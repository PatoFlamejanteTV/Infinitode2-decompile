/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.PixmapIO;
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
/*     */ public class FileTextureData
/*     */   implements TextureData
/*     */ {
/*     */   final FileHandle file;
/*  29 */   int width = 0;
/*  30 */   int height = 0;
/*     */   Pixmap.Format format;
/*     */   Pixmap pixmap;
/*     */   boolean useMipMaps;
/*     */   boolean isPrepared = false;
/*     */   
/*     */   public FileTextureData(FileHandle paramFileHandle, Pixmap paramPixmap, Pixmap.Format paramFormat, boolean paramBoolean) {
/*  37 */     this.file = paramFileHandle;
/*  38 */     this.pixmap = paramPixmap;
/*  39 */     this.format = paramFormat;
/*  40 */     this.useMipMaps = paramBoolean;
/*  41 */     if (this.pixmap != null) {
/*  42 */       this.width = this.pixmap.getWidth();
/*  43 */       this.height = this.pixmap.getHeight();
/*  44 */       if (paramFormat == null) this.format = this.pixmap.getFormat();
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isPrepared() {
/*  50 */     return this.isPrepared;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/*  55 */     if (this.isPrepared) throw new GdxRuntimeException("Already prepared"); 
/*  56 */     if (this.pixmap == null) {
/*  57 */       if (this.file.extension().equals("cim")) {
/*  58 */         this.pixmap = PixmapIO.readCIM(this.file);
/*     */       } else {
/*  60 */         this.pixmap = new Pixmap(this.file);
/*  61 */       }  this.width = this.pixmap.getWidth();
/*  62 */       this.height = this.pixmap.getHeight();
/*  63 */       if (this.format == null) this.format = this.pixmap.getFormat(); 
/*     */     } 
/*  65 */     this.isPrepared = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap consumePixmap() {
/*  70 */     if (!this.isPrepared) throw new GdxRuntimeException("Call prepare() before calling getPixmap()"); 
/*  71 */     this.isPrepared = false;
/*  72 */     Pixmap pixmap = this.pixmap;
/*  73 */     this.pixmap = null;
/*  74 */     return pixmap;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean disposePixmap() {
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  84 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  89 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap.Format getFormat() {
/*  94 */     return this.format;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useMipMaps() {
/*  99 */     return this.useMipMaps;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/* 104 */     return true;
/*     */   }
/*     */   
/*     */   public FileHandle getFileHandle() {
/* 108 */     return this.file;
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureData.TextureDataType getType() {
/* 113 */     return TextureData.TextureDataType.Pixmap;
/*     */   }
/*     */ 
/*     */   
/*     */   public void consumeCustomData(int paramInt) {
/* 118 */     throw new GdxRuntimeException("This TextureData implementation does not upload data itself");
/*     */   }
/*     */   
/*     */   public String toString() {
/* 122 */     return this.file.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\FileTextureData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */