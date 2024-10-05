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
/*     */ public class Ktx2ImageLevelInfo
/*     */   implements Closeable
/*     */ {
/*     */   long addr;
/*     */   
/*     */   Ktx2ImageLevelInfo() {
/*  23 */     this.addr = jniCreate();
/*     */   }
/*     */   
/*     */   Ktx2ImageLevelInfo(Object paramObject) {
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLevelIndex() {
/*  49 */     return jniGetLevelIndex(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetLevelIndex(long paramLong);
/*     */   
/*     */   public int getLayerIndex() {
/*  55 */     return jniGetLayerIndex(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetLayerIndex(long paramLong);
/*     */   
/*     */   public int getFaceIndex() {
/*  61 */     return jniGetFaceIndex(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetFaceIndex(long paramLong);
/*     */   
/*     */   public int getOrigWidth() {
/*  67 */     return jniGetOrigWidth(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetOrigWidth(long paramLong);
/*     */   
/*     */   public int getOrigHeight() {
/*  73 */     return jniGetOrigHeight(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetOrigHeight(long paramLong);
/*     */   
/*     */   public int getWidth() {
/*  79 */     return jniGetWidth(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetWidth(long paramLong);
/*     */   
/*     */   public int getHeight() {
/*  85 */     return jniGetHeight(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetHeight(long paramLong);
/*     */   
/*     */   public int getNumBlocksX() {
/*  91 */     return jniGetNumBlocksX(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetNumBlocksX(long paramLong);
/*     */   
/*     */   public int getNumBlocksY() {
/*  97 */     return jniGetNumBlocksY(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetNumBlocksY(long paramLong);
/*     */   
/*     */   public int getTotalBlocks() {
/* 103 */     return jniGetTotalBlocks(this.addr);
/*     */   }
/*     */   
/*     */   private native int jniGetTotalBlocks(long paramLong);
/*     */   
/*     */   public boolean getAlphaFlag() {
/* 109 */     return jniGetAlphaFlag(this.addr);
/*     */   }
/*     */ 
/*     */   
/*     */   private native boolean jniGetAlphaFlag(long paramLong);
/*     */ 
/*     */   
/*     */   public boolean getIframeFlag() {
/* 117 */     return jniGetIframeFlag(this.addr);
/*     */   }
/*     */   
/*     */   private native boolean jniGetIframeFlag(long paramLong);
/*     */   
/*     */   private static native long jniCreate();
/*     */   
/*     */   private static native void jniDispose(long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\wrapper\Ktx2ImageLevelInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */