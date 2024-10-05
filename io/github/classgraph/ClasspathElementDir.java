/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOError;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.file.DirectoryStream;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.attribute.BasicFileAttributes;
/*     */ import java.nio.file.attribute.PosixFileAttributes;
/*     */ import java.nio.file.attribute.PosixFilePermission;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import nonapi.io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry;
/*     */ import nonapi.io.github.classgraph.concurrency.WorkQueue;
/*     */ import nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler;
/*     */ import nonapi.io.github.classgraph.fileslice.PathSlice;
/*     */ import nonapi.io.github.classgraph.fileslice.Slice;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.ClassfileReader;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
/*     */ import nonapi.io.github.classgraph.utils.FastPathResolver;
/*     */ import nonapi.io.github.classgraph.utils.FileUtils;
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
/*     */ class ClasspathElementDir
/*     */   extends ClasspathElement
/*     */ {
/*     */   private final Path classpathEltPath;
/*  72 */   private final Set<Path> scannedCanonicalPaths = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final NestedJarHandler nestedJarHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ClasspathElementDir(Scanner.ClasspathEntryWorkUnit paramClasspathEntryWorkUnit, NestedJarHandler paramNestedJarHandler, ScanSpec paramScanSpec) {
/*  89 */     super(paramClasspathEntryWorkUnit, paramScanSpec);
/*  90 */     this.classpathEltPath = (Path)paramClasspathEntryWorkUnit.classpathEntryObj;
/*  91 */     this.nestedJarHandler = paramNestedJarHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void open(WorkQueue<Scanner.ClasspathEntryWorkUnit> paramWorkQueue, LogNode paramLogNode) {
/* 100 */     if (!this.scanSpec.scanDirs) {
/* 101 */       if (paramLogNode != null) {
/* 102 */         log(this.classpathElementIdx, "Skipping classpath element, since dir scanning is disabled: " + this.classpathEltPath, paramLogNode);
/*     */       }
/*     */       
/* 105 */       this.skipClasspathElement = true;
/*     */       
/*     */       return;
/*     */     } 
/*     */     try {
/* 110 */       byte b1 = 0; String[] arrayOfString; int i; byte b2;
/* 111 */       for (i = (arrayOfString = ClassLoaderHandlerRegistry.AUTOMATIC_LIB_DIR_PREFIXES).length, b2 = 0; b2 < i; ) { String str = arrayOfString[b2];
/*     */         Path path;
/* 113 */         if (FileUtils.canReadAndIsDir(path = this.classpathEltPath.resolve(str))) {
/*     */           try {
/* 115 */             Throwable throwable; DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, new DirectoryStream.Filter<Path>()
/*     */                 {
/*     */                   public boolean accept(Path param1Path) {
/* 118 */                     return (param1Path.toString().toLowerCase().endsWith(".jar") && Files.isRegularFile(param1Path, new java.nio.file.LinkOption[0]));
/*     */                   }
/*     */                 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             path = null;
/* 130 */           } catch (IOException iOException) {}
/*     */         }
/*     */         
/*     */         b2++; }
/*     */ 
/*     */       
/* 136 */       if (this.packageRootPrefix.isEmpty()) {
/* 137 */         for (i = (arrayOfString = ClassLoaderHandlerRegistry.AUTOMATIC_PACKAGE_ROOT_PREFIXES).length, b2 = 0; b2 < i; ) { String str = arrayOfString[b2];
/*     */           Path path;
/* 139 */           if (FileUtils.canReadAndIsDir(path = this.classpathEltPath.resolve(str))) {
/* 140 */             if (paramLogNode != null) {
/* 141 */               log(this.classpathElementIdx, "Found package root: " + str, paramLogNode);
/*     */             }
/* 143 */             paramWorkQueue.addWorkUnit(new Scanner.ClasspathEntryWorkUnit(path, getClassLoader(), this, b1++, str));
/*     */           } 
/*     */           
/*     */           b2++; }
/*     */       
/*     */       }
/*     */       return;
/* 150 */     } catch (SecurityException securityException) {
/* 151 */       if (paramLogNode != null) {
/* 152 */         log(this.classpathElementIdx, "Skipping classpath element, since dir cannot be accessed: " + this.classpathEltPath, paramLogNode);
/*     */       }
/*     */       
/* 155 */       this.skipClasspathElement = true;
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
/*     */   private Resource newResource(final Path resourcePath, final BasicFileAttributes attributes) {
/* 168 */     return new Resource(this, (attributes == null) ? -2L : attributes.size())
/*     */       {
/*     */         private PathSlice pathSlice;
/*     */ 
/*     */         
/* 173 */         private final AtomicBoolean isOpen = new AtomicBoolean();
/*     */ 
/*     */         
/*     */         public long getLength() {
/* 177 */           if (this.length == -2L) {
/*     */             try {
/* 179 */               this.length = Files.size(resourcePath);
/* 180 */             } catch (IOException|SecurityException iOException) {
/* 181 */               this.length = -1L;
/*     */             } 
/*     */           }
/* 184 */           return this.length;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getPath() {
/* 189 */           String str = FastPathResolver.resolve(ClasspathElementDir.this.classpathEltPath.relativize(resourcePath).toString());
/* 190 */           while (str.startsWith("/")) {
/* 191 */             str = str.substring(1);
/*     */           }
/* 193 */           return str;
/*     */         }
/*     */ 
/*     */         
/*     */         public String getPathRelativeToClasspathElement() {
/* 198 */           return ClasspathElementDir.this.packageRootPrefix.isEmpty() ? getPath() : (ClasspathElementDir.this.packageRootPrefix + getPath());
/*     */         }
/*     */ 
/*     */         
/*     */         public long getLastModified() {
/*     */           try {
/* 204 */             return (attributes == null) ? resourcePath.toFile().lastModified() : attributes.lastModifiedTime().toMillis();
/* 205 */           } catch (UnsupportedOperationException unsupportedOperationException) {
/* 206 */             return 0L;
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public Set<PosixFilePermission> getPosixFilePermissions() {
/* 213 */           Set<PosixFilePermission> set = null;
/*     */           try {
/* 215 */             if (attributes instanceof PosixFileAttributes) {
/* 216 */               set = ((PosixFileAttributes)attributes).permissions();
/*     */             } else {
/*     */               
/* 219 */               set = ((PosixFileAttributes)Files.<PosixFileAttributes>readAttributes(resourcePath, PosixFileAttributes.class, new java.nio.file.LinkOption[0])).permissions();
/*     */             } 
/* 221 */           } catch (UnsupportedOperationException|IOException|SecurityException unsupportedOperationException) {}
/*     */ 
/*     */           
/* 224 */           return set;
/*     */         }
/*     */ 
/*     */         
/*     */         public ByteBuffer read() {
/* 229 */           checkSkipState();
/* 230 */           openAndCreateSlice();
/* 231 */           this.byteBuffer = this.pathSlice.read();
/* 232 */           return this.byteBuffer;
/*     */         }
/*     */ 
/*     */         
/*     */         ClassfileReader openClassfile() {
/* 237 */           checkSkipState();
/*     */           
/* 239 */           openAndCreateSlice();
/* 240 */           return new ClassfileReader((Slice)this.pathSlice, this);
/*     */         }
/*     */ 
/*     */         
/*     */         public InputStream open() {
/* 245 */           checkSkipState();
/* 246 */           openAndCreateSlice();
/* 247 */           this.inputStream = this.pathSlice.open(this);
/* 248 */           return this.inputStream;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte[] load() {
/* 253 */           checkSkipState();
/*     */           try {
/* 255 */             openAndCreateSlice();
/* 256 */             return this.pathSlice.load();
/*     */           } finally {
/* 258 */             close();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void close() {
/* 264 */           if (this.isOpen.getAndSet(false)) {
/* 265 */             if (this.byteBuffer != null)
/*     */             {
/* 267 */               this.byteBuffer = null;
/*     */             }
/* 269 */             if (this.pathSlice != null) {
/* 270 */               this.pathSlice.close();
/* 271 */               ClasspathElementDir.this.nestedJarHandler.markSliceAsClosed((Slice)this.pathSlice);
/* 272 */               this.pathSlice = null;
/*     */             } 
/*     */ 
/*     */             
/* 276 */             super.close();
/*     */           } 
/*     */         }
/*     */         
/*     */         private void checkSkipState() {
/* 281 */           if (ClasspathElementDir.this.skipClasspathElement)
/*     */           {
/* 283 */             throw new IOException("Parent directory could not be opened");
/*     */           }
/*     */         }
/*     */         
/*     */         private void openAndCreateSlice() {
/* 288 */           if (this.isOpen.getAndSet(true)) {
/* 289 */             throw new IOException("Resource is already open -- cannot open it again without first calling close()");
/*     */           }
/*     */           
/* 292 */           this.pathSlice = new PathSlice(resourcePath, false, 0L, ClasspathElementDir.this.nestedJarHandler, false);
/* 293 */           this.length = this.pathSlice.sliceLength;
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
/*     */     Path path;
/* 309 */     return FileUtils.canReadAndIsFile(path = this.classpathEltPath.resolve(paramString)) ? newResource(path, (BasicFileAttributes)null) : null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void scanPathRecursively(Path paramPath, LogNode paramLogNode) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: iconst_0
/*     */     //   2: anewarray java/nio/file/LinkOption
/*     */     //   5: invokeinterface toRealPath : ([Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;
/*     */     //   10: astore_3
/*     */     //   11: aload_0
/*     */     //   12: getfield scannedCanonicalPaths : Ljava/util/Set;
/*     */     //   15: aload_3
/*     */     //   16: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   21: ifne -> 50
/*     */     //   24: aload_2
/*     */     //   25: ifnull -> 49
/*     */     //   28: aload_2
/*     */     //   29: new java/lang/StringBuilder
/*     */     //   32: dup
/*     */     //   33: ldc 'Reached symlink cycle, stopping recursion: '
/*     */     //   35: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   38: aload_1
/*     */     //   39: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   42: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   45: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   48: pop
/*     */     //   49: return
/*     */     //   50: goto -> 83
/*     */     //   53: astore #4
/*     */     //   55: aload_2
/*     */     //   56: ifnull -> 82
/*     */     //   59: aload_2
/*     */     //   60: new java/lang/StringBuilder
/*     */     //   63: dup
/*     */     //   64: ldc 'Could not canonicalize path: '
/*     */     //   66: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   69: aload_1
/*     */     //   70: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   73: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   76: aload #4
/*     */     //   78: invokevirtual log : (Ljava/lang/String;Ljava/lang/Throwable;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   81: pop
/*     */     //   82: return
/*     */     //   83: aload_0
/*     */     //   84: getfield classpathEltPath : Ljava/nio/file/Path;
/*     */     //   87: aload_1
/*     */     //   88: invokeinterface relativize : (Ljava/nio/file/Path;)Ljava/nio/file/Path;
/*     */     //   93: invokeinterface toString : ()Ljava/lang/String;
/*     */     //   98: invokestatic resolve : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   101: astore #4
/*     */     //   103: aload #4
/*     */     //   105: ldc '/'
/*     */     //   107: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   110: ifeq -> 124
/*     */     //   113: aload #4
/*     */     //   115: iconst_1
/*     */     //   116: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   119: astore #4
/*     */     //   121: goto -> 103
/*     */     //   124: aload #4
/*     */     //   126: ldc '/'
/*     */     //   128: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   131: ifne -> 156
/*     */     //   134: new java/lang/StringBuilder
/*     */     //   137: dup
/*     */     //   138: invokespecial <init> : ()V
/*     */     //   141: aload #4
/*     */     //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   146: ldc '/'
/*     */     //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   151: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   154: astore #4
/*     */     //   156: aload #4
/*     */     //   158: ldc '/'
/*     */     //   160: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   163: istore #5
/*     */     //   165: aload_0
/*     */     //   166: getfield nestedClasspathRootPrefixes : Ljava/util/List;
/*     */     //   169: ifnull -> 213
/*     */     //   172: aload_0
/*     */     //   173: getfield nestedClasspathRootPrefixes : Ljava/util/List;
/*     */     //   176: aload #4
/*     */     //   178: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   183: ifeq -> 213
/*     */     //   186: aload_2
/*     */     //   187: ifnull -> 212
/*     */     //   190: aload_2
/*     */     //   191: new java/lang/StringBuilder
/*     */     //   194: dup
/*     */     //   195: ldc 'Reached nested classpath root, stopping recursion to avoid duplicate scanning: '
/*     */     //   197: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   200: aload #4
/*     */     //   202: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   205: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   208: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   211: pop
/*     */     //   212: return
/*     */     //   213: aload_0
/*     */     //   214: getfield scanSpec : Lnonapi/io/github/classgraph/scanspec/ScanSpec;
/*     */     //   217: getfield enableMultiReleaseVersions : Z
/*     */     //   220: ifne -> 260
/*     */     //   223: aload #4
/*     */     //   225: ldc 'META-INF/versions/'
/*     */     //   227: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   230: ifeq -> 260
/*     */     //   233: aload_2
/*     */     //   234: ifnull -> 259
/*     */     //   237: aload_2
/*     */     //   238: new java/lang/StringBuilder
/*     */     //   241: dup
/*     */     //   242: ldc 'Found unexpected nested versioned entry in directory classpath element -- skipping: '
/*     */     //   244: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   247: aload #4
/*     */     //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   252: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   255: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   258: pop
/*     */     //   259: return
/*     */     //   260: aload_0
/*     */     //   261: aload #4
/*     */     //   263: aload_2
/*     */     //   264: invokevirtual checkResourcePathAcceptReject : (Ljava/lang/String;Lnonapi/io/github/classgraph/utils/LogNode;)Z
/*     */     //   267: ifne -> 271
/*     */     //   270: return
/*     */     //   271: aload_0
/*     */     //   272: getfield scanSpec : Lnonapi/io/github/classgraph/scanspec/ScanSpec;
/*     */     //   275: aload #4
/*     */     //   277: invokevirtual dirAcceptMatchStatus : (Ljava/lang/String;)Lnonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch;
/*     */     //   280: dup
/*     */     //   281: astore #6
/*     */     //   283: getstatic nonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch.HAS_REJECTED_PATH_PREFIX : Lnonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch;
/*     */     //   286: if_acmpne -> 316
/*     */     //   289: aload_2
/*     */     //   290: ifnull -> 315
/*     */     //   293: aload_2
/*     */     //   294: new java/lang/StringBuilder
/*     */     //   297: dup
/*     */     //   298: ldc 'Reached rejected directory, stopping recursive scan: '
/*     */     //   300: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   303: aload #4
/*     */     //   305: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   308: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   311: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   314: pop
/*     */     //   315: return
/*     */     //   316: aload #6
/*     */     //   318: getstatic nonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch.NOT_WITHIN_ACCEPTED_PATH : Lnonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch;
/*     */     //   321: if_acmpne -> 325
/*     */     //   324: return
/*     */     //   325: aload_2
/*     */     //   326: ifnonnull -> 333
/*     */     //   329: aconst_null
/*     */     //   330: goto -> 419
/*     */     //   333: aload_2
/*     */     //   334: new java/lang/StringBuilder
/*     */     //   337: dup
/*     */     //   338: ldc '1:'
/*     */     //   340: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   343: aload_3
/*     */     //   344: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   347: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   350: new java/lang/StringBuilder
/*     */     //   353: dup
/*     */     //   354: ldc 'Scanning Path: '
/*     */     //   356: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   359: aload_1
/*     */     //   360: invokeinterface toString : ()Ljava/lang/String;
/*     */     //   365: invokestatic resolve : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   368: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   371: aload_1
/*     */     //   372: aload_3
/*     */     //   373: invokeinterface equals : (Ljava/lang/Object;)Z
/*     */     //   378: ifeq -> 386
/*     */     //   381: ldc ''
/*     */     //   383: goto -> 410
/*     */     //   386: new java/lang/StringBuilder
/*     */     //   389: dup
/*     */     //   390: ldc ' ; canonical path: '
/*     */     //   392: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   395: aload_3
/*     */     //   396: invokeinterface toString : ()Ljava/lang/String;
/*     */     //   401: invokestatic resolve : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   404: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   407: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   413: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   416: invokevirtual log : (Ljava/lang/String;Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   419: astore_3
/*     */     //   420: new java/util/ArrayList
/*     */     //   423: dup
/*     */     //   424: invokespecial <init> : ()V
/*     */     //   427: astore #7
/*     */     //   429: aload_1
/*     */     //   430: invokestatic newDirectoryStream : (Ljava/nio/file/Path;)Ljava/nio/file/DirectoryStream;
/*     */     //   433: astore #8
/*     */     //   435: aconst_null
/*     */     //   436: astore #9
/*     */     //   438: aload #8
/*     */     //   440: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   445: astore #10
/*     */     //   447: aload #10
/*     */     //   449: invokeinterface hasNext : ()Z
/*     */     //   454: ifeq -> 482
/*     */     //   457: aload #10
/*     */     //   459: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   464: checkcast java/nio/file/Path
/*     */     //   467: astore #11
/*     */     //   469: aload #7
/*     */     //   471: aload #11
/*     */     //   473: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   478: pop
/*     */     //   479: goto -> 447
/*     */     //   482: aload #8
/*     */     //   484: ifnull -> 576
/*     */     //   487: aload #9
/*     */     //   489: ifnull -> 514
/*     */     //   492: aload #8
/*     */     //   494: invokeinterface close : ()V
/*     */     //   499: goto -> 620
/*     */     //   502: astore #10
/*     */     //   504: aload #9
/*     */     //   506: aload #10
/*     */     //   508: invokevirtual addSuppressed : (Ljava/lang/Throwable;)V
/*     */     //   511: goto -> 620
/*     */     //   514: aload #8
/*     */     //   516: invokeinterface close : ()V
/*     */     //   521: goto -> 620
/*     */     //   524: dup
/*     */     //   525: astore #10
/*     */     //   527: astore #9
/*     */     //   529: aload #10
/*     */     //   531: athrow
/*     */     //   532: astore #4
/*     */     //   534: aload #8
/*     */     //   536: ifnull -> 573
/*     */     //   539: aload #9
/*     */     //   541: ifnull -> 566
/*     */     //   544: aload #8
/*     */     //   546: invokeinterface close : ()V
/*     */     //   551: goto -> 573
/*     */     //   554: astore #12
/*     */     //   556: aload #9
/*     */     //   558: aload #12
/*     */     //   560: invokevirtual addSuppressed : (Ljava/lang/Throwable;)V
/*     */     //   563: goto -> 573
/*     */     //   566: aload #8
/*     */     //   568: invokeinterface close : ()V
/*     */     //   573: aload #4
/*     */     //   575: athrow
/*     */     //   576: goto -> 620
/*     */     //   579: astore #8
/*     */     //   581: aload_2
/*     */     //   582: ifnull -> 619
/*     */     //   585: aload_2
/*     */     //   586: new java/lang/StringBuilder
/*     */     //   589: dup
/*     */     //   590: ldc 'Could not read directory '
/*     */     //   592: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   595: aload_1
/*     */     //   596: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   599: ldc ' : '
/*     */     //   601: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   604: aload #8
/*     */     //   606: invokevirtual getMessage : ()Ljava/lang/String;
/*     */     //   609: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   612: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   615: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   618: pop
/*     */     //   619: return
/*     */     //   620: aload #7
/*     */     //   622: invokestatic sort : (Ljava/util/List;)V
/*     */     //   625: invokestatic createCachedAttributesGetter : ()Lnonapi/io/github/classgraph/utils/FileUtils$FileAttributesGetter;
/*     */     //   628: astore #8
/*     */     //   630: getstatic nonapi/io/github/classgraph/utils/VersionFinder.JAVA_MAJOR_VERSION : I
/*     */     //   633: bipush #9
/*     */     //   635: if_icmplt -> 649
/*     */     //   638: aload_0
/*     */     //   639: invokevirtual getModuleName : ()Ljava/lang/String;
/*     */     //   642: ifnull -> 649
/*     */     //   645: iconst_1
/*     */     //   646: goto -> 650
/*     */     //   649: iconst_0
/*     */     //   650: istore #9
/*     */     //   652: aload #6
/*     */     //   654: getstatic nonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch.ANCESTOR_OF_ACCEPTED_PATH : Lnonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch;
/*     */     //   657: if_acmpeq -> 901
/*     */     //   660: aload #7
/*     */     //   662: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   667: astore #10
/*     */     //   669: aload #10
/*     */     //   671: invokeinterface hasNext : ()Z
/*     */     //   676: ifeq -> 898
/*     */     //   679: aload #10
/*     */     //   681: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   686: checkcast java/nio/file/Path
/*     */     //   689: astore #11
/*     */     //   691: aload #8
/*     */     //   693: aload #11
/*     */     //   695: invokeinterface get : (Ljava/nio/file/Path;)Ljava/nio/file/attribute/BasicFileAttributes;
/*     */     //   700: dup
/*     */     //   701: astore #4
/*     */     //   703: invokeinterface isRegularFile : ()Z
/*     */     //   708: ifeq -> 895
/*     */     //   711: aload #10
/*     */     //   713: invokeinterface remove : ()V
/*     */     //   718: aload_0
/*     */     //   719: getfield classpathEltPath : Ljava/nio/file/Path;
/*     */     //   722: aload #11
/*     */     //   724: invokeinterface relativize : (Ljava/nio/file/Path;)Ljava/nio/file/Path;
/*     */     //   729: dup
/*     */     //   730: astore #12
/*     */     //   732: invokeinterface toString : ()Ljava/lang/String;
/*     */     //   737: invokestatic resolve : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   740: astore_2
/*     */     //   741: iload #9
/*     */     //   743: ifeq -> 769
/*     */     //   746: iload #5
/*     */     //   748: ifeq -> 769
/*     */     //   751: aload_2
/*     */     //   752: ldc '.class'
/*     */     //   754: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   757: ifeq -> 769
/*     */     //   760: aload_2
/*     */     //   761: ldc 'module-info.class'
/*     */     //   763: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   766: ifeq -> 669
/*     */     //   769: aload_0
/*     */     //   770: aload_2
/*     */     //   771: aload_3
/*     */     //   772: invokevirtual checkResourcePathAcceptReject : (Ljava/lang/String;Lnonapi/io/github/classgraph/utils/LogNode;)Z
/*     */     //   775: ifne -> 779
/*     */     //   778: return
/*     */     //   779: aload #6
/*     */     //   781: getstatic nonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch.HAS_ACCEPTED_PATH_PREFIX : Lnonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch;
/*     */     //   784: if_acmpeq -> 814
/*     */     //   787: aload #6
/*     */     //   789: getstatic nonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch.AT_ACCEPTED_PATH : Lnonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch;
/*     */     //   792: if_acmpeq -> 814
/*     */     //   795: aload #6
/*     */     //   797: getstatic nonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch.AT_ACCEPTED_CLASS_PACKAGE : Lnonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch;
/*     */     //   800: if_acmpne -> 869
/*     */     //   803: aload_0
/*     */     //   804: getfield scanSpec : Lnonapi/io/github/classgraph/scanspec/ScanSpec;
/*     */     //   807: aload_2
/*     */     //   808: invokevirtual classfileIsSpecificallyAccepted : (Ljava/lang/String;)Z
/*     */     //   811: ifeq -> 869
/*     */     //   814: aload_0
/*     */     //   815: aload #11
/*     */     //   817: aload #4
/*     */     //   819: invokespecial newResource : (Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Lio/github/classgraph/Resource;
/*     */     //   822: astore_2
/*     */     //   823: aload_0
/*     */     //   824: aload_2
/*     */     //   825: aload #6
/*     */     //   827: iconst_0
/*     */     //   828: aload_3
/*     */     //   829: invokevirtual addAcceptedResource : (Lio/github/classgraph/Resource;Lnonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch;ZLnonapi/io/github/classgraph/utils/LogNode;)V
/*     */     //   832: aload_0
/*     */     //   833: getfield fileToLastModified : Ljava/util/Map;
/*     */     //   836: aload #11
/*     */     //   838: invokeinterface toFile : ()Ljava/io/File;
/*     */     //   843: aload #4
/*     */     //   845: invokeinterface lastModifiedTime : ()Ljava/nio/file/attribute/FileTime;
/*     */     //   850: invokevirtual toMillis : ()J
/*     */     //   853: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   856: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   861: pop
/*     */     //   862: goto -> 895
/*     */     //   865: pop
/*     */     //   866: goto -> 669
/*     */     //   869: aload_3
/*     */     //   870: ifnull -> 895
/*     */     //   873: aload_3
/*     */     //   874: new java/lang/StringBuilder
/*     */     //   877: dup
/*     */     //   878: ldc 'Skipping non-accepted file: '
/*     */     //   880: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   883: aload #12
/*     */     //   885: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   888: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   891: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   894: pop
/*     */     //   895: goto -> 669
/*     */     //   898: goto -> 1058
/*     */     //   901: aload_0
/*     */     //   902: getfield scanSpec : Lnonapi/io/github/classgraph/scanspec/ScanSpec;
/*     */     //   905: getfield enableClassInfo : Z
/*     */     //   908: ifeq -> 1058
/*     */     //   911: aload #4
/*     */     //   913: ldc '/'
/*     */     //   915: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   918: ifeq -> 1058
/*     */     //   921: aload #7
/*     */     //   923: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   928: astore #10
/*     */     //   930: aload #10
/*     */     //   932: invokeinterface hasNext : ()Z
/*     */     //   937: ifeq -> 1058
/*     */     //   940: aload #10
/*     */     //   942: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   947: checkcast java/nio/file/Path
/*     */     //   950: dup
/*     */     //   951: astore #11
/*     */     //   953: invokeinterface getFileName : ()Ljava/nio/file/Path;
/*     */     //   958: invokeinterface toString : ()Ljava/lang/String;
/*     */     //   963: ldc 'module-info.class'
/*     */     //   965: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   968: ifeq -> 1055
/*     */     //   971: aload #8
/*     */     //   973: aload #11
/*     */     //   975: invokeinterface get : (Ljava/nio/file/Path;)Ljava/nio/file/attribute/BasicFileAttributes;
/*     */     //   980: dup
/*     */     //   981: astore #4
/*     */     //   983: invokeinterface isRegularFile : ()Z
/*     */     //   988: ifeq -> 1055
/*     */     //   991: aload #10
/*     */     //   993: invokeinterface remove : ()V
/*     */     //   998: aload_0
/*     */     //   999: aload #11
/*     */     //   1001: aload #4
/*     */     //   1003: invokespecial newResource : (Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Lio/github/classgraph/Resource;
/*     */     //   1006: astore #12
/*     */     //   1008: aload_0
/*     */     //   1009: aload #12
/*     */     //   1011: aload #6
/*     */     //   1013: iconst_1
/*     */     //   1014: aload_3
/*     */     //   1015: invokevirtual addAcceptedResource : (Lio/github/classgraph/Resource;Lnonapi/io/github/classgraph/scanspec/ScanSpec$ScanSpecPathMatch;ZLnonapi/io/github/classgraph/utils/LogNode;)V
/*     */     //   1018: aload_0
/*     */     //   1019: getfield fileToLastModified : Ljava/util/Map;
/*     */     //   1022: aload #11
/*     */     //   1024: invokeinterface toFile : ()Ljava/io/File;
/*     */     //   1029: aload #4
/*     */     //   1031: invokeinterface lastModifiedTime : ()Ljava/nio/file/attribute/FileTime;
/*     */     //   1036: invokevirtual toMillis : ()J
/*     */     //   1039: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   1042: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   1047: pop
/*     */     //   1048: goto -> 1058
/*     */     //   1051: pop
/*     */     //   1052: goto -> 1058
/*     */     //   1055: goto -> 930
/*     */     //   1058: aload #7
/*     */     //   1060: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1065: astore #10
/*     */     //   1067: aload #10
/*     */     //   1069: invokeinterface hasNext : ()Z
/*     */     //   1074: ifeq -> 1160
/*     */     //   1077: aload #10
/*     */     //   1079: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1084: checkcast java/nio/file/Path
/*     */     //   1087: astore #11
/*     */     //   1089: aload #8
/*     */     //   1091: aload #11
/*     */     //   1093: invokeinterface get : (Ljava/nio/file/Path;)Ljava/nio/file/attribute/BasicFileAttributes;
/*     */     //   1098: invokeinterface isDirectory : ()Z
/*     */     //   1103: ifeq -> 1113
/*     */     //   1106: aload_0
/*     */     //   1107: aload #11
/*     */     //   1109: aload_3
/*     */     //   1110: invokespecial scanPathRecursively : (Ljava/nio/file/Path;Lnonapi/io/github/classgraph/utils/LogNode;)V
/*     */     //   1113: goto -> 1067
/*     */     //   1116: astore #4
/*     */     //   1118: aload_3
/*     */     //   1119: ifnull -> 1157
/*     */     //   1122: aload_3
/*     */     //   1123: new java/lang/StringBuilder
/*     */     //   1126: dup
/*     */     //   1127: ldc 'Could not read sub-directory '
/*     */     //   1129: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1132: aload #11
/*     */     //   1134: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   1137: ldc ' : '
/*     */     //   1139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1142: aload #4
/*     */     //   1144: invokevirtual getMessage : ()Ljava/lang/String;
/*     */     //   1147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1150: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1153: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   1156: pop
/*     */     //   1157: goto -> 1067
/*     */     //   1160: aload_3
/*     */     //   1161: ifnull -> 1168
/*     */     //   1164: aload_3
/*     */     //   1165: invokevirtual addElapsedTime : ()V
/*     */     //   1168: aload_1
/*     */     //   1169: invokeinterface toFile : ()Ljava/io/File;
/*     */     //   1174: astore #10
/*     */     //   1176: aload_0
/*     */     //   1177: getfield fileToLastModified : Ljava/util/Map;
/*     */     //   1180: aload #10
/*     */     //   1182: dup
/*     */     //   1183: invokevirtual lastModified : ()J
/*     */     //   1186: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   1189: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   1194: pop
/*     */     //   1195: return
/*     */     //   1196: pop
/*     */     //   1197: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #325	-> 0
/*     */     //   #326	-> 11
/*     */     //   #327	-> 24
/*     */     //   #328	-> 28
/*     */     //   #330	-> 49
/*     */     //   #337	-> 50
/*     */     //   #332	-> 53
/*     */     //   #333	-> 55
/*     */     //   #334	-> 59
/*     */     //   #336	-> 82
/*     */     //   #339	-> 83
/*     */     //   #340	-> 103
/*     */     //   #341	-> 113
/*     */     //   #343	-> 124
/*     */     //   #344	-> 134
/*     */     //   #346	-> 156
/*     */     //   #348	-> 165
/*     */     //   #349	-> 186
/*     */     //   #350	-> 190
/*     */     //   #353	-> 212
/*     */     //   #359	-> 213
/*     */     //   #360	-> 227
/*     */     //   #361	-> 233
/*     */     //   #362	-> 237
/*     */     //   #365	-> 259
/*     */     //   #369	-> 260
/*     */     //   #370	-> 270
/*     */     //   #373	-> 271
/*     */     //   #374	-> 281
/*     */     //   #376	-> 289
/*     */     //   #377	-> 293
/*     */     //   #379	-> 315
/*     */     //   #381	-> 316
/*     */     //   #383	-> 324
/*     */     //   #386	-> 325
/*     */     //   #389	-> 360
/*     */     //   #391	-> 396
/*     */     //   #388	-> 416
/*     */     //   #393	-> 420
/*     */     //   #394	-> 429
/*     */     //   #395	-> 438
/*     */     //   #396	-> 469
/*     */     //   #397	-> 479
/*     */     //   #398	-> 482
/*     */     //   #394	-> 524
/*     */     //   #398	-> 532
/*     */     //   #403	-> 576
/*     */     //   #398	-> 579
/*     */     //   #399	-> 581
/*     */     //   #400	-> 585
/*     */     //   #402	-> 619
/*     */     //   #404	-> 620
/*     */     //   #405	-> 625
/*     */     //   #408	-> 630
/*     */     //   #411	-> 652
/*     */     //   #413	-> 660
/*     */     //   #414	-> 669
/*     */     //   #415	-> 679
/*     */     //   #417	-> 691
/*     */     //   #418	-> 701
/*     */     //   #419	-> 711
/*     */     //   #420	-> 718
/*     */     //   #421	-> 730
/*     */     //   #424	-> 741
/*     */     //   #425	-> 763
/*     */     //   #430	-> 769
/*     */     //   #431	-> 778
/*     */     //   #435	-> 779
/*     */     //   #438	-> 808
/*     */     //   #440	-> 814
/*     */     //   #441	-> 823
/*     */     //   #445	-> 832
/*     */     //   #448	-> 862
/*     */     //   #446	-> 865
/*     */     //   #449	-> 866
/*     */     //   #450	-> 869
/*     */     //   #451	-> 873
/*     */     //   #455	-> 895
/*     */     //   #456	-> 898
/*     */     //   #458	-> 921
/*     */     //   #459	-> 930
/*     */     //   #460	-> 940
/*     */     //   #461	-> 951
/*     */     //   #462	-> 971
/*     */     //   #463	-> 981
/*     */     //   #464	-> 991
/*     */     //   #465	-> 998
/*     */     //   #466	-> 1008
/*     */     //   #468	-> 1018
/*     */     //   #471	-> 1048
/*     */     //   #469	-> 1051
/*     */     //   #472	-> 1052
/*     */     //   #475	-> 1055
/*     */     //   #478	-> 1058
/*     */     //   #480	-> 1089
/*     */     //   #481	-> 1106
/*     */     //   #487	-> 1113
/*     */     //   #483	-> 1116
/*     */     //   #484	-> 1118
/*     */     //   #485	-> 1122
/*     */     //   #488	-> 1157
/*     */     //   #490	-> 1160
/*     */     //   #491	-> 1164
/*     */     //   #496	-> 1168
/*     */     //   #497	-> 1176
/*     */     //   #500	-> 1195
/*     */     //   #498	-> 1196
/*     */     //   #501	-> 1197
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   0	49	53	java/io/IOException
/*     */     //   0	49	53	java/lang/SecurityException
/*     */     //   429	576	579	java/io/IOException
/*     */     //   429	576	579	java/lang/SecurityException
/*     */     //   438	482	524	java/lang/Throwable
/*     */     //   438	482	532	finally
/*     */     //   492	499	502	java/lang/Throwable
/*     */     //   524	534	532	finally
/*     */     //   544	551	554	java/lang/Throwable
/*     */     //   832	862	865	java/lang/UnsupportedOperationException
/*     */     //   1018	1048	1051	java/lang/UnsupportedOperationException
/*     */     //   1089	1113	1116	java/lang/SecurityException
/*     */     //   1168	1195	1196	java/lang/UnsupportedOperationException
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void scanPaths(LogNode paramLogNode) {
/* 511 */     if (!checkResourcePathAcceptReject(this.classpathEltPath.toString(), paramLogNode)) {
/* 512 */       this.skipClasspathElement = true;
/*     */     }
/* 514 */     if (this.skipClasspathElement) {
/*     */       return;
/*     */     }
/* 517 */     if (this.scanned.getAndSet(true))
/*     */     {
/* 519 */       throw new IllegalArgumentException("Already scanned classpath element " + this);
/*     */     }
/*     */ 
/*     */     
/* 523 */     paramLogNode = (paramLogNode == null) ? null : log(this.classpathElementIdx, "Scanning Path classpath element " + getURI(), paramLogNode);
/*     */     
/* 525 */     scanPathRecursively(this.classpathEltPath, paramLogNode);
/*     */     
/* 527 */     finishScanPaths(paramLogNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModuleName() {
/* 537 */     return (this.moduleNameFromModuleDescriptor == null || this.moduleNameFromModuleDescriptor.isEmpty()) ? null : this.moduleNameFromModuleDescriptor;
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
/*     */   public File getFile() {
/*     */     try {
/* 550 */       return this.classpathEltPath.toFile();
/* 551 */     } catch (UnsupportedOperationException unsupportedOperationException) {
/* 552 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   URI getURI() {
/*     */     try {
/* 562 */       return this.classpathEltPath.toUri();
/* 563 */     } catch (IOError|SecurityException iOError) {
/* 564 */       throw new IllegalArgumentException("Could not convert to URI: " + this.classpathEltPath);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   List<URI> getAllURIs() {
/* 570 */     return Collections.singletonList(getURI());
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
/*     */     try {
/* 582 */       return this.classpathEltPath.toUri().toString();
/* 583 */     } catch (IOError|SecurityException iOError) {
/* 584 */       return this.classpathEltPath.toString();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 593 */     return Objects.hash(new Object[] { this.classpathEltPath });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 601 */     if (paramObject == this)
/* 602 */       return true; 
/* 603 */     if (!(paramObject instanceof ClasspathElementDir)) {
/* 604 */       return false;
/*     */     }
/* 606 */     paramObject = paramObject;
/* 607 */     return Objects.equals(this.classpathEltPath, ((ClasspathElementDir)paramObject).classpathEltPath);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClasspathElementDir.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */