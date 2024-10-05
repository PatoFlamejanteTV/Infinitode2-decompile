/*     */ package org.lwjgl.system.macosx;public class CoreGraphics { public static final int kCGErrorSuccess = 0; public static final int kCGErrorFailure = 1000; public static final int kCGErrorIllegalArgument = 1001;
/*     */   public static final int kCGErrorInvalidConnection = 1002;
/*     */   public static final int kCGErrorInvalidContext = 1003;
/*     */   public static final int kCGErrorCannotComplete = 1004;
/*     */   public static final int kCGErrorNotImplemented = 1006;
/*     */   public static final int kCGErrorRangeCheck = 1007;
/*     */   public static final int kCGErrorTypeCheck = 1008;
/*     */   public static final int kCGErrorInvalidOperation = 1010;
/*     */   public static final int kCGErrorNoneAvailable = 1011;
/*     */   public static final int kCGEventNull = 0;
/*     */   public static final int kCGEventLeftMouseDown = 1;
/*     */   public static final int kCGEventLeftMouseUp = 2;
/*     */   public static final int kCGEventRightMouseDown = 3;
/*     */   public static final int kCGEventRightMouseUp = 4;
/*     */   public static final int kCGEventMouseMoved = 5;
/*     */   public static final int kCGEventLeftMouseDragged = 6;
/*     */   public static final int kCGEventRightMouseDragged = 7;
/*     */   public static final int kCGEventKeyDown = 10;
/*     */   public static final int kCGEventKeyUp = 11;
/*     */   public static final int kCGEventFlagsChanged = 12;
/*     */   public static final int kCGEventScrollWheel = 22;
/*     */   public static final int kCGEventTabletPointer = 23;
/*     */   public static final int kCGEventTabletProximity = 24;
/*  24 */   private static final SharedLibrary COREGRAPHICS = Library.loadNative(CoreGraphics.class, "org.lwjgl", "/System/Library/Frameworks/CoreGraphics.framework"); public static final int kCGEventOtherMouseDown = 25; public static final int kCGEventOtherMouseUp = 26; public static final int kCGEventOtherMouseDragged = 27; public static final int kCGEventTapDisabledByTimeout = -2; public static final int kCGEventTapDisabledByUserInput = -1; public static final int kCGMouseButtonLeft = 0; public static final int kCGMouseButtonRight = 1; public static final int kCGMouseButtonCenter = 2; public static final int kCGHIDEventTap = 0; public static final int kCGSessionEventTap = 1; public static final int kCGAnnotatedSessionEventTap = 2; public static final int kCGScrollEventUnitPixel = 0; public static final int kCGScrollEventUnitLine = 1; public static final int kCGMouseEventNumber = 0; public static final int kCGMouseEventClickState = 1; public static final int kCGMouseEventPressure = 2; public static final int kCGMouseEventButtonNumber = 3; public static final int kCGMouseEventDeltaX = 4; public static final int kCGMouseEventDeltaY = 5; public static final int kCGMouseEventInstantMouser = 6; public static final int kCGMouseEventSubtype = 7; public static final int kCGKeyboardEventAutorepeat = 8; public static final int kCGKeyboardEventKeycode = 9; public static final int kCGKeyboardEventKeyboardType = 10; public static final int kCGScrollWheelEventDeltaAxis1 = 11; public static final int kCGScrollWheelEventDeltaAxis2 = 12; public static final int kCGScrollWheelEventDeltaAxis3 = 13; public static final int kCGScrollWheelEventFixedPtDeltaAxis1 = 93; public static final int kCGScrollWheelEventFixedPtDeltaAxis2 = 94; public static final int kCGScrollWheelEventFixedPtDeltaAxis3 = 95; public static final int kCGScrollWheelEventPointDeltaAxis1 = 96; public static final int kCGScrollWheelEventPointDeltaAxis2 = 97; public static final int kCGScrollWheelEventPointDeltaAxis3 = 98; public static final int kCGScrollWheelEventScrollPhase = 99; public static final int kCGScrollWheelEventScrollCount = 100; public static final int kCGScrollWheelEventMomentumPhase = 123; public static final int kCGScrollWheelEventInstantMouser = 14; public static final int kCGTabletEventPointX = 15; public static final int kCGTabletEventPointY = 16; public static final int kCGTabletEventPointZ = 17; public static final int kCGTabletEventPointButtons = 18; public static final int kCGTabletEventPointPressure = 19; public static final int kCGTabletEventTiltX = 20; public static final int kCGTabletEventTiltY = 21; public static final int kCGTabletEventRotation = 22; public static final int kCGTabletEventTangentialPressure = 23; public static final int kCGTabletEventDeviceID = 24; public static final int kCGTabletEventVendor1 = 25; public static final int kCGTabletEventVendor2 = 26; public static final int kCGTabletEventVendor3 = 27; public static final int kCGTabletProximityEventVendorID = 28; public static final int kCGTabletProximityEventTabletID = 29; public static final int kCGTabletProximityEventPointerID = 30; public static final int kCGTabletProximityEventDeviceID = 31; public static final int kCGTabletProximityEventSystemTabletID = 32; public static final int kCGTabletProximityEventVendorPointerType = 33; public static final int kCGTabletProximityEventVendorPointerSerialNumber = 34; public static final int kCGTabletProximityEventVendorUniqueID = 35; public static final int kCGTabletProximityEventCapabilityMask = 36; public static final int kCGTabletProximityEventPointerType = 37; public static final int kCGTabletProximityEventEnterProximity = 38; public static final int kCGEventTargetProcessSerialNumber = 39; public static final int kCGEventTargetUnixProcessID = 40; public static final int kCGEventSourceUnixProcessID = 41; public static final int kCGEventSourceUserData = 42; public static final int kCGEventSourceUserID = 43; public static final int kCGEventSourceGroupID = 44;
/*     */   public static final int kCGEventSourceStateID = 45;
/*     */   public static final int kCGScrollWheelEventIsContinuous = 88;
/*     */   public static final int kCGMouseEventWindowUnderMousePointer = 91;
/*     */   public static final int kCGMouseEventWindowUnderMousePointerThatCanHandleThisEvent = 92;
/*     */   public static final int kCGEventMouseSubtypeDefault = 0;
/*     */   public static final int kCGEventMouseSubtypeTabletPoint = 1;
/*     */   public static final int kCGEventMouseSubtypeTabletProximity = 2;
/*     */   
/*  33 */   public static final class Functions { public static final long EventGetTypeID = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetTypeID");
/*  34 */     public static final long EventCreate = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreate");
/*  35 */     public static final long EventCreateData = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateData");
/*  36 */     public static final long EventCreateFromData = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateFromData");
/*  37 */     public static final long EventCreateMouseEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateMouseEvent");
/*  38 */     public static final long EventCreateKeyboardEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateKeyboardEvent");
/*  39 */     public static final long EventCreateScrollWheelEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateScrollWheelEvent");
/*  40 */     public static final long EventCreateScrollWheelEvent2 = APIUtil.apiGetFunctionAddressOptional(CoreGraphics.COREGRAPHICS, "CGEventCreateScrollWheelEvent2");
/*  41 */     public static final long EventCreateCopy = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateCopy");
/*  42 */     public static final long EventCreateSourceFromEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateSourceFromEvent");
/*  43 */     public static final long EventSetSource = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetSource");
/*  44 */     public static final long EventGetType = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetType");
/*  45 */     public static final long EventSetType = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetType");
/*  46 */     public static final long EventGetTimestamp = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetTimestamp");
/*  47 */     public static final long EventSetTimestamp = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetTimestamp");
/*  48 */     public static final long EventGetLocation = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetLocation");
/*  49 */     public static final long EventGetUnflippedLocation = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetUnflippedLocation");
/*  50 */     public static final long EventSetLocation = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetLocation");
/*  51 */     public static final long EventGetFlags = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetFlags");
/*  52 */     public static final long EventSetFlags = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetFlags");
/*  53 */     public static final long EventKeyboardGetUnicodeString = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventKeyboardGetUnicodeString");
/*  54 */     public static final long EventKeyboardSetUnicodeString = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventKeyboardSetUnicodeString");
/*  55 */     public static final long EventGetIntegerValueField = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetIntegerValueField");
/*  56 */     public static final long EventSetIntegerValueField = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetIntegerValueField");
/*  57 */     public static final long EventGetDoubleValueField = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetDoubleValueField");
/*  58 */     public static final long EventSetDoubleValueField = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetDoubleValueField");
/*  59 */     public static final long EventTapCreate = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventTapCreate");
/*  60 */     public static final long EventTapCreateForPid = APIUtil.apiGetFunctionAddressOptional(CoreGraphics.COREGRAPHICS, "CGEventTapCreateForPid");
/*  61 */     public static final long EventTapEnable = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventTapEnable");
/*  62 */     public static final long EventTapIsEnabled = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventTapIsEnabled");
/*  63 */     public static final long EventTapPostEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventTapPostEvent");
/*  64 */     public static final long EventPost = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventPost");
/*  65 */     public static final long EventPostToPid = APIUtil.apiGetFunctionAddressOptional(CoreGraphics.COREGRAPHICS, "CGEventPostToPid");
/*  66 */     public static final long GetEventTapList = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGGetEventTapList"); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  72 */     return COREGRAPHICS;
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
/*     */   protected CoreGraphics() {
/* 418 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFTypeID")
/*     */   public static long CGEventGetTypeID() {
/*     */     long l;
/* 427 */     return JNI.invokeJ(l = Functions.EventGetTypeID);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreate(@NativeType("CGEventSourceRef") long paramLong) {
/* 435 */     long l = Functions.EventCreate;
/* 436 */     return JNI.invokePP(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFDataRef")
/*     */   public static long CGEventCreateData(@NativeType("CFAllocatorRef") long paramLong1, @NativeType("CGEventRef") long paramLong2) {
/* 444 */     long l = Functions.EventCreateData;
/* 445 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateFromData(@NativeType("CFAllocatorRef") long paramLong1, @NativeType("CFDataRef") long paramLong2) {
/* 453 */     long l = Functions.EventCreateFromData;
/* 454 */     return JNI.invokePPP(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nCGEventCreateMouseEvent(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {
/* 464 */     long l = Functions.EventCreateMouseEvent;
/* 465 */     return nCGEventCreateMouseEvent(paramLong1, paramInt1, paramLong2, paramInt2, l);
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
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateMouseEvent(@NativeType("CGEventSourceRef") long paramLong, @NativeType("CGEventType") int paramInt1, CGPoint paramCGPoint, @NativeType("CGMouseButton") int paramInt2) {
/* 480 */     return nCGEventCreateMouseEvent(paramLong, paramInt1, paramCGPoint.address(), paramInt2);
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
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateKeyboardEvent(@NativeType("CGEventSourceRef") long paramLong, @NativeType("CGKeyCode") short paramShort, @NativeType("bool") boolean paramBoolean) {
/* 502 */     long l = Functions.EventCreateKeyboardEvent;
/* 503 */     return JNI.invokePCP(paramLong, paramShort, paramBoolean, l);
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
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateScrollWheelEvent(@NativeType("CGEventSourceRef") long paramLong, @NativeType("CGScrollEventUnit") int paramInt1, @NativeType("uint32_t") int paramInt2, @NativeType("int32_t") int paramInt3) {
/* 521 */     long l = Functions.EventCreateScrollWheelEvent;
/* 522 */     return JNI.invokePP(paramLong, paramInt1, paramInt2, paramInt3, l);
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
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateScrollWheelEvent(@NativeType("CGEventSourceRef") long paramLong, @NativeType("CGScrollEventUnit") int paramInt1, @NativeType("int32_t") int paramInt2) {
/* 538 */     long l = Functions.EventCreateScrollWheelEvent;
/* 539 */     return JNI.invokePP(paramLong, paramInt1, 1, paramInt2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateScrollWheelEvent2(@NativeType("CGEventSourceRef") long paramLong, @NativeType("CGScrollEventUnit") int paramInt1, @NativeType("uint32_t") int paramInt2, @NativeType("int32_t") int paramInt3, @NativeType("int32_t") int paramInt4, @NativeType("int32_t") int paramInt5) {
/* 551 */     long l = Functions.EventCreateScrollWheelEvent2;
/* 552 */     if (Checks.CHECKS) {
/* 553 */       Checks.check(l);
/*     */     }
/* 555 */     return JNI.invokePP(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateCopy(@NativeType("CGEventRef") long paramLong) {
/* 563 */     long l = Functions.EventCreateCopy;
/* 564 */     return JNI.invokePP(paramLong, l);
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
/*     */   @NativeType("CGEventSourceRef")
/*     */   public static long CGEventCreateSourceFromEvent(@NativeType("CGEventRef") long paramLong) {
/* 579 */     long l = Functions.EventCreateSourceFromEvent;
/* 580 */     return JNI.invokePP(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventSetSource(@NativeType("CGEventRef") long paramLong1, @NativeType("CGEventSourceRef") long paramLong2) {
/* 587 */     long l = Functions.EventSetSource;
/* 588 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventType")
/*     */   public static int CGEventGetType(@NativeType("CGEventRef") long paramLong) {
/* 596 */     long l = Functions.EventGetType;
/* 597 */     return JNI.invokePI(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventSetType(@NativeType("CGEventRef") long paramLong, @NativeType("CGEventType") int paramInt) {
/* 604 */     long l = Functions.EventSetType;
/* 605 */     JNI.invokePV(paramLong, paramInt, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventTimestamp")
/*     */   public static long CGEventGetTimestamp(@NativeType("CGEventRef") long paramLong) {
/* 613 */     long l = Functions.EventGetTimestamp;
/* 614 */     return JNI.invokePJ(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventSetTimestamp(@NativeType("CGEventRef") long paramLong1, @NativeType("CGEventTimestamp") long paramLong2) {
/* 621 */     long l = Functions.EventSetTimestamp;
/* 622 */     JNI.invokePJV(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nCGEventGetLocation(long paramLong1, long paramLong2) {
/* 632 */     long l = Functions.EventGetLocation;
/* 633 */     nCGEventGetLocation(paramLong1, l, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGPoint CGEventGetLocation(@NativeType("CGEventRef") long paramLong, CGPoint paramCGPoint) {
/* 642 */     nCGEventGetLocation(paramLong, paramCGPoint.address());
/* 643 */     return paramCGPoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nCGEventGetUnflippedLocation(long paramLong1, long paramLong2) {
/* 653 */     long l = Functions.EventGetUnflippedLocation;
/* 654 */     nCGEventGetUnflippedLocation(paramLong1, l, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CGPoint CGEventGetUnflippedLocation(@NativeType("CGEventRef") long paramLong, CGPoint paramCGPoint) {
/* 663 */     nCGEventGetUnflippedLocation(paramLong, paramCGPoint.address());
/* 664 */     return paramCGPoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nCGEventSetLocation(long paramLong1, long paramLong2) {
/* 674 */     long l = Functions.EventSetLocation;
/* 675 */     nCGEventSetLocation(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void CGEventSetLocation(@NativeType("CGEventRef") long paramLong, CGPoint paramCGPoint) {
/* 680 */     nCGEventSetLocation(paramLong, paramCGPoint.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventFlags")
/*     */   public static long CGEventGetFlags(@NativeType("CGEventRef") long paramLong) {
/* 692 */     long l = Functions.EventGetFlags;
/* 693 */     return JNI.invokePJ(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventSetFlags(@NativeType("CGEventRef") long paramLong1, @NativeType("CGEventFlags") long paramLong2) {
/* 700 */     long l = Functions.EventSetFlags;
/* 701 */     JNI.invokePJV(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nCGEventKeyboardGetUnicodeString(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 708 */     long l = Functions.EventKeyboardGetUnicodeString;
/* 709 */     JNI.invokePNPPV(paramLong1, paramLong2, paramLong3, paramLong4, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventKeyboardGetUnicodeString(@NativeType("CGEventRef") long paramLong, @NativeType("UniCharCount *") CLongBuffer paramCLongBuffer, @NativeType("UniChar *") ShortBuffer paramShortBuffer) {
/* 719 */     if (Checks.CHECKS) {
/* 720 */       Checks.checkSafe((CustomBuffer)paramCLongBuffer, 1);
/*     */     }
/* 722 */     nCGEventKeyboardGetUnicodeString(paramLong, Checks.remainingSafe(paramShortBuffer), MemoryUtil.memAddressSafe((Pointer)paramCLongBuffer), MemoryUtil.memAddressSafe(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nCGEventKeyboardSetUnicodeString(long paramLong1, long paramLong2, long paramLong3) {
/* 729 */     long l = Functions.EventKeyboardSetUnicodeString;
/* 730 */     JNI.invokePNPV(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventKeyboardSetUnicodeString(@NativeType("CGEventRef") long paramLong, @NativeType("UniChar const *") ShortBuffer paramShortBuffer) {
/* 741 */     nCGEventKeyboardSetUnicodeString(paramLong, paramShortBuffer.remaining(), MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int64_t")
/*     */   public static long CGEventGetIntegerValueField(@NativeType("CGEventRef") long paramLong, @NativeType("CGEventField") int paramInt) {
/* 749 */     long l = Functions.EventGetIntegerValueField;
/* 750 */     return JNI.invokePJ(paramLong, paramInt, l);
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
/*     */   public static void CGEventSetIntegerValueField(@NativeType("CGEventRef") long paramLong1, @NativeType("CGEventField") int paramInt, @NativeType("int64_t") long paramLong2) {
/* 765 */     long l = Functions.EventSetIntegerValueField;
/* 766 */     JNI.invokePJV(paramLong1, paramInt, paramLong2, l);
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
/*     */   public static double CGEventGetDoubleValueField(@NativeType("CGEventRef") long paramLong, @NativeType("CGEventField") int paramInt) {
/* 778 */     long l = Functions.EventGetDoubleValueField;
/* 779 */     return JNI.invokePD(paramLong, paramInt, l);
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
/*     */   public static void CGEventSetDoubleValueField(@NativeType("CGEventRef") long paramLong, @NativeType("CGEventField") int paramInt, double paramDouble) {
/* 794 */     long l = Functions.EventSetDoubleValueField;
/* 795 */     JNI.invokePV(paramLong, paramInt, paramDouble, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nCGEventTapCreate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3) {
/* 802 */     long l = Functions.EventTapCreate;
/* 803 */     return JNI.invokeJPPP(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramLong3, l);
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
/*     */   @NativeType("CFMachPortRef")
/*     */   public static long CGEventTapCreate(@NativeType("CGEventTapLocation") int paramInt1, @NativeType("CGEventTapPlacement") int paramInt2, @NativeType("CGEventTapOptions") int paramInt3, @NativeType("CGEventMask") long paramLong1, @NativeType("CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)") CGEventTapCallBackI paramCGEventTapCallBackI, @NativeType("void *") long paramLong2) {
/* 836 */     return nCGEventTapCreate(paramInt1, paramInt2, paramInt3, paramLong1, paramCGEventTapCallBackI.address(), paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nCGEventTapCreateForPid(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, long paramLong4) {
/* 843 */     long l = Functions.EventTapCreateForPid;
/* 844 */     if (Checks.CHECKS) {
/* 845 */       Checks.check(l);
/* 846 */       Checks.check(paramLong1);
/*     */     } 
/* 848 */     return JNI.invokePJPPP(paramLong1, paramInt1, paramInt2, paramLong2, paramLong3, paramLong4, l);
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
/*     */   @NativeType("CFMachPortRef")
/*     */   public static long CGEventTapCreateForPid(@NativeType("pid_t") long paramLong1, @NativeType("CGEventTapPlacement") int paramInt1, @NativeType("CGEventTapOptions") int paramInt2, @NativeType("CGEventMask") long paramLong2, @NativeType("CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)") CGEventTapCallBackI paramCGEventTapCallBackI, @NativeType("void *") long paramLong3) {
/* 861 */     return nCGEventTapCreateForPid(paramLong1, paramInt1, paramInt2, paramLong2, paramCGEventTapCallBackI.address(), paramLong3);
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
/*     */   public static void CGEventTapEnable(@NativeType("CFMachPortRef") long paramLong, @NativeType("bool") boolean paramBoolean) {
/* 874 */     long l = Functions.EventTapEnable;
/* 875 */     if (Checks.CHECKS) {
/* 876 */       Checks.check(paramLong);
/*     */     }
/* 878 */     JNI.invokePV(paramLong, paramBoolean, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("bool")
/*     */   public static boolean CGEventTapIsEnabled(@NativeType("CFMachPortRef") long paramLong) {
/* 886 */     long l = Functions.EventTapIsEnabled;
/* 887 */     if (Checks.CHECKS) {
/* 888 */       Checks.check(paramLong);
/*     */     }
/* 890 */     return JNI.invokePZ(paramLong, l);
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
/*     */   public static void CGEventTapPostEvent(@NativeType("CGEventTapProxy") long paramLong1, @NativeType("CGEventRef") long paramLong2) {
/* 903 */     long l = Functions.EventTapPostEvent;
/* 904 */     JNI.invokePPV(paramLong1, paramLong2, l);
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
/*     */   public static void CGEventPost(@NativeType("CGEventTapLocation") int paramInt, @NativeType("CGEventRef") long paramLong) {
/* 919 */     long l = Functions.EventPost;
/* 920 */     if (Checks.CHECKS) {
/* 921 */       Checks.check(paramLong);
/*     */     }
/* 923 */     JNI.invokePV(paramInt, paramLong, l);
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
/*     */   public static void CGEventPostToPid(@NativeType("pid_t") long paramLong1, @NativeType("CGEventRef") long paramLong2) {
/* 940 */     long l = Functions.EventPostToPid;
/* 941 */     if (Checks.CHECKS) {
/* 942 */       Checks.check(l);
/* 943 */       Checks.check(paramLong1);
/*     */     } 
/* 945 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nCGGetEventTapList(int paramInt, long paramLong1, long paramLong2) {
/* 952 */     long l = Functions.GetEventTapList;
/* 953 */     return JNI.invokePPI(paramInt, paramLong1, paramLong2, l);
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
/*     */   @NativeType("CGError")
/*     */   public static int CGGetEventTapList(@NativeType("CGEventTapInformation *") CGEventTapInformation.Buffer paramBuffer, @NativeType("uint32_t *") IntBuffer paramIntBuffer) {
/* 970 */     if (Checks.CHECKS) {
/* 971 */       Checks.checkSafe(paramIntBuffer, 1);
/*     */     }
/* 973 */     return nCGGetEventTapList(Checks.remainingSafe((CustomBuffer)paramBuffer), MemoryUtil.memAddressSafe((Pointer)paramBuffer), MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void CGEventKeyboardGetUnicodeString(@NativeType("CGEventRef") long paramLong, @NativeType("UniCharCount *") CLongBuffer paramCLongBuffer, @NativeType("UniChar *") short[] paramArrayOfshort) {
/* 978 */     long l = Functions.EventKeyboardGetUnicodeString;
/* 979 */     if (Checks.CHECKS) {
/* 980 */       Checks.checkSafe((CustomBuffer)paramCLongBuffer, 1);
/*     */     }
/* 982 */     JNI.invokePNPPV(paramLong, Checks.lengthSafe(paramArrayOfshort), MemoryUtil.memAddressSafe((Pointer)paramCLongBuffer), paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void CGEventKeyboardSetUnicodeString(@NativeType("CGEventRef") long paramLong, @NativeType("UniChar const *") short[] paramArrayOfshort) {
/* 987 */     long l = Functions.EventKeyboardSetUnicodeString;
/* 988 */     JNI.invokePNPV(paramLong, paramArrayOfshort.length, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CGError")
/*     */   public static int CGGetEventTapList(@NativeType("CGEventTapInformation *") CGEventTapInformation.Buffer paramBuffer, @NativeType("uint32_t *") int[] paramArrayOfint) {
/* 994 */     long l = Functions.GetEventTapList;
/* 995 */     if (Checks.CHECKS) {
/* 996 */       Checks.checkSafe(paramArrayOfint, 1);
/*     */     }
/* 998 */     return JNI.invokePPI(Checks.remainingSafe((CustomBuffer)paramBuffer), MemoryUtil.memAddressSafe((Pointer)paramBuffer), paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native long nCGEventCreateMouseEvent(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*     */   
/*     */   public static native void nCGEventGetLocation(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nCGEventGetUnflippedLocation(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nCGEventSetLocation(long paramLong1, long paramLong2, long paramLong3); }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\CoreGraphics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */