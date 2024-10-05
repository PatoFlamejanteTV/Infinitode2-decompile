/*     */ package com.badlogic.gdx.graphics.g3d.decals;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Quaternion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.NumberUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Decal
/*     */ {
/*     */   private static final int VERTEX_SIZE = 6;
/*     */   public static final int SIZE = 24;
/*  42 */   private static Vector3 tmp = new Vector3();
/*  43 */   private static Vector3 tmp2 = new Vector3();
/*     */ 
/*     */   
/*     */   public int value;
/*     */   
/*  48 */   protected float[] vertices = new float[24];
/*  49 */   protected Vector3 position = new Vector3();
/*  50 */   protected Quaternion rotation = new Quaternion();
/*  51 */   protected Vector2 scale = new Vector2(1.0F, 1.0F);
/*  52 */   protected Color color = new Color();
/*     */ 
/*     */ 
/*     */   
/*  56 */   public Vector2 transformationOffset = null;
/*  57 */   protected Vector2 dimensions = new Vector2();
/*     */   
/*     */   protected DecalMaterial material;
/*     */   protected boolean updated = false;
/*     */   
/*     */   public Decal() {
/*  63 */     this.material = new DecalMaterial();
/*     */   }
/*     */   
/*     */   public Decal(DecalMaterial paramDecalMaterial) {
/*  67 */     this.material = paramDecalMaterial;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  77 */     this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */     int i;
/*  79 */     float f = NumberUtils.intToFloatColor(i = (int)(255.0F * paramFloat4) << 24 | (int)(255.0F * paramFloat3) << 16 | (int)(255.0F * paramFloat2) << 8 | (int)(255.0F * paramFloat1));
/*  80 */     this.vertices[3] = f;
/*  81 */     this.vertices[9] = f;
/*  82 */     this.vertices[15] = f;
/*  83 */     this.vertices[21] = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setColor(Color paramColor) {
/*  88 */     this.color.set(paramColor);
/*  89 */     float f = paramColor.toFloatBits();
/*  90 */     this.vertices[3] = f;
/*  91 */     this.vertices[9] = f;
/*  92 */     this.vertices[15] = f;
/*  93 */     this.vertices[21] = f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPackedColor(float paramFloat) {
/*  99 */     Color.abgr8888ToColor(this.color, paramFloat);
/* 100 */     this.vertices[3] = paramFloat;
/* 101 */     this.vertices[9] = paramFloat;
/* 102 */     this.vertices[15] = paramFloat;
/* 103 */     this.vertices[21] = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationX(float paramFloat) {
/* 110 */     this.rotation.set(Vector3.X, paramFloat);
/* 111 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationY(float paramFloat) {
/* 118 */     this.rotation.set(Vector3.Y, paramFloat);
/* 119 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationZ(float paramFloat) {
/* 126 */     this.rotation.set(Vector3.Z, paramFloat);
/* 127 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotateX(float paramFloat) {
/* 134 */     rotator.set(Vector3.X, paramFloat);
/* 135 */     this.rotation.mul(rotator);
/* 136 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotateY(float paramFloat) {
/* 143 */     rotator.set(Vector3.Y, paramFloat);
/* 144 */     this.rotation.mul(rotator);
/* 145 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotateZ(float paramFloat) {
/* 152 */     rotator.set(Vector3.Z, paramFloat);
/* 153 */     this.rotation.mul(rotator);
/* 154 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotation(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 162 */     this.rotation.setEulerAngles(paramFloat1, paramFloat2, paramFloat3);
/* 163 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotation(Vector3 paramVector31, Vector3 paramVector32) {
/* 170 */     tmp.set(paramVector32).crs(paramVector31).nor();
/* 171 */     tmp2.set(paramVector31).crs(tmp).nor();
/* 172 */     this.rotation.setFromAxes(tmp.x, tmp2.x, paramVector31.x, tmp.y, tmp2.y, paramVector31.y, tmp.z, tmp2.z, paramVector31.z);
/* 173 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotation(Quaternion paramQuaternion) {
/* 179 */     this.rotation.set(paramQuaternion);
/* 180 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Quaternion getRotation() {
/* 187 */     return this.rotation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void translateX(float paramFloat) {
/* 194 */     this.position.x += paramFloat;
/* 195 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setX(float paramFloat) {
/* 202 */     this.position.x = paramFloat;
/* 203 */     this.updated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getX() {
/* 208 */     return this.position.x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void translateY(float paramFloat) {
/* 215 */     this.position.y += paramFloat;
/* 216 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setY(float paramFloat) {
/* 223 */     this.position.y = paramFloat;
/* 224 */     this.updated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getY() {
/* 229 */     return this.position.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void translateZ(float paramFloat) {
/* 236 */     this.position.z += paramFloat;
/* 237 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZ(float paramFloat) {
/* 244 */     this.position.z = paramFloat;
/* 245 */     this.updated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getZ() {
/* 250 */     return this.position.z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void translate(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 259 */     this.position.add(paramFloat1, paramFloat2, paramFloat3);
/* 260 */     this.updated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void translate(Vector3 paramVector3) {
/* 265 */     this.position.add(paramVector3);
/* 266 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPosition(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 275 */     this.position.set(paramFloat1, paramFloat2, paramFloat3);
/* 276 */     this.updated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPosition(Vector3 paramVector3) {
/* 281 */     this.position.set(paramVector3);
/* 282 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getColor() {
/* 289 */     return this.color;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 getPosition() {
/* 296 */     return this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScaleX(float paramFloat) {
/* 303 */     this.scale.x = paramFloat;
/* 304 */     this.updated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScaleX() {
/* 309 */     return this.scale.x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScaleY(float paramFloat) {
/* 316 */     this.scale.y = paramFloat;
/* 317 */     this.updated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getScaleY() {
/* 322 */     return this.scale.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScale(float paramFloat1, float paramFloat2) {
/* 330 */     this.scale.set(paramFloat1, paramFloat2);
/* 331 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScale(float paramFloat) {
/* 338 */     this.scale.set(paramFloat, paramFloat);
/* 339 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWidth(float paramFloat) {
/* 346 */     this.dimensions.x = paramFloat;
/* 347 */     this.updated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWidth() {
/* 352 */     return this.dimensions.x;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeight(float paramFloat) {
/* 359 */     this.dimensions.y = paramFloat;
/* 360 */     this.updated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getHeight() {
/* 365 */     return this.dimensions.y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDimensions(float paramFloat1, float paramFloat2) {
/* 373 */     this.dimensions.set(paramFloat1, paramFloat2);
/* 374 */     this.updated = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] getVertices() {
/* 382 */     update();
/* 383 */     return this.vertices;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update() {
/* 388 */     if (!this.updated) {
/* 389 */       resetVertices();
/* 390 */       transformVertices();
/*     */     } 
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
/*     */ 
/*     */   
/*     */   protected void transformVertices() {
/*     */     float f5, f6;
/* 407 */     if (this.transformationOffset != null) {
/* 408 */       f5 = -this.transformationOffset.x;
/* 409 */       f6 = -this.transformationOffset.y;
/*     */     } else {
/* 411 */       f5 = f6 = 0.0F;
/*     */     } 
/*     */ 
/*     */     
/* 415 */     float f1 = (this.vertices[0] + f5) * this.scale.x;
/* 416 */     float f2 = (this.vertices[1] + f6) * this.scale.y;
/* 417 */     float f3 = this.vertices[2];
/*     */     
/* 419 */     this.vertices[0] = this.rotation.w * f1 + this.rotation.y * f3 - this.rotation.z * f2;
/* 420 */     this.vertices[1] = this.rotation.w * f2 + this.rotation.z * f1 - this.rotation.x * f3;
/* 421 */     this.vertices[2] = this.rotation.w * f3 + this.rotation.x * f2 - this.rotation.y * f1;
/* 422 */     float f4 = -this.rotation.x * f1 - this.rotation.y * f2 - this.rotation.z * f3;
/* 423 */     this.rotation.conjugate();
/* 424 */     f1 = this.vertices[0];
/* 425 */     f2 = this.vertices[1];
/* 426 */     f3 = this.vertices[2];
/* 427 */     this.vertices[0] = f4 * this.rotation.x + f1 * this.rotation.w + f2 * this.rotation.z - f3 * this.rotation.y;
/* 428 */     this.vertices[1] = f4 * this.rotation.y + f2 * this.rotation.w + f3 * this.rotation.x - f1 * this.rotation.z;
/* 429 */     this.vertices[2] = f4 * this.rotation.z + f3 * this.rotation.w + f1 * this.rotation.y - f2 * this.rotation.x;
/* 430 */     this.rotation.conjugate();
/*     */     
/* 432 */     this.vertices[0] = this.vertices[0] + this.position.x - f5;
/* 433 */     this.vertices[1] = this.vertices[1] + this.position.y - f6;
/* 434 */     this.vertices[2] = this.vertices[2] + this.position.z;
/*     */ 
/*     */     
/* 437 */     f1 = (this.vertices[6] + f5) * this.scale.x;
/* 438 */     f2 = (this.vertices[7] + f6) * this.scale.y;
/* 439 */     f3 = this.vertices[8];
/*     */     
/* 441 */     this.vertices[6] = this.rotation.w * f1 + this.rotation.y * f3 - this.rotation.z * f2;
/* 442 */     this.vertices[7] = this.rotation.w * f2 + this.rotation.z * f1 - this.rotation.x * f3;
/* 443 */     this.vertices[8] = this.rotation.w * f3 + this.rotation.x * f2 - this.rotation.y * f1;
/* 444 */     f4 = -this.rotation.x * f1 - this.rotation.y * f2 - this.rotation.z * f3;
/* 445 */     this.rotation.conjugate();
/* 446 */     f1 = this.vertices[6];
/* 447 */     f2 = this.vertices[7];
/* 448 */     f3 = this.vertices[8];
/* 449 */     this.vertices[6] = f4 * this.rotation.x + f1 * this.rotation.w + f2 * this.rotation.z - f3 * this.rotation.y;
/* 450 */     this.vertices[7] = f4 * this.rotation.y + f2 * this.rotation.w + f3 * this.rotation.x - f1 * this.rotation.z;
/* 451 */     this.vertices[8] = f4 * this.rotation.z + f3 * this.rotation.w + f1 * this.rotation.y - f2 * this.rotation.x;
/* 452 */     this.rotation.conjugate();
/*     */     
/* 454 */     this.vertices[6] = this.vertices[6] + this.position.x - f5;
/* 455 */     this.vertices[7] = this.vertices[7] + this.position.y - f6;
/* 456 */     this.vertices[8] = this.vertices[8] + this.position.z;
/*     */ 
/*     */     
/* 459 */     f1 = (this.vertices[12] + f5) * this.scale.x;
/* 460 */     f2 = (this.vertices[13] + f6) * this.scale.y;
/* 461 */     f3 = this.vertices[14];
/*     */     
/* 463 */     this.vertices[12] = this.rotation.w * f1 + this.rotation.y * f3 - this.rotation.z * f2;
/* 464 */     this.vertices[13] = this.rotation.w * f2 + this.rotation.z * f1 - this.rotation.x * f3;
/* 465 */     this.vertices[14] = this.rotation.w * f3 + this.rotation.x * f2 - this.rotation.y * f1;
/* 466 */     f4 = -this.rotation.x * f1 - this.rotation.y * f2 - this.rotation.z * f3;
/* 467 */     this.rotation.conjugate();
/* 468 */     f1 = this.vertices[12];
/* 469 */     f2 = this.vertices[13];
/* 470 */     f3 = this.vertices[14];
/* 471 */     this.vertices[12] = f4 * this.rotation.x + f1 * this.rotation.w + f2 * this.rotation.z - f3 * this.rotation.y;
/* 472 */     this.vertices[13] = f4 * this.rotation.y + f2 * this.rotation.w + f3 * this.rotation.x - f1 * this.rotation.z;
/* 473 */     this.vertices[14] = f4 * this.rotation.z + f3 * this.rotation.w + f1 * this.rotation.y - f2 * this.rotation.x;
/* 474 */     this.rotation.conjugate();
/*     */     
/* 476 */     this.vertices[12] = this.vertices[12] + this.position.x - f5;
/* 477 */     this.vertices[13] = this.vertices[13] + this.position.y - f6;
/* 478 */     this.vertices[14] = this.vertices[14] + this.position.z;
/*     */ 
/*     */     
/* 481 */     f1 = (this.vertices[18] + f5) * this.scale.x;
/* 482 */     f2 = (this.vertices[19] + f6) * this.scale.y;
/* 483 */     f3 = this.vertices[20];
/*     */     
/* 485 */     this.vertices[18] = this.rotation.w * f1 + this.rotation.y * f3 - this.rotation.z * f2;
/* 486 */     this.vertices[19] = this.rotation.w * f2 + this.rotation.z * f1 - this.rotation.x * f3;
/* 487 */     this.vertices[20] = this.rotation.w * f3 + this.rotation.x * f2 - this.rotation.y * f1;
/* 488 */     f4 = -this.rotation.x * f1 - this.rotation.y * f2 - this.rotation.z * f3;
/* 489 */     this.rotation.conjugate();
/* 490 */     f1 = this.vertices[18];
/* 491 */     f2 = this.vertices[19];
/* 492 */     f3 = this.vertices[20];
/* 493 */     this.vertices[18] = f4 * this.rotation.x + f1 * this.rotation.w + f2 * this.rotation.z - f3 * this.rotation.y;
/* 494 */     this.vertices[19] = f4 * this.rotation.y + f2 * this.rotation.w + f3 * this.rotation.x - f1 * this.rotation.z;
/* 495 */     this.vertices[20] = f4 * this.rotation.z + f3 * this.rotation.w + f1 * this.rotation.y - f2 * this.rotation.x;
/* 496 */     this.rotation.conjugate();
/*     */     
/* 498 */     this.vertices[18] = this.vertices[18] + this.position.x - f5;
/* 499 */     this.vertices[19] = this.vertices[19] + this.position.y - f6;
/* 500 */     this.vertices[20] = this.vertices[20] + this.position.z;
/* 501 */     this.updated = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void resetVertices() {
/* 507 */     float f1, f2 = (f1 = -this.dimensions.x / 2.0F) + this.dimensions.x;
/*     */     
/* 509 */     float f3, f4 = (f3 = this.dimensions.y / 2.0F) - this.dimensions.y;
/*     */ 
/*     */     
/* 512 */     this.vertices[0] = f1;
/* 513 */     this.vertices[1] = f3;
/* 514 */     this.vertices[2] = 0.0F;
/*     */     
/* 516 */     this.vertices[6] = f2;
/* 517 */     this.vertices[7] = f3;
/* 518 */     this.vertices[8] = 0.0F;
/*     */     
/* 520 */     this.vertices[12] = f1;
/* 521 */     this.vertices[13] = f4;
/* 522 */     this.vertices[14] = 0.0F;
/*     */     
/* 524 */     this.vertices[18] = f2;
/* 525 */     this.vertices[19] = f4;
/* 526 */     this.vertices[20] = 0.0F;
/*     */     
/* 528 */     this.updated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateUVs() {
/* 533 */     TextureRegion textureRegion = this.material.textureRegion;
/*     */     
/* 535 */     this.vertices[4] = textureRegion.getU();
/* 536 */     this.vertices[5] = textureRegion.getV();
/*     */     
/* 538 */     this.vertices[10] = textureRegion.getU2();
/* 539 */     this.vertices[11] = textureRegion.getV();
/*     */     
/* 541 */     this.vertices[16] = textureRegion.getU();
/* 542 */     this.vertices[17] = textureRegion.getV2();
/*     */     
/* 544 */     this.vertices[22] = textureRegion.getU2();
/* 545 */     this.vertices[23] = textureRegion.getV2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextureRegion(TextureRegion paramTextureRegion) {
/* 552 */     this.material.textureRegion = paramTextureRegion;
/* 553 */     updateUVs();
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureRegion getTextureRegion() {
/* 558 */     return this.material.textureRegion;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlending(int paramInt1, int paramInt2) {
/* 566 */     this.material.srcBlendFactor = paramInt1;
/* 567 */     this.material.dstBlendFactor = paramInt2;
/*     */   }
/*     */   
/*     */   public DecalMaterial getMaterial() {
/* 571 */     return this.material;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaterial(DecalMaterial paramDecalMaterial) {
/* 578 */     this.material = paramDecalMaterial;
/*     */   }
/*     */   
/* 581 */   static final Vector3 dir = new Vector3();
/*     */   public static final int X1 = 0;
/*     */   public static final int Y1 = 1;
/*     */   public static final int Z1 = 2;
/*     */   
/*     */   public void lookAt(Vector3 paramVector31, Vector3 paramVector32) {
/* 587 */     dir.set(paramVector31).sub(this.position).nor();
/* 588 */     setRotation(dir, paramVector32);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int C1 = 3;
/*     */   
/*     */   public static final int U1 = 4;
/*     */   
/*     */   public static final int V1 = 5;
/*     */   
/*     */   public static final int X2 = 6;
/*     */   
/*     */   public static final int Y2 = 7;
/*     */   public static final int Z2 = 8;
/*     */   public static final int C2 = 9;
/*     */   public static final int U2 = 10;
/*     */   public static final int V2 = 11;
/*     */   public static final int X3 = 12;
/*     */   public static final int Y3 = 13;
/*     */   public static final int Z3 = 14;
/*     */   public static final int C3 = 15;
/*     */   public static final int U3 = 16;
/*     */   public static final int V3 = 17;
/*     */   public static final int X4 = 18;
/*     */   public static final int Y4 = 19;
/*     */   public static final int Z4 = 20;
/*     */   public static final int C4 = 21;
/*     */   public static final int U4 = 22;
/*     */   public static final int V4 = 23;
/* 617 */   protected static Quaternion rotator = new Quaternion(0.0F, 0.0F, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Decal newDecal(TextureRegion paramTextureRegion) {
/* 624 */     return newDecal(paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight(), paramTextureRegion, -1, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Decal newDecal(TextureRegion paramTextureRegion, boolean paramBoolean) {
/* 634 */     return newDecal(paramTextureRegion.getRegionWidth(), paramTextureRegion.getRegionHeight(), paramTextureRegion, 
/* 635 */         paramBoolean ? 770 : -1, 
/* 636 */         paramBoolean ? 771 : -1);
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
/*     */   public static Decal newDecal(float paramFloat1, float paramFloat2, TextureRegion paramTextureRegion) {
/* 648 */     return newDecal(paramFloat1, paramFloat2, paramTextureRegion, -1, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Decal newDecal(float paramFloat1, float paramFloat2, TextureRegion paramTextureRegion, boolean paramBoolean) {
/* 659 */     return newDecal(paramFloat1, paramFloat2, paramTextureRegion, paramBoolean ? 770 : -1, 
/* 660 */         paramBoolean ? 771 : -1);
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
/*     */   public static Decal newDecal(float paramFloat1, float paramFloat2, TextureRegion paramTextureRegion, int paramInt1, int paramInt2) {
/*     */     Decal decal;
/* 673 */     (decal = new Decal()).setTextureRegion(paramTextureRegion);
/* 674 */     decal.setBlending(paramInt1, paramInt2);
/* 675 */     decal.dimensions.x = paramFloat1;
/* 676 */     decal.dimensions.y = paramFloat2;
/* 677 */     decal.setColor(1.0F, 1.0F, 1.0F, 1.0F);
/* 678 */     return decal;
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
/*     */   
/*     */   public static Decal newDecal(float paramFloat1, float paramFloat2, TextureRegion paramTextureRegion, int paramInt1, int paramInt2, DecalMaterial paramDecalMaterial) {
/*     */     Decal decal;
/* 693 */     (decal = new Decal(paramDecalMaterial)).setTextureRegion(paramTextureRegion);
/* 694 */     decal.setBlending(paramInt1, paramInt2);
/* 695 */     decal.dimensions.x = paramFloat1;
/* 696 */     decal.dimensions.y = paramFloat2;
/* 697 */     decal.setColor(1.0F, 1.0F, 1.0F, 1.0F);
/* 698 */     return decal;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\decals\Decal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */