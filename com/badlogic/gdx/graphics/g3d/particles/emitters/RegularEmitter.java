/*     */ package com.badlogic.gdx.graphics.g3d.particles.emitters;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.values.RangedNumericValue;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ 
/*     */ public class RegularEmitter
/*     */   extends Emitter implements Json.Serializable {
/*     */   public RangedNumericValue delayValue;
/*     */   public RangedNumericValue durationValue;
/*     */   public ScaledNumericValue lifeOffsetValue;
/*     */   public ScaledNumericValue lifeValue;
/*     */   public ScaledNumericValue emissionValue;
/*     */   protected int emission;
/*     */   protected int emissionDiff;
/*     */   protected int emissionDelta;
/*     */   protected int lifeOffset;
/*     */   protected int lifeOffsetDiff;
/*     */   protected int life;
/*     */   protected int lifeDiff;
/*     */   protected float duration;
/*     */   protected float delay;
/*     */   protected float durationTimer;
/*     */   protected float delayTimer;
/*     */   private boolean continuous;
/*     */   private EmissionMode emissionMode;
/*     */   private ParallelArray.FloatChannel lifeChannel;
/*     */   
/*     */   public enum EmissionMode {
/*  34 */     Enabled,
/*     */ 
/*     */     
/*  37 */     EnabledUntilCycleEnd,
/*     */     
/*  39 */     Disabled;
/*     */   }
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
/*     */   public RegularEmitter() {
/*  54 */     this.delayValue = new RangedNumericValue();
/*  55 */     this.durationValue = new RangedNumericValue();
/*  56 */     this.lifeOffsetValue = new ScaledNumericValue();
/*  57 */     this.lifeValue = new ScaledNumericValue();
/*  58 */     this.emissionValue = new ScaledNumericValue();
/*     */     
/*  60 */     this.durationValue.setActive(true);
/*  61 */     this.emissionValue.setActive(true);
/*  62 */     this.lifeValue.setActive(true);
/*  63 */     this.continuous = true;
/*  64 */     this.emissionMode = EmissionMode.Enabled;
/*     */   }
/*     */   
/*     */   public RegularEmitter(RegularEmitter paramRegularEmitter) {
/*  68 */     this();
/*  69 */     set(paramRegularEmitter);
/*     */   }
/*     */ 
/*     */   
/*     */   public void allocateChannels() {
/*  74 */     this.lifeChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life);
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/*  79 */     this.delay = this.delayValue.active ? this.delayValue.newLowValue() : 0.0F;
/*  80 */     this.delayTimer = 0.0F;
/*  81 */     this.durationTimer = 0.0F;
/*     */     
/*  83 */     this.duration = this.durationValue.newLowValue();
/*  84 */     this.percent = this.durationTimer / this.duration;
/*     */     
/*  86 */     this.emission = (int)this.emissionValue.newLowValue();
/*  87 */     this.emissionDiff = (int)this.emissionValue.newHighValue();
/*  88 */     if (!this.emissionValue.isRelative()) this.emissionDiff -= this.emission;
/*     */     
/*  90 */     this.life = (int)this.lifeValue.newLowValue();
/*  91 */     this.lifeDiff = (int)this.lifeValue.newHighValue();
/*  92 */     if (!this.lifeValue.isRelative()) this.lifeDiff -= this.life;
/*     */     
/*  94 */     this.lifeOffset = this.lifeOffsetValue.active ? (int)this.lifeOffsetValue.newLowValue() : 0;
/*  95 */     this.lifeOffsetDiff = (int)this.lifeOffsetValue.newHighValue();
/*  96 */     if (!this.lifeOffsetValue.isRelative()) this.lifeOffsetDiff -= this.lifeOffset; 
/*     */   }
/*     */   
/*     */   public void init() {
/* 100 */     super.init();
/* 101 */     this.emissionDelta = 0;
/* 102 */     this.durationTimer = this.duration;
/*     */   }
/*     */   
/*     */   public void activateParticles(int paramInt1, int paramInt2) {
/* 106 */     int i = this.life + (int)(this.lifeDiff * this.lifeValue.getScale(this.percent)), j = i;
/*     */     int k;
/* 108 */     if ((k = (int)(this.lifeOffset + this.lifeOffsetDiff * this.lifeOffsetValue.getScale(this.percent))) > 0) {
/* 109 */       if (k >= i) k = i - 1; 
/* 110 */       j = i - k;
/*     */     } 
/* 112 */     float f = 1.0F - j / i;
/*     */ 
/*     */     
/* 115 */     for (paramInt2 = (paramInt1 = paramInt1 * this.lifeChannel.strideSize) + paramInt2 * this.lifeChannel.strideSize; paramInt1 < paramInt2; paramInt1 += this.lifeChannel.strideSize) {
/* 116 */       this.lifeChannel.data[paramInt1] = j;
/* 117 */       this.lifeChannel.data[paramInt1 + 1] = i;
/* 118 */       this.lifeChannel.data[paramInt1 + 2] = f;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void update() {
/* 123 */     float f = this.controller.deltaTime * 1000.0F;
/*     */     
/* 125 */     if (this.delayTimer < this.delay) {
/* 126 */       this.delayTimer += f;
/*     */     } else {
/* 128 */       boolean bool = (this.emissionMode != EmissionMode.Disabled) ? true : false;
/*     */       
/* 130 */       if (this.durationTimer < this.duration) {
/* 131 */         this.durationTimer += f;
/* 132 */         this.percent = this.durationTimer / this.duration;
/*     */       }
/* 134 */       else if (this.continuous && bool && this.emissionMode == EmissionMode.Enabled) {
/* 135 */         this.controller.start();
/*     */       } else {
/* 137 */         bool = false;
/*     */       } 
/*     */       
/* 140 */       if (bool) {
/*     */         
/* 142 */         this.emissionDelta = (int)(this.emissionDelta + f);
/*     */         float f1;
/* 144 */         if ((f1 = this.emission + this.emissionDiff * this.emissionValue.getScale(this.percent)) > 0.0F) {
/* 145 */           f1 = 1000.0F / f1;
/* 146 */           if (this.emissionDelta >= f1) {
/*     */             
/* 148 */             int k = Math.min(k = (int)(this.emissionDelta / f1), this.maxParticleCount - this.controller.particles.size);
/* 149 */             this.emissionDelta = (int)(this.emissionDelta - k * f1);
/* 150 */             this.emissionDelta = (int)(this.emissionDelta % f1);
/* 151 */             addParticles(k);
/*     */           } 
/*     */         } 
/* 154 */         if (this.controller.particles.size < this.minParticleCount) addParticles(this.minParticleCount - this.controller.particles.size);
/*     */       
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     int i = this.controller.particles.size; int j;
/* 160 */     for (byte b = 0; b < this.controller.particles.size; ) {
/* 161 */       this.lifeChannel.data[j] = this.lifeChannel.data[j] - f; if (this.lifeChannel.data[j] - f <= 0.0F) {
/* 162 */         this.controller.particles.removeElement(b);
/*     */         continue;
/*     */       } 
/* 165 */       this.lifeChannel.data[j + 2] = 1.0F - this.lifeChannel.data[j] / this.lifeChannel.data[j + 1];
/*     */ 
/*     */ 
/*     */       
/* 169 */       b++;
/* 170 */       j += this.lifeChannel.strideSize;
/*     */     } 
/*     */     
/* 173 */     if (this.controller.particles.size < i) {
/* 174 */       this.controller.killParticles(this.controller.particles.size, i - this.controller.particles.size);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void addParticles(int paramInt) {
/* 180 */     if ((paramInt = Math.min(paramInt, this.maxParticleCount - this.controller.particles.size)) <= 0)
/* 181 */       return;  this.controller.activateParticles(this.controller.particles.size, paramInt);
/* 182 */     this.controller.particles.size += paramInt;
/*     */   }
/*     */   
/*     */   public ScaledNumericValue getLife() {
/* 186 */     return this.lifeValue;
/*     */   }
/*     */   
/*     */   public ScaledNumericValue getEmission() {
/* 190 */     return this.emissionValue;
/*     */   }
/*     */   
/*     */   public RangedNumericValue getDuration() {
/* 194 */     return this.durationValue;
/*     */   }
/*     */   
/*     */   public RangedNumericValue getDelay() {
/* 198 */     return this.delayValue;
/*     */   }
/*     */   
/*     */   public ScaledNumericValue getLifeOffset() {
/* 202 */     return this.lifeOffsetValue;
/*     */   }
/*     */   
/*     */   public boolean isContinuous() {
/* 206 */     return this.continuous;
/*     */   }
/*     */   
/*     */   public void setContinuous(boolean paramBoolean) {
/* 210 */     this.continuous = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EmissionMode getEmissionMode() {
/* 216 */     return this.emissionMode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmissionMode(EmissionMode paramEmissionMode) {
/* 222 */     this.emissionMode = paramEmissionMode;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 227 */     if (this.delayTimer < this.delay) return false; 
/* 228 */     return (this.durationTimer >= this.duration && this.controller.particles.size == 0);
/*     */   }
/*     */   
/*     */   public float getPercentComplete() {
/* 232 */     if (this.delayTimer < this.delay) return 0.0F; 
/* 233 */     return Math.min(1.0F, this.durationTimer / this.duration);
/*     */   }
/*     */   
/*     */   public void set(RegularEmitter paramRegularEmitter) {
/* 237 */     set(paramRegularEmitter);
/* 238 */     this.delayValue.load(paramRegularEmitter.delayValue);
/* 239 */     this.durationValue.load(paramRegularEmitter.durationValue);
/* 240 */     this.lifeOffsetValue.load(paramRegularEmitter.lifeOffsetValue);
/* 241 */     this.lifeValue.load(paramRegularEmitter.lifeValue);
/* 242 */     this.emissionValue.load(paramRegularEmitter.emissionValue);
/* 243 */     this.emission = paramRegularEmitter.emission;
/* 244 */     this.emissionDiff = paramRegularEmitter.emissionDiff;
/* 245 */     this.emissionDelta = paramRegularEmitter.emissionDelta;
/* 246 */     this.lifeOffset = paramRegularEmitter.lifeOffset;
/* 247 */     this.lifeOffsetDiff = paramRegularEmitter.lifeOffsetDiff;
/* 248 */     this.life = paramRegularEmitter.life;
/* 249 */     this.lifeDiff = paramRegularEmitter.lifeDiff;
/* 250 */     this.duration = paramRegularEmitter.duration;
/* 251 */     this.delay = paramRegularEmitter.delay;
/* 252 */     this.durationTimer = paramRegularEmitter.durationTimer;
/* 253 */     this.delayTimer = paramRegularEmitter.delayTimer;
/* 254 */     this.continuous = paramRegularEmitter.continuous;
/*     */   }
/*     */ 
/*     */   
/*     */   public ParticleControllerComponent copy() {
/* 259 */     return new RegularEmitter(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Json paramJson) {
/* 264 */     super.write(paramJson);
/* 265 */     paramJson.writeValue("continous", Boolean.valueOf(this.continuous));
/* 266 */     paramJson.writeValue("emission", this.emissionValue);
/* 267 */     paramJson.writeValue("delay", this.delayValue);
/* 268 */     paramJson.writeValue("duration", this.durationValue);
/* 269 */     paramJson.writeValue("life", this.lifeValue);
/* 270 */     paramJson.writeValue("lifeOffset", this.lifeOffsetValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 275 */     super.read(paramJson, paramJsonValue);
/* 276 */     this.continuous = ((Boolean)paramJson.readValue("continous", boolean.class, paramJsonValue)).booleanValue();
/* 277 */     this.emissionValue = (ScaledNumericValue)paramJson.readValue("emission", ScaledNumericValue.class, paramJsonValue);
/* 278 */     this.delayValue = (RangedNumericValue)paramJson.readValue("delay", RangedNumericValue.class, paramJsonValue);
/* 279 */     this.durationValue = (RangedNumericValue)paramJson.readValue("duration", RangedNumericValue.class, paramJsonValue);
/* 280 */     this.lifeValue = (ScaledNumericValue)paramJson.readValue("life", ScaledNumericValue.class, paramJsonValue);
/* 281 */     this.lifeOffsetValue = (ScaledNumericValue)paramJson.readValue("lifeOffset", ScaledNumericValue.class, paramJsonValue);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\emitters\RegularEmitter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */