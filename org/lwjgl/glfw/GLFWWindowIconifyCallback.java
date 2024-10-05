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
/*    */ public abstract class GLFWWindowIconifyCallback
/*    */   extends Callback
/*    */   implements GLFWWindowIconifyCallbackI
/*    */ {
/*    */   public static GLFWWindowIconifyCallback create(long paramLong) {
/*    */     GLFWWindowIconifyCallbackI gLFWWindowIconifyCallbackI;
/* 38 */     return (gLFWWindowIconifyCallbackI = (GLFWWindowIconifyCallbackI)Callback.get(paramLong) instanceof GLFWWindowIconifyCallback) ? (GLFWWindowIconifyCallback)gLFWWindowIconifyCallbackI : new Container(paramLong, gLFWWindowIconifyCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowIconifyCallback createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowIconifyCallback create(GLFWWindowIconifyCallbackI paramGLFWWindowIconifyCallbackI) {
/* 51 */     return (paramGLFWWindowIconifyCallbackI instanceof GLFWWindowIconifyCallback) ? (GLFWWindowIconifyCallback)paramGLFWWindowIconifyCallbackI : new Container(paramGLFWWindowIconifyCallbackI
/*    */         
/* 53 */         .address(), paramGLFWWindowIconifyCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWWindowIconifyCallback() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWWindowIconifyCallback(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowIconifyCallback set(long paramLong) {
/* 66 */     GLFW.glfwSetWindowIconifyCallback(paramLong, this);
/* 67 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowIconifyCallback {
/*    */     private final GLFWWindowIconifyCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWWindowIconifyCallbackI param1GLFWWindowIconifyCallbackI) {
/* 75 */       super(param1Long);
/* 76 */       this.delegate = param1GLFWWindowIconifyCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, boolean param1Boolean) {
/* 81 */       this.delegate.invoke(param1Long, param1Boolean);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWWindowIconifyCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */