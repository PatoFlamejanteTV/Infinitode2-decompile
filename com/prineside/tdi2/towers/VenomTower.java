/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.buffs.PoisonBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.projectiles.VenomProjectile;
/*     */ import com.prineside.tdi2.shapes.Circle;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class VenomTower
/*     */   extends Tower
/*     */ {
/*     */   public static final int ABILITY_FAST_SHELLS = 2;
/*  44 */   public static final String[] ABILITY_ALIASES = new String[] { "CONCENTRATED_POISON", "HARD_SHELLS", "FAST_SHELLS" };
/*     */   
/*     */   @NAGS
/*     */   private Circle e;
/*     */   
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect f;
/*     */   
/*     */   private float g;
/*     */   
/*     */   private boolean h = false;
/*     */   
/*     */   private float i;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  60 */     super.write(paramKryo, paramOutput);
/*  61 */     paramOutput.writeFloat(this.g);
/*  62 */     paramOutput.writeBoolean(this.h);
/*  63 */     paramOutput.writeFloat(this.i);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  68 */     super.read(paramKryo, paramInput);
/*  69 */     this.g = paramInput.readFloat();
/*  70 */     this.h = paramInput.readBoolean();
/*  71 */     this.i = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private VenomTower() {
/*  75 */     super(TowerType.VENOM);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/*  80 */     if (isAbilityInstalled(0)) {
/*  81 */       return Game.i.towerManager.F.VENOM.getAbilityTextures(0);
/*     */     }
/*  83 */     return Game.i.towerManager.F.VENOM.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void attack(int paramInt) {
/* 101 */     if (getTarget() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 105 */     Vector2 vector2 = new Vector2();
/* 106 */     PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, this.angle, 12.0F, vector2);
/*     */     
/* 108 */     VenomProjectile venomProjectile = (VenomProjectile)this.S.projectile.F.VENOM.obtain();
/* 109 */     this.S.projectile.register((Projectile)venomProjectile);
/*     */     
/*     */     PoisonBuff poisonBuff;
/*     */     
/* 113 */     (poisonBuff = new PoisonBuff()).setup(this, 
/*     */         
/* 115 */         getStat(TowerStatType.U_POISON_DURATION), 
/* 116 */         getStat(TowerStatType.U_POISON_DURATION) * 10.0F, this.i * paramInt, 
/*     */         
/* 118 */         getStat(TowerStatType.DAMAGE), null);
/*     */ 
/*     */ 
/*     */     
/* 122 */     venomProjectile.setup(this, getTarget(), poisonBuff, vector2, getStat(TowerStatType.PROJECTILE_SPEED));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     setTarget(null);
/*     */     
/* 130 */     this.shotCount += paramInt;
/*     */     
/* 132 */     if (this.S._sound != null) {
/* 133 */       this.S._sound.playShotSound(StaticSoundType.SHOT_VENOM, this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getUltimateChance() {
/* 140 */     float f1 = getUpgradeLevel() / 10.0F;
/* 141 */     float f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_CHAIN_CHANCE_MIN);
/* 142 */     float f3 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_CHAIN_CHANCE_MAX);
/* 143 */     return f2 + (f3 - f2) * f1;
/*     */   }
/*     */   
/*     */   public final float getPoisonousCloudRange() {
/* 147 */     return this.S.gameValue.getFloatValue(GameValueType.TOWER_VENOM_A_CLOUD_RANGE);
/*     */   }
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 152 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 154 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_CONCENTRATE_DAMAGE)); 
/* 155 */     if (paramTowerStatType == TowerStatType.PROJECTILE_SPEED && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_FAST_SPEED));
/*     */     
/* 157 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateCache() {
/* 162 */     super.updateCache();
/*     */ 
/*     */     
/* 165 */     this.i = getStat(TowerStatType.DAMAGE);
/* 166 */     if (isAbilityInstalled(1)) {
/* 167 */       this.i *= (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_HARD_DAMAGE);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void placedOnMap() {
/* 173 */     super.placedOnMap();
/* 174 */     this.h = true;
/*     */   }
/*     */   
/*     */   private void a() {
/* 178 */     if (this.h && 
/* 179 */       isRegistered() && this.S._particle != null && 
/*     */       
/* 181 */       isAbilityInstalled(3) && 
/* 182 */       !isOutOfOrder() && Game.i.settingsManager
/* 183 */       .isParticlesDrawing()) {
/*     */       
/* 185 */       if (this.f == null && !this.S._particle.willParticleBeSkipped()) {
/* 186 */         this.f = (ParticleEffectPool.PooledEffect)Game.i.towerManager.F.VENOM.c.obtain();
/* 187 */         this.S._particle.addParticle((ParticleEffect)this.f, true);
/* 188 */         this.f.setPosition((getTile()).center.x, (getTile()).center.y);
/*     */         
/*     */         return;
/*     */       } 
/* 192 */     } else if (this.f != null) {
/* 193 */       this.f.allowCompletion();
/* 194 */       this.f = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void removedFromMap() {
/* 201 */     super.removedFromMap();
/*     */     
/* 203 */     if (this.f != null) {
/* 204 */       this.f.allowCompletion();
/* 205 */       this.f = null;
/*     */     } 
/*     */     
/* 208 */     if (this.e != null) {
/* 209 */       this.e.free();
/* 210 */       this.e = null;
/*     */     } 
/*     */     
/* 213 */     this.h = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 220 */     if (isOutOfOrder()) {
/* 221 */       super.update(paramFloat);
/*     */       
/*     */       return;
/*     */     } 
/* 225 */     a(paramFloat, getStat(TowerStatType.ROTATION_SPEED));
/*     */ 
/*     */     
/* 228 */     float f = getPoisonousCloudRange() * 128.0F;
/*     */     
/* 230 */     this.g += paramFloat;
/* 231 */     if (this.g > 0.33F) {
/* 232 */       if (isAbilityInstalled(3)) {
/* 233 */         float f1 = this.g * getStat(TowerStatType.DAMAGE) * getStat(TowerStatType.ATTACK_SPEED) * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_CLOUD_DAMAGE_COEFF);
/* 234 */         this.S.map.getEnemiesInCircleV((getTile()).center, f, (paramEnemyReference, paramFloat2, paramFloat3, paramFloat4) -> {
/*     */               Enemy enemy;
/*     */               if ((enemy = paramEnemyReference.enemy) == null)
/*     */                 return true; 
/*     */               if (!enemy.isVulnerableTo(DamageType.POISON))
/*     */                 return true; 
/*     */               this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, paramFloat1, DamageType.POISON).setTower(this));
/*     */               return true;
/*     */             });
/*     */       } 
/* 244 */       this.g = 0.0F;
/*     */     } 
/*     */     
/* 247 */     super.update(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawGlitch(Batch paramBatch) {
/* 252 */     super.drawGlitch(paramBatch);
/* 253 */     a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 258 */     super.drawBatch(paramBatch, paramFloat);
/*     */     
/* 260 */     a();
/*     */     
/* 262 */     if (this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED) {
/* 263 */       if (isAbilityInstalled(3) && this.e == null && Game.i.shapeManager != null) {
/* 264 */         paramFloat = getPoisonousCloudRange() * 128.0F;
/*     */         
/* 266 */         this.e = (Circle)Game.i.shapeManager.getFactory(ShapeType.CIRCLE).obtain();
/*     */         Color color1;
/* 268 */         (color1 = MaterialColor.LIGHT_GREEN.P500.cpy()).a = 0.0F;
/*     */         Color color2;
/* 270 */         (color2 = MaterialColor.LIGHT_GREEN.P500.cpy()).a = 0.07F;
/* 271 */         this.e.setup((getTile()).center.x, (getTile()).center.y, paramFloat * 0.67F, paramFloat, 32, color1.toFloatBits(), color2.toFloatBits());
/*     */       } 
/*     */       
/* 274 */       if (this.e != null) {
/* 275 */         this.e.draw(paramBatch);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getEnemyPriority(Enemy paramEnemy) {
/* 282 */     if (paramEnemy.hasBuffsByType(BuffType.POISON)) {
/*     */       
/* 284 */       DelayedRemovalArray delayedRemovalArray = paramEnemy.buffsByType[BuffType.POISON.ordinal()];
/* 285 */       boolean bool = false;
/* 286 */       byte b1 = isAbilityInstalled(2) ? this.S.gameValue.getIntValue(GameValueType.TOWER_VENOM_A_FAST_MAX_DEBUFFS) : 1;
/* 287 */       for (byte b2 = 0; b2 < delayedRemovalArray.size; b2++) {
/*     */         PoisonBuff poisonBuff;
/* 289 */         if ((poisonBuff = (PoisonBuff)delayedRemovalArray.get(b2)).tower == this) {
/*     */           
/* 291 */           if (b1 <= 1 || poisonBuff.fastShellsStackCount >= b1)
/*     */           {
/* 293 */             bool = true;
/*     */           }
/*     */           break;
/*     */         } 
/*     */       } 
/* 298 */       if (bool) {
/* 299 */         return paramEnemy.lowAimPriority.isTrue() ? -5 : 5;
/*     */       }
/* 301 */       return super.getEnemyPriority(paramEnemy);
/*     */     } 
/*     */     
/* 304 */     return super.getEnemyPriority(paramEnemy);
/*     */   }
/*     */   
/*     */   public static class VenomTowerFactory
/*     */     extends Tower.Factory<VenomTower> {
/*     */     ParticleEffectPool c;
/*     */     
/*     */     public VenomTowerFactory() {
/* 312 */       super("tower-venom", TowerType.VENOM);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 317 */       super.setup();
/*     */       
/* 319 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "" };
/* 320 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "" };
/* 321 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 322 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "", "" };
/* 323 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "", "", "", "" };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 330 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_CONCENTRATE_DAMAGE), 2, true).toString();
/* 331 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_HARD_DAMAGE), 2, true).toString();
/* 332 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_FAST_SPEED), 2, true).toString();
/* 333 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_VENOM_A_FAST_MAX_DEBUFFS), false).toString();
/* 334 */       (arrayOfAbilityConfig[2]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_VENOM_A_FAST_DAMAGE_PER_STACK), 2, true).toString();
/* 335 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_VENOM_A_CLOUD_RANGE), 2, true).toString();
/* 336 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_VENOM_A_CLOUD_DAMAGE_COEFF), 2, true).toString();
/* 337 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_VENOM_A_CHAIN_DURATION), 2, true).toString();
/* 338 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros((((VenomTower)param1Tower).getUltimateChance() * 100.0F), 2, true).toString();
/* 339 */       (arrayOfAbilityConfig[4]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_VENOM_A_CHAIN_RANGE), 2, true).toString();
/* 340 */       (arrayOfAbilityConfig[4]).descriptionArgs[3] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_VENOM_A_CHAIN_PROLONG), 2, true).toString();
/*     */       
/* 342 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 348 */       if (param1Int == 0) {
/* 349 */         return false;
/*     */       }
/* 351 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 356 */       this.c = Game.i.assetManager.getParticleEffectPool("poison-cloud.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public VenomTower create() {
/* 361 */       return new VenomTower((byte)0);
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 365 */       return MaterialColor.LIGHT_GREEN.P500;
/*     */     }
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 369 */       switch (VenomTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 370 */           return 3;
/* 371 */         case 2: return 2;
/* 372 */         case 3: return 3;
/* 373 */         case 4: return 4;
/* 374 */         case 5: return 2; }
/* 375 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 381 */       return VenomTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 386 */       return 29;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\VenomTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */