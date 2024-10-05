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
/*     */ public class XPropertyEvent
/*     */   extends Struct<XPropertyEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int ATOM;
/*     */   public static final int TIME;
/*     */   public static final int STATE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  67 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(4) })).getSize();
/*  68 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  70 */     TYPE = layout.offsetof(0);
/*  71 */     SERIAL = layout.offsetof(1);
/*  72 */     SEND_EVENT = layout.offsetof(2);
/*  73 */     DISPLAY = layout.offsetof(3);
/*  74 */     WINDOW = layout.offsetof(4);
/*  75 */     ATOM = layout.offsetof(5);
/*  76 */     TIME = layout.offsetof(6);
/*  77 */     STATE = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected XPropertyEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  81 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XPropertyEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  86 */     return new XPropertyEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XPropertyEvent(ByteBuffer paramByteBuffer) {
/*  96 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 100 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 103 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 106 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 109 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 112 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 115 */     return nwindow(address());
/*     */   } @NativeType("Atom")
/*     */   public long atom() {
/* 118 */     return natom(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 121 */     return ntime(address());
/*     */   } public int state() {
/* 123 */     return nstate(address());
/*     */   }
/*     */   public XPropertyEvent type(int paramInt) {
/* 126 */     ntype(address(), paramInt); return this;
/*     */   } public XPropertyEvent serial(@NativeType("unsigned long") long paramLong) {
/* 128 */     nserial(address(), paramLong); return this;
/*     */   } public XPropertyEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 130 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XPropertyEvent display(@NativeType("Display *") long paramLong) {
/* 132 */     ndisplay(address(), paramLong); return this;
/*     */   } public XPropertyEvent window(@NativeType("Window") long paramLong) {
/* 134 */     nwindow(address(), paramLong); return this;
/*     */   } public XPropertyEvent atom(@NativeType("Atom") long paramLong) {
/* 136 */     natom(address(), paramLong); return this;
/*     */   } public XPropertyEvent time(@NativeType("Time") long paramLong) {
/* 138 */     ntime(address(), paramLong); return this;
/*     */   } public XPropertyEvent state(int paramInt) {
/* 140 */     nstate(address(), paramInt); return this;
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
/*     */   public XPropertyEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2) {
/* 153 */     type(paramInt1);
/* 154 */     serial(paramLong1);
/* 155 */     send_event(paramBoolean);
/* 156 */     display(paramLong2);
/* 157 */     window(paramLong3);
/* 158 */     atom(paramLong4);
/* 159 */     time(paramLong5);
/* 160 */     state(paramInt2);
/*     */     
/* 162 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XPropertyEvent set(XPropertyEvent paramXPropertyEvent) {
/* 173 */     MemoryUtil.memCopy(paramXPropertyEvent.address(), address(), SIZEOF);
/* 174 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XPropertyEvent malloc() {
/* 181 */     return new XPropertyEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XPropertyEvent calloc() {
/* 186 */     return new XPropertyEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XPropertyEvent create() {
/* 191 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 192 */     return new XPropertyEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XPropertyEvent create(long paramLong) {
/* 197 */     return new XPropertyEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XPropertyEvent createSafe(long paramLong) {
/* 203 */     return (paramLong == 0L) ? null : new XPropertyEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 212 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 221 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 230 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 231 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 241 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 247 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XPropertyEvent mallocStack() {
/* 253 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 255 */   public static XPropertyEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 257 */   public static XPropertyEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 259 */   public static XPropertyEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 261 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 263 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 265 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 267 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XPropertyEvent malloc(MemoryStack paramMemoryStack) {
/* 275 */     return new XPropertyEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XPropertyEvent calloc(MemoryStack paramMemoryStack) {
/* 284 */     return new XPropertyEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 294 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 304 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 310 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 312 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 314 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 316 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 318 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static long natom(long paramLong) {
/* 320 */     return MemoryUtil.memGetCLong(paramLong + ATOM);
/*     */   } public static long ntime(long paramLong) {
/* 322 */     return MemoryUtil.memGetCLong(paramLong + TIME);
/*     */   } public static int nstate(long paramLong) {
/* 324 */     return UNSAFE.getInt(null, paramLong + STATE);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 327 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 329 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 331 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 333 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 335 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void natom(long paramLong1, long paramLong2) {
/* 337 */     MemoryUtil.memPutCLong(paramLong1 + ATOM, paramLong2);
/*     */   } public static void ntime(long paramLong1, long paramLong2) {
/* 339 */     MemoryUtil.memPutCLong(paramLong1 + TIME, paramLong2);
/*     */   } public static void nstate(long paramLong, int paramInt) {
/* 341 */     UNSAFE.putInt(null, paramLong + STATE, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 349 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XPropertyEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 357 */     private static final XPropertyEvent ELEMENT_FACTORY = XPropertyEvent.create(-1L);
/*     */ 
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
/* 369 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XPropertyEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 373 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 377 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 382 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XPropertyEvent getElementFactory() {
/* 387 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 391 */       return XPropertyEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 394 */       return XPropertyEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 397 */       return (XPropertyEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 400 */       return XPropertyEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 403 */       return XPropertyEvent.nwindow(address());
/*     */     } @NativeType("Atom")
/*     */     public long atom() {
/* 406 */       return XPropertyEvent.natom(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 409 */       return XPropertyEvent.ntime(address());
/*     */     } public int state() {
/* 411 */       return XPropertyEvent.nstate(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 414 */       XPropertyEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 416 */       XPropertyEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 418 */       XPropertyEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 420 */       XPropertyEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 422 */       XPropertyEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer atom(@NativeType("Atom") long param1Long) {
/* 424 */       XPropertyEvent.natom(address(), param1Long); return this;
/*     */     } public Buffer time(@NativeType("Time") long param1Long) {
/* 426 */       XPropertyEvent.ntime(address(), param1Long); return this;
/*     */     } public Buffer state(int param1Int) {
/* 428 */       XPropertyEvent.nstate(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XPropertyEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */