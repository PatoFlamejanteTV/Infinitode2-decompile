/*     */ package com.vladsch.flexmark.parser.block;
/*     */ 
/*     */ import com.vladsch.flexmark.parser.InlineParser;
/*     */ import com.vladsch.flexmark.util.ast.Block;
/*     */ import com.vladsch.flexmark.util.ast.BlockContent;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*     */ import com.vladsch.flexmark.util.data.MutableDataSet;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ 
/*     */ public abstract class AbstractBlockParser
/*     */   implements BlockParser {
/*  13 */   private MutableDataSet mutableData = null;
/*     */   
/*     */   private boolean isClosed = false;
/*     */   
/*     */   public boolean isClosed() {
/*  18 */     return this.isClosed;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isContainer() {
/*  23 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInterruptible() {
/*  28 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRawText() {
/*  33 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canContain(ParserState paramParserState, BlockParser paramBlockParser, Block paramBlock) {
/*  38 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isParagraphParser() {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPropagatingLastBlankLine(BlockParser paramBlockParser) {
/*  54 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlockContent getBlockContent() {
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLine(ParserState paramParserState, BasedSequence paramBasedSequence) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void parseInlines(InlineParser paramInlineParser) {}
/*     */ 
/*     */   
/*     */   public boolean breakOutOnDoubleBlankLine() {
/*  72 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void finalizeClosedBlock() {
/*  77 */     this.mutableData = null;
/*  78 */     this.isClosed = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canInterruptBy(BlockParserFactory paramBlockParserFactory) {
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableDataHolder getDataHolder() {
/*  88 */     if (this.mutableData == null) {
/*  89 */       this.mutableData = new MutableDataSet();
/*     */     }
/*  91 */     return (MutableDataHolder)this.mutableData;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeBlankLines() {
/*  96 */     Node node = getBlock().getFirstChild();
/*     */     
/*  98 */     while (node != null) {
/*  99 */       Node node1 = node.getNext();
/* 100 */       if (node instanceof com.vladsch.flexmark.util.ast.BlankLine) {
/* 101 */         node.unlink();
/*     */       }
/* 103 */       node = node1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\AbstractBlockParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */