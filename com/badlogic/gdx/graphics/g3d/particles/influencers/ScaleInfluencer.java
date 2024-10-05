/*    */ package com.badlogic.gdx.graphics.g3d.particles.influencers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
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
/*    */ public class ScaleInfluencer
/*    */   extends SimpleInfluencer
/*    */ {
/*    */   public ScaleInfluencer() {
/* 28 */     this.valueChannelDescriptor = ParticleChannels.Scale;
/*    */   }
/*    */ 
/*    */   
/*    */   public void activateParticles(int paramInt1, int paramInt2) {
/* 33 */     if (this.value.isRelative()) {
/* 34 */       int j = paramInt1 * this.valueChannel.strideSize; paramInt1 *= this.interpolationChannel.strideSize;
/* 35 */       for (paramInt2 = j + paramInt2 * this.valueChannel.strideSize; j < paramInt2; j += this.valueChannel.strideSize, paramInt1 += this.interpolationChannel.strideSize) {
/* 36 */         float f1 = this.value.newLowValue() * this.controller.scale.x;
/* 37 */         float f2 = this.value.newHighValue() * this.controller.scale.x;
/* 38 */         this.interpolationChannel.data[paramInt1] = f1;
/* 39 */         this.interpolationChannel.data[paramInt1 + 1] = f2;
/* 40 */         this.valueChannel.data[j] = f1 + f2 * this.value.getScale(0.0F);
/*    */       }  return;
/*    */     } 
/* 43 */     int i = paramInt1 * this.valueChannel.strideSize; paramInt1 *= this.interpolationChannel.strideSize;
/* 44 */     for (paramInt2 = i + paramInt2 * this.valueChannel.strideSize; i < paramInt2; i += this.valueChannel.strideSize, paramInt1 += this.interpolationChannel.strideSize) {
/* 45 */       float f1 = this.value.newLowValue() * this.controller.scale.x;
/* 46 */       float f2 = this.value.newHighValue() * this.controller.scale.x - f1;
/* 47 */       this.interpolationChannel.data[paramInt1] = f1;
/* 48 */       this.interpolationChannel.data[paramInt1 + 1] = f2;
/* 49 */       this.valueChannel.data[i] = f1 + f2 * this.value.getScale(0.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public ScaleInfluencer(ScaleInfluencer paramScaleInfluencer) {
/* 55 */     super(paramScaleInfluencer);
/*    */   }
/*    */ 
/*    */   
/*    */   public ParticleControllerComponent copy() {
/* 60 */     return new ScaleInfluencer(this);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\influencers\ScaleInfluencer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */