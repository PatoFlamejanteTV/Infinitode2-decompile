/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.Pointer;
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
/*    */ public abstract class GLFWDropCallback
/*    */   extends Callback
/*    */   implements GLFWDropCallbackI
/*    */ {
/*    */   public static GLFWDropCallback create(long paramLong) {
/*    */     GLFWDropCallbackI gLFWDropCallbackI;
/* 39 */     return (gLFWDropCallbackI = (GLFWDropCallbackI)Callback.get(paramLong) instanceof GLFWDropCallback) ? (GLFWDropCallback)gLFWDropCallbackI : new Container(paramLong, gLFWDropCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWDropCallback createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWDropCallback create(GLFWDropCallbackI paramGLFWDropCallbackI) {
/* 52 */     return (paramGLFWDropCallbackI instanceof GLFWDropCallback) ? (GLFWDropCallback)paramGLFWDropCallbackI : new Container(paramGLFWDropCallbackI
/*    */         
/* 54 */         .address(), paramGLFWDropCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWDropCallback() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWDropCallback(long paramLong) {
/* 62 */     super(paramLong);
/*    */   }
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
/*    */   public static String getName(long paramLong, int paramInt) {
/* 76 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(paramLong + (Pointer.POINTER_SIZE * paramInt)));
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWDropCallback set(long paramLong) {
/* 81 */     GLFW.glfwSetDropCallback(paramLong, this);
/* 82 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWDropCallback {
/*    */     private final GLFWDropCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWDropCallbackI param1GLFWDropCallbackI) {
/* 90 */       super(param1Long);
/* 91 */       this.delegate = param1GLFWDropCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long1, int param1Int, long param1Long2) {
/* 96 */       this.delegate.invoke(param1Long1, param1Int, param1Long2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWDropCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */