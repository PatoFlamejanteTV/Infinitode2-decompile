/*    */ package com.vladsch.flexmark.util.misc;
/*    */ 
/*    */ public class MinMaxAvgFloat {
/*  4 */   private float min = Float.MAX_VALUE;
/*  5 */   private float max = Float.MIN_VALUE;
/*  6 */   private float total = 0.0F;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add(float paramFloat) {
/* 12 */     this.total += paramFloat;
/* 13 */     this.min = Math.min(this.min, paramFloat);
/* 14 */     this.max = Math.max(this.max, paramFloat);
/*    */   }
/*    */   
/*    */   public void add(MinMaxAvgFloat paramMinMaxAvgFloat) {
/* 18 */     this.total += paramMinMaxAvgFloat.total;
/* 19 */     this.min = Math.min(this.min, paramMinMaxAvgFloat.min);
/* 20 */     this.max = Math.max(this.max, paramMinMaxAvgFloat.max);
/*    */   }
/*    */   
/*    */   public void diff(float paramFloat1, float paramFloat2) {
/* 24 */     add(paramFloat2 - paramFloat1);
/*    */   }
/*    */   
/*    */   public float getMin() {
/* 28 */     return this.min;
/*    */   }
/*    */   
/*    */   public float getMax() {
/* 32 */     return this.max;
/*    */   }
/*    */   
/*    */   public float getTotal() {
/* 36 */     return this.total;
/*    */   }
/*    */   
/*    */   public float getAvg(float paramFloat) {
/* 40 */     return (paramFloat == 0.0F) ? 0.0F : (this.total / paramFloat);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\MinMaxAvgFloat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */