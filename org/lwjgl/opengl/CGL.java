/*      */ package org.lwjgl.opengl;public class CGL { public static final int kCGLPFAAllRenderers = 1; public static final int kCGLPFATripleBuffer = 3; public static final int kCGLPFADoubleBuffer = 5; public static final int kCGLPFAStereo = 6; public static final int kCGLPFAColorSize = 8; public static final int kCGLPFAAlphaSize = 11; public static final int kCGLPFADepthSize = 12; public static final int kCGLPFAStencilSize = 13; public static final int kCGLPFAMinimumPolicy = 51; public static final int kCGLPFAMaximumPolicy = 52; public static final int kCGLPFASampleBuffers = 55; public static final int kCGLPFASamples = 56; public static final int kCGLPFAColorFloat = 58; public static final int kCGLPFAMultisample = 59; public static final int kCGLPFASupersample = 60; public static final int kCGLPFASampleAlpha = 61; public static final int kCGLPFARendererID = 70; public static final int kCGLPFASingleRenderer = 71; public static final int kCGLPFANoRecovery = 72; public static final int kCGLPFAAccelerated = 73; public static final int kCGLPFAClosestPolicy = 74; public static final int kCGLPFABackingStore = 76; public static final int kCGLPFABackingVolatile = 77; public static final int kCGLPFADisplayMask = 84; public static final int kCGLPFAAllowOfflineRenderers = 96; public static final int kCGLPFAAcceleratedCompute = 97; public static final int kCGLPFAOpenGLProfile = 99; public static final int kCGLPFASupportsAutomaticGraphicsSwitching = 101; public static final int kCGLPFAVirtualScreenCount = 128; public static final int kCGLPFAAuxBuffers = 7; public static final int kCGLPFAAccumSize = 14; public static final int kCGLPFAOffScreen = 53; public static final int kCGLPFAAuxDepthStencil = 57; public static final int kCGLPFAWindow = 80; public static final int kCGLPFACompliant = 83; public static final int kCGLPFAPBuffer = 90; public static final int kCGLPFARemotePBuffer = 91; public static final int kCGLPFARobust = 75; public static final int kCGLPFAMPSafe = 78; public static final int kCGLPFAMultiScreen = 81; public static final int kCGLPFAFullScreen = 54; public static final int kCGLRPOffScreen = 53; public static final int kCGLRPRendererID = 70; public static final int kCGLRPAccelerated = 73; public static final int kCGLRPBackingStore = 76; public static final int kCGLRPWindow = 80; public static final int kCGLRPCompliant = 83; public static final int kCGLRPDisplayMask = 84; public static final int kCGLRPBufferModes = 100; public static final int kCGLRPColorModes = 103; public static final int kCGLRPAccumModes = 104; public static final int kCGLRPDepthModes = 105; public static final int kCGLRPStencilModes = 106; public static final int kCGLRPMaxAuxBuffers = 107; public static final int kCGLRPMaxSampleBuffers = 108; public static final int kCGLRPMaxSamples = 109; public static final int kCGLRPSampleModes = 110; public static final int kCGLRPSampleAlpha = 111; public static final int kCGLRPVideoMemory = 120; public static final int kCGLRPTextureMemory = 121; public static final int kCGLRPGPUVertProcCapable = 122; public static final int kCGLRPGPUFragProcCapable = 123; public static final int kCGLRPRendererCount = 128; public static final int kCGLRPOnline = 129; public static final int kCGLRPAcceleratedCompute = 130; public static final int kCGLRPVideoMemoryMegabytes = 131; public static final int kCGLRPTextureMemoryMegabytes = 132; public static final int kCGLRPRobust = 75; public static final int kCGLRPMPSafe = 78; public static final int kCGLRPMultiScreen = 81; public static final int kCGLRPFullScreen = 54; public static final int kCGLCESwapRectangle = 201; public static final int kCGLCESwapLimit = 203; public static final int kCGLCERasterization = 221; public static final int kCGLCEStateValidation = 301; public static final int kCGLCESurfaceBackingSize = 305; public static final int kCGLCEDisplayListOptimization = 307; public static final int kCGLCEMPEngine = 313; public static final int kCGLCPSwapRectangle = 200; public static final int kCGLCPSwapInterval = 222; public static final int kCGLCPDispatchTableSize = 224; public static final int kCGLCPClientStorage = 226; public static final int kCGLCPSurfaceTexture = 228; public static final int kCGLCPSurfaceOrder = 235; public static final int kCGLCPSurfaceOpacity = 236; public static final int kCGLCPSurfaceBackingSize = 304; public static final int kCGLCPSurfaceSurfaceVolatile = 306; public static final int kCGLCPReclaimResources = 308; public static final int kCGLCPCurrentRendererID = 309; public static final int kCGLCPGPUVertexProcessing = 310; public static final int kCGLCPGPUFragmentProcessing = 311; public static final int kCGLCPHasDrawable = 314; public static final int kCGLCPMPSwapsInFlight = 315; public static final int kCGLGOFormatCacheSize = 501; public static final int kCGLGOClearFormatCache = 502; public static final int kCGLGORetainRenderers = 503; public static final int kCGLGOResetLibrary = 504; public static final int kCGLGOUseErrorHandler = 505; public static final int kCGLGOUseBuildCache = 506; public static final int kCGLOGLPVersion_Legacy = 4096; public static final int kCGLOGLPVersion_3_2_Core = 12800; public static final int kCGLNoError = 0; public static final int kCGLBadAttribute = 10000; public static final int kCGLBadProperty = 10001; public static final int kCGLBadPixelFormat = 10002; public static final int kCGLBadRendererInfo = 10003; public static final int kCGLBadContext = 10004; public static final int kCGLBadDrawable = 10005; public static final int kCGLBadDisplay = 10006; public static final int kCGLBadState = 10007; public static final int kCGLBadValue = 10008; public static final int kCGLBadMatch = 10009; public static final int kCGLBadEnumeration = 10010; public static final int kCGLBadOffScreen = 10011; public static final int kCGLBadFullScreen = 10012; public static final int kCGLBadWindow = 10013; public static final int kCGLBadAddress = 10014; public static final int kCGLBadCodeModule = 10015; public static final int kCGLBadAlloc = 10016; public static final int kCGLBadConnection = 10017; public static final int kCGLMonoscopicBit = 1; public static final int kCGLStereoscopicBit = 2; public static final int kCGLSingleBufferBit = 4; public static final int kCGLDoubleBufferBit = 8; public static final int kCGLTripleBufferBit = 16; public static final int kCGL0Bit = 1; public static final int kCGL1Bit = 2; public static final int kCGL2Bit = 4; public static final int kCGL3Bit = 8; public static final int kCGL4Bit = 16; public static final int kCGL5Bit = 32; public static final int kCGL6Bit = 64; public static final int kCGL8Bit = 128; public static final int kCGL10Bit = 256; public static final int kCGL12Bit = 512; public static final int kCGL16Bit = 1024; public static final int kCGL24Bit = 2048; public static final int kCGL32Bit = 4096; public static final int kCGL48Bit = 8192;
/*      */   public static final int kCGL64Bit = 16384;
/*      */   public static final int kCGL96Bit = 32768;
/*      */   public static final int kCGL128Bit = 65536;
/*      */   public static final int kCGLRGB444Bit = 64;
/*      */   public static final int kCGLARGB4444Bit = 128;
/*      */   public static final int kCGLRGB444A8Bit = 256;
/*      */   public static final int kCGLRGB555Bit = 512;
/*      */   public static final int kCGLARGB1555Bit = 1024;
/*      */   public static final int kCGLRGB555A8Bit = 2048;
/*      */   public static final int kCGLRGB565Bit = 4096;
/*      */   public static final int kCGLRGB565A8Bit = 8192;
/*      */   public static final int kCGLRGB888Bit = 16384;
/*      */   public static final int kCGLARGB8888Bit = 32768;
/*      */   public static final int kCGLRGB888A8Bit = 65536;
/*      */   public static final int kCGLRGB101010Bit = 131072;
/*      */   public static final int kCGLARGB2101010Bit = 262144;
/*      */   public static final int kCGLRGB101010_A8Bit = 524288;
/*      */   public static final int kCGLRGB121212Bit = 1048576;
/*      */   public static final int kCGLARGB12121212Bit = 2097152;
/*      */   public static final int kCGLRGB161616Bit = 4194304;
/*      */   public static final int kCGLRGBA16161616Bit = 8388608;
/*      */   public static final int kCGLRGBFloat64Bit = 16777216;
/*      */   public static final int kCGLRGBAFloat64Bit = 33554432;
/*      */   public static final int kCGLRGBFloat128Bit = 67108864;
/*      */   public static final int kCGLRGBAFloat128Bit = 134217728;
/*      */   public static final int kCGLRGBFloat256Bit = 268435456;
/*      */   public static final int kCGLRGBAFloat256Bit = 536870912;
/*      */   public static final int kCGLSupersampleBit = 1;
/*      */   public static final int kCGLMultisampleBit = 2;
/*      */   
/*   32 */   public static final class Functions { public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetCurrentContext");
/*   33 */     public static final long SetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetCurrentContext");
/*   34 */     public static final long GetShareGroup = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetShareGroup");
/*   35 */     public static final long ChoosePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLChoosePixelFormat");
/*   36 */     public static final long DestroyPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyPixelFormat");
/*   37 */     public static final long DescribePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribePixelFormat");
/*   38 */     public static final long ReleasePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleasePixelFormat");
/*   39 */     public static final long RetainPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainPixelFormat");
/*   40 */     public static final long GetPixelFormatRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPixelFormatRetainCount");
/*   41 */     public static final long QueryRendererInfo = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLQueryRendererInfo");
/*   42 */     public static final long DestroyRendererInfo = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyRendererInfo");
/*   43 */     public static final long DescribeRenderer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribeRenderer");
/*   44 */     public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCreateContext");
/*   45 */     public static final long DestroyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyContext");
/*   46 */     public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCopyContext");
/*   47 */     public static final long RetainContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainContext");
/*   48 */     public static final long ReleaseContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleaseContext");
/*   49 */     public static final long GetContextRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetContextRetainCount");
/*   50 */     public static final long GetPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPixelFormat");
/*   51 */     public static final long CreatePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCreatePBuffer");
/*   52 */     public static final long DestroyPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyPBuffer");
/*   53 */     public static final long DescribePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribePBuffer");
/*   54 */     public static final long TexImagePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLTexImagePBuffer");
/*   55 */     public static final long RetainPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainPBuffer");
/*   56 */     public static final long ReleasePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleasePBuffer");
/*   57 */     public static final long GetPBufferRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPBufferRetainCount");
/*   58 */     public static final long SetOffScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetOffScreen");
/*   59 */     public static final long GetOffScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetOffScreen");
/*   60 */     public static final long SetFullScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetFullScreen");
/*   61 */     public static final long SetFullScreenOnDisplay = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetFullScreenOnDisplay");
/*   62 */     public static final long SetPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetPBuffer");
/*   63 */     public static final long GetPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPBuffer");
/*   64 */     public static final long ClearDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLClearDrawable");
/*   65 */     public static final long FlushDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLFlushDrawable");
/*   66 */     public static final long Enable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLEnable");
/*   67 */     public static final long Disable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDisable");
/*   68 */     public static final long IsEnabled = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLIsEnabled");
/*   69 */     public static final long SetParameter = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetParameter");
/*   70 */     public static final long GetParameter = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetParameter");
/*   71 */     public static final long SetVirtualScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetVirtualScreen");
/*   72 */     public static final long GetVirtualScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetVirtualScreen");
/*   73 */     public static final long UpdateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLUpdateContext");
/*   74 */     public static final long SetGlobalOption = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetGlobalOption");
/*   75 */     public static final long GetGlobalOption = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetGlobalOption");
/*   76 */     public static final long LockContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLLockContext");
/*   77 */     public static final long UnlockContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLUnlockContext");
/*   78 */     public static final long GetVersion = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetVersion");
/*   79 */     public static final long ErrorString = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLErrorString"); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected CGL() {
/*  285 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLContextObj")
/*      */   public static long CGLGetCurrentContext() {
/*      */     long l;
/*  294 */     return JNI.callP(l = Functions.GetCurrentContext);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetCurrentContext(@NativeType("CGLContextObj") long paramLong) {
/*  313 */     long l = Functions.SetCurrentContext;
/*  314 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLShareGroupObj")
/*      */   public static long CGLGetShareGroup(@NativeType("CGLContextObj") long paramLong) {
/*  326 */     long l = Functions.GetShareGroup;
/*  327 */     if (Checks.CHECKS) {
/*  328 */       Checks.check(paramLong);
/*      */     }
/*  330 */     return JNI.callPP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLChoosePixelFormat(long paramLong1, long paramLong2, long paramLong3) {
/*  337 */     long l = Functions.ChoosePixelFormat;
/*  338 */     return JNI.callPPPI(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLChoosePixelFormat(@NativeType("CGLPixelFormatAttribute const *") IntBuffer paramIntBuffer1, @NativeType("CGLPixelFormatObj *") PointerBuffer paramPointerBuffer, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/*  354 */     if (Checks.CHECKS) {
/*  355 */       Checks.checkNT(paramIntBuffer1);
/*  356 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*  357 */       Checks.check(paramIntBuffer2, 1);
/*      */     } 
/*  359 */     return nCGLChoosePixelFormat(MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddress(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDestroyPixelFormat(@NativeType("CGLPixelFormatObj") long paramLong) {
/*  371 */     long l = Functions.DestroyPixelFormat;
/*  372 */     if (Checks.CHECKS) {
/*  373 */       Checks.check(paramLong);
/*      */     }
/*  375 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLDescribePixelFormat(long paramLong1, int paramInt1, int paramInt2, long paramLong2) {
/*  382 */     long l = Functions.DescribePixelFormat;
/*  383 */     if (Checks.CHECKS) {
/*  384 */       Checks.check(paramLong1);
/*      */     }
/*  386 */     return JNI.callPPI(paramLong1, paramInt1, paramInt2, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribePixelFormat(@NativeType("CGLPixelFormatObj") long paramLong, @NativeType("GLint") int paramInt1, @NativeType("CGLPixelFormatAttribute") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  399 */     if (Checks.CHECKS) {
/*  400 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  402 */     return nCGLDescribePixelFormat(paramLong, paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void CGLReleasePixelFormat(@NativeType("CGLPixelFormatObj") long paramLong) {
/*  418 */     long l = Functions.ReleasePixelFormat;
/*  419 */     if (Checks.CHECKS) {
/*  420 */       Checks.check(paramLong);
/*      */     }
/*  422 */     JNI.callPV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLPixelFormatObj")
/*      */   public static long CGLRetainPixelFormat(@NativeType("CGLPixelFormatObj") long paramLong) {
/*  437 */     long l = Functions.RetainPixelFormat;
/*  438 */     if (Checks.CHECKS) {
/*  439 */       Checks.check(paramLong);
/*      */     }
/*  441 */     return JNI.callPP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int CGLGetPixelFormatRetainCount(@NativeType("CGLPixelFormatObj") long paramLong) {
/*  453 */     long l = Functions.GetPixelFormatRetainCount;
/*  454 */     if (Checks.CHECKS) {
/*  455 */       Checks.check(paramLong);
/*      */     }
/*  457 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLQueryRendererInfo(int paramInt, long paramLong1, long paramLong2) {
/*  464 */     long l = Functions.QueryRendererInfo;
/*  465 */     return JNI.callPPI(paramInt, paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLQueryRendererInfo(@NativeType("GLuint") int paramInt, @NativeType("CGLRendererInfoObj *") PointerBuffer paramPointerBuffer, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  482 */     if (Checks.CHECKS) {
/*  483 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*  484 */       Checks.check(paramIntBuffer, 1);
/*      */     } 
/*  486 */     return nCGLQueryRendererInfo(paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDestroyRendererInfo(@NativeType("CGLRendererInfoObj") long paramLong) {
/*  498 */     long l = Functions.DestroyRendererInfo;
/*  499 */     if (Checks.CHECKS) {
/*  500 */       Checks.check(paramLong);
/*      */     }
/*  502 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLDescribeRenderer(long paramLong1, int paramInt1, int paramInt2, long paramLong2) {
/*  509 */     long l = Functions.DescribeRenderer;
/*  510 */     if (Checks.CHECKS) {
/*  511 */       Checks.check(paramLong1);
/*      */     }
/*  513 */     return JNI.callPPI(paramLong1, paramInt1, paramInt2, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribeRenderer(@NativeType("CGLRendererInfoObj") long paramLong, @NativeType("GLint") int paramInt1, @NativeType("CGLRendererProperty") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  530 */     if (Checks.CHECKS) {
/*  531 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  533 */     return nCGLDescribeRenderer(paramLong, paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLCreateContext(long paramLong1, long paramLong2, long paramLong3) {
/*  540 */     long l = Functions.CreateContext;
/*  541 */     if (Checks.CHECKS) {
/*  542 */       Checks.check(paramLong1);
/*      */     }
/*  544 */     return JNI.callPPPI(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLCreateContext(@NativeType("CGLPixelFormatObj") long paramLong1, @NativeType("CGLContextObj") long paramLong2, @NativeType("CGLContextObj *") PointerBuffer paramPointerBuffer) {
/*  559 */     if (Checks.CHECKS) {
/*  560 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/*  562 */     return nCGLCreateContext(paramLong1, paramLong2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDestroyContext(@NativeType("CGLContextObj") long paramLong) {
/*  578 */     long l = Functions.DestroyContext;
/*  579 */     if (Checks.CHECKS) {
/*  580 */       Checks.check(paramLong);
/*      */     }
/*  582 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLCopyContext(@NativeType("CGLContextObj") long paramLong1, @NativeType("CGLContextObj") long paramLong2, @NativeType("GLbitfield") int paramInt) {
/*  598 */     long l = Functions.CopyContext;
/*  599 */     if (Checks.CHECKS) {
/*  600 */       Checks.check(paramLong1);
/*  601 */       Checks.check(paramLong2);
/*      */     } 
/*  603 */     return JNI.callPPI(paramLong1, paramLong2, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLContextObj")
/*      */   public static long CGLRetainContext(@NativeType("CGLContextObj") long paramLong) {
/*  620 */     long l = Functions.RetainContext;
/*  621 */     if (Checks.CHECKS) {
/*  622 */       Checks.check(paramLong);
/*      */     }
/*  624 */     return JNI.callPP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void CGLReleaseContext(@NativeType("CGLContextObj") long paramLong) {
/*  642 */     long l = Functions.ReleaseContext;
/*  643 */     if (Checks.CHECKS) {
/*  644 */       Checks.check(paramLong);
/*      */     }
/*  646 */     JNI.callPV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int CGLGetContextRetainCount(@NativeType("CGLContextObj") long paramLong) {
/*  658 */     long l = Functions.GetContextRetainCount;
/*  659 */     if (Checks.CHECKS) {
/*  660 */       Checks.check(paramLong);
/*      */     }
/*  662 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLPixelFormatObj")
/*      */   public static long CGLGetPixelFormat(@NativeType("CGLContextObj") long paramLong) {
/*  677 */     long l = Functions.GetPixelFormat;
/*  678 */     if (Checks.CHECKS) {
/*  679 */       Checks.check(paramLong);
/*      */     }
/*  681 */     return JNI.callPP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLCreatePBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong) {
/*  688 */     long l = Functions.CreatePBuffer;
/*  689 */     return JNI.callPI(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLCreatePBuffer(@NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("CGLPBufferObj *") PointerBuffer paramPointerBuffer) {
/*  722 */     if (Checks.CHECKS) {
/*  723 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/*  725 */     return nCGLCreatePBuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDestroyPBuffer(@NativeType("CGLPBufferObj") long paramLong) {
/*  741 */     long l = Functions.DestroyPBuffer;
/*  742 */     if (Checks.CHECKS) {
/*  743 */       Checks.check(paramLong);
/*      */     }
/*  745 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLDescribePBuffer(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {
/*  752 */     long l = Functions.DescribePBuffer;
/*  753 */     if (Checks.CHECKS) {
/*  754 */       Checks.check(paramLong1);
/*      */     }
/*  756 */     return JNI.callPPPPPPI(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribePBuffer(@NativeType("CGLPBufferObj") long paramLong, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLsizei *") IntBuffer paramIntBuffer2, @NativeType("GLenum *") IntBuffer paramIntBuffer3, @NativeType("GLenum *") IntBuffer paramIntBuffer4, @NativeType("GLint *") IntBuffer paramIntBuffer5) {
/*  777 */     if (Checks.CHECKS) {
/*  778 */       Checks.check(paramIntBuffer1, 1);
/*  779 */       Checks.check(paramIntBuffer2, 1);
/*  780 */       Checks.check(paramIntBuffer3, 1);
/*  781 */       Checks.check(paramIntBuffer4, 1);
/*  782 */       Checks.check(paramIntBuffer5, 1);
/*      */     } 
/*  784 */     return nCGLDescribePBuffer(paramLong, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramIntBuffer4), MemoryUtil.memAddress(paramIntBuffer5));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLTexImagePBuffer(@NativeType("CGLContextObj") long paramLong1, @NativeType("CGLPBufferObj") long paramLong2, @NativeType("GLenum") int paramInt) {
/*  822 */     long l = Functions.TexImagePBuffer;
/*  823 */     if (Checks.CHECKS) {
/*  824 */       Checks.check(paramLong1);
/*  825 */       Checks.check(paramLong2);
/*      */     } 
/*  827 */     return JNI.callPPI(paramLong1, paramLong2, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLPBufferObj")
/*      */   public static long CGLRetainPBuffer(@NativeType("CGLPBufferObj") long paramLong) {
/*  844 */     long l = Functions.RetainPBuffer;
/*  845 */     if (Checks.CHECKS) {
/*  846 */       Checks.check(paramLong);
/*      */     }
/*  848 */     return JNI.callPP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void CGLReleasePBuffer(@NativeType("CGLPBufferObj") long paramLong) {
/*  863 */     long l = Functions.ReleasePBuffer;
/*  864 */     if (Checks.CHECKS) {
/*  865 */       Checks.check(paramLong);
/*      */     }
/*  867 */     JNI.callPV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int CGLGetPBufferRetainCount(@NativeType("CGLPBufferObj") long paramLong) {
/*  881 */     long l = Functions.GetPBufferRetainCount;
/*  882 */     if (Checks.CHECKS) {
/*  883 */       Checks.check(paramLong);
/*      */     }
/*  885 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLSetOffScreen(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2) {
/*  892 */     long l = Functions.SetOffScreen;
/*  893 */     if (Checks.CHECKS) {
/*  894 */       Checks.check(paramLong1);
/*      */     }
/*  896 */     return JNI.callPPI(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetOffScreen(@NativeType("CGLContextObj") long paramLong, @NativeType("GLsizei") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  923 */     if (Checks.CHECKS) {
/*  924 */       Checks.check(paramByteBuffer, paramInt3 * paramInt2);
/*      */     }
/*  926 */     return nCGLSetOffScreen(paramLong, paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLGetOffScreen(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/*  933 */     long l = Functions.GetOffScreen;
/*  934 */     if (Checks.CHECKS) {
/*  935 */       Checks.check(paramLong1);
/*      */     }
/*  937 */     return JNI.callPPPPPI(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetOffScreen(@NativeType("CGLContextObj") long paramLong, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLsizei *") IntBuffer paramIntBuffer2, @NativeType("GLint *") IntBuffer paramIntBuffer3, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/*  957 */     if (Checks.CHECKS) {
/*  958 */       Checks.check(paramIntBuffer1, 1);
/*  959 */       Checks.check(paramIntBuffer2, 1);
/*  960 */       Checks.check(paramIntBuffer3, 1);
/*  961 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     } 
/*  963 */     return nCGLGetOffScreen(paramLong, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetFullScreen(@NativeType("CGLContextObj") long paramLong) {
/*  986 */     long l = Functions.SetFullScreen;
/*  987 */     if (Checks.CHECKS) {
/*  988 */       Checks.check(paramLong);
/*      */     }
/*  990 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetFullScreenOnDisplay(@NativeType("CGLContextObj") long paramLong, @NativeType("GLuint") int paramInt) {
/* 1020 */     long l = Functions.SetFullScreenOnDisplay;
/* 1021 */     if (Checks.CHECKS) {
/* 1022 */       Checks.check(paramLong);
/*      */     }
/* 1024 */     return JNI.callPI(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetPBuffer(@NativeType("CGLContextObj") long paramLong1, @NativeType("CGLPBufferObj") long paramLong2, @NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 1064 */     long l = Functions.SetPBuffer;
/* 1065 */     if (Checks.CHECKS) {
/* 1066 */       Checks.check(paramLong1);
/* 1067 */       Checks.check(paramLong2);
/*      */     } 
/* 1069 */     return JNI.callPPI(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLGetPBuffer(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/* 1076 */     long l = Functions.GetPBuffer;
/* 1077 */     if (Checks.CHECKS) {
/* 1078 */       Checks.check(paramLong1);
/*      */     }
/* 1080 */     return JNI.callPPPPPI(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetPBuffer(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLPBufferObj *") PointerBuffer paramPointerBuffer, @NativeType("GLenum *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2, @NativeType("GLint *") IntBuffer paramIntBuffer3) {
/* 1097 */     if (Checks.CHECKS) {
/* 1098 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 1099 */       Checks.check(paramIntBuffer1, 1);
/* 1100 */       Checks.check(paramIntBuffer2, 1);
/* 1101 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/* 1103 */     return nCGLGetPBuffer(paramLong, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLClearDrawable(@NativeType("CGLContextObj") long paramLong) {
/* 1115 */     long l = Functions.ClearDrawable;
/* 1116 */     if (Checks.CHECKS) {
/* 1117 */       Checks.check(paramLong);
/*      */     }
/* 1119 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLFlushDrawable(@NativeType("CGLContextObj") long paramLong) {
/* 1140 */     long l = Functions.FlushDrawable;
/* 1141 */     if (Checks.CHECKS) {
/* 1142 */       Checks.check(paramLong);
/*      */     }
/* 1144 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLEnable(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLContextEnable") int paramInt) {
/* 1157 */     long l = Functions.Enable;
/* 1158 */     if (Checks.CHECKS) {
/* 1159 */       Checks.check(paramLong);
/*      */     }
/* 1161 */     return JNI.callPI(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDisable(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLContextEnable") int paramInt) {
/* 1174 */     long l = Functions.Disable;
/* 1175 */     if (Checks.CHECKS) {
/* 1176 */       Checks.check(paramLong);
/*      */     }
/* 1178 */     return JNI.callPI(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLIsEnabled(long paramLong1, int paramInt, long paramLong2) {
/* 1185 */     long l = Functions.IsEnabled;
/* 1186 */     if (Checks.CHECKS) {
/* 1187 */       Checks.check(paramLong1);
/*      */     }
/* 1189 */     return JNI.callPPI(paramLong1, paramInt, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLIsEnabled(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLContextEnable") int paramInt, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1201 */     if (Checks.CHECKS) {
/* 1202 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1204 */     return nCGLIsEnabled(paramLong, paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLSetParameter(long paramLong1, int paramInt, long paramLong2) {
/* 1211 */     long l = Functions.SetParameter;
/* 1212 */     if (Checks.CHECKS) {
/* 1213 */       Checks.check(paramLong1);
/*      */     }
/* 1215 */     return JNI.callPPI(paramLong1, paramInt, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetParameter(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLContextParameter") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1227 */     if (Checks.CHECKS) {
/* 1228 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1230 */     return nCGLSetParameter(paramLong, paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetParameter(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLContextParameter") int paramInt1, @NativeType("GLint const *") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1241 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1243 */       IntBuffer intBuffer = memoryStack.ints(paramInt2);
/* 1244 */       return nCGLSetParameter(paramLong, paramInt1, MemoryUtil.memAddress(intBuffer));
/*      */     } finally {
/* 1246 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLGetParameter(long paramLong1, int paramInt, long paramLong2) {
/* 1254 */     long l = Functions.GetParameter;
/* 1255 */     if (Checks.CHECKS) {
/* 1256 */       Checks.check(paramLong1);
/*      */     }
/* 1258 */     return JNI.callPPI(paramLong1, paramInt, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetParameter(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLContextParameter") int paramInt, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1270 */     if (Checks.CHECKS) {
/* 1271 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1273 */     return nCGLGetParameter(paramLong, paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetVirtualScreen(@NativeType("CGLContextObj") long paramLong, @NativeType("GLint") int paramInt) {
/* 1293 */     long l = Functions.SetVirtualScreen;
/* 1294 */     if (Checks.CHECKS) {
/* 1295 */       Checks.check(paramLong);
/*      */     }
/* 1297 */     return JNI.callPI(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLGetVirtualScreen(long paramLong1, long paramLong2) {
/* 1304 */     long l = Functions.GetVirtualScreen;
/* 1305 */     if (Checks.CHECKS) {
/* 1306 */       Checks.check(paramLong1);
/*      */     }
/* 1308 */     return JNI.callPPI(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetVirtualScreen(@NativeType("CGLContextObj") long paramLong, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1323 */     if (Checks.CHECKS) {
/* 1324 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1326 */     return nCGLGetVirtualScreen(paramLong, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLUpdateContext(@NativeType("CGLContextObj") long paramLong) {
/* 1338 */     long l = Functions.UpdateContext;
/* 1339 */     if (Checks.CHECKS) {
/* 1340 */       Checks.check(paramLong);
/*      */     }
/* 1342 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLSetGlobalOption(int paramInt, long paramLong) {
/* 1349 */     long l = Functions.SetGlobalOption;
/* 1350 */     return JNI.callPI(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetGlobalOption(@NativeType("CGLGlobalOption") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 1361 */     if (Checks.CHECKS) {
/* 1362 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1364 */     return nCGLSetGlobalOption(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetGlobalOption(@NativeType("CGLGlobalOption") int paramInt1, @NativeType("GLint const *") int paramInt2) {
/*      */     MemoryStack memoryStack;
/* 1374 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1376 */       IntBuffer intBuffer = memoryStack.ints(paramInt2);
/* 1377 */       paramInt1 = nCGLSetGlobalOption(paramInt1, MemoryUtil.memAddress(intBuffer)); return paramInt1;
/*      */     } finally {
/* 1379 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLGetGlobalOption(int paramInt, long paramLong) {
/* 1387 */     long l = Functions.GetGlobalOption;
/* 1388 */     return JNI.callPI(paramInt, paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetGlobalOption(@NativeType("CGLGlobalOption") int paramInt, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 1399 */     if (Checks.CHECKS) {
/* 1400 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/* 1402 */     return nCGLGetGlobalOption(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLLockContext(@NativeType("CGLContextObj") long paramLong) {
/* 1423 */     long l = Functions.LockContext;
/* 1424 */     if (Checks.CHECKS) {
/* 1425 */       Checks.check(paramLong);
/*      */     }
/* 1427 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLUnlockContext(@NativeType("CGLContextObj") long paramLong) {
/* 1439 */     long l = Functions.UnlockContext;
/* 1440 */     if (Checks.CHECKS) {
/* 1441 */       Checks.check(paramLong);
/*      */     }
/* 1443 */     return JNI.callPI(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nCGLGetVersion(long paramLong1, long paramLong2) {
/* 1450 */     long l = Functions.GetVersion;
/* 1451 */     JNI.callPPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void CGLGetVersion(@NativeType("GLint *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 1461 */     if (Checks.CHECKS) {
/* 1462 */       Checks.check(paramIntBuffer1, 1);
/* 1463 */       Checks.check(paramIntBuffer2, 1);
/*      */     } 
/* 1465 */     nCGLGetVersion(MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nCGLErrorString(int paramInt) {
/* 1472 */     long l = Functions.ErrorString;
/* 1473 */     return JNI.callP(paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String CGLErrorString(@NativeType("CGLError") int paramInt) {
/*      */     long l;
/* 1485 */     return MemoryUtil.memASCIISafe(l = nCGLErrorString(paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLChoosePixelFormat(@NativeType("CGLPixelFormatAttribute const *") int[] paramArrayOfint1, @NativeType("CGLPixelFormatObj *") PointerBuffer paramPointerBuffer, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 1491 */     long l = Functions.ChoosePixelFormat;
/* 1492 */     if (Checks.CHECKS) {
/* 1493 */       Checks.checkNT(paramArrayOfint1);
/* 1494 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 1495 */       Checks.check(paramArrayOfint2, 1);
/*      */     } 
/* 1497 */     return JNI.callPPPI(paramArrayOfint1, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint2, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribePixelFormat(@NativeType("CGLPixelFormatObj") long paramLong, @NativeType("GLint") int paramInt1, @NativeType("CGLPixelFormatAttribute") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1503 */     long l = Functions.DescribePixelFormat;
/* 1504 */     if (Checks.CHECKS) {
/* 1505 */       Checks.check(paramLong);
/* 1506 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1508 */     return JNI.callPPI(paramLong, paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLQueryRendererInfo(@NativeType("GLuint") int paramInt, @NativeType("CGLRendererInfoObj *") PointerBuffer paramPointerBuffer, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1514 */     long l = Functions.QueryRendererInfo;
/* 1515 */     if (Checks.CHECKS) {
/* 1516 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 1517 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1519 */     return JNI.callPPI(paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribeRenderer(@NativeType("CGLRendererInfoObj") long paramLong, @NativeType("GLint") int paramInt1, @NativeType("CGLRendererProperty") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1525 */     long l = Functions.DescribeRenderer;
/* 1526 */     if (Checks.CHECKS) {
/* 1527 */       Checks.check(paramLong);
/* 1528 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1530 */     return JNI.callPPI(paramLong, paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribePBuffer(@NativeType("CGLPBufferObj") long paramLong, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLsizei *") int[] paramArrayOfint2, @NativeType("GLenum *") int[] paramArrayOfint3, @NativeType("GLenum *") int[] paramArrayOfint4, @NativeType("GLint *") int[] paramArrayOfint5) {
/* 1536 */     long l = Functions.DescribePBuffer;
/* 1537 */     if (Checks.CHECKS) {
/* 1538 */       Checks.check(paramLong);
/* 1539 */       Checks.check(paramArrayOfint1, 1);
/* 1540 */       Checks.check(paramArrayOfint2, 1);
/* 1541 */       Checks.check(paramArrayOfint3, 1);
/* 1542 */       Checks.check(paramArrayOfint4, 1);
/* 1543 */       Checks.check(paramArrayOfint5, 1);
/*      */     } 
/* 1545 */     return JNI.callPPPPPPI(paramLong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, paramArrayOfint5, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetOffScreen(@NativeType("CGLContextObj") long paramLong, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLsizei *") int[] paramArrayOfint2, @NativeType("GLint *") int[] paramArrayOfint3, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 1551 */     long l = Functions.GetOffScreen;
/* 1552 */     if (Checks.CHECKS) {
/* 1553 */       Checks.check(paramLong);
/* 1554 */       Checks.check(paramArrayOfint1, 1);
/* 1555 */       Checks.check(paramArrayOfint2, 1);
/* 1556 */       Checks.check(paramArrayOfint3, 1);
/* 1557 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     } 
/* 1559 */     return JNI.callPPPPPI(paramLong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetPBuffer(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLPBufferObj *") PointerBuffer paramPointerBuffer, @NativeType("GLenum *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2, @NativeType("GLint *") int[] paramArrayOfint3) {
/* 1565 */     long l = Functions.GetPBuffer;
/* 1566 */     if (Checks.CHECKS) {
/* 1567 */       Checks.check(paramLong);
/* 1568 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 1569 */       Checks.check(paramArrayOfint1, 1);
/* 1570 */       Checks.check(paramArrayOfint2, 1);
/* 1571 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/* 1573 */     return JNI.callPPPPPI(paramLong, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLIsEnabled(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLContextEnable") int paramInt, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1579 */     long l = Functions.IsEnabled;
/* 1580 */     if (Checks.CHECKS) {
/* 1581 */       Checks.check(paramLong);
/* 1582 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1584 */     return JNI.callPPI(paramLong, paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetParameter(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLContextParameter") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1590 */     long l = Functions.SetParameter;
/* 1591 */     if (Checks.CHECKS) {
/* 1592 */       Checks.check(paramLong);
/* 1593 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1595 */     return JNI.callPPI(paramLong, paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetParameter(@NativeType("CGLContextObj") long paramLong, @NativeType("CGLContextParameter") int paramInt, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1601 */     long l = Functions.GetParameter;
/* 1602 */     if (Checks.CHECKS) {
/* 1603 */       Checks.check(paramLong);
/* 1604 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1606 */     return JNI.callPPI(paramLong, paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetVirtualScreen(@NativeType("CGLContextObj") long paramLong, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1612 */     long l = Functions.GetVirtualScreen;
/* 1613 */     if (Checks.CHECKS) {
/* 1614 */       Checks.check(paramLong);
/* 1615 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1617 */     return JNI.callPPI(paramLong, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetGlobalOption(@NativeType("CGLGlobalOption") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 1623 */     long l = Functions.SetGlobalOption;
/* 1624 */     if (Checks.CHECKS) {
/* 1625 */       Checks.check(paramArrayOfint, 1);
/*      */     }
/* 1627 */     return JNI.callPI(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetGlobalOption(@NativeType("CGLGlobalOption") int paramInt, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1633 */     long l = Functions.GetGlobalOption;
/* 1634 */     if (Checks.CHECKS) {
/* 1635 */       Checks.check(paramArrayOfint, 1);
/*      */     }
/* 1637 */     return JNI.callPI(paramInt, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void CGLGetVersion(@NativeType("GLint *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 1642 */     long l = Functions.GetVersion;
/* 1643 */     if (Checks.CHECKS) {
/* 1644 */       Checks.check(paramArrayOfint1, 1);
/* 1645 */       Checks.check(paramArrayOfint2, 1);
/*      */     } 
/* 1647 */     JNI.callPPV(paramArrayOfint1, paramArrayOfint2, l);
/*      */   } }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\CGL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */