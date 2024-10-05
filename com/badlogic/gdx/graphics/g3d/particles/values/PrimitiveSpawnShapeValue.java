/*     */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*     */ 
/*     */ import com.badlogic.gdx.math.Vector3;
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
/*     */ public abstract class PrimitiveSpawnShapeValue
/*     */   extends SpawnShapeValue
/*     */ {
/*     */   public ScaledNumericValue spawnWidthValue;
/*     */   public ScaledNumericValue spawnHeightValue;
/*     */   public ScaledNumericValue spawnDepthValue;
/*     */   protected float spawnWidth;
/*     */   protected float spawnWidthDiff;
/*     */   protected float spawnHeight;
/*     */   protected float spawnHeightDiff;
/*     */   protected float spawnDepth;
/*     */   protected float spawnDepthDiff;
/*  26 */   protected static final Vector3 TMP_V1 = new Vector3();
/*     */   
/*     */   public enum SpawnSide {
/*  29 */     both, top, bottom;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean edges = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public PrimitiveSpawnShapeValue() {
/*  39 */     this.spawnWidthValue = new ScaledNumericValue();
/*  40 */     this.spawnHeightValue = new ScaledNumericValue();
/*  41 */     this.spawnDepthValue = new ScaledNumericValue();
/*     */   }
/*     */   
/*     */   public PrimitiveSpawnShapeValue(PrimitiveSpawnShapeValue paramPrimitiveSpawnShapeValue) {
/*  45 */     super(paramPrimitiveSpawnShapeValue);
/*  46 */     this.spawnWidthValue = new ScaledNumericValue();
/*  47 */     this.spawnHeightValue = new ScaledNumericValue();
/*  48 */     this.spawnDepthValue = new ScaledNumericValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setActive(boolean paramBoolean) {
/*  53 */     super.setActive(paramBoolean);
/*  54 */     this.spawnWidthValue.setActive(true);
/*  55 */     this.spawnHeightValue.setActive(true);
/*  56 */     this.spawnDepthValue.setActive(true);
/*     */   }
/*     */   
/*     */   public boolean isEdges() {
/*  60 */     return this.edges;
/*     */   }
/*     */   
/*     */   public void setEdges(boolean paramBoolean) {
/*  64 */     this.edges = paramBoolean;
/*     */   }
/*     */   
/*     */   public ScaledNumericValue getSpawnWidth() {
/*  68 */     return this.spawnWidthValue;
/*     */   }
/*     */   
/*     */   public ScaledNumericValue getSpawnHeight() {
/*  72 */     return this.spawnHeightValue;
/*     */   }
/*     */   
/*     */   public ScaledNumericValue getSpawnDepth() {
/*  76 */     return this.spawnDepthValue;
/*     */   }
/*     */   
/*     */   public void setDimensions(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  80 */     this.spawnWidthValue.setHigh(paramFloat1);
/*  81 */     this.spawnHeightValue.setHigh(paramFloat2);
/*  82 */     this.spawnDepthValue.setHigh(paramFloat3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/*  87 */     this.spawnWidth = this.spawnWidthValue.newLowValue();
/*  88 */     this.spawnWidthDiff = this.spawnWidthValue.newHighValue();
/*  89 */     if (!this.spawnWidthValue.isRelative()) this.spawnWidthDiff -= this.spawnWidth;
/*     */     
/*  91 */     this.spawnHeight = this.spawnHeightValue.newLowValue();
/*  92 */     this.spawnHeightDiff = this.spawnHeightValue.newHighValue();
/*  93 */     if (!this.spawnHeightValue.isRelative()) this.spawnHeightDiff -= this.spawnHeight;
/*     */     
/*  95 */     this.spawnDepth = this.spawnDepthValue.newLowValue();
/*  96 */     this.spawnDepthDiff = this.spawnDepthValue.newHighValue();
/*  97 */     if (!this.spawnDepthValue.isRelative()) this.spawnDepthDiff -= this.spawnDepth;
/*     */   
/*     */   }
/*     */   
/*     */   public void load(ParticleValue paramParticleValue) {
/* 102 */     super.load(paramParticleValue);
/* 103 */     paramParticleValue = paramParticleValue;
/* 104 */     this.edges = ((PrimitiveSpawnShapeValue)paramParticleValue).edges;
/* 105 */     this.spawnWidthValue.load(((PrimitiveSpawnShapeValue)paramParticleValue).spawnWidthValue);
/* 106 */     this.spawnHeightValue.load(((PrimitiveSpawnShapeValue)paramParticleValue).spawnHeightValue);
/* 107 */     this.spawnDepthValue.load(((PrimitiveSpawnShapeValue)paramParticleValue).spawnDepthValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Json paramJson) {
/* 112 */     super.write(paramJson);
/* 113 */     paramJson.writeValue("spawnWidthValue", this.spawnWidthValue);
/* 114 */     paramJson.writeValue("spawnHeightValue", this.spawnHeightValue);
/* 115 */     paramJson.writeValue("spawnDepthValue", this.spawnDepthValue);
/* 116 */     paramJson.writeValue("edges", Boolean.valueOf(this.edges));
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 121 */     super.read(paramJson, paramJsonValue);
/* 122 */     this.spawnWidthValue = (ScaledNumericValue)paramJson.readValue("spawnWidthValue", ScaledNumericValue.class, paramJsonValue);
/* 123 */     this.spawnHeightValue = (ScaledNumericValue)paramJson.readValue("spawnHeightValue", ScaledNumericValue.class, paramJsonValue);
/* 124 */     this.spawnDepthValue = (ScaledNumericValue)paramJson.readValue("spawnDepthValue", ScaledNumericValue.class, paramJsonValue);
/* 125 */     this.edges = ((Boolean)paramJson.readValue("edges", boolean.class, paramJsonValue)).booleanValue();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\PrimitiveSpawnShapeValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */