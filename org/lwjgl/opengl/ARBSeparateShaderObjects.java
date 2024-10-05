/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ARBSeparateShaderObjects
/*      */ {
/*      */   public static final int GL_VERTEX_SHADER_BIT = 1;
/*      */   public static final int GL_FRAGMENT_SHADER_BIT = 2;
/*      */   public static final int GL_GEOMETRY_SHADER_BIT = 4;
/*      */   public static final int GL_TESS_CONTROL_SHADER_BIT = 8;
/*      */   public static final int GL_TESS_EVALUATION_SHADER_BIT = 16;
/*      */   public static final int GL_ALL_SHADER_BITS = -1;
/*      */   public static final int GL_PROGRAM_SEPARABLE = 33368;
/*      */   public static final int GL_ACTIVE_PROGRAM = 33369;
/*      */   public static final int GL_PROGRAM_PIPELINE_BINDING = 33370;
/*      */   
/*      */   static {
/*   66 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ARBSeparateShaderObjects() {
/*   87 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUseProgramStages(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  100 */     GL41C.glUseProgramStages(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glActiveShaderProgram(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  112 */     GL41C.glActiveShaderProgram(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglCreateShaderProgramv(int paramInt1, int paramInt2, long paramLong) {
/*  123 */     return GL41C.nglCreateShaderProgramv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer) {
/*  161 */     return GL41C.glCreateShaderProgramv(paramInt, paramPointerBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int paramInt, @NativeType("GLchar const * const *") CharSequence... paramVarArgs) {
/*  199 */     return GL41C.glCreateShaderProgramv(paramInt, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int paramInt, @NativeType("GLchar const * const *") CharSequence paramCharSequence) {
/*  236 */     return GL41C.glCreateShaderProgramv(paramInt, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindProgramPipeline(@NativeType("GLuint") int paramInt) {
/*  247 */     GL41C.glBindProgramPipeline(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteProgramPipelines(int paramInt, long paramLong) {
/*  258 */     GL41C.nglDeleteProgramPipelines(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  267 */     GL41C.glDeleteProgramPipelines(paramIntBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int paramInt) {
/*  272 */     GL41C.glDeleteProgramPipelines(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGenProgramPipelines(int paramInt, long paramLong) {
/*  283 */     GL41C.nglGenProgramPipelines(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenProgramPipelines(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  292 */     GL41C.glGenProgramPipelines(paramIntBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenProgramPipelines() {
/*  298 */     return GL41C.glGenProgramPipelines();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsProgramPipeline(@NativeType("GLuint") int paramInt) {
/*  310 */     return GL41C.glIsProgramPipeline(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/*  323 */     GL41C.glProgramParameteri(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramPipelineiv(int paramInt1, int paramInt2, long paramLong) {
/*  330 */     GL41C.nglGetProgramPipelineiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  341 */     GL41C.glGetProgramPipelineiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetProgramPipelinei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  352 */     return GL41C.glGetProgramPipelinei(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3) {
/*  365 */     GL41C.glProgramUniform1i(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4) {
/*  379 */     GL41C.glProgramUniform2i(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5) {
/*  394 */     GL41C.glProgramUniform3i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6) {
/*  410 */     GL41C.glProgramUniform4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  423 */     GL41C.glProgramUniform1ui(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4) {
/*  437 */     GL41C.glProgramUniform2ui(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5) {
/*  452 */     GL41C.glProgramUniform3ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6) {
/*  468 */     GL41C.glProgramUniform4ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat) {
/*  481 */     GL41C.glProgramUniform1f(paramInt1, paramInt2, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2) {
/*  495 */     GL41C.glProgramUniform2f(paramInt1, paramInt2, paramFloat1, paramFloat2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3) {
/*  510 */     GL41C.glProgramUniform3f(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4) {
/*  526 */     GL41C.glProgramUniform4f(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble) {
/*  539 */     GL41C.glProgramUniform1d(paramInt1, paramInt2, paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/*  553 */     GL41C.glProgramUniform2d(paramInt1, paramInt2, paramDouble1, paramDouble2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3) {
/*  568 */     GL41C.glProgramUniform3d(paramInt1, paramInt2, paramDouble1, paramDouble2, paramDouble3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4) {
/*  584 */     GL41C.glProgramUniform4d(paramInt1, paramInt2, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform1iv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  595 */     GL41C.nglProgramUniform1iv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  606 */     GL41C.glProgramUniform1iv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform2iv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  617 */     GL41C.nglProgramUniform2iv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  628 */     GL41C.glProgramUniform2iv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform3iv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  639 */     GL41C.nglProgramUniform3iv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  650 */     GL41C.glProgramUniform3iv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform4iv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  661 */     GL41C.nglProgramUniform4iv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  672 */     GL41C.glProgramUniform4iv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform1uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  683 */     GL41C.nglProgramUniform1uiv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  694 */     GL41C.glProgramUniform1uiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform2uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  705 */     GL41C.nglProgramUniform2uiv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  716 */     GL41C.glProgramUniform2uiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform3uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  727 */     GL41C.nglProgramUniform3uiv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  738 */     GL41C.glProgramUniform3uiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform4uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  749 */     GL41C.nglProgramUniform4uiv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  760 */     GL41C.glProgramUniform4uiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform1fv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  771 */     GL41C.nglProgramUniform1fv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  782 */     GL41C.glProgramUniform1fv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform2fv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  793 */     GL41C.nglProgramUniform2fv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  804 */     GL41C.glProgramUniform2fv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform3fv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  815 */     GL41C.nglProgramUniform3fv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  826 */     GL41C.glProgramUniform3fv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform4fv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  837 */     GL41C.nglProgramUniform4fv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  848 */     GL41C.glProgramUniform4fv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform1dv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  859 */     GL41C.nglProgramUniform1dv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  870 */     GL41C.glProgramUniform1dv(paramInt1, paramInt2, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform2dv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  881 */     GL41C.nglProgramUniform2dv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  892 */     GL41C.glProgramUniform2dv(paramInt1, paramInt2, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform3dv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  903 */     GL41C.nglProgramUniform3dv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  914 */     GL41C.glProgramUniform3dv(paramInt1, paramInt2, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniform4dv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/*  925 */     GL41C.nglProgramUniform4dv(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  936 */     GL41C.glProgramUniform4dv(paramInt1, paramInt2, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/*  947 */     GL41C.nglProgramUniformMatrix2fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  959 */     GL41C.glProgramUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/*  970 */     GL41C.nglProgramUniformMatrix3fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  982 */     GL41C.glProgramUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/*  993 */     GL41C.nglProgramUniformMatrix4fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1005 */     GL41C.glProgramUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1016 */     GL41C.nglProgramUniformMatrix2dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1028 */     GL41C.glProgramUniformMatrix2dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1039 */     GL41C.nglProgramUniformMatrix3dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1051 */     GL41C.glProgramUniformMatrix3dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1062 */     GL41C.nglProgramUniformMatrix4dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1074 */     GL41C.glProgramUniformMatrix4dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2x3fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1085 */     GL41C.nglProgramUniformMatrix2x3fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1097 */     GL41C.glProgramUniformMatrix2x3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3x2fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1108 */     GL41C.nglProgramUniformMatrix3x2fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1120 */     GL41C.glProgramUniformMatrix3x2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2x4fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1131 */     GL41C.nglProgramUniformMatrix2x4fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1143 */     GL41C.glProgramUniformMatrix2x4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4x2fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1154 */     GL41C.nglProgramUniformMatrix4x2fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1166 */     GL41C.glProgramUniformMatrix4x2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3x4fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1177 */     GL41C.nglProgramUniformMatrix3x4fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1189 */     GL41C.glProgramUniformMatrix3x4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4x3fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1200 */     GL41C.nglProgramUniformMatrix4x3fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1212 */     GL41C.glProgramUniformMatrix4x3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2x3dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1223 */     GL41C.nglProgramUniformMatrix2x3dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1235 */     GL41C.glProgramUniformMatrix2x3dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3x2dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1246 */     GL41C.nglProgramUniformMatrix3x2dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1258 */     GL41C.glProgramUniformMatrix3x2dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix2x4dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1269 */     GL41C.nglProgramUniformMatrix2x4dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1281 */     GL41C.glProgramUniformMatrix2x4dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4x2dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1292 */     GL41C.nglProgramUniformMatrix4x2dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1304 */     GL41C.glProgramUniformMatrix4x2dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix3x4dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1315 */     GL41C.nglProgramUniformMatrix3x4dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1327 */     GL41C.glProgramUniformMatrix3x4dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramUniformMatrix4x3dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong) {
/* 1338 */     GL41C.nglProgramUniformMatrix4x3dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1350 */     GL41C.glProgramUniformMatrix4x3dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glValidateProgramPipeline(@NativeType("GLuint") int paramInt) {
/* 1361 */     GL41C.glValidateProgramPipeline(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramPipelineInfoLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
/* 1372 */     GL41C.nglGetProgramPipelineInfoLog(paramInt1, paramInt2, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1383 */     GL41C.glGetProgramPipelineInfoLog(paramInt, paramIntBuffer, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/* 1394 */     return GL41C.glGetProgramPipelineInfoLog(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt) {
/* 1404 */     return glGetProgramPipelineInfoLog(paramInt, glGetProgramPipelinei(paramInt, 35716));
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1409 */     GL41C.glDeleteProgramPipelines(paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGenProgramPipelines(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 1414 */     GL41C.glGenProgramPipelines(paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1419 */     GL41C.glGetProgramPipelineiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1424 */     GL41C.glProgramUniform1iv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1429 */     GL41C.glProgramUniform2iv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1434 */     GL41C.glProgramUniform3iv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1439 */     GL41C.glProgramUniform4iv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1444 */     GL41C.glProgramUniform1uiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1449 */     GL41C.glProgramUniform2uiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1454 */     GL41C.glProgramUniform3uiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1459 */     GL41C.glProgramUniform4uiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1464 */     GL41C.glProgramUniform1fv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1469 */     GL41C.glProgramUniform2fv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1474 */     GL41C.glProgramUniform3fv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1479 */     GL41C.glProgramUniform4fv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1484 */     GL41C.glProgramUniform1dv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1489 */     GL41C.glProgramUniform2dv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1494 */     GL41C.glProgramUniform3dv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1499 */     GL41C.glProgramUniform4dv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1504 */     GL41C.glProgramUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1509 */     GL41C.glProgramUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1514 */     GL41C.glProgramUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1519 */     GL41C.glProgramUniformMatrix2dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1524 */     GL41C.glProgramUniformMatrix3dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1529 */     GL41C.glProgramUniformMatrix4dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1534 */     GL41C.glProgramUniformMatrix2x3fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1539 */     GL41C.glProgramUniformMatrix3x2fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1544 */     GL41C.glProgramUniformMatrix2x4fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1549 */     GL41C.glProgramUniformMatrix4x2fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1554 */     GL41C.glProgramUniformMatrix3x4fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1559 */     GL41C.glProgramUniformMatrix4x3fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1564 */     GL41C.glProgramUniformMatrix2x3dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1569 */     GL41C.glProgramUniformMatrix3x2dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1574 */     GL41C.glProgramUniformMatrix2x4dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1579 */     GL41C.glProgramUniformMatrix4x2dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1584 */     GL41C.glProgramUniformMatrix3x4dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1589 */     GL41C.glProgramUniformMatrix4x3dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1594 */     GL41C.glGetProgramPipelineInfoLog(paramInt, paramArrayOfint, paramByteBuffer);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBSeparateShaderObjects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */