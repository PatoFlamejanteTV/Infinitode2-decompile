/*     */ package com.vladsch.flexmark.parser;
/*     */ 
/*     */ import com.vladsch.flexmark.ast.Text;
/*     */ import com.vladsch.flexmark.ast.util.Parsing;
/*     */ import com.vladsch.flexmark.util.ast.Document;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.SegmentedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.regex.MatchResult;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LightInlineParserImpl
/*     */   implements LightInlineParser
/*     */ {
/*     */   protected final InlineParserOptions options;
/*     */   protected final Parsing myParsing;
/*     */   protected Node block;
/*     */   protected BasedSequence input;
/*     */   protected int index;
/*     */   protected ArrayList<BasedSequence> currentText;
/*     */   protected Document document;
/*     */   
/*     */   public LightInlineParserImpl(DataHolder paramDataHolder) {
/*  30 */     this.options = new InlineParserOptions(paramDataHolder);
/*  31 */     this.myParsing = new Parsing(paramDataHolder);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<BasedSequence> getCurrentText() {
/*  37 */     if (this.currentText == null) {
/*  38 */       this.currentText = new ArrayList<>();
/*     */     }
/*     */     
/*  41 */     return this.currentText;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence getInput() {
/*  47 */     return this.input;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInput(BasedSequence paramBasedSequence) {
/*  52 */     this.input = paramBasedSequence;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getIndex() {
/*  57 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIndex(int paramInt) {
/*  62 */     this.index = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Document getDocument() {
/*  68 */     return this.document;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDocument(Document paramDocument) {
/*  73 */     this.document = paramDocument;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public InlineParserOptions getOptions() {
/*  79 */     return this.options;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Parsing getParsing() {
/*  85 */     return this.myParsing;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Node getBlock() {
/*  91 */     return this.block;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBlock(Node paramNode) {
/*  96 */     this.block = paramNode;
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveNodes(Node paramNode1, Node paramNode2) {
/* 101 */     if (paramNode1 != paramNode2) {
/* 102 */       Node node = paramNode1.getNext();
/* 103 */       while (node != null) {
/* 104 */         Node node1 = node.getNext();
/* 105 */         node.unlink();
/* 106 */         paramNode1.appendChild(node);
/* 107 */         if (node != paramNode2) {
/* 108 */           node = node1;
/*     */         }
/*     */       } 
/*     */     } 
/* 112 */     paramNode1.setCharsFromContent();
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendText(BasedSequence paramBasedSequence) {
/* 117 */     getCurrentText().add(paramBasedSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendText(BasedSequence paramBasedSequence, int paramInt1, int paramInt2) {
/* 122 */     getCurrentText().add(paramBasedSequence.subSequence(paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendNode(Node paramNode) {
/* 127 */     flushTextNode();
/* 128 */     this.block.appendChild(paramNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Text appendSeparateText(BasedSequence paramBasedSequence) {
/* 135 */     Text text = new Text(paramBasedSequence);
/* 136 */     appendNode((Node)text);
/* 137 */     return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean flushTextNode() {
/* 142 */     if (this.currentText != null) {
/* 143 */       this.block.appendChild((Node)new Text(SegmentedSequence.create(this.input, this.currentText)));
/* 144 */       this.currentText = null;
/* 145 */       return true;
/*     */     } 
/* 147 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence match(Pattern paramPattern) {
/* 158 */     if (this.index >= this.input.length()) {
/* 159 */       return null;
/*     */     }
/*     */     Matcher matcher;
/* 162 */     (matcher = paramPattern.matcher((CharSequence)this.input)).region(this.index, this.input.length());
/*     */     boolean bool;
/* 164 */     if (bool = matcher.find()) {
/* 165 */       this.index = matcher.end();
/* 166 */       MatchResult matchResult = matcher.toMatchResult();
/* 167 */       return this.input.subSequence(matchResult.start(), matchResult.end());
/*     */     } 
/* 169 */     return null;
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
/*     */   public BasedSequence[] matchWithGroups(Pattern paramPattern) {
/* 181 */     if (this.index >= this.input.length()) {
/* 182 */       return null;
/*     */     }
/*     */     Matcher matcher;
/* 185 */     (matcher = paramPattern.matcher((CharSequence)this.input)).region(this.index, this.input.length());
/*     */     boolean bool;
/* 187 */     if (bool = matcher.find()) {
/* 188 */       this.index = matcher.end();
/* 189 */       MatchResult matchResult = matcher.toMatchResult();
/*     */       int i;
/*     */       BasedSequence[] arrayOfBasedSequence;
/* 192 */       (arrayOfBasedSequence = new BasedSequence[i = matcher.groupCount() + 1])[0] = this.input.subSequence(matchResult.start(), matchResult.end());
/* 193 */       for (byte b = 1; b < i; b++) {
/* 194 */         if (matcher.group(b) != null) {
/* 195 */           arrayOfBasedSequence[b] = this.input.subSequence(matchResult.start(b), matchResult.end(b));
/*     */         } else {
/* 197 */           arrayOfBasedSequence[b] = null;
/*     */         } 
/*     */       } 
/* 200 */       return arrayOfBasedSequence;
/*     */     } 
/* 202 */     return null;
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
/*     */   public Matcher matcher(Pattern paramPattern) {
/* 214 */     if (this.index >= this.input.length()) {
/* 215 */       return null;
/*     */     }
/*     */     Matcher matcher;
/* 218 */     (matcher = paramPattern.matcher((CharSequence)this.input)).region(this.index, this.input.length());
/*     */     boolean bool;
/* 220 */     if (bool = matcher.find()) {
/* 221 */       this.index = matcher.end();
/* 222 */       return matcher;
/*     */     } 
/* 224 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char peek() {
/* 233 */     if (this.index < this.input.length()) {
/* 234 */       return this.input.charAt(this.index);
/*     */     }
/* 236 */     return Character.MIN_VALUE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public char peek(int paramInt) {
/* 242 */     if (this.index + paramInt < this.input.length()) {
/* 243 */       return this.input.charAt(this.index + paramInt);
/*     */     }
/* 245 */     return Character.MIN_VALUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean spnl() {
/* 256 */     match(this.myParsing.SPNL);
/* 257 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean nonIndentSp() {
/* 267 */     match(this.myParsing.SPNI);
/* 268 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sp() {
/* 278 */     match(this.myParsing.SP);
/* 279 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean spnlUrl() {
/* 289 */     return (match(this.myParsing.SPNL_URL) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasedSequence toEOL() {
/* 300 */     return match(this.myParsing.REST_OF_LINE);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\LightInlineParserImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */