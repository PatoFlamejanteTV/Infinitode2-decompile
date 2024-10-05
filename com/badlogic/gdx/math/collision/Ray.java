/*     */ package com.badlogic.gdx.math.collision;
/*     */ 
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector3;
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
/*     */ public class Ray
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -620692054835390878L;
/*  29 */   public final Vector3 origin = new Vector3();
/*  30 */   public final Vector3 direction = new Vector3();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ray() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Ray(Vector3 paramVector31, Vector3 paramVector32) {
/*  40 */     this.origin.set(paramVector31);
/*  41 */     this.direction.set(paramVector32).nor();
/*     */   }
/*     */ 
/*     */   
/*     */   public Ray cpy() {
/*  46 */     return new Ray(this.origin, this.direction);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 getEndPoint(Vector3 paramVector3, float paramFloat) {
/*  54 */     return paramVector3.set(this.direction).scl(paramFloat).add(this.origin);
/*     */   }
/*     */   
/*  57 */   static Vector3 tmp = new Vector3();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ray mul(Matrix4 paramMatrix4) {
/*  64 */     tmp.set(this.origin).add(this.direction);
/*  65 */     tmp.mul(paramMatrix4);
/*  66 */     this.origin.mul(paramMatrix4);
/*  67 */     this.direction.set(tmp.sub(this.origin)).nor();
/*  68 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  73 */     return "ray [" + this.origin + ":" + this.direction + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ray set(Vector3 paramVector31, Vector3 paramVector32) {
/*  82 */     this.origin.set(paramVector31);
/*  83 */     this.direction.set(paramVector32).nor();
/*  84 */     return this;
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
/*     */   public Ray set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  97 */     this.origin.set(paramFloat1, paramFloat2, paramFloat3);
/*  98 */     this.direction.set(paramFloat4, paramFloat5, paramFloat6).nor();
/*  99 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ray set(Ray paramRay) {
/* 107 */     this.origin.set(paramRay.origin);
/* 108 */     this.direction.set(paramRay.direction).nor();
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 114 */     if (paramObject == this) return true; 
/* 115 */     if (paramObject == null || paramObject.getClass() != getClass()) return false; 
/* 116 */     paramObject = paramObject;
/* 117 */     return (this.direction.equals(((Ray)paramObject).direction) && this.origin.equals(((Ray)paramObject).origin));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 124 */     int i = 73 + this.direction.hashCode();
/*     */     
/* 126 */     return i = i * 73 + this.origin.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\collision\Ray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */