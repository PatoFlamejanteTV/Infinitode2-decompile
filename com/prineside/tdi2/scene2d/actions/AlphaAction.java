/*    */ package com.prineside.tdi2.scene2d.actions;
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
/*    */   private float c;
/*    */   private float d;
/*    */   @Null
/*    */   private Color e;
/*    */   
/*    */   protected final void a() {
/* 31 */     if (this.e == null) this.e = this.b.getColor(); 
/* 32 */     this.c = this.e.a;
/*    */   }
/*    */   
/*    */   protected final void a(float paramFloat) {
/* 36 */     if (paramFloat == 0.0F) {
/* 37 */       this.e.a = this.c; return;
/* 38 */     }  if (paramFloat == 1.0F) {
/* 39 */       this.e.a = this.d; return;
/*    */     } 
/* 41 */     this.e.a = this.c + (this.d - this.c) * paramFloat;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 45 */     super.reset();
/* 46 */     this.e = null;
/*    */   }
/*    */   @Null
/*    */   public Color getColor() {
/* 50 */     return this.e;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setColor(@Null Color paramColor) {
/* 56 */     this.e = paramColor;
/*    */   }
/*    */   
/*    */   public float getAlpha() {
/* 60 */     return this.d;
/*    */   }
/*    */   
/*    */   public void setAlpha(float paramFloat) {
/* 64 */     this.d = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\AlphaAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */