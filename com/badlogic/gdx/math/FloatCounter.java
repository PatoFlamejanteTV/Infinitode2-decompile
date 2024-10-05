/*    */ package com.badlogic.gdx.math;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Pool;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FloatCounter
/*    */   implements Pool.Poolable
/*    */ {
/*    */   public int count;
/*    */   public float total;
/*    */   public float min;
/*    */   public float max;
/*    */   public float average;
/*    */   public float latest;
/*    */   public float value;
/*    */   public final WindowedMean mean;
/*    */   
/*    */   public FloatCounter(int paramInt) {
/* 46 */     this.mean = (paramInt > 1) ? new WindowedMean(paramInt) : null;
/* 47 */     reset();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void put(float paramFloat) {
/* 53 */     this.latest = paramFloat;
/* 54 */     this.total += paramFloat;
/* 55 */     this.count++;
/* 56 */     this.average = this.total / this.count;
/*    */     
/* 58 */     if (this.mean != null) {
/* 59 */       this.mean.addValue(paramFloat);
/* 60 */       this.value = this.mean.getMean();
/*    */     } else {
/* 62 */       this.value = this.latest;
/*    */     } 
/* 64 */     if (this.mean == null || this.mean.hasEnoughData()) {
/* 65 */       if (this.value < this.min) this.min = this.value; 
/* 66 */       if (this.value > this.max) this.max = this.value;
/*    */     
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void reset() {
/* 73 */     this.count = 0;
/* 74 */     this.total = 0.0F;
/* 75 */     this.min = Float.MAX_VALUE;
/* 76 */     this.max = -3.4028235E38F;
/* 77 */     this.average = 0.0F;
/* 78 */     this.latest = 0.0F;
/* 79 */     this.value = 0.0F;
/* 80 */     if (this.mean != null) this.mean.clear();
/*    */   
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     return "FloatCounter{count=" + this.count + ", total=" + this.total + ", min=" + this.min + ", max=" + this.max + ", average=" + this.average + ", latest=" + this.latest + ", value=" + this.value + '}';
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\FloatCounter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */