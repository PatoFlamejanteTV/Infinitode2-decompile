/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.util.function.Function;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum Platform
/*     */ {
/*  16 */   LINUX("Linux", "linux") {
/*  17 */     private final Pattern SO = Pattern.compile("(?:^|/)lib\\w+[.]so(?:[.]\\d+)*$");
/*     */ 
/*     */     
/*     */     final String mapLibraryName(String param1String) {
/*  21 */       if (this.SO.matcher(param1String).find()) {
/*  22 */         return param1String;
/*     */       }
/*     */       
/*  25 */       return System.mapLibraryName(param1String);
/*     */     }
/*     */   },
/*     */   
/*  29 */   MACOSX("macOS", "macos") {
/*  30 */     private final Pattern DYLIB = Pattern.compile("(?:^|/)lib\\w+(?:[.]\\d+)*[.]dylib$");
/*     */ 
/*     */     
/*     */     final String mapLibraryName(String param1String) {
/*  34 */       if (this.DYLIB.matcher(param1String).find()) {
/*  35 */         return param1String;
/*     */       }
/*     */       
/*  38 */       return System.mapLibraryName(param1String);
/*     */     }
/*     */   },
/*  41 */   WINDOWS("Windows", "windows")
/*     */   {
/*     */     final String mapLibraryName(String param1String) {
/*  44 */       if (param1String.endsWith(".dll")) {
/*  45 */         return param1String;
/*     */       }
/*     */       
/*  48 */       return System.mapLibraryName(param1String);
/*     */     } }; private static final Platform current; private static final Function<String, String> bundledLibraryNameMapper;
/*     */   private static final Function<String, String> bundledLibraryPathMapper;
/*     */   private final String name;
/*     */   private final String nativePath;
/*     */   
/*  54 */   public enum Architecture { X64(true),
/*  55 */     X86(false),
/*  56 */     ARM64(true),
/*  57 */     ARM32(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       String str;
/*  65 */       boolean bool = ((str = System.getProperty("os.arch")).contains("64") || str.startsWith("armv8")) ? true : false;
/*     */       
/*  67 */       current = (str.startsWith("arm") || str.startsWith("aarch64")) ? (bool ? ARM64 : ARM32) : (bool ? X64 : X86);
/*     */     }
/*     */     static final Architecture current;
/*     */     final boolean is64Bit;
/*     */     
/*     */     Architecture(boolean param1Boolean) {
/*  73 */       this.is64Bit = param1Boolean;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     String str;
/*  84 */     if ((str = System.getProperty("os.name")).startsWith("Windows")) {
/*  85 */       current = WINDOWS;
/*  86 */     } else if (str.startsWith("Linux") || str.startsWith("FreeBSD") || str.startsWith("SunOS") || str.startsWith("Unix")) {
/*  87 */       current = LINUX;
/*  88 */     } else if (str.startsWith("Mac OS X") || str.startsWith("Darwin")) {
/*  89 */       current = MACOSX;
/*     */     } else {
/*  91 */       throw new LinkageError("Unknown platform: " + str);
/*     */     } 
/*     */     
/*  94 */     bundledLibraryNameMapper = getMapper(Configuration.BUNDLED_LIBRARY_NAME_MAPPER
/*  95 */         .get("default"), paramString -> paramString, paramString -> Architecture.current.is64Bit ? paramString : (paramString + "32"));
/*     */ 
/*     */ 
/*     */     
/*  99 */     bundledLibraryPathMapper = getMapper(Configuration.BUNDLED_LIBRARY_PATH_MAPPER
/* 100 */         .get("default"), paramString -> current.nativePath + "/" + Architecture.current.name().toLowerCase() + "/" + paramString, paramString -> paramString.substring(paramString.lastIndexOf('/')));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Platform(String paramString1, String paramString2) {
/* 110 */     this.name = paramString1;
/* 111 */     this.nativePath = paramString2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 116 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Platform get() {
/* 123 */     return current;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Architecture getArchitecture() {
/* 128 */     return Architecture.current;
/*     */   }
/*     */   
/*     */   public static String mapLibraryNameBundled(String paramString) {
/* 132 */     return bundledLibraryNameMapper.apply(paramString);
/*     */   }
/*     */   
/*     */   static String mapLibraryPathBundled(String paramString) {
/* 136 */     return bundledLibraryPathMapper.apply(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Function<String, String> getMapper(Object paramObject, Function<String, String> paramFunction1, Function<String, String> paramFunction2) {
/* 145 */     if (paramObject == null || "default".equals(paramObject)) {
/* 146 */       return paramFunction1;
/*     */     }
/*     */     
/* 149 */     if ("legacy".equals(paramObject)) {
/* 150 */       return paramFunction2;
/*     */     }
/*     */     
/* 153 */     if (paramObject instanceof Function) {
/* 154 */       return (Function<String, String>)paramObject;
/*     */     }
/*     */     
/* 157 */     paramObject = paramObject.toString();
/*     */     try {
/* 159 */       return 
/* 160 */         Class.forName((String)paramObject)
/* 161 */         .getConstructor(new Class[0])
/* 162 */         .newInstance(new Object[0]);
/* 163 */     } catch (Throwable throwable) {
/* 164 */       if (Checks.DEBUG) {
/* 165 */         throwable.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */       }
/* 167 */       APIUtil.apiLog(String.format("Warning: Failed to instantiate bundled library mapper: %s. Using the default.", new Object[] { paramObject }));
/* 168 */       return paramFunction1;
/*     */     } 
/*     */   }
/*     */   
/*     */   abstract String mapLibraryName(String paramString);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\Platform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */