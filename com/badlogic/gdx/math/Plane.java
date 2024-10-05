/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Plane
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1240652082930747866L;
/*     */   
/*     */   public enum PlaneSide
/*     */   {
/*  32 */     OnPlane, Back, Front;
/*     */   }
/*     */   
/*  35 */   public final Vector3 normal = new Vector3();
/*  36 */   public float d = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Plane() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Plane(Vector3 paramVector3, float paramFloat) {
/*  48 */     this.normal.set(paramVector3).nor();
/*  49 */     this.d = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Plane(Vector3 paramVector31, Vector3 paramVector32) {
/*  57 */     this.normal.set(paramVector31).nor();
/*  58 */     this.d = -this.normal.dot(paramVector32);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Plane(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33) {
/*  68 */     set(paramVector31, paramVector32, paramVector33);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Vector3 paramVector31, Vector3 paramVector32, Vector3 paramVector33) {
/*  78 */     this.normal.set(paramVector31).sub(paramVector32).crs(paramVector32.x - paramVector33.x, paramVector32.y - paramVector33.y, paramVector32.z - paramVector33.z).nor();
/*  79 */     this.d = -paramVector31.dot(this.normal);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  89 */     this.normal.set(paramFloat1, paramFloat2, paramFloat3);
/*  90 */     this.d = paramFloat4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float distance(Vector3 paramVector3) {
/*  98 */     return this.normal.dot(paramVector3) + this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PlaneSide testPoint(Vector3 paramVector3) {
/*     */     float f;
/* 109 */     if ((f = this.normal.dot(paramVector3) + this.d) == 0.0F)
/* 110 */       return PlaneSide.OnPlane; 
/* 111 */     if (f < 0.0F) {
/* 112 */       return PlaneSide.Back;
/*     */     }
/* 114 */     return PlaneSide.Front;
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
/*     */   public PlaneSide testPoint(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 127 */     if ((paramFloat1 = this.normal.dot(paramFloat1, paramFloat2, paramFloat3) + this.d) == 0.0F)
/* 128 */       return PlaneSide.OnPlane; 
/* 129 */     if (paramFloat1 < 0.0F) {
/* 130 */       return PlaneSide.Back;
/*     */     }
/* 132 */     return PlaneSide.Front;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFrontFacing(Vector3 paramVector3) {
/*     */     float f;
/* 142 */     return ((f = this.normal.dot(paramVector3)) <= 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector3 getNormal() {
/* 147 */     return this.normal;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getD() {
/* 152 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Vector3 paramVector31, Vector3 paramVector32) {
/* 160 */     this.normal.set(paramVector32);
/* 161 */     this.d = -paramVector31.dot(paramVector32);
/*     */   }
/*     */   
/*     */   public void set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 165 */     this.normal.set(paramFloat4, paramFloat5, paramFloat6);
/* 166 */     this.d = -(paramFloat1 * paramFloat4 + paramFloat2 * paramFloat5 + paramFloat3 * paramFloat6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Plane paramPlane) {
/* 173 */     this.normal.set(paramPlane.normal);
/* 174 */     this.d = paramPlane.d;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 178 */     return this.normal.toString() + ", " + this.d;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Plane.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */