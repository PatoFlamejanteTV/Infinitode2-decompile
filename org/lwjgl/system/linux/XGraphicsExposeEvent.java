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
/*     */ public class XGraphicsExposeEvent
/*     */   extends Struct<XGraphicsExposeEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int DRAWABLE;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int COUNT;
/*     */   public static final int MAJOR_CODE;
/*     */   public static final int MINOR_CODE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  77 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4), __member(4) })).getSize();
/*  78 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  80 */     TYPE = layout.offsetof(0);
/*  81 */     SERIAL = layout.offsetof(1);
/*  82 */     SEND_EVENT = layout.offsetof(2);
/*  83 */     DISPLAY = layout.offsetof(3);
/*  84 */     DRAWABLE = layout.offsetof(4);
/*  85 */     X = layout.offsetof(5);
/*  86 */     Y = layout.offsetof(6);
/*  87 */     WIDTH = layout.offsetof(7);
/*  88 */     HEIGHT = layout.offsetof(8);
/*  89 */     COUNT = layout.offsetof(9);
/*  90 */     MAJOR_CODE = layout.offsetof(10);
/*  91 */     MINOR_CODE = layout.offsetof(11);
/*     */   }
/*     */   
/*     */   protected XGraphicsExposeEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  95 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XGraphicsExposeEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/* 100 */     return new XGraphicsExposeEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGraphicsExposeEvent(ByteBuffer paramByteBuffer) {
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
/*     */   } @NativeType("Drawable")
/*     */   public long drawable() {
/* 129 */     return ndrawable(address());
/*     */   } public int x() {
/* 131 */     return nx(address());
/*     */   } public int y() {
/* 133 */     return ny(address());
/*     */   } public int width() {
/* 135 */     return nwidth(address());
/*     */   } public int height() {
/* 137 */     return nheight(address());
/*     */   } public int count() {
/* 139 */     return ncount(address());
/*     */   } public int major_code() {
/* 141 */     return nmajor_code(address());
/*     */   } public int minor_code() {
/* 143 */     return nminor_code(address());
/*     */   }
/*     */   public XGraphicsExposeEvent type(int paramInt) {
/* 146 */     ntype(address(), paramInt); return this;
/*     */   } public XGraphicsExposeEvent serial(@NativeType("unsigned long") long paramLong) {
/* 148 */     nserial(address(), paramLong); return this;
/*     */   } public XGraphicsExposeEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 150 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XGraphicsExposeEvent display(@NativeType("Display *") long paramLong) {
/* 152 */     ndisplay(address(), paramLong); return this;
/*     */   } public XGraphicsExposeEvent drawable(@NativeType("Drawable") long paramLong) {
/* 154 */     ndrawable(address(), paramLong); return this;
/*     */   } public XGraphicsExposeEvent x(int paramInt) {
/* 156 */     nx(address(), paramInt); return this;
/*     */   } public XGraphicsExposeEvent y(int paramInt) {
/* 158 */     ny(address(), paramInt); return this;
/*     */   } public XGraphicsExposeEvent width(int paramInt) {
/* 160 */     nwidth(address(), paramInt); return this;
/*     */   } public XGraphicsExposeEvent height(int paramInt) {
/* 162 */     nheight(address(), paramInt); return this;
/*     */   } public XGraphicsExposeEvent count(int paramInt) {
/* 164 */     ncount(address(), paramInt); return this;
/*     */   } public XGraphicsExposeEvent major_code(int paramInt) {
/* 166 */     nmajor_code(address(), paramInt); return this;
/*     */   } public XGraphicsExposeEvent minor_code(int paramInt) {
/* 168 */     nminor_code(address(), paramInt); return this;
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
/*     */   public XGraphicsExposeEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
/* 185 */     type(paramInt1);
/* 186 */     serial(paramLong1);
/* 187 */     send_event(paramBoolean);
/* 188 */     display(paramLong2);
/* 189 */     drawable(paramLong3);
/* 190 */     x(paramInt2);
/* 191 */     y(paramInt3);
/* 192 */     width(paramInt4);
/* 193 */     height(paramInt5);
/* 194 */     count(paramInt6);
/* 195 */     major_code(paramInt7);
/* 196 */     minor_code(paramInt8);
/*     */     
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGraphicsExposeEvent set(XGraphicsExposeEvent paramXGraphicsExposeEvent) {
/* 209 */     MemoryUtil.memCopy(paramXGraphicsExposeEvent.address(), address(), SIZEOF);
/* 210 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent malloc() {
/* 217 */     return new XGraphicsExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent calloc() {
/* 222 */     return new XGraphicsExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent create() {
/* 227 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 228 */     return new XGraphicsExposeEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent create(long paramLong) {
/* 233 */     return new XGraphicsExposeEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent createSafe(long paramLong) {
/* 239 */     return (paramLong == 0L) ? null : new XGraphicsExposeEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 248 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 257 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 266 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 267 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 277 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 283 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XGraphicsExposeEvent mallocStack() {
/* 289 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 291 */   public static XGraphicsExposeEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 293 */   public static XGraphicsExposeEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 295 */   public static XGraphicsExposeEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 297 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 299 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 301 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 303 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent malloc(MemoryStack paramMemoryStack) {
/* 311 */     return new XGraphicsExposeEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGraphicsExposeEvent calloc(MemoryStack paramMemoryStack) {
/* 320 */     return new XGraphicsExposeEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 330 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 340 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 346 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 348 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 350 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 352 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long ndrawable(long paramLong) {
/* 354 */     return MemoryUtil.memGetCLong(paramLong + DRAWABLE);
/*     */   } public static int nx(long paramLong) {
/* 356 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 358 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static int nwidth(long paramLong) {
/* 360 */     return UNSAFE.getInt(null, paramLong + WIDTH);
/*     */   } public static int nheight(long paramLong) {
/* 362 */     return UNSAFE.getInt(null, paramLong + HEIGHT);
/*     */   } public static int ncount(long paramLong) {
/* 364 */     return UNSAFE.getInt(null, paramLong + COUNT);
/*     */   } public static int nmajor_code(long paramLong) {
/* 366 */     return UNSAFE.getInt(null, paramLong + MAJOR_CODE);
/*     */   } public static int nminor_code(long paramLong) {
/* 368 */     return UNSAFE.getInt(null, paramLong + MINOR_CODE);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 371 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 373 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 375 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 377 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void ndrawable(long paramLong1, long paramLong2) {
/* 379 */     MemoryUtil.memPutCLong(paramLong1 + DRAWABLE, paramLong2);
/*     */   } public static void nx(long paramLong, int paramInt) {
/* 381 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 383 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
/*     */   } public static void nwidth(long paramLong, int paramInt) {
/* 385 */     UNSAFE.putInt(null, paramLong + WIDTH, paramInt);
/*     */   } public static void nheight(long paramLong, int paramInt) {
/* 387 */     UNSAFE.putInt(null, paramLong + HEIGHT, paramInt);
/*     */   } public static void ncount(long paramLong, int paramInt) {
/* 389 */     UNSAFE.putInt(null, paramLong + COUNT, paramInt);
/*     */   } public static void nmajor_code(long paramLong, int paramInt) {
/* 391 */     UNSAFE.putInt(null, paramLong + MAJOR_CODE, paramInt);
/*     */   } public static void nminor_code(long paramLong, int paramInt) {
/* 393 */     UNSAFE.putInt(null, paramLong + MINOR_CODE, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 401 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XGraphicsExposeEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 409 */     private static final XGraphicsExposeEvent ELEMENT_FACTORY = XGraphicsExposeEvent.create(-1L);
/*     */ 
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
/* 421 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XGraphicsExposeEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 425 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 429 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 434 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XGraphicsExposeEvent getElementFactory() {
/* 439 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 443 */       return XGraphicsExposeEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 446 */       return XGraphicsExposeEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 449 */       return (XGraphicsExposeEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 452 */       return XGraphicsExposeEvent.ndisplay(address());
/*     */     } @NativeType("Drawable")
/*     */     public long drawable() {
/* 455 */       return XGraphicsExposeEvent.ndrawable(address());
/*     */     } public int x() {
/* 457 */       return XGraphicsExposeEvent.nx(address());
/*     */     } public int y() {
/* 459 */       return XGraphicsExposeEvent.ny(address());
/*     */     } public int width() {
/* 461 */       return XGraphicsExposeEvent.nwidth(address());
/*     */     } public int height() {
/* 463 */       return XGraphicsExposeEvent.nheight(address());
/*     */     } public int count() {
/* 465 */       return XGraphicsExposeEvent.ncount(address());
/*     */     } public int major_code() {
/* 467 */       return XGraphicsExposeEvent.nmajor_code(address());
/*     */     } public int minor_code() {
/* 469 */       return XGraphicsExposeEvent.nminor_code(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 472 */       XGraphicsExposeEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 474 */       XGraphicsExposeEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 476 */       XGraphicsExposeEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 478 */       XGraphicsExposeEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer drawable(@NativeType("Drawable") long param1Long) {
/* 480 */       XGraphicsExposeEvent.ndrawable(address(), param1Long); return this;
/*     */     } public Buffer x(int param1Int) {
/* 482 */       XGraphicsExposeEvent.nx(address(), param1Int); return this;
/*     */     } public Buffer y(int param1Int) {
/* 484 */       XGraphicsExposeEvent.ny(address(), param1Int); return this;
/*     */     } public Buffer width(int param1Int) {
/* 486 */       XGraphicsExposeEvent.nwidth(address(), param1Int); return this;
/*     */     } public Buffer height(int param1Int) {
/* 488 */       XGraphicsExposeEvent.nheight(address(), param1Int); return this;
/*     */     } public Buffer count(int param1Int) {
/* 490 */       XGraphicsExposeEvent.ncount(address(), param1Int); return this;
/*     */     } public Buffer major_code(int param1Int) {
/* 492 */       XGraphicsExposeEvent.nmajor_code(address(), param1Int); return this;
/*     */     } public Buffer minor_code(int param1Int) {
/* 494 */       XGraphicsExposeEvent.nminor_code(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XGraphicsExposeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */