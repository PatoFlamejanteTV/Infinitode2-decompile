/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Rectangle;
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
/*     */ public class PolygonSprite
/*     */ {
/*     */   PolygonRegion region;
/*     */   private float x;
/*     */   private float y;
/*     */   private float width;
/*     */   private float height;
/*  29 */   private float scaleX = 1.0F; private float scaleY = 1.0F; private float rotation;
/*     */   private float originX;
/*     */   private float originY;
/*     */   private float[] vertices;
/*     */   private boolean dirty;
/*  34 */   private Rectangle bounds = new Rectangle();
/*  35 */   private final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   
/*     */   public PolygonSprite(PolygonRegion paramPolygonRegion) {
/*  38 */     setRegion(paramPolygonRegion);
/*  39 */     setSize(paramPolygonRegion.region.regionWidth, paramPolygonRegion.region.regionHeight);
/*  40 */     setOrigin(this.width / 2.0F, this.height / 2.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public PolygonSprite(PolygonSprite paramPolygonSprite) {
/*  45 */     set(paramPolygonSprite);
/*     */   }
/*     */   
/*     */   public void set(PolygonSprite paramPolygonSprite) {
/*  49 */     if (paramPolygonSprite == null) throw new IllegalArgumentException("sprite cannot be null.");
/*     */     
/*  51 */     setRegion(paramPolygonSprite.region);
/*     */     
/*  53 */     this.x = paramPolygonSprite.x;
/*  54 */     this.y = paramPolygonSprite.y;
/*  55 */     this.width = paramPolygonSprite.width;
/*  56 */     this.height = paramPolygonSprite.height;
/*  57 */     this.originX = paramPolygonSprite.originX;
/*  58 */     this.originY = paramPolygonSprite.originY;
/*  59 */     this.rotation = paramPolygonSprite.rotation;
/*  60 */     this.scaleX = paramPolygonSprite.scaleX;
/*  61 */     this.scaleY = paramPolygonSprite.scaleY;
/*  62 */     this.color.set(paramPolygonSprite.color);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  68 */     this.x = paramFloat1;
/*  69 */     this.y = paramFloat2;
/*  70 */     this.width = paramFloat3;
/*  71 */     this.height = paramFloat4;
/*     */     
/*  73 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSize(float paramFloat1, float paramFloat2) {
/*  80 */     this.width = paramFloat1;
/*  81 */     this.height = paramFloat2;
/*     */     
/*  83 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/*  90 */     translate(paramFloat1 - this.x, paramFloat2 - this.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(float paramFloat) {
/*  97 */     translateX(paramFloat - this.x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(float paramFloat) {
/* 104 */     translateY(paramFloat - this.y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void translateX(float paramFloat) {
/* 110 */     this.x += paramFloat;
/*     */     
/* 112 */     if (this.dirty)
/*     */       return; 
/* 114 */     float[] arrayOfFloat = this.vertices;
/* 115 */     for (byte b = 0; b < arrayOfFloat.length; b += 5) {
/* 116 */       arrayOfFloat[b] = arrayOfFloat[b] + paramFloat;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void translateY(float paramFloat) {
/* 122 */     this.y += paramFloat;
/*     */     
/* 124 */     if (this.dirty)
/*     */       return; 
/* 126 */     float[] arrayOfFloat = this.vertices;
/* 127 */     for (byte b = 1; b < arrayOfFloat.length; b += 5) {
/* 128 */       arrayOfFloat[b] = arrayOfFloat[b] + paramFloat;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void translate(float paramFloat1, float paramFloat2) {
/* 134 */     this.x += paramFloat1;
/* 135 */     this.y += paramFloat2;
/*     */     
/* 137 */     if (this.dirty)
/*     */       return; 
/* 139 */     float[] arrayOfFloat = this.vertices;
/* 140 */     for (byte b = 0; b < arrayOfFloat.length; b += 5) {
/* 141 */       arrayOfFloat[b] = arrayOfFloat[b] + paramFloat1;
/* 142 */       arrayOfFloat[b + 1] = arrayOfFloat[b + 1] + paramFloat2;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 147 */     this.color.set(paramColor);
/* 148 */     float f = paramColor.toFloatBits();
/*     */     
/* 150 */     float[] arrayOfFloat = this.vertices;
/* 151 */     for (byte b = 2; b < arrayOfFloat.length; b += 5)
/* 152 */       arrayOfFloat[b] = f; 
/*     */   }
/*     */   
/*     */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 156 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 157 */     paramFloat1 = this.color.toFloatBits();
/* 158 */     float[] arrayOfFloat = this.vertices;
/* 159 */     for (byte b = 2; b < arrayOfFloat.length; b += 5) {
/* 160 */       arrayOfFloat[b] = paramFloat1;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setOrigin(float paramFloat1, float paramFloat2) {
/* 165 */     this.originX = paramFloat1;
/* 166 */     this.originY = paramFloat2;
/* 167 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void setRotation(float paramFloat) {
/* 171 */     this.rotation = paramFloat;
/* 172 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rotate(float paramFloat) {
/* 177 */     this.rotation += paramFloat;
/* 178 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void setScale(float paramFloat) {
/* 182 */     this.scaleX = paramFloat;
/* 183 */     this.scaleY = paramFloat;
/* 184 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void setScale(float paramFloat1, float paramFloat2) {
/* 188 */     this.scaleX = paramFloat1;
/* 189 */     this.scaleY = paramFloat2;
/* 190 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void scale(float paramFloat) {
/* 195 */     this.scaleX += paramFloat;
/* 196 */     this.scaleY += paramFloat;
/* 197 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getVertices() {
/* 202 */     if (!this.dirty) return this.vertices; 
/* 203 */     this.dirty = false;
/*     */     
/* 205 */     float f1 = this.originX;
/* 206 */     float f2 = this.originY;
/* 207 */     float f3 = this.scaleX;
/* 208 */     float f4 = this.scaleY;
/* 209 */     PolygonRegion polygonRegion = this.region;
/* 210 */     float[] arrayOfFloat1 = this.vertices;
/* 211 */     float[] arrayOfFloat2 = polygonRegion.vertices;
/*     */     
/* 213 */     float f6 = this.x + f1;
/* 214 */     float f7 = this.y + f2;
/* 215 */     float f8 = this.width / polygonRegion.region.getRegionWidth();
/* 216 */     float f5 = this.height / polygonRegion.region.getRegionHeight();
/* 217 */     float f9 = MathUtils.cosDeg(this.rotation);
/* 218 */     float f10 = MathUtils.sinDeg(this.rotation);
/*     */     byte b1, b2;
/*     */     int i;
/* 221 */     for (b1 = 0, b2 = 0, i = arrayOfFloat2.length; b1 < i; b1 += 2, b2 += 5) {
/* 222 */       float f11 = (arrayOfFloat2[b1] * f8 - f1) * f3;
/* 223 */       float f12 = (arrayOfFloat2[b1 + 1] * f5 - f2) * f4;
/* 224 */       arrayOfFloat1[b2] = f9 * f11 - f10 * f12 + f6;
/* 225 */       arrayOfFloat1[b2 + 1] = f10 * f11 + f9 * f12 + f7;
/*     */     } 
/* 227 */     return arrayOfFloat1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getBoundingRectangle() {
/* 237 */     float arrayOfFloat[], f1 = (arrayOfFloat = getVertices())[0];
/* 238 */     float f2 = arrayOfFloat[1];
/* 239 */     float f3 = arrayOfFloat[0];
/* 240 */     float f4 = arrayOfFloat[1];
/*     */     
/* 242 */     for (byte b = 5; b < arrayOfFloat.length; b += 5) {
/* 243 */       float f5 = arrayOfFloat[b];
/* 244 */       float f6 = arrayOfFloat[b + 1];
/* 245 */       f1 = (f1 > f5) ? f5 : f1;
/* 246 */       f3 = (f3 < f5) ? f5 : f3;
/* 247 */       f2 = (f2 > f6) ? f6 : f2;
/* 248 */       f4 = (f4 < f6) ? f6 : f4;
/*     */     } 
/*     */     
/* 251 */     this.bounds.x = f1;
/* 252 */     this.bounds.y = f2;
/* 253 */     this.bounds.width = f3 - f1;
/* 254 */     this.bounds.height = f4 - f2;
/* 255 */     return this.bounds;
/*     */   }
/*     */   
/*     */   public void draw(PolygonSpriteBatch paramPolygonSpriteBatch) {
/* 259 */     PolygonRegion polygonRegion = this.region;
/* 260 */     paramPolygonSpriteBatch.draw(polygonRegion.region.texture, getVertices(), 0, this.vertices.length, polygonRegion.triangles, 0, polygonRegion.triangles.length);
/*     */   }
/*     */   
/*     */   public void draw(PolygonSpriteBatch paramPolygonSpriteBatch, float paramFloat) {
/*     */     Color color;
/* 265 */     float f = (color = getColor()).a;
/* 266 */     color.a *= paramFloat;
/* 267 */     setColor(color);
/* 268 */     draw(paramPolygonSpriteBatch);
/* 269 */     color.a = f;
/* 270 */     setColor(color);
/*     */   }
/*     */   
/*     */   public float getX() {
/* 274 */     return this.x;
/*     */   }
/*     */   
/*     */   public float getY() {
/* 278 */     return this.y;
/*     */   }
/*     */   
/*     */   public float getWidth() {
/* 282 */     return this.width;
/*     */   }
/*     */   
/*     */   public float getHeight() {
/* 286 */     return this.height;
/*     */   }
/*     */   
/*     */   public float getOriginX() {
/* 290 */     return this.originX;
/*     */   }
/*     */   
/*     */   public float getOriginY() {
/* 294 */     return this.originY;
/*     */   }
/*     */   
/*     */   public float getRotation() {
/* 298 */     return this.rotation;
/*     */   }
/*     */   
/*     */   public float getScaleX() {
/* 302 */     return this.scaleX;
/*     */   }
/*     */   
/*     */   public float getScaleY() {
/* 306 */     return this.scaleY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getColor() {
/* 312 */     return this.color;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getPackedColor() {
/* 319 */     Color.abgr8888ToColor(this.color, this.vertices[2]);
/* 320 */     return this.color;
/*     */   }
/*     */   
/*     */   public void setRegion(PolygonRegion paramPolygonRegion) {
/* 324 */     this.region = paramPolygonRegion;
/*     */     
/* 326 */     float[] arrayOfFloat2 = paramPolygonRegion.vertices;
/* 327 */     float[] arrayOfFloat1 = paramPolygonRegion.textureCoords;
/*     */     
/* 329 */     int i = arrayOfFloat2.length / 2 * 5;
/* 330 */     if (this.vertices == null || this.vertices.length != i) this.vertices = new float[i];
/*     */ 
/*     */     
/* 333 */     float f = this.color.toFloatBits();
/* 334 */     float[] arrayOfFloat3 = this.vertices;
/* 335 */     for (byte b1 = 0, b2 = 2; b2 < i; b1 += 2, b2 += 5) {
/* 336 */       arrayOfFloat3[b2] = f;
/* 337 */       arrayOfFloat3[b2 + 1] = arrayOfFloat1[b1];
/* 338 */       arrayOfFloat3[b2 + 2] = arrayOfFloat1[b1 + 1];
/*     */     } 
/*     */     
/* 341 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public PolygonRegion getRegion() {
/* 345 */     return this.region;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\PolygonSprite.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */