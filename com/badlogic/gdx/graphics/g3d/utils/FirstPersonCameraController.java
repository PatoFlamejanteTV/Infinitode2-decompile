/*     */ package com.badlogic.gdx.graphics.g3d.utils;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.graphics.Camera;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.IntIntMap;
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
/*     */ public class FirstPersonCameraController
/*     */   extends InputAdapter
/*     */ {
/*     */   protected final Camera camera;
/*  30 */   protected final IntIntMap keys = new IntIntMap();
/*  31 */   public int strafeLeftKey = 29;
/*  32 */   public int strafeRightKey = 32;
/*  33 */   public int forwardKey = 51;
/*  34 */   public int backwardKey = 47;
/*  35 */   public int upKey = 45;
/*  36 */   public int downKey = 33;
/*     */   public boolean autoUpdate = true;
/*  38 */   protected float velocity = 5.0F;
/*  39 */   protected float degreesPerPixel = 0.5F;
/*  40 */   protected final Vector3 tmp = new Vector3();
/*     */   
/*     */   public FirstPersonCameraController(Camera paramCamera) {
/*  43 */     this.camera = paramCamera;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean keyDown(int paramInt) {
/*  48 */     this.keys.put(paramInt, paramInt);
/*  49 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean keyUp(int paramInt) {
/*  54 */     this.keys.remove(paramInt, 0);
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVelocity(float paramFloat) {
/*  61 */     this.velocity = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDegreesPerPixel(float paramFloat) {
/*  67 */     this.degreesPerPixel = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3) {
/*  72 */     float f1 = -Gdx.input.getDeltaX() * this.degreesPerPixel;
/*  73 */     float f2 = -Gdx.input.getDeltaY() * this.degreesPerPixel;
/*  74 */     this.camera.direction.rotate(this.camera.up, f1);
/*  75 */     this.tmp.set(this.camera.direction).crs(this.camera.up).nor();
/*  76 */     this.camera.direction.rotate(this.tmp, f2);
/*  77 */     return true;
/*     */   }
/*     */   
/*     */   public void update() {
/*  81 */     update(Gdx.graphics.getDeltaTime());
/*     */   }
/*     */   
/*     */   public void update(float paramFloat) {
/*  85 */     if (this.keys.containsKey(this.forwardKey)) {
/*  86 */       this.tmp.set(this.camera.direction).nor().scl(paramFloat * this.velocity);
/*  87 */       this.camera.position.add(this.tmp);
/*     */     } 
/*  89 */     if (this.keys.containsKey(this.backwardKey)) {
/*  90 */       this.tmp.set(this.camera.direction).nor().scl(-paramFloat * this.velocity);
/*  91 */       this.camera.position.add(this.tmp);
/*     */     } 
/*  93 */     if (this.keys.containsKey(this.strafeLeftKey)) {
/*  94 */       this.tmp.set(this.camera.direction).crs(this.camera.up).nor().scl(-paramFloat * this.velocity);
/*  95 */       this.camera.position.add(this.tmp);
/*     */     } 
/*  97 */     if (this.keys.containsKey(this.strafeRightKey)) {
/*  98 */       this.tmp.set(this.camera.direction).crs(this.camera.up).nor().scl(paramFloat * this.velocity);
/*  99 */       this.camera.position.add(this.tmp);
/*     */     } 
/* 101 */     if (this.keys.containsKey(this.upKey)) {
/* 102 */       this.tmp.set(this.camera.up).nor().scl(paramFloat * this.velocity);
/* 103 */       this.camera.position.add(this.tmp);
/*     */     } 
/* 105 */     if (this.keys.containsKey(this.downKey)) {
/* 106 */       this.tmp.set(this.camera.up).nor().scl(-paramFloat * this.velocity);
/* 107 */       this.camera.position.add(this.tmp);
/*     */     } 
/* 109 */     if (this.autoUpdate) this.camera.update(true); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\FirstPersonCameraController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */