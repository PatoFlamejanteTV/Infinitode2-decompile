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
/*    */ public final class ConstantFloatDistribution
/*    */   extends FloatDistribution
/*    */ {
/* 22 */   public static final ConstantFloatDistribution NEGATIVE_ONE = new ConstantFloatDistribution(-1.0F);
/* 23 */   public static final ConstantFloatDistribution ZERO = new ConstantFloatDistribution(0.0F);
/* 24 */   public static final ConstantFloatDistribution ONE = new ConstantFloatDistribution(1.0F);
/* 25 */   public static final ConstantFloatDistribution ZERO_POINT_FIVE = new ConstantFloatDistribution(0.5F);
/*    */   
/*    */   private final float value;
/*    */   
/*    */   public ConstantFloatDistribution(float paramFloat) {
/* 30 */     this.value = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float nextFloat() {
/* 35 */     return this.value;
/*    */   }
/*    */   
/*    */   public final float getValue() {
/* 39 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\ConstantFloatDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */