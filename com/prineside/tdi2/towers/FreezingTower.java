/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Shape;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.buffs.FreezingBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.shapes.Circle;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.units.SnowballUnit;
/*     */ import com.prineside.tdi2.utils.DrawUtils;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ @REGS
/*     */ public final class FreezingTower extends Tower {
/*     */   public static final float SPECIAL_ABILITY_RANGE = 2.5F;
/*     */   public static final float MONITORED_TARGET_FREEZING_BONUS = 15.0F;
/*  43 */   private static final Color e = (new Color(MaterialColor.LIGHT_BLUE.P500)).mul(1.0F, 1.0F, 1.0F, 0.14F);
/*  44 */   private static final Color f = (new Color(MaterialColor.LIGHT_BLUE.P500)).mul(1.0F, 1.0F, 1.0F, 0.56F);
/*     */   
/*     */   public static final int ABILITY_COLD_EVAPORATION = 0;
/*     */   
/*     */   public static final int ABILITY_SLOW_FREEZING = 1;
/*     */   public static final int ABILITY_MONITORING_SYSTEM = 2;
/*  50 */   public static final String[] ABILITY_ALIASES = new String[] { "COLD_EVAPORATION", "SLOW_FREEZING", "MONITORING_SYSTEM" };
/*     */   
/*     */   public static final float GAIN_EXP_COEFF = 0.02F;
/*     */   
/*     */   public static final float SNOWBALL_ACCUMULATION_TIME = 8.0F;
/*     */   
/*     */   private float g;
/*     */   
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte h;
/*     */   
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect i;
/*     */   
/*     */   @NAGS
/*     */   private Circle j;
/*     */   @NAGS
/*     */   private Circle k;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  70 */     super.write(paramKryo, paramOutput);
/*  71 */     paramOutput.writeFloat(this.g);
/*  72 */     paramOutput.writeByte(this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  77 */     super.read(paramKryo, paramInput);
/*  78 */     this.g = paramInput.readFloat();
/*  79 */     this.h = paramInput.readByte();
/*     */   }
/*     */   
/*     */   private FreezingTower() {
/*  83 */     super(TowerType.FREEZING);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/*  88 */     if (isAbilityInstalled(1)) {
/*  89 */       return Game.i.towerManager.F.FREEZING.getAbilityTextures(1);
/*     */     }
/*  91 */     return Game.i.towerManager.F.FREEZING.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float a() {
/*  97 */     float f = (float)Math.pow((f = 1.0F + (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FREEZING_A_PER_SNOWBALL_PENALTY)), this.S.unit.spawnedSnowballs);
/*  98 */     return 8.0F * f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/* 105 */     return isAbilityInstalled(2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 110 */     return isAbilityInstalled(2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float b() {
/* 116 */     float f1 = this.S.gameValue.getFloatValue(GameValueType.TOWER_FREEZING_A_SNOWBALL_MIN_DURATION);
/* 117 */     float f2 = this.S.gameValue.getFloatValue(GameValueType.TOWER_FREEZING_A_SNOWBALL_MAX_DURATION);
/* 118 */     float f3 = getUpgradeLevel() / 10.0F;
/*     */     
/* 120 */     return f1 + (f2 - f1) * f3;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 125 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 127 */     if (paramTowerStatType == TowerStatType.FREEZE_PERCENT && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FREEZING_A_SLOW_PERCENT)); 
/* 128 */     if (paramTowerStatType == TowerStatType.FREEZE_SPEED && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FREEZING_A_SLOW_SPEED));
/*     */     
/* 130 */     return f;
/*     */   }
/*     */   
/*     */   private void c() {
/* 134 */     Color color1 = MaterialColor.LIGHT_BLUE.P500.cpy();
/* 135 */     Color color2 = MaterialColor.LIGHT_BLUE.P500.cpy();
/* 136 */     color1.a = 0.0F;
/* 137 */     color2.a = 0.07F;
/* 138 */     this.j.setup((getTile()).center.x, (getTile()).center.y, this.rangeInPixels * 0.5F, this.rangeInPixels, 48, color1.toFloatBits(), color2.toFloatBits());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateCache() {
/* 143 */     super.updateCache();
/*     */     
/* 145 */     if (this.j != null && getTile() != null) {
/* 146 */       c();
/*     */     }
/*     */     
/* 149 */     if (isAbilityInstalled(2)) {
/* 150 */       this.experienceMultiplier = (float)(this.experienceMultiplier * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FREEZING_A_MONITORING_XP));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void removedFromMap() {
/* 158 */     super.removedFromMap();
/*     */     
/* 160 */     if (this.i != null) this.i.allowCompletion();
/*     */   
/*     */   }
/*     */   
/*     */   private void a(float paramFloat) {
/* 165 */     if (isAbilityInstalled(3) && !isOutOfOrder()) {
/* 166 */       boolean[] arrayOfBoolean = { false };
/* 167 */       float f = 1.0F;
/*     */       
/* 169 */       if (isAbilityInstalled(4)) {
/* 170 */         f = (float)(1.0D + this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FREEZING_A_ULTIMATE_SNOW_BONUS));
/*     */       } else {
/*     */         
/* 173 */         this.S.map.getEnemiesInCircle((getTile()).center.x, (getTile()).center.y, 320.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */               if (paramEnemyReference.enemy == null) {
/*     */                 return true;
/*     */               }
/*     */               paramArrayOfboolean[0] = true;
/*     */               return false;
/*     */             });
/*     */       } 
/* 181 */       if (!arrayOfBoolean[0]) {
/*     */         
/* 183 */         this.g += paramFloat * f;
/*     */         
/* 185 */         if (this.g >= a())
/*     */         { SnowballUnit snowballUnit;
/*     */           
/* 188 */           (snowballUnit = Game.i.unitManager.F.SNOWBALL.create()).setup(this, b());
/* 189 */           if (this.S.unit.preparePathToRandomSpawn((Unit)snowballUnit, (Tile)getTile())) {
/* 190 */             this.S.unit.register((Unit)snowballUnit);
/* 191 */             this.S.map.spawnUnit((Unit)snowballUnit);
/*     */           
/*     */           }
/* 194 */           else if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */             ParticleEffectPool.PooledEffect pooledEffect;
/* 196 */             (pooledEffect = Game.i.unitManager.F.SNOWBALL.getBreakParticle()).setPosition((getTile()).center.x, (getTile()).center.y);
/* 197 */             this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */           } 
/*     */ 
/*     */           
/* 201 */           this.g = 0.0F; }
/*     */         else { return; }
/*     */       
/*     */       } else {
/* 205 */         if (this.S._particle != null && this.g > a() * 0.25F && Game.i.settingsManager.isParticlesDrawing()) {
/*     */           ParticleEffectPool.PooledEffect pooledEffect;
/* 207 */           (pooledEffect = Game.i.unitManager.F.SNOWBALL.getBreakParticle()).setPosition((getTile()).center.x, (getTile()).center.y);
/* 208 */           this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */         } 
/*     */         
/* 211 */         this.g = 0.0F; return;
/*     */       } 
/*     */     } else {
/* 214 */       this.g = 0.0F;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void d() {
/* 219 */     if (!isOutOfOrder()) {
/*     */       
/* 221 */       float f1 = getStat(TowerStatType.FREEZE_PERCENT);
/* 222 */       float f2 = getStat(TowerStatType.FREEZE_SPEED);
/* 223 */       float f3 = getStat(TowerStatType.U_POISON_DURATION_BONUS);
/* 224 */       float f4 = getStat(TowerStatType.U_CHAIN_LIGHTNING_BONUS_LENGTH);
/*     */       
/* 226 */       this.S.map.getEnemiesInCircle((getTile()).center.x, (getTile()).center.y, this.rangeInPixels, (paramEnemyReference, paramFloat5, paramFloat6, paramFloat7) -> {
/*     */             Enemy enemy;
/*     */             if ((enemy = paramEnemyReference.enemy) == null) {
/*     */               return true;
/*     */             }
/*     */             if (canAttackEnemy(enemy)) {
/*     */               DelayedRemovalArray delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.FREEZING);
/*     */               FreezingBuff freezingBuff = null;
/*     */               if (delayedRemovalArray != null && ((Array)delayedRemovalArray).size != 0) {
/*     */                 for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/*     */                   FreezingBuff freezingBuff1;
/*     */                   if ((freezingBuff1 = (FreezingBuff)((Array)delayedRemovalArray).items[b]).tower == this) {
/*     */                     freezingBuff = freezingBuff1;
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */               paramFloat7 = enemy.getTowerDamageMultiplier(TowerType.FREEZING) * paramFloat1;
/*     */               if (freezingBuff == null) {
/*     */                 FreezingBuff freezingBuff1;
/*     */                 (freezingBuff1 = new FreezingBuff()).setup(this, paramFloat2, paramFloat7, 0.25F, 5.0F, paramFloat3, paramFloat4);
/*     */                 freezingBuff1.copyDisabled = true;
/*     */                 this.S.buff.P_FREEZING.addBuff(enemy, freezingBuff1);
/*     */                 freezingBuff = freezingBuff1;
/*     */               } else {
/*     */                 freezingBuff.duration = 0.25F;
/*     */                 freezingBuff.speed = paramFloat2;
/*     */                 freezingBuff.maxPercent = paramFloat7;
/*     */                 freezingBuff.poisonDurationBonus = paramFloat3;
/*     */                 freezingBuff.lightningLengthBonus = paramFloat4;
/*     */               } 
/*     */               if (isAbilityInstalled(2) && enemy == getTarget()) {
/*     */                 freezingBuff.maxPercent = paramFloat1 * 1.15F;
/*     */                 if (freezingBuff.maxPercent > 95.0F) {
/*     */                   freezingBuff.maxPercent = 95.0F;
/*     */                 }
/*     */                 enemy.buffFreezingPercent = Math.max(enemy.buffFreezingPercent, freezingBuff.maxPercent);
/*     */               } else {
/*     */                 freezingBuff.maxPercent = paramFloat7;
/*     */               } 
/*     */             } 
/*     */             return true;
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 279 */     this.angle += paramFloat * 360.0F;
/* 280 */     this.angle %= 360.0F;
/*     */     
/* 282 */     if (this.i == null && this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */       
/* 284 */       this.i = (ParticleEffectPool.PooledEffect)Game.i.towerManager.F.FREEZING.d.obtain();
/* 285 */       this.i.setPosition((getTile()).center.x, (getTile()).center.y);
/*     */       
/* 287 */       Array array = this.i.getEmitters();
/*     */       
/* 289 */       float f = getRange() * 2.0F;
/*     */       
/*     */       ParticleEmitter particleEmitter;
/*     */       
/* 293 */       (particleEmitter = (ParticleEmitter)array.get(0)).getXScale().setHigh(6.0F * f, 12.0F * f);
/* 294 */       particleEmitter.getYScale().setHigh(6.0F * f, 12.0F * f);
/* 295 */       particleEmitter.getXScale().setLow(4.0F * f);
/* 296 */       particleEmitter.getYScale().setLow(4.0F * f);
/* 297 */       particleEmitter.getVelocity().setHigh(8.0F * f, 16.0F * f);
/* 298 */       particleEmitter.getVelocity().setLow(8.0F * f);
/*     */ 
/*     */       
/* 301 */       ((ParticleEmitter)array.get(1)).getXScale().setHigh(140.0F * f);
/* 302 */       ((ParticleEmitter)array.get(1)).getYScale().setHigh(140.0F * f);
/*     */       
/* 304 */       this.S._particle.addParticle((ParticleEffect)this.i, false);
/*     */     } 
/*     */     
/* 307 */     a(paramFloat);
/*     */ 
/*     */     
/* 310 */     this.h = (byte)(this.h + 1);
/* 311 */     if (this.h == 8) {
/* 312 */       this.h = 0;
/* 313 */       d();
/*     */     } 
/*     */ 
/*     */     
/* 317 */     super.update(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/*     */     Enemy enemy;
/* 323 */     if (isAbilityInstalled(2) && (
/*     */       
/* 325 */       enemy = getTarget()) != null)
/*     */     {
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
/* 337 */       DrawUtils.texturedLineD(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), (getTile()).center.x, (getTile()).center.y, (enemy.getPosition()).x, (enemy.getPosition()).y, 1.7F, 6.0F, e, f);
/*     */     }
/*     */ 
/*     */     
/* 341 */     if (this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED) {
/* 342 */       if (this.j == null && Game.i.shapeManager != null) {
/* 343 */         this.j = (Circle)Game.i.shapeManager.getFactory(ShapeType.CIRCLE).obtain();
/* 344 */         c();
/*     */       } 
/* 346 */       if (this.j != null) {
/* 347 */         this.j.draw(paramBatch);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean bool;
/*     */ 
/*     */     
/* 356 */     if (bool = (this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED && this.S._gameMapSelection.getSelectedTile() == getTile() && isAbilityInstalled(3) && !isAbilityInstalled(4)) ? true : false) {
/* 357 */       if (this.k == null && Game.i.shapeManager != null) {
/* 358 */         this.k = (Circle)Game.i.shapeManager.F.CIRCLE.obtain();
/*     */         
/* 360 */         float f = (new Color(1.0F, 1.0F, 1.0F, 0.07F)).toFloatBits();
/* 361 */         this.k.setup((getTile()).center.x, (getTile()).center.y, 316.0F, 320.0F, 112, f, f);
/* 362 */         this.k.setSkipOddSegments(true);
/*     */       } 
/* 364 */       if (this.k != null) {
/* 365 */         this.k.draw(paramBatch);
/*     */       }
/*     */     }
/* 368 */     else if (this.k != null) {
/* 369 */       Game.i.shapeManager.F.CIRCLE.free((Shape)this.k);
/* 370 */       this.k = null;
/*     */     } 
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
/* 385 */     if (this.g > 0.0F) {
/* 386 */       float f = this.g / a();
/* 387 */       f = Game.i.towerManager.F.FREEZING.c.getRegionWidth() * f;
/* 388 */       paramBatch.draw(Game.i.towerManager.F.FREEZING.c, (getTile()).center.x - f * 0.5F, (getTile()).center.y - f * 0.5F, f, f);
/*     */     } 
/*     */     
/* 391 */     super.drawBatch(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public static class FreezingTowerFactory
/*     */     extends Tower.Factory<FreezingTower> {
/*     */     TextureRegion c;
/*     */     public TextureRegion monitoringTraceTexture;
/*     */     ParticleEffectPool d;
/*     */     
/*     */     public FreezingTowerFactory() {
/* 401 */       super("tower-freezing", TowerType.FREEZING);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 406 */       super.setup();
/*     */       
/* 408 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "", "" };
/* 409 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "", "" };
/* 410 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "" };
/* 411 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 412 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "" };
/*     */     }
/*     */ 
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 417 */       switch (FreezingTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 418 */           return 3;
/* 419 */         case 2: return 5;
/* 420 */         case 3: return 0;
/* 421 */         case 4: return 0;
/* 422 */         case 5: return 5; }
/* 423 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 431 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_FREEZING_A_EVAPORATION_DAMAGE), 2, true).toString();
/* 432 */       (arrayOfAbilityConfig[0]).descriptionArgs[1] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_FREEZING_A_EVAPORATION_STACK), false).toString();
/*     */       
/* 434 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FREEZING_A_SLOW_SPEED), 2, true).toString();
/* 435 */       (arrayOfAbilityConfig[1]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FREEZING_A_SLOW_PERCENT), 2, true).toString();
/*     */       
/* 437 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(15.0D, 1, true).toString();
/* 438 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FREEZING_A_MONITORING_XP), 2, true).toString();
/*     */       
/* 440 */       float f = FreezingTower.a((FreezingTower)param1Tower);
/* 441 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(2.5D, 1, true).toString();
/* 442 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(f, 1, true).toString();
/* 443 */       (arrayOfAbilityConfig[3]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_FREEZING_A_PER_SNOWBALL_PENALTY), 1, true).toString();
/*     */       
/* 445 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_FREEZING_A_ULTIMATE_SNOW_BONUS), 1, true).toString();
/*     */       
/* 447 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 453 */       if (param1Int == 1) {
/* 454 */         return false;
/*     */       }
/* 456 */       return true;
/*     */     }
/*     */     
/*     */     public boolean canKillEnemies() {
/* 460 */       return false;
/*     */     }
/*     */     
/*     */     public int getBuildHotKey() {
/* 464 */       return 46;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 468 */       return MaterialColor.BLUE.P500;
/*     */     }
/*     */     
/*     */     public void setupAssets() {
/* 472 */       this.monitoringTraceTexture = (TextureRegion)Game.i.assetManager.getTextureRegion("freezing-monitoring-trace");
/*     */ 
/*     */ 
/*     */       
/* 476 */       this.d = Game.i.assetManager.getParticleEffectPool("snowflakes.prt");
/*     */       
/* 478 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("unit-type-snowball");
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 483 */       return FreezingTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public FreezingTower create() {
/* 488 */       return new FreezingTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\FreezingTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */