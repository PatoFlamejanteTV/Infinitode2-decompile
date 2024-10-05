/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBShadingLanguageInclude
/*     */ {
/*     */   public static final int GL_SHADER_INCLUDE_ARB = 36270;
/*     */   public static final int GL_NAMED_STRING_LENGTH_ARB = 36329;
/*     */   public static final int GL_NAMED_STRING_TYPE_ARB = 36330;
/*     */   
/*     */   static {
/*  77 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBShadingLanguageInclude() {
/*  88 */     throw new UnsupportedOperationException();
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
/*     */   public static void glNamedStringARB(@NativeType("GLenum") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer1, @NativeType("GLchar const *") ByteBuffer paramByteBuffer2) {
/* 112 */     nglNamedStringARB(paramInt, paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer2.remaining(), MemoryUtil.memAddress(paramByteBuffer2));
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
/*     */   public static void glNamedStringARB(@NativeType("GLenum") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence1, @NativeType("GLchar const *") CharSequence paramCharSequence2) {
/*     */     MemoryStack memoryStack;
/* 126 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 128 */       int j = memoryStack.nASCII(paramCharSequence1, false);
/* 129 */       long l1 = memoryStack.getPointerAddress();
/* 130 */       int k = memoryStack.nUTF8(paramCharSequence2, false);
/* 131 */       long l2 = memoryStack.getPointerAddress();
/* 132 */       nglNamedStringARB(paramInt, j, l1, k, l2); return;
/*     */     } finally {
/* 134 */       memoryStack.setPointer(i);
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
/*     */   public static void glDeleteNamedStringARB(@NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 153 */     nglDeleteNamedStringARB(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteNamedStringARB(@NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 162 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 164 */       int j = memoryStack.nASCII(paramCharSequence, false);
/* 165 */       long l = memoryStack.getPointerAddress();
/* 166 */       nglDeleteNamedStringARB(j, l); return;
/*     */     } finally {
/* 168 */       memoryStack.setPointer(i);
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
/*     */   public static void glCompileShaderIncludeARB(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 189 */     if (Checks.CHECKS) {
/* 190 */       Checks.checkSafe(paramIntBuffer, paramPointerBuffer.remaining());
/*     */     }
/* 192 */     nglCompileShaderIncludeARB(paramInt, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe(paramIntBuffer));
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
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsNamedStringARB(@NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 212 */     return nglIsNamedStringARB(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsNamedStringARB(@NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 223 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 225 */       int j = memoryStack.nASCII(paramCharSequence, false);
/* 226 */       long l = memoryStack.getPointerAddress();
/* 227 */       return nglIsNamedStringARB(j, l);
/*     */     } finally {
/* 229 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetNamedStringARB(@NativeType("GLchar const *") ByteBuffer paramByteBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer2) {
/* 252 */     if (Checks.CHECKS) {
/* 253 */       Checks.checkSafe(paramIntBuffer, 1);
/*     */     }
/* 255 */     nglGetNamedStringARB(paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer2.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer2));
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
/*     */   public static void glGetNamedStringARB(@NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLint *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 267 */     if (Checks.CHECKS)
/* 268 */       Checks.checkSafe(paramIntBuffer, 1); 
/*     */     MemoryStack memoryStack;
/* 270 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 272 */       int j = memoryStack.nASCII(paramCharSequence, false);
/* 273 */       long l = memoryStack.getPointerAddress();
/* 274 */       nglGetNamedStringARB(j, l, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer)); return;
/*     */     } finally {
/* 276 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetNamedStringARB(@NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLsizei") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 288 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 290 */       int j = memoryStack.nASCII(paramCharSequence, false);
/* 291 */       long l = memoryStack.getPointerAddress();
/* 292 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 293 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt);
/* 294 */       nglGetNamedStringARB(j, l, paramInt, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 295 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*     */     } finally {
/* 297 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetNamedStringARB(@NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 308 */     return glGetNamedStringARB(paramCharSequence, glGetNamedStringiARB(paramCharSequence, 36329));
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
/*     */   public static void glGetNamedStringivARB(@NativeType("GLchar const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 328 */     if (Checks.CHECKS) {
/* 329 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 331 */     nglGetNamedStringivARB(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringivARB(@NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLenum") int paramInt, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 342 */     if (Checks.CHECKS)
/* 343 */       Checks.check(paramIntBuffer, 1); 
/*     */     MemoryStack memoryStack;
/* 345 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 347 */       int j = memoryStack.nASCII(paramCharSequence, false);
/* 348 */       long l = memoryStack.getPointerAddress();
/* 349 */       nglGetNamedStringivARB(j, l, paramInt, MemoryUtil.memAddress(paramIntBuffer)); return;
/*     */     } finally {
/* 351 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetNamedStringiARB(@NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLenum") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 363 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 365 */       int j = memoryStack.nASCII(paramCharSequence, false);
/* 366 */       long l = memoryStack.getPointerAddress();
/* 367 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 368 */       nglGetNamedStringivARB(j, l, paramInt, MemoryUtil.memAddress(intBuffer));
/* 369 */       j = intBuffer.get(0); return j;
/*     */     } finally {
/* 371 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCompileShaderIncludeARB(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 377 */     long l = (GL.getICD()).glCompileShaderIncludeARB;
/* 378 */     if (Checks.CHECKS) {
/* 379 */       Checks.check(l);
/* 380 */       Checks.checkSafe(paramArrayOfint, paramPointerBuffer.remaining());
/*     */     } 
/* 382 */     JNI.callPPV(paramInt, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringARB(@NativeType("GLchar const *") ByteBuffer paramByteBuffer1, @NativeType("GLint *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer2) {
/* 387 */     long l = (GL.getICD()).glGetNamedStringARB;
/* 388 */     if (Checks.CHECKS) {
/* 389 */       Checks.check(l);
/* 390 */       Checks.checkSafe(paramArrayOfint, 1);
/*     */     } 
/* 392 */     JNI.callPPPV(paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer2.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer2), l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringARB(@NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLint *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 397 */     long l = (GL.getICD()).glGetNamedStringARB;
/* 398 */     if (Checks.CHECKS) {
/* 399 */       Checks.check(l);
/* 400 */       Checks.checkSafe(paramArrayOfint, 1);
/*     */     }  MemoryStack memoryStack;
/* 402 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 404 */       int j = memoryStack.nASCII(paramCharSequence, false);
/* 405 */       long l1 = memoryStack.getPointerAddress();
/* 406 */       JNI.callPPPV(j, l1, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l); return;
/*     */     } finally {
/* 408 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringivARB(@NativeType("GLchar const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt, @NativeType("GLint *") int[] paramArrayOfint) {
/* 414 */     long l = (GL.getICD()).glGetNamedStringivARB;
/* 415 */     if (Checks.CHECKS) {
/* 416 */       Checks.check(l);
/* 417 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 419 */     JNI.callPPV(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedStringivARB(@NativeType("GLchar const *") CharSequence paramCharSequence, @NativeType("GLenum") int paramInt, @NativeType("GLint *") int[] paramArrayOfint) {
/* 424 */     long l = (GL.getICD()).glGetNamedStringivARB;
/* 425 */     if (Checks.CHECKS) {
/* 426 */       Checks.check(l);
/* 427 */       Checks.check(paramArrayOfint, 1);
/*     */     }  MemoryStack memoryStack;
/* 429 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 431 */       int j = memoryStack.nASCII(paramCharSequence, false);
/* 432 */       long l1 = memoryStack.getPointerAddress();
/* 433 */       JNI.callPPV(j, l1, paramInt, paramArrayOfint, l); return;
/*     */     } finally {
/* 435 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static native void nglNamedStringARB(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2);
/*     */   
/*     */   public static native void nglDeleteNamedStringARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglCompileShaderIncludeARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native boolean nglIsNamedStringARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetNamedStringARB(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nglGetNamedStringivARB(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBShadingLanguageInclude.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */