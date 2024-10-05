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
/*    */ public abstract class GLFWWindowFocusCallback
/*    */   extends Callback
/*    */   implements GLFWWindowFocusCallbackI
/*    */ {
/*    */   public static GLFWWindowFocusCallback create(long paramLong) {
/*    */     GLFWWindowFocusCallbackI gLFWWindowFocusCallbackI;
/* 38 */     return (gLFWWindowFocusCallbackI = (GLFWWindowFocusCallbackI)Callback.get(paramLong) instanceof GLFWWindowFocusCallback) ? (GLFWWindowFocusCallback)gLFWWindowFocusCallbackI : new Container(paramLong, gLFWWindowFocusCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowFocusCallback createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowFocusCallback create(GLFWWindowFocusCallbackI paramGLFWWindowFocusCallbackI) {
/* 51 */     return (paramGLFWWindowFocusCallbackI instanceof GLFWWindowFocusCallback) ? (GLFWWindowFocusCallback)paramGLFWWindowFocusCallbackI : new Container(paramGLFWWindowFocusCallbackI
/*    */         
/* 53 */         .address(), paramGLFWWindowFocusCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWWindowFocusCallback() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWWindowFocusCallback(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowFocusCallback set(long paramLong) {
/* 66 */     GLFW.glfwSetWindowFocusCallback(paramLong, this);
/* 67 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowFocusCallback {
/*    */     private final GLFWWindowFocusCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWWindowFocusCallbackI param1GLFWWindowFocusCallbackI) {
/* 75 */       super(param1Long);
/* 76 */       this.delegate = param1GLFWWindowFocusCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, boolean param1Boolean) {
/* 81 */       this.delegate.invoke(param1Long, param1Boolean);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWWindowFocusCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */