/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
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
/*     */ 
/*     */ public class SOFTCallbackBuffer
/*     */ {
/*     */   public static final int AL_BUFFER_CALLBACK_FUNCTION_SOFT = 6560;
/*     */   public static final int AL_BUFFER_CALLBACK_USER_PARAM_SOFT = 6561;
/*     */   
/*     */   protected SOFTCallbackBuffer() {
/*  35 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferCallbackSOFT(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {
/*  42 */     long l = (AL.getICD()).alBufferCallbackSOFT;
/*  43 */     if (Checks.CHECKS) {
/*  44 */       Checks.check(l);
/*  45 */       Checks.check(paramLong2);
/*     */     } 
/*  47 */     JNI.invokePPV(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, l);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferCallbackSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALsizei") int paramInt3, @NativeType("ALBUFFERCALLBACKTYPESOFT") SOFTCallbackBufferTypeI paramSOFTCallbackBufferTypeI, @NativeType("ALvoid *") long paramLong) {
/*  67 */     nalBufferCallbackSOFT(paramInt1, paramInt2, paramInt3, paramSOFTCallbackBufferTypeI.address(), paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferPtrSOFT(int paramInt1, int paramInt2, long paramLong) {
/*  73 */     long l = (AL.getICD()).alGetBufferPtrSOFT;
/*  74 */     if (Checks.CHECKS) {
/*  75 */       Checks.check(l);
/*     */     }
/*  77 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*     */   }
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferPtrSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid **") PointerBuffer paramPointerBuffer) {
/*  82 */     if (Checks.CHECKS) {
/*  83 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     }
/*  85 */     nalGetBufferPtrSOFT(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */   @NativeType("ALvoid")
/*     */   public static long alGetBufferPtrSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/*  90 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  92 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/*  93 */       nalGetBufferPtrSOFT(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/*  94 */       return pointerBuffer.get(0);
/*     */     } finally {
/*  96 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBuffer3PtrSOFT(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {
/* 103 */     long l = (AL.getICD()).alGetBuffer3PtrSOFT;
/* 104 */     if (Checks.CHECKS) {
/* 105 */       Checks.check(l);
/*     */     }
/* 107 */     JNI.invokePPPV(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3PtrSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid **") PointerBuffer paramPointerBuffer1, @NativeType("ALvoid **") PointerBuffer paramPointerBuffer2, @NativeType("ALvoid **") PointerBuffer paramPointerBuffer3) {
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.check((CustomBuffer)paramPointerBuffer1, 1);
/* 114 */       Checks.check((CustomBuffer)paramPointerBuffer2, 1);
/* 115 */       Checks.check((CustomBuffer)paramPointerBuffer3, 1);
/*     */     } 
/* 117 */     nalGetBuffer3PtrSOFT(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer1), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer2), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer3));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferPtrvSOFT(int paramInt1, int paramInt2, long paramLong) {
/* 123 */     long l = (AL.getICD()).alGetBufferPtrvSOFT;
/* 124 */     if (Checks.CHECKS) {
/* 125 */       Checks.check(l);
/*     */     }
/* 127 */     JNI.invokePV(paramInt1, paramInt2, paramLong, l);
/*     */   }
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferPtrvSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid **") PointerBuffer paramPointerBuffer) {
/* 132 */     if (Checks.CHECKS) {
/* 133 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     }
/* 135 */     nalGetBufferPtrvSOFT(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTCallbackBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */