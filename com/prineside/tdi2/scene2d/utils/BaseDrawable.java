/*     */ package com.prineside.tdi2.scene2d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.reflect.ClassReflection;
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
/*     */ public class BaseDrawable
/*     */   implements Drawable
/*     */ {
/*     */   @Null
/*     */   private String a;
/*     */   private float b;
/*     */   private float c;
/*     */   private float d;
/*     */   private float e;
/*     */   private float f;
/*     */   private float g;
/*     */   
/*     */   public BaseDrawable() {}
/*     */   
/*     */   public BaseDrawable(Drawable paramDrawable) {
/*  34 */     if (paramDrawable instanceof BaseDrawable) this.a = ((BaseDrawable)paramDrawable).getName(); 
/*  35 */     this.b = paramDrawable.getLeftWidth();
/*  36 */     this.c = paramDrawable.getRightWidth();
/*  37 */     this.d = paramDrawable.getTopHeight();
/*  38 */     this.e = paramDrawable.getBottomHeight();
/*  39 */     this.f = paramDrawable.getMinWidth();
/*  40 */     this.g = paramDrawable.getMinHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
/*     */   
/*     */   public float getLeftWidth() {
/*  47 */     return this.b;
/*     */   }
/*     */   
/*     */   public void setLeftWidth(float paramFloat) {
/*  51 */     this.b = paramFloat;
/*     */   }
/*     */   
/*     */   public float getRightWidth() {
/*  55 */     return this.c;
/*     */   }
/*     */   
/*     */   public void setRightWidth(float paramFloat) {
/*  59 */     this.c = paramFloat;
/*     */   }
/*     */   
/*     */   public float getTopHeight() {
/*  63 */     return this.d;
/*     */   }
/*     */   
/*     */   public void setTopHeight(float paramFloat) {
/*  67 */     this.d = paramFloat;
/*     */   }
/*     */   
/*     */   public float getBottomHeight() {
/*  71 */     return this.e;
/*     */   }
/*     */   
/*     */   public void setBottomHeight(float paramFloat) {
/*  75 */     this.e = paramFloat;
/*     */   }
/*     */   
/*     */   public void setPadding(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  79 */     setTopHeight(paramFloat1);
/*  80 */     setLeftWidth(paramFloat2);
/*  81 */     setBottomHeight(paramFloat3);
/*  82 */     setRightWidth(paramFloat4);
/*     */   }
/*     */   
/*     */   public float getMinWidth() {
/*  86 */     return this.f;
/*     */   }
/*     */   
/*     */   public void setMinWidth(float paramFloat) {
/*  90 */     this.f = paramFloat;
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/*  94 */     return this.g;
/*     */   }
/*     */   
/*     */   public void setMinHeight(float paramFloat) {
/*  98 */     this.g = paramFloat;
/*     */   }
/*     */   
/*     */   public void setMinSize(float paramFloat1, float paramFloat2) {
/* 102 */     setMinWidth(paramFloat1);
/* 103 */     setMinHeight(paramFloat2);
/*     */   }
/*     */   @Null
/*     */   public String getName() {
/* 107 */     return this.a;
/*     */   }
/*     */   
/*     */   public void setName(@Null String paramString) {
/* 111 */     this.a = paramString;
/*     */   }
/*     */   @Null
/*     */   public String toString() {
/* 115 */     if (this.a == null) return ClassReflection.getSimpleName(getClass()); 
/* 116 */     return this.a;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\BaseDrawable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */