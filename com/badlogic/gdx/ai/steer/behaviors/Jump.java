/*     */ package com.badlogic.gdx.ai.steer.behaviors;
/*     */ 
/*     */ import com.badlogic.gdx.ai.GdxAI;
/*     */ import com.badlogic.gdx.ai.steer.Limiter;
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.ai.steer.SteerableAdapter;
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
/*     */ public class Jump<T extends Vector<T>>
/*     */   extends MatchVelocity<T>
/*     */ {
/*     */   public static boolean DEBUG_ENABLED = false;
/*     */   protected JumpDescriptor<T> jumpDescriptor;
/*     */   protected T gravity;
/*     */   protected GravityComponentHandler<T> gravityComponentHandler;
/*     */   protected JumpCallback callback;
/*     */   protected float takeoffPositionTolerance;
/*     */   protected float takeoffVelocityTolerance;
/*     */   protected float maxVerticalVelocity;
/*     */   private boolean isJumpAchievable;
/*  60 */   protected float airborneTime = 0.0F;
/*     */ 
/*     */ 
/*     */   
/*     */   private JumpTarget<T> jumpTarget;
/*     */ 
/*     */ 
/*     */   
/*     */   private T planarVelocity;
/*     */ 
/*     */ 
/*     */   
/*     */   public Jump(Steerable<T> paramSteerable, JumpDescriptor<T> paramJumpDescriptor, T paramT, GravityComponentHandler<T> paramGravityComponentHandler, JumpCallback paramJumpCallback) {
/*  73 */     super(paramSteerable);
/*  74 */     this.gravity = paramT;
/*  75 */     this.gravityComponentHandler = paramGravityComponentHandler;
/*  76 */     setJumpDescriptor(paramJumpDescriptor);
/*  77 */     this.callback = paramJumpCallback;
/*     */     
/*  79 */     this.jumpTarget = new JumpTarget<>(paramSteerable);
/*  80 */     this.planarVelocity = (T)newVector((Location)paramSteerable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringAcceleration<T> calculateRealSteering(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  86 */     if (this.target == null) {
/*  87 */       this.target = calculateTarget();
/*  88 */       this.callback.reportAchievability(this.isJumpAchievable);
/*     */     } 
/*     */ 
/*     */     
/*  92 */     if (!this.isJumpAchievable) return paramSteeringAcceleration.setZero();
/*     */ 
/*     */     
/*  95 */     if (this.owner.getPosition().epsilonEquals(this.target.getPosition(), this.takeoffPositionTolerance)) {
/*  96 */       if (DEBUG_ENABLED) GdxAI.getLogger().info("Jump", "Good position!!!"); 
/*  97 */       if (this.owner.getLinearVelocity().epsilonEquals(this.target.getLinearVelocity(), this.takeoffVelocityTolerance)) {
/*  98 */         if (DEBUG_ENABLED) GdxAI.getLogger().info("Jump", "Good Velocity!!!"); 
/*  99 */         this.isJumpAchievable = false;
/*     */         
/* 101 */         this.callback.takeoff(this.maxVerticalVelocity, this.airborneTime);
/* 102 */         return paramSteeringAcceleration.setZero();
/*     */       } 
/* 104 */       if (DEBUG_ENABLED) {
/* 105 */         GdxAI.getLogger().info("Jump", "Bad Velocity: Speed diff. = " + this.planarVelocity
/*     */             
/* 107 */             .set(this.target.getLinearVelocity()).sub(this.owner.getLinearVelocity()).len() + ", diff = (" + this.planarVelocity + ")");
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 113 */     return super.calculateRealSteering(paramSteeringAcceleration);
/*     */   }
/*     */ 
/*     */   
/*     */   private Steerable<T> calculateTarget() {
/* 118 */     this.jumpTarget.position = this.jumpDescriptor.takeoffPosition;
/* 119 */     this.airborneTime = calculateAirborneTimeAndVelocity(this.jumpTarget.linearVelocity, this.jumpDescriptor, getActualLimiter()
/* 120 */         .getMaxLinearSpeed());
/* 121 */     this.isJumpAchievable = (this.airborneTime >= 0.0F);
/* 122 */     return (Steerable<T>)this.jumpTarget;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float calculateAirborneTimeAndVelocity(T paramT, JumpDescriptor<T> paramJumpDescriptor, float paramFloat) {
/* 135 */     float f1 = this.gravityComponentHandler.getComponent(this.gravity);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 142 */     float f2 = (float)Math.sqrt((f1 * 2.0F * this.gravityComponentHandler.getComponent(paramJumpDescriptor.delta) + this.maxVerticalVelocity * this.maxVerticalVelocity));
/*     */     
/* 144 */     float f3 = (-this.maxVerticalVelocity + f2) / f1;
/* 145 */     if (DEBUG_ENABLED) GdxAI.getLogger().info("Jump", "1st jump time = " + f3);
/*     */ 
/*     */     
/* 148 */     if (!checkAirborneTimeAndCalculateVelocity(paramT, f3, paramJumpDescriptor, paramFloat)) {
/*     */       
/* 150 */       f3 = (-this.maxVerticalVelocity - f2) / f1;
/* 151 */       if (DEBUG_ENABLED) GdxAI.getLogger().info("Jump", "2nd jump time = " + f3); 
/* 152 */       if (!checkAirborneTimeAndCalculateVelocity(paramT, f3, paramJumpDescriptor, paramFloat)) {
/* 153 */         return -1.0F;
/*     */       }
/*     */     } 
/* 156 */     return f3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean checkAirborneTimeAndCalculateVelocity(T paramT, float paramFloat1, JumpDescriptor<T> paramJumpDescriptor, float paramFloat2) {
/* 162 */     this.planarVelocity.set((Vector)paramJumpDescriptor.delta).scl(1.0F / paramFloat1);
/* 163 */     this.gravityComponentHandler.setComponent(this.planarVelocity, 0.0F);
/*     */ 
/*     */     
/* 166 */     if (this.planarVelocity.len2() < paramFloat2 * paramFloat2) {
/*     */       
/* 168 */       paramFloat1 = this.gravityComponentHandler.getComponent(paramT);
/* 169 */       this.gravityComponentHandler.setComponent((T)paramT.set((Vector)this.planarVelocity), paramFloat1);
/* 170 */       if (DEBUG_ENABLED)
/* 171 */         GdxAI.getLogger().info("Jump", "targetLinearVelocity = " + paramT + "; targetLinearSpeed = " + paramT.len()); 
/* 172 */       return true;
/*     */     } 
/* 174 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public JumpDescriptor<T> getJumpDescriptor() {
/* 179 */     return this.jumpDescriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jump<T> setJumpDescriptor(JumpDescriptor<T> paramJumpDescriptor) {
/* 186 */     this.jumpDescriptor = paramJumpDescriptor;
/* 187 */     this.target = null;
/* 188 */     this.isJumpAchievable = false;
/* 189 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getGravity() {
/* 194 */     return this.gravity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jump<T> setGravity(T paramT) {
/* 201 */     this.gravity = paramT;
/* 202 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMaxVerticalVelocity() {
/* 207 */     return this.maxVerticalVelocity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jump<T> setMaxVerticalVelocity(float paramFloat) {
/* 214 */     this.maxVerticalVelocity = paramFloat;
/* 215 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTakeoffPositionTolerance() {
/* 220 */     return this.takeoffPositionTolerance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jump<T> setTakeoffPositionTolerance(float paramFloat) {
/* 227 */     this.takeoffPositionTolerance = paramFloat;
/* 228 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getTakeoffVelocityTolerance() {
/* 233 */     return this.takeoffVelocityTolerance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jump<T> setTakeoffVelocityTolerance(float paramFloat) {
/* 240 */     this.takeoffVelocityTolerance = paramFloat;
/* 241 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jump<T> setTakeoffTolerance(float paramFloat) {
/* 248 */     setTakeoffPositionTolerance(paramFloat);
/* 249 */     setTakeoffVelocityTolerance(paramFloat);
/* 250 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jump<T> setOwner(Steerable<T> paramSteerable) {
/* 259 */     this.owner = paramSteerable;
/* 260 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Jump<T> setEnabled(boolean paramBoolean) {
/* 265 */     this.enabled = paramBoolean;
/* 266 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jump<T> setLimiter(Limiter paramLimiter) {
/* 274 */     this.limiter = paramLimiter;
/* 275 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jump<T> setTarget(Steerable<T> paramSteerable) {
/* 284 */     this.target = paramSteerable;
/* 285 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Jump<T> setTimeToTarget(float paramFloat) {
/* 290 */     this.timeToTarget = paramFloat;
/* 291 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class JumpTarget<T extends Vector<T>>
/*     */     extends SteerableAdapter<T>
/*     */   {
/*     */     T position;
/*     */     
/*     */     T linearVelocity;
/*     */ 
/*     */     
/*     */     public JumpTarget(Steerable<T> param1Steerable) {
/* 304 */       this.position = null;
/* 305 */       this.linearVelocity = (T)param1Steerable.getPosition().cpy().setZero();
/*     */     }
/*     */ 
/*     */     
/*     */     public T getPosition() {
/* 310 */       return this.position;
/*     */     }
/*     */ 
/*     */     
/*     */     public T getLinearVelocity() {
/* 315 */       return this.linearVelocity;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class JumpDescriptor<T extends Vector<T>>
/*     */   {
/*     */     public T takeoffPosition;
/*     */ 
/*     */ 
/*     */     
/*     */     public T landingPosition;
/*     */ 
/*     */ 
/*     */     
/*     */     public T delta;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public JumpDescriptor(T param1T1, T param1T2) {
/* 338 */       this.takeoffPosition = param1T1;
/* 339 */       this.landingPosition = param1T2;
/* 340 */       this.delta = (T)param1T2.cpy();
/* 341 */       set(param1T1, param1T2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void set(T param1T1, T param1T2) {
/* 348 */       this.takeoffPosition.set((Vector)param1T1);
/* 349 */       this.landingPosition.set((Vector)param1T2);
/* 350 */       this.delta.set((Vector)param1T2).sub((Vector)param1T1);
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface GravityComponentHandler<T extends Vector<T>> {
/*     */     float getComponent(T param1T);
/*     */     
/*     */     void setComponent(T param1T, float param1Float);
/*     */   }
/*     */   
/*     */   public static interface JumpCallback {
/*     */     void reportAchievability(boolean param1Boolean);
/*     */     
/*     */     void takeoff(float param1Float1, float param1Float2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\behaviors\Jump.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */