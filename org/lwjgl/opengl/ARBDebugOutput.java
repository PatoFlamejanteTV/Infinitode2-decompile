/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
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
/*     */ public class ARBDebugOutput
/*     */ {
/*     */   public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS_ARB = 33346;
/*     */   public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_ARB = 37187;
/*     */   public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_ARB = 37188;
/*     */   public static final int GL_DEBUG_LOGGED_MESSAGES_ARB = 37189;
/*     */   public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_ARB = 33347;
/*     */   public static final int GL_DEBUG_CALLBACK_FUNCTION_ARB = 33348;
/*     */   public static final int GL_DEBUG_CALLBACK_USER_PARAM_ARB = 33349;
/*     */   public static final int GL_DEBUG_SOURCE_API_ARB = 33350;
/*     */   public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM_ARB = 33351;
/*     */   public static final int GL_DEBUG_SOURCE_SHADER_COMPILER_ARB = 33352;
/*     */   public static final int GL_DEBUG_SOURCE_THIRD_PARTY_ARB = 33353;
/*     */   public static final int GL_DEBUG_SOURCE_APPLICATION_ARB = 33354;
/*     */   public static final int GL_DEBUG_SOURCE_OTHER_ARB = 33355;
/*     */   public static final int GL_DEBUG_TYPE_ERROR_ARB = 33356;
/*     */   public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB = 33357;
/*     */   public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB = 33358;
/*     */   public static final int GL_DEBUG_TYPE_PORTABILITY_ARB = 33359;
/*     */   public static final int GL_DEBUG_TYPE_PERFORMANCE_ARB = 33360;
/*     */   public static final int GL_DEBUG_TYPE_OTHER_ARB = 33361;
/*     */   public static final int GL_DEBUG_SEVERITY_HIGH_ARB = 37190;
/*     */   public static final int GL_DEBUG_SEVERITY_MEDIUM_ARB = 37191;
/*     */   public static final int GL_DEBUG_SEVERITY_LOW_ARB = 37192;
/*     */   
/*     */   static {
/*  64 */     GL.initialize();
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
/*     */   protected ARBDebugOutput() {
/* 143 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDebugMessageControlARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLboolean") boolean paramBoolean) {
/* 183 */     nglDebugMessageControlARB(paramInt1, paramInt2, paramInt3, Checks.remainingSafe(paramIntBuffer), MemoryUtil.memAddressSafe(paramIntBuffer), paramBoolean);
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
/*     */   public static void glDebugMessageControlARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") int paramInt4, @NativeType("GLboolean") boolean paramBoolean) {
/*     */     MemoryStack memoryStack;
/* 213 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 215 */       IntBuffer intBuffer = memoryStack.ints(paramInt4);
/* 216 */       nglDebugMessageControlARB(paramInt1, paramInt2, paramInt3, 1, MemoryUtil.memAddress(intBuffer), paramBoolean); return;
/*     */     } finally {
/* 218 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void glDebugMessageInsertARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 245 */     nglDebugMessageInsertARB(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glDebugMessageInsertARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 262 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 264 */       int j = memoryStack.nUTF8(paramCharSequence, false);
/* 265 */       long l = memoryStack.getPointerAddress();
/* 266 */       nglDebugMessageInsertARB(paramInt1, paramInt2, paramInt3, paramInt4, j, l); return;
/*     */     } finally {
/* 268 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void glDebugMessageCallbackARB(@NativeType("GLDEBUGPROCARB") GLDebugMessageARBCallbackI paramGLDebugMessageARBCallbackI, @NativeType("void const *") long paramLong) {
/* 316 */     nglDebugMessageCallbackARB(MemoryUtil.memAddressSafe((Pointer)paramGLDebugMessageARBCallbackI), paramLong);
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
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLogARB(@NativeType("GLuint") int paramInt, @NativeType("GLenum *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2, @NativeType("GLuint *") IntBuffer paramIntBuffer3, @NativeType("GLenum *") IntBuffer paramIntBuffer4, @NativeType("GLsizei *") IntBuffer paramIntBuffer5, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 359 */     if (Checks.CHECKS) {
/* 360 */       Checks.checkSafe(paramIntBuffer1, paramInt);
/* 361 */       Checks.checkSafe(paramIntBuffer2, paramInt);
/* 362 */       Checks.checkSafe(paramIntBuffer3, paramInt);
/* 363 */       Checks.checkSafe(paramIntBuffer4, paramInt);
/* 364 */       Checks.checkSafe(paramIntBuffer5, paramInt);
/*     */     } 
/* 366 */     return nglGetDebugMessageLogARB(paramInt, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4), MemoryUtil.memAddressSafe(paramIntBuffer5), MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageControlARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLboolean") boolean paramBoolean) {
/* 371 */     long l = (GL.getICD()).glDebugMessageControlARB;
/* 372 */     if (Checks.CHECKS) {
/* 373 */       Checks.check(l);
/*     */     }
/* 375 */     JNI.callPV(paramInt1, paramInt2, paramInt3, Checks.lengthSafe(paramArrayOfint), paramArrayOfint, paramBoolean, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLogARB(@NativeType("GLuint") int paramInt, @NativeType("GLenum *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2, @NativeType("GLuint *") int[] paramArrayOfint3, @NativeType("GLenum *") int[] paramArrayOfint4, @NativeType("GLsizei *") int[] paramArrayOfint5, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 381 */     long l = (GL.getICD()).glGetDebugMessageLogARB;
/* 382 */     if (Checks.CHECKS) {
/* 383 */       Checks.check(l);
/* 384 */       Checks.checkSafe(paramArrayOfint1, paramInt);
/* 385 */       Checks.checkSafe(paramArrayOfint2, paramInt);
/* 386 */       Checks.checkSafe(paramArrayOfint3, paramInt);
/* 387 */       Checks.checkSafe(paramArrayOfint4, paramInt);
/* 388 */       Checks.checkSafe(paramArrayOfint5, paramInt);
/*     */     } 
/* 390 */     return JNI.callPPPPPPI(paramInt, Checks.remainingSafe(paramByteBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, paramArrayOfint5, MemoryUtil.memAddressSafe(paramByteBuffer), l);
/*     */   }
/*     */   
/*     */   public static native void nglDebugMessageControlARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean);
/*     */   
/*     */   public static native void nglDebugMessageInsertARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*     */   
/*     */   public static native void nglDebugMessageCallbackARB(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nglGetDebugMessageLogARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBDebugOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */