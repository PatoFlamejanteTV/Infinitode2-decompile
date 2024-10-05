/*     */ package nonapi.io.github.classgraph.classloaderhandler;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class WebsphereLibertyClassLoaderHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   private static final String PKG_PREFIX = "com.ibm.ws.classloading.internal.";
/*     */   private static final String IBM_APP_CLASS_LOADER = "com.ibm.ws.classloading.internal.AppClassLoader";
/*     */   private static final String IBM_THREAD_CONTEXT_CLASS_LOADER = "com.ibm.ws.classloading.internal.ThreadContextClassLoader";
/*     */   
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*  78 */     if ("com.ibm.ws.classloading.internal.AppClassLoader".equals(paramClass.getName()) || "com.ibm.ws.classloading.internal.ThreadContextClassLoader"
/*  79 */       .equals(paramClass.getName())) return true;
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
/*  94 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*  95 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
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
/*     */   private static Collection<Object> getPaths(Object paramObject, ReflectionUtils paramReflectionUtils) {
/* 112 */     if (paramObject == null) {
/* 113 */       return Collections.emptyList();
/*     */     }
/*     */ 
/*     */     
/*     */     Collection<Object> collection;
/*     */ 
/*     */     
/* 120 */     if ((collection = callGetUrls(paramObject, "getContainerURLs", paramReflectionUtils)) != null && !collection.isEmpty()) {
/* 121 */       return collection;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 126 */     if ((paramObject = paramReflectionUtils.getFieldVal(false, paramObject, "container")) == null) {
/* 127 */       return Collections.emptyList();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     if ((collection = callGetUrls(paramObject, "getURLs", paramReflectionUtils)) != null && !collection.isEmpty()) {
/* 134 */       return collection;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 139 */     if ((paramObject = paramReflectionUtils.getFieldVal(false, paramObject, "delegate")) == null) {
/* 140 */       return Collections.emptyList();
/*     */     }
/*     */     
/*     */     String str;
/* 144 */     if ((str = (String)paramReflectionUtils.getFieldVal(false, paramObject, "path")) != null && str.length() > 0) {
/* 145 */       return Collections.singletonList(str);
/*     */     }
/*     */ 
/*     */     
/* 149 */     if ((paramObject = paramReflectionUtils.getFieldVal(false, paramObject, "base")) == null)
/*     */     {
/* 151 */       return Collections.emptyList();
/*     */     }
/*     */ 
/*     */     
/* 155 */     if ((paramObject = paramReflectionUtils.getFieldVal(false, paramObject, "archiveFile")) != null)
/*     */     {
/* 157 */       return Collections.singletonList((paramObject = paramObject).getAbsolutePath());
/*     */     }
/* 159 */     return Collections.emptyList();
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
/*     */   private static Collection<Object> callGetUrls(Object paramObject, String paramString, ReflectionUtils paramReflectionUtils) {
/* 176 */     if (paramObject != null) {
/*     */       
/*     */       try {
/*     */         
/* 180 */         if ((paramObject = paramReflectionUtils.invokeMethod(false, paramObject, paramString)) != null && !paramObject.isEmpty()) {
/* 181 */           HashSet<Iterator<Object>> hashSet = new HashSet();
/* 182 */           for (paramObject = paramObject.iterator(); paramObject.hasNext(); ) {
/* 183 */             Iterator<Object> iterator; if (paramReflectionUtils = paramObject.next() instanceof Collection) {
/*     */               
/* 185 */               for (iterator = ((Collection)paramReflectionUtils).iterator(); iterator.hasNext();) {
/* 186 */                 if ((object = iterator.next()) != null)
/* 187 */                   hashSet.add(object); 
/*     */               }  continue;
/*     */             } 
/* 190 */             if (iterator != null) {
/* 191 */               hashSet.add(iterator);
/*     */             }
/*     */           } 
/* 194 */           return (Collection)hashSet;
/*     */         } 
/* 196 */       } catch (UnsupportedOperationException unsupportedOperationException) {}
/*     */     }
/*     */ 
/*     */     
/* 200 */     return Collections.emptyList();
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
/*     */     Object<Object> object;
/* 219 */     if ((object = (Object<Object>)paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "appLoader")) != null) {
/* 220 */       object = (Object<Object>)paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "smartClassPath");
/*     */     } else {
/* 222 */       object = (Object<Object>)paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "smartClassPath");
/*     */     } 
/* 224 */     if (object != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 229 */       if (!(collection = callGetUrls(object, "getClassPath", paramClasspathOrder.reflectionUtils)).isEmpty()) {
/* 230 */         for (Collection<Object> collection : collection) {
/* 231 */           paramClasspathOrder.addClasspathEntry(collection, paramClassLoader, paramScanSpec, paramLogNode);
/*     */         }
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 238 */       if ((object = (Object<Object>)paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "classPath")) != null && !object.isEmpty())
/* 239 */         for (Iterator iterator = object.iterator(); iterator.hasNext();) {
/*     */ 
/*     */           
/* 242 */           for (Object object1 : object = (Object<Object>)getPaths(object = (Object<Object>)iterator.next(), paramClasspathOrder.reflectionUtils))
/* 243 */             paramClasspathOrder.addClasspathEntry(object1, paramClassLoader, paramScanSpec, paramLogNode); 
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\WebsphereLibertyClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */