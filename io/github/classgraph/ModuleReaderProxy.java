/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URI;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.List;
/*     */ import nonapi.io.github.classgraph.reflection.ReflectionUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModuleReaderProxy
/*     */   implements Closeable
/*     */ {
/*     */   private final AutoCloseable moduleReader;
/*     */   private static Class<?> collectorClass;
/*     */   private static Object collectorsToList;
/*     */   private ReflectionUtils reflectionUtils;
/*     */   
/*     */   ModuleReaderProxy(ModuleRef paramModuleRef) {
/*     */     try {
/*  63 */       this.reflectionUtils = paramModuleRef.reflectionUtils;
/*     */       
/*  65 */       collectorClass = this.reflectionUtils.classForNameOrNull("java.util.stream.Collector");
/*     */       Class clazz;
/*  67 */       if ((collectorClass == null || collectorsToList == null) && (clazz = this.reflectionUtils.classForNameOrNull("java.util.stream.Collectors")) != null) {
/*  68 */         collectorsToList = this.reflectionUtils.invokeStaticMethod(true, clazz, "toList");
/*     */       }
/*     */ 
/*     */       
/*  72 */       this.moduleReader = (AutoCloseable)this.reflectionUtils.invokeMethod(true, paramModuleRef
/*  73 */           .getReference(), "open");
/*  74 */       if (this.moduleReader == null)
/*  75 */         throw new IllegalArgumentException("moduleReference.open() should not return null"); 
/*     */       return;
/*  77 */     } catch (SecurityException securityException) {
/*  78 */       throw new IOException("Could not open module " + paramModuleRef.getName(), securityException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     try {
/*  86 */       this.moduleReader.close(); return;
/*  87 */     } catch (Exception exception) {
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> list() {
/* 107 */     if (collectorsToList == null) {
/* 108 */       throw new IllegalArgumentException("Could not call Collectors.toList()");
/*     */     }
/*     */     
/*     */     Object object;
/* 112 */     if ((object = this.reflectionUtils.invokeMethod(true, this.moduleReader, "list")) == null) {
/* 113 */       throw new IllegalArgumentException("Could not call moduleReader.list()");
/*     */     }
/*     */ 
/*     */     
/* 117 */     if ((object = this.reflectionUtils.invokeMethod(true, object, "collect", collectorClass, collectorsToList)) == null) {
/* 118 */       throw new IllegalArgumentException("Could not call moduleReader.list().collect(Collectors.toList())");
/*     */     }
/*     */ 
/*     */     
/* 122 */     return (List<String>)(object = object);
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
/*     */   public InputStream open(String paramString) {
/*     */     Object object;
/* 140 */     if ((object = this.reflectionUtils.invokeMethod(true, this.moduleReader, "open", String.class, paramString)) == null) {
/* 141 */       throw new IllegalArgumentException("Got null result from ModuleReader#open for path " + paramString);
/*     */     }
/*     */     
/*     */     InputStream inputStream;
/* 145 */     if ((inputStream = (InputStream)this.reflectionUtils.invokeMethod(true, object, "get")) == null) {
/* 146 */       throw new IllegalArgumentException("Got null result from ModuleReader#open(String)#get()");
/*     */     }
/* 148 */     return inputStream;
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
/*     */   public ByteBuffer read(String paramString) {
/*     */     Object object;
/* 166 */     if ((object = this.reflectionUtils.invokeMethod(true, this.moduleReader, "read", String.class, paramString)) == null) {
/* 167 */       throw new IllegalArgumentException("Got null result from ModuleReader#read(String)");
/*     */     }
/*     */ 
/*     */     
/* 171 */     if ((object = this.reflectionUtils.invokeMethod(true, object, "get")) == null) {
/* 172 */       throw new IllegalArgumentException("Got null result from ModuleReader#read(String).get()");
/*     */     }
/* 174 */     return (ByteBuffer)object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void release(ByteBuffer paramByteBuffer) {
/* 184 */     this.reflectionUtils.invokeMethod(true, this.moduleReader, "release", ByteBuffer.class, paramByteBuffer);
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
/*     */   public URI find(String paramString) {
/*     */     Object object;
/* 200 */     if ((object = this.reflectionUtils.invokeMethod(true, this.moduleReader, "find", String.class, paramString)) == null) {
/* 201 */       throw new IllegalArgumentException("Got null result from ModuleReader#find(String)");
/*     */     }
/*     */     
/* 204 */     if ((object = this.reflectionUtils.invokeMethod(true, object, "get")) == null) {
/* 205 */       throw new IllegalArgumentException("Got null result from ModuleReader#find(String).get()");
/*     */     }
/* 207 */     return (URI)object;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\ModuleReaderProxy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */