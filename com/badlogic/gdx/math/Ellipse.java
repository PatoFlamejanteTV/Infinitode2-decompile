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
/*     */ 
/*     */ 
/*     */ public class Ellipse
/*     */   implements Shape2D, Serializable
/*     */ {
/*     */   public float x;
/*     */   public float y;
/*     */   public float width;
/*     */   public float height;
/*     */   private static final long serialVersionUID = 7381533206532032099L;
/*     */   
/*     */   public Ellipse() {}
/*     */   
/*     */   public Ellipse(Ellipse paramEllipse) {
/*  41 */     this.x = paramEllipse.x;
/*  42 */     this.y = paramEllipse.y;
/*  43 */     this.width = paramEllipse.width;
/*  44 */     this.height = paramEllipse.height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ellipse(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  54 */     this.x = paramFloat1;
/*  55 */     this.y = paramFloat2;
/*  56 */     this.width = paramFloat3;
/*  57 */     this.height = paramFloat4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ellipse(Vector2 paramVector2, float paramFloat1, float paramFloat2) {
/*  66 */     this.x = paramVector2.x;
/*  67 */     this.y = paramVector2.y;
/*  68 */     this.width = paramFloat1;
/*  69 */     this.height = paramFloat2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ellipse(Vector2 paramVector21, Vector2 paramVector22) {
/*  77 */     this.x = paramVector21.x;
/*  78 */     this.y = paramVector21.y;
/*  79 */     this.width = paramVector22.x;
/*  80 */     this.height = paramVector22.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ellipse(Circle paramCircle) {
/*  87 */     this.x = paramCircle.x;
/*  88 */     this.y = paramCircle.y;
/*  89 */     this.width = paramCircle.radius * 2.0F;
/*  90 */     this.height = paramCircle.radius * 2.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(float paramFloat1, float paramFloat2) {
/* 100 */     paramFloat1 -= this.x;
/* 101 */     paramFloat2 -= this.y;
/*     */     
/* 103 */     return (paramFloat1 * paramFloat1 / this.width * 0.5F * this.width * 0.5F + paramFloat2 * paramFloat2 / this.height * 0.5F * this.height * 0.5F <= 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Vector2 paramVector2) {
/* 112 */     return contains(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 122 */     this.x = paramFloat1;
/* 123 */     this.y = paramFloat2;
/* 124 */     this.width = paramFloat3;
/* 125 */     this.height = paramFloat4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Ellipse paramEllipse) {
/* 132 */     this.x = paramEllipse.x;
/* 133 */     this.y = paramEllipse.y;
/* 134 */     this.width = paramEllipse.width;
/* 135 */     this.height = paramEllipse.height;
/*     */   }
/*     */   
/*     */   public void set(Circle paramCircle) {
/* 139 */     this.x = paramCircle.x;
/* 140 */     this.y = paramCircle.y;
/* 141 */     this.width = paramCircle.radius * 2.0F;
/* 142 */     this.height = paramCircle.radius * 2.0F;
/*     */   }
/*     */   
/*     */   public void set(Vector2 paramVector21, Vector2 paramVector22) {
/* 146 */     this.x = paramVector21.x;
/* 147 */     this.y = paramVector21.y;
/* 148 */     this.width = paramVector22.x;
/* 149 */     this.height = paramVector22.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ellipse setPosition(Vector2 paramVector2) {
/* 156 */     this.x = paramVector2.x;
/* 157 */     this.y = paramVector2.y;
/*     */     
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ellipse setPosition(float paramFloat1, float paramFloat2) {
/* 167 */     this.x = paramFloat1;
/* 168 */     this.y = paramFloat2;
/*     */     
/* 170 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ellipse setSize(float paramFloat1, float paramFloat2) {
/* 178 */     this.width = paramFloat1;
/* 179 */     this.height = paramFloat2;
/*     */     
/* 181 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float area() {
/* 186 */     return 3.1415927F * this.width * this.height / 4.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float circumference() {
/* 194 */     float f1 = this.width / 2.0F;
/* 195 */     float f2 = this.height / 2.0F;
/* 196 */     if (f1 * 3.0F > f2 || f2 * 3.0F > f1)
/*     */     {
/* 198 */       return (float)(3.1415927410125732D * ((3.0F * (f1 + f2)) - Math.sqrt(((3.0F * f1 + f2) * (f1 + 3.0F * f2)))));
/*     */     }
/*     */     
/* 201 */     return (float)(6.2831854820251465D * Math.sqrt(((f1 * f1 + f2 * f2) / 2.0F)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 207 */     if (paramObject == this) return true; 
/* 208 */     if (paramObject == null || paramObject.getClass() != getClass()) return false; 
/* 209 */     paramObject = paramObject;
/* 210 */     return (this.x == ((Ellipse)paramObject).x && this.y == ((Ellipse)paramObject).y && this.width == ((Ellipse)paramObject).width && this.height == ((Ellipse)paramObject).height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 217 */     int i = 53 + NumberUtils.floatToRawIntBits(this.height);
/* 218 */     i = i * 53 + NumberUtils.floatToRawIntBits(this.width);
/* 219 */     i = i * 53 + NumberUtils.floatToRawIntBits(this.x);
/*     */     
/* 221 */     return i = i * 53 + NumberUtils.floatToRawIntBits(this.y);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Ellipse.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */