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
/*    */ class WeblogicClassLoaderHandler
/*    */   implements ClassLoaderHandler
/*    */ {
/*    */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/* 52 */     if ("weblogic.utils.classloaders.ChangeAwareClassLoader".equals(paramClass.getName()) || "weblogic.utils.classloaders.GenericClassLoader"
/* 53 */       .equals(paramClass.getName()) || "weblogic.utils.classloaders.FilteringClassLoader"
/* 54 */       .equals(paramClass.getName()) || "weblogic.servlet.jsp.JspClassLoader"
/*    */ 
/*    */       
/* 57 */       .equals(paramClass.getName()) || "weblogic.servlet.jsp.TagFileClassLoader"
/* 58 */       .equals(paramClass.getName())) return true;
/*    */     
/*    */     return false;
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
/*    */   public static void findClassLoaderOrder(ClassLoader paramClassLoader, ClassLoaderOrder paramClassLoaderOrder, LogNode paramLogNode) {
/* 73 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/* 74 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
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
/* 91 */     paramClasspathOrder.addClasspathPathStr((String)paramClasspathOrder.reflectionUtils
/* 92 */         .invokeMethod(false, paramClassLoader, "getFinderClassPath"), paramClassLoader, paramScanSpec, paramLogNode);
/*    */     
/* 94 */     paramClasspathOrder.addClasspathPathStr((String)paramClasspathOrder.reflectionUtils
/* 95 */         .invokeMethod(false, paramClassLoader, "getClassPath"), paramClassLoader, paramScanSpec, paramLogNode);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\WeblogicClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */