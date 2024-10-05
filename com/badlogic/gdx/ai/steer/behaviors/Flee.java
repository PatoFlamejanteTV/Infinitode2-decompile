/*    */ package com.badlogic.gdx.ai.steer.behaviors;
/*    */ 
/*    */ import com.badlogic.gdx.ai.steer.Limiter;
/*    */ import com.badlogic.gdx.ai.steer.Steerable;
/*    */ import com.badlogic.gdx.ai.steer.SteeringAcceleration;
/*    */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
/*    */ import com.badlogic.gdx.ai.utils.Location;
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
/*    */ public class Flee<T extends Vector<T>>
/*    */   extends Seek<T>
/*    */ {
/*    */   public Flee(Steerable<T> paramSteerable) {
/* 36 */     this(paramSteerable, (Location<T>)null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Flee(Steerable<T> paramSteerable, Location<T> paramLocation) {
/* 43 */     super(paramSteerable, paramLocation);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/* 50 */     paramSteeringAcceleration.linear.set(this.owner.getPosition()).sub(this.target.getPosition()).nor().scl(getActualLimiter().getMaxLinearAcceleration());
/*    */ 
/*    */     
/* 53 */     paramSteeringAcceleration.angular = 0.0F;
/*    */ 
/*    */     
/* 56 */     return paramSteeringAcceleration;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Flee<T> setOwner(Steerable<T> paramSteerable) {
/* 65 */     this.owner = paramSteerable;
/* 66 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Flee<T> setEnabled(boolean paramBoolean) {
/* 71 */     this.enabled = paramBoolean;
/* 72 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Flee<T> setLimiter(Limiter paramLimiter) {
/* 79 */     this.limiter = paramLimiter;
/* 80 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Flee<T> setTarget(Location<T> paramLocation) {
/* 85 */     this.target = paramLocation;
/* 86 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Flee.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */