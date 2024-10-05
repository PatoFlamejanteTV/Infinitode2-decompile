/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureAtlas;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ 
/*     */ 
/*     */ public class ParticleEffectActor
/*     */   extends Actor
/*     */   implements Disposable
/*     */ {
/*     */   private final ParticleEffect j;
/*     */   private float k;
/*     */   private boolean l;
/*     */   private boolean m;
/*     */   private boolean n;
/*     */   private boolean o;
/*     */   
/*     */   public ParticleEffectActor(ParticleEffect paramParticleEffect, boolean paramBoolean) {
/*  23 */     this.j = paramParticleEffect;
/*  24 */     this.n = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public ParticleEffectActor(FileHandle paramFileHandle, TextureAtlas paramTextureAtlas) {
/*  29 */     this.j = new ParticleEffect();
/*  30 */     this.j.load(paramFileHandle, paramTextureAtlas);
/*  31 */     this.m = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ParticleEffectActor(FileHandle paramFileHandle1, FileHandle paramFileHandle2) {
/*  36 */     this.j = new ParticleEffect();
/*  37 */     this.j.load(paramFileHandle1, paramFileHandle2);
/*  38 */     this.m = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*  43 */     this.j.setPosition(getX(), getY());
/*  44 */     if (this.k > 0.0F) {
/*  45 */       this.j.update(this.k);
/*  46 */       this.k = 0.0F;
/*     */     } 
/*  48 */     if (this.l) {
/*  49 */       this.j.draw(paramBatch);
/*  50 */       this.l = !this.j.isComplete();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void act(float paramFloat) {
/*  56 */     super.act(paramFloat);
/*     */ 
/*     */     
/*  59 */     this.k += paramFloat;
/*     */     
/*  61 */     if (this.o && this.j.isComplete()) {
/*  62 */       remove();
/*     */     }
/*     */   }
/*     */   
/*     */   public void start() {
/*  67 */     this.l = true;
/*  68 */     if (this.n) {
/*  69 */       this.j.reset(false);
/*     */     }
/*  71 */     this.j.start();
/*     */   }
/*     */   
/*     */   public boolean isResetOnStart() {
/*  75 */     return this.n;
/*     */   }
/*     */   
/*     */   public ParticleEffectActor setResetOnStart(boolean paramBoolean) {
/*  79 */     this.n = paramBoolean;
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public boolean isAutoRemove() {
/*  84 */     return this.o;
/*     */   }
/*     */   
/*     */   public ParticleEffectActor setAutoRemove(boolean paramBoolean) {
/*  88 */     this.o = paramBoolean;
/*  89 */     return this;
/*     */   }
/*     */   
/*     */   public boolean isRunning() {
/*  93 */     return this.l;
/*     */   }
/*     */   
/*     */   public ParticleEffect getEffect() {
/*  97 */     return this.j;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a() {
/* 102 */     super.a();
/* 103 */     this.j.scaleEffect(getScaleX(), getScaleY(), getScaleY());
/*     */   }
/*     */   
/*     */   public void cancel() {
/* 107 */     this.l = true;
/*     */   }
/*     */   
/*     */   public void allowCompletion() {
/* 111 */     this.j.allowCompletion();
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 116 */     if (this.m)
/* 117 */       this.j.dispose(); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\ParticleEffectActor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */