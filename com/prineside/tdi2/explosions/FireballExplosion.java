/*     */ package com.prineside.tdi2.explosions;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.abilities.FireballAbility;
/*     */ import com.prineside.tdi2.buffs.BurnBuff;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.ExplosionType;
/*     */ import com.prineside.tdi2.enums.LimitedParticleType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class FireballExplosion extends Explosion {
/*  25 */   private static final Color d = MaterialColor.DEEP_ORANGE.P400;
/*     */   
/*     */   private float e;
/*     */   
/*     */   private float f;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  32 */     super.write(paramKryo, paramOutput);
/*  33 */     paramOutput.writeFloat(this.e);
/*  34 */     paramOutput.writeFloat(this.f);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  39 */     super.read(paramKryo, paramInput);
/*  40 */     this.e = paramInput.readFloat();
/*  41 */     this.f = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private FireballExplosion() {
/*  45 */     super(ExplosionType.FIREBALL);
/*     */   }
/*     */   
/*     */   public final float getDamage() {
/*  49 */     return this.e;
/*     */   }
/*     */   
/*     */   public final float getFireDamage() {
/*  53 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, FireballAbility paramFireballAbility) {
/*  57 */     float f = 0.25F + paramFloat5 * 0.08F;
/*  58 */     this.e = paramFloat3;
/*  59 */     this.f = paramFloat4;
/*     */     
/*  61 */     a(null, paramFloat1, paramFloat2, 0.0F, paramFloat5, f, (Ability)paramFireballAbility);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void explode() {
/*  66 */     super.explode();
/*     */ 
/*     */     
/*  69 */     if (this.S._particle != null && Game.i.settingsManager.isExplosionsDrawing()) {
/*     */       ParticleEffectPool.PooledEffect pooledEffect;
/*     */ 
/*     */ 
/*     */       
/*  74 */       Array array = (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.assetManager.getParticleEffectPool("explosion.prt").obtain()).getEmitters();
/*     */       
/*  76 */       float f = this.b * 2.0F / 128.0F;
/*     */       
/*     */       ParticleEmitter.GradientColorValue gradientColorValue;
/*     */       
/*     */       float[] arrayOfFloat;
/*     */       
/*     */       ParticleEmitter particleEmitter2;
/*     */       
/*  84 */       (arrayOfFloat = (gradientColorValue = (particleEmitter2 = (ParticleEmitter)array.get(1)).getTint()).getColors())[0] = d.r;
/*  85 */       arrayOfFloat[1] = d.g;
/*  86 */       arrayOfFloat[2] = d.b;
/*  87 */       gradientColorValue.setColors(arrayOfFloat);
/*     */       
/*  89 */       particleEmitter2.getXScale().setHigh(16.0F * f);
/*  90 */       particleEmitter2.getYScale().setHigh(16.0F * f);
/*  91 */       particleEmitter2.getVelocity().setHigh(f * 50.0F, f * 150.0F);
/*     */       
/*     */       ParticleEmitter particleEmitter1;
/*     */       
/*  95 */       (particleEmitter1 = (ParticleEmitter)array.get(2)).getXScale().setLow(4.0F * f);
/*  96 */       particleEmitter1.getYScale().setLow(4.0F * f);
/*  97 */       particleEmitter1.getXScale().setHigh(8.0F * f, 32.0F * f);
/*  98 */       particleEmitter1.getYScale().setHigh(8.0F * f, 32.0F * f);
/*  99 */       particleEmitter1.getVelocity().setHigh(20.0F, 70.0F * f);
/*     */       
/* 101 */       pooledEffect.setPosition(this.position.x, this.position.y);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       (arrayOfFloat = (gradientColorValue = (particleEmitter1 = (ParticleEmitter)pooledEffect.getEmitters().get(0)).getTint()).getColors())[0] = d.r;
/* 109 */       arrayOfFloat[1] = d.g;
/* 110 */       arrayOfFloat[2] = d.b;
/* 111 */       gradientColorValue.setColors(arrayOfFloat);
/*     */       
/* 113 */       particleEmitter1.getXScale().setHigh(this.b * 2.0F);
/* 114 */       particleEmitter1.getYScale().setHigh(this.b * 2.0F);
/* 115 */       particleEmitter1.getLife().setHigh(this.c * 1000.0F);
/* 116 */       particleEmitter1.getLife().setLow(this.c * 1500.0F);
/*     */       
/* 118 */       this.S._particle.addLimitedParticle((ParticleEffect)pooledEffect, LimitedParticleType.EXPLOSION_FIREBALL, this.position.x, this.position.y);
/*     */     } 
/*     */     
/* 121 */     if (this.S._sound != null) {
/* 122 */       this.S._sound.playExplosionSound(this.position.x);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void enemyAffected(Enemy paramEnemy, float paramFloat1, float paramFloat2) {
/* 128 */     if (this.f > 0.0F) {
/*     */       BurnBuff burnBuff;
/* 130 */       (burnBuff = new BurnBuff()).setup(null, 15.0F, 150.0F, this.f, this.fromAbility);
/* 131 */       this.S.buff.P_BURN.addBuff(paramEnemy, burnBuff);
/*     */     } 
/*     */     
/* 134 */     if (this.e > 0.0F) {
/*     */       Tower tower;
/* 136 */       if ((tower = getTower()) != null && !tower.isRegistered()) {
/* 137 */         tower = null;
/*     */       }
/* 139 */       this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(paramEnemy, this.e, DamageType.FIRE)
/* 140 */           .setTower(tower)
/* 141 */           .setExplosion(this)
/* 142 */           .setAbility(this.fromAbility));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class FireballExplosionFactory
/*     */     extends Explosion.Factory<FireballExplosion>
/*     */   {
/*     */     public void setupAssets() {
/* 151 */       Game.i.assetManager.getParticleEffectPool("fireball-explosion.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     private static FireballExplosion b() {
/* 156 */       return new FireballExplosion((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\explosions\FireballExplosion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */