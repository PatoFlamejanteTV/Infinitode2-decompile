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
/*     */ 
/*     */ 
/*     */ public class XErrorEvent
/*     */   extends Struct<XErrorEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int DISPLAY;
/*     */   public static final int RESOURCEID;
/*     */   public static final int SERIAL;
/*     */   public static final int ERROR_CODE;
/*     */   public static final int REQUEST_CODE;
/*     */   public static final int MINOR_CODE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  64 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(1), __member(1), __member(1) })).getSize();
/*  65 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  67 */     TYPE = layout.offsetof(0);
/*  68 */     DISPLAY = layout.offsetof(1);
/*  69 */     RESOURCEID = layout.offsetof(2);
/*  70 */     SERIAL = layout.offsetof(3);
/*  71 */     ERROR_CODE = layout.offsetof(4);
/*  72 */     REQUEST_CODE = layout.offsetof(5);
/*  73 */     MINOR_CODE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XErrorEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  77 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XErrorEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  82 */     return new XErrorEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XErrorEvent(ByteBuffer paramByteBuffer) {
/*  92 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  96 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  99 */     return ntype(address());
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 102 */     return ndisplay(address());
/*     */   } @NativeType("XID")
/*     */   public long resourceid() {
/* 105 */     return nresourceid(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 108 */     return nserial(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte error_code() {
/* 111 */     return nerror_code(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte request_code() {
/* 114 */     return nrequest_code(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte minor_code() {
/* 117 */     return nminor_code(address());
/*     */   }
/*     */   public XErrorEvent type(int paramInt) {
/* 120 */     ntype(address(), paramInt); return this;
/*     */   } public XErrorEvent display(@NativeType("Display *") long paramLong) {
/* 122 */     ndisplay(address(), paramLong); return this;
/*     */   } public XErrorEvent resourceid(@NativeType("XID") long paramLong) {
/* 124 */     nresourceid(address(), paramLong); return this;
/*     */   } public XErrorEvent serial(@NativeType("unsigned long") long paramLong) {
/* 126 */     nserial(address(), paramLong); return this;
/*     */   } public XErrorEvent error_code(@NativeType("unsigned char") byte paramByte) {
/* 128 */     nerror_code(address(), paramByte); return this;
/*     */   } public XErrorEvent request_code(@NativeType("unsigned char") byte paramByte) {
/* 130 */     nrequest_code(address(), paramByte); return this;
/*     */   } public XErrorEvent minor_code(@NativeType("unsigned char") byte paramByte) {
/* 132 */     nminor_code(address(), paramByte); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XErrorEvent set(int paramInt, long paramLong1, long paramLong2, long paramLong3, byte paramByte1, byte paramByte2, byte paramByte3) {
/* 144 */     type(paramInt);
/* 145 */     display(paramLong1);
/* 146 */     resourceid(paramLong2);
/* 147 */     serial(paramLong3);
/* 148 */     error_code(paramByte1);
/* 149 */     request_code(paramByte2);
/* 150 */     minor_code(paramByte3);
/*     */     
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XErrorEvent set(XErrorEvent paramXErrorEvent) {
/* 163 */     MemoryUtil.memCopy(paramXErrorEvent.address(), address(), SIZEOF);
/* 164 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XErrorEvent malloc() {
/* 171 */     return new XErrorEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XErrorEvent calloc() {
/* 176 */     return new XErrorEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XErrorEvent create() {
/* 181 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 182 */     return new XErrorEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XErrorEvent create(long paramLong) {
/* 187 */     return new XErrorEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XErrorEvent createSafe(long paramLong) {
/* 193 */     return (paramLong == 0L) ? null : new XErrorEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 202 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 211 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 220 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 221 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 231 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 237 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XErrorEvent mallocStack() {
/* 243 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 245 */   public static XErrorEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 247 */   public static XErrorEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 249 */   public static XErrorEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 251 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 253 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 255 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 257 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XErrorEvent malloc(MemoryStack paramMemoryStack) {
/* 265 */     return new XErrorEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XErrorEvent calloc(MemoryStack paramMemoryStack) {
/* 274 */     return new XErrorEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 284 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 294 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 300 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long ndisplay(long paramLong) {
/* 302 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nresourceid(long paramLong) {
/* 304 */     return MemoryUtil.memGetCLong(paramLong + RESOURCEID);
/*     */   } public static long nserial(long paramLong) {
/* 306 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static byte nerror_code(long paramLong) {
/* 308 */     return UNSAFE.getByte(null, paramLong + ERROR_CODE);
/*     */   } public static byte nrequest_code(long paramLong) {
/* 310 */     return UNSAFE.getByte(null, paramLong + REQUEST_CODE);
/*     */   } public static byte nminor_code(long paramLong) {
/* 312 */     return UNSAFE.getByte(null, paramLong + MINOR_CODE);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 315 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 317 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nresourceid(long paramLong1, long paramLong2) {
/* 319 */     MemoryUtil.memPutCLong(paramLong1 + RESOURCEID, paramLong2);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 321 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nerror_code(long paramLong, byte paramByte) {
/* 323 */     UNSAFE.putByte(null, paramLong + ERROR_CODE, paramByte);
/*     */   } public static void nrequest_code(long paramLong, byte paramByte) {
/* 325 */     UNSAFE.putByte(null, paramLong + REQUEST_CODE, paramByte);
/*     */   } public static void nminor_code(long paramLong, byte paramByte) {
/* 327 */     UNSAFE.putByte(null, paramLong + MINOR_CODE, paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 335 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XErrorEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 343 */     private static final XErrorEvent ELEMENT_FACTORY = XErrorEvent.create(-1L);
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
/* 355 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XErrorEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 359 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 363 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 368 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XErrorEvent getElementFactory() {
/* 373 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 377 */       return XErrorEvent.ntype(address());
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 380 */       return XErrorEvent.ndisplay(address());
/*     */     } @NativeType("XID")
/*     */     public long resourceid() {
/* 383 */       return XErrorEvent.nresourceid(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 386 */       return XErrorEvent.nserial(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte error_code() {
/* 389 */       return XErrorEvent.nerror_code(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte request_code() {
/* 392 */       return XErrorEvent.nrequest_code(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte minor_code() {
/* 395 */       return XErrorEvent.nminor_code(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 398 */       XErrorEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 400 */       XErrorEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer resourceid(@NativeType("XID") long param1Long) {
/* 402 */       XErrorEvent.nresourceid(address(), param1Long); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 404 */       XErrorEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer error_code(@NativeType("unsigned char") byte param1Byte) {
/* 406 */       XErrorEvent.nerror_code(address(), param1Byte); return this;
/*     */     } public Buffer request_code(@NativeType("unsigned char") byte param1Byte) {
/* 408 */       XErrorEvent.nrequest_code(address(), param1Byte); return this;
/*     */     } public Buffer minor_code(@NativeType("unsigned char") byte param1Byte) {
/* 410 */       XErrorEvent.nminor_code(address(), param1Byte); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XErrorEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */