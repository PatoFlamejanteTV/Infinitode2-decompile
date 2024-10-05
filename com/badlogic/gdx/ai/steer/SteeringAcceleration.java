/*     */ package com.badlogic.gdx.ai.steer;
/*     */ 
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
/*     */ public class SteeringAcceleration<T extends Vector<T>>
/*     */ {
/*     */   public T linear;
/*     */   public float angular;
/*     */   
/*     */   public SteeringAcceleration(T paramT) {
/*  38 */     this(paramT, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringAcceleration(T paramT, float paramFloat) {
/*  46 */     if (paramT == null) throw new IllegalArgumentException("Linear acceleration cannot be null"); 
/*  47 */     this.linear = paramT;
/*  48 */     this.angular = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isZero() {
/*  53 */     return (this.angular == 0.0F && this.linear.isZero());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringAcceleration<T> setZero() {
/*  59 */     this.linear.setZero();
/*  60 */     this.angular = 0.0F;
/*  61 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringAcceleration<T> add(SteeringAcceleration<T> paramSteeringAcceleration) {
/*  69 */     this.linear.add((Vector)paramSteeringAcceleration.linear);
/*  70 */     this.angular += paramSteeringAcceleration.angular;
/*  71 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringAcceleration<T> scl(float paramFloat) {
/*  79 */     this.linear.scl(paramFloat);
/*  80 */     this.angular *= paramFloat;
/*  81 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SteeringAcceleration<T> mulAdd(SteeringAcceleration<T> paramSteeringAcceleration, float paramFloat) {
/*  90 */     this.linear.mulAdd((Vector)paramSteeringAcceleration.linear, paramFloat);
/*  91 */     this.angular += paramSteeringAcceleration.angular * paramFloat;
/*  92 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float calculateSquareMagnitude() {
/*  97 */     return this.linear.len2() + this.angular * this.angular;
/*     */   }
/*     */ 
/*     */   
/*     */   public float calculateMagnitude() {
/* 102 */     return (float)Math.sqrt(calculateSquareMagnitude());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\steer\SteeringAcceleration.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */