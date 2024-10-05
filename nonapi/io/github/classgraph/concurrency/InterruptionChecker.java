/*     */ package nonapi.io.github.classgraph.concurrency;
/*     */ 
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InterruptionChecker
/*     */ {
/*  41 */   private final AtomicBoolean interrupted = new AtomicBoolean(false);
/*     */ 
/*     */   
/*  44 */   private final AtomicReference<ExecutionException> thrownExecutionException = new AtomicReference<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void interrupt() {
/*  49 */     this.interrupted.set(true);
/*  50 */     Thread.currentThread().interrupt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExecutionException(ExecutionException paramExecutionException) {
/*  61 */     if (paramExecutionException != null && this.thrownExecutionException.get() == null) {
/*  62 */       this.thrownExecutionException.compareAndSet(null, paramExecutionException);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExecutionException getExecutionException() {
/*  72 */     return this.thrownExecutionException.get();
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
/*     */   public static Throwable getCause(Throwable paramThrowable) {
/*  84 */     paramThrowable = paramThrowable;
/*  85 */     while (paramThrowable instanceof ExecutionException) {
/*  86 */       paramThrowable = paramThrowable.getCause();
/*     */     }
/*  88 */     return (paramThrowable != null) ? paramThrowable : new ExecutionException("ExecutionException with unknown cause", null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkAndReturn() {
/*  99 */     if (this.interrupted.get()) {
/*     */       
/* 101 */       interrupt();
/* 102 */       return true;
/*     */     } 
/*     */     
/* 105 */     if (Thread.currentThread().isInterrupted()) {
/*     */       
/* 107 */       this.interrupted.set(true);
/* 108 */       return true;
/*     */     } 
/* 110 */     return false;
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
/*     */   public void check() {
/*     */     ExecutionException executionException;
/* 125 */     if ((executionException = getExecutionException()) != null) {
/* 126 */       throw executionException;
/*     */     }
/*     */     
/* 129 */     if (checkAndReturn())
/* 130 */       throw new InterruptedException(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\concurrency\InterruptionChecker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */