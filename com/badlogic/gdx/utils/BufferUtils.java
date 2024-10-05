/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.math.Matrix3;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BufferUtils
/*     */ {
/*  40 */   static Array<ByteBuffer> unsafeBuffers = new Array<>();
/*  41 */   static int allocatedUnsafe = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void copy(float[] paramArrayOffloat, Buffer paramBuffer, int paramInt1, int paramInt2) {
/*  54 */     if (paramBuffer instanceof ByteBuffer)
/*  55 */     { paramBuffer.limit(paramInt1 << 2); }
/*  56 */     else if (paramBuffer instanceof FloatBuffer) { paramBuffer.limit(paramInt1); }
/*     */     
/*  58 */     copyJni(paramArrayOffloat, paramBuffer, paramInt1, paramInt2);
/*  59 */     paramBuffer.position(0);
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
/*     */   public static void copy(byte[] paramArrayOfbyte, int paramInt1, Buffer paramBuffer, int paramInt2) {
/*  72 */     paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2));
/*  73 */     copyJni(paramArrayOfbyte, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2);
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
/*     */   public static void copy(short[] paramArrayOfshort, int paramInt1, Buffer paramBuffer, int paramInt2) {
/*  86 */     paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 1));
/*  87 */     copyJni(paramArrayOfshort, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 1);
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
/*     */   public static void copy(char[] paramArrayOfchar, int paramInt1, int paramInt2, Buffer paramBuffer) {
/*  99 */     copyJni(paramArrayOfchar, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 1);
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
/*     */   public static void copy(int[] paramArrayOfint, int paramInt1, int paramInt2, Buffer paramBuffer) {
/* 111 */     copyJni(paramArrayOfint, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 2);
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
/*     */   public static void copy(long[] paramArrayOflong, int paramInt1, int paramInt2, Buffer paramBuffer) {
/* 123 */     copyJni(paramArrayOflong, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 3);
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
/*     */   public static void copy(float[] paramArrayOffloat, int paramInt1, int paramInt2, Buffer paramBuffer) {
/* 135 */     copyJni(paramArrayOffloat, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 2);
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
/*     */   public static void copy(double[] paramArrayOfdouble, int paramInt1, int paramInt2, Buffer paramBuffer) {
/* 147 */     copyJni(paramArrayOfdouble, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 3);
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
/*     */   public static void copy(char[] paramArrayOfchar, int paramInt1, Buffer paramBuffer, int paramInt2) {
/* 160 */     paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 1));
/* 161 */     copyJni(paramArrayOfchar, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 1);
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
/*     */   public static void copy(int[] paramArrayOfint, int paramInt1, Buffer paramBuffer, int paramInt2) {
/* 174 */     paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 2));
/* 175 */     copyJni(paramArrayOfint, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 2);
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
/*     */   public static void copy(long[] paramArrayOflong, int paramInt1, Buffer paramBuffer, int paramInt2) {
/* 188 */     paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 3));
/* 189 */     copyJni(paramArrayOflong, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 3);
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
/*     */   public static void copy(float[] paramArrayOffloat, int paramInt1, Buffer paramBuffer, int paramInt2) {
/* 202 */     paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 2));
/* 203 */     copyJni(paramArrayOffloat, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 2);
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
/*     */   public static void copy(double[] paramArrayOfdouble, int paramInt1, Buffer paramBuffer, int paramInt2) {
/* 216 */     paramBuffer.limit(paramBuffer.position() + bytesToElements(paramBuffer, paramInt2 << 3));
/* 217 */     copyJni(paramArrayOfdouble, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2 << 3);
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
/*     */   public static void copy(Buffer paramBuffer1, Buffer paramBuffer2, int paramInt) {
/* 230 */     paramInt = elementsToBytes(paramBuffer1, paramInt);
/* 231 */     paramBuffer2.limit(paramBuffer2.position() + bytesToElements(paramBuffer2, paramInt));
/* 232 */     copyJni(paramBuffer1, positionInBytes(paramBuffer1), paramBuffer2, positionInBytes(paramBuffer2), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void transform(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, Matrix4 paramMatrix4) {
/* 243 */     transform(paramBuffer, paramInt1, paramInt2, paramInt3, paramMatrix4, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void transform(float[] paramArrayOffloat, int paramInt1, int paramInt2, int paramInt3, Matrix4 paramMatrix4) {
/* 254 */     transform(paramArrayOffloat, paramInt1, paramInt2, paramInt3, paramMatrix4, 0);
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
/*     */   public static void transform(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, Matrix4 paramMatrix4, int paramInt4) {
/* 266 */     switch (paramInt1) {
/*     */       case 4:
/* 268 */         transformV4M4Jni(paramBuffer, paramInt2, paramInt3, paramMatrix4.val, positionInBytes(paramBuffer) + paramInt4);
/*     */         return;
/*     */       case 3:
/* 271 */         transformV3M4Jni(paramBuffer, paramInt2, paramInt3, paramMatrix4.val, positionInBytes(paramBuffer) + paramInt4);
/*     */         return;
/*     */       case 2:
/* 274 */         transformV2M4Jni(paramBuffer, paramInt2, paramInt3, paramMatrix4.val, positionInBytes(paramBuffer) + paramInt4);
/*     */         return;
/*     */     } 
/* 277 */     throw new IllegalArgumentException();
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
/*     */   public static void transform(float[] paramArrayOffloat, int paramInt1, int paramInt2, int paramInt3, Matrix4 paramMatrix4, int paramInt4) {
/* 290 */     switch (paramInt1) {
/*     */       case 4:
/* 292 */         transformV4M4Jni(paramArrayOffloat, paramInt2, paramInt3, paramMatrix4.val, paramInt4);
/*     */         return;
/*     */       case 3:
/* 295 */         transformV3M4Jni(paramArrayOffloat, paramInt2, paramInt3, paramMatrix4.val, paramInt4);
/*     */         return;
/*     */       case 2:
/* 298 */         transformV2M4Jni(paramArrayOffloat, paramInt2, paramInt3, paramMatrix4.val, paramInt4);
/*     */         return;
/*     */     } 
/* 301 */     throw new IllegalArgumentException();
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
/*     */   public static void transform(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, Matrix3 paramMatrix3) {
/* 313 */     transform(paramBuffer, paramInt1, paramInt2, paramInt3, paramMatrix3, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void transform(float[] paramArrayOffloat, int paramInt1, int paramInt2, int paramInt3, Matrix3 paramMatrix3) {
/* 324 */     transform(paramArrayOffloat, paramInt1, paramInt2, paramInt3, paramMatrix3, 0);
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
/*     */   public static void transform(Buffer paramBuffer, int paramInt1, int paramInt2, int paramInt3, Matrix3 paramMatrix3, int paramInt4) {
/* 336 */     switch (paramInt1) {
/*     */       case 3:
/* 338 */         transformV3M3Jni(paramBuffer, paramInt2, paramInt3, paramMatrix3.val, positionInBytes(paramBuffer) + paramInt4);
/*     */         return;
/*     */       case 2:
/* 341 */         transformV2M3Jni(paramBuffer, paramInt2, paramInt3, paramMatrix3.val, positionInBytes(paramBuffer) + paramInt4);
/*     */         return;
/*     */     } 
/* 344 */     throw new IllegalArgumentException();
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
/*     */   public static void transform(float[] paramArrayOffloat, int paramInt1, int paramInt2, int paramInt3, Matrix3 paramMatrix3, int paramInt4) {
/* 357 */     switch (paramInt1) {
/*     */       case 3:
/* 359 */         transformV3M3Jni(paramArrayOffloat, paramInt2, paramInt3, paramMatrix3.val, paramInt4);
/*     */         return;
/*     */       case 2:
/* 362 */         transformV2M3Jni(paramArrayOffloat, paramInt2, paramInt3, paramMatrix3.val, paramInt4);
/*     */         return;
/*     */     } 
/* 365 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */   
/*     */   public static long findFloats(Buffer paramBuffer1, int paramInt1, Buffer paramBuffer2, int paramInt2) {
/* 370 */     return find(paramBuffer1, positionInBytes(paramBuffer1), paramInt1, paramBuffer2, positionInBytes(paramBuffer2), paramInt2);
/*     */   }
/*     */   
/*     */   public static long findFloats(float[] paramArrayOffloat, int paramInt1, Buffer paramBuffer, int paramInt2) {
/* 374 */     return find(paramArrayOffloat, 0, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2);
/*     */   }
/*     */   
/*     */   public static long findFloats(Buffer paramBuffer, int paramInt1, float[] paramArrayOffloat, int paramInt2) {
/* 378 */     return find(paramBuffer, positionInBytes(paramBuffer), paramInt1, paramArrayOffloat, 0, paramInt2);
/*     */   }
/*     */   
/*     */   public static long findFloats(float[] paramArrayOffloat1, int paramInt1, float[] paramArrayOffloat2, int paramInt2) {
/* 382 */     return find(paramArrayOffloat1, 0, paramInt1, paramArrayOffloat2, 0, paramInt2);
/*     */   }
/*     */   
/*     */   public static long findFloats(Buffer paramBuffer1, int paramInt1, Buffer paramBuffer2, int paramInt2, float paramFloat) {
/* 386 */     return find(paramBuffer1, positionInBytes(paramBuffer1), paramInt1, paramBuffer2, positionInBytes(paramBuffer2), paramInt2, paramFloat);
/*     */   }
/*     */   
/*     */   public static long findFloats(float[] paramArrayOffloat, int paramInt1, Buffer paramBuffer, int paramInt2, float paramFloat) {
/* 390 */     return find(paramArrayOffloat, 0, paramInt1, paramBuffer, positionInBytes(paramBuffer), paramInt2, paramFloat);
/*     */   }
/*     */   
/*     */   public static long findFloats(Buffer paramBuffer, int paramInt1, float[] paramArrayOffloat, int paramInt2, float paramFloat) {
/* 394 */     return find(paramBuffer, positionInBytes(paramBuffer), paramInt1, paramArrayOffloat, 0, paramInt2, paramFloat);
/*     */   }
/*     */   
/*     */   public static long findFloats(float[] paramArrayOffloat1, int paramInt1, float[] paramArrayOffloat2, int paramInt2, float paramFloat) {
/* 398 */     return find(paramArrayOffloat1, 0, paramInt1, paramArrayOffloat2, 0, paramInt2, paramFloat);
/*     */   }
/*     */   
/*     */   private static int positionInBytes(Buffer paramBuffer) {
/* 402 */     if (paramBuffer instanceof ByteBuffer)
/* 403 */       return paramBuffer.position(); 
/* 404 */     if (paramBuffer instanceof ShortBuffer)
/* 405 */       return paramBuffer.position() << 1; 
/* 406 */     if (paramBuffer instanceof CharBuffer)
/* 407 */       return paramBuffer.position() << 1; 
/* 408 */     if (paramBuffer instanceof IntBuffer)
/* 409 */       return paramBuffer.position() << 2; 
/* 410 */     if (paramBuffer instanceof LongBuffer)
/* 411 */       return paramBuffer.position() << 3; 
/* 412 */     if (paramBuffer instanceof FloatBuffer)
/* 413 */       return paramBuffer.position() << 2; 
/* 414 */     if (paramBuffer instanceof DoubleBuffer) {
/* 415 */       return paramBuffer.position() << 3;
/*     */     }
/* 417 */     throw new GdxRuntimeException("Can't copy to a " + paramBuffer.getClass().getName() + " instance");
/*     */   }
/*     */   
/*     */   private static int bytesToElements(Buffer paramBuffer, int paramInt) {
/* 421 */     if (paramBuffer instanceof ByteBuffer)
/* 422 */       return paramInt; 
/* 423 */     if (paramBuffer instanceof ShortBuffer)
/* 424 */       return paramInt >>> 1; 
/* 425 */     if (paramBuffer instanceof CharBuffer)
/* 426 */       return paramInt >>> 1; 
/* 427 */     if (paramBuffer instanceof IntBuffer)
/* 428 */       return paramInt >>> 2; 
/* 429 */     if (paramBuffer instanceof LongBuffer)
/* 430 */       return paramInt >>> 3; 
/* 431 */     if (paramBuffer instanceof FloatBuffer)
/* 432 */       return paramInt >>> 2; 
/* 433 */     if (paramBuffer instanceof DoubleBuffer) {
/* 434 */       return paramInt >>> 3;
/*     */     }
/* 436 */     throw new GdxRuntimeException("Can't copy to a " + paramBuffer.getClass().getName() + " instance");
/*     */   }
/*     */   
/*     */   private static int elementsToBytes(Buffer paramBuffer, int paramInt) {
/* 440 */     if (paramBuffer instanceof ByteBuffer)
/* 441 */       return paramInt; 
/* 442 */     if (paramBuffer instanceof ShortBuffer)
/* 443 */       return paramInt << 1; 
/* 444 */     if (paramBuffer instanceof CharBuffer)
/* 445 */       return paramInt << 1; 
/* 446 */     if (paramBuffer instanceof IntBuffer)
/* 447 */       return paramInt << 2; 
/* 448 */     if (paramBuffer instanceof LongBuffer)
/* 449 */       return paramInt << 3; 
/* 450 */     if (paramBuffer instanceof FloatBuffer)
/* 451 */       return paramInt << 2; 
/* 452 */     if (paramBuffer instanceof DoubleBuffer) {
/* 453 */       return paramInt << 3;
/*     */     }
/* 455 */     throw new GdxRuntimeException("Can't copy to a " + paramBuffer.getClass().getName() + " instance");
/*     */   }
/*     */   
/*     */   public static FloatBuffer newFloatBuffer(int paramInt) {
/*     */     ByteBuffer byteBuffer;
/* 460 */     (byteBuffer = ByteBuffer.allocateDirect(paramInt << 2)).order(ByteOrder.nativeOrder());
/* 461 */     return byteBuffer.asFloatBuffer();
/*     */   }
/*     */   
/*     */   public static DoubleBuffer newDoubleBuffer(int paramInt) {
/*     */     ByteBuffer byteBuffer;
/* 466 */     (byteBuffer = ByteBuffer.allocateDirect(paramInt << 3)).order(ByteOrder.nativeOrder());
/* 467 */     return byteBuffer.asDoubleBuffer();
/*     */   }
/*     */   
/*     */   public static ByteBuffer newByteBuffer(int paramInt) {
/*     */     ByteBuffer byteBuffer;
/* 472 */     (byteBuffer = ByteBuffer.allocateDirect(paramInt)).order(ByteOrder.nativeOrder());
/* 473 */     return byteBuffer;
/*     */   }
/*     */   
/*     */   public static ShortBuffer newShortBuffer(int paramInt) {
/*     */     ByteBuffer byteBuffer;
/* 478 */     (byteBuffer = ByteBuffer.allocateDirect(paramInt << 1)).order(ByteOrder.nativeOrder());
/* 479 */     return byteBuffer.asShortBuffer();
/*     */   }
/*     */   
/*     */   public static CharBuffer newCharBuffer(int paramInt) {
/*     */     ByteBuffer byteBuffer;
/* 484 */     (byteBuffer = ByteBuffer.allocateDirect(paramInt << 1)).order(ByteOrder.nativeOrder());
/* 485 */     return byteBuffer.asCharBuffer();
/*     */   }
/*     */   
/*     */   public static IntBuffer newIntBuffer(int paramInt) {
/*     */     ByteBuffer byteBuffer;
/* 490 */     (byteBuffer = ByteBuffer.allocateDirect(paramInt << 2)).order(ByteOrder.nativeOrder());
/* 491 */     return byteBuffer.asIntBuffer();
/*     */   }
/*     */   
/*     */   public static LongBuffer newLongBuffer(int paramInt) {
/*     */     ByteBuffer byteBuffer;
/* 496 */     (byteBuffer = ByteBuffer.allocateDirect(paramInt << 3)).order(ByteOrder.nativeOrder());
/* 497 */     return byteBuffer.asLongBuffer();
/*     */   }
/*     */   
/*     */   public static void disposeUnsafeByteBuffer(ByteBuffer paramByteBuffer) {
/* 501 */     int i = paramByteBuffer.capacity();
/* 502 */     synchronized (unsafeBuffers) {
/* 503 */       if (!unsafeBuffers.removeValue(paramByteBuffer, true))
/* 504 */         throw new IllegalArgumentException("buffer not allocated with newUnsafeByteBuffer or already disposed"); 
/*     */     } 
/* 506 */     allocatedUnsafe -= i;
/* 507 */     freeMemory(paramByteBuffer);
/*     */   }
/*     */   
/*     */   public static boolean isUnsafeByteBuffer(ByteBuffer paramByteBuffer) {
/* 511 */     synchronized (unsafeBuffers) {
/* 512 */       return unsafeBuffers.contains(paramByteBuffer, true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer newUnsafeByteBuffer(int paramInt) {
/* 520 */     (null = newDisposableByteBuffer(paramInt)).order(ByteOrder.nativeOrder());
/* 521 */     allocatedUnsafe += paramInt;
/* 522 */     synchronized (unsafeBuffers) {
/* 523 */       unsafeBuffers.add(null);
/*     */     } 
/* 525 */     return (ByteBuffer)SYNTHETIC_LOCAL_VARIABLE_1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getUnsafeBufferAddress(Buffer paramBuffer) {
/* 532 */     return getBufferAddress(paramBuffer) + paramBuffer.position();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer newUnsafeByteBuffer(ByteBuffer paramByteBuffer) {
/* 540 */     allocatedUnsafe += paramByteBuffer.capacity();
/* 541 */     synchronized (unsafeBuffers) {
/* 542 */       unsafeBuffers.add(paramByteBuffer);
/*     */     } 
/* 544 */     return paramByteBuffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getAllocatedBytesUnsafe() {
/* 549 */     return allocatedUnsafe;
/*     */   }
/*     */   
/*     */   private static native void freeMemory(ByteBuffer paramByteBuffer);
/*     */   
/*     */   private static native ByteBuffer newDisposableByteBuffer(int paramInt);
/*     */   
/*     */   private static native long getBufferAddress(Buffer paramBuffer);
/*     */   
/*     */   public static native void clear(ByteBuffer paramByteBuffer, int paramInt);
/*     */   
/*     */   private static native void copyJni(float[] paramArrayOffloat, Buffer paramBuffer, int paramInt1, int paramInt2);
/*     */   
/*     */   private static native void copyJni(byte[] paramArrayOfbyte, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);
/*     */   
/*     */   private static native void copyJni(char[] paramArrayOfchar, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);
/*     */   
/*     */   private static native void copyJni(short[] paramArrayOfshort, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);
/*     */   
/*     */   private static native void copyJni(int[] paramArrayOfint, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);
/*     */   
/*     */   private static native void copyJni(long[] paramArrayOflong, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);
/*     */   
/*     */   private static native void copyJni(float[] paramArrayOffloat, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);
/*     */   
/*     */   private static native void copyJni(double[] paramArrayOfdouble, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3);
/*     */   
/*     */   private static native void copyJni(Buffer paramBuffer1, int paramInt1, Buffer paramBuffer2, int paramInt2, int paramInt3);
/*     */   
/*     */   private static native void transformV4M4Jni(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3);
/*     */   
/*     */   private static native void transformV4M4Jni(float[] paramArrayOffloat1, int paramInt1, int paramInt2, float[] paramArrayOffloat2, int paramInt3);
/*     */   
/*     */   private static native void transformV3M4Jni(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3);
/*     */   
/*     */   private static native void transformV3M4Jni(float[] paramArrayOffloat1, int paramInt1, int paramInt2, float[] paramArrayOffloat2, int paramInt3);
/*     */   
/*     */   private static native void transformV2M4Jni(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3);
/*     */   
/*     */   private static native void transformV2M4Jni(float[] paramArrayOffloat1, int paramInt1, int paramInt2, float[] paramArrayOffloat2, int paramInt3);
/*     */   
/*     */   private static native void transformV3M3Jni(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3);
/*     */   
/*     */   private static native void transformV3M3Jni(float[] paramArrayOffloat1, int paramInt1, int paramInt2, float[] paramArrayOffloat2, int paramInt3);
/*     */   
/*     */   private static native void transformV2M3Jni(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3);
/*     */   
/*     */   private static native void transformV2M3Jni(float[] paramArrayOffloat1, int paramInt1, int paramInt2, float[] paramArrayOffloat2, int paramInt3);
/*     */   
/*     */   private static native long find(Buffer paramBuffer1, int paramInt1, int paramInt2, Buffer paramBuffer2, int paramInt3, int paramInt4);
/*     */   
/*     */   private static native long find(float[] paramArrayOffloat, int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3, int paramInt4);
/*     */   
/*     */   private static native long find(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3, int paramInt4);
/*     */   
/*     */   private static native long find(float[] paramArrayOffloat1, int paramInt1, int paramInt2, float[] paramArrayOffloat2, int paramInt3, int paramInt4);
/*     */   
/*     */   private static native long find(Buffer paramBuffer1, int paramInt1, int paramInt2, Buffer paramBuffer2, int paramInt3, int paramInt4, float paramFloat);
/*     */   
/*     */   private static native long find(float[] paramArrayOffloat, int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3, int paramInt4, float paramFloat);
/*     */   
/*     */   private static native long find(Buffer paramBuffer, int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3, int paramInt4, float paramFloat);
/*     */   
/*     */   private static native long find(float[] paramArrayOffloat1, int paramInt1, int paramInt2, float[] paramArrayOffloat2, int paramInt3, int paramInt4, float paramFloat);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\BufferUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */