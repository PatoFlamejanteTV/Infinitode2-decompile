/*     */ package com.badlogic.gdx.backends.lwjgl3;
/*     */ 
/*     */ import org.lwjgl.glfw.GLFW;
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
/*     */ class Sync
/*     */ {
/*     */   private static final long NANOS_IN_SECOND = 1000000000L;
/*  47 */   private long nextFrame = 0L;
/*     */ 
/*     */   
/*     */   private boolean initialised = false;
/*     */ 
/*     */   
/*  53 */   private RunningAvg sleepDurations = new RunningAvg(10);
/*  54 */   private RunningAvg yieldDurations = new RunningAvg(10);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sync(int paramInt) {
/*  64 */     if (paramInt <= 0)
/*  65 */       return;  if (!this.initialised) initialise();
/*     */     
/*     */     try {
/*     */       long l;
/*  69 */       for (l = getTime(); this.nextFrame - l > this.sleepDurations.avg(); l = l1) {
/*  70 */         Thread.sleep(1L); long l1;
/*  71 */         this.sleepDurations.add((l1 = getTime()) - l);
/*     */       } 
/*     */ 
/*     */       
/*  75 */       this.sleepDurations.dampenForLowResTicker();
/*     */ 
/*     */       
/*  78 */       for (l = getTime(); this.nextFrame - l > this.yieldDurations.avg(); l = l1) {
/*  79 */         Thread.yield(); long l1;
/*  80 */         this.yieldDurations.add((l1 = getTime()) - l);
/*     */       } 
/*  82 */     } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     this.nextFrame = Math.max(this.nextFrame + 1000000000L / paramInt, getTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initialise() {
/*  94 */     this.initialised = true;
/*     */     
/*  96 */     this.sleepDurations.init(1000000L);
/*  97 */     this.yieldDurations.init((int)(-(getTime() - getTime()) * 1.333D));
/*     */     
/*  99 */     this.nextFrame = getTime();
/*     */     
/*     */     String str;
/*     */     
/* 103 */     if ((str = System.getProperty("os.name")).startsWith("Win")) {
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
/* 117 */       (thread = new Thread(new Runnable() { public void run() { try { Thread.sleep(Long.MAX_VALUE); return; } catch (Exception exception) { return; }  } })).setName("LWJGL3 Timer");
/* 118 */       thread.setDaemon(true);
/* 119 */       thread.start();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long getTime() {
/* 127 */     return (long)(GLFW.glfwGetTime() * 1.0E9D);
/*     */   }
/*     */   
/*     */   private class RunningAvg
/*     */   {
/*     */     private final long[] slots;
/*     */     private int offset;
/*     */     private static final long DAMPEN_THRESHOLD = 10000000L;
/*     */     private static final float DAMPEN_FACTOR = 0.9F;
/*     */     
/*     */     public RunningAvg(int param1Int) {
/* 138 */       this.slots = new long[param1Int];
/* 139 */       this.offset = 0;
/*     */     }
/*     */     
/*     */     public void init(long param1Long) {
/* 143 */       while (this.offset < this.slots.length) {
/* 144 */         this.slots[this.offset++] = param1Long;
/*     */       }
/*     */     }
/*     */     
/*     */     public void add(long param1Long) {
/* 149 */       this.slots[this.offset++ % this.slots.length] = param1Long;
/* 150 */       this.offset %= this.slots.length;
/*     */     }
/*     */     
/*     */     public long avg() {
/* 154 */       long l = 0L;
/* 155 */       for (byte b = 0; b < this.slots.length; b++) {
/* 156 */         l += this.slots[b];
/*     */       }
/* 158 */       return l / this.slots.length;
/*     */     }
/*     */     
/*     */     public void dampenForLowResTicker() {
/* 162 */       if (avg() > 10000000L)
/* 163 */         for (byte b = 0; b < this.slots.length; b++)
/* 164 */           this.slots[b] = (long)((float)this.slots[b] * 0.9F);  
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Sync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */