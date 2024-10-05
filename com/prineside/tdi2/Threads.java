/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Sort;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.utils.IntObjectConsumer;
/*     */ import com.prineside.tdi2.utils.IntObjectPair;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Threads
/*     */ {
/*  35 */   private static final TLog a = TLog.forClass(Threads.class);
/*     */   
/*  37 */   private static final Threads b = new Threads();
/*     */   public static Threads i() {
/*  39 */     return b;
/*     */   }
/*     */ 
/*     */   
/*  43 */   private static final ThreadLocal<Sort> c = new ThreadLocal<Sort>()
/*     */     {
/*     */       private static Sort a() {
/*  46 */         return new Sort();
/*     */       }
/*     */     };
/*     */   private static final class TestObject {
/*  50 */     public int v; } private final HashSet<Runnable> d = new HashSet<>();
/*  51 */   private final ExecutorService e = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new DaemonThreadFactory("Shared Threads async executor", true));
/*     */ 
/*     */ 
/*     */   
/*     */   private ExecutorService f;
/*     */ 
/*     */ 
/*     */   
/*     */   final void a() {
/*  60 */     this.d.clear();
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
/*     */   public final void runOnMainThreadBlocking(Runnable paramRunnable, float paramFloat) {
/*  73 */     if (Game.i.isInMainThread()) {
/*  74 */       paramRunnable.run();
/*     */       
/*     */       return;
/*     */     } 
/*  78 */     Thread thread = Thread.currentThread();
/*  79 */     boolean[] arrayOfBoolean1 = { false };
/*  80 */     boolean[] arrayOfBoolean2 = { false };
/*  81 */     Throwable[] arrayOfThrowable = { null };
/*  82 */     postRunnable(() -> {
/*     */           if (paramThread == Thread.currentThread()) {
/*     */             paramArrayOfboolean1[0] = true;
/*     */             return;
/*     */           } 
/*     */           try {
/*     */             paramRunnable.run();
/*  89 */           } catch (Throwable throwable) {
/*     */             paramArrayOfThrowable[0] = throwable;
/*     */           } 
/*     */           
/*     */           paramArrayOfboolean2[0] = true;
/*     */         });
/*  95 */     long l = Game.getTimestampMillis();
/*  96 */     while (!arrayOfBoolean1[0]) {
/*     */       try {
/*  98 */         if (arrayOfBoolean2[0]) {
/*  99 */           throw new IllegalStateException("Multithreading.runOnMainThreadBlocking should not be called from the GDX thread");
/*     */         }
/* 101 */         Thread.sleep(1L);
/* 102 */         if (paramFloat > 0.0F && (float)(Game.getTimestampMillis() - l) > paramFloat * 1000.0F) {
/* 103 */           throw new IllegalStateException("Job takes too long");
/*     */         }
/* 105 */       } catch (Exception exception) {
/* 106 */         throw new IllegalStateException("Failed runOnMainThreadBlocking", exception);
/*     */       } 
/*     */     } 
/* 109 */     if (arrayOfThrowable[0] != null) {
/* 110 */       throw new IllegalStateException("Failed runOnMainThreadBlocking: exception occurred", arrayOfThrowable[0]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void runOnMainThread(Runnable paramRunnable) {
/* 121 */     if (Game.i.isInMainThread()) {
/* 122 */       paramRunnable.run();
/*     */       
/*     */       return;
/*     */     } 
/* 126 */     postRunnable(paramRunnable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void runAsync(Runnable paramRunnable) {
/* 134 */     StackTraceElement[] arrayOfStackTraceElement = (new Throwable()).getStackTrace();
/* 135 */     this.e.submit(() -> {
/*     */           try {
/*     */             paramRunnable.run(); return;
/* 138 */           } catch (Exception exception) {
/*     */             a.e("Failed to execute runnable async", new Object[] { exception });
/*     */             throw new RuntimeException("Failed to execute runnable async, called from " + Arrays.toString(paramArrayOfStackTraceElement), exception);
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public final void runAsync(Runnable paramRunnable, ObjectConsumer<Exception> paramObjectConsumer) {
/* 146 */     this.e.submit(() -> {
/*     */           try {
/*     */             paramRunnable.run(); return;
/* 149 */           } catch (Exception exception) {
/*     */             paramObjectConsumer.accept(exception);
/*     */             return;
/*     */           } 
/*     */         });
/*     */   }
/*     */   public static <T> void sortGdxArray(Array<T> paramArray, Comparator<? super T> paramComparator) {
/* 156 */     ((Sort)c.get()).sort(paramArray.items, paramComparator, 0, paramArray.size);
/*     */   }
/*     */   
/*     */   public static <T> void sort(T[] paramArrayOfT, Comparator<? super T> paramComparator) {
/* 160 */     ((Sort)c.get()).sort((Object[])paramArrayOfT, paramComparator, 0, paramArrayOfT.length);
/*     */   }
/*     */   
/*     */   public static <T> void sortArraySlice(T[] paramArrayOfT, int paramInt1, int paramInt2, Comparator<? super T> paramComparator) {
/* 164 */     ((Sort)c.get()).sort((Object[])paramArrayOfT, paramComparator, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void postRunnable(Runnable paramRunnable) {
/* 172 */     StackTraceElement[] arrayOfStackTraceElement = null;
/* 173 */     if (Config.isHeadless()) {
/* 174 */       arrayOfStackTraceElement = (new Throwable()).getStackTrace();
/*     */     }
/* 176 */     else if (Game.i == null || Game.i.settingsManager == null || Game.i.settingsManager.isInDebugDetailedMode()) {
/* 177 */       arrayOfStackTraceElement = (new Throwable()).getStackTrace();
/*     */     } 
/*     */     
/* 180 */     arrayOfStackTraceElement = arrayOfStackTraceElement;
/*     */     
/* 182 */     Gdx.app.postRunnable(() -> {
/*     */           long l1 = Game.getRealTickCount();
/*     */           try {
/*     */             paramRunnable.run();
/* 186 */           } catch (Exception exception) {
/*     */             throw new RuntimeException("Failed to execute runnable: " + Arrays.toString(paramArrayOfStackTraceElement), exception);
/*     */           } 
/*     */           long l2;
/*     */           if ((l2 = Game.getRealTickCount() - l1) > 80000L) {
/*     */             a.d("runnable '" + paramRunnable + "' took " + ((float)l2 * 0.001F) + "ms to execute on the main thread: " + Arrays.toString((Object[])paramArrayOfStackTraceElement), new Object[0]);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void postRunnableOnce(Runnable paramRunnable) {
/* 200 */     Preconditions.checkNotNull(paramRunnable, "runnable can not be null");
/* 201 */     if (this.d.contains(paramRunnable)) {
/*     */       return;
/*     */     }
/*     */     
/* 205 */     this.d.add(paramRunnable);
/*     */     
/* 207 */     postRunnable(paramRunnable);
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
/*     */   public final Thread createThread(String paramString, Runnable paramRunnable, boolean paramBoolean) {
/*     */     Thread thread;
/* 220 */     (thread = new Thread(paramRunnable, paramString)).setDaemon(true);
/* 221 */     if (paramBoolean) {
/* 222 */       CrashHandler.handleThreadExceptions(thread);
/*     */     } else {
/* 224 */       CrashHandler.handleThreadExceptionsForgiving(thread);
/*     */     } 
/*     */     
/* 227 */     return thread;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void synchronize(Object paramObject, Runnable paramRunnable) {
/* 232 */     synchronized (paramObject) {
/* 233 */       paramRunnable.run();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public final void tryFinally(Runnable paramRunnable1, Runnable paramRunnable2) {
/*     */     try {
/* 239 */       paramRunnable1.run(); return;
/*     */     } finally {
/* 241 */       paramRunnable2.run();
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void tryCatch(Runnable paramRunnable, ObjectConsumer<Throwable> paramObjectConsumer) {
/*     */     try {
/* 247 */       paramRunnable.run(); return;
/* 248 */     } catch (Throwable throwable) {
/* 249 */       paramObjectConsumer.accept(throwable);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private ExecutorService b() {
/* 256 */     if (this.f == null) {
/* 257 */       int i = Runtime.getRuntime().availableProcessors();
/* 258 */       this.f = Executors.newFixedThreadPool(i, new DaemonThreadFactory("Threads class loop executor", true));
/* 259 */       a.i("created ExecutorService with " + i + " threads for loops", new Object[0]);
/*     */     } 
/* 261 */     return this.f;
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
/*     */   private static <T> void a(T[] paramArrayOfT, int paramInt1, int paramInt2, IntObjectConsumer<T> paramIntObjectConsumer) {
/* 275 */     ArrayList<IntObjectPair> arrayList = new ArrayList();
/* 276 */     for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
/* 277 */       arrayList.add(new IntObjectPair(i, paramArrayOfT[i]));
/*     */     }
/* 279 */     arrayList.parallelStream().forEach(paramIntObjectPair -> paramIntObjectConsumer.accept(paramIntObjectPair.a, paramIntObjectPair.t));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> void concurrentLoop(Array<T> paramArray, IntObjectConsumer<T> paramIntObjectConsumer) {
/* 288 */     concurrentLoop(paramArray.items, 0, paramArray.size, paramIntObjectConsumer);
/*     */   }
/*     */   
/*     */   public final <T> void concurrentLoop(T[] paramArrayOfT, int paramInt1, int paramInt2, IntObjectConsumer<T> paramIntObjectConsumer) {
/* 292 */     if (paramInt2 == 0)
/* 293 */       return;  if (paramInt2 == 1) {
/* 294 */       paramIntObjectConsumer.accept(0, paramArrayOfT[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 298 */     if (Gdx.app != null && (
/* 299 */       Gdx.app.getType() == Application.ApplicationType.Desktop || (Gdx.app.getType() == Application.ApplicationType.Android && Gdx.app.getVersion() >= 24))) {
/* 300 */       a(paramArrayOfT, paramInt1, paramInt2, paramIntObjectConsumer);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     int i;
/* 306 */     if ((i = Math.min(paramInt2, Runtime.getRuntime().availableProcessors())) > paramInt2) {
/* 307 */       i = paramInt2;
/*     */     }
/*     */     
/* 310 */     ExecutorService executorService = b();
/* 311 */     double d1 = paramInt2 / i;
/* 312 */     double d2 = paramInt1;
/* 313 */     ArrayList<Callable> arrayList = new ArrayList();
/* 314 */     for (byte b = 0; b < i; b++) {
/* 315 */       int j = (int)d2;
/* 316 */       d2 += d1;
/* 317 */       int k = (b == i - 1) ? (paramInt1 + paramInt2 - 1) : ((int)d2 - 1);
/* 318 */       arrayList.add(() -> {
/*     */             for (paramInt1 = paramInt1; paramInt1 <= paramInt2; paramInt1++) {
/*     */               paramIntObjectConsumer.accept(paramInt1, paramArrayOfObject[paramInt1]);
/*     */             }
/*     */             return null;
/*     */           });
/*     */     } 
/*     */     try {
/* 326 */       executorService.invokeAll((Collection)arrayList); return;
/* 327 */     } catch (InterruptedException interruptedException) {
/* 328 */       throw new IllegalStateException("Failed to loop through the array", interruptedException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final <T> void asyncConcurrentLoop(T[] paramArrayOfT, int paramInt1, int paramInt2, IntObjectConsumer<T> paramIntObjectConsumer, Runnable paramRunnable, ObjectConsumer<Exception> paramObjectConsumer) {
/* 333 */     runAsync(() -> { concurrentLoop(paramArrayOfObject, paramInt1, paramInt2, paramIntObjectConsumer); paramRunnable.run(); }paramObjectConsumer);
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
/*     */   public static class DaemonThreadFactory
/*     */     implements ThreadFactory
/*     */   {
/*     */     private final String a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final boolean c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DaemonThreadFactory(String param1String, boolean param1Boolean) {
/* 379 */       this.a = param1String;
/* 380 */       this.c = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public Thread newThread(Runnable param1Runnable) {
/* 385 */       return Threads.i().createThread(this.a + " " + this.b++, param1Runnable, this.c);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Threads.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */