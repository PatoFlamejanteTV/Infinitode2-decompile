/*     */ package org.lwjgl.opengl;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBOcclusionQuery
/*     */ {
/*     */   public static final int GL_SAMPLES_PASSED_ARB = 35092;
/*     */   public static final int GL_QUERY_COUNTER_BITS_ARB = 34916;
/*     */   public static final int GL_CURRENT_QUERY_ARB = 34917;
/*     */   public static final int GL_QUERY_RESULT_ARB = 34918;
/*     */   public static final int GL_QUERY_RESULT_AVAILABLE_ARB = 34919;
/*     */   
/*     */   static {
/*  61 */     GL.initialize();
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
/*     */   protected ARBOcclusionQuery() {
/*  77 */     throw new UnsupportedOperationException();
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
/*     */   public static void glGenQueriesARB(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  95 */     nglGenQueriesARB(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenQueriesARB() {
/*     */     MemoryStack memoryStack;
/* 101 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 103 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 104 */       nglGenQueriesARB(1, MemoryUtil.memAddress(intBuffer));
/* 105 */       return intBuffer.get(0);
/*     */     } finally {
/* 107 */       memoryStack.setPointer(i);
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
/*     */   public static void glDeleteQueriesARB(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 126 */     nglDeleteQueriesARB(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   
/*     */   public static void glDeleteQueriesARB(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 131 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 133 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 134 */       nglDeleteQueriesARB(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 136 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetQueryivARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 182 */     if (Checks.CHECKS) {
/* 183 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 185 */     nglGetQueryivARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryiARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 196 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 198 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 199 */       nglGetQueryivARB(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 200 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 202 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetQueryObjectivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 219 */     if (Checks.CHECKS) {
/* 220 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 222 */     nglGetQueryObjectivARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") long paramLong) {
/* 233 */     nglGetQueryObjectivARB(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryObjectiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 244 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 246 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 247 */       nglGetQueryObjectivARB(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 248 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 250 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetQueryObjectuivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 267 */     if (Checks.CHECKS) {
/* 268 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 270 */     nglGetQueryObjectuivARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") long paramLong) {
/* 281 */     nglGetQueryObjectuivARB(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetQueryObjectuiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 292 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 294 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 295 */       nglGetQueryObjectuivARB(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 296 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 298 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenQueriesARB(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 304 */     long l = (GL.getICD()).glGenQueriesARB;
/* 305 */     if (Checks.CHECKS) {
/* 306 */       Checks.check(l);
/*     */     }
/* 308 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteQueriesARB(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 313 */     long l = (GL.getICD()).glDeleteQueriesARB;
/* 314 */     if (Checks.CHECKS) {
/* 315 */       Checks.check(l);
/*     */     }
/* 317 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryivARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 322 */     long l = (GL.getICD()).glGetQueryivARB;
/* 323 */     if (Checks.CHECKS) {
/* 324 */       Checks.check(l);
/* 325 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 327 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 332 */     long l = (GL.getICD()).glGetQueryObjectivARB;
/* 333 */     if (Checks.CHECKS) {
/* 334 */       Checks.check(l);
/* 335 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 337 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetQueryObjectuivARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 342 */     long l = (GL.getICD()).glGetQueryObjectuivARB;
/* 343 */     if (Checks.CHECKS) {
/* 344 */       Checks.check(l);
/* 345 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 347 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void nglGenQueriesARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteQueriesARB(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsQueryARB(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glBeginQueryARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glEndQueryARB(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglGetQueryivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetQueryObjectivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetQueryObjectuivARB(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBOcclusionQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */