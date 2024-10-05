/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.FunctionProvider;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GLFWNativeNSGL
/*    */ {
/*    */   public static final class Functions
/*    */   {
/* 30 */     public static final long GetNSGLContext = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetNSGLContext");
/*    */   }
/*    */ 
/*    */   
/*    */   protected GLFWNativeNSGL() {
/* 35 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("id")
/*    */   public static long glfwGetNSGLContext(@NativeType("GLFWwindow *") long paramLong) {
/* 55 */     long l = Functions.GetNSGLContext;
/* 56 */     if (Checks.CHECKS) {
/* 57 */       Checks.check(paramLong);
/*    */     }
/* 59 */     return JNI.invokePP(paramLong, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWNativeNSGL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */