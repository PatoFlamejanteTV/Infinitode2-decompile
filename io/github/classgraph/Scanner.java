/*      */ package io.github.classgraph;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.URI;
/*      */ import java.net.URISyntaxException;
/*      */ import java.net.URL;
/*      */ import java.nio.file.FileSystemNotFoundException;
/*      */ import java.nio.file.Files;
/*      */ import java.nio.file.InvalidPathException;
/*      */ import java.nio.file.Path;
/*      */ import java.nio.file.Paths;
/*      */ import java.nio.file.attribute.BasicFileAttributes;
/*      */ import java.util.AbstractMap;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Queue;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.Callable;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.ConcurrentLinkedQueue;
/*      */ import java.util.concurrent.ExecutionException;
/*      */ import java.util.concurrent.ExecutorService;
/*      */ import nonapi.io.github.classgraph.classpath.ClasspathFinder;
/*      */ import nonapi.io.github.classgraph.classpath.ClasspathOrder;
/*      */ import nonapi.io.github.classgraph.classpath.ModuleFinder;
/*      */ import nonapi.io.github.classgraph.concurrency.AutoCloseableExecutorService;
/*      */ import nonapi.io.github.classgraph.concurrency.InterruptionChecker;
/*      */ import nonapi.io.github.classgraph.concurrency.SingletonMap;
/*      */ import nonapi.io.github.classgraph.concurrency.WorkQueue;
/*      */ import nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler;
/*      */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*      */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*      */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*      */ import nonapi.io.github.classgraph.utils.FastPathResolver;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ class Scanner
/*      */   implements Callable<ScanResult>
/*      */ {
/*      */   private final ScanSpec scanSpec;
/*      */   public boolean performScan;
/*      */   private final NestedJarHandler nestedJarHandler;
/*      */   private final ExecutorService executorService;
/*      */   private final InterruptionChecker interruptionChecker;
/*      */   private final int numParallelTasks;
/*      */   private final ClassGraph.ScanResultProcessor scanResultProcessor;
/*      */   private final ClassGraph.FailureHandler failureHandler;
/*      */   private final LogNode topLevelLog;
/*      */   private final ClasspathFinder classpathFinder;
/*      */   private final List<ClasspathElementModule> moduleOrder;
/*      */   private final SingletonMap<Object, ClasspathElement, IOException> classpathEntryObjToClasspathEntrySingletonMap;
/*      */   
/*      */   Scanner(boolean paramBoolean, ScanSpec paramScanSpec, ExecutorService paramExecutorService, int paramInt, ClassGraph.ScanResultProcessor paramScanResultProcessor, ClassGraph.FailureHandler paramFailureHandler, ReflectionUtils paramReflectionUtils, LogNode paramLogNode) {
/*  507 */     this.classpathEntryObjToClasspathEntrySingletonMap = new SingletonMap<Object, ClasspathElement, IOException>()
/*      */       {
/*      */ 
/*      */ 
/*      */         
/*      */         public ClasspathElement newInstance(Object param1Object, LogNode param1LogNode)
/*      */         {
/*  514 */           throw new IOException("Should not reach here"); }
/*      */       }; this.scanSpec = paramScanSpec; this.performScan = paramBoolean; paramScanSpec.sortPrefixes(); paramScanSpec.log(paramLogNode); if (paramLogNode != null) { if (paramScanSpec.pathAcceptReject != null && paramScanSpec.packagePrefixAcceptReject.isSpecificallyAccepted(""))
/*      */         paramLogNode.log("Note: There is no need to accept the root package (\"\") -- not accepting anything will have the same effect of causing all packages to be scanned");  paramLogNode.log("Number of worker threads: " + paramInt); }
/*      */      this.executorService = paramExecutorService; this.interruptionChecker = (paramExecutorService instanceof AutoCloseableExecutorService) ? ((AutoCloseableExecutorService)paramExecutorService).interruptionChecker : new InterruptionChecker(); this.nestedJarHandler = new NestedJarHandler(paramScanSpec, this.interruptionChecker, paramReflectionUtils); this.numParallelTasks = paramInt; this.scanResultProcessor = paramScanResultProcessor; this.failureHandler = paramFailureHandler; this.topLevelLog = paramLogNode; LogNode logNode = (paramLogNode == null) ? null : paramLogNode.log("Finding classpath"); this.classpathFinder = new ClasspathFinder(paramScanSpec, paramReflectionUtils, logNode); try { this.moduleOrder = new ArrayList<>(); ModuleFinder moduleFinder; if ((moduleFinder = this.classpathFinder.getModuleFinder()) != null) { List list = moduleFinder.getSystemModuleRefs(); ClassLoader arrayOfClassLoader[], classLoader = ((arrayOfClassLoader = this.classpathFinder.getClassLoaderOrderRespectingParentDelegation()) != null && arrayOfClassLoader.length != 0) ? arrayOfClassLoader[0] : null; if (list != null)
/*      */           for (Iterator<ModuleRef> iterator = list.iterator(); iterator.hasNext(); ) { ModuleRef moduleRef; String str = (moduleRef = iterator.next()).getName(); if ((paramScanSpec.enableSystemJarsAndModules && paramScanSpec.moduleAcceptReject.acceptAndRejectAreEmpty()) || paramScanSpec.moduleAcceptReject.isSpecificallyAcceptedAndNotRejected(str)) { ClasspathElementModule classpathElementModule = new ClasspathElementModule(moduleRef, this.nestedJarHandler.moduleRefToModuleReaderProxyRecyclerMap, new ClasspathEntryWorkUnit(null, classLoader, null, this.moduleOrder.size(), ""), paramScanSpec); this.moduleOrder.add(classpathElementModule); classpathElementModule.open((WorkQueue<ClasspathEntryWorkUnit>)null, logNode); continue; }
/*      */              if (logNode != null)
/*      */               logNode.log("Skipping non-accepted or rejected system module: " + str);  }
/*      */             if ((list = moduleFinder.getNonSystemModuleRefs()) != null)
/*      */           for (Iterator<ModuleRef> iterator = list.iterator(); iterator.hasNext(); ) { ModuleRef moduleRef; String str; if ((str = (moduleRef = iterator.next()).getName()) == null)
/*      */               str = "";  if (paramScanSpec.moduleAcceptReject.isAcceptedAndNotRejected(str)) { ClasspathElementModule classpathElementModule = new ClasspathElementModule(moduleRef, this.nestedJarHandler.moduleRefToModuleReaderProxyRecyclerMap, new ClasspathEntryWorkUnit(null, classLoader, null, this.moduleOrder.size(), ""), paramScanSpec); this.moduleOrder.add(classpathElementModule); classpathElementModule.open((WorkQueue<ClasspathEntryWorkUnit>)null, logNode); continue; }
/*      */              if (logNode != null)
/*      */               logNode.log("Skipping non-accepted or rejected module: " + str);  }
/*      */             }
/*      */        return; }
/*      */     catch (InterruptedException interruptedException) { this.nestedJarHandler.close(null); throw interruptedException; }
/*      */      } private static void findClasspathOrderRec(ClasspathElement paramClasspathElement, Set<ClasspathElement> paramSet, List<ClasspathElement> paramList) { if (paramSet.add(paramClasspathElement)) {
/*      */       if (!paramClasspathElement.skipClasspathElement)
/*      */         paramList.add(paramClasspathElement);  List<?> list; for (Iterator<?> iterator = (list = CollectionUtils.sortCopy(paramClasspathElement.childClasspathElements)).iterator(); iterator.hasNext();)
/*      */         findClasspathOrderRec(classpathElement = (ClasspathElement)iterator.next(), paramSet, paramList); 
/*  533 */     }  } private WorkQueue.WorkUnitProcessor<ClasspathEntryWorkUnit> newClasspathEntryWorkUnitProcessor(final Set<ClasspathElement> allClasspathEltsOut, final Set<ClasspathElement> toplevelClasspathEltsOut) { return new WorkQueue.WorkUnitProcessor<ClasspathEntryWorkUnit>()
/*      */       {
/*      */         public void processWorkUnit(final Scanner.ClasspathEntryWorkUnit workUnit, final WorkQueue<Scanner.ClasspathEntryWorkUnit> workQueue, final LogNode log)
/*      */         {
/*      */           try {
/*      */             final boolean isJar;
/*      */             
/*  540 */             workUnit.classpathEntryObj = Scanner.normalizeClasspathEntry(workUnit.classpathEntryObj);
/*      */ 
/*      */ 
/*      */             
/*  544 */             if (workUnit.classpathEntryObj instanceof URL || workUnit.classpathEntryObj instanceof URI) {
/*      */               
/*  546 */               bool = true;
/*  547 */             } else if (workUnit.classpathEntryObj instanceof Path) {
/*  548 */               Path path = (Path)workUnit.classpathEntryObj;
/*  549 */               if ("JrtFileSystem".equals(path.getFileSystem().getClass().getSimpleName()))
/*      */               {
/*      */                 
/*  552 */                 throw new IOException("Ignoring JrtFS filesystem path (modules are scanned using the JPMS API): " + path);
/*      */               }
/*      */               
/*  555 */               if (!FileUtils.canRead(path)) {
/*  556 */                 throw new IOException("Cannot read path: " + path);
/*      */               }
/*      */               BasicFileAttributes basicFileAttributes;
/*  559 */               if ((basicFileAttributes = Files.<BasicFileAttributes>readAttributes(path, (Class)BasicFileAttributes.class, new java.nio.file.LinkOption[0])).isRegularFile()) {
/*      */                 
/*  561 */                 bool = true;
/*  562 */               } else if (basicFileAttributes.isDirectory()) {
/*      */                 
/*  564 */                 bool = false;
/*      */               } else {
/*  566 */                 throw new IOException("Not a file or directory: " + bool);
/*      */               }
/*      */             
/*      */             } else {
/*      */               
/*  571 */               throw new IOException("Got unexpected classpath entry object type " + workUnit.classpathEntryObj
/*  572 */                   .getClass().getName() + " : " + workUnit.classpathEntryObj);
/*      */             } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  579 */             Scanner.this.classpathEntryObjToClasspathEntrySingletonMap.get(workUnit.classpathEntryObj, log, new SingletonMap.NewInstanceFactory<ClasspathElement, IOException>()
/*      */                 {
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   public ClasspathElement newInstance()
/*      */                   {
/*  587 */                     ClasspathElement classpathElement = (ClasspathElement)(isJar ? new ClasspathElementZip(workUnit, Scanner.this.nestedJarHandler, Scanner.this.scanSpec) : new ClasspathElementDir(workUnit, Scanner.this.nestedJarHandler, Scanner.this.scanSpec));
/*      */                     
/*  589 */                     allClasspathEltsOut.add(classpathElement);
/*      */ 
/*      */ 
/*      */                     
/*  593 */                     LogNode logNode = (log == null) ? null : log.log(classpathElement.getURI().toString(), "Opening classpath element " + classpathElement);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  601 */                     classpathElement.open(workQueue, logNode);
/*      */                     
/*  603 */                     if (workUnit.parentClasspathElement != null) {
/*      */                       
/*  605 */                       workUnit.parentClasspathElement.childClasspathElements
/*  606 */                         .add(classpathElement);
/*      */                     } else {
/*  608 */                       toplevelClasspathEltsOut.add(classpathElement);
/*      */                     } 
/*      */                     
/*  611 */                     return classpathElement;
/*      */                   }
/*      */                 });
/*      */             return;
/*  615 */           } catch (Exception exception) {
/*  616 */             if (log != null)
/*  617 */               log.log("Skipping invalid classpath entry " + workUnit.classpathEntryObj + " : " + (
/*  618 */                   (exception.getCause() == null) ? (String)exception : (String)exception.getCause()));  return;
/*      */           } 
/*      */         }
/*      */       }; } private List<ClasspathElement> findClasspathOrder(Set<ClasspathElement> paramSet) { List list = CollectionUtils.sortCopy(paramSet); HashSet<ClasspathElement> hashSet = new HashSet(); ArrayList<ClasspathElement> arrayList = new ArrayList(); for (Iterator<ClasspathElement> iterator = list.iterator(); iterator.hasNext();)
/*      */       findClasspathOrderRec(classpathElement = iterator.next(), hashSet, arrayList);  return arrayList; } private <W> void processWorkUnits(Collection<W> paramCollection, LogNode paramLogNode, WorkQueue.WorkUnitProcessor<W> paramWorkUnitProcessor) { WorkQueue.runWorkQueue(paramCollection, this.executorService, this.interruptionChecker, this.numParallelTasks, paramLogNode, paramWorkUnitProcessor); if (paramLogNode != null)
/*      */       paramLogNode.addElapsedTime();  this.interruptionChecker.check(); } static class ClasspathEntryWorkUnit {
/*      */     Object classpathEntryObj; final ClassLoader classLoader; final ClasspathElement parentClasspathElement; final int classpathElementIdxWithinParent; final String packageRootPrefix; public ClasspathEntryWorkUnit(Object param1Object, ClassLoader param1ClassLoader, ClasspathElement param1ClasspathElement, int param1Int, String param1String) { this.classpathEntryObj = param1Object; this.classLoader = param1ClassLoader; this.parentClasspathElement = param1ClasspathElement; this.classpathElementIdxWithinParent = param1Int; this.packageRootPrefix = param1String; }
/*      */   } private static Object normalizeClasspathEntry(Object paramObject) { if (paramObject == null)
/*      */       throw new IOException("Got null classpath entry object");  Object object; if (!(object = paramObject instanceof Path))
/*      */       object = FastPathResolver.resolve(FileUtils.currDirPath(), object.toString());  if (object instanceof String) { String str = (String)object; boolean bool1 = JarUtils.URL_SCHEME_PATTERN.matcher(str).matches(); boolean bool2 = str.contains("!"); if (bool1 || bool2) { str = str.replace(" ", "%20").replace("#", "%23"); if (!bool1)
/*      */           str = "file:" + str;  if (bool2)
/*      */           str = (str = "jar:" + str).replaceAll("!([^/])", "!/$1");  try { URL uRL = new URL(str); if (!bool2)
/*      */             try { String str1 = uRL.getProtocol(); if (!"http".equals(str1) && !"https".equals(str1)) { URI uRI; object = Paths.get(uRI = uRL.toURI()); }
/*      */                }
/*      */             catch (URISyntaxException|IllegalArgumentException|SecurityException uRISyntaxException) {  }
/*      */             catch (FileSystemNotFoundException fileSystemNotFoundException) {}  }
/*      */         catch (MalformedURLException malformedURLException) { try { URI uRI = new URI(str); String str1 = uRI.getScheme(); if (!"http".equals(str1) && !"https".equals(str1))
/*      */               object = Paths.get(uRI);  }
/*      */           catch (URISyntaxException uRISyntaxException) { throw new IOException("Malformed URI: " + object + " : " + uRISyntaxException); }
/*      */           catch (IllegalArgumentException|SecurityException illegalArgumentException) {  }
/*      */           catch (FileSystemNotFoundException fileSystemNotFoundException) {} }
/*      */          }
/*      */        if (object instanceof String)
/*      */         try { object = (new File((String)object)).toPath(); }
/*      */         catch (Exception exception) { try { object = Paths.get((String)object, new String[0]); }
/*      */           catch (InvalidPathException invalidPathException)
/*      */           { throw new IOException("Malformed path: " + paramObject + " : " + invalidPathException); }
/*      */            }
/*      */           }
/*      */      if (object instanceof Path)
/*      */       try {
/*      */         object = ((Path)object).toRealPath(new java.nio.file.LinkOption[0]);
/*      */       } catch (IOException|SecurityException iOException) {}  return object; } static class ClassfileScanWorkUnit {
/*  651 */     private final ClasspathElement classpathElement; private final Resource classfileResource; private final boolean isExternalClass; ClassfileScanWorkUnit(ClasspathElement param1ClasspathElement, Resource param1Resource, boolean param1Boolean) { this.classpathElement = param1ClasspathElement;
/*  652 */       this.classfileResource = param1Resource;
/*  653 */       this.isExternalClass = param1Boolean; }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class ClassfileScannerWorkUnitProcessor
/*      */     implements WorkQueue.WorkUnitProcessor<ClassfileScanWorkUnit>
/*      */   {
/*      */     private final ScanSpec scanSpec;
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<ClasspathElement> classpathOrder;
/*      */ 
/*      */ 
/*      */     
/*      */     private final Set<String> acceptedClassNamesFound;
/*      */ 
/*      */ 
/*      */     
/*  675 */     private final Set<String> classNamesScheduledForExtendedScanning = Collections.newSetFromMap(new ConcurrentHashMap<>());
/*      */ 
/*      */     
/*      */     private final Queue<Classfile> scannedClassfiles;
/*      */ 
/*      */     
/*  681 */     private final ConcurrentHashMap<String, String> stringInternMap = new ConcurrentHashMap<>();
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
/*      */     public ClassfileScannerWorkUnitProcessor(ScanSpec param1ScanSpec, List<ClasspathElement> param1List, Set<String> param1Set, Queue<Classfile> param1Queue) {
/*  699 */       this.scanSpec = param1ScanSpec;
/*  700 */       this.classpathOrder = param1List;
/*  701 */       this.acceptedClassNamesFound = param1Set;
/*  702 */       this.scannedClassfiles = param1Queue;
/*      */     }
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
/*      */     public void processWorkUnit(Scanner.ClassfileScanWorkUnit param1ClassfileScanWorkUnit, WorkQueue<Scanner.ClassfileScanWorkUnit> param1WorkQueue, LogNode param1LogNode) {
/*  729 */       param1LogNode = (param1ClassfileScanWorkUnit.classfileResource.scanLog == null) ? null : param1ClassfileScanWorkUnit.classfileResource.scanLog.log(param1ClassfileScanWorkUnit.classfileResource.getPath(), "Parsing classfile");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/*  736 */         Classfile classfile = new Classfile(param1ClassfileScanWorkUnit.classpathElement, this.classpathOrder, this.acceptedClassNamesFound, this.classNamesScheduledForExtendedScanning, param1ClassfileScanWorkUnit.classfileResource.getPath(), param1ClassfileScanWorkUnit.classfileResource, param1ClassfileScanWorkUnit.isExternalClass, this.stringInternMap, param1WorkQueue, this.scanSpec, param1LogNode);
/*      */ 
/*      */ 
/*      */         
/*  740 */         this.scannedClassfiles.add(classfile);
/*      */         
/*  742 */         if (param1LogNode != null)
/*  743 */           param1LogNode.addElapsedTime(); 
/*      */         return;
/*  745 */       } catch (SkipClassException skipClassException) {
/*  746 */         if (param1LogNode != null) {
/*  747 */           param1LogNode.log(param1ClassfileScanWorkUnit.classfileResource.getPath(), "Skipping classfile: " + skipClassException.getMessage());
/*  748 */           param1LogNode.addElapsedTime();
/*      */         }  return;
/*  750 */       } catch (ClassfileFormatException classfileFormatException) {
/*  751 */         if (param1LogNode != null) {
/*  752 */           param1LogNode.log(param1ClassfileScanWorkUnit.classfileResource.getPath(), "Invalid classfile: " + classfileFormatException.getMessage());
/*  753 */           param1LogNode.addElapsedTime();
/*      */         }  return;
/*  755 */       } catch (IOException iOException) {
/*  756 */         if (param1LogNode != null) {
/*  757 */           param1LogNode.log(param1ClassfileScanWorkUnit.classfileResource.getPath(), "Could not read classfile: " + iOException);
/*  758 */           param1LogNode.addElapsedTime();
/*      */         }  return;
/*  760 */       } catch (Exception exception) {
/*  761 */         if (param1LogNode != null) {
/*  762 */           param1LogNode.log(param1ClassfileScanWorkUnit.classfileResource.getPath(), "Could not read classfile", exception);
/*  763 */           param1LogNode.addElapsedTime();
/*      */         } 
/*      */         return;
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
/*      */ 
/*      */   
/*      */   private void findNestedClasspathElements(List<AbstractMap.SimpleEntry<String, ClasspathElement>> paramList, LogNode paramLogNode) {
/*  782 */     CollectionUtils.sortIfNotEmpty(paramList, new Comparator<AbstractMap.SimpleEntry<String, ClasspathElement>>()
/*      */         {
/*      */           public int compare(AbstractMap.SimpleEntry<String, ClasspathElement> param1SimpleEntry1, AbstractMap.SimpleEntry<String, ClasspathElement> param1SimpleEntry2)
/*      */           {
/*  786 */             return ((String)param1SimpleEntry1.getKey()).compareTo(param1SimpleEntry2.getKey());
/*      */           }
/*      */         });
/*      */     
/*  790 */     for (byte b = 0; b < paramList.size(); b++) {
/*      */       AbstractMap.SimpleEntry<String, ?> simpleEntry;
/*      */       
/*      */       String str;
/*      */       
/*  795 */       int i = (str = (simpleEntry = paramList.get(b)).getKey()).length();
/*  796 */       for (int j = b + 1; j < paramList.size(); ) {
/*      */         AbstractMap.SimpleEntry<String, ?> simpleEntry1;
/*      */         String str1;
/*  799 */         int k = (str1 = (simpleEntry1 = paramList.get(j)).getKey()).length();
/*  800 */         boolean bool = false;
/*  801 */         if (str1.startsWith(str) && k > i)
/*      */         {
/*      */           
/*  804 */           if ((k = str1.charAt(i)) == 47 || k == 33) {
/*      */             String str2;
/*      */ 
/*      */ 
/*      */             
/*  809 */             if ((str2 = str1.substring(i + 1)).indexOf('!') < 0) {
/*      */               
/*  811 */               bool = true;
/*      */               
/*      */               ClasspathElement classpathElement;
/*  814 */               if ((classpathElement = (ClasspathElement)simpleEntry.getValue()).nestedClasspathRootPrefixes == null) {
/*  815 */                 classpathElement.nestedClasspathRootPrefixes = new ArrayList<>();
/*      */               }
/*  817 */               classpathElement.nestedClasspathRootPrefixes.add(str2 + "/");
/*  818 */               if (paramLogNode != null) {
/*  819 */                 paramLogNode.log(str + " is a prefix of the nested element " + str1);
/*      */               }
/*      */             } 
/*      */           } 
/*      */         }
/*  824 */         if (bool) {
/*      */           j++;
/*      */         }
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
/*      */   
/*      */   private void preprocessClasspathElementsByType(List<ClasspathElement> paramList, LogNode paramLogNode) {
/*  842 */     ArrayList<AbstractMap.SimpleEntry<String, ClasspathElement>> arrayList1 = new ArrayList();
/*  843 */     ArrayList<AbstractMap.SimpleEntry<String, ClasspathElement>> arrayList2 = new ArrayList();
/*  844 */     for (Iterator<ClasspathElement> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*  845 */       ClasspathElement classpathElement; if (classpathElement = iterator.next() instanceof ClasspathElementDir) {
/*      */         File file;
/*      */         
/*  848 */         String str = ((file = classpathElement.getFile()) == null) ? classpathElement.toString() : file.getPath();
/*  849 */         arrayList1.add(new AbstractMap.SimpleEntry<>(str, classpathElement)); continue;
/*      */       } 
/*  851 */       if (classpathElement instanceof ClasspathElementZip) {
/*      */         
/*  853 */         ClasspathElementZip classpathElementZip = (ClasspathElementZip)classpathElement;
/*  854 */         arrayList2.add(new AbstractMap.SimpleEntry<>(classpathElementZip.getZipFilePath(), classpathElement));
/*      */ 
/*      */         
/*  857 */         if (classpathElementZip.logicalZipFile != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  863 */           if (classpathElementZip.logicalZipFile.addExportsManifestEntryValue != null) {
/*  864 */             int i; String[] arrayOfString; byte b; for (i = (arrayOfString = JarUtils.smartPathSplit(classpathElementZip.logicalZipFile.addExportsManifestEntryValue, ' ', this.scanSpec)).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*      */               
/*  866 */               this.scanSpec.modulePathInfo.addExports.add(str + "=ALL-UNNAMED"); b++; }
/*      */           
/*      */           } 
/*  869 */           if (classpathElementZip.logicalZipFile.addOpensManifestEntryValue != null) {
/*  870 */             int i; String[] arrayOfString; byte b; for (i = (arrayOfString = JarUtils.smartPathSplit(classpathElementZip.logicalZipFile.addOpensManifestEntryValue, ' ', this.scanSpec)).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*      */               
/*  872 */               this.scanSpec.modulePathInfo.addOpens.add(str + "=ALL-UNNAMED");
/*      */               b++; }
/*      */           
/*      */           } 
/*  876 */           if (classpathElementZip.logicalZipFile.automaticModuleNameManifestEntryValue != null) {
/*  877 */             classpathElementZip.moduleNameFromManifestFile = classpathElementZip.logicalZipFile.automaticModuleNameManifestEntryValue;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  885 */     findNestedClasspathElements(arrayList1, paramLogNode);
/*  886 */     findNestedClasspathElements(arrayList2, paramLogNode);
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
/*      */   private void maskClassfiles(List<ClasspathElement> paramList, LogNode paramLogNode) {
/*  901 */     HashSet<String> hashSet = new HashSet();
/*  902 */     for (byte b = 0; b < paramList.size(); b++) {
/*      */       ClasspathElement classpathElement;
/*  904 */       (classpathElement = paramList.get(b)).maskClassfiles(b, hashSet, paramLogNode);
/*      */     } 
/*  906 */     if (paramLogNode != null) {
/*  907 */       paramLogNode.addElapsedTime();
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
/*      */   private ScanResult performScan(List<ClasspathElement> paramList, List<String> paramList1, ClasspathFinder paramClasspathFinder) {
/*  933 */     if (this.scanSpec.enableClassInfo) {
/*  934 */       maskClassfiles(paramList, (this.topLevelLog == null) ? null : this.topLevelLog
/*  935 */           .log("Masking classfiles"));
/*      */     }
/*      */ 
/*      */     
/*  939 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  940 */     for (ClasspathElement classpathElement : paramList) {
/*  941 */       hashMap1.putAll(classpathElement.fileToLastModified);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  947 */     ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
/*  948 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  949 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*  950 */     if (this.scanSpec.enableClassInfo) {
/*      */       
/*  952 */       ArrayList<ClassfileScanWorkUnit> arrayList = new ArrayList();
/*  953 */       HashSet<String> hashSet = new HashSet();
/*  954 */       for (Iterator<ClasspathElement> iterator = paramList.iterator(); iterator.hasNext();) {
/*      */         
/*  956 */         for (Iterator<Resource> iterator1 = (classpathElement = iterator.next()).acceptedClassfileResources.iterator(); iterator1.hasNext(); ) {
/*      */           Resource resource;
/*      */           
/*  959 */           String str = JarUtils.classfilePathToClassName((resource = iterator1.next()).getPath());
/*  960 */           if (!hashSet.add(str) && !str.equals("module-info") && 
/*  961 */             !str.equals("package-info") && !str.endsWith(".package-info"))
/*      */           {
/*      */             
/*  964 */             throw new IllegalArgumentException("Class " + str + " should not have been scheduled more than once for scanning due to classpath masking -- please report this bug at: https://github.com/classgraph/classgraph/issues");
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  970 */           arrayList
/*  971 */             .add(new ClassfileScanWorkUnit(classpathElement, resource, false));
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  976 */       ConcurrentLinkedQueue<Classfile> concurrentLinkedQueue = new ConcurrentLinkedQueue();
/*      */ 
/*      */       
/*  979 */       ClassfileScannerWorkUnitProcessor classfileScannerWorkUnitProcessor = new ClassfileScannerWorkUnitProcessor(this.scanSpec, paramList, Collections.unmodifiableSet(hashSet), concurrentLinkedQueue);
/*  980 */       processWorkUnits(arrayList, (this.topLevelLog == null) ? null : this.topLevelLog
/*  981 */           .log("Scanning classfiles"), classfileScannerWorkUnitProcessor);
/*      */ 
/*      */ 
/*      */       
/*  985 */       LogNode logNode = (this.topLevelLog == null) ? null : this.topLevelLog.log("Linking related classfiles");
/*  986 */       while (!concurrentLinkedQueue.isEmpty()) {
/*      */         Classfile classfile;
/*  988 */         (classfile = concurrentLinkedQueue.remove()).link((Map)concurrentHashMap, (Map)hashMap2, (Map)hashMap3);
/*      */       } 
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
/* 1013 */       if (logNode != null) {
/* 1014 */         logNode.addElapsedTime();
/*      */       }
/*      */     }
/* 1017 */     else if (this.topLevelLog != null) {
/* 1018 */       this.topLevelLog.log("Classfile scanning is disabled");
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1023 */     return new ScanResult(this.scanSpec, paramList, paramList1, paramClasspathFinder, (Map)concurrentHashMap, (Map)hashMap2, (Map)hashMap3, (Map)hashMap1, this.nestedJarHandler, this.topLevelLog);
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
/*      */   private ScanResult openClasspathElementsThenScan() {
/* 1043 */     ArrayList<ClasspathEntryWorkUnit> arrayList = new ArrayList();
/*      */     List<?> list1;
/* 1045 */     for (ClasspathOrder.ClasspathEntry classpathEntry : list1 = this.classpathFinder.getClasspathOrder().getOrder()) {
/* 1046 */       arrayList.add(new ClasspathEntryWorkUnit(classpathEntry.classpathEntryObj, classpathEntry.classLoader, null, arrayList
/*      */ 
/*      */ 
/*      */             
/* 1050 */             .size(), ""));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1058 */     Set<?> set1 = Collections.newSetFromMap(new ConcurrentHashMap<>());
/*      */     
/* 1060 */     Set<?> set2 = Collections.newSetFromMap(new ConcurrentHashMap<>());
/* 1061 */     processWorkUnits(arrayList, (this.topLevelLog == null) ? null : this.topLevelLog
/* 1062 */         .log("Opening classpath elements"), 
/* 1063 */         newClasspathEntryWorkUnitProcessor((Set)set1, (Set)set2));
/*      */ 
/*      */ 
/*      */     
/* 1067 */     List<ClasspathElement> list = findClasspathOrder((Set)set2);
/*      */ 
/*      */ 
/*      */     
/* 1071 */     preprocessClasspathElementsByType(list, (this.topLevelLog == null) ? null : this.topLevelLog
/* 1072 */         .log("Finding nested classpath elements"));
/*      */ 
/*      */ 
/*      */     
/* 1076 */     LogNode logNode = (this.topLevelLog == null) ? null : this.topLevelLog.log("Final classpath element order:");
/* 1077 */     int i = this.moduleOrder.size() + list.size();
/* 1078 */     ArrayList<ClasspathElementModule> arrayList2 = new ArrayList(i);
/* 1079 */     ArrayList<String> arrayList1 = new ArrayList(i);
/* 1080 */     byte b = 0; Iterator<ClasspathElementModule> iterator;
/* 1081 */     for (iterator = this.moduleOrder.iterator(); iterator.hasNext(); ) {
/* 1082 */       ClasspathElementModule classpathElementModule; (classpathElementModule = iterator.next()).classpathElementIdx = b++;
/* 1083 */       arrayList2.add(classpathElementModule);
/* 1084 */       arrayList1.add(classpathElementModule.toString());
/* 1085 */       if (logNode != null) {
/* 1086 */         ModuleRef moduleRef = classpathElementModule.getModuleRef();
/* 1087 */         logNode.log(moduleRef.toString());
/*      */       } 
/*      */     } 
/* 1090 */     for (iterator = (Iterator)list.iterator(); iterator.hasNext(); ) {
/* 1091 */       ClasspathElement classpathElement; (classpathElement = iterator.next()).classpathElementIdx = b++;
/* 1092 */       arrayList2.add(classpathElement);
/* 1093 */       arrayList1.add(classpathElement.toString());
/* 1094 */       if (logNode != null) {
/* 1095 */         logNode.log(classpathElement.toString());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1100 */     processWorkUnits((Collection)arrayList2, (this.topLevelLog == null) ? null : this.topLevelLog
/* 1101 */         .log("Scanning classpath elements"), new WorkQueue.WorkUnitProcessor<ClasspathElement>()
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*      */           public void processWorkUnit(ClasspathElement param1ClasspathElement, WorkQueue<ClasspathElement> param1WorkQueue, LogNode param1LogNode)
/*      */           {
/* 1108 */             param1ClasspathElement.scanPaths(param1LogNode);
/*      */           }
/*      */         });
/*      */ 
/*      */     
/* 1113 */     ArrayList<ClasspathElementModule> arrayList3 = arrayList2;
/* 1114 */     if (!this.scanSpec.classpathElementResourcePathAcceptReject.acceptIsEmpty()) {
/* 1115 */       arrayList3 = new ArrayList<>(arrayList2.size());
/* 1116 */       for (Iterator<ClasspathElementModule> iterator1 = arrayList2.iterator(); iterator1.hasNext();) {
/* 1117 */         if ((classpathElement = iterator1.next()).containsSpecificallyAcceptedClasspathElementResourcePath) {
/* 1118 */           arrayList3.add(classpathElement);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1123 */     if (this.performScan)
/*      */     {
/* 1125 */       return performScan((List)arrayList3, arrayList1, this.classpathFinder);
/*      */     }
/*      */     
/* 1128 */     if (this.topLevelLog != null) {
/* 1129 */       this.topLevelLog.log("Only returning classpath elements (not performing a scan)");
/*      */     }
/* 1131 */     return new ScanResult(this.scanSpec, (List)arrayList3, arrayList1, this.classpathFinder, null, null, null, null, this.nestedJarHandler, this.topLevelLog);
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
/*      */   public ScanResult call() {
/* 1154 */     ScanResult scanResult = null;
/* 1155 */     long l = System.currentTimeMillis();
/* 1156 */     boolean bool = this.scanSpec.removeTemporaryFilesAfterScan;
/*      */     
/*      */     try {
/* 1159 */       scanResult = openClasspathElementsThenScan();
/*      */ 
/*      */       
/* 1162 */       if (this.topLevelLog != null) {
/* 1163 */         this.topLevelLog.log("~", 
/* 1164 */             String.format("Total time: %.3f sec", new Object[] { Double.valueOf((System.currentTimeMillis() - l) * 0.001D) }));
/* 1165 */         this.topLevelLog.flush();
/*      */       } 
/*      */ 
/*      */       
/* 1169 */       if (this.scanResultProcessor != null) {
/*      */         try {
/* 1171 */           this.scanResultProcessor.processScanResult(scanResult);
/* 1172 */         } catch (Exception exception1) {
/* 1173 */           scanResult.close();
/* 1174 */           throw new ExecutionException(exception1);
/*      */         } 
/* 1176 */         scanResult.close();
/*      */       }
/*      */     
/* 1179 */     } catch (Throwable throwable) {
/* 1180 */       if (this.topLevelLog != null) {
/* 1181 */         this.topLevelLog.log("~", (throwable instanceof InterruptedException || throwable instanceof java.util.concurrent.CancellationException) ? "Scan interrupted or canceled" : ((throwable instanceof ExecutionException || throwable instanceof RuntimeException) ? "Uncaught exception during scan" : throwable
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1186 */             .getMessage()), 
/* 1187 */             InterruptionChecker.getCause(throwable));
/*      */         
/* 1189 */         this.topLevelLog.flush();
/*      */       } 
/*      */ 
/*      */       
/* 1193 */       bool = true;
/*      */ 
/*      */       
/* 1196 */       this.interruptionChecker.interrupt();
/*      */       
/* 1198 */       if (this.failureHandler == null) {
/*      */ 
/*      */ 
/*      */         
/* 1202 */         this.nestedJarHandler.close(this.topLevelLog);
/*      */ 
/*      */         
/* 1205 */         throw throwable;
/*      */       } 
/*      */       
/*      */       try {
/* 1209 */         this.failureHandler.onFailure(throwable);
/* 1210 */       } catch (Exception exception) {
/*      */         
/* 1212 */         if (this.topLevelLog != null) {
/* 1213 */           this.topLevelLog.log("~", "The failure handler threw an exception:", exception);
/* 1214 */           this.topLevelLog.flush();
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1220 */         (exception = new ExecutionException("Exception while calling failure handler", exception)).addSuppressed(throwable);
/*      */ 
/*      */ 
/*      */         
/* 1224 */         this.nestedJarHandler.close(this.topLevelLog);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1229 */         throw exception;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1234 */     if (bool)
/*      */     {
/*      */       
/* 1237 */       this.nestedJarHandler.close(this.topLevelLog);
/*      */     }
/* 1239 */     return (ScanResult)exception;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\Scanner.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */