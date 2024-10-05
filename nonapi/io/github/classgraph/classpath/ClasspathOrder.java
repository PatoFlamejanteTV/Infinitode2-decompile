/*     */ package nonapi.io.github.classgraph.classpath;
/*     */ 
/*     */ import io.github.classgraph.ClassGraph;
/*     */ import java.lang.reflect.Array;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class ClasspathOrder
/*     */ {
/*     */   private final ScanSpec scanSpec;
/*     */   public ReflectionUtils reflectionUtils;
/*  67 */   private final Set<String> classpathEntryUniqueResolvedPaths = new HashSet<>();
/*     */ 
/*     */   
/*  70 */   private final List<ClasspathEntry> order = new ArrayList<>();
/*     */ 
/*     */   
/*  73 */   private static final List<String> AUTOMATIC_PACKAGE_ROOT_SUFFIXES = new ArrayList<>();
/*     */ 
/*     */   
/*  76 */   private static final Pattern schemeMatcher = Pattern.compile("^[a-zA-Z][a-zA-Z+\\-.]+:"); static { String[] arrayOfString;
/*     */     int i;
/*     */     byte b;
/*  79 */     for (i = (arrayOfString = ClassLoaderHandlerRegistry.AUTOMATIC_PACKAGE_ROOT_PREFIXES).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*  80 */       AUTOMATIC_PACKAGE_ROOT_SUFFIXES.add("!/" + str.substring(0, str.length() - 1));
/*     */       b++; }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ClasspathEntry
/*     */   {
/*     */     public final Object classpathEntryObj;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ClassLoader classLoader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ClasspathEntry(Object param1Object, ClassLoader param1ClassLoader) {
/* 103 */       this.classpathEntryObj = param1Object;
/* 104 */       this.classLoader = param1ClassLoader;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 109 */       return Objects.hash(new Object[] { this.classpathEntryObj });
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 114 */       if (param1Object == this)
/* 115 */         return true; 
/* 116 */       if (!(param1Object instanceof ClasspathEntry)) {
/* 117 */         return false;
/*     */       }
/* 119 */       param1Object = param1Object;
/* 120 */       return Objects.equals(this.classpathEntryObj, ((ClasspathEntry)param1Object).classpathEntryObj);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 125 */       return this.classpathEntryObj + " [" + this.classLoader + "]";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ClasspathOrder(ScanSpec paramScanSpec, ReflectionUtils paramReflectionUtils) {
/* 136 */     this.scanSpec = paramScanSpec;
/* 137 */     this.reflectionUtils = paramReflectionUtils;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ClasspathEntry> getOrder() {
/* 146 */     return this.order;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> getClasspathEntryUniqueResolvedPaths() {
/* 155 */     return this.classpathEntryUniqueResolvedPaths;
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
/*     */   private boolean filter(URL paramURL, String paramString) {
/* 168 */     if (this.scanSpec.classpathElementFilters != null) {
/* 169 */       for (ClassGraph.ClasspathElementURLFilter classpathElementURLFilter : this.scanSpec.classpathElementFilters) {
/* 170 */         if ((paramURL != null && classpathElementURLFilter instanceof ClassGraph.ClasspathElementURLFilter && 
/* 171 */           !((ClassGraph.ClasspathElementURLFilter)classpathElementURLFilter).includeClasspathElement(paramURL)) || (paramString != null && classpathElementURLFilter instanceof ClassGraph.ClasspathElementFilter && 
/*     */ 
/*     */           
/* 174 */           !((ClassGraph.ClasspathElementFilter)classpathElementURLFilter).includeClasspathElement(paramString))) {
/* 175 */           return false;
/*     */         }
/*     */       } 
/*     */     }
/* 179 */     return true;
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
/*     */   boolean addSystemClasspathEntry(String paramString, ClassLoader paramClassLoader) {
/* 193 */     if (this.classpathEntryUniqueResolvedPaths.add(paramString)) {
/* 194 */       this.order.add(new ClasspathEntry(paramString, paramClassLoader));
/* 195 */       return true;
/*     */     } 
/* 197 */     return false;
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
/*     */   private boolean addClasspathEntry(Object paramObject, String paramString, ClassLoader paramClassLoader, ScanSpec paramScanSpec) {
/* 218 */     String str = paramString;
/* 219 */     boolean bool = false;
/* 220 */     for (String str1 : AUTOMATIC_PACKAGE_ROOT_SUFFIXES) {
/* 221 */       if (paramString.endsWith(str1)) {
/*     */         
/* 223 */         str = paramString.substring(0, paramString
/* 224 */             .length() - str1.length());
/* 225 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 229 */     if (paramObject instanceof URL || paramObject instanceof URI || paramObject instanceof java.nio.file.Path || paramObject instanceof java.io.File) {
/*     */       
/* 231 */       Object object = paramObject;
/* 232 */       if (bool) {
/*     */         
/*     */         try {
/*     */           
/* 236 */           object = (paramObject instanceof URL) ? new URL(str) : ((paramObject instanceof URI) ? new URI(str) : ((paramObject instanceof java.nio.file.Path) ? Paths.get(str, new String[0]) : str));
/*     */         
/*     */         }
/* 239 */         catch (MalformedURLException|java.net.URISyntaxException|java.nio.file.InvalidPathException malformedURLException) {
/*     */           try {
/* 241 */             object = (paramObject instanceof URL) ? new URL("file:" + str) : ((paramObject instanceof URI) ? new URI("file:" + str) : str);
/*     */ 
/*     */           
/*     */           }
/* 245 */           catch (MalformedURLException|java.net.URISyntaxException|java.nio.file.InvalidPathException malformedURLException1) {
/* 246 */             return false;
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 251 */       if (this.classpathEntryUniqueResolvedPaths.add(str)) {
/*     */         
/* 253 */         this.order.add(new ClasspathEntry(object, paramClassLoader));
/* 254 */         return true;
/*     */       } 
/*     */     } else {
/* 257 */       String str1 = FastPathResolver.resolve(FileUtils.currDirPath(), str);
/*     */       
/* 259 */       if (paramScanSpec.overrideClasspath == null && (
/* 260 */         SystemJarFinder.getJreLibOrExtJars().contains(str1) || str1
/* 261 */         .equals(SystemJarFinder.getJreRtJarPath())))
/*     */       {
/*     */         
/* 264 */         return false;
/*     */       }
/* 266 */       if (this.classpathEntryUniqueResolvedPaths.add(str1)) {
/* 267 */         this.order.add(new ClasspathEntry(str1, paramClassLoader));
/* 268 */         return true;
/*     */       } 
/*     */     } 
/* 271 */     return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addClasspathEntry(Object paramObject, ClassLoader paramClassLoader, ScanSpec paramScanSpec, LogNode paramLogNode) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnonnull -> 6
/*     */     //   4: iconst_0
/*     */     //   5: ireturn
/*     */     //   6: aload_1
/*     */     //   7: instanceof java/nio/file/Path
/*     */     //   10: ifeq -> 54
/*     */     //   13: aload_1
/*     */     //   14: checkcast java/nio/file/Path
/*     */     //   17: invokeinterface toUri : ()Ljava/net/URI;
/*     */     //   22: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   25: dup
/*     */     //   26: astore #5
/*     */     //   28: ldc 'file:///'
/*     */     //   30: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   33: ifeq -> 50
/*     */     //   36: aload_1
/*     */     //   37: checkcast java/nio/file/Path
/*     */     //   40: invokeinterface toFile : ()Ljava/io/File;
/*     */     //   45: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   48: astore #5
/*     */     //   50: goto -> 60
/*     */     //   53: pop
/*     */     //   54: aload_1
/*     */     //   55: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   58: astore #5
/*     */     //   60: invokestatic currDirPath : ()Ljava/lang/String;
/*     */     //   63: aload #5
/*     */     //   65: invokestatic resolve : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   68: dup
/*     */     //   69: astore #5
/*     */     //   71: invokevirtual isEmpty : ()Z
/*     */     //   74: ifeq -> 79
/*     */     //   77: iconst_0
/*     */     //   78: ireturn
/*     */     //   79: aconst_null
/*     */     //   80: astore #6
/*     */     //   82: iconst_0
/*     */     //   83: istore #7
/*     */     //   85: aload #5
/*     */     //   87: ldc '/*'
/*     */     //   89: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   92: ifne -> 105
/*     */     //   95: aload #5
/*     */     //   97: ldc '\*'
/*     */     //   99: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   102: ifeq -> 126
/*     */     //   105: iconst_1
/*     */     //   106: istore #7
/*     */     //   108: aload #5
/*     */     //   110: iconst_0
/*     */     //   111: aload #5
/*     */     //   113: invokevirtual length : ()I
/*     */     //   116: iconst_2
/*     */     //   117: isub
/*     */     //   118: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   121: astore #5
/*     */     //   123: goto -> 342
/*     */     //   126: aload #5
/*     */     //   128: ldc '*'
/*     */     //   130: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   133: ifeq -> 146
/*     */     //   136: iconst_1
/*     */     //   137: istore #7
/*     */     //   139: ldc ''
/*     */     //   141: astore #5
/*     */     //   143: goto -> 342
/*     */     //   146: getstatic nonapi/io/github/classgraph/classpath/ClasspathOrder.schemeMatcher : Ljava/util/regex/Pattern;
/*     */     //   149: aload #5
/*     */     //   151: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*     */     //   154: dup
/*     */     //   155: astore #8
/*     */     //   157: invokevirtual find : ()Z
/*     */     //   160: ifeq -> 342
/*     */     //   163: aload_1
/*     */     //   164: instanceof java/net/URL
/*     */     //   167: ifeq -> 177
/*     */     //   170: aload_1
/*     */     //   171: checkcast java/net/URL
/*     */     //   174: goto -> 237
/*     */     //   177: aload_1
/*     */     //   178: instanceof java/net/URI
/*     */     //   181: ifeq -> 194
/*     */     //   184: aload_1
/*     */     //   185: checkcast java/net/URI
/*     */     //   188: invokevirtual toURL : ()Ljava/net/URL;
/*     */     //   191: goto -> 237
/*     */     //   194: aload_1
/*     */     //   195: instanceof java/nio/file/Path
/*     */     //   198: ifeq -> 216
/*     */     //   201: aload_1
/*     */     //   202: checkcast java/nio/file/Path
/*     */     //   205: invokeinterface toUri : ()Ljava/net/URI;
/*     */     //   210: invokevirtual toURL : ()Ljava/net/URL;
/*     */     //   213: goto -> 237
/*     */     //   216: aload_1
/*     */     //   217: instanceof java/io/File
/*     */     //   220: ifeq -> 236
/*     */     //   223: aload_1
/*     */     //   224: checkcast java/io/File
/*     */     //   227: invokevirtual toURI : ()Ljava/net/URI;
/*     */     //   230: invokevirtual toURL : ()Ljava/net/URL;
/*     */     //   233: goto -> 237
/*     */     //   236: aconst_null
/*     */     //   237: astore #6
/*     */     //   239: goto -> 243
/*     */     //   242: pop
/*     */     //   243: aload #6
/*     */     //   245: ifnonnull -> 310
/*     */     //   248: aload #5
/*     */     //   250: ldc '%'
/*     */     //   252: ldc '%25'
/*     */     //   254: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
/*     */     //   257: astore #9
/*     */     //   259: new java/net/URL
/*     */     //   262: dup
/*     */     //   263: aload #9
/*     */     //   265: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   268: astore #6
/*     */     //   270: goto -> 310
/*     */     //   273: pop
/*     */     //   274: new java/io/File
/*     */     //   277: dup
/*     */     //   278: aload #9
/*     */     //   280: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   283: invokevirtual toURI : ()Ljava/net/URI;
/*     */     //   286: invokevirtual toURL : ()Ljava/net/URL;
/*     */     //   289: astore #6
/*     */     //   291: goto -> 310
/*     */     //   294: pop
/*     */     //   295: new java/net/URL
/*     */     //   298: dup
/*     */     //   299: aload #5
/*     */     //   301: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   304: astore #6
/*     */     //   306: goto -> 310
/*     */     //   309: pop
/*     */     //   310: aload #6
/*     */     //   312: ifnonnull -> 342
/*     */     //   315: aload #4
/*     */     //   317: ifnull -> 342
/*     */     //   320: aload #4
/*     */     //   322: new java/lang/StringBuilder
/*     */     //   325: dup
/*     */     //   326: ldc 'Failed to convert classpath element to URL: '
/*     */     //   328: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   331: aload_1
/*     */     //   332: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   335: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   338: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   341: pop
/*     */     //   342: aload #6
/*     */     //   344: ifnonnull -> 368
/*     */     //   347: aload_1
/*     */     //   348: instanceof java/net/URI
/*     */     //   351: ifne -> 368
/*     */     //   354: aload_1
/*     */     //   355: instanceof java/io/File
/*     */     //   358: ifne -> 368
/*     */     //   361: aload_1
/*     */     //   362: instanceof java/nio/file/Path
/*     */     //   365: ifeq -> 507
/*     */     //   368: aload_0
/*     */     //   369: aload #6
/*     */     //   371: aload #5
/*     */     //   373: invokespecial filter : (Ljava/net/URL;Ljava/lang/String;)Z
/*     */     //   376: ifne -> 409
/*     */     //   379: aload #4
/*     */     //   381: ifnull -> 407
/*     */     //   384: aload #4
/*     */     //   386: new java/lang/StringBuilder
/*     */     //   389: dup
/*     */     //   390: ldc 'Classpath element did not match filter criterion, skipping: '
/*     */     //   392: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   395: aload #5
/*     */     //   397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   400: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   403: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   406: pop
/*     */     //   407: iconst_0
/*     */     //   408: ireturn
/*     */     //   409: aload_1
/*     */     //   410: instanceof java/io/File
/*     */     //   413: ifeq -> 421
/*     */     //   416: aload #5
/*     */     //   418: goto -> 432
/*     */     //   421: aload #6
/*     */     //   423: ifnull -> 431
/*     */     //   426: aload #6
/*     */     //   428: goto -> 432
/*     */     //   431: aload_1
/*     */     //   432: astore #8
/*     */     //   434: aload_0
/*     */     //   435: aload #8
/*     */     //   437: aload #5
/*     */     //   439: aload_2
/*     */     //   440: aload_3
/*     */     //   441: invokespecial addClasspathEntry : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassLoader;Lnonapi/io/github/classgraph/scanspec/ScanSpec;)Z
/*     */     //   444: ifeq -> 477
/*     */     //   447: aload #4
/*     */     //   449: ifnull -> 475
/*     */     //   452: aload #4
/*     */     //   454: new java/lang/StringBuilder
/*     */     //   457: dup
/*     */     //   458: ldc 'Found classpath element: '
/*     */     //   460: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   463: aload #5
/*     */     //   465: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   468: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   471: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   474: pop
/*     */     //   475: iconst_1
/*     */     //   476: ireturn
/*     */     //   477: aload #4
/*     */     //   479: ifnull -> 505
/*     */     //   482: aload #4
/*     */     //   484: new java/lang/StringBuilder
/*     */     //   487: dup
/*     */     //   488: ldc 'Ignoring duplicate classpath element: '
/*     */     //   490: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   493: aload #5
/*     */     //   495: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   498: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   501: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   504: pop
/*     */     //   505: iconst_0
/*     */     //   506: ireturn
/*     */     //   507: iload #7
/*     */     //   509: ifeq -> 966
/*     */     //   512: aload #5
/*     */     //   514: astore #8
/*     */     //   516: invokestatic currDirPath : ()Ljava/lang/String;
/*     */     //   519: aload #8
/*     */     //   521: invokestatic resolve : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   524: astore #9
/*     */     //   526: aload_0
/*     */     //   527: aload #6
/*     */     //   529: aload #8
/*     */     //   531: invokespecial filter : (Ljava/net/URL;Ljava/lang/String;)Z
/*     */     //   534: ifeq -> 558
/*     */     //   537: aload #9
/*     */     //   539: aload #8
/*     */     //   541: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   544: ifne -> 588
/*     */     //   547: aload_0
/*     */     //   548: aload #6
/*     */     //   550: aload #9
/*     */     //   552: invokespecial filter : (Ljava/net/URL;Ljava/lang/String;)Z
/*     */     //   555: ifne -> 588
/*     */     //   558: aload #4
/*     */     //   560: ifnull -> 586
/*     */     //   563: aload #4
/*     */     //   565: new java/lang/StringBuilder
/*     */     //   568: dup
/*     */     //   569: ldc 'Classpath element did not match filter criterion, skipping: '
/*     */     //   571: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   574: aload #5
/*     */     //   576: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   579: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   582: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   585: pop
/*     */     //   586: iconst_0
/*     */     //   587: ireturn
/*     */     //   588: new java/io/File
/*     */     //   591: dup
/*     */     //   592: aload #9
/*     */     //   594: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   597: dup
/*     */     //   598: astore_1
/*     */     //   599: invokevirtual exists : ()Z
/*     */     //   602: ifne -> 635
/*     */     //   605: aload #4
/*     */     //   607: ifnull -> 633
/*     */     //   610: aload #4
/*     */     //   612: new java/lang/StringBuilder
/*     */     //   615: dup
/*     */     //   616: ldc 'Directory does not exist for wildcard classpath element: '
/*     */     //   618: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   621: aload #5
/*     */     //   623: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   626: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   629: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   632: pop
/*     */     //   633: iconst_0
/*     */     //   634: ireturn
/*     */     //   635: aload_1
/*     */     //   636: invokestatic canRead : (Ljava/io/File;)Z
/*     */     //   639: ifne -> 672
/*     */     //   642: aload #4
/*     */     //   644: ifnull -> 670
/*     */     //   647: aload #4
/*     */     //   649: new java/lang/StringBuilder
/*     */     //   652: dup
/*     */     //   653: ldc 'Cannot read directory for wildcard classpath element: '
/*     */     //   655: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   658: aload #5
/*     */     //   660: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   663: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   666: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   669: pop
/*     */     //   670: iconst_0
/*     */     //   671: ireturn
/*     */     //   672: aload_1
/*     */     //   673: invokevirtual isDirectory : ()Z
/*     */     //   676: ifne -> 709
/*     */     //   679: aload #4
/*     */     //   681: ifnull -> 707
/*     */     //   684: aload #4
/*     */     //   686: new java/lang/StringBuilder
/*     */     //   689: dup
/*     */     //   690: ldc 'Wildcard is appended to something other than a directory: '
/*     */     //   692: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   695: aload #5
/*     */     //   697: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   700: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   703: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   706: pop
/*     */     //   707: iconst_0
/*     */     //   708: ireturn
/*     */     //   709: aload #4
/*     */     //   711: ifnonnull -> 718
/*     */     //   714: aconst_null
/*     */     //   715: goto -> 740
/*     */     //   718: aload #4
/*     */     //   720: new java/lang/StringBuilder
/*     */     //   723: dup
/*     */     //   724: ldc 'Adding classpath elements from wildcarded directory: '
/*     */     //   726: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   729: aload #5
/*     */     //   731: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   734: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   737: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   740: astore #4
/*     */     //   742: aload_1
/*     */     //   743: invokevirtual listFiles : ()[Ljava/io/File;
/*     */     //   746: dup
/*     */     //   747: astore_1
/*     */     //   748: ifnull -> 964
/*     */     //   751: aload_1
/*     */     //   752: dup
/*     */     //   753: astore_1
/*     */     //   754: arraylength
/*     */     //   755: istore #5
/*     */     //   757: iconst_0
/*     */     //   758: istore #6
/*     */     //   760: iload #6
/*     */     //   762: iload #5
/*     */     //   764: if_icmpge -> 962
/*     */     //   767: aload_1
/*     */     //   768: iload #6
/*     */     //   770: aaload
/*     */     //   771: dup
/*     */     //   772: astore #7
/*     */     //   774: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   777: dup
/*     */     //   778: astore #8
/*     */     //   780: ldc '.'
/*     */     //   782: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   785: ifne -> 956
/*     */     //   788: aload #8
/*     */     //   790: ldc '..'
/*     */     //   792: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   795: ifne -> 956
/*     */     //   798: aload #7
/*     */     //   800: invokevirtual getPath : ()Ljava/lang/String;
/*     */     //   803: astore #7
/*     */     //   805: invokestatic currDirPath : ()Ljava/lang/String;
/*     */     //   808: aload #7
/*     */     //   810: invokestatic resolve : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   813: astore #8
/*     */     //   815: aload_0
/*     */     //   816: aload #8
/*     */     //   818: dup
/*     */     //   819: aload_2
/*     */     //   820: aload_3
/*     */     //   821: invokespecial addClasspathEntry : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassLoader;Lnonapi/io/github/classgraph/scanspec/ScanSpec;)Z
/*     */     //   824: ifeq -> 893
/*     */     //   827: aload #4
/*     */     //   829: ifnull -> 956
/*     */     //   832: aload #4
/*     */     //   834: new java/lang/StringBuilder
/*     */     //   837: dup
/*     */     //   838: ldc 'Found classpath element: '
/*     */     //   840: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   843: aload #7
/*     */     //   845: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   848: aload #7
/*     */     //   850: aload #8
/*     */     //   852: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   855: ifeq -> 863
/*     */     //   858: ldc ''
/*     */     //   860: goto -> 880
/*     */     //   863: new java/lang/StringBuilder
/*     */     //   866: dup
/*     */     //   867: ldc ' -> '
/*     */     //   869: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   872: aload #8
/*     */     //   874: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   877: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   880: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   883: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   886: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   889: pop
/*     */     //   890: goto -> 956
/*     */     //   893: aload #4
/*     */     //   895: ifnull -> 956
/*     */     //   898: aload #4
/*     */     //   900: new java/lang/StringBuilder
/*     */     //   903: dup
/*     */     //   904: ldc 'Ignoring duplicate classpath element: '
/*     */     //   906: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   909: aload #7
/*     */     //   911: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   914: aload #7
/*     */     //   916: aload #8
/*     */     //   918: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   921: ifeq -> 929
/*     */     //   924: ldc ''
/*     */     //   926: goto -> 946
/*     */     //   929: new java/lang/StringBuilder
/*     */     //   932: dup
/*     */     //   933: ldc ' -> '
/*     */     //   935: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   938: aload #8
/*     */     //   940: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   943: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   946: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   949: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   952: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   955: pop
/*     */     //   956: iinc #6, 1
/*     */     //   959: goto -> 760
/*     */     //   962: iconst_1
/*     */     //   963: ireturn
/*     */     //   964: iconst_0
/*     */     //   965: ireturn
/*     */     //   966: aload #5
/*     */     //   968: bipush #42
/*     */     //   970: invokevirtual indexOf : (I)I
/*     */     //   973: iflt -> 1006
/*     */     //   976: aload #4
/*     */     //   978: ifnull -> 1004
/*     */     //   981: aload #4
/*     */     //   983: new java/lang/StringBuilder
/*     */     //   986: dup
/*     */     //   987: ldc 'Wildcard classpath elements can only end with a suffix of "/*", can't use globs elsewhere in the path: '
/*     */     //   989: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   992: aload #5
/*     */     //   994: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   997: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1000: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   1003: pop
/*     */     //   1004: iconst_0
/*     */     //   1005: ireturn
/*     */     //   1006: invokestatic currDirPath : ()Ljava/lang/String;
/*     */     //   1009: aload #5
/*     */     //   1011: invokestatic resolve : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   1014: astore #8
/*     */     //   1016: aload_0
/*     */     //   1017: aload #6
/*     */     //   1019: aload #5
/*     */     //   1021: invokespecial filter : (Ljava/net/URL;Ljava/lang/String;)Z
/*     */     //   1024: ifeq -> 1048
/*     */     //   1027: aload #8
/*     */     //   1029: aload #5
/*     */     //   1031: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1034: ifne -> 1113
/*     */     //   1037: aload_0
/*     */     //   1038: aload #6
/*     */     //   1040: aload #8
/*     */     //   1042: invokespecial filter : (Ljava/net/URL;Ljava/lang/String;)Z
/*     */     //   1045: ifne -> 1113
/*     */     //   1048: aload #4
/*     */     //   1050: ifnull -> 1111
/*     */     //   1053: aload #4
/*     */     //   1055: new java/lang/StringBuilder
/*     */     //   1058: dup
/*     */     //   1059: ldc 'Classpath element did not match filter criterion, skipping: '
/*     */     //   1061: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1064: aload #5
/*     */     //   1066: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1069: aload #5
/*     */     //   1071: aload #8
/*     */     //   1073: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1076: ifeq -> 1084
/*     */     //   1079: ldc ''
/*     */     //   1081: goto -> 1101
/*     */     //   1084: new java/lang/StringBuilder
/*     */     //   1087: dup
/*     */     //   1088: ldc ' -> '
/*     */     //   1090: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1093: aload #8
/*     */     //   1095: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1098: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1101: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1104: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1107: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   1110: pop
/*     */     //   1111: iconst_0
/*     */     //   1112: ireturn
/*     */     //   1113: aload #8
/*     */     //   1115: ldc '//'
/*     */     //   1117: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   1120: ifeq -> 1278
/*     */     //   1123: new java/io/File
/*     */     //   1126: dup
/*     */     //   1127: aload #8
/*     */     //   1129: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1132: astore #9
/*     */     //   1134: aload_0
/*     */     //   1135: aload #9
/*     */     //   1137: aload #8
/*     */     //   1139: aload_2
/*     */     //   1140: aload_3
/*     */     //   1141: invokespecial addClasspathEntry : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassLoader;Lnonapi/io/github/classgraph/scanspec/ScanSpec;)Z
/*     */     //   1144: ifeq -> 1212
/*     */     //   1147: aload #4
/*     */     //   1149: ifnull -> 1210
/*     */     //   1152: aload #4
/*     */     //   1154: new java/lang/StringBuilder
/*     */     //   1157: dup
/*     */     //   1158: ldc 'Found classpath element: '
/*     */     //   1160: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1163: aload #9
/*     */     //   1165: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   1168: aload #5
/*     */     //   1170: aload #8
/*     */     //   1172: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1175: ifeq -> 1183
/*     */     //   1178: ldc ''
/*     */     //   1180: goto -> 1200
/*     */     //   1183: new java/lang/StringBuilder
/*     */     //   1186: dup
/*     */     //   1187: ldc ' -> '
/*     */     //   1189: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1192: aload #8
/*     */     //   1194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1197: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1203: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1206: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   1209: pop
/*     */     //   1210: iconst_1
/*     */     //   1211: ireturn
/*     */     //   1212: aload #4
/*     */     //   1214: ifnull -> 1275
/*     */     //   1217: aload #4
/*     */     //   1219: new java/lang/StringBuilder
/*     */     //   1222: dup
/*     */     //   1223: ldc 'Ignoring duplicate classpath element: '
/*     */     //   1225: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1228: aload #5
/*     */     //   1230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1233: aload #5
/*     */     //   1235: aload #8
/*     */     //   1237: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1240: ifeq -> 1248
/*     */     //   1243: ldc ''
/*     */     //   1245: goto -> 1265
/*     */     //   1248: new java/lang/StringBuilder
/*     */     //   1251: dup
/*     */     //   1252: ldc ' -> '
/*     */     //   1254: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1257: aload #8
/*     */     //   1259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1262: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1268: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1271: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   1274: pop
/*     */     //   1275: iconst_0
/*     */     //   1276: ireturn
/*     */     //   1277: pop
/*     */     //   1278: aload_0
/*     */     //   1279: aload #8
/*     */     //   1281: dup
/*     */     //   1282: aload_2
/*     */     //   1283: aload_3
/*     */     //   1284: invokespecial addClasspathEntry : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/ClassLoader;Lnonapi/io/github/classgraph/scanspec/ScanSpec;)Z
/*     */     //   1287: ifeq -> 1355
/*     */     //   1290: aload #4
/*     */     //   1292: ifnull -> 1353
/*     */     //   1295: aload #4
/*     */     //   1297: new java/lang/StringBuilder
/*     */     //   1300: dup
/*     */     //   1301: ldc 'Found classpath element: '
/*     */     //   1303: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1306: aload #5
/*     */     //   1308: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1311: aload #5
/*     */     //   1313: aload #8
/*     */     //   1315: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1318: ifeq -> 1326
/*     */     //   1321: ldc ''
/*     */     //   1323: goto -> 1343
/*     */     //   1326: new java/lang/StringBuilder
/*     */     //   1329: dup
/*     */     //   1330: ldc ' -> '
/*     */     //   1332: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1335: aload #8
/*     */     //   1337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1340: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1346: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1349: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   1352: pop
/*     */     //   1353: iconst_1
/*     */     //   1354: ireturn
/*     */     //   1355: aload #4
/*     */     //   1357: ifnull -> 1418
/*     */     //   1360: aload #4
/*     */     //   1362: new java/lang/StringBuilder
/*     */     //   1365: dup
/*     */     //   1366: ldc 'Ignoring duplicate classpath element: '
/*     */     //   1368: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1371: aload #5
/*     */     //   1373: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1376: aload #5
/*     */     //   1378: aload #8
/*     */     //   1380: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1383: ifeq -> 1391
/*     */     //   1386: ldc ''
/*     */     //   1388: goto -> 1408
/*     */     //   1391: new java/lang/StringBuilder
/*     */     //   1394: dup
/*     */     //   1395: ldc ' -> '
/*     */     //   1397: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1400: aload #8
/*     */     //   1402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1405: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1411: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1414: invokevirtual log : (Ljava/lang/String;)Lnonapi/io/github/classgraph/utils/LogNode;
/*     */     //   1417: pop
/*     */     //   1418: iconst_0
/*     */     //   1419: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #292	-> 0
/*     */     //   #293	-> 4
/*     */     //   #296	-> 6
/*     */     //   #299	-> 13
/*     */     //   #302	-> 26
/*     */     //   #303	-> 36
/*     */     //   #307	-> 50
/*     */     //   #305	-> 53
/*     */     //   #309	-> 54
/*     */     //   #311	-> 60
/*     */     //   #312	-> 69
/*     */     //   #313	-> 77
/*     */     //   #315	-> 79
/*     */     //   #316	-> 82
/*     */     //   #318	-> 85
/*     */     //   #319	-> 105
/*     */     //   #320	-> 108
/*     */     //   #322	-> 126
/*     */     //   #323	-> 136
/*     */     //   #324	-> 139
/*     */     //   #327	-> 146
/*     */     //   #328	-> 155
/*     */     //   #332	-> 163
/*     */     //   #333	-> 188
/*     */     //   #334	-> 205
/*     */     //   #335	-> 227
/*     */     //   #339	-> 239
/*     */     //   #337	-> 242
/*     */     //   #340	-> 243
/*     */     //   #342	-> 248
/*     */     //   #344	-> 259
/*     */     //   #357	-> 270
/*     */     //   #345	-> 273
/*     */     //   #347	-> 274
/*     */     //   #356	-> 291
/*     */     //   #348	-> 294
/*     */     //   #352	-> 295
/*     */     //   #355	-> 306
/*     */     //   #353	-> 309
/*     */     //   #359	-> 310
/*     */     //   #360	-> 315
/*     */     //   #361	-> 320
/*     */     //   #366	-> 342
/*     */     //   #368	-> 368
/*     */     //   #369	-> 379
/*     */     //   #370	-> 384
/*     */     //   #372	-> 407
/*     */     //   #377	-> 409
/*     */     //   #379	-> 434
/*     */     //   #380	-> 447
/*     */     //   #381	-> 452
/*     */     //   #383	-> 475
/*     */     //   #385	-> 477
/*     */     //   #386	-> 482
/*     */     //   #388	-> 505
/*     */     //   #391	-> 507
/*     */     //   #394	-> 512
/*     */     //   #395	-> 516
/*     */     //   #396	-> 526
/*     */     //   #397	-> 541
/*     */     //   #398	-> 558
/*     */     //   #399	-> 563
/*     */     //   #401	-> 586
/*     */     //   #405	-> 588
/*     */     //   #406	-> 598
/*     */     //   #407	-> 605
/*     */     //   #408	-> 610
/*     */     //   #410	-> 633
/*     */     //   #412	-> 635
/*     */     //   #413	-> 642
/*     */     //   #414	-> 647
/*     */     //   #416	-> 670
/*     */     //   #418	-> 672
/*     */     //   #419	-> 679
/*     */     //   #420	-> 684
/*     */     //   #422	-> 707
/*     */     //   #426	-> 709
/*     */     //   #427	-> 737
/*     */     //   #428	-> 742
/*     */     //   #429	-> 747
/*     */     //   #430	-> 751
/*     */     //   #431	-> 772
/*     */     //   #432	-> 778
/*     */     //   #434	-> 798
/*     */     //   #435	-> 805
/*     */     //   #437	-> 815
/*     */     //   #439	-> 827
/*     */     //   #440	-> 832
/*     */     //   #441	-> 852
/*     */     //   #440	-> 886
/*     */     //   #445	-> 893
/*     */     //   #446	-> 898
/*     */     //   #447	-> 918
/*     */     //   #446	-> 952
/*     */     //   #430	-> 956
/*     */     //   #453	-> 962
/*     */     //   #455	-> 964
/*     */     //   #459	-> 966
/*     */     //   #460	-> 976
/*     */     //   #461	-> 981
/*     */     //   #464	-> 1004
/*     */     //   #466	-> 1006
/*     */     //   #467	-> 1016
/*     */     //   #468	-> 1042
/*     */     //   #469	-> 1048
/*     */     //   #470	-> 1053
/*     */     //   #471	-> 1073
/*     */     //   #470	-> 1107
/*     */     //   #473	-> 1111
/*     */     //   #475	-> 1113
/*     */     //   #480	-> 1123
/*     */     //   #481	-> 1134
/*     */     //   #482	-> 1147
/*     */     //   #483	-> 1152
/*     */     //   #484	-> 1172
/*     */     //   #483	-> 1206
/*     */     //   #487	-> 1210
/*     */     //   #489	-> 1212
/*     */     //   #490	-> 1217
/*     */     //   #491	-> 1237
/*     */     //   #490	-> 1271
/*     */     //   #494	-> 1275
/*     */     //   #496	-> 1277
/*     */     //   #500	-> 1278
/*     */     //   #501	-> 1290
/*     */     //   #502	-> 1295
/*     */     //   #503	-> 1315
/*     */     //   #502	-> 1349
/*     */     //   #505	-> 1353
/*     */     //   #507	-> 1355
/*     */     //   #508	-> 1360
/*     */     //   #509	-> 1380
/*     */     //   #508	-> 1414
/*     */     //   #511	-> 1418
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   13	50	53	java/io/IOError
/*     */     //   13	50	53	java/lang/SecurityException
/*     */     //   163	239	242	java/net/MalformedURLException
/*     */     //   163	239	242	java/lang/IllegalArgumentException
/*     */     //   163	239	242	java/io/IOError
/*     */     //   163	239	242	java/lang/SecurityException
/*     */     //   259	270	273	java/net/MalformedURLException
/*     */     //   274	291	294	java/net/MalformedURLException
/*     */     //   274	291	294	java/lang/IllegalArgumentException
/*     */     //   274	291	294	java/io/IOError
/*     */     //   274	291	294	java/lang/SecurityException
/*     */     //   295	306	309	java/net/MalformedURLException
/*     */     //   1123	1211	1277	java/lang/Exception
/*     */     //   1212	1276	1277	java/lang/Exception
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addClasspathEntries(List<Object> paramList, ClassLoader paramClassLoader, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 531 */     if (paramList == null || paramList.isEmpty()) {
/* 532 */       return false;
/*     */     }
/* 534 */     for (Object object : paramList) {
/* 535 */       addClasspathEntry(object, paramClassLoader, paramScanSpec, paramLogNode);
/*     */     }
/* 537 */     return true;
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
/*     */   public boolean addClasspathPathStr(String paramString, ClassLoader paramClassLoader, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 556 */     if (paramString == null || paramString.isEmpty()) {
/* 557 */       return false;
/*     */     }
/*     */     String[] arrayOfString;
/* 560 */     if ((arrayOfString = JarUtils.smartPathSplit(paramString, paramScanSpec)).length == 0)
/* 561 */       return false;  int i;
/*     */     byte b;
/* 563 */     for (i = (arrayOfString = arrayOfString).length, b = 0; b < i; ) { String str = arrayOfString[b];
/* 564 */       addClasspathEntry(str, paramClassLoader, paramScanSpec, paramLogNode); b++; }
/*     */     
/* 566 */     return true;
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
/*     */   public boolean addClasspathEntryObject(Object paramObject, ClassLoader paramClassLoader, ScanSpec paramScanSpec, LogNode paramLogNode) {
/* 590 */     int i = 0;
/* 591 */     if (paramObject != null)
/* 592 */       if (paramObject instanceof URL || paramObject instanceof URI || paramObject instanceof java.nio.file.Path || paramObject instanceof java.io.File)
/*     */       
/* 594 */       { i = false | addClasspathEntry(paramObject, paramClassLoader, paramScanSpec, paramLogNode); }
/* 595 */       else { boolean bool; if (paramObject instanceof Iterable) {
/* 596 */           for (Object object : paramObject) {
/* 597 */             bool = i | addClasspathEntryObject(object, paramClassLoader, paramScanSpec, paramLogNode);
/*     */           }
/*     */         } else {
/*     */           Class<?> clazz;
/* 601 */           if ((clazz = paramObject.getClass()).isArray()) {
/* 602 */             int j; byte b; for (b = 0, j = Array.getLength(paramObject); b < j; b++) {
/* 603 */               Object object = Array.get(paramObject, b);
/* 604 */               bool |= addClasspathEntryObject(object, paramClassLoader, paramScanSpec, paramLogNode);
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 609 */             i = false | addClasspathPathStr(paramObject.toString(), paramClassLoader, paramScanSpec, paramLogNode);
/*     */           } 
/*     */         }  }
/*     */        
/* 613 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\classpath\ClasspathOrder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */