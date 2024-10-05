/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.GroupBehavior;
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
/*     */ public class Separation<T extends Vector<T>>
/*     */   extends GroupBehavior<T>
/*     */   implements Proximity.ProximityCallback<T>
/*     */ {
/*  39 */   float decayCoefficient = 1.0F;
/*     */ 
/*     */   
/*     */   private T toAgent;
/*     */   
/*     */   private T linear;
/*     */ 
/*     */   
/*     */   public Separation(Steerable<T> paramSteerable, Proximity<T> paramProximity) {
/*  48 */     super(paramSteerable, paramProximity);
/*     */     
/*  50 */     this.toAgent = (T)newVector((Location)paramSteerable);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  55 */     paramSteeringAcceleration.setZero();
/*     */     
/*  57 */     this.linear = (T)paramSteeringAcceleration.linear;
/*     */     
/*  59 */     this.proximity.findNeighbors(this);
/*     */     
/*  61 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean reportNeighbor(Steerable<T> paramSteerable) {
/*  67 */     this.toAgent.set(this.owner.getPosition()).sub(paramSteerable.getPosition());
/*     */     
/*     */     float f1;
/*  70 */     if ((f1 = this.toAgent.len2()) == 0.0F) return true;
/*     */     
/*  72 */     float f2 = getActualLimiter().getMaxLinearAcceleration();
/*     */     
/*     */     float f3;
/*     */     
/*  76 */     if ((f3 = getDecayCoefficient() / f1) > f2) f3 = f2;
/*     */ 
/*     */ 
/*     */     
/*  80 */     this.linear.mulAdd((Vector)this.toAgent, f3 / (float)Math.sqrt(f1));
/*     */     
/*  82 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDecayCoefficient() {
/*  87 */     return this.decayCoefficient;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Separation<T> setDecayCoefficient(float paramFloat) {
/*  94 */     this.decayCoefficient = paramFloat;
/*  95 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Separation<T> setOwner(Steerable<T> paramSteerable) {
/* 104 */     this.owner = paramSteerable;
/* 105 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Separation<T> setEnabled(boolean paramBoolean) {
/* 110 */     this.enabled = paramBoolean;
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Separation<T> setLimiter(Limiter paramLimiter) {
/* 118 */     this.limiter = paramLimiter;
/* 119 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Separation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */