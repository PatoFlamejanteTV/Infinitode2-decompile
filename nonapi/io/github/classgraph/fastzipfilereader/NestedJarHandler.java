/*      */ package nonapi.io.github.classgraph.fastzipfilereader;
/*      */ 
/*      */ import io.github.classgraph.ModuleReaderProxy;
/*      */ import io.github.classgraph.ModuleRef;
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.lang.reflect.Method;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.URI;
/*      */ import java.net.URL;
/*      */ import java.net.URLConnection;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.file.FileSystem;
/*      */ import java.nio.file.FileSystemNotFoundException;
/*      */ import java.nio.file.Files;
/*      */ import java.nio.file.Path;
/*      */ import java.nio.file.Paths;
/*      */ import java.util.AbstractMap;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.atomic.AtomicBoolean;
/*      */ import java.util.zip.DataFormatException;
/*      */ import java.util.zip.Inflater;
/*      */ import java.util.zip.ZipException;
/*      */ import nonapi.io.github.classgraph.concurrency.InterruptionChecker;
/*      */ import nonapi.io.github.classgraph.concurrency.SingletonMap;
/*      */ import nonapi.io.github.classgraph.fileslice.ArraySlice;
/*      */ import nonapi.io.github.classgraph.fileslice.FileSlice;
/*      */ import nonapi.io.github.classgraph.fileslice.Slice;
/*      */ import nonapi.io.github.classgraph.recycler.Recycler;
/*      */ import nonapi.io.github.classgraph.recycler.Resettable;
/*      */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*      */ import nonapi.io.github.classgraph.scanspec.ScanSpec;
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
/*      */ public class NestedJarHandler
/*      */ {
/*      */   public final ScanSpec scanSpec;
/*      */   public ReflectionUtils reflectionUtils;
/*      */   
/*   93 */   private SingletonMap<File, PhysicalZipFile, IOException> canonicalFileToPhysicalZipFileMap = new SingletonMap<File, PhysicalZipFile, IOException>()
/*      */     {
/*      */       public PhysicalZipFile newInstance(File param1File, LogNode param1LogNode)
/*      */       {
/*   97 */         return new PhysicalZipFile(param1File, NestedJarHandler.this, param1LogNode);
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  106 */   private SingletonMap<FastZipEntry, ZipFileSlice, IOException> fastZipEntryToZipFileSliceMap = new SingletonMap<FastZipEntry, ZipFileSlice, IOException>()
/*      */     {
/*      */       public ZipFileSlice newInstance(FastZipEntry param1FastZipEntry, LogNode param1LogNode)
/*      */       {
/*      */         ZipFileSlice zipFileSlice;
/*      */         
/*  112 */         if (!param1FastZipEntry.isDeflated) {
/*      */ 
/*      */           
/*  115 */           zipFileSlice = new ZipFileSlice(param1FastZipEntry);
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */           
/*  121 */           if (param1LogNode != null) {
/*  122 */             param1LogNode.log("Inflating nested zip entry: " + zipFileSlice + " ; uncompressed size: " + ((FastZipEntry)zipFileSlice).uncompressedSize);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*  127 */           PhysicalZipFile physicalZipFile = new PhysicalZipFile(zipFileSlice.getSlice().open(), (((FastZipEntry)zipFileSlice).uncompressedSize >= 0L && ((FastZipEntry)zipFileSlice).uncompressedSize <= 2147483639L) ? (int)((FastZipEntry)zipFileSlice).uncompressedSize : -1L, ((FastZipEntry)zipFileSlice).entryName, NestedJarHandler.this, param1LogNode);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  135 */           zipFileSlice = new ZipFileSlice(physicalZipFile, (FastZipEntry)zipFileSlice);
/*      */         } 
/*  137 */         return zipFileSlice;
/*      */       }
/*      */     };
/*      */ 
/*      */   
/*  142 */   private SingletonMap<ZipFileSlice, LogicalZipFile, IOException> zipFileSliceToLogicalZipFileMap = new SingletonMap<ZipFileSlice, LogicalZipFile, IOException>()
/*      */     {
/*      */ 
/*      */       
/*      */       public LogicalZipFile newInstance(ZipFileSlice param1ZipFileSlice, LogNode param1LogNode)
/*      */       {
/*  148 */         return new LogicalZipFile(param1ZipFileSlice, NestedJarHandler.this, param1LogNode, NestedJarHandler.this.scanSpec.enableMultiReleaseVersions);
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  157 */   public SingletonMap<String, Map.Entry<LogicalZipFile, String>, IOException> nestedPathToLogicalZipFileAndPackageRootMap = new SingletonMap<String, Map.Entry<LogicalZipFile, String>, IOException>()
/*      */     {
/*      */       public Map.Entry<LogicalZipFile, String> newInstance(String param1String, LogNode param1LogNode) {
/*      */         PhysicalZipFile physicalZipFile;
/*      */         FastZipEntry fastZipEntry;
/*      */         ZipFileSlice zipFileSlice;
/*      */         LogicalZipFile logicalZipFile2;
/*      */         int i;
/*  165 */         if ((i = (param1String = FastPathResolver.resolve(param1String)).lastIndexOf('!')) < 0) {
/*      */           LogicalZipFile logicalZipFile;
/*      */ 
/*      */ 
/*      */           
/*      */           boolean bool1;
/*      */ 
/*      */ 
/*      */           
/*  174 */           if (bool1 = JarUtils.URL_SCHEME_PATTERN.matcher(param1String).matches()) {
/*  175 */             String str = param1String.substring(0, param1String.indexOf(':'));
/*  176 */             if (NestedJarHandler.this.scanSpec.allowedURLSchemes == null || 
/*  177 */               !NestedJarHandler.this.scanSpec.allowedURLSchemes.contains(str))
/*      */             {
/*      */               
/*  180 */               throw new IOException("Scanning of URL scheme \"" + str + "\" has not been enabled -- cannot scan classpath element: " + param1String);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  186 */             physicalZipFile = NestedJarHandler.this.downloadJarFromURL(param1String, param1LogNode);
/*      */           } else {
/*      */ 
/*      */             
/*      */             try {
/*      */               
/*  192 */               File file = (new File(param1String)).getCanonicalFile();
/*      */               
/*  194 */               physicalZipFile = (PhysicalZipFile)NestedJarHandler.this.canonicalFileToPhysicalZipFileMap.get(file, param1LogNode);
/*  195 */             } catch (nonapi.io.github.classgraph.concurrency.SingletonMap.NullSingletonException|nonapi.io.github.classgraph.concurrency.SingletonMap.NewInstanceException nullSingletonException) {
/*      */               
/*  197 */               throw new IOException("Could not get PhysicalZipFile for path " + param1String + " : " + (
/*  198 */                   (nullSingletonException.getCause() == null) ? nullSingletonException : nullSingletonException.getCause()));
/*  199 */             } catch (SecurityException securityException) {
/*      */               
/*  201 */               throw new IOException("Path component " + param1String + " could not be canonicalized: " + securityException);
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  207 */           ZipFileSlice zipFileSlice1 = new ZipFileSlice(physicalZipFile);
/*      */           
/*      */           try {
/*  210 */             logicalZipFile = (LogicalZipFile)NestedJarHandler.this.zipFileSliceToLogicalZipFileMap.get(zipFileSlice1, param1LogNode);
/*  211 */           } catch (nonapi.io.github.classgraph.concurrency.SingletonMap.NullSingletonException nullSingletonException) {
/*  212 */             throw new IOException("Could not get toplevel slice " + zipFileSlice1 + " : " + nullSingletonException);
/*  213 */           } catch (nonapi.io.github.classgraph.concurrency.SingletonMap.NewInstanceException newInstanceException) {
/*  214 */             throw new IOException("Could not get toplevel slice " + zipFileSlice1, newInstanceException);
/*      */           } 
/*      */ 
/*      */           
/*  218 */           return new AbstractMap.SimpleEntry<>(logicalZipFile, "");
/*      */         } 
/*      */ 
/*      */         
/*  222 */         String str2 = param1String.substring(0, physicalZipFile);
/*      */ 
/*      */         
/*  225 */         String str1 = FileUtils.sanitizeEntryPath(str1 = param1String.substring(physicalZipFile + 1), true, true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/*  235 */           entry = (Map.Entry)NestedJarHandler.this.nestedPathToLogicalZipFileAndPackageRootMap.get(str2, param1LogNode);
/*  236 */         } catch (nonapi.io.github.classgraph.concurrency.SingletonMap.NullSingletonException nullSingletonException) {
/*  237 */           throw new IOException("Could not get parent logical zipfile " + str2 + " : " + nullSingletonException);
/*  238 */         } catch (nonapi.io.github.classgraph.concurrency.SingletonMap.NewInstanceException newInstanceException) {
/*  239 */           throw new IOException("Could not get parent logical zipfile " + str2, newInstanceException);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  244 */         LogicalZipFile logicalZipFile1 = (LogicalZipFile)entry.getKey();
/*      */ 
/*      */         
/*  247 */         boolean bool = false;
/*  248 */         while (str1.endsWith("/")) {
/*      */           
/*  250 */           bool = true;
/*  251 */           str1 = str1.substring(0, str1.length() - 1);
/*      */         } 
/*  253 */         Map.Entry entry = null;
/*  254 */         if (!bool)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  264 */           for (Iterator<FastZipEntry> iterator = logicalZipFile1.entries.iterator(); iterator.hasNext();) {
/*  265 */             if ((fastZipEntry1 = iterator.next()).entryName.equals(str1)) {
/*  266 */               fastZipEntry = fastZipEntry1;
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         }
/*  271 */         if (fastZipEntry == null) {
/*      */ 
/*      */           
/*  274 */           String str = str1 + "/";
/*  275 */           for (Iterator<FastZipEntry> iterator = logicalZipFile1.entries.iterator(); iterator.hasNext();) {
/*  276 */             if ((fastZipEntry1 = iterator.next()).entryName.startsWith(str)) {
/*  277 */               bool = true;
/*      */ 
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/*  285 */         if (bool) {
/*  286 */           if (!str1.isEmpty()) {
/*      */ 
/*      */ 
/*      */             
/*  290 */             if (param1LogNode != null) {
/*  291 */               param1LogNode.log("Path " + str1 + " in jarfile " + logicalZipFile1 + " is a directory, not a file -- using as package root");
/*      */             }
/*      */             
/*  294 */             logicalZipFile1.classpathRoots.add(str1);
/*      */           } 
/*      */           
/*  297 */           return new AbstractMap.SimpleEntry<>(logicalZipFile1, str1);
/*      */         } 
/*      */         
/*  300 */         if (fastZipEntry == null) {
/*  301 */           throw new IOException("Path " + str1 + " does not exist in jarfile " + logicalZipFile1);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  306 */         if (!NestedJarHandler.this.scanSpec.scanNestedJars) {
/*  307 */           throw new IOException("Nested jar scanning is disabled -- skipping nested jar " + param1String);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/*  320 */           zipFileSlice = (ZipFileSlice)NestedJarHandler.this.fastZipEntryToZipFileSliceMap.get(fastZipEntry, param1LogNode);
/*  321 */         } catch (nonapi.io.github.classgraph.concurrency.SingletonMap.NullSingletonException nullSingletonException) {
/*  322 */           throw new IOException("Could not get child zip entry slice " + fastZipEntry + " : " + nullSingletonException);
/*      */         }
/*  324 */         catch (nonapi.io.github.classgraph.concurrency.SingletonMap.NewInstanceException newInstanceException) {
/*  325 */           throw new IOException("Could not get child zip entry slice " + fastZipEntry, newInstanceException);
/*      */         } 
/*      */ 
/*      */         
/*  329 */         LogNode logNode = (param1LogNode == null) ? null : param1LogNode.log("Getting zipfile slice " + zipFileSlice + " for nested jar " + fastZipEntry.entryName);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/*  335 */           logicalZipFile2 = (LogicalZipFile)NestedJarHandler.this.zipFileSliceToLogicalZipFileMap.get(zipFileSlice, logNode);
/*      */         }
/*  337 */         catch (nonapi.io.github.classgraph.concurrency.SingletonMap.NullSingletonException nullSingletonException) {
/*  338 */           throw new IOException("Could not get child logical zipfile " + zipFileSlice + " : " + nullSingletonException);
/*      */         }
/*  340 */         catch (nonapi.io.github.classgraph.concurrency.SingletonMap.NewInstanceException newInstanceException) {
/*  341 */           throw new IOException("Could not get child logical zipfile " + zipFileSlice, newInstanceException);
/*      */         } 
/*      */ 
/*      */         
/*  345 */         return new AbstractMap.SimpleEntry<>(logicalZipFile2, "");
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */   
/*  351 */   public SingletonMap<ModuleRef, Recycler<ModuleReaderProxy, IOException>, IOException> moduleRefToModuleReaderProxyRecyclerMap = new SingletonMap<ModuleRef, Recycler<ModuleReaderProxy, IOException>, IOException>()
/*      */     {
/*      */ 
/*      */       
/*      */       public Recycler<ModuleReaderProxy, IOException> newInstance(final ModuleRef moduleRef, LogNode param1LogNode)
/*      */       {
/*  357 */         return new Recycler<ModuleReaderProxy, IOException>()
/*      */           {
/*      */             public ModuleReaderProxy newInstance() {
/*  360 */               return moduleRef.open();
/*      */             }
/*      */           };
/*      */       }
/*      */     };
/*      */ 
/*      */   
/*  367 */   private Recycler<RecyclableInflater, RuntimeException> inflaterRecycler = new Recycler<RecyclableInflater, RuntimeException>()
/*      */     {
/*      */       public NestedJarHandler.RecyclableInflater newInstance()
/*      */       {
/*  371 */         return new NestedJarHandler.RecyclableInflater();
/*      */       }
/*      */     };
/*      */ 
/*      */   
/*  376 */   private Set<Slice> openSlices = Collections.newSetFromMap(new ConcurrentHashMap<>());
/*      */ 
/*      */   
/*  379 */   private Set<File> tempFiles = Collections.newSetFromMap(new ConcurrentHashMap<>());
/*      */ 
/*      */   
/*      */   public static final String TEMP_FILENAME_LEAF_SEPARATOR = "---";
/*      */ 
/*      */   
/*  385 */   private final AtomicBoolean closed = new AtomicBoolean(false);
/*      */ 
/*      */ 
/*      */   
/*      */   public InterruptionChecker interruptionChecker;
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int DEFAULT_BUFFER_SIZE = 16384;
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MAX_INITIAL_BUFFER_SIZE = 16777216;
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int HTTP_TIMEOUT = 5000;
/*      */ 
/*      */ 
/*      */   
/*      */   private static Method runFinalizationMethod;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NestedJarHandler(ScanSpec paramScanSpec, InterruptionChecker paramInterruptionChecker, ReflectionUtils paramReflectionUtils) {
/*  411 */     this.scanSpec = paramScanSpec;
/*  412 */     this.interruptionChecker = paramInterruptionChecker;
/*  413 */     this.reflectionUtils = paramReflectionUtils;
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
/*      */   private static String leafname(String paramString) {
/*  426 */     return paramString.substring(paramString.lastIndexOf('/') + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String sanitizeFilename(String paramString) {
/*  437 */     return paramString.replace('/', '_').replace('\\', '_').replace(':', '_').replace('?', '_').replace('&', '_')
/*  438 */       .replace('=', '_').replace(' ', '_');
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
/*      */   public File makeTempFile(String paramString, boolean paramBoolean) {
/*      */     File file;
/*  455 */     (file = File.createTempFile("ClassGraph--", "---" + sanitizeFilename(paramBoolean ? leafname(paramString) : paramString))).deleteOnExit();
/*  456 */     this.tempFiles.add(file);
/*  457 */     return file;
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
/*      */   void removeTempFile(File paramFile) {
/*  471 */     if (this.tempFiles.remove(paramFile)) {
/*  472 */       Files.delete(paramFile.toPath()); return;
/*      */     } 
/*  474 */     throw new IOException("Not a temp file: " + paramFile);
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
/*      */   public void markSliceAsOpen(Slice paramSlice) {
/*  487 */     this.openSlices.add(paramSlice);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void markSliceAsClosed(Slice paramSlice) {
/*  497 */     this.openSlices.remove(paramSlice);
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
/*      */   private PhysicalZipFile downloadJarFromURL(String paramString, LogNode paramLogNode) {
/*      */     URL uRL;
/*      */     try {
/*  523 */       uRL = new URL(paramString);
/*  524 */     } catch (MalformedURLException malformedURLException) {
/*      */       try {
/*  526 */         uRL = (new URI(paramString)).toURL();
/*  527 */       } catch (MalformedURLException|IllegalArgumentException|java.net.URISyntaxException malformedURLException1) {
/*  528 */         throw new IOException("Could not parse URL: " + paramString);
/*      */       } 
/*      */     } 
/*      */     
/*      */     String str;
/*  533 */     if (!(str = uRL.getProtocol()).equalsIgnoreCase("http") && !str.equalsIgnoreCase("https")) {
/*      */       try {
/*      */         Path path;
/*      */ 
/*      */ 
/*      */         
/*  539 */         FileSystem fileSystem = (path = Paths.get(uRL.toURI())).getFileSystem();
/*  540 */         if (paramLogNode != null) {
/*  541 */           paramLogNode.log("URL " + paramString + " is backed by filesystem " + fileSystem.getClass().getName());
/*      */         }
/*      */         
/*  544 */         return new PhysicalZipFile(path, this, paramLogNode);
/*  545 */       } catch (IllegalArgumentException|SecurityException|java.net.URISyntaxException illegalArgumentException) {
/*  546 */         throw new IOException("Could not convert URL to URI (" + illegalArgumentException + "): " + uRL);
/*  547 */       } catch (FileSystemNotFoundException fileSystemNotFoundException) {}
/*      */     }
/*      */ 
/*      */     
/*  551 */     CloseableUrlConnection closeableUrlConnection = new CloseableUrlConnection(uRL); Throwable throwable = null;
/*      */     try {
/*  553 */       closeableUrlConnection.conn.setConnectTimeout(5000);
/*  554 */       closeableUrlConnection.conn.connect();
/*  555 */       if (closeableUrlConnection.httpConn != null) {
/*      */         
/*  557 */         if (closeableUrlConnection.httpConn.getResponseCode() != 200) {
/*  558 */           throw new IOException("Got response code " + closeableUrlConnection.httpConn
/*  559 */               .getResponseCode() + " for URL " + uRL);
/*      */         }
/*  561 */       } else if (uRL.getProtocol().equalsIgnoreCase("file")) {
/*      */ 
/*      */         
/*      */         try {
/*      */ 
/*      */           
/*  567 */           File file = Paths.get(uRL.toURI()).toFile();
/*  568 */           return new PhysicalZipFile(file, this, paramLogNode);
/*      */         }
/*  570 */         catch (Exception exception) {}
/*      */       } 
/*      */ 
/*      */       
/*      */       long l;
/*      */       
/*  576 */       if ((l = closeableUrlConnection.conn.getContentLengthLong()) < -1L) {
/*  577 */         l = -1L;
/*      */       }
/*      */       
/*  580 */       LogNode logNode = (throwable1 == null) ? null : throwable1.log("Downloading jar from URL " + paramString);
/*      */     } catch (Throwable throwable2) {
/*      */       Throwable throwable1 = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       throw throwable1;
/*      */     } finally {
/*  597 */       if (throwable != null) { try { closeableUrlConnection.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { closeableUrlConnection.close(); }
/*      */     
/*      */     } 
/*      */   }
/*      */   private static class CloseableUrlConnection implements AutoCloseable { public final URLConnection conn;
/*      */     public final HttpURLConnection httpConn;
/*      */     
/*      */     public CloseableUrlConnection(URL param1URL) {
/*  605 */       this.conn = param1URL.openConnection();
/*  606 */       this.httpConn = (this.conn instanceof HttpURLConnection) ? (HttpURLConnection)this.conn : null;
/*      */     }
/*      */ 
/*      */     
/*      */     public void close() {
/*  611 */       if (this.httpConn != null) {
/*  612 */         this.httpConn.disconnect();
/*      */       }
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class RecyclableInflater
/*      */     implements AutoCloseable, Resettable
/*      */   {
/*  627 */     private final Inflater inflater = new Inflater(true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Inflater getInflater() {
/*  635 */       return this.inflater;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void reset() {
/*  643 */       this.inflater.reset();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/*  649 */       this.inflater.end();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private RecyclableInflater() {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStream openInflaterInputStream(final InputStream rawInputStream) {
/*  663 */     return new InputStream()
/*      */       {
/*  665 */         private final NestedJarHandler.RecyclableInflater recyclableInflater = (NestedJarHandler.RecyclableInflater)NestedJarHandler.this.inflaterRecycler.acquire();
/*  666 */         private final Inflater inflater = this.recyclableInflater.getInflater();
/*  667 */         private final AtomicBoolean closed = new AtomicBoolean();
/*  668 */         private final byte[] buf = new byte[8192];
/*      */         
/*      */         private static final int INFLATE_BUF_SIZE = 8192;
/*      */         
/*      */         public int read() {
/*  673 */           if (this.closed.get())
/*  674 */             throw new IOException("Already closed"); 
/*  675 */           if (this.inflater.finished()) {
/*  676 */             return -1;
/*      */           }
/*      */           int i;
/*  679 */           if ((i = read(this.buf, 0, 1)) < 0) {
/*  680 */             return -1;
/*      */           }
/*  682 */           return this.buf[0] & 0xFF;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/*  688 */           if (this.closed.get())
/*  689 */             throw new IOException("Already closed"); 
/*  690 */           if (param1Int2 < 0)
/*  691 */             throw new IllegalArgumentException("len cannot be negative"); 
/*  692 */           if (param1Int2 == 0) {
/*  693 */             return 0;
/*      */           }
/*      */           
/*      */           try {
/*  697 */             int i = 0;
/*  698 */             while (!this.inflater.finished() && i < param1Int2) {
/*      */               int j;
/*      */               
/*  701 */               if ((j = this.inflater.inflate(param1ArrayOfbyte, param1Int1 + i, param1Int2 - i)) == 0) {
/*  702 */                 if (this.inflater.needsDictionary())
/*      */                 {
/*  704 */                   throw new IOException("Inflater needs preset dictionary"); } 
/*  705 */                 if (this.inflater.needsInput()) {
/*      */ 
/*      */                   
/*  708 */                   if ((j = rawInputStream.read(this.buf, 0, this.buf.length)) == -1) {
/*      */ 
/*      */ 
/*      */                     
/*  712 */                     this.buf[0] = 0;
/*  713 */                     this.inflater.setInput(this.buf, 0, 1);
/*      */                     continue;
/*      */                   } 
/*  716 */                   this.inflater.setInput(this.buf, 0, j);
/*      */                 } 
/*      */                 continue;
/*      */               } 
/*  720 */               i += j;
/*      */             } 
/*      */             
/*  723 */             if (i == 0)
/*      */             {
/*  725 */               return -1;
/*      */             }
/*  727 */             return i;
/*      */           }
/*  729 */           catch (DataFormatException dataFormatException) {
/*  730 */             throw new ZipException(
/*  731 */                 (dataFormatException.getMessage() != null) ? dataFormatException.getMessage() : "Invalid deflated zip entry data");
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*      */         public long skip(long param1Long) {
/*  737 */           if (this.closed.get())
/*  738 */             throw new IOException("Already closed"); 
/*  739 */           if (param1Long < 0L)
/*  740 */             throw new IllegalArgumentException("numToSkip cannot be negative"); 
/*  741 */           if (param1Long == 0L)
/*  742 */             return 0L; 
/*  743 */           if (this.inflater.finished()) {
/*  744 */             return -1L;
/*      */           }
/*  746 */           long l = 0L;
/*      */           
/*  748 */           int i = (int)Math.min(param1Long - l, this.buf.length);
/*      */           
/*  750 */           while ((i = read(this.buf, 0, i)) > 0) {
/*  751 */             l -= i;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*  756 */           return l;
/*      */         }
/*      */ 
/*      */         
/*      */         public int available() {
/*  761 */           if (this.closed.get()) {
/*  762 */             throw new IOException("Already closed");
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*  767 */           return this.inflater.finished() ? 0 : 1;
/*      */         }
/*      */ 
/*      */         
/*      */         public synchronized void mark(int param1Int) {
/*  772 */           throw new IllegalArgumentException("Not supported");
/*      */         }
/*      */ 
/*      */         
/*      */         public synchronized void reset() {
/*  777 */           throw new IllegalArgumentException("Not supported");
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean markSupported() {
/*  782 */           return false;
/*      */         }
/*      */ 
/*      */         
/*      */         public void close() {
/*  787 */           if (!this.closed.getAndSet(true)) {
/*      */             try {
/*  789 */               rawInputStream.close();
/*  790 */             } catch (Exception exception) {}
/*      */ 
/*      */ 
/*      */             
/*  794 */             NestedJarHandler.this.inflaterRecycler.recycle(this.recyclableInflater);
/*      */           } 
/*      */         }
/*      */       };
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
/*      */   public Slice readAllBytesWithSpilloverToDisk(InputStream paramInputStream, String paramString, long paramLong, LogNode paramLogNode) {
/*  825 */     paramInputStream = paramInputStream; Throwable throwable2 = null; 
/*  826 */     try { FileSlice fileSlice; if (paramLong <= this.scanSpec.maxBufferedJarRAMSize) {
/*      */         byte[] arrayOfByte;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  836 */         int i = (arrayOfByte = new byte[i = (paramLong == -1L) ? this.scanSpec.maxBufferedJarRAMSize : ((paramLong == 0L) ? 16384 : Math.min((int)paramLong, this.scanSpec.maxBufferedJarRAMSize))]).length;
/*      */         
/*  838 */         int j = 0;
/*      */         int k;
/*  840 */         while ((k = paramInputStream.read(arrayOfByte, j, i - j)) > 0)
/*      */         {
/*  842 */           j += k;
/*      */         }
/*  844 */         if (k == 0) {
/*      */ 
/*      */           
/*  847 */           byte[] arrayOfByte1 = new byte[1];
/*      */           
/*  849 */           if ((k = paramInputStream.read(arrayOfByte1, 0, 1)) == 1) {
/*      */ 
/*      */             
/*  852 */             fileSlice = spillToDisk(paramInputStream, paramString, arrayOfByte, arrayOfByte1, paramLogNode); return (Slice)fileSlice;
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  857 */         if (j < arrayOfByte.length)
/*      */         {
/*      */           
/*  860 */           arrayOfByte = Arrays.copyOf(arrayOfByte, j);
/*      */         }
/*      */         
/*  863 */         return (Slice)new ArraySlice(arrayOfByte, false, 0L, this);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  868 */       return (Slice)spillToDisk((InputStream)throwable1, (String)fileSlice, null, null, paramLogNode); } catch (Throwable throwable4) { Throwable throwable3 = null; throw throwable3; }
/*  869 */     finally { if (throwable1 != null) if (throwable2 != null) { try { throwable1.close(); } catch (Throwable throwable) { throwable2.addSuppressed(throwable); }  } else { throwable.close(); }
/*      */       
/*      */        }
/*      */   
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
/*      */   private FileSlice spillToDisk(InputStream paramInputStream, String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, LogNode paramLogNode) {
/*      */     File file;
/*      */     byte[] arrayOfByte;
/*      */     try {
/*  895 */       file = makeTempFile(paramString, true);
/*  896 */     } catch (IOException iOException) {
/*  897 */       throw new IOException("Could not create temporary file: " + iOException.getMessage());
/*      */     } 
/*  899 */     if (paramLogNode != null) {
/*  900 */       paramLogNode.log("Could not fit InputStream content into max RAM buffer size, saving to temporary file: " + iOException + " -> " + file);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  905 */     BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file)); Throwable throwable = null;
/*      */     
/*  907 */     try { if (paramArrayOfbyte1 != null) {
/*  908 */         bufferedOutputStream.write(paramArrayOfbyte1);
/*  909 */         bufferedOutputStream.write(paramArrayOfbyte2);
/*      */       } 
/*      */       
/*  912 */       paramArrayOfbyte1 = new byte[8192]; int i;
/*  913 */       while ((i = paramInputStream.read(paramArrayOfbyte1, 0, 8192)) > 0)
/*  914 */         bufferedOutputStream.write(paramArrayOfbyte1, 0, i);  }
/*      */     catch (Throwable throwable1) { arrayOfByte = paramArrayOfbyte1 = null; throw paramArrayOfbyte1; }
/*  916 */     finally { if (arrayOfByte != null) { try { bufferedOutputStream.close(); } catch (Throwable throwable1) { arrayOfByte.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*      */        }
/*      */     
/*  919 */     return new FileSlice(file, this, paramLogNode);
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
/*      */   public static byte[] readAllBytesAsArray(InputStream paramInputStream, long paramLong) {
/*  935 */     if (paramLong > 2147483639L) {
/*  936 */       throw new IOException("InputStream is too large to read");
/*      */     }
/*  938 */     paramInputStream = paramInputStream; Throwable throwable = null;
/*      */ 
/*      */ 
/*      */     
/*      */     try { boolean bool;
/*      */ 
/*      */       
/*  945 */       byte[] arrayOfByte = new byte[bool = (paramLong < 1L) ? true : Math.min((int)paramLong, 16777216)];
/*  946 */       int i = 0; while (true) {
/*      */         int j;
/*  948 */         while ((j = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i)) > 0)
/*      */         {
/*  950 */           i += j;
/*      */         }
/*  952 */         if (j >= 0) {
/*      */           int k;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  961 */           if ((k = paramInputStream.read()) != -1) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  968 */             if (arrayOfByte.length == 2147483639) {
/*  969 */               throw new IOException("InputStream too large to read into array");
/*      */             }
/*      */             
/*  972 */             (arrayOfByte = Arrays.copyOf(arrayOfByte, (int)Math.min(arrayOfByte.length << 1L, 2147483639L)))[i++] = (byte)k; continue;
/*      */           } 
/*      */         }  break;
/*  975 */       }  return (i == arrayOfByte.length) ? arrayOfByte : Arrays.copyOf(arrayOfByte, i); } catch (Throwable throwable2) { Throwable throwable1 = null; throw throwable1; }
/*  976 */     finally { if (paramInputStream != null) if (throwable != null) { try { paramInputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { throwable1.close(); }
/*      */       
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close(LogNode paramLogNode) {
/*  988 */     if (!this.closed.getAndSet(true)) {
/*  989 */       boolean bool = false;
/*  990 */       if (this.moduleRefToModuleReaderProxyRecyclerMap != null) {
/*  991 */         boolean bool1 = false;
/*  992 */         while (!bool1) {
/*      */           
/*      */           try {
/*  995 */             for (Iterator<Recycler> iterator = this.moduleRefToModuleReaderProxyRecyclerMap.values().iterator(); iterator.hasNext();) {
/*  996 */               (recycler = iterator.next()).forceClose();
/*      */             }
/*  998 */             bool1 = true;
/*  999 */           } catch (InterruptedException interruptedException) {
/*      */             
/* 1001 */             bool = true;
/*      */           } 
/*      */         } 
/* 1004 */         this.moduleRefToModuleReaderProxyRecyclerMap.clear();
/* 1005 */         this.moduleRefToModuleReaderProxyRecyclerMap = null;
/*      */       } 
/* 1007 */       if (this.zipFileSliceToLogicalZipFileMap != null) {
/* 1008 */         this.zipFileSliceToLogicalZipFileMap.clear();
/* 1009 */         this.zipFileSliceToLogicalZipFileMap = null;
/*      */       } 
/* 1011 */       if (this.nestedPathToLogicalZipFileAndPackageRootMap != null) {
/* 1012 */         this.nestedPathToLogicalZipFileAndPackageRootMap.clear();
/* 1013 */         this.nestedPathToLogicalZipFileAndPackageRootMap = null;
/*      */       } 
/* 1015 */       if (this.canonicalFileToPhysicalZipFileMap != null) {
/* 1016 */         this.canonicalFileToPhysicalZipFileMap.clear();
/* 1017 */         this.canonicalFileToPhysicalZipFileMap = null;
/*      */       } 
/* 1019 */       if (this.fastZipEntryToZipFileSliceMap != null) {
/* 1020 */         this.fastZipEntryToZipFileSliceMap.clear();
/* 1021 */         this.fastZipEntryToZipFileSliceMap = null;
/*      */       } 
/* 1023 */       if (this.openSlices != null) {
/* 1024 */         while (!this.openSlices.isEmpty()) {
/* 1025 */           for (Slice slice : new ArrayList(this.openSlices)) {
/*      */             try {
/* 1027 */               slice.close();
/* 1028 */             } catch (IOException iOException) {}
/*      */ 
/*      */             
/* 1031 */             markSliceAsClosed(slice);
/*      */           } 
/*      */         } 
/* 1034 */         this.openSlices.clear();
/* 1035 */         this.openSlices = null;
/*      */       } 
/* 1037 */       if (this.inflaterRecycler != null) {
/* 1038 */         this.inflaterRecycler.forceClose();
/* 1039 */         this.inflaterRecycler = null;
/*      */       } 
/*      */       
/* 1042 */       if (this.tempFiles != null) {
/*      */         
/* 1044 */         LogNode logNode = (this.tempFiles.isEmpty() || paramLogNode == null) ? null : paramLogNode.log("Removing temporary files");
/* 1045 */         while (!this.tempFiles.isEmpty()) {
/* 1046 */           for (File file : new ArrayList(this.tempFiles)) {
/*      */             try {
/* 1048 */               removeTempFile(file);
/* 1049 */             } catch (IOException|SecurityException iOException) {
/* 1050 */               if (logNode != null) {
/* 1051 */                 logNode.log("Removing temporary file failed: " + file);
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/* 1056 */         this.tempFiles = null;
/*      */       } 
/* 1058 */       if (bool) {
/* 1059 */         this.interruptionChecker.interrupt();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void runFinalizationMethod() {
/* 1068 */     if (runFinalizationMethod == null) {
/* 1069 */       runFinalizationMethod = this.reflectionUtils.staticMethodForNameOrNull("System", "runFinalization");
/*      */     }
/* 1071 */     if (runFinalizationMethod != null) {
/*      */       
/*      */       try {
/* 1074 */         runFinalizationMethod.invoke(null, new Object[0]); return;
/* 1075 */       } catch (Throwable throwable) {}
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void closeDirectByteBuffer(ByteBuffer paramByteBuffer) {
/* 1082 */     FileUtils.closeDirectByteBuffer(paramByteBuffer, this.reflectionUtils, null);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fastzipfilereader\NestedJarHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */