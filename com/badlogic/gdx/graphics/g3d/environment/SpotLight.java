/*     */ package com.badlogic.gdx.graphics.g3d.environment;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpotLight
/*     */   extends BaseLight<SpotLight>
/*     */ {
/*  26 */   public final Vector3 position = new Vector3();
/*  27 */   public final Vector3 direction = new Vector3();
/*     */   public float intensity;
/*     */   public float cutoffAngle;
/*     */   public float exponent;
/*     */   
/*     */   public SpotLight setPosition(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  33 */     this.position.set(paramFloat1, paramFloat2, paramFloat3);
/*  34 */     return this;
/*     */   }
/*     */   
/*     */   public SpotLight setPosition(Vector3 paramVector3) {
/*  38 */     this.position.set(paramVector3);
/*  39 */     return this;
/*     */   }
/*     */   
/*     */   public SpotLight setDirection(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  43 */     this.direction.set(paramFloat1, paramFloat2, paramFloat3);
/*  44 */     return this;
/*     */   }
/*     */   
/*     */   public SpotLight setDirection(Vector3 paramVector3) {
/*  48 */     this.direction.set(paramVector3);
/*  49 */     return this;
/*     */   }
/*     */   
/*     */   public SpotLight setIntensity(float paramFloat) {
/*  53 */     this.intensity = paramFloat;
/*  54 */     return this;
/*     */   }
/*     */   
/*     */   public SpotLight setCutoffAngle(float paramFloat) {
/*  58 */     this.cutoffAngle = paramFloat;
/*  59 */     return this;
/*     */   }
/*     */   
/*     */   public SpotLight setExponent(float paramFloat) {
/*  63 */     this.exponent = paramFloat;
/*  64 */     return this;
/*     */   }
/*     */   
/*     */   public SpotLight set(SpotLight paramSpotLight) {
/*  68 */     return set(paramSpotLight.color, paramSpotLight.position, paramSpotLight.direction, paramSpotLight.intensity, paramSpotLight.cutoffAngle, paramSpotLight.exponent);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SpotLight set(Color paramColor, Vector3 paramVector31, Vector3 paramVector32, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  74 */     if (paramColor != null) this.color.set(paramColor); 
/*  75 */     if (paramVector31 != null) this.position.set(paramVector31); 
/*  76 */     if (paramVector32 != null) this.direction.set(paramVector32).nor(); 
/*  77 */     this.intensity = paramFloat1;
/*  78 */     this.cutoffAngle = paramFloat2;
/*  79 */     this.exponent = paramFloat3;
/*  80 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SpotLight set(float paramFloat1, float paramFloat2, float paramFloat3, Vector3 paramVector31, Vector3 paramVector32, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  85 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, 1.0F);
/*  86 */     if (paramVector31 != null) this.position.set(paramVector31); 
/*  87 */     if (paramVector32 != null) this.direction.set(paramVector32).nor(); 
/*  88 */     this.intensity = paramFloat4;
/*  89 */     this.cutoffAngle = paramFloat5;
/*  90 */     this.exponent = paramFloat6;
/*  91 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SpotLight set(Color paramColor, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
/*  96 */     if (paramColor != null) this.color.set(paramColor); 
/*  97 */     this.position.set(paramFloat1, paramFloat2, paramFloat3);
/*  98 */     this.direction.set(paramFloat4, paramFloat5, paramFloat6).nor();
/*  99 */     this.intensity = paramFloat7;
/* 100 */     this.cutoffAngle = paramFloat8;
/* 101 */     this.exponent = paramFloat9;
/* 102 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SpotLight set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12) {
/* 108 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, 1.0F);
/* 109 */     this.position.set(paramFloat4, paramFloat5, paramFloat6);
/* 110 */     this.direction.set(paramFloat7, paramFloat8, paramFloat9).nor();
/* 111 */     this.intensity = paramFloat10;
/* 112 */     this.cutoffAngle = paramFloat11;
/* 113 */     this.exponent = paramFloat12;
/* 114 */     return this;
/*     */   }
/*     */   
/*     */   public SpotLight setTarget(Vector3 paramVector3) {
/* 118 */     this.direction.set(paramVector3).sub(this.position).nor();
/* 119 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 124 */     return (paramObject instanceof SpotLight && equals((SpotLight)paramObject));
/*     */   }
/*     */   
/*     */   public boolean equals(SpotLight paramSpotLight) {
/* 128 */     if (paramSpotLight != null && (paramSpotLight == this || (this.color.equals(paramSpotLight.color) && this.position.equals(paramSpotLight.position) && this.direction
/* 129 */       .equals(paramSpotLight.direction) && MathUtils.isEqual(this.intensity, paramSpotLight.intensity) && 
/* 130 */       MathUtils.isEqual(this.cutoffAngle, paramSpotLight.cutoffAngle) && MathUtils.isEqual(this.exponent, paramSpotLight.exponent)))) return true; 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\environment\SpotLight.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */