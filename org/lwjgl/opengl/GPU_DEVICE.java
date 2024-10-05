/*     */ package org.lwjgl.opengl;
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
/*     */ import org.lwjgl.system.windows.RECT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GPU_DEVICE
/*     */   extends Struct<GPU_DEVICE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CB;
/*     */   public static final int DEVICENAME;
/*     */   public static final int DEVICESTRING;
/*     */   public static final int FLAGS;
/*     */   public static final int RCVIRTUALSCREEN;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  59 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __array(1, 32), __array(1, 128), __member(4), __member(RECT.SIZEOF, RECT.ALIGNOF) })).getSize();
/*  60 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  62 */     CB = layout.offsetof(0);
/*  63 */     DEVICENAME = layout.offsetof(1);
/*  64 */     DEVICESTRING = layout.offsetof(2);
/*  65 */     FLAGS = layout.offsetof(3);
/*  66 */     RCVIRTUALSCREEN = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected GPU_DEVICE(long paramLong, ByteBuffer paramByteBuffer) {
/*  70 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GPU_DEVICE create(long paramLong, ByteBuffer paramByteBuffer) {
/*  75 */     return new GPU_DEVICE(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GPU_DEVICE(ByteBuffer paramByteBuffer) {
/*  85 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  89 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int cb() {
/*  93 */     return ncb(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CHAR[32]")
/*     */   public ByteBuffer DeviceName() {
/*  99 */     return nDeviceName(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CHAR[32]")
/*     */   public String DeviceNameString() {
/* 105 */     return nDeviceNameString(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CHAR[128]")
/*     */   public ByteBuffer DeviceString() {
/* 111 */     return nDeviceString(address());
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CHAR[128]")
/*     */   public String DeviceStringString() {
/* 117 */     return nDeviceStringString(address());
/*     */   } @NativeType("DWORD")
/*     */   public int Flags() {
/* 120 */     return nFlags(address());
/*     */   }
/*     */ 
/*     */   
/*     */   public RECT rcVirtualScreen() {
/* 125 */     return nrcVirtualScreen(address());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE malloc() {
/* 131 */     return new GPU_DEVICE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE calloc() {
/* 136 */     return new GPU_DEVICE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE create() {
/* 141 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 142 */     return new GPU_DEVICE(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE create(long paramLong) {
/* 147 */     return new GPU_DEVICE(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE createSafe(long paramLong) {
/* 153 */     return (paramLong == 0L) ? null : new GPU_DEVICE(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 162 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 171 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 180 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 181 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 191 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 197 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static GPU_DEVICE mallocStack() {
/* 203 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 205 */   public static GPU_DEVICE callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 207 */   public static GPU_DEVICE mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 209 */   public static GPU_DEVICE callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 211 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 213 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 215 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 217 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE malloc(MemoryStack paramMemoryStack) {
/* 225 */     return new GPU_DEVICE(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GPU_DEVICE calloc(MemoryStack paramMemoryStack) {
/* 234 */     return new GPU_DEVICE(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 244 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 254 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncb(long paramLong) {
/* 260 */     return UNSAFE.getInt(null, paramLong + CB);
/*     */   } public static ByteBuffer nDeviceName(long paramLong) {
/* 262 */     return MemoryUtil.memByteBuffer(paramLong + DEVICENAME, 32);
/*     */   } public static String nDeviceNameString(long paramLong) {
/* 264 */     return MemoryUtil.memASCII(paramLong + DEVICENAME);
/*     */   } public static ByteBuffer nDeviceString(long paramLong) {
/* 266 */     return MemoryUtil.memByteBuffer(paramLong + DEVICESTRING, 128);
/*     */   } public static String nDeviceStringString(long paramLong) {
/* 268 */     return MemoryUtil.memASCII(paramLong + DEVICESTRING);
/*     */   } public static int nFlags(long paramLong) {
/* 270 */     return UNSAFE.getInt(null, paramLong + FLAGS);
/*     */   } public static RECT nrcVirtualScreen(long paramLong) {
/* 272 */     return RECT.create(paramLong + RCVIRTUALSCREEN);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GPU_DEVICE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 279 */     private static final GPU_DEVICE ELEMENT_FACTORY = GPU_DEVICE.create(-1L);
/*     */ 
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
/* 291 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / GPU_DEVICE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 295 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 299 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 304 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected GPU_DEVICE getElementFactory() {
/* 309 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int cb() {
/* 314 */       return GPU_DEVICE.ncb(address());
/*     */     } @NativeType("CHAR[32]")
/*     */     public ByteBuffer DeviceName() {
/* 317 */       return GPU_DEVICE.nDeviceName(address());
/*     */     } @NativeType("CHAR[32]")
/*     */     public String DeviceNameString() {
/* 320 */       return GPU_DEVICE.nDeviceNameString(address());
/*     */     } @NativeType("CHAR[128]")
/*     */     public ByteBuffer DeviceString() {
/* 323 */       return GPU_DEVICE.nDeviceString(address());
/*     */     } @NativeType("CHAR[128]")
/*     */     public String DeviceStringString() {
/* 326 */       return GPU_DEVICE.nDeviceStringString(address());
/*     */     } @NativeType("DWORD")
/*     */     public int Flags() {
/* 329 */       return GPU_DEVICE.nFlags(address());
/*     */     } public RECT rcVirtualScreen() {
/* 331 */       return GPU_DEVICE.nrcVirtualScreen(address());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GPU_DEVICE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */