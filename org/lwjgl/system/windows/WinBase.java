/*     */ package org.lwjgl.system.windows;
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
/*     */ public class WinBase
/*     */ {
/*     */   public static final int FALSE = 0;
/*     */   public static final int TRUE = 1;
/*     */   
/*     */   static {
/*  21 */     Library.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected WinBase() {
/*  29 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("HLOCAL")
/*     */   public static long LocalFree(@NativeType("HLOCAL") long paramLong) {
/*  48 */     if (Checks.CHECKS) {
/*  49 */       Checks.check(paramLong);
/*     */     }
/*  51 */     return nLocalFree(paramLong);
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
/*     */   @NativeType("HMODULE")
/*     */   public static long GetModuleHandle(@NativeType("LPCTSTR") ByteBuffer paramByteBuffer) {
/*  95 */     if (Checks.CHECKS) {
/*  96 */       Checks.checkNT2Safe(paramByteBuffer);
/*     */     }
/*  98 */     return nGetModuleHandle(MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*     */   @NativeType("HMODULE")
/*     */   public static long GetModuleHandle(@NativeType("LPCTSTR") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 113 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 115 */       memoryStack.nUTF16Safe(paramCharSequence, true);
/*     */       long l;
/* 117 */       return nGetModuleHandle(l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress());
/*     */     } finally {
/* 119 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetModuleFileName(@NativeType("HMODULE") long paramLong, @NativeType("LPTSTR") ByteBuffer paramByteBuffer) {
/* 159 */     return nGetModuleFileName(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining() >> 1);
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
/*     */   @NativeType("DWORD")
/*     */   public static String GetModuleFileName(@NativeType("HMODULE") long paramLong, @NativeType("DWORD") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 180 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 182 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt);
/* 183 */       int j = nGetModuleFileName(paramLong, MemoryUtil.memAddress(byteBuffer), paramInt);
/* 184 */       return MemoryUtil.memUTF16(byteBuffer, j);
/*     */     } finally {
/* 186 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HMODULE")
/*     */   public static long LoadLibrary(@NativeType("LPCTSTR") ByteBuffer paramByteBuffer) {
/* 214 */     if (Checks.CHECKS) {
/* 215 */       Checks.checkNT2(paramByteBuffer);
/*     */     }
/* 217 */     return nLoadLibrary(MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   @NativeType("HMODULE")
/*     */   public static long LoadLibrary(@NativeType("LPCTSTR") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 239 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 241 */       memoryStack.nUTF16(paramCharSequence, true);
/*     */       long l;
/* 243 */       return nLoadLibrary(l = memoryStack.getPointerAddress());
/*     */     } finally {
/* 245 */       memoryStack.setPointer(i);
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
/*     */   @NativeType("FARPROC")
/*     */   public static long GetProcAddress(@NativeType("HMODULE") long paramLong, @NativeType("LPCSTR") ByteBuffer paramByteBuffer) {
/* 263 */     if (Checks.CHECKS) {
/* 264 */       Checks.check(paramLong);
/* 265 */       Checks.checkNT1(paramByteBuffer);
/*     */     } 
/* 267 */     return nGetProcAddress(paramLong, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("FARPROC")
/*     */   public static long GetProcAddress(@NativeType("HMODULE") long paramLong, @NativeType("LPCSTR") CharSequence paramCharSequence) {
/* 279 */     if (Checks.CHECKS)
/* 280 */       Checks.check(paramLong); 
/*     */     MemoryStack memoryStack;
/* 282 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 284 */       memoryStack.nASCII(paramCharSequence, true);
/* 285 */       long l = memoryStack.getPointerAddress();
/* 286 */       return nGetProcAddress(paramLong, l);
/*     */     } finally {
/* 288 */       memoryStack.setPointer(i);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean FreeLibrary(@NativeType("HMODULE") long paramLong) {
/* 305 */     if (Checks.CHECKS) {
/* 306 */       Checks.check(paramLong);
/*     */     }
/* 308 */     return (nFreeLibrary(paramLong) != 0);
/*     */   }
/*     */   
/*     */   public static native long nLocalFree(long paramLong);
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static native int GetLastError();
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static native int getLastError();
/*     */   
/*     */   public static native long nGetModuleHandle(long paramLong);
/*     */   
/*     */   public static native int nGetModuleFileName(long paramLong1, long paramLong2, int paramInt);
/*     */   
/*     */   public static native long nLoadLibrary(long paramLong);
/*     */   
/*     */   public static native long nGetProcAddress(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nFreeLibrary(long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\WinBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */