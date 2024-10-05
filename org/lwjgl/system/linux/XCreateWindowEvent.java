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
/*     */ public class XCreateWindowEvent
/*     */   extends Struct<XCreateWindowEvent>
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
/*     */   public static final int OVERRIDE_REDIRECT;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  77 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  78 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  80 */     TYPE = layout.offsetof(0);
/*  81 */     SERIAL = layout.offsetof(1);
/*  82 */     SEND_EVENT = layout.offsetof(2);
/*  83 */     DISPLAY = layout.offsetof(3);
/*  84 */     PARENT = layout.offsetof(4);
/*  85 */     WINDOW = layout.offsetof(5);
/*  86 */     X = layout.offsetof(6);
/*  87 */     Y = layout.offsetof(7);
/*  88 */     WIDTH = layout.offsetof(8);
/*  89 */     HEIGHT = layout.offsetof(9);
/*  90 */     BORDER_WIDTH = layout.offsetof(10);
/*  91 */     OVERRIDE_REDIRECT = layout.offsetof(11);
/*     */   }
/*     */   
/*     */   protected XCreateWindowEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  95 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XCreateWindowEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/* 100 */     return new XCreateWindowEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCreateWindowEvent(ByteBuffer paramByteBuffer) {
/* 110 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 114 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 117 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 120 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 123 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 126 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long parent() {
/* 129 */     return nparent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 132 */     return nwindow(address());
/*     */   } public int x() {
/* 134 */     return nx(address());
/*     */   } public int y() {
/* 136 */     return ny(address());
/*     */   } public int width() {
/* 138 */     return nwidth(address());
/*     */   } public int height() {
/* 140 */     return nheight(address());
/*     */   } public int border_width() {
/* 142 */     return nborder_width(address());
/*     */   } public int override_redirect() {
/* 144 */     return noverride_redirect(address());
/*     */   }
/*     */   public XCreateWindowEvent type(int paramInt) {
/* 147 */     ntype(address(), paramInt); return this;
/*     */   } public XCreateWindowEvent serial(@NativeType("unsigned long") long paramLong) {
/* 149 */     nserial(address(), paramLong); return this;
/*     */   } public XCreateWindowEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 151 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XCreateWindowEvent display(@NativeType("Display *") long paramLong) {
/* 153 */     ndisplay(address(), paramLong); return this;
/*     */   } public XCreateWindowEvent parent(@NativeType("Window") long paramLong) {
/* 155 */     nparent(address(), paramLong); return this;
/*     */   } public XCreateWindowEvent window(@NativeType("Window") long paramLong) {
/* 157 */     nwindow(address(), paramLong); return this;
/*     */   } public XCreateWindowEvent x(int paramInt) {
/* 159 */     nx(address(), paramInt); return this;
/*     */   } public XCreateWindowEvent y(int paramInt) {
/* 161 */     ny(address(), paramInt); return this;
/*     */   } public XCreateWindowEvent width(int paramInt) {
/* 163 */     nwidth(address(), paramInt); return this;
/*     */   } public XCreateWindowEvent height(int paramInt) {
/* 165 */     nheight(address(), paramInt); return this;
/*     */   } public XCreateWindowEvent border_width(int paramInt) {
/* 167 */     nborder_width(address(), paramInt); return this;
/*     */   } public XCreateWindowEvent override_redirect(int paramInt) {
/* 169 */     noverride_redirect(address(), paramInt); return this;
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
/*     */   public XCreateWindowEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/* 186 */     type(paramInt1);
/* 187 */     serial(paramLong1);
/* 188 */     send_event(paramBoolean);
/* 189 */     display(paramLong2);
/* 190 */     parent(paramLong3);
/* 191 */     window(paramLong4);
/* 192 */     x(paramInt2);
/* 193 */     y(paramInt3);
/* 194 */     width(paramInt4);
/* 195 */     height(paramInt5);
/* 196 */     border_width(paramInt6);
/* 197 */     override_redirect(paramInt7);
/*     */     
/* 199 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCreateWindowEvent set(XCreateWindowEvent paramXCreateWindowEvent) {
/* 210 */     MemoryUtil.memCopy(paramXCreateWindowEvent.address(), address(), SIZEOF);
/* 211 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent malloc() {
/* 218 */     return new XCreateWindowEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent calloc() {
/* 223 */     return new XCreateWindowEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent create() {
/* 228 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 229 */     return new XCreateWindowEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent create(long paramLong) {
/* 234 */     return new XCreateWindowEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent createSafe(long paramLong) {
/* 240 */     return (paramLong == 0L) ? null : new XCreateWindowEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 249 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 258 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 267 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 268 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 278 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 284 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XCreateWindowEvent mallocStack() {
/* 290 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 292 */   public static XCreateWindowEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 294 */   public static XCreateWindowEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 296 */   public static XCreateWindowEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 298 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 300 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 302 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 304 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent malloc(MemoryStack paramMemoryStack) {
/* 312 */     return new XCreateWindowEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCreateWindowEvent calloc(MemoryStack paramMemoryStack) {
/* 321 */     return new XCreateWindowEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 331 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 341 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 347 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 349 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 351 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 353 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nparent(long paramLong) {
/* 355 */     return MemoryUtil.memGetCLong(paramLong + PARENT);
/*     */   } public static long nwindow(long paramLong) {
/* 357 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static int nx(long paramLong) {
/* 359 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 361 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static int nwidth(long paramLong) {
/* 363 */     return UNSAFE.getInt(null, paramLong + WIDTH);
/*     */   } public static int nheight(long paramLong) {
/* 365 */     return UNSAFE.getInt(null, paramLong + HEIGHT);
/*     */   } public static int nborder_width(long paramLong) {
/* 367 */     return UNSAFE.getInt(null, paramLong + BORDER_WIDTH);
/*     */   } public static int noverride_redirect(long paramLong) {
/* 369 */     return UNSAFE.getInt(null, paramLong + OVERRIDE_REDIRECT);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 372 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 374 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 376 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 378 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nparent(long paramLong1, long paramLong2) {
/* 380 */     MemoryUtil.memPutCLong(paramLong1 + PARENT, paramLong2);
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 382 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nx(long paramLong, int paramInt) {
/* 384 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 386 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
/*     */   } public static void nwidth(long paramLong, int paramInt) {
/* 388 */     UNSAFE.putInt(null, paramLong + WIDTH, paramInt);
/*     */   } public static void nheight(long paramLong, int paramInt) {
/* 390 */     UNSAFE.putInt(null, paramLong + HEIGHT, paramInt);
/*     */   } public static void nborder_width(long paramLong, int paramInt) {
/* 392 */     UNSAFE.putInt(null, paramLong + BORDER_WIDTH, paramInt);
/*     */   } public static void noverride_redirect(long paramLong, int paramInt) {
/* 394 */     UNSAFE.putInt(null, paramLong + OVERRIDE_REDIRECT, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 402 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XCreateWindowEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 410 */     private static final XCreateWindowEvent ELEMENT_FACTORY = XCreateWindowEvent.create(-1L);
/*     */ 
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
/* 422 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XCreateWindowEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 426 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 430 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 435 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XCreateWindowEvent getElementFactory() {
/* 440 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 444 */       return XCreateWindowEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 447 */       return XCreateWindowEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 450 */       return (XCreateWindowEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 453 */       return XCreateWindowEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long parent() {
/* 456 */       return XCreateWindowEvent.nparent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 459 */       return XCreateWindowEvent.nwindow(address());
/*     */     } public int x() {
/* 461 */       return XCreateWindowEvent.nx(address());
/*     */     } public int y() {
/* 463 */       return XCreateWindowEvent.ny(address());
/*     */     } public int width() {
/* 465 */       return XCreateWindowEvent.nwidth(address());
/*     */     } public int height() {
/* 467 */       return XCreateWindowEvent.nheight(address());
/*     */     } public int border_width() {
/* 469 */       return XCreateWindowEvent.nborder_width(address());
/*     */     } public int override_redirect() {
/* 471 */       return XCreateWindowEvent.noverride_redirect(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 474 */       XCreateWindowEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 476 */       XCreateWindowEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 478 */       XCreateWindowEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 480 */       XCreateWindowEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer parent(@NativeType("Window") long param1Long) {
/* 482 */       XCreateWindowEvent.nparent(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 484 */       XCreateWindowEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer x(int param1Int) {
/* 486 */       XCreateWindowEvent.nx(address(), param1Int); return this;
/*     */     } public Buffer y(int param1Int) {
/* 488 */       XCreateWindowEvent.ny(address(), param1Int); return this;
/*     */     } public Buffer width(int param1Int) {
/* 490 */       XCreateWindowEvent.nwidth(address(), param1Int); return this;
/*     */     } public Buffer height(int param1Int) {
/* 492 */       XCreateWindowEvent.nheight(address(), param1Int); return this;
/*     */     } public Buffer border_width(int param1Int) {
/* 494 */       XCreateWindowEvent.nborder_width(address(), param1Int); return this;
/*     */     } public Buffer override_redirect(int param1Int) {
/* 496 */       XCreateWindowEvent.noverride_redirect(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XCreateWindowEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */