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
/*      */ public class GL41
/*      */   extends GL40
/*      */ {
/*      */   public static final int GL_SHADER_COMPILER = 36346;
/*      */   public static final int GL_SHADER_BINARY_FORMATS = 36344;
/*      */   public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345;
/*      */   public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347;
/*      */   public static final int GL_MAX_VARYING_VECTORS = 36348;
/*      */   public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 36349;
/*      */   public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 35738;
/*      */   public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 35739;
/*      */   public static final int GL_FIXED = 5132;
/*      */   public static final int GL_LOW_FLOAT = 36336;
/*      */   public static final int GL_MEDIUM_FLOAT = 36337;
/*      */   public static final int GL_HIGH_FLOAT = 36338;
/*      */   public static final int GL_LOW_INT = 36339;
/*      */   public static final int GL_MEDIUM_INT = 36340;
/*      */   public static final int GL_HIGH_INT = 36341;
/*      */   public static final int GL_RGB565 = 36194;
/*      */   public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;
/*      */   
/*      */   static {
/*   34 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_PROGRAM_BINARY_FORMATS = 34815;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_VERTEX_SHADER_BIT = 1;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_FRAGMENT_SHADER_BIT = 2;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_GEOMETRY_SHADER_BIT = 4;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_TESS_CONTROL_SHADER_BIT = 8;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_TESS_EVALUATION_SHADER_BIT = 16;
/*      */ 
/*      */   
/*      */   public static final int GL_ALL_SHADER_BITS = -1;
/*      */ 
/*      */   
/*      */   public static final int GL_PROGRAM_SEPARABLE = 33368;
/*      */ 
/*      */   
/*      */   public static final int GL_ACTIVE_PROGRAM = 33369;
/*      */ 
/*      */   
/*      */   public static final int GL_PROGRAM_PIPELINE_BINDING = 33370;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_VIEWPORTS = 33371;
/*      */ 
/*      */   
/*      */   public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;
/*      */ 
/*      */   
/*      */   public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
/*      */ 
/*      */   
/*      */   public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
/*      */ 
/*      */   
/*      */   public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
/*      */ 
/*      */   
/*      */   public static final int GL_UNDEFINED_VERTEX = 33376;
/*      */ 
/*      */ 
/*      */   
/*      */   protected GL41() {
/*  103 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReleaseShaderCompiler() {
/*  114 */     GL41C.glReleaseShaderCompiler();
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
/*      */   public static void nglShaderBinary(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3) {
/*  126 */     GL41C.nglShaderBinary(paramInt1, paramLong1, paramInt2, paramLong2, paramInt3);
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
/*      */   public static void glShaderBinary(@NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  139 */     GL41C.glShaderBinary(paramIntBuffer, paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetShaderPrecisionFormat(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
/*  146 */     GL41C.nglGetShaderPrecisionFormat(paramInt1, paramInt2, paramLong1, paramLong2);
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
/*      */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/*  160 */     GL41C.glGetShaderPrecisionFormat(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2);
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
/*      */   @NativeType("void")
/*      */   public static int glGetShaderPrecisionFormat(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  174 */     return GL41C.glGetShaderPrecisionFormat(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static void glDepthRangef(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2) {
/*  188 */     GL41C.glDepthRangef(paramFloat1, paramFloat2);
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
/*      */   public static void glClearDepthf(@NativeType("GLfloat") float paramFloat) {
/*  201 */     GL41C.glClearDepthf(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramBinary(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {
/*  212 */     GL41C.nglGetProgramBinary(paramInt1, paramInt2, paramLong1, paramLong2, paramLong3);
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
/*      */   public static void glGetProgramBinary(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  226 */     GL41C.glGetProgramBinary(paramInt, paramIntBuffer1, paramIntBuffer2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglProgramBinary(int paramInt1, int paramInt2, long paramLong, int paramInt3) {
/*  237 */     GL41C.nglProgramBinary(paramInt1, paramInt2, paramLong, paramInt3);
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
/*      */   public static void glProgramBinary(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  250 */     GL41C.glProgramBinary(paramInt1, paramInt2, paramByteBuffer);
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
/*      */   public static void glProgramParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/*  265 */     GL41C.glProgramParameteri(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glUseProgramStages(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  280 */     GL41C.glUseProgramStages(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glActiveShaderProgram(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  294 */     GL41C.glActiveShaderProgram(paramInt1, paramInt2);
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
/*  305 */     return GL41C.nglCreateShaderProgramv(paramInt1, paramInt2, paramLong);
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
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer) {
/*  345 */     return GL41C.glCreateShaderProgramv(paramInt, paramPointerBuffer);
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
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int paramInt, @NativeType("GLchar const * const *") CharSequence... paramVarArgs) {
/*  385 */     return GL41C.glCreateShaderProgramv(paramInt, paramVarArgs);
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
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int paramInt, @NativeType("GLchar const * const *") CharSequence paramCharSequence) {
/*  424 */     return GL41C.glCreateShaderProgramv(paramInt, paramCharSequence);
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
/*      */   public static void glBindProgramPipeline(@NativeType("GLuint") int paramInt) {
/*  437 */     GL41C.glBindProgramPipeline(paramInt);
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
/*  448 */     GL41C.nglDeleteProgramPipelines(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  459 */     GL41C.glDeleteProgramPipelines(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int paramInt) {
/*  468 */     GL41C.glDeleteProgramPipelines(paramInt);
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
/*  479 */     GL41C.nglGenProgramPipelines(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenProgramPipelines(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  490 */     GL41C.glGenProgramPipelines(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenProgramPipelines() {
/*  500 */     return GL41C.glGenProgramPipelines();
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
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsProgramPipeline(@NativeType("GLuint") int paramInt) {
/*  514 */     return GL41C.glIsProgramPipeline(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramPipelineiv(int paramInt1, int paramInt2, long paramLong) {
/*  521 */     GL41C.nglGetProgramPipelineiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  534 */     GL41C.glGetProgramPipelineiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   @NativeType("void")
/*      */   public static int glGetProgramPipelinei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  547 */     return GL41C.glGetProgramPipelinei(paramInt1, paramInt2);
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
/*      */   public static void glProgramUniform1i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3) {
/*  562 */     GL41C.glProgramUniform1i(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glProgramUniform2i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4) {
/*  578 */     GL41C.glProgramUniform2i(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glProgramUniform3i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5) {
/*  595 */     GL41C.glProgramUniform3i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glProgramUniform4i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6) {
/*  613 */     GL41C.glProgramUniform4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
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
/*      */   public static void glProgramUniform1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  628 */     GL41C.glProgramUniform1ui(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glProgramUniform2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4) {
/*  644 */     GL41C.glProgramUniform2ui(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glProgramUniform3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5) {
/*  661 */     GL41C.glProgramUniform3ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public static void glProgramUniform4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6) {
/*  679 */     GL41C.glProgramUniform4ui(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
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
/*      */   public static void glProgramUniform1f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat) {
/*  694 */     GL41C.glProgramUniform1f(paramInt1, paramInt2, paramFloat);
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
/*      */   public static void glProgramUniform2f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2) {
/*  710 */     GL41C.glProgramUniform2f(paramInt1, paramInt2, paramFloat1, paramFloat2);
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
/*      */   public static void glProgramUniform3f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3) {
/*  727 */     GL41C.glProgramUniform3f(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3);
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
/*      */   public static void glProgramUniform4f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4) {
/*  745 */     GL41C.glProgramUniform4f(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
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
/*      */   public static void glProgramUniform1d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble) {
/*  760 */     GL41C.glProgramUniform1d(paramInt1, paramInt2, paramDouble);
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
/*      */   public static void glProgramUniform2d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/*  776 */     GL41C.glProgramUniform2d(paramInt1, paramInt2, paramDouble1, paramDouble2);
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
/*      */   public static void glProgramUniform3d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3) {
/*  793 */     GL41C.glProgramUniform3d(paramInt1, paramInt2, paramDouble1, paramDouble2, paramDouble3);
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
/*      */   public static void glProgramUniform4d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4) {
/*  811 */     GL41C.glProgramUniform4d(paramInt1, paramInt2, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
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
/*  822 */     GL41C.nglProgramUniform1iv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform1iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  835 */     GL41C.glProgramUniform1iv(paramInt1, paramInt2, paramIntBuffer);
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
/*  846 */     GL41C.nglProgramUniform2iv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform2iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  859 */     GL41C.glProgramUniform2iv(paramInt1, paramInt2, paramIntBuffer);
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
/*  870 */     GL41C.nglProgramUniform3iv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform3iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  883 */     GL41C.glProgramUniform3iv(paramInt1, paramInt2, paramIntBuffer);
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
/*  894 */     GL41C.nglProgramUniform4iv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform4iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  907 */     GL41C.glProgramUniform4iv(paramInt1, paramInt2, paramIntBuffer);
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
/*  918 */     GL41C.nglProgramUniform1uiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  931 */     GL41C.glProgramUniform1uiv(paramInt1, paramInt2, paramIntBuffer);
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
/*  942 */     GL41C.nglProgramUniform2uiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  955 */     GL41C.glProgramUniform2uiv(paramInt1, paramInt2, paramIntBuffer);
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
/*  966 */     GL41C.nglProgramUniform3uiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  979 */     GL41C.glProgramUniform3uiv(paramInt1, paramInt2, paramIntBuffer);
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
/*  990 */     GL41C.nglProgramUniform4uiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1003 */     GL41C.glProgramUniform4uiv(paramInt1, paramInt2, paramIntBuffer);
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
/* 1014 */     GL41C.nglProgramUniform1fv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform1fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1027 */     GL41C.glProgramUniform1fv(paramInt1, paramInt2, paramFloatBuffer);
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
/* 1038 */     GL41C.nglProgramUniform2fv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1051 */     GL41C.glProgramUniform2fv(paramInt1, paramInt2, paramFloatBuffer);
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
/* 1062 */     GL41C.nglProgramUniform3fv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1075 */     GL41C.glProgramUniform3fv(paramInt1, paramInt2, paramFloatBuffer);
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
/* 1086 */     GL41C.nglProgramUniform4fv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1099 */     GL41C.glProgramUniform4fv(paramInt1, paramInt2, paramFloatBuffer);
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
/* 1110 */     GL41C.nglProgramUniform1dv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform1dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1123 */     GL41C.glProgramUniform1dv(paramInt1, paramInt2, paramDoubleBuffer);
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
/* 1134 */     GL41C.nglProgramUniform2dv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1147 */     GL41C.glProgramUniform2dv(paramInt1, paramInt2, paramDoubleBuffer);
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
/* 1158 */     GL41C.nglProgramUniform3dv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1171 */     GL41C.glProgramUniform3dv(paramInt1, paramInt2, paramDoubleBuffer);
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
/* 1182 */     GL41C.nglProgramUniform4dv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glProgramUniform4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1195 */     GL41C.glProgramUniform4dv(paramInt1, paramInt2, paramDoubleBuffer);
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
/* 1206 */     GL41C.nglProgramUniformMatrix2fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1220 */     GL41C.glProgramUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
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
/* 1231 */     GL41C.nglProgramUniformMatrix3fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1245 */     GL41C.glProgramUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
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
/* 1256 */     GL41C.nglProgramUniformMatrix4fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1270 */     GL41C.glProgramUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
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
/* 1281 */     GL41C.nglProgramUniformMatrix2dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1295 */     GL41C.glProgramUniformMatrix2dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
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
/* 1306 */     GL41C.nglProgramUniformMatrix3dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1320 */     GL41C.glProgramUniformMatrix3dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
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
/* 1331 */     GL41C.nglProgramUniformMatrix4dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1345 */     GL41C.glProgramUniformMatrix4dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
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
/* 1356 */     GL41C.nglProgramUniformMatrix2x3fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1370 */     GL41C.glProgramUniformMatrix2x3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
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
/* 1381 */     GL41C.nglProgramUniformMatrix3x2fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1395 */     GL41C.glProgramUniformMatrix3x2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
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
/* 1406 */     GL41C.nglProgramUniformMatrix2x4fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1420 */     GL41C.glProgramUniformMatrix2x4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
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
/* 1431 */     GL41C.nglProgramUniformMatrix4x2fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1445 */     GL41C.glProgramUniformMatrix4x2fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
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
/* 1456 */     GL41C.nglProgramUniformMatrix3x4fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1470 */     GL41C.glProgramUniformMatrix3x4fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
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
/* 1481 */     GL41C.nglProgramUniformMatrix4x3fv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1495 */     GL41C.glProgramUniformMatrix4x3fv(paramInt1, paramInt2, paramBoolean, paramFloatBuffer);
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
/* 1506 */     GL41C.nglProgramUniformMatrix2x3dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1520 */     GL41C.glProgramUniformMatrix2x3dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
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
/* 1531 */     GL41C.nglProgramUniformMatrix3x2dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1545 */     GL41C.glProgramUniformMatrix3x2dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
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
/* 1556 */     GL41C.nglProgramUniformMatrix2x4dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1570 */     GL41C.glProgramUniformMatrix2x4dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
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
/* 1581 */     GL41C.nglProgramUniformMatrix4x2dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1595 */     GL41C.glProgramUniformMatrix4x2dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
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
/* 1606 */     GL41C.nglProgramUniformMatrix3x4dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1620 */     GL41C.glProgramUniformMatrix3x4dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
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
/* 1631 */     GL41C.nglProgramUniformMatrix4x3dv(paramInt1, paramInt2, paramInt3, paramBoolean, paramLong);
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
/*      */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1645 */     GL41C.glProgramUniformMatrix4x3dv(paramInt1, paramInt2, paramBoolean, paramDoubleBuffer);
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
/*      */   public static void glValidateProgramPipeline(@NativeType("GLuint") int paramInt) {
/* 1658 */     GL41C.glValidateProgramPipeline(paramInt);
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
/* 1669 */     GL41C.nglGetProgramPipelineInfoLog(paramInt1, paramInt2, paramLong1, paramLong2);
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
/*      */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1682 */     GL41C.glGetProgramPipelineInfoLog(paramInt, paramIntBuffer, paramByteBuffer);
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
/*      */   @NativeType("void")
/*      */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/* 1695 */     return GL41C.glGetProgramPipelineInfoLog(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt) {
/* 1707 */     return glGetProgramPipelineInfoLog(paramInt, glGetProgramPipelinei(paramInt, 35716));
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
/*      */   public static void glVertexAttribL1d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble) {
/* 1721 */     GL41C.glVertexAttribL1d(paramInt, paramDouble);
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
/*      */   public static void glVertexAttribL2d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/* 1736 */     GL41C.glVertexAttribL2d(paramInt, paramDouble1, paramDouble2);
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
/*      */   public static void glVertexAttribL3d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3) {
/* 1752 */     GL41C.glVertexAttribL3d(paramInt, paramDouble1, paramDouble2, paramDouble3);
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
/*      */   public static void glVertexAttribL4d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4) {
/* 1769 */     GL41C.glVertexAttribL4d(paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribL1dv(int paramInt, long paramLong) {
/* 1776 */     GL41C.nglVertexAttribL1dv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribL1dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1788 */     GL41C.glVertexAttribL1dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribL2dv(int paramInt, long paramLong) {
/* 1795 */     GL41C.nglVertexAttribL2dv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribL2dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1807 */     GL41C.glVertexAttribL2dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribL3dv(int paramInt, long paramLong) {
/* 1814 */     GL41C.nglVertexAttribL3dv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribL3dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1826 */     GL41C.glVertexAttribL3dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribL4dv(int paramInt, long paramLong) {
/* 1833 */     GL41C.nglVertexAttribL4dv(paramInt, paramLong);
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
/*      */   public static void glVertexAttribL4dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1845 */     GL41C.glVertexAttribL4dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribLPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/* 1856 */     GL41C.nglVertexAttribLPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glVertexAttribLPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1873 */     GL41C.glVertexAttribLPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
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
/*      */   public static void glVertexAttribLPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") long paramLong) {
/* 1890 */     GL41C.glVertexAttribLPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glVertexAttribLPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 1906 */     GL41C.glVertexAttribLPointer(paramInt1, paramInt2, paramInt3, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribLdv(int paramInt1, int paramInt2, long paramLong) {
/* 1913 */     GL41C.nglGetVertexAttribLdv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetVertexAttribLdv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 1926 */     GL41C.glGetVertexAttribLdv(paramInt1, paramInt2, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglViewportArrayv(int paramInt1, int paramInt2, long paramLong) {
/* 1937 */     GL41C.nglViewportArrayv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glViewportArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1949 */     GL41C.glViewportArrayv(paramInt, paramFloatBuffer);
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
/*      */   public static void glViewportIndexedf(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4) {
/* 1966 */     GL41C.glViewportIndexedf(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglViewportIndexedfv(int paramInt, long paramLong) {
/* 1973 */     GL41C.nglViewportIndexedfv(paramInt, paramLong);
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
/*      */   public static void glViewportIndexedfv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1985 */     GL41C.glViewportIndexedfv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglScissorArrayv(int paramInt1, int paramInt2, long paramLong) {
/* 1996 */     GL41C.nglScissorArrayv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glScissorArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2008 */     GL41C.glScissorArrayv(paramInt, paramIntBuffer);
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
/*      */   public static void glScissorIndexed(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 2025 */     GL41C.glScissorIndexed(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglScissorIndexedv(int paramInt, long paramLong) {
/* 2032 */     GL41C.nglScissorIndexedv(paramInt, paramLong);
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
/*      */   public static void glScissorIndexedv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 2044 */     GL41C.glScissorIndexedv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDepthRangeArrayv(int paramInt1, int paramInt2, long paramLong) {
/* 2055 */     GL41C.nglDepthRangeArrayv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glDepthRangeArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 2067 */     GL41C.glDepthRangeArrayv(paramInt, paramDoubleBuffer);
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
/*      */   public static void glDepthRangeIndexed(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/* 2082 */     GL41C.glDepthRangeIndexed(paramInt, paramDouble1, paramDouble2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetFloati_v(int paramInt1, int paramInt2, long paramLong) {
/* 2089 */     GL41C.nglGetFloati_v(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetFloati_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2102 */     GL41C.glGetFloati_v(paramInt1, paramInt2, paramFloatBuffer);
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
/*      */   @NativeType("void")
/*      */   public static float glGetFloati(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2115 */     return GL41C.glGetFloati(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetDoublei_v(int paramInt1, int paramInt2, long paramLong) {
/* 2122 */     GL41C.nglGetDoublei_v(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetDoublei_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 2135 */     GL41C.glGetDoublei_v(paramInt1, paramInt2, paramDoubleBuffer);
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
/*      */   @NativeType("void")
/*      */   public static double glGetDoublei(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2148 */     return GL41C.glGetDoublei(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glShaderBinary(@NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2157 */     GL41C.glShaderBinary(paramArrayOfint, paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 2166 */     GL41C.glGetShaderPrecisionFormat(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramBinary(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 2175 */     GL41C.glGetProgramBinary(paramInt, paramArrayOfint1, paramArrayOfint2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2184 */     GL41C.glDeleteProgramPipelines(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenProgramPipelines(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 2193 */     GL41C.glGenProgramPipelines(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2202 */     GL41C.glGetProgramPipelineiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2211 */     GL41C.glProgramUniform1iv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2220 */     GL41C.glProgramUniform2iv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2229 */     GL41C.glProgramUniform3iv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2238 */     GL41C.glProgramUniform4iv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2247 */     GL41C.glProgramUniform1uiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2256 */     GL41C.glProgramUniform2uiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2265 */     GL41C.glProgramUniform3uiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2274 */     GL41C.glProgramUniform4uiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2283 */     GL41C.glProgramUniform1fv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2292 */     GL41C.glProgramUniform2fv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2301 */     GL41C.glProgramUniform3fv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2310 */     GL41C.glProgramUniform4fv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2319 */     GL41C.glProgramUniform1dv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2328 */     GL41C.glProgramUniform2dv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2337 */     GL41C.glProgramUniform3dv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2346 */     GL41C.glProgramUniform4dv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2355 */     GL41C.glProgramUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2364 */     GL41C.glProgramUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2373 */     GL41C.glProgramUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2382 */     GL41C.glProgramUniformMatrix2dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2391 */     GL41C.glProgramUniformMatrix3dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2400 */     GL41C.glProgramUniformMatrix4dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2409 */     GL41C.glProgramUniformMatrix2x3fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2418 */     GL41C.glProgramUniformMatrix3x2fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2427 */     GL41C.glProgramUniformMatrix2x4fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2436 */     GL41C.glProgramUniformMatrix4x2fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2445 */     GL41C.glProgramUniformMatrix3x4fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2454 */     GL41C.glProgramUniformMatrix4x3fv(paramInt1, paramInt2, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2463 */     GL41C.glProgramUniformMatrix2x3dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2472 */     GL41C.glProgramUniformMatrix3x2dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2481 */     GL41C.glProgramUniformMatrix2x4dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2490 */     GL41C.glProgramUniformMatrix4x2dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2499 */     GL41C.glProgramUniformMatrix3x4dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2508 */     GL41C.glProgramUniformMatrix4x3dv(paramInt1, paramInt2, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2517 */     GL41C.glGetProgramPipelineInfoLog(paramInt, paramArrayOfint, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL1dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2526 */     GL41C.glVertexAttribL1dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL2dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2535 */     GL41C.glVertexAttribL2dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL3dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2544 */     GL41C.glVertexAttribL3dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL4dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2553 */     GL41C.glVertexAttribL4dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribLdv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 2562 */     GL41C.glGetVertexAttribLdv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glViewportArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2571 */     GL41C.glViewportArrayv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glViewportIndexedfv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2580 */     GL41C.glViewportIndexedfv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glScissorArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2589 */     GL41C.glScissorArrayv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glScissorIndexedv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2598 */     GL41C.glScissorIndexedv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDepthRangeArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2607 */     GL41C.glDepthRangeArrayv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFloati_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2616 */     GL41C.glGetFloati_v(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetDoublei_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 2625 */     GL41C.glGetDoublei_v(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL41.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */