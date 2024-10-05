/*    */ package com.vladsch.flexmark.util.misc;
/*    */ 
/*    */ public class MinMaxAvgDouble {
/*  4 */   private double min = Double.MAX_VALUE;
/*  5 */   private double max = Double.MIN_VALUE;
/*  6 */   private double total = 0.0D;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add(double paramDouble) {
/* 12 */     this.total += paramDouble;
/* 13 */     this.min = Math.min(this.min, paramDouble);
/* 14 */     this.max = Math.max(this.max, paramDouble);
/*    */   }
/*    */   
/*    */   public void add(MinMaxAvgDouble paramMinMaxAvgDouble) {
/* 18 */     this.total += paramMinMaxAvgDouble.total;
/* 19 */     this.min = Math.min(this.min, paramMinMaxAvgDouble.min);
/* 20 */     this.max = Math.max(this.max, paramMinMaxAvgDouble.max);
/*    */   }
/*    */   
/*    */   public void diff(double paramDouble1, double paramDouble2) {
/* 24 */     add(paramDouble2 - paramDouble1);
/*    */   }
/*    */   
/*    */   public double getMin() {
/* 28 */     return this.min;
/*    */   }
/*    */   
/*    */   public double getMax() {
/* 32 */     return this.max;
/*    */   }
/*    */   
/*    */   public double getTotal() {
/* 36 */     return this.total;
/*    */   }
/*    */   
/*    */   public double getAvg(double paramDouble) {
/* 40 */     return (paramDouble == 0.0D) ? 0.0D : (this.total / paramDouble);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\MinMaxAvgDouble.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */