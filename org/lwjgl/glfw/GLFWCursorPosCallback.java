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
/*    */ public abstract class GLFWCursorPosCallback
/*    */   extends Callback
/*    */   implements GLFWCursorPosCallbackI
/*    */ {
/*    */   public static GLFWCursorPosCallback create(long paramLong) {
/*    */     GLFWCursorPosCallbackI gLFWCursorPosCallbackI;
/* 39 */     return (gLFWCursorPosCallbackI = (GLFWCursorPosCallbackI)Callback.get(paramLong) instanceof GLFWCursorPosCallback) ? (GLFWCursorPosCallback)gLFWCursorPosCallbackI : new Container(paramLong, gLFWCursorPosCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWCursorPosCallback createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWCursorPosCallback create(GLFWCursorPosCallbackI paramGLFWCursorPosCallbackI) {
/* 52 */     return (paramGLFWCursorPosCallbackI instanceof GLFWCursorPosCallback) ? (GLFWCursorPosCallback)paramGLFWCursorPosCallbackI : new Container(paramGLFWCursorPosCallbackI
/*    */         
/* 54 */         .address(), paramGLFWCursorPosCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWCursorPosCallback() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWCursorPosCallback(long paramLong) {
/* 62 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWCursorPosCallback set(long paramLong) {
/* 67 */     GLFW.glfwSetCursorPosCallback(paramLong, this);
/* 68 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWCursorPosCallback {
/*    */     private final GLFWCursorPosCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWCursorPosCallbackI param1GLFWCursorPosCallbackI) {
/* 76 */       super(param1Long);
/* 77 */       this.delegate = param1GLFWCursorPosCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, double param1Double1, double param1Double2) {
/* 82 */       this.delegate.invoke(param1Long, param1Double1, param1Double2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWCursorPosCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */