/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import java.nio.ByteBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ScreenUtils
/*     */ {
/*     */   public static void clear(Color paramColor) {
/*  41 */     clear(paramColor.r, paramColor.g, paramColor.b, paramColor.a, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clear(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  46 */     clear(paramFloat1, paramFloat2, paramFloat3, paramFloat4, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clear(Color paramColor, boolean paramBoolean) {
/*  53 */     clear(paramColor.r, paramColor.g, paramColor.b, paramColor.a, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clear(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean) {
/*  59 */     clear(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clear(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean1, boolean paramBoolean2) {
/*  68 */     Gdx.gl.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*  69 */     int i = 16384;
/*  70 */     if (paramBoolean1) i = 16640; 
/*  71 */     if (paramBoolean2 && (Gdx.graphics.getBufferFormat()).coverageSampling) i |= 0x8000; 
/*  72 */     Gdx.gl.glClear(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TextureRegion getFrameBufferTexture() {
/*  80 */     int i = Gdx.graphics.getBackBufferWidth();
/*  81 */     int j = Gdx.graphics.getBackBufferHeight();
/*  82 */     return getFrameBufferTexture(0, 0, i, j);
/*     */   }
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
/*     */   public static TextureRegion getFrameBufferTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  96 */     int i = MathUtils.nextPowerOfTwo(paramInt3);
/*  97 */     int j = MathUtils.nextPowerOfTwo(paramInt4);
/*     */     
/*  99 */     Pixmap pixmap1 = Pixmap.createFromFrameBuffer(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */     Pixmap pixmap2;
/* 101 */     (pixmap2 = new Pixmap(i, j, Pixmap.Format.RGBA8888)).setBlending(Pixmap.Blending.None);
/* 102 */     pixmap2.drawPixmap(pixmap1, 0, 0);
/* 103 */     Texture texture = new Texture(pixmap2);
/* 104 */     TextureRegion textureRegion = new TextureRegion(texture, 0, paramInt4, paramInt3, -paramInt4);
/* 105 */     pixmap2.dispose();
/* 106 */     pixmap1.dispose();
/*     */     
/* 108 */     return textureRegion;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static Pixmap getFrameBufferPixmap(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 114 */     return Pixmap.createFromFrameBuffer(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] getFrameBufferPixels(boolean paramBoolean) {
/* 124 */     int i = Gdx.graphics.getBackBufferWidth();
/* 125 */     int j = Gdx.graphics.getBackBufferHeight();
/* 126 */     return getFrameBufferPixels(0, 0, i, j, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] getFrameBufferPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
/* 138 */     Gdx.gl.glPixelStorei(3333, 1);
/* 139 */     ByteBuffer byteBuffer = BufferUtils.newByteBuffer(paramInt3 * paramInt4 << 2);
/* 140 */     Gdx.gl.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, byteBuffer);
/*     */     
/* 142 */     byte[] arrayOfByte = new byte[paramInt1 = paramInt3 * paramInt4 << 2];
/* 143 */     if (paramBoolean) {
/* 144 */       paramInt2 = paramInt3 << 2;
/* 145 */       for (paramInt3 = 0; paramInt3 < paramInt4; paramInt3++) {
/* 146 */         byteBuffer.position((paramInt4 - paramInt3 - 1) * paramInt2);
/* 147 */         byteBuffer.get(arrayOfByte, paramInt3 * paramInt2, paramInt2);
/*     */       } 
/*     */     } else {
/* 150 */       byteBuffer.clear();
/* 151 */       byteBuffer.get(arrayOfByte);
/*     */     } 
/* 153 */     return arrayOfByte;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\ScreenUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */