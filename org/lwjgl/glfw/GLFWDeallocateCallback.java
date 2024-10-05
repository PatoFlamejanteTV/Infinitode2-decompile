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
/*    */ public abstract class GLFWDeallocateCallback
/*    */   extends Callback
/*    */   implements GLFWDeallocateCallbackI
/*    */ {
/*    */   public static GLFWDeallocateCallback create(long paramLong) {
/*    */     GLFWDeallocateCallbackI gLFWDeallocateCallbackI;
/* 56 */     return (gLFWDeallocateCallbackI = (GLFWDeallocateCallbackI)Callback.get(paramLong) instanceof GLFWDeallocateCallback) ? (GLFWDeallocateCallback)gLFWDeallocateCallbackI : new Container(paramLong, gLFWDeallocateCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWDeallocateCallback createSafe(long paramLong) {
/* 64 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWDeallocateCallback create(GLFWDeallocateCallbackI paramGLFWDeallocateCallbackI) {
/* 69 */     return (paramGLFWDeallocateCallbackI instanceof GLFWDeallocateCallback) ? (GLFWDeallocateCallback)paramGLFWDeallocateCallbackI : new Container(paramGLFWDeallocateCallbackI
/*    */         
/* 71 */         .address(), paramGLFWDeallocateCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWDeallocateCallback() {
/* 75 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWDeallocateCallback(long paramLong) {
/* 79 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWDeallocateCallback {
/*    */     private final GLFWDeallocateCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWDeallocateCallbackI param1GLFWDeallocateCallbackI) {
/* 87 */       super(param1Long);
/* 88 */       this.delegate = param1GLFWDeallocateCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long1, long param1Long2) {
/* 93 */       this.delegate.invoke(param1Long1, param1Long2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWDeallocateCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */