/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GL40C
/*      */   extends GL33C
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
/*   44 */     GL.initialize();
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
/*      */   protected GL40C() {
/*  199 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  285 */     if (Checks.CHECKS) {
/*  286 */       Checks.check(paramByteBuffer, 16);
/*      */     }
/*  288 */     nglDrawArraysIndirect(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  316 */     nglDrawArraysIndirect(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  344 */     if (Checks.CHECKS) {
/*  345 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  347 */     nglDrawArraysIndirect(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  395 */     if (Checks.CHECKS) {
/*  396 */       Checks.check(paramByteBuffer, 20);
/*      */     }
/*  398 */     nglDrawElementsIndirect(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  441 */     nglDrawElementsIndirect(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  484 */     if (Checks.CHECKS) {
/*  485 */       Checks.check(paramIntBuffer, 5);
/*      */     }
/*  487 */     nglDrawElementsIndirect(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  562 */     nglUniform1dv(paramInt, paramDoubleBuffer.remaining(), MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  583 */     nglUniform2dv(paramInt, paramDoubleBuffer.remaining() >> 1, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  604 */     nglUniform3dv(paramInt, paramDoubleBuffer.remaining() / 3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  625 */     nglUniform4dv(paramInt, paramDoubleBuffer.remaining() >> 2, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  647 */     nglUniformMatrix2dv(paramInt, paramDoubleBuffer.remaining() >> 2, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  669 */     nglUniformMatrix3dv(paramInt, paramDoubleBuffer.remaining() / 9, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  691 */     nglUniformMatrix4dv(paramInt, paramDoubleBuffer.remaining() >> 4, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  713 */     nglUniformMatrix2x3dv(paramInt, paramDoubleBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  735 */     nglUniformMatrix2x4dv(paramInt, paramDoubleBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  757 */     nglUniformMatrix3x2dv(paramInt, paramDoubleBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  779 */     nglUniformMatrix3x4dv(paramInt, paramDoubleBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  801 */     nglUniformMatrix4x2dv(paramInt, paramDoubleBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  823 */     nglUniformMatrix4x3dv(paramInt, paramDoubleBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  841 */     if (Checks.CHECKS) {
/*  842 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/*  844 */     nglGetUniformdv(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static double glGetUniformd(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  857 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  859 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/*  860 */       nglGetUniformdv(paramInt1, paramInt2, MemoryUtil.memAddress(doubleBuffer));
/*  861 */       return doubleBuffer.get(0);
/*      */     } finally {
/*  863 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  894 */     if (Checks.CHECKS) {
/*  895 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  897 */     return nglGetSubroutineUniformLocation(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  911 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  913 */       memoryStack.nASCII(paramCharSequence, true);
/*  914 */       long l = memoryStack.getPointerAddress();
/*  915 */       paramInt1 = nglGetSubroutineUniformLocation(paramInt1, paramInt2, l); return paramInt1;
/*      */     } finally {
/*  917 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  937 */     if (Checks.CHECKS) {
/*  938 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  940 */     return nglGetSubroutineIndex(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  954 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  956 */       memoryStack.nASCII(paramCharSequence, true);
/*  957 */       long l = memoryStack.getPointerAddress();
/*  958 */       paramInt1 = nglGetSubroutineIndex(paramInt1, paramInt2, l); return paramInt1;
/*      */     } finally {
/*  960 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  981 */     if (Checks.CHECKS) {
/*  982 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  984 */     nglGetActiveSubroutineUniformiv(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
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
/*      */     MemoryStack memoryStack;
/*  999 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1001 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1002 */       nglGetActiveSubroutineUniformiv(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(intBuffer));
/* 1003 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1005 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1030 */     if (Checks.CHECKS) {
/* 1031 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/* 1033 */     nglGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
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
/*      */     MemoryStack memoryStack;
/* 1048 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1050 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 1051 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt4);
/* 1052 */       nglGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 1053 */       return MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 1055 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
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
/* 1070 */     return glGetActiveSubroutineUniformName(paramInt1, paramInt2, paramInt3, glGetActiveSubroutineUniformi(paramInt1, paramInt2, paramInt3, 35385));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1094 */     if (Checks.CHECKS) {
/* 1095 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/* 1097 */     nglGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
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
/*      */     MemoryStack memoryStack;
/* 1112 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1114 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 1115 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt4);
/* 1116 */       nglGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 1117 */       return MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 1119 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
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
/* 1134 */     return glGetActiveSubroutineName(paramInt1, paramInt2, paramInt3, glGetProgramStagei(paramInt1, paramInt2, 36424));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1155 */     nglUniformSubroutinesuiv(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformSubroutinesui(@NativeType("GLenum") int paramInt1, @NativeType("GLuint const *") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1166 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1168 */       IntBuffer intBuffer = memoryStack.ints(paramInt2);
/* 1169 */       nglUniformSubroutinesuiv(paramInt1, 1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1171 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1190 */     if (Checks.CHECKS) {
/* 1191 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1193 */     nglGetUniformSubroutineuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetUniformSubroutineui(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1206 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1208 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1209 */       nglGetUniformSubroutineuiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1210 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1212 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1232 */     if (Checks.CHECKS) {
/* 1233 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1235 */     nglGetProgramStageiv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1249 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1251 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1252 */       nglGetProgramStageiv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 1253 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1255 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1285 */     if (Checks.CHECKS && 
/* 1286 */       Checks.DEBUG) {
/* 1287 */       Checks.check(paramFloatBuffer, GL11.glGetInteger(36466));
/*      */     }
/*      */     
/* 1290 */     nglPatchParameterfv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 1322 */     nglDeleteTransformFeedbacks(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1331 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1333 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 1334 */       nglDeleteTransformFeedbacks(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 1336 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 1357 */     nglGenTransformFeedbacks(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenTransformFeedbacks() {
/*      */     MemoryStack memoryStack;
/* 1367 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1369 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1370 */       nglGenTransformFeedbacks(1, MemoryUtil.memAddress(intBuffer));
/* 1371 */       return intBuffer.get(0);
/*      */     } finally {
/* 1373 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1485 */     if (Checks.CHECKS) {
/* 1486 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1488 */     nglGetQueryIndexediv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1502 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1504 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1505 */       nglGetQueryIndexediv(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 1506 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1508 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawArraysIndirect(@NativeType("GLenum") int paramInt, @NativeType("void const *") int[] paramArrayOfint) {
/* 1518 */     long l = (GL.getICD()).glDrawArraysIndirect;
/* 1519 */     if (Checks.CHECKS) {
/* 1520 */       Checks.check(l);
/* 1521 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 1523 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") int[] paramArrayOfint) {
/* 1532 */     long l = (GL.getICD()).glDrawElementsIndirect;
/* 1533 */     if (Checks.CHECKS) {
/* 1534 */       Checks.check(l);
/* 1535 */       Checks.check(paramArrayOfint, 5);
/*      */     } 
/* 1537 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1546 */     long l = (GL.getICD()).glUniform1dv;
/* 1547 */     if (Checks.CHECKS) {
/* 1548 */       Checks.check(l);
/*      */     }
/* 1550 */     JNI.callPV(paramInt, paramArrayOfdouble.length, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1559 */     long l = (GL.getICD()).glUniform2dv;
/* 1560 */     if (Checks.CHECKS) {
/* 1561 */       Checks.check(l);
/*      */     }
/* 1563 */     JNI.callPV(paramInt, paramArrayOfdouble.length >> 1, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1572 */     long l = (GL.getICD()).glUniform3dv;
/* 1573 */     if (Checks.CHECKS) {
/* 1574 */       Checks.check(l);
/*      */     }
/* 1576 */     JNI.callPV(paramInt, paramArrayOfdouble.length / 3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4dv(@NativeType("GLint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1585 */     long l = (GL.getICD()).glUniform4dv;
/* 1586 */     if (Checks.CHECKS) {
/* 1587 */       Checks.check(l);
/*      */     }
/* 1589 */     JNI.callPV(paramInt, paramArrayOfdouble.length >> 2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1598 */     long l = (GL.getICD()).glUniformMatrix2dv;
/* 1599 */     if (Checks.CHECKS) {
/* 1600 */       Checks.check(l);
/*      */     }
/* 1602 */     JNI.callPV(paramInt, paramArrayOfdouble.length >> 2, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1611 */     long l = (GL.getICD()).glUniformMatrix3dv;
/* 1612 */     if (Checks.CHECKS) {
/* 1613 */       Checks.check(l);
/*      */     }
/* 1615 */     JNI.callPV(paramInt, paramArrayOfdouble.length / 9, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1624 */     long l = (GL.getICD()).glUniformMatrix4dv;
/* 1625 */     if (Checks.CHECKS) {
/* 1626 */       Checks.check(l);
/*      */     }
/* 1628 */     JNI.callPV(paramInt, paramArrayOfdouble.length >> 4, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2x3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1637 */     long l = (GL.getICD()).glUniformMatrix2x3dv;
/* 1638 */     if (Checks.CHECKS) {
/* 1639 */       Checks.check(l);
/*      */     }
/* 1641 */     JNI.callPV(paramInt, paramArrayOfdouble.length / 6, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2x4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1650 */     long l = (GL.getICD()).glUniformMatrix2x4dv;
/* 1651 */     if (Checks.CHECKS) {
/* 1652 */       Checks.check(l);
/*      */     }
/* 1654 */     JNI.callPV(paramInt, paramArrayOfdouble.length >> 3, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3x2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1663 */     long l = (GL.getICD()).glUniformMatrix3x2dv;
/* 1664 */     if (Checks.CHECKS) {
/* 1665 */       Checks.check(l);
/*      */     }
/* 1667 */     JNI.callPV(paramInt, paramArrayOfdouble.length / 6, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3x4dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1676 */     long l = (GL.getICD()).glUniformMatrix3x4dv;
/* 1677 */     if (Checks.CHECKS) {
/* 1678 */       Checks.check(l);
/*      */     }
/* 1680 */     JNI.callPV(paramInt, paramArrayOfdouble.length / 12, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4x2dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1689 */     long l = (GL.getICD()).glUniformMatrix4x2dv;
/* 1690 */     if (Checks.CHECKS) {
/* 1691 */       Checks.check(l);
/*      */     }
/* 1693 */     JNI.callPV(paramInt, paramArrayOfdouble.length >> 3, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4x3dv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1702 */     long l = (GL.getICD()).glUniformMatrix4x3dv;
/* 1703 */     if (Checks.CHECKS) {
/* 1704 */       Checks.check(l);
/*      */     }
/* 1706 */     JNI.callPV(paramInt, paramArrayOfdouble.length / 12, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformdv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 1715 */     long l = (GL.getICD()).glGetUniformdv;
/* 1716 */     if (Checks.CHECKS) {
/* 1717 */       Checks.check(l);
/* 1718 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 1720 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1729 */     long l = (GL.getICD()).glGetActiveSubroutineUniformiv;
/* 1730 */     if (Checks.CHECKS) {
/* 1731 */       Checks.check(l);
/* 1732 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1734 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1743 */     long l = (GL.getICD()).glGetActiveSubroutineUniformName;
/* 1744 */     if (Checks.CHECKS) {
/* 1745 */       Checks.check(l);
/* 1746 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 1748 */     JNI.callPPV(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1757 */     long l = (GL.getICD()).glGetActiveSubroutineName;
/* 1758 */     if (Checks.CHECKS) {
/* 1759 */       Checks.check(l);
/* 1760 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 1762 */     JNI.callPPV(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1771 */     long l = (GL.getICD()).glUniformSubroutinesuiv;
/* 1772 */     if (Checks.CHECKS) {
/* 1773 */       Checks.check(l);
/*      */     }
/* 1775 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 1784 */     long l = (GL.getICD()).glGetUniformSubroutineuiv;
/* 1785 */     if (Checks.CHECKS) {
/* 1786 */       Checks.check(l);
/* 1787 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1789 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramStageiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1798 */     long l = (GL.getICD()).glGetProgramStageiv;
/* 1799 */     if (Checks.CHECKS) {
/* 1800 */       Checks.check(l);
/* 1801 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1803 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPatchParameterfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1812 */     long l = (GL.getICD()).glPatchParameterfv;
/* 1813 */     if (Checks.CHECKS) {
/* 1814 */       Checks.check(l);
/* 1815 */       if (Checks.DEBUG) {
/* 1816 */         Checks.check(paramArrayOffloat, GL11.glGetInteger(36466));
/*      */       }
/*      */     } 
/* 1819 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1828 */     long l = (GL.getICD()).glDeleteTransformFeedbacks;
/* 1829 */     if (Checks.CHECKS) {
/* 1830 */       Checks.check(l);
/*      */     }
/* 1832 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 1841 */     long l = (GL.getICD()).glGenTransformFeedbacks;
/* 1842 */     if (Checks.CHECKS) {
/* 1843 */       Checks.check(l);
/*      */     }
/* 1845 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryIndexediv(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1854 */     long l = (GL.getICD()).glGetQueryIndexediv;
/* 1855 */     if (Checks.CHECKS) {
/* 1856 */       Checks.check(l);
/* 1857 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1859 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */   
/*      */   public static native void glBlendEquationi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glBlendEquationSeparatei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*      */   
/*      */   public static native void glBlendFunci(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*      */   
/*      */   public static native void glBlendFuncSeparatei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5);
/*      */   
/*      */   public static native void nglDrawArraysIndirect(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglDrawElementsIndirect(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glUniform1d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void glUniform2d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glUniform3d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glUniform4d(@NativeType("GLint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglUniform1dv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform2dv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform3dv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform4dv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix2x3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix2x4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix3x2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix3x4dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix4x2dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix4x3dv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglGetUniformdv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glMinSampleShading(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native int nglGetSubroutineUniformLocation(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native int nglGetSubroutineIndex(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetActiveSubroutineUniformiv(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetActiveSubroutineUniformName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglGetActiveSubroutineName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglUniformSubroutinesuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetUniformSubroutineuiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramStageiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glPatchParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void nglPatchParameterfv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glBindTransformFeedback(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglDeleteTransformFeedbacks(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenTransformFeedbacks(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsTransformFeedback(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glPauseTransformFeedback();
/*      */   
/*      */   public static native void glResumeTransformFeedback();
/*      */   
/*      */   public static native void glDrawTransformFeedback(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDrawTransformFeedbackStream(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glBeginQueryIndexed(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glEndQueryIndexed(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglGetQueryIndexediv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL40C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */