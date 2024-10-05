/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Kernel32
/*     */ {
/*  17 */   private static final SharedLibrary KERNEL32 = Library.loadNative(Kernel32.class, "org.lwjgl", "kernel32");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Functions
/*     */   {
/*  26 */     public static final long GetCurrentProcess = APIUtil.apiGetFunctionAddress((FunctionProvider)Kernel32.KERNEL32, "GetCurrentProcess");
/*  27 */     public static final long GetCurrentProcessId = APIUtil.apiGetFunctionAddress((FunctionProvider)Kernel32.KERNEL32, "GetCurrentProcessId");
/*  28 */     public static final long GetProcessId = APIUtil.apiGetFunctionAddress((FunctionProvider)Kernel32.KERNEL32, "GetProcessId");
/*  29 */     public static final long GetCurrentThread = APIUtil.apiGetFunctionAddress((FunctionProvider)Kernel32.KERNEL32, "GetCurrentThread");
/*  30 */     public static final long GetCurrentThreadId = APIUtil.apiGetFunctionAddress((FunctionProvider)Kernel32.KERNEL32, "GetCurrentThreadId");
/*  31 */     public static final long GetThreadId = APIUtil.apiGetFunctionAddressOptional(Kernel32.KERNEL32, "GetThreadId");
/*  32 */     public static final long GetProcessIdOfThread = APIUtil.apiGetFunctionAddressOptional(Kernel32.KERNEL32, "GetProcessIdOfThread");
/*  33 */     public static final long GetCurrentProcessorNumber = APIUtil.apiGetFunctionAddressOptional(Kernel32.KERNEL32, "GetCurrentProcessorNumber");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  39 */     return KERNEL32;
/*     */   }
/*     */   
/*     */   protected Kernel32() {
/*  43 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HANDLE")
/*     */   public static long GetCurrentProcess() {
/*     */     long l;
/*  51 */     return JNI.callP(l = Functions.GetCurrentProcess);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetCurrentProcessId() {
/*     */     long l;
/*  59 */     return JNI.callI(l = Functions.GetCurrentProcessId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetProcessId(@NativeType("HANDLE") long paramLong) {
/*  66 */     long l = Functions.GetProcessId;
/*  67 */     if (Checks.CHECKS) {
/*  68 */       Checks.check(paramLong);
/*     */     }
/*  70 */     return JNI.callPI(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HANDLE")
/*     */   public static long GetCurrentThread() {
/*     */     long l;
/*  78 */     return JNI.callP(l = Functions.GetCurrentThread);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetCurrentThreadId() {
/*     */     long l;
/*  86 */     return JNI.callI(l = Functions.GetCurrentThreadId);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetThreadId(@NativeType("HANDLE") long paramLong) {
/*  93 */     long l = Functions.GetThreadId;
/*  94 */     if (Checks.CHECKS) {
/*  95 */       Checks.check(l);
/*  96 */       Checks.check(paramLong);
/*     */     } 
/*  98 */     return JNI.callPI(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetProcessIdOfThread(@NativeType("HANDLE") long paramLong) {
/* 105 */     long l = Functions.GetProcessIdOfThread;
/* 106 */     if (Checks.CHECKS) {
/* 107 */       Checks.check(l);
/* 108 */       Checks.check(paramLong);
/*     */     } 
/* 110 */     return JNI.callPI(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public static int GetCurrentProcessorNumber() {
/* 117 */     long l = Functions.GetCurrentProcessorNumber;
/* 118 */     if (Checks.CHECKS) {
/* 119 */       Checks.check(l);
/*     */     }
/* 121 */     return JNI.callI(l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\Kernel32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */