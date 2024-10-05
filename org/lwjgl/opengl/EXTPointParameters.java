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
/*    */ public class EXTPointParameters
/*    */ {
/*    */   public static final int GL_POINT_SIZE_MIN_EXT = 33062;
/*    */   public static final int GL_POINT_SIZE_MAX_EXT = 33063;
/*    */   public static final int GL_POINT_FADE_THRESHOLD_SIZE_EXT = 33064;
/*    */   public static final int GL_DISTANCE_ATTENUATION_EXT = 33065;
/*    */   
/*    */   static {
/* 62 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTPointParameters() {
/* 72 */     throw new UnsupportedOperationException();
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
/*    */   public static void glPointParameterfvEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 84 */     if (Checks.CHECKS) {
/* 85 */       Checks.check(paramFloatBuffer, 1);
/*    */     }
/* 87 */     nglPointParameterfvEXT(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glPointParameterfvEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 92 */     long l = (GL.getICD()).glPointParameterfvEXT;
/* 93 */     if (Checks.CHECKS) {
/* 94 */       Checks.check(l);
/* 95 */       Checks.check(paramArrayOffloat, 1);
/*    */     } 
/* 97 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*    */   }
/*    */   
/*    */   public static native void glPointParameterfEXT(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*    */   
/*    */   public static native void nglPointParameterfvEXT(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTPointParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */