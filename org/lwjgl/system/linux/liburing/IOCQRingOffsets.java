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
/*     */ @NativeType("struct io_cqring_offsets")
/*     */ public class IOCQRingOffsets
/*     */   extends Struct<IOCQRingOffsets>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int HEAD;
/*     */   public static final int TAIL;
/*     */   public static final int RING_MASK;
/*     */   public static final int RING_ENTRIES;
/*     */   public static final int OVERFLOW;
/*     */   public static final int CQES;
/*     */   public static final int FLAGS;
/*     */   public static final int RESV1;
/*     */   public static final int RESV2;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  68 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(8) })).getSize();
/*  69 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  71 */     HEAD = layout.offsetof(0);
/*  72 */     TAIL = layout.offsetof(1);
/*  73 */     RING_MASK = layout.offsetof(2);
/*  74 */     RING_ENTRIES = layout.offsetof(3);
/*  75 */     OVERFLOW = layout.offsetof(4);
/*  76 */     CQES = layout.offsetof(5);
/*  77 */     FLAGS = layout.offsetof(6);
/*  78 */     RESV1 = layout.offsetof(7);
/*  79 */     RESV2 = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected IOCQRingOffsets(long paramLong, ByteBuffer paramByteBuffer) {
/*  83 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOCQRingOffsets create(long paramLong, ByteBuffer paramByteBuffer) {
/*  88 */     return new IOCQRingOffsets(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOCQRingOffsets(ByteBuffer paramByteBuffer) {
/*  98 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 102 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int head() {
/* 106 */     return nhead(address());
/*     */   } @NativeType("__u32")
/*     */   public int tail() {
/* 109 */     return ntail(address());
/*     */   } @NativeType("__u32")
/*     */   public int ring_mask() {
/* 112 */     return nring_mask(address());
/*     */   } @NativeType("__u32")
/*     */   public int ring_entries() {
/* 115 */     return nring_entries(address());
/*     */   } @NativeType("__u32")
/*     */   public int overflow() {
/* 118 */     return noverflow(address());
/*     */   } @NativeType("__u32")
/*     */   public int cqes() {
/* 121 */     return ncqes(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 124 */     return nflags(address());
/*     */   }
/*     */   public IOCQRingOffsets head(@NativeType("__u32") int paramInt) {
/* 127 */     nhead(address(), paramInt); return this;
/*     */   } public IOCQRingOffsets tail(@NativeType("__u32") int paramInt) {
/* 129 */     ntail(address(), paramInt); return this;
/*     */   } public IOCQRingOffsets ring_mask(@NativeType("__u32") int paramInt) {
/* 131 */     nring_mask(address(), paramInt); return this;
/*     */   } public IOCQRingOffsets ring_entries(@NativeType("__u32") int paramInt) {
/* 133 */     nring_entries(address(), paramInt); return this;
/*     */   } public IOCQRingOffsets overflow(@NativeType("__u32") int paramInt) {
/* 135 */     noverflow(address(), paramInt); return this;
/*     */   } public IOCQRingOffsets cqes(@NativeType("__u32") int paramInt) {
/* 137 */     ncqes(address(), paramInt); return this;
/*     */   } public IOCQRingOffsets flags(@NativeType("__u32") int paramInt) {
/* 139 */     nflags(address(), paramInt); return this;
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
/*     */   public IOCQRingOffsets set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/* 151 */     head(paramInt1);
/* 152 */     tail(paramInt2);
/* 153 */     ring_mask(paramInt3);
/* 154 */     ring_entries(paramInt4);
/* 155 */     overflow(paramInt5);
/* 156 */     cqes(paramInt6);
/* 157 */     flags(paramInt7);
/*     */     
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOCQRingOffsets set(IOCQRingOffsets paramIOCQRingOffsets) {
/* 170 */     MemoryUtil.memCopy(paramIOCQRingOffsets.address(), address(), SIZEOF);
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOCQRingOffsets malloc() {
/* 178 */     return new IOCQRingOffsets(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOCQRingOffsets calloc() {
/* 183 */     return new IOCQRingOffsets(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOCQRingOffsets create() {
/* 188 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 189 */     return new IOCQRingOffsets(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOCQRingOffsets create(long paramLong) {
/* 194 */     return new IOCQRingOffsets(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOCQRingOffsets createSafe(long paramLong) {
/* 200 */     return (paramLong == 0L) ? null : new IOCQRingOffsets(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 209 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 218 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 227 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 228 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 238 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 244 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOCQRingOffsets malloc(MemoryStack paramMemoryStack) {
/* 253 */     return new IOCQRingOffsets(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOCQRingOffsets calloc(MemoryStack paramMemoryStack) {
/* 262 */     return new IOCQRingOffsets(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 272 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 282 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nhead(long paramLong) {
/* 288 */     return UNSAFE.getInt(null, paramLong + HEAD);
/*     */   } public static int ntail(long paramLong) {
/* 290 */     return UNSAFE.getInt(null, paramLong + TAIL);
/*     */   } public static int nring_mask(long paramLong) {
/* 292 */     return UNSAFE.getInt(null, paramLong + RING_MASK);
/*     */   } public static int nring_entries(long paramLong) {
/* 294 */     return UNSAFE.getInt(null, paramLong + RING_ENTRIES);
/*     */   } public static int noverflow(long paramLong) {
/* 296 */     return UNSAFE.getInt(null, paramLong + OVERFLOW);
/*     */   } public static int ncqes(long paramLong) {
/* 298 */     return UNSAFE.getInt(null, paramLong + CQES);
/*     */   }
/* 300 */   public static int nflags(long paramLong) { return UNSAFE.getInt(null, paramLong + FLAGS); }
/* 301 */   public static int nresv1(long paramLong) { return UNSAFE.getInt(null, paramLong + RESV1); } public static long nresv2(long paramLong) {
/* 302 */     return UNSAFE.getLong(null, paramLong + RESV2);
/*     */   }
/*     */   public static void nhead(long paramLong, int paramInt) {
/* 305 */     UNSAFE.putInt(null, paramLong + HEAD, paramInt);
/*     */   } public static void ntail(long paramLong, int paramInt) {
/* 307 */     UNSAFE.putInt(null, paramLong + TAIL, paramInt);
/*     */   } public static void nring_mask(long paramLong, int paramInt) {
/* 309 */     UNSAFE.putInt(null, paramLong + RING_MASK, paramInt);
/*     */   } public static void nring_entries(long paramLong, int paramInt) {
/* 311 */     UNSAFE.putInt(null, paramLong + RING_ENTRIES, paramInt);
/*     */   } public static void noverflow(long paramLong, int paramInt) {
/* 313 */     UNSAFE.putInt(null, paramLong + OVERFLOW, paramInt);
/*     */   } public static void ncqes(long paramLong, int paramInt) {
/* 315 */     UNSAFE.putInt(null, paramLong + CQES, paramInt);
/*     */   }
/* 317 */   public static void nflags(long paramLong, int paramInt) { UNSAFE.putInt(null, paramLong + FLAGS, paramInt); }
/* 318 */   public static void nresv1(long paramLong, int paramInt) { UNSAFE.putInt(null, paramLong + RESV1, paramInt); } public static void nresv2(long paramLong1, long paramLong2) {
/* 319 */     UNSAFE.putLong(null, paramLong1 + RESV2, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOCQRingOffsets, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 326 */     private static final IOCQRingOffsets ELEMENT_FACTORY = IOCQRingOffsets.create(-1L);
/*     */ 
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
/* 338 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOCQRingOffsets.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 342 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 346 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 351 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOCQRingOffsets getElementFactory() {
/* 356 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int head() {
/* 361 */       return IOCQRingOffsets.nhead(address());
/*     */     } @NativeType("__u32")
/*     */     public int tail() {
/* 364 */       return IOCQRingOffsets.ntail(address());
/*     */     } @NativeType("__u32")
/*     */     public int ring_mask() {
/* 367 */       return IOCQRingOffsets.nring_mask(address());
/*     */     } @NativeType("__u32")
/*     */     public int ring_entries() {
/* 370 */       return IOCQRingOffsets.nring_entries(address());
/*     */     } @NativeType("__u32")
/*     */     public int overflow() {
/* 373 */       return IOCQRingOffsets.noverflow(address());
/*     */     } @NativeType("__u32")
/*     */     public int cqes() {
/* 376 */       return IOCQRingOffsets.ncqes(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 379 */       return IOCQRingOffsets.nflags(address());
/*     */     }
/*     */     public Buffer head(@NativeType("__u32") int param1Int) {
/* 382 */       IOCQRingOffsets.nhead(address(), param1Int); return this;
/*     */     } public Buffer tail(@NativeType("__u32") int param1Int) {
/* 384 */       IOCQRingOffsets.ntail(address(), param1Int); return this;
/*     */     } public Buffer ring_mask(@NativeType("__u32") int param1Int) {
/* 386 */       IOCQRingOffsets.nring_mask(address(), param1Int); return this;
/*     */     } public Buffer ring_entries(@NativeType("__u32") int param1Int) {
/* 388 */       IOCQRingOffsets.nring_entries(address(), param1Int); return this;
/*     */     } public Buffer overflow(@NativeType("__u32") int param1Int) {
/* 390 */       IOCQRingOffsets.noverflow(address(), param1Int); return this;
/*     */     } public Buffer cqes(@NativeType("__u32") int param1Int) {
/* 392 */       IOCQRingOffsets.ncqes(address(), param1Int); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int param1Int) {
/* 394 */       IOCQRingOffsets.nflags(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOCQRingOffsets.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */