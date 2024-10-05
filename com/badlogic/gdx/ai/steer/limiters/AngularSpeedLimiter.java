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
/*    */ public class AngularSpeedLimiter
/*    */   extends NullLimiter
/*    */ {
/*    */   private float maxAngularSpeed;
/*    */   
/*    */   public AngularSpeedLimiter(float paramFloat) {
/* 30 */     this.maxAngularSpeed = paramFloat;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getMaxAngularSpeed() {
/* 36 */     return this.maxAngularSpeed;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMaxAngularSpeed(float paramFloat) {
/* 42 */     this.maxAngularSpeed = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\limiters\AngularSpeedLimiter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */