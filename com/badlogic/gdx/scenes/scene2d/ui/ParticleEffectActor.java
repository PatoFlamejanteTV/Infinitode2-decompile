/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ 
/*     */ 
/*     */ public class ParticleEffectActor
/*     */   extends Actor
/*     */   implements Disposable
/*     */ {
/*     */   private final ParticleEffect particleEffect;
/*     */   protected float lastDelta;
/*     */   protected boolean isRunning;
/*     */   protected boolean ownsEffect;
/*     */   private boolean resetOnStart;
/*     */   private boolean autoRemove;
/*     */   
/*     */   public ParticleEffectActor(ParticleEffect paramParticleEffect, boolean paramBoolean) {
/*  23 */     this.particleEffect = paramParticleEffect;
/*  24 */     this.resetOnStart = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public ParticleEffectActor(FileHandle paramFileHandle, TextureAtlas paramTextureAtlas) {
/*  29 */     this.particleEffect = new ParticleEffect();
/*  30 */     this.particleEffect.load(paramFileHandle, paramTextureAtlas);
/*  31 */     this.ownsEffect = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ParticleEffectActor(FileHandle paramFileHandle1, FileHandle paramFileHandle2) {
/*  36 */     this.particleEffect = new ParticleEffect();
/*  37 */     this.particleEffect.load(paramFileHandle1, paramFileHandle2);
/*  38 */     this.ownsEffect = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  43 */     this.particleEffect.setPosition(getX(), getY());
/*  44 */     if (this.lastDelta > 0.0F) {
/*  45 */       this.particleEffect.update(this.lastDelta);
/*  46 */       this.lastDelta = 0.0F;
/*     */     } 
/*  48 */     if (this.isRunning) {
/*  49 */       this.particleEffect.draw(paramBatch);
/*  50 */       this.isRunning = !this.particleEffect.isComplete();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void act(float paramFloat) {
/*  56 */     super.act(paramFloat);
/*     */ 
/*     */     
/*  59 */     this.lastDelta += paramFloat;
/*     */     
/*  61 */     if (this.autoRemove && this.particleEffect.isComplete()) {
/*  62 */       remove();
/*     */     }
/*     */   }
/*     */   
/*     */   public void start() {
/*  67 */     this.isRunning = true;
/*  68 */     if (this.resetOnStart) {
/*  69 */       this.particleEffect.reset(false);
/*     */     }
/*  71 */     this.particleEffect.start();
/*     */   }
/*     */   
/*     */   public boolean isResetOnStart() {
/*  75 */     return this.resetOnStart;
/*     */   }
/*     */   
/*     */   public ParticleEffectActor setResetOnStart(boolean paramBoolean) {
/*  79 */     this.resetOnStart = paramBoolean;
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public boolean isAutoRemove() {
/*  84 */     return this.autoRemove;
/*     */   }
/*     */   
/*     */   public ParticleEffectActor setAutoRemove(boolean paramBoolean) {
/*  88 */     this.autoRemove = paramBoolean;
/*  89 */     return this;
/*     */   }
/*     */   
/*     */   public boolean isRunning() {
/*  93 */     return this.isRunning;
/*     */   }
/*     */   
/*     */   public ParticleEffect getEffect() {
/*  97 */     return this.particleEffect;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void scaleChanged() {
/* 102 */     super.scaleChanged();
/* 103 */     this.particleEffect.scaleEffect(getScaleX(), getScaleY(), getScaleY());
/*     */   }
/*     */   
/*     */   public void cancel() {
/* 107 */     this.isRunning = true;
/*     */   }
/*     */   
/*     */   public void allowCompletion() {
/* 111 */     this.particleEffect.allowCompletion();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 116 */     if (this.ownsEffect)
/* 117 */       this.particleEffect.dispose(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\ParticleEffectActor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */