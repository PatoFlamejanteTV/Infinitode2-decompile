/*    */ package com.prineside.tdi2.scene2d.actions;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SizeByAction
/*    */   extends RelativeTemporalAction
/*    */ {
/*    */   private float c;
/*    */   private float d;
/*    */   
/*    */   protected final void b(float paramFloat) {
/* 25 */     this.b.sizeBy(this.c * paramFloat, this.d * paramFloat);
/*    */   }
/*    */   
/*    */   public void setAmount(float paramFloat1, float paramFloat2) {
/* 29 */     this.c = paramFloat1;
/* 30 */     this.d = paramFloat2;
/*    */   }
/*    */   
/*    */   public float getAmountWidth() {
/* 34 */     return this.c;
/*    */   }
/*    */   
/*    */   public void setAmountWidth(float paramFloat) {
/* 38 */     this.c = paramFloat;
/*    */   }
/*    */   
/*    */   public float getAmountHeight() {
/* 42 */     return this.d;
/*    */   }
/*    */   
/*    */   public void setAmountHeight(float paramFloat) {
/* 46 */     this.d = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\SizeByAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */