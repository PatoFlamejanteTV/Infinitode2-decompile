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
/*    */ public class ScaleByAction
/*    */   extends RelativeTemporalAction
/*    */ {
/*    */   private float c;
/*    */   private float d;
/*    */   
/*    */   protected final void b(float paramFloat) {
/* 25 */     this.b.scaleBy(this.c * paramFloat, this.d * paramFloat);
/*    */   }
/*    */   
/*    */   public void setAmount(float paramFloat1, float paramFloat2) {
/* 29 */     this.c = paramFloat1;
/* 30 */     this.d = paramFloat2;
/*    */   }
/*    */   
/*    */   public void setAmount(float paramFloat) {
/* 34 */     this.c = paramFloat;
/* 35 */     this.d = paramFloat;
/*    */   }
/*    */   
/*    */   public float getAmountX() {
/* 39 */     return this.c;
/*    */   }
/*    */   
/*    */   public void setAmountX(float paramFloat) {
/* 43 */     this.c = paramFloat;
/*    */   }
/*    */   
/*    */   public float getAmountY() {
/* 47 */     return this.d;
/*    */   }
/*    */   
/*    */   public void setAmountY(float paramFloat) {
/* 51 */     this.d = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\ScaleByAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */