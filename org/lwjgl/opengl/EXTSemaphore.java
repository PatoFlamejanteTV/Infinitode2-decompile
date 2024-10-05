/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
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
/*     */ public class EXTSemaphore
/*     */ {
/*     */   public static final int GL_NUM_DEVICE_UUIDS_EXT = 38294;
/*     */   public static final int GL_DEVICE_UUID_EXT = 38295;
/*     */   public static final int GL_DRIVER_UUID_EXT = 38296;
/*     */   public static final int GL_UUID_SIZE_EXT = 16;
/*     */   public static final int GL_LAYOUT_GENERAL_EXT = 38285;
/*     */   public static final int GL_LAYOUT_COLOR_ATTACHMENT_EXT = 38286;
/*     */   public static final int GL_LAYOUT_DEPTH_STENCIL_ATTACHMENT_EXT = 38287;
/*     */   public static final int GL_LAYOUT_DEPTH_STENCIL_READ_ONLY_EXT = 38288;
/*     */   public static final int GL_LAYOUT_SHADER_READ_ONLY_EXT = 38289;
/*     */   public static final int GL_LAYOUT_TRANSFER_SRC_EXT = 38290;
/*     */   public static final int GL_LAYOUT_TRANSFER_DST_EXT = 38291;
/*     */   public static final int GL_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_EXT = 38192;
/*     */   public static final int GL_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_EXT = 38193;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected EXTSemaphore() {
/*  69 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUnsignedBytevEXT(int paramInt, long paramLong) {
/*  75 */     EXTMemoryObject.nglGetUnsignedBytevEXT(paramInt, paramLong);
/*     */   }
/*     */   
/*     */   public static void glGetUnsignedBytevEXT(@NativeType("GLenum") int paramInt, @NativeType("GLubyte *") ByteBuffer paramByteBuffer) {
/*  79 */     EXTMemoryObject.glGetUnsignedBytevEXT(paramInt, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUnsignedBytei_vEXT(int paramInt1, int paramInt2, long paramLong) {
/*  85 */     EXTMemoryObject.nglGetUnsignedBytei_vEXT(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */   
/*     */   public static void glGetUnsignedBytei_vEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLubyte *") ByteBuffer paramByteBuffer) {
/*  89 */     EXTMemoryObject.glGetUnsignedBytei_vEXT(paramInt1, paramInt2, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenSemaphoresEXT(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  97 */     nglGenSemaphoresEXT(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGenSemaphoresEXT() {
/*     */     MemoryStack memoryStack;
/* 102 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 104 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 105 */       nglGenSemaphoresEXT(1, MemoryUtil.memAddress(intBuffer));
/* 106 */       return intBuffer.get(0);
/*     */     } finally {
/* 108 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteSemaphoresEXT(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 117 */     nglDeleteSemaphoresEXT(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glDeleteSemaphoresEXT(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 121 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 123 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 124 */       nglDeleteSemaphoresEXT(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 126 */       memoryStack.setPointer(i);
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
/*     */   public static void glSemaphoreParameterui64vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 const *") LongBuffer paramLongBuffer) {
/* 140 */     if (Checks.CHECKS) {
/* 141 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 143 */     nglSemaphoreParameterui64vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   public static void glSemaphoreParameterui64EXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 const *") long paramLong) {
/*     */     MemoryStack memoryStack;
/* 147 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 149 */       LongBuffer longBuffer = memoryStack.longs(paramLong);
/* 150 */       nglSemaphoreParameterui64vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer)); return;
/*     */     } finally {
/* 152 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSemaphoreParameterui64vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") LongBuffer paramLongBuffer) {
/* 161 */     if (Checks.CHECKS) {
/* 162 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 164 */     nglGetSemaphoreParameterui64vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glGetSemaphoreParameterui64EXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 169 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 171 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 172 */       nglGetSemaphoreParameterui64vEXT(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 173 */       return longBuffer.get(0);
/*     */     } finally {
/* 175 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glWaitSemaphoreEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLuint const *") IntBuffer paramIntBuffer2, @NativeType("GLenum const *") IntBuffer paramIntBuffer3) {
/* 184 */     if (Checks.CHECKS) {
/* 185 */       Checks.check(paramIntBuffer3, paramIntBuffer2.remaining());
/*     */     }
/* 187 */     nglWaitSemaphoreEXT(paramInt, paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), paramIntBuffer2.remaining(), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSignalSemaphoreEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") IntBuffer paramIntBuffer1, @NativeType("GLuint const *") IntBuffer paramIntBuffer2, @NativeType("GLenum const *") IntBuffer paramIntBuffer3) {
/* 195 */     if (Checks.CHECKS) {
/* 196 */       Checks.check(paramIntBuffer3, paramIntBuffer2.remaining());
/*     */     }
/* 198 */     nglSignalSemaphoreEXT(paramInt, paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), paramIntBuffer2.remaining(), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenSemaphoresEXT(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 203 */     long l = (GL.getICD()).glGenSemaphoresEXT;
/* 204 */     if (Checks.CHECKS) {
/* 205 */       Checks.check(l);
/*     */     }
/* 207 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSemaphoresEXT(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 212 */     long l = (GL.getICD()).glDeleteSemaphoresEXT;
/* 213 */     if (Checks.CHECKS) {
/* 214 */       Checks.check(l);
/*     */     }
/* 216 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSemaphoreParameterui64vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 const *") long[] paramArrayOflong) {
/* 221 */     long l = (GL.getICD()).glSemaphoreParameterui64vEXT;
/* 222 */     if (Checks.CHECKS) {
/* 223 */       Checks.check(l);
/* 224 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 226 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSemaphoreParameterui64vEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64 *") long[] paramArrayOflong) {
/* 231 */     long l = (GL.getICD()).glGetSemaphoreParameterui64vEXT;
/* 232 */     if (Checks.CHECKS) {
/* 233 */       Checks.check(l);
/* 234 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 236 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWaitSemaphoreEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2, @NativeType("GLenum const *") int[] paramArrayOfint3) {
/* 241 */     long l = (GL.getICD()).glWaitSemaphoreEXT;
/* 242 */     if (Checks.CHECKS) {
/* 243 */       Checks.check(l);
/* 244 */       Checks.check(paramArrayOfint3, paramArrayOfint2.length);
/*     */     } 
/* 246 */     JNI.callPPPV(paramInt, paramArrayOfint1.length, paramArrayOfint1, paramArrayOfint2.length, paramArrayOfint2, paramArrayOfint3, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSignalSemaphoreEXT(@NativeType("GLuint") int paramInt, @NativeType("GLuint const *") int[] paramArrayOfint1, @NativeType("GLuint const *") int[] paramArrayOfint2, @NativeType("GLenum const *") int[] paramArrayOfint3) {
/* 251 */     long l = (GL.getICD()).glSignalSemaphoreEXT;
/* 252 */     if (Checks.CHECKS) {
/* 253 */       Checks.check(l);
/* 254 */       Checks.check(paramArrayOfint3, paramArrayOfint2.length);
/*     */     } 
/* 256 */     JNI.callPPPV(paramInt, paramArrayOfint1.length, paramArrayOfint1, paramArrayOfint2.length, paramArrayOfint2, paramArrayOfint3, l);
/*     */   }
/*     */   
/*     */   public static native void nglGenSemaphoresEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteSemaphoresEXT(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsSemaphoreEXT(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglSemaphoreParameterui64vEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetSemaphoreParameterui64vEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglWaitSemaphoreEXT(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nglSignalSemaphoreEXT(int paramInt1, int paramInt2, long paramLong1, int paramInt3, long paramLong2, long paramLong3);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTSemaphore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */