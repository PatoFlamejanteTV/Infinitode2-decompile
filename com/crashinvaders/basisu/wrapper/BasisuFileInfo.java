/*     */ package com.crashinvaders.basisu.wrapper;
/*     */ 
/*     */ import java.io.Closeable;
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
/*     */ 
/*     */ 
/*     */ public class BasisuFileInfo
/*     */   implements Closeable
/*     */ {
/*  36 */   long addr = 0L;
/*     */   
/*     */   BasisuFileInfo() {
/*  39 */     this.addr = jniCreate();
/*     */   }
/*     */   
/*     */   BasisuFileInfo(Object paramObject) {
/*  43 */     throw new UnsupportedOperationException("This constructor exists solely for GWT compilation compatibility.");
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/*  48 */     if (this.addr == 0L) {
/*  49 */       throw new IllegalStateException("Object was already closed!");
/*     */     }
/*  51 */     jniDispose(this.addr);
/*  52 */     this.addr = 0L;
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
/*     */   public BasisuTextureType getTextureType() {
/*  65 */     int i = jniGetTextureType(this.addr);
/*  66 */     return UniqueIdUtils.<BasisuTextureType>findOrThrow(BasisuTextureType.values(), i);
/*     */   }
/*     */ 
/*     */   
/*     */   private native int jniGetTextureType(long paramLong);
/*     */   
/*     */   public BasisuTextureFormat getTextureFormat() {
/*  73 */     int i = jniGetTextureFormat(this.addr);
/*  74 */     return UniqueIdUtils.<BasisuTextureFormat>findOrThrow(BasisuTextureFormat.values(), i);
/*     */   }
/*     */   private native int jniGetTextureFormat(long paramLong);
/*     */   private native int jniGetVersion(long paramLong);
/*     */   
/*     */   public int getVersion() {
/*  80 */     return jniGetVersion(this.addr);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTotalHeaderSize() {
/*  85 */     return jniGetTotalHeaderSize(this.addr);
/*     */   }
/*     */   private native int jniGetTotalHeaderSize(long paramLong);
/*     */   
/*     */   public int getTotalSelectors() {
/*  90 */     return jniGetTotalSelectors(this.addr);
/*     */   }
/*     */   private native int jniGetTotalSelectors(long paramLong);
/*     */   
/*     */   public int getSelectorCodebookSize() {
/*  95 */     return jniGetSelectorCodebookSize(this.addr);
/*     */   }
/*     */   private native int jniGetSelectorCodebookSize(long paramLong);
/*     */   
/*     */   public int getTotalEndpoints() {
/* 100 */     return jniGetTotalEndpoints(this.addr);
/*     */   }
/*     */   private native int jniGetTotalEndpoints(long paramLong);
/*     */   
/*     */   public int getEndpointCodebookSize() {
/* 105 */     return jniGetEndpointCodebookSize(this.addr);
/*     */   }
/*     */   private native int jniGetEndpointCodebookSize(long paramLong);
/*     */   
/*     */   public int getTablesSize() {
/* 110 */     return jniGetTablesSize(this.addr);
/*     */   }
/*     */   private native int jniGetTablesSize(long paramLong);
/*     */   
/*     */   public int getSlicesSize() {
/* 115 */     return jniGetSlicesSize(this.addr);
/*     */   }
/*     */   private native int jniGetSlicesSize(long paramLong);
/*     */   
/*     */   public int getUsPerFrame() {
/* 120 */     return jniGetUsPerFrame(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetUsPerFrame(long paramLong);
/*     */   
/*     */   public int getTotalImages() {
/* 126 */     return jniGetTotalImages(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetTotalImages(long paramLong);
/*     */   
/*     */   public int[] getImageMipmapLevels() {
/* 132 */     return jniGetImageMipmapLevels(this.addr);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private native int[] jniGetImageMipmapLevels(long paramLong);
/*     */ 
/*     */   
/*     */   public int getUserdata0() {
/* 141 */     return jniGetUserdata0(this.addr);
/*     */   }
/*     */   private native int jniGetUserdata0(long paramLong);
/*     */   
/*     */   public int getUserdata1() {
/* 146 */     return jniGetUserdata1(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetUserdata1(long paramLong);
/*     */   
/*     */   public boolean isFlippedY() {
/* 152 */     return jniIsFlippedY(this.addr);
/*     */   }
/*     */   
/*     */   private native boolean jniIsFlippedY(long paramLong);
/*     */   
/*     */   public boolean isEtc1s() {
/* 158 */     return jniIsEtc1s(this.addr);
/*     */   }
/*     */   
/*     */   private native boolean jniIsEtc1s(long paramLong);
/*     */   
/*     */   public boolean hasAlphaSlices() {
/* 164 */     return jniHasAlphaSlices(this.addr);
/*     */   }
/*     */   
/*     */   private native boolean jniHasAlphaSlices(long paramLong);
/*     */   
/*     */   private static native long jniCreate();
/*     */   
/*     */   private static native void jniDispose(long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\wrapper\BasisuFileInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */