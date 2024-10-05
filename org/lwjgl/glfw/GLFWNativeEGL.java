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
/*     */ 
/*     */ 
/*     */ public class GLFWNativeEGL
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  31 */     public static final long GetEGLDisplay = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetEGLDisplay");
/*  32 */     public static final long GetEGLContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetEGLContext");
/*  33 */     public static final long GetEGLSurface = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetEGLSurface");
/*  34 */     public static final long GetEGLConfig = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetEGLConfig");
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWNativeEGL() {
/*  39 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("EGLDisplay")
/*     */   public static long glfwGetEGLDisplay() {
/*     */     long l;
/*  60 */     return JNI.invokeP(l = Functions.GetEGLDisplay);
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
/*     */   @NativeType("EGLContext")
/*     */   public static long glfwGetEGLContext(@NativeType("GLFWwindow *") long paramLong) {
/*  80 */     long l = Functions.GetEGLContext;
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
/*     */   @NativeType("EGLSurface")
/*     */   public static long glfwGetEGLSurface(@NativeType("GLFWwindow *") long paramLong) {
/* 102 */     long l = Functions.GetEGLSurface;
/* 103 */     if (Checks.CHECKS) {
/* 104 */       Checks.check(paramLong);
/*     */     }
/* 106 */     return JNI.invokePP(paramLong, l);
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
/*     */   @NativeType("EGLConfig")
/*     */   public static long glfwGetEGLConfig(@NativeType("GLFWwindow *") long paramLong) {
/* 124 */     long l = Functions.GetEGLConfig;
/* 125 */     if (Checks.CHECKS) {
/* 126 */       Checks.check(paramLong);
/*     */     }
/* 128 */     return JNI.invokePP(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setEGLPath(FunctionProvider paramFunctionProvider) {
/* 139 */     if (!(paramFunctionProvider instanceof SharedLibrary)) {
/* 140 */       APIUtil.apiLog("GLFW EGL path override not set: Function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     String str;
/* 145 */     if ((str = ((SharedLibrary)paramFunctionProvider).getPath()) == null) {
/* 146 */       APIUtil.apiLog("GLFW EGL path override not set: Could not resolve the shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 151 */     setEGLPath(str);
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
/*     */   public static void setEGLPath(String paramString) {
/* 165 */     if (!override("_glfw_egl_library", paramString)) {
/* 166 */       APIUtil.apiLog("GLFW EGL path override not set: Could not resolve override symbol.");
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
/*     */   public static void setGLESPath(FunctionProvider paramFunctionProvider) {
/* 178 */     if (!(paramFunctionProvider instanceof SharedLibrary)) {
/* 179 */       APIUtil.apiLog("GLFW OpenGL ES path override not set: Function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     String str;
/* 184 */     if ((str = ((SharedLibrary)paramFunctionProvider).getPath()) == null) {
/* 185 */       APIUtil.apiLog("GLFW OpenGL ES path override not set: Could not resolve the shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 190 */     setGLESPath(str);
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
/*     */   public static void setGLESPath(String paramString) {
/* 204 */     if (!override("_glfw_opengles_library", paramString)) {
/* 205 */       APIUtil.apiLog("GLFW OpenGL ES path override not set: Could not resolve override symbol.");
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean override(String paramString1, String paramString2) {
/*     */     long l1;
/* 211 */     if ((l1 = GLFW.getLibrary().getFunctionAddress(paramString1)) == 0L) {
/* 212 */       return false;
/*     */     }
/*     */     
/*     */     long l2;
/* 216 */     if ((l2 = MemoryUtil.memGetAddress(l1)) != 0L) {
/* 217 */       MemoryUtil.nmemFree(l2);
/*     */     }
/* 219 */     MemoryUtil.memPutAddress(l1, (paramString2 == null) ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(paramString2)));
/* 220 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWNativeEGL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */