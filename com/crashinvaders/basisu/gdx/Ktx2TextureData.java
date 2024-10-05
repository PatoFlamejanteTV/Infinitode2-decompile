/*     */ package com.crashinvaders.basisu.gdx;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Pixmap;
/*     */ import com.badlogic.gdx.graphics.TextureData;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTranscoderTextureFormat;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuWrapper;
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
/*     */ public class Ktx2TextureData
/*     */   implements TextureData
/*     */ {
/*  25 */   private static final String TAG = Ktx2TextureData.class.getSimpleName();
/*     */   
/*  27 */   private BasisuTextureFormatSelector formatSelector = BasisuGdxUtils.defaultFormatSelector;
/*     */   
/*     */   private final FileHandle file;
/*     */   
/*     */   private final int mipmapLevel;
/*     */   
/*     */   private Ktx2Data ktx2Data;
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
/*     */   public Ktx2TextureData(FileHandle paramFileHandle) {
/*  45 */     this(paramFileHandle, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ktx2TextureData(FileHandle paramFileHandle, int paramInt) {
/*  54 */     this.file = paramFileHandle;
/*  55 */     this.mipmapLevel = paramInt;
/*     */     
/*  57 */     this.ktx2Data = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ktx2TextureData(Ktx2Data paramKtx2Data) {
/*  64 */     this(paramKtx2Data, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ktx2TextureData(Ktx2Data paramKtx2Data, int paramInt) {
/*  73 */     this.file = null;
/*  74 */     this.mipmapLevel = paramInt;
/*     */     
/*  76 */     this.ktx2Data = paramKtx2Data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasisuTextureFormatSelector getTextureFormatSelector() {
/*  83 */     return this.formatSelector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextureFormatSelector(BasisuTextureFormatSelector paramBasisuTextureFormatSelector) {
/*  90 */     this.formatSelector = paramBasisuTextureFormatSelector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextureFormatSelector(BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat) {
/*  99 */     this.formatSelector = new BasisuTextureFormatSelector.Fixed(paramBasisuTranscoderTextureFormat);
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureData.TextureDataType getType() {
/* 104 */     return TextureData.TextureDataType.Custom;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrepared() {
/* 109 */     return this.isPrepared;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/* 114 */     if (this.isPrepared) throw new GdxRuntimeException("Already prepared"); 
/* 115 */     if (this.file == null && this.ktx2Data == null) throw new GdxRuntimeException("Can only load once from ktx2Data"); 
/* 116 */     if (this.file != null) {
/* 117 */       this.ktx2Data = new Ktx2Data(this.file);
/*     */     }
/*     */     
/* 120 */     int i = this.ktx2Data.getTotalMipmapLevels();
/* 121 */     if (this.mipmapLevel < 0 || this.mipmapLevel >= i) {
/* 122 */       throw new BasisuGdxException("mipmapLevel " + this.mipmapLevel + " exceeds the total number of mipmap levels (" + i + ") in the basis file.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     this.width = this.ktx2Data.getImageWidth();
/* 134 */     this.height = this.ktx2Data.getImageHeight();
/*     */     
/* 136 */     this.transcodeFormat = this.formatSelector.resolveTextureFormat(this.ktx2Data);
/* 137 */     Gdx.app.debug(TAG, ((this.file != null) ? ("[" + this.file.path() + "] ") : "") + "Transcoding to the " + this.transcodeFormat + " format");
/*     */ 
/*     */     
/* 140 */     this.transcodedData = this.ktx2Data.transcode(0, this.mipmapLevel, this.transcodeFormat);
/*     */     
/* 142 */     Gdx.app.debug(TAG, ((this.file != null) ? ("[" + this.file.path() + "] ") : "") + "Transcoded texture size: " + MathUtils.round(this.transcodedData.capacity() / 1024.0F) + "kB");
/*     */     
/* 144 */     this.ktx2Data.dispose();
/* 145 */     this.ktx2Data = null;
/* 146 */     this.isPrepared = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void consumeCustomData(int paramInt) {
/* 151 */     if (!this.isPrepared) throw new GdxRuntimeException("Call prepare() before calling consumeCompressedData()");
/*     */     
/* 153 */     int i = BasisuGdxUtils.toGlTextureFormat(this.transcodeFormat);
/*     */     
/* 155 */     if (this.transcodeFormat.isCompressedFormat()) {
/* 156 */       BasisuGdxGl.glCompressedTexImage2D(paramInt, 0, i, this.width, this.height, 0, this.transcodedData
/*     */           
/* 158 */           .capacity(), this.transcodedData);
/*     */     } else {
/* 160 */       int j = BasisuGdxUtils.toUncompressedGlTextureType(this.transcodeFormat);
/* 161 */       Gdx.gl.glTexImage2D(paramInt, 0, i, this.width, this.height, 0, i, j, this.transcodedData);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     BasisuWrapper.disposeNativeBuffer(this.transcodedData);
/* 168 */     this.transcodedData = null;
/* 169 */     this.transcodeFormat = null;
/*     */     
/* 171 */     this.isPrepared = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap consumePixmap() {
/* 176 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap.");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean disposePixmap() {
/* 181 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap.");
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 186 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 191 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pixmap.Format getFormat() {
/* 196 */     throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean useMipMaps() {
/* 201 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isManaged() {
/* 206 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\Ktx2TextureData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */