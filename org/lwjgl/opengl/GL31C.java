/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ public class GL31C
/*     */   extends GL30C
/*     */ {
/*     */   public static final int GL_R8_SNORM = 36756;
/*     */   public static final int GL_RG8_SNORM = 36757;
/*     */   public static final int GL_RGB8_SNORM = 36758;
/*     */   public static final int GL_RGBA8_SNORM = 36759;
/*     */   public static final int GL_R16_SNORM = 36760;
/*     */   public static final int GL_RG16_SNORM = 36761;
/*     */   public static final int GL_RGB16_SNORM = 36762;
/*     */   public static final int GL_RGBA16_SNORM = 36763;
/*     */   public static final int GL_SIGNED_NORMALIZED = 36764;
/*     */   public static final int GL_SAMPLER_BUFFER = 36290;
/*     */   public static final int GL_INT_SAMPLER_2D_RECT = 36301;
/*     */   public static final int GL_INT_SAMPLER_BUFFER = 36304;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 36309;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 36312;
/*     */   public static final int GL_COPY_READ_BUFFER = 36662;
/*     */   
/*     */   static {
/*  39 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_COPY_WRITE_BUFFER = 36663;
/*     */ 
/*     */   
/*     */   public static final int GL_PRIMITIVE_RESTART = 36765;
/*     */ 
/*     */   
/*     */   public static final int GL_PRIMITIVE_RESTART_INDEX = 36766;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BUFFER = 35882;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 35883;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_BUFFER = 35884;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 35885;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_RECTANGLE = 34037;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_RECTANGLE = 34038;
/*     */ 
/*     */   
/*     */   public static final int GL_PROXY_TEXTURE_RECTANGLE = 34039;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 34040;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLER_2D_RECT = 35683;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLER_2D_RECT_SHADOW = 35684;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER = 35345;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_BINDING = 35368;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_START = 35369;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_SIZE = 35370;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 35380;
/*     */ 
/*     */   
/*     */   public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381;
/*     */ 
/*     */   
/*     */   public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_TYPE = 35383;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_SIZE = 35384;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_NAME_LENGTH = 35385;
/*     */ 
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_INDEX = 35386;
/*     */   
/*     */   public static final int GL_UNIFORM_OFFSET = 35387;
/*     */   
/*     */   public static final int GL_UNIFORM_ARRAY_STRIDE = 35388;
/*     */   
/*     */   public static final int GL_UNIFORM_MATRIX_STRIDE = 35389;
/*     */   
/*     */   public static final int GL_UNIFORM_IS_ROW_MAJOR = 35390;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_BINDING = 35391;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 35392;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 35393;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 35394;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 35395;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 35396;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 35397;
/*     */   
/*     */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 35398;
/*     */   
/*     */   public static final int GL_INVALID_INDEX = -1;
/*     */ 
/*     */   
/*     */   protected GL31C() {
/* 170 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt4) {
/* 209 */     nglDrawElementsInstanced(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3) {
/* 223 */     nglDrawElementsInstanced(paramInt1, paramByteBuffer.remaining() >> GLChecks.typeToByteShift(paramInt2), paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3);
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2) {
/* 236 */     nglDrawElementsInstanced(paramInt1, paramByteBuffer.remaining(), 5121, MemoryUtil.memAddress(paramByteBuffer), paramInt2);
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLsizei") int paramInt2) {
/* 249 */     nglDrawElementsInstanced(paramInt1, paramShortBuffer.remaining(), 5123, MemoryUtil.memAddress(paramShortBuffer), paramInt2);
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
/*     */   public static void glDrawElementsInstanced(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt2) {
/* 262 */     nglDrawElementsInstanced(paramInt1, paramIntBuffer.remaining(), 5125, MemoryUtil.memAddress(paramIntBuffer), paramInt2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 353 */     if (Checks.CHECKS) {
/* 354 */       Checks.check(paramIntBuffer, paramPointerBuffer.remaining());
/*     */     }
/* 356 */     nglGetUniformIndices(paramInt, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") CharSequence[] paramArrayOfCharSequence, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 369 */     if (Checks.CHECKS)
/* 370 */       Checks.check(paramIntBuffer, paramArrayOfCharSequence.length); 
/*     */     MemoryStack memoryStack;
/* 372 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 374 */       long l = APIUtil.apiArray(memoryStack, MemoryUtil::memASCII, paramArrayOfCharSequence);
/* 375 */       nglGetUniformIndices(paramInt, paramArrayOfCharSequence.length, l, MemoryUtil.memAddress(paramIntBuffer));
/* 376 */       APIUtil.apiArrayFree(l, paramArrayOfCharSequence.length); return;
/*     */     } finally {
/* 378 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 391 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 393 */       long l = APIUtil.apiArray(memoryStack, MemoryUtil::memASCII, new CharSequence[] { paramCharSequence });
/* 394 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 395 */       nglGetUniformIndices(paramInt, 1, l, MemoryUtil.memAddress(intBuffer));
/* 396 */       APIUtil.apiArrayFree(l, 1);
/* 397 */       paramInt = intBuffer.get(0); return paramInt;
/*     */     } finally {
/* 399 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetActiveUniformsiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 423 */     if (Checks.CHECKS) {
/* 424 */       Checks.check(paramIntBuffer2, paramIntBuffer1.remaining());
/*     */     }
/* 426 */     nglGetActiveUniformsiv(paramInt1, paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), paramInt2, MemoryUtil.memAddress(paramIntBuffer2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetActiveUniformsi(@NativeType("GLuint") int paramInt1, @NativeType("GLuint const *") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 439 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 441 */       IntBuffer intBuffer2 = memoryStack.callocInt(1);
/* 442 */       IntBuffer intBuffer1 = memoryStack.ints(paramInt2);
/* 443 */       nglGetActiveUniformsiv(paramInt1, 1, MemoryUtil.memAddress(intBuffer1), paramInt3, MemoryUtil.memAddress(intBuffer2));
/* 444 */       paramInt1 = intBuffer2.get(0); return paramInt1;
/*     */     } finally {
/* 446 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 470 */     if (Checks.CHECKS) {
/* 471 */       Checks.checkSafe(paramIntBuffer, 1);
/*     */     }
/* 473 */     nglGetActiveUniformName(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 487 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 489 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 490 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt3);
/* 491 */       nglGetActiveUniformName(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 492 */       return MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
/*     */     } finally {
/* 494 */       memoryStack.setPointer(i);
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
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 508 */     return glGetActiveUniformName(paramInt1, paramInt2, glGetActiveUniformsi(paramInt1, paramInt2, 35385));
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
/*     */   @NativeType("GLuint")
/*     */   public static int glGetUniformBlockIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 526 */     if (Checks.CHECKS) {
/* 527 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 529 */     return nglGetUniformBlockIndex(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetUniformBlockIndex(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 542 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 544 */       memoryStack.nASCII(paramCharSequence, true);
/* 545 */       long l = memoryStack.getPointerAddress();
/* 546 */       paramInt = nglGetUniformBlockIndex(paramInt, l); return paramInt;
/*     */     } finally {
/* 548 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetActiveUniformBlockiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 568 */     if (Checks.CHECKS) {
/* 569 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 571 */     nglGetActiveUniformBlockiv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   @NativeType("void")
/*     */   public static int glGetActiveUniformBlocki(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 585 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 587 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 588 */       nglGetActiveUniformBlockiv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 589 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 591 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 615 */     if (Checks.CHECKS) {
/* 616 */       Checks.checkSafe(paramIntBuffer, 1);
/*     */     }
/* 618 */     nglGetActiveUniformBlockName(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 632 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 634 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 635 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt3);
/* 636 */       nglGetActiveUniformBlockName(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 637 */       return MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
/*     */     } finally {
/* 639 */       memoryStack.setPointer(i);
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
/*     */   @NativeType("void")
/*     */   public static String glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 653 */     return glGetActiveUniformBlockName(paramInt1, paramInt2, glGetActiveUniformBlocki(paramInt1, paramInt2, 35393));
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
/*     */   public static void glGetUniformIndices(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 675 */     long l = (GL.getICD()).glGetUniformIndices;
/* 676 */     if (Checks.CHECKS) {
/* 677 */       Checks.check(l);
/* 678 */       Checks.check(paramArrayOfint, paramPointerBuffer.remaining());
/*     */     } 
/* 680 */     JNI.callPPV(paramInt, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformsiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 689 */     long l = (GL.getICD()).glGetActiveUniformsiv;
/* 690 */     if (Checks.CHECKS) {
/* 691 */       Checks.check(l);
/* 692 */       Checks.check(paramArrayOfint2, paramArrayOfint1.length);
/*     */     } 
/* 694 */     JNI.callPPV(paramInt1, paramArrayOfint1.length, paramArrayOfint1, paramInt2, paramArrayOfint2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 703 */     long l = (GL.getICD()).glGetActiveUniformName;
/* 704 */     if (Checks.CHECKS) {
/* 705 */       Checks.check(l);
/* 706 */       Checks.checkSafe(paramArrayOfint, 1);
/*     */     } 
/* 708 */     JNI.callPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformBlockiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 717 */     long l = (GL.getICD()).glGetActiveUniformBlockiv;
/* 718 */     if (Checks.CHECKS) {
/* 719 */       Checks.check(l);
/* 720 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 722 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveUniformBlockName(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 731 */     long l = (GL.getICD()).glGetActiveUniformBlockName;
/* 732 */     if (Checks.CHECKS) {
/* 733 */       Checks.check(l);
/* 734 */       Checks.checkSafe(paramArrayOfint, 1);
/*     */     } 
/* 736 */     JNI.callPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*     */   }
/*     */   
/*     */   public static native void glDrawArraysInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*     */   
/*     */   public static native void nglDrawElementsInstanced(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
/*     */   
/*     */   public static native void glCopyBufferSubData(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3);
/*     */   
/*     */   public static native void glPrimitiveRestartIndex(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glTexBuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void nglGetUniformIndices(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetActiveUniformsiv(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2);
/*     */   
/*     */   public static native void nglGetActiveUniformName(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nglGetUniformBlockIndex(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetActiveUniformBlockiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGetActiveUniformBlockName(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void glUniformBlockBinding(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL31C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */