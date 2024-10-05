/*    */ package com.vladsch.flexmark.util.misc;
/*    */ 
/*    */ public class MinMaxAvgInt {
/*  4 */   private int min = Integer.MAX_VALUE;
/*  5 */   private int max = Integer.MIN_VALUE;
/*  6 */   private int total = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add(int paramInt) {
/* 12 */     this.total += paramInt;
/* 13 */     this.min = Math.min(this.min, paramInt);
/* 14 */     this.max = Math.max(this.max, paramInt);
/*    */   }
/*    */   
/*    */   public void add(MinMaxAvgInt paramMinMaxAvgInt) {
/* 18 */     this.total += paramMinMaxAvgInt.total;
/* 19 */     this.min = Math.min(this.min, paramMinMaxAvgInt.min);
/* 20 */     this.max = Math.max(this.max, paramMinMaxAvgInt.max);
/*    */   }
/*    */   
/*    */   public void diff(int paramInt1, int paramInt2) {
/* 24 */     add(paramInt2 - paramInt1);
/*    */   }
/*    */   
/*    */   public int getMin() {
/* 28 */     return this.min;
/*    */   }
/*    */   
/*    */   public int getMax() {
/* 32 */     return this.max;
/*    */   }
/*    */   
/*    */   public int getTotal() {
/* 36 */     return this.total;
/*    */   }
/*    */   
/*    */   public int getAvg(int paramInt) {
/* 40 */     return (paramInt == 0) ? 0 : (this.total / paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\MinMaxAvgInt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */