/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ @NativeType("struct io_uring_sq")
/*     */ public class IOURingSQ
/*     */   extends Struct<IOURingSQ>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int KHEAD;
/*     */   public static final int KTAIL;
/*     */   public static final int KRING_MASK;
/*     */   public static final int KRING_ENTRIES;
/*     */   public static final int KFLAGS;
/*     */   public static final int KDROPPED;
/*     */   public static final int ARRAY;
/*     */   public static final int SQES;
/*     */   public static final int SQE_HEAD;
/*     */   public static final int SQE_TAIL;
/*     */   public static final int RING_SZ;
/*     */   public static final int RING_PTR;
/*     */   public static final int RING_MASK;
/*     */   public static final int RING_ENTRIES;
/*     */   public static final int PAD;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  87 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(4), __member(4), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(4), __member(4), __array(4, 2) })).getSize();
/*  88 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  90 */     KHEAD = layout.offsetof(0);
/*  91 */     KTAIL = layout.offsetof(1);
/*  92 */     KRING_MASK = layout.offsetof(2);
/*  93 */     KRING_ENTRIES = layout.offsetof(3);
/*  94 */     KFLAGS = layout.offsetof(4);
/*  95 */     KDROPPED = layout.offsetof(5);
/*  96 */     ARRAY = layout.offsetof(6);
/*  97 */     SQES = layout.offsetof(7);
/*  98 */     SQE_HEAD = layout.offsetof(8);
/*  99 */     SQE_TAIL = layout.offsetof(9);
/* 100 */     RING_SZ = layout.offsetof(10);
/* 101 */     RING_PTR = layout.offsetof(11);
/* 102 */     RING_MASK = layout.offsetof(12);
/* 103 */     RING_ENTRIES = layout.offsetof(13);
/* 104 */     PAD = layout.offsetof(14);
/*     */   }
/*     */   
/*     */   protected IOURingSQ(long paramLong, ByteBuffer paramByteBuffer) {
/* 108 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingSQ create(long paramLong, ByteBuffer paramByteBuffer) {
/* 113 */     return new IOURingSQ(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingSQ(ByteBuffer paramByteBuffer) {
/* 123 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 127 */     return SIZEOF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer khead(int paramInt) {
/* 135 */     return nkhead(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer ktail(int paramInt) {
/* 142 */     return nktail(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer kring_mask(int paramInt) {
/* 149 */     return nkring_mask(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer kring_entries(int paramInt) {
/* 156 */     return nkring_entries(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer kflags(int paramInt) {
/* 163 */     return nkflags(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer kdropped(int paramInt) {
/* 170 */     return nkdropped(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer array(int paramInt) {
/* 177 */     return narray(address(), paramInt);
/*     */   } @NativeType("struct io_uring_sqe *")
/*     */   public IOURingSQE sqes() {
/* 180 */     return nsqes(address());
/*     */   } @NativeType("unsigned")
/*     */   public int sqe_head() {
/* 183 */     return nsqe_head(address());
/*     */   } @NativeType("unsigned")
/*     */   public int sqe_tail() {
/* 186 */     return nsqe_tail(address());
/*     */   } @NativeType("size_t")
/*     */   public long ring_sz() {
/* 189 */     return nring_sz(address());
/*     */   } @NativeType("void *")
/*     */   public ByteBuffer ring_ptr() {
/* 192 */     return nring_ptr(address());
/*     */   } @NativeType("unsigned")
/*     */   public int ring_mask() {
/* 195 */     return nring_mask(address());
/*     */   } @NativeType("unsigned")
/*     */   public int ring_entries() {
/* 198 */     return nring_entries(address());
/*     */   }
/*     */   public IOURingSQ khead(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 201 */     nkhead(address(), paramIntBuffer); return this;
/*     */   } public IOURingSQ ktail(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 203 */     nktail(address(), paramIntBuffer); return this;
/*     */   } public IOURingSQ kring_mask(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 205 */     nkring_mask(address(), paramIntBuffer); return this;
/*     */   } public IOURingSQ kring_entries(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 207 */     nkring_entries(address(), paramIntBuffer); return this;
/*     */   } public IOURingSQ kflags(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 209 */     nkflags(address(), paramIntBuffer); return this;
/*     */   } public IOURingSQ kdropped(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 211 */     nkdropped(address(), paramIntBuffer); return this;
/*     */   } public IOURingSQ array(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 213 */     narray(address(), paramIntBuffer); return this;
/*     */   } public IOURingSQ sqes(@NativeType("struct io_uring_sqe *") IOURingSQE paramIOURingSQE) {
/* 215 */     nsqes(address(), paramIOURingSQE); return this;
/*     */   } public IOURingSQ sqe_head(@NativeType("unsigned") int paramInt) {
/* 217 */     nsqe_head(address(), paramInt); return this;
/*     */   } public IOURingSQ sqe_tail(@NativeType("unsigned") int paramInt) {
/* 219 */     nsqe_tail(address(), paramInt); return this;
/*     */   } public IOURingSQ ring_ptr(@NativeType("void *") ByteBuffer paramByteBuffer) {
/* 221 */     nring_ptr(address(), paramByteBuffer); return this;
/*     */   } public IOURingSQ ring_mask(@NativeType("unsigned") int paramInt) {
/* 223 */     nring_mask(address(), paramInt); return this;
/*     */   } public IOURingSQ ring_entries(@NativeType("unsigned") int paramInt) {
/* 225 */     nring_entries(address(), paramInt); return this;
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
/*     */   public IOURingSQ set(IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, IntBuffer paramIntBuffer3, IntBuffer paramIntBuffer4, IntBuffer paramIntBuffer5, IntBuffer paramIntBuffer6, IntBuffer paramIntBuffer7, IOURingSQE paramIOURingSQE, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, int paramInt3, int paramInt4) {
/* 243 */     khead(paramIntBuffer1);
/* 244 */     ktail(paramIntBuffer2);
/* 245 */     kring_mask(paramIntBuffer3);
/* 246 */     kring_entries(paramIntBuffer4);
/* 247 */     kflags(paramIntBuffer5);
/* 248 */     kdropped(paramIntBuffer6);
/* 249 */     array(paramIntBuffer7);
/* 250 */     sqes(paramIOURingSQE);
/* 251 */     sqe_head(paramInt1);
/* 252 */     sqe_tail(paramInt2);
/* 253 */     ring_ptr(paramByteBuffer);
/* 254 */     ring_mask(paramInt3);
/* 255 */     ring_entries(paramInt4);
/*     */     
/* 257 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingSQ set(IOURingSQ paramIOURingSQ) {
/* 268 */     MemoryUtil.memCopy(paramIOURingSQ.address(), address(), SIZEOF);
/* 269 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSQ malloc() {
/* 276 */     return new IOURingSQ(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSQ calloc() {
/* 281 */     return new IOURingSQ(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSQ create() {
/* 286 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 287 */     return new IOURingSQ(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSQ create(long paramLong) {
/* 292 */     return new IOURingSQ(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSQ createSafe(long paramLong) {
/* 298 */     return (paramLong == 0L) ? null : new IOURingSQ(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 307 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 316 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 325 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 326 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 336 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 342 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSQ malloc(MemoryStack paramMemoryStack) {
/* 351 */     return new IOURingSQ(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSQ calloc(MemoryStack paramMemoryStack) {
/* 360 */     return new IOURingSQ(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 370 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 380 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer nkhead(long paramLong, int paramInt) {
/* 386 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KHEAD), paramInt);
/*     */   } public static IntBuffer nktail(long paramLong, int paramInt) {
/* 388 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KTAIL), paramInt);
/*     */   } public static IntBuffer nkring_mask(long paramLong, int paramInt) {
/* 390 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KRING_MASK), paramInt);
/*     */   } public static IntBuffer nkring_entries(long paramLong, int paramInt) {
/* 392 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KRING_ENTRIES), paramInt);
/*     */   } public static IntBuffer nkflags(long paramLong, int paramInt) {
/* 394 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KFLAGS), paramInt);
/*     */   } public static IntBuffer nkdropped(long paramLong, int paramInt) {
/* 396 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KDROPPED), paramInt);
/*     */   } public static IntBuffer narray(long paramLong, int paramInt) {
/* 398 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + ARRAY), paramInt);
/*     */   } public static IOURingSQE nsqes(long paramLong) {
/* 400 */     return IOURingSQE.create(MemoryUtil.memGetAddress(paramLong + SQES));
/*     */   } public static int nsqe_head(long paramLong) {
/* 402 */     return UNSAFE.getInt(null, paramLong + SQE_HEAD);
/*     */   } public static int nsqe_tail(long paramLong) {
/* 404 */     return UNSAFE.getInt(null, paramLong + SQE_TAIL);
/*     */   } public static long nring_sz(long paramLong) {
/* 406 */     return MemoryUtil.memGetAddress(paramLong + RING_SZ);
/*     */   } public static ByteBuffer nring_ptr(long paramLong) {
/* 408 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(paramLong + RING_PTR), (int)nring_sz(paramLong));
/*     */   } public static int nring_mask(long paramLong) {
/* 410 */     return UNSAFE.getInt(null, paramLong + RING_MASK);
/*     */   }
/* 412 */   public static int nring_entries(long paramLong) { return UNSAFE.getInt(null, paramLong + RING_ENTRIES); } public static IntBuffer npad(long paramLong) {
/* 413 */     return MemoryUtil.memIntBuffer(paramLong + PAD, 2);
/*     */   } public static int npad(long paramLong, int paramInt) {
/* 415 */     return UNSAFE.getInt(null, paramLong + PAD + (Checks.check(paramInt, 2) << 2L));
/*     */   }
/*     */   
/*     */   public static void nkhead(long paramLong, IntBuffer paramIntBuffer) {
/* 419 */     MemoryUtil.memPutAddress(paramLong + KHEAD, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nktail(long paramLong, IntBuffer paramIntBuffer) {
/* 421 */     MemoryUtil.memPutAddress(paramLong + KTAIL, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nkring_mask(long paramLong, IntBuffer paramIntBuffer) {
/* 423 */     MemoryUtil.memPutAddress(paramLong + KRING_MASK, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nkring_entries(long paramLong, IntBuffer paramIntBuffer) {
/* 425 */     MemoryUtil.memPutAddress(paramLong + KRING_ENTRIES, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nkflags(long paramLong, IntBuffer paramIntBuffer) {
/* 427 */     MemoryUtil.memPutAddress(paramLong + KFLAGS, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nkdropped(long paramLong, IntBuffer paramIntBuffer) {
/* 429 */     MemoryUtil.memPutAddress(paramLong + KDROPPED, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void narray(long paramLong, IntBuffer paramIntBuffer) {
/* 431 */     MemoryUtil.memPutAddress(paramLong + ARRAY, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nsqes(long paramLong, IOURingSQE paramIOURingSQE) {
/* 433 */     MemoryUtil.memPutAddress(paramLong + SQES, paramIOURingSQE.address());
/*     */   } public static void nsqe_head(long paramLong, int paramInt) {
/* 435 */     UNSAFE.putInt(null, paramLong + SQE_HEAD, paramInt);
/*     */   } public static void nsqe_tail(long paramLong, int paramInt) {
/* 437 */     UNSAFE.putInt(null, paramLong + SQE_TAIL, paramInt);
/*     */   } public static void nring_sz(long paramLong1, long paramLong2) {
/* 439 */     MemoryUtil.memPutAddress(paramLong1 + RING_SZ, paramLong2);
/*     */   } public static void nring_ptr(long paramLong, ByteBuffer paramByteBuffer) {
/* 441 */     MemoryUtil.memPutAddress(paramLong + RING_PTR, MemoryUtil.memAddress(paramByteBuffer)); nring_sz(paramLong, paramByteBuffer.remaining());
/*     */   } public static void nring_mask(long paramLong, int paramInt) {
/* 443 */     UNSAFE.putInt(null, paramLong + RING_MASK, paramInt);
/*     */   } public static void nring_entries(long paramLong, int paramInt) {
/* 445 */     UNSAFE.putInt(null, paramLong + RING_ENTRIES, paramInt);
/*     */   } public static void npad(long paramLong, IntBuffer paramIntBuffer) {
/* 447 */     if (Checks.CHECKS) Checks.checkGT(paramIntBuffer, 2); 
/* 448 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramIntBuffer), paramLong + PAD, (paramIntBuffer.remaining() << 2));
/*     */   }
/*     */   public static void npad(long paramLong, int paramInt1, int paramInt2) {
/* 451 */     UNSAFE.putInt(null, paramLong + PAD + (Checks.check(paramInt1, 2) << 2L), paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 460 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KHEAD));
/* 461 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KTAIL));
/* 462 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KRING_MASK));
/* 463 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KRING_ENTRIES));
/* 464 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KFLAGS));
/* 465 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KDROPPED));
/* 466 */     Checks.check(MemoryUtil.memGetAddress(paramLong + ARRAY));
/* 467 */     Checks.check(MemoryUtil.memGetAddress(paramLong + SQES));
/* 468 */     Checks.check(MemoryUtil.memGetAddress(paramLong + RING_PTR));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingSQ, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 476 */     private static final IOURingSQ ELEMENT_FACTORY = IOURingSQ.create(-1L);
/*     */ 
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
/* 488 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingSQ.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 492 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 496 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 501 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingSQ getElementFactory() {
/* 506 */       return ELEMENT_FACTORY;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer khead(int param1Int) {
/* 515 */       return IOURingSQ.nkhead(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer ktail(int param1Int) {
/* 522 */       return IOURingSQ.nktail(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer kring_mask(int param1Int) {
/* 529 */       return IOURingSQ.nkring_mask(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer kring_entries(int param1Int) {
/* 536 */       return IOURingSQ.nkring_entries(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer kflags(int param1Int) {
/* 543 */       return IOURingSQ.nkflags(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer kdropped(int param1Int) {
/* 550 */       return IOURingSQ.nkdropped(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer array(int param1Int) {
/* 557 */       return IOURingSQ.narray(address(), param1Int);
/*     */     } @NativeType("struct io_uring_sqe *")
/*     */     public IOURingSQE sqes() {
/* 560 */       return IOURingSQ.nsqes(address());
/*     */     } @NativeType("unsigned")
/*     */     public int sqe_head() {
/* 563 */       return IOURingSQ.nsqe_head(address());
/*     */     } @NativeType("unsigned")
/*     */     public int sqe_tail() {
/* 566 */       return IOURingSQ.nsqe_tail(address());
/*     */     } @NativeType("size_t")
/*     */     public long ring_sz() {
/* 569 */       return IOURingSQ.nring_sz(address());
/*     */     } @NativeType("void *")
/*     */     public ByteBuffer ring_ptr() {
/* 572 */       return IOURingSQ.nring_ptr(address());
/*     */     } @NativeType("unsigned")
/*     */     public int ring_mask() {
/* 575 */       return IOURingSQ.nring_mask(address());
/*     */     } @NativeType("unsigned")
/*     */     public int ring_entries() {
/* 578 */       return IOURingSQ.nring_entries(address());
/*     */     }
/*     */     public Buffer khead(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 581 */       IOURingSQ.nkhead(address(), param1IntBuffer); return this;
/*     */     } public Buffer ktail(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 583 */       IOURingSQ.nktail(address(), param1IntBuffer); return this;
/*     */     } public Buffer kring_mask(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 585 */       IOURingSQ.nkring_mask(address(), param1IntBuffer); return this;
/*     */     } public Buffer kring_entries(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 587 */       IOURingSQ.nkring_entries(address(), param1IntBuffer); return this;
/*     */     } public Buffer kflags(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 589 */       IOURingSQ.nkflags(address(), param1IntBuffer); return this;
/*     */     } public Buffer kdropped(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 591 */       IOURingSQ.nkdropped(address(), param1IntBuffer); return this;
/*     */     } public Buffer array(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 593 */       IOURingSQ.narray(address(), param1IntBuffer); return this;
/*     */     } public Buffer sqes(@NativeType("struct io_uring_sqe *") IOURingSQE param1IOURingSQE) {
/* 595 */       IOURingSQ.nsqes(address(), param1IOURingSQE); return this;
/*     */     } public Buffer sqe_head(@NativeType("unsigned") int param1Int) {
/* 597 */       IOURingSQ.nsqe_head(address(), param1Int); return this;
/*     */     } public Buffer sqe_tail(@NativeType("unsigned") int param1Int) {
/* 599 */       IOURingSQ.nsqe_tail(address(), param1Int); return this;
/*     */     } public Buffer ring_ptr(@NativeType("void *") ByteBuffer param1ByteBuffer) {
/* 601 */       IOURingSQ.nring_ptr(address(), param1ByteBuffer); return this;
/*     */     } public Buffer ring_mask(@NativeType("unsigned") int param1Int) {
/* 603 */       IOURingSQ.nring_mask(address(), param1Int); return this;
/*     */     } public Buffer ring_entries(@NativeType("unsigned") int param1Int) {
/* 605 */       IOURingSQ.nring_entries(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingSQ.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */