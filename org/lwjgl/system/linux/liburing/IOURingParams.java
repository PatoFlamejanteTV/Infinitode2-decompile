/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.function.Consumer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct io_uring_params")
/*     */ public class IOURingParams
/*     */   extends Struct<IOURingParams>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SQ_ENTRIES;
/*     */   public static final int CQ_ENTRIES;
/*     */   public static final int FLAGS;
/*     */   public static final int SQ_THREAD_CPU;
/*     */   public static final int SQ_THREAD_IDLE;
/*     */   public static final int FEATURES;
/*     */   public static final int WQ_FD;
/*     */   public static final int RESV;
/*     */   public static final int SQ_OFF;
/*     */   public static final int CQ_OFF;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/* 112 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __array(4, 3), __member(IOSQRingOffsets.SIZEOF, IOSQRingOffsets.ALIGNOF), __member(IOCQRingOffsets.SIZEOF, IOCQRingOffsets.ALIGNOF) })).getSize();
/* 113 */     ALIGNOF = layout.getAlignment();
/*     */     
/* 115 */     SQ_ENTRIES = layout.offsetof(0);
/* 116 */     CQ_ENTRIES = layout.offsetof(1);
/* 117 */     FLAGS = layout.offsetof(2);
/* 118 */     SQ_THREAD_CPU = layout.offsetof(3);
/* 119 */     SQ_THREAD_IDLE = layout.offsetof(4);
/* 120 */     FEATURES = layout.offsetof(5);
/* 121 */     WQ_FD = layout.offsetof(6);
/* 122 */     RESV = layout.offsetof(7);
/* 123 */     SQ_OFF = layout.offsetof(8);
/* 124 */     CQ_OFF = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected IOURingParams(long paramLong, ByteBuffer paramByteBuffer) {
/* 128 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingParams create(long paramLong, ByteBuffer paramByteBuffer) {
/* 133 */     return new IOURingParams(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingParams(ByteBuffer paramByteBuffer) {
/* 143 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 147 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int sq_entries() {
/* 151 */     return nsq_entries(address());
/*     */   } @NativeType("__u32")
/*     */   public int cq_entries() {
/* 154 */     return ncq_entries(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 157 */     return nflags(address());
/*     */   } @NativeType("__u32")
/*     */   public int sq_thread_cpu() {
/* 160 */     return nsq_thread_cpu(address());
/*     */   } @NativeType("__u32")
/*     */   public int sq_thread_idle() {
/* 163 */     return nsq_thread_idle(address());
/*     */   } @NativeType("__u32")
/*     */   public int features() {
/* 166 */     return nfeatures(address());
/*     */   } @NativeType("__u32")
/*     */   public int wq_fd() {
/* 169 */     return nwq_fd(address());
/*     */   } @NativeType("__u32[3]")
/*     */   public IntBuffer resv() {
/* 172 */     return nresv(address());
/*     */   } @NativeType("__u32")
/*     */   public int resv(int paramInt) {
/* 175 */     return nresv(address(), paramInt);
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
/*     */   @NativeType("struct io_sqring_offsets")
/*     */   public IOSQRingOffsets sq_off() {
/* 190 */     return nsq_off(address());
/*     */   } @NativeType("struct io_cqring_offsets")
/*     */   public IOCQRingOffsets cq_off() {
/* 193 */     return ncq_off(address());
/*     */   }
/*     */   public IOURingParams sq_entries(@NativeType("__u32") int paramInt) {
/* 196 */     nsq_entries(address(), paramInt); return this;
/*     */   } public IOURingParams cq_entries(@NativeType("__u32") int paramInt) {
/* 198 */     ncq_entries(address(), paramInt); return this;
/*     */   } public IOURingParams flags(@NativeType("__u32") int paramInt) {
/* 200 */     nflags(address(), paramInt); return this;
/*     */   } public IOURingParams sq_thread_cpu(@NativeType("__u32") int paramInt) {
/* 202 */     nsq_thread_cpu(address(), paramInt); return this;
/*     */   } public IOURingParams sq_thread_idle(@NativeType("__u32") int paramInt) {
/* 204 */     nsq_thread_idle(address(), paramInt); return this;
/*     */   } public IOURingParams features(@NativeType("__u32") int paramInt) {
/* 206 */     nfeatures(address(), paramInt); return this;
/*     */   } public IOURingParams wq_fd(@NativeType("__u32") int paramInt) {
/* 208 */     nwq_fd(address(), paramInt); return this;
/*     */   } public IOURingParams resv(@NativeType("__u32[3]") IntBuffer paramIntBuffer) {
/* 210 */     nresv(address(), paramIntBuffer); return this;
/*     */   } public IOURingParams resv(int paramInt1, @NativeType("__u32") int paramInt2) {
/* 212 */     nresv(address(), paramInt1, paramInt2); return this;
/*     */   } public IOURingParams sq_off(@NativeType("struct io_sqring_offsets") IOSQRingOffsets paramIOSQRingOffsets) {
/* 214 */     nsq_off(address(), paramIOSQRingOffsets); return this;
/*     */   } public IOURingParams sq_off(Consumer<IOSQRingOffsets> paramConsumer) {
/* 216 */     paramConsumer.accept(sq_off()); return this;
/*     */   } public IOURingParams cq_off(@NativeType("struct io_cqring_offsets") IOCQRingOffsets paramIOCQRingOffsets) {
/* 218 */     ncq_off(address(), paramIOCQRingOffsets); return this;
/*     */   } public IOURingParams cq_off(Consumer<IOCQRingOffsets> paramConsumer) {
/* 220 */     paramConsumer.accept(cq_off()); return this;
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
/*     */   public IOURingParams set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, IntBuffer paramIntBuffer, IOSQRingOffsets paramIOSQRingOffsets, IOCQRingOffsets paramIOCQRingOffsets) {
/* 235 */     sq_entries(paramInt1);
/* 236 */     cq_entries(paramInt2);
/* 237 */     flags(paramInt3);
/* 238 */     sq_thread_cpu(paramInt4);
/* 239 */     sq_thread_idle(paramInt5);
/* 240 */     features(paramInt6);
/* 241 */     wq_fd(paramInt7);
/* 242 */     resv(paramIntBuffer);
/* 243 */     sq_off(paramIOSQRingOffsets);
/* 244 */     cq_off(paramIOCQRingOffsets);
/*     */     
/* 246 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingParams set(IOURingParams paramIOURingParams) {
/* 257 */     MemoryUtil.memCopy(paramIOURingParams.address(), address(), SIZEOF);
/* 258 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingParams malloc() {
/* 265 */     return new IOURingParams(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingParams calloc() {
/* 270 */     return new IOURingParams(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingParams create() {
/* 275 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 276 */     return new IOURingParams(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingParams create(long paramLong) {
/* 281 */     return new IOURingParams(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingParams createSafe(long paramLong) {
/* 287 */     return (paramLong == 0L) ? null : new IOURingParams(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 296 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 305 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 314 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 315 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 325 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 331 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingParams malloc(MemoryStack paramMemoryStack) {
/* 340 */     return new IOURingParams(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingParams calloc(MemoryStack paramMemoryStack) {
/* 349 */     return new IOURingParams(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 359 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 369 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nsq_entries(long paramLong) {
/* 375 */     return UNSAFE.getInt(null, paramLong + SQ_ENTRIES);
/*     */   } public static int ncq_entries(long paramLong) {
/* 377 */     return UNSAFE.getInt(null, paramLong + CQ_ENTRIES);
/*     */   } public static int nflags(long paramLong) {
/* 379 */     return UNSAFE.getInt(null, paramLong + FLAGS);
/*     */   } public static int nsq_thread_cpu(long paramLong) {
/* 381 */     return UNSAFE.getInt(null, paramLong + SQ_THREAD_CPU);
/*     */   } public static int nsq_thread_idle(long paramLong) {
/* 383 */     return UNSAFE.getInt(null, paramLong + SQ_THREAD_IDLE);
/*     */   } public static int nfeatures(long paramLong) {
/* 385 */     return UNSAFE.getInt(null, paramLong + FEATURES);
/*     */   } public static int nwq_fd(long paramLong) {
/* 387 */     return UNSAFE.getInt(null, paramLong + WQ_FD);
/*     */   } public static IntBuffer nresv(long paramLong) {
/* 389 */     return MemoryUtil.memIntBuffer(paramLong + RESV, 3);
/*     */   }
/*     */   public static int nresv(long paramLong, int paramInt) {
/* 392 */     return UNSAFE.getInt(null, paramLong + RESV + (Checks.check(paramInt, 3) << 2L));
/*     */   }
/*     */   public static IOSQRingOffsets nsq_off(long paramLong) {
/* 395 */     return IOSQRingOffsets.create(paramLong + SQ_OFF);
/*     */   } public static IOCQRingOffsets ncq_off(long paramLong) {
/* 397 */     return IOCQRingOffsets.create(paramLong + CQ_OFF);
/*     */   }
/*     */   public static void nsq_entries(long paramLong, int paramInt) {
/* 400 */     UNSAFE.putInt(null, paramLong + SQ_ENTRIES, paramInt);
/*     */   } public static void ncq_entries(long paramLong, int paramInt) {
/* 402 */     UNSAFE.putInt(null, paramLong + CQ_ENTRIES, paramInt);
/*     */   } public static void nflags(long paramLong, int paramInt) {
/* 404 */     UNSAFE.putInt(null, paramLong + FLAGS, paramInt);
/*     */   } public static void nsq_thread_cpu(long paramLong, int paramInt) {
/* 406 */     UNSAFE.putInt(null, paramLong + SQ_THREAD_CPU, paramInt);
/*     */   } public static void nsq_thread_idle(long paramLong, int paramInt) {
/* 408 */     UNSAFE.putInt(null, paramLong + SQ_THREAD_IDLE, paramInt);
/*     */   } public static void nfeatures(long paramLong, int paramInt) {
/* 410 */     UNSAFE.putInt(null, paramLong + FEATURES, paramInt);
/*     */   } public static void nwq_fd(long paramLong, int paramInt) {
/* 412 */     UNSAFE.putInt(null, paramLong + WQ_FD, paramInt);
/*     */   }
/*     */   public static void nresv(long paramLong, IntBuffer paramIntBuffer) {
/* 415 */     if (Checks.CHECKS) Checks.checkGT(paramIntBuffer, 3); 
/* 416 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramIntBuffer), paramLong + RESV, (paramIntBuffer.remaining() << 2));
/*     */   }
/*     */   
/*     */   public static void nresv(long paramLong, int paramInt1, int paramInt2) {
/* 420 */     UNSAFE.putInt(null, paramLong + RESV + (Checks.check(paramInt1, 3) << 2L), paramInt2);
/*     */   }
/*     */   public static void nsq_off(long paramLong, IOSQRingOffsets paramIOSQRingOffsets) {
/* 423 */     MemoryUtil.memCopy(paramIOSQRingOffsets.address(), paramLong + SQ_OFF, IOSQRingOffsets.SIZEOF);
/*     */   } public static void ncq_off(long paramLong, IOCQRingOffsets paramIOCQRingOffsets) {
/* 425 */     MemoryUtil.memCopy(paramIOCQRingOffsets.address(), paramLong + CQ_OFF, IOCQRingOffsets.SIZEOF);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingParams, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 432 */     private static final IOURingParams ELEMENT_FACTORY = IOURingParams.create(-1L);
/*     */ 
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
/* 444 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingParams.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 448 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 452 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 457 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingParams getElementFactory() {
/* 462 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int sq_entries() {
/* 467 */       return IOURingParams.nsq_entries(address());
/*     */     } @NativeType("__u32")
/*     */     public int cq_entries() {
/* 470 */       return IOURingParams.ncq_entries(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 473 */       return IOURingParams.nflags(address());
/*     */     } @NativeType("__u32")
/*     */     public int sq_thread_cpu() {
/* 476 */       return IOURingParams.nsq_thread_cpu(address());
/*     */     } @NativeType("__u32")
/*     */     public int sq_thread_idle() {
/* 479 */       return IOURingParams.nsq_thread_idle(address());
/*     */     } @NativeType("__u32")
/*     */     public int features() {
/* 482 */       return IOURingParams.nfeatures(address());
/*     */     } @NativeType("__u32")
/*     */     public int wq_fd() {
/* 485 */       return IOURingParams.nwq_fd(address());
/*     */     } @NativeType("__u32[3]")
/*     */     public IntBuffer resv() {
/* 488 */       return IOURingParams.nresv(address());
/*     */     } @NativeType("__u32")
/*     */     public int resv(int param1Int) {
/* 491 */       return IOURingParams.nresv(address(), param1Int);
/*     */     } @NativeType("struct io_sqring_offsets")
/*     */     public IOSQRingOffsets sq_off() {
/* 494 */       return IOURingParams.nsq_off(address());
/*     */     } @NativeType("struct io_cqring_offsets")
/*     */     public IOCQRingOffsets cq_off() {
/* 497 */       return IOURingParams.ncq_off(address());
/*     */     }
/*     */     public Buffer sq_entries(@NativeType("__u32") int param1Int) {
/* 500 */       IOURingParams.nsq_entries(address(), param1Int); return this;
/*     */     } public Buffer cq_entries(@NativeType("__u32") int param1Int) {
/* 502 */       IOURingParams.ncq_entries(address(), param1Int); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int param1Int) {
/* 504 */       IOURingParams.nflags(address(), param1Int); return this;
/*     */     } public Buffer sq_thread_cpu(@NativeType("__u32") int param1Int) {
/* 506 */       IOURingParams.nsq_thread_cpu(address(), param1Int); return this;
/*     */     } public Buffer sq_thread_idle(@NativeType("__u32") int param1Int) {
/* 508 */       IOURingParams.nsq_thread_idle(address(), param1Int); return this;
/*     */     } public Buffer features(@NativeType("__u32") int param1Int) {
/* 510 */       IOURingParams.nfeatures(address(), param1Int); return this;
/*     */     } public Buffer wq_fd(@NativeType("__u32") int param1Int) {
/* 512 */       IOURingParams.nwq_fd(address(), param1Int); return this;
/*     */     } public Buffer resv(@NativeType("__u32[3]") IntBuffer param1IntBuffer) {
/* 514 */       IOURingParams.nresv(address(), param1IntBuffer); return this;
/*     */     } public Buffer resv(int param1Int1, @NativeType("__u32") int param1Int2) {
/* 516 */       IOURingParams.nresv(address(), param1Int1, param1Int2); return this;
/*     */     } public Buffer sq_off(@NativeType("struct io_sqring_offsets") IOSQRingOffsets param1IOSQRingOffsets) {
/* 518 */       IOURingParams.nsq_off(address(), param1IOSQRingOffsets); return this;
/*     */     } public Buffer sq_off(Consumer<IOSQRingOffsets> param1Consumer) {
/* 520 */       param1Consumer.accept(sq_off()); return this;
/*     */     } public Buffer cq_off(@NativeType("struct io_cqring_offsets") IOCQRingOffsets param1IOCQRingOffsets) {
/* 522 */       IOURingParams.ncq_off(address(), param1IOCQRingOffsets); return this;
/*     */     } public Buffer cq_off(Consumer<IOCQRingOffsets> param1Consumer) {
/* 524 */       param1Consumer.accept(cq_off()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */