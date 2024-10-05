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
/*     */ 
/*     */ 
/*     */ public class XSelectionRequestEvent
/*     */   extends Struct<XSelectionRequestEvent>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TYPE;
/*     */   public static final int SERIAL;
/*     */   public static final int SEND_EVENT;
/*     */   public static final int DISPLAY;
/*     */   public static final int OWNER;
/*     */   public static final int REQUESTOR;
/*     */   public static final int SELECTION;
/*     */   public static final int TARGET;
/*     */   public static final int PROPERTY;
/*     */   public static final int TIME;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  73 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(CLONG_SIZE), __member(4), __member(POINTER_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE), __member(CLONG_SIZE) })).getSize();
/*  74 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  76 */     TYPE = layout.offsetof(0);
/*  77 */     SERIAL = layout.offsetof(1);
/*  78 */     SEND_EVENT = layout.offsetof(2);
/*  79 */     DISPLAY = layout.offsetof(3);
/*  80 */     OWNER = layout.offsetof(4);
/*  81 */     REQUESTOR = layout.offsetof(5);
/*  82 */     SELECTION = layout.offsetof(6);
/*  83 */     TARGET = layout.offsetof(7);
/*  84 */     PROPERTY = layout.offsetof(8);
/*  85 */     TIME = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected XSelectionRequestEvent(long paramLong, ByteBuffer paramByteBuffer) {
/*  89 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XSelectionRequestEvent create(long paramLong, ByteBuffer paramByteBuffer) {
/*  94 */     return new XSelectionRequestEvent(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionRequestEvent(ByteBuffer paramByteBuffer) {
/* 104 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 108 */     return SIZEOF;
/*     */   }
/*     */   public int type() {
/* 111 */     return ntype(address());
/*     */   } @NativeType("unsigned long")
/*     */   public long serial() {
/* 114 */     return nserial(address());
/*     */   } @NativeType("Bool")
/*     */   public boolean send_event() {
/* 117 */     return (nsend_event(address()) != 0);
/*     */   } @NativeType("Display *")
/*     */   public long display() {
/* 120 */     return ndisplay(address());
/*     */   } @NativeType("Window")
/*     */   public long owner() {
/* 123 */     return nowner(address());
/*     */   } @NativeType("Window")
/*     */   public long requestor() {
/* 126 */     return nrequestor(address());
/*     */   } @NativeType("Atom")
/*     */   public long selection() {
/* 129 */     return nselection(address());
/*     */   } @NativeType("Atom")
/*     */   public long target() {
/* 132 */     return ntarget(address());
/*     */   } @NativeType("Atom")
/*     */   public long property() {
/* 135 */     return nproperty(address());
/*     */   } @NativeType("Time")
/*     */   public long time() {
/* 138 */     return ntime(address());
/*     */   }
/*     */   public XSelectionRequestEvent type(int paramInt) {
/* 141 */     ntype(address(), paramInt); return this;
/*     */   } public XSelectionRequestEvent serial(@NativeType("unsigned long") long paramLong) {
/* 143 */     nserial(address(), paramLong); return this;
/*     */   } public XSelectionRequestEvent send_event(@NativeType("Bool") boolean paramBoolean) {
/* 145 */     nsend_event(address(), paramBoolean ? 1 : 0); return this;
/*     */   } public XSelectionRequestEvent display(@NativeType("Display *") long paramLong) {
/* 147 */     ndisplay(address(), paramLong); return this;
/*     */   } public XSelectionRequestEvent owner(@NativeType("Window") long paramLong) {
/* 149 */     nowner(address(), paramLong); return this;
/*     */   } public XSelectionRequestEvent requestor(@NativeType("Window") long paramLong) {
/* 151 */     nrequestor(address(), paramLong); return this;
/*     */   } public XSelectionRequestEvent selection(@NativeType("Atom") long paramLong) {
/* 153 */     nselection(address(), paramLong); return this;
/*     */   } public XSelectionRequestEvent target(@NativeType("Atom") long paramLong) {
/* 155 */     ntarget(address(), paramLong); return this;
/*     */   } public XSelectionRequestEvent property(@NativeType("Atom") long paramLong) {
/* 157 */     nproperty(address(), paramLong); return this;
/*     */   } public XSelectionRequestEvent time(@NativeType("Time") long paramLong) {
/* 159 */     ntime(address(), paramLong); return this;
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
/*     */   
/*     */   public XSelectionRequestEvent set(int paramInt, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8) {
/* 174 */     type(paramInt);
/* 175 */     serial(paramLong1);
/* 176 */     send_event(paramBoolean);
/* 177 */     display(paramLong2);
/* 178 */     owner(paramLong3);
/* 179 */     requestor(paramLong4);
/* 180 */     selection(paramLong5);
/* 181 */     target(paramLong6);
/* 182 */     property(paramLong7);
/* 183 */     time(paramLong8);
/*     */     
/* 185 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSelectionRequestEvent set(XSelectionRequestEvent paramXSelectionRequestEvent) {
/* 196 */     MemoryUtil.memCopy(paramXSelectionRequestEvent.address(), address(), SIZEOF);
/* 197 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent malloc() {
/* 204 */     return new XSelectionRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent calloc() {
/* 209 */     return new XSelectionRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent create() {
/* 214 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 215 */     return new XSelectionRequestEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent create(long paramLong) {
/* 220 */     return new XSelectionRequestEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent createSafe(long paramLong) {
/* 226 */     return (paramLong == 0L) ? null : new XSelectionRequestEvent(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 235 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 244 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 253 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 254 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 264 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 270 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static XSelectionRequestEvent mallocStack() {
/* 276 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 278 */   public static XSelectionRequestEvent callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 280 */   public static XSelectionRequestEvent mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 282 */   public static XSelectionRequestEvent callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 284 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 286 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 288 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 290 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent malloc(MemoryStack paramMemoryStack) {
/* 298 */     return new XSelectionRequestEvent(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSelectionRequestEvent calloc(MemoryStack paramMemoryStack) {
/* 307 */     return new XSelectionRequestEvent(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 317 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 327 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ntype(long paramLong) {
/* 333 */     return UNSAFE.getInt(null, paramLong + TYPE);
/*     */   } public static long nserial(long paramLong) {
/* 335 */     return MemoryUtil.memGetCLong(paramLong + SERIAL);
/*     */   } public static int nsend_event(long paramLong) {
/* 337 */     return UNSAFE.getInt(null, paramLong + SEND_EVENT);
/*     */   } public static long ndisplay(long paramLong) {
/* 339 */     return MemoryUtil.memGetAddress(paramLong + DISPLAY);
/*     */   } public static long nowner(long paramLong) {
/* 341 */     return MemoryUtil.memGetCLong(paramLong + OWNER);
/*     */   } public static long nrequestor(long paramLong) {
/* 343 */     return MemoryUtil.memGetCLong(paramLong + REQUESTOR);
/*     */   } public static long nselection(long paramLong) {
/* 345 */     return MemoryUtil.memGetCLong(paramLong + SELECTION);
/*     */   } public static long ntarget(long paramLong) {
/* 347 */     return MemoryUtil.memGetCLong(paramLong + TARGET);
/*     */   } public static long nproperty(long paramLong) {
/* 349 */     return MemoryUtil.memGetCLong(paramLong + PROPERTY);
/*     */   } public static long ntime(long paramLong) {
/* 351 */     return MemoryUtil.memGetCLong(paramLong + TIME);
/*     */   }
/*     */   public static void ntype(long paramLong, int paramInt) {
/* 354 */     UNSAFE.putInt(null, paramLong + TYPE, paramInt);
/*     */   } public static void nserial(long paramLong1, long paramLong2) {
/* 356 */     MemoryUtil.memPutCLong(paramLong1 + SERIAL, paramLong2);
/*     */   } public static void nsend_event(long paramLong, int paramInt) {
/* 358 */     UNSAFE.putInt(null, paramLong + SEND_EVENT, paramInt);
/*     */   } public static void ndisplay(long paramLong1, long paramLong2) {
/* 360 */     MemoryUtil.memPutAddress(paramLong1 + DISPLAY, Checks.check(paramLong2));
/*     */   } public static void nowner(long paramLong1, long paramLong2) {
/* 362 */     MemoryUtil.memPutCLong(paramLong1 + OWNER, paramLong2);
/*     */   } public static void nrequestor(long paramLong1, long paramLong2) {
/* 364 */     MemoryUtil.memPutCLong(paramLong1 + REQUESTOR, paramLong2);
/*     */   } public static void nselection(long paramLong1, long paramLong2) {
/* 366 */     MemoryUtil.memPutCLong(paramLong1 + SELECTION, paramLong2);
/*     */   } public static void ntarget(long paramLong1, long paramLong2) {
/* 368 */     MemoryUtil.memPutCLong(paramLong1 + TARGET, paramLong2);
/*     */   } public static void nproperty(long paramLong1, long paramLong2) {
/* 370 */     MemoryUtil.memPutCLong(paramLong1 + PROPERTY, paramLong2);
/*     */   } public static void ntime(long paramLong1, long paramLong2) {
/* 372 */     MemoryUtil.memPutCLong(paramLong1 + TIME, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 380 */     Checks.check(MemoryUtil.memGetAddress(paramLong + DISPLAY));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<XSelectionRequestEvent, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 388 */     private static final XSelectionRequestEvent ELEMENT_FACTORY = XSelectionRequestEvent.create(-1L);
/*     */ 
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
/* 400 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / XSelectionRequestEvent.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 404 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 408 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 413 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected XSelectionRequestEvent getElementFactory() {
/* 418 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int type() {
/* 422 */       return XSelectionRequestEvent.ntype(address());
/*     */     } @NativeType("unsigned long")
/*     */     public long serial() {
/* 425 */       return XSelectionRequestEvent.nserial(address());
/*     */     } @NativeType("Bool")
/*     */     public boolean send_event() {
/* 428 */       return (XSelectionRequestEvent.nsend_event(address()) != 0);
/*     */     } @NativeType("Display *")
/*     */     public long display() {
/* 431 */       return XSelectionRequestEvent.ndisplay(address());
/*     */     } @NativeType("Window")
/*     */     public long owner() {
/* 434 */       return XSelectionRequestEvent.nowner(address());
/*     */     } @NativeType("Window")
/*     */     public long requestor() {
/* 437 */       return XSelectionRequestEvent.nrequestor(address());
/*     */     } @NativeType("Atom")
/*     */     public long selection() {
/* 440 */       return XSelectionRequestEvent.nselection(address());
/*     */     } @NativeType("Atom")
/*     */     public long target() {
/* 443 */       return XSelectionRequestEvent.ntarget(address());
/*     */     } @NativeType("Atom")
/*     */     public long property() {
/* 446 */       return XSelectionRequestEvent.nproperty(address());
/*     */     } @NativeType("Time")
/*     */     public long time() {
/* 449 */       return XSelectionRequestEvent.ntime(address());
/*     */     }
/*     */     public Buffer type(int param1Int) {
/* 452 */       XSelectionRequestEvent.ntype(address(), param1Int); return this;
/*     */     } public Buffer serial(@NativeType("unsigned long") long param1Long) {
/* 454 */       XSelectionRequestEvent.nserial(address(), param1Long); return this;
/*     */     } public Buffer send_event(@NativeType("Bool") boolean param1Boolean) {
/* 456 */       XSelectionRequestEvent.nsend_event(address(), param1Boolean ? 1 : 0); return this;
/*     */     } public Buffer display(@NativeType("Display *") long param1Long) {
/* 458 */       XSelectionRequestEvent.ndisplay(address(), param1Long); return this;
/*     */     } public Buffer owner(@NativeType("Window") long param1Long) {
/* 460 */       XSelectionRequestEvent.nowner(address(), param1Long); return this;
/*     */     } public Buffer requestor(@NativeType("Window") long param1Long) {
/* 462 */       XSelectionRequestEvent.nrequestor(address(), param1Long); return this;
/*     */     } public Buffer selection(@NativeType("Atom") long param1Long) {
/* 464 */       XSelectionRequestEvent.nselection(address(), param1Long); return this;
/*     */     } public Buffer target(@NativeType("Atom") long param1Long) {
/* 466 */       XSelectionRequestEvent.ntarget(address(), param1Long); return this;
/*     */     } public Buffer property(@NativeType("Atom") long param1Long) {
/* 468 */       XSelectionRequestEvent.nproperty(address(), param1Long); return this;
/*     */     } public Buffer time(@NativeType("Time") long param1Long) {
/* 470 */       XSelectionRequestEvent.ntime(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\XSelectionRequestEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */