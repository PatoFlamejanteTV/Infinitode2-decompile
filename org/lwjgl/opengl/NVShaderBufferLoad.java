/*     */ package org.lwjgl.opengl;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVShaderBufferLoad
/*     */ {
/*     */   public static final int GL_BUFFER_GPU_ADDRESS_NV = 36637;
/*     */   public static final int GL_GPU_ADDRESS_NV = 36660;
/*     */   public static final int GL_MAX_SHADER_BUFFER_ADDRESS_NV = 36661;
/*     */   
/*     */   static {
/*  92 */     GL.initialize();
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
/*     */   protected NVShaderBufferLoad() {
/* 104 */     throw new UnsupportedOperationException();
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
/*     */   public static void glGetBufferParameterui64vNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64EXT *") LongBuffer paramLongBuffer) {
/* 138 */     if (Checks.CHECKS) {
/* 139 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 141 */     nglGetBufferParameterui64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glGetBufferParameterui64NV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 146 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 148 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 149 */       nglGetBufferParameterui64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 150 */       return longBuffer.get(0);
/*     */     } finally {
/* 152 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetNamedBufferParameterui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64EXT *") LongBuffer paramLongBuffer) {
/* 161 */     if (Checks.CHECKS) {
/* 162 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 164 */     nglGetNamedBufferParameterui64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glGetNamedBufferParameterui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 169 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 171 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 172 */       nglGetNamedBufferParameterui64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
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
/*     */   public static void glGetIntegerui64vNV(@NativeType("GLenum") int paramInt, @NativeType("GLuint64EXT *") LongBuffer paramLongBuffer) {
/* 184 */     if (Checks.CHECKS) {
/* 185 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 187 */     nglGetIntegerui64vNV(paramInt, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glGetIntegerui64NV(@NativeType("GLenum") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 192 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 194 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 195 */       nglGetIntegerui64vNV(paramInt, MemoryUtil.memAddress(longBuffer));
/* 196 */       return longBuffer.get(0);
/*     */     } finally {
/* 198 */       memoryStack.setPointer(i);
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
/*     */   public static void glUniformui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 211 */     nglUniformui64vNV(paramInt, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT *") LongBuffer paramLongBuffer) {
/* 219 */     if (Checks.CHECKS) {
/* 220 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 222 */     nglGetUniformui64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glGetUniformui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 227 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 229 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 230 */       nglGetUniformui64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 231 */       return longBuffer.get(0);
/*     */     } finally {
/* 233 */       memoryStack.setPointer(i);
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
/*     */   public static void glProgramUniformui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 246 */     nglProgramUniformui64vNV(paramInt1, paramInt2, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameterui64vNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64EXT *") long[] paramArrayOflong) {
/* 251 */     long l = (GL.getICD()).glGetBufferParameterui64vNV;
/* 252 */     if (Checks.CHECKS) {
/* 253 */       Checks.check(l);
/* 254 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 256 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedBufferParameterui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64EXT *") long[] paramArrayOflong) {
/* 261 */     long l = (GL.getICD()).glGetNamedBufferParameterui64vNV;
/* 262 */     if (Checks.CHECKS) {
/* 263 */       Checks.check(l);
/* 264 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 266 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetIntegerui64vNV(@NativeType("GLenum") int paramInt, @NativeType("GLuint64EXT *") long[] paramArrayOflong) {
/* 271 */     long l = (GL.getICD()).glGetIntegerui64vNV;
/* 272 */     if (Checks.CHECKS) {
/* 273 */       Checks.check(l);
/* 274 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 276 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformui64vNV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 281 */     long l = (GL.getICD()).glUniformui64vNV;
/* 282 */     if (Checks.CHECKS) {
/* 283 */       Checks.check(l);
/*     */     }
/* 285 */     JNI.callPV(paramInt, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT *") long[] paramArrayOflong) {
/* 290 */     long l = (GL.getICD()).glGetUniformui64vNV;
/* 291 */     if (Checks.CHECKS) {
/* 292 */       Checks.check(l);
/* 293 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 295 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glProgramUniformui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 300 */     long l = (GL.getICD()).glProgramUniformui64vNV;
/* 301 */     if (Checks.CHECKS) {
/* 302 */       Checks.check(l);
/*     */     }
/* 304 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */   
/*     */   public static native void glMakeBufferResidentNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*     */   
/*     */   public static native void glMakeBufferNonResidentNV(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsBufferResidentNV(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glMakeNamedBufferResidentNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*     */   
/*     */   public static native void glMakeNamedBufferNonResidentNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsNamedBufferResidentNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglGetBufferParameterui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetNamedBufferParameterui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetIntegerui64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glUniformui64NV(@NativeType("GLint") int paramInt, @NativeType("GLuint64EXT") long paramLong);
/*     */   
/*     */   public static native void nglUniformui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetUniformui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glProgramUniformui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLuint64EXT") long paramLong);
/*     */   
/*     */   public static native void nglProgramUniformui64vNV(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVShaderBufferLoad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */