/*    */ package com.vladsch.flexmark.parser.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.parser.block.BlockParser;
/*    */ import com.vladsch.flexmark.parser.block.MatchedBlockParser;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ public class MatchedBlockParserImpl
/*    */   implements MatchedBlockParser
/*    */ {
/*    */   private final BlockParser matchedBlockParser;
/*    */   
/*    */   public List<BasedSequence> getParagraphLines() {
/* 15 */     if (this.matchedBlockParser.isParagraphParser()) {
/* 16 */       return this.matchedBlockParser.getBlockContent().getLines();
/*    */     }
/* 18 */     return null;
/*    */   }
/*    */   
/*    */   public List<Integer> getParagraphEolLengths() {
/* 22 */     if (this.matchedBlockParser.isParagraphParser()) {
/* 23 */       return this.matchedBlockParser.getBlockContent().getLineIndents();
/*    */     }
/* 25 */     return null;
/*    */   }
/*    */   
/*    */   public MatchedBlockParserImpl(BlockParser paramBlockParser) {
/* 29 */     this.matchedBlockParser = paramBlockParser;
/*    */   }
/*    */ 
/*    */   
/*    */   public BlockParser getBlockParser() {
/* 34 */     return this.matchedBlockParser;
/*    */   }
/*    */ 
/*    */   
/*    */   public BasedSequence getParagraphContent() {
/* 39 */     if (this.matchedBlockParser.isParagraphParser()) {
/* 40 */       return this.matchedBlockParser.getBlockContent().getContents();
/*    */     }
/* 42 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public MutableDataHolder getParagraphDataHolder() {
/* 47 */     if (this.matchedBlockParser.isParagraphParser()) {
/* 48 */       return this.matchedBlockParser.getDataHolder();
/*    */     }
/* 50 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\internal\MatchedBlockParserImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */