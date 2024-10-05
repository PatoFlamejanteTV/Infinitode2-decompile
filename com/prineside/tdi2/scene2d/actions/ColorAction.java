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
/*    */ public class ColorAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private float c;
/*    */   private float d;
/*    */   private float e;
/*    */   private float f;
/*    */   @Null
/*    */   private Color g;
/* 29 */   private final Color h = new Color();
/*    */   
/*    */   protected final void a() {
/* 32 */     if (this.g == null) this.g = this.b.getColor(); 
/* 33 */     this.c = this.g.r;
/* 34 */     this.d = this.g.g;
/* 35 */     this.e = this.g.b;
/* 36 */     this.f = this.g.a;
/*    */   }
/*    */   
/*    */   protected final void a(float paramFloat) {
/* 40 */     if (paramFloat == 0.0F) {
/* 41 */       this.g.set(this.c, this.d, this.e, this.f); return;
/* 42 */     }  if (paramFloat == 1.0F) {
/* 43 */       this.g.set(this.h); return;
/*    */     } 
/* 45 */     float f1 = this.c + (this.h.r - this.c) * paramFloat;
/* 46 */     float f2 = this.d + (this.h.g - this.d) * paramFloat;
/* 47 */     float f3 = this.e + (this.h.b - this.e) * paramFloat;
/* 48 */     paramFloat = this.f + (this.h.a - this.f) * paramFloat;
/* 49 */     this.g.set(f1, f2, f3, paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public void reset() {
/* 54 */     super.reset();
/* 55 */     this.g = null;
/*    */   }
/*    */   @Null
/*    */   public Color getColor() {
/* 59 */     return this.g;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setColor(@Null Color paramColor) {
/* 65 */     this.g = paramColor;
/*    */   }
/*    */   
/*    */   public Color getEndColor() {
/* 69 */     return this.h;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setEndColor(Color paramColor) {
/* 74 */     this.h.set(paramColor);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\ColorAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */