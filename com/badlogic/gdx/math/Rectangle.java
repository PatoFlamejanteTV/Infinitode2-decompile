/*     */ package com.badlogic.gdx.math;
/*     */ 
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*     */ public class Rectangle
/*     */   implements Shape2D, Serializable
/*     */ {
/*  26 */   public static final Rectangle tmp = new Rectangle();
/*     */ 
/*     */   
/*  29 */   public static final Rectangle tmp2 = new Rectangle();
/*     */   
/*     */   private static final long serialVersionUID = 5733252015138115702L;
/*     */   
/*     */   public float x;
/*     */   
/*     */   public float y;
/*     */   
/*     */   public float width;
/*     */   
/*     */   public float height;
/*     */ 
/*     */   
/*     */   public Rectangle() {}
/*     */ 
/*     */   
/*     */   public Rectangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  46 */     this.x = paramFloat1;
/*  47 */     this.y = paramFloat2;
/*  48 */     this.width = paramFloat3;
/*  49 */     this.height = paramFloat4;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle(Rectangle paramRectangle) {
/*  55 */     this.x = paramRectangle.x;
/*  56 */     this.y = paramRectangle.y;
/*  57 */     this.width = paramRectangle.width;
/*  58 */     this.height = paramRectangle.height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  67 */     this.x = paramFloat1;
/*  68 */     this.y = paramFloat2;
/*  69 */     this.width = paramFloat3;
/*  70 */     this.height = paramFloat4;
/*     */     
/*  72 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getX() {
/*  77 */     return this.x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle setX(float paramFloat) {
/*  84 */     this.x = paramFloat;
/*     */     
/*  86 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getY() {
/*  91 */     return this.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle setY(float paramFloat) {
/*  98 */     this.y = paramFloat;
/*     */     
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWidth() {
/* 105 */     return this.width;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle setWidth(float paramFloat) {
/* 112 */     this.width = paramFloat;
/*     */     
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getHeight() {
/* 119 */     return this.height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle setHeight(float paramFloat) {
/* 126 */     this.height = paramFloat;
/*     */     
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 getPosition(Vector2 paramVector2) {
/* 134 */     return paramVector2.set(this.x, this.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle setPosition(Vector2 paramVector2) {
/* 141 */     this.x = paramVector2.x;
/* 142 */     this.y = paramVector2.y;
/*     */     
/* 144 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle setPosition(float paramFloat1, float paramFloat2) {
/* 152 */     this.x = paramFloat1;
/* 153 */     this.y = paramFloat2;
/*     */     
/* 155 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle setSize(float paramFloat1, float paramFloat2) {
/* 163 */     this.width = paramFloat1;
/* 164 */     this.height = paramFloat2;
/*     */     
/* 166 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle setSize(float paramFloat) {
/* 173 */     this.width = paramFloat;
/* 174 */     this.height = paramFloat;
/*     */     
/* 176 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 getSize(Vector2 paramVector2) {
/* 182 */     return paramVector2.set(this.width, this.height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(float paramFloat1, float paramFloat2) {
/* 189 */     return (this.x <= paramFloat1 && this.x + this.width >= paramFloat1 && this.y <= paramFloat2 && this.y + this.height >= paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Vector2 paramVector2) {
/* 195 */     return contains(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Circle paramCircle) {
/* 201 */     return (paramCircle.x - paramCircle.radius >= this.x && paramCircle.x + paramCircle.radius <= this.x + this.width && paramCircle.y - paramCircle.radius >= this.y && paramCircle.y + paramCircle.radius <= this.y + this.height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Rectangle paramRectangle) {
/* 209 */     float f2, f3 = (f2 = paramRectangle.x) + paramRectangle.width;
/*     */ 
/*     */     
/* 212 */     float f4, f1 = (f4 = paramRectangle.y) + paramRectangle.height;
/*     */     
/* 214 */     return (f2 > this.x && f2 < this.x + this.width && f3 > this.x && f3 < this.x + this.width && f4 > this.y && f4 < this.y + this.height && f1 > this.y && f1 < this.y + this.height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean overlaps(Rectangle paramRectangle) {
/* 221 */     return (this.x < paramRectangle.x + paramRectangle.width && this.x + this.width > paramRectangle.x && this.y < paramRectangle.y + paramRectangle.height && this.y + this.height > paramRectangle.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle set(Rectangle paramRectangle) {
/* 228 */     this.x = paramRectangle.x;
/* 229 */     this.y = paramRectangle.y;
/* 230 */     this.width = paramRectangle.width;
/* 231 */     this.height = paramRectangle.height;
/*     */     
/* 233 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle merge(Rectangle paramRectangle) {
/* 240 */     float f2 = Math.min(this.x, paramRectangle.x);
/* 241 */     float f3 = Math.max(this.x + this.width, paramRectangle.x + paramRectangle.width);
/* 242 */     this.x = f2;
/* 243 */     this.width = f3 - f2;
/*     */     
/* 245 */     f2 = Math.min(this.y, paramRectangle.y);
/* 246 */     float f1 = Math.max(this.y + this.height, paramRectangle.y + paramRectangle.height);
/* 247 */     this.y = f2;
/* 248 */     this.height = f1 - f2;
/*     */     
/* 250 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle merge(float paramFloat1, float paramFloat2) {
/* 258 */     float f = Math.min(this.x, paramFloat1);
/* 259 */     paramFloat1 = Math.max(this.x + this.width, paramFloat1);
/* 260 */     this.x = f;
/* 261 */     this.width = paramFloat1 - f;
/*     */     
/* 263 */     paramFloat1 = Math.min(this.y, paramFloat2);
/* 264 */     paramFloat2 = Math.max(this.y + this.height, paramFloat2);
/* 265 */     this.y = paramFloat1;
/* 266 */     this.height = paramFloat2 - paramFloat1;
/*     */     
/* 268 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle merge(Vector2 paramVector2) {
/* 275 */     return merge(paramVector2.x, paramVector2.y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle merge(Vector2[] paramArrayOfVector2) {
/* 282 */     float f1 = this.x;
/* 283 */     float f2 = this.x + this.width;
/* 284 */     float f3 = this.y;
/* 285 */     float f4 = this.y + this.height;
/* 286 */     for (byte b = 0; b < paramArrayOfVector2.length; b++) {
/* 287 */       Vector2 vector2 = paramArrayOfVector2[b];
/* 288 */       f1 = Math.min(f1, vector2.x);
/* 289 */       f2 = Math.max(f2, vector2.x);
/* 290 */       f3 = Math.min(f3, vector2.y);
/* 291 */       f4 = Math.max(f4, vector2.y);
/*     */     } 
/* 293 */     this.x = f1;
/* 294 */     this.width = f2 - f1;
/* 295 */     this.y = f3;
/* 296 */     this.height = f4 - f3;
/* 297 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAspectRatio() {
/* 303 */     return (this.height == 0.0F) ? Float.NaN : (this.width / this.height);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 getCenter(Vector2 paramVector2) {
/* 310 */     paramVector2.x = this.x + this.width / 2.0F;
/* 311 */     paramVector2.y = this.y + this.height / 2.0F;
/* 312 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle setCenter(float paramFloat1, float paramFloat2) {
/* 320 */     setPosition(paramFloat1 - this.width / 2.0F, paramFloat2 - this.height / 2.0F);
/* 321 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle setCenter(Vector2 paramVector2) {
/* 328 */     setPosition(paramVector2.x - this.width / 2.0F, paramVector2.y - this.height / 2.0F);
/* 329 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle fitOutside(Rectangle paramRectangle) {
/*     */     float f;
/* 340 */     if ((f = getAspectRatio()) > paramRectangle.getAspectRatio()) {
/*     */       
/* 342 */       setSize(paramRectangle.height * f, paramRectangle.height);
/*     */     } else {
/*     */       
/* 345 */       setSize(paramRectangle.width, paramRectangle.width / f);
/*     */     } 
/*     */     
/* 348 */     setPosition(paramRectangle.x + paramRectangle.width / 2.0F - this.width / 2.0F, paramRectangle.y + paramRectangle.height / 2.0F - this.height / 2.0F);
/* 349 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle fitInside(Rectangle paramRectangle) {
/*     */     float f;
/* 360 */     if ((f = getAspectRatio()) < paramRectangle.getAspectRatio()) {
/*     */       
/* 362 */       setSize(paramRectangle.height * f, paramRectangle.height);
/*     */     } else {
/*     */       
/* 365 */       setSize(paramRectangle.width, paramRectangle.width / f);
/*     */     } 
/*     */     
/* 368 */     setPosition(paramRectangle.x + paramRectangle.width / 2.0F - this.width / 2.0F, paramRectangle.y + paramRectangle.height / 2.0F - this.height / 2.0F);
/* 369 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 375 */     return "[" + this.x + "," + this.y + "," + this.width + "," + this.height + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle fromString(String paramString) {
/* 383 */     int i = paramString.indexOf(',', 1);
/* 384 */     int j = paramString.indexOf(',', i + 1);
/* 385 */     int k = paramString.indexOf(',', j + 1);
/* 386 */     if (i != -1 && j != -1 && k != -1 && paramString.charAt(0) == '[' && paramString.charAt(paramString.length() - 1) == ']') {
/*     */       try {
/* 388 */         float f4 = Float.parseFloat(paramString.substring(1, i));
/* 389 */         float f1 = Float.parseFloat(paramString.substring(i + 1, j));
/* 390 */         float f2 = Float.parseFloat(paramString.substring(j + 1, k));
/* 391 */         float f3 = Float.parseFloat(paramString.substring(k + 1, paramString.length() - 1));
/* 392 */         return set(f4, f1, f2, f3);
/* 393 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */     
/* 397 */     throw new GdxRuntimeException("Malformed Rectangle: " + paramString);
/*     */   }
/*     */   
/*     */   public float area() {
/* 401 */     return this.width * this.height;
/*     */   }
/*     */   
/*     */   public float perimeter() {
/* 405 */     return 2.0F * (this.width + this.height);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 411 */     int i = 31 + NumberUtils.floatToRawIntBits(this.height);
/* 412 */     i = i * 31 + NumberUtils.floatToRawIntBits(this.width);
/* 413 */     i = i * 31 + NumberUtils.floatToRawIntBits(this.x);
/*     */     
/* 415 */     return i = i * 31 + NumberUtils.floatToRawIntBits(this.y);
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 419 */     if (this == paramObject) return true; 
/* 420 */     if (paramObject == null) return false; 
/* 421 */     if (getClass() != paramObject.getClass()) return false; 
/* 422 */     paramObject = paramObject;
/* 423 */     if (NumberUtils.floatToRawIntBits(this.height) != NumberUtils.floatToRawIntBits(((Rectangle)paramObject).height)) return false; 
/* 424 */     if (NumberUtils.floatToRawIntBits(this.width) != NumberUtils.floatToRawIntBits(((Rectangle)paramObject).width)) return false; 
/* 425 */     if (NumberUtils.floatToRawIntBits(this.x) != NumberUtils.floatToRawIntBits(((Rectangle)paramObject).x)) return false; 
/* 426 */     if (NumberUtils.floatToRawIntBits(this.y) != NumberUtils.floatToRawIntBits(((Rectangle)paramObject).y)) return false; 
/* 427 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\Rectangle.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */