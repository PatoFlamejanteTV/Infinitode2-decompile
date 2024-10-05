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
/*    */ public class SizeByAction
/*    */   extends RelativeTemporalAction
/*    */ {
/*    */   private float amountWidth;
/*    */   private float amountHeight;
/*    */   
/*    */   protected void updateRelative(float paramFloat) {
/* 25 */     this.target.sizeBy(this.amountWidth * paramFloat, this.amountHeight * paramFloat);
/*    */   }
/*    */   
/*    */   public void setAmount(float paramFloat1, float paramFloat2) {
/* 29 */     this.amountWidth = paramFloat1;
/* 30 */     this.amountHeight = paramFloat2;
/*    */   }
/*    */   
/*    */   public float getAmountWidth() {
/* 34 */     return this.amountWidth;
/*    */   }
/*    */   
/*    */   public void setAmountWidth(float paramFloat) {
/* 38 */     this.amountWidth = paramFloat;
/*    */   }
/*    */   
/*    */   public float getAmountHeight() {
/* 42 */     return this.amountHeight;
/*    */   }
/*    */   
/*    */   public void setAmountHeight(float paramFloat) {
/* 46 */     this.amountHeight = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\SizeByAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */