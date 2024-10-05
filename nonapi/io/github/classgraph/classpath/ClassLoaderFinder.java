/*     */ package nonapi.io.github.classgraph.classpath;
/*     */ 
/*     */ import java.util.LinkedHashSet;
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
/*     */ public class ClassLoaderFinder
/*     */ {
/*     */   private final ClassLoader[] contextClassLoaders;
/*     */   
/*     */   public ClassLoader[] getContextClassLoaders() {
/*  50 */     return this.contextClassLoaders;
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
/*     */   ClassLoaderFinder(ScanSpec paramScanSpec, ReflectionUtils paramReflectionUtils, LogNode paramLogNode) {
/*     */     LogNode logNode;
/*     */     LinkedHashSet linkedHashSet;
/*  66 */     if (paramScanSpec.overrideClassLoaders == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  75 */       linkedHashSet = new LinkedHashSet();
/*     */       ClassLoader classLoader1;
/*  77 */       if ((classLoader1 = Thread.currentThread().getContextClassLoader()) != null) {
/*  78 */         linkedHashSet.add(classLoader1);
/*     */       }
/*     */ 
/*     */       
/*     */       ClassLoader classLoader2;
/*     */ 
/*     */       
/*  85 */       if ((classLoader2 = getClass().getClassLoader()) != null) {
/*  86 */         linkedHashSet.add(classLoader2);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  91 */       if ((classLoader1 = ClassLoader.getSystemClassLoader()) != null) {
/*  92 */         linkedHashSet.add(classLoader1);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/*     */         Class[] arrayOfClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 106 */         for (int i = (arrayOfClass = (new CallStackReader(paramReflectionUtils)).getClassContext(paramLogNode)).length - 1; i >= 0; i--) {
/*     */           
/* 108 */           if ((classLoader2 = arrayOfClass[i].getClassLoader()) != null) {
/* 109 */             linkedHashSet.add(classLoader2);
/*     */           }
/*     */         } 
/* 112 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 113 */         if (paramLogNode != null) {
/* 114 */           paramLogNode.log("Could not get call stack", illegalArgumentException);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 119 */       if (paramScanSpec.addedClassLoaders != null) {
/* 120 */         linkedHashSet.addAll(paramScanSpec.addedClassLoaders);
/*     */       }
/* 122 */       logNode = (paramLogNode == null) ? null : paramLogNode.log("Found ClassLoaders:");
/*     */     }
/*     */     else {
/*     */       
/* 126 */       linkedHashSet = new LinkedHashSet(((ScanSpec)logNode).overrideClassLoaders);
/* 127 */       logNode = (paramLogNode == null) ? null : paramLogNode.log("Override ClassLoaders:");
/*     */     } 
/*     */ 
/*     */     
/* 131 */     if (logNode != null) {
/* 132 */       for (ClassLoader classLoader : linkedHashSet) {
/* 133 */         logNode.log(classLoader.getClass().getName());
/*     */       }
/*     */     }
/*     */     
/* 137 */     this.contextClassLoaders = (ClassLoader[])linkedHashSet.toArray((Object[])new ClassLoader[0]);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classpath\ClassLoaderFinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */