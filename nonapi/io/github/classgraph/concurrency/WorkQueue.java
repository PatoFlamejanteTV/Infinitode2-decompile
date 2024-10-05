/*     */ package nonapi.io.github.classgraph.concurrency;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.CancellationException;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
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
/*     */ public class WorkQueue<T>
/*     */   implements AutoCloseable
/*     */ {
/*     */   private final WorkUnitProcessor<T> workUnitProcessor;
/*  55 */   private final BlockingQueue<WorkUnitWrapper<T>> workUnits = new LinkedBlockingQueue<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int numWorkers;
/*     */ 
/*     */ 
/*     */   
/*  64 */   private final AtomicInteger numIncompleteWorkUnits = new AtomicInteger();
/*     */ 
/*     */   
/*  67 */   private final ConcurrentLinkedQueue<Future<?>> workerFutures = new ConcurrentLinkedQueue<>();
/*     */ 
/*     */ 
/*     */   
/*     */   private final InterruptionChecker interruptionChecker;
/*     */ 
/*     */ 
/*     */   
/*     */   private final LogNode log;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface WorkUnitProcessor<T>
/*     */   {
/*     */     void processWorkUnit(T param1T, WorkQueue<T> param1WorkQueue, LogNode param1LogNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class WorkUnitWrapper<T>
/*     */   {
/*     */     final T workUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WorkUnitWrapper(T param1T) {
/*  96 */       this.workUnit = param1T;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <U> void runWorkQueue(Collection<U> paramCollection, ExecutorService paramExecutorService, InterruptionChecker paramInterruptionChecker, int paramInt, LogNode paramLogNode, WorkUnitProcessor<U> paramWorkUnitProcessor) {
/*     */     ExecutorService executorService;
/* 148 */     if (paramCollection.isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 154 */     WorkQueue<U> workQueue = new WorkQueue<>(paramCollection, paramWorkUnitProcessor, paramInt, paramInterruptionChecker, paramLogNode); paramInterruptionChecker = null;
/*     */ 
/*     */     
/* 157 */     try { workQueue.startWorkers(paramExecutorService, paramInt - 1);
/*     */ 
/*     */ 
/*     */       
/* 161 */       workQueue.runWorkLoop();
/* 162 */       if (paramInterruptionChecker != null) try { return; } catch (Throwable throwable) { return; }   return; } catch (Throwable throwable) { executorService = paramExecutorService = null; throw paramExecutorService; } finally { if (executorService != null) { try { workQueue.close(); } catch (Throwable throwable) { executorService.addSuppressed(throwable); }  } else { throwable.close(); }
/*     */        }
/*     */   
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
/*     */   private WorkQueue(Collection<T> paramCollection, WorkUnitProcessor<T> paramWorkUnitProcessor, int paramInt, InterruptionChecker paramInterruptionChecker, LogNode paramLogNode) {
/* 181 */     this.workUnitProcessor = paramWorkUnitProcessor;
/* 182 */     this.numWorkers = paramInt;
/* 183 */     this.interruptionChecker = paramInterruptionChecker;
/* 184 */     this.log = paramLogNode;
/* 185 */     addWorkUnits(paramCollection);
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
/*     */   private void startWorkers(ExecutorService paramExecutorService, int paramInt) {
/* 197 */     for (byte b = 0; b < paramInt; b++) {
/* 198 */       this.workerFutures.add(paramExecutorService.submit(new Callable<Void>()
/*     */             {
/*     */               public Void call() {
/* 201 */                 WorkQueue.this.runWorkLoop();
/* 202 */                 return null;
/*     */               }
/*     */             }));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void sendPoisonPills() {
/* 213 */     for (byte b = 0; b < this.numWorkers; b++) {
/* 214 */       this.workUnits.add(new WorkUnitWrapper<>(null));
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
/*     */   private void runWorkLoop() {
/*     */     while (true) {
/*     */       try {
/* 235 */         this.interruptionChecker.check();
/*     */ 
/*     */         
/*     */         WorkUnitWrapper workUnitWrapper;
/*     */         
/* 240 */         if ((workUnitWrapper = this.workUnits.take()).workUnit == null) {
/*     */           return;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 246 */         this.workUnitProcessor.processWorkUnit(workUnitWrapper.workUnit, this, this.log);
/*     */       }
/* 248 */       catch (InterruptedException|Error interruptedException) {
/*     */         
/* 250 */         this.workUnits.clear();
/* 251 */         this.numIncompleteWorkUnits.set(0);
/* 252 */         sendPoisonPills();
/* 253 */         throw interruptedException;
/*     */       }
/* 255 */       catch (RuntimeException runtimeException) {
/*     */         
/* 257 */         this.workUnits.clear();
/* 258 */         this.numIncompleteWorkUnits.set(0);
/* 259 */         sendPoisonPills();
/* 260 */         throw new ExecutionException("Worker thread threw unchecked exception", runtimeException);
/*     */       } 
/*     */       
/* 263 */       if (this.numIncompleteWorkUnits.decrementAndGet() == 0)
/*     */       {
/* 265 */         sendPoisonPills();
/*     */       }
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
/*     */   public void addWorkUnit(T paramT) {
/* 279 */     if (paramT == null) {
/* 280 */       throw new NullPointerException("workUnit cannot be null");
/*     */     }
/* 282 */     this.numIncompleteWorkUnits.incrementAndGet();
/* 283 */     this.workUnits.add(new WorkUnitWrapper<>(paramT));
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
/*     */   public void addWorkUnits(Collection<T> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   6: astore_1
/*     */     //   7: aload_1
/*     */     //   8: invokeinterface hasNext : ()Z
/*     */     //   13: ifeq -> 31
/*     */     //   16: aload_1
/*     */     //   17: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   22: astore_2
/*     */     //   23: aload_0
/*     */     //   24: aload_2
/*     */     //   25: invokevirtual addWorkUnit : (Ljava/lang/Object;)V
/*     */     //   28: goto -> 7
/*     */     //   31: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #295	-> 0
/*     */     //   #296	-> 23
/*     */     //   #297	-> 28
/*     */     //   #298	-> 31
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
/*     */   public void close() {
/*     */     Future future;
/* 309 */     while ((future = this.workerFutures.poll()) != null) {
/*     */       
/*     */       try {
/* 312 */         future.get();
/* 313 */       } catch (CancellationException cancellationException) {
/* 314 */         if (this.log != null) {
/* 315 */           this.log.log("~", "Worker thread was cancelled");
/*     */         }
/* 317 */       } catch (InterruptedException interruptedException) {
/* 318 */         if (this.log != null) {
/* 319 */           this.log.log("~", "Worker thread was interrupted");
/*     */         }
/*     */         
/* 322 */         this.interruptionChecker.interrupt();
/* 323 */       } catch (ExecutionException executionException) {
/* 324 */         this.interruptionChecker.setExecutionException(executionException);
/* 325 */         this.interruptionChecker.interrupt();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\concurrency\WorkQueue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */