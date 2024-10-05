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
/*    */ public abstract class DoubleDistribution
/*    */   implements Distribution
/*    */ {
/*    */   public int nextInt() {
/* 24 */     return (int)nextDouble();
/*    */   }
/*    */ 
/*    */   
/*    */   public long nextLong() {
/* 29 */     return (long)nextDouble();
/*    */   }
/*    */ 
/*    */   
/*    */   public float nextFloat() {
/* 34 */     return (float)nextDouble();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\DoubleDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */