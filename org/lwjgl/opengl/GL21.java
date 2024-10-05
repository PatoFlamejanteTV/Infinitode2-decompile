/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GL21
/*     */   extends GL20
/*     */ {
/*     */   public static final int GL_CURRENT_RASTER_SECONDARY_COLOR = 33887;
/*     */   public static final int GL_FLOAT_MAT2x3 = 35685;
/*     */   public static final int GL_FLOAT_MAT2x4 = 35686;
/*     */   public static final int GL_FLOAT_MAT3x2 = 35687;
/*     */   public static final int GL_FLOAT_MAT3x4 = 35688;
/*     */   public static final int GL_FLOAT_MAT4x2 = 35689;
/*     */   public static final int GL_FLOAT_MAT4x3 = 35690;
/*     */   public static final int GL_PIXEL_PACK_BUFFER = 35051;
/*     */   public static final int GL_PIXEL_UNPACK_BUFFER = 35052;
/*     */   public static final int GL_PIXEL_PACK_BUFFER_BINDING = 35053;
/*     */   public static final int GL_PIXEL_UNPACK_BUFFER_BINDING = 35055;
/*     */   
/*     */   static {
/*  26 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_SRGB = 35904;
/*     */ 
/*     */   
/*     */   public static final int GL_SRGB8 = 35905;
/*     */ 
/*     */   
/*     */   public static final int GL_SRGB_ALPHA = 35906;
/*     */ 
/*     */   
/*     */   public static final int GL_SRGB8_ALPHA8 = 35907;
/*     */ 
/*     */   
/*     */   public static final int GL_SLUMINANCE_ALPHA = 35908;
/*     */ 
/*     */   
/*     */   public static final int GL_SLUMINANCE8_ALPHA8 = 35909;
/*     */ 
/*     */   
/*     */   public static final int GL_SLUMINANCE = 35910;
/*     */ 
/*     */   
/*     */   public static final int GL_SLUMINANCE8 = 35911;
/*     */ 
/*     */   
/*     */   public static final int GL_COMPRESSED_SRGB = 35912;
/*     */ 
/*     */   
/*     */   public static final int GL_COMPRESSED_SRGB_ALPHA = 35913;
/*     */ 
/*     */   
/*     */   public static final int GL_COMPRESSED_SLUMINANCE = 35914;
/*     */ 
/*     */   
/*     */   public static final int GL_COMPRESSED_SLUMINANCE_ALPHA = 35915;
/*     */ 
/*     */ 
/*     */   
/*     */   protected GL21() {
/*  69 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2x3fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/*  80 */     GL21C.nglUniformMatrix2x3fv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*     */   public static void glUniformMatrix2x3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/*  93 */     GL21C.glUniformMatrix2x3fv(paramInt, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3x2fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 104 */     GL21C.nglUniformMatrix3x2fv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*     */   public static void glUniformMatrix3x2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 117 */     GL21C.glUniformMatrix3x2fv(paramInt, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix2x4fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 128 */     GL21C.nglUniformMatrix2x4fv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*     */   public static void glUniformMatrix2x4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 141 */     GL21C.glUniformMatrix2x4fv(paramInt, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4x2fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 152 */     GL21C.nglUniformMatrix4x2fv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*     */   public static void glUniformMatrix4x2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 165 */     GL21C.glUniformMatrix4x2fv(paramInt, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix3x4fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 176 */     GL21C.nglUniformMatrix3x4fv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*     */   public static void glUniformMatrix3x4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 189 */     GL21C.glUniformMatrix3x4fv(paramInt, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformMatrix4x3fv(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong) {
/* 200 */     GL21C.nglUniformMatrix4x3fv(paramInt1, paramInt2, paramBoolean, paramLong);
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
/*     */   public static void glUniformMatrix4x3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 213 */     GL21C.glUniformMatrix4x3fv(paramInt, paramBoolean, paramFloatBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 222 */     GL21C.glUniformMatrix2x3fv(paramInt, paramBoolean, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 231 */     GL21C.glUniformMatrix3x2fv(paramInt, paramBoolean, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix2x4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 240 */     GL21C.glUniformMatrix2x4fv(paramInt, paramBoolean, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x2fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 249 */     GL21C.glUniformMatrix4x2fv(paramInt, paramBoolean, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix3x4fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 258 */     GL21C.glUniformMatrix3x4fv(paramInt, paramBoolean, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glUniformMatrix4x3fv(@NativeType("GLint") int paramInt, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 267 */     GL21C.glUniformMatrix4x3fv(paramInt, paramBoolean, paramArrayOffloat);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL21.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */