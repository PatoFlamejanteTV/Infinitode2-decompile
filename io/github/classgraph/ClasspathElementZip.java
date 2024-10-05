/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOError;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.attribute.PosixFilePermission;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import nonapi.io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry;
/*     */ import nonapi.io.github.classgraph.concurrency.SingletonMap;
/*     */ import nonapi.io.github.classgraph.concurrency.WorkQueue;
/*     */ import nonapi.io.github.classgraph.fastzipfilereader.FastZipEntry;
/*     */ import nonapi.io.github.classgraph.fastzipfilereader.LogicalZipFile;
/*     */ import nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler;
/*     */ import nonapi.io.github.classgraph.fastzipfilereader.ZipFileSlice;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.ClassfileReader;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.FastPathResolver;
/*     */ import nonapi.io.github.classgraph.utils.FileUtils;
/*     */ import nonapi.io.github.classgraph.utils.JarUtils;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
/*     */ import nonapi.io.github.classgraph.utils.URLPathEncoder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ClasspathElementZip
/*     */   extends ClasspathElement
/*     */ {
/*     */   private final String rawPath;
/*     */   LogicalZipFile logicalZipFile;
/*     */   private String zipFilePath;
/*     */   private final ConcurrentHashMap<String, Resource> relativePathToResource;
/*     */   private final Set<String> strippedAutomaticPackageRootPrefixes;
/*     */   private final NestedJarHandler nestedJarHandler;
/*     */   String moduleNameFromManifestFile;
/*     */   private String derivedAutomaticModuleName;
/*     */   
/*     */   ClasspathElementZip(Scanner.ClasspathEntryWorkUnit paramClasspathEntryWorkUnit, NestedJarHandler paramNestedJarHandler, ScanSpec paramScanSpec) {
/* 106 */     super(paramClasspathEntryWorkUnit, paramScanSpec); String str; this.relativePathToResource = new ConcurrentHashMap<>(); this.strippedAutomaticPackageRootPrefixes = new HashSet<>();
/* 107 */     Object object = paramClasspathEntryWorkUnit.classpathEntryObj;
/*     */ 
/*     */ 
/*     */     
/* 111 */     paramScanSpec = null;
/* 112 */     if (object instanceof Path) {
/*     */       
/*     */       try {
/* 115 */         str = ((Path)object).toUri().toString();
/* 116 */       } catch (IOError|SecurityException iOError) {}
/*     */     }
/*     */ 
/*     */     
/* 120 */     if (str == null) {
/* 121 */       str = object.toString();
/*     */     }
/* 123 */     this.rawPath = str;
/* 124 */     this.zipFilePath = str;
/* 125 */     this.nestedJarHandler = paramNestedJarHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void open(WorkQueue<Scanner.ClasspathEntryWorkUnit> paramWorkQueue, LogNode paramLogNode) {
/* 134 */     if (!this.scanSpec.scanJars) {
/* 135 */       if (paramLogNode != null) {
/* 136 */         log(this.classpathElementIdx, "Skipping classpath element, since jar scanning is disabled: " + this.rawPath, paramLogNode);
/*     */       }
/*     */       
/* 139 */       this.skipClasspathElement = true;
/*     */       return;
/*     */     } 
/* 142 */     paramLogNode = (paramLogNode == null) ? null : log(this.classpathElementIdx, "Opening jar: " + this.rawPath, paramLogNode);
/* 143 */     int i = this.rawPath.indexOf('!');
/* 144 */     String str = FastPathResolver.resolve(FileUtils.currDirPath(), (i < 0) ? this.rawPath : this.rawPath
/* 145 */         .substring(0, i));
/* 146 */     if (!this.scanSpec.jarAcceptReject.isAcceptedAndNotRejected(str)) {
/* 147 */       if (paramLogNode != null) {
/* 148 */         paramLogNode.log("Skipping jarfile that is rejected or not accepted: " + this.rawPath);
/*     */       }
/* 150 */       this.skipClasspathElement = true;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     try {
/*     */       Map.Entry entry;
/*     */       
/*     */       try {
/* 159 */         entry = (Map.Entry)this.nestedJarHandler.nestedPathToLogicalZipFileAndPackageRootMap.get(this.rawPath, paramLogNode);
/* 160 */       } catch (nonapi.io.github.classgraph.concurrency.SingletonMap.NullSingletonException|nonapi.io.github.classgraph.concurrency.SingletonMap.NewInstanceException nullSingletonException) {
/*     */ 
/*     */         
/* 163 */         throw new IOException("Could not get logical zipfile " + this.rawPath + " : " + (
/* 164 */             (nullSingletonException.getCause() == null) ? nullSingletonException : nullSingletonException.getCause()));
/*     */       } 
/* 166 */       this.logicalZipFile = (LogicalZipFile)entry.getKey();
/* 167 */       if (this.logicalZipFile == null)
/*     */       {
/* 169 */         throw new IOException("Logical zipfile was null");
/*     */       }
/*     */ 
/*     */       
/* 173 */       this.zipFilePath = FastPathResolver.resolve(FileUtils.currDirPath(), this.logicalZipFile.getPath());
/*     */       
/*     */       String str1;
/*     */       
/* 177 */       if (!(str1 = (String)entry.getValue()).isEmpty()) {
/* 178 */         this.packageRootPrefix = str1 + "/";
/*     */       }
/* 180 */     } catch (IOException|IllegalArgumentException iOException) {
/* 181 */       if (paramLogNode != null) {
/* 182 */         paramLogNode.log("Could not open jarfile " + this.rawPath + " : " + iOException);
/*     */       }
/* 184 */       this.skipClasspathElement = true;
/*     */       
/*     */       return;
/*     */     } 
/* 188 */     if (!this.scanSpec.enableSystemJarsAndModules && this.logicalZipFile.isJREJar) {
/*     */ 
/*     */       
/* 191 */       if (paramLogNode != null) {
/* 192 */         paramLogNode.log("Ignoring JRE jar: " + this.rawPath);
/*     */       }
/* 194 */       this.skipClasspathElement = true;
/*     */       
/*     */       return;
/*     */     } 
/* 198 */     if (!this.logicalZipFile.isAcceptedAndNotRejected(this.scanSpec.jarAcceptReject)) {
/* 199 */       if (paramLogNode != null) {
/* 200 */         paramLogNode.log("Skipping jarfile that is rejected or not accepted: " + this.rawPath);
/*     */       }
/* 202 */       this.skipClasspathElement = true;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 208 */     byte b = 0;
/* 209 */     if (this.scanSpec.scanNestedJars) {
/* 210 */       for (FastZipEntry fastZipEntry : this.logicalZipFile.entries) {
/* 211 */         String[] arrayOfString; int j; byte b1; for (j = (arrayOfString = ClassLoaderHandlerRegistry.AUTOMATIC_LIB_DIR_PREFIXES).length, b1 = 0; b1 < j; ) { String str1 = arrayOfString[b1];
/*     */           
/* 213 */           if (fastZipEntry.entryNameUnversioned.startsWith(str1) && fastZipEntry.entryNameUnversioned
/* 214 */             .endsWith(".jar")) {
/* 215 */             str1 = fastZipEntry.getPath();
/* 216 */             if (paramLogNode != null) {
/* 217 */               paramLogNode.log("Found nested lib jar: " + str1);
/*     */             }
/* 219 */             paramWorkQueue.addWorkUnit(new Scanner.ClasspathEntryWorkUnit(str1, getClassLoader(), this, b++, ""));
/*     */             
/*     */             break;
/*     */           } 
/*     */           
/*     */           b1++; }
/*     */       
/*     */       } 
/*     */     }
/*     */     
/*     */     HashSet<String> hashSet;
/*     */     
/* 231 */     (hashSet = new HashSet<>()).add(this.rawPath);
/*     */ 
/*     */ 
/*     */     
/* 235 */     if (this.logicalZipFile.classPathManifestEntryValue != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 240 */       String str1 = FileUtils.getParentDirPath(this.logicalZipFile.getPathWithinParentZipFileSlice()); String[] arrayOfString;
/*     */       int j;
/*     */       byte b1;
/* 243 */       for (j = (arrayOfString = this.logicalZipFile.classPathManifestEntryValue
/* 244 */         .split(" ")).length, b1 = 0; b1 < j; b1++) {
/* 245 */         String str2; if (!(str2 = arrayOfString[b1]).isEmpty()) {
/*     */           
/* 247 */           str2 = FastPathResolver.resolve(str1, str2);
/*     */ 
/*     */           
/*     */           ZipFileSlice zipFileSlice;
/*     */ 
/*     */           
/* 253 */           String str3 = ((zipFileSlice = this.logicalZipFile.getParentZipFileSlice()) == null) ? str2 : (zipFileSlice.getPath() + (str2.startsWith("/") ? "!" : "!/") + str2);
/*     */ 
/*     */           
/* 256 */           if (hashSet.add(str3))
/*     */           {
/* 258 */             paramWorkQueue.addWorkUnit(new Scanner.ClasspathEntryWorkUnit(str3, 
/* 259 */                   getClassLoader(), this, b++, ""));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 269 */     if (this.logicalZipFile.bundleClassPathManifestEntryValue != null) {
/* 270 */       String str1 = this.zipFilePath + "!/"; String[] arrayOfString; int j;
/*     */       byte b1;
/* 272 */       for (j = (arrayOfString = this.logicalZipFile.bundleClassPathManifestEntryValue.split(",")).length, b1 = 0; b1 < j; ) { String str2 = arrayOfString[b1];
/*     */         
/* 274 */         while (str2.startsWith("/")) {
/* 275 */           str2 = str2.substring(1);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 281 */         if (!str2.isEmpty() && !str2.equals(".")) {
/*     */           
/* 283 */           str2 = str1 + FileUtils.sanitizeEntryPath(str2, true, true);
/*     */ 
/*     */           
/* 286 */           if (hashSet.add(str2))
/*     */           {
/* 288 */             paramWorkQueue.addWorkUnit(new Scanner.ClasspathEntryWorkUnit(str2, getClassLoader(), this, b++, ""));
/*     */           }
/*     */         } 
/*     */         b1++; }
/*     */     
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
/*     */   private Resource newResource(final FastZipEntry zipEntry, final String pathRelativeToPackageRoot) {
/* 308 */     return new Resource(this, zipEntry.uncompressedSize)
/*     */       {
/* 310 */         private final AtomicBoolean isOpen = new AtomicBoolean();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public String getPath() {
/* 318 */           return pathRelativeToPackageRoot;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getPathRelativeToClasspathElement() {
/* 323 */           if (zipEntry.entryName.startsWith(ClasspathElementZip.this.packageRootPrefix)) {
/* 324 */             return zipEntry.entryName.substring(ClasspathElementZip.this.packageRootPrefix.length());
/*     */           }
/* 326 */           return zipEntry.entryName;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public long getLastModified() {
/* 332 */           return zipEntry.getLastModifiedTimeMillis();
/*     */         }
/*     */ 
/*     */         
/*     */         public Set<PosixFilePermission> getPosixFilePermissions() {
/*     */           HashSet<PosixFilePermission> hashSet;
/*     */           int i;
/* 339 */           if ((i = zipEntry.fileAttributes) == 0) {
/* 340 */             hashSet = null;
/*     */           } else {
/* 342 */             hashSet = new HashSet();
/* 343 */             if ((i & 0x100) > 0) {
/* 344 */               hashSet.add(PosixFilePermission.OWNER_READ);
/*     */             }
/* 346 */             if ((i & 0x80) > 0) {
/* 347 */               hashSet.add(PosixFilePermission.OWNER_WRITE);
/*     */             }
/* 349 */             if ((i & 0x40) > 0) {
/* 350 */               hashSet.add(PosixFilePermission.OWNER_EXECUTE);
/*     */             }
/* 352 */             if ((i & 0x20) > 0) {
/* 353 */               hashSet.add(PosixFilePermission.GROUP_READ);
/*     */             }
/* 355 */             if ((i & 0x10) > 0) {
/* 356 */               hashSet.add(PosixFilePermission.GROUP_WRITE);
/*     */             }
/* 358 */             if ((i & 0x8) > 0) {
/* 359 */               hashSet.add(PosixFilePermission.GROUP_EXECUTE);
/*     */             }
/* 361 */             if ((i & 0x4) > 0) {
/* 362 */               hashSet.add(PosixFilePermission.OTHERS_READ);
/*     */             }
/* 364 */             if ((i & 0x2) > 0) {
/* 365 */               hashSet.add(PosixFilePermission.OTHERS_WRITE);
/*     */             }
/* 367 */             if ((i & 0x1) > 0) {
/* 368 */               hashSet.add(PosixFilePermission.OTHERS_EXECUTE);
/*     */             }
/*     */           } 
/* 371 */           return hashSet;
/*     */         }
/*     */ 
/*     */         
/*     */         ClassfileReader openClassfile() {
/* 376 */           return new ClassfileReader(open(), this);
/*     */         }
/*     */ 
/*     */         
/*     */         public InputStream open() {
/* 381 */           if (ClasspathElementZip.this.skipClasspathElement)
/*     */           {
/* 383 */             throw new IOException("Jarfile could not be opened");
/*     */           }
/* 385 */           if (this.isOpen.getAndSet(true)) {
/* 386 */             throw new IOException("Resource is already open -- cannot open it again without first calling close()");
/*     */           }
/*     */           
/*     */           try {
/* 390 */             this.inputStream = zipEntry.getSlice().open(this);
/* 391 */             this.length = zipEntry.uncompressedSize;
/* 392 */             return this.inputStream;
/*     */           }
/* 394 */           catch (IOException iOException) {
/* 395 */             close();
/* 396 */             throw iOException;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public ByteBuffer read() {
/* 402 */           if (ClasspathElementZip.this.skipClasspathElement)
/*     */           {
/* 404 */             throw new IOException("Jarfile could not be opened");
/*     */           }
/* 406 */           if (this.isOpen.getAndSet(true)) {
/* 407 */             throw new IOException("Resource is already open -- cannot open it again without first calling close()");
/*     */           }
/*     */           
/*     */           try {
/* 411 */             this.byteBuffer = zipEntry.getSlice().read();
/* 412 */             this.length = this.byteBuffer.remaining();
/* 413 */             return this.byteBuffer;
/* 414 */           } catch (IOException iOException) {
/* 415 */             close();
/* 416 */             throw iOException;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public byte[] load() {
/* 422 */           if (ClasspathElementZip.this.skipClasspathElement)
/*     */           {
/* 424 */             throw new IOException("Jarfile could not be opened");
/*     */           }
/* 426 */           if (this.isOpen.getAndSet(true)) {
/* 427 */             throw new IOException("Resource is already open -- cannot open it again without first calling close()");
/*     */           }
/*     */           
/* 430 */           null  = this; Throwable throwable2 = null; 
/* 431 */           try { byte[] arrayOfByte = zipEntry.getSlice().load();
/* 432 */             .length = arrayOfByte.length;
/* 433 */             arrayOfByte = arrayOfByte; return arrayOfByte; } catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/* 434 */           finally { if (throwable2 != null) { try { throwable1.close(); } catch (Throwable throwable) { throwable2.addSuppressed(throwable); }  } else { throwable.close(); }
/*     */              }
/*     */         
/*     */         }
/*     */         public void close() {
/* 439 */           if (this.isOpen.getAndSet(false)) {
/* 440 */             if (this.byteBuffer != null)
/*     */             {
/*     */               
/* 443 */               this.byteBuffer = null;
/*     */             }
/*     */ 
/*     */             
/* 447 */             super.close();
/*     */           } 
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
/*     */   
/*     */   Resource getResource(String paramString) {
/* 463 */     return this.relativePathToResource.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void scanPaths(LogNode paramLogNode) {
/* 474 */     if (this.logicalZipFile == null) {
/* 475 */       this.skipClasspathElement = true;
/*     */     }
/* 477 */     if (!checkResourcePathAcceptReject(getZipFilePath(), paramLogNode)) {
/* 478 */       this.skipClasspathElement = true;
/*     */     }
/* 480 */     if (this.skipClasspathElement) {
/*     */       return;
/*     */     }
/* 483 */     if (this.scanned.getAndSet(true))
/*     */     {
/* 485 */       throw new IllegalArgumentException("Already scanned classpath element " + getZipFilePath());
/*     */     }
/*     */ 
/*     */     
/* 489 */     LogNode logNode = (paramLogNode == null) ? null : log(this.classpathElementIdx, "Scanning jarfile classpath element " + getZipFilePath(), paramLogNode);
/*     */     
/* 491 */     boolean bool = false;
/* 492 */     if (VersionFinder.JAVA_MAJOR_VERSION >= 9) {
/*     */       String str1;
/*     */       
/* 495 */       if ((str1 = this.moduleNameFromModuleDescriptor) == null || str1.isEmpty()) {
/* 496 */         str1 = this.moduleNameFromManifestFile;
/*     */       }
/* 498 */       if (str1 != null && str1.isEmpty()) {
/* 499 */         str1 = null;
/*     */       }
/* 501 */       if (str1 != null) {
/* 502 */         bool = true;
/*     */       }
/*     */     } 
/*     */     
/* 506 */     HashSet<String> hashSet = null;
/* 507 */     String str = null;
/* 508 */     Object object = null;
/* 509 */     Iterator<FastZipEntry> iterator = this.logicalZipFile.entries.iterator(); label105: while (true) { FastZipEntry fastZipEntry; String str1; while (true) { if (iterator.hasNext()) {
/* 510 */           str1 = (fastZipEntry = iterator.next()).entryNameUnversioned;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 516 */           if (!this.scanSpec.enableMultiReleaseVersions && str1
/* 517 */             .startsWith("META-INF/versions/")) {
/* 518 */             if (logNode != null) {
/* 519 */               if (VersionFinder.JAVA_MAJOR_VERSION < 9) {
/* 520 */                 logNode.log("Skipping versioned entry in jar, because JRE version " + VersionFinder.JAVA_MAJOR_VERSION + " does not support this: " + str1);
/*     */                 continue;
/*     */               } 
/* 523 */               logNode.log("Found unexpected versioned entry in jar (the jar's manifest file may be missing the \"Multi-Release\" key) -- skipping: " + str1);
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/*     */             continue;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 533 */           if (!bool || str1.indexOf('/') >= 0 || !str1.endsWith(".class") || str1
/* 534 */             .equals("module-info.class")) {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 539 */             if (this.nestedClasspathRootPrefixes != null) {
/*     */               
/* 541 */               boolean bool1 = false;
/* 542 */               for (String str2 : this.nestedClasspathRootPrefixes) {
/* 543 */                 if (str1.startsWith(str2)) {
/*     */                   
/* 545 */                   if (logNode != null) {
/* 546 */                     if (hashSet == null) {
/* 547 */                       hashSet = new HashSet();
/*     */                     }
/* 549 */                     if (hashSet.add(str2)) {
/* 550 */                       logNode.log("Reached nested classpath root, stopping recursion to avoid duplicate scanning: " + str2);
/*     */                     }
/*     */                   } 
/*     */                   
/* 554 */                   bool1 = true;
/*     */                   break;
/*     */                 } 
/*     */               } 
/* 558 */               if (!bool1)
/*     */                 break;  continue;
/*     */             }  break;
/*     */           }  continue;
/*     */         }  break label105; }
/*     */       
/* 564 */       if (this.packageRootPrefix.isEmpty() || str1.startsWith(this.packageRootPrefix)) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 569 */         if (!this.packageRootPrefix.isEmpty()) {
/* 570 */           str1 = str1.substring(this.packageRootPrefix.length());
/*     */         } else {
/*     */           
/* 573 */           for (byte b = 0; b < ClassLoaderHandlerRegistry.AUTOMATIC_PACKAGE_ROOT_PREFIXES.length; b++) {
/* 574 */             String str2 = ClassLoaderHandlerRegistry.AUTOMATIC_PACKAGE_ROOT_PREFIXES[b];
/* 575 */             if (str1.startsWith(str2)) {
/*     */               
/* 577 */               str1 = str1.substring(str2.length());
/*     */ 
/*     */               
/* 580 */               String str3 = str2.endsWith("/") ? str2.substring(0, str2.length() - 1) : str2;
/*     */ 
/*     */               
/* 583 */               this.strippedAutomaticPackageRootPrefixes.add(str3);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 589 */         if (checkResourcePathAcceptReject(str1, paramLogNode)) {
/*     */           String str2;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           boolean bool1;
/*     */ 
/*     */ 
/*     */           
/* 599 */           int j = (bool1 = !(str2 = ((j = str1.lastIndexOf('/')) < 0) ? "/" : str1.substring(0, j + 1)).equals(str) ? true : false) ? this.scanSpec.dirAcceptMatchStatus(str2) : object;
/*     */           
/* 601 */           str = str2;
/* 602 */           int i = j;
/*     */           
/* 604 */           if (j == ScanSpec.ScanSpecPathMatch.HAS_REJECTED_PATH_PREFIX) {
/*     */             
/* 606 */             if (logNode != null) {
/* 607 */               logNode.log("Skipping rejected path: " + str1);
/*     */             }
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/* 613 */           Resource resource = newResource(fastZipEntry, str1);
/* 614 */           if (this.relativePathToResource.putIfAbsent(str1, resource) == null) {
/*     */             
/* 616 */             if (j == ScanSpec.ScanSpecPathMatch.HAS_ACCEPTED_PATH_PREFIX || j == ScanSpec.ScanSpecPathMatch.AT_ACCEPTED_PATH || (j == ScanSpec.ScanSpecPathMatch.AT_ACCEPTED_CLASS_PACKAGE && this.scanSpec
/*     */ 
/*     */               
/* 619 */               .classfileIsSpecificallyAccepted(str1))) {
/*     */               
/* 621 */               addAcceptedResource(resource, j, false, logNode); continue;
/* 622 */             }  if (this.scanSpec.enableClassInfo && str1.equals("module-info.class"))
/*     */             {
/*     */ 
/*     */               
/* 626 */               addAcceptedResource(resource, j, true, logNode);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }  }
/*     */     
/*     */     File file;
/* 633 */     if ((file = getFile()) != null) {
/* 634 */       this.fileToLastModified.put(file, Long.valueOf(file.lastModified()));
/*     */     }
/*     */     
/* 637 */     finishScanPaths(logNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModuleName() {
/*     */     String str;
/* 649 */     if ((str = this.moduleNameFromModuleDescriptor) == null || str.isEmpty()) {
/* 650 */       str = this.moduleNameFromManifestFile;
/*     */     }
/* 652 */     if (str == null || str.isEmpty()) {
/* 653 */       if (this.derivedAutomaticModuleName == null) {
/* 654 */         this.derivedAutomaticModuleName = JarUtils.derivedAutomaticModuleName(this.zipFilePath);
/*     */       }
/* 656 */       str = this.derivedAutomaticModuleName;
/*     */     } 
/* 658 */     return (str == null || str.isEmpty()) ? null : str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getZipFilePath() {
/* 667 */     return this.packageRootPrefix.isEmpty() ? this.zipFilePath : (this.zipFilePath + "!/" + this.packageRootPrefix
/* 668 */       .substring(0, this.packageRootPrefix.length() - 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   URI getURI() {
/*     */     try {
/* 677 */       return new URI(URLPathEncoder.normalizeURLPath(getZipFilePath()));
/* 678 */     } catch (URISyntaxException uRISyntaxException) {
/* 679 */       throw new IllegalArgumentException("Could not form URI: " + uRISyntaxException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List<URI> getAllURIs() {
/* 689 */     if (this.strippedAutomaticPackageRootPrefixes.isEmpty()) {
/* 690 */       return Collections.singletonList(getURI());
/*     */     }
/* 692 */     URI uRI = getURI();
/*     */     ArrayList<URI> arrayList;
/* 694 */     (arrayList = new ArrayList<>()).add(uRI);
/* 695 */     String str = uRI.toString();
/* 696 */     for (String str1 : this.strippedAutomaticPackageRootPrefixes) {
/*     */       try {
/* 698 */         arrayList.add(new URI(str + "!/" + str1));
/* 699 */       } catch (URISyntaxException uRISyntaxException) {}
/*     */     } 
/*     */ 
/*     */     
/* 703 */     return arrayList;
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
/*     */   File getFile() {
/* 716 */     if (this.logicalZipFile != null) {
/* 717 */       return this.logicalZipFile.getPhysicalFile();
/*     */     }
/*     */     
/* 720 */     int i = this.rawPath.indexOf('!');
/* 721 */     String str = FastPathResolver.resolve(FileUtils.currDirPath(), (i < 0) ? this.rawPath : this.rawPath
/* 722 */         .substring(0, i));
/* 723 */     return new File(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 734 */     return getZipFilePath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 742 */     if (paramObject == this)
/* 743 */       return true; 
/* 744 */     if (!(paramObject instanceof ClasspathElementZip)) {
/* 745 */       return false;
/*     */     }
/* 747 */     paramObject = paramObject;
/* 748 */     return getZipFilePath().equals(paramObject.getZipFilePath());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 756 */     return getZipFilePath().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClasspathElementZip.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */