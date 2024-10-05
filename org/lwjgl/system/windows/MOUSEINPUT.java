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
/*     */ public class MOUSEINPUT
/*     */   extends Struct<MOUSEINPUT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int DX;
/*     */   public static final int DY;
/*     */   public static final int MOUSEDATA;
/*     */   public static final int DWFLAGS;
/*     */   public static final int TIME;
/*     */   public static final int DWEXTRAINFO;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  60 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(4), __member(4), __member(4), __member(4), __member(POINTER_SIZE) })).getSize();
/*  61 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  63 */     DX = layout.offsetof(0);
/*  64 */     DY = layout.offsetof(1);
/*  65 */     MOUSEDATA = layout.offsetof(2);
/*  66 */     DWFLAGS = layout.offsetof(3);
/*  67 */     TIME = layout.offsetof(4);
/*  68 */     DWEXTRAINFO = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected MOUSEINPUT(long paramLong, ByteBuffer paramByteBuffer) {
/*  72 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected MOUSEINPUT create(long paramLong, ByteBuffer paramByteBuffer) {
/*  77 */     return new MOUSEINPUT(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MOUSEINPUT(ByteBuffer paramByteBuffer) {
/*  87 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  91 */     return SIZEOF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("LONG")
/*     */   public int dx() {
/* 100 */     return ndx(address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("LONG")
/*     */   public int dy() {
/* 108 */     return ndy(address());
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
/*     */   @NativeType("DWORD")
/*     */   public int mouseData() {
/* 124 */     return nmouseData(address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int dwFlags() {
/* 136 */     return ndwFlags(address());
/*     */   } @NativeType("DWORD")
/*     */   public int time() {
/* 139 */     return ntime(address());
/*     */   } @NativeType("ULONG_PTR")
/*     */   public long dwExtraInfo() {
/* 142 */     return ndwExtraInfo(address());
/*     */   }
/*     */   public MOUSEINPUT dx(@NativeType("LONG") int paramInt) {
/* 145 */     ndx(address(), paramInt); return this;
/*     */   } public MOUSEINPUT dy(@NativeType("LONG") int paramInt) {
/* 147 */     ndy(address(), paramInt); return this;
/*     */   } public MOUSEINPUT mouseData(@NativeType("DWORD") int paramInt) {
/* 149 */     nmouseData(address(), paramInt); return this;
/*     */   } public MOUSEINPUT dwFlags(@NativeType("DWORD") int paramInt) {
/* 151 */     ndwFlags(address(), paramInt); return this;
/*     */   } public MOUSEINPUT time(@NativeType("DWORD") int paramInt) {
/* 153 */     ntime(address(), paramInt); return this;
/*     */   } public MOUSEINPUT dwExtraInfo(@NativeType("ULONG_PTR") long paramLong) {
/* 155 */     ndwExtraInfo(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MOUSEINPUT set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong) {
/* 166 */     dx(paramInt1);
/* 167 */     dy(paramInt2);
/* 168 */     mouseData(paramInt3);
/* 169 */     dwFlags(paramInt4);
/* 170 */     time(paramInt5);
/* 171 */     dwExtraInfo(paramLong);
/*     */     
/* 173 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MOUSEINPUT set(MOUSEINPUT paramMOUSEINPUT) {
/* 184 */     MemoryUtil.memCopy(paramMOUSEINPUT.address(), address(), SIZEOF);
/* 185 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT malloc() {
/* 192 */     return new MOUSEINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT calloc() {
/* 197 */     return new MOUSEINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT create() {
/* 202 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 203 */     return new MOUSEINPUT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT create(long paramLong) {
/* 208 */     return new MOUSEINPUT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT createSafe(long paramLong) {
/* 214 */     return (paramLong == 0L) ? null : new MOUSEINPUT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 223 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 232 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 241 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 242 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 252 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 258 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static MOUSEINPUT mallocStack() {
/* 264 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 266 */   public static MOUSEINPUT callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 268 */   public static MOUSEINPUT mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 270 */   public static MOUSEINPUT callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 272 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 274 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 276 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 278 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT malloc(MemoryStack paramMemoryStack) {
/* 286 */     return new MOUSEINPUT(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MOUSEINPUT calloc(MemoryStack paramMemoryStack) {
/* 295 */     return new MOUSEINPUT(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 305 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 315 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ndx(long paramLong) {
/* 321 */     return UNSAFE.getInt(null, paramLong + DX);
/*     */   } public static int ndy(long paramLong) {
/* 323 */     return UNSAFE.getInt(null, paramLong + DY);
/*     */   } public static int nmouseData(long paramLong) {
/* 325 */     return UNSAFE.getInt(null, paramLong + MOUSEDATA);
/*     */   } public static int ndwFlags(long paramLong) {
/* 327 */     return UNSAFE.getInt(null, paramLong + DWFLAGS);
/*     */   } public static int ntime(long paramLong) {
/* 329 */     return UNSAFE.getInt(null, paramLong + TIME);
/*     */   } public static long ndwExtraInfo(long paramLong) {
/* 331 */     return MemoryUtil.memGetAddress(paramLong + DWEXTRAINFO);
/*     */   }
/*     */   public static void ndx(long paramLong, int paramInt) {
/* 334 */     UNSAFE.putInt(null, paramLong + DX, paramInt);
/*     */   } public static void ndy(long paramLong, int paramInt) {
/* 336 */     UNSAFE.putInt(null, paramLong + DY, paramInt);
/*     */   } public static void nmouseData(long paramLong, int paramInt) {
/* 338 */     UNSAFE.putInt(null, paramLong + MOUSEDATA, paramInt);
/*     */   } public static void ndwFlags(long paramLong, int paramInt) {
/* 340 */     UNSAFE.putInt(null, paramLong + DWFLAGS, paramInt);
/*     */   } public static void ntime(long paramLong, int paramInt) {
/* 342 */     UNSAFE.putInt(null, paramLong + TIME, paramInt);
/*     */   } public static void ndwExtraInfo(long paramLong1, long paramLong2) {
/* 344 */     MemoryUtil.memPutAddress(paramLong1 + DWEXTRAINFO, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<MOUSEINPUT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 351 */     private static final MOUSEINPUT ELEMENT_FACTORY = MOUSEINPUT.create(-1L);
/*     */ 
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
/* 363 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / MOUSEINPUT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 367 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 371 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 376 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected MOUSEINPUT getElementFactory() {
/* 381 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("LONG")
/*     */     public int dx() {
/* 386 */       return MOUSEINPUT.ndx(address());
/*     */     } @NativeType("LONG")
/*     */     public int dy() {
/* 389 */       return MOUSEINPUT.ndy(address());
/*     */     } @NativeType("DWORD")
/*     */     public int mouseData() {
/* 392 */       return MOUSEINPUT.nmouseData(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwFlags() {
/* 395 */       return MOUSEINPUT.ndwFlags(address());
/*     */     } @NativeType("DWORD")
/*     */     public int time() {
/* 398 */       return MOUSEINPUT.ntime(address());
/*     */     } @NativeType("ULONG_PTR")
/*     */     public long dwExtraInfo() {
/* 401 */       return MOUSEINPUT.ndwExtraInfo(address());
/*     */     }
/*     */     public Buffer dx(@NativeType("LONG") int param1Int) {
/* 404 */       MOUSEINPUT.ndx(address(), param1Int); return this;
/*     */     } public Buffer dy(@NativeType("LONG") int param1Int) {
/* 406 */       MOUSEINPUT.ndy(address(), param1Int); return this;
/*     */     } public Buffer mouseData(@NativeType("DWORD") int param1Int) {
/* 408 */       MOUSEINPUT.nmouseData(address(), param1Int); return this;
/*     */     } public Buffer dwFlags(@NativeType("DWORD") int param1Int) {
/* 410 */       MOUSEINPUT.ndwFlags(address(), param1Int); return this;
/*     */     } public Buffer time(@NativeType("DWORD") int param1Int) {
/* 412 */       MOUSEINPUT.ntime(address(), param1Int); return this;
/*     */     } public Buffer dwExtraInfo(@NativeType("ULONG_PTR") long param1Long) {
/* 414 */       MOUSEINPUT.ndwExtraInfo(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\MOUSEINPUT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */