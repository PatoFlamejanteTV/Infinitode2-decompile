/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ @NativeType("struct msghdr")
/*     */ public class Msghdr
/*     */   extends Struct<Msghdr>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int MSG_NAME;
/*     */   public static final int MSG_NAMELEN;
/*     */   public static final int MSG_IOV;
/*     */   public static final int MSG_IOVLEN;
/*     */   public static final int MSG_CONTROL;
/*     */   public static final int MSG_CONTROLLEN;
/*     */   public static final int MSG_FLAGS;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  63 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(4), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(4) })).getSize();
/*  64 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  66 */     MSG_NAME = layout.offsetof(0);
/*  67 */     MSG_NAMELEN = layout.offsetof(1);
/*  68 */     MSG_IOV = layout.offsetof(2);
/*  69 */     MSG_IOVLEN = layout.offsetof(3);
/*  70 */     MSG_CONTROL = layout.offsetof(4);
/*  71 */     MSG_CONTROLLEN = layout.offsetof(5);
/*  72 */     MSG_FLAGS = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected Msghdr(long paramLong, ByteBuffer paramByteBuffer) {
/*  76 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Msghdr create(long paramLong, ByteBuffer paramByteBuffer) {
/*  81 */     return new Msghdr(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Msghdr(ByteBuffer paramByteBuffer) {
/*  91 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  95 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("void *")
/*     */   public ByteBuffer msg_name() {
/*  99 */     return nmsg_name(address());
/*     */   } @NativeType("socklen_t")
/*     */   public int msg_namelen() {
/* 102 */     return nmsg_namelen(address());
/*     */   } @NativeType("struct iovec *")
/*     */   public IOVec.Buffer msg_iov() {
/* 105 */     return nmsg_iov(address());
/*     */   } @NativeType("size_t")
/*     */   public long msg_iovlen() {
/* 108 */     return nmsg_iovlen(address());
/*     */   } @NativeType("void *")
/*     */   public ByteBuffer msg_control() {
/* 111 */     return nmsg_control(address());
/*     */   } @NativeType("size_t")
/*     */   public long msg_controllen() {
/* 114 */     return nmsg_controllen(address());
/*     */   } public int msg_flags() {
/* 116 */     return nmsg_flags(address());
/*     */   }
/*     */   public Msghdr msg_name(@NativeType("void *") ByteBuffer paramByteBuffer) {
/* 119 */     nmsg_name(address(), paramByteBuffer); return this;
/*     */   } public Msghdr msg_iov(@NativeType("struct iovec *") IOVec.Buffer paramBuffer) {
/* 121 */     nmsg_iov(address(), paramBuffer); return this;
/*     */   } public Msghdr msg_control(@NativeType("void *") ByteBuffer paramByteBuffer) {
/* 123 */     nmsg_control(address(), paramByteBuffer); return this;
/*     */   } public Msghdr msg_flags(int paramInt) {
/* 125 */     nmsg_flags(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Msghdr set(ByteBuffer paramByteBuffer1, IOVec.Buffer paramBuffer, ByteBuffer paramByteBuffer2, int paramInt) {
/* 134 */     msg_name(paramByteBuffer1);
/* 135 */     msg_iov(paramBuffer);
/* 136 */     msg_control(paramByteBuffer2);
/* 137 */     msg_flags(paramInt);
/*     */     
/* 139 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Msghdr set(Msghdr paramMsghdr) {
/* 150 */     MemoryUtil.memCopy(paramMsghdr.address(), address(), SIZEOF);
/* 151 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Msghdr malloc() {
/* 158 */     return new Msghdr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Msghdr calloc() {
/* 163 */     return new Msghdr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Msghdr create() {
/* 168 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 169 */     return new Msghdr(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Msghdr create(long paramLong) {
/* 174 */     return new Msghdr(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Msghdr createSafe(long paramLong) {
/* 180 */     return (paramLong == 0L) ? null : new Msghdr(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 189 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 198 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 207 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 208 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 218 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 224 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Msghdr malloc(MemoryStack paramMemoryStack) {
/* 233 */     return new Msghdr(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Msghdr calloc(MemoryStack paramMemoryStack) {
/* 242 */     return new Msghdr(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 252 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 262 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer nmsg_name(long paramLong) {
/* 268 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(paramLong + MSG_NAME), nmsg_namelen(paramLong));
/*     */   } public static int nmsg_namelen(long paramLong) {
/* 270 */     return UNSAFE.getInt(null, paramLong + MSG_NAMELEN);
/*     */   } public static IOVec.Buffer nmsg_iov(long paramLong) {
/* 272 */     return IOVec.create(MemoryUtil.memGetAddress(paramLong + MSG_IOV), (int)nmsg_iovlen(paramLong));
/*     */   } public static long nmsg_iovlen(long paramLong) {
/* 274 */     return MemoryUtil.memGetAddress(paramLong + MSG_IOVLEN);
/*     */   } public static ByteBuffer nmsg_control(long paramLong) {
/* 276 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(paramLong + MSG_CONTROL), (int)nmsg_controllen(paramLong));
/*     */   } public static long nmsg_controllen(long paramLong) {
/* 278 */     return MemoryUtil.memGetAddress(paramLong + MSG_CONTROLLEN);
/*     */   } public static int nmsg_flags(long paramLong) {
/* 280 */     return UNSAFE.getInt(null, paramLong + MSG_FLAGS);
/*     */   }
/*     */   public static void nmsg_name(long paramLong, ByteBuffer paramByteBuffer) {
/* 283 */     MemoryUtil.memPutAddress(paramLong + MSG_NAME, MemoryUtil.memAddress(paramByteBuffer)); nmsg_namelen(paramLong, paramByteBuffer.remaining());
/*     */   } public static void nmsg_namelen(long paramLong, int paramInt) {
/* 285 */     UNSAFE.putInt(null, paramLong + MSG_NAMELEN, paramInt);
/*     */   } public static void nmsg_iov(long paramLong, IOVec.Buffer paramBuffer) {
/* 287 */     MemoryUtil.memPutAddress(paramLong + MSG_IOV, paramBuffer.address()); nmsg_iovlen(paramLong, paramBuffer.remaining());
/*     */   } public static void nmsg_iovlen(long paramLong1, long paramLong2) {
/* 289 */     MemoryUtil.memPutAddress(paramLong1 + MSG_IOVLEN, paramLong2);
/*     */   } public static void nmsg_control(long paramLong, ByteBuffer paramByteBuffer) {
/* 291 */     MemoryUtil.memPutAddress(paramLong + MSG_CONTROL, MemoryUtil.memAddress(paramByteBuffer)); nmsg_controllen(paramLong, paramByteBuffer.remaining());
/*     */   } public static void nmsg_controllen(long paramLong1, long paramLong2) {
/* 293 */     MemoryUtil.memPutAddress(paramLong1 + MSG_CONTROLLEN, paramLong2);
/*     */   } public static void nmsg_flags(long paramLong, int paramInt) {
/* 295 */     UNSAFE.putInt(null, paramLong + MSG_FLAGS, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 303 */     Checks.check(MemoryUtil.memGetAddress(paramLong + MSG_NAME));
/* 304 */     Checks.check(MemoryUtil.memGetAddress(paramLong + MSG_IOV));
/* 305 */     Checks.check(MemoryUtil.memGetAddress(paramLong + MSG_CONTROL));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<Msghdr, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 313 */     private static final Msghdr ELEMENT_FACTORY = Msghdr.create(-1L);
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
/* 325 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / Msghdr.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 329 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 333 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 338 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Msghdr getElementFactory() {
/* 343 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("void *")
/*     */     public ByteBuffer msg_name() {
/* 348 */       return Msghdr.nmsg_name(address());
/*     */     } @NativeType("socklen_t")
/*     */     public int msg_namelen() {
/* 351 */       return Msghdr.nmsg_namelen(address());
/*     */     } @NativeType("struct iovec *")
/*     */     public IOVec.Buffer msg_iov() {
/* 354 */       return Msghdr.nmsg_iov(address());
/*     */     } @NativeType("size_t")
/*     */     public long msg_iovlen() {
/* 357 */       return Msghdr.nmsg_iovlen(address());
/*     */     } @NativeType("void *")
/*     */     public ByteBuffer msg_control() {
/* 360 */       return Msghdr.nmsg_control(address());
/*     */     } @NativeType("size_t")
/*     */     public long msg_controllen() {
/* 363 */       return Msghdr.nmsg_controllen(address());
/*     */     } public int msg_flags() {
/* 365 */       return Msghdr.nmsg_flags(address());
/*     */     }
/*     */     public Buffer msg_name(@NativeType("void *") ByteBuffer param1ByteBuffer) {
/* 368 */       Msghdr.nmsg_name(address(), param1ByteBuffer); return this;
/*     */     } public Buffer msg_iov(@NativeType("struct iovec *") IOVec.Buffer param1Buffer) {
/* 370 */       Msghdr.nmsg_iov(address(), param1Buffer); return this;
/*     */     } public Buffer msg_control(@NativeType("void *") ByteBuffer param1ByteBuffer) {
/* 372 */       Msghdr.nmsg_control(address(), param1ByteBuffer); return this;
/*     */     } public Buffer msg_flags(int param1Int) {
/* 374 */       Msghdr.nmsg_flags(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\Msghdr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */