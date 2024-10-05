/*     */ package com.prineside.tdi2.towers;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.buffs.BurnBuff;
/*     */ import com.prineside.tdi2.buffs.PoisonBuff;
/*     */ import com.prineside.tdi2.buffs.VulnerabilityBuff;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.enums.UnitType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.shapes.BulletSmokeMultiLine;
/*     */ import com.prineside.tdi2.shapes.PieChart;
/*     */ import com.prineside.tdi2.shapes.RangeCircle;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.PieChartActor;
/*     */ import com.prineside.tdi2.units.MicrogunUnit;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class MinigunTower extends Tower {
/*     */   static {
/*  61 */     TLog.forClass(MinigunTower.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   public static final String[] ABILITY_ALIASES = new String[] { "HEAVY_WEAPONS", "HEAVY_MECHANISM", "FOUNDATION" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  75 */   public static Color muzzleFlashColor = Color.WHITE.cpy();
/*     */   @NAGS
/*  77 */   private Color e = Color.WHITE.cpy();
/*     */   
/*     */   @NAGS
/*     */   private float f;
/*     */   
/*     */   @NAGS
/*     */   private float g;
/*     */   private byte h;
/*     */   private float i;
/*     */   private float j;
/*     */   private int k;
/*     */   private int l;
/*     */   private float m;
/*     */   private float n;
/*     */   private float o;
/*     */   private float p;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  95 */     super.write(paramKryo, paramOutput);
/*  96 */     paramOutput.writeByte(this.h);
/*  97 */     paramOutput.writeFloat(this.i);
/*  98 */     paramOutput.writeFloat(this.j);
/*  99 */     paramOutput.writeVarInt(this.k, true);
/* 100 */     paramOutput.writeVarInt(this.l, true);
/* 101 */     paramOutput.writeFloat(this.m);
/* 102 */     paramOutput.writeFloat(this.n);
/* 103 */     paramOutput.writeFloat(this.o);
/* 104 */     paramOutput.writeFloat(this.p);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 109 */     super.read(paramKryo, paramInput);
/* 110 */     this.h = paramInput.readByte();
/* 111 */     this.i = paramInput.readFloat();
/* 112 */     this.j = paramInput.readFloat();
/* 113 */     this.k = paramInput.readVarInt(true);
/* 114 */     this.l = paramInput.readVarInt(true);
/* 115 */     this.m = paramInput.readFloat();
/* 116 */     this.n = paramInput.readFloat();
/* 117 */     this.o = paramInput.readFloat();
/* 118 */     this.p = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private MinigunTower() {
/* 122 */     super(TowerType.MINIGUN);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/* 127 */     if (isAbilityInstalled(0)) {
/* 128 */       return Game.i.towerManager.F.MINIGUN.getAbilityTextures(0);
/*     */     }
/* 130 */     return Game.i.towerManager.F.MINIGUN.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/* 138 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 143 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAttackDelay() {
/*     */     float f;
/* 149 */     if ((f = this.i / this.n) == 0.0F) return Float.MAX_VALUE;
/*     */     
/* 151 */     return 1.0F / f * getStat(TowerStatType.ATTACK_SPEED);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getBulletsInMagazine() {
/* 158 */     return this.l;
/*     */   }
/*     */   
/*     */   public final void setBulletsInMagazine(int paramInt) {
/* 162 */     this.l = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMagazineSize() {
/* 169 */     return MathUtils.round(getStat(TowerStatType.U_MAGAZINE_SIZE));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getReloadDuration() {
/* 176 */     return this.S.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_RELOAD_DURATION);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getTimeSinceLastAttack() {
/* 183 */     return this.j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getTimeSinceReloadStart() {
/* 190 */     return this.m;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(StringBuilder paramStringBuilder) {
/* 195 */     paramStringBuilder.append("framesSinceTargetLost: ").append(this.h).append("\n");
/* 196 */     paramStringBuilder.append("speedingUpTime: ").append(this.i).append("\n");
/* 197 */     paramStringBuilder.append("timeSinceLastAttack: ").append(this.j).append("\n");
/* 198 */     paramStringBuilder.append("shotCount: ").append(this.k).append("\n");
/* 199 */     paramStringBuilder.append("bulletsInMagazine: ").append(this.l).append("\n");
/* 200 */     paramStringBuilder.append("magazineSize: ").append(getMagazineSize()).append("\n");
/* 201 */     paramStringBuilder.append("timeSinceReloadStart: ").append(this.m).append("\n");
/* 202 */     paramStringBuilder.append("speedUpRequiredTime: ").append(this.n).append("\n");
/* 203 */     paramStringBuilder.append("timeSinceMicrogunPlaced: ").append(this.o).append("\n");
/* 204 */     paramStringBuilder.append("timeSinceSpecialHandled: ").append(this.p).append("\n");
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canAttack() {
/*     */     Enemy enemy;
/* 210 */     if ((enemy = getTarget()) != null && !this.attackDisabled) {
/* 211 */       float f = PMath.getAngleBetweenPoints((getTile()).center, enemy.getPosition());
/*     */       
/* 213 */       return ((f = StrictMath.abs(PMath.getDistanceBetweenAngles(this.angle, f))) < this.S.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_KEEP_SHOOTING_ANGLE));
/*     */     } 
/* 215 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void attack(int paramInt) {
/*     */     Enemy enemy;
/* 222 */     if ((enemy = getTarget()) == null) {
/*     */       return;
/*     */     }
/* 225 */     if (this.l <= 0) {
/*     */       return;
/*     */     }
/* 228 */     if (paramInt > this.l) {
/* 229 */       paramInt = this.l;
/*     */     }
/* 231 */     this.l -= paramInt;
/*     */     
/* 233 */     this.j = 0.0F;
/*     */     
/* 235 */     if (this.S._particle != null) {
/*     */       Vector2 vector21;
/* 237 */       (vector21 = new Vector2()).set((getTile()).center);
/* 238 */       PMath.shiftPointByAngle(vector21, this.angle, 45.0F);
/* 239 */       this.S._particle.addFlashParticle((TextureRegion)(AssetManager.TextureRegions.i()).muzzleFlashSmall, vector21.x, vector21.y, 12.0F, 4.5F, 24.0F, 36.0F, this.angle);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 244 */     float f1 = this.S.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_BULLET_SPREAD) * this.i / this.n;
/* 245 */     f1 = this.angle + (this.S.gameState.randomFloat() - 0.5F) * f1;
/* 246 */     float f2 = this.rangeInPixels;
/* 247 */     Vector2 vector2 = new Vector2();
/* 248 */     PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, f1, f2, vector2);
/*     */     
/* 250 */     Enemy[] arrayOfEnemy = { null };
/* 251 */     this.S.map.rayCastEnemiesSorted((getTile()).center.x, (getTile()).center.y, vector2.x, vector2.y, 0.0F, paramEnemyReference -> {
/*     */           Enemy enemy = paramEnemyReference.enemy;
/*     */           
/*     */           if (canAttackEnemy(enemy)) {
/*     */             paramArrayOfEnemy[0] = enemy;
/*     */             return false;
/*     */           } 
/*     */           return true;
/*     */         });
/* 260 */     if (arrayOfEnemy[0] != null) {
/*     */       
/* 262 */       f2 = PMath.getDistanceBetweenPoints((getTile()).center, arrayOfEnemy[0].getPosition());
/* 263 */       PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, f1, f2, vector2);
/*     */     } 
/*     */ 
/*     */     
/* 267 */     if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled() && (
/* 268 */       PMath.getDistanceBetweenAngles(this.f, this.angle) > 2.0F || this.g > 0.05F)) {
/*     */       
/* 270 */       this.f = this.angle;
/* 271 */       this.g = 0.0F;
/*     */       
/* 273 */       BulletSmokeMultiLine bulletSmokeMultiLine = (BulletSmokeMultiLine)Game.i.shapeManager.F.BULLET_SMOKE_MULTI_LINE.obtain();
/* 274 */       Vector2 vector21 = new Vector2();
/* 275 */       PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, this.angle, 30.0F, vector21);
/* 276 */       bulletSmokeMultiLine.setTexture(Game.i.towerManager.F.MINIGUN.bulletTraceTexture, false, (FastRandom.getFloat() < 0.5F));
/* 277 */       if (this.i >= this.n && isAbilityInstalled(3)) {
/* 278 */         if (isAbilityInstalled(2)) {
/* 279 */           bulletSmokeMultiLine.setColor(MaterialColor.LIGHT_GREEN.P500);
/*     */         } else {
/* 281 */           bulletSmokeMultiLine.setColor(MaterialColor.DEEP_ORANGE.P500);
/*     */         } 
/*     */       } else {
/* 284 */         bulletSmokeMultiLine.setColor(MaterialColor.PURPLE.P200);
/*     */       } 
/* 286 */       bulletSmokeMultiLine.maxSegmentWidth = 32.0F;
/* 287 */       bulletSmokeMultiLine.nodesDisperseTime = 0.7F;
/* 288 */       bulletSmokeMultiLine.maxAlpha = 0.56F;
/* 289 */       bulletSmokeMultiLine.setup(vector21.x, vector21.y, vector2.x, vector2.y);
/* 290 */       this.S._projectileTrail.addTrail((ProjectileTrail)bulletSmokeMultiLine);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 295 */     if (this.p > 0.2F) {
/* 296 */       this.p = 0.0F;
/*     */       
/* 298 */       if (arrayOfEnemy[0] != null && isAbilityInstalled(3) && this.i >= this.n * 0.9F) {
/* 299 */         f1 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HOT_DAMAGE);
/* 300 */         if (isAbilityInstalled(2)) {
/* 301 */           f1 += (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_FOUNDATION_SPECIAL_BONUS);
/*     */         }
/* 303 */         f2 = getStat(TowerStatType.ATTACK_SPEED) * getStat(TowerStatType.DAMAGE) * f1;
/* 304 */         f1 = this.S.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_A_HOT_DURATION);
/* 305 */         if (isAbilityInstalled(2)) {
/*     */           PoisonBuff poisonBuff;
/*     */           
/* 308 */           (poisonBuff = new PoisonBuff()).setup(this, f1, f1 * 10.0F, f2, f2, null);
/* 309 */           this.S.buff.P_POISON.addBuff(arrayOfEnemy[0], poisonBuff);
/*     */         } else {
/*     */           BurnBuff burnBuff;
/*     */           
/* 313 */           (burnBuff = new BurnBuff()).setup(this, f1, f1 * 10.0F, f2, null);
/* 314 */           this.S.buff.P_BURN.addBuff(arrayOfEnemy[0], burnBuff);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 319 */     if (arrayOfEnemy[0] != null) {
/* 320 */       this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(arrayOfEnemy[0], getStat(TowerStatType.DAMAGE) * paramInt, DamageType.BULLET).setTower(this));
/*     */       
/* 322 */       if (isAbilityInstalled(0)) {
/* 323 */         f1 = a();
/*     */         VulnerabilityBuff vulnerabilityBuff;
/* 325 */         (vulnerabilityBuff = new VulnerabilityBuff()).setup(this.id, f1, 2.0F, 20.0F);
/* 326 */         this.S.buff.P_VULNERABILITY.addBuff(arrayOfEnemy[0], vulnerabilityBuff);
/*     */       } 
/*     */     } 
/*     */     
/* 330 */     this.k += paramInt;
/*     */     
/* 332 */     if (this.S._sound != null) {
/* 333 */       this.S._sound.playShotSound(StaticSoundType.SHOT_MINIGUN, this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 341 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 343 */     if (paramTowerStatType == TowerStatType.U_ACCELERATION && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HEAVY_MECH_ACCELERATION)); 
/* 344 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HEAVY_WEAPONS_DAMAGE)); 
/* 345 */     if (paramTowerStatType == TowerStatType.ATTACK_SPEED && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HEAVY_MECH_SPEED)); 
/* 346 */     if (paramTowerStatType == TowerStatType.ROTATION_SPEED && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_FOUNDATION_ROTATION)); 
/* 347 */     if (paramTowerStatType == TowerStatType.U_MAGAZINE_SIZE && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HEAVY_MECH_MAGAZINE));
/*     */     
/* 349 */     return f;
/*     */   }
/*     */   
/*     */   private float a() {
/* 353 */     float f1 = getUpgradeLevel() / 10.0F;
/* 354 */     float f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HEAVY_WEAPONS_VULNERABILITY_MIN);
/* 355 */     float f3 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HEAVY_WEAPONS_VULNERABILITY_MAX);
/*     */     
/* 357 */     return f2 + (f3 - f2) * f1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateCache() {
/* 362 */     super.updateCache();
/*     */     
/* 364 */     this.n = 1.0F / getStat(TowerStatType.U_ACCELERATION) * 100.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 372 */     boolean bool1 = canAttack();
/* 373 */     boolean bool2 = isOutOfOrder();
/*     */ 
/*     */     
/* 376 */     if ((bool1 = (bool1 && !bool2 && this.l > 0)) || this.h < 6) {
/*     */       
/* 378 */       this.i += paramFloat;
/* 379 */       if (this.i > this.n) {
/* 380 */         this.i = this.n;
/*     */       }
/*     */     } else {
/*     */       
/* 384 */       this.i -= paramFloat * 2.0F;
/* 385 */       if (this.i < 0.0F) {
/* 386 */         this.i = 0.0F;
/*     */       }
/*     */     } 
/*     */     
/* 390 */     if (bool1) {
/* 391 */       this.h = 0;
/* 392 */     } else if (this.h < 6) {
/* 393 */       this.h = (byte)(this.h + 1);
/*     */     } 
/*     */     
/* 396 */     if (bool2) {
/* 397 */       super.update(paramFloat);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 402 */     float f = getReloadDuration();
/* 403 */     if (this.l == 0) {
/*     */       
/* 405 */       this.m += paramFloat;
/* 406 */       if (this.m >= f) {
/*     */         
/* 408 */         this.l = getMagazineSize();
/* 409 */         this.m = 0.0F;
/*     */       } 
/*     */     } else {
/*     */       
/* 413 */       this.m = 0.0F;
/* 414 */       if (this.l < getMagazineSize() && 
/* 415 */         this.j > f)
/*     */       {
/* 417 */         this.l = getMagazineSize();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 422 */     a(paramFloat, getStat(TowerStatType.ROTATION_SPEED));
/*     */ 
/*     */     
/* 425 */     this.j += paramFloat;
/* 426 */     this.g += paramFloat;
/* 427 */     this.p += paramFloat;
/*     */     
/* 429 */     if (isAbilityInstalled(4)) {
/* 430 */       int i = this.S.gameValue.getIntValue(GameValueType.TOWER_MINIGUN_A_MICROGUN_COUNT);
/* 431 */       float f1 = this.S.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_A_MICROGUN_BUILD_DELAY);
/*     */       
/* 433 */       this.o += paramFloat;
/* 434 */       if (this.o > f1) {
/*     */         
/* 436 */         this.o = 0.0F;
/*     */ 
/*     */         
/* 439 */         byte b1 = 0;
/* 440 */         for (byte b2 = 0; b2 < this.S.map.spawnedUnits.size; b2++) {
/*     */           MicrogunUnit microgunUnit; Unit unit;
/* 442 */           if ((unit = ((Unit[])this.S.map.spawnedUnits.items)[b2]).type == UnitType.MICROGUN && 
/*     */             
/* 444 */             (microgunUnit = (MicrogunUnit)unit).parent == this) {
/* 445 */             b1++;
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 452 */         if (b1 < i) {
/*     */           
/* 454 */           Array array = this.S.TSH.getTileArray();
/*     */           
/* 456 */           boolean[] arrayOfBoolean = { false };
/* 457 */           this.S.tower.traverseTilesInRange(this, paramTile -> {
/*     */                 if (paramTile.type == TileType.ROAD || paramTile.type == TileType.PLATFORM) {
/*     */                   boolean bool = false;
/*     */                   
/*     */                   if (paramTile.type == TileType.PLATFORM && ((PlatformTile)paramTile).building != null) {
/*     */                     bool = true;
/*     */                   } else if (paramTile.enemyCount != 0) {
/*     */                     bool = true;
/*     */                   } else {
/*     */                     DelayedRemovalArray delayedRemovalArray = this.S.map.spawnedUnits;
/*     */                     
/*     */                     for (byte b = 0; b < delayedRemovalArray.size; b++) {
/*     */                       Unit unit;
/*     */                       
/*     */                       if ((unit = ((Unit[])delayedRemovalArray.items)[b]).type == UnitType.MICROGUN && PMath.getSquareDistanceBetweenPoints(paramTile.center.x, paramTile.center.y, unit.position.x, unit.position.y) < 64.0F) {
/*     */                         bool = true;
/*     */                         
/*     */                         break;
/*     */                       } 
/*     */                     } 
/*     */                   } 
/*     */                   
/*     */                   if (!bool) {
/*     */                     if (paramTile.type == TileType.PLATFORM) {
/*     */                       paramArrayOfboolean[0] = true;
/*     */                     }
/*     */                     paramArray.add(paramTile);
/*     */                   } 
/*     */                 } 
/*     */                 return true;
/*     */               });
/* 488 */           if (array.size != 0) {
/* 489 */             if (arrayOfBoolean[0])
/*     */             {
/* 491 */               for (int j = array.size - 1; j >= 0; j--) {
/* 492 */                 if ((((Tile[])array.items)[j]).type == TileType.ROAD) {
/* 493 */                   array.removeIndex(j);
/*     */                 }
/*     */               } 
/*     */             }
/*     */             
/* 498 */             Tile tile = ((Tile[])array.items)[this.S.gameState.randomInt(array.size)];
/*     */             
/*     */             MicrogunUnit microgunUnit;
/* 501 */             (microgunUnit = Game.i.unitManager.F.MICROGUN.create()).setup(this, tile.center.x, tile.center.y);
/* 502 */             this.S.unit.register((Unit)microgunUnit);
/* 503 */             this.S.map.spawnUnit((Unit)microgunUnit);
/*     */             
/* 505 */             if (this.S._sound != null) {
/* 506 */               this.S._sound.playStatic(StaticSoundType.BUILDING_BUILT);
/*     */             }
/*     */             
/* 509 */             if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */               ParticleEffectPool.PooledEffect pooledEffect;
/* 511 */               (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.unitManager.F.MICROGUN.highlightParticles.obtain()).setPosition(tile.center.x, tile.center.y);
/* 512 */               this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */             } 
/*     */           } 
/*     */           
/* 516 */           this.S.TSH.freeTileArray(array);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 522 */     super.update(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 527 */     super.drawBatch(paramBatch, paramFloat);
/*     */     
/* 529 */     if ((getTile()).visibleOnScreen)
/*     */     {
/* 531 */       if (this.i != 0.0F) {
/* 532 */         Quad quad; this.e.a = this.i / this.n;
/* 533 */         paramBatch.setColor(this.e);
/*     */ 
/*     */         
/* 536 */         if (isAbilityInstalled(0)) {
/* 537 */           quad = Game.i.towerManager.F.MINIGUN.d;
/*     */         } else {
/* 539 */           quad = Game.i.towerManager.F.MINIGUN.c;
/*     */         } 
/* 541 */         quad.draw(paramBatch, (getTile()).boundingBox.minX, (getTile()).boundingBox.minY, 64.0F, 64.0F, 128.0F, 128.0F, 1.0F, 1.0F, this.angle);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 546 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_BUILDING_INFO) != 0.0D) {
/*     */       BitmapFont bitmapFont;
/* 548 */       (bitmapFont = Game.i.assetManager.getDebugFont(false)).draw(paramBatch, "S: " + StringFormatter.compactNumberWithPrecision((this.i / this.n), 2), (getTile()).boundingBox.minX, (getTile()).boundingBox.minY - 20.0F + 64.0F, 128.0F, 1, false);
/* 549 */       bitmapFont.setColor(Color.WHITE);
/*     */     } 
/*     */     
/* 552 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawSelectedRange(Batch paramBatch, RangeCircle paramRangeCircle) {
/* 557 */     super.drawSelectedRange(paramBatch, paramRangeCircle);
/*     */ 
/*     */     
/* 560 */     Array array = MinigunTowerFactory.a(Game.i.towerManager.F.MINIGUN);
/*     */     
/* 562 */     for (byte b = 0; b < this.S.map.spawnedUnits.size; b++) {
/*     */       Unit unit; MicrogunUnit microgunUnit;
/* 564 */       if ((unit = ((Unit[])this.S.map.spawnedUnits.items)[b]).type == UnitType.MICROGUN && 
/*     */         
/* 566 */         (microgunUnit = (MicrogunUnit)unit).parent == this) {
/*     */         RangeCircle rangeCircle;
/* 568 */         if (array.size <= 0) {
/* 569 */           rangeCircle = (RangeCircle)Game.i.shapeManager.F.RANGE_CIRCLE.obtain();
/* 570 */           array.add(rangeCircle);
/*     */         } else {
/* 572 */           rangeCircle = ((RangeCircle[])array.items)[0];
/*     */         } 
/*     */         
/* 575 */         microgunUnit.drawRange(paramBatch, rangeCircle);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fillTowerMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/* 585 */     if (paramObjectMap.size == 0 || !paramObjectMap.get("state", Integer.valueOf(-1)).equals(Integer.valueOf(1))) {
/*     */       
/* 587 */       paramGroup.clear();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 592 */       PieChartActor pieChartActor3 = new PieChartActor();
/*     */       Array array3;
/* 594 */       (array3 = new Array(PieChart.ChartEntryConfig.class)).add(new PieChart.ChartEntryConfig(MaterialColor.AMBER.P500, 20.0F, 0.0F));
/*     */ 
/*     */ 
/*     */       
/* 598 */       array3.add(new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.28F), 30.0F, 0.0F));
/*     */ 
/*     */ 
/*     */       
/* 602 */       pieChartActor3.setPosition(40.0F, 0.0F);
/* 603 */       pieChartActor3.setSize(64.0F, 64.0F);
/* 604 */       pieChartActor3.setSegmentCount(200);
/* 605 */       pieChartActor3.setConfigs(array3);
/* 606 */       paramGroup.addActor((Actor)pieChartActor3);
/*     */       
/*     */       Image image1;
/* 609 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("circle"))).setColor(new Color(724249599));
/* 610 */       image1.setSize(36.0F, 36.0F);
/* 611 */       image1.setPosition(54.0F, 14.0F);
/* 612 */       paramGroup.addActor((Actor)image1);
/*     */       
/*     */       Image image2;
/* 615 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-aim-time"))).setSize(28.0F, 28.0F);
/* 616 */       image2.setPosition(58.0F, 18.0F);
/* 617 */       paramGroup.addActor((Actor)image2);
/*     */       
/*     */       Label label6;
/* 620 */       (label6 = new Label("", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.ORANGE.P500);
/* 621 */       label6.setPosition(120.0F, 38.0F);
/* 622 */       label6.setSize(100.0F, 18.0F);
/* 623 */       paramGroup.addActor((Actor)label6);
/*     */       
/*     */       Label label4;
/* 626 */       (label4 = new Label(Game.i.localeManager.i18n.get("tower_stat_U_ACCELERATION"), Game.i.assetManager.getLabelStyle(21))).setColor(new Color(1.0F, 1.0F, 1.0F, 0.56F));
/* 627 */       label4.setPosition(120.0F, 12.0F);
/* 628 */       label4.setSize(100.0F, 16.0F);
/* 629 */       paramGroup.addActor((Actor)label4);
/*     */ 
/*     */       
/* 632 */       PieChartActor pieChartActor4 = new PieChartActor();
/*     */       Array array4;
/* 634 */       (array4 = new Array(PieChart.ChartEntryConfig.class)).add(new PieChart.ChartEntryConfig(MaterialColor.PURPLE.P700, 20.0F, 0.0F));
/*     */ 
/*     */ 
/*     */       
/* 638 */       array4.add(new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.28F), 30.0F, 0.0F));
/*     */ 
/*     */ 
/*     */       
/* 642 */       pieChartActor4.setPosition(296.0F, -6.0F);
/* 643 */       pieChartActor4.setSize(76.0F, 76.0F);
/* 644 */       pieChartActor4.setSegmentCount(200);
/* 645 */       pieChartActor4.setConfigs(array4);
/* 646 */       paramGroup.addActor((Actor)pieChartActor4);
/*     */ 
/*     */       
/* 649 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("circle"))).setColor(new Color(724249599));
/* 650 */       image1.setSize(68.0F, 68.0F);
/* 651 */       image1.setPosition(300.0F, -2.0F);
/* 652 */       paramGroup.addActor((Actor)image1);
/*     */       
/* 654 */       PieChartActor pieChartActor5 = new PieChartActor();
/*     */       
/* 656 */       (array4 = new Array(PieChart.ChartEntryConfig.class)).add(new PieChart.ChartEntryConfig(MaterialColor.PURPLE.P500, 20.0F, 0.0F));
/*     */ 
/*     */ 
/*     */       
/* 660 */       array4.add(new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.28F), 30.0F, 0.0F));
/*     */ 
/*     */ 
/*     */       
/* 664 */       pieChartActor5.setPosition(302.0F, 0.0F);
/* 665 */       pieChartActor5.setSize(64.0F, 64.0F);
/* 666 */       pieChartActor5.setSegmentCount(200);
/* 667 */       pieChartActor5.setConfigs(array4);
/* 668 */       paramGroup.addActor((Actor)pieChartActor5);
/*     */ 
/*     */       
/* 671 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("circle"))).setColor(new Color(724249599));
/* 672 */       image1.setSize(36.0F, 36.0F);
/* 673 */       image1.setPosition(316.0F, 14.0F);
/* 674 */       paramGroup.addActor((Actor)image1);
/*     */       
/*     */       Image image3;
/* 677 */       (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-bullet-wall"))).setSize(28.0F, 28.0F);
/* 678 */       image3.setPosition(320.0F, 18.0F);
/* 679 */       paramGroup.addActor((Actor)image3);
/*     */ 
/*     */       
/* 682 */       (label4 = new Label("", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.PURPLE.P400);
/* 683 */       label4.setPosition(382.0F, 38.0F);
/* 684 */       label4.setSize(100.0F, 18.0F);
/* 685 */       paramGroup.addActor((Actor)label4);
/*     */       
/*     */       Label label5;
/* 688 */       (label5 = new Label("", Game.i.assetManager.getLabelStyle(21))).setColor(new Color(1.0F, 1.0F, 1.0F, 0.56F));
/* 689 */       label5.setPosition(382.0F, 12.0F);
/* 690 */       label5.setSize(100.0F, 16.0F);
/* 691 */       paramGroup.addActor((Actor)label5);
/*     */       
/* 693 */       paramObjectMap.put("speedUpChart", pieChartActor3);
/* 694 */       paramObjectMap.put("magazineReloadChart", pieChartActor4);
/* 695 */       paramObjectMap.put("magazineChart", pieChartActor5);
/* 696 */       paramObjectMap.put("accelerationTitle", label6);
/* 697 */       paramObjectMap.put("magazineTitle", label4);
/* 698 */       paramObjectMap.put("magazineReloadingDescription", label5);
/*     */       
/* 700 */       paramObjectMap.put("state", Integer.valueOf(1));
/*     */     } 
/*     */ 
/*     */     
/* 704 */     float f = this.i / this.n;
/* 705 */     Label label1 = (Label)paramObjectMap.get("accelerationTitle");
/* 706 */     Label label2 = (Label)paramObjectMap.get("magazineTitle");
/* 707 */     Label label3 = (Label)paramObjectMap.get("magazineReloadingDescription");
/*     */     
/*     */     PieChartActor pieChartActor2;
/*     */     Array array1;
/* 711 */     ((PieChart.ChartEntryConfig)(array1 = (pieChartActor2 = (PieChartActor)paramObjectMap.get("speedUpChart")).getConfigs()).get(0)).setValue(f);
/* 712 */     if (f >= 0.9F) {
/* 713 */       ((PieChart.ChartEntryConfig)array1.get(0)).color = MaterialColor.RED.P500;
/*     */     } else {
/* 715 */       ((PieChart.ChartEntryConfig)array1.get(0)).color = MaterialColor.AMBER.P500;
/*     */     } 
/* 717 */     if (f > 1.0F) f = 1.0F; 
/* 718 */     ((PieChart.ChartEntryConfig)array1.get(1)).setValue(1.0F - f);
/* 719 */     pieChartActor2.setConfigs(array1);
/*     */     
/* 721 */     if (f >= 0.9F) {
/* 722 */       label1.setColor(MaterialColor.RED.P500);
/*     */     } else {
/* 724 */       label1.setColor(MaterialColor.AMBER.P500);
/*     */     } 
/* 726 */     d.setLength(0);
/* 727 */     d.append(MathUtils.round(f * 100.0F));
/* 728 */     d.append("%");
/* 729 */     label1.setText((CharSequence)d);
/*     */ 
/*     */     
/* 732 */     PieChartActor pieChartActor1 = (PieChartActor)paramObjectMap.get("magazineChart");
/* 733 */     pieChartActor2 = (PieChartActor)paramObjectMap.get("magazineReloadChart");
/* 734 */     array1 = pieChartActor1.getConfigs();
/* 735 */     Array array2 = pieChartActor2.getConfigs();
/* 736 */     if (getBulletsInMagazine() == 0) {
/*     */       float f1;
/*     */       
/* 739 */       if ((f1 = this.m / getReloadDuration()) > 1.0F) {
/* 740 */         f1 = 1.0F;
/*     */       }
/* 742 */       ((PieChart.ChartEntryConfig)array2.get(0)).setValue(f1);
/* 743 */       ((PieChart.ChartEntryConfig)array2.get(0)).color = MaterialColor.PURPLE.P500;
/* 744 */       ((PieChart.ChartEntryConfig)array2.get(1)).setValue(1.0F - f1);
/*     */       
/* 746 */       ((PieChart.ChartEntryConfig)array1.get(0)).setValue(0.0F);
/* 747 */       ((PieChart.ChartEntryConfig)array1.get(1)).setValue(1.0F);
/* 748 */       label3.setText(Game.i.localeManager.i18n.get("ammo_reloading_status_hint"));
/*     */     } else {
/*     */       float f1;
/*     */       
/* 752 */       if ((f1 = getBulletsInMagazine() / getMagazineSize()) > 1.0F) {
/* 753 */         f1 = 1.0F;
/*     */       }
/* 755 */       ((PieChart.ChartEntryConfig)array1.get(0)).setValue(f1);
/* 756 */       ((PieChart.ChartEntryConfig)array1.get(1)).setValue(1.0F - f1);
/*     */ 
/*     */ 
/*     */       
/* 760 */       float f2 = MathUtils.clamp(f2 = ((f2 = (f1 < 1.0F) ? (this.j / getReloadDuration()) : 0.0F) - 0.05F) / 0.95F, 0.0F, 1.0F);
/*     */       
/* 762 */       ((PieChart.ChartEntryConfig)array2.get(0)).setValue(f2);
/* 763 */       ((PieChart.ChartEntryConfig)array2.get(0)).color = MaterialColor.PURPLE.P700;
/* 764 */       ((PieChart.ChartEntryConfig)array2.get(1)).setValue(1.0F - f2);
/* 765 */       label3.setText(Game.i.localeManager.i18n.get("bullets_in_magazine_status_hint"));
/*     */     } 
/* 767 */     pieChartActor2.setConfigs(array2);
/* 768 */     pieChartActor1.setConfigs(array1);
/*     */     
/* 770 */     d.setLength(0);
/* 771 */     d.append(getBulletsInMagazine()).append(" / ").append(getMagazineSize());
/* 772 */     label2.setText((CharSequence)d);
/*     */     
/* 774 */     super.fillTowerMenu(paramGroup, paramObjectMap);
/*     */   }
/*     */   
/*     */   public static class MinigunTowerFactory
/*     */     extends Tower.Factory<MinigunTower> {
/*     */     public TextureRegion bulletTraceTexture;
/*     */     Quad c;
/*     */     Quad d;
/* 782 */     private Array<RangeCircle> e = new Array(RangeCircle.class);
/*     */     
/*     */     public MinigunTowerFactory() {
/* 785 */       super("tower-minigun", TowerType.MINIGUN);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 790 */       super.setup();
/*     */       
/* 792 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 793 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 794 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "" };
/* 795 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "", "" };
/* 796 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "", "", "", "" };
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 801 */       this.bulletTraceTexture = (TextureRegion)Game.i.assetManager.getTextureRegion("bullet-trace-smoke");
/*     */       
/* 803 */       this.c = Game.i.assetManager.getQuad("towers." + TowerType.MINIGUN.name() + ".weaponHeat");
/* 804 */       this.d = Game.i.assetManager.getQuad("towers." + TowerType.MINIGUN.name() + ".weaponHeatHeavy");
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 808 */       return MaterialColor.PURPLE.P500;
/*     */     } @Null
/*     */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/*     */       String str;
/* 812 */       if (param1TowerStatType == TowerStatType.U_ACCELERATION) {
/* 813 */         str = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameValueProvider.getFloatValue(GameValueType.TOWER_MINIGUN_BULLET_SPREAD), 1, true).toString();
/* 814 */         return Game.i.localeManager.i18n.format("tower_stat_more_info_MINIGUN_U_ACCELERATION", new Object[] { str });
/* 815 */       }  if (str == TowerStatType.U_MAGAZINE_SIZE) {
/* 816 */         str = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameValueProvider.getFloatValue(GameValueType.TOWER_MINIGUN_RELOAD_DURATION), 1, true).toString();
/* 817 */         return Game.i.localeManager.i18n.format("tower_stat_more_info_MINIGUN_U_MAGAZINE_SIZE", new Object[] { str });
/*     */       } 
/* 819 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 827 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HEAVY_WEAPONS_DAMAGE), 2, true).toString();
/* 828 */       (arrayOfAbilityConfig[0]).descriptionArgs[1] = "+" + StringFormatter.compactNumberWithPrecisionTrimZeros((MinigunTower.a((MinigunTower)param1Tower) * 100.0F - 100.0F), 2, true).toString();
/* 829 */       (arrayOfAbilityConfig[0]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(2.0D, 2, true).toString();
/* 830 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HEAVY_MECH_ACCELERATION), 2, true).toString();
/* 831 */       (arrayOfAbilityConfig[1]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HEAVY_MECH_SPEED), 2, true).toString();
/* 832 */       (arrayOfAbilityConfig[1]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_HEAVY_MECH_MAGAZINE), 2, true).toString();
/* 833 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_FOUNDATION_ROTATION), 2, true).toString();
/* 834 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_A_FOUNDATION_SPECIAL_BONUS), 2, true).toString();
/* 835 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_A_HOT_DURATION), 2, true).toString();
/*     */       
/* 837 */       float f = param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_A_HOT_DAMAGE);
/* 838 */       if (param1Tower.isAbilityInstalled(2)) {
/* 839 */         f += param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_A_FOUNDATION_SPECIAL_BONUS);
/*     */       }
/* 841 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(f, 2, true).toString();
/* 842 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_A_MICROGUN_BUILD_DELAY), 2, true).toString();
/* 843 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_A_MICROGUN_ATTACK_SPEED), 2, true).toString();
/* 844 */       (arrayOfAbilityConfig[4]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MINIGUN_A_MICROGUN_RANGE), 2, true).toString();
/* 845 */       (arrayOfAbilityConfig[4]).descriptionArgs[3] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_MINIGUN_A_MICROGUN_COUNT), false).toString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 851 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 857 */       if (param1Int == 0) {
/* 858 */         return false;
/*     */       }
/* 860 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 865 */       switch (MinigunTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 866 */           return 4;
/* 867 */         case 2: return 5;
/* 868 */         case 3: return 4;
/* 869 */         case 4: return 1;
/* 870 */         case 5: return 2; }
/* 871 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 877 */       return 54;
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 882 */       return MinigunTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public MinigunTower create() {
/* 887 */       return new MinigunTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\MinigunTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */