/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.security.ProtectionDomain;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.JarUtils;
/*     */ import nonapi.io.github.classgraph.utils.VersionFinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassGraphClassLoader
/*     */   extends ClassLoader
/*     */ {
/*     */   private final ScanResult scanResult;
/*     */   private final boolean initializeLoadedClasses;
/*     */   private Set<ClassLoader> environmentClassLoaderDelegationOrder;
/*     */   private List<ClassLoader> overrideClassLoaders;
/*     */   private final ClassLoader classpathClassLoader;
/*     */   private Set<ClassLoader> addedClassLoaderDelegationOrder;
/*     */   
/*     */   ClassGraphClassLoader(ScanResult paramScanResult) {
/*  76 */     super(null);
/*  77 */     registerAsParallelCapable();
/*     */     
/*  79 */     this.scanResult = paramScanResult;
/*  80 */     ScanSpec scanSpec = paramScanResult.scanSpec;
/*  81 */     this.initializeLoadedClasses = scanSpec.initializeLoadedClasses;
/*     */ 
/*     */     
/*  84 */     boolean bool1 = (scanSpec.overrideClasspath != null && !scanSpec.overrideClasspath.isEmpty()) ? true : false;
/*     */     
/*  86 */     boolean bool2 = (scanSpec.overrideClassLoaders != null && !scanSpec.overrideClassLoaders.isEmpty()) ? true : false;
/*     */     
/*  88 */     boolean bool3 = (scanSpec.addedClassLoaders != null && !scanSpec.addedClassLoaders.isEmpty()) ? true : false;
/*     */ 
/*     */     
/*  91 */     if (!bool1 && !bool2) {
/*     */ 
/*     */       
/*  94 */       this.environmentClassLoaderDelegationOrder = new LinkedHashSet<>();
/*  95 */       this.environmentClassLoaderDelegationOrder.add(null);
/*     */       
/*     */       ClassLoader[] arrayOfClassLoader;
/*     */       
/*  99 */       if ((arrayOfClassLoader = paramScanResult.getClassLoaderOrderRespectingParentDelegation()) != null)
/*     */       {
/* 101 */         this.environmentClassLoaderDelegationOrder.addAll(Arrays.asList(arrayOfClassLoader));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 106 */     List<URL> list = paramScanResult.getClasspathURLs();
/* 107 */     this
/* 108 */       .classpathClassLoader = list.isEmpty() ? null : new URLClassLoader(list.<URL>toArray(new URL[0]));
/*     */ 
/*     */ 
/*     */     
/* 112 */     this.overrideClassLoaders = bool2 ? scanSpec.overrideClassLoaders : null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 119 */     if (this.overrideClassLoaders == null && bool1 && this.classpathClassLoader != null) {
/* 120 */       this.overrideClassLoaders = Collections.singletonList(this.classpathClassLoader);
/*     */     }
/*     */ 
/*     */     
/* 124 */     if (bool3) {
/* 125 */       this.addedClassLoaderDelegationOrder = new LinkedHashSet<>();
/* 126 */       this.addedClassLoaderDelegationOrder.addAll(scanSpec.addedClassLoaders);
/*     */       
/* 128 */       if (this.environmentClassLoaderDelegationOrder != null) {
/* 129 */         this.addedClassLoaderDelegationOrder.removeAll(this.environmentClassLoaderDelegationOrder);
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
/*     */   protected Class<?> findClass(String paramString) {
/*     */     LinkageError linkageError;
/* 142 */     ClassLoader classLoader = this.scanResult.classpathFinder.getDelegateClassGraphClassLoader();
/* 143 */     ClassGraphClassLoader classGraphClassLoader = null;
/* 144 */     if (classLoader != null) {
/*     */       try {
/* 146 */         return Class.forName(paramString, this.initializeLoadedClasses, classLoader);
/* 147 */       } catch (ClassNotFoundException classNotFoundException) {
/*     */       
/* 149 */       } catch (LinkageError linkageError1) {
/* 150 */         classGraphClassLoader = classLoader = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 155 */     if (this.overrideClassLoaders != null) {
/* 156 */       for (ClassLoader classLoader1 : this.overrideClassLoaders) {
/*     */         try {
/* 158 */           return Class.forName(paramString, this.initializeLoadedClasses, classLoader1);
/* 159 */         } catch (ClassNotFoundException classNotFoundException) {
/*     */         
/* 161 */         } catch (LinkageError linkageError1) {
/* 162 */           if (classGraphClassLoader == null) {
/* 163 */             linkageError = linkageError1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 170 */     if (this.overrideClassLoaders == null && this.environmentClassLoaderDelegationOrder != null && 
/* 171 */       !this.environmentClassLoaderDelegationOrder.isEmpty()) {
/* 172 */       for (ClassLoader classLoader1 : this.environmentClassLoaderDelegationOrder) {
/*     */         try {
/* 174 */           return Class.forName(paramString, this.initializeLoadedClasses, classLoader1);
/* 175 */         } catch (ClassNotFoundException classNotFoundException) {
/*     */         
/* 177 */         } catch (LinkageError linkageError1) {
/* 178 */           if (linkageError == null) {
/* 179 */             linkageError = linkageError1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     classLoader = null;
/*     */     
/*     */     ClassInfo classInfo;
/* 192 */     if ((classInfo = (ClassInfo)((this.scanResult.classNameToClassInfo == null) ? null : this.scanResult.classNameToClassInfo.get(paramString))) != null) {
/*     */ 
/*     */ 
/*     */       
/* 196 */       if ((classLoader = classInfo.classLoader) != null && (this.environmentClassLoaderDelegationOrder == null || 
/* 197 */         !this.environmentClassLoaderDelegationOrder.contains(classLoader))) {
/*     */         try {
/* 199 */           return Class.forName(paramString, this.initializeLoadedClasses, classLoader);
/* 200 */         } catch (ClassNotFoundException classNotFoundException) {
/*     */         
/* 202 */         } catch (LinkageError linkageError1) {
/* 203 */           if (linkageError == null) {
/* 204 */             linkageError = linkageError1;
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 214 */       if (classInfo.classpathElement instanceof ClasspathElementModule && !classInfo.isPublic()) {
/* 215 */         throw new ClassNotFoundException("Classfile for class " + paramString + " was found in a module, but the context and system classloaders could not load the class, probably because the class is not public.");
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 222 */     if (this.overrideClassLoaders == null && this.classpathClassLoader != null) {
/*     */       try {
/* 224 */         return Class.forName(paramString, this.initializeLoadedClasses, this.classpathClassLoader);
/* 225 */       } catch (ClassNotFoundException classNotFoundException) {
/*     */       
/* 227 */       } catch (LinkageError linkageError1) {
/* 228 */         if (linkageError == null) {
/* 229 */           linkageError = linkageError1;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 235 */     if (this.addedClassLoaderDelegationOrder != null && !this.addedClassLoaderDelegationOrder.isEmpty()) {
/* 236 */       for (Iterator<ClassLoader> iterator = this.addedClassLoaderDelegationOrder.iterator(); iterator.hasNext();) {
/* 237 */         if ((classLoader1 = iterator.next()) != classLoader) {
/*     */           try {
/* 239 */             return Class.forName(paramString, this.initializeLoadedClasses, classLoader1);
/* 240 */           } catch (ClassNotFoundException classNotFoundException) {
/*     */           
/* 242 */           } catch (LinkageError linkageError1) {
/* 243 */             if (linkageError == null) {
/* 244 */               linkageError = linkageError1;
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ResourceList resourceList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 262 */     if ((resourceList = this.scanResult.getResourcesWithPath(JarUtils.classNameToClassfilePath(paramString))) != null) {
/* 263 */       for (Resource resource : resourceList) {
/*     */ 
/*     */         
/* 266 */         try { Resource resource2, resource1 = resource; resourceList = null;
/*     */ 
/*     */ 
/*     */           
/* 270 */           try { return defineClass(paramString, resource1.read(), (ProtectionDomain)null); } catch (Throwable throwable1) { resource2 = resource = null; throw resource; }
/* 271 */           finally { if (throwable != null) if (resource2 != null) { try { throwable.close(); } catch (Throwable throwable1) { resource2.addSuppressed(throwable1); }  } else { throwable1.close(); }   }  } catch (IOException iOException)
/* 272 */         { throw new ClassNotFoundException("Could not load classfile for class " + paramString + " : " + iOException); }
/* 273 */         catch (LinkageError linkageError1)
/* 274 */         { if (linkageError == null) {
/* 275 */             linkageError = linkageError1;
/*     */           } }
/*     */       
/*     */       } 
/*     */     }
/*     */     
/* 281 */     if (linkageError != null) {
/* 282 */       if (VersionFinder.OS == VersionFinder.OperatingSystem.Windows) {
/*     */         String str;
/*     */ 
/*     */ 
/*     */         
/* 287 */         if ((str = linkageError.getMessage()) != null) {
/*     */           int i;
/*     */           
/* 290 */           if ((i = str.indexOf("(wrong name: ")) >= 0) {
/*     */             String str1;
/*     */             
/* 293 */             if ((str1 = str.substring(i + 13, str.length() - 1)).replace('/', '.').equalsIgnoreCase(paramString)) {
/* 294 */               throw new LinkageError("You appear to have two classfiles with the same case-insensitive name in the same directory on a case-insensitive filesystem -- this is not allowed on Windows, and therefore your code is not portable. Class name: " + paramString, linkageError);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 302 */       throw linkageError;
/*     */     } 
/*     */     
/* 305 */     throw new ClassNotFoundException("Could not find or load classfile for class " + paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URL[] getURLs() {
/* 314 */     return this.scanResult.getClasspathURLs().<URL>toArray(new URL[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URL getResource(String paramString) {
/* 325 */     if (!this.environmentClassLoaderDelegationOrder.isEmpty()) {
/* 326 */       for (Iterator<ClassLoader> iterator = this.environmentClassLoaderDelegationOrder.iterator(); iterator.hasNext();) {
/*     */         
/* 328 */         if ((uRL = (classLoader = iterator.next()).getResource(paramString)) != null) {
/* 329 */           return uRL;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 335 */     if (!this.addedClassLoaderDelegationOrder.isEmpty()) {
/* 336 */       for (Iterator<ClassLoader> iterator = this.addedClassLoaderDelegationOrder.iterator(); iterator.hasNext();) {
/*     */         
/* 338 */         if ((uRL = (classLoader = iterator.next()).getResource(paramString)) != null) {
/* 339 */           return uRL;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     ResourceList resourceList;
/*     */     
/* 347 */     if ((resourceList = this.scanResult.getResourcesWithPath(paramString)) == null || resourceList.isEmpty()) {
/* 348 */       return super.getResource(paramString);
/*     */     }
/* 350 */     return resourceList.get(0).getURL();
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
/*     */   public Enumeration<URL> getResources(String paramString) {
/* 362 */     if (!this.environmentClassLoaderDelegationOrder.isEmpty()) {
/* 363 */       for (Iterator<ClassLoader> iterator = this.environmentClassLoaderDelegationOrder.iterator(); iterator.hasNext();) {
/*     */         
/* 365 */         if ((enumeration = (classLoader = iterator.next()).getResources(paramString)) != null && enumeration.hasMoreElements()) {
/* 366 */           return enumeration;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 372 */     if (!this.addedClassLoaderDelegationOrder.isEmpty()) {
/* 373 */       for (Iterator<ClassLoader> iterator = this.addedClassLoaderDelegationOrder.iterator(); iterator.hasNext();) {
/*     */         
/* 375 */         if ((enumeration = (classLoader = iterator.next()).getResources(paramString)) != null && enumeration.hasMoreElements()) {
/* 376 */           return enumeration;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     final ResourceList resourceList;
/*     */     
/* 384 */     if ((resourceList = this.scanResult.getResourcesWithPath(paramString)) == null || resourceList.isEmpty()) {
/* 385 */       return Collections.emptyEnumeration();
/*     */     }
/* 387 */     return new Enumeration<URL>()
/*     */       {
/*     */         int idx;
/*     */ 
/*     */         
/*     */         public boolean hasMoreElements() {
/* 393 */           return (this.idx < resourceList.size());
/*     */         }
/*     */ 
/*     */         
/*     */         public URL nextElement() {
/* 398 */           return resourceList.get(this.idx++).getURL();
/*     */         }
/*     */       };
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
/*     */   public InputStream getResourceAsStream(String paramString) {
/* 412 */     if (!this.environmentClassLoaderDelegationOrder.isEmpty()) {
/* 413 */       for (Iterator<ClassLoader> iterator = this.environmentClassLoaderDelegationOrder.iterator(); iterator.hasNext();) {
/*     */         
/* 415 */         if ((inputStream = (classLoader = iterator.next()).getResourceAsStream(paramString)) != null) {
/* 416 */           return inputStream;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 422 */     if (!this.addedClassLoaderDelegationOrder.isEmpty()) {
/* 423 */       for (Iterator<ClassLoader> iterator = this.addedClassLoaderDelegationOrder.iterator(); iterator.hasNext();) {
/*     */         
/* 425 */         if ((inputStream = (classLoader = iterator.next()).getResourceAsStream(paramString)) != null) {
/* 426 */           return inputStream;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     ResourceList resourceList;
/*     */     
/* 434 */     if ((resourceList = this.scanResult.getResourcesWithPath(paramString)) == null || resourceList.isEmpty()) {
/* 435 */       return super.getResourceAsStream(paramString);
/*     */     }
/*     */     try {
/* 438 */       return resourceList.get(0).open();
/* 439 */     } catch (IOException iOException) {
/* 440 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClassGraphClassLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */