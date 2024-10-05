/*    */ package com.badlogic.gdx.graphics.g3d.particles.influencers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
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
/*    */ public class ParticleControllerFinalizerInfluencer
/*    */   extends Influencer
/*    */ {
/*    */   ParallelArray.FloatChannel positionChannel;
/*    */   ParallelArray.FloatChannel scaleChannel;
/*    */   ParallelArray.FloatChannel rotationChannel;
/*    */   ParallelArray.ObjectChannel<ParticleController> controllerChannel;
/*    */   boolean hasScale;
/*    */   boolean hasRotation;
/*    */   
/*    */   public void init() {
/* 38 */     this.controllerChannel = (ParallelArray.ObjectChannel<ParticleController>)this.controller.particles.getChannel(ParticleChannels.ParticleController);
/* 39 */     if (this.controllerChannel == null) throw new GdxRuntimeException("ParticleController channel not found, specify an influencer which will allocate it please.");
/*    */     
/* 41 */     this.scaleChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Scale);
/* 42 */     this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Rotation3D);
/* 43 */     this.hasScale = (this.scaleChannel != null);
/* 44 */     this.hasRotation = (this.rotationChannel != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void allocateChannels() {
/* 49 */     this.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 54 */     byte b = 0; int i = 0;
/* 55 */     for (int j = this.controller.particles.size; b < j; b++, i += this.positionChannel.strideSize) {
/* 56 */       ParticleController particleController = ((ParticleController[])this.controllerChannel.data)[b];
/* 57 */       float f1 = this.hasScale ? this.scaleChannel.data[b] : 1.0F;
/* 58 */       float f2 = 0.0F, f3 = 0.0F, f4 = 0.0F, f5 = 1.0F;
/* 59 */       if (this.hasRotation) {
/* 60 */         int k = b * this.rotationChannel.strideSize;
/* 61 */         f2 = this.rotationChannel.data[k];
/* 62 */         f3 = this.rotationChannel.data[k + 1];
/* 63 */         f4 = this.rotationChannel.data[k + 2];
/* 64 */         f5 = this.rotationChannel.data[k + 3];
/*    */       } 
/* 66 */       particleController.setTransform(this.positionChannel.data[i], this.positionChannel.data[i + 1], this.positionChannel.data[i + 2], f2, f3, f4, f5, f1);
/*    */ 
/*    */       
/* 69 */       particleController.update();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public ParticleControllerFinalizerInfluencer copy() {
/* 75 */     return new ParticleControllerFinalizerInfluencer();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\influencers\ParticleControllerFinalizerInfluencer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */