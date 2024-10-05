/*     */ package org.lwjgl.system.linux;
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
/*     */   public static final int RTLD_BINDING_MASK = 3;
/*     */   public static final int RTLD_NOLOAD = 4;
/*     */   public static final int RTLD_DEEPBIND = 8;
/*     */   public static final int RTLD_GLOBAL = 256;
/*     */   public static final int RTLD_LOCAL = 0;
/*     */   public static final int RTLD_NODELETE = 4096;
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
/*  47 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("void *")
/*     */   public static long dlopen(@NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt) {
/*  64 */     if (Checks.CHECKS) {
/*  65 */       Checks.checkNT1Safe(paramByteBuffer);
/*     */     }
/*  67 */     return ndlopen(MemoryUtil.memAddressSafe(paramByteBuffer), paramInt);
/*     */   }
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
/*  79 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  81 */       memoryStack.nUTF8Safe(paramCharSequence, true);
/*     */       long l;
/*  83 */       return ndlopen(l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress(), paramInt);
/*     */     } finally {
/*  85 */       memoryStack.setPointer(i);
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
/*     */   @NativeType("char *")
/*     */   public static String dlerror() {
/*     */     long l;
/* 102 */     return MemoryUtil.memUTF8Safe(l = ndlerror());
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
/*     */   @NativeType("void *")
/*     */   public static long dlsym(@NativeType("void *") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(paramLong);
/* 122 */       Checks.checkNT1(paramByteBuffer);
/*     */     } 
/* 124 */     return ndlsym(paramLong, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   @NativeType("void *")
/*     */   public static long dlsym(@NativeType("void *") long paramLong, @NativeType("char const *") CharSequence paramCharSequence) {
/* 137 */     if (Checks.CHECKS)
/* 138 */       Checks.check(paramLong); 
/*     */     MemoryStack memoryStack;
/* 140 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 142 */       memoryStack.nASCII(paramCharSequence, true);
/* 143 */       long l = memoryStack.getPointerAddress();
/* 144 */       return ndlsym(paramLong, l);
/*     */     } finally {
/* 146 */       memoryStack.setPointer(i);
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
/*     */   public static int dlclose(@NativeType("void *") long paramLong) {
/* 162 */     if (Checks.CHECKS) {
/* 163 */       Checks.check(paramLong);
/*     */     }
/* 165 */     return ndlclose(paramLong);
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


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\DynamicLinkLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */