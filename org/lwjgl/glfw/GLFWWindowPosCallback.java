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
/*    */ public abstract class GLFWWindowPosCallback
/*    */   extends Callback
/*    */   implements GLFWWindowPosCallbackI
/*    */ {
/*    */   public static GLFWWindowPosCallback create(long paramLong) {
/*    */     GLFWWindowPosCallbackI gLFWWindowPosCallbackI;
/* 39 */     return (gLFWWindowPosCallbackI = (GLFWWindowPosCallbackI)Callback.get(paramLong) instanceof GLFWWindowPosCallback) ? (GLFWWindowPosCallback)gLFWWindowPosCallbackI : new Container(paramLong, gLFWWindowPosCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowPosCallback createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowPosCallback create(GLFWWindowPosCallbackI paramGLFWWindowPosCallbackI) {
/* 52 */     return (paramGLFWWindowPosCallbackI instanceof GLFWWindowPosCallback) ? (GLFWWindowPosCallback)paramGLFWWindowPosCallbackI : new Container(paramGLFWWindowPosCallbackI
/*    */         
/* 54 */         .address(), paramGLFWWindowPosCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWWindowPosCallback() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWWindowPosCallback(long paramLong) {
/* 62 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowPosCallback set(long paramLong) {
/* 67 */     GLFW.glfwSetWindowPosCallback(paramLong, this);
/* 68 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowPosCallback {
/*    */     private final GLFWWindowPosCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWWindowPosCallbackI param1GLFWWindowPosCallbackI) {
/* 76 */       super(param1Long);
/* 77 */       this.delegate = param1GLFWWindowPosCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, int param1Int1, int param1Int2) {
/* 82 */       this.delegate.invoke(param1Long, param1Int1, param1Int2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWWindowPosCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */