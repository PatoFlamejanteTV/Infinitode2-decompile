/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
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
/*     */ public class GLFWNativeWin32
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  27 */     public static final long GetWin32Adapter = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWin32Adapter");
/*  28 */     public static final long GetWin32Monitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWin32Monitor");
/*  29 */     public static final long GetWin32Window = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWin32Window");
/*  30 */     public static final long AttachWin32Window = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwAttachWin32Window");
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWNativeWin32() {
/*  35 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglfwGetWin32Adapter(long paramLong) {
/*  42 */     long l = Functions.GetWin32Adapter;
/*  43 */     if (Checks.CHECKS) {
/*  44 */       Checks.check(paramLong);
/*     */     }
/*  46 */     return JNI.invokePP(paramLong, l);
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
/*     */   @NativeType("char const *")
/*     */   public static String glfwGetWin32Adapter(@NativeType("GLFWmonitor *") long paramLong) {
/*     */     long l;
/*  66 */     return MemoryUtil.memUTF8Safe(l = nglfwGetWin32Adapter(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglfwGetWin32Monitor(long paramLong) {
/*  73 */     long l = Functions.GetWin32Monitor;
/*  74 */     if (Checks.CHECKS) {
/*  75 */       Checks.check(paramLong);
/*     */     }
/*  77 */     return JNI.invokePP(paramLong, l);
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
/*     */   @NativeType("char const *")
/*     */   public static String glfwGetWin32Monitor(@NativeType("GLFWmonitor *") long paramLong) {
/*     */     long l;
/*  97 */     return MemoryUtil.memUTF8Safe(l = nglfwGetWin32Monitor(paramLong));
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
/*     */   @NativeType("HWND")
/*     */   public static long glfwGetWin32Window(@NativeType("GLFWwindow *") long paramLong) {
/* 123 */     long l = Functions.GetWin32Window;
/* 124 */     if (Checks.CHECKS) {
/* 125 */       Checks.check(paramLong);
/*     */     }
/* 127 */     return JNI.invokePP(paramLong, l);
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
/*     */   @NativeType("GLFWwindow *")
/*     */   public static long glfwAttachWin32Window(@NativeType("HWND") long paramLong1, @NativeType("GLFWwindow *") long paramLong2) {
/* 151 */     long l = Functions.AttachWin32Window;
/* 152 */     if (Checks.CHECKS) {
/* 153 */       Checks.check(paramLong1);
/*     */     }
/* 155 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWNativeWin32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */