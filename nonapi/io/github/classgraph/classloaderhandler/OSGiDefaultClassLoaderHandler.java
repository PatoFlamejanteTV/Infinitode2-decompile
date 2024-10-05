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
/*     */ 
/*     */ 
/*     */ 
/*     */ class OSGiDefaultClassLoaderHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*  58 */     return "org.eclipse.osgi.internal.baseadaptor.DefaultClassLoader".equals(paramClass.getName());
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
/*  73 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*  74 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
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
/*     */   public static void findClasspathOrder(ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/*  91 */     Object object = paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getClasspathManager");
/*     */ 
/*     */ 
/*     */     
/*  95 */     if ((object = paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "entries")) != null) {
/*  96 */       int i; byte b; for (i = (object = object).length, b = 0; b < i; ) { Object object1 = object[b];
/*  97 */         object1 = paramClasspathOrder.reflectionUtils.invokeMethod(false, object1, "getBundleFile");
/*     */ 
/*     */ 
/*     */         
/* 101 */         if ((object1 = paramClasspathOrder.reflectionUtils.invokeMethod(false, object1, "getBaseFile")) != null)
/* 102 */           paramClasspathOrder.addClasspathEntry(object1.getPath(), paramClassLoader, paramScanSpec, paramLogNode); 
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\OSGiDefaultClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */