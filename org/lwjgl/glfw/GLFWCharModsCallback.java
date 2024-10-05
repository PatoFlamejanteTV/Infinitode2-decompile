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
/*    */ 
/*    */ 
/*    */ public abstract class GLFWCharModsCallback
/*    */   extends Callback
/*    */   implements GLFWCharModsCallbackI
/*    */ {
/*    */   public static GLFWCharModsCallback create(long paramLong) {
/*    */     GLFWCharModsCallbackI gLFWCharModsCallbackI;
/* 41 */     return (gLFWCharModsCallbackI = (GLFWCharModsCallbackI)Callback.get(paramLong) instanceof GLFWCharModsCallback) ? (GLFWCharModsCallback)gLFWCharModsCallbackI : new Container(paramLong, gLFWCharModsCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWCharModsCallback createSafe(long paramLong) {
/* 49 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWCharModsCallback create(GLFWCharModsCallbackI paramGLFWCharModsCallbackI) {
/* 54 */     return (paramGLFWCharModsCallbackI instanceof GLFWCharModsCallback) ? (GLFWCharModsCallback)paramGLFWCharModsCallbackI : new Container(paramGLFWCharModsCallbackI
/*    */         
/* 56 */         .address(), paramGLFWCharModsCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWCharModsCallback() {
/* 60 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWCharModsCallback(long paramLong) {
/* 64 */     super(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWCharModsCallback set(long paramLong) {
/* 69 */     GLFW.glfwSetCharModsCallback(paramLong, this);
/* 70 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWCharModsCallback {
/*    */     private final GLFWCharModsCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWCharModsCallbackI param1GLFWCharModsCallbackI) {
/* 78 */       super(param1Long);
/* 79 */       this.delegate = param1GLFWCharModsCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, int param1Int1, int param1Int2) {
/* 84 */       this.delegate.invoke(param1Long, param1Int1, param1Int2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWCharModsCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */