/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.utils.Null;
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
/*    */ public class ColorAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private float startR;
/*    */   private float startG;
/*    */   private float startB;
/*    */   private float startA;
/*    */   @Null
/*    */   private Color color;
/* 29 */   private final Color end = new Color();
/*    */   
/*    */   protected void begin() {
/* 32 */     if (this.color == null) this.color = this.target.getColor(); 
/* 33 */     this.startR = this.color.r;
/* 34 */     this.startG = this.color.g;
/* 35 */     this.startB = this.color.b;
/* 36 */     this.startA = this.color.a;
/*    */   }
/*    */   
/*    */   protected void update(float paramFloat) {
/* 40 */     if (paramFloat == 0.0F) {
/* 41 */       this.color.set(this.startR, this.startG, this.startB, this.startA); return;
/* 42 */     }  if (paramFloat == 1.0F) {
/* 43 */       this.color.set(this.end); return;
/*    */     } 
/* 45 */     float f1 = this.startR + (this.end.r - this.startR) * paramFloat;
/* 46 */     float f2 = this.startG + (this.end.g - this.startG) * paramFloat;
/* 47 */     float f3 = this.startB + (this.end.b - this.startB) * paramFloat;
/* 48 */     paramFloat = this.startA + (this.end.a - this.startA) * paramFloat;
/* 49 */     this.color.set(f1, f2, f3, paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public void reset() {
/* 54 */     super.reset();
/* 55 */     this.color = null;
/*    */   }
/*    */   @Null
/*    */   public Color getColor() {
/* 59 */     return this.color;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setColor(@Null Color paramColor) {
/* 65 */     this.color = paramColor;
/*    */   }
/*    */   
/*    */   public Color getEndColor() {
/* 69 */     return this.end;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEndColor(Color paramColor) {
/* 74 */     this.end.set(paramColor);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\ColorAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */