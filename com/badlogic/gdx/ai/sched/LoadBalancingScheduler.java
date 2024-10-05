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
/*     */ public class LoadBalancingScheduler
/*     */   extends SchedulerBase<SchedulerBase.SchedulableRecord>
/*     */ {
/*     */   protected int frame;
/*     */   
/*     */   public LoadBalancingScheduler(int paramInt) {
/*  59 */     super(paramInt);
/*  60 */     this.frame = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addWithAutomaticPhasing(Schedulable paramSchedulable, int paramInt) {
/*  70 */     add(paramSchedulable, paramInt, calculatePhase(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Schedulable paramSchedulable, int paramInt1, int paramInt2) {
/*  76 */     this.schedulableRecords.add(new SchedulerBase.SchedulableRecord(paramSchedulable, paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run(long paramLong) {
/*  84 */     this.frame++;
/*     */ 
/*     */     
/*  87 */     this.runList.size = 0;
/*     */ 
/*     */     
/*  90 */     for (byte b1 = 0; b1 < this.schedulableRecords.size; b1++) {
/*  91 */       SchedulerBase.SchedulableRecord schedulableRecord = (SchedulerBase.SchedulableRecord)this.schedulableRecords.get(b1);
/*     */       
/*  93 */       if ((this.frame + schedulableRecord.phase) % schedulableRecord.frequency == 0) this.runList.add(schedulableRecord);
/*     */     
/*     */     } 
/*     */     
/*  97 */     long l = TimeUtils.nanoTime();
/*     */ 
/*     */     
/* 100 */     int i = this.runList.size;
/*     */ 
/*     */     
/* 103 */     for (byte b2 = 0; b2 < i; b2++) {
/*     */       
/* 105 */       long l1 = TimeUtils.nanoTime();
/*     */       
/* 107 */       long l2 = (paramLong = paramLong - l1 - l) / (i - b2);
/*     */ 
/*     */       
/* 110 */       ((SchedulerBase.SchedulableRecord)this.runList.get(b2)).schedulable.run(l2);
/*     */ 
/*     */       
/* 113 */       l = l1;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\sched\LoadBalancingScheduler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */