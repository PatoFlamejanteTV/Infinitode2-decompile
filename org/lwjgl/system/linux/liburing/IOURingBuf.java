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
/*     */ @NativeType("struct io_uring_buf")
/*     */ public class IOURingBuf
/*     */   extends Struct<IOURingBuf>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ADDR;
/*     */   public static final int LEN;
/*     */   public static final int BID;
/*     */   public static final int RESV;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  53 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(8), __member(4), __member(2), __member(2) })).getSize();
/*  54 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  56 */     ADDR = layout.offsetof(0);
/*  57 */     LEN = layout.offsetof(1);
/*  58 */     BID = layout.offsetof(2);
/*  59 */     RESV = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingBuf(long paramLong, ByteBuffer paramByteBuffer) {
/*  63 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingBuf create(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     return new IOURingBuf(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBuf(ByteBuffer paramByteBuffer) {
/*  78 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  82 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long addr() {
/*  86 */     return naddr(address());
/*     */   } @NativeType("__u32")
/*     */   public int len() {
/*  89 */     return nlen(address());
/*     */   } @NativeType("__u16")
/*     */   public short bid() {
/*  92 */     return nbid(address());
/*     */   } @NativeType("__u16")
/*     */   public short resv() {
/*  95 */     return nresv(address());
/*     */   }
/*     */   public IOURingBuf addr(@NativeType("__u64") long paramLong) {
/*  98 */     naddr(address(), paramLong); return this;
/*     */   } public IOURingBuf len(@NativeType("__u32") int paramInt) {
/* 100 */     nlen(address(), paramInt); return this;
/*     */   } public IOURingBuf bid(@NativeType("__u16") short paramShort) {
/* 102 */     nbid(address(), paramShort); return this;
/*     */   } public IOURingBuf resv(@NativeType("__u16") short paramShort) {
/* 104 */     nresv(address(), paramShort); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBuf set(long paramLong, int paramInt, short paramShort1, short paramShort2) {
/* 113 */     addr(paramLong);
/* 114 */     len(paramInt);
/* 115 */     bid(paramShort1);
/* 116 */     resv(paramShort2);
/*     */     
/* 118 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBuf set(IOURingBuf paramIOURingBuf) {
/* 129 */     MemoryUtil.memCopy(paramIOURingBuf.address(), address(), SIZEOF);
/* 130 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBuf malloc() {
/* 137 */     return new IOURingBuf(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBuf calloc() {
/* 142 */     return new IOURingBuf(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBuf create() {
/* 147 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 148 */     return new IOURingBuf(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBuf create(long paramLong) {
/* 153 */     return new IOURingBuf(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBuf createSafe(long paramLong) {
/* 159 */     return (paramLong == 0L) ? null : new IOURingBuf(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 168 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 177 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 186 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 187 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 197 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 203 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBuf malloc(MemoryStack paramMemoryStack) {
/* 212 */     return new IOURingBuf(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBuf calloc(MemoryStack paramMemoryStack) {
/* 221 */     return new IOURingBuf(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 231 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 241 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long naddr(long paramLong) {
/* 247 */     return UNSAFE.getLong(null, paramLong + ADDR);
/*     */   } public static int nlen(long paramLong) {
/* 249 */     return UNSAFE.getInt(null, paramLong + LEN);
/*     */   } public static short nbid(long paramLong) {
/* 251 */     return UNSAFE.getShort(null, paramLong + BID);
/*     */   } public static short nresv(long paramLong) {
/* 253 */     return UNSAFE.getShort(null, paramLong + RESV);
/*     */   }
/*     */   public static void naddr(long paramLong1, long paramLong2) {
/* 256 */     UNSAFE.putLong(null, paramLong1 + ADDR, paramLong2);
/*     */   } public static void nlen(long paramLong, int paramInt) {
/* 258 */     UNSAFE.putInt(null, paramLong + LEN, paramInt);
/*     */   } public static void nbid(long paramLong, short paramShort) {
/* 260 */     UNSAFE.putShort(null, paramLong + BID, paramShort);
/*     */   } public static void nresv(long paramLong, short paramShort) {
/* 262 */     UNSAFE.putShort(null, paramLong + RESV, paramShort);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingBuf, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 269 */     private static final IOURingBuf ELEMENT_FACTORY = IOURingBuf.create(-1L);
/*     */ 
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
/* 281 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingBuf.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 285 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 289 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 294 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingBuf getElementFactory() {
/* 299 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long addr() {
/* 304 */       return IOURingBuf.naddr(address());
/*     */     } @NativeType("__u32")
/*     */     public int len() {
/* 307 */       return IOURingBuf.nlen(address());
/*     */     } @NativeType("__u16")
/*     */     public short bid() {
/* 310 */       return IOURingBuf.nbid(address());
/*     */     } @NativeType("__u16")
/*     */     public short resv() {
/* 313 */       return IOURingBuf.nresv(address());
/*     */     }
/*     */     public Buffer addr(@NativeType("__u64") long param1Long) {
/* 316 */       IOURingBuf.naddr(address(), param1Long); return this;
/*     */     } public Buffer len(@NativeType("__u32") int param1Int) {
/* 318 */       IOURingBuf.nlen(address(), param1Int); return this;
/*     */     } public Buffer bid(@NativeType("__u16") short param1Short) {
/* 320 */       IOURingBuf.nbid(address(), param1Short); return this;
/*     */     } public Buffer resv(@NativeType("__u16") short param1Short) {
/* 322 */       IOURingBuf.nresv(address(), param1Short); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingBuf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */