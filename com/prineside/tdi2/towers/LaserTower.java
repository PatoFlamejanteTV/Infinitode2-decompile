/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.buffs.BonusCoinsBuff;
/*     */ import com.prineside.tdi2.buffs.BurnBuff;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.projectiles.LaserProjectile;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class LaserTower
/*     */   extends Tower
/*     */ {
/*  56 */   public static final String[] ABILITY_ALIASES = new String[] { "HIGH_FREQUENCY", "MIRRORS_SYSTEM", "LARGE_BATTERIES" };
/*     */   
/*     */   private float e;
/*     */   
/*     */   private boolean f;
/*     */   
/*     */   private float g;
/*     */   
/*     */   private int h;
/*     */   
/*     */   private float i;
/*     */   
/*     */   private int j;
/*  69 */   public FloatArray ultDamageBonuses = new FloatArray(false, 4);
/*  70 */   private DelayedRemovalArray<ActiveLaserConfig> k = new DelayedRemovalArray(ActiveLaserConfig.class);
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  74 */     super.write(paramKryo, paramOutput);
/*  75 */     paramOutput.writeFloat(this.e);
/*  76 */     paramOutput.writeBoolean(this.f);
/*  77 */     paramOutput.writeFloat(this.g);
/*  78 */     paramOutput.writeVarInt(this.h, true);
/*  79 */     paramOutput.writeFloat(this.i);
/*  80 */     paramOutput.writeVarInt(this.j, true);
/*  81 */     paramKryo.writeObject(paramOutput, this.ultDamageBonuses);
/*  82 */     paramKryo.writeObject(paramOutput, this.k);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  87 */     super.read(paramKryo, paramInput);
/*  88 */     this.e = paramInput.readFloat();
/*  89 */     this.f = paramInput.readBoolean();
/*  90 */     this.g = paramInput.readFloat();
/*  91 */     this.h = paramInput.readVarInt(true);
/*  92 */     this.i = paramInput.readFloat();
/*  93 */     this.j = paramInput.readVarInt(true);
/*  94 */     this.ultDamageBonuses = (FloatArray)paramKryo.readObject(paramInput, FloatArray.class);
/*  95 */     this.k = (DelayedRemovalArray<ActiveLaserConfig>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*     */   }
/*     */   
/*     */   private LaserTower() {
/*  99 */     super(TowerType.LASER);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/* 104 */     if (isAbilityInstalled(1)) {
/* 105 */       return Game.i.towerManager.F.LASER.getAbilityTextures(1);
/*     */     }
/* 107 */     return Game.i.towerManager.F.LASER.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/* 115 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAttackDelay() {
/* 125 */     if (this.f) return Float.MAX_VALUE;
/*     */     
/* 127 */     return 100.0F / getStat(TowerStatType.CHARGING_SPEED);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canAttack() {
/* 132 */     boolean bool = super.canAttack();
/*     */     
/* 134 */     if (this.f) return false; 
/* 135 */     if (isOutOfOrder()) return false;
/*     */     
/* 137 */     return (bool && this.e >= 100.0F);
/*     */   }
/*     */   
/*     */   public final float getUltDamageMultiplier() {
/* 141 */     if (isAbilityInstalled(4)) {
/* 142 */       float f = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_ULTIMATE_DAMAGE_BONUS);
/* 143 */       return this.ultDamageBonuses.size * f + 1.0F;
/*     */     } 
/* 145 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void onAbilitySet(int paramInt, boolean paramBoolean) {
/* 151 */     if (paramBoolean && paramInt == 2)
/*     */     {
/* 153 */       for (paramInt = 0; paramInt < this.k.size; paramInt++) {
/* 154 */         ActiveLaserConfig activeLaserConfig = (ActiveLaserConfig)this.k.get(paramInt);
/* 155 */         float f = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_LARGE_DURATION);
/* 156 */         f = activeLaserConfig.projectile.getDuration() * f - activeLaserConfig.projectile.getDuration();
/* 157 */         activeLaserConfig.durationLeft += f;
/* 158 */         activeLaserConfig.projectile.setDuration(activeLaserConfig.projectile.getDuration() + f);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void attack(int paramInt) {
/* 165 */     if (getTarget() == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 171 */     this.f = true;
/* 172 */     this.g = 0.0F;
/* 173 */     this.e = 0.0F;
/*     */     
/* 175 */     Vector2 vector21 = new Vector2();
/* 176 */     Vector2 vector22 = new Vector2();
/*     */     
/* 178 */     float f1 = getStat(TowerStatType.U_BATTERIES_CAPACITY);
/* 179 */     float f2 = getStat(TowerStatType.DAMAGE);
/*     */     
/* 181 */     if (isAbilityInstalled(1)) {
/*     */       int i;
/*     */       
/* 184 */       if ((i = this.S.gameValue.getIntValue(GameValueType.TOWER_LASER_A_MIRRORS_BEAM_COUNT)) <= 0) i = 1;
/*     */ 
/*     */       
/* 187 */       float f3, f4 = -(f3 = this.S.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_MIRRORS_BEAM_ANGLE)) * 0.5F;
/* 188 */       f3 /= (i - 1);
/*     */       
/* 190 */       if (i == 1) {
/* 191 */         f4 = 0.0F;
/*     */       }
/*     */       
/* 194 */       for (byte b = 0; b < i; b++) {
/* 195 */         LaserProjectile laserProjectile = (LaserProjectile)this.S.projectile.F.LASER.obtain();
/* 196 */         this.S.projectile.register((Projectile)laserProjectile);
/* 197 */         vector21.set(0.0F, 20.0F).rotateDeg(this.angle).add((getTile()).center);
/* 198 */         vector22.set(0.0F, 6144.0F).rotateDeg(this.angle + f4).add((getTile()).center);
/* 199 */         laserProjectile.setup(this, f1, f2, vector21.x, vector21.y, vector22.x, vector22.y, 1);
/*     */         
/*     */         ActiveLaserConfig activeLaserConfig;
/* 202 */         (activeLaserConfig = new ActiveLaserConfig()).startX = vector21.x;
/* 203 */         activeLaserConfig.startY = vector21.y;
/* 204 */         activeLaserConfig.endX = vector22.x;
/* 205 */         activeLaserConfig.endY = vector22.y;
/* 206 */         activeLaserConfig.baseDamage = f2;
/* 207 */         activeLaserConfig.projectile = laserProjectile;
/* 208 */         activeLaserConfig.durationLeft = f1;
/* 209 */         activeLaserConfig.angleDelta = f4;
/* 210 */         this.k.add(activeLaserConfig);
/*     */         
/* 212 */         f4 += f3;
/*     */       } 
/*     */     } else {
/* 215 */       LaserProjectile laserProjectile = (LaserProjectile)this.S.projectile.F.LASER.obtain();
/* 216 */       this.S.projectile.register((Projectile)laserProjectile);
/*     */       
/* 218 */       vector21.set(0.0F, 20.0F).rotateDeg(this.angle).add((getTile()).center);
/* 219 */       vector22.set(0.0F, 6144.0F).rotateDeg(this.angle).add((getTile()).center);
/*     */       
/* 221 */       laserProjectile.setup(this, f1, f2, vector21.x, vector21.y, vector22.x, vector22.y, 1);
/*     */       
/*     */       ActiveLaserConfig activeLaserConfig;
/* 224 */       (activeLaserConfig = new ActiveLaserConfig()).startX = vector21.x;
/* 225 */       activeLaserConfig.startY = vector21.y;
/* 226 */       activeLaserConfig.endX = vector22.x;
/* 227 */       activeLaserConfig.endY = vector22.y;
/* 228 */       activeLaserConfig.baseDamage = f2;
/* 229 */       activeLaserConfig.projectile = laserProjectile;
/* 230 */       activeLaserConfig.durationLeft = f1;
/* 231 */       activeLaserConfig.angleDelta = 0.0F;
/* 232 */       this.k.add(activeLaserConfig);
/*     */     } 
/*     */     
/* 235 */     this.shotCount++;
/*     */     
/* 237 */     if (this.S._sound != null) {
/* 238 */       this.S._sound.playShotSound(StaticSoundType.SHOT_LASER, this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 246 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 248 */     if (paramTowerStatType == TowerStatType.U_BATTERIES_CAPACITY && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_LARGE_DURATION)); 
/* 249 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_MIRRORS_DAMAGE)); 
/* 250 */     if (paramTowerStatType == TowerStatType.CHARGING_SPEED && isAbilityInstalled(3)) {
/* 251 */       f = (float)(f * (1.0D + this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_IONIZATION_SPEED) - this.h * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_IONIZATION_SPEED_REDUCTION)));
/*     */     }
/*     */     
/* 254 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void updateCache() {
/* 260 */     if (getTile() != null) {
/* 261 */       this.h = 0;
/*     */       
/* 263 */       this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */             PlatformTile platformTile;
/*     */             
/*     */             if (paramTile.type == TileType.PLATFORM && (platformTile = (PlatformTile)paramTile).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/*     */               this.h++;
/*     */             }
/*     */             
/*     */             return true;
/*     */           });
/*     */     } else {
/* 273 */       this.h = 0;
/*     */     } 
/*     */     
/* 276 */     super.updateCache();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 283 */     this.k.begin();
/* 284 */     float f1 = getStat(TowerStatType.U_BATTERIES_CAPACITY);
/* 285 */     float f2 = getStat(TowerStatType.DAMAGE);
/*     */     int i;
/* 287 */     for (i = 0; i < this.k.size; i++) {
/*     */       ActiveLaserConfig activeLaserConfig;
/* 289 */       (activeLaserConfig = ((ActiveLaserConfig[])this.k.items)[i]).durationLeft -= paramFloat;
/* 290 */       if (activeLaserConfig.durationLeft <= 0.0F) {
/* 291 */         if (isAbilityInstalled(0)) {
/*     */           
/* 293 */           int j = this.S.gameValue.getIntValue(GameValueType.TOWER_LASER_A_HIGH_ENEMY_COUNT);
/* 294 */           float f3 = this.S.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_HIGH_FIRE_DURATION);
/* 295 */           float f4 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_HIGH_DAMAGE) * f1 * f2;
/* 296 */           if (j <= 0) j = 1;
/*     */           
/* 298 */           int[] arrayOfInt = { 0 };
/* 299 */           j = j;
/* 300 */           float f5 = PMath.getAngleBetweenPoints(activeLaserConfig.startX, activeLaserConfig.startY, activeLaserConfig.endX, activeLaserConfig.endY);
/* 301 */           Vector2 vector2 = new Vector2();
/* 302 */           PMath.getPointByAngleFromPoint(activeLaserConfig.startX, activeLaserConfig.startY, f5, 8192.0F, vector2);
/* 303 */           this.S.map.rayCastEnemiesSorted(activeLaserConfig.startX, activeLaserConfig.startY, vector2.x, vector2.y, 5.0F, paramEnemyReference -> {
/*     */                 Enemy enemy;
/*     */                 
/*     */                 if ((enemy = paramEnemyReference.enemy) != null) {
/*     */                   if (canAttackEnemy(enemy)) {
/*     */                     BurnBuff burnBuff;
/*     */                     
/*     */                     (burnBuff = new BurnBuff()).setup(this, paramFloat1, paramFloat1 * 10.0F, paramFloat2, null);
/*     */                     
/*     */                     this.S.buff.P_BURN.addBuff(enemy, burnBuff);
/*     */                     if (isAbilityInstalled(3)) {
/*     */                       BonusCoinsBuff bonusCoinsBuff = new BonusCoinsBuff();
/*     */                       paramFloat2 = this.S.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_IONIZATION_COINS_DURATION);
/*     */                       float f = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_IONIZATION_COINS);
/*     */                       bonusCoinsBuff.setup(paramFloat2, paramFloat2 * 10.0F, f, this);
/*     */                       this.S.buff.P_BONUS_COINS.addBuff(enemy, bonusCoinsBuff);
/*     */                     } 
/*     */                   } 
/*     */                   paramArrayOfint[0] = paramArrayOfint[0] + 1;
/*     */                 } 
/*     */                 return (paramArrayOfint[0] != paramInt);
/*     */               });
/*     */         } 
/* 326 */         this.k.removeIndex(i);
/*     */       } else {
/* 328 */         activeLaserConfig.projectile.setDamage(activeLaserConfig.projectile.getDamage() + activeLaserConfig.baseDamage * paramFloat * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_DAMAGE_PER_SECOND_SHOOTING));
/*     */       } 
/*     */     } 
/* 331 */     this.k.end();
/*     */     
/* 333 */     this.g += paramFloat;
/* 334 */     if (this.f && this.g < f1) {
/*     */       
/* 336 */       if (isAbilityInstalled(2)) {
/* 337 */         float f3 = this.angle;
/* 338 */         float f4 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_LARGE_ROTATION_SPEED);
/* 339 */         a(paramFloat, getStat(TowerStatType.ROTATION_SPEED) * f4);
/* 340 */         if (f3 != this.angle)
/*     */         {
/* 342 */           for (byte b = 0; b < this.k.size; b++) {
/* 343 */             ActiveLaserConfig activeLaserConfig = ((ActiveLaserConfig[])this.k.items)[b];
/* 344 */             Vector2 vector21 = new Vector2();
/* 345 */             Vector2 vector22 = new Vector2();
/* 346 */             vector21.set(0.0F, 20.0F).rotateDeg(this.angle).add((getTile()).center);
/* 347 */             vector22.set(0.0F, 6144.0F).rotateDeg(this.angle + activeLaserConfig.angleDelta).add((getTile()).center);
/* 348 */             activeLaserConfig.projectile.setStartPos(vector21.x, vector21.y);
/* 349 */             activeLaserConfig.projectile.setEndPos(vector22.x, vector22.y);
/* 350 */             activeLaserConfig.startX = vector21.x;
/* 351 */             activeLaserConfig.startY = vector21.y;
/* 352 */             activeLaserConfig.endX = vector22.x;
/* 353 */             activeLaserConfig.endY = vector22.y;
/* 354 */             activeLaserConfig.projectile.handleCollisions(0.0F);
/*     */           
/*     */           }
/*     */ 
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 367 */       this.f = false;
/*     */       
/* 369 */       if (!isOutOfOrder()) {
/* 370 */         this.e += paramFloat * getStat(TowerStatType.CHARGING_SPEED);
/* 371 */         if (this.e > 100.0F) {
/* 372 */           this.e = 100.0F;
/*     */         }
/*     */         
/* 375 */         a(paramFloat, getStat(TowerStatType.ROTATION_SPEED));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 380 */     for (i = this.ultDamageBonuses.size - 1; i >= 0; i--) {
/* 381 */       this.ultDamageBonuses.items[i] = this.ultDamageBonuses.items[i] - paramFloat;
/* 382 */       if (this.ultDamageBonuses.items[i] <= 0.0F) {
/* 383 */         this.ultDamageBonuses.removeIndex(i);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 388 */     if (isAbilityInstalled(4)) {
/* 389 */       i = (int)this.S.statistics.getStatistic(StatisticsType.EK);
/* 390 */       float f = this.S.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_ULTIMATE_PASSIVE_INTERVAL);
/* 391 */       if (this.j != i) {
/* 392 */         this.i = 0.0F;
/* 393 */         this.j = i;
/*     */       } else {
/* 395 */         this.i += paramFloat;
/* 396 */         if (this.i > f) {
/* 397 */           this.i -= f;
/* 398 */           this.ultDamageBonuses.add(this.S.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_ULTIMATE_DURATION));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 403 */     super.update(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(StringBuilder paramStringBuilder) {
/* 408 */     paramStringBuilder.append("chargingPercent: ").append(this.e).append("\n");
/* 409 */     paramStringBuilder.append("isShooting: ").append(this.f).append("\n");
/* 410 */     paramStringBuilder.append("shootingTime: ").append(this.g).append("\n");
/* 411 */     paramStringBuilder.append("towersNearby: ").append(this.h).append("\n");
/* 412 */     paramStringBuilder.append("ultNoDeathsTimeAccumulator: ").append(this.i).append("\n");
/* 413 */     paramStringBuilder.append("ultNoDeathsLastEnemyKills: ").append(this.j).append("\n");
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillTowerMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/* 418 */     if (isAbilityInstalled(4)) {
/*     */ 
/*     */       
/* 421 */       if (paramObjectMap.size == 0 || !paramObjectMap.get("state", Integer.valueOf(-1)).equals(Integer.valueOf(1))) {
/*     */         
/* 423 */         paramGroup.clear();
/*     */         
/*     */         Image image1;
/* 426 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-damage"))).setPosition(40.0F, 0.0F);
/* 427 */         image1.setSize(48.0F, 48.0F);
/* 428 */         paramGroup.addActor((Actor)image1);
/*     */         
/*     */         Label label1;
/* 431 */         (label1 = new Label("", Game.i.assetManager.getLabelStyle(24))).setPosition(102.0F, 24.0F);
/* 432 */         label1.setSize(100.0F, 24.0F);
/* 433 */         paramGroup.addActor((Actor)label1);
/*     */         
/*     */         Label label2;
/* 436 */         (label2 = new Label(Game.i.localeManager.i18n.get("tower_ability_name_ultimate"), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 437 */         label2.setPosition(102.0F, 0.0F);
/* 438 */         label2.setSize(100.0F, 20.0F);
/* 439 */         paramGroup.addActor((Actor)label2);
/*     */         
/* 441 */         paramObjectMap.put("state", Integer.valueOf(1));
/* 442 */         paramObjectMap.put("damageIcon", image1);
/* 443 */         paramObjectMap.put("bonusLabel", label1);
/*     */       } 
/*     */ 
/*     */       
/* 447 */       Label label = (Label)paramObjectMap.get("bonusLabel");
/* 448 */       Image image = (Image)paramObjectMap.get("damageIcon");
/*     */       
/*     */       float f;
/* 451 */       if ((f = getUltDamageMultiplier()) == 1.0F) {
/* 452 */         label.setColor(MaterialColor.GREY.P500);
/* 453 */         image.setColor(MaterialColor.GREY.P500);
/*     */       } else {
/* 455 */         label.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 456 */         image.setColor(MaterialColor.LIGHT_GREEN.P500);
/*     */       } 
/* 458 */       d.setLength(0);
/* 459 */       d.append('+').append(Math.round((f - 1.0F) * 100.0F)).append('%');
/* 460 */       label.setText((CharSequence)d);
/*     */     } else {
/* 462 */       paramGroup.clear();
/*     */     } 
/*     */     
/* 465 */     super.fillTowerMenu(paramGroup, paramObjectMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 470 */     super.drawBatch(paramBatch, paramFloat);
/*     */     
/* 472 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_BUILDING_INFO) != 0.0D)
/* 473 */       Game.i.assetManager.getDebugFont(false).draw(paramBatch, (this.f ? "+" : "-") + " " + (int)this.e, (getTile()).center.x - 50.0F, (getTile()).center.y - 30.0F, 100.0F, 1, false); 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie
/*     */     extends SerializableListener<GameSystemProvider> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(GameSystemProvider param1GameSystemProvider) {
/* 482 */       this.a = param1GameSystemProvider;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       DamageRecord damageRecord;
/*     */       Tower tower;
/* 489 */       if (tower = (damageRecord = param1EnemyDie.getLastDamage()).getTower() instanceof LaserTower && tower.isAbilityInstalled(4)) {
/*     */         
/* 491 */         tower = tower;
/* 492 */         float f = ((GameSystemProvider)this.a).gameValue.getFloatValue(GameValueType.TOWER_LASER_A_ULTIMATE_DURATION);
/* 493 */         ((LaserTower)tower).ultDamageBonuses.add(f);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class LaserTowerFactory extends Tower.Factory<LaserTower> {
/*     */     public LaserTowerFactory() {
/* 500 */       super("tower-laser", TowerType.LASER);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 505 */       super.setup();
/*     */       
/* 507 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 508 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "", "" };
/* 509 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "" };
/* 510 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "", "", "", "" };
/* 511 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "", "", "" };
/*     */     }
/*     */ 
/*     */     
/*     */     public void configureSystems(GameSystemProvider param1GameSystemProvider) {
/* 516 */       param1GameSystemProvider.events.getListeners(EnemyDie.class).addStateAffecting(new LaserTower.OnEnemyDie(param1GameSystemProvider));
/*     */     }
/*     */     
/*     */     @Null
/*     */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/* 521 */       if (param1TowerStatType == TowerStatType.U_BATTERIES_CAPACITY) {
/* 522 */         String str = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameValueProvider.getFloatValue(GameValueType.TOWER_LASER_DAMAGE_PER_SECOND_SHOOTING), 1, true).toString();
/* 523 */         return Game.i.localeManager.i18n.format("tower_stat_more_info_LASER_U_BATTERIES_CAPACITY", new Object[] { str });
/*     */       } 
/* 525 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 533 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_LASER_A_HIGH_ENEMY_COUNT), false).toString();
/* 534 */       (arrayOfAbilityConfig[0]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_HIGH_FIRE_DURATION), 2, true).toString();
/* 535 */       (arrayOfAbilityConfig[0]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_HIGH_DAMAGE), 1, true).toString();
/* 536 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_LASER_A_MIRRORS_BEAM_COUNT), false).toString();
/* 537 */       (arrayOfAbilityConfig[1]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_MIRRORS_DAMAGE), 2, true).toString();
/* 538 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_LASER_A_LARGE_DURATION), 2, true).toString();
/* 539 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_LARGE_ROTATION_SPEED), 2, true).toString();
/* 540 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_IONIZATION_SPEED), 2, true).toString();
/* 541 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_IONIZATION_SPEED_REDUCTION), 2, true).toString();
/* 542 */       (arrayOfAbilityConfig[3]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_IONIZATION_COINS), 2, true).toString();
/* 543 */       (arrayOfAbilityConfig[3]).descriptionArgs[3] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_IONIZATION_COINS_DURATION), 2, true).toString();
/* 544 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_ULTIMATE_DAMAGE_BONUS), 2, true).toString();
/* 545 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_ULTIMATE_DURATION), 2, true).toString();
/* 546 */       (arrayOfAbilityConfig[4]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_LASER_A_ULTIMATE_PASSIVE_INTERVAL), 2, true).toString();
/*     */       
/* 548 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 554 */       if (param1Int == 1) {
/* 555 */         return false;
/*     */       }
/* 557 */       return true;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 561 */       return MaterialColor.LIGHT_BLUE.P500;
/*     */     }
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 565 */       switch (LaserTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 566 */           return 5;
/* 567 */         case 2: return 1;
/* 568 */         case 3: return 5;
/* 569 */         case 4: return 3;
/* 570 */         case 5: return 1; }
/* 571 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 577 */       return LaserTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 582 */       return 53;
/*     */     }
/*     */ 
/*     */     
/*     */     public LaserTower create() {
/* 587 */       return new LaserTower((byte)0);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class ActiveLaserConfig
/*     */     implements KryoSerializable {
/*     */     public LaserProjectile projectile;
/*     */     public float durationLeft;
/*     */     public float angleDelta;
/*     */     public float baseDamage;
/*     */     public float startX;
/*     */     public float startY;
/*     */     public float endX;
/*     */     public float endY;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 604 */       param1Kryo.writeObject(param1Output, this.projectile);
/* 605 */       param1Output.writeFloat(this.durationLeft);
/* 606 */       param1Output.writeFloat(this.angleDelta);
/* 607 */       param1Output.writeFloat(this.baseDamage);
/* 608 */       param1Output.writeFloat(this.startX);
/* 609 */       param1Output.writeFloat(this.startY);
/* 610 */       param1Output.writeFloat(this.endX);
/* 611 */       param1Output.writeFloat(this.endY);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 616 */       this.projectile = (LaserProjectile)param1Kryo.readObject(param1Input, LaserProjectile.class);
/* 617 */       this.durationLeft = param1Input.readFloat();
/* 618 */       this.angleDelta = param1Input.readFloat();
/* 619 */       this.baseDamage = param1Input.readFloat();
/* 620 */       this.startX = param1Input.readFloat();
/* 621 */       this.startY = param1Input.readFloat();
/* 622 */       this.endX = param1Input.readFloat();
/* 623 */       this.endY = param1Input.readFloat();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\LaserTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */