/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
/*     */ import com.badlogic.gdx.ai.steer.Proximity;
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
/*     */ public class Hide<T extends Vector<T>>
/*     */   extends Arrive<T>
/*     */   implements Proximity.ProximityCallback<T>
/*     */ {
/*     */   protected Proximity<T> proximity;
/*     */   protected float distanceFromBoundary;
/*     */   private T toObstacle;
/*     */   private T bestHidingSpot;
/*     */   private float distance2ToClosest;
/*     */   
/*     */   public Hide(Steerable<T> paramSteerable) {
/*  75 */     this(paramSteerable, (Location<T>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Hide(Steerable<T> paramSteerable, Location<T> paramLocation) {
/*  82 */     this(paramSteerable, paramLocation, (Proximity<T>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Hide(Steerable<T> paramSteerable, Location<T> paramLocation, Proximity<T> paramProximity) {
/*  90 */     super(paramSteerable, paramLocation);
/*  91 */     this.proximity = paramProximity;
/*     */     
/*  93 */     this.bestHidingSpot = (T)newVector((Location)paramSteerable);
/*  94 */     this.toObstacle = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/* 100 */     this.distance2ToClosest = Float.POSITIVE_INFINITY;
/* 101 */     this.toObstacle = (T)paramSteeringAcceleration.linear;
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */     
/* 107 */     return ((i = this.proximity.findNeighbors(this)) == 0) ? paramSteeringAcceleration.setZero() : arrive(paramSteeringAcceleration, this.bestHidingSpot);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean reportNeighbor(Steerable<T> paramSteerable) {
/*     */     float f;
/* 118 */     if ((f = (paramSteerable = (Steerable<T>)getHidingPosition((T)paramSteerable.getPosition(), paramSteerable.getBoundingRadius(), (T)this.target.getPosition())).dst2(this.owner.getPosition())) < this.distance2ToClosest) {
/* 119 */       this.distance2ToClosest = f;
/* 120 */       this.bestHidingSpot.set((Vector)paramSteerable);
/* 121 */       return true;
/*     */     } 
/*     */     
/* 124 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Proximity<T> getProximity() {
/* 129 */     return this.proximity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Hide<T> setProximity(Proximity<T> paramProximity) {
/* 136 */     this.proximity = paramProximity;
/* 137 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDistanceFromBoundary() {
/* 142 */     return this.distanceFromBoundary;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Hide<T> setDistanceFromBoundary(float paramFloat) {
/* 149 */     this.distanceFromBoundary = paramFloat;
/* 150 */     return this;
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
/*     */   protected T getHidingPosition(T paramT1, float paramFloat, T paramT2) {
/* 164 */     paramFloat += this.distanceFromBoundary;
/*     */ 
/*     */     
/* 167 */     this.toObstacle.set((Vector)paramT1).sub((Vector)paramT2).nor();
/*     */ 
/*     */ 
/*     */     
/* 171 */     return (T)this.toObstacle.scl(paramFloat).add((Vector)paramT1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Hide<T> setOwner(Steerable<T> paramSteerable) {
/* 180 */     this.owner = paramSteerable;
/* 181 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Hide<T> setEnabled(boolean paramBoolean) {
/* 186 */     this.enabled = paramBoolean;
/* 187 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Hide<T> setLimiter(Limiter paramLimiter) {
/* 192 */     this.limiter = paramLimiter;
/* 193 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Hide<T> setTarget(Location<T> paramLocation) {
/* 198 */     this.target = paramLocation;
/* 199 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Hide<T> setArrivalTolerance(float paramFloat) {
/* 204 */     this.arrivalTolerance = paramFloat;
/* 205 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Hide<T> setDecelerationRadius(float paramFloat) {
/* 210 */     this.decelerationRadius = paramFloat;
/* 211 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Hide<T> setTimeToTarget(float paramFloat) {
/* 216 */     this.timeToTarget = paramFloat;
/* 217 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Hide.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */