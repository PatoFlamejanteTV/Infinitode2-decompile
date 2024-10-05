/*     */ package nonapi.io.github.classgraph.concurrency;
/*     */ 
/*     */ import java.util.concurrent.CancellationException;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AutoCloseableExecutorService
/*     */   extends ThreadPoolExecutor
/*     */   implements AutoCloseable
/*     */ {
/*  41 */   public final InterruptionChecker interruptionChecker = new InterruptionChecker();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AutoCloseableExecutorService(int paramInt) {
/*  50 */     super(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new SimpleThreadFactory("ClassGraph-worker-", true));
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
/*     */   public void afterExecute(Runnable paramRunnable, Throwable paramThrowable) {
/*  65 */     super.afterExecute(paramRunnable, paramThrowable);
/*  66 */     if (paramThrowable != null) {
/*     */       
/*  68 */       this.interruptionChecker.setExecutionException(new ExecutionException("Uncaught exception", paramThrowable));
/*     */       
/*  70 */       this.interruptionChecker.interrupt(); return;
/*  71 */     }  if (paramRunnable instanceof Future) {
/*     */       
/*     */       try {
/*     */         
/*  75 */         ((Future)paramRunnable).get(); return;
/*  76 */       } catch (CancellationException|InterruptedException cancellationException) {
/*     */         
/*  78 */         this.interruptionChecker.interrupt(); return;
/*  79 */       } catch (ExecutionException executionException) {
/*     */         
/*  81 */         this.interruptionChecker.setExecutionException(executionException);
/*     */         
/*  83 */         this.interruptionChecker.interrupt();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     try {
/*  93 */       shutdown();
/*  94 */     } catch (SecurityException securityException) {}
/*     */ 
/*     */     
/*  97 */     boolean bool = false;
/*     */     
/*     */     try {
/* 100 */       bool = awaitTermination(2500L, TimeUnit.MILLISECONDS);
/* 101 */     } catch (InterruptedException interruptedException) {
/* 102 */       this.interruptionChecker.interrupt();
/*     */     } 
/* 104 */     if (!bool)
/*     */       
/*     */       try {
/* 107 */         shutdownNow(); return;
/* 108 */       } catch (SecurityException securityException) {
/* 109 */         throw new RuntimeException("Could not shut down ExecutorService -- need java.lang.RuntimePermission(\"modifyThread\"), or the security manager's checkAccess method denies access", securityException);
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\concurrency\AutoCloseableExecutorService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */