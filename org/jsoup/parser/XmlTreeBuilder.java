/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.util.List;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.CDataNode;
/*     */ import org.jsoup.nodes.Comment;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.DocumentType;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Entities;
/*     */ import org.jsoup.nodes.LeafNode;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.TextNode;
/*     */ import org.jsoup.nodes.XmlDeclaration;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlTreeBuilder
/*     */   extends TreeBuilder
/*     */ {
/*     */   private static final int maxQueueDepth = 256;
/*     */   
/*     */   ParseSettings defaultSettings() {
/*  30 */     return ParseSettings.preserveCase;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void initialiseParse(Reader paramReader, String paramString, Parser paramParser) {
/*  35 */     super.initialiseParse(paramReader, paramString, paramParser);
/*  36 */     this.stack.add(this.doc);
/*  37 */     this.doc.outputSettings()
/*  38 */       .syntax(Document.OutputSettings.Syntax.xml)
/*  39 */       .escapeMode(Entities.EscapeMode.xhtml)
/*  40 */       .prettyPrint(false);
/*     */   }
/*     */   
/*     */   Document parse(Reader paramReader, String paramString) {
/*  44 */     return parse(paramReader, paramString, new Parser(this));
/*     */   }
/*     */   
/*     */   Document parse(String paramString1, String paramString2) {
/*  48 */     return parse(new StringReader(paramString1), paramString2, new Parser(this));
/*     */   }
/*     */ 
/*     */   
/*     */   XmlTreeBuilder newInstance() {
/*  53 */     return new XmlTreeBuilder();
/*     */   }
/*     */   
/*     */   public String defaultNamespace() {
/*  57 */     return "http://www.w3.org/XML/1998/namespace";
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean process(Token paramToken) {
/*  62 */     this.currentToken = paramToken;
/*     */ 
/*     */     
/*  65 */     switch (paramToken.type) {
/*     */       case StartTag:
/*  67 */         insertElementFor(paramToken.asStartTag());
/*     */       
/*     */       case EndTag:
/*  70 */         popStackToClose(paramToken.asEndTag());
/*     */       
/*     */       case Comment:
/*  73 */         insertCommentFor(paramToken.asComment());
/*     */       
/*     */       case Character:
/*  76 */         insertCharacterFor(paramToken.asCharacter());
/*     */       
/*     */       case Doctype:
/*  79 */         insertDoctypeFor(paramToken.asDoctype());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case EOF:
/*  86 */         return true;
/*     */     } 
/*     */     Validate.fail("Unexpected token type: " + paramToken.type);
/*     */   } void insertElementFor(Token.StartTag paramStartTag) {
/*  90 */     Tag tag = tagFor(paramStartTag.name(), this.settings);
/*  91 */     if (paramStartTag.attributes != null) {
/*  92 */       paramStartTag.attributes.deduplicate(this.settings);
/*     */     }
/*  94 */     Element element = new Element(tag, null, this.settings.normalizeAttributes(paramStartTag.attributes));
/*  95 */     currentElement().appendChild((Node)element);
/*  96 */     push(element);
/*     */     
/*  98 */     if (paramStartTag.isSelfClosing()) {
/*  99 */       tag.setSelfClosing();
/* 100 */       pop();
/*     */     } 
/*     */   }
/*     */   
/*     */   void insertLeafNode(LeafNode paramLeafNode) {
/* 105 */     currentElement().appendChild((Node)paramLeafNode);
/* 106 */     onNodeInserted((Node)paramLeafNode);
/*     */   }
/*     */   
/*     */   void insertCommentFor(Token.Comment paramComment) {
/*     */     XmlDeclaration xmlDeclaration;
/* 111 */     Comment comment1 = new Comment(paramComment.getData()), comment2 = comment1;
/* 112 */     if (paramComment.bogus && comment1.isXmlDeclaration()) {
/*     */       XmlDeclaration xmlDeclaration1;
/*     */ 
/*     */ 
/*     */       
/* 117 */       if ((xmlDeclaration1 = comment1.asXmlDeclaration()) != null)
/* 118 */         xmlDeclaration = xmlDeclaration1; 
/*     */     } 
/* 120 */     insertLeafNode((LeafNode)xmlDeclaration);
/*     */   }
/*     */   
/*     */   void insertCharacterFor(Token.Character paramCharacter) {
/* 124 */     String str = paramCharacter.getData();
/* 125 */     insertLeafNode(paramCharacter.isCData() ? (LeafNode)new CDataNode(str) : (LeafNode)new TextNode(str));
/*     */   }
/*     */   
/*     */   void insertDoctypeFor(Token.Doctype paramDoctype) {
/*     */     DocumentType documentType;
/* 130 */     (documentType = new DocumentType(this.settings.normalizeTag(paramDoctype.getName()), paramDoctype.getPublicIdentifier(), paramDoctype.getSystemIdentifier())).setPubSysKey(paramDoctype.getPubSysKey());
/* 131 */     insertLeafNode((LeafNode)documentType);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void insertNode(Node paramNode) {
/* 137 */     currentElement().appendChild(paramNode);
/* 138 */     onNodeInserted(paramNode);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void insertNode(Node paramNode, Token paramToken) {
/* 144 */     currentElement().appendChild(paramNode);
/* 145 */     onNodeInserted(paramNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void popStackToClose(Token.EndTag paramEndTag) {
/* 156 */     String str = this.settings.normalizeTag(paramEndTag.tagName);
/* 157 */     Element element1 = null;
/*     */ 
/*     */     
/* 160 */     int i = ((i = this.stack.size() - 1) >= 256) ? (i - 256) : 0;
/*     */     int j;
/* 162 */     for (j = this.stack.size() - 1; j >= i; j--) {
/*     */       Element element;
/* 164 */       if ((element = this.stack.get(j)).nodeName().equals(str)) {
/* 165 */         element1 = element;
/*     */         break;
/*     */       } 
/*     */     } 
/* 169 */     if (element1 == null)
/*     */       return; 
/*     */     Element element2;
/* 172 */     for (j = this.stack.size() - 1; j >= 0 && (
/*     */       
/* 174 */       element2 = pop()) != element1; j--);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List<Node> parseFragment(String paramString1, String paramString2, Parser paramParser) {
/* 182 */     initialiseParse(new StringReader(paramString1), paramString2, paramParser);
/* 183 */     runParser();
/* 184 */     return this.doc.childNodes();
/*     */   }
/*     */   
/*     */   List<Node> parseFragment(String paramString1, Element paramElement, String paramString2, Parser paramParser) {
/* 188 */     return parseFragment(paramString1, paramString2, paramParser);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\XmlTreeBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */