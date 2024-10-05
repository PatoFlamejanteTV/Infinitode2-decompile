/*     */ package com.prineside.tdi2.projectiles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyFollowingProjectile;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.buffs.ChainReactionBuff;
/*     */ import com.prineside.tdi2.buffs.PoisonBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.towers.VenomTower;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class VenomProjectile
/*     */   extends EnemyFollowingProjectile
/*     */ {
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect d;
/*     */   private VenomTower e;
/*     */   private PoisonBuff f;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  37 */     super.write(paramKryo, paramOutput);
/*  38 */     paramKryo.writeObjectOrNull(paramOutput, this.e, VenomTower.class);
/*  39 */     paramKryo.writeObjectOrNull(paramOutput, this.f, PoisonBuff.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  44 */     super.read(paramKryo, paramInput);
/*  45 */     this.e = (VenomTower)paramKryo.readObjectOrNull(paramInput, VenomTower.class);
/*  46 */     this.f = (PoisonBuff)paramKryo.readObjectOrNull(paramInput, PoisonBuff.class);
/*     */   }
/*     */   
/*     */   private VenomProjectile() {
/*  50 */     super(ProjectileType.VENOM);
/*     */   }
/*     */   
/*     */   public final void setup(VenomTower paramVenomTower, Enemy paramEnemy, PoisonBuff paramPoisonBuff, Vector2 paramVector2, float paramFloat) {
/*  54 */     setup(paramVector2, paramEnemy, paramFloat);
/*     */     
/*  56 */     this.e = paramVenomTower;
/*  57 */     this.f = paramPoisonBuff;
/*     */     
/*  59 */     if (this.S._particle != null && this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*  60 */       this.d = (ParticleEffectPool.PooledEffect)this.S.projectile.F.VENOM.b.obtain();
/*  61 */       this.d.setPosition(paramVector2.x, paramVector2.y);
/*  62 */       this.S._particle.addParticle((ParticleEffect)this.d, true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void multiplyDamage(float paramFloat) {
/*  68 */     super.multiplyDamage(paramFloat);
/*     */     
/*  70 */     this.f.hitDamage *= paramFloat;
/*  71 */     this.f.poisonDamage *= paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  76 */     super.reset();
/*     */     
/*  78 */     this.f = null;
/*  79 */     this.e = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  84 */     super.setUnregistered();
/*  85 */     if (this.d != null) {
/*  86 */       this.d.allowCompletion();
/*  87 */       this.d = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hit() {
/*  93 */     super.hit();
/*     */     
/*     */     Enemy enemy;
/*  96 */     if ((enemy = getTarget()) != null) {
/*  97 */       this.S.buff.P_POISON.addBuff(enemy, this.f);
/*     */       
/*  99 */       if (this.e != null && this.e.isRegistered() && this.e.type == TowerType.VENOM && this.e.isAbilityInstalled(4)) {
/*     */         
/* 101 */         VenomTower venomTower = this.e;
/* 102 */         if (!enemy.hasBuffsByType(BuffType.CHAIN_REACTION)) {
/*     */           
/* 104 */           ChainReactionBuff chainReactionBuff = new ChainReactionBuff();
/* 105 */           float f = this.S.gameValue.getFloatValue(GameValueType.TOWER_VENOM_A_CHAIN_DURATION);
/* 106 */           chainReactionBuff.setup(f, f * 10.0F, venomTower
/*     */ 
/*     */               
/* 109 */               .getUltimateChance(), this.S.gameValue
/* 110 */               .getFloatValue(GameValueType.TOWER_VENOM_A_CHAIN_RANGE), 1.0F + 
/* 111 */               (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_CHAIN_PROLONG));
/* 112 */           this.S.buff.P_CHAIN_REACTION.addBuff(enemy, chainReactionBuff);
/*     */         } 
/*     */       } 
/*     */       
/* 116 */       this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, this.f.hitDamage, DamageType.POISON).setTower(this.f.tower).setProjectile((Projectile)this));
/*     */ 
/*     */       
/* 119 */       if (this.f.tower != null && this.f.tower.getTarget() == enemy) {
/* 120 */         this.f.tower.setTarget(null);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 127 */     paramBatch.draw(this.S.projectile.F.VENOM.a, this.drawPosition.x - 9.0F, this.drawPosition.y - 9.0F, 9.0F, 9.0F, 18.0F, 18.0F, 1.0F, 1.0F, this.drawAngle);
/*     */     
/* 129 */     if (this.d != null) this.d.setPosition(this.drawPosition.x, this.drawPosition.y);
/*     */     
/* 131 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public static class VenomProjectileFactory
/*     */     extends Projectile.Factory<VenomProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     ParticleEffectPool b;
/*     */     
/*     */     public void setupAssets() {
/* 141 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-venom");
/* 142 */       Game.i.assetManager.getTextureRegion("bullet-trace-thin");
/* 143 */       this.b = Game.i.assetManager.getParticleEffectPool("venom-projectile.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     private static VenomProjectile b() {
/* 148 */       return new VenomProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\VenomProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */