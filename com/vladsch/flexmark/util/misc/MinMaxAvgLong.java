/*    */ package com.vladsch.flexmark.util.misc;
/*    */ 
/*    */ public class MinMaxAvgLong {
/*  4 */   private long min = Long.MAX_VALUE;
/*  5 */   private long max = Long.MIN_VALUE;
/*  6 */   private long total = 0L;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add(long paramLong) {
/* 12 */     this.total += paramLong;
/* 13 */     this.min = Math.min(this.min, paramLong);
/* 14 */     this.max = Math.max(this.max, paramLong);
/*    */   }
/*    */   
/*    */   public void add(MinMaxAvgLong paramMinMaxAvgLong) {
/* 18 */     this.total += paramMinMaxAvgLong.total;
/* 19 */     this.min = Math.min(this.min, paramMinMaxAvgLong.min);
/* 20 */     this.max = Math.max(this.max, paramMinMaxAvgLong.max);
/*    */   }
/*    */   
/*    */   public void diff(long paramLong1, long paramLong2) {
/* 24 */     add(paramLong2 - paramLong1);
/*    */   }
/*    */   
/*    */   public long getMin() {
/* 28 */     return this.min;
/*    */   }
/*    */   
/*    */   public long getMax() {
/* 32 */     return this.max;
/*    */   }
/*    */   
/*    */   public long getTotal() {
/* 36 */     return this.total;
/*    */   }
/*    */   
/*    */   public long getAvg(long paramLong) {
/* 40 */     return (paramLong == 0L) ? 0L : (this.total / paramLong);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\MinMaxAvgLong.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */