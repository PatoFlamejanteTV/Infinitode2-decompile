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
/*    */ public abstract class GLFWScrollCallback
/*    */   extends Callback
/*    */   implements GLFWScrollCallbackI
/*    */ {
/*    */   public static GLFWScrollCallback create(long paramLong) {
/*    */     GLFWScrollCallbackI gLFWScrollCallbackI;
/* 39 */     return (gLFWScrollCallbackI = (GLFWScrollCallbackI)Callback.get(paramLong) instanceof GLFWScrollCallback) ? (GLFWScrollCallback)gLFWScrollCallbackI : new Container(paramLong, gLFWScrollCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWScrollCallback createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWScrollCallback create(GLFWScrollCallbackI paramGLFWScrollCallbackI) {
/* 52 */     return (paramGLFWScrollCallbackI instanceof GLFWScrollCallback) ? (GLFWScrollCallback)paramGLFWScrollCallbackI : new Container(paramGLFWScrollCallbackI
/*    */         
/* 54 */         .address(), paramGLFWScrollCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWScrollCallback() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWScrollCallback(long paramLong) {
/* 62 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWScrollCallback set(long paramLong) {
/* 67 */     GLFW.glfwSetScrollCallback(paramLong, this);
/* 68 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWScrollCallback {
/*    */     private final GLFWScrollCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWScrollCallbackI param1GLFWScrollCallbackI) {
/* 76 */       super(param1Long);
/* 77 */       this.delegate = param1GLFWScrollCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, double param1Double1, double param1Double2) {
/* 82 */       this.delegate.invoke(param1Long, param1Double1, param1Double2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWScrollCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */