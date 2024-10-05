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
/*    */ 
/*    */ public abstract class GLFWFramebufferSizeCallback
/*    */   extends Callback
/*    */   implements GLFWFramebufferSizeCallbackI
/*    */ {
/*    */   public static GLFWFramebufferSizeCallback create(long paramLong) {
/*    */     GLFWFramebufferSizeCallbackI gLFWFramebufferSizeCallbackI;
/* 39 */     return (gLFWFramebufferSizeCallbackI = (GLFWFramebufferSizeCallbackI)Callback.get(paramLong) instanceof GLFWFramebufferSizeCallback) ? (GLFWFramebufferSizeCallback)gLFWFramebufferSizeCallbackI : new Container(paramLong, gLFWFramebufferSizeCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWFramebufferSizeCallback createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWFramebufferSizeCallback create(GLFWFramebufferSizeCallbackI paramGLFWFramebufferSizeCallbackI) {
/* 52 */     return (paramGLFWFramebufferSizeCallbackI instanceof GLFWFramebufferSizeCallback) ? (GLFWFramebufferSizeCallback)paramGLFWFramebufferSizeCallbackI : new Container(paramGLFWFramebufferSizeCallbackI
/*    */         
/* 54 */         .address(), paramGLFWFramebufferSizeCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWFramebufferSizeCallback() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWFramebufferSizeCallback(long paramLong) {
/* 62 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWFramebufferSizeCallback set(long paramLong) {
/* 67 */     GLFW.glfwSetFramebufferSizeCallback(paramLong, this);
/* 68 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWFramebufferSizeCallback {
/*    */     private final GLFWFramebufferSizeCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWFramebufferSizeCallbackI param1GLFWFramebufferSizeCallbackI) {
/* 76 */       super(param1Long);
/* 77 */       this.delegate = param1GLFWFramebufferSizeCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, int param1Int1, int param1Int2) {
/* 82 */       this.delegate.invoke(param1Long, param1Int1, param1Int2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWFramebufferSizeCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */