/*      */ package com.vladsch.flexmark.html2md.converter;
/*      */ 
/*      */ import com.vladsch.flexmark.ast.Reference;
/*      */ import com.vladsch.flexmark.html.renderer.HeaderIdGeneratorFactory;
/*      */ import com.vladsch.flexmark.html.renderer.LinkStatus;
/*      */ import com.vladsch.flexmark.html.renderer.LinkType;
/*      */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*      */ import com.vladsch.flexmark.parser.Parser;
/*      */ import com.vladsch.flexmark.util.ast.Document;
/*      */ import com.vladsch.flexmark.util.ast.Node;
/*      */ import com.vladsch.flexmark.util.builder.BuilderBase;
/*      */ import com.vladsch.flexmark.util.data.DataHolder;
/*      */ import com.vladsch.flexmark.util.data.DataKey;
/*      */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*      */ import com.vladsch.flexmark.util.data.ScopedDataSet;
/*      */ import com.vladsch.flexmark.util.dependency.DependencyResolver;
/*      */ import com.vladsch.flexmark.util.format.NodeContext;
/*      */ import com.vladsch.flexmark.util.format.TableFormatOptions;
/*      */ import com.vladsch.flexmark.util.format.options.TableCaptionHandling;
/*      */ import com.vladsch.flexmark.util.html.Attribute;
/*      */ import com.vladsch.flexmark.util.html.Attributes;
/*      */ import com.vladsch.flexmark.util.html.CellAlignment;
/*      */ import com.vladsch.flexmark.util.html.MutableAttributes;
/*      */ import com.vladsch.flexmark.util.misc.Extension;
/*      */ import com.vladsch.flexmark.util.misc.Ref;
/*      */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*      */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*      */ import com.vladsch.flexmark.util.sequence.LineAppendableImpl;
/*      */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*      */ import com.vladsch.flexmark.util.sequence.builder.StringSequenceBuilder;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.Stack;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import org.jsoup.Jsoup;
/*      */ import org.jsoup.nodes.Attribute;
/*      */ import org.jsoup.nodes.Attributes;
/*      */ import org.jsoup.nodes.Document;
/*      */ import org.jsoup.nodes.Element;
/*      */ import org.jsoup.nodes.Node;
/*      */ import org.jsoup.nodes.TextNode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FlexmarkHtmlConverter
/*      */ {
/*   56 */   public static final DataKey<Integer> FORMAT_FLAGS = new DataKey("FORMAT_FLAGS", Integer.valueOf(LineAppendable.F_TRIM_TRAILING_WHITESPACE | LineAppendable.F_TRIM_LEADING_WHITESPACE | LineAppendable.F_COLLAPSE_WHITESPACE | LineAppendable.F_TRIM_LEADING_EOL | LineAppendable.F_PREFIX_PRE_FORMATTED));
/*   57 */   public static final DataKey<Integer> MAX_BLANK_LINES = new DataKey("MAX_BLANK_LINES", Integer.valueOf(2));
/*   58 */   public static final DataKey<Integer> MAX_TRAILING_BLANK_LINES = new DataKey("MAX_TRAILING_BLANK_LINES", Integer.valueOf(1));
/*      */   
/*   60 */   public static final DataKey<Boolean> LIST_CONTENT_INDENT = new DataKey("LIST_CONTENT_INDENT", Boolean.TRUE);
/*   61 */   public static final DataKey<Boolean> SETEXT_HEADINGS = new DataKey("SETEXT_HEADINGS", Boolean.TRUE);
/*   62 */   public static final DataKey<Boolean> OUTPUT_UNKNOWN_TAGS = new DataKey("OUTPUT_UNKNOWN_TAGS", Boolean.FALSE);
/*   63 */   public static final DataKey<Boolean> TYPOGRAPHIC_QUOTES = new DataKey("TYPOGRAPHIC_QUOTES", Boolean.TRUE);
/*   64 */   public static final DataKey<Boolean> TYPOGRAPHIC_SMARTS = new DataKey("TYPOGRAPHIC_SMARTS", Boolean.TRUE);
/*   65 */   public static final DataKey<Boolean> EXTRACT_AUTO_LINKS = new DataKey("EXTRACT_AUTO_LINKS", Boolean.TRUE);
/*   66 */   public static final DataKey<Boolean> OUTPUT_ATTRIBUTES_ID = new DataKey("OUTPUT_ATTRIBUTES_ID", Boolean.TRUE);
/*   67 */   public static final DataKey<String> OUTPUT_ATTRIBUTES_NAMES_REGEX = new DataKey("OUTPUT_ATTRIBUTES_NAMES_REGEX", "");
/*   68 */   public static final DataKey<Boolean> WRAP_AUTO_LINKS = new DataKey("WRAP_AUTO_LINKS", Boolean.TRUE);
/*   69 */   public static final DataKey<Boolean> RENDER_COMMENTS = new DataKey("RENDER_COMMENTS", Boolean.FALSE);
/*   70 */   public static final DataKey<Boolean> DOT_ONLY_NUMERIC_LISTS = new DataKey("DOT_ONLY_NUMERIC_LISTS", Boolean.TRUE);
/*   71 */   public static final DataKey<Boolean> COMMENT_ORIGINAL_NON_NUMERIC_LIST_ITEM = new DataKey("COMMENT_ORIGINAL_NON_NUMERIC_LIST_ITEM", Boolean.FALSE);
/*   72 */   public static final DataKey<Boolean> PRE_CODE_PRESERVE_EMPHASIS = new DataKey("PRE_CODE_PRESERVE_EMPHASIS", Boolean.FALSE);
/*   73 */   public static final DataKey<Character> ORDERED_LIST_DELIMITER = new DataKey("ORDERED_LIST_DELIMITER", Character.valueOf('.'));
/*   74 */   public static final DataKey<Character> UNORDERED_LIST_DELIMITER = new DataKey("UNORDERED_LIST_DELIMITER", Character.valueOf('*'));
/*   75 */   public static final DataKey<Integer> DEFINITION_MARKER_SPACES = new DataKey("DEFINITION_MARKER_SPACES", Integer.valueOf(3));
/*   76 */   public static final DataKey<Integer> MIN_SETEXT_HEADING_MARKER_LENGTH = new DataKey("MIN_SETEXT_HEADING_MARKER_LENGTH", Integer.valueOf(3));
/*   77 */   public static final DataKey<String> CODE_INDENT = new DataKey("CODE_INDENT", "    ");
/*   78 */   public static final DataKey<String> NBSP_TEXT = new DataKey("NBSP_TEXT", " ");
/*   79 */   public static final DataKey<String> EOL_IN_TITLE_ATTRIBUTE = new DataKey("EOL_IN_TITLE_ATTRIBUTE", " ");
/*   80 */   public static final DataKey<String> THEMATIC_BREAK = new DataKey("THEMATIC_BREAK", "*** ** * ** ***");
/*      */ 
/*      */   
/*   83 */   public static final DataKey<String[]> UNWRAPPED_TAGS = new DataKey("UNWRAPPED_TAGS", new String[] { "article", "address", "frameset", "section", "small", "iframe" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   93 */   public static final DataKey<String[]> WRAPPED_TAGS = new DataKey("WRAPPED_TAGS", new String[] { "kbd", "var" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  100 */   public static final DataKey<String> OUTPUT_ID_ATTRIBUTE_REGEX = new DataKey("OUTPUT_ID_ATTRIBUTE_REGEX", "^user-content-(.*)$");
/*      */   @Deprecated
/*  102 */   public static final DataKey<Integer> TABLE_MIN_SEPARATOR_COLUMN_WIDTH = TableFormatOptions.FORMAT_TABLE_MIN_SEPARATOR_COLUMN_WIDTH; @Deprecated
/*  103 */   public static final DataKey<Integer> TABLE_MIN_SEPARATOR_DASHES = TableFormatOptions.FORMAT_TABLE_MIN_SEPARATOR_DASHES; @Deprecated
/*  104 */   public static final DataKey<Boolean> TABLE_LEAD_TRAIL_PIPES = TableFormatOptions.FORMAT_TABLE_LEAD_TRAIL_PIPES; @Deprecated
/*  105 */   public static final DataKey<Boolean> TABLE_SPACE_AROUND_PIPES = TableFormatOptions.FORMAT_TABLE_SPACE_AROUND_PIPES; @Deprecated
/*  106 */   public static final DataKey<TableCaptionHandling> TABLE_CAPTION = TableFormatOptions.FORMAT_TABLE_CAPTION;
/*      */   
/*  108 */   public static final DataKey<Boolean> LISTS_END_ON_DOUBLE_BLANK = new DataKey("LISTS_END_ON_DOUBLE_BLANK", Boolean.FALSE);
/*  109 */   public static final DataKey<Boolean> DIV_AS_PARAGRAPH = new DataKey("DIV_AS_PARAGRAPH", Boolean.FALSE);
/*  110 */   public static final DataKey<Boolean> BR_AS_PARA_BREAKS = new DataKey("BR_AS_PARA_BREAKS", Boolean.TRUE);
/*  111 */   public static final DataKey<Boolean> BR_AS_EXTRA_BLANK_LINES = new DataKey("BR_AS_EXTRA_BLANK_LINES", Boolean.TRUE);
/*  112 */   public static final DataKey<Boolean> DIV_TABLE_PROCESSING = new DataKey("DIV_TABLE_PROCESSING", Boolean.FALSE);
/*  113 */   public static final DataKey<String[]> DIV_TABLE_HDR_CLASSES = new DataKey("DIV_TABLE_HDR_CLASSES", new String[] { "wt-data-grid__row_header" });
/*      */ 
/*      */   
/*  116 */   public static final DataKey<String[]> DIV_TABLE_ROW_CLASSES = new DataKey("DIV_TABLE_ROW_CLASSES", new String[] { "wt-data-grid__row" });
/*      */ 
/*      */   
/*  119 */   public static final DataKey<String[]> DIV_TABLE_CELL_CLASSES = new DataKey("DIV_TABLE_CELL_CLASSES", new String[] { "wt-data-grid__cell" });
/*      */ 
/*      */ 
/*      */   
/*  123 */   public static final DataKey<Boolean> ADD_TRAILING_EOL = new DataKey("ADD_TRAILING_EOL", Boolean.TRUE);
/*      */   
/*  125 */   public static final DataKey<Boolean> SKIP_HEADING_1 = new DataKey("SKIP_HEADING_1", Boolean.FALSE);
/*  126 */   public static final DataKey<Boolean> SKIP_HEADING_2 = new DataKey("SKIP_HEADING_2", Boolean.FALSE);
/*  127 */   public static final DataKey<Boolean> SKIP_HEADING_3 = new DataKey("SKIP_HEADING_3", Boolean.FALSE);
/*  128 */   public static final DataKey<Boolean> SKIP_HEADING_4 = new DataKey("SKIP_HEADING_4", Boolean.FALSE);
/*  129 */   public static final DataKey<Boolean> SKIP_HEADING_5 = new DataKey("SKIP_HEADING_5", Boolean.FALSE);
/*  130 */   public static final DataKey<Boolean> SKIP_HEADING_6 = new DataKey("SKIP_HEADING_6", Boolean.FALSE);
/*  131 */   public static final DataKey<Boolean> SKIP_ATTRIBUTES = new DataKey("SKIP_ATTRIBUTES", Boolean.FALSE);
/*  132 */   public static final DataKey<Boolean> SKIP_FENCED_CODE = new DataKey("SKIP_FENCED_CODE", Boolean.FALSE);
/*  133 */   public static final DataKey<Boolean> SKIP_CHAR_ESCAPE = new DataKey("SKIP_CHAR_ESCAPE", Boolean.FALSE);
/*      */   
/*  135 */   public static final DataKey<ExtensionConversion> EXT_INLINE_STRONG = new DataKey("EXT_INLINE_STRONG", ExtensionConversion.MARKDOWN);
/*  136 */   public static final DataKey<ExtensionConversion> EXT_INLINE_EMPHASIS = new DataKey("EXT_INLINE_EMPHASIS", ExtensionConversion.MARKDOWN);
/*  137 */   public static final DataKey<ExtensionConversion> EXT_INLINE_CODE = new DataKey("EXT_INLINE_CODE", ExtensionConversion.MARKDOWN);
/*  138 */   public static final DataKey<ExtensionConversion> EXT_INLINE_DEL = new DataKey("EXT_INLINE_DEL", ExtensionConversion.MARKDOWN);
/*  139 */   public static final DataKey<ExtensionConversion> EXT_INLINE_INS = new DataKey("EXT_INLINE_INS", ExtensionConversion.MARKDOWN);
/*  140 */   public static final DataKey<ExtensionConversion> EXT_INLINE_SUB = new DataKey("EXT_INLINE_SUB", ExtensionConversion.MARKDOWN);
/*  141 */   public static final DataKey<ExtensionConversion> EXT_INLINE_SUP = new DataKey("EXT_INLINE_SUP", ExtensionConversion.MARKDOWN);
/*  142 */   public static final DataKey<ExtensionConversion> EXT_MATH = new DataKey("EXT_MATH", ExtensionConversion.HTML);
/*      */   
/*  144 */   public static final DataKey<ExtensionConversion> EXT_TABLES = new DataKey("EXT_TABLES", ExtensionConversion.MARKDOWN);
/*      */   
/*  146 */   public static final DataKey<LinkConversion> EXT_INLINE_LINK = new DataKey("EXT_INLINE_LINK", LinkConversion.MARKDOWN_EXPLICIT);
/*  147 */   public static final DataKey<LinkConversion> EXT_INLINE_IMAGE = new DataKey("EXT_INLINE_IMAGE", LinkConversion.MARKDOWN_EXPLICIT);
/*  148 */   public static final DataKey<Ref<Document>> FOR_DOCUMENT = new DataKey("FOR_DOCUMENT", new Ref(null));
/*  149 */   public static final DataKey<Map<String, String>> TYPOGRAPHIC_REPLACEMENT_MAP = new DataKey("TYPOGRAPHIC_REPLACEMENT_MAP", new HashMap<>());
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  154 */   public static final DataKey<Boolean> DUMP_HTML_TREE = new DataKey("DUMP_HTML_TREE", Boolean.FALSE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  162 */   public static final DataKey<Boolean> IGNORE_TABLE_HEADING_AFTER_ROWS = new DataKey("IGNORE_TABLE_HEADING_AFTER_ROWS", Boolean.TRUE);
/*      */   
/*      */   public static final String A_NODE = "a";
/*      */   
/*      */   public static final String ABBR_NODE = "abbr";
/*      */   public static final String ASIDE_NODE = "aside";
/*      */   public static final String BR_NODE = "br";
/*      */   public static final String BLOCKQUOTE_NODE = "blockquote";
/*      */   public static final String CODE_NODE = "code";
/*      */   public static final String IMG_NODE = "img";
/*      */   public static final String DEL_NODE = "del";
/*      */   public static final String STRIKE_NODE = "strike";
/*      */   public static final String DIV_NODE = "div";
/*      */   public static final String DD_NODE = "dd";
/*      */   public static final String DL_NODE = "dl";
/*      */   public static final String DT_NODE = "dt";
/*      */   public static final String I_NODE = "i";
/*      */   public static final String EM_NODE = "em";
/*      */   public static final String B_NODE = "b";
/*      */   public static final String STRONG_NODE = "strong";
/*      */   public static final String EMOJI_NODE = "g-emoji";
/*      */   public static final String INPUT_NODE = "input";
/*      */   public static final String INS_NODE = "ins";
/*      */   public static final String U_NODE = "u";
/*      */   public static final String SUB_NODE = "sub";
/*      */   public static final String SUP_NODE = "sup";
/*      */   public static final String HR_NODE = "hr";
/*      */   public static final String OL_NODE = "ol";
/*      */   public static final String UL_NODE = "ul";
/*      */   public static final String LI_NODE = "li";
/*      */   public static final String TABLE_NODE = "table";
/*      */   public static final String TBODY_NODE = "tbody";
/*      */   public static final String TD_NODE = "td";
/*      */   public static final String TH_NODE = "th";
/*      */   public static final String THEAD_NODE = "thead";
/*      */   public static final String TR_NODE = "tr";
/*      */   public static final String CAPTION_NODE = "caption";
/*      */   public static final String SVG_NODE = "svg";
/*      */   public static final String P_NODE = "p";
/*      */   public static final String PRE_NODE = "pre";
/*      */   public static final String MATH_NODE = "math";
/*      */   public static final String SPAN_NODE = "span";
/*      */   public static final String TEXT_NODE = "#text";
/*      */   public static final String COMMENT_NODE = "#comment";
/*      */   public static final String H1_NODE = "h1";
/*      */   public static final String H2_NODE = "h2";
/*      */   public static final String H3_NODE = "h3";
/*      */   public static final String H4_NODE = "h4";
/*      */   public static final String H5_NODE = "h5";
/*      */   public static final String H6_NODE = "h6";
/*      */   public static final String DEFAULT_NODE = "";
/*  213 */   public static final String[] HEADING_NODES = new String[] { "h1", "h2", "h3", "h4", "h5", "h6" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  222 */   public static String[] EXPLICIT_LINK_TEXT_TAGS = new String[] { "img" }; private static final Map<Object, CellAlignment> TABLE_CELL_ALIGNMENTS;
/*      */   static final Map<String, String> SPECIAL_CHARS_MAP;
/*      */   
/*      */   static {
/*  226 */     (TABLE_CELL_ALIGNMENTS = new LinkedHashMap<>()).put(Pattern.compile("\\bleft\\b"), CellAlignment.LEFT);
/*  227 */     TABLE_CELL_ALIGNMENTS.put(Pattern.compile("\\bcenter\\b"), CellAlignment.CENTER);
/*  228 */     TABLE_CELL_ALIGNMENTS.put(Pattern.compile("\\bright\\b"), CellAlignment.RIGHT);
/*  229 */     TABLE_CELL_ALIGNMENTS.put("text-left", CellAlignment.LEFT);
/*  230 */     TABLE_CELL_ALIGNMENTS.put("text-center", CellAlignment.CENTER);
/*  231 */     TABLE_CELL_ALIGNMENTS.put("text-right", CellAlignment.RIGHT);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  238 */     (SPECIAL_CHARS_MAP = new HashMap<>()).put("“", "\"");
/*  239 */     SPECIAL_CHARS_MAP.put("”", "\"");
/*  240 */     SPECIAL_CHARS_MAP.put("&ldquo;", "\"");
/*  241 */     SPECIAL_CHARS_MAP.put("&rdquo;", "\"");
/*  242 */     SPECIAL_CHARS_MAP.put("‘", "'");
/*  243 */     SPECIAL_CHARS_MAP.put("’", "'");
/*  244 */     SPECIAL_CHARS_MAP.put("&lsquo;", "'");
/*  245 */     SPECIAL_CHARS_MAP.put("&rsquo;", "'");
/*  246 */     SPECIAL_CHARS_MAP.put("&apos;", "'");
/*  247 */     SPECIAL_CHARS_MAP.put("«", "<<");
/*  248 */     SPECIAL_CHARS_MAP.put("&laquo;", "<<");
/*  249 */     SPECIAL_CHARS_MAP.put("»", ">>");
/*  250 */     SPECIAL_CHARS_MAP.put("&raquo;", ">>");
/*  251 */     SPECIAL_CHARS_MAP.put("…", "...");
/*  252 */     SPECIAL_CHARS_MAP.put("&hellip;", "...");
/*  253 */     SPECIAL_CHARS_MAP.put("–", "--");
/*  254 */     SPECIAL_CHARS_MAP.put("&endash;", "--");
/*  255 */     SPECIAL_CHARS_MAP.put("—", "---");
/*  256 */     SPECIAL_CHARS_MAP.put("&emdash;", "---");
/*      */   }
/*      */   private static final String TYPOGRAPHIC_QUOTES_PIPED = "“|”|‘|’|«|»|&ldquo;|&rdquo;|&lsquo;|&rsquo;|&apos;|&laquo;|&raquo;"; private static final String TYPOGRAPHIC_SMARTS_PIPED = "…|–|—|&hellip;|&endash;|&emdash;";
/*  259 */   public static final DataKey<Map<Object, CellAlignment>> TABLE_CELL_ALIGNMENT_MAP = new DataKey("TABLE_CELL_ALIGNMENT_MAP", TABLE_CELL_ALIGNMENTS);
/*      */   
/*      */   final HtmlConverterOptions htmlConverterOptions;
/*      */   private final DataHolder options;
/*      */   final List<DelegatingNodeRendererFactoryWrapper> nodeRendererFactories;
/*      */   final List<HtmlLinkResolverFactory> linkResolverFactories;
/*      */   
/*      */   FlexmarkHtmlConverter(Builder paramBuilder) {
/*  267 */     this.options = (DataHolder)paramBuilder.toImmutable();
/*  268 */     this.htmlConverterOptions = new HtmlConverterOptions(this.options);
/*      */     ArrayList<HtmlNodeRendererFactory> arrayList;
/*  270 */     (arrayList = new ArrayList<>(paramBuilder.nodeRendererFactories.size() + 1)).addAll(paramBuilder.nodeRendererFactories);
/*      */ 
/*      */     
/*  273 */     ArrayList<DelegatingNodeRendererFactoryWrapper> arrayList1 = new ArrayList(arrayList.size());
/*      */     
/*  275 */     for (int i = arrayList.size() - 1; i >= 0; i--) {
/*  276 */       HtmlNodeRendererFactory htmlNodeRendererFactory = arrayList.get(i);
/*  277 */       arrayList1.add(new DelegatingNodeRendererFactoryWrapper(arrayList1, htmlNodeRendererFactory));
/*      */     } 
/*      */ 
/*      */     
/*  281 */     HtmlConverterCoreNodeRendererFactory htmlConverterCoreNodeRendererFactory = new HtmlConverterCoreNodeRendererFactory();
/*  282 */     arrayList1.add(new DelegatingNodeRendererFactoryWrapper(arrayList1, htmlConverterCoreNodeRendererFactory));
/*      */     
/*  284 */     this.nodeRendererFactories = DependencyResolver.resolveFlatDependencies(arrayList1, null, paramDelegatingNodeRendererFactoryWrapper -> paramDelegatingNodeRendererFactoryWrapper.getFactory().getClass());
/*      */     
/*  286 */     this.linkResolverFactories = DependencyResolver.resolveFlatDependencies(paramBuilder.linkResolverFactories, null, null);
/*      */   }
/*      */   
/*      */   public DataHolder getOptions() {
/*  290 */     return this.options;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Builder builder() {
/*  299 */     return new Builder();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Builder builder(DataHolder paramDataHolder) {
/*  309 */     return new Builder(paramDataHolder);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void convert(String paramString, Appendable paramAppendable) {
/*  319 */     Document document = Jsoup.parse(paramString);
/*      */     
/*  321 */     if (((Boolean)DUMP_HTML_TREE.get(getOptions())).booleanValue()) {
/*      */       LineAppendableImpl lineAppendableImpl;
/*  323 */       (lineAppendableImpl = new LineAppendableImpl(LineAppendable.F_TRIM_LEADING_EOL)).setIndentPrefix("  ");
/*  324 */       dumpHtmlTree((LineAppendable)lineAppendableImpl, (Node)document.body());
/*  325 */       System.out.println(lineAppendableImpl.toString(0, 0));
/*      */     } 
/*      */     
/*      */     MainHtmlConverter mainHtmlConverter;
/*  329 */     (mainHtmlConverter = new MainHtmlConverter(this.options, new HtmlMarkdownWriter(this.htmlConverterOptions.formatFlags), document, null)).render((Node)document);
/*  330 */     mainHtmlConverter.flushTo(paramAppendable, this.htmlConverterOptions.maxBlankLines, this.htmlConverterOptions.maxTrailingBlankLines);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String convert(String paramString) {
/*  340 */     return convert(paramString, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String convert(String paramString, int paramInt) {
/*  351 */     Document document = Jsoup.parse(paramString);
/*      */     
/*  353 */     if (((Boolean)DUMP_HTML_TREE.get(getOptions())).booleanValue()) {
/*      */       LineAppendableImpl lineAppendableImpl;
/*  355 */       (lineAppendableImpl = new LineAppendableImpl(LineAppendable.F_TRIM_LEADING_EOL)).setIndentPrefix("  ");
/*  356 */       dumpHtmlTree((LineAppendable)lineAppendableImpl, (Node)document.body());
/*  357 */       System.out.println(lineAppendableImpl.toString(0, 0));
/*      */     } 
/*      */     
/*      */     MainHtmlConverter mainHtmlConverter;
/*  361 */     (mainHtmlConverter = new MainHtmlConverter(this.options, new HtmlMarkdownWriter(this.htmlConverterOptions.formatFlags), document, null)).render((Node)document);
/*      */     
/*  363 */     return mainHtmlConverter.getMarkdown().toString(this.htmlConverterOptions.maxBlankLines, paramInt);
/*      */   }
/*      */   
/*      */   public static void dumpHtmlTree(LineAppendable paramLineAppendable, Node paramNode) {
/*  367 */     paramLineAppendable.line().append(paramNode.nodeName());
/*  368 */     for (Attribute attribute : paramNode.attributes().asList()) {
/*  369 */       paramLineAppendable.append(' ').append(attribute.getKey()).append("=\"").append(attribute.getValue()).append("\"");
/*      */     }
/*      */     
/*  372 */     paramLineAppendable.line().indent();
/*      */     
/*  374 */     for (Node node : paramNode.childNodes()) {
/*  375 */       dumpHtmlTree(paramLineAppendable, node);
/*      */     }
/*      */     
/*  378 */     paramLineAppendable.unIndent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void convert(Node paramNode, Appendable paramAppendable, int paramInt) {
/*      */     MainHtmlConverter mainHtmlConverter;
/*  390 */     (mainHtmlConverter = new MainHtmlConverter(this.options, new HtmlMarkdownWriter(this.htmlConverterOptions.formatFlags), paramNode.ownerDocument(), null)).render(paramNode);
/*  391 */     mainHtmlConverter.flushTo(paramAppendable, this.htmlConverterOptions.maxBlankLines, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String convert(Node paramNode) {
/*  401 */     StringBuilder stringBuilder = new StringBuilder();
/*  402 */     convert(paramNode, stringBuilder, 0);
/*  403 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Builder
/*      */     extends BuilderBase<Builder>
/*      */   {
/*  410 */     List<HtmlNodeRendererFactory> nodeRendererFactories = new ArrayList<>();
/*  411 */     List<HtmlLinkResolverFactory> linkResolverFactories = new ArrayList<>();
/*  412 */     HeaderIdGeneratorFactory htmlIdGeneratorFactory = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder(DataHolder param1DataHolder) {
/*  419 */       super(param1DataHolder);
/*  420 */       loadExtensions();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FlexmarkHtmlConverter build() {
/*  428 */       return new FlexmarkHtmlConverter(this);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void removeApiPoint(Object param1Object) {
/*  433 */       if (param1Object instanceof HtmlNodeRendererFactory) { this.nodeRendererFactories.remove(param1Object); return; }
/*  434 */        if (param1Object instanceof HtmlLinkResolverFactory) { this.linkResolverFactories.remove(param1Object); return; }
/*  435 */        if (param1Object instanceof HeaderIdGeneratorFactory) { this.htmlIdGeneratorFactory = null; return; }
/*      */       
/*  437 */       throw new IllegalStateException("Unknown data point type: " + param1Object.getClass().getName());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void preloadExtension(Extension param1Extension) {
/*  443 */       if (param1Extension instanceof FlexmarkHtmlConverter.HtmlConverterExtension)
/*      */       {
/*  445 */         (param1Extension = param1Extension).rendererOptions((MutableDataHolder)this);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean loadExtension(Extension param1Extension) {
/*  451 */       if (param1Extension instanceof FlexmarkHtmlConverter.HtmlConverterExtension) {
/*      */         
/*  453 */         (param1Extension = param1Extension).extend(this);
/*  454 */         return true;
/*      */       } 
/*  456 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder htmlNodeRendererFactory(HtmlNodeRendererFactory param1HtmlNodeRendererFactory) {
/*  471 */       this.nodeRendererFactories.add(param1HtmlNodeRendererFactory);
/*  472 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder linkResolverFactory(HtmlLinkResolverFactory param1HtmlLinkResolverFactory) {
/*  487 */       this.linkResolverFactories.add(param1HtmlLinkResolverFactory);
/*  488 */       addExtensionApiPoint(param1HtmlLinkResolverFactory);
/*  489 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder() {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  507 */   private static final Iterator<Node> NULL_ITERATOR = new Iterator<Node>()
/*      */     {
/*      */       public final boolean hasNext() {
/*  510 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public final Node next() {
/*  515 */         return null;
/*      */       }
/*      */ 
/*      */       
/*      */       public final void remove() {}
/*      */     };
/*      */ 
/*      */   
/*      */   public static final Iterable<Node> NULL_ITERABLE = () -> NULL_ITERATOR;
/*      */ 
/*      */   
/*      */   private class MainHtmlConverter
/*      */     extends HtmlNodeConverterSubContext
/*      */   {
/*      */     private final Document document;
/*      */     private final Document myForDocument;
/*      */     private final Map<String, HtmlNodeRendererHandler<?>> renderers;
/*      */     private final List<PhasedHtmlNodeRenderer> phasedFormatters;
/*      */     private final Set<HtmlConverterPhase> renderingPhases;
/*      */     private final DataHolder myOptions;
/*      */     private HtmlConverterPhase phase;
/*      */     private final HtmlConverterOptions myHtmlConverterOptions;
/*      */     private final Pattern specialCharsPattern;
/*      */     private final Stack<HtmlConverterState> myStateStack;
/*      */     private final Map<String, String> mySpecialCharsMap;
/*      */     private HtmlConverterState myState;
/*      */     private boolean myTrace;
/*      */     private boolean myInlineCode;
/*  543 */     private Parser myParser = null;
/*      */     
/*      */     private final HtmlLinkResolver[] myHtmlLinkResolvers;
/*      */     private final HashMap<String, Reference> myReferenceUrlToReferenceMap;
/*      */     private final HashSet<Reference> myExternalReferences;
/*      */     
/*      */     public HtmlConverterState getState() {
/*  550 */       return this.myState;
/*      */     }
/*      */     
/*      */     MainHtmlConverter(DataHolder param1DataHolder1, HtmlMarkdownWriter param1HtmlMarkdownWriter, Document param1Document, DataHolder param1DataHolder2) {
/*  554 */       super(param1HtmlMarkdownWriter);
/*  555 */       this.myOptions = (DataHolder)new ScopedDataSet(param1DataHolder2, param1DataHolder1);
/*  556 */       this.renderers = new HashMap<>(32);
/*  557 */       this.renderingPhases = new HashSet<>((HtmlConverterPhase.values()).length);
/*  558 */       this.phasedFormatters = new ArrayList<>(FlexmarkHtmlConverter.this.nodeRendererFactories.size());
/*  559 */       this.myHtmlLinkResolvers = new HtmlLinkResolver[FlexmarkHtmlConverter.this.linkResolverFactories.size()];
/*      */       
/*  561 */       param1HtmlMarkdownWriter.setContext(this);
/*      */       
/*  563 */       this.myHtmlConverterOptions = new HtmlConverterOptions(this.myOptions);
/*      */       
/*  565 */       if (this.myHtmlConverterOptions.typographicQuotes && this.myHtmlConverterOptions.typographicSmarts) {
/*  566 */         this.specialCharsPattern = Pattern.compile("“|”|‘|’|«|»|&ldquo;|&rdquo;|&lsquo;|&rsquo;|&apos;|&laquo;|&raquo;|…|–|—|&hellip;|&endash;|&emdash;");
/*  567 */       } else if (this.myHtmlConverterOptions.typographicQuotes) {
/*  568 */         this.specialCharsPattern = Pattern.compile("“|”|‘|’|«|»|&ldquo;|&rdquo;|&lsquo;|&rsquo;|&apos;|&laquo;|&raquo;");
/*  569 */       } else if (this.myHtmlConverterOptions.typographicSmarts) {
/*  570 */         this.specialCharsPattern = Pattern.compile("…|–|—|&hellip;|&endash;|&emdash;");
/*      */       } else {
/*  572 */         this.specialCharsPattern = null;
/*      */       } 
/*      */ 
/*      */       
/*  576 */       this.myStateStack = new Stack<>();
/*  577 */       this.myReferenceUrlToReferenceMap = new HashMap<>();
/*  578 */       this.myExternalReferences = new HashSet<>();
/*  579 */       this.myState = null;
/*      */       
/*      */       Map<?, ?> map;
/*  582 */       if (!(map = (Map<?, ?>)FlexmarkHtmlConverter.TYPOGRAPHIC_REPLACEMENT_MAP.get(this.myOptions)).isEmpty()) {
/*  583 */         this.mySpecialCharsMap = (Map)map;
/*      */       } else {
/*  585 */         this.mySpecialCharsMap = FlexmarkHtmlConverter.SPECIAL_CHARS_MAP;
/*      */       } 
/*      */       
/*      */       int i;
/*  589 */       for (i = FlexmarkHtmlConverter.this.nodeRendererFactories.size() - 1; i >= 0; i--) {
/*      */         HtmlNodeRendererFactory htmlNodeRendererFactory;
/*      */         HtmlNodeRenderer htmlNodeRenderer;
/*      */         Set<HtmlNodeRendererHandler<?>> set;
/*  593 */         if ((set = (htmlNodeRenderer = (htmlNodeRendererFactory = FlexmarkHtmlConverter.this.nodeRendererFactories.get(i)).apply(this.myOptions)).getHtmlNodeRendererHandlers()) != null) {
/*      */           
/*  595 */           for (HtmlNodeRendererHandler<?> htmlNodeRendererHandler : set)
/*      */           {
/*  597 */             this.renderers.put(htmlNodeRendererHandler.getTagName(), htmlNodeRendererHandler);
/*      */           }
/*      */           
/*  600 */           if (htmlNodeRenderer instanceof PhasedHtmlNodeRenderer)
/*      */           {
/*  602 */             if ((set = (Set)((PhasedHtmlNodeRenderer)htmlNodeRenderer).getHtmlConverterPhases()) != null) {
/*  603 */               if (set.isEmpty()) throw new IllegalStateException("PhasedNodeFormatter with empty Phases"); 
/*  604 */               this.renderingPhases.addAll(set);
/*  605 */               this.phasedFormatters.add((PhasedHtmlNodeRenderer)htmlNodeRenderer);
/*      */             } else {
/*  607 */               throw new IllegalStateException("PhasedNodeFormatter with null Phases");
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*  612 */       for (i = 0; i < FlexmarkHtmlConverter.this.linkResolverFactories.size(); i++) {
/*  613 */         this.myHtmlLinkResolvers[i] = ((HtmlLinkResolverFactory)FlexmarkHtmlConverter.this.linkResolverFactories.get(i)).apply(this);
/*      */       }
/*      */       
/*  616 */       this.document = param1Document;
/*  617 */       this.myForDocument = (Document)((Ref)FlexmarkHtmlConverter.FOR_DOCUMENT.get(param1DataHolder1)).value;
/*      */     }
/*      */     
/*      */     private class SubHtmlNodeConverter
/*      */       extends HtmlNodeConverterSubContext implements HtmlNodeConverterContext {
/*      */       private final FlexmarkHtmlConverter.MainHtmlConverter myMainNodeRenderer;
/*      */       private final DataHolder myOptions;
/*      */       
/*      */       SubHtmlNodeConverter(FlexmarkHtmlConverter.MainHtmlConverter param2MainHtmlConverter1, HtmlMarkdownWriter param2HtmlMarkdownWriter, DataHolder param2DataHolder) {
/*  626 */         super(param2HtmlMarkdownWriter);
/*  627 */         this.myMainNodeRenderer = param2MainHtmlConverter1;
/*  628 */         this.myOptions = (param2DataHolder == null || param2DataHolder == this.myMainNodeRenderer.getOptions()) ? this.myMainNodeRenderer.getOptions() : (DataHolder)new ScopedDataSet(this.myMainNodeRenderer.getOptions(), param2DataHolder);
/*      */       }
/*      */       
/*      */       public DataHolder getOptions() {
/*  632 */         return this.myOptions;
/*      */       }
/*      */       public HtmlConverterOptions getHtmlConverterOptions() {
/*  635 */         return this.myMainNodeRenderer.getHtmlConverterOptions();
/*      */       }
/*      */       public Document getDocument() {
/*  638 */         return this.myMainNodeRenderer.getDocument();
/*      */       }
/*      */       public HtmlConverterPhase getFormattingPhase() {
/*  641 */         return this.myMainNodeRenderer.getFormattingPhase();
/*      */       }
/*      */       
/*      */       public void render(Node param2Node) {
/*  645 */         this.myMainNodeRenderer.renderNode(param2Node, this);
/*      */       }
/*      */ 
/*      */       
/*      */       public Node getCurrentNode() {
/*  650 */         return this.myRenderingNode;
/*      */       }
/*      */ 
/*      */       
/*      */       public HtmlNodeConverterContext getSubContext() {
/*  655 */         return getSubContext(this.myOptions, (ISequenceBuilder<?, ?>)StringSequenceBuilder.emptyBuilder());
/*      */       }
/*      */ 
/*      */       
/*      */       public HtmlNodeConverterContext getSubContext(DataHolder param2DataHolder) {
/*  660 */         return getSubContext(param2DataHolder, (ISequenceBuilder<?, ?>)StringSequenceBuilder.emptyBuilder());
/*      */       }
/*      */ 
/*      */       
/*      */       public HtmlNodeConverterContext getSubContext(DataHolder param2DataHolder, ISequenceBuilder<?, ?> param2ISequenceBuilder) {
/*      */         HtmlMarkdownWriter htmlMarkdownWriter;
/*  666 */         (htmlMarkdownWriter = new HtmlMarkdownWriter((Appendable)param2ISequenceBuilder, this.markdown.getOptions())).setContext(this);
/*      */         
/*  668 */         return new SubHtmlNodeConverter(this.myMainNodeRenderer, htmlMarkdownWriter, (param2DataHolder == null || param2DataHolder == this.myOptions) ? this.myOptions : (DataHolder)new ScopedDataSet(this.myOptions, param2DataHolder));
/*      */       }
/*      */ 
/*      */       
/*      */       public void renderChildren(Node param2Node, boolean param2Boolean, Runnable param2Runnable) {
/*  673 */         FlexmarkHtmlConverter.processHtmlTree(this, param2Node, param2Boolean, param2Runnable);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public Document getForDocument() {
/*  679 */         return this.myMainNodeRenderer.getForDocument();
/*      */       }
/*      */ 
/*      */       
/*      */       public ResolvedLink resolveLink(LinkType param2LinkType, CharSequence param2CharSequence, Boolean param2Boolean) {
/*  684 */         return this.myMainNodeRenderer.resolveLink(param2LinkType, param2CharSequence, param2Boolean);
/*      */       }
/*      */ 
/*      */       
/*      */       public ResolvedLink resolveLink(LinkType param2LinkType, CharSequence param2CharSequence, Attributes param2Attributes, Boolean param2Boolean) {
/*  689 */         return this.myMainNodeRenderer.resolveLink(param2LinkType, param2CharSequence, param2Attributes, param2Boolean);
/*      */       }
/*      */ 
/*      */       
/*      */       public void pushState(Node param2Node) {
/*  694 */         this.myMainNodeRenderer.pushState(param2Node);
/*      */       }
/*      */ 
/*      */       
/*      */       public void popState(LineAppendable param2LineAppendable) {
/*  699 */         this.myMainNodeRenderer.popState(param2LineAppendable);
/*      */       }
/*      */ 
/*      */       
/*      */       public void processAttributes(Node param2Node) {
/*  704 */         this.myMainNodeRenderer.processAttributes(param2Node);
/*      */       }
/*      */ 
/*      */       
/*      */       public int outputAttributes(LineAppendable param2LineAppendable, String param2String) {
/*  709 */         return this.myMainNodeRenderer.outputAttributes(param2LineAppendable, param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       public void transferIdToParent() {
/*  714 */         this.myMainNodeRenderer.transferIdToParent();
/*      */       }
/*      */ 
/*      */       
/*      */       public void transferToParentExcept(String... param2VarArgs) {
/*  719 */         this.myMainNodeRenderer.transferToParentExcept(param2VarArgs);
/*      */       }
/*      */ 
/*      */       
/*      */       public void transferToParentOnly(String... param2VarArgs) {
/*  724 */         this.myMainNodeRenderer.transferToParentOnly(param2VarArgs);
/*      */       }
/*      */ 
/*      */       
/*      */       public Node peek() {
/*  729 */         return this.myMainNodeRenderer.peek();
/*      */       }
/*      */ 
/*      */       
/*      */       public Node peek(int param2Int) {
/*  734 */         return this.myMainNodeRenderer.peek(param2Int);
/*      */       }
/*      */ 
/*      */       
/*      */       public Node next() {
/*  739 */         return this.myMainNodeRenderer.next();
/*      */       }
/*      */ 
/*      */       
/*      */       public void skip() {
/*  744 */         this.myMainNodeRenderer.skip();
/*      */       }
/*      */ 
/*      */       
/*      */       public Node next(int param2Int) {
/*  749 */         return this.myMainNodeRenderer.next(param2Int);
/*      */       }
/*      */ 
/*      */       
/*      */       public void skip(int param2Int) {
/*  754 */         this.myMainNodeRenderer.skip(param2Int);
/*      */       }
/*      */ 
/*      */       
/*      */       public void delegateRender() {
/*  759 */         this.myMainNodeRenderer.renderByPreviousHandler(this);
/*      */       }
/*      */ 
/*      */       
/*      */       public HashMap<String, Reference> getReferenceUrlToReferenceMap() {
/*  764 */         return this.myMainNodeRenderer.getReferenceUrlToReferenceMap();
/*      */       }
/*      */ 
/*      */       
/*      */       public HashSet<Reference> getExternalReferences() {
/*  769 */         return this.myMainNodeRenderer.getExternalReferences();
/*      */       }
/*      */ 
/*      */       
/*      */       public Reference getOrCreateReference(String param2String1, String param2String2, String param2String3) {
/*  774 */         return this.myMainNodeRenderer.getOrCreateReference(param2String1, param2String2, param2String3);
/*      */       }
/*      */ 
/*      */       
/*      */       public Node parseMarkdown(String param2String) {
/*  779 */         return this.myMainNodeRenderer.parseMarkdown(param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       public void processUnwrapped(Node param2Node) {
/*  784 */         this.myMainNodeRenderer.processUnwrapped(this, param2Node);
/*      */       }
/*      */ 
/*      */       
/*      */       public void processWrapped(Node param2Node, Boolean param2Boolean, boolean param2Boolean1) {
/*  789 */         FlexmarkHtmlConverter.processWrapped(this, param2Node, param2Boolean, param2Boolean1);
/*      */       }
/*      */ 
/*      */       
/*      */       public void appendOuterHtml(Node param2Node) {
/*  794 */         FlexmarkHtmlConverter.appendOuterHtml(this, param2Node);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean isInlineCode() {
/*  799 */         return this.myMainNodeRenderer.isInlineCode();
/*      */       }
/*      */ 
/*      */       
/*      */       public void setInlineCode(boolean param2Boolean) {
/*  804 */         this.myMainNodeRenderer.setInlineCode(param2Boolean);
/*      */       }
/*      */ 
/*      */       
/*      */       public void inlineCode(Runnable param2Runnable) {
/*  809 */         this.myMainNodeRenderer.inlineCode(param2Runnable);
/*      */       }
/*      */ 
/*      */       
/*      */       public String escapeSpecialChars(String param2String) {
/*  814 */         return this.myMainNodeRenderer.escapeSpecialChars(param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       public String prepareText(String param2String) {
/*  819 */         return this.myMainNodeRenderer.prepareText(param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       public String prepareText(String param2String, boolean param2Boolean) {
/*  824 */         return this.myMainNodeRenderer.prepareText(param2String, param2Boolean);
/*      */       }
/*      */ 
/*      */       
/*      */       public String processTextNodes(Node param2Node) {
/*  829 */         return this.myMainNodeRenderer.processTextNodes(param2Node);
/*      */       }
/*      */ 
/*      */       
/*      */       public void excludeAttributes(String... param2VarArgs) {
/*  834 */         this.myMainNodeRenderer.excludeAttributes(param2VarArgs);
/*      */       }
/*      */ 
/*      */       
/*      */       public void processTextNodes(Node param2Node, boolean param2Boolean) {
/*  839 */         processTextNodes(param2Node, param2Boolean, (CharSequence)null, (CharSequence)null);
/*      */       }
/*      */ 
/*      */       
/*      */       public void processTextNodes(Node param2Node, boolean param2Boolean, CharSequence param2CharSequence) {
/*  844 */         processTextNodes(param2Node, param2Boolean, param2CharSequence, param2CharSequence);
/*      */       }
/*      */ 
/*      */       
/*      */       public void processTextNodes(Node param2Node, boolean param2Boolean, CharSequence param2CharSequence1, CharSequence param2CharSequence2) {
/*  849 */         FlexmarkHtmlConverter.processTextNodes(this, param2Node, param2Boolean, param2CharSequence1, param2CharSequence2);
/*      */       }
/*      */ 
/*      */       
/*      */       public void wrapTextNodes(Node param2Node, CharSequence param2CharSequence, boolean param2Boolean) {
/*  854 */         FlexmarkHtmlConverter.wrapTextNodes(this, param2Node, param2CharSequence, param2Boolean);
/*      */       }
/*      */ 
/*      */       
/*      */       public void processConditional(ExtensionConversion param2ExtensionConversion, Node param2Node, Runnable param2Runnable) {
/*  859 */         FlexmarkHtmlConverter.processConditional(this, param2ExtensionConversion, param2Node, param2Runnable);
/*      */       }
/*      */ 
/*      */       
/*      */       public void renderDefault(Node param2Node) {
/*  864 */         FlexmarkHtmlConverter.processDefault(this, param2Node, (getHtmlConverterOptions()).outputUnknownTags);
/*      */       }
/*      */ 
/*      */       
/*      */       public HtmlConverterState getState() {
/*  869 */         return this.myMainNodeRenderer.getState();
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean isTrace() {
/*  874 */         return this.myMainNodeRenderer.isTrace();
/*      */       }
/*      */ 
/*      */       
/*      */       public void setTrace(boolean param2Boolean) {
/*  879 */         this.myMainNodeRenderer.setTrace(param2Boolean);
/*      */       }
/*      */ 
/*      */       
/*      */       public Stack<HtmlConverterState> getStateStack() {
/*  884 */         return this.myMainNodeRenderer.getStateStack();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public HashMap<String, Reference> getReferenceUrlToReferenceMap() {
/*  890 */       return this.myReferenceUrlToReferenceMap;
/*      */     }
/*      */ 
/*      */     
/*      */     public HashSet<Reference> getExternalReferences() {
/*  895 */       return this.myExternalReferences;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isTrace() {
/*  900 */       return this.myTrace;
/*      */     }
/*      */ 
/*      */     
/*      */     public Stack<HtmlConverterState> getStateStack() {
/*  905 */       return this.myStateStack;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setTrace(boolean param1Boolean) {
/*  910 */       this.myTrace = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public Node parseMarkdown(String param1String) {
/*  915 */       if (this.myParser == null) {
/*  916 */         this.myParser = Parser.builder(this.myOptions).build();
/*      */       }
/*  918 */       return (Node)this.myParser.parse(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public Reference getOrCreateReference(String param1String1, String param1String2, String param1String3) {
/*      */       Reference reference;
/*  924 */       if ((reference = this.myReferenceUrlToReferenceMap.get(param1String1)) != null) {
/*  925 */         if (param1String3 != null && !param1String3.trim().isEmpty()) {
/*  926 */           if (reference.getTitle().isBlank()) {
/*      */             
/*  928 */             reference.setTitle(BasedSequence.of(param1String3).subSequence(0, param1String3.length()));
/*  929 */             return reference;
/*  930 */           }  if (reference.getTitle().equals(param1String3.trim())) {
/*  931 */             return reference;
/*      */           }
/*      */         } 
/*  934 */         return reference;
/*      */       } 
/*      */ 
/*      */       
/*  938 */       String str = param1String2;
/*      */       
/*  940 */       if (this.myReferenceUrlToReferenceMap.containsKey(str)) {
/*  941 */         byte b = 1; while (true) {
/*  942 */           str = param1String2 + "_" + b;
/*  943 */           if (this.myReferenceUrlToReferenceMap.containsKey(str)) {
/*      */             b++; continue;
/*      */           } 
/*      */           break;
/*      */         } 
/*      */       } 
/*  949 */       StringBuilder stringBuilder = (new StringBuilder("[")).append(str).append("]: ").append(param1String1);
/*      */       
/*  951 */       if (param1String3 != null && !param1String3.trim().isEmpty()) {
/*  952 */         stringBuilder.append(" '").append(param1String3.replace("'", "\\'")).append("'");
/*      */       }
/*      */       
/*      */       Node node;
/*      */       
/*  957 */       if (node = (node = parseMarkdown(stringBuilder.toString())).getFirstChild() instanceof Reference) {
/*  958 */         Reference reference1 = (Reference)node;
/*  959 */         this.myReferenceUrlToReferenceMap.put(param1String1, reference1);
/*  960 */         return reference1;
/*      */       } 
/*  962 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public ResolvedLink resolveLink(LinkType param1LinkType, CharSequence param1CharSequence, Boolean param1Boolean) {
/*  967 */       return resolveLink(param1LinkType, param1CharSequence, (Attributes)null, param1Boolean);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ResolvedLink resolveLink(LinkType param1LinkType, CharSequence param1CharSequence, Attributes param1Attributes, Boolean param1Boolean) {
/*  975 */       param1CharSequence = String.valueOf(param1CharSequence);
/*      */ 
/*      */ 
/*      */       
/*  979 */       ResolvedLink resolvedLink = new ResolvedLink(param1LinkType, param1CharSequence, param1Attributes);
/*      */       
/*  981 */       if (!param1CharSequence.isEmpty()) {
/*  982 */         Node node = getCurrentNode(); HtmlLinkResolver[] arrayOfHtmlLinkResolver; int i; byte b;
/*      */         HtmlLinkResolver htmlLinkResolver;
/*  984 */         for (i = (arrayOfHtmlLinkResolver = this.myHtmlLinkResolvers).length, b = 0; b < i && (
/*      */           
/*  986 */           resolvedLink = (htmlLinkResolver = arrayOfHtmlLinkResolver[b]).resolveLink(node, this, resolvedLink)).getStatus() == LinkStatus.UNKNOWN; b++);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  994 */       return resolvedLink;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Node getCurrentNode() {
/* 1000 */       return this.myRenderingNode;
/*      */     }
/*      */ 
/*      */     
/*      */     public DataHolder getOptions() {
/* 1005 */       return this.myOptions;
/*      */     }
/*      */ 
/*      */     
/*      */     public HtmlConverterOptions getHtmlConverterOptions() {
/* 1010 */       return FlexmarkHtmlConverter.this.htmlConverterOptions;
/*      */     }
/*      */ 
/*      */     
/*      */     public Document getDocument() {
/* 1015 */       return this.document;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Document getForDocument() {
/* 1021 */       return this.myForDocument;
/*      */     }
/*      */ 
/*      */     
/*      */     public HtmlConverterPhase getFormattingPhase() {
/* 1026 */       return this.phase;
/*      */     }
/*      */ 
/*      */     
/*      */     public void render(Node param1Node) {
/* 1031 */       renderNode(param1Node, this);
/*      */     }
/*      */ 
/*      */     
/*      */     public void delegateRender() {
/* 1036 */       renderByPreviousHandler(this);
/*      */     }
/*      */     
/*      */     void renderByPreviousHandler(HtmlNodeConverterSubContext param1HtmlNodeConverterSubContext) {
/* 1040 */       if (param1HtmlNodeConverterSubContext.getRenderingNode() != null)
/*      */       { NodeRenderingHandlerWrapper<?> nodeRenderingHandlerWrapper;
/*      */         
/* 1043 */         if ((nodeRenderingHandlerWrapper = param1HtmlNodeConverterSubContext.renderingHandlerWrapper.myPreviousRenderingHandler) != null)
/* 1044 */         { Node node = param1HtmlNodeConverterSubContext.getRenderingNode();
/* 1045 */           NodeRenderingHandlerWrapper<?> nodeRenderingHandlerWrapper1 = param1HtmlNodeConverterSubContext.renderingHandlerWrapper;
/*      */           try {
/* 1047 */             param1HtmlNodeConverterSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper;
/* 1048 */             nodeRenderingHandlerWrapper.myRenderingHandler.render(node, param1HtmlNodeConverterSubContext, param1HtmlNodeConverterSubContext.getMarkdown());
/*      */           } finally {
/* 1050 */             param1HtmlNodeConverterSubContext.setRenderingNode(node);
/* 1051 */             param1HtmlNodeConverterSubContext.renderingHandlerWrapper = nodeRenderingHandlerWrapper1;
/*      */           }  }
/*      */         else { return; }
/*      */          }
/* 1055 */       else { throw new IllegalStateException("renderingByPreviousHandler called outside node rendering code"); }
/*      */     
/*      */     }
/*      */ 
/*      */     
/*      */     public HtmlNodeConverterContext getSubContext() {
/* 1061 */       return getSubContext((DataHolder)null);
/*      */     }
/*      */ 
/*      */     
/*      */     public HtmlNodeConverterContext getSubContext(DataHolder param1DataHolder) {
/* 1066 */       return getSubContext(param1DataHolder, this.markdown.getBuilder());
/*      */     }
/*      */ 
/*      */     
/*      */     public HtmlNodeConverterContext getSubContext(DataHolder param1DataHolder, ISequenceBuilder<?, ?> param1ISequenceBuilder) {
/*      */       HtmlMarkdownWriter htmlMarkdownWriter;
/* 1072 */       (htmlMarkdownWriter = new HtmlMarkdownWriter((Appendable)param1ISequenceBuilder, this.markdown.getOptions())).setContext(this);
/*      */       
/* 1074 */       return new SubHtmlNodeConverter(this, htmlMarkdownWriter, (param1DataHolder == null || param1DataHolder == this.myOptions) ? this.myOptions : (DataHolder)new ScopedDataSet(this.myOptions, param1DataHolder));
/*      */     }
/*      */     
/*      */     void renderNode(Node param1Node, HtmlNodeConverterSubContext param1HtmlNodeConverterSubContext) {
/* 1078 */       if (param1Node instanceof Document) {
/*      */         HtmlConverterPhase[] arrayOfHtmlConverterPhase; int i; byte b;
/* 1080 */         for (i = (arrayOfHtmlConverterPhase = HtmlConverterPhase.values()).length, b = 0; b < i; ) {
/* 1081 */           HtmlConverterPhase htmlConverterPhase; if ((htmlConverterPhase = arrayOfHtmlConverterPhase[b]) == HtmlConverterPhase.DOCUMENT || this.renderingPhases.contains(htmlConverterPhase)) {
/* 1082 */             this.phase = htmlConverterPhase;
/*      */ 
/*      */             
/* 1085 */             if (this.phase == HtmlConverterPhase.DOCUMENT) {
/*      */               
/* 1087 */               FlexmarkHtmlConverter.processHtmlTree(param1HtmlNodeConverterSubContext, (Node)this.document.body(), false, null);
/*      */ 
/*      */ 
/*      */             
/*      */             }
/*      */             else {
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1097 */               for (Iterator<PhasedHtmlNodeRenderer> iterator = this.phasedFormatters.iterator(); iterator.hasNext();) {
/* 1098 */                 if ((phasedHtmlNodeRenderer = iterator.next()).getHtmlConverterPhases().contains(htmlConverterPhase)) {
/* 1099 */                   param1HtmlNodeConverterSubContext.myRenderingNode = param1Node;
/* 1100 */                   phasedHtmlNodeRenderer.renderDocument(param1HtmlNodeConverterSubContext, (LineAppendable)param1HtmlNodeConverterSubContext.markdown, (Document)param1Node, htmlConverterPhase);
/* 1101 */                   param1HtmlNodeConverterSubContext.myRenderingNode = null;
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           }  b++;
/*      */         }  return;
/*      */       } 
/*      */       HtmlNodeRendererHandler htmlNodeRendererHandler;
/* 1109 */       if ((htmlNodeRendererHandler = this.renderers.get(param1Node.nodeName().toLowerCase())) == null) {
/* 1110 */         htmlNodeRendererHandler = this.renderers.get("");
/*      */       }
/*      */       
/* 1113 */       if (htmlNodeRendererHandler != null) {
/* 1114 */         Node node = this.myRenderingNode;
/* 1115 */         param1HtmlNodeConverterSubContext.myRenderingNode = param1Node;
/* 1116 */         htmlNodeRendererHandler.render(param1Node, param1HtmlNodeConverterSubContext, param1HtmlNodeConverterSubContext.markdown);
/* 1117 */         param1HtmlNodeConverterSubContext.myRenderingNode = node;
/*      */         return;
/*      */       } 
/* 1120 */       throw new IllegalStateException("Core Node Formatter should implement generic empty tag renderer");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void renderChildren(Node param1Node, boolean param1Boolean, Runnable param1Runnable) {
/* 1127 */       FlexmarkHtmlConverter.processHtmlTree(this, param1Node, param1Boolean, param1Runnable);
/*      */     }
/*      */ 
/*      */     
/*      */     public void pushState(Node param1Node) {
/* 1132 */       this.myStateStack.push(this.myState);
/* 1133 */       this.myState = new HtmlConverterState(param1Node);
/* 1134 */       processAttributes(param1Node);
/*      */     }
/*      */ 
/*      */     
/*      */     public void excludeAttributes(String... param1VarArgs) {
/* 1139 */       assert this.myState != null; int i; byte b;
/* 1140 */       for (i = (param1VarArgs = param1VarArgs).length, b = 0; b < i; ) { String str = param1VarArgs[b];
/* 1141 */         this.myState.myAttributes.remove(str);
/*      */         b++; }
/*      */     
/*      */     }
/*      */     
/*      */     public void processAttributes(Node param1Node) {
/* 1147 */       assert this.myState != null;
/* 1148 */       MutableAttributes mutableAttributes = this.myState.myAttributes;
/*      */       
/* 1150 */       if (this.myHtmlConverterOptions.outputAttributesIdAttr || !this.myHtmlConverterOptions.outputAttributesNamesRegex.isEmpty()) {
/* 1151 */         Attributes attributes = param1Node.attributes();
/* 1152 */         boolean bool = false;
/* 1153 */         if (this.myHtmlConverterOptions.outputAttributesIdAttr) {
/*      */           String str;
/* 1155 */           if ((str = attributes.get("id")) == null || str.isEmpty()) {
/* 1156 */             str = attributes.get("name");
/*      */           }
/*      */           
/* 1159 */           if (str != null && !str.isEmpty()) {
/* 1160 */             mutableAttributes.replaceValue("id", str);
/* 1161 */             bool = true;
/*      */           } 
/*      */         } 
/*      */         
/* 1165 */         if (!this.myHtmlConverterOptions.outputAttributesNamesRegex.isEmpty()) {
/* 1166 */           for (Attribute attribute : attributes) {
/* 1167 */             if (!bool || (!attribute.getKey().equals("id") && !attribute.getKey().equals("name")))
/*      */             {
/*      */               
/* 1170 */               if (attribute.getKey().matches(this.myHtmlConverterOptions.outputAttributesNamesRegex)) {
/* 1171 */                 mutableAttributes.replaceValue(attribute.getKey(), attribute.getValue());
/*      */               }
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     public int outputAttributes(LineAppendable param1LineAppendable, String param1String) {
/* 1180 */       assert this.myState != null;
/* 1181 */       MutableAttributes mutableAttributes = this.myState.myAttributes;
/* 1182 */       int i = param1LineAppendable.offsetWithPending();
/*      */       
/* 1184 */       if (!mutableAttributes.isEmpty() && !this.myHtmlConverterOptions.skipAttributes) {
/*      */         
/* 1186 */         String str = "";
/* 1187 */         param1LineAppendable.append(param1String);
/* 1188 */         param1LineAppendable.append("{");
/*      */         
/* 1190 */         for (String str1 : mutableAttributes.keySet()) {
/* 1191 */           Matcher matcher; String str2 = mutableAttributes.getValue(str1);
/* 1192 */           param1LineAppendable.append(str);
/*      */           
/* 1194 */           if (str1.equals("id") || str1.equals("name")) {
/*      */             
/* 1196 */             boolean bool = false;
/* 1197 */             if (!this.myHtmlConverterOptions.outputIdAttributeRegex.isEmpty() && (
/*      */               
/* 1199 */               matcher = this.myHtmlConverterOptions.outputIdAttributeRegexPattern.matcher(str2)).matches()) {
/* 1200 */               StringBuilder stringBuilder = new StringBuilder();
/* 1201 */               int j = matcher.groupCount();
/* 1202 */               for (byte b = 0; b < j; b++) {
/*      */                 String str3;
/* 1204 */                 if ((str3 = matcher.group(b + 1)) != null && !str3.isEmpty()) {
/* 1205 */                   stringBuilder.append(str3);
/*      */                 }
/*      */               } 
/*      */ 
/*      */               
/* 1210 */               bool = (str2 = stringBuilder.toString().trim()).isEmpty();
/*      */             } 
/*      */ 
/*      */             
/* 1214 */             if (!bool) {
/* 1215 */               param1LineAppendable.append("#").append(str2);
/*      */             }
/* 1217 */           } else if (matcher.equals("class")) {
/* 1218 */             param1LineAppendable.append(".").append(str2);
/*      */           } else {
/* 1220 */             param1LineAppendable.append((CharSequence)matcher).append("=");
/*      */             
/* 1222 */             if (!str2.contains("\"")) {
/* 1223 */               param1LineAppendable.append('"').append(str2).append('"');
/* 1224 */             } else if (!str2.contains("'")) {
/* 1225 */               param1LineAppendable.append('\'').append(str2).append('\'');
/*      */             } else {
/* 1227 */               param1LineAppendable.append('"').append(str2.replace("\"", "\\\"")).append('"');
/*      */             } 
/*      */           } 
/*      */           
/* 1231 */           str = " ";
/*      */         } 
/* 1233 */         param1LineAppendable.append("}");
/* 1234 */         this.myState.myAttributes.clear();
/*      */       } 
/*      */       
/* 1237 */       return param1LineAppendable.offsetWithPending() - i;
/*      */     }
/*      */ 
/*      */     
/*      */     public void transferIdToParent() {
/* 1242 */       assert this.myState != null;
/* 1243 */       if (this.myStateStack.isEmpty())
/* 1244 */         throw new IllegalStateException("transferIdToParent with an empty stack"); 
/* 1245 */       Attribute attribute = this.myState.myAttributes.get("id");
/* 1246 */       this.myState.myAttributes.remove("id"); HtmlConverterState htmlConverterState;
/* 1247 */       if (attribute != null && !attribute.getValue().isEmpty() && (
/*      */         
/* 1249 */         htmlConverterState = this.myStateStack.peek()) != null) {
/* 1250 */         htmlConverterState.myAttributes.addValue("id", attribute.getValue());
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void transferToParentExcept(String... param1VarArgs) {
/* 1257 */       assert this.myState != null;
/* 1258 */       if (this.myStateStack.isEmpty())
/* 1259 */         throw new IllegalStateException("transferIdToParent with an empty stack"); 
/* 1260 */       MutableAttributes mutableAttributes = new MutableAttributes((Attributes)this.myState.myAttributes);
/* 1261 */       this.myState.myAttributes.clear(); int i;
/*      */       byte b;
/* 1263 */       for (i = (param1VarArgs = param1VarArgs).length, b = 0; b < i; ) { String str = param1VarArgs[b];
/* 1264 */         this.myState.myAttributes.addValue(mutableAttributes.get(str));
/* 1265 */         mutableAttributes.remove(str);
/*      */         b++; }
/*      */       
/* 1268 */       if (!mutableAttributes.isEmpty()) {
/* 1269 */         HtmlConverterState htmlConverterState = this.myStateStack.peek();
/* 1270 */         for (String str : mutableAttributes.keySet()) {
/* 1271 */           htmlConverterState.myAttributes.addValue(mutableAttributes.get(str));
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void transferToParentOnly(String... param1VarArgs) {
/* 1278 */       assert this.myState != null;
/* 1279 */       if (this.myStateStack.isEmpty())
/* 1280 */         throw new IllegalStateException("transferIdToParent with an empty stack"); 
/* 1281 */       MutableAttributes mutableAttributes = new MutableAttributes(); int i;
/*      */       byte b;
/* 1283 */       for (i = (param1VarArgs = param1VarArgs).length, b = 0; b < i; ) { String str = param1VarArgs[b];
/*      */         Attribute attribute;
/* 1285 */         if ((attribute = this.myState.myAttributes.get(str)) != null) {
/* 1286 */           this.myState.myAttributes.remove(str);
/* 1287 */           mutableAttributes.addValue(attribute);
/*      */         } 
/*      */         b++; }
/*      */       
/* 1291 */       if (!mutableAttributes.isEmpty()) {
/* 1292 */         HtmlConverterState htmlConverterState = this.myStateStack.peek();
/* 1293 */         for (String str : mutableAttributes.keySet()) {
/* 1294 */           htmlConverterState.myAttributes.addValue(mutableAttributes.get(str));
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void popState(LineAppendable param1LineAppendable) {
/* 1301 */       if (this.myStateStack.isEmpty())
/* 1302 */         throw new IllegalStateException("popState with an empty stack"); 
/* 1303 */       if (param1LineAppendable != null) outputAttributes(param1LineAppendable, ""); 
/* 1304 */       this.myState = this.myStateStack.pop();
/*      */     }
/*      */ 
/*      */     
/*      */     public Node peek() {
/* 1309 */       assert this.myState != null;
/* 1310 */       if (this.myState.myIndex < this.myState.myElements.size())
/* 1311 */         return this.myState.myElements.get(this.myState.myIndex); 
/* 1312 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public Node peek(int param1Int) {
/* 1317 */       assert this.myState != null;
/* 1318 */       if (this.myState.myIndex + param1Int >= 0 && this.myState.myIndex + param1Int < this.myState.myElements.size())
/* 1319 */         return this.myState.myElements.get(this.myState.myIndex + param1Int); 
/* 1320 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public Node next() {
/* 1325 */       assert this.myState != null;
/*      */       Node node;
/* 1327 */       if ((node = peek()) != null) this.myState.myIndex++; 
/* 1328 */       return node;
/*      */     }
/*      */ 
/*      */     
/*      */     public void skip() {
/* 1333 */       assert this.myState != null;
/*      */       Node node;
/* 1335 */       if ((node = peek()) != null) this.myState.myIndex++;
/*      */     
/*      */     }
/*      */     
/*      */     public Node next(int param1Int) {
/* 1340 */       assert this.myState != null;
/* 1341 */       if (param1Int > 0) {
/*      */         Node node;
/* 1343 */         if ((node = peek(param1Int - 1)) != null) this.myState.myIndex += param1Int; 
/* 1344 */         return node;
/*      */       } 
/* 1346 */       return peek();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void skip(int param1Int) {
/* 1352 */       assert this.myState != null; Node node;
/* 1353 */       if (param1Int > 0 && (
/*      */         
/* 1355 */         node = peek(param1Int - 1)) != null) this.myState.myIndex += param1Int;
/*      */     
/*      */     }
/*      */     
/*      */     private String dumpState() {
/* 1360 */       if (!this.myStateStack.isEmpty()) {
/* 1361 */         StringBuilder stringBuilder = new StringBuilder();
/*      */         
/* 1363 */         while (!this.myStateStack.isEmpty()) {
/* 1364 */           HtmlConverterState htmlConverterState = this.myStateStack.pop();
/* 1365 */           stringBuilder.append("\n").append((htmlConverterState == null) ? "null" : htmlConverterState.toString());
/*      */         } 
/*      */         
/* 1368 */         return stringBuilder.toString();
/*      */       } 
/* 1370 */       return "";
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void processUnwrapped(Node param1Node) {
/* 1376 */       processUnwrapped(this, param1Node);
/*      */     }
/*      */ 
/*      */     
/*      */     void processUnwrapped(HtmlNodeConverterSubContext param1HtmlNodeConverterSubContext, Node param1Node) {
/* 1381 */       FlexmarkHtmlConverter.processHtmlTree(param1HtmlNodeConverterSubContext, param1Node, false, null);
/*      */     }
/*      */ 
/*      */     
/*      */     public void processWrapped(Node param1Node, Boolean param1Boolean, boolean param1Boolean1) {
/* 1386 */       FlexmarkHtmlConverter.processWrapped(this, param1Node, param1Boolean, param1Boolean1);
/*      */     }
/*      */ 
/*      */     
/*      */     public void processTextNodes(Node param1Node, boolean param1Boolean) {
/* 1391 */       processTextNodes(param1Node, param1Boolean, (CharSequence)null, (CharSequence)null);
/*      */     }
/*      */ 
/*      */     
/*      */     public void processTextNodes(Node param1Node, boolean param1Boolean, CharSequence param1CharSequence) {
/* 1396 */       processTextNodes(param1Node, param1Boolean, param1CharSequence, param1CharSequence);
/*      */     }
/*      */ 
/*      */     
/*      */     public void processTextNodes(Node param1Node, boolean param1Boolean, CharSequence param1CharSequence1, CharSequence param1CharSequence2) {
/* 1401 */       FlexmarkHtmlConverter.processTextNodes(this, param1Node, param1Boolean, param1CharSequence1, param1CharSequence2);
/*      */     }
/*      */ 
/*      */     
/*      */     public void wrapTextNodes(Node param1Node, CharSequence param1CharSequence, boolean param1Boolean) {
/* 1406 */       FlexmarkHtmlConverter.wrapTextNodes(this, param1Node, param1CharSequence, param1Boolean);
/*      */     }
/*      */ 
/*      */     
/*      */     public String processTextNodes(Node param1Node) {
/* 1411 */       pushState(param1Node);
/*      */ 
/*      */       
/* 1414 */       HtmlNodeConverterContext htmlNodeConverterContext = getSubContext();
/*      */       
/* 1416 */       while ((param1Node = next()) != null) {
/* 1417 */         String str; if (param1Node instanceof TextNode) {
/* 1418 */           str = ((TextNode)param1Node).getWholeText();
/* 1419 */           htmlNodeConverterContext.getMarkdown().append(prepareText(str)); continue;
/* 1420 */         }  if (str instanceof Element) {
/* 1421 */           htmlNodeConverterContext.render((Node)str);
/*      */         }
/*      */       } 
/*      */       
/* 1425 */       transferIdToParent();
/* 1426 */       popState((LineAppendable)null);
/* 1427 */       return htmlNodeConverterContext.getMarkdown().toString(-1, -1);
/*      */     }
/*      */ 
/*      */     
/*      */     public void appendOuterHtml(Node param1Node) {
/* 1432 */       FlexmarkHtmlConverter.appendOuterHtml(this, param1Node);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isInlineCode() {
/* 1437 */       return this.myInlineCode;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setInlineCode(boolean param1Boolean) {
/* 1442 */       this.myInlineCode = param1Boolean;
/*      */     }
/*      */ 
/*      */     
/*      */     public void inlineCode(Runnable param1Runnable) {
/* 1447 */       boolean bool = this.myInlineCode;
/* 1448 */       this.myInlineCode = true;
/*      */       try {
/* 1450 */         param1Runnable.run(); return;
/*      */       } finally {
/* 1452 */         this.myInlineCode = bool;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public String prepareText(String param1String) {
/* 1458 */       return prepareText(param1String, this.myInlineCode);
/*      */     }
/*      */ 
/*      */     
/*      */     public String prepareText(String param1String, boolean param1Boolean) {
/* 1463 */       if (this.specialCharsPattern != null) {
/* 1464 */         Matcher matcher = this.specialCharsPattern.matcher(param1String);
/* 1465 */         int i = param1String.length();
/* 1466 */         StringBuilder stringBuilder = new StringBuilder(i << 1);
/* 1467 */         int j = 0;
/*      */         
/* 1469 */         while (matcher.find()) {
/* 1470 */           if (j < matcher.start()) {
/* 1471 */             stringBuilder.append(param1String, j, matcher.start());
/*      */           }
/*      */           
/* 1474 */           String str1 = matcher.group();
/*      */           String str2;
/* 1476 */           if ((str2 = this.mySpecialCharsMap.get(str1)) != null) {
/* 1477 */             stringBuilder.append(str2);
/*      */           } else {
/* 1479 */             stringBuilder.append(str1);
/*      */           } 
/* 1481 */           j = matcher.end();
/*      */         } 
/*      */         
/* 1484 */         if (j < i) {
/* 1485 */           stringBuilder.append(param1String, j, i);
/*      */         }
/*      */         
/* 1488 */         param1String = stringBuilder.toString();
/*      */       } 
/*      */       
/* 1491 */       if (!param1Boolean) {
/*      */         
/* 1493 */         param1String = escapeSpecialChars(param1String);
/*      */       } else {
/* 1495 */         param1String = param1String.replace(" ", " ");
/*      */       } 
/*      */       
/* 1498 */       return param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     public String escapeSpecialChars(String param1String) {
/* 1503 */       if (!this.myHtmlConverterOptions.skipCharEscape)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1512 */         param1String = (param1String = (param1String = (param1String = (param1String = (param1String = (param1String = (param1String = (param1String = param1String.replace("\\", "\\\\")).replace("*", "\\*")).replace("~", "\\~")).replace("^", "\\^")).replace("&", "\\&")).replace("<", "\\<").replace(">", "\\>")).replace("[", "\\[").replace("]", "\\]")).replace("|", "\\|").replace("`", "\\`")).replace(" ", this.myHtmlConverterOptions.nbspText);
/*      */       }
/* 1514 */       return param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     public void processConditional(ExtensionConversion param1ExtensionConversion, Node param1Node, Runnable param1Runnable) {
/* 1519 */       FlexmarkHtmlConverter.processConditional(this, param1ExtensionConversion, param1Node, param1Runnable);
/*      */     }
/*      */ 
/*      */     
/*      */     public void renderDefault(Node param1Node) {
/* 1524 */       FlexmarkHtmlConverter.processDefault(this, param1Node, (getHtmlConverterOptions()).outputUnknownTags);
/*      */     }
/*      */   }
/*      */   
/*      */   static void processTextNodes(HtmlNodeConverterContext paramHtmlNodeConverterContext, Node paramNode, boolean paramBoolean, CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 1529 */     paramHtmlNodeConverterContext.pushState(paramNode);
/*      */ 
/*      */ 
/*      */     
/* 1533 */     HtmlMarkdownWriter htmlMarkdownWriter = paramHtmlNodeConverterContext.getMarkdown();
/*      */     Node node;
/* 1535 */     while ((node = paramHtmlNodeConverterContext.next()) != null) {
/* 1536 */       String str; if (node instanceof TextNode) {
/* 1537 */         if (paramCharSequence1 != null && paramCharSequence1.length() > 0) htmlMarkdownWriter.append(paramCharSequence1); 
/* 1538 */         str = ((TextNode)node).getWholeText();
/* 1539 */         str = paramHtmlNodeConverterContext.prepareText(str);
/* 1540 */         htmlMarkdownWriter.append(str);
/* 1541 */         if (paramCharSequence2 != null && paramCharSequence2.length() > 0) htmlMarkdownWriter.append(paramCharSequence2);  continue;
/* 1542 */       }  if (str instanceof Element) {
/* 1543 */         paramHtmlNodeConverterContext.render((Node)str);
/*      */       }
/*      */     } 
/*      */     
/* 1547 */     if (paramBoolean) {
/* 1548 */       paramHtmlNodeConverterContext.excludeAttributes(new String[] { "id" });
/*      */     }
/*      */ 
/*      */     
/* 1552 */     int i = paramNode.parent().childNodeSize();
/* 1553 */     if (paramNode.parent().childNode(i - 1) == paramNode) {
/* 1554 */       paramHtmlNodeConverterContext.transferIdToParent();
/*      */     }
/* 1556 */     paramHtmlNodeConverterContext.popState((LineAppendable)htmlMarkdownWriter);
/*      */   }
/*      */   
/*      */   static void wrapTextNodes(HtmlNodeConverterContext paramHtmlNodeConverterContext, Node paramNode, CharSequence paramCharSequence, boolean paramBoolean) {
/* 1560 */     String str1 = paramHtmlNodeConverterContext.processTextNodes(paramNode);
/* 1561 */     String str2 = null;
/* 1562 */     String str3 = null;
/* 1563 */     boolean bool1 = false;
/* 1564 */     boolean bool2 = false;
/* 1565 */     HtmlMarkdownWriter htmlMarkdownWriter = paramHtmlNodeConverterContext.getMarkdown();
/*      */     
/* 1567 */     if (!str1.isEmpty() && paramBoolean) {
/* 1568 */       if ("  \t\n".indexOf(str1.charAt(0)) != -1) {
/* 1569 */         str2 = paramHtmlNodeConverterContext.prepareText(str1.substring(0, 1));
/* 1570 */         str1 = str1.substring(1);
/* 1571 */       } else if (str1.startsWith("&nbsp;")) {
/* 1572 */         str2 = "&nbsp;";
/* 1573 */         str1 = str1.substring(str2.length());
/*      */       } else {
/*      */         
/* 1576 */         bool1 = (htmlMarkdownWriter.getPendingEOL() != 0 && !htmlMarkdownWriter.isPendingSpace() && htmlMarkdownWriter.offsetWithPending() != 0 && htmlMarkdownWriter.getPendingEOL() <= 0) ? true : false;
/*      */       } 
/*      */       
/* 1579 */       if (!str1.isEmpty() && "  \t\n".indexOf(str1.charAt(str1.length() - 1)) != -1) {
/* 1580 */         str3 = paramHtmlNodeConverterContext.prepareText(str1.substring(str1.length() - 1));
/* 1581 */         str1 = str1.substring(0, str1.length() - 1);
/* 1582 */       } else if (str1.endsWith("&nbsp;")) {
/* 1583 */         str3 = "&nbsp;";
/* 1584 */         str1 = str1.substring(0, str1.length() - str3.length());
/*      */       } else {
/*      */         
/* 1587 */         Node node = paramHtmlNodeConverterContext.peek();
/* 1588 */         bool2 = true;
/*      */         String str;
/* 1590 */         if (node instanceof TextNode && 
/*      */           
/* 1592 */           !(str = ((TextNode)node).getWholeText()).isEmpty() && Character.isWhitespace(str.charAt(0))) {
/* 1593 */           bool2 = false;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1599 */     if (!str1.isEmpty()) {
/*      */       
/* 1601 */       int i = str1.length() - 1;
/* 1602 */       for (; i >= 0 && Character.isWhitespace(str1.charAt(i)); i--);
/* 1603 */       i++;
/*      */       
/* 1605 */       if (i > 0) {
/* 1606 */         if (str2 != null) htmlMarkdownWriter.append(str2); 
/* 1607 */         if (bool1) htmlMarkdownWriter.append(' ');
/*      */         
/* 1609 */         str1 = str1.substring(0, i);
/* 1610 */         htmlMarkdownWriter.append(paramCharSequence);
/* 1611 */         htmlMarkdownWriter.append(str1);
/* 1612 */         htmlMarkdownWriter.append(paramCharSequence);
/*      */         
/* 1614 */         if (str3 != null) htmlMarkdownWriter.append(str3); 
/* 1615 */         if (bool2) htmlMarkdownWriter.append(' '); 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   static void processConditional(HtmlNodeConverterContext paramHtmlNodeConverterContext, ExtensionConversion paramExtensionConversion, Node paramNode, Runnable paramRunnable) {
/* 1621 */     if (paramExtensionConversion.isParsed()) {
/* 1622 */       if (!paramExtensionConversion.isSuppressed()) {
/* 1623 */         paramRunnable.run(); return;
/*      */       } 
/*      */     } else {
/* 1626 */       paramHtmlNodeConverterContext.processWrapped(paramNode, null, true);
/*      */     } 
/*      */   }
/*      */   
/*      */   static void appendOuterHtml(HtmlNodeConverterSubContext paramHtmlNodeConverterSubContext, Node paramNode) {
/*      */     String str;
/* 1632 */     int i = (str = paramNode.outerHtml()).indexOf(">");
/* 1633 */     int j = str.lastIndexOf("</");
/* 1634 */     if (i != -1 && j != -1) {
/* 1635 */       paramHtmlNodeConverterSubContext.markdown.append(str.substring(0, i + 1));
/*      */       
/*      */       int k;
/* 1638 */       if ((k = paramNode.childNodeSize()) > 0) {
/* 1639 */         for (i = 0; i < k; i++) {
/* 1640 */           appendOuterHtml(paramHtmlNodeConverterSubContext, paramNode.childNode(i));
/*      */         }
/*      */       } else {
/*      */         
/* 1644 */         paramHtmlNodeConverterSubContext.markdown.append(paramHtmlNodeConverterSubContext.escapeSpecialChars(str.substring(i + 1, j)));
/*      */       } 
/* 1646 */       paramHtmlNodeConverterSubContext.markdown.append(str.substring(j)); return;
/*      */     } 
/* 1648 */     if (i == -1) {
/* 1649 */       paramHtmlNodeConverterSubContext.markdown.append(paramHtmlNodeConverterSubContext.escapeSpecialChars(str));
/*      */       return;
/*      */     } 
/* 1652 */     paramHtmlNodeConverterSubContext.markdown.append(str);
/*      */   }
/*      */   
/*      */   public static void processWrapped(HtmlNodeConverterSubContext paramHtmlNodeConverterSubContext, Node paramNode, Boolean paramBoolean, boolean paramBoolean1) {
/*      */     int i;
/*      */     String str;
/* 1658 */     if (paramNode instanceof Element && ((paramBoolean == null && ((Element)paramNode).isBlock()) || (paramBoolean != null && paramBoolean.booleanValue()))) {
/*      */       
/* 1660 */       int j = (str = paramNode.toString()).indexOf(">");
/* 1661 */       ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlNodeConverterSubContext.markdown.lineIf((paramBoolean != null))).append(str.substring(0, j + 1))).lineIf((paramBoolean != null));
/*      */       
/* 1663 */       processHtmlTree(paramHtmlNodeConverterSubContext, paramNode, false, null);
/*      */       
/* 1665 */       i = str.lastIndexOf("<");
/* 1666 */       ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlNodeConverterSubContext.markdown.lineIf((paramBoolean != null))).append(str.substring(i))).lineIf((paramBoolean != null)); return;
/*      */     } 
/* 1668 */     if (str != null) {
/* 1669 */       appendOuterHtml(paramHtmlNodeConverterSubContext, i); return;
/*      */     } 
/* 1671 */     paramHtmlNodeConverterSubContext.markdown.append(i.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static void processHtmlTree(HtmlNodeConverterSubContext paramHtmlNodeConverterSubContext, Node paramNode, boolean paramBoolean, Runnable paramRunnable) {
/* 1677 */     paramHtmlNodeConverterSubContext.pushState(paramNode);
/* 1678 */     HtmlConverterState htmlConverterState = paramHtmlNodeConverterSubContext.getState();
/* 1679 */     assert htmlConverterState != null;
/*      */     
/* 1681 */     if (paramRunnable != null) {
/* 1682 */       htmlConverterState.addPrePopAction(paramRunnable);
/*      */     }
/*      */     
/*      */     Node node;
/*      */     
/* 1687 */     while ((node = paramHtmlNodeConverterSubContext.next()) != null) {
/* 1688 */       paramHtmlNodeConverterSubContext.render(node);
/*      */     }
/*      */     
/* 1691 */     if (htmlConverterState != paramHtmlNodeConverterSubContext.getState()) {
/* 1692 */       throw new IllegalStateException("State not equal after process " + dumpState(paramHtmlNodeConverterSubContext));
/*      */     }
/*      */     
/* 1695 */     htmlConverterState.runPrePopActions();
/* 1696 */     paramHtmlNodeConverterSubContext.popState(paramBoolean ? (LineAppendable)paramHtmlNodeConverterSubContext.markdown : null);
/*      */   }
/*      */ 
/*      */   
/*      */   static String dumpState(HtmlNodeConverterContext paramHtmlNodeConverterContext) {
/*      */     Stack<HtmlConverterState> stack;
/* 1702 */     if (!(stack = paramHtmlNodeConverterContext.getStateStack()).isEmpty()) {
/* 1703 */       StringBuilder stringBuilder = new StringBuilder();
/*      */       
/* 1705 */       while (!stack.isEmpty()) {
/* 1706 */         HtmlConverterState htmlConverterState = stack.pop();
/* 1707 */         stringBuilder.append("\n").append((htmlConverterState == null) ? "null" : htmlConverterState.toString());
/*      */       } 
/*      */       
/* 1710 */       return stringBuilder.toString();
/*      */     } 
/* 1712 */     return "";
/*      */   }
/*      */   
/*      */   static void processDefault(HtmlNodeConverterSubContext paramHtmlNodeConverterSubContext, Node paramNode, boolean paramBoolean) {
/* 1716 */     if (paramBoolean) {
/* 1717 */       paramHtmlNodeConverterSubContext.processWrapped(paramNode, null, false); return;
/*      */     } 
/* 1719 */     paramHtmlNodeConverterSubContext.processUnwrapped(paramNode);
/*      */   }
/*      */   
/*      */   public static interface HtmlConverterExtension extends Extension {
/*      */     void rendererOptions(MutableDataHolder param1MutableDataHolder);
/*      */     
/*      */     void extend(FlexmarkHtmlConverter.Builder param1Builder);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\FlexmarkHtmlConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */