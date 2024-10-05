/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ 
/*     */ @NativeType("struct io_uring_restriction")
/*     */ public class IOURingRestriction
/*     */   extends Struct<IOURingRestriction>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OPCODE;
/*     */   public static final int REGISTER_OP;
/*     */   public static final int SQE_OP;
/*     */   public static final int SQE_FLAGS;
/*     */   public static final int RESV;
/*     */   public static final int RESV2;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  64 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(2), (Struct.Member)__union(new Struct.Member[] { __member(1), __member(1), __member(1) }), __member(1), __array(4, 3) })).getSize();
/*  65 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  67 */     OPCODE = layout.offsetof(0);
/*  68 */     REGISTER_OP = layout.offsetof(2);
/*  69 */     SQE_OP = layout.offsetof(3);
/*  70 */     SQE_FLAGS = layout.offsetof(4);
/*  71 */     RESV = layout.offsetof(5);
/*  72 */     RESV2 = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected IOURingRestriction(long paramLong, ByteBuffer paramByteBuffer) {
/*  76 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRestriction create(long paramLong, ByteBuffer paramByteBuffer) {
/*  81 */     return new IOURingRestriction(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRestriction(ByteBuffer paramByteBuffer) {
/*  91 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  95 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u16")
/*     */   public short opcode() {
/*  99 */     return nopcode(address());
/*     */   } @NativeType("__u8")
/*     */   public byte register_op() {
/* 102 */     return nregister_op(address());
/*     */   } @NativeType("__u8")
/*     */   public byte sqe_op() {
/* 105 */     return nsqe_op(address());
/*     */   } @NativeType("__u8")
/*     */   public byte sqe_flags() {
/* 108 */     return nsqe_flags(address());
/*     */   }
/*     */   public IOURingRestriction opcode(@NativeType("__u16") short paramShort) {
/* 111 */     nopcode(address(), paramShort); return this;
/*     */   } public IOURingRestriction register_op(@NativeType("__u8") byte paramByte) {
/* 113 */     nregister_op(address(), paramByte); return this;
/*     */   } public IOURingRestriction sqe_op(@NativeType("__u8") byte paramByte) {
/* 115 */     nsqe_op(address(), paramByte); return this;
/*     */   } public IOURingRestriction sqe_flags(@NativeType("__u8") byte paramByte) {
/* 117 */     nsqe_flags(address(), paramByte); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRestriction set(IOURingRestriction paramIOURingRestriction) {
/* 127 */     MemoryUtil.memCopy(paramIOURingRestriction.address(), address(), SIZEOF);
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRestriction malloc() {
/* 135 */     return new IOURingRestriction(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRestriction calloc() {
/* 140 */     return new IOURingRestriction(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRestriction create() {
/* 145 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 146 */     return new IOURingRestriction(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRestriction create(long paramLong) {
/* 151 */     return new IOURingRestriction(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRestriction createSafe(long paramLong) {
/* 157 */     return (paramLong == 0L) ? null : new IOURingRestriction(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 166 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 175 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 184 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 185 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 195 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 201 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRestriction malloc(MemoryStack paramMemoryStack) {
/* 210 */     return new IOURingRestriction(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRestriction calloc(MemoryStack paramMemoryStack) {
/* 219 */     return new IOURingRestriction(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 229 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 239 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nopcode(long paramLong) {
/* 245 */     return UNSAFE.getShort(null, paramLong + OPCODE);
/*     */   } public static byte nregister_op(long paramLong) {
/* 247 */     return UNSAFE.getByte(null, paramLong + REGISTER_OP);
/*     */   } public static byte nsqe_op(long paramLong) {
/* 249 */     return UNSAFE.getByte(null, paramLong + SQE_OP);
/*     */   }
/* 251 */   public static byte nsqe_flags(long paramLong) { return UNSAFE.getByte(null, paramLong + SQE_FLAGS); }
/* 252 */   public static byte nresv(long paramLong) { return UNSAFE.getByte(null, paramLong + RESV); } public static IntBuffer nresv2(long paramLong) {
/* 253 */     return MemoryUtil.memIntBuffer(paramLong + RESV2, 3);
/*     */   } public static int nresv2(long paramLong, int paramInt) {
/* 255 */     return UNSAFE.getInt(null, paramLong + RESV2 + (Checks.check(paramInt, 3) << 2L));
/*     */   }
/*     */   
/*     */   public static void nopcode(long paramLong, short paramShort) {
/* 259 */     UNSAFE.putShort(null, paramLong + OPCODE, paramShort);
/*     */   } public static void nregister_op(long paramLong, byte paramByte) {
/* 261 */     UNSAFE.putByte(null, paramLong + REGISTER_OP, paramByte);
/*     */   } public static void nsqe_op(long paramLong, byte paramByte) {
/* 263 */     UNSAFE.putByte(null, paramLong + SQE_OP, paramByte);
/*     */   }
/* 265 */   public static void nsqe_flags(long paramLong, byte paramByte) { UNSAFE.putByte(null, paramLong + SQE_FLAGS, paramByte); } public static void nresv(long paramLong, byte paramByte) {
/* 266 */     UNSAFE.putByte(null, paramLong + RESV, paramByte);
/*     */   } public static void nresv2(long paramLong, IntBuffer paramIntBuffer) {
/* 268 */     if (Checks.CHECKS) Checks.checkGT(paramIntBuffer, 3); 
/* 269 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramIntBuffer), paramLong + RESV2, (paramIntBuffer.remaining() << 2));
/*     */   }
/*     */   public static void nresv2(long paramLong, int paramInt1, int paramInt2) {
/* 272 */     UNSAFE.putInt(null, paramLong + RESV2 + (Checks.check(paramInt1, 3) << 2L), paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRestriction, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 280 */     private static final IOURingRestriction ELEMENT_FACTORY = IOURingRestriction.create(-1L);
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
/* 292 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / IOURingRestriction.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 296 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 300 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 305 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingRestriction getElementFactory() {
/* 310 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u16")
/*     */     public short opcode() {
/* 315 */       return IOURingRestriction.nopcode(address());
/*     */     } @NativeType("__u8")
/*     */     public byte register_op() {
/* 318 */       return IOURingRestriction.nregister_op(address());
/*     */     } @NativeType("__u8")
/*     */     public byte sqe_op() {
/* 321 */       return IOURingRestriction.nsqe_op(address());
/*     */     } @NativeType("__u8")
/*     */     public byte sqe_flags() {
/* 324 */       return IOURingRestriction.nsqe_flags(address());
/*     */     }
/*     */     public Buffer opcode(@NativeType("__u16") short param1Short) {
/* 327 */       IOURingRestriction.nopcode(address(), param1Short); return this;
/*     */     } public Buffer register_op(@NativeType("__u8") byte param1Byte) {
/* 329 */       IOURingRestriction.nregister_op(address(), param1Byte); return this;
/*     */     } public Buffer sqe_op(@NativeType("__u8") byte param1Byte) {
/* 331 */       IOURingRestriction.nsqe_op(address(), param1Byte); return this;
/*     */     } public Buffer sqe_flags(@NativeType("__u8") byte param1Byte) {
/* 333 */       IOURingRestriction.nsqe_flags(address(), param1Byte); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\liburing\IOURingRestriction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */