/*     */ package com.badlogic.gdx.math.collision;
/*     */ 
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
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
/*     */ public class BoundingBox
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1286036817192127343L;
/*  32 */   private static final Vector3 tmpVector = new Vector3();
/*     */ 
/*     */ 
/*     */   
/*  36 */   public final Vector3 min = new Vector3();
/*     */ 
/*     */   
/*  39 */   public final Vector3 max = new Vector3();
/*     */   
/*  41 */   private final Vector3 cnt = new Vector3();
/*  42 */   private final Vector3 dim = new Vector3();
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 getCenter(Vector3 paramVector3) {
/*  47 */     return paramVector3.set(this.cnt);
/*     */   }
/*     */   
/*     */   public float getCenterX() {
/*  51 */     return this.cnt.x;
/*     */   }
/*     */   
/*     */   public float getCenterY() {
/*  55 */     return this.cnt.y;
/*     */   }
/*     */   
/*     */   public float getCenterZ() {
/*  59 */     return this.cnt.z;
/*     */   }
/*     */   
/*     */   public Vector3 getCorner000(Vector3 paramVector3) {
/*  63 */     return paramVector3.set(this.min.x, this.min.y, this.min.z);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner001(Vector3 paramVector3) {
/*  67 */     return paramVector3.set(this.min.x, this.min.y, this.max.z);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner010(Vector3 paramVector3) {
/*  71 */     return paramVector3.set(this.min.x, this.max.y, this.min.z);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner011(Vector3 paramVector3) {
/*  75 */     return paramVector3.set(this.min.x, this.max.y, this.max.z);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner100(Vector3 paramVector3) {
/*  79 */     return paramVector3.set(this.max.x, this.min.y, this.min.z);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner101(Vector3 paramVector3) {
/*  83 */     return paramVector3.set(this.max.x, this.min.y, this.max.z);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner110(Vector3 paramVector3) {
/*  87 */     return paramVector3.set(this.max.x, this.max.y, this.min.z);
/*     */   }
/*     */   
/*     */   public Vector3 getCorner111(Vector3 paramVector3) {
/*  91 */     return paramVector3.set(this.max.x, this.max.y, this.max.z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 getDimensions(Vector3 paramVector3) {
/*  97 */     return paramVector3.set(this.dim);
/*     */   }
/*     */   
/*     */   public float getWidth() {
/* 101 */     return this.dim.x;
/*     */   }
/*     */   
/*     */   public float getHeight() {
/* 105 */     return this.dim.y;
/*     */   }
/*     */   
/*     */   public float getDepth() {
/* 109 */     return this.dim.z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 getMin(Vector3 paramVector3) {
/* 115 */     return paramVector3.set(this.min);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 getMax(Vector3 paramVector3) {
/* 121 */     return paramVector3.set(this.max);
/*     */   }
/*     */ 
/*     */   
/*     */   public BoundingBox() {
/* 126 */     clr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox(BoundingBox paramBoundingBox) {
/* 133 */     set(paramBoundingBox);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox(Vector3 paramVector31, Vector3 paramVector32) {
/* 141 */     set(paramVector31, paramVector32);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox set(BoundingBox paramBoundingBox) {
/* 149 */     return set(paramBoundingBox.min, paramBoundingBox.max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox set(Vector3 paramVector31, Vector3 paramVector32) {
/* 158 */     this.min.set((paramVector31.x < paramVector32.x) ? paramVector31.x : paramVector32.x, (paramVector31.y < paramVector32.y) ? paramVector31.y : paramVector32.y, 
/* 159 */         (paramVector31.z < paramVector32.z) ? paramVector31.z : paramVector32.z);
/* 160 */     this.max.set((paramVector31.x > paramVector32.x) ? paramVector31.x : paramVector32.x, (paramVector31.y > paramVector32.y) ? paramVector31.y : paramVector32.y, 
/* 161 */         (paramVector31.z > paramVector32.z) ? paramVector31.z : paramVector32.z);
/* 162 */     update();
/* 163 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 168 */     this.cnt.set(this.min).add(this.max).scl(0.5F);
/* 169 */     this.dim.set(this.max).sub(this.min);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox set(Vector3[] paramArrayOfVector3) {
/* 177 */     inf(); int i; byte b;
/* 178 */     for (i = (paramArrayOfVector3 = paramArrayOfVector3).length, b = 0; b < i; ) { Vector3 vector3 = paramArrayOfVector3[b];
/* 179 */       ext(vector3); b++; }
/* 180 */      return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox set(List<Vector3> paramList) {
/* 188 */     inf();
/* 189 */     for (Vector3 vector3 : paramList)
/* 190 */       ext(vector3); 
/* 191 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox inf() {
/* 198 */     this.min.set(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
/* 199 */     this.max.set(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
/* 200 */     this.cnt.set(0.0F, 0.0F, 0.0F);
/* 201 */     this.dim.set(0.0F, 0.0F, 0.0F);
/* 202 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox ext(Vector3 paramVector3) {
/* 209 */     return set(this.min.set(min(this.min.x, paramVector3.x), min(this.min.y, paramVector3.y), min(this.min.z, paramVector3.z)), this.max
/* 210 */         .set(Math.max(this.max.x, paramVector3.x), Math.max(this.max.y, paramVector3.y), Math.max(this.max.z, paramVector3.z)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox clr() {
/* 216 */     return set(this.min.set(0.0F, 0.0F, 0.0F), this.max.set(0.0F, 0.0F, 0.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValid() {
/* 222 */     return (this.min.x <= this.max.x && this.min.y <= this.max.y && this.min.z <= this.max.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox ext(BoundingBox paramBoundingBox) {
/* 230 */     return set(this.min.set(min(this.min.x, paramBoundingBox.min.x), min(this.min.y, paramBoundingBox.min.y), min(this.min.z, paramBoundingBox.min.z)), this.max
/* 231 */         .set(max(this.max.x, paramBoundingBox.max.x), max(this.max.y, paramBoundingBox.max.y), max(this.max.z, paramBoundingBox.max.z)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox ext(Vector3 paramVector3, float paramFloat) {
/* 240 */     return set(this.min.set(min(this.min.x, paramVector3.x - paramFloat), min(this.min.y, paramVector3.y - paramFloat), min(this.min.z, paramVector3.z - paramFloat)), this.max
/* 241 */         .set(max(this.max.x, paramVector3.x + paramFloat), max(this.max.y, paramVector3.y + paramFloat), max(this.max.z, paramVector3.z + paramFloat)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox ext(BoundingBox paramBoundingBox, Matrix4 paramMatrix4) {
/* 250 */     ext(tmpVector.set(paramBoundingBox.min.x, paramBoundingBox.min.y, paramBoundingBox.min.z).mul(paramMatrix4));
/* 251 */     ext(tmpVector.set(paramBoundingBox.min.x, paramBoundingBox.min.y, paramBoundingBox.max.z).mul(paramMatrix4));
/* 252 */     ext(tmpVector.set(paramBoundingBox.min.x, paramBoundingBox.max.y, paramBoundingBox.min.z).mul(paramMatrix4));
/* 253 */     ext(tmpVector.set(paramBoundingBox.min.x, paramBoundingBox.max.y, paramBoundingBox.max.z).mul(paramMatrix4));
/* 254 */     ext(tmpVector.set(paramBoundingBox.max.x, paramBoundingBox.min.y, paramBoundingBox.min.z).mul(paramMatrix4));
/* 255 */     ext(tmpVector.set(paramBoundingBox.max.x, paramBoundingBox.min.y, paramBoundingBox.max.z).mul(paramMatrix4));
/* 256 */     ext(tmpVector.set(paramBoundingBox.max.x, paramBoundingBox.max.y, paramBoundingBox.min.z).mul(paramMatrix4));
/* 257 */     ext(tmpVector.set(paramBoundingBox.max.x, paramBoundingBox.max.y, paramBoundingBox.max.z).mul(paramMatrix4));
/* 258 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox mul(Matrix4 paramMatrix4) {
/* 267 */     float f1 = this.min.x, f2 = this.min.y, f3 = this.min.z, f4 = this.max.x, f5 = this.max.y, f6 = this.max.z;
/* 268 */     inf();
/* 269 */     ext(tmpVector.set(f1, f2, f3).mul(paramMatrix4));
/* 270 */     ext(tmpVector.set(f1, f2, f6).mul(paramMatrix4));
/* 271 */     ext(tmpVector.set(f1, f5, f3).mul(paramMatrix4));
/* 272 */     ext(tmpVector.set(f1, f5, f6).mul(paramMatrix4));
/* 273 */     ext(tmpVector.set(f4, f2, f3).mul(paramMatrix4));
/* 274 */     ext(tmpVector.set(f4, f2, f6).mul(paramMatrix4));
/* 275 */     ext(tmpVector.set(f4, f5, f3).mul(paramMatrix4));
/* 276 */     ext(tmpVector.set(f4, f5, f6).mul(paramMatrix4));
/* 277 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(BoundingBox paramBoundingBox) {
/* 284 */     return (!isValid() || (this.min.x <= paramBoundingBox.min.x && this.min.y <= paramBoundingBox.min.y && this.min.z <= paramBoundingBox.min.z && this.max.x >= paramBoundingBox.max.x && this.max.y >= paramBoundingBox.max.y && this.max.z >= paramBoundingBox.max.z));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(OrientedBoundingBox paramOrientedBoundingBox) {
/* 292 */     if (contains(paramOrientedBoundingBox.getCorner000(tmpVector)) && contains(paramOrientedBoundingBox.getCorner001(tmpVector)) && 
/* 293 */       contains(paramOrientedBoundingBox.getCorner010(tmpVector)) && contains(paramOrientedBoundingBox.getCorner011(tmpVector)) && 
/* 294 */       contains(paramOrientedBoundingBox.getCorner100(tmpVector)) && contains(paramOrientedBoundingBox.getCorner101(tmpVector)) && 
/* 295 */       contains(paramOrientedBoundingBox.getCorner110(tmpVector)) && contains(paramOrientedBoundingBox.getCorner111(tmpVector))) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean intersects(BoundingBox paramBoundingBox) {
/* 302 */     if (!isValid()) return false;
/*     */ 
/*     */ 
/*     */     
/* 306 */     float f2 = Math.abs(this.cnt.x - paramBoundingBox.cnt.x);
/* 307 */     float f3 = this.dim.x / 2.0F + paramBoundingBox.dim.x / 2.0F;
/*     */     
/* 309 */     float f4 = Math.abs(this.cnt.y - paramBoundingBox.cnt.y);
/* 310 */     float f5 = this.dim.y / 2.0F + paramBoundingBox.dim.y / 2.0F;
/*     */     
/* 312 */     float f6 = Math.abs(this.cnt.z - paramBoundingBox.cnt.z);
/* 313 */     float f1 = this.dim.z / 2.0F + paramBoundingBox.dim.z / 2.0F;
/*     */     
/* 315 */     return (f2 <= f3 && f4 <= f5 && f6 <= f1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Vector3 paramVector3) {
/* 322 */     return (this.min.x <= paramVector3.x && this.max.x >= paramVector3.x && this.min.y <= paramVector3.y && this.max.y >= paramVector3.y && this.min.z <= paramVector3.z && this.max.z >= paramVector3.z);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 327 */     return "[" + this.min + "|" + this.max + "]";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundingBox ext(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 337 */     return set(this.min.set(min(this.min.x, paramFloat1), min(this.min.y, paramFloat2), min(this.min.z, paramFloat3)), this.max.set(max(this.max.x, paramFloat1), max(this.max.y, paramFloat2), max(this.max.z, paramFloat3)));
/*     */   }
/*     */   
/*     */   static final float min(float paramFloat1, float paramFloat2) {
/* 341 */     return (paramFloat1 > paramFloat2) ? paramFloat2 : paramFloat1;
/*     */   }
/*     */   
/*     */   static final float max(float paramFloat1, float paramFloat2) {
/* 345 */     return (paramFloat1 > paramFloat2) ? paramFloat1 : paramFloat2;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\math\collision\BoundingBox.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */