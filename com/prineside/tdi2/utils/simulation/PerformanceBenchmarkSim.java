/*     */ package com.prineside.tdi2.utils.simulation;
/*     */ 
/*     */ import com.google.common.b.a.a;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ 
/*     */ public final class PerformanceBenchmarkSim
/*     */   extends AbstractSimulation {
/*  19 */   private static final TLog a = TLog.forClass(PerformanceBenchmarkSim.class);
/*     */   
/*     */   public static final long BENCHMARK_STATE_START_TIMESTAMP = 1692113508000L;
/*     */   
/*     */   public final SimConfig simConfig;
/*     */   
/*     */   public final int threadCount;
/*     */   
/*     */   public final int repeatCount;
/*     */   public final int frameCount;
/*     */   public final int jobCount;
/*  30 */   private final AtomicBoolean b = new AtomicBoolean(true);
/*     */   private final a[] c;
/*  32 */   private final AtomicBoolean d = new AtomicBoolean();
/*     */   
/*     */   private Runnable e;
/*     */   
/*     */   public PerformanceBenchmarkSim(SimConfig paramSimConfig, int paramInt1, int paramInt2, int paramInt3) {
/*  37 */     this.simConfig = paramSimConfig.cpy();
/*  38 */     this.simConfig.startTimestamp = 1692113508000L;
/*  39 */     this.threadCount = paramInt1;
/*  40 */     this.repeatCount = paramInt2;
/*  41 */     this.frameCount = paramInt3;
/*  42 */     this.jobCount = paramInt2 * paramInt1;
/*     */     
/*  44 */     this.c = new a[this.jobCount];
/*  45 */     for (byte b = 0; b < this.jobCount; b++) {
/*  46 */       this.c[b] = new a(0.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getName() {
/*  52 */     return "Performance benchmark on " + this.threadCount + " threads, " + this.repeatCount + " repeats, " + this.frameCount + " frames, " + this.simConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setSimFinishListener(Runnable paramRunnable) {
/*  57 */     this.e = paramRunnable;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getProgress() {
/*  62 */     double d = 0.0D; a[] arrayOfA; int i; byte b;
/*  63 */     for (i = (arrayOfA = this.c).length, b = 0; b < i; ) { a a1 = arrayOfA[b];
/*  64 */       d += a1.a(); b++; }
/*     */     
/*  66 */     return (float)(d / this.jobCount);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void start() {
/*  71 */     if (isRunning()) {
/*  72 */       throw new IllegalStateException("Already running");
/*     */     }
/*  74 */     for (byte b = 0; b < this.jobCount; b++) {
/*  75 */       this.c[b].a(0.0D);
/*     */     }
/*  77 */     this.b.set(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Thread thread;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 116 */     (thread = new Thread(() -> { this.d.set(true); ExecutorService executorService = Executors.newFixedThreadPool(this.threadCount, (ThreadFactory)new Threads.DaemonThreadFactory("Performance benchmark", true)); ArrayList<Callable> arrayList = new ArrayList(); JustUpdateScenario justUpdateScenario = new JustUpdateScenario(this.frameCount); for (byte b = 0; b < this.jobCount; b++) { byte b1 = b; a.i("add callable " + b1, new Object[0]); arrayList.add(()); }  this.d.set(true); long l1 = Game.getRealTickCount(); try { log((byte)1, "invoking " + arrayList.size() + " callables"); executorService.invokeAll((Collection)arrayList); } catch (InterruptedException interruptedException) { throw new RuntimeException(interruptedException); }  long l2 = (this.frameCount * this.repeatCount) * this.threadCount; double d = (Game.getRealTickCount() - l1) * 0.001D; log((byte)1, "all sim threads finished in " + d + "ms, " + StringFormatter.commaSeparatedNumber(l2) + " frames / " + StringFormatter.commaSeparatedNumber((long)(l2 / d * 1000.0D)) + " UPS"); stop(); if (this.e != null) Threads.i().runOnMainThread(this.e);  }"PerformanceBenchmarkSim main")).setDaemon(true);
/* 117 */     thread.start();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isRunning() {
/* 122 */     return this.d.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isReadyToStart() {
/* 127 */     return !isRunning();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isSuccessful() {
/* 132 */     return this.b.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void stop() {
/* 137 */     this.d.set(false);
/*     */   }
/*     */   
/*     */   private void a(int paramInt, SimConfig paramSimConfig, Scenario paramScenario, a parama) {
/* 141 */     log((byte)1, "starting sim #" + paramInt);
/* 142 */     GameSystemProvider gameSystemProvider = SimConfig.createProgressSnapshotAndInitGSP(paramSimConfig);
/*     */     
/* 144 */     (paramScenario = paramScenario.cpy()).start(gameSystemProvider);
/* 145 */     long l = Game.getRealTickCount();
/* 146 */     while (!paramScenario.isFinished() && 
/* 147 */       isRunning()) {
/*     */ 
/*     */       
/*     */       try {
/* 151 */         gameSystemProvider.updateSystems();
/* 152 */         paramScenario.onUpdate();
/* 153 */         parama.a(paramScenario.getProgress());
/* 154 */       } catch (Exception exception) {
/* 155 */         stop();
/* 156 */         this.b.set(false);
/* 157 */         logThrowable((byte)3, "exception in sim, frame " + gameSystemProvider.gameState.updateNumber, exception);
/*     */         break;
/*     */       } 
/*     */     } 
/* 161 */     log((byte)1, "sim #" + paramInt + " finished in " + ((Game.getRealTickCount() - l) * 0.001D) + "ms, " + gameSystemProvider.gameState.updateNumber + " frames, completed waves: " + gameSystemProvider.wave.getCompletedWavesCount());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\PerformanceBenchmarkSim.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */