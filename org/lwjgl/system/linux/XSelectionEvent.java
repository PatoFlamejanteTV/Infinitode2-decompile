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
/*     */ 
/*     */ 
/*     */ public class XSelectionEvent
/*     */   extends Struct<XSelectionEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int REQUESTOR;
/*     */   public static final int SELECTION;
/*     */   public static final int TARGET;
/*     */   public static final int PROPERTY;
/*     */   public static final int TIME;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  70 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE) })).getSize();
/*  71 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  73 */     TYPE = layout.offsetof(0);
/*  74 */     SERIAL = layout.offsetof(1);
/*  75 */     SEND_EVENT = layout.offsetof(2);
/*  76 */     DISPLAY = layout.offsetof(3);
/*  77 */     REQUESTOR = layout.offsetof(4);
/*  78 */     SELECTION = layout.offsetof(5);
/*  79 */     TARGET = layout.offsetof(6);
/*  80 */     PROPERTY = layout.offsetof(7);
/*  81 */     TIME = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected XSelectionEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  85 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XSelectionEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  90 */     return new XSelectionEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionEvent(ByteBuffer paramByteBuffer) {
/* 100 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 104 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 107 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 110 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 113 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 116 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long requestor() {
/* 119 */     return nrequestor(address());
/*     */   } @NativeType("Atom")
/*     */   public long selection() {
/* 122 */     return nselection(address());
/*     */   } @NativeType("Atom")
/*     */   public long target() {
/* 125 */     return ntarget(address());
/*     */   } @NativeType("Atom")
/*     */   public long property() {
/* 128 */     return nproperty(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 131 */     return ntime(address());
/*     */   }
/*     */   public XSelectionEvent type(int paramInt) {
/* 134 */     ntype(address(), paramInt); return this;
/*     */   } public XSelectionEvent serial(@NativeType("unsigned long") long paramLong) {
/* 136 */     nserial(address(), paramLong); return this;
/*     */   } public XSelectionEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 138 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XSelectionEvent display(@NativeType("Display *") long paramLong) {
/* 140 */     ndisplay(address(), paramLong); return this;
/*     */   } public XSelectionEvent requestor(@NativeType("Window") long paramLong) {
/* 142 */     nrequestor(address(), paramLong); return this;
/*     */   } public XSelectionEvent selection(@NativeType("Atom") long paramLong) {
/* 144 */     nselection(address(), paramLong); return this;
/*     */   } public XSelectionEvent target(@NativeType("Atom") long paramLong) {
/* 146 */     ntarget(address(), paramLong); return this;
/*     */   } public XSelectionEvent property(@NativeType("Atom") long paramLong) {
/* 148 */     nproperty(address(), paramLong); return this;
/*     */   } public XSelectionEvent time(@NativeType("Time") long paramLong) {
/* 150 */     ntime(address(), paramLong); return this;
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
/*     */   
/*     */   public XSelectionEvent set(int paramInt, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7) {
/* 164 */     type(paramInt);
/* 165 */     serial(paramLong1);
/* 166 */     send_event(paramBoolean);
/* 167 */     display(paramLong2);
/* 168 */     requestor(paramLong3);
/* 169 */     selection(paramLong4);
/* 170 */     target(paramLong5);
/* 171 */     property(paramLong6);
/* 172 */     time(paramLong7);
/*     */     
/* 174 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionEvent set(XSelectionEvent paramXSelectionEvent) {
/* 185 */     MemoryUtil.memCopy(paramXSelectionEvent.address(), address(), SIZEOF);
/* 186 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionEvent malloc() {
/* 193 */     return new XSelectionEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionEvent calloc() {
/* 198 */     return new XSelectionEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionEvent create() {
/* 203 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 204 */     return new XSelectionEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionEvent create(long paramLong) {
/* 209 */     return new XSelectionEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionEvent createSafe(long paramLong) {
/* 215 */     return (paramLong == 0L) ? null : new XSelectionEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 224 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 233 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 242 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 243 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 253 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 259 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XSelectionEvent mallocStack() {
/* 265 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 267 */   public static XSelectionEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 269 */   public static XSelectionEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 271 */   public static XSelectionEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 273 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 275 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 277 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 279 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionEvent malloc(MemoryStack paramMemoryStack) {
/* 287 */     return new XSelectionEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionEvent calloc(MemoryStack paramMemoryStack) {
/* 296 */     return new XSelectionEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 306 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 316 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 322 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 324 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 326 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 328 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nrequestor(long paramLong) {
/* 330 */     return MemoryUtil.memGetCLong(paramLong + REQUESTOR);
/*     */   } public static long nselection(long paramLong) {
/* 332 */     return MemoryUtil.memGetCLong(paramLong + SELECTION);
/*     */   } public static long ntarget(long paramLong) {
/* 334 */     return MemoryUtil.memGetCLong(paramLong + TARGET);
/*     */   } public static long nproperty(long paramLong) {
/* 336 */     return MemoryUtil.memGetCLong(paramLong + PROPERTY);
/*     */   } public static long ntime(long paramLong) {
/* 338 */     return MemoryUtil.memGetCLong(paramLong + TIME);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 341 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 343 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 345 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 347 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nrequestor(long paramLong1, long paramLong2) {
/* 349 */     MemoryUtil.memPutCLong(paramLong1 + REQUESTOR, paramLong2);
/*     */   } public static void nselection(long paramLong1, long paramLong2) {
/* 351 */     MemoryUtil.memPutCLong(paramLong1 + SELECTION, paramLong2);
/*     */   } public static void ntarget(long paramLong1, long paramLong2) {
/* 353 */     MemoryUtil.memPutCLong(paramLong1 + TARGET, paramLong2);
/*     */   } public static void nproperty(long paramLong1, long paramLong2) {
/* 355 */     MemoryUtil.memPutCLong(paramLong1 + PROPERTY, paramLong2);
/*     */   } public static void ntime(long paramLong1, long paramLong2) {
/* 357 */     MemoryUtil.memPutCLong(paramLong1 + TIME, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 365 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XSelectionEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 373 */     private static final XSelectionEvent ELEMENT_FACTORY = XSelectionEvent.create(-1L);
/*     */ 
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
/* 385 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XSelectionEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 389 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 393 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 398 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XSelectionEvent getElementFactory() {
/* 403 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 407 */       return XSelectionEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 410 */       return XSelectionEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 413 */       return (XSelectionEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 416 */       return XSelectionEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long requestor() {
/* 419 */       return XSelectionEvent.nrequestor(address());
/*     */     } @NativeType("Atom")
/*     */     public long selection() {
/* 422 */       return XSelectionEvent.nselection(address());
/*     */     } @NativeType("Atom")
/*     */     public long target() {
/* 425 */       return XSelectionEvent.ntarget(address());
/*     */     } @NativeType("Atom")
/*     */     public long property() {
/* 428 */       return XSelectionEvent.nproperty(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 431 */       return XSelectionEvent.ntime(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 434 */       XSelectionEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 436 */       XSelectionEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 438 */       XSelectionEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 440 */       XSelectionEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer requestor(@NativeType("Window") long param1Long) {
/* 442 */       XSelectionEvent.nrequestor(address(), param1Long); return this;
/*     */     } public Buffer selection(@NativeType("Atom") long param1Long) {
/* 444 */       XSelectionEvent.nselection(address(), param1Long); return this;
/*     */     } public Buffer target(@NativeType("Atom") long param1Long) {
/* 446 */       XSelectionEvent.ntarget(address(), param1Long); return this;
/*     */     } public Buffer property(@NativeType("Atom") long param1Long) {
/* 448 */       XSelectionEvent.nproperty(address(), param1Long); return this;
/*     */     } public Buffer time(@NativeType("Time") long param1Long) {
/* 450 */       XSelectionEvent.ntime(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XSelectionEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */