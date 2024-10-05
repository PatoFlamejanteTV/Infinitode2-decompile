/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ public class EXTGPUShader4
/*     */ {
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER_EXT = 35069;
/*     */   public static final int GL_SAMPLER_1D_ARRAY_EXT = 36288;
/*     */   public static final int GL_SAMPLER_2D_ARRAY_EXT = 36289;
/*     */   public static final int GL_SAMPLER_BUFFER_EXT = 36290;
/*     */   public static final int GL_SAMPLER_1D_ARRAY_SHADOW_EXT = 36291;
/*     */   public static final int GL_SAMPLER_2D_ARRAY_SHADOW_EXT = 36292;
/*     */   public static final int GL_SAMPLER_CUBE_SHADOW_EXT = 36293;
/*     */   public static final int GL_UNSIGNED_INT_VEC2_EXT = 36294;
/*     */   public static final int GL_UNSIGNED_INT_VEC3_EXT = 36295;
/*     */   public static final int GL_UNSIGNED_INT_VEC4_EXT = 36296;
/*     */   public static final int GL_INT_SAMPLER_1D_EXT = 36297;
/*     */   public static final int GL_INT_SAMPLER_2D_EXT = 36298;
/*     */   public static final int GL_INT_SAMPLER_3D_EXT = 36299;
/*     */   public static final int GL_INT_SAMPLER_CUBE_EXT = 36300;
/*     */   public static final int GL_INT_SAMPLER_2D_RECT_EXT = 36301;
/*     */   public static final int GL_INT_SAMPLER_1D_ARRAY_EXT = 36302;
/*     */   public static final int GL_INT_SAMPLER_2D_ARRAY_EXT = 36303;
/*     */   public static final int GL_INT_SAMPLER_BUFFER_EXT = 36304;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_1D_EXT = 36305;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_EXT = 36306;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_3D_EXT = 36307;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_EXT = 36308;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT_EXT = 36309;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY_EXT = 36310;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY_EXT = 36311;
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_EXT = 36312;
/*     */   public static final int GL_MIN_PROGRAM_TEXEL_OFFSET_EXT = 35076;
/*     */   public static final int GL_MAX_PROGRAM_TEXEL_OFFSET_EXT = 35077;
/*     */   
/*     */   static {
/*  72 */     GL.initialize();
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
/*     */   protected EXTGPUShader4() {
/* 111 */     throw new UnsupportedOperationException();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI1ivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 218 */     if (Checks.CHECKS) {
/* 219 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 221 */     nglVertexAttribI1ivEXT(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glVertexAttribI2ivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 236 */     if (Checks.CHECKS) {
/* 237 */       Checks.check(paramIntBuffer, 2);
/*     */     }
/* 239 */     nglVertexAttribI2ivEXT(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glVertexAttribI3ivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 254 */     if (Checks.CHECKS) {
/* 255 */       Checks.check(paramIntBuffer, 3);
/*     */     }
/* 257 */     nglVertexAttribI3ivEXT(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glVertexAttribI4ivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 272 */     if (Checks.CHECKS) {
/* 273 */       Checks.check(paramIntBuffer, 4);
/*     */     }
/* 275 */     nglVertexAttribI4ivEXT(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glVertexAttribI1uivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 290 */     if (Checks.CHECKS) {
/* 291 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 293 */     nglVertexAttribI1uivEXT(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glVertexAttribI2uivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 308 */     if (Checks.CHECKS) {
/* 309 */       Checks.check(paramIntBuffer, 2);
/*     */     }
/* 311 */     nglVertexAttribI2uivEXT(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glVertexAttribI3uivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 326 */     if (Checks.CHECKS) {
/* 327 */       Checks.check(paramIntBuffer, 3);
/*     */     }
/* 329 */     nglVertexAttribI3uivEXT(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glVertexAttribI4uivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 344 */     if (Checks.CHECKS) {
/* 345 */       Checks.check(paramIntBuffer, 4);
/*     */     }
/* 347 */     nglVertexAttribI4uivEXT(paramInt, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glVertexAttribI4bvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/* 362 */     if (Checks.CHECKS) {
/* 363 */       Checks.check(paramByteBuffer, 4);
/*     */     }
/* 365 */     nglVertexAttribI4bvEXT(paramInt, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glVertexAttribI4svEXT(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 380 */     if (Checks.CHECKS) {
/* 381 */       Checks.check(paramShortBuffer, 4);
/*     */     }
/* 383 */     nglVertexAttribI4svEXT(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glVertexAttribI4ubvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/* 398 */     if (Checks.CHECKS) {
/* 399 */       Checks.check(paramByteBuffer, 4);
/*     */     }
/* 401 */     nglVertexAttribI4ubvEXT(paramInt, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glVertexAttribI4usvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 416 */     if (Checks.CHECKS) {
/* 417 */       Checks.check(paramShortBuffer, 4);
/*     */     }
/* 419 */     nglVertexAttribI4usvEXT(paramInt, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 439 */     nglVertexAttribIPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramByteBuffer));
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
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") long paramLong) {
/* 454 */     nglVertexAttribIPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 469 */     nglVertexAttribIPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramShortBuffer));
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
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 484 */     nglVertexAttribIPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glGetVertexAttribIivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 500 */     if (Checks.CHECKS) {
/* 501 */       Checks.check(paramIntBuffer, 4);
/*     */     }
/* 503 */     nglGetVertexAttribIivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetVertexAttribIiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 514 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 516 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 517 */       nglGetVertexAttribIivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 518 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 520 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetVertexAttribIuivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 537 */     if (Checks.CHECKS) {
/* 538 */       Checks.check(paramIntBuffer, 4);
/*     */     }
/* 540 */     nglGetVertexAttribIuivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetVertexAttribIuiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 551 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 553 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 554 */       nglGetVertexAttribIuivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 555 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 557 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformuivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 566 */     if (Checks.CHECKS) {
/* 567 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 569 */     nglGetUniformuivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetUniformuiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 574 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 576 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 577 */       nglGetUniformuivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 578 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 580 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindFragDataLocationEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 589 */     if (Checks.CHECKS) {
/* 590 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 592 */     nglBindFragDataLocationEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   public static void glBindFragDataLocationEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 596 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 598 */       memoryStack.nASCII(paramCharSequence, true);
/* 599 */       long l = memoryStack.getPointerAddress();
/* 600 */       nglBindFragDataLocationEXT(paramInt1, paramInt2, l); return;
/*     */     } finally {
/* 602 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetFragDataLocationEXT(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 612 */     if (Checks.CHECKS) {
/* 613 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 615 */     return nglGetFragDataLocationEXT(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   @NativeType("GLint")
/*     */   public static int glGetFragDataLocationEXT(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 620 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 622 */       memoryStack.nASCII(paramCharSequence, true);
/* 623 */       long l = memoryStack.getPointerAddress();
/* 624 */       paramInt = nglGetFragDataLocationEXT(paramInt, l); return paramInt;
/*     */     } finally {
/* 626 */       memoryStack.setPointer(i);
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
/*     */   public static void glUniform1uivEXT(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 651 */     nglUniform1uivEXT(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2uivEXT(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 659 */     nglUniform2uivEXT(paramInt, paramIntBuffer.remaining() >> 1, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3uivEXT(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 667 */     nglUniform3uivEXT(paramInt, paramIntBuffer.remaining() / 3, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4uivEXT(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 675 */     nglUniform4uivEXT(paramInt, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI1ivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 680 */     long l = (GL.getICD()).glVertexAttribI1ivEXT;
/* 681 */     if (Checks.CHECKS) {
/* 682 */       Checks.check(l);
/* 683 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 685 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI2ivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 690 */     long l = (GL.getICD()).glVertexAttribI2ivEXT;
/* 691 */     if (Checks.CHECKS) {
/* 692 */       Checks.check(l);
/* 693 */       Checks.check(paramArrayOfint, 2);
/*     */     } 
/* 695 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI3ivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 700 */     long l = (GL.getICD()).glVertexAttribI3ivEXT;
/* 701 */     if (Checks.CHECKS) {
/* 702 */       Checks.check(l);
/* 703 */       Checks.check(paramArrayOfint, 3);
/*     */     } 
/* 705 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4ivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 710 */     long l = (GL.getICD()).glVertexAttribI4ivEXT;
/* 711 */     if (Checks.CHECKS) {
/* 712 */       Checks.check(l);
/* 713 */       Checks.check(paramArrayOfint, 4);
/*     */     } 
/* 715 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI1uivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 720 */     long l = (GL.getICD()).glVertexAttribI1uivEXT;
/* 721 */     if (Checks.CHECKS) {
/* 722 */       Checks.check(l);
/* 723 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 725 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI2uivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 730 */     long l = (GL.getICD()).glVertexAttribI2uivEXT;
/* 731 */     if (Checks.CHECKS) {
/* 732 */       Checks.check(l);
/* 733 */       Checks.check(paramArrayOfint, 2);
/*     */     } 
/* 735 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI3uivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 740 */     long l = (GL.getICD()).glVertexAttribI3uivEXT;
/* 741 */     if (Checks.CHECKS) {
/* 742 */       Checks.check(l);
/* 743 */       Checks.check(paramArrayOfint, 3);
/*     */     } 
/* 745 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4uivEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 750 */     long l = (GL.getICD()).glVertexAttribI4uivEXT;
/* 751 */     if (Checks.CHECKS) {
/* 752 */       Checks.check(l);
/* 753 */       Checks.check(paramArrayOfint, 4);
/*     */     } 
/* 755 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4svEXT(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 760 */     long l = (GL.getICD()).glVertexAttribI4svEXT;
/* 761 */     if (Checks.CHECKS) {
/* 762 */       Checks.check(l);
/* 763 */       Checks.check(paramArrayOfshort, 4);
/*     */     } 
/* 765 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribI4usvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 770 */     long l = (GL.getICD()).glVertexAttribI4usvEXT;
/* 771 */     if (Checks.CHECKS) {
/* 772 */       Checks.check(l);
/* 773 */       Checks.check(paramArrayOfshort, 4);
/*     */     } 
/* 775 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") short[] paramArrayOfshort) {
/* 780 */     long l = (GL.getICD()).glVertexAttribIPointerEXT;
/* 781 */     if (Checks.CHECKS) {
/* 782 */       Checks.check(l);
/*     */     }
/* 784 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribIPointerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") int[] paramArrayOfint) {
/* 789 */     long l = (GL.getICD()).glVertexAttribIPointerEXT;
/* 790 */     if (Checks.CHECKS) {
/* 791 */       Checks.check(l);
/*     */     }
/* 793 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribIivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 798 */     long l = (GL.getICD()).glGetVertexAttribIivEXT;
/* 799 */     if (Checks.CHECKS) {
/* 800 */       Checks.check(l);
/* 801 */       Checks.check(paramArrayOfint, 4);
/*     */     } 
/* 803 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribIuivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 808 */     long l = (GL.getICD()).glGetVertexAttribIuivEXT;
/* 809 */     if (Checks.CHECKS) {
/* 810 */       Checks.check(l);
/* 811 */       Checks.check(paramArrayOfint, 4);
/*     */     } 
/* 813 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformuivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 818 */     long l = (GL.getICD()).glGetUniformuivEXT;
/* 819 */     if (Checks.CHECKS) {
/* 820 */       Checks.check(l);
/* 821 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 823 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1uivEXT(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 828 */     long l = (GL.getICD()).glUniform1uivEXT;
/* 829 */     if (Checks.CHECKS) {
/* 830 */       Checks.check(l);
/*     */     }
/* 832 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2uivEXT(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 837 */     long l = (GL.getICD()).glUniform2uivEXT;
/* 838 */     if (Checks.CHECKS) {
/* 839 */       Checks.check(l);
/*     */     }
/* 841 */     JNI.callPV(paramInt, paramArrayOfint.length >> 1, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3uivEXT(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 846 */     long l = (GL.getICD()).glUniform3uivEXT;
/* 847 */     if (Checks.CHECKS) {
/* 848 */       Checks.check(l);
/*     */     }
/* 850 */     JNI.callPV(paramInt, paramArrayOfint.length / 3, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4uivEXT(@NativeType("GLint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 855 */     long l = (GL.getICD()).glUniform4uivEXT;
/* 856 */     if (Checks.CHECKS) {
/* 857 */       Checks.check(l);
/*     */     }
/* 859 */     JNI.callPV(paramInt, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void glVertexAttribI1iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native void glVertexAttribI2iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void glVertexAttribI3iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   public static native void glVertexAttribI4iEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void glVertexAttribI1uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glVertexAttribI2uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glVertexAttribI3uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   public static native void glVertexAttribI4uiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void nglVertexAttribI1ivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI2ivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI3ivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4ivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI1uivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI2uivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI3uivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4uivEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4bvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4svEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4ubvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribI4usvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribIPointerEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribIivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribIuivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformuivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglBindFragDataLocationEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native int nglGetFragDataLocationEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glUniform1uiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glUniform2uiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*     */   
/*     */   public static native void glUniform3uiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*     */   
/*     */   public static native void glUniform4uiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5);
/*     */   
/*     */   public static native void nglUniform1uivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform2uivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform3uivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform4uivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTGPUShader4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */