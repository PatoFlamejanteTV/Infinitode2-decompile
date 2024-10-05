/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.NumberUtils;
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
/*     */ 
/*     */ public class Circle
/*     */   implements Shape2D, Serializable
/*     */ {
/*     */   public float x;
/*     */   public float y;
/*     */   public float radius;
/*     */   
/*     */   public Circle() {}
/*     */   
/*     */   public Circle(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  37 */     this.x = paramFloat1;
/*  38 */     this.y = paramFloat2;
/*  39 */     this.radius = paramFloat3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Circle(Vector2 paramVector2, float paramFloat) {
/*  47 */     this.x = paramVector2.x;
/*  48 */     this.y = paramVector2.y;
/*  49 */     this.radius = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Circle(Circle paramCircle) {
/*  56 */     this.x = paramCircle.x;
/*  57 */     this.y = paramCircle.y;
/*  58 */     this.radius = paramCircle.radius;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Circle(Vector2 paramVector21, Vector2 paramVector22) {
/*  66 */     this.x = paramVector21.x;
/*  67 */     this.y = paramVector21.y;
/*  68 */     this.radius = Vector2.len(paramVector21.x - paramVector22.x, paramVector21.y - paramVector22.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  77 */     this.x = paramFloat1;
/*  78 */     this.y = paramFloat2;
/*  79 */     this.radius = paramFloat3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Vector2 paramVector2, float paramFloat) {
/*  87 */     this.x = paramVector2.x;
/*  88 */     this.y = paramVector2.y;
/*  89 */     this.radius = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Circle paramCircle) {
/*  96 */     this.x = paramCircle.x;
/*  97 */     this.y = paramCircle.y;
/*  98 */     this.radius = paramCircle.radius;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Vector2 paramVector21, Vector2 paramVector22) {
/* 106 */     this.x = paramVector21.x;
/* 107 */     this.y = paramVector21.y;
/* 108 */     this.radius = Vector2.len(paramVector21.x - paramVector22.x, paramVector21.y - paramVector22.y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosition(Vector2 paramVector2) {
/* 114 */     this.x = paramVector2.x;
/* 115 */     this.y = paramVector2.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/* 122 */     this.x = paramFloat1;
/* 123 */     this.y = paramFloat2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(float paramFloat) {
/* 129 */     this.x = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(float paramFloat) {
/* 135 */     this.y = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRadius(float paramFloat) {
/* 141 */     this.radius = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(float paramFloat1, float paramFloat2) {
/* 151 */     paramFloat1 = this.x - paramFloat1;
/* 152 */     paramFloat2 = this.y - paramFloat2;
/* 153 */     return (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= this.radius * this.radius);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Vector2 paramVector2) {
/* 162 */     float f2 = this.x - paramVector2.x;
/* 163 */     float f1 = this.y - paramVector2.y;
/* 164 */     return (f2 * f2 + f1 * f1 <= this.radius * this.radius);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Circle paramCircle) {
/*     */     float f2;
/* 171 */     if ((f2 = this.radius - paramCircle.radius) < 0.0F) return false; 
/* 172 */     float f3 = this.x - paramCircle.x;
/* 173 */     float f4 = this.y - paramCircle.y;
/* 174 */     f3 = f3 * f3 + f4 * f4;
/* 175 */     float f1 = this.radius + paramCircle.radius;
/* 176 */     return (f2 * f2 >= f3 && f3 < f1 * f1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean overlaps(Circle paramCircle) {
/* 182 */     float f2 = this.x - paramCircle.x;
/* 183 */     float f3 = this.y - paramCircle.y;
/* 184 */     f2 = f2 * f2 + f3 * f3;
/* 185 */     float f1 = this.radius + paramCircle.radius;
/* 186 */     return (f2 < f1 * f1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 192 */     return this.x + "," + this.y + "," + this.radius;
/*     */   }
/*     */ 
/*     */   
/*     */   public float circumference() {
/* 197 */     return this.radius * 6.2831855F;
/*     */   }
/*     */ 
/*     */   
/*     */   public float area() {
/* 202 */     return this.radius * this.radius * 3.1415927F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 207 */     if (paramObject == this) return true; 
/* 208 */     if (paramObject == null || paramObject.getClass() != getClass()) return false; 
/* 209 */     paramObject = paramObject;
/* 210 */     return (this.x == ((Circle)paramObject).x && this.y == ((Circle)paramObject).y && this.radius == ((Circle)paramObject).radius);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 217 */     int i = 41 + NumberUtils.floatToRawIntBits(this.radius);
/* 218 */     i = i * 41 + NumberUtils.floatToRawIntBits(this.x);
/*     */     
/* 220 */     return i = i * 41 + NumberUtils.floatToRawIntBits(this.y);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Circle.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */