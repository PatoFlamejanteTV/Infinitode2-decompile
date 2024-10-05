/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBShaderSubroutine
/*     */ {
/*     */   public static final int GL_ACTIVE_SUBROUTINES = 36325;
/*     */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
/*     */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
/*     */   public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
/*     */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
/*     */   public static final int GL_MAX_SUBROUTINES = 36327;
/*     */   public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
/*     */   public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
/*     */   public static final int GL_COMPATIBLE_SUBROUTINES = 36427;
/*     */   
/*     */   static {
/*  25 */     GL.initialize();
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
/*     */   protected ARBShaderSubroutine() {
/*  46 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetSubroutineUniformLocation(int paramInt1, int paramInt2, long paramLong) {
/*  53 */     return GL40C.nglGetSubroutineUniformLocation(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetSubroutineUniformLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  65 */     return GL40C.glGetSubroutineUniformLocation(paramInt1, paramInt2, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetSubroutineUniformLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*  77 */     return GL40C.glGetSubroutineUniformLocation(paramInt1, paramInt2, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetSubroutineIndex(int paramInt1, int paramInt2, long paramLong) {
/*  84 */     return GL40C.nglGetSubroutineIndex(paramInt1, paramInt2, paramLong);
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
/*     */   public static int glGetSubroutineIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  96 */     return GL40C.glGetSubroutineIndex(paramInt1, paramInt2, paramByteBuffer);
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
/*     */   public static int glGetSubroutineIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 108 */     return GL40C.glGetSubroutineIndex(paramInt1, paramInt2, paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveSubroutineUniformiv(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/* 115 */     GL40C.nglGetActiveSubroutineUniformiv(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*     */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 128 */     GL40C.glGetActiveSubroutineUniformiv(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
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
/*     */   public static int glGetActiveSubroutineUniformi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4) {
/* 141 */     return GL40C.glGetActiveSubroutineUniformi(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveSubroutineUniformName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2) {
/* 152 */     GL40C.nglGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
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
/*     */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 165 */     GL40C.glGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramByteBuffer);
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
/*     */   public static String glGetActiveSubroutineUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 178 */     return GL40C.glGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static String glGetActiveSubroutineUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 190 */     return glGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, glGetActiveSubroutineUniformi(paramInt1, paramInt2, paramInt3, 35385));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveSubroutineName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2) {
/* 201 */     GL40C.nglGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
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
/*     */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 214 */     GL40C.glGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramByteBuffer);
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
/*     */   public static String glGetActiveSubroutineName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 227 */     return GL40C.glGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static String glGetActiveSubroutineName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 239 */     return glGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, glGetProgramStagei(paramInt1, paramInt2, 36424));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformSubroutinesuiv(int paramInt1, int paramInt2, long paramLong) {
/* 250 */     GL40C.nglUniformSubroutinesuiv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 260 */     GL40C.glUniformSubroutinesuiv(paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint const *") int paramInt2) {
/* 269 */     GL40C.glUniformSubroutinesui(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformSubroutineuiv(int paramInt1, int paramInt2, long paramLong) {
/* 276 */     GL40C.nglGetUniformSubroutineuiv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 287 */     GL40C.glGetUniformSubroutineuiv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetUniformSubroutineui(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 298 */     return GL40C.glGetUniformSubroutineui(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetProgramStageiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 305 */     GL40C.nglGetProgramStageiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glGetProgramStageiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 317 */     GL40C.glGetProgramStageiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*     */   public static int glGetProgramStagei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 329 */     return GL40C.glGetProgramStagei(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") int[] paramArrayOfint) {
/* 334 */     GL40C.glGetActiveSubroutineUniformiv(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 339 */     GL40C.glGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, paramArrayOfint, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 344 */     GL40C.glGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, paramArrayOfint, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 349 */     GL40C.glUniformSubroutinesuiv(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 354 */     GL40C.glGetUniformSubroutineuiv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramStageiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 359 */     GL40C.glGetProgramStageiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBShaderSubroutine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */