/*     */ package com.prineside.tdi2.scene2d.actions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MoveToAction
/*     */   extends TemporalAction
/*     */ {
/*     */   private float c;
/*     */   private float d;
/*     */   private float e;
/*     */   private float f;
/*  26 */   private int g = 12;
/*     */   
/*     */   protected final void a() {
/*  29 */     this.c = this.b.getX(this.g);
/*  30 */     this.d = this.b.getY(this.g);
/*     */   }
/*     */   
/*     */   protected final void a(float paramFloat) {
/*     */     float f;
/*  35 */     if (paramFloat == 0.0F) {
/*  36 */       f = this.c;
/*  37 */       paramFloat = this.d;
/*  38 */     } else if (paramFloat == 1.0F) {
/*  39 */       f = this.e;
/*  40 */       paramFloat = this.f;
/*     */     } else {
/*  42 */       f = this.c + (this.e - this.c) * paramFloat;
/*  43 */       paramFloat = this.d + (this.f - this.d) * paramFloat;
/*     */     } 
/*  45 */     this.b.setPosition(f, paramFloat, this.g);
/*     */   }
/*     */   
/*     */   public void reset() {
/*  49 */     super.reset();
/*  50 */     this.g = 12;
/*     */   }
/*     */   
/*     */   public void setStartPosition(float paramFloat1, float paramFloat2) {
/*  54 */     this.c = paramFloat1;
/*  55 */     this.d = paramFloat2;
/*     */   }
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/*  59 */     this.e = paramFloat1;
/*  60 */     this.f = paramFloat2;
/*     */   }
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2, int paramInt) {
/*  64 */     this.e = paramFloat1;
/*  65 */     this.f = paramFloat2;
/*  66 */     this.g = paramInt;
/*     */   }
/*     */   
/*     */   public float getX() {
/*  70 */     return this.e;
/*     */   }
/*     */   
/*     */   public void setX(float paramFloat) {
/*  74 */     this.e = paramFloat;
/*     */   }
/*     */   
/*     */   public float getY() {
/*  78 */     return this.f;
/*     */   }
/*     */   
/*     */   public void setY(float paramFloat) {
/*  82 */     this.f = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getStartX() {
/*  87 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getStartY() {
/*  92 */     return this.d;
/*     */   }
/*     */   
/*     */   public int getAlignment() {
/*  96 */     return this.g;
/*     */   }
/*     */   
/*     */   public void setAlignment(int paramInt) {
/* 100 */     this.g = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\MoveToAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */