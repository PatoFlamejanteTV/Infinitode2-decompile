/*     */ package com.crashinvaders.basisu.gdx;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuFileInfo;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuImageInfo;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuTranscoderTextureFormat;
/*     */ import com.crashinvaders.basisu.wrapper.BasisuWrapper;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasisuData
/*     */   implements Disposable
/*     */ {
/*     */   private final ByteBuffer encodedData;
/*     */   private final BasisuFileInfo fileInfo;
/*  26 */   private IntMap<BasisuImageInfo> imageInfoIndex = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasisuData(FileHandle paramFileHandle) {
/*  32 */     this(BasisuGdxUtils.readFileIntoBuffer(paramFileHandle));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasisuData(ByteBuffer paramByteBuffer) {
/*  39 */     BasisuNativeLibLoader.loadIfNeeded();
/*     */     
/*  41 */     this.encodedData = paramByteBuffer;
/*     */     
/*  43 */     if (!BasisuWrapper.basisValidateHeader(paramByteBuffer)) {
/*  44 */       throw new BasisuGdxException("Cannot validate header of the basis universal data.");
/*     */     }
/*     */     
/*  47 */     this.fileInfo = BasisuWrapper.basisGetFileInfo(paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*  52 */     this.fileInfo.close();
/*     */     
/*  54 */     if (this.imageInfoIndex != null) {
/*  55 */       for (Iterator<BasisuImageInfo> iterator = this.imageInfoIndex.values().iterator(); iterator.hasNext();) {
/*  56 */         (basisuImageInfo = iterator.next()).close();
/*     */       }
/*  58 */       this.imageInfoIndex.clear();
/*     */     } 
/*     */ 
/*     */     
/*  62 */     if (BasisuBufferUtils.isUnsafeByteBuffer(this.encodedData)) {
/*  63 */       BasisuBufferUtils.disposeUnsafeByteBuffer(this.encodedData);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuffer getEncodedData() {
/*  71 */     return this.encodedData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasisuFileInfo getFileInfo() {
/*  79 */     return this.fileInfo;
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
/*     */   public BasisuImageInfo getImageInfo(int paramInt) {
/*  92 */     if (this.imageInfoIndex == null) {
/*  93 */       this.imageInfoIndex = new IntMap();
/*     */     }
/*     */     BasisuImageInfo basisuImageInfo;
/*  96 */     if ((basisuImageInfo = (BasisuImageInfo)this.imageInfoIndex.get(paramInt)) == null) {
/*  97 */       basisuImageInfo = BasisuWrapper.basisGetImageInfo(this.encodedData, paramInt);
/*  98 */       this.imageInfoIndex.put(paramInt, basisuImageInfo);
/*     */     } 
/* 100 */     return basisuImageInfo;
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
/* 114 */     return BasisuWrapper.basisTranscode(this.encodedData, paramInt1, paramInt2, paramBasisuTranscoderTextureFormat);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\BasisuData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */