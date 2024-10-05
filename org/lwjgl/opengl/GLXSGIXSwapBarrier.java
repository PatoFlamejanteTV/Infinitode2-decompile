/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GLXSGIXSwapBarrier
/*    */ {
/*    */   protected GLXSGIXSwapBarrier() {
/* 26 */     throw new UnsupportedOperationException();
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
/*    */   public static void glXBindSwapBarrierSGIX(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, int paramInt) {
/* 40 */     long l = (GL.getCapabilitiesGLXClient()).glXBindSwapBarrierSGIX;
/* 41 */     if (Checks.CHECKS) {
/* 42 */       Checks.check(l);
/* 43 */       Checks.check(paramLong1);
/* 44 */       Checks.check(paramLong2);
/*    */     } 
/* 46 */     JNI.callPPV(paramLong1, paramLong2, paramInt, l);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int nglXQueryMaxSwapBarriersSGIX(long paramLong1, int paramInt, long paramLong2) {
/* 53 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryMaxSwapBarriersSGIX;
/* 54 */     if (Checks.CHECKS) {
/* 55 */       Checks.check(l);
/* 56 */       Checks.check(paramLong1);
/*    */     } 
/* 58 */     return JNI.callPPI(paramLong1, paramInt, paramLong2, l);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("Bool")
/*    */   public static boolean glXQueryMaxSwapBarriersSGIX(@NativeType("Display *") long paramLong, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer) {
/* 70 */     if (Checks.CHECKS) {
/* 71 */       Checks.check(paramIntBuffer, 1);
/*    */     }
/* 73 */     return (nglXQueryMaxSwapBarriersSGIX(paramLong, paramInt, MemoryUtil.memAddress(paramIntBuffer)) != 0);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("Bool")
/*    */   public static boolean glXQueryMaxSwapBarriersSGIX(@NativeType("Display *") long paramLong, int paramInt, @NativeType("int *") int[] paramArrayOfint) {
/* 79 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryMaxSwapBarriersSGIX;
/* 80 */     if (Checks.CHECKS) {
/* 81 */       Checks.check(l);
/* 82 */       Checks.check(paramLong);
/* 83 */       Checks.check(paramArrayOfint, 1);
/*    */     } 
/* 85 */     return (JNI.callPPI(paramLong, paramInt, paramArrayOfint, l) != 0);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXSGIXSwapBarrier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */