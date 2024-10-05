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
/*    */ 
/*    */ 
/*    */ public class Seek<T extends Vector<T>>
/*    */   extends SteeringBehavior<T>
/*    */ {
/*    */   protected Location<T> target;
/*    */   
/*    */   public Seek(Steerable<T> paramSteerable) {
/* 40 */     this(paramSteerable, (Location<T>)null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Seek(Steerable<T> paramSteerable, Location<T> paramLocation) {
/* 47 */     super(paramSteerable);
/* 48 */     this.target = paramLocation;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/* 55 */     paramSteeringAcceleration.linear.set(this.target.getPosition()).sub(this.owner.getPosition()).nor().scl(getActualLimiter().getMaxLinearAcceleration());
/*    */ 
/*    */     
/* 58 */     paramSteeringAcceleration.angular = 0.0F;
/*    */ 
/*    */     
/* 61 */     return paramSteeringAcceleration;
/*    */   }
/*    */ 
/*    */   
/*    */   public Location<T> getTarget() {
/* 66 */     return this.target;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Seek<T> setTarget(Location<T> paramLocation) {
/* 72 */     this.target = paramLocation;
/* 73 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Seek<T> setOwner(Steerable<T> paramSteerable) {
/* 82 */     this.owner = paramSteerable;
/* 83 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Seek<T> setEnabled(boolean paramBoolean) {
/* 88 */     this.enabled = paramBoolean;
/* 89 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Seek<T> setLimiter(Limiter paramLimiter) {
/* 96 */     this.limiter = paramLimiter;
/* 97 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Seek.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */