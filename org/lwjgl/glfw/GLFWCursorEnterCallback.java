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
/*    */ public abstract class GLFWCursorEnterCallback
/*    */   extends Callback
/*    */   implements GLFWCursorEnterCallbackI
/*    */ {
/*    */   public static GLFWCursorEnterCallback create(long paramLong) {
/*    */     GLFWCursorEnterCallbackI gLFWCursorEnterCallbackI;
/* 38 */     return (gLFWCursorEnterCallbackI = (GLFWCursorEnterCallbackI)Callback.get(paramLong) instanceof GLFWCursorEnterCallback) ? (GLFWCursorEnterCallback)gLFWCursorEnterCallbackI : new Container(paramLong, gLFWCursorEnterCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWCursorEnterCallback createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWCursorEnterCallback create(GLFWCursorEnterCallbackI paramGLFWCursorEnterCallbackI) {
/* 51 */     return (paramGLFWCursorEnterCallbackI instanceof GLFWCursorEnterCallback) ? (GLFWCursorEnterCallback)paramGLFWCursorEnterCallbackI : new Container(paramGLFWCursorEnterCallbackI
/*    */         
/* 53 */         .address(), paramGLFWCursorEnterCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWCursorEnterCallback() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWCursorEnterCallback(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWCursorEnterCallback set(long paramLong) {
/* 66 */     GLFW.glfwSetCursorEnterCallback(paramLong, this);
/* 67 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWCursorEnterCallback {
/*    */     private final GLFWCursorEnterCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWCursorEnterCallbackI param1GLFWCursorEnterCallbackI) {
/* 75 */       super(param1Long);
/* 76 */       this.delegate = param1GLFWCursorEnterCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, boolean param1Boolean) {
/* 81 */       this.delegate.invoke(param1Long, param1Boolean);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWCursorEnterCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */