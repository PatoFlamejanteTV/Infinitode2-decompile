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
/*    */ public class GLFWNativeCocoa
/*    */ {
/*    */   public static final class Functions
/*    */   {
/* 24 */     public static final long GetCocoaMonitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetCocoaMonitor");
/* 25 */     public static final long GetCocoaWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetCocoaWindow");
/*    */   }
/*    */ 
/*    */   
/*    */   protected GLFWNativeCocoa() {
/* 30 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("CGDirectDisplayID")
/*    */   public static int glfwGetCocoaMonitor(@NativeType("GLFWmonitor *") long paramLong) {
/* 50 */     long l = Functions.GetCocoaMonitor;
/* 51 */     if (Checks.CHECKS) {
/* 52 */       Checks.check(paramLong);
/*    */     }
/* 54 */     return JNI.invokePI(paramLong, l);
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
/*    */   public static long glfwGetCocoaWindow(@NativeType("GLFWwindow *") long paramLong) {
/* 74 */     long l = Functions.GetCocoaWindow;
/* 75 */     if (Checks.CHECKS) {
/* 76 */       Checks.check(paramLong);
/*    */     }
/* 78 */     return JNI.invokePP(paramLong, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWNativeCocoa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */