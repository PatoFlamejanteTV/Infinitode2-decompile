/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
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
/*     */ public class ARBSync
/*     */ {
/*     */   public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137;
/*     */   public static final int GL_OBJECT_TYPE = 37138;
/*     */   public static final int GL_SYNC_CONDITION = 37139;
/*     */   public static final int GL_SYNC_STATUS = 37140;
/*     */   public static final int GL_SYNC_FLAGS = 37141;
/*     */   public static final int GL_SYNC_FENCE = 37142;
/*     */   public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143;
/*     */   public static final int GL_UNSIGNALED = 37144;
/*     */   public static final int GL_SIGNALED = 37145;
/*     */   public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1;
/*     */   public static final long GL_TIMEOUT_IGNORED = -1L;
/*     */   public static final int GL_ALREADY_SIGNALED = 37146;
/*     */   public static final int GL_TIMEOUT_EXPIRED = 37147;
/*     */   public static final int GL_CONDITION_SATISFIED = 37148;
/*     */   public static final int GL_WAIT_FAILED = 37149;
/*     */   
/*     */   static {
/*  33 */     GL.initialize();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBSync() {
/*  70 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("GLsync")
/*     */   public static long glFenceSync(@NativeType("GLenum") int paramInt1, @NativeType("GLbitfield") int paramInt2) {
/*  84 */     return GL32C.glFenceSync(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean nglIsSync(long paramLong) {
/*  91 */     return GL32C.nglIsSync(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsSync(@NativeType("GLsync") long paramLong) {
/* 101 */     return GL32C.glIsSync(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteSync(long paramLong) {
/* 108 */     GL32C.nglDeleteSync(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteSync(@NativeType("GLsync") long paramLong) {
/* 117 */     GL32C.glDeleteSync(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglClientWaitSync(long paramLong1, int paramInt, long paramLong2) {
/* 124 */     return GL32C.nglClientWaitSync(paramLong1, paramInt, paramLong2);
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
/*     */   @NativeType("GLenum")
/*     */   public static int glClientWaitSync(@NativeType("GLsync") long paramLong1, @NativeType("GLbitfield") int paramInt, @NativeType("GLuint64") long paramLong2) {
/* 146 */     return GL32C.glClientWaitSync(paramLong1, paramInt, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglWaitSync(long paramLong1, int paramInt, long paramLong2) {
/* 153 */     GL32C.nglWaitSync(paramLong1, paramInt, paramLong2);
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
/*     */   public static void glWaitSync(@NativeType("GLsync") long paramLong1, @NativeType("GLbitfield") int paramInt, @NativeType("GLuint64") long paramLong2) {
/* 170 */     GL32C.glWaitSync(paramLong1, paramInt, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetInteger64v(int paramInt, long paramLong) {
/* 177 */     GL32C.nglGetInteger64v(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int paramInt, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 187 */     GL32C.glGetInteger64v(paramInt, paramLongBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetInteger64(@NativeType("GLenum") int paramInt) {
/* 197 */     return GL32C.glGetInteger64(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSynciv(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3) {
/* 208 */     GL32C.nglGetSynciv(paramLong1, paramInt1, paramInt2, paramLong2, paramLong3);
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
/*     */   public static void glGetSynciv(@NativeType("GLsync") long paramLong, @NativeType("GLenum") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 220 */     GL32C.glGetSynciv(paramLong, paramInt, paramIntBuffer1, paramIntBuffer2);
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
/*     */   public static int glGetSynci(@NativeType("GLsync") long paramLong, @NativeType("GLenum") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer) {
/* 232 */     return GL32C.glGetSynci(paramLong, paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int paramInt, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 237 */     GL32C.glGetInteger64v(paramInt, paramArrayOflong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSynciv(@NativeType("GLsync") long paramLong, @NativeType("GLenum") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 242 */     GL32C.glGetSynciv(paramLong, paramInt, paramArrayOfint1, paramArrayOfint2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBSync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */