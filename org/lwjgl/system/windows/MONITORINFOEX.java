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
/*     */ public class MONITORINFOEX
/*     */   extends Struct<MONITORINFOEX>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CBSIZE;
/*     */   public static final int RCMONITOR;
/*     */   public static final int RCWORK;
/*     */   public static final int DWFLAGS;
/*     */   public static final int SZDEVICE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  57 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __member(RECT.SIZEOF, RECT.ALIGNOF), __member(RECT.SIZEOF, RECT.ALIGNOF), __member(4), __array(2, 32) })).getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     CBSIZE = layout.offsetof(0);
/*  61 */     RCMONITOR = layout.offsetof(1);
/*  62 */     RCWORK = layout.offsetof(2);
/*  63 */     DWFLAGS = layout.offsetof(3);
/*  64 */     SZDEVICE = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected MONITORINFOEX(long paramLong, ByteBuffer paramByteBuffer) {
/*  68 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected MONITORINFOEX create(long paramLong, ByteBuffer paramByteBuffer) {
/*  73 */     return new MONITORINFOEX(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MONITORINFOEX(ByteBuffer paramByteBuffer) {
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
/*     */   
/*     */   @NativeType("DWORD")
/*     */   public int cbSize() {
/*  96 */     return ncbSize(address());
/*     */   }
/*     */ 
/*     */   
/*     */   public RECT rcMonitor() {
/* 101 */     return nrcMonitor(address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RECT rcWork() {
/* 108 */     return nrcWork(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwFlags() {
/* 111 */     return ndwFlags(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public ByteBuffer szDevice() {
/* 114 */     return nszDevice(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public String szDeviceString() {
/* 117 */     return nszDeviceString(address());
/*     */   }
/*     */   public MONITORINFOEX cbSize(@NativeType("DWORD") int paramInt) {
/* 120 */     ncbSize(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MONITORINFOEX set(MONITORINFOEX paramMONITORINFOEX) {
/* 130 */     MemoryUtil.memCopy(paramMONITORINFOEX.address(), address(), SIZEOF);
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX malloc() {
/* 138 */     return new MONITORINFOEX(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX calloc() {
/* 143 */     return new MONITORINFOEX(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX create() {
/* 148 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 149 */     return new MONITORINFOEX(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX create(long paramLong) {
/* 154 */     return new MONITORINFOEX(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX createSafe(long paramLong) {
/* 160 */     return (paramLong == 0L) ? null : new MONITORINFOEX(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 169 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 178 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 187 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 188 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 198 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 204 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static MONITORINFOEX mallocStack() {
/* 210 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 212 */   public static MONITORINFOEX callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 214 */   public static MONITORINFOEX mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 216 */   public static MONITORINFOEX callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 218 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 220 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 222 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 224 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX malloc(MemoryStack paramMemoryStack) {
/* 232 */     return new MONITORINFOEX(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MONITORINFOEX calloc(MemoryStack paramMemoryStack) {
/* 241 */     return new MONITORINFOEX(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 251 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 261 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncbSize(long paramLong) {
/* 267 */     return UNSAFE.getInt(null, paramLong + CBSIZE);
/*     */   } public static RECT nrcMonitor(long paramLong) {
/* 269 */     return RECT.create(paramLong + RCMONITOR);
/*     */   } public static RECT nrcWork(long paramLong) {
/* 271 */     return RECT.create(paramLong + RCWORK);
/*     */   } public static int ndwFlags(long paramLong) {
/* 273 */     return UNSAFE.getInt(null, paramLong + DWFLAGS);
/*     */   } public static ByteBuffer nszDevice(long paramLong) {
/* 275 */     return MemoryUtil.memByteBuffer(paramLong + SZDEVICE, 64);
/*     */   } public static String nszDeviceString(long paramLong) {
/* 277 */     return MemoryUtil.memUTF16(paramLong + SZDEVICE);
/*     */   }
/*     */   public static void ncbSize(long paramLong, int paramInt) {
/* 280 */     UNSAFE.putInt(null, paramLong + CBSIZE, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<MONITORINFOEX, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 287 */     private static final MONITORINFOEX ELEMENT_FACTORY = MONITORINFOEX.create(-1L);
/*     */ 
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
/* 299 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / MONITORINFOEX.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 303 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 307 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 312 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected MONITORINFOEX getElementFactory() {
/* 317 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int cbSize() {
/* 322 */       return MONITORINFOEX.ncbSize(address());
/*     */     } public RECT rcMonitor() {
/* 324 */       return MONITORINFOEX.nrcMonitor(address());
/*     */     } public RECT rcWork() {
/* 326 */       return MONITORINFOEX.nrcWork(address());
/*     */     } @NativeType("DWORD")
/*     */     public int dwFlags() {
/* 329 */       return MONITORINFOEX.ndwFlags(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public ByteBuffer szDevice() {
/* 332 */       return MONITORINFOEX.nszDevice(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public String szDeviceString() {
/* 335 */       return MONITORINFOEX.nszDeviceString(address());
/*     */     }
/*     */     public Buffer cbSize(@NativeType("DWORD") int param1Int) {
/* 338 */       MONITORINFOEX.ncbSize(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\MONITORINFOEX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */