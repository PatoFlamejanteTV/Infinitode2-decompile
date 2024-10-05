/*     */ package nonapi.io.github.classgraph.classloaderhandler;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ class EquinoxClassLoaderHandler
/*     */   implements ClassLoaderHandler
/*     */ {
/*     */   private static boolean alreadyReadSystemBundles;
/*  51 */   private static final String[] FIELD_NAMES = new String[] { "cp", "nestedDirName" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean canHandle(Class<?> paramClass, LogNode paramLogNode) {
/*  67 */     return "org.eclipse.osgi.internal.loader.EquinoxClassLoader".equals(paramClass.getName());
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
/*  82 */     paramClassLoaderOrder.delegateTo(paramClassLoader.getParent(), true, paramLogNode);
/*  83 */     paramClassLoaderOrder.add(paramClassLoader, paramLogNode);
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
/*     */   private static void addBundleFile(Object paramObject, Set<Object> paramSet, ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 106 */     if (paramObject != null && paramSet.add(paramObject)) {
/*     */       Object object;
/*     */       
/* 109 */       if ((object = paramClasspathOrder.reflectionUtils.getFieldVal(false, paramObject, "basefile")) != null) {
/* 110 */         boolean bool = false; String[] arrayOfString; int i; byte b;
/* 111 */         for (i = (arrayOfString = FIELD_NAMES).length, b = 0; b < i; ) { String str1, str2 = arrayOfString[b];
/*     */           
/*     */           Object object1;
/* 114 */           if ((object1 = paramClasspathOrder.reflectionUtils.getFieldVal(false, paramObject, str2)) != null) {
/* 115 */             bool = true;
/*     */             
/* 117 */             Object object2 = object;
/* 118 */             String str = "/";
/* 119 */             if (paramObject.getClass().getName()
/* 120 */               .equals("org.eclipse.osgi.storage.bundlefile.NestedDirBundleFile")) {
/*     */               Object object3;
/*     */ 
/*     */               
/* 124 */               if ((object3 = paramClasspathOrder.reflectionUtils.getFieldVal(false, paramObject, "baseBundleFile")) != null && object3.getClass().getName()
/* 125 */                 .equals("org.eclipse.osgi.storage.bundlefile.ZipBundleFile")) {
/* 126 */                 object2 = object3;
/* 127 */                 str = "!/";
/*     */               } 
/*     */             } 
/* 130 */             str1 = object2 + str + object1;
/* 131 */             paramClasspathOrder.addClasspathEntry(str1, paramClassLoader, paramScanSpec, paramLogNode); break;
/*     */           } 
/*     */           str1++; }
/*     */         
/* 135 */         if (!bool)
/*     */         {
/* 137 */           paramClasspathOrder.addClasspathEntry(object.toString(), paramClassLoader, paramScanSpec, paramLogNode);
/*     */         }
/*     */       } 
/*     */       
/* 141 */       addBundleFile(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramObject, "wrapped"), paramSet, paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode);
/*     */       
/* 143 */       addBundleFile(paramClasspathOrder.reflectionUtils.getFieldVal(false, paramObject, "next"), paramSet, paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode);
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
/*     */   private static void addClasspathEntries(Object paramObject, ClassLoader paramClassLoader, ClasspathOrder paramClasspathOrder, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 166 */     if ((paramObject = paramClasspathOrder.reflectionUtils.getFieldVal(false, paramObject, "entries")) != null) {
/* 167 */       byte b; int i; for (b = 0, i = Array.getLength(paramObject); b < i; b++) {
/*     */         
/* 169 */         Object object = Array.get(paramObject, b);
/*     */ 
/*     */         
/* 172 */         addBundleFile(object = paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "bundlefile"), new HashSet(), paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode);
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
/*     */     Object object;
/* 193 */     addClasspathEntries(object = paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "manager"), paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode);
/*     */ 
/*     */ 
/*     */     
/* 197 */     if ((object = paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "fragments")) != null) {
/* 198 */       byte b; int i; for (b = 0, i = Array.getLength(object); b < i; b++) {
/*     */         Object object1;
/*     */         
/* 201 */         addClasspathEntries(object1 = Array.get(object, b), paramClassLoader, paramClasspathOrder, paramScanSpec, paramLogNode);
/*     */       } 
/*     */     } 
/*     */     
/* 205 */     if (!alreadyReadSystemBundles) {
/*     */       
/* 207 */       Object object1 = paramClasspathOrder.reflectionUtils.getFieldVal(false, paramClassLoader, "delegate");
/*     */       
/* 209 */       Object object2 = paramClasspathOrder.reflectionUtils.getFieldVal(false, object1, "container");
/*     */       
/* 211 */       Object object3 = paramClasspathOrder.reflectionUtils.getFieldVal(false, object2, "storage");
/*     */       
/* 213 */       object = paramClasspathOrder.reflectionUtils.getFieldVal(false, object3, "moduleContainer");
/*     */ 
/*     */       
/* 216 */       object = paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "moduleDatabase");
/*     */ 
/*     */       
/* 219 */       object = paramClasspathOrder.reflectionUtils.getFieldVal(false, object, "modulesById");
/*     */ 
/*     */       
/* 222 */       object = paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "get", Object.class, 
/* 223 */           Long.valueOf(0L));
/*     */       
/* 225 */       object = paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getBundle");
/*     */       
/* 227 */       object = paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getBundleContext");
/*     */ 
/*     */ 
/*     */       
/* 231 */       if ((object = paramClasspathOrder.reflectionUtils.invokeMethod(false, object, "getBundles")) != null) {
/* 232 */         byte b; int i; for (b = 0, i = Array.getLength(object); b < i; b++) {
/*     */           
/* 234 */           object3 = Array.get(object, b);
/*     */           
/* 236 */           object3 = paramClasspathOrder.reflectionUtils.getFieldVal(false, object3, "module");
/*     */ 
/*     */           
/*     */           int j;
/*     */           
/* 241 */           if ((object3 = paramClasspathOrder.reflectionUtils.getFieldVal(false, object3, "location")) != null && (
/*     */             
/* 243 */             j = object3.indexOf("file:")) >= 0) {
/* 244 */             object3 = object3.substring(j);
/* 245 */             paramClasspathOrder.addClasspathEntry(object3, paramClassLoader, paramScanSpec, paramLogNode);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 250 */       alreadyReadSystemBundles = true;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classloaderhandler\EquinoxClassLoaderHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */