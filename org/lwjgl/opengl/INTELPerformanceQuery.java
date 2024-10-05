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
/*     */ public class INTELPerformanceQuery
/*     */ {
/*     */   public static final int GL_PERFQUERY_SINGLE_CONTEXT_INTEL = 0;
/*     */   public static final int GL_PERFQUERY_GLOBAL_CONTEXT_INTEL = 1;
/*     */   public static final int GL_PERFQUERY_WAIT_INTEL = 33787;
/*     */   public static final int GL_PERFQUERY_FLUSH_INTEL = 33786;
/*     */   public static final int GL_PERFQUERY_DONOT_FLUSH_INTEL = 33785;
/*     */   public static final int GL_PERFQUERY_COUNTER_EVENT_INTEL = 38128;
/*     */   public static final int GL_PERFQUERY_COUNTER_DURATION_NORM_INTEL = 38129;
/*     */   public static final int GL_PERFQUERY_COUNTER_DURATION_RAW_INTEL = 38130;
/*     */   public static final int GL_PERFQUERY_COUNTER_THROUGHPUT_INTEL = 38131;
/*     */   public static final int GL_PERFQUERY_COUNTER_RAW_INTEL = 38132;
/*     */   public static final int GL_PERFQUERY_COUNTER_TIMESTAMP_INTEL = 38133;
/*     */   public static final int GL_PERFQUERY_COUNTER_DATA_UINT32_INTEL = 38136;
/*     */   public static final int GL_PERFQUERY_COUNTER_DATA_UINT64_INTEL = 38137;
/*     */   public static final int GL_PERFQUERY_COUNTER_DATA_FLOAT_INTEL = 38138;
/*     */   public static final int GL_PERFQUERY_COUNTER_DATA_DOUBLE_INTEL = 38139;
/*     */   public static final int GL_PERFQUERY_COUNTER_DATA_BOOL32_INTEL = 38140;
/*     */   public static final int GL_PERFQUERY_QUERY_NAME_LENGTH_MAX_INTEL = 38141;
/*     */   public static final int GL_PERFQUERY_COUNTER_NAME_LENGTH_MAX_INTEL = 38142;
/*     */   public static final int GL_PERFQUERY_COUNTER_DESC_LENGTH_MAX_INTEL = 38143;
/*     */   public static final int GL_PERFQUERY_GPA_EXTENDED_COUNTERS_INTEL = 38144;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected INTELPerformanceQuery() {
/*  88 */     throw new UnsupportedOperationException();
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
/*     */   public static void glCreatePerfQueryINTEL(@NativeType("GLuint") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 100 */     if (Checks.CHECKS) {
/* 101 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 103 */     nglCreatePerfQueryINTEL(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glCreatePerfQueryINTEL(@NativeType("GLuint") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 108 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 110 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 111 */       nglCreatePerfQueryINTEL(paramInt, MemoryUtil.memAddress(intBuffer));
/* 112 */       paramInt = intBuffer.get(0); return paramInt;
/*     */     } finally {
/* 114 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetFirstPerfQueryIdINTEL(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 134 */     nglGetFirstPerfQueryIdINTEL(MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetFirstPerfQueryIdINTEL() {
/*     */     MemoryStack memoryStack;
/* 139 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*     */       IntBuffer intBuffer;
/* 142 */       nglGetFirstPerfQueryIdINTEL(MemoryUtil.memAddress(intBuffer = memoryStack.callocInt(1)));
/* 143 */       return intBuffer.get(0);
/*     */     } finally {
/* 145 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetNextPerfQueryIdINTEL(@NativeType("GLuint") int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 154 */     if (Checks.CHECKS) {
/* 155 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 157 */     nglGetNextPerfQueryIdINTEL(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetNextPerfQueryIdINTEL(@NativeType("GLuint") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 162 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 164 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 165 */       nglGetNextPerfQueryIdINTEL(paramInt, MemoryUtil.memAddress(intBuffer));
/* 166 */       paramInt = intBuffer.get(0); return paramInt;
/*     */     } finally {
/* 168 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfCounterInfoINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar *") ByteBuffer paramByteBuffer1, @NativeType("GLchar *") ByteBuffer paramByteBuffer2, @NativeType("GLuint *") IntBuffer paramIntBuffer1, @NativeType("GLuint *") IntBuffer paramIntBuffer2, @NativeType("GLuint *") IntBuffer paramIntBuffer3, @NativeType("GLuint *") IntBuffer paramIntBuffer4, @NativeType("GLuint64 *") LongBuffer paramLongBuffer) {
/* 177 */     if (Checks.CHECKS) {
/* 178 */       Checks.check(paramIntBuffer1, 1);
/* 179 */       Checks.check(paramIntBuffer2, 1);
/* 180 */       Checks.check(paramIntBuffer3, 1);
/* 181 */       Checks.check(paramIntBuffer4, 1);
/* 182 */       Checks.check(paramLongBuffer, 1);
/*     */     } 
/* 184 */     nglGetPerfCounterInfoINTEL(paramInt1, paramInt2, paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer2.remaining(), MemoryUtil.memAddress(paramByteBuffer2), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramIntBuffer4), MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryDataINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("void *") ByteBuffer paramByteBuffer, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 192 */     if (Checks.CHECKS) {
/* 193 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 195 */     nglGetPerfQueryDataINTEL(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryIdByNameINTEL(@NativeType("GLchar *") ByteBuffer paramByteBuffer, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 203 */     if (Checks.CHECKS) {
/* 204 */       Checks.checkNT1(paramByteBuffer);
/* 205 */       Checks.check(paramIntBuffer, 1);
/*     */     } 
/* 207 */     nglGetPerfQueryIdByNameINTEL(MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   
/*     */   public static void glGetPerfQueryIdByNameINTEL(@NativeType("GLchar *") CharSequence paramCharSequence, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 211 */     if (Checks.CHECKS)
/* 212 */       Checks.check(paramIntBuffer, 1); 
/*     */     MemoryStack memoryStack;
/* 214 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 216 */       memoryStack.nASCII(paramCharSequence, true);
/*     */       long l;
/* 218 */       nglGetPerfQueryIdByNameINTEL(l = memoryStack.getPointerAddress(), MemoryUtil.memAddress(paramIntBuffer)); return;
/*     */     } finally {
/* 220 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetPerfQueryIdByNameINTEL(@NativeType("GLchar *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 226 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 228 */       memoryStack.nASCII(paramCharSequence, true);
/* 229 */       long l = memoryStack.getPointerAddress();
/* 230 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 231 */       nglGetPerfQueryIdByNameINTEL(l, MemoryUtil.memAddress(intBuffer));
/* 232 */       return intBuffer.get(0);
/*     */     } finally {
/* 234 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryInfoINTEL(@NativeType("GLuint") int paramInt, @NativeType("GLchar *") ByteBuffer paramByteBuffer, @NativeType("GLuint *") IntBuffer paramIntBuffer1, @NativeType("GLuint *") IntBuffer paramIntBuffer2, @NativeType("GLuint *") IntBuffer paramIntBuffer3, @NativeType("GLuint *") IntBuffer paramIntBuffer4) {
/* 243 */     if (Checks.CHECKS) {
/* 244 */       Checks.check(paramIntBuffer1, 1);
/* 245 */       Checks.check(paramIntBuffer2, 1);
/* 246 */       Checks.check(paramIntBuffer3, 1);
/* 247 */       Checks.check(paramIntBuffer4, 1);
/*     */     } 
/* 249 */     nglGetPerfQueryInfoINTEL(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramIntBuffer4));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCreatePerfQueryINTEL(@NativeType("GLuint") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 254 */     long l = (GL.getICD()).glCreatePerfQueryINTEL;
/* 255 */     if (Checks.CHECKS) {
/* 256 */       Checks.check(l);
/* 257 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 259 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFirstPerfQueryIdINTEL(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 264 */     long l = (GL.getICD()).glGetFirstPerfQueryIdINTEL;
/* 265 */     if (Checks.CHECKS) {
/* 266 */       Checks.check(l);
/* 267 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 269 */     JNI.callPV(paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNextPerfQueryIdINTEL(@NativeType("GLuint") int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 274 */     long l = (GL.getICD()).glGetNextPerfQueryIdINTEL;
/* 275 */     if (Checks.CHECKS) {
/* 276 */       Checks.check(l);
/* 277 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 279 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfCounterInfoINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar *") ByteBuffer paramByteBuffer1, @NativeType("GLchar *") ByteBuffer paramByteBuffer2, @NativeType("GLuint *") int[] paramArrayOfint1, @NativeType("GLuint *") int[] paramArrayOfint2, @NativeType("GLuint *") int[] paramArrayOfint3, @NativeType("GLuint *") int[] paramArrayOfint4, @NativeType("GLuint64 *") long[] paramArrayOflong) {
/* 284 */     long l = (GL.getICD()).glGetPerfCounterInfoINTEL;
/* 285 */     if (Checks.CHECKS) {
/* 286 */       Checks.check(l);
/* 287 */       Checks.check(paramArrayOfint1, 1);
/* 288 */       Checks.check(paramArrayOfint2, 1);
/* 289 */       Checks.check(paramArrayOfint3, 1);
/* 290 */       Checks.check(paramArrayOfint4, 1);
/* 291 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 293 */     JNI.callPPPPPPPV(paramInt1, paramInt2, paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer2.remaining(), MemoryUtil.memAddress(paramByteBuffer2), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryDataINTEL(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("void *") ByteBuffer paramByteBuffer, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 298 */     long l = (GL.getICD()).glGetPerfQueryDataINTEL;
/* 299 */     if (Checks.CHECKS) {
/* 300 */       Checks.check(l);
/* 301 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 303 */     JNI.callPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryIdByNameINTEL(@NativeType("GLchar *") ByteBuffer paramByteBuffer, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 308 */     long l = (GL.getICD()).glGetPerfQueryIdByNameINTEL;
/* 309 */     if (Checks.CHECKS) {
/* 310 */       Checks.check(l);
/* 311 */       Checks.checkNT1(paramByteBuffer);
/* 312 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 314 */     JNI.callPPV(MemoryUtil.memAddress(paramByteBuffer), paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryIdByNameINTEL(@NativeType("GLchar *") CharSequence paramCharSequence, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 319 */     long l = (GL.getICD()).glGetPerfQueryIdByNameINTEL;
/* 320 */     if (Checks.CHECKS) {
/* 321 */       Checks.check(l);
/* 322 */       Checks.check(paramArrayOfint, 1);
/*     */     }  MemoryStack memoryStack;
/* 324 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 326 */       memoryStack.nASCII(paramCharSequence, true);
/*     */       long l1;
/* 328 */       JNI.callPPV(l1 = memoryStack.getPointerAddress(), paramArrayOfint, l); return;
/*     */     } finally {
/* 330 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryInfoINTEL(@NativeType("GLuint") int paramInt, @NativeType("GLchar *") ByteBuffer paramByteBuffer, @NativeType("GLuint *") int[] paramArrayOfint1, @NativeType("GLuint *") int[] paramArrayOfint2, @NativeType("GLuint *") int[] paramArrayOfint3, @NativeType("GLuint *") int[] paramArrayOfint4) {
/* 336 */     long l = (GL.getICD()).glGetPerfQueryInfoINTEL;
/* 337 */     if (Checks.CHECKS) {
/* 338 */       Checks.check(l);
/* 339 */       Checks.check(paramArrayOfint1, 1);
/* 340 */       Checks.check(paramArrayOfint2, 1);
/* 341 */       Checks.check(paramArrayOfint3, 1);
/* 342 */       Checks.check(paramArrayOfint4, 1);
/*     */     } 
/* 344 */     JNI.callPPPPPV(paramInt, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, l);
/*     */   }
/*     */   
/*     */   public static native void glBeginPerfQueryINTEL(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglCreatePerfQueryINTEL(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glDeletePerfQueryINTEL(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glEndPerfQueryINTEL(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglGetFirstPerfQueryIdINTEL(long paramLong);
/*     */   
/*     */   public static native void nglGetNextPerfQueryIdINTEL(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetPerfCounterInfoINTEL(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*     */   
/*     */   public static native void nglGetPerfQueryDataINTEL(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetPerfQueryIdByNameINTEL(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetPerfQueryInfoINTEL(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\INTELPerformanceQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */