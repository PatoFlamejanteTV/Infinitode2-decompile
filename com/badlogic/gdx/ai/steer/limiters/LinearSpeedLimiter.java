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
/*    */ public class LinearSpeedLimiter
/*    */   extends NullLimiter
/*    */ {
/*    */   private float maxLinearSpeed;
/*    */   
/*    */   public LinearSpeedLimiter(float paramFloat) {
/* 30 */     this.maxLinearSpeed = paramFloat;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getMaxLinearSpeed() {
/* 36 */     return this.maxLinearSpeed;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMaxLinearSpeed(float paramFloat) {
/* 42 */     this.maxLinearSpeed = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\limiters\LinearSpeedLimiter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */