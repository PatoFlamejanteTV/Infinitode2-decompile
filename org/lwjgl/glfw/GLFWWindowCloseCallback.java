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
/*    */ public abstract class GLFWWindowCloseCallback
/*    */   extends Callback
/*    */   implements GLFWWindowCloseCallbackI
/*    */ {
/*    */   public static GLFWWindowCloseCallback create(long paramLong) {
/*    */     GLFWWindowCloseCallbackI gLFWWindowCloseCallbackI;
/* 37 */     return (gLFWWindowCloseCallbackI = (GLFWWindowCloseCallbackI)Callback.get(paramLong) instanceof GLFWWindowCloseCallback) ? (GLFWWindowCloseCallback)gLFWWindowCloseCallbackI : new Container(paramLong, gLFWWindowCloseCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowCloseCallback createSafe(long paramLong) {
/* 45 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowCloseCallback create(GLFWWindowCloseCallbackI paramGLFWWindowCloseCallbackI) {
/* 50 */     return (paramGLFWWindowCloseCallbackI instanceof GLFWWindowCloseCallback) ? (GLFWWindowCloseCallback)paramGLFWWindowCloseCallbackI : new Container(paramGLFWWindowCloseCallbackI
/*    */         
/* 52 */         .address(), paramGLFWWindowCloseCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWWindowCloseCallback() {
/* 56 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWWindowCloseCallback(long paramLong) {
/* 60 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowCloseCallback set(long paramLong) {
/* 65 */     GLFW.glfwSetWindowCloseCallback(paramLong, this);
/* 66 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowCloseCallback {
/*    */     private final GLFWWindowCloseCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWWindowCloseCallbackI param1GLFWWindowCloseCallbackI) {
/* 74 */       super(param1Long);
/* 75 */       this.delegate = param1GLFWWindowCloseCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long) {
/* 80 */       this.delegate.invoke(param1Long);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWWindowCloseCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */