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
/*     */ public class XFocusChangeEvent
/*     */   extends Struct<XFocusChangeEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int MODE;
/*     */   public static final int DETAIL;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  62 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(4), __member(4) })).getSize();
/*  63 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  65 */     TYPE = layout.offsetof(0);
/*  66 */     SERIAL = layout.offsetof(1);
/*  67 */     SEND_EVENT = layout.offsetof(2);
/*  68 */     DISPLAY = layout.offsetof(3);
/*  69 */     WINDOW = layout.offsetof(4);
/*  70 */     MODE = layout.offsetof(5);
/*  71 */     DETAIL = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XFocusChangeEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  75 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XFocusChangeEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  80 */     return new XFocusChangeEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XFocusChangeEvent(ByteBuffer paramByteBuffer) {
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
/*     */   public long window() {
/* 109 */     return nwindow(address());
/*     */   } public int mode() {
/* 111 */     return nmode(address());
/*     */   } public int detail() {
/* 113 */     return ndetail(address());
/*     */   }
/*     */   public XFocusChangeEvent type(int paramInt) {
/* 116 */     ntype(address(), paramInt); return this;
/*     */   } public XFocusChangeEvent serial(@NativeType("unsigned long") long paramLong) {
/* 118 */     nserial(address(), paramLong); return this;
/*     */   } public XFocusChangeEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 120 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XFocusChangeEvent display(@NativeType("Display *") long paramLong) {
/* 122 */     ndisplay(address(), paramLong); return this;
/*     */   } public XFocusChangeEvent window(@NativeType("Window") long paramLong) {
/* 124 */     nwindow(address(), paramLong); return this;
/*     */   } public XFocusChangeEvent mode(int paramInt) {
/* 126 */     nmode(address(), paramInt); return this;
/*     */   } public XFocusChangeEvent detail(int paramInt) {
/* 128 */     ndetail(address(), paramInt); return this;
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
/*     */   public XFocusChangeEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, int paramInt2, int paramInt3) {
/* 140 */     type(paramInt1);
/* 141 */     serial(paramLong1);
/* 142 */     send_event(paramBoolean);
/* 143 */     display(paramLong2);
/* 144 */     window(paramLong3);
/* 145 */     mode(paramInt2);
/* 146 */     detail(paramInt3);
/*     */     
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XFocusChangeEvent set(XFocusChangeEvent paramXFocusChangeEvent) {
/* 159 */     MemoryUtil.memCopy(paramXFocusChangeEvent.address(), address(), SIZEOF);
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent malloc() {
/* 167 */     return new XFocusChangeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent calloc() {
/* 172 */     return new XFocusChangeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent create() {
/* 177 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 178 */     return new XFocusChangeEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent create(long paramLong) {
/* 183 */     return new XFocusChangeEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent createSafe(long paramLong) {
/* 189 */     return (paramLong == 0L) ? null : new XFocusChangeEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 198 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 207 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 216 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 217 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 227 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 233 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XFocusChangeEvent mallocStack() {
/* 239 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 241 */   public static XFocusChangeEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 243 */   public static XFocusChangeEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 245 */   public static XFocusChangeEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 247 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 249 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 251 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 253 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent malloc(MemoryStack paramMemoryStack) {
/* 261 */     return new XFocusChangeEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XFocusChangeEvent calloc(MemoryStack paramMemoryStack) {
/* 270 */     return new XFocusChangeEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 280 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 290 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 296 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 298 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 300 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 302 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 304 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static int nmode(long paramLong) {
/* 306 */     return UNSAFE.getInt(null, paramLong + MODE);
/*     */   } public static int ndetail(long paramLong) {
/* 308 */     return UNSAFE.getInt(null, paramLong + DETAIL);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 311 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 313 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 315 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 317 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 319 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nmode(long paramLong, int paramInt) {
/* 321 */     UNSAFE.putInt(null, paramLong + MODE, paramInt);
/*     */   } public static void ndetail(long paramLong, int paramInt) {
/* 323 */     UNSAFE.putInt(null, paramLong + DETAIL, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 331 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XFocusChangeEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 339 */     private static final XFocusChangeEvent ELEMENT_FACTORY = XFocusChangeEvent.create(-1L);
/*     */ 
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
/* 351 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XFocusChangeEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 355 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 359 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 364 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XFocusChangeEvent getElementFactory() {
/* 369 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 373 */       return XFocusChangeEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 376 */       return XFocusChangeEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 379 */       return (XFocusChangeEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 382 */       return XFocusChangeEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 385 */       return XFocusChangeEvent.nwindow(address());
/*     */     } public int mode() {
/* 387 */       return XFocusChangeEvent.nmode(address());
/*     */     } public int detail() {
/* 389 */       return XFocusChangeEvent.ndetail(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 392 */       XFocusChangeEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 394 */       XFocusChangeEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 396 */       XFocusChangeEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 398 */       XFocusChangeEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 400 */       XFocusChangeEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer mode(int param1Int) {
/* 402 */       XFocusChangeEvent.nmode(address(), param1Int); return this;
/*     */     } public Buffer detail(int param1Int) {
/* 404 */       XFocusChangeEvent.ndetail(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XFocusChangeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */