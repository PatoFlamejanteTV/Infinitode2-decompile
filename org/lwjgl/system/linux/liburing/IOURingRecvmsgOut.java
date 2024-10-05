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
/*     */ @NativeType("struct io_uring_recvmsg_out")
/*     */ public class IOURingRecvmsgOut
/*     */   extends Struct<IOURingRecvmsgOut>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NAMELEN;
/*     */   public static final int CONTROLLEN;
/*     */   public static final int PAYLOADLEN;
/*     */   public static final int FLAGS;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  53 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  54 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  56 */     NAMELEN = layout.offsetof(0);
/*  57 */     CONTROLLEN = layout.offsetof(1);
/*  58 */     PAYLOADLEN = layout.offsetof(2);
/*  59 */     FLAGS = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingRecvmsgOut(long paramLong, ByteBuffer paramByteBuffer) {
/*  63 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRecvmsgOut create(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     return new IOURingRecvmsgOut(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRecvmsgOut(ByteBuffer paramByteBuffer) {
/*  78 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  82 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int namelen() {
/*  86 */     return nnamelen(address());
/*     */   } @NativeType("__u32")
/*     */   public int controllen() {
/*  89 */     return ncontrollen(address());
/*     */   } @NativeType("__u32")
/*     */   public int payloadlen() {
/*  92 */     return npayloadlen(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/*  95 */     return nflags(address());
/*     */   }
/*     */   public IOURingRecvmsgOut namelen(@NativeType("__u32") int paramInt) {
/*  98 */     nnamelen(address(), paramInt); return this;
/*     */   } public IOURingRecvmsgOut controllen(@NativeType("__u32") int paramInt) {
/* 100 */     ncontrollen(address(), paramInt); return this;
/*     */   } public IOURingRecvmsgOut payloadlen(@NativeType("__u32") int paramInt) {
/* 102 */     npayloadlen(address(), paramInt); return this;
/*     */   } public IOURingRecvmsgOut flags(@NativeType("__u32") int paramInt) {
/* 104 */     nflags(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRecvmsgOut set(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 113 */     namelen(paramInt1);
/* 114 */     controllen(paramInt2);
/* 115 */     payloadlen(paramInt3);
/* 116 */     flags(paramInt4);
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
/*     */   public IOURingRecvmsgOut set(IOURingRecvmsgOut paramIOURingRecvmsgOut) {
/* 129 */     MemoryUtil.memCopy(paramIOURingRecvmsgOut.address(), address(), SIZEOF);
/* 130 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut malloc() {
/* 137 */     return new IOURingRecvmsgOut(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut calloc() {
/* 142 */     return new IOURingRecvmsgOut(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut create() {
/* 147 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 148 */     return new IOURingRecvmsgOut(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut create(long paramLong) {
/* 153 */     return new IOURingRecvmsgOut(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut createSafe(long paramLong) {
/* 159 */     return (paramLong == 0L) ? null : new IOURingRecvmsgOut(paramLong, null);
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
/*     */   public static IOURingRecvmsgOut malloc(MemoryStack paramMemoryStack) {
/* 212 */     return new IOURingRecvmsgOut(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut calloc(MemoryStack paramMemoryStack) {
/* 221 */     return new IOURingRecvmsgOut(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static int nnamelen(long paramLong) {
/* 247 */     return UNSAFE.getInt(null, paramLong + NAMELEN);
/*     */   } public static int ncontrollen(long paramLong) {
/* 249 */     return UNSAFE.getInt(null, paramLong + CONTROLLEN);
/*     */   } public static int npayloadlen(long paramLong) {
/* 251 */     return UNSAFE.getInt(null, paramLong + PAYLOADLEN);
/*     */   } public static int nflags(long paramLong) {
/* 253 */     return UNSAFE.getInt(null, paramLong + FLAGS);
/*     */   }
/*     */   public static void nnamelen(long paramLong, int paramInt) {
/* 256 */     UNSAFE.putInt(null, paramLong + NAMELEN, paramInt);
/*     */   } public static void ncontrollen(long paramLong, int paramInt) {
/* 258 */     UNSAFE.putInt(null, paramLong + CONTROLLEN, paramInt);
/*     */   } public static void npayloadlen(long paramLong, int paramInt) {
/* 260 */     UNSAFE.putInt(null, paramLong + PAYLOADLEN, paramInt);
/*     */   } public static void nflags(long paramLong, int paramInt) {
/* 262 */     UNSAFE.putInt(null, paramLong + FLAGS, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRecvmsgOut, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 269 */     private static final IOURingRecvmsgOut ELEMENT_FACTORY = IOURingRecvmsgOut.create(-1L);
/*     */ 
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
/* 281 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingRecvmsgOut.SIZEOF);
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
/*     */     protected IOURingRecvmsgOut getElementFactory() {
/* 299 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int namelen() {
/* 304 */       return IOURingRecvmsgOut.nnamelen(address());
/*     */     } @NativeType("__u32")
/*     */     public int controllen() {
/* 307 */       return IOURingRecvmsgOut.ncontrollen(address());
/*     */     } @NativeType("__u32")
/*     */     public int payloadlen() {
/* 310 */       return IOURingRecvmsgOut.npayloadlen(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 313 */       return IOURingRecvmsgOut.nflags(address());
/*     */     }
/*     */     public Buffer namelen(@NativeType("__u32") int param1Int) {
/* 316 */       IOURingRecvmsgOut.nnamelen(address(), param1Int); return this;
/*     */     } public Buffer controllen(@NativeType("__u32") int param1Int) {
/* 318 */       IOURingRecvmsgOut.ncontrollen(address(), param1Int); return this;
/*     */     } public Buffer payloadlen(@NativeType("__u32") int param1Int) {
/* 320 */       IOURingRecvmsgOut.npayloadlen(address(), param1Int); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int param1Int) {
/* 322 */       IOURingRecvmsgOut.nflags(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingRecvmsgOut.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */