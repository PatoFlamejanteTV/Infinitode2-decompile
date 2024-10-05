/*     */ package com.badlogic.gdx.graphics.g3d.particles.influencers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.values.GradientColorValue;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
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
/*     */ public abstract class ColorInfluencer
/*     */   extends Influencer
/*     */ {
/*     */   ParallelArray.FloatChannel colorChannel;
/*     */   
/*     */   public static class Random
/*     */     extends ColorInfluencer
/*     */   {
/*     */     ParallelArray.FloatChannel colorChannel;
/*     */     
/*     */     public void allocateChannels() {
/*  37 */       this.colorChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Color);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void activateParticles(int param1Int1, int param1Int2) {
/*  43 */       for (param1Int2 = (param1Int1 = param1Int1 * this.colorChannel.strideSize) + param1Int2 * this.colorChannel.strideSize; param1Int1 < param1Int2; param1Int1 += this.colorChannel.strideSize) {
/*  44 */         this.colorChannel.data[param1Int1] = MathUtils.random();
/*  45 */         this.colorChannel.data[param1Int1 + 1] = MathUtils.random();
/*  46 */         this.colorChannel.data[param1Int1 + 2] = MathUtils.random();
/*  47 */         this.colorChannel.data[param1Int1 + 3] = MathUtils.random();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Random copy() {
/*  53 */       return new Random();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Single
/*     */     extends ColorInfluencer {
/*     */     ParallelArray.FloatChannel alphaInterpolationChannel;
/*     */     ParallelArray.FloatChannel lifeChannel;
/*     */     public ScaledNumericValue alphaValue;
/*     */     public GradientColorValue colorValue;
/*     */     
/*     */     public Single() {
/*  65 */       this.colorValue = new GradientColorValue();
/*  66 */       this.alphaValue = new ScaledNumericValue();
/*  67 */       this.alphaValue.setHigh(1.0F);
/*     */     }
/*     */     
/*     */     public Single(Single param1Single) {
/*  71 */       this();
/*  72 */       set(param1Single);
/*     */     }
/*     */     
/*     */     public void set(Single param1Single) {
/*  76 */       this.colorValue.load(param1Single.colorValue);
/*  77 */       this.alphaValue.load(param1Single.alphaValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/*  82 */       super.allocateChannels();
/*     */       
/*  84 */       ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
/*  85 */       this.alphaInterpolationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation);
/*  86 */       this.lifeChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life);
/*     */     }
/*     */ 
/*     */     
/*     */     public void activateParticles(int param1Int1, int param1Int2) {
/*  91 */       int i = param1Int1 * this.colorChannel.strideSize, j = param1Int1 * this.alphaInterpolationChannel.strideSize;
/*  92 */       param1Int1 = param1Int1 * this.lifeChannel.strideSize + 2; param1Int2 = i + param1Int2 * this.colorChannel.strideSize;
/*  93 */       for (; i < param1Int2; i += this.colorChannel.strideSize, j += this.alphaInterpolationChannel.strideSize, param1Int1 += this.lifeChannel.strideSize) {
/*  94 */         float f1 = this.alphaValue.newLowValue();
/*  95 */         float f2 = this.alphaValue.newHighValue() - f1;
/*  96 */         this.colorValue.getColor(0.0F, this.colorChannel.data, i);
/*  97 */         this.colorChannel.data[i + 3] = f1 + f2 * this.alphaValue
/*  98 */           .getScale(this.lifeChannel.data[param1Int1]);
/*  99 */         this.alphaInterpolationChannel.data[j] = f1;
/* 100 */         this.alphaInterpolationChannel.data[j + 1] = f2;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 106 */       int i = 0, j = 0, k = 2, m = 0 + this.controller.particles.size * this.colorChannel.strideSize;
/* 107 */       for (; i < m; i += this.colorChannel.strideSize, j += this.alphaInterpolationChannel.strideSize, k += this.lifeChannel.strideSize) {
/*     */         
/* 109 */         float f = this.lifeChannel.data[k];
/* 110 */         this.colorValue.getColor(f, this.colorChannel.data, i);
/* 111 */         this.colorChannel.data[i + 3] = this.alphaInterpolationChannel.data[j] + this.alphaInterpolationChannel.data[j + 1] * this.alphaValue
/*     */ 
/*     */           
/* 114 */           .getScale(f);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Single copy() {
/* 120 */       return new Single(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(Json param1Json) {
/* 125 */       param1Json.writeValue("alpha", this.alphaValue);
/* 126 */       param1Json.writeValue("color", this.colorValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Json param1Json, JsonValue param1JsonValue) {
/* 131 */       this.alphaValue = (ScaledNumericValue)param1Json.readValue("alpha", ScaledNumericValue.class, param1JsonValue);
/* 132 */       this.colorValue = (GradientColorValue)param1Json.readValue("color", GradientColorValue.class, param1JsonValue);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void allocateChannels() {
/* 140 */     this.colorChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Color);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\influencers\ColorInfluencer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */