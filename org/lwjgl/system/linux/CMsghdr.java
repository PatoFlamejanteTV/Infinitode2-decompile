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
/*     */ @NativeType("struct cmsghdr")
/*     */ public class CMsghdr
/*     */   extends Struct<CMsghdr>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CMSG_LEN;
/*     */   public static final int CMSG_LEVEL;
/*     */   public static final int CMSG_TYPE;
/*     */   public static final int CMSG_DATA;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  54 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __array(1, 0) })).getSize();
/*  55 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  57 */     CMSG_LEN = layout.offsetof(0);
/*  58 */     CMSG_LEVEL = layout.offsetof(1);
/*  59 */     CMSG_TYPE = layout.offsetof(2);
/*  60 */     CMSG_DATA = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected CMsghdr(long paramLong, ByteBuffer paramByteBuffer) {
/*  64 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CMsghdr create(long paramLong, ByteBuffer paramByteBuffer) {
/*  69 */     return new CMsghdr(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CMsghdr(ByteBuffer paramByteBuffer) {
/*  79 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  83 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("socklen_t")
/*     */   public int cmsg_len() {
/*  87 */     return ncmsg_len(address());
/*     */   } public int cmsg_level() {
/*  89 */     return ncmsg_level(address());
/*     */   } public int cmsg_type() {
/*  91 */     return ncmsg_type(address());
/*     */   } @NativeType("char[0]")
/*     */   public ByteBuffer cmsg_data() {
/*  94 */     return ncmsg_data(address());
/*     */   } @NativeType("char")
/*     */   public byte cmsg_data(int paramInt) {
/*  97 */     return ncmsg_data(address(), paramInt);
/*     */   }
/*     */   public CMsghdr cmsg_len(@NativeType("socklen_t") int paramInt) {
/* 100 */     ncmsg_len(address(), paramInt); return this;
/*     */   } public CMsghdr cmsg_level(int paramInt) {
/* 102 */     ncmsg_level(address(), paramInt); return this;
/*     */   } public CMsghdr cmsg_type(int paramInt) {
/* 104 */     ncmsg_type(address(), paramInt); return this;
/*     */   } public CMsghdr cmsg_data(@NativeType("char[0]") ByteBuffer paramByteBuffer) {
/* 106 */     ncmsg_data(address(), paramByteBuffer); return this;
/*     */   } public CMsghdr cmsg_data(int paramInt, @NativeType("char") byte paramByte) {
/* 108 */     ncmsg_data(address(), paramInt, paramByte); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CMsghdr set(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer) {
/* 117 */     cmsg_len(paramInt1);
/* 118 */     cmsg_level(paramInt2);
/* 119 */     cmsg_type(paramInt3);
/* 120 */     cmsg_data(paramByteBuffer);
/*     */     
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CMsghdr set(CMsghdr paramCMsghdr) {
/* 133 */     MemoryUtil.memCopy(paramCMsghdr.address(), address(), SIZEOF);
/* 134 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CMsghdr malloc() {
/* 141 */     return new CMsghdr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CMsghdr calloc() {
/* 146 */     return new CMsghdr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CMsghdr create() {
/* 151 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 152 */     return new CMsghdr(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CMsghdr create(long paramLong) {
/* 157 */     return new CMsghdr(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static CMsghdr createSafe(long paramLong) {
/* 163 */     return (paramLong == 0L) ? null : new CMsghdr(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 172 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 181 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 190 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 191 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 201 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 207 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CMsghdr malloc(MemoryStack paramMemoryStack) {
/* 216 */     return new CMsghdr(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CMsghdr calloc(MemoryStack paramMemoryStack) {
/* 225 */     return new CMsghdr(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 235 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 245 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncmsg_len(long paramLong) {
/* 251 */     return UNSAFE.getInt(null, paramLong + CMSG_LEN);
/*     */   } public static int ncmsg_level(long paramLong) {
/* 253 */     return UNSAFE.getInt(null, paramLong + CMSG_LEVEL);
/*     */   } public static int ncmsg_type(long paramLong) {
/* 255 */     return UNSAFE.getInt(null, paramLong + CMSG_TYPE);
/*     */   } public static ByteBuffer ncmsg_data(long paramLong) {
/* 257 */     return MemoryUtil.memByteBuffer(paramLong + CMSG_DATA, 0);
/*     */   }
/*     */   public static byte ncmsg_data(long paramLong, int paramInt) {
/* 260 */     return UNSAFE.getByte(null, paramLong + CMSG_DATA + Checks.check(paramInt, 0));
/*     */   }
/*     */   
/*     */   public static void ncmsg_len(long paramLong, int paramInt) {
/* 264 */     UNSAFE.putInt(null, paramLong + CMSG_LEN, paramInt);
/*     */   } public static void ncmsg_level(long paramLong, int paramInt) {
/* 266 */     UNSAFE.putInt(null, paramLong + CMSG_LEVEL, paramInt);
/*     */   } public static void ncmsg_type(long paramLong, int paramInt) {
/* 268 */     UNSAFE.putInt(null, paramLong + CMSG_TYPE, paramInt);
/*     */   }
/*     */   public static void ncmsg_data(long paramLong, ByteBuffer paramByteBuffer) {
/* 271 */     if (Checks.CHECKS) Checks.checkGT(paramByteBuffer, 0); 
/* 272 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramByteBuffer), paramLong + CMSG_DATA, paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public static void ncmsg_data(long paramLong, int paramInt, byte paramByte) {
/* 276 */     UNSAFE.putByte(null, paramLong + CMSG_DATA + Checks.check(paramInt, 0), paramByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<CMsghdr, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 284 */     private static final CMsghdr ELEMENT_FACTORY = CMsghdr.create(-1L);
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
/* 296 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / CMsghdr.SIZEOF);
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
/*     */     protected CMsghdr getElementFactory() {
/* 314 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("socklen_t")
/*     */     public int cmsg_len() {
/* 319 */       return CMsghdr.ncmsg_len(address());
/*     */     } public int cmsg_level() {
/* 321 */       return CMsghdr.ncmsg_level(address());
/*     */     } public int cmsg_type() {
/* 323 */       return CMsghdr.ncmsg_type(address());
/*     */     } @NativeType("char[0]")
/*     */     public ByteBuffer cmsg_data() {
/* 326 */       return CMsghdr.ncmsg_data(address());
/*     */     } @NativeType("char")
/*     */     public byte cmsg_data(int param1Int) {
/* 329 */       return CMsghdr.ncmsg_data(address(), param1Int);
/*     */     }
/*     */     public Buffer cmsg_len(@NativeType("socklen_t") int param1Int) {
/* 332 */       CMsghdr.ncmsg_len(address(), param1Int); return this;
/*     */     } public Buffer cmsg_level(int param1Int) {
/* 334 */       CMsghdr.ncmsg_level(address(), param1Int); return this;
/*     */     } public Buffer cmsg_type(int param1Int) {
/* 336 */       CMsghdr.ncmsg_type(address(), param1Int); return this;
/*     */     } public Buffer cmsg_data(@NativeType("char[0]") ByteBuffer param1ByteBuffer) {
/* 338 */       CMsghdr.ncmsg_data(address(), param1ByteBuffer); return this;
/*     */     } public Buffer cmsg_data(int param1Int, @NativeType("char") byte param1Byte) {
/* 340 */       CMsghdr.ncmsg_data(address(), param1Int, param1Byte); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\CMsghdr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */