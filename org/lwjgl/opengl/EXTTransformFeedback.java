/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
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
/*     */ public class EXTTransformFeedback
/*     */ {
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_EXT = 35982;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_EXT = 35972;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_EXT = 35973;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_EXT = 35983;
/*     */   public static final int GL_INTERLEAVED_ATTRIBS_EXT = 35980;
/*     */   public static final int GL_SEPARATE_ATTRIBS_EXT = 35981;
/*     */   public static final int GL_PRIMITIVES_GENERATED_EXT = 35975;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_EXT = 35976;
/*     */   public static final int GL_RASTERIZER_DISCARD_EXT = 35977;
/*     */   public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_EXT = 35978;
/*     */   public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_EXT = 35979;
/*     */   public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_EXT = 35968;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_EXT = 35971;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_EXT = 35967;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH_EXT = 35958;
/*     */   
/*     */   static {
/*  45 */     GL.initialize();
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
/*     */   protected EXTTransformFeedback() {
/*  93 */     throw new UnsupportedOperationException();
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
/*     */   public static void glTransformFeedbackVaryingsEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLenum") int paramInt2) {
/* 121 */     nglTransformFeedbackVaryingsEXT(paramInt1, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramInt2);
/*     */   }
/*     */   public static void glTransformFeedbackVaryingsEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLchar const * const *") CharSequence[] paramArrayOfCharSequence, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 125 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 127 */       long l = APIUtil.apiArray(memoryStack, MemoryUtil::memASCII, paramArrayOfCharSequence);
/* 128 */       nglTransformFeedbackVaryingsEXT(paramInt1, paramArrayOfCharSequence.length, l, paramInt2);
/* 129 */       APIUtil.apiArrayFree(l, paramArrayOfCharSequence.length); return;
/*     */     } finally {
/* 131 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */   public static void glTransformFeedbackVaryingsEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLchar const * const *") CharSequence paramCharSequence, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 136 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 138 */       long l = APIUtil.apiArray(memoryStack, MemoryUtil::memASCII, new CharSequence[] { paramCharSequence });
/* 139 */       nglTransformFeedbackVaryingsEXT(paramInt1, 1, l, paramInt2);
/* 140 */       APIUtil.apiArrayFree(l, 1); return;
/*     */     } finally {
/* 142 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetTransformFeedbackVaryingEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLsizei *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 151 */     if (Checks.CHECKS) {
/* 152 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 153 */       Checks.check(paramIntBuffer2, 1);
/* 154 */       Checks.check(paramIntBuffer3, 1);
/*     */     } 
/* 156 */     nglGetTransformFeedbackVaryingEXT(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetTransformFeedbackVaryingEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 161 */     if (Checks.CHECKS) {
/* 162 */       Checks.check(paramIntBuffer1, 1);
/* 163 */       Checks.check(paramIntBuffer2, 1);
/*     */     }  MemoryStack memoryStack;
/* 165 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 167 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 168 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt3);
/* 169 */       nglGetTransformFeedbackVaryingEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(byteBuffer));
/* 170 */       return MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
/*     */     } finally {
/* 172 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetTransformFeedbackVaryingEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 178 */     return glGetTransformFeedbackVaryingEXT(paramInt1, paramInt2, (GL.getCapabilities()).OpenGL20 ? 
/* 179 */         GL20.glGetProgrami(paramInt1, 35958) : 
/* 180 */         ARBShaderObjects.glGetObjectParameteriARB(paramInt1, 35958), paramIntBuffer1, paramIntBuffer2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetIntegerIndexedvEXT(int paramInt1, int paramInt2, long paramLong) {
/* 186 */     EXTDrawBuffers2.nglGetIntegerIndexedvEXT(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glGetIntegerIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 190 */     EXTDrawBuffers2.glGetIntegerIndexedvEXT(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetIntegerIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 195 */     return EXTDrawBuffers2.glGetIntegerIndexedEXT(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetBooleanIndexedvEXT(int paramInt1, int paramInt2, long paramLong) {
/* 201 */     EXTDrawBuffers2.nglGetBooleanIndexedvEXT(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glGetBooleanIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLboolean *") ByteBuffer paramByteBuffer) {
/* 205 */     EXTDrawBuffers2.glGetBooleanIndexedvEXT(paramInt1, paramInt2, paramByteBuffer);
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static boolean glGetBooleanIndexedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 210 */     return EXTDrawBuffers2.glGetBooleanIndexedEXT(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTransformFeedbackVaryingEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLsizei *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 215 */     long l = (GL.getICD()).glGetTransformFeedbackVaryingEXT;
/* 216 */     if (Checks.CHECKS) {
/* 217 */       Checks.check(l);
/* 218 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 219 */       Checks.check(paramArrayOfint2, 1);
/* 220 */       Checks.check(paramArrayOfint3, 1);
/*     */     } 
/* 222 */     JNI.callPPPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, MemoryUtil.memAddress(paramByteBuffer), l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetIntegerIndexedvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 227 */     EXTDrawBuffers2.glGetIntegerIndexedvEXT(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */   
/*     */   public static native void glBindBufferRangeEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*     */   
/*     */   public static native void glBindBufferOffsetEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong);
/*     */   
/*     */   public static native void glBindBufferBaseEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glBeginTransformFeedbackEXT(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glEndTransformFeedbackEXT();
/*     */   
/*     */   public static native void nglTransformFeedbackVaryingsEXT(int paramInt1, int paramInt2, long paramLong, int paramInt3);
/*     */   
/*     */   public static native void nglGetTransformFeedbackVaryingEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTTransformFeedback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */