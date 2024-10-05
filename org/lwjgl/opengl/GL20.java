/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
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
/*      */ public class GL20
/*      */   extends GL15
/*      */ {
/*      */   public static final int GL_SHADING_LANGUAGE_VERSION = 35724;
/*      */   public static final int GL_CURRENT_PROGRAM = 35725;
/*      */   public static final int GL_SHADER_TYPE = 35663;
/*      */   public static final int GL_DELETE_STATUS = 35712;
/*      */   public static final int GL_COMPILE_STATUS = 35713;
/*      */   public static final int GL_LINK_STATUS = 35714;
/*      */   public static final int GL_VALIDATE_STATUS = 35715;
/*      */   public static final int GL_INFO_LOG_LENGTH = 35716;
/*      */   public static final int GL_ATTACHED_SHADERS = 35717;
/*      */   public static final int GL_ACTIVE_UNIFORMS = 35718;
/*      */   
/*      */   static {
/*   33 */     GL.initialize();
/*      */   }
/*      */ 
/*      */   
/*      */   public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719;
/*      */   
/*      */   public static final int GL_ACTIVE_ATTRIBUTES = 35721;
/*      */   
/*      */   public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722;
/*      */   
/*      */   public static final int GL_SHADER_SOURCE_LENGTH = 35720;
/*      */   
/*      */   public static final int GL_FLOAT_VEC2 = 35664;
/*      */   
/*      */   public static final int GL_FLOAT_VEC3 = 35665;
/*      */   
/*      */   public static final int GL_FLOAT_VEC4 = 35666;
/*      */   
/*      */   public static final int GL_INT_VEC2 = 35667;
/*      */   
/*      */   public static final int GL_INT_VEC3 = 35668;
/*      */   
/*      */   public static final int GL_INT_VEC4 = 35669;
/*      */   
/*      */   public static final int GL_BOOL = 35670;
/*      */   
/*      */   public static final int GL_BOOL_VEC2 = 35671;
/*      */   
/*      */   public static final int GL_BOOL_VEC3 = 35672;
/*      */   
/*      */   public static final int GL_BOOL_VEC4 = 35673;
/*      */   
/*      */   public static final int GL_FLOAT_MAT2 = 35674;
/*      */   
/*      */   public static final int GL_FLOAT_MAT3 = 35675;
/*      */   
/*      */   public static final int GL_FLOAT_MAT4 = 35676;
/*      */   
/*      */   public static final int GL_SAMPLER_1D = 35677;
/*      */   
/*      */   public static final int GL_SAMPLER_2D = 35678;
/*      */   
/*      */   public static final int GL_SAMPLER_3D = 35679;
/*      */   
/*      */   public static final int GL_SAMPLER_CUBE = 35680;
/*      */   
/*      */   public static final int GL_SAMPLER_1D_SHADOW = 35681;
/*      */   
/*      */   public static final int GL_SAMPLER_2D_SHADOW = 35682;
/*      */   
/*      */   public static final int GL_VERTEX_SHADER = 35633;
/*      */   
/*      */   public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 35658;
/*      */   
/*      */   public static final int GL_MAX_VARYING_FLOATS = 35659;
/*      */   
/*      */   public static final int GL_MAX_VERTEX_ATTRIBS = 34921;
/*      */   
/*      */   public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930;
/*      */   
/*      */   public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660;
/*      */   
/*      */   public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661;
/*      */   
/*      */   public static final int GL_MAX_TEXTURE_COORDS = 34929;
/*      */   
/*      */   public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370;
/*      */   
/*      */   public static final int GL_VERTEX_PROGRAM_TWO_SIDE = 34371;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922;
/*      */   
/*      */   public static final int GL_CURRENT_VERTEX_ATTRIB = 34342;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373;
/*      */   
/*      */   public static final int GL_FRAGMENT_SHADER = 35632;
/*      */   
/*      */   public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 35657;
/*      */   
/*      */   public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 35723;
/*      */   
/*      */   public static final int GL_MAX_DRAW_BUFFERS = 34852;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER0 = 34853;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER1 = 34854;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER2 = 34855;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER3 = 34856;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER4 = 34857;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER5 = 34858;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER6 = 34859;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER7 = 34860;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER8 = 34861;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER9 = 34862;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER10 = 34863;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER11 = 34864;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER12 = 34865;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER13 = 34866;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER14 = 34867;
/*      */   
/*      */   public static final int GL_DRAW_BUFFER15 = 34868;
/*      */   
/*      */   public static final int GL_POINT_SPRITE = 34913;
/*      */   
/*      */   public static final int GL_COORD_REPLACE = 34914;
/*      */   
/*      */   public static final int GL_POINT_SPRITE_COORD_ORIGIN = 36000;
/*      */   
/*      */   public static final int GL_LOWER_LEFT = 36001;
/*      */   public static final int GL_UPPER_LEFT = 36002;
/*      */   public static final int GL_BLEND_EQUATION_RGB = 32777;
/*      */   public static final int GL_BLEND_EQUATION_ALPHA = 34877;
/*      */   public static final int GL_STENCIL_BACK_FUNC = 34816;
/*      */   public static final int GL_STENCIL_BACK_FAIL = 34817;
/*      */   public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818;
/*      */   public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819;
/*      */   public static final int GL_STENCIL_BACK_REF = 36003;
/*      */   public static final int GL_STENCIL_BACK_VALUE_MASK = 36004;
/*      */   public static final int GL_STENCIL_BACK_WRITEMASK = 36005;
/*      */   
/*      */   protected GL20() {
/*  176 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateProgram() {
/*  188 */     return GL20C.glCreateProgram();
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
/*      */   public static void glDeleteProgram(@NativeType("GLuint") int paramInt) {
/*  201 */     GL20C.glDeleteProgram(paramInt);
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
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsProgram(@NativeType("GLuint") int paramInt) {
/*  216 */     return GL20C.glIsProgram(paramInt);
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
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShader(@NativeType("GLenum") int paramInt) {
/*  230 */     return GL20C.glCreateShader(paramInt);
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
/*      */   public static void glDeleteShader(@NativeType("GLuint") int paramInt) {
/*  243 */     GL20C.glDeleteShader(paramInt);
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
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsShader(@NativeType("GLuint") int paramInt) {
/*  258 */     return GL20C.glIsShader(paramInt);
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
/*      */   public static void glAttachShader(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  283 */     GL20C.glAttachShader(paramInt1, paramInt2);
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
/*      */   public static void glDetachShader(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  297 */     GL20C.glDetachShader(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglShaderSource(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
/*  308 */     GL20C.nglShaderSource(paramInt1, paramInt2, paramLong1, paramLong2);
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
/*      */   public static void glShaderSource(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  326 */     GL20C.glShaderSource(paramInt, paramPointerBuffer, paramIntBuffer);
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
/*      */   public static void glShaderSource(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") CharSequence... paramVarArgs) {
/*  343 */     GL20C.glShaderSource(paramInt, paramVarArgs);
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
/*      */   public static void glShaderSource(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") CharSequence paramCharSequence) {
/*  359 */     GL20C.glShaderSource(paramInt, paramCharSequence);
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
/*      */   public static void glCompileShader(@NativeType("GLuint") int paramInt) {
/*  372 */     GL20C.glCompileShader(paramInt);
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
/*      */   public static void glLinkProgram(@NativeType("GLuint") int paramInt) {
/*  385 */     GL20C.glLinkProgram(paramInt);
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
/*      */   public static void glUseProgram(@NativeType("GLuint") int paramInt) {
/*  398 */     GL20C.glUseProgram(paramInt);
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
/*      */   public static void glValidateProgram(@NativeType("GLuint") int paramInt) {
/*  411 */     GL20C.glValidateProgram(paramInt);
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
/*      */   public static void glUniform1f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat) {
/*  425 */     GL20C.glUniform1f(paramInt, paramFloat);
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
/*      */   public static void glUniform2f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2) {
/*  440 */     GL20C.glUniform2f(paramInt, paramFloat1, paramFloat2);
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
/*      */   public static void glUniform3f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3) {
/*  456 */     GL20C.glUniform3f(paramInt, paramFloat1, paramFloat2, paramFloat3);
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
/*      */   public static void glUniform4f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4) {
/*  473 */     GL20C.glUniform4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
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
/*      */   public static void glUniform1i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*  487 */     GL20C.glUniform1i(paramInt1, paramInt2);
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
/*      */   public static void glUniform2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3) {
/*  502 */     GL20C.glUniform2i(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glUniform3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4) {
/*  518 */     GL20C.glUniform3i(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glUniform4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5) {
/*  535 */     GL20C.glUniform4i(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform1fv(int paramInt1, int paramInt2, long paramLong) {
/*  546 */     GL20C.nglUniform1fv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform1fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  558 */     GL20C.glUniform1fv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform2fv(int paramInt1, int paramInt2, long paramLong) {
/*  569 */     GL20C.nglUniform2fv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform2fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  581 */     GL20C.glUniform2fv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform3fv(int paramInt1, int paramInt2, long paramLong) {
/*  592 */     GL20C.nglUniform3fv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform3fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  604 */     GL20C.glUniform3fv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform4fv(int paramInt1, int paramInt2, long paramLong) {
/*  615 */     GL20C.nglUniform4fv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform4fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  627 */     GL20C.glUniform4fv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform1iv(int paramInt1, int paramInt2, long paramLong) {
/*  638 */     GL20C.nglUniform1iv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform1iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  650 */     GL20C.glUniform1iv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform2iv(int paramInt1, int paramInt2, long paramLong) {
/*  661 */     GL20C.nglUniform2iv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform2iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  673 */     GL20C.glUniform2iv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform3iv(int paramInt1, int paramInt2, long paramLong) {
/*  684 */     GL20C.nglUniform3iv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform3iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  696 */     GL20C.glUniform3iv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform4iv(int paramInt1, int paramInt2, long paramLong) {
/*  707 */     GL20C.nglUniform4iv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform4iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  719 */     GL20C.glUniform4iv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  730 */     GL20C.nglUniformMatrix2fv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  743 */     GL20C.glUniformMatrix2fv(paramInt, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  754 */     GL20C.nglUniformMatrix3fv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  767 */     GL20C.glUniformMatrix3fv(paramInt, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  778 */     GL20C.nglUniformMatrix4fv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  791 */     GL20C.glUniformMatrix4fv(paramInt, paramBoolean, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetShaderiv(int paramInt1, int paramInt2, long paramLong) {
/*  798 */     GL20C.nglGetShaderiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetShaderiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  811 */     GL20C.glGetShaderiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetShaderi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  824 */     return GL20C.glGetShaderi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramiv(int paramInt1, int paramInt2, long paramLong) {
/*  831 */     GL20C.nglGetProgramiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetProgramiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  844 */     GL20C.glGetProgramiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetProgrami(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  857 */     return GL20C.glGetProgrami(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetShaderInfoLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
/*  868 */     GL20C.nglGetShaderInfoLog(paramInt1, paramInt2, paramLong1, paramLong2);
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
/*      */   public static void glGetShaderInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/*  881 */     GL20C.glGetShaderInfoLog(paramInt, paramIntBuffer, paramByteBuffer);
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
/*      */   public static String glGetShaderInfoLog(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/*  894 */     return GL20C.glGetShaderInfoLog(paramInt1, paramInt2);
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
/*      */   public static String glGetShaderInfoLog(@NativeType("GLuint") int paramInt) {
/*  906 */     return glGetShaderInfoLog(paramInt, glGetShaderi(paramInt, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramInfoLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
/*  917 */     GL20C.nglGetProgramInfoLog(paramInt1, paramInt2, paramLong1, paramLong2);
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
/*      */   public static void glGetProgramInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/*  930 */     GL20C.glGetProgramInfoLog(paramInt, paramIntBuffer, paramByteBuffer);
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
/*      */   public static String glGetProgramInfoLog(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/*  943 */     return GL20C.glGetProgramInfoLog(paramInt1, paramInt2);
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
/*      */   public static String glGetProgramInfoLog(@NativeType("GLuint") int paramInt) {
/*  955 */     return glGetProgramInfoLog(paramInt, glGetProgrami(paramInt, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetAttachedShaders(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
/*  966 */     GL20C.nglGetAttachedShaders(paramInt1, paramInt2, paramLong1, paramLong2);
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
/*      */   public static void glGetAttachedShaders(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLuint *") IntBuffer paramIntBuffer2) {
/*  979 */     GL20C.glGetAttachedShaders(paramInt, paramIntBuffer1, paramIntBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetUniformLocation(int paramInt, long paramLong) {
/*  986 */     return GL20C.nglGetUniformLocation(paramInt, paramLong);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetUniformLocation(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  999 */     return GL20C.glGetUniformLocation(paramInt, paramByteBuffer);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetUniformLocation(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 1012 */     return GL20C.glGetUniformLocation(paramInt, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetActiveUniform(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 1023 */     GL20C.nglGetActiveUniform(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3, paramLong4);
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
/*      */   public static void glGetActiveUniform(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1039 */     GL20C.glGetActiveUniform(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3, paramByteBuffer);
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
/*      */   @NativeType("void")
/*      */   public static String glGetActiveUniform(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 1055 */     return GL20C.glGetActiveUniform(paramInt1, paramInt2, paramInt3, paramIntBuffer1, paramIntBuffer2);
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
/*      */   @NativeType("void")
/*      */   public static String glGetActiveUniform(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 1070 */     return glGetActiveUniform(paramInt1, paramInt2, glGetProgrami(paramInt1, 35719), paramIntBuffer1, paramIntBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetUniformfv(int paramInt1, int paramInt2, long paramLong) {
/* 1077 */     GL20C.nglGetUniformfv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetUniformfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1090 */     GL20C.glGetUniformfv(paramInt1, paramInt2, paramFloatBuffer);
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
/*      */   public static float glGetUniformf(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 1103 */     return GL20C.glGetUniformf(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetUniformiv(int paramInt1, int paramInt2, long paramLong) {
/* 1110 */     GL20C.nglGetUniformiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1123 */     GL20C.glGetUniformiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetUniformi(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 1136 */     return GL20C.glGetUniformi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetShaderSource(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
/* 1147 */     GL20C.nglGetShaderSource(paramInt1, paramInt2, paramLong1, paramLong2);
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
/*      */   public static void glGetShaderSource(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1160 */     GL20C.glGetShaderSource(paramInt, paramIntBuffer, paramByteBuffer);
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
/*      */   public static String glGetShaderSource(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/* 1173 */     return GL20C.glGetShaderSource(paramInt1, paramInt2);
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
/*      */   public static String glGetShaderSource(@NativeType("GLuint") int paramInt) {
/* 1185 */     return glGetShaderSource(paramInt, glGetShaderi(paramInt, 35720));
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
/*      */   public static void glVertexAttrib1f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat) {
/* 1199 */     GL20C.glVertexAttrib1f(paramInt, paramFloat);
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
/*      */   public static void glVertexAttrib1s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort) {
/* 1213 */     GL20C.glVertexAttrib1s(paramInt, paramShort);
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
/*      */   public static void glVertexAttrib1d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble) {
/* 1227 */     GL20C.glVertexAttrib1d(paramInt, paramDouble);
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
/*      */   public static void glVertexAttrib2f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2) {
/* 1242 */     GL20C.glVertexAttrib2f(paramInt, paramFloat1, paramFloat2);
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
/*      */   public static void glVertexAttrib2s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2) {
/* 1257 */     GL20C.glVertexAttrib2s(paramInt, paramShort1, paramShort2);
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
/*      */   public static void glVertexAttrib2d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/* 1272 */     GL20C.glVertexAttrib2d(paramInt, paramDouble1, paramDouble2);
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
/*      */   public static void glVertexAttrib3f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3) {
/* 1288 */     GL20C.glVertexAttrib3f(paramInt, paramFloat1, paramFloat2, paramFloat3);
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
/*      */   public static void glVertexAttrib3s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3) {
/* 1304 */     GL20C.glVertexAttrib3s(paramInt, paramShort1, paramShort2, paramShort3);
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
/*      */   public static void glVertexAttrib3d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3) {
/* 1320 */     GL20C.glVertexAttrib3d(paramInt, paramDouble1, paramDouble2, paramDouble3);
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
/*      */   public static void glVertexAttrib4f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4) {
/* 1337 */     GL20C.glVertexAttrib4f(paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
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
/*      */   public static void glVertexAttrib4s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4) {
/* 1354 */     GL20C.glVertexAttrib4s(paramInt, paramShort1, paramShort2, paramShort3, paramShort4);
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
/*      */   public static void glVertexAttrib4d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4) {
/* 1371 */     GL20C.glVertexAttrib4d(paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
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
/*      */   public static void glVertexAttrib4Nub(@NativeType("GLuint") int paramInt, @NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3, @NativeType("GLubyte") byte paramByte4) {
/* 1388 */     GL20C.glVertexAttrib4Nub(paramInt, paramByte1, paramByte2, paramByte3, paramByte4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1fv(int paramInt, long paramLong) {
/* 1395 */     GL20C.nglVertexAttrib1fv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib1fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1407 */     GL20C.glVertexAttrib1fv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1sv(int paramInt, long paramLong) {
/* 1414 */     GL20C.nglVertexAttrib1sv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib1sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 1426 */     GL20C.glVertexAttrib1sv(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib1dv(int paramInt, long paramLong) {
/* 1433 */     GL20C.nglVertexAttrib1dv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib1dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1445 */     GL20C.glVertexAttrib1dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2fv(int paramInt, long paramLong) {
/* 1452 */     GL20C.nglVertexAttrib2fv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib2fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1464 */     GL20C.glVertexAttrib2fv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2sv(int paramInt, long paramLong) {
/* 1471 */     GL20C.nglVertexAttrib2sv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib2sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 1483 */     GL20C.glVertexAttrib2sv(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib2dv(int paramInt, long paramLong) {
/* 1490 */     GL20C.nglVertexAttrib2dv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib2dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1502 */     GL20C.glVertexAttrib2dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3fv(int paramInt, long paramLong) {
/* 1509 */     GL20C.nglVertexAttrib3fv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib3fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1521 */     GL20C.glVertexAttrib3fv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3sv(int paramInt, long paramLong) {
/* 1528 */     GL20C.nglVertexAttrib3sv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib3sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 1540 */     GL20C.glVertexAttrib3sv(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib3dv(int paramInt, long paramLong) {
/* 1547 */     GL20C.nglVertexAttrib3dv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib3dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1559 */     GL20C.glVertexAttrib3dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4fv(int paramInt, long paramLong) {
/* 1566 */     GL20C.nglVertexAttrib4fv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1578 */     GL20C.glVertexAttrib4fv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4sv(int paramInt, long paramLong) {
/* 1585 */     GL20C.nglVertexAttrib4sv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 1597 */     GL20C.glVertexAttrib4sv(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4dv(int paramInt, long paramLong) {
/* 1604 */     GL20C.nglVertexAttrib4dv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1616 */     GL20C.glVertexAttrib4dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4iv(int paramInt, long paramLong) {
/* 1623 */     GL20C.nglVertexAttrib4iv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1635 */     GL20C.glVertexAttrib4iv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4bv(int paramInt, long paramLong) {
/* 1642 */     GL20C.nglVertexAttrib4bv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4bv(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/* 1654 */     GL20C.glVertexAttrib4bv(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4ubv(int paramInt, long paramLong) {
/* 1661 */     GL20C.nglVertexAttrib4ubv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4ubv(@NativeType("GLuint") int paramInt, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/* 1673 */     GL20C.glVertexAttrib4ubv(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4usv(int paramInt, long paramLong) {
/* 1680 */     GL20C.nglVertexAttrib4usv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4usv(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/* 1692 */     GL20C.glVertexAttrib4usv(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4uiv(int paramInt, long paramLong) {
/* 1699 */     GL20C.nglVertexAttrib4uiv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1711 */     GL20C.glVertexAttrib4uiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Nbv(int paramInt, long paramLong) {
/* 1718 */     GL20C.nglVertexAttrib4Nbv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4Nbv(@NativeType("GLuint") int paramInt, @NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/* 1730 */     GL20C.glVertexAttrib4Nbv(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Nsv(int paramInt, long paramLong) {
/* 1737 */     GL20C.nglVertexAttrib4Nsv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4Nsv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/* 1749 */     GL20C.glVertexAttrib4Nsv(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Niv(int paramInt, long paramLong) {
/* 1756 */     GL20C.nglVertexAttrib4Niv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4Niv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1768 */     GL20C.glVertexAttrib4Niv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Nubv(int paramInt, long paramLong) {
/* 1775 */     GL20C.nglVertexAttrib4Nubv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4Nubv(@NativeType("GLuint") int paramInt, @NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/* 1787 */     GL20C.glVertexAttrib4Nubv(paramInt, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Nusv(int paramInt, long paramLong) {
/* 1794 */     GL20C.nglVertexAttrib4Nusv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4Nusv(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/* 1806 */     GL20C.glVertexAttrib4Nusv(paramInt, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttrib4Nuiv(int paramInt, long paramLong) {
/* 1813 */     GL20C.nglVertexAttrib4Nuiv(paramInt, paramLong);
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
/*      */   public static void glVertexAttrib4Nuiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1825 */     GL20C.glVertexAttrib4Nuiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong) {
/* 1832 */     GL20C.nglVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramLong);
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
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 1850 */     GL20C.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramByteBuffer);
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
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") long paramLong) {
/* 1868 */     GL20C.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramLong);
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
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 1886 */     GL20C.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramShortBuffer);
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
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 1904 */     GL20C.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramIntBuffer);
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
/*      */   public static void glVertexAttribPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 1922 */     GL20C.glVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramFloatBuffer);
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
/*      */   public static void glEnableVertexAttribArray(@NativeType("GLuint") int paramInt) {
/* 1935 */     GL20C.glEnableVertexAttribArray(paramInt);
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
/*      */   public static void glDisableVertexAttribArray(@NativeType("GLuint") int paramInt) {
/* 1948 */     GL20C.glDisableVertexAttribArray(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBindAttribLocation(int paramInt1, int paramInt2, long paramLong) {
/* 1955 */     GL20C.nglBindAttribLocation(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glBindAttribLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 1968 */     GL20C.glBindAttribLocation(paramInt1, paramInt2, paramByteBuffer);
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
/*      */   public static void glBindAttribLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 1981 */     GL20C.glBindAttribLocation(paramInt1, paramInt2, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetActiveAttrib(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 1992 */     GL20C.nglGetActiveAttrib(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3, paramLong4);
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
/*      */   public static void glGetActiveAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2009 */     GL20C.glGetActiveAttrib(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2, paramIntBuffer3, paramByteBuffer);
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
/*      */   @NativeType("void")
/*      */   public static String glGetActiveAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 2025 */     return GL20C.glGetActiveAttrib(paramInt1, paramInt2, paramInt3, paramIntBuffer1, paramIntBuffer2);
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
/*      */   @NativeType("void")
/*      */   public static String glGetActiveAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 2040 */     return glGetActiveAttrib(paramInt1, paramInt2, glGetProgrami(paramInt1, 35722), paramIntBuffer1, paramIntBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetAttribLocation(int paramInt, long paramLong) {
/* 2047 */     return GL20C.nglGetAttribLocation(paramInt, paramLong);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetAttribLocation(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 2060 */     return GL20C.glGetAttribLocation(paramInt, paramByteBuffer);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetAttribLocation(@NativeType("GLuint") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/* 2073 */     return GL20C.glGetAttribLocation(paramInt, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribiv(int paramInt1, int paramInt2, long paramLong) {
/* 2080 */     GL20C.nglGetVertexAttribiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetVertexAttribiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2093 */     GL20C.glGetVertexAttribiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetVertexAttribi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2106 */     return GL20C.glGetVertexAttribi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribfv(int paramInt1, int paramInt2, long paramLong) {
/* 2113 */     GL20C.nglGetVertexAttribfv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetVertexAttribfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2126 */     GL20C.glGetVertexAttribfv(paramInt1, paramInt2, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribdv(int paramInt1, int paramInt2, long paramLong) {
/* 2133 */     GL20C.nglGetVertexAttribdv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetVertexAttribdv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 2146 */     GL20C.glGetVertexAttribdv(paramInt1, paramInt2, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetVertexAttribPointerv(int paramInt1, int paramInt2, long paramLong) {
/* 2153 */     GL20C.nglGetVertexAttribPointerv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetVertexAttribPointerv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 2166 */     GL20C.glGetVertexAttribPointerv(paramInt1, paramInt2, paramPointerBuffer);
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
/*      */   public static long glGetVertexAttribPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2179 */     return GL20C.glGetVertexAttribPointer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDrawBuffers(int paramInt, long paramLong) {
/* 2190 */     GL20C.nglDrawBuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 2201 */     GL20C.glDrawBuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") int paramInt) {
/* 2210 */     GL20C.glDrawBuffers(paramInt);
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
/*      */   public static void glBlendEquationSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 2224 */     GL20C.glBlendEquationSeparate(paramInt1, paramInt2);
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
/*      */   public static void glStencilOpSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4) {
/* 2241 */     GL20C.glStencilOpSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glStencilFuncSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 2258 */     GL20C.glStencilFuncSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static void glStencilMaskSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 2272 */     GL20C.glStencilMaskSeparate(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glShaderSource(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2281 */     GL20C.glShaderSource(paramInt, paramPointerBuffer, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2290 */     GL20C.glUniform1fv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2299 */     GL20C.glUniform2fv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2308 */     GL20C.glUniform3fv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2317 */     GL20C.glUniform4fv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2326 */     GL20C.glUniform1iv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2335 */     GL20C.glUniform2iv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2344 */     GL20C.glUniform3iv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2353 */     GL20C.glUniform4iv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2362 */     GL20C.glUniformMatrix2fv(paramInt, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2371 */     GL20C.glUniformMatrix3fv(paramInt, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2380 */     GL20C.glUniformMatrix4fv(paramInt, paramBoolean, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2389 */     GL20C.glGetShaderiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2398 */     GL20C.glGetProgramiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2407 */     GL20C.glGetShaderInfoLog(paramInt, paramArrayOfint, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2416 */     GL20C.glGetProgramInfoLog(paramInt, paramArrayOfint, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetAttachedShaders(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLuint *") int[] paramArrayOfint2) {
/* 2425 */     GL20C.glGetAttachedShaders(paramInt, paramArrayOfint1, paramArrayOfint2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveUniform(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2434 */     GL20C.glGetActiveUniform(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2443 */     GL20C.glGetUniformfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2452 */     GL20C.glGetUniformiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderSource(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2461 */     GL20C.glGetShaderSource(paramInt, paramArrayOfint, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2470 */     GL20C.glVertexAttrib1fv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2479 */     GL20C.glVertexAttrib1sv(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2488 */     GL20C.glVertexAttrib1dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2497 */     GL20C.glVertexAttrib2fv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2506 */     GL20C.glVertexAttrib2sv(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2515 */     GL20C.glVertexAttrib2dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2524 */     GL20C.glVertexAttrib3fv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2533 */     GL20C.glVertexAttrib3sv(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2542 */     GL20C.glVertexAttrib3dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2551 */     GL20C.glVertexAttrib4fv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2560 */     GL20C.glVertexAttrib4sv(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2569 */     GL20C.glVertexAttrib4dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2578 */     GL20C.glVertexAttrib4iv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usv(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 2587 */     GL20C.glVertexAttrib4usv(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2596 */     GL20C.glVertexAttrib4uiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nsv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2605 */     GL20C.glVertexAttrib4Nsv(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Niv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2614 */     GL20C.glVertexAttrib4Niv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nusv(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 2623 */     GL20C.glVertexAttrib4Nusv(paramInt, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nuiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2632 */     GL20C.glVertexAttrib4Nuiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2641 */     GL20C.glGetActiveAttrib(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2650 */     GL20C.glGetVertexAttribiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2659 */     GL20C.glGetVertexAttribfv(paramInt1, paramInt2, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 2668 */     GL20C.glGetVertexAttribdv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") int[] paramArrayOfint) {
/* 2677 */     GL20C.glDrawBuffers(paramArrayOfint);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL20.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */