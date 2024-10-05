/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBCLEvent
/*    */ {
/*    */   public static final int GL_SYNC_CL_EVENT_ARB = 33344;
/*    */   public static final int GL_SYNC_CL_EVENT_COMPLETE_ARB = 33345;
/*    */   
/*    */   static {
/* 23 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBCLEvent() {
/* 32 */     throw new UnsupportedOperationException();
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("GLsync")
/*    */   public static long glCreateSyncFromCLeventARB(@NativeType("cl_context") long paramLong1, @NativeType("cl_event") long paramLong2, @NativeType("GLbitfield") int paramInt) {
/* 58 */     if (Checks.CHECKS) {
/* 59 */       Checks.check(paramLong1);
/* 60 */       Checks.check(paramLong2);
/*    */     } 
/* 62 */     return nglCreateSyncFromCLeventARB(paramLong1, paramLong2, paramInt);
/*    */   }
/*    */   
/*    */   public static native long nglCreateSyncFromCLeventARB(long paramLong1, long paramLong2, int paramInt);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBCLEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */