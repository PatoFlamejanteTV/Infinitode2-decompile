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
/*    */ public final class UniformIntegerDistribution
/*    */   extends IntegerDistribution
/*    */ {
/*    */   private final int low;
/*    */   private final int high;
/*    */   
/*    */   public UniformIntegerDistribution(int paramInt) {
/* 28 */     this(0, paramInt);
/*    */   }
/*    */   
/*    */   public UniformIntegerDistribution(int paramInt1, int paramInt2) {
/* 32 */     this.low = paramInt1;
/* 33 */     this.high = paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int nextInt() {
/* 38 */     return MathUtils.random(this.low, this.high);
/*    */   }
/*    */   
/*    */   public final int getLow() {
/* 42 */     return this.low;
/*    */   }
/*    */   
/*    */   public final int getHigh() {
/* 46 */     return this.high;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\UniformIntegerDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */