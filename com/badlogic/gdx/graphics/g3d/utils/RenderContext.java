/*     */ package com.badlogic.gdx.graphics.g3d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderContext
/*     */ {
/*     */   public final TextureBinder textureBinder;
/*     */   private boolean blending;
/*     */   private int blendSFactor;
/*     */   private int blendDFactor;
/*     */   private int depthFunc;
/*     */   private float depthRangeNear;
/*     */   private float depthRangeFar;
/*     */   private boolean depthMask;
/*     */   private int cullFace;
/*     */   
/*     */   public RenderContext(TextureBinder paramTextureBinder) {
/*  39 */     this.textureBinder = paramTextureBinder;
/*     */   }
/*     */ 
/*     */   
/*     */   public void begin() {
/*  44 */     Gdx.gl.glDisable(2929);
/*  45 */     this.depthFunc = 0;
/*  46 */     Gdx.gl.glDepthMask(true);
/*  47 */     this.depthMask = true;
/*  48 */     Gdx.gl.glDisable(3042);
/*  49 */     this.blending = false;
/*  50 */     Gdx.gl.glDisable(2884);
/*  51 */     this.cullFace = this.blendSFactor = this.blendDFactor = 0;
/*  52 */     this.textureBinder.begin();
/*     */   }
/*     */ 
/*     */   
/*     */   public void end() {
/*  57 */     if (this.depthFunc != 0) Gdx.gl.glDisable(2929); 
/*  58 */     if (!this.depthMask) Gdx.gl.glDepthMask(true); 
/*  59 */     if (this.blending) Gdx.gl.glDisable(3042); 
/*  60 */     if (this.cullFace > 0) Gdx.gl.glDisable(2884); 
/*  61 */     this.textureBinder.end();
/*     */   }
/*     */   
/*     */   public void setDepthMask(boolean paramBoolean) {
/*  65 */     if (this.depthMask != paramBoolean) Gdx.gl.glDepthMask(this.depthMask = paramBoolean); 
/*     */   }
/*     */   
/*     */   public void setDepthTest(int paramInt) {
/*  69 */     setDepthTest(paramInt, 0.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public void setDepthTest(int paramInt, float paramFloat1, float paramFloat2) {
/*  73 */     boolean bool1 = (this.depthFunc != 0) ? true : false;
/*  74 */     boolean bool2 = (paramInt != 0) ? true : false;
/*  75 */     if (this.depthFunc != paramInt) {
/*  76 */       this.depthFunc = paramInt;
/*  77 */       if (bool2) {
/*  78 */         Gdx.gl.glEnable(2929);
/*  79 */         Gdx.gl.glDepthFunc(paramInt);
/*     */       } else {
/*  81 */         Gdx.gl.glDisable(2929);
/*     */       } 
/*  83 */     }  if (bool2) {
/*  84 */       if (!bool1 || this.depthFunc != paramInt) Gdx.gl.glDepthFunc(this.depthFunc = paramInt); 
/*  85 */       if (!bool1 || this.depthRangeNear != paramFloat1 || this.depthRangeFar != paramFloat2)
/*  86 */         Gdx.gl.glDepthRangef(this.depthRangeNear = paramFloat1, this.depthRangeFar = paramFloat2); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setBlending(boolean paramBoolean, int paramInt1, int paramInt2) {
/*  91 */     if (paramBoolean != this.blending) {
/*  92 */       this.blending = paramBoolean;
/*  93 */       if (paramBoolean) {
/*  94 */         Gdx.gl.glEnable(3042);
/*     */       } else {
/*  96 */         Gdx.gl.glDisable(3042);
/*     */       } 
/*  98 */     }  if (paramBoolean && (this.blendSFactor != paramInt1 || this.blendDFactor != paramInt2)) {
/*  99 */       Gdx.gl.glBlendFunc(paramInt1, paramInt2);
/* 100 */       this.blendSFactor = paramInt1;
/* 101 */       this.blendDFactor = paramInt2;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCullFace(int paramInt) {
/* 106 */     if (paramInt != this.cullFace) {
/* 107 */       this.cullFace = paramInt;
/* 108 */       if (paramInt == 1028 || paramInt == 1029 || paramInt == 1032) {
/* 109 */         Gdx.gl.glEnable(2884);
/* 110 */         Gdx.gl.glCullFace(paramInt); return;
/*     */       } 
/* 112 */       Gdx.gl.glDisable(2884);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\RenderContext.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */