/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.TextureData;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class GLOnlyTextureData
/*     */   implements TextureData
/*     */ {
/*  31 */   int width = 0;
/*  32 */   int height = 0;
/*     */   
/*     */   boolean isPrepared = false;
/*     */   
/*  36 */   int mipLevel = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   int internalFormat;
/*     */ 
/*     */ 
/*     */   
/*     */   int format;
/*     */ 
/*     */   
/*     */   int type;
/*     */ 
/*     */ 
/*     */   
/*     */   public GLOnlyTextureData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/*  52 */     this.width = paramInt1;
/*  53 */     this.height = paramInt2;
/*  54 */     this.mipLevel = paramInt3;
/*  55 */     this.internalFormat = paramInt4;
/*  56 */     this.format = paramInt5;
/*  57 */     this.type = paramInt6;
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureData.TextureDataType getType() {
/*  62 */     return TextureData.TextureDataType.Custom;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrepared() {
/*  67 */     return this.isPrepared;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/*  72 */     if (this.isPrepared) throw new GdxRuntimeException("Already prepared"); 
/*  73 */     this.isPrepared = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void consumeCustomData(int paramInt) {
/*  78 */     Gdx.gl.glTexImage2D(paramInt, this.mipLevel, this.internalFormat, this.width, this.height, 0, this.format, this.type, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap consumePixmap() {
/*  83 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean disposePixmap() {
/*  88 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  93 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  98 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap.Format getFormat() {
/* 103 */     return Pixmap.Format.RGBA8888;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useMipMaps() {
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/* 113 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\GLOnlyTextureData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */