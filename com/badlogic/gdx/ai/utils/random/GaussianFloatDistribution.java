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
/*    */ public final class GaussianFloatDistribution
/*    */   extends FloatDistribution
/*    */ {
/* 24 */   public static final GaussianFloatDistribution STANDARD_NORMAL = new GaussianFloatDistribution(0.0F, 1.0F);
/*    */   
/*    */   private final float mean;
/*    */   private final float standardDeviation;
/*    */   
/*    */   public GaussianFloatDistribution(float paramFloat1, float paramFloat2) {
/* 30 */     this.mean = paramFloat1;
/* 31 */     this.standardDeviation = paramFloat2;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float nextFloat() {
/* 36 */     return this.mean + (float)MathUtils.random.nextGaussian() * this.standardDeviation;
/*    */   }
/*    */   
/*    */   public final float getMean() {
/* 40 */     return this.mean;
/*    */   }
/*    */   
/*    */   public final float getStandardDeviation() {
/* 44 */     return this.standardDeviation;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\GaussianFloatDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */