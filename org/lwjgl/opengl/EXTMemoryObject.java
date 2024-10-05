/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
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
/*     */ public class EXTMemoryObject
/*     */ {
/*     */   public static final int GL_TEXTURE_TILING_EXT = 38272;
/*     */   public static final int GL_DEDICATED_MEMORY_OBJECT_EXT = 38273;
/*     */   public static final int GL_NUM_TILING_TYPES_EXT = 38274;
/*     */   public static final int GL_TILING_TYPES_EXT = 38275;
/*     */   public static final int GL_OPTIMAL_TILING_EXT = 38276;
/*     */   public static final int GL_LINEAR_TILING_EXT = 38277;
/*     */   public static final int GL_NUM_DEVICE_UUIDS_EXT = 38294;
/*     */   public static final int GL_DEVICE_UUID_EXT = 38295;
/*     */   public static final int GL_DRIVER_UUID_EXT = 38296;
/*     */   public static final int GL_UUID_SIZE_EXT = 16;
/*     */   
/*     */   static {
/*  44 */     GL.initialize();
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
/*     */   protected EXTMemoryObject() {
/*  83 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUnsignedBytevEXT(@NativeType("GLenum") int paramInt, @NativeType("GLubyte *") ByteBuffer paramByteBuffer) {
/*  91 */     nglGetUnsignedBytevEXT(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUnsignedBytei_vEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLubyte *") ByteBuffer paramByteBuffer) {
/*  99 */     nglGetUnsignedBytei_vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteMemoryObjectsEXT(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 107 */     nglDeleteMemoryObjectsEXT(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glDeleteMemoryObjectsEXT(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 111 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 113 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 114 */       nglDeleteMemoryObjectsEXT(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 116 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void glCreateMemoryObjectsEXT(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 130 */     nglCreateMemoryObjectsEXT(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glCreateMemoryObjectsEXT() {
/*     */     MemoryStack memoryStack;
/* 135 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 137 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 138 */       nglCreateMemoryObjectsEXT(1, MemoryUtil.memAddress(intBuffer));
/* 139 */       return intBuffer.get(0);
/*     */     } finally {
/* 141 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMemoryObjectParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 150 */     if (Checks.CHECKS) {
/* 151 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 153 */     nglMemoryObjectParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glMemoryObjectParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 157 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 159 */       IntBuffer intBuffer = memoryStack.ints(paramInt3);
/* 160 */       nglMemoryObjectParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 162 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetMemoryObjectParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 171 */     if (Checks.CHECKS) {
/* 172 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 174 */     nglGetMemoryObjectParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetMemoryObjectParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 179 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 181 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 182 */       nglGetMemoryObjectParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 183 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 185 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteMemoryObjectsEXT(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 239 */     long l = (GL.getICD()).glDeleteMemoryObjectsEXT;
/* 240 */     if (Checks.CHECKS) {
/* 241 */       Checks.check(l);
/*     */     }
/* 243 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCreateMemoryObjectsEXT(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 248 */     long l = (GL.getICD()).glCreateMemoryObjectsEXT;
/* 249 */     if (Checks.CHECKS) {
/* 250 */       Checks.check(l);
/*     */     }
/* 252 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMemoryObjectParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 257 */     long l = (GL.getICD()).glMemoryObjectParameterivEXT;
/* 258 */     if (Checks.CHECKS) {
/* 259 */       Checks.check(l);
/* 260 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 262 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetMemoryObjectParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 267 */     long l = (GL.getICD()).glGetMemoryObjectParameterivEXT;
/* 268 */     if (Checks.CHECKS) {
/* 269 */       Checks.check(l);
/* 270 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 272 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void nglGetUnsignedBytevEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetUnsignedBytei_vEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglDeleteMemoryObjectsEXT(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsMemoryObjectEXT(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglCreateMemoryObjectsEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglMemoryObjectParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetMemoryObjectParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glTexStorageMem2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTexStorageMem2DMultisampleEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt6, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTexStorageMem3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTexStorageMem3DMultisampleEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt7, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glBufferStorageMemEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizeiptr") long paramLong1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong2);
/*     */   
/*     */   public static native void glTextureStorageMem2DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTextureStorageMem2DMultisampleEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt6, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTextureStorageMem3DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTextureStorageMem3DMultisampleEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt7, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glNamedBufferStorageMemEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizeiptr") long paramLong1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong2);
/*     */   
/*     */   public static native void glTexStorageMem1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint64") long paramLong);
/*     */   
/*     */   public static native void glTextureStorageMem1DEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint64") long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTMemoryObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */