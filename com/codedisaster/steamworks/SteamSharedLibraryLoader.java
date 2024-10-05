/*     */ package com.codedisaster.steamworks;
/*     */ import java.io.File;
/*     */ 
/*     */ class SteamSharedLibraryLoader {
/*     */   private static final PLATFORM OS;
/*     */   private static final boolean IS_64_BIT;
/*     */   
/*     */   enum PLATFORM {
/*   9 */     Windows,
/*  10 */     Linux,
/*  11 */     MacOS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  17 */   private static final String SHARED_LIBRARY_EXTRACT_DIRECTORY = System.getProperty("com.codedisaster.steamworks.SharedLibraryExtractDirectory", "steamworks4j");
/*     */ 
/*     */   
/*  20 */   private static final String SHARED_LIBRARY_EXTRACT_PATH = System.getProperty("com.codedisaster.steamworks.SharedLibraryExtractPath", null);
/*     */ 
/*     */   
/*  23 */   private static final String SDK_REDISTRIBUTABLE_BIN_PATH = System.getProperty("com.codedisaster.steamworks.SDKRedistributableBinPath", "sdk/redistributable_bin");
/*     */ 
/*     */   
/*  26 */   private static final String SDK_LIBRARY_PATH = System.getProperty("com.codedisaster.steamworks.SDKLibraryPath", "sdk/public/steam/lib");
/*     */ 
/*     */   
/*  29 */   static final boolean DEBUG = Boolean.parseBoolean(System.getProperty("com.codedisaster.steamworks.Debug", "false"));
/*     */ 
/*     */   
/*     */   static {
/*  33 */     String str1 = System.getProperty("os.name");
/*  34 */     String str2 = System.getProperty("os.arch");
/*     */     
/*  36 */     if (str1.contains("Windows")) {
/*  37 */       OS = PLATFORM.Windows;
/*  38 */     } else if (str1.contains("Linux")) {
/*  39 */       OS = PLATFORM.Linux;
/*  40 */     } else if (str1.contains("Mac")) {
/*  41 */       OS = PLATFORM.MacOS;
/*     */     } else {
/*  43 */       throw new RuntimeException("Unknown host architecture: " + str1 + ", " + str2);
/*     */     } 
/*     */     
/*  46 */     IS_64_BIT = (str2.equals("amd64") || str2.equals("x86_64"));
/*     */   }
/*     */   
/*     */   private static String getPlatformLibName(String paramString) {
/*  50 */     switch (OS) {
/*     */       case Windows:
/*  52 */         return paramString + (IS_64_BIT ? "64" : "") + ".dll";
/*     */       case Linux:
/*  54 */         return "lib" + paramString + ".so";
/*     */       case MacOS:
/*  56 */         return "lib" + paramString + ".dylib";
/*     */     } 
/*     */     
/*  59 */     throw new RuntimeException("Unknown host architecture");
/*     */   }
/*     */   
/*     */   static String getSdkRedistributableBinPath() {
/*     */     File file;
/*  64 */     switch (OS) {
/*     */       case Windows:
/*  66 */         file = new File(SDK_REDISTRIBUTABLE_BIN_PATH, IS_64_BIT ? "win64" : "");
/*     */         break;
/*     */       case Linux:
/*  69 */         file = new File(SDK_REDISTRIBUTABLE_BIN_PATH, "linux64");
/*     */         break;
/*     */       case MacOS:
/*  72 */         file = new File(SDK_REDISTRIBUTABLE_BIN_PATH, "osx");
/*     */         break;
/*     */       default:
/*  75 */         return null;
/*     */     } 
/*     */     
/*  78 */     return file.exists() ? file.getPath() : null;
/*     */   }
/*     */   
/*     */   static String getSdkLibraryPath() {
/*     */     File file;
/*  83 */     switch (OS) {
/*     */       case Windows:
/*  85 */         file = new File(SDK_LIBRARY_PATH, IS_64_BIT ? "win64" : "win32");
/*     */         break;
/*     */       case Linux:
/*  88 */         file = new File(SDK_LIBRARY_PATH, "linux64");
/*     */         break;
/*     */       case MacOS:
/*  91 */         file = new File(SDK_LIBRARY_PATH, "osx");
/*     */         break;
/*     */       default:
/*  94 */         return null;
/*     */     } 
/*     */     
/*  97 */     return file.exists() ? file.getPath() : null;
/*     */   }
/*     */   
/*     */   static void loadLibrary(String paramString1, String paramString2) {
/*     */     try {
/* 102 */       paramString1 = getPlatformLibName(paramString1);
/*     */       
/* 104 */       File file = discoverExtractLocation(SHARED_LIBRARY_EXTRACT_DIRECTORY + "/" + 
/* 105 */           Version.getVersion(), paramString1);
/*     */       
/* 107 */       if (paramString2 == null) {
/*     */         
/* 109 */         extractLibrary(file, paramString1);
/*     */       } else {
/*     */         
/* 112 */         File file1 = new File(paramString2, paramString1);
/*     */         
/* 114 */         if (OS != PLATFORM.Windows) {
/*     */           
/* 116 */           extractLibrary(file, file1);
/*     */         } else {
/*     */           
/* 119 */           file = file1;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 124 */       System.load(paramString1 = file.getCanonicalPath()); return;
/* 125 */     } catch (IOException iOException) {
/* 126 */       throw new SteamException(iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void extractLibrary(File paramFile, String paramString) {
/* 131 */     extractLibrary(paramFile, SteamSharedLibraryLoader.class
/* 132 */         .getResourceAsStream("/" + paramString));
/*     */   }
/*     */   
/*     */   private static void extractLibrary(File paramFile1, File paramFile2) {
/* 136 */     extractLibrary(paramFile1, new FileInputStream(paramFile2));
/*     */   }
/*     */   
/*     */   private static void extractLibrary(File paramFile, InputStream paramInputStream) {
/* 140 */     if (paramInputStream != null) { 
/* 141 */       try { FileOutputStream fileOutputStream = new FileOutputStream(paramFile); Throwable throwable = null; 
/* 142 */         try { byte[] arrayOfByte = new byte[4096];
/*     */           
/*     */           int i;
/* 145 */           while ((i = paramInputStream.read(arrayOfByte)) != -1) {
/* 146 */             fileOutputStream.write(arrayOfByte, 0, i);
/*     */           }
/* 148 */           fileOutputStream.close(); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 149 */         finally { if (throwable != null) { try { fileOutputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }  }  } catch (IOException iOException)
/*     */       
/*     */       { 
/*     */ 
/*     */         
/* 154 */         if (!paramFile.exists()) {
/* 155 */           throw iOException;
/*     */         } }
/*     */       finally
/* 158 */       { paramInputStream.close(); }
/*     */        }
/*     */     else
/* 161 */     { throw new IOException("Failed to read input stream for " + paramFile.getCanonicalPath()); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static File discoverExtractLocation(String paramString1, String paramString2) {
/*     */     File file;
/* 171 */     if (SHARED_LIBRARY_EXTRACT_PATH != null && 
/*     */       
/* 173 */       canWrite(file = new File(SHARED_LIBRARY_EXTRACT_PATH, paramString2))) {
/* 174 */       return file;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     if (canWrite(file = new File(System.getProperty("java.io.tmpdir") + "/" + paramString1, paramString2))) {
/* 182 */       return file;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 189 */       if ((file = File.createTempFile(paramString1, null)).delete())
/*     */       {
/*     */         
/* 192 */         if (canWrite(file = new File(file, paramString2))) {
/* 193 */           return file;
/*     */         }
/*     */       }
/* 196 */     } catch (IOException iOException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 203 */     if (canWrite(file = new File(System.getProperty("user.home") + "/." + paramString1, paramString2))) {
/* 204 */       return file;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 210 */     if (canWrite(file = new File(".tmp/" + paramString1, paramString2))) {
/* 211 */       return file;
/*     */     }
/*     */     
/* 214 */     throw new IOException("No suitable extraction path found");
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean canWrite(File paramFile) {
/* 219 */     null = paramFile.getParentFile();
/*     */     
/* 221 */     if (paramFile.exists()) {
/* 222 */       if (!paramFile.canWrite() || !canExecute(paramFile)) {
/* 223 */         return false;
/*     */       }
/*     */     } else {
/* 226 */       if (!null.exists() && 
/* 227 */         !null.mkdirs()) {
/* 228 */         return false;
/*     */       }
/*     */       
/* 231 */       if (!null.isDirectory()) {
/* 232 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 236 */     paramFile = new File(null, UUID.randomUUID().toString());
/*     */     
/*     */     try {
/* 239 */       (new FileOutputStream(paramFile)).close();
/* 240 */       return canExecute(paramFile);
/* 241 */     } catch (IOException iOException) {
/* 242 */       return false;
/*     */     } finally {
/* 244 */       paramFile.delete();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean canExecute(File paramFile) {
/*     */     try {
/* 251 */       if (paramFile.canExecute()) {
/* 252 */         return true;
/*     */       }
/*     */       
/* 255 */       if (paramFile.setExecutable(true)) {
/* 256 */         return paramFile.canExecute();
/*     */       }
/* 258 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */     
/* 262 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamSharedLibraryLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */