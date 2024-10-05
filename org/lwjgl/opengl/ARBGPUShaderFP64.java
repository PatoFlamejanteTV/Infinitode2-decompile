/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
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
/*     */ public class ARBGPUShaderFP64
/*     */ {
/*     */   public static final int GL_DOUBLE_VEC2 = 36860;
/*     */   public static final int GL_DOUBLE_VEC3 = 36861;
/*     */   public static final int GL_DOUBLE_VEC4 = 36862;
/*     */   public static final int GL_DOUBLE_MAT2 = 36678;
/*     */   public static final int GL_DOUBLE_MAT3 = 36679;
/*     */   public static final int GL_DOUBLE_MAT4 = 36680;
/*     */   public static final int GL_DOUBLE_MAT2x3 = 36681;
/*     */   public static final int GL_DOUBLE_MAT2x4 = 36682;
/*     */   public static final int GL_DOUBLE_MAT3x2 = 36683;
/*     */   public static final int GL_DOUBLE_MAT3x4 = 36684;
/*     */   public static final int GL_DOUBLE_MAT4x2 = 36685;
/*     */   public static final int GL_DOUBLE_MAT4x3 = 36686;
/*     */   
/*     */   static {
/*  57 */     GL.initialize();
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
/*     */   protected ARBGPUShaderFP64() {
/*  75 */     throw new UnsupportedOperationException();
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
/*     */   public static void glUniform1d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble) {
/*  87 */     GL40C.glUniform1d(paramInt, paramDouble);
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
/*     */   public static void glUniform2d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/* 100 */     GL40C.glUniform2d(paramInt, paramDouble1, paramDouble2);
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
/*     */   public static void glUniform3d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3) {
/* 114 */     GL40C.glUniform3d(paramInt, paramDouble1, paramDouble2, paramDouble3);
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
/*     */   public static void glUniform4d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4) {
/* 129 */     GL40C.glUniform4d(paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform1dv(int paramInt1, int paramInt2, long paramLong) {
/* 140 */     GL40C.nglUniform1dv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform1dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 150 */     GL40C.glUniform1dv(paramInt, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform2dv(int paramInt1, int paramInt2, long paramLong) {
/* 161 */     GL40C.nglUniform2dv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform2dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 171 */     GL40C.glUniform2dv(paramInt, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform3dv(int paramInt1, int paramInt2, long paramLong) {
/* 182 */     GL40C.nglUniform3dv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform3dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 192 */     GL40C.glUniform3dv(paramInt, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniform4dv(int paramInt1, int paramInt2, long paramLong) {
/* 203 */     GL40C.nglUniform4dv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniform4dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 213 */     GL40C.glUniform4dv(paramInt, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 224 */     GL40C.nglUniformMatrix2dv(paramInt1, paramInt2, paramBoolean, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 235 */     GL40C.glUniformMatrix2dv(paramInt, paramBoolean, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 246 */     GL40C.nglUniformMatrix3dv(paramInt1, paramInt2, paramBoolean, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 257 */     GL40C.glUniformMatrix3dv(paramInt, paramBoolean, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 268 */     GL40C.nglUniformMatrix4dv(paramInt1, paramInt2, paramBoolean, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 279 */     GL40C.glUniformMatrix4dv(paramInt, paramBoolean, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2x3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 290 */     GL40C.nglUniformMatrix2x3dv(paramInt1, paramInt2, paramBoolean, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 301 */     GL40C.glUniformMatrix2x3dv(paramInt, paramBoolean, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2x4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 312 */     GL40C.nglUniformMatrix2x4dv(paramInt1, paramInt2, paramBoolean, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 323 */     GL40C.glUniformMatrix2x4dv(paramInt, paramBoolean, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3x2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 334 */     GL40C.nglUniformMatrix3x2dv(paramInt1, paramInt2, paramBoolean, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 345 */     GL40C.glUniformMatrix3x2dv(paramInt, paramBoolean, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3x4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 356 */     GL40C.nglUniformMatrix3x4dv(paramInt1, paramInt2, paramBoolean, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 367 */     GL40C.glUniformMatrix3x4dv(paramInt, paramBoolean, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4x2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 378 */     GL40C.nglUniformMatrix4x2dv(paramInt1, paramInt2, paramBoolean, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 389 */     GL40C.glUniformMatrix4x2dv(paramInt, paramBoolean, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4x3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 400 */     GL40C.nglUniformMatrix4x3dv(paramInt1, paramInt2, paramBoolean, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 411 */     GL40C.glUniformMatrix4x3dv(paramInt, paramBoolean, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformdv(int paramInt1, int paramInt2, long paramLong) {
/* 418 */     GL40C.nglGetUniformdv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformdv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 429 */     GL40C.glGetUniformdv(paramInt1, paramInt2, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static double glGetUniformd(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 440 */     return GL40C.glGetUniformd(paramInt1, paramInt2);
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
/*     */   public static void glProgramUniform1dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 510 */     nglProgramUniform1dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining(), MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniform2dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 530 */     nglProgramUniform2dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 1, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniform3dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 550 */     nglProgramUniform3dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 3, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniform4dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 570 */     nglProgramUniform4dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniformMatrix2dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 591 */     nglProgramUniformMatrix2dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 2, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniformMatrix3dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 612 */     nglProgramUniformMatrix3dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 9, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniformMatrix4dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 633 */     nglProgramUniformMatrix4dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 4, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniformMatrix2x3dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 654 */     nglProgramUniformMatrix2x3dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniformMatrix2x4dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 675 */     nglProgramUniformMatrix2x4dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniformMatrix3x2dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 696 */     nglProgramUniformMatrix3x2dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniformMatrix3x4dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 717 */     nglProgramUniformMatrix3x4dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniformMatrix4x2dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 738 */     nglProgramUniformMatrix4x2dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glProgramUniformMatrix4x3dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 759 */     nglProgramUniformMatrix4x3dvEXT(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform1dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 764 */     GL40C.glUniform1dv(paramInt, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform2dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 769 */     GL40C.glUniform2dv(paramInt, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform3dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 774 */     GL40C.glUniform3dv(paramInt, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniform4dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 779 */     GL40C.glUniform4dv(paramInt, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 784 */     GL40C.glUniformMatrix2dv(paramInt, paramBoolean, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 789 */     GL40C.glUniformMatrix3dv(paramInt, paramBoolean, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 794 */     GL40C.glUniformMatrix4dv(paramInt, paramBoolean, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 799 */     GL40C.glUniformMatrix2x3dv(paramInt, paramBoolean, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 804 */     GL40C.glUniformMatrix2x4dv(paramInt, paramBoolean, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 809 */     GL40C.glUniformMatrix3x2dv(paramInt, paramBoolean, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 814 */     GL40C.glUniformMatrix3x4dv(paramInt, paramBoolean, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 819 */     GL40C.glUniformMatrix4x2dv(paramInt, paramBoolean, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 824 */     GL40C.glUniformMatrix4x3dv(paramInt, paramBoolean, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformdv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 829 */     GL40C.glGetUniformdv(paramInt1, paramInt2, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform1dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 834 */     long l = (GL.getICD()).glProgramUniform1dvEXT;
/* 835 */     if (Checks.CHECKS) {
/* 836 */       Checks.check(l);
/*     */     }
/* 838 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform2dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 843 */     long l = (GL.getICD()).glProgramUniform2dvEXT;
/* 844 */     if (Checks.CHECKS) {
/* 845 */       Checks.check(l);
/*     */     }
/* 847 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 1, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform3dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 852 */     long l = (GL.getICD()).glProgramUniform3dvEXT;
/* 853 */     if (Checks.CHECKS) {
/* 854 */       Checks.check(l);
/*     */     }
/* 856 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 3, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniform4dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 861 */     long l = (GL.getICD()).glProgramUniform4dvEXT;
/* 862 */     if (Checks.CHECKS) {
/* 863 */       Checks.check(l);
/*     */     }
/* 865 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 2, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 870 */     long l = (GL.getICD()).glProgramUniformMatrix2dvEXT;
/* 871 */     if (Checks.CHECKS) {
/* 872 */       Checks.check(l);
/*     */     }
/* 874 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 2, paramBoolean, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 879 */     long l = (GL.getICD()).glProgramUniformMatrix3dvEXT;
/* 880 */     if (Checks.CHECKS) {
/* 881 */       Checks.check(l);
/*     */     }
/* 883 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 9, paramBoolean, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 888 */     long l = (GL.getICD()).glProgramUniformMatrix4dvEXT;
/* 889 */     if (Checks.CHECKS) {
/* 890 */       Checks.check(l);
/*     */     }
/* 892 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 4, paramBoolean, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x3dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 897 */     long l = (GL.getICD()).glProgramUniformMatrix2x3dvEXT;
/* 898 */     if (Checks.CHECKS) {
/* 899 */       Checks.check(l);
/*     */     }
/* 901 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 6, paramBoolean, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix2x4dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 906 */     long l = (GL.getICD()).glProgramUniformMatrix2x4dvEXT;
/* 907 */     if (Checks.CHECKS) {
/* 908 */       Checks.check(l);
/*     */     }
/* 910 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 3, paramBoolean, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x2dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 915 */     long l = (GL.getICD()).glProgramUniformMatrix3x2dvEXT;
/* 916 */     if (Checks.CHECKS) {
/* 917 */       Checks.check(l);
/*     */     }
/* 919 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 6, paramBoolean, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix3x4dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 924 */     long l = (GL.getICD()).glProgramUniformMatrix3x4dvEXT;
/* 925 */     if (Checks.CHECKS) {
/* 926 */       Checks.check(l);
/*     */     }
/* 928 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 12, paramBoolean, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x2dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 933 */     long l = (GL.getICD()).glProgramUniformMatrix4x2dvEXT;
/* 934 */     if (Checks.CHECKS) {
/* 935 */       Checks.check(l);
/*     */     }
/* 937 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 3, paramBoolean, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformMatrix4x3dvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 942 */     long l = (GL.getICD()).glProgramUniformMatrix4x3dvEXT;
/* 943 */     if (Checks.CHECKS) {
/* 944 */       Checks.check(l);
/*     */     }
/* 946 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 12, paramBoolean, paramArrayOfdouble, l);
/*     */   }
/*     */   
/*     */   public static native void glProgramUniform1dEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble);
/*     */   
/*     */   public static native void glProgramUniform2dEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void glProgramUniform3dEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void glProgramUniform4dEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*     */   
/*     */   public static native void nglProgramUniform1dvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform2dvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform3dvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniform4dvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix2dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix3dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix4dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix2x3dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix2x4dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix3x2dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix3x4dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix4x2dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformMatrix4x3dvEXT(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBGPUShaderFP64.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */