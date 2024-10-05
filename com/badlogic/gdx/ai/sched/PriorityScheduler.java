/*     */ package com.badlogic.gdx.ai.sched;
/*     */ 
/*     */ import com.badlogic.gdx.utils.TimeUtils;
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
/*     */ public class PriorityScheduler
/*     */   extends SchedulerBase<PriorityScheduler.PrioritySchedulableRecord>
/*     */ {
/*     */   protected int frame;
/*     */   
/*     */   public PriorityScheduler(int paramInt) {
/*  36 */     super(paramInt);
/*  37 */     this.frame = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run(long paramLong) {
/*  45 */     this.frame++;
/*     */ 
/*     */     
/*  48 */     this.runList.size = 0;
/*  49 */     float f = 0.0F;
/*     */ 
/*     */     
/*  52 */     for (byte b1 = 0; b1 < this.schedulableRecords.size; b1++) {
/*  53 */       PrioritySchedulableRecord prioritySchedulableRecord = (PrioritySchedulableRecord)this.schedulableRecords.get(b1);
/*     */       
/*  55 */       if ((this.frame + prioritySchedulableRecord.phase) % prioritySchedulableRecord.frequency == 0) {
/*  56 */         this.runList.add(prioritySchedulableRecord);
/*  57 */         f += prioritySchedulableRecord.priority;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  62 */     long l = TimeUtils.nanoTime();
/*     */ 
/*     */     
/*  65 */     int i = this.runList.size;
/*     */ 
/*     */     
/*  68 */     for (byte b2 = 0; b2 < i; b2++) {
/*     */       
/*  70 */       long l2 = TimeUtils.nanoTime();
/*  71 */       paramLong -= l2 - l;
/*  72 */       PrioritySchedulableRecord prioritySchedulableRecord = (PrioritySchedulableRecord)this.runList.get(b2);
/*  73 */       long l3 = (long)((float)paramLong * prioritySchedulableRecord.priority / f);
/*     */ 
/*     */       
/*  76 */       prioritySchedulableRecord.schedulable.run(l3);
/*     */ 
/*     */       
/*  79 */       long l1 = l2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addWithAutomaticPhasing(Schedulable paramSchedulable, int paramInt) {
/*  89 */     addWithAutomaticPhasing(paramSchedulable, paramInt, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addWithAutomaticPhasing(Schedulable paramSchedulable, int paramInt, float paramFloat) {
/*  99 */     add(paramSchedulable, paramInt, calculatePhase(paramInt), paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Schedulable paramSchedulable, int paramInt1, int paramInt2) {
/* 108 */     add(paramSchedulable, paramInt1, paramInt2, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Schedulable paramSchedulable, int paramInt1, int paramInt2, float paramFloat) {
/* 118 */     this.schedulableRecords.add(new PrioritySchedulableRecord(paramSchedulable, paramInt1, paramInt2, paramFloat));
/*     */   }
/*     */ 
/*     */   
/*     */   static class PrioritySchedulableRecord
/*     */     extends SchedulerBase.SchedulableRecord
/*     */   {
/*     */     float priority;
/*     */     
/*     */     PrioritySchedulableRecord(Schedulable param1Schedulable, int param1Int1, int param1Int2, float param1Float) {
/* 128 */       super(param1Schedulable, param1Int1, param1Int2);
/* 129 */       this.priority = param1Float;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\sched\PriorityScheduler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */