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
/*    */ public final class ConstantIntegerDistribution
/*    */   extends IntegerDistribution
/*    */ {
/* 22 */   public static final ConstantIntegerDistribution NEGATIVE_ONE = new ConstantIntegerDistribution(-1);
/* 23 */   public static final ConstantIntegerDistribution ZERO = new ConstantIntegerDistribution(0);
/* 24 */   public static final ConstantIntegerDistribution ONE = new ConstantIntegerDistribution(1);
/*    */   
/*    */   private final int value;
/*    */   
/*    */   public ConstantIntegerDistribution(int paramInt) {
/* 29 */     this.value = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int nextInt() {
/* 34 */     return this.value;
/*    */   }
/*    */   
/*    */   public final int getValue() {
/* 38 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\ConstantIntegerDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */