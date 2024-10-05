/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.LongBuffer;
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
/*     */ public class ARBTimerQuery
/*     */ {
/*     */   public static final int GL_TIME_ELAPSED = 35007;
/*     */   public static final int GL_TIMESTAMP = 36392;
/*     */   
/*     */   static {
/*  31 */     GL.initialize();
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
/*     */   protected ARBTimerQuery() {
/*  43 */     throw new UnsupportedOperationException();
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
/*     */   public static void glQueryCounter(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  55 */     GL33C.glQueryCounter(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetQueryObjecti64v(int paramInt1, int paramInt2, long paramLong) {
/*  62 */     GL33C.nglGetQueryObjecti64v(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/*  73 */     GL33C.glGetQueryObjecti64v(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long paramLong) {
/*  84 */     GL33C.glGetQueryObjecti64v(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetQueryObjecti64(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  95 */     return GL33C.glGetQueryObjecti64(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetQueryObjectui64v(int paramInt1, int paramInt2, long paramLong) {
/* 102 */     GL33C.nglGetQueryObjectui64v(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") LongBuffer paramLongBuffer) {
/* 113 */     GL33C.glGetQueryObjectui64v(paramInt1, paramInt2, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") long paramLong) {
/* 124 */     GL33C.glGetQueryObjectui64v(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetQueryObjectui64(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 135 */     return GL33C.glGetQueryObjectui64(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjecti64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 140 */     GL33C.glGetQueryObjecti64v(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectui64v(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") long[] paramArrayOflong) {
/* 145 */     GL33C.glGetQueryObjectui64v(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBTimerQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */