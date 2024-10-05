/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Texture3DData;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class CustomTexture3DData
/*     */   implements Texture3DData
/*     */ {
/*     */   private int width;
/*     */   private int height;
/*     */   private int depth;
/*     */   private int mipMapLevel;
/*     */   private int glFormat;
/*     */   private int glInternalFormat;
/*     */   private int glType;
/*     */   private ByteBuffer pixels;
/*     */   
/*     */   public CustomTexture3DData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/*  48 */     this.width = paramInt1;
/*  49 */     this.height = paramInt2;
/*  50 */     this.depth = paramInt3;
/*  51 */     this.glFormat = paramInt5;
/*  52 */     this.glInternalFormat = paramInt6;
/*  53 */     this.glType = paramInt7;
/*  54 */     this.mipMapLevel = paramInt4;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrepared() {
/*  59 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepare() {}
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  68 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  73 */     return this.height;
/*     */   }
/*     */   
/*     */   public int getDepth() {
/*  77 */     return this.depth;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useMipMaps() {
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/*  87 */     return (this.pixels != null);
/*     */   }
/*     */   
/*     */   public int getInternalFormat() {
/*  91 */     return this.glInternalFormat;
/*     */   }
/*     */   
/*     */   public int getGLType() {
/*  95 */     return this.glType;
/*     */   }
/*     */   
/*     */   public int getGLFormat() {
/*  99 */     return this.glFormat;
/*     */   }
/*     */   
/*     */   public int getMipMapLevel() {
/* 103 */     return this.mipMapLevel;
/*     */   }
/*     */   
/*     */   public ByteBuffer getPixels() {
/* 107 */     if (this.pixels == null) {
/*     */       int i;
/*     */       byte b;
/* 110 */       if (this.glFormat == 6403 || this.glFormat == 36244 || this.glFormat == 6409 || this.glFormat == 6406) {
/*     */         
/* 112 */         i = 1;
/* 113 */       } else if (this.glFormat == 33319 || this.glFormat == 33320 || this.glFormat == 6410) {
/* 114 */         i = 2;
/* 115 */       } else if (this.glFormat == 6407 || this.glFormat == 36248) {
/* 116 */         i = 3;
/* 117 */       } else if (this.glFormat == 6408 || this.glFormat == 36249) {
/* 118 */         i = 4;
/*     */       } else {
/* 120 */         throw new GdxRuntimeException("unsupported glFormat: " + this.glFormat);
/*     */       } 
/*     */ 
/*     */       
/* 124 */       if (this.glType == 5121 || this.glType == 5120) {
/* 125 */         b = 1;
/* 126 */       } else if (this.glType == 5123 || this.glType == 5122 || this.glType == 5131) {
/* 127 */         b = 2;
/* 128 */       } else if (this.glType == 5125 || this.glType == 5124 || this.glType == 5126) {
/* 129 */         b = 4;
/*     */       } else {
/* 131 */         throw new GdxRuntimeException("unsupported glType: " + this.glType);
/*     */       } 
/*     */       
/* 134 */       i *= b;
/*     */       
/* 136 */       this.pixels = BufferUtils.newByteBuffer(this.width * this.height * this.depth * i);
/*     */     } 
/* 138 */     return this.pixels;
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume3DData() {
/* 143 */     Gdx.gl30.glTexImage3D(32879, this.mipMapLevel, this.glInternalFormat, this.width, this.height, this.depth, 0, this.glFormat, this.glType, this.pixels);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\CustomTexture3DData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */