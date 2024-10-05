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
/*    */ public final class TriangularFloatDistribution
/*    */   extends FloatDistribution
/*    */ {
/*    */   private final float low;
/*    */   private final float high;
/*    */   private final float mode;
/*    */   
/*    */   public TriangularFloatDistribution(float paramFloat) {
/* 29 */     this(-paramFloat, paramFloat);
/*    */   }
/*    */   
/*    */   public TriangularFloatDistribution(float paramFloat1, float paramFloat2) {
/* 33 */     this(paramFloat1, paramFloat2, (paramFloat1 + paramFloat2) * 0.5F);
/*    */   }
/*    */   
/*    */   public TriangularFloatDistribution(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 37 */     this.low = paramFloat1;
/* 38 */     this.high = paramFloat2;
/* 39 */     this.mode = paramFloat3;
/*    */   }
/*    */ 
/*    */   
/*    */   public final float nextFloat() {
/* 44 */     if (-this.low == this.high && this.mode == 0.0F) return MathUtils.randomTriangular(this.high); 
/* 45 */     return MathUtils.randomTriangular(this.low, this.high, this.mode);
/*    */   }
/*    */   
/*    */   public final float getLow() {
/* 49 */     return this.low;
/*    */   }
/*    */   
/*    */   public final float getHigh() {
/* 53 */     return this.high;
/*    */   }
/*    */   
/*    */   public final float getMode() {
/* 57 */     return this.mode;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\TriangularFloatDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */