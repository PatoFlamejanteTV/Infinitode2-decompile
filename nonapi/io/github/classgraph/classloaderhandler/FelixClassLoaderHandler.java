/*     */ package nonapi.io.github.classgraph.classloaderhandler;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class FelixClassLoaderHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*  65 */     if ("org.apache.felix.framework.BundleWiringImpl$BundleClassLoaderJava5"
/*  66 */       .equals(paramClass.getName()) || "org.apache.felix.framework.BundleWiringImpl$BundleClassLoader"
/*     */       
/*  68 */       .equals(paramClass.getName())) return true;
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
/*  83 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*  84 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static File getContentLocation(Object paramObject, ReflectionUtils paramReflectionUtils) {
/*  95 */     return (File)paramReflectionUtils.invokeMethod(false, paramObject, "getFile");
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
/*     */   private static void addBundle(Object paramObject, ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, Set<Object> paramSet, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 118 */     paramSet.add(paramObject);
/*     */ 
/*     */     
/* 121 */     paramObject = paramClasspathOrder.reflectionUtils.invokeMethod(false, paramObject, "getRevision");
/*     */     
/*     */     Object object;
/*     */     
/*     */     File file;
/* 126 */     if ((file = (File)(((object = paramClasspathOrder.reflectionUtils.invokeMethod(false, paramObject, "getContent")) != null) ? getContentLocation(object, paramClasspathOrder.reflectionUtils) : null)) != null) {
/*     */       
/* 128 */       paramClasspathOrder.addClasspathEntry(file, paramClassLoader, paramScanSpec, paramLogNode);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       if ((paramObject = paramClasspathOrder.reflectionUtils.invokeMethod(false, paramObject, "getContentPath")) != null) {
/* 134 */         for (paramObject = paramObject.iterator(); paramObject.hasNext();) {
/* 135 */           if ((file = paramObject.next()) != object)
/*     */           {
/*     */ 
/*     */             
/* 139 */             if ((file = (File)((file != null) ? getContentLocation(file, paramClasspathOrder.reflectionUtils) : null)) != null) {
/* 140 */               paramClasspathOrder.addClasspathEntry(file, paramClassLoader, paramScanSpec, paramLogNode);
/*     */             }
/*     */           }
/*     */         } 
/*     */       }
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
/* 163 */     HashSet<Object> hashSet = new HashSet();
/*     */     Object object;
/* 165 */     addBundle(object = paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "m_wiring"), paramClassLoader, paramClasspathOrder, hashSet, paramScanSpec, paramLogNode);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     if ((object = paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getRequiredWires", String.class, null)) != null)
/* 173 */       for (Object object1 : object) {
/* 174 */         object1 = paramClasspathOrder.reflectionUtils.invokeMethod(false, object1, "getProviderWiring");
/*     */         
/* 176 */         if (!hashSet.contains(object1))
/* 177 */           addBundle(object1, paramClassLoader, paramClasspathOrder, hashSet, paramScanSpec, paramLogNode); 
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\FelixClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */