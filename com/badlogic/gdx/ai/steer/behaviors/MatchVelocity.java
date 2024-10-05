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
/*     */ public class MatchVelocity<T extends Vector<T>>
/*     */   extends SteeringBehavior<T>
/*     */ {
/*     */   protected Steerable<T> target;
/*     */   protected float timeToTarget;
/*     */   
/*     */   public MatchVelocity(Steerable<T> paramSteerable) {
/*  43 */     this(paramSteerable, (Steerable<T>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MatchVelocity(Steerable<T> paramSteerable1, Steerable<T> paramSteerable2) {
/*  50 */     this(paramSteerable1, paramSteerable2, 0.1F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MatchVelocity(Steerable<T> paramSteerable1, Steerable<T> paramSteerable2, float paramFloat) {
/*  58 */     super(paramSteerable1);
/*  59 */     this.target = paramSteerable2;
/*  60 */     this.timeToTarget = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  66 */     paramSteeringAcceleration.linear.set(this.target.getLinearVelocity()).sub(this.owner.getLinearVelocity()).scl(1.0F / this.timeToTarget)
/*  67 */       .limit(getActualLimiter().getMaxLinearAcceleration());
/*     */ 
/*     */     
/*  70 */     paramSteeringAcceleration.angular = 0.0F;
/*     */ 
/*     */     
/*  73 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */   
/*     */   public Steerable<T> getTarget() {
/*  78 */     return this.target;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MatchVelocity<T> setTarget(Steerable<T> paramSteerable) {
/*  85 */     this.target = paramSteerable;
/*  86 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTimeToTarget() {
/*  91 */     return this.timeToTarget;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MatchVelocity<T> setTimeToTarget(float paramFloat) {
/*  98 */     this.timeToTarget = paramFloat;
/*  99 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MatchVelocity<T> setOwner(Steerable<T> paramSteerable) {
/* 108 */     this.owner = paramSteerable;
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public MatchVelocity<T> setEnabled(boolean paramBoolean) {
/* 114 */     this.enabled = paramBoolean;
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MatchVelocity<T> setLimiter(Limiter paramLimiter) {
/* 122 */     this.limiter = paramLimiter;
/* 123 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\MatchVelocity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */