/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class GameSyncLoader {
/*   9 */   private static final TLog a = TLog.forClass(GameSyncLoader.class);
/*     */   
/*  11 */   private final Array<Task> b = new Array();
/*  12 */   private final DelayedRemovalArray<SyncExecutionListener> c = new DelayedRemovalArray(false, 1);
/*     */   
/*  14 */   private int d = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTask(Task paramTask) {
/*  20 */     if (this.d != 0) {
/*  21 */       throw new IllegalStateException("Can't registerDelta new tasks, already executing");
/*     */     }
/*     */     
/*  24 */     this.b.add(paramTask);
/*     */   }
/*     */   
/*     */   public void addListener(SyncExecutionListener paramSyncExecutionListener) {
/*  28 */     if (paramSyncExecutionListener == null) {
/*  29 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/*  32 */     if (!this.c.contains(paramSyncExecutionListener, true)) {
/*  33 */       this.c.add(paramSyncExecutionListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean iterateWithTimeout(long paramLong) {
/*  38 */     long l = Game.getTimestampMillis();
/*  39 */     while (Game.getTimestampMillis() - l < paramLong) {
/*     */       boolean bool;
/*  41 */       if (!(bool = iterate())) {
/*  42 */         return false;
/*     */       }
/*     */     } 
/*  45 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean iterate() {
/*  52 */     if (this.d == this.b.size) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (this.d < this.b.size) {
/*  57 */       Task task = (Task)this.b.get(this.d);
/*     */ 
/*     */       
/*  60 */       this.c.begin(); byte b; int i;
/*  61 */       for (b = 0, i = this.c.size; b < i; b++) {
/*  62 */         ((SyncExecutionListener)this.c.get(b)).startedTask(task, (this.d == 0) ? null : (Task)this.b.get(this.d - 1));
/*     */       }
/*  64 */       this.c.end();
/*     */ 
/*     */       
/*  67 */       long l = Game.getRealTickCount();
/*  68 */       a.i("starting \"" + task.title + "\"", new Object[0]);
/*  69 */       task.a.run();
/*  70 */       a.i("done \"" + task.title + "\" in " + ((float)(Game.getRealTickCount() - l) * 0.001F) + "ms", new Object[0]);
/*     */       
/*  72 */       this.d++;
/*     */       
/*  74 */       if (this.d == this.b.size) {
/*     */         
/*  76 */         this.c.begin(); byte b1; int j;
/*  77 */         for (b1 = 0, j = this.c.size; b1 < j; b1++) {
/*  78 */           ((SyncExecutionListener)this.c.get(b1)).done();
/*     */         }
/*  80 */         this.c.end();
/*     */       } 
/*     */     } 
/*     */     
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   public float getProgress() {
/*  88 */     return this.d / this.b.size;
/*     */   }
/*     */   
/*     */   public boolean isDone() {
/*  92 */     return (this.d == this.b.size);
/*     */   }
/*     */   
/*     */   public static class Task {
/*     */     final Runnable a;
/*     */     public final String title;
/*     */     
/*     */     public Task(String param1String, Runnable param1Runnable) {
/* 100 */       if (param1Runnable == null) throw new IllegalArgumentException("runnable is null for task " + param1String);
/*     */       
/* 102 */       this.a = param1Runnable;
/* 103 */       this.title = param1String;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface SyncExecutionListener {
/*     */     void startedTask(GameSyncLoader.Task param1Task1, GameSyncLoader.Task param1Task2);
/*     */     
/*     */     void done();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\GameSyncLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */