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
/*    */ public abstract class GLFWKeyCallback
/*    */   extends Callback
/*    */   implements GLFWKeyCallbackI
/*    */ {
/*    */   public static GLFWKeyCallback create(long paramLong) {
/*    */     GLFWKeyCallbackI gLFWKeyCallbackI;
/* 39 */     return (gLFWKeyCallbackI = (GLFWKeyCallbackI)Callback.get(paramLong) instanceof GLFWKeyCallback) ? (GLFWKeyCallback)gLFWKeyCallbackI : new Container(paramLong, gLFWKeyCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWKeyCallback createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWKeyCallback create(GLFWKeyCallbackI paramGLFWKeyCallbackI) {
/* 52 */     return (paramGLFWKeyCallbackI instanceof GLFWKeyCallback) ? (GLFWKeyCallback)paramGLFWKeyCallbackI : new Container(paramGLFWKeyCallbackI
/*    */         
/* 54 */         .address(), paramGLFWKeyCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWKeyCallback() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWKeyCallback(long paramLong) {
/* 62 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWKeyCallback set(long paramLong) {
/* 67 */     GLFW.glfwSetKeyCallback(paramLong, this);
/* 68 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWKeyCallback {
/*    */     private final GLFWKeyCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWKeyCallbackI param1GLFWKeyCallbackI) {
/* 76 */       super(param1Long);
/* 77 */       this.delegate = param1GLFWKeyCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 82 */       this.delegate.invoke(param1Long, param1Int1, param1Int2, param1Int3, param1Int4);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWKeyCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */