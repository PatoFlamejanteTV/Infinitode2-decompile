/*     */ package nonapi.io.github.classgraph.classloaderhandler;
/*     */ 
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
/*     */ class UnoOneJarClassLoaderHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*  52 */     if ("com.needhamsoftware.unojar.JarClassLoader".equals(paramClass.getName()) || "com.simontuffs.onejar.JarClassLoader"
/*  53 */       .equals(paramClass.getName())) return true;
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
/*  68 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*  69 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
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
/*     */   public static void findClasspathOrder(ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/*  89 */     String str = (String)paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getOneJarPath");
/*     */     
/*  91 */     paramClasspathOrder.addClasspathEntry(str, paramClassLoader, paramScanSpec, paramLogNode);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     str = System.getProperty("uno-jar.jar.path");
/*  97 */     paramClasspathOrder.addClasspathEntry(str, paramClassLoader, paramScanSpec, paramLogNode);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     str = System.getProperty("one-jar.jar.path");
/* 105 */     paramClasspathOrder.addClasspathEntry(str, paramClassLoader, paramScanSpec, paramLogNode);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     if ((str = System.getProperty("one-jar.class.path")) != null)
/* 111 */       paramClasspathOrder.addClasspathEntryObject(str.split("\\|"), paramClassLoader, paramScanSpec, paramLogNode); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\UnoOneJarClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */