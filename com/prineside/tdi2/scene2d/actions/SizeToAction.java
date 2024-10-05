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
/*    */ public class SizeToAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private float c;
/*    */   private float d;
/*    */   private float e;
/*    */   private float f;
/*    */   
/*    */   protected final void a() {
/* 26 */     this.c = this.b.getWidth();
/* 27 */     this.d = this.b.getHeight();
/*    */   }
/*    */   
/*    */   protected final void a(float paramFloat) {
/*    */     float f;
/* 32 */     if (paramFloat == 0.0F) {
/* 33 */       f = this.c;
/* 34 */       paramFloat = this.d;
/* 35 */     } else if (paramFloat == 1.0F) {
/* 36 */       f = this.e;
/* 37 */       paramFloat = this.f;
/*    */     } else {
/* 39 */       f = this.c + (this.e - this.c) * paramFloat;
/* 40 */       paramFloat = this.d + (this.f - this.d) * paramFloat;
/*    */     } 
/* 42 */     this.b.setSize(f, paramFloat);
/*    */   }
/*    */   
/*    */   public void setSize(float paramFloat1, float paramFloat2) {
/* 46 */     this.e = paramFloat1;
/* 47 */     this.f = paramFloat2;
/*    */   }
/*    */   
/*    */   public float getWidth() {
/* 51 */     return this.e;
/*    */   }
/*    */   
/*    */   public void setWidth(float paramFloat) {
/* 55 */     this.e = paramFloat;
/*    */   }
/*    */   
/*    */   public float getHeight() {
/* 59 */     return this.f;
/*    */   }
/*    */   
/*    */   public void setHeight(float paramFloat) {
/* 63 */     this.f = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\SizeToAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */