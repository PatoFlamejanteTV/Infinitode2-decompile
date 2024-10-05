/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.ai.steer.SteeringAcceleration;
/*     */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
/*     */ import com.badlogic.gdx.ai.utils.ArithmeticUtils;
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
/*     */ public class ReachOrientation<T extends Vector<T>>
/*     */   extends SteeringBehavior<T>
/*     */ {
/*     */   protected Location<T> target;
/*     */   protected float alignTolerance;
/*     */   protected float decelerationRadius;
/*  52 */   protected float timeToTarget = 0.1F;
/*     */ 
/*     */ 
/*     */   
/*     */   public ReachOrientation(Steerable<T> paramSteerable) {
/*  57 */     this(paramSteerable, (Location<T>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReachOrientation(Steerable<T> paramSteerable, Location<T> paramLocation) {
/*  64 */     super(paramSteerable);
/*  65 */     this.target = paramLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  70 */     return reachOrientation(paramSteeringAcceleration, this.target.getOrientation());
/*     */   }
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
/*     */   protected SteeringAcceleration<T> reachOrientation(SteeringAcceleration<T> paramSteeringAcceleration, float paramFloat) {
/*     */     float f1;
/*  86 */     if ((f1 = ((paramFloat = ArithmeticUtils.wrapAngleAroundZero(paramFloat - this.owner.getOrientation())) < 0.0F) ? -paramFloat : paramFloat) <= this.alignTolerance) return paramSteeringAcceleration.setZero();
/*     */ 
/*     */     
/*     */     Limiter limiter;
/*     */     
/*  91 */     float f2 = (limiter = getActualLimiter()).getMaxAngularSpeed();
/*     */ 
/*     */     
/*  94 */     if (f1 <= this.decelerationRadius) f2 *= f1 / this.decelerationRadius;
/*     */ 
/*     */ 
/*     */     
/*  98 */     f2 *= paramFloat / f1;
/*     */ 
/*     */     
/* 101 */     paramSteeringAcceleration.angular = (f2 - this.owner.getAngularVelocity()) / this.timeToTarget;
/*     */ 
/*     */ 
/*     */     
/* 105 */     if ((paramFloat = (paramSteeringAcceleration.angular < 0.0F) ? -paramSteeringAcceleration.angular : paramSteeringAcceleration.angular) > limiter.getMaxAngularAcceleration()) {
/* 106 */       paramSteeringAcceleration.angular *= limiter.getMaxAngularAcceleration() / paramFloat;
/*     */     }
/*     */     
/* 109 */     paramSteeringAcceleration.linear.setZero();
/*     */ 
/*     */     
/* 112 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */   
/*     */   public Location<T> getTarget() {
/* 117 */     return this.target;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ReachOrientation<T> setTarget(Location<T> paramLocation) {
/* 123 */     this.target = paramLocation;
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getAlignTolerance() {
/* 129 */     return this.alignTolerance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ReachOrientation<T> setAlignTolerance(float paramFloat) {
/* 135 */     this.alignTolerance = paramFloat;
/* 136 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDecelerationRadius() {
/* 141 */     return this.decelerationRadius;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ReachOrientation<T> setDecelerationRadius(float paramFloat) {
/* 147 */     this.decelerationRadius = paramFloat;
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTimeToTarget() {
/* 153 */     return this.timeToTarget;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ReachOrientation<T> setTimeToTarget(float paramFloat) {
/* 159 */     this.timeToTarget = paramFloat;
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReachOrientation<T> setOwner(Steerable<T> paramSteerable) {
/* 169 */     this.owner = paramSteerable;
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ReachOrientation<T> setEnabled(boolean paramBoolean) {
/* 175 */     this.enabled = paramBoolean;
/* 176 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReachOrientation<T> setLimiter(Limiter paramLimiter) {
/* 184 */     this.limiter = paramLimiter;
/* 185 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\ReachOrientation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */