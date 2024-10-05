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
/*    */ public abstract class GLFWMouseButtonCallback
/*    */   extends Callback
/*    */   implements GLFWMouseButtonCallbackI
/*    */ {
/*    */   public static GLFWMouseButtonCallback create(long paramLong) {
/*    */     GLFWMouseButtonCallbackI gLFWMouseButtonCallbackI;
/* 38 */     return (gLFWMouseButtonCallbackI = (GLFWMouseButtonCallbackI)Callback.get(paramLong) instanceof GLFWMouseButtonCallback) ? (GLFWMouseButtonCallback)gLFWMouseButtonCallbackI : new Container(paramLong, gLFWMouseButtonCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWMouseButtonCallback createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWMouseButtonCallback create(GLFWMouseButtonCallbackI paramGLFWMouseButtonCallbackI) {
/* 51 */     return (paramGLFWMouseButtonCallbackI instanceof GLFWMouseButtonCallback) ? (GLFWMouseButtonCallback)paramGLFWMouseButtonCallbackI : new Container(paramGLFWMouseButtonCallbackI
/*    */         
/* 53 */         .address(), paramGLFWMouseButtonCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWMouseButtonCallback() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWMouseButtonCallback(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWMouseButtonCallback set(long paramLong) {
/* 66 */     GLFW.glfwSetMouseButtonCallback(paramLong, this);
/* 67 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWMouseButtonCallback {
/*    */     private final GLFWMouseButtonCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWMouseButtonCallbackI param1GLFWMouseButtonCallbackI) {
/* 75 */       super(param1Long);
/* 76 */       this.delegate = param1GLFWMouseButtonCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, int param1Int1, int param1Int2, int param1Int3) {
/* 81 */       this.delegate.invoke(param1Long, param1Int1, param1Int2, param1Int3);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWMouseButtonCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */