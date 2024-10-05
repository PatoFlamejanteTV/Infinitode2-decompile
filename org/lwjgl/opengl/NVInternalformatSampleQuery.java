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
/*    */ public class NVInternalformatSampleQuery
/*    */ {
/*    */   public static final int GL_MULTISAMPLES_NV = 37745;
/*    */   public static final int GL_SUPERSAMPLE_SCALE_X_NV = 37746;
/*    */   public static final int GL_SUPERSAMPLE_SCALE_Y_NV = 37747;
/*    */   public static final int GL_CONFORMANT_NV = 37748;
/*    */   
/*    */   static {
/* 46 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVInternalformatSampleQuery() {
/* 56 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetInternalformatSampleivNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 64 */     nglGetInternalformatSampleivNV(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetInternalformatSampleivNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") int[] paramArrayOfint) {
/* 69 */     long l = (GL.getICD()).glGetInternalformatSampleivNV;
/* 70 */     if (Checks.CHECKS) {
/* 71 */       Checks.check(l);
/*    */     }
/* 73 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint.length, paramArrayOfint, l);
/*    */   }
/*    */   
/*    */   public static native void nglGetInternalformatSampleivNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVInternalformatSampleQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */