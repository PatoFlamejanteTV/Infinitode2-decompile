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
/*    */ public final class ConstantLongDistribution
/*    */   extends LongDistribution
/*    */ {
/* 22 */   public static final ConstantLongDistribution NEGATIVE_ONE = new ConstantLongDistribution(-1L);
/* 23 */   public static final ConstantLongDistribution ZERO = new ConstantLongDistribution(0L);
/* 24 */   public static final ConstantLongDistribution ONE = new ConstantLongDistribution(1L);
/*    */   
/*    */   private final long value;
/*    */   
/*    */   public ConstantLongDistribution(long paramLong) {
/* 29 */     this.value = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   public final long nextLong() {
/* 34 */     return this.value;
/*    */   }
/*    */   
/*    */   public final long getValue() {
/* 38 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\ConstantLongDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */