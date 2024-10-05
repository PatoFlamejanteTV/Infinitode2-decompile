/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBES2Compatibility
/*     */ {
/*     */   public static final int GL_SHADER_COMPILER = 36346;
/*     */   public static final int GL_SHADER_BINARY_FORMATS = 36344;
/*     */   public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345;
/*     */   public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347;
/*     */   public static final int GL_MAX_VARYING_VECTORS = 36348;
/*     */   public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 36349;
/*     */   public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 35738;
/*     */   public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 35739;
/*     */   
/*     */   static {
/*  22 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_FIXED = 5132;
/*     */ 
/*     */   
/*     */   public static final int GL_LOW_FLOAT = 36336;
/*     */ 
/*     */   
/*     */   public static final int GL_MEDIUM_FLOAT = 36337;
/*     */ 
/*     */   
/*     */   public static final int GL_HIGH_FLOAT = 36338;
/*     */ 
/*     */   
/*     */   public static final int GL_LOW_INT = 36339;
/*     */ 
/*     */   
/*     */   public static final int GL_MEDIUM_INT = 36340;
/*     */ 
/*     */   
/*     */   public static final int GL_HIGH_INT = 36341;
/*     */   
/*     */   public static final int GL_RGB565 = 36194;
/*     */ 
/*     */   
/*     */   protected ARBES2Compatibility() {
/*  51 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glReleaseShaderCompiler() {
/*  58 */     GL41C.glReleaseShaderCompiler();
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
/*     */   public static void nglShaderBinary(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3) {
/*  70 */     GL41C.nglShaderBinary(paramInt1, paramLong1, paramInt2, paramLong2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glShaderBinary(@NativeType("GLuint const *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  81 */     GL41C.glShaderBinary(paramIntBuffer, paramInt, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetShaderPrecisionFormat(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
/*  88 */     GL41C.nglGetShaderPrecisionFormat(paramInt1, paramInt2, paramLong1, paramLong2);
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
/*     */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 100 */     GL41C.glGetShaderPrecisionFormat(paramInt1, paramInt2, paramIntBuffer1, paramIntBuffer2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetShaderPrecisionFormat(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 112 */     return GL41C.glGetShaderPrecisionFormat(paramInt1, paramInt2, paramIntBuffer);
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
/*     */   public static void glDepthRangef(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2) {
/* 124 */     GL41C.glDepthRangef(paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glClearDepthf(@NativeType("GLfloat") float paramFloat) {
/* 135 */     GL41C.glClearDepthf(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glShaderBinary(@NativeType("GLuint const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 140 */     GL41C.glShaderBinary(paramArrayOfint, paramInt, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 145 */     GL41C.glGetShaderPrecisionFormat(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBES2Compatibility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */