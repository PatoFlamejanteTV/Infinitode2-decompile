/*    */ package com.badlogic.gdx.ai.steer.limiters;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LinearAccelerationLimiter
/*    */   extends NullLimiter
/*    */ {
/*    */   private float maxLinearAcceleration;
/*    */   
/*    */   public LinearAccelerationLimiter(float paramFloat) {
/* 30 */     this.maxLinearAcceleration = paramFloat;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getMaxLinearAcceleration() {
/* 36 */     return this.maxLinearAcceleration;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMaxLinearAcceleration(float paramFloat) {
/* 42 */     this.maxLinearAcceleration = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\limiters\LinearAccelerationLimiter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */