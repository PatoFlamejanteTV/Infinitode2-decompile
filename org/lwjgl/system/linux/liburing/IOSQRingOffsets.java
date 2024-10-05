/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct io_sqring_offsets")
/*     */ public class IOSQRingOffsets
/*     */   extends Struct<IOSQRingOffsets>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int HEAD;
/*     */   public static final int TAIL;
/*     */   public static final int RING_MASK;
/*     */   public static final int RING_ENTRIES;
/*     */   public static final int FLAGS;
/*     */   public static final int DROPPED;
/*     */   public static final int ARRAY;
/*     */   public static final int RESV1;
/*     */   public static final int RESV2;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  70 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(8) })).getSize();
/*  71 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  73 */     HEAD = layout.offsetof(0);
/*  74 */     TAIL = layout.offsetof(1);
/*  75 */     RING_MASK = layout.offsetof(2);
/*  76 */     RING_ENTRIES = layout.offsetof(3);
/*  77 */     FLAGS = layout.offsetof(4);
/*  78 */     DROPPED = layout.offsetof(5);
/*  79 */     ARRAY = layout.offsetof(6);
/*  80 */     RESV1 = layout.offsetof(7);
/*  81 */     RESV2 = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected IOSQRingOffsets(long paramLong, ByteBuffer paramByteBuffer) {
/*  85 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOSQRingOffsets create(long paramLong, ByteBuffer paramByteBuffer) {
/*  90 */     return new IOSQRingOffsets(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOSQRingOffsets(ByteBuffer paramByteBuffer) {
/* 100 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 104 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int head() {
/* 108 */     return nhead(address());
/*     */   } @NativeType("__u32")
/*     */   public int tail() {
/* 111 */     return ntail(address());
/*     */   } @NativeType("__u32")
/*     */   public int ring_mask() {
/* 114 */     return nring_mask(address());
/*     */   } @NativeType("__u32")
/*     */   public int ring_entries() {
/* 117 */     return nring_entries(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 120 */     return nflags(address());
/*     */   } @NativeType("__u32")
/*     */   public int dropped() {
/* 123 */     return ndropped(address());
/*     */   } @NativeType("__u32")
/*     */   public int array() {
/* 126 */     return narray(address());
/*     */   }
/*     */   public IOSQRingOffsets head(@NativeType("__u32") int paramInt) {
/* 129 */     nhead(address(), paramInt); return this;
/*     */   } public IOSQRingOffsets tail(@NativeType("__u32") int paramInt) {
/* 131 */     ntail(address(), paramInt); return this;
/*     */   } public IOSQRingOffsets ring_mask(@NativeType("__u32") int paramInt) {
/* 133 */     nring_mask(address(), paramInt); return this;
/*     */   } public IOSQRingOffsets ring_entries(@NativeType("__u32") int paramInt) {
/* 135 */     nring_entries(address(), paramInt); return this;
/*     */   } public IOSQRingOffsets flags(@NativeType("__u32") int paramInt) {
/* 137 */     nflags(address(), paramInt); return this;
/*     */   } public IOSQRingOffsets dropped(@NativeType("__u32") int paramInt) {
/* 139 */     ndropped(address(), paramInt); return this;
/*     */   } public IOSQRingOffsets array(@NativeType("__u32") int paramInt) {
/* 141 */     narray(address(), paramInt); return this;
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
/*     */   public IOSQRingOffsets set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/* 153 */     head(paramInt1);
/* 154 */     tail(paramInt2);
/* 155 */     ring_mask(paramInt3);
/* 156 */     ring_entries(paramInt4);
/* 157 */     flags(paramInt5);
/* 158 */     dropped(paramInt6);
/* 159 */     array(paramInt7);
/*     */     
/* 161 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOSQRingOffsets set(IOSQRingOffsets paramIOSQRingOffsets) {
/* 172 */     MemoryUtil.memCopy(paramIOSQRingOffsets.address(), address(), SIZEOF);
/* 173 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets malloc() {
/* 180 */     return new IOSQRingOffsets(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets calloc() {
/* 185 */     return new IOSQRingOffsets(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets create() {
/* 190 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 191 */     return new IOSQRingOffsets(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets create(long paramLong) {
/* 196 */     return new IOSQRingOffsets(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets createSafe(long paramLong) {
/* 202 */     return (paramLong == 0L) ? null : new IOSQRingOffsets(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 211 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 220 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 229 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 230 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 240 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 246 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets malloc(MemoryStack paramMemoryStack) {
/* 255 */     return new IOSQRingOffsets(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOSQRingOffsets calloc(MemoryStack paramMemoryStack) {
/* 264 */     return new IOSQRingOffsets(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 274 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 284 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nhead(long paramLong) {
/* 290 */     return UNSAFE.getInt(null, paramLong + HEAD);
/*     */   } public static int ntail(long paramLong) {
/* 292 */     return UNSAFE.getInt(null, paramLong + TAIL);
/*     */   } public static int nring_mask(long paramLong) {
/* 294 */     return UNSAFE.getInt(null, paramLong + RING_MASK);
/*     */   } public static int nring_entries(long paramLong) {
/* 296 */     return UNSAFE.getInt(null, paramLong + RING_ENTRIES);
/*     */   } public static int nflags(long paramLong) {
/* 298 */     return UNSAFE.getInt(null, paramLong + FLAGS);
/*     */   } public static int ndropped(long paramLong) {
/* 300 */     return UNSAFE.getInt(null, paramLong + DROPPED);
/*     */   }
/* 302 */   public static int narray(long paramLong) { return UNSAFE.getInt(null, paramLong + ARRAY); }
/* 303 */   public static int nresv1(long paramLong) { return UNSAFE.getInt(null, paramLong + RESV1); } public static long nresv2(long paramLong) {
/* 304 */     return UNSAFE.getLong(null, paramLong + RESV2);
/*     */   }
/*     */   public static void nhead(long paramLong, int paramInt) {
/* 307 */     UNSAFE.putInt(null, paramLong + HEAD, paramInt);
/*     */   } public static void ntail(long paramLong, int paramInt) {
/* 309 */     UNSAFE.putInt(null, paramLong + TAIL, paramInt);
/*     */   } public static void nring_mask(long paramLong, int paramInt) {
/* 311 */     UNSAFE.putInt(null, paramLong + RING_MASK, paramInt);
/*     */   } public static void nring_entries(long paramLong, int paramInt) {
/* 313 */     UNSAFE.putInt(null, paramLong + RING_ENTRIES, paramInt);
/*     */   } public static void nflags(long paramLong, int paramInt) {
/* 315 */     UNSAFE.putInt(null, paramLong + FLAGS, paramInt);
/*     */   } public static void ndropped(long paramLong, int paramInt) {
/* 317 */     UNSAFE.putInt(null, paramLong + DROPPED, paramInt);
/*     */   }
/* 319 */   public static void narray(long paramLong, int paramInt) { UNSAFE.putInt(null, paramLong + ARRAY, paramInt); }
/* 320 */   public static void nresv1(long paramLong, int paramInt) { UNSAFE.putInt(null, paramLong + RESV1, paramInt); } public static void nresv2(long paramLong1, long paramLong2) {
/* 321 */     UNSAFE.putLong(null, paramLong1 + RESV2, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOSQRingOffsets, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 328 */     private static final IOSQRingOffsets ELEMENT_FACTORY = IOSQRingOffsets.create(-1L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Buffer(ByteBuffer param1ByteBuffer) {
/* 340 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOSQRingOffsets.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 344 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 348 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 353 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOSQRingOffsets getElementFactory() {
/* 358 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int head() {
/* 363 */       return IOSQRingOffsets.nhead(address());
/*     */     } @NativeType("__u32")
/*     */     public int tail() {
/* 366 */       return IOSQRingOffsets.ntail(address());
/*     */     } @NativeType("__u32")
/*     */     public int ring_mask() {
/* 369 */       return IOSQRingOffsets.nring_mask(address());
/*     */     } @NativeType("__u32")
/*     */     public int ring_entries() {
/* 372 */       return IOSQRingOffsets.nring_entries(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 375 */       return IOSQRingOffsets.nflags(address());
/*     */     } @NativeType("__u32")
/*     */     public int dropped() {
/* 378 */       return IOSQRingOffsets.ndropped(address());
/*     */     } @NativeType("__u32")
/*     */     public int array() {
/* 381 */       return IOSQRingOffsets.narray(address());
/*     */     }
/*     */     public Buffer head(@NativeType("__u32") int param1Int) {
/* 384 */       IOSQRingOffsets.nhead(address(), param1Int); return this;
/*     */     } public Buffer tail(@NativeType("__u32") int param1Int) {
/* 386 */       IOSQRingOffsets.ntail(address(), param1Int); return this;
/*     */     } public Buffer ring_mask(@NativeType("__u32") int param1Int) {
/* 388 */       IOSQRingOffsets.nring_mask(address(), param1Int); return this;
/*     */     } public Buffer ring_entries(@NativeType("__u32") int param1Int) {
/* 390 */       IOSQRingOffsets.nring_entries(address(), param1Int); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int param1Int) {
/* 392 */       IOSQRingOffsets.nflags(address(), param1Int); return this;
/*     */     } public Buffer dropped(@NativeType("__u32") int param1Int) {
/* 394 */       IOSQRingOffsets.ndropped(address(), param1Int); return this;
/*     */     } public Buffer array(@NativeType("__u32") int param1Int) {
/* 396 */       IOSQRingOffsets.narray(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOSQRingOffsets.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */