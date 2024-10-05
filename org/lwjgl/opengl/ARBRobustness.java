/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ARBRobustness
/*      */ {
/*      */   public static final int GL_GUILTY_CONTEXT_RESET_ARB = 33363;
/*      */   public static final int GL_INNOCENT_CONTEXT_RESET_ARB = 33364;
/*      */   public static final int GL_UNKNOWN_CONTEXT_RESET_ARB = 33365;
/*      */   public static final int GL_RESET_NOTIFICATION_STRATEGY_ARB = 33366;
/*      */   public static final int GL_LOSE_CONTEXT_ON_RESET_ARB = 33362;
/*      */   public static final int GL_NO_RESET_NOTIFICATION_ARB = 33377;
/*      */   public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT_ARB = 4;
/*      */   
/*      */   static {
/*   78 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ARBRobustness() {
/*   98 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnMapdvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/*  143 */     nglGetnMapdvARB(paramInt1, paramInt2, paramDoubleBuffer.remaining(), MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetnMapdARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  154 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  156 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/*  157 */       nglGetnMapdvARB(paramInt1, paramInt2, 1, MemoryUtil.memAddress(doubleBuffer));
/*  158 */       return doubleBuffer.get(0);
/*      */     } finally {
/*  160 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetnMapfvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  181 */     nglGetnMapfvARB(paramInt1, paramInt2, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetnMapfARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  192 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  194 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  195 */       nglGetnMapfvARB(paramInt1, paramInt2, 1, MemoryUtil.memAddress(floatBuffer));
/*  196 */       return floatBuffer.get(0);
/*      */     } finally {
/*  198 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetnMapivARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  219 */     nglGetnMapivARB(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetnMapiARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  230 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  232 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  233 */       nglGetnMapivARB(paramInt1, paramInt2, 1, MemoryUtil.memAddress(intBuffer));
/*  234 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  236 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetnPixelMapfvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  256 */     nglGetnPixelMapfvARB(paramInt, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapuivARB(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  275 */     nglGetnPixelMapuivARB(paramInt, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapusvARB(@NativeType("GLenum") int paramInt, @NativeType("GLushort *") ShortBuffer paramShortBuffer) {
/*  294 */     nglGetnPixelMapusvARB(paramInt, paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPolygonStippleARB(@NativeType("GLsizei") int paramInt, @NativeType("GLubyte *") long paramLong) {
/*  313 */     nglGetnPolygonStippleARB(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnPolygonStippleARB(@NativeType("GLubyte *") ByteBuffer paramByteBuffer) {
/*  322 */     nglGetnPolygonStippleARB(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("void *") long paramLong) {
/*  345 */     nglGetnTexImageARB(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  358 */     nglGetnTexImageARB(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") ShortBuffer paramShortBuffer) {
/*  371 */     nglGetnTexImageARB(paramInt1, paramInt2, paramInt3, paramInt4, paramShortBuffer.remaining() << 1, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") IntBuffer paramIntBuffer) {
/*  384 */     nglGetnTexImageARB(paramInt1, paramInt2, paramInt3, paramInt4, paramIntBuffer.remaining() << 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/*  397 */     nglGetnTexImageARB(paramInt1, paramInt2, paramInt3, paramInt4, paramFloatBuffer.remaining() << 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/*  410 */     nglGetnTexImageARB(paramInt1, paramInt2, paramInt3, paramInt4, paramDoubleBuffer.remaining() << 3, MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixelsARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("void *") long paramLong) {
/*  435 */     nglReadnPixelsARB(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixelsARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  450 */     nglReadnPixelsARB(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixelsARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") ShortBuffer paramShortBuffer) {
/*  465 */     nglReadnPixelsARB(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramShortBuffer.remaining() << 1, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixelsARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") IntBuffer paramIntBuffer) {
/*  480 */     nglReadnPixelsARB(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramIntBuffer.remaining() << 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glReadnPixelsARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/*  495 */     nglReadnPixelsARB(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFloatBuffer.remaining() << 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnColorTableARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void *") long paramLong) {
/*  517 */     nglGetnColorTableARB(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnColorTableARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  529 */     nglGetnColorTableARB(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnColorTableARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ShortBuffer paramShortBuffer) {
/*  541 */     nglGetnColorTableARB(paramInt1, paramInt2, paramInt3, paramShortBuffer.remaining() << 1, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnColorTableARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") IntBuffer paramIntBuffer) {
/*  553 */     nglGetnColorTableARB(paramInt1, paramInt2, paramInt3, paramIntBuffer.remaining() << 2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnColorTableARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/*  565 */     nglGetnColorTableARB(paramInt1, paramInt2, paramInt3, paramFloatBuffer.remaining() << 2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnConvolutionFilterARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void *") long paramLong) {
/*  587 */     nglGetnConvolutionFilterARB(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnConvolutionFilterARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  599 */     nglGetnConvolutionFilterARB(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnSeparableFilterARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void *") long paramLong1, @NativeType("GLsizei") int paramInt5, @NativeType("void *") long paramLong2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  624 */     nglGetnSeparableFilterARB(paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramInt5, paramLong2, MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnSeparableFilterARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer1, @NativeType("void *") ByteBuffer paramByteBuffer2, @NativeType("void *") ByteBuffer paramByteBuffer3) {
/*  637 */     nglGetnSeparableFilterARB(paramInt1, paramInt2, paramInt3, paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer2.remaining(), MemoryUtil.memAddress(paramByteBuffer2), MemoryUtil.memAddressSafe(paramByteBuffer3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnHistogramARB(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void *") long paramLong) {
/*  660 */     nglGetnHistogramARB(paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnHistogramARB(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  673 */     nglGetnHistogramARB(paramInt1, paramBoolean, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnMinmaxARB(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void *") long paramLong) {
/*  697 */     nglGetnMinmaxARB(paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnMinmaxARB(@NativeType("GLenum") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  711 */     nglGetnMinmaxARB(paramInt1, paramBoolean, paramInt2, paramInt3, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnCompressedTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void *") long paramLong) {
/*  732 */     nglGetnCompressedTexImageARB(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnCompressedTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  743 */     if (Checks.CHECKS && 
/*  744 */       Checks.DEBUG) {
/*  745 */       Checks.check(paramByteBuffer, GL11.glGetTexLevelParameteri(paramInt1, paramInt2, 34464));
/*      */     }
/*      */     
/*  748 */     nglGetnCompressedTexImageARB(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetnUniformfvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/*  768 */     nglGetnUniformfvARB(paramInt1, paramInt2, paramFloatBuffer.remaining(), MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static float glGetnUniformfARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  779 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  781 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/*  782 */       nglGetnUniformfvARB(paramInt1, paramInt2, 1, MemoryUtil.memAddress(floatBuffer));
/*  783 */       return floatBuffer.get(0);
/*      */     } finally {
/*  785 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetnUniformivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  806 */     nglGetnUniformivARB(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetnUniformiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  817 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  819 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  820 */       nglGetnUniformivARB(paramInt1, paramInt2, 1, MemoryUtil.memAddress(intBuffer));
/*  821 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  823 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetnUniformuivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  844 */     nglGetnUniformuivARB(paramInt1, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetnUniformuiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  855 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  857 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  858 */       nglGetnUniformuivARB(paramInt1, paramInt2, 1, MemoryUtil.memAddress(intBuffer));
/*  859 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  861 */       memoryStack.setPointer(i);
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
/*      */   public static void glGetnUniformdvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/*  882 */     nglGetnUniformdvARB(paramInt1, paramInt2, paramDoubleBuffer.remaining(), MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static double glGetnUniformdARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*      */     MemoryStack memoryStack;
/*  893 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  895 */       DoubleBuffer doubleBuffer = memoryStack.callocDouble(1);
/*  896 */       nglGetnUniformdvARB(paramInt1, paramInt2, 1, MemoryUtil.memAddress(doubleBuffer));
/*  897 */       return doubleBuffer.get(0);
/*      */     } finally {
/*  899 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnMapdvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/*  905 */     long l = (GL.getICD()).glGetnMapdvARB;
/*  906 */     if (Checks.CHECKS) {
/*  907 */       Checks.check(l);
/*      */     }
/*  909 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnMapfvARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/*  914 */     long l = (GL.getICD()).glGetnMapfvARB;
/*  915 */     if (Checks.CHECKS) {
/*  916 */       Checks.check(l);
/*      */     }
/*  918 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnMapivARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/*  923 */     long l = (GL.getICD()).glGetnMapivARB;
/*  924 */     if (Checks.CHECKS) {
/*  925 */       Checks.check(l);
/*      */     }
/*  927 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapfvARB(@NativeType("GLenum") int paramInt, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/*  932 */     long l = (GL.getICD()).glGetnPixelMapfvARB;
/*  933 */     if (Checks.CHECKS) {
/*  934 */       Checks.check(l);
/*      */     }
/*  936 */     JNI.callPV(paramInt, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapuivARB(@NativeType("GLenum") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/*  941 */     long l = (GL.getICD()).glGetnPixelMapuivARB;
/*  942 */     if (Checks.CHECKS) {
/*  943 */       Checks.check(l);
/*      */     }
/*  945 */     JNI.callPV(paramInt, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnPixelMapusvARB(@NativeType("GLenum") int paramInt, @NativeType("GLushort *") short[] paramArrayOfshort) {
/*  950 */     long l = (GL.getICD()).glGetnPixelMapusvARB;
/*  951 */     if (Checks.CHECKS) {
/*  952 */       Checks.check(l);
/*      */     }
/*  954 */     JNI.callPV(paramInt, paramArrayOfshort.length, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") short[] paramArrayOfshort) {
/*  959 */     long l = (GL.getICD()).glGetnTexImageARB;
/*  960 */     if (Checks.CHECKS) {
/*  961 */       Checks.check(l);
/*      */     }
/*  963 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfshort.length << 1, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") int[] paramArrayOfint) {
/*  968 */     long l = (GL.getICD()).glGetnTexImageARB;
/*  969 */     if (Checks.CHECKS) {
/*  970 */       Checks.check(l);
/*      */     }
/*  972 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint.length << 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") float[] paramArrayOffloat) {
/*  977 */     long l = (GL.getICD()).glGetnTexImageARB;
/*  978 */     if (Checks.CHECKS) {
/*  979 */       Checks.check(l);
/*      */     }
/*  981 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOffloat.length << 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnTexImageARB(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void *") double[] paramArrayOfdouble) {
/*  986 */     long l = (GL.getICD()).glGetnTexImageARB;
/*  987 */     if (Checks.CHECKS) {
/*  988 */       Checks.check(l);
/*      */     }
/*  990 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfdouble.length << 3, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixelsARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") short[] paramArrayOfshort) {
/*  995 */     long l = (GL.getICD()).glReadnPixelsARB;
/*  996 */     if (Checks.CHECKS) {
/*  997 */       Checks.check(l);
/*      */     }
/*  999 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfshort.length << 1, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixelsARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") int[] paramArrayOfint) {
/* 1004 */     long l = (GL.getICD()).glReadnPixelsARB;
/* 1005 */     if (Checks.CHECKS) {
/* 1006 */       Checks.check(l);
/*      */     }
/* 1008 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfint.length << 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glReadnPixelsARB(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6, @NativeType("void *") float[] paramArrayOffloat) {
/* 1013 */     long l = (GL.getICD()).glReadnPixelsARB;
/* 1014 */     if (Checks.CHECKS) {
/* 1015 */       Checks.check(l);
/*      */     }
/* 1017 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOffloat.length << 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnColorTableARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") short[] paramArrayOfshort) {
/* 1022 */     long l = (GL.getICD()).glGetnColorTableARB;
/* 1023 */     if (Checks.CHECKS) {
/* 1024 */       Checks.check(l);
/*      */     }
/* 1026 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfshort.length << 1, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnColorTableARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") int[] paramArrayOfint) {
/* 1031 */     long l = (GL.getICD()).glGetnColorTableARB;
/* 1032 */     if (Checks.CHECKS) {
/* 1033 */       Checks.check(l);
/*      */     }
/* 1035 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint.length << 2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnColorTableARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") float[] paramArrayOffloat) {
/* 1040 */     long l = (GL.getICD()).glGetnColorTableARB;
/* 1041 */     if (Checks.CHECKS) {
/* 1042 */       Checks.check(l);
/*      */     }
/* 1044 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat.length << 2, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformfvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 1049 */     long l = (GL.getICD()).glGetnUniformfvARB;
/* 1050 */     if (Checks.CHECKS) {
/* 1051 */       Checks.check(l);
/*      */     }
/* 1053 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1058 */     long l = (GL.getICD()).glGetnUniformivARB;
/* 1059 */     if (Checks.CHECKS) {
/* 1060 */       Checks.check(l);
/*      */     }
/* 1062 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformuivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 1067 */     long l = (GL.getICD()).glGetnUniformuivARB;
/* 1068 */     if (Checks.CHECKS) {
/* 1069 */       Checks.check(l);
/*      */     }
/* 1071 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void glGetnUniformdvARB(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 1076 */     long l = (GL.getICD()).glGetnUniformdvARB;
/* 1077 */     if (Checks.CHECKS) {
/* 1078 */       Checks.check(l);
/*      */     }
/* 1080 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble.length, paramArrayOfdouble, l);
/*      */   }
/*      */   
/*      */   @NativeType("GLenum")
/*      */   public static native int glGetGraphicsResetStatusARB();
/*      */   
/*      */   public static native void nglGetnMapdvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnMapfvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnMapivARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnPixelMapfvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetnPixelMapuivARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetnPixelMapusvARB(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetnPolygonStippleARB(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGetnTexImageARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
/*      */   
/*      */   public static native void nglReadnPixelsARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong);
/*      */   
/*      */   public static native void nglGetnColorTableARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetnConvolutionFilterARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetnSeparableFilterARB(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nglGetnHistogramARB(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetnMinmaxARB(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void nglGetnCompressedTexImageARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformfvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformivARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformuivARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void nglGetnUniformdvARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBRobustness.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */