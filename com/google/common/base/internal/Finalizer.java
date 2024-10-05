/*     */ package com.google.common.base.internal;
/*     */ 
/*     */ import java.lang.ref.PhantomReference;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
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
/*     */ public class Finalizer
/*     */   implements Runnable
/*     */ {
/*  49 */   private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final WeakReference<Class<?>> finalizableReferenceClassReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final PhantomReference<Object> frqReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ReferenceQueue<Object> queue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Constructor<Thread> bigThreadConstructor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 125 */   private static final Field inheritableThreadLocals = ((bigThreadConstructor = getBigThreadConstructor()) == null) ? getInheritableThreadLocalsField() : null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Finalizer(Class<?> paramClass, ReferenceQueue<Object> paramReferenceQueue, PhantomReference<Object> paramPhantomReference) {
/* 132 */     this.queue = paramReferenceQueue;
/*     */     
/* 134 */     this.finalizableReferenceClassReference = new WeakReference<>(paramClass);
/*     */ 
/*     */     
/* 137 */     this.frqReference = paramPhantomReference;
/*     */   } public static void startFinalizer(Class<?> paramClass, ReferenceQueue<Object> paramReferenceQueue, PhantomReference<Object> paramPhantomReference) { Thread thread; if (!paramClass.getName().equals("com.google.common.base.FinalizableReference"))
/*     */       throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");  Finalizer finalizer = new Finalizer(paramClass, paramReferenceQueue, paramPhantomReference); String str = Finalizer.class.getName(); paramPhantomReference = null; if (bigThreadConstructor != null)
/*     */       try { thread = bigThreadConstructor.newInstance(new Object[] { null, finalizer, str, Long.valueOf(0L), Boolean.FALSE }); } catch (Throwable throwable) { logger.log(Level.INFO, "Failed to create a thread without inherited thread-local values", throwable); }
/*     */         if (thread == null)
/*     */       thread = new Thread((ThreadGroup)null, finalizer, str);  thread.setDaemon(true); try { if (inheritableThreadLocals != null)
/*     */         inheritableThreadLocals.set(thread, null);  }
/*     */     catch (Throwable throwable) { logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", throwable); }
/*     */      thread.start(); } public void run() { while (true) { try { do {  }
/* 146 */         while (cleanUp(this.queue.remove()));
/*     */         
/*     */         return; }
/* 149 */       catch (InterruptedException interruptedException) {} }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean cleanUp(Reference<?> paramReference) {
/*     */     Method method;
/* 163 */     if ((method = getFinalizeReferentMethod()) == null) {
/* 164 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 171 */       paramReference.clear();
/*     */       
/* 173 */       if (paramReference == this.frqReference)
/*     */       {
/*     */ 
/*     */         
/* 177 */         return false;
/*     */       }
/*     */       
/*     */       try {
/* 181 */         method.invoke(paramReference, new Object[0]);
/* 182 */       } catch (Throwable throwable) {
/* 183 */         logger.log(Level.SEVERE, "Error cleaning up after reference.", throwable);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 190 */       if ((paramReference = this.queue.poll()) == null) {
/* 191 */         return true;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private Method getFinalizeReferentMethod() {
/*     */     Class clazz;
/* 198 */     if ((clazz = this.finalizableReferenceClassReference.get()) == null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 205 */       return null;
/*     */     }
/*     */     try {
/* 208 */       return clazz.getMethod("finalizeReferent", new Class[0]);
/* 209 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 210 */       throw new AssertionError(noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Field getInheritableThreadLocalsField() {
/*     */     try {
/*     */       Field field;
/* 218 */       (field = Thread.class.getDeclaredField("inheritableThreadLocals")).setAccessible(true);
/* 219 */       return field;
/* 220 */     } catch (Throwable throwable) {
/* 221 */       logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
/*     */ 
/*     */ 
/*     */       
/* 225 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static Constructor<Thread> getBigThreadConstructor() {
/*     */     try {
/* 232 */       return Thread.class.getConstructor(new Class[] { ThreadGroup.class, Runnable.class, String.class, long.class, boolean.class });
/*     */     }
/* 234 */     catch (Throwable throwable) {
/*     */       
/* 236 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\internal\Finalizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */