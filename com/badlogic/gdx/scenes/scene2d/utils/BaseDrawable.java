/*     */ package com.badlogic.gdx.scenes.scene2d.utils;
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
/*     */   private String name;
/*     */   private float leftWidth;
/*     */   private float rightWidth;
/*     */   private float topHeight;
/*     */   private float bottomHeight;
/*     */   private float minWidth;
/*     */   private float minHeight;
/*     */   
/*     */   public BaseDrawable() {}
/*     */   
/*     */   public BaseDrawable(Drawable paramDrawable) {
/*  34 */     if (paramDrawable instanceof BaseDrawable) this.name = ((BaseDrawable)paramDrawable).getName(); 
/*  35 */     this.leftWidth = paramDrawable.getLeftWidth();
/*  36 */     this.rightWidth = paramDrawable.getRightWidth();
/*  37 */     this.topHeight = paramDrawable.getTopHeight();
/*  38 */     this.bottomHeight = paramDrawable.getBottomHeight();
/*  39 */     this.minWidth = paramDrawable.getMinWidth();
/*  40 */     this.minHeight = paramDrawable.getMinHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
/*     */   
/*     */   public float getLeftWidth() {
/*  47 */     return this.leftWidth;
/*     */   }
/*     */   
/*     */   public void setLeftWidth(float paramFloat) {
/*  51 */     this.leftWidth = paramFloat;
/*     */   }
/*     */   
/*     */   public float getRightWidth() {
/*  55 */     return this.rightWidth;
/*     */   }
/*     */   
/*     */   public void setRightWidth(float paramFloat) {
/*  59 */     this.rightWidth = paramFloat;
/*     */   }
/*     */   
/*     */   public float getTopHeight() {
/*  63 */     return this.topHeight;
/*     */   }
/*     */   
/*     */   public void setTopHeight(float paramFloat) {
/*  67 */     this.topHeight = paramFloat;
/*     */   }
/*     */   
/*     */   public float getBottomHeight() {
/*  71 */     return this.bottomHeight;
/*     */   }
/*     */   
/*     */   public void setBottomHeight(float paramFloat) {
/*  75 */     this.bottomHeight = paramFloat;
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
/*  86 */     return this.minWidth;
/*     */   }
/*     */   
/*     */   public void setMinWidth(float paramFloat) {
/*  90 */     this.minWidth = paramFloat;
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/*  94 */     return this.minHeight;
/*     */   }
/*     */   
/*     */   public void setMinHeight(float paramFloat) {
/*  98 */     this.minHeight = paramFloat;
/*     */   }
/*     */   
/*     */   public void setMinSize(float paramFloat1, float paramFloat2) {
/* 102 */     setMinWidth(paramFloat1);
/* 103 */     setMinHeight(paramFloat2);
/*     */   }
/*     */   @Null
/*     */   public String getName() {
/* 107 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(@Null String paramString) {
/* 111 */     this.name = paramString;
/*     */   }
/*     */   @Null
/*     */   public String toString() {
/* 115 */     if (this.name == null) return ClassReflection.getSimpleName(getClass()); 
/* 116 */     return this.name;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\BaseDrawable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */