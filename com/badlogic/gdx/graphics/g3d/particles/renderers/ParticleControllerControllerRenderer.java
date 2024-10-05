/*    */ package com.badlogic.gdx.graphics.g3d.particles.renderers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
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
/*    */ public class ParticleControllerControllerRenderer
/*    */   extends ParticleControllerRenderer
/*    */ {
/*    */   ParallelArray.ObjectChannel<ParticleController> controllerChannel;
/*    */   
/*    */   public void init() {
/* 34 */     this.controllerChannel = (ParallelArray.ObjectChannel<ParticleController>)this.controller.particles.getChannel(ParticleChannels.ParticleController);
/* 35 */     if (this.controllerChannel == null) throw new GdxRuntimeException("ParticleController channel not found, specify an influencer which will allocate it please."); 
/*    */   }
/*    */   
/*    */   public void update() {
/*    */     byte b;
/*    */     int i;
/* 41 */     for (b = 0, i = this.controller.particles.size; b < i; b++) {
/* 42 */       ((ParticleController[])this.controllerChannel.data)[b].draw();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public ParticleControllerComponent copy() {
/* 48 */     return new ParticleControllerControllerRenderer();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCompatible(ParticleBatch paramParticleBatch) {
/* 53 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\renderers\ParticleControllerControllerRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */