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
/*    */ public class MoveByAction
/*    */   extends RelativeTemporalAction
/*    */ {
/*    */   private float amountX;
/*    */   private float amountY;
/*    */   
/*    */   protected void updateRelative(float paramFloat) {
/* 25 */     this.target.moveBy(this.amountX * paramFloat, this.amountY * paramFloat);
/*    */   }
/*    */   
/*    */   public void setAmount(float paramFloat1, float paramFloat2) {
/* 29 */     this.amountX = paramFloat1;
/* 30 */     this.amountY = paramFloat2;
/*    */   }
/*    */   
/*    */   public float getAmountX() {
/* 34 */     return this.amountX;
/*    */   }
/*    */   
/*    */   public void setAmountX(float paramFloat) {
/* 38 */     this.amountX = paramFloat;
/*    */   }
/*    */   
/*    */   public float getAmountY() {
/* 42 */     return this.amountY;
/*    */   }
/*    */   
/*    */   public void setAmountY(float paramFloat) {
/* 46 */     this.amountY = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\MoveByAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */