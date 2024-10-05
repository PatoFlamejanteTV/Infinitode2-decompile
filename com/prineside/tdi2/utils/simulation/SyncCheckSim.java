/*     */ package com.prineside.tdi2.utils.simulation;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.google.common.b.a.a;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import java.util.concurrent.BrokenBarrierException;
/*     */ import java.util.concurrent.CyclicBarrier;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ 
/*     */ 
/*     */ public class SyncCheckSim
/*     */   extends AbstractSimulation
/*     */ {
/*     */   public final SimConfig simConfig;
/*     */   public final int syncCheckFrameInterval;
/*     */   public final int parallelThreads;
/*     */   public final int extraLoadThreads;
/*     */   public final Array<ObjectPair<String, Scenario>> scenarios;
/*     */   public final Scenario extraLoadScenario;
/*  26 */   private final AtomicBoolean a = new AtomicBoolean(false);
/*  27 */   private final AtomicBoolean b = new AtomicBoolean(true);
/*  28 */   private final AtomicBoolean c = new AtomicBoolean(true);
/*     */   
/*  30 */   private final Array<GameSystemProvider> d = new Array(true, 1, GameSystemProvider.class);
/*     */   private final CyclicBarrier e;
/*  32 */   private final AtomicInteger f = new AtomicInteger(0);
/*  33 */   private final a g = new a(0.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Runnable h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SyncCheckSim(SimConfig paramSimConfig, Array<ObjectPair<String, Scenario>> paramArray, Scenario paramScenario, int paramInt1, int paramInt2, int paramInt3) {
/*  45 */     Preconditions.checkNotNull(paramSimConfig, "simConfig can not be null");
/*  46 */     Preconditions.checkNotNull(paramArray, "scenarios can not be null");
/*  47 */     Preconditions.checkArgument((paramInt1 >= 2), "parallelThreads must be 2+, %s given", paramInt1);
/*  48 */     Preconditions.checkArgument((paramInt2 >= 0), "extraLoadThreads must be 0+, %s given", paramInt2);
/*  49 */     Preconditions.checkArgument((paramInt3 > 0), "syncCheckFrameInterval must be 1+, %s given", paramInt3);
/*     */     
/*  51 */     this.simConfig = paramSimConfig.cpy();
/*  52 */     this.extraLoadScenario = paramScenario;
/*  53 */     this.syncCheckFrameInterval = paramInt3;
/*  54 */     this.parallelThreads = paramInt1;
/*  55 */     this.extraLoadThreads = paramInt2;
/*  56 */     this.scenarios = paramArray;
/*     */     
/*  58 */     Runnable runnable = () -> {
/*     */         GameSystemProvider gameSystemProvider;
/*     */         if ((gameSystemProvider = (GameSystemProvider)this.d.first()).gameState.updateNumber % paramInt1 == 0) {
/*     */           if (gameSystemProvider.gameState.updateNumber % paramInt1 * 100 == 0) {
/*     */             log((byte)1, "comparing GSPs " + gameSystemProvider.gameState.updateNumber + " on " + Thread.currentThread().getName());
/*     */           }
/*     */           try {
/*     */             for (byte b1 = 1; b1 < paramInt2; b1++) {
/*     */               GameSystemProvider gameSystemProvider1 = ((GameSystemProvider[])this.d.items)[b1];
/*     */               StringBuilder stringBuilder = new StringBuilder();
/*     */               gameSystemProvider.compareSync(gameSystemProvider1, stringBuilder, false);
/*     */               if (stringBuilder.length != 0) {
/*     */                 log((byte)3, "Desync on frame " + gameSystemProvider.gameState.updateNumber);
/*     */                 log((byte)3, stringBuilder.toString());
/*     */                 log((byte)3, "- S1 log: \n" + gameSystemProvider.syncCheckLog.toString("\n"));
/*     */                 log((byte)3, "- S2 log: \n" + gameSystemProvider1.syncCheckLog.toString("\n"));
/*     */                 this.b.set(false);
/*     */                 stop();
/*     */               } 
/*     */               gameSystemProvider1.syncCheckLog.clear();
/*     */             } 
/*  79 */           } catch (Exception exception) {
/*     */             logThrowable((byte)3, "exception in sim-sync, frame " + gameSystemProvider.gameState.updateNumber, exception);
/*     */           } 
/*     */           
/*     */           for (byte b = 0; b < paramInt2; b++) {
/*     */             GameSystemProvider gameSystemProvider1;
/*     */             
/*     */             (gameSystemProvider1 = ((GameSystemProvider[])this.d.items)[b]).syncCheckLog.clear();
/*     */           } 
/*     */           
/*     */           if (gameSystemProvider.gameState.updateNumber / paramInt1 % 10 == 0) {
/*     */             GameSystemProvider gameSystemProvider1 = gameSystemProvider.deepCopy();
/*     */             
/*     */             StringBuilder stringBuilder = new StringBuilder();
/*     */             
/*     */             gameSystemProvider.compareSync(gameSystemProvider1, stringBuilder, false);
/*     */             
/*     */             if (stringBuilder.length != 0) {
/*     */               log((byte)3, "Desync on frame " + gameSystemProvider.gameState.updateNumber + " from deep copy");
/*     */               log((byte)3, stringBuilder.toString());
/*     */               log((byte)3, "- S1 log: \n" + gameSystemProvider.syncCheckLog.toString("\n"));
/*     */               log((byte)3, "- S2 log: \n" + gameSystemProvider1.syncCheckLog.toString("\n"));
/*     */               this.b.set(false);
/*     */               stop();
/*     */             } 
/*     */             gameSystemProvider1.syncCheckLog.clear();
/*     */           } 
/*     */         } 
/*     */       };
/* 108 */     this.e = new CyclicBarrier(paramInt1, runnable);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence getName() {
/* 113 */     return "Sync check on " + this.parallelThreads + " threads, " + this.extraLoadThreads + " extra threads, " + this.simConfig.getShortDescription();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSimFinishListener(Runnable paramRunnable) {
/* 118 */     this.h = paramRunnable;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getProgress() {
/* 123 */     return this.g.floatValue() / this.scenarios.size + this.f.get() / this.scenarios.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/* 128 */     if (isRunning()) {
/* 129 */       throw new IllegalStateException("Already running");
/*     */     }
/*     */     
/* 132 */     this.f.set(0);
/* 133 */     this.g.a(0.0D);
/* 134 */     this.c.set(false);
/* 135 */     this.e.reset();
/* 136 */     this.a.set(true);
/* 137 */     this.b.set(true);
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
/* 157 */     (thread = new Thread(() -> { Array.ArrayIterator<ObjectPair> arrayIterator = this.scenarios.iterator(); while (arrayIterator.hasNext()) { ObjectPair objectPair = arrayIterator.next(); a((Scenario)objectPair.second); this.g.a(0.0D); if (isSuccessful() && isRunning()) { this.f.addAndGet(1); log((byte)1, "==== SIM END " + (String)objectPair.first + " : " + this.b.get()); }  }  log((byte)1, "==== ALL DONE"); stop(); this.c.set(true); if (this.h != null) Threads.i().runOnMainThread(this.h);  }"sync-check-main")).setDaemon(true);
/* 158 */     thread.start();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRunning() {
/* 163 */     return this.a.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadyToStart() {
/* 168 */     return this.c.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSuccessful() {
/* 173 */     return this.b.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 178 */     this.a.set(false);
/* 179 */     this.e.reset();
/*     */   }
/*     */   
/*     */   private void a(Scenario paramScenario) {
/* 183 */     log((byte)1, "Running test scenario: " + paramScenario);
/* 184 */     this.d.clear();
/*     */     
/* 186 */     Array array = new Array(true, 1, Thread.class);
/*     */     
/* 188 */     AtomicBoolean atomicBoolean = new AtomicBoolean(true);
/*     */     byte b;
/* 190 */     for (b = 0; b < this.parallelThreads; b++) {
/* 191 */       GameSystemProvider gameSystemProvider = SimConfig.createProgressSnapshotAndInitGSP(this.simConfig);
/* 192 */       Scenario scenario = paramScenario.cpy();
/* 193 */       this.d.add(gameSystemProvider);
/* 194 */       int j = this.d.size - 1;
/*     */       
/* 196 */       if (this.syncCheckFrameInterval == 1) {
/* 197 */         gameSystemProvider.syncChecking = true;
/*     */       }
/*     */       
/* 200 */       int i = b + 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       Thread thread;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 236 */       (thread = new Thread(() -> { paramScenario.start(((GameSystemProvider[])this.d.items)[paramInt1]); long l = Game.getRealTickCount(); while (!paramScenario.isFinished() && isRunning()) { GameSystemProvider gameSystemProvider = ((GameSystemProvider[])this.d.items)[paramInt1]; try { gameSystemProvider.updateSystems(); paramScenario.onUpdate(); if (paramInt2 == 1) this.g.a(paramScenario.getProgress());  if (!isRunning()) break;  this.e.await(); } catch (BrokenBarrierException brokenBarrierException) { log((byte)2, "broken barrier, stopping sim on frame " + gameSystemProvider.gameState.updateNumber); break; } catch (Exception exception) { this.b.set(false); stop(); logThrowable((byte)3, "exception in sim, frame " + gameSystemProvider.gameState.updateNumber, exception); break; }  }  log((byte)1, "sim-" + paramInt2 + " finished in " + ((Game.getRealTickCount() - l) * 0.001D) + "ms, " + (((GameSystemProvider[])this.d.items)[paramInt1]).gameState.updateNumber + " frames, random seed: " + (((GameSystemProvider[])this.d.items)[paramInt1]).gameState.getRandomState(0)); paramAtomicBoolean.set(false); }"sim-" + i)).setDaemon(true);
/* 237 */       array.add(thread);
/*     */     } 
/*     */ 
/*     */     
/* 241 */     for (b = 0; b < this.extraLoadThreads; b++) {
/* 242 */       int i = b + 1 + this.parallelThreads;
/* 243 */       Scenario scenario = this.extraLoadScenario.cpy();
/*     */       
/* 245 */       GameSystemProvider gameSystemProvider = SimConfig.createProgressSnapshotAndInitGSP(this.simConfig);
/* 246 */       String str = "sim-mass-" + i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       Thread thread;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 266 */       (thread = new Thread(() -> { paramScenario.start(paramGameSystemProvider); long l = Game.getRealTickCount(); while (!paramScenario.isFinished() && isRunning() && paramAtomicBoolean.get()) { try { paramGameSystemProvider.updateSystems(); paramScenario.onUpdate(); } catch (Exception exception) { this.b.set(false); stop(); logThrowable((byte)3, "exception in " + paramString + ", frame " + paramGameSystemProvider.gameState.updateNumber, exception); break; }  }  log((byte)1, paramString + " finished in " + ((Game.getRealTickCount() - l) * 0.001D) + "ms, " + paramGameSystemProvider.gameState.updateNumber + " frames, massThreadsAlive: " + paramAtomicBoolean.get()); }str)).setDaemon(true);
/* 267 */       array.add(thread);
/*     */     } 
/*     */     try {
/* 270 */       for (b = 0; b < array.size; b++) {
/* 271 */         ((Thread)array.get(b)).start();
/*     */       }
/* 273 */       for (b = 0; b < array.size; b++)
/* 274 */         ((Thread)array.get(b)).join(); 
/*     */       return;
/* 276 */     } catch (Exception exception) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\SyncCheckSim.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */