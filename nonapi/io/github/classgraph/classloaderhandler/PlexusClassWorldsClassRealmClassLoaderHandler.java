/*     */ package nonapi.io.github.classgraph.classloaderhandler;
/*     */ 
/*     */ import nonapi.io.github.classgraph.classpath.ClassLoaderOrder;
/*     */ import nonapi.io.github.classgraph.classpath.ClasspathOrder;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
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
/*     */ class PlexusClassWorldsClassRealmClassLoaderHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*  59 */     return "org.codehaus.plexus.classworlds.realm.ClassRealm".equals(paramClass.getName());
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
/*     */   private static boolean isParentFirstStrategy(ClassLoader paramClassLoader, ReflectionUtils paramReflectionUtils) {
/*     */     Object object;
/*  72 */     if ((object = paramReflectionUtils.getFieldVal(false, paramClassLoader, "strategy")) != null && ((
/*     */       
/*  74 */       object = object.getClass().getName()).equals("org.codehaus.plexus.classworlds.strategy.SelfFirstStrategy") || object
/*  75 */       .equals("org.codehaus.plexus.classworlds.strategy.OsgiBundleStrategy")))
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  81 */     return true;
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
/*     */   public static void findClassLoaderOrder(ClassLoader paramClassLoader, ClassLoaderOrder paramClassLoaderOrder, LogNode paramLogNode) {
/*  99 */     if ((object = paramClassLoaderOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "foreignImports")) != null)
/*     */     {
/*     */       
/* 102 */       for (Object object : object = object) {
/*     */         
/* 104 */         object = paramClassLoaderOrder.reflectionUtils.invokeMethod(false, object, "getClassLoader");
/*     */         
/* 106 */         paramClassLoaderOrder.delegateTo((ClassLoader)object, true, paramLogNode);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     boolean bool;
/*     */ 
/*     */     
/* 114 */     if (!(bool = isParentFirstStrategy(paramClassLoader, paramClassLoaderOrder.reflectionUtils)))
/*     */     {
/* 116 */       paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     ClassLoader classLoader = (ClassLoader)paramClassLoaderOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getParentClassLoader");
/*     */     
/* 124 */     paramClassLoaderOrder.delegateTo(classLoader, true, paramLogNode);
/* 125 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*     */ 
/*     */     
/* 128 */     if (bool)
/*     */     {
/* 130 */       paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void findClasspathOrder(ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 149 */     URLClassLoaderHandler.findClasspathOrder(paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\PlexusClassWorldsClassRealmClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */