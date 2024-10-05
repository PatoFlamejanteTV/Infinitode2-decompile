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
/*     */ public class GLFWNativeWGL
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  29 */     public static final long GetWGLContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWGLContext");
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWNativeWGL() {
/*  34 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("HGLRC")
/*     */   public static long glfwGetWGLContext(@NativeType("GLFWwindow *") long paramLong) {
/*  60 */     long l = Functions.GetWGLContext;
/*  61 */     if (Checks.CHECKS) {
/*  62 */       Checks.check(paramLong);
/*     */     }
/*  64 */     return JNI.invokePP(paramLong, l);
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
/*  75 */     if (!(paramFunctionProvider instanceof SharedLibrary)) {
/*  76 */       APIUtil.apiLog("GLFW OpenGL path override not set: Function provider is not a shared library.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     String str;
/*  81 */     if ((str = ((SharedLibrary)paramFunctionProvider).getPath()) == null) {
/*  82 */       APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve the shared library path.");
/*     */       
/*     */       return;
/*     */     } 
/*  86 */     setPath(str);
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
/* 101 */     if ((l1 = GLFW.getLibrary().getFunctionAddress("_glfw_opengl_library")) == 0L) {
/* 102 */       APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve override symbol.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     long l2;
/* 107 */     if ((l2 = MemoryUtil.memGetAddress(l1)) != 0L) {
/* 108 */       MemoryUtil.nmemFree(l2);
/*     */     }
/* 110 */     MemoryUtil.memPutAddress(l1, (paramString == null) ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF16(paramString)));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWNativeWGL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */