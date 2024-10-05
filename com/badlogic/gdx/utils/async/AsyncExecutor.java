/*    */ package com.badlogic.gdx.utils.async;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Disposable;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ import java.util.concurrent.Callable;
/*    */ import java.util.concurrent.ExecutorService;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AsyncExecutor
/*    */   implements Disposable
/*    */ {
/*    */   private final ExecutorService executor;
/*    */   
/*    */   public AsyncExecutor(int paramInt) {
/* 37 */     this(paramInt, "AsynchExecutor-Thread");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AsyncExecutor(int paramInt, final String name) {
/* 44 */     this.executor = Executors.newFixedThreadPool(paramInt, new ThreadFactory()
/*    */         {
/*    */           public Thread newThread(Runnable param1Runnable)
/*    */           {
/* 48 */             (param1Runnable = new Thread(param1Runnable, name)).setDaemon(true);
/* 49 */             return (Thread)param1Runnable;
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> AsyncResult<T> submit(final AsyncTask<T> task) {
/* 58 */     if (this.executor.isShutdown()) {
/* 59 */       throw new GdxRuntimeException("Cannot run tasks on an executor that has been shutdown (disposed)");
/*    */     }
/* 61 */     return new AsyncResult<>(this.executor.submit(new Callable<T>()
/*    */           {
/*    */             public T call() {
/* 64 */               return task.call();
/*    */             }
/*    */           }));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 73 */     this.executor.shutdown();
/*    */     try {
/* 75 */       this.executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS); return;
/* 76 */     } catch (InterruptedException interruptedException) {
/* 77 */       throw new GdxRuntimeException("Couldn't shutdown loading thread", interruptedException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\async\AsyncExecutor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */