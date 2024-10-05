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
/*     */ @NativeType("struct io_uring_probe_op")
/*     */ public class IOURingProbeOp
/*     */   extends Struct<IOURingProbeOp>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OP;
/*     */   public static final int RESV;
/*     */   public static final int FLAGS;
/*     */   public static final int RESV2;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  53 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(1), __member(1), __member(2), __member(4) })).getSize();
/*  54 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  56 */     OP = layout.offsetof(0);
/*  57 */     RESV = layout.offsetof(1);
/*  58 */     FLAGS = layout.offsetof(2);
/*  59 */     RESV2 = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingProbeOp(long paramLong, ByteBuffer paramByteBuffer) {
/*  63 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingProbeOp create(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     return new IOURingProbeOp(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbeOp(ByteBuffer paramByteBuffer) {
/*  78 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  82 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u8")
/*     */   public byte op() {
/*  86 */     return nop(address());
/*     */   } @NativeType("__u8")
/*     */   public byte resv() {
/*  89 */     return nresv(address());
/*     */   } @NativeType("__u16")
/*     */   public short flags() {
/*  92 */     return nflags(address());
/*     */   } @NativeType("__u32")
/*     */   public int resv2() {
/*  95 */     return nresv2(address());
/*     */   }
/*     */   public IOURingProbeOp op(@NativeType("__u8") byte paramByte) {
/*  98 */     nop(address(), paramByte); return this;
/*     */   } public IOURingProbeOp resv(@NativeType("__u8") byte paramByte) {
/* 100 */     nresv(address(), paramByte); return this;
/*     */   } public IOURingProbeOp flags(@NativeType("__u16") short paramShort) {
/* 102 */     nflags(address(), paramShort); return this;
/*     */   } public IOURingProbeOp resv2(@NativeType("__u32") int paramInt) {
/* 104 */     nresv2(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbeOp set(byte paramByte1, byte paramByte2, short paramShort, int paramInt) {
/* 113 */     op(paramByte1);
/* 114 */     resv(paramByte2);
/* 115 */     flags(paramShort);
/* 116 */     resv2(paramInt);
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
/*     */   public IOURingProbeOp set(IOURingProbeOp paramIOURingProbeOp) {
/* 129 */     MemoryUtil.memCopy(paramIOURingProbeOp.address(), address(), SIZEOF);
/* 130 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp malloc() {
/* 137 */     return new IOURingProbeOp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp calloc() {
/* 142 */     return new IOURingProbeOp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp create() {
/* 147 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 148 */     return new IOURingProbeOp(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp create(long paramLong) {
/* 153 */     return new IOURingProbeOp(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp createSafe(long paramLong) {
/* 159 */     return (paramLong == 0L) ? null : new IOURingProbeOp(paramLong, null);
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
/*     */   public static IOURingProbeOp malloc(MemoryStack paramMemoryStack) {
/* 212 */     return new IOURingProbeOp(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbeOp calloc(MemoryStack paramMemoryStack) {
/* 221 */     return new IOURingProbeOp(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static byte nop(long paramLong) {
/* 247 */     return UNSAFE.getByte(null, paramLong + OP);
/*     */   } public static byte nresv(long paramLong) {
/* 249 */     return UNSAFE.getByte(null, paramLong + RESV);
/*     */   } public static short nflags(long paramLong) {
/* 251 */     return UNSAFE.getShort(null, paramLong + FLAGS);
/*     */   } public static int nresv2(long paramLong) {
/* 253 */     return UNSAFE.getInt(null, paramLong + RESV2);
/*     */   }
/*     */   public static void nop(long paramLong, byte paramByte) {
/* 256 */     UNSAFE.putByte(null, paramLong + OP, paramByte);
/*     */   } public static void nresv(long paramLong, byte paramByte) {
/* 258 */     UNSAFE.putByte(null, paramLong + RESV, paramByte);
/*     */   } public static void nflags(long paramLong, short paramShort) {
/* 260 */     UNSAFE.putShort(null, paramLong + FLAGS, paramShort);
/*     */   } public static void nresv2(long paramLong, int paramInt) {
/* 262 */     UNSAFE.putInt(null, paramLong + RESV2, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingProbeOp, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 269 */     private static final IOURingProbeOp ELEMENT_FACTORY = IOURingProbeOp.create(-1L);
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
/* 281 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingProbeOp.SIZEOF);
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
/*     */     protected IOURingProbeOp getElementFactory() {
/* 299 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u8")
/*     */     public byte op() {
/* 304 */       return IOURingProbeOp.nop(address());
/*     */     } @NativeType("__u8")
/*     */     public byte resv() {
/* 307 */       return IOURingProbeOp.nresv(address());
/*     */     } @NativeType("__u16")
/*     */     public short flags() {
/* 310 */       return IOURingProbeOp.nflags(address());
/*     */     } @NativeType("__u32")
/*     */     public int resv2() {
/* 313 */       return IOURingProbeOp.nresv2(address());
/*     */     }
/*     */     public Buffer op(@NativeType("__u8") byte param1Byte) {
/* 316 */       IOURingProbeOp.nop(address(), param1Byte); return this;
/*     */     } public Buffer resv(@NativeType("__u8") byte param1Byte) {
/* 318 */       IOURingProbeOp.nresv(address(), param1Byte); return this;
/*     */     } public Buffer flags(@NativeType("__u16") short param1Short) {
/* 320 */       IOURingProbeOp.nflags(address(), param1Short); return this;
/*     */     } public Buffer resv2(@NativeType("__u32") int param1Int) {
/* 322 */       IOURingProbeOp.nresv2(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingProbeOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */