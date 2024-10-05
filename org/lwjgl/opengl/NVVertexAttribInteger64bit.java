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
/*     */ public class NVVertexAttribInteger64bit
/*     */ {
/*     */   public static final int GL_INT64_NV = 5134;
/*     */   public static final int GL_UNSIGNED_INT64_NV = 5135;
/*     */   
/*     */   static {
/*  30 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected NVVertexAttribInteger64bit() {
/*  38 */     throw new UnsupportedOperationException();
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
/*     */   public static void glVertexAttribL1i64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/*  62 */     if (Checks.CHECKS) {
/*  63 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/*  65 */     nglVertexAttribL1i64vNV(paramInt, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2i64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/*  73 */     if (Checks.CHECKS) {
/*  74 */       Checks.check(paramLongBuffer, 2);
/*     */     }
/*  76 */     nglVertexAttribL2i64vNV(paramInt, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3i64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/*  84 */     if (Checks.CHECKS) {
/*  85 */       Checks.check(paramLongBuffer, 3);
/*     */     }
/*  87 */     nglVertexAttribL3i64vNV(paramInt, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4i64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT const *") LongBuffer paramLongBuffer) {
/*  95 */     if (Checks.CHECKS) {
/*  96 */       Checks.check(paramLongBuffer, 4);
/*     */     }
/*  98 */     nglVertexAttribL4i64vNV(paramInt, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static void glVertexAttribL1ui64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 125 */     nglVertexAttribL1ui64vNV(paramInt, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2ui64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 133 */     if (Checks.CHECKS) {
/* 134 */       Checks.check(paramLongBuffer, 2);
/*     */     }
/* 136 */     nglVertexAttribL2ui64vNV(paramInt, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3ui64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(paramLongBuffer, 3);
/*     */     }
/* 147 */     nglVertexAttribL3ui64vNV(paramInt, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4ui64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT const *") LongBuffer paramLongBuffer) {
/* 155 */     if (Checks.CHECKS) {
/* 156 */       Checks.check(paramLongBuffer, 4);
/*     */     }
/* 158 */     nglVertexAttribL4ui64vNV(paramInt, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLi64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64EXT *") LongBuffer paramLongBuffer) {
/* 166 */     if (Checks.CHECKS) {
/* 167 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 169 */     nglGetVertexAttribLi64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glGetVertexAttribLi64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 174 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 176 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 177 */       nglGetVertexAttribLi64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 178 */       return longBuffer.get(0);
/*     */     } finally {
/* 180 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64EXT *") LongBuffer paramLongBuffer) {
/* 189 */     if (Checks.CHECKS) {
/* 190 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 192 */     nglGetVertexAttribLui64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static long glGetVertexAttribLui64NV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 197 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 199 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 200 */       nglGetVertexAttribLui64vNV(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 201 */       return longBuffer.get(0);
/*     */     } finally {
/* 203 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL1i64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 213 */     long l = (GL.getICD()).glVertexAttribL1i64vNV;
/* 214 */     if (Checks.CHECKS) {
/* 215 */       Checks.check(l);
/* 216 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 218 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2i64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 223 */     long l = (GL.getICD()).glVertexAttribL2i64vNV;
/* 224 */     if (Checks.CHECKS) {
/* 225 */       Checks.check(l);
/* 226 */       Checks.check(paramArrayOflong, 2);
/*     */     } 
/* 228 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3i64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 233 */     long l = (GL.getICD()).glVertexAttribL3i64vNV;
/* 234 */     if (Checks.CHECKS) {
/* 235 */       Checks.check(l);
/* 236 */       Checks.check(paramArrayOflong, 3);
/*     */     } 
/* 238 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4i64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT const *") long[] paramArrayOflong) {
/* 243 */     long l = (GL.getICD()).glVertexAttribL4i64vNV;
/* 244 */     if (Checks.CHECKS) {
/* 245 */       Checks.check(l);
/* 246 */       Checks.check(paramArrayOflong, 4);
/*     */     } 
/* 248 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL1ui64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 253 */     long l = (GL.getICD()).glVertexAttribL1ui64vNV;
/* 254 */     if (Checks.CHECKS) {
/* 255 */       Checks.check(l);
/* 256 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 258 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL2ui64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 263 */     long l = (GL.getICD()).glVertexAttribL2ui64vNV;
/* 264 */     if (Checks.CHECKS) {
/* 265 */       Checks.check(l);
/* 266 */       Checks.check(paramArrayOflong, 2);
/*     */     } 
/* 268 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL3ui64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 273 */     long l = (GL.getICD()).glVertexAttribL3ui64vNV;
/* 274 */     if (Checks.CHECKS) {
/* 275 */       Checks.check(l);
/* 276 */       Checks.check(paramArrayOflong, 3);
/*     */     } 
/* 278 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribL4ui64vNV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT const *") long[] paramArrayOflong) {
/* 283 */     long l = (GL.getICD()).glVertexAttribL4ui64vNV;
/* 284 */     if (Checks.CHECKS) {
/* 285 */       Checks.check(l);
/* 286 */       Checks.check(paramArrayOflong, 4);
/*     */     } 
/* 288 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLi64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64EXT *") long[] paramArrayOflong) {
/* 293 */     long l = (GL.getICD()).glGetVertexAttribLi64vNV;
/* 294 */     if (Checks.CHECKS) {
/* 295 */       Checks.check(l);
/* 296 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 298 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetVertexAttribLui64vNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint64EXT *") long[] paramArrayOflong) {
/* 303 */     long l = (GL.getICD()).glGetVertexAttribLui64vNV;
/* 304 */     if (Checks.CHECKS) {
/* 305 */       Checks.check(l);
/* 306 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 308 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */   
/*     */   public static native void glVertexAttribL1i64NV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT") long paramLong);
/*     */   
/*     */   public static native void glVertexAttribL2i64NV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glVertexAttribL3i64NV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glVertexAttribL4i64NV(@NativeType("GLuint") int paramInt, @NativeType("GLint64EXT") long paramLong1, @NativeType("GLint64EXT") long paramLong2, @NativeType("GLint64EXT") long paramLong3, @NativeType("GLint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglVertexAttribL1i64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL2i64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL3i64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL4i64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glVertexAttribL1ui64NV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT") long paramLong);
/*     */   
/*     */   public static native void glVertexAttribL2ui64NV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2);
/*     */   
/*     */   public static native void glVertexAttribL3ui64NV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3);
/*     */   
/*     */   public static native void glVertexAttribL4ui64NV(@NativeType("GLuint") int paramInt, @NativeType("GLuint64EXT") long paramLong1, @NativeType("GLuint64EXT") long paramLong2, @NativeType("GLuint64EXT") long paramLong3, @NativeType("GLuint64EXT") long paramLong4);
/*     */   
/*     */   public static native void nglVertexAttribL1ui64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL2ui64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL3ui64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribL4ui64vNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribLi64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetVertexAttribLui64vNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glVertexAttribLFormatNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVVertexAttribInteger64bit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */