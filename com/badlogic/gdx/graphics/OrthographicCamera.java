/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
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
/*     */ public class OrthographicCamera
/*     */   extends Camera
/*     */ {
/*  29 */   public float zoom = 1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Vector3 tmp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrthographicCamera() {
/*  47 */     this.tmp = new Vector3(); this.near = 0.0F; } public OrthographicCamera(float paramFloat1, float paramFloat2) { this.tmp = new Vector3();
/*     */     this.viewportWidth = paramFloat1;
/*     */     this.viewportHeight = paramFloat2;
/*     */     this.near = 0.0F;
/*  51 */     update(); } public void update() { update(true); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(boolean paramBoolean) {
/*  56 */     this.projection.setToOrtho(this.zoom * -this.viewportWidth / 2.0F, this.zoom * this.viewportWidth / 2.0F, this.zoom * -(this.viewportHeight / 2.0F), this.zoom * this.viewportHeight / 2.0F, this.near, this.far);
/*     */     
/*  58 */     this.view.setToLookAt(this.direction, this.up);
/*  59 */     this.view.translate(-this.position.x, -this.position.y, -this.position.z);
/*  60 */     this.combined.set(this.projection);
/*  61 */     Matrix4.mul(this.combined.val, this.view.val);
/*     */     
/*  63 */     if (paramBoolean) {
/*  64 */       this.invProjectionView.set(this.combined);
/*  65 */       Matrix4.inv(this.invProjectionView.val);
/*  66 */       this.frustum.update(this.invProjectionView);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setToOrtho(boolean paramBoolean) {
/*  74 */     setToOrtho(paramBoolean, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setToOrtho(boolean paramBoolean, float paramFloat1, float paramFloat2) {
/*  83 */     if (paramBoolean) {
/*  84 */       this.up.set(0.0F, -1.0F, 0.0F);
/*  85 */       this.direction.set(0.0F, 0.0F, 1.0F);
/*     */     } else {
/*  87 */       this.up.set(0.0F, 1.0F, 0.0F);
/*  88 */       this.direction.set(0.0F, 0.0F, -1.0F);
/*     */     } 
/*  90 */     this.position.set(this.zoom * paramFloat1 / 2.0F, this.zoom * paramFloat2 / 2.0F, 0.0F);
/*  91 */     this.viewportWidth = paramFloat1;
/*  92 */     this.viewportHeight = paramFloat2;
/*  93 */     update();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rotate(float paramFloat) {
/*  99 */     rotate(this.direction, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void translate(float paramFloat1, float paramFloat2) {
/* 106 */     translate(paramFloat1, paramFloat2, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void translate(Vector2 paramVector2) {
/* 112 */     translate(paramVector2.x, paramVector2.y, 0.0F);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\OrthographicCamera.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */