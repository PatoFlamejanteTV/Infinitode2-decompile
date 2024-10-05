/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.LongBuffer;
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
/*     */ @NativeType("struct io_uring_buf_reg")
/*     */ public class IOURingBufReg
/*     */   extends Struct<IOURingBufReg>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int RING_ADDR;
/*     */   public static final int RING_ENTRIES;
/*     */   public static final int BGID;
/*     */   public static final int FLAGS;
/*     */   public static final int RESV;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  59 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(8), __member(4), __member(2), __member(2), __array(8, 3) })).getSize();
/*  60 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  62 */     RING_ADDR = layout.offsetof(0);
/*  63 */     RING_ENTRIES = layout.offsetof(1);
/*  64 */     BGID = layout.offsetof(2);
/*  65 */     FLAGS = layout.offsetof(3);
/*  66 */     RESV = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected IOURingBufReg(long paramLong, ByteBuffer paramByteBuffer) {
/*  70 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingBufReg create(long paramLong, ByteBuffer paramByteBuffer) {
/*  75 */     return new IOURingBufReg(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufReg(ByteBuffer paramByteBuffer) {
/*  85 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  89 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long ring_addr() {
/*  93 */     return nring_addr(address());
/*     */   } @NativeType("__u32")
/*     */   public int ring_entries() {
/*  96 */     return nring_entries(address());
/*     */   } @NativeType("__u16")
/*     */   public short bgid() {
/*  99 */     return nbgid(address());
/*     */   } @NativeType("__u16")
/*     */   public short flags() {
/* 102 */     return nflags(address());
/*     */   } @NativeType("__u64[3]")
/*     */   public LongBuffer resv() {
/* 105 */     return nresv(address());
/*     */   } @NativeType("__u64")
/*     */   public long resv(int paramInt) {
/* 108 */     return nresv(address(), paramInt);
/*     */   }
/*     */   public IOURingBufReg ring_addr(@NativeType("__u64") long paramLong) {
/* 111 */     nring_addr(address(), paramLong); return this;
/*     */   } public IOURingBufReg ring_entries(@NativeType("__u32") int paramInt) {
/* 113 */     nring_entries(address(), paramInt); return this;
/*     */   } public IOURingBufReg bgid(@NativeType("__u16") short paramShort) {
/* 115 */     nbgid(address(), paramShort); return this;
/*     */   } public IOURingBufReg flags(@NativeType("__u16") short paramShort) {
/* 117 */     nflags(address(), paramShort); return this;
/*     */   } public IOURingBufReg resv(@NativeType("__u64[3]") LongBuffer paramLongBuffer) {
/* 119 */     nresv(address(), paramLongBuffer); return this;
/*     */   } public IOURingBufReg resv(int paramInt, @NativeType("__u64") long paramLong) {
/* 121 */     nresv(address(), paramInt, paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufReg set(long paramLong, int paramInt, short paramShort1, short paramShort2, LongBuffer paramLongBuffer) {
/* 131 */     ring_addr(paramLong);
/* 132 */     ring_entries(paramInt);
/* 133 */     bgid(paramShort1);
/* 134 */     flags(paramShort2);
/* 135 */     resv(paramLongBuffer);
/*     */     
/* 137 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufReg set(IOURingBufReg paramIOURingBufReg) {
/* 148 */     MemoryUtil.memCopy(paramIOURingBufReg.address(), address(), SIZEOF);
/* 149 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufReg malloc() {
/* 156 */     return new IOURingBufReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufReg calloc() {
/* 161 */     return new IOURingBufReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufReg create() {
/* 166 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 167 */     return new IOURingBufReg(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufReg create(long paramLong) {
/* 172 */     return new IOURingBufReg(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufReg createSafe(long paramLong) {
/* 178 */     return (paramLong == 0L) ? null : new IOURingBufReg(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 187 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 196 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 205 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 206 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 216 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 222 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufReg malloc(MemoryStack paramMemoryStack) {
/* 231 */     return new IOURingBufReg(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufReg calloc(MemoryStack paramMemoryStack) {
/* 240 */     return new IOURingBufReg(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 250 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 260 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nring_addr(long paramLong) {
/* 266 */     return UNSAFE.getLong(null, paramLong + RING_ADDR);
/*     */   } public static int nring_entries(long paramLong) {
/* 268 */     return UNSAFE.getInt(null, paramLong + RING_ENTRIES);
/*     */   } public static short nbgid(long paramLong) {
/* 270 */     return UNSAFE.getShort(null, paramLong + BGID);
/*     */   } public static short nflags(long paramLong) {
/* 272 */     return UNSAFE.getShort(null, paramLong + FLAGS);
/*     */   } public static LongBuffer nresv(long paramLong) {
/* 274 */     return MemoryUtil.memLongBuffer(paramLong + RESV, 3);
/*     */   }
/*     */   public static long nresv(long paramLong, int paramInt) {
/* 277 */     return UNSAFE.getLong(null, paramLong + RESV + (Checks.check(paramInt, 3) << 3L));
/*     */   }
/*     */   
/*     */   public static void nring_addr(long paramLong1, long paramLong2) {
/* 281 */     UNSAFE.putLong(null, paramLong1 + RING_ADDR, paramLong2);
/*     */   } public static void nring_entries(long paramLong, int paramInt) {
/* 283 */     UNSAFE.putInt(null, paramLong + RING_ENTRIES, paramInt);
/*     */   } public static void nbgid(long paramLong, short paramShort) {
/* 285 */     UNSAFE.putShort(null, paramLong + BGID, paramShort);
/*     */   } public static void nflags(long paramLong, short paramShort) {
/* 287 */     UNSAFE.putShort(null, paramLong + FLAGS, paramShort);
/*     */   }
/*     */   public static void nresv(long paramLong, LongBuffer paramLongBuffer) {
/* 290 */     if (Checks.CHECKS) Checks.checkGT(paramLongBuffer, 3); 
/* 291 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramLongBuffer), paramLong + RESV, (paramLongBuffer.remaining() << 3));
/*     */   }
/*     */   
/*     */   public static void nresv(long paramLong1, int paramInt, long paramLong2) {
/* 295 */     UNSAFE.putLong(null, paramLong1 + RESV + (Checks.check(paramInt, 3) << 3L), paramLong2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingBufReg, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 303 */     private static final IOURingBufReg ELEMENT_FACTORY = IOURingBufReg.create(-1L);
/*     */ 
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
/* 315 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingBufReg.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 319 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 323 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 328 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingBufReg getElementFactory() {
/* 333 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long ring_addr() {
/* 338 */       return IOURingBufReg.nring_addr(address());
/*     */     } @NativeType("__u32")
/*     */     public int ring_entries() {
/* 341 */       return IOURingBufReg.nring_entries(address());
/*     */     } @NativeType("__u16")
/*     */     public short bgid() {
/* 344 */       return IOURingBufReg.nbgid(address());
/*     */     } @NativeType("__u16")
/*     */     public short flags() {
/* 347 */       return IOURingBufReg.nflags(address());
/*     */     } @NativeType("__u64[3]")
/*     */     public LongBuffer resv() {
/* 350 */       return IOURingBufReg.nresv(address());
/*     */     } @NativeType("__u64")
/*     */     public long resv(int param1Int) {
/* 353 */       return IOURingBufReg.nresv(address(), param1Int);
/*     */     }
/*     */     public Buffer ring_addr(@NativeType("__u64") long param1Long) {
/* 356 */       IOURingBufReg.nring_addr(address(), param1Long); return this;
/*     */     } public Buffer ring_entries(@NativeType("__u32") int param1Int) {
/* 358 */       IOURingBufReg.nring_entries(address(), param1Int); return this;
/*     */     } public Buffer bgid(@NativeType("__u16") short param1Short) {
/* 360 */       IOURingBufReg.nbgid(address(), param1Short); return this;
/*     */     } public Buffer flags(@NativeType("__u16") short param1Short) {
/* 362 */       IOURingBufReg.nflags(address(), param1Short); return this;
/*     */     } public Buffer resv(@NativeType("__u64[3]") LongBuffer param1LongBuffer) {
/* 364 */       IOURingBufReg.nresv(address(), param1LongBuffer); return this;
/*     */     } public Buffer resv(int param1Int, @NativeType("__u64") long param1Long) {
/* 366 */       IOURingBufReg.nresv(address(), param1Int, param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingBufReg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */