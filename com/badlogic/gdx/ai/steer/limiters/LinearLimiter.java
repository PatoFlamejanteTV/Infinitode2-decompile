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
/*    */ 
/*    */ public class LinearLimiter
/*    */   extends NullLimiter
/*    */ {
/*    */   private float maxLinearAcceleration;
/*    */   private float maxLinearSpeed;
/*    */   
/*    */   public LinearLimiter(float paramFloat1, float paramFloat2) {
/* 32 */     this.maxLinearAcceleration = paramFloat1;
/* 33 */     this.maxLinearSpeed = paramFloat2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getMaxLinearSpeed() {
/* 39 */     return this.maxLinearSpeed;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMaxLinearSpeed(float paramFloat) {
/* 45 */     this.maxLinearSpeed = paramFloat;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getMaxLinearAcceleration() {
/* 51 */     return this.maxLinearAcceleration;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMaxLinearAcceleration(float paramFloat) {
/* 57 */     this.maxLinearAcceleration = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\limiters\LinearLimiter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */