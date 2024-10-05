/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
/*    */ import org.lwjgl.system.Checks;
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
/*    */ 
/*    */ 
/*    */ public final class Callbacks
/*    */ {
/*    */   public static void glfwFreeCallbacks(@NativeType("GLFWwindow *") long paramLong) {
/* 30 */     if (Checks.CHECKS)
/* 31 */       Checks.check(paramLong); 
/*    */     long[] arrayOfLong;
/*    */     byte b;
/* 34 */     for (arrayOfLong = new long[] { GLFW.Functions.SetWindowPosCallback, GLFW.Functions.SetWindowSizeCallback, GLFW.Functions.SetWindowCloseCallback, GLFW.Functions.SetWindowRefreshCallback, GLFW.Functions.SetWindowFocusCallback, GLFW.Functions.SetWindowIconifyCallback, GLFW.Functions.SetWindowMaximizeCallback, GLFW.Functions.SetFramebufferSizeCallback, GLFW.Functions.SetWindowContentScaleCallback, GLFW.Functions.SetKeyCallback, GLFW.Functions.SetCharCallback, GLFW.Functions.SetCharModsCallback, GLFW.Functions.SetMouseButtonCallback, GLFW.Functions.SetCursorPosCallback, GLFW.Functions.SetCursorEnterCallback, GLFW.Functions.SetScrollCallback, GLFW.Functions.SetDropCallback }, b = 0; b < 17; ) { long l1 = arrayOfLong[b];
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       long l2;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 54 */       if ((l2 = JNI.invokePPP(paramLong, 0L, l1)) != 0L)
/* 55 */         Callback.free(l2); 
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\Callbacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */