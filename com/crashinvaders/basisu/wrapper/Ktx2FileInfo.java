/*    */ package com.crashinvaders.basisu.wrapper;
/*    */ 
/*    */ import java.io.Closeable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Ktx2FileInfo
/*    */   implements Closeable
/*    */ {
/*    */   long addr;
/*    */   
/*    */   Ktx2FileInfo() {
/* 27 */     this.addr = jniCreate();
/*    */   }
/*    */   
/*    */   Ktx2FileInfo(Object paramObject) {
/* 31 */     throw new UnsupportedOperationException("This constructor exists solely for GWT compilation compatibility.");
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/* 36 */     if (this.addr == 0L) {
/* 37 */       throw new IllegalStateException("Object was already closed!");
/*    */     }
/* 39 */     jniDispose(this.addr);
/* 40 */     this.addr = 0L;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getTotalLayers() {
/* 53 */     return getTotalLayersNative(this.addr);
/*    */   }
/*    */ 
/*    */   
/*    */   private native int getTotalLayersNative(long paramLong);
/*    */   
/*    */   public int getTotalMipmapLevels() {
/* 60 */     return getTotalMipmapLevelsNative(this.addr);
/*    */   }
/*    */ 
/*    */   
/*    */   private native int getTotalMipmapLevelsNative(long paramLong);
/*    */   
/*    */   public int getImageWidth() {
/* 67 */     return getImageWidthNative(this.addr);
/*    */   }
/*    */ 
/*    */   
/*    */   private native int getImageWidthNative(long paramLong);
/*    */   
/*    */   public int getImageHeight() {
/* 74 */     return getImageHeightNative(this.addr);
/*    */   }
/*    */ 
/*    */   
/*    */   private native int getImageHeightNative(long paramLong);
/*    */   
/*    */   public boolean hasAlpha() {
/* 81 */     return hasAlphaNative(this.addr);
/*    */   }
/*    */ 
/*    */   
/*    */   private native boolean hasAlphaNative(long paramLong);
/*    */   
/*    */   public BasisuTextureFormat getTextureFormat() {
/* 88 */     int i = getTextureFormatNative(this.addr);
/* 89 */     return UniqueIdUtils.<BasisuTextureFormat>findOrThrow(BasisuTextureFormat.values(), i);
/*    */   }
/*    */   
/*    */   private native int getTextureFormatNative(long paramLong);
/*    */   
/*    */   private static native long jniCreate();
/*    */   
/*    */   private static native void jniDispose(long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\wrapper\Ktx2FileInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */