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
/*    */ public class ScaleToAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private float startX;
/*    */   private float startY;
/*    */   private float endX;
/*    */   private float endY;
/*    */   
/*    */   protected void begin() {
/* 26 */     this.startX = this.target.getScaleX();
/* 27 */     this.startY = this.target.getScaleY();
/*    */   }
/*    */   
/*    */   protected void update(float paramFloat) {
/*    */     float f;
/* 32 */     if (paramFloat == 0.0F) {
/* 33 */       f = this.startX;
/* 34 */       paramFloat = this.startY;
/* 35 */     } else if (paramFloat == 1.0F) {
/* 36 */       f = this.endX;
/* 37 */       paramFloat = this.endY;
/*    */     } else {
/* 39 */       f = this.startX + (this.endX - this.startX) * paramFloat;
/* 40 */       paramFloat = this.startY + (this.endY - this.startY) * paramFloat;
/*    */     } 
/* 42 */     this.target.setScale(f, paramFloat);
/*    */   }
/*    */   
/*    */   public void setScale(float paramFloat1, float paramFloat2) {
/* 46 */     this.endX = paramFloat1;
/* 47 */     this.endY = paramFloat2;
/*    */   }
/*    */   
/*    */   public void setScale(float paramFloat) {
/* 51 */     this.endX = paramFloat;
/* 52 */     this.endY = paramFloat;
/*    */   }
/*    */   
/*    */   public float getX() {
/* 56 */     return this.endX;
/*    */   }
/*    */   
/*    */   public void setX(float paramFloat) {
/* 60 */     this.endX = paramFloat;
/*    */   }
/*    */   
/*    */   public float getY() {
/* 64 */     return this.endY;
/*    */   }
/*    */   
/*    */   public void setY(float paramFloat) {
/* 68 */     this.endY = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\ScaleToAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */