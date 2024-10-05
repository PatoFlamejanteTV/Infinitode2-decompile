/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ public abstract class GLDebugMessageCallback
/*    */   extends Callback
/*    */   implements GLDebugMessageCallbackI
/*    */ {
/*    */   public static GLDebugMessageCallback create(long paramLong) {
/*    */     GLDebugMessageCallbackI gLDebugMessageCallbackI;
/* 39 */     return (gLDebugMessageCallbackI = (GLDebugMessageCallbackI)Callback.get(paramLong) instanceof GLDebugMessageCallback) ? (GLDebugMessageCallback)gLDebugMessageCallbackI : new Container(paramLong, gLDebugMessageCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLDebugMessageCallback createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLDebugMessageCallback create(GLDebugMessageCallbackI paramGLDebugMessageCallbackI) {
/* 52 */     return (paramGLDebugMessageCallbackI instanceof GLDebugMessageCallback) ? (GLDebugMessageCallback)paramGLDebugMessageCallbackI : new Container(paramGLDebugMessageCallbackI
/*    */         
/* 54 */         .address(), paramGLDebugMessageCallbackI);
/*    */   }
/*    */   
/*    */   protected GLDebugMessageCallback() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLDebugMessageCallback(long paramLong) {
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
/*    */   public static String getMessage(int paramInt, long paramLong) {
/* 76 */     return MemoryUtil.memUTF8(MemoryUtil.memByteBuffer(paramLong, paramInt));
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLDebugMessageCallback {
/*    */     private final GLDebugMessageCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLDebugMessageCallbackI param1GLDebugMessageCallbackI) {
/* 84 */       super(param1Long);
/* 85 */       this.delegate = param1GLDebugMessageCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, long param1Long1, long param1Long2) {
/* 90 */       this.delegate.invoke(param1Int1, param1Int2, param1Int3, param1Int4, param1Int5, param1Long1, param1Long2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLDebugMessageCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */