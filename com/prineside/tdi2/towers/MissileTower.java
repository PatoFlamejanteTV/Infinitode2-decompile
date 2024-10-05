/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
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
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.projectiles.MissileProjectile;
/*     */ import com.prineside.tdi2.utils.DrawUtils;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS
/*     */ public final class MissileTower
/*     */   extends Tower
/*     */ {
/*  37 */   private static final TLog e = TLog.forClass(MissileTower.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   public static final String[] ABILITY_ALIASES = new String[] { "VERTICAL_LAUNCH", "COMPACT_MISSILES", "ANTI_AIR_SYSTEM" };
/*     */ 
/*     */ 
/*     */   
/*     */   private float f;
/*     */ 
/*     */   
/*  50 */   private Enemy.EnemyReference g = Enemy.EnemyReference.NULL;
/*     */   
/*     */   private Enemy.EnemyReference[] h;
/*     */   
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte i;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  58 */     super.write(paramKryo, paramOutput);
/*  59 */     paramOutput.writeFloat(this.f);
/*  60 */     paramKryo.writeObject(paramOutput, this.g);
/*  61 */     paramKryo.writeObjectOrNull(paramOutput, this.h, Enemy.EnemyReference[].class);
/*  62 */     paramOutput.writeByte(this.i);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  67 */     super.read(paramKryo, paramInput);
/*  68 */     this.f = paramInput.readFloat();
/*  69 */     this.g = (Enemy.EnemyReference)paramKryo.readObject(paramInput, Enemy.EnemyReference.class);
/*  70 */     this.h = (Enemy.EnemyReference[])paramKryo.readObjectOrNull(paramInput, Enemy.EnemyReference[].class);
/*  71 */     this.i = paramInput.readByte();
/*     */   }
/*     */   
/*     */   private MissileTower() {
/*  75 */     super(TowerType.MISSILE);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  80 */     this.g = Enemy.EnemyReference.NULL;
/*     */     
/*  82 */     super.setUnregistered();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/*  87 */     if (isAbilityInstalled(1)) {
/*  88 */       return Game.i.towerManager.F.MISSILE.getAbilityTextures(1);
/*     */     }
/*  90 */     return Game.i.towerManager.F.MISSILE.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 103 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAttack() {
/* 109 */     if (isOutOfOrder() || this.attackDisabled) return false; 
/* 110 */     return (getTarget() != null && getTarget().getPosition().dst2((getTile()).center) > this.minRangeInPixels * this.minRangeInPixels);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canAttackEnemy(Enemy paramEnemy) {
/* 115 */     if (!super.canAttackEnemy(paramEnemy)) return false;
/*     */     
/* 117 */     return (!paramEnemy.isAir() || isAbilityInstalled(2));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void attack(int paramInt) {
/* 122 */     b(getStat(TowerStatType.DAMAGE), 1.0F);
/*     */   }
/*     */   
/*     */   private void b(float paramFloat1, float paramFloat2) {
/* 126 */     if (getTarget() == null) {
/* 127 */       e.i("Enemy is not valid", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 131 */     Vector2 vector21 = new Vector2();
/* 132 */     Vector2 vector22 = new Vector2();
/*     */     
/* 134 */     float f1 = getStat(TowerStatType.U_EXPLOSION_RANGE);
/* 135 */     float f2 = getStat(TowerStatType.PROJECTILE_SPEED);
/*     */     
/* 137 */     if (isAbilityInstalled(1) && this.S.gameValue.getIntValue(GameValueType.TOWER_MISSILE_A_COMPACT_COUNT) > 1) {
/* 138 */       int i = this.S.gameValue.getIntValue(GameValueType.TOWER_MISSILE_A_COMPACT_COUNT);
/*     */       
/* 140 */       float f3 = 60.0F;
/* 141 */       if (isAbilityInstalled(0)) {
/*     */         float f;
/* 143 */         if ((f = 1.0F + (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_A_VERTICAL_ROTATION_BONUS)) < 0.01F) {
/* 144 */           f = 0.01F;
/*     */         }
/* 146 */         f3 = 60.0F * f;
/*     */       } 
/*     */       
/* 149 */       float f4 = 0.0F;
/* 150 */       float f5 = 1.0F / (i - 1);
/* 151 */       for (byte b = 0; b < i; b++) {
/* 152 */         Enemy enemy = getTarget();
/* 153 */         if (b > 0 && this.h != null && this.h.length > b && (this.h[b]).enemy != null)
/*     */         {
/* 155 */           enemy = (this.h[b]).enemy;
/*     */         }
/*     */         
/* 158 */         float f = this.angle + -37.5F + f4 * 75.0F;
/*     */         
/* 160 */         vector21.set(0.0F, 20.0F);
/* 161 */         vector21.rotateDeg(f);
/* 162 */         vector21.add((getTile()).center);
/*     */         
/* 164 */         vector22.set(0.0F, 18.0F);
/* 165 */         vector22.rotateDeg(this.angle + 180.0F);
/* 166 */         vector21.add(vector22);
/*     */         
/* 168 */         MissileProjectile missileProjectile = (MissileProjectile)this.S.projectile.F.MISSILE.obtain();
/* 169 */         this.S.projectile.register((Projectile)missileProjectile);
/* 170 */         missileProjectile.setup(this, enemy, paramFloat1, f1, vector21, f2, f3, f, paramFloat2 * 0.75F);
/*     */         
/* 172 */         f4 += f5;
/*     */       } 
/*     */     } else {
/*     */       
/* 176 */       MissileProjectile missileProjectile = (MissileProjectile)this.S.projectile.F.MISSILE.obtain();
/* 177 */       this.S.projectile.register((Projectile)missileProjectile);
/* 178 */       missileProjectile.setup(this, getTarget(), paramFloat1, f1, (getTile()).center, f2, 90.0F, this.angle, paramFloat2);
/*     */     } 
/* 180 */     this.shotCount++;
/*     */     
/* 182 */     if (this.S._sound != null) {
/* 183 */       this.S._sound.playShotSound(StaticSoundType.SHOT_MISSILE, this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 191 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 193 */     if (paramTowerStatType == TowerStatType.RANGE && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_A_VERTICAL_MAX_RANGE)); 
/* 194 */     if (paramTowerStatType == TowerStatType.MIN_RANGE && isAbilityInstalled(2)) f = 0.0F; 
/* 195 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_A_COMPACT_DAMAGE));
/*     */     
/* 197 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawWeapon(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 204 */     paramFloat4 = paramFloat3 / 128.0F;
/* 205 */     if ((getTile()).visibleOnScreen && !isOutOfOrder()) {
/*     */       
/* 207 */       getWeaponTextures().draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat3, 1.0F, 1.0F, this.angle);
/*     */ 
/*     */       
/* 210 */       float f = getAttackDelay();
/* 211 */       if (this.c > f / 2.0F) {
/*     */         int i; byte b;
/* 213 */         if ((f = (this.c - f / 2.0F) / f / 2.0F) > 1.0F) f = 1.0F;
/*     */         
/* 215 */         if (isAbilityInstalled(1) && this.S.gameValue.getIntValue(GameValueType.TOWER_MISSILE_A_COMPACT_COUNT) > 1) {
/*     */           
/* 217 */           f *= 0.75F;
/*     */           
/* 219 */           i = this.S.gameValue.getIntValue(GameValueType.TOWER_MISSILE_A_COMPACT_COUNT);
/*     */           
/* 221 */           paramFloat2 = 0.0F;
/* 222 */           paramFloat3 = 1.0F / (i - 1);
/*     */           
/* 224 */           for (b = 0; b < i; b++) {
/* 225 */             float f1 = this.angle + -37.5F + paramFloat2 * 75.0F;
/*     */             
/* 227 */             Vector2 vector21 = new Vector2();
/* 228 */             Vector2 vector22 = new Vector2();
/* 229 */             vector21.set(0.0F, 20.0F);
/* 230 */             vector21.rotateDeg(f1);
/* 231 */             vector21.add((getTile()).center);
/*     */             
/* 233 */             vector22.set(0.0F, 18.0F);
/* 234 */             vector22.rotateDeg(this.angle + 180.0F);
/* 235 */             vector21.add(vector22);
/*     */             
/* 237 */             paramBatch.draw(Game.i.towerManager.F.MISSILE.c, vector21.x - 7.0F * f, vector21.y - 14.0F * f, 7.0F * f, 14.0F * f, 14.0F * f, 28.0F * f, 1.0F, 1.0F, f1);
/*     */             
/* 239 */             paramFloat2 += paramFloat3;
/*     */           } 
/*     */           return;
/*     */         } 
/* 243 */         paramBatch.draw(Game.i.towerManager.F.MISSILE.c, i + paramFloat3 * 0.5F - 7.0F * f * b, paramFloat2 + paramFloat3 * 0.5F - 14.0F * f * b, 7.0F * f * b, 14.0F * f * b, 14.0F * f * b, 28.0F * f * b, 1.0F, 1.0F, this.angle);
/*     */       } 
/*     */     } 
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
/*     */   public final void update(float paramFloat) {
/* 262 */     if (isOutOfOrder()) {
/* 263 */       super.update(paramFloat);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 268 */     a(paramFloat, getStat(TowerStatType.ROTATION_SPEED));
/*     */ 
/*     */     
/* 271 */     this.i = (byte)(this.i + 1);
/* 272 */     if (this.i == 3) {
/* 273 */       float f = paramFloat * 3.0F;
/* 274 */       this.i = 0;
/*     */       
/* 276 */       boolean bool = (getTarget() == null) ? true : false;
/* 277 */       if (isAbilityInstalled(0)) {
/* 278 */         bool = true;
/*     */       }
/*     */       
/* 281 */       if (getTarget() != null)
/*     */       {
/* 283 */         if (isAbilityInstalled(4)) {
/*     */           int i;
/*     */           
/* 286 */           if ((i = this.S.gameValue.getIntValue(GameValueType.TOWER_MISSILE_A_COMPACT_COUNT) - 1) > 0) {
/* 287 */             if (this.h == null || this.h.length != i) {
/* 288 */               this.h = new Enemy.EnemyReference[i];
/* 289 */               Arrays.fill((Object[])this.h, Enemy.EnemyReference.NULL);
/*     */             } 
/*     */             
/* 292 */             for (byte b = 0; b < this.h.length; b++) {
/*     */               Enemy enemy;
/* 294 */               if ((enemy = (this.h[b]).enemy) == null || enemy == getTarget()) {
/* 295 */                 this.h[b] = Enemy.EnemyReference.NULL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 303 */                 if ((enemy = findTargetFiltered(paramEnemy -> { Enemy.EnemyReference[] arrayOfEnemyReference; int i = (arrayOfEnemyReference = this.h).length; for (byte b = 0; b < i; b++) { Enemy.EnemyReference enemyReference; if ((enemyReference = arrayOfEnemyReference[b]).enemy == paramEnemy) return false;  }  return (paramEnemy != getTarget()); })) == null) {
/*     */                   
/* 305 */                   this.h[b] = this.S.enemy.getReference(getTarget());
/*     */                   break;
/*     */                 } 
/* 308 */                 this.h[b] = this.S.enemy.getReference(enemy);
/*     */ 
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 318 */       if (bool) {
/*     */         
/* 320 */         if (this.g.enemy == null)
/*     */         {
/* 322 */           if (this.S.map.spawnedEnemies.size != 0) {
/* 323 */             for (byte b = 0; b < 10; b++) {
/*     */               Enemy.EnemyReference enemyReference;
/* 325 */               if ((enemyReference = (Enemy.EnemyReference)this.S.map.spawnedEnemies.get(this.S.gameState.randomInt(this.S.map.spawnedEnemies.size))).enemy != null && 
/* 326 */                 canAttackEnemy(enemyReference.enemy)) {
/*     */                 
/* 328 */                 this.g = enemyReference;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/* 335 */         if (this.g.enemy != null) {
/*     */           
/* 337 */           if (!isOutOfOrder()) {
/* 338 */             float f1 = getStat(TowerStatType.U_LRM_AIM_SPEED);
/* 339 */             if (isAbilityInstalled(0)) {
/* 340 */               f1 = (float)(f1 * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_A_VERTICAL_LRM_RATE));
/*     */             }
/*     */             
/* 343 */             this.f += f * f1;
/* 344 */             if (this.f >= 100.0F) {
/*     */               
/* 346 */               if (!this.attackDisabled) {
/* 347 */                 setTarget(this.g.enemy);
/* 348 */                 float f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_LRM_DAMAGE);
/* 349 */                 if (isAbilityInstalled(2)) {
/* 350 */                   f2 = (float)(f2 + this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_A_ANTI_AIR_LRM_DAMAGE));
/*     */                 }
/* 352 */                 b(getStat(TowerStatType.DAMAGE) * f2, 1.5F);
/* 353 */                 setTarget(null);
/*     */               } 
/*     */               
/* 356 */               this.f = 0.0F;
/* 357 */               this.g = Enemy.EnemyReference.NULL;
/*     */             } 
/*     */           } 
/*     */         } else {
/*     */           
/* 362 */           this.f = 0.0F;
/*     */         } 
/*     */       } else {
/* 365 */         this.f = 0.0F;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 370 */     super.update(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 375 */     super.drawBatch(paramBatch, paramFloat);
/*     */     
/* 377 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_BUILDING_INFO) != 0.0D) {
/* 378 */       String str = ((this.g.enemy == null) ? "-" : "+") + " " + (int)this.f;
/* 379 */       Game.i.assetManager.getDebugFont(false).draw(paramBatch, str, (getTile()).center.x - 50.0F, (getTile()).center.y - 30.0F, 100.0F, 1, false);
/*     */       
/* 381 */       if (this.g.enemy != null) {
/* 382 */         DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), (getTile()).center.x, (getTile()).center.y, (this.g.enemy.getPosition()).x, (this.g.enemy.getPosition()).y, 4.0F, MaterialColor.PINK.P600.toFloatBits(), MaterialColor.PINK.P400.toFloatBits());
/*     */         
/* 384 */         if (this.h != null) {
/* 385 */           Enemy.EnemyReference[] arrayOfEnemyReference; int i; byte b; for (i = (arrayOfEnemyReference = this.h).length, b = 0; b < i; b++) {
/* 386 */             Enemy.EnemyReference enemyReference; if ((enemyReference = arrayOfEnemyReference[b]).enemy != null)
/* 387 */               DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), (getTile()).center.x, (getTile()).center.y, (enemyReference.enemy.getPosition()).x, (enemyReference.enemy.getPosition()).y, 3.0F, MaterialColor.PURPLE.P600.toFloatBits(), MaterialColor.PURPLE.P400.toFloatBits()); 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class MissileTowerFactory
/*     */     extends Tower.Factory<MissileTower> {
/*     */     TextureRegion c;
/*     */     
/*     */     public MissileTowerFactory() {
/* 399 */       super("tower-missile", TowerType.MISSILE);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 404 */       super.setup();
/*     */       
/* 406 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 407 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "", "" };
/* 408 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "" };
/* 409 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "", "" };
/* 410 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "" };
/*     */     }
/*     */     
/*     */     @Null
/*     */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/* 415 */       if (param1TowerStatType == TowerStatType.U_LRM_AIM_SPEED) {
/* 416 */         float f = param1GameValueProvider.getFloatValue(GameValueType.TOWER_MISSILE_LRM_DAMAGE);
/* 417 */         if (param1Tower.isAbilityInstalled(2)) {
/* 418 */           f += param1GameValueProvider.getFloatValue(GameValueType.TOWER_MISSILE_A_ANTI_AIR_LRM_DAMAGE);
/*     */         }
/* 420 */         String str = StringFormatter.compactNumberWithPrecisionTrimZeros(f, 1, true).toString();
/* 421 */         return Game.i.localeManager.i18n.format("tower_stat_more_info_MISSILE_U_LRM_AIM_SPEED", new Object[] { str });
/*     */       } 
/* 423 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 431 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_A_VERTICAL_MAX_RANGE), 2, true).toString();
/* 432 */       (arrayOfAbilityConfig[0]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MISSILE_A_VERTICAL_ROTATION_BONUS), 2, true).toString();
/* 433 */       (arrayOfAbilityConfig[0]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MISSILE_A_VERTICAL_LRM_RATE), 2, true).toString();
/* 434 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MISSILE_A_ANTI_AIR_LRM_DAMAGE), 2, true).toString();
/* 435 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_MISSILE_A_COMPACT_COUNT), false).toString();
/* 436 */       (arrayOfAbilityConfig[1]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MISSILE_A_COMPACT_DAMAGE), 2, true).toString();
/* 437 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MISSILE_A_OVERWEIGHT_HP), 2, true).toString();
/*     */       
/* 439 */       float f = param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MISSILE_A_OVERWEIGHT_DAMAGE);
/* 440 */       if (param1Tower.isAbilityInstalled(4)) {
/* 441 */         f += param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MISSILE_A_ULTIMATE_DAMAGE);
/*     */       }
/* 443 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(f, 2, true).toString();
/*     */       
/* 445 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MISSILE_A_ULTIMATE_DAMAGE), 2, true).toString();
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
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 461 */       switch (MissileTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 462 */           return 5;
/* 463 */         case 2: return 1;
/* 464 */         case 3: return 5;
/* 465 */         case 4: return 5;
/* 466 */         case 5: return 2; }
/* 467 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 473 */       return 50;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 477 */       return MaterialColor.PINK.P500;
/*     */     }
/*     */     
/*     */     public void setupAssets() {
/* 481 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-missile");
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 486 */       return MissileTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public MissileTower create() {
/* 491 */       return new MissileTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\MissileTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */