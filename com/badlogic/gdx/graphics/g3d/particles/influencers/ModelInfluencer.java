/*     */ package com.badlogic.gdx.graphics.g3d.particles.influencers;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetDescriptor;
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.graphics.g3d.Model;
/*     */ import com.badlogic.gdx.graphics.g3d.ModelInstance;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
/*     */ import com.badlogic.gdx.utils.Array;
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
/*     */ public abstract class ModelInfluencer
/*     */   extends Influencer
/*     */ {
/*     */   public Array<Model> models;
/*     */   ParallelArray.ObjectChannel<ModelInstance> modelChannel;
/*     */   
/*     */   public static class Single
/*     */     extends ModelInfluencer
/*     */   {
/*     */     public Single() {}
/*     */     
/*     */     public Single(Single param1Single) {
/*  42 */       super(param1Single);
/*     */     }
/*     */     
/*     */     public Single(Model... param1VarArgs) {
/*  46 */       super(param1VarArgs);
/*     */     }
/*     */ 
/*     */     
/*     */     public void init() {
/*  51 */       Model model = (Model)this.models.first(); byte b; int i;
/*  52 */       for (b = 0, i = this.controller.emitter.maxParticleCount; b < i; b++) {
/*  53 */         ((ModelInstance[])this.modelChannel.data)[b] = new ModelInstance(model);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public Single copy() {
/*  59 */       return new Single(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Random
/*     */     extends ModelInfluencer
/*     */   {
/*     */     ModelInstancePool pool;
/*     */     
/*     */     private class ModelInstancePool
/*     */       extends Pool<ModelInstance> {
/*     */       public ModelInstance newObject() {
/*  71 */         return new ModelInstance((Model)ModelInfluencer.Random.this.models.random());
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Random() {
/*  79 */       this.pool = new ModelInstancePool();
/*     */     }
/*     */     
/*     */     public Random(Random param1Random) {
/*  83 */       super(param1Random);
/*  84 */       this.pool = new ModelInstancePool();
/*     */     }
/*     */     
/*     */     public Random(Model... param1VarArgs) {
/*  88 */       super(param1VarArgs);
/*  89 */       this.pool = new ModelInstancePool();
/*     */     }
/*     */ 
/*     */     
/*     */     public void init() {
/*  94 */       this.pool.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public void activateParticles(int param1Int1, int param1Int2) {
/*  99 */       for (int i = param1Int1; i < param1Int1; i++) {
/* 100 */         ((ModelInstance[])this.modelChannel.data)[i] = (ModelInstance)this.pool.obtain();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void killParticles(int param1Int1, int param1Int2) {
/* 106 */       for (int i = param1Int1; i < param1Int1; i++) {
/* 107 */         this.pool.free(((ModelInstance[])this.modelChannel.data)[i]);
/* 108 */         ((ModelInstance[])this.modelChannel.data)[i] = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Random copy() {
/* 114 */       return new Random(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelInfluencer() {
/* 122 */     this.models = new Array(true, 1, Model.class);
/*     */   }
/*     */   
/*     */   public ModelInfluencer(Model... paramVarArgs) {
/* 126 */     this.models = new Array((Object[])paramVarArgs);
/*     */   }
/*     */   
/*     */   public ModelInfluencer(ModelInfluencer paramModelInfluencer) {
/* 130 */     this((Model[])paramModelInfluencer.models.toArray(Model.class));
/*     */   }
/*     */ 
/*     */   
/*     */   public void allocateChannels() {
/* 135 */     this.modelChannel = (ParallelArray.ObjectChannel<ModelInstance>)this.controller.particles.addChannel(ParticleChannels.ModelInstance);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 140 */     ResourceData.SaveData saveData = paramResourceData.createSaveData();
/* 141 */     for (Array.ArrayIterator<Model> arrayIterator = this.models.iterator(); arrayIterator.hasNext(); ) { Model model = arrayIterator.next();
/* 142 */       saveData.saveAsset(paramAssetManager.getAssetFileName(model), Model.class); }
/*     */   
/*     */   }
/*     */   
/*     */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 147 */     ResourceData.SaveData saveData = paramResourceData.getSaveData();
/*     */     AssetDescriptor assetDescriptor;
/* 149 */     while ((assetDescriptor = saveData.loadAsset()) != null) {
/*     */       Model model;
/* 151 */       if ((model = (Model)paramAssetManager.get(assetDescriptor)) == null) throw new RuntimeException("Model is null"); 
/* 152 */       this.models.add(model);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\influencers\ModelInfluencer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */