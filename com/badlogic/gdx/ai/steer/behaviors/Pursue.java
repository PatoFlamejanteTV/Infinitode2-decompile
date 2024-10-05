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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Pursue<T extends Vector<T>>
/*     */   extends SteeringBehavior<T>
/*     */ {
/*     */   protected Steerable<T> target;
/*     */   protected float maxPredictionTime;
/*     */   
/*     */   public Pursue(Steerable<T> paramSteerable1, Steerable<T> paramSteerable2) {
/*  54 */     this(paramSteerable1, paramSteerable2, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pursue(Steerable<T> paramSteerable1, Steerable<T> paramSteerable2, float paramFloat) {
/*  63 */     super(paramSteerable1);
/*  64 */     this.target = paramSteerable2;
/*  65 */     this.maxPredictionTime = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float getActualMaxLinearAcceleration() {
/*  71 */     return getActualLimiter().getMaxLinearAcceleration();
/*     */   }
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  76 */     Vector vector = this.target.getPosition();
/*     */ 
/*     */     
/*  79 */     float f1 = paramSteeringAcceleration.linear.set(vector).sub(this.owner.getPosition()).len2();
/*     */ 
/*     */     
/*  82 */     float f2 = this.owner.getLinearVelocity().len2();
/*     */     
/*  84 */     float f3 = this.maxPredictionTime;
/*     */     
/*  86 */     if (f2 > 0.0F)
/*     */     {
/*     */       
/*  89 */       if ((f1 = f1 / f2) < this.maxPredictionTime * this.maxPredictionTime) {
/*  90 */         f3 = (float)Math.sqrt(f1);
/*     */       }
/*     */     }
/*     */     
/*  94 */     paramSteeringAcceleration.linear.set(vector).mulAdd(this.target.getLinearVelocity(), f3).sub(this.owner.getPosition()).nor()
/*  95 */       .scl(getActualMaxLinearAcceleration());
/*     */ 
/*     */     
/*  98 */     paramSteeringAcceleration.angular = 0.0F;
/*     */ 
/*     */     
/* 101 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */   
/*     */   public Steerable<T> getTarget() {
/* 106 */     return this.target;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Pursue<T> setTarget(Steerable<T> paramSteerable) {
/* 112 */     this.target = paramSteerable;
/* 113 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMaxPredictionTime() {
/* 118 */     return this.maxPredictionTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Pursue<T> setMaxPredictionTime(float paramFloat) {
/* 124 */     this.maxPredictionTime = paramFloat;
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pursue<T> setOwner(Steerable<T> paramSteerable) {
/* 134 */     this.owner = paramSteerable;
/* 135 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Pursue<T> setEnabled(boolean paramBoolean) {
/* 140 */     this.enabled = paramBoolean;
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pursue<T> setLimiter(Limiter paramLimiter) {
/* 148 */     this.limiter = paramLimiter;
/* 149 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Pursue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */