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
/*     */ public class XGenericEventCookie
/*     */   extends Struct<XGenericEventCookie>
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
/*     */   public static final int COOKIE;
/*     */   public static final int DATA;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  67 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(4), __member(4), __member(4), __member(POINTER_SIZE) })).getSize();
/*  68 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  70 */     TYPE = layout.offsetof(0);
/*  71 */     SERIAL = layout.offsetof(1);
/*  72 */     SEND_EVENT = layout.offsetof(2);
/*  73 */     DISPLAY = layout.offsetof(3);
/*  74 */     EXTENSION = layout.offsetof(4);
/*  75 */     EVTYPE = layout.offsetof(5);
/*  76 */     COOKIE = layout.offsetof(6);
/*  77 */     DATA = layout.offsetof(7);
/*     */   }
/*     */   
/*     */   protected XGenericEventCookie(long paramLong, ByteBuffer paramByteBuffer) {
/*  81 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XGenericEventCookie create(long paramLong, ByteBuffer paramByteBuffer) {
/*  86 */     return new XGenericEventCookie(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGenericEventCookie(ByteBuffer paramByteBuffer) {
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
/*     */   } public int extension() {
/* 114 */     return nextension(address());
/*     */   } public int evtype() {
/* 116 */     return nevtype(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int cookie() {
/* 119 */     return ncookie(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public ByteBuffer data(int paramInt) {
/* 126 */     return ndata(address(), paramInt);
/*     */   }
/*     */   public XGenericEventCookie type(int paramInt) {
/* 129 */     ntype(address(), paramInt); return this;
/*     */   } public XGenericEventCookie serial(@NativeType("unsigned long") long paramLong) {
/* 131 */     nserial(address(), paramLong); return this;
/*     */   } public XGenericEventCookie send_event(@NativeType("Bool") boolean paramBoolean) {
/* 133 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XGenericEventCookie display(@NativeType("Display *") long paramLong) {
/* 135 */     ndisplay(address(), paramLong); return this;
/*     */   } public XGenericEventCookie extension(int paramInt) {
/* 137 */     nextension(address(), paramInt); return this;
/*     */   } public XGenericEventCookie evtype(int paramInt) {
/* 139 */     nevtype(address(), paramInt); return this;
/*     */   } public XGenericEventCookie cookie(@NativeType("unsigned int") int paramInt) {
/* 141 */     ncookie(address(), paramInt); return this;
/*     */   } public XGenericEventCookie data(@NativeType("void *") ByteBuffer paramByteBuffer) {
/* 143 */     ndata(address(), paramByteBuffer); return this;
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
/*     */   public XGenericEventCookie set(int paramInt1, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt2, int paramInt3, int paramInt4, ByteBuffer paramByteBuffer) {
/* 156 */     type(paramInt1);
/* 157 */     serial(paramLong1);
/* 158 */     send_event(paramBoolean);
/* 159 */     display(paramLong2);
/* 160 */     extension(paramInt2);
/* 161 */     evtype(paramInt3);
/* 162 */     cookie(paramInt4);
/* 163 */     data(paramByteBuffer);
/*     */     
/* 165 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XGenericEventCookie set(XGenericEventCookie paramXGenericEventCookie) {
/* 176 */     MemoryUtil.memCopy(paramXGenericEventCookie.address(), address(), SIZEOF);
/* 177 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie malloc() {
/* 184 */     return new XGenericEventCookie(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie calloc() {
/* 189 */     return new XGenericEventCookie(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie create() {
/* 194 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 195 */     return new XGenericEventCookie(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie create(long paramLong) {
/* 200 */     return new XGenericEventCookie(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie createSafe(long paramLong) {
/* 206 */     return (paramLong == 0L) ? null : new XGenericEventCookie(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 215 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 224 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 233 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 234 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 244 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 250 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XGenericEventCookie mallocStack() {
/* 256 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 258 */   public static XGenericEventCookie callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 260 */   public static XGenericEventCookie mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 262 */   public static XGenericEventCookie callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 264 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 266 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 268 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 270 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie malloc(MemoryStack paramMemoryStack) {
/* 278 */     return new XGenericEventCookie(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XGenericEventCookie calloc(MemoryStack paramMemoryStack) {
/* 287 */     return new XGenericEventCookie(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 297 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 307 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 313 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 315 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 317 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 319 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static int nextension(long paramLong) {
/* 321 */     return UNSAFE.getInt(null, paramLong + EXTENSION);
/*     */   } public static int nevtype(long paramLong) {
/* 323 */     return UNSAFE.getInt(null, paramLong + EVTYPE);
/*     */   } public static int ncookie(long paramLong) {
/* 325 */     return UNSAFE.getInt(null, paramLong + COOKIE);
/*     */   } public static ByteBuffer ndata(long paramLong, int paramInt) {
/* 327 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(paramLong + DATA), paramInt);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 330 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 332 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 334 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 336 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nextension(long paramLong, int paramInt) {
/* 338 */     UNSAFE.putInt(null, paramLong + EXTENSION, paramInt);
/*     */   } public static void nevtype(long paramLong, int paramInt) {
/* 340 */     UNSAFE.putInt(null, paramLong + EVTYPE, paramInt);
/*     */   } public static void ncookie(long paramLong, int paramInt) {
/* 342 */     UNSAFE.putInt(null, paramLong + COOKIE, paramInt);
/*     */   } public static void ndata(long paramLong, ByteBuffer paramByteBuffer) {
/* 344 */     MemoryUtil.memPutAddress(paramLong + DATA, MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 352 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/* 353 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DATA));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XGenericEventCookie, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 361 */     private static final XGenericEventCookie ELEMENT_FACTORY = XGenericEventCookie.create(-1L);
/*     */ 
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
/* 373 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XGenericEventCookie.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 377 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 381 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 386 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XGenericEventCookie getElementFactory() {
/* 391 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 395 */       return XGenericEventCookie.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 398 */       return XGenericEventCookie.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 401 */       return (XGenericEventCookie.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 404 */       return XGenericEventCookie.ndisplay(address());
/*     */     } public int extension() {
/* 406 */       return XGenericEventCookie.nextension(address());
/*     */     } public int evtype() {
/* 408 */       return XGenericEventCookie.nevtype(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int cookie() {
/* 411 */       return XGenericEventCookie.ncookie(address());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @NativeType("void *")
/*     */     public ByteBuffer data(int param1Int) {
/* 418 */       return XGenericEventCookie.ndata(address(), param1Int);
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 421 */       XGenericEventCookie.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 423 */       XGenericEventCookie.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 425 */       XGenericEventCookie.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 427 */       XGenericEventCookie.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer extension(int param1Int) {
/* 429 */       XGenericEventCookie.nextension(address(), param1Int); return this;
/*     */     } public Buffer evtype(int param1Int) {
/* 431 */       XGenericEventCookie.nevtype(address(), param1Int); return this;
/*     */     } public Buffer cookie(@NativeType("unsigned int") int param1Int) {
/* 433 */       XGenericEventCookie.ncookie(address(), param1Int); return this;
/*     */     } public Buffer data(@NativeType("void *") ByteBuffer param1ByteBuffer) {
/* 435 */       XGenericEventCookie.ndata(address(), param1ByteBuffer); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XGenericEventCookie.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */