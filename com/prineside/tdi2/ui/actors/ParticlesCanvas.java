/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.systems.ParticleSystem;
/*     */ 
/*     */ public class ParticlesCanvas
/*     */   extends Actor
/*     */ {
/*     */   public boolean scissors;
/*  16 */   private final Array<ParticleConfig> j = new Array(true, 1, ParticleConfig.class);
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
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  29 */     float f1 = getX();
/*  30 */     float f2 = getY();
/*     */     
/*  32 */     if (this.j.size != 0) {
/*  33 */       boolean bool = false;
/*  34 */       if (this.scissors) {
/*  35 */         paramBatch.flush();
/*  36 */         bool = clipBegin();
/*     */       } 
/*     */       
/*  39 */       paramBatch.setColor(Color.WHITE);
/*  40 */       for (int i = this.j.size - 1; i >= 0; i--) {
/*     */         ParticleConfig particleConfig;
/*  42 */         if ((particleConfig = ((ParticleConfig[])this.j.items)[i]).effect.isComplete()) {
/*  43 */           this.j.removeIndex(i);
/*  44 */           particleConfig.effect.reset();
/*     */           
/*  46 */           ParticleSystem.freeParticle(particleConfig.effect);
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
/*     */         }
/*     */         else {
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
/*  72 */           particleConfig.effect.setPosition(f1 + particleConfig.x, f2 + particleConfig.y);
/*  73 */           for (Array.ArrayIterator<ParticleEmitter> arrayIterator = particleConfig.effect.getEmitters().iterator(); arrayIterator.hasNext();) {
/*  74 */             (particleEmitter = arrayIterator.next()).getTransparency().setHigh(paramFloat);
/*     */           }
/*     */           
/*  77 */           particleConfig.effect.update(Gdx.graphics.getDeltaTime());
/*  78 */           particleConfig.effect.draw(paramBatch);
/*     */         } 
/*  80 */       }  paramBatch.setColor(Color.WHITE);
/*  81 */       paramBatch.flush();
/*     */       
/*  83 */       if (bool) clipEnd();
/*     */       
/*  85 */       paramBatch.setBlendFunction(770, 771);
/*     */     } 
/*     */   }
/*     */   
/*     */   public ParticleConfig addParticle(ParticleEffect paramParticleEffect, float paramFloat1, float paramFloat2) {
/*  90 */     return addParticleForeground(paramParticleEffect, paramFloat1, paramFloat2, false);
/*     */   }
/*     */   
/*     */   public ParticleConfig addParticleForeground(ParticleEffect paramParticleEffect, float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*     */     ParticleConfig particleConfig;
/*  95 */     (particleConfig = new ParticleConfig()).effect = paramParticleEffect;
/*  96 */     particleConfig.x = paramFloat1;
/*  97 */     particleConfig.y = paramFloat2;
/*  98 */     if (paramBoolean) {
/*  99 */       this.j.insert(0, particleConfig);
/*     */     } else {
/* 101 */       this.j.add(particleConfig);
/*     */     } 
/* 103 */     paramParticleEffect.start();
/*     */     
/* 105 */     return particleConfig;
/*     */   }
/*     */   
/*     */   public void removeParticle(ParticleEffect paramParticleEffect) {
/* 109 */     for (byte b = 0; b < this.j.size; b++) {
/* 110 */       if ((((ParticleConfig[])this.j.items)[b]).effect == paramParticleEffect) {
/* 111 */         paramParticleEffect.reset();
/* 112 */         this.j.removeIndex(b);
/* 113 */         ParticleSystem.freeParticle(paramParticleEffect);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clearParticles() {
/* 120 */     for (int i = this.j.size - 1; i >= 0; i--) {
/* 121 */       ParticleConfig particleConfig = ((ParticleConfig[])this.j.items)[i];
/* 122 */       this.j.removeIndex(i);
/* 123 */       particleConfig.effect.reset();
/* 124 */       ParticleSystem.freeParticle(particleConfig.effect);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class ParticleConfig {
/*     */     public ParticleEffect effect;
/*     */     public float x;
/*     */     public float y;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\ParticlesCanvas.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */