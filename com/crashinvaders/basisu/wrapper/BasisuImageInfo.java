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
/*     */ public class BasisuImageInfo
/*     */   implements Closeable
/*     */ {
/*     */   long addr;
/*     */   
/*     */   BasisuImageInfo() {
/*  23 */     this.addr = jniCreate();
/*     */   }
/*     */   
/*     */   BasisuImageInfo(Object paramObject) {
/*  27 */     throw new UnsupportedOperationException("This constructor exists solely for GWT compilation compatibility.");
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/*  32 */     if (this.addr == 0L) {
/*  33 */       throw new IllegalStateException("Object was already closed!");
/*     */     }
/*  35 */     jniDispose(this.addr);
/*  36 */     this.addr = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private native int jniGetImageIndex(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getImageIndex() {
/*  48 */     return jniGetImageIndex(this.addr);
/*     */   }
/*     */   private native int jniGetTotalLevels(long paramLong);
/*     */   
/*     */   public int getTotalLevels() {
/*  53 */     return jniGetTotalLevels(this.addr);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOrigWidth() {
/*  58 */     return jniGetOrigWidth(this.addr);
/*     */   }
/*     */   private native int jniGetOrigWidth(long paramLong);
/*     */   
/*     */   public int getOrigHeight() {
/*  63 */     return jniGetOrigHeight(this.addr);
/*     */   }
/*     */   private native int jniGetOrigHeight(long paramLong);
/*     */   
/*     */   public int getWidth() {
/*  68 */     return jniGetWidth(this.addr);
/*     */   }
/*     */   private native int jniGetWidth(long paramLong);
/*     */   
/*     */   public int getHeight() {
/*  73 */     return jniGetHeight(this.addr);
/*     */   }
/*     */   private native int jniGetHeight(long paramLong);
/*     */   
/*     */   public int getNumBlocksX() {
/*  78 */     return jniGetNumBlocksX(this.addr);
/*     */   }
/*     */   private native int jniGetNumBlocksX(long paramLong);
/*     */   
/*     */   public int getNumBlocksY() {
/*  83 */     return jniGetNumBlocksY(this.addr);
/*     */   }
/*     */   private native int jniGetNumBlocksY(long paramLong);
/*     */   
/*     */   public int getTotalBlocks() {
/*  88 */     return jniGetTotalBlocks(this.addr);
/*     */   }
/*     */   private native int jniGetTotalBlocks(long paramLong);
/*     */   
/*     */   public int getFirstSliceIndex() {
/*  93 */     return jniGetFirstSliceIndex(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetFirstSliceIndex(long paramLong);
/*     */   
/*     */   public boolean hasAlphaFlag() {
/*  99 */     return jniHasAlphaFlag(this.addr);
/*     */   }
/*     */   
/*     */   private native boolean jniHasAlphaFlag(long paramLong);
/*     */   
/*     */   public boolean hasIframeFlag() {
/* 105 */     return jniHasIframeFlag(this.addr);
/*     */   }
/*     */   
/*     */   private native boolean jniHasIframeFlag(long paramLong);
/*     */   
/*     */   private static native long jniCreate();
/*     */   
/*     */   private static native void jniDispose(long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\wrapper\BasisuImageInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */