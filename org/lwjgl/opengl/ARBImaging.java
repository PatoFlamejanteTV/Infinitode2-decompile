/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ public class ARBImaging
/*      */ {
/*      */   public static final int GL_COLOR_TABLE = 32976;
/*      */   public static final int GL_POST_CONVOLUTION_COLOR_TABLE = 32977;
/*      */   public static final int GL_POST_COLOR_MATRIX_COLOR_TABLE = 32978;
/*      */   public static final int GL_PROXY_COLOR_TABLE = 32979;
/*      */   
/*      */   static {
/*   22 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_PROXY_POST_CONVOLUTION_COLOR_TABLE = 32980;
/*      */ 
/*      */   
/*      */   public static final int GL_PROXY_POST_COLOR_MATRIX_COLOR_TABLE = 32981;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_TABLE_SCALE = 32982;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_TABLE_BIAS = 32983;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_TABLE_FORMAT = 32984;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_TABLE_WIDTH = 32985;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_TABLE_RED_SIZE = 32986;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_TABLE_GREEN_SIZE = 32987;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_TABLE_BLUE_SIZE = 32988;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_TABLE_ALPHA_SIZE = 32989;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_TABLE_LUMINANCE_SIZE = 32990;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_TABLE_INTENSITY_SIZE = 32991;
/*      */ 
/*      */   
/*      */   public static final int GL_TABLE_TOO_LARGE = 32817;
/*      */ 
/*      */   
/*      */   public static final int GL_CONVOLUTION_1D = 32784;
/*      */ 
/*      */   
/*      */   public static final int GL_CONVOLUTION_2D = 32785;
/*      */ 
/*      */   
/*      */   public static final int GL_SEPARABLE_2D = 32786;
/*      */ 
/*      */   
/*      */   public static final int GL_CONVOLUTION_BORDER_MODE = 32787;
/*      */ 
/*      */   
/*      */   public static final int GL_CONVOLUTION_FILTER_SCALE = 32788;
/*      */ 
/*      */   
/*      */   public static final int GL_CONVOLUTION_FILTER_BIAS = 32789;
/*      */ 
/*      */   
/*      */   public static final int GL_REDUCE = 32790;
/*      */ 
/*      */   
/*      */   public static final int GL_CONVOLUTION_FORMAT = 32791;
/*      */ 
/*      */   
/*      */   public static final int GL_CONVOLUTION_WIDTH = 32792;
/*      */ 
/*      */   
/*      */   public static final int GL_CONVOLUTION_HEIGHT = 32793;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_CONVOLUTION_WIDTH = 32794;
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_CONVOLUTION_HEIGHT = 32795;
/*      */ 
/*      */   
/*      */   public static final int GL_POST_CONVOLUTION_RED_SCALE = 32796;
/*      */ 
/*      */   
/*      */   public static final int GL_POST_CONVOLUTION_GREEN_SCALE = 32797;
/*      */ 
/*      */   
/*      */   public static final int GL_POST_CONVOLUTION_BLUE_SCALE = 32798;
/*      */ 
/*      */   
/*      */   public static final int GL_POST_CONVOLUTION_ALPHA_SCALE = 32799;
/*      */ 
/*      */   
/*      */   public static final int GL_POST_CONVOLUTION_RED_BIAS = 32800;
/*      */ 
/*      */   
/*      */   public static final int GL_POST_CONVOLUTION_GREEN_BIAS = 32801;
/*      */ 
/*      */   
/*      */   public static final int GL_POST_CONVOLUTION_BLUE_BIAS = 32802;
/*      */ 
/*      */   
/*      */   public static final int GL_POST_CONVOLUTION_ALPHA_BIAS = 32803;
/*      */ 
/*      */   
/*      */   public static final int GL_CONSTANT_BORDER = 33105;
/*      */ 
/*      */   
/*      */   public static final int GL_REPLICATE_BORDER = 33107;
/*      */ 
/*      */   
/*      */   public static final int GL_CONVOLUTION_BORDER_COLOR = 33108;
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_MATRIX = 32945;
/*      */   
/*      */   public static final int GL_COLOR_MATRIX_STACK_DEPTH = 32946;
/*      */   
/*      */   public static final int GL_MAX_COLOR_MATRIX_STACK_DEPTH = 32947;
/*      */   
/*      */   public static final int GL_POST_COLOR_MATRIX_RED_SCALE = 32948;
/*      */   
/*      */   public static final int GL_POST_COLOR_MATRIX_GREEN_SCALE = 32949;
/*      */   
/*      */   public static final int GL_POST_COLOR_MATRIX_BLUE_SCALE = 32950;
/*      */   
/*      */   public static final int GL_POST_COLOR_MATRIX_ALPHA_SCALE = 32951;
/*      */   
/*      */   public static final int GL_POST_COLOR_MATRIX_RED_BIAS = 32952;
/*      */   
/*      */   public static final int GL_POST_COLOR_MATRIX_GREEN_BIAS = 32953;
/*      */   
/*      */   public static final int GL_POST_COLOR_MATRIX_BLUE_BIAS = 32954;
/*      */   
/*      */   public static final int GL_POST_COLOR_MATRIX_ALPHA_BIAS = 32955;
/*      */   
/*      */   public static final int GL_HISTOGRAM = 32804;
/*      */   
/*      */   public static final int GL_PROXY_HISTOGRAM = 32805;
/*      */   
/*      */   public static final int GL_HISTOGRAM_WIDTH = 32806;
/*      */   
/*      */   public static final int GL_HISTOGRAM_FORMAT = 32807;
/*      */   
/*      */   public static final int GL_HISTOGRAM_RED_SIZE = 32808;
/*      */   
/*      */   public static final int GL_HISTOGRAM_GREEN_SIZE = 32809;
/*      */   
/*      */   public static final int GL_HISTOGRAM_BLUE_SIZE = 32810;
/*      */   
/*      */   public static final int GL_HISTOGRAM_ALPHA_SIZE = 32811;
/*      */   
/*      */   public static final int GL_HISTOGRAM_LUMINANCE_SIZE = 32812;
/*      */   
/*      */   public static final int GL_HISTOGRAM_SINK = 32813;
/*      */   
/*      */   public static final int GL_MINMAX = 32814;
/*      */   
/*      */   public static final int GL_MINMAX_FORMAT = 32815;
/*      */   
/*      */   public static final int GL_MINMAX_SINK = 32816;
/*      */   
/*      */   public static final int GL_CONSTANT_COLOR = 32769;
/*      */   
/*      */   public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
/*      */   
/*      */   public static final int GL_CONSTANT_ALPHA = 32771;
/*      */   
/*      */   public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
/*      */   
/*      */   public static final int GL_BLEND_COLOR = 32773;
/*      */   
/*      */   public static final int GL_FUNC_ADD = 32774;
/*      */   
/*      */   public static final int GL_MIN = 32775;
/*      */   
/*      */   public static final int GL_MAX = 32776;
/*      */   
/*      */   public static final int GL_BLEND_EQUATION = 32777;
/*      */   
/*      */   public static final int GL_FUNC_SUBTRACT = 32778;
/*      */   
/*      */   public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
/*      */ 
/*      */   
/*      */   protected ARBImaging() {
/*  207 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  226 */     nglColorTable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") long paramLong) {
/*  240 */     nglColorTable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  254 */     nglColorTable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  268 */     nglColorTable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  282 */     nglColorTable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorTableParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  311 */     if (Checks.CHECKS) {
/*  312 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  314 */     nglColorTableParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorTableParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  330 */     if (Checks.CHECKS) {
/*  331 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/*  333 */     nglColorTableParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  350 */     nglGetColorTable(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") long paramLong) {
/*  362 */     nglGetColorTable(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ShortBuffer paramShortBuffer) {
/*  374 */     nglGetColorTable(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") IntBuffer paramIntBuffer) {
/*  386 */     nglGetColorTable(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/*  398 */     nglGetColorTable(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetColorTableParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  414 */     if (Checks.CHECKS) {
/*  415 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  417 */     nglGetColorTableParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetColorTableParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  428 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  430 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  431 */       nglGetColorTableParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  432 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  434 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetColorTableParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  451 */     if (Checks.CHECKS) {
/*  452 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/*  454 */     nglGetColorTableParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetColorTableParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  465 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  467 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  468 */       nglGetColorTableParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/*  469 */       return floatBuffer.get(0);
/*      */     } finally {
/*  471 */       memoryStack.setPointer(i);
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
/*      */   public static void glColorSubTable(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  491 */     nglColorSubTable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glColorSubTable(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") long paramLong) {
/*  505 */     nglColorSubTable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glConvolutionFilter1D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  537 */     nglConvolutionFilter1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glConvolutionFilter1D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") long paramLong) {
/*  551 */     nglConvolutionFilter1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glConvolutionFilter2D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  571 */     nglConvolutionFilter2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glConvolutionFilter2D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") long paramLong) {
/*  586 */     nglConvolutionFilter2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetConvolutionFilter(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  632 */     nglGetConvolutionFilter(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetConvolutionFilter(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") long paramLong) {
/*  644 */     nglGetConvolutionFilter(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSeparableFilter2D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") ByteBuffer paramByteBuffer1, @NativeType("void const *") ByteBuffer paramByteBuffer2) {
/*  665 */     nglSeparableFilter2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSeparableFilter2D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void const *") long paramLong1, @NativeType("void const *") long paramLong2) {
/*  681 */     nglSeparableFilter2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSeparableFilter(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer1, @NativeType("void *") ByteBuffer paramByteBuffer2, @NativeType("void *") ByteBuffer paramByteBuffer3) {
/*  700 */     nglGetSeparableFilter(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddress(paramByteBuffer2), MemoryUtil.memAddressSafe(paramByteBuffer3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetSeparableFilter(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") long paramLong1, @NativeType("void *") long paramLong2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  714 */     nglGetSeparableFilter(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glConvolutionParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  741 */     if (Checks.CHECKS) {
/*  742 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  744 */     nglConvolutionParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glConvolutionParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  771 */     if (Checks.CHECKS) {
/*  772 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/*  774 */     nglConvolutionParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetConvolutionParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  790 */     if (Checks.CHECKS) {
/*  791 */       Checks.check(paramIntBuffer, 4);
/*      */     }
/*  793 */     nglGetConvolutionParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetConvolutionParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  804 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  806 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  807 */       nglGetConvolutionParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  808 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  810 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetConvolutionParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  827 */     if (Checks.CHECKS) {
/*  828 */       Checks.check(paramFloatBuffer, 4);
/*      */     }
/*  830 */     nglGetConvolutionParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetConvolutionParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  841 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  843 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  844 */       nglGetConvolutionParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/*  845 */       return floatBuffer.get(0);
/*      */     } finally {
/*  847 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetHistogram(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  887 */     nglGetHistogram(paramInt1, paramBoolean, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetHistogram(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") long paramLong) {
/*  900 */     nglGetHistogram(paramInt1, paramBoolean, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetHistogramParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  916 */     if (Checks.CHECKS) {
/*  917 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  919 */     nglGetHistogramParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetHistogramParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  930 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  932 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  933 */       nglGetHistogramParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  934 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  936 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetHistogramParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  953 */     if (Checks.CHECKS) {
/*  954 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  956 */     nglGetHistogramParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetHistogramParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  967 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  969 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  970 */       nglGetHistogramParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/*  971 */       return floatBuffer.get(0);
/*      */     } finally {
/*  973 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetMinmax(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 1013 */     nglGetMinmax(paramInt1, paramBoolean, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMinmax(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") long paramLong) {
/* 1027 */     nglGetMinmax(paramInt1, paramBoolean, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetMinmaxParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1043 */     if (Checks.CHECKS) {
/* 1044 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1046 */     nglGetMinmaxParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetMinmaxParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1057 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1059 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1060 */       nglGetMinmaxParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1061 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1063 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetMinmaxParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 1080 */     if (Checks.CHECKS) {
/* 1081 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/* 1083 */     nglGetMinmaxParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetMinmaxParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1094 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1096 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 1097 */       nglGetMinmaxParameterfv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 1098 */       return floatBuffer.get(0);
/*      */     } finally {
/* 1100 */       memoryStack.setPointer(i);
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
/*      */   public static void glBlendColor(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4) {
/* 1115 */     GL14C.glBlendColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBlendEquation(@NativeType("GLenum") int paramInt) {
/* 1126 */     GL14C.glBlendEquation(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1131 */     long l = (GL.getICD()).glColorTable;
/* 1132 */     if (Checks.CHECKS) {
/* 1133 */       Checks.check(l);
/*      */     }
/* 1135 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") int[] paramArrayOfint) {
/* 1140 */     long l = (GL.getICD()).glColorTable;
/* 1141 */     if (Checks.CHECKS) {
/* 1142 */       Checks.check(l);
/*      */     }
/* 1144 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1149 */     long l = (GL.getICD()).glColorTable;
/* 1150 */     if (Checks.CHECKS) {
/* 1151 */       Checks.check(l);
/*      */     }
/* 1153 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColorTableParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1158 */     long l = (GL.getICD()).glColorTableParameteriv;
/* 1159 */     if (Checks.CHECKS) {
/* 1160 */       Checks.check(l);
/* 1161 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 1163 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glColorTableParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1168 */     long l = (GL.getICD()).glColorTableParameterfv;
/* 1169 */     if (Checks.CHECKS) {
/* 1170 */       Checks.check(l);
/* 1171 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1173 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") short[] paramArrayOfshort) {
/* 1178 */     long l = (GL.getICD()).glGetColorTable;
/* 1179 */     if (Checks.CHECKS) {
/* 1180 */       Checks.check(l);
/*      */     }
/* 1182 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") int[] paramArrayOfint) {
/* 1187 */     long l = (GL.getICD()).glGetColorTable;
/* 1188 */     if (Checks.CHECKS) {
/* 1189 */       Checks.check(l);
/*      */     }
/* 1191 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") float[] paramArrayOffloat) {
/* 1196 */     long l = (GL.getICD()).glGetColorTable;
/* 1197 */     if (Checks.CHECKS) {
/* 1198 */       Checks.check(l);
/*      */     }
/* 1200 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetColorTableParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1205 */     long l = (GL.getICD()).glGetColorTableParameteriv;
/* 1206 */     if (Checks.CHECKS) {
/* 1207 */       Checks.check(l);
/* 1208 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 1210 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetColorTableParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1215 */     long l = (GL.getICD()).glGetColorTableParameterfv;
/* 1216 */     if (Checks.CHECKS) {
/* 1217 */       Checks.check(l);
/* 1218 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1220 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glConvolutionParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1225 */     long l = (GL.getICD()).glConvolutionParameteriv;
/* 1226 */     if (Checks.CHECKS) {
/* 1227 */       Checks.check(l);
/* 1228 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 1230 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glConvolutionParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1235 */     long l = (GL.getICD()).glConvolutionParameterfv;
/* 1236 */     if (Checks.CHECKS) {
/* 1237 */       Checks.check(l);
/* 1238 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1240 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetConvolutionParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1245 */     long l = (GL.getICD()).glGetConvolutionParameteriv;
/* 1246 */     if (Checks.CHECKS) {
/* 1247 */       Checks.check(l);
/* 1248 */       Checks.check(paramArrayOfint, 4);
/*      */     } 
/* 1250 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetConvolutionParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1255 */     long l = (GL.getICD()).glGetConvolutionParameterfv;
/* 1256 */     if (Checks.CHECKS) {
/* 1257 */       Checks.check(l);
/* 1258 */       Checks.check(paramArrayOffloat, 4);
/*      */     } 
/* 1260 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetHistogramParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1265 */     long l = (GL.getICD()).glGetHistogramParameteriv;
/* 1266 */     if (Checks.CHECKS) {
/* 1267 */       Checks.check(l);
/* 1268 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1270 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetHistogramParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1275 */     long l = (GL.getICD()).glGetHistogramParameterfv;
/* 1276 */     if (Checks.CHECKS) {
/* 1277 */       Checks.check(l);
/* 1278 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1280 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMinmaxParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1285 */     long l = (GL.getICD()).glGetMinmaxParameteriv;
/* 1286 */     if (Checks.CHECKS) {
/* 1287 */       Checks.check(l);
/* 1288 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1290 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetMinmaxParameterfv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1295 */     long l = (GL.getICD()).glGetMinmaxParameterfv;
/* 1296 */     if (Checks.CHECKS) {
/* 1297 */       Checks.check(l);
/* 1298 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1300 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*      */   }
/*      */   
/*      */   public static native void nglColorTable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void glCopyColorTable(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void nglColorTableParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglColorTableParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetColorTable(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetColorTableParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetColorTableParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglColorSubTable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void glCopyColorSubTable(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void nglConvolutionFilter1D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglConvolutionFilter2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*      */   
/*      */   public static native void glCopyConvolutionFilter1D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5);
/*      */   
/*      */   public static native void glCopyConvolutionFilter2D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6);
/*      */   
/*      */   public static native void nglGetConvolutionFilter(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglSeparableFilter2D(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nglGetSeparableFilter(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void glConvolutionParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglConvolutionParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glConvolutionParameterf(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void nglConvolutionParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetConvolutionParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetConvolutionParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glHistogram(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void glResetHistogram(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglGetHistogram(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetHistogramParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetHistogramParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glMinmax(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLboolean") boolean paramBoolean);
/*      */   
/*      */   public static native void glResetMinmax(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglGetMinmax(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetMinmaxParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetMinmaxParameterfv(int paramInt1, int paramInt2, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBImaging.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */