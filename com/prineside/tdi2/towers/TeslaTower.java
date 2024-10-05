/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Animation;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Shape;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.abilities.BallLightningAbility;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.projectiles.ChainLightningProjectile;
/*     */ import com.prineside.tdi2.shapes.Circle;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.units.BallLightningUnit;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ @REGS
/*     */ public final class TeslaTower
/*     */   extends Tower {
/*     */   public static final float SPECIAL_ABILITY_RANGE = 3.5F;
/*  46 */   public static final String[] ABILITY_ALIASES = new String[] { "HIGH_CURRENT", "LARGE_BATTERIES", "INCREASED_VOLTAGE" };
/*     */ 
/*     */   
/*     */   private boolean e;
/*     */   
/*     */   private float f;
/*     */   
/*     */   private byte g;
/*     */   
/*     */   @NAGS
/*     */   private Circle h;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  60 */     super.write(paramKryo, paramOutput);
/*  61 */     paramOutput.writeBoolean(this.e);
/*  62 */     paramOutput.writeFloat(this.f);
/*  63 */     paramOutput.writeByte(this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  68 */     super.read(paramKryo, paramInput);
/*  69 */     this.e = paramInput.readBoolean();
/*  70 */     this.f = paramInput.readFloat();
/*  71 */     this.g = paramInput.readByte();
/*     */   }
/*     */   
/*     */   private TeslaTower() {
/*  75 */     super(TowerType.TESLA);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/*  80 */     if (isAbilityInstalled(0)) {
/*  81 */       return Game.i.towerManager.F.TESLA.getAbilityTextures(0);
/*     */     }
/*  83 */     return Game.i.towerManager.F.TESLA.getWeaponTexture();
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
/*     */   public final void attack(int paramInt) {
/*     */     float f3;
/*     */     Enemy enemy;
/* 102 */     if ((enemy = getTarget()) == null) {
/*     */       return;
/*     */     }
/*     */     
/* 106 */     float f1 = getStat(TowerStatType.DAMAGE);
/* 107 */     float f2 = getStat(TowerStatType.U_CHAIN_LIGHTNING_LENGTH);
/*     */     
/* 109 */     Vector2 vector2 = new Vector2();
/* 110 */     PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, this.angle, 36.0F, vector2);
/*     */     
/* 112 */     ChainLightningProjectile chainLightningProjectile = (ChainLightningProjectile)this.S.projectile.F.CHAIN_LIGHTNING.obtain();
/* 113 */     this.S.projectile.register((Projectile)chainLightningProjectile);
/*     */ 
/*     */     
/* 116 */     if (isAbilityInstalled(2)) {
/* 117 */       f3 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_VOLTAGE_MIN_DAMAGE);
/*     */     } else {
/* 119 */       f3 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_CHAIN_MIN_DAMAGE);
/*     */     } 
/* 121 */     float f4 = (enemy.getPosition()).x;
/* 122 */     float f5 = (enemy.getPosition()).y;
/* 123 */     chainLightningProjectile.setup(this, enemy, f1 * paramInt, f1 * f3 * paramInt, 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 128 */         getStat(TowerStatType.CHAIN_LIGHTNING_DAMAGE) * 0.01F, f2, vector2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     this.shotCount += paramInt;
/*     */     
/* 138 */     if (isAbilityInstalled(4)) {
/* 139 */       paramInt = this.S.gameValue.getIntValue(GameValueType.TOWER_TESLA_A_ULTIMATE_SHOT_INTERVAL);
/* 140 */       if (this.shotCount % paramInt == 0) {
/*     */         BallLightningAbility ballLightningAbility;
/*     */         
/* 143 */         if ((ballLightningAbility = (BallLightningAbility)this.S.ability.registerConfigureAndStartAbility(AbilityType.BALL_LIGHTNING, (int)f4, (int)f5, this.S.damage.getTowersMaxDps())) != null) {
/* 144 */           ballLightningAbility.damage = f1 * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_ULTIMATE_DAMAGE);
/* 145 */           ballLightningAbility.attackInterval = getAttackDelay();
/* 146 */           ballLightningAbility.duration = this.S.gameValue.getFloatValue(GameValueType.TOWER_TESLA_A_ULTIMATE_DURATION);
/* 147 */           ballLightningAbility.launchedByTower = this;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 152 */     if (this.S._sound != null) {
/* 153 */       this.S._sound.playShotSound(StaticSoundType.SHOT_TESLA, this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 161 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 163 */     if (paramTowerStatType == TowerStatType.U_CHAIN_LIGHTNING_LENGTH && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_VOLTAGE_LENGTH)); 
/* 164 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_CURRENT_DAMAGE)); 
/* 165 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_BATTERIES_DAMAGE)); 
/* 166 */     if (paramTowerStatType == TowerStatType.ATTACK_SPEED && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_BATTERIES_SPEED));
/*     */     
/* 168 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 175 */     if (isOutOfOrder()) {
/* 176 */       super.update(paramFloat);
/*     */       
/*     */       return;
/*     */     } 
/* 180 */     a(paramFloat, getStat(TowerStatType.ROTATION_SPEED));
/*     */ 
/*     */     
/* 183 */     if (isAbilityInstalled(3)) {
/* 184 */       this.g = (byte)(this.g + 1);
/* 185 */       if (this.g == 7) {
/* 186 */         this.g = 0;
/* 187 */         this.e = true;
/* 188 */         this.S.map.getEnemiesInCircle((getTile()).center.x, (getTile()).center.y, 448.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */               if (paramEnemyReference.enemy == null)
/*     */                 return true; 
/*     */               this.e = false;
/*     */               return false;
/*     */             });
/*     */       } 
/*     */     } else {
/* 196 */       this.e = false;
/*     */     } 
/*     */     
/* 199 */     if (this.e) {
/*     */       
/* 201 */       this.f += paramFloat;
/* 202 */       if (this.f >= this.S.unit.getBallLightningAccumulationTime()) {
/*     */         BallLightningUnit ballLightningUnit;
/*     */         
/* 205 */         (ballLightningUnit = Game.i.unitManager.F.BALL_LIGHTNING.create()).setup(this, getStat(TowerStatType.DAMAGE) * 1.0F / getAttackDelay() * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_BALL_DAMAGE));
/* 206 */         if (this.S.unit.preparePathToRandomSpawn((Unit)ballLightningUnit, (Tile)getTile())) {
/* 207 */           this.S.unit.register((Unit)ballLightningUnit);
/* 208 */           this.S.map.spawnUnit((Unit)ballLightningUnit);
/*     */         } 
/*     */         
/* 211 */         this.f = 0.0F;
/*     */       } 
/*     */     } else {
/*     */       
/* 215 */       if (this.S._particle != null && this.f > this.S.unit.getBallLightningAccumulationTime() * 0.25F && Game.i.settingsManager.isParticlesDrawing()) {
/*     */         ParticleEffectPool.PooledEffect pooledEffect;
/* 217 */         (pooledEffect = Game.i.unitManager.F.BALL_LIGHTNING.getBreakParticle()).setPosition((getTile()).center.x, (getTile()).center.y);
/* 218 */         this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */       } 
/*     */       
/* 221 */       this.f = 0.0F;
/*     */     } 
/*     */     
/* 224 */     super.update(paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 230 */     if (this.f > 0.0F) {
/* 231 */       float f = this.f / this.S.unit.getBallLightningAccumulationTime();
/*     */       TextureRegion textureRegion;
/* 233 */       f = (textureRegion = (TextureRegion)Game.i.towerManager.F.TESLA.c.getKeyFrame(this.f, true)).getRegionWidth() * f;
/* 234 */       paramBatch.draw(textureRegion, (getTile()).center.x - f * 0.5F, (getTile()).center.y - f * 0.5F, f, f);
/*     */     } 
/*     */ 
/*     */     
/*     */     boolean bool;
/*     */ 
/*     */     
/* 241 */     if (bool = (this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED && this.S._gameMapSelection.getSelectedTile() == getTile() && isAbilityInstalled(3)) ? true : false) {
/* 242 */       if (this.h == null && Game.i.shapeManager != null) {
/* 243 */         this.h = (Circle)Game.i.shapeManager.F.CIRCLE.obtain();
/*     */         
/* 245 */         float f = (new Color(1.0F, 1.0F, 1.0F, 0.07F)).toFloatBits();
/* 246 */         this.h.setup((getTile()).center.x, (getTile()).center.y, 444.0F, 448.0F, 112, f, f);
/* 247 */         this.h.setSkipOddSegments(true);
/*     */       } 
/* 249 */       if (this.h != null) {
/* 250 */         this.h.draw(paramBatch);
/*     */       }
/*     */     }
/* 253 */     else if (this.h != null) {
/* 254 */       Game.i.shapeManager.F.CIRCLE.free((Shape)this.h);
/* 255 */       this.h = null;
/*     */     } 
/*     */ 
/*     */     
/* 259 */     super.drawBatch(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public static class TeslaTowerFactory extends Tower.Factory<TeslaTower> {
/*     */     Animation<ResourcePack.AtlasTextureRegion> c;
/*     */     
/*     */     public TeslaTowerFactory() {
/* 266 */       super("tower-tesla", TowerType.TESLA);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 271 */       super.setup();
/*     */       
/* 273 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "" };
/* 274 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "", "" };
/* 275 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "" };
/* 276 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 277 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "", "", "" };
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 282 */       this.c = Game.i.unitManager.F.BALL_LIGHTNING.getBallAnimation();
/*     */     }
/*     */     
/*     */     @Null
/*     */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/* 287 */       if (param1TowerStatType == TowerStatType.CHAIN_LIGHTNING_DAMAGE) {
/*     */         float f;
/* 289 */         if (param1Tower.isAbilityInstalled(2)) {
/* 290 */           f = (float)param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_VOLTAGE_MIN_DAMAGE);
/*     */         } else {
/* 292 */           f = (float)param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_CHAIN_MIN_DAMAGE);
/*     */         } 
/* 294 */         String str = StringFormatter.compactNumberWithPrecisionTrimZeros((f * 100.0F), 1, true).toString();
/* 295 */         return Game.i.localeManager.i18n.format("tower_stat_more_info_TESLA_CHAIN_LIGHTNING_DAMAGE", new Object[] { str });
/*     */       } 
/* 297 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 305 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_CURRENT_DAMAGE), 2, true).toString();
/* 306 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_BATTERIES_SPEED), 2, true).toString();
/* 307 */       (arrayOfAbilityConfig[1]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_BATTERIES_DAMAGE), 2, true).toString();
/* 308 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_VOLTAGE_LENGTH), 2, true).toString();
/* 309 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_TESLA_A_VOLTAGE_MIN_DAMAGE), 2, true).toString();
/* 310 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(3.5D, 1, true).toString();
/* 311 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_TESLA_A_BALL_DAMAGE), false).toString();
/* 312 */       (arrayOfAbilityConfig[3]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_TESLA_A_PER_BALL_PENALTY), 1, true).toString();
/* 313 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_TESLA_A_ULTIMATE_SHOT_INTERVAL), false).toString();
/* 314 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_TESLA_A_ULTIMATE_DAMAGE), 2, true).toString();
/* 315 */       (arrayOfAbilityConfig[4]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_TESLA_A_ULTIMATE_DURATION), 2, true).toString();
/*     */       
/* 317 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 323 */       if (param1Int == 0) {
/* 324 */         return false;
/*     */       }
/* 326 */       return true;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 330 */       return MaterialColor.INDIGO.P500;
/*     */     }
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 334 */       switch (TeslaTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 335 */           return 4;
/* 336 */         case 2: return 3;
/* 337 */         case 3: return 2;
/* 338 */         case 4: return 4;
/* 339 */         case 5: return 3; }
/* 340 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 346 */       return TeslaTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 351 */       return 31;
/*     */     }
/*     */ 
/*     */     
/*     */     public TeslaTower create() {
/* 356 */       return new TeslaTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\TeslaTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */