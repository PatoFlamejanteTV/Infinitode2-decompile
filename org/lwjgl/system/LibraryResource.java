/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.net.URL;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LibraryResource
/*     */ {
/*     */   static {
/*  26 */     Library.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Path load(String paramString1, String paramString2) {
/*  33 */     return load(LibraryResource.class, paramString1, paramString2);
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
/*     */   public static Path load(Class<?> paramClass, String paramString1, String paramString2) {
/*  49 */     return load(paramClass, paramString1, paramString2, false, true);
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
/*     */   public static Path load(Class<?> paramClass, String paramString1, String paramString2, boolean paramBoolean) {
/*  67 */     return load(paramClass, paramString1, paramString2, paramBoolean, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Path load(Class<?> paramClass, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
/*  72 */     if (Checks.DEBUG) {
/*  73 */       APIUtil.DEBUG_STREAM.print("[LWJGL] Loading library resource: " + paramString2 + "\n\tModule: " + paramString1 + "\n");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     Path path;
/*     */ 
/*     */ 
/*     */     
/*  82 */     if ((path = Paths.get(paramString2, new String[0])).isAbsolute()) {
/*  83 */       if (!Files.exists(path, new java.nio.file.LinkOption[0])) {
/*  84 */         if (paramBoolean2) {
/*  85 */           printError();
/*     */         }
/*  87 */         throw new IllegalStateException("Failed to locate library resource: " + paramString2);
/*     */       } 
/*  89 */       APIUtil.apiLogMore("Success");
/*  90 */       return path;
/*     */     } 
/*     */     
/*     */     URL uRL;
/*     */     
/*  95 */     if ((uRL = Library.findResource(paramClass, paramString1, paramString2, paramBoolean1)) == null) {
/*     */       
/*  97 */       if ((path = loadFromLibraryPath(paramString1, paramString2, paramBoolean1)) != null) {
/*  98 */         return path;
/*     */       }
/*     */     } else {
/* 101 */       boolean bool = ((Boolean)Configuration.DEBUG_LOADER.get(Boolean.FALSE)).booleanValue();
/*     */       try {
/*     */         String str1;
/* 104 */         if ((null = Library.getRegularFilePath(uRL)) != null) {
/* 105 */           APIUtil.apiLogMore("Loaded from classpath: " + null);
/* 106 */           return Paths.get(null, new String[0]);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 111 */         if (bool) {
/* 112 */           APIUtil.apiLogMore("Using SharedLibraryLoader...");
/*     */         }
/*     */         
/* 115 */         FileChannel fileChannel = SharedLibraryLoader.load(paramString2, paramString2, uRL, null); Throwable throwable2 = null; 
/*     */         try { Path path1;
/* 117 */           if ((path1 = loadFromLibraryPath(paramString1, paramString2, paramBoolean1)) != null)
/* 118 */           { path1 = path1; return path1; }  }
/*     */         catch (Throwable throwable) { str1 = null = null; throw null; }
/* 120 */         finally { if (throwable1 != null) if (str1 != null) { try { throwable1.close(); } catch (Throwable throwable) { str1.addSuppressed(throwable); }  } else { throwable.close(); }   } 
/* 121 */       } catch (Exception exception) {
/* 122 */         if (bool) {
/* 123 */           exception.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*     */     String str;
/*     */     
/* 130 */     if ((str = System.getProperty("java.library.path")) != null && (
/*     */       
/* 132 */       path = load(paramString1, paramString2, paramBoolean1, "java.library.path", str)) != null) {
/* 133 */       return path;
/*     */     }
/*     */ 
/*     */     
/* 137 */     if (paramBoolean2) {
/* 138 */       printError();
/*     */     }
/* 140 */     throw new IllegalStateException("Failed to locate library resource: " + paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Path loadFromLibraryPath(String paramString1, String paramString2, boolean paramBoolean) {
/*     */     String str;
/* 146 */     if ((str = Configuration.LIBRARY_PATH.get()) == null) {
/* 147 */       return null;
/*     */     }
/* 149 */     return load(paramString1, paramString2, paramBoolean, Configuration.LIBRARY_PATH.getProperty(), str);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Path load(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4) {
/*     */     Path path;
/* 155 */     if ((path = Library.findFile(paramString4, paramString1, paramString2, paramBoolean)) == null) {
/* 156 */       APIUtil.apiLogMore(paramString2 + " not found in " + paramString3 + "=" + paramString4);
/* 157 */       return null;
/*     */     } 
/*     */     
/* 160 */     APIUtil.apiLogMore("Loaded from " + paramString3 + ": " + path);
/* 161 */     return path;
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
/*     */   public static Path load(Class<?> paramClass, String paramString, Configuration<String> paramConfiguration, String... paramVarArgs) {
/* 176 */     return load(paramClass, paramString, paramConfiguration, (Supplier<Path>)null, paramVarArgs);
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
/*     */   public static Path load(Class<?> paramClass, String paramString, Configuration<String> paramConfiguration, Supplier<Path> paramSupplier, String... paramVarArgs) {
/* 193 */     if (paramVarArgs.length == 0) {
/* 194 */       throw new IllegalArgumentException("No default names specified.");
/*     */     }
/*     */     
/*     */     String str;
/* 198 */     if ((str = paramConfiguration.get()) != null) {
/* 199 */       return load(paramClass, paramString, str);
/*     */     }
/*     */     
/* 202 */     if (paramSupplier == null && paramVarArgs.length <= 1) {
/* 203 */       return load(paramClass, paramString, paramVarArgs[0]);
/*     */     }
/*     */     
/*     */     try {
/* 207 */       return load(paramClass, paramString, paramVarArgs[0], false, false);
/* 208 */     } catch (Throwable throwable) {
/* 209 */       for (byte b = 1; b < paramVarArgs.length; b++) {
/*     */         try {
/* 211 */           return load(paramClass, paramString, paramVarArgs[b], false, (paramSupplier == null && b == paramVarArgs.length - 1));
/* 212 */         } catch (Throwable throwable1) {}
/*     */       } 
/*     */       
/* 215 */       if (paramSupplier != null) {
/* 216 */         return paramSupplier.get();
/*     */       }
/* 218 */       throw throwable;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void printError() {
/* 223 */     Library.printError("[LWJGL] Failed to load a library resource. Possible solutions:\n\ta) Add the directory that contains the resource to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the resource to the classpath.");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\LibraryResource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */