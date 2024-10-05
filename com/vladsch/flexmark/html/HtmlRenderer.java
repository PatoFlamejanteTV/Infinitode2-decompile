/*     */ package com.vladsch.flexmark.html;
/*     */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*     */ import com.vladsch.flexmark.html.renderer.CoreNodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.HeaderIdGeneratorFactory;
/*     */ import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
/*     */ import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
/*     */ import com.vladsch.flexmark.html.renderer.LinkResolverContext;
/*     */ import com.vladsch.flexmark.html.renderer.LinkType;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*     */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*     */ import com.vladsch.flexmark.html.renderer.PhasedNodeRenderer;
/*     */ import com.vladsch.flexmark.html.renderer.RenderingPhase;
/*     */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.data.DataKey;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*     */ import com.vladsch.flexmark.util.data.SharedDataKeys;
/*     */ import com.vladsch.flexmark.util.dependency.DependencyResolver;
/*     */ import com.vladsch.flexmark.util.html.Attributes;
/*     */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*     */ import com.vladsch.flexmark.util.misc.Extension;
/*     */ import com.vladsch.flexmark.util.misc.Pair;
/*     */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class HtmlRenderer implements IRender {
/*  37 */   public static final DataKey<String> SOFT_BREAK = new DataKey("SOFT_BREAK", "\n");
/*  38 */   public static final DataKey<String> HARD_BREAK = new DataKey("HARD_BREAK", "<br />\n");
/*  39 */   public static final NullableDataKey<String> STRONG_EMPHASIS_STYLE_HTML_OPEN = new NullableDataKey("STRONG_EMPHASIS_STYLE_HTML_OPEN");
/*  40 */   public static final NullableDataKey<String> STRONG_EMPHASIS_STYLE_HTML_CLOSE = new NullableDataKey("STRONG_EMPHASIS_STYLE_HTML_CLOSE");
/*  41 */   public static final NullableDataKey<String> EMPHASIS_STYLE_HTML_OPEN = new NullableDataKey("EMPHASIS_STYLE_HTML_OPEN");
/*  42 */   public static final NullableDataKey<String> EMPHASIS_STYLE_HTML_CLOSE = new NullableDataKey("EMPHASIS_STYLE_HTML_CLOSE");
/*  43 */   public static final NullableDataKey<String> CODE_STYLE_HTML_OPEN = new NullableDataKey("CODE_STYLE_HTML_OPEN");
/*  44 */   public static final NullableDataKey<String> CODE_STYLE_HTML_CLOSE = new NullableDataKey("CODE_STYLE_HTML_CLOSE");
/*  45 */   public static final NullableDataKey<String> INLINE_CODE_SPLICE_CLASS = new NullableDataKey("INLINE_CODE_SPLICE_CLASS");
/*  46 */   public static final DataKey<Boolean> PERCENT_ENCODE_URLS = SharedDataKeys.PERCENT_ENCODE_URLS;
/*  47 */   public static final DataKey<Integer> INDENT_SIZE = SharedDataKeys.INDENT_SIZE;
/*  48 */   public static final DataKey<Boolean> ESCAPE_HTML = new DataKey("ESCAPE_HTML", Boolean.FALSE);
/*  49 */   public static final DataKey<Boolean> ESCAPE_HTML_BLOCKS = new DataKey("ESCAPE_HTML_BLOCKS", ESCAPE_HTML);
/*  50 */   public static final DataKey<Boolean> ESCAPE_HTML_COMMENT_BLOCKS = new DataKey("ESCAPE_HTML_COMMENT_BLOCKS", ESCAPE_HTML_BLOCKS);
/*  51 */   public static final DataKey<Boolean> ESCAPE_INLINE_HTML = new DataKey("ESCAPE_HTML_BLOCKS", ESCAPE_HTML);
/*  52 */   public static final DataKey<Boolean> ESCAPE_INLINE_HTML_COMMENTS = new DataKey("ESCAPE_INLINE_HTML_COMMENTS", ESCAPE_INLINE_HTML);
/*  53 */   public static final DataKey<Boolean> SUPPRESS_HTML = new DataKey("SUPPRESS_HTML", Boolean.FALSE);
/*  54 */   public static final DataKey<Boolean> SUPPRESS_HTML_BLOCKS = new DataKey("SUPPRESS_HTML_BLOCKS", SUPPRESS_HTML);
/*  55 */   public static final DataKey<Boolean> SUPPRESS_HTML_COMMENT_BLOCKS = new DataKey("SUPPRESS_HTML_COMMENT_BLOCKS", SUPPRESS_HTML_BLOCKS);
/*  56 */   public static final DataKey<Boolean> SUPPRESS_INLINE_HTML = new DataKey("SUPPRESS_INLINE_HTML", SUPPRESS_HTML);
/*  57 */   public static final DataKey<Boolean> SUPPRESS_INLINE_HTML_COMMENTS = new DataKey("SUPPRESS_INLINE_HTML_COMMENTS", SUPPRESS_INLINE_HTML);
/*  58 */   public static final DataKey<Boolean> SOURCE_WRAP_HTML = new DataKey("SOURCE_WRAP_HTML", Boolean.FALSE);
/*  59 */   public static final DataKey<Boolean> SOURCE_WRAP_HTML_BLOCKS = new DataKey("SOURCE_WRAP_HTML_BLOCKS", SOURCE_WRAP_HTML);
/*  60 */   public static final DataKey<Boolean> HEADER_ID_GENERATOR_RESOLVE_DUPES = SharedDataKeys.HEADER_ID_GENERATOR_RESOLVE_DUPES;
/*  61 */   public static final DataKey<String> HEADER_ID_GENERATOR_TO_DASH_CHARS = SharedDataKeys.HEADER_ID_GENERATOR_TO_DASH_CHARS;
/*  62 */   public static final DataKey<String> HEADER_ID_GENERATOR_NON_DASH_CHARS = SharedDataKeys.HEADER_ID_GENERATOR_NON_DASH_CHARS;
/*  63 */   public static final DataKey<Boolean> HEADER_ID_GENERATOR_NO_DUPED_DASHES = SharedDataKeys.HEADER_ID_GENERATOR_NO_DUPED_DASHES;
/*  64 */   public static final DataKey<Boolean> HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE = SharedDataKeys.HEADER_ID_GENERATOR_NON_ASCII_TO_LOWERCASE;
/*  65 */   public static final DataKey<Boolean> HEADER_ID_REF_TEXT_TRIM_LEADING_SPACES = SharedDataKeys.HEADER_ID_REF_TEXT_TRIM_LEADING_SPACES;
/*  66 */   public static final DataKey<Boolean> HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES = SharedDataKeys.HEADER_ID_REF_TEXT_TRIM_TRAILING_SPACES;
/*  67 */   public static final DataKey<Boolean> HEADER_ID_ADD_EMOJI_SHORTCUT = SharedDataKeys.HEADER_ID_ADD_EMOJI_SHORTCUT;
/*  68 */   public static final DataKey<Boolean> RENDER_HEADER_ID = SharedDataKeys.RENDER_HEADER_ID;
/*  69 */   public static final DataKey<Boolean> GENERATE_HEADER_ID = SharedDataKeys.GENERATE_HEADER_ID;
/*  70 */   public static final DataKey<Boolean> DO_NOT_RENDER_LINKS = SharedDataKeys.DO_NOT_RENDER_LINKS;
/*  71 */   public static final DataKey<String> FENCED_CODE_LANGUAGE_CLASS_PREFIX = new DataKey("FENCED_CODE_LANGUAGE_CLASS_PREFIX", "language-");
/*  72 */   public static final DataKey<HashMap<String, String>> FENCED_CODE_LANGUAGE_CLASS_MAP = new DataKey("FENCED_CODE_LANGUAGE_CLASS_MAP", HashMap::new);
/*  73 */   public static final DataKey<String> FENCED_CODE_NO_LANGUAGE_CLASS = new DataKey("FENCED_CODE_NO_LANGUAGE_CLASS", "");
/*  74 */   public static final DataKey<String> FENCED_CODE_LANGUAGE_DELIMITERS = new DataKey("FENCED_CODE_LANGUAGE_DELIMITERS", " \t");
/*  75 */   public static final DataKey<String> SOURCE_POSITION_ATTRIBUTE = new DataKey("SOURCE_POSITION_ATTRIBUTE", "");
/*  76 */   public static final DataKey<Boolean> SOURCE_POSITION_PARAGRAPH_LINES = new DataKey("SOURCE_POSITION_PARAGRAPH_LINES", Boolean.FALSE);
/*  77 */   public static final DataKey<String> TYPE = new DataKey("TYPE", "HTML");
/*  78 */   public static final DataKey<ArrayList<TagRange>> TAG_RANGES = new DataKey("TAG_RANGES", ArrayList::new);
/*     */   
/*  80 */   public static final DataKey<Boolean> RECHECK_UNDEFINED_REFERENCES = new DataKey("RECHECK_UNDEFINED_REFERENCES", Boolean.FALSE);
/*  81 */   public static final DataKey<Boolean> OBFUSCATE_EMAIL = new DataKey("OBFUSCATE_EMAIL", Boolean.FALSE);
/*  82 */   public static final DataKey<Boolean> OBFUSCATE_EMAIL_RANDOM = new DataKey("OBFUSCATE_EMAIL_RANDOM", Boolean.TRUE);
/*  83 */   public static final DataKey<Boolean> HTML_BLOCK_OPEN_TAG_EOL = new DataKey("HTML_BLOCK_OPEN_TAG_EOL", Boolean.TRUE);
/*  84 */   public static final DataKey<Boolean> HTML_BLOCK_CLOSE_TAG_EOL = new DataKey("HTML_BLOCK_CLOSE_TAG_EOL", Boolean.TRUE);
/*  85 */   public static final DataKey<Boolean> UNESCAPE_HTML_ENTITIES = new DataKey("UNESCAPE_HTML_ENTITIES", Boolean.TRUE);
/*  86 */   public static final DataKey<String> AUTOLINK_WWW_PREFIX = new DataKey("AUTOLINK_WWW_PREFIX", "http://");
/*     */ 
/*     */   
/*  89 */   public static final DataKey<String> SUPPRESSED_LINKS = new DataKey("SUPPRESSED_LINKS", "javascript:.*");
/*  90 */   public static final DataKey<Boolean> NO_P_TAGS_USE_BR = new DataKey("NO_P_TAGS_USE_BR", Boolean.FALSE);
/*  91 */   public static final DataKey<Boolean> EMBEDDED_ATTRIBUTE_PROVIDER = new DataKey("EMBEDDED_ATTRIBUTE_PROVIDER", Boolean.TRUE);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   public static final DataKey<Integer> FORMAT_FLAGS = new DataKey("RENDERER_FORMAT_FLAGS", Integer.valueOf(LineAppendable.F_TRIM_LEADING_WHITESPACE));
/*  97 */   public static final DataKey<Integer> MAX_TRAILING_BLANK_LINES = SharedDataKeys.RENDERER_MAX_TRAILING_BLANK_LINES;
/*  98 */   public static final DataKey<Integer> MAX_BLANK_LINES = SharedDataKeys.RENDERER_MAX_BLANK_LINES;
/*     */ 
/*     */   
/*     */   @Deprecated
/* 102 */   public static final int CONVERT_TABS = LineAppendable.F_CONVERT_TABS; @Deprecated
/* 103 */   public static final int COLLAPSE_WHITESPACE = LineAppendable.F_COLLAPSE_WHITESPACE; @Deprecated
/* 104 */   public static final int SUPPRESS_TRAILING_WHITESPACE = LineAppendable.F_TRIM_TRAILING_WHITESPACE; @Deprecated
/* 105 */   public static final int PASS_THROUGH = LineAppendable.F_PASS_THROUGH;
/*     */   @Deprecated
/* 107 */   public static final int FORMAT_ALL = LineAppendable.F_FORMAT_ALL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   public static final DataKey<List<Pair<String, String>>> RENDERER_TYPE_EQUIVALENCE = new DataKey("RENDERER_TYPE_EQUIVALENCE", Collections.emptyList());
/*     */   
/*     */   @Deprecated
/* 117 */   public static final int FORMAT_CONVERT_TABS = LineAppendable.F_CONVERT_TABS; @Deprecated
/* 118 */   public static final int FORMAT_COLLAPSE_WHITESPACE = LineAppendable.F_COLLAPSE_WHITESPACE; @Deprecated
/* 119 */   public static final int FORMAT_SUPPRESS_TRAILING_WHITESPACE = LineAppendable.F_TRIM_TRAILING_WHITESPACE; @Deprecated
/* 120 */   public static final int FORMAT_ALL_OPTIONS = LineAppendable.F_FORMAT_ALL;
/*     */ 
/*     */   
/* 123 */   public static final DataKey<List<TrackedOffset>> TRACKED_OFFSETS = new DataKey("TRACKED_OFFSETS", Collections.emptyList());
/*     */   
/*     */   final List<AttributeProviderFactory> attributeProviderFactories;
/*     */   
/*     */   final List<DelegatingNodeRendererFactoryWrapper> nodeRendererFactories;
/*     */   final List<LinkResolverFactory> linkResolverFactories;
/*     */   final HeaderIdGeneratorFactory htmlIdGeneratorFactory;
/*     */   final HtmlRendererOptions htmlOptions;
/*     */   final DataHolder options;
/*     */   
/*     */   HtmlRenderer(Builder paramBuilder) {
/* 134 */     this.options = (DataHolder)paramBuilder.toImmutable();
/* 135 */     this.htmlOptions = new HtmlRendererOptions(this.options);
/*     */     
/* 137 */     this.htmlIdGeneratorFactory = paramBuilder.htmlIdGeneratorFactory;
/*     */ 
/*     */     
/* 140 */     ArrayList<DelegatingNodeRendererFactoryWrapper> arrayList = new ArrayList(paramBuilder.nodeRendererFactories.size());
/*     */     
/* 142 */     for (int i = paramBuilder.nodeRendererFactories.size() - 1; i >= 0; i--) {
/* 143 */       NodeRendererFactory nodeRendererFactory = paramBuilder.nodeRendererFactories.get(i);
/* 144 */       arrayList.add(new DelegatingNodeRendererFactoryWrapper(arrayList, nodeRendererFactory));
/*     */     } 
/*     */ 
/*     */     
/* 148 */     CoreNodeRenderer.Factory factory = new CoreNodeRenderer.Factory();
/* 149 */     arrayList.add(new DelegatingNodeRendererFactoryWrapper(arrayList, (NodeRendererFactory)factory));
/*     */     
/* 151 */     this.nodeRendererFactories = DependencyResolver.resolveFlatDependencies(arrayList, null, paramDelegatingNodeRendererFactoryWrapper -> paramDelegatingNodeRendererFactoryWrapper.getFactory().getClass());
/*     */ 
/*     */     
/* 154 */     boolean bool = !paramBuilder.attributeProviderFactories.containsKey(EmbeddedAttributeProvider.Factory.getClass()) ? true : false;
/* 155 */     arrayList = new ArrayList<>((Collection)paramBuilder.attributeProviderFactories.values());
/* 156 */     if (bool && ((Boolean)EMBEDDED_ATTRIBUTE_PROVIDER.get(this.options)).booleanValue())
/*     */     {
/* 158 */       arrayList.add(0, EmbeddedAttributeProvider.Factory);
/*     */     }
/*     */     
/* 161 */     this.attributeProviderFactories = DependencyResolver.resolveFlatDependencies(arrayList, null, null);
/* 162 */     this.linkResolverFactories = DependencyResolver.resolveFlatDependencies(paramBuilder.linkResolverFactories, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Builder builder() {
/* 171 */     return new Builder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Builder builder(DataHolder paramDataHolder) {
/* 181 */     return new Builder(paramDataHolder);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DataHolder getOptions() {
/* 187 */     return this.options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Node paramNode, Appendable paramAppendable) {
/* 197 */     render(paramNode, paramAppendable, this.htmlOptions.maxTrailingBlankLines);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Node paramNode, Appendable paramAppendable, int paramInt) {
/* 207 */     HtmlWriter htmlWriter = new HtmlWriter(paramAppendable, this.htmlOptions.indentSize, this.htmlOptions.formatFlags, !this.htmlOptions.htmlBlockOpenTagEol, !this.htmlOptions.htmlBlockCloseTagEol);
/*     */     MainNodeRenderer mainNodeRenderer;
/* 209 */     if ((mainNodeRenderer = new MainNodeRenderer(this.options, htmlWriter, paramNode.getDocument())).htmlIdGenerator != HtmlIdGenerator.NULL && !(paramNode instanceof Document)) {
/* 210 */       mainNodeRenderer.htmlIdGenerator.generateIds(paramNode.getDocument());
/*     */     }
/*     */     
/* 213 */     mainNodeRenderer.render(paramNode);
/* 214 */     htmlWriter.appendToSilently(paramAppendable, this.htmlOptions.maxBlankLines, paramInt);
/*     */ 
/*     */     
/* 217 */     TrackedOffsetUtils.resolveTrackedOffsets(paramNode.getChars(), (LineAppendable)htmlWriter, (List)TRACKED_OFFSETS.get((DataHolder)mainNodeRenderer.getDocument()), paramInt, ((Boolean)SharedDataKeys.RUNNING_TESTS.get(this.options)).booleanValue());
/* 218 */     mainNodeRenderer.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String render(Node paramNode) {
/* 229 */     StringBuilder stringBuilder = new StringBuilder();
/* 230 */     render(paramNode, stringBuilder);
/* 231 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static boolean isCompatibleRendererType(MutableDataHolder paramMutableDataHolder, String paramString) {
/* 235 */     String str = (String)TYPE.get((DataHolder)paramMutableDataHolder);
/* 236 */     return isCompatibleRendererType(paramMutableDataHolder, str, paramString);
/*     */   }
/*     */   
/*     */   public static boolean isCompatibleRendererType(MutableDataHolder paramMutableDataHolder, String paramString1, String paramString2) {
/* 240 */     if (paramString1.equals(paramString2)) {
/* 241 */       return true;
/*     */     }
/*     */     
/*     */     List<?> list;
/*     */     
/* 246 */     for (Pair pair : list = (List)RENDERER_TYPE_EQUIVALENCE.get((DataHolder)paramMutableDataHolder)) {
/* 247 */       if (paramString1.equals(pair.getFirst()) && 
/* 248 */         paramString2.equals(pair.getSecond())) {
/* 249 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 253 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static MutableDataHolder addRenderTypeEquivalence(MutableDataHolder paramMutableDataHolder, String paramString1, String paramString2) {
/* 258 */     if (!isCompatibleRendererType(paramMutableDataHolder, paramString1, paramString2)) {
/*     */       
/* 260 */       List<?> list = (List)RENDERER_TYPE_EQUIVALENCE.get((DataHolder)paramMutableDataHolder);
/*     */       
/* 262 */       (list = new ArrayList(list)).add(new Pair(paramString1, paramString2));
/* 263 */       paramMutableDataHolder.set(RENDERER_TYPE_EQUIVALENCE, list);
/*     */     } 
/* 265 */     return paramMutableDataHolder;
/*     */   }
/*     */   
/*     */   public static class Builder
/*     */     extends BuilderBase<Builder>
/*     */     implements RendererBuilder
/*     */   {
/* 272 */     Map<Class<?>, AttributeProviderFactory> attributeProviderFactories = new LinkedHashMap<>();
/* 273 */     List<NodeRendererFactory> nodeRendererFactories = new ArrayList<>();
/* 274 */     List<LinkResolverFactory> linkResolverFactories = new ArrayList<>();
/* 275 */     HeaderIdGeneratorFactory htmlIdGeneratorFactory = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder(DataHolder param1DataHolder) {
/* 282 */       super(param1DataHolder);
/* 283 */       loadExtensions();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void removeApiPoint(Object param1Object) {
/* 288 */       if (param1Object instanceof AttributeProviderFactory) { this.attributeProviderFactories.remove(param1Object.getClass()); return; }
/* 289 */        if (param1Object instanceof NodeRendererFactory) { this.nodeRendererFactories.remove(param1Object); return; }
/* 290 */        if (param1Object instanceof LinkResolverFactory) { this.linkResolverFactories.remove(param1Object); return; }
/* 291 */        if (param1Object instanceof HeaderIdGeneratorFactory) { this.htmlIdGeneratorFactory = null; return; }
/*     */       
/* 293 */       throw new IllegalStateException("Unknown data point type: " + param1Object.getClass().getName());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void preloadExtension(Extension param1Extension) {
/* 299 */       if (param1Extension instanceof HtmlRenderer.HtmlRendererExtension) {
/*     */         
/* 301 */         (param1Extension = param1Extension).rendererOptions((MutableDataHolder)this); return;
/* 302 */       }  if (param1Extension instanceof RendererExtension)
/*     */       {
/* 304 */         (param1Extension = param1Extension).rendererOptions((MutableDataHolder)this);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean loadExtension(Extension param1Extension) {
/* 310 */       if (param1Extension instanceof HtmlRenderer.HtmlRendererExtension) {
/*     */         
/* 312 */         (param1Extension = param1Extension).extend(this, (String)HtmlRenderer.TYPE.get(this));
/* 313 */         return true;
/* 314 */       }  if (param1Extension instanceof RendererExtension) {
/*     */         
/* 316 */         (param1Extension = param1Extension).extend(this, (String)HtmlRenderer.TYPE.get(this));
/* 317 */         return true;
/*     */       } 
/* 319 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public HtmlRenderer build() {
/* 327 */       return new HtmlRenderer(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder softBreak(String param1String) {
/* 342 */       set(HtmlRenderer.SOFT_BREAK, param1String);
/* 343 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder indentSize(int param1Int) {
/* 353 */       set(HtmlRenderer.INDENT_SIZE, Integer.valueOf(param1Int));
/* 354 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder escapeHtml(boolean param1Boolean) {
/* 367 */       set(HtmlRenderer.ESCAPE_HTML, Boolean.valueOf(param1Boolean));
/* 368 */       return this;
/*     */     }
/*     */     
/*     */     public boolean isRendererType(String param1String) {
/* 372 */       String str = (String)HtmlRenderer.TYPE.get(this);
/* 373 */       return HtmlRenderer.isCompatibleRendererType((MutableDataHolder)this, str, param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder percentEncodeUrls(boolean param1Boolean) {
/* 391 */       set(HtmlRenderer.PERCENT_ENCODE_URLS, Boolean.valueOf(param1Boolean));
/* 392 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder attributeProviderFactory(AttributeProviderFactory param1AttributeProviderFactory) {
/* 402 */       this.attributeProviderFactories.put(param1AttributeProviderFactory.getClass(), param1AttributeProviderFactory);
/* 403 */       addExtensionApiPoint(param1AttributeProviderFactory);
/* 404 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder nodeRendererFactory(NodeRendererFactory param1NodeRendererFactory) {
/* 418 */       this.nodeRendererFactories.add(param1NodeRendererFactory);
/* 419 */       addExtensionApiPoint(param1NodeRendererFactory);
/* 420 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder linkResolverFactory(LinkResolverFactory param1LinkResolverFactory) {
/* 434 */       this.linkResolverFactories.add(param1LinkResolverFactory);
/* 435 */       addExtensionApiPoint(param1LinkResolverFactory);
/* 436 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder contentResolverFactory(UriContentResolverFactory param1UriContentResolverFactory) {
/* 447 */       throw new IllegalStateException("Not implemented");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder htmlIdGeneratorFactory(HeaderIdGeneratorFactory param1HeaderIdGeneratorFactory) {
/* 459 */       if (this.htmlIdGeneratorFactory != null) {
/* 460 */         throw new IllegalStateException("custom header id factory is already set to " + param1HeaderIdGeneratorFactory.getClass().getName());
/*     */       }
/* 462 */       this.htmlIdGeneratorFactory = param1HeaderIdGeneratorFactory;
/* 463 */       addExtensionApiPoint(param1HeaderIdGeneratorFactory);
/* 464 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface HtmlRendererExtension
/*     */     extends Extension
/*     */   {
/*     */     void rendererOptions(MutableDataHolder param1MutableDataHolder);
/*     */ 
/*     */ 
/*     */     
/*     */     void extend(HtmlRenderer.Builder param1Builder, String param1String);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class MainNodeRenderer
/*     */     extends NodeRendererSubContext
/*     */     implements Disposable, NodeRendererContext
/*     */   {
/*     */     private Document document;
/*     */ 
/*     */     
/*     */     private Map<Class<?>, NodeRenderingHandlerWrapper> renderers;
/*     */     
/*     */     private List<PhasedNodeRenderer> phasedRenderers;
/*     */     
/*     */     private LinkResolver[] myLinkResolvers;
/*     */     
/*     */     private Set<RenderingPhase> renderingPhases;
/*     */     
/*     */     private DataHolder options;
/*     */     
/*     */     private RenderingPhase phase;
/*     */     
/*     */     HtmlIdGenerator htmlIdGenerator;
/*     */     
/* 507 */     private HashMap<LinkType, HashMap<String, ResolvedLink>> resolvedLinkMap = new HashMap<>();
/*     */     
/*     */     private AttributeProvider[] attributeProviders;
/*     */     
/*     */     public void dispose() {
/* 512 */       this.document = null;
/* 513 */       this.renderers = null;
/* 514 */       this.phasedRenderers = null; LinkResolver[] arrayOfLinkResolver; int i;
/*     */       byte b;
/* 516 */       for (i = (arrayOfLinkResolver = this.myLinkResolvers).length, b = 0; b < i; b++) {
/* 517 */         LinkResolver linkResolver; if (linkResolver = arrayOfLinkResolver[b] instanceof Disposable) ((Disposable)linkResolver).dispose(); 
/*     */       } 
/* 519 */       this.myLinkResolvers = null;
/*     */       
/* 521 */       this.renderingPhases = null;
/* 522 */       this.options = null;
/*     */       
/* 524 */       if (this.htmlIdGenerator instanceof Disposable) ((Disposable)this.htmlIdGenerator).dispose(); 
/* 525 */       this.htmlIdGenerator = null;
/* 526 */       this.resolvedLinkMap = null;
/*     */       AttributeProvider[] arrayOfAttributeProvider;
/* 528 */       for (i = (arrayOfAttributeProvider = this.attributeProviders).length, b = 0; b < i; b++) {
/* 529 */         AttributeProvider attributeProvider; if (attributeProvider = arrayOfAttributeProvider[b] instanceof Disposable) ((Disposable)attributeProvider).dispose(); 
/*     */       } 
/* 531 */       this.attributeProviders = null;
/*     */     }
/*     */     
/*     */     MainNodeRenderer(DataHolder param1DataHolder, HtmlWriter param1HtmlWriter, Document param1Document) {
/* 535 */       super(param1HtmlWriter);
/* 536 */       this.options = (DataHolder)new ScopedDataSet((DataHolder)param1Document, param1DataHolder);
/* 537 */       this.document = param1Document;
/* 538 */       this.renderers = new HashMap<>(32);
/* 539 */       this.renderingPhases = new HashSet<>((RenderingPhase.values()).length);
/* 540 */       this.phasedRenderers = new ArrayList<>(HtmlRenderer.this.nodeRendererFactories.size());
/* 541 */       this.myLinkResolvers = new LinkResolver[HtmlRenderer.this.linkResolverFactories.size()];
/* 542 */       this.doNotRenderLinksNesting = HtmlRenderer.this.htmlOptions.doNotRenderLinksInDocument ? 0 : 1;
/* 543 */       this
/* 544 */         .htmlIdGenerator = (HtmlRenderer.this.htmlIdGeneratorFactory != null) ? HtmlRenderer.this.htmlIdGeneratorFactory.create((LinkResolverContext)this) : ((!HtmlRenderer.this.htmlOptions.renderHeaderId && !HtmlRenderer.this.htmlOptions.generateHeaderIds) ? HtmlIdGenerator.NULL : (HtmlIdGenerator)(new HeaderIdGenerator.Factory()).create((LinkResolverContext)this));
/*     */       
/* 546 */       param1HtmlWriter.setContext(this);
/*     */       int i;
/* 548 */       for (i = HtmlRenderer.this.nodeRendererFactories.size() - 1; i >= 0; i--) {
/*     */         NodeRenderer nodeRenderer;
/*     */         NodeRendererFactory nodeRendererFactory;
/* 551 */         Set<? extends RenderingPhase> set = (nodeRenderer = (nodeRendererFactory = (NodeRendererFactory)HtmlRenderer.this.nodeRendererFactories.get(i)).apply(getOptions())).getNodeRenderingHandlers();
/*     */         
/* 553 */         assert set != null;
/* 554 */         for (NodeRenderingHandler<?> nodeRenderingHandler : (Iterable<NodeRenderingHandler<?>>)set) {
/*     */           
/* 556 */           NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper = new NodeRenderingHandlerWrapper(nodeRenderingHandler, this.renderers.get(nodeRenderingHandler.getNodeType()));
/* 557 */           this.renderers.put(nodeRenderingHandler.getNodeType(), nodeRenderingHandlerWrapper);
/*     */         } 
/*     */         
/* 560 */         if (nodeRenderer instanceof PhasedNodeRenderer) {
/* 561 */           set = ((PhasedNodeRenderer)nodeRenderer).getRenderingPhases();
/* 562 */           assert set != null;
/*     */           
/* 564 */           this.renderingPhases.addAll(set);
/* 565 */           this.phasedRenderers.add((PhasedNodeRenderer)nodeRenderer);
/*     */         } 
/*     */       } 
/*     */       
/* 569 */       for (i = 0; i < HtmlRenderer.this.linkResolverFactories.size(); i++) {
/* 570 */         this.myLinkResolvers[i] = ((LinkResolverFactory)HtmlRenderer.this.linkResolverFactories.get(i)).apply((LinkResolverBasicContext)this);
/*     */       }
/*     */       
/* 573 */       this.attributeProviders = new AttributeProvider[HtmlRenderer.this.attributeProviderFactories.size()];
/* 574 */       for (i = 0; i < HtmlRenderer.this.attributeProviderFactories.size(); i++) {
/* 575 */         this.attributeProviders[i] = ((AttributeProviderFactory)HtmlRenderer.this.attributeProviderFactories.get(i)).apply((LinkResolverContext)this);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Node getCurrentNode() {
/* 582 */       return this.renderingNode;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ResolvedLink resolveLink(LinkType param1LinkType, CharSequence param1CharSequence, Attributes param1Attributes, Boolean param1Boolean) {
/* 588 */       HashMap<CharSequence, ResolvedLink> hashMap = (HashMap)this.resolvedLinkMap.computeIfAbsent(param1LinkType, param1LinkType -> new HashMap<>());
/*     */       
/* 590 */       param1CharSequence = String.valueOf(param1CharSequence);
/*     */       ResolvedLink resolvedLink;
/* 592 */       if ((resolvedLink = (ResolvedLink)hashMap.get(param1CharSequence)) == null) {
/* 593 */         resolvedLink = new ResolvedLink(param1LinkType, param1CharSequence, param1Attributes);
/*     */         
/* 595 */         if (!param1CharSequence.isEmpty()) {
/* 596 */           Node node = getCurrentNode(); LinkResolver[] arrayOfLinkResolver; int i; byte b;
/*     */           LinkResolver linkResolver;
/* 598 */           for (i = (arrayOfLinkResolver = this.myLinkResolvers).length, b = 0; b < i && (
/*     */             
/* 600 */             resolvedLink = (linkResolver = arrayOfLinkResolver[b]).resolveLink(node, (LinkResolverBasicContext)this, resolvedLink)).getStatus() == LinkStatus.UNKNOWN; b++);
/*     */ 
/*     */           
/* 603 */           if ((param1Boolean == null && HtmlRenderer.this.htmlOptions.percentEncodeUrls) || (param1Boolean != null && param1Boolean.booleanValue())) {
/* 604 */             resolvedLink = resolvedLink.withUrl(Escaping.percentEncodeUrl(resolvedLink.getUrl()));
/*     */           }
/*     */         } 
/*     */         
/* 608 */         hashMap.put(param1CharSequence, resolvedLink);
/*     */       } 
/*     */       
/* 611 */       return resolvedLink;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getNodeId(Node param1Node) {
/* 616 */       String str = this.htmlIdGenerator.getId(param1Node);
/* 617 */       if (HtmlRenderer.this.attributeProviderFactories.size() != 0) {
/* 618 */         MutableAttributes mutableAttributes = new MutableAttributes();
/* 619 */         if (str != null) mutableAttributes.replaceValue("id", str);  AttributeProvider[] arrayOfAttributeProvider; int i;
/*     */         byte b;
/* 621 */         for (i = (arrayOfAttributeProvider = this.attributeProviders).length, b = 0; b < i; b++) {
/* 622 */           AttributeProvider attributeProvider; (attributeProvider = arrayOfAttributeProvider[b]).setAttributes(this.renderingNode, AttributablePart.ID, mutableAttributes);
/*     */         } 
/* 624 */         str = mutableAttributes.getValue("id");
/*     */       } 
/* 626 */       return str;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public DataHolder getOptions() {
/* 632 */       return this.options;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public HtmlRendererOptions getHtmlOptions() {
/* 638 */       return HtmlRenderer.this.htmlOptions;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Document getDocument() {
/* 644 */       return this.document;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public RenderingPhase getRenderingPhase() {
/* 650 */       return this.phase;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String encodeUrl(CharSequence param1CharSequence) {
/* 656 */       if (HtmlRenderer.this.htmlOptions.percentEncodeUrls) {
/* 657 */         return Escaping.percentEncodeUrl(param1CharSequence);
/*     */       }
/* 659 */       return String.valueOf(param1CharSequence);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public MutableAttributes extendRenderingNodeAttributes(AttributablePart param1AttributablePart, Attributes param1Attributes) {
/* 665 */       MutableAttributes mutableAttributes = (param1Attributes != null) ? param1Attributes.toMutable() : new MutableAttributes(); AttributeProvider[] arrayOfAttributeProvider; int i; byte b;
/* 666 */       for (i = (arrayOfAttributeProvider = this.attributeProviders).length, b = 0; b < i; b++) {
/* 667 */         AttributeProvider attributeProvider; (attributeProvider = arrayOfAttributeProvider[b]).setAttributes(this.renderingNode, param1AttributablePart, mutableAttributes);
/*     */       } 
/* 669 */       return mutableAttributes;
/*     */     }
/*     */ 
/*     */     
/*     */     public MutableAttributes extendRenderingNodeAttributes(Node param1Node, AttributablePart param1AttributablePart, Attributes param1Attributes) {
/* 674 */       MutableAttributes mutableAttributes = (param1Attributes != null) ? param1Attributes.toMutable() : new MutableAttributes(); AttributeProvider[] arrayOfAttributeProvider; int i; byte b;
/* 675 */       for (i = (arrayOfAttributeProvider = this.attributeProviders).length, b = 0; b < i; b++) {
/* 676 */         AttributeProvider attributeProvider; (attributeProvider = arrayOfAttributeProvider[b]).setAttributes(param1Node, param1AttributablePart, mutableAttributes);
/*     */       } 
/* 678 */       return mutableAttributes;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(Node param1Node) {
/* 683 */       renderNode(param1Node, this);
/*     */     }
/*     */ 
/*     */     
/*     */     public void delegateRender() {
/* 688 */       renderByPreviousHandler(this);
/*     */     }
/*     */     
/*     */     void renderByPreviousHandler(NodeRendererSubContext param1NodeRendererSubContext) {
/* 692 */       if (param1NodeRendererSubContext.renderingNode != null)
/*     */       { NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper;
/* 694 */         if ((nodeRenderingHandlerWrapper = param1NodeRendererSubContext.renderingHandlerWrapper.myPreviousRenderingHandler) != null)
/* 695 */         { Node node = param1NodeRendererSubContext.renderingNode;
/* 696 */           int i = param1NodeRendererSubContext.doNotRenderLinksNesting;
/* 697 */           NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper1 = param1NodeRendererSubContext.renderingHandlerWrapper;
/*     */           try {
/* 699 */             param1NodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper;
/* 700 */             nodeRenderingHandlerWrapper.myRenderingHandler.render(node, param1NodeRendererSubContext, param1NodeRendererSubContext.htmlWriter);
/*     */           } finally {
/* 702 */             param1NodeRendererSubContext.renderingNode = node;
/* 703 */             param1NodeRendererSubContext.doNotRenderLinksNesting = i;
/* 704 */             param1NodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper1;
/*     */           }  }
/*     */         else { return; }
/*     */          }
/* 708 */       else { throw new IllegalStateException("renderingByPreviousHandler called outside node rendering code"); }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public NodeRendererContext getSubContext(boolean param1Boolean) {
/*     */       HtmlWriter htmlWriter;
/* 716 */       (htmlWriter = new HtmlWriter(getHtmlWriter(), param1Boolean)).setContext(this);
/*     */       
/* 718 */       return new SubNodeRenderer(this, htmlWriter, false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public NodeRendererContext getDelegatedSubContext(boolean param1Boolean) {
/*     */       HtmlWriter htmlWriter;
/* 725 */       (htmlWriter = new HtmlWriter(getHtmlWriter(), param1Boolean)).setContext(this);
/*     */       
/* 727 */       return new SubNodeRenderer(this, htmlWriter, true);
/*     */     }
/*     */     
/*     */     void renderNode(Node param1Node, NodeRendererSubContext param1NodeRendererSubContext) {
/* 731 */       if (param1Node instanceof Document) {
/*     */         
/* 733 */         int i = param1NodeRendererSubContext.getDoNotRenderLinksNesting();
/* 734 */         boolean bool = (getHtmlOptions()).doNotRenderLinksInDocument ? true : false;
/* 735 */         this.htmlIdGenerator.generateIds(this.document); RenderingPhase[] arrayOfRenderingPhase; int j;
/*     */         byte b;
/* 737 */         for (j = (arrayOfRenderingPhase = RenderingPhase.values()).length, b = 0; b < j; ) {
/* 738 */           RenderingPhase renderingPhase; if ((renderingPhase = arrayOfRenderingPhase[b]) == RenderingPhase.BODY || this.renderingPhases.contains(renderingPhase)) {
/* 739 */             this.phase = renderingPhase;
/*     */ 
/*     */ 
/*     */             
/* 743 */             for (Iterator<PhasedNodeRenderer> iterator = this.phasedRenderers.iterator(); iterator.hasNext();) {
/* 744 */               if (((Set)Objects.<Set>requireNonNull((phasedNodeRenderer = iterator.next()).getRenderingPhases())).contains(renderingPhase)) {
/* 745 */                 param1NodeRendererSubContext.doNotRenderLinksNesting = bool;
/* 746 */                 param1NodeRendererSubContext.renderingNode = param1Node;
/* 747 */                 phasedNodeRenderer.renderDocument(param1NodeRendererSubContext, param1NodeRendererSubContext.htmlWriter, (Document)param1Node, renderingPhase);
/* 748 */                 param1NodeRendererSubContext.renderingNode = null;
/* 749 */                 param1NodeRendererSubContext.doNotRenderLinksNesting = i;
/*     */               } 
/*     */             } 
/*     */             NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper1;
/* 753 */             if (getRenderingPhase() == RenderingPhase.BODY && (
/*     */               
/* 755 */               nodeRenderingHandlerWrapper1 = this.renderers.get(param1Node.getClass())) != null) {
/* 756 */               param1NodeRendererSubContext.doNotRenderLinksNesting = bool;
/* 757 */               NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper2 = param1NodeRendererSubContext.renderingHandlerWrapper;
/*     */               
/* 759 */               try { param1NodeRendererSubContext.renderingNode = param1Node;
/* 760 */                 param1NodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper1;
/* 761 */                 nodeRenderingHandlerWrapper1.myRenderingHandler.render(param1Node, param1NodeRendererSubContext, param1NodeRendererSubContext.htmlWriter);
/*     */                 
/* 763 */                 param1NodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper2;
/* 764 */                 param1NodeRendererSubContext.renderingNode = null;
/* 765 */                 param1NodeRendererSubContext.doNotRenderLinksNesting = i; } finally { param1NodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper2; param1NodeRendererSubContext.renderingNode = null; param1NodeRendererSubContext.doNotRenderLinksNesting = i; }
/*     */             
/*     */             } 
/*     */           }  b++;
/*     */         }  return;
/*     */       } 
/*     */       NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper;
/* 772 */       if ((nodeRenderingHandlerWrapper = this.renderers.get(param1Node.getClass())) != null) {
/* 773 */         Node node = this.renderingNode;
/* 774 */         int i = param1NodeRendererSubContext.doNotRenderLinksNesting;
/* 775 */         NodeRenderingHandlerWrapper nodeRenderingHandlerWrapper1 = param1NodeRendererSubContext.renderingHandlerWrapper;
/*     */         try {
/* 777 */           param1NodeRendererSubContext.renderingNode = param1Node;
/* 778 */           param1NodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper;
/* 779 */           nodeRenderingHandlerWrapper.myRenderingHandler.render(param1Node, param1NodeRendererSubContext, param1NodeRendererSubContext.htmlWriter); return;
/*     */         } finally {
/* 781 */           param1NodeRendererSubContext.renderingNode = node;
/* 782 */           param1NodeRendererSubContext.doNotRenderLinksNesting = i;
/* 783 */           param1NodeRendererSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper1;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderChildren(Node param1Node) {
/* 790 */       renderChildrenNode(param1Node, this);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renderChildrenNode(Node param1Node, NodeRendererSubContext param1NodeRendererSubContext) {
/* 795 */       param1Node = param1Node.getFirstChild();
/* 796 */       while (param1Node != null) {
/* 797 */         Node node = param1Node.getNext();
/* 798 */         renderNode(param1Node, param1NodeRendererSubContext);
/* 799 */         param1Node = node;
/*     */       } 
/*     */     }
/*     */     
/*     */     private class SubNodeRenderer
/*     */       extends NodeRendererSubContext implements NodeRendererContext {
/*     */       private final HtmlRenderer.MainNodeRenderer myMainNodeRenderer;
/*     */       
/*     */       public SubNodeRenderer(HtmlRenderer.MainNodeRenderer param2MainNodeRenderer1, HtmlWriter param2HtmlWriter, boolean param2Boolean) {
/* 808 */         super(param2HtmlWriter);
/* 809 */         this.myMainNodeRenderer = param2MainNodeRenderer1;
/* 810 */         this.doNotRenderLinksNesting = (param2MainNodeRenderer1.getHtmlOptions()).doNotRenderLinksInDocument ? 1 : 0;
/* 811 */         if (param2Boolean) {
/* 812 */           this.renderingNode = param2MainNodeRenderer1.renderingNode;
/* 813 */           this.renderingHandlerWrapper = param2MainNodeRenderer1.renderingHandlerWrapper;
/*     */         } 
/*     */       }
/*     */       
/*     */       public String getNodeId(Node param2Node) {
/* 818 */         return this.myMainNodeRenderer.getNodeId(param2Node);
/*     */       }
/*     */       
/*     */       public DataHolder getOptions() {
/* 822 */         return this.myMainNodeRenderer.getOptions();
/*     */       }
/*     */       
/*     */       public HtmlRendererOptions getHtmlOptions() {
/* 826 */         return this.myMainNodeRenderer.getHtmlOptions();
/*     */       }
/*     */       
/*     */       public Document getDocument() {
/* 830 */         return this.myMainNodeRenderer.getDocument();
/*     */       }
/*     */       
/*     */       public RenderingPhase getRenderingPhase() {
/* 834 */         return this.myMainNodeRenderer.getRenderingPhase();
/*     */       }
/*     */       
/*     */       public String encodeUrl(CharSequence param2CharSequence) {
/* 838 */         return this.myMainNodeRenderer.encodeUrl(param2CharSequence);
/*     */       }
/*     */       
/*     */       public MutableAttributes extendRenderingNodeAttributes(AttributablePart param2AttributablePart, Attributes param2Attributes) {
/* 842 */         return this.myMainNodeRenderer.extendRenderingNodeAttributes(param2AttributablePart, param2Attributes);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public MutableAttributes extendRenderingNodeAttributes(Node param2Node, AttributablePart param2AttributablePart, Attributes param2Attributes) {
/* 850 */         return this.myMainNodeRenderer.extendRenderingNodeAttributes(param2Node, param2AttributablePart, param2Attributes);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void render(Node param2Node) {
/* 859 */         this.myMainNodeRenderer.renderNode(param2Node, this);
/*     */       }
/*     */ 
/*     */       
/*     */       public void delegateRender() {
/* 864 */         this.myMainNodeRenderer.renderByPreviousHandler(this);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public Node getCurrentNode() {
/* 870 */         return this.myMainNodeRenderer.getCurrentNode();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public ResolvedLink resolveLink(LinkType param2LinkType, CharSequence param2CharSequence, Boolean param2Boolean) {
/* 876 */         return this.myMainNodeRenderer.resolveLink(param2LinkType, param2CharSequence, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public ResolvedLink resolveLink(LinkType param2LinkType, CharSequence param2CharSequence, Attributes param2Attributes, Boolean param2Boolean) {
/* 882 */         return this.myMainNodeRenderer.resolveLink(param2LinkType, param2CharSequence, param2Attributes, param2Boolean);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public NodeRendererContext getSubContext(boolean param2Boolean) {
/*     */         HtmlWriter htmlWriter;
/* 889 */         (htmlWriter = new HtmlWriter(this.htmlWriter, param2Boolean)).setContext(this);
/*     */         
/* 891 */         return new SubNodeRenderer(this.myMainNodeRenderer, htmlWriter, false);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public NodeRendererContext getDelegatedSubContext(boolean param2Boolean) {
/*     */         HtmlWriter htmlWriter;
/* 898 */         (htmlWriter = new HtmlWriter(this.htmlWriter, param2Boolean)).setContext(this);
/*     */         
/* 900 */         return new SubNodeRenderer(this.myMainNodeRenderer, htmlWriter, true);
/*     */       }
/*     */ 
/*     */       
/*     */       public void renderChildren(Node param2Node) {
/* 905 */         this.myMainNodeRenderer.renderChildrenNode(param2Node, this);
/*     */       }
/*     */ 
/*     */       
/*     */       public HtmlWriter getHtmlWriter() {
/* 910 */         return this.htmlWriter;
/*     */       } protected int getDoNotRenderLinksNesting() {
/* 912 */         return super.getDoNotRenderLinksNesting();
/*     */       }
/*     */       public boolean isDoNotRenderLinks() {
/* 915 */         return super.isDoNotRenderLinks();
/*     */       }
/*     */       public void doNotRenderLinks(boolean param2Boolean) {
/* 918 */         super.doNotRenderLinks(param2Boolean);
/*     */       }
/*     */       public void doNotRenderLinks() {
/* 921 */         super.doNotRenderLinks();
/*     */       }
/*     */       public void doRenderLinks() {
/* 924 */         super.doRenderLinks();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\HtmlRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */