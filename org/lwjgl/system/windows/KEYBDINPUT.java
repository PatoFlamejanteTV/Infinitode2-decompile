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
/*     */ public class KEYBDINPUT
/*     */   extends Struct<KEYBDINPUT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int WVK;
/*     */   public static final int WSCAN;
/*     */   public static final int DWFLAGS;
/*     */   public static final int TIME;
/*     */   public static final int DWEXTRAINFO;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  57 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(2), __member(2), __member(4), __member(4), __member(POINTER_SIZE) })).getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     WVK = layout.offsetof(0);
/*  61 */     WSCAN = layout.offsetof(1);
/*  62 */     DWFLAGS = layout.offsetof(2);
/*  63 */     TIME = layout.offsetof(3);
/*  64 */     DWEXTRAINFO = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected KEYBDINPUT(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected KEYBDINPUT create(long paramLong, ByteBuffer paramByteBuffer) {
/*  73 */     return new KEYBDINPUT(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KEYBDINPUT(ByteBuffer paramByteBuffer) {
/*  83 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  87 */     return SIZEOF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("WORD")
/*     */   public short wVk() {
/*  95 */     return nwVk(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("WORD")
/*     */   public short wScan() {
/* 102 */     return nwScan(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwFlags() {
/* 105 */     return ndwFlags(address());
/*     */   } @NativeType("DWORD")
/*     */   public int time() {
/* 108 */     return ntime(address());
/*     */   } @NativeType("ULONG_PTR")
/*     */   public long dwExtraInfo() {
/* 111 */     return ndwExtraInfo(address());
/*     */   }
/*     */   public KEYBDINPUT wVk(@NativeType("WORD") short paramShort) {
/* 114 */     nwVk(address(), paramShort); return this;
/*     */   } public KEYBDINPUT wScan(@NativeType("WORD") short paramShort) {
/* 116 */     nwScan(address(), paramShort); return this;
/*     */   } public KEYBDINPUT dwFlags(@NativeType("DWORD") int paramInt) {
/* 118 */     ndwFlags(address(), paramInt); return this;
/*     */   } public KEYBDINPUT time(@NativeType("DWORD") int paramInt) {
/* 120 */     ntime(address(), paramInt); return this;
/*     */   } public KEYBDINPUT dwExtraInfo(@NativeType("ULONG_PTR") long paramLong) {
/* 122 */     ndwExtraInfo(address(), paramLong); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KEYBDINPUT set(short paramShort1, short paramShort2, int paramInt1, int paramInt2, long paramLong) {
/* 132 */     wVk(paramShort1);
/* 133 */     wScan(paramShort2);
/* 134 */     dwFlags(paramInt1);
/* 135 */     time(paramInt2);
/* 136 */     dwExtraInfo(paramLong);
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
/*     */   public KEYBDINPUT set(KEYBDINPUT paramKEYBDINPUT) {
/* 149 */     MemoryUtil.memCopy(paramKEYBDINPUT.address(), address(), SIZEOF);
/* 150 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT malloc() {
/* 157 */     return new KEYBDINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT calloc() {
/* 162 */     return new KEYBDINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT create() {
/* 167 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 168 */     return new KEYBDINPUT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT create(long paramLong) {
/* 173 */     return new KEYBDINPUT(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT createSafe(long paramLong) {
/* 179 */     return (paramLong == 0L) ? null : new KEYBDINPUT(paramLong, null);
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
/*     */   public static KEYBDINPUT mallocStack() {
/* 229 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 231 */   public static KEYBDINPUT callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 233 */   public static KEYBDINPUT mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 235 */   public static KEYBDINPUT callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
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
/*     */   public static KEYBDINPUT malloc(MemoryStack paramMemoryStack) {
/* 251 */     return new KEYBDINPUT(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static KEYBDINPUT calloc(MemoryStack paramMemoryStack) {
/* 260 */     return new KEYBDINPUT(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static short nwVk(long paramLong) {
/* 286 */     return UNSAFE.getShort(null, paramLong + WVK);
/*     */   } public static short nwScan(long paramLong) {
/* 288 */     return UNSAFE.getShort(null, paramLong + WSCAN);
/*     */   } public static int ndwFlags(long paramLong) {
/* 290 */     return UNSAFE.getInt(null, paramLong + DWFLAGS);
/*     */   } public static int ntime(long paramLong) {
/* 292 */     return UNSAFE.getInt(null, paramLong + TIME);
/*     */   } public static long ndwExtraInfo(long paramLong) {
/* 294 */     return MemoryUtil.memGetAddress(paramLong + DWEXTRAINFO);
/*     */   }
/*     */   public static void nwVk(long paramLong, short paramShort) {
/* 297 */     UNSAFE.putShort(null, paramLong + WVK, paramShort);
/*     */   } public static void nwScan(long paramLong, short paramShort) {
/* 299 */     UNSAFE.putShort(null, paramLong + WSCAN, paramShort);
/*     */   } public static void ndwFlags(long paramLong, int paramInt) {
/* 301 */     UNSAFE.putInt(null, paramLong + DWFLAGS, paramInt);
/*     */   } public static void ntime(long paramLong, int paramInt) {
/* 303 */     UNSAFE.putInt(null, paramLong + TIME, paramInt);
/*     */   } public static void ndwExtraInfo(long paramLong1, long paramLong2) {
/* 305 */     MemoryUtil.memPutAddress(paramLong1 + DWEXTRAINFO, paramLong2);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<KEYBDINPUT, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 312 */     private static final KEYBDINPUT ELEMENT_FACTORY = KEYBDINPUT.create(-1L);
/*     */ 
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
/* 324 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / KEYBDINPUT.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 328 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 332 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 337 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected KEYBDINPUT getElementFactory() {
/* 342 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("WORD")
/*     */     public short wVk() {
/* 347 */       return KEYBDINPUT.nwVk(address());
/*     */     } @NativeType("WORD")
/*     */     public short wScan() {
/* 350 */       return KEYBDINPUT.nwScan(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwFlags() {
/* 353 */       return KEYBDINPUT.ndwFlags(address());
/*     */     } @NativeType("DWORD")
/*     */     public int time() {
/* 356 */       return KEYBDINPUT.ntime(address());
/*     */     } @NativeType("ULONG_PTR")
/*     */     public long dwExtraInfo() {
/* 359 */       return KEYBDINPUT.ndwExtraInfo(address());
/*     */     }
/*     */     public Buffer wVk(@NativeType("WORD") short param1Short) {
/* 362 */       KEYBDINPUT.nwVk(address(), param1Short); return this;
/*     */     } public Buffer wScan(@NativeType("WORD") short param1Short) {
/* 364 */       KEYBDINPUT.nwScan(address(), param1Short); return this;
/*     */     } public Buffer dwFlags(@NativeType("DWORD") int param1Int) {
/* 366 */       KEYBDINPUT.ndwFlags(address(), param1Int); return this;
/*     */     } public Buffer time(@NativeType("DWORD") int param1Int) {
/* 368 */       KEYBDINPUT.ntime(address(), param1Int); return this;
/*     */     } public Buffer dwExtraInfo(@NativeType("ULONG_PTR") long param1Long) {
/* 370 */       KEYBDINPUT.ndwExtraInfo(address(), param1Long); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\KEYBDINPUT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */