/*     */ package nonapi.io.github.classgraph.classloaderhandler;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.lang.reflect.Array;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.classpath.ClassLoaderOrder;
/*     */ import nonapi.io.github.classgraph.classpath.ClasspathOrder;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.FileUtils;
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
/*     */ class JBossClassLoaderHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*  68 */     return "org.jboss.modules.ModuleClassLoader".equals(paramClass.getName());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void handleResourceLoader(Object paramObject, ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/*     */     String str;
/* 103 */     if (paramObject == null) {
/*     */       return;
/*     */     }
/*     */     
/* 107 */     Object object = paramClasspathOrder.reflectionUtils.getFieldVal(false, paramObject, "root");
/*     */ 
/*     */     
/*     */     File file;
/*     */     
/* 112 */     if ((file = (File)paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getPhysicalFile")) != null) {
/*     */       
/* 114 */       if ((object = paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getName")) != null) {
/*     */ 
/*     */         
/* 117 */         if (FileUtils.canRead((File)(object = new File(file.getParentFile(), (String)object)))) {
/* 118 */           str = object.getAbsolutePath();
/*     */         } else {
/*     */           
/* 121 */           str = str.getAbsolutePath();
/*     */         } 
/*     */       } else {
/* 124 */         str = str.getAbsolutePath();
/*     */       }
/*     */     
/*     */     }
/* 128 */     else if ((str = (String)paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getPathName")) == null) {
/*     */ 
/*     */ 
/*     */       
/* 132 */       if ((object = (object instanceof Path) ? ((Path)object).toFile() : ((object instanceof File) ? object : null)) != null) {
/* 133 */         str = object.getAbsolutePath();
/*     */       }
/*     */     } 
/*     */     
/* 137 */     if (str == null && (
/*     */ 
/*     */       
/* 140 */       object = paramClasspathOrder.reflectionUtils.getFieldVal(false, paramObject, "fileOfJar")) != null) {
/* 141 */       str = object.getAbsolutePath();
/*     */     }
/*     */     
/* 144 */     if (str != null) {
/* 145 */       paramClasspathOrder.addClasspathEntry(str, paramClassLoader, paramScanSpec, paramLogNode); return;
/*     */     } 
/* 147 */     if (paramLogNode != null) {
/* 148 */       paramLogNode.log("Could not determine classpath for ResourceLoader: " + paramObject);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void handleRealModule(Object paramObject, Set<Object> paramSet, ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 172 */     if (!paramSet.add(paramObject)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 178 */     if ((paramObject = paramClasspathOrder.reflectionUtils.invokeMethod(false, paramObject, "getClassLoader")) == null) {
/* 179 */       paramObject = paramClassLoader;
/*     */     }
/*     */     
/*     */     Object object;
/*     */     
/* 184 */     if ((object = paramClasspathOrder.reflectionUtils.invokeMethod(false, paramObject, "getResourceLoaders")) != null) {
/* 185 */       byte b; int i; for (b = 0, i = Array.getLength(object); b < i; b++) {
/*     */         Object object1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 193 */         handleResourceLoader(object1 = Array.get(object, b), (ClassLoader)paramObject, paramClasspathOrder, paramScanSpec, paramLogNode);
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
/* 213 */     object = paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getModule");
/* 214 */     Object<?> object1 = (Object<?>)paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getCallerModuleLoader");
/*     */     
/* 216 */     HashSet<Object> hashSet = new HashSet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 222 */     for (object1 = (Object<?>)(object1 = ((object1 = (Object<?>)paramClasspathOrder.reflectionUtils.getFieldVal(false, object1, "moduleMap")) != null) ? (Object<?>)object1.entrySet() : (Object<?>)Collections.emptySet()).iterator(); object1.hasNext(); ) {
/*     */       Map.Entry<?, Object> entry;
/* 224 */       Object object2 = (entry = (Map.Entry<?, Object>)object1.next()).getValue();
/*     */ 
/*     */       
/* 227 */       handleRealModule(object2 = paramClasspathOrder.reflectionUtils.invokeMethod(false, object2, "getModule"), hashSet, paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 233 */     for (Iterator<Map.Entry> iterator = (object1 = (Object<?>)paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getPaths")).entrySet().iterator(); iterator.hasNext();) {
/* 234 */       for (Object object : (entry = iterator.next()).getValue()) {
/*     */         
/* 236 */         object = paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "this$0");
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 241 */         handleRealModule(object = paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "module"), hashSet, paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\JBossClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */