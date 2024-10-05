/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.nio.file.attribute.PosixFilePermission;
/*     */ import java.util.Set;
/*     */ import nonapi.io.github.classgraph.fileslice.reader.ClassfileReader;
/*     */ import nonapi.io.github.classgraph.utils.LogNode;
/*     */ import nonapi.io.github.classgraph.utils.URLPathEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Resource
/*     */   implements Closeable, Comparable<Resource>
/*     */ {
/*     */   private final ClasspathElement classpathElement;
/*     */   protected InputStream inputStream;
/*     */   protected ByteBuffer byteBuffer;
/*     */   protected long length;
/*     */   private String toString;
/*     */   LogNode scanLog;
/*     */   
/*     */   public Resource(ClasspathElement paramClasspathElement, long paramLong) {
/*  86 */     this.classpathElement = paramClasspathElement;
/*  87 */     this.length = paramLong;
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
/*     */   private static URL uriToURL(URI paramURI) {
/*     */     try {
/* 103 */       return paramURI.toURL();
/* 104 */     } catch (IllegalArgumentException|java.net.MalformedURLException illegalArgumentException) {
/* 105 */       if (paramURI.getScheme().equals("jrt"))
/*     */       {
/* 107 */         throw new IllegalArgumentException("Could not create URL from URI with \"jrt:\" scheme (\"jrt:\" is not supported by the URL class without a custom URL protocol handler): " + paramURI);
/*     */       }
/*     */ 
/*     */       
/* 111 */       throw new IllegalArgumentException("Could not create URL from URI: " + paramURI + " -- " + illegalArgumentException);
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
/*     */   public URI getURI() {
/*     */     URI uRI;
/* 125 */     String str1 = (uRI = getClasspathElementURI()).toString();
/* 126 */     String str2 = getPathRelativeToClasspathElement();
/*     */     
/* 128 */     boolean bool = str1.endsWith("/");
/*     */     try {
/* 130 */       return new URI(((bool || str1
/* 131 */           .startsWith("jar:") || str1.startsWith("jrt:")) ? "" : "jar:") + str1 + (bool ? "" : (
/* 132 */           str1.startsWith("jrt:") ? "/" : "!/")) + 
/* 133 */           URLPathEncoder.encodePath(str2));
/* 134 */     } catch (URISyntaxException uRISyntaxException) {
/* 135 */       throw new IllegalArgumentException("Could not form URL for classpath element: " + str1 + " ; path: " + str2 + " : " + uRISyntaxException);
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
/*     */   public URL getURL() {
/* 152 */     return uriToURL(getURI());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getClasspathElementURI() {
/* 163 */     return this.classpathElement.getURI();
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
/*     */   public URL getClasspathElementURL() {
/* 178 */     return uriToURL(getClasspathElementURI());
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
/*     */   public File getClasspathElementFile() {
/* 191 */     return this.classpathElement.getFile();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModuleRef getModuleRef() {
/* 201 */     return (this.classpathElement instanceof ClasspathElementModule) ? ((ClasspathElementModule)this.classpathElement).moduleRef : null;
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
/*     */   public String getContentAsString() {
/* 215 */     String str = new String(load(), StandardCharsets.UTF_8);
/* 216 */     close();
/* 217 */     return str;
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
/*     */   public String getPathRelativeToClasspathElement() {
/* 242 */     return getPath();
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
/*     */   public CloseableByteBuffer readCloseable() {
/* 282 */     return new CloseableByteBuffer(read(), new Runnable()
/*     */         {
/*     */           public void run() {
/* 285 */             Resource.this.close();
/*     */           }
/*     */         });
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
/*     */   public long getLength() {
/* 319 */     return this.length;
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
/*     */   public String toString() {
/* 358 */     if (this.toString != null) {
/* 359 */       return this.toString;
/*     */     }
/* 361 */     return this.toString = getURI().toString();
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
/*     */   public int hashCode() {
/* 375 */     return toString().hashCode();
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
/* 390 */     if (paramObject == this)
/* 391 */       return true; 
/* 392 */     if (!(paramObject instanceof Resource)) {
/* 393 */       return false;
/*     */     }
/* 395 */     return toString().equals(paramObject.toString());
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
/*     */   public int compareTo(Resource paramResource) {
/* 410 */     return toString().compareTo(paramResource.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 419 */     if (this.inputStream != null) {
/*     */       try {
/* 421 */         this.inputStream.close();
/* 422 */       } catch (IOException iOException) {}
/*     */ 
/*     */       
/* 425 */       this.inputStream = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract String getPath();
/*     */   
/*     */   public abstract InputStream open();
/*     */   
/*     */   public abstract ByteBuffer read();
/*     */   
/*     */   public abstract byte[] load();
/*     */   
/*     */   abstract ClassfileReader openClassfile();
/*     */   
/*     */   public abstract long getLastModified();
/*     */   
/*     */   public abstract Set<PosixFilePermission> getPosixFilePermissions();
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\Resource.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */