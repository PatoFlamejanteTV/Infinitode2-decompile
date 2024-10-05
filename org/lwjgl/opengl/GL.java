/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.HashSet;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.function.IntFunction;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Configuration;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.Platform;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ import org.lwjgl.system.ThreadLocalUtil;
/*     */ import org.lwjgl.system.linux.X11;
/*     */ import org.lwjgl.system.windows.GDI32;
/*     */ import org.lwjgl.system.windows.PIXELFORMATDESCRIPTOR;
/*     */ import org.lwjgl.system.windows.User32;
/*     */ import org.lwjgl.system.windows.WNDCLASSEX;
/*     */ import org.lwjgl.system.windows.WindowsLibrary;
/*     */ import org.lwjgl.system.windows.WindowsUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GL
/*     */ {
/*     */   private static final APIUtil.APIVersion MAX_VERSION;
/*     */   private static FunctionProvider functionProvider;
/*  67 */   private static final ThreadLocal<GLCapabilities> capabilitiesTLS = new ThreadLocal<>();
/*     */   
/*  69 */   private static ICD icd = new ICDStatic();
/*     */ 
/*     */   
/*     */   private static WGLCapabilities capabilitiesWGL;
/*     */   
/*     */   private static GLXCapabilities capabilitiesGLXClient;
/*     */   
/*     */   private static GLXCapabilities capabilitiesGLX;
/*     */ 
/*     */   
/*     */   static {
/*  80 */     Library.loadSystem(System::load, System::loadLibrary, GL.class, "org.lwjgl.opengl", Platform.mapLibraryNameBundled("lwjgl_opengl"));
/*     */     
/*  82 */     MAX_VERSION = APIUtil.apiParseVersion(Configuration.OPENGL_MAXVERSION);
/*     */     
/*  84 */     if (!((Boolean)Configuration.OPENGL_EXPLICIT_INIT.get(Boolean.FALSE)).booleanValue()) {
/*  85 */       create();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void initialize() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create() {
/*     */     SharedLibrary sharedLibrary;
/*  99 */     switch (Platform.get()) {
/*     */       case LINUX:
/* 101 */         sharedLibrary = Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.OPENGL_LIBRARY_NAME, new String[] { "libGLX.so.0", "libGL.so.1", "libGL.so" });
/*     */         break;
/*     */       case MACOSX:
/* 104 */         sharedLibrary = Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.OPENGL_LIBRARY_NAME, new String[] { "/System/Library/Frameworks/OpenGL.framework/Versions/Current/OpenGL" });
/*     */         break;
/*     */       case WINDOWS:
/* 107 */         sharedLibrary = Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.OPENGL_LIBRARY_NAME, new String[] { "opengl32" });
/*     */         break;
/*     */       default:
/* 110 */         throw new IllegalStateException();
/*     */     } 
/* 112 */     create(sharedLibrary);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create(String paramString) {
/* 121 */     create(Library.loadNative(GL.class, "org.lwjgl.opengl", paramString));
/*     */   }
/*     */   
/*     */   private static void create(SharedLibrary paramSharedLibrary) {
/*     */     try {
/* 126 */       create((FunctionProvider)new SharedLibrary.Delegate(paramSharedLibrary)
/*     */           {
/*     */             private final long GetProcAddress;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public final long getFunctionAddress(ByteBuffer param1ByteBuffer) {
/*     */               long l;
/* 155 */               if ((l = (this.GetProcAddress == 0L) ? 0L : ((Platform.get() == Platform.WINDOWS) ? WGL.nwglGetProcAddress(MemoryUtil.memAddress(param1ByteBuffer), this.GetProcAddress) : JNI.callPP(MemoryUtil.memAddress(param1ByteBuffer), this.GetProcAddress))) == 0L && (
/*     */                 
/* 157 */                 l = this.library.getFunctionAddress(param1ByteBuffer)) == 0L && Checks.DEBUG_FUNCTIONS) {
/* 158 */                 APIUtil.apiLogMissing("GL", param1ByteBuffer);
/*     */               }
/*     */ 
/*     */               
/* 162 */               return l; }
/*     */           });
/*     */       return;
/* 165 */     } catch (RuntimeException runtimeException) {
/* 166 */       paramSharedLibrary.free();
/* 167 */       throw runtimeException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create(FunctionProvider paramFunctionProvider) {
/* 177 */     if (functionProvider != null) {
/* 178 */       throw new IllegalStateException("OpenGL library has already been loaded.");
/*     */     }
/*     */     
/* 181 */     functionProvider = paramFunctionProvider;
/* 182 */     ThreadLocalUtil.setFunctionMissingAddresses(2228);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void destroy() {
/* 187 */     if (functionProvider == null) {
/*     */       return;
/*     */     }
/*     */     
/* 191 */     ThreadLocalUtil.setFunctionMissingAddresses(0);
/*     */     
/* 193 */     capabilitiesWGL = null;
/* 194 */     capabilitiesGLX = null;
/*     */     
/* 196 */     if (functionProvider instanceof NativeResource) {
/* 197 */       ((NativeResource)functionProvider).free();
/*     */     }
/* 199 */     functionProvider = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static FunctionProvider getFunctionProvider() {
/* 205 */     return functionProvider;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCapabilities(GLCapabilities paramGLCapabilities) {
/* 215 */     capabilitiesTLS.set(paramGLCapabilities);
/* 216 */     ThreadLocalUtil.setCapabilities((paramGLCapabilities == null) ? 0L : MemoryUtil.memAddress((CustomBuffer)paramGLCapabilities.addresses));
/* 217 */     icd.set(paramGLCapabilities);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLCapabilities getCapabilities() {
/* 226 */     return checkCapabilities(capabilitiesTLS.get());
/*     */   }
/*     */   
/*     */   private static GLCapabilities checkCapabilities(GLCapabilities paramGLCapabilities) {
/* 230 */     if (Checks.CHECKS && paramGLCapabilities == null) {
/* 231 */       throw new IllegalStateException("No GLCapabilities instance set for the current thread. Possible solutions:\n\ta) Call GL.createCapabilities() after making a context current in the current thread.\n\tb) Call GL.setCapabilities() if a GLCapabilities instance already exists for the current context.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     return paramGLCapabilities;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WGLCapabilities getCapabilitiesWGL() {
/* 247 */     if (capabilitiesWGL == null) {
/* 248 */       capabilitiesWGL = createCapabilitiesWGLDummy();
/*     */     }
/*     */     
/* 251 */     return capabilitiesWGL;
/*     */   }
/*     */ 
/*     */   
/*     */   static GLXCapabilities getCapabilitiesGLXClient() {
/* 256 */     if (capabilitiesGLXClient == null) {
/* 257 */       capabilitiesGLXClient = initCapabilitiesGLX(true);
/*     */     }
/*     */     
/* 260 */     return capabilitiesGLXClient;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLXCapabilities getCapabilitiesGLX() {
/* 269 */     if (capabilitiesGLX == null) {
/* 270 */       capabilitiesGLX = initCapabilitiesGLX(false);
/*     */     }
/*     */     
/* 273 */     return capabilitiesGLX;
/*     */   }
/*     */   
/*     */   private static GLXCapabilities initCapabilitiesGLX(boolean paramBoolean) {
/* 277 */     long l = X11.nXOpenDisplay(0L);
/*     */     try {
/* 279 */       return createCapabilitiesGLX(l, paramBoolean ? -1 : X11.XDefaultScreen(l));
/*     */     } finally {
/* 281 */       X11.XCloseDisplay(l);
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
/*     */   public static GLCapabilities createCapabilities() {
/* 295 */     return createCapabilities((IntFunction<PointerBuffer>)null);
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
/*     */   public static GLCapabilities createCapabilities(IntFunction<PointerBuffer> paramIntFunction) {
/* 311 */     return createCapabilities(false, paramIntFunction);
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
/*     */   public static GLCapabilities createCapabilities(boolean paramBoolean) {
/* 327 */     return createCapabilities(paramBoolean, null);
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
/*     */   public static GLCapabilities createCapabilities(boolean paramBoolean, IntFunction<PointerBuffer> paramIntFunction) {
/*     */     int i;
/*     */     FunctionProvider functionProvider;
/* 347 */     if ((functionProvider = functionProvider) == null) {
/* 348 */       throw new IllegalStateException("OpenGL library has not been loaded.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 353 */     long l1 = functionProvider.getFunctionAddress("glGetError");
/* 354 */     long l2 = functionProvider.getFunctionAddress("glGetString");
/* 355 */     long l3 = functionProvider.getFunctionAddress("glGetIntegerv");
/*     */     
/* 357 */     if (l1 == 0L || l2 == 0L || l3 == 0L) {
/* 358 */       throw new IllegalStateException("Core OpenGL functions could not be found. Make sure that the OpenGL library has been loaded correctly.");
/*     */     }
/*     */     
/*     */     int j;
/* 362 */     if ((j = JNI.callI(l1)) != 0) {
/* 363 */       APIUtil.apiLog(String.format("An OpenGL context was in an error state before the creation of its capabilities instance. Error: 0x%X", new Object[] { Integer.valueOf(j) }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 369 */     try (MemoryStack null = MemoryStack.stackPush()) {
/* 370 */       IntBuffer intBuffer = memoryStack.ints(0);
/*     */ 
/*     */       
/* 373 */       JNI.callPV(33307, MemoryUtil.memAddress(intBuffer), l3);
/* 374 */       if (JNI.callI(l1) == 0 && 3 <= (j = intBuffer.get(0))) {
/*     */         
/* 376 */         JNI.callPV(33308, MemoryUtil.memAddress(intBuffer), l3);
/* 377 */         i = intBuffer.get(0);
/*     */       } else {
/*     */         String str;
/*     */         
/* 381 */         if ((str = MemoryUtil.memUTF8Safe(JNI.callP(7938, l2))) == null || JNI.callI(i) != 0) {
/* 382 */           throw new IllegalStateException("There is no OpenGL context current in the current thread.");
/*     */         }
/*     */         
/*     */         APIUtil.APIVersion aPIVersion;
/*     */         
/* 387 */         j = (aPIVersion = APIUtil.apiParseVersion(str)).major;
/* 388 */         i = aPIVersion.minor;
/*     */       } 
/*     */     } 
/*     */     
/* 392 */     if (j <= 0 || (j == 1 && i <= 0)) {
/* 393 */       throw new IllegalStateException("OpenGL 1.1 is required.");
/*     */     }
/*     */     
/* 396 */     int[] arrayOfInt = { 5, 1, 3, 6 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 403 */     HashSet<String> hashSet = new HashSet(512);
/*     */     
/* 405 */     int k = Math.min(j, 4);
/* 406 */     if (MAX_VERSION != null) {
/* 407 */       k = Math.min(MAX_VERSION.major, k);
/*     */     }
/* 409 */     for (byte b = 1; b <= k; b++) {
/* 410 */       int m = arrayOfInt[b - 1];
/* 411 */       if (b == j) {
/* 412 */         m = Math.min(i, m);
/*     */       }
/* 414 */       if (MAX_VERSION != null && b == MAX_VERSION.major) {
/* 415 */         m = Math.min(MAX_VERSION.minor, m);
/*     */       }
/*     */       
/* 418 */       for (byte b1 = (b == 1) ? 1 : 0; b1 <= m; b1++) {
/* 419 */         hashSet.add("OpenGL" + b + b1);
/*     */       }
/*     */     } 
/*     */     
/* 423 */     if (j < 3) {
/*     */       String str;
/*     */       
/* 426 */       if ((str = MemoryUtil.memASCIISafe(JNI.callP(7939, throwable2))) != null) {
/* 427 */         StringTokenizer stringTokenizer = new StringTokenizer(str);
/* 428 */         while (stringTokenizer.hasMoreTokens()) {
/* 429 */           hashSet.add(stringTokenizer.nextToken());
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 434 */       try (MemoryStack null = MemoryStack.stackPush()) {
/* 435 */         IntBuffer intBuffer = memoryStack1.ints(0);
/*     */         
/* 437 */         JNI.callPV(33309, MemoryUtil.memAddress(intBuffer), l3);
/* 438 */         int m = intBuffer.get(0);
/*     */         
/* 440 */         long l = APIUtil.apiGetFunctionAddress(functionProvider, "glGetStringi");
/* 441 */         for (byte b1 = 0; b1 < m; b1++) {
/* 442 */           hashSet.add(MemoryUtil.memASCII(JNI.callP(7939, b1, l)));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 451 */         JNI.callPV(33310, MemoryUtil.memAddress(intBuffer), l3);
/* 452 */         if ((intBuffer.get(0) & 0x1) != 0) {
/* 453 */           paramBoolean = true;
/*     */         
/*     */         }
/* 456 */         else if (3 < j || i > 0) {
/* 457 */           if (3 < j || 2 <= i) {
/* 458 */             JNI.callPV(37158, MemoryUtil.memAddress(intBuffer), l3);
/* 459 */             if ((intBuffer.get(0) & 0x1) != 0) {
/* 460 */               paramBoolean = true;
/*     */             }
/*     */           } else {
/* 463 */             paramBoolean = !hashSet.contains("GL_ARB_compatibility");
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 469 */     APIUtil.apiFilterExtensions(hashSet, Configuration.OPENGL_EXTENSION_FILTER);
/*     */ 
/*     */     
/*     */     GLCapabilities gLCapabilities;
/*     */ 
/*     */     
/* 475 */     setCapabilities(gLCapabilities = new GLCapabilities(functionProvider, hashSet, paramBoolean, (throwable1 == null) ? BufferUtils::createPointerBuffer : (IntFunction<PointerBuffer>)throwable1));
/*     */     
/* 477 */     return gLCapabilities;
/*     */   }
/*     */ 
/*     */   
/*     */   private static WGLCapabilities createCapabilitiesWGLDummy() {
/*     */     long l1;
/* 483 */     if ((l1 = WGL.wglGetCurrentDC()) != 0L) {
/* 484 */       return createCapabilitiesWGL(l1);
/*     */     }
/*     */     
/* 487 */     short s = 0;
/* 488 */     long l2 = 0L;
/* 489 */     long l3 = 0L;
/* 490 */     try (MemoryStack null = MemoryStack.stackPush()) {
/*     */       WNDCLASSEX wNDCLASSEX;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 497 */       MemoryUtil.memPutAddress((wNDCLASSEX = WNDCLASSEX.calloc(memoryStack).cbSize(WNDCLASSEX.SIZEOF).style(3).hInstance(WindowsLibrary.HINSTANCE).lpszClassName(memoryStack.UTF16("WGL")))
/* 498 */           .address() + WNDCLASSEX.LPFNWNDPROC, User32.Functions.DefWindowProc);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 503 */       if ((s = User32.RegisterClassEx(wNDCLASSEX)) == 0) {
/* 504 */         throw new IllegalStateException("Failed to register WGL window class");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 514 */       long l = Checks.check(User32.GetDC(l2 = Checks.check(User32.nCreateWindowEx(0, (s & 0xFFFF), 0L, 114229248, 0, 0, 1, 1, 0L, 0L, 0L, 0L))));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 519 */       PIXELFORMATDESCRIPTOR pIXELFORMATDESCRIPTOR = PIXELFORMATDESCRIPTOR.calloc(memoryStack).nSize((short)PIXELFORMATDESCRIPTOR.SIZEOF).nVersion((short)1).dwFlags(32);
/*     */       
/*     */       int i;
/* 522 */       if ((i = GDI32.ChoosePixelFormat(l, pIXELFORMATDESCRIPTOR)) == 0) {
/* 523 */         WindowsUtil.windowsThrowException("Failed to choose an OpenGL-compatible pixel format");
/*     */       }
/*     */       
/* 526 */       if (GDI32.DescribePixelFormat(l, i, pIXELFORMATDESCRIPTOR) == 0) {
/* 527 */         WindowsUtil.windowsThrowException("Failed to obtain pixel format information");
/*     */       }
/*     */       
/* 530 */       if (!GDI32.SetPixelFormat(l, i, pIXELFORMATDESCRIPTOR)) {
/* 531 */         WindowsUtil.windowsThrowException("Failed to set the pixel format");
/*     */       }
/*     */       
/* 534 */       l3 = Checks.check(WGL.wglCreateContext(l));
/* 535 */       WGL.wglMakeCurrent(l, l3);
/*     */       
/* 537 */       return createCapabilitiesWGL(l);
/*     */     } finally {
/* 539 */       if (l3 != 0L) {
/* 540 */         WGL.wglMakeCurrent(0L, 0L);
/* 541 */         WGL.wglDeleteContext(l3);
/*     */       } 
/*     */       
/* 544 */       if (l2 != 0L) {
/* 545 */         User32.DestroyWindow(l2);
/*     */       }
/*     */       
/* 548 */       if (s != 0) {
/* 549 */         User32.nUnregisterClass((s & 0xFFFF), WindowsLibrary.HINSTANCE);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WGLCapabilities createCapabilitiesWGL() {
/*     */     long l;
/* 561 */     if ((l = WGL.wglGetCurrentDC()) == 0L) {
/* 562 */       throw new IllegalStateException("Failed to retrieve the device context of the current OpenGL context");
/*     */     }
/*     */     
/* 565 */     return createCapabilitiesWGL(l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static WGLCapabilities createCapabilitiesWGL(long paramLong) {
/*     */     FunctionProvider functionProvider;
/* 575 */     if ((functionProvider = functionProvider) == null) {
/* 576 */       throw new IllegalStateException("OpenGL library has not been loaded.");
/*     */     }
/*     */     
/* 579 */     String str = null;
/*     */     
/*     */     long l;
/* 582 */     if ((l = functionProvider.getFunctionAddress("wglGetExtensionsStringARB")) != 0L) {
/* 583 */       str = MemoryUtil.memASCII(JNI.callPP(paramLong, l));
/*     */     
/*     */     }
/* 586 */     else if ((l = functionProvider.getFunctionAddress("wglGetExtensionsStringEXT")) != 0L) {
/* 587 */       str = MemoryUtil.memASCII(JNI.callP(l));
/*     */     } 
/*     */ 
/*     */     
/* 591 */     HashSet<String> hashSet = new HashSet(32);
/*     */     
/* 593 */     if (str != null) {
/* 594 */       StringTokenizer stringTokenizer = new StringTokenizer(str);
/* 595 */       while (stringTokenizer.hasMoreTokens()) {
/* 596 */         hashSet.add(stringTokenizer.nextToken());
/*     */       }
/*     */     } 
/*     */     
/* 600 */     APIUtil.apiFilterExtensions(hashSet, Configuration.OPENGL_EXTENSION_FILTER);
/*     */     
/* 602 */     return new WGLCapabilities(functionProvider, hashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLXCapabilities createCapabilitiesGLX(long paramLong) {
/* 613 */     return createCapabilitiesGLX(paramLong, X11.XDefaultScreen(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLXCapabilities createCapabilitiesGLX(long paramLong, int paramInt) {
/*     */     int i, j;
/*     */     FunctionProvider functionProvider;
/* 626 */     if ((functionProvider = functionProvider) == null) {
/* 627 */       throw new IllegalStateException("OpenGL library has not been loaded.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 633 */     try (MemoryStack null = MemoryStack.stackPush()) {
/* 634 */       IntBuffer intBuffer1 = memoryStack.ints(0);
/* 635 */       IntBuffer intBuffer2 = memoryStack.ints(0);
/*     */       
/* 637 */       if (!GLX11.glXQueryVersion(paramLong, intBuffer1, intBuffer2)) {
/* 638 */         throw new IllegalStateException("Failed to query GLX version");
/*     */       }
/*     */       
/* 641 */       i = intBuffer1.get(0);
/* 642 */       j = intBuffer2.get(0);
/* 643 */       if (i != 1) {
/* 644 */         throw new IllegalStateException("Invalid GLX major version: " + i);
/*     */       }
/*     */     } 
/*     */     
/* 648 */     HashSet<String> hashSet = new HashSet(32);
/*     */     
/* 650 */     int[][] arrayOfInt = { { 1, 2, 3, 4 } };
/*     */ 
/*     */ 
/*     */     
/* 654 */     for (byte b = 1; b <= 1; b++) {
/*     */       int[] arrayOfInt1; int k; int[] arrayOfInt2; byte b1;
/* 656 */       for (k = (arrayOfInt2 = arrayOfInt1 = arrayOfInt[b - 1]).length, b1 = 0; b1 < k; ) { int m = arrayOfInt2[b1];
/* 657 */         if (b < i || (b == i && m <= j)) {
/* 658 */           hashSet.add("GLX" + b + m);
/*     */         }
/*     */         b1++; }
/*     */     
/*     */     } 
/* 663 */     if (j > 0) {
/*     */       String str;
/*     */       
/* 666 */       if (paramInt == -1) {
/* 667 */         long l = functionProvider.getFunctionAddress("glXGetClientString");
/* 668 */         str = MemoryUtil.memASCIISafe(JNI.callPP(paramLong, 3, l));
/*     */       } else {
/* 670 */         long l = functionProvider.getFunctionAddress("glXQueryExtensionsString");
/* 671 */         str = MemoryUtil.memASCIISafe(JNI.callPP(paramLong, paramInt, l));
/*     */       } 
/*     */       
/* 674 */       if (str != null) {
/* 675 */         StringTokenizer stringTokenizer = new StringTokenizer(str);
/* 676 */         while (stringTokenizer.hasMoreTokens()) {
/* 677 */           hashSet.add(stringTokenizer.nextToken());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 682 */     APIUtil.apiFilterExtensions(hashSet, Configuration.OPENGL_EXTENSION_FILTER);
/*     */     
/* 684 */     return new GLXCapabilities(functionProvider, hashSet);
/*     */   }
/*     */ 
/*     */   
/*     */   static GLCapabilities getICD() {
/* 689 */     return checkCapabilities(icd.get());
/*     */   }
/*     */ 
/*     */   
/*     */   private static interface ICD
/*     */   {
/*     */     default void set(GLCapabilities param1GLCapabilities) {}
/*     */ 
/*     */     
/*     */     GLCapabilities get();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ICDStatic
/*     */     implements ICD
/*     */   {
/*     */     private static GLCapabilities tempCaps;
/*     */ 
/*     */     
/*     */     private ICDStatic() {}
/*     */ 
/*     */     
/*     */     public void set(GLCapabilities param1GLCapabilities) {
/* 712 */       if (tempCaps == null) {
/* 713 */         tempCaps = param1GLCapabilities; return;
/* 714 */       }  if (param1GLCapabilities != null && param1GLCapabilities != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(tempCaps.addresses, param1GLCapabilities.addresses)) {
/* 715 */         APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread-local lookup for GL contexts.");
/* 716 */         GL.icd = GL::getCapabilities;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public GLCapabilities get() {
/* 722 */       return WriteOnce.caps;
/*     */     }
/*     */     
/*     */     private static final class WriteOnce
/*     */     {
/*     */       static final GLCapabilities caps;
/*     */       
/*     */       static {
/*     */         GLCapabilities gLCapabilities;
/* 731 */         if ((gLCapabilities = GL.ICDStatic.tempCaps) == null) {
/* 732 */           throw new IllegalStateException("No GLCapabilities instance has been set");
/*     */         }
/* 734 */         caps = gLCapabilities;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */