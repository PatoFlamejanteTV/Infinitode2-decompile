/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
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
/*     */ public class EXTVertexAttrib64bit
/*     */ {
/*     */   public static final int GL_DOUBLE_VEC2_EXT = 36860;
/*     */   public static final int GL_DOUBLE_VEC3_EXT = 36861;
/*     */   public static final int GL_DOUBLE_VEC4_EXT = 36862;
/*     */   public static final int GL_DOUBLE_MAT2_EXT = 36678;
/*     */   public static final int GL_DOUBLE_MAT3_EXT = 36679;
/*     */   public static final int GL_DOUBLE_MAT4_EXT = 36680;
/*     */   public static final int GL_DOUBLE_MAT2x3_EXT = 36681;
/*     */   public static final int GL_DOUBLE_MAT2x4_EXT = 36682;
/*     */   public static final int GL_DOUBLE_MAT3x2_EXT = 36683;
/*     */   public static final int GL_DOUBLE_MAT3x4_EXT = 36684;
/*     */   public static final int GL_DOUBLE_MAT4x2_EXT = 36685;
/*     */   public static final int GL_DOUBLE_MAT4x3_EXT = 36686;
/*     */   
/*     */   static {
/*  46 */     GL.initialize();
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
/*     */   protected EXTVertexAttrib64bit() {
/*  64 */     throw new UnsupportedOperationException();
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
/*     */   public static void glVertexAttribL1dvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  88 */     if (Checks.CHECKS) {
/*  89 */       Checks.check(paramDoubleBuffer, 1);
/*     */     }
/*  91 */     nglVertexAttribL1dvEXT(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2dvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/*  99 */     if (Checks.CHECKS) {
/* 100 */       Checks.check(paramDoubleBuffer, 2);
/*     */     }
/* 102 */     nglVertexAttribL2dvEXT(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3dvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(paramDoubleBuffer, 3);
/*     */     }
/* 113 */     nglVertexAttribL3dvEXT(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4dvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") DoubleBuffer paramDoubleBuffer) {
/* 121 */     if (Checks.CHECKS) {
/* 122 */       Checks.check(paramDoubleBuffer, 4);
/*     */     }
/* 124 */     nglVertexAttribL4dvEXT(paramInt, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribLPointerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 132 */     nglVertexAttribLPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   
/*     */   public static void glVertexAttribLPointerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("void const *") long paramLong) {
/* 136 */     nglVertexAttribLPointerEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
/*     */   }
/*     */   
/*     */   public static void glVertexAttribLPointerEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 140 */     nglVertexAttribLPointerEXT(paramInt1, paramInt2, 5130, paramInt3, MemoryUtil.memAddress(paramDoubleBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLdvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") DoubleBuffer paramDoubleBuffer) {
/* 148 */     if (Checks.CHECKS) {
/* 149 */       Checks.check(paramDoubleBuffer, 4);
/*     */     }
/* 151 */     nglGetVertexAttribLdvEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glVertexArrayVertexAttribLOffsetEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLintptr") long paramLong) {
/* 169 */     ARBVertexAttrib64Bit.glVertexArrayVertexAttribLOffsetEXT(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL1dvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 174 */     long l = (GL.getICD()).glVertexAttribL1dvEXT;
/* 175 */     if (Checks.CHECKS) {
/* 176 */       Checks.check(l);
/* 177 */       Checks.check(paramArrayOfdouble, 1);
/*     */     } 
/* 179 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2dvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 184 */     long l = (GL.getICD()).glVertexAttribL2dvEXT;
/* 185 */     if (Checks.CHECKS) {
/* 186 */       Checks.check(l);
/* 187 */       Checks.check(paramArrayOfdouble, 2);
/*     */     } 
/* 189 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3dvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 194 */     long l = (GL.getICD()).glVertexAttribL3dvEXT;
/* 195 */     if (Checks.CHECKS) {
/* 196 */       Checks.check(l);
/* 197 */       Checks.check(paramArrayOfdouble, 3);
/*     */     } 
/* 199 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4dvEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble const *") double[] paramArrayOfdouble) {
/* 204 */     long l = (GL.getICD()).glVertexAttribL4dvEXT;
/* 205 */     if (Checks.CHECKS) {
/* 206 */       Checks.check(l);
/* 207 */       Checks.check(paramArrayOfdouble, 4);
/*     */     } 
/* 209 */     JNI.callPV(paramInt, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLdvEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLdouble *") double[] paramArrayOfdouble) {
/* 214 */     long l = (GL.getICD()).glGetVertexAttribLdvEXT;
/* 215 */     if (Checks.CHECKS) {
/* 216 */       Checks.check(l);
/* 217 */       Checks.check(paramArrayOfdouble, 4);
/*     */     } 
/* 219 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfdouble, l);
/*     */   }
/*     */   
/*     */   public static native void glVertexAttribL1dEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble);
/*     */   
/*     */   public static native void glVertexAttribL2dEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*     */   
/*     */   public static native void glVertexAttribL3dEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3);
/*     */   
/*     */   public static native void glVertexAttribL4dEXT(@NativeType("GLuint") int paramInt, @NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2, @NativeType("GLdouble") double paramDouble3, @NativeType("GLdouble") double paramDouble4);
/*     */   
/*     */   public static native void nglVertexAttribL1dvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL2dvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL3dvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL4dvEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribLPointerEXT(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribLdvEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTVertexAttrib64bit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */