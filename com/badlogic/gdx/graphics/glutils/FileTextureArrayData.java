/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.TextureArrayData;
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
/*     */ public class FileTextureArrayData
/*     */   implements TextureArrayData
/*     */ {
/*     */   private TextureData[] textureDatas;
/*     */   private boolean prepared;
/*     */   private Pixmap.Format format;
/*     */   private int depth;
/*     */   boolean useMipMaps;
/*     */   
/*     */   public FileTextureArrayData(Pixmap.Format paramFormat, boolean paramBoolean, FileHandle[] paramArrayOfFileHandle) {
/*  37 */     this.format = paramFormat;
/*  38 */     this.useMipMaps = paramBoolean;
/*  39 */     this.depth = paramArrayOfFileHandle.length;
/*  40 */     this.textureDatas = new TextureData[paramArrayOfFileHandle.length];
/*  41 */     for (byte b = 0; b < paramArrayOfFileHandle.length; b++) {
/*  42 */       this.textureDatas[b] = TextureData.Factory.loadFromFile(paramArrayOfFileHandle[b], paramFormat, paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrepared() {
/*  48 */     return this.prepared;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/*  53 */     int i = -1;
/*  54 */     int j = -1; TextureData[] arrayOfTextureData; int k; byte b;
/*  55 */     for (k = (arrayOfTextureData = this.textureDatas).length, b = 0; b < k; b++) {
/*  56 */       TextureData textureData; (textureData = arrayOfTextureData[b]).prepare();
/*  57 */       if (i == -1) {
/*  58 */         i = textureData.getWidth();
/*  59 */         j = textureData.getHeight();
/*     */       
/*     */       }
/*  62 */       else if (i != textureData.getWidth() || j != textureData.getHeight()) {
/*  63 */         throw new GdxRuntimeException("Error whilst preparing TextureArray: TextureArray Textures must have equal dimensions.");
/*     */       } 
/*     */     } 
/*     */     
/*  67 */     this.prepared = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void consumeTextureArrayData() {
/*  72 */     boolean bool = false;
/*  73 */     for (byte b = 0; b < this.textureDatas.length; b++) {
/*  74 */       if (this.textureDatas[b].getType() == TextureData.TextureDataType.Custom) {
/*  75 */         this.textureDatas[b].consumeCustomData(35866);
/*  76 */         bool = true;
/*     */       } else {
/*     */         TextureData textureData;
/*  79 */         Pixmap pixmap = (textureData = this.textureDatas[b]).consumePixmap();
/*  80 */         boolean bool1 = textureData.disposePixmap();
/*  81 */         if (textureData.getFormat() != pixmap.getFormat()) {
/*     */           Pixmap pixmap1;
/*  83 */           (pixmap1 = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), textureData.getFormat())).setBlending(Pixmap.Blending.None);
/*  84 */           pixmap1.drawPixmap(pixmap, 0, 0, 0, 0, pixmap.getWidth(), pixmap.getHeight());
/*  85 */           if (textureData.disposePixmap()) {
/*  86 */             pixmap.dispose();
/*     */           }
/*  88 */           pixmap = pixmap1;
/*  89 */           bool1 = true;
/*     */         } 
/*  91 */         Gdx.gl30.glTexSubImage3D(35866, 0, 0, 0, b, pixmap.getWidth(), pixmap.getHeight(), 1, pixmap
/*  92 */             .getGLInternalFormat(), pixmap.getGLType(), pixmap.getPixels());
/*  93 */         if (bool1) pixmap.dispose(); 
/*     */       } 
/*     */     } 
/*  96 */     if (this.useMipMaps && !bool) {
/*  97 */       Gdx.gl20.glGenerateMipmap(35866);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 103 */     return this.textureDatas[0].getWidth();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 108 */     return this.textureDatas[0].getHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDepth() {
/* 113 */     return this.depth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInternalFormat() {
/* 118 */     return Pixmap.Format.toGlFormat(this.format);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getGLType() {
/* 123 */     return Pixmap.Format.toGlType(this.format);
/*     */   } public boolean isManaged() {
/*     */     TextureData[] arrayOfTextureData;
/*     */     int i;
/*     */     byte b;
/* 128 */     for (i = (arrayOfTextureData = this.textureDatas).length, b = 0; b < i; b++) {
/* 129 */       TextureData textureData; if (!(textureData = arrayOfTextureData[b]).isManaged()) {
/* 130 */         return false;
/*     */       }
/*     */     } 
/* 133 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\FileTextureArrayData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */