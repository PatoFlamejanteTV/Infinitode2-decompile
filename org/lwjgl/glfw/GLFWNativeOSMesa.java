/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GLFWNativeOSMesa
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  36 */     public static final long GetOSMesaColorBuffer = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetOSMesaColorBuffer");
/*  37 */     public static final long GetOSMesaDepthBuffer = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetOSMesaDepthBuffer");
/*  38 */     public static final long GetOSMesaContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetOSMesaContext");
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWNativeOSMesa() {
/*  43 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglfwGetOSMesaColorBuffer(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/*  50 */     long l = Functions.GetOSMesaColorBuffer;
/*  51 */     if (Checks.CHECKS) {
/*  52 */       Checks.check(paramLong1);
/*     */     }
/*  54 */     return JNI.invokePPPPPI(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, l);
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
/*     */   @NativeType("int")
/*     */   public static boolean glfwGetOSMesaColorBuffer(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/*  76 */     if (Checks.CHECKS) {
/*  77 */       Checks.checkSafe(paramIntBuffer1, 1);
/*  78 */       Checks.checkSafe(paramIntBuffer2, 1);
/*  79 */       Checks.checkSafe(paramIntBuffer3, 1);
/*  80 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/*  82 */     return (nglfwGetOSMesaColorBuffer(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglfwGetOSMesaDepthBuffer(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/*  89 */     long l = Functions.GetOSMesaDepthBuffer;
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.check(paramLong1);
/*     */     }
/*  93 */     return JNI.invokePPPPPI(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, l);
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
/*     */   public static int glfwGetOSMesaDepthBuffer(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 114 */     if (Checks.CHECKS) {
/* 115 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 116 */       Checks.checkSafe(paramIntBuffer2, 1);
/* 117 */       Checks.checkSafe(paramIntBuffer3, 1);
/* 118 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/* 120 */     return nglfwGetOSMesaDepthBuffer(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer));
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
/*     */   @NativeType("OSMesaContext")
/*     */   public static long glfwGetOSMesaContext(@NativeType("GLFWwindow *") long paramLong) {
/* 140 */     long l = Functions.GetOSMesaContext;
/* 141 */     if (Checks.CHECKS) {
/* 142 */       Checks.check(paramLong);
/*     */     }
/* 144 */     return JNI.invokePP(paramLong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("int")
/*     */   public static boolean glfwGetOSMesaColorBuffer(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 150 */     long l = Functions.GetOSMesaColorBuffer;
/* 151 */     if (Checks.CHECKS) {
/* 152 */       Checks.check(paramLong);
/* 153 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 154 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 155 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 156 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/* 158 */     return (JNI.invokePPPPPI(paramLong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glfwGetOSMesaDepthBuffer(@NativeType("GLFWwindow *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 163 */     long l = Functions.GetOSMesaDepthBuffer;
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(paramLong);
/* 166 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 167 */       Checks.checkSafe(paramArrayOfint2, 1);
/* 168 */       Checks.checkSafe(paramArrayOfint3, 1);
/* 169 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/* 171 */     return JNI.invokePPPPPI(paramLong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setPath(FunctionProvider paramFunctionProvider) {
/* 182 */     if (!(paramFunctionProvider instanceof SharedLibrary)) {
/* 183 */       APIUtil.apiLog("GLFW OSMesa path override not set: Function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     String str;
/* 188 */     if ((str = ((SharedLibrary)paramFunctionProvider).getPath()) == null) {
/* 189 */       APIUtil.apiLog("GLFW OSMesa path override not set: Could not resolve the OSMesa shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/* 193 */     setPath(str);
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
/*     */   public static void setPath(String paramString) {
/*     */     long l1;
/* 208 */     if ((l1 = GLFW.getLibrary().getFunctionAddress("_glfw_mesa_library")) == 0L) {
/* 209 */       APIUtil.apiLog("GLFW OSMesa path override not set: Could not resolve override symbol.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     long l2;
/* 214 */     if ((l2 = MemoryUtil.memGetAddress(l1)) != 0L) {
/* 215 */       MemoryUtil.nmemFree(l2);
/*     */     }
/* 217 */     MemoryUtil.memPutAddress(l1, (paramString == null) ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(paramString)));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWNativeOSMesa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */