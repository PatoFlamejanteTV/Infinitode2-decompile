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
/*     */ public class Interpose<T extends Vector<T>>
/*     */   extends Arrive<T>
/*     */ {
/*     */   protected Steerable<T> agentA;
/*     */   protected Steerable<T> agentB;
/*     */   protected float interpositionRatio;
/*     */   private T internalTargetPosition;
/*     */   
/*     */   public Interpose(Steerable<T> paramSteerable1, Steerable<T> paramSteerable2, Steerable<T> paramSteerable3) {
/*  58 */     this(paramSteerable1, paramSteerable2, paramSteerable3, 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Interpose(Steerable<T> paramSteerable1, Steerable<T> paramSteerable2, Steerable<T> paramSteerable3, float paramFloat) {
/*  68 */     super(paramSteerable1);
/*  69 */     this.agentA = paramSteerable2;
/*  70 */     this.agentB = paramSteerable3;
/*  71 */     this.interpositionRatio = paramFloat;
/*     */     
/*  73 */     this.internalTargetPosition = (T)newVector((Location)paramSteerable1);
/*     */   }
/*     */ 
/*     */   
/*     */   public Steerable<T> getAgentA() {
/*  78 */     return this.agentA;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Interpose<T> setAgentA(Steerable<T> paramSteerable) {
/*  84 */     this.agentA = paramSteerable;
/*  85 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Steerable<T> getAgentB() {
/*  90 */     return this.agentB;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Interpose<T> setAgentB(Steerable<T> paramSteerable) {
/*  96 */     this.agentB = paramSteerable;
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getInterpositionRatio() {
/* 102 */     return this.interpositionRatio;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Interpose<T> setInterpositionRatio(float paramFloat) {
/* 110 */     this.interpositionRatio = paramFloat;
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/* 121 */     this.internalTargetPosition.set(this.agentB.getPosition()).sub(this.agentA.getPosition()).scl(this.interpositionRatio)
/* 122 */       .add(this.agentA.getPosition());
/*     */     
/* 124 */     float f = this.owner.getPosition().dst((Vector)this.internalTargetPosition) / getActualLimiter().getMaxLinearSpeed();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     paramSteeringAcceleration.linear.set(this.agentA.getPosition()).mulAdd(this.agentA.getLinearVelocity(), f);
/* 131 */     this.internalTargetPosition.set(this.agentB.getPosition()).mulAdd(this.agentB.getLinearVelocity(), f);
/*     */ 
/*     */     
/* 134 */     this.internalTargetPosition.sub(paramSteeringAcceleration.linear).scl(this.interpositionRatio).add(paramSteeringAcceleration.linear);
/*     */ 
/*     */     
/* 137 */     return arrive(paramSteeringAcceleration, this.internalTargetPosition);
/*     */   }
/*     */ 
/*     */   
/*     */   public T getInternalTargetPosition() {
/* 142 */     return this.internalTargetPosition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Interpose<T> setOwner(Steerable<T> paramSteerable) {
/* 151 */     this.owner = paramSteerable;
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Interpose<T> setEnabled(boolean paramBoolean) {
/* 157 */     this.enabled = paramBoolean;
/* 158 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Interpose<T> setLimiter(Limiter paramLimiter) {
/* 163 */     this.limiter = paramLimiter;
/* 164 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Interpose<T> setTarget(Location<T> paramLocation) {
/* 169 */     this.target = paramLocation;
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Interpose<T> setArrivalTolerance(float paramFloat) {
/* 175 */     this.arrivalTolerance = paramFloat;
/* 176 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Interpose<T> setDecelerationRadius(float paramFloat) {
/* 181 */     this.decelerationRadius = paramFloat;
/* 182 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Interpose<T> setTimeToTarget(float paramFloat) {
/* 187 */     this.timeToTarget = paramFloat;
/* 188 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Interpose.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */