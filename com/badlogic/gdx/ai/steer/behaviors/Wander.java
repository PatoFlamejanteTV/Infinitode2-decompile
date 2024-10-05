/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.GdxAI;
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.ai.steer.SteeringAcceleration;
/*     */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
/*     */ import com.badlogic.gdx.ai.utils.Location;
/*     */ import com.badlogic.gdx.math.MathUtils;
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
/*     */ public class Wander<T extends Vector<T>>
/*     */   extends Face<T>
/*     */ {
/*     */   protected float wanderOffset;
/*     */   protected float wanderRadius;
/*     */   protected float wanderRate;
/*     */   protected float lastTime;
/*     */   protected float wanderOrientation;
/*     */   protected boolean faceEnabled;
/*     */   private T internalTargetPosition;
/*     */   private T wanderCenter;
/*     */   
/*     */   public Wander(Steerable<T> paramSteerable) {
/*  91 */     super(paramSteerable);
/*     */     
/*  93 */     this.internalTargetPosition = (T)newVector((Location)paramSteerable);
/*  94 */     this.wanderCenter = (T)newVector((Location)paramSteerable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/* 100 */     float f1 = GdxAI.getTimepiece().getTime();
/* 101 */     if (this.lastTime > 0.0F) {
/* 102 */       float f = f1 - this.lastTime;
/* 103 */       this.wanderOrientation += MathUtils.randomTriangular(this.wanderRate * f);
/*     */     } 
/* 105 */     this.lastTime = f1;
/*     */ 
/*     */     
/* 108 */     float f2 = this.wanderOrientation + this.owner.getOrientation();
/*     */ 
/*     */     
/* 111 */     this.wanderCenter.set(this.owner.getPosition()).mulAdd(this.owner.angleToVector(paramSteeringAcceleration.linear, this.owner.getOrientation()), this.wanderOffset);
/*     */ 
/*     */ 
/*     */     
/* 115 */     this.internalTargetPosition.set((Vector)this.wanderCenter).mulAdd(this.owner.angleToVector(paramSteeringAcceleration.linear, f2), this.wanderRadius);
/*     */     
/* 117 */     f1 = getActualLimiter().getMaxLinearAcceleration();
/*     */     
/* 119 */     if (this.faceEnabled) {
/*     */       
/* 121 */       face(paramSteeringAcceleration, this.internalTargetPosition);
/*     */ 
/*     */ 
/*     */       
/* 125 */       this.owner.angleToVector(paramSteeringAcceleration.linear, this.owner.getOrientation()).scl(f1);
/*     */     } else {
/*     */       
/* 128 */       paramSteeringAcceleration.linear.set((Vector)this.internalTargetPosition).sub(this.owner.getPosition()).nor().scl(f1);
/*     */ 
/*     */       
/* 131 */       paramSteeringAcceleration.angular = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 135 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWanderOffset() {
/* 140 */     return this.wanderOffset;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Wander<T> setWanderOffset(float paramFloat) {
/* 146 */     this.wanderOffset = paramFloat;
/* 147 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWanderRadius() {
/* 152 */     return this.wanderRadius;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Wander<T> setWanderRadius(float paramFloat) {
/* 158 */     this.wanderRadius = paramFloat;
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWanderRate() {
/* 164 */     return this.wanderRate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Wander<T> setWanderRate(float paramFloat) {
/* 170 */     this.wanderRate = paramFloat;
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWanderOrientation() {
/* 176 */     return this.wanderOrientation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Wander<T> setWanderOrientation(float paramFloat) {
/* 182 */     this.wanderOrientation = paramFloat;
/* 183 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFaceEnabled() {
/* 188 */     return this.faceEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Wander<T> setFaceEnabled(boolean paramBoolean) {
/* 195 */     this.faceEnabled = paramBoolean;
/* 196 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getInternalTargetPosition() {
/* 201 */     return this.internalTargetPosition;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getWanderCenter() {
/* 206 */     return this.wanderCenter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Wander<T> setOwner(Steerable<T> paramSteerable) {
/* 215 */     this.owner = paramSteerable;
/* 216 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Wander<T> setEnabled(boolean paramBoolean) {
/* 221 */     this.enabled = paramBoolean;
/* 222 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Wander<T> setLimiter(Limiter paramLimiter) {
/* 230 */     this.limiter = paramLimiter;
/* 231 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Wander<T> setTarget(Location<T> paramLocation) {
/* 239 */     this.target = paramLocation;
/* 240 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Wander<T> setAlignTolerance(float paramFloat) {
/* 245 */     this.alignTolerance = paramFloat;
/* 246 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Wander<T> setDecelerationRadius(float paramFloat) {
/* 251 */     this.decelerationRadius = paramFloat;
/* 252 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Wander<T> setTimeToTarget(float paramFloat) {
/* 257 */     this.timeToTarget = paramFloat;
/* 258 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Wander.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */