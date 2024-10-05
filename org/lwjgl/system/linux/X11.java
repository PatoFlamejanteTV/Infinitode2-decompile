/*     */ package org.lwjgl.system.linux;public class X11 { public static final int True = 1; public static final int False = 0; public static final int None = 0; public static final int ParentRelative = 1; public static final int CopyFromParent = 0; public static final int PointerWindow = 0; public static final int InputFocus = 1; public static final int PointerRoot = 1; public static final int AnyPropertyType = 0; public static final int AnyKey = 0; public static final int AnyButton = 0; public static final int AllTemporary = 0; public static final int CurrentTime = 0; public static final int NoSymbol = 0; public static final int Success = 0; public static final int BadRequest = 1; public static final int BadValue = 2; public static final int BadWindow = 3; public static final int BadPixmap = 4; public static final int BadAtom = 5; public static final int BadCursor = 6; public static final int BadFont = 7; public static final int BadMatch = 8; public static final int BadDrawable = 9; public static final int BadAccess = 10; public static final int BadAlloc = 11; public static final int BadColor = 12; public static final int BadGC = 13; public static final int BadIDChoice = 14; public static final int BadName = 15; public static final int BadLength = 16; public static final int BadImplementation = 17; public static final int FirstExtensionError = 128; public static final int LastExtensionError = 255; public static final int CWBackPixmap = 1; public static final int CWBackPixel = 2; public static final int CWBorderPixmap = 4; public static final int CWBorderPixel = 8; public static final int CWBitGravity = 16; public static final int CWWinGravity = 32; public static final int CWBackingStore = 64; public static final int CWBackingPlanes = 128; public static final int CWBackingPixel = 256; public static final int CWOverrideRedirect = 512; public static final int CWSaveUnder = 1024;
/*     */   public static final int CWEventMask = 2048;
/*     */   public static final int CWDontPropagate = 4096;
/*     */   public static final int CWColormap = 8192;
/*     */   public static final int CWCursor = 16384;
/*     */   public static final int NoEventMask = 0;
/*     */   public static final int KeyPressMask = 1;
/*     */   public static final int KeyReleaseMask = 2;
/*     */   public static final int ButtonPressMask = 4;
/*     */   public static final int ButtonReleaseMask = 8;
/*     */   public static final int EnterWindowMask = 16;
/*     */   public static final int LeaveWindowMask = 32;
/*     */   public static final int PointerMotionMask = 64;
/*     */   public static final int PointerMotionHintMask = 128;
/*     */   public static final int Button1MotionMask = 256;
/*     */   public static final int Button2MotionMask = 512;
/*     */   public static final int Button3MotionMask = 1024;
/*     */   public static final int Button4MotionMask = 2048;
/*     */   public static final int Button5MotionMask = 4096;
/*     */   public static final int ButtonMotionMask = 8192;
/*     */   public static final int KeymapStateMask = 16384;
/*     */   public static final int ExposureMask = 32768;
/*     */   public static final int VisibilityChangeMask = 65536;
/*     */   public static final int StructureNotifyMask = 131072;
/*  25 */   private static final SharedLibrary X11 = Library.loadNative(X11.class, "org.lwjgl", null, new String[] { "libX11.so.6", "libX11.so" }); public static final int ResizeRedirectMask = 262144; public static final int SubstructureNotifyMask = 524288; public static final int SubstructureRedirectMask = 1048576; public static final int FocusChangeMask = 2097152; public static final int PropertyChangeMask = 4194304; public static final int ColormapChangeMask = 8388608; public static final int OwnerGrabButtonMask = 16777216; public static final int KeyPress = 2; public static final int KeyRelease = 3; public static final int ButtonPress = 4; public static final int ButtonRelease = 5; public static final int MotionNotify = 6; public static final int EnterNotify = 7; public static final int LeaveNotify = 8; public static final int FocusIn = 9; public static final int FocusOut = 10; public static final int KeymapNotify = 11; public static final int Expose = 12; public static final int GraphicsExpose = 13; public static final int NoExpose = 14; public static final int VisibilityNotify = 15; public static final int CreateNotify = 16; public static final int DestroyNotify = 17; public static final int UnmapNotify = 18; public static final int MapNotify = 19; public static final int MapRequest = 20; public static final int ReparentNotify = 21; public static final int ConfigureNotify = 22; public static final int ConfigureRequest = 23; public static final int GravityNotify = 24; public static final int ResizeRequest = 25; public static final int CirculateNotify = 26; public static final int CirculateRequest = 27; public static final int PropertyNotify = 28; public static final int SelectionClear = 29; public static final int SelectionRequest = 30; public static final int SelectionNotify = 31; public static final int ColormapNotify = 32; public static final int ClientMessage = 33; public static final int MappingNotify = 34; public static final int GenericEvent = 35; public static final int LASTEvent = 36; public static final int ShiftMask = 1; public static final int LockMask = 2; public static final int ControlMask = 4; public static final int Mod1Mask = 8; public static final int Mod2Mask = 16; public static final int Mod3Mask = 32; public static final int Mod4Mask = 64; public static final int Mod5Mask = 128; public static final int ShiftMapIndex = 0; public static final int LockMapIndex = 1; public static final int ControlMapIndex = 2; public static final int Mod1MapIndex = 3; public static final int Mod2MapIndex = 4; public static final int Mod3MapIndex = 5; public static final int Mod4MapIndex = 6; public static final int Mod5MapIndex = 7; public static final int Button1Mask = 256; public static final int Button2Mask = 512; public static final int Button3Mask = 1024; public static final int Button4Mask = 2048; public static final int Button5Mask = 4096; public static final int AnyModifier = 32768; public static final int Button1 = 1; public static final int Button2 = 2; public static final int Button3 = 3; public static final int Button4 = 4; public static final int Button5 = 5; public static final int NotifyNormal = 0; public static final int NotifyGrab = 1; public static final int NotifyUngrab = 2; public static final int NotifyWhileGrabbed = 3; public static final int NotifyHint = 1; public static final int NotifyAncestor = 0; public static final int NotifyVirtual = 1; public static final int NotifyInferior = 2; public static final int NotifyNonlinear = 3; public static final int NotifyNonlinearVirtual = 4; public static final int NotifyPointer = 5; public static final int NotifyPointerRoot = 6; public static final int NotifyDetailNone = 7; public static final int VisibilityUnobscured = 0; public static final int VisibilityPartiallyObscured = 1; public static final int VisibilityFullyObscured = 2; public static final int PlaceOnTop = 0; public static final int PlaceOnBottom = 1; public static final int PropertyNewValue = 0; public static final int PropertyDelete = 1; public static final int ColormapUninstalled = 0; public static final int ColormapInstalled = 1; public static final int GrabModeSync = 0; public static final int GrabModeAsync = 1; public static final int GrabSuccess = 0; public static final int AlreadyGrabbed = 1; public static final int GrabInvalidTime = 2; public static final int GrabNotViewable = 3; public static final int GrabFrozen = 4; public static final int AsyncPointer = 0; public static final int SyncPointer = 1; public static final int ReplayPointer = 2; public static final int AsyncKeyboard = 3; public static final int SyncKeyboard = 4; public static final int ReplayKeyboard = 5; public static final int AsyncBoth = 6; public static final int SyncBoth = 7; public static final int AllocNone = 0; public static final int AllocAll = 1; public static final int RevertToNone = 0; public static final int RevertToPointerRoot = 1; public static final int RevertToParent = 2; public static final int InputOutput = 1; public static final int InputOnly = 2; public static final int DontPreferBlanking = 0; public static final int PreferBlanking = 1; public static final int DefaultBlanking = 2; public static final int DisableScreenSaver = 0; public static final int DisableScreenInterval = 0; public static final int DontAllowExposures = 0; public static final int AllowExposures = 1; public static final int DefaultExposures = 2; public static final int ScreenSaverReset = 0; public static final int ScreenSaverActive = 1; public static final int PropModeReplace = 0; public static final int PropModePrepend = 1; public static final int PropModeAppend = 2; public static final int GXclear = 0; public static final int GXand = 1; public static final int GXandReverse = 2; public static final int GXcopy = 3; public static final int GXandInverted = 4; public static final int GXnoop = 5; public static final int GXxor = 6; public static final int GXor = 7; public static final int GXnor = 8; public static final int GXequiv = 9; public static final int GXinvert = 10; public static final int GXorReverse = 11; public static final int GXcopyInverted = 12; public static final int GXorInverted = 13; public static final int GXnand = 14; public static final int GXset = 15; public static final int LineSolid = 0; public static final int LineOnOffDash = 1; public static final int LineDoubleDash = 2; public static final int CapNotLast = 0; public static final int CapButt = 1; public static final int CapRound = 2; public static final int CapProjecting = 3; public static final int JoinMiter = 0; public static final int JoinRound = 1; public static final int JoinBevel = 2; public static final int FillSolid = 0; public static final int FillTiled = 1; public static final int FillStippled = 2; public static final int FillOpaqueStippled = 3; public static final int EvenOddRule = 0; public static final int WindingRule = 1; public static final int ClipByChildren = 0; public static final int IncludeInferiors = 1; public static final int Unsorted = 0; public static final int YSorted = 1; public static final int YXSorted = 2; public static final int YXBanded = 3; public static final int CoordModeOrigin = 0; public static final int CoordModePrevious = 1; public static final int Complex = 0; public static final int Nonconvex = 1; public static final int Convex = 2; public static final int ArcChord = 0; public static final int ArcPieSlice = 1; public static final int GCFunction = 1; public static final int GCPlaneMask = 2; public static final int GCForeground = 4; public static final int GCBackground = 8; public static final int GCLineWidth = 16; public static final int GCLineStyle = 32; public static final int GCCapStyle = 64; public static final int GCJoinStyle = 128; public static final int GCFillStyle = 256; public static final int GCFillRule = 512; public static final int GCTile = 1024; public static final int GCStipple = 2048; public static final int GCTileStipXOrigin = 4096; public static final int GCTileStipYOrigin = 8192; public static final int GCFont = 16384; public static final int GCSubwindowMode = 32768; public static final int GCGraphicsExposures = 65536; public static final int GCClipXOrigin = 131072; public static final int GCClipYOrigin = 262144; public static final int GCClipMask = 524288; public static final int GCDashOffset = 1048576; public static final int GCDashList = 2097152; public static final int GCArcMode = 4194304; public static final int GCLastBit = 22; public static final int Above = 0;
/*     */   public static final int Below = 1;
/*     */   public static final int TopIf = 2;
/*     */   public static final int BottomIf = 3;
/*     */   public static final int Opposite = 4;
/*     */   public static final int MappingModifier = 0;
/*     */   public static final int MappingKeyboard = 1;
/*     */   public static final int MappingPointer = 2;
/*     */   
/*  34 */   public static final class Functions { public static final long XOpenDisplay = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XOpenDisplay");
/*  35 */     public static final long XCloseDisplay = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XCloseDisplay");
/*  36 */     public static final long XDefaultScreen = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XDefaultScreen");
/*  37 */     public static final long XRootWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XRootWindow");
/*  38 */     public static final long XCreateColormap = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XCreateColormap");
/*  39 */     public static final long XFreeColormap = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XFreeColormap");
/*  40 */     public static final long XCreateWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XCreateWindow");
/*  41 */     public static final long XDestroyWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XDestroyWindow");
/*  42 */     public static final long XFree = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XFree");
/*  43 */     public static final long XSendEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XSendEvent");
/*  44 */     public static final long XDisplayMotionBufferSize = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XDisplayMotionBufferSize");
/*  45 */     public static final long XGetMotionEvents = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XGetMotionEvents");
/*  46 */     public static final long XTranslateCoordinates = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XTranslateCoordinates"); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  52 */     return X11;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected X11() {
/* 445 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nXOpenDisplay(long paramLong) {
/* 452 */     long l = Functions.XOpenDisplay;
/* 453 */     return JNI.invokePP(paramLong, l);
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
/*     */   @NativeType("Display *")
/*     */   public static long XOpenDisplay(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/* 469 */     if (Checks.CHECKS) {
/* 470 */       Checks.checkNT1Safe(paramByteBuffer);
/*     */     }
/* 472 */     return nXOpenDisplay(MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*     */   @NativeType("Display *")
/*     */   public static long XOpenDisplay(@NativeType("char const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 488 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 490 */       memoryStack.nASCIISafe(paramCharSequence, true);
/*     */       long l;
/* 492 */       return nXOpenDisplay(l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress());
/*     */     } finally {
/* 494 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void XCloseDisplay(@NativeType("Display *") long paramLong) {
/* 510 */     long l = Functions.XCloseDisplay;
/* 511 */     if (Checks.CHECKS) {
/* 512 */       Checks.check(paramLong);
/*     */     }
/* 514 */     JNI.invokePV(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int XDefaultScreen(@NativeType("Display *") long paramLong) {
/* 525 */     long l = Functions.XDefaultScreen;
/* 526 */     if (Checks.CHECKS) {
/* 527 */       Checks.check(paramLong);
/*     */     }
/* 529 */     return JNI.invokePI(paramLong, l);
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
/*     */   @NativeType("Window")
/*     */   public static long XRootWindow(@NativeType("Display *") long paramLong, int paramInt) {
/* 542 */     long l = Functions.XRootWindow;
/* 543 */     if (Checks.CHECKS) {
/* 544 */       Checks.check(paramLong);
/*     */     }
/* 546 */     return JNI.invokePN(paramLong, paramInt, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nXCreateColormap(long paramLong1, long paramLong2, long paramLong3, int paramInt) {
/* 553 */     long l = Functions.XCreateColormap;
/* 554 */     if (Checks.CHECKS) {
/* 555 */       Checks.check(paramLong1);
/*     */     }
/* 557 */     return JNI.invokePNPN(paramLong1, paramLong2, paramLong3, paramInt, l);
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
/*     */   @NativeType("Colormap")
/*     */   public static long XCreateColormap(@NativeType("Display *") long paramLong1, @NativeType("Window") long paramLong2, @NativeType("Visual *") Visual paramVisual, int paramInt) {
/* 571 */     return nXCreateColormap(paramLong1, paramLong2, paramVisual.address(), paramInt);
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
/*     */   public static int XFreeColormap(@NativeType("Display *") long paramLong1, @NativeType("Colormap") long paramLong2) {
/* 586 */     long l = Functions.XFreeColormap;
/* 587 */     if (Checks.CHECKS) {
/* 588 */       Checks.check(paramLong1);
/*     */     }
/* 590 */     return JNI.invokePNI(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nXCreateWindow(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong3, long paramLong4, long paramLong5) {
/* 597 */     long l = Functions.XCreateWindow;
/* 598 */     if (Checks.CHECKS) {
/* 599 */       Checks.check(paramLong1);
/*     */     }
/* 601 */     return JNI.invokePNPNPN(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramLong3, paramLong4, paramLong5, l);
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
/*     */   @NativeType("Window")
/*     */   public static long XCreateWindow(@NativeType("Display *") long paramLong1, @NativeType("Window") long paramLong2, int paramInt1, int paramInt2, @NativeType("unsigned int") int paramInt3, @NativeType("unsigned int") int paramInt4, @NativeType("unsigned int") int paramInt5, int paramInt6, @NativeType("unsigned int") int paramInt7, @NativeType("Visual *") Visual paramVisual, @NativeType("unsigned long") long paramLong3, @NativeType("XSetWindowAttributes *") XSetWindowAttributes paramXSetWindowAttributes) {
/* 632 */     return nXCreateWindow(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramVisual.address(), paramLong3, paramXSetWindowAttributes.address());
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
/*     */   public static int XDestroyWindow(@NativeType("Display *") long paramLong1, @NativeType("Window") long paramLong2) {
/* 649 */     long l = Functions.XDestroyWindow;
/* 650 */     if (Checks.CHECKS) {
/* 651 */       Checks.check(paramLong1);
/*     */     }
/* 653 */     return JNI.invokePNI(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nXFree(long paramLong) {
/* 660 */     long l = Functions.XFree;
/* 661 */     return JNI.invokePI(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int XFree(@NativeType("void *") ByteBuffer paramByteBuffer) {
/* 670 */     return nXFree(MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int XFree(@NativeType("void *") PointerBuffer paramPointerBuffer) {
/* 679 */     return nXFree(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nXSendEvent(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4) {
/* 686 */     long l = Functions.XSendEvent;
/* 687 */     if (Checks.CHECKS) {
/* 688 */       Checks.check(paramLong1);
/*     */     }
/* 690 */     return JNI.invokePNNPI(paramLong1, paramLong2, paramInt, paramLong3, paramLong4, l);
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
/*     */   @NativeType("Status")
/*     */   public static int XSendEvent(@NativeType("Display *") long paramLong1, @NativeType("Window") long paramLong2, @NativeType("Bool") boolean paramBoolean, long paramLong3, @NativeType("XEvent *") XEvent paramXEvent) {
/* 736 */     return nXSendEvent(paramLong1, paramLong2, paramBoolean ? 1 : 0, paramLong3, paramXEvent.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned long")
/*     */   public static long XDisplayMotionBufferSize(@NativeType("Display *") long paramLong) {
/* 744 */     long l = Functions.XDisplayMotionBufferSize;
/* 745 */     if (Checks.CHECKS) {
/* 746 */       Checks.check(paramLong);
/*     */     }
/* 748 */     return JNI.invokePN(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nXGetMotionEvents(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/* 755 */     long l = Functions.XGetMotionEvents;
/* 756 */     if (Checks.CHECKS) {
/* 757 */       Checks.check(paramLong1);
/*     */     }
/* 759 */     return JNI.invokePNNNPP(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, l);
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
/*     */   @NativeType("XTimeCoord *")
/*     */   public static XTimeCoord.Buffer XGetMotionEvents(@NativeType("Display *") long paramLong1, @NativeType("Window") long paramLong2, @NativeType("Time") long paramLong3, @NativeType("Time") long paramLong4) {
/*     */     MemoryStack memoryStack;
/* 775 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/* 776 */     IntBuffer intBuffer = memoryStack.callocInt(1);
/*     */     try {
/*     */       long l;
/* 779 */       return XTimeCoord.createSafe(l = nXGetMotionEvents(paramLong1, paramLong2, paramLong3, paramLong4, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0));
/*     */     } finally {
/* 781 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nXTranslateCoordinates(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, long paramLong4, long paramLong5, long paramLong6) {
/* 789 */     long l = Functions.XTranslateCoordinates;
/* 790 */     if (Checks.CHECKS) {
/* 791 */       Checks.check(paramLong1);
/*     */     }
/* 793 */     return JNI.invokePNNPPPI(paramLong1, paramLong2, paramLong3, paramInt1, paramInt2, paramLong4, paramLong5, paramLong6, l);
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
/*     */   @NativeType("Bool")
/*     */   public static boolean XTranslateCoordinates(@NativeType("Display *") long paramLong1, @NativeType("Window") long paramLong2, @NativeType("Window") long paramLong3, int paramInt1, int paramInt2, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("Window *") CLongBuffer paramCLongBuffer) {
/* 818 */     if (Checks.CHECKS) {
/* 819 */       Checks.check(paramIntBuffer1, 1);
/* 820 */       Checks.check(paramIntBuffer2, 1);
/* 821 */       Checks.check((CustomBuffer)paramCLongBuffer, 1);
/*     */     } 
/* 823 */     return (nXTranslateCoordinates(paramLong1, paramLong2, paramLong3, paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress((CustomBuffer)paramCLongBuffer)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean XTranslateCoordinates(@NativeType("Display *") long paramLong1, @NativeType("Window") long paramLong2, @NativeType("Window") long paramLong3, int paramInt1, int paramInt2, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("Window *") CLongBuffer paramCLongBuffer) {
/* 829 */     long l = Functions.XTranslateCoordinates;
/* 830 */     if (Checks.CHECKS) {
/* 831 */       Checks.check(paramLong1);
/* 832 */       Checks.check(paramArrayOfint1, 1);
/* 833 */       Checks.check(paramArrayOfint2, 1);
/* 834 */       Checks.check((CustomBuffer)paramCLongBuffer, 1);
/*     */     } 
/* 836 */     return (JNI.invokePNNPPPI(paramLong1, paramLong2, paramLong3, paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, MemoryUtil.memAddress((CustomBuffer)paramCLongBuffer), l) != 0);
/*     */   } }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\linux\X11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */