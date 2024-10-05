/*     */ package com.badlogic.gdx.scenes.scene2d.actions;
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
/*     */   private float startX;
/*     */   private float startY;
/*     */   private float endX;
/*     */   private float endY;
/*  26 */   private int alignment = 12;
/*     */   
/*     */   protected void begin() {
/*  29 */     this.startX = this.target.getX(this.alignment);
/*  30 */     this.startY = this.target.getY(this.alignment);
/*     */   }
/*     */   
/*     */   protected void update(float paramFloat) {
/*     */     float f;
/*  35 */     if (paramFloat == 0.0F) {
/*  36 */       f = this.startX;
/*  37 */       paramFloat = this.startY;
/*  38 */     } else if (paramFloat == 1.0F) {
/*  39 */       f = this.endX;
/*  40 */       paramFloat = this.endY;
/*     */     } else {
/*  42 */       f = this.startX + (this.endX - this.startX) * paramFloat;
/*  43 */       paramFloat = this.startY + (this.endY - this.startY) * paramFloat;
/*     */     } 
/*  45 */     this.target.setPosition(f, paramFloat, this.alignment);
/*     */   }
/*     */   
/*     */   public void reset() {
/*  49 */     super.reset();
/*  50 */     this.alignment = 12;
/*     */   }
/*     */   
/*     */   public void setStartPosition(float paramFloat1, float paramFloat2) {
/*  54 */     this.startX = paramFloat1;
/*  55 */     this.startY = paramFloat2;
/*     */   }
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/*  59 */     this.endX = paramFloat1;
/*  60 */     this.endY = paramFloat2;
/*     */   }
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2, int paramInt) {
/*  64 */     this.endX = paramFloat1;
/*  65 */     this.endY = paramFloat2;
/*  66 */     this.alignment = paramInt;
/*     */   }
/*     */   
/*     */   public float getX() {
/*  70 */     return this.endX;
/*     */   }
/*     */   
/*     */   public void setX(float paramFloat) {
/*  74 */     this.endX = paramFloat;
/*     */   }
/*     */   
/*     */   public float getY() {
/*  78 */     return this.endY;
/*     */   }
/*     */   
/*     */   public void setY(float paramFloat) {
/*  82 */     this.endY = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getStartX() {
/*  87 */     return this.startX;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getStartY() {
/*  92 */     return this.startY;
/*     */   }
/*     */   
/*     */   public int getAlignment() {
/*  96 */     return this.alignment;
/*     */   }
/*     */   
/*     */   public void setAlignment(int paramInt) {
/* 100 */     this.alignment = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\MoveToAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */