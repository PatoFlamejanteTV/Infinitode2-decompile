/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Attributes;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.Range;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class TreeBuilder
/*     */ {
/*     */   protected Parser parser;
/*     */   CharacterReader reader;
/*     */   Tokeniser tokeniser;
/*     */   Document doc;
/*     */   ArrayList<Element> stack;
/*     */   String baseUri;
/*     */   Token currentToken;
/*     */   ParseSettings settings;
/*     */   Map<String, Tag> seenTags;
/*     */   private Token.StartTag start;
/*  34 */   private final Token.EndTag end = new Token.EndTag(this);
/*     */   boolean trackSourceRange;
/*     */   
/*     */   abstract ParseSettings defaultSettings();
/*     */   
/*     */   void initialiseParse(Reader paramReader, String paramString, Parser paramParser) {
/*  40 */     Validate.notNullParam(paramReader, "input");
/*  41 */     Validate.notNullParam(paramString, "baseUri");
/*  42 */     Validate.notNull(paramParser);
/*     */     
/*  44 */     this.doc = new Document(paramParser.defaultNamespace(), paramString);
/*  45 */     this.doc.parser(paramParser);
/*  46 */     this.parser = paramParser;
/*  47 */     this.settings = paramParser.settings();
/*  48 */     this.reader = new CharacterReader(paramReader);
/*  49 */     this.trackSourceRange = paramParser.isTrackPosition();
/*  50 */     this.reader.trackNewlines((paramParser.isTrackErrors() || this.trackSourceRange));
/*  51 */     this.tokeniser = new Tokeniser(this);
/*  52 */     this.stack = new ArrayList<>(32);
/*  53 */     this.seenTags = new HashMap<>();
/*  54 */     this.start = new Token.StartTag(this);
/*  55 */     this.currentToken = this.start;
/*  56 */     this.baseUri = paramString;
/*     */   }
/*     */   
/*     */   Document parse(Reader paramReader, String paramString, Parser paramParser) {
/*  60 */     initialiseParse(paramReader, paramString, paramParser);
/*  61 */     runParser();
/*     */ 
/*     */     
/*  64 */     this.reader.close();
/*  65 */     this.reader = null;
/*  66 */     this.tokeniser = null;
/*  67 */     this.stack = null;
/*  68 */     this.seenTags = null;
/*     */     
/*  70 */     return this.doc;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   abstract TreeBuilder newInstance();
/*     */ 
/*     */   
/*     */   abstract List<Node> parseFragment(String paramString1, Element paramElement, String paramString2, Parser paramParser);
/*     */ 
/*     */   
/*     */   void runParser() {
/*  82 */     Tokeniser tokeniser = this.tokeniser;
/*  83 */     Token.TokenType tokenType = Token.TokenType.EOF;
/*     */     
/*     */     while (true) {
/*  86 */       Token token = tokeniser.read();
/*  87 */       this.currentToken = token;
/*  88 */       process(token);
/*  89 */       if (token.type != tokenType) {
/*     */         
/*  91 */         token.reset(); continue;
/*     */       } 
/*     */       break;
/*     */     } 
/*  95 */     for (; !this.stack.isEmpty(); pop());
/*     */   }
/*     */ 
/*     */   
/*     */   abstract boolean process(Token paramToken);
/*     */   
/*     */   boolean processStartTag(String paramString) {
/* 102 */     Token.StartTag startTag = this.start;
/* 103 */     if (this.currentToken == startTag) {
/* 104 */       return process((new Token.StartTag(this)).name(paramString));
/*     */     }
/* 106 */     return process(startTag.reset().name(paramString));
/*     */   }
/*     */   
/*     */   boolean processStartTag(String paramString, Attributes paramAttributes) {
/* 110 */     Token.StartTag startTag = this.start;
/* 111 */     if (this.currentToken == startTag) {
/* 112 */       return process((new Token.StartTag(this)).nameAttr(paramString, paramAttributes));
/*     */     }
/* 114 */     startTag.reset();
/* 115 */     startTag.nameAttr(paramString, paramAttributes);
/* 116 */     return process(startTag);
/*     */   }
/*     */   
/*     */   boolean processEndTag(String paramString) {
/* 120 */     if (this.currentToken == this.end) {
/* 121 */       return process((new Token.EndTag(this)).name(paramString));
/*     */     }
/* 123 */     return process(this.end.reset().name(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final Element pop() {
/* 131 */     int i = this.stack.size();
/* 132 */     Element element = this.stack.remove(i - 1);
/* 133 */     onNodeClosed((Node)element);
/* 134 */     return element;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void push(Element paramElement) {
/* 142 */     this.stack.add(paramElement);
/* 143 */     onNodeInserted((Node)paramElement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Element currentElement() {
/*     */     int i;
/* 153 */     return (Element)(((i = this.stack.size()) > 0) ? this.stack.get(i - 1) : this.doc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean currentElementIs(String paramString) {
/* 162 */     if (this.stack.size() == 0)
/* 163 */       return false; 
/*     */     Element element;
/* 165 */     if ((element = currentElement()) != null && element.normalName().equals(paramString) && element
/* 166 */       .tag().namespace().equals("http://www.w3.org/1999/xhtml")) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean currentElementIs(String paramString1, String paramString2) {
/* 176 */     if (this.stack.size() == 0)
/* 177 */       return false; 
/*     */     Element element;
/* 179 */     if ((element = currentElement()) != null && element.normalName().equals(paramString1) && element
/* 180 */       .tag().namespace().equals(paramString2)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void error(String paramString) {
/* 188 */     error(paramString, (Object[])null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void error(String paramString, Object... paramVarArgs) {
/*     */     ParseErrorList parseErrorList;
/* 198 */     if ((parseErrorList = this.parser.getErrors()).canAddError()) {
/* 199 */       parseErrorList.add(new ParseError(this.reader, paramString, paramVarArgs));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isContentForTagData(String paramString) {
/* 207 */     return false;
/*     */   }
/*     */   
/*     */   Tag tagFor(String paramString1, String paramString2, ParseSettings paramParseSettings) {
/*     */     Tag tag;
/* 212 */     if ((tag = this.seenTags.get(paramString1)) == null || !tag.namespace().equals(paramString2)) {
/*     */       
/* 214 */       Tag tag1 = Tag.valueOf(paramString1, paramString2, paramParseSettings);
/* 215 */       this.seenTags.put(paramString1, tag1);
/* 216 */       return tag1;
/*     */     } 
/* 218 */     return tag;
/*     */   }
/*     */   
/*     */   Tag tagFor(String paramString, ParseSettings paramParseSettings) {
/* 222 */     return tagFor(paramString, defaultNamespace(), paramParseSettings);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String defaultNamespace() {
/* 230 */     return "http://www.w3.org/1999/xhtml";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void onNodeInserted(Node paramNode) {
/* 238 */     trackNodePosition(paramNode, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void onNodeClosed(Node paramNode) {
/* 246 */     trackNodePosition(paramNode, false);
/*     */   }
/*     */   
/*     */   private void trackNodePosition(Node paramNode, boolean paramBoolean) {
/* 250 */     if (!this.trackSourceRange)
/*     */       return; 
/*     */     Token token;
/* 253 */     int i = (token = this.currentToken).startPos();
/* 254 */     int j = token.endPos();
/*     */ 
/*     */     
/* 257 */     if (paramNode instanceof Element) {
/* 258 */       Element element = (Element)paramNode;
/* 259 */       if (token.isEOF()) {
/* 260 */         if (element.endSourceRange().isTracked())
/*     */           return; 
/* 262 */         i = j = this.reader.pos();
/* 263 */       } else if (paramBoolean) {
/* 264 */         if (!token.isStartTag() || !element.normalName().equals((token.asStartTag()).normalName)) {
/* 265 */           j = i;
/*     */         }
/*     */       }
/* 268 */       else if (!element.tag().isEmpty() && !element.tag().isSelfClosing() && (
/* 269 */         !token.isEndTag() || !element.normalName().equals((token.asEndTag()).normalName))) {
/* 270 */         j = i;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 277 */     Range.Position position2 = new Range.Position(i, this.reader.lineNumber(i), this.reader.columnNumber(i));
/*     */     
/* 279 */     Range.Position position1 = new Range.Position(j, this.reader.lineNumber(j), this.reader.columnNumber(j));
/* 280 */     Range range = new Range(position2, position1);
/* 281 */     paramNode.attributes().userData(paramBoolean ? "jsoup.start" : "jsoup.end", range);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\parser\TreeBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */