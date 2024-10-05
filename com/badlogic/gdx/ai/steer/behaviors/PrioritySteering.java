/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.ai.steer.SteeringAcceleration;
/*     */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
/*     */ import com.badlogic.gdx.math.Vector;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PrioritySteering<T extends Vector<T>>
/*     */   extends SteeringBehavior<T>
/*     */ {
/*     */   protected float epsilon;
/*  69 */   protected Array<SteeringBehavior<T>> behaviors = new Array();
/*     */ 
/*     */   
/*     */   protected int selectedBehaviorIndex;
/*     */ 
/*     */ 
/*     */   
/*     */   public PrioritySteering(Steerable<T> paramSteerable) {
/*  77 */     this(paramSteerable, 0.001F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrioritySteering(Steerable<T> paramSteerable, float paramFloat) {
/*  85 */     super(paramSteerable);
/*  86 */     this.epsilon = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrioritySteering<T> add(SteeringBehavior<T> paramSteeringBehavior) {
/*  93 */     this.behaviors.add(paramSteeringBehavior);
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/* 100 */     float f = this.epsilon * this.epsilon;
/*     */ 
/*     */     
/* 103 */     int i = this.behaviors.size;
/* 104 */     this.selectedBehaviorIndex = -1;
/* 105 */     for (byte b = 0; b < i; b++) {
/* 106 */       this.selectedBehaviorIndex = b;
/*     */ 
/*     */       
/*     */       SteeringBehavior steeringBehavior;
/*     */       
/* 111 */       (steeringBehavior = (SteeringBehavior)this.behaviors.get(b)).calculateSteering(paramSteeringAcceleration);
/*     */ 
/*     */       
/* 114 */       if (paramSteeringAcceleration.calculateSquareMagnitude() > f) return paramSteeringAcceleration;
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 120 */     return (i > 0) ? paramSteeringAcceleration : paramSteeringAcceleration.setZero();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSelectedBehaviorIndex() {
/* 126 */     return this.selectedBehaviorIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getEpsilon() {
/* 132 */     return this.epsilon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrioritySteering<T> setEpsilon(float paramFloat) {
/* 140 */     this.epsilon = paramFloat;
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrioritySteering<T> setOwner(Steerable<T> paramSteerable) {
/* 150 */     this.owner = paramSteerable;
/* 151 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PrioritySteering<T> setEnabled(boolean paramBoolean) {
/* 156 */     this.enabled = paramBoolean;
/* 157 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrioritySteering<T> setLimiter(Limiter paramLimiter) {
/* 165 */     this.limiter = paramLimiter;
/* 166 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\PrioritySteering.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */