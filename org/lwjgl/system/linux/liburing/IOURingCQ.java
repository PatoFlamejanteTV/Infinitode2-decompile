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
/*     */ @NativeType("struct io_uring_cq")
/*     */ public class IOURingCQ
/*     */   extends Struct<IOURingCQ>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int KHEAD;
/*     */   public static final int KTAIL;
/*     */   public static final int KRING_MASK;
/*     */   public static final int KRING_ENTRIES;
/*     */   public static final int KFLAGS;
/*     */   public static final int KOVERFLOW;
/*     */   public static final int CQES;
/*     */   public static final int RING_SZ;
/*     */   public static final int RING_PTR;
/*     */   public static final int RING_MASK;
/*     */   public static final int RING_ENTRIES;
/*     */   public static final int PAD;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  78 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(4), __member(4), __array(4, 2) })).getSize();
/*  79 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  81 */     KHEAD = layout.offsetof(0);
/*  82 */     KTAIL = layout.offsetof(1);
/*  83 */     KRING_MASK = layout.offsetof(2);
/*  84 */     KRING_ENTRIES = layout.offsetof(3);
/*  85 */     KFLAGS = layout.offsetof(4);
/*  86 */     KOVERFLOW = layout.offsetof(5);
/*  87 */     CQES = layout.offsetof(6);
/*  88 */     RING_SZ = layout.offsetof(7);
/*  89 */     RING_PTR = layout.offsetof(8);
/*  90 */     RING_MASK = layout.offsetof(9);
/*  91 */     RING_ENTRIES = layout.offsetof(10);
/*  92 */     PAD = layout.offsetof(11);
/*     */   }
/*     */   
/*     */   protected IOURingCQ(long paramLong, ByteBuffer paramByteBuffer) {
/*  96 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingCQ create(long paramLong, ByteBuffer paramByteBuffer) {
/* 101 */     return new IOURingCQ(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCQ(ByteBuffer paramByteBuffer) {
/* 111 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 115 */     return SIZEOF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer khead(int paramInt) {
/* 123 */     return nkhead(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer ktail(int paramInt) {
/* 130 */     return nktail(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer kring_mask(int paramInt) {
/* 137 */     return nkring_mask(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer kring_entries(int paramInt) {
/* 144 */     return nkring_entries(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer kflags(int paramInt) {
/* 151 */     return nkflags(address(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer koverflow(int paramInt) {
/* 158 */     return nkoverflow(address(), paramInt);
/*     */   } @NativeType("struct io_uring_cqe *")
/*     */   public IOURingCQE cqes() {
/* 161 */     return ncqes(address());
/*     */   } @NativeType("size_t")
/*     */   public long ring_sz() {
/* 164 */     return nring_sz(address());
/*     */   } @NativeType("void *")
/*     */   public ByteBuffer ring_ptr() {
/* 167 */     return nring_ptr(address());
/*     */   } @NativeType("unsigned")
/*     */   public int ring_mask() {
/* 170 */     return nring_mask(address());
/*     */   } @NativeType("unsigned")
/*     */   public int ring_entries() {
/* 173 */     return nring_entries(address());
/*     */   }
/*     */   public IOURingCQ khead(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 176 */     nkhead(address(), paramIntBuffer); return this;
/*     */   } public IOURingCQ ktail(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 178 */     nktail(address(), paramIntBuffer); return this;
/*     */   } public IOURingCQ kring_mask(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 180 */     nkring_mask(address(), paramIntBuffer); return this;
/*     */   } public IOURingCQ kring_entries(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 182 */     nkring_entries(address(), paramIntBuffer); return this;
/*     */   } public IOURingCQ kflags(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 184 */     nkflags(address(), paramIntBuffer); return this;
/*     */   } public IOURingCQ koverflow(@NativeType("unsigned *") IntBuffer paramIntBuffer) {
/* 186 */     nkoverflow(address(), paramIntBuffer); return this;
/*     */   } public IOURingCQ cqes(@NativeType("struct io_uring_cqe *") IOURingCQE paramIOURingCQE) {
/* 188 */     ncqes(address(), paramIOURingCQE); return this;
/*     */   } public IOURingCQ ring_ptr(@NativeType("void *") ByteBuffer paramByteBuffer) {
/* 190 */     nring_ptr(address(), paramByteBuffer); return this;
/*     */   } public IOURingCQ ring_mask(@NativeType("unsigned") int paramInt) {
/* 192 */     nring_mask(address(), paramInt); return this;
/*     */   } public IOURingCQ ring_entries(@NativeType("unsigned") int paramInt) {
/* 194 */     nring_entries(address(), paramInt); return this;
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
/*     */   public IOURingCQ set(IntBuffer paramIntBuffer1, IntBuffer paramIntBuffer2, IntBuffer paramIntBuffer3, IntBuffer paramIntBuffer4, IntBuffer paramIntBuffer5, IntBuffer paramIntBuffer6, IOURingCQE paramIOURingCQE, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 209 */     khead(paramIntBuffer1);
/* 210 */     ktail(paramIntBuffer2);
/* 211 */     kring_mask(paramIntBuffer3);
/* 212 */     kring_entries(paramIntBuffer4);
/* 213 */     kflags(paramIntBuffer5);
/* 214 */     koverflow(paramIntBuffer6);
/* 215 */     cqes(paramIOURingCQE);
/* 216 */     ring_ptr(paramByteBuffer);
/* 217 */     ring_mask(paramInt1);
/* 218 */     ring_entries(paramInt2);
/*     */     
/* 220 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCQ set(IOURingCQ paramIOURingCQ) {
/* 231 */     MemoryUtil.memCopy(paramIOURingCQ.address(), address(), SIZEOF);
/* 232 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQ malloc() {
/* 239 */     return new IOURingCQ(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQ calloc() {
/* 244 */     return new IOURingCQ(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQ create() {
/* 249 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 250 */     return new IOURingCQ(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQ create(long paramLong) {
/* 255 */     return new IOURingCQ(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQ createSafe(long paramLong) {
/* 261 */     return (paramLong == 0L) ? null : new IOURingCQ(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 270 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 279 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 288 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 289 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 299 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 305 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQ malloc(MemoryStack paramMemoryStack) {
/* 314 */     return new IOURingCQ(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQ calloc(MemoryStack paramMemoryStack) {
/* 323 */     return new IOURingCQ(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 333 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 343 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer nkhead(long paramLong, int paramInt) {
/* 349 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KHEAD), paramInt);
/*     */   } public static IntBuffer nktail(long paramLong, int paramInt) {
/* 351 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KTAIL), paramInt);
/*     */   } public static IntBuffer nkring_mask(long paramLong, int paramInt) {
/* 353 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KRING_MASK), paramInt);
/*     */   } public static IntBuffer nkring_entries(long paramLong, int paramInt) {
/* 355 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KRING_ENTRIES), paramInt);
/*     */   } public static IntBuffer nkflags(long paramLong, int paramInt) {
/* 357 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KFLAGS), paramInt);
/*     */   } public static IntBuffer nkoverflow(long paramLong, int paramInt) {
/* 359 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(paramLong + KOVERFLOW), paramInt);
/*     */   } public static IOURingCQE ncqes(long paramLong) {
/* 361 */     return IOURingCQE.create(MemoryUtil.memGetAddress(paramLong + CQES));
/*     */   } public static long nring_sz(long paramLong) {
/* 363 */     return MemoryUtil.memGetAddress(paramLong + RING_SZ);
/*     */   } public static ByteBuffer nring_ptr(long paramLong) {
/* 365 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(paramLong + RING_PTR), (int)nring_sz(paramLong));
/*     */   } public static int nring_mask(long paramLong) {
/* 367 */     return UNSAFE.getInt(null, paramLong + RING_MASK);
/*     */   }
/* 369 */   public static int nring_entries(long paramLong) { return UNSAFE.getInt(null, paramLong + RING_ENTRIES); } public static IntBuffer npad(long paramLong) {
/* 370 */     return MemoryUtil.memIntBuffer(paramLong + PAD, 2);
/*     */   } public static int npad(long paramLong, int paramInt) {
/* 372 */     return UNSAFE.getInt(null, paramLong + PAD + (Checks.check(paramInt, 2) << 2L));
/*     */   }
/*     */   
/*     */   public static void nkhead(long paramLong, IntBuffer paramIntBuffer) {
/* 376 */     MemoryUtil.memPutAddress(paramLong + KHEAD, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nktail(long paramLong, IntBuffer paramIntBuffer) {
/* 378 */     MemoryUtil.memPutAddress(paramLong + KTAIL, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nkring_mask(long paramLong, IntBuffer paramIntBuffer) {
/* 380 */     MemoryUtil.memPutAddress(paramLong + KRING_MASK, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nkring_entries(long paramLong, IntBuffer paramIntBuffer) {
/* 382 */     MemoryUtil.memPutAddress(paramLong + KRING_ENTRIES, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nkflags(long paramLong, IntBuffer paramIntBuffer) {
/* 384 */     MemoryUtil.memPutAddress(paramLong + KFLAGS, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void nkoverflow(long paramLong, IntBuffer paramIntBuffer) {
/* 386 */     MemoryUtil.memPutAddress(paramLong + KOVERFLOW, MemoryUtil.memAddress(paramIntBuffer));
/*     */   } public static void ncqes(long paramLong, IOURingCQE paramIOURingCQE) {
/* 388 */     MemoryUtil.memPutAddress(paramLong + CQES, paramIOURingCQE.address());
/*     */   } public static void nring_sz(long paramLong1, long paramLong2) {
/* 390 */     MemoryUtil.memPutAddress(paramLong1 + RING_SZ, paramLong2);
/*     */   } public static void nring_ptr(long paramLong, ByteBuffer paramByteBuffer) {
/* 392 */     MemoryUtil.memPutAddress(paramLong + RING_PTR, MemoryUtil.memAddress(paramByteBuffer)); nring_sz(paramLong, paramByteBuffer.remaining());
/*     */   } public static void nring_mask(long paramLong, int paramInt) {
/* 394 */     UNSAFE.putInt(null, paramLong + RING_MASK, paramInt);
/*     */   } public static void nring_entries(long paramLong, int paramInt) {
/* 396 */     UNSAFE.putInt(null, paramLong + RING_ENTRIES, paramInt);
/*     */   } public static void npad(long paramLong, IntBuffer paramIntBuffer) {
/* 398 */     if (Checks.CHECKS) Checks.checkGT(paramIntBuffer, 2); 
/* 399 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramIntBuffer), paramLong + PAD, (paramIntBuffer.remaining() << 2));
/*     */   }
/*     */   public static void npad(long paramLong, int paramInt1, int paramInt2) {
/* 402 */     UNSAFE.putInt(null, paramLong + PAD + (Checks.check(paramInt1, 2) << 2L), paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 411 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KHEAD));
/* 412 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KTAIL));
/* 413 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KRING_MASK));
/* 414 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KRING_ENTRIES));
/* 415 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KFLAGS));
/* 416 */     Checks.check(MemoryUtil.memGetAddress(paramLong + KOVERFLOW));
/* 417 */     Checks.check(MemoryUtil.memGetAddress(paramLong + CQES));
/* 418 */     Checks.check(MemoryUtil.memGetAddress(paramLong + RING_PTR));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingCQ, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 426 */     private static final IOURingCQ ELEMENT_FACTORY = IOURingCQ.create(-1L);
/*     */ 
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
/* 438 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingCQ.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 442 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 446 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 451 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingCQ getElementFactory() {
/* 456 */       return ELEMENT_FACTORY;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer khead(int param1Int) {
/* 465 */       return IOURingCQ.nkhead(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer ktail(int param1Int) {
/* 472 */       return IOURingCQ.nktail(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer kring_mask(int param1Int) {
/* 479 */       return IOURingCQ.nkring_mask(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer kring_entries(int param1Int) {
/* 486 */       return IOURingCQ.nkring_entries(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer kflags(int param1Int) {
/* 493 */       return IOURingCQ.nkflags(address(), param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer koverflow(int param1Int) {
/* 500 */       return IOURingCQ.nkoverflow(address(), param1Int);
/*     */     } @NativeType("struct io_uring_cqe *")
/*     */     public IOURingCQE cqes() {
/* 503 */       return IOURingCQ.ncqes(address());
/*     */     } @NativeType("size_t")
/*     */     public long ring_sz() {
/* 506 */       return IOURingCQ.nring_sz(address());
/*     */     } @NativeType("void *")
/*     */     public ByteBuffer ring_ptr() {
/* 509 */       return IOURingCQ.nring_ptr(address());
/*     */     } @NativeType("unsigned")
/*     */     public int ring_mask() {
/* 512 */       return IOURingCQ.nring_mask(address());
/*     */     } @NativeType("unsigned")
/*     */     public int ring_entries() {
/* 515 */       return IOURingCQ.nring_entries(address());
/*     */     }
/*     */     public Buffer khead(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 518 */       IOURingCQ.nkhead(address(), param1IntBuffer); return this;
/*     */     } public Buffer ktail(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 520 */       IOURingCQ.nktail(address(), param1IntBuffer); return this;
/*     */     } public Buffer kring_mask(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 522 */       IOURingCQ.nkring_mask(address(), param1IntBuffer); return this;
/*     */     } public Buffer kring_entries(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 524 */       IOURingCQ.nkring_entries(address(), param1IntBuffer); return this;
/*     */     } public Buffer kflags(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 526 */       IOURingCQ.nkflags(address(), param1IntBuffer); return this;
/*     */     } public Buffer koverflow(@NativeType("unsigned *") IntBuffer param1IntBuffer) {
/* 528 */       IOURingCQ.nkoverflow(address(), param1IntBuffer); return this;
/*     */     } public Buffer cqes(@NativeType("struct io_uring_cqe *") IOURingCQE param1IOURingCQE) {
/* 530 */       IOURingCQ.ncqes(address(), param1IOURingCQE); return this;
/*     */     } public Buffer ring_ptr(@NativeType("void *") ByteBuffer param1ByteBuffer) {
/* 532 */       IOURingCQ.nring_ptr(address(), param1ByteBuffer); return this;
/*     */     } public Buffer ring_mask(@NativeType("unsigned") int param1Int) {
/* 534 */       IOURingCQ.nring_mask(address(), param1Int); return this;
/*     */     } public Buffer ring_entries(@NativeType("unsigned") int param1Int) {
/* 536 */       IOURingCQ.nring_entries(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingCQ.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */