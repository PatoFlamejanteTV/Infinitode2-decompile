/*     */ package com.badlogic.gdx.utils.viewport;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Scaling;
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
/*     */ 
/*     */ public class ExtendViewport
/*     */   extends Viewport
/*     */ {
/*     */   private float minWorldWidth;
/*     */   private float minWorldHeight;
/*     */   private float maxWorldWidth;
/*     */   private float maxWorldHeight;
/*  32 */   private Scaling scaling = Scaling.fit;
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtendViewport(float paramFloat1, float paramFloat2) {
/*  37 */     this(paramFloat1, paramFloat2, 0.0F, 0.0F, (Camera)new OrthographicCamera());
/*     */   }
/*     */ 
/*     */   
/*     */   public ExtendViewport(float paramFloat1, float paramFloat2, Camera paramCamera) {
/*  42 */     this(paramFloat1, paramFloat2, 0.0F, 0.0F, paramCamera);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtendViewport(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  48 */     this(paramFloat1, paramFloat2, paramFloat3, paramFloat4, (Camera)new OrthographicCamera());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtendViewport(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Camera paramCamera) {
/*  55 */     this.minWorldWidth = paramFloat1;
/*  56 */     this.minWorldHeight = paramFloat2;
/*  57 */     this.maxWorldWidth = paramFloat3;
/*  58 */     this.maxWorldHeight = paramFloat4;
/*  59 */     setCamera(paramCamera);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  64 */     float f1 = this.minWorldWidth;
/*  65 */     float f2 = this.minWorldHeight;
/*     */     
/*     */     Vector2 vector2;
/*     */     
/*  69 */     int j = Math.round((vector2 = this.scaling.apply(f1, f2, paramInt1, paramInt2)).x);
/*  70 */     int i = Math.round(vector2.y);
/*  71 */     if (j < paramInt1) {
/*  72 */       float f3 = i / f2;
/*  73 */       float f4 = f2 / i;
/*  74 */       f4 = (paramInt1 - j) * f4;
/*  75 */       if (this.maxWorldWidth > 0.0F) f4 = Math.min(f4, this.maxWorldWidth - this.minWorldWidth); 
/*  76 */       f1 += f4;
/*  77 */       j += Math.round(f4 * f3);
/*     */     } 
/*  79 */     if (i < paramInt2) {
/*  80 */       float f3 = j / f1;
/*  81 */       float f4 = f1 / j;
/*  82 */       f4 = (paramInt2 - i) * f4;
/*  83 */       if (this.maxWorldHeight > 0.0F) f4 = Math.min(f4, this.maxWorldHeight - this.minWorldHeight); 
/*  84 */       f2 += f4;
/*  85 */       i += Math.round(f4 * f3);
/*     */     } 
/*     */     
/*  88 */     setWorldSize(f1, f2);
/*     */ 
/*     */     
/*  91 */     setScreenBounds((paramInt1 - j) / 2, (paramInt2 - i) / 2, j, i);
/*     */     
/*  93 */     apply(paramBoolean);
/*     */   }
/*     */   
/*     */   public float getMinWorldWidth() {
/*  97 */     return this.minWorldWidth;
/*     */   }
/*     */   
/*     */   public void setMinWorldWidth(float paramFloat) {
/* 101 */     this.minWorldWidth = paramFloat;
/*     */   }
/*     */   
/*     */   public float getMinWorldHeight() {
/* 105 */     return this.minWorldHeight;
/*     */   }
/*     */   
/*     */   public void setMinWorldHeight(float paramFloat) {
/* 109 */     this.minWorldHeight = paramFloat;
/*     */   }
/*     */   
/*     */   public float getMaxWorldWidth() {
/* 113 */     return this.maxWorldWidth;
/*     */   }
/*     */   
/*     */   public void setMaxWorldWidth(float paramFloat) {
/* 117 */     this.maxWorldWidth = paramFloat;
/*     */   }
/*     */   
/*     */   public float getMaxWorldHeight() {
/* 121 */     return this.maxWorldHeight;
/*     */   }
/*     */   
/*     */   public void setMaxWorldHeight(float paramFloat) {
/* 125 */     this.maxWorldHeight = paramFloat;
/*     */   }
/*     */   
/*     */   public void setScaling(Scaling paramScaling) {
/* 129 */     this.scaling = paramScaling;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\viewport\ExtendViewport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */