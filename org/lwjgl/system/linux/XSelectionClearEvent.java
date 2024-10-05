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
/*     */ public class XSelectionClearEvent
/*     */   extends Struct<XSelectionClearEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int SELECTION;
/*     */   public static final int TIME;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  62 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE) })).getSize();
/*  63 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  65 */     TYPE = layout.offsetof(0);
/*  66 */     SERIAL = layout.offsetof(1);
/*  67 */     SEND_EVENT = layout.offsetof(2);
/*  68 */     DISPLAY = layout.offsetof(3);
/*  69 */     WINDOW = layout.offsetof(4);
/*  70 */     SELECTION = layout.offsetof(5);
/*  71 */     TIME = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XSelectionClearEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  75 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XSelectionClearEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  80 */     return new XSelectionClearEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionClearEvent(ByteBuffer paramByteBuffer) {
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
/*     */   } @NativeType("Atom")
/*     */   public long selection() {
/* 112 */     return nselection(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 115 */     return ntime(address());
/*     */   }
/*     */   public XSelectionClearEvent type(int paramInt) {
/* 118 */     ntype(address(), paramInt); return this;
/*     */   } public XSelectionClearEvent serial(@NativeType("unsigned long") long paramLong) {
/* 120 */     nserial(address(), paramLong); return this;
/*     */   } public XSelectionClearEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 122 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XSelectionClearEvent display(@NativeType("Display *") long paramLong) {
/* 124 */     ndisplay(address(), paramLong); return this;
/*     */   } public XSelectionClearEvent window(@NativeType("Window") long paramLong) {
/* 126 */     nwindow(address(), paramLong); return this;
/*     */   } public XSelectionClearEvent selection(@NativeType("Atom") long paramLong) {
/* 128 */     nselection(address(), paramLong); return this;
/*     */   } public XSelectionClearEvent time(@NativeType("Time") long paramLong) {
/* 130 */     ntime(address(), paramLong); return this;
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
/*     */   public XSelectionClearEvent set(int paramInt, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/* 142 */     type(paramInt);
/* 143 */     serial(paramLong1);
/* 144 */     send_event(paramBoolean);
/* 145 */     display(paramLong2);
/* 146 */     window(paramLong3);
/* 147 */     selection(paramLong4);
/* 148 */     time(paramLong5);
/*     */     
/* 150 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionClearEvent set(XSelectionClearEvent paramXSelectionClearEvent) {
/* 161 */     MemoryUtil.memCopy(paramXSelectionClearEvent.address(), address(), SIZEOF);
/* 162 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent malloc() {
/* 169 */     return new XSelectionClearEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent calloc() {
/* 174 */     return new XSelectionClearEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent create() {
/* 179 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 180 */     return new XSelectionClearEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent create(long paramLong) {
/* 185 */     return new XSelectionClearEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent createSafe(long paramLong) {
/* 191 */     return (paramLong == 0L) ? null : new XSelectionClearEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 200 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 209 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 218 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 219 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 229 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 235 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XSelectionClearEvent mallocStack() {
/* 241 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 243 */   public static XSelectionClearEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 245 */   public static XSelectionClearEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 247 */   public static XSelectionClearEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 249 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 251 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 253 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 255 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent malloc(MemoryStack paramMemoryStack) {
/* 263 */     return new XSelectionClearEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionClearEvent calloc(MemoryStack paramMemoryStack) {
/* 272 */     return new XSelectionClearEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 282 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 292 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 298 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 300 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 302 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 304 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 306 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static long nselection(long paramLong) {
/* 308 */     return MemoryUtil.memGetCLong(paramLong + SELECTION);
/*     */   } public static long ntime(long paramLong) {
/* 310 */     return MemoryUtil.memGetCLong(paramLong + TIME);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 313 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 315 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 317 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 319 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 321 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nselection(long paramLong1, long paramLong2) {
/* 323 */     MemoryUtil.memPutCLong(paramLong1 + SELECTION, paramLong2);
/*     */   } public static void ntime(long paramLong1, long paramLong2) {
/* 325 */     MemoryUtil.memPutCLong(paramLong1 + TIME, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 333 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XSelectionClearEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 341 */     private static final XSelectionClearEvent ELEMENT_FACTORY = XSelectionClearEvent.create(-1L);
/*     */ 
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
/* 353 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XSelectionClearEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 357 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 361 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 366 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XSelectionClearEvent getElementFactory() {
/* 371 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 375 */       return XSelectionClearEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 378 */       return XSelectionClearEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 381 */       return (XSelectionClearEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 384 */       return XSelectionClearEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 387 */       return XSelectionClearEvent.nwindow(address());
/*     */     } @NativeType("Atom")
/*     */     public long selection() {
/* 390 */       return XSelectionClearEvent.nselection(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 393 */       return XSelectionClearEvent.ntime(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 396 */       XSelectionClearEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 398 */       XSelectionClearEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 400 */       XSelectionClearEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 402 */       XSelectionClearEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 404 */       XSelectionClearEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer selection(@NativeType("Atom") long param1Long) {
/* 406 */       XSelectionClearEvent.nselection(address(), param1Long); return this;
/*     */     } public Buffer time(@NativeType("Time") long param1Long) {
/* 408 */       XSelectionClearEvent.ntime(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XSelectionClearEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */