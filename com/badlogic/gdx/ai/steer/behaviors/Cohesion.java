/*    */ package com.badlogic.gdx.ai.steer.behaviors;
/*    */ 
/*    */ import com.badlogic.gdx.ai.steer.GroupBehavior;
/*    */ import com.badlogic.gdx.ai.steer.Limiter;
/*    */ import com.badlogic.gdx.ai.steer.Proximity;
/*    */ import com.badlogic.gdx.ai.steer.Steerable;
/*    */ import com.badlogic.gdx.ai.steer.SteeringAcceleration;
/*    */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
/*    */ import com.badlogic.gdx.math.Vector;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cohesion<T extends Vector<T>>
/*    */   extends GroupBehavior<T>
/*    */   implements Proximity.ProximityCallback<T>
/*    */ {
/*    */   private T centerOfMass;
/*    */   
/*    */   public Cohesion(Steerable<T> paramSteerable, Proximity<T> paramProximity) {
/* 45 */     super(paramSteerable, paramProximity);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/* 51 */     paramSteeringAcceleration.setZero();
/*    */     
/* 53 */     this.centerOfMass = (T)paramSteeringAcceleration.linear;
/*    */     
/*    */     int i;
/*    */     
/* 57 */     if ((i = this.proximity.findNeighbors(this)) > 0) {
/*    */ 
/*    */       
/* 60 */       this.centerOfMass.scl(1.0F / i);
/*    */ 
/*    */       
/* 63 */       this.centerOfMass.sub(this.owner.getPosition()).nor().scl(getActualLimiter().getMaxLinearAcceleration());
/*    */     } 
/*    */     
/* 66 */     return paramSteeringAcceleration;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean reportNeighbor(Steerable<T> paramSteerable) {
/* 72 */     this.centerOfMass.add(paramSteerable.getPosition());
/* 73 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Cohesion<T> setOwner(Steerable<T> paramSteerable) {
/* 82 */     this.owner = paramSteerable;
/* 83 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Cohesion<T> setEnabled(boolean paramBoolean) {
/* 88 */     this.enabled = paramBoolean;
/* 89 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Cohesion<T> setLimiter(Limiter paramLimiter) {
/* 96 */     this.limiter = paramLimiter;
/* 97 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Cohesion.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */