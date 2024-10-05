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
/*     */ public class Face<T extends Vector<T>>
/*     */   extends ReachOrientation<T>
/*     */ {
/*     */   public Face(Steerable<T> paramSteerable) {
/*  36 */     this(paramSteerable, (Location<T>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Face(Steerable<T> paramSteerable, Location<T> paramLocation) {
/*  43 */     super(paramSteerable, paramLocation);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  48 */     return face(paramSteeringAcceleration, (T)this.target.getPosition());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> face(SteeringAcceleration<T> paramSteeringAcceleration, T paramT) {
/*     */     Vector vector;
/*  56 */     if ((vector = paramSteeringAcceleration.linear.set((Vector)paramT).sub(this.owner.getPosition())).isZero(getActualLimiter().getZeroLinearSpeedThreshold())) return paramSteeringAcceleration.setZero();
/*     */ 
/*     */     
/*  59 */     float f = this.owner.vectorToAngle(vector);
/*     */ 
/*     */     
/*  62 */     return reachOrientation(paramSteeringAcceleration, f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Face<T> setOwner(Steerable<T> paramSteerable) {
/*  71 */     this.owner = paramSteerable;
/*  72 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Face<T> setEnabled(boolean paramBoolean) {
/*  77 */     this.enabled = paramBoolean;
/*  78 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Face<T> setLimiter(Limiter paramLimiter) {
/*  86 */     this.limiter = paramLimiter;
/*  87 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Face<T> setTarget(Location<T> paramLocation) {
/*  92 */     this.target = paramLocation;
/*  93 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Face<T> setAlignTolerance(float paramFloat) {
/*  98 */     this.alignTolerance = paramFloat;
/*  99 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Face<T> setDecelerationRadius(float paramFloat) {
/* 104 */     this.decelerationRadius = paramFloat;
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Face<T> setTimeToTarget(float paramFloat) {
/* 110 */     this.timeToTarget = paramFloat;
/* 111 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Face.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */