/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HtmlInnerBlockComment
/*    */   extends HtmlBlockBase
/*    */ {
/*    */   public BasedSequence[] getSegments() {
/* 15 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 20 */     astExtraChars(paramStringBuilder);
/*    */   }
/*    */ 
/*    */   
/*    */   public HtmlInnerBlockComment() {}
/*    */   
/*    */   public HtmlInnerBlockComment(BasedSequence paramBasedSequence) {
/* 27 */     super(paramBasedSequence);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\HtmlInnerBlockComment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */