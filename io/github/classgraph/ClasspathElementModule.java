/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.file.attribute.PosixFilePermission;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import nonapi.io.github.classgraph.concurrency.SingletonMap;
/*     */ import nonapi.io.github.classgraph.concurrency.WorkQueue;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.ClassfileReader;
/*     */ import nonapi.io.github.classgraph.recycler.RecycleOnClose;
/*     */ import nonapi.io.github.classgraph.recycler.Recycler;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.CollectionUtils;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
/*     */ import nonapi.io.github.classgraph.utils.ProxyingInputStream;
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
/*     */ class ClasspathElementModule
/*     */   extends ClasspathElement
/*     */ {
/*     */   final ModuleRef moduleRef;
/*     */   SingletonMap<ModuleRef, Recycler<ModuleReaderProxy, IOException>, IOException> moduleRefToModuleReaderProxyRecyclerMap;
/*     */   private Recycler<ModuleReaderProxy, IOException> moduleReaderProxyRecycler;
/*  77 */   private final Set<String> allResourcePaths = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ClasspathElementModule(ModuleRef paramModuleRef, SingletonMap<ModuleRef, Recycler<ModuleReaderProxy, IOException>, IOException> paramSingletonMap, Scanner.ClasspathEntryWorkUnit paramClasspathEntryWorkUnit, ScanSpec paramScanSpec) {
/*  95 */     super(paramClasspathEntryWorkUnit, paramScanSpec);
/*  96 */     this.moduleRefToModuleReaderProxyRecyclerMap = paramSingletonMap;
/*  97 */     this.moduleRef = paramModuleRef;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void open(WorkQueue<Scanner.ClasspathEntryWorkUnit> paramWorkQueue, LogNode paramLogNode) {
/* 107 */     if (!this.scanSpec.scanModules) {
/* 108 */       if (paramLogNode != null) {
/* 109 */         log(this.classpathElementIdx, "Skipping module, since module scanning is disabled: " + getModuleName(), paramLogNode);
/*     */       }
/*     */       
/* 112 */       this.skipClasspathElement = true;
/*     */       return;
/*     */     } 
/*     */     try {
/* 116 */       this.moduleReaderProxyRecycler = (Recycler<ModuleReaderProxy, IOException>)this.moduleRefToModuleReaderProxyRecyclerMap.get(this.moduleRef, paramLogNode); return;
/* 117 */     } catch (IOException|nonapi.io.github.classgraph.concurrency.SingletonMap.NullSingletonException|nonapi.io.github.classgraph.concurrency.SingletonMap.NewInstanceException iOException) {
/* 118 */       if (paramLogNode != null) {
/* 119 */         log(this.classpathElementIdx, "Skipping invalid module " + getModuleName() + " : " + (
/* 120 */             (iOException.getCause() == null) ? (String)iOException : (String)iOException.getCause()), paramLogNode);
/*     */       }
/* 122 */       this.skipClasspathElement = true;
/*     */       return;
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
/*     */   private Resource newResource(final String resourcePath) {
/* 135 */     return new Resource(this, -1L)
/*     */       {
/*     */         private ModuleReaderProxy moduleReaderProxy;
/*     */ 
/*     */         
/* 140 */         private final AtomicBoolean isOpen = new AtomicBoolean();
/*     */ 
/*     */         
/*     */         public String getPath() {
/* 144 */           return resourcePath;
/*     */         }
/*     */ 
/*     */         
/*     */         public long getLastModified() {
/* 149 */           return 0L;
/*     */         }
/*     */ 
/*     */         
/*     */         public Set<PosixFilePermission> getPosixFilePermissions() {
/* 154 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public ByteBuffer read() {
/* 159 */           if (ClasspathElementModule.this.skipClasspathElement)
/*     */           {
/* 161 */             throw new IOException("Module could not be opened");
/*     */           }
/* 163 */           if (this.isOpen.getAndSet(true)) {
/* 164 */             throw new IOException("Resource is already open -- cannot open it again without first calling close()");
/*     */           }
/*     */           
/*     */           try {
/* 168 */             this.moduleReaderProxy = (ModuleReaderProxy)ClasspathElementModule.this.moduleReaderProxyRecycler.acquire();
/*     */ 
/*     */             
/* 171 */             this.byteBuffer = this.moduleReaderProxy.read(resourcePath);
/* 172 */             this.length = this.byteBuffer.remaining();
/* 173 */             return this.byteBuffer;
/*     */           }
/* 175 */           catch (SecurityException|OutOfMemoryError securityException) {
/* 176 */             close();
/* 177 */             throw new IOException("Could not open " + this, securityException);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         ClassfileReader openClassfile() {
/* 183 */           return new ClassfileReader(open(), this);
/*     */         }
/*     */ 
/*     */         
/*     */         public URI getURI() {
/*     */           try {
/* 189 */             ModuleReaderProxy moduleReaderProxy = (ModuleReaderProxy)ClasspathElementModule.this.moduleReaderProxyRecycler.acquire();
/*     */             try {
/* 191 */               return moduleReaderProxy.find(resourcePath);
/*     */             } finally {
/* 193 */               ClasspathElementModule.this.moduleReaderProxyRecycler.recycle(moduleReaderProxy);
/*     */             } 
/* 195 */           } catch (IOException iOException) {
/* 196 */             throw new RuntimeException(iOException);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public InputStream open() {
/* 202 */           if (ClasspathElementModule.this.skipClasspathElement)
/*     */           {
/* 204 */             throw new IOException("Module could not be opened");
/*     */           }
/* 206 */           if (this.isOpen.getAndSet(true)) {
/* 207 */             throw new IOException("Resource is already open -- cannot open it again without first calling close()");
/*     */           }
/*     */           
/*     */           try {
/* 211 */             final null thisResource = this;
/* 212 */             this.moduleReaderProxy = (ModuleReaderProxy)ClasspathElementModule.this.moduleReaderProxyRecycler.acquire();
/* 213 */             this.inputStream = (InputStream)new ProxyingInputStream(this.moduleReaderProxy.open(resourcePath))
/*     */               {
/*     */                 public void close()
/*     */                 {
/* 217 */                   super.close();
/*     */ 
/*     */                   
/*     */                   try {
/* 221 */                     thisResource.close(); return;
/* 222 */                   } catch (Exception exception) {
/*     */                     return;
/*     */                   } 
/*     */                 }
/*     */               };
/*     */             
/* 228 */             this.length = -1L;
/* 229 */             return this.inputStream;
/*     */           }
/* 231 */           catch (SecurityException securityException) {
/* 232 */             close();
/* 233 */             throw new IOException("Could not open " + this, securityException);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public byte[] load() {
/* 239 */           null  = this; Throwable throwable2 = null; 
/* 240 */           try { read();
/*     */             
/* 242 */             if (.byteBuffer.hasArray() && .byteBuffer.position() == 0 && .byteBuffer
/* 243 */               .limit() == .byteBuffer.capacity()) {
/* 244 */               arrayOfByte = .byteBuffer.array();
/*     */             } else {
/* 246 */               arrayOfByte = new byte[.byteBuffer.remaining()];
/* 247 */               .byteBuffer.get(arrayOfByte);
/*     */             } 
/* 249 */             .length = arrayOfByte.length;
/* 250 */             byte[] arrayOfByte = arrayOfByte; return arrayOfByte; } catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/* 251 */           finally { if (throwable2 != null) { try { throwable1.close(); } catch (Throwable throwable) { throwable2.addSuppressed(throwable); }  } else { throwable.close(); }
/*     */              }
/*     */         
/*     */         }
/*     */         public void close() {
/* 256 */           if (this.isOpen.getAndSet(false)) {
/* 257 */             if (this.moduleReaderProxy != null) {
/* 258 */               if (this.byteBuffer != null) {
/*     */                 
/* 260 */                 this.moduleReaderProxy.release(this.byteBuffer);
/* 261 */                 this.byteBuffer = null;
/*     */               } 
/*     */               
/* 264 */               ClasspathElementModule.this.moduleReaderProxyRecycler.recycle(this.moduleReaderProxy);
/*     */ 
/*     */ 
/*     */               
/* 268 */               this.moduleReaderProxy = null;
/*     */             } 
/*     */ 
/*     */             
/* 272 */             super.close();
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
/* 288 */     return this.allResourcePaths.contains(paramString) ? newResource(paramString) : null;
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
/* 299 */     if (this.skipClasspathElement) {
/*     */       return;
/*     */     }
/* 302 */     if (this.scanned.getAndSet(true))
/*     */     {
/* 304 */       throw new IllegalArgumentException("Already scanned classpath element " + this);
/*     */     }
/*     */ 
/*     */     
/* 308 */     LogNode logNode = (paramLogNode == null) ? null : log(this.classpathElementIdx, "Scanning module " + this.moduleRef.getName(), paramLogNode);
/*     */ 
/*     */     
/* 311 */     boolean bool = (VersionFinder.JAVA_MAJOR_VERSION >= 9 && getModuleName() != null) ? true : false;
/*     */ 
/*     */     
/* 314 */     try (RecycleOnClose null = this.moduleReaderProxyRecycler.acquireRecycleOnClose()) {
/*     */       List<String> list;
/*     */       
/*     */       try {
/* 318 */         list = ((ModuleReaderProxy)recycleOnClose.get()).list();
/* 319 */       } catch (SecurityException securityException) {
/* 320 */         if (logNode != null) {
/* 321 */           logNode.log("Could not get resource list for module " + this.moduleRef.getName(), securityException);
/*     */         }
/*     */         return;
/*     */       } 
/* 325 */       CollectionUtils.sortIfNotEmpty(list);
/*     */       
/* 327 */       String str = null;
/* 328 */       Object object = null;
/* 329 */       for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 338 */         if (!(str1 = iterator.next()).endsWith("/")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 347 */           if (!this.scanSpec.enableMultiReleaseVersions && str1
/* 348 */             .startsWith("META-INF/versions/")) {
/* 349 */             if (logNode != null) {
/* 350 */               logNode.log("Found unexpected nested versioned entry in module -- skipping: " + str1);
/*     */             }
/*     */ 
/*     */             
/*     */             continue;
/*     */           } 
/*     */ 
/*     */           
/* 358 */           if (!bool || str1.indexOf('/') >= 0 || !str1.endsWith(".class") || str1
/* 359 */             .equals("module-info.class"))
/*     */           {
/*     */ 
/*     */ 
/*     */             
/* 364 */             if (checkResourcePathAcceptReject(str1, paramLogNode)) {
/*     */               String str2;
/*     */ 
/*     */ 
/*     */               
/*     */               int i;
/*     */ 
/*     */ 
/*     */               
/* 373 */               boolean bool2 = !(str2 = ((i = str1.lastIndexOf('/')) < 0) ? "/" : str1.substring(0, i + 1)).equals(str) ? true : false;
/*     */ 
/*     */               
/* 376 */               bool2 = (str == null || bool2) ? this.scanSpec.dirAcceptMatchStatus(str2) : object;
/*     */               
/* 378 */               str = str2;
/* 379 */               boolean bool1 = bool2;
/*     */               
/* 381 */               if (bool2 == ScanSpec.ScanSpecPathMatch.HAS_REJECTED_PATH_PREFIX) {
/*     */                 
/* 383 */                 if (logNode != null) {
/* 384 */                   logNode.log("Skipping rejected path: " + str1);
/*     */                 }
/*     */                 
/*     */                 continue;
/*     */               } 
/*     */               
/* 390 */               if (this.allResourcePaths.add(str1)) {
/*     */                 
/* 392 */                 if (bool2 == ScanSpec.ScanSpecPathMatch.HAS_ACCEPTED_PATH_PREFIX || bool2 == ScanSpec.ScanSpecPathMatch.AT_ACCEPTED_PATH || (bool2 == ScanSpec.ScanSpecPathMatch.AT_ACCEPTED_CLASS_PACKAGE && this.scanSpec
/*     */ 
/*     */                   
/* 395 */                   .classfileIsSpecificallyAccepted(str1))) {
/*     */                   
/* 397 */                   addAcceptedResource(newResource(str1), bool2, false, logNode); continue;
/*     */                 } 
/* 399 */                 if (this.scanSpec.enableClassInfo && str1.equals("module-info.class"))
/*     */                 {
/*     */ 
/*     */                   
/* 403 */                   addAcceptedResource(newResource(str1), bool2, true, logNode);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */       File file;
/* 411 */       if ((file = this.moduleRef.getLocationFile()) != null && file.exists()) {
/* 412 */         this.fileToLastModified.put(file, Long.valueOf(file.lastModified()));
/*     */       }
/*     */     }
/* 415 */     catch (IOException iOException) {
/* 416 */       if (logNode != null) {
/* 417 */         logNode.log("Exception opening module " + this.moduleRef.getName(), iOException);
/*     */       }
/* 419 */       this.skipClasspathElement = true;
/*     */     } 
/*     */     
/* 422 */     finishScanPaths(logNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ModuleRef getModuleRef() {
/* 431 */     return this.moduleRef;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModuleName() {
/*     */     String str;
/* 442 */     if ((str = this.moduleRef.getName()) == null || str.isEmpty()) {
/* 443 */       str = this.moduleNameFromModuleDescriptor;
/*     */     }
/* 445 */     return (str == null || str.isEmpty()) ? null : str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getModuleNameOrEmpty() {
/*     */     String str;
/* 455 */     return ((str = getModuleName()) == null) ? "" : str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   URI getURI() {
/*     */     URI uRI;
/* 464 */     if ((uRI = this.moduleRef.getLocation()) == null)
/*     */     {
/* 466 */       throw new IllegalArgumentException("Module " + getModuleName() + " has a null location");
/*     */     }
/* 468 */     return uRI;
/*     */   }
/*     */ 
/*     */   
/*     */   List<URI> getAllURIs() {
/* 473 */     return Collections.singletonList(getURI());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   File getFile() {
/*     */     try {
/*     */       URI uRI;
/*     */       File file;
/* 483 */       if ((uRI = this.moduleRef.getLocation()) != null && !uRI.getScheme().equals("jrt") && (
/*     */         
/* 485 */         file = new File(uRI)).exists()) {
/* 486 */         return file;
/*     */       }
/*     */     }
/* 489 */     catch (Exception exception) {}
/*     */ 
/*     */     
/* 492 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 502 */     return this.moduleRef.toString();
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
/*     */   public boolean equals(Object paramObject) {
/* 517 */     if (paramObject == this)
/* 518 */       return true; 
/* 519 */     if (!(paramObject instanceof ClasspathElementModule)) {
/* 520 */       return false;
/*     */     }
/* 522 */     paramObject = paramObject;
/* 523 */     return getModuleNameOrEmpty().equals(paramObject.getModuleNameOrEmpty());
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
/*     */   public int hashCode() {
/* 536 */     return getModuleNameOrEmpty().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClasspathElementModule.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */