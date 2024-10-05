/*     */ package org.lwjgl.system;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MemoryAccessJNI
/*     */ {
/*     */   static {
/*  14 */     Library.initialize();
/*     */   }
/*     */   private MemoryAccessJNI() {
/*  17 */     throw new UnsupportedOperationException();
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
/*  31 */   static final long malloc = malloc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   static final long calloc = calloc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   static final long realloc = realloc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   static final long free = free();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   static final long aligned_alloc = aligned_alloc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   static final long aligned_free = aligned_free();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int8_t")
/*     */   static byte getByte(@NativeType("void *") long paramLong) {
/*  85 */     if (Checks.CHECKS) {
/*  86 */       Checks.check(paramLong);
/*     */     }
/*  88 */     return ngetByte(paramLong);
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
/*     */   @NativeType("int16_t")
/*     */   static short getShort(@NativeType("void *") long paramLong) {
/* 103 */     if (Checks.CHECKS) {
/* 104 */       Checks.check(paramLong);
/*     */     }
/* 106 */     return ngetShort(paramLong);
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
/*     */   @NativeType("int32_t")
/*     */   static int getInt(@NativeType("void *") long paramLong) {
/* 121 */     if (Checks.CHECKS) {
/* 122 */       Checks.check(paramLong);
/*     */     }
/* 124 */     return ngetInt(paramLong);
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
/*     */   @NativeType("int64_t")
/*     */   static long getLong(@NativeType("void *") long paramLong) {
/* 139 */     if (Checks.CHECKS) {
/* 140 */       Checks.check(paramLong);
/*     */     }
/* 142 */     return ngetLong(paramLong);
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
/*     */   static float getFloat(@NativeType("void *") long paramLong) {
/* 156 */     if (Checks.CHECKS) {
/* 157 */       Checks.check(paramLong);
/*     */     }
/* 159 */     return ngetFloat(paramLong);
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
/*     */   static double getDouble(@NativeType("void *") long paramLong) {
/* 173 */     if (Checks.CHECKS) {
/* 174 */       Checks.check(paramLong);
/*     */     }
/* 176 */     return ngetDouble(paramLong);
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
/*     */   @NativeType("uintptr_t")
/*     */   static long getAddress(@NativeType("void *") long paramLong) {
/* 191 */     if (Checks.CHECKS) {
/* 192 */       Checks.check(paramLong);
/*     */     }
/* 194 */     return ngetAddress(paramLong);
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
/*     */   static void putByte(@NativeType("void *") long paramLong, @NativeType("int8_t") byte paramByte) {
/* 209 */     if (Checks.CHECKS) {
/* 210 */       Checks.check(paramLong);
/*     */     }
/* 212 */     nputByte(paramLong, paramByte);
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
/*     */   static void putShort(@NativeType("void *") long paramLong, @NativeType("int16_t") short paramShort) {
/* 227 */     if (Checks.CHECKS) {
/* 228 */       Checks.check(paramLong);
/*     */     }
/* 230 */     nputShort(paramLong, paramShort);
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
/*     */   static void putInt(@NativeType("void *") long paramLong, @NativeType("int32_t") int paramInt) {
/* 245 */     if (Checks.CHECKS) {
/* 246 */       Checks.check(paramLong);
/*     */     }
/* 248 */     nputInt(paramLong, paramInt);
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
/*     */   static void putLong(@NativeType("void *") long paramLong1, @NativeType("int64_t") long paramLong2) {
/* 263 */     if (Checks.CHECKS) {
/* 264 */       Checks.check(paramLong1);
/*     */     }
/* 266 */     nputLong(paramLong1, paramLong2);
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
/*     */   static void putFloat(@NativeType("void *") long paramLong, float paramFloat) {
/* 281 */     if (Checks.CHECKS) {
/* 282 */       Checks.check(paramLong);
/*     */     }
/* 284 */     nputFloat(paramLong, paramFloat);
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
/*     */   static void putDouble(@NativeType("void *") long paramLong, double paramDouble) {
/* 299 */     if (Checks.CHECKS) {
/* 300 */       Checks.check(paramLong);
/*     */     }
/* 302 */     nputDouble(paramLong, paramDouble);
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
/*     */   static void putAddress(@NativeType("void *") long paramLong1, @NativeType("uintptr_t") long paramLong2) {
/* 317 */     if (Checks.CHECKS) {
/* 318 */       Checks.check(paramLong1);
/*     */     }
/* 320 */     nputAddress(paramLong1, paramLong2);
/*     */   }
/*     */   
/*     */   static native int getPointerSize();
/*     */   
/*     */   @NativeType("void * (*) (size_t)")
/*     */   private static native long malloc();
/*     */   
/*     */   @NativeType("void * (*) (size_t, size_t)")
/*     */   private static native long calloc();
/*     */   
/*     */   @NativeType("void * (*) (void *, size_t)")
/*     */   private static native long realloc();
/*     */   
/*     */   @NativeType("void (*) (void *)")
/*     */   private static native long free();
/*     */   
/*     */   @NativeType("void * (*) (size_t, size_t)")
/*     */   private static native long aligned_alloc();
/*     */   
/*     */   @NativeType("void (*) (void *)")
/*     */   private static native long aligned_free();
/*     */   
/*     */   static native byte ngetByte(long paramLong);
/*     */   
/*     */   static native short ngetShort(long paramLong);
/*     */   
/*     */   static native int ngetInt(long paramLong);
/*     */   
/*     */   static native long ngetLong(long paramLong);
/*     */   
/*     */   static native float ngetFloat(long paramLong);
/*     */   
/*     */   static native double ngetDouble(long paramLong);
/*     */   
/*     */   static native long ngetAddress(long paramLong);
/*     */   
/*     */   static native void nputByte(long paramLong, byte paramByte);
/*     */   
/*     */   static native void nputShort(long paramLong, short paramShort);
/*     */   
/*     */   static native void nputInt(long paramLong, int paramInt);
/*     */   
/*     */   static native void nputLong(long paramLong1, long paramLong2);
/*     */   
/*     */   static native void nputFloat(long paramLong, float paramFloat);
/*     */   
/*     */   static native void nputDouble(long paramLong, double paramDouble);
/*     */   
/*     */   static native void nputAddress(long paramLong1, long paramLong2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\MemoryAccessJNI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */