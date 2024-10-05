/*      */ package io.github.classgraph;
/*      */ 
/*      */ import java.io.Closeable;
/*      */ import java.io.File;
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.ref.WeakReference;
/*      */ import java.net.URI;
/*      */ import java.net.URL;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.atomic.AtomicBoolean;
/*      */ import java.util.concurrent.atomic.AtomicInteger;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import nonapi.io.github.classgraph.classpath.ClasspathFinder;
/*      */ import nonapi.io.github.classgraph.concurrency.AutoCloseableExecutorService;
/*      */ import nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler;
/*      */ import nonapi.io.github.classgraph.json.JSONDeserializer;
/*      */ import nonapi.io.github.classgraph.json.JSONSerializer;
/*      */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*      */ import nonapi.io.github.classgraph.scanspec.AcceptReject;
/*      */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*      */ import nonapi.io.github.classgraph.utils.Assert;
/*      */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*      */ import nonapi.io.github.classgraph.utils.FileUtils;
/*      */ import nonapi.io.github.classgraph.utils.JarUtils;
/*      */ import nonapi.io.github.classgraph.utils.LogNode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class ScanResult
/*      */   implements Closeable
/*      */ {
/*      */   private List<String> rawClasspathEltOrderStrs;
/*      */   private List<ClasspathElement> classpathOrder;
/*      */   private ResourceList allAcceptedResourcesCached;
/*   87 */   private final AtomicInteger getResourcesWithPathCallCount = new AtomicInteger();
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<String, ResourceList> pathToAcceptedResourcesCached;
/*      */ 
/*      */ 
/*      */   
/*      */   Map<String, ClassInfo> classNameToClassInfo;
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<String, PackageInfo> packageNameToPackageInfo;
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<String, ModuleInfo> moduleNameToModuleInfo;
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<File, Long> fileToLastModified;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isObtainedFromDeserialization;
/*      */ 
/*      */ 
/*      */   
/*      */   private ClassGraphClassLoader classGraphClassLoader;
/*      */ 
/*      */ 
/*      */   
/*      */   ClasspathFinder classpathFinder;
/*      */ 
/*      */   
/*      */   private NestedJarHandler nestedJarHandler;
/*      */ 
/*      */   
/*      */   ScanSpec scanSpec;
/*      */ 
/*      */   
/*  128 */   private final AtomicBoolean closed = new AtomicBoolean(false);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ReflectionUtils reflectionUtils;
/*      */ 
/*      */ 
/*      */   
/*      */   private final LogNode topLevelLog;
/*      */ 
/*      */ 
/*      */   
/*      */   private final WeakReference<ScanResult> weakReference;
/*      */ 
/*      */ 
/*      */   
/*  145 */   private static Set<WeakReference<ScanResult>> nonClosedWeakReferences = Collections.newSetFromMap(new ConcurrentHashMap<>());
/*      */ 
/*      */   
/*  148 */   private static final AtomicBoolean initialized = new AtomicBoolean(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String CURRENT_SERIALIZATION_FORMAT = "10";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class SerializationFormat
/*      */   {
/*      */     public String format;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ScanSpec scanSpec;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<String> classpath;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<ClassInfo> classInfo;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<PackageInfo> packageInfo;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List<ModuleInfo> moduleInfo;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SerializationFormat() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SerializationFormat(String param1String, ScanSpec param1ScanSpec, List<ClassInfo> param1List, List<PackageInfo> param1List1, List<ModuleInfo> param1List2, List<String> param1List3) {
/*  204 */       this.format = param1String;
/*  205 */       this.scanSpec = param1ScanSpec;
/*  206 */       this.classpath = param1List3;
/*  207 */       this.classInfo = param1List;
/*  208 */       this.packageInfo = param1List1;
/*  209 */       this.moduleInfo = param1List2;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void init(ReflectionUtils paramReflectionUtils) {
/*  220 */     if (!initialized.getAndSet(true))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  233 */       FileUtils.closeDirectByteBuffer(ByteBuffer.allocateDirect(32), paramReflectionUtils, null);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ScanResult(ScanSpec paramScanSpec, List<ClasspathElement> paramList, List<String> paramList1, ClasspathFinder paramClasspathFinder, Map<String, ClassInfo> paramMap, Map<String, PackageInfo> paramMap1, Map<String, ModuleInfo> paramMap2, Map<File, Long> paramMap3, NestedJarHandler paramNestedJarHandler, LogNode paramLogNode) {
/*  270 */     this.scanSpec = paramScanSpec;
/*  271 */     this.rawClasspathEltOrderStrs = paramList1;
/*  272 */     this.classpathOrder = paramList;
/*  273 */     this.classpathFinder = paramClasspathFinder;
/*  274 */     this.fileToLastModified = paramMap3;
/*  275 */     this.classNameToClassInfo = paramMap;
/*  276 */     this.packageNameToPackageInfo = paramMap1;
/*  277 */     this.moduleNameToModuleInfo = paramMap2;
/*  278 */     this.nestedJarHandler = paramNestedJarHandler;
/*  279 */     this.reflectionUtils = paramNestedJarHandler.reflectionUtils;
/*  280 */     this.topLevelLog = paramLogNode;
/*      */     
/*  282 */     if (paramMap != null) {
/*  283 */       indexResourcesAndClassInfo(paramLogNode);
/*      */     }
/*      */     
/*  286 */     if (paramMap != null) {
/*      */       
/*  288 */       HashSet<Object> hashSet = new HashSet(); Iterator<ClassInfo> iterator;
/*  289 */       for (iterator = paramMap.values().iterator(); iterator.hasNext();) {
/*  290 */         if ((classInfo = iterator.next()).isAnnotation() && classInfo.annotationInfo != null && (
/*      */ 
/*      */           
/*  293 */           annotationInfo = classInfo.annotationInfo.get("java.lang.annotation.Repeatable")) != null && 
/*      */           
/*  295 */           !(annotationParameterValueList = annotationInfo.getParameterValues()).isEmpty() && 
/*      */           
/*  297 */           object = annotationParameterValueList.getValue("value") instanceof AnnotationClassRef && (
/*      */ 
/*      */           
/*  300 */           object = (object = object).getName()) != null) {
/*  301 */           hashSet.add(object);
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  308 */       if (!hashSet.isEmpty()) {
/*  309 */         for (iterator = paramMap.values().iterator(); iterator.hasNext();) {
/*  310 */           (classInfo = iterator.next()).handleRepeatableAnnotations(hashSet);
/*      */         }
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  316 */     this.classGraphClassLoader = new ClassGraphClassLoader(this);
/*      */ 
/*      */     
/*  319 */     this.weakReference = new WeakReference<>(this);
/*  320 */     nonClosedWeakReferences.add(this.weakReference);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void indexResourcesAndClassInfo(LogNode paramLogNode) {
/*      */     Collection<ClassInfo> collection;
/*      */     Iterator<ClassInfo> iterator;
/*  332 */     for (iterator = (collection = this.classNameToClassInfo.values()).iterator(); iterator.hasNext();) {
/*  333 */       (classInfo = iterator.next()).setScanResult(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  339 */     if (this.scanSpec.enableInterClassDependencies) {
/*  340 */       for (ClassInfo classInfo : new ArrayList<>(this.classNameToClassInfo.values())) {
/*  341 */         HashSet<ClassInfo> hashSet = new HashSet();
/*  342 */         for (Iterator<ClassInfo> iterator1 = classInfo.findReferencedClassInfo(paramLogNode).iterator(); iterator1.hasNext();) {
/*      */           
/*  344 */           if ((classInfo1 = iterator1.next()) != null && !classInfo.equals(classInfo1) && 
/*  345 */             !classInfo1.getName().equals("java.lang.Object") && (
/*      */             
/*  347 */             !classInfo1.isExternalClass() || this.scanSpec.enableExternalClasses)) {
/*  348 */             classInfo1.setScanResult(this);
/*  349 */             hashSet.add(classInfo1);
/*      */           } 
/*      */         } 
/*  352 */         classInfo.setReferencedClasses(new ClassInfoList(hashSet, true));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final List<File> getClasspathFiles() {
/*  367 */     if (this.closed.get()) {
/*  368 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  370 */     ArrayList<File> arrayList = new ArrayList();
/*  371 */     for (Iterator<ClasspathElement> iterator = this.classpathOrder.iterator(); iterator.hasNext();) {
/*      */       
/*  373 */       if ((file = (classpathElement = iterator.next()).getFile()) != null) {
/*  374 */         arrayList.add(file);
/*      */       }
/*      */     } 
/*  377 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String getClasspath() {
/*  388 */     if (this.closed.get()) {
/*  389 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  391 */     return JarUtils.pathElementsToPathStr(getClasspathFiles());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final List<URI> getClasspathURIs() {
/*  400 */     if (this.closed.get()) {
/*  401 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  403 */     ArrayList<URI> arrayList = new ArrayList();
/*  404 */     for (ClasspathElement classpathElement : this.classpathOrder) {
/*      */       try {
/*  406 */         for (Iterator<URI> iterator = classpathElement.getAllURIs().iterator(); iterator.hasNext();) {
/*  407 */           if ((uRI = iterator.next()) != null) {
/*  408 */             arrayList.add(uRI);
/*      */           }
/*      */         } 
/*  411 */       } catch (IllegalArgumentException illegalArgumentException) {}
/*      */     } 
/*      */ 
/*      */     
/*  415 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final List<URL> getClasspathURLs() {
/*  426 */     if (this.closed.get()) {
/*  427 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  429 */     ArrayList<URL> arrayList = new ArrayList();
/*  430 */     for (URI uRI : getClasspathURIs()) {
/*      */       try {
/*  432 */         arrayList.add(uRI.toURL());
/*  433 */       } catch (IllegalArgumentException|java.net.MalformedURLException illegalArgumentException) {}
/*      */     } 
/*      */ 
/*      */     
/*  437 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final List<ModuleRef> getModules() {
/*  446 */     if (this.closed.get()) {
/*  447 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  449 */     ArrayList<ModuleRef> arrayList = new ArrayList();
/*  450 */     for (Iterator<ClasspathElement> iterator = this.classpathOrder.iterator(); iterator.hasNext();) {
/*  451 */       if (classpathElement = iterator.next() instanceof ClasspathElementModule) {
/*  452 */         arrayList.add(((ClasspathElementModule)classpathElement).getModuleRef());
/*      */       }
/*      */     } 
/*  455 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ModulePathInfo getModulePathInfo() {
/*  471 */     this.scanSpec.modulePathInfo.getRuntimeInfo(this.reflectionUtils);
/*  472 */     return this.scanSpec.modulePathInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ResourceList getAllResources() {
/*  484 */     if (this.allAcceptedResourcesCached == null) {
/*      */       
/*  486 */       ResourceList resourceList = new ResourceList();
/*  487 */       for (ClasspathElement classpathElement : this.classpathOrder) {
/*  488 */         resourceList.addAll(classpathElement.acceptedResources);
/*      */       }
/*      */       
/*  491 */       this.allAcceptedResourcesCached = resourceList;
/*      */     } 
/*  493 */     return this.allAcceptedResourcesCached;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Map<String, ResourceList> getAllResourcesAsMap() {
/*  504 */     if (this.pathToAcceptedResourcesCached == null) {
/*  505 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*  506 */       for (Resource resource : getAllResources()) {
/*      */         ResourceList resourceList;
/*  508 */         if ((resourceList = (ResourceList)hashMap.get(resource.getPath())) == null) {
/*  509 */           hashMap.put(resource.getPath(), resourceList = new ResourceList());
/*      */         }
/*  511 */         resourceList.add(resource);
/*      */       } 
/*      */       
/*  514 */       this.pathToAcceptedResourcesCached = (Map)hashMap;
/*      */     } 
/*  516 */     return this.pathToAcceptedResourcesCached;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ResourceList getResourcesWithPath(String paramString) {
/*  529 */     if (this.closed.get()) {
/*  530 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  532 */     paramString = FileUtils.sanitizeEntryPath(paramString, true, true);
/*      */     
/*  534 */     ResourceList resourceList = null;
/*  535 */     if (this.getResourcesWithPathCallCount.incrementAndGet() > 3) {
/*      */ 
/*      */       
/*  538 */       resourceList = getAllResourcesAsMap().get(paramString);
/*      */     }
/*      */     else {
/*      */       
/*  542 */       for (Iterator<ClasspathElement> iterator = this.classpathOrder.iterator(); iterator.hasNext();) {
/*  543 */         for (Iterator<Resource> iterator1 = (classpathElement = iterator.next()).acceptedResources.iterator(); iterator1.hasNext();) {
/*  544 */           if ((resource = iterator1.next()).getPath().equals(paramString)) {
/*  545 */             if (resourceList == null) {
/*  546 */               resourceList = new ResourceList();
/*      */             }
/*  548 */             resourceList.add(resource);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  553 */     return (resourceList == null) ? ResourceList.EMPTY_LIST : resourceList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ResourceList getResourcesWithPathIgnoringAccept(String paramString) {
/*  571 */     if (this.closed.get()) {
/*  572 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  574 */     paramString = FileUtils.sanitizeEntryPath(paramString, true, true);
/*      */     
/*  576 */     ResourceList resourceList = new ResourceList();
/*  577 */     for (Iterator<ClasspathElement> iterator = this.classpathOrder.iterator(); iterator.hasNext();) {
/*      */       
/*  579 */       if ((resource = (classpathElement = iterator.next()).getResource(paramString)) != null) {
/*  580 */         resourceList.add(resource);
/*      */       }
/*      */     } 
/*  583 */     return resourceList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public final ResourceList getResourcesWithPathIgnoringWhitelist(String paramString) {
/*  598 */     return getResourcesWithPathIgnoringAccept(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ResourceList getResourcesWithLeafName(String paramString) {
/*  609 */     if (this.closed.get()) {
/*  610 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*      */     ResourceList resourceList1;
/*  613 */     if ((resourceList1 = getAllResources()).isEmpty()) {
/*  614 */       return ResourceList.EMPTY_LIST;
/*      */     }
/*  616 */     ResourceList resourceList2 = new ResourceList();
/*  617 */     for (Iterator<Resource> iterator = resourceList1.iterator(); iterator.hasNext(); ) {
/*      */       Resource resource; String str;
/*  619 */       int i = (str = (resource = iterator.next()).getPath()).lastIndexOf('/');
/*  620 */       if (str.substring(i + 1).equals(paramString)) {
/*  621 */         resourceList2.add(resource);
/*      */       }
/*      */     } 
/*  624 */     return resourceList2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ResourceList getResourcesWithExtension(String paramString) {
/*  636 */     if (this.closed.get()) {
/*  637 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*      */     ResourceList resourceList1;
/*  640 */     if ((resourceList1 = getAllResources()).isEmpty()) {
/*  641 */       return ResourceList.EMPTY_LIST;
/*      */     }
/*  643 */     paramString = paramString;
/*  644 */     while (paramString.startsWith(".")) {
/*  645 */       paramString = paramString.substring(1);
/*      */     }
/*  647 */     ResourceList resourceList2 = new ResourceList();
/*  648 */     for (Iterator<Resource> iterator = resourceList1.iterator(); iterator.hasNext(); ) {
/*      */       Resource resource; String str;
/*  650 */       int i = (str = (resource = iterator.next()).getPath()).lastIndexOf('/');
/*      */       int j;
/*  652 */       if ((j = str.lastIndexOf('.')) > i && str
/*  653 */         .substring(j + 1).equalsIgnoreCase(paramString)) {
/*  654 */         resourceList2.add(resource);
/*      */       }
/*      */     } 
/*  657 */     return resourceList2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ResourceList getResourcesMatchingPattern(Pattern paramPattern) {
/*  670 */     if (this.closed.get()) {
/*  671 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*      */     ResourceList resourceList1;
/*  674 */     if ((resourceList1 = getAllResources()).isEmpty()) {
/*  675 */       return ResourceList.EMPTY_LIST;
/*      */     }
/*  677 */     ResourceList resourceList2 = new ResourceList();
/*  678 */     for (Iterator<Resource> iterator = resourceList1.iterator(); iterator.hasNext(); ) {
/*  679 */       Resource resource; String str = (resource = iterator.next()).getPath();
/*  680 */       if (paramPattern.matcher(str).matches()) {
/*  681 */         resourceList2.add(resource);
/*      */       }
/*      */     } 
/*  684 */     return resourceList2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ResourceList getResourcesMatchingWildcard(String paramString) {
/*  712 */     if (this.closed.get()) {
/*  713 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  715 */     return getResourcesMatchingPattern(AcceptReject.globToPattern(paramString, false));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ModuleInfo getModuleInfo(String paramString) {
/*  730 */     if (this.closed.get()) {
/*  731 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  733 */     if (!this.scanSpec.enableClassInfo) {
/*  734 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  736 */     return this.moduleNameToModuleInfo.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ModuleInfoList getModuleInfo() {
/*  745 */     if (this.closed.get()) {
/*  746 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  748 */     if (!this.scanSpec.enableClassInfo) {
/*  749 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  751 */     return new ModuleInfoList(this.moduleNameToModuleInfo.values());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final PackageInfo getPackageInfo(String paramString) {
/*  766 */     if (this.closed.get()) {
/*  767 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  769 */     if (!this.scanSpec.enableClassInfo) {
/*  770 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  772 */     return this.packageNameToPackageInfo.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final PackageInfoList getPackageInfo() {
/*  781 */     if (this.closed.get()) {
/*  782 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  784 */     if (!this.scanSpec.enableClassInfo) {
/*  785 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  787 */     return new PackageInfoList(this.packageNameToPackageInfo.values());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Map<ClassInfo, ClassInfoList> getClassDependencyMap() {
/*  806 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  807 */     for (ClassInfo classInfo : getAllClasses()) {
/*  808 */       hashMap.put(classInfo, classInfo.getClassDependencies());
/*      */     }
/*  810 */     return (Map)hashMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Map<ClassInfo, ClassInfoList> getReverseClassDependencyMap() {
/*  826 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  827 */     for (Iterator<ClassInfo> iterator = getAllClasses().iterator(); iterator.hasNext();) {
/*  828 */       for (ClassInfo classInfo1 : (classInfo = iterator.next()).getClassDependencies()) {
/*      */         Set<ClassInfo> set;
/*  830 */         if ((set = (Set)hashMap1.get(classInfo1)) == null) {
/*  831 */           hashMap1.put(classInfo1, set = new HashSet());
/*      */         }
/*  833 */         set.add(classInfo);
/*      */       } 
/*      */     } 
/*  836 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  837 */     for (Map.Entry<Object, Object> entry : hashMap1.entrySet()) {
/*  838 */       hashMap2.put(entry.getKey(), new ClassInfoList((Set<ClassInfo>)entry.getValue(), true));
/*      */     }
/*  840 */     return (Map)hashMap2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfo getClassInfo(String paramString) {
/*  855 */     if (this.closed.get()) {
/*  856 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  858 */     if (!this.scanSpec.enableClassInfo) {
/*  859 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  861 */     return this.classNameToClassInfo.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getAllClasses() {
/*  870 */     if (this.closed.get()) {
/*  871 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  873 */     if (!this.scanSpec.enableClassInfo) {
/*  874 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  876 */     return ClassInfo.getAllClasses(this.classNameToClassInfo.values(), this.scanSpec);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getAllEnums() {
/*  885 */     if (this.closed.get()) {
/*  886 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  888 */     if (!this.scanSpec.enableClassInfo) {
/*  889 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  891 */     return ClassInfo.getAllEnums(this.classNameToClassInfo.values(), this.scanSpec);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getAllRecords() {
/*  900 */     if (this.closed.get()) {
/*  901 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  903 */     if (!this.scanSpec.enableClassInfo) {
/*  904 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  906 */     return ClassInfo.getAllRecords(this.classNameToClassInfo.values(), this.scanSpec);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Map<String, ClassInfo> getAllClassesAsMap() {
/*  917 */     if (this.closed.get()) {
/*  918 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  920 */     if (!this.scanSpec.enableClassInfo) {
/*  921 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  923 */     return this.classNameToClassInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getAllStandardClasses() {
/*  932 */     if (this.closed.get()) {
/*  933 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  935 */     if (!this.scanSpec.enableClassInfo) {
/*  936 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  938 */     return ClassInfo.getAllStandardClasses(this.classNameToClassInfo.values(), this.scanSpec);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getSubclasses(Class<?> paramClass) {
/*  949 */     return getSubclasses(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getSubclasses(String paramString) {
/*  960 */     if (this.closed.get()) {
/*  961 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  963 */     if (!this.scanSpec.enableClassInfo) {
/*  964 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*  966 */     if (paramString.equals("java.lang.Object"))
/*      */     {
/*  968 */       return getAllStandardClasses();
/*      */     }
/*      */     ClassInfo classInfo;
/*  971 */     return ((classInfo = this.classNameToClassInfo.get(paramString)) == null) ? ClassInfoList.EMPTY_LIST : classInfo.getSubclasses();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getSuperclasses(String paramString) {
/*  983 */     if (this.closed.get()) {
/*  984 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/*  986 */     if (!this.scanSpec.enableClassInfo) {
/*  987 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*      */     ClassInfo classInfo;
/*  990 */     return ((classInfo = this.classNameToClassInfo.get(paramString)) == null) ? ClassInfoList.EMPTY_LIST : classInfo.getSuperclasses();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getSuperclasses(Class<?> paramClass) {
/* 1001 */     return getSuperclasses(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithMethodAnnotation(Class<? extends Annotation> paramClass) {
/* 1012 */     Assert.isAnnotation(paramClass);
/* 1013 */     return getClassesWithMethodAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithMethodAnnotation(String paramString) {
/* 1024 */     if (this.closed.get()) {
/* 1025 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1027 */     if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableMethodInfo || !this.scanSpec.enableAnnotationInfo) {
/* 1028 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo(), #enableMethodInfo(), and #enableAnnotationInfo() before #scan()");
/*      */     }
/*      */     
/*      */     ClassInfo classInfo;
/* 1032 */     return ((classInfo = this.classNameToClassInfo.get(paramString)) == null) ? ClassInfoList.EMPTY_LIST : classInfo.getClassesWithMethodAnnotation();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithMethodParameterAnnotation(Class<? extends Annotation> paramClass) {
/* 1045 */     Assert.isAnnotation(paramClass);
/* 1046 */     return getClassesWithMethodParameterAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithMethodParameterAnnotation(String paramString) {
/* 1058 */     if (this.closed.get()) {
/* 1059 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1061 */     if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableMethodInfo || !this.scanSpec.enableAnnotationInfo) {
/* 1062 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo(), #enableMethodInfo(), and #enableAnnotationInfo() before #scan()");
/*      */     }
/*      */     
/*      */     ClassInfo classInfo;
/* 1066 */     return ((classInfo = this.classNameToClassInfo.get(paramString)) == null) ? ClassInfoList.EMPTY_LIST : classInfo.getClassesWithMethodParameterAnnotation();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithFieldAnnotation(Class<? extends Annotation> paramClass) {
/* 1077 */     Assert.isAnnotation(paramClass);
/* 1078 */     return getClassesWithFieldAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithFieldAnnotation(String paramString) {
/* 1089 */     if (this.closed.get()) {
/* 1090 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1092 */     if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableFieldInfo || !this.scanSpec.enableAnnotationInfo) {
/* 1093 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo(), #enableFieldInfo(), and #enableAnnotationInfo() before #scan()");
/*      */     }
/*      */     
/*      */     ClassInfo classInfo;
/* 1097 */     return ((classInfo = this.classNameToClassInfo.get(paramString)) == null) ? ClassInfoList.EMPTY_LIST : classInfo.getClassesWithFieldAnnotation();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getAllInterfaces() {
/* 1110 */     if (this.closed.get()) {
/* 1111 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1113 */     if (!this.scanSpec.enableClassInfo) {
/* 1114 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/* 1116 */     return ClassInfo.getAllImplementedInterfaceClasses(this.classNameToClassInfo.values(), this.scanSpec);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getInterfaces(String paramString) {
/* 1129 */     if (this.closed.get()) {
/* 1130 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1132 */     if (!this.scanSpec.enableClassInfo) {
/* 1133 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*      */     ClassInfo classInfo;
/* 1136 */     return ((classInfo = this.classNameToClassInfo.get(paramString)) == null) ? ClassInfoList.EMPTY_LIST : classInfo.getInterfaces();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getInterfaces(Class<?> paramClass) {
/* 1149 */     return getInterfaces(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesImplementing(Class<?> paramClass) {
/* 1161 */     Assert.isInterface(paramClass);
/* 1162 */     return getClassesImplementing(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesImplementing(String paramString) {
/* 1174 */     if (this.closed.get()) {
/* 1175 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1177 */     if (!this.scanSpec.enableClassInfo) {
/* 1178 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*      */     ClassInfo classInfo;
/* 1181 */     return ((classInfo = this.classNameToClassInfo.get(paramString)) == null) ? ClassInfoList.EMPTY_LIST : classInfo.getClassesImplementing();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getAllAnnotations() {
/* 1193 */     if (this.closed.get()) {
/* 1194 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1196 */     if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableAnnotationInfo) {
/* 1197 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() and #enableAnnotationInfo() before #scan()");
/*      */     }
/*      */     
/* 1200 */     return ClassInfo.getAllAnnotationClasses(this.classNameToClassInfo.values(), this.scanSpec);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getAllInterfacesAndAnnotations() {
/* 1210 */     if (this.closed.get()) {
/* 1211 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1213 */     if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableAnnotationInfo) {
/* 1214 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() and #enableAnnotationInfo() before #scan()");
/*      */     }
/*      */     
/* 1217 */     return ClassInfo.getAllInterfacesOrAnnotationClasses(this.classNameToClassInfo.values(), this.scanSpec);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithAnnotation(Class<? extends Annotation> paramClass) {
/* 1229 */     Assert.isAnnotation(paramClass);
/* 1230 */     return getClassesWithAnnotation(paramClass.getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithAllAnnotations(Class<? extends Annotation>... paramVarArgs) {
/* 1243 */     ArrayList<String> arrayList = new ArrayList(); int i; byte b;
/* 1244 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 1245 */       Class<? extends Annotation> clazz; Assert.isAnnotation(clazz = paramVarArgs[b]);
/* 1246 */       arrayList.add(clazz.getName());
/*      */     } 
/* 1248 */     return getClassesWithAllAnnotations(arrayList.<String>toArray(new String[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithAnyAnnotation(Class<? extends Annotation>... paramVarArgs) {
/* 1261 */     ArrayList<String> arrayList = new ArrayList(); int i; byte b;
/* 1262 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/* 1263 */       Class<? extends Annotation> clazz; Assert.isAnnotation(clazz = paramVarArgs[b]);
/* 1264 */       arrayList.add(clazz.getName());
/*      */     } 
/* 1266 */     return getClassesWithAnyAnnotation(arrayList.<String>toArray(new String[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithAnnotation(String paramString) {
/* 1278 */     if (this.closed.get()) {
/* 1279 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1281 */     if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableAnnotationInfo) {
/* 1282 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() and #enableAnnotationInfo() before #scan()");
/*      */     }
/*      */     
/*      */     ClassInfo classInfo;
/* 1286 */     return ((classInfo = this.classNameToClassInfo.get(paramString)) == null) ? ClassInfoList.EMPTY_LIST : classInfo.getClassesWithAnnotation();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithAllAnnotations(String... paramVarArgs) {
/* 1298 */     ClassInfoList classInfoList = null; int i; byte b;
/* 1299 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { String str = paramVarArgs[b];
/* 1300 */       ClassInfoList classInfoList1 = getClassesWithAnnotation(str);
/* 1301 */       if (classInfoList == null) {
/* 1302 */         classInfoList = classInfoList1;
/*      */       } else {
/* 1304 */         classInfoList = classInfoList.intersect(new ClassInfoList[] { classInfoList1 });
/*      */       }  b++; }
/*      */     
/* 1307 */     CollectionUtils.sortIfNotEmpty(classInfoList);
/* 1308 */     return (classInfoList == null) ? ClassInfoList.EMPTY_LIST : classInfoList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getClassesWithAnyAnnotation(String... paramVarArgs) {
/* 1320 */     ClassInfoList classInfoList = null; int i; byte b;
/* 1321 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { String str = paramVarArgs[b];
/* 1322 */       ClassInfoList classInfoList1 = getClassesWithAnnotation(str);
/* 1323 */       if (classInfoList == null) {
/* 1324 */         classInfoList = classInfoList1;
/*      */       } else {
/* 1326 */         classInfoList = classInfoList.union(new ClassInfoList[] { classInfoList1 });
/*      */       }  b++; }
/*      */     
/* 1329 */     CollectionUtils.sortIfNotEmpty(classInfoList);
/* 1330 */     return (classInfoList == null) ? ClassInfoList.EMPTY_LIST : classInfoList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ClassInfoList getAnnotationsOnClass(String paramString) {
/* 1345 */     if (this.closed.get()) {
/* 1346 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1348 */     if (!this.scanSpec.enableClassInfo || !this.scanSpec.enableAnnotationInfo) {
/* 1349 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() and #enableAnnotationInfo() before #scan()");
/*      */     }
/*      */     
/*      */     ClassInfo classInfo;
/* 1353 */     return ((classInfo = this.classNameToClassInfo.get(paramString)) == null) ? ClassInfoList.EMPTY_LIST : classInfo.getAnnotations();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean classpathContentsModifiedSinceScan() {
/* 1368 */     if (this.closed.get()) {
/* 1369 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1371 */     if (this.fileToLastModified == null) {
/* 1372 */       return true;
/*      */     }
/* 1374 */     for (Iterator<Map.Entry> iterator = this.fileToLastModified.entrySet().iterator(); iterator.hasNext();) {
/* 1375 */       if (((File)(entry = iterator.next()).getKey()).lastModified() != ((Long)entry.getValue()).longValue()) {
/* 1376 */         return true;
/*      */       }
/*      */     } 
/* 1379 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final long classpathContentsLastModifiedTime() {
/* 1396 */     if (this.closed.get()) {
/* 1397 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1399 */     long l = 0L;
/* 1400 */     if (this.fileToLastModified != null) {
/* 1401 */       long l1 = System.currentTimeMillis();
/* 1402 */       for (Iterator<Long> iterator = this.fileToLastModified.values().iterator(); iterator.hasNext();) {
/* 1403 */         if ((l2 = ((Long)iterator.next()).longValue()) > l && l2 < l1) {
/* 1404 */           l = l2;
/*      */         }
/*      */       } 
/*      */     } 
/* 1408 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final ClassLoader[] getClassLoaderOrderRespectingParentDelegation() {
/* 1420 */     return this.classpathFinder.getClassLoaderOrderRespectingParentDelegation();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Class<?> loadClass(String paramString, boolean paramBoolean) {
/* 1447 */     if (this.closed.get()) {
/* 1448 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1450 */     if (paramString == null || paramString.isEmpty()) {
/* 1451 */       throw new NullPointerException("className cannot be null or empty");
/*      */     }
/*      */     try {
/* 1454 */       return Class.forName(paramString, this.scanSpec.initializeLoadedClasses, this.classGraphClassLoader);
/* 1455 */     } catch (ClassNotFoundException|LinkageError classNotFoundException) {
/* 1456 */       if (paramBoolean) {
/* 1457 */         return null;
/*      */       }
/* 1459 */       throw new IllegalArgumentException("Could not load class " + paramString + " : " + classNotFoundException, classNotFoundException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> Class<T> loadClass(String paramString, Class<T> paramClass, boolean paramBoolean) {
/*      */     Class<?> clazz2;
/* 1493 */     if (this.closed.get()) {
/* 1494 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1496 */     if (paramString == null || paramString.isEmpty()) {
/* 1497 */       throw new NullPointerException("className cannot be null or empty");
/*      */     }
/* 1499 */     if (paramClass == null) {
/* 1500 */       throw new NullPointerException("superclassOrInterfaceType parameter cannot be null");
/*      */     }
/*      */     
/*      */     try {
/* 1504 */       clazz2 = Class.forName(paramString, this.scanSpec.initializeLoadedClasses, this.classGraphClassLoader);
/* 1505 */     } catch (ClassNotFoundException|LinkageError classNotFoundException) {
/* 1506 */       if (paramBoolean) {
/* 1507 */         return null;
/*      */       }
/* 1509 */       throw new IllegalArgumentException("Could not load class " + paramString + " : " + classNotFoundException);
/*      */     } 
/*      */     
/* 1512 */     if (clazz2 != null && !classNotFoundException.isAssignableFrom(clazz2)) {
/* 1513 */       if (paramBoolean) {
/* 1514 */         return null;
/*      */       }
/* 1516 */       throw new IllegalArgumentException("Loaded class " + clazz2.getName() + " cannot be cast to " + classNotFoundException
/* 1517 */           .getName());
/*      */     } 
/*      */     
/*      */     Class<?> clazz1;
/*      */     
/* 1522 */     return (Class)(clazz1 = clazz2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ScanResult fromJSON(String paramString) {
/*      */     Matcher matcher;
/* 1539 */     if (!(matcher = Pattern.compile("\\{[\\n\\r ]*\"format\"[ ]?:[ ]?\"([^\"]+)\"").matcher(paramString)).find()) {
/* 1540 */       throw new IllegalArgumentException("JSON is not in correct format");
/*      */     }
/* 1542 */     if (!"10".equals(matcher.group(1))) {
/* 1543 */       throw new IllegalArgumentException("JSON was serialized in a different format from the format used by the current version of ClassGraph -- please serialize and deserialize your ScanResult using the same version of ClassGraph");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1552 */     if ((null = (SerializationFormat)JSONDeserializer.deserializeObject(SerializationFormat.class, paramString)) == null || !null.format.equals("10"))
/*      */     {
/*      */       
/* 1555 */       throw new IllegalArgumentException("JSON was serialized by newer version of ClassGraph");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     ClassGraph classGraph;
/*      */ 
/*      */     
/* 1563 */     (classGraph = new ClassGraph()).scanSpec = null.scanSpec;
/*      */     
/* 1565 */     AutoCloseableExecutorService autoCloseableExecutorService = new AutoCloseableExecutorService(ClassGraph.DEFAULT_NUM_WORKER_THREADS); Throwable throwable2 = null;
/*      */     
/* 1567 */     try { ScanResult scanResult = classGraph.getClasspathScanResult(autoCloseableExecutorService); } catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/* 1568 */     finally { if (throwable2 != null) { try { autoCloseableExecutorService.close(); } catch (Throwable throwable1) { throwable2.addSuppressed(throwable1); }  } else { autoCloseableExecutorService.close(); }  }
/* 1569 */      ((ScanResult)throwable1).rawClasspathEltOrderStrs = ((SerializationFormat)paramString).classpath;
/*      */ 
/*      */ 
/*      */     
/* 1573 */     ((ScanResult)throwable1).scanSpec = ((SerializationFormat)paramString).scanSpec;
/* 1574 */     ((ScanResult)throwable1).classNameToClassInfo = new HashMap<>();
/* 1575 */     if (((SerializationFormat)paramString).classInfo != null) {
/* 1576 */       for (ClassInfo classInfo : ((SerializationFormat)paramString).classInfo) {
/* 1577 */         ((ScanResult)throwable1).classNameToClassInfo.put(classInfo.getName(), classInfo);
/* 1578 */         classInfo.setScanResult((ScanResult)throwable1);
/*      */       } 
/*      */     }
/* 1581 */     ((ScanResult)throwable1).moduleNameToModuleInfo = new HashMap<>();
/* 1582 */     if (((SerializationFormat)paramString).moduleInfo != null) {
/* 1583 */       for (ModuleInfo moduleInfo : ((SerializationFormat)paramString).moduleInfo) {
/* 1584 */         ((ScanResult)throwable1).moduleNameToModuleInfo.put(moduleInfo.getName(), moduleInfo);
/*      */       }
/*      */     }
/* 1587 */     ((ScanResult)throwable1).packageNameToPackageInfo = new HashMap<>();
/* 1588 */     if (((SerializationFormat)paramString).packageInfo != null) {
/* 1589 */       for (PackageInfo packageInfo : ((SerializationFormat)paramString).packageInfo) {
/* 1590 */         ((ScanResult)throwable1).packageNameToPackageInfo.put(packageInfo.getName(), packageInfo);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/* 1595 */     throwable1.indexResourcesAndClassInfo(null);
/*      */     
/* 1597 */     ((ScanResult)throwable1).isObtainedFromDeserialization = true;
/* 1598 */     return (ScanResult)throwable1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String toJSON(int paramInt) {
/* 1609 */     if (this.closed.get()) {
/* 1610 */       throw new IllegalArgumentException("Cannot use a ScanResult after it has been closed");
/*      */     }
/* 1612 */     if (!this.scanSpec.enableClassInfo) {
/* 1613 */       throw new IllegalArgumentException("Please call ClassGraph#enableClassInfo() before #scan()");
/*      */     }
/*      */     ArrayList<ClassInfo> arrayList;
/* 1616 */     CollectionUtils.sortIfNotEmpty(arrayList = new ArrayList(this.classNameToClassInfo.values()));
/*      */     ArrayList<PackageInfo> arrayList1;
/* 1618 */     CollectionUtils.sortIfNotEmpty(arrayList1 = new ArrayList(this.packageNameToPackageInfo.values()));
/*      */     ArrayList<ModuleInfo> arrayList2;
/* 1620 */     CollectionUtils.sortIfNotEmpty(arrayList2 = new ArrayList(this.moduleNameToModuleInfo.values()));
/* 1621 */     return JSONSerializer.serializeObject(new SerializationFormat("10", this.scanSpec, arrayList, arrayList1, arrayList2, this.rawClasspathEltOrderStrs), paramInt, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String toJSON() {
/* 1631 */     return toJSON(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isObtainedFromDeserialization() {
/* 1641 */     return this.isObtainedFromDeserialization;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void close() {
/* 1654 */     if (!this.closed.getAndSet(true)) {
/* 1655 */       nonClosedWeakReferences.remove(this.weakReference);
/* 1656 */       if (this.classpathOrder != null) {
/* 1657 */         this.classpathOrder.clear();
/* 1658 */         this.classpathOrder = null;
/*      */       } 
/* 1660 */       if (this.allAcceptedResourcesCached != null) {
/* 1661 */         for (Iterator<Resource> iterator = this.allAcceptedResourcesCached.iterator(); iterator.hasNext();) {
/* 1662 */           (resource = iterator.next()).close();
/*      */         }
/* 1664 */         this.allAcceptedResourcesCached.clear();
/* 1665 */         this.allAcceptedResourcesCached = null;
/*      */       } 
/* 1667 */       if (this.pathToAcceptedResourcesCached != null) {
/* 1668 */         this.pathToAcceptedResourcesCached.clear();
/* 1669 */         this.pathToAcceptedResourcesCached = null;
/*      */       } 
/* 1671 */       this.classGraphClassLoader = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1680 */       if (this.packageNameToPackageInfo != null) {
/* 1681 */         this.packageNameToPackageInfo.clear();
/* 1682 */         this.packageNameToPackageInfo = null;
/*      */       } 
/* 1684 */       if (this.moduleNameToModuleInfo != null) {
/* 1685 */         this.moduleNameToModuleInfo.clear();
/* 1686 */         this.moduleNameToModuleInfo = null;
/*      */       } 
/* 1688 */       if (this.fileToLastModified != null) {
/* 1689 */         this.fileToLastModified.clear();
/* 1690 */         this.fileToLastModified = null;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1696 */       if (this.nestedJarHandler != null) {
/* 1697 */         this.nestedJarHandler.close(this.topLevelLog);
/* 1698 */         this.nestedJarHandler = null;
/*      */       } 
/* 1700 */       this.classGraphClassLoader = null;
/* 1701 */       this.classpathFinder = null;
/* 1702 */       this.reflectionUtils = null;
/*      */ 
/*      */       
/* 1705 */       if (this.topLevelLog != null) {
/* 1706 */         this.topLevelLog.flush();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void closeAll() {
/* 1720 */     for (Iterator<?> iterator = (new ArrayList(nonClosedWeakReferences)).iterator(); iterator.hasNext();) {
/*      */       
/* 1722 */       if ((scanResult = (weakReference = (WeakReference<ScanResult>)iterator.next()).get()) != null)
/* 1723 */         scanResult.close(); 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ScanResult.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */