/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
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
/*     */ public class SOFTReopenDevice
/*     */ {
/*     */   protected SOFTReopenDevice() {
/*  31 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean nalcReopenDeviceSOFT(long paramLong1, long paramLong2, long paramLong3) {
/*  38 */     long l = (ALC.getICD()).alcReopenDeviceSOFT;
/*  39 */     if (Checks.CHECKS) {
/*  40 */       Checks.check(l);
/*  41 */       Checks.check(paramLong1);
/*     */     } 
/*  43 */     return JNI.invokePPPZ(paramLong1, paramLong2, paramLong3, l);
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
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcReopenDeviceSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCchar const *") ByteBuffer paramByteBuffer, @NativeType("ALCint const *") IntBuffer paramIntBuffer) {
/*  56 */     if (Checks.CHECKS) {
/*  57 */       Checks.checkNT1Safe(paramByteBuffer);
/*  58 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     } 
/*  60 */     return nalcReopenDeviceSOFT(paramLong, MemoryUtil.memAddressSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcReopenDeviceSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCchar const *") CharSequence paramCharSequence, @NativeType("ALCint const *") IntBuffer paramIntBuffer) {
/*  73 */     if (Checks.CHECKS)
/*  74 */       Checks.checkNTSafe(paramIntBuffer); 
/*     */     MemoryStack memoryStack;
/*  76 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  78 */       memoryStack.nUTF8Safe(paramCharSequence, true);
/*  79 */       long l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress();
/*  80 */       return nalcReopenDeviceSOFT(paramLong, l, MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */     } finally {
/*  82 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcReopenDeviceSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCchar const *") ByteBuffer paramByteBuffer, @NativeType("ALCint const *") int[] paramArrayOfint) {
/*  89 */     long l = (ALC.getICD()).alcReopenDeviceSOFT;
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.check(l);
/*  92 */       Checks.check(paramLong);
/*  93 */       Checks.checkNT1Safe(paramByteBuffer);
/*  94 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/*  96 */     return JNI.invokePPPZ(paramLong, MemoryUtil.memAddressSafe(paramByteBuffer), paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcReopenDeviceSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCchar const *") CharSequence paramCharSequence, @NativeType("ALCint const *") int[] paramArrayOfint) {
/* 102 */     long l = (ALC.getICD()).alcReopenDeviceSOFT;
/* 103 */     if (Checks.CHECKS) {
/* 104 */       Checks.check(l);
/* 105 */       Checks.check(paramLong);
/* 106 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     }  MemoryStack memoryStack;
/* 108 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 110 */       memoryStack.nUTF8Safe(paramCharSequence, true);
/* 111 */       long l1 = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress();
/* 112 */       return JNI.invokePPPZ(paramLong, l1, paramArrayOfint, l);
/*     */     } finally {
/* 114 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTReopenDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */