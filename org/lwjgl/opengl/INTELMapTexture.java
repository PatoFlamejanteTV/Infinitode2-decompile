/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.APIUtil;
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
/*     */ public class INTELMapTexture
/*     */ {
/*     */   public static final int GL_TEXTURE_MEMORY_LAYOUT_INTEL = 33791;
/*     */   public static final int GL_LAYOUT_DEFAULT_INTEL = 0;
/*     */   public static final int GL_LAYOUT_LINEAR_INTEL = 1;
/*     */   public static final int GL_LAYOUT_LINEAR_CPU_CACHED_INTEL = 2;
/*     */   
/*     */   static {
/*  36 */     GL.initialize();
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
/*     */   protected INTELMapTexture() {
/*  48 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLbitfield") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2) {
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.check(paramIntBuffer1, 1);
/*  99 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/*     */     long l;
/* 102 */     return MemoryUtil.memByteBufferSafe(l = nglMapTexture2DINTEL(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2)), getStride(paramIntBuffer1) * GLChecks.getTexLevelParameteri(paramInt1, 3553, paramInt2, 4097));
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLbitfield") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2, ByteBuffer paramByteBuffer) {
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(paramIntBuffer1, 1);
/* 122 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/* 124 */     long l = nglMapTexture2DINTEL(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2));
/* 125 */     paramInt1 = getStride(paramIntBuffer1) * GLChecks.getTexLevelParameteri(paramInt1, 3553, paramInt2, 4097);
/* 126 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, paramInt1);
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLbitfield") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLenum *") IntBuffer paramIntBuffer2, long paramLong, ByteBuffer paramByteBuffer) {
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(paramIntBuffer1, 1);
/* 146 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/* 148 */     long l = nglMapTexture2DINTEL(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2));
/* 149 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, (int)paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLbitfield") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2) {
/* 156 */     long l1 = (GL.getICD()).glMapTexture2DINTEL;
/* 157 */     if (Checks.CHECKS) {
/* 158 */       Checks.check(l1);
/* 159 */       Checks.check(paramArrayOfint1, 1);
/* 160 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/*     */     long l2;
/* 163 */     return MemoryUtil.memByteBufferSafe(l2 = JNI.callPPP(paramInt1, paramInt2, paramInt3, paramArrayOfint1, paramArrayOfint2, l1), getStride(paramArrayOfint1) * GLChecks.getTexLevelParameteri(paramInt1, 3553, paramInt2, 4097));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLbitfield") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2, ByteBuffer paramByteBuffer) {
/* 170 */     long l1 = (GL.getICD()).glMapTexture2DINTEL;
/* 171 */     if (Checks.CHECKS) {
/* 172 */       Checks.check(l1);
/* 173 */       Checks.check(paramArrayOfint1, 1);
/* 174 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/* 176 */     long l2 = JNI.callPPP(paramInt1, paramInt2, paramInt3, paramArrayOfint1, paramArrayOfint2, l1);
/* 177 */     paramInt1 = getStride(paramArrayOfint1) * GLChecks.getTexLevelParameteri(paramInt1, 3553, paramInt2, 4097);
/* 178 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l2, paramInt1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapTexture2DINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLbitfield") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint1, @NativeType("GLenum *") int[] paramArrayOfint2, long paramLong, ByteBuffer paramByteBuffer) {
/* 185 */     long l1 = (GL.getICD()).glMapTexture2DINTEL;
/* 186 */     if (Checks.CHECKS) {
/* 187 */       Checks.check(l1);
/* 188 */       Checks.check(paramArrayOfint1, 1);
/* 189 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/* 191 */     long l2 = JNI.callPPP(paramInt1, paramInt2, paramInt3, paramArrayOfint1, paramArrayOfint2, l1);
/* 192 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l2, (int)paramLong);
/*     */   }
/*     */   
/*     */   private static int getStride(IntBuffer paramIntBuffer) {
/* 196 */     return paramIntBuffer.get(paramIntBuffer.position());
/*     */   }
/*     */   
/*     */   private static int getStride(int[] paramArrayOfint) {
/* 200 */     return paramArrayOfint[0];
/*     */   }
/*     */   
/*     */   public static native void glSyncTextureINTEL(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glUnmapTexture2DINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2);
/*     */   
/*     */   public static native long nglMapTexture2DINTEL(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\INTELMapTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */