/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.Frustum;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Quaternion;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.math.collision.Ray;
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
/*     */ public abstract class Camera
/*     */ {
/*  33 */   public final Vector3 position = new Vector3();
/*     */   
/*  35 */   public final Vector3 direction = new Vector3(0.0F, 0.0F, -1.0F);
/*     */   
/*  37 */   public final Vector3 up = new Vector3(0.0F, 1.0F, 0.0F);
/*     */ 
/*     */   
/*  40 */   public final Matrix4 projection = new Matrix4();
/*     */   
/*  42 */   public final Matrix4 view = new Matrix4();
/*     */   
/*  44 */   public final Matrix4 combined = new Matrix4();
/*     */   
/*  46 */   public final Matrix4 invProjectionView = new Matrix4();
/*     */ 
/*     */   
/*  49 */   public float near = 1.0F;
/*     */   
/*  51 */   public float far = 100.0F;
/*     */ 
/*     */   
/*  54 */   public float viewportWidth = 0.0F;
/*     */   
/*  56 */   public float viewportHeight = 0.0F;
/*     */ 
/*     */   
/*  59 */   public final Frustum frustum = new Frustum();
/*     */   
/*  61 */   private final Vector3 tmpVec = new Vector3();
/*  62 */   private final Ray ray = new Ray(new Vector3(), new Vector3());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void update();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void update(boolean paramBoolean);
/*     */ 
/*     */ 
/*     */   
/*     */   public void lookAt(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  77 */     this.tmpVec.set(paramFloat1, paramFloat2, paramFloat3).sub(this.position).nor();
/*  78 */     if (!this.tmpVec.isZero()) {
/*     */       
/*  80 */       if (Math.abs((paramFloat1 = this.tmpVec.dot(this.up)) - 1.0F) < 1.0E-9F) {
/*     */         
/*  82 */         this.up.set(this.direction).scl(-1.0F);
/*  83 */       } else if (Math.abs(paramFloat1 + 1.0F) < 1.0E-9F) {
/*     */         
/*  85 */         this.up.set(this.direction);
/*     */       } 
/*  87 */       this.direction.set(this.tmpVec);
/*  88 */       normalizeUp();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void lookAt(Vector3 paramVector3) {
/*  95 */     lookAt(paramVector3.x, paramVector3.y, paramVector3.z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void normalizeUp() {
/* 101 */     this.tmpVec.set(this.direction).crs(this.up);
/* 102 */     this.up.set(this.tmpVec).crs(this.direction).nor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 113 */     this.direction.rotate(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 114 */     this.up.rotate(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotate(Vector3 paramVector3, float paramFloat) {
/* 123 */     this.direction.rotate(paramVector3, paramFloat);
/* 124 */     this.up.rotate(paramVector3, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotate(Matrix4 paramMatrix4) {
/* 132 */     this.direction.rot(paramMatrix4);
/* 133 */     this.up.rot(paramMatrix4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotate(Quaternion paramQuaternion) {
/* 141 */     paramQuaternion.transform(this.direction);
/* 142 */     paramQuaternion.transform(this.up);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotateAround(Vector3 paramVector31, Vector3 paramVector32, float paramFloat) {
/* 152 */     this.tmpVec.set(paramVector31);
/* 153 */     this.tmpVec.sub(this.position);
/* 154 */     translate(this.tmpVec);
/* 155 */     rotate(paramVector32, paramFloat);
/* 156 */     this.tmpVec.rotate(paramVector32, paramFloat);
/* 157 */     translate(-this.tmpVec.x, -this.tmpVec.y, -this.tmpVec.z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void transform(Matrix4 paramMatrix4) {
/* 164 */     this.position.mul(paramMatrix4);
/* 165 */     rotate(paramMatrix4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void translate(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 173 */     this.position.add(paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void translate(Vector3 paramVector3) {
/* 179 */     this.position.add(paramVector3);
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
/*     */   
/*     */   public Vector3 unproject(Vector3 paramVector3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 195 */     paramFloat1 = paramVector3.x - paramFloat1; paramFloat2 = Gdx.graphics.getHeight() - paramVector3.y - paramFloat2;
/* 196 */     paramVector3.x = paramFloat1 * 2.0F / paramFloat3 - 1.0F;
/* 197 */     paramVector3.y = paramFloat2 * 2.0F / paramFloat4 - 1.0F;
/* 198 */     paramVector3.z = 2.0F * paramVector3.z - 1.0F;
/* 199 */     paramVector3.prj(this.invProjectionView);
/* 200 */     return paramVector3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 unproject(Vector3 paramVector3) {
/* 211 */     unproject(paramVector3, 0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/* 212 */     return paramVector3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 project(Vector3 paramVector3) {
/* 221 */     project(paramVector3, 0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/* 222 */     return paramVector3;
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
/*     */   public Vector3 project(Vector3 paramVector3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 237 */     paramVector3.prj(this.combined);
/* 238 */     paramVector3.x = paramFloat3 * (paramVector3.x + 1.0F) / 2.0F + paramFloat1;
/* 239 */     paramVector3.y = paramFloat4 * (paramVector3.y + 1.0F) / 2.0F + paramFloat2;
/* 240 */     paramVector3.z = (paramVector3.z + 1.0F) / 2.0F;
/* 241 */     return paramVector3;
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
/*     */   public Ray getPickRay(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/* 254 */     unproject(this.ray.origin.set(paramFloat1, paramFloat2, 0.0F), paramFloat3, paramFloat4, paramFloat5, paramFloat6);
/* 255 */     unproject(this.ray.direction.set(paramFloat1, paramFloat2, 1.0F), paramFloat3, paramFloat4, paramFloat5, paramFloat6);
/* 256 */     this.ray.direction.sub(this.ray.origin).nor();
/* 257 */     return this.ray;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ray getPickRay(float paramFloat1, float paramFloat2) {
/* 265 */     return getPickRay(paramFloat1, paramFloat2, 0.0F, 0.0F, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\Camera.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */