/*    */ package com.badlogic.gdx.graphics.g3d.particles.batches;
/*    */ 
/*    */ import com.badlogic.gdx.assets.AssetManager;
/*    */ import com.badlogic.gdx.graphics.g3d.ModelInstance;
/*    */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.renderers.ModelInstanceControllerRenderData;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.Pool;
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
/*    */ public class ModelInstanceParticleBatch
/*    */   implements ParticleBatch<ModelInstanceControllerRenderData>
/*    */ {
/* 33 */   Array<ModelInstanceControllerRenderData> controllersRenderData = new Array(false, 5);
/*    */   
/*    */   int bufferedParticlesCount;
/*    */   
/*    */   public void getRenderables(Array<Renderable> paramArray, Pool<Renderable> paramPool) {
/* 38 */     for (Array.ArrayIterator<ModelInstanceControllerRenderData> arrayIterator = this.controllersRenderData.iterator(); arrayIterator.hasNext(); ) { ModelInstanceControllerRenderData modelInstanceControllerRenderData = arrayIterator.next(); byte b; int i;
/* 39 */       for (b = 0, i = modelInstanceControllerRenderData.controller.particles.size; b < i; b++) {
/* 40 */         ((ModelInstance[])modelInstanceControllerRenderData.modelInstanceChannel.data)[b].getRenderables(paramArray, paramPool);
/*    */       } }
/*    */   
/*    */   }
/*    */   
/*    */   public int getBufferedCount() {
/* 46 */     return this.bufferedParticlesCount;
/*    */   }
/*    */ 
/*    */   
/*    */   public void begin() {
/* 51 */     this.controllersRenderData.clear();
/* 52 */     this.bufferedParticlesCount = 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void end() {}
/*    */ 
/*    */   
/*    */   public void draw(ModelInstanceControllerRenderData paramModelInstanceControllerRenderData) {
/* 61 */     this.controllersRenderData.add(paramModelInstanceControllerRenderData);
/* 62 */     this.bufferedParticlesCount += paramModelInstanceControllerRenderData.controller.particles.size;
/*    */   }
/*    */   
/*    */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {}
/*    */   
/*    */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\batches\ModelInstanceParticleBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */