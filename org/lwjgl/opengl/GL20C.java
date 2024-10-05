/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
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
/*      */ public class GL20C
/*      */   extends GL15C
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
/*   38 */     GL.initialize();
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
/*      */   public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370;
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
/*      */   public static final int GL_DRAW_BUFFER11 = 34864;
/*      */   public static final int GL_DRAW_BUFFER12 = 34865;
/*      */   public static final int GL_DRAW_BUFFER13 = 34866;
/*      */   public static final int GL_DRAW_BUFFER14 = 34867;
/*      */   public static final int GL_DRAW_BUFFER15 = 34868;
/*      */   public static final int GL_POINT_SPRITE_COORD_ORIGIN = 36000;
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
/*      */   protected GL20C() {
/*  166 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  298 */     if (Checks.CHECKS) {
/*  299 */       Checks.checkSafe(paramIntBuffer, paramPointerBuffer.remaining());
/*      */     }
/*  301 */     nglShaderSource(paramInt, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */     MemoryStack memoryStack;
/*  318 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  320 */       long l = APIUtil.apiArrayi(memoryStack, MemoryUtil::memUTF8, paramVarArgs);
/*  321 */       nglShaderSource(paramInt, paramVarArgs.length, l, l - (paramVarArgs.length << 2));
/*  322 */       APIUtil.apiArrayFree(l, paramVarArgs.length); return;
/*      */     } finally {
/*  324 */       memoryStack.setPointer(i);
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
/*      */   public static void glShaderSource(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  341 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  343 */       long l = APIUtil.apiArrayi(memoryStack, MemoryUtil::memUTF8, new CharSequence[] { paramCharSequence });
/*  344 */       nglShaderSource(paramInt, 1, l, l - 4L);
/*  345 */       APIUtil.apiArrayFree(l, 1); return;
/*      */     } finally {
/*  347 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  521 */     nglUniform1fv(paramInt, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  542 */     nglUniform2fv(paramInt, paramFloatBuffer.remaining() >> 1, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  563 */     nglUniform3fv(paramInt, paramFloatBuffer.remaining() / 3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  584 */     nglUniform4fv(paramInt, paramFloatBuffer.remaining() >> 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  605 */     nglUniform1iv(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  626 */     nglUniform2iv(paramInt, paramIntBuffer.remaining() >> 1, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  647 */     nglUniform3iv(paramInt, paramIntBuffer.remaining() / 3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  668 */     nglUniform4iv(paramInt, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  690 */     nglUniformMatrix2fv(paramInt, paramFloatBuffer.remaining() >> 2, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  712 */     nglUniformMatrix3fv(paramInt, paramFloatBuffer.remaining() / 9, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  734 */     nglUniformMatrix4fv(paramInt, paramFloatBuffer.remaining() >> 4, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  752 */     if (Checks.CHECKS) {
/*  753 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  755 */     nglGetShaderiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetShaderi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  768 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  770 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  771 */       nglGetShaderiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  772 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  774 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetProgramiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  793 */     if (Checks.CHECKS) {
/*  794 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  796 */     nglGetProgramiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetProgrami(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  809 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  811 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  812 */       nglGetProgramiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  813 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  815 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetShaderInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/*  838 */     if (Checks.CHECKS) {
/*  839 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/*  841 */     nglGetShaderInfoLog(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static String glGetShaderInfoLog(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  854 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*  855 */     ByteBuffer byteBuffer = MemoryUtil.memAlloc(paramInt2);
/*      */     try {
/*  857 */       IntBuffer intBuffer = memoryStack.ints(0);
/*  858 */       nglGetShaderInfoLog(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/*  859 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/*  861 */       MemoryUtil.memFree(byteBuffer);
/*  862 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void")
/*      */   public static String glGetShaderInfoLog(@NativeType("GLuint") int paramInt) {
/*  875 */     return glGetShaderInfoLog(paramInt, glGetShaderi(paramInt, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  897 */     if (Checks.CHECKS) {
/*  898 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/*  900 */     nglGetProgramInfoLog(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static String glGetProgramInfoLog(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  913 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*  914 */     ByteBuffer byteBuffer = MemoryUtil.memAlloc(paramInt2);
/*      */     try {
/*  916 */       IntBuffer intBuffer = memoryStack.ints(0);
/*  917 */       nglGetProgramInfoLog(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/*  918 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/*  920 */       MemoryUtil.memFree(byteBuffer);
/*  921 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void")
/*      */   public static String glGetProgramInfoLog(@NativeType("GLuint") int paramInt) {
/*  934 */     return glGetProgramInfoLog(paramInt, glGetProgrami(paramInt, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  956 */     if (Checks.CHECKS) {
/*  957 */       Checks.checkSafe(paramIntBuffer1, 1);
/*      */     }
/*  959 */     nglGetAttachedShaders(paramInt, paramIntBuffer2.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  977 */     if (Checks.CHECKS) {
/*  978 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  980 */     return nglGetUniformLocation(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  993 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  995 */       memoryStack.nASCII(paramCharSequence, true);
/*  996 */       long l = memoryStack.getPointerAddress();
/*  997 */       paramInt = nglGetUniformLocation(paramInt, l); return paramInt;
/*      */     } finally {
/*  999 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetActiveUniform(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1025 */     if (Checks.CHECKS) {
/* 1026 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 1027 */       Checks.check(paramIntBuffer2, 1);
/* 1028 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/* 1030 */     nglGetActiveUniform(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 1046 */     if (Checks.CHECKS) {
/* 1047 */       Checks.check(paramIntBuffer1, 1);
/* 1048 */       Checks.check(paramIntBuffer2, 1);
/*      */     }  MemoryStack memoryStack;
/* 1050 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1052 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 1053 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt3);
/* 1054 */       nglGetActiveUniform(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(byteBuffer));
/* 1055 */       return MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 1057 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void")
/*      */   public static String glGetActiveUniform(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 1073 */     return glGetActiveUniform(paramInt1, paramInt2, glGetProgrami(paramInt1, 35719), paramIntBuffer1, paramIntBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1091 */     if (Checks.CHECKS) {
/* 1092 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1094 */     nglGetUniformfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static float glGetUniformf(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1107 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1109 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1110 */       nglGetUniformfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1111 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1113 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1132 */     if (Checks.CHECKS) {
/* 1133 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1135 */     nglGetUniformiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetUniformi(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1148 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1150 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1151 */       nglGetUniformiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1152 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1154 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetShaderSource(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 1177 */     if (Checks.CHECKS) {
/* 1178 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/* 1180 */     nglGetShaderSource(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static String glGetShaderSource(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1193 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 1194 */     ByteBuffer byteBuffer = MemoryUtil.memAlloc(paramInt2);
/*      */     try {
/* 1196 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 1197 */       nglGetShaderSource(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 1198 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 1200 */       MemoryUtil.memFree(byteBuffer);
/* 1201 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void")
/*      */   public static String glGetShaderSource(@NativeType("GLuint") int paramInt) {
/* 1214 */     return glGetShaderSource(paramInt, glGetShaderi(paramInt, 35720));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1408 */     if (Checks.CHECKS) {
/* 1409 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1411 */     nglVertexAttrib1fv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1428 */     if (Checks.CHECKS) {
/* 1429 */       Checks.check(paramShortBuffer, 1);
/*      */     }
/* 1431 */     nglVertexAttrib1sv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1448 */     if (Checks.CHECKS) {
/* 1449 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/* 1451 */     nglVertexAttrib1dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1468 */     if (Checks.CHECKS) {
/* 1469 */       Checks.check(paramFloatBuffer, 2);
/*      */     }
/* 1471 */     nglVertexAttrib2fv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1488 */     if (Checks.CHECKS) {
/* 1489 */       Checks.check(paramShortBuffer, 2);
/*      */     }
/* 1491 */     nglVertexAttrib2sv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1508 */     if (Checks.CHECKS) {
/* 1509 */       Checks.check(paramDoubleBuffer, 2);
/*      */     }
/* 1511 */     nglVertexAttrib2dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1528 */     if (Checks.CHECKS) {
/* 1529 */       Checks.check(paramFloatBuffer, 3);
/*      */     }
/* 1531 */     nglVertexAttrib3fv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1548 */     if (Checks.CHECKS) {
/* 1549 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/* 1551 */     nglVertexAttrib3sv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1568 */     if (Checks.CHECKS) {
/* 1569 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/* 1571 */     nglVertexAttrib3dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1588 */     if (Checks.CHECKS) {
/* 1589 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1591 */     nglVertexAttrib4fv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1608 */     if (Checks.CHECKS) {
/* 1609 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/* 1611 */     nglVertexAttrib4sv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1628 */     if (Checks.CHECKS) {
/* 1629 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 1631 */     nglVertexAttrib4dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1648 */     if (Checks.CHECKS) {
/* 1649 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1651 */     nglVertexAttrib4iv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1668 */     if (Checks.CHECKS) {
/* 1669 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/* 1671 */     nglVertexAttrib4bv(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1688 */     if (Checks.CHECKS) {
/* 1689 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/* 1691 */     nglVertexAttrib4ubv(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1708 */     if (Checks.CHECKS) {
/* 1709 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/* 1711 */     nglVertexAttrib4usv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1728 */     if (Checks.CHECKS) {
/* 1729 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1731 */     nglVertexAttrib4uiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1748 */     if (Checks.CHECKS) {
/* 1749 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/* 1751 */     nglVertexAttrib4Nbv(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1768 */     if (Checks.CHECKS) {
/* 1769 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/* 1771 */     nglVertexAttrib4Nsv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1788 */     if (Checks.CHECKS) {
/* 1789 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1791 */     nglVertexAttrib4Niv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1808 */     if (Checks.CHECKS) {
/* 1809 */       Checks.check(paramByteBuffer, 4);
/*      */     }
/* 1811 */     nglVertexAttrib4Nubv(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1828 */     if (Checks.CHECKS) {
/* 1829 */       Checks.check(paramShortBuffer, 4);
/*      */     }
/* 1831 */     nglVertexAttrib4Nusv(paramInt, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1848 */     if (Checks.CHECKS) {
/* 1849 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1851 */     nglVertexAttrib4Nuiv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1874 */     nglVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1892 */     nglVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1910 */     nglVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1928 */     nglVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1946 */     nglVertexAttribPointer(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1986 */     if (Checks.CHECKS) {
/* 1987 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 1989 */     nglBindAttribLocation(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 2002 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2004 */       memoryStack.nASCII(paramCharSequence, true);
/* 2005 */       long l = memoryStack.getPointerAddress();
/* 2006 */       nglBindAttribLocation(paramInt1, paramInt2, l); return;
/*      */     } finally {
/* 2008 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetActiveAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2035 */     if (Checks.CHECKS) {
/* 2036 */       Checks.checkSafe(paramIntBuffer1, 1);
/* 2037 */       Checks.check(paramIntBuffer2, 1);
/* 2038 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/* 2040 */     nglGetActiveAttrib(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
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
/* 2056 */     if (Checks.CHECKS) {
/* 2057 */       Checks.check(paramIntBuffer1, 1);
/* 2058 */       Checks.check(paramIntBuffer2, 1);
/*      */     }  MemoryStack memoryStack;
/* 2060 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2062 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 2063 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt3);
/* 2064 */       nglGetActiveAttrib(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(byteBuffer));
/* 2065 */       return MemoryUtil.memASCII(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 2067 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("void")
/*      */   public static String glGetActiveAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/* 2083 */     return glGetActiveAttrib(paramInt1, paramInt2, glGetProgrami(paramInt1, 35722), paramIntBuffer1, paramIntBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2101 */     if (Checks.CHECKS) {
/* 2102 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/* 2104 */     return nglGetAttribLocation(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 2117 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2119 */       memoryStack.nASCII(paramCharSequence, true);
/* 2120 */       long l = memoryStack.getPointerAddress();
/* 2121 */       paramInt = nglGetAttribLocation(paramInt, l); return paramInt;
/*      */     } finally {
/* 2123 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetVertexAttribiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 2142 */     if (Checks.CHECKS) {
/* 2143 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 2145 */     nglGetVertexAttribiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetVertexAttribi(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2158 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2160 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 2161 */       nglGetVertexAttribiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 2162 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 2164 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetVertexAttribfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 2183 */     if (Checks.CHECKS) {
/* 2184 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 2186 */     nglGetVertexAttribfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2204 */     if (Checks.CHECKS) {
/* 2205 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 2207 */     nglGetVertexAttribdv(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2225 */     if (Checks.CHECKS) {
/* 2226 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/* 2228 */     nglGetVertexAttribPointerv(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
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
/*      */   public static long glGetVertexAttribPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2241 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2243 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/* 2244 */       nglGetVertexAttribPointerv(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 2245 */       return pointerBuffer.get(0);
/*      */     } finally {
/* 2247 */       memoryStack.setPointer(i);
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
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 2268 */     nglDrawBuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/* 2277 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2279 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 2280 */       nglDrawBuffers(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/* 2282 */       memoryStack.setPointer(i);
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
/*      */   public static void glShaderSource(@NativeType("GLuint") int paramInt, @NativeType("GLchar const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2346 */     long l = (GL.getICD()).glShaderSource;
/* 2347 */     if (Checks.CHECKS) {
/* 2348 */       Checks.check(l);
/* 2349 */       Checks.checkSafe(paramArrayOfint, paramPointerBuffer.remaining());
/*      */     } 
/* 2351 */     JNI.callPPV(paramInt, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2360 */     long l = (GL.getICD()).glUniform1fv;
/* 2361 */     if (Checks.CHECKS) {
/* 2362 */       Checks.check(l);
/*      */     }
/* 2364 */     JNI.callPV(paramInt, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2373 */     long l = (GL.getICD()).glUniform2fv;
/* 2374 */     if (Checks.CHECKS) {
/* 2375 */       Checks.check(l);
/*      */     }
/* 2377 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 1, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2386 */     long l = (GL.getICD()).glUniform3fv;
/* 2387 */     if (Checks.CHECKS) {
/* 2388 */       Checks.check(l);
/*      */     }
/* 2390 */     JNI.callPV(paramInt, paramArrayOffloat.length / 3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4fv(@NativeType("GLint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2399 */     long l = (GL.getICD()).glUniform4fv;
/* 2400 */     if (Checks.CHECKS) {
/* 2401 */       Checks.check(l);
/*      */     }
/* 2403 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform1iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2412 */     long l = (GL.getICD()).glUniform1iv;
/* 2413 */     if (Checks.CHECKS) {
/* 2414 */       Checks.check(l);
/*      */     }
/* 2416 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform2iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2425 */     long l = (GL.getICD()).glUniform2iv;
/* 2426 */     if (Checks.CHECKS) {
/* 2427 */       Checks.check(l);
/*      */     }
/* 2429 */     JNI.callPV(paramInt, paramArrayOfint.length >> 1, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform3iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2438 */     long l = (GL.getICD()).glUniform3iv;
/* 2439 */     if (Checks.CHECKS) {
/* 2440 */       Checks.check(l);
/*      */     }
/* 2442 */     JNI.callPV(paramInt, paramArrayOfint.length / 3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniform4iv(@NativeType("GLint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2451 */     long l = (GL.getICD()).glUniform4iv;
/* 2452 */     if (Checks.CHECKS) {
/* 2453 */       Checks.check(l);
/*      */     }
/* 2455 */     JNI.callPV(paramInt, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2464 */     long l = (GL.getICD()).glUniformMatrix2fv;
/* 2465 */     if (Checks.CHECKS) {
/* 2466 */       Checks.check(l);
/*      */     }
/* 2468 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 2, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2477 */     long l = (GL.getICD()).glUniformMatrix3fv;
/* 2478 */     if (Checks.CHECKS) {
/* 2479 */       Checks.check(l);
/*      */     }
/* 2481 */     JNI.callPV(paramInt, paramArrayOffloat.length / 9, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glUniformMatrix4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2490 */     long l = (GL.getICD()).glUniformMatrix4fv;
/* 2491 */     if (Checks.CHECKS) {
/* 2492 */       Checks.check(l);
/*      */     }
/* 2494 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 4, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2503 */     long l = (GL.getICD()).glGetShaderiv;
/* 2504 */     if (Checks.CHECKS) {
/* 2505 */       Checks.check(l);
/* 2506 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2508 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2517 */     long l = (GL.getICD()).glGetProgramiv;
/* 2518 */     if (Checks.CHECKS) {
/* 2519 */       Checks.check(l);
/* 2520 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2522 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2531 */     long l = (GL.getICD()).glGetShaderInfoLog;
/* 2532 */     if (Checks.CHECKS) {
/* 2533 */       Checks.check(l);
/* 2534 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 2536 */     JNI.callPPV(paramInt, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2545 */     long l = (GL.getICD()).glGetProgramInfoLog;
/* 2546 */     if (Checks.CHECKS) {
/* 2547 */       Checks.check(l);
/* 2548 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 2550 */     JNI.callPPV(paramInt, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetAttachedShaders(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLuint *") int[] paramArrayOfint2) {
/* 2559 */     long l = (GL.getICD()).glGetAttachedShaders;
/* 2560 */     if (Checks.CHECKS) {
/* 2561 */       Checks.check(l);
/* 2562 */       Checks.checkSafe(paramArrayOfint1, 1);
/*      */     } 
/* 2564 */     JNI.callPPV(paramInt, paramArrayOfint2.length, paramArrayOfint1, paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveUniform(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2573 */     long l = (GL.getICD()).glGetActiveUniform;
/* 2574 */     if (Checks.CHECKS) {
/* 2575 */       Checks.check(l);
/* 2576 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2577 */       Checks.check(paramArrayOfint2, 1);
/* 2578 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/* 2580 */     JNI.callPPPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformfv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2589 */     long l = (GL.getICD()).glGetUniformfv;
/* 2590 */     if (Checks.CHECKS) {
/* 2591 */       Checks.check(l);
/* 2592 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 2594 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetUniformiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2603 */     long l = (GL.getICD()).glGetUniformiv;
/* 2604 */     if (Checks.CHECKS) {
/* 2605 */       Checks.check(l);
/* 2606 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2608 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderSource(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2617 */     long l = (GL.getICD()).glGetShaderSource;
/* 2618 */     if (Checks.CHECKS) {
/* 2619 */       Checks.check(l);
/* 2620 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 2622 */     JNI.callPPV(paramInt, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2631 */     long l = (GL.getICD()).glVertexAttrib1fv;
/* 2632 */     if (Checks.CHECKS) {
/* 2633 */       Checks.check(l);
/* 2634 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 2636 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2645 */     long l = (GL.getICD()).glVertexAttrib1sv;
/* 2646 */     if (Checks.CHECKS) {
/* 2647 */       Checks.check(l);
/* 2648 */       Checks.check(paramArrayOfshort, 1);
/*      */     } 
/* 2650 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib1dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2659 */     long l = (GL.getICD()).glVertexAttrib1dv;
/* 2660 */     if (Checks.CHECKS) {
/* 2661 */       Checks.check(l);
/* 2662 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 2664 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2673 */     long l = (GL.getICD()).glVertexAttrib2fv;
/* 2674 */     if (Checks.CHECKS) {
/* 2675 */       Checks.check(l);
/* 2676 */       Checks.check(paramArrayOffloat, 2);
/*      */     } 
/* 2678 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2687 */     long l = (GL.getICD()).glVertexAttrib2sv;
/* 2688 */     if (Checks.CHECKS) {
/* 2689 */       Checks.check(l);
/* 2690 */       Checks.check(paramArrayOfshort, 2);
/*      */     } 
/* 2692 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib2dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2701 */     long l = (GL.getICD()).glVertexAttrib2dv;
/* 2702 */     if (Checks.CHECKS) {
/* 2703 */       Checks.check(l);
/* 2704 */       Checks.check(paramArrayOfdouble, 2);
/*      */     } 
/* 2706 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2715 */     long l = (GL.getICD()).glVertexAttrib3fv;
/* 2716 */     if (Checks.CHECKS) {
/* 2717 */       Checks.check(l);
/* 2718 */       Checks.check(paramArrayOffloat, 3);
/*      */     } 
/* 2720 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2729 */     long l = (GL.getICD()).glVertexAttrib3sv;
/* 2730 */     if (Checks.CHECKS) {
/* 2731 */       Checks.check(l);
/* 2732 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 2734 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib3dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2743 */     long l = (GL.getICD()).glVertexAttrib3dv;
/* 2744 */     if (Checks.CHECKS) {
/* 2745 */       Checks.check(l);
/* 2746 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 2748 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4fv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2757 */     long l = (GL.getICD()).glVertexAttrib4fv;
/* 2758 */     if (Checks.CHECKS) {
/* 2759 */       Checks.check(l);
/* 2760 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 2762 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4sv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2771 */     long l = (GL.getICD()).glVertexAttrib4sv;
/* 2772 */     if (Checks.CHECKS) {
/* 2773 */       Checks.check(l);
/* 2774 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 2776 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2785 */     long l = (GL.getICD()).glVertexAttrib4dv;
/* 2786 */     if (Checks.CHECKS) {
/* 2787 */       Checks.check(l);
/* 2788 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 2790 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4iv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2799 */     long l = (GL.getICD()).glVertexAttrib4iv;
/* 2800 */     if (Checks.CHECKS) {
/* 2801 */       Checks.check(l);
/* 2802 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2804 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4usv(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 2813 */     long l = (GL.getICD()).glVertexAttrib4usv;
/* 2814 */     if (Checks.CHECKS) {
/* 2815 */       Checks.check(l);
/* 2816 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 2818 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4uiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2827 */     long l = (GL.getICD()).glVertexAttrib4uiv;
/* 2828 */     if (Checks.CHECKS) {
/* 2829 */       Checks.check(l);
/* 2830 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2832 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nsv(@NativeType("GLuint") int paramInt, @NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 2841 */     long l = (GL.getICD()).glVertexAttrib4Nsv;
/* 2842 */     if (Checks.CHECKS) {
/* 2843 */       Checks.check(l);
/* 2844 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 2846 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Niv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2855 */     long l = (GL.getICD()).glVertexAttrib4Niv;
/* 2856 */     if (Checks.CHECKS) {
/* 2857 */       Checks.check(l);
/* 2858 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2860 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nusv(@NativeType("GLuint") int paramInt, @NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 2869 */     long l = (GL.getICD()).glVertexAttrib4Nusv;
/* 2870 */     if (Checks.CHECKS) {
/* 2871 */       Checks.check(l);
/* 2872 */       Checks.check(paramArrayOfshort, 4);
/*      */     } 
/* 2874 */     JNI.callPV(paramInt, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttrib4Nuiv(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2883 */     long l = (GL.getICD()).glVertexAttrib4Nuiv;
/* 2884 */     if (Checks.CHECKS) {
/* 2885 */       Checks.check(l);
/* 2886 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2888 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetActiveAttrib(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2897 */     long l = (GL.getICD()).glGetActiveAttrib;
/* 2898 */     if (Checks.CHECKS) {
/* 2899 */       Checks.check(l);
/* 2900 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2901 */       Checks.check(paramArrayOfint2, 1);
/* 2902 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/* 2904 */     JNI.callPPPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2913 */     long l = (GL.getICD()).glGetVertexAttribiv;
/* 2914 */     if (Checks.CHECKS) {
/* 2915 */       Checks.check(l);
/* 2916 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2918 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribfv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2927 */     long l = (GL.getICD()).glGetVertexAttribfv;
/* 2928 */     if (Checks.CHECKS) {
/* 2929 */       Checks.check(l);
/* 2930 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 2932 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribdv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 2941 */     long l = (GL.getICD()).glGetVertexAttribdv;
/* 2942 */     if (Checks.CHECKS) {
/* 2943 */       Checks.check(l);
/* 2944 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 2946 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDrawBuffers(@NativeType("GLenum const *") int[] paramArrayOfint) {
/* 2955 */     long l = (GL.getICD()).glDrawBuffers;
/* 2956 */     if (Checks.CHECKS) {
/* 2957 */       Checks.check(l);
/*      */     }
/* 2959 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static native int glCreateProgram();
/*      */   
/*      */   public static native void glDeleteProgram(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsProgram(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static native int glCreateShader(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void glDeleteShader(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsShader(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glAttachShader(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glDetachShader(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglShaderSource(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glCompileShader(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glLinkProgram(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glUseProgram(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glValidateProgram(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glUniform1f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glUniform2f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glUniform3f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glUniform4f(@NativeType("GLint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glUniform1i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glUniform2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glUniform3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glUniform4i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void nglUniform1fv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform2fv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform3fv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform4fv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform1iv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform2iv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform3iv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniform4iv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix2fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix3fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglUniformMatrix4fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglGetShaderiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetProgramiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetShaderInfoLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglGetProgramInfoLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglGetAttachedShaders(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int nglGetUniformLocation(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetActiveUniform(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void nglGetUniformfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetUniformiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetShaderSource(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glVertexAttrib1f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glVertexAttrib1s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort);
/*      */   
/*      */   public static native void glVertexAttrib1d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void glVertexAttrib2f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glVertexAttrib2s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glVertexAttrib2d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glVertexAttrib3f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glVertexAttrib3s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glVertexAttrib3d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glVertexAttrib4f(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glVertexAttrib4s(@NativeType("GLuint") int paramInt, @NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3, @NativeType("GLshort") short paramShort4);
/*      */   
/*      */   public static native void glVertexAttrib4d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void glVertexAttrib4Nub(@NativeType("GLuint") int paramInt, @NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3, @NativeType("GLubyte") byte paramByte4);
/*      */   
/*      */   public static native void nglVertexAttrib1fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib1sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib1dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib2fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib2sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib2dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib3fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib3sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib3dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4fv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4sv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4iv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4bv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4ubv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4usv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4uiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Nbv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Nsv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Niv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Nubv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Nusv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttrib4Nuiv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribPointer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void glEnableVertexAttribArray(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glDisableVertexAttribArray(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglBindAttribLocation(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetActiveAttrib(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nglGetAttribLocation(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribdv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribPointerv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglDrawBuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void glBlendEquationSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*      */   
/*      */   public static native void glStencilOpSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4);
/*      */   
/*      */   public static native void glStencilFuncSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glStencilMaskSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL20C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */