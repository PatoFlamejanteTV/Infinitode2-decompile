/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import org.lwjgl.system.NativeType;
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
/*     */ public class ARBVertexAttrib64Bit
/*     */ {
/*     */   public static final int GL_DOUBLE_VEC2 = 36860;
/*     */   public static final int GL_DOUBLE_VEC3 = 36861;
/*     */   public static final int GL_DOUBLE_VEC4 = 36862;
/*     */   public static final int GL_DOUBLE_MAT2 = 36678;
/*     */   public static final int GL_DOUBLE_MAT3 = 36679;
/*     */   public static final int GL_DOUBLE_MAT4 = 36680;
/*     */   public static final int GL_DOUBLE_MAT2x3 = 36681;
/*     */   public static final int GL_DOUBLE_MAT2x4 = 36682;
/*     */   public static final int GL_DOUBLE_MAT3x2 = 36683;
/*     */   public static final int GL_DOUBLE_MAT3x4 = 36684;
/*     */   public static final int GL_DOUBLE_MAT4x2 = 36685;
/*     */   public static final int GL_DOUBLE_MAT4x3 = 36686;
/*     */   
/*     */   static {
/*  42 */     GL.initialize();
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
/*     */   protected ARBVertexAttrib64Bit() {
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
/*     */   public static void glVertexAttribL1d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble) {
/*  72 */     GL41C.glVertexAttribL1d(paramInt, paramDouble);
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
/*     */   public static void glVertexAttribL2d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2) {
/*  85 */     GL41C.glVertexAttribL2d(paramInt, paramDouble1, paramDouble2);
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
/*     */   public static void glVertexAttribL3d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3) {
/*  99 */     GL41C.glVertexAttribL3d(paramInt, paramDouble1, paramDouble2, paramDouble3);
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
/*     */   public static void glVertexAttribL4d(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4) {
/* 114 */     GL41C.glVertexAttribL4d(paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribL1dv(int paramInt, long paramLong) {
/* 121 */     GL41C.nglVertexAttribL1dv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL1dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 131 */     GL41C.glVertexAttribL1dv(paramInt, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribL2dv(int paramInt, long paramLong) {
/* 138 */     GL41C.nglVertexAttribL2dv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 148 */     GL41C.glVertexAttribL2dv(paramInt, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribL3dv(int paramInt, long paramLong) {
/* 155 */     GL41C.nglVertexAttribL3dv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 165 */     GL41C.glVertexAttribL3dv(paramInt, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribL4dv(int paramInt, long paramLong) {
/* 172 */     GL41C.nglVertexAttribL4dv(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 182 */     GL41C.glVertexAttribL4dv(paramInt, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglVertexAttribLPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/* 193 */     GL41C.nglVertexAttribLPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*     */   public static void glVertexAttribLPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 208 */     GL41C.glVertexAttribLPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer);
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
/*     */   public static void glVertexAttribLPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") long paramLong) {
/* 223 */     GL41C.glVertexAttribLPointer(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*     */   public static void glVertexAttribLPointer(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 237 */     GL41C.glVertexAttribLPointer(paramInt1, paramInt2, paramInt3, paramDoubleBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetVertexAttribLdv(int paramInt1, int paramInt2, long paramLong) {
/* 244 */     GL41C.nglGetVertexAttribLdv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLdv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 255 */     GL41C.glGetVertexAttribLdv(paramInt1, paramInt2, paramDoubleBuffer);
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
/*     */   public static void glVertexAttribL1dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 276 */     GL41C.glVertexAttribL1dv(paramInt, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 281 */     GL41C.glVertexAttribL2dv(paramInt, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 286 */     GL41C.glVertexAttribL3dv(paramInt, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4dv(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 291 */     GL41C.glVertexAttribL4dv(paramInt, paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLdv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 296 */     GL41C.glGetVertexAttribLdv(paramInt1, paramInt2, paramArrayOfdouble);
/*     */   }
/*     */   
/*     */   public static native void glVertexArrayVertexAttribLOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLintptr") long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBVertexAttrib64Bit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */