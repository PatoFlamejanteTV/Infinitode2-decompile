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
/*     */ public class AMDDebugOutput
/*     */ {
/*     */   public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_AMD = 37187;
/*     */   public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_AMD = 37188;
/*     */   public static final int GL_DEBUG_LOGGED_MESSAGES_AMD = 37189;
/*     */   public static final int GL_DEBUG_SEVERITY_HIGH_AMD = 37190;
/*     */   public static final int GL_DEBUG_SEVERITY_MEDIUM_AMD = 37191;
/*     */   public static final int GL_DEBUG_SEVERITY_LOW_AMD = 37192;
/*     */   public static final int GL_DEBUG_CATEGORY_API_ERROR_AMD = 37193;
/*     */   public static final int GL_DEBUG_CATEGORY_WINDOW_SYSTEM_AMD = 37194;
/*     */   public static final int GL_DEBUG_CATEGORY_DEPRECATION_AMD = 37195;
/*     */   public static final int GL_DEBUG_CATEGORY_UNDEFINED_BEHAVIOR_AMD = 37196;
/*     */   public static final int GL_DEBUG_CATEGORY_PERFORMANCE_AMD = 37197;
/*     */   public static final int GL_DEBUG_CATEGORY_SHADER_COMPILER_AMD = 37198;
/*     */   public static final int GL_DEBUG_CATEGORY_APPLICATION_AMD = 37199;
/*     */   public static final int GL_DEBUG_CATEGORY_OTHER_AMD = 37200;
/*     */   
/*     */   static {
/*  52 */     GL.initialize();
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
/*     */   protected AMDDebugOutput() {
/*  81 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDebugMessageEnableAMD(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLboolean") boolean paramBoolean) {
/* 129 */     nglDebugMessageEnableAMD(paramInt1, paramInt2, Checks.remainingSafe(paramIntBuffer), MemoryUtil.memAddressSafe(paramIntBuffer), paramBoolean);
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
/*     */   public static void glDebugMessageEnableAMD(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int paramInt3, @NativeType("GLboolean") boolean paramBoolean) {
/*     */     MemoryStack memoryStack;
/* 167 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 169 */       IntBuffer intBuffer = memoryStack.ints(paramInt3);
/* 170 */       nglDebugMessageEnableAMD(paramInt1, paramInt2, 1, MemoryUtil.memAddress(intBuffer), paramBoolean); return;
/*     */     } finally {
/* 172 */       memoryStack.setPointer(i);
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
/*     */   public static void glDebugMessageInsertAMD(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 202 */     nglDebugMessageInsertAMD(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glDebugMessageInsertAMD(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 222 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 224 */       int j = memoryStack.nUTF8(paramCharSequence, false);
/* 225 */       long l = memoryStack.getPointerAddress();
/* 226 */       nglDebugMessageInsertAMD(paramInt1, paramInt2, paramInt3, j, l); return;
/*     */     } finally {
/* 228 */       memoryStack.setPointer(i);
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
/*     */   public static void glDebugMessageCallbackAMD(@NativeType("GLDEBUGPROCAMD") GLDebugMessageAMDCallbackI paramGLDebugMessageAMDCallbackI, @NativeType("void *") long paramLong) {
/* 265 */     nglDebugMessageCallbackAMD(MemoryUtil.memAddressSafe((Pointer)paramGLDebugMessageAMDCallbackI), paramLong);
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
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLogAMD(@NativeType("GLuint") int paramInt, @NativeType("GLenum *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2, @NativeType("GLuint *") IntBuffer paramIntBuffer3, @NativeType("GLsizei *") IntBuffer paramIntBuffer4, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 303 */     if (Checks.CHECKS) {
/* 304 */       Checks.checkSafe(paramIntBuffer1, paramInt);
/* 305 */       Checks.checkSafe(paramIntBuffer2, paramInt);
/* 306 */       Checks.checkSafe(paramIntBuffer3, paramInt);
/* 307 */       Checks.checkSafe(paramIntBuffer4, paramInt);
/*     */     } 
/* 309 */     return nglGetDebugMessageLogAMD(paramInt, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer3), MemoryUtil.memAddressSafe(paramIntBuffer4), MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDebugMessageEnableAMD(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLboolean") boolean paramBoolean) {
/* 314 */     long l = (GL.getICD()).glDebugMessageEnableAMD;
/* 315 */     if (Checks.CHECKS) {
/* 316 */       Checks.check(l);
/*     */     }
/* 318 */     JNI.callPV(paramInt1, paramInt2, Checks.lengthSafe(paramArrayOfint), paramArrayOfint, paramBoolean, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetDebugMessageLogAMD(@NativeType("GLuint") int paramInt, @NativeType("GLenum *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2, @NativeType("GLuint *") int[] paramArrayOfint3, @NativeType("GLsizei *") int[] paramArrayOfint4, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 324 */     long l = (GL.getICD()).glGetDebugMessageLogAMD;
/* 325 */     if (Checks.CHECKS) {
/* 326 */       Checks.check(l);
/* 327 */       Checks.checkSafe(paramArrayOfint1, paramInt);
/* 328 */       Checks.checkSafe(paramArrayOfint2, paramInt);
/* 329 */       Checks.checkSafe(paramArrayOfint3, paramInt);
/* 330 */       Checks.checkSafe(paramArrayOfint4, paramInt);
/*     */     } 
/* 332 */     return JNI.callPPPPPI(paramInt, Checks.remainingSafe(paramByteBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, MemoryUtil.memAddressSafe(paramByteBuffer), l);
/*     */   }
/*     */   
/*     */   public static native void nglDebugMessageEnableAMD(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean);
/*     */   
/*     */   public static native void nglDebugMessageInsertAMD(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglDebugMessageCallbackAMD(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nglGetDebugMessageLogAMD(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\AMDDebugOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */