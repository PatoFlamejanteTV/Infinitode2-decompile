/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.security.MessageDigest;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Enumeration;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.jar.Attributes;
/*     */ import java.util.jar.Manifest;
/*     */ import java.util.regex.Pattern;
/*     */ import org.lwjgl.Version;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Library
/*     */ {
/*  33 */   public static final String JNI_LIBRARY_NAME = Configuration.LIBRARY_NAME.get(Platform.mapLibraryNameBundled("lwjgl"));
/*     */   
/*     */   static final String JAVA_LIBRARY_PATH = "java.library.path";
/*     */   
/*  37 */   private static final Pattern PATH_SEPARATOR = Pattern.compile(File.pathSeparator);
/*     */   
/*  39 */   private static final Pattern NATIVES_JAR = Pattern.compile("/[\\w-]+?-natives-\\w+.jar!/");
/*     */   
/*     */   static {
/*  42 */     if (Checks.DEBUG) {
/*  43 */       APIUtil.DEBUG_STREAM.print("[LWJGL] Version: " + 
/*  44 */           Version.getVersion() + "\n\t OS: " + 
/*  45 */           System.getProperty("os.name") + " v" + System.getProperty("os.version") + "\n\tJRE: " + 
/*  46 */           Platform.get().getName() + " " + System.getProperty("os.arch") + " " + System.getProperty("java.version") + "\n\tJVM: " + 
/*  47 */           System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor") + "\n");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  52 */     loadSystem("org.lwjgl", JNI_LIBRARY_NAME);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initialize() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void loadSystem(String paramString1, String paramString2) {
/*  64 */     loadSystem(System::load, System::loadLibrary, Library.class, paramString1, paramString2);
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
/*     */   public static void loadSystem(Consumer<String> paramConsumer1, Consumer<String> paramConsumer2, Class<?> paramClass, String paramString1, String paramString2) {
/*  88 */     if (Checks.DEBUG) {
/*  89 */       APIUtil.DEBUG_STREAM.print("[LWJGL] Loading JNI library: " + paramString2 + "\n\tModule: " + paramString1 + "\n");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     if (Paths.get(paramString2, new String[0]).isAbsolute()) {
/*  98 */       paramConsumer1.accept(paramString2);
/*  99 */       APIUtil.apiLogMore("Success");
/*     */       
/*     */       return;
/*     */     } 
/* 103 */     String str1 = Platform.get().mapLibraryName(paramString2);
/*     */     
/* 105 */     boolean bool = paramString2.contains("lwjgl");
/*     */     
/*     */     URL uRL;
/*     */     
/* 109 */     if ((uRL = findResource(paramClass, paramString1, str1, bool)) == null) {
/* 110 */       if (loadSystemFromLibraryPath(paramConsumer1, paramClass, paramString1, str1, bool)) {
/*     */         return;
/*     */       }
/*     */     } else {
/* 114 */       boolean bool1 = ((Boolean)Configuration.DEBUG_LOADER.get(Boolean.FALSE)).booleanValue(); try {
/*     */         Throwable throwable; String str;
/* 116 */         if (!((Boolean)Configuration.SHARED_LIBRARY_EXTRACT_FORCE.get(Boolean.FALSE)).booleanValue() && (
/*     */           
/* 118 */           str = getRegularFilePath(uRL)) != null) {
/* 119 */           paramConsumer1.accept(str);
/* 120 */           APIUtil.apiLogMore("Loaded from classpath: " + str);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */ 
/*     */         
/* 127 */         if (bool1) {
/* 128 */           APIUtil.apiLogMore("Using SharedLibraryLoader...");
/*     */         }
/*     */         
/* 131 */         FileChannel fileChannel = SharedLibraryLoader.load(paramString2, str1, uRL, paramConsumer1); uRL = null; 
/* 132 */         try { if (loadSystemFromLibraryPath(paramConsumer1, paramClass, paramString1, str1, bool))
/*     */             return;  }
/*     */         catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 135 */         finally { if (fileChannel != null) if (throwable != null) { try { fileChannel.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }   } 
/* 136 */       } catch (Exception exception) {
/* 137 */         if (bool1) {
/* 138 */           exception.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     String str2 = System.getProperty("java.library.path");
/*     */ 
/*     */     
/* 146 */     if (bool && str2 != null && 
/* 147 */       loadSystem(paramConsumer1, paramClass, paramString1, getBundledPath(paramString1, str1), false, "java.library.path", str2)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 154 */       paramConsumer2.accept(paramString2);
/*     */ 
/*     */       
/*     */       Path path;
/*     */       
/* 159 */       if ((path = (Path)((str2 == null) ? null : findFile(str2, paramString1, str1, bool))) != null) {
/* 160 */         APIUtil.apiLogMore(String.format("Loaded from %s: %s", new Object[] { "java.library.path", path }));
/* 161 */         if (bool) {
/* 162 */           checkHash(paramClass, path, paramString1, str1); return;
/*     */         } 
/*     */       } else {
/* 165 */         APIUtil.apiLogMore("Loaded from a ClassLoader provided path.");
/*     */       } 
/*     */       return;
/* 168 */     } catch (Throwable throwable) {
/* 169 */       APIUtil.apiLogMore(str1 + " not found in java.library.path");
/*     */ 
/*     */       
/* 172 */       detectPlatformMismatch(paramClass, paramString1);
/* 173 */       printError(true);
/* 174 */       throw new UnsatisfiedLinkError("Failed to locate library: " + str1);
/*     */     } 
/*     */   }
/*     */   private static boolean loadSystemFromLibraryPath(Consumer<String> paramConsumer, Class<?> paramClass, String paramString1, String paramString2, boolean paramBoolean) {
/*     */     String str;
/* 179 */     if ((str = Configuration.LIBRARY_PATH.get()) != null && loadSystem(paramConsumer, paramClass, paramString1, paramString2, paramBoolean, Configuration.LIBRARY_PATH.getProperty(), str)) return true;  return false;
/*     */   }
/*     */   
/*     */   private static boolean loadSystem(Consumer<String> paramConsumer, Class<?> paramClass, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4) {
/*     */     Path path;
/* 184 */     if ((path = findFile(paramString4, paramString1, paramString2, paramBoolean)) == null) {
/* 185 */       APIUtil.apiLogMore(paramString2 + " not found in " + paramString3 + "=" + paramString4);
/* 186 */       return false;
/*     */     } 
/*     */     
/* 189 */     paramConsumer.accept(path.toAbsolutePath().toString());
/* 190 */     APIUtil.apiLogMore("Loaded from " + paramString3 + ": " + path);
/* 191 */     if (paramBoolean) {
/* 192 */       checkHash(paramClass, path, paramString1, paramString2);
/*     */     }
/* 194 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static SharedLibrary loadNative(String paramString1, String paramString2) {
/* 199 */     return loadNative(Library.class, paramString1, paramString2);
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
/*     */   public static SharedLibrary loadNative(Class<?> paramClass, String paramString1, String paramString2) {
/* 217 */     return loadNative(paramClass, paramString1, paramString2, false);
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
/*     */   public static SharedLibrary loadNative(Class<?> paramClass, String paramString1, String paramString2, boolean paramBoolean) {
/* 236 */     return loadNative(paramClass, paramString1, paramString2, paramBoolean, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static SharedLibrary loadNative(Class<?> paramClass, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
/* 241 */     if (Checks.DEBUG) {
/* 242 */       APIUtil.DEBUG_STREAM.print("[LWJGL] Loading library: " + paramString2 + "\n\tModule: " + paramString1 + "\n");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 250 */     if (Paths.get(paramString2, new String[0]).isAbsolute()) {
/* 251 */       SharedLibrary sharedLibrary1 = APIUtil.apiCreateLibrary(paramString2);
/* 252 */       APIUtil.apiLogMore("Success");
/* 253 */       return sharedLibrary1;
/*     */     } 
/*     */     
/* 256 */     String str1 = Platform.get().mapLibraryName(paramString2);
/*     */ 
/*     */     
/*     */     URL uRL;
/*     */     
/* 261 */     if ((uRL = findResource(paramClass, paramString1, str1, paramBoolean1)) == null) {
/*     */       
/* 263 */       if ((sharedLibrary = loadNativeFromLibraryPath(paramClass, paramString1, str1, paramBoolean1)) != null) {
/* 264 */         return sharedLibrary;
/*     */       }
/*     */     } else {
/* 267 */       boolean bool = ((Boolean)Configuration.DEBUG_LOADER.get(Boolean.FALSE)).booleanValue(); try {
/*     */         SharedLibrary sharedLibrary1; String str;
/* 269 */         if (!((Boolean)Configuration.SHARED_LIBRARY_EXTRACT_FORCE.get(Boolean.FALSE)).booleanValue() && (
/*     */           
/* 271 */           str = getRegularFilePath((URL)sharedLibrary)) != null) {
/* 272 */           sharedLibrary = APIUtil.apiCreateLibrary(str);
/* 273 */           APIUtil.apiLogMore("Loaded from classpath: " + str);
/* 274 */           return sharedLibrary;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 280 */         if (bool) {
/* 281 */           APIUtil.apiLogMore("Using SharedLibraryLoader...");
/*     */         }
/*     */         
/* 284 */         FileChannel fileChannel = SharedLibraryLoader.load(paramString2, str1, (URL)sharedLibrary, null); Throwable throwable2 = null;
/*     */         
/* 286 */         try { if ((sharedLibrary = loadNativeFromLibraryPath(paramClass, paramString1, str1, paramBoolean1)) != null)
/* 287 */           { sharedLibrary = sharedLibrary; return sharedLibrary; }  }
/*     */         catch (Throwable throwable) { sharedLibrary1 = sharedLibrary = null; throw sharedLibrary; }
/* 289 */         finally { if (throwable1 != null) if (sharedLibrary1 != null) { try { throwable1.close(); } catch (Throwable throwable) { sharedLibrary1.addSuppressed(throwable); }  } else { throwable.close(); }   } 
/* 290 */       } catch (Exception exception) {
/* 291 */         if (bool) {
/* 292 */           exception.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*     */     SharedLibrary sharedLibrary;
/* 298 */     if (!paramBoolean1 && (
/*     */       
/* 300 */       sharedLibrary = loadNativeFromSystem(str1)) != null) {
/* 301 */       return sharedLibrary;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 307 */     if (((Boolean)Configuration.EMULATE_SYSTEM_LOADLIBRARY.get(Boolean.FALSE)).booleanValue()) {
/*     */       try {
/*     */         Method method;
/*     */         
/* 311 */         (method = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class })).setAccessible(true);
/*     */         
/*     */         String str;
/* 314 */         if ((str = (String)method.invoke(paramClass.getClassLoader(), new Object[] { paramString2 })) != null) {
/* 315 */           sharedLibrary = APIUtil.apiCreateLibrary(str);
/* 316 */           APIUtil.apiLogMore("Loaded from ClassLoader provided path: " + str);
/* 317 */           return sharedLibrary;
/*     */         } 
/* 319 */       } catch (Exception exception) {}
/*     */     }
/*     */ 
/*     */     
/*     */     String str2;
/*     */ 
/*     */     
/* 326 */     if ((str2 = System.getProperty("java.library.path")) != null && (
/*     */       
/* 328 */       sharedLibrary = loadNative(paramClass, paramString1, str1, paramBoolean1, "java.library.path", str2)) != null) {
/* 329 */       return sharedLibrary;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 335 */     if (paramBoolean1 && (
/*     */       
/* 337 */       sharedLibrary = loadNativeFromSystem(str1)) != null) {
/* 338 */       return sharedLibrary;
/*     */     }
/*     */ 
/*     */     
/* 342 */     if (paramBoolean2) {
/* 343 */       detectPlatformMismatch(paramClass, paramString1);
/* 344 */       printError(paramBoolean1);
/*     */     } 
/* 346 */     throw new UnsatisfiedLinkError("Failed to locate library: " + str1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static SharedLibrary loadNativeFromSystem(String paramString) {
/*     */     SharedLibrary sharedLibrary;
/*     */     try {
/*     */       String str;
/* 355 */       APIUtil.apiLogMore(((str = (sharedLibrary = APIUtil.apiCreateLibrary(paramString)).getPath()) == null) ? "Loaded from system paths" : ("Loaded from system paths: " + str));
/*     */     
/*     */     }
/* 358 */     catch (UnsatisfiedLinkError unsatisfiedLinkError) {
/* 359 */       sharedLibrary = null;
/* 360 */       APIUtil.apiLogMore(paramString + " not found in system paths");
/*     */     } 
/* 362 */     return sharedLibrary;
/*     */   }
/*     */ 
/*     */   
/*     */   private static SharedLibrary loadNativeFromLibraryPath(Class<?> paramClass, String paramString1, String paramString2, boolean paramBoolean) {
/*     */     String str;
/* 368 */     if ((str = Configuration.LIBRARY_PATH.get()) == null) {
/* 369 */       return null;
/*     */     }
/* 371 */     return loadNative(paramClass, paramString1, paramString2, paramBoolean, Configuration.LIBRARY_PATH.getProperty(), str);
/*     */   }
/*     */ 
/*     */   
/*     */   private static SharedLibrary loadNative(Class<?> paramClass, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4) {
/*     */     Path path;
/* 377 */     if ((path = findFile(paramString4, paramString1, paramString2, paramBoolean)) == null) {
/* 378 */       APIUtil.apiLogMore(paramString2 + " not found in " + paramString3 + "=" + paramString4);
/* 379 */       return null;
/*     */     } 
/*     */     
/* 382 */     SharedLibrary sharedLibrary = APIUtil.apiCreateLibrary(path.toAbsolutePath().toString());
/* 383 */     APIUtil.apiLogMore("Loaded from " + paramString3 + ": " + path);
/* 384 */     if (paramBoolean) {
/* 385 */       checkHash(paramClass, path, paramString1, paramString2);
/*     */     }
/* 387 */     return sharedLibrary;
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
/*     */   public static SharedLibrary loadNative(Class<?> paramClass, String paramString, Configuration<String> paramConfiguration, String... paramVarArgs) {
/* 402 */     return loadNative(paramClass, paramString, paramConfiguration, (Supplier<SharedLibrary>)null, paramVarArgs);
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
/*     */   public static SharedLibrary loadNative(Class<?> paramClass, String paramString, Configuration<String> paramConfiguration, Supplier<SharedLibrary> paramSupplier, String... paramVarArgs) {
/* 419 */     if (paramVarArgs.length == 0) {
/* 420 */       throw new IllegalArgumentException("No default names specified.");
/*     */     }
/*     */     String str;
/* 423 */     if (paramConfiguration != null && (
/*     */       
/* 425 */       str = paramConfiguration.get()) != null) {
/* 426 */       return loadNative(paramClass, paramString, str);
/*     */     }
/*     */ 
/*     */     
/* 430 */     if (paramSupplier == null && paramVarArgs.length <= 1) {
/* 431 */       return loadNative(paramClass, paramString, paramVarArgs[0]);
/*     */     }
/*     */     
/*     */     try {
/* 435 */       return loadNative(paramClass, paramString, paramVarArgs[0], false, false);
/* 436 */     } catch (Throwable throwable) {
/* 437 */       for (byte b = 1; b < paramVarArgs.length; b++) {
/*     */         try {
/* 439 */           return loadNative(paramClass, paramString, paramVarArgs[b], false, (paramSupplier == null && b == paramVarArgs.length - 1));
/* 440 */         } catch (Throwable throwable1) {}
/*     */       } 
/*     */       
/* 443 */       if (paramSupplier != null) {
/* 444 */         return paramSupplier.get();
/*     */       }
/* 446 */       throw throwable;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String getBundledPath(String paramString1, String paramString2) {
/* 451 */     return Platform.mapLibraryPathBundled(paramString1.replace('.', '/') + "/" + paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   static URL findResource(Class<?> paramClass, String paramString1, String paramString2, boolean paramBoolean) {
/* 456 */     URL uRL = null;
/* 457 */     if (paramBoolean && 
/*     */       
/* 459 */       !(paramString1 = getBundledPath(paramString1, paramString2)).equals(paramString2)) {
/* 460 */       uRL = paramClass.getClassLoader().getResource(paramString1);
/*     */     }
/*     */     
/* 463 */     return (uRL == null) ? paramClass.getClassLoader().getResource(paramString2) : uRL;
/*     */   }
/*     */ 
/*     */   
/*     */   static String getRegularFilePath(URL paramURL) {
/* 468 */     if (paramURL.getProtocol().equals("file")) {
/*     */       try {
/*     */         Path path;
/* 471 */         if ((path = Paths.get(paramURL.toURI())).isAbsolute() && Files.isReadable(path)) {
/* 472 */           return path.toString();
/*     */         }
/* 474 */       } catch (URISyntaxException uRISyntaxException) {}
/*     */     }
/*     */     
/* 477 */     return null;
/*     */   }
/*     */   
/*     */   static Path findFile(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/*     */     Path path;
/* 482 */     if (paramBoolean && 
/*     */       
/* 484 */       !(paramString2 = getBundledPath(paramString2, paramString3)).equals(paramString3) && (
/*     */       
/* 486 */       path = findFile(paramString1, paramString2)) != null) {
/* 487 */       return path;
/*     */     }
/*     */ 
/*     */     
/* 491 */     return findFile(paramString1, paramString3);
/*     */   } private static Path findFile(String paramString1, String paramString2) {
/*     */     String[] arrayOfString;
/*     */     int i;
/*     */     byte b;
/* 496 */     for (i = (arrayOfString = PATH_SEPARATOR.split(paramString1)).length, b = 0; b < i; b++) {
/*     */       Path path; String str;
/* 498 */       if (Files.isReadable(path = Paths.get(str = arrayOfString[b], new String[] { paramString2 }))) {
/* 499 */         return path;
/*     */       }
/*     */     } 
/* 502 */     return null;
/*     */   }
/*     */   
/*     */   private static void detectPlatformMismatch(Class<?> paramClass, String paramString) {
/* 506 */     if (!paramString.startsWith("org.lwjgl")) {
/*     */       return;
/*     */     }
/*     */     
/* 510 */     String str = paramString.equals("org.lwjgl") ? "lwjgl" : ("lwjgl-" + paramString.substring(10));
/*     */     
/* 512 */     ArrayList<String> arrayList = new ArrayList(8);
/*     */     try {
/* 514 */       Enumeration<URL> enumeration = paramClass.getClassLoader().getResources("META-INF/MANIFEST.MF");
/* 515 */       while (enumeration.hasMoreElements()) {
/* 516 */         try (InputStream null = ((URL)enumeration.nextElement()).openStream()) {
/*     */           Manifest manifest;
/* 518 */           Attributes attributes = (manifest = new Manifest(inputStream)).getMainAttributes();
/*     */           String str1;
/* 520 */           if (str.equals(attributes.getValue("Implementation-Title")) && (
/*     */             
/* 522 */             str1 = attributes.getValue("LWJGL-Platform")) != null) {
/* 523 */             arrayList.add(str1);
/*     */           }
/*     */         }
/*     */       
/*     */       } 
/* 528 */     } catch (IOException iOException) {}
/*     */ 
/*     */     
/* 531 */     if (!arrayList.isEmpty()) {
/* 532 */       APIUtil.DEBUG_STREAM.print("[LWJGL] Platform/architecture mismatch detected for module: " + paramString + "\n\tJVM platform:\t\t" + 
/*     */ 
/*     */           
/* 535 */           Platform.get().getName() + " " + System.getProperty("os.arch") + " " + System.getProperty("java.version") + "\n\t\t" + 
/* 536 */           System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor") + "\n\tPlatform" + (
/* 537 */           (arrayList.size() == 1) ? "" : "s") + " available on classpath:\n\t\t" + String.join("\n\t\t", (Iterable)arrayList) + "\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void printError(boolean paramBoolean) {
/* 543 */     printError("[LWJGL] Failed to load a library. Possible solutions:\n" + (paramBoolean ? "\ta) Add the directory that contains the shared library to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the shared library to the classpath." : "\ta) Install the library or the driver that provides the library.\n\tb) Ensure that the library is accessible from the system library paths."));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void printError(String paramString) {
/*     */     StringBuilder stringBuilder;
/* 555 */     (stringBuilder = new StringBuilder(paramString)).append("\n");
/*     */     
/* 557 */     if (!Checks.DEBUG) {
/* 558 */       stringBuilder.append("[LWJGL] Enable debug mode with -Dorg.lwjgl.util.Debug=true for better diagnostics.\n");
/* 559 */       if (!((Boolean)Configuration.DEBUG_LOADER.get(Boolean.FALSE)).booleanValue()) {
/* 560 */         stringBuilder.append("[LWJGL] Enable the SharedLibraryLoader debug mode with -Dorg.lwjgl.util.DebugLoader=true for better diagnostics.\n");
/*     */       }
/*     */     } 
/*     */     
/* 564 */     APIUtil.DEBUG_STREAM.print(stringBuilder);
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
/*     */   private static void checkHash(Class<?> paramClass, Path paramPath, String paramString1, String paramString2) {
/* 576 */     if (!Checks.CHECKS) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 581 */       URL uRL1 = null;
/* 582 */       URL uRL2 = null;
/*     */       
/* 584 */       Enumeration<URL> enumeration = paramClass.getClassLoader().getResources("META-INF/" + getBundledPath(paramString1, paramString2) + ".sha1");
/* 585 */       while (enumeration.hasMoreElements()) {
/* 586 */         URL uRL = enumeration.nextElement();
/* 587 */         if (NATIVES_JAR.matcher(uRL.toExternalForm()).find()) {
/* 588 */           uRL2 = uRL; continue;
/*     */         } 
/* 590 */         uRL1 = uRL;
/*     */       } 
/*     */       
/* 593 */       if (uRL1 == null) {
/*     */         return;
/*     */       }
/*     */       
/* 597 */       byte[] arrayOfByte2 = getSHA1(uRL1);
/*     */ 
/*     */       
/* 600 */       byte[] arrayOfByte1 = (Checks.DEBUG || uRL2 == null) ? getSHA1(paramPath) : getSHA1(uRL2);
/*     */       
/* 602 */       if (!Arrays.equals(arrayOfByte2, arrayOfByte1)) {
/* 603 */         APIUtil.DEBUG_STREAM.println("[LWJGL] [ERROR] Incompatible Java and native library versions detected.\nPossible reasons:\n\ta) -Djava.library.path is set to a folder containing shared libraries of an older LWJGL version.\n\tb) The classpath contains jar files of an older LWJGL version.\nPossible solutions:\n\ta) Make sure to not set -Djava.library.path (it is not needed for developing with LWJGL 3) or make\n\t   sure the folder it points to contains the shared libraries of the correct LWJGL version.\n\tb) Check the classpath and make sure to only have jar files of the same LWJGL version in it.");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/* 613 */     } catch (Throwable throwable) {
/* 614 */       if (Checks.DEBUG) {
/* 615 */         APIUtil.apiLog("Failed to verify native library.");
/* 616 */         throwable.printStackTrace();
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   private static byte[] getSHA1(URL paramURL) {
/* 622 */     null = new byte[20];
/* 623 */     InputStream inputStream = paramURL.openStream(); Throwable throwable = null; 
/* 624 */     try { for (byte b = 0; b < 20; b++)
/* 625 */         null[b] = (byte)(Character.digit(inputStream.read(), 16) << 4 | Character.digit(inputStream.read(), 16));  }
/*     */     catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 627 */     finally { if (inputStream != null) if (throwable != null) { try { inputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }   }
/* 628 */      return (byte[])SYNTHETIC_LOCAL_VARIABLE_1;
/*     */   }
/*     */   
/*     */   private static byte[] getSHA1(Path paramPath) {
/* 632 */     null = MessageDigest.getInstance("SHA-1");
/* 633 */     InputStream inputStream = Files.newInputStream(paramPath, new java.nio.file.OpenOption[0]); Throwable throwable = null; 
/* 634 */     try { byte[] arrayOfByte = new byte[8192]; int i;
/* 635 */       while ((i = inputStream.read(arrayOfByte)) != -1)
/* 636 */         null.update(arrayOfByte, 0, i);  }
/*     */     catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 638 */     finally { if (inputStream != null) if (throwable != null) { try { inputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }   }
/* 639 */      return SYNTHETIC_LOCAL_VARIABLE_1.digest();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\Library.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */