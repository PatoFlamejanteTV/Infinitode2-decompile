/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class ImageRef
/*    */   extends RefNode {
/*    */   public ImageRef() {}
/*    */   
/*    */   public ImageRef(BasedSequence paramBasedSequence) {
/* 10 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public ImageRef(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6) {
/* 14 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5, paramBasedSequence6);
/*    */   }
/*    */   
/*    */   public ImageRef(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5, BasedSequence paramBasedSequence6, BasedSequence paramBasedSequence7) {
/* 18 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5, paramBasedSequence6, paramBasedSequence7);
/*    */   }
/*    */   
/*    */   public ImageRef(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3) {
/* 22 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3);
/*    */   }
/*    */   
/*    */   public ImageRef(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4) {
/* 26 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4);
/*    */   }
/*    */   
/*    */   public ImageRef(BasedSequence paramBasedSequence1, BasedSequence paramBasedSequence2, BasedSequence paramBasedSequence3, BasedSequence paramBasedSequence4, BasedSequence paramBasedSequence5) {
/* 30 */     super(paramBasedSequence1, paramBasedSequence2, paramBasedSequence3, paramBasedSequence4, paramBasedSequence5);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTextChars(BasedSequence paramBasedSequence) {
/* 35 */     int i = paramBasedSequence.length();
/* 36 */     this.textOpeningMarker = paramBasedSequence.subSequence(0, 2);
/* 37 */     this.text = (BasedSequence)paramBasedSequence.subSequence(2, i - 1).trim();
/* 38 */     this.textClosingMarker = paramBasedSequence.subSequence(i - 1, i);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\ImageRef.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */