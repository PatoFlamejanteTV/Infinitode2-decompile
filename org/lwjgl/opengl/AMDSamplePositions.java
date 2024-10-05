/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.FloatBuffer;
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
/*    */ public class AMDSamplePositions
/*    */ {
/*    */   public static final int GL_SUBSAMPLE_DISTANCE_AMD = 34879;
/*    */   
/*    */   static {
/* 28 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected AMDSamplePositions() {
/* 34 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glSetMultisamplefvAMD(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 42 */     if (Checks.CHECKS) {
/* 43 */       Checks.check(paramFloatBuffer, 2);
/*    */     }
/* 45 */     nglSetMultisamplefvAMD(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glSetMultisamplefvAMD(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 50 */     long l = (GL.getICD()).glSetMultisamplefvAMD;
/* 51 */     if (Checks.CHECKS) {
/* 52 */       Checks.check(l);
/* 53 */       Checks.check(paramArrayOffloat, 2);
/*    */     } 
/* 55 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*    */   }
/*    */   
/*    */   public static native void nglSetMultisamplefvAMD(int paramInt1, int paramInt2, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\AMDSamplePositions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */