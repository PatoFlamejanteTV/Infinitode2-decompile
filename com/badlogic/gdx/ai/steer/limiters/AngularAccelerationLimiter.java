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
/*    */ public class AngularAccelerationLimiter
/*    */   extends NullLimiter
/*    */ {
/*    */   private float maxAngularAcceleration;
/*    */   
/*    */   public AngularAccelerationLimiter(float paramFloat) {
/* 30 */     this.maxAngularAcceleration = paramFloat;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getMaxAngularAcceleration() {
/* 36 */     return this.maxAngularAcceleration;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMaxAngularAcceleration(float paramFloat) {
/* 42 */     this.maxAngularAcceleration = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\limiters\AngularAccelerationLimiter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */