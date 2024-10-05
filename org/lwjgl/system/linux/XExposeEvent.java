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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XExposeEvent
/*     */   extends Struct<XExposeEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int COUNT;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  71 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  72 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  74 */     TYPE = layout.offsetof(0);
/*  75 */     SERIAL = layout.offsetof(1);
/*  76 */     SEND_EVENT = layout.offsetof(2);
/*  77 */     DISPLAY = layout.offsetof(3);
/*  78 */     WINDOW = layout.offsetof(4);
/*  79 */     X = layout.offsetof(5);
/*  80 */     Y = layout.offsetof(6);
/*  81 */     WIDTH = layout.offsetof(7);
/*  82 */     HEIGHT = layout.offsetof(8);
/*  83 */     COUNT = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected XExposeEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  87 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XExposeEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  92 */     return new XExposeEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XExposeEvent(ByteBuffer paramByteBuffer) {
/* 102 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 106 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 109 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 112 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 115 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 118 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 121 */     return nwindow(address());
/*     */   } public int x() {
/* 123 */     return nx(address());
/*     */   } public int y() {
/* 125 */     return ny(address());
/*     */   } public int width() {
/* 127 */     return nwidth(address());
/*     */   } public int height() {
/* 129 */     return nheight(address());
/*     */   } public int count() {
/* 131 */     return ncount(address());
/*     */   }
/*     */   public XExposeEvent type(int paramInt) {
/* 134 */     ntype(address(), paramInt); return this;
/*     */   } public XExposeEvent serial(@NativeType("unsigned long") long paramLong) {
/* 136 */     nserial(address(), paramLong); return this;
/*     */   } public XExposeEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 138 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XExposeEvent display(@NativeType("Display *") long paramLong) {
/* 140 */     ndisplay(address(), paramLong); return this;
/*     */   } public XExposeEvent window(@NativeType("Window") long paramLong) {
/* 142 */     nwindow(address(), paramLong); return this;
/*     */   } public XExposeEvent x(int paramInt) {
/* 144 */     nx(address(), paramInt); return this;
/*     */   } public XExposeEvent y(int paramInt) {
/* 146 */     ny(address(), paramInt); return this;
/*     */   } public XExposeEvent width(int paramInt) {
/* 148 */     nwidth(address(), paramInt); return this;
/*     */   } public XExposeEvent height(int paramInt) {
/* 150 */     nheight(address(), paramInt); return this;
/*     */   } public XExposeEvent count(int paramInt) {
/* 152 */     ncount(address(), paramInt); return this;
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
/*     */   public XExposeEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 167 */     type(paramInt1);
/* 168 */     serial(paramLong1);
/* 169 */     send_event(paramBoolean);
/* 170 */     display(paramLong2);
/* 171 */     window(paramLong3);
/* 172 */     x(paramInt2);
/* 173 */     y(paramInt3);
/* 174 */     width(paramInt4);
/* 175 */     height(paramInt5);
/* 176 */     count(paramInt6);
/*     */     
/* 178 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XExposeEvent set(XExposeEvent paramXExposeEvent) {
/* 189 */     MemoryUtil.memCopy(paramXExposeEvent.address(), address(), SIZEOF);
/* 190 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XExposeEvent malloc() {
/* 197 */     return new XExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XExposeEvent calloc() {
/* 202 */     return new XExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XExposeEvent create() {
/* 207 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 208 */     return new XExposeEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XExposeEvent create(long paramLong) {
/* 213 */     return new XExposeEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XExposeEvent createSafe(long paramLong) {
/* 219 */     return (paramLong == 0L) ? null : new XExposeEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 228 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 237 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 246 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 247 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 257 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 263 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XExposeEvent mallocStack() {
/* 269 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 271 */   public static XExposeEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 273 */   public static XExposeEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 275 */   public static XExposeEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 277 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 279 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 281 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 283 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XExposeEvent malloc(MemoryStack paramMemoryStack) {
/* 291 */     return new XExposeEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XExposeEvent calloc(MemoryStack paramMemoryStack) {
/* 300 */     return new XExposeEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 310 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 320 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 326 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 328 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 330 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 332 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 334 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static int nx(long paramLong) {
/* 336 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 338 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static int nwidth(long paramLong) {
/* 340 */     return UNSAFE.getInt(null, paramLong + WIDTH);
/*     */   } public static int nheight(long paramLong) {
/* 342 */     return UNSAFE.getInt(null, paramLong + HEIGHT);
/*     */   } public static int ncount(long paramLong) {
/* 344 */     return UNSAFE.getInt(null, paramLong + COUNT);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 347 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 349 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 351 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 353 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 355 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nx(long paramLong, int paramInt) {
/* 357 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 359 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
/*     */   } public static void nwidth(long paramLong, int paramInt) {
/* 361 */     UNSAFE.putInt(null, paramLong + WIDTH, paramInt);
/*     */   } public static void nheight(long paramLong, int paramInt) {
/* 363 */     UNSAFE.putInt(null, paramLong + HEIGHT, paramInt);
/*     */   } public static void ncount(long paramLong, int paramInt) {
/* 365 */     UNSAFE.putInt(null, paramLong + COUNT, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 373 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XExposeEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 381 */     private static final XExposeEvent ELEMENT_FACTORY = XExposeEvent.create(-1L);
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
/* 393 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XExposeEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 397 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 401 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 406 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XExposeEvent getElementFactory() {
/* 411 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 415 */       return XExposeEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 418 */       return XExposeEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 421 */       return (XExposeEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 424 */       return XExposeEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 427 */       return XExposeEvent.nwindow(address());
/*     */     } public int x() {
/* 429 */       return XExposeEvent.nx(address());
/*     */     } public int y() {
/* 431 */       return XExposeEvent.ny(address());
/*     */     } public int width() {
/* 433 */       return XExposeEvent.nwidth(address());
/*     */     } public int height() {
/* 435 */       return XExposeEvent.nheight(address());
/*     */     } public int count() {
/* 437 */       return XExposeEvent.ncount(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 440 */       XExposeEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 442 */       XExposeEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 444 */       XExposeEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 446 */       XExposeEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 448 */       XExposeEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer x(int param1Int) {
/* 450 */       XExposeEvent.nx(address(), param1Int); return this;
/*     */     } public Buffer y(int param1Int) {
/* 452 */       XExposeEvent.ny(address(), param1Int); return this;
/*     */     } public Buffer width(int param1Int) {
/* 454 */       XExposeEvent.nwidth(address(), param1Int); return this;
/*     */     } public Buffer height(int param1Int) {
/* 456 */       XExposeEvent.nheight(address(), param1Int); return this;
/*     */     } public Buffer count(int param1Int) {
/* 458 */       XExposeEvent.ncount(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XExposeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */