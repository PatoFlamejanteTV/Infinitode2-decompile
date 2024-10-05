/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.buffs.BurnBuff;
/*     */ import com.prineside.tdi2.buffs.FreezingBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.SpecialDamageType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.utils.DrawUtils;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class FlamethrowerTower
/*     */   extends Tower {
/*  46 */   private static final TLog e = TLog.forClass(FlamethrowerTower.class);
/*     */   
/*  48 */   private static final float[] f = new float[] { 1.0F, 0.6F, 0.1F };
/*  49 */   private static final float[] g = new float[] { 0.1F, 0.6F, 1.0F };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   public static final String[] ABILITY_ALIASES = new String[] { "PLASMA_IGNITION", "NAPALM", "COLD_FIRE" };
/*     */   
/*     */   private boolean h = false;
/*     */   
/*     */   private boolean i;
/*     */   
/*     */   public int instaKillPapersAccumulator;
/*     */   
/*     */   private boolean j;
/*     */   
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte k;
/*     */   
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte l;
/*     */   
/*     */   private float m;
/*     */   
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect n;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  77 */     super.write(paramKryo, paramOutput);
/*  78 */     paramOutput.writeBoolean(this.h);
/*  79 */     paramOutput.writeBoolean(this.i);
/*  80 */     paramOutput.writeVarInt(this.instaKillPapersAccumulator, true);
/*  81 */     paramOutput.writeBoolean(this.j);
/*  82 */     paramOutput.writeByte(this.k);
/*  83 */     paramOutput.writeByte(this.l);
/*  84 */     paramOutput.writeFloat(this.m);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  89 */     super.read(paramKryo, paramInput);
/*  90 */     this.h = paramInput.readBoolean();
/*  91 */     this.i = paramInput.readBoolean();
/*  92 */     this.instaKillPapersAccumulator = paramInput.readVarInt(true);
/*  93 */     this.j = paramInput.readBoolean();
/*  94 */     this.k = paramInput.readByte();
/*  95 */     this.l = paramInput.readByte();
/*  96 */     this.m = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private FlamethrowerTower() {
/* 100 */     super(TowerType.FLAMETHROWER);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/* 105 */     if (isAbilityInstalled(0)) {
/* 106 */       return Game.i.towerManager.F.FLAMETHROWER.getAbilityTextures(0);
/*     */     }
/* 108 */     return Game.i.towerManager.F.FLAMETHROWER.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final float a() {
/* 115 */     float f1 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_INSTAKILL_HP_MIN);
/* 116 */     float f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_INSTAKILL_HP_MAX);
/* 117 */     float f3 = getUpgradeLevel() / 10.0F;
/*     */     
/* 119 */     return f1 + (f2 - f1) * f3;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/* 124 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAttackDelay() {
/* 134 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canAttack() {
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 146 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 148 */     if (paramTowerStatType == TowerStatType.U_DIRECT_FIRE_DAMAGE && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_PLASMA_DAMAGE)); 
/* 149 */     if (paramTowerStatType == TowerStatType.U_DIRECT_FIRE_DAMAGE && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_NAPALM_DIRECT_DAMAGE)); 
/* 150 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_COLD_DAMAGE)); 
/* 151 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_NAPALM_DAMAGE)); 
/* 152 */     if (paramTowerStatType == TowerStatType.U_BURNING_TIME && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_NAPALM_DURATION)); 
/* 153 */     if (paramTowerStatType == TowerStatType.RANGE && isAbilityInstalled(3)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_SUPPLY_RANGE));
/*     */     
/* 155 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateCache() {
/* 160 */     super.updateCache();
/*     */     
/* 162 */     this.m = 20.0F;
/* 163 */     if (isAbilityInstalled(3)) {
/* 164 */       this.m = (float)(this.m * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_SUPPLY_ARC));
/*     */     }
/*     */ 
/*     */     
/* 168 */     if (this.n != null) {
/* 169 */       this.n.allowCompletion();
/* 170 */       this.n = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Array<Enemy> paramArray) {
/* 177 */     Vector2 vector21 = (getTile()).center;
/* 178 */     Vector2 vector22 = new Vector2();
/* 179 */     this.S.map.getEnemiesInCircleFiltered(vector21.x, vector21.y, this.rangeInPixels, (paramFloat1, paramFloat2, paramFloat3) -> {
/*     */           float f = PMath.getAngleBetweenPoints(paramVector21.x, paramVector21.y, paramFloat1, paramFloat2);
/*     */           if (StrictMath.abs(PMath.getDistanceBetweenAngles(this.angle, f)) < this.m) {
/*     */             if (StrictMath.abs(PMath.getDistanceBetweenAngles(this.angle, f)) < this.m * 0.5F) {
/*     */               return true;
/*     */             }
/*     */             PMath.getPointByAngleFromPoint(paramFloat1, paramFloat2, f - 90.0F, paramFloat3, paramVector22);
/*     */             float f1 = PMath.getAngleBetweenPoints(paramVector21, paramVector22);
/*     */             if (StrictMath.abs(PMath.getDistanceBetweenAngles(this.angle, f1)) < this.m * 0.5F) {
/*     */               return true;
/*     */             }
/*     */             PMath.getPointByAngleFromPoint(paramFloat1, paramFloat2, f + 90.0F, paramFloat3, paramVector22);
/*     */             f1 = PMath.getAngleBetweenPoints(paramVector21, paramVector22);
/*     */             return (StrictMath.abs(PMath.getDistanceBetweenAngles(this.angle, f1)) < this.m * 0.5F);
/*     */           } 
/*     */           return false;
/*     */         }(paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */           Enemy enemy;
/*     */           if ((enemy = paramEnemyReference.enemy) == null) {
/*     */             return true;
/*     */           }
/*     */           if (!canAttackEnemy(enemy)) {
/*     */             return true;
/*     */           }
/*     */           paramArray.add(paramEnemyReference.enemy);
/*     */           return true;
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Array<Enemy> paramArray1, Array<Enemy> paramArray2) {
/* 216 */     if (paramArray1.size != 0) {
/* 217 */       float f1 = this.angle - this.m * 0.5F;
/* 218 */       float f2 = this.angle + this.m * 0.5F;
/* 219 */       f1 += 360.0F;
/* 220 */       f2 += 360.0F;
/*     */ 
/*     */       
/* 223 */       Vector2 vector2 = (getTile()).center;
/* 224 */       this.S.TSH.sort.sort(paramArray1, (paramEnemy1, paramEnemy2) -> Float.compare(paramEnemy1.getPosition().dst2(paramVector2), paramEnemy2.getPosition().dst2(paramVector2)));
/*     */ 
/*     */       
/* 227 */       Array array = new Array(true, 1, Vector2.class);
/*     */       
/* 229 */       for (byte b = 0; b < paramArray1.size; b++) {
/* 230 */         Enemy enemy = ((Enemy[])paramArray1.items)[b];
/* 231 */         float f3 = PMath.getAngleBetweenPoints(vector2, enemy.getPosition());
/*     */         
/* 233 */         Vector2 vector21 = new Vector2();
/* 234 */         PMath.getPointByAngleFromPoint((enemy.getPosition()).x, (enemy.getPosition()).y, f3 - 90.0F, enemy.getSize(), vector21);
/*     */         
/* 236 */         Vector2 vector22 = new Vector2();
/* 237 */         PMath.getPointByAngleFromPoint((enemy.getPosition()).x, (enemy.getPosition()).y, f3 + 90.0F, enemy.getSize(), vector22);
/*     */         
/* 239 */         f3 = PMath.getAngleBetweenPoints(vector2, vector21);
/* 240 */         float f4 = PMath.getAngleBetweenPoints(vector2, vector22);
/*     */         
/* 242 */         f3 += 360.0F;
/* 243 */         f4 += 360.0F;
/*     */ 
/*     */         
/* 246 */         float f5 = Math.max(f1, f3);
/* 247 */         float f6 = Math.min(f2, f4);
/*     */         
/* 249 */         boolean bool = false;
/* 250 */         for (byte b1 = 0; b1 < array.size; b1++) {
/*     */           Vector2 vector23;
/* 252 */           float f8 = (vector23 = ((Vector2[])array.items)[b1]).x;
/* 253 */           float f7 = vector23.y;
/* 254 */           if (f8 <= f5 && f7 >= f6) {
/* 255 */             bool = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 260 */         if (!bool) {
/*     */           
/* 262 */           array.add(new Vector2(f3, f4));
/* 263 */           paramArray2.add(enemy);
/*     */         } 
/*     */       } 
/*     */       
/* 267 */       array.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(float paramFloat) {
/* 273 */     this.h = false;
/*     */     
/* 275 */     float f1 = -1.0F;
/* 276 */     if (isAbilityInstalled(4)) {
/* 277 */       f1 = a();
/*     */     }
/*     */     
/* 280 */     float f2 = getStat(TowerStatType.DAMAGE) * paramFloat;
/* 281 */     boolean bool = isAbilityInstalled(2);
/* 282 */     float f3 = getStat(TowerStatType.U_DIRECT_FIRE_DAMAGE) * 0.01F;
/*     */     
/* 284 */     f1 = f1;
/* 285 */     Array<Enemy> array1 = this.S.TSH.getEnemyArray();
/* 286 */     a(array1);
/* 287 */     Array<Enemy> array2 = this.S.TSH.getEnemyArray();
/* 288 */     if (isAbilityInstalled(2)) {
/*     */       
/* 290 */       array2.addAll(array1);
/*     */     } else {
/* 292 */       a(array1, array2);
/*     */     } 
/* 294 */     this.S.TSH.freeEnemyArray(array1);
/*     */     
/* 296 */     this.h = (array2.size != 0);
/* 297 */     if (this.h)
/* 298 */       for (byte b = 0; b < array2.size; b++) {
/*     */         Enemy enemy;
/* 300 */         if ((enemy = ((Enemy[])array2.items)[b]).isRegistered()) {
/*     */           
/* 302 */           float f = f2 * f3;
/*     */           
/* 304 */           if (enemy.isVulnerableToSpecial(SpecialDamageType.INSTAKILL) && enemy.getHealth() / enemy.maxHealth < f1) {
/*     */             float f4;
/*     */             
/* 307 */             if ((f4 = enemy.getBuffedDamageMultiplier(TowerType.FLAMETHROWER, DamageType.FIRE)) > 0.0F) {
/* 308 */               this.S.damage.queueDamage(this.S.damage
/* 309 */                   .obtainRecord().setup(enemy, enemy.getHealth() + 1.0F, DamageType.FIRE)
/* 310 */                   .setTower(this)
/* 311 */                   .setCleanForDps(false)
/* 312 */                   .setLethal(true)
/* 313 */                   .setEfficiency(8)
/* 314 */                   .setIgnoreTowerEfficiency(true));
/*     */             }
/*     */           } else {
/*     */             
/* 318 */             float f4 = getStat(TowerStatType.U_BURNING_TIME);
/* 319 */             if (bool) {
/*     */               
/* 321 */               float f5 = this.S.gameValue.getFloatValue(GameValueType.TOWER_FLAMETHROWER_A_COLD_FREEZING);
/* 322 */               if (isAbilityInstalled(1)) {
/* 323 */                 f5 += this.S.gameValue.getFloatValue(GameValueType.TOWER_FLAMETHROWER_A_NAPALM_FREEZING);
/*     */               }
/*     */               
/* 326 */               boolean bool1 = false;
/*     */               DelayedRemovalArray delayedRemovalArray;
/* 328 */               if ((delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.FREEZING)) != null && delayedRemovalArray.size != 0) {
/* 329 */                 for (byte b1 = 0; b1 < delayedRemovalArray.size; b1++) {
/*     */                   FreezingBuff freezingBuff;
/* 331 */                   if ((freezingBuff = (FreezingBuff)delayedRemovalArray.get(b1)).tower == this) {
/* 332 */                     freezingBuff.speed = 10.0F;
/* 333 */                     freezingBuff.maxPercent = f5;
/* 334 */                     freezingBuff.duration = f4;
/* 335 */                     freezingBuff.maxDuration = f4 * 10.0F;
/* 336 */                     bool1 = true;
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               }
/* 341 */               if (!bool1) {
/*     */                 FreezingBuff freezingBuff;
/* 343 */                 (freezingBuff = new FreezingBuff()).setup(this, 10.0F, f5, f4, f4 * 10.0F, 0.0F, 0.0F);
/* 344 */                 this.S.buff.P_FREEZING.addBuff(enemy, freezingBuff);
/*     */               } 
/*     */ 
/*     */               
/* 348 */               if (enemy.hasBuffsByType(BuffType.BURN)) {
/* 349 */                 float f6 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_COLD_DAMAGE_TO_BURNING);
/* 350 */                 if (isAbilityInstalled(1)) {
/* 351 */                   f6 = (float)(f6 + this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_NAPALM_COLD_FIRE_DMG));
/*     */                 }
/* 353 */                 f *= f6 + 1.0F;
/*     */               } 
/*     */             } else {
/*     */               
/* 357 */               float f5 = this.S.gameValue.getFloatValue(GameValueType.TOWER_FLAMETHROWER_TIME_TO_IGNITE);
/* 358 */               enemy.ignitionProgress += paramFloat / f5;
/* 359 */               enemy.ignitionIncreasedLastFrame = this.S.gameState.updateNumber;
/* 360 */               if (enemy.ignitionProgress >= 1.0F) {
/* 361 */                 enemy.ignitionProgress = 1.0F;
/*     */                 BurnBuff burnBuff;
/* 363 */                 (burnBuff = new BurnBuff()).setup(this, f4, f4 * 10.0F, getStat(TowerStatType.DAMAGE), null);
/* 364 */                 if (isAbilityInstalled(4)) {
/* 365 */                   burnBuff.bonusDamagePerEnemyNearby = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_ULTIMATE_CROWD_BONUS);
/*     */                 }
/* 367 */                 this.S.buff.P_BURN.addBuff(enemy, burnBuff);
/*     */               } 
/*     */             } 
/*     */             
/* 371 */             if (f > 0.0F) {
/* 372 */               this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, f, DamageType.FIRE).setTower(this).setEfficiency(4));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }  
/* 377 */     this.S.TSH.freeEnemyArray(array2);
/*     */     
/* 379 */     if (!this.i && this.h) {
/*     */       
/* 381 */       this.shotCount++;
/*     */       
/* 383 */       if (this.S._sound != null) {
/* 384 */         this.S._sound.playShotSound(StaticSoundType.SHOT_FLAMETHROWER, this);
/*     */       }
/*     */     } 
/*     */     
/* 388 */     this.i = this.h;
/* 389 */     if (this.h) {
/* 390 */       this.c = 0.0F;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAimStrategy(Tower.AimStrategy paramAimStrategy) {
/* 396 */     super.setAimStrategy(paramAimStrategy);
/*     */     
/* 398 */     this.j = true;
/*     */     
/* 400 */     b();
/*     */   }
/*     */   
/*     */   private void b() {
/* 404 */     if (this.n != null) {
/* 405 */       this.n.allowCompletion();
/* 406 */       this.n = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c() {
/* 411 */     Array array = this.n.getEmitters();
/* 412 */     float f = getRange() * 2.0F * 0.75F;
/*     */     
/*     */     ParticleEmitter particleEmitter2;
/* 415 */     (particleEmitter2 = (ParticleEmitter)array.get(0)).getXScale().setHigh(48.0F * f);
/* 416 */     particleEmitter2.getYScale().setHigh(48.0F * f);
/* 417 */     particleEmitter2.getXScale().setLow(4.0F * f);
/* 418 */     particleEmitter2.getYScale().setLow(4.0F * f);
/*     */     
/*     */     ParticleEmitter particleEmitter1;
/* 421 */     (particleEmitter1 = (ParticleEmitter)array.get(1)).getXScale().setHigh(20.0F * f);
/* 422 */     particleEmitter1.getYScale().setHigh(20.0F * f);
/* 423 */     particleEmitter1.getXScale().setLow(3.0F * f);
/* 424 */     particleEmitter1.getYScale().setLow(3.0F * f);
/*     */     
/* 426 */     particleEmitter2.getVelocity().setHigh(170.0F * f, 230.0F * f);
/* 427 */     particleEmitter2.getVelocity().setLow(60.0F * f);
/* 428 */     particleEmitter1.getVelocity().setHigh(120.0F * f, 150.0F * f);
/*     */     
/* 430 */     if (isAbilityInstalled(2)) {
/* 431 */       particleEmitter2.getTint().setColors(g); return;
/*     */     } 
/* 433 */     particleEmitter2.getTint().setColors(f);
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
/*     */   public final void update(float paramFloat) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: fload_1
/*     */     //   2: invokespecial update : (F)V
/*     */     //   5: aload_0
/*     */     //   6: invokevirtual isOutOfOrder : ()Z
/*     */     //   9: ifeq -> 17
/*     */     //   12: aload_0
/*     */     //   13: invokespecial b : ()V
/*     */     //   16: return
/*     */     //   17: aload_0
/*     */     //   18: fload_1
/*     */     //   19: aload_0
/*     */     //   20: getstatic com/prineside/tdi2/enums/TowerStatType.ROTATION_SPEED : Lcom/prineside/tdi2/enums/TowerStatType;
/*     */     //   23: invokevirtual getStat : (Lcom/prineside/tdi2/enums/TowerStatType;)F
/*     */     //   26: invokevirtual a : (FF)V
/*     */     //   29: aload_0
/*     */     //   30: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*     */     //   33: getfield _particle : Lcom/prineside/tdi2/systems/ParticleSystem;
/*     */     //   36: ifnull -> 80
/*     */     //   39: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*     */     //   42: getfield settingsManager : Lcom/prineside/tdi2/managers/SettingsManager;
/*     */     //   45: invokevirtual isParticlesDrawing : ()Z
/*     */     //   48: ifeq -> 80
/*     */     //   51: aload_0
/*     */     //   52: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*     */     //   55: getfield _particle : Lcom/prineside/tdi2/systems/ParticleSystem;
/*     */     //   58: invokevirtual willParticleBeSkipped : ()Z
/*     */     //   61: ifne -> 80
/*     */     //   64: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*     */     //   67: getfield settingsManager : Lcom/prineside/tdi2/managers/SettingsManager;
/*     */     //   70: invokevirtual isProjectilesDrawing : ()Z
/*     */     //   73: ifeq -> 80
/*     */     //   76: iconst_1
/*     */     //   77: goto -> 81
/*     */     //   80: iconst_0
/*     */     //   81: dup
/*     */     //   82: istore_2
/*     */     //   83: ifne -> 90
/*     */     //   86: aload_0
/*     */     //   87: invokespecial b : ()V
/*     */     //   90: aload_0
/*     */     //   91: dup
/*     */     //   92: getfield l : B
/*     */     //   95: iconst_1
/*     */     //   96: iadd
/*     */     //   97: i2b
/*     */     //   98: putfield l : B
/*     */     //   101: aload_0
/*     */     //   102: getfield l : B
/*     */     //   105: iconst_5
/*     */     //   106: if_icmpne -> 224
/*     */     //   109: aload_0
/*     */     //   110: iconst_0
/*     */     //   111: putfield l : B
/*     */     //   114: aload_0
/*     */     //   115: getfield j : Z
/*     */     //   118: ifeq -> 129
/*     */     //   121: aload_0
/*     */     //   122: iconst_0
/*     */     //   123: putfield j : Z
/*     */     //   126: goto -> 220
/*     */     //   129: aload_0
/*     */     //   130: fload_1
/*     */     //   131: ldc 5.0
/*     */     //   133: fmul
/*     */     //   134: invokespecial a : (F)V
/*     */     //   137: aload_0
/*     */     //   138: getfield h : Z
/*     */     //   141: ifeq -> 220
/*     */     //   144: aload_0
/*     */     //   145: invokevirtual isOutOfOrder : ()Z
/*     */     //   148: ifne -> 220
/*     */     //   151: aload_0
/*     */     //   152: getfield n : Lcom/badlogic/gdx/graphics/g2d/ParticleEffectPool$PooledEffect;
/*     */     //   155: ifnonnull -> 224
/*     */     //   158: aload_0
/*     */     //   159: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*     */     //   162: getfield _particle : Lcom/prineside/tdi2/systems/ParticleSystem;
/*     */     //   165: ifnull -> 224
/*     */     //   168: iload_2
/*     */     //   169: ifeq -> 224
/*     */     //   172: aload_0
/*     */     //   173: getstatic com/prineside/tdi2/Game.i : Lcom/prineside/tdi2/Game;
/*     */     //   176: getfield towerManager : Lcom/prineside/tdi2/managers/TowerManager;
/*     */     //   179: getfield F : Lcom/prineside/tdi2/managers/TowerManager$Factories;
/*     */     //   182: getfield FLAMETHROWER : Lcom/prineside/tdi2/towers/FlamethrowerTower$FlamethrowerTowerFactory;
/*     */     //   185: getfield c : Lcom/badlogic/gdx/graphics/g2d/ParticleEffectPool;
/*     */     //   188: invokevirtual obtain : ()Ljava/lang/Object;
/*     */     //   191: checkcast com/badlogic/gdx/graphics/g2d/ParticleEffectPool$PooledEffect
/*     */     //   194: putfield n : Lcom/badlogic/gdx/graphics/g2d/ParticleEffectPool$PooledEffect;
/*     */     //   197: aload_0
/*     */     //   198: invokespecial c : ()V
/*     */     //   201: aload_0
/*     */     //   202: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*     */     //   205: getfield _particle : Lcom/prineside/tdi2/systems/ParticleSystem;
/*     */     //   208: aload_0
/*     */     //   209: getfield n : Lcom/badlogic/gdx/graphics/g2d/ParticleEffectPool$PooledEffect;
/*     */     //   212: iconst_1
/*     */     //   213: invokevirtual addParticle : (Lcom/badlogic/gdx/graphics/g2d/ParticleEffect;Z)Z
/*     */     //   216: pop
/*     */     //   217: goto -> 224
/*     */     //   220: aload_0
/*     */     //   221: invokespecial b : ()V
/*     */     //   224: aload_0
/*     */     //   225: getfield a : B
/*     */     //   228: ifeq -> 264
/*     */     //   231: aload_0
/*     */     //   232: dup
/*     */     //   233: getfield k : B
/*     */     //   236: iconst_1
/*     */     //   237: iadd
/*     */     //   238: i2b
/*     */     //   239: putfield k : B
/*     */     //   242: aload_0
/*     */     //   243: getfield k : B
/*     */     //   246: bipush #15
/*     */     //   248: if_icmpne -> 264
/*     */     //   251: aload_0
/*     */     //   252: iconst_0
/*     */     //   253: putfield k : B
/*     */     //   256: aload_0
/*     */     //   257: dup
/*     */     //   258: invokevirtual findTarget : ()Lcom/prineside/tdi2/Enemy;
/*     */     //   261: invokevirtual setTarget : (Lcom/prineside/tdi2/Enemy;)V
/*     */     //   264: aload_0
/*     */     //   265: getfield n : Lcom/badlogic/gdx/graphics/g2d/ParticleEffectPool$PooledEffect;
/*     */     //   268: ifnull -> 386
/*     */     //   271: new com/badlogic/gdx/math/Vector2
/*     */     //   274: dup
/*     */     //   275: ldc 42.0
/*     */     //   277: fconst_0
/*     */     //   278: invokespecial <init> : (FF)V
/*     */     //   281: aload_0
/*     */     //   282: getfield angle : F
/*     */     //   285: ldc 90.0
/*     */     //   287: fadd
/*     */     //   288: invokevirtual rotateDeg : (F)Lcom/badlogic/gdx/math/Vector2;
/*     */     //   291: aload_0
/*     */     //   292: invokevirtual getTile : ()Lcom/prineside/tdi2/tiles/PlatformTile;
/*     */     //   295: getfield center : Lcom/badlogic/gdx/math/Vector2;
/*     */     //   298: invokevirtual add : (Lcom/badlogic/gdx/math/Vector2;)Lcom/badlogic/gdx/math/Vector2;
/*     */     //   301: astore_1
/*     */     //   302: aload_0
/*     */     //   303: getfield n : Lcom/badlogic/gdx/graphics/g2d/ParticleEffectPool$PooledEffect;
/*     */     //   306: aload_1
/*     */     //   307: getfield x : F
/*     */     //   310: aload_1
/*     */     //   311: getfield y : F
/*     */     //   314: invokevirtual setPosition : (FF)V
/*     */     //   317: aload_0
/*     */     //   318: getfield n : Lcom/badlogic/gdx/graphics/g2d/ParticleEffectPool$PooledEffect;
/*     */     //   321: invokevirtual getEmitters : ()Lcom/badlogic/gdx/utils/Array;
/*     */     //   324: astore_1
/*     */     //   325: iconst_0
/*     */     //   326: istore_2
/*     */     //   327: iload_2
/*     */     //   328: aload_1
/*     */     //   329: getfield size : I
/*     */     //   332: if_icmpge -> 386
/*     */     //   335: aload_1
/*     */     //   336: iload_2
/*     */     //   337: invokevirtual get : (I)Ljava/lang/Object;
/*     */     //   340: checkcast com/badlogic/gdx/graphics/g2d/ParticleEmitter
/*     */     //   343: invokevirtual getAngle : ()Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$ScaledNumericValue;
/*     */     //   346: aload_0
/*     */     //   347: getfield m : F
/*     */     //   350: fneg
/*     */     //   351: ldc 0.5
/*     */     //   353: fmul
/*     */     //   354: aload_0
/*     */     //   355: getfield angle : F
/*     */     //   358: fadd
/*     */     //   359: ldc 90.0
/*     */     //   361: fadd
/*     */     //   362: aload_0
/*     */     //   363: getfield m : F
/*     */     //   366: ldc 0.5
/*     */     //   368: fmul
/*     */     //   369: aload_0
/*     */     //   370: getfield angle : F
/*     */     //   373: fadd
/*     */     //   374: ldc 90.0
/*     */     //   376: fadd
/*     */     //   377: invokevirtual setHigh : (FF)V
/*     */     //   380: iinc #2, 1
/*     */     //   383: goto -> 327
/*     */     //   386: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #439	-> 0
/*     */     //   #441	-> 5
/*     */     //   #442	-> 12
/*     */     //   #443	-> 16
/*     */     //   #445	-> 17
/*     */     //   #448	-> 29
/*     */     //   #451	-> 39
/*     */     //   #454	-> 82
/*     */     //   #455	-> 86
/*     */     //   #459	-> 90
/*     */     //   #460	-> 101
/*     */     //   #461	-> 109
/*     */     //   #462	-> 114
/*     */     //   #463	-> 121
/*     */     //   #464	-> 126
/*     */     //   #466	-> 129
/*     */     //   #468	-> 137
/*     */     //   #470	-> 151
/*     */     //   #472	-> 172
/*     */     //   #473	-> 197
/*     */     //   #474	-> 201
/*     */     //   #478	-> 220
/*     */     //   #484	-> 224
/*     */     //   #485	-> 231
/*     */     //   #486	-> 242
/*     */     //   #487	-> 251
/*     */     //   #488	-> 256
/*     */     //   #492	-> 264
/*     */     //   #494	-> 271
/*     */     //   #495	-> 302
/*     */     //   #497	-> 317
/*     */     //   #498	-> 325
/*     */     //   #499	-> 335
/*     */     //   #498	-> 380
/*     */     //   #502	-> 386
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
/*     */   public final void removedFromMap() {
/* 506 */     super.removedFromMap();
/* 507 */     b();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 512 */     super.drawBatch(paramBatch, paramFloat);
/*     */     
/* 514 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_BUILDING_INFO) != 0.0D && this.S.map.aabbGenerated()) {
/* 515 */       paramFloat = this.angle - this.m * 0.5F;
/* 516 */       float f = this.angle + this.m * 0.5F;
/* 517 */       paramFloat += 360.0F;
/* 518 */       f += 360.0F;
/*     */       
/* 520 */       Game.i.assetManager.getSmallDebugFont().setColor(MaterialColor.CYAN.P300);
/*     */       
/* 522 */       Vector2 vector2 = new Vector2();
/* 523 */       PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, paramFloat, this.rangeInPixels, vector2);
/* 524 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), (getTile()).center.x, (getTile()).center.y, vector2.x, vector2.y, 2.0F, MaterialColor.CYAN.P900.toFloatBits(), MaterialColor.CYAN.P900.toFloatBits());
/* 525 */       Game.i.assetManager.getSmallDebugFont().draw(paramBatch, (int)paramFloat + "deg", vector2.x, vector2.y, 1.0F, 1, false);
/*     */       
/* 527 */       PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, f, this.rangeInPixels, vector2);
/* 528 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), (getTile()).center.x, (getTile()).center.y, vector2.x, vector2.y, 2.0F, MaterialColor.CYAN.P900.toFloatBits(), MaterialColor.CYAN.P900.toFloatBits());
/* 529 */       Game.i.assetManager.getSmallDebugFont().draw(paramBatch, (int)f + "deg", vector2.x, vector2.y, 1.0F, 1, false);
/*     */       
/* 531 */       Game.i.assetManager.getSmallDebugFont().setColor(Color.WHITE);
/*     */ 
/*     */       
/* 534 */       Array<Enemy> array = new Array(true, 1, Enemy.class);
/* 535 */       a(array);
/* 536 */       if (array.size != 0) {
/*     */ 
/*     */ 
/*     */         
/* 540 */         Vector2 vector21 = (getTile()).center;
/* 541 */         array.sort((paramEnemy1, paramEnemy2) -> Float.compare(paramEnemy1.getPosition().dst2(paramVector2), paramEnemy2.getPosition().dst2(paramVector2)));
/*     */         
/* 543 */         for (byte b1 = 0; b1 < array.size; b1++) {
/* 544 */           Enemy enemy = ((Enemy[])array.items)[b1];
/* 545 */           Game.i.assetManager.getSmallDebugFont().draw(paramBatch, "#" + (b1 + 1), (enemy.getPosition()).x, (enemy.getPosition()).y, 1.0F, 1, false);
/*     */         } 
/*     */ 
/*     */         
/* 549 */         Array array1 = new Array(true, 1, ObjectPair.class);
/*     */         
/* 551 */         for (byte b2 = 0; b2 < array.size; b2++) {
/* 552 */           Enemy enemy = ((Enemy[])array.items)[b2];
/* 553 */           float f1 = PMath.getAngleBetweenPoints(vector21, enemy.getPosition());
/*     */           
/* 555 */           Vector2 vector22 = new Vector2();
/* 556 */           PMath.getPointByAngleFromPoint((enemy.getPosition()).x, (enemy.getPosition()).y, f1 - 90.0F, enemy.getSize(), vector22);
/*     */           
/* 558 */           paramBatch.setColor(Color.RED);
/* 559 */           paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).smallCircle, vector22.x - 2.0F, vector22.y - 2.0F, 4.0F, 4.0F);
/*     */           
/* 561 */           Vector2 vector23 = new Vector2();
/* 562 */           PMath.getPointByAngleFromPoint((enemy.getPosition()).x, (enemy.getPosition()).y, f1 + 90.0F, enemy.getSize(), vector23);
/*     */           
/* 564 */           paramBatch.setColor(Color.GREEN);
/* 565 */           paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).smallCircle, vector23.x - 2.0F, vector23.y - 2.0F, 4.0F, 4.0F);
/*     */           
/* 567 */           f1 = PMath.getAngleBetweenPoints(vector21, vector22);
/* 568 */           float f4 = PMath.getAngleBetweenPoints(vector21, vector23);
/*     */           
/* 570 */           f1 += 360.0F;
/* 571 */           f4 += 360.0F;
/*     */           
/* 573 */           Game.i.assetManager.getSmallDebugFont().setColor(Color.RED);
/* 574 */           Game.i.assetManager.getSmallDebugFont().draw(paramBatch, (int)f1 + "deg", vector22.x, vector22.y + 20.0F, 1.0F, 1, false);
/*     */           
/* 576 */           Game.i.assetManager.getSmallDebugFont().setColor(Color.GREEN);
/* 577 */           Game.i.assetManager.getSmallDebugFont().draw(paramBatch, (int)f4 + "deg", vector23.x, vector23.y + 20.0F, 1.0F, 1, false);
/*     */           
/* 579 */           Game.i.assetManager.getSmallDebugFont().setColor(Color.WHITE);
/*     */ 
/*     */           
/* 582 */           float f2 = Math.max(paramFloat, f1);
/* 583 */           float f3 = Math.min(f, f4);
/*     */ 
/*     */           
/* 586 */           boolean bool = false;
/* 587 */           for (byte b = 0; b < array1.size; b++) {
/*     */             ObjectPair objectPair;
/* 589 */             float f6 = ((Vector2)(objectPair = ((ObjectPair[])array1.items)[b]).first).x;
/* 590 */             float f5 = ((Vector2)objectPair.first).y;
/*     */             
/* 592 */             if (f6 <= f2 && f5 >= f3) {
/*     */               
/* 594 */               bool = true;
/*     */ 
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */           
/* 601 */           if (!bool) {
/*     */             
/* 603 */             array1.add(new ObjectPair(new Vector2(f1, f4), enemy));
/* 604 */             Game.i.assetManager.getSmallDebugFont().setColor(MaterialColor.ORANGE.P500);
/* 605 */             Game.i.assetManager.getSmallDebugFont().draw(paramBatch, "HIT", (enemy.getPosition()).x, (enemy.getPosition()).y + 20.0F, 1.0F, 1, false);
/* 606 */             Game.i.assetManager.getSmallDebugFont().setColor(Color.WHITE);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 611 */       array.clear();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class FlamethrowerTowerFactory extends Tower.Factory<FlamethrowerTower> {
/*     */     ParticleEffectPool c;
/*     */     
/*     */     public FlamethrowerTowerFactory() {
/* 619 */       super("tower-flamethrower", TowerType.FLAMETHROWER);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 624 */       super.setup();
/*     */       
/* 626 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "" };
/* 627 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "", "", "", "", "" };
/* 628 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 629 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "", "" };
/* 630 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "", "" };
/*     */     }
/*     */     @Null
/*     */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/*     */       float f;
/* 635 */       if (param1TowerStatType == TowerStatType.U_BURNING_TIME) {
/* 636 */         f = param1GameValueProvider.getFloatValue(GameValueType.TOWER_FLAMETHROWER_TIME_TO_IGNITE);
/* 637 */         return Game.i.localeManager.i18n.format("tower_stat_more_info_FLAMETHROWER_U_BURNING_TIME", new Object[] { Float.valueOf(f) });
/* 638 */       }  if (f == TowerStatType.U_DIRECT_FIRE_DAMAGE) {
/* 639 */         return Game.i.localeManager.i18n.get("tower_stat_more_info_FLAMETHROWER_U_DIRECT_FIRE_DAMAGE");
/*     */       }
/* 641 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 649 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_PLASMA_DAMAGE), 2, true).toString();
/* 650 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_NAPALM_DURATION), 2, true).toString();
/* 651 */       (arrayOfAbilityConfig[1]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_NAPALM_DAMAGE), 2, true).toString();
/* 652 */       (arrayOfAbilityConfig[1]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_NAPALM_DIRECT_DAMAGE), 2, true).toString();
/* 653 */       (arrayOfAbilityConfig[1]).descriptionArgs[3] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_FLAMETHROWER_A_NAPALM_FREEZING), 2, true).toString();
/* 654 */       (arrayOfAbilityConfig[1]).descriptionArgs[4] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_FLAMETHROWER_A_NAPALM_COLD_FIRE_DMG), 2, true).toString();
/* 655 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_COLD_DAMAGE), 2, true).toString();
/* 656 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_FLAMETHROWER_A_COLD_FREEZING), 2, true).toString();
/* 657 */       (arrayOfAbilityConfig[2]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_FLAMETHROWER_A_COLD_DAMAGE_TO_BURNING), 2, true).toString();
/* 658 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_SUPPLY_RANGE), 2, true).toString();
/* 659 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_SUPPLY_ARC), 2, true).toString();
/* 660 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros((((FlamethrowerTower)param1Tower).a() * 100.0F), 2, true).toString();
/* 661 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_FLAMETHROWER_A_ULTIMATE_CROWD_BONUS), 2, true).toString();
/*     */       
/* 663 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 669 */       if (param1Int == 0) {
/* 670 */         return false;
/*     */       }
/* 672 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 677 */       this.c = Game.i.assetManager.getParticleEffectPool("flamethrower.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 682 */       return 48;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 686 */       return MaterialColor.ORANGE.P500;
/*     */     }
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 690 */       switch (FlamethrowerTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 691 */           return 2;
/* 692 */         case 2: return 5;
/* 693 */         case 3: return 4;
/* 694 */         case 4: return 5;
/* 695 */         case 5: return 2; }
/* 696 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 702 */       return FlamethrowerTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public FlamethrowerTower create() {
/* 707 */       return new FlamethrowerTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\FlamethrowerTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */