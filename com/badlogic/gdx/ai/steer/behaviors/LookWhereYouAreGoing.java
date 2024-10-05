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
/*     */ public class LookWhereYouAreGoing<T extends Vector<T>>
/*     */   extends ReachOrientation<T>
/*     */ {
/*     */   public LookWhereYouAreGoing(Steerable<T> paramSteerable) {
/*  46 */     super(paramSteerable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  52 */     if (this.owner.getLinearVelocity().isZero(getActualLimiter().getZeroLinearSpeedThreshold())) return paramSteeringAcceleration.setZero();
/*     */ 
/*     */     
/*  55 */     float f = this.owner.vectorToAngle(this.owner.getLinearVelocity());
/*     */ 
/*     */     
/*  58 */     return reachOrientation(paramSteeringAcceleration, f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LookWhereYouAreGoing<T> setOwner(Steerable<T> paramSteerable) {
/*  67 */     this.owner = paramSteerable;
/*  68 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public LookWhereYouAreGoing<T> setEnabled(boolean paramBoolean) {
/*  73 */     this.enabled = paramBoolean;
/*  74 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LookWhereYouAreGoing<T> setLimiter(Limiter paramLimiter) {
/*  82 */     this.limiter = paramLimiter;
/*  83 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LookWhereYouAreGoing<T> setTarget(Location<T> paramLocation) {
/*  91 */     this.target = paramLocation;
/*  92 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public LookWhereYouAreGoing<T> setAlignTolerance(float paramFloat) {
/*  97 */     this.alignTolerance = paramFloat;
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public LookWhereYouAreGoing<T> setDecelerationRadius(float paramFloat) {
/* 103 */     this.decelerationRadius = paramFloat;
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public LookWhereYouAreGoing<T> setTimeToTarget(float paramFloat) {
/* 109 */     this.timeToTarget = paramFloat;
/* 110 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\LookWhereYouAreGoing.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */