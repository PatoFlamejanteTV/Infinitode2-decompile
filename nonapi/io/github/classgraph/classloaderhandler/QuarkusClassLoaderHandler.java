/*     */ package nonapi.io.github.classgraph.classloaderhandler;
/*     */ 
/*     */ import java.io.IOError;
/*     */ import java.net.URI;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import nonapi.io.github.classgraph.classpath.ClassLoaderOrder;
/*     */ import nonapi.io.github.classgraph.classpath.ClasspathOrder;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class QuarkusClassLoaderHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   private static final String RUNTIME_CLASSLOADER = "io.quarkus.runner.RuntimeClassLoader";
/*     */   private static final String QUARKUS_CLASSLOADER = "io.quarkus.bootstrap.classloading.QuarkusClassLoader";
/*     */   private static final String RUNNER_CLASSLOADER = "io.quarkus.bootstrap.runner.RunnerClassLoader";
/*     */   
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*  71 */     if ("io.quarkus.runner.RuntimeClassLoader".equals(paramClass.getName()) || "io.quarkus.bootstrap.classloading.QuarkusClassLoader"
/*  72 */       .equals(paramClass.getName()) || "io.quarkus.bootstrap.runner.RunnerClassLoader"
/*  73 */       .equals(paramClass.getName())) return true;
/*     */     
/*     */     return false;
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
/*     */   public static void findClassLoaderOrder(ClassLoader paramClassLoader, ClassLoaderOrder paramClassLoaderOrder, LogNode paramLogNode) {
/*  88 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*  89 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
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
/*     */   public static void findClasspathOrder(ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 107 */     String str = paramClassLoader.getClass().getName();
/* 108 */     if ("io.quarkus.runner.RuntimeClassLoader".equals(str)) {
/* 109 */       findClasspathOrderForRuntimeClassloader(paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode); return;
/* 110 */     }  if ("io.quarkus.bootstrap.classloading.QuarkusClassLoader".equals(str)) {
/* 111 */       findClasspathOrderForQuarkusClassloader(paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode); return;
/* 112 */     }  if ("io.quarkus.bootstrap.runner.RunnerClassLoader".equals(str)) {
/* 113 */       findClasspathOrderForRunnerClassloader(paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void findClasspathOrderForQuarkusClassloader(ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 120 */     for (Iterator<Object> iterator = ((Collection)paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "elements")).iterator(); iterator.hasNext(); ) {
/*     */       Object object;
/* 122 */       String str = (object = iterator.next()).getClass().getName();
/* 123 */       if ("io.quarkus.bootstrap.classloading.JarClassPathElement".equals(str)) {
/* 124 */         paramClasspathOrder.addClasspathEntry(paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "file"), paramClassLoader, paramScanSpec, paramLogNode); continue;
/*     */       } 
/* 126 */       if ("io.quarkus.bootstrap.classloading.DirectoryClassPathElement".equals(str)) {
/* 127 */         paramClasspathOrder.addClasspathEntry(paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "root"), paramClassLoader, paramScanSpec, paramLogNode);
/*     */         
/*     */         continue;
/*     */       } 
/* 131 */       if (object = paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getRoot") instanceof Path) {
/* 132 */         paramClasspathOrder.addClasspathEntry(object, paramClassLoader, paramScanSpec, paramLogNode);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void findClasspathOrderForRuntimeClassloader(ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/*     */     Collection collection;
/* 143 */     if ((collection = (Collection)paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "applicationClassDirectories")) != null) {
/* 144 */       for (Path path : collection) {
/*     */         try {
/* 146 */           URI uRI = path.toUri();
/* 147 */           paramClasspathOrder.addClasspathEntryObject(uRI, paramClassLoader, paramScanSpec, paramLogNode);
/* 148 */         } catch (IOError|SecurityException iOError) {
/* 149 */           if (paramLogNode != null) {
/* 150 */             paramLogNode.log("Could not convert path to URI: " + path);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void findClasspathOrderForRunnerClassloader(ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 160 */     for (Iterator<Object[]> iterator = ((Map)paramClasspathOrder.reflectionUtils
/* 161 */       .getFieldVal(false, paramClassLoader, "resourceDirectoryMap")).values().iterator(); iterator.hasNext();) {
/* 162 */       for (i = (arrayOfObject = arrayOfObject = iterator.next()).length, b = 0; b < i; b++) {
/* 163 */         Object object; String str = (object = arrayOfObject[b]).getClass().getName();
/* 164 */         if ("io.quarkus.bootstrap.runner.JarResource".equals(str))
/* 165 */           paramClasspathOrder.addClasspathEntry(paramClasspathOrder.reflectionUtils
/* 166 */               .getFieldVal(false, object, "jarPath"), paramClassLoader, paramScanSpec, paramLogNode); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\QuarkusClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */