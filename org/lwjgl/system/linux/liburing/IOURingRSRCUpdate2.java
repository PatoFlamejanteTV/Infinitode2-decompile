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
/*     */ @NativeType("struct io_uring_rsrc_update2")
/*     */ public class IOURingRSRCUpdate2
/*     */   extends Struct<IOURingRSRCUpdate2>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OFFSET;
/*     */   public static final int RESV;
/*     */   public static final int DATA;
/*     */   public static final int TAGS;
/*     */   public static final int NR;
/*     */   public static final int RESV2;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  59 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(8), __member(8), __member(4), __member(4) })).getSize();
/*  60 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  62 */     OFFSET = layout.offsetof(0);
/*  63 */     RESV = layout.offsetof(1);
/*  64 */     DATA = layout.offsetof(2);
/*  65 */     TAGS = layout.offsetof(3);
/*  66 */     NR = layout.offsetof(4);
/*  67 */     RESV2 = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected IOURingRSRCUpdate2(long paramLong, ByteBuffer paramByteBuffer) {
/*  71 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRSRCUpdate2 create(long paramLong, ByteBuffer paramByteBuffer) {
/*  76 */     return new IOURingRSRCUpdate2(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate2(ByteBuffer paramByteBuffer) {
/*  86 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  90 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int offset() {
/*  94 */     return noffset(address());
/*     */   } @NativeType("__u32")
/*     */   public int resv() {
/*  97 */     return nresv(address());
/*     */   } @NativeType("__u64")
/*     */   public long data() {
/* 100 */     return ndata(address());
/*     */   } @NativeType("__u64")
/*     */   public long tags() {
/* 103 */     return ntags(address());
/*     */   } @NativeType("__u32")
/*     */   public int nr() {
/* 106 */     return nnr(address());
/*     */   } @NativeType("__u32")
/*     */   public int resv2() {
/* 109 */     return nresv2(address());
/*     */   }
/*     */   public IOURingRSRCUpdate2 offset(@NativeType("__u32") int paramInt) {
/* 112 */     noffset(address(), paramInt); return this;
/*     */   } public IOURingRSRCUpdate2 resv(@NativeType("__u32") int paramInt) {
/* 114 */     nresv(address(), paramInt); return this;
/*     */   } public IOURingRSRCUpdate2 data(@NativeType("__u64") long paramLong) {
/* 116 */     ndata(address(), paramLong); return this;
/*     */   } public IOURingRSRCUpdate2 tags(@NativeType("__u64") long paramLong) {
/* 118 */     ntags(address(), paramLong); return this;
/*     */   } public IOURingRSRCUpdate2 nr(@NativeType("__u32") int paramInt) {
/* 120 */     nnr(address(), paramInt); return this;
/*     */   } public IOURingRSRCUpdate2 resv2(@NativeType("__u32") int paramInt) {
/* 122 */     nresv2(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate2 set(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4) {
/* 133 */     offset(paramInt1);
/* 134 */     resv(paramInt2);
/* 135 */     data(paramLong1);
/* 136 */     tags(paramLong2);
/* 137 */     nr(paramInt3);
/* 138 */     resv2(paramInt4);
/*     */     
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate2 set(IOURingRSRCUpdate2 paramIOURingRSRCUpdate2) {
/* 151 */     MemoryUtil.memCopy(paramIOURingRSRCUpdate2.address(), address(), SIZEOF);
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 malloc() {
/* 159 */     return new IOURingRSRCUpdate2(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 calloc() {
/* 164 */     return new IOURingRSRCUpdate2(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 create() {
/* 169 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 170 */     return new IOURingRSRCUpdate2(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 create(long paramLong) {
/* 175 */     return new IOURingRSRCUpdate2(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 createSafe(long paramLong) {
/* 181 */     return (paramLong == 0L) ? null : new IOURingRSRCUpdate2(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 190 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 199 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 208 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 209 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 219 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 225 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 malloc(MemoryStack paramMemoryStack) {
/* 234 */     return new IOURingRSRCUpdate2(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 calloc(MemoryStack paramMemoryStack) {
/* 243 */     return new IOURingRSRCUpdate2(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 253 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 263 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int noffset(long paramLong) {
/* 269 */     return UNSAFE.getInt(null, paramLong + OFFSET);
/*     */   } public static int nresv(long paramLong) {
/* 271 */     return UNSAFE.getInt(null, paramLong + RESV);
/*     */   } public static long ndata(long paramLong) {
/* 273 */     return UNSAFE.getLong(null, paramLong + DATA);
/*     */   } public static long ntags(long paramLong) {
/* 275 */     return UNSAFE.getLong(null, paramLong + TAGS);
/*     */   } public static int nnr(long paramLong) {
/* 277 */     return UNSAFE.getInt(null, paramLong + NR);
/*     */   } public static int nresv2(long paramLong) {
/* 279 */     return UNSAFE.getInt(null, paramLong + RESV2);
/*     */   }
/*     */   public static void noffset(long paramLong, int paramInt) {
/* 282 */     UNSAFE.putInt(null, paramLong + OFFSET, paramInt);
/*     */   } public static void nresv(long paramLong, int paramInt) {
/* 284 */     UNSAFE.putInt(null, paramLong + RESV, paramInt);
/*     */   } public static void ndata(long paramLong1, long paramLong2) {
/* 286 */     UNSAFE.putLong(null, paramLong1 + DATA, paramLong2);
/*     */   } public static void ntags(long paramLong1, long paramLong2) {
/* 288 */     UNSAFE.putLong(null, paramLong1 + TAGS, paramLong2);
/*     */   } public static void nnr(long paramLong, int paramInt) {
/* 290 */     UNSAFE.putInt(null, paramLong + NR, paramInt);
/*     */   } public static void nresv2(long paramLong, int paramInt) {
/* 292 */     UNSAFE.putInt(null, paramLong + RESV2, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRSRCUpdate2, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 299 */     private static final IOURingRSRCUpdate2 ELEMENT_FACTORY = IOURingRSRCUpdate2.create(-1L);
/*     */ 
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
/* 311 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingRSRCUpdate2.SIZEOF);
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
/*     */     protected IOURingRSRCUpdate2 getElementFactory() {
/* 329 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int offset() {
/* 334 */       return IOURingRSRCUpdate2.noffset(address());
/*     */     } @NativeType("__u32")
/*     */     public int resv() {
/* 337 */       return IOURingRSRCUpdate2.nresv(address());
/*     */     } @NativeType("__u64")
/*     */     public long data() {
/* 340 */       return IOURingRSRCUpdate2.ndata(address());
/*     */     } @NativeType("__u64")
/*     */     public long tags() {
/* 343 */       return IOURingRSRCUpdate2.ntags(address());
/*     */     } @NativeType("__u32")
/*     */     public int nr() {
/* 346 */       return IOURingRSRCUpdate2.nnr(address());
/*     */     } @NativeType("__u32")
/*     */     public int resv2() {
/* 349 */       return IOURingRSRCUpdate2.nresv2(address());
/*     */     }
/*     */     public Buffer offset(@NativeType("__u32") int param1Int) {
/* 352 */       IOURingRSRCUpdate2.noffset(address(), param1Int); return this;
/*     */     } public Buffer resv(@NativeType("__u32") int param1Int) {
/* 354 */       IOURingRSRCUpdate2.nresv(address(), param1Int); return this;
/*     */     } public Buffer data(@NativeType("__u64") long param1Long) {
/* 356 */       IOURingRSRCUpdate2.ndata(address(), param1Long); return this;
/*     */     } public Buffer tags(@NativeType("__u64") long param1Long) {
/* 358 */       IOURingRSRCUpdate2.ntags(address(), param1Long); return this;
/*     */     } public Buffer nr(@NativeType("__u32") int param1Int) {
/* 360 */       IOURingRSRCUpdate2.nnr(address(), param1Int); return this;
/*     */     } public Buffer resv2(@NativeType("__u32") int param1Int) {
/* 362 */       IOURingRSRCUpdate2.nresv2(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingRSRCUpdate2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */