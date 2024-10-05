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
/*     */ public class DISPLAY_DEVICE
/*     */   extends Struct<DISPLAY_DEVICE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CB;
/*     */   public static final int DEVICENAME;
/*     */   public static final int DEVICESTRING;
/*     */   public static final int STATEFLAGS;
/*     */   public static final int DEVICEID;
/*     */   public static final int DEVICEKEY;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  64 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(4), __array(2, 32), __array(2, 128), __member(4), __array(2, 128), __array(2, 128) })).getSize();
/*  65 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  67 */     CB = layout.offsetof(0);
/*  68 */     DEVICENAME = layout.offsetof(1);
/*  69 */     DEVICESTRING = layout.offsetof(2);
/*  70 */     STATEFLAGS = layout.offsetof(3);
/*  71 */     DEVICEID = layout.offsetof(4);
/*  72 */     DEVICEKEY = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected DISPLAY_DEVICE(long paramLong, ByteBuffer paramByteBuffer) {
/*  76 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected DISPLAY_DEVICE create(long paramLong, ByteBuffer paramByteBuffer) {
/*  81 */     return new DISPLAY_DEVICE(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DISPLAY_DEVICE(ByteBuffer paramByteBuffer) {
/*  91 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  95 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int cb() {
/*  99 */     return ncb(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public ByteBuffer DeviceName() {
/* 102 */     return nDeviceName(address());
/*     */   } @NativeType("TCHAR[32]")
/*     */   public String DeviceNameString() {
/* 105 */     return nDeviceNameString(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public ByteBuffer DeviceString() {
/* 108 */     return nDeviceString(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public String DeviceStringString() {
/* 111 */     return nDeviceStringString(address());
/*     */   } @NativeType("DWORD")
/*     */   public int StateFlags() {
/* 114 */     return nStateFlags(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public ByteBuffer DeviceID() {
/* 117 */     return nDeviceID(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public String DeviceIDString() {
/* 120 */     return nDeviceIDString(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public ByteBuffer DeviceKey() {
/* 123 */     return nDeviceKey(address());
/*     */   } @NativeType("TCHAR[128]")
/*     */   public String DeviceKeyString() {
/* 126 */     return nDeviceKeyString(address());
/*     */   }
/*     */   public DISPLAY_DEVICE cb(@NativeType("DWORD") int paramInt) {
/* 129 */     ncb(address(), paramInt); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DISPLAY_DEVICE set(DISPLAY_DEVICE paramDISPLAY_DEVICE) {
/* 139 */     MemoryUtil.memCopy(paramDISPLAY_DEVICE.address(), address(), SIZEOF);
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE malloc() {
/* 147 */     return new DISPLAY_DEVICE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE calloc() {
/* 152 */     return new DISPLAY_DEVICE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE create() {
/* 157 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 158 */     return new DISPLAY_DEVICE(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE create(long paramLong) {
/* 163 */     return new DISPLAY_DEVICE(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE createSafe(long paramLong) {
/* 169 */     return (paramLong == 0L) ? null : new DISPLAY_DEVICE(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt) {
/* 178 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(paramInt, SIZEOF)), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt) {
/* 187 */     return new Buffer(MemoryUtil.nmemCallocChecked(paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int paramInt) {
/* 196 */     ByteBuffer byteBuffer = __create(paramInt, SIZEOF);
/* 197 */     return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, paramInt, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long paramLong, int paramInt) {
/* 207 */     return new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long paramLong, int paramInt) {
/* 213 */     return (paramLong == 0L) ? null : new Buffer(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static DISPLAY_DEVICE mallocStack() {
/* 219 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 221 */   public static DISPLAY_DEVICE callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 223 */   public static DISPLAY_DEVICE mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); }
/*     */   @Deprecated
/* 225 */   public static DISPLAY_DEVICE callocStack(MemoryStack paramMemoryStack) { return calloc(paramMemoryStack); }
/*     */   @Deprecated
/* 227 */   public static Buffer mallocStack(int paramInt) { return malloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 229 */   public static Buffer callocStack(int paramInt) { return calloc(paramInt, MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 231 */   public static Buffer mallocStack(int paramInt, MemoryStack paramMemoryStack) { return malloc(paramInt, paramMemoryStack); } @Deprecated
/*     */   public static Buffer callocStack(int paramInt, MemoryStack paramMemoryStack) {
/* 233 */     return calloc(paramInt, paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE malloc(MemoryStack paramMemoryStack) {
/* 241 */     return new DISPLAY_DEVICE(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DISPLAY_DEVICE calloc(MemoryStack paramMemoryStack) {
/* 250 */     return new DISPLAY_DEVICE(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int paramInt, MemoryStack paramMemoryStack) {
/* 260 */     return new Buffer(paramMemoryStack.nmalloc(ALIGNOF, paramInt * SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int paramInt, MemoryStack paramMemoryStack) {
/* 270 */     return new Buffer(paramMemoryStack.ncalloc(ALIGNOF, paramInt, SIZEOF), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncb(long paramLong) {
/* 276 */     return UNSAFE.getInt(null, paramLong + CB);
/*     */   } public static ByteBuffer nDeviceName(long paramLong) {
/* 278 */     return MemoryUtil.memByteBuffer(paramLong + DEVICENAME, 64);
/*     */   } public static String nDeviceNameString(long paramLong) {
/* 280 */     return MemoryUtil.memUTF16(paramLong + DEVICENAME);
/*     */   } public static ByteBuffer nDeviceString(long paramLong) {
/* 282 */     return MemoryUtil.memByteBuffer(paramLong + DEVICESTRING, 256);
/*     */   } public static String nDeviceStringString(long paramLong) {
/* 284 */     return MemoryUtil.memUTF16(paramLong + DEVICESTRING);
/*     */   } public static int nStateFlags(long paramLong) {
/* 286 */     return UNSAFE.getInt(null, paramLong + STATEFLAGS);
/*     */   } public static ByteBuffer nDeviceID(long paramLong) {
/* 288 */     return MemoryUtil.memByteBuffer(paramLong + DEVICEID, 256);
/*     */   } public static String nDeviceIDString(long paramLong) {
/* 290 */     return MemoryUtil.memUTF16(paramLong + DEVICEID);
/*     */   } public static ByteBuffer nDeviceKey(long paramLong) {
/* 292 */     return MemoryUtil.memByteBuffer(paramLong + DEVICEKEY, 256);
/*     */   } public static String nDeviceKeyString(long paramLong) {
/* 294 */     return MemoryUtil.memUTF16(paramLong + DEVICEKEY);
/*     */   }
/*     */   public static void ncb(long paramLong, int paramInt) {
/* 297 */     UNSAFE.putInt(null, paramLong + CB, paramInt);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<DISPLAY_DEVICE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 304 */     private static final DISPLAY_DEVICE ELEMENT_FACTORY = DISPLAY_DEVICE.create(-1L);
/*     */ 
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
/* 316 */       super(param1ByteBuffer, param1ByteBuffer.remaining() / DISPLAY_DEVICE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long param1Long, int param1Int) {
/* 320 */       super(param1Long, null, -1, 0, param1Int, param1Int);
/*     */     }
/*     */     
/*     */     Buffer(long param1Long, ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 324 */       super(param1Long, param1ByteBuffer, param1Int1, param1Int2, param1Int3, param1Int4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 329 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected DISPLAY_DEVICE getElementFactory() {
/* 334 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("DWORD")
/*     */     public int cb() {
/* 339 */       return DISPLAY_DEVICE.ncb(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public ByteBuffer DeviceName() {
/* 342 */       return DISPLAY_DEVICE.nDeviceName(address());
/*     */     } @NativeType("TCHAR[32]")
/*     */     public String DeviceNameString() {
/* 345 */       return DISPLAY_DEVICE.nDeviceNameString(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public ByteBuffer DeviceString() {
/* 348 */       return DISPLAY_DEVICE.nDeviceString(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public String DeviceStringString() {
/* 351 */       return DISPLAY_DEVICE.nDeviceStringString(address());
/*     */     } @NativeType("DWORD")
/*     */     public int StateFlags() {
/* 354 */       return DISPLAY_DEVICE.nStateFlags(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public ByteBuffer DeviceID() {
/* 357 */       return DISPLAY_DEVICE.nDeviceID(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public String DeviceIDString() {
/* 360 */       return DISPLAY_DEVICE.nDeviceIDString(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public ByteBuffer DeviceKey() {
/* 363 */       return DISPLAY_DEVICE.nDeviceKey(address());
/*     */     } @NativeType("TCHAR[128]")
/*     */     public String DeviceKeyString() {
/* 366 */       return DISPLAY_DEVICE.nDeviceKeyString(address());
/*     */     }
/*     */     public Buffer cb(@NativeType("DWORD") int param1Int) {
/* 369 */       DISPLAY_DEVICE.ncb(address(), param1Int); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\DISPLAY_DEVICE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */