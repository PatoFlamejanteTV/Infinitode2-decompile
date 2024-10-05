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
/*     */ public class XConfigureEvent
/*     */   extends Struct<XConfigureEvent>
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
/*     */   public static final int BORDER_WIDTH;
/*     */   public static final int ABOVE;
/*     */   public static final int OVERRIDE_REDIRECT;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  79 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4), __member(4), __member(4), __member(CLONG_SIZE), __member(4) })).getSize();
/*  80 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  82 */     TYPE = layout.offsetof(0);
/*  83 */     SERIAL = layout.offsetof(1);
/*  84 */     SEND_EVENT = layout.offsetof(2);
/*  85 */     DISPLAY = layout.offsetof(3);
/*  86 */     WINDOW = layout.offsetof(4);
/*  87 */     X = layout.offsetof(5);
/*  88 */     Y = layout.offsetof(6);
/*  89 */     WIDTH = layout.offsetof(7);
/*  90 */     HEIGHT = layout.offsetof(8);
/*  91 */     BORDER_WIDTH = layout.offsetof(9);
/*  92 */     ABOVE = layout.offsetof(10);
/*  93 */     OVERRIDE_REDIRECT = layout.offsetof(11);
/*     */   }
/*     */   
/*     */   protected XConfigureEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  97 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XConfigureEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/* 102 */     return new XConfigureEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XConfigureEvent(ByteBuffer paramByteBuffer) {
/* 112 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 116 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 119 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 122 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 125 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 128 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 131 */     return nwindow(address());
/*     */   } public int x() {
/* 133 */     return nx(address());
/*     */   } public int y() {
/* 135 */     return ny(address());
/*     */   } public int width() {
/* 137 */     return nwidth(address());
/*     */   } public int height() {
/* 139 */     return nheight(address());
/*     */   } public int border_width() {
/* 141 */     return nborder_width(address());
/*     */   } @NativeType("Window")
/*     */   public long above() {
/* 144 */     return nabove(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean override_redirect() {
/* 147 */     return (noverride_redirect(address()) != 0);
/*     */   }
/*     */   public XConfigureEvent type(int paramInt) {
/* 150 */     ntype(address(), paramInt); return this;
/*     */   } public XConfigureEvent serial(@NativeType("unsigned long") long paramLong) {
/* 152 */     nserial(address(), paramLong); return this;
/*     */   } public XConfigureEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 154 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XConfigureEvent display(@NativeType("Display *") long paramLong) {
/* 156 */     ndisplay(address(), paramLong); return this;
/*     */   } public XConfigureEvent window(@NativeType("Window") long paramLong) {
/* 158 */     nwindow(address(), paramLong); return this;
/*     */   } public XConfigureEvent x(int paramInt) {
/* 160 */     nx(address(), paramInt); return this;
/*     */   } public XConfigureEvent y(int paramInt) {
/* 162 */     ny(address(), paramInt); return this;
/*     */   } public XConfigureEvent width(int paramInt) {
/* 164 */     nwidth(address(), paramInt); return this;
/*     */   } public XConfigureEvent height(int paramInt) {
/* 166 */     nheight(address(), paramInt); return this;
/*     */   } public XConfigureEvent border_width(int paramInt) {
/* 168 */     nborder_width(address(), paramInt); return this;
/*     */   } public XConfigureEvent above(@NativeType("Window") long paramLong) {
/* 170 */     nabove(address(), paramLong); return this;
/*     */   } public XConfigureEvent override_redirect(@NativeType("Bool") boolean paramBoolean) {
/* 172 */     noverride_redirect(address(), paramBoolean ? 1 : 0); return this;
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
/*     */   public XConfigureEvent set(int paramInt1, long paramLong1, boolean paramBoolean1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong4, boolean paramBoolean2) {
/* 189 */     type(paramInt1);
/* 190 */     serial(paramLong1);
/* 191 */     send_event(paramBoolean1);
/* 192 */     display(paramLong2);
/* 193 */     window(paramLong3);
/* 194 */     x(paramInt2);
/* 195 */     y(paramInt3);
/* 196 */     width(paramInt4);
/* 197 */     height(paramInt5);
/* 198 */     border_width(paramInt6);
/* 199 */     above(paramLong4);
/* 200 */     override_redirect(paramBoolean2);
/*     */     
/* 202 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XConfigureEvent set(XConfigureEvent paramXConfigureEvent) {
/* 213 */     MemoryUtil.memCopy(paramXConfigureEvent.address(), address(), SIZEOF);
/* 214 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureEvent malloc() {
/* 221 */     return new XConfigureEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureEvent calloc() {
/* 226 */     return new XConfigureEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureEvent create() {
/* 231 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 232 */     return new XConfigureEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XConfigureEvent create(long paramLong) {
/* 237 */     return new XConfigureEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureEvent createSafe(long paramLong) {
/* 243 */     return (paramLong == 0L) ? null : new XConfigureEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 252 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 261 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 270 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 271 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 281 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 287 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XConfigureEvent mallocStack() {
/* 293 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 295 */   public static XConfigureEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 297 */   public static XConfigureEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 299 */   public static XConfigureEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 301 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 303 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 305 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 307 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureEvent malloc(MemoryStack paramMemoryStack) {
/* 315 */     return new XConfigureEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XConfigureEvent calloc(MemoryStack paramMemoryStack) {
/* 324 */     return new XConfigureEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 334 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 344 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 350 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 352 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 354 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 356 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 358 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static int nx(long paramLong) {
/* 360 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 362 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static int nwidth(long paramLong) {
/* 364 */     return UNSAFE.getInt(null, paramLong + WIDTH);
/*     */   } public static int nheight(long paramLong) {
/* 366 */     return UNSAFE.getInt(null, paramLong + HEIGHT);
/*     */   } public static int nborder_width(long paramLong) {
/* 368 */     return UNSAFE.getInt(null, paramLong + BORDER_WIDTH);
/*     */   } public static long nabove(long paramLong) {
/* 370 */     return MemoryUtil.memGetCLong(paramLong + ABOVE);
/*     */   } public static int noverride_redirect(long paramLong) {
/* 372 */     return UNSAFE.getInt(null, paramLong + OVERRIDE_REDIRECT);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 375 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 377 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 379 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 381 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 383 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nx(long paramLong, int paramInt) {
/* 385 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 387 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
/*     */   } public static void nwidth(long paramLong, int paramInt) {
/* 389 */     UNSAFE.putInt(null, paramLong + WIDTH, paramInt);
/*     */   } public static void nheight(long paramLong, int paramInt) {
/* 391 */     UNSAFE.putInt(null, paramLong + HEIGHT, paramInt);
/*     */   } public static void nborder_width(long paramLong, int paramInt) {
/* 393 */     UNSAFE.putInt(null, paramLong + BORDER_WIDTH, paramInt);
/*     */   } public static void nabove(long paramLong1, long paramLong2) {
/* 395 */     MemoryUtil.memPutCLong(paramLong1 + ABOVE, paramLong2);
/*     */   } public static void noverride_redirect(long paramLong, int paramInt) {
/* 397 */     UNSAFE.putInt(null, paramLong + OVERRIDE_REDIRECT, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 405 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XConfigureEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 413 */     private static final XConfigureEvent ELEMENT_FACTORY = XConfigureEvent.create(-1L);
/*     */ 
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
/* 425 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XConfigureEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 429 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 433 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 438 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XConfigureEvent getElementFactory() {
/* 443 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 447 */       return XConfigureEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 450 */       return XConfigureEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 453 */       return (XConfigureEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 456 */       return XConfigureEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 459 */       return XConfigureEvent.nwindow(address());
/*     */     } public int x() {
/* 461 */       return XConfigureEvent.nx(address());
/*     */     } public int y() {
/* 463 */       return XConfigureEvent.ny(address());
/*     */     } public int width() {
/* 465 */       return XConfigureEvent.nwidth(address());
/*     */     } public int height() {
/* 467 */       return XConfigureEvent.nheight(address());
/*     */     } public int border_width() {
/* 469 */       return XConfigureEvent.nborder_width(address());
/*     */     } @NativeType("Window")
/*     */     public long above() {
/* 472 */       return XConfigureEvent.nabove(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean override_redirect() {
/* 475 */       return (XConfigureEvent.noverride_redirect(address()) != 0);
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 478 */       XConfigureEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 480 */       XConfigureEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 482 */       XConfigureEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 484 */       XConfigureEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 486 */       XConfigureEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer x(int param1Int) {
/* 488 */       XConfigureEvent.nx(address(), param1Int); return this;
/*     */     } public Buffer y(int param1Int) {
/* 490 */       XConfigureEvent.ny(address(), param1Int); return this;
/*     */     } public Buffer width(int param1Int) {
/* 492 */       XConfigureEvent.nwidth(address(), param1Int); return this;
/*     */     } public Buffer height(int param1Int) {
/* 494 */       XConfigureEvent.nheight(address(), param1Int); return this;
/*     */     } public Buffer border_width(int param1Int) {
/* 496 */       XConfigureEvent.nborder_width(address(), param1Int); return this;
/*     */     } public Buffer above(@NativeType("Window") long param1Long) {
/* 498 */       XConfigureEvent.nabove(address(), param1Long); return this;
/*     */     } public Buffer override_redirect(@NativeType("Bool") boolean param1Boolean) {
/* 500 */       XConfigureEvent.noverride_redirect(address(), param1Boolean ? 1 : 0); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XConfigureEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */