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
/*     */ public class XColormapEvent
/*     */   extends Struct<XColormapEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int COLORMAP;
/*     */   public static final int NEW;
/*     */   public static final int STATE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  65 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4), __member(4) })).getSize();
/*  66 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  68 */     TYPE = layout.offsetof(0);
/*  69 */     SERIAL = layout.offsetof(1);
/*  70 */     SEND_EVENT = layout.offsetof(2);
/*  71 */     DISPLAY = layout.offsetof(3);
/*  72 */     WINDOW = layout.offsetof(4);
/*  73 */     COLORMAP = layout.offsetof(5);
/*  74 */     NEW = layout.offsetof(6);
/*  75 */     STATE = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected XColormapEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  79 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XColormapEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  84 */     return new XColormapEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XColormapEvent(ByteBuffer paramByteBuffer) {
/*  94 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  98 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 101 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 104 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 107 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 110 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 113 */     return nwindow(address());
/*     */   } @NativeType("Colormap")
/*     */   public long colormap() {
/* 116 */     return ncolormap(address());
/*     */   } public int new$() {
/* 118 */     return nnew$(address());
/*     */   } public int state() {
/* 120 */     return nstate(address());
/*     */   }
/*     */   public XColormapEvent type(int paramInt) {
/* 123 */     ntype(address(), paramInt); return this;
/*     */   } public XColormapEvent serial(@NativeType("unsigned long") long paramLong) {
/* 125 */     nserial(address(), paramLong); return this;
/*     */   } public XColormapEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 127 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XColormapEvent display(@NativeType("Display *") long paramLong) {
/* 129 */     ndisplay(address(), paramLong); return this;
/*     */   } public XColormapEvent window(@NativeType("Window") long paramLong) {
/* 131 */     nwindow(address(), paramLong); return this;
/*     */   } public XColormapEvent colormap(@NativeType("Colormap") long paramLong) {
/* 133 */     ncolormap(address(), paramLong); return this;
/*     */   } public XColormapEvent new$(int paramInt) {
/* 135 */     nnew$(address(), paramInt); return this;
/*     */   } public XColormapEvent state(int paramInt) {
/* 137 */     nstate(address(), paramInt); return this;
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
/*     */   public XColormapEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, int paramInt2, int paramInt3) {
/* 150 */     type(paramInt1);
/* 151 */     serial(paramLong1);
/* 152 */     send_event(paramBoolean);
/* 153 */     display(paramLong2);
/* 154 */     window(paramLong3);
/* 155 */     colormap(paramLong4);
/* 156 */     new$(paramInt2);
/* 157 */     state(paramInt3);
/*     */     
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XColormapEvent set(XColormapEvent paramXColormapEvent) {
/* 170 */     MemoryUtil.memCopy(paramXColormapEvent.address(), address(), SIZEOF);
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XColormapEvent malloc() {
/* 178 */     return new XColormapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XColormapEvent calloc() {
/* 183 */     return new XColormapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XColormapEvent create() {
/* 188 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 189 */     return new XColormapEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XColormapEvent create(long paramLong) {
/* 194 */     return new XColormapEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XColormapEvent createSafe(long paramLong) {
/* 200 */     return (paramLong == 0L) ? null : new XColormapEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 209 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 218 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 227 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 228 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 238 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 244 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XColormapEvent mallocStack() {
/* 250 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 252 */   public static XColormapEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 254 */   public static XColormapEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 256 */   public static XColormapEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 258 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 260 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 262 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 264 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XColormapEvent malloc(MemoryStack paramMemoryStack) {
/* 272 */     return new XColormapEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XColormapEvent calloc(MemoryStack paramMemoryStack) {
/* 281 */     return new XColormapEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 291 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 301 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 307 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 309 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 311 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 313 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 315 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static long ncolormap(long paramLong) {
/* 317 */     return MemoryUtil.memGetCLong(paramLong + COLORMAP);
/*     */   } public static int nnew$(long paramLong) {
/* 319 */     return UNSAFE.getInt(null, paramLong + NEW);
/*     */   } public static int nstate(long paramLong) {
/* 321 */     return UNSAFE.getInt(null, paramLong + STATE);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 324 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 326 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 328 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 330 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 332 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void ncolormap(long paramLong1, long paramLong2) {
/* 334 */     MemoryUtil.memPutCLong(paramLong1 + COLORMAP, paramLong2);
/*     */   } public static void nnew$(long paramLong, int paramInt) {
/* 336 */     UNSAFE.putInt(null, paramLong + NEW, paramInt);
/*     */   } public static void nstate(long paramLong, int paramInt) {
/* 338 */     UNSAFE.putInt(null, paramLong + STATE, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 346 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XColormapEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 354 */     private static final XColormapEvent ELEMENT_FACTORY = XColormapEvent.create(-1L);
/*     */ 
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
/* 366 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XColormapEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 370 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 374 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 379 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XColormapEvent getElementFactory() {
/* 384 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 388 */       return XColormapEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 391 */       return XColormapEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 394 */       return (XColormapEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 397 */       return XColormapEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 400 */       return XColormapEvent.nwindow(address());
/*     */     } @NativeType("Colormap")
/*     */     public long colormap() {
/* 403 */       return XColormapEvent.ncolormap(address());
/*     */     } public int new$() {
/* 405 */       return XColormapEvent.nnew$(address());
/*     */     } public int state() {
/* 407 */       return XColormapEvent.nstate(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 410 */       XColormapEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 412 */       XColormapEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 414 */       XColormapEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 416 */       XColormapEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 418 */       XColormapEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer colormap(@NativeType("Colormap") long param1Long) {
/* 420 */       XColormapEvent.ncolormap(address(), param1Long); return this;
/*     */     } public Buffer new$(int param1Int) {
/* 422 */       XColormapEvent.nnew$(address(), param1Int); return this;
/*     */     } public Buffer state(int param1Int) {
/* 424 */       XColormapEvent.nstate(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XColormapEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */