/*     */ package org.lwjgl.system.windows;public class GDI32 { public static final int DISPLAY_DEVICE_ATTACHED_TO_DESKTOP = 1; public static final int DISPLAY_DEVICE_MULTI_DRIVER = 2;
/*     */   public static final int DISPLAY_DEVICE_PRIMARY_DEVICE = 4;
/*     */   public static final int DISPLAY_DEVICE_MIRRORING_DRIVER = 8;
/*     */   public static final int DISPLAY_DEVICE_VGA_COMPATIBLE = 16;
/*     */   public static final int DISPLAY_DEVICE_REMOVABLE = 32;
/*     */   public static final int DISPLAY_DEVICE_MODESPRUNED = 134217728;
/*     */   public static final int DISPLAY_DEVICE_REMOTE = 67108864;
/*     */   public static final int DISPLAY_DEVICE_DISCONNECT = 33554432;
/*     */   public static final int DISPLAY_DEVICE_TS_COMPATIBLE = 2097152;
/*     */   public static final int DISPLAY_DEVICE_UNSAFE_MODES_ON = 524288;
/*     */   public static final int DISPLAY_DEVICE_ACTIVE = 1;
/*     */   public static final int DISPLAY_DEVICE_ATTACHED = 2;
/*     */   public static final int DM_SPECVERSION = 1025;
/*     */   public static final int DM_ORIENTATION = 1;
/*     */   public static final int DM_PAPERSIZE = 2;
/*     */   public static final int DM_PAPERLENGTH = 4;
/*     */   public static final int DM_PAPERWIDTH = 8;
/*     */   public static final int DM_SCALE = 16;
/*  19 */   private static final SharedLibrary GDI32 = Library.loadNative(GDI32.class, "org.lwjgl", "gdi32"); public static final int DM_POSITION = 32; public static final int DM_NUP = 64; public static final int DM_DISPLAYORIENTATION = 128; public static final int DM_COPIES = 256; public static final int DM_DEFAULTSOURCE = 512; public static final int DM_PRINTQUALITY = 1024; public static final int DM_COLOR = 2048; public static final int DM_DUPLEX = 4096; public static final int DM_YRESOLUTION = 8192; public static final int DM_TTOPTION = 16384; public static final int DM_COLLATE = 32768; public static final int DM_FORMNAME = 65536; public static final int DM_LOGPIXELS = 131072; public static final int DM_BITSPERPEL = 262144; public static final int DM_PELSWIDTH = 524288; public static final int DM_PELSHEIGHT = 1048576; public static final int DM_DISPLAYFLAGS = 2097152; public static final int DM_DISPLAYFREQUENCY = 4194304; public static final int DM_ICMMETHOD = 8388608; public static final int DM_ICMINTENT = 16777216; public static final int DM_MEDIATYPE = 33554432; public static final int DM_DITHERTYPE = 67108864; public static final int DM_PANNINGWIDTH = 134217728; public static final int DM_PANNINGHEIGHT = 268435456; public static final int DM_DISPLAYFIXEDOUTPUT = 536870912; public static final int DMDO_DEFAULT = 0; public static final int DMDO_90 = 1; public static final int DMDO_180 = 2; public static final int DMDO_270 = 3; public static final int DMDFO_DEFAULT = 0; public static final int DMDFO_STRETCH = 1; public static final int DMDFO_CENTER = 2; public static final int DM_INTERLACED = 2; public static final int DMDISPLAYFLAGS_TEXTMODE = 4; public static final int PFD_DOUBLEBUFFER = 1; public static final int PFD_STEREO = 2; public static final int PFD_DRAW_TO_WINDOW = 4; public static final int PFD_DRAW_TO_BITMAP = 8; public static final int PFD_SUPPORT_GDI = 16; public static final int PFD_SUPPORT_OPENGL = 32; public static final int PFD_GENERIC_FORMAT = 64; public static final int PFD_NEED_PALETTE = 128; public static final int PFD_NEED_SYSTEM_PALETTE = 256; public static final int PFD_SWAP_EXCHANGE = 512; public static final int PFD_SWAP_COPY = 1024; public static final int PFD_SWAP_LAYER_BUFFERS = 2048; public static final int PFD_GENERIC_ACCELERATED = 4096; public static final int PFD_SUPPORT_DIRECTDRAW = 8192; public static final int PFD_DIRECT3D_ACCELERATED = 16384; public static final int PFD_SUPPORT_COMPOSITION = 32768; public static final int PFD_DEPTH_DONTCARE = 536870912;
/*     */   public static final int PFD_DOUBLEBUFFER_DONTCARE = 1073741824;
/*     */   public static final int PFD_STEREO_DONTCARE = -2147483648;
/*     */   public static final byte PFD_TYPE_RGBA = 0;
/*     */   public static final byte PFD_TYPE_COLORINDEX = 1;
/*     */   public static final byte PFD_MAIN_PLANE = 0;
/*     */   public static final byte PFD_OVERLAY_PLANE = 1;
/*     */   public static final byte PFD_UNDERLAY_PLANE = -1;
/*     */   
/*  28 */   public static final class Functions { public static final long ChoosePixelFormat = APIUtil.apiGetFunctionAddress((FunctionProvider)GDI32.GDI32, "ChoosePixelFormat");
/*  29 */     public static final long DescribePixelFormat = APIUtil.apiGetFunctionAddress((FunctionProvider)GDI32.GDI32, "DescribePixelFormat");
/*  30 */     public static final long GetPixelFormat = APIUtil.apiGetFunctionAddress((FunctionProvider)GDI32.GDI32, "GetPixelFormat");
/*  31 */     public static final long SetPixelFormat = APIUtil.apiGetFunctionAddress((FunctionProvider)GDI32.GDI32, "SetPixelFormat");
/*  32 */     public static final long SwapBuffers = APIUtil.apiGetFunctionAddress((FunctionProvider)GDI32.GDI32, "SwapBuffers"); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  38 */     return GDI32;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected GDI32() {
/* 148 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nChoosePixelFormat(long paramLong1, long paramLong2) {
/* 158 */     long l = Functions.ChoosePixelFormat;
/* 159 */     if (Checks.CHECKS) {
/* 160 */       Checks.check(paramLong1);
/*     */     }
/* 162 */     return nChoosePixelFormat(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ChoosePixelFormat(@NativeType("HDC") long paramLong, @NativeType("PIXELFORMATDESCRIPTOR const *") PIXELFORMATDESCRIPTOR paramPIXELFORMATDESCRIPTOR) {
/* 172 */     return nChoosePixelFormat(paramLong, paramPIXELFORMATDESCRIPTOR.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nDescribePixelFormat(long paramLong1, int paramInt1, int paramInt2, long paramLong2) {
/* 182 */     long l = Functions.DescribePixelFormat;
/* 183 */     if (Checks.CHECKS) {
/* 184 */       Checks.check(paramLong1);
/*     */     }
/* 186 */     return nDescribePixelFormat(paramLong1, paramInt1, paramInt2, paramLong2, l);
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
/*     */ 
/*     */   
/*     */   public static int DescribePixelFormat(@NativeType("HDC") long paramLong, int paramInt1, @NativeType("UINT") int paramInt2, @NativeType("LPPIXELFORMATDESCRIPTOR") PIXELFORMATDESCRIPTOR paramPIXELFORMATDESCRIPTOR) {
/* 203 */     return nDescribePixelFormat(paramLong, paramInt1, paramInt2, MemoryUtil.memAddressSafe((Pointer)paramPIXELFORMATDESCRIPTOR));
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
/*     */   public static int DescribePixelFormat(@NativeType("HDC") long paramLong, int paramInt, @NativeType("LPPIXELFORMATDESCRIPTOR") PIXELFORMATDESCRIPTOR paramPIXELFORMATDESCRIPTOR) {
/* 218 */     return nDescribePixelFormat(paramLong, paramInt, PIXELFORMATDESCRIPTOR.SIZEOF, MemoryUtil.memAddressSafe((Pointer)paramPIXELFORMATDESCRIPTOR));
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
/*     */   public static int GetPixelFormat(@NativeType("HDC") long paramLong) {
/* 232 */     long l = Functions.GetPixelFormat;
/* 233 */     if (Checks.CHECKS) {
/* 234 */       Checks.check(paramLong);
/*     */     }
/* 236 */     return nGetPixelFormat(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nSetPixelFormat(long paramLong1, int paramInt, long paramLong2) {
/* 246 */     long l = Functions.SetPixelFormat;
/* 247 */     if (Checks.CHECKS) {
/* 248 */       Checks.check(paramLong1);
/*     */     }
/* 250 */     return nSetPixelFormat(paramLong1, paramInt, paramLong2, l);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean SetPixelFormat(@NativeType("HDC") long paramLong, int paramInt, @NativeType("PIXELFORMATDESCRIPTOR const *") PIXELFORMATDESCRIPTOR paramPIXELFORMATDESCRIPTOR) {
/* 263 */     return (nSetPixelFormat(paramLong, paramInt, MemoryUtil.memAddressSafe((Pointer)paramPIXELFORMATDESCRIPTOR)) != 0);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean SwapBuffers(@NativeType("HDC") long paramLong) {
/* 279 */     long l = Functions.SwapBuffers;
/* 280 */     if (Checks.CHECKS) {
/* 281 */       Checks.check(paramLong);
/*     */     }
/* 283 */     return (nSwapBuffers(paramLong, l) != 0);
/*     */   }
/*     */   
/*     */   public static native int nChoosePixelFormat(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nDescribePixelFormat(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nGetPixelFormat(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nSetPixelFormat(long paramLong1, int paramInt, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nSwapBuffers(long paramLong1, long paramLong2); }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\GDI32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */