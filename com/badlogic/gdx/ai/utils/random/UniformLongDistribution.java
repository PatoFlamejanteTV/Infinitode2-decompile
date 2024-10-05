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
/*    */ public final class UniformLongDistribution
/*    */   extends LongDistribution
/*    */ {
/*    */   private final long low;
/*    */   private final long high;
/*    */   
/*    */   public UniformLongDistribution(long paramLong) {
/* 28 */     this(0L, paramLong);
/*    */   }
/*    */   
/*    */   public UniformLongDistribution(long paramLong1, long paramLong2) {
/* 32 */     this.low = paramLong1;
/* 33 */     this.high = paramLong2;
/*    */   }
/*    */ 
/*    */   
/*    */   public final long nextLong() {
/* 38 */     return this.low + (long)(MathUtils.random.nextDouble() * (this.high - this.low));
/*    */   }
/*    */   
/*    */   public final long getLow() {
/* 42 */     return this.low;
/*    */   }
/*    */   
/*    */   public final long getHigh() {
/* 46 */     return this.high;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\UniformLongDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */