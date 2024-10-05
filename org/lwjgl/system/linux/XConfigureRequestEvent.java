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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XConfigureRequestEvent
/*     */   extends Struct<XConfigureRequestEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int PARENT;
/*     */   public static final int WINDOW;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int BORDER_WIDTH;
/*     */   public static final int ABOVE;
/*     */   public static final int DETAIL;
/*     */   public static final int VALUE_MASK;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  83 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4), __member(4), __member(4), __member(CLONG_SIZE), __member(4), __member(CLONG_SIZE) })).getSize();
/*  84 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  86 */     TYPE = layout.offsetof(0);
/*  87 */     SERIAL = layout.offsetof(1);
/*  88 */     SEND_EVENT = layout.offsetof(2);
/*  89 */     DISPLAY = layout.offsetof(3);
/*  90 */     PARENT = layout.offsetof(4);
/*  91 */     WINDOW = layout.offsetof(5);
/*  92 */     X = layout.offsetof(6);
/*  93 */     Y = layout.offsetof(7);
/*  94 */     WIDTH = layout.offsetof(8);
/*  95 */     HEIGHT = layout.offsetof(9);
/*  96 */     BORDER_WIDTH = layout.offsetof(10);
/*  97 */     ABOVE = layout.offsetof(11);
/*  98 */     DETAIL = layout.offsetof(12);
/*  99 */     VALUE_MASK = layout.offsetof(13);
/*     */   }
/*     */   
/*     */   protected XConfigureRequestEvent(long paramLong, ByteBuffer paramByteBuffer) {
/* 103 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XConfigureRequestEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/* 108 */     return new XConfigureRequestEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XConfigureRequestEvent(ByteBuffer paramByteBuffer) {
/* 118 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 122 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 125 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 128 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 131 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 134 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long parent() {
/* 137 */     return nparent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 140 */     return nwindow(address());
/*     */   } public int x() {
/* 142 */     return nx(address());
/*     */   } public int y() {
/* 144 */     return ny(address());
/*     */   } public int width() {
/* 146 */     return nwidth(address());
/*     */   } public int height() {
/* 148 */     return nheight(address());
/*     */   } public int border_width() {
/* 150 */     return nborder_width(address());
/*     */   } @NativeType("Window")
/*     */   public long above() {
/* 153 */     return nabove(address());
/*     */   } public int detail() {
/* 155 */     return ndetail(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long value_mask() {
/* 158 */     return nvalue_mask(address());
/*     */   }
/*     */   public XConfigureRequestEvent type(int paramInt) {
/* 161 */     ntype(address(), paramInt); return this;
/*     */   } public XConfigureRequestEvent serial(@NativeType("unsigned long") long paramLong) {
/* 163 */     nserial(address(), paramLong); return this;
/*     */   } public XConfigureRequestEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 165 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XConfigureRequestEvent display(@NativeType("Display *") long paramLong) {
/* 167 */     ndisplay(address(), paramLong); return this;
/*     */   } public XConfigureRequestEvent parent(@NativeType("Window") long paramLong) {
/* 169 */     nparent(address(), paramLong); return this;
/*     */   } public XConfigureRequestEvent window(@NativeType("Window") long paramLong) {
/* 171 */     nwindow(address(), paramLong); return this;
/*     */   } public XConfigureRequestEvent x(int paramInt) {
/* 173 */     nx(address(), paramInt); return this;
/*     */   } public XConfigureRequestEvent y(int paramInt) {
/* 175 */     ny(address(), paramInt); return this;
/*     */   } public XConfigureRequestEvent width(int paramInt) {
/* 177 */     nwidth(address(), paramInt); return this;
/*     */   } public XConfigureRequestEvent height(int paramInt) {
/* 179 */     nheight(address(), paramInt); return this;
/*     */   } public XConfigureRequestEvent border_width(int paramInt) {
/* 181 */     nborder_width(address(), paramInt); return this;
/*     */   } public XConfigureRequestEvent above(@NativeType("Window") long paramLong) {
/* 183 */     nabove(address(), paramLong); return this;
/*     */   } public XConfigureRequestEvent detail(int paramInt) {
/* 185 */     ndetail(address(), paramInt); return this;
/*     */   } public XConfigureRequestEvent value_mask(@NativeType("unsigned long") long paramLong) {
/* 187 */     nvalue_mask(address(), paramLong); return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XConfigureRequestEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong5, int paramInt7, long paramLong6) {
/* 206 */     type(paramInt1);
/* 207 */     serial(paramLong1);
/* 208 */     send_event(paramBoolean);
/* 209 */     display(paramLong2);
/* 210 */     parent(paramLong3);
/* 211 */     window(paramLong4);
/* 212 */     x(paramInt2);
/* 213 */     y(paramInt3);
/* 214 */     width(paramInt4);
/* 215 */     height(paramInt5);
/* 216 */     border_width(paramInt6);
/* 217 */     above(paramLong5);
/* 218 */     detail(paramInt7);
/* 219 */     value_mask(paramLong6);
/*     */     
/* 221 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XConfigureRequestEvent set(XConfigureRequestEvent paramXConfigureRequestEvent) {
/* 232 */     MemoryUtil.memCopy(paramXConfigureRequestEvent.address(), address(), SIZEOF);
/* 233 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent malloc() {
/* 240 */     return new XConfigureRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent calloc() {
/* 245 */     return new XConfigureRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent create() {
/* 250 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 251 */     return new XConfigureRequestEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent create(long paramLong) {
/* 256 */     return new XConfigureRequestEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent createSafe(long paramLong) {
/* 262 */     return (paramLong == 0L) ? null : new XConfigureRequestEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 271 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 280 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 289 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 290 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 300 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 306 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XConfigureRequestEvent mallocStack() {
/* 312 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 314 */   public static XConfigureRequestEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 316 */   public static XConfigureRequestEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 318 */   public static XConfigureRequestEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 320 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 322 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 324 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 326 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent malloc(MemoryStack paramMemoryStack) {
/* 334 */     return new XConfigureRequestEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureRequestEvent calloc(MemoryStack paramMemoryStack) {
/* 343 */     return new XConfigureRequestEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 353 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 363 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 369 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 371 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 373 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 375 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nparent(long paramLong) {
/* 377 */     return MemoryUtil.memGetCLong(paramLong + PARENT);
/*     */   } public static long nwindow(long paramLong) {
/* 379 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static int nx(long paramLong) {
/* 381 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 383 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static int nwidth(long paramLong) {
/* 385 */     return UNSAFE.getInt(null, paramLong + WIDTH);
/*     */   } public static int nheight(long paramLong) {
/* 387 */     return UNSAFE.getInt(null, paramLong + HEIGHT);
/*     */   } public static int nborder_width(long paramLong) {
/* 389 */     return UNSAFE.getInt(null, paramLong + BORDER_WIDTH);
/*     */   } public static long nabove(long paramLong) {
/* 391 */     return MemoryUtil.memGetCLong(paramLong + ABOVE);
/*     */   } public static int ndetail(long paramLong) {
/* 393 */     return UNSAFE.getInt(null, paramLong + DETAIL);
/*     */   } public static long nvalue_mask(long paramLong) {
/* 395 */     return MemoryUtil.memGetCLong(paramLong + VALUE_MASK);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 398 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 400 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 402 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 404 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nparent(long paramLong1, long paramLong2) {
/* 406 */     MemoryUtil.memPutCLong(paramLong1 + PARENT, paramLong2);
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 408 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nx(long paramLong, int paramInt) {
/* 410 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 412 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
/*     */   } public static void nwidth(long paramLong, int paramInt) {
/* 414 */     UNSAFE.putInt(null, paramLong + WIDTH, paramInt);
/*     */   } public static void nheight(long paramLong, int paramInt) {
/* 416 */     UNSAFE.putInt(null, paramLong + HEIGHT, paramInt);
/*     */   } public static void nborder_width(long paramLong, int paramInt) {
/* 418 */     UNSAFE.putInt(null, paramLong + BORDER_WIDTH, paramInt);
/*     */   } public static void nabove(long paramLong1, long paramLong2) {
/* 420 */     MemoryUtil.memPutCLong(paramLong1 + ABOVE, paramLong2);
/*     */   } public static void ndetail(long paramLong, int paramInt) {
/* 422 */     UNSAFE.putInt(null, paramLong + DETAIL, paramInt);
/*     */   } public static void nvalue_mask(long paramLong1, long paramLong2) {
/* 424 */     MemoryUtil.memPutCLong(paramLong1 + VALUE_MASK, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 432 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XConfigureRequestEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 440 */     private static final XConfigureRequestEvent ELEMENT_FACTORY = XConfigureRequestEvent.create(-1L);
/*     */ 
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
/* 452 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XConfigureRequestEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 456 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 460 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 465 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XConfigureRequestEvent getElementFactory() {
/* 470 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 474 */       return XConfigureRequestEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 477 */       return XConfigureRequestEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 480 */       return (XConfigureRequestEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 483 */       return XConfigureRequestEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long parent() {
/* 486 */       return XConfigureRequestEvent.nparent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 489 */       return XConfigureRequestEvent.nwindow(address());
/*     */     } public int x() {
/* 491 */       return XConfigureRequestEvent.nx(address());
/*     */     } public int y() {
/* 493 */       return XConfigureRequestEvent.ny(address());
/*     */     } public int width() {
/* 495 */       return XConfigureRequestEvent.nwidth(address());
/*     */     } public int height() {
/* 497 */       return XConfigureRequestEvent.nheight(address());
/*     */     } public int border_width() {
/* 499 */       return XConfigureRequestEvent.nborder_width(address());
/*     */     } @NativeType("Window")
/*     */     public long above() {
/* 502 */       return XConfigureRequestEvent.nabove(address());
/*     */     } public int detail() {
/* 504 */       return XConfigureRequestEvent.ndetail(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long value_mask() {
/* 507 */       return XConfigureRequestEvent.nvalue_mask(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 510 */       XConfigureRequestEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 512 */       XConfigureRequestEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 514 */       XConfigureRequestEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 516 */       XConfigureRequestEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer parent(@NativeType("Window") long param1Long) {
/* 518 */       XConfigureRequestEvent.nparent(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 520 */       XConfigureRequestEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer x(int param1Int) {
/* 522 */       XConfigureRequestEvent.nx(address(), param1Int); return this;
/*     */     } public Buffer y(int param1Int) {
/* 524 */       XConfigureRequestEvent.ny(address(), param1Int); return this;
/*     */     } public Buffer width(int param1Int) {
/* 526 */       XConfigureRequestEvent.nwidth(address(), param1Int); return this;
/*     */     } public Buffer height(int param1Int) {
/* 528 */       XConfigureRequestEvent.nheight(address(), param1Int); return this;
/*     */     } public Buffer border_width(int param1Int) {
/* 530 */       XConfigureRequestEvent.nborder_width(address(), param1Int); return this;
/*     */     } public Buffer above(@NativeType("Window") long param1Long) {
/* 532 */       XConfigureRequestEvent.nabove(address(), param1Long); return this;
/*     */     } public Buffer detail(int param1Int) {
/* 534 */       XConfigureRequestEvent.ndetail(address(), param1Int); return this;
/*     */     } public Buffer value_mask(@NativeType("unsigned long") long param1Long) {
/* 536 */       XConfigureRequestEvent.nvalue_mask(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XConfigureRequestEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */