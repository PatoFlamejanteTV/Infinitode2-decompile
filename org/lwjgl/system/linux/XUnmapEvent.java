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
/*     */ public class XUnmapEvent
/*     */   extends Struct<XUnmapEvent>
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
/*     */   public static final int FROM_CONFIGURE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  62 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4) })).getSize();
/*  63 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  65 */     TYPE = layout.offsetof(0);
/*  66 */     SERIAL = layout.offsetof(1);
/*  67 */     SEND_EVENT = layout.offsetof(2);
/*  68 */     DISPLAY = layout.offsetof(3);
/*  69 */     EVENT = layout.offsetof(4);
/*  70 */     WINDOW = layout.offsetof(5);
/*  71 */     FROM_CONFIGURE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XUnmapEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  75 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XUnmapEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  80 */     return new XUnmapEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XUnmapEvent(ByteBuffer paramByteBuffer) {
/*  90 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  94 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  97 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 100 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 103 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 106 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long event() {
/* 109 */     return nevent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 112 */     return nwindow(address());
/*     */   } public int from_configure() {
/* 114 */     return nfrom_configure(address());
/*     */   }
/*     */   public XUnmapEvent type(int paramInt) {
/* 117 */     ntype(address(), paramInt); return this;
/*     */   } public XUnmapEvent serial(@NativeType("unsigned long") long paramLong) {
/* 119 */     nserial(address(), paramLong); return this;
/*     */   } public XUnmapEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 121 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XUnmapEvent display(@NativeType("Display *") long paramLong) {
/* 123 */     ndisplay(address(), paramLong); return this;
/*     */   } public XUnmapEvent event(@NativeType("Window") long paramLong) {
/* 125 */     nevent(address(), paramLong); return this;
/*     */   } public XUnmapEvent window(@NativeType("Window") long paramLong) {
/* 127 */     nwindow(address(), paramLong); return this;
/*     */   } public XUnmapEvent from_configure(int paramInt) {
/* 129 */     nfrom_configure(address(), paramInt); return this;
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
/*     */   public XUnmapEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, int paramInt2) {
/* 141 */     type(paramInt1);
/* 142 */     serial(paramLong1);
/* 143 */     send_event(paramBoolean);
/* 144 */     display(paramLong2);
/* 145 */     event(paramLong3);
/* 146 */     window(paramLong4);
/* 147 */     from_configure(paramInt2);
/*     */     
/* 149 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XUnmapEvent set(XUnmapEvent paramXUnmapEvent) {
/* 160 */     MemoryUtil.memCopy(paramXUnmapEvent.address(), address(), SIZEOF);
/* 161 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XUnmapEvent malloc() {
/* 168 */     return new XUnmapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XUnmapEvent calloc() {
/* 173 */     return new XUnmapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XUnmapEvent create() {
/* 178 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 179 */     return new XUnmapEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XUnmapEvent create(long paramLong) {
/* 184 */     return new XUnmapEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XUnmapEvent createSafe(long paramLong) {
/* 190 */     return (paramLong == 0L) ? null : new XUnmapEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 199 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 208 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 217 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 218 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 228 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 234 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XUnmapEvent mallocStack() {
/* 240 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 242 */   public static XUnmapEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 244 */   public static XUnmapEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 246 */   public static XUnmapEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 248 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 250 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 252 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 254 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XUnmapEvent malloc(MemoryStack paramMemoryStack) {
/* 262 */     return new XUnmapEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XUnmapEvent calloc(MemoryStack paramMemoryStack) {
/* 271 */     return new XUnmapEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 281 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 291 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 297 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 299 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 301 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 303 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nevent(long paramLong) {
/* 305 */     return MemoryUtil.memGetCLong(paramLong + EVENT);
/*     */   } public static long nwindow(long paramLong) {
/* 307 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static int nfrom_configure(long paramLong) {
/* 309 */     return UNSAFE.getInt(null, paramLong + FROM_CONFIGURE);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 312 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 314 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 316 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 318 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nevent(long paramLong1, long paramLong2) {
/* 320 */     MemoryUtil.memPutCLong(paramLong1 + EVENT, paramLong2);
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 322 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nfrom_configure(long paramLong, int paramInt) {
/* 324 */     UNSAFE.putInt(null, paramLong + FROM_CONFIGURE, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 332 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XUnmapEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 340 */     private static final XUnmapEvent ELEMENT_FACTORY = XUnmapEvent.create(-1L);
/*     */ 
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
/* 352 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XUnmapEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 356 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 360 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 365 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XUnmapEvent getElementFactory() {
/* 370 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 374 */       return XUnmapEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 377 */       return XUnmapEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 380 */       return (XUnmapEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 383 */       return XUnmapEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long event() {
/* 386 */       return XUnmapEvent.nevent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 389 */       return XUnmapEvent.nwindow(address());
/*     */     } public int from_configure() {
/* 391 */       return XUnmapEvent.nfrom_configure(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 394 */       XUnmapEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 396 */       XUnmapEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 398 */       XUnmapEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 400 */       XUnmapEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer event(@NativeType("Window") long param1Long) {
/* 402 */       XUnmapEvent.nevent(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 404 */       XUnmapEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer from_configure(int param1Int) {
/* 406 */       XUnmapEvent.nfrom_configure(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XUnmapEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */