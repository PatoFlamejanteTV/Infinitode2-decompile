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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CollisionAvoidance<T extends Vector<T>>
/*     */   extends GroupBehavior<T>
/*     */   implements Proximity.ProximityCallback<T>
/*     */ {
/*     */   private float shortestTime;
/*     */   private Steerable<T> firstNeighbor;
/*     */   private float firstMinSeparation;
/*     */   private float firstDistance;
/*     */   private T firstRelativePosition;
/*     */   private T firstRelativeVelocity;
/*     */   private T relativePosition;
/*     */   private T relativeVelocity;
/*     */   
/*     */   public CollisionAvoidance(Steerable<T> paramSteerable, Proximity<T> paramProximity) {
/*  57 */     super(paramSteerable, paramProximity);
/*     */     
/*  59 */     this.firstRelativePosition = (T)newVector((Location)paramSteerable);
/*  60 */     this.firstRelativeVelocity = (T)newVector((Location)paramSteerable);
/*     */     
/*  62 */     this.relativeVelocity = (T)newVector((Location)paramSteerable);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  67 */     this.shortestTime = Float.POSITIVE_INFINITY;
/*  68 */     this.firstNeighbor = null;
/*  69 */     this.firstMinSeparation = 0.0F;
/*  70 */     this.firstDistance = 0.0F;
/*  71 */     this.relativePosition = (T)paramSteeringAcceleration.linear;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     if ((i = this.proximity.findNeighbors(this)) == 0 || this.firstNeighbor == null) return paramSteeringAcceleration.setZero();
/*     */ 
/*     */ 
/*     */     
/*  86 */     if (this.firstMinSeparation <= 0.0F || this.firstDistance < this.owner.getBoundingRadius() + this.firstNeighbor.getBoundingRadius()) {
/*  87 */       this.relativePosition.set(this.firstNeighbor.getPosition()).sub(this.owner.getPosition());
/*     */     } else {
/*     */       
/*  90 */       this.relativePosition.set((Vector)this.firstRelativePosition).mulAdd((Vector)this.firstRelativeVelocity, this.shortestTime);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  95 */     this.relativePosition.nor().scl(-getActualLimiter().getMaxLinearAcceleration());
/*     */ 
/*     */     
/*  98 */     paramSteeringAcceleration.angular = 0.0F;
/*     */ 
/*     */     
/* 101 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean reportNeighbor(Steerable<T> paramSteerable) {
/* 107 */     this.relativePosition.set(paramSteerable.getPosition()).sub(this.owner.getPosition());
/* 108 */     this.relativeVelocity.set(paramSteerable.getLinearVelocity()).sub(this.owner.getLinearVelocity());
/*     */ 
/*     */ 
/*     */     
/*     */     float f1;
/*     */ 
/*     */     
/* 115 */     if ((f1 = this.relativeVelocity.len2()) == 0.0F) return false;
/*     */ 
/*     */ 
/*     */     
/*     */     float f2;
/*     */     
/* 121 */     if ((f2 = -this.relativePosition.dot((Vector)this.relativeVelocity) / f1) <= 0.0F || f2 >= this.shortestTime) return false;
/*     */ 
/*     */     
/*     */     float f3;
/*     */     
/* 126 */     if ((f1 = (f3 = this.relativePosition.len()) - (float)Math.sqrt(f1) * f2) > this.owner.getBoundingRadius() + paramSteerable.getBoundingRadius()) return false;
/*     */ 
/*     */     
/* 129 */     this.shortestTime = f2;
/* 130 */     this.firstNeighbor = paramSteerable;
/* 131 */     this.firstMinSeparation = f1;
/* 132 */     this.firstDistance = f3;
/* 133 */     this.firstRelativePosition.set((Vector)this.relativePosition);
/* 134 */     this.firstRelativeVelocity.set((Vector)this.relativeVelocity);
/*     */     
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CollisionAvoidance<T> setOwner(Steerable<T> paramSteerable) {
/* 145 */     this.owner = paramSteerable;
/* 146 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public CollisionAvoidance<T> setEnabled(boolean paramBoolean) {
/* 151 */     this.enabled = paramBoolean;
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CollisionAvoidance<T> setLimiter(Limiter paramLimiter) {
/* 159 */     this.limiter = paramLimiter;
/* 160 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\CollisionAvoidance.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */