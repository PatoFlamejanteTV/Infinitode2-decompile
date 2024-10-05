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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XCrossingEvent
/*     */   extends Struct<XCrossingEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int ROOT;
/*     */   public static final int SUBWINDOW;
/*     */   public static final int TIME;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int X_ROOT;
/*     */   public static final int Y_ROOT;
/*     */   public static final int MODE;
/*     */   public static final int DETAIL;
/*     */   public static final int SAME_SCREEN;
/*     */   public static final int FOCUS;
/*     */   public static final int STATE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  92 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  93 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  95 */     TYPE = layout.offsetof(0);
/*  96 */     SERIAL = layout.offsetof(1);
/*  97 */     SEND_EVENT = layout.offsetof(2);
/*  98 */     DISPLAY = layout.offsetof(3);
/*  99 */     WINDOW = layout.offsetof(4);
/* 100 */     ROOT = layout.offsetof(5);
/* 101 */     SUBWINDOW = layout.offsetof(6);
/* 102 */     TIME = layout.offsetof(7);
/* 103 */     X = layout.offsetof(8);
/* 104 */     Y = layout.offsetof(9);
/* 105 */     X_ROOT = layout.offsetof(10);
/* 106 */     Y_ROOT = layout.offsetof(11);
/* 107 */     MODE = layout.offsetof(12);
/* 108 */     DETAIL = layout.offsetof(13);
/* 109 */     SAME_SCREEN = layout.offsetof(14);
/* 110 */     FOCUS = layout.offsetof(15);
/* 111 */     STATE = layout.offsetof(16);
/*     */   }
/*     */   
/*     */   protected XCrossingEvent(long paramLong, ByteBuffer paramByteBuffer) {
/* 115 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XCrossingEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/* 120 */     return new XCrossingEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCrossingEvent(ByteBuffer paramByteBuffer) {
/* 130 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 134 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 137 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 140 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 143 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 146 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 149 */     return nwindow(address());
/*     */   } @NativeType("Window")
/*     */   public long root() {
/* 152 */     return nroot(address());
/*     */   } @NativeType("Window")
/*     */   public long subwindow() {
/* 155 */     return nsubwindow(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 158 */     return ntime(address());
/*     */   } public int x() {
/* 160 */     return nx(address());
/*     */   } public int y() {
/* 162 */     return ny(address());
/*     */   } public int x_root() {
/* 164 */     return nx_root(address());
/*     */   } public int y_root() {
/* 166 */     return ny_root(address());
/*     */   } public int mode() {
/* 168 */     return nmode(address());
/*     */   } public int detail() {
/* 170 */     return ndetail(address());
/*     */   } public int same_screen() {
/* 172 */     return nsame_screen(address());
/*     */   } public int focus() {
/* 174 */     return nfocus(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int state() {
/* 177 */     return nstate(address());
/*     */   }
/*     */   public XCrossingEvent type(int paramInt) {
/* 180 */     ntype(address(), paramInt); return this;
/*     */   } public XCrossingEvent serial(@NativeType("unsigned long") long paramLong) {
/* 182 */     nserial(address(), paramLong); return this;
/*     */   } public XCrossingEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 184 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XCrossingEvent display(@NativeType("Display *") long paramLong) {
/* 186 */     ndisplay(address(), paramLong); return this;
/*     */   } public XCrossingEvent window(@NativeType("Window") long paramLong) {
/* 188 */     nwindow(address(), paramLong); return this;
/*     */   } public XCrossingEvent root(@NativeType("Window") long paramLong) {
/* 190 */     nroot(address(), paramLong); return this;
/*     */   } public XCrossingEvent subwindow(@NativeType("Window") long paramLong) {
/* 192 */     nsubwindow(address(), paramLong); return this;
/*     */   } public XCrossingEvent time(@NativeType("Time") long paramLong) {
/* 194 */     ntime(address(), paramLong); return this;
/*     */   } public XCrossingEvent x(int paramInt) {
/* 196 */     nx(address(), paramInt); return this;
/*     */   } public XCrossingEvent y(int paramInt) {
/* 198 */     ny(address(), paramInt); return this;
/*     */   } public XCrossingEvent x_root(int paramInt) {
/* 200 */     nx_root(address(), paramInt); return this;
/*     */   } public XCrossingEvent y_root(int paramInt) {
/* 202 */     ny_root(address(), paramInt); return this;
/*     */   } public XCrossingEvent mode(int paramInt) {
/* 204 */     nmode(address(), paramInt); return this;
/*     */   } public XCrossingEvent detail(int paramInt) {
/* 206 */     ndetail(address(), paramInt); return this;
/*     */   } public XCrossingEvent same_screen(int paramInt) {
/* 208 */     nsame_screen(address(), paramInt); return this;
/*     */   } public XCrossingEvent focus(int paramInt) {
/* 210 */     nfocus(address(), paramInt); return this;
/*     */   } public XCrossingEvent state(@NativeType("unsigned int") int paramInt) {
/* 212 */     nstate(address(), paramInt); return this;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public XCrossingEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
/* 234 */     type(paramInt1);
/* 235 */     serial(paramLong1);
/* 236 */     send_event(paramBoolean);
/* 237 */     display(paramLong2);
/* 238 */     window(paramLong3);
/* 239 */     root(paramLong4);
/* 240 */     subwindow(paramLong5);
/* 241 */     time(paramLong6);
/* 242 */     x(paramInt2);
/* 243 */     y(paramInt3);
/* 244 */     x_root(paramInt4);
/* 245 */     y_root(paramInt5);
/* 246 */     mode(paramInt6);
/* 247 */     detail(paramInt7);
/* 248 */     same_screen(paramInt8);
/* 249 */     focus(paramInt9);
/* 250 */     state(paramInt10);
/*     */     
/* 252 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCrossingEvent set(XCrossingEvent paramXCrossingEvent) {
/* 263 */     MemoryUtil.memCopy(paramXCrossingEvent.address(), address(), SIZEOF);
/* 264 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCrossingEvent malloc() {
/* 271 */     return new XCrossingEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCrossingEvent calloc() {
/* 276 */     return new XCrossingEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCrossingEvent create() {
/* 281 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 282 */     return new XCrossingEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCrossingEvent create(long paramLong) {
/* 287 */     return new XCrossingEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCrossingEvent createSafe(long paramLong) {
/* 293 */     return (paramLong == 0L) ? null : new XCrossingEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 302 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 311 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 320 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 321 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 331 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 337 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XCrossingEvent mallocStack() {
/* 343 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 345 */   public static XCrossingEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 347 */   public static XCrossingEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 349 */   public static XCrossingEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 351 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 353 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 355 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 357 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCrossingEvent malloc(MemoryStack paramMemoryStack) {
/* 365 */     return new XCrossingEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCrossingEvent calloc(MemoryStack paramMemoryStack) {
/* 374 */     return new XCrossingEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 384 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 394 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 400 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 402 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 404 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 406 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 408 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static long nroot(long paramLong) {
/* 410 */     return MemoryUtil.memGetCLong(paramLong + ROOT);
/*     */   } public static long nsubwindow(long paramLong) {
/* 412 */     return MemoryUtil.memGetCLong(paramLong + SUBWINDOW);
/*     */   } public static long ntime(long paramLong) {
/* 414 */     return MemoryUtil.memGetCLong(paramLong + TIME);
/*     */   } public static int nx(long paramLong) {
/* 416 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 418 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static int nx_root(long paramLong) {
/* 420 */     return UNSAFE.getInt(null, paramLong + X_ROOT);
/*     */   } public static int ny_root(long paramLong) {
/* 422 */     return UNSAFE.getInt(null, paramLong + Y_ROOT);
/*     */   } public static int nmode(long paramLong) {
/* 424 */     return UNSAFE.getInt(null, paramLong + MODE);
/*     */   } public static int ndetail(long paramLong) {
/* 426 */     return UNSAFE.getInt(null, paramLong + DETAIL);
/*     */   } public static int nsame_screen(long paramLong) {
/* 428 */     return UNSAFE.getInt(null, paramLong + SAME_SCREEN);
/*     */   } public static int nfocus(long paramLong) {
/* 430 */     return UNSAFE.getInt(null, paramLong + FOCUS);
/*     */   } public static int nstate(long paramLong) {
/* 432 */     return UNSAFE.getInt(null, paramLong + STATE);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 435 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 437 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 439 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 441 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 443 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nroot(long paramLong1, long paramLong2) {
/* 445 */     MemoryUtil.memPutCLong(paramLong1 + ROOT, paramLong2);
/*     */   } public static void nsubwindow(long paramLong1, long paramLong2) {
/* 447 */     MemoryUtil.memPutCLong(paramLong1 + SUBWINDOW, paramLong2);
/*     */   } public static void ntime(long paramLong1, long paramLong2) {
/* 449 */     MemoryUtil.memPutCLong(paramLong1 + TIME, paramLong2);
/*     */   } public static void nx(long paramLong, int paramInt) {
/* 451 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 453 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
/*     */   } public static void nx_root(long paramLong, int paramInt) {
/* 455 */     UNSAFE.putInt(null, paramLong + X_ROOT, paramInt);
/*     */   } public static void ny_root(long paramLong, int paramInt) {
/* 457 */     UNSAFE.putInt(null, paramLong + Y_ROOT, paramInt);
/*     */   } public static void nmode(long paramLong, int paramInt) {
/* 459 */     UNSAFE.putInt(null, paramLong + MODE, paramInt);
/*     */   } public static void ndetail(long paramLong, int paramInt) {
/* 461 */     UNSAFE.putInt(null, paramLong + DETAIL, paramInt);
/*     */   } public static void nsame_screen(long paramLong, int paramInt) {
/* 463 */     UNSAFE.putInt(null, paramLong + SAME_SCREEN, paramInt);
/*     */   } public static void nfocus(long paramLong, int paramInt) {
/* 465 */     UNSAFE.putInt(null, paramLong + FOCUS, paramInt);
/*     */   } public static void nstate(long paramLong, int paramInt) {
/* 467 */     UNSAFE.putInt(null, paramLong + STATE, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 475 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XCrossingEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 483 */     private static final XCrossingEvent ELEMENT_FACTORY = XCrossingEvent.create(-1L);
/*     */ 
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
/* 495 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XCrossingEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 499 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 503 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 508 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XCrossingEvent getElementFactory() {
/* 513 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 517 */       return XCrossingEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 520 */       return XCrossingEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 523 */       return (XCrossingEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 526 */       return XCrossingEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 529 */       return XCrossingEvent.nwindow(address());
/*     */     } @NativeType("Window")
/*     */     public long root() {
/* 532 */       return XCrossingEvent.nroot(address());
/*     */     } @NativeType("Window")
/*     */     public long subwindow() {
/* 535 */       return XCrossingEvent.nsubwindow(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 538 */       return XCrossingEvent.ntime(address());
/*     */     } public int x() {
/* 540 */       return XCrossingEvent.nx(address());
/*     */     } public int y() {
/* 542 */       return XCrossingEvent.ny(address());
/*     */     } public int x_root() {
/* 544 */       return XCrossingEvent.nx_root(address());
/*     */     } public int y_root() {
/* 546 */       return XCrossingEvent.ny_root(address());
/*     */     } public int mode() {
/* 548 */       return XCrossingEvent.nmode(address());
/*     */     } public int detail() {
/* 550 */       return XCrossingEvent.ndetail(address());
/*     */     } public int same_screen() {
/* 552 */       return XCrossingEvent.nsame_screen(address());
/*     */     } public int focus() {
/* 554 */       return XCrossingEvent.nfocus(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int state() {
/* 557 */       return XCrossingEvent.nstate(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 560 */       XCrossingEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 562 */       XCrossingEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 564 */       XCrossingEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 566 */       XCrossingEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 568 */       XCrossingEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer root(@NativeType("Window") long param1Long) {
/* 570 */       XCrossingEvent.nroot(address(), param1Long); return this;
/*     */     } public Buffer subwindow(@NativeType("Window") long param1Long) {
/* 572 */       XCrossingEvent.nsubwindow(address(), param1Long); return this;
/*     */     } public Buffer time(@NativeType("Time") long param1Long) {
/* 574 */       XCrossingEvent.ntime(address(), param1Long); return this;
/*     */     } public Buffer x(int param1Int) {
/* 576 */       XCrossingEvent.nx(address(), param1Int); return this;
/*     */     } public Buffer y(int param1Int) {
/* 578 */       XCrossingEvent.ny(address(), param1Int); return this;
/*     */     } public Buffer x_root(int param1Int) {
/* 580 */       XCrossingEvent.nx_root(address(), param1Int); return this;
/*     */     } public Buffer y_root(int param1Int) {
/* 582 */       XCrossingEvent.ny_root(address(), param1Int); return this;
/*     */     } public Buffer mode(int param1Int) {
/* 584 */       XCrossingEvent.nmode(address(), param1Int); return this;
/*     */     } public Buffer detail(int param1Int) {
/* 586 */       XCrossingEvent.ndetail(address(), param1Int); return this;
/*     */     } public Buffer same_screen(int param1Int) {
/* 588 */       XCrossingEvent.nsame_screen(address(), param1Int); return this;
/*     */     } public Buffer focus(int param1Int) {
/* 590 */       XCrossingEvent.nfocus(address(), param1Int); return this;
/*     */     } public Buffer state(@NativeType("unsigned int") int param1Int) {
/* 592 */       XCrossingEvent.nstate(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XCrossingEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */