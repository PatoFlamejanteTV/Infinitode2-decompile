/*     */ package com.badlogic.gdx.ai.steer;
/*     */ 
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
/*     */ public abstract class SteeringBehavior<T extends Vector<T>>
/*     */ {
/*     */   protected Steerable<T> owner;
/*     */   protected Limiter limiter;
/*     */   protected boolean enabled;
/*     */   
/*     */   public SteeringBehavior(Steerable<T> paramSteerable) {
/*  43 */     this(paramSteerable, null, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringBehavior(Steerable<T> paramSteerable, Limiter paramLimiter) {
/*  51 */     this(paramSteerable, paramLimiter, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringBehavior(Steerable<T> paramSteerable, boolean paramBoolean) {
/*  60 */     this(paramSteerable, null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringBehavior(Steerable<T> paramSteerable, Limiter paramLimiter, boolean paramBoolean) {
/*  69 */     this.owner = paramSteerable;
/*  70 */     this.limiter = paramLimiter;
/*  71 */     this.enabled = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringAcceleration<T> calculateSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  79 */     return isEnabled() ? calculateRealSteering(paramSteeringAcceleration) : paramSteeringAcceleration.setZero();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Steerable<T> getOwner() {
/*  91 */     return this.owner;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringBehavior<T> setOwner(Steerable<T> paramSteerable) {
/*  97 */     this.owner = paramSteerable;
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Limiter getLimiter() {
/* 103 */     return this.limiter;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringBehavior<T> setLimiter(Limiter paramLimiter) {
/* 109 */     this.limiter = paramLimiter;
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 115 */     return this.enabled;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringBehavior<T> setEnabled(boolean paramBoolean) {
/* 121 */     this.enabled = paramBoolean;
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Limiter getActualLimiter() {
/* 127 */     return (this.limiter == null) ? this.owner : this.limiter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected T newVector(Location<T> paramLocation) {
/* 138 */     return (T)paramLocation.getPosition().cpy().setZero();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\SteeringBehavior.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */