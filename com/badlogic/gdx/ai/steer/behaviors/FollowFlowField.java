/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.ai.steer.SteeringAcceleration;
/*     */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
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
/*     */ public class FollowFlowField<T extends Vector<T>>
/*     */   extends SteeringBehavior<T>
/*     */ {
/*     */   protected FlowField<T> flowField;
/*     */   protected float predictionTime;
/*     */   
/*     */   public FollowFlowField(Steerable<T> paramSteerable) {
/*  49 */     this(paramSteerable, (FlowField<T>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowFlowField(Steerable<T> paramSteerable, FlowField<T> paramFlowField) {
/*  56 */     this(paramSteerable, paramFlowField, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowFlowField(Steerable<T> paramSteerable, FlowField<T> paramFlowField, float paramFloat) {
/*  65 */     super(paramSteerable);
/*  66 */     this.flowField = paramFlowField;
/*  67 */     this.predictionTime = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  78 */     Vector vector = (this.predictionTime == 0.0F) ? this.owner.getPosition() : paramSteeringAcceleration.linear.set(this.owner.getPosition()).mulAdd(this.owner.getLinearVelocity(), this.predictionTime);
/*     */ 
/*     */     
/*  81 */     vector = (Vector)this.flowField.lookup((T)vector);
/*     */ 
/*     */     
/*  84 */     paramSteeringAcceleration.setZero();
/*     */     
/*  86 */     if (vector != null && !vector.isZero()) {
/*  87 */       Limiter limiter = getActualLimiter();
/*     */ 
/*     */       
/*  90 */       paramSteeringAcceleration.linear.mulAdd(vector, limiter.getMaxLinearSpeed()).sub(this.owner.getLinearVelocity())
/*  91 */         .limit(limiter.getMaxLinearAcceleration());
/*     */     } 
/*     */ 
/*     */     
/*  95 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */   
/*     */   public FlowField<T> getFlowField() {
/* 100 */     return this.flowField;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowFlowField<T> setFlowField(FlowField<T> paramFlowField) {
/* 107 */     this.flowField = paramFlowField;
/* 108 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPredictionTime() {
/* 113 */     return this.predictionTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowFlowField<T> setPredictionTime(float paramFloat) {
/* 120 */     this.predictionTime = paramFloat;
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowFlowField<T> setOwner(Steerable<T> paramSteerable) {
/* 130 */     this.owner = paramSteerable;
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FollowFlowField<T> setEnabled(boolean paramBoolean) {
/* 136 */     this.enabled = paramBoolean;
/* 137 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FollowFlowField<T> setLimiter(Limiter paramLimiter) {
/* 145 */     this.limiter = paramLimiter;
/* 146 */     return this;
/*     */   }
/*     */   
/*     */   public static interface FlowField<T extends Vector<T>> {
/*     */     T lookup(T param1T);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\FollowFlowField.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */