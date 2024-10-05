/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
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
/*     */ public class GLFWNativeGLX
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  29 */     public static final long GetGLXContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetGLXContext");
/*  30 */     public static final long GetGLXWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetGLXWindow");
/*  31 */     public static final long GetGLXFBConfig = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetGLXFBConfig");
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWNativeGLX() {
/*  36 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("GLXContext")
/*     */   public static long glfwGetGLXContext(@NativeType("GLFWwindow *") long paramLong) {
/*  56 */     long l = Functions.GetGLXContext;
/*  57 */     if (Checks.CHECKS) {
/*  58 */       Checks.check(paramLong);
/*     */     }
/*  60 */     return JNI.invokePP(paramLong, l);
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
/*     */   @NativeType("GLXWindow")
/*     */   public static long glfwGetGLXWindow(@NativeType("GLFWwindow *") long paramLong) {
/*  80 */     long l = Functions.GetGLXWindow;
/*  81 */     if (Checks.CHECKS) {
/*  82 */       Checks.check(paramLong);
/*     */     }
/*  84 */     return JNI.invokePP(paramLong, l);
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
/*     */   @NativeType("GLXWindow")
/*     */   public static long glfwGetGLXFBConfig(@NativeType("GLFWwindow *") long paramLong) {
/* 104 */     long l = Functions.GetGLXFBConfig;
/* 105 */     if (Checks.CHECKS) {
/* 106 */       Checks.check(paramLong);
/*     */     }
/* 108 */     return JNI.invokePP(paramLong, l);
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
/* 119 */     if (!(paramFunctionProvider instanceof SharedLibrary)) {
/* 120 */       APIUtil.apiLog("GLFW OpenGL path override not set: Function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     String str;
/* 125 */     if ((str = ((SharedLibrary)paramFunctionProvider).getPath()) == null) {
/* 126 */       APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve the shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 131 */     setPath(str);
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
/* 146 */     if ((l1 = GLFW.getLibrary().getFunctionAddress("_glfw_opengl_library")) == 0L) {
/* 147 */       APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve override symbol.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     long l2;
/* 152 */     if ((l2 = MemoryUtil.memGetAddress(l1)) != 0L) {
/* 153 */       MemoryUtil.nmemFree(l2);
/*     */     }
/* 155 */     MemoryUtil.memPutAddress(l1, (paramString == null) ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(paramString)));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWNativeGLX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */