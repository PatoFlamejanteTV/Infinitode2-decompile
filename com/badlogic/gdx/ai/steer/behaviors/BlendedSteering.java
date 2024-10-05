/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.ai.steer.SteeringAcceleration;
/*     */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
/*     */ import com.badlogic.gdx.ai.utils.Location;
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
/*     */ public class BlendedSteering<T extends Vector<T>>
/*     */   extends SteeringBehavior<T>
/*     */ {
/*     */   protected Array<BehaviorAndWeight<T>> list;
/*     */   private SteeringAcceleration<T> steering;
/*     */   
/*     */   public BlendedSteering(Steerable<T> paramSteerable) {
/*  59 */     super(paramSteerable);
/*     */     
/*  61 */     this.list = new Array();
/*  62 */     this.steering = new SteeringAcceleration(newVector((Location)paramSteerable));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlendedSteering<T> add(SteeringBehavior<T> paramSteeringBehavior, float paramFloat) {
/*  70 */     return add(new BehaviorAndWeight<>(paramSteeringBehavior, paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlendedSteering<T> add(BehaviorAndWeight<T> paramBehaviorAndWeight) {
/*  77 */     paramBehaviorAndWeight.behavior.setOwner(this.owner);
/*  78 */     this.list.add(paramBehaviorAndWeight);
/*  79 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(BehaviorAndWeight<T> paramBehaviorAndWeight) {
/*  85 */     this.list.removeValue(paramBehaviorAndWeight, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(SteeringBehavior<T> paramSteeringBehavior) {
/*  91 */     for (byte b = 0; b < this.list.size; b++) {
/*  92 */       if (((BehaviorAndWeight)this.list.get(b)).behavior == paramSteeringBehavior) {
/*  93 */         this.list.removeIndex(b);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BehaviorAndWeight<T> get(int paramInt) {
/* 102 */     return (BehaviorAndWeight<T>)this.list.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/* 108 */     paramSteeringAcceleration.setZero();
/*     */ 
/*     */     
/* 111 */     int i = this.list.size;
/* 112 */     for (byte b = 0; b < i; b++) {
/*     */       BehaviorAndWeight behaviorAndWeight;
/*     */ 
/*     */       
/* 116 */       (behaviorAndWeight = (BehaviorAndWeight)this.list.get(b)).behavior.calculateSteering(this.steering);
/*     */ 
/*     */       
/* 119 */       paramSteeringAcceleration.mulAdd(this.steering, behaviorAndWeight.weight);
/*     */     } 
/*     */     
/* 122 */     Limiter limiter = getActualLimiter();
/*     */ 
/*     */     
/* 125 */     paramSteeringAcceleration.linear.limit(limiter.getMaxLinearAcceleration());
/* 126 */     if (paramSteeringAcceleration.angular > limiter.getMaxAngularAcceleration()) {
/* 127 */       paramSteeringAcceleration.angular = limiter.getMaxAngularAcceleration();
/*     */     }
/* 129 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlendedSteering<T> setOwner(Steerable<T> paramSteerable) {
/* 138 */     this.owner = paramSteerable;
/* 139 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public BlendedSteering<T> setEnabled(boolean paramBoolean) {
/* 144 */     this.enabled = paramBoolean;
/* 145 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlendedSteering<T> setLimiter(Limiter paramLimiter) {
/* 153 */     this.limiter = paramLimiter;
/* 154 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class BehaviorAndWeight<T extends Vector<T>>
/*     */   {
/*     */     protected SteeringBehavior<T> behavior;
/*     */     
/*     */     protected float weight;
/*     */ 
/*     */     
/*     */     public BehaviorAndWeight(SteeringBehavior<T> param1SteeringBehavior, float param1Float) {
/* 167 */       this.behavior = param1SteeringBehavior;
/* 168 */       this.weight = param1Float;
/*     */     }
/*     */     
/*     */     public SteeringBehavior<T> getBehavior() {
/* 172 */       return this.behavior;
/*     */     }
/*     */     
/*     */     public void setBehavior(SteeringBehavior<T> param1SteeringBehavior) {
/* 176 */       this.behavior = param1SteeringBehavior;
/*     */     }
/*     */     
/*     */     public float getWeight() {
/* 180 */       return this.weight;
/*     */     }
/*     */     
/*     */     public void setWeight(float param1Float) {
/* 184 */       this.weight = param1Float;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\BlendedSteering.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */