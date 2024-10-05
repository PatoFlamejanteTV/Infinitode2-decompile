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
/*    */ public final class ConstantDoubleDistribution
/*    */   extends DoubleDistribution
/*    */ {
/* 22 */   public static final ConstantDoubleDistribution NEGATIVE_ONE = new ConstantDoubleDistribution(-1.0D);
/* 23 */   public static final ConstantDoubleDistribution ZERO = new ConstantDoubleDistribution(0.0D);
/* 24 */   public static final ConstantDoubleDistribution ONE = new ConstantDoubleDistribution(1.0D);
/*    */   
/*    */   private final double value;
/*    */   
/*    */   public ConstantDoubleDistribution(double paramDouble) {
/* 29 */     this.value = paramDouble;
/*    */   }
/*    */ 
/*    */   
/*    */   public final double nextDouble() {
/* 34 */     return this.value;
/*    */   }
/*    */   
/*    */   public final double getValue() {
/* 38 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\ConstantDoubleDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */