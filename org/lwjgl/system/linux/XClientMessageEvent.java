/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.CLongBuffer;
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
/*     */ public class XClientMessageEvent
/*     */   extends Struct<XClientMessageEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int MESSAGE_TYPE;
/*     */   public static final int FORMAT;
/*     */   public static final int DATA;
/*     */   public static final int DATA_B;
/*     */   public static final int DATA_S;
/*     */   public static final int DATA_L;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  84 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), (Struct.Member)__struct(new Struct.Member[] { __array(1, 20), __array(2, 10), __array(CLONG_SIZE, 5) }) })).getSize();
/*  85 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  87 */     TYPE = layout.offsetof(0);
/*  88 */     SERIAL = layout.offsetof(1);
/*  89 */     SEND_EVENT = layout.offsetof(2);
/*  90 */     DISPLAY = layout.offsetof(3);
/*  91 */     WINDOW = layout.offsetof(4);
/*  92 */     MESSAGE_TYPE = layout.offsetof(5);
/*  93 */     FORMAT = layout.offsetof(6);
/*  94 */     DATA = layout.offsetof(7);
/*  95 */     DATA_B = layout.offsetof(8);
/*  96 */     DATA_S = layout.offsetof(9);
/*  97 */     DATA_L = layout.offsetof(10);
/*     */   }
/*     */   
/*     */   protected XClientMessageEvent(long paramLong, ByteBuffer paramByteBuffer) {
/* 101 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XClientMessageEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/* 106 */     return new XClientMessageEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XClientMessageEvent(ByteBuffer paramByteBuffer) {
/* 116 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 120 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 123 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 126 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 129 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 132 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 135 */     return nwindow(address());
/*     */   } @NativeType("Atom")
/*     */   public long message_type() {
/* 138 */     return nmessage_type(address());
/*     */   } public int format() {
/* 140 */     return nformat(address());
/*     */   } @NativeType("char[20]")
/*     */   public ByteBuffer data_b() {
/* 143 */     return ndata_b(address());
/*     */   } @NativeType("char")
/*     */   public byte data_b(int paramInt) {
/* 146 */     return ndata_b(address(), paramInt);
/*     */   } @NativeType("short[10]")
/*     */   public ShortBuffer data_s() {
/* 149 */     return ndata_s(address());
/*     */   } public short data_s(int paramInt) {
/* 151 */     return ndata_s(address(), paramInt);
/*     */   } @NativeType("long[5]")
/*     */   public CLongBuffer data_l() {
/* 154 */     return ndata_l(address());
/*     */   } public long data_l(int paramInt) {
/* 156 */     return ndata_l(address(), paramInt);
/*     */   }
/*     */   public XClientMessageEvent type(int paramInt) {
/* 159 */     ntype(address(), paramInt); return this;
/*     */   } public XClientMessageEvent serial(@NativeType("unsigned long") long paramLong) {
/* 161 */     nserial(address(), paramLong); return this;
/*     */   } public XClientMessageEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 163 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XClientMessageEvent display(@NativeType("Display *") long paramLong) {
/* 165 */     ndisplay(address(), paramLong); return this;
/*     */   } public XClientMessageEvent window(@NativeType("Window") long paramLong) {
/* 167 */     nwindow(address(), paramLong); return this;
/*     */   } public XClientMessageEvent message_type(@NativeType("Atom") long paramLong) {
/* 169 */     nmessage_type(address(), paramLong); return this;
/*     */   } public XClientMessageEvent format(int paramInt) {
/* 171 */     nformat(address(), paramInt); return this;
/*     */   } public XClientMessageEvent data_b(@NativeType("char[20]") ByteBuffer paramByteBuffer) {
/* 173 */     ndata_b(address(), paramByteBuffer); return this;
/*     */   } public XClientMessageEvent data_b(int paramInt, @NativeType("char") byte paramByte) {
/* 175 */     ndata_b(address(), paramInt, paramByte); return this;
/*     */   } public XClientMessageEvent data_s(@NativeType("short[10]") ShortBuffer paramShortBuffer) {
/* 177 */     ndata_s(address(), paramShortBuffer); return this;
/*     */   } public XClientMessageEvent data_s(int paramInt, short paramShort) {
/* 179 */     ndata_s(address(), paramInt, paramShort); return this;
/*     */   } public XClientMessageEvent data_l(@NativeType("long[5]") CLongBuffer paramCLongBuffer) {
/* 181 */     ndata_l(address(), paramCLongBuffer); return this;
/*     */   } public XClientMessageEvent data_l(int paramInt, long paramLong) {
/* 183 */     ndata_l(address(), paramInt, paramLong); return this;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public XClientMessageEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, int paramInt2, ByteBuffer paramByteBuffer, ShortBuffer paramShortBuffer, CLongBuffer paramCLongBuffer) {
/* 198 */     type(paramInt1);
/* 199 */     serial(paramLong1);
/* 200 */     send_event(paramBoolean);
/* 201 */     display(paramLong2);
/* 202 */     window(paramLong3);
/* 203 */     message_type(paramLong4);
/* 204 */     format(paramInt2);
/* 205 */     data_b(paramByteBuffer);
/* 206 */     data_s(paramShortBuffer);
/* 207 */     data_l(paramCLongBuffer);
/*     */     
/* 209 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XClientMessageEvent set(XClientMessageEvent paramXClientMessageEvent) {
/* 220 */     MemoryUtil.memCopy(paramXClientMessageEvent.address(), address(), SIZEOF);
/* 221 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent malloc() {
/* 228 */     return new XClientMessageEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent calloc() {
/* 233 */     return new XClientMessageEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent create() {
/* 238 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 239 */     return new XClientMessageEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent create(long paramLong) {
/* 244 */     return new XClientMessageEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent createSafe(long paramLong) {
/* 250 */     return (paramLong == 0L) ? null : new XClientMessageEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 259 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 268 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 277 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 278 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 288 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 294 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XClientMessageEvent mallocStack() {
/* 300 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 302 */   public static XClientMessageEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 304 */   public static XClientMessageEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 306 */   public static XClientMessageEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 308 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 310 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 312 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 314 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent malloc(MemoryStack paramMemoryStack) {
/* 322 */     return new XClientMessageEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XClientMessageEvent calloc(MemoryStack paramMemoryStack) {
/* 331 */     return new XClientMessageEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 341 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 351 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 357 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 359 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 361 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 363 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 365 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static long nmessage_type(long paramLong) {
/* 367 */     return MemoryUtil.memGetCLong(paramLong + MESSAGE_TYPE);
/*     */   } public static int nformat(long paramLong) {
/* 369 */     return UNSAFE.getInt(null, paramLong + FORMAT);
/*     */   } public static ByteBuffer ndata_b(long paramLong) {
/* 371 */     return MemoryUtil.memByteBuffer(paramLong + DATA_B, 20);
/*     */   }
/*     */   public static byte ndata_b(long paramLong, int paramInt) {
/* 374 */     return UNSAFE.getByte(null, paramLong + DATA_B + Checks.check(paramInt, 20));
/*     */   }
/*     */   public static ShortBuffer ndata_s(long paramLong) {
/* 377 */     return MemoryUtil.memShortBuffer(paramLong + DATA_S, 10);
/*     */   }
/*     */   public static short ndata_s(long paramLong, int paramInt) {
/* 380 */     return UNSAFE.getShort(null, paramLong + DATA_S + (Checks.check(paramInt, 10) << 1L));
/*     */   }
/*     */   public static CLongBuffer ndata_l(long paramLong) {
/* 383 */     return MemoryUtil.memCLongBuffer(paramLong + DATA_L, 5);
/*     */   }
/*     */   public static long ndata_l(long paramLong, int paramInt) {
/* 386 */     return MemoryUtil.memGetCLong(paramLong + DATA_L + Checks.check(paramInt, 5) * CLONG_SIZE);
/*     */   }
/*     */   
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 390 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 392 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 394 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 396 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 398 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nmessage_type(long paramLong1, long paramLong2) {
/* 400 */     MemoryUtil.memPutCLong(paramLong1 + MESSAGE_TYPE, paramLong2);
/*     */   } public static void nformat(long paramLong, int paramInt) {
/* 402 */     UNSAFE.putInt(null, paramLong + FORMAT, paramInt);
/*     */   }
/*     */   public static void ndata_b(long paramLong, ByteBuffer paramByteBuffer) {
/* 405 */     if (Checks.CHECKS) Checks.checkGT(paramByteBuffer, 20); 
/* 406 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramByteBuffer), paramLong + DATA_B, paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public static void ndata_b(long paramLong, int paramInt, byte paramByte) {
/* 410 */     UNSAFE.putByte(null, paramLong + DATA_B + Checks.check(paramInt, 20), paramByte);
/*     */   }
/*     */   
/*     */   public static void ndata_s(long paramLong, ShortBuffer paramShortBuffer) {
/* 414 */     if (Checks.CHECKS) Checks.checkGT(paramShortBuffer, 10); 
/* 415 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramShortBuffer), paramLong + DATA_S, (paramShortBuffer.remaining() << 1));
/*     */   }
/*     */   
/*     */   public static void ndata_s(long paramLong, int paramInt, short paramShort) {
/* 419 */     UNSAFE.putShort(null, paramLong + DATA_S + (Checks.check(paramInt, 10) << 1L), paramShort);
/*     */   }
/*     */   
/*     */   public static void ndata_l(long paramLong, CLongBuffer paramCLongBuffer) {
/* 423 */     if (Checks.CHECKS) Checks.checkGT((CustomBuffer)paramCLongBuffer, 5); 
/* 424 */     MemoryUtil.memCopy(MemoryUtil.memAddress((CustomBuffer)paramCLongBuffer), paramLong + DATA_L, (paramCLongBuffer.remaining() * CLONG_SIZE));
/*     */   }
/*     */   
/*     */   public static void ndata_l(long paramLong1, int paramInt, long paramLong2) {
/* 428 */     MemoryUtil.memPutCLong(paramLong1 + DATA_L + Checks.check(paramInt, 5) * CLONG_SIZE, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 437 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XClientMessageEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 445 */     private static final XClientMessageEvent ELEMENT_FACTORY = XClientMessageEvent.create(-1L);
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
/* 457 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XClientMessageEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 461 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 465 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 470 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XClientMessageEvent getElementFactory() {
/* 475 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 479 */       return XClientMessageEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 482 */       return XClientMessageEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 485 */       return (XClientMessageEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 488 */       return XClientMessageEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 491 */       return XClientMessageEvent.nwindow(address());
/*     */     } @NativeType("Atom")
/*     */     public long message_type() {
/* 494 */       return XClientMessageEvent.nmessage_type(address());
/*     */     } public int format() {
/* 496 */       return XClientMessageEvent.nformat(address());
/*     */     } @NativeType("char[20]")
/*     */     public ByteBuffer data_b() {
/* 499 */       return XClientMessageEvent.ndata_b(address());
/*     */     } @NativeType("char")
/*     */     public byte data_b(int param1Int) {
/* 502 */       return XClientMessageEvent.ndata_b(address(), param1Int);
/*     */     } @NativeType("short[10]")
/*     */     public ShortBuffer data_s() {
/* 505 */       return XClientMessageEvent.ndata_s(address());
/*     */     } public short data_s(int param1Int) {
/* 507 */       return XClientMessageEvent.ndata_s(address(), param1Int);
/*     */     } @NativeType("long[5]")
/*     */     public CLongBuffer data_l() {
/* 510 */       return XClientMessageEvent.ndata_l(address());
/*     */     } public long data_l(int param1Int) {
/* 512 */       return XClientMessageEvent.ndata_l(address(), param1Int);
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 515 */       XClientMessageEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 517 */       XClientMessageEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 519 */       XClientMessageEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 521 */       XClientMessageEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 523 */       XClientMessageEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer message_type(@NativeType("Atom") long param1Long) {
/* 525 */       XClientMessageEvent.nmessage_type(address(), param1Long); return this;
/*     */     } public Buffer format(int param1Int) {
/* 527 */       XClientMessageEvent.nformat(address(), param1Int); return this;
/*     */     } public Buffer data_b(@NativeType("char[20]") ByteBuffer param1ByteBuffer) {
/* 529 */       XClientMessageEvent.ndata_b(address(), param1ByteBuffer); return this;
/*     */     } public Buffer data_b(int param1Int, @NativeType("char") byte param1Byte) {
/* 531 */       XClientMessageEvent.ndata_b(address(), param1Int, param1Byte); return this;
/*     */     } public Buffer data_s(@NativeType("short[10]") ShortBuffer param1ShortBuffer) {
/* 533 */       XClientMessageEvent.ndata_s(address(), param1ShortBuffer); return this;
/*     */     } public Buffer data_s(int param1Int, short param1Short) {
/* 535 */       XClientMessageEvent.ndata_s(address(), param1Int, param1Short); return this;
/*     */     } public Buffer data_l(@NativeType("long[5]") CLongBuffer param1CLongBuffer) {
/* 537 */       XClientMessageEvent.ndata_l(address(), param1CLongBuffer); return this;
/*     */     } public Buffer data_l(int param1Int, long param1Long) {
/* 539 */       XClientMessageEvent.ndata_l(address(), param1Int, param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XClientMessageEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */