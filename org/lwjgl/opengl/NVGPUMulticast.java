/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVGPUMulticast
/*     */ {
/*     */   public static final int GL_PER_GPU_STORAGE_BIT_NV = 2048;
/*     */   public static final int GL_MULTICAST_GPUS_NV = 37562;
/*     */   public static final int GL_RENDER_GPU_MASK_NV = 38232;
/*     */   public static final int GL_PER_GPU_STORAGE_NV = 38216;
/*     */   public static final int GL_MULTICAST_PROGRAMMABLE_SAMPLE_LOCATION_NV = 38217;
/*     */   
/*     */   static {
/*  48 */     GL.initialize();
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
/*     */   protected NVGPUMulticast() {
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
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  82 */     nglMulticastBufferSubDataNV(paramInt1, paramInt2, paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  86 */     nglMulticastBufferSubDataNV(paramInt1, paramInt2, paramLong, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  90 */     nglMulticastBufferSubDataNV(paramInt1, paramInt2, paramLong, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  94 */     nglMulticastBufferSubDataNV(paramInt1, paramInt2, paramLong, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  98 */     nglMulticastBufferSubDataNV(paramInt1, paramInt2, paramLong, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glMulticastFramebufferSampleLocationsfvNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 118 */     nglMulticastFramebufferSampleLocationsfvNV(paramInt1, paramInt2, paramInt3, paramFloatBuffer.remaining() >> 1, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static void glMulticastGetQueryObjectivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 134 */     if (Checks.CHECKS) {
/* 135 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 137 */     nglMulticastGetQueryObjectivNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glMulticastGetQueryObjectiNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 142 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 144 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 145 */       nglMulticastGetQueryObjectivNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 146 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 148 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjectuivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 157 */     if (Checks.CHECKS) {
/* 158 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 160 */     nglMulticastGetQueryObjectuivNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glMulticastGetQueryObjectuiNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 165 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 167 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 168 */       nglMulticastGetQueryObjectuivNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 169 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 171 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjecti64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 180 */     if (Checks.CHECKS) {
/* 181 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 183 */     nglMulticastGetQueryObjecti64vNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glMulticastGetQueryObjecti64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 188 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 190 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 191 */       nglMulticastGetQueryObjecti64vNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(longBuffer));
/* 192 */       return longBuffer.get(0);
/*     */     } finally {
/* 194 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjectui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint64 *") LongBuffer paramLongBuffer) {
/* 203 */     if (Checks.CHECKS) {
/* 204 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 206 */     nglMulticastGetQueryObjectui64vNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glMulticastGetQueryObjectui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 211 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 213 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 214 */       nglMulticastGetQueryObjectui64vNV(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(longBuffer));
/* 215 */       return longBuffer.get(0);
/*     */     } finally {
/* 217 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("void const *") short[] paramArrayOfshort) {
/* 223 */     long l = (GL.getICD()).glMulticastBufferSubDataNV;
/* 224 */     if (Checks.CHECKS) {
/* 225 */       Checks.check(l);
/*     */     }
/* 227 */     JNI.callPPPV(paramInt1, paramInt2, paramLong, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("void const *") int[] paramArrayOfint) {
/* 232 */     long l = (GL.getICD()).glMulticastBufferSubDataNV;
/* 233 */     if (Checks.CHECKS) {
/* 234 */       Checks.check(l);
/*     */     }
/* 236 */     JNI.callPPPV(paramInt1, paramInt2, paramLong, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("void const *") float[] paramArrayOffloat) {
/* 241 */     long l = (GL.getICD()).glMulticastBufferSubDataNV;
/* 242 */     if (Checks.CHECKS) {
/* 243 */       Checks.check(l);
/*     */     }
/* 245 */     JNI.callPPPV(paramInt1, paramInt2, paramLong, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastBufferSubDataNV(@NativeType("GLbitfield") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLintptr") long paramLong, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 250 */     long l = (GL.getICD()).glMulticastBufferSubDataNV;
/* 251 */     if (Checks.CHECKS) {
/* 252 */       Checks.check(l);
/*     */     }
/* 254 */     JNI.callPPPV(paramInt1, paramInt2, paramLong, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastFramebufferSampleLocationsfvNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 259 */     long l = (GL.getICD()).glMulticastFramebufferSampleLocationsfvNV;
/* 260 */     if (Checks.CHECKS) {
/* 261 */       Checks.check(l);
/*     */     }
/* 263 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat.length >> 1, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjectivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 268 */     long l = (GL.getICD()).glMulticastGetQueryObjectivNV;
/* 269 */     if (Checks.CHECKS) {
/* 270 */       Checks.check(l);
/* 271 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 273 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjectuivNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 278 */     long l = (GL.getICD()).glMulticastGetQueryObjectuivNV;
/* 279 */     if (Checks.CHECKS) {
/* 280 */       Checks.check(l);
/* 281 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 283 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjecti64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 288 */     long l = (GL.getICD()).glMulticastGetQueryObjecti64vNV;
/* 289 */     if (Checks.CHECKS) {
/* 290 */       Checks.check(l);
/* 291 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 293 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMulticastGetQueryObjectui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint64 *") long[] paramArrayOflong) {
/* 298 */     long l = (GL.getICD()).glMulticastGetQueryObjectui64vNV;
/* 299 */     if (Checks.CHECKS) {
/* 300 */       Checks.check(l);
/* 301 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 303 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOflong, l);
/*     */   }
/*     */   
/*     */   public static native void glRenderGpuMaskNV(@NativeType("GLbitfield") int paramInt);
/*     */   
/*     */   public static native void nglMulticastBufferSubDataNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void glMulticastCopyBufferSubDataNV(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLintptr") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizeiptr") long paramLong3);
/*     */   
/*     */   public static native void glMulticastCopyImageSubDataNV(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLuint") int paramInt9, @NativeType("GLenum") int paramInt10, @NativeType("GLint") int paramInt11, @NativeType("GLint") int paramInt12, @NativeType("GLint") int paramInt13, @NativeType("GLint") int paramInt14, @NativeType("GLsizei") int paramInt15, @NativeType("GLsizei") int paramInt16, @NativeType("GLsizei") int paramInt17);
/*     */   
/*     */   public static native void glMulticastBlitFramebufferNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLbitfield") int paramInt11, @NativeType("GLenum") int paramInt12);
/*     */   
/*     */   public static native void nglMulticastFramebufferSampleLocationsfvNV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void glMulticastBarrierNV();
/*     */   
/*     */   public static native void glMulticastWaitSyncNV(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2);
/*     */   
/*     */   public static native void nglMulticastGetQueryObjectivNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglMulticastGetQueryObjectuivNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglMulticastGetQueryObjecti64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglMulticastGetQueryObjectui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVGPUMulticast.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */