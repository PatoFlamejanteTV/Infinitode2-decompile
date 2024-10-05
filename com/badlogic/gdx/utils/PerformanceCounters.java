/*    */ package com.badlogic.gdx.utils;
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
/*    */ public class PerformanceCounters
/*    */ {
/*    */   private static final float nano2seconds = 1.0E-9F;
/* 25 */   private long lastTick = 0L;
/* 26 */   public final Array<PerformanceCounter> counters = new Array<>();
/*    */   
/*    */   public PerformanceCounter add(String paramString, int paramInt) {
/* 29 */     PerformanceCounter performanceCounter = new PerformanceCounter(paramString, paramInt);
/* 30 */     this.counters.add(performanceCounter);
/* 31 */     return performanceCounter;
/*    */   }
/*    */   
/*    */   public PerformanceCounter add(String paramString) {
/* 35 */     PerformanceCounter performanceCounter = new PerformanceCounter(paramString);
/* 36 */     this.counters.add(performanceCounter);
/* 37 */     return performanceCounter;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 41 */     long l = TimeUtils.nanoTime();
/* 42 */     if (this.lastTick > 0L) tick((float)(l - this.lastTick) * 1.0E-9F); 
/* 43 */     this.lastTick = l;
/*    */   }
/*    */   
/*    */   public void tick(float paramFloat) {
/* 47 */     for (byte b = 0; b < this.counters.size; b++)
/* 48 */       ((PerformanceCounter)this.counters.get(b)).tick(paramFloat); 
/*    */   }
/*    */   
/*    */   public StringBuilder toString(StringBuilder paramStringBuilder) {
/* 52 */     paramStringBuilder.setLength(0);
/* 53 */     for (byte b = 0; b < this.counters.size; b++) {
/* 54 */       if (b != 0) paramStringBuilder.append("; "); 
/* 55 */       ((PerformanceCounter)this.counters.get(b)).toString(paramStringBuilder);
/*    */     } 
/* 57 */     return paramStringBuilder;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\PerformanceCounters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */