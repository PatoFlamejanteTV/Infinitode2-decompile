/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
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
/*     */ public class AMDPerformanceMonitor
/*     */ {
/*     */   public static final int GL_COUNTER_TYPE_AMD = 35776;
/*     */   public static final int GL_COUNTER_RANGE_AMD = 35777;
/*     */   public static final int GL_UNSIGNED_INT64_AMD = 35778;
/*     */   public static final int GL_PERCENTAGE_AMD = 35779;
/*     */   public static final int GL_PERFMON_RESULT_AVAILABLE_AMD = 35780;
/*     */   public static final int GL_PERFMON_RESULT_SIZE_AMD = 35781;
/*     */   public static final int GL_PERFMON_RESULT_AMD = 35782;
/*     */   
/*     */   static {
/*  29 */     GL.initialize();
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
/*     */   protected AMDPerformanceMonitor() {
/*  48 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorGroupsAMD(@NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLuint *") IntBuffer paramIntBuffer2) {
/*  56 */     if (Checks.CHECKS) {
/*  57 */       Checks.checkSafe(paramIntBuffer1, 1);
/*     */     }
/*  59 */     nglGetPerfMonitorGroupsAMD(MemoryUtil.memAddressSafe(paramIntBuffer1), Checks.remainingSafe(paramIntBuffer2), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCountersAMD(@NativeType("GLuint") int paramInt, @NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2, @NativeType("GLuint *") IntBuffer paramIntBuffer3) {
/*  67 */     if (Checks.CHECKS) {
/*  68 */       Checks.check(paramIntBuffer1, 1);
/*  69 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/*  71 */     nglGetPerfMonitorCountersAMD(paramInt, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), paramIntBuffer3.remaining(), MemoryUtil.memAddress(paramIntBuffer3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorGroupStringAMD(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/*  79 */     if (Checks.CHECKS) {
/*  80 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/*  82 */     nglGetPerfMonitorGroupStringAMD(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterStringAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.checkSafe(paramIntBuffer, 1);
/*     */     }
/*  93 */     nglGetPerfMonitorCounterStringAMD(paramInt1, paramInt2, Checks.remainingSafe(paramByteBuffer), MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterInfoAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 101 */     if (Checks.CHECKS) {
/* 102 */       Checks.check(paramByteBuffer, 4);
/*     */     }
/* 104 */     nglGetPerfMonitorCounterInfoAMD(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */   
/*     */   public static void glGetPerfMonitorCounterInfoAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 108 */     if (Checks.CHECKS) {
/* 109 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 111 */     nglGetPerfMonitorCounterInfoAMD(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   
/*     */   public static void glGetPerfMonitorCounterInfoAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 115 */     if (Checks.CHECKS) {
/* 116 */       Checks.check(paramFloatBuffer, 1);
/*     */     }
/* 118 */     nglGetPerfMonitorCounterInfoAMD(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenPerfMonitorsAMD(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 126 */     nglGenPerfMonitorsAMD(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGenPerfMonitorsAMD() {
/*     */     MemoryStack memoryStack;
/* 131 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 133 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 134 */       nglGenPerfMonitorsAMD(1, MemoryUtil.memAddress(intBuffer));
/* 135 */       return intBuffer.get(0);
/*     */     } finally {
/* 137 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeletePerfMonitorsAMD(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 146 */     nglDeletePerfMonitorsAMD(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glDeletePerfMonitorsAMD(@NativeType("GLuint *") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 150 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 152 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 153 */       nglDeletePerfMonitorsAMD(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 155 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSelectPerfMonitorCountersAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 164 */     nglSelectPerfMonitorCountersAMD(paramInt1, paramBoolean, paramInt2, paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   public static void glGetPerfMonitorCounterDataAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 180 */     if (Checks.CHECKS) {
/* 181 */       Checks.checkSafe(paramIntBuffer2, 1);
/*     */     }
/* 183 */     nglGetPerfMonitorCounterDataAMD(paramInt1, paramInt2, paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddressSafe(paramIntBuffer2));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorGroupsAMD(@NativeType("GLint *") int[] paramArrayOfint1, @NativeType("GLuint *") int[] paramArrayOfint2) {
/* 188 */     long l = (GL.getICD()).glGetPerfMonitorGroupsAMD;
/* 189 */     if (Checks.CHECKS) {
/* 190 */       Checks.check(l);
/* 191 */       Checks.checkSafe(paramArrayOfint1, 1);
/*     */     } 
/* 193 */     JNI.callPPV(paramArrayOfint1, Checks.lengthSafe(paramArrayOfint2), paramArrayOfint2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCountersAMD(@NativeType("GLuint") int paramInt, @NativeType("GLint *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2, @NativeType("GLuint *") int[] paramArrayOfint3) {
/* 198 */     long l = (GL.getICD()).glGetPerfMonitorCountersAMD;
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.check(l);
/* 201 */       Checks.check(paramArrayOfint1, 1);
/* 202 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/* 204 */     JNI.callPPPV(paramInt, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3.length, paramArrayOfint3, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorGroupStringAMD(@NativeType("GLuint") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 209 */     long l = (GL.getICD()).glGetPerfMonitorGroupStringAMD;
/* 210 */     if (Checks.CHECKS) {
/* 211 */       Checks.check(l);
/* 212 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 214 */     JNI.callPPV(paramInt, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterStringAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 219 */     long l = (GL.getICD()).glGetPerfMonitorCounterStringAMD;
/* 220 */     if (Checks.CHECKS) {
/* 221 */       Checks.check(l);
/* 222 */       Checks.checkSafe(paramArrayOfint, 1);
/*     */     } 
/* 224 */     JNI.callPPV(paramInt1, paramInt2, Checks.remainingSafe(paramByteBuffer), paramArrayOfint, MemoryUtil.memAddressSafe(paramByteBuffer), l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterInfoAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") int[] paramArrayOfint) {
/* 229 */     long l = (GL.getICD()).glGetPerfMonitorCounterInfoAMD;
/* 230 */     if (Checks.CHECKS) {
/* 231 */       Checks.check(l);
/* 232 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 234 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterInfoAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void *") float[] paramArrayOffloat) {
/* 239 */     long l = (GL.getICD()).glGetPerfMonitorCounterInfoAMD;
/* 240 */     if (Checks.CHECKS) {
/* 241 */       Checks.check(l);
/* 242 */       Checks.check(paramArrayOffloat, 1);
/*     */     } 
/* 244 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenPerfMonitorsAMD(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 249 */     long l = (GL.getICD()).glGenPerfMonitorsAMD;
/* 250 */     if (Checks.CHECKS) {
/* 251 */       Checks.check(l);
/*     */     }
/* 253 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeletePerfMonitorsAMD(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 258 */     long l = (GL.getICD()).glDeletePerfMonitorsAMD;
/* 259 */     if (Checks.CHECKS) {
/* 260 */       Checks.check(l);
/*     */     }
/* 262 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSelectPerfMonitorCountersAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLuint") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 267 */     long l = (GL.getICD()).glSelectPerfMonitorCountersAMD;
/* 268 */     if (Checks.CHECKS) {
/* 269 */       Checks.check(l);
/*     */     }
/* 271 */     JNI.callPV(paramInt1, paramBoolean, paramInt2, paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterDataAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 276 */     long l = (GL.getICD()).glGetPerfMonitorCounterDataAMD;
/* 277 */     if (Checks.CHECKS) {
/* 278 */       Checks.check(l);
/* 279 */       Checks.checkSafe(paramArrayOfint2, 1);
/*     */     } 
/* 281 */     JNI.callPPV(paramInt1, paramInt2, paramArrayOfint1.length, paramArrayOfint1, paramArrayOfint2, l);
/*     */   }
/*     */   
/*     */   public static native void nglGetPerfMonitorGroupsAMD(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native void nglGetPerfMonitorCountersAMD(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3);
/*     */   
/*     */   public static native void nglGetPerfMonitorGroupStringAMD(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetPerfMonitorCounterStringAMD(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetPerfMonitorCounterInfoAMD(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGenPerfMonitorsAMD(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeletePerfMonitorsAMD(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglSelectPerfMonitorCountersAMD(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glBeginPerfMonitorAMD(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glEndPerfMonitorAMD(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglGetPerfMonitorCounterDataAMD(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\AMDPerformanceMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */