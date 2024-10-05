/*    */ package com.vladsch.flexmark.ext.aside;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.ast.BlockQuoteLike;
/*    */ import com.vladsch.flexmark.util.ast.KeepTrailingBlankLineContainer;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AsideBlock
/*    */   extends Block
/*    */   implements BlockQuoteLike, KeepTrailingBlankLineContainer
/*    */ {
/* 16 */   private BasedSequence openingMarker = BasedSequence.NULL;
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 20 */     segmentSpanChars(paramStringBuilder, this.openingMarker, "marker");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 26 */     return new BasedSequence[] { this.openingMarker };
/*    */   }
/*    */ 
/*    */   
/*    */   public AsideBlock() {}
/*    */   
/*    */   public AsideBlock(BasedSequence paramBasedSequence) {
/* 33 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public AsideBlock(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 37 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public AsideBlock(BlockContent paramBlockContent) {
/* 41 */     super(paramBlockContent);
/*    */   }
/*    */   
/*    */   public BasedSequence getOpeningMarker() {
/* 45 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 49 */     this.openingMarker = paramBasedSequence;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\aside\AsideBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */