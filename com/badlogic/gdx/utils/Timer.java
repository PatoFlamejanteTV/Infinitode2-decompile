/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.LifecycleListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Timer
/*     */ {
/*  32 */   static final Object threadLock = new Object();
/*     */   
/*     */   static TimerThread thread;
/*     */ 
/*     */   
/*     */   public static Timer instance() {
/*  38 */     synchronized (threadLock) {
/*     */       TimerThread timerThread;
/*  40 */       if ((timerThread = thread()).instance == null) timerThread.instance = new Timer(); 
/*  41 */       return timerThread.instance;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static TimerThread thread() {
/*  46 */     synchronized (threadLock) {
/*  47 */       if (thread == null || thread.files != Gdx.files) {
/*  48 */         if (thread != null) thread.dispose(); 
/*  49 */         thread = new TimerThread();
/*     */       } 
/*  51 */       return thread;
/*     */     } 
/*     */   }
/*     */   
/*  55 */   final Array<Task> tasks = new Array<>(false, 8);
/*     */   long stopTimeMillis;
/*     */   
/*     */   public Timer() {
/*  59 */     start();
/*     */   }
/*     */ 
/*     */   
/*     */   public Task postTask(Task paramTask) {
/*  64 */     return scheduleTask(paramTask, 0.0F, 0.0F, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Task scheduleTask(Task paramTask, float paramFloat) {
/*  69 */     return scheduleTask(paramTask, paramFloat, 0.0F, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Task scheduleTask(Task paramTask, float paramFloat1, float paramFloat2) {
/*  74 */     return scheduleTask(paramTask, paramFloat1, paramFloat2, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Task scheduleTask(Task paramTask, float paramFloat1, float paramFloat2, int paramInt) {
/*  80 */     synchronized (threadLock) {
/*  81 */       synchronized (this) {
/*  82 */         synchronized (paramTask) {
/*  83 */           if (paramTask.timer != null) throw new IllegalArgumentException("The same task may not be scheduled twice."); 
/*  84 */           paramTask.timer = this;
/*     */           
/*  86 */           long l1, l2 = (l1 = System.nanoTime() / 1000000L) + (long)(paramFloat1 * 1000.0F);
/*  87 */           if (thread.pauseTimeMillis > 0L) l2 -= l1 - thread.pauseTimeMillis; 
/*  88 */           paramTask.executeTimeMillis = l2;
/*  89 */           paramTask.intervalMillis = (long)(paramFloat2 * 1000.0F);
/*  90 */           paramTask.repeatCount = paramInt;
/*  91 */           this.tasks.add(paramTask);
/*     */         } 
/*     */       } 
/*  94 */       threadLock.notifyAll();
/*     */     } 
/*  96 */     return paramTask;
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 101 */     synchronized (threadLock) {
/* 102 */       if ((thread()).instances.removeValue(this, true)) this.stopTimeMillis = System.nanoTime() / 1000000L; 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void start() {
/* 108 */     synchronized (threadLock) {
/*     */       TimerThread timerThread;
/*     */       Array<Timer> array;
/* 111 */       if ((array = (timerThread = thread()).instances).contains(this, true))
/* 112 */         return;  array.add(this);
/* 113 */       if (this.stopTimeMillis > 0L) {
/* 114 */         delay(System.nanoTime() / 1000000L - this.stopTimeMillis);
/* 115 */         this.stopTimeMillis = 0L;
/*     */       } 
/* 117 */       threadLock.notifyAll();
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clear() {
/* 123 */     synchronized (threadLock) {
/* 124 */       null = thread();
/* 125 */       synchronized (this) {
/* 126 */         synchronized (null.postedTasks) {
/* 127 */           byte b; int i; for (b = 0, i = this.tasks.size; b < i; b++) {
/* 128 */             Task task = this.tasks.get(b);
/* 129 */             null.removePostedTask(task);
/* 130 */             task.reset();
/*     */           } 
/*     */         } 
/* 133 */         this.tasks.clear();
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean isEmpty() {
/* 141 */     return (this.tasks.size == 0);
/*     */   } synchronized long update(TimerThread paramTimerThread, long paramLong1, long paramLong2) {
/*     */     byte b;
/*     */     int i;
/* 145 */     for (b = 0, i = this.tasks.size; b < i; b++) {
/*     */       Task task;
/* 147 */       synchronized (task = this.tasks.get(b)) {
/* 148 */         if (task.executeTimeMillis > paramLong1) {
/* 149 */           paramLong2 = Math.min(paramLong2, task.executeTimeMillis - paramLong1);
/*     */         } else {
/*     */           
/* 152 */           if (task.repeatCount == 0) {
/* 153 */             task.timer = null;
/* 154 */             this.tasks.removeIndex(b);
/* 155 */             b--;
/* 156 */             i--;
/*     */           } else {
/* 158 */             task.executeTimeMillis = paramLong1 + task.intervalMillis;
/* 159 */             paramLong2 = Math.min(paramLong2, task.intervalMillis);
/* 160 */             if (task.repeatCount > 0) task.repeatCount--; 
/*     */           } 
/* 162 */           paramTimerThread.addPostedTask(task);
/*     */         } 
/*     */       } 
/* 165 */     }  return paramLong2;
/*     */   }
/*     */   public synchronized void delay(long paramLong) {
/*     */     byte b;
/*     */     int i;
/* 170 */     for (b = 0, i = this.tasks.size; b < i; b++) {
/*     */       Task task;
/* 172 */       synchronized (task = this.tasks.get(b)) {
/* 173 */         task.executeTimeMillis += paramLong;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Task post(Task paramTask) {
/* 181 */     return instance().postTask(paramTask);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Task schedule(Task paramTask, float paramFloat) {
/* 187 */     return instance().scheduleTask(paramTask, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Task schedule(Task paramTask, float paramFloat1, float paramFloat2) {
/* 193 */     return instance().scheduleTask(paramTask, paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Task schedule(Task paramTask, float paramFloat1, float paramFloat2, int paramInt) {
/* 199 */     return instance().scheduleTask(paramTask, paramFloat1, paramFloat2, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class Task
/*     */     implements Runnable
/*     */   {
/* 211 */     final Application app = Gdx.app; long executeTimeMillis; public Task() {
/* 212 */       if (this.app == null) throw new IllegalStateException("Gdx.app not available."); 
/*     */     }
/*     */     long intervalMillis;
/*     */     int repeatCount;
/*     */     volatile Timer timer;
/*     */     
/*     */     public abstract void run();
/*     */     
/*     */     public void cancel() {
/* 221 */       synchronized (Timer.threadLock) {
/* 222 */         Timer.thread().removePostedTask(this);
/*     */         Timer timer;
/* 224 */         if ((timer = this.timer) != null) {
/* 225 */           synchronized (timer) {
/* 226 */             timer.tasks.removeValue(this, true);
/* 227 */             reset();
/*     */           } 
/*     */         } else {
/* 230 */           reset();
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } synchronized void reset() {
/* 235 */       this.executeTimeMillis = 0L;
/* 236 */       this.timer = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isScheduled() {
/* 250 */       return (this.timer != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public synchronized long getExecuteTimeMillis() {
/* 255 */       return this.executeTimeMillis;
/*     */     }
/*     */   }
/*     */   
/*     */   static class TimerThread
/*     */     implements LifecycleListener, Runnable
/*     */   {
/*     */     final Files files;
/*     */     final Application app;
/* 264 */     final Array<Timer> instances = new Array<>(1);
/*     */     
/*     */     Timer instance;
/*     */     long pauseTimeMillis;
/* 268 */     final Array<Timer.Task> postedTasks = new Array<>(2);
/* 269 */     final Array<Timer.Task> runTasks = new Array<>(2);
/* 270 */     private final Runnable runPostedTasks = new Runnable() {
/*     */         public void run() {
/* 272 */           Timer.TimerThread.this.runPostedTasks();
/*     */         }
/*     */       };
/*     */     
/*     */     public TimerThread() {
/* 277 */       this.files = Gdx.files;
/* 278 */       this.app = Gdx.app;
/* 279 */       this.app.addLifecycleListener(this);
/* 280 */       resume();
/*     */       
/*     */       Thread thread;
/* 283 */       (thread = new Thread(this, "Timer")).setDaemon(true);
/* 284 */       thread.start();
/*     */     }
/*     */     
/*     */     public void run() {
/*     */       while (true) {
/* 289 */         synchronized (Timer.threadLock) {
/* 290 */           if (Timer.thread != this || this.files != Gdx.files)
/*     */             break; 
/* 292 */           long l = 5000L;
/* 293 */           if (this.pauseTimeMillis == 0L) {
/* 294 */             long l1 = System.nanoTime() / 1000000L; byte b; int i;
/* 295 */             for (b = 0, i = this.instances.size; b < i; b++) {
/*     */               try {
/* 297 */                 l = ((Timer)this.instances.get(b)).update(this, l1, l);
/* 298 */               } catch (Throwable throwable) {
/* 299 */                 throw new GdxRuntimeException("Task failed: " + ((Timer)this.instances.get(b)).getClass().getName(), throwable);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 304 */           if (Timer.thread != this || this.files != Gdx.files)
/*     */             break; 
/*     */           try {
/* 307 */             if (throwable > 0L) Timer.threadLock.wait(throwable); 
/* 308 */           } catch (InterruptedException interruptedException) {}
/*     */         } 
/*     */       } 
/*     */       
/* 312 */       dispose();
/*     */     }
/*     */     
/*     */     void runPostedTasks() {
/* 316 */       synchronized (this.postedTasks) {
/* 317 */         this.runTasks.addAll(this.postedTasks);
/* 318 */         this.postedTasks.clear();
/*     */       } 
/* 320 */       T[] arrayOfT = this.runTasks.items; byte b; int i;
/* 321 */       for (b = 0, i = this.runTasks.size; b < i; b++)
/* 322 */         ((Timer.Task)arrayOfT[b]).run(); 
/* 323 */       this.runTasks.clear();
/*     */     }
/*     */     
/*     */     void addPostedTask(Timer.Task param1Task) {
/* 327 */       synchronized (this.postedTasks) {
/* 328 */         if (this.postedTasks.isEmpty()) param1Task.app.postRunnable(this.runPostedTasks); 
/* 329 */         this.postedTasks.add(param1Task);
/*     */         return;
/*     */       } 
/*     */     }
/*     */     void removePostedTask(Timer.Task param1Task) {
/* 334 */       synchronized (this.postedTasks) {
/* 335 */         T[] arrayOfT = this.postedTasks.items;
/* 336 */         for (int i = this.postedTasks.size - 1; i >= 0; i--) {
/* 337 */           if (arrayOfT[i] == param1Task) this.postedTasks.removeIndex(i); 
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } public void resume() {
/* 342 */       synchronized (Timer.threadLock) {
/* 343 */         long l = System.nanoTime() / 1000000L - this.pauseTimeMillis; byte b; int i;
/* 344 */         for (b = 0, i = this.instances.size; b < i; b++)
/* 345 */           ((Timer)this.instances.get(b)).delay(l); 
/* 346 */         this.pauseTimeMillis = 0L;
/* 347 */         Timer.threadLock.notifyAll();
/*     */         return;
/*     */       } 
/*     */     }
/*     */     public void pause() {
/* 352 */       synchronized (Timer.threadLock) {
/* 353 */         this.pauseTimeMillis = System.nanoTime() / 1000000L;
/* 354 */         Timer.threadLock.notifyAll();
/*     */         return;
/*     */       } 
/*     */     }
/*     */     public void dispose() {
/* 359 */       synchronized (Timer.threadLock) {
/* 360 */         synchronized (this.postedTasks) {
/* 361 */           this.postedTasks.clear();
/*     */         } 
/* 363 */         if (Timer.thread == this) Timer.thread = null; 
/* 364 */         this.instances.clear();
/* 365 */         Timer.threadLock.notifyAll();
/*     */       } 
/* 367 */       this.app.removeLifecycleListener(this);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Timer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */