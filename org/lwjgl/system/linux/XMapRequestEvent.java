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
/*     */ public class XMapRequestEvent
/*     */   extends Struct<XMapRequestEvent>
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
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  59 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE) })).getSize();
/*  60 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  62 */     TYPE = layout.offsetof(0);
/*  63 */     SERIAL = layout.offsetof(1);
/*  64 */     SEND_EVENT = layout.offsetof(2);
/*  65 */     DISPLAY = layout.offsetof(3);
/*  66 */     PARENT = layout.offsetof(4);
/*  67 */     WINDOW = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected XMapRequestEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  71 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XMapRequestEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  76 */     return new XMapRequestEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMapRequestEvent(ByteBuffer paramByteBuffer) {
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
/*     */   public long parent() {
/* 105 */     return nparent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 108 */     return nwindow(address());
/*     */   }
/*     */   public XMapRequestEvent type(int paramInt) {
/* 111 */     ntype(address(), paramInt); return this;
/*     */   } public XMapRequestEvent serial(@NativeType("unsigned long") long paramLong) {
/* 113 */     nserial(address(), paramLong); return this;
/*     */   } public XMapRequestEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 115 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XMapRequestEvent display(@NativeType("Display *") long paramLong) {
/* 117 */     ndisplay(address(), paramLong); return this;
/*     */   } public XMapRequestEvent parent(@NativeType("Window") long paramLong) {
/* 119 */     nparent(address(), paramLong); return this;
/*     */   } public XMapRequestEvent window(@NativeType("Window") long paramLong) {
/* 121 */     nwindow(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMapRequestEvent set(int paramInt, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4) {
/* 132 */     type(paramInt);
/* 133 */     serial(paramLong1);
/* 134 */     send_event(paramBoolean);
/* 135 */     display(paramLong2);
/* 136 */     parent(paramLong3);
/* 137 */     window(paramLong4);
/*     */     
/* 139 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMapRequestEvent set(XMapRequestEvent paramXMapRequestEvent) {
/* 150 */     MemoryUtil.memCopy(paramXMapRequestEvent.address(), address(), SIZEOF);
/* 151 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMapRequestEvent malloc() {
/* 158 */     return new XMapRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMapRequestEvent calloc() {
/* 163 */     return new XMapRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMapRequestEvent create() {
/* 168 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 169 */     return new XMapRequestEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XMapRequestEvent create(long paramLong) {
/* 174 */     return new XMapRequestEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMapRequestEvent createSafe(long paramLong) {
/* 180 */     return (paramLong == 0L) ? null : new XMapRequestEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 189 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 198 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 207 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 208 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 218 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 224 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XMapRequestEvent mallocStack() {
/* 230 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 232 */   public static XMapRequestEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 234 */   public static XMapRequestEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 236 */   public static XMapRequestEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 238 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 240 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 242 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 244 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMapRequestEvent malloc(MemoryStack paramMemoryStack) {
/* 252 */     return new XMapRequestEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XMapRequestEvent calloc(MemoryStack paramMemoryStack) {
/* 261 */     return new XMapRequestEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 271 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 281 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 287 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 289 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 291 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 293 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nparent(long paramLong) {
/* 295 */     return MemoryUtil.memGetCLong(paramLong + PARENT);
/*     */   } public static long nwindow(long paramLong) {
/* 297 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 300 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 302 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 304 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 306 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nparent(long paramLong1, long paramLong2) {
/* 308 */     MemoryUtil.memPutCLong(paramLong1 + PARENT, paramLong2);
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 310 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 318 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XMapRequestEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 326 */     private static final XMapRequestEvent ELEMENT_FACTORY = XMapRequestEvent.create(-1L);
/*     */ 
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
/* 338 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XMapRequestEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 342 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 346 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 351 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XMapRequestEvent getElementFactory() {
/* 356 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 360 */       return XMapRequestEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 363 */       return XMapRequestEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 366 */       return (XMapRequestEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 369 */       return XMapRequestEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long parent() {
/* 372 */       return XMapRequestEvent.nparent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 375 */       return XMapRequestEvent.nwindow(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 378 */       XMapRequestEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 380 */       XMapRequestEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 382 */       XMapRequestEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 384 */       XMapRequestEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer parent(@NativeType("Window") long param1Long) {
/* 386 */       XMapRequestEvent.nparent(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 388 */       XMapRequestEvent.nwindow(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XMapRequestEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */