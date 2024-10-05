/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.ai.steer.SteeringAcceleration;
/*     */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
/*     */ import com.badlogic.gdx.ai.utils.Location;
/*     */ import com.badlogic.gdx.math.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Arrive<T extends Vector<T>>
/*     */   extends SteeringBehavior<T>
/*     */ {
/*     */   protected Location<T> target;
/*     */   protected float arrivalTolerance;
/*     */   protected float decelerationRadius;
/*  57 */   protected float timeToTarget = 0.1F;
/*     */ 
/*     */ 
/*     */   
/*     */   public Arrive(Steerable<T> paramSteerable) {
/*  62 */     this(paramSteerable, (Location<T>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Arrive(Steerable<T> paramSteerable, Location<T> paramLocation) {
/*  69 */     super(paramSteerable);
/*  70 */     this.target = paramLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  75 */     return arrive(paramSteeringAcceleration, (T)this.target.getPosition());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> arrive(SteeringAcceleration<T> paramSteeringAcceleration, T paramT) {
/*     */     Vector vector;
/*     */     float f1;
/*  84 */     if ((f1 = (vector = paramSteeringAcceleration.linear.set((Vector)paramT).sub(this.owner.getPosition())).len()) <= this.arrivalTolerance) return paramSteeringAcceleration.setZero();
/*     */ 
/*     */     
/*     */     Limiter limiter;
/*  88 */     float f2 = (limiter = getActualLimiter()).getMaxLinearSpeed();
/*     */ 
/*     */     
/*  91 */     if (f1 <= this.decelerationRadius) f2 *= f1 / this.decelerationRadius;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     (vector = vector.scl(f2 / f1)).sub(this.owner.getLinearVelocity()).scl(1.0F / this.timeToTarget).limit(limiter.getMaxLinearAcceleration());
/*     */ 
/*     */     
/* 101 */     paramSteeringAcceleration.angular = 0.0F;
/*     */ 
/*     */     
/* 104 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */   
/*     */   public Location<T> getTarget() {
/* 109 */     return this.target;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Arrive<T> setTarget(Location<T> paramLocation) {
/* 115 */     this.target = paramLocation;
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getArrivalTolerance() {
/* 122 */     return this.arrivalTolerance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Arrive<T> setArrivalTolerance(float paramFloat) {
/* 129 */     this.arrivalTolerance = paramFloat;
/* 130 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDecelerationRadius() {
/* 135 */     return this.decelerationRadius;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Arrive<T> setDecelerationRadius(float paramFloat) {
/* 141 */     this.decelerationRadius = paramFloat;
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTimeToTarget() {
/* 147 */     return this.timeToTarget;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Arrive<T> setTimeToTarget(float paramFloat) {
/* 153 */     this.timeToTarget = paramFloat;
/* 154 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Arrive<T> setOwner(Steerable<T> paramSteerable) {
/* 163 */     this.owner = paramSteerable;
/* 164 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Arrive<T> setEnabled(boolean paramBoolean) {
/* 169 */     this.enabled = paramBoolean;
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Arrive<T> setLimiter(Limiter paramLimiter) {
/* 178 */     this.limiter = paramLimiter;
/* 179 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Arrive.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */