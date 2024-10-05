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
/*     */ public class XGravityEvent
/*     */   extends Struct<XGravityEvent>
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
/*     */   public static final int X;
/*     */   public static final int Y;
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
/*  72 */     EVENT = layout.offsetof(4);
/*  73 */     WINDOW = layout.offsetof(5);
/*  74 */     X = layout.offsetof(6);
/*  75 */     Y = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected XGravityEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  79 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XGravityEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  84 */     return new XGravityEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGravityEvent(ByteBuffer paramByteBuffer) {
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
/*     */   public long event() {
/* 113 */     return nevent(address());
/*     */   } @NativeType("Window")
/*     */   public long window() {
/* 116 */     return nwindow(address());
/*     */   } public int x() {
/* 118 */     return nx(address());
/*     */   } public int y() {
/* 120 */     return ny(address());
/*     */   }
/*     */   public XGravityEvent type(int paramInt) {
/* 123 */     ntype(address(), paramInt); return this;
/*     */   } public XGravityEvent serial(@NativeType("unsigned long") long paramLong) {
/* 125 */     nserial(address(), paramLong); return this;
/*     */   } public XGravityEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 127 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XGravityEvent display(@NativeType("Display *") long paramLong) {
/* 129 */     ndisplay(address(), paramLong); return this;
/*     */   } public XGravityEvent event(@NativeType("Window") long paramLong) {
/* 131 */     nevent(address(), paramLong); return this;
/*     */   } public XGravityEvent window(@NativeType("Window") long paramLong) {
/* 133 */     nwindow(address(), paramLong); return this;
/*     */   } public XGravityEvent x(int paramInt) {
/* 135 */     nx(address(), paramInt); return this;
/*     */   } public XGravityEvent y(int paramInt) {
/* 137 */     ny(address(), paramInt); return this;
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
/*     */   public XGravityEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, int paramInt2, int paramInt3) {
/* 150 */     type(paramInt1);
/* 151 */     serial(paramLong1);
/* 152 */     send_event(paramBoolean);
/* 153 */     display(paramLong2);
/* 154 */     event(paramLong3);
/* 155 */     window(paramLong4);
/* 156 */     x(paramInt2);
/* 157 */     y(paramInt3);
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
/*     */   public XGravityEvent set(XGravityEvent paramXGravityEvent) {
/* 170 */     MemoryUtil.memCopy(paramXGravityEvent.address(), address(), SIZEOF);
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGravityEvent malloc() {
/* 178 */     return new XGravityEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGravityEvent calloc() {
/* 183 */     return new XGravityEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGravityEvent create() {
/* 188 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 189 */     return new XGravityEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGravityEvent create(long paramLong) {
/* 194 */     return new XGravityEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGravityEvent createSafe(long paramLong) {
/* 200 */     return (paramLong == 0L) ? null : new XGravityEvent(paramLong, null);
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
/*     */   public static XGravityEvent mallocStack() {
/* 250 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 252 */   public static XGravityEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 254 */   public static XGravityEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 256 */   public static XGravityEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
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
/*     */   public static XGravityEvent malloc(MemoryStack paramMemoryStack) {
/* 272 */     return new XGravityEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGravityEvent calloc(MemoryStack paramMemoryStack) {
/* 281 */     return new XGravityEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   } public static long nevent(long paramLong) {
/* 315 */     return MemoryUtil.memGetCLong(paramLong + EVENT);
/*     */   } public static long nwindow(long paramLong) {
/* 317 */     return MemoryUtil.memGetCLong(paramLong + WINDOW);
/*     */   } public static int nx(long paramLong) {
/* 319 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 321 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 324 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 326 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 328 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 330 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nevent(long paramLong1, long paramLong2) {
/* 332 */     MemoryUtil.memPutCLong(paramLong1 + EVENT, paramLong2);
/*     */   } public static void nwindow(long paramLong1, long paramLong2) {
/* 334 */     MemoryUtil.memPutCLong(paramLong1 + WINDOW, paramLong2);
/*     */   } public static void nx(long paramLong, int paramInt) {
/* 336 */     UNSAFE.putInt(null, paramLong + X, paramInt);
/*     */   } public static void ny(long paramLong, int paramInt) {
/* 338 */     UNSAFE.putInt(null, paramLong + Y, paramInt);
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
/*     */     extends StructBuffer<XGravityEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 354 */     private static final XGravityEvent ELEMENT_FACTORY = XGravityEvent.create(-1L);
/*     */ 
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
/* 366 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XGravityEvent.SIZEOF);
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
/*     */     protected XGravityEvent getElementFactory() {
/* 384 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 388 */       return XGravityEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 391 */       return XGravityEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 394 */       return (XGravityEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 397 */       return XGravityEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long event() {
/* 400 */       return XGravityEvent.nevent(address());
/*     */     } @NativeType("Window")
/*     */     public long window() {
/* 403 */       return XGravityEvent.nwindow(address());
/*     */     } public int x() {
/* 405 */       return XGravityEvent.nx(address());
/*     */     } public int y() {
/* 407 */       return XGravityEvent.ny(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 410 */       XGravityEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 412 */       XGravityEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 414 */       XGravityEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 416 */       XGravityEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer event(@NativeType("Window") long param1Long) {
/* 418 */       XGravityEvent.nevent(address(), param1Long); return this;
/*     */     } public Buffer window(@NativeType("Window") long param1Long) {
/* 420 */       XGravityEvent.nwindow(address(), param1Long); return this;
/*     */     } public Buffer x(int param1Int) {
/* 422 */       XGravityEvent.nx(address(), param1Int); return this;
/*     */     } public Buffer y(int param1Int) {
/* 424 */       XGravityEvent.ny(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XGravityEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */