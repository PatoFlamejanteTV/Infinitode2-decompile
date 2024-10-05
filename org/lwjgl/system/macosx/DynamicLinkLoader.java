/*     */ package org.lwjgl.system.macosx;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class DynamicLinkLoader {
/*     */   public static final int RTLD_LAZY = 1;
/*     */   public static final int RTLD_NOW = 2;
/*     */   public static final int RTLD_LOCAL = 4;
/*     */   public static final int RTLD_GLOBAL = 8;
/*     */   public static final long RTLD_NEXT = -1L;
/*     */   public static final long RTLD_DEFAULT = -2L;
/*     */   public static final long RTLD_SELF = -3L;
/*     */   public static final long RTLD_MAIN_ONLY = -5L;
/*     */   
/*     */   static {
/*  21 */     Library.initialize();
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
/*     */   protected DynamicLinkLoader() {
/*  38 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("void *")
/*     */   public static long dlopen(@NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt) {
/* 106 */     if (Checks.CHECKS) {
/* 107 */       Checks.checkNT1Safe(paramByteBuffer);
/*     */     }
/* 109 */     return ndlopen(MemoryUtil.memAddressSafe(paramByteBuffer), paramInt);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlopen(@NativeType("char const *") CharSequence paramCharSequence, int paramInt) {
/*     */     MemoryStack memoryStack;
/* 172 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 174 */       memoryStack.nUTF8Safe(paramCharSequence, true);
/*     */       long l;
/* 176 */       return ndlopen(l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress(), paramInt);
/*     */     } finally {
/* 178 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   @NativeType("char const *")
/*     */   public static String dlerror() {
/*     */     long l;
/* 200 */     return MemoryUtil.memUTF8Safe(l = ndlerror());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlsym(@NativeType("void *") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 229 */     if (Checks.CHECKS) {
/* 230 */       Checks.check(paramLong);
/* 231 */       Checks.checkNT1(paramByteBuffer);
/*     */     } 
/* 233 */     return ndlsym(paramLong, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long dlsym(@NativeType("void *") long paramLong, @NativeType("char const *") CharSequence paramCharSequence) {
/* 257 */     if (Checks.CHECKS)
/* 258 */       Checks.check(paramLong); 
/*     */     MemoryStack memoryStack;
/* 260 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 262 */       memoryStack.nASCII(paramCharSequence, true);
/* 263 */       long l = memoryStack.getPointerAddress();
/* 264 */       return ndlsym(paramLong, l);
/*     */     } finally {
/* 266 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static int dlclose(@NativeType("void *") long paramLong) {
/* 284 */     if (Checks.CHECKS) {
/* 285 */       Checks.check(paramLong);
/*     */     }
/* 287 */     return ndlclose(paramLong);
/*     */   }
/*     */   
/*     */   public static native long ndlopen(long paramLong, int paramInt);
/*     */   
/*     */   public static native long ndlerror();
/*     */   
/*     */   public static native long ndlsym(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int ndlclose(long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\DynamicLinkLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */