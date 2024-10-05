/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ @NativeType("struct io_uring_probe")
/*     */ public class IOURingProbe
/*     */   extends Struct<IOURingProbe>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int LAST_OP;
/*     */   public static final int OPS_LEN;
/*     */   public static final int RESV;
/*     */   public static final int RESV2;
/*     */   public static final int OPS;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  57 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(1), __member(1), __member(2), __array(4, 3), __array(IOURingProbeOp.SIZEOF, IOURingProbeOp.ALIGNOF, 0) })).getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     LAST_OP = layout.offsetof(0);
/*  61 */     OPS_LEN = layout.offsetof(1);
/*  62 */     RESV = layout.offsetof(2);
/*  63 */     RESV2 = layout.offsetof(3);
/*  64 */     OPS = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected IOURingProbe(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingProbe create(long paramLong, ByteBuffer paramByteBuffer) {
/*  73 */     return new IOURingProbe(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbe(ByteBuffer paramByteBuffer) {
/*  83 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  87 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u8")
/*     */   public byte last_op() {
/*  91 */     return nlast_op(address());
/*     */   } @NativeType("__u8")
/*     */   public byte ops_len() {
/*  94 */     return nops_len(address());
/*     */   } @NativeType("__u16")
/*     */   public short resv() {
/*  97 */     return nresv(address());
/*     */   } @NativeType("struct io_uring_probe_op[0]")
/*     */   public IOURingProbeOp.Buffer ops() {
/* 100 */     return nops(address());
/*     */   } @NativeType("struct io_uring_probe_op")
/*     */   public IOURingProbeOp ops(int paramInt) {
/* 103 */     return nops(address(), paramInt);
/*     */   }
/*     */   public IOURingProbe last_op(@NativeType("__u8") byte paramByte) {
/* 106 */     nlast_op(address(), paramByte); return this;
/*     */   } public IOURingProbe ops_len(@NativeType("__u8") byte paramByte) {
/* 108 */     nops_len(address(), paramByte); return this;
/*     */   } public IOURingProbe resv(@NativeType("__u16") short paramShort) {
/* 110 */     nresv(address(), paramShort); return this;
/*     */   } public IOURingProbe ops(@NativeType("struct io_uring_probe_op[0]") IOURingProbeOp.Buffer paramBuffer) {
/* 112 */     nops(address(), paramBuffer); return this;
/*     */   } public IOURingProbe ops(int paramInt, @NativeType("struct io_uring_probe_op") IOURingProbeOp paramIOURingProbeOp) {
/* 114 */     nops(address(), paramInt, paramIOURingProbeOp); return this;
/*     */   } public IOURingProbe ops(Consumer<IOURingProbeOp.Buffer> paramConsumer) {
/* 116 */     paramConsumer.accept(ops()); return this;
/*     */   } public IOURingProbe ops(int paramInt, Consumer<IOURingProbeOp> paramConsumer) {
/* 118 */     paramConsumer.accept(ops(paramInt)); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbe set(byte paramByte1, byte paramByte2, short paramShort, IOURingProbeOp.Buffer paramBuffer) {
/* 127 */     last_op(paramByte1);
/* 128 */     ops_len(paramByte2);
/* 129 */     resv(paramShort);
/* 130 */     ops(paramBuffer);
/*     */     
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingProbe set(IOURingProbe paramIOURingProbe) {
/* 143 */     MemoryUtil.memCopy(paramIOURingProbe.address(), address(), SIZEOF);
/* 144 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbe malloc() {
/* 151 */     return new IOURingProbe(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbe calloc() {
/* 156 */     return new IOURingProbe(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbe create() {
/* 161 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 162 */     return new IOURingProbe(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingProbe create(long paramLong) {
/* 167 */     return new IOURingProbe(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbe createSafe(long paramLong) {
/* 173 */     return (paramLong == 0L) ? null : new IOURingProbe(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 182 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 191 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 200 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 201 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 211 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 217 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbe malloc(MemoryStack paramMemoryStack) {
/* 226 */     return new IOURingProbe(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingProbe calloc(MemoryStack paramMemoryStack) {
/* 235 */     return new IOURingProbe(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 245 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 255 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte nlast_op(long paramLong) {
/* 261 */     return UNSAFE.getByte(null, paramLong + LAST_OP);
/*     */   } public static byte nops_len(long paramLong) {
/* 263 */     return UNSAFE.getByte(null, paramLong + OPS_LEN);
/*     */   }
/* 265 */   public static short nresv(long paramLong) { return UNSAFE.getShort(null, paramLong + RESV); } public static IntBuffer nresv2(long paramLong) {
/* 266 */     return MemoryUtil.memIntBuffer(paramLong + RESV2, 3);
/*     */   } public static int nresv2(long paramLong, int paramInt) {
/* 268 */     return UNSAFE.getInt(null, paramLong + RESV2 + (Checks.check(paramInt, 3) << 2L));
/*     */   }
/*     */   public static IOURingProbeOp.Buffer nops(long paramLong) {
/* 271 */     return IOURingProbeOp.create(paramLong + OPS, 0);
/*     */   }
/*     */   public static IOURingProbeOp nops(long paramLong, int paramInt) {
/* 274 */     return IOURingProbeOp.create(paramLong + OPS + Checks.check(paramInt, 0) * IOURingProbeOp.SIZEOF);
/*     */   }
/*     */   
/*     */   public static void nlast_op(long paramLong, byte paramByte) {
/* 278 */     UNSAFE.putByte(null, paramLong + LAST_OP, paramByte);
/*     */   } public static void nops_len(long paramLong, byte paramByte) {
/* 280 */     UNSAFE.putByte(null, paramLong + OPS_LEN, paramByte);
/*     */   } public static void nresv(long paramLong, short paramShort) {
/* 282 */     UNSAFE.putShort(null, paramLong + RESV, paramShort);
/*     */   } public static void nresv2(long paramLong, IntBuffer paramIntBuffer) {
/* 284 */     if (Checks.CHECKS) Checks.checkGT(paramIntBuffer, 3); 
/* 285 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramIntBuffer), paramLong + RESV2, (paramIntBuffer.remaining() << 2));
/*     */   }
/*     */   public static void nresv2(long paramLong, int paramInt1, int paramInt2) {
/* 288 */     UNSAFE.putInt(null, paramLong + RESV2 + (Checks.check(paramInt1, 3) << 2L), paramInt2);
/*     */   }
/*     */   
/*     */   public static void nops(long paramLong, IOURingProbeOp.Buffer paramBuffer) {
/* 292 */     if (Checks.CHECKS) Checks.checkGT((CustomBuffer)paramBuffer, 0); 
/* 293 */     MemoryUtil.memCopy(paramBuffer.address(), paramLong + OPS, (paramBuffer.remaining() * IOURingProbeOp.SIZEOF));
/*     */   }
/*     */   
/*     */   public static void nops(long paramLong, int paramInt, IOURingProbeOp paramIOURingProbeOp) {
/* 297 */     MemoryUtil.memCopy(paramIOURingProbeOp.address(), paramLong + OPS + Checks.check(paramInt, 0) * IOURingProbeOp.SIZEOF, IOURingProbeOp.SIZEOF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingProbe, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 305 */     private static final IOURingProbe ELEMENT_FACTORY = IOURingProbe.create(-1L);
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
/* 317 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingProbe.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 321 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 325 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 330 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingProbe getElementFactory() {
/* 335 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u8")
/*     */     public byte last_op() {
/* 340 */       return IOURingProbe.nlast_op(address());
/*     */     } @NativeType("__u8")
/*     */     public byte ops_len() {
/* 343 */       return IOURingProbe.nops_len(address());
/*     */     } @NativeType("__u16")
/*     */     public short resv() {
/* 346 */       return IOURingProbe.nresv(address());
/*     */     } @NativeType("struct io_uring_probe_op[0]")
/*     */     public IOURingProbeOp.Buffer ops() {
/* 349 */       return IOURingProbe.nops(address());
/*     */     } @NativeType("struct io_uring_probe_op")
/*     */     public IOURingProbeOp ops(int param1Int) {
/* 352 */       return IOURingProbe.nops(address(), param1Int);
/*     */     }
/*     */     public Buffer last_op(@NativeType("__u8") byte param1Byte) {
/* 355 */       IOURingProbe.nlast_op(address(), param1Byte); return this;
/*     */     } public Buffer ops_len(@NativeType("__u8") byte param1Byte) {
/* 357 */       IOURingProbe.nops_len(address(), param1Byte); return this;
/*     */     } public Buffer resv(@NativeType("__u16") short param1Short) {
/* 359 */       IOURingProbe.nresv(address(), param1Short); return this;
/*     */     } public Buffer ops(@NativeType("struct io_uring_probe_op[0]") IOURingProbeOp.Buffer param1Buffer) {
/* 361 */       IOURingProbe.nops(address(), param1Buffer); return this;
/*     */     } public Buffer ops(int param1Int, @NativeType("struct io_uring_probe_op") IOURingProbeOp param1IOURingProbeOp) {
/* 363 */       IOURingProbe.nops(address(), param1Int, param1IOURingProbeOp); return this;
/*     */     } public Buffer ops(Consumer<IOURingProbeOp.Buffer> param1Consumer) {
/* 365 */       param1Consumer.accept(ops()); return this;
/*     */     } public Buffer ops(int param1Int, Consumer<IOURingProbeOp> param1Consumer) {
/* 367 */       param1Consumer.accept(ops(param1Int)); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingProbe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */