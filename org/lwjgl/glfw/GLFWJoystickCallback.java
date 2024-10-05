/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class GLFWJoystickCallback
/*    */   extends Callback
/*    */   implements GLFWJoystickCallbackI
/*    */ {
/*    */   public static GLFWJoystickCallback create(long paramLong) {
/*    */     GLFWJoystickCallbackI gLFWJoystickCallbackI;
/* 38 */     return (gLFWJoystickCallbackI = (GLFWJoystickCallbackI)Callback.get(paramLong) instanceof GLFWJoystickCallback) ? (GLFWJoystickCallback)gLFWJoystickCallbackI : new Container(paramLong, gLFWJoystickCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWJoystickCallback createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWJoystickCallback create(GLFWJoystickCallbackI paramGLFWJoystickCallbackI) {
/* 51 */     return (paramGLFWJoystickCallbackI instanceof GLFWJoystickCallback) ? (GLFWJoystickCallback)paramGLFWJoystickCallbackI : new Container(paramGLFWJoystickCallbackI
/*    */         
/* 53 */         .address(), paramGLFWJoystickCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWJoystickCallback() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWJoystickCallback(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWJoystickCallback set() {
/* 66 */     GLFW.glfwSetJoystickCallback(this);
/* 67 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWJoystickCallback {
/*    */     private final GLFWJoystickCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWJoystickCallbackI param1GLFWJoystickCallbackI) {
/* 75 */       super(param1Long);
/* 76 */       this.delegate = param1GLFWJoystickCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(int param1Int1, int param1Int2) {
/* 81 */       this.delegate.invoke(param1Int1, param1Int2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWJoystickCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */