/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.LongBuffer;
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
/*     */ public class AMDGPUShaderInt64
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
/*     */   
/*     */   static {
/*  36 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_UNSIGNED_INT8_VEC2_NV = 36845;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT8_VEC3_NV = 36846;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT8_VEC4_NV = 36847;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT16_NV = 36848;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT16_VEC2_NV = 36849;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT16_VEC3_NV = 36850;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT16_VEC4_NV = 36851;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT64_VEC2_NV = 36853;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT64_VEC3_NV = 36854;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT64_VEC4_NV = 36855;
/*     */   
/*     */   public static final int GL_FLOAT16_NV = 36856;
/*     */   
/*     */   public static final int GL_FLOAT16_VEC2_NV = 36857;
/*     */   
/*     */   public static final int GL_FLOAT16_VEC3_NV = 36858;
/*     */   
/*     */   public static final int GL_FLOAT16_VEC4_NV = 36859;
/*     */ 
/*     */   
/*     */   protected AMDGPUShaderInt64() {
/*  70 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform1i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong) {
/*  76 */     NVGPUShader5.glUniform1i64NV(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2) {
/*  82 */     NVGPUShader5.glUniform2i64NV(paramInt, paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3) {
/*  88 */     NVGPUShader5.glUniform3i64NV(paramInt, paramLong1, paramLong2, paramLong3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4i64NV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3, @NativeType("GLint64EXT") long paramLong4) {
/*  94 */     NVGPUShader5.glUniform4i64NV(paramInt, paramLong1, paramLong2, paramLong3, paramLong4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform1i64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 100 */     NVGPUShader5.nglUniform1i64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glUniform1i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 104 */     NVGPUShader5.glUniform1i64vNV(paramInt, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform2i64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 110 */     NVGPUShader5.nglUniform2i64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glUniform2i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 114 */     NVGPUShader5.glUniform2i64vNV(paramInt, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform3i64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 120 */     NVGPUShader5.nglUniform3i64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glUniform3i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 124 */     NVGPUShader5.glUniform3i64vNV(paramInt, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform4i64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 130 */     NVGPUShader5.nglUniform4i64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glUniform4i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 134 */     NVGPUShader5.glUniform4i64vNV(paramInt, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform1ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong) {
/* 140 */     NVGPUShader5.glUniform1ui64NV(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2) {
/* 146 */     NVGPUShader5.glUniform2ui64NV(paramInt, paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3) {
/* 152 */     NVGPUShader5.glUniform3ui64NV(paramInt, paramLong1, paramLong2, paramLong3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3, @NativeType("GLuint64EXT") long paramLong4) {
/* 158 */     NVGPUShader5.glUniform4ui64NV(paramInt, paramLong1, paramLong2, paramLong3, paramLong4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform1ui64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 164 */     NVGPUShader5.nglUniform1ui64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glUniform1ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 168 */     NVGPUShader5.glUniform1ui64vNV(paramInt, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform2ui64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 174 */     NVGPUShader5.nglUniform2ui64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glUniform2ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT *") LongBuffer paramLongBuffer) {
/* 178 */     NVGPUShader5.glUniform2ui64vNV(paramInt, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform3ui64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 184 */     NVGPUShader5.nglUniform3ui64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glUniform3ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 188 */     NVGPUShader5.glUniform3ui64vNV(paramInt, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform4ui64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 194 */     NVGPUShader5.nglUniform4ui64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glUniform4ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 198 */     NVGPUShader5.glUniform4ui64vNV(paramInt, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformi64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 204 */     NVGPUShader5.nglGetUniformi64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glGetUniformi64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT *") LongBuffer paramLongBuffer) {
/* 208 */     NVGPUShader5.glGetUniformi64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformi64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 213 */     return NVGPUShader5.glGetUniformi64NV(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformui64vNV(int paramInt1, int paramInt2, long paramLong) {
/* 219 */     NVShaderBufferLoad.nglGetUniformui64vNV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT *") LongBuffer paramLongBuffer) {
/* 223 */     NVShaderBufferLoad.glGetUniformui64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetUniformui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 228 */     return NVShaderBufferLoad.glGetUniformui64NV(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong) {
/* 234 */     NVGPUShader5.glProgramUniform1i64NV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2) {
/* 240 */     NVGPUShader5.glProgramUniform2i64NV(paramInt1, paramInt2, paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3) {
/* 246 */     NVGPUShader5.glProgramUniform3i64NV(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3, @NativeType("GLint64EXT") long paramLong4) {
/* 252 */     NVGPUShader5.glProgramUniform4i64NV(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramLong4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform1i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 258 */     NVGPUShader5.nglProgramUniform1i64vNV(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */   
/*     */   public static void glProgramUniform1i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 262 */     NVGPUShader5.glProgramUniform1i64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform2i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 268 */     NVGPUShader5.nglProgramUniform2i64vNV(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */   
/*     */   public static void glProgramUniform2i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 272 */     NVGPUShader5.glProgramUniform2i64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform3i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 278 */     NVGPUShader5.nglProgramUniform3i64vNV(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */   
/*     */   public static void glProgramUniform3i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 282 */     NVGPUShader5.glProgramUniform3i64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform4i64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 288 */     NVGPUShader5.nglProgramUniform4i64vNV(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */   
/*     */   public static void glProgramUniform4i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/* 292 */     NVGPUShader5.glProgramUniform4i64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong) {
/* 298 */     NVGPUShader5.glProgramUniform1ui64NV(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2) {
/* 304 */     NVGPUShader5.glProgramUniform2ui64NV(paramInt1, paramInt2, paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3) {
/* 310 */     NVGPUShader5.glProgramUniform3ui64NV(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3, @NativeType("GLuint64EXT") long paramLong4) {
/* 316 */     NVGPUShader5.glProgramUniform4ui64NV(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3, paramLong4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform1ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 322 */     NVGPUShader5.nglProgramUniform1ui64vNV(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */   
/*     */   public static void glProgramUniform1ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 326 */     NVGPUShader5.glProgramUniform1ui64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform2ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 332 */     NVGPUShader5.nglProgramUniform2ui64vNV(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */   
/*     */   public static void glProgramUniform2ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 336 */     NVGPUShader5.glProgramUniform2ui64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform3ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 342 */     NVGPUShader5.nglProgramUniform3ui64vNV(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */   
/*     */   public static void glProgramUniform3ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 346 */     NVGPUShader5.glProgramUniform3ui64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglProgramUniform4ui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 352 */     NVGPUShader5.nglProgramUniform4ui64vNV(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */   
/*     */   public static void glProgramUniform4ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 356 */     NVGPUShader5.glProgramUniform4ui64vNV(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 361 */     NVGPUShader5.glUniform1i64vNV(paramInt, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 366 */     NVGPUShader5.glUniform2i64vNV(paramInt, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 371 */     NVGPUShader5.glUniform3i64vNV(paramInt, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4i64vNV(@NativeType("GLint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 376 */     NVGPUShader5.glUniform4i64vNV(paramInt, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 381 */     NVGPUShader5.glUniform1ui64vNV(paramInt, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT *") long[] paramArrayOflong) {
/* 386 */     NVGPUShader5.glUniform2ui64vNV(paramInt, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 391 */     NVGPUShader5.glUniform3ui64vNV(paramInt, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4ui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 396 */     NVGPUShader5.glUniform4ui64vNV(paramInt, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformi64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT *") long[] paramArrayOflong) {
/* 401 */     NVGPUShader5.glGetUniformi64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT *") long[] paramArrayOflong) {
/* 406 */     NVShaderBufferLoad.glGetUniformui64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 411 */     NVGPUShader5.glProgramUniform1i64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 416 */     NVGPUShader5.glProgramUniform2i64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 421 */     NVGPUShader5.glProgramUniform3i64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4i64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 426 */     NVGPUShader5.glProgramUniform4i64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 431 */     NVGPUShader5.glProgramUniform1ui64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 436 */     NVGPUShader5.glProgramUniform2ui64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 441 */     NVGPUShader5.glProgramUniform3ui64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4ui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 446 */     NVGPUShader5.glProgramUniform4ui64vNV(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\AMDGPUShaderInt64.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */