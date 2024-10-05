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
/*     */ public class LibCLocale
/*     */ {
/*     */   static {
/*  21 */     Library.initialize();
/*     */   }
/*     */   protected LibCLocale() {
/*  24 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  32 */   public static final int LC_ALL = LC_ALL();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   public static final int LC_COLLATE = LC_COLLATE();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   public static final int LC_CTYPE = LC_CTYPE();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   public static final int LC_MONETARY = LC_MONETARY();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   public static final int LC_NUMERIC = LC_NUMERIC();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   public static final int LC_TIME = LC_TIME();
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
/*     */   @NativeType("char *")
/*     */   public static String setlocale(int paramInt, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/*  92 */     if (Checks.CHECKS) {
/*  93 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/*     */     long l;
/*  96 */     return MemoryUtil.memASCIISafe(l = nsetlocale(paramInt, MemoryUtil.memAddress(paramByteBuffer)));
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
/*     */   @NativeType("char *")
/*     */   public static String setlocale(int paramInt, @NativeType("char const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 117 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 119 */       memoryStack.nASCII(paramCharSequence, true);
/* 120 */       long l1 = memoryStack.getPointerAddress();
/*     */       long l2;
/* 122 */       return MemoryUtil.memASCIISafe(l2 = nsetlocale(paramInt, l1));
/*     */     } finally {
/* 124 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static native int LC_ALL();
/*     */   
/*     */   private static native int LC_COLLATE();
/*     */   
/*     */   private static native int LC_CTYPE();
/*     */   
/*     */   private static native int LC_MONETARY();
/*     */   
/*     */   private static native int LC_NUMERIC();
/*     */   
/*     */   private static native int LC_TIME();
/*     */   
/*     */   public static native long nsetlocale(int paramInt, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\libc\LibCLocale.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */