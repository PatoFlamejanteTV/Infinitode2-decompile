/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ 
/*     */ 
/*     */ public class Crypt32
/*     */ {
/*     */   public static final int CRYPTPROTECT_UI_FORBIDDEN = 1;
/*     */   public static final int CRYPTPROTECT_LOCAL_MACHINE = 4;
/*     */   public static final int CRYPTPROTECT_AUDIT = 16;
/*     */   public static final int CRYPTPROTECT_VERIFY_PROTECTION = 64;
/*     */   public static final int CRYPTPROTECTMEMORY_SAME_PROCESS = 0;
/*  24 */   private static final SharedLibrary CRYPT32 = Library.loadNative(Crypt32.class, "org.lwjgl", "crypt32");
/*     */   public static final int CRYPTPROTECTMEMORY_CROSS_PROCESS = 1;
/*     */   public static final int CRYPTPROTECTMEMORY_SAME_LOGON = 2;
/*     */   public static final int CRYPTPROTECT_PROMPT_ON_UNPROTECT = 1;
/*     */   public static final int CRYPTPROTECT_PROMPT_ON_PROTECT = 2;
/*     */   public static final int CRYPTPROTECTMEMORY_BLOCK_SIZE = 16;
/*     */   
/*     */   public static final class Functions
/*     */   {
/*  33 */     public static final long CryptProtectData = APIUtil.apiGetFunctionAddress((FunctionProvider)Crypt32.CRYPT32, "CryptProtectData");
/*  34 */     public static final long CryptProtectMemory = APIUtil.apiGetFunctionAddressOptional(Crypt32.CRYPT32, "CryptProtectMemory");
/*  35 */     public static final long CryptUnprotectData = APIUtil.apiGetFunctionAddress((FunctionProvider)Crypt32.CRYPT32, "CryptUnprotectData");
/*  36 */     public static final long CryptUnprotectMemory = APIUtil.apiGetFunctionAddressOptional(Crypt32.CRYPT32, "CryptUnprotectMemory");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  42 */     return CRYPT32;
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
/*     */   protected Crypt32() {
/*  67 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nCryptProtectData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6) {
/*  77 */     long l = Functions.CryptProtectData;
/*  78 */     return nCryptProtectData(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramInt, paramLong6, l);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean CryptProtectData(@NativeType("DATA_BLOB *") DATA_BLOB paramDATA_BLOB1, @NativeType("LPCWSTR") ByteBuffer paramByteBuffer, @NativeType("DATA_BLOB *") DATA_BLOB paramDATA_BLOB2, @NativeType("PVOID") long paramLong, @NativeType("CRYPTPROTECT_PROMPTSTRUCT *") CRYPTPROTECT_PROMPTSTRUCT paramCRYPTPROTECT_PROMPTSTRUCT, @NativeType("DWORD") int paramInt, @NativeType("DATA_BLOB *") DATA_BLOB paramDATA_BLOB3) {
/* 107 */     if (Checks.CHECKS) {
/* 108 */       Checks.checkNT2Safe(paramByteBuffer);
/*     */     }
/* 110 */     return (nCryptProtectData(paramDATA_BLOB1.address(), MemoryUtil.memAddressSafe(paramByteBuffer), MemoryUtil.memAddressSafe((Pointer)paramDATA_BLOB2), paramLong, MemoryUtil.memAddressSafe((Pointer)paramCRYPTPROTECT_PROMPTSTRUCT), paramInt, paramDATA_BLOB3.address()) != 0);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean CryptProtectData(@NativeType("DATA_BLOB *") DATA_BLOB paramDATA_BLOB1, @NativeType("LPCWSTR") CharSequence paramCharSequence, @NativeType("DATA_BLOB *") DATA_BLOB paramDATA_BLOB2, @NativeType("PVOID") long paramLong, @NativeType("CRYPTPROTECT_PROMPTSTRUCT *") CRYPTPROTECT_PROMPTSTRUCT paramCRYPTPROTECT_PROMPTSTRUCT, @NativeType("DWORD") int paramInt, @NativeType("DATA_BLOB *") DATA_BLOB paramDATA_BLOB3) {
/*     */     MemoryStack memoryStack;
/* 139 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 141 */       memoryStack.nUTF16Safe(paramCharSequence, true);
/* 142 */       long l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress();
/* 143 */       return (nCryptProtectData(paramDATA_BLOB1.address(), l, MemoryUtil.memAddressSafe((Pointer)paramDATA_BLOB2), paramLong, MemoryUtil.memAddressSafe((Pointer)paramCRYPTPROTECT_PROMPTSTRUCT), paramInt, paramDATA_BLOB3.address()) != 0);
/*     */     } finally {
/* 145 */       memoryStack.setPointer(i);
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
/*     */   public static int nCryptProtectMemory(long paramLong, int paramInt1, int paramInt2) {
/* 168 */     long l = Functions.CryptProtectMemory;
/* 169 */     if (Checks.CHECKS) {
/* 170 */       Checks.check(l);
/*     */     }
/* 172 */     return nCryptProtectMemory(paramLong, paramInt1, paramInt2, l);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean CryptProtectMemory(@NativeType("LPVOID") ByteBuffer paramByteBuffer, @NativeType("DWORD") int paramInt) {
/* 186 */     return (nCryptProtectMemory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nCryptUnprotectData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6) {
/* 196 */     long l = Functions.CryptUnprotectData;
/* 197 */     return nCryptUnprotectData(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramInt, paramLong6, l);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean CryptUnprotectData(@NativeType("DATA_BLOB *") DATA_BLOB paramDATA_BLOB1, @NativeType("LPWSTR *") PointerBuffer paramPointerBuffer, @NativeType("DATA_BLOB *") DATA_BLOB paramDATA_BLOB2, @NativeType("PVOID") long paramLong, @NativeType("CRYPTPROTECT_PROMPTSTRUCT *") CRYPTPROTECT_PROMPTSTRUCT paramCRYPTPROTECT_PROMPTSTRUCT, @NativeType("DWORD") int paramInt, @NativeType("DATA_BLOB *") DATA_BLOB paramDATA_BLOB3) {
/* 226 */     if (Checks.CHECKS) {
/* 227 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, 1);
/*     */     }
/* 229 */     return (nCryptUnprotectData(paramDATA_BLOB1.address(), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), MemoryUtil.memAddressSafe((Pointer)paramDATA_BLOB2), paramLong, MemoryUtil.memAddressSafe((Pointer)paramCRYPTPROTECT_PROMPTSTRUCT), paramInt, paramDATA_BLOB3.address()) != 0);
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
/*     */   public static int nCryptUnprotectMemory(long paramLong, int paramInt1, int paramInt2) {
/* 251 */     long l = Functions.CryptUnprotectMemory;
/* 252 */     if (Checks.CHECKS) {
/* 253 */       Checks.check(l);
/*     */     }
/* 255 */     return nCryptUnprotectMemory(paramLong, paramInt1, paramInt2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean CryptUnprotectMemory(@NativeType("LPVOID") ByteBuffer paramByteBuffer, @NativeType("DWORD") int paramInt) {
/* 266 */     return (nCryptUnprotectMemory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt) != 0);
/*     */   }
/*     */   
/*     */   public static native int nCryptProtectData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6, long paramLong7);
/*     */   
/*     */   public static native int nCryptProtectMemory(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*     */   
/*     */   public static native int nCryptUnprotectData(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt, long paramLong6, long paramLong7);
/*     */   
/*     */   public static native int nCryptUnprotectMemory(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\Crypt32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */