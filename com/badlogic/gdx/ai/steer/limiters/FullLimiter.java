/*    */ package com.badlogic.gdx.ai.steer.limiters;
/*    */ 
/*    */ import com.badlogic.gdx.ai.steer.Limiter;
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
/*    */ 
/*    */ public class FullLimiter
/*    */   implements Limiter
/*    */ {
/*    */   private float maxLinearAcceleration;
/*    */   private float maxLinearSpeed;
/*    */   private float maxAngularAcceleration;
/*    */   private float maxAngularSpeed;
/*    */   private float zeroLinearSpeedThreshold;
/*    */   
/*    */   public FullLimiter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 38 */     this.maxLinearAcceleration = paramFloat1;
/* 39 */     this.maxLinearSpeed = paramFloat2;
/* 40 */     this.maxAngularAcceleration = paramFloat3;
/* 41 */     this.maxAngularSpeed = paramFloat4;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getMaxLinearSpeed() {
/* 46 */     return this.maxLinearSpeed;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setMaxLinearSpeed(float paramFloat) {
/* 51 */     this.maxLinearSpeed = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getMaxLinearAcceleration() {
/* 56 */     return this.maxLinearAcceleration;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setMaxLinearAcceleration(float paramFloat) {
/* 61 */     this.maxLinearAcceleration = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getMaxAngularSpeed() {
/* 66 */     return this.maxAngularSpeed;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setMaxAngularSpeed(float paramFloat) {
/* 71 */     this.maxAngularSpeed = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getMaxAngularAcceleration() {
/* 76 */     return this.maxAngularAcceleration;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setMaxAngularAcceleration(float paramFloat) {
/* 81 */     this.maxAngularAcceleration = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getZeroLinearSpeedThreshold() {
/* 86 */     return this.zeroLinearSpeedThreshold;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setZeroLinearSpeedThreshold(float paramFloat) {
/* 91 */     this.zeroLinearSpeedThreshold = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\limiters\FullLimiter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */