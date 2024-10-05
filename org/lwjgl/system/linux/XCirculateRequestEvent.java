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
/*     */ public class XCirculateRequestEvent
/*     */   extends Struct<XCirculateRequestEvent>
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
/*     */   public static final int PLACE;
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
/*  69 */     PARENT = layout.offsetof(4);
/*  70 */     WINDOW = layout.offsetof(5);
/*  71 */     PLACE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XCirculateRequestEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  75 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XCirculateRequestEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  80 */     return new XCirculateRequestEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XCirculateRequestEvent(ByteBuffer paramByteBuffer) {
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
/*     */   public long parent() {
/* 109 */     return nparent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 112 */     return nwindow(address());
/*     */   } public int place() {
/* 114 */     return nplace(address());
/*     */   }
/*     */   public XCirculateRequestEvent type(int paramInt) {
/* 117 */     ntype(address(), paramInt); return this;
/*     */   } public XCirculateRequestEvent serial(@NativeType("unsigned long") long paramLong) {
/* 119 */     nserial(address(), paramLong); return this;
/*     */   } public XCirculateRequestEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 121 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XCirculateRequestEvent display(@NativeType("Display *") long paramLong) {
/* 123 */     ndisplay(address(), paramLong); return this;
/*     */   } public XCirculateRequestEvent parent(@NativeType("Window") long paramLong) {
/* 125 */     nparent(address(), paramLong); return this;
/*     */   } public XCirculateRequestEvent window(@NativeType("Window") long paramLong) {
/* 127 */     nwindow(address(), paramLong); return this;
/*     */   } public XCirculateRequestEvent place(int paramInt) {
/* 129 */     nplace(address(), paramInt); return this;
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
/*     */   public XCirculateRequestEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, int paramInt2) {
/* 141 */     type(paramInt1);
/* 142 */     serial(paramLong1);
/* 143 */     send_event(paramBoolean);
/* 144 */     display(paramLong2);
/* 145 */     parent(paramLong3);
/* 146 */     window(paramLong4);
/* 147 */     place(paramInt2);
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
/*     */   public XCirculateRequestEvent set(XCirculateRequestEvent paramXCirculateRequestEvent) {
/* 160 */     MemoryUtil.memCopy(paramXCirculateRequestEvent.address(), address(), SIZEOF);
/* 161 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent malloc() {
/* 168 */     return new XCirculateRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent calloc() {
/* 173 */     return new XCirculateRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent create() {
/* 178 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 179 */     return new XCirculateRequestEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent create(long paramLong) {
/* 184 */     return new XCirculateRequestEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent createSafe(long paramLong) {
/* 190 */     return (paramLong == 0L) ? null : new XCirculateRequestEvent(paramLong, null);
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
/*     */   public static XCirculateRequestEvent mallocStack() {
/* 240 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 242 */   public static XCirculateRequestEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 244 */   public static XCirculateRequestEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 246 */   public static XCirculateRequestEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
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
/*     */   public static XCirculateRequestEvent malloc(MemoryStack paramMemoryStack) {
/* 262 */     return new XCirculateRequestEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XCirculateRequestEvent calloc(MemoryStack paramMemoryStack) {
/* 271 */     return new XCirculateRequestEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   } public static long nparent(long paramLong) {
/* 305 */     return MemoryUtil.memGetCLong(paramLong + PARENT);
/*     */   } public static long nwindow(long paramLong) {
/* 307 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static int nplace(long paramLong) {
/* 309 */     return UNSAFE.getInt(null, paramLong + PLACE);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 312 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 314 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 316 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 318 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nparent(long paramLong1, long paramLong2) {
/* 320 */     MemoryUtil.memPutCLong(paramLong1 + PARENT, paramLong2);
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 322 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nplace(long paramLong, int paramInt) {
/* 324 */     UNSAFE.putInt(null, paramLong + PLACE, paramInt);
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
/*     */     extends StructBuffer<XCirculateRequestEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 340 */     private static final XCirculateRequestEvent ELEMENT_FACTORY = XCirculateRequestEvent.create(-1L);
/*     */ 
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
/* 352 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XCirculateRequestEvent.SIZEOF);
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
/*     */     protected XCirculateRequestEvent getElementFactory() {
/* 370 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 374 */       return XCirculateRequestEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 377 */       return XCirculateRequestEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 380 */       return (XCirculateRequestEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 383 */       return XCirculateRequestEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long parent() {
/* 386 */       return XCirculateRequestEvent.nparent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 389 */       return XCirculateRequestEvent.nwindow(address());
/*     */     } public int place() {
/* 391 */       return XCirculateRequestEvent.nplace(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 394 */       XCirculateRequestEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 396 */       XCirculateRequestEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 398 */       XCirculateRequestEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 400 */       XCirculateRequestEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer parent(@NativeType("Window") long param1Long) {
/* 402 */       XCirculateRequestEvent.nparent(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 404 */       XCirculateRequestEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer place(int param1Int) {
/* 406 */       XCirculateRequestEvent.nplace(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XCirculateRequestEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */