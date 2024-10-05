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
/*    */ 
/*    */ public class RotateByAction
/*    */   extends RelativeTemporalAction
/*    */ {
/*    */   private float c;
/*    */   
/*    */   protected final void b(float paramFloat) {
/* 25 */     this.b.rotateBy(this.c * paramFloat);
/*    */   }
/*    */   
/*    */   public float getAmount() {
/* 29 */     return this.c;
/*    */   }
/*    */   
/*    */   public void setAmount(float paramFloat) {
/* 33 */     this.c = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\RotateByAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */