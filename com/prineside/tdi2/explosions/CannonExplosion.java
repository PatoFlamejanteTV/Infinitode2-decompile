/*     */ package com.prineside.tdi2.explosions;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.buffs.ThrowBackBuff;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.ExplosionType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.LimitedParticleType;
/*     */ import com.prineside.tdi2.projectiles.SplinterProjectile;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class CannonExplosion
/*     */   extends Explosion
/*     */ {
/*  27 */   private static final Color d = MaterialColor.RED.P400;
/*     */   
/*     */   private int e;
/*     */   
/*     */   private float f;
/*     */   private float g;
/*     */   public float throwBackDistance;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  36 */     super.write(paramKryo, paramOutput);
/*  37 */     paramOutput.writeVarInt(this.e, true);
/*  38 */     paramOutput.writeFloat(this.f);
/*  39 */     paramOutput.writeFloat(this.g);
/*  40 */     paramOutput.writeFloat(this.throwBackDistance);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  45 */     super.read(paramKryo, paramInput);
/*  46 */     this.e = paramInput.readVarInt(true);
/*  47 */     this.f = paramInput.readFloat();
/*  48 */     this.g = paramInput.readFloat();
/*  49 */     this.throwBackDistance = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private CannonExplosion() {
/*  53 */     super(ExplosionType.CANNON);
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6) {
/*  57 */     float f = 0.25F + paramFloat4 * 0.08F;
/*  58 */     a(paramTower, paramFloat1, paramFloat2, paramFloat3, paramFloat4, f, null);
/*     */     
/*  60 */     this.e = paramInt;
/*  61 */     this.f = paramFloat5;
/*  62 */     this.g = paramFloat6;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void explode() {
/*  67 */     super.explode();
/*     */     
/*  69 */     addExplosionParticle(d, LimitedParticleType.EXPLOSION_CANNON);
/*     */     
/*  71 */     if (this.S._sound != null) {
/*  72 */       this.S._sound.playExplosionSound(this.position.x);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void enemyAffected(Enemy paramEnemy, float paramFloat1, float paramFloat2) {
/*     */     Tower tower;
/*  79 */     if ((tower = getTower()) == null || !tower.isRegistered())
/*     */       return; 
/*  81 */     if (!tower.canAttackEnemy(paramEnemy)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  86 */     DamageRecord damageRecord = this.S.damage.obtainRecord().setup(paramEnemy, 1.0F, DamageType.EXPLOSION).setTower(tower).setExplosion(this).setAbility(this.fromAbility);
/*     */     
/*  88 */     if (tower.isAbilityInstalled(3) && (paramEnemy.getHealth() / paramEnemy.maxHealth) < this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_PRESSURE_HEALTH)) {
/*     */       
/*  90 */       float f = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_PRESSURE_DAMAGE);
/*  91 */       damageRecord.setDamage(calculateDamage(this.damage * (f + 1.0F), paramFloat1, paramFloat2));
/*     */     } else {
/*  93 */       damageRecord.setDamage(calculateDamage(this.damage, paramFloat1, paramFloat2));
/*     */     } 
/*  95 */     this.S.damage.queueDamage(damageRecord);
/*     */     
/*  97 */     if (this.throwBackDistance != 0.0F) {
/*     */       ThrowBackBuff throwBackBuff;
/*  99 */       (throwBackBuff = new ThrowBackBuff()).setup(tower.id, this.throwBackDistance, 0.5F, 10.0F);
/* 100 */       this.S.buff.P_THROW_BACK.addBuff(paramEnemy, throwBackBuff);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDone() {
/* 106 */     return (super.isDone() && this.e == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 111 */     super.update(paramFloat);
/*     */     
/*     */     Tower tower;
/* 114 */     if (this.e > 0 && (
/*     */       
/* 116 */       tower = getTower()) != null && tower.isRegistered()) {
/* 117 */       SplinterProjectile splinterProjectile = (SplinterProjectile)this.S.projectile.F.SPLINTER.obtain();
/* 118 */       this.S.projectile.register((Projectile)splinterProjectile);
/*     */       
/* 120 */       float f = this.S.gameState.randomFloat() * 6.2831855F;
/* 121 */       Vector2 vector21 = new Vector2();
/* 122 */       Vector2 vector22 = new Vector2();
/*     */       Vector2 vector23;
/* 124 */       (vector23 = new Vector2()).set(PMath.cos(f), PMath.sin(f));
/*     */       
/* 126 */       vector23.scl(32.0F);
/* 127 */       vector21.set(vector23).add(this.position);
/*     */       
/* 129 */       vector23.scl((this.g + 32.0F) / 32.0F);
/* 130 */       vector22.set(vector23).add(this.position);
/*     */       
/* 132 */       splinterProjectile.setup(tower, this.damage * this.f, vector21, vector22, 2.0F, null);
/*     */       
/* 134 */       this.e--;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final class CannonExplosionFactory
/*     */     extends Explosion.Factory<CannonExplosion>
/*     */   {
/*     */     private static CannonExplosion b() {
/* 142 */       return new CannonExplosion((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\explosions\CannonExplosion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */