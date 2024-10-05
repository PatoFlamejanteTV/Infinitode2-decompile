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
/*    */ public class AngularLimiter
/*    */   extends NullLimiter
/*    */ {
/*    */   private float maxAngularAcceleration;
/*    */   private float maxAngularSpeed;
/*    */   
/*    */   public AngularLimiter(float paramFloat1, float paramFloat2) {
/* 32 */     this.maxAngularAcceleration = paramFloat1;
/* 33 */     this.maxAngularSpeed = paramFloat2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getMaxAngularSpeed() {
/* 39 */     return this.maxAngularSpeed;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMaxAngularSpeed(float paramFloat) {
/* 45 */     this.maxAngularSpeed = paramFloat;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getMaxAngularAcceleration() {
/* 51 */     return this.maxAngularAcceleration;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMaxAngularAcceleration(float paramFloat) {
/* 57 */     this.maxAngularAcceleration = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\limiters\AngularLimiter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */