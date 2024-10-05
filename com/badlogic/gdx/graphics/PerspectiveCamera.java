/*    */ package com.badlogic.gdx.graphics;
/*    */ 
/*    */ import com.badlogic.gdx.math.Matrix4;
/*    */ import com.badlogic.gdx.math.Vector3;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PerspectiveCamera
/*    */   extends Camera
/*    */ {
/* 27 */   public float fieldOfView = 67.0F;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   final Vector3 tmp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PerspectiveCamera() {
/* 46 */     this.tmp = new Vector3(); } public PerspectiveCamera(float paramFloat1, float paramFloat2, float paramFloat3) { this.tmp = new Vector3();
/*    */     this.fieldOfView = paramFloat1;
/*    */     this.viewportWidth = paramFloat2;
/*    */     this.viewportHeight = paramFloat3;
/* 50 */     update(); } public void update() { update(true); }
/*    */ 
/*    */ 
/*    */   
/*    */   public void update(boolean paramBoolean) {
/* 55 */     float f = this.viewportWidth / this.viewportHeight;
/* 56 */     this.projection.setToProjection(Math.abs(this.near), Math.abs(this.far), this.fieldOfView, f);
/* 57 */     this.view.setToLookAt(this.position, this.tmp.set(this.position).add(this.direction), this.up);
/* 58 */     this.combined.set(this.projection);
/* 59 */     Matrix4.mul(this.combined.val, this.view.val);
/*    */     
/* 61 */     if (paramBoolean) {
/* 62 */       this.invProjectionView.set(this.combined);
/* 63 */       Matrix4.inv(this.invProjectionView.val);
/* 64 */       this.frustum.update(this.invProjectionView);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\PerspectiveCamera.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */