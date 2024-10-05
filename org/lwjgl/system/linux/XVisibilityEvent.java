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
/*     */ public class XVisibilityEvent
/*     */   extends Struct<XVisibilityEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int WINDOW;
/*     */   public static final int STATE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  59 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(4) })).getSize();
/*  60 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  62 */     TYPE = layout.offsetof(0);
/*  63 */     SERIAL = layout.offsetof(1);
/*  64 */     SEND_EVENT = layout.offsetof(2);
/*  65 */     DISPLAY = layout.offsetof(3);
/*  66 */     WINDOW = layout.offsetof(4);
/*  67 */     STATE = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected XVisibilityEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  71 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XVisibilityEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  76 */     return new XVisibilityEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XVisibilityEvent(ByteBuffer paramByteBuffer) {
/*  86 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  90 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  93 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/*  96 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/*  99 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 102 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 105 */     return nwindow(address());
/*     */   } public int state() {
/* 107 */     return nstate(address());
/*     */   }
/*     */   public XVisibilityEvent type(int paramInt) {
/* 110 */     ntype(address(), paramInt); return this;
/*     */   } public XVisibilityEvent serial(@NativeType("unsigned long") long paramLong) {
/* 112 */     nserial(address(), paramLong); return this;
/*     */   } public XVisibilityEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 114 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XVisibilityEvent display(@NativeType("Display *") long paramLong) {
/* 116 */     ndisplay(address(), paramLong); return this;
/*     */   } public XVisibilityEvent window(@NativeType("Window") long paramLong) {
/* 118 */     nwindow(address(), paramLong); return this;
/*     */   } public XVisibilityEvent state(int paramInt) {
/* 120 */     nstate(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XVisibilityEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, int paramInt2) {
/* 131 */     type(paramInt1);
/* 132 */     serial(paramLong1);
/* 133 */     send_event(paramBoolean);
/* 134 */     display(paramLong2);
/* 135 */     window(paramLong3);
/* 136 */     state(paramInt2);
/*     */     
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XVisibilityEvent set(XVisibilityEvent paramXVisibilityEvent) {
/* 149 */     MemoryUtil.memCopy(paramXVisibilityEvent.address(), address(), SIZEOF);
/* 150 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent malloc() {
/* 157 */     return new XVisibilityEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent calloc() {
/* 162 */     return new XVisibilityEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent create() {
/* 167 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 168 */     return new XVisibilityEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent create(long paramLong) {
/* 173 */     return new XVisibilityEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent createSafe(long paramLong) {
/* 179 */     return (paramLong == 0L) ? null : new XVisibilityEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 188 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 197 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 206 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 207 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 217 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 223 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XVisibilityEvent mallocStack() {
/* 229 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 231 */   public static XVisibilityEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 233 */   public static XVisibilityEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 235 */   public static XVisibilityEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 237 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 239 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 241 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 243 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent malloc(MemoryStack paramMemoryStack) {
/* 251 */     return new XVisibilityEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XVisibilityEvent calloc(MemoryStack paramMemoryStack) {
/* 260 */     return new XVisibilityEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 270 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 280 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 286 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 288 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 290 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 292 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nwindow(long paramLong) {
/* 294 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static int nstate(long paramLong) {
/* 296 */     return UNSAFE.getInt(null, paramLong + STATE);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 299 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 301 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 303 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 305 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 307 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nstate(long paramLong, int paramInt) {
/* 309 */     UNSAFE.putInt(null, paramLong + STATE, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 317 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XVisibilityEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 325 */     private static final XVisibilityEvent ELEMENT_FACTORY = XVisibilityEvent.create(-1L);
/*     */ 
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
/* 337 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XVisibilityEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 341 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 345 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 350 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XVisibilityEvent getElementFactory() {
/* 355 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 359 */       return XVisibilityEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 362 */       return XVisibilityEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 365 */       return (XVisibilityEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 368 */       return XVisibilityEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 371 */       return XVisibilityEvent.nwindow(address());
/*     */     } public int state() {
/* 373 */       return XVisibilityEvent.nstate(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 376 */       XVisibilityEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 378 */       XVisibilityEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 380 */       XVisibilityEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 382 */       XVisibilityEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 384 */       XVisibilityEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer state(int param1Int) {
/* 386 */       XVisibilityEvent.nstate(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XVisibilityEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */