/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.HashSet;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import java.util.zip.CRC32;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SharedLibraryLoader
/*     */ {
/*     */   public static Os os;
/*  41 */   public static Architecture.Bitness bitness = Architecture.Bitness._32;
/*  42 */   public static Architecture architecture = Architecture.x86;
/*     */   
/*     */   static {
/*  45 */     if (System.getProperty("os.name").contains("Windows")) {
/*  46 */       os = Os.Windows;
/*  47 */     } else if (System.getProperty("os.name").contains("Linux")) {
/*  48 */       os = Os.Linux;
/*  49 */     } else if (System.getProperty("os.name").contains("Mac")) {
/*  50 */       os = Os.MacOsX;
/*     */     } 
/*  52 */     if (System.getProperty("os.arch").startsWith("arm") || System.getProperty("os.arch").startsWith("aarch64")) {
/*  53 */       architecture = Architecture.ARM;
/*  54 */     } else if (System.getProperty("os.arch").startsWith("riscv")) {
/*  55 */       architecture = Architecture.RISCV;
/*  56 */     } else if (System.getProperty("os.arch").startsWith("loongarch")) {
/*  57 */       architecture = Architecture.LOONGARCH;
/*     */     } 
/*  59 */     if (System.getProperty("os.arch").contains("64") || System.getProperty("os.arch").startsWith("armv8")) {
/*  60 */       bitness = Architecture.Bitness._64;
/*  61 */     } else if (System.getProperty("os.arch").contains("128")) {
/*  62 */       bitness = Architecture.Bitness._128;
/*     */     } 
/*  64 */     boolean bool = (System.getProperty("moe.platform.name") != null) ? true : false;
/*     */     String str;
/*  66 */     if ((str = System.getProperty("java.runtime.name")) != null && str.contains("Android Runtime")) {
/*  67 */       os = Os.Android;
/*  68 */       bitness = Architecture.Bitness._32;
/*  69 */       architecture = Architecture.x86;
/*     */     } 
/*  71 */     if (bool || (os != Os.Android && os != Os.Windows && os != Os.Linux && os != Os.MacOsX)) {
/*  72 */       os = Os.IOS;
/*  73 */       bitness = Architecture.Bitness._32;
/*  74 */       architecture = Architecture.x86;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*  82 */   public static boolean isWindows = (os == Os.Windows);
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*  87 */   public static boolean isLinux = (os == Os.Linux);
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*  92 */   public static boolean isMac = (os == Os.MacOsX);
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*  97 */   public static boolean isIos = (os == Os.IOS);
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/* 102 */   public static boolean isAndroid = (os == Os.Android);
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/* 107 */   public static boolean isARM = (architecture == Architecture.ARM);
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/* 112 */   public static boolean is64Bit = (bitness == Architecture.Bitness._64);
/*     */   
/* 114 */   private static final HashSet<String> loadedLibraries = new HashSet<>();
/* 115 */   private static final Random random = new Random();
/*     */   
/*     */   private String nativesJar;
/*     */ 
/*     */   
/*     */   public SharedLibraryLoader() {}
/*     */   
/*     */   static String randomUUID() {
/* 123 */     return (new UUID(random.nextLong(), random.nextLong())).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SharedLibraryLoader(String paramString) {
/* 129 */     this.nativesJar = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String crc(InputStream paramInputStream) {
/* 134 */     if (paramInputStream == null) throw new IllegalArgumentException("input cannot be null."); 
/* 135 */     null = new CRC32();
/* 136 */     byte[] arrayOfByte = new byte[4096];
/*     */ 
/*     */     
/*     */     try { int i;
/* 140 */       while ((i = paramInputStream.read(arrayOfByte)) != -1) {
/* 141 */         null.update(arrayOfByte, 0, i);
/*     */       } }
/* 143 */     catch (Exception exception) {  }
/*     */     finally
/* 145 */     { closeQuietly(paramInputStream); }
/*     */     
/* 147 */     return Long.toString(SYNTHETIC_LOCAL_VARIABLE_2.getValue(), 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public String mapLibraryName(String paramString) {
/* 152 */     if (os == Os.Android)
/* 153 */       return paramString; 
/* 154 */     return os.getLibPrefix() + paramString + architecture.toSuffix() + bitness.toSuffix() + "." + os.getLibExtension();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(String paramString) {
/* 161 */     if (os == Os.IOS)
/*     */       return; 
/* 163 */     synchronized (SharedLibraryLoader.class) {
/* 164 */       if (isLoaded(paramString))
/* 165 */         return;  String str = mapLibraryName(paramString);
/*     */       try {
/* 167 */         if (os == Os.Android) {
/* 168 */           System.loadLibrary(str);
/*     */         } else {
/* 170 */           loadFile(str);
/* 171 */         }  setLoaded(paramString);
/* 172 */       } catch (Throwable throwable) {
/* 173 */         throw new SharedLibraryLoadRuntimeException("Couldn't load shared library '" + str + "' for target: " + ((os == Os.Android) ? "Android" : (
/* 174 */             System.getProperty("os.name") + ", " + architecture.name() + ", " + bitness.name().substring(1) + "-bit")), throwable);
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   private InputStream readFile(String paramString) {
/* 181 */     if (this.nativesJar == null) {
/*     */       InputStream inputStream;
/* 183 */       if ((inputStream = SharedLibraryLoader.class.getResourceAsStream("/" + paramString)) == null) throw new SharedLibraryLoadRuntimeException("Unable to read file for extraction: " + paramString); 
/* 184 */       return inputStream;
/*     */     } 
/*     */     
/*     */     try {
/*     */       ZipFile zipFile;
/*     */       
/*     */       ZipEntry zipEntry;
/* 191 */       if ((zipEntry = (zipFile = new ZipFile(this.nativesJar)).getEntry(paramString)) == null) throw new SharedLibraryLoadRuntimeException("Couldn't find '" + paramString + "' in JAR: " + this.nativesJar); 
/* 192 */       return zipFile.getInputStream(zipEntry);
/* 193 */     } catch (IOException iOException) {
/* 194 */       throw new SharedLibraryLoadRuntimeException("Error reading '" + paramString + "' in JAR: " + this.nativesJar, iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File extractFile(String paramString1, String paramString2) {
/*     */     try {
/* 205 */       String str = crc(readFile(paramString1));
/* 206 */       if (paramString2 == null) paramString2 = str;
/*     */       
/*     */       File file;
/* 209 */       if ((file = getExtractedFile(paramString2, (new File(paramString1)).getName())) == null && (
/*     */         
/* 211 */         file = getExtractedFile(randomUUID(), (new File(paramString1)).getName())) == null) throw new SharedLibraryLoadRuntimeException("Unable to find writable path to extract file. Is the user home directory writable?");
/*     */ 
/*     */       
/* 214 */       return extractFile(paramString1, str, file);
/* 215 */     } catch (RuntimeException runtimeException) {
/*     */       File file;
/*     */       
/* 218 */       if ((file = new File(System.getProperty("java.library.path"), paramString1)).exists()) return file; 
/* 219 */       throw runtimeException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void extractFileTo(String paramString, File paramFile) {
/* 228 */     extractFile(paramString, crc(readFile(paramString)), new File(paramFile, (new File(paramString)).getName()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private File getExtractedFile(String paramString1, String paramString2) {
/* 236 */     File file1 = new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + paramString1, paramString2);
/* 237 */     if (canWrite(file1)) return file1;
/*     */ 
/*     */     
/*     */     try {
/*     */       File file;
/* 242 */       if ((file = File.createTempFile(paramString1, null)).delete()) {
/* 243 */         file = new File(file, paramString2);
/* 244 */         if (canWrite(file)) return file; 
/*     */       } 
/* 246 */     } catch (IOException iOException) {}
/*     */ 
/*     */ 
/*     */     
/* 250 */     File file2 = new File(System.getProperty("user.home") + "/.libgdx/" + paramString1, paramString2);
/* 251 */     if (canWrite(file2)) return file2;
/*     */ 
/*     */     
/* 254 */     file2 = new File(".temp/" + paramString1, paramString2);
/* 255 */     if (canWrite(file2)) return file2;
/*     */ 
/*     */     
/* 258 */     if (System.getenv("APP_SANDBOX_CONTAINER_ID") != null) return file1;
/*     */     
/* 260 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canWrite(File paramFile) {
/* 265 */     null = paramFile.getParentFile();
/*     */     
/* 267 */     if (paramFile.exists()) {
/* 268 */       if (!paramFile.canWrite() || !canExecute(paramFile)) return false;
/*     */       
/* 270 */       paramFile = new File(null, randomUUID().toString());
/*     */     } else {
/* 272 */       null.mkdirs();
/* 273 */       if (!null.isDirectory()) return false; 
/* 274 */       paramFile = paramFile;
/*     */     } 
/*     */     try {
/* 277 */       (new FileOutputStream(paramFile)).close();
/* 278 */       if (!canExecute(paramFile)) return false; 
/* 279 */       return true;
/* 280 */     } catch (Throwable throwable) {
/* 281 */       return false;
/*     */     } finally {
/* 283 */       paramFile.delete();
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean canExecute(File paramFile) {
/*     */     try {
/*     */       Method method1;
/* 290 */       if (((Boolean)(method1 = File.class.getMethod("canExecute", new Class[0])).invoke(paramFile, new Object[0])).booleanValue()) return true;
/*     */       
/*     */       Method method2;
/* 293 */       (method2 = File.class.getMethod("setExecutable", new Class[] { boolean.class, boolean.class })).invoke(paramFile, new Object[] { Boolean.TRUE, Boolean.FALSE });
/*     */       
/* 295 */       return ((Boolean)method1.invoke(paramFile, new Object[0])).booleanValue();
/* 296 */     } catch (Exception exception) {
/*     */       
/* 298 */       return false;
/*     */     } 
/*     */   }
/*     */   private File extractFile(String paramString1, String paramString2, File paramFile) {
/* 302 */     String str = null;
/* 303 */     if (paramFile.exists()) {
/*     */       try {
/* 305 */         str = crc(new FileInputStream(paramFile));
/* 306 */       } catch (FileNotFoundException fileNotFoundException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 311 */     if (str == null || !str.equals(paramString2)) {
/* 312 */       InputStream inputStream; FileOutputStream fileOutputStream; paramString2 = null;
/* 313 */       str = null;
/*     */       try {
/* 315 */         inputStream = readFile(paramString1);
/* 316 */         paramFile.getParentFile().mkdirs();
/* 317 */         fileOutputStream = new FileOutputStream(paramFile);
/* 318 */         byte[] arrayOfByte = new byte[4096];
/*     */         
/*     */         int i;
/* 321 */         while ((i = inputStream.read(arrayOfByte)) != -1) {
/* 322 */           fileOutputStream.write(arrayOfByte, 0, i);
/*     */         }
/* 324 */       } catch (IOException iOException) {
/* 325 */         throw new SharedLibraryLoadRuntimeException("Error extracting file: " + paramString1 + "\nTo: " + paramFile.getAbsolutePath(), iOException);
/*     */       } finally {
/*     */         
/* 328 */         closeQuietly(inputStream);
/* 329 */         closeQuietly(fileOutputStream);
/*     */       } 
/*     */     } 
/*     */     
/* 333 */     return paramFile;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void loadFile(String paramString) {
/* 339 */     String str1 = crc(readFile(paramString));
/*     */     
/* 341 */     String str2 = (new File(paramString)).getName();
/*     */ 
/*     */     
/* 344 */     File file = new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + str1, str2);
/*     */     
/*     */     Throwable throwable;
/* 347 */     if ((throwable = loadFile(paramString, str1, file)) == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 352 */     try { if ((file = File.createTempFile(str1, null)).delete() && loadFile(paramString, str1, file) == null)
/* 353 */         return;  } catch (Throwable throwable1) {}
/*     */ 
/*     */ 
/*     */     
/* 357 */     file = new File(System.getProperty("user.home") + "/.libgdx/" + str1, str2);
/* 358 */     if (loadFile(paramString, str1, file) == null) {
/*     */       return;
/*     */     }
/* 361 */     file = new File(".temp/" + str1, str2);
/* 362 */     if (loadFile(paramString, str1, file) == null) {
/*     */       return;
/*     */     }
/*     */     
/* 366 */     if ((file = new File(System.getProperty("java.library.path"), paramString)).exists()) {
/* 367 */       System.load(file.getAbsolutePath());
/*     */       
/*     */       return;
/*     */     } 
/* 371 */     throw new SharedLibraryLoadRuntimeException(throwable);
/*     */   }
/*     */ 
/*     */   
/*     */   private Throwable loadFile(String paramString1, String paramString2, File paramFile) {
/*     */     try {
/* 377 */       System.load(extractFile(paramString1, paramString2, paramFile).getAbsolutePath());
/* 378 */       return null;
/* 379 */     } catch (Throwable throwable) {
/* 380 */       return (Throwable)(paramString1 = null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static synchronized void setLoaded(String paramString) {
/* 386 */     loadedLibraries.add(paramString);
/*     */   }
/*     */   
/*     */   public static synchronized boolean isLoaded(String paramString) {
/* 390 */     return loadedLibraries.contains(paramString);
/*     */   }
/*     */   
/*     */   public static void closeQuietly(Closeable paramCloseable) {
/* 394 */     if (paramCloseable != null)
/*     */       try {
/* 396 */         paramCloseable.close(); return;
/* 397 */       } catch (Throwable throwable) {} 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\SharedLibraryLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */