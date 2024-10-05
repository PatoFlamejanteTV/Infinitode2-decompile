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
/*    */ public abstract class LongDistribution
/*    */   implements Distribution
/*    */ {
/*    */   public int nextInt() {
/* 24 */     return (int)nextLong();
/*    */   }
/*    */ 
/*    */   
/*    */   public float nextFloat() {
/* 29 */     return (float)nextLong();
/*    */   }
/*    */ 
/*    */   
/*    */   public double nextDouble() {
/* 34 */     return nextLong();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\a\\utils\random\LongDistribution.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */