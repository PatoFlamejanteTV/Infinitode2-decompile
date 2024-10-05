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
/*     */ 
/*     */ public class Polygon
/*     */   implements Shape2D
/*     */ {
/*     */   private float[] localVertices;
/*     */   private float[] worldVertices;
/*     */   private float x;
/*     */   private float y;
/*     */   private float originX;
/*     */   private float originY;
/*     */   private float rotation;
/*  26 */   private float scaleX = 1.0F; private float scaleY = 1.0F;
/*     */   
/*     */   private boolean dirty = true;
/*     */   private Rectangle bounds;
/*     */   
/*     */   public Polygon() {
/*  32 */     this.localVertices = new float[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Polygon(float[] paramArrayOffloat) {
/*  42 */     if (paramArrayOffloat.length < 6) throw new IllegalArgumentException("polygons must contain at least 3 points."); 
/*  43 */     this.localVertices = paramArrayOffloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getVertices() {
/*  48 */     return this.localVertices;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] getTransformedVertices() {
/*  56 */     if (!this.dirty) return this.worldVertices; 
/*  57 */     this.dirty = false;
/*     */     
/*  59 */     float[] arrayOfFloat1 = this.localVertices;
/*  60 */     if (this.worldVertices == null || this.worldVertices.length != arrayOfFloat1.length) this.worldVertices = new float[arrayOfFloat1.length];
/*     */     
/*  62 */     float[] arrayOfFloat2 = this.worldVertices;
/*  63 */     float f1 = this.x;
/*  64 */     float f2 = this.y;
/*  65 */     float f3 = this.originX;
/*  66 */     float f4 = this.originY;
/*  67 */     float f5 = this.scaleX;
/*  68 */     float f6 = this.scaleY;
/*  69 */     boolean bool = (f5 != 1.0F || f6 != 1.0F) ? true : false;
/*     */     
/*  71 */     float f7, f8 = MathUtils.cosDeg(f7 = this.rotation);
/*  72 */     float f9 = MathUtils.sinDeg(f7); byte b;
/*     */     int i;
/*  74 */     for (b = 0, i = arrayOfFloat1.length; b < i; b += 2) {
/*  75 */       float f10 = arrayOfFloat1[b] - f3;
/*  76 */       float f11 = arrayOfFloat1[b + 1] - f4;
/*     */ 
/*     */       
/*  79 */       if (bool) {
/*  80 */         f10 *= f5;
/*  81 */         f11 *= f6;
/*     */       } 
/*     */ 
/*     */       
/*  85 */       if (f7 != 0.0F) {
/*  86 */         float f = f10;
/*  87 */         f10 = f8 * f10 - f9 * f11;
/*  88 */         f11 = f9 * f + f8 * f11;
/*     */       } 
/*     */       
/*  91 */       arrayOfFloat2[b] = f1 + f10 + f3;
/*  92 */       arrayOfFloat2[b + 1] = f2 + f11 + f4;
/*     */     } 
/*  94 */     return arrayOfFloat2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOrigin(float paramFloat1, float paramFloat2) {
/*  99 */     this.originX = paramFloat1;
/* 100 */     this.originY = paramFloat2;
/* 101 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/* 106 */     this.x = paramFloat1;
/* 107 */     this.y = paramFloat2;
/* 108 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVertices(float[] paramArrayOffloat) {
/* 118 */     if (paramArrayOffloat.length < 6) throw new IllegalArgumentException("polygons must contain at least 3 points."); 
/* 119 */     this.localVertices = paramArrayOffloat;
/* 120 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVertex(int paramInt, float paramFloat1, float paramFloat2) {
/* 127 */     if (paramInt < 0 || paramInt > this.localVertices.length / 2 - 1)
/* 128 */       throw new IllegalArgumentException("the vertex " + paramInt + " doesn't exist"); 
/* 129 */     this.localVertices[2 * paramInt] = paramFloat1;
/* 130 */     this.localVertices[2 * paramInt + 1] = paramFloat2;
/* 131 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void translate(float paramFloat1, float paramFloat2) {
/* 136 */     this.x += paramFloat1;
/* 137 */     this.y += paramFloat2;
/* 138 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotation(float paramFloat) {
/* 143 */     this.rotation = paramFloat;
/* 144 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(float paramFloat) {
/* 149 */     this.rotation += paramFloat;
/* 150 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScale(float paramFloat1, float paramFloat2) {
/* 155 */     this.scaleX = paramFloat1;
/* 156 */     this.scaleY = paramFloat2;
/* 157 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void scale(float paramFloat) {
/* 162 */     this.scaleX += paramFloat;
/* 163 */     this.scaleY += paramFloat;
/* 164 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dirty() {
/* 170 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public float area() {
/*     */     float[] arrayOfFloat;
/* 176 */     return GeometryUtils.polygonArea(arrayOfFloat = getTransformedVertices(), 0, arrayOfFloat.length);
/*     */   }
/*     */   
/*     */   public int getVertexCount() {
/* 180 */     return this.localVertices.length / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 getVertex(int paramInt, Vector2 paramVector2) {
/* 185 */     if (paramInt < 0 || paramInt > getVertexCount())
/* 186 */       throw new IllegalArgumentException("the vertex " + paramInt + " doesn't exist"); 
/* 187 */     float[] arrayOfFloat = getTransformedVertices();
/* 188 */     return paramVector2.set(arrayOfFloat[2 * paramInt], arrayOfFloat[2 * paramInt + 1]);
/*     */   }
/*     */   
/*     */   public Vector2 getCentroid(Vector2 paramVector2) {
/*     */     float[] arrayOfFloat;
/* 193 */     return GeometryUtils.polygonCentroid(arrayOfFloat = getTransformedVertices(), 0, arrayOfFloat.length, paramVector2);
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
/* 204 */     float arrayOfFloat[], f1 = (arrayOfFloat = getTransformedVertices())[0];
/* 205 */     float f2 = arrayOfFloat[1];
/* 206 */     float f3 = arrayOfFloat[0];
/* 207 */     float f4 = arrayOfFloat[1];
/*     */     
/* 209 */     int i = arrayOfFloat.length;
/* 210 */     for (byte b = 2; b < i; b += 2) {
/* 211 */       f1 = (f1 > arrayOfFloat[b]) ? arrayOfFloat[b] : f1;
/* 212 */       f2 = (f2 > arrayOfFloat[b + 1]) ? arrayOfFloat[b + 1] : f2;
/* 213 */       f3 = (f3 < arrayOfFloat[b]) ? arrayOfFloat[b] : f3;
/* 214 */       f4 = (f4 < arrayOfFloat[b + 1]) ? arrayOfFloat[b + 1] : f4;
/*     */     } 
/*     */     
/* 217 */     if (this.bounds == null) this.bounds = new Rectangle(); 
/* 218 */     this.bounds.x = f1;
/* 219 */     this.bounds.y = f2;
/* 220 */     this.bounds.width = f3 - f1;
/* 221 */     this.bounds.height = f4 - f2;
/*     */     
/* 223 */     return this.bounds;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(float paramFloat1, float paramFloat2) {
/*     */     float[] arrayOfFloat;
/* 230 */     int i = (arrayOfFloat = getTransformedVertices()).length;
/* 231 */     byte b1 = 0;
/*     */     
/* 233 */     for (byte b2 = 0; b2 < i; b2 += 2) {
/* 234 */       float f1 = arrayOfFloat[b2];
/* 235 */       float f2 = arrayOfFloat[b2 + 1];
/* 236 */       float f3 = arrayOfFloat[(b2 + 2) % i];
/* 237 */       float f4 = arrayOfFloat[(b2 + 3) % i];
/* 238 */       if (((f2 <= paramFloat2 && paramFloat2 < f4) || (f4 <= paramFloat2 && paramFloat2 < f2)) && paramFloat1 < (f3 - f1) / (f4 - f2) * (paramFloat2 - f2) + f1) b1++; 
/*     */     } 
/* 240 */     return ((b1 & 0x1) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Vector2 paramVector2) {
/* 245 */     return contains(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getX() {
/* 250 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getY() {
/* 255 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOriginX() {
/* 260 */     return this.originX;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getOriginY() {
/* 265 */     return this.originY;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRotation() {
/* 270 */     return this.rotation;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScaleX() {
/* 275 */     return this.scaleX;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScaleY() {
/* 280 */     return this.scaleY;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Polygon.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */