/*     */ package com.crashinvaders.basisu.wrapper;
/*     */ 
/*     */ import java.nio.Buffer;
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
/*     */ public class BasisuWrapper
/*     */ {
/*     */   public static boolean isTranscoderTexFormatSupported(BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat, BasisuTextureFormat paramBasisuTextureFormat) {
/*  46 */     return isTranscoderTexFormatSupportedNative(paramBasisuTranscoderTextureFormat.getId(), paramBasisuTextureFormat.getId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static native boolean isTranscoderTexFormatSupportedNative(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static native boolean basisValidateHeader(Buffer paramBuffer);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static native boolean basisValidateChecksum(Buffer paramBuffer, boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer basisTranscode(Buffer paramBuffer, int paramInt1, int paramInt2, BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat) {
/*  79 */     int i = paramBasisuTranscoderTextureFormat.getId();
/*  80 */     return basisTranscodeNative(paramBuffer, paramBuffer.capacity(), paramInt1, paramInt2, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static native ByteBuffer basisTranscodeNative(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BasisuFileInfo basisGetFileInfo(Buffer paramBuffer) {
/*  99 */     BasisuFileInfo basisuFileInfo = new BasisuFileInfo();
/* 100 */     basisGetFileInfoNative(paramBuffer, paramBuffer.capacity(), basisuFileInfo.addr);
/* 101 */     return basisuFileInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static native void basisGetFileInfoNative(Buffer paramBuffer, int paramInt, long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BasisuImageInfo basisGetImageInfo(Buffer paramBuffer, int paramInt) {
/* 114 */     BasisuImageInfo basisuImageInfo = new BasisuImageInfo();
/* 115 */     basisGetImageInfoNative(paramBuffer, paramBuffer.capacity(), paramInt, basisuImageInfo.addr);
/* 116 */     return basisuImageInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static native void basisGetImageInfoNative(Buffer paramBuffer, int paramInt1, int paramInt2, long paramLong);
/*     */ 
/*     */ 
/*     */   
/*     */   public static Ktx2FileInfo ktx2GetFileInfo(Buffer paramBuffer) {
/* 127 */     Ktx2FileInfo ktx2FileInfo = new Ktx2FileInfo();
/* 128 */     ktx2GetFileInfoNative(paramBuffer, paramBuffer.capacity(), ktx2FileInfo.addr);
/* 129 */     return ktx2FileInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static native void ktx2GetFileInfoNative(Buffer paramBuffer, int paramInt, long paramLong);
/*     */ 
/*     */ 
/*     */   
/*     */   public static Ktx2ImageLevelInfo ktx2GetImageLevelInfo(Buffer paramBuffer, int paramInt1, int paramInt2) {
/* 140 */     Ktx2ImageLevelInfo ktx2ImageLevelInfo = new Ktx2ImageLevelInfo();
/* 141 */     ktx2GetImageLevelInfoNative(paramBuffer, paramBuffer.capacity(), paramInt1, paramInt2, ktx2ImageLevelInfo.addr);
/* 142 */     return ktx2ImageLevelInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static native void ktx2GetImageLevelInfoNative(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer ktx2Transcode(Buffer paramBuffer, int paramInt1, int paramInt2, BasisuTranscoderTextureFormat paramBasisuTranscoderTextureFormat) {
/* 152 */     int i = paramBasisuTranscoderTextureFormat.getId();
/* 153 */     return ktx2TranscodeNative(paramBuffer, paramBuffer.capacity(), paramInt1, paramInt2, i);
/*     */   }
/*     */   
/*     */   private static native ByteBuffer ktx2TranscodeNative(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   public static native void disposeNativeBuffer(ByteBuffer paramByteBuffer);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\wrapper\BasisuWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */