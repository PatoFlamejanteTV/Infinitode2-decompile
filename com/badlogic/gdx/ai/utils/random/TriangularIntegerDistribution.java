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
/*    */ public final class TriangularIntegerDistribution
/*    */   extends IntegerDistribution
/*    */ {
/*    */   private final int low;
/*    */   private final int high;
/*    */   private final float mode;
/*    */   
/*    */   public TriangularIntegerDistribution(int paramInt) {
/* 29 */     this(-paramInt, paramInt);
/*    */   }
/*    */   
/*    */   public TriangularIntegerDistribution(int paramInt1, int paramInt2) {
/* 33 */     this(paramInt1, paramInt2, (paramInt1 + paramInt2) * 0.5F);
/*    */   }
/*    */   
/*    */   public TriangularIntegerDistribution(int paramInt1, int paramInt2, float paramFloat) {
/* 37 */     this.low = paramInt1;
/* 38 */     this.high = paramInt2;
/* 39 */     this.mode = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public final int nextInt() {
/*    */     float f;
/* 45 */     if (-this.low == this.high && this.mode == 0.0F) {
/* 46 */       f = MathUtils.randomTriangular(this.high);
/*    */     } else {
/* 48 */       f = MathUtils.randomTriangular(this.low, this.high, this.mode);
/* 49 */     }  return Math.round(f);
/*    */   }
/*    */   
/*    */   public final int getLow() {
/* 53 */     return this.low;
/*    */   }
/*    */   
/*    */   public final int getHigh() {
/* 57 */     return this.high;
/*    */   }
/*    */   
/*    */   public final float getMode() {
/* 61 */     return this.mode;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\TriangularIntegerDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */