/*     */ package nonapi.io.github.classgraph.classpath;
/*     */ 
/*     */ import io.github.classgraph.ClassGraphClassLoader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.FastPathResolver;
/*     */ import nonapi.io.github.classgraph.utils.FileUtils;
/*     */ import nonapi.io.github.classgraph.utils.JarUtils;
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
/*     */ public class ClasspathFinder
/*     */ {
/*     */   private final ClasspathOrder classpathOrder;
/*     */   private final ModuleFinder moduleFinder;
/*     */   private ClassLoader[] classLoaderOrderRespectingParentDelegation;
/*     */   private ClassGraphClassLoader delegateClassGraphClassLoader;
/*     */   
/*     */   public ClasspathOrder getClasspathOrder() {
/*  75 */     return this.classpathOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModuleFinder getModuleFinder() {
/*  84 */     return this.moduleFinder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassLoader[] getClassLoaderOrderRespectingParentDelegation() {
/*  93 */     return this.classLoaderOrderRespectingParentDelegation;
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
/*     */   public ClassGraphClassLoader getDelegateClassGraphClassLoader() {
/* 105 */     return this.delegateClassGraphClassLoader;
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
/*     */   public ClasspathFinder(ScanSpec paramScanSpec, ReflectionUtils paramReflectionUtils, LogNode paramLogNode) {
/*     */     boolean bool1;
/* 119 */     paramLogNode = (paramLogNode == null) ? null : paramLogNode.log("Finding classpath and modules");
/*     */ 
/*     */     
/* 122 */     boolean bool = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     if (paramScanSpec.overrideClasspath != null) {
/*     */       
/* 129 */       bool1 = false;
/* 130 */     } else if (paramScanSpec.overrideClassLoaders != null) {
/*     */ 
/*     */       
/* 133 */       bool1 = false;
/* 134 */       for (Iterator<ClassLoader> iterator = paramScanSpec.overrideClassLoaders.iterator(); iterator.hasNext(); ) {
/* 135 */         ClassLoader classLoader1; String str = (classLoader1 = iterator.next()).getClass().getName();
/*     */ 
/*     */ 
/*     */         
/* 139 */         if (!paramScanSpec.enableSystemJarsAndModules && str
/* 140 */           .equals("jdk.internal.loader.ClassLoaders$PlatformClassLoader")) {
/* 141 */           if (paramLogNode != null) {
/* 142 */             paramLogNode
/* 143 */               .log("overrideClassLoaders() was called with an instance of " + str + ", so enableSystemJarsAndModules() was called automatically");
/*     */           }
/*     */           
/* 146 */           paramScanSpec.enableSystemJarsAndModules = true;
/*     */         } 
/* 148 */         if (str.equals("jdk.internal.loader.ClassLoaders$AppClassLoader") || str
/* 149 */           .equals("jdk.internal.loader.ClassLoaders$PlatformClassLoader")) {
/* 150 */           if (paramLogNode != null) {
/* 151 */             paramLogNode
/* 152 */               .log("overrideClassLoaders() was called with an instance of " + str + ", so the `java.class.path` classpath will also be scanned");
/*     */           }
/*     */           
/* 155 */           bool = true;
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 161 */       bool1 = paramScanSpec.scanModules;
/*     */     } 
/*     */ 
/*     */     
/* 165 */     this
/* 166 */       .moduleFinder = (bool1 || paramScanSpec.enableSystemJarsAndModules) ? new ModuleFinder((new CallStackReader(paramReflectionUtils)).getClassContext(paramLogNode), paramScanSpec, bool1, paramScanSpec.enableSystemJarsAndModules, paramReflectionUtils, paramLogNode) : null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     this.classpathOrder = new ClasspathOrder(paramScanSpec, paramReflectionUtils);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ClassLoaderFinder classLoaderFinder;
/*     */ 
/*     */ 
/*     */     
/* 181 */     ClassLoader arrayOfClassLoader[], classLoader = ((arrayOfClassLoader = ((classLoaderFinder = (ClassLoaderFinder)((paramScanSpec.overrideClasspath == null && paramScanSpec.overrideClassLoaders == null) ? new ClassLoaderFinder(paramScanSpec, paramReflectionUtils, paramLogNode) : null)) == null) ? new ClassLoader[0] : classLoaderFinder.getContextClassLoaders()).length > 0) ? arrayOfClassLoader[0] : null;
/* 182 */     if (paramScanSpec.overrideClasspath != null) {
/*     */       
/* 184 */       if (paramScanSpec.overrideClassLoaders != null && paramLogNode != null) {
/* 185 */         paramLogNode.log("It is not possible to override both the classpath and the ClassLoaders -- ignoring the ClassLoader override");
/*     */       }
/*     */ 
/*     */       
/* 189 */       LogNode logNode = (paramLogNode == null) ? null : paramLogNode.log("Overriding classpath with: " + paramScanSpec.overrideClasspath);
/* 190 */       this.classpathOrder.addClasspathEntries(paramScanSpec.overrideClasspath, classLoader, paramScanSpec, logNode);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 195 */       if (logNode != null) {
/* 196 */         logNode.log("WARNING: when the classpath is overridden, there is no guarantee that the classes found by classpath scanning will be the same as the classes loaded by the context classloader");
/*     */       }
/*     */ 
/*     */       
/* 200 */       this.classLoaderOrderRespectingParentDelegation = arrayOfClassLoader;
/*     */     } 
/*     */ 
/*     */     
/* 204 */     if (paramScanSpec.enableSystemJarsAndModules) {
/* 205 */       String str = SystemJarFinder.getJreRtJarPath();
/*     */ 
/*     */ 
/*     */       
/* 209 */       LogNode logNode = (paramLogNode == null) ? null : paramLogNode.log("System jars:");
/* 210 */       if (str != null) {
/* 211 */         if (paramScanSpec.enableSystemJarsAndModules) {
/* 212 */           this.classpathOrder.addSystemClasspathEntry(str, classLoader);
/* 213 */           if (logNode != null) {
/* 214 */             logNode.log("Found rt.jar: " + str);
/*     */           }
/* 216 */         } else if (logNode != null) {
/* 217 */           logNode.log((paramScanSpec.enableSystemJarsAndModules ? "" : "Scanning disabled for rt.jar: ") + str);
/*     */         } 
/*     */       }
/*     */       
/* 221 */       boolean bool2 = !paramScanSpec.libOrExtJarAcceptReject.acceptAndRejectAreEmpty() ? true : false;
/* 222 */       for (String str1 : SystemJarFinder.getJreLibOrExtJars()) {
/* 223 */         if (bool2 || paramScanSpec.libOrExtJarAcceptReject
/* 224 */           .isSpecificallyAcceptedAndNotRejected(str1)) {
/* 225 */           this.classpathOrder.addSystemClasspathEntry(str1, classLoader);
/* 226 */           if (logNode != null)
/* 227 */             logNode.log("Found lib or ext jar: " + str1);  continue;
/*     */         } 
/* 229 */         if (logNode != null) {
/* 230 */           logNode.log("Scanning disabled for lib or ext jar: " + str1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 235 */     if (paramScanSpec.overrideClasspath == null) {
/*     */       
/* 237 */       if (paramLogNode != null) {
/* 238 */         LogNode logNode = paramLogNode.log("ClassLoaderHandlers:");
/*     */         
/* 240 */         for (ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry classLoaderHandlerRegistryEntry : ClassLoaderHandlerRegistry.CLASS_LOADER_HANDLERS) {
/* 241 */           logNode.log(classLoaderHandlerRegistryEntry.classLoaderHandlerClass.getName());
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 247 */       LogNode logNode1 = (paramLogNode == null) ? null : paramLogNode.log("Finding unique classloaders in delegation order");
/* 248 */       ClassLoaderOrder classLoaderOrder = new ClassLoaderOrder(paramReflectionUtils);
/*     */       
/*     */       ClassLoader[] arrayOfClassLoader1;
/*     */       
/* 252 */       if ((arrayOfClassLoader1 = (ClassLoader[])((paramScanSpec.overrideClassLoaders != null) ? paramScanSpec.overrideClassLoaders.toArray((Object[])new ClassLoader[0]) : arrayOfClassLoader)) != null) {
/* 253 */         byte b; ClassLoader[] arrayOfClassLoader2; int i; for (i = (arrayOfClassLoader2 = arrayOfClassLoader1).length, b = 0; b < i; ) { ClassLoader classLoader1 = arrayOfClassLoader2[b];
/* 254 */           classLoaderOrder.delegateTo(classLoader1, false, logNode1);
/*     */           
/*     */           b++; }
/*     */       
/*     */       } 
/* 259 */       Set<ClassLoader> set = classLoaderOrder.getAllParentClassLoaders();
/*     */ 
/*     */ 
/*     */       
/* 263 */       LogNode logNode2 = (paramLogNode == null) ? null : paramLogNode.log("Obtaining URLs from classloaders in delegation order");
/* 264 */       ArrayList<ClassLoader> arrayList = new ArrayList();
/* 265 */       for (Iterator<Map.Entry<ClassLoader, ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry>> iterator = classLoaderOrder
/* 266 */         .getClassLoaderOrder().iterator(); iterator.hasNext(); ) {
/* 267 */         Map.Entry<ClassLoader, ?> entry; ClassLoader classLoader1 = (entry = iterator.next()).getKey();
/* 268 */         ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry classLoaderHandlerRegistryEntry = (ClassLoaderHandlerRegistry.ClassLoaderHandlerRegistryEntry)entry.getValue();
/*     */         
/* 270 */         if (!paramScanSpec.ignoreParentClassLoaders || !set.contains(classLoader1)) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 275 */           LogNode logNode = (logNode2 == null) ? null : logNode2.log("Classloader " + classLoader1.getClass().getName() + " is handled by " + classLoaderHandlerRegistryEntry.classLoaderHandlerClass
/* 276 */               .getName());
/* 277 */           classLoaderHandlerRegistryEntry.findClasspathOrder(classLoader1, this.classpathOrder, paramScanSpec, logNode);
/*     */           
/* 279 */           arrayList.add(classLoader1);
/* 280 */         } else if (logNode2 != null) {
/* 281 */           logNode2.log("Ignoring parent classloader " + classLoader1 + ", normally handled by " + classLoaderHandlerRegistryEntry.classLoaderHandlerClass
/* 282 */               .getName());
/*     */         } 
/*     */         
/* 285 */         if (classLoader1 instanceof ClassGraphClassLoader) {
/* 286 */           this.delegateClassGraphClassLoader = (ClassGraphClassLoader)classLoader1;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 292 */       this.classLoaderOrderRespectingParentDelegation = arrayList.<ClassLoader>toArray(new ClassLoader[0]);
/*     */     } 
/*     */ 
/*     */     
/*     */     String[] arrayOfString;
/*     */ 
/*     */     
/* 299 */     if ((bool || (!paramScanSpec.ignoreParentClassLoaders && paramScanSpec.overrideClassLoaders == null && paramScanSpec.overrideClasspath == null) || (this.moduleFinder != null && this.moduleFinder
/*     */ 
/*     */       
/* 302 */       .forceScanJavaClassPath())) && (
/*     */       
/* 304 */       arrayOfString = JarUtils.smartPathSplit(System.getProperty("java.class.path"), paramScanSpec)).length > 0) {
/*     */       
/* 306 */       LogNode logNode = (paramLogNode == null) ? null : paramLogNode.log("Getting classpath entries from java.class.path"); String[] arrayOfString1; int i; byte b;
/* 307 */       for (i = (arrayOfString1 = arrayOfString).length, b = 0; b < i; ) { String str1 = arrayOfString1[b];
/*     */         
/* 309 */         String str2 = FastPathResolver.resolve(FileUtils.currDirPath(), str1);
/*     */         
/* 311 */         this.classpathOrder.addClasspathEntry(str2, classLoader, paramScanSpec, logNode);
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classpath\ClasspathFinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */