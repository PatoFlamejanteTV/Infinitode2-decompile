/*     */ package com.prineside.tdi2.enemies.bosses;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class BrootEnemy
/*     */   extends Enemy
/*     */ {
/*     */   public static final float RAGE_DURATION = 15.0F;
/*     */   public static final float RAGE_SPEED_MULT = 0.3F;
/*     */   private boolean a;
/*     */   private float b;
/*     */   @NAGS
/*     */   private float c;
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect d;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  33 */     super.write(paramKryo, paramOutput);
/*  34 */     paramOutput.writeBoolean(this.a);
/*  35 */     paramOutput.writeFloat(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  40 */     super.read(paramKryo, paramInput);
/*  41 */     this.a = paramInput.readBoolean();
/*  42 */     this.b = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private BrootEnemy() {
/*  46 */     super(EnemyType.BROOT_BOSS);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossRelated() {
/*  51 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossMainBodyPart() {
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  61 */     if (this.d != null) {
/*  62 */       this.d.allowCompletion();
/*  63 */       this.d = null;
/*     */     } 
/*     */     
/*  66 */     super.setUnregistered();
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAbilityVulnerability(AbilityType paramAbilityType) {
/*  71 */     float f = super.getAbilityVulnerability(paramAbilityType);
/*     */     
/*  73 */     if (paramAbilityType == AbilityType.BALL_LIGHTNING) {
/*  74 */       return f * 0.1F;
/*     */     }
/*     */     
/*  77 */     return f;
/*     */   }
/*     */   
/*     */   public final float getSize() {
/*  81 */     return 51.2F;
/*     */   }
/*     */   
/*     */   public final float getSquaredSize() {
/*  85 */     return 2621.4402F;
/*     */   }
/*     */   
/*     */   public final void startRage() {
/*  89 */     this.a = true;
/*  90 */     this.b = 0.0F;
/*     */     
/*  92 */     if (this.d != null) {
/*  93 */       this.d.allowCompletion();
/*  94 */       this.d = null;
/*     */     } 
/*     */     
/*  97 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && !this.S._particle.willParticleBeSkipped()) {
/*  98 */       this.d = (ParticleEffectPool.PooledEffect)Game.i.enemyManager.F.BROOT_BOSS.a.obtain();
/*  99 */       this.S._particle.addParticle((ParticleEffect)this.d, true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBuffedSpeed() {
/* 105 */     float f = super.getBuffedSpeed();
/*     */     
/* 107 */     if (isInRage()) {
/* 108 */       f *= 0.3F;
/*     */     }
/*     */     
/* 111 */     return f;
/*     */   }
/*     */   
/*     */   public final boolean wasInRage() {
/* 115 */     return this.a;
/*     */   }
/*     */   
/*     */   public final boolean isInRage() {
/* 119 */     return (this.a && this.b < 15.0F);
/*     */   }
/*     */   
/*     */   public final float getRageDuration() {
/* 123 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void updateRageState(float paramFloat) {
/* 127 */     this.c += paramFloat;
/*     */     
/* 129 */     if (this.a) {
/* 130 */       this.b += paramFloat;
/* 131 */       if (this.b >= 15.0F)
/*     */       {
/* 133 */         if (this.d != null) {
/* 134 */           this.d.allowCompletion();
/* 135 */           this.d = null;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 140 */     if (isInRage() && this.d != null) {
/* 141 */       this.d.setPosition((getPosition()).x, (getPosition()).y);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void healthRestoredWithDamage() {
/* 146 */     if (this.c > 0.1F) {
/* 147 */       this.c = 0.0F;
/*     */       
/* 149 */       if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */         ParticleEffectPool.PooledEffect pooledEffect;
/* 151 */         (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.enemyManager.F.BROOT_BOSS.b.obtain()).setPosition((getPosition()).x, (getPosition()).y);
/* 152 */         this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/* 159 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/* 164 */     return 100.0F;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/* 201 */     return false;
/*     */   }
/*     */   
/*     */   public static class BrootEnemyFactory
/*     */     extends Enemy.Factory<BrootEnemy> {
/*     */     private TextureRegion c;
/*     */     ParticleEffectPool a;
/*     */     ParticleEffectPool b;
/*     */     
/*     */     public BrootEnemyFactory() {
/* 211 */       super(EnemyType.BROOT_BOSS);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 216 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 221 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 226 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-broot");
/*     */       
/* 228 */       this.a = Game.i.assetManager.getParticleEffectPool("anger.prt");
/* 229 */       this.b = Game.i.assetManager.getParticleEffectPool("regeneration-once.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public BrootEnemy create() {
/* 234 */       return new BrootEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 239 */       return MaterialColor.DEEP_ORANGE.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\bosses\BrootEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */