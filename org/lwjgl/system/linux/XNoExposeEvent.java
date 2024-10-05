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
/*     */ public class XNoExposeEvent
/*     */   extends Struct<XNoExposeEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int DRAWABLE;
/*     */   public static final int MAJOR_CODE;
/*     */   public static final int MINOR_CODE;
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
/*  69 */     DRAWABLE = layout.offsetof(4);
/*  70 */     MAJOR_CODE = layout.offsetof(5);
/*  71 */     MINOR_CODE = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected XNoExposeEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  75 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XNoExposeEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  80 */     return new XNoExposeEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XNoExposeEvent(ByteBuffer paramByteBuffer) {
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
/*     */   } @NativeType("Drawable")
/*     */   public long drawable() {
/* 109 */     return ndrawable(address());
/*     */   } public int major_code() {
/* 111 */     return nmajor_code(address());
/*     */   } public int minor_code() {
/* 113 */     return nminor_code(address());
/*     */   }
/*     */   public XNoExposeEvent type(int paramInt) {
/* 116 */     ntype(address(), paramInt); return this;
/*     */   } public XNoExposeEvent serial(@NativeType("unsigned long") long paramLong) {
/* 118 */     nserial(address(), paramLong); return this;
/*     */   } public XNoExposeEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 120 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XNoExposeEvent display(@NativeType("Display *") long paramLong) {
/* 122 */     ndisplay(address(), paramLong); return this;
/*     */   } public XNoExposeEvent drawable(@NativeType("Drawable") long paramLong) {
/* 124 */     ndrawable(address(), paramLong); return this;
/*     */   } public XNoExposeEvent major_code(int paramInt) {
/* 126 */     nmajor_code(address(), paramInt); return this;
/*     */   } public XNoExposeEvent minor_code(int paramInt) {
/* 128 */     nminor_code(address(), paramInt); return this;
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
/*     */   public XNoExposeEvent set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, int paramInt2, int paramInt3) {
/* 140 */     type(paramInt1);
/* 141 */     serial(paramLong1);
/* 142 */     send_event(paramBoolean);
/* 143 */     display(paramLong2);
/* 144 */     drawable(paramLong3);
/* 145 */     major_code(paramInt2);
/* 146 */     minor_code(paramInt3);
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
/*     */   public XNoExposeEvent set(XNoExposeEvent paramXNoExposeEvent) {
/* 159 */     MemoryUtil.memCopy(paramXNoExposeEvent.address(), address(), SIZEOF);
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XNoExposeEvent malloc() {
/* 167 */     return new XNoExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XNoExposeEvent calloc() {
/* 172 */     return new XNoExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XNoExposeEvent create() {
/* 177 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 178 */     return new XNoExposeEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XNoExposeEvent create(long paramLong) {
/* 183 */     return new XNoExposeEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XNoExposeEvent createSafe(long paramLong) {
/* 189 */     return (paramLong == 0L) ? null : new XNoExposeEvent(paramLong, null);
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
/*     */   public static XNoExposeEvent mallocStack() {
/* 239 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 241 */   public static XNoExposeEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 243 */   public static XNoExposeEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 245 */   public static XNoExposeEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
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
/*     */   public static XNoExposeEvent malloc(MemoryStack paramMemoryStack) {
/* 261 */     return new XNoExposeEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XNoExposeEvent calloc(MemoryStack paramMemoryStack) {
/* 270 */     return new XNoExposeEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   } public static long ndrawable(long paramLong) {
/* 304 */     return MemoryUtil.memGetCLong(paramLong + DRAWABLE);
/*     */   } public static int nmajor_code(long paramLong) {
/* 306 */     return UNSAFE.getInt(null, paramLong + MAJOR_CODE);
/*     */   } public static int nminor_code(long paramLong) {
/* 308 */     return UNSAFE.getInt(null, paramLong + MINOR_CODE);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 311 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 313 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 315 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 317 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void ndrawable(long paramLong1, long paramLong2) {
/* 319 */     MemoryUtil.memPutCLong(paramLong1 + DRAWABLE, paramLong2);
/*     */   } public static void nmajor_code(long paramLong, int paramInt) {
/* 321 */     UNSAFE.putInt(null, paramLong + MAJOR_CODE, paramInt);
/*     */   } public static void nminor_code(long paramLong, int paramInt) {
/* 323 */     UNSAFE.putInt(null, paramLong + MINOR_CODE, paramInt);
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
/*     */     extends StructBuffer<XNoExposeEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 339 */     private static final XNoExposeEvent ELEMENT_FACTORY = XNoExposeEvent.create(-1L);
/*     */ 
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
/* 351 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XNoExposeEvent.SIZEOF);
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
/*     */     protected XNoExposeEvent getElementFactory() {
/* 369 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 373 */       return XNoExposeEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 376 */       return XNoExposeEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 379 */       return (XNoExposeEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 382 */       return XNoExposeEvent.ndisplay(address());
/*     */     } @NativeType("Drawable")
/*     */     public long drawable() {
/* 385 */       return XNoExposeEvent.ndrawable(address());
/*     */     } public int major_code() {
/* 387 */       return XNoExposeEvent.nmajor_code(address());
/*     */     } public int minor_code() {
/* 389 */       return XNoExposeEvent.nminor_code(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 392 */       XNoExposeEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 394 */       XNoExposeEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 396 */       XNoExposeEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 398 */       XNoExposeEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer drawable(@NativeType("Drawable") long param1Long) {
/* 400 */       XNoExposeEvent.ndrawable(address(), param1Long); return this;
/*     */     } public Buffer major_code(int param1Int) {
/* 402 */       XNoExposeEvent.nmajor_code(address(), param1Int); return this;
/*     */     } public Buffer minor_code(int param1Int) {
/* 404 */       XNoExposeEvent.nminor_code(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XNoExposeEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */