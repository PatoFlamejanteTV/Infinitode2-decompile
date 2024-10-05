/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
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
/*      */ public class GL41C
/*      */   extends GL40C
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
/*   39 */     GL.initialize();
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
/*      */   protected GL41C() {
/*  108 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  140 */     nglShaderBinary(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), paramInt, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  159 */     if (Checks.CHECKS) {
/*  160 */       Checks.check(paramIntBuffer1, 2);
/*  161 */       Checks.check(paramIntBuffer2, 1);
/*      */     } 
/*  163 */     nglGetShaderPrecisionFormat(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2));
/*      */   }
/*      */ 
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
/*  177 */     if (Checks.CHECKS)
/*  178 */       Checks.check(paramIntBuffer, 2); 
/*      */     MemoryStack memoryStack;
/*  180 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  182 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  183 */       nglGetShaderPrecisionFormat(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(intBuffer));
/*  184 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  186 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetProgramBinary(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  233 */     if (Checks.CHECKS) {
/*  234 */       Checks.checkSafe(paramIntBuffer1, 1);
/*  235 */       Checks.check(paramIntBuffer2, 1);
/*      */     } 
/*  237 */     nglGetProgramBinary(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  259 */     nglProgramBinary(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  346 */     return nglCreateShaderProgramv(paramInt, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */     MemoryStack memoryStack;
/*  386 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  388 */       long l = APIUtil.apiArray(memoryStack, MemoryUtil::memUTF8, paramVarArgs);
/*  389 */       paramInt = nglCreateShaderProgramv(paramInt, paramVarArgs.length, l);
/*  390 */       APIUtil.apiArrayFree(l, paramVarArgs.length);
/*  391 */       return paramInt;
/*      */     } finally {
/*  393 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("GLuint")
/*      */   public static int glCreateShaderProgramv(@NativeType("GLenum") int paramInt, @NativeType("GLchar const * const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  433 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  435 */       long l = APIUtil.apiArray(memoryStack, MemoryUtil::memUTF8, new CharSequence[] { paramCharSequence });
/*  436 */       paramInt = nglCreateShaderProgramv(paramInt, 1, l);
/*  437 */       APIUtil.apiArrayFree(l, 1);
/*  438 */       return paramInt;
/*      */     } finally {
/*  440 */       memoryStack.setPointer(i);
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
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  472 */     nglDeleteProgramPipelines(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  481 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  483 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  484 */       nglDeleteProgramPipelines(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/*  486 */       memoryStack.setPointer(i);
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
/*      */   public static void glGenProgramPipelines(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  507 */     nglGenProgramPipelines(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenProgramPipelines() {
/*      */     MemoryStack memoryStack;
/*  517 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  519 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  520 */       nglGenProgramPipelines(1, MemoryUtil.memAddress(intBuffer));
/*  521 */       return intBuffer.get(0);
/*      */     } finally {
/*  523 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  554 */     if (Checks.CHECKS) {
/*  555 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  557 */     nglGetProgramPipelineiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*      */   public static int glGetProgramPipelinei(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  570 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  572 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  573 */       nglGetProgramPipelineiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  574 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  576 */       memoryStack.setPointer(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  831 */     nglProgramUniform1iv(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  853 */     nglProgramUniform2iv(paramInt1, paramInt2, paramIntBuffer.remaining() >> 1, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  875 */     nglProgramUniform3iv(paramInt1, paramInt2, paramIntBuffer.remaining() / 3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  897 */     nglProgramUniform4iv(paramInt1, paramInt2, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  919 */     nglProgramUniform1uiv(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  941 */     nglProgramUniform2uiv(paramInt1, paramInt2, paramIntBuffer.remaining() >> 1, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  963 */     nglProgramUniform3uiv(paramInt1, paramInt2, paramIntBuffer.remaining() / 3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  985 */     nglProgramUniform4uiv(paramInt1, paramInt2, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1007 */     nglProgramUniform1fv(paramInt1, paramInt2, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1029 */     nglProgramUniform2fv(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 1, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1051 */     nglProgramUniform3fv(paramInt1, paramInt2, paramFloatBuffer.remaining() / 3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1073 */     nglProgramUniform4fv(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1095 */     nglProgramUniform1dv(paramInt1, paramInt2, paramDoubleBuffer.remaining(), MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1117 */     nglProgramUniform2dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 1, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1139 */     nglProgramUniform3dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1161 */     nglProgramUniform4dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 2, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1184 */     nglProgramUniformMatrix2fv(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 2, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1207 */     nglProgramUniformMatrix3fv(paramInt1, paramInt2, paramFloatBuffer.remaining() / 9, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1230 */     nglProgramUniformMatrix4fv(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 4, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1253 */     nglProgramUniformMatrix2dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 2, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1276 */     nglProgramUniformMatrix3dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 9, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1299 */     nglProgramUniformMatrix4dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 4, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1322 */     nglProgramUniformMatrix2x3fv(paramInt1, paramInt2, paramFloatBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1345 */     nglProgramUniformMatrix3x2fv(paramInt1, paramInt2, paramFloatBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1368 */     nglProgramUniformMatrix2x4fv(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1391 */     nglProgramUniformMatrix4x2fv(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1414 */     nglProgramUniformMatrix3x4fv(paramInt1, paramInt2, paramFloatBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1437 */     nglProgramUniformMatrix4x3fv(paramInt1, paramInt2, paramFloatBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1460 */     nglProgramUniformMatrix2x3dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1483 */     nglProgramUniformMatrix3x2dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 6, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1506 */     nglProgramUniformMatrix2x4dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1529 */     nglProgramUniformMatrix4x2dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() >> 3, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1552 */     nglProgramUniformMatrix3x4dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1575 */     nglProgramUniformMatrix4x3dv(paramInt1, paramInt2, paramDoubleBuffer.remaining() / 12, paramBoolean, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1608 */     if (Checks.CHECKS) {
/* 1609 */       Checks.checkSafe(paramIntBuffer, 1);
/*      */     }
/* 1611 */     nglGetProgramPipelineInfoLog(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
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
/*      */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1624 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 1625 */     ByteBuffer byteBuffer = MemoryUtil.memAlloc(paramInt2);
/*      */     try {
/* 1627 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 1628 */       nglGetProgramPipelineInfoLog(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 1629 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*      */     } finally {
/* 1631 */       MemoryUtil.memFree(byteBuffer);
/* 1632 */       memoryStack.setPointer(i);
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
/*      */   public static String glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt) {
/* 1645 */     return glGetProgramPipelineInfoLog(paramInt, glGetProgramPipelinei(paramInt, 35716));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1716 */     if (Checks.CHECKS) {
/* 1717 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/* 1719 */     nglVertexAttribL1dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1736 */     if (Checks.CHECKS) {
/* 1737 */       Checks.check(paramDoubleBuffer, 2);
/*      */     }
/* 1739 */     nglVertexAttribL2dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1756 */     if (Checks.CHECKS) {
/* 1757 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/* 1759 */     nglVertexAttribL3dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1776 */     if (Checks.CHECKS) {
/* 1777 */       Checks.check(paramDoubleBuffer, 4);
/*      */     }
/* 1779 */     nglVertexAttribL4dv(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1805 */     nglVertexAttribLPointer(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1822 */     nglVertexAttribLPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1838 */     nglVertexAttribLPointer(paramInt1, paramInt2, 5130, paramInt3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1856 */     if (Checks.CHECKS) {
/* 1857 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/* 1859 */     nglGetVertexAttribLdv(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1880 */     nglViewportArrayv(paramInt, paramFloatBuffer.remaining() >> 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1912 */     if (Checks.CHECKS) {
/* 1913 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/* 1915 */     nglViewportIndexedfv(paramInt, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1936 */     nglScissorArrayv(paramInt, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1968 */     if (Checks.CHECKS) {
/* 1969 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/* 1971 */     nglScissorIndexedv(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 1992 */     nglDepthRangeArrayv(paramInt, paramDoubleBuffer.remaining() >> 1, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/* 2023 */     if (Checks.CHECKS) {
/* 2024 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 2026 */     nglGetFloati_v(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   public static float glGetFloati(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2039 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2041 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 2042 */       nglGetFloati_v(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 2043 */       return floatBuffer.get(0);
/*      */     } finally {
/* 2045 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetDoublei_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 2064 */     if (Checks.CHECKS) {
/* 2065 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/* 2067 */     nglGetDoublei_v(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static double glGetDoublei(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 2080 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 2082 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/* 2083 */       nglGetDoublei_v(paramInt1, paramInt2, MemoryUtil.memAddress(doubleBuffer));
/* 2084 */       return doubleBuffer.get(0);
/*      */     } finally {
/* 2086 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glShaderBinary(@NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 2096 */     long l = (GL.getICD()).glShaderBinary;
/* 2097 */     if (Checks.CHECKS) {
/* 2098 */       Checks.check(l);
/*      */     }
/* 2100 */     JNI.callPPV(paramArrayOfint.length, paramArrayOfint, paramInt, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 2109 */     long l = (GL.getICD()).glGetShaderPrecisionFormat;
/* 2110 */     if (Checks.CHECKS) {
/* 2111 */       Checks.check(l);
/* 2112 */       Checks.check(paramArrayOfint1, 2);
/* 2113 */       Checks.check(paramArrayOfint2, 1);
/*      */     } 
/* 2115 */     JNI.callPPV(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramBinary(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 2124 */     long l = (GL.getICD()).glGetProgramBinary;
/* 2125 */     if (Checks.CHECKS) {
/* 2126 */       Checks.check(l);
/* 2127 */       Checks.checkSafe(paramArrayOfint1, 1);
/* 2128 */       Checks.check(paramArrayOfint2, 1);
/*      */     } 
/* 2130 */     JNI.callPPPV(paramInt, paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteProgramPipelines(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2139 */     long l = (GL.getICD()).glDeleteProgramPipelines;
/* 2140 */     if (Checks.CHECKS) {
/* 2141 */       Checks.check(l);
/*      */     }
/* 2143 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenProgramPipelines(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 2152 */     long l = (GL.getICD()).glGenProgramPipelines;
/* 2153 */     if (Checks.CHECKS) {
/* 2154 */       Checks.check(l);
/*      */     }
/* 2156 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 2165 */     long l = (GL.getICD()).glGetProgramPipelineiv;
/* 2166 */     if (Checks.CHECKS) {
/* 2167 */       Checks.check(l);
/* 2168 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 2170 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2179 */     long l = (GL.getICD()).glProgramUniform1iv;
/* 2180 */     if (Checks.CHECKS) {
/* 2181 */       Checks.check(l);
/*      */     }
/* 2183 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2192 */     long l = (GL.getICD()).glProgramUniform2iv;
/* 2193 */     if (Checks.CHECKS) {
/* 2194 */       Checks.check(l);
/*      */     }
/* 2196 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length >> 1, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2205 */     long l = (GL.getICD()).glProgramUniform3iv;
/* 2206 */     if (Checks.CHECKS) {
/* 2207 */       Checks.check(l);
/*      */     }
/* 2209 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length / 3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4iv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2218 */     long l = (GL.getICD()).glProgramUniform4iv;
/* 2219 */     if (Checks.CHECKS) {
/* 2220 */       Checks.check(l);
/*      */     }
/* 2222 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2231 */     long l = (GL.getICD()).glProgramUniform1uiv;
/* 2232 */     if (Checks.CHECKS) {
/* 2233 */       Checks.check(l);
/*      */     }
/* 2235 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2244 */     long l = (GL.getICD()).glProgramUniform2uiv;
/* 2245 */     if (Checks.CHECKS) {
/* 2246 */       Checks.check(l);
/*      */     }
/* 2248 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length >> 1, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2257 */     long l = (GL.getICD()).glProgramUniform3uiv;
/* 2258 */     if (Checks.CHECKS) {
/* 2259 */       Checks.check(l);
/*      */     }
/* 2261 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length / 3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4uiv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint const *") int[] paramArrayOfint) {
/* 2270 */     long l = (GL.getICD()).glProgramUniform4uiv;
/* 2271 */     if (Checks.CHECKS) {
/* 2272 */       Checks.check(l);
/*      */     }
/* 2274 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2283 */     long l = (GL.getICD()).glProgramUniform1fv;
/* 2284 */     if (Checks.CHECKS) {
/* 2285 */       Checks.check(l);
/*      */     }
/* 2287 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2296 */     long l = (GL.getICD()).glProgramUniform2fv;
/* 2297 */     if (Checks.CHECKS) {
/* 2298 */       Checks.check(l);
/*      */     }
/* 2300 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 1, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2309 */     long l = (GL.getICD()).glProgramUniform3fv;
/* 2310 */     if (Checks.CHECKS) {
/* 2311 */       Checks.check(l);
/*      */     }
/* 2313 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2322 */     long l = (GL.getICD()).glProgramUniform4fv;
/* 2323 */     if (Checks.CHECKS) {
/* 2324 */       Checks.check(l);
/*      */     }
/* 2326 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform1dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2335 */     long l = (GL.getICD()).glProgramUniform1dv;
/* 2336 */     if (Checks.CHECKS) {
/* 2337 */       Checks.check(l);
/*      */     }
/* 2339 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2348 */     long l = (GL.getICD()).glProgramUniform2dv;
/* 2349 */     if (Checks.CHECKS) {
/* 2350 */       Checks.check(l);
/*      */     }
/* 2352 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 1, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2361 */     long l = (GL.getICD()).glProgramUniform3dv;
/* 2362 */     if (Checks.CHECKS) {
/* 2363 */       Checks.check(l);
/*      */     }
/* 2365 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniform4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2374 */     long l = (GL.getICD()).glProgramUniform4dv;
/* 2375 */     if (Checks.CHECKS) {
/* 2376 */       Checks.check(l);
/*      */     }
/* 2378 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2387 */     long l = (GL.getICD()).glProgramUniformMatrix2fv;
/* 2388 */     if (Checks.CHECKS) {
/* 2389 */       Checks.check(l);
/*      */     }
/* 2391 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 2, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2400 */     long l = (GL.getICD()).glProgramUniformMatrix3fv;
/* 2401 */     if (Checks.CHECKS) {
/* 2402 */       Checks.check(l);
/*      */     }
/* 2404 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 9, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2413 */     long l = (GL.getICD()).glProgramUniformMatrix4fv;
/* 2414 */     if (Checks.CHECKS) {
/* 2415 */       Checks.check(l);
/*      */     }
/* 2417 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 4, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2426 */     long l = (GL.getICD()).glProgramUniformMatrix2dv;
/* 2427 */     if (Checks.CHECKS) {
/* 2428 */       Checks.check(l);
/*      */     }
/* 2430 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 2, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2439 */     long l = (GL.getICD()).glProgramUniformMatrix3dv;
/* 2440 */     if (Checks.CHECKS) {
/* 2441 */       Checks.check(l);
/*      */     }
/* 2443 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 9, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2452 */     long l = (GL.getICD()).glProgramUniformMatrix4dv;
/* 2453 */     if (Checks.CHECKS) {
/* 2454 */       Checks.check(l);
/*      */     }
/* 2456 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 4, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2465 */     long l = (GL.getICD()).glProgramUniformMatrix2x3fv;
/* 2466 */     if (Checks.CHECKS) {
/* 2467 */       Checks.check(l);
/*      */     }
/* 2469 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 6, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2478 */     long l = (GL.getICD()).glProgramUniformMatrix3x2fv;
/* 2479 */     if (Checks.CHECKS) {
/* 2480 */       Checks.check(l);
/*      */     }
/* 2482 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 6, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2491 */     long l = (GL.getICD()).glProgramUniformMatrix2x4fv;
/* 2492 */     if (Checks.CHECKS) {
/* 2493 */       Checks.check(l);
/*      */     }
/* 2495 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 3, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2504 */     long l = (GL.getICD()).glProgramUniformMatrix4x2fv;
/* 2505 */     if (Checks.CHECKS) {
/* 2506 */       Checks.check(l);
/*      */     }
/* 2508 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 3, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2517 */     long l = (GL.getICD()).glProgramUniformMatrix3x4fv;
/* 2518 */     if (Checks.CHECKS) {
/* 2519 */       Checks.check(l);
/*      */     }
/* 2521 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 12, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3fv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2530 */     long l = (GL.getICD()).glProgramUniformMatrix4x3fv;
/* 2531 */     if (Checks.CHECKS) {
/* 2532 */       Checks.check(l);
/*      */     }
/* 2534 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length / 12, paramBoolean, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2543 */     long l = (GL.getICD()).glProgramUniformMatrix2x3dv;
/* 2544 */     if (Checks.CHECKS) {
/* 2545 */       Checks.check(l);
/*      */     }
/* 2547 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 6, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2556 */     long l = (GL.getICD()).glProgramUniformMatrix3x2dv;
/* 2557 */     if (Checks.CHECKS) {
/* 2558 */       Checks.check(l);
/*      */     }
/* 2560 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 6, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix2x4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2569 */     long l = (GL.getICD()).glProgramUniformMatrix2x4dv;
/* 2570 */     if (Checks.CHECKS) {
/* 2571 */       Checks.check(l);
/*      */     }
/* 2573 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 3, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x2dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2582 */     long l = (GL.getICD()).glProgramUniformMatrix4x2dv;
/* 2583 */     if (Checks.CHECKS) {
/* 2584 */       Checks.check(l);
/*      */     }
/* 2586 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length >> 3, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix3x4dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2595 */     long l = (GL.getICD()).glProgramUniformMatrix3x4dv;
/* 2596 */     if (Checks.CHECKS) {
/* 2597 */       Checks.check(l);
/*      */     }
/* 2599 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 12, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glProgramUniformMatrix4x3dv(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2608 */     long l = (GL.getICD()).glProgramUniformMatrix4x3dv;
/* 2609 */     if (Checks.CHECKS) {
/* 2610 */       Checks.check(l);
/*      */     }
/* 2612 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length / 12, paramBoolean, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetProgramPipelineInfoLog(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 2621 */     long l = (GL.getICD()).glGetProgramPipelineInfoLog;
/* 2622 */     if (Checks.CHECKS) {
/* 2623 */       Checks.check(l);
/* 2624 */       Checks.checkSafe(paramArrayOfint, 1);
/*      */     } 
/* 2626 */     JNI.callPPV(paramInt, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL1dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2635 */     long l = (GL.getICD()).glVertexAttribL1dv;
/* 2636 */     if (Checks.CHECKS) {
/* 2637 */       Checks.check(l);
/* 2638 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 2640 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL2dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2649 */     long l = (GL.getICD()).glVertexAttribL2dv;
/* 2650 */     if (Checks.CHECKS) {
/* 2651 */       Checks.check(l);
/* 2652 */       Checks.check(paramArrayOfdouble, 2);
/*      */     } 
/* 2654 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL3dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2663 */     long l = (GL.getICD()).glVertexAttribL3dv;
/* 2664 */     if (Checks.CHECKS) {
/* 2665 */       Checks.check(l);
/* 2666 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 2668 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glVertexAttribL4dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2677 */     long l = (GL.getICD()).glVertexAttribL4dv;
/* 2678 */     if (Checks.CHECKS) {
/* 2679 */       Checks.check(l);
/* 2680 */       Checks.check(paramArrayOfdouble, 4);
/*      */     } 
/* 2682 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetVertexAttribLdv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 2691 */     long l = (GL.getICD()).glGetVertexAttribLdv;
/* 2692 */     if (Checks.CHECKS) {
/* 2693 */       Checks.check(l);
/* 2694 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 2696 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glViewportArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2705 */     long l = (GL.getICD()).glViewportArrayv;
/* 2706 */     if (Checks.CHECKS) {
/* 2707 */       Checks.check(l);
/*      */     }
/* 2709 */     JNI.callPV(paramInt, paramArrayOffloat.length >> 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glViewportIndexedfv(@NativeType("GLuint") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 2718 */     long l = (GL.getICD()).glViewportIndexedfv;
/* 2719 */     if (Checks.CHECKS) {
/* 2720 */       Checks.check(l);
/* 2721 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 2723 */     JNI.callPV(paramInt, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glScissorArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2732 */     long l = (GL.getICD()).glScissorArrayv;
/* 2733 */     if (Checks.CHECKS) {
/* 2734 */       Checks.check(l);
/*      */     }
/* 2736 */     JNI.callPV(paramInt, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glScissorIndexedv(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 2745 */     long l = (GL.getICD()).glScissorIndexedv;
/* 2746 */     if (Checks.CHECKS) {
/* 2747 */       Checks.check(l);
/* 2748 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 2750 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDepthRangeArrayv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 2759 */     long l = (GL.getICD()).glDepthRangeArrayv;
/* 2760 */     if (Checks.CHECKS) {
/* 2761 */       Checks.check(l);
/*      */     }
/* 2763 */     JNI.callPV(paramInt, paramArrayOfdouble.length >> 1, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetFloati_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 2772 */     long l = (GL.getICD()).glGetFloati_v;
/* 2773 */     if (Checks.CHECKS) {
/* 2774 */       Checks.check(l);
/* 2775 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 2777 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetDoublei_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 2786 */     long l = (GL.getICD()).glGetDoublei_v;
/* 2787 */     if (Checks.CHECKS) {
/* 2788 */       Checks.check(l);
/* 2789 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 2791 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*      */   }
/*      */   
/*      */   public static native void glReleaseShaderCompiler();
/*      */   
/*      */   public static native void nglShaderBinary(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3);
/*      */   
/*      */   public static native void nglGetShaderPrecisionFormat(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glDepthRangef(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glClearDepthf(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglGetProgramBinary(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nglProgramBinary(int paramInt1, int paramInt2, long paramLong, int paramInt3);
/*      */   
/*      */   public static native void glProgramParameteri(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glUseProgramStages(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glActiveShaderProgram(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native int nglCreateShaderProgramv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glBindProgramPipeline(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglDeleteProgramPipelines(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenProgramPipelines(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsProgramPipeline(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglGetProgramPipelineiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glProgramUniform1i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glProgramUniform2i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*      */   
/*      */   public static native void glProgramUniform3i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5);
/*      */   
/*      */   public static native void glProgramUniform4i(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6);
/*      */   
/*      */   public static native void glProgramUniform1ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3);
/*      */   
/*      */   public static native void glProgramUniform2ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*      */   
/*      */   public static native void glProgramUniform3ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5);
/*      */   
/*      */   public static native void glProgramUniform4ui(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6);
/*      */   
/*      */   public static native void glProgramUniform1f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glProgramUniform2f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glProgramUniform3f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glProgramUniform4f(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void glProgramUniform1d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void glProgramUniform2d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glProgramUniform3d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glProgramUniform4d(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglProgramUniform1iv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2iv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3iv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4iv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform1uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4uiv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform1fv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2fv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3fv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4fv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform1dv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform2dv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform3dv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniform4dv(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x3fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x2fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x4fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x2fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x4fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x3fv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x3dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x2dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix2x4dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x2dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix3x4dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void nglProgramUniformMatrix4x3dv(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void glValidateProgramPipeline(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglGetProgramPipelineInfoLog(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void glVertexAttribL1d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void glVertexAttribL2d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void glVertexAttribL3d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glVertexAttribL4d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*      */   
/*      */   public static native void nglVertexAttribL1dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribL2dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribL3dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribL4dv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglVertexAttribLPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetVertexAttribLdv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglViewportArrayv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glViewportIndexedf(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*      */   
/*      */   public static native void nglViewportIndexedfv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglScissorArrayv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glScissorIndexed(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void nglScissorIndexedv(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglDepthRangeArrayv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glDepthRangeIndexed(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglGetFloati_v(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetDoublei_v(int paramInt1, int paramInt2, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL41C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */