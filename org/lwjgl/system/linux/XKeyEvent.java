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
/*     */ public class XKeyEvent
/*     */   extends Struct<XKeyEvent>
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
/*     */   public static final int STATE;
/*     */   public static final int KEYCODE;
/*     */   public static final int SAME_SCREEN;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  88 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  89 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  91 */     TYPE = layout.offsetof(0);
/*  92 */     SERIAL = layout.offsetof(1);
/*  93 */     SEND_EVENT = layout.offsetof(2);
/*  94 */     DISPLAY = layout.offsetof(3);
/*  95 */     WINDOW = layout.offsetof(4);
/*  96 */     ROOT = layout.offsetof(5);
/*  97 */     SUBWINDOW = layout.offsetof(6);
/*  98 */     TIME = layout.offsetof(7);
/*  99 */     X = layout.offsetof(8);
/* 100 */     Y = layout.offsetof(9);
/* 101 */     X_ROOT = layout.offsetof(10);
/* 102 */     Y_ROOT = layout.offsetof(11);
/* 103 */     STATE = layout.offsetof(12);
/* 104 */     KEYCODE = layout.offsetof(13);
/* 105 */     SAME_SCREEN = layout.offsetof(14);
/*     */   }
/*     */   
/*     */   protected XKeyEvent(long paramLong, ByteBuffer paramByteBuffer) {
/* 109 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XKeyEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/* 114 */     return new XKeyEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XKeyEvent(ByteBuffer paramByteBuffer) {
/* 124 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 128 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 131 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 134 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 137 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 140 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 143 */     return nwindow(address());
/*     */   } @NativeType("Window")
/*     */   public long root() {
/* 146 */     return nroot(address());
/*     */   } @NativeType("Window")
/*     */   public long subwindow() {
/* 149 */     return nsubwindow(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 152 */     return ntime(address());
/*     */   } public int x() {
/* 154 */     return nx(address());
/*     */   } public int y() {
/* 156 */     return ny(address());
/*     */   } public int x_root() {
/* 158 */     return nx_root(address());
/*     */   } public int y_root() {
/* 160 */     return ny_root(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int state() {
/* 163 */     return nstate(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int keycode() {
/* 166 */     return nkeycode(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean same_screen() {
/* 169 */     return (nsame_screen(address()) != 0);
/*     */   }
/*     */   public XKeyEvent type(int paramInt) {
/* 172 */     ntype(address(), paramInt); return this;
/*     */   } public XKeyEvent serial(@NativeType("unsigned long") long paramLong) {
/* 174 */     nserial(address(), paramLong); return this;
/*     */   } public XKeyEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 176 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XKeyEvent display(@NativeType("Display *") long paramLong) {
/* 178 */     ndisplay(address(), paramLong); return this;
/*     */   } public XKeyEvent window(@NativeType("Window") long paramLong) {
/* 180 */     nwindow(address(), paramLong); return this;
/*     */   } public XKeyEvent root(@NativeType("Window") long paramLong) {
/* 182 */     nroot(address(), paramLong); return this;
/*     */   } public XKeyEvent subwindow(@NativeType("Window") long paramLong) {
/* 184 */     nsubwindow(address(), paramLong); return this;
/*     */   } public XKeyEvent time(@NativeType("Time") long paramLong) {
/* 186 */     ntime(address(), paramLong); return this;
/*     */   } public XKeyEvent x(int paramInt) {
/* 188 */     nx(address(), paramInt); return this;
/*     */   } public XKeyEvent y(int paramInt) {
/* 190 */     ny(address(), paramInt); return this;
/*     */   } public XKeyEvent x_root(int paramInt) {
/* 192 */     nx_root(address(), paramInt); return this;
/*     */   } public XKeyEvent y_root(int paramInt) {
/* 194 */     ny_root(address(), paramInt); return this;
/*     */   } public XKeyEvent state(@NativeType("unsigned int") int paramInt) {
/* 196 */     nstate(address(), paramInt); return this;
/*     */   } public XKeyEvent keycode(@NativeType("unsigned int") int paramInt) {
/* 198 */     nkeycode(address(), paramInt); return this;
/*     */   } public XKeyEvent same_screen(@NativeType("Bool") boolean paramBoolean) {
/* 200 */     nsame_screen(address(), paramBoolean ? 1 : 0); return this;
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
/*     */   public XKeyEvent set(int paramInt1, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean2) {
/* 220 */     type(paramInt1);
/* 221 */     serial(paramLong1);
/* 222 */     send_event(paramBoolean1);
/* 223 */     display(paramLong2);
/* 224 */     window(paramLong3);
/* 225 */     root(paramLong4);
/* 226 */     subwindow(paramLong5);
/* 227 */     time(paramLong6);
/* 228 */     x(paramInt2);
/* 229 */     y(paramInt3);
/* 230 */     x_root(paramInt4);
/* 231 */     y_root(paramInt5);
/* 232 */     state(paramInt6);
/* 233 */     keycode(paramInt7);
/* 234 */     same_screen(paramBoolean2);
/*     */     
/* 236 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XKeyEvent set(XKeyEvent paramXKeyEvent) {
/* 247 */     MemoryUtil.memCopy(paramXKeyEvent.address(), address(), SIZEOF);
/* 248 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeyEvent malloc() {
/* 255 */     return new XKeyEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeyEvent calloc() {
/* 260 */     return new XKeyEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeyEvent create() {
/* 265 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 266 */     return new XKeyEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XKeyEvent create(long paramLong) {
/* 271 */     return new XKeyEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeyEvent createSafe(long paramLong) {
/* 277 */     return (paramLong == 0L) ? null : new XKeyEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 286 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 295 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 304 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 305 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 315 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 321 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XKeyEvent mallocStack() {
/* 327 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 329 */   public static XKeyEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 331 */   public static XKeyEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 333 */   public static XKeyEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 335 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 337 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 339 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 341 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeyEvent malloc(MemoryStack paramMemoryStack) {
/* 349 */     return new XKeyEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XKeyEvent calloc(MemoryStack paramMemoryStack) {
/* 358 */     return new XKeyEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 368 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 378 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 384 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 386 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 388 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 390 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 392 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static long nroot(long paramLong) {
/* 394 */     return MemoryUtil.memGetCLong(paramLong + ROOT);
/*     */   } public static long nsubwindow(long paramLong) {
/* 396 */     return MemoryUtil.memGetCLong(paramLong + SUBWINDOW);
/*     */   } public static long ntime(long paramLong) {
/* 398 */     return MemoryUtil.memGetCLong(paramLong + TIME);
/*     */   } public static int nx(long paramLong) {
/* 400 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 402 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static int nx_root(long paramLong) {
/* 404 */     return UNSAFE.getInt(null, paramLong + X_ROOT);
/*     */   } public static int ny_root(long paramLong) {
/* 406 */     return UNSAFE.getInt(null, paramLong + Y_ROOT);
/*     */   } public static int nstate(long paramLong) {
/* 408 */     return UNSAFE.getInt(null, paramLong + STATE);
/*     */   } public static int nkeycode(long paramLong) {
/* 410 */     return UNSAFE.getInt(null, paramLong + KEYCODE);
/*     */   } public static int nsame_screen(long paramLong) {
/* 412 */     return UNSAFE.getInt(null, paramLong + SAME_SCREEN);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 415 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 417 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 419 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 421 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 423 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nroot(long paramLong1, long paramLong2) {
/* 425 */     MemoryUtil.memPutCLong(paramLong1 + ROOT, paramLong2);
/*     */   } public static void nsubwindow(long paramLong1, long paramLong2) {
/* 427 */     MemoryUtil.memPutCLong(paramLong1 + SUBWINDOW, paramLong2);
/*     */   } public static void ntime(long paramLong1, long paramLong2) {
/* 429 */     MemoryUtil.memPutCLong(paramLong1 + TIME, paramLong2);
/*     */   } public static void nx(long paramLong, int paramInt) {
/* 431 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 433 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
/*     */   } public static void nx_root(long paramLong, int paramInt) {
/* 435 */     UNSAFE.putInt(null, paramLong + X_ROOT, paramInt);
/*     */   } public static void ny_root(long paramLong, int paramInt) {
/* 437 */     UNSAFE.putInt(null, paramLong + Y_ROOT, paramInt);
/*     */   } public static void nstate(long paramLong, int paramInt) {
/* 439 */     UNSAFE.putInt(null, paramLong + STATE, paramInt);
/*     */   } public static void nkeycode(long paramLong, int paramInt) {
/* 441 */     UNSAFE.putInt(null, paramLong + KEYCODE, paramInt);
/*     */   } public static void nsame_screen(long paramLong, int paramInt) {
/* 443 */     UNSAFE.putInt(null, paramLong + SAME_SCREEN, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 451 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XKeyEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 459 */     private static final XKeyEvent ELEMENT_FACTORY = XKeyEvent.create(-1L);
/*     */ 
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
/* 471 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XKeyEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 475 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 479 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 484 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XKeyEvent getElementFactory() {
/* 489 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 493 */       return XKeyEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 496 */       return XKeyEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 499 */       return (XKeyEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 502 */       return XKeyEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 505 */       return XKeyEvent.nwindow(address());
/*     */     } @NativeType("Window")
/*     */     public long root() {
/* 508 */       return XKeyEvent.nroot(address());
/*     */     } @NativeType("Window")
/*     */     public long subwindow() {
/* 511 */       return XKeyEvent.nsubwindow(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 514 */       return XKeyEvent.ntime(address());
/*     */     } public int x() {
/* 516 */       return XKeyEvent.nx(address());
/*     */     } public int y() {
/* 518 */       return XKeyEvent.ny(address());
/*     */     } public int x_root() {
/* 520 */       return XKeyEvent.nx_root(address());
/*     */     } public int y_root() {
/* 522 */       return XKeyEvent.ny_root(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int state() {
/* 525 */       return XKeyEvent.nstate(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int keycode() {
/* 528 */       return XKeyEvent.nkeycode(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean same_screen() {
/* 531 */       return (XKeyEvent.nsame_screen(address()) != 0);
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 534 */       XKeyEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 536 */       XKeyEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 538 */       XKeyEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 540 */       XKeyEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 542 */       XKeyEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer root(@NativeType("Window") long param1Long) {
/* 544 */       XKeyEvent.nroot(address(), param1Long); return this;
/*     */     } public Buffer subwindow(@NativeType("Window") long param1Long) {
/* 546 */       XKeyEvent.nsubwindow(address(), param1Long); return this;
/*     */     } public Buffer time(@NativeType("Time") long param1Long) {
/* 548 */       XKeyEvent.ntime(address(), param1Long); return this;
/*     */     } public Buffer x(int param1Int) {
/* 550 */       XKeyEvent.nx(address(), param1Int); return this;
/*     */     } public Buffer y(int param1Int) {
/* 552 */       XKeyEvent.ny(address(), param1Int); return this;
/*     */     } public Buffer x_root(int param1Int) {
/* 554 */       XKeyEvent.nx_root(address(), param1Int); return this;
/*     */     } public Buffer y_root(int param1Int) {
/* 556 */       XKeyEvent.ny_root(address(), param1Int); return this;
/*     */     } public Buffer state(@NativeType("unsigned int") int param1Int) {
/* 558 */       XKeyEvent.nstate(address(), param1Int); return this;
/*     */     } public Buffer keycode(@NativeType("unsigned int") int param1Int) {
/* 560 */       XKeyEvent.nkeycode(address(), param1Int); return this;
/*     */     } public Buffer same_screen(@NativeType("Bool") boolean param1Boolean) {
/* 562 */       XKeyEvent.nsame_screen(address(), param1Boolean ? 1 : 0); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XKeyEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */