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
/*    */ public final class UniformFloatDistribution
/*    */   extends FloatDistribution
/*    */ {
/*    */   private final float low;
/*    */   private final float high;
/*    */   
/*    */   public UniformFloatDistribution(float paramFloat) {
/* 28 */     this(0.0F, paramFloat);
/*    */   }
/*    */   
/*    */   public UniformFloatDistribution(float paramFloat1, float paramFloat2) {
/* 32 */     this.low = paramFloat1;
/* 33 */     this.high = paramFloat2;
/*    */   }
/*    */   
/*    */   public final float nextFloat() {
/* 37 */     return MathUtils.random(this.low, this.high);
/*    */   }
/*    */   
/*    */   public final float getLow() {
/* 41 */     return this.low;
/*    */   }
/*    */   
/*    */   public final float getHigh() {
/* 45 */     return this.high;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\UniformFloatDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */