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
/*     */ 
/*     */ 
/*     */ 
/*     */ class FallbackClassLoaderHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*  55 */     return true;
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
/*     */   public static void findClassLoaderOrder(ClassLoader paramClassLoader, ClassLoaderOrder paramClassLoaderOrder, LogNode paramLogNode) {
/*  70 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*  71 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
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
/*     */   public static void findClasspathOrder(ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 195 */     int i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = (i = false | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getClassPath"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getClasspath"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "classpath"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "classPath"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "cp"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "classpath"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "classPath"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "cp"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getPath"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getPaths"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "path"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "paths"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "paths"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "paths"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getDir"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getDirs"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "dir"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "dirs"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "dir"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "dirs"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getFile"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getFiles"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "file"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "files"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "file"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "files"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getJar"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getJars"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "jar"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "jars"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "jar"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "jars"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getURL"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getURLs"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getUrl"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getUrls"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "url"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "urls"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "url"), paramClassLoader, paramScanSpec, paramLogNode)) | paramClasspathOrder.addClasspathEntryObject(paramClasspathOrder.reflectionUtils
/* 196 */         .getFieldVal(false, paramClassLoader, "urls"), paramClassLoader, paramScanSpec, paramLogNode);
/* 197 */     if (paramLogNode != null)
/* 198 */       paramLogNode.log("FallbackClassLoaderHandler " + ((i != 0) ? "found" : "did not find") + " classpath entries in unknown ClassLoader " + paramClassLoader); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\FallbackClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */