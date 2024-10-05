/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.ai.steer.SteeringAcceleration;
/*     */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
/*     */ import com.badlogic.gdx.ai.steer.utils.Path;
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
/*     */ public class FollowPath<T extends Vector<T>, P extends Path.PathParam>
/*     */   extends Arrive<T>
/*     */ {
/*     */   protected Path<T, P> path;
/*     */   protected float pathOffset;
/*     */   protected P pathParam;
/*     */   protected boolean arriveEnabled;
/*     */   protected float predictionTime;
/*     */   private T internalTargetPosition;
/*     */   
/*     */   public FollowPath(Steerable<T> paramSteerable, Path<T, P> paramPath) {
/*  66 */     this(paramSteerable, paramPath, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowPath(Steerable<T> paramSteerable, Path<T, P> paramPath, float paramFloat) {
/*  75 */     this(paramSteerable, paramPath, paramFloat, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowPath(Steerable<T> paramSteerable, Path<T, P> paramPath, float paramFloat1, float paramFloat2) {
/*  86 */     super(paramSteerable);
/*  87 */     this.path = paramPath;
/*  88 */     this.pathParam = (P)paramPath.createParam();
/*  89 */     this.pathOffset = paramFloat1;
/*  90 */     this.predictionTime = paramFloat2;
/*     */     
/*  92 */     this.arriveEnabled = true;
/*     */     
/*  94 */     this.internalTargetPosition = (T)newVector((Location)paramSteerable);
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
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/* 106 */     Vector vector = (this.predictionTime == 0.0F) ? this.owner.getPosition() : paramSteeringAcceleration.linear.set(this.owner.getPosition()).mulAdd(this.owner.getLinearVelocity(), this.predictionTime);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     float f = (f = this.path.calculateDistance(vector, (Path.PathParam)this.pathParam)) + this.pathOffset;
/*     */ 
/*     */     
/* 115 */     this.path.calculateTargetPosition((Vector)this.internalTargetPosition, (Path.PathParam)this.pathParam, f);
/*     */     
/* 117 */     if (this.arriveEnabled && this.path.isOpen()) {
/* 118 */       if (this.pathOffset >= 0.0F)
/*     */       
/* 120 */       { if (f > this.path.getLength() - this.decelerationRadius) return arrive(paramSteeringAcceleration, this.internalTargetPosition);
/*     */          }
/*     */       
/* 123 */       else if (f < this.decelerationRadius) { return arrive(paramSteeringAcceleration, this.internalTargetPosition); }
/*     */     
/*     */     }
/*     */ 
/*     */     
/* 128 */     paramSteeringAcceleration.linear.set((Vector)this.internalTargetPosition).sub(this.owner.getPosition()).nor()
/* 129 */       .scl(getActualLimiter().getMaxLinearAcceleration());
/*     */ 
/*     */     
/* 132 */     paramSteeringAcceleration.angular = 0.0F;
/*     */ 
/*     */     
/* 135 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */   
/*     */   public Path<T, P> getPath() {
/* 140 */     return this.path;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setPath(Path<T, P> paramPath) {
/* 147 */     this.path = paramPath;
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPathOffset() {
/* 153 */     return this.pathOffset;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isArriveEnabled() {
/* 158 */     return this.arriveEnabled;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPredictionTime() {
/* 163 */     return this.predictionTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setPredictionTime(float paramFloat) {
/* 170 */     this.predictionTime = paramFloat;
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setArriveEnabled(boolean paramBoolean) {
/* 179 */     this.arriveEnabled = paramBoolean;
/* 180 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setPathOffset(float paramFloat) {
/* 187 */     this.pathOffset = paramFloat;
/* 188 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public P getPathParam() {
/* 193 */     return this.pathParam;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getInternalTargetPosition() {
/* 198 */     return this.internalTargetPosition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setOwner(Steerable<T> paramSteerable) {
/* 207 */     this.owner = paramSteerable;
/* 208 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setEnabled(boolean paramBoolean) {
/* 213 */     this.enabled = paramBoolean;
/* 214 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setLimiter(Limiter paramLimiter) {
/* 222 */     this.limiter = paramLimiter;
/* 223 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setTarget(Location<T> paramLocation) {
/* 228 */     this.target = paramLocation;
/* 229 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setArrivalTolerance(float paramFloat) {
/* 234 */     this.arrivalTolerance = paramFloat;
/* 235 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setDecelerationRadius(float paramFloat) {
/* 240 */     this.decelerationRadius = paramFloat;
/* 241 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FollowPath<T, P> setTimeToTarget(float paramFloat) {
/* 246 */     this.timeToTarget = paramFloat;
/* 247 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\FollowPath.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */