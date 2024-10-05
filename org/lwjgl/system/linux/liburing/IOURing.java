/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ @NativeType("struct io_uring")
/*     */ public class IOURing
/*     */   extends Struct<IOURing>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SQ;
/*     */   public static final int CQ;
/*     */   public static final int FLAGS;
/*     */   public static final int RING_FD;
/*     */   public static final int FEATURES;
/*     */   public static final int ENTER_RING_FD;
/*     */   public static final int INT_FLAGS;
/*     */   public static final int PAD;
/*     */   public static final int PAD2;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  69 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(IOURingSQ.SIZEOF, IOURingSQ.ALIGNOF), __member(IOURingCQ.SIZEOF, IOURingCQ.ALIGNOF), __member(4), __member(4), __member(4), __member(4), __member(1), __array(1, 3), __member(4) })).getSize();
/*  70 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  72 */     SQ = layout.offsetof(0);
/*  73 */     CQ = layout.offsetof(1);
/*  74 */     FLAGS = layout.offsetof(2);
/*  75 */     RING_FD = layout.offsetof(3);
/*  76 */     FEATURES = layout.offsetof(4);
/*  77 */     ENTER_RING_FD = layout.offsetof(5);
/*  78 */     INT_FLAGS = layout.offsetof(6);
/*  79 */     PAD = layout.offsetof(7);
/*  80 */     PAD2 = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected IOURing(long paramLong, ByteBuffer paramByteBuffer) {
/*  84 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURing create(long paramLong, ByteBuffer paramByteBuffer) {
/*  89 */     return new IOURing(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURing(ByteBuffer paramByteBuffer) {
/*  99 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 103 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("struct io_uring_sq")
/*     */   public IOURingSQ sq() {
/* 107 */     return nsq(address());
/*     */   } @NativeType("struct io_uring_cq")
/*     */   public IOURingCQ cq() {
/* 110 */     return ncq(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int flags() {
/* 113 */     return nflags(address());
/*     */   } public int ring_fd() {
/* 115 */     return nring_fd(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int features() {
/* 118 */     return nfeatures(address());
/*     */   } public int enter_ring_fd() {
/* 120 */     return nenter_ring_fd(address());
/*     */   } @NativeType("__u8")
/*     */   public byte int_flags() {
/* 123 */     return nint_flags(address());
/*     */   }
/*     */   public IOURing sq(@NativeType("struct io_uring_sq") IOURingSQ paramIOURingSQ) {
/* 126 */     nsq(address(), paramIOURingSQ); return this;
/*     */   } public IOURing sq(Consumer<IOURingSQ> paramConsumer) {
/* 128 */     paramConsumer.accept(sq()); return this;
/*     */   } public IOURing cq(@NativeType("struct io_uring_cq") IOURingCQ paramIOURingCQ) {
/* 130 */     ncq(address(), paramIOURingCQ); return this;
/*     */   } public IOURing cq(Consumer<IOURingCQ> paramConsumer) {
/* 132 */     paramConsumer.accept(cq()); return this;
/*     */   } public IOURing flags(@NativeType("unsigned int") int paramInt) {
/* 134 */     nflags(address(), paramInt); return this;
/*     */   } public IOURing ring_fd(int paramInt) {
/* 136 */     nring_fd(address(), paramInt); return this;
/*     */   } public IOURing features(@NativeType("unsigned int") int paramInt) {
/* 138 */     nfeatures(address(), paramInt); return this;
/*     */   } public IOURing enter_ring_fd(int paramInt) {
/* 140 */     nenter_ring_fd(address(), paramInt); return this;
/*     */   } public IOURing int_flags(@NativeType("__u8") byte paramByte) {
/* 142 */     nint_flags(address(), paramByte); return this;
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
/*     */   public IOURing set(IOURingSQ paramIOURingSQ, IOURingCQ paramIOURingCQ, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte) {
/* 154 */     sq(paramIOURingSQ);
/* 155 */     cq(paramIOURingCQ);
/* 156 */     flags(paramInt1);
/* 157 */     ring_fd(paramInt2);
/* 158 */     features(paramInt3);
/* 159 */     enter_ring_fd(paramInt4);
/* 160 */     int_flags(paramByte);
/*     */     
/* 162 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURing set(IOURing paramIOURing) {
/* 173 */     MemoryUtil.memCopy(paramIOURing.address(), address(), SIZEOF);
/* 174 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURing malloc() {
/* 181 */     return new IOURing(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURing calloc() {
/* 186 */     return new IOURing(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURing create() {
/* 191 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 192 */     return new IOURing(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURing create(long paramLong) {
/* 197 */     return new IOURing(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURing createSafe(long paramLong) {
/* 203 */     return (paramLong == 0L) ? null : new IOURing(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 212 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 221 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 230 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 231 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 241 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 247 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURing malloc(MemoryStack paramMemoryStack) {
/* 256 */     return new IOURing(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURing calloc(MemoryStack paramMemoryStack) {
/* 265 */     return new IOURing(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 275 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 285 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSQ nsq(long paramLong) {
/* 291 */     return IOURingSQ.create(paramLong + SQ);
/*     */   } public static IOURingCQ ncq(long paramLong) {
/* 293 */     return IOURingCQ.create(paramLong + CQ);
/*     */   } public static int nflags(long paramLong) {
/* 295 */     return UNSAFE.getInt(null, paramLong + FLAGS);
/*     */   } public static int nring_fd(long paramLong) {
/* 297 */     return UNSAFE.getInt(null, paramLong + RING_FD);
/*     */   } public static int nfeatures(long paramLong) {
/* 299 */     return UNSAFE.getInt(null, paramLong + FEATURES);
/*     */   } public static int nenter_ring_fd(long paramLong) {
/* 301 */     return UNSAFE.getInt(null, paramLong + ENTER_RING_FD);
/*     */   }
/* 303 */   public static byte nint_flags(long paramLong) { return UNSAFE.getByte(null, paramLong + INT_FLAGS); } public static ByteBuffer npad(long paramLong) {
/* 304 */     return MemoryUtil.memByteBuffer(paramLong + PAD, 3);
/*     */   } public static byte npad(long paramLong, int paramInt) {
/* 306 */     return UNSAFE.getByte(null, paramLong + PAD + Checks.check(paramInt, 3));
/*     */   } public static int npad2(long paramLong) {
/* 308 */     return UNSAFE.getInt(null, paramLong + PAD2);
/*     */   }
/*     */   public static void nsq(long paramLong, IOURingSQ paramIOURingSQ) {
/* 311 */     MemoryUtil.memCopy(paramIOURingSQ.address(), paramLong + SQ, IOURingSQ.SIZEOF);
/*     */   } public static void ncq(long paramLong, IOURingCQ paramIOURingCQ) {
/* 313 */     MemoryUtil.memCopy(paramIOURingCQ.address(), paramLong + CQ, IOURingCQ.SIZEOF);
/*     */   } public static void nflags(long paramLong, int paramInt) {
/* 315 */     UNSAFE.putInt(null, paramLong + FLAGS, paramInt);
/*     */   } public static void nring_fd(long paramLong, int paramInt) {
/* 317 */     UNSAFE.putInt(null, paramLong + RING_FD, paramInt);
/*     */   } public static void nfeatures(long paramLong, int paramInt) {
/* 319 */     UNSAFE.putInt(null, paramLong + FEATURES, paramInt);
/*     */   } public static void nenter_ring_fd(long paramLong, int paramInt) {
/* 321 */     UNSAFE.putInt(null, paramLong + ENTER_RING_FD, paramInt);
/*     */   } public static void nint_flags(long paramLong, byte paramByte) {
/* 323 */     UNSAFE.putByte(null, paramLong + INT_FLAGS, paramByte);
/*     */   } public static void npad(long paramLong, ByteBuffer paramByteBuffer) {
/* 325 */     if (Checks.CHECKS) Checks.checkGT(paramByteBuffer, 3); 
/* 326 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramByteBuffer), paramLong + PAD, paramByteBuffer.remaining());
/*     */   }
/*     */   public static void npad(long paramLong, int paramInt, byte paramByte) {
/* 329 */     UNSAFE.putByte(null, paramLong + PAD + Checks.check(paramInt, 3), paramByte);
/*     */   } public static void npad2(long paramLong, int paramInt) {
/* 331 */     UNSAFE.putInt(null, paramLong + PAD2, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 339 */     IOURingSQ.validate(paramLong + SQ);
/* 340 */     IOURingCQ.validate(paramLong + CQ);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURing, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 348 */     private static final IOURing ELEMENT_FACTORY = IOURing.create(-1L);
/*     */ 
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
/* 360 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURing.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 364 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 368 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 373 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURing getElementFactory() {
/* 378 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("struct io_uring_sq")
/*     */     public IOURingSQ sq() {
/* 383 */       return IOURing.nsq(address());
/*     */     } @NativeType("struct io_uring_cq")
/*     */     public IOURingCQ cq() {
/* 386 */       return IOURing.ncq(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int flags() {
/* 389 */       return IOURing.nflags(address());
/*     */     } public int ring_fd() {
/* 391 */       return IOURing.nring_fd(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int features() {
/* 394 */       return IOURing.nfeatures(address());
/*     */     } public int enter_ring_fd() {
/* 396 */       return IOURing.nenter_ring_fd(address());
/*     */     } @NativeType("__u8")
/*     */     public byte int_flags() {
/* 399 */       return IOURing.nint_flags(address());
/*     */     }
/*     */     public Buffer sq(@NativeType("struct io_uring_sq") IOURingSQ param1IOURingSQ) {
/* 402 */       IOURing.nsq(address(), param1IOURingSQ); return this;
/*     */     } public Buffer sq(Consumer<IOURingSQ> param1Consumer) {
/* 404 */       param1Consumer.accept(sq()); return this;
/*     */     } public Buffer cq(@NativeType("struct io_uring_cq") IOURingCQ param1IOURingCQ) {
/* 406 */       IOURing.ncq(address(), param1IOURingCQ); return this;
/*     */     } public Buffer cq(Consumer<IOURingCQ> param1Consumer) {
/* 408 */       param1Consumer.accept(cq()); return this;
/*     */     } public Buffer flags(@NativeType("unsigned int") int param1Int) {
/* 410 */       IOURing.nflags(address(), param1Int); return this;
/*     */     } public Buffer ring_fd(int param1Int) {
/* 412 */       IOURing.nring_fd(address(), param1Int); return this;
/*     */     } public Buffer features(@NativeType("unsigned int") int param1Int) {
/* 414 */       IOURing.nfeatures(address(), param1Int); return this;
/*     */     } public Buffer enter_ring_fd(int param1Int) {
/* 416 */       IOURing.nenter_ring_fd(address(), param1Int); return this;
/*     */     } public Buffer int_flags(@NativeType("__u8") byte param1Byte) {
/* 418 */       IOURing.nint_flags(address(), param1Byte); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */