/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import nonapi.io.github.classgraph.concurrency.WorkQueue;
/*     */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class ClasspathElement
/*     */   implements Comparable<ClasspathElement>
/*     */ {
/*     */   int classpathElementIdx;
/*     */   List<String> nestedClasspathRootPrefixes;
/*     */   boolean skipClasspathElement;
/*     */   boolean containsSpecificallyAcceptedClasspathElementResourcePath;
/*     */   final int classpathElementIdxWithinParent;
/*  85 */   Collection<ClasspathElement> childClasspathElements = new ConcurrentLinkedQueue<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   protected final List<Resource> acceptedResources = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   protected List<Resource> acceptedClassfileResources = new ArrayList<>();
/*     */ 
/*     */   
/* 100 */   protected final Map<File, Long> fileToLastModified = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/* 103 */   protected final AtomicBoolean scanned = new AtomicBoolean(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ClassLoader classLoader;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String packageRootPrefix;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String moduleNameFromModuleDescriptor;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final ScanSpec scanSpec;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ClasspathElement(Scanner.ClasspathEntryWorkUnit paramClasspathEntryWorkUnit, ScanSpec paramScanSpec) {
/* 131 */     this.packageRootPrefix = paramClasspathEntryWorkUnit.packageRootPrefix;
/* 132 */     this.classpathElementIdxWithinParent = paramClasspathEntryWorkUnit.classpathElementIdxWithinParent;
/* 133 */     this.classLoader = paramClasspathEntryWorkUnit.classLoader;
/* 134 */     this.scanSpec = paramScanSpec;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(ClasspathElement paramClasspathElement) {
/* 142 */     return this.classpathElementIdxWithinParent - paramClasspathElement.classpathElementIdxWithinParent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ClassLoader getClassLoader() {
/* 153 */     return this.classLoader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getNumClassfileMatches() {
/* 162 */     return (this.acceptedClassfileResources == null) ? 0 : this.acceptedClassfileResources.size();
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
/*     */   protected boolean checkResourcePathAcceptReject(String paramString, LogNode paramLogNode) {
/* 178 */     if (!this.scanSpec.classpathElementResourcePathAcceptReject.acceptAndRejectAreEmpty()) {
/* 179 */       if (this.scanSpec.classpathElementResourcePathAcceptReject.isRejected(paramString)) {
/* 180 */         if (paramLogNode != null) {
/* 181 */           paramLogNode.log("Reached rejected classpath element resource path, stopping scanning: " + paramString);
/*     */         }
/* 183 */         return false;
/*     */       } 
/* 185 */       if (this.scanSpec.classpathElementResourcePathAcceptReject.isSpecificallyAccepted(paramString)) {
/* 186 */         if (paramLogNode != null) {
/* 187 */           paramLogNode.log("Reached specifically accepted classpath element resource path: " + paramString);
/*     */         }
/* 189 */         this.containsSpecificallyAcceptedClasspathElementResourcePath = true;
/*     */       } 
/*     */     } 
/* 192 */     return true;
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
/*     */   void maskClassfiles(int paramInt, Set<String> paramSet, LogNode paramLogNode) {
/* 215 */     ArrayList<Resource> arrayList = new ArrayList(this.acceptedClassfileResources.size());
/* 216 */     boolean bool = false;
/* 217 */     for (Iterator<Resource> iterator = this.acceptedClassfileResources.iterator(); iterator.hasNext(); ) {
/*     */       Resource resource;
/*     */ 
/*     */       
/*     */       String str;
/*     */       
/* 223 */       if (!(str = (resource = iterator.next()).getPath()).equals("module-info.class") && 
/* 224 */         !str.equals("package-info.class") && 
/* 225 */         !str.endsWith("/package-info.class") && 
/*     */         
/* 227 */         !paramSet.add(str)) {
/*     */ 
/*     */         
/* 230 */         bool = true;
/* 231 */         if (paramLogNode != null)
/* 232 */           paramLogNode.log(String.format("%06d-1", new Object[] { Integer.valueOf(paramInt) }), "Ignoring duplicate (masked) class " + 
/* 233 */               JarUtils.classfilePathToClassName(str) + " found at " + resource); 
/*     */         continue;
/*     */       } 
/* 236 */       arrayList.add(resource);
/*     */     } 
/*     */     
/* 239 */     if (bool)
/*     */     {
/*     */ 
/*     */       
/* 243 */       this.acceptedClassfileResources = arrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addAcceptedResource(Resource paramResource, ScanSpec.ScanSpecPathMatch paramScanSpecPathMatch, boolean paramBoolean, LogNode paramLogNode) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual getPath : ()Ljava/lang/String;
/*     */     //   4: dup
/*     */     //   5: astore #5
/*     */     //   7: invokestatic isClassfile : (Ljava/lang/String;)Z
/*     */     //   10: istore #6
/*     */     //   12: iconst_0
/*     */     //   13: istore #7
/*     */     //   15: iload #6
/*     */     //   17: ifeq -> 56
/*     */     //   20: aload_0
/*     */     //   21: getfield scanSpec : Lnonapi/io/github/classgraph/scanspec/ScanSpec;
/*     */     //   24: getfield enableClassInfo : Z
/*     */     //   27: ifeq -> 59
/*     */     //   30: aload_0
/*     */     //   31: getfield scanSpec : Lnonapi/io/github/classgraph/scanspec/ScanSpec;
/*     */     //   34: getfield classfilePathAcceptReject : Lnonapi/io/github/classgraph/scanspec/AcceptReject$AcceptRejectWholeString;
/*     */     //   37: aload #5
/*     */     //   39: invokevirtual isRejected : (Ljava/lang/String;)Z
/*     */     //   42: ifne -> 59
/*     */     //   45: aload_0
/*     */     //   46: getfield acceptedClassfileResources : Ljava/util/List;
/*     */     //   49: aload_1
/*     */     //   50: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   55: pop
/*     */     //   56: iconst_1
/*     */     //   57: istore #7
/*     */     //   59: iload_3
/*     */     //   60: ifne -> 74
/*     */     //   63: aload_0
/*     */     //   64: getfield acceptedResources : Ljava/util/List;
/*     */     //   67: aload_1
/*     */     //   68: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   73: pop
/*     */     //   74: aload #4
/*     */     //   76: ifnull -> 313
/*     */     //   79: iload #7
/*     */     //   81: ifeq -> 313
/*     */     //   84: iload #6
/*     */     //   86: ifeq -> 94
/*     */     //   89: ldc 'classfile'
/*     */     //   91: goto -> 96
/*     */     //   94: ldc 'resource'
/*     */     //   96: astore_3
/*     */     //   97: getstatic io/github/classgraph/ClasspathElement$1.$SwitchMap$nonapi$io$github$classgraph$scanspec$ScanSpec$ScanSpecPathMatch : [I
/*     */     //   100: aload_2
/*     */     //   101: invokevirtual ordinal : ()I
/*     */     //   104: iaload
/*     */     //   105: tableswitch default -> 207, 1 -> 132, 2 -> 157, 3 -> 182
/*     */     //   132: new java/lang/StringBuilder
/*     */     //   135: dup
/*     */     //   136: ldc 'Found '
/*     */     //   138: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   141: aload_3
/*     */     //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   145: ldc ' within subpackage of accepted package: '
/*     */     //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   150: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   153: astore_2
/*     */     //   154: goto -> 229
/*     */     //   157: new java/lang/StringBuilder
/*     */     //   160: dup
/*     */     //   161: ldc 'Found '
/*     */     //   163: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   166: aload_3
/*     */     //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   170: ldc ' within accepted package: '
/*     */     //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   175: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   178: astore_2
/*     */     //   179: goto -> 229
/*     */     //   182: new java/lang/StringBuilder
/*     */     //   185: dup
/*     */     //   186: ldc 'Found specifically-accepted '
/*     */     //   188: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   191: aload_3
/*     */     //   192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   195: ldc ': '
/*     */     //   197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   200: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   203: astore_2
/*     */     //   204: goto -> 229
/*     */     //   207: new java/lang/StringBuilder
/*     */     //   210: dup
/*     */     //   211: ldc 'Found accepted '
/*     */     //   213: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   216: aload_3
/*     */     //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   220: ldc ': '
/*     */     //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   225: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   228: astore_2
/*     */     //   229: aload_1
/*     */     //   230: aload #4
/*     */     //   232: new java/lang/StringBuilder
/*     */     //   235: dup
/*     */     //   236: ldc '0:'
/*     */     //   238: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   241: aload #5
/*     */     //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   246: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   249: new java/lang/StringBuilder
/*     */     //   252: dup
/*     */     //   253: invokespecial <init> : ()V
/*     */     //   256: aload_2
/*     */     //   257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   260: aload #5
/*     */     //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   265: aload #5
/*     */     //   267: aload_1
/*     */     //   268: invokevirtual getPathRelativeToClasspathElement : ()Ljava/lang/String;
/*     */     //   271: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   274: ifeq -> 282
/*     */     //   277: ldc ''
/*     */     //   279: goto -> 301
/*     */     //   282: new java/lang/StringBuilder
/*     */     //   285: dup
/*     */     //   286: ldc ' ; full path: '
/*     */     //   288: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   291: aload_1
/*     */     //   292: invokevirtual getPathRelativeToClasspathElement : ()Ljava/lang/String;
/*     */     //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   298: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   304: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   307: invokevirtual log : (Ljava/lang/String;Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   310: putfield scanLog : Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   313: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #264	-> 0
/*     */     //   #265	-> 5
/*     */     //   #266	-> 12
/*     */     //   #267	-> 15
/*     */     //   #269	-> 20
/*     */     //   #271	-> 45
/*     */     //   #276	-> 56
/*     */     //   #279	-> 59
/*     */     //   #281	-> 63
/*     */     //   #286	-> 74
/*     */     //   #287	-> 84
/*     */     //   #289	-> 97
/*     */     //   #291	-> 132
/*     */     //   #292	-> 154
/*     */     //   #294	-> 157
/*     */     //   #295	-> 179
/*     */     //   #297	-> 182
/*     */     //   #298	-> 204
/*     */     //   #300	-> 207
/*     */     //   #305	-> 229
/*     */     //   #306	-> 268
/*     */     //   #307	-> 292
/*     */     //   #305	-> 307
/*     */     //   #309	-> 313
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
/*     */   protected void finishScanPaths(LogNode paramLogNode) {
/* 320 */     if (paramLogNode != null) {
/* 321 */       if (this.acceptedResources.isEmpty() && this.acceptedClassfileResources.isEmpty()) {
/* 322 */         paramLogNode.log(this.scanSpec.enableClassInfo ? "No accepted classfiles or resources found" : "Classfile scanning is disabled, and no accepted resources found");
/*     */       }
/* 324 */       else if (this.acceptedResources.isEmpty()) {
/* 325 */         paramLogNode.log("No accepted resources found");
/* 326 */       } else if (this.acceptedClassfileResources.isEmpty()) {
/* 327 */         paramLogNode.log(this.scanSpec.enableClassInfo ? "No accepted classfiles found" : "Classfile scanning is disabled");
/*     */       } 
/*     */     }
/*     */     
/* 331 */     if (paramLogNode != null) {
/* 332 */       paramLogNode.addElapsedTime();
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
/*     */   protected LogNode log(int paramInt, String paramString, LogNode paramLogNode) {
/* 350 */     return paramLogNode.log(String.format("%07d", new Object[] { Integer.valueOf(paramInt) }), paramString);
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
/*     */   protected LogNode log(int paramInt, String paramString, Throwable paramThrowable, LogNode paramLogNode) {
/* 367 */     return paramLogNode.log(String.format("%07d", new Object[] { Integer.valueOf(paramInt) }), paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   abstract void open(WorkQueue<Scanner.ClasspathEntryWorkUnit> paramWorkQueue, LogNode paramLogNode);
/*     */   
/*     */   abstract void scanPaths(LogNode paramLogNode);
/*     */   
/*     */   abstract Resource getResource(String paramString);
/*     */   
/*     */   abstract URI getURI();
/*     */   
/*     */   abstract List<URI> getAllURIs();
/*     */   
/*     */   abstract File getFile();
/*     */   
/*     */   abstract String getModuleName();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ClasspathElement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */