/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BulletList
/*    */   extends ListBlock
/*    */ {
/*    */   private char openingMarker;
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 15 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public BulletList() {}
/*    */   
/*    */   public BulletList(BasedSequence paramBasedSequence) {
/* 22 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public BulletList(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 26 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public BulletList(BlockContent paramBlockContent) {
/* 30 */     super(paramBlockContent);
/*    */   }
/*    */   
/*    */   public char getOpeningMarker() {
/* 34 */     return this.openingMarker;
/*    */   }
/*    */   
/*    */   public void setOpeningMarker(char paramChar) {
/* 38 */     this.openingMarker = paramChar;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\BulletList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */