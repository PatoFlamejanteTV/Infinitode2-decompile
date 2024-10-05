/*    */ package com.badlogic.gdx.graphics.g3d.particles.renderers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
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
/*    */ 
/*    */ public abstract class ParticleControllerRenderer<D extends ParticleControllerRenderData, T extends ParticleBatch<D>>
/*    */   extends ParticleControllerComponent
/*    */ {
/*    */   protected T batch;
/*    */   protected D renderData;
/*    */   
/*    */   protected ParticleControllerRenderer() {}
/*    */   
/*    */   protected ParticleControllerRenderer(D paramD) {
/* 35 */     this.renderData = paramD;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 40 */     this.batch.draw((ParticleControllerRenderData)this.renderData);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean setBatch(ParticleBatch<?> paramParticleBatch) {
/* 45 */     if (isCompatible(paramParticleBatch)) {
/* 46 */       this.batch = (T)paramParticleBatch;
/* 47 */       return true;
/*    */     } 
/* 49 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract boolean isCompatible(ParticleBatch<?> paramParticleBatch);
/*    */   
/*    */   public void set(ParticleController paramParticleController) {
/* 56 */     super.set(paramParticleController);
/* 57 */     if (this.renderData != null) ((ParticleControllerRenderData)this.renderData).controller = this.controller; 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\renderers\ParticleControllerRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */