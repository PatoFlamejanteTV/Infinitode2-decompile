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
/*    */ 
/*    */ 
/*    */ public class AlphaAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private float start;
/*    */   private float end;
/*    */   @Null
/*    */   private Color color;
/*    */   
/*    */   protected void begin() {
/* 31 */     if (this.color == null) this.color = this.target.getColor(); 
/* 32 */     this.start = this.color.a;
/*    */   }
/*    */   
/*    */   protected void update(float paramFloat) {
/* 36 */     if (paramFloat == 0.0F) {
/* 37 */       this.color.a = this.start; return;
/* 38 */     }  if (paramFloat == 1.0F) {
/* 39 */       this.color.a = this.end; return;
/*    */     } 
/* 41 */     this.color.a = this.start + (this.end - this.start) * paramFloat;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 45 */     super.reset();
/* 46 */     this.color = null;
/*    */   }
/*    */   @Null
/*    */   public Color getColor() {
/* 50 */     return this.color;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setColor(@Null Color paramColor) {
/* 56 */     this.color = paramColor;
/*    */   }
/*    */   
/*    */   public float getAlpha() {
/* 60 */     return this.end;
/*    */   }
/*    */   
/*    */   public void setAlpha(float paramFloat) {
/* 64 */     this.end = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\AlphaAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */