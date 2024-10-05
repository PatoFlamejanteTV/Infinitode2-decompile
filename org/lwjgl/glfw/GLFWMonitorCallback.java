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
/*    */ public abstract class GLFWMonitorCallback
/*    */   extends Callback
/*    */   implements GLFWMonitorCallbackI
/*    */ {
/*    */   public static GLFWMonitorCallback create(long paramLong) {
/*    */     GLFWMonitorCallbackI gLFWMonitorCallbackI;
/* 38 */     return (gLFWMonitorCallbackI = (GLFWMonitorCallbackI)Callback.get(paramLong) instanceof GLFWMonitorCallback) ? (GLFWMonitorCallback)gLFWMonitorCallbackI : new Container(paramLong, gLFWMonitorCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWMonitorCallback createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWMonitorCallback create(GLFWMonitorCallbackI paramGLFWMonitorCallbackI) {
/* 51 */     return (paramGLFWMonitorCallbackI instanceof GLFWMonitorCallback) ? (GLFWMonitorCallback)paramGLFWMonitorCallbackI : new Container(paramGLFWMonitorCallbackI
/*    */         
/* 53 */         .address(), paramGLFWMonitorCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWMonitorCallback() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWMonitorCallback(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWMonitorCallback set() {
/* 66 */     GLFW.glfwSetMonitorCallback(this);
/* 67 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWMonitorCallback {
/*    */     private final GLFWMonitorCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWMonitorCallbackI param1GLFWMonitorCallbackI) {
/* 75 */       super(param1Long);
/* 76 */       this.delegate = param1GLFWMonitorCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, int param1Int) {
/* 81 */       this.delegate.invoke(param1Long, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWMonitorCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */