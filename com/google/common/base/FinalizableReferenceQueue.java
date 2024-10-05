/*     */ package com.google.common.base;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.lang.ref.PhantomReference;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ElementTypesAreNonnullByDefault
/*     */ public class FinalizableReferenceQueue
/*     */   implements Closeable
/*     */ {
/* 134 */   private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
/*     */ 
/*     */   
/*     */   private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
/*     */   
/*     */   private static final Method startFinalizer;
/*     */ 
/*     */   
/*     */   static {
/*     */     Class<?> clazz;
/* 144 */     startFinalizer = getStartFinalizer(clazz = loadFinalizer(new FinalizerLoader[] { new SystemLoader(), new DecoupledLoader(), new DirectLoader() }));
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
/* 158 */   final ReferenceQueue<Object> queue = new ReferenceQueue();
/* 159 */   final PhantomReference<Object> frqRef = new PhantomReference(this, this.queue); public FinalizableReferenceQueue() {
/* 160 */     boolean bool = false;
/*     */     try {
/* 162 */       startFinalizer.invoke(null, new Object[] { FinalizableReference.class, this.queue, this.frqRef });
/* 163 */       bool = true;
/* 164 */     } catch (IllegalAccessException illegalAccessException) {
/* 165 */       throw new AssertionError(illegalAccessException);
/* 166 */     } catch (Throwable throwable) {
/* 167 */       logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", throwable);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     this.threadStarted = bool;
/*     */   }
/*     */   final boolean threadStarted;
/*     */   
/*     */   public void close() {
/* 179 */     this.frqRef.enqueue();
/* 180 */     cleanUp();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void cleanUp() {
/* 189 */     if (this.threadStarted) {
/*     */       return;
/*     */     }
/*     */     
/*     */     Reference<?> reference;
/* 194 */     while ((reference = this.queue.poll()) != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 199 */       reference.clear();
/*     */       try {
/* 201 */         ((FinalizableReference)reference).finalizeReferent();
/* 202 */       } catch (Throwable throwable) {
/* 203 */         logger.log(Level.SEVERE, "Error cleaning up after reference.", throwable);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class<?> loadFinalizer(FinalizerLoader... paramVarArgs) {
/*     */     int i;
/*     */     byte b;
/* 214 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*     */       Class<?> clazz; FinalizerLoader finalizerLoader;
/* 216 */       if ((clazz = (finalizerLoader = paramVarArgs[b]).loadFinalizer()) != null) {
/* 217 */         return clazz;
/*     */       }
/*     */     } 
/*     */     
/* 221 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static interface FinalizerLoader
/*     */   {
/*     */     Class<?> loadFinalizer();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class SystemLoader
/*     */     implements FinalizerLoader
/*     */   {
/*     */     static boolean disabled;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<?> loadFinalizer() {
/*     */       ClassLoader classLoader;
/* 248 */       if (disabled) {
/* 249 */         return null;
/*     */       }
/*     */       
/*     */       try {
/* 253 */         classLoader = ClassLoader.getSystemClassLoader();
/* 254 */       } catch (SecurityException securityException) {
/* 255 */         FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
/* 256 */         return null;
/*     */       } 
/* 258 */       if (classLoader != null) {
/*     */         try {
/* 260 */           return classLoader.loadClass("com.google.common.base.internal.Finalizer");
/* 261 */         } catch (ClassNotFoundException classNotFoundException) {
/*     */           
/* 263 */           return null;
/*     */         } 
/*     */       }
/* 266 */       return null;
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
/*     */   static class DecoupledLoader
/*     */     implements FinalizerLoader
/*     */   {
/*     */     private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<?> loadFinalizer() {
/*     */       try {
/*     */         URLClassLoader uRLClassLoader;
/* 297 */         return (uRLClassLoader = newLoader(getBaseUrl())).loadClass("com.google.common.base.internal.Finalizer");
/* 298 */       } catch (Exception exception) {
/* 299 */         FinalizableReferenceQueue.logger.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", exception);
/* 300 */         return null;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     URL getBaseUrl() {
/* 307 */       String str1 = String.valueOf("com.google.common.base.internal.Finalizer".replace('.', '/')).concat(".class");
/*     */       URL uRL;
/* 309 */       if ((uRL = getClass().getClassLoader().getResource(str1)) == null) {
/* 310 */         throw new FileNotFoundException(str1);
/*     */       }
/*     */       
/*     */       String str2;
/*     */       
/* 315 */       if (!(str2 = uRL.toString()).endsWith(str1)) {
/* 316 */         String.valueOf(str2); throw new IOException((String.valueOf(str2).length() != 0) ? "Unsupported path style: ".concat(String.valueOf(str2)) : new String("Unsupported path style: "));
/*     */       } 
/* 318 */       str2 = str2.substring(0, str2.length() - str1.length());
/* 319 */       return new URL(uRL, str2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     URLClassLoader newLoader(URL param1URL) {
/* 327 */       return new URLClassLoader(new URL[] { param1URL }, null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class DirectLoader
/*     */     implements FinalizerLoader
/*     */   {
/*     */     public Class<?> loadFinalizer() {
/*     */       try {
/* 339 */         return Class.forName("com.google.common.base.internal.Finalizer");
/* 340 */       } catch (ClassNotFoundException classNotFoundException) {
/* 341 */         throw new AssertionError(classNotFoundException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static Method getStartFinalizer(Class<?> paramClass) {
/*     */     try {
/* 349 */       return paramClass.getMethod("startFinalizer", new Class[] { Class.class, ReferenceQueue.class, PhantomReference.class });
/*     */     }
/* 351 */     catch (NoSuchMethodException noSuchMethodException) {
/* 352 */       throw new AssertionError(noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\FinalizableReferenceQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */