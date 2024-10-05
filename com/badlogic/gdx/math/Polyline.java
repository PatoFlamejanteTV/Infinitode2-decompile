/*     */ package com.badlogic.gdx.math;
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
/*     */ public class Polyline
/*     */   implements Shape2D
/*     */ {
/*     */   private float[] localVertices;
/*     */   private float[] worldVertices;
/*     */   private float x;
/*     */   private float y;
/*     */   private float originX;
/*     */   private float originY;
/*     */   private float rotation;
/*  25 */   private float scaleX = 1.0F; private float scaleY = 1.0F;
/*     */   private float length;
/*     */   private float scaledLength;
/*     */   private boolean calculateScaledLength = true;
/*     */   private boolean calculateLength = true;
/*     */   private boolean dirty = true;
/*     */   private Rectangle bounds;
/*     */   
/*     */   public Polyline() {
/*  34 */     this.localVertices = new float[0];
/*     */   }
/*     */   
/*     */   public Polyline(float[] paramArrayOffloat) {
/*  38 */     if (paramArrayOffloat.length < 4) throw new IllegalArgumentException("polylines must contain at least 2 points."); 
/*  39 */     this.localVertices = paramArrayOffloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getVertices() {
/*  44 */     return this.localVertices;
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getTransformedVertices() {
/*  49 */     if (!this.dirty) return this.worldVertices; 
/*  50 */     this.dirty = false;
/*     */     
/*  52 */     float[] arrayOfFloat1 = this.localVertices;
/*  53 */     if (this.worldVertices == null || this.worldVertices.length < arrayOfFloat1.length) this.worldVertices = new float[arrayOfFloat1.length];
/*     */     
/*  55 */     float[] arrayOfFloat2 = this.worldVertices;
/*  56 */     float f1 = this.x;
/*  57 */     float f2 = this.y;
/*  58 */     float f3 = this.originX;
/*  59 */     float f4 = this.originY;
/*  60 */     float f5 = this.scaleX;
/*  61 */     float f6 = this.scaleY;
/*  62 */     boolean bool = (f5 != 1.0F || f6 != 1.0F) ? true : false;
/*     */     
/*  64 */     float f7, f8 = MathUtils.cosDeg(f7 = this.rotation);
/*  65 */     float f9 = MathUtils.sinDeg(f7); byte b;
/*     */     int i;
/*  67 */     for (b = 0, i = arrayOfFloat1.length; b < i; b += 2) {
/*  68 */       float f10 = arrayOfFloat1[b] - f3;
/*  69 */       float f11 = arrayOfFloat1[b + 1] - f4;
/*     */ 
/*     */       
/*  72 */       if (bool) {
/*  73 */         f10 *= f5;
/*  74 */         f11 *= f6;
/*     */       } 
/*     */ 
/*     */       
/*  78 */       if (f7 != 0.0F) {
/*  79 */         float f = f10;
/*  80 */         f10 = f8 * f10 - f9 * f11;
/*  81 */         f11 = f9 * f + f8 * f11;
/*     */       } 
/*     */       
/*  84 */       arrayOfFloat2[b] = f1 + f10 + f3;
/*  85 */       arrayOfFloat2[b + 1] = f2 + f11 + f4;
/*     */     } 
/*  87 */     return arrayOfFloat2;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getLength() {
/*  92 */     if (!this.calculateLength) return this.length; 
/*  93 */     this.calculateLength = false;
/*     */     
/*  95 */     this.length = 0.0F; byte b; int i;
/*  96 */     for (b = 0, i = this.localVertices.length - 2; b < i; b += 2) {
/*  97 */       float f1 = this.localVertices[b + 2] - this.localVertices[b];
/*  98 */       float f2 = this.localVertices[b + 1] - this.localVertices[b + 3];
/*  99 */       this.length += (float)Math.sqrt((f1 * f1 + f2 * f2));
/*     */     } 
/*     */     
/* 102 */     return this.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScaledLength() {
/* 107 */     if (!this.calculateScaledLength) return this.scaledLength; 
/* 108 */     this.calculateScaledLength = false;
/*     */     
/* 110 */     this.scaledLength = 0.0F; byte b; int i;
/* 111 */     for (b = 0, i = this.localVertices.length - 2; b < i; b += 2) {
/* 112 */       float f1 = this.localVertices[b + 2] * this.scaleX - this.localVertices[b] * this.scaleX;
/* 113 */       float f2 = this.localVertices[b + 1] * this.scaleY - this.localVertices[b + 3] * this.scaleY;
/* 114 */       this.scaledLength += (float)Math.sqrt((f1 * f1 + f2 * f2));
/*     */     } 
/*     */     
/* 117 */     return this.scaledLength;
/*     */   }
/*     */   
/*     */   public float getX() {
/* 121 */     return this.x;
/*     */   }
/*     */   
/*     */   public float getY() {
/* 125 */     return this.y;
/*     */   }
/*     */   
/*     */   public float getOriginX() {
/* 129 */     return this.originX;
/*     */   }
/*     */   
/*     */   public float getOriginY() {
/* 133 */     return this.originY;
/*     */   }
/*     */   
/*     */   public float getRotation() {
/* 137 */     return this.rotation;
/*     */   }
/*     */   
/*     */   public float getScaleX() {
/* 141 */     return this.scaleX;
/*     */   }
/*     */   
/*     */   public float getScaleY() {
/* 145 */     return this.scaleY;
/*     */   }
/*     */   
/*     */   public void setOrigin(float paramFloat1, float paramFloat2) {
/* 149 */     this.originX = paramFloat1;
/* 150 */     this.originY = paramFloat2;
/* 151 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/* 155 */     this.x = paramFloat1;
/* 156 */     this.y = paramFloat2;
/* 157 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void setVertices(float[] paramArrayOffloat) {
/* 161 */     if (paramArrayOffloat.length < 4) throw new IllegalArgumentException("polylines must contain at least 2 points."); 
/* 162 */     this.localVertices = paramArrayOffloat;
/* 163 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void setRotation(float paramFloat) {
/* 167 */     this.rotation = paramFloat;
/* 168 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void rotate(float paramFloat) {
/* 172 */     this.rotation += paramFloat;
/* 173 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void setScale(float paramFloat1, float paramFloat2) {
/* 177 */     this.scaleX = paramFloat1;
/* 178 */     this.scaleY = paramFloat2;
/* 179 */     this.dirty = true;
/* 180 */     this.calculateScaledLength = true;
/*     */   }
/*     */   
/*     */   public void scale(float paramFloat) {
/* 184 */     this.scaleX += paramFloat;
/* 185 */     this.scaleY += paramFloat;
/* 186 */     this.dirty = true;
/* 187 */     this.calculateScaledLength = true;
/*     */   }
/*     */   
/*     */   public void calculateLength() {
/* 191 */     this.calculateLength = true;
/*     */   }
/*     */   
/*     */   public void calculateScaledLength() {
/* 195 */     this.calculateScaledLength = true;
/*     */   }
/*     */   
/*     */   public void dirty() {
/* 199 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void translate(float paramFloat1, float paramFloat2) {
/* 203 */     this.x += paramFloat1;
/* 204 */     this.y += paramFloat2;
/* 205 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getBoundingRectangle() {
/* 216 */     float arrayOfFloat[], f1 = (arrayOfFloat = getTransformedVertices())[0];
/* 217 */     float f2 = arrayOfFloat[1];
/* 218 */     float f3 = arrayOfFloat[0];
/* 219 */     float f4 = arrayOfFloat[1];
/*     */     
/* 221 */     int i = arrayOfFloat.length;
/* 222 */     for (byte b = 2; b < i; b += 2) {
/* 223 */       f1 = (f1 > arrayOfFloat[b]) ? arrayOfFloat[b] : f1;
/* 224 */       f2 = (f2 > arrayOfFloat[b + 1]) ? arrayOfFloat[b + 1] : f2;
/* 225 */       f3 = (f3 < arrayOfFloat[b]) ? arrayOfFloat[b] : f3;
/* 226 */       f4 = (f4 < arrayOfFloat[b + 1]) ? arrayOfFloat[b + 1] : f4;
/*     */     } 
/*     */     
/* 229 */     if (this.bounds == null) this.bounds = new Rectangle(); 
/* 230 */     this.bounds.x = f1;
/* 231 */     this.bounds.y = f2;
/* 232 */     this.bounds.width = f3 - f1;
/* 233 */     this.bounds.height = f4 - f2;
/*     */     
/* 235 */     return this.bounds;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Vector2 paramVector2) {
/* 240 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(float paramFloat1, float paramFloat2) {
/* 245 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Polyline.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */