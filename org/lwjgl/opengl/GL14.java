/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class GL14 extends GL13 {
/*      */   public static final int GL_GENERATE_MIPMAP = 33169;
/*      */   public static final int GL_GENERATE_MIPMAP_HINT = 33170;
/*      */   public static final int GL_CONSTANT_COLOR = 32769;
/*      */   public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
/*      */   public static final int GL_CONSTANT_ALPHA = 32771;
/*      */   public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
/*      */   public static final int GL_FUNC_ADD = 32774;
/*      */   public static final int GL_MIN = 32775;
/*      */   public static final int GL_MAX = 32776;
/*      */   public static final int GL_FUNC_SUBTRACT = 32778;
/*      */   public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
/*      */   public static final int GL_DEPTH_COMPONENT16 = 33189;
/*      */   public static final int GL_DEPTH_COMPONENT24 = 33190;
/*      */   public static final int GL_DEPTH_COMPONENT32 = 33191;
/*      */   public static final int GL_TEXTURE_DEPTH_SIZE = 34890;
/*      */   public static final int GL_DEPTH_TEXTURE_MODE = 34891;
/*      */   public static final int GL_TEXTURE_COMPARE_MODE = 34892;
/*      */   public static final int GL_TEXTURE_COMPARE_FUNC = 34893;
/*      */   public static final int GL_COMPARE_R_TO_TEXTURE = 34894;
/*      */   public static final int GL_FOG_COORDINATE_SOURCE = 33872;
/*      */   public static final int GL_FOG_COORDINATE = 33873;
/*      */   public static final int GL_FRAGMENT_DEPTH = 33874;
/*      */   public static final int GL_CURRENT_FOG_COORDINATE = 33875;
/*      */   public static final int GL_FOG_COORDINATE_ARRAY_TYPE = 33876;
/*      */   
/*      */   static {
/*   41 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_FOG_COORDINATE_ARRAY_STRIDE = 33877;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_FOG_COORDINATE_ARRAY_POINTER = 33878;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_FOG_COORDINATE_ARRAY = 33879;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_POINT_SIZE_MIN = 33062;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_POINT_SIZE_MAX = 33063;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_POINT_DISTANCE_ATTENUATION = 33065;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_COLOR_SUM = 33880;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_CURRENT_SECONDARY_COLOR = 33881;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_SECONDARY_COLOR_ARRAY_SIZE = 33882;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_SECONDARY_COLOR_ARRAY_TYPE = 33883;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE = 33884;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_SECONDARY_COLOR_ARRAY_POINTER = 33885;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_SECONDARY_COLOR_ARRAY = 33886;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_BLEND_DST_RGB = 32968;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_BLEND_SRC_RGB = 32969;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_BLEND_DST_ALPHA = 32970;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_BLEND_SRC_ALPHA = 32971;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_INCR_WRAP = 34055;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_DECR_WRAP = 34056;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_TEXTURE_FILTER_CONTROL = 34048;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_TEXTURE_LOD_BIAS = 34049;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_MAX_TEXTURE_LOD_BIAS = 34045;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_MIRRORED_REPEAT = 33648;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected GL14() {
/*  167 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*  183 */     GL14C.glBlendColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBlendEquation(@NativeType("GLenum") int paramInt) {
/*  196 */     GL14C.glBlendEquation(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogCoordfv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  234 */     if (Checks.CHECKS) {
/*  235 */       Checks.check(paramFloatBuffer, 1);
/*      */     }
/*  237 */     nglFogCoordfv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogCoorddv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  253 */     if (Checks.CHECKS) {
/*  254 */       Checks.check(paramDoubleBuffer, 1);
/*      */     }
/*  256 */     nglFogCoorddv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogCoordPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  274 */     nglFogCoordPointer(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogCoordPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") long paramLong) {
/*  287 */     nglFogCoordPointer(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogCoordPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  300 */     nglFogCoordPointer(paramInt1, paramInt2, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogCoordPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  313 */     nglFogCoordPointer(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglMultiDrawArrays(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {
/*  324 */     GL14C.nglMultiDrawArrays(paramInt1, paramLong1, paramLong2, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArrays(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer1, @NativeType("GLsizei const *") IntBuffer paramIntBuffer2) {
/*  337 */     GL14C.glMultiDrawArrays(paramInt, paramIntBuffer1, paramIntBuffer2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglMultiDrawElements(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3) {
/*  348 */     GL14C.nglMultiDrawElements(paramInt1, paramLong1, paramInt2, paramLong2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElements(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt2, @NativeType("void const **") PointerBuffer paramPointerBuffer) {
/*  364 */     GL14C.glMultiDrawElements(paramInt1, paramIntBuffer, paramInt2, paramPointerBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPointParameterf(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat) {
/*  378 */     GL14C.glPointParameterf(paramInt, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPointParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2) {
/*  392 */     GL14C.glPointParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglPointParameterfv(int paramInt, long paramLong) {
/*  399 */     GL14C.nglPointParameterfv(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPointParameterfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  411 */     GL14C.glPointParameterfv(paramInt, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglPointParameteriv(int paramInt, long paramLong) {
/*  418 */     GL14C.nglPointParameteriv(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPointParameteriv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  430 */     GL14C.glPointParameteriv(paramInt, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3bv(@NativeType("GLbyte const *") ByteBuffer paramByteBuffer) {
/*  550 */     if (Checks.CHECKS) {
/*  551 */       Checks.check(paramByteBuffer, 3);
/*      */     }
/*  553 */     nglSecondaryColor3bv(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  569 */     if (Checks.CHECKS) {
/*  570 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/*  572 */     nglSecondaryColor3sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  588 */     if (Checks.CHECKS) {
/*  589 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/*  591 */     nglSecondaryColor3iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  607 */     if (Checks.CHECKS) {
/*  608 */       Checks.check(paramFloatBuffer, 3);
/*      */     }
/*  610 */     nglSecondaryColor3fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  626 */     if (Checks.CHECKS) {
/*  627 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/*  629 */     nglSecondaryColor3dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3ubv(@NativeType("GLubyte const *") ByteBuffer paramByteBuffer) {
/*  645 */     if (Checks.CHECKS) {
/*  646 */       Checks.check(paramByteBuffer, 3);
/*      */     }
/*  648 */     nglSecondaryColor3ubv(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3usv(@NativeType("GLushort const *") ShortBuffer paramShortBuffer) {
/*  664 */     if (Checks.CHECKS) {
/*  665 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/*  667 */     nglSecondaryColor3usv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3uiv(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  683 */     if (Checks.CHECKS) {
/*  684 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/*  686 */     nglSecondaryColor3uiv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColorPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  705 */     nglSecondaryColorPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColorPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") long paramLong) {
/*  719 */     nglSecondaryColorPointer(paramInt1, paramInt2, paramInt3, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColorPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  733 */     nglSecondaryColorPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColorPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  747 */     nglSecondaryColorPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColorPointer(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  761 */     nglSecondaryColorPointer(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBlendFuncSeparate(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4) {
/*  777 */     GL14C.glBlendFuncSeparate(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos2iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  841 */     if (Checks.CHECKS) {
/*  842 */       Checks.check(paramIntBuffer, 2);
/*      */     }
/*  844 */     nglWindowPos2iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos2sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  860 */     if (Checks.CHECKS) {
/*  861 */       Checks.check(paramShortBuffer, 2);
/*      */     }
/*  863 */     nglWindowPos2sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos2fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  879 */     if (Checks.CHECKS) {
/*  880 */       Checks.check(paramFloatBuffer, 2);
/*      */     }
/*  882 */     nglWindowPos2fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos2dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  898 */     if (Checks.CHECKS) {
/*  899 */       Checks.check(paramDoubleBuffer, 2);
/*      */     }
/*  901 */     nglWindowPos2dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos3iv(@NativeType("GLint const *") IntBuffer paramIntBuffer) {
/*  969 */     if (Checks.CHECKS) {
/*  970 */       Checks.check(paramIntBuffer, 3);
/*      */     }
/*  972 */     nglWindowPos3iv(MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos3sv(@NativeType("GLshort const *") ShortBuffer paramShortBuffer) {
/*  988 */     if (Checks.CHECKS) {
/*  989 */       Checks.check(paramShortBuffer, 3);
/*      */     }
/*  991 */     nglWindowPos3sv(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos3fv(@NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 1007 */     if (Checks.CHECKS) {
/* 1008 */       Checks.check(paramFloatBuffer, 3);
/*      */     }
/* 1010 */     nglWindowPos3fv(MemoryUtil.memAddress(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos3dv(@NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 1026 */     if (Checks.CHECKS) {
/* 1027 */       Checks.check(paramDoubleBuffer, 3);
/*      */     }
/* 1029 */     nglWindowPos3dv(MemoryUtil.memAddress(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogCoordfv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1038 */     long l = (GL.getICD()).glFogCoordfv;
/* 1039 */     if (Checks.CHECKS) {
/* 1040 */       Checks.check(l);
/* 1041 */       Checks.check(paramArrayOffloat, 1);
/*      */     } 
/* 1043 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glFogCoorddv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1052 */     long l = (GL.getICD()).glFogCoorddv;
/* 1053 */     if (Checks.CHECKS) {
/* 1054 */       Checks.check(l);
/* 1055 */       Checks.check(paramArrayOfdouble, 1);
/*      */     } 
/* 1057 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawArrays(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint1, @NativeType("GLsizei const *") int[] paramArrayOfint2) {
/* 1066 */     GL14C.glMultiDrawArrays(paramInt, paramArrayOfint1, paramArrayOfint2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glMultiDrawElements(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt2, @NativeType("void const **") PointerBuffer paramPointerBuffer) {
/* 1075 */     GL14C.glMultiDrawElements(paramInt1, paramArrayOfint, paramInt2, paramPointerBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPointParameterfv(@NativeType("GLenum") int paramInt, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1084 */     GL14C.glPointParameterfv(paramInt, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glPointParameteriv(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1093 */     GL14C.glPointParameteriv(paramInt, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1102 */     long l = (GL.getICD()).glSecondaryColor3sv;
/* 1103 */     if (Checks.CHECKS) {
/* 1104 */       Checks.check(l);
/* 1105 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 1107 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 1116 */     long l = (GL.getICD()).glSecondaryColor3iv;
/* 1117 */     if (Checks.CHECKS) {
/* 1118 */       Checks.check(l);
/* 1119 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 1121 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1130 */     long l = (GL.getICD()).glSecondaryColor3fv;
/* 1131 */     if (Checks.CHECKS) {
/* 1132 */       Checks.check(l);
/* 1133 */       Checks.check(paramArrayOffloat, 3);
/*      */     } 
/* 1135 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1144 */     long l = (GL.getICD()).glSecondaryColor3dv;
/* 1145 */     if (Checks.CHECKS) {
/* 1146 */       Checks.check(l);
/* 1147 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 1149 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3usv(@NativeType("GLushort const *") short[] paramArrayOfshort) {
/* 1158 */     long l = (GL.getICD()).glSecondaryColor3usv;
/* 1159 */     if (Checks.CHECKS) {
/* 1160 */       Checks.check(l);
/* 1161 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 1163 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glSecondaryColor3uiv(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1172 */     long l = (GL.getICD()).glSecondaryColor3uiv;
/* 1173 */     if (Checks.CHECKS) {
/* 1174 */       Checks.check(l);
/* 1175 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 1177 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos2iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 1186 */     long l = (GL.getICD()).glWindowPos2iv;
/* 1187 */     if (Checks.CHECKS) {
/* 1188 */       Checks.check(l);
/* 1189 */       Checks.check(paramArrayOfint, 2);
/*      */     } 
/* 1191 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos2sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1200 */     long l = (GL.getICD()).glWindowPos2sv;
/* 1201 */     if (Checks.CHECKS) {
/* 1202 */       Checks.check(l);
/* 1203 */       Checks.check(paramArrayOfshort, 2);
/*      */     } 
/* 1205 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos2fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1214 */     long l = (GL.getICD()).glWindowPos2fv;
/* 1215 */     if (Checks.CHECKS) {
/* 1216 */       Checks.check(l);
/* 1217 */       Checks.check(paramArrayOffloat, 2);
/*      */     } 
/* 1219 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos2dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1228 */     long l = (GL.getICD()).glWindowPos2dv;
/* 1229 */     if (Checks.CHECKS) {
/* 1230 */       Checks.check(l);
/* 1231 */       Checks.check(paramArrayOfdouble, 2);
/*      */     } 
/* 1233 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos3iv(@NativeType("GLint const *") int[] paramArrayOfint) {
/* 1242 */     long l = (GL.getICD()).glWindowPos3iv;
/* 1243 */     if (Checks.CHECKS) {
/* 1244 */       Checks.check(l);
/* 1245 */       Checks.check(paramArrayOfint, 3);
/*      */     } 
/* 1247 */     JNI.callPV(paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos3sv(@NativeType("GLshort const *") short[] paramArrayOfshort) {
/* 1256 */     long l = (GL.getICD()).glWindowPos3sv;
/* 1257 */     if (Checks.CHECKS) {
/* 1258 */       Checks.check(l);
/* 1259 */       Checks.check(paramArrayOfshort, 3);
/*      */     } 
/* 1261 */     JNI.callPV(paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos3fv(@NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 1270 */     long l = (GL.getICD()).glWindowPos3fv;
/* 1271 */     if (Checks.CHECKS) {
/* 1272 */       Checks.check(l);
/* 1273 */       Checks.check(paramArrayOffloat, 3);
/*      */     } 
/* 1275 */     JNI.callPV(paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glWindowPos3dv(@NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 1284 */     long l = (GL.getICD()).glWindowPos3dv;
/* 1285 */     if (Checks.CHECKS) {
/* 1286 */       Checks.check(l);
/* 1287 */       Checks.check(paramArrayOfdouble, 3);
/*      */     } 
/* 1289 */     JNI.callPV(paramArrayOfdouble, l);
/*      */   }
/*      */   
/*      */   public static native void glFogCoordf(@NativeType("GLfloat") float paramFloat);
/*      */   
/*      */   public static native void glFogCoordd(@NativeType("GLdouble") double paramDouble);
/*      */   
/*      */   public static native void nglFogCoordfv(long paramLong);
/*      */   
/*      */   public static native void nglFogCoorddv(long paramLong);
/*      */   
/*      */   public static native void nglFogCoordPointer(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void glSecondaryColor3b(@NativeType("GLbyte") byte paramByte1, @NativeType("GLbyte") byte paramByte2, @NativeType("GLbyte") byte paramByte3);
/*      */   
/*      */   public static native void glSecondaryColor3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glSecondaryColor3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glSecondaryColor3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glSecondaryColor3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void glSecondaryColor3ub(@NativeType("GLubyte") byte paramByte1, @NativeType("GLubyte") byte paramByte2, @NativeType("GLubyte") byte paramByte3);
/*      */   
/*      */   public static native void glSecondaryColor3us(@NativeType("GLushort") short paramShort1, @NativeType("GLushort") short paramShort2, @NativeType("GLushort") short paramShort3);
/*      */   
/*      */   public static native void glSecondaryColor3ui(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void nglSecondaryColor3bv(long paramLong);
/*      */   
/*      */   public static native void nglSecondaryColor3sv(long paramLong);
/*      */   
/*      */   public static native void nglSecondaryColor3iv(long paramLong);
/*      */   
/*      */   public static native void nglSecondaryColor3fv(long paramLong);
/*      */   
/*      */   public static native void nglSecondaryColor3dv(long paramLong);
/*      */   
/*      */   public static native void nglSecondaryColor3ubv(long paramLong);
/*      */   
/*      */   public static native void nglSecondaryColor3usv(long paramLong);
/*      */   
/*      */   public static native void nglSecondaryColor3uiv(long paramLong);
/*      */   
/*      */   public static native void nglSecondaryColorPointer(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void glWindowPos2i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2);
/*      */   
/*      */   public static native void glWindowPos2s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2);
/*      */   
/*      */   public static native void glWindowPos2f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*      */   
/*      */   public static native void glWindowPos2d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*      */   
/*      */   public static native void nglWindowPos2iv(long paramLong);
/*      */   
/*      */   public static native void nglWindowPos2sv(long paramLong);
/*      */   
/*      */   public static native void nglWindowPos2fv(long paramLong);
/*      */   
/*      */   public static native void nglWindowPos2dv(long paramLong);
/*      */   
/*      */   public static native void glWindowPos3i(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3);
/*      */   
/*      */   public static native void glWindowPos3s(@NativeType("GLshort") short paramShort1, @NativeType("GLshort") short paramShort2, @NativeType("GLshort") short paramShort3);
/*      */   
/*      */   public static native void glWindowPos3f(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3);
/*      */   
/*      */   public static native void glWindowPos3d(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*      */   
/*      */   public static native void nglWindowPos3iv(long paramLong);
/*      */   
/*      */   public static native void nglWindowPos3sv(long paramLong);
/*      */   
/*      */   public static native void nglWindowPos3fv(long paramLong);
/*      */   
/*      */   public static native void nglWindowPos3dv(long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL14.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */