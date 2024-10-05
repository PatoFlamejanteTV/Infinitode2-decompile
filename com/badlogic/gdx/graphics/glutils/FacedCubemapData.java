/*     */ package com.badlogic.gdx.graphics.glutils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Cubemap;
/*     */ import com.badlogic.gdx.graphics.CubemapData;
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
/*     */ public class FacedCubemapData
/*     */   implements CubemapData
/*     */ {
/*  21 */   protected final TextureData[] data = new TextureData[6];
/*     */ 
/*     */ 
/*     */   
/*     */   public FacedCubemapData() {
/*  26 */     this((TextureData)null, (TextureData)null, (TextureData)null, (TextureData)null, (TextureData)null, (TextureData)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FacedCubemapData(FileHandle paramFileHandle1, FileHandle paramFileHandle2, FileHandle paramFileHandle3, FileHandle paramFileHandle4, FileHandle paramFileHandle5, FileHandle paramFileHandle6) {
/*  32 */     this(TextureData.Factory.loadFromFile(paramFileHandle1, false), TextureData.Factory.loadFromFile(paramFileHandle2, false), 
/*  33 */         TextureData.Factory.loadFromFile(paramFileHandle3, false), TextureData.Factory.loadFromFile(paramFileHandle4, false), 
/*  34 */         TextureData.Factory.loadFromFile(paramFileHandle5, false), TextureData.Factory.loadFromFile(paramFileHandle6, false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FacedCubemapData(FileHandle paramFileHandle1, FileHandle paramFileHandle2, FileHandle paramFileHandle3, FileHandle paramFileHandle4, FileHandle paramFileHandle5, FileHandle paramFileHandle6, boolean paramBoolean) {
/*  40 */     this(TextureData.Factory.loadFromFile(paramFileHandle1, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle2, paramBoolean), 
/*  41 */         TextureData.Factory.loadFromFile(paramFileHandle3, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle4, paramBoolean), 
/*  42 */         TextureData.Factory.loadFromFile(paramFileHandle5, paramBoolean), TextureData.Factory.loadFromFile(paramFileHandle6, paramBoolean));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FacedCubemapData(Pixmap paramPixmap1, Pixmap paramPixmap2, Pixmap paramPixmap3, Pixmap paramPixmap4, Pixmap paramPixmap5, Pixmap paramPixmap6) {
/*  48 */     this(paramPixmap1, paramPixmap2, paramPixmap3, paramPixmap4, paramPixmap5, paramPixmap6, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FacedCubemapData(Pixmap paramPixmap1, Pixmap paramPixmap2, Pixmap paramPixmap3, Pixmap paramPixmap4, Pixmap paramPixmap5, Pixmap paramPixmap6, boolean paramBoolean) {
/*  54 */     this((paramPixmap1 == null) ? null : new PixmapTextureData(paramPixmap1, null, paramBoolean, false), 
/*  55 */         (paramPixmap2 == null) ? null : new PixmapTextureData(paramPixmap2, null, paramBoolean, false), 
/*  56 */         (paramPixmap3 == null) ? null : new PixmapTextureData(paramPixmap3, null, paramBoolean, false), 
/*  57 */         (paramPixmap4 == null) ? null : new PixmapTextureData(paramPixmap4, null, paramBoolean, false), 
/*  58 */         (paramPixmap5 == null) ? null : new PixmapTextureData(paramPixmap5, null, paramBoolean, false), 
/*  59 */         (paramPixmap6 == null) ? null : new PixmapTextureData(paramPixmap6, null, paramBoolean, false));
/*     */   }
/*     */ 
/*     */   
/*     */   public FacedCubemapData(int paramInt1, int paramInt2, int paramInt3, Pixmap.Format paramFormat) {
/*  64 */     this(new PixmapTextureData(new Pixmap(paramInt3, paramInt2, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt3, paramInt2, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt3, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt3, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt2, paramFormat), null, false, true), new PixmapTextureData(new Pixmap(paramInt1, paramInt2, paramFormat), null, false, true));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FacedCubemapData(TextureData paramTextureData1, TextureData paramTextureData2, TextureData paramTextureData3, TextureData paramTextureData4, TextureData paramTextureData5, TextureData paramTextureData6) {
/*  75 */     this.data[0] = paramTextureData1;
/*  76 */     this.data[1] = paramTextureData2;
/*  77 */     this.data[2] = paramTextureData3;
/*  78 */     this.data[3] = paramTextureData4;
/*  79 */     this.data[4] = paramTextureData5;
/*  80 */     this.data[5] = paramTextureData6;
/*     */   } public boolean isManaged() {
/*     */     TextureData[] arrayOfTextureData;
/*     */     int i;
/*     */     byte b;
/*  85 */     for (i = (arrayOfTextureData = this.data).length, b = 0; b < i; b++) {
/*  86 */       TextureData textureData; if (!(textureData = arrayOfTextureData[b]).isManaged()) return false; 
/*  87 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(Cubemap.CubemapSide paramCubemapSide, FileHandle paramFileHandle) {
/*  96 */     this.data[paramCubemapSide.index] = TextureData.Factory.loadFromFile(paramFileHandle, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(Cubemap.CubemapSide paramCubemapSide, Pixmap paramPixmap) {
/* 105 */     this.data[paramCubemapSide.index] = (paramPixmap == null) ? null : new PixmapTextureData(paramPixmap, null, false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 110 */     for (byte b = 0; b < this.data.length; b++) {
/* 111 */       if (this.data[b] == null) return false; 
/* 112 */     }  return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureData getTextureData(Cubemap.CubemapSide paramCubemapSide) {
/* 117 */     return this.data[paramCubemapSide.index];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 122 */     int j = 0; int i;
/* 123 */     if (this.data[Cubemap.CubemapSide.PositiveZ.index] != null && (i = this.data[Cubemap.CubemapSide.PositiveZ.index].getWidth()) > 0) j = i; 
/* 124 */     if (this.data[Cubemap.CubemapSide.NegativeZ.index] != null && (i = this.data[Cubemap.CubemapSide.NegativeZ.index].getWidth()) > j) j = i; 
/* 125 */     if (this.data[Cubemap.CubemapSide.PositiveY.index] != null && (i = this.data[Cubemap.CubemapSide.PositiveY.index].getWidth()) > j) j = i; 
/* 126 */     if (this.data[Cubemap.CubemapSide.NegativeY.index] != null && (i = this.data[Cubemap.CubemapSide.NegativeY.index].getWidth()) > j) j = i; 
/* 127 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 132 */     int j = 0; int i;
/* 133 */     if (this.data[Cubemap.CubemapSide.PositiveZ.index] != null && (i = this.data[Cubemap.CubemapSide.PositiveZ.index].getHeight()) > 0)
/* 134 */       j = i; 
/* 135 */     if (this.data[Cubemap.CubemapSide.NegativeZ.index] != null && (i = this.data[Cubemap.CubemapSide.NegativeZ.index].getHeight()) > j)
/* 136 */       j = i; 
/* 137 */     if (this.data[Cubemap.CubemapSide.PositiveX.index] != null && (i = this.data[Cubemap.CubemapSide.PositiveX.index].getHeight()) > j)
/* 138 */       j = i; 
/* 139 */     if (this.data[Cubemap.CubemapSide.NegativeX.index] != null && (i = this.data[Cubemap.CubemapSide.NegativeX.index].getHeight()) > j)
/* 140 */       j = i; 
/* 141 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrepared() {
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/* 151 */     if (!isComplete()) throw new GdxRuntimeException("You need to complete your cubemap data before using it"); 
/* 152 */     for (byte b = 0; b < this.data.length; b++) {
/* 153 */       if (!this.data[b].isPrepared()) this.data[b].prepare(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void consumeCubemapData() {
/* 158 */     for (byte b = 0; b < this.data.length; b++) {
/* 159 */       if (this.data[b].getType() == TextureData.TextureDataType.Custom) {
/* 160 */         this.data[b].consumeCustomData(b + 34069);
/*     */       } else {
/* 162 */         Pixmap pixmap = this.data[b].consumePixmap();
/* 163 */         boolean bool = this.data[b].disposePixmap();
/* 164 */         if (this.data[b].getFormat() != pixmap.getFormat()) {
/*     */           Pixmap pixmap1;
/* 166 */           (pixmap1 = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), this.data[b].getFormat())).setBlending(Pixmap.Blending.None);
/* 167 */           pixmap1.drawPixmap(pixmap, 0, 0, 0, 0, pixmap.getWidth(), pixmap.getHeight());
/* 168 */           if (this.data[b].disposePixmap()) pixmap.dispose(); 
/* 169 */           pixmap = pixmap1;
/* 170 */           bool = true;
/*     */         } 
/* 172 */         Gdx.gl.glPixelStorei(3317, 1);
/* 173 */         Gdx.gl.glTexImage2D(b + 34069, 0, pixmap.getGLInternalFormat(), pixmap.getWidth(), pixmap
/* 174 */             .getHeight(), 0, pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
/* 175 */         if (bool) pixmap.dispose(); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\FacedCubemapData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */