/*      */ package org.jsoup.parser;
/*      */ 
/*      */ import java.io.Reader;
/*      */ import java.io.StringReader;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import org.jsoup.helper.Validate;
/*      */ import org.jsoup.internal.Normalizer;
/*      */ import org.jsoup.internal.StringUtil;
/*      */ import org.jsoup.nodes.Attributes;
/*      */ import org.jsoup.nodes.CDataNode;
/*      */ import org.jsoup.nodes.Comment;
/*      */ import org.jsoup.nodes.DataNode;
/*      */ import org.jsoup.nodes.Document;
/*      */ import org.jsoup.nodes.Element;
/*      */ import org.jsoup.nodes.FormElement;
/*      */ import org.jsoup.nodes.Node;
/*      */ import org.jsoup.nodes.TextNode;
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
/*      */ public class HtmlTreeBuilder
/*      */   extends TreeBuilder
/*      */ {
/*   32 */   static final String[] TagsSearchInScope = new String[] { "applet", "caption", "html", "marquee", "object", "table", "td", "th" };
/*   33 */   static final String[] TagSearchList = new String[] { "ol", "ul" };
/*   34 */   static final String[] TagSearchButton = new String[] { "button" };
/*   35 */   static final String[] TagSearchTableScope = new String[] { "html", "table" };
/*   36 */   static final String[] TagSearchSelectScope = new String[] { "optgroup", "option" };
/*   37 */   static final String[] TagSearchEndTags = new String[] { "dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc" };
/*   38 */   static final String[] TagThoroughSearchEndTags = new String[] { "caption", "colgroup", "dd", "dt", "li", "optgroup", "option", "p", "rb", "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr" };
/*   39 */   static final String[] TagSearchSpecial = new String[] { "address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   47 */   static final String[] TagMathMlTextIntegration = new String[] { "mi", "mn", "mo", "ms", "mtext" };
/*   48 */   static final String[] TagSvgHtmlIntegration = new String[] { "desc", "foreignObject", "title" };
/*      */   
/*      */   public static final int MaxScopeSearchDepth = 100;
/*      */   
/*      */   private HtmlTreeBuilderState state;
/*      */   
/*      */   private HtmlTreeBuilderState originalState;
/*      */   private boolean baseUriSetFromDoc;
/*      */   private Element headElement;
/*      */   private FormElement formElement;
/*      */   private Element contextElement;
/*      */   private ArrayList<Element> formattingElements;
/*      */   private ArrayList<HtmlTreeBuilderState> tmplInsertMode;
/*      */   private List<Token.Character> pendingTableCharacters;
/*      */   private Token.EndTag emptyEnd;
/*      */   private boolean framesetOk;
/*      */   private boolean fosterInserts;
/*      */   private boolean fragmentParsing;
/*      */   private static final int maxQueueDepth = 256;
/*      */   
/*      */   ParseSettings defaultSettings() {
/*   69 */     return ParseSettings.htmlDefault;
/*      */   }
/*      */ 
/*      */   
/*      */   HtmlTreeBuilder newInstance() {
/*   74 */     return new HtmlTreeBuilder();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void initialiseParse(Reader paramReader, String paramString, Parser paramParser) {
/*   79 */     super.initialiseParse(paramReader, paramString, paramParser);
/*      */ 
/*      */     
/*   82 */     this.state = HtmlTreeBuilderState.Initial;
/*   83 */     this.originalState = null;
/*   84 */     this.baseUriSetFromDoc = false;
/*   85 */     this.headElement = null;
/*   86 */     this.formElement = null;
/*   87 */     this.contextElement = null;
/*   88 */     this.formattingElements = new ArrayList<>();
/*   89 */     this.tmplInsertMode = new ArrayList<>();
/*   90 */     this.pendingTableCharacters = new ArrayList<>();
/*   91 */     this.emptyEnd = new Token.EndTag(this);
/*   92 */     this.framesetOk = true;
/*   93 */     this.fosterInserts = false;
/*   94 */     this.fragmentParsing = false;
/*      */   }
/*      */   
/*      */   List<Node> parseFragment(String paramString1, Element paramElement, String paramString2, Parser paramParser) {
/*      */     Element element;
/*   99 */     this.state = HtmlTreeBuilderState.Initial;
/*  100 */     initialiseParse(new StringReader(paramString1), paramString2, paramParser);
/*  101 */     this.contextElement = paramElement;
/*  102 */     this.fragmentParsing = true;
/*  103 */     paramString1 = null;
/*      */     
/*  105 */     if (paramElement != null) {
/*  106 */       if (paramElement.ownerDocument() != null) {
/*  107 */         this.doc.quirksMode(paramElement.ownerDocument().quirksMode());
/*      */       }
/*      */       
/*      */       String str;
/*  111 */       switch (str = paramElement.normalName()) {
/*      */         case "title":
/*      */         case "textarea":
/*  114 */           this.tokeniser.transition(TokeniserState.Rcdata);
/*      */           break;
/*      */         case "iframe":
/*      */         case "noembed":
/*      */         case "noframes":
/*      */         case "style":
/*      */         case "xmp":
/*  121 */           this.tokeniser.transition(TokeniserState.Rawtext);
/*      */           break;
/*      */         case "script":
/*  124 */           this.tokeniser.transition(TokeniserState.ScriptData);
/*      */           break;
/*      */         case "plaintext":
/*  127 */           this.tokeniser.transition(TokeniserState.PLAINTEXT);
/*      */           break;
/*      */         case "template":
/*  130 */           this.tokeniser.transition(TokeniserState.Data);
/*  131 */           pushTemplateMode(HtmlTreeBuilderState.InTemplate);
/*      */           break;
/*      */         default:
/*  134 */           this.tokeniser.transition(TokeniserState.Data); break;
/*      */       } 
/*  136 */       element = new Element(tagFor(str, this.settings), paramString2);
/*  137 */       this.doc.appendChild((Node)element);
/*  138 */       push(element);
/*  139 */       resetInsertionMode();
/*      */ 
/*      */ 
/*      */       
/*  143 */       Element element1 = paramElement;
/*  144 */       while (element1 != null) {
/*  145 */         if (element1 instanceof FormElement) {
/*  146 */           this.formElement = (FormElement)element1;
/*      */           break;
/*      */         } 
/*  149 */         element1 = element1.parent();
/*      */       } 
/*      */     } 
/*      */     
/*  153 */     runParser();
/*  154 */     if (paramElement != null) {
/*      */       List<?> list;
/*      */ 
/*      */       
/*  158 */       if (!(list = element.siblingNodes()).isEmpty())
/*  159 */         element.insertChildren(-1, list); 
/*  160 */       return element.childNodes();
/*      */     } 
/*      */     
/*  163 */     return this.doc.childNodes();
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean process(Token paramToken) {
/*      */     HtmlTreeBuilderState htmlTreeBuilderState;
/*  169 */     return (htmlTreeBuilderState = useCurrentOrForeignInsert(paramToken) ? this.state : HtmlTreeBuilderState.ForeignContent).process(paramToken, this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   boolean useCurrentOrForeignInsert(Token paramToken) {
/*  175 */     if (this.stack.isEmpty())
/*  176 */       return true; 
/*      */     Element element;
/*  178 */     String str = (element = currentElement()).tag().namespace();
/*      */ 
/*      */     
/*  181 */     if ("http://www.w3.org/1999/xhtml".equals(str)) {
/*  182 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  186 */     if (isMathmlTextIntegration(element)) {
/*  187 */       if (paramToken.isStartTag() && 
/*  188 */         !"mglyph".equals((paramToken.asStartTag()).normalName) && 
/*  189 */         !"malignmark".equals((paramToken.asStartTag()).normalName))
/*  190 */         return true; 
/*  191 */       if (paramToken.isCharacter()) {
/*  192 */         return true;
/*      */       }
/*      */     } 
/*  195 */     if ("http://www.w3.org/1998/Math/MathML".equals(str) && element
/*  196 */       .nameIs("annotation-xml") && paramToken
/*  197 */       .isStartTag() && "svg"
/*  198 */       .equals((paramToken.asStartTag()).normalName)) {
/*  199 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  203 */     if (isHtmlIntegration(element) && (paramToken
/*  204 */       .isStartTag() || paramToken.isCharacter())) {
/*  205 */       return true;
/*      */     }
/*      */     
/*  208 */     return paramToken.isEOF();
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
/*      */   static boolean isMathmlTextIntegration(Element paramElement) {
/*  220 */     if ("http://www.w3.org/1998/Math/MathML".equals(paramElement.tag().namespace()) && 
/*  221 */       StringUtil.inSorted(paramElement.normalName(), TagMathMlTextIntegration)) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isHtmlIntegration(Element paramElement) {
/*      */     String str;
/*  233 */     if ("http://www.w3.org/1998/Math/MathML".equals(paramElement.tag().namespace()) && paramElement
/*  234 */       .nameIs("annotation-xml") && ((
/*      */       
/*  236 */       str = Normalizer.normalize(paramElement.attr("encoding"))).equals("text/html") || str.equals("application/xhtml+xml"))) {
/*  237 */       return true;
/*      */     }
/*  239 */     if ("http://www.w3.org/2000/svg".equals(paramElement.tag().namespace()) && 
/*  240 */       StringUtil.in(paramElement.tagName(), TagSvgHtmlIntegration)) {
/*  241 */       return true;
/*      */     }
/*  243 */     return false;
/*      */   }
/*      */   
/*      */   boolean process(Token paramToken, HtmlTreeBuilderState paramHtmlTreeBuilderState) {
/*  247 */     return paramHtmlTreeBuilderState.process(paramToken, this);
/*      */   }
/*      */   
/*      */   void transition(HtmlTreeBuilderState paramHtmlTreeBuilderState) {
/*  251 */     this.state = paramHtmlTreeBuilderState;
/*      */   }
/*      */   
/*      */   HtmlTreeBuilderState state() {
/*  255 */     return this.state;
/*      */   }
/*      */   
/*      */   void markInsertionMode() {
/*  259 */     this.originalState = this.state;
/*      */   }
/*      */   
/*      */   HtmlTreeBuilderState originalState() {
/*  263 */     return this.originalState;
/*      */   }
/*      */   
/*      */   void framesetOk(boolean paramBoolean) {
/*  267 */     this.framesetOk = paramBoolean;
/*      */   }
/*      */   
/*      */   boolean framesetOk() {
/*  271 */     return this.framesetOk;
/*      */   }
/*      */   
/*      */   Document getDocument() {
/*  275 */     return this.doc;
/*      */   }
/*      */   
/*      */   String getBaseUri() {
/*  279 */     return this.baseUri;
/*      */   }
/*      */   
/*      */   void maybeSetBaseUri(Element paramElement) {
/*  283 */     if (this.baseUriSetFromDoc) {
/*      */       return;
/*      */     }
/*      */     String str;
/*  287 */     if ((str = paramElement.absUrl("href")).length() != 0) {
/*  288 */       this.baseUri = str;
/*  289 */       this.baseUriSetFromDoc = true;
/*  290 */       this.doc.setBaseUri(str);
/*      */     } 
/*      */   }
/*      */   
/*      */   boolean isFragmentParsing() {
/*  295 */     return this.fragmentParsing;
/*      */   }
/*      */   
/*      */   void error(HtmlTreeBuilderState paramHtmlTreeBuilderState) {
/*  299 */     if (this.parser.getErrors().canAddError()) {
/*  300 */       this.parser.getErrors().add(new ParseError(this.reader, "Unexpected %s token [%s] when in state [%s]", new Object[] { this.currentToken
/*  301 */               .tokenType(), this.currentToken, paramHtmlTreeBuilderState }));
/*      */     }
/*      */   }
/*      */   
/*      */   Element createElementFor(Token.StartTag paramStartTag, String paramString, boolean paramBoolean) {
/*  306 */     Attributes attributes = paramStartTag.attributes;
/*  307 */     if (!paramBoolean)
/*  308 */       attributes = this.settings.normalizeAttributes(attributes);  int i;
/*  309 */     if (attributes != null && !attributes.isEmpty() && (
/*      */       
/*  311 */       i = attributes.deduplicate(this.settings)) > 0) {
/*  312 */       error("Dropped duplicate attribute(s) in tag [%s]", new Object[] { paramStartTag.normalName });
/*      */     }
/*      */ 
/*      */     
/*      */     Tag tag;
/*      */ 
/*      */     
/*  319 */     if ((tag = tagFor(paramStartTag.tagName, paramString, paramBoolean ? ParseSettings.preserveCase : this.settings)).normalName().equals("form"))
/*  320 */       return (Element)new FormElement(tag, null, attributes); 
/*  321 */     return new Element(tag, null, attributes);
/*      */   }
/*      */ 
/*      */   
/*      */   Element insertElementFor(Token.StartTag paramStartTag) {
/*  326 */     Element element = createElementFor(paramStartTag, "http://www.w3.org/1999/xhtml", false);
/*  327 */     doInsertElement(element, paramStartTag);
/*      */ 
/*      */     
/*  330 */     if (paramStartTag.isSelfClosing()) {
/*      */       Tag tag;
/*  332 */       if ((tag = element.tag()).isKnownTag()) {
/*  333 */         if (!tag.isEmpty()) {
/*  334 */           this.tokeniser.error("Tag [%s] cannot be self closing; not a void tag", new Object[] { tag.normalName() });
/*      */         }
/*      */       } else {
/*      */         
/*  338 */         tag.setSelfClosing();
/*      */       } 
/*      */ 
/*      */       
/*  342 */       this.tokeniser.transition(TokeniserState.Data);
/*  343 */       this.tokeniser.emit(this.emptyEnd.reset().name(element.tagName()));
/*      */     } 
/*      */     
/*  346 */     return element;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Element insertForeignElementFor(Token.StartTag paramStartTag, String paramString) {
/*  353 */     Element element = createElementFor(paramStartTag, paramString, true);
/*  354 */     doInsertElement(element, paramStartTag);
/*      */     
/*  356 */     if (paramStartTag.isSelfClosing()) {
/*  357 */       element.tag().setSelfClosing();
/*  358 */       pop();
/*      */     } 
/*      */     
/*  361 */     return element;
/*      */   }
/*      */   
/*      */   Element insertEmptyElementFor(Token.StartTag paramStartTag) {
/*  365 */     Element element = createElementFor(paramStartTag, "http://www.w3.org/1999/xhtml", false);
/*  366 */     doInsertElement(element, paramStartTag);
/*  367 */     pop();
/*  368 */     return element;
/*      */   }
/*      */   
/*      */   FormElement insertFormElement(Token.StartTag paramStartTag, boolean paramBoolean1, boolean paramBoolean2) {
/*  372 */     FormElement formElement = (FormElement)createElementFor(paramStartTag, "http://www.w3.org/1999/xhtml", false);
/*      */     
/*  374 */     if (!paramBoolean2 || 
/*  375 */       !onStack("template"))
/*      */     {
/*      */       
/*  378 */       setFormElement(formElement);
/*      */     }
/*  380 */     doInsertElement((Element)formElement, paramStartTag);
/*  381 */     if (!paramBoolean1) pop(); 
/*  382 */     return formElement;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void doInsertElement(Element paramElement, Token paramToken) {
/*  391 */     if (paramElement.tag().isFormListed() && this.formElement != null) {
/*  392 */       this.formElement.addElement(paramElement);
/*      */     }
/*      */     
/*  395 */     if (paramElement.hasAttr("xmlns") && !paramElement.attr("xmlns").equals(paramElement.tag().namespace())) {
/*  396 */       error("Invalid xmlns attribute [%s] on tag [%s]", new Object[] { paramElement.attr("xmlns"), paramElement.tagName() });
/*      */     }
/*  398 */     if (isFosterInserts() && StringUtil.inSorted(currentElement().normalName(), HtmlTreeBuilderState.Constants.InTableFoster)) {
/*  399 */       insertInFosterParent((Node)paramElement);
/*      */     } else {
/*  401 */       currentElement().appendChild((Node)paramElement);
/*      */     } 
/*  403 */     push(paramElement);
/*      */   }
/*      */   
/*      */   void insertCommentNode(Token.Comment paramComment) {
/*  407 */     Comment comment = new Comment(paramComment.getData());
/*  408 */     currentElement().appendChild((Node)comment);
/*  409 */     onNodeInserted((Node)comment);
/*      */   }
/*      */ 
/*      */   
/*      */   void insertCharacterNode(Token.Character paramCharacter) {
/*  414 */     Element element = currentElement();
/*  415 */     insertCharacterToElement(paramCharacter, element);
/*      */   }
/*      */ 
/*      */   
/*      */   void insertCharacterToElement(Token.Character paramCharacter, Element paramElement) {
/*      */     TextNode textNode;
/*  421 */     String str1 = paramElement.normalName();
/*  422 */     String str2 = paramCharacter.getData();
/*      */     
/*  424 */     if (paramCharacter.isCData()) {
/*  425 */       CDataNode cDataNode = new CDataNode(str2);
/*  426 */     } else if (isContentForTagData(str1)) {
/*  427 */       DataNode dataNode = new DataNode(str2);
/*      */     } else {
/*  429 */       textNode = new TextNode(str2);
/*  430 */     }  paramElement.appendChild((Node)textNode);
/*  431 */     onNodeInserted((Node)textNode);
/*      */   }
/*      */   
/*      */   ArrayList<Element> getStack() {
/*  435 */     return this.stack;
/*      */   }
/*      */   
/*      */   boolean onStack(Element paramElement) {
/*  439 */     return onStack(this.stack, paramElement);
/*      */   }
/*      */ 
/*      */   
/*      */   boolean onStack(String paramString) {
/*  444 */     return (getFromStack(paramString) != null);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean onStack(ArrayList<Element> paramArrayList, Element paramElement) {
/*      */     int i;
/*  450 */     byte b = ((i = paramArrayList.size() - 1) >= 256) ? (i - 256) : 0;
/*  451 */     for (i = i; i >= b; i--) {
/*      */       Element element;
/*  453 */       if ((element = paramArrayList.get(i)) == paramElement) {
/*  454 */         return true;
/*      */       }
/*      */     } 
/*  457 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   Element getFromStack(String paramString) {
/*      */     int i;
/*  464 */     byte b = ((i = this.stack.size() - 1) >= 256) ? (i - 256) : 0;
/*  465 */     for (i = i; i >= b; i--) {
/*      */       Element element;
/*  467 */       if ((element = this.stack.get(i)).elementIs(paramString, "http://www.w3.org/1999/xhtml")) {
/*  468 */         return element;
/*      */       }
/*      */     } 
/*  471 */     return null;
/*      */   }
/*      */   
/*      */   boolean removeFromStack(Element paramElement) {
/*  475 */     for (int i = this.stack.size() - 1; i >= 0; i--) {
/*      */       Element element;
/*  477 */       if ((element = this.stack.get(i)) == paramElement) {
/*  478 */         this.stack.remove(i);
/*  479 */         onNodeClosed((Node)paramElement);
/*  480 */         return true;
/*      */       } 
/*      */     } 
/*  483 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   Element popStackToClose(String paramString) {
/*  489 */     for (int i = this.stack.size() - 1; i >= 0; i--) {
/*      */       Element element;
/*  491 */       if ((element = pop()).elementIs(paramString, "http://www.w3.org/1999/xhtml")) {
/*  492 */         return element;
/*      */       }
/*      */     } 
/*  495 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   Element popStackToCloseAnyNamespace(String paramString) {
/*  501 */     for (int i = this.stack.size() - 1; i >= 0; i--) {
/*      */       Element element;
/*  503 */       if ((element = pop()).nameIs(paramString)) {
/*  504 */         return element;
/*      */       }
/*      */     } 
/*  507 */     return null;
/*      */   }
/*      */   
/*      */   void popStackToClose(String... paramVarArgs) {
/*      */     Element element;
/*  512 */     for (int i = this.stack.size() - 1; i >= 0 && (
/*      */       
/*  514 */       !StringUtil.inSorted((element = pop()).normalName(), paramVarArgs) || !"http://www.w3.org/1999/xhtml".equals(element.tag().namespace())); i--);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void clearStackToTableContext() {
/*  521 */     clearStackToContext(new String[] { "table", "template" });
/*      */   }
/*      */   
/*      */   void clearStackToTableBodyContext() {
/*  525 */     clearStackToContext(new String[] { "tbody", "tfoot", "thead", "template" });
/*      */   }
/*      */   
/*      */   void clearStackToTableRowContext() {
/*  529 */     clearStackToContext(new String[] { "tr", "template" });
/*      */   }
/*      */ 
/*      */   
/*      */   private void clearStackToContext(String... paramVarArgs) {
/*  534 */     for (int i = this.stack.size() - 1; i >= 0; ) {
/*  535 */       Element element = this.stack.get(i);
/*  536 */       if (!"http://www.w3.org/1999/xhtml".equals(element.tag().namespace()) || (
/*  537 */         !StringUtil.in(element.normalName(), paramVarArgs) && !element.nameIs("html"))) {
/*      */ 
/*      */         
/*  540 */         pop();
/*      */         i--;
/*      */       } 
/*      */     } 
/*      */   } Element aboveOnStack(Element paramElement) {
/*  545 */     assert onStack(paramElement);
/*  546 */     for (int i = this.stack.size() - 1; i >= 0; i--) {
/*      */       Element element;
/*  548 */       if ((element = this.stack.get(i)) == paramElement) {
/*  549 */         return this.stack.get(i - 1);
/*      */       }
/*      */     } 
/*  552 */     return null;
/*      */   }
/*      */   
/*      */   void insertOnStackAfter(Element paramElement1, Element paramElement2) {
/*      */     int i;
/*  557 */     Validate.isTrue(((i = this.stack.lastIndexOf(paramElement1)) != -1));
/*  558 */     this.stack.add(i + 1, paramElement2);
/*      */   }
/*      */   
/*      */   void replaceOnStack(Element paramElement1, Element paramElement2) {
/*  562 */     replaceInQueue(this.stack, paramElement1, paramElement2);
/*      */   }
/*      */   
/*      */   private static void replaceInQueue(ArrayList<Element> paramArrayList, Element paramElement1, Element paramElement2) {
/*      */     int i;
/*  567 */     Validate.isTrue(((i = paramArrayList.lastIndexOf(paramElement1)) != -1));
/*  568 */     paramArrayList.set(i, paramElement2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean resetInsertionMode() {
/*  578 */     boolean bool = false;
/*      */     int i;
/*  580 */     byte b = ((i = this.stack.size() - 1) >= 256) ? (i - 256) : 0;
/*  581 */     HtmlTreeBuilderState htmlTreeBuilderState = this.state;
/*      */     
/*  583 */     if (this.stack.size() == 0) {
/*  584 */       transition(HtmlTreeBuilderState.InBody);
/*      */     }
/*      */     
/*  587 */     for (i = i; i >= b; i--) {
/*  588 */       Element element = this.stack.get(i);
/*  589 */       if (i == b) {
/*  590 */         bool = true;
/*  591 */         if (this.fragmentParsing)
/*  592 */           element = this.contextElement; 
/*      */       } 
/*  594 */       String str = (element != null) ? element.normalName() : "";
/*  595 */       if ("http://www.w3.org/1999/xhtml".equals(element.tag().namespace())) {
/*      */         HtmlTreeBuilderState htmlTreeBuilderState1;
/*      */         
/*  598 */         switch (str) {
/*      */           case "select":
/*  600 */             transition(HtmlTreeBuilderState.InSelect);
/*      */             break;
/*      */           
/*      */           case "td":
/*      */           case "th":
/*  605 */             if (!bool) {
/*  606 */               transition(HtmlTreeBuilderState.InCell);
/*      */               break;
/*      */             } 
/*      */             break;
/*      */           case "tr":
/*  611 */             transition(HtmlTreeBuilderState.InRow);
/*      */             break;
/*      */           case "tbody":
/*      */           case "thead":
/*      */           case "tfoot":
/*  616 */             transition(HtmlTreeBuilderState.InTableBody);
/*      */             break;
/*      */           case "caption":
/*  619 */             transition(HtmlTreeBuilderState.InCaption);
/*      */             break;
/*      */           case "colgroup":
/*  622 */             transition(HtmlTreeBuilderState.InColumnGroup);
/*      */             break;
/*      */           case "table":
/*  625 */             transition(HtmlTreeBuilderState.InTable);
/*      */             break;
/*      */           
/*      */           case "template":
/*  629 */             Validate.notNull(htmlTreeBuilderState1 = currentTemplateMode(), "Bug: no template insertion mode on stack!");
/*  630 */             transition(htmlTreeBuilderState1);
/*      */             break;
/*      */           case "head":
/*  633 */             if (htmlTreeBuilderState1 == null) {
/*  634 */               transition(HtmlTreeBuilderState.InHead);
/*      */               break;
/*      */             } 
/*      */             break;
/*      */           case "body":
/*  639 */             transition(HtmlTreeBuilderState.InBody);
/*      */             break;
/*      */           case "frameset":
/*  642 */             transition(HtmlTreeBuilderState.InFrameset);
/*      */             break;
/*      */           case "html":
/*  645 */             transition((this.headElement == null) ? HtmlTreeBuilderState.BeforeHead : HtmlTreeBuilderState.AfterHead);
/*      */             break;
/*      */         } 
/*  648 */         if (htmlTreeBuilderState1 != null) {
/*  649 */           transition(HtmlTreeBuilderState.InBody); break;
/*      */         } 
/*      */       } 
/*      */     } 
/*  653 */     return (this.state != htmlTreeBuilderState);
/*      */   }
/*      */ 
/*      */   
/*      */   void resetBody() {
/*  658 */     if (!onStack("body")) {
/*  659 */       this.stack.add(this.doc.body());
/*      */     }
/*  661 */     transition(HtmlTreeBuilderState.InBody);
/*      */   }
/*      */ 
/*      */   
/*  665 */   private final String[] specificScopeTarget = new String[] { null }; private static final int maxUsedFormattingElements = 12;
/*      */   
/*      */   private boolean inSpecificScope(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
/*  668 */     this.specificScopeTarget[0] = paramString;
/*  669 */     return inSpecificScope(this.specificScopeTarget, paramArrayOfString1, paramArrayOfString2);
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean inSpecificScope(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3) {
/*      */     int i;
/*  675 */     byte b = ((i = this.stack.size() - 1) > 100) ? (i - 100) : 0;
/*      */ 
/*      */     
/*  678 */     for (i = i; i >= b; i--) {
/*      */       Element element;
/*  680 */       if ((element = this.stack.get(i)).tag().namespace().equals("http://www.w3.org/1999/xhtml")) {
/*      */         String str;
/*      */         
/*  683 */         if (StringUtil.inSorted(str = element.normalName(), paramArrayOfString1))
/*  684 */           return true; 
/*  685 */         if (StringUtil.inSorted(str, paramArrayOfString2))
/*  686 */           return false; 
/*  687 */         if (paramArrayOfString3 != null && StringUtil.inSorted(str, paramArrayOfString3))
/*  688 */           return false; 
/*      */       } 
/*      */     } 
/*  691 */     return false;
/*      */   }
/*      */   
/*      */   boolean inScope(String[] paramArrayOfString) {
/*  695 */     return inSpecificScope(paramArrayOfString, TagsSearchInScope, (String[])null);
/*      */   }
/*      */   
/*      */   boolean inScope(String paramString) {
/*  699 */     return inScope(paramString, (String[])null);
/*      */   }
/*      */   
/*      */   boolean inScope(String paramString, String[] paramArrayOfString) {
/*  703 */     return inSpecificScope(paramString, TagsSearchInScope, paramArrayOfString);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   boolean inListItemScope(String paramString) {
/*  709 */     return inScope(paramString, TagSearchList);
/*      */   }
/*      */   
/*      */   boolean inButtonScope(String paramString) {
/*  713 */     return inScope(paramString, TagSearchButton);
/*      */   }
/*      */   
/*      */   boolean inTableScope(String paramString) {
/*  717 */     return inSpecificScope(paramString, TagSearchTableScope, (String[])null);
/*      */   }
/*      */   
/*      */   boolean inSelectScope(String paramString) {
/*  721 */     for (int i = this.stack.size() - 1; i >= 0; i--) {
/*      */       String str;
/*      */       Element element;
/*  724 */       if ((str = (element = this.stack.get(i)).normalName()).equals(paramString))
/*  725 */         return true; 
/*  726 */       if (!StringUtil.inSorted(str, TagSearchSelectScope))
/*  727 */         return false; 
/*      */     } 
/*  729 */     Validate.fail("Should not be reachable");
/*  730 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean onStackNot(String[] paramArrayOfString) {
/*      */     int i;
/*  736 */     byte b = ((i = this.stack.size() - 1) > 100) ? (i - 100) : 0;
/*      */ 
/*      */     
/*  739 */     for (i = i; i >= b; i--) {
/*      */       String str;
/*  741 */       if (!StringUtil.inSorted(str = ((Element)this.stack.get(i)).normalName(), paramArrayOfString))
/*  742 */         return true; 
/*      */     } 
/*  744 */     return false;
/*      */   }
/*      */   
/*      */   void setHeadElement(Element paramElement) {
/*  748 */     this.headElement = paramElement;
/*      */   }
/*      */   
/*      */   Element getHeadElement() {
/*  752 */     return this.headElement;
/*      */   }
/*      */   
/*      */   boolean isFosterInserts() {
/*  756 */     return this.fosterInserts;
/*      */   }
/*      */   
/*      */   void setFosterInserts(boolean paramBoolean) {
/*  760 */     this.fosterInserts = paramBoolean;
/*      */   }
/*      */   
/*      */   FormElement getFormElement() {
/*  764 */     return this.formElement;
/*      */   }
/*      */   
/*      */   void setFormElement(FormElement paramFormElement) {
/*  768 */     this.formElement = paramFormElement;
/*      */   }
/*      */   
/*      */   void resetPendingTableCharacters() {
/*  772 */     this.pendingTableCharacters.clear();
/*      */   }
/*      */   
/*      */   List<Token.Character> getPendingTableCharacters() {
/*  776 */     return this.pendingTableCharacters;
/*      */   }
/*      */ 
/*      */   
/*      */   void addPendingTableCharacters(Token.Character paramCharacter) {
/*  781 */     paramCharacter = paramCharacter.clone();
/*  782 */     this.pendingTableCharacters.add(paramCharacter);
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
/*      */   void generateImpliedEndTags(String paramString) {
/*  797 */     while (StringUtil.inSorted(currentElement().normalName(), TagSearchEndTags) && (
/*  798 */       paramString == null || !currentElementIs(paramString)))
/*      */     {
/*  800 */       pop();
/*      */     }
/*      */   }
/*      */   
/*      */   void generateImpliedEndTags() {
/*  805 */     generateImpliedEndTags(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void generateImpliedEndTags(boolean paramBoolean) {
/*  813 */     String[] arrayOfString = paramBoolean ? TagThoroughSearchEndTags : TagSearchEndTags;
/*  814 */     while ("http://www.w3.org/1999/xhtml".equals(currentElement().tag().namespace()) && 
/*  815 */       StringUtil.inSorted(currentElement().normalName(), arrayOfString)) {
/*  816 */       pop();
/*      */     }
/*      */   }
/*      */   
/*      */   void closeElement(String paramString) {
/*  821 */     generateImpliedEndTags(paramString);
/*  822 */     if (!paramString.equals(currentElement().normalName())) error(state()); 
/*  823 */     popStackToClose(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isSpecial(Element paramElement) {
/*      */     String str;
/*  830 */     return StringUtil.inSorted(str = paramElement.normalName(), TagSearchSpecial);
/*      */   }
/*      */   
/*      */   Element lastFormattingElement() {
/*  834 */     return (this.formattingElements.size() > 0) ? this.formattingElements.get(this.formattingElements.size() - 1) : null;
/*      */   }
/*      */   
/*      */   int positionOfElement(Element paramElement) {
/*  838 */     for (byte b = 0; b < this.formattingElements.size(); b++) {
/*  839 */       if (paramElement == this.formattingElements.get(b))
/*  840 */         return b; 
/*      */     } 
/*  842 */     return -1;
/*      */   }
/*      */   
/*      */   Element removeLastFormattingElement() {
/*      */     int i;
/*  847 */     if ((i = this.formattingElements.size()) > 0) {
/*  848 */       return this.formattingElements.remove(i - 1);
/*      */     }
/*  850 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   void pushActiveFormattingElements(Element paramElement) {
/*  855 */     checkActiveFormattingElements(paramElement);
/*  856 */     this.formattingElements.add(paramElement);
/*      */   }
/*      */   
/*      */   void pushWithBookmark(Element paramElement, int paramInt) {
/*  860 */     checkActiveFormattingElements(paramElement);
/*      */     
/*      */     try {
/*  863 */       this.formattingElements.add(paramInt, paramElement); return;
/*  864 */     } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*  865 */       this.formattingElements.add(paramElement);
/*      */       return;
/*      */     } 
/*      */   }
/*      */   void checkActiveFormattingElements(Element paramElement) {
/*  870 */     byte b = 0;
/*      */     int i, j;
/*  872 */     if ((j = (i = this.formattingElements.size() - 1) - 12) < 0) j = 0; 
/*      */     Element element;
/*  874 */     for (i = i; i >= j && (
/*      */       
/*  876 */       element = this.formattingElements.get(i)) != null; i--) {
/*      */ 
/*      */       
/*  879 */       if (isSameFormattingElement(paramElement, element)) {
/*  880 */         b++;
/*      */       }
/*  882 */       if (b == 3) {
/*  883 */         this.formattingElements.remove(i);
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean isSameFormattingElement(Element paramElement1, Element paramElement2) {
/*  891 */     if (paramElement1.normalName().equals(paramElement2.normalName()) && paramElement1
/*      */       
/*  893 */       .attributes().equals(paramElement2.attributes())) return true; 
/*      */     return false;
/*      */   }
/*      */   
/*      */   void reconstructFormattingElements() {
/*  898 */     if (this.stack.size() > 256)
/*      */       return; 
/*      */     Element element;
/*  901 */     if ((element = lastFormattingElement()) == null || onStack(element)) {
/*      */       return;
/*      */     }
/*  904 */     element = element;
/*      */     int i, j;
/*  906 */     if ((j = (i = this.formattingElements.size()) - 12) < 0) j = 0; 
/*  907 */     int k = i - 1;
/*  908 */     boolean bool = false;
/*      */     do {
/*  910 */       if (k == j) {
/*  911 */         bool = true;
/*      */         
/*      */         break;
/*      */       } 
/*  915 */     } while ((element = this.formattingElements.get(--k)) != null && !onStack(element));
/*      */ 
/*      */     
/*      */     while (true) {
/*  919 */       if (!bool)
/*  920 */         element = this.formattingElements.get(++k); 
/*  921 */       Validate.notNull(element);
/*      */ 
/*      */       
/*  924 */       bool = false;
/*  925 */       Element element1 = new Element(tagFor(element.normalName(), this.settings), null, element.attributes().clone());
/*  926 */       doInsertElement(element1, (Token)null);
/*      */ 
/*      */       
/*  929 */       this.formattingElements.set(k, element1);
/*      */ 
/*      */       
/*  932 */       if (k != i - 1)
/*      */         continue; 
/*      */       break;
/*      */     } 
/*      */   }
/*      */   void clearFormattingElementsToLastMarker() {
/*      */     Element element;
/*  939 */     while (!this.formattingElements.isEmpty() && (
/*      */       
/*  941 */       element = removeLastFormattingElement()) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void removeFromActiveFormattingElements(Element paramElement) {
/*  947 */     for (int i = this.formattingElements.size() - 1; i >= 0; i--) {
/*      */       Element element;
/*  949 */       if ((element = this.formattingElements.get(i)) == paramElement) {
/*  950 */         this.formattingElements.remove(i);
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   boolean isInActiveFormattingElements(Element paramElement) {
/*  957 */     return onStack(this.formattingElements, paramElement);
/*      */   }
/*      */   
/*      */   Element getActiveFormattingElement(String paramString) {
/*      */     Element element;
/*  962 */     for (int i = this.formattingElements.size() - 1; i >= 0 && (
/*      */       
/*  964 */       element = this.formattingElements.get(i)) != null; i--) {
/*      */       
/*  966 */       if (element.nameIs(paramString))
/*  967 */         return element; 
/*      */     } 
/*  969 */     return null;
/*      */   }
/*      */   
/*      */   void replaceActiveFormattingElement(Element paramElement1, Element paramElement2) {
/*  973 */     replaceInQueue(this.formattingElements, paramElement1, paramElement2);
/*      */   }
/*      */   
/*      */   void insertMarkerToFormattingElements() {
/*  977 */     this.formattingElements.add(null);
/*      */   }
/*      */ 
/*      */   
/*      */   void insertInFosterParent(Node paramNode) {
/*  982 */     Element element1, element2 = getFromStack("table");
/*  983 */     boolean bool = false;
/*  984 */     if (element2 != null)
/*  985 */     { if (element2.parent() != null) {
/*  986 */         element2.parent(); element1 = null;
/*  987 */         bool = true;
/*      */       } else {
/*  989 */         element1 = aboveOnStack(element2);
/*      */       }  }
/*  991 */     else { element1 = this.stack.get(0); }
/*      */ 
/*      */     
/*  994 */     if (bool) {
/*  995 */       Validate.notNull(element2);
/*  996 */       element2.before(paramNode);
/*      */       return;
/*      */     } 
/*  999 */     element1.appendChild(paramNode);
/*      */   }
/*      */ 
/*      */   
/*      */   void pushTemplateMode(HtmlTreeBuilderState paramHtmlTreeBuilderState) {
/* 1004 */     this.tmplInsertMode.add(paramHtmlTreeBuilderState);
/*      */   }
/*      */   
/*      */   HtmlTreeBuilderState popTemplateMode() {
/* 1008 */     if (this.tmplInsertMode.size() > 0) {
/* 1009 */       return this.tmplInsertMode.remove(this.tmplInsertMode.size() - 1);
/*      */     }
/* 1011 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   int templateModeSize() {
/* 1016 */     return this.tmplInsertMode.size();
/*      */   }
/*      */   
/*      */   HtmlTreeBuilderState currentTemplateMode() {
/* 1020 */     return (this.tmplInsertMode.size() > 0) ? this.tmplInsertMode.get(this.tmplInsertMode.size() - 1) : null;
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1025 */     return "TreeBuilder{currentToken=" + this.currentToken + ", state=" + this.state + ", currentElement=" + 
/*      */ 
/*      */       
/* 1028 */       currentElement() + '}';
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean isContentForTagData(String paramString) {
/* 1033 */     return (paramString.equals("script") || paramString.equals("style"));
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\HtmlTreeBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */