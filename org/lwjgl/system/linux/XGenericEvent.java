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
/*     */ public class XGenericEvent
/*     */   extends Struct<XGenericEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int EXTENSION;
/*     */   public static final int EVTYPE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  61 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(4), __member(4) })).getSize();
/*  62 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  64 */     TYPE = layout.offsetof(0);
/*  65 */     SERIAL = layout.offsetof(1);
/*  66 */     SEND_EVENT = layout.offsetof(2);
/*  67 */     DISPLAY = layout.offsetof(3);
/*  68 */     EXTENSION = layout.offsetof(4);
/*  69 */     EVTYPE = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected XGenericEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  73 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XGenericEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  78 */     return new XGenericEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGenericEvent(ByteBuffer paramByteBuffer) {
/*  88 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  92 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/*  95 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/*  98 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 101 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 104 */     return ndisplay(address());
/*     */   } public int extension() {
/* 106 */     return nextension(address());
/*     */   } public int evtype() {
/* 108 */     return nevtype(address());
/*     */   }
/*     */   public XGenericEvent type(int paramInt) {
/* 111 */     ntype(address(), paramInt); return this;
/*     */   } public XGenericEvent serial(@NativeType("unsigned long") long paramLong) {
/* 113 */     nserial(address(), paramLong); return this;
/*     */   } public XGenericEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 115 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XGenericEvent display(@NativeType("Display *") long paramLong) {
/* 117 */     ndisplay(address(), paramLong); return this;
/*     */   } public XGenericEvent extension(int paramInt) {
/* 119 */     nextension(address(), paramInt); return this;
/*     */   } public XGenericEvent evtype(int paramInt) {
/* 121 */     nevtype(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGenericEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt2, int paramInt3) {
/* 132 */     type(paramInt1);
/* 133 */     serial(paramLong1);
/* 134 */     send_event(paramBoolean);
/* 135 */     display(paramLong2);
/* 136 */     extension(paramInt2);
/* 137 */     evtype(paramInt3);
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
/*     */   public XGenericEvent set(XGenericEvent paramXGenericEvent) {
/* 150 */     MemoryUtil.memCopy(paramXGenericEvent.address(), address(), SIZEOF);
/* 151 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEvent malloc() {
/* 158 */     return new XGenericEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEvent calloc() {
/* 163 */     return new XGenericEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEvent create() {
/* 168 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 169 */     return new XGenericEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEvent create(long paramLong) {
/* 174 */     return new XGenericEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEvent createSafe(long paramLong) {
/* 180 */     return (paramLong == 0L) ? null : new XGenericEvent(paramLong, null);
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
/*     */   public static XGenericEvent mallocStack() {
/* 230 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 232 */   public static XGenericEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 234 */   public static XGenericEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 236 */   public static XGenericEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
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
/*     */   public static XGenericEvent malloc(MemoryStack paramMemoryStack) {
/* 252 */     return new XGenericEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEvent calloc(MemoryStack paramMemoryStack) {
/* 261 */     return new XGenericEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   } public static int nextension(long paramLong) {
/* 295 */     return UNSAFE.getInt(null, paramLong + EXTENSION);
/*     */   } public static int nevtype(long paramLong) {
/* 297 */     return UNSAFE.getInt(null, paramLong + EVTYPE);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 300 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 302 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 304 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 306 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nextension(long paramLong, int paramInt) {
/* 308 */     UNSAFE.putInt(null, paramLong + EXTENSION, paramInt);
/*     */   } public static void nevtype(long paramLong, int paramInt) {
/* 310 */     UNSAFE.putInt(null, paramLong + EVTYPE, paramInt);
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
/*     */     extends StructBuffer<XGenericEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 326 */     private static final XGenericEvent ELEMENT_FACTORY = XGenericEvent.create(-1L);
/*     */ 
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
/* 338 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XGenericEvent.SIZEOF);
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
/*     */     protected XGenericEvent getElementFactory() {
/* 356 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 360 */       return XGenericEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 363 */       return XGenericEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 366 */       return (XGenericEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 369 */       return XGenericEvent.ndisplay(address());
/*     */     } public int extension() {
/* 371 */       return XGenericEvent.nextension(address());
/*     */     } public int evtype() {
/* 373 */       return XGenericEvent.nevtype(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 376 */       XGenericEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 378 */       XGenericEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 380 */       XGenericEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 382 */       XGenericEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer extension(int param1Int) {
/* 384 */       XGenericEvent.nextension(address(), param1Int); return this;
/*     */     } public Buffer evtype(int param1Int) {
/* 386 */       XGenericEvent.nevtype(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XGenericEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */