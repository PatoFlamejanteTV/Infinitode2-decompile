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
/*     */ @NativeType("struct io_uring_cqe")
/*     */ public class IOURingCQE
/*     */   extends Struct<IOURingCQE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int USER_DATA;
/*     */   public static final int RES;
/*     */   public static final int FLAGS;
/*     */   public static final int BIG_CQE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  56 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(8), __member(4), __member(4), __array(8, 0) })).getSize();
/*  57 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  59 */     USER_DATA = layout.offsetof(0);
/*  60 */     RES = layout.offsetof(1);
/*  61 */     FLAGS = layout.offsetof(2);
/*  62 */     BIG_CQE = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingCQE(long paramLong, ByteBuffer paramByteBuffer) {
/*  66 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingCQE create(long paramLong, ByteBuffer paramByteBuffer) {
/*  71 */     return new IOURingCQE(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCQE(ByteBuffer paramByteBuffer) {
/*  81 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("__u64")
/*     */   public long user_data() {
/*  93 */     return nuser_data(address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("__s32")
/*     */   public int res() {
/* 103 */     return nres(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 106 */     return nflags(address());
/*     */   } @NativeType("__u64[0]")
/*     */   public LongBuffer big_cqe() {
/* 109 */     return nbig_cqe(address());
/*     */   } @NativeType("__u64")
/*     */   public long big_cqe(int paramInt) {
/* 112 */     return nbig_cqe(address(), paramInt);
/*     */   }
/*     */   public IOURingCQE user_data(@NativeType("__u64") long paramLong) {
/* 115 */     nuser_data(address(), paramLong); return this;
/*     */   } public IOURingCQE res(@NativeType("__s32") int paramInt) {
/* 117 */     nres(address(), paramInt); return this;
/*     */   } public IOURingCQE flags(@NativeType("__u32") int paramInt) {
/* 119 */     nflags(address(), paramInt); return this;
/*     */   } public IOURingCQE big_cqe(@NativeType("__u64[0]") LongBuffer paramLongBuffer) {
/* 121 */     nbig_cqe(address(), paramLongBuffer); return this;
/*     */   } public IOURingCQE big_cqe(int paramInt, @NativeType("__u64") long paramLong) {
/* 123 */     nbig_cqe(address(), paramInt, paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCQE set(long paramLong, int paramInt1, int paramInt2, LongBuffer paramLongBuffer) {
/* 132 */     user_data(paramLong);
/* 133 */     res(paramInt1);
/* 134 */     flags(paramInt2);
/* 135 */     big_cqe(paramLongBuffer);
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
/*     */   public IOURingCQE set(IOURingCQE paramIOURingCQE) {
/* 148 */     MemoryUtil.memCopy(paramIOURingCQE.address(), address(), SIZEOF);
/* 149 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQE malloc() {
/* 156 */     return new IOURingCQE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQE calloc() {
/* 161 */     return new IOURingCQE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQE create() {
/* 166 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 167 */     return new IOURingCQE(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQE create(long paramLong) {
/* 172 */     return new IOURingCQE(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQE createSafe(long paramLong) {
/* 178 */     return (paramLong == 0L) ? null : new IOURingCQE(paramLong, null);
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
/*     */   public static IOURingCQE malloc(MemoryStack paramMemoryStack) {
/* 231 */     return new IOURingCQE(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQE calloc(MemoryStack paramMemoryStack) {
/* 240 */     return new IOURingCQE(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static long nuser_data(long paramLong) {
/* 266 */     return UNSAFE.getLong(null, paramLong + USER_DATA);
/*     */   } public static int nres(long paramLong) {
/* 268 */     return UNSAFE.getInt(null, paramLong + RES);
/*     */   } public static int nflags(long paramLong) {
/* 270 */     return UNSAFE.getInt(null, paramLong + FLAGS);
/*     */   } public static LongBuffer nbig_cqe(long paramLong) {
/* 272 */     return MemoryUtil.memLongBuffer(paramLong + BIG_CQE, 0);
/*     */   }
/*     */   public static long nbig_cqe(long paramLong, int paramInt) {
/* 275 */     return UNSAFE.getLong(null, paramLong + BIG_CQE + (Checks.check(paramInt, 0) << 3L));
/*     */   }
/*     */   
/*     */   public static void nuser_data(long paramLong1, long paramLong2) {
/* 279 */     UNSAFE.putLong(null, paramLong1 + USER_DATA, paramLong2);
/*     */   } public static void nres(long paramLong, int paramInt) {
/* 281 */     UNSAFE.putInt(null, paramLong + RES, paramInt);
/*     */   } public static void nflags(long paramLong, int paramInt) {
/* 283 */     UNSAFE.putInt(null, paramLong + FLAGS, paramInt);
/*     */   }
/*     */   public static void nbig_cqe(long paramLong, LongBuffer paramLongBuffer) {
/* 286 */     if (Checks.CHECKS) Checks.checkGT(paramLongBuffer, 0); 
/* 287 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramLongBuffer), paramLong + BIG_CQE, (paramLongBuffer.remaining() << 3));
/*     */   }
/*     */   
/*     */   public static void nbig_cqe(long paramLong1, int paramInt, long paramLong2) {
/* 291 */     UNSAFE.putLong(null, paramLong1 + BIG_CQE + (Checks.check(paramInt, 0) << 3L), paramLong2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingCQE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 299 */     private static final IOURingCQE ELEMENT_FACTORY = IOURingCQE.create(-1L);
/*     */ 
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
/* 311 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingCQE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 315 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 319 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 324 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingCQE getElementFactory() {
/* 329 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long user_data() {
/* 334 */       return IOURingCQE.nuser_data(address());
/*     */     } @NativeType("__s32")
/*     */     public int res() {
/* 337 */       return IOURingCQE.nres(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 340 */       return IOURingCQE.nflags(address());
/*     */     } @NativeType("__u64[0]")
/*     */     public LongBuffer big_cqe() {
/* 343 */       return IOURingCQE.nbig_cqe(address());
/*     */     } @NativeType("__u64")
/*     */     public long big_cqe(int param1Int) {
/* 346 */       return IOURingCQE.nbig_cqe(address(), param1Int);
/*     */     }
/*     */     public Buffer user_data(@NativeType("__u64") long param1Long) {
/* 349 */       IOURingCQE.nuser_data(address(), param1Long); return this;
/*     */     } public Buffer res(@NativeType("__s32") int param1Int) {
/* 351 */       IOURingCQE.nres(address(), param1Int); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int param1Int) {
/* 353 */       IOURingCQE.nflags(address(), param1Int); return this;
/*     */     } public Buffer big_cqe(@NativeType("__u64[0]") LongBuffer param1LongBuffer) {
/* 355 */       IOURingCQE.nbig_cqe(address(), param1LongBuffer); return this;
/*     */     } public Buffer big_cqe(int param1Int, @NativeType("__u64") long param1Long) {
/* 357 */       IOURingCQE.nbig_cqe(address(), param1Int, param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingCQE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */