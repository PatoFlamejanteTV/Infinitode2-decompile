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
/*     */ public class XReparentEvent
/*     */   extends Struct<XReparentEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int EVENT;
/*     */   public static final int WINDOW;
/*     */   public static final int PARENT;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int OVERRIDE_REDIRECT;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  71 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(4), __member(4) })).getSize();
/*  72 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  74 */     TYPE = layout.offsetof(0);
/*  75 */     SERIAL = layout.offsetof(1);
/*  76 */     SEND_EVENT = layout.offsetof(2);
/*  77 */     DISPLAY = layout.offsetof(3);
/*  78 */     EVENT = layout.offsetof(4);
/*  79 */     WINDOW = layout.offsetof(5);
/*  80 */     PARENT = layout.offsetof(6);
/*  81 */     X = layout.offsetof(7);
/*  82 */     Y = layout.offsetof(8);
/*  83 */     OVERRIDE_REDIRECT = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected XReparentEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  87 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XReparentEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  92 */     return new XReparentEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XReparentEvent(ByteBuffer paramByteBuffer) {
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
/*     */   public long event() {
/* 121 */     return nevent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 124 */     return nwindow(address());
/*     */   } @NativeType("Window")
/*     */   public long parent() {
/* 127 */     return nparent(address());
/*     */   } public int x() {
/* 129 */     return nx(address());
/*     */   } public int y() {
/* 131 */     return ny(address());
/*     */   } public int override_redirect() {
/* 133 */     return noverride_redirect(address());
/*     */   }
/*     */   public XReparentEvent type(int paramInt) {
/* 136 */     ntype(address(), paramInt); return this;
/*     */   } public XReparentEvent serial(@NativeType("unsigned long") long paramLong) {
/* 138 */     nserial(address(), paramLong); return this;
/*     */   } public XReparentEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 140 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XReparentEvent display(@NativeType("Display *") long paramLong) {
/* 142 */     ndisplay(address(), paramLong); return this;
/*     */   } public XReparentEvent event(@NativeType("Window") long paramLong) {
/* 144 */     nevent(address(), paramLong); return this;
/*     */   } public XReparentEvent window(@NativeType("Window") long paramLong) {
/* 146 */     nwindow(address(), paramLong); return this;
/*     */   } public XReparentEvent parent(@NativeType("Window") long paramLong) {
/* 148 */     nparent(address(), paramLong); return this;
/*     */   } public XReparentEvent x(int paramInt) {
/* 150 */     nx(address(), paramInt); return this;
/*     */   } public XReparentEvent y(int paramInt) {
/* 152 */     ny(address(), paramInt); return this;
/*     */   } public XReparentEvent override_redirect(int paramInt) {
/* 154 */     noverride_redirect(address(), paramInt); return this;
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
/*     */   public XReparentEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, int paramInt3, int paramInt4) {
/* 169 */     type(paramInt1);
/* 170 */     serial(paramLong1);
/* 171 */     send_event(paramBoolean);
/* 172 */     display(paramLong2);
/* 173 */     event(paramLong3);
/* 174 */     window(paramLong4);
/* 175 */     parent(paramLong5);
/* 176 */     x(paramInt2);
/* 177 */     y(paramInt3);
/* 178 */     override_redirect(paramInt4);
/*     */     
/* 180 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XReparentEvent set(XReparentEvent paramXReparentEvent) {
/* 191 */     MemoryUtil.memCopy(paramXReparentEvent.address(), address(), SIZEOF);
/* 192 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XReparentEvent malloc() {
/* 199 */     return new XReparentEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XReparentEvent calloc() {
/* 204 */     return new XReparentEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XReparentEvent create() {
/* 209 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 210 */     return new XReparentEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XReparentEvent create(long paramLong) {
/* 215 */     return new XReparentEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XReparentEvent createSafe(long paramLong) {
/* 221 */     return (paramLong == 0L) ? null : new XReparentEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 230 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 239 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 248 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 249 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 259 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 265 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XReparentEvent mallocStack() {
/* 271 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 273 */   public static XReparentEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 275 */   public static XReparentEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 277 */   public static XReparentEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 279 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 281 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 283 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 285 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XReparentEvent malloc(MemoryStack paramMemoryStack) {
/* 293 */     return new XReparentEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XReparentEvent calloc(MemoryStack paramMemoryStack) {
/* 302 */     return new XReparentEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 312 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 322 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 328 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 330 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 332 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 334 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nevent(long paramLong) {
/* 336 */     return MemoryUtil.memGetCLong(paramLong + EVENT);
/*     */   } public static long nwindow(long paramLong) {
/* 338 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static long nparent(long paramLong) {
/* 340 */     return MemoryUtil.memGetCLong(paramLong + PARENT);
/*     */   } public static int nx(long paramLong) {
/* 342 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 344 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static int noverride_redirect(long paramLong) {
/* 346 */     return UNSAFE.getInt(null, paramLong + OVERRIDE_REDIRECT);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 349 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 351 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 353 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 355 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nevent(long paramLong1, long paramLong2) {
/* 357 */     MemoryUtil.memPutCLong(paramLong1 + EVENT, paramLong2);
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 359 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nparent(long paramLong1, long paramLong2) {
/* 361 */     MemoryUtil.memPutCLong(paramLong1 + PARENT, paramLong2);
/*     */   } public static void nx(long paramLong, int paramInt) {
/* 363 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 365 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
/*     */   } public static void noverride_redirect(long paramLong, int paramInt) {
/* 367 */     UNSAFE.putInt(null, paramLong + OVERRIDE_REDIRECT, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 375 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XReparentEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 383 */     private static final XReparentEvent ELEMENT_FACTORY = XReparentEvent.create(-1L);
/*     */ 
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
/* 395 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XReparentEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 399 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 403 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 408 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XReparentEvent getElementFactory() {
/* 413 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 417 */       return XReparentEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 420 */       return XReparentEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 423 */       return (XReparentEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 426 */       return XReparentEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long event() {
/* 429 */       return XReparentEvent.nevent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 432 */       return XReparentEvent.nwindow(address());
/*     */     } @NativeType("Window")
/*     */     public long parent() {
/* 435 */       return XReparentEvent.nparent(address());
/*     */     } public int x() {
/* 437 */       return XReparentEvent.nx(address());
/*     */     } public int y() {
/* 439 */       return XReparentEvent.ny(address());
/*     */     } public int override_redirect() {
/* 441 */       return XReparentEvent.noverride_redirect(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 444 */       XReparentEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 446 */       XReparentEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 448 */       XReparentEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 450 */       XReparentEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer event(@NativeType("Window") long param1Long) {
/* 452 */       XReparentEvent.nevent(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 454 */       XReparentEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer parent(@NativeType("Window") long param1Long) {
/* 456 */       XReparentEvent.nparent(address(), param1Long); return this;
/*     */     } public Buffer x(int param1Int) {
/* 458 */       XReparentEvent.nx(address(), param1Int); return this;
/*     */     } public Buffer y(int param1Int) {
/* 460 */       XReparentEvent.ny(address(), param1Int); return this;
/*     */     } public Buffer override_redirect(int param1Int) {
/* 462 */       XReparentEvent.noverride_redirect(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XReparentEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */