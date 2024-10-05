/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GL40
/*      */   extends GL33
/*      */ {
/*      */   public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
/*      */   public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;
/*      */   public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943;
/*      */   public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442;
/*      */   public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 36443;
/*      */   public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 36444;
/*      */   public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 36445;
/*      */   public static final int GL_DOUBLE_VEC2 = 36860;
/*      */   public static final int GL_DOUBLE_VEC3 = 36861;
/*      */   public static final int GL_DOUBLE_VEC4 = 36862;
/*      */   public static final int GL_DOUBLE_MAT2 = 36678;
/*      */   public static final int GL_DOUBLE_MAT3 = 36679;
/*      */   public static final int GL_DOUBLE_MAT4 = 36680;
/*      */   public static final int GL_DOUBLE_MAT2x3 = 36681;
/*      */   public static final int GL_DOUBLE_MAT2x4 = 36682;
/*      */   public static final int GL_DOUBLE_MAT3x2 = 36683;
/*      */   public static final int GL_DOUBLE_MAT3x4 = 36684;
/*      */   public static final int GL_DOUBLE_MAT4x2 = 36685;
/*      */   public static final int GL_DOUBLE_MAT4x3 = 36686;
/*      */   
/*      */   static {
/*   39 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_SAMPLE_SHADING = 35894;
/*      */ 
/*      */   
/*      */   public static final int GL_MIN_SAMPLE_SHADING_VALUE = 35895;
/*      */ 
/*      */   
/*      */   public static final int GL_ACTIVE_SUBROUTINES = 36325;
/*      */ 
/*      */   
/*      */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
/*      */ 
/*      */   
/*      */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
/*      */ 
/*      */   
/*      */   public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
/*      */ 
/*      */   
/*      */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_SUBROUTINES = 36327;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
/*      */ 
/*      */   
/*      */   public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
/*      */ 
/*      */   
/*      */   public static final int GL_COMPATIBLE_SUBROUTINES = 36427;
/*      */ 
/*      */   
/*      */   public static final int GL_PATCHES = 14;
/*      */ 
/*      */   
/*      */   public static final int GL_PATCH_VERTICES = 36466;
/*      */ 
/*      */   
/*      */   public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 36467;
/*      */ 
/*      */   
/*      */   public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 36468;
/*      */ 
/*      */   
/*      */   public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469;
/*      */ 
/*      */   
/*      */   public static final int GL_TESS_GEN_MODE = 36470;
/*      */ 
/*      */   
/*      */   public static final int GL_TESS_GEN_SPACING = 36471;
/*      */ 
/*      */   
/*      */   public static final int GL_TESS_GEN_VERTEX_ORDER = 36472;
/*      */ 
/*      */   
/*      */   public static final int GL_TESS_GEN_POINT_MODE = 36473;
/*      */ 
/*      */   
/*      */   public static final int GL_ISOLINES = 36474;
/*      */ 
/*      */   
/*      */   public static final int GL_FRACTIONAL_ODD = 36475;
/*      */ 
/*      */   
/*      */   public static final int GL_FRACTIONAL_EVEN = 36476;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_PATCH_VERTICES = 36477;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_TESS_GEN_LEVEL = 36478;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486;
/*      */   
/*      */   public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489;
/*      */   
/*      */   public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490;
/*      */   
/*      */   public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924;
/*      */   
/*      */   public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925;
/*      */   
/*      */   public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382;
/*      */   
/*      */   public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383;
/*      */   
/*      */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 34032;
/*      */   
/*      */   public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 34033;
/*      */   
/*      */   public static final int GL_TESS_EVALUATION_SHADER = 36487;
/*      */   
/*      */   public static final int GL_TESS_CONTROL_SHADER = 36488;
/*      */   
/*      */   public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873;
/*      */   
/*      */   public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 36874;
/*      */   
/*      */   public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY = 36875;
/*      */   
/*      */   public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 36876;
/*      */   
/*      */   public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 36877;
/*      */   
/*      */   public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 36878;
/*      */   
/*      */   public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 36879;
/*      */   
/*      */   public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET = 36446;
/*      */   
/*      */   public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET = 36447;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK = 36386;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
/*      */   
/*      */   public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;
/*      */   
/*      */   public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
/*      */   
/*      */   public static final int GL_MAX_VERTEX_STREAMS = 36465;
/*      */ 
/*      */   
/*      */   protected GL40() {
/*  194 */     throw new UnsupportedOperationException();
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
/*      */   public static void glBlendEquationi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  208 */     GL40C.glBlendEquationi(paramInt1, paramInt2);
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
/*      */   public static void glBlendEquationSeparatei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*  223 */     GL40C.glBlendEquationSeparatei(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glBlendFunci(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*  238 */     GL40C.glBlendFunci(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glBlendFuncSeparatei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5) {
/*  255 */     GL40C.glBlendFuncSeparatei(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDrawArraysIndirect(int paramInt, long paramLong) {
/*  262 */     GL40C.nglDrawArraysIndirect(paramInt, paramLong);
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
/*      */   public static void glDrawArraysIndirect(@NativeType("GLenum") int paramInt, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  290 */     GL40C.glDrawArraysIndirect(paramInt, paramByteBuffer);
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
/*      */   public static void glDrawArraysIndirect(@NativeType("GLenum") int paramInt, @NativeType("void const *") long paramLong) {
/*  318 */     GL40C.glDrawArraysIndirect(paramInt, paramLong);
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
/*      */   public static void glDrawArraysIndirect(@NativeType("GLenum") int paramInt, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  346 */     GL40C.glDrawArraysIndirect(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDrawElementsIndirect(int paramInt1, int paramInt2, long paramLong) {
/*  353 */     GL40C.nglDrawElementsIndirect(paramInt1, paramInt2, paramLong);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  396 */     GL40C.glDrawElementsIndirect(paramInt1, paramInt2, paramByteBuffer);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") long paramLong) {
/*  439 */     GL40C.glDrawElementsIndirect(paramInt1, paramInt2, paramLong);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  482 */     GL40C.glDrawElementsIndirect(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static void glUniform1d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble) {
/*  496 */     GL40C.glUniform1d(paramInt, paramDouble);
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
/*      */   public static void glUniform2d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/*  511 */     GL40C.glUniform2d(paramInt, paramDouble1, paramDouble2);
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
/*      */   public static void glUniform3d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3) {
/*  527 */     GL40C.glUniform3d(paramInt, paramDouble1, paramDouble2, paramDouble3);
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
/*      */   public static void glUniform4d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4) {
/*  544 */     GL40C.glUniform4d(paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform1dv(int paramInt1, int paramInt2, long paramLong) {
/*  555 */     GL40C.nglUniform1dv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform1dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  567 */     GL40C.glUniform1dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform2dv(int paramInt1, int paramInt2, long paramLong) {
/*  578 */     GL40C.nglUniform2dv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform2dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  590 */     GL40C.glUniform2dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform3dv(int paramInt1, int paramInt2, long paramLong) {
/*  601 */     GL40C.nglUniform3dv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform3dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  613 */     GL40C.glUniform3dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniform4dv(int paramInt1, int paramInt2, long paramLong) {
/*  624 */     GL40C.nglUniform4dv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniform4dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  636 */     GL40C.glUniform4dv(paramInt, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  647 */     GL40C.nglUniformMatrix2dv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  660 */     GL40C.glUniformMatrix2dv(paramInt, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  671 */     GL40C.nglUniformMatrix3dv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  684 */     GL40C.glUniformMatrix3dv(paramInt, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  695 */     GL40C.nglUniformMatrix4dv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  708 */     GL40C.glUniformMatrix4dv(paramInt, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix2x3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  719 */     GL40C.nglUniformMatrix2x3dv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  732 */     GL40C.glUniformMatrix2x3dv(paramInt, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix2x4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  743 */     GL40C.nglUniformMatrix2x4dv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  756 */     GL40C.glUniformMatrix2x4dv(paramInt, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix3x2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  767 */     GL40C.nglUniformMatrix3x2dv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  780 */     GL40C.glUniformMatrix3x2dv(paramInt, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix3x4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  791 */     GL40C.nglUniformMatrix3x4dv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  804 */     GL40C.glUniformMatrix3x4dv(paramInt, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix4x2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  815 */     GL40C.nglUniformMatrix4x2dv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  828 */     GL40C.glUniformMatrix4x2dv(paramInt, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformMatrix4x3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  839 */     GL40C.nglUniformMatrix4x3dv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*      */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  852 */     GL40C.glUniformMatrix4x3dv(paramInt, paramBoolean, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetUniformdv(int paramInt1, int paramInt2, long paramLong) {
/*  859 */     GL40C.nglGetUniformdv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetUniformdv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/*  872 */     GL40C.glGetUniformdv(paramInt1, paramInt2, paramDoubleBuffer);
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
/*      */   public static double glGetUniformd(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*  885 */     return GL40C.glGetUniformd(paramInt1, paramInt2);
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
/*      */   public static void glMinSampleShading(@NativeType("GLfloat") float paramFloat) {
/*  898 */     GL40C.glMinSampleShading(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetSubroutineUniformLocation(int paramInt1, int paramInt2, long paramLong) {
/*  905 */     return GL40C.nglGetSubroutineUniformLocation(paramInt1, paramInt2, paramLong);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetSubroutineUniformLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  919 */     return GL40C.glGetSubroutineUniformLocation(paramInt1, paramInt2, paramByteBuffer);
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
/*      */   @NativeType("GLint")
/*      */   public static int glGetSubroutineUniformLocation(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*  933 */     return GL40C.glGetSubroutineUniformLocation(paramInt1, paramInt2, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nglGetSubroutineIndex(int paramInt1, int paramInt2, long paramLong) {
/*  940 */     return GL40C.nglGetSubroutineIndex(paramInt1, paramInt2, paramLong);
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
/*      */   public static int glGetSubroutineIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/*  954 */     return GL40C.glGetSubroutineIndex(paramInt1, paramInt2, paramByteBuffer);
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
/*      */   public static int glGetSubroutineIndex(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*  968 */     return GL40C.glGetSubroutineIndex(paramInt1, paramInt2, paramCharSequence);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetActiveSubroutineUniformiv(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/*  975 */     GL40C.nglGetActiveSubroutineUniformiv(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*      */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  990 */     GL40C.glGetActiveSubroutineUniformiv(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer);
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
/*      */   public static int glGetActiveSubroutineUniformi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4) {
/* 1005 */     return GL40C.glGetActiveSubroutineUniformi(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetActiveSubroutineUniformName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2) {
/* 1016 */     GL40C.nglGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
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
/*      */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1031 */     GL40C.glGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramByteBuffer);
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
/*      */   public static String glGetActiveSubroutineUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1046 */     return GL40C.glGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static String glGetActiveSubroutineUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 1060 */     return glGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, glGetActiveSubroutineUniformi(paramInt1, paramInt2, paramInt3, 35385));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetActiveSubroutineName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2) {
/* 1071 */     GL40C.nglGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
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
/*      */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1086 */     GL40C.glGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramByteBuffer);
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
/*      */   public static String glGetActiveSubroutineName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 1101 */     return GL40C.glGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*      */   public static String glGetActiveSubroutineName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 1115 */     return glGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, glGetProgramStagei(paramInt1, paramInt2, 36424));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglUniformSubroutinesuiv(int paramInt1, int paramInt2, long paramLong) {
/* 1126 */     GL40C.nglUniformSubroutinesuiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1138 */     GL40C.glUniformSubroutinesuiv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformSubroutinesui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint const *") int paramInt2) {
/* 1149 */     GL40C.glUniformSubroutinesui(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetUniformSubroutineuiv(int paramInt1, int paramInt2, long paramLong) {
/* 1156 */     GL40C.nglGetUniformSubroutineuiv(paramInt1, paramInt2, paramLong);
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
/*      */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1169 */     GL40C.glGetUniformSubroutineuiv(paramInt1, paramInt2, paramIntBuffer);
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
/*      */   public static int glGetUniformSubroutineui(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 1182 */     return GL40C.glGetUniformSubroutineui(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetProgramStageiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1189 */     GL40C.nglGetProgramStageiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetProgramStageiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1203 */     GL40C.glGetProgramStageiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*      */   public static int glGetProgramStagei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 1217 */     return GL40C.glGetProgramStagei(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glPatchParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2) {
/* 1231 */     GL40C.glPatchParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglPatchParameterfv(int paramInt, long paramLong) {
/* 1238 */     GL40C.nglPatchParameterfv(paramInt, paramLong);
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
/*      */   public static void glPatchParameterfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1250 */     GL40C.glPatchParameterfv(paramInt, paramFloatBuffer);
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
/*      */   public static void glBindTransformFeedback(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1264 */     GL40C.glBindTransformFeedback(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteTransformFeedbacks(int paramInt, long paramLong) {
/* 1275 */     GL40C.nglDeleteTransformFeedbacks(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1286 */     GL40C.glDeleteTransformFeedbacks(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int paramInt) {
/* 1295 */     GL40C.glDeleteTransformFeedbacks(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGenTransformFeedbacks(int paramInt, long paramLong) {
/* 1306 */     GL40C.nglGenTransformFeedbacks(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1317 */     GL40C.glGenTransformFeedbacks(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenTransformFeedbacks() {
/* 1327 */     return GL40C.glGenTransformFeedbacks();
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
/*      */   public static boolean glIsTransformFeedback(@NativeType("GLuint") int paramInt) {
/* 1341 */     return GL40C.glIsTransformFeedback(paramInt);
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
/*      */   public static void glPauseTransformFeedback() {
/* 1362 */     GL40C.glPauseTransformFeedback();
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
/*      */   public static void glResumeTransformFeedback() {
/* 1375 */     GL40C.glResumeTransformFeedback();
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
/*      */   public static void glDrawTransformFeedback(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1389 */     GL40C.glDrawTransformFeedback(paramInt1, paramInt2);
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
/*      */   public static void glDrawTransformFeedbackStream(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 1404 */     GL40C.glDrawTransformFeedbackStream(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glBeginQueryIndexed(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 1419 */     GL40C.glBeginQueryIndexed(paramInt1, paramInt2, paramInt3);
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
/*      */   public static void glEndQueryIndexed(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 1433 */     GL40C.glEndQueryIndexed(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetQueryIndexediv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 1440 */     GL40C.nglGetQueryIndexediv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*      */   public static void glGetQueryIndexediv(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1454 */     GL40C.glGetQueryIndexediv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*      */   public static int glGetQueryIndexedi(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 1468 */     return GL40C.glGetQueryIndexedi(paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawArraysIndirect(@NativeType("GLenum") int paramInt, @NativeType("void const *") int[] paramArrayOfint) {
/* 1477 */     GL40C.glDrawArraysIndirect(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") int[] paramArrayOfint) {
/* 1486 */     GL40C.glDrawElementsIndirect(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1495 */     GL40C.glUniform1dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1504 */     GL40C.glUniform2dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1513 */     GL40C.glUniform3dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1522 */     GL40C.glUniform4dv(paramInt, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1531 */     GL40C.glUniformMatrix2dv(paramInt, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1540 */     GL40C.glUniformMatrix3dv(paramInt, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1549 */     GL40C.glUniformMatrix4dv(paramInt, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1558 */     GL40C.glUniformMatrix2x3dv(paramInt, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1567 */     GL40C.glUniformMatrix2x4dv(paramInt, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1576 */     GL40C.glUniformMatrix3x2dv(paramInt, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1585 */     GL40C.glUniformMatrix3x4dv(paramInt, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1594 */     GL40C.glUniformMatrix4x2dv(paramInt, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1603 */     GL40C.glUniformMatrix4x3dv(paramInt, paramBoolean, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformdv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 1612 */     GL40C.glGetUniformdv(paramInt1, paramInt2, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1621 */     GL40C.glGetActiveSubroutineUniformiv(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1630 */     GL40C.glGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, paramArrayOfint, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1639 */     GL40C.glGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, paramArrayOfint, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1648 */     GL40C.glUniformSubroutinesuiv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 1657 */     GL40C.glGetUniformSubroutineuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramStageiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1666 */     GL40C.glGetProgramStageiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPatchParameterfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1675 */     GL40C.glPatchParameterfv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1684 */     GL40C.glDeleteTransformFeedbacks(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 1693 */     GL40C.glGenTransformFeedbacks(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryIndexediv(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1702 */     GL40C.glGetQueryIndexediv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL40.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */