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
/*    */ public abstract class GLFWCharCallback
/*    */   extends Callback
/*    */   implements GLFWCharCallbackI
/*    */ {
/*    */   public static GLFWCharCallback create(long paramLong) {
/*    */     GLFWCharCallbackI gLFWCharCallbackI;
/* 38 */     return (gLFWCharCallbackI = (GLFWCharCallbackI)Callback.get(paramLong) instanceof GLFWCharCallback) ? (GLFWCharCallback)gLFWCharCallbackI : new Container(paramLong, gLFWCharCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWCharCallback createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWCharCallback create(GLFWCharCallbackI paramGLFWCharCallbackI) {
/* 51 */     return (paramGLFWCharCallbackI instanceof GLFWCharCallback) ? (GLFWCharCallback)paramGLFWCharCallbackI : new Container(paramGLFWCharCallbackI
/*    */         
/* 53 */         .address(), paramGLFWCharCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWCharCallback() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWCharCallback(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWCharCallback set(long paramLong) {
/* 66 */     GLFW.glfwSetCharCallback(paramLong, this);
/* 67 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWCharCallback {
/*    */     private final GLFWCharCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWCharCallbackI param1GLFWCharCallbackI) {
/* 75 */       super(param1Long);
/* 76 */       this.delegate = param1GLFWCharCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, int param1Int) {
/* 81 */       this.delegate.invoke(param1Long, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWCharCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */