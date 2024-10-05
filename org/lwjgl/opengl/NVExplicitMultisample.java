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
/*    */ public class NVExplicitMultisample
/*    */ {
/*    */   public static final int GL_SAMPLE_POSITION_NV = 36432;
/*    */   public static final int GL_SAMPLE_MASK_NV = 36433;
/*    */   public static final int GL_SAMPLE_MASK_VALUE_NV = 36434;
/*    */   public static final int GL_TEXTURE_BINDING_RENDERBUFFER_NV = 36435;
/*    */   public static final int GL_TEXTURE_RENDERBUFFER_DATA_STORE_BINDING_NV = 36436;
/*    */   public static final int GL_MAX_SAMPLE_MASK_WORDS_NV = 36441;
/*    */   public static final int GL_TEXTURE_RENDERBUFFER_NV = 36437;
/*    */   public static final int GL_SAMPLER_RENDERBUFFER_NV = 36438;
/*    */   public static final int GL_INT_SAMPLER_RENDERBUFFER_NV = 36439;
/*    */   public static final int GL_UNSIGNED_INT_SAMPLER_RENDERBUFFER_NV = 36440;
/*    */   
/*    */   static {
/* 34 */     GL.initialize();
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVExplicitMultisample() {
/* 64 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetMultisamplefvNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 72 */     if (Checks.CHECKS) {
/* 73 */       Checks.check(paramFloatBuffer, 2);
/*    */     }
/* 75 */     nglGetMultisamplefvNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*    */   public static void glGetMultisamplefvNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 88 */     long l = (GL.getICD()).glGetMultisamplefvNV;
/* 89 */     if (Checks.CHECKS) {
/* 90 */       Checks.check(l);
/* 91 */       Checks.check(paramArrayOffloat, 2);
/*    */     } 
/* 93 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*    */   }
/*    */   
/*    */   public static native void nglGetMultisamplefvNV(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void glSampleMaskIndexedNV(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2);
/*    */   
/*    */   public static native void glTexRenderbufferNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVExplicitMultisample.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */