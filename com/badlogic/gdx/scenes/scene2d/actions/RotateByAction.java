/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
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
/*    */   private float amount;
/*    */   
/*    */   protected void updateRelative(float paramFloat) {
/* 25 */     this.target.rotateBy(this.amount * paramFloat);
/*    */   }
/*    */   
/*    */   public float getAmount() {
/* 29 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(float paramFloat) {
/* 33 */     this.amount = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\RotateByAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */