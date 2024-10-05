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
/*     */ @NativeType("struct io_uring_buf_ring")
/*     */ public class IOURingBufRing
/*     */   extends Struct<IOURingBufRing>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int RESV1;
/*     */   public static final int RESV2;
/*     */   public static final int RESV3;
/*     */   public static final int TAIL;
/*     */   public static final int BUFS;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  65 */     SIZEOF = (layout = __struct(new Struct.Member[] { (Struct.Member)__union(new Struct.Member[] { (Struct.Member)__struct(new Struct.Member[] { __member(8), __member(4), __member(2), __member(2) }), __array(IOURingBuf.SIZEOF, IOURingBuf.ALIGNOF, 0) }) })).getSize();
/*  66 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  68 */     RESV1 = layout.offsetof(2);
/*  69 */     RESV2 = layout.offsetof(3);
/*  70 */     RESV3 = layout.offsetof(4);
/*  71 */     TAIL = layout.offsetof(5);
/*  72 */     BUFS = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected IOURingBufRing(long paramLong, ByteBuffer paramByteBuffer) {
/*  76 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingBufRing create(long paramLong, ByteBuffer paramByteBuffer) {
/*  81 */     return new IOURingBufRing(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufRing(ByteBuffer paramByteBuffer) {
/*  91 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  95 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long resv1() {
/*  99 */     return nresv1(address());
/*     */   } @NativeType("__u32")
/*     */   public int resv2() {
/* 102 */     return nresv2(address());
/*     */   } @NativeType("__u16")
/*     */   public short resv3() {
/* 105 */     return nresv3(address());
/*     */   } @NativeType("__u16")
/*     */   public short tail() {
/* 108 */     return ntail(address());
/*     */   } @NativeType("struct io_uring_buf[0]")
/*     */   public IOURingBuf.Buffer bufs() {
/* 111 */     return nbufs(address());
/*     */   } @NativeType("struct io_uring_buf")
/*     */   public IOURingBuf bufs(int paramInt) {
/* 114 */     return nbufs(address(), paramInt);
/*     */   }
/*     */   public IOURingBufRing resv1(@NativeType("__u64") long paramLong) {
/* 117 */     nresv1(address(), paramLong); return this;
/*     */   } public IOURingBufRing resv2(@NativeType("__u32") int paramInt) {
/* 119 */     nresv2(address(), paramInt); return this;
/*     */   } public IOURingBufRing resv3(@NativeType("__u16") short paramShort) {
/* 121 */     nresv3(address(), paramShort); return this;
/*     */   } public IOURingBufRing tail(@NativeType("__u16") short paramShort) {
/* 123 */     ntail(address(), paramShort); return this;
/*     */   } public IOURingBufRing bufs(@NativeType("struct io_uring_buf[0]") IOURingBuf.Buffer paramBuffer) {
/* 125 */     nbufs(address(), paramBuffer); return this;
/*     */   } public IOURingBufRing bufs(int paramInt, @NativeType("struct io_uring_buf") IOURingBuf paramIOURingBuf) {
/* 127 */     nbufs(address(), paramInt, paramIOURingBuf); return this;
/*     */   } public IOURingBufRing bufs(Consumer<IOURingBuf.Buffer> paramConsumer) {
/* 129 */     paramConsumer.accept(bufs()); return this;
/*     */   } public IOURingBufRing bufs(int paramInt, Consumer<IOURingBuf> paramConsumer) {
/* 131 */     paramConsumer.accept(bufs(paramInt)); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufRing set(IOURingBufRing paramIOURingBufRing) {
/* 141 */     MemoryUtil.memCopy(paramIOURingBufRing.address(), address(), SIZEOF);
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufRing malloc() {
/* 149 */     return new IOURingBufRing(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufRing calloc() {
/* 154 */     return new IOURingBufRing(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufRing create() {
/* 159 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 160 */     return new IOURingBufRing(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufRing create(long paramLong) {
/* 165 */     return new IOURingBufRing(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufRing createSafe(long paramLong) {
/* 171 */     return (paramLong == 0L) ? null : new IOURingBufRing(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 180 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 189 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 198 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 199 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 209 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 215 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufRing malloc(MemoryStack paramMemoryStack) {
/* 224 */     return new IOURingBufRing(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufRing calloc(MemoryStack paramMemoryStack) {
/* 233 */     return new IOURingBufRing(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 243 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 253 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nresv1(long paramLong) {
/* 259 */     return UNSAFE.getLong(null, paramLong + RESV1);
/*     */   } public static int nresv2(long paramLong) {
/* 261 */     return UNSAFE.getInt(null, paramLong + RESV2);
/*     */   } public static short nresv3(long paramLong) {
/* 263 */     return UNSAFE.getShort(null, paramLong + RESV3);
/*     */   } public static short ntail(long paramLong) {
/* 265 */     return UNSAFE.getShort(null, paramLong + TAIL);
/*     */   } public static IOURingBuf.Buffer nbufs(long paramLong) {
/* 267 */     return IOURingBuf.create(paramLong + BUFS, 0);
/*     */   }
/*     */   public static IOURingBuf nbufs(long paramLong, int paramInt) {
/* 270 */     return IOURingBuf.create(paramLong + BUFS + Checks.check(paramInt, 0) * IOURingBuf.SIZEOF);
/*     */   }
/*     */   
/*     */   public static void nresv1(long paramLong1, long paramLong2) {
/* 274 */     UNSAFE.putLong(null, paramLong1 + RESV1, paramLong2);
/*     */   } public static void nresv2(long paramLong, int paramInt) {
/* 276 */     UNSAFE.putInt(null, paramLong + RESV2, paramInt);
/*     */   } public static void nresv3(long paramLong, short paramShort) {
/* 278 */     UNSAFE.putShort(null, paramLong + RESV3, paramShort);
/*     */   } public static void ntail(long paramLong, short paramShort) {
/* 280 */     UNSAFE.putShort(null, paramLong + TAIL, paramShort);
/*     */   }
/*     */   public static void nbufs(long paramLong, IOURingBuf.Buffer paramBuffer) {
/* 283 */     if (Checks.CHECKS) Checks.checkGT((CustomBuffer)paramBuffer, 0); 
/* 284 */     MemoryUtil.memCopy(paramBuffer.address(), paramLong + BUFS, (paramBuffer.remaining() * IOURingBuf.SIZEOF));
/*     */   }
/*     */   
/*     */   public static void nbufs(long paramLong, int paramInt, IOURingBuf paramIOURingBuf) {
/* 288 */     MemoryUtil.memCopy(paramIOURingBuf.address(), paramLong + BUFS + Checks.check(paramInt, 0) * IOURingBuf.SIZEOF, IOURingBuf.SIZEOF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingBufRing, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 296 */     private static final IOURingBufRing ELEMENT_FACTORY = IOURingBufRing.create(-1L);
/*     */ 
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
/* 308 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingBufRing.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 312 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 316 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 321 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingBufRing getElementFactory() {
/* 326 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long resv1() {
/* 331 */       return IOURingBufRing.nresv1(address());
/*     */     } @NativeType("__u32")
/*     */     public int resv2() {
/* 334 */       return IOURingBufRing.nresv2(address());
/*     */     } @NativeType("__u16")
/*     */     public short resv3() {
/* 337 */       return IOURingBufRing.nresv3(address());
/*     */     } @NativeType("__u16")
/*     */     public short tail() {
/* 340 */       return IOURingBufRing.ntail(address());
/*     */     } @NativeType("struct io_uring_buf[0]")
/*     */     public IOURingBuf.Buffer bufs() {
/* 343 */       return IOURingBufRing.nbufs(address());
/*     */     } @NativeType("struct io_uring_buf")
/*     */     public IOURingBuf bufs(int param1Int) {
/* 346 */       return IOURingBufRing.nbufs(address(), param1Int);
/*     */     }
/*     */     public Buffer resv1(@NativeType("__u64") long param1Long) {
/* 349 */       IOURingBufRing.nresv1(address(), param1Long); return this;
/*     */     } public Buffer resv2(@NativeType("__u32") int param1Int) {
/* 351 */       IOURingBufRing.nresv2(address(), param1Int); return this;
/*     */     } public Buffer resv3(@NativeType("__u16") short param1Short) {
/* 353 */       IOURingBufRing.nresv3(address(), param1Short); return this;
/*     */     } public Buffer tail(@NativeType("__u16") short param1Short) {
/* 355 */       IOURingBufRing.ntail(address(), param1Short); return this;
/*     */     } public Buffer bufs(@NativeType("struct io_uring_buf[0]") IOURingBuf.Buffer param1Buffer) {
/* 357 */       IOURingBufRing.nbufs(address(), param1Buffer); return this;
/*     */     } public Buffer bufs(int param1Int, @NativeType("struct io_uring_buf") IOURingBuf param1IOURingBuf) {
/* 359 */       IOURingBufRing.nbufs(address(), param1Int, param1IOURingBuf); return this;
/*     */     } public Buffer bufs(Consumer<IOURingBuf.Buffer> param1Consumer) {
/* 361 */       param1Consumer.accept(bufs()); return this;
/*     */     } public Buffer bufs(int param1Int, Consumer<IOURingBuf> param1Consumer) {
/* 363 */       param1Consumer.accept(bufs(param1Int)); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingBufRing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */