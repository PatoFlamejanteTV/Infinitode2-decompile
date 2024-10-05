/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.file.CopyOption;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.nio.file.StandardCopyOption;
/*     */ import java.nio.file.attribute.FileAttribute;
/*     */ import java.util.HashSet;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.stream.Stream;
/*     */ import java.util.zip.CRC32;
/*     */ import org.lwjgl.Version;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SharedLibraryLoader
/*     */ {
/*  37 */   private static final Lock EXTRACT_PATH_LOCK = new ReentrantLock();
/*     */ 
/*     */   
/*     */   private static Path extractPath;
/*     */ 
/*     */   
/*  43 */   private static HashSet<Path> extractPaths = new HashSet<>(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean checkedJDK8195129;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static FileChannel load(String paramString1, String paramString2, URL paramURL, Consumer<String> paramConsumer) {
/*     */     try {
/*  64 */       EXTRACT_PATH_LOCK.lock(); try {
/*     */         Path path;
/*  66 */         if (extractPath != null) {
/*     */           
/*  68 */           path = extractPath.resolve(paramString2);
/*     */         }
/*     */         else {
/*     */           
/*  72 */           Path path1 = (path = getExtractPath((String)path, paramURL, paramConsumer)).getParent();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  82 */           if (Platform.get() != Platform.WINDOWS || checkedJDK8195129) {
/*  83 */             extractPath = path1;
/*     */           }
/*  85 */           initExtractPath(path1);
/*     */         } 
/*     */       } finally {
/*  88 */         EXTRACT_PATH_LOCK.unlock();
/*     */       } 
/*     */       
/*  91 */       return extract((Path)paramString2, paramURL);
/*  92 */     } catch (Exception exception) {
/*  93 */       throw new RuntimeException("\tFailed to extract " + paramString1 + " library", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void initExtractPath(Path paramPath) {
/*  98 */     if (extractPaths.contains(paramPath)) {
/*     */       return;
/*     */     }
/* 101 */     extractPaths.add(paramPath);
/*     */     
/* 103 */     String str1 = paramPath.toAbsolutePath().toString();
/*     */     
/*     */     String str2;
/*     */     
/* 107 */     if ((str2 = Configuration.LIBRARY_PATH.get()) != null && !str2.isEmpty()) {
/* 108 */       str1 = str1 + File.pathSeparator + str2;
/*     */     }
/*     */     
/* 111 */     System.setProperty(Configuration.LIBRARY_PATH.getProperty(), str1);
/* 112 */     Configuration.LIBRARY_PATH.set(str1);
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
/*     */   private static Path getExtractPath(String paramString, URL paramURL, Consumer<String> paramConsumer) {
/*     */     String str1;
/* 126 */     if ((str1 = Configuration.SHARED_LIBRARY_EXTRACT_PATH.get()) != null) {
/* 127 */       Path path4, path5 = (path4 = Paths.get(str1, new String[0])).resolve(paramString);
/* 128 */       if (canWrite(path4, path5, paramURL, paramConsumer)) {
/* 129 */         return path5;
/*     */       }
/* 131 */       APIUtil.apiLogMore("The path " + str1 + " is not accessible. Trying other paths.");
/*     */     } 
/*     */     
/* 134 */     str1 = Version.getVersion().replace(' ', '-');
/* 135 */     String str2 = Platform.getArchitecture().name().toLowerCase();
/*     */ 
/*     */ 
/*     */     
/* 139 */     Path path1, path2 = (path1 = Paths.get(System.getProperty("java.io.tmpdir"), new String[0])).resolve(Paths.get(Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY.get("lwjgl_" + System.getProperty("user.name").trim()), new String[] { str1, str2, paramString }));
/* 140 */     if (canWrite(path1, path2, paramURL, paramConsumer)) {
/* 141 */       return path2;
/*     */     }
/*     */     
/* 144 */     Path path3 = Paths.get("." + (String)Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY.get("lwjgl"), new String[] { str1, str2, paramString });
/*     */ 
/*     */     
/* 147 */     path2 = (path1 = Paths.get("", new String[0]).toAbsolutePath()).resolve(path3);
/* 148 */     if (canWrite(path1, path2, paramURL, paramConsumer)) {
/* 149 */       return path2;
/*     */     }
/*     */ 
/*     */     
/* 153 */     path2 = (path1 = Paths.get(System.getProperty("user.home"), new String[0])).resolve(path3);
/* 154 */     if (canWrite(path1, path2, paramURL, paramConsumer)) {
/* 155 */       return path2;
/*     */     }
/*     */     
/* 158 */     if (Platform.get() == Platform.WINDOWS) {
/*     */       String str;
/*     */       
/* 161 */       if ((str = System.getenv("SystemRoot")) != null) {
/* 162 */         Path path; path2 = (path = Paths.get(str, new String[] { "Temp" })).resolve(path3);
/* 163 */         if (canWrite(path, path2, paramURL, paramConsumer)) {
/* 164 */           return path2;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 170 */       if ((str = System.getenv("SystemDrive")) != null) {
/* 171 */         Path path; path2 = (path = Paths.get(str + "/", new String[0])).resolve(Paths.get("Temp", new String[0]).resolve(path3));
/* 172 */         if (canWrite(path, path2, paramURL, paramConsumer)) {
/* 173 */           return path2;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 181 */       path1 = (path2 = Files.createTempDirectory("lwjgl", (FileAttribute<?>[])new FileAttribute[0])).getParent();
/* 182 */       path2 = path2.resolve(paramString);
/* 183 */       if (canWrite(path1, path2, paramURL, paramConsumer)) {
/* 184 */         return path2;
/*     */       }
/* 186 */     } catch (IOException iOException) {}
/*     */ 
/*     */     
/* 189 */     throw new RuntimeException("Failed to find an appropriate directory to extract the native library");
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
/*     */   private static FileChannel extract(Path paramPath, URL paramURL) {
/* 203 */     if (Files.exists(paramPath, new java.nio.file.LinkOption[0]))
/*     */     {
/* 205 */       try(InputStream null = paramURL.openStream(); 
/* 206 */           InputStream null = Files.newInputStream(paramPath, new java.nio.file.OpenOption[0])) {
/*     */         
/* 208 */         if (crc(inputStream1) == crc(inputStream2)) {
/* 209 */           if (((Boolean)Configuration.DEBUG_LOADER.get(Boolean.FALSE)).booleanValue()) {
/* 210 */             APIUtil.apiLogMore("Found at: " + paramPath);
/*     */           }
/* 212 */           return lock(paramPath);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 218 */     APIUtil.apiLogMore("Extracting: " + throwable.getPath());
/*     */     
/* 220 */     if (extractPath == null) {
/* 221 */       APIUtil.apiLogMore("        to: " + paramPath);
/*     */     }
/*     */     
/* 224 */     Files.createDirectories(paramPath.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
/* 225 */     try (InputStream null = throwable.openStream()) {
/* 226 */       Files.copy(inputStream, paramPath, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*     */     } 
/*     */     
/* 229 */     return lock(paramPath);
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
/*     */   private static FileChannel lock(Path paramPath) {
/*     */     try {
/*     */       FileChannel fileChannel;
/* 243 */       if ((fileChannel = FileChannel.open(paramPath, new java.nio.file.OpenOption[0])).tryLock(0L, Long.MAX_VALUE, true) == null) {
/* 244 */         if (((Boolean)Configuration.DEBUG_LOADER.get(Boolean.FALSE)).booleanValue()) {
/* 245 */           APIUtil.apiLogMore("File is locked by another process, waiting...");
/*     */         }
/*     */         
/* 248 */         fileChannel.lock(0L, Long.MAX_VALUE, true);
/*     */       } 
/*     */ 
/*     */       
/* 252 */       return fileChannel;
/* 253 */     } catch (Exception exception) {
/* 254 */       throw new RuntimeException("Failed to lock file.", exception);
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
/*     */   private static long crc(InputStream paramInputStream) {
/* 266 */     CRC32 cRC32 = new CRC32();
/*     */     
/* 268 */     byte[] arrayOfByte = new byte[8192]; int i;
/* 269 */     while ((i = paramInputStream.read(arrayOfByte)) != -1) {
/* 270 */       cRC32.update(arrayOfByte, 0, i);
/*     */     }
/*     */     
/* 273 */     return cRC32.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean canWrite(Path paramPath1, Path paramPath2, URL paramURL, Consumer<String> paramConsumer) {
/*     */     Path path;
/* 285 */     if (Files.exists(paramPath2, new java.nio.file.LinkOption[0])) {
/* 286 */       if (!Files.isWritable(paramPath2)) {
/* 287 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 291 */       path = paramPath2.getParent().resolve(".lwjgl.test");
/*     */     } else {
/*     */       try {
/* 294 */         Files.createDirectories(paramPath2.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
/* 295 */       } catch (IOException iOException) {
/* 296 */         return false;
/*     */       } 
/* 298 */       path = paramPath2;
/*     */     } 
/*     */     
/*     */     try {
/* 302 */       Files.write(path, new byte[0], new java.nio.file.OpenOption[0]);
/* 303 */       Files.delete(path);
/*     */       
/* 305 */       if (paramConsumer != null && Platform.get() == Platform.WINDOWS) {
/* 306 */         workaroundJDK8195129(paramPath2, paramURL, paramConsumer);
/*     */       }
/*     */       
/* 309 */       return true;
/* 310 */     } catch (Throwable throwable) {
/* 311 */       if (paramPath2 == path) {
/* 312 */         canWriteCleanup(paramPath1, paramPath2);
/*     */       }
/* 314 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void canWriteCleanup(Path paramPath1, Path paramPath2) {
/*     */     try {
/* 321 */       Files.deleteIfExists(paramPath2);
/*     */ 
/*     */       
/* 324 */       paramPath2 = paramPath2.getParent(); while (true) {
/* 325 */         if (!Files.isSameFile(paramPath2, paramPath1)) {
/* 326 */           try (Stream<Path> null = Files.list(paramPath2)) {} {
/*     */           
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/* 334 */       } catch (IOException iOException) {}
/*     */     }
/*     */ 
/*     */     
/*     */     private static void workaroundJDK8195129(Path paramPath, URL paramURL, Consumer<String> paramConsumer) {
/*     */       String str;
/* 340 */       if ((str = paramPath.toAbsolutePath().toString()).endsWith(".dll")) {
/* 341 */         boolean bool = false;
/* 342 */         for (byte b = 0; b < str.length(); b++) {
/* 343 */           if ('' <= str.charAt(b)) {
/* 344 */             bool = true;
/*     */           }
/*     */         } 
/* 347 */         if (bool) {
/*     */           Path path;
/*     */ 
/*     */           
/* 351 */           FileChannel fileChannel = extract(paramPath, paramURL); paramURL = null; 
/* 352 */           try { paramConsumer.accept(paramPath.toAbsolutePath().toString()); } catch (Throwable throwable) { path = paramPath = null; throw paramPath; }
/* 353 */           finally { if (fileChannel != null) if (path != null) { try { fileChannel.close(); } catch (Throwable throwable) { path.addSuppressed(throwable); }  } else { fileChannel.close(); }   }
/*     */         
/* 355 */         }  checkedJDK8195129 = true;
/*     */       } 
/*     */     }
/*     */   }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\SharedLibraryLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */