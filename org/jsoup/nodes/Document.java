/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.jsoup.Connection;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.helper.DataUtil;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.parser.ParseSettings;
/*     */ import org.jsoup.parser.Parser;
/*     */ import org.jsoup.parser.Tag;
/*     */ import org.jsoup.select.Elements;
/*     */ import org.jsoup.select.Evaluator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Document
/*     */   extends Element
/*     */ {
/*     */   private Connection connection;
/*  28 */   private OutputSettings outputSettings = new OutputSettings();
/*     */   private Parser parser;
/*  30 */   private QuirksMode quirksMode = QuirksMode.noQuirks;
/*     */ 
/*     */ 
/*     */   
/*     */   private final String location;
/*     */ 
/*     */   
/*     */   private boolean updateMetaCharset = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public Document(String paramString1, String paramString2) {
/*  42 */     super(Tag.valueOf("#root", paramString1, ParseSettings.htmlDefault), paramString2);
/*  43 */     this.location = paramString2;
/*  44 */     this.parser = Parser.htmlParser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Document(String paramString) {
/*  54 */     this("http://www.w3.org/1999/xhtml", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Document createShell(String paramString) {
/*  63 */     Validate.notNull(paramString);
/*     */     
/*     */     Document document;
/*  66 */     (document = new Document(paramString)).parser = document.parser();
/*     */     Element element;
/*  68 */     (element = document.appendElement("html")).appendElement("head");
/*  69 */     element.appendElement("body");
/*     */     
/*  71 */     return document;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String location() {
/*  81 */     return this.location;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection connection() {
/*  91 */     if (this.connection == null) {
/*  92 */       return Jsoup.newSession();
/*     */     }
/*  94 */     return this.connection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocumentType documentType() {
/* 102 */     for (Iterator<Node> iterator = this.childNodes.iterator(); iterator.hasNext(); ) {
/* 103 */       Node node; if (node = iterator.next() instanceof DocumentType)
/* 104 */         return (DocumentType)node; 
/* 105 */       if (node instanceof LeafNode);
/*     */     } 
/*     */     
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Element htmlEl() {
/* 117 */     Element element = firstElementChild();
/* 118 */     while (element != null) {
/* 119 */       if (element.nameIs("html"))
/* 120 */         return element; 
/* 121 */       element = element.nextElementSibling();
/*     */     } 
/* 123 */     return appendElement("html");
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
/*     */   public Element head() {
/* 136 */     Element element1, element2 = (element1 = htmlEl()).firstElementChild();
/* 137 */     while (element2 != null) {
/* 138 */       if (element2.nameIs("head"))
/* 139 */         return element2; 
/* 140 */       element2 = element2.nextElementSibling();
/*     */     } 
/* 142 */     return element1.prependElement("head");
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
/*     */   public Element body() {
/* 156 */     Element element1, element2 = (element1 = htmlEl()).firstElementChild();
/* 157 */     while (element2 != null) {
/* 158 */       if (element2.nameIs("body") || element2.nameIs("frameset"))
/* 159 */         return element2; 
/* 160 */       element2 = element2.nextElementSibling();
/*     */     } 
/* 162 */     return element1.appendElement("body");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FormElement> forms() {
/* 173 */     return select("form").forms();
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
/*     */   public FormElement expectForm(String paramString) {
/*     */     Elements elements;
/* 186 */     for (Iterator<Element> iterator = (elements = select(paramString)).iterator(); iterator.hasNext();) {
/* 187 */       if (element = iterator.next() instanceof FormElement) return (FormElement)element; 
/*     */     } 
/* 189 */     Validate.fail("No form elements matched the query '%s' in the document.", new Object[] { paramString });
/* 190 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String title() {
/*     */     Element element;
/* 200 */     return ((element = head().selectFirst(titleEval)) != null) ? StringUtil.normaliseWhitespace(element.text()).trim() : "";
/*     */   }
/* 202 */   private static final Evaluator titleEval = (Evaluator)new Evaluator.Tag("title");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void title(String paramString) {
/* 210 */     Validate.notNull(paramString);
/*     */     Element element;
/* 212 */     if ((element = head().selectFirst(titleEval)) == null)
/* 213 */       element = head().appendElement("title"); 
/* 214 */     element.text(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element createElement(String paramString) {
/* 223 */     return new Element(Tag.valueOf(paramString, this.parser.defaultNamespace(), ParseSettings.preserveCase), baseUri());
/*     */   }
/*     */ 
/*     */   
/*     */   public String outerHtml() {
/* 228 */     return html();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element text(String paramString) {
/* 238 */     body().text(paramString);
/* 239 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String nodeName() {
/* 244 */     return "#document";
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
/*     */   public void charset(Charset paramCharset) {
/* 272 */     updateMetaCharsetElement(true);
/* 273 */     this.outputSettings.charset(paramCharset);
/* 274 */     ensureMetaCharsetElement();
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
/*     */   public Charset charset() {
/* 286 */     return this.outputSettings.charset();
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
/*     */ 
/*     */   
/*     */   public void updateMetaCharsetElement(boolean paramBoolean) {
/* 303 */     this.updateMetaCharset = paramBoolean;
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
/*     */   public boolean updateMetaCharsetElement() {
/* 315 */     return this.updateMetaCharset;
/*     */   }
/*     */ 
/*     */   
/*     */   public Document clone() {
/*     */     Document document;
/* 321 */     (document = (Document)super.clone()).outputSettings = this.outputSettings.clone();
/* 322 */     return document;
/*     */   }
/*     */ 
/*     */   
/*     */   public Document shallowClone() {
/* 327 */     Document document = new Document(tag().namespace(), baseUri());
/* 328 */     if (this.attributes != null)
/* 329 */       document.attributes = this.attributes.clone(); 
/* 330 */     document.outputSettings = this.outputSettings.clone();
/* 331 */     return document;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void ensureMetaCharsetElement() {
/* 354 */     if (this.updateMetaCharset) {
/*     */       Element element;
/*     */       OutputSettings.Syntax syntax;
/* 357 */       if ((syntax = outputSettings().syntax()) == OutputSettings.Syntax.html) {
/*     */         
/* 359 */         if ((element = selectFirst("meta[charset]")) != null) {
/* 360 */           element.attr("charset", charset().displayName());
/*     */         } else {
/* 362 */           head().appendElement("meta").attr("charset", charset().displayName());
/*     */         } 
/* 364 */         select("meta[name=charset]").remove(); return;
/* 365 */       }  if (element == OutputSettings.Syntax.xml) {
/*     */         Node node;
/* 367 */         if (node = ensureChildNodes().get(0) instanceof XmlDeclaration) {
/*     */           
/* 369 */           if ((node = node).name().equals("xml"))
/* 370 */           { node.attr("encoding", charset().displayName());
/* 371 */             if (node.hasAttr("version"))
/* 372 */             { node.attr("version", "1.0"); }
/*     */             else { return; }
/*     */              }
/* 375 */           else { (node = new XmlDeclaration("xml", false)).attr("version", "1.0");
/* 376 */             node.attr("encoding", charset().displayName());
/* 377 */             prependChild(node);
/*     */             return; }
/*     */         
/*     */         } else {
/* 381 */           (node = new XmlDeclaration("xml", false)).attr("version", "1.0");
/* 382 */           node.attr("encoding", charset().displayName());
/* 383 */           prependChild(node);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class OutputSettings
/*     */     implements Cloneable
/*     */   {
/*     */     public enum Syntax
/*     */     {
/* 397 */       html, xml;
/*     */     }
/* 399 */     private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
/*     */     private Charset charset;
/*     */     Entities.CoreCharset coreCharset;
/* 402 */     private final ThreadLocal<CharsetEncoder> encoderThreadLocal = new ThreadLocal<>();
/*     */     
/*     */     private boolean prettyPrint = true;
/*     */     private boolean outline = false;
/* 406 */     private int indentAmount = 1;
/* 407 */     private int maxPaddingWidth = 30;
/* 408 */     private Syntax syntax = Syntax.html;
/*     */     
/*     */     public OutputSettings() {
/* 411 */       charset(DataUtil.UTF_8);
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
/*     */     public Entities.EscapeMode escapeMode() {
/* 423 */       return this.escapeMode;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings escapeMode(Entities.EscapeMode param1EscapeMode) {
/* 433 */       this.escapeMode = param1EscapeMode;
/* 434 */       return this;
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
/*     */     public Charset charset() {
/* 446 */       return this.charset;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings charset(Charset param1Charset) {
/* 455 */       this.charset = param1Charset;
/* 456 */       this.coreCharset = Entities.CoreCharset.byName(param1Charset.name());
/* 457 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings charset(String param1String) {
/* 466 */       charset(Charset.forName(param1String));
/* 467 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     CharsetEncoder prepareEncoder() {
/* 472 */       CharsetEncoder charsetEncoder = this.charset.newEncoder();
/* 473 */       this.encoderThreadLocal.set(charsetEncoder);
/* 474 */       return charsetEncoder;
/*     */     }
/*     */     
/*     */     CharsetEncoder encoder() {
/*     */       CharsetEncoder charsetEncoder;
/* 479 */       return ((charsetEncoder = this.encoderThreadLocal.get()) != null) ? charsetEncoder : prepareEncoder();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Syntax syntax() {
/* 487 */       return this.syntax;
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
/*     */     public OutputSettings syntax(Syntax param1Syntax) {
/* 499 */       this.syntax = param1Syntax;
/* 500 */       if (param1Syntax == Syntax.xml)
/* 501 */         escapeMode(Entities.EscapeMode.xhtml); 
/* 502 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean prettyPrint() {
/* 511 */       return this.prettyPrint;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings prettyPrint(boolean param1Boolean) {
/* 520 */       this.prettyPrint = param1Boolean;
/* 521 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean outline() {
/* 530 */       return this.outline;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings outline(boolean param1Boolean) {
/* 539 */       this.outline = param1Boolean;
/* 540 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int indentAmount() {
/* 548 */       return this.indentAmount;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings indentAmount(int param1Int) {
/* 557 */       Validate.isTrue((param1Int >= 0));
/* 558 */       this.indentAmount = param1Int;
/* 559 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int maxPaddingWidth() {
/* 568 */       return this.maxPaddingWidth;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings maxPaddingWidth(int param1Int) {
/* 578 */       Validate.isTrue((param1Int >= -1));
/* 579 */       this.maxPaddingWidth = param1Int;
/* 580 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings clone() {
/*     */       try {
/* 587 */         OutputSettings outputSettings = (OutputSettings)super.clone();
/* 588 */       } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 589 */         throw new RuntimeException(cloneNotSupportedException);
/*     */       } 
/* 591 */       cloneNotSupportedException.charset(this.charset.name());
/* 592 */       ((OutputSettings)cloneNotSupportedException).escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
/*     */       
/* 594 */       return (OutputSettings)cloneNotSupportedException;
/*     */     }
/*     */   }
/*     */   
/*     */   public enum Syntax {
/*     */     html, xml;
/*     */   }
/*     */   
/*     */   public OutputSettings outputSettings() {
/* 603 */     return this.outputSettings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Document outputSettings(OutputSettings paramOutputSettings) {
/* 612 */     Validate.notNull(paramOutputSettings);
/* 613 */     this.outputSettings = paramOutputSettings;
/* 614 */     return this;
/*     */   }
/*     */   
/*     */   public enum QuirksMode {
/* 618 */     noQuirks, quirks, limitedQuirks;
/*     */   }
/*     */   
/*     */   public QuirksMode quirksMode() {
/* 622 */     return this.quirksMode;
/*     */   }
/*     */   
/*     */   public Document quirksMode(QuirksMode paramQuirksMode) {
/* 626 */     this.quirksMode = paramQuirksMode;
/* 627 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parser parser() {
/* 635 */     return this.parser;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Document parser(Parser paramParser) {
/* 645 */     this.parser = paramParser;
/* 646 */     return this;
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
/*     */   public Document connection(Connection paramConnection) {
/* 659 */     Validate.notNull(paramConnection);
/* 660 */     this.connection = paramConnection;
/* 661 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\Document.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */