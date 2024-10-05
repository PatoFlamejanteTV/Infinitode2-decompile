/*     */ package com.badlogic.gdx.graphics.g3d.particles.influencers;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Pool;
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
/*     */ public abstract class ParticleControllerInfluencer
/*     */   extends Influencer
/*     */ {
/*     */   public Array<ParticleController> templates;
/*     */   ParallelArray.ObjectChannel<ParticleController> particleControllerChannel;
/*     */   
/*     */   public static class Single
/*     */     extends ParticleControllerInfluencer
/*     */   {
/*     */     public Single(ParticleController... param1VarArgs) {
/*  41 */       super(param1VarArgs);
/*     */     }
/*     */ 
/*     */     
/*     */     public Single() {}
/*     */ 
/*     */     
/*     */     public Single(Single param1Single) {
/*  49 */       super(param1Single);
/*     */     }
/*     */ 
/*     */     
/*     */     public void init() {
/*  54 */       ParticleController particleController = (ParticleController)this.templates.first(); byte b; int i;
/*  55 */       for (b = 0, i = this.controller.particles.capacity; b < i; b++) {
/*     */         ParticleController particleController1;
/*  57 */         (particleController1 = particleController.copy()).init();
/*  58 */         ((ParticleController[])this.particleControllerChannel.data)[b] = particleController1;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void activateParticles(int param1Int1, int param1Int2) {
/*  64 */       for (int i = param1Int1; i < param1Int1; i++) {
/*  65 */         ((ParticleController[])this.particleControllerChannel.data)[i].start();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void killParticles(int param1Int1, int param1Int2) {
/*  71 */       for (int i = param1Int1; i < param1Int1; i++) {
/*  72 */         ((ParticleController[])this.particleControllerChannel.data)[i].end();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public Single copy() {
/*  78 */       return new Single(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Random
/*     */     extends ParticleControllerInfluencer
/*     */   {
/*     */     ParticleControllerPool pool;
/*     */     
/*     */     private class ParticleControllerPool
/*     */       extends Pool<ParticleController> {
/*     */       public ParticleController newObject() {
/*     */         ParticleController particleController;
/*  91 */         (particleController = ((ParticleController)ParticleControllerInfluencer.Random.this.templates.random()).copy()).init();
/*  92 */         return particleController;
/*     */       }
/*     */       
/*     */       public void clear() {
/*     */         byte b;
/*     */         int i;
/*  98 */         for (b = 0, i = ParticleControllerInfluencer.Random.this.pool.getFree(); b < i; b++) {
/*  99 */           ((ParticleController)ParticleControllerInfluencer.Random.this.pool.obtain()).dispose();
/*     */         }
/* 101 */         super.clear();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Random() {
/* 109 */       this.pool = new ParticleControllerPool();
/*     */     }
/*     */     
/*     */     public Random(ParticleController... param1VarArgs) {
/* 113 */       super(param1VarArgs);
/* 114 */       this.pool = new ParticleControllerPool();
/*     */     }
/*     */     
/*     */     public Random(Random param1Random) {
/* 118 */       super(param1Random);
/* 119 */       this.pool = new ParticleControllerPool();
/*     */     }
/*     */ 
/*     */     
/*     */     public void init() {
/* 124 */       this.pool.clear();
/*     */       
/* 126 */       for (byte b = 0; b < this.controller.emitter.maxParticleCount; b++) {
/* 127 */         this.pool.free(this.pool.newObject());
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void dispose() {
/* 133 */       this.pool.clear();
/* 134 */       super.dispose();
/*     */     }
/*     */ 
/*     */     
/*     */     public void activateParticles(int param1Int1, int param1Int2) {
/* 139 */       for (int i = param1Int1; i < param1Int1; i++) {
/*     */         ParticleController particleController;
/* 141 */         (particleController = (ParticleController)this.pool.obtain()).start();
/* 142 */         ((ParticleController[])this.particleControllerChannel.data)[i] = particleController;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void killParticles(int param1Int1, int param1Int2) {
/* 148 */       for (int i = param1Int1; i < param1Int1; i++) {
/*     */         ParticleController particleController;
/* 150 */         (particleController = ((ParticleController[])this.particleControllerChannel.data)[i]).end();
/* 151 */         this.pool.free(particleController);
/* 152 */         ((ParticleController[])this.particleControllerChannel.data)[i] = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Random copy() {
/* 158 */       return new Random(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ParticleControllerInfluencer() {
/* 166 */     this.templates = new Array(true, 1, ParticleController.class);
/*     */   }
/*     */   
/*     */   public ParticleControllerInfluencer(ParticleController... paramVarArgs) {
/* 170 */     this.templates = new Array((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public ParticleControllerInfluencer(ParticleControllerInfluencer paramParticleControllerInfluencer) {
/* 174 */     this((ParticleController[])paramParticleControllerInfluencer.templates.items);
/*     */   }
/*     */ 
/*     */   
/*     */   public void allocateChannels() {
/* 179 */     this.particleControllerChannel = (ParallelArray.ObjectChannel<ParticleController>)this.controller.particles.addChannel(ParticleChannels.ParticleController);
/*     */   }
/*     */ 
/*     */   
/*     */   public void end() {
/* 184 */     for (byte b = 0; b < this.controller.particles.size; b++) {
/* 185 */       ((ParticleController[])this.particleControllerChannel.data)[b].end();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 191 */     if (this.controller != null) {
/* 192 */       for (byte b = 0; b < this.controller.particles.size; b++) {
/*     */         ParticleController particleController;
/* 194 */         if ((particleController = ((ParticleController[])this.particleControllerChannel.data)[b]) != null) {
/* 195 */           particleController.dispose();
/* 196 */           ((ParticleController[])this.particleControllerChannel.data)[b] = null;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 204 */     ResourceData.SaveData saveData = paramResourceData.createSaveData();
/* 205 */     Array array1 = paramAssetManager.getAll(ParticleEffect.class, new Array());
/*     */     
/* 207 */     Array array2 = new Array(this.templates);
/* 208 */     Array array3 = new Array();
/*     */     
/* 210 */     for (byte b = 0; b < array1.size && array2.size > 0; b++) {
/*     */       ParticleEffect particleEffect;
/* 212 */       Array array = (particleEffect = (ParticleEffect)array1.get(b)).getControllers();
/* 213 */       Array.ArrayIterator<ParticleController> arrayIterator = array2.iterator();
/* 214 */       IntArray intArray = null;
/* 215 */       while (arrayIterator.hasNext()) {
/* 216 */         ParticleController particleController = arrayIterator.next();
/*     */         int i;
/* 218 */         if ((i = array.indexOf(particleController, true)) >= 0) {
/* 219 */           if (intArray == null) {
/* 220 */             intArray = new IntArray();
/*     */           }
/* 222 */           arrayIterator.remove();
/* 223 */           intArray.add(i);
/*     */         } 
/*     */       } 
/*     */       
/* 227 */       if (intArray != null) {
/* 228 */         saveData.saveAsset(paramAssetManager.getAssetFileName(particleEffect), ParticleEffect.class);
/* 229 */         array3.add(intArray);
/*     */       } 
/*     */     } 
/* 232 */     saveData.save("indices", array3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {
/*     */     ResourceData.SaveData saveData;
/*     */     Array array;
/* 240 */     Array.ArrayIterator<IntArray> arrayIterator = (array = (Array)(saveData = paramResourceData.getSaveData()).load("indices")).iterator(); AssetDescriptor assetDescriptor;
/* 241 */     while ((assetDescriptor = saveData.loadAsset()) != null) {
/*     */       ParticleEffect particleEffect;
/* 243 */       if ((particleEffect = (ParticleEffect)paramAssetManager.get(assetDescriptor)) == null) throw new RuntimeException("Template is null"); 
/* 244 */       Array array1 = particleEffect.getControllers();
/* 245 */       IntArray intArray = arrayIterator.next(); byte b;
/*     */       int i;
/* 247 */       for (b = 0, i = intArray.size; b < i; b++)
/* 248 */         this.templates.add(array1.get(intArray.get(b))); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\influencers\ParticleControllerInfluencer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */