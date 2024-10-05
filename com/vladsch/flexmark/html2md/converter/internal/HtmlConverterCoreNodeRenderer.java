/*      */ package com.vladsch.flexmark.html2md.converter.internal;
/*      */ import com.vladsch.flexmark.ast.Reference;
/*      */ import com.vladsch.flexmark.ast.util.ReferenceRepository;
/*      */ import com.vladsch.flexmark.ext.emoji.internal.EmojiReference;
/*      */ import com.vladsch.flexmark.html2md.converter.HtmlConverterPhase;
/*      */ import com.vladsch.flexmark.html2md.converter.HtmlMarkdownWriter;
/*      */ import com.vladsch.flexmark.html2md.converter.HtmlNodeConverterContext;
/*      */ import com.vladsch.flexmark.html2md.converter.HtmlNodeRendererHandler;
/*      */ import com.vladsch.flexmark.html2md.converter.LinkConversion;
/*      */ import com.vladsch.flexmark.html2md.converter.ListState;
/*      */ import com.vladsch.flexmark.util.ast.Document;
/*      */ import com.vladsch.flexmark.util.data.DataHolder;
/*      */ import com.vladsch.flexmark.util.format.MarkdownTable;
/*      */ import com.vladsch.flexmark.util.format.RomanNumeral;
/*      */ import com.vladsch.flexmark.util.html.CellAlignment;
/*      */ import com.vladsch.flexmark.util.misc.Utils;
/*      */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*      */ import com.vladsch.flexmark.util.sequence.LineAppendable;
/*      */ import com.vladsch.flexmark.util.sequence.RepeatedSequence;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import org.jsoup.nodes.Comment;
/*      */ import org.jsoup.nodes.Element;
/*      */ import org.jsoup.nodes.Node;
/*      */ import org.jsoup.nodes.TextNode;
/*      */ import org.jsoup.select.Elements;
/*      */ 
/*      */ public class HtmlConverterCoreNodeRenderer implements PhasedHtmlNodeRenderer {
/*   34 */   public static final Pattern NUMERIC_DOT_LIST_PAT = Pattern.compile("^(\\d+)\\.\\s*$"); public static final String EMOJI_ALT_PREFIX = "emoji ";
/*   35 */   public static final Pattern NUMERIC_PAREN_LIST_PAT = Pattern.compile("^(\\d+)\\)\\s*$");
/*   36 */   public static final Pattern NON_NUMERIC_DOT_LIST_PAT = Pattern.compile("^((?:(?:" + RomanNumeral.ROMAN_NUMERAL.pattern() + ")|(?:" + RomanNumeral.LOWERCASE_ROMAN_NUMERAL.pattern() + ")|[a-z]+|[A-Z]+))\\.\\s*$");
/*   37 */   public static final Pattern NON_NUMERIC_PAREN_LIST_PAT = Pattern.compile("^((?:[a-z]+|[A-Z]+))\\)\\s*$");
/*   38 */   public static final Pattern BULLET_LIST_PAT = Pattern.compile("^([·])\\s*$");
/*   39 */   public static final Pattern ALPHA_NUMERAL_PAT = Pattern.compile("^[a-z]+|[A-Z]+$");
/*      */   
/*   41 */   public static HashSet<String> explicitLinkTextTags = new HashSet<>(Arrays.asList(FlexmarkHtmlConverter.EXPLICIT_LINK_TEXT_TAGS));
/*      */   
/*      */   private final HashMap<String, String> myAbbreviations;
/*      */   private final HashMap<String, String> myMacrosMap;
/*      */   private final HtmlConverterOptions myHtmlConverterOptions;
/*      */   private MarkdownTable myTable;
/*      */   private boolean myTableSuppressColumns = false;
/*      */   
/*      */   public HtmlConverterCoreNodeRenderer(DataHolder paramDataHolder) {
/*   50 */     this.myHtmlConverterOptions = new HtmlConverterOptions(paramDataHolder);
/*      */     
/*   52 */     this.myAbbreviations = new HashMap<>();
/*   53 */     this.myMacrosMap = new HashMap<>();
/*      */   }
/*      */ 
/*      */   
/*      */   public Set<HtmlConverterPhase> getHtmlConverterPhases() {
/*   58 */     return new HashSet<>(Arrays.asList(new HtmlConverterPhase[] { HtmlConverterPhase.COLLECT, HtmlConverterPhase.DOCUMENT_BOTTOM }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<HtmlNodeRendererHandler<?>> getHtmlNodeRendererHandlers()
/*      */   {
/*   66 */     HashSet<HtmlNodeRendererHandler> hashSet = new HashSet(Arrays.asList((Object[])new HtmlNodeRendererHandler[] { new HtmlNodeRendererHandler("#comment", Comment.class, this::processComment), new HtmlNodeRendererHandler("a", Element.class, this::processA), new HtmlNodeRendererHandler("abbr", Element.class, this::processAbbr), new HtmlNodeRendererHandler("aside", Element.class, this::processAside), new HtmlNodeRendererHandler("b", Element.class, this::processStrong), new HtmlNodeRendererHandler("blockquote", Element.class, this::processBlockQuote), new HtmlNodeRendererHandler("br", Element.class, this::processBr), new HtmlNodeRendererHandler("code", Element.class, this::processCode), new HtmlNodeRendererHandler("del", Element.class, this::processDel), new HtmlNodeRendererHandler("div", Element.class, this::processDiv), new HtmlNodeRendererHandler("dl", Element.class, this::processDl), new HtmlNodeRendererHandler("em", Element.class, this::processEmphasis), new HtmlNodeRendererHandler("g-emoji", Element.class, this::processEmoji), new HtmlNodeRendererHandler("h1", Element.class, this::processHeading), new HtmlNodeRendererHandler("h2", Element.class, this::processHeading), new HtmlNodeRendererHandler("h3", Element.class, this::processHeading), new HtmlNodeRendererHandler("h4", Element.class, this::processHeading), new HtmlNodeRendererHandler("h5", Element.class, this::processHeading), new HtmlNodeRendererHandler("h6", Element.class, this::processHeading), new HtmlNodeRendererHandler("hr", Element.class, this::processHr), new HtmlNodeRendererHandler("i", Element.class, this::processEmphasis), new HtmlNodeRendererHandler("img", Element.class, this::processImg), new HtmlNodeRendererHandler("input", Element.class, this::processInput), new HtmlNodeRendererHandler("ins", Element.class, this::processIns), new HtmlNodeRendererHandler("li", Element.class, this::processLi), new HtmlNodeRendererHandler("math", Element.class, this::processMath), new HtmlNodeRendererHandler("ol", Element.class, this::processOl), new HtmlNodeRendererHandler("p", Element.class, this::processP), new HtmlNodeRendererHandler("pre", Element.class, this::processPre), new HtmlNodeRendererHandler("span", Element.class, this::processSpan), new HtmlNodeRendererHandler("strike", Element.class, this::processDel), new HtmlNodeRendererHandler("strong", Element.class, this::processStrong), new HtmlNodeRendererHandler("sub", Element.class, this::processSub), new HtmlNodeRendererHandler("sup", Element.class, this::processSup), new HtmlNodeRendererHandler("svg", Element.class, this::processSvg), new HtmlNodeRendererHandler("table", Element.class, this::processTable), new HtmlNodeRendererHandler("u", Element.class, this::processIns), new HtmlNodeRendererHandler("ul", Element.class, this::processUl), new HtmlNodeRendererHandler("#text", TextNode.class, this::processText), new HtmlNodeRendererHandler("", Node.class, this::processDefault) }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  112 */     if (this.myHtmlConverterOptions.unwrappedTags.length > 0) {
/*  113 */       String[] arrayOfString; int i; byte b; for (i = (arrayOfString = this.myHtmlConverterOptions.unwrappedTags).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*  114 */         hashSet.add(new HtmlNodeRendererHandler(str, Node.class, this::processUnwrapped));
/*      */         b++; }
/*      */     
/*      */     } 
/*  118 */     if (this.myHtmlConverterOptions.wrappedTags.length > 0) {
/*  119 */       String[] arrayOfString; int i; byte b; for (i = (arrayOfString = this.myHtmlConverterOptions.wrappedTags).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*  120 */         hashSet.add(new HtmlNodeRendererHandler(str, Node.class, this::processWrapped));
/*      */         b++; }
/*      */     
/*      */     } 
/*  124 */     return (Set)hashSet; } public void renderDocument(HtmlNodeConverterContext paramHtmlNodeConverterContext, LineAppendable paramLineAppendable, Document paramDocument, HtmlConverterPhase paramHtmlConverterPhase) {
/*      */     HashSet<Reference> hashSet;
/*      */     Document document;
/*      */     HashMap<?, ?> hashMap;
/*      */     ReferenceRepository referenceRepository;
/*  129 */     switch (paramHtmlConverterPhase) {
/*      */ 
/*      */ 
/*      */       
/*      */       case COLLECT:
/*  134 */         if ((document = paramHtmlNodeConverterContext.getForDocument()) != null && (
/*      */           
/*  136 */           referenceRepository = (ReferenceRepository)Parser.REFERENCES.get((DataHolder)document)) != null) {
/*  137 */           HashMap<String, Reference> hashMap1 = paramHtmlNodeConverterContext.getReferenceUrlToReferenceMap();
/*  138 */           hashSet = paramHtmlNodeConverterContext.getExternalReferences();
/*      */           
/*  140 */           for (Reference reference : referenceRepository.getValues()) {
/*  141 */             hashMap1.put(reference.getUrl().toString(), reference);
/*  142 */             hashMap1.put(reference.getReference().toString(), reference);
/*  143 */             hashSet.add(reference);
/*      */           } 
/*      */         } 
/*      */         return;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case DOCUMENT_BOTTOM:
/*  152 */         if (!this.myAbbreviations.isEmpty()) {
/*  153 */           reference.blankLine();
/*  154 */           for (Map.Entry<String, String> entry : this.myAbbreviations.entrySet()) {
/*  155 */             reference.line().append("*[").append((CharSequence)entry.getKey()).append("]: ").append((CharSequence)entry.getValue()).line();
/*      */           }
/*  157 */           reference.blankLine();
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  162 */         if (!(hashMap = hashSet.getReferenceUrlToReferenceMap()).isEmpty()) {
/*  163 */           boolean bool = true;
/*  164 */           HashSet hashSet1 = hashSet.getExternalReferences();
/*  165 */           for (Map.Entry<?, ?> entry : hashMap.entrySet()) {
/*  166 */             if (!hashSet1.contains(entry.getValue())) {
/*  167 */               if (bool) {
/*  168 */                 bool = false;
/*  169 */                 reference.blankLine();
/*      */               } 
/*  171 */               reference.line().append((CharSequence)((Reference)entry.getValue()).getChars()).line();
/*      */             } 
/*      */           } 
/*      */           
/*  175 */           if (!bool) {
/*  176 */             reference.blankLine();
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  181 */         if (!this.myMacrosMap.isEmpty()) {
/*  182 */           for (Map.Entry<String, String> entry : this.myMacrosMap.entrySet()) {
/*  183 */             reference.blankLine();
/*  184 */             reference.append(">>>").append((CharSequence)entry.getKey()).line();
/*      */             CharSequence charSequence;
/*  186 */             BasedSequence basedSequence = BasedSequence.of(charSequence = (CharSequence)entry.getValue());
/*  187 */             reference.append((CharSequence)basedSequence.trimEnd()).append("\n");
/*  188 */             reference.append("<<<\n");
/*  189 */             reference.blankLine();
/*      */           } 
/*      */         }
/*      */         break;
/*      */     } 
/*      */   }
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
/*      */   public static int getMaxRepeatedChars(CharSequence paramCharSequence, char paramChar, int paramInt) {
/*  206 */     BasedSequence basedSequence = BasedSequence.of(paramCharSequence);
/*  207 */     int i = 0;
/*  208 */     while (i < basedSequence.length() && (
/*      */       
/*  210 */       i = basedSequence.indexOf(paramChar, i)) >= 0) {
/*  211 */       int j = basedSequence.countLeading(paramInt -> (paramInt == paramChar), i);
/*  212 */       if (paramInt <= j) paramInt = j + 1; 
/*  213 */       i += j;
/*      */     } 
/*  215 */     return paramInt;
/*      */   }
/*      */   
/*      */   public static boolean hasChildrenOfType(Element paramElement, Set<String> paramSet) {
/*  219 */     for (Node node : paramElement.children()) {
/*  220 */       if (paramSet.contains(node.nodeName().toLowerCase())) return true; 
/*      */     } 
/*  222 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean isFirstChild(Element paramElement) {
/*  226 */     for (Iterator<Node> iterator = paramElement.parent().childNodes().iterator(); iterator.hasNext(); ) {
/*  227 */       Node node; if (node = iterator.next() instanceof Element)
/*  228 */         return (paramElement == node); 
/*  229 */       if (!node.nodeName().equals("#text") || node.outerHtml().trim().isEmpty());
/*      */     } 
/*      */ 
/*      */     
/*  233 */     return false;
/*      */   }
/*      */   
/*      */   public static boolean isLastChild(Element paramElement) {
/*      */     Elements elements;
/*  238 */     int i = (elements = paramElement.parent().children()).size();
/*  239 */     while (i-- > 0) {
/*      */       Node node;
/*  241 */       if (node = (Node)elements.get(i) instanceof Element) {
/*  242 */         return (paramElement == node);
/*      */       }
/*      */     } 
/*  245 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void processDefault(Node paramNode, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  251 */     paramHtmlNodeConverterContext.renderDefault(paramNode);
/*      */   }
/*      */   
/*      */   private boolean isHeading(Element paramElement) {
/*  255 */     if (paramElement != null) {
/*  256 */       String str = paramElement.tagName().toLowerCase(); String[] arrayOfString; int i; byte b;
/*  257 */       for (i = (arrayOfString = FlexmarkHtmlConverter.HEADING_NODES).length, b = 0; b < i; ) { String str1 = arrayOfString[b];
/*  258 */         if (str.equals(str1)) return true;  b++; }
/*      */     
/*      */     } 
/*  261 */     return false;
/*      */   }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void processA(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ldc 'href'
/*      */     //   3: invokevirtual hasAttr : (Ljava/lang/String;)Z
/*      */     //   6: ifeq -> 696
/*      */     //   9: aload_0
/*      */     //   10: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */     //   13: getfield extInlineLink : Lcom/vladsch/flexmark/html2md/converter/LinkConversion;
/*      */     //   16: dup
/*      */     //   17: astore #4
/*      */     //   19: invokevirtual isSuppressed : ()Z
/*      */     //   22: ifeq -> 26
/*      */     //   25: return
/*      */     //   26: aload_1
/*      */     //   27: ldc 'href'
/*      */     //   29: invokevirtual attr : (Ljava/lang/String;)Ljava/lang/String;
/*      */     //   32: astore #5
/*      */     //   34: aload_2
/*      */     //   35: getstatic com/vladsch/flexmark/html/renderer/LinkType.LINK : Lcom/vladsch/flexmark/html/renderer/LinkType;
/*      */     //   38: aload #5
/*      */     //   40: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
/*      */     //   43: invokeinterface resolveLink : (Lcom/vladsch/flexmark/html/renderer/LinkType;Ljava/lang/CharSequence;Ljava/lang/Boolean;)Lcom/vladsch/flexmark/html/renderer/ResolvedLink;
/*      */     //   48: dup
/*      */     //   49: astore #6
/*      */     //   51: invokevirtual getUrl : ()Ljava/lang/String;
/*      */     //   54: astore #6
/*      */     //   56: aload_3
/*      */     //   57: invokevirtual isPreFormatted : ()Z
/*      */     //   60: ifeq -> 145
/*      */     //   63: aload #6
/*      */     //   65: bipush #47
/*      */     //   67: invokevirtual lastIndexOf : (I)I
/*      */     //   70: dup
/*      */     //   71: istore #7
/*      */     //   73: iconst_m1
/*      */     //   74: if_icmpeq -> 135
/*      */     //   77: aload #6
/*      */     //   79: bipush #35
/*      */     //   81: iload #7
/*      */     //   83: invokevirtual indexOf : (II)I
/*      */     //   86: dup
/*      */     //   87: istore #8
/*      */     //   89: iconst_m1
/*      */     //   90: if_icmpeq -> 135
/*      */     //   93: iload #7
/*      */     //   95: iconst_1
/*      */     //   96: iadd
/*      */     //   97: iload #8
/*      */     //   99: if_icmpne -> 135
/*      */     //   102: new java/lang/StringBuilder
/*      */     //   105: dup
/*      */     //   106: invokespecial <init> : ()V
/*      */     //   109: aload #6
/*      */     //   111: iconst_0
/*      */     //   112: iload #7
/*      */     //   114: invokevirtual substring : (II)Ljava/lang/String;
/*      */     //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   120: aload #6
/*      */     //   122: iload #8
/*      */     //   124: invokevirtual substring : (I)Ljava/lang/String;
/*      */     //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   130: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   133: astore #6
/*      */     //   135: aload_3
/*      */     //   136: aload #6
/*      */     //   138: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   141: pop
/*      */     //   142: goto -> 733
/*      */     //   145: aload #4
/*      */     //   147: invokevirtual isParsed : ()Z
/*      */     //   150: ifeq -> 678
/*      */     //   153: aload_2
/*      */     //   154: aload_1
/*      */     //   155: invokeinterface pushState : (Lorg/jsoup/nodes/Node;)V
/*      */     //   160: aload_2
/*      */     //   161: aload_1
/*      */     //   162: invokeinterface processTextNodes : (Lorg/jsoup/nodes/Node;)Ljava/lang/String;
/*      */     //   167: dup
/*      */     //   168: astore #7
/*      */     //   170: invokevirtual trim : ()Ljava/lang/String;
/*      */     //   173: astore #8
/*      */     //   175: aload_1
/*      */     //   176: ldc 'title'
/*      */     //   178: invokevirtual hasAttr : (Ljava/lang/String;)Z
/*      */     //   181: ifeq -> 193
/*      */     //   184: aload_1
/*      */     //   185: ldc 'title'
/*      */     //   187: invokevirtual attr : (Ljava/lang/String;)Ljava/lang/String;
/*      */     //   190: goto -> 194
/*      */     //   193: aconst_null
/*      */     //   194: astore #7
/*      */     //   196: aload #8
/*      */     //   198: invokevirtual isEmpty : ()Z
/*      */     //   201: ifeq -> 286
/*      */     //   204: aload #6
/*      */     //   206: ldc '#'
/*      */     //   208: invokevirtual contains : (Ljava/lang/CharSequence;)Z
/*      */     //   211: ifeq -> 286
/*      */     //   214: aload_0
/*      */     //   215: aload_1
/*      */     //   216: invokevirtual parent : ()Lorg/jsoup/nodes/Element;
/*      */     //   219: invokespecial isHeading : (Lorg/jsoup/nodes/Element;)Z
/*      */     //   222: ifne -> 662
/*      */     //   225: aload #6
/*      */     //   227: ldc '#'
/*      */     //   229: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   232: ifne -> 662
/*      */     //   235: aload_2
/*      */     //   236: invokeinterface getState : ()Lcom/vladsch/flexmark/html2md/converter/HtmlConverterState;
/*      */     //   241: ifnull -> 286
/*      */     //   244: aload_2
/*      */     //   245: invokeinterface getState : ()Lcom/vladsch/flexmark/html2md/converter/HtmlConverterState;
/*      */     //   250: invokevirtual getAttributes : ()Lcom/vladsch/flexmark/util/html/Attributes;
/*      */     //   253: ldc 'id'
/*      */     //   255: invokevirtual get : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/html/Attribute;
/*      */     //   258: ifnull -> 286
/*      */     //   261: aload_2
/*      */     //   262: invokeinterface getState : ()Lcom/vladsch/flexmark/html2md/converter/HtmlConverterState;
/*      */     //   267: invokevirtual getAttributes : ()Lcom/vladsch/flexmark/util/html/Attributes;
/*      */     //   270: ldc 'id'
/*      */     //   272: invokevirtual get : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/html/Attribute;
/*      */     //   275: invokeinterface getValue : ()Ljava/lang/String;
/*      */     //   280: invokevirtual isEmpty : ()Z
/*      */     //   283: ifeq -> 662
/*      */     //   286: aload_0
/*      */     //   287: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */     //   290: getfield extractAutoLinks : Z
/*      */     //   293: ifeq -> 369
/*      */     //   296: aload #5
/*      */     //   298: aload #8
/*      */     //   300: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   303: ifeq -> 369
/*      */     //   306: aload #7
/*      */     //   308: ifnull -> 319
/*      */     //   311: aload #7
/*      */     //   313: invokevirtual isEmpty : ()Z
/*      */     //   316: ifeq -> 369
/*      */     //   319: aload_0
/*      */     //   320: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */     //   323: getfield wrapAutoLinks : Z
/*      */     //   326: ifeq -> 336
/*      */     //   329: aload_3
/*      */     //   330: bipush #60
/*      */     //   332: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   335: pop
/*      */     //   336: aload_3
/*      */     //   337: aload #6
/*      */     //   339: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   342: pop
/*      */     //   343: aload_0
/*      */     //   344: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */     //   347: getfield wrapAutoLinks : Z
/*      */     //   350: ifeq -> 360
/*      */     //   353: aload_3
/*      */     //   354: bipush #62
/*      */     //   356: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   359: pop
/*      */     //   360: aload_2
/*      */     //   361: invokeinterface transferIdToParent : ()V
/*      */     //   366: goto -> 632
/*      */     //   369: aload #4
/*      */     //   371: invokevirtual isTextOnly : ()Z
/*      */     //   374: ifne -> 605
/*      */     //   377: aload #6
/*      */     //   379: ldc 'javascript:'
/*      */     //   381: invokevirtual startsWith : (Ljava/lang/String;)Z
/*      */     //   384: ifne -> 605
/*      */     //   387: iconst_0
/*      */     //   388: istore #5
/*      */     //   390: aload #4
/*      */     //   392: invokevirtual isReference : ()Z
/*      */     //   395: ifeq -> 507
/*      */     //   398: aload_1
/*      */     //   399: getstatic com/vladsch/flexmark/html2md/converter/internal/HtmlConverterCoreNodeRenderer.explicitLinkTextTags : Ljava/util/HashSet;
/*      */     //   402: invokestatic hasChildrenOfType : (Lorg/jsoup/nodes/Element;Ljava/util/Set;)Z
/*      */     //   405: ifne -> 507
/*      */     //   408: aload_2
/*      */     //   409: aload #6
/*      */     //   411: aload #8
/*      */     //   413: aload #7
/*      */     //   415: invokeinterface getOrCreateReference : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/vladsch/flexmark/ast/Reference;
/*      */     //   420: dup
/*      */     //   421: astore_1
/*      */     //   422: ifnull -> 507
/*      */     //   425: iconst_1
/*      */     //   426: istore #5
/*      */     //   428: aload_1
/*      */     //   429: invokevirtual getReference : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   432: aload #8
/*      */     //   434: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   437: ifeq -> 466
/*      */     //   440: aload_3
/*      */     //   441: bipush #91
/*      */     //   443: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   446: checkcast com/vladsch/flexmark/html2md/converter/HtmlMarkdownWriter
/*      */     //   449: aload #8
/*      */     //   451: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   454: checkcast com/vladsch/flexmark/html2md/converter/HtmlMarkdownWriter
/*      */     //   457: ldc '][]'
/*      */     //   459: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   462: pop
/*      */     //   463: goto -> 507
/*      */     //   466: aload_3
/*      */     //   467: bipush #91
/*      */     //   469: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   472: checkcast com/vladsch/flexmark/html2md/converter/HtmlMarkdownWriter
/*      */     //   475: aload #8
/*      */     //   477: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   480: checkcast com/vladsch/flexmark/html2md/converter/HtmlMarkdownWriter
/*      */     //   483: ldc ']['
/*      */     //   485: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   488: checkcast com/vladsch/flexmark/html2md/converter/HtmlMarkdownWriter
/*      */     //   491: aload_1
/*      */     //   492: invokevirtual getReference : ()Lcom/vladsch/flexmark/util/sequence/BasedSequence;
/*      */     //   495: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   498: checkcast com/vladsch/flexmark/html2md/converter/HtmlMarkdownWriter
/*      */     //   501: bipush #93
/*      */     //   503: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   506: pop
/*      */     //   507: iload #5
/*      */     //   509: ifne -> 602
/*      */     //   512: aload_3
/*      */     //   513: bipush #91
/*      */     //   515: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   518: pop
/*      */     //   519: aload_3
/*      */     //   520: aload #8
/*      */     //   522: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   525: pop
/*      */     //   526: aload_3
/*      */     //   527: bipush #93
/*      */     //   529: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   532: pop
/*      */     //   533: aload_3
/*      */     //   534: bipush #40
/*      */     //   536: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   539: checkcast com/vladsch/flexmark/html2md/converter/HtmlMarkdownWriter
/*      */     //   542: aload #6
/*      */     //   544: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   547: pop
/*      */     //   548: aload #7
/*      */     //   550: ifnull -> 595
/*      */     //   553: aload_3
/*      */     //   554: ldc ' "'
/*      */     //   556: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   559: checkcast com/vladsch/flexmark/html2md/converter/HtmlMarkdownWriter
/*      */     //   562: aload #7
/*      */     //   564: ldc '\\n'
/*      */     //   566: aload_0
/*      */     //   567: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */     //   570: getfield eolInTitleAttribute : Ljava/lang/String;
/*      */     //   573: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
/*      */     //   576: ldc '"'
/*      */     //   578: ldc '\"'
/*      */     //   580: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
/*      */     //   583: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   586: checkcast com/vladsch/flexmark/html2md/converter/HtmlMarkdownWriter
/*      */     //   589: bipush #34
/*      */     //   591: invokevirtual append : (C)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   594: pop
/*      */     //   595: aload_3
/*      */     //   596: ldc ')'
/*      */     //   598: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   601: pop
/*      */     //   602: goto -> 632
/*      */     //   605: aload #5
/*      */     //   607: aload #8
/*      */     //   609: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   612: ifeq -> 625
/*      */     //   615: aload_3
/*      */     //   616: aload #6
/*      */     //   618: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   621: pop
/*      */     //   622: goto -> 632
/*      */     //   625: aload_3
/*      */     //   626: aload #8
/*      */     //   628: invokevirtual append : (Ljava/lang/CharSequence;)Lcom/vladsch/flexmark/util/format/MarkdownWriterBase;
/*      */     //   631: pop
/*      */     //   632: aload_2
/*      */     //   633: iconst_2
/*      */     //   634: anewarray java/lang/String
/*      */     //   637: dup
/*      */     //   638: iconst_0
/*      */     //   639: ldc 'href'
/*      */     //   641: aastore
/*      */     //   642: dup
/*      */     //   643: iconst_1
/*      */     //   644: ldc 'title'
/*      */     //   646: aastore
/*      */     //   647: invokeinterface excludeAttributes : ([Ljava/lang/String;)V
/*      */     //   652: aload_2
/*      */     //   653: aload_3
/*      */     //   654: invokeinterface popState : (Lcom/vladsch/flexmark/util/sequence/LineAppendable;)V
/*      */     //   659: goto -> 695
/*      */     //   662: aload_2
/*      */     //   663: invokeinterface transferIdToParent : ()V
/*      */     //   668: aload_2
/*      */     //   669: aconst_null
/*      */     //   670: invokeinterface popState : (Lcom/vladsch/flexmark/util/sequence/LineAppendable;)V
/*      */     //   675: goto -> 733
/*      */     //   678: aload #4
/*      */     //   680: invokevirtual isSuppressed : ()Z
/*      */     //   683: ifne -> 695
/*      */     //   686: aload_2
/*      */     //   687: aload_1
/*      */     //   688: aconst_null
/*      */     //   689: iconst_1
/*      */     //   690: invokeinterface processWrapped : (Lorg/jsoup/nodes/Node;Ljava/lang/Boolean;Z)V
/*      */     //   695: return
/*      */     //   696: iconst_0
/*      */     //   697: istore #4
/*      */     //   699: aload_1
/*      */     //   700: invokevirtual childNodeSize : ()I
/*      */     //   703: ifne -> 724
/*      */     //   706: aload_1
/*      */     //   707: invokevirtual parent : ()Lorg/jsoup/nodes/Element;
/*      */     //   710: invokevirtual tagName : ()Ljava/lang/String;
/*      */     //   713: ldc 'body'
/*      */     //   715: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   718: ifeq -> 724
/*      */     //   721: iconst_1
/*      */     //   722: istore #4
/*      */     //   724: aload_2
/*      */     //   725: aload_1
/*      */     //   726: iload #4
/*      */     //   728: invokeinterface processTextNodes : (Lorg/jsoup/nodes/Node;Z)V
/*      */     //   733: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #266	-> 0
/*      */     //   #267	-> 9
/*      */     //   #268	-> 17
/*      */     //   #270	-> 26
/*      */     //   #271	-> 34
/*      */     //   #272	-> 49
/*      */     //   #274	-> 56
/*      */     //   #276	-> 63
/*      */     //   #277	-> 71
/*      */     //   #278	-> 77
/*      */     //   #279	-> 87
/*      */     //   #281	-> 102
/*      */     //   #284	-> 135
/*      */     //   #285	-> 142
/*      */     //   #286	-> 153
/*      */     //   #287	-> 160
/*      */     //   #288	-> 168
/*      */     //   #289	-> 175
/*      */     //   #291	-> 196
/*      */     //   #292	-> 216
/*      */     //   #293	-> 286
/*      */     //   #294	-> 319
/*      */     //   #295	-> 336
/*      */     //   #296	-> 343
/*      */     //   #297	-> 360
/*      */     //   #298	-> 369
/*      */     //   #299	-> 387
/*      */     //   #301	-> 390
/*      */     //   #303	-> 408
/*      */     //   #304	-> 421
/*      */     //   #305	-> 425
/*      */     //   #306	-> 428
/*      */     //   #307	-> 440
/*      */     //   #309	-> 466
/*      */     //   #314	-> 507
/*      */     //   #315	-> 512
/*      */     //   #316	-> 519
/*      */     //   #317	-> 526
/*      */     //   #318	-> 533
/*      */     //   #319	-> 548
/*      */     //   #320	-> 553
/*      */     //   #321	-> 595
/*      */     //   #323	-> 602
/*      */     //   #324	-> 605
/*      */     //   #325	-> 615
/*      */     //   #327	-> 625
/*      */     //   #331	-> 632
/*      */     //   #332	-> 652
/*      */     //   #334	-> 662
/*      */     //   #335	-> 668
/*      */     //   #337	-> 675
/*      */     //   #338	-> 686
/*      */     //   #340	-> 695
/*      */     //   #341	-> 696
/*      */     //   #342	-> 699
/*      */     //   #344	-> 721
/*      */     //   #347	-> 724
/*      */     //   #349	-> 733
/*      */   }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void processAbbr(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  353 */     if (paramElement.hasAttr("title")) {
/*  354 */       String str = paramHtmlNodeConverterContext.processTextNodes((Node)paramElement).trim();
/*  355 */       this.myAbbreviations.put(str, paramElement.attr("title"));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void processAside(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  360 */     if (isFirstChild(paramElement)) paramHtmlMarkdownWriter.line(); 
/*  361 */     paramHtmlMarkdownWriter.pushPrefix();
/*  362 */     paramHtmlMarkdownWriter.addPrefix("| ");
/*  363 */     paramHtmlNodeConverterContext.renderChildren((Node)paramElement, true, null);
/*  364 */     paramHtmlMarkdownWriter.line();
/*  365 */     paramHtmlMarkdownWriter.popPrefix();
/*      */   }
/*      */   
/*      */   private void processBlockQuote(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  369 */     if (isFirstChild(paramElement)) paramHtmlMarkdownWriter.line(); 
/*  370 */     paramHtmlMarkdownWriter.pushPrefix();
/*  371 */     paramHtmlMarkdownWriter.addPrefix("> ");
/*  372 */     paramHtmlNodeConverterContext.renderChildren((Node)paramElement, true, null);
/*  373 */     paramHtmlMarkdownWriter.line();
/*  374 */     paramHtmlMarkdownWriter.popPrefix();
/*      */   }
/*      */   
/*      */   private void processBr(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  378 */     if (paramHtmlMarkdownWriter.isPreFormatted()) {
/*  379 */       paramHtmlMarkdownWriter.append('\n'); return;
/*      */     } 
/*  381 */     int i = paramHtmlMarkdownWriter.getOptions();
/*  382 */     paramHtmlMarkdownWriter.setOptions(i & ((LineAppendable.F_TRIM_TRAILING_WHITESPACE | LineAppendable.F_COLLAPSE_WHITESPACE) ^ 0xFFFFFFFF));
/*  383 */     if (paramHtmlMarkdownWriter.getPendingEOL() == 0) {
/*      */       
/*  385 */       ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(' ', 2)).line();
/*      */     }
/*  387 */     else if (paramHtmlMarkdownWriter.getPendingEOL() == 1) {
/*      */       String str;
/*  389 */       if (!(str = paramHtmlMarkdownWriter.toString()).endsWith("<br />")) {
/*      */         
/*  391 */         if (this.myHtmlConverterOptions.brAsParaBreaks) {
/*  392 */           paramHtmlMarkdownWriter.blankLine();
/*      */         
/*      */         }
/*      */       }
/*  396 */       else if (this.myHtmlConverterOptions.brAsExtraBlankLines) {
/*  397 */         ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append("<br />")).blankLine();
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  402 */     else if (this.myHtmlConverterOptions.brAsExtraBlankLines) {
/*  403 */       ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append("<br />")).blankLine();
/*      */     } 
/*      */ 
/*      */     
/*  407 */     paramHtmlMarkdownWriter.setOptions(i);
/*      */   }
/*      */ 
/*      */   
/*      */   private void processCode(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  412 */     paramHtmlNodeConverterContext.processConditional(this.myHtmlConverterOptions.extInlineCode, (Node)paramElement, () -> {
/*      */           BasedSequence basedSequence;
/*      */           String str;
/*      */           int i = getMaxRepeatedChars((CharSequence)(basedSequence = BasedSequence.of(str = paramElement.ownText())), '`', 1);
/*      */           CharSequence charSequence = RepeatedSequence.repeatOf("`", i);
/*      */           paramHtmlNodeConverterContext.inlineCode(());
/*      */         });
/*      */   }
/*      */   
/*      */   private void processDel(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  422 */     paramHtmlNodeConverterContext.processConditional(this.myHtmlConverterOptions.extInlineDel, (Node)paramElement, () -> {
/*      */           // Byte code:
/*      */           //   0: aload_0
/*      */           //   1: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */           //   4: getfield preCodePreserveEmphasis : Z
/*      */           //   7: ifne -> 24
/*      */           //   10: aload_1
/*      */           //   11: invokevirtual isPreFormatted : ()Z
/*      */           //   14: ifeq -> 24
/*      */           //   17: aload_2
/*      */           //   18: aload_3
/*      */           //   19: ldc ''
/*      */           //   21: goto -> 57
/*      */           //   24: aload_2
/*      */           //   25: aload_3
/*      */           //   26: aload_0
/*      */           //   27: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */           //   30: getfield extInlineDel : Lcom/vladsch/flexmark/html2md/converter/ExtensionConversion;
/*      */           //   33: invokevirtual isTextOnly : ()Z
/*      */           //   36: ifeq -> 44
/*      */           //   39: ldc ''
/*      */           //   41: goto -> 46
/*      */           //   44: ldc '~~'
/*      */           //   46: aload_3
/*      */           //   47: invokevirtual nextElementSibling : ()Lorg/jsoup/nodes/Element;
/*      */           //   50: ifnull -> 57
/*      */           //   53: iconst_1
/*      */           //   54: goto -> 58
/*      */           //   57: iconst_0
/*      */           //   58: invokeinterface wrapTextNodes : (Lorg/jsoup/nodes/Node;Ljava/lang/CharSequence;Z)V
/*      */           //   63: return
/*      */           // Line number table:
/*      */           //   Java source line number -> byte code offset
/*      */           //   #423	-> 0
/*      */           //   #424	-> 17
/*      */           //   #426	-> 24
/*      */           //   #428	-> 63
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void handleDivTable(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  432 */     MarkdownTable markdownTable = this.myTable;
/*      */     
/*  434 */     this.myTable = new MarkdownTable("", this.myHtmlConverterOptions.tableOptions);
/*  435 */     this.myTableSuppressColumns = false;
/*      */     
/*  437 */     paramElement = paramElement; Node node;
/*      */     do {
/*  439 */       if (!paramElement.nodeName().toLowerCase().equals("div"))
/*  440 */       { if (paramElement instanceof Element) {
/*      */           break;
/*      */         } }
/*      */       else
/*      */       { Set<?> set;
/*  445 */         if ((set = paramElement.classNames()).contains("wt-data-grid__row"))
/*      */         
/*  447 */         { handleDivTableRow(paramElement, paramHtmlNodeConverterContext, paramHtmlMarkdownWriter); } else { break; }  } 
/*  448 */     } while ((node = paramHtmlNodeConverterContext.next()) != null);
/*      */     
/*  450 */     this.myTable.finalizeTable();
/*      */     
/*      */     int i;
/*  453 */     if ((i = this.myTable.getMaxColumns()) > 0) {
/*  454 */       paramHtmlMarkdownWriter.blankLine();
/*  455 */       this.myTable.appendTable((LineAppendable)paramHtmlMarkdownWriter);
/*  456 */       paramHtmlMarkdownWriter.tailBlankLine();
/*      */     } 
/*      */     
/*  459 */     this.myTable = markdownTable;
/*      */   }
/*      */   
/*      */   private void handleDivTableRow(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  463 */     paramHtmlNodeConverterContext.pushState((Node)paramElement);
/*      */     
/*  465 */     this.myTable.setHeader(hasIntersection(paramElement.classNames(), this.myHtmlConverterOptions.divTableHdrClasses));
/*      */     
/*      */     Node node;
/*  468 */     while ((node = paramHtmlNodeConverterContext.next()) != null) {
/*  469 */       if (!node.nodeName().toLowerCase().equals("div")) {
/*  470 */         if (node instanceof Element)
/*      */           break;  continue;
/*      */       } 
/*  473 */       if (hasIntersection(((Element)node).classNames(), this.myHtmlConverterOptions.divTableCellClasses))
/*      */       {
/*  475 */         handleDivTableCell((Element)node, paramHtmlNodeConverterContext, paramHtmlMarkdownWriter);
/*      */       }
/*      */     } 
/*  478 */     this.myTable.nextRow();
/*  479 */     paramHtmlNodeConverterContext.popState((LineAppendable)paramHtmlMarkdownWriter);
/*      */   }
/*      */   
/*      */   private void handleDivTableCell(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  483 */     String str = paramHtmlNodeConverterContext.processTextNodes((Node)paramElement).trim().replaceAll("\\s*\n\\s*", " ");
/*      */ 
/*      */     
/*  486 */     CellAlignment cellAlignment = CellAlignment.NONE;
/*      */ 
/*      */     
/*  489 */     if (!this.myTableSuppressColumns)
/*  490 */       this.myTable.addCell(new TableCell(null, (CharSequence)BasedSequence.NULL, str.replace("\n", " "), (CharSequence)BasedSequence.NULL, 1, 1, cellAlignment)); 
/*      */   }
/*      */   private boolean hasIntersection(Set<String> paramSet, String[] paramArrayOfString) {
/*      */     int i;
/*      */     byte b;
/*  495 */     for (i = (paramArrayOfString = paramArrayOfString).length, b = 0; b < i; ) { String str = paramArrayOfString[b];
/*  496 */       if (paramSet.contains(str)) return true;  b++; }
/*      */     
/*  498 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void processDiv(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  503 */     if (this.myHtmlConverterOptions.divTableProcessing)
/*      */     {
/*  505 */       if (hasIntersection(paramElement.classNames(), this.myHtmlConverterOptions.divTableRowClasses)) {
/*  506 */         handleDivTable(paramElement, paramHtmlNodeConverterContext, paramHtmlMarkdownWriter);
/*      */         
/*      */         return;
/*      */       } 
/*      */     }
/*  511 */     if (!isFirstChild(paramElement)) {
/*  512 */       if (!this.myHtmlConverterOptions.divAsParagraph) {
/*      */         int i;
/*  514 */         if ((i = paramHtmlMarkdownWriter.getPendingEOL()) == 0) {
/*      */           
/*  516 */           i = paramHtmlMarkdownWriter.getPendingSpace();
/*  517 */           paramHtmlMarkdownWriter.lineWithTrailingSpaces(Utils.minLimit(0, new int[] { 2 - i }));
/*  518 */         } else if (i == 1) {
/*      */           BasedSequence basedSequence;
/*      */           int j;
/*  521 */           if ((i = paramHtmlMarkdownWriter.getLineCountWithPending()) > 0 && (
/*      */ 
/*      */             
/*  524 */             j = BasedSequence.of((CharSequence)(basedSequence = paramHtmlMarkdownWriter.getLineContent(i - 1))).countTrailing(CharPredicate.SPACE_TAB)) < 2) {
/*      */             
/*  526 */             paramHtmlMarkdownWriter.removeLines(i - 1, i);
/*  527 */             paramHtmlMarkdownWriter.append((CharSequence)basedSequence);
/*  528 */             paramHtmlMarkdownWriter.lineWithTrailingSpaces(2 - j);
/*      */           } 
/*      */         } 
/*      */       } else {
/*      */         
/*  533 */         paramHtmlMarkdownWriter.blankLine();
/*      */       } 
/*      */     }
/*      */     
/*  537 */     paramHtmlNodeConverterContext.renderChildren((Node)paramElement, false, null);
/*      */     
/*  539 */     if (!isLastChild(paramElement)) {
/*  540 */       paramHtmlMarkdownWriter.line();
/*  541 */       if (this.myHtmlConverterOptions.divAsParagraph) paramHtmlMarkdownWriter.blankLine(); 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void processDl(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  546 */     paramHtmlNodeConverterContext.pushState((Node)paramElement);
/*      */ 
/*      */     
/*  549 */     boolean bool1 = true;
/*  550 */     boolean bool2 = true;
/*      */     Node node;
/*  552 */     while ((node = paramHtmlNodeConverterContext.next()) != null) {
/*  553 */       switch (node.nodeName().toLowerCase()) {
/*      */         case "dt":
/*  555 */           ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.blankLineIf(bool1)).lineIf(!bool2);
/*  556 */           paramHtmlNodeConverterContext.processTextNodes(node, false);
/*  557 */           paramHtmlMarkdownWriter.line();
/*  558 */           bool1 = false;
/*  559 */           bool2 = false;
/*      */ 
/*      */         
/*      */         case "dd":
/*  563 */           handleDefinition((Element)node, paramHtmlNodeConverterContext, paramHtmlMarkdownWriter);
/*  564 */           bool1 = true;
/*  565 */           bool2 = false;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     } 
/*  574 */     paramHtmlNodeConverterContext.popState((LineAppendable)paramHtmlMarkdownWriter);
/*      */   }
/*      */   
/*      */   private void handleDefinition(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  578 */     paramHtmlNodeConverterContext.pushState((Node)paramElement);
/*  579 */     int i = paramHtmlMarkdownWriter.getOptions();
/*  580 */     Elements elements = paramElement.children();
/*  581 */     boolean bool2 = false;
/*      */     
/*  583 */     if (!elements.isEmpty() && ((Element)elements.get(0)).tagName().equalsIgnoreCase("p")) {
/*      */       
/*  585 */       paramHtmlMarkdownWriter.blankLine();
/*  586 */       bool2 = true;
/*      */     } 
/*      */     
/*  589 */     boolean bool1 = this.myHtmlConverterOptions.listContentIndent ? (this.myHtmlConverterOptions.definitionMarkerSpaces + 1) : true;
/*  590 */     CharSequence charSequence = RepeatedSequence.repeatOf(" ", bool1);
/*      */     
/*  592 */     ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.line()).setOptions(i & (LineAppendable.F_COLLAPSE_WHITESPACE ^ 0xFFFFFFFF));
/*  593 */     ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(':')).append(' ', this.myHtmlConverterOptions.definitionMarkerSpaces);
/*  594 */     paramHtmlMarkdownWriter.pushPrefix();
/*  595 */     paramHtmlMarkdownWriter.addPrefix(charSequence, true);
/*  596 */     paramHtmlMarkdownWriter.setOptions(i);
/*  597 */     if (bool2) {
/*  598 */       paramHtmlNodeConverterContext.renderChildren((Node)paramElement, true, null);
/*      */     } else {
/*  600 */       paramHtmlNodeConverterContext.processTextNodes((Node)paramElement, false);
/*      */     } 
/*  602 */     paramHtmlMarkdownWriter.line();
/*  603 */     paramHtmlMarkdownWriter.popPrefix();
/*  604 */     paramHtmlNodeConverterContext.popState((LineAppendable)paramHtmlMarkdownWriter);
/*      */   }
/*      */   
/*      */   private void processEmoji(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  608 */     if (paramElement.hasAttr("alias")) {
/*  609 */       ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(':')).append(paramElement.attr("alias"))).append(':');
/*      */       return;
/*      */     } 
/*      */     EmojiReference.Emoji emoji;
/*  613 */     if (paramElement.hasAttr("fallback-src") && (
/*      */       
/*  615 */       emoji = EmojiShortcuts.getEmojiFromURI(paramElement.attr("fallback-src"))) != null) {
/*  616 */       ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(':')).append(emoji.shortcut)).append(':');
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  621 */     paramHtmlNodeConverterContext.renderDefault((Node)paramElement);
/*      */   }
/*      */   
/*      */   private void processEmphasis(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  625 */     paramHtmlNodeConverterContext.processConditional(this.myHtmlConverterOptions.extInlineEmphasis, (Node)paramElement, () -> {
/*      */           // Byte code:
/*      */           //   0: aload_0
/*      */           //   1: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */           //   4: getfield preCodePreserveEmphasis : Z
/*      */           //   7: ifne -> 24
/*      */           //   10: aload_1
/*      */           //   11: invokevirtual isPreFormatted : ()Z
/*      */           //   14: ifeq -> 24
/*      */           //   17: aload_2
/*      */           //   18: aload_3
/*      */           //   19: ldc ''
/*      */           //   21: goto -> 57
/*      */           //   24: aload_2
/*      */           //   25: aload_3
/*      */           //   26: aload_0
/*      */           //   27: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */           //   30: getfield extInlineEmphasis : Lcom/vladsch/flexmark/html2md/converter/ExtensionConversion;
/*      */           //   33: invokevirtual isTextOnly : ()Z
/*      */           //   36: ifeq -> 44
/*      */           //   39: ldc ''
/*      */           //   41: goto -> 46
/*      */           //   44: ldc '*'
/*      */           //   46: aload_3
/*      */           //   47: invokevirtual nextElementSibling : ()Lorg/jsoup/nodes/Element;
/*      */           //   50: ifnull -> 57
/*      */           //   53: iconst_1
/*      */           //   54: goto -> 58
/*      */           //   57: iconst_0
/*      */           //   58: invokeinterface wrapTextNodes : (Lorg/jsoup/nodes/Node;Ljava/lang/CharSequence;Z)V
/*      */           //   63: return
/*      */           // Line number table:
/*      */           //   Java source line number -> byte code offset
/*      */           //   #626	-> 0
/*      */           //   #627	-> 17
/*      */           //   #629	-> 24
/*      */           //   #631	-> 63
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void processHr(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  635 */     ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.blankLine()).append(this.myHtmlConverterOptions.thematicBreak)).blankLine();
/*      */   }
/*      */ 
/*      */   
/*      */   private void processImg(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  640 */     if (paramElement.hasAttr("src")) {
/*      */       int i; String str1;
/*      */       String str2;
/*      */       EmojiReference.Emoji emoji;
/*      */       String str3;
/*  645 */       if ((emoji = EmojiShortcuts.getEmojiFromURI(str2 = paramElement.attr("src"))) == null && paramElement.hasAttr("alt") && (
/*      */         
/*  647 */         str3 = paramElement.attr("alt")).startsWith("emoji ")) {
/*      */ 
/*      */ 
/*      */         
/*  651 */         String str4 = str3.substring(6, j); int j;
/*      */         String str5;
/*      */         EmojiReference.Emoji emoji1;
/*  654 */         if ((j = str3.indexOf(":", 6)) > 0 && (emoji1 = EmojiShortcuts.getEmojiFromShortcut(str5 = str3.substring(j + 1))).category.equals(str4)) {
/*  655 */           emoji = emoji1;
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  661 */       if (emoji != null) {
/*  662 */         ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(':')).append(emoji.shortcut)).append(':'); return;
/*      */       } 
/*      */       LinkConversion linkConversion;
/*  665 */       if ((linkConversion = this.myHtmlConverterOptions.extInlineImage).isSuppressed())
/*      */         return; 
/*  667 */       if (linkConversion.isParsed()) {
/*      */         String str4;
/*      */ 
/*      */         
/*  671 */         if ((str4 = (String)(!paramElement.hasAttr("alt") ? null : paramElement.attr("alt").trim().replace("[", "\\[").replace("]", "\\]"))) != null && str4.isEmpty()) str4 = null;
/*      */ 
/*      */         
/*      */         String str5;
/*  675 */         if ((str5 = (String)(!paramElement.hasAttr("title") ? null : paramElement.attr("title").replace("\n", this.myHtmlConverterOptions.eolInTitleAttribute).replace("\"", "\\\""))) != null && str5.isEmpty()) str5 = null;
/*      */         
/*  677 */         if (!linkConversion.isTextOnly())
/*      */         { ResolvedLink resolvedLink;
/*      */           
/*      */           String str;
/*  681 */           int j = ((i = (str = (resolvedLink = paramHtmlNodeConverterContext.resolveLink(LinkType.IMAGE, str2, Boolean.FALSE)).getUrl()).indexOf('?')) < 0) ? i : str.indexOf("%0A", i);
/*  682 */           j = (i > 0 && j > 0) ? 1 : 0;
/*  683 */           boolean bool = false;
/*      */           
/*  685 */           if (linkConversion.isReference() && j == 0) {
/*      */             Reference reference;
/*  687 */             if ((reference = paramHtmlNodeConverterContext.getOrCreateReference(str, (str4 == null) ? "image" : str4, str5)) != null) {
/*  688 */               bool = true;
/*      */               
/*  690 */               if (str4 == null || reference.getReference().equals(str4)) {
/*      */                 
/*  692 */                 ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append("![")).append((CharSequence)reference.getReference())).append("][]");
/*      */               } else {
/*  694 */                 ((HtmlMarkdownWriter)((HtmlMarkdownWriter)((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append("![")).append(str4)).append("][")).append((CharSequence)reference.getReference())).append("]");
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/*  699 */           if (!bool) {
/*  700 */             paramHtmlMarkdownWriter.append("![");
/*  701 */             if (str4 != null) paramHtmlMarkdownWriter.append(str4); 
/*  702 */             ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(']')).append('(');
/*      */             
/*  704 */             if (j != 0) {
/*  705 */               paramHtmlMarkdownWriter.append(str, 0, i + 1);
/*  706 */               str1 = Utils.urlDecode(str.substring(i + 1).replace("+", "%2B"), "UTF8");
/*  707 */               ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.line()).append(str1);
/*      */             } else {
/*  709 */               paramHtmlMarkdownWriter.append(str);
/*      */             } 
/*      */             
/*  712 */             if (str5 != null) ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(" \"")).append(str5)).append('"'); 
/*  713 */             paramHtmlMarkdownWriter.append(")");
/*      */           }
/*      */            }
/*  716 */         else if (str4 != null) { paramHtmlMarkdownWriter.append(str4); }
/*  717 */         else { if (str5 != null) paramHtmlMarkdownWriter.append(str5);  return; }
/*      */       
/*  719 */       } else if (!linkConversion.isSuppressed()) {
/*  720 */         str1.processWrapped(i, null, false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void processInput(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  727 */     boolean bool = false;
/*      */     
/*      */     Element element;
/*  730 */     if ((element = paramElement.firstElementSibling()) == null || paramElement == element) {
/*      */       String str;
/*  732 */       bool = (str = paramElement.parent().tagName()).equalsIgnoreCase("li");
/*      */     } 
/*      */     
/*  735 */     if (bool && 
/*  736 */       paramElement.hasAttr("type") && "checkbox".equalsIgnoreCase(paramElement.attr("type"))) {
/*  737 */       if (paramElement.hasAttr("checked")) {
/*  738 */         paramHtmlMarkdownWriter.append("[x] "); return;
/*      */       } 
/*  740 */       paramHtmlMarkdownWriter.append("[ ] ");
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  745 */     paramHtmlNodeConverterContext.renderDefault((Node)paramElement);
/*      */   }
/*      */   
/*      */   private void processIns(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  749 */     paramHtmlNodeConverterContext.processConditional(this.myHtmlConverterOptions.extInlineIns, (Node)paramElement, () -> {
/*      */           // Byte code:
/*      */           //   0: aload_0
/*      */           //   1: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */           //   4: getfield preCodePreserveEmphasis : Z
/*      */           //   7: ifne -> 24
/*      */           //   10: aload_1
/*      */           //   11: invokevirtual isPreFormatted : ()Z
/*      */           //   14: ifeq -> 24
/*      */           //   17: aload_2
/*      */           //   18: aload_3
/*      */           //   19: ldc ''
/*      */           //   21: goto -> 57
/*      */           //   24: aload_2
/*      */           //   25: aload_3
/*      */           //   26: aload_0
/*      */           //   27: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */           //   30: getfield extInlineIns : Lcom/vladsch/flexmark/html2md/converter/ExtensionConversion;
/*      */           //   33: invokevirtual isTextOnly : ()Z
/*      */           //   36: ifeq -> 44
/*      */           //   39: ldc ''
/*      */           //   41: goto -> 46
/*      */           //   44: ldc '++'
/*      */           //   46: aload_3
/*      */           //   47: invokevirtual nextElementSibling : ()Lorg/jsoup/nodes/Element;
/*      */           //   50: ifnull -> 57
/*      */           //   53: iconst_1
/*      */           //   54: goto -> 58
/*      */           //   57: iconst_0
/*      */           //   58: invokeinterface wrapTextNodes : (Lorg/jsoup/nodes/Node;Ljava/lang/CharSequence;Z)V
/*      */           //   63: return
/*      */           // Line number table:
/*      */           //   Java source line number -> byte code offset
/*      */           //   #750	-> 0
/*      */           //   #751	-> 17
/*      */           //   #753	-> 24
/*      */           //   #755	-> 63
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void processStrong(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  759 */     paramHtmlNodeConverterContext.processConditional(this.myHtmlConverterOptions.extInlineStrong, (Node)paramElement, () -> {
/*      */           // Byte code:
/*      */           //   0: aload_0
/*      */           //   1: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */           //   4: getfield preCodePreserveEmphasis : Z
/*      */           //   7: ifne -> 24
/*      */           //   10: aload_1
/*      */           //   11: invokevirtual isPreFormatted : ()Z
/*      */           //   14: ifeq -> 24
/*      */           //   17: aload_2
/*      */           //   18: aload_3
/*      */           //   19: ldc ''
/*      */           //   21: goto -> 57
/*      */           //   24: aload_2
/*      */           //   25: aload_3
/*      */           //   26: aload_0
/*      */           //   27: getfield myHtmlConverterOptions : Lcom/vladsch/flexmark/html2md/converter/HtmlConverterOptions;
/*      */           //   30: getfield extInlineStrong : Lcom/vladsch/flexmark/html2md/converter/ExtensionConversion;
/*      */           //   33: invokevirtual isTextOnly : ()Z
/*      */           //   36: ifeq -> 44
/*      */           //   39: ldc ''
/*      */           //   41: goto -> 46
/*      */           //   44: ldc '**'
/*      */           //   46: aload_3
/*      */           //   47: invokevirtual nextElementSibling : ()Lorg/jsoup/nodes/Element;
/*      */           //   50: ifnull -> 57
/*      */           //   53: iconst_1
/*      */           //   54: goto -> 58
/*      */           //   57: iconst_0
/*      */           //   58: invokeinterface wrapTextNodes : (Lorg/jsoup/nodes/Node;Ljava/lang/CharSequence;Z)V
/*      */           //   63: return
/*      */           // Line number table:
/*      */           //   Java source line number -> byte code offset
/*      */           //   #760	-> 0
/*      */           //   #761	-> 17
/*      */           //   #763	-> 24
/*      */           //   #765	-> 63
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void processSub(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  769 */     paramHtmlNodeConverterContext.processConditional(this.myHtmlConverterOptions.extInlineSub, (Node)paramElement, () -> {
/*      */           if (this.myHtmlConverterOptions.extInlineSub.isTextOnly() || (!this.myHtmlConverterOptions.preCodePreserveEmphasis && paramHtmlMarkdownWriter.isPreFormatted())) {
/*      */             paramHtmlNodeConverterContext.wrapTextNodes((Node)paramElement, "", false);
/*      */             return;
/*      */           } 
/*      */           paramHtmlNodeConverterContext.wrapTextNodes((Node)paramElement, "~", false);
/*      */         });
/*      */   }
/*      */   
/*      */   private void processSup(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  779 */     paramHtmlNodeConverterContext.processConditional(this.myHtmlConverterOptions.extInlineSup, (Node)paramElement, () -> {
/*      */           if (this.myHtmlConverterOptions.extInlineSup.isTextOnly() || (!this.myHtmlConverterOptions.preCodePreserveEmphasis && paramHtmlMarkdownWriter.isPreFormatted())) {
/*      */             paramHtmlNodeConverterContext.wrapTextNodes((Node)paramElement, "", false);
/*      */             return;
/*      */           } 
/*      */           paramHtmlNodeConverterContext.wrapTextNodes((Node)paramElement, "^", false);
/*      */         });
/*      */   }
/*      */   
/*      */   private void processMath(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  789 */     paramHtmlNodeConverterContext.processConditional(this.myHtmlConverterOptions.extMath, (Node)paramElement, () -> {
/*      */           boolean bool = this.myHtmlConverterOptions.extMath.isTextOnly();
/*      */           paramHtmlNodeConverterContext.processTextNodes((Node)paramElement, false, bool ? "" : "$`", bool ? "" : "`$");
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void handleListItem(HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter, Element paramElement, ListState paramListState) {
/*  798 */     paramHtmlNodeConverterContext.pushState((Node)paramElement);
/*      */     
/*  800 */     paramListState.itemCount++;
/*  801 */     String str = paramListState.getItemPrefix(this.myHtmlConverterOptions);
/*  802 */     boolean bool = this.myHtmlConverterOptions.listContentIndent ? str.length() : true;
/*  803 */     CharSequence charSequence = RepeatedSequence.repeatOf(" ", bool);
/*      */     
/*  805 */     ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.line()).append(str);
/*  806 */     paramHtmlMarkdownWriter.pushPrefix();
/*  807 */     paramHtmlMarkdownWriter.addPrefix(charSequence, true);
/*  808 */     int i = paramHtmlMarkdownWriter.offsetWithPending();
/*  809 */     paramHtmlNodeConverterContext.renderChildren((Node)paramElement, true, null);
/*  810 */     if (i == paramHtmlMarkdownWriter.offsetWithPending()) {
/*      */       
/*  812 */       int j = paramHtmlMarkdownWriter.getOptions();
/*  813 */       paramHtmlMarkdownWriter.setOptions(j & ((LineAppendable.F_TRIM_TRAILING_WHITESPACE | LineAppendable.F_TRIM_LEADING_WHITESPACE) ^ 0xFFFFFFFF));
/*      */       
/*  815 */       paramHtmlMarkdownWriter.line();
/*  816 */       paramHtmlMarkdownWriter.setOptions(j);
/*      */     } else {
/*  818 */       paramHtmlMarkdownWriter.line();
/*      */     } 
/*  820 */     paramHtmlMarkdownWriter.popPrefix();
/*  821 */     paramHtmlNodeConverterContext.popState((LineAppendable)paramHtmlMarkdownWriter);
/*      */   }
/*      */   
/*      */   private boolean hasListItemParent(Element paramElement) {
/*  825 */     paramElement = paramElement.parent();
/*  826 */     while (paramElement != null) {
/*  827 */       if (paramElement.tagName().equalsIgnoreCase("li")) {
/*  828 */         return true;
/*      */       }
/*  830 */       paramElement = paramElement.parent();
/*      */     } 
/*  832 */     return false;
/*      */   }
/*      */   
/*      */   private boolean haveListItemAncestor(Node paramNode) {
/*  836 */     paramNode = paramNode.parent();
/*  837 */     while (paramNode != null) {
/*  838 */       if (paramNode.nodeName().toLowerCase().equals("li")) {
/*  839 */         return true;
/*      */       }
/*  841 */       paramNode = paramNode.parent();
/*      */     } 
/*  843 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void handleList(HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter, Element paramElement, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  853 */     if (!paramBoolean2) {
/*  854 */       paramHtmlNodeConverterContext.pushState((Node)paramElement);
/*      */       
/*  856 */       if (!paramBoolean3 && !haveListItemAncestor(paramHtmlNodeConverterContext.getState().getParent()) && !isFirstChild(paramElement)) {
/*  857 */         paramHtmlMarkdownWriter.blankLine();
/*      */       }
/*      */     } 
/*      */     
/*      */     Element element2;
/*      */     String str;
/*  863 */     if ((str = (String)(((element2 = paramElement.previousElementSibling()) == null) ? null : element2.tagName().toUpperCase())) != null && str.equals(paramElement.tagName().toUpperCase()) && (str.equals("UL") || str.equals("OL"))) {
/*  864 */       if (this.myHtmlConverterOptions.listsEndOnDoubleBlank) {
/*  865 */         paramHtmlMarkdownWriter.blankLine(2);
/*      */       } else {
/*  867 */         ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.line()).append("<!-- -->")).blankLine();
/*      */       } 
/*      */     }
/*      */     
/*      */     ListState listState;
/*      */     
/*  873 */     if ((listState = new ListState(paramBoolean1)).isNumbered && paramElement.hasAttr("start")) {
/*      */       try {
/*  875 */         int i = Integer.parseInt(paramElement.attr("start"));
/*  876 */         listState.itemCount = i - 1;
/*  877 */       } catch (NumberFormatException numberFormatException) {}
/*      */     }
/*      */ 
/*      */     
/*  881 */     Element element1 = paramElement;
/*  882 */     boolean bool = false;
/*      */     Node node;
/*      */     do {
/*  885 */       boolean bool1 = false;
/*      */       
/*  887 */       switch (element1.nodeName().toLowerCase()) {
/*      */         case "li":
/*  889 */           handleListItem(paramHtmlNodeConverterContext, paramHtmlMarkdownWriter, element1, listState);
/*  890 */           bool = true;
/*      */           break;
/*      */         
/*      */         case "p":
/*  894 */           if (element1.childNodeSize() > 0) {
/*  895 */             handleListItem(paramHtmlNodeConverterContext, paramHtmlMarkdownWriter, element1, listState);
/*      */           }
/*      */           break;
/*      */         
/*      */         case "ol":
/*  900 */           bool1 = true;
/*      */         
/*      */         case "ul":
/*  903 */           if (element1 != paramElement && element1.childNodeSize() > 0) {
/*  904 */             if (bool) {
/*  905 */               null = listState.getItemPrefix(this.myHtmlConverterOptions);
/*  906 */               boolean bool2 = this.myHtmlConverterOptions.listContentIndent ? null.length() : true;
/*  907 */               CharSequence charSequence = RepeatedSequence.repeatOf(" ", bool2);
/*      */               
/*  909 */               paramHtmlMarkdownWriter.pushPrefix();
/*  910 */               paramHtmlMarkdownWriter.addPrefix(charSequence, true);
/*      */             } 
/*      */             
/*  913 */             handleList(paramHtmlNodeConverterContext, paramHtmlMarkdownWriter, element1, bool1, false, true);
/*      */             
/*  915 */             if (bool) {
/*  916 */               paramHtmlMarkdownWriter.popPrefix();
/*      */             }
/*      */           } 
/*      */           break;
/*      */ 
/*      */         
/*      */         default:
/*  923 */           paramHtmlNodeConverterContext.render((Node)element1);
/*      */           break;
/*      */       } 
/*  926 */     } while ((node = paramHtmlNodeConverterContext.next()) != null);
/*      */     
/*  928 */     if (!paramBoolean3 && paramElement.nextElementSibling() != null) {
/*  929 */       paramHtmlMarkdownWriter.blankLine();
/*      */     }
/*      */     
/*  932 */     if (!paramBoolean2) {
/*  933 */       paramHtmlNodeConverterContext.popState((LineAppendable)paramHtmlMarkdownWriter);
/*      */     }
/*      */   }
/*      */   
/*      */   private void processLi(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  938 */     handleList(paramHtmlNodeConverterContext, paramHtmlMarkdownWriter, paramElement, false, true, false);
/*      */   }
/*      */   
/*      */   private void processOl(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  942 */     handleList(paramHtmlNodeConverterContext, paramHtmlMarkdownWriter, paramElement, true, false, false);
/*      */   }
/*      */   
/*      */   private void processUl(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  946 */     handleList(paramHtmlNodeConverterContext, paramHtmlMarkdownWriter, paramElement, false, false, false);
/*      */   }
/*      */   
/*      */   private void processSvg(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  950 */     if (!paramElement.hasClass("octicon"))
/*      */     {
/*  952 */       paramHtmlNodeConverterContext.renderDefault((Node)paramElement);
/*      */     }
/*      */   }
/*      */   
/*      */   private void processP(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*  957 */     boolean bool1 = false;
/*  958 */     boolean bool2 = false;
/*      */     
/*      */     Element element;
/*  961 */     if ((element = paramElement.firstElementSibling()) == null || paramElement == element) {
/*      */       String str;
/*  963 */       bool1 = (str = paramElement.parent().tagName()).equalsIgnoreCase("li");
/*  964 */       bool2 = str.equalsIgnoreCase("dd");
/*      */     } 
/*      */     
/*  967 */     paramHtmlMarkdownWriter.blankLineIf((!bool1 && !bool2 && !isFirstChild(paramElement)));
/*      */     
/*  969 */     if (paramElement.childNodeSize() == 0) {
/*  970 */       if (this.myHtmlConverterOptions.brAsExtraBlankLines) {
/*  971 */         ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append("<br />")).blankLine();
/*      */       }
/*      */     } else {
/*  974 */       paramHtmlNodeConverterContext.processTextNodes((Node)paramElement, false);
/*      */     } 
/*      */     
/*  977 */     paramHtmlMarkdownWriter.line();
/*      */     
/*  979 */     if (bool1 || bool2)
/*  980 */       paramHtmlMarkdownWriter.tailBlankLine(); 
/*      */   }
/*      */   
/*      */   private void processHeading(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*      */     byte b;
/*      */     byte b1;
/*      */     boolean bool;
/*  987 */     switch (paramElement.nodeName().toLowerCase()) {
/*      */       case "h1":
/*  989 */         b = 1;
/*  990 */         bool = this.myHtmlConverterOptions.skipHeading1;
/*      */         break;
/*      */       case "h2":
/*  993 */         b = 2;
/*  994 */         bool = this.myHtmlConverterOptions.skipHeading2;
/*      */         break;
/*      */       case "h3":
/*  997 */         b = 3;
/*  998 */         bool = this.myHtmlConverterOptions.skipHeading3;
/*      */         break;
/*      */       case "h4":
/* 1001 */         b = 4;
/* 1002 */         bool = this.myHtmlConverterOptions.skipHeading4;
/*      */         break;
/*      */       case "h5":
/* 1005 */         b = 5;
/* 1006 */         bool = this.myHtmlConverterOptions.skipHeading5;
/*      */         break;
/*      */ 
/*      */       
/*      */       default:
/* 1011 */         b = 6;
/* 1012 */         bool = this.myHtmlConverterOptions.skipHeading6;
/*      */         break;
/*      */     } 
/*      */     
/*      */     String str;
/* 1017 */     if (!(str = paramHtmlNodeConverterContext.processTextNodes((Node)paramElement).trim()).isEmpty()) {
/* 1018 */       paramHtmlMarkdownWriter.blankLine();
/* 1019 */       if (bool) {
/* 1020 */         paramHtmlMarkdownWriter.append(str); return;
/*      */       } 
/* 1022 */       if (this.myHtmlConverterOptions.setextHeadings && b <= 2) {
/* 1023 */         paramHtmlMarkdownWriter.append(str);
/* 1024 */         int i = paramHtmlNodeConverterContext.outputAttributes((LineAppendable)paramHtmlMarkdownWriter, " ");
/* 1025 */         ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.line()).append((b == 1) ? 61 : 45, Utils.minLimit(str.length() + i, new int[] { this.myHtmlConverterOptions.minSetextHeadingMarkerLength }));
/*      */       } else {
/* 1027 */         ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append('#', b)).append(' ');
/* 1028 */         paramHtmlMarkdownWriter.append(str);
/* 1029 */         paramHtmlNodeConverterContext.outputAttributes((LineAppendable)paramHtmlMarkdownWriter, " ");
/*      */       } 
/* 1031 */       paramHtmlMarkdownWriter.blankLine();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void processPre(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/* 1037 */     paramHtmlNodeConverterContext.pushState((Node)paramElement);
/*      */ 
/*      */     
/* 1040 */     boolean bool = false;
/* 1041 */     String str2 = "";
/*      */     
/*      */     HtmlNodeConverterContext htmlNodeConverterContext;
/* 1044 */     (htmlNodeConverterContext = paramHtmlNodeConverterContext.getSubContext()).getMarkdown().setOptions(paramHtmlMarkdownWriter.getOptions() & ((LineAppendable.F_COLLAPSE_WHITESPACE | LineAppendable.F_TRIM_TRAILING_WHITESPACE) ^ 0xFFFFFFFF));
/* 1045 */     htmlNodeConverterContext.getMarkdown().openPreFormatted(false);
/*      */     
/*      */     Node node;
/* 1048 */     while ((node = paramHtmlNodeConverterContext.next()) != null) {
/* 1049 */       Element element; if (node.nodeName().equalsIgnoreCase("code") || node.nodeName().equalsIgnoreCase("tt")) {
/* 1050 */         bool = true;
/* 1051 */         element = (Element)node;
/*      */         
/* 1053 */         htmlNodeConverterContext.renderChildren((Node)element, false, null);
/* 1054 */         if (str2.isEmpty()) str2 = Utils.removePrefix(element.className(), "language-");  continue;
/* 1055 */       }  if (element.nodeName().equalsIgnoreCase("br")) {
/* 1056 */         htmlNodeConverterContext.getMarkdown().append("\n"); continue;
/* 1057 */       }  if (element.nodeName().equalsIgnoreCase("#text")) {
/* 1058 */         htmlNodeConverterContext.getMarkdown().append(((TextNode)element).getWholeText()); continue;
/*      */       } 
/* 1060 */       htmlNodeConverterContext.renderChildren((Node)element, false, null);
/*      */     } 
/*      */ 
/*      */     
/* 1064 */     htmlNodeConverterContext.getMarkdown().closePreFormatted();
/*      */ 
/*      */ 
/*      */     
/*      */     String str1;
/*      */ 
/*      */ 
/*      */     
/* 1072 */     int i = getMaxRepeatedChars(str1 = htmlNodeConverterContext.getMarkdown().toString(2147483647, 2), '`', 3);
/* 1073 */     CharSequence charSequence = RepeatedSequence.repeatOf("`", i);
/*      */     
/* 1075 */     if (!this.myHtmlConverterOptions.skipFencedCode && (!str2.isEmpty() || str1.trim().isEmpty() || !bool)) {
/* 1076 */       ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.blankLine()).append(charSequence);
/* 1077 */       if (!str2.isEmpty()) {
/* 1078 */         paramHtmlMarkdownWriter.append(str2);
/*      */       }
/* 1080 */       paramHtmlMarkdownWriter.line();
/* 1081 */       paramHtmlMarkdownWriter.openPreFormatted(true);
/* 1082 */       paramHtmlMarkdownWriter.append(str1.isEmpty() ? "\n" : str1);
/* 1083 */       paramHtmlMarkdownWriter.closePreFormatted();
/* 1084 */       ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.line()).append(charSequence)).line();
/* 1085 */       paramHtmlMarkdownWriter.tailBlankLine();
/*      */     } else {
/*      */       
/* 1088 */       paramHtmlMarkdownWriter.blankLine();
/* 1089 */       paramHtmlMarkdownWriter.pushPrefix();
/* 1090 */       paramHtmlMarkdownWriter.addPrefix(this.myHtmlConverterOptions.codeIndent);
/* 1091 */       paramHtmlMarkdownWriter.openPreFormatted(true);
/* 1092 */       paramHtmlMarkdownWriter.append(str1.isEmpty() ? "\n" : str1);
/* 1093 */       paramHtmlMarkdownWriter.closePreFormatted();
/* 1094 */       paramHtmlMarkdownWriter.line();
/* 1095 */       paramHtmlMarkdownWriter.tailBlankLine();
/* 1096 */       paramHtmlMarkdownWriter.popPrefix();
/*      */     } 
/*      */     
/* 1099 */     paramHtmlNodeConverterContext.popState((LineAppendable)paramHtmlMarkdownWriter);
/*      */   }
/*      */   
/*      */   private void processTable(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/* 1103 */     MarkdownTable markdownTable = this.myTable;
/*      */     
/* 1105 */     paramHtmlNodeConverterContext.pushState((Node)paramElement);
/*      */     
/* 1107 */     this.myTable = new MarkdownTable("", this.myHtmlConverterOptions.tableOptions);
/* 1108 */     this.myTableSuppressColumns = false;
/*      */     
/*      */     Node node;
/* 1111 */     while ((node = paramHtmlNodeConverterContext.next()) != null) {
/*      */       Element element; Elements elements; String str;
/* 1113 */       switch (str = node.nodeName().toLowerCase()) {
/*      */         case "caption":
/* 1115 */           handleTableCaption((Element)node, paramHtmlNodeConverterContext, paramHtmlMarkdownWriter);
/*      */         
/*      */         case "tbody":
/* 1118 */           this.myTable.setHeader(false);
/* 1119 */           handleTableSection(paramHtmlNodeConverterContext, paramHtmlMarkdownWriter, (Element)node);
/*      */         
/*      */         case "thead":
/* 1122 */           this.myTable.setHeader(true);
/* 1123 */           handleTableSection(paramHtmlNodeConverterContext, paramHtmlMarkdownWriter, (Element)node);
/*      */ 
/*      */         
/*      */         case "tr":
/* 1127 */           elements = (element = (Element)node).children();
/* 1128 */           this.myTable.setHeader((!elements.isEmpty() && ((Element)elements.get(0)).tagName().equalsIgnoreCase("th")));
/* 1129 */           handleTableRow(paramHtmlNodeConverterContext, paramHtmlMarkdownWriter, (Element)node);
/*      */       } 
/*      */ 
/*      */     
/*      */     } 
/* 1134 */     this.myTable.finalizeTable();
/*      */     
/*      */     int i;
/* 1137 */     if ((i = this.myTable.getMaxColumns()) > 0) {
/* 1138 */       paramHtmlMarkdownWriter.blankLine();
/* 1139 */       this.myTable.appendTable((LineAppendable)paramHtmlMarkdownWriter);
/* 1140 */       paramHtmlMarkdownWriter.tailBlankLine();
/*      */     } 
/*      */     
/* 1143 */     this.myTable = markdownTable;
/* 1144 */     paramHtmlNodeConverterContext.popState((LineAppendable)paramHtmlMarkdownWriter);
/*      */   }
/*      */   
/*      */   private void handleTableSection(HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter, Element paramElement) {
/* 1148 */     paramHtmlNodeConverterContext.pushState((Node)paramElement);
/*      */     
/*      */     Node node;
/* 1151 */     while ((node = paramHtmlNodeConverterContext.next()) != null) {
/* 1152 */       if (node.nodeName().equalsIgnoreCase("tr")) {
/*      */         Element element;
/* 1154 */         Elements elements = (element = (Element)node).children();
/* 1155 */         boolean bool = this.myTable.getHeader();
/* 1156 */         if (!elements.isEmpty() && (
/* 1157 */           (Element)elements.get(0)).tagName().equalsIgnoreCase("th")) {
/* 1158 */           this.myTable.setHeader(true);
/*      */         }
/*      */         
/* 1161 */         if (this.myTable.getHeader() && this.myTable.body.rows.size() > 0) {
/* 1162 */           if (this.myHtmlConverterOptions.ignoreTableHeadingAfterRows) {
/*      */             
/* 1164 */             this.myTableSuppressColumns = true;
/*      */           } else {
/* 1166 */             this.myTable.setHeader(false);
/*      */           } 
/*      */         }
/* 1169 */         handleTableRow(paramHtmlNodeConverterContext, paramHtmlMarkdownWriter, element);
/* 1170 */         this.myTableSuppressColumns = false;
/* 1171 */         this.myTable.setHeader(bool);
/*      */       } 
/*      */     } 
/*      */     
/* 1175 */     paramHtmlNodeConverterContext.popState((LineAppendable)paramHtmlMarkdownWriter);
/*      */   }
/*      */   
/*      */   private void handleTableRow(HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter, Element paramElement) {
/* 1179 */     paramHtmlNodeConverterContext.pushState((Node)paramElement);
/*      */     
/*      */     Node node;
/* 1182 */     while ((node = paramHtmlNodeConverterContext.next()) != null) {
/* 1183 */       switch (node.nodeName().toLowerCase()) {
/*      */         case "th":
/*      */         case "td":
/* 1186 */           handleTableCell((Element)node, paramHtmlNodeConverterContext, paramHtmlMarkdownWriter);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     } 
/* 1195 */     this.myTable.nextRow();
/* 1196 */     paramHtmlNodeConverterContext.popState((LineAppendable)paramHtmlMarkdownWriter);
/*      */   }
/*      */   
/*      */   private void handleTableCaption(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/* 1200 */     this.myTable.setCaption(paramHtmlNodeConverterContext.processTextNodes((Node)paramElement).trim());
/*      */   }
/*      */   
/*      */   private void handleTableCell(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/* 1204 */     String str = paramHtmlNodeConverterContext.processTextNodes((Node)paramElement).trim().replaceAll("\\s*\n\\s*", " ");
/* 1205 */     int i = 1;
/* 1206 */     int j = 1;
/* 1207 */     CellAlignment cellAlignment = null;
/*      */     
/* 1209 */     if (paramElement.hasAttr("colSpan")) {
/*      */       try {
/* 1211 */         i = Integer.parseInt(paramElement.attr("colSpan"));
/* 1212 */       } catch (NumberFormatException numberFormatException) {}
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1217 */     if (paramElement.hasAttr("rowSpan")) {
/*      */       try {
/* 1219 */         j = Integer.parseInt(paramElement.attr("rowSpan"));
/* 1220 */       } catch (NumberFormatException numberFormatException) {}
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1225 */     if (paramElement.hasAttr("align")) {
/* 1226 */       cellAlignment = CellAlignment.getAlignment(paramElement.attr("align"));
/*      */     } else {
/*      */       Set<?> set;
/*      */       
/* 1230 */       if (!(set = paramElement.classNames()).isEmpty()) {
/* 1231 */         for (String str1 : set) {
/*      */           CellAlignment cellAlignment1;
/* 1233 */           if ((cellAlignment1 = (CellAlignment)this.myHtmlConverterOptions.tableCellAlignmentMap.get(str1)) != null) {
/* 1234 */             cellAlignment = cellAlignment1;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/* 1239 */         if (cellAlignment == null)
/*      */         {
/* 1241 */           for (Iterator<Object> iterator = this.myHtmlConverterOptions.tableCellAlignmentMap.keySet().iterator(); iterator.hasNext();) {
/* 1242 */             if (pattern = (Pattern)iterator.next() instanceof Pattern) {
/* 1243 */               Pattern pattern1 = pattern;
/* 1244 */               for (String str1 : set) {
/* 1245 */                 if (pattern1.matcher(str1).find()) {
/*      */                   
/* 1247 */                   cellAlignment = (CellAlignment)this.myHtmlConverterOptions.tableCellAlignmentMap.get(pattern);
/*      */                   
/*      */                   break;
/*      */                 } 
/*      */               } 
/* 1252 */               if (cellAlignment == null)
/*      */                 continue; 
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 1260 */     if (!this.myTableSuppressColumns) {
/* 1261 */       this.myTable.addCell(new TableCell(null, (CharSequence)BasedSequence.NULL, str.replace("\n", " "), (CharSequence)BasedSequence.NULL, j, i, cellAlignment));
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean matchingText(Pattern paramPattern, String paramString, String[] paramArrayOfString) {
/*      */     Matcher matcher;
/* 1267 */     if ((matcher = paramPattern.matcher(paramString)).matches()) {
/* 1268 */       if (matcher.groupCount() > 0) {
/* 1269 */         paramArrayOfString[0] = matcher.group(1);
/*      */       } else {
/* 1271 */         paramArrayOfString[0] = matcher.group();
/*      */       } 
/* 1273 */       return true;
/*      */     } 
/* 1275 */     return false;
/*      */   }
/*      */   
/*      */   private String convertNumeric(String paramString) {
/* 1279 */     paramString = paramString.trim();
/*      */     
/* 1281 */     if (RomanNumeral.LIMITED_ROMAN_NUMERAL.matcher(paramString).matches() || RomanNumeral.LIMITED_LOWERCASE_ROMAN_NUMERAL.matcher(paramString).matches()) {
/*      */       RomanNumeral romanNumeral;
/* 1283 */       return String.valueOf((romanNumeral = new RomanNumeral(paramString)).toInt());
/* 1284 */     }  if (ALPHA_NUMERAL_PAT.matcher(paramString).matches()) {
/* 1285 */       int i = 0;
/*      */       
/* 1287 */       int j = (paramString = paramString.toUpperCase()).length();
/* 1288 */       for (byte b = 0; b < j; b++) {
/* 1289 */         char c = paramString.charAt(b);
/*      */         
/* 1291 */         i = (i = i * 26) + c - 65 + 1;
/*      */       } 
/* 1293 */       return String.valueOf(i);
/*      */     } 
/* 1295 */     return "1";
/*      */   }
/*      */   
/*      */   private void processUnwrapped(Node paramNode, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/* 1299 */     paramHtmlNodeConverterContext.processUnwrapped(paramNode);
/*      */   }
/*      */   
/*      */   private void processWrapped(Node paramNode, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/* 1303 */     paramHtmlNodeConverterContext.processWrapped(paramNode, Boolean.FALSE, false);
/*      */   }
/*      */   
/*      */   private void processSpan(Element paramElement, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/*      */     String str1, str2;
/* 1308 */     if (paramElement.hasAttr("style") && (
/*      */       
/* 1310 */       str2 = paramElement.attr("style")).equals("mso-list:Ignore")) {
/* 1311 */       String[] arrayOfString = { "1" };
/* 1312 */       str1 = paramHtmlNodeConverterContext.processTextNodes((Node)paramElement);
/* 1313 */       if (matchingText(NUMERIC_DOT_LIST_PAT, str1, arrayOfString)) {
/* 1314 */         ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(str1)).append(' ');
/* 1315 */       } else if (matchingText(NUMERIC_PAREN_LIST_PAT, str1, arrayOfString)) {
/* 1316 */         if (this.myHtmlConverterOptions.dotOnlyNumericLists) {
/* 1317 */           ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(arrayOfString[0])).append(". ");
/*      */         } else {
/* 1319 */           ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(arrayOfString[0])).append(") ");
/*      */         } 
/* 1321 */       } else if (matchingText(NON_NUMERIC_DOT_LIST_PAT, str1, arrayOfString)) {
/* 1322 */         ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(convertNumeric(arrayOfString[0]))).append(". ");
/* 1323 */         if (this.myHtmlConverterOptions.commentOriginalNonNumericListItem) ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(" <!-- ")).append(arrayOfString[0])).append(" -->"); 
/* 1324 */       } else if (matchingText(NON_NUMERIC_PAREN_LIST_PAT, str1, arrayOfString)) {
/* 1325 */         if (this.myHtmlConverterOptions.dotOnlyNumericLists) {
/* 1326 */           ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(convertNumeric(arrayOfString[0]))).append(". ");
/* 1327 */           if (this.myHtmlConverterOptions.commentOriginalNonNumericListItem) ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(" <!-- ")).append(arrayOfString[0])).append(" -->"); 
/*      */         } else {
/* 1329 */           ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(convertNumeric(arrayOfString[0]))).append(") ");
/* 1330 */           if (this.myHtmlConverterOptions.commentOriginalNonNumericListItem) ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append(" <!-- ")).append(arrayOfString[0])).append(" -->"); 
/*      */         } 
/* 1332 */       } else if (BULLET_LIST_PAT.matcher(str1).matches()) {
/* 1333 */         paramHtmlMarkdownWriter.append("* ");
/*      */       } else {
/* 1335 */         ((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append("* ")).append(str1);
/*      */       } 
/* 1337 */       paramHtmlNodeConverterContext.transferIdToParent();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1342 */     paramHtmlNodeConverterContext.renderChildren((Node)str1, true, paramHtmlNodeConverterContext::transferIdToParent);
/*      */   }
/*      */   
/*      */   private void processComment(Comment paramComment, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/* 1346 */     if (this.myHtmlConverterOptions.renderComments) {
/* 1347 */       ((HtmlMarkdownWriter)((HtmlMarkdownWriter)paramHtmlMarkdownWriter.append("<!--")).append(paramComment.getData())).append("-->");
/*      */     }
/*      */   }
/*      */   
/*      */   private void processText(TextNode paramTextNode, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/* 1352 */     if (paramHtmlMarkdownWriter.isPreFormatted()) {
/* 1353 */       paramHtmlMarkdownWriter.append(paramHtmlNodeConverterContext.prepareText(paramTextNode.getWholeText(), true)); return;
/*      */     } 
/* 1355 */     String str = paramHtmlNodeConverterContext.prepareText(paramTextNode.text());
/* 1356 */     if (paramHtmlMarkdownWriter.offsetWithPending() != 0 || !str.trim().isEmpty())
/* 1357 */       paramHtmlMarkdownWriter.append(str); 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\internal\HtmlConverterCoreNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */