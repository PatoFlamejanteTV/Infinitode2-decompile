/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBMatrixPalette
/*     */ {
/*     */   public static final int GL_MATRIX_PALETTE_ARB = 34880;
/*     */   public static final int GL_MAX_MATRIX_PALETTE_STACK_DEPTH_ARB = 34881;
/*     */   public static final int GL_MAX_PALETTE_MATRICES_ARB = 34882;
/*     */   public static final int GL_CURRENT_PALETTE_MATRIX_ARB = 34883;
/*     */   public static final int GL_MATRIX_INDEX_ARRAY_ARB = 34884;
/*     */   public static final int GL_CURRENT_MATRIX_INDEX_ARB = 34885;
/*     */   public static final int GL_MATRIX_INDEX_ARRAY_SIZE_ARB = 34886;
/*     */   public static final int GL_MATRIX_INDEX_ARRAY_TYPE_ARB = 34887;
/*     */   public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_ARB = 34888;
/*     */   public static final int GL_MATRIX_INDEX_ARRAY_POINTER_ARB = 34889;
/*     */   
/*     */   static {
/*  30 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBMatrixPalette() {
/*  60 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexuivARB(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  87 */     nglMatrixIndexuivARB(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexubvARB(@NativeType("GLubyte *") ByteBuffer paramByteBuffer) {
/* 105 */     nglMatrixIndexubvARB(paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexusvARB(@NativeType("GLushort *") ShortBuffer paramShortBuffer) {
/* 123 */     nglMatrixIndexusvARB(paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 142 */     nglMatrixIndexPointerARB(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") long paramLong) {
/* 152 */     nglMatrixIndexPointerARB(paramInt1, paramInt2, paramInt3, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 161 */     nglMatrixIndexPointerARB(paramInt1, 5121, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 170 */     nglMatrixIndexPointerARB(paramInt1, 5123, paramInt2, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexPointerARB(@NativeType("GLint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 179 */     nglMatrixIndexPointerARB(paramInt1, 5125, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexuivARB(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 184 */     long l = (GL.getICD()).glMatrixIndexuivARB;
/* 185 */     if (Checks.CHECKS) {
/* 186 */       Checks.check(l);
/*     */     }
/* 188 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMatrixIndexusvARB(@NativeType("GLushort *") short[] paramArrayOfshort) {
/* 193 */     long l = (GL.getICD()).glMatrixIndexusvARB;
/* 194 */     if (Checks.CHECKS) {
/* 195 */       Checks.check(l);
/*     */     }
/* 197 */     JNI.callPV(paramArrayOfshort.length, paramArrayOfshort, l);
/*     */   }
/*     */   
/*     */   public static native void glCurrentPaletteMatrixARB(@NativeType("GLint") int paramInt);
/*     */   
/*     */   public static native void nglMatrixIndexuivARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMatrixIndexubvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMatrixIndexusvARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMatrixIndexPointerARB(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBMatrixPalette.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */