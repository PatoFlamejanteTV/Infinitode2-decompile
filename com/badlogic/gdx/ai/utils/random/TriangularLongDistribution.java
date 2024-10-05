/*    */ package com.badlogic.gdx.ai.utils.random;
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
/*    */ public final class TriangularLongDistribution
/*    */   extends LongDistribution
/*    */ {
/*    */   private final long low;
/*    */   private final long high;
/*    */   private final double mode;
/*    */   
/*    */   public TriangularLongDistribution(long paramLong) {
/* 27 */     this(-paramLong, paramLong);
/*    */   }
/*    */   
/*    */   public TriangularLongDistribution(long paramLong1, long paramLong2) {
/* 31 */     this(paramLong1, paramLong2, (paramLong1 + paramLong2) * 0.5D);
/*    */   }
/*    */   
/*    */   public TriangularLongDistribution(long paramLong1, long paramLong2, double paramDouble) {
/* 35 */     this.low = paramLong1;
/* 36 */     this.high = paramLong2;
/* 37 */     this.mode = paramDouble;
/*    */   }
/*    */ 
/*    */   
/*    */   public final long nextLong() {
/*    */     double d;
/* 43 */     if (-this.low == this.high && this.mode == 0.0D) {
/* 44 */       d = TriangularDoubleDistribution.randomTriangular(this.high);
/*    */     } else {
/* 46 */       d = TriangularDoubleDistribution.randomTriangular(this.low, this.high, this.mode);
/* 47 */     }  return Math.round(d);
/*    */   }
/*    */   
/*    */   public final long getLow() {
/* 51 */     return this.low;
/*    */   }
/*    */   
/*    */   public final long getHigh() {
/* 55 */     return this.high;
/*    */   }
/*    */   
/*    */   public final double getMode() {
/* 59 */     return this.mode;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\TriangularLongDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */