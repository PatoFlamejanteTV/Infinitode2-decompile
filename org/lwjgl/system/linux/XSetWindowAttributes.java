/*     */ package org.lwjgl.system.linux;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
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
/*     */ public class XSetWindowAttributes
/*     */   extends Struct<XSetWindowAttributes>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int BACKGROUND_PIXMAP;
/*     */   public static final int BACKGROUND_PIXEL;
/*     */   public static final int BORDER_PIXMAP;
/*     */   public static final int BORDER_PIXEL;
/*     */   public static final int BIT_GRAVITY;
/*     */   public static final int WIN_GRAVITY;
/*     */   public static final int BACKING_STORE;
/*     */   public static final int BACKING_PLANES;
/*     */   public static final int BACKING_PIXEL;
/*     */   public static final int SAVE_UNDER;
/*     */   public static final int EVENT_MASK;
/*     */   public static final int DO_NOT_PROPAGATE_MASK;
/*     */   public static final int OVERRIDE_REDIRECT;
/*     */   public static final int COLORMAP;
/*     */   public static final int CURSOR;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  87 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(CLONG_SIZE), __member(CLONG_SIZE) })).getSize();
/*  88 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  90 */     BACKGROUND_PIXMAP = layout.offsetof(0);
/*  91 */     BACKGROUND_PIXEL = layout.offsetof(1);
/*  92 */     BORDER_PIXMAP = layout.offsetof(2);
/*  93 */     BORDER_PIXEL = layout.offsetof(3);
/*  94 */     BIT_GRAVITY = layout.offsetof(4);
/*  95 */     WIN_GRAVITY = layout.offsetof(5);
/*  96 */     BACKING_STORE = layout.offsetof(6);
/*  97 */     BACKING_PLANES = layout.offsetof(7);
/*  98 */     BACKING_PIXEL = layout.offsetof(8);
/*  99 */     SAVE_UNDER = layout.offsetof(9);
/* 100 */     EVENT_MASK = layout.offsetof(10);
/* 101 */     DO_NOT_PROPAGATE_MASK = layout.offsetof(11);
/* 102 */     OVERRIDE_REDIRECT = layout.offsetof(12);
/* 103 */     COLORMAP = layout.offsetof(13);
/* 104 */     CURSOR = layout.offsetof(14);
/*     */   }
/*     */   
/*     */   protected XSetWindowAttributes(long paramLong, ByteBuffer paramByteBuffer) {
/* 108 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XSetWindowAttributes create(long paramLong, ByteBuffer paramByteBuffer) {
/* 113 */     return new XSetWindowAttributes(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSetWindowAttributes(ByteBuffer paramByteBuffer) {
/* 123 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 127 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("Pixmap")
/*     */   public long background_pixmap() {
/* 131 */     return nbackground_pixmap(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long background_pixel() {
/* 134 */     return nbackground_pixel(address());
/*     */   } @NativeType("Pixmap")
/*     */   public long border_pixmap() {
/* 137 */     return nborder_pixmap(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long border_pixel() {
/* 140 */     return nborder_pixel(address());
/*     */   } public int bit_gravity() {
/* 142 */     return nbit_gravity(address());
/*     */   } public int win_gravity() {
/* 144 */     return nwin_gravity(address());
/*     */   } public int backing_store() {
/* 146 */     return nbacking_store(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long backing_planes() {
/* 149 */     return nbacking_planes(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long backing_pixel() {
/* 152 */     return nbacking_pixel(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean save_under() {
/* 155 */     return (nsave_under(address()) != 0);
/*     */   } public long event_mask() {
/* 157 */     return nevent_mask(address());
/*     */   } public long do_not_propagate_mask() {
/* 159 */     return ndo_not_propagate_mask(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean override_redirect() {
/* 162 */     return (noverride_redirect(address()) != 0);
/*     */   } @NativeType("Colormap")
/*     */   public long colormap() {
/* 165 */     return ncolormap(address());
/*     */   } @NativeType("Cursor")
/*     */   public long cursor() {
/* 168 */     return ncursor(address());
/*     */   }
/*     */   public XSetWindowAttributes background_pixmap(@NativeType("Pixmap") long paramLong) {
/* 171 */     nbackground_pixmap(address(), paramLong); return this;
/*     */   } public XSetWindowAttributes background_pixel(@NativeType("unsigned long") long paramLong) {
/* 173 */     nbackground_pixel(address(), paramLong); return this;
/*     */   } public XSetWindowAttributes border_pixmap(@NativeType("Pixmap") long paramLong) {
/* 175 */     nborder_pixmap(address(), paramLong); return this;
/*     */   } public XSetWindowAttributes border_pixel(@NativeType("unsigned long") long paramLong) {
/* 177 */     nborder_pixel(address(), paramLong); return this;
/*     */   } public XSetWindowAttributes bit_gravity(int paramInt) {
/* 179 */     nbit_gravity(address(), paramInt); return this;
/*     */   } public XSetWindowAttributes win_gravity(int paramInt) {
/* 181 */     nwin_gravity(address(), paramInt); return this;
/*     */   } public XSetWindowAttributes backing_store(int paramInt) {
/* 183 */     nbacking_store(address(), paramInt); return this;
/*     */   } public XSetWindowAttributes backing_planes(@NativeType("unsigned long") long paramLong) {
/* 185 */     nbacking_planes(address(), paramLong); return this;
/*     */   } public XSetWindowAttributes backing_pixel(@NativeType("unsigned long") long paramLong) {
/* 187 */     nbacking_pixel(address(), paramLong); return this;
/*     */   } public XSetWindowAttributes save_under(@NativeType("Bool") boolean paramBoolean) {
/* 189 */     nsave_under(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XSetWindowAttributes event_mask(long paramLong) {
/* 191 */     nevent_mask(address(), paramLong); return this;
/*     */   } public XSetWindowAttributes do_not_propagate_mask(long paramLong) {
/* 193 */     ndo_not_propagate_mask(address(), paramLong); return this;
/*     */   } public XSetWindowAttributes override_redirect(@NativeType("Bool") boolean paramBoolean) {
/* 195 */     noverride_redirect(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XSetWindowAttributes colormap(@NativeType("Colormap") long paramLong) {
/* 197 */     ncolormap(address(), paramLong); return this;
/*     */   } public XSetWindowAttributes cursor(@NativeType("Cursor") long paramLong) {
/* 199 */     ncursor(address(), paramLong); return this;
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
/*     */   public XSetWindowAttributes set(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, int paramInt3, long paramLong5, long paramLong6, boolean paramBoolean1, long paramLong7, long paramLong8, boolean paramBoolean2, long paramLong9, long paramLong10) {
/* 219 */     background_pixmap(paramLong1);
/* 220 */     background_pixel(paramLong2);
/* 221 */     border_pixmap(paramLong3);
/* 222 */     border_pixel(paramLong4);
/* 223 */     bit_gravity(paramInt1);
/* 224 */     win_gravity(paramInt2);
/* 225 */     backing_store(paramInt3);
/* 226 */     backing_planes(paramLong5);
/* 227 */     backing_pixel(paramLong6);
/* 228 */     save_under(paramBoolean1);
/* 229 */     event_mask(paramLong7);
/* 230 */     do_not_propagate_mask(paramLong8);
/* 231 */     override_redirect(paramBoolean2);
/* 232 */     colormap(paramLong9);
/* 233 */     cursor(paramLong10);
/*     */     
/* 235 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSetWindowAttributes set(XSetWindowAttributes paramXSetWindowAttributes) {
/* 246 */     MemoryUtil.memCopy(paramXSetWindowAttributes.address(), address(), SIZEOF);
/* 247 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes malloc() {
/* 254 */     return new XSetWindowAttributes(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes calloc() {
/* 259 */     return new XSetWindowAttributes(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes create() {
/* 264 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 265 */     return new XSetWindowAttributes(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes create(long paramLong) {
/* 270 */     return new XSetWindowAttributes(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes createSafe(long paramLong) {
/* 276 */     return (paramLong == 0L) ? null : new XSetWindowAttributes(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 285 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 294 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 303 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 304 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 314 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 320 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XSetWindowAttributes mallocStack() {
/* 326 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 328 */   public static XSetWindowAttributes callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 330 */   public static XSetWindowAttributes mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 332 */   public static XSetWindowAttributes callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 334 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 336 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 338 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 340 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes malloc(MemoryStack paramMemoryStack) {
/* 348 */     return new XSetWindowAttributes(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSetWindowAttributes calloc(MemoryStack paramMemoryStack) {
/* 357 */     return new XSetWindowAttributes(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 367 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 377 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nbackground_pixmap(long paramLong) {
/* 383 */     return MemoryUtil.memGetCLong(paramLong + BACKGROUND_PIXMAP);
/*     */   } public static long nbackground_pixel(long paramLong) {
/* 385 */     return MemoryUtil.memGetCLong(paramLong + BACKGROUND_PIXEL);
/*     */   } public static long nborder_pixmap(long paramLong) {
/* 387 */     return MemoryUtil.memGetCLong(paramLong + BORDER_PIXMAP);
/*     */   } public static long nborder_pixel(long paramLong) {
/* 389 */     return MemoryUtil.memGetCLong(paramLong + BORDER_PIXEL);
/*     */   } public static int nbit_gravity(long paramLong) {
/* 391 */     return UNSAFE.getInt(null, paramLong + BIT_GRAVITY);
/*     */   } public static int nwin_gravity(long paramLong) {
/* 393 */     return UNSAFE.getInt(null, paramLong + WIN_GRAVITY);
/*     */   } public static int nbacking_store(long paramLong) {
/* 395 */     return UNSAFE.getInt(null, paramLong + BACKING_STORE);
/*     */   } public static long nbacking_planes(long paramLong) {
/* 397 */     return MemoryUtil.memGetCLong(paramLong + BACKING_PLANES);
/*     */   } public static long nbacking_pixel(long paramLong) {
/* 399 */     return MemoryUtil.memGetCLong(paramLong + BACKING_PIXEL);
/*     */   } public static int nsave_under(long paramLong) {
/* 401 */     return UNSAFE.getInt(null, paramLong + SAVE_UNDER);
/*     */   } public static long nevent_mask(long paramLong) {
/* 403 */     return MemoryUtil.memGetCLong(paramLong + EVENT_MASK);
/*     */   } public static long ndo_not_propagate_mask(long paramLong) {
/* 405 */     return MemoryUtil.memGetCLong(paramLong + DO_NOT_PROPAGATE_MASK);
/*     */   } public static int noverride_redirect(long paramLong) {
/* 407 */     return UNSAFE.getInt(null, paramLong + OVERRIDE_REDIRECT);
/*     */   } public static long ncolormap(long paramLong) {
/* 409 */     return MemoryUtil.memGetCLong(paramLong + COLORMAP);
/*     */   } public static long ncursor(long paramLong) {
/* 411 */     return MemoryUtil.memGetCLong(paramLong + CURSOR);
/*     */   }
/*     */   public static void nbackground_pixmap(long paramLong1, long paramLong2) {
/* 414 */     MemoryUtil.memPutCLong(paramLong1 + BACKGROUND_PIXMAP, paramLong2);
/*     */   } public static void nbackground_pixel(long paramLong1, long paramLong2) {
/* 416 */     MemoryUtil.memPutCLong(paramLong1 + BACKGROUND_PIXEL, paramLong2);
/*     */   } public static void nborder_pixmap(long paramLong1, long paramLong2) {
/* 418 */     MemoryUtil.memPutCLong(paramLong1 + BORDER_PIXMAP, paramLong2);
/*     */   } public static void nborder_pixel(long paramLong1, long paramLong2) {
/* 420 */     MemoryUtil.memPutCLong(paramLong1 + BORDER_PIXEL, paramLong2);
/*     */   } public static void nbit_gravity(long paramLong, int paramInt) {
/* 422 */     UNSAFE.putInt(null, paramLong + BIT_GRAVITY, paramInt);
/*     */   } public static void nwin_gravity(long paramLong, int paramInt) {
/* 424 */     UNSAFE.putInt(null, paramLong + WIN_GRAVITY, paramInt);
/*     */   } public static void nbacking_store(long paramLong, int paramInt) {
/* 426 */     UNSAFE.putInt(null, paramLong + BACKING_STORE, paramInt);
/*     */   } public static void nbacking_planes(long paramLong1, long paramLong2) {
/* 428 */     MemoryUtil.memPutCLong(paramLong1 + BACKING_PLANES, paramLong2);
/*     */   } public static void nbacking_pixel(long paramLong1, long paramLong2) {
/* 430 */     MemoryUtil.memPutCLong(paramLong1 + BACKING_PIXEL, paramLong2);
/*     */   } public static void nsave_under(long paramLong, int paramInt) {
/* 432 */     UNSAFE.putInt(null, paramLong + SAVE_UNDER, paramInt);
/*     */   } public static void nevent_mask(long paramLong1, long paramLong2) {
/* 434 */     MemoryUtil.memPutCLong(paramLong1 + EVENT_MASK, paramLong2);
/*     */   } public static void ndo_not_propagate_mask(long paramLong1, long paramLong2) {
/* 436 */     MemoryUtil.memPutCLong(paramLong1 + DO_NOT_PROPAGATE_MASK, paramLong2);
/*     */   } public static void noverride_redirect(long paramLong, int paramInt) {
/* 438 */     UNSAFE.putInt(null, paramLong + OVERRIDE_REDIRECT, paramInt);
/*     */   } public static void ncolormap(long paramLong1, long paramLong2) {
/* 440 */     MemoryUtil.memPutCLong(paramLong1 + COLORMAP, paramLong2);
/*     */   } public static void ncursor(long paramLong1, long paramLong2) {
/* 442 */     MemoryUtil.memPutCLong(paramLong1 + CURSOR, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XSetWindowAttributes, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 449 */     private static final XSetWindowAttributes ELEMENT_FACTORY = XSetWindowAttributes.create(-1L);
/*     */ 
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
/* 461 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XSetWindowAttributes.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 465 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 469 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 474 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XSetWindowAttributes getElementFactory() {
/* 479 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("Pixmap")
/*     */     public long background_pixmap() {
/* 484 */       return XSetWindowAttributes.nbackground_pixmap(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long background_pixel() {
/* 487 */       return XSetWindowAttributes.nbackground_pixel(address());
/*     */     } @NativeType("Pixmap")
/*     */     public long border_pixmap() {
/* 490 */       return XSetWindowAttributes.nborder_pixmap(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long border_pixel() {
/* 493 */       return XSetWindowAttributes.nborder_pixel(address());
/*     */     } public int bit_gravity() {
/* 495 */       return XSetWindowAttributes.nbit_gravity(address());
/*     */     } public int win_gravity() {
/* 497 */       return XSetWindowAttributes.nwin_gravity(address());
/*     */     } public int backing_store() {
/* 499 */       return XSetWindowAttributes.nbacking_store(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long backing_planes() {
/* 502 */       return XSetWindowAttributes.nbacking_planes(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long backing_pixel() {
/* 505 */       return XSetWindowAttributes.nbacking_pixel(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean save_under() {
/* 508 */       return (XSetWindowAttributes.nsave_under(address()) != 0);
/*     */     } public long event_mask() {
/* 510 */       return XSetWindowAttributes.nevent_mask(address());
/*     */     } public long do_not_propagate_mask() {
/* 512 */       return XSetWindowAttributes.ndo_not_propagate_mask(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean override_redirect() {
/* 515 */       return (XSetWindowAttributes.noverride_redirect(address()) != 0);
/*     */     } @NativeType("Colormap")
/*     */     public long colormap() {
/* 518 */       return XSetWindowAttributes.ncolormap(address());
/*     */     } @NativeType("Cursor")
/*     */     public long cursor() {
/* 521 */       return XSetWindowAttributes.ncursor(address());
/*     */     }
/*     */     public Buffer background_pixmap(@NativeType("Pixmap") long param1Long) {
/* 524 */       XSetWindowAttributes.nbackground_pixmap(address(), param1Long); return this;
/*     */     } public Buffer background_pixel(@NativeType("unsigned long") long param1Long) {
/* 526 */       XSetWindowAttributes.nbackground_pixel(address(), param1Long); return this;
/*     */     } public Buffer border_pixmap(@NativeType("Pixmap") long param1Long) {
/* 528 */       XSetWindowAttributes.nborder_pixmap(address(), param1Long); return this;
/*     */     } public Buffer border_pixel(@NativeType("unsigned long") long param1Long) {
/* 530 */       XSetWindowAttributes.nborder_pixel(address(), param1Long); return this;
/*     */     } public Buffer bit_gravity(int param1Int) {
/* 532 */       XSetWindowAttributes.nbit_gravity(address(), param1Int); return this;
/*     */     } public Buffer win_gravity(int param1Int) {
/* 534 */       XSetWindowAttributes.nwin_gravity(address(), param1Int); return this;
/*     */     } public Buffer backing_store(int param1Int) {
/* 536 */       XSetWindowAttributes.nbacking_store(address(), param1Int); return this;
/*     */     } public Buffer backing_planes(@NativeType("unsigned long") long param1Long) {
/* 538 */       XSetWindowAttributes.nbacking_planes(address(), param1Long); return this;
/*     */     } public Buffer backing_pixel(@NativeType("unsigned long") long param1Long) {
/* 540 */       XSetWindowAttributes.nbacking_pixel(address(), param1Long); return this;
/*     */     } public Buffer save_under(@NativeType("Bool") boolean param1Boolean) {
/* 542 */       XSetWindowAttributes.nsave_under(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer event_mask(long param1Long) {
/* 544 */       XSetWindowAttributes.nevent_mask(address(), param1Long); return this;
/*     */     } public Buffer do_not_propagate_mask(long param1Long) {
/* 546 */       XSetWindowAttributes.ndo_not_propagate_mask(address(), param1Long); return this;
/*     */     } public Buffer override_redirect(@NativeType("Bool") boolean param1Boolean) {
/* 548 */       XSetWindowAttributes.noverride_redirect(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer colormap(@NativeType("Colormap") long param1Long) {
/* 550 */       XSetWindowAttributes.ncolormap(address(), param1Long); return this;
/*     */     } public Buffer cursor(@NativeType("Cursor") long param1Long) {
/* 552 */       XSetWindowAttributes.ncursor(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XSetWindowAttributes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */