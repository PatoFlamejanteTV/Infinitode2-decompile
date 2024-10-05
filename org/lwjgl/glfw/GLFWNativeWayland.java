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
/*    */ public class GLFWNativeWayland
/*    */ {
/*    */   public static final class Functions
/*    */   {
/* 24 */     public static final long GetWaylandDisplay = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWaylandDisplay");
/* 25 */     public static final long GetWaylandMonitor = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWaylandMonitor");
/* 26 */     public static final long GetWaylandWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)GLFW.getLibrary(), "glfwGetWaylandWindow");
/*    */   }
/*    */ 
/*    */   
/*    */   protected GLFWNativeWayland() {
/* 31 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("struct wl_display *")
/*    */   public static long glfwGetWaylandDisplay() {
/*    */     long l;
/* 50 */     return JNI.invokeP(l = Functions.GetWaylandDisplay);
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
/*    */   @NativeType("struct wl_output *")
/*    */   public static long glfwGetWaylandMonitor(@NativeType("GLFWmonitor *") long paramLong) {
/* 68 */     long l = Functions.GetWaylandMonitor;
/* 69 */     if (Checks.CHECKS) {
/* 70 */       Checks.check(paramLong);
/*    */     }
/* 72 */     return JNI.invokePP(paramLong, l);
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
/*    */   @NativeType("struct wl_surface *")
/*    */   public static long glfwGetWaylandWindow(@NativeType("GLFWwindow *") long paramLong) {
/* 90 */     long l = Functions.GetWaylandWindow;
/* 91 */     if (Checks.CHECKS) {
/* 92 */       Checks.check(paramLong);
/*    */     }
/* 94 */     return JNI.invokePP(paramLong, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWNativeWayland.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */