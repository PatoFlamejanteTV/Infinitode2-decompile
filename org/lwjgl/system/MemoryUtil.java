/*      */ package org.lwjgl.system;
/*      */ 
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.nio.Buffer;
/*      */ import java.nio.BufferOverflowException;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.ByteOrder;
/*      */ import java.nio.CharBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import java.nio.charset.Charset;
/*      */ import java.nio.charset.StandardCharsets;
/*      */ import java.util.Objects;
/*      */ import java.util.function.LongPredicate;
/*      */ import org.lwjgl.CLongBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.jni.JNINativeInterface;
/*      */ import org.lwjgl.system.libc.LibCString;
/*      */ import sun.misc.Unsafe;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class MemoryUtil
/*      */ {
/*   63 */   static final int ARRAY_TLC_SIZE = ((Integer)Configuration.ARRAY_TLC_SIZE.get(Integer.valueOf(8192))).intValue();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   72 */   private static final Charset UTF16 = ((NATIVE_ORDER = ByteOrder.nativeOrder()) == ByteOrder.LITTLE_ENDIAN) ? StandardCharsets.UTF_16LE : StandardCharsets.UTF_16BE; static final ThreadLocal<byte[]> ARRAY_TLC_BYTE = (ThreadLocal)ThreadLocal.withInitial(() -> new byte[ARRAY_TLC_SIZE]); static final ThreadLocal<char[]> ARRAY_TLC_CHAR = (ThreadLocal)ThreadLocal.withInitial(() -> new char[ARRAY_TLC_SIZE]); public static final long NULL = 0L; public static final int PAGE_SIZE;
/*      */   public static final int CACHE_LINE_SIZE;
/*      */   static final Unsafe UNSAFE;
/*      */   static final ByteOrder NATIVE_ORDER;
/*      */   static final Class<? extends ByteBuffer> BUFFER_BYTE;
/*      */   static final Class<? extends ShortBuffer> BUFFER_SHORT;
/*      */   static final Class<? extends CharBuffer> BUFFER_CHAR;
/*      */   static final Class<? extends IntBuffer> BUFFER_INT;
/*      */   static final Class<? extends LongBuffer> BUFFER_LONG;
/*      */   static final Class<? extends FloatBuffer> BUFFER_FLOAT;
/*      */   static final Class<? extends DoubleBuffer> BUFFER_DOUBLE;
/*      */   private static final long MARK;
/*      */   private static final long POSITION;
/*      */   private static final long LIMIT;
/*      */   private static final long CAPACITY;
/*      */   private static final long ADDRESS;
/*      */   private static final long PARENT_BYTE;
/*      */   private static final long PARENT_SHORT;
/*      */   private static final long PARENT_CHAR;
/*      */   private static final long PARENT_INT;
/*      */   private static final long PARENT_LONG;
/*      */   private static final long PARENT_FLOAT;
/*      */   private static final long PARENT_DOUBLE;
/*      */   private static final int FILL_PATTERN_32;
/*      */   private static final long FILL_PATTERN_64;
/*      */   private static final int MAGIC_CAPACITY = 219540062;
/*      */   private static final int MAGIC_POSITION = 16435934;
/*      */   
/*  100 */   static { Library.initialize();
/*      */     
/*      */     ByteBuffer byteBuffer;
/*      */     
/*  104 */     BUFFER_BYTE = (Class)(byteBuffer = ByteBuffer.allocateDirect(0).order(NATIVE_ORDER)).getClass();
/*  105 */     BUFFER_SHORT = (Class)byteBuffer.asShortBuffer().getClass();
/*  106 */     BUFFER_CHAR = (Class)byteBuffer.asCharBuffer().getClass();
/*  107 */     BUFFER_INT = (Class)byteBuffer.asIntBuffer().getClass();
/*  108 */     BUFFER_LONG = (Class)byteBuffer.asLongBuffer().getClass();
/*  109 */     BUFFER_FLOAT = (Class)byteBuffer.asFloatBuffer().getClass();
/*  110 */     BUFFER_DOUBLE = (Class)byteBuffer.asDoubleBuffer().getClass();
/*      */     
/*  112 */     UNSAFE = getUnsafeInstance();
/*      */     
/*      */     try {
/*  115 */       MARK = getMarkOffset();
/*  116 */       POSITION = getPositionOffset();
/*  117 */       LIMIT = getLimitOffset();
/*  118 */       CAPACITY = getCapacityOffset();
/*      */       
/*  120 */       ADDRESS = getAddressOffset();
/*      */       
/*  122 */       PARENT_BYTE = getFieldOffsetObject(byteBuffer.duplicate().order(byteBuffer.order()), byteBuffer);
/*  123 */       PARENT_SHORT = getFieldOffsetObject(byteBuffer.asShortBuffer(), byteBuffer);
/*  124 */       PARENT_CHAR = getFieldOffsetObject(byteBuffer.asCharBuffer(), byteBuffer);
/*  125 */       PARENT_INT = getFieldOffsetObject(byteBuffer.asIntBuffer(), byteBuffer);
/*  126 */       PARENT_LONG = getFieldOffsetObject(byteBuffer.asLongBuffer(), byteBuffer);
/*  127 */       PARENT_FLOAT = getFieldOffsetObject(byteBuffer.asFloatBuffer(), byteBuffer);
/*  128 */       PARENT_DOUBLE = getFieldOffsetObject(byteBuffer.asDoubleBuffer(), byteBuffer);
/*  129 */     } catch (Throwable throwable) {
/*  130 */       throw new UnsupportedOperationException(throwable);
/*      */     } 
/*      */     
/*  133 */     PAGE_SIZE = UNSAFE.pageSize();
/*  134 */     CACHE_LINE_SIZE = 64;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1768 */     FILL_PATTERN_32 = Integer.divideUnsigned(-1, 255);
/* 1769 */     FILL_PATTERN_64 = Long.divideUnsigned(-1L, 255L); }
/*      */   static final class LazyInit {
/*      */     static { boolean bool = ((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR.get(Boolean.FALSE)).booleanValue(); }
/*      */     static final MemoryUtil.MemoryAllocator ALLOCATOR_IMPL = MemoryManage.getInstance();
/*      */     static final MemoryUtil.MemoryAllocator ALLOCATOR;
/*      */     static { ALLOCATOR = bool ? new MemoryManage.DebugAllocator(ALLOCATOR_IMPL) : ALLOCATOR_IMPL; APIUtil.apiLog("MemoryUtil allocator: " + ALLOCATOR.getClass().getSimpleName()); if (bool && !((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR_FAST.get(Boolean.FALSE)).booleanValue()) APIUtil.apiLogMore("Reminder: enable Configuration.DEBUG_MEMORY_ALLOCATOR_FAST for low overhead allocation tracking.");  } }
/*      */   public static MemoryAllocator getAllocator() { return getAllocator(false); }
/*      */   public static MemoryAllocator getAllocator(boolean paramBoolean) { return paramBoolean ? LazyInit.ALLOCATOR : LazyInit.ALLOCATOR_IMPL; } public static long nmemAlloc(long paramLong) { return LazyInit.ALLOCATOR.malloc(paramLong); } public static long nmemAllocChecked(long paramLong) { long l = nmemAlloc((paramLong != 0L) ? paramLong : 1L); if (Checks.CHECKS && l == 0L) throw new OutOfMemoryError();  return l; } private static long getAllocationSize(int paramInt1, int paramInt2) { return APIUtil.apiCheckAllocation(paramInt1, Integer.toUnsignedLong(paramInt1) << paramInt2, Pointer.BITS64 ? Long.MAX_VALUE : 4294967295L); } public static ByteBuffer memAlloc(int paramInt) { return ((ByteBuffer)wrap(BUFFER_BYTE, nmemAllocChecked(paramInt), paramInt)).order(NATIVE_ORDER); } public static ShortBuffer memAllocShort(int paramInt) { return wrap(BUFFER_SHORT, nmemAllocChecked(getAllocationSize(paramInt, 1)), paramInt); } public static IntBuffer memAllocInt(int paramInt) { return wrap(BUFFER_INT, nmemAllocChecked(getAllocationSize(paramInt, 2)), paramInt); } public static FloatBuffer memAllocFloat(int paramInt) { return wrap(BUFFER_FLOAT, nmemAllocChecked(getAllocationSize(paramInt, 2)), paramInt); } public static LongBuffer memAllocLong(int paramInt) { return wrap(BUFFER_LONG, nmemAllocChecked(getAllocationSize(paramInt, 3)), paramInt); } public static CLongBuffer memAllocCLong(int paramInt) { return CLongBuffer.create(nmemAllocChecked(getAllocationSize(paramInt, Pointer.CLONG_SHIFT)), paramInt); } public static DoubleBuffer memAllocDouble(int paramInt) { return wrap(BUFFER_DOUBLE, nmemAllocChecked(getAllocationSize(paramInt, 3)), paramInt); } public static PointerBuffer memAllocPointer(int paramInt) { return PointerBuffer.create(nmemAllocChecked(getAllocationSize(paramInt, Pointer.POINTER_SHIFT)), paramInt); } public static void nmemFree(long paramLong) { LazyInit.ALLOCATOR.free(paramLong); } public static void memFree(Buffer paramBuffer) { if (paramBuffer != null) nmemFree(UNSAFE.getLong(paramBuffer, ADDRESS));  } public static void memFree(CustomBuffer<?> paramCustomBuffer) { if (paramCustomBuffer != null) nmemFree(paramCustomBuffer.address);  } public static long nmemCalloc(long paramLong1, long paramLong2) { return LazyInit.ALLOCATOR.calloc(paramLong1, paramLong2); } public static long nmemCallocChecked(long paramLong1, long paramLong2) { if (paramLong1 == 0L || paramLong2 == 0L) { paramLong1 = 1L; paramLong2 = 1L; }  long l = nmemCalloc(paramLong1, paramLong2); if (Checks.CHECKS && l == 0L) throw new OutOfMemoryError();  return l; } public static ByteBuffer memCalloc(int paramInt1, int paramInt2) { return ((ByteBuffer)wrap(BUFFER_BYTE, nmemCallocChecked(paramInt1, paramInt2), paramInt1 * paramInt2)).order(NATIVE_ORDER); } public static ByteBuffer memCalloc(int paramInt) { return ((ByteBuffer)wrap(BUFFER_BYTE, nmemCallocChecked(paramInt, 1L), paramInt)).order(NATIVE_ORDER); } public static ShortBuffer memCallocShort(int paramInt) { return wrap(BUFFER_SHORT, nmemCallocChecked(paramInt, 2L), paramInt); } public static IntBuffer memCallocInt(int paramInt) { return wrap(BUFFER_INT, nmemCallocChecked(paramInt, 4L), paramInt); } public static FloatBuffer memCallocFloat(int paramInt) { return wrap(BUFFER_FLOAT, nmemCallocChecked(paramInt, 4L), paramInt); } public static LongBuffer memCallocLong(int paramInt) { return wrap(BUFFER_LONG, nmemCallocChecked(paramInt, 8L), paramInt); } public static CLongBuffer memCallocCLong(int paramInt) { return CLongBuffer.create(nmemCallocChecked(paramInt, Pointer.CLONG_SIZE), paramInt); } public static DoubleBuffer memCallocDouble(int paramInt) { return wrap(BUFFER_DOUBLE, nmemCallocChecked(paramInt, 8L), paramInt); } public static PointerBuffer memCallocPointer(int paramInt) { return PointerBuffer.create(nmemCallocChecked(paramInt, Pointer.POINTER_SIZE), paramInt); } public static long nmemRealloc(long paramLong1, long paramLong2) { return LazyInit.ALLOCATOR.realloc(paramLong1, paramLong2); } public static long nmemReallocChecked(long paramLong1, long paramLong2) { long l = nmemRealloc(paramLong1, (paramLong2 != 0L) ? paramLong2 : 1L); if (Checks.CHECKS && l == 0L) throw new OutOfMemoryError();  return l; } private static <T extends Buffer> T realloc(T paramT1, T paramT2, int paramInt) { if (paramT1 != null) paramT2.position(Math.min(paramT1.position(), paramInt));  return paramT2; } public static ByteBuffer memRealloc(ByteBuffer paramByteBuffer, int paramInt) { return realloc(paramByteBuffer, memByteBuffer(nmemReallocChecked((paramByteBuffer == null) ? 0L : UNSAFE.getLong(paramByteBuffer, ADDRESS), paramInt), paramInt), paramInt); } public static ShortBuffer memRealloc(ShortBuffer paramShortBuffer, int paramInt) { return realloc(paramShortBuffer, memShortBuffer(nmemReallocChecked((paramShortBuffer == null) ? 0L : UNSAFE.getLong(paramShortBuffer, ADDRESS), getAllocationSize(paramInt, 1)), paramInt), paramInt); } public static IntBuffer memRealloc(IntBuffer paramIntBuffer, int paramInt) { return realloc(paramIntBuffer, memIntBuffer(nmemReallocChecked((paramIntBuffer == null) ? 0L : UNSAFE.getLong(paramIntBuffer, ADDRESS), getAllocationSize(paramInt, 2)), paramInt), paramInt); } public static LongBuffer memRealloc(LongBuffer paramLongBuffer, int paramInt) { return realloc(paramLongBuffer, memLongBuffer(nmemReallocChecked((paramLongBuffer == null) ? 0L : UNSAFE.getLong(paramLongBuffer, ADDRESS), getAllocationSize(paramInt, 3)), paramInt), paramInt); } public static CLongBuffer memRealloc(CLongBuffer paramCLongBuffer, int paramInt) { CLongBuffer cLongBuffer = memCLongBuffer(nmemReallocChecked((paramCLongBuffer == null) ? 0L : paramCLongBuffer.address, getAllocationSize(paramInt, Pointer.CLONG_SIZE)), paramInt); if (paramCLongBuffer != null) cLongBuffer.position(Math.min(paramCLongBuffer.position(), paramInt));  return cLongBuffer; } public static FloatBuffer memRealloc(FloatBuffer paramFloatBuffer, int paramInt) { return realloc(paramFloatBuffer, memFloatBuffer(nmemReallocChecked((paramFloatBuffer == null) ? 0L : UNSAFE.getLong(paramFloatBuffer, ADDRESS), getAllocationSize(paramInt, 2)), paramInt), paramInt); } public static DoubleBuffer memRealloc(DoubleBuffer paramDoubleBuffer, int paramInt) { return realloc(paramDoubleBuffer, memDoubleBuffer(nmemReallocChecked((paramDoubleBuffer == null) ? 0L : UNSAFE.getLong(paramDoubleBuffer, ADDRESS), getAllocationSize(paramInt, 3)), paramInt), paramInt); } public static PointerBuffer memRealloc(PointerBuffer paramPointerBuffer, int paramInt) { PointerBuffer pointerBuffer = memPointerBuffer(nmemReallocChecked((paramPointerBuffer == null) ? 0L : paramPointerBuffer.address, getAllocationSize(paramInt, Pointer.POINTER_SHIFT)), paramInt); if (paramPointerBuffer != null) pointerBuffer.position(Math.min(paramPointerBuffer.position(), paramInt));  return pointerBuffer; } public static long nmemAlignedAlloc(long paramLong1, long paramLong2) { return LazyInit.ALLOCATOR.aligned_alloc(paramLong1, paramLong2); } public static long nmemAlignedAllocChecked(long paramLong1, long paramLong2) { long l = nmemAlignedAlloc(paramLong1, (paramLong2 != 0L) ? paramLong2 : 1L); if (Checks.CHECKS && l == 0L) throw new OutOfMemoryError();  return l; } public static ByteBuffer memAlignedAlloc(int paramInt1, int paramInt2) { return ((ByteBuffer)wrap(BUFFER_BYTE, nmemAlignedAllocChecked(paramInt1, paramInt2), paramInt2)).order(NATIVE_ORDER); } public static void nmemAlignedFree(long paramLong) { LazyInit.ALLOCATOR.aligned_free(paramLong); } public static void memAlignedFree(ByteBuffer paramByteBuffer) { if (paramByteBuffer != null) nmemAlignedFree(UNSAFE.getLong(paramByteBuffer, ADDRESS));  } public static interface MemoryAllocationReport {
/*      */     void invoke(long param1Long1, long param1Long2, long param1Long3, String param1String, StackTraceElement... param1VarArgs); public enum Aggregate {
/*      */       ALL, GROUP_BY_METHOD, GROUP_BY_STACKTRACE; } } public enum Aggregate {
/* 1779 */     ALL, GROUP_BY_METHOD, GROUP_BY_STACKTRACE; } public static void memReport(MemoryAllocationReport paramMemoryAllocationReport) { MemoryManage.DebugAllocator.report(paramMemoryAllocationReport); } public static void memReport(MemoryAllocationReport paramMemoryAllocationReport, MemoryAllocationReport.Aggregate paramAggregate, boolean paramBoolean) { MemoryManage.DebugAllocator.report(paramMemoryAllocationReport, paramAggregate, paramBoolean); } public static long memAddress0(Buffer paramBuffer) { return UNSAFE.getLong(paramBuffer, ADDRESS); } public static long memAddress(ByteBuffer paramByteBuffer) { return paramByteBuffer.position() + memAddress0(paramByteBuffer); } public static long memAddress(ByteBuffer paramByteBuffer, int paramInt) { Objects.requireNonNull(paramByteBuffer); return memAddress0(paramByteBuffer) + Integer.toUnsignedLong(paramInt); } private static long address(int paramInt1, int paramInt2, long paramLong) { return paramLong + ((paramInt1 & 0xFFFFFFFFL) << paramInt2); } public static long memAddress(ShortBuffer paramShortBuffer) { return address(paramShortBuffer.position(), 1, memAddress0(paramShortBuffer)); } public static long memAddress(ShortBuffer paramShortBuffer, int paramInt) { Objects.requireNonNull(paramShortBuffer); return address(paramInt, 1, memAddress0(paramShortBuffer)); } public static long memAddress(CharBuffer paramCharBuffer) { return address(paramCharBuffer.position(), 1, memAddress0(paramCharBuffer)); } public static long memAddress(CharBuffer paramCharBuffer, int paramInt) { Objects.requireNonNull(paramCharBuffer); return address(paramInt, 1, memAddress0(paramCharBuffer)); } public static long memAddress(IntBuffer paramIntBuffer) { return address(paramIntBuffer.position(), 2, memAddress0(paramIntBuffer)); } public static long memAddress(IntBuffer paramIntBuffer, int paramInt) { Objects.requireNonNull(paramIntBuffer); return address(paramInt, 2, memAddress0(paramIntBuffer)); } public static long memAddress(FloatBuffer paramFloatBuffer) { return address(paramFloatBuffer.position(), 2, memAddress0(paramFloatBuffer)); } public static long memAddress(FloatBuffer paramFloatBuffer, int paramInt) { Objects.requireNonNull(paramFloatBuffer); return address(paramInt, 2, memAddress0(paramFloatBuffer)); } public static long memAddress(LongBuffer paramLongBuffer) { return address(paramLongBuffer.position(), 3, memAddress0(paramLongBuffer)); } public static long memAddress(LongBuffer paramLongBuffer, int paramInt) { Objects.requireNonNull(paramLongBuffer); return address(paramInt, 3, memAddress0(paramLongBuffer)); } public static long memAddress(DoubleBuffer paramDoubleBuffer) { return address(paramDoubleBuffer.position(), 3, memAddress0(paramDoubleBuffer)); } public static long memAddress(DoubleBuffer paramDoubleBuffer, int paramInt) { Objects.requireNonNull(paramDoubleBuffer); return address(paramInt, 3, memAddress0(paramDoubleBuffer)); } public static long memAddress(Buffer paramBuffer) { byte b; if (paramBuffer instanceof ByteBuffer) { b = 0; } else if (paramBuffer instanceof ShortBuffer || paramBuffer instanceof CharBuffer) { b = 1; } else if (paramBuffer instanceof IntBuffer || paramBuffer instanceof FloatBuffer) { b = 2; } else { b = 3; }  return address(paramBuffer.position(), b, memAddress0(paramBuffer)); } public static long memAddress(CustomBuffer<?> paramCustomBuffer) { return paramCustomBuffer.address(); } public static long memAddress(CustomBuffer<?> paramCustomBuffer, int paramInt) { return paramCustomBuffer.address(paramInt); } public static long memAddressSafe(ByteBuffer paramByteBuffer) { return (paramByteBuffer == null) ? 0L : (memAddress0(paramByteBuffer) + paramByteBuffer.position()); } public static long memAddressSafe(ShortBuffer paramShortBuffer) { return (paramShortBuffer == null) ? 0L : address(paramShortBuffer.position(), 1, memAddress0(paramShortBuffer)); } public static long memAddressSafe(CharBuffer paramCharBuffer) { return (paramCharBuffer == null) ? 0L : address(paramCharBuffer.position(), 1, memAddress0(paramCharBuffer)); } public static void memSet(long paramLong1, int paramInt, long paramLong2) { if (Checks.DEBUG && (paramLong1 == 0L || paramLong2 < 0L)) {
/* 1780 */       throw new IllegalArgumentException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1790 */     if (paramLong2 < 256L) {
/* 1791 */       int i = (int)paramLong1;
/* 1792 */       if (Pointer.BITS64) {
/* 1793 */         if ((i & 0x7) == 0) {
/* 1794 */           memSet64(paramLong1, paramInt, (int)paramLong2 & 0xFF);
/*      */           
/*      */           return;
/*      */         } 
/* 1798 */       } else if ((i & 0x3) == 0) {
/* 1799 */         memSet32(i, paramInt, (int)paramLong2 & 0xFF);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 1804 */     LibCString.nmemset(paramLong1, paramInt, paramLong2); }
/*      */   public static long memAddressSafe(IntBuffer paramIntBuffer) { return (paramIntBuffer == null) ? 0L : address(paramIntBuffer.position(), 2, memAddress0(paramIntBuffer)); }
/*      */   public static long memAddressSafe(FloatBuffer paramFloatBuffer) { return (paramFloatBuffer == null) ? 0L : address(paramFloatBuffer.position(), 2, memAddress0(paramFloatBuffer)); }
/* 1807 */   public static long memAddressSafe(LongBuffer paramLongBuffer) { return (paramLongBuffer == null) ? 0L : address(paramLongBuffer.position(), 3, memAddress0(paramLongBuffer)); } public static long memAddressSafe(DoubleBuffer paramDoubleBuffer) { return (paramDoubleBuffer == null) ? 0L : address(paramDoubleBuffer.position(), 3, memAddress0(paramDoubleBuffer)); } public static long memAddressSafe(Pointer paramPointer) { return (paramPointer == null) ? 0L : paramPointer.address(); } public static ByteBuffer memByteBuffer(long paramLong, int paramInt) { if (Checks.CHECKS) Checks.check(paramLong);  return ((ByteBuffer)wrap(BUFFER_BYTE, paramLong, paramInt)).order(NATIVE_ORDER); } public static ByteBuffer memByteBufferSafe(long paramLong, int paramInt) { return (paramLong == 0L) ? null : ((ByteBuffer)wrap(BUFFER_BYTE, paramLong, paramInt)).order(NATIVE_ORDER); } public static ByteBuffer memByteBuffer(ShortBuffer paramShortBuffer) { if (Checks.CHECKS && 1073741823 < paramShortBuffer.remaining()) throw new IllegalArgumentException("The source buffer range is too wide");  return ((ByteBuffer)wrap(BUFFER_BYTE, memAddress(paramShortBuffer), paramShortBuffer.remaining() << 1)).order(NATIVE_ORDER); } public static ByteBuffer memByteBuffer(CharBuffer paramCharBuffer) { if (Checks.CHECKS && 1073741823 < paramCharBuffer.remaining()) throw new IllegalArgumentException("The source buffer range is too wide");  return ((ByteBuffer)wrap(BUFFER_BYTE, memAddress(paramCharBuffer), paramCharBuffer.remaining() << 1)).order(NATIVE_ORDER); } public static ByteBuffer memByteBuffer(IntBuffer paramIntBuffer) { if (Checks.CHECKS && 536870911 < paramIntBuffer.remaining()) throw new IllegalArgumentException("The source buffer range is too wide");  return ((ByteBuffer)wrap(BUFFER_BYTE, memAddress(paramIntBuffer), paramIntBuffer.remaining() << 2)).order(NATIVE_ORDER); } public static ByteBuffer memByteBuffer(LongBuffer paramLongBuffer) { if (Checks.CHECKS && 268435455 < paramLongBuffer.remaining()) throw new IllegalArgumentException("The source buffer range is too wide");  return ((ByteBuffer)wrap(BUFFER_BYTE, memAddress(paramLongBuffer), paramLongBuffer.remaining() << 3)).order(NATIVE_ORDER); } public static ByteBuffer memByteBuffer(FloatBuffer paramFloatBuffer) { if (Checks.CHECKS && 536870911 < paramFloatBuffer.remaining()) throw new IllegalArgumentException("The source buffer range is too wide");  return ((ByteBuffer)wrap(BUFFER_BYTE, memAddress(paramFloatBuffer), paramFloatBuffer.remaining() << 2)).order(NATIVE_ORDER); } public static ByteBuffer memByteBuffer(DoubleBuffer paramDoubleBuffer) { if (Checks.CHECKS && 268435455 < paramDoubleBuffer.remaining()) throw new IllegalArgumentException("The source buffer range is too wide");  return ((ByteBuffer)wrap(BUFFER_BYTE, memAddress(paramDoubleBuffer), paramDoubleBuffer.remaining() << 3)).order(NATIVE_ORDER); } public static ByteBuffer memByteBuffer(CustomBuffer<?> paramCustomBuffer) { if (Checks.CHECKS && Integer.MAX_VALUE / paramCustomBuffer.sizeof() < paramCustomBuffer.remaining()) throw new IllegalArgumentException("The source buffer range is too wide");  return ((ByteBuffer)wrap(BUFFER_BYTE, memAddress(paramCustomBuffer), paramCustomBuffer.remaining() * paramCustomBuffer.sizeof())).order(NATIVE_ORDER); } public static <T extends Struct<T>> ByteBuffer memByteBuffer(T paramT) { return ((ByteBuffer)wrap(BUFFER_BYTE, ((Struct)paramT).address, paramT.sizeof())).order(NATIVE_ORDER); } public static ShortBuffer memShortBuffer(long paramLong, int paramInt) { if (Checks.CHECKS) Checks.check(paramLong);  return wrap(BUFFER_SHORT, paramLong, paramInt); } public static ShortBuffer memShortBufferSafe(long paramLong, int paramInt) { return (paramLong == 0L) ? null : wrap(BUFFER_SHORT, paramLong, paramInt); } public static CharBuffer memCharBuffer(long paramLong, int paramInt) { if (Checks.CHECKS) Checks.check(paramLong);  return wrap(BUFFER_CHAR, paramLong, paramInt); } public static CharBuffer memCharBufferSafe(long paramLong, int paramInt) { return (paramLong == 0L) ? null : wrap(BUFFER_CHAR, paramLong, paramInt); } public static IntBuffer memIntBuffer(long paramLong, int paramInt) { if (Checks.CHECKS) Checks.check(paramLong);  return wrap(BUFFER_INT, paramLong, paramInt); } public static IntBuffer memIntBufferSafe(long paramLong, int paramInt) { return (paramLong == 0L) ? null : wrap(BUFFER_INT, paramLong, paramInt); } public static LongBuffer memLongBuffer(long paramLong, int paramInt) { if (Checks.CHECKS) Checks.check(paramLong);  return wrap(BUFFER_LONG, paramLong, paramInt); } public static LongBuffer memLongBufferSafe(long paramLong, int paramInt) { return (paramLong == 0L) ? null : wrap(BUFFER_LONG, paramLong, paramInt); } public static CLongBuffer memCLongBuffer(long paramLong, int paramInt) { if (Checks.CHECKS) Checks.check(paramLong);  return CLongBuffer.create(paramLong, paramInt); } public static CLongBuffer memCLongBufferSafe(long paramLong, int paramInt) { return (paramLong == 0L) ? null : CLongBuffer.create(paramLong, paramInt); } public static FloatBuffer memFloatBuffer(long paramLong, int paramInt) { if (Checks.CHECKS) Checks.check(paramLong);  return wrap(BUFFER_FLOAT, paramLong, paramInt); } public static FloatBuffer memFloatBufferSafe(long paramLong, int paramInt) { return (paramLong == 0L) ? null : wrap(BUFFER_FLOAT, paramLong, paramInt); } public static DoubleBuffer memDoubleBuffer(long paramLong, int paramInt) { if (Checks.CHECKS) Checks.check(paramLong);  return wrap(BUFFER_DOUBLE, paramLong, paramInt); } public static DoubleBuffer memDoubleBufferSafe(long paramLong, int paramInt) { return (paramLong == 0L) ? null : wrap(BUFFER_DOUBLE, paramLong, paramInt); } public static PointerBuffer memPointerBuffer(long paramLong, int paramInt) { if (Checks.CHECKS) Checks.check(paramLong);  return PointerBuffer.create(paramLong, paramInt); } public static PointerBuffer memPointerBufferSafe(long paramLong, int paramInt) { return (paramLong == 0L) ? null : PointerBuffer.create(paramLong, paramInt); } public static ByteBuffer memDuplicate(ByteBuffer paramByteBuffer) { ByteBuffer byteBuffer; try { byteBuffer = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE); } catch (InstantiationException instantiationException) { throw new UnsupportedOperationException(instantiationException); }  UNSAFE.putLong(byteBuffer, ADDRESS, UNSAFE.getLong(paramByteBuffer, ADDRESS)); UNSAFE.putInt(byteBuffer, MARK, UNSAFE.getInt(paramByteBuffer, MARK)); UNSAFE.putInt(byteBuffer, POSITION, UNSAFE.getInt(paramByteBuffer, POSITION)); UNSAFE.putInt(byteBuffer, LIMIT, UNSAFE.getInt(paramByteBuffer, LIMIT)); UNSAFE.putInt(byteBuffer, CAPACITY, UNSAFE.getInt(paramByteBuffer, CAPACITY)); Object object = UNSAFE.getObject(paramByteBuffer, PARENT_BYTE); UNSAFE.putObject(byteBuffer, PARENT_BYTE, (object == null) ? paramByteBuffer : object); return byteBuffer.order(paramByteBuffer.order()); } public static ShortBuffer memDuplicate(ShortBuffer paramShortBuffer) { return duplicate(BUFFER_SHORT, paramShortBuffer, PARENT_SHORT); } public static CharBuffer memDuplicate(CharBuffer paramCharBuffer) { return duplicate(BUFFER_CHAR, paramCharBuffer, PARENT_CHAR); } public static IntBuffer memDuplicate(IntBuffer paramIntBuffer) { return duplicate(BUFFER_INT, paramIntBuffer, PARENT_INT); } public static LongBuffer memDuplicate(LongBuffer paramLongBuffer) { return duplicate(BUFFER_LONG, paramLongBuffer, PARENT_LONG); } public static FloatBuffer memDuplicate(FloatBuffer paramFloatBuffer) { return duplicate(BUFFER_FLOAT, paramFloatBuffer, PARENT_FLOAT); } public static DoubleBuffer memDuplicate(DoubleBuffer paramDoubleBuffer) { return duplicate(BUFFER_DOUBLE, paramDoubleBuffer, PARENT_DOUBLE); } public static ByteBuffer memSlice(ByteBuffer paramByteBuffer) { return slice(paramByteBuffer, memAddress0(paramByteBuffer) + paramByteBuffer.position(), paramByteBuffer.remaining()); } public static ShortBuffer memSlice(ShortBuffer paramShortBuffer) { return slice(BUFFER_SHORT, paramShortBuffer, address(paramShortBuffer.position(), 1, memAddress0(paramShortBuffer)), paramShortBuffer.remaining(), PARENT_SHORT); } public static CharBuffer memSlice(CharBuffer paramCharBuffer) { return slice(BUFFER_CHAR, paramCharBuffer, address(paramCharBuffer.position(), 1, memAddress0(paramCharBuffer)), paramCharBuffer.remaining(), PARENT_CHAR); } public static IntBuffer memSlice(IntBuffer paramIntBuffer) { return slice(BUFFER_INT, paramIntBuffer, address(paramIntBuffer.position(), 2, memAddress0(paramIntBuffer)), paramIntBuffer.remaining(), PARENT_INT); } public static LongBuffer memSlice(LongBuffer paramLongBuffer) { return slice(BUFFER_LONG, paramLongBuffer, address(paramLongBuffer.position(), 3, memAddress0(paramLongBuffer)), paramLongBuffer.remaining(), PARENT_LONG); } public static FloatBuffer memSlice(FloatBuffer paramFloatBuffer) { return slice(BUFFER_FLOAT, paramFloatBuffer, address(paramFloatBuffer.position(), 2, memAddress0(paramFloatBuffer)), paramFloatBuffer.remaining(), PARENT_FLOAT); } public static DoubleBuffer memSlice(DoubleBuffer paramDoubleBuffer) { return slice(BUFFER_DOUBLE, paramDoubleBuffer, address(paramDoubleBuffer.position(), 3, memAddress0(paramDoubleBuffer)), paramDoubleBuffer.remaining(), PARENT_DOUBLE); } public static ByteBuffer memSlice(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) { int i = paramByteBuffer.position() + paramInt1; if (paramInt1 < 0 || paramByteBuffer.limit() < i) throw new IllegalArgumentException();  if (paramInt2 < 0 || paramByteBuffer.capacity() - i < paramInt2) throw new IllegalArgumentException();  return slice(paramByteBuffer, memAddress0(paramByteBuffer) + i, paramInt2); } public static ShortBuffer memSlice(ShortBuffer paramShortBuffer, int paramInt1, int paramInt2) { int i = paramShortBuffer.position() + paramInt1; if (paramInt1 < 0 || paramShortBuffer.limit() < i) throw new IllegalArgumentException();  if (paramInt2 < 0 || paramShortBuffer.capacity() - i < paramInt2) throw new IllegalArgumentException();  return slice(BUFFER_SHORT, paramShortBuffer, address(i, 1, memAddress0(paramShortBuffer)), paramInt2, PARENT_SHORT); } public static CharBuffer memSlice(CharBuffer paramCharBuffer, int paramInt1, int paramInt2) { int i = paramCharBuffer.position() + paramInt1; if (paramInt1 < 0 || paramCharBuffer.limit() < i) throw new IllegalArgumentException();  if (paramInt2 < 0 || paramCharBuffer.capacity() - i < paramInt2) throw new IllegalArgumentException();  return slice(BUFFER_CHAR, paramCharBuffer, address(i, 1, memAddress0(paramCharBuffer)), paramInt2, PARENT_CHAR); } public static IntBuffer memSlice(IntBuffer paramIntBuffer, int paramInt1, int paramInt2) { int i = paramIntBuffer.position() + paramInt1; if (paramInt1 < 0 || paramIntBuffer.limit() < i) throw new IllegalArgumentException();  if (paramInt2 < 0 || paramIntBuffer.capacity() - i < paramInt2) throw new IllegalArgumentException();  return slice(BUFFER_INT, paramIntBuffer, address(i, 2, memAddress0(paramIntBuffer)), paramInt2, PARENT_INT); } public static LongBuffer memSlice(LongBuffer paramLongBuffer, int paramInt1, int paramInt2) { int i = paramLongBuffer.position() + paramInt1; if (paramInt1 < 0 || paramLongBuffer.limit() < i) throw new IllegalArgumentException();  if (paramInt2 < 0 || paramLongBuffer.capacity() - i < paramInt2) throw new IllegalArgumentException();  return slice(BUFFER_LONG, paramLongBuffer, address(i, 3, memAddress0(paramLongBuffer)), paramInt2, PARENT_LONG); } public static FloatBuffer memSlice(FloatBuffer paramFloatBuffer, int paramInt1, int paramInt2) { int i = paramFloatBuffer.position() + paramInt1; if (paramInt1 < 0 || paramFloatBuffer.limit() < i) throw new IllegalArgumentException();  if (paramInt2 < 0 || paramFloatBuffer.capacity() - i < paramInt2) throw new IllegalArgumentException();  return slice(BUFFER_FLOAT, paramFloatBuffer, address(i, 2, memAddress0(paramFloatBuffer)), paramInt2, PARENT_FLOAT); } public static DoubleBuffer memSlice(DoubleBuffer paramDoubleBuffer, int paramInt1, int paramInt2) { int i = paramDoubleBuffer.position() + paramInt1; if (paramInt1 < 0 || paramDoubleBuffer.limit() < i) throw new IllegalArgumentException();  if (paramInt2 < 0 || paramDoubleBuffer.capacity() - i < paramInt2) throw new IllegalArgumentException();  return slice(BUFFER_DOUBLE, paramDoubleBuffer, address(i, 3, memAddress0(paramDoubleBuffer)), paramInt2, PARENT_DOUBLE); } public static <T extends CustomBuffer<T>> T memSlice(T paramT, int paramInt1, int paramInt2) { return paramT.slice(paramInt1, paramInt2); } public static void memSet(ByteBuffer paramByteBuffer, int paramInt) { memSet(memAddress(paramByteBuffer), paramInt, paramByteBuffer.remaining()); } public static void memSet(ShortBuffer paramShortBuffer, int paramInt) { memSet(memAddress(paramShortBuffer), paramInt, APIUtil.apiGetBytes(paramShortBuffer.remaining(), 1)); } public static void memSet(CharBuffer paramCharBuffer, int paramInt) { memSet(memAddress(paramCharBuffer), paramInt, APIUtil.apiGetBytes(paramCharBuffer.remaining(), 1)); } public static void memSet(IntBuffer paramIntBuffer, int paramInt) { memSet(memAddress(paramIntBuffer), paramInt, APIUtil.apiGetBytes(paramIntBuffer.remaining(), 2)); } public static void memSet(LongBuffer paramLongBuffer, int paramInt) { memSet(memAddress(paramLongBuffer), paramInt, APIUtil.apiGetBytes(paramLongBuffer.remaining(), 3)); } public static void memSet(FloatBuffer paramFloatBuffer, int paramInt) { memSet(memAddress(paramFloatBuffer), paramInt, APIUtil.apiGetBytes(paramFloatBuffer.remaining(), 2)); } public static void memSet(DoubleBuffer paramDoubleBuffer, int paramInt) { memSet(memAddress(paramDoubleBuffer), paramInt, APIUtil.apiGetBytes(paramDoubleBuffer.remaining(), 3)); } public static <T extends CustomBuffer<T>> void memSet(T paramT, int paramInt) { memSet(memAddress((CustomBuffer<?>)paramT), paramInt, Integer.toUnsignedLong(paramT.remaining()) * paramT.sizeof()); } public static <T extends Struct<T>> void memSet(T paramT, int paramInt) { memSet(((Struct)paramT).address, paramInt, paramT.sizeof()); } public static void memCopy(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2) { if (Checks.CHECKS) Checks.check(paramByteBuffer2, paramByteBuffer1.remaining());  MultiReleaseMemCopy.copy(memAddress(paramByteBuffer1), memAddress(paramByteBuffer2), paramByteBuffer1.remaining()); } public static void memCopy(ShortBuffer paramShortBuffer1, ShortBuffer paramShortBuffer2) { if (Checks.CHECKS) Checks.check(paramShortBuffer2, paramShortBuffer1.remaining());  MultiReleaseMemCopy.copy(memAddress(paramShortBuffer1), memAddress(paramShortBuffer2), APIUtil.apiGetBytes(paramShortBuffer1.remaining(), 1)); } public static void memCopy(CharBuffer paramCharBuffer1, CharBuffer paramCharBuffer2) { if (Checks.CHECKS) Checks.check(paramCharBuffer2, paramCharBuffer1.remaining());  MultiReleaseMemCopy.copy(memAddress(paramCharBuffer1), memAddress(paramCharBuffer2), APIUtil.apiGetBytes(paramCharBuffer1.remaining(), 1)); } public static void memCopy(IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2) { if (Checks.CHECKS) Checks.check(paramIntBuffer2, paramIntBuffer1.remaining());  MultiReleaseMemCopy.copy(memAddress(paramIntBuffer1), memAddress(paramIntBuffer2), APIUtil.apiGetBytes(paramIntBuffer1.remaining(), 2)); } public static void memCopy(LongBuffer paramLongBuffer1, LongBuffer paramLongBuffer2) { if (Checks.CHECKS) Checks.check(paramLongBuffer2, paramLongBuffer1.remaining());  MultiReleaseMemCopy.copy(memAddress(paramLongBuffer1), memAddress(paramLongBuffer2), APIUtil.apiGetBytes(paramLongBuffer1.remaining(), 3)); } public static void memCopy(FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2) { if (Checks.CHECKS) Checks.check(paramFloatBuffer2, paramFloatBuffer1.remaining());  MultiReleaseMemCopy.copy(memAddress(paramFloatBuffer1), memAddress(paramFloatBuffer2), APIUtil.apiGetBytes(paramFloatBuffer1.remaining(), 2)); } public static void memCopy(DoubleBuffer paramDoubleBuffer1, DoubleBuffer paramDoubleBuffer2) { if (Checks.CHECKS) Checks.check(paramDoubleBuffer2, paramDoubleBuffer1.remaining());  MultiReleaseMemCopy.copy(memAddress(paramDoubleBuffer1), memAddress(paramDoubleBuffer2), APIUtil.apiGetBytes(paramDoubleBuffer1.remaining(), 3)); } public static <T extends CustomBuffer<T>> void memCopy(T paramT1, T paramT2) { if (Checks.CHECKS) Checks.check((CustomBuffer<?>)paramT2, paramT1.remaining());  MultiReleaseMemCopy.copy(memAddress((CustomBuffer<?>)paramT1), memAddress((CustomBuffer<?>)paramT2), Integer.toUnsignedLong(paramT1.remaining()) * paramT1.sizeof()); } public static <T extends Struct<T>> void memCopy(T paramT1, T paramT2) { MultiReleaseMemCopy.copy(((Struct)paramT1).address, ((Struct)paramT2).address, paramT1.sizeof()); } private static void memSet64(long paramLong, int paramInt1, int paramInt2) { int i = paramInt2 & 0xFFFFFFF8;
/*      */ 
/*      */     
/* 1810 */     long l = (paramInt1 & 0xFF) * FILL_PATTERN_64; byte b;
/* 1811 */     for (b = 0; b < i; b += 8) {
/* 1812 */       UNSAFE.putLong(null, paramLong + b, l);
/*      */     }
/*      */ 
/*      */     
/* 1816 */     b = (byte)paramInt1;
/* 1817 */     for (paramInt1 = i; paramInt1 < paramInt2; paramInt1++)
/* 1818 */       UNSAFE.putByte(null, paramLong + paramInt1, b);  }
/*      */ 
/*      */   
/*      */   private static void memSet32(int paramInt1, int paramInt2, int paramInt3) {
/* 1822 */     int i = paramInt3 & 0xFFFFFFFC;
/*      */ 
/*      */     
/* 1825 */     int j = (paramInt2 & 0xFF) * FILL_PATTERN_32; byte b;
/* 1826 */     for (b = 0; b < i; b += 4) {
/* 1827 */       UNSAFE.putInt(null, (paramInt1 + b) & 0xFFFFFFFFL, j);
/*      */     }
/*      */ 
/*      */     
/* 1831 */     b = (byte)paramInt2;
/* 1832 */     for (paramInt2 = i; paramInt2 < paramInt3; paramInt2++) {
/* 1833 */       UNSAFE.putByte(null, (paramInt1 + paramInt2) & 0xFFFFFFFFL, b);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(long paramLong1, long paramLong2, long paramLong3) {
/* 1845 */     if (Checks.DEBUG && (paramLong1 == 0L || paramLong2 == 0L || paramLong3 < 0L)) {
/* 1846 */       throw new IllegalArgumentException();
/*      */     }
/*      */     
/* 1849 */     MultiReleaseMemCopy.copy(paramLong1, paramLong2, paramLong3);
/*      */   }
/*      */   
/*      */   static void memCopyAligned64(long paramLong1, long paramLong2, int paramInt) {
/* 1853 */     int i = paramInt & 0xFFFFFFF8;
/*      */     
/*      */     int j;
/* 1856 */     for (j = 0; j < i; j += 8) {
/* 1857 */       UNSAFE.putLong(null, paramLong2 + j, UNSAFE.getLong(null, paramLong1 + j));
/*      */     }
/*      */ 
/*      */     
/* 1861 */     for (j = i; j < paramInt; j++)
/* 1862 */       UNSAFE.putByte(null, paramLong2 + j, UNSAFE.getByte(null, paramLong1 + j)); 
/*      */   }
/*      */   
/*      */   static void memCopyAligned32(int paramInt1, int paramInt2, int paramInt3) {
/* 1866 */     int i = paramInt3 & 0xFFFFFFFC;
/*      */     
/*      */     int j;
/* 1869 */     for (j = 0; j < i; j += 4) {
/* 1870 */       UNSAFE.putInt(null, (paramInt2 + j) & 0xFFFFFFFFL, UNSAFE.getInt(null, (paramInt1 + j) & 0xFFFFFFFFL));
/*      */     }
/*      */ 
/*      */     
/* 1874 */     for (j = i; j < paramInt3; j++)
/* 1875 */       UNSAFE.putByte(null, (paramInt2 + j) & 0xFFFFFFFFL, UNSAFE.getByte(null, (paramInt1 + j) & 0xFFFFFFFFL)); 
/*      */   }
/*      */   
/*      */   public static boolean memGetBoolean(long paramLong) {
/* 1879 */     return (UNSAFE.getByte(null, paramLong) != 0);
/* 1880 */   } public static byte memGetByte(long paramLong) { return UNSAFE.getByte(null, paramLong); }
/* 1881 */   public static short memGetShort(long paramLong) { return UNSAFE.getShort(null, paramLong); }
/* 1882 */   public static int memGetInt(long paramLong) { return UNSAFE.getInt(null, paramLong); }
/* 1883 */   public static long memGetLong(long paramLong) { return UNSAFE.getLong(null, paramLong); }
/* 1884 */   public static float memGetFloat(long paramLong) { return UNSAFE.getFloat(null, paramLong); } public static double memGetDouble(long paramLong) {
/* 1885 */     return UNSAFE.getDouble(null, paramLong);
/*      */   } public static long memGetCLong(long paramLong) {
/* 1887 */     if (Pointer.CLONG_SIZE == 8)
/* 1888 */       return UNSAFE.getLong(null, paramLong);  return UNSAFE
/* 1889 */       .getInt(null, paramLong);
/*      */   }
/*      */   
/*      */   public static long memGetAddress(long paramLong) {
/* 1893 */     if (Pointer.BITS64)
/* 1894 */       return UNSAFE.getLong(null, paramLong);  return UNSAFE
/* 1895 */       .getInt(null, paramLong) & 0xFFFFFFFFL;
/*      */   }
/*      */   
/* 1898 */   public static void memPutByte(long paramLong, byte paramByte) { UNSAFE.putByte(null, paramLong, paramByte); }
/* 1899 */   public static void memPutShort(long paramLong, short paramShort) { UNSAFE.putShort(null, paramLong, paramShort); }
/* 1900 */   public static void memPutInt(long paramLong, int paramInt) { UNSAFE.putInt(null, paramLong, paramInt); }
/* 1901 */   public static void memPutLong(long paramLong1, long paramLong2) { UNSAFE.putLong(null, paramLong1, paramLong2); }
/* 1902 */   public static void memPutFloat(long paramLong, float paramFloat) { UNSAFE.putFloat(null, paramLong, paramFloat); } public static void memPutDouble(long paramLong, double paramDouble) {
/* 1903 */     UNSAFE.putDouble(null, paramLong, paramDouble);
/*      */   } public static void memPutCLong(long paramLong1, long paramLong2) {
/* 1905 */     if (Pointer.CLONG_SIZE == 8) {
/* 1906 */       UNSAFE.putLong(null, paramLong1, paramLong2); return;
/*      */     } 
/* 1908 */     UNSAFE.putInt(null, paramLong1, (int)paramLong2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void memPutAddress(long paramLong1, long paramLong2) {
/* 1913 */     if (Pointer.BITS64) {
/* 1914 */       UNSAFE.putLong(null, paramLong1, paramLong2); return;
/*      */     } 
/* 1916 */     UNSAFE.putInt(null, paramLong1, (int)paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int write8(long paramLong, int paramInt1, int paramInt2) {
/* 1943 */     UNSAFE.putByte(null, paramLong + Integer.toUnsignedLong(paramInt1), (byte)paramInt2);
/* 1944 */     return paramInt1 + 1;
/*      */   }
/*      */   private static int write8Safe(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/* 1947 */     if (paramInt1 == paramInt2) {
/* 1948 */       throw new BufferOverflowException();
/*      */     }
/* 1950 */     UNSAFE.putByte(null, paramLong + Integer.toUnsignedLong(paramInt1), (byte)paramInt3);
/* 1951 */     return paramInt1 + 1;
/*      */   }
/*      */   private static int write16(long paramLong, int paramInt, char paramChar) {
/* 1954 */     UNSAFE.putShort(null, paramLong + Integer.toUnsignedLong(paramInt), (short)paramChar);
/* 1955 */     return paramInt + 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memASCII(CharSequence paramCharSequence) {
/* 1968 */     return memASCII(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memASCIISafe(CharSequence paramCharSequence) {
/* 1974 */     return (paramCharSequence == null) ? null : memASCII(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memASCII(CharSequence paramCharSequence, boolean paramBoolean) {
/*      */     int i;
/* 1989 */     long l = nmemAlloc((i = memLengthASCII(paramCharSequence, paramBoolean)));
/* 1990 */     if (Checks.CHECKS && l == 0L) {
/* 1991 */       throw new OutOfMemoryError();
/*      */     }
/* 1993 */     encodeASCIIUnsafe(paramCharSequence, paramBoolean, l);
/* 1994 */     return ((ByteBuffer)wrap(BUFFER_BYTE, l, i)).order(NATIVE_ORDER);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memASCIISafe(CharSequence paramCharSequence, boolean paramBoolean) {
/* 2000 */     return (paramCharSequence == null) ? null : memASCII(paramCharSequence, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memASCII(CharSequence paramCharSequence, boolean paramBoolean, ByteBuffer paramByteBuffer) {
/* 2016 */     if (paramByteBuffer.remaining() < memLengthASCII(paramCharSequence, paramBoolean)) {
/* 2017 */       throw new BufferOverflowException();
/*      */     }
/* 2019 */     long l = memAddress(paramByteBuffer);
/* 2020 */     return encodeASCIIUnsafe(paramCharSequence, paramBoolean, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memASCII(CharSequence paramCharSequence, boolean paramBoolean, ByteBuffer paramByteBuffer, int paramInt) {
/* 2036 */     if (paramByteBuffer.capacity() - paramInt < memLengthASCII(paramCharSequence, paramBoolean)) {
/* 2037 */       throw new BufferOverflowException();
/*      */     }
/* 2039 */     return encodeASCIIUnsafe(paramCharSequence, paramBoolean, memAddress(paramByteBuffer, paramInt));
/*      */   }
/*      */   
/*      */   static int encodeASCIIUnsafe(CharSequence paramCharSequence, boolean paramBoolean, long paramLong) {
/* 2043 */     int i = 0, j = paramCharSequence.length();
/*      */     
/* 2045 */     while (i < j) {
/* 2046 */       i = write8(paramLong, i, paramCharSequence.charAt(i));
/*      */     }
/*      */     
/* 2049 */     if (paramBoolean) {
/* 2050 */       i = write8(paramLong, i, 0);
/*      */     }
/*      */     
/* 2053 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memLengthASCII(CharSequence paramCharSequence, boolean paramBoolean) {
/*      */     int i;
/* 2068 */     if ((i = paramCharSequence.length() + (paramBoolean ? 1 : 0)) < 0) {
/* 2069 */       throw new BufferOverflowException();
/*      */     }
/* 2071 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF8(CharSequence paramCharSequence) {
/* 2084 */     return memUTF8(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF8Safe(CharSequence paramCharSequence) {
/* 2090 */     return (paramCharSequence == null) ? null : memUTF8(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF8(CharSequence paramCharSequence, boolean paramBoolean) {
/*      */     int i;
/* 2105 */     long l = nmemAlloc((i = memLengthUTF8(paramCharSequence, paramBoolean)));
/* 2106 */     if (Checks.CHECKS && l == 0L) {
/* 2107 */       throw new OutOfMemoryError();
/*      */     }
/* 2109 */     encodeUTF8Unsafe(paramCharSequence, paramBoolean, l);
/* 2110 */     return ((ByteBuffer)wrap(BUFFER_BYTE, l, i)).order(NATIVE_ORDER);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF8Safe(CharSequence paramCharSequence, boolean paramBoolean) {
/* 2116 */     return (paramCharSequence == null) ? null : memUTF8(paramCharSequence, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memUTF8(CharSequence paramCharSequence, boolean paramBoolean, ByteBuffer paramByteBuffer) {
/* 2132 */     if (paramByteBuffer.remaining() < memLengthASCII(paramCharSequence, paramBoolean)) {
/* 2133 */       throw new BufferOverflowException();
/*      */     }
/* 2135 */     return encodeUTF8Safe(paramCharSequence, paramBoolean, memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memUTF8(CharSequence paramCharSequence, boolean paramBoolean, ByteBuffer paramByteBuffer, int paramInt) {
/* 2152 */     if (paramByteBuffer.capacity() - paramInt < memLengthASCII(paramCharSequence, paramBoolean)) {
/* 2153 */       throw new BufferOverflowException();
/*      */     }
/* 2155 */     return encodeUTF8Safe(paramCharSequence, paramBoolean, memAddress(paramByteBuffer, paramInt), paramByteBuffer.capacity() - paramInt);
/*      */   }
/*      */   
/*      */   static int encodeUTF8Unsafe(CharSequence paramCharSequence, boolean paramBoolean, long paramLong) {
/* 2159 */     int i = 0; byte b = 0; int j = paramCharSequence.length();
/*      */     
/* 2161 */     while (b < j) {
/*      */       char c;
/* 2163 */       if ((c = paramCharSequence.charAt(b++)) < '') {
/* 2164 */         i = write8(paramLong, i, c); continue;
/*      */       } 
/* 2166 */       int k = c;
/* 2167 */       if (c < 'ࠀ') {
/* 2168 */         i = write8(paramLong, i, 0xC0 | k >> 6);
/*      */       } else {
/* 2170 */         if (!Character.isHighSurrogate(c)) {
/* 2171 */           i = write8(paramLong, i, 0xE0 | k >> 12);
/*      */         } else {
/* 2173 */           k = Character.toCodePoint(c, paramCharSequence.charAt(b++));
/*      */           
/* 2175 */           i = write8(paramLong, i, 0xF0 | k >> 18);
/* 2176 */           i = write8(paramLong, i, 0x80 | k >> 12 & 0x3F);
/*      */         } 
/* 2178 */         i = write8(paramLong, i, 0x80 | k >> 6 & 0x3F);
/*      */       } 
/* 2180 */       i = write8(paramLong, i, 0x80 | k & 0x3F);
/*      */     } 
/*      */ 
/*      */     
/* 2184 */     if (paramBoolean) {
/* 2185 */       i = write8(paramLong, i, 0);
/*      */     }
/*      */     
/* 2188 */     return i;
/*      */   }
/*      */   
/*      */   static int encodeUTF8Safe(CharSequence paramCharSequence, boolean paramBoolean, long paramLong, int paramInt) {
/* 2192 */     int i = 0; byte b = 0; int j = paramCharSequence.length();
/*      */ 
/*      */     
/* 2195 */     while (b < j) {
/* 2196 */       char c = paramCharSequence.charAt(b);
/* 2197 */       if ('' > c) {
/*      */ 
/*      */         
/* 2200 */         i = write8(paramLong, i, c);
/* 2201 */         b++;
/*      */       } 
/*      */     } 
/*      */     
/* 2205 */     while (b < j) {
/*      */       char c;
/* 2207 */       if ((c = paramCharSequence.charAt(b++)) < '') {
/* 2208 */         i = write8Safe(paramLong, i, paramInt, c); continue;
/*      */       } 
/* 2210 */       int k = c;
/* 2211 */       if (c < 'ࠀ') {
/* 2212 */         i = write8Safe(paramLong, i, paramInt, 0xC0 | k >> 6);
/*      */       } else {
/* 2214 */         if (!Character.isHighSurrogate(c)) {
/* 2215 */           i = write8Safe(paramLong, i, paramInt, 0xE0 | k >> 12);
/*      */         } else {
/* 2217 */           k = Character.toCodePoint(c, paramCharSequence.charAt(b++));
/*      */           
/* 2219 */           i = write8Safe(paramLong, i, paramInt, 0xF0 | k >> 18);
/* 2220 */           i = write8Safe(paramLong, i, paramInt, 0x80 | k >> 12 & 0x3F);
/*      */         } 
/* 2222 */         i = write8Safe(paramLong, i, paramInt, 0x80 | k >> 6 & 0x3F);
/*      */       } 
/* 2224 */       i = write8Safe(paramLong, i, paramInt, 0x80 | k & 0x3F);
/*      */     } 
/*      */ 
/*      */     
/* 2228 */     if (paramBoolean) {
/* 2229 */       i = write8Safe(paramLong, i, paramInt, 0);
/*      */     }
/*      */     
/* 2232 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memLengthUTF8(CharSequence paramCharSequence, boolean paramBoolean) {
/* 2247 */     int j, i = (j = paramCharSequence.length()) + (paramBoolean ? 1 : 0);
/*      */     
/* 2249 */     for (byte b = 0; b < j; b++) {
/*      */       char c;
/*      */       
/* 2252 */       if ((c = paramCharSequence.charAt(b)) >= '') {
/*      */ 
/*      */         
/* 2255 */         if (c < 'ࠀ') {
/*      */ 
/*      */           
/* 2258 */           i += 127 - c >>> 31;
/*      */         }
/*      */         else {
/*      */           
/* 2262 */           i += 2;
/* 2263 */           if (Character.isHighSurrogate(c)) {
/* 2264 */             b++;
/*      */           }
/*      */         } 
/* 2267 */         if (i < 0) {
/* 2268 */           throw new BufferOverflowException();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2273 */     if (i < 0) {
/* 2274 */       throw new BufferOverflowException();
/*      */     }
/*      */     
/* 2277 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF16(CharSequence paramCharSequence) {
/* 2290 */     return memUTF16(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF16Safe(CharSequence paramCharSequence) {
/* 2296 */     return (paramCharSequence == null) ? null : memUTF16(paramCharSequence, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF16(CharSequence paramCharSequence, boolean paramBoolean) {
/*      */     int i;
/* 2311 */     long l = nmemAlloc((i = memLengthUTF16(paramCharSequence, paramBoolean)));
/* 2312 */     if (Checks.CHECKS && l == 0L) {
/* 2313 */       throw new OutOfMemoryError();
/*      */     }
/* 2315 */     encodeUTF16Unsafe(paramCharSequence, paramBoolean, l);
/* 2316 */     return ((ByteBuffer)wrap(BUFFER_BYTE, l, i)).order(NATIVE_ORDER);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF16Safe(CharSequence paramCharSequence, boolean paramBoolean) {
/* 2322 */     return (paramCharSequence == null) ? null : memUTF16(paramCharSequence, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memUTF16(CharSequence paramCharSequence, boolean paramBoolean, ByteBuffer paramByteBuffer) {
/* 2339 */     if (paramByteBuffer.remaining() < memLengthUTF16(paramCharSequence, paramBoolean)) {
/* 2340 */       throw new BufferOverflowException();
/*      */     }
/* 2342 */     long l = memAddress(paramByteBuffer);
/* 2343 */     return encodeUTF16Unsafe(paramCharSequence, paramBoolean, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memUTF16(CharSequence paramCharSequence, boolean paramBoolean, ByteBuffer paramByteBuffer, int paramInt) {
/* 2361 */     if (paramByteBuffer.capacity() - paramInt < memLengthUTF16(paramCharSequence, paramBoolean)) {
/* 2362 */       throw new BufferOverflowException();
/*      */     }
/* 2364 */     long l = memAddress(paramByteBuffer, paramInt);
/* 2365 */     return encodeUTF16Unsafe(paramCharSequence, paramBoolean, l);
/*      */   }
/*      */   
/*      */   static int encodeUTF16Unsafe(CharSequence paramCharSequence, boolean paramBoolean, long paramLong) {
/* 2369 */     int i = 0; byte b = 0; int j = paramCharSequence.length();
/*      */     
/* 2371 */     while (b < j) {
/* 2372 */       i = write16(paramLong, i, paramCharSequence.charAt(b++));
/*      */     }
/*      */     
/* 2375 */     if (paramBoolean) {
/* 2376 */       i = write16(paramLong, i, false);
/*      */     }
/*      */     
/* 2379 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memLengthUTF16(CharSequence paramCharSequence, boolean paramBoolean) {
/*      */     int i;
/* 2392 */     if ((i = paramCharSequence.length() + (paramBoolean ? 1 : 0)) < 0 || 1073741823 < i) {
/* 2393 */       throw new BufferOverflowException();
/*      */     }
/* 2395 */     return i << 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int memLengthNT1(long paramLong, int paramInt) {
/* 2405 */     if (Checks.CHECKS) {
/* 2406 */       Checks.check(paramLong);
/*      */     }
/* 2408 */     if (Pointer.BITS64)
/* 2409 */       return strlen64NT1(paramLong, paramInt); 
/* 2410 */     return strlen32NT1(paramLong, paramInt);
/*      */   }
/*      */   
/*      */   private static int strlen64NT1(long paramLong, int paramInt) {
/* 2414 */     byte b = 0;
/*      */     
/* 2416 */     if (8 <= paramInt) {
/*      */       int i;
/* 2418 */       if ((i = (int)paramLong & 0x7) != 0)
/*      */       {
/* 2420 */         for (i = 8 - i; b < i; b++) {
/* 2421 */           if (UNSAFE.getByte(null, paramLong + b) == 0) {
/* 2422 */             return b;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 2428 */       for (; b <= paramInt - 8 && 
/* 2429 */         !MathUtil.mathHasZeroByte(UNSAFE.getLong(null, paramLong + b)); b += 8);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2436 */     for (; b < paramInt && 
/* 2437 */       UNSAFE.getByte(null, paramLong + b) != 0; b++);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2442 */     return b;
/*      */   }
/*      */   
/*      */   private static int strlen32NT1(long paramLong, int paramInt) {
/* 2446 */     byte b = 0;
/*      */     
/* 2448 */     if (4 <= paramInt) {
/*      */       int i;
/* 2450 */       if ((i = (int)paramLong & 0x3) != 0)
/*      */       {
/* 2452 */         for (i = 4 - i; b < i; b++) {
/* 2453 */           if (UNSAFE.getByte(null, paramLong + b) == 0) {
/* 2454 */             return b;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 2460 */       for (; b <= paramInt - 4 && 
/* 2461 */         !MathUtil.mathHasZeroByte(UNSAFE.getInt(null, paramLong + b)); b += 4);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2468 */     for (; b < paramInt && 
/* 2469 */       UNSAFE.getByte(null, paramLong + b) != 0; b++);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2474 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memLengthNT1(ByteBuffer paramByteBuffer) {
/* 2488 */     return memLengthNT1(memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*      */   }
/*      */   
/*      */   private static int memLengthNT2(long paramLong, int paramInt) {
/* 2492 */     if (Checks.CHECKS) {
/* 2493 */       Checks.check(paramLong);
/*      */     }
/* 2495 */     if (Pointer.BITS64)
/* 2496 */       return strlen64NT2(paramLong, paramInt); 
/* 2497 */     return strlen32NT2((int)paramLong, paramInt);
/*      */   }
/*      */   
/*      */   private static int strlen64NT2(long paramLong, int paramInt) {
/* 2501 */     byte b = 0;
/*      */     
/* 2503 */     if (8 <= paramInt) {
/*      */       int i;
/* 2505 */       if ((i = (int)paramLong & 0x7) != 0)
/*      */       {
/* 2507 */         for (i = 8 - i; b < i; b += 2) {
/* 2508 */           if (UNSAFE.getShort(null, paramLong + b) == 0) {
/* 2509 */             return b;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 2515 */       for (; b <= paramInt - 8 && 
/* 2516 */         !MathUtil.mathHasZeroShort(UNSAFE.getLong(null, paramLong + b)); b += 8);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2523 */     for (; b < paramInt && 
/* 2524 */       UNSAFE.getShort(null, paramLong + b) != 0; b += 2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2529 */     return b;
/*      */   }
/*      */   
/*      */   private static int strlen32NT2(long paramLong, int paramInt) {
/* 2533 */     byte b = 0;
/*      */     
/* 2535 */     if (4 <= paramInt) {
/*      */       int i;
/* 2537 */       if ((i = (int)paramLong & 0x3) != 0)
/*      */       {
/* 2539 */         for (i = 4 - i; b < i; b += 2) {
/* 2540 */           if (UNSAFE.getShort(null, paramLong + b) == 0) {
/* 2541 */             return b;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 2547 */       while (b <= paramInt - 4 && 
/* 2548 */         !MathUtil.mathHasZeroShort(UNSAFE.getInt(null, paramLong + b)))
/*      */       {
/*      */         
/* 2551 */         b += 4;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2556 */     for (; b < paramInt && 
/* 2557 */       UNSAFE.getShort(null, paramLong + b) != 0; b += 2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2562 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memLengthNT2(ByteBuffer paramByteBuffer) {
/* 2576 */     return memLengthNT2(memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT1(long paramLong) {
/* 2590 */     return memByteBuffer(paramLong, memLengthNT1(paramLong, 2147483647));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT1(long paramLong, int paramInt) {
/* 2605 */     return memByteBuffer(paramLong, memLengthNT1(paramLong, paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT1Safe(long paramLong) {
/* 2611 */     return (paramLong == 0L) ? null : memByteBuffer(paramLong, memLengthNT1(paramLong, 2147483647));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT1Safe(long paramLong, int paramInt) {
/* 2617 */     return (paramLong == 0L) ? null : memByteBuffer(paramLong, memLengthNT1(paramLong, paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT2(long paramLong) {
/* 2631 */     return memByteBufferNT2(paramLong, 2147483646);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT2(long paramLong, int paramInt) {
/* 2645 */     if (Checks.DEBUG && (
/* 2646 */       paramInt & 0x1) != 0) {
/* 2647 */       throw new IllegalArgumentException("The maximum length must be an even number.");
/*      */     }
/*      */     
/* 2650 */     return memByteBuffer(paramLong, memLengthNT2(paramLong, paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT2Safe(long paramLong) {
/* 2656 */     return (paramLong == 0L) ? null : memByteBufferNT2(paramLong, 2147483646);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT2Safe(long paramLong, int paramInt) {
/* 2662 */     return (paramLong == 0L) ? null : memByteBufferNT2(paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCII(long paramLong) {
/* 2673 */     return memASCII(paramLong, memLengthNT1(paramLong, 2147483647));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCII(long paramLong, int paramInt) {
/* 2686 */     if (paramInt <= 0) {
/* 2687 */       return "";
/*      */     }
/*      */     
/* 2690 */     byte[] arrayOfByte = (paramInt <= ARRAY_TLC_SIZE) ? ARRAY_TLC_BYTE.get() : new byte[paramInt];
/* 2691 */     memByteBuffer(paramLong, paramInt).get(arrayOfByte, 0, paramInt);
/* 2692 */     return new String(arrayOfByte, 0, 0, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCII(ByteBuffer paramByteBuffer) {
/* 2705 */     return memASCII(memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCIISafe(long paramLong) {
/* 2711 */     return (paramLong == 0L) ? null : memASCII(paramLong, memLengthNT1(paramLong, 2147483647));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCIISafe(long paramLong, int paramInt) {
/* 2717 */     return (paramLong == 0L) ? null : memASCII(paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCIISafe(ByteBuffer paramByteBuffer) {
/* 2723 */     return (paramByteBuffer == null) ? null : memASCII(memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCII(ByteBuffer paramByteBuffer, int paramInt) {
/* 2737 */     return memASCII(memAddress(paramByteBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCII(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 2752 */     return memASCII(memAddress(paramByteBuffer, paramInt2), paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8(long paramLong) {
/* 2763 */     return MultiReleaseTextDecoding.decodeUTF8(paramLong, memLengthNT1(paramLong, 2147483647));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8(long paramLong, int paramInt) {
/* 2775 */     return MultiReleaseTextDecoding.decodeUTF8(paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8(ByteBuffer paramByteBuffer) {
/* 2788 */     return MultiReleaseTextDecoding.decodeUTF8(memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8Safe(long paramLong) {
/* 2794 */     return (paramLong == 0L) ? null : MultiReleaseTextDecoding.decodeUTF8(paramLong, memLengthNT1(paramLong, 2147483647));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8Safe(long paramLong, int paramInt) {
/* 2800 */     return (paramLong == 0L) ? null : MultiReleaseTextDecoding.decodeUTF8(paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8Safe(ByteBuffer paramByteBuffer) {
/* 2806 */     return (paramByteBuffer == null) ? null : MultiReleaseTextDecoding.decodeUTF8(memAddress(paramByteBuffer), paramByteBuffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8(ByteBuffer paramByteBuffer, int paramInt) {
/* 2820 */     return MultiReleaseTextDecoding.decodeUTF8(memAddress(paramByteBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 2835 */     return MultiReleaseTextDecoding.decodeUTF8(memAddress(paramByteBuffer, paramInt2), paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16(long paramLong) {
/* 2846 */     return memUTF16(paramLong, memLengthNT2(paramLong, 2147483646) >> 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16(long paramLong, int paramInt) {
/*      */     byte[] arrayOfByte;
/* 2858 */     if (paramInt <= 0) {
/* 2859 */       return "";
/*      */     }
/*      */     
/* 2862 */     if (Checks.DEBUG) {
/*      */       int i;
/*      */       
/* 2865 */       arrayOfByte = ((i = paramInt << 1) <= ARRAY_TLC_SIZE) ? ARRAY_TLC_BYTE.get() : new byte[i];
/* 2866 */       memByteBuffer(paramLong, i).get(arrayOfByte, 0, i);
/* 2867 */       return new String(arrayOfByte, 0, i, UTF16);
/*      */     } 
/*      */     
/* 2870 */     char[] arrayOfChar = (arrayOfByte <= ARRAY_TLC_SIZE) ? ARRAY_TLC_CHAR.get() : new char[arrayOfByte];
/* 2871 */     memCharBuffer(paramLong, arrayOfByte).get(arrayOfChar, 0, arrayOfByte);
/* 2872 */     return new String(arrayOfChar, 0, arrayOfByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16(ByteBuffer paramByteBuffer) {
/* 2885 */     return memUTF16(memAddress(paramByteBuffer), paramByteBuffer.remaining() >> 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16Safe(long paramLong) {
/* 2891 */     return (paramLong == 0L) ? null : memUTF16(paramLong, memLengthNT2(paramLong, 2147483646) >> 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16Safe(long paramLong, int paramInt) {
/* 2897 */     return (paramLong == 0L) ? null : memUTF16(paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16Safe(ByteBuffer paramByteBuffer) {
/* 2903 */     return (paramByteBuffer == null) ? null : memUTF16(memAddress(paramByteBuffer), paramByteBuffer.remaining() >> 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16(ByteBuffer paramByteBuffer, int paramInt) {
/* 2917 */     return memUTF16(memAddress(paramByteBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 2932 */     return memUTF16(memAddress(paramByteBuffer, paramInt2), paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Unsafe getUnsafeInstance() {
/*      */     Field[] arrayOfField;
/*      */     int i;
/*      */     byte b;
/* 2950 */     for (i = (arrayOfField = arrayOfField = Unsafe.class.getDeclaredFields()).length, b = 0; b < i; b++) {
/* 2951 */       Field field; if ((field = arrayOfField[b]).getType().equals(Unsafe.class)) {
/*      */         int j;
/*      */ 
/*      */ 
/*      */         
/* 2956 */         if (Modifier.isStatic(j = field.getModifiers()) && Modifier.isFinal(j))
/*      */           
/*      */           try {
/*      */ 
/*      */             
/* 2961 */             field.setAccessible(true);
/* 2962 */             return (Unsafe)field.get(null);
/* 2963 */           } catch (Exception exception) {
/*      */             break;
/*      */           }  
/*      */       } 
/*      */     } 
/* 2968 */     throw new UnsupportedOperationException("LWJGL requires sun.misc.Unsafe to be available.");
/*      */   }
/*      */   
/*      */   private static long getFieldOffset(Class<?> paramClass1, Class<?> paramClass2, LongPredicate paramLongPredicate) {
/* 2972 */     paramClass1 = paramClass1;
/* 2973 */     while (paramClass1 != Object.class) {
/*      */       Field[] arrayOfField; int i; byte b;
/* 2975 */       for (i = (arrayOfField = arrayOfField = paramClass1.getDeclaredFields()).length, b = 0; b < i; ) {
/* 2976 */         Field field; if ((field = arrayOfField[b]).getType().isAssignableFrom(paramClass2) && !Modifier.isStatic(field.getModifiers()) && !field.isSynthetic()) {
/*      */ 
/*      */ 
/*      */           
/* 2980 */           long l = UNSAFE.objectFieldOffset(field);
/* 2981 */           if (paramLongPredicate.test(l))
/* 2982 */             return l; 
/*      */         }  b++;
/*      */       } 
/* 2985 */       paramClass1 = paramClass1.getSuperclass();
/*      */     } 
/* 2987 */     throw new UnsupportedOperationException("Failed to find field offset in class.");
/*      */   }
/*      */   
/*      */   private static long getFieldOffsetInt(Object paramObject, int paramInt) {
/* 2991 */     return getFieldOffset(paramObject.getClass(), int.class, paramLong -> (UNSAFE.getInt(paramObject, paramLong) == paramInt));
/*      */   }
/*      */   
/*      */   private static long getFieldOffsetObject(Object paramObject1, Object paramObject2) {
/* 2995 */     return getFieldOffset(paramObject1.getClass(), paramObject2.getClass(), paramLong -> (UNSAFE.getObject(paramObject1, paramLong) == paramObject2));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static long getAddressOffset() {
/*      */     long l;
/*      */     ByteBuffer byteBuffer;
/* 3003 */     return getFieldOffset((byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(l = 0xDEADBEEF8BADF00DL & (Pointer.BITS32 ? 4294967295L : -1L), 0L))).getClass(), long.class, paramLong2 -> (UNSAFE.getLong(paramByteBuffer, paramLong2) == paramLong1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long getMarkOffset() {
/*      */     ByteBuffer byteBuffer;
/* 3011 */     return getFieldOffsetInt(byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(1L, 0L)), -1);
/*      */   }
/*      */   
/*      */   private static long getPositionOffset() {
/*      */     ByteBuffer byteBuffer;
/* 3016 */     (byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L))).position(16435934);
/* 3017 */     return getFieldOffsetInt(byteBuffer, 16435934);
/*      */   }
/*      */   
/*      */   private static long getLimitOffset() {
/*      */     ByteBuffer byteBuffer;
/* 3022 */     (byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L))).limit(16435934);
/* 3023 */     return getFieldOffsetInt(byteBuffer, 16435934);
/*      */   }
/*      */   
/*      */   private static long getCapacityOffset() {
/*      */     ByteBuffer byteBuffer;
/* 3028 */     (byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L))).limit(0);
/* 3029 */     return getFieldOffsetInt(byteBuffer, 219540062);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static <T extends Buffer> T wrap(Class<? extends T> paramClass, long paramLong, int paramInt) {
/*      */     try {
/* 3036 */       Buffer buffer = (Buffer)UNSAFE.allocateInstance(paramClass);
/* 3037 */     } catch (InstantiationException instantiationException) {
/* 3038 */       throw new UnsupportedOperationException(instantiationException);
/*      */     } 
/*      */     
/* 3041 */     UNSAFE.putLong(instantiationException, ADDRESS, paramLong);
/* 3042 */     UNSAFE.putInt(instantiationException, MARK, -1);
/* 3043 */     UNSAFE.putInt(instantiationException, LIMIT, paramInt);
/* 3044 */     UNSAFE.putInt(instantiationException, CAPACITY, paramInt);
/*      */     
/* 3046 */     return (T)instantiationException;
/*      */   }
/*      */   
/*      */   static ByteBuffer slice(ByteBuffer paramByteBuffer, long paramLong, int paramInt) {
/*      */     ByteBuffer byteBuffer;
/*      */     try {
/* 3052 */       byteBuffer = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
/* 3053 */     } catch (InstantiationException instantiationException) {
/* 3054 */       throw new UnsupportedOperationException(instantiationException);
/*      */     } 
/*      */     
/* 3057 */     UNSAFE.putLong(byteBuffer, ADDRESS, instantiationException);
/* 3058 */     UNSAFE.putInt(byteBuffer, MARK, -1);
/* 3059 */     UNSAFE.putInt(byteBuffer, LIMIT, paramInt);
/* 3060 */     UNSAFE.putInt(byteBuffer, CAPACITY, paramInt);
/*      */     
/* 3062 */     Object object = UNSAFE.getObject(paramByteBuffer, PARENT_BYTE);
/* 3063 */     UNSAFE.putObject(byteBuffer, PARENT_BYTE, (object == null) ? paramByteBuffer : object);
/*      */     
/* 3065 */     return byteBuffer.order(paramByteBuffer.order());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static <T extends Buffer> T slice(Class<? extends T> paramClass, T paramT, long paramLong1, int paramInt, long paramLong2) {
/*      */     try {
/* 3072 */       Buffer buffer = (Buffer)UNSAFE.allocateInstance(paramClass);
/* 3073 */     } catch (InstantiationException instantiationException) {
/* 3074 */       throw new UnsupportedOperationException(instantiationException);
/*      */     } 
/*      */     
/* 3077 */     UNSAFE.putLong(instantiationException, ADDRESS, paramLong1);
/* 3078 */     UNSAFE.putInt(instantiationException, MARK, -1);
/* 3079 */     UNSAFE.putInt(instantiationException, LIMIT, paramInt);
/* 3080 */     UNSAFE.putInt(instantiationException, CAPACITY, paramInt);
/*      */     
/* 3082 */     UNSAFE.putObject(instantiationException, paramLong2, UNSAFE.getObject(paramT, paramLong2));
/*      */     
/* 3084 */     return (T)instantiationException;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static <T extends Buffer> T duplicate(Class<? extends T> paramClass, T paramT, long paramLong) {
/*      */     try {
/* 3091 */       Buffer buffer = (Buffer)UNSAFE.allocateInstance(paramClass);
/* 3092 */     } catch (InstantiationException instantiationException) {
/* 3093 */       throw new UnsupportedOperationException(instantiationException);
/*      */     } 
/*      */     
/* 3096 */     UNSAFE.putLong(instantiationException, ADDRESS, UNSAFE.getLong(paramT, ADDRESS));
/* 3097 */     UNSAFE.putInt(instantiationException, MARK, UNSAFE.getInt(paramT, MARK));
/* 3098 */     UNSAFE.putInt(instantiationException, POSITION, UNSAFE.getInt(paramT, POSITION));
/* 3099 */     UNSAFE.putInt(instantiationException, LIMIT, UNSAFE.getInt(paramT, LIMIT));
/* 3100 */     UNSAFE.putInt(instantiationException, CAPACITY, UNSAFE.getInt(paramT, CAPACITY));
/*      */     
/* 3102 */     UNSAFE.putObject(instantiationException, paramLong, UNSAFE.getObject(paramT, paramLong));
/*      */     
/* 3104 */     return (T)instantiationException;
/*      */   }
/*      */   
/*      */   public static native <T> T memGlobalRefToObject(long paramLong);
/*      */   
/*      */   public static interface MemoryAllocator {
/*      */     long getMalloc();
/*      */     
/*      */     long getCalloc();
/*      */     
/*      */     long getRealloc();
/*      */     
/*      */     long getFree();
/*      */     
/*      */     long getAlignedAlloc();
/*      */     
/*      */     long getAlignedFree();
/*      */     
/*      */     long malloc(long param1Long);
/*      */     
/*      */     long calloc(long param1Long1, long param1Long2);
/*      */     
/*      */     long realloc(long param1Long1, long param1Long2);
/*      */     
/*      */     void free(long param1Long);
/*      */     
/*      */     long aligned_alloc(long param1Long1, long param1Long2);
/*      */     
/*      */     void aligned_free(long param1Long);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\MemoryUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */