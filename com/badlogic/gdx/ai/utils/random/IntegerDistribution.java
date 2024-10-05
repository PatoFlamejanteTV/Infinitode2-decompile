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
/*    */ 
/*    */ public abstract class IntegerDistribution
/*    */   implements Distribution
/*    */ {
/*    */   public long nextLong() {
/* 24 */     return nextInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public float nextFloat() {
/* 29 */     return nextInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public double nextDouble() {
/* 34 */     return nextInt();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\IntegerDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */