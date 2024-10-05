/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class Link
/*    */   extends InlineLinkNode {
/*    */   public Link() {}
/*    */   
/*    */   public Link(BasedSequence paramBasedSequence) {
/* 10 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public Link(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7, BasedSequence paramBasedSequence8, BasedSequence paramBasedSequence9) {
/* 14 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5, paramBasedSequence6, paramBasedSequence7, paramBasedSequence8, paramBasedSequence9);
/*    */   }
/*    */   
/*    */   public Link(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7, BasedSequence paramBasedSequence8, BasedSequence paramBasedSequence9, BasedSequence paramBasedSequence10) {
/* 18 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5, paramBasedSequence6, paramBasedSequence7, paramBasedSequence8, paramBasedSequence9, paramBasedSequence10);
/*    */   }
/*    */   
/*    */   public Link(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6) {
/* 22 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5, paramBasedSequence6);
/*    */   }
/*    */   
/*    */   public Link(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7) {
/* 26 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5, paramBasedSequence6, paramBasedSequence7);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTextChars(BasedSequence paramBasedSequence) {
/* 31 */     int i = paramBasedSequence.length();
/* 32 */     this.textOpeningMarker = paramBasedSequence.subSequence(0, 1);
/* 33 */     this.text = (BasedSequence)paramBasedSequence.subSequence(1, i - 1).trim();
/* 34 */     this.textClosingMarker = paramBasedSequence.subSequence(i - 1, i);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\Link.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */