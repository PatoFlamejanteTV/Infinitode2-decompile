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
/*    */ public final class TriangularDoubleDistribution
/*    */   extends DoubleDistribution
/*    */ {
/*    */   private final double low;
/*    */   private final double high;
/*    */   private final double mode;
/*    */   
/*    */   public TriangularDoubleDistribution(double paramDouble) {
/* 29 */     this(-paramDouble, paramDouble);
/*    */   }
/*    */   
/*    */   public TriangularDoubleDistribution(double paramDouble1, double paramDouble2) {
/* 33 */     this(paramDouble1, paramDouble2, (paramDouble1 + paramDouble2) * 0.5D);
/*    */   }
/*    */   
/*    */   public TriangularDoubleDistribution(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 37 */     this.low = paramDouble1;
/* 38 */     this.high = paramDouble2;
/* 39 */     this.mode = paramDouble3;
/*    */   }
/*    */ 
/*    */   
/*    */   public final double nextDouble() {
/* 44 */     if (-this.low == this.high && this.mode == 0.0D) return randomTriangular(this.high); 
/* 45 */     return randomTriangular(this.low, this.high, this.mode);
/*    */   }
/*    */   
/*    */   public final double getLow() {
/* 49 */     return this.low;
/*    */   }
/*    */   
/*    */   public final double getHigh() {
/* 53 */     return this.high;
/*    */   }
/*    */   
/*    */   public final double getMode() {
/* 57 */     return this.mode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static double randomTriangular(double paramDouble) {
/* 66 */     return (MathUtils.random.nextDouble() - MathUtils.random.nextDouble()) * paramDouble;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static double randomTriangular(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 75 */     double d1 = MathUtils.random.nextDouble();
/* 76 */     double d2 = paramDouble2 - paramDouble1;
/* 77 */     if (d1 <= (paramDouble3 - paramDouble1) / d2) return paramDouble1 + Math.sqrt(d1 * d2 * (paramDouble3 - paramDouble1)); 
/* 78 */     return paramDouble2 - Math.sqrt((1.0D - d1) * d2 * (paramDouble2 - paramDouble3));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\TriangularDoubleDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */