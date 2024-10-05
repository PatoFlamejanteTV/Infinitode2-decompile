/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.ast.BlockQuoteLike;
/*    */ import com.vladsch.flexmark.util.ast.KeepTrailingBlankLineContainer;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ public class BlockQuote
/*    */   extends Block
/*    */   implements BlockQuoteLike, KeepTrailingBlankLineContainer {
/* 13 */   private BasedSequence openingMarker = BasedSequence.NULL;
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 17 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "marker");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 23 */     return new BasedSequence[] { this.openingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public BlockQuote() {}
/*    */   
/*    */   public BlockQuote(BasedSequence paramBasedSequence) {
/* 30 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public BlockQuote(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 34 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public BlockQuote(BlockContent paramBlockContent) {
/* 38 */     super(paramBlockContent);
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 42 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 46 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\BlockQuote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */