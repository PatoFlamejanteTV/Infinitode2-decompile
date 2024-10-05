/*     */ package com.crashinvaders.basisu.gdx;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.TextureData;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuFileInfo;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuImageInfo;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTextureType;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTranscoderTextureFormat;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuWrapper;
/*     */ import java.nio.ByteBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasisuTextureData
/*     */   implements TextureData
/*     */ {
/*  24 */   private static final String TAG = BasisuTextureData.class.getSimpleName();
/*     */   
/*  26 */   private BasisuTextureFormatSelector formatSelector = BasisuGdxUtils.defaultFormatSelector;
/*     */   
/*     */   private final FileHandle file;
/*     */   
/*     */   private final int imageIndex;
/*     */   
/*     */   private final int mipmapLevel;
/*     */   private BasisuData basisuData;
/*  34 */   private ByteBuffer transcodedData = null;
/*  35 */   private BasisuTranscoderTextureFormat transcodeFormat = null;
/*     */   
/*  37 */   private int width = 0;
/*  38 */   private int height = 0;
/*     */ 
/*     */   
/*     */   private boolean isPrepared = false;
/*     */ 
/*     */   
/*     */   public BasisuTextureData(FileHandle paramFileHandle) {
/*  45 */     this(paramFileHandle, 0, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasisuTextureData(FileHandle paramFileHandle, int paramInt) {
/*  53 */     this(paramFileHandle, paramInt, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasisuTextureData(FileHandle paramFileHandle, int paramInt1, int paramInt2) {
/*  63 */     this.file = paramFileHandle;
/*  64 */     this.imageIndex = paramInt1;
/*  65 */     this.mipmapLevel = paramInt2;
/*     */     
/*  67 */     this.basisuData = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasisuTextureData(BasisuData paramBasisuData) {
/*  74 */     this(paramBasisuData, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasisuTextureData(BasisuData paramBasisuData, int paramInt) {
/*  82 */     this(paramBasisuData, paramInt, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasisuTextureData(BasisuData paramBasisuData, int paramInt1, int paramInt2) {
/*  92 */     this.file = null;
/*  93 */     this.imageIndex = paramInt1;
/*  94 */     this.mipmapLevel = paramInt2;
/*     */     
/*  96 */     this.basisuData = paramBasisuData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasisuTextureFormatSelector getTextureFormatSelector() {
/* 103 */     return this.formatSelector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextureFormatSelector(BasisuTextureFormatSelector paramBasisuTextureFormatSelector) {
/* 110 */     this.formatSelector = paramBasisuTextureFormatSelector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextureFormatSelector(BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat) {
/* 119 */     this.formatSelector = new BasisuTextureFormatSelector.Fixed(paramBasisuTranscoderTextureFormat);
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureData.TextureDataType getType() {
/* 124 */     return TextureData.TextureDataType.Custom;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrepared() {
/* 129 */     return this.isPrepared;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/* 134 */     if (this.isPrepared) throw new GdxRuntimeException("Already prepared"); 
/* 135 */     if (this.file == null && this.basisuData == null) throw new GdxRuntimeException("Can only load once from BasisuData"); 
/* 136 */     if (this.file != null) {
/* 137 */       this.basisuData = new BasisuData(this.file);
/*     */     }
/*     */     
/*     */     BasisuFileInfo basisuFileInfo;
/*     */     
/* 142 */     int i = (basisuFileInfo = this.basisuData.getFileInfo()).getTotalImages();
/* 143 */     if (this.imageIndex < 0 || this.imageIndex >= i) {
/* 144 */       throw new BasisuGdxException("imageIndex " + this.imageIndex + " exceeds the total number of images (" + i + ") in the basis file.");
/*     */     }
/*     */ 
/*     */     
/* 148 */     i = basisuFileInfo.getImageMipmapLevels()[this.imageIndex];
/* 149 */     if (this.mipmapLevel < 0 || this.mipmapLevel >= i) {
/* 150 */       throw new BasisuGdxException("mipmapLevel " + this.mipmapLevel + " exceeds the total number of mipmap levels (" + i + ") in the basis file.");
/*     */     }
/*     */     
/*     */     BasisuTextureType basisuTextureType;
/*     */     
/* 155 */     if ((basisuTextureType = basisuFileInfo.getTextureType()) != BasisuTextureType.REGULAR_2D) {
/* 156 */       throw new BasisuGdxException("textureType " + basisuTextureType + " is not supported at the moment. Only BasisuTextureType.REGULAR_2D texture type is allowed.");
/*     */     }
/*     */ 
/*     */     
/* 160 */     BasisuImageInfo basisuImageInfo = this.basisuData.getImageInfo(this.imageIndex);
/* 161 */     this.width = basisuImageInfo.getWidth();
/* 162 */     this.height = basisuImageInfo.getHeight();
/*     */     
/* 164 */     this.transcodeFormat = this.formatSelector.resolveTextureFormat(this.basisuData, this.imageIndex);
/* 165 */     Gdx.app.debug(TAG, ((this.file != null) ? ("[" + this.file.path() + "] ") : "") + "Transcoding to the " + this.transcodeFormat + " format");
/*     */     
/* 167 */     this.transcodedData = this.basisuData.transcode(this.imageIndex, this.mipmapLevel, this.transcodeFormat);
/*     */     
/* 169 */     Gdx.app.debug(TAG, ((this.file != null) ? ("[" + this.file.path() + "] ") : "") + "Transcoded texture size: " + MathUtils.round(this.transcodedData.capacity() / 1024.0F) + "kB");
/*     */     
/* 171 */     this.basisuData.dispose();
/* 172 */     this.basisuData = null;
/* 173 */     this.isPrepared = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void consumeCustomData(int paramInt) {
/* 178 */     if (!this.isPrepared) throw new GdxRuntimeException("Call prepare() before calling consumeCompressedData()");
/*     */     
/* 180 */     int i = BasisuGdxUtils.toGlTextureFormat(this.transcodeFormat);
/*     */     
/* 182 */     if (this.transcodeFormat.isCompressedFormat()) {
/* 183 */       BasisuGdxGl.glCompressedTexImage2D(paramInt, 0, i, this.width, this.height, 0, this.transcodedData
/*     */           
/* 185 */           .capacity(), this.transcodedData);
/*     */     } else {
/* 187 */       int j = BasisuGdxUtils.toUncompressedGlTextureType(this.transcodeFormat);
/* 188 */       Gdx.gl.glTexImage2D(paramInt, 0, i, this.width, this.height, 0, i, j, this.transcodedData);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     BasisuWrapper.disposeNativeBuffer(this.transcodedData);
/* 195 */     this.transcodedData = null;
/* 196 */     this.transcodeFormat = null;
/*     */     
/* 198 */     this.isPrepared = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap consumePixmap() {
/* 203 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap.");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean disposePixmap() {
/* 208 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap.");
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 213 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 218 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap.Format getFormat() {
/* 223 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useMipMaps() {
/* 228 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/* 233 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\BasisuTextureData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */