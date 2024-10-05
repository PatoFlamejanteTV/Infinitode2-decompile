/*     */ package nonapi.io.github.classgraph.classloaderhandler;
/*     */ 
/*     */ import java.io.File;
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
/*     */ class TomcatWebappClassLoaderBaseHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*  56 */     return "org.apache.catalina.loader.WebappClassLoaderBase".equals(paramClass.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isParentFirst(ClassLoader paramClassLoader, ReflectionUtils paramReflectionUtils) {
/*     */     Object object;
/*  68 */     if ((object = paramReflectionUtils.getFieldVal(false, paramClassLoader, "delegate")) != null) {
/*  69 */       return ((Boolean)object).booleanValue();
/*     */     }
/*     */     
/*  72 */     return true;
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
/*     */     boolean bool;
/*  88 */     if (bool = isParentFirst(paramClassLoader, paramClassLoaderOrder.reflectionUtils))
/*     */     {
/*  90 */       paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*     */     }
/*  92 */     if ("org.apache.tomee.catalina.TomEEWebappClassLoader".equals(paramClassLoader.getClass().getName())) {
/*     */       
/*     */       try {
/*     */ 
/*     */         
/*  97 */         paramClassLoaderOrder.delegateTo(Class.forName("org.apache.openejb.OpenEJB").getClassLoader(), true, paramLogNode);
/*     */       }
/*  99 */       catch (LinkageError|ClassNotFoundException linkageError) {}
/*     */     }
/*     */ 
/*     */     
/* 103 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
/* 104 */     if (!bool)
/*     */     {
/* 106 */       paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
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
/* 125 */     Object object = paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getResources");
/*     */     
/* 127 */     Object<?> object1 = (Object<?>)paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getBaseUrls");
/* 128 */     paramClasspathOrder.addClasspathEntryObject(object1, paramClassLoader, paramScanSpec, paramLogNode);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     if ((object = paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "allResources")) != null)
/*     */     {
/* 137 */       for (object = object.iterator(); object.hasNext();) {
/*     */ 
/*     */ 
/*     */         
/* 141 */         for (object1 = (Object<?>)(object1 = (Object<?>)object.next()).iterator(); object1.hasNext();) {
/* 142 */           if ((object2 = object1.next()) != null) {
/*     */             File file;
/*     */             
/*     */             String str;
/*     */             
/* 147 */             if ((str = (String)(((file = (File)paramClasspathOrder.reflectionUtils.invokeMethod(false, object2, "getFileBase")) == null) ? null : file.getPath())) == null)
/*     */             {
/* 149 */               str = (String)paramClasspathOrder.reflectionUtils.invokeMethod(false, object2, "getBase");
/*     */             }
/*     */             
/* 152 */             if (str == null)
/*     */             {
/*     */ 
/*     */               
/* 156 */               str = (String)paramClasspathOrder.reflectionUtils.invokeMethod(false, object2, "getBaseUrlString");
/*     */             }
/*     */             
/* 159 */             if (str != null) {
/*     */               String str1;
/*     */ 
/*     */ 
/*     */               
/* 164 */               if ((str1 = (String)paramClasspathOrder.reflectionUtils.getFieldVal(false, object2, "archivePath")) != null && !str1.isEmpty())
/*     */               {
/* 166 */                 str = str + "!" + (str1.startsWith("/") ? str1 : ("/" + str1));
/*     */               }
/*     */ 
/*     */ 
/*     */               
/* 171 */               boolean bool = ((str1 = object2.getClass().getName()).equals("java.org.apache.catalina.webresources.JarResourceSet") || str1.equals("java.org.apache.catalina.webresources.JarWarResourceSet")) ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 176 */               if ((object2 = paramClasspathOrder.reflectionUtils.invokeMethod(false, object2, "getInternalPath")) != null && !object2.isEmpty() && !object2.equals("/")) {
/* 177 */                 paramClasspathOrder.addClasspathEntryObject(str + (bool ? "!" : "") + (
/* 178 */                     object2.startsWith("/") ? object2 : ("/" + object2)), paramClassLoader, paramScanSpec, paramLogNode);
/*     */                 continue;
/*     */               } 
/* 181 */               paramClasspathOrder.addClasspathEntryObject(str, paramClassLoader, paramScanSpec, paramLogNode);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 189 */     object = paramClasspathOrder.reflectionUtils.invokeMethod(false, paramClassLoader, "getURLs");
/* 190 */     paramClasspathOrder.addClasspathEntryObject(object, paramClassLoader, paramScanSpec, paramLogNode);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\TomcatWebappClassLoaderBaseHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */