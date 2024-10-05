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
/*    */ public final class UniformDoubleDistribution
/*    */   extends DoubleDistribution
/*    */ {
/*    */   private final double low;
/*    */   private final double high;
/*    */   
/*    */   public UniformDoubleDistribution(double paramDouble) {
/* 28 */     this(0.0D, paramDouble);
/*    */   }
/*    */   
/*    */   public UniformDoubleDistribution(double paramDouble1, double paramDouble2) {
/* 32 */     this.low = paramDouble1;
/* 33 */     this.high = paramDouble2;
/*    */   }
/*    */   
/*    */   public final double nextDouble() {
/* 37 */     return this.low + MathUtils.random.nextDouble() * (this.high - this.low);
/*    */   }
/*    */   
/*    */   public final double getLow() {
/* 41 */     return this.low;
/*    */   }
/*    */   
/*    */   public final double getHigh() {
/* 45 */     return this.high;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\UniformDoubleDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */