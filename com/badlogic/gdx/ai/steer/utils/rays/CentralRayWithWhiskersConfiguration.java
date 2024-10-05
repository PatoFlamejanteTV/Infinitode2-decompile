/*     */ package com.badlogic.gdx.ai.steer.utils.rays;
/*     */ 
/*     */ import com.badlogic.gdx.ai.steer.Steerable;
/*     */ import com.badlogic.gdx.ai.utils.Ray;
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
/*     */ public class CentralRayWithWhiskersConfiguration<T extends Vector<T>>
/*     */   extends RayConfigurationBase<T>
/*     */ {
/*     */   private float rayLength;
/*     */   private float whiskerLength;
/*     */   private float whiskerAngle;
/*     */   
/*     */   public CentralRayWithWhiskersConfiguration(Steerable<T> paramSteerable, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  45 */     super(paramSteerable, 3);
/*  46 */     this.rayLength = paramFloat1;
/*  47 */     this.whiskerLength = paramFloat2;
/*  48 */     this.whiskerAngle = paramFloat3;
/*     */   }
/*     */ 
/*     */   
/*     */   public Ray<T>[] updateRays() {
/*  53 */     Vector vector1 = this.owner.getPosition();
/*  54 */     Vector vector2 = this.owner.getLinearVelocity();
/*     */     
/*  56 */     float f = this.owner.vectorToAngle(vector2);
/*     */ 
/*     */     
/*  59 */     (this.rays[0]).start.set(vector1);
/*  60 */     (this.rays[0]).end.set(vector2).nor().scl(this.rayLength).add(vector1);
/*     */ 
/*     */     
/*  63 */     (this.rays[1]).start.set(vector1);
/*  64 */     this.owner.angleToVector((this.rays[1]).end, f - this.whiskerAngle).scl(this.whiskerLength).add(vector1);
/*     */ 
/*     */     
/*  67 */     (this.rays[2]).start.set(vector1);
/*  68 */     this.owner.angleToVector((this.rays[2]).end, f + this.whiskerAngle).scl(this.whiskerLength).add(vector1);
/*     */     
/*  70 */     return this.rays;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRayLength() {
/*  75 */     return this.rayLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRayLength(float paramFloat) {
/*  80 */     this.rayLength = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWhiskerLength() {
/*  85 */     return this.whiskerLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWhiskerLength(float paramFloat) {
/*  90 */     this.whiskerLength = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWhiskerAngle() {
/*  95 */     return this.whiskerAngle;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWhiskerAngle(float paramFloat) {
/* 100 */     this.whiskerAngle = paramFloat;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\stee\\utils\rays\CentralRayWithWhiskersConfiguration.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */