/*    */ package com.badlogic.gdx.ai.utils.random;
/*    */ 
/*    */ import com.badlogic.gdx.math.MathUtils;
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
/*    */ public final class GaussianDoubleDistribution
/*    */   extends DoubleDistribution
/*    */ {
/* 24 */   public static final GaussianDoubleDistribution STANDARD_NORMAL = new GaussianDoubleDistribution(0.0D, 1.0D);
/*    */   
/*    */   private final double mean;
/*    */   private final double standardDeviation;
/*    */   
/*    */   public GaussianDoubleDistribution(double paramDouble1, double paramDouble2) {
/* 30 */     this.mean = paramDouble1;
/* 31 */     this.standardDeviation = paramDouble2;
/*    */   }
/*    */ 
/*    */   
/*    */   public final double nextDouble() {
/* 36 */     return this.mean + MathUtils.random.nextGaussian() * this.standardDeviation;
/*    */   }
/*    */   
/*    */   public final double getMean() {
/* 40 */     return this.mean;
/*    */   }
/*    */   
/*    */   public final double getStandardDeviation() {
/* 44 */     return this.standardDeviation;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\GaussianDoubleDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */