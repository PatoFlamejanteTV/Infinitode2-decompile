/*     */ package com.badlogic.gdx.graphics.g3d.particles.values;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EllipseSpawnShapeValue
/*     */   extends PrimitiveSpawnShapeValue
/*     */ {
/*  27 */   PrimitiveSpawnShapeValue.SpawnSide side = PrimitiveSpawnShapeValue.SpawnSide.both;
/*     */   
/*     */   public EllipseSpawnShapeValue(EllipseSpawnShapeValue paramEllipseSpawnShapeValue) {
/*  30 */     super(paramEllipseSpawnShapeValue);
/*  31 */     load(paramEllipseSpawnShapeValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EllipseSpawnShapeValue() {}
/*     */ 
/*     */   
/*     */   public final void spawnAux(Vector3 paramVector3, float paramFloat) {
/*  40 */     float f1 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(paramFloat);
/*  41 */     float f2 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(paramFloat);
/*  42 */     paramFloat = this.spawnDepth + this.spawnDepthDiff * this.spawnDepthValue.getScale(paramFloat);
/*     */ 
/*     */ 
/*     */     
/*  46 */     float f3 = 6.2831855F;
/*  47 */     if (this.side == PrimitiveSpawnShapeValue.SpawnSide.top) {
/*  48 */       f3 = 3.1415927F;
/*  49 */     } else if (this.side == PrimitiveSpawnShapeValue.SpawnSide.bottom) {
/*  50 */       f3 = -3.1415927F;
/*     */     } 
/*  52 */     f3 = MathUtils.random(0.0F, f3);
/*     */ 
/*     */     
/*  55 */     if (this.edges) {
/*  56 */       if (f1 == 0.0F) {
/*  57 */         paramVector3.set(0.0F, f2 / 2.0F * MathUtils.sin(f3), paramFloat / 2.0F * MathUtils.cos(f3));
/*     */         return;
/*     */       } 
/*  60 */       if (f2 == 0.0F) {
/*  61 */         paramVector3.set(f1 / 2.0F * MathUtils.cos(f3), 0.0F, paramFloat / 2.0F * MathUtils.sin(f3));
/*     */         return;
/*     */       } 
/*  64 */       if (paramFloat == 0.0F) {
/*  65 */         paramVector3.set(f1 / 2.0F * MathUtils.cos(f3), f2 / 2.0F * MathUtils.sin(f3), 0.0F);
/*     */         
/*     */         return;
/*     */       } 
/*  69 */       f1 /= 2.0F;
/*  70 */       f2 /= 2.0F;
/*  71 */       paramFloat /= 2.0F;
/*     */     } else {
/*  73 */       f1 = MathUtils.random(f1 / 2.0F);
/*  74 */       f2 = MathUtils.random(f2 / 2.0F);
/*  75 */       paramFloat = MathUtils.random(paramFloat / 2.0F);
/*     */     } 
/*     */     
/*  78 */     float f4 = MathUtils.random(-1.0F, 1.0F);
/*  79 */     float f5 = (float)Math.sqrt((1.0F - f4 * f4));
/*  80 */     paramVector3.set(f1 * f5 * MathUtils.cos(f3), f2 * f5 * MathUtils.sin(f3), paramFloat * f4);
/*     */   }
/*     */   
/*     */   public final PrimitiveSpawnShapeValue.SpawnSide getSide() {
/*  84 */     return this.side;
/*     */   }
/*     */   
/*     */   public final void setSide(PrimitiveSpawnShapeValue.SpawnSide paramSpawnSide) {
/*  88 */     this.side = paramSpawnSide;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void load(ParticleValue paramParticleValue) {
/*  93 */     super.load(paramParticleValue);
/*  94 */     paramParticleValue = paramParticleValue;
/*  95 */     this.side = ((EllipseSpawnShapeValue)paramParticleValue).side;
/*     */   }
/*     */ 
/*     */   
/*     */   public final SpawnShapeValue copy() {
/* 100 */     return new EllipseSpawnShapeValue(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void write(Json paramJson) {
/* 105 */     super.write(paramJson);
/* 106 */     paramJson.writeValue("side", this.side);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Json paramJson, JsonValue paramJsonValue) {
/* 111 */     super.read(paramJson, paramJsonValue);
/* 112 */     this.side = (PrimitiveSpawnShapeValue.SpawnSide)paramJson.readValue("side", PrimitiveSpawnShapeValue.SpawnSide.class, paramJsonValue);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\values\EllipseSpawnShapeValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */