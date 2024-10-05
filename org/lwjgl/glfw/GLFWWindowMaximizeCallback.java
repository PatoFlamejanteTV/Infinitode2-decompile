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
/*    */ public abstract class GLFWWindowMaximizeCallback
/*    */   extends Callback
/*    */   implements GLFWWindowMaximizeCallbackI
/*    */ {
/*    */   public static GLFWWindowMaximizeCallback create(long paramLong) {
/*    */     GLFWWindowMaximizeCallbackI gLFWWindowMaximizeCallbackI;
/* 38 */     return (gLFWWindowMaximizeCallbackI = (GLFWWindowMaximizeCallbackI)Callback.get(paramLong) instanceof GLFWWindowMaximizeCallback) ? (GLFWWindowMaximizeCallback)gLFWWindowMaximizeCallbackI : new Container(paramLong, gLFWWindowMaximizeCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowMaximizeCallback createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowMaximizeCallback create(GLFWWindowMaximizeCallbackI paramGLFWWindowMaximizeCallbackI) {
/* 51 */     return (paramGLFWWindowMaximizeCallbackI instanceof GLFWWindowMaximizeCallback) ? (GLFWWindowMaximizeCallback)paramGLFWWindowMaximizeCallbackI : new Container(paramGLFWWindowMaximizeCallbackI
/*    */         
/* 53 */         .address(), paramGLFWWindowMaximizeCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWWindowMaximizeCallback() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWWindowMaximizeCallback(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowMaximizeCallback set(long paramLong) {
/* 66 */     GLFW.glfwSetWindowMaximizeCallback(paramLong, this);
/* 67 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowMaximizeCallback {
/*    */     private final GLFWWindowMaximizeCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWWindowMaximizeCallbackI param1GLFWWindowMaximizeCallbackI) {
/* 75 */       super(param1Long);
/* 76 */       this.delegate = param1GLFWWindowMaximizeCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, boolean param1Boolean) {
/* 81 */       this.delegate.invoke(param1Long, param1Boolean);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWWindowMaximizeCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */