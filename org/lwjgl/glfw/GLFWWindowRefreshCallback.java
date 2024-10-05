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
/*    */ public abstract class GLFWWindowRefreshCallback
/*    */   extends Callback
/*    */   implements GLFWWindowRefreshCallbackI
/*    */ {
/*    */   public static GLFWWindowRefreshCallback create(long paramLong) {
/*    */     GLFWWindowRefreshCallbackI gLFWWindowRefreshCallbackI;
/* 37 */     return (gLFWWindowRefreshCallbackI = (GLFWWindowRefreshCallbackI)Callback.get(paramLong) instanceof GLFWWindowRefreshCallback) ? (GLFWWindowRefreshCallback)gLFWWindowRefreshCallbackI : new Container(paramLong, gLFWWindowRefreshCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowRefreshCallback createSafe(long paramLong) {
/* 45 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowRefreshCallback create(GLFWWindowRefreshCallbackI paramGLFWWindowRefreshCallbackI) {
/* 50 */     return (paramGLFWWindowRefreshCallbackI instanceof GLFWWindowRefreshCallback) ? (GLFWWindowRefreshCallback)paramGLFWWindowRefreshCallbackI : new Container(paramGLFWWindowRefreshCallbackI
/*    */         
/* 52 */         .address(), paramGLFWWindowRefreshCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWWindowRefreshCallback() {
/* 56 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWWindowRefreshCallback(long paramLong) {
/* 60 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowRefreshCallback set(long paramLong) {
/* 65 */     GLFW.glfwSetWindowRefreshCallback(paramLong, this);
/* 66 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowRefreshCallback {
/*    */     private final GLFWWindowRefreshCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWWindowRefreshCallbackI param1GLFWWindowRefreshCallbackI) {
/* 74 */       super(param1Long);
/* 75 */       this.delegate = param1GLFWWindowRefreshCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long) {
/* 80 */       this.delegate.invoke(param1Long);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWWindowRefreshCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */