/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.LongBuffer;
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
/*     */ public class NVGPUShader5
/*     */ {
/*     */   public static final int GL_INT64_NV = 5134;
/*     */   public static final int GL_UNSIGNED_INT64_NV = 5135;
/*     */   public static final int GL_INT8_NV = 36832;
/*     */   public static final int GL_INT8_VEC2_NV = 36833;
/*     */   public static final int GL_INT8_VEC3_NV = 36834;
/*     */   public static final int GL_INT8_VEC4_NV = 36835;
/*     */   public static final int GL_INT16_NV = 36836;
/*     */   public static final int GL_INT16_VEC2_NV = 36837;
/*     */   public static final int GL_INT16_VEC3_NV = 36838;
/*     */   public static final int GL_INT16_VEC4_NV = 36839;
/*     */   public static final int GL_INT64_VEC2_NV = 36841;
/*     */   public static final int GL_INT64_VEC3_NV = 36842;
/*     */   public static final int GL_INT64_VEC4_NV = 36843;
/*     */   public static final int GL_UNSIGNED_INT8_NV = 36844;
/*     */   public static final int GL_UNSIGNED_INT8_VEC2_NV = 36845;
/*     */   public static final int GL_UNSIGNED_INT8_VEC3_NV = 36846;
/*     */   public static final int GL_UNSIGNED_INT8_VEC4_NV = 36847;
/*     */   public static final int GL_UNSIGNED_INT16_NV = 36848;
/*     */   public static final int GL_UNSIGNED_INT16_VEC2_NV = 36849;
/*     */   public static final int GL_UNSIGNED_INT16_VEC3_NV = 36850;
/*     */   public static final int GL_UNSIGNED_INT16_VEC4_NV = 36851;
/*     */   public static final int GL_UNSIGNED_INT64_VEC2_NV = 36853;
/*     */   public static final int GL_UNSIGNED_INT64_VEC3_NV = 36854;
/*     */   public static final int GL_UNSIGNED_INT64_VEC4_NV = 36855;
/*     */   public static final int GL_FLOAT16_NV = 36856;
/*     */   public static final int GL_FLOAT16_VEC2_NV = 36857;
/*     */   public static final int GL_FLOAT16_VEC3_NV = 36858;
/*     */   public static final int GL_FLOAT16_VEC4_NV = 36859;
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
/*     */   protected NVGPUShader5() {
/*  98 */     throw new UnsupportedOperationException();
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
/*     */   public static void glUniform1i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 122 */     nglUniform1i64vNV(paramInt, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 130 */     nglUniform2i64vNV(paramInt, paramLongBuffer.remaining() >> 1, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 138 */     nglUniform3i64vNV(paramInt, paramLongBuffer.remaining() / 3, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 146 */     nglUniform4i64vNV(paramInt, paramLongBuffer.remaining() >> 2, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glUniform1ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 170 */     nglUniform1ui64vNV(paramInt, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT *") LongBuffer paramLongBuffer) {
/* 178 */     nglUniform2ui64vNV(paramInt, paramLongBuffer.remaining() >> 1, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 186 */     nglUniform3ui64vNV(paramInt, paramLongBuffer.remaining() / 3, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 194 */     nglUniform4ui64vNV(paramInt, paramLongBuffer.remaining() >> 2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformi64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT *") LongBuffer paramLongBuffer) {
/* 202 */     if (Checks.CHECKS) {
/* 203 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 205 */     nglGetUniformi64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glGetUniformi64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 210 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 212 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 213 */       nglGetUniformi64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 214 */       return longBuffer.get(0);
/*     */     } finally {
/* 216 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformui64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 223 */     NVShaderBufferLoad.nglGetUniformui64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT *") LongBuffer paramLongBuffer) {
/* 227 */     NVShaderBufferLoad.glGetUniformui64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 232 */     return NVShaderBufferLoad.glGetUniformui64NV(paramInt1, paramInt2);
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
/*     */   public static void glProgramUniform1i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 256 */     nglProgramUniform1i64vNV(paramInt1, paramInt2, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 264 */     nglProgramUniform2i64vNV(paramInt1, paramInt2, paramLongBuffer.remaining() >> 1, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 272 */     nglProgramUniform3i64vNV(paramInt1, paramInt2, paramLongBuffer.remaining() / 3, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 280 */     nglProgramUniform4i64vNV(paramInt1, paramInt2, paramLongBuffer.remaining() >> 2, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glProgramUniform1ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 304 */     nglProgramUniform1ui64vNV(paramInt1, paramInt2, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 312 */     nglProgramUniform2ui64vNV(paramInt1, paramInt2, paramLongBuffer.remaining() >> 1, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 320 */     nglProgramUniform3ui64vNV(paramInt1, paramInt2, paramLongBuffer.remaining() / 3, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 328 */     nglProgramUniform4ui64vNV(paramInt1, paramInt2, paramLongBuffer.remaining() >> 2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 333 */     long l = (GL.getICD()).glUniform1i64vNV;
/* 334 */     if (Checks.CHECKS) {
/* 335 */       Checks.check(l);
/*     */     }
/* 337 */     JNI.callPV(paramInt, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 342 */     long l = (GL.getICD()).glUniform2i64vNV;
/* 343 */     if (Checks.CHECKS) {
/* 344 */       Checks.check(l);
/*     */     }
/* 346 */     JNI.callPV(paramInt, paramArrayOflong.length >> 1, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 351 */     long l = (GL.getICD()).glUniform3i64vNV;
/* 352 */     if (Checks.CHECKS) {
/* 353 */       Checks.check(l);
/*     */     }
/* 355 */     JNI.callPV(paramInt, paramArrayOflong.length / 3, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 360 */     long l = (GL.getICD()).glUniform4i64vNV;
/* 361 */     if (Checks.CHECKS) {
/* 362 */       Checks.check(l);
/*     */     }
/* 364 */     JNI.callPV(paramInt, paramArrayOflong.length >> 2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 369 */     long l = (GL.getICD()).glUniform1ui64vNV;
/* 370 */     if (Checks.CHECKS) {
/* 371 */       Checks.check(l);
/*     */     }
/* 373 */     JNI.callPV(paramInt, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT *") long[] paramArrayOflong) {
/* 378 */     long l = (GL.getICD()).glUniform2ui64vNV;
/* 379 */     if (Checks.CHECKS) {
/* 380 */       Checks.check(l);
/*     */     }
/* 382 */     JNI.callPV(paramInt, paramArrayOflong.length >> 1, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 387 */     long l = (GL.getICD()).glUniform3ui64vNV;
/* 388 */     if (Checks.CHECKS) {
/* 389 */       Checks.check(l);
/*     */     }
/* 391 */     JNI.callPV(paramInt, paramArrayOflong.length / 3, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 396 */     long l = (GL.getICD()).glUniform4ui64vNV;
/* 397 */     if (Checks.CHECKS) {
/* 398 */       Checks.check(l);
/*     */     }
/* 400 */     JNI.callPV(paramInt, paramArrayOflong.length >> 2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformi64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT *") long[] paramArrayOflong) {
/* 405 */     long l = (GL.getICD()).glGetUniformi64vNV;
/* 406 */     if (Checks.CHECKS) {
/* 407 */       Checks.check(l);
/* 408 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 410 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT *") long[] paramArrayOflong) {
/* 415 */     NVShaderBufferLoad.glGetUniformui64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 420 */     long l = (GL.getICD()).glProgramUniform1i64vNV;
/* 421 */     if (Checks.CHECKS) {
/* 422 */       Checks.check(l);
/*     */     }
/* 424 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 429 */     long l = (GL.getICD()).glProgramUniform2i64vNV;
/* 430 */     if (Checks.CHECKS) {
/* 431 */       Checks.check(l);
/*     */     }
/* 433 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length >> 1, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 438 */     long l = (GL.getICD()).glProgramUniform3i64vNV;
/* 439 */     if (Checks.CHECKS) {
/* 440 */       Checks.check(l);
/*     */     }
/* 442 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length / 3, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 447 */     long l = (GL.getICD()).glProgramUniform4i64vNV;
/* 448 */     if (Checks.CHECKS) {
/* 449 */       Checks.check(l);
/*     */     }
/* 451 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length >> 2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 456 */     long l = (GL.getICD()).glProgramUniform1ui64vNV;
/* 457 */     if (Checks.CHECKS) {
/* 458 */       Checks.check(l);
/*     */     }
/* 460 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 465 */     long l = (GL.getICD()).glProgramUniform2ui64vNV;
/* 466 */     if (Checks.CHECKS) {
/* 467 */       Checks.check(l);
/*     */     }
/* 469 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length >> 1, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 474 */     long l = (GL.getICD()).glProgramUniform3ui64vNV;
/* 475 */     if (Checks.CHECKS) {
/* 476 */       Checks.check(l);
/*     */     }
/* 478 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length / 3, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 483 */     long l = (GL.getICD()).glProgramUniform4ui64vNV;
/* 484 */     if (Checks.CHECKS) {
/* 485 */       Checks.check(l);
/*     */     }
/* 487 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length >> 2, paramArrayOflong, l);
/*     */   }
/*     */   
/*     */   public static native void glUniform1i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong);
/*     */   
/*     */   public static native void glUniform2i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glUniform3i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glUniform4i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3, @NativeType("GLint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglUniform1i64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform2i64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform3i64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform4i64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glUniform1ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong);
/*     */   
/*     */   public static native void glUniform2ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glUniform3ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glUniform4ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3, @NativeType("GLuint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglUniform1ui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform2ui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform3ui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglUniform4ui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformi64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform1i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong);
/*     */   
/*     */   public static native void glProgramUniform2i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glProgramUniform3i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glProgramUniform4i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3, @NativeType("GLint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglProgramUniform1i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform2i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform3i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform4i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glProgramUniform1ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong);
/*     */   
/*     */   public static native void glProgramUniform2ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glProgramUniform3ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glProgramUniform4ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3, @NativeType("GLuint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglProgramUniform1ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform2ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform3ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform4ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVGPUShader5.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */