/*    */ package com.badlogic.gdx.graphics.g3d.particles.influencers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*    */ import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
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
/*    */ public abstract class SimpleInfluencer
/*    */   extends Influencer
/*    */ {
/*    */   public ScaledNumericValue value;
/*    */   ParallelArray.FloatChannel valueChannel;
/*    */   ParallelArray.FloatChannel interpolationChannel;
/*    */   ParallelArray.FloatChannel lifeChannel;
/*    */   ParallelArray.ChannelDescriptor valueChannelDescriptor;
/*    */   
/*    */   public SimpleInfluencer() {
/* 36 */     this.value = new ScaledNumericValue();
/* 37 */     this.value.setHigh(1.0F);
/*    */   }
/*    */   
/*    */   public SimpleInfluencer(SimpleInfluencer paramSimpleInfluencer) {
/* 41 */     this();
/* 42 */     set(paramSimpleInfluencer);
/*    */   }
/*    */   
/*    */   private void set(SimpleInfluencer paramSimpleInfluencer) {
/* 46 */     this.value.load(paramSimpleInfluencer.value);
/* 47 */     this.valueChannelDescriptor = paramSimpleInfluencer.valueChannelDescriptor;
/*    */   }
/*    */ 
/*    */   
/*    */   public void allocateChannels() {
/* 52 */     this.valueChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(this.valueChannelDescriptor);
/* 53 */     ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
/* 54 */     this.interpolationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation);
/* 55 */     this.lifeChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life);
/*    */   }
/*    */ 
/*    */   
/*    */   public void activateParticles(int paramInt1, int paramInt2) {
/* 60 */     if (!this.value.isRelative()) {
/* 61 */       int j = paramInt1 * this.valueChannel.strideSize; paramInt1 *= this.interpolationChannel.strideSize;
/* 62 */       for (paramInt2 = j + paramInt2 * this.valueChannel.strideSize; j < paramInt2; j += this.valueChannel.strideSize, paramInt1 += this.interpolationChannel.strideSize) {
/* 63 */         float f1 = this.value.newLowValue();
/* 64 */         float f2 = this.value.newHighValue() - f1;
/* 65 */         this.interpolationChannel.data[paramInt1] = f1;
/* 66 */         this.interpolationChannel.data[paramInt1 + 1] = f2;
/* 67 */         this.valueChannel.data[j] = f1 + f2 * this.value.getScale(0.0F);
/*    */       }  return;
/*    */     } 
/* 70 */     int i = paramInt1 * this.valueChannel.strideSize; paramInt1 *= this.interpolationChannel.strideSize;
/* 71 */     for (paramInt2 = i + paramInt2 * this.valueChannel.strideSize; i < paramInt2; i += this.valueChannel.strideSize, paramInt1 += this.interpolationChannel.strideSize) {
/* 72 */       float f1 = this.value.newLowValue();
/* 73 */       float f2 = this.value.newHighValue();
/* 74 */       this.interpolationChannel.data[paramInt1] = f1;
/* 75 */       this.interpolationChannel.data[paramInt1 + 1] = f2;
/* 76 */       this.valueChannel.data[i] = f1 + f2 * this.value.getScale(0.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void update() {
/* 83 */     int i = 0, j = 0, k = 2, m = 0 + this.controller.particles.size * this.valueChannel.strideSize;
/* 84 */     for (; i < m; i += this.valueChannel.strideSize, j += this.interpolationChannel.strideSize, k += this.lifeChannel.strideSize)
/*    */     {
/* 86 */       this.valueChannel.data[i] = this.interpolationChannel.data[j] + this.interpolationChannel.data[j + 1] * this.value
/* 87 */         .getScale(this.lifeChannel.data[k]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Json paramJson) {
/* 93 */     paramJson.writeValue("value", this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 98 */     this.value = (ScaledNumericValue)paramJson.readValue("value", ScaledNumericValue.class, paramJsonValue);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\influencers\SimpleInfluencer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */