/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
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
/*     */ 
/*     */ public class GLFWNativeX11
/*     */ {
/*     */   public static final class Functions
/*     */   {
/*  30 */     public static final long GetX11Display = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetX11Display");
/*  31 */     public static final long GetX11Adapter = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetX11Adapter");
/*  32 */     public static final long GetX11Monitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetX11Monitor");
/*  33 */     public static final long GetX11Window = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetX11Window");
/*  34 */     public static final long SetX11SelectionString = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwSetX11SelectionString");
/*  35 */     public static final long GetX11SelectionString = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetX11SelectionString");
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWNativeX11() {
/*  40 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("Display *")
/*     */   public static long glfwGetX11Display() {
/*     */     long l;
/*  59 */     return JNI.invokeP(l = Functions.GetX11Display);
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
/*     */   @NativeType("RRCrtc")
/*     */   public static long glfwGetX11Adapter(@NativeType("GLFWmonitor *") long paramLong) {
/*  79 */     long l = Functions.GetX11Adapter;
/*  80 */     if (Checks.CHECKS) {
/*  81 */       Checks.check(paramLong);
/*     */     }
/*  83 */     return JNI.invokePN(paramLong, l);
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
/*     */   @NativeType("RROutput")
/*     */   public static long glfwGetX11Monitor(@NativeType("GLFWmonitor *") long paramLong) {
/* 103 */     long l = Functions.GetX11Monitor;
/* 104 */     if (Checks.CHECKS) {
/* 105 */       Checks.check(paramLong);
/*     */     }
/* 107 */     return JNI.invokePN(paramLong, l);
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
/*     */   @NativeType("Window")
/*     */   public static long glfwGetX11Window(@NativeType("GLFWwindow *") long paramLong) {
/* 127 */     long l = Functions.GetX11Window;
/* 128 */     if (Checks.CHECKS) {
/* 129 */       Checks.check(paramLong);
/*     */     }
/* 131 */     return JNI.invokePN(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglfwSetX11SelectionString(long paramLong) {
/* 138 */     long l = Functions.SetX11SelectionString;
/* 139 */     JNI.invokePV(paramLong, l);
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
/*     */   public static void glfwSetX11SelectionString(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 152 */     if (Checks.CHECKS) {
/* 153 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 155 */     nglfwSetX11SelectionString(MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glfwSetX11SelectionString(@NativeType("char const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 168 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 170 */       memoryStack.nUTF8(paramCharSequence, true);
/*     */       long l;
/* 172 */       nglfwSetX11SelectionString(l = memoryStack.getPointerAddress()); return;
/*     */     } finally {
/* 174 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglfwGetX11SelectionString() {
/*     */     long l;
/* 183 */     return JNI.invokeP(l = Functions.GetX11SelectionString);
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
/*     */   @NativeType("char const *")
/*     */   public static String glfwGetX11SelectionString() {
/*     */     long l;
/* 204 */     return MemoryUtil.memUTF8Safe(l = nglfwGetX11SelectionString());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWNativeX11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */