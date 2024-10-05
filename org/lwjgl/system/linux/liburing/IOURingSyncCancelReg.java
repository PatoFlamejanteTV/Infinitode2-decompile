/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.LongBuffer;
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
/*     */ import org.lwjgl.system.linux.KernelTimespec;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct io_uring_sync_cancel_reg")
/*     */ public class IOURingSyncCancelReg
/*     */   extends Struct<IOURingSyncCancelReg>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ADDR;
/*     */   public static final int FD;
/*     */   public static final int FLAGS;
/*     */   public static final int TIMEOUT;
/*     */   public static final int PAD;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  61 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(8), __member(4), __member(4), __member(KernelTimespec.SIZEOF, KernelTimespec.ALIGNOF), __array(8, 4) })).getSize();
/*  62 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  64 */     ADDR = layout.offsetof(0);
/*  65 */     FD = layout.offsetof(1);
/*  66 */     FLAGS = layout.offsetof(2);
/*  67 */     TIMEOUT = layout.offsetof(3);
/*  68 */     PAD = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected IOURingSyncCancelReg(long paramLong, ByteBuffer paramByteBuffer) {
/*  72 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingSyncCancelReg create(long paramLong, ByteBuffer paramByteBuffer) {
/*  77 */     return new IOURingSyncCancelReg(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingSyncCancelReg(ByteBuffer paramByteBuffer) {
/*  87 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  91 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long addr() {
/*  95 */     return naddr(address());
/*     */   } @NativeType("__s32")
/*     */   public int fd() {
/*  98 */     return nfd(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 101 */     return nflags(address());
/*     */   } @NativeType("struct __kernel_timespec")
/*     */   public KernelTimespec timeout() {
/* 104 */     return ntimeout(address());
/*     */   }
/*     */   public IOURingSyncCancelReg addr(@NativeType("__u64") long paramLong) {
/* 107 */     naddr(address(), paramLong); return this;
/*     */   } public IOURingSyncCancelReg fd(@NativeType("__s32") int paramInt) {
/* 109 */     nfd(address(), paramInt); return this;
/*     */   } public IOURingSyncCancelReg flags(@NativeType("__u32") int paramInt) {
/* 111 */     nflags(address(), paramInt); return this;
/*     */   } public IOURingSyncCancelReg timeout(@NativeType("struct __kernel_timespec") KernelTimespec paramKernelTimespec) {
/* 113 */     ntimeout(address(), paramKernelTimespec); return this;
/*     */   } public IOURingSyncCancelReg timeout(Consumer<KernelTimespec> paramConsumer) {
/* 115 */     paramConsumer.accept(timeout()); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingSyncCancelReg set(long paramLong, int paramInt1, int paramInt2, KernelTimespec paramKernelTimespec) {
/* 124 */     addr(paramLong);
/* 125 */     fd(paramInt1);
/* 126 */     flags(paramInt2);
/* 127 */     timeout(paramKernelTimespec);
/*     */     
/* 129 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingSyncCancelReg set(IOURingSyncCancelReg paramIOURingSyncCancelReg) {
/* 140 */     MemoryUtil.memCopy(paramIOURingSyncCancelReg.address(), address(), SIZEOF);
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg malloc() {
/* 148 */     return new IOURingSyncCancelReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg calloc() {
/* 153 */     return new IOURingSyncCancelReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg create() {
/* 158 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 159 */     return new IOURingSyncCancelReg(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg create(long paramLong) {
/* 164 */     return new IOURingSyncCancelReg(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg createSafe(long paramLong) {
/* 170 */     return (paramLong == 0L) ? null : new IOURingSyncCancelReg(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 179 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 188 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 197 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 198 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 208 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 214 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg malloc(MemoryStack paramMemoryStack) {
/* 223 */     return new IOURingSyncCancelReg(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg calloc(MemoryStack paramMemoryStack) {
/* 232 */     return new IOURingSyncCancelReg(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 242 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 252 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long naddr(long paramLong) {
/* 258 */     return UNSAFE.getLong(null, paramLong + ADDR);
/*     */   } public static int nfd(long paramLong) {
/* 260 */     return UNSAFE.getInt(null, paramLong + FD);
/*     */   } public static int nflags(long paramLong) {
/* 262 */     return UNSAFE.getInt(null, paramLong + FLAGS);
/*     */   }
/* 264 */   public static KernelTimespec ntimeout(long paramLong) { return KernelTimespec.create(paramLong + TIMEOUT); } public static LongBuffer npad(long paramLong) {
/* 265 */     return MemoryUtil.memLongBuffer(paramLong + PAD, 4);
/*     */   } public static long npad(long paramLong, int paramInt) {
/* 267 */     return UNSAFE.getLong(null, paramLong + PAD + (Checks.check(paramInt, 4) << 3L));
/*     */   }
/*     */   
/*     */   public static void naddr(long paramLong1, long paramLong2) {
/* 271 */     UNSAFE.putLong(null, paramLong1 + ADDR, paramLong2);
/*     */   } public static void nfd(long paramLong, int paramInt) {
/* 273 */     UNSAFE.putInt(null, paramLong + FD, paramInt);
/*     */   } public static void nflags(long paramLong, int paramInt) {
/* 275 */     UNSAFE.putInt(null, paramLong + FLAGS, paramInt);
/*     */   } public static void ntimeout(long paramLong, KernelTimespec paramKernelTimespec) {
/* 277 */     MemoryUtil.memCopy(paramKernelTimespec.address(), paramLong + TIMEOUT, KernelTimespec.SIZEOF);
/*     */   } public static void npad(long paramLong, LongBuffer paramLongBuffer) {
/* 279 */     if (Checks.CHECKS) Checks.checkGT(paramLongBuffer, 4); 
/* 280 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramLongBuffer), paramLong + PAD, (paramLongBuffer.remaining() << 3));
/*     */   }
/*     */   public static void npad(long paramLong1, int paramInt, long paramLong2) {
/* 283 */     UNSAFE.putLong(null, paramLong1 + PAD + (Checks.check(paramInt, 4) << 3L), paramLong2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingSyncCancelReg, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 291 */     private static final IOURingSyncCancelReg ELEMENT_FACTORY = IOURingSyncCancelReg.create(-1L);
/*     */ 
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
/* 303 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingSyncCancelReg.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 307 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 311 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 316 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingSyncCancelReg getElementFactory() {
/* 321 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long addr() {
/* 326 */       return IOURingSyncCancelReg.naddr(address());
/*     */     } @NativeType("__s32")
/*     */     public int fd() {
/* 329 */       return IOURingSyncCancelReg.nfd(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 332 */       return IOURingSyncCancelReg.nflags(address());
/*     */     } @NativeType("struct __kernel_timespec")
/*     */     public KernelTimespec timeout() {
/* 335 */       return IOURingSyncCancelReg.ntimeout(address());
/*     */     }
/*     */     public Buffer addr(@NativeType("__u64") long param1Long) {
/* 338 */       IOURingSyncCancelReg.naddr(address(), param1Long); return this;
/*     */     } public Buffer fd(@NativeType("__s32") int param1Int) {
/* 340 */       IOURingSyncCancelReg.nfd(address(), param1Int); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int param1Int) {
/* 342 */       IOURingSyncCancelReg.nflags(address(), param1Int); return this;
/*     */     } public Buffer timeout(@NativeType("struct __kernel_timespec") KernelTimespec param1KernelTimespec) {
/* 344 */       IOURingSyncCancelReg.ntimeout(address(), param1KernelTimespec); return this;
/*     */     } public Buffer timeout(Consumer<KernelTimespec> param1Consumer) {
/* 346 */       param1Consumer.accept(timeout()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingSyncCancelReg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */