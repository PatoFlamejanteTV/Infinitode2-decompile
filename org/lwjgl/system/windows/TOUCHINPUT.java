/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
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
/*     */ public class TOUCHINPUT
/*     */   extends Struct<TOUCHINPUT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int HSOURCE;
/*     */   public static final int DWID;
/*     */   public static final int DWFLAGS;
/*     */   public static final int DWMASK;
/*     */   public static final int DWTIME;
/*     */   public static final int DWEXTRAINFO;
/*     */   public static final int CXCONTACT;
/*     */   public static final int CYCONTACT;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  72 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(POINTER_SIZE), __member(4), __member(4), __member(4), __member(4), __member(POINTER_SIZE), __member(4), __member(4) })).getSize();
/*  73 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  75 */     X = layout.offsetof(0);
/*  76 */     Y = layout.offsetof(1);
/*  77 */     HSOURCE = layout.offsetof(2);
/*  78 */     DWID = layout.offsetof(3);
/*  79 */     DWFLAGS = layout.offsetof(4);
/*  80 */     DWMASK = layout.offsetof(5);
/*  81 */     DWTIME = layout.offsetof(6);
/*  82 */     DWEXTRAINFO = layout.offsetof(7);
/*  83 */     CXCONTACT = layout.offsetof(8);
/*  84 */     CYCONTACT = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected TOUCHINPUT(long paramLong, ByteBuffer paramByteBuffer) {
/*  88 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected TOUCHINPUT create(long paramLong, ByteBuffer paramByteBuffer) {
/*  93 */     return new TOUCHINPUT(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TOUCHINPUT(ByteBuffer paramByteBuffer) {
/* 103 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 107 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("LONG")
/*     */   public int x() {
/* 111 */     return nx(address());
/*     */   } @NativeType("LONG")
/*     */   public int y() {
/* 114 */     return ny(address());
/*     */   } @NativeType("HANDLE")
/*     */   public long hSource() {
/* 117 */     return nhSource(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dwID() {
/* 123 */     return ndwID(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dwFlags() {
/* 129 */     return ndwFlags(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dwMask() {
/* 136 */     return ndwMask(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dwTime() {
/* 143 */     return ndwTime(address());
/*     */   } @NativeType("ULONG_PTR")
/*     */   public long dwExtraInfo() {
/* 146 */     return ndwExtraInfo(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int cxContact() {
/* 152 */     return ncxContact(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int cyContact() {
/* 158 */     return ncyContact(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT malloc() {
/* 164 */     return new TOUCHINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT calloc() {
/* 169 */     return new TOUCHINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT create() {
/* 174 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 175 */     return new TOUCHINPUT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT create(long paramLong) {
/* 180 */     return new TOUCHINPUT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT createSafe(long paramLong) {
/* 186 */     return (paramLong == 0L) ? null : new TOUCHINPUT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 195 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 204 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 213 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 214 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 224 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 230 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static TOUCHINPUT mallocStack() {
/* 236 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 238 */   public static TOUCHINPUT callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 240 */   public static TOUCHINPUT mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 242 */   public static TOUCHINPUT callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 244 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 246 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 248 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 250 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT malloc(MemoryStack paramMemoryStack) {
/* 258 */     return new TOUCHINPUT(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TOUCHINPUT calloc(MemoryStack paramMemoryStack) {
/* 267 */     return new TOUCHINPUT(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 277 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 287 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nx(long paramLong) {
/* 293 */     return UNSAFE.getInt(null, paramLong + X);
/*     */   } public static int ny(long paramLong) {
/* 295 */     return UNSAFE.getInt(null, paramLong + Y);
/*     */   } public static long nhSource(long paramLong) {
/* 297 */     return MemoryUtil.memGetAddress(paramLong + HSOURCE);
/*     */   } public static int ndwID(long paramLong) {
/* 299 */     return UNSAFE.getInt(null, paramLong + DWID);
/*     */   } public static int ndwFlags(long paramLong) {
/* 301 */     return UNSAFE.getInt(null, paramLong + DWFLAGS);
/*     */   } public static int ndwMask(long paramLong) {
/* 303 */     return UNSAFE.getInt(null, paramLong + DWMASK);
/*     */   } public static int ndwTime(long paramLong) {
/* 305 */     return UNSAFE.getInt(null, paramLong + DWTIME);
/*     */   } public static long ndwExtraInfo(long paramLong) {
/* 307 */     return MemoryUtil.memGetAddress(paramLong + DWEXTRAINFO);
/*     */   } public static int ncxContact(long paramLong) {
/* 309 */     return UNSAFE.getInt(null, paramLong + CXCONTACT);
/*     */   } public static int ncyContact(long paramLong) {
/* 311 */     return UNSAFE.getInt(null, paramLong + CYCONTACT);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<TOUCHINPUT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 318 */     private static final TOUCHINPUT ELEMENT_FACTORY = TOUCHINPUT.create(-1L);
/*     */ 
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
/* 330 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / TOUCHINPUT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 334 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 338 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 343 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected TOUCHINPUT getElementFactory() {
/* 348 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("LONG")
/*     */     public int x() {
/* 353 */       return TOUCHINPUT.nx(address());
/*     */     } @NativeType("LONG")
/*     */     public int y() {
/* 356 */       return TOUCHINPUT.ny(address());
/*     */     } @NativeType("HANDLE")
/*     */     public long hSource() {
/* 359 */       return TOUCHINPUT.nhSource(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwID() {
/* 362 */       return TOUCHINPUT.ndwID(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwFlags() {
/* 365 */       return TOUCHINPUT.ndwFlags(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwMask() {
/* 368 */       return TOUCHINPUT.ndwMask(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwTime() {
/* 371 */       return TOUCHINPUT.ndwTime(address());
/*     */     } @NativeType("ULONG_PTR")
/*     */     public long dwExtraInfo() {
/* 374 */       return TOUCHINPUT.ndwExtraInfo(address());
/*     */     } @NativeType("DWORD")
/*     */     public int cxContact() {
/* 377 */       return TOUCHINPUT.ncxContact(address());
/*     */     } @NativeType("DWORD")
/*     */     public int cyContact() {
/* 380 */       return TOUCHINPUT.ncyContact(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\TOUCHINPUT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */