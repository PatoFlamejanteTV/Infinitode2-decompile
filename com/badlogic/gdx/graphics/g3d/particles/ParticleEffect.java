/*     */ package com.badlogic.gdx.graphics.g3d.particles;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
/*     */ import com.badlogic.gdx.math.Matrix4;
/*     */ import com.badlogic.gdx.math.Quaternion;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.math.collision.BoundingBox;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Disposable;
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
/*     */ public class ParticleEffect
/*     */   implements ResourceData.Configurable, Disposable
/*     */ {
/*     */   private Array<ParticleController> controllers;
/*     */   private BoundingBox bounds;
/*     */   
/*     */   public ParticleEffect() {
/*  36 */     this.controllers = new Array(true, 3, ParticleController.class);
/*     */   }
/*     */   
/*     */   public ParticleEffect(ParticleEffect paramParticleEffect) {
/*  40 */     this.controllers = new Array(true, paramParticleEffect.controllers.size); byte b; int i;
/*  41 */     for (b = 0, i = paramParticleEffect.controllers.size; b < i; b++)
/*  42 */       this.controllers.add(((ParticleController)paramParticleEffect.controllers.get(b)).copy()); 
/*     */   }
/*     */   
/*     */   public ParticleEffect(ParticleController... paramVarArgs) {
/*  46 */     this.controllers = new Array((Object[])paramVarArgs);
/*     */   } public void init() {
/*     */     byte b;
/*     */     int i;
/*  50 */     for (b = 0, i = this.controllers.size; b < i; b++)
/*  51 */       ((ParticleController)this.controllers.get(b)).init(); 
/*     */   } public void start() {
/*     */     byte b;
/*     */     int i;
/*  55 */     for (b = 0, i = this.controllers.size; b < i; b++)
/*  56 */       ((ParticleController)this.controllers.get(b)).start(); 
/*     */   } public void end() {
/*     */     byte b;
/*     */     int i;
/*  60 */     for (b = 0, i = this.controllers.size; b < i; b++)
/*  61 */       ((ParticleController)this.controllers.get(b)).end(); 
/*     */   } public void reset() {
/*     */     byte b;
/*     */     int i;
/*  65 */     for (b = 0, i = this.controllers.size; b < i; b++)
/*  66 */       ((ParticleController)this.controllers.get(b)).reset(); 
/*     */   } public void update() {
/*     */     byte b;
/*     */     int i;
/*  70 */     for (b = 0, i = this.controllers.size; b < i; b++)
/*  71 */       ((ParticleController)this.controllers.get(b)).update(); 
/*     */   } public void update(float paramFloat) {
/*     */     byte b;
/*     */     int i;
/*  75 */     for (b = 0, i = this.controllers.size; b < i; b++)
/*  76 */       ((ParticleController)this.controllers.get(b)).update(paramFloat); 
/*     */   } public void draw() {
/*     */     byte b;
/*     */     int i;
/*  80 */     for (b = 0, i = this.controllers.size; b < i; b++)
/*  81 */       ((ParticleController)this.controllers.get(b)).draw(); 
/*     */   } public boolean isComplete() {
/*     */     byte b;
/*     */     int i;
/*  85 */     for (b = 0, i = this.controllers.size; b < i; b++) {
/*  86 */       if (!((ParticleController)this.controllers.get(b)).isComplete()) {
/*  87 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  91 */     return true;
/*     */   }
/*     */   public void setTransform(Matrix4 paramMatrix4) {
/*     */     byte b;
/*     */     int i;
/*  96 */     for (b = 0, i = this.controllers.size; b < i; b++)
/*  97 */       ((ParticleController)this.controllers.get(b)).setTransform(paramMatrix4); 
/*     */   }
/*     */   public void rotate(Quaternion paramQuaternion) {
/*     */     byte b;
/*     */     int i;
/* 102 */     for (b = 0, i = this.controllers.size; b < i; b++) {
/* 103 */       ((ParticleController)this.controllers.get(b)).rotate(paramQuaternion);
/*     */     }
/*     */   }
/*     */   
/*     */   public void rotate(Vector3 paramVector3, float paramFloat) {
/*     */     byte b;
/*     */     int i;
/* 110 */     for (b = 0, i = this.controllers.size; b < i; b++)
/* 111 */       ((ParticleController)this.controllers.get(b)).rotate(paramVector3, paramFloat); 
/*     */   }
/*     */   public void translate(Vector3 paramVector3) {
/*     */     byte b;
/*     */     int i;
/* 116 */     for (b = 0, i = this.controllers.size; b < i; b++)
/* 117 */       ((ParticleController)this.controllers.get(b)).translate(paramVector3); 
/*     */   }
/*     */   public void scale(float paramFloat1, float paramFloat2, float paramFloat3) {
/*     */     byte b;
/*     */     int i;
/* 122 */     for (b = 0, i = this.controllers.size; b < i; b++)
/* 123 */       ((ParticleController)this.controllers.get(b)).scale(paramFloat1, paramFloat2, paramFloat3); 
/*     */   }
/*     */   public void scale(Vector3 paramVector3) {
/*     */     byte b;
/*     */     int i;
/* 128 */     for (b = 0, i = this.controllers.size; b < i; b++) {
/* 129 */       ((ParticleController)this.controllers.get(b)).scale(paramVector3.x, paramVector3.y, paramVector3.z);
/*     */     }
/*     */   }
/*     */   
/*     */   public Array<ParticleController> getControllers() {
/* 134 */     return this.controllers;
/*     */   }
/*     */   public ParticleController findController(String paramString) {
/*     */     byte b;
/*     */     int i;
/* 139 */     for (b = 0, i = this.controllers.size; b < i; b++) {
/*     */       ParticleController particleController;
/* 141 */       if ((particleController = (ParticleController)this.controllers.get(b)).name.equals(paramString)) return particleController; 
/*     */     } 
/* 143 */     return null;
/*     */   } public void dispose() {
/*     */     byte b;
/*     */     int i;
/* 147 */     for (b = 0, i = this.controllers.size; b < i; b++) {
/* 148 */       ((ParticleController)this.controllers.get(b)).dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BoundingBox getBoundingBox() {
/* 154 */     if (this.bounds == null) this.bounds = new BoundingBox();
/*     */     
/*     */     BoundingBox boundingBox;
/* 157 */     (boundingBox = this.bounds).inf();
/* 158 */     for (Array.ArrayIterator<ParticleController> arrayIterator = this.controllers.iterator(); arrayIterator.hasNext(); ) { ParticleController particleController = arrayIterator.next();
/* 159 */       boundingBox.ext(particleController.getBoundingBox()); }
/* 160 */      return boundingBox;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBatch(Array<ParticleBatch<?>> paramArray) {
/* 166 */     for (Array.ArrayIterator<ParticleController> arrayIterator = this.controllers.iterator(); arrayIterator.hasNext(); ) { ParticleController particleController = arrayIterator.next();
/* 167 */       for (Array.ArrayIterator<ParticleBatch> arrayIterator1 = paramArray.iterator(); arrayIterator1.hasNext(); ) { ParticleBatch particleBatch = arrayIterator1.next();
/* 168 */         if (!particleController.renderer.setBatch(particleBatch)); }
/*     */        }
/*     */   
/*     */   }
/*     */   
/*     */   public ParticleEffect copy() {
/* 174 */     return new ParticleEffect(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 179 */     for (Array.ArrayIterator<ParticleController> arrayIterator = this.controllers.iterator(); arrayIterator.hasNext();) {
/* 180 */       (particleController = arrayIterator.next()).save(paramAssetManager, paramResourceData);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 187 */     for (Array.ArrayIterator<ParticleController> arrayIterator = this.controllers.iterator(); arrayIterator.hasNext();)
/* 188 */       (particleController = arrayIterator.next()).load(paramAssetManager, paramResourceData); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\ParticleEffect.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */