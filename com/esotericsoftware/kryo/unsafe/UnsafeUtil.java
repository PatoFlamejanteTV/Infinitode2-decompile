/*     */ package com.esotericsoftware.kryo.unsafe;
/*     */ 
/*     */ import com.esotericsoftware.kryo.KryoException;
/*     */ import com.esotericsoftware.kryo.util.Util;
/*     */ import com.esotericsoftware.minlog.Log;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.nio.ByteBuffer;
/*     */ import sun.misc.Unsafe;
/*     */ import sun.nio.ch.DirectBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UnsafeUtil
/*     */ {
/*     */   public static final Unsafe unsafe;
/*     */   public static final long byteArrayBaseOffset;
/*     */   public static final long floatArrayBaseOffset;
/*     */   public static final long doubleArrayBaseOffset;
/*     */   public static final long intArrayBaseOffset;
/*     */   public static final long longArrayBaseOffset;
/*     */   public static final long shortArrayBaseOffset;
/*     */   public static final long charArrayBaseOffset;
/*     */   public static final long booleanArrayBaseOffset;
/*     */   
/*     */   static {
/*  53 */     Unsafe unsafe = null;
/*  54 */     long l1 = 0L;
/*  55 */     long l2 = 0L;
/*  56 */     long l3 = 0L;
/*  57 */     long l4 = 0L;
/*  58 */     long l5 = 0L;
/*  59 */     long l6 = 0L;
/*  60 */     long l7 = 0L;
/*  61 */     long l8 = 0L;
/*     */     
/*     */     try {
/*  64 */       if (!Util.isAndroid)
/*     */       { Field field;
/*  66 */         (field = Unsafe.class.getDeclaredField("theUnsafe")).setAccessible(true);
/*     */         
/*  68 */         l1 = (unsafe = (Unsafe)field.get(null)).arrayBaseOffset(byte[].class);
/*  69 */         l7 = unsafe.arrayBaseOffset(char[].class);
/*  70 */         l6 = unsafe.arrayBaseOffset(short[].class);
/*  71 */         l4 = unsafe.arrayBaseOffset(int[].class);
/*  72 */         l2 = unsafe.arrayBaseOffset(float[].class);
/*  73 */         l5 = unsafe.arrayBaseOffset(long[].class);
/*  74 */         l3 = unsafe.arrayBaseOffset(double[].class);
/*  75 */         l8 = unsafe.arrayBaseOffset(boolean[].class); }
/*     */       
/*  77 */       else if (Log.DEBUG) { Log.debug("kryo", "Unsafe is not available on Android."); }
/*     */     
/*  79 */     } catch (Exception exception) {
/*  80 */       if (Log.DEBUG) Log.debug("kryo", "Unsafe is not available.", exception);
/*     */     
/*     */     } 
/*  83 */     byteArrayBaseOffset = l1;
/*  84 */     charArrayBaseOffset = l7;
/*  85 */     shortArrayBaseOffset = l6;
/*  86 */     intArrayBaseOffset = l4;
/*  87 */     floatArrayBaseOffset = l2;
/*  88 */     longArrayBaseOffset = l5;
/*  89 */     doubleArrayBaseOffset = l3;
/*  90 */     booleanArrayBaseOffset = l8;
/*  91 */     unsafe = unsafe;
/*     */   }
/*     */   
/*     */   private static final class DirectBuffers { private static Constructor<? extends ByteBuffer> directByteBufferConstructor;
/*     */     private static Method cleanerMethod;
/*     */     private static Method cleanMethod;
/*     */     
/*     */     static {
/*  99 */       ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1);
/*     */       
/*     */       try {
/* 102 */         (directByteBufferConstructor = (Constructor)byteBuffer.getClass().getDeclaredConstructor(new Class[] { long.class, int.class })).setAccessible(true);
/* 103 */       } catch (Exception exception) {
/* 104 */         if (Log.DEBUG) Log.debug("kryo", "No direct ByteBuffer constructor is available.", exception); 
/* 105 */         directByteBufferConstructor = null;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 113 */         (cleanerMethod = DirectBuffer.class.getMethod("cleaner", new Class[0])).setAccessible(true);
/* 114 */         cleanMethod = cleanerMethod.getReturnType().getMethod("clean", new Class[0]); return;
/* 115 */       } catch (Exception exception) {
/* 116 */         if (Log.DEBUG) Log.debug("kryo", "No direct ByteBuffer clean method is available.", exception); 
/* 117 */         cleanerMethod = null;
/*     */         return;
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer newDirectBuffer(long paramLong, int paramInt) {
/* 127 */     if (!isNewDirectBufferAvailable())
/* 128 */       throw new UnsupportedOperationException("No direct ByteBuffer constructor is available."); 
/*     */     try {
/* 130 */       return DirectBuffers.directByteBufferConstructor.newInstance(new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
/* 131 */     } catch (Exception exception) {
/* 132 */       throw new KryoException("Error creating a ByteBuffer at address: " + paramLong, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isNewDirectBufferAvailable() {
/* 138 */     return (DirectBuffers.directByteBufferConstructor != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void dispose(ByteBuffer paramByteBuffer) {
/* 143 */     if (!(paramByteBuffer instanceof DirectBuffer))
/* 144 */       return;  if (DirectBuffers.cleanerMethod != null)
/*     */       try {
/* 146 */         DirectBuffers.cleanMethod.invoke(DirectBuffers.cleanerMethod.invoke(paramByteBuffer, new Object[0]), new Object[0]); return;
/* 147 */       } catch (Throwable throwable) {} 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\unsafe\UnsafeUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */