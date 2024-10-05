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
/*    */ public abstract class GLDebugMessageAMDCallback
/*    */   extends Callback
/*    */   implements GLDebugMessageAMDCallbackI
/*    */ {
/*    */   public static GLDebugMessageAMDCallback create(long paramLong) {
/*    */     GLDebugMessageAMDCallbackI gLDebugMessageAMDCallbackI;
/* 38 */     return (gLDebugMessageAMDCallbackI = (GLDebugMessageAMDCallbackI)Callback.get(paramLong) instanceof GLDebugMessageAMDCallback) ? (GLDebugMessageAMDCallback)gLDebugMessageAMDCallbackI : new Container(paramLong, gLDebugMessageAMDCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLDebugMessageAMDCallback createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLDebugMessageAMDCallback create(GLDebugMessageAMDCallbackI paramGLDebugMessageAMDCallbackI) {
/* 51 */     return (paramGLDebugMessageAMDCallbackI instanceof GLDebugMessageAMDCallback) ? (GLDebugMessageAMDCallback)paramGLDebugMessageAMDCallbackI : new Container(paramGLDebugMessageAMDCallbackI
/*    */         
/* 53 */         .address(), paramGLDebugMessageAMDCallbackI);
/*    */   }
/*    */   
/*    */   protected GLDebugMessageAMDCallback() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   GLDebugMessageAMDCallback(long paramLong) {
/* 61 */     super(paramLong);
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
/* 75 */     return MemoryUtil.memUTF8(MemoryUtil.memByteBuffer(paramLong, paramInt));
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLDebugMessageAMDCallback {
/*    */     private final GLDebugMessageAMDCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, GLDebugMessageAMDCallbackI param1GLDebugMessageAMDCallbackI) {
/* 83 */       super(param1Long);
/* 84 */       this.delegate = param1GLDebugMessageAMDCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(int param1Int1, int param1Int2, int param1Int3, int param1Int4, long param1Long1, long param1Long2) {
/* 89 */       this.delegate.invoke(param1Int1, param1Int2, param1Int3, param1Int4, param1Long1, param1Long2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLDebugMessageAMDCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */