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
/*    */ public abstract class GLDebugMessageARBCallback
/*    */   extends Callback
/*    */   implements GLDebugMessageARBCallbackI
/*    */ {
/*    */   public static GLDebugMessageARBCallback create(long paramLong) {
/*    */     GLDebugMessageARBCallbackI gLDebugMessageARBCallbackI;
/* 39 */     return (gLDebugMessageARBCallbackI = (GLDebugMessageARBCallbackI)Callback.get(paramLong) instanceof GLDebugMessageARBCallback) ? (GLDebugMessageARBCallback)gLDebugMessageARBCallbackI : new Container(paramLong, gLDebugMessageARBCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLDebugMessageARBCallback createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLDebugMessageARBCallback create(GLDebugMessageARBCallbackI paramGLDebugMessageARBCallbackI) {
/* 52 */     return (paramGLDebugMessageARBCallbackI instanceof GLDebugMessageARBCallback) ? (GLDebugMessageARBCallback)paramGLDebugMessageARBCallbackI : new Container(paramGLDebugMessageARBCallbackI
/*    */         
/* 54 */         .address(), paramGLDebugMessageARBCallbackI);
/*    */   }
/*    */   
/*    */   protected GLDebugMessageARBCallback() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLDebugMessageARBCallback(long paramLong) {
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
/*    */     extends GLDebugMessageARBCallback {
/*    */     private final GLDebugMessageARBCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLDebugMessageARBCallbackI param1GLDebugMessageARBCallbackI) {
/* 84 */       super(param1Long);
/* 85 */       this.delegate = param1GLDebugMessageARBCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, long param1Long1, long param1Long2) {
/* 90 */       this.delegate.invoke(param1Int1, param1Int2, param1Int3, param1Int4, param1Int5, param1Long1, param1Long2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLDebugMessageARBCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */