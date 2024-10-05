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
/*    */ public abstract class GLFWAllocateCallback
/*    */   extends Callback
/*    */   implements GLFWAllocateCallbackI
/*    */ {
/*    */   public static GLFWAllocateCallback create(long paramLong) {
/*    */     GLFWAllocateCallbackI gLFWAllocateCallbackI;
/* 59 */     return (gLFWAllocateCallbackI = (GLFWAllocateCallbackI)Callback.get(paramLong) instanceof GLFWAllocateCallback) ? (GLFWAllocateCallback)gLFWAllocateCallbackI : new Container(paramLong, gLFWAllocateCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWAllocateCallback createSafe(long paramLong) {
/* 67 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWAllocateCallback create(GLFWAllocateCallbackI paramGLFWAllocateCallbackI) {
/* 72 */     return (paramGLFWAllocateCallbackI instanceof GLFWAllocateCallback) ? (GLFWAllocateCallback)paramGLFWAllocateCallbackI : new Container(paramGLFWAllocateCallbackI
/*    */         
/* 74 */         .address(), paramGLFWAllocateCallbackI);
/*    */   }
/*    */   
/*    */   protected GLFWAllocateCallback() {
/* 78 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLFWAllocateCallback(long paramLong) {
/* 82 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWAllocateCallback {
/*    */     private final GLFWAllocateCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLFWAllocateCallbackI param1GLFWAllocateCallbackI) {
/* 90 */       super(param1Long);
/* 91 */       this.delegate = param1GLFWAllocateCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final long invoke(long param1Long1, long param1Long2) {
/* 96 */       return this.delegate.invoke(param1Long1, param1Long2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWAllocateCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */