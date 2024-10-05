/*     */ package com.badlogic.gdx.graphics.g3d.particles.influencers;
/*     */ 
/*     */ import com.badlogic.gdx.assets.AssetManager;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.values.PointSpawnShapeValue;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.values.SpawnShapeValue;
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
/*     */ 
/*     */ 
/*     */ public class SpawnInfluencer
/*     */   extends Influencer
/*     */ {
/*     */   public SpawnShapeValue spawnShapeValue;
/*     */   ParallelArray.FloatChannel positionChannel;
/*     */   ParallelArray.FloatChannel rotationChannel;
/*     */   
/*     */   public SpawnInfluencer() {
/*  37 */     this.spawnShapeValue = (SpawnShapeValue)new PointSpawnShapeValue();
/*     */   }
/*     */   
/*     */   public SpawnInfluencer(SpawnShapeValue paramSpawnShapeValue) {
/*  41 */     this.spawnShapeValue = paramSpawnShapeValue;
/*     */   }
/*     */   
/*     */   public SpawnInfluencer(SpawnInfluencer paramSpawnInfluencer) {
/*  45 */     this.spawnShapeValue = paramSpawnInfluencer.spawnShapeValue.copy();
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/*  50 */     this.spawnShapeValue.init();
/*     */   }
/*     */ 
/*     */   
/*     */   public void allocateChannels() {
/*  55 */     this.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
/*  56 */     this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/*  61 */     this.spawnShapeValue.start();
/*     */   }
/*     */   
/*     */   public void activateParticles(int paramInt1, int paramInt2) {
/*     */     int i;
/*     */     int j;
/*  67 */     for (j = (i = paramInt1 * this.positionChannel.strideSize) + paramInt2 * this.positionChannel.strideSize; i < j; i += this.positionChannel.strideSize) {
/*  68 */       this.spawnShapeValue.spawn(TMP_V1, this.controller.emitter.percent);
/*  69 */       TMP_V1.mul(this.controller.transform);
/*  70 */       this.positionChannel.data[i] = TMP_V1.x;
/*  71 */       this.positionChannel.data[i + 1] = TMP_V1.y;
/*  72 */       this.positionChannel.data[i + 2] = TMP_V1.z;
/*     */     } 
/*     */     
/*  75 */     for (j = (i = paramInt1 * this.rotationChannel.strideSize) + paramInt2 * this.rotationChannel.strideSize; i < j; i += this.rotationChannel.strideSize) {
/*  76 */       this.controller.transform.getRotation(TMP_Q, true);
/*  77 */       this.rotationChannel.data[i] = TMP_Q.x;
/*  78 */       this.rotationChannel.data[i + 1] = TMP_Q.y;
/*  79 */       this.rotationChannel.data[i + 2] = TMP_Q.z;
/*  80 */       this.rotationChannel.data[i + 3] = TMP_Q.w;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public SpawnInfluencer copy() {
/*  86 */     return new SpawnInfluencer(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Json paramJson) {
/*  91 */     paramJson.writeValue("spawnShape", this.spawnShapeValue, SpawnShapeValue.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json paramJson, JsonValue paramJsonValue) {
/*  96 */     this.spawnShapeValue = (SpawnShapeValue)paramJson.readValue("spawnShape", SpawnShapeValue.class, paramJsonValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 101 */     this.spawnShapeValue.save(paramAssetManager, paramResourceData);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(AssetManager paramAssetManager, ResourceData paramResourceData) {
/* 106 */     this.spawnShapeValue.load(paramAssetManager, paramResourceData);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\influencers\SpawnInfluencer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */