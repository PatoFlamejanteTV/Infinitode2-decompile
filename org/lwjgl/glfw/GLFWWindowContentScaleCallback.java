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
/*    */ public abstract class GLFWWindowContentScaleCallback
/*    */   extends Callback
/*    */   implements GLFWWindowContentScaleCallbackI
/*    */ {
/*    */   public static GLFWWindowContentScaleCallback create(long paramLong) {
/*    */     GLFWWindowContentScaleCallbackI gLFWWindowContentScaleCallbackI;
/* 39 */     return (gLFWWindowContentScaleCallbackI = (GLFWWindowContentScaleCallbackI)Callback.get(paramLong) instanceof GLFWWindowContentScaleCallback) ? (GLFWWindowContentScaleCallback)gLFWWindowContentScaleCallbackI : new Container(paramLong, gLFWWindowContentScaleCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowContentScaleCallback createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowContentScaleCallback create(GLFWWindowContentScaleCallbackI paramGLFWWindowContentScaleCallbackI) {
/* 52 */     return (paramGLFWWindowContentScaleCallbackI instanceof GLFWWindowContentScaleCallback) ? (GLFWWindowContentScaleCallback)paramGLFWWindowContentScaleCallbackI : new Container(paramGLFWWindowContentScaleCallbackI
/*    */         
/* 54 */         .address(), paramGLFWWindowContentScaleCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWWindowContentScaleCallback() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWWindowContentScaleCallback(long paramLong) {
/* 62 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowContentScaleCallback set(long paramLong) {
/* 67 */     GLFW.glfwSetWindowContentScaleCallback(paramLong, this);
/* 68 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowContentScaleCallback {
/*    */     private final GLFWWindowContentScaleCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWWindowContentScaleCallbackI param1GLFWWindowContentScaleCallbackI) {
/* 76 */       super(param1Long);
/* 77 */       this.delegate = param1GLFWWindowContentScaleCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, float param1Float1, float param1Float2) {
/* 82 */       this.delegate.invoke(param1Long, param1Float1, param1Float2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWWindowContentScaleCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */