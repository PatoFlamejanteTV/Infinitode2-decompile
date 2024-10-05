/*    */ package nonapi.io.github.classgraph.classloaderhandler;
/*    */ 
/*    */ import nonapi.io.github.classgraph.classpath.ClassLoaderOrder;
/*    */ import nonapi.io.github.classgraph.classpath.ClasspathOrder;
/*    */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*    */ import nonapi.io.github.classgraph.utils.LogNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ParentLastDelegationOrderTestClassLoaderHandler
/*    */   implements ClassLoaderHandler
/*    */ {
/*    */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/* 52 */     return "io.github.classgraph.issues.issue267.FakeRestartClassLoader".equals(paramClass.getName());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void findClassLoaderOrder(ClassLoader paramClassLoader, ClassLoaderOrder paramClassLoaderOrder, LogNode paramLogNode) {
/* 68 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
/* 69 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void findClasspathOrder(ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 86 */     String str = (String)paramClasspathOrder.reflectionUtils.invokeMethod(true, paramClassLoader, "getClasspath");
/*    */     
/* 88 */     paramClasspathOrder.addClasspathEntry(str, paramClassLoader, paramScanSpec, paramLogNode);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\ParentLastDelegationOrderTestClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */