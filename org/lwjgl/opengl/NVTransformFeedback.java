/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVTransformFeedback
/*     */ {
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_NV = 35982;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_NV = 35972;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_NV = 35973;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_RECORD_NV = 35974;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_NV = 35983;
/*     */   public static final int GL_INTERLEAVED_ATTRIBS_NV = 35980;
/*     */   public static final int GL_SEPARATE_ATTRIBS_NV = 35981;
/*     */   public static final int GL_PRIMITIVES_GENERATED_NV = 35975;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_NV = 35976;
/*     */   public static final int GL_RASTERIZER_DISCARD_NV = 35977;
/*     */   public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_NV = 35978;
/*     */   public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_NV = 35979;
/*     */   public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_NV = 35968;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_ATTRIBS_NV = 35966;
/*     */   public static final int GL_ACTIVE_VARYINGS_NV = 35969;
/*     */   public static final int GL_ACTIVE_VARYING_MAX_LENGTH_NV = 35970;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_NV = 35971;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_NV = 35967;
/*     */   public static final int GL_BACK_PRIMARY_COLOR_NV = 35959;
/*     */   public static final int GL_BACK_SECONDARY_COLOR_NV = 35960;
/*     */   public static final int GL_TEXTURE_COORD_NV = 35961;
/*     */   public static final int GL_CLIP_DISTANCE_NV = 35962;
/*     */   public static final int GL_VERTEX_ID_NV = 35963;
/*     */   public static final int GL_PRIMITIVE_ID_NV = 35964;
/*     */   public static final int GL_GENERIC_ATTRIB_NV = 35965;
/*     */   public static final int GL_SECONDARY_COLOR_NV = 34093;
/*     */   public static final int GL_LAYER_NV = 36266;
/*     */   
/*     */   static {
/*  44 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected NVTransformFeedback() {
/* 109 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTransformFeedbackAttribsNV(@NativeType("GLint const *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt) {
/* 125 */     nglTransformFeedbackAttribsNV(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTransformFeedbackVaryingsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint const *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt2) {
/* 145 */     nglTransformFeedbackVaryingsNV(paramInt1, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glActiveVaryingNV(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 153 */     if (Checks.CHECKS) {
/* 154 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 156 */     nglActiveVaryingNV(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   public static void glActiveVaryingNV(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 160 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 162 */       memoryStack.nASCII(paramCharSequence, true);
/* 163 */       long l = memoryStack.getPointerAddress();
/* 164 */       nglActiveVaryingNV(paramInt, l); return;
/*     */     } finally {
/* 166 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetVaryingLocationNV(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 176 */     if (Checks.CHECKS) {
/* 177 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 179 */     return nglGetVaryingLocationNV(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   @NativeType("GLint")
/*     */   public static int glGetVaryingLocationNV(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 184 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 186 */       memoryStack.nASCII(paramCharSequence, true);
/* 187 */       long l = memoryStack.getPointerAddress();
/* 188 */       paramInt = nglGetVaryingLocationNV(paramInt, l); return paramInt;
/*     */     } finally {
/* 190 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveVaryingNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLsizei *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 201 */       Checks.check(paramIntBuffer2, 1);
/* 202 */       Checks.check(paramIntBuffer3, 1);
/*     */     } 
/* 204 */     nglGetActiveVaryingNV(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetTransformFeedbackVaryingNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 212 */     if (Checks.CHECKS) {
/* 213 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 215 */     nglGetTransformFeedbackVaryingNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetTransformFeedbackVaryingNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 220 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 222 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 223 */       nglGetTransformFeedbackVaryingNV(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 224 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 226 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTransformFeedbackStreamAttribsNV(@NativeType("GLint const *") IntBuffer paramIntBuffer1, @NativeType("GLint const *") IntBuffer paramIntBuffer2, @NativeType("GLenum") int paramInt) {
/* 235 */     nglTransformFeedbackStreamAttribsNV(paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), paramIntBuffer2.remaining(), MemoryUtil.memAddress(paramIntBuffer2), paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTransformFeedbackAttribsNV(@NativeType("GLint const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt) {
/* 240 */     long l = (GL.getICD()).glTransformFeedbackAttribsNV;
/* 241 */     if (Checks.CHECKS) {
/* 242 */       Checks.check(l);
/*     */     }
/* 244 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, paramInt, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTransformFeedbackVaryingsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt2) {
/* 249 */     long l = (GL.getICD()).glTransformFeedbackVaryingsNV;
/* 250 */     if (Checks.CHECKS) {
/* 251 */       Checks.check(l);
/*     */     }
/* 253 */     JNI.callPV(paramInt1, paramArrayOfint.length, paramArrayOfint, paramInt2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveVaryingNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLsizei *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 258 */     long l = (GL.getICD()).glGetActiveVaryingNV;
/* 259 */     if (Checks.CHECKS) {
/* 260 */       Checks.check(l);
/* 261 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 262 */       Checks.check(paramArrayOfint2, 1);
/* 263 */       Checks.check(paramArrayOfint3, 1);
/*     */     } 
/* 265 */     JNI.callPPPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, MemoryUtil.memAddress(paramByteBuffer), l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTransformFeedbackVaryingNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 270 */     long l = (GL.getICD()).glGetTransformFeedbackVaryingNV;
/* 271 */     if (Checks.CHECKS) {
/* 272 */       Checks.check(l);
/* 273 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 275 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTransformFeedbackStreamAttribsNV(@NativeType("GLint const *") int[] paramArrayOfint1, @NativeType("GLint const *") int[] paramArrayOfint2, @NativeType("GLenum") int paramInt) {
/* 280 */     long l = (GL.getICD()).glTransformFeedbackStreamAttribsNV;
/* 281 */     if (Checks.CHECKS) {
/* 282 */       Checks.check(l);
/*     */     }
/* 284 */     JNI.callPPV(paramArrayOfint1.length, paramArrayOfint1, paramArrayOfint2.length, paramArrayOfint2, paramInt, l);
/*     */   }
/*     */   
/*     */   public static native void glBeginTransformFeedbackNV(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glEndTransformFeedbackNV();
/*     */   
/*     */   public static native void nglTransformFeedbackAttribsNV(int paramInt1, long paramLong, int paramInt2);
/*     */   
/*     */   public static native void glBindBufferRangeNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*     */   
/*     */   public static native void glBindBufferOffsetNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong);
/*     */   
/*     */   public static native void glBindBufferBaseNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void nglTransformFeedbackVaryingsNV(int paramInt1, int paramInt2, long paramLong, int paramInt3);
/*     */   
/*     */   public static native void nglActiveVaryingNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native int nglGetVaryingLocationNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetActiveVaryingNV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native void nglGetTransformFeedbackVaryingNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglTransformFeedbackStreamAttribsNV(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVTransformFeedback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */