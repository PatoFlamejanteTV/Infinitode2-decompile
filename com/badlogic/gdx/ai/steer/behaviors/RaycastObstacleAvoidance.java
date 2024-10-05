/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.ai.steer.SteeringAcceleration;
/*     */ import com.badlogic.gdx.ai.steer.SteeringBehavior;
/*     */ import com.badlogic.gdx.ai.steer.utils.RayConfiguration;
/*     */ import com.badlogic.gdx.ai.utils.Collision;
/*     */ import com.badlogic.gdx.ai.utils.Location;
/*     */ import com.badlogic.gdx.ai.utils.Ray;
/*     */ import com.badlogic.gdx.ai.utils.RaycastCollisionDetector;
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
/*     */ public class RaycastObstacleAvoidance<T extends Vector<T>>
/*     */   extends SteeringBehavior<T>
/*     */ {
/*     */   protected RayConfiguration<T> rayConfiguration;
/*     */   protected RaycastCollisionDetector<T> raycastCollisionDetector;
/*     */   protected float distanceFromBoundary;
/*     */   private Collision<T> outputCollision;
/*     */   private Collision<T> minOutputCollision;
/*     */   
/*     */   public RaycastObstacleAvoidance(Steerable<T> paramSteerable) {
/*  90 */     this(paramSteerable, (RayConfiguration<T>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RaycastObstacleAvoidance(Steerable<T> paramSteerable, RayConfiguration<T> paramRayConfiguration) {
/*  97 */     this(paramSteerable, paramRayConfiguration, (RaycastCollisionDetector<T>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RaycastObstacleAvoidance(Steerable<T> paramSteerable, RayConfiguration<T> paramRayConfiguration, RaycastCollisionDetector<T> paramRaycastCollisionDetector) {
/* 106 */     this(paramSteerable, paramRayConfiguration, paramRaycastCollisionDetector, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RaycastObstacleAvoidance(Steerable<T> paramSteerable, RayConfiguration<T> paramRayConfiguration, RaycastCollisionDetector<T> paramRaycastCollisionDetector, float paramFloat) {
/* 116 */     super(paramSteerable);
/* 117 */     this.rayConfiguration = paramRayConfiguration;
/* 118 */     this.raycastCollisionDetector = paramRaycastCollisionDetector;
/* 119 */     this.distanceFromBoundary = paramFloat;
/*     */     
/* 121 */     this.outputCollision = new Collision(newVector((Location)paramSteerable), newVector((Location)paramSteerable));
/* 122 */     this.minOutputCollision = new Collision(newVector((Location)paramSteerable), newVector((Location)paramSteerable));
/*     */   }
/*     */ 
/*     */   
/*     */   protected SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/* 127 */     Vector vector = this.owner.getPosition();
/* 128 */     float f = Float.POSITIVE_INFINITY;
/*     */ 
/*     */     
/* 131 */     Ray[] arrayOfRay = this.rayConfiguration.updateRays();
/*     */ 
/*     */     
/* 134 */     for (byte b = 0; b < arrayOfRay.length; b++) {
/*     */       float f1;
/*     */       
/*     */       boolean bool;
/* 138 */       if ((bool = this.raycastCollisionDetector.findCollision(this.outputCollision, arrayOfRay[b])) && (
/*     */         
/* 140 */         f1 = vector.dst2(this.outputCollision.point)) < f) {
/* 141 */         f = f1;
/*     */         
/* 143 */         Collision<T> collision = this.outputCollision;
/* 144 */         this.outputCollision = this.minOutputCollision;
/* 145 */         this.minOutputCollision = collision;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 151 */     if (f == Float.POSITIVE_INFINITY) return paramSteeringAcceleration.setZero();
/*     */ 
/*     */     
/* 154 */     paramSteeringAcceleration.linear.set(this.minOutputCollision.point)
/* 155 */       .mulAdd(this.minOutputCollision.normal, this.owner.getBoundingRadius() + this.distanceFromBoundary).sub(this.owner.getPosition()).nor()
/* 156 */       .scl(getActualLimiter().getMaxLinearAcceleration());
/*     */ 
/*     */     
/* 159 */     paramSteeringAcceleration.angular = 0.0F;
/*     */ 
/*     */     
/* 162 */     return paramSteeringAcceleration;
/*     */   }
/*     */ 
/*     */   
/*     */   public RayConfiguration<T> getRayConfiguration() {
/* 167 */     return this.rayConfiguration;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RaycastObstacleAvoidance<T> setRayConfiguration(RayConfiguration<T> paramRayConfiguration) {
/* 174 */     this.rayConfiguration = paramRayConfiguration;
/* 175 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RaycastCollisionDetector<T> getRaycastCollisionDetector() {
/* 180 */     return this.raycastCollisionDetector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RaycastObstacleAvoidance<T> setRaycastCollisionDetector(RaycastCollisionDetector<T> paramRaycastCollisionDetector) {
/* 187 */     this.raycastCollisionDetector = paramRaycastCollisionDetector;
/* 188 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getDistanceFromBoundary() {
/* 193 */     return this.distanceFromBoundary;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RaycastObstacleAvoidance<T> setDistanceFromBoundary(float paramFloat) {
/* 200 */     this.distanceFromBoundary = paramFloat;
/* 201 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RaycastObstacleAvoidance<T> setOwner(Steerable<T> paramSteerable) {
/* 210 */     this.owner = paramSteerable;
/* 211 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RaycastObstacleAvoidance<T> setEnabled(boolean paramBoolean) {
/* 216 */     this.enabled = paramBoolean;
/* 217 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RaycastObstacleAvoidance<T> setLimiter(Limiter paramLimiter) {
/* 224 */     this.limiter = paramLimiter;
/* 225 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\RaycastObstacleAvoidance.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */