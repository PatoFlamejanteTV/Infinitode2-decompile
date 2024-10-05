/*     */ package com.badlogic.gdx.graphics.g3d.particles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.Renderable;
/*     */ import com.badlogic.gdx.graphics.g3d.RenderableProvider;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Pool;
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
/*     */ public final class ParticleSystem
/*     */   implements RenderableProvider
/*     */ {
/*     */   private static ParticleSystem instance;
/*     */   private Array<ParticleBatch<?>> batches;
/*     */   private Array<ParticleEffect> effects;
/*     */   
/*     */   @Deprecated
/*     */   public static ParticleSystem get() {
/*  34 */     if (instance == null) instance = new ParticleSystem(); 
/*  35 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ParticleSystem() {
/*  42 */     this.batches = new Array();
/*  43 */     this.effects = new Array();
/*     */   }
/*     */   
/*     */   public final void add(ParticleBatch<?> paramParticleBatch) {
/*  47 */     this.batches.add(paramParticleBatch);
/*     */   }
/*     */   
/*     */   public final void add(ParticleEffect paramParticleEffect) {
/*  51 */     this.effects.add(paramParticleEffect);
/*     */   }
/*     */   
/*     */   public final void remove(ParticleEffect paramParticleEffect) {
/*  55 */     this.effects.removeValue(paramParticleEffect, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void removeAll() {
/*  60 */     this.effects.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update() {
/*  65 */     for (Array.ArrayIterator<ParticleEffect> arrayIterator = this.effects.iterator(); arrayIterator.hasNext();) {
/*  66 */       (particleEffect = arrayIterator.next()).update();
/*     */     }
/*     */   }
/*     */   
/*     */   public final void updateAndDraw() {
/*  71 */     for (Array.ArrayIterator<ParticleEffect> arrayIterator = this.effects.iterator(); arrayIterator.hasNext(); ) {
/*  72 */       ParticleEffect particleEffect; (particleEffect = arrayIterator.next()).update();
/*  73 */       particleEffect.draw();
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void update(float paramFloat) {
/*  78 */     for (Array.ArrayIterator<ParticleEffect> arrayIterator = this.effects.iterator(); arrayIterator.hasNext();) {
/*  79 */       (particleEffect = arrayIterator.next()).update(paramFloat);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void updateAndDraw(float paramFloat) {
/*  84 */     for (Array.ArrayIterator<ParticleEffect> arrayIterator = this.effects.iterator(); arrayIterator.hasNext(); ) {
/*  85 */       ParticleEffect particleEffect; (particleEffect = arrayIterator.next()).update(paramFloat);
/*  86 */       particleEffect.draw();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void begin() {
/*  92 */     for (Array.ArrayIterator<ParticleBatch> arrayIterator = this.batches.iterator(); arrayIterator.hasNext();) {
/*  93 */       (particleBatch = arrayIterator.next()).begin();
/*     */     }
/*     */   }
/*     */   
/*     */   public final void draw() {
/*  98 */     for (Array.ArrayIterator<ParticleEffect> arrayIterator = this.effects.iterator(); arrayIterator.hasNext();) {
/*  99 */       (particleEffect = arrayIterator.next()).draw();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void end() {
/* 105 */     for (Array.ArrayIterator<ParticleBatch> arrayIterator = this.batches.iterator(); arrayIterator.hasNext();) {
/* 106 */       (particleBatch = arrayIterator.next()).end();
/*     */     }
/*     */   }
/*     */   
/*     */   public final void getRenderables(Array<Renderable> paramArray, Pool<Renderable> paramPool) {
/* 111 */     for (Array.ArrayIterator<ParticleBatch> arrayIterator = this.batches.iterator(); arrayIterator.hasNext();)
/* 112 */       (particleBatch = arrayIterator.next()).getRenderables(paramArray, paramPool); 
/*     */   }
/*     */   
/*     */   public final Array<ParticleBatch<?>> getBatches() {
/* 116 */     return this.batches;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\ParticleSystem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */