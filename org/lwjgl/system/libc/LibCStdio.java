/*     */ package org.lwjgl.system.libc;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Library;
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
/*     */ public class LibCStdio
/*     */ {
/*     */   static {
/*  21 */     Library.initialize();
/*     */   }
/*     */   protected LibCStdio() {
/*  24 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   public static final long sscanf = sscanf();
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
/*     */   public static int vsscanf(@NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2, @NativeType("va_list") long paramLong) {
/*  51 */     if (Checks.CHECKS) {
/*  52 */       Checks.checkNT1(paramByteBuffer1);
/*  53 */       Checks.checkNT1(paramByteBuffer2);
/*  54 */       Checks.check(paramLong);
/*     */     } 
/*  56 */     return nvsscanf(MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), paramLong);
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
/*     */   public static int vsscanf(@NativeType("char const *") CharSequence paramCharSequence1, @NativeType("char const *") CharSequence paramCharSequence2, @NativeType("va_list") long paramLong) {
/*  70 */     if (Checks.CHECKS)
/*  71 */       Checks.check(paramLong); 
/*     */     MemoryStack memoryStack;
/*  73 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  75 */       memoryStack.nASCII(paramCharSequence1, true);
/*  76 */       long l1 = memoryStack.getPointerAddress();
/*  77 */       memoryStack.nASCII(paramCharSequence2, true);
/*  78 */       long l2 = memoryStack.getPointerAddress();
/*  79 */       return nvsscanf(l1, l2, paramLong);
/*     */     } finally {
/*  81 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public static final long snprintf = snprintf();
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
/*     */   public static int vsnprintf(@NativeType("char *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2, @NativeType("va_list") long paramLong) {
/* 115 */     if (Checks.CHECKS) {
/* 116 */       Checks.checkNT1(paramByteBuffer2);
/* 117 */       Checks.check(paramLong);
/*     */     } 
/* 119 */     return nvsnprintf(MemoryUtil.memAddressSafe(paramByteBuffer1), Checks.remainingSafe(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), paramLong);
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
/*     */   public static int vsnprintf(@NativeType("char *") ByteBuffer paramByteBuffer, @NativeType("char const *") CharSequence paramCharSequence, @NativeType("va_list") long paramLong) {
/* 135 */     if (Checks.CHECKS)
/* 136 */       Checks.check(paramLong); 
/*     */     MemoryStack memoryStack;
/* 138 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 140 */       memoryStack.nASCII(paramCharSequence, true);
/* 141 */       long l = memoryStack.getPointerAddress();
/* 142 */       return nvsnprintf(MemoryUtil.memAddressSafe(paramByteBuffer), Checks.remainingSafe(paramByteBuffer), l, paramLong);
/*     */     } finally {
/* 144 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   @NativeType("void *")
/*     */   private static native long sscanf();
/*     */   
/*     */   public static native int nvsscanf(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   @NativeType("void *")
/*     */   private static native long snprintf();
/*     */   
/*     */   public static native int nvsnprintf(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\libc\LibCStdio.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */