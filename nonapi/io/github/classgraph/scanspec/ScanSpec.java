/*     */ package nonapi.io.github.classgraph.scanspec;
/*     */ 
/*     */ import io.github.classgraph.ModulePathInfo;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
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
/*     */ public class ScanSpec
/*     */ {
/*  59 */   public AcceptReject.AcceptRejectWholeString packageAcceptReject = new AcceptReject.AcceptRejectWholeString('.');
/*     */ 
/*     */   
/*  62 */   public AcceptReject.AcceptRejectPrefix packagePrefixAcceptReject = new AcceptReject.AcceptRejectPrefix('.');
/*     */ 
/*     */   
/*  65 */   public AcceptReject.AcceptRejectWholeString pathAcceptReject = new AcceptReject.AcceptRejectWholeString('/');
/*     */ 
/*     */   
/*  68 */   public AcceptReject.AcceptRejectPrefix pathPrefixAcceptReject = new AcceptReject.AcceptRejectPrefix('/');
/*     */ 
/*     */   
/*  71 */   public AcceptReject.AcceptRejectWholeString classAcceptReject = new AcceptReject.AcceptRejectWholeString('.');
/*     */ 
/*     */   
/*  74 */   public AcceptReject.AcceptRejectWholeString classfilePathAcceptReject = new AcceptReject.AcceptRejectWholeString('/');
/*     */ 
/*     */   
/*  77 */   public AcceptReject.AcceptRejectWholeString classPackageAcceptReject = new AcceptReject.AcceptRejectWholeString('.');
/*     */ 
/*     */   
/*  80 */   public AcceptReject.AcceptRejectWholeString classPackagePathAcceptReject = new AcceptReject.AcceptRejectWholeString('/');
/*     */ 
/*     */   
/*  83 */   public AcceptReject.AcceptRejectWholeString moduleAcceptReject = new AcceptReject.AcceptRejectWholeString('.');
/*     */ 
/*     */   
/*  86 */   public AcceptReject.AcceptRejectLeafname jarAcceptReject = new AcceptReject.AcceptRejectLeafname('/');
/*     */ 
/*     */   
/*  89 */   public AcceptReject.AcceptRejectWholeString classpathElementResourcePathAcceptReject = new AcceptReject.AcceptRejectWholeString('/');
/*     */ 
/*     */ 
/*     */   
/*  93 */   public AcceptReject.AcceptRejectLeafname libOrExtJarAcceptReject = new AcceptReject.AcceptRejectLeafname('/');
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean scanJars = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean scanNestedJars = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean scanDirs = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean scanModules = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enableClassInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enableFieldInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enableMethodInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enableAnnotationInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enableStaticFinalFieldConstantInitializerValues;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enableInterClassDependencies;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enableExternalClasses;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enableSystemJarsAndModules;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ignoreClassVisibility;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ignoreFieldVisibility;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ignoreMethodVisibility;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean disableRuntimeInvisibleAnnotations;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean extendScanningUpwardsToExternalClasses = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> allowedURLSchemes;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public transient List<ClassLoader> addedClassLoaders;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public transient List<ClassLoader> overrideClassLoaders;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public transient List<Object> addedModuleLayers;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public transient List<Object> overrideModuleLayers;
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Object> overrideClasspath;
/*     */ 
/*     */ 
/*     */   
/*     */   public transient List<Object> classpathElementFilters;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean initializeLoadedClasses;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeTemporaryFilesAfterScan;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ignoreParentClassLoaders;
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ignoreParentModuleLayers;
/*     */ 
/*     */ 
/*     */   
/* 231 */   public ModulePathInfo modulePathInfo = new ModulePathInfo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 256 */   public int maxBufferedJarRAMSize = 67108864;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enableMemoryMapping;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enableMultiReleaseVersions;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sortPrefixes() {
/*     */     Field[] arrayOfField;
/*     */     int i;
/*     */     byte b;
/* 275 */     for (i = (arrayOfField = ScanSpec.class.getDeclaredFields()).length, b = 0; b < i; ) { Field field = arrayOfField[b];
/* 276 */       if (AcceptReject.class.isAssignableFrom(field.getType())) {
/*     */         try {
/* 278 */           ((AcceptReject)field.get(this)).sortPrefixes();
/* 279 */         } catch (ReflectiveOperationException reflectiveOperationException) {
/* 280 */           throw new RuntimeException("Field is not accessible: " + field, reflectiveOperationException);
/*     */         } 
/*     */       }
/*     */       b++; }
/*     */   
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
/*     */   public void addClasspathOverride(Object paramObject) {
/* 298 */     if (this.overrideClasspath == null) {
/* 299 */       this.overrideClasspath = new ArrayList();
/*     */     }
/* 301 */     if (paramObject instanceof ClassLoader) {
/* 302 */       throw new IllegalArgumentException("Need to pass ClassLoader instances to overrideClassLoaders, not overrideClasspath");
/*     */     }
/*     */     
/* 305 */     this.overrideClasspath
/* 306 */       .add((paramObject instanceof String || paramObject instanceof java.net.URL || paramObject instanceof java.net.URI) ? paramObject : paramObject
/*     */         
/* 308 */         .toString());
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
/*     */   public void filterClasspathElements(Object paramObject) {
/* 321 */     if (!(paramObject instanceof io.github.classgraph.ClassGraph.ClasspathElementFilter) && !(paramObject instanceof io.github.classgraph.ClassGraph.ClasspathElementURLFilter))
/*     */     {
/* 323 */       throw new IllegalArgumentException();
/*     */     }
/* 325 */     if (this.classpathElementFilters == null) {
/* 326 */       this.classpathElementFilters = new ArrayList(2);
/*     */     }
/* 328 */     this.classpathElementFilters.add(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addClassLoader(ClassLoader paramClassLoader) {
/* 339 */     if (this.addedClassLoaders == null) {
/* 340 */       this.addedClassLoaders = new ArrayList<>();
/*     */     }
/* 342 */     if (paramClassLoader != null) {
/* 343 */       this.addedClassLoaders.add(paramClassLoader);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void enableURLScheme(String paramString) {
/* 354 */     if (paramString == null || paramString.length() < 2) {
/* 355 */       throw new IllegalArgumentException("URL schemes must contain at least two characters");
/*     */     }
/* 357 */     if (this.allowedURLSchemes == null) {
/* 358 */       this.allowedURLSchemes = new HashSet<>();
/*     */     }
/* 360 */     this.allowedURLSchemes.add(paramString.toLowerCase());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void overrideClassLoaders(ClassLoader... paramVarArgs) {
/* 371 */     if (paramVarArgs.length == 0) {
/* 372 */       throw new IllegalArgumentException("At least one override ClassLoader must be provided");
/*     */     }
/* 374 */     this.addedClassLoaders = null;
/* 375 */     this.overrideClassLoaders = new ArrayList<>(); int i; byte b;
/* 376 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 377 */       ClassLoader classLoader; if ((classLoader = paramVarArgs[b]) != null) {
/* 378 */         this.overrideClassLoaders.add(classLoader);
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
/*     */   private static boolean isModuleLayer(Object<?> paramObject) {
/* 391 */     if (paramObject == null) {
/* 392 */       throw new IllegalArgumentException("ModuleLayer references must not be null");
/*     */     }
/* 394 */     for (paramObject = (Object<?>)paramObject.getClass(); paramObject != null; 
/* 395 */       paramObject = (Object<?>)paramObject.getSuperclass()) {
/* 396 */       if (paramObject.getName().equals("java.lang.ModuleLayer")) {
/* 397 */         return true;
/*     */       }
/*     */     } 
/* 400 */     return false;
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
/*     */   public void addModuleLayer(Object paramObject) {
/* 415 */     if (!isModuleLayer(paramObject)) {
/* 416 */       throw new IllegalArgumentException("moduleLayer must be of type java.lang.ModuleLayer");
/*     */     }
/* 418 */     if (this.addedModuleLayers == null) {
/* 419 */       this.addedModuleLayers = new ArrayList();
/*     */     }
/* 421 */     this.addedModuleLayers.add(paramObject);
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
/*     */   public void overrideModuleLayers(Object... paramVarArgs) {
/* 436 */     if (paramVarArgs == null) {
/* 437 */       throw new IllegalArgumentException("overrideModuleLayers cannot be null");
/*     */     }
/* 439 */     if (paramVarArgs.length == 0)
/* 440 */       throw new IllegalArgumentException("At least one override ModuleLayer must be provided");  Object[] arrayOfObject; int i;
/*     */     byte b;
/* 442 */     for (i = (arrayOfObject = paramVarArgs).length, b = 0; b < i; b++) {
/* 443 */       Object object; if (!isModuleLayer(object = arrayOfObject[b])) {
/* 444 */         throw new IllegalArgumentException("moduleLayer must be of type java.lang.ModuleLayer");
/*     */       }
/*     */     } 
/* 447 */     this.addedModuleLayers = null;
/* 448 */     this.overrideModuleLayers = new ArrayList();
/* 449 */     Collections.addAll(this.overrideModuleLayers, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum ScanSpecPathMatch
/*     */   {
/* 459 */     HAS_REJECTED_PATH_PREFIX,
/*     */     
/* 461 */     HAS_ACCEPTED_PATH_PREFIX,
/*     */     
/* 463 */     AT_ACCEPTED_PATH,
/*     */     
/* 465 */     ANCESTOR_OF_ACCEPTED_PATH,
/*     */     
/* 467 */     AT_ACCEPTED_CLASS_PACKAGE,
/*     */     
/* 469 */     NOT_WITHIN_ACCEPTED_PATH;
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
/*     */   public ScanSpecPathMatch dirAcceptMatchStatus(String paramString) {
/* 482 */     if (this.pathAcceptReject.isRejected(paramString) || this.pathPrefixAcceptReject.isRejected(paramString))
/*     */     {
/* 484 */       return ScanSpecPathMatch.HAS_REJECTED_PATH_PREFIX;
/*     */     }
/*     */     
/* 487 */     if (this.pathAcceptReject.acceptIsEmpty() && this.classPackagePathAcceptReject.acceptIsEmpty())
/*     */     {
/* 489 */       return (paramString.isEmpty() || paramString.equals("/")) ? ScanSpecPathMatch.AT_ACCEPTED_PATH : ScanSpecPathMatch.HAS_ACCEPTED_PATH_PREFIX;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 494 */     if (this.pathAcceptReject.isSpecificallyAcceptedAndNotRejected(paramString))
/*     */     {
/* 496 */       return ScanSpecPathMatch.AT_ACCEPTED_PATH;
/*     */     }
/* 498 */     if (this.classPackagePathAcceptReject.isSpecificallyAcceptedAndNotRejected(paramString))
/*     */     {
/* 500 */       return ScanSpecPathMatch.AT_ACCEPTED_CLASS_PACKAGE;
/*     */     }
/*     */ 
/*     */     
/* 504 */     if (this.pathPrefixAcceptReject.isSpecificallyAccepted(paramString))
/*     */     {
/* 506 */       return ScanSpecPathMatch.HAS_ACCEPTED_PATH_PREFIX;
/*     */     }
/*     */ 
/*     */     
/* 510 */     if (paramString
/*     */       
/* 512 */       .equals("/") || this.pathAcceptReject
/*     */       
/* 514 */       .acceptHasPrefix(paramString) || this.classfilePathAcceptReject
/*     */       
/* 516 */       .acceptHasPrefix(paramString)) {
/* 517 */       return ScanSpecPathMatch.ANCESTOR_OF_ACCEPTED_PATH;
/*     */     }
/*     */ 
/*     */     
/* 521 */     return ScanSpecPathMatch.NOT_WITHIN_ACCEPTED_PATH;
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
/*     */   public boolean classfileIsSpecificallyAccepted(String paramString) {
/* 534 */     return this.classfilePathAcceptReject.isSpecificallyAcceptedAndNotRejected(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean classOrPackageIsRejected(String paramString) {
/* 545 */     return (this.classAcceptReject.isRejected(paramString) || this.packagePrefixAcceptReject.isRejected(paramString));
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
/*     */   public void log(LogNode paramLogNode) {
/* 557 */     if (paramLogNode != null) {
/* 558 */       paramLogNode = paramLogNode.log("ScanSpec:"); Field[] arrayOfField; int i; byte b;
/* 559 */       for (i = (arrayOfField = ScanSpec.class.getDeclaredFields()).length, b = 0; b < i; ) { Field field = arrayOfField[b];
/*     */         try {
/* 561 */           paramLogNode.log(field.getName() + ": " + field.get(this));
/* 562 */         } catch (ReflectiveOperationException reflectiveOperationException) {}
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\scanspec\ScanSpec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */