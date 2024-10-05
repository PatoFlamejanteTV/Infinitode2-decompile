/*     */ package com.crashinvaders.basisu.gdx;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTextureFormat;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTranscoderTextureFormat;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuWrapper;
/*     */ import com.crashinvaders.basisu.wrapper.Ktx2FileInfo;
/*     */ import com.crashinvaders.basisu.wrapper.Ktx2ImageLevelInfo;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Ktx2Data
/*     */   implements Disposable
/*     */ {
/*     */   private final ByteBuffer encodedData;
/*     */   private final Ktx2FileInfo fileInfo;
/*  24 */   private final IntMap<IntMap<Ktx2ImageLevelInfo>> imageInfoIndex = new IntMap();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ktx2Data(FileHandle paramFileHandle) {
/*  30 */     this(BasisuGdxUtils.readFileIntoBuffer(paramFileHandle));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ktx2Data(ByteBuffer paramByteBuffer) {
/*  37 */     BasisuNativeLibLoader.loadIfNeeded();
/*     */     
/*  39 */     this.encodedData = paramByteBuffer;
/*     */ 
/*     */ 
/*     */     
/*  43 */     this.fileInfo = BasisuWrapper.ktx2GetFileInfo(paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*  48 */     for (Iterator<IntMap> iterator = this.imageInfoIndex.values().iterator(); iterator.hasNext();) {
/*  49 */       for (Iterator<Ktx2ImageLevelInfo> iterator1 = (intMap = iterator.next()).values().iterator(); iterator1.hasNext();) {
/*  50 */         (ktx2ImageLevelInfo = iterator1.next()).close();
/*     */       }
/*     */     } 
/*  53 */     this.imageInfoIndex.clear();
/*     */     
/*  55 */     this.fileInfo.close();
/*     */ 
/*     */     
/*  58 */     if (BasisuBufferUtils.isUnsafeByteBuffer(this.encodedData)) {
/*  59 */       BasisuBufferUtils.disposeUnsafeByteBuffer(this.encodedData);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getTotalLayers() {
/*  64 */     return this.fileInfo.getTotalLayers();
/*     */   }
/*     */   
/*     */   public int getTotalMipmapLevels() {
/*  68 */     return this.fileInfo.getTotalMipmapLevels();
/*     */   }
/*     */   
/*     */   public int getImageWidth() {
/*  72 */     return this.fileInfo.getImageWidth();
/*     */   }
/*     */   
/*     */   public int getImageHeight() {
/*  76 */     return this.fileInfo.getImageHeight();
/*     */   }
/*     */   
/*     */   public boolean hasAlpha() {
/*  80 */     return this.fileInfo.hasAlpha();
/*     */   }
/*     */   
/*     */   public BasisuTextureFormat getTextureFormat() {
/*  84 */     return this.fileInfo.getTextureFormat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuffer getEncodedData() {
/*  91 */     return this.encodedData;
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
/*     */   public Ktx2ImageLevelInfo getImageLevelInfo(int paramInt1, int paramInt2) {
/*     */     IntMap intMap;
/* 104 */     if ((intMap = (IntMap)this.imageInfoIndex.get(paramInt1)) == null) {
/* 105 */       intMap = new IntMap();
/* 106 */       this.imageInfoIndex.put(paramInt1, intMap);
/*     */     } 
/*     */     Ktx2ImageLevelInfo ktx2ImageLevelInfo;
/* 109 */     if ((ktx2ImageLevelInfo = (Ktx2ImageLevelInfo)intMap.get(paramInt1)) == null) {
/* 110 */       ktx2ImageLevelInfo = BasisuWrapper.ktx2GetImageLevelInfo(this.encodedData, paramInt1, paramInt2);
/* 111 */       intMap.put(paramInt1, ktx2ImageLevelInfo);
/*     */     } 
/* 113 */     return ktx2ImageLevelInfo;
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
/*     */   public ByteBuffer transcode(int paramInt1, int paramInt2, BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat) {
/* 127 */     return BasisuWrapper.ktx2Transcode(this.encodedData, paramInt1, paramInt2, paramBasisuTranscoderTextureFormat);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\Ktx2Data.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */