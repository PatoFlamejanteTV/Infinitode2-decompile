/*    */ package com.badlogic.gdx.graphics.g3d.particles.renderers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.Material;
/*    */ import com.badlogic.gdx.graphics.g3d.ModelInstance;
/*    */ import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
/*    */ import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.batches.ModelInstanceParticleBatch;
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
/*    */ public class ModelInstanceRenderer
/*    */   extends ParticleControllerRenderer<ModelInstanceControllerRenderData, ModelInstanceParticleBatch>
/*    */ {
/*    */   private boolean hasColor;
/*    */   private boolean hasScale;
/*    */   private boolean hasRotation;
/*    */   
/*    */   public ModelInstanceRenderer() {
/* 35 */     super(new ModelInstanceControllerRenderData());
/*    */   }
/*    */   
/*    */   public ModelInstanceRenderer(ModelInstanceParticleBatch paramModelInstanceParticleBatch) {
/* 39 */     this();
/* 40 */     setBatch((ParticleBatch<?>)paramModelInstanceParticleBatch);
/*    */   }
/*    */ 
/*    */   
/*    */   public void allocateChannels() {
/* 45 */     this.renderData.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {
/* 50 */     this.renderData.modelInstanceChannel = (ParallelArray.ObjectChannel<ModelInstance>)this.controller.particles.getChannel(ParticleChannels.ModelInstance);
/* 51 */     this.renderData.colorChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Color);
/* 52 */     this.renderData.scaleChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Scale);
/* 53 */     this.renderData.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Rotation3D);
/* 54 */     this.hasColor = (this.renderData.colorChannel != null);
/* 55 */     this.hasScale = (this.renderData.scaleChannel != null);
/* 56 */     this.hasRotation = (this.renderData.rotationChannel != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 61 */     byte b = 0; int i = 0;
/* 62 */     for (int j = this.controller.particles.size; b < j; b++, i += this.renderData.positionChannel.strideSize) {
/* 63 */       ModelInstance modelInstance = ((ModelInstance[])this.renderData.modelInstanceChannel.data)[b];
/* 64 */       float f1 = this.hasScale ? this.renderData.scaleChannel.data[b] : 1.0F;
/* 65 */       float f2 = 0.0F, f3 = 0.0F, f4 = 0.0F, f5 = 1.0F;
/* 66 */       if (this.hasRotation) {
/* 67 */         int k = b * this.renderData.rotationChannel.strideSize;
/* 68 */         f2 = this.renderData.rotationChannel.data[k];
/* 69 */         f3 = this.renderData.rotationChannel.data[k + 1];
/* 70 */         f4 = this.renderData.rotationChannel.data[k + 2];
/* 71 */         f5 = this.renderData.rotationChannel.data[k + 3];
/*    */       } 
/*    */       
/* 74 */       modelInstance.transform.set(this.renderData.positionChannel.data[i], this.renderData.positionChannel.data[i + 1], this.renderData.positionChannel.data[i + 2], f2, f3, f4, f5, f1, f1, f1);
/*    */ 
/*    */       
/* 77 */       if (this.hasColor) {
/* 78 */         int k = b * this.renderData.colorChannel.strideSize;
/* 79 */         ColorAttribute colorAttribute = (ColorAttribute)((Material)modelInstance.materials.get(0)).get(ColorAttribute.Diffuse);
/* 80 */         BlendingAttribute blendingAttribute = (BlendingAttribute)((Material)modelInstance.materials.get(0)).get(BlendingAttribute.Type);
/* 81 */         colorAttribute.color.r = this.renderData.colorChannel.data[k];
/* 82 */         colorAttribute.color.g = this.renderData.colorChannel.data[k + 1];
/* 83 */         colorAttribute.color.b = this.renderData.colorChannel.data[k + 2];
/* 84 */         if (blendingAttribute != null)
/* 85 */           blendingAttribute.opacity = this.renderData.colorChannel.data[k + 3]; 
/*    */       } 
/*    */     } 
/* 88 */     super.update();
/*    */   }
/*    */ 
/*    */   
/*    */   public ParticleControllerComponent copy() {
/* 93 */     return new ModelInstanceRenderer(this.batch);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCompatible(ParticleBatch<?> paramParticleBatch) {
/* 98 */     return paramParticleBatch instanceof ModelInstanceParticleBatch;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\renderers\ModelInstanceRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */