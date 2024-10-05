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
/*    */ public class SizeToAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private float startWidth;
/*    */   private float startHeight;
/*    */   private float endWidth;
/*    */   private float endHeight;
/*    */   
/*    */   protected void begin() {
/* 26 */     this.startWidth = this.target.getWidth();
/* 27 */     this.startHeight = this.target.getHeight();
/*    */   }
/*    */   
/*    */   protected void update(float paramFloat) {
/*    */     float f;
/* 32 */     if (paramFloat == 0.0F) {
/* 33 */       f = this.startWidth;
/* 34 */       paramFloat = this.startHeight;
/* 35 */     } else if (paramFloat == 1.0F) {
/* 36 */       f = this.endWidth;
/* 37 */       paramFloat = this.endHeight;
/*    */     } else {
/* 39 */       f = this.startWidth + (this.endWidth - this.startWidth) * paramFloat;
/* 40 */       paramFloat = this.startHeight + (this.endHeight - this.startHeight) * paramFloat;
/*    */     } 
/* 42 */     this.target.setSize(f, paramFloat);
/*    */   }
/*    */   
/*    */   public void setSize(float paramFloat1, float paramFloat2) {
/* 46 */     this.endWidth = paramFloat1;
/* 47 */     this.endHeight = paramFloat2;
/*    */   }
/*    */   
/*    */   public float getWidth() {
/* 51 */     return this.endWidth;
/*    */   }
/*    */   
/*    */   public void setWidth(float paramFloat) {
/* 55 */     this.endWidth = paramFloat;
/*    */   }
/*    */   
/*    */   public float getHeight() {
/* 59 */     return this.endHeight;
/*    */   }
/*    */   
/*    */   public void setHeight(float paramFloat) {
/* 63 */     this.endHeight = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\SizeToAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */