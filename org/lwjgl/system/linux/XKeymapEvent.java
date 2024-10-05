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
/*     */ public class XKeymapEvent
/*     */   extends Struct<XKeymapEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int KEY_VECTOR;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  61 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __array(1, 32) })).getSize();
/*  62 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  64 */     TYPE = layout.offsetof(0);
/*  65 */     SERIAL = layout.offsetof(1);
/*  66 */     SEND_EVENT = layout.offsetof(2);
/*  67 */     DISPLAY = layout.offsetof(3);
/*  68 */     WINDOW = layout.offsetof(4);
/*  69 */     KEY_VECTOR = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected XKeymapEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  73 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XKeymapEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  78 */     return new XKeymapEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XKeymapEvent(ByteBuffer paramByteBuffer) {
/*  88 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  92 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  95 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/*  98 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 101 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 104 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 107 */     return nwindow(address());
/*     */   } @NativeType("char[32]")
/*     */   public ByteBuffer key_vector() {
/* 110 */     return nkey_vector(address());
/*     */   } @NativeType("char")
/*     */   public byte key_vector(int paramInt) {
/* 113 */     return nkey_vector(address(), paramInt);
/*     */   }
/*     */   public XKeymapEvent type(int paramInt) {
/* 116 */     ntype(address(), paramInt); return this;
/*     */   } public XKeymapEvent serial(@NativeType("unsigned long") long paramLong) {
/* 118 */     nserial(address(), paramLong); return this;
/*     */   } public XKeymapEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 120 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XKeymapEvent display(@NativeType("Display *") long paramLong) {
/* 122 */     ndisplay(address(), paramLong); return this;
/*     */   } public XKeymapEvent window(@NativeType("Window") long paramLong) {
/* 124 */     nwindow(address(), paramLong); return this;
/*     */   } public XKeymapEvent key_vector(@NativeType("char[32]") ByteBuffer paramByteBuffer) {
/* 126 */     nkey_vector(address(), paramByteBuffer); return this;
/*     */   } public XKeymapEvent key_vector(int paramInt, @NativeType("char") byte paramByte) {
/* 128 */     nkey_vector(address(), paramInt, paramByte); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XKeymapEvent set(int paramInt, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, ByteBuffer paramByteBuffer) {
/* 139 */     type(paramInt);
/* 140 */     serial(paramLong1);
/* 141 */     send_event(paramBoolean);
/* 142 */     display(paramLong2);
/* 143 */     window(paramLong3);
/* 144 */     key_vector(paramByteBuffer);
/*     */     
/* 146 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XKeymapEvent set(XKeymapEvent paramXKeymapEvent) {
/* 157 */     MemoryUtil.memCopy(paramXKeymapEvent.address(), address(), SIZEOF);
/* 158 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeymapEvent malloc() {
/* 165 */     return new XKeymapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeymapEvent calloc() {
/* 170 */     return new XKeymapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeymapEvent create() {
/* 175 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 176 */     return new XKeymapEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeymapEvent create(long paramLong) {
/* 181 */     return new XKeymapEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeymapEvent createSafe(long paramLong) {
/* 187 */     return (paramLong == 0L) ? null : new XKeymapEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 196 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 205 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 214 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 215 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 225 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 231 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XKeymapEvent mallocStack() {
/* 237 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 239 */   public static XKeymapEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 241 */   public static XKeymapEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 243 */   public static XKeymapEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 245 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 247 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 249 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 251 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeymapEvent malloc(MemoryStack paramMemoryStack) {
/* 259 */     return new XKeymapEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeymapEvent calloc(MemoryStack paramMemoryStack) {
/* 268 */     return new XKeymapEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 278 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 288 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 294 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 296 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 298 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 300 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 302 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static ByteBuffer nkey_vector(long paramLong) {
/* 304 */     return MemoryUtil.memByteBuffer(paramLong + KEY_VECTOR, 32);
/*     */   }
/*     */   public static byte nkey_vector(long paramLong, int paramInt) {
/* 307 */     return UNSAFE.getByte(null, paramLong + KEY_VECTOR + Checks.check(paramInt, 32));
/*     */   }
/*     */   
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 311 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 313 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 315 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 317 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 319 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   }
/*     */   public static void nkey_vector(long paramLong, ByteBuffer paramByteBuffer) {
/* 322 */     if (Checks.CHECKS) Checks.checkGT(paramByteBuffer, 32); 
/* 323 */     MemoryUtil.memCopy(MemoryUtil.memAddress(paramByteBuffer), paramLong + KEY_VECTOR, paramByteBuffer.remaining());
/*     */   }
/*     */   
/*     */   public static void nkey_vector(long paramLong, int paramInt, byte paramByte) {
/* 327 */     UNSAFE.putByte(null, paramLong + KEY_VECTOR + Checks.check(paramInt, 32), paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 336 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XKeymapEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 344 */     private static final XKeymapEvent ELEMENT_FACTORY = XKeymapEvent.create(-1L);
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
/* 356 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XKeymapEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 360 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 364 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 369 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XKeymapEvent getElementFactory() {
/* 374 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 378 */       return XKeymapEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 381 */       return XKeymapEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 384 */       return (XKeymapEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 387 */       return XKeymapEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 390 */       return XKeymapEvent.nwindow(address());
/*     */     } @NativeType("char[32]")
/*     */     public ByteBuffer key_vector() {
/* 393 */       return XKeymapEvent.nkey_vector(address());
/*     */     } @NativeType("char")
/*     */     public byte key_vector(int param1Int) {
/* 396 */       return XKeymapEvent.nkey_vector(address(), param1Int);
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 399 */       XKeymapEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 401 */       XKeymapEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 403 */       XKeymapEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 405 */       XKeymapEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 407 */       XKeymapEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer key_vector(@NativeType("char[32]") ByteBuffer param1ByteBuffer) {
/* 409 */       XKeymapEvent.nkey_vector(address(), param1ByteBuffer); return this;
/*     */     } public Buffer key_vector(int param1Int, @NativeType("char") byte param1Byte) {
/* 411 */       XKeymapEvent.nkey_vector(address(), param1Int, param1Byte); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XKeymapEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */