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
/*    */ public abstract class GLFWReallocateCallback
/*    */   extends Callback
/*    */   implements GLFWReallocateCallbackI
/*    */ {
/*    */   public static GLFWReallocateCallback create(long paramLong) {
/*    */     GLFWReallocateCallbackI gLFWReallocateCallbackI;
/* 61 */     return (gLFWReallocateCallbackI = (GLFWReallocateCallbackI)Callback.get(paramLong) instanceof GLFWReallocateCallback) ? (GLFWReallocateCallback)gLFWReallocateCallbackI : new Container(paramLong, gLFWReallocateCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWReallocateCallback createSafe(long paramLong) {
/* 69 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWReallocateCallback create(GLFWReallocateCallbackI paramGLFWReallocateCallbackI) {
/* 74 */     return (paramGLFWReallocateCallbackI instanceof GLFWReallocateCallback) ? (GLFWReallocateCallback)paramGLFWReallocateCallbackI : new Container(paramGLFWReallocateCallbackI
/*    */         
/* 76 */         .address(), paramGLFWReallocateCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWReallocateCallback() {
/* 80 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWReallocateCallback(long paramLong) {
/* 84 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWReallocateCallback {
/*    */     private final GLFWReallocateCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWReallocateCallbackI param1GLFWReallocateCallbackI) {
/* 92 */       super(param1Long);
/* 93 */       this.delegate = param1GLFWReallocateCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final long invoke(long param1Long1, long param1Long2, long param1Long3) {
/* 98 */       return this.delegate.invoke(param1Long1, param1Long2, param1Long3);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWReallocateCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */