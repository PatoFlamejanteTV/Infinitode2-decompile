/*     */ package nonapi.io.github.classgraph.classloaderhandler;
/*     */ 
/*     */ import io.github.classgraph.ClassGraphClassLoader;
/*     */ import java.net.URL;
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
/*     */ class ClassGraphClassLoaderHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*     */     boolean bool;
/*  59 */     if ((bool = "io.github.classgraph.ClassGraphClassLoader".equals(paramClass.getName())) && paramLogNode != null) {
/*  60 */       paramLogNode.log("Sharing a `ClassGraphClassLoader` between multiple nested scans is not advisable, because scan criteria may differ between scans. See: https://github.com/classgraph/classgraph/issues/485");
/*     */     }
/*     */ 
/*     */     
/*  64 */     return bool;
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
/*  79 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*  80 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
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
/*     */   public static void findClasspathOrder(ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/*     */     URL[] arrayOfURL;
/*     */     int i;
/*     */     byte b;
/* 102 */     for (i = (arrayOfURL = ((ClassGraphClassLoader)paramClassLoader).getURLs()).length, b = 0; b < i; b++) {
/* 103 */       URL uRL; if ((uRL = arrayOfURL[b]) != null)
/* 104 */         paramClasspathOrder.addClasspathEntry(uRL, paramClassLoader, paramScanSpec, paramLogNode); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\ClassGraphClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */