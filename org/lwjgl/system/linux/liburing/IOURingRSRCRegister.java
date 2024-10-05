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
/*     */ @NativeType("struct io_uring_rsrc_register")
/*     */ public class IOURingRSRCRegister
/*     */   extends Struct<IOURingRSRCRegister>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NR;
/*     */   public static final int FLAGS;
/*     */   public static final int RESV2;
/*     */   public static final int DATA;
/*     */   public static final int TAGS;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  56 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(8), __member(8), __member(8) })).getSize();
/*  57 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  59 */     NR = layout.offsetof(0);
/*  60 */     FLAGS = layout.offsetof(1);
/*  61 */     RESV2 = layout.offsetof(2);
/*  62 */     DATA = layout.offsetof(3);
/*  63 */     TAGS = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected IOURingRSRCRegister(long paramLong, ByteBuffer paramByteBuffer) {
/*  67 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRSRCRegister create(long paramLong, ByteBuffer paramByteBuffer) {
/*  72 */     return new IOURingRSRCRegister(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCRegister(ByteBuffer paramByteBuffer) {
/*  82 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  86 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int nr() {
/*  90 */     return nnr(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/*  93 */     return nflags(address());
/*     */   } @NativeType("__u64")
/*     */   public long resv2() {
/*  96 */     return nresv2(address());
/*     */   } @NativeType("__u64")
/*     */   public long data() {
/*  99 */     return ndata(address());
/*     */   } @NativeType("__u64")
/*     */   public long tags() {
/* 102 */     return ntags(address());
/*     */   }
/*     */   public IOURingRSRCRegister nr(@NativeType("__u32") int paramInt) {
/* 105 */     nnr(address(), paramInt); return this;
/*     */   } public IOURingRSRCRegister flags(@NativeType("__u32") int paramInt) {
/* 107 */     nflags(address(), paramInt); return this;
/*     */   } public IOURingRSRCRegister resv2(@NativeType("__u64") long paramLong) {
/* 109 */     nresv2(address(), paramLong); return this;
/*     */   } public IOURingRSRCRegister data(@NativeType("__u64") long paramLong) {
/* 111 */     ndata(address(), paramLong); return this;
/*     */   } public IOURingRSRCRegister tags(@NativeType("__u64") long paramLong) {
/* 113 */     ntags(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCRegister set(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3) {
/* 123 */     nr(paramInt1);
/* 124 */     flags(paramInt2);
/* 125 */     resv2(paramLong1);
/* 126 */     data(paramLong2);
/* 127 */     tags(paramLong3);
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
/*     */   public IOURingRSRCRegister set(IOURingRSRCRegister paramIOURingRSRCRegister) {
/* 140 */     MemoryUtil.memCopy(paramIOURingRSRCRegister.address(), address(), SIZEOF);
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister malloc() {
/* 148 */     return new IOURingRSRCRegister(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister calloc() {
/* 153 */     return new IOURingRSRCRegister(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister create() {
/* 158 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 159 */     return new IOURingRSRCRegister(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister create(long paramLong) {
/* 164 */     return new IOURingRSRCRegister(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister createSafe(long paramLong) {
/* 170 */     return (paramLong == 0L) ? null : new IOURingRSRCRegister(paramLong, null);
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
/*     */   public static IOURingRSRCRegister malloc(MemoryStack paramMemoryStack) {
/* 223 */     return new IOURingRSRCRegister(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister calloc(MemoryStack paramMemoryStack) {
/* 232 */     return new IOURingRSRCRegister(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static int nnr(long paramLong) {
/* 258 */     return UNSAFE.getInt(null, paramLong + NR);
/*     */   } public static int nflags(long paramLong) {
/* 260 */     return UNSAFE.getInt(null, paramLong + FLAGS);
/*     */   } public static long nresv2(long paramLong) {
/* 262 */     return UNSAFE.getLong(null, paramLong + RESV2);
/*     */   } public static long ndata(long paramLong) {
/* 264 */     return UNSAFE.getLong(null, paramLong + DATA);
/*     */   } public static long ntags(long paramLong) {
/* 266 */     return UNSAFE.getLong(null, paramLong + TAGS);
/*     */   }
/*     */   public static void nnr(long paramLong, int paramInt) {
/* 269 */     UNSAFE.putInt(null, paramLong + NR, paramInt);
/*     */   } public static void nflags(long paramLong, int paramInt) {
/* 271 */     UNSAFE.putInt(null, paramLong + FLAGS, paramInt);
/*     */   } public static void nresv2(long paramLong1, long paramLong2) {
/* 273 */     UNSAFE.putLong(null, paramLong1 + RESV2, paramLong2);
/*     */   } public static void ndata(long paramLong1, long paramLong2) {
/* 275 */     UNSAFE.putLong(null, paramLong1 + DATA, paramLong2);
/*     */   } public static void ntags(long paramLong1, long paramLong2) {
/* 277 */     UNSAFE.putLong(null, paramLong1 + TAGS, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRSRCRegister, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 284 */     private static final IOURingRSRCRegister ELEMENT_FACTORY = IOURingRSRCRegister.create(-1L);
/*     */ 
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
/* 296 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingRSRCRegister.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 300 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 304 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 309 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingRSRCRegister getElementFactory() {
/* 314 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int nr() {
/* 319 */       return IOURingRSRCRegister.nnr(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 322 */       return IOURingRSRCRegister.nflags(address());
/*     */     } @NativeType("__u64")
/*     */     public long resv2() {
/* 325 */       return IOURingRSRCRegister.nresv2(address());
/*     */     } @NativeType("__u64")
/*     */     public long data() {
/* 328 */       return IOURingRSRCRegister.ndata(address());
/*     */     } @NativeType("__u64")
/*     */     public long tags() {
/* 331 */       return IOURingRSRCRegister.ntags(address());
/*     */     }
/*     */     public Buffer nr(@NativeType("__u32") int param1Int) {
/* 334 */       IOURingRSRCRegister.nnr(address(), param1Int); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int param1Int) {
/* 336 */       IOURingRSRCRegister.nflags(address(), param1Int); return this;
/*     */     } public Buffer resv2(@NativeType("__u64") long param1Long) {
/* 338 */       IOURingRSRCRegister.nresv2(address(), param1Long); return this;
/*     */     } public Buffer data(@NativeType("__u64") long param1Long) {
/* 340 */       IOURingRSRCRegister.ndata(address(), param1Long); return this;
/*     */     } public Buffer tags(@NativeType("__u64") long param1Long) {
/* 342 */       IOURingRSRCRegister.ntags(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingRSRCRegister.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */