/*    */ package com.badlogic.gdx.ai.sched;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.IntArray;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SchedulerBase<T extends SchedulerBase.SchedulableRecord>
/*    */   implements Scheduler
/*    */ {
/*    */   protected Array<T> schedulableRecords;
/*    */   protected Array<T> runList;
/*    */   protected IntArray phaseCounters;
/*    */   protected int dryRunFrames;
/*    */   
/*    */   public SchedulerBase(int paramInt) {
/* 39 */     this.schedulableRecords = new Array();
/* 40 */     this.runList = new Array();
/* 41 */     this.phaseCounters = new IntArray();
/* 42 */     this.dryRunFrames = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected int calculatePhase(int paramInt) {
/* 52 */     if (paramInt > this.phaseCounters.size) this.phaseCounters.ensureCapacity(paramInt - this.phaseCounters.size);
/*    */     
/* 54 */     int[] arrayOfInt = this.phaseCounters.items;
/*    */ 
/*    */     
/* 57 */     this.phaseCounters.size = paramInt; int i;
/* 58 */     for (i = 0; i < paramInt; i++) {
/* 59 */       arrayOfInt[i] = 0;
/*    */     }
/*    */     
/* 62 */     for (i = 0; i < this.dryRunFrames; i++) {
/* 63 */       int j = i % paramInt;
/*    */       
/* 65 */       for (byte b2 = 0; b2 < this.schedulableRecords.size; b2++) {
/* 66 */         SchedulableRecord schedulableRecord = (SchedulableRecord)this.schedulableRecords.get(b2);
/*    */         
/* 68 */         if ((i - schedulableRecord.phase) % schedulableRecord.frequency == 0) arrayOfInt[j] = arrayOfInt[j] + 1;
/*    */       
/*    */       } 
/*    */     } 
/* 72 */     i = Integer.MAX_VALUE;
/* 73 */     byte b = -1;
/* 74 */     for (byte b1 = 0; b1 < paramInt; b1++) {
/* 75 */       if (arrayOfInt[b1] < i) {
/* 76 */         i = arrayOfInt[b1];
/* 77 */         b = b1;
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 82 */     return b;
/*    */   }
/*    */ 
/*    */   
/*    */   protected static class SchedulableRecord
/*    */   {
/*    */     Schedulable schedulable;
/*    */     
/*    */     int frequency;
/*    */     int phase;
/*    */     
/*    */     SchedulableRecord(Schedulable param1Schedulable, int param1Int1, int param1Int2) {
/* 94 */       this.schedulable = param1Schedulable;
/* 95 */       this.frequency = param1Int1;
/* 96 */       this.phase = param1Int2;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\sched\SchedulerBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */