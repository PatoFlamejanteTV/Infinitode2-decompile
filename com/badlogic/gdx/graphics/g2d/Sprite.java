/*     */ package com.badlogic.gdx.graphics.g2d;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
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
/*     */ public class Sprite
/*     */   extends TextureRegion
/*     */ {
/*     */   static final int VERTEX_SIZE = 5;
/*     */   static final int SPRITE_SIZE = 20;
/*  38 */   final float[] vertices = new float[20];
/*  39 */   private final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F); private float x; private float y; float width; float height;
/*  40 */   private float packedColor = Color.WHITE_FLOAT_BITS;
/*     */   
/*     */   private float originX;
/*     */   private float originY;
/*     */   private float rotation;
/*  45 */   private float scaleX = 1.0F; private float scaleY = 1.0F;
/*     */   
/*     */   private boolean dirty = true;
/*     */   private Rectangle bounds;
/*     */   
/*     */   public Sprite() {
/*  51 */     setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public Sprite(Texture paramTexture) {
/*  56 */     this(paramTexture, 0, 0, paramTexture.getWidth(), paramTexture.getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sprite(Texture paramTexture, int paramInt1, int paramInt2) {
/*  64 */     this(paramTexture, 0, 0, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sprite(Texture paramTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  71 */     if (paramTexture == null) throw new IllegalArgumentException("texture cannot be null."); 
/*  72 */     this.texture = paramTexture;
/*  73 */     setRegion(paramInt1, paramInt2, paramInt3, paramInt4);
/*  74 */     setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*  75 */     setSize(Math.abs(paramInt3), Math.abs(paramInt4));
/*  76 */     setOrigin(this.width / 2.0F, this.height / 2.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sprite(TextureRegion paramTextureRegion) {
/*  83 */     setRegion(paramTextureRegion);
/*  84 */     setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*  85 */     setSize(paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight());
/*  86 */     setOrigin(this.width / 2.0F, this.height / 2.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sprite(TextureRegion paramTextureRegion, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  94 */     setRegion(paramTextureRegion, paramInt1, paramInt2, paramInt3, paramInt4);
/*  95 */     setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*  96 */     setSize(Math.abs(paramInt3), Math.abs(paramInt4));
/*  97 */     setOrigin(this.width / 2.0F, this.height / 2.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public Sprite(Sprite paramSprite) {
/* 102 */     set(paramSprite);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Sprite paramSprite) {
/* 107 */     if (paramSprite == null) throw new IllegalArgumentException("sprite cannot be null."); 
/* 108 */     System.arraycopy(paramSprite.vertices, 0, this.vertices, 0, 20);
/* 109 */     this.texture = paramSprite.texture;
/* 110 */     this.u = paramSprite.u;
/* 111 */     this.v = paramSprite.v;
/* 112 */     this.u2 = paramSprite.u2;
/* 113 */     this.v2 = paramSprite.v2;
/* 114 */     this.x = paramSprite.x;
/* 115 */     this.y = paramSprite.y;
/* 116 */     this.width = paramSprite.width;
/* 117 */     this.height = paramSprite.height;
/* 118 */     this.regionWidth = paramSprite.regionWidth;
/* 119 */     this.regionHeight = paramSprite.regionHeight;
/* 120 */     this.originX = paramSprite.originX;
/* 121 */     this.originY = paramSprite.originY;
/* 122 */     this.rotation = paramSprite.rotation;
/* 123 */     this.scaleX = paramSprite.scaleX;
/* 124 */     this.scaleY = paramSprite.scaleY;
/* 125 */     this.color.set(paramSprite.color);
/* 126 */     this.dirty = paramSprite.dirty;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 132 */     this.x = paramFloat1;
/* 133 */     this.y = paramFloat2;
/* 134 */     this.width = paramFloat3;
/* 135 */     this.height = paramFloat4;
/*     */     
/* 137 */     if (this.dirty)
/* 138 */       return;  if (this.rotation != 0.0F || this.scaleX != 1.0F || this.scaleY != 1.0F) {
/* 139 */       this.dirty = true;
/*     */       
/*     */       return;
/*     */     } 
/* 143 */     paramFloat3 = paramFloat1 + paramFloat3;
/* 144 */     paramFloat4 = paramFloat2 + paramFloat4;
/*     */     float[] arrayOfFloat;
/* 146 */     (arrayOfFloat = this.vertices)[0] = paramFloat1;
/* 147 */     arrayOfFloat[1] = paramFloat2;
/*     */     
/* 149 */     arrayOfFloat[5] = paramFloat1;
/* 150 */     arrayOfFloat[6] = paramFloat4;
/*     */     
/* 152 */     arrayOfFloat[10] = paramFloat3;
/* 153 */     arrayOfFloat[11] = paramFloat4;
/*     */     
/* 155 */     arrayOfFloat[15] = paramFloat3;
/* 156 */     arrayOfFloat[16] = paramFloat2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSize(float paramFloat1, float paramFloat2) {
/* 163 */     this.width = paramFloat1;
/* 164 */     this.height = paramFloat2;
/*     */     
/* 166 */     if (this.dirty)
/* 167 */       return;  if (this.rotation != 0.0F || this.scaleX != 1.0F || this.scaleY != 1.0F) {
/* 168 */       this.dirty = true;
/*     */       
/*     */       return;
/*     */     } 
/* 172 */     paramFloat1 = this.x + paramFloat1;
/* 173 */     paramFloat2 = this.y + paramFloat2;
/*     */     float[] arrayOfFloat;
/* 175 */     (arrayOfFloat = this.vertices)[0] = this.x;
/* 176 */     arrayOfFloat[1] = this.y;
/*     */     
/* 178 */     arrayOfFloat[5] = this.x;
/* 179 */     arrayOfFloat[6] = paramFloat2;
/*     */     
/* 181 */     arrayOfFloat[10] = paramFloat1;
/* 182 */     arrayOfFloat[11] = paramFloat2;
/*     */     
/* 184 */     arrayOfFloat[15] = paramFloat1;
/* 185 */     arrayOfFloat[16] = this.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/* 192 */     this.x = paramFloat1;
/* 193 */     this.y = paramFloat2;
/*     */     
/* 195 */     if (this.dirty)
/* 196 */       return;  if (this.rotation != 0.0F || this.scaleX != 1.0F || this.scaleY != 1.0F) {
/* 197 */       this.dirty = true;
/*     */       
/*     */       return;
/*     */     } 
/* 201 */     float f1 = paramFloat1 + this.width;
/* 202 */     float f2 = paramFloat2 + this.height;
/*     */     float[] arrayOfFloat;
/* 204 */     (arrayOfFloat = this.vertices)[0] = paramFloat1;
/* 205 */     arrayOfFloat[1] = paramFloat2;
/*     */     
/* 207 */     arrayOfFloat[5] = paramFloat1;
/* 208 */     arrayOfFloat[6] = f2;
/*     */     
/* 210 */     arrayOfFloat[10] = f1;
/* 211 */     arrayOfFloat[11] = f2;
/*     */     
/* 213 */     arrayOfFloat[15] = f1;
/* 214 */     arrayOfFloat[16] = paramFloat2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOriginBasedPosition(float paramFloat1, float paramFloat2) {
/* 219 */     setPosition(paramFloat1 - this.originX, paramFloat2 - this.originY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(float paramFloat) {
/* 226 */     this.x = paramFloat;
/*     */     
/* 228 */     if (this.dirty)
/* 229 */       return;  if (this.rotation != 0.0F || this.scaleX != 1.0F || this.scaleY != 1.0F) {
/* 230 */       this.dirty = true;
/*     */       
/*     */       return;
/*     */     } 
/* 234 */     float f = paramFloat + this.width;
/*     */     float[] arrayOfFloat;
/* 236 */     (arrayOfFloat = this.vertices)[0] = paramFloat;
/* 237 */     arrayOfFloat[5] = paramFloat;
/* 238 */     arrayOfFloat[10] = f;
/* 239 */     arrayOfFloat[15] = f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(float paramFloat) {
/* 246 */     this.y = paramFloat;
/*     */     
/* 248 */     if (this.dirty)
/* 249 */       return;  if (this.rotation != 0.0F || this.scaleX != 1.0F || this.scaleY != 1.0F) {
/* 250 */       this.dirty = true;
/*     */       
/*     */       return;
/*     */     } 
/* 254 */     float f = paramFloat + this.height;
/*     */     float[] arrayOfFloat;
/* 256 */     (arrayOfFloat = this.vertices)[1] = paramFloat;
/* 257 */     arrayOfFloat[6] = f;
/* 258 */     arrayOfFloat[11] = f;
/* 259 */     arrayOfFloat[16] = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCenterX(float paramFloat) {
/* 264 */     setX(paramFloat - this.width / 2.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCenterY(float paramFloat) {
/* 269 */     setY(paramFloat - this.height / 2.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCenter(float paramFloat1, float paramFloat2) {
/* 274 */     setPosition(paramFloat1 - this.width / 2.0F, paramFloat2 - this.height / 2.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void translateX(float paramFloat) {
/* 280 */     this.x += paramFloat;
/*     */     
/* 282 */     if (this.dirty)
/* 283 */       return;  if (this.rotation != 0.0F || this.scaleX != 1.0F || this.scaleY != 1.0F) {
/* 284 */       this.dirty = true;
/*     */       
/*     */       return;
/*     */     } 
/*     */     float[] arrayOfFloat;
/* 289 */     (arrayOfFloat = this.vertices)[0] = (arrayOfFloat = this.vertices)[0] + paramFloat;
/* 290 */     arrayOfFloat[5] = arrayOfFloat[5] + paramFloat;
/* 291 */     arrayOfFloat[10] = arrayOfFloat[10] + paramFloat;
/* 292 */     arrayOfFloat[15] = arrayOfFloat[15] + paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void translateY(float paramFloat) {
/* 298 */     this.y += paramFloat;
/*     */     
/* 300 */     if (this.dirty)
/* 301 */       return;  if (this.rotation != 0.0F || this.scaleX != 1.0F || this.scaleY != 1.0F) {
/* 302 */       this.dirty = true;
/*     */       
/*     */       return;
/*     */     } 
/*     */     float[] arrayOfFloat;
/* 307 */     (arrayOfFloat = this.vertices)[1] = (arrayOfFloat = this.vertices)[1] + paramFloat;
/* 308 */     arrayOfFloat[6] = arrayOfFloat[6] + paramFloat;
/* 309 */     arrayOfFloat[11] = arrayOfFloat[11] + paramFloat;
/* 310 */     arrayOfFloat[16] = arrayOfFloat[16] + paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void translate(float paramFloat1, float paramFloat2) {
/* 316 */     this.x += paramFloat1;
/* 317 */     this.y += paramFloat2;
/*     */     
/* 319 */     if (this.dirty)
/* 320 */       return;  if (this.rotation != 0.0F || this.scaleX != 1.0F || this.scaleY != 1.0F) {
/* 321 */       this.dirty = true;
/*     */       
/*     */       return;
/*     */     } 
/*     */     float[] arrayOfFloat;
/* 326 */     (arrayOfFloat = this.vertices)[0] = (arrayOfFloat = this.vertices)[0] + paramFloat1;
/* 327 */     arrayOfFloat[1] = arrayOfFloat[1] + paramFloat2;
/*     */     
/* 329 */     arrayOfFloat[5] = arrayOfFloat[5] + paramFloat1;
/* 330 */     arrayOfFloat[6] = arrayOfFloat[6] + paramFloat2;
/*     */     
/* 332 */     arrayOfFloat[10] = arrayOfFloat[10] + paramFloat1;
/* 333 */     arrayOfFloat[11] = arrayOfFloat[11] + paramFloat2;
/*     */     
/* 335 */     arrayOfFloat[15] = arrayOfFloat[15] + paramFloat1;
/* 336 */     arrayOfFloat[16] = arrayOfFloat[16] + paramFloat2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(Color paramColor) {
/* 341 */     this.color.set(paramColor);
/* 342 */     this.packedColor = paramColor.toFloatBits();
/*     */     float[] arrayOfFloat;
/* 344 */     (arrayOfFloat = this.vertices)[2] = this.packedColor;
/* 345 */     arrayOfFloat[7] = this.packedColor;
/* 346 */     arrayOfFloat[12] = this.packedColor;
/* 347 */     arrayOfFloat[17] = this.packedColor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAlpha(float paramFloat) {
/* 352 */     if (this.color.a != paramFloat) {
/* 353 */       this.color.a = paramFloat;
/* 354 */       this.packedColor = this.color.toFloatBits();
/* 355 */       this.vertices[2] = this.packedColor;
/* 356 */       this.vertices[7] = this.packedColor;
/* 357 */       this.vertices[12] = this.packedColor;
/* 358 */       this.vertices[17] = this.packedColor;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 364 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 365 */     this.packedColor = this.color.toFloatBits();
/*     */     float[] arrayOfFloat;
/* 367 */     (arrayOfFloat = this.vertices)[2] = this.packedColor;
/* 368 */     arrayOfFloat[7] = this.packedColor;
/* 369 */     arrayOfFloat[12] = this.packedColor;
/* 370 */     arrayOfFloat[17] = this.packedColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPackedColor(float paramFloat) {
/* 378 */     if (paramFloat != this.packedColor || (paramFloat == 0.0F && this.packedColor == 0.0F && 
/* 379 */       Float.floatToIntBits(paramFloat) != Float.floatToIntBits(this.packedColor))) {
/* 380 */       this.packedColor = paramFloat;
/* 381 */       Color.abgr8888ToColor(this.color, paramFloat);
/*     */       float[] arrayOfFloat;
/* 383 */       (arrayOfFloat = this.vertices)[2] = paramFloat;
/* 384 */       arrayOfFloat[7] = paramFloat;
/* 385 */       arrayOfFloat[12] = paramFloat;
/* 386 */       arrayOfFloat[17] = paramFloat;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOrigin(float paramFloat1, float paramFloat2) {
/* 392 */     this.originX = paramFloat1;
/* 393 */     this.originY = paramFloat2;
/* 394 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOriginCenter() {
/* 399 */     this.originX = this.width / 2.0F;
/* 400 */     this.originY = this.height / 2.0F;
/* 401 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotation(float paramFloat) {
/* 406 */     this.rotation = paramFloat;
/* 407 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getRotation() {
/* 412 */     return this.rotation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotate(float paramFloat) {
/* 418 */     if (paramFloat == 0.0F)
/* 419 */       return;  this.rotation += paramFloat;
/* 420 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotate90(boolean paramBoolean) {
/* 426 */     float[] arrayOfFloat = this.vertices;
/*     */     
/* 428 */     if (paramBoolean) {
/* 429 */       float f1 = arrayOfFloat[4];
/* 430 */       arrayOfFloat[4] = arrayOfFloat[19];
/* 431 */       arrayOfFloat[19] = arrayOfFloat[14];
/* 432 */       arrayOfFloat[14] = arrayOfFloat[9];
/* 433 */       arrayOfFloat[9] = f1;
/*     */       
/* 435 */       f1 = arrayOfFloat[3];
/* 436 */       arrayOfFloat[3] = arrayOfFloat[18];
/* 437 */       arrayOfFloat[18] = arrayOfFloat[13];
/* 438 */       arrayOfFloat[13] = arrayOfFloat[8];
/* 439 */       arrayOfFloat[8] = f1; return;
/*     */     } 
/* 441 */     float f = arrayOfFloat[4];
/* 442 */     arrayOfFloat[4] = arrayOfFloat[9];
/* 443 */     arrayOfFloat[9] = arrayOfFloat[14];
/* 444 */     arrayOfFloat[14] = arrayOfFloat[19];
/* 445 */     arrayOfFloat[19] = f;
/*     */     
/* 447 */     f = arrayOfFloat[3];
/* 448 */     arrayOfFloat[3] = arrayOfFloat[8];
/* 449 */     arrayOfFloat[8] = arrayOfFloat[13];
/* 450 */     arrayOfFloat[13] = arrayOfFloat[18];
/* 451 */     arrayOfFloat[18] = f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScale(float paramFloat) {
/* 458 */     this.scaleX = paramFloat;
/* 459 */     this.scaleY = paramFloat;
/* 460 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScale(float paramFloat1, float paramFloat2) {
/* 466 */     this.scaleX = paramFloat1;
/* 467 */     this.scaleY = paramFloat2;
/* 468 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void scale(float paramFloat) {
/* 475 */     this.scaleX += paramFloat;
/* 476 */     this.scaleY += paramFloat;
/* 477 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] getVertices() {
/* 482 */     if (this.dirty) {
/* 483 */       this.dirty = false;
/*     */       
/* 485 */       float[] arrayOfFloat = this.vertices;
/* 486 */       float f1 = -this.originX;
/* 487 */       float f2 = -this.originY;
/* 488 */       float f3 = f1 + this.width;
/* 489 */       float f4 = f2 + this.height;
/* 490 */       float f5 = this.x - f1;
/* 491 */       float f6 = this.y - f2;
/* 492 */       if (this.scaleX != 1.0F || this.scaleY != 1.0F) {
/* 493 */         f1 *= this.scaleX;
/* 494 */         f2 *= this.scaleY;
/* 495 */         f3 *= this.scaleX;
/* 496 */         f4 *= this.scaleY;
/*     */       } 
/* 498 */       if (this.rotation != 0.0F) {
/* 499 */         float f7 = MathUtils.cosDeg(this.rotation);
/* 500 */         float f8 = MathUtils.sinDeg(this.rotation);
/* 501 */         float f9 = f1 * f7;
/* 502 */         f1 *= f8;
/* 503 */         float f10 = f2 * f7;
/* 504 */         f2 *= f8;
/* 505 */         float f11 = f3 * f7;
/* 506 */         f3 *= f8;
/* 507 */         f7 = f4 * f7;
/* 508 */         f4 *= f8;
/*     */         
/* 510 */         f2 = f9 - f2 + f5;
/* 511 */         f8 = f10 + f1 + f6;
/* 512 */         arrayOfFloat[0] = f2;
/* 513 */         arrayOfFloat[1] = f8;
/*     */         
/* 515 */         f9 = f9 - f4 + f5;
/* 516 */         f1 = f7 + f1 + f6;
/* 517 */         arrayOfFloat[5] = f9;
/* 518 */         arrayOfFloat[6] = f1;
/*     */         
/* 520 */         f4 = f11 - f4 + f5;
/* 521 */         f3 = f7 + f3 + f6;
/* 522 */         arrayOfFloat[10] = f4;
/* 523 */         arrayOfFloat[11] = f3;
/*     */         
/* 525 */         arrayOfFloat[15] = f2 + f4 - f9;
/* 526 */         arrayOfFloat[16] = f3 - f1 - f8;
/*     */       } else {
/* 528 */         float f7 = f1 + f5;
/* 529 */         float f8 = f2 + f6;
/* 530 */         float f9 = f3 + f5;
/* 531 */         f1 = f4 + f6;
/*     */         
/* 533 */         arrayOfFloat[0] = f7;
/* 534 */         arrayOfFloat[1] = f8;
/*     */         
/* 536 */         arrayOfFloat[5] = f7;
/* 537 */         arrayOfFloat[6] = f1;
/*     */         
/* 539 */         arrayOfFloat[10] = f9;
/* 540 */         arrayOfFloat[11] = f1;
/*     */         
/* 542 */         arrayOfFloat[15] = f9;
/* 543 */         arrayOfFloat[16] = f8;
/*     */       } 
/*     */     } 
/* 546 */     return this.vertices;
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
/* 557 */     float arrayOfFloat[], f1 = (arrayOfFloat = getVertices())[0];
/* 558 */     float f2 = arrayOfFloat[1];
/* 559 */     float f3 = arrayOfFloat[0];
/* 560 */     float f4 = arrayOfFloat[1];
/*     */ 
/*     */ 
/*     */     
/* 564 */     f1 = ((f1 = ((f1 = (f1 > arrayOfFloat[5]) ? arrayOfFloat[5] : f1) > arrayOfFloat[10]) ? arrayOfFloat[10] : f1) > arrayOfFloat[15]) ? arrayOfFloat[15] : f1;
/*     */ 
/*     */ 
/*     */     
/* 568 */     f3 = ((f3 = ((f3 = (f3 < arrayOfFloat[5]) ? arrayOfFloat[5] : f3) < arrayOfFloat[10]) ? arrayOfFloat[10] : f3) < arrayOfFloat[15]) ? arrayOfFloat[15] : f3;
/*     */ 
/*     */ 
/*     */     
/* 572 */     f2 = ((f2 = ((f2 = (f2 > arrayOfFloat[6]) ? arrayOfFloat[6] : f2) > arrayOfFloat[11]) ? arrayOfFloat[11] : f2) > arrayOfFloat[16]) ? arrayOfFloat[16] : f2;
/*     */ 
/*     */ 
/*     */     
/* 576 */     f4 = ((f4 = ((f4 = (f4 < arrayOfFloat[6]) ? arrayOfFloat[6] : f4) < arrayOfFloat[11]) ? arrayOfFloat[11] : f4) < arrayOfFloat[16]) ? arrayOfFloat[16] : f4;
/*     */     
/* 578 */     if (this.bounds == null) this.bounds = new Rectangle(); 
/* 579 */     this.bounds.x = f1;
/* 580 */     this.bounds.y = f2;
/* 581 */     this.bounds.width = f3 - f1;
/* 582 */     this.bounds.height = f4 - f2;
/* 583 */     return this.bounds;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch) {
/* 587 */     paramBatch.draw(this.texture, getVertices(), 0, 20);
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 591 */     float f = (getColor()).a;
/* 592 */     setAlpha(f * paramFloat);
/* 593 */     draw(paramBatch);
/* 594 */     setAlpha(f);
/*     */   }
/*     */   
/*     */   public float getX() {
/* 598 */     return this.x;
/*     */   }
/*     */   
/*     */   public float getY() {
/* 602 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWidth() {
/* 607 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getHeight() {
/* 612 */     return this.height;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getOriginX() {
/* 618 */     return this.originX;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getOriginY() {
/* 624 */     return this.originY;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScaleX() {
/* 629 */     return this.scaleX;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScaleY() {
/* 634 */     return this.scaleY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getColor() {
/* 640 */     return this.color;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getPackedColor() {
/* 645 */     return this.packedColor;
/*     */   }
/*     */   
/*     */   public void setRegion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 649 */     super.setRegion(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */     
/*     */     float[] arrayOfFloat;
/* 652 */     (arrayOfFloat = this.vertices)[3] = paramFloat1;
/* 653 */     arrayOfFloat[4] = paramFloat4;
/*     */     
/* 655 */     arrayOfFloat[8] = paramFloat1;
/* 656 */     arrayOfFloat[9] = paramFloat2;
/*     */     
/* 658 */     arrayOfFloat[13] = paramFloat3;
/* 659 */     arrayOfFloat[14] = paramFloat2;
/*     */     
/* 661 */     arrayOfFloat[18] = paramFloat3;
/* 662 */     arrayOfFloat[19] = paramFloat4;
/*     */   }
/*     */   
/*     */   public void setU(float paramFloat) {
/* 666 */     super.setU(paramFloat);
/* 667 */     this.vertices[3] = paramFloat;
/* 668 */     this.vertices[8] = paramFloat;
/*     */   }
/*     */   
/*     */   public void setV(float paramFloat) {
/* 672 */     super.setV(paramFloat);
/* 673 */     this.vertices[9] = paramFloat;
/* 674 */     this.vertices[14] = paramFloat;
/*     */   }
/*     */   
/*     */   public void setU2(float paramFloat) {
/* 678 */     super.setU2(paramFloat);
/* 679 */     this.vertices[13] = paramFloat;
/* 680 */     this.vertices[18] = paramFloat;
/*     */   }
/*     */   
/*     */   public void setV2(float paramFloat) {
/* 684 */     super.setV2(paramFloat);
/* 685 */     this.vertices[4] = paramFloat;
/* 686 */     this.vertices[19] = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlip(boolean paramBoolean1, boolean paramBoolean2) {
/* 693 */     boolean bool1 = false;
/* 694 */     boolean bool2 = false;
/* 695 */     if (isFlipX() != paramBoolean1) {
/* 696 */       bool1 = true;
/*     */     }
/* 698 */     if (isFlipY() != paramBoolean2) {
/* 699 */       bool2 = true;
/*     */     }
/* 701 */     flip(bool1, bool2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flip(boolean paramBoolean1, boolean paramBoolean2) {
/* 708 */     super.flip(paramBoolean1, paramBoolean2);
/* 709 */     float[] arrayOfFloat = this.vertices;
/* 710 */     if (paramBoolean1) {
/* 711 */       float f = arrayOfFloat[3];
/* 712 */       arrayOfFloat[3] = arrayOfFloat[13];
/* 713 */       arrayOfFloat[13] = f;
/* 714 */       f = arrayOfFloat[8];
/* 715 */       arrayOfFloat[8] = arrayOfFloat[18];
/* 716 */       arrayOfFloat[18] = f;
/*     */     } 
/* 718 */     if (paramBoolean2) {
/* 719 */       float f = arrayOfFloat[4];
/* 720 */       arrayOfFloat[4] = arrayOfFloat[14];
/* 721 */       arrayOfFloat[14] = f;
/* 722 */       f = arrayOfFloat[9];
/* 723 */       arrayOfFloat[9] = arrayOfFloat[19];
/* 724 */       arrayOfFloat[19] = f;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void scroll(float paramFloat1, float paramFloat2) {
/* 729 */     float[] arrayOfFloat = this.vertices;
/* 730 */     if (paramFloat1 != 0.0F) {
/*     */       
/* 732 */       float f = (paramFloat1 = (arrayOfFloat[3] + paramFloat1) % 1.0F) + this.width / this.texture.getWidth();
/* 733 */       this.u = paramFloat1;
/* 734 */       this.u2 = f;
/* 735 */       arrayOfFloat[3] = paramFloat1;
/* 736 */       arrayOfFloat[8] = paramFloat1;
/* 737 */       arrayOfFloat[13] = f;
/* 738 */       arrayOfFloat[18] = f;
/*     */     } 
/* 740 */     if (paramFloat2 != 0.0F) {
/*     */       
/* 742 */       float f = (paramFloat1 = (arrayOfFloat[9] + paramFloat2) % 1.0F) + this.height / this.texture.getHeight();
/* 743 */       this.v = paramFloat1;
/* 744 */       this.v2 = f;
/* 745 */       arrayOfFloat[4] = f;
/* 746 */       arrayOfFloat[9] = paramFloat1;
/* 747 */       arrayOfFloat[14] = paramFloat1;
/* 748 */       arrayOfFloat[19] = f;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\Sprite.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */