/*      */ package io.github.classgraph;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.net.URI;
/*      */ import java.net.URL;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.concurrent.Callable;
/*      */ import java.util.concurrent.ExecutionException;
/*      */ import java.util.concurrent.ExecutorService;
/*      */ import java.util.concurrent.Future;
/*      */ import java.util.regex.Pattern;
/*      */ import nonapi.io.github.classgraph.classpath.SystemJarFinder;
/*      */ import nonapi.io.github.classgraph.concurrency.AutoCloseableExecutorService;
/*      */ import nonapi.io.github.classgraph.concurrency.InterruptionChecker;
/*      */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*      */ import nonapi.io.github.classgraph.scanspec.AcceptReject;
/*      */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*      */ import nonapi.io.github.classgraph.utils.JarUtils;
/*      */ import nonapi.io.github.classgraph.utils.LogNode;
/*      */ import nonapi.io.github.classgraph.utils.VersionFinder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ClassGraph
/*      */ {
/*   69 */   ScanSpec scanSpec = new ScanSpec();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   75 */   static final int DEFAULT_NUM_WORKER_THREADS = Math.max(2, 
/*      */ 
/*      */       
/*   78 */       (int)Math.ceil(
/*      */         
/*   80 */         Math.min(4.0D, Runtime.getRuntime().availableProcessors() * 0.75D) + 
/*      */         
/*   82 */         Runtime.getRuntime().availableProcessors() * 1.25D));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public enum CircumventEncapsulationMethod
/*      */   {
/*   94 */     NONE,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  100 */     NARCISSUS,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  106 */     JVM_DRIVER;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  128 */   public static CircumventEncapsulationMethod CIRCUMVENT_ENCAPSULATION = CircumventEncapsulationMethod.NONE;
/*      */ 
/*      */ 
/*      */   
/*      */   private final ReflectionUtils reflectionUtils;
/*      */ 
/*      */ 
/*      */   
/*      */   private LogNode topLevelLog;
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph() {
/*  141 */     this.reflectionUtils = new ReflectionUtils();
/*      */     
/*  143 */     ScanResult.init(this.reflectionUtils);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getVersion() {
/*  152 */     return VersionFinder.getVersion();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph verbose() {
/*  163 */     if (this.topLevelLog == null) {
/*  164 */       this.topLevelLog = new LogNode();
/*      */     }
/*  166 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph verbose(boolean paramBoolean) {
/*  177 */     if (paramBoolean) {
/*  178 */       verbose();
/*      */     }
/*  180 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableAllInfo() {
/*  198 */     enableClassInfo();
/*  199 */     enableFieldInfo();
/*  200 */     enableMethodInfo();
/*  201 */     enableAnnotationInfo();
/*  202 */     enableStaticFinalFieldConstantInitializerValues();
/*  203 */     ignoreClassVisibility();
/*  204 */     ignoreFieldVisibility();
/*  205 */     ignoreMethodVisibility();
/*  206 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableClassInfo() {
/*  216 */     this.scanSpec.enableClassInfo = true;
/*  217 */     this.scanSpec.enableMultiReleaseVersions = false;
/*  218 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph ignoreClassVisibility() {
/*  228 */     enableClassInfo();
/*  229 */     this.scanSpec.ignoreClassVisibility = true;
/*  230 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableMethodInfo() {
/*  241 */     enableClassInfo();
/*  242 */     this.scanSpec.enableMethodInfo = true;
/*  243 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph ignoreMethodVisibility() {
/*  254 */     enableClassInfo();
/*  255 */     enableMethodInfo();
/*  256 */     this.scanSpec.ignoreMethodVisibility = true;
/*  257 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableFieldInfo() {
/*  268 */     enableClassInfo();
/*  269 */     this.scanSpec.enableFieldInfo = true;
/*  270 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph ignoreFieldVisibility() {
/*  281 */     enableClassInfo();
/*  282 */     enableFieldInfo();
/*  283 */     this.scanSpec.ignoreFieldVisibility = true;
/*  284 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableStaticFinalFieldConstantInitializerValues() {
/*  317 */     enableClassInfo();
/*  318 */     enableFieldInfo();
/*  319 */     this.scanSpec.enableStaticFinalFieldConstantInitializerValues = true;
/*  320 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableAnnotationInfo() {
/*  332 */     enableClassInfo();
/*  333 */     this.scanSpec.enableAnnotationInfo = true;
/*  334 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableInterClassDependencies() {
/*  347 */     enableClassInfo();
/*  348 */     enableFieldInfo();
/*  349 */     enableMethodInfo();
/*  350 */     enableAnnotationInfo();
/*  351 */     ignoreClassVisibility();
/*  352 */     ignoreFieldVisibility();
/*  353 */     ignoreMethodVisibility();
/*  354 */     this.scanSpec.enableInterClassDependencies = true;
/*  355 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph disableRuntimeInvisibleAnnotations() {
/*  367 */     enableClassInfo();
/*  368 */     this.scanSpec.disableRuntimeInvisibleAnnotations = true;
/*  369 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph disableJarScanning() {
/*  380 */     this.scanSpec.scanJars = false;
/*  381 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph disableNestedJarScanning() {
/*  390 */     this.scanSpec.scanNestedJars = false;
/*  391 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph disableDirScanning() {
/*  400 */     this.scanSpec.scanDirs = false;
/*  401 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph disableModuleScanning() {
/*  410 */     this.scanSpec.scanModules = false;
/*  411 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableExternalClasses() {
/*  424 */     enableClassInfo();
/*  425 */     this.scanSpec.enableExternalClasses = true;
/*  426 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph initializeLoadedClasses() {
/*  436 */     this.scanSpec.initializeLoadedClasses = true;
/*  437 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph removeTemporaryFilesAfterScan() {
/*  448 */     this.scanSpec.removeTemporaryFilesAfterScan = true;
/*  449 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph overrideClasspath(String paramString) {
/*  468 */     if (paramString.isEmpty())
/*  469 */       throw new IllegalArgumentException("Can't override classpath with an empty path");  String[] arrayOfString; int i;
/*      */     byte b;
/*  471 */     for (i = (arrayOfString = JarUtils.smartPathSplit(paramString, this.scanSpec)).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*  472 */       this.scanSpec.addClasspathOverride(str); b++; }
/*      */     
/*  474 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph overrideClasspath(Iterable<?> paramIterable) {
/*  490 */     if (!paramIterable.iterator().hasNext()) {
/*  491 */       throw new IllegalArgumentException("Can't override classpath with an empty path");
/*      */     }
/*  493 */     for (Object object : paramIterable) {
/*  494 */       this.scanSpec.addClasspathOverride(object);
/*      */     }
/*  496 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph overrideClasspath(Object... paramVarArgs) {
/*  512 */     if (paramVarArgs.length == 0)
/*  513 */       throw new IllegalArgumentException("Can't override classpath with an empty path");  int i;
/*      */     byte b;
/*  515 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Object object = paramVarArgs[b];
/*  516 */       this.scanSpec.addClasspathOverride(object); b++; }
/*      */     
/*  518 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph filterClasspathElements(ClasspathElementFilter paramClasspathElementFilter) {
/*  568 */     this.scanSpec.filterClasspathElements(paramClasspathElementFilter);
/*  569 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph filterClasspathElementsByURL(ClasspathElementURLFilter paramClasspathElementURLFilter) {
/*  582 */     this.scanSpec.filterClasspathElements(paramClasspathElementURLFilter);
/*  583 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph addClassLoader(ClassLoader paramClassLoader) {
/*  600 */     this.scanSpec.addClassLoader(paramClassLoader);
/*  601 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph overrideClassLoaders(ClassLoader... paramVarArgs) {
/*  618 */     this.scanSpec.overrideClassLoaders(paramVarArgs);
/*  619 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph ignoreParentClassLoaders() {
/*  629 */     this.scanSpec.ignoreParentClassLoaders = true;
/*  630 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph addModuleLayer(Object paramObject) {
/*  648 */     this.scanSpec.addModuleLayer(paramObject);
/*  649 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph overrideModuleLayers(Object... paramVarArgs) {
/*  665 */     this.scanSpec.overrideModuleLayers(paramVarArgs);
/*  666 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph ignoreParentModuleLayers() {
/*  675 */     this.scanSpec.ignoreParentModuleLayers = true;
/*  676 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph acceptPackages(String... paramVarArgs) {
/*  694 */     enableClassInfo(); int i; byte b;
/*  695 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*  696 */       String str1 = AcceptReject.normalizePackageOrClassName(str1 = paramVarArgs[b]);
/*      */       
/*  698 */       this.scanSpec.packageAcceptReject.addToAccept(str1);
/*  699 */       String str2 = AcceptReject.packageNameToPath(str1);
/*  700 */       this.scanSpec.pathAcceptReject.addToAccept(str2 + "/");
/*  701 */       if (str1.isEmpty()) {
/*  702 */         this.scanSpec.pathAcceptReject.addToAccept("");
/*      */       }
/*  704 */       if (!str1.contains("*"))
/*      */       {
/*  706 */         if (str1.isEmpty()) {
/*  707 */           this.scanSpec.packagePrefixAcceptReject.addToAccept("");
/*  708 */           this.scanSpec.pathPrefixAcceptReject.addToAccept("");
/*      */         } else {
/*  710 */           this.scanSpec.packagePrefixAcceptReject.addToAccept(str1 + ".");
/*  711 */           this.scanSpec.pathPrefixAcceptReject.addToAccept(str2 + "/");
/*      */         } 
/*      */       }
/*      */     } 
/*  715 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph whitelistPackages(String... paramVarArgs) {
/*  729 */     return acceptPackages(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph acceptPaths(String... paramVarArgs) {
/*      */     int i;
/*      */     byte b;
/*  741 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*      */ 
/*      */       
/*  744 */       String str1, str2 = AcceptReject.pathToPackageName(str1 = AcceptReject.normalizePath(str1 = paramVarArgs[b]));
/*  745 */       this.scanSpec.packageAcceptReject.addToAccept(str2);
/*  746 */       this.scanSpec.pathAcceptReject.addToAccept(str1 + "/");
/*  747 */       if (str1.isEmpty()) {
/*  748 */         this.scanSpec.pathAcceptReject.addToAccept("");
/*      */       }
/*  750 */       if (!str1.contains("*"))
/*      */       {
/*  752 */         if (str1.isEmpty()) {
/*  753 */           this.scanSpec.packagePrefixAcceptReject.addToAccept("");
/*  754 */           this.scanSpec.pathPrefixAcceptReject.addToAccept("");
/*      */         } else {
/*  756 */           this.scanSpec.packagePrefixAcceptReject.addToAccept(str2 + ".");
/*  757 */           this.scanSpec.pathPrefixAcceptReject.addToAccept(str1 + "/");
/*      */         } 
/*      */       }
/*      */     } 
/*  761 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph whitelistPaths(String... paramVarArgs) {
/*  775 */     return acceptPaths(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph acceptPackagesNonRecursive(String... paramVarArgs) {
/*  797 */     enableClassInfo(); int i; byte b;
/*  798 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*      */       String str;
/*  800 */       if ((str = AcceptReject.normalizePackageOrClassName(str = paramVarArgs[b])).contains("*")) {
/*  801 */         throw new IllegalArgumentException("Cannot use a glob wildcard here: " + str);
/*      */       }
/*      */       
/*  804 */       this.scanSpec.packageAcceptReject.addToAccept(str);
/*  805 */       this.scanSpec.pathAcceptReject.addToAccept(AcceptReject.packageNameToPath(str) + "/");
/*  806 */       if (str.isEmpty()) {
/*  807 */         this.scanSpec.pathAcceptReject.addToAccept("");
/*      */       }
/*      */     } 
/*  810 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph whitelistPackagesNonRecursive(String... paramVarArgs) {
/*  824 */     return acceptPackagesNonRecursive(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph acceptPathsNonRecursive(String... paramVarArgs) {
/*      */     int i;
/*      */     byte b;
/*  841 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*  842 */       String str; if ((str = paramVarArgs[b]).contains("*")) {
/*  843 */         throw new IllegalArgumentException("Cannot use a glob wildcard here: " + str);
/*      */       }
/*  845 */       str = AcceptReject.normalizePath(str);
/*      */       
/*  847 */       this.scanSpec.packageAcceptReject.addToAccept(AcceptReject.pathToPackageName(str));
/*  848 */       this.scanSpec.pathAcceptReject.addToAccept(str + "/");
/*  849 */       if (str.isEmpty()) {
/*  850 */         this.scanSpec.pathAcceptReject.addToAccept("");
/*      */       }
/*      */     } 
/*  853 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph whitelistPathsNonRecursive(String... paramVarArgs) {
/*  867 */     return acceptPathsNonRecursive(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph rejectPackages(String... paramVarArgs) {
/*  883 */     enableClassInfo(); int i; byte b;
/*  884 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*      */       String str1;
/*  886 */       if ((str1 = AcceptReject.normalizePackageOrClassName(str1 = paramVarArgs[b])).isEmpty()) {
/*  887 */         throw new IllegalArgumentException("Rejecting the root package (\"\") will cause nothing to be scanned");
/*      */       }
/*      */ 
/*      */       
/*  891 */       this.scanSpec.packageAcceptReject.addToReject(str1);
/*  892 */       String str2 = AcceptReject.packageNameToPath(str1);
/*  893 */       this.scanSpec.pathAcceptReject.addToReject(str2 + "/");
/*  894 */       if (!str1.contains("*")) {
/*      */         
/*  896 */         this.scanSpec.packagePrefixAcceptReject.addToReject(str1 + ".");
/*  897 */         this.scanSpec.pathPrefixAcceptReject.addToReject(str2 + "/");
/*      */       } 
/*      */     } 
/*  900 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph blacklistPackages(String... paramVarArgs) {
/*  914 */     return rejectPackages(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph rejectPaths(String... paramVarArgs) {
/*      */     int i;
/*      */     byte b;
/*  925 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*      */       String str1;
/*  927 */       if ((str1 = AcceptReject.normalizePath(str1 = paramVarArgs[b])).isEmpty()) {
/*  928 */         throw new IllegalArgumentException("Rejecting the root package (\"\") will cause nothing to be scanned");
/*      */       }
/*      */ 
/*      */       
/*  932 */       String str2 = AcceptReject.pathToPackageName(str1);
/*  933 */       this.scanSpec.packageAcceptReject.addToReject(str2);
/*  934 */       this.scanSpec.pathAcceptReject.addToReject(str1 + "/");
/*  935 */       if (!str1.contains("*")) {
/*      */         
/*  937 */         this.scanSpec.packagePrefixAcceptReject.addToReject(str2 + ".");
/*  938 */         this.scanSpec.pathPrefixAcceptReject.addToReject(str1 + "/");
/*      */       } 
/*      */     } 
/*  941 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph blacklistPaths(String... paramVarArgs) {
/*  954 */     return rejectPaths(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph acceptClasses(String... paramVarArgs) {
/*  971 */     enableClassInfo(); int i; byte b;
/*  972 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*  973 */       String str = AcceptReject.normalizePackageOrClassName(str = paramVarArgs[b]);
/*      */       
/*  975 */       this.scanSpec.classAcceptReject.addToAccept(str);
/*  976 */       this.scanSpec.classfilePathAcceptReject
/*  977 */         .addToAccept(AcceptReject.classNameToClassfilePath(str));
/*  978 */       str = PackageInfo.getParentPackageName(str);
/*      */ 
/*      */       
/*  981 */       this.scanSpec.classPackageAcceptReject.addToAccept(str);
/*  982 */       this.scanSpec.classPackagePathAcceptReject.addToAccept(AcceptReject.packageNameToPath(str) + "/");
/*      */     } 
/*  984 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph whitelistClasses(String... paramVarArgs) {
/*  997 */     return acceptClasses(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph rejectClasses(String... paramVarArgs) {
/* 1013 */     enableClassInfo(); int i; byte b;
/* 1014 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 1015 */       String str = AcceptReject.normalizePackageOrClassName(str = paramVarArgs[b]);
/* 1016 */       this.scanSpec.classAcceptReject.addToReject(str);
/* 1017 */       this.scanSpec.classfilePathAcceptReject
/* 1018 */         .addToReject(AcceptReject.classNameToClassfilePath(str));
/*      */     } 
/* 1020 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph blacklistClasses(String... paramVarArgs) {
/* 1033 */     return rejectClasses(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph acceptJars(String... paramVarArgs) {
/*      */     int i;
/*      */     byte b;
/* 1045 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*      */       String str1; String str2;
/* 1047 */       if (!(str2 = JarUtils.leafName(str1 = paramVarArgs[b])).equals(str1)) {
/* 1048 */         throw new IllegalArgumentException("Can only accept jars by leafname: " + str1);
/*      */       }
/* 1050 */       this.scanSpec.jarAcceptReject.addToAccept(str2);
/*      */     } 
/* 1052 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph whitelistJars(String... paramVarArgs) {
/* 1066 */     return acceptJars(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph rejectJars(String... paramVarArgs) {
/*      */     int i;
/*      */     byte b;
/* 1078 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*      */       String str1; String str2;
/* 1080 */       if (!(str2 = JarUtils.leafName(str1 = paramVarArgs[b])).equals(str1)) {
/* 1081 */         throw new IllegalArgumentException("Can only reject jars by leafname: " + str1);
/*      */       }
/* 1083 */       this.scanSpec.jarAcceptReject.addToReject(str2);
/*      */     } 
/* 1085 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph blacklistJars(String... paramVarArgs) {
/* 1099 */     return rejectJars(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void acceptOrRejectLibOrExtJars(boolean paramBoolean, String... paramVarArgs) {
/* 1111 */     if (paramVarArgs.length == 0) {
/*      */       
/* 1113 */       for (String str : SystemJarFinder.getJreLibOrExtJars()) {
/* 1114 */         acceptOrRejectLibOrExtJars(paramBoolean, new String[] { JarUtils.leafName(str) });
/*      */       }  return;
/*      */     }  int i; byte b;
/* 1117 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*      */       String str1; String str2;
/* 1119 */       if (!(str2 = JarUtils.leafName(str1 = paramVarArgs[b])).equals(str1)) {
/* 1120 */         throw new IllegalArgumentException("Can only " + (paramBoolean ? "accept" : "reject") + " jars by leafname: " + str1);
/*      */       }
/*      */       
/* 1123 */       if (str1.contains("*")) {
/*      */         
/* 1125 */         Pattern pattern = AcceptReject.globToPattern(str1, true);
/* 1126 */         boolean bool = false;
/* 1127 */         for (Iterator<String> iterator = SystemJarFinder.getJreLibOrExtJars().iterator(); iterator.hasNext(); ) {
/* 1128 */           String str = JarUtils.leafName(str = iterator.next());
/* 1129 */           if (pattern.matcher(str).matches()) {
/*      */             
/* 1131 */             if (!str.contains("*")) {
/* 1132 */               acceptOrRejectLibOrExtJars(paramBoolean, new String[] { str });
/*      */             }
/* 1134 */             bool = true;
/*      */           } 
/*      */         } 
/* 1137 */         if (!bool && this.topLevelLog != null) {
/* 1138 */           this.topLevelLog.log("Could not find lib or ext jar matching wildcard: " + str1);
/*      */         }
/*      */       } else {
/*      */         
/* 1142 */         boolean bool = false;
/* 1143 */         for (Iterator<String> iterator = SystemJarFinder.getJreLibOrExtJars().iterator(); iterator.hasNext(); ) {
/* 1144 */           String str3, str4 = JarUtils.leafName(str3 = iterator.next());
/* 1145 */           if (str1.equals(str4)) {
/* 1146 */             if (paramBoolean) {
/* 1147 */               this.scanSpec.libOrExtJarAcceptReject.addToAccept(str1);
/*      */             } else {
/* 1149 */               this.scanSpec.libOrExtJarAcceptReject.addToReject(str1);
/*      */             } 
/* 1151 */             if (this.topLevelLog != null) {
/* 1152 */               this.topLevelLog.log((paramBoolean ? "Accepting" : "Rejecting") + " lib or ext jar: " + str3);
/*      */             }
/*      */             
/* 1155 */             bool = true;
/*      */             break;
/*      */           } 
/*      */         } 
/* 1159 */         if (!bool && this.topLevelLog != null) {
/* 1160 */           this.topLevelLog.log("Could not find lib or ext jar: " + str1);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph acceptLibOrExtJars(String... paramVarArgs) {
/* 1178 */     acceptOrRejectLibOrExtJars(true, paramVarArgs);
/* 1179 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph whitelistLibOrExtJars(String... paramVarArgs) {
/* 1194 */     return acceptLibOrExtJars(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph rejectLibOrExtJars(String... paramVarArgs) {
/* 1207 */     acceptOrRejectLibOrExtJars(false, paramVarArgs);
/* 1208 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph blacklistLibOrExtJars(String... paramVarArgs) {
/* 1223 */     return rejectLibOrExtJars(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph acceptModules(String... paramVarArgs) {
/*      */     int i;
/*      */     byte b;
/* 1234 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { String str = paramVarArgs[b];
/* 1235 */       this.scanSpec.moduleAcceptReject.addToAccept(AcceptReject.normalizePackageOrClassName(str)); b++; }
/*      */     
/* 1237 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph whitelistModules(String... paramVarArgs) {
/* 1250 */     return acceptModules(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph rejectModules(String... paramVarArgs) {
/*      */     int i;
/*      */     byte b;
/* 1261 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { String str = paramVarArgs[b];
/* 1262 */       this.scanSpec.moduleAcceptReject.addToReject(AcceptReject.normalizePackageOrClassName(str)); b++; }
/*      */     
/* 1264 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph blacklistModules(String... paramVarArgs) {
/* 1277 */     return rejectModules(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph acceptClasspathElementsContainingResourcePath(String... paramVarArgs) {
/*      */     int i;
/*      */     byte b;
/* 1290 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 1291 */       String str = AcceptReject.normalizePath(str = paramVarArgs[b]);
/* 1292 */       this.scanSpec.classpathElementResourcePathAcceptReject.addToAccept(str);
/*      */     } 
/* 1294 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph whitelistClasspathElementsContainingResourcePath(String... paramVarArgs) {
/* 1308 */     return acceptClasspathElementsContainingResourcePath(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph rejectClasspathElementsContainingResourcePath(String... paramVarArgs) {
/*      */     int i;
/*      */     byte b;
/* 1321 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 1322 */       String str = AcceptReject.normalizePath(str = paramVarArgs[b]);
/* 1323 */       this.scanSpec.classpathElementResourcePathAcceptReject.addToReject(str);
/*      */     } 
/* 1325 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public ClassGraph blacklistClasspathElementsContainingResourcePath(String... paramVarArgs) {
/* 1339 */     return rejectClasspathElementsContainingResourcePath(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableRemoteJarScanning() {
/* 1356 */     this.scanSpec.enableURLScheme("http");
/* 1357 */     this.scanSpec.enableURLScheme("https");
/* 1358 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableURLScheme(String paramString) {
/* 1371 */     this.scanSpec.enableURLScheme(paramString);
/* 1372 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableSystemJarsAndModules() {
/* 1385 */     enableClassInfo();
/* 1386 */     this.scanSpec.enableSystemJarsAndModules = true;
/* 1387 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph setMaxBufferedJarRAMSize(int paramInt) {
/* 1419 */     this.scanSpec.maxBufferedJarRAMSize = paramInt;
/* 1420 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableMemoryMapping() {
/* 1430 */     this.scanSpec.enableMemoryMapping = true;
/* 1431 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableMultiReleaseVersions() {
/* 1442 */     this.scanSpec.enableMultiReleaseVersions = true;
/*      */     
/* 1444 */     this.scanSpec.enableClassInfo = false;
/* 1445 */     this.scanSpec.ignoreClassVisibility = false;
/* 1446 */     this.scanSpec.enableMethodInfo = false;
/* 1447 */     this.scanSpec.ignoreMethodVisibility = false;
/* 1448 */     this.scanSpec.enableFieldInfo = false;
/* 1449 */     this.scanSpec.ignoreFieldVisibility = false;
/* 1450 */     this.scanSpec.enableStaticFinalFieldConstantInitializerValues = false;
/* 1451 */     this.scanSpec.enableAnnotationInfo = false;
/* 1452 */     this.scanSpec.enableInterClassDependencies = false;
/* 1453 */     this.scanSpec.disableRuntimeInvisibleAnnotations = false;
/* 1454 */     this.scanSpec.enableExternalClasses = false;
/* 1455 */     this.scanSpec.enableSystemJarsAndModules = false;
/* 1456 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ClassGraph enableRealtimeLogging() {
/* 1470 */     verbose();
/* 1471 */     LogNode.logInRealtime(true);
/* 1472 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void scanAsync(final ExecutorService executorService, final int numParallelTasks, final ScanResultProcessor scanResultProcessor, final FailureHandler failureHandler) {
/* 1518 */     if (scanResultProcessor == null)
/*      */     {
/*      */       
/* 1521 */       throw new IllegalArgumentException("scanResultProcessor cannot be null");
/*      */     }
/* 1523 */     if (failureHandler == null)
/*      */     {
/*      */       
/* 1526 */       throw new IllegalArgumentException("failureHandler cannot be null");
/*      */     }
/*      */     
/* 1529 */     executorService.execute(new Runnable()
/*      */         {
/*      */           public void run()
/*      */           {
/*      */             try {
/* 1534 */               (new Scanner(true, ClassGraph.this.scanSpec, executorService, numParallelTasks, scanResultProcessor, failureHandler, ClassGraph.this
/* 1535 */                   .reflectionUtils, ClassGraph.this.topLevelLog)).call(); return;
/* 1536 */             } catch (InterruptedException|java.util.concurrent.CancellationException|ExecutionException interruptedException) {
/*      */               
/* 1538 */               failureHandler.onFailure(interruptedException);
/*      */               return;
/*      */             } 
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Future<ScanResult> scanAsync(boolean paramBoolean, ExecutorService paramExecutorService, int paramInt) {
/*      */     try {
/* 1562 */       return paramExecutorService.submit(new Scanner(paramBoolean, this.scanSpec, paramExecutorService, paramInt, null, null, this.reflectionUtils, this.topLevelLog));
/*      */     }
/* 1564 */     catch (InterruptedException interruptedException) {
/*      */ 
/*      */       
/* 1567 */       return paramExecutorService.submit(new Callable<ScanResult>()
/*      */           {
/*      */             public ScanResult call() {
/* 1570 */               throw e;
/*      */             }
/*      */           });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Future<ScanResult> scanAsync(ExecutorService paramExecutorService, int paramInt) {
/* 1590 */     return scanAsync(true, paramExecutorService, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ScanResult scan(ExecutorService paramExecutorService, int paramInt) {
/*      */     try {
/*      */       ScanResult scanResult;
/* 1629 */       if ((scanResult = scanAsync(paramExecutorService, paramInt).get()) == null) {
/* 1630 */         throw new NullPointerException();
/*      */       }
/* 1632 */       return scanResult;
/*      */     }
/* 1634 */     catch (InterruptedException|java.util.concurrent.CancellationException interruptedException) {
/* 1635 */       throw new ClassGraphException("Scan interrupted", interruptedException);
/* 1636 */     } catch (ExecutionException executionException) {
/* 1637 */       throw new ClassGraphException("Uncaught exception during scan", InterruptionChecker.getCause(executionException));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ScanResult scan(int paramInt) {
/* 1653 */     AutoCloseableExecutorService autoCloseableExecutorService = new AutoCloseableExecutorService(paramInt); Throwable throwable2 = null; 
/* 1654 */     try { return scan((ExecutorService)autoCloseableExecutorService, paramInt); } catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/* 1655 */     finally { if (throwable2 != null) { try { throwable1.close(); } catch (Throwable throwable) { throwable2.addSuppressed(throwable); }  } else { throwable.close(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ScanResult scan() {
/* 1667 */     return scan(DEFAULT_NUM_WORKER_THREADS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ScanResult getClasspathScanResult(AutoCloseableExecutorService paramAutoCloseableExecutorService) {
/*      */     try {
/*      */       ScanResult scanResult;
/* 1688 */       if ((scanResult = scanAsync(false, (ExecutorService)paramAutoCloseableExecutorService, DEFAULT_NUM_WORKER_THREADS).get()) == null) {
/* 1689 */         throw new NullPointerException();
/*      */       }
/* 1691 */       return scanResult;
/*      */     }
/* 1693 */     catch (InterruptedException|java.util.concurrent.CancellationException interruptedException) {
/* 1694 */       throw new ClassGraphException("Scan interrupted", interruptedException);
/* 1695 */     } catch (ExecutionException executionException) {
/* 1696 */       throw new ClassGraphException("Uncaught exception during scan", InterruptionChecker.getCause(executionException));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<File> getClasspathFiles() {
/* 1711 */     AutoCloseableExecutorService autoCloseableExecutorService = new AutoCloseableExecutorService(DEFAULT_NUM_WORKER_THREADS); Throwable throwable = null; 
/* 1712 */     try { ScanResult scanResult = getClasspathScanResult(autoCloseableExecutorService); Throwable throwable2 = null; }
/*      */     catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 1714 */     finally { if (throwable != null) { try { autoCloseableExecutorService.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getClasspath() {
/* 1731 */     return JarUtils.pathElementsToPathStr(getClasspathFiles());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<URI> getClasspathURIs() {
/* 1744 */     AutoCloseableExecutorService autoCloseableExecutorService = new AutoCloseableExecutorService(DEFAULT_NUM_WORKER_THREADS); Throwable throwable = null; 
/* 1745 */     try { ScanResult scanResult = getClasspathScanResult(autoCloseableExecutorService); Throwable throwable2 = null; }
/*      */     catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 1747 */     finally { if (throwable != null) { try { autoCloseableExecutorService.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<URL> getClasspathURLs() {
/* 1760 */     AutoCloseableExecutorService autoCloseableExecutorService = new AutoCloseableExecutorService(DEFAULT_NUM_WORKER_THREADS); Throwable throwable = null; 
/* 1761 */     try { ScanResult scanResult = getClasspathScanResult(autoCloseableExecutorService); Throwable throwable2 = null; }
/*      */     catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 1763 */     finally { if (throwable != null) { try { autoCloseableExecutorService.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ModuleRef> getModules() {
/* 1774 */     AutoCloseableExecutorService autoCloseableExecutorService = new AutoCloseableExecutorService(DEFAULT_NUM_WORKER_THREADS); Throwable throwable = null; 
/* 1775 */     try { ScanResult scanResult = getClasspathScanResult(autoCloseableExecutorService); Throwable throwable2 = null; }
/*      */     catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/* 1777 */     finally { if (throwable != null) { try { autoCloseableExecutorService.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ModulePathInfo getModulePathInfo() {
/* 1798 */     this.scanSpec.modulePathInfo.getRuntimeInfo(this.reflectionUtils);
/* 1799 */     return this.scanSpec.modulePathInfo;
/*      */   }
/*      */   
/*      */   @FunctionalInterface
/*      */   public static interface FailureHandler {
/*      */     void onFailure(Throwable param1Throwable);
/*      */   }
/*      */   
/*      */   @FunctionalInterface
/*      */   public static interface ScanResultProcessor {
/*      */     void processScanResult(ScanResult param1ScanResult);
/*      */   }
/*      */   
/*      */   @FunctionalInterface
/*      */   public static interface ClasspathElementURLFilter {
/*      */     boolean includeClasspathElement(URL param1URL);
/*      */   }
/*      */   
/*      */   @FunctionalInterface
/*      */   public static interface ClasspathElementFilter {
/*      */     boolean includeClasspathElement(String param1String);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClassGraph.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */