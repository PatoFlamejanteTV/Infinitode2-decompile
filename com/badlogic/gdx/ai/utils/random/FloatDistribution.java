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
/*    */ public abstract class FloatDistribution
/*    */   implements Distribution
/*    */ {
/*    */   public int nextInt() {
/* 24 */     return (int)nextFloat();
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextLong() {
/* 29 */     return (long)nextFloat();
/*    */   }
/*    */ 
/*    */   
/*    */   public double nextDouble() {
/* 34 */     return nextFloat();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\FloatDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */