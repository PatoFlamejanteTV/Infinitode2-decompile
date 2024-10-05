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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBPointParameters
/*    */ {
/*    */   public static final int GL_POINT_SIZE_MIN_ARB = 33062;
/*    */   public static final int GL_POINT_SIZE_MAX_ARB = 33063;
/*    */   public static final int GL_POINT_FADE_THRESHOLD_SIZE_ARB = 33064;
/*    */   public static final int GL_POINT_DISTANCE_ATTENUATION_ARB = 33065;
/*    */   
/*    */   static {
/* 37 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBPointParameters() {
/* 47 */     throw new UnsupportedOperationException();
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
/*    */   public static void glPointParameterfvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 72 */     if (Checks.CHECKS) {
/* 73 */       Checks.check(paramFloatBuffer, 3);
/*    */     }
/* 75 */     nglPointParameterfvARB(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glPointParameterfvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 80 */     long l = (GL.getICD()).glPointParameterfvARB;
/* 81 */     if (Checks.CHECKS) {
/* 82 */       Checks.check(l);
/* 83 */       Checks.check(paramArrayOffloat, 3);
/*    */     } 
/* 85 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*    */   }
/*    */   
/*    */   public static native void glPointParameterfARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*    */   
/*    */   public static native void nglPointParameterfvARB(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBPointParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */