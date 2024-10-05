/*     */ package nonapi.io.github.classgraph.classpath;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.utils.FastPathResolver;
/*     */ import nonapi.io.github.classgraph.utils.FileUtils;
/*     */ import nonapi.io.github.classgraph.utils.JarUtils;
/*     */ import nonapi.io.github.classgraph.utils.VersionFinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SystemJarFinder
/*     */ {
/*  44 */   private static final Set<String> RT_JARS = new LinkedHashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String RT_JAR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     String str2;
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
/*     */   static {
/*     */     String str1;
/* 101 */     if ((str1 = VersionFinder.getProperty("java.home")) == null || str1.isEmpty()) {
/* 102 */       str1 = System.getenv("JAVA_HOME");
/*     */     }
/* 104 */     if (str1 != null && !str1.isEmpty()) {
/*     */       File file;
/* 106 */       addJREPath(file = new File(str1));
/* 107 */       if (file.getName().equals("jre")) {
/*     */         File file1;
/*     */         
/* 110 */         addJREPath(file1 = file.getParentFile());
/* 111 */         addJREPath(new File(file1, "lib"));
/* 112 */         addJREPath(new File(file1, "lib/ext"));
/*     */       } else {
/*     */         
/* 115 */         addJREPath(new File(file, "jre"));
/*     */       } 
/* 117 */       addJREPath(new File(file, "lib"));
/* 118 */       addJREPath(new File(file, "lib/ext"));
/* 119 */       addJREPath(new File(file, "jre/lib"));
/* 120 */       addJREPath(new File(file, "jre/lib/ext"));
/* 121 */       addJREPath(new File(file, "packages"));
/* 122 */       addJREPath(new File(file, "packages/lib"));
/* 123 */       addJREPath(new File(file, "packages/lib/ext"));
/*     */     } 
/*     */     
/* 126 */     if ((str1 = VersionFinder.getProperty("java.ext.dirs")) != null && !str1.isEmpty()) {
/* 127 */       int i; String[] arrayOfString; byte b; for (i = (arrayOfString = JarUtils.smartPathSplit(str1, null)).length, b = 0; b < i; b++) {
/* 128 */         String str; if (!(str = arrayOfString[b]).isEmpty()) {
/* 129 */           addJREPath(new File(str));
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 135 */     switch (VersionFinder.OS) {
/*     */       case Linux:
/*     */       case Unix:
/*     */       case BSD:
/*     */       case Unknown:
/* 140 */         addJREPath(new File("/usr/java/packages"));
/* 141 */         addJREPath(new File("/usr/java/packages/lib"));
/* 142 */         addJREPath(new File("/usr/java/packages/lib/ext"));
/*     */         break;
/*     */       case MacOSX:
/* 145 */         addJREPath(new File("/System/Library/Java"));
/* 146 */         addJREPath(new File("/System/Library/Java/Libraries"));
/* 147 */         addJREPath(new File("/System/Library/Java/Extensions"));
/*     */         break;
/*     */       
/*     */       case Windows:
/* 151 */         if ((str2 = (String)((File.separatorChar == '\\') ? System.getenv("SystemRoot") : null)) != null) {
/* 152 */           addJREPath(new File(str2, "Sun\\Java"));
/* 153 */           addJREPath(new File(str2, "Sun\\Java\\lib"));
/* 154 */           addJREPath(new File(str2, "Sun\\Java\\lib\\ext"));
/* 155 */           addJREPath(new File(str2, "Oracle\\Java"));
/* 156 */           addJREPath(new File(str2, "Oracle\\Java\\lib"));
/* 157 */           addJREPath(new File(str2, "Oracle\\Java\\lib\\ext"));
/*     */         } 
/*     */         break;
/*     */       
/*     */       case Solaris:
/* 162 */         addJREPath(new File("/usr/jdk/packages"));
/* 163 */         addJREPath(new File("/usr/jdk/packages/lib"));
/* 164 */         addJREPath(new File("/usr/jdk/packages/lib/ext"));
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 170 */     RT_JAR = RT_JARS.isEmpty() ? null : FastPathResolver.resolve(RT_JARS.iterator().next());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Set<String> JRE_LIB_OR_EXT_JARS = new LinkedHashSet<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getJreRtJarPath() {
/* 180 */     return RT_JAR;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<String> getJreLibOrExtJars() {
/* 189 */     return JRE_LIB_OR_EXT_JARS;
/*     */   }
/*     */   
/*     */   private static boolean addJREPath(File paramFile) {
/*     */     File[] arrayOfFile;
/*     */     if (paramFile != null && !paramFile.getPath().isEmpty() && FileUtils.canReadAndIsDir(paramFile) && (arrayOfFile = paramFile.listFiles()) != null) {
/*     */       int i;
/*     */       byte b;
/*     */       for (i = (arrayOfFile = arrayOfFile).length, b = 0; b < i; b++) {
/*     */         File file;
/*     */         String str;
/*     */         if ((str = (file = arrayOfFile[b]).getPath()).endsWith(".jar")) {
/*     */           String str1;
/*     */           if ((str1 = FastPathResolver.resolve(FileUtils.currDirPath(), str)).endsWith("/rt.jar")) {
/*     */             RT_JARS.add(str1);
/*     */           } else {
/*     */             JRE_LIB_OR_EXT_JARS.add(str1);
/*     */           } 
/*     */           try {
/*     */             String str2;
/*     */             if (!(str2 = (file = file.getCanonicalFile()).getPath()).equals(str)) {
/*     */               str2 = FastPathResolver.resolve(FileUtils.currDirPath(), str);
/*     */               JRE_LIB_OR_EXT_JARS.add(str2);
/*     */             } 
/*     */           } catch (IOException|SecurityException iOException) {}
/*     */         } 
/*     */       } 
/*     */       return true;
/*     */     } 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classpath\SystemJarFinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */