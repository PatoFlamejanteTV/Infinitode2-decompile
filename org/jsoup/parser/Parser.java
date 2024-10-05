/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.util.List;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
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
/*     */ public class Parser
/*     */ {
/*     */   public static final String NamespaceHtml = "http://www.w3.org/1999/xhtml";
/*     */   public static final String NamespaceXml = "http://www.w3.org/XML/1998/namespace";
/*     */   public static final String NamespaceMathml = "http://www.w3.org/1998/Math/MathML";
/*     */   public static final String NamespaceSvg = "http://www.w3.org/2000/svg";
/*     */   private TreeBuilder treeBuilder;
/*     */   private ParseErrorList errors;
/*     */   private ParseSettings settings;
/*     */   private boolean trackPosition = false;
/*     */   
/*     */   public Parser(TreeBuilder paramTreeBuilder) {
/*  32 */     this.treeBuilder = paramTreeBuilder;
/*  33 */     this.settings = paramTreeBuilder.defaultSettings();
/*  34 */     this.errors = ParseErrorList.noTracking();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parser newInstance() {
/*  42 */     return new Parser(this);
/*     */   }
/*     */   
/*     */   private Parser(Parser paramParser) {
/*  46 */     this.treeBuilder = paramParser.treeBuilder.newInstance();
/*  47 */     this.errors = new ParseErrorList(paramParser.errors);
/*  48 */     this.settings = new ParseSettings(paramParser.settings);
/*  49 */     this.trackPosition = paramParser.trackPosition;
/*     */   }
/*     */   
/*     */   public Document parseInput(String paramString1, String paramString2) {
/*  53 */     return this.treeBuilder.parse(new StringReader(paramString1), paramString2, this);
/*     */   }
/*     */   
/*     */   public Document parseInput(Reader paramReader, String paramString) {
/*  57 */     return this.treeBuilder.parse(paramReader, paramString, this);
/*     */   }
/*     */   
/*     */   public List<Node> parseFragmentInput(String paramString1, Element paramElement, String paramString2) {
/*  61 */     return this.treeBuilder.parseFragment(paramString1, paramElement, paramString2, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TreeBuilder getTreeBuilder() {
/*  69 */     return this.treeBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parser setTreeBuilder(TreeBuilder paramTreeBuilder) {
/*  78 */     this.treeBuilder = paramTreeBuilder;
/*  79 */     paramTreeBuilder.parser = this;
/*  80 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTrackErrors() {
/*  88 */     return (this.errors.getMaxSize() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parser setTrackErrors(int paramInt) {
/*  97 */     this.errors = (paramInt > 0) ? ParseErrorList.tracking(paramInt) : ParseErrorList.noTracking();
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ParseErrorList getErrors() {
/* 107 */     return this.errors;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTrackPosition() {
/* 116 */     return this.trackPosition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parser setTrackPosition(boolean paramBoolean) {
/* 126 */     this.trackPosition = paramBoolean;
/* 127 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parser settings(ParseSettings paramParseSettings) {
/* 136 */     this.settings = paramParseSettings;
/* 137 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ParseSettings settings() {
/* 145 */     return this.settings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isContentForTagData(String paramString) {
/* 153 */     return getTreeBuilder().isContentForTagData(paramString);
/*     */   }
/*     */   
/*     */   public String defaultNamespace() {
/* 157 */     return getTreeBuilder().defaultNamespace();
/*     */   }
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
/*     */   public static Document parse(String paramString1, String paramString2) {
/*     */     HtmlTreeBuilder htmlTreeBuilder;
/* 171 */     return (htmlTreeBuilder = new HtmlTreeBuilder()).parse(new StringReader(paramString1), paramString2, new Parser(htmlTreeBuilder));
/*     */   }
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
/*     */   public static List<Node> parseFragment(String paramString1, Element paramElement, String paramString2) {
/*     */     HtmlTreeBuilder htmlTreeBuilder;
/* 186 */     return (htmlTreeBuilder = new HtmlTreeBuilder()).parseFragment(paramString1, paramElement, paramString2, new Parser(htmlTreeBuilder));
/*     */   }
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
/*     */   public static List<Node> parseFragment(String paramString1, Element paramElement, String paramString2, ParseErrorList paramParseErrorList) {
/* 201 */     HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
/*     */     Parser parser;
/* 203 */     (parser = new Parser(htmlTreeBuilder)).errors = paramParseErrorList;
/* 204 */     return htmlTreeBuilder.parseFragment(paramString1, paramElement, paramString2, parser);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Node> parseXmlFragment(String paramString1, String paramString2) {
/*     */     XmlTreeBuilder xmlTreeBuilder;
/* 216 */     return (xmlTreeBuilder = new XmlTreeBuilder()).parseFragment(paramString1, paramString2, new Parser(xmlTreeBuilder));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Document parseBodyFragment(String paramString1, String paramString2) {
/*     */     Document document;
/* 229 */     Element element = (document = Document.createShell(paramString2)).body();
/*     */     Node[] arrayOfNode1;
/*     */     List<Node> list;
/* 232 */     for (int j = (arrayOfNode1 = (list = parseFragment(paramString1, element, paramString2)).<Node>toArray(new Node[0])).length - 1; j > 0; j--)
/* 233 */       arrayOfNode1[j].remove();  int i; Node[] arrayOfNode2;
/*     */     byte b;
/* 235 */     for (i = (arrayOfNode2 = arrayOfNode1).length, b = 0; b < i; ) { Node node = arrayOfNode2[b];
/* 236 */       element.appendChild(node); b++; }
/*     */     
/* 238 */     return document;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unescapeEntities(String paramString, boolean paramBoolean) {
/*     */     Parser parser;
/* 249 */     (parser = htmlParser()).treeBuilder.initialiseParse(new StringReader(paramString), "", parser);
/*     */     Tokeniser tokeniser;
/* 251 */     return (tokeniser = new Tokeniser(parser.treeBuilder)).unescapeEntities(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Parser htmlParser() {
/* 262 */     return new Parser(new HtmlTreeBuilder());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Parser xmlParser() {
/* 271 */     return new Parser(new XmlTreeBuilder());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\Parser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */