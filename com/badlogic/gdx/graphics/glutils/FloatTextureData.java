/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.TextureData;
/*     */ import com.badlogic.gdx.utils.BufferUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import java.nio.FloatBuffer;
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
/*     */ public class FloatTextureData
/*     */   implements TextureData
/*     */ {
/*  34 */   int width = 0;
/*  35 */   int height = 0;
/*     */   
/*     */   int internalFormat;
/*     */   
/*     */   int format;
/*     */   
/*     */   int type;
/*     */   boolean isGpuOnly;
/*     */   boolean isPrepared = false;
/*     */   FloatBuffer buffer;
/*     */   
/*     */   public FloatTextureData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
/*  47 */     this.width = paramInt1;
/*  48 */     this.height = paramInt2;
/*  49 */     this.internalFormat = paramInt3;
/*  50 */     this.format = paramInt4;
/*  51 */     this.type = paramInt5;
/*  52 */     this.isGpuOnly = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureData.TextureDataType getType() {
/*  57 */     return TextureData.TextureDataType.Custom;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrepared() {
/*  62 */     return this.isPrepared;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/*  67 */     if (this.isPrepared) throw new GdxRuntimeException("Already prepared"); 
/*  68 */     if (!this.isGpuOnly) {
/*  69 */       byte b = 4;
/*  70 */       if (Gdx.graphics.getGLVersion().getType().equals(GLVersion.Type.OpenGL)) {
/*  71 */         if (this.internalFormat == 34842 || this.internalFormat == 34836) b = 4; 
/*  72 */         if (this.internalFormat == 34843 || this.internalFormat == 34837) b = 3; 
/*  73 */         if (this.internalFormat == 33327 || this.internalFormat == 33328) b = 2; 
/*  74 */         if (this.internalFormat == 33325 || this.internalFormat == 33326) b = 1; 
/*     */       } 
/*  76 */       this.buffer = BufferUtils.newFloatBuffer(this.width * this.height * b);
/*     */     } 
/*  78 */     this.isPrepared = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void consumeCustomData(int paramInt) {
/*  83 */     if (Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS || (Gdx.app
/*  84 */       .getType() == Application.ApplicationType.WebGL && !Gdx.graphics.isGL30Available())) {
/*     */       
/*  86 */       if (!Gdx.graphics.supportsExtension("OES_texture_float")) {
/*  87 */         throw new GdxRuntimeException("Extension OES_texture_float not supported!");
/*     */       }
/*     */ 
/*     */       
/*  91 */       Gdx.gl.glTexImage2D(paramInt, 0, 6408, this.width, this.height, 0, 6408, 5126, this.buffer);
/*     */       return;
/*     */     } 
/*  94 */     if (!Gdx.graphics.isGL30Available() && 
/*  95 */       !Gdx.graphics.supportsExtension("GL_ARB_texture_float")) {
/*  96 */       throw new GdxRuntimeException("Extension GL_ARB_texture_float not supported!");
/*     */     }
/*     */ 
/*     */     
/* 100 */     Gdx.gl.glTexImage2D(paramInt, 0, this.internalFormat, this.width, this.height, 0, this.format, 5126, this.buffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Pixmap consumePixmap() {
/* 106 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean disposePixmap() {
/* 111 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 116 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 121 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap.Format getFormat() {
/* 126 */     return Pixmap.Format.RGBA8888;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useMipMaps() {
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/* 136 */     return true;
/*     */   }
/*     */   
/*     */   public FloatBuffer getBuffer() {
/* 140 */     return this.buffer;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\FloatTextureData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */