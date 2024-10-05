/*     */ package com.badlogic.gdx.utils.viewport;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.graphics.glutils.HdpiUtils;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.math.collision.Ray;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
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
/*     */ public abstract class Viewport
/*     */ {
/*     */   private Camera camera;
/*     */   private float worldWidth;
/*     */   private float worldHeight;
/*     */   private int screenX;
/*     */   private int screenY;
/*     */   private int screenWidth;
/*     */   private int screenHeight;
/*  39 */   private final Vector3 tmp = new Vector3();
/*     */ 
/*     */   
/*     */   public void apply() {
/*  43 */     apply(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void apply(boolean paramBoolean) {
/*  49 */     HdpiUtils.glViewport(this.screenX, this.screenY, this.screenWidth, this.screenHeight);
/*  50 */     this.camera.viewportWidth = this.worldWidth;
/*  51 */     this.camera.viewportHeight = this.worldHeight;
/*  52 */     if (paramBoolean) this.camera.position.set(this.worldWidth / 2.0F, this.worldHeight / 2.0F, 0.0F); 
/*  53 */     this.camera.update();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(int paramInt1, int paramInt2) {
/*  58 */     update(paramInt1, paramInt2, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  66 */     apply(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 unproject(Vector2 paramVector2) {
/*  73 */     this.tmp.set(paramVector2.x, paramVector2.y, 1.0F);
/*  74 */     this.camera.unproject(this.tmp, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
/*  75 */     paramVector2.set(this.tmp.x, this.tmp.y);
/*  76 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 project(Vector2 paramVector2) {
/*  83 */     this.tmp.set(paramVector2.x, paramVector2.y, 1.0F);
/*  84 */     this.camera.project(this.tmp, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
/*  85 */     paramVector2.set(this.tmp.x, this.tmp.y);
/*  86 */     return paramVector2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 unproject(Vector3 paramVector3) {
/*  93 */     this.camera.unproject(paramVector3, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
/*  94 */     return paramVector3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector3 project(Vector3 paramVector3) {
/* 101 */     this.camera.project(paramVector3, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
/* 102 */     return paramVector3;
/*     */   }
/*     */ 
/*     */   
/*     */   public Ray getPickRay(float paramFloat1, float paramFloat2) {
/* 107 */     return this.camera.getPickRay(paramFloat1, paramFloat2, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
/*     */   }
/*     */ 
/*     */   
/*     */   public void calculateScissors(Matrix4 paramMatrix4, Rectangle paramRectangle1, Rectangle paramRectangle2) {
/* 112 */     ScissorStack.calculateScissors(this.camera, this.screenX, this.screenY, this.screenWidth, this.screenHeight, paramMatrix4, paramRectangle1, paramRectangle2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Vector2 toScreenCoordinates(Vector2 paramVector2, Matrix4 paramMatrix4) {
/* 118 */     this.tmp.set(paramVector2.x, paramVector2.y, 0.0F);
/* 119 */     this.tmp.mul(paramMatrix4);
/* 120 */     this.camera.project(this.tmp, this.screenX, this.screenY, this.screenWidth, this.screenHeight);
/* 121 */     this.tmp.y = Gdx.graphics.getHeight() - this.tmp.y;
/* 122 */     paramVector2.x = this.tmp.x;
/* 123 */     paramVector2.y = this.tmp.y;
/* 124 */     return paramVector2;
/*     */   }
/*     */   
/*     */   public Camera getCamera() {
/* 128 */     return this.camera;
/*     */   }
/*     */   
/*     */   public void setCamera(Camera paramCamera) {
/* 132 */     this.camera = paramCamera;
/*     */   }
/*     */   
/*     */   public float getWorldWidth() {
/* 136 */     return this.worldWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWorldWidth(float paramFloat) {
/* 141 */     this.worldWidth = paramFloat;
/*     */   }
/*     */   
/*     */   public float getWorldHeight() {
/* 145 */     return this.worldHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWorldHeight(float paramFloat) {
/* 150 */     this.worldHeight = paramFloat;
/*     */   }
/*     */   
/*     */   public void setWorldSize(float paramFloat1, float paramFloat2) {
/* 154 */     this.worldWidth = paramFloat1;
/* 155 */     this.worldHeight = paramFloat2;
/*     */   }
/*     */   
/*     */   public int getScreenX() {
/* 159 */     return this.screenX;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScreenX(int paramInt) {
/* 165 */     this.screenX = paramInt;
/*     */   }
/*     */   
/*     */   public int getScreenY() {
/* 169 */     return this.screenY;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScreenY(int paramInt) {
/* 175 */     this.screenY = paramInt;
/*     */   }
/*     */   
/*     */   public int getScreenWidth() {
/* 179 */     return this.screenWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScreenWidth(int paramInt) {
/* 184 */     this.screenWidth = paramInt;
/*     */   }
/*     */   
/*     */   public int getScreenHeight() {
/* 188 */     return this.screenHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScreenHeight(int paramInt) {
/* 193 */     this.screenHeight = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScreenPosition(int paramInt1, int paramInt2) {
/* 198 */     this.screenX = paramInt1;
/* 199 */     this.screenY = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScreenSize(int paramInt1, int paramInt2) {
/* 204 */     this.screenWidth = paramInt1;
/* 205 */     this.screenHeight = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScreenBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 210 */     this.screenX = paramInt1;
/* 211 */     this.screenY = paramInt2;
/* 212 */     this.screenWidth = paramInt3;
/* 213 */     this.screenHeight = paramInt4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLeftGutterWidth() {
/* 218 */     return this.screenX;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRightGutterX() {
/* 223 */     return this.screenX + this.screenWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRightGutterWidth() {
/* 228 */     return Gdx.graphics.getWidth() - this.screenX + this.screenWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBottomGutterHeight() {
/* 233 */     return this.screenY;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTopGutterY() {
/* 238 */     return this.screenY + this.screenHeight;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTopGutterHeight() {
/* 243 */     return Gdx.graphics.getHeight() - this.screenY + this.screenHeight;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\viewport\Viewport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */