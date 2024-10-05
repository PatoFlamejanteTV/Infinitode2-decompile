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
/*    */ public abstract class GLFWWindowSizeCallback
/*    */   extends Callback
/*    */   implements GLFWWindowSizeCallbackI
/*    */ {
/*    */   public static GLFWWindowSizeCallback create(long paramLong) {
/*    */     GLFWWindowSizeCallbackI gLFWWindowSizeCallbackI;
/* 37 */     return (gLFWWindowSizeCallbackI = (GLFWWindowSizeCallbackI)Callback.get(paramLong) instanceof GLFWWindowSizeCallback) ? (GLFWWindowSizeCallback)gLFWWindowSizeCallbackI : new Container(paramLong, gLFWWindowSizeCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowSizeCallback createSafe(long paramLong) {
/* 45 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowSizeCallback create(GLFWWindowSizeCallbackI paramGLFWWindowSizeCallbackI) {
/* 50 */     return (paramGLFWWindowSizeCallbackI instanceof GLFWWindowSizeCallback) ? (GLFWWindowSizeCallback)paramGLFWWindowSizeCallbackI : new Container(paramGLFWWindowSizeCallbackI
/*    */         
/* 52 */         .address(), paramGLFWWindowSizeCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWWindowSizeCallback() {
/* 56 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWWindowSizeCallback(long paramLong) {
/* 60 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowSizeCallback set(long paramLong) {
/* 65 */     GLFW.glfwSetWindowSizeCallback(paramLong, this);
/* 66 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowSizeCallback {
/*    */     private final GLFWWindowSizeCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWWindowSizeCallbackI param1GLFWWindowSizeCallbackI) {
/* 74 */       super(param1Long);
/* 75 */       this.delegate = param1GLFWWindowSizeCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, int param1Int1, int param1Int2) {
/* 80 */       this.delegate.invoke(param1Long, param1Int1, param1Int2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWWindowSizeCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */