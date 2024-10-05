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
/*     */ public class XMappingEvent
/*     */   extends Struct<XMappingEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int REQUEST;
/*     */   public static final int FIRST_KEYCODE;
/*     */   public static final int COUNT;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  65 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4) })).getSize();
/*  66 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  68 */     TYPE = layout.offsetof(0);
/*  69 */     SERIAL = layout.offsetof(1);
/*  70 */     SEND_EVENT = layout.offsetof(2);
/*  71 */     DISPLAY = layout.offsetof(3);
/*  72 */     WINDOW = layout.offsetof(4);
/*  73 */     REQUEST = layout.offsetof(5);
/*  74 */     FIRST_KEYCODE = layout.offsetof(6);
/*  75 */     COUNT = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected XMappingEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  79 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XMappingEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  84 */     return new XMappingEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMappingEvent(ByteBuffer paramByteBuffer) {
/*  94 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  98 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 101 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 104 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 107 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 110 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 113 */     return nwindow(address());
/*     */   } public int request() {
/* 115 */     return nrequest(address());
/*     */   } public int first_keycode() {
/* 117 */     return nfirst_keycode(address());
/*     */   } public int count() {
/* 119 */     return ncount(address());
/*     */   }
/*     */   public XMappingEvent type(int paramInt) {
/* 122 */     ntype(address(), paramInt); return this;
/*     */   } public XMappingEvent serial(@NativeType("unsigned long") long paramLong) {
/* 124 */     nserial(address(), paramLong); return this;
/*     */   } public XMappingEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 126 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XMappingEvent display(@NativeType("Display *") long paramLong) {
/* 128 */     ndisplay(address(), paramLong); return this;
/*     */   } public XMappingEvent window(@NativeType("Window") long paramLong) {
/* 130 */     nwindow(address(), paramLong); return this;
/*     */   } public XMappingEvent request(int paramInt) {
/* 132 */     nrequest(address(), paramInt); return this;
/*     */   } public XMappingEvent first_keycode(int paramInt) {
/* 134 */     nfirst_keycode(address(), paramInt); return this;
/*     */   } public XMappingEvent count(int paramInt) {
/* 136 */     ncount(address(), paramInt); return this;
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
/*     */   public XMappingEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, int paramInt2, int paramInt3, int paramInt4) {
/* 149 */     type(paramInt1);
/* 150 */     serial(paramLong1);
/* 151 */     send_event(paramBoolean);
/* 152 */     display(paramLong2);
/* 153 */     window(paramLong3);
/* 154 */     request(paramInt2);
/* 155 */     first_keycode(paramInt3);
/* 156 */     count(paramInt4);
/*     */     
/* 158 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMappingEvent set(XMappingEvent paramXMappingEvent) {
/* 169 */     MemoryUtil.memCopy(paramXMappingEvent.address(), address(), SIZEOF);
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMappingEvent malloc() {
/* 177 */     return new XMappingEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMappingEvent calloc() {
/* 182 */     return new XMappingEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMappingEvent create() {
/* 187 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 188 */     return new XMappingEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMappingEvent create(long paramLong) {
/* 193 */     return new XMappingEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMappingEvent createSafe(long paramLong) {
/* 199 */     return (paramLong == 0L) ? null : new XMappingEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 208 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 217 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 226 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 227 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 237 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 243 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XMappingEvent mallocStack() {
/* 249 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 251 */   public static XMappingEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 253 */   public static XMappingEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 255 */   public static XMappingEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 257 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 259 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 261 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 263 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMappingEvent malloc(MemoryStack paramMemoryStack) {
/* 271 */     return new XMappingEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMappingEvent calloc(MemoryStack paramMemoryStack) {
/* 280 */     return new XMappingEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 290 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 300 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 306 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 308 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 310 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 312 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 314 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static int nrequest(long paramLong) {
/* 316 */     return UNSAFE.getInt(null, paramLong + REQUEST);
/*     */   } public static int nfirst_keycode(long paramLong) {
/* 318 */     return UNSAFE.getInt(null, paramLong + FIRST_KEYCODE);
/*     */   } public static int ncount(long paramLong) {
/* 320 */     return UNSAFE.getInt(null, paramLong + COUNT);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 323 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 325 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 327 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 329 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 331 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nrequest(long paramLong, int paramInt) {
/* 333 */     UNSAFE.putInt(null, paramLong + REQUEST, paramInt);
/*     */   } public static void nfirst_keycode(long paramLong, int paramInt) {
/* 335 */     UNSAFE.putInt(null, paramLong + FIRST_KEYCODE, paramInt);
/*     */   } public static void ncount(long paramLong, int paramInt) {
/* 337 */     UNSAFE.putInt(null, paramLong + COUNT, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 345 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XMappingEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 353 */     private static final XMappingEvent ELEMENT_FACTORY = XMappingEvent.create(-1L);
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
/* 365 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XMappingEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 369 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 373 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 378 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XMappingEvent getElementFactory() {
/* 383 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 387 */       return XMappingEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 390 */       return XMappingEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 393 */       return (XMappingEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 396 */       return XMappingEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 399 */       return XMappingEvent.nwindow(address());
/*     */     } public int request() {
/* 401 */       return XMappingEvent.nrequest(address());
/*     */     } public int first_keycode() {
/* 403 */       return XMappingEvent.nfirst_keycode(address());
/*     */     } public int count() {
/* 405 */       return XMappingEvent.ncount(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 408 */       XMappingEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 410 */       XMappingEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 412 */       XMappingEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 414 */       XMappingEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 416 */       XMappingEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer request(int param1Int) {
/* 418 */       XMappingEvent.nrequest(address(), param1Int); return this;
/*     */     } public Buffer first_keycode(int param1Int) {
/* 420 */       XMappingEvent.nfirst_keycode(address(), param1Int); return this;
/*     */     } public Buffer count(int param1Int) {
/* 422 */       XMappingEvent.ncount(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XMappingEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */