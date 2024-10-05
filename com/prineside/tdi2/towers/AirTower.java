/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.buffs.BurnBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.events.game.EnemyTakeDamage;
/*     */ import com.prineside.tdi2.explosions.AirFallExplosion;
/*     */ import com.prineside.tdi2.projectiles.AirProjectile;
/*     */ import com.prineside.tdi2.units.MineUnit;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ @REGS
/*     */ public final class AirTower
/*     */   extends Tower
/*     */ {
/*  44 */   public static final String[] ABILITY_ALIASES = new String[] { "HEAVY_WEAPONS", "FAST_MECHANISM", "FOUNDATION" };
/*     */ 
/*     */ 
/*     */   
/*     */   public static final float MAX_BURN_DAMAGE_ENEMY_HP_PERCENT = 3.0F;
/*     */ 
/*     */ 
/*     */   
/*  52 */   private float e = 90.0F;
/*  53 */   private Vector2 f = new Vector2();
/*     */   
/*     */   public boolean currentTargetIgnited;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  59 */     super.write(paramKryo, paramOutput);
/*  60 */     paramOutput.writeFloat(this.e);
/*  61 */     paramKryo.writeObject(paramOutput, this.f);
/*  62 */     paramOutput.writeBoolean(this.currentTargetIgnited);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  67 */     super.read(paramKryo, paramInput);
/*  68 */     this.e = paramInput.readFloat();
/*  69 */     this.f = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*  70 */     this.currentTargetIgnited = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private AirTower() {
/*  74 */     super(TowerType.AIR);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/*  79 */     if (isAbilityInstalled(0)) {
/*  80 */       return Game.i.towerManager.F.AIR.getAbilityTextures(0);
/*     */     }
/*  82 */     return Game.i.towerManager.F.AIR.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getEnemyPriority(Enemy paramEnemy) {
/* 100 */     if (paramEnemy.hasBuffsByType(BuffType.BURN)) {
/* 101 */       return paramEnemy.lowAimPriority.isTrue() ? -5 : 5;
/*     */     }
/* 103 */     return super.getEnemyPriority(paramEnemy);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void attack(int paramInt) {
/* 109 */     if (getTarget() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 113 */     this.e = -this.e;
/*     */     
/* 115 */     this.f.set((getTile()).center);
/* 116 */     PMath.shiftPointByAngle(this.f, this.angle, 24.0F);
/* 117 */     PMath.shiftPointByAngle(this.f, this.angle + this.e, 5.0F);
/*     */     
/* 119 */     AirProjectile airProjectile = (AirProjectile)this.S.projectile.F.AIR.obtain();
/* 120 */     this.S.projectile.register((Projectile)airProjectile);
/* 121 */     airProjectile.setup(this, 
/*     */         
/* 123 */         getTarget(), 
/* 124 */         getStat(TowerStatType.DAMAGE) * paramInt, this.f, 
/*     */         
/* 126 */         getStat(TowerStatType.PROJECTILE_SPEED), 
/* 127 */         getStat(TowerStatType.U_BURN_CHANCE) * 0.01F, 
/* 128 */         getStat(TowerStatType.U_BURN_DAMAGE) * 0.01F, 
/* 129 */         getStat(TowerStatType.U_BURNING_TIME));
/*     */ 
/*     */     
/* 132 */     this.shotCount += paramInt;
/*     */     
/* 134 */     if (this.S._sound != null) {
/* 135 */       this.S._sound.playShotSound(StaticSoundType.SHOT_AIR, this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 143 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 145 */     switch (null.a[paramTowerStatType.ordinal()]) {
/*     */       case 1:
/* 147 */         if (isAbilityInstalled(0)) {
/* 148 */           f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_HEAVY_WEAPONS_DAMAGE));
/*     */         }
/*     */         break;
/*     */       
/*     */       case 2:
/* 153 */         if (isAbilityInstalled(1)) {
/* 154 */           f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_FAST_MECHANISM_SPEED));
/*     */         }
/*     */         break;
/*     */       
/*     */       case 3:
/* 159 */         if (isAbilityInstalled(2)) {
/* 160 */           f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_FOUNDATION_BURN_DAMAGE));
/*     */         }
/*     */         break;
/*     */       
/*     */       case 4:
/* 165 */         if (isAbilityInstalled(1)) {
/* 166 */           f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_FAST_MECHANISM_IGNITION_CHANCE));
/*     */         }
/*     */         break;
/*     */       
/*     */       case 5:
/*     */       case 6:
/* 172 */         if (isAbilityInstalled(2)) {
/* 173 */           f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_FOUNDATION_SPEED));
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 179 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final AirFallExplosion createSpecialAbilityExplosion(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 185 */     double d = this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_AIMED_DROP_DAMAGE);
/*     */     
/* 187 */     if (isRegistered() && isAbilityInstalled(4)) {
/* 188 */       d += this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_ULTIMATE_DAMAGE);
/*     */     }
/*     */     
/*     */     AirFallExplosion airFallExplosion;
/* 192 */     (airFallExplosion = (AirFallExplosion)this.S.explosion.F.AIR_FALL.obtain()).setup(this, paramFloat1, paramFloat2, paramFloat3 * (float)d, this.S.gameValue.getFloatValue(GameValueType.TOWER_AIR_A_ULTIMATE_EXPL_RANGE));
/* 193 */     airFallExplosion.piercingMultiplier = 1.6F;
/*     */     
/* 195 */     return airFallExplosion;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 200 */     if (isOutOfOrder()) {
/* 201 */       super.update(paramFloat);
/*     */       
/*     */       return;
/*     */     } 
/* 205 */     a(paramFloat, getStat(TowerStatType.ROTATION_SPEED));
/*     */     
/* 207 */     if (this.currentTargetIgnited) {
/*     */       
/* 209 */       this.currentTargetIgnited = false;
/* 210 */       Enemy enemy = findTarget();
/* 211 */       if (getTarget() != enemy) {
/* 212 */         setTarget(enemy);
/*     */       }
/*     */     } 
/* 215 */     super.update(paramFloat);
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie extends SerializableListener<GameSystemProvider> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(GameSystemProvider param1GameSystemProvider) {
/* 223 */       this.a = param1GameSystemProvider;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       DamageRecord damageRecord;
/*     */       Tower tower;
/* 230 */       if (tower = (damageRecord = param1EnemyDie.getLastDamage()).getTower() instanceof AirTower && tower.isAbilityInstalled(3) && damageRecord.getEnemy().isAir()) {
/*     */         
/* 232 */         AirTower airTower = (AirTower)tower;
/*     */         Enemy enemy;
/* 234 */         Vector2 vector2 = (enemy = damageRecord.getEnemy()).getPosition();
/*     */         
/* 236 */         AirFallExplosion airFallExplosion = airTower.createSpecialAbilityExplosion(vector2.x, vector2.y, enemy.maxHealth);
/* 237 */         if (tower.isAbilityInstalled(4)) {
/*     */           MineUnit mineUnit;
/*     */           
/* 240 */           (mineUnit = Game.i.unitManager.F.MINE.create()).setup(tower, vector2.x, vector2.y, vector2.x, vector2.y, (Explosion)airFallExplosion, MaterialColor.CYAN.P500);
/* 241 */           ((GameSystemProvider)this.a).unit.register((Unit)mineUnit);
/* 242 */           ((GameSystemProvider)this.a).map.spawnUnit((Unit)mineUnit);
/*     */           return;
/*     */         } 
/* 245 */         ((GameSystemProvider)this.a).explosion.register((Explosion)airFallExplosion);
/* 246 */         airFallExplosion.explode();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyTakeDamage
/*     */     extends SerializableListener<GameSystemProvider>
/*     */     implements Listener<EnemyTakeDamage> {
/*     */     private OnEnemyTakeDamage() {}
/*     */     
/*     */     public OnEnemyTakeDamage(GameSystemProvider param1GameSystemProvider) {
/* 258 */       this.a = param1GameSystemProvider;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyTakeDamage param1EnemyTakeDamage) {
/*     */       DamageRecord damageRecord;
/*     */       Projectile projectile;
/* 265 */       if (projectile = (damageRecord = param1EnemyTakeDamage.getRecord()).getProjectile() instanceof AirProjectile && damageRecord.getDamageType() == DamageType.BULLET) {
/* 266 */         AirProjectile airProjectile = (AirProjectile)projectile;
/* 267 */         if (((GameSystemProvider)this.a).gameState.randomFloat() < airProjectile.getBurnChance()) {
/*     */           
/* 269 */           Tower tower = damageRecord.getTower();
/* 270 */           Enemy enemy = damageRecord.getEnemy();
/*     */           
/* 272 */           BurnBuff burnBuff = new BurnBuff();
/*     */           float f;
/* 274 */           if ((f = airProjectile.getDamage() * airProjectile.getBurnDamage()) > enemy.maxHealth * 3.0F) {
/* 275 */             f = enemy.maxHealth * 3.0F;
/*     */           }
/* 277 */           burnBuff.setup(tower, airProjectile.getBurningTime(), airProjectile.getBurningTime() * 10.0F, f, null);
/* 278 */           ((GameSystemProvider)this.a).buff.P_BURN.addBuff(enemy, burnBuff);
/*     */ 
/*     */           
/* 281 */           if (tower instanceof AirTower && tower.getTarget() == enemy)
/* 282 */             ((AirTower)tower).currentTargetIgnited = true; 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class AirTowerFactory
/*     */     extends Tower.Factory<AirTower> {
/*     */     public AirTowerFactory() {
/* 291 */       super("tower-air", TowerType.AIR);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void setup() {
/* 296 */       super.setup();
/*     */       
/* 298 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "" };
/* 299 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "", "" };
/* 300 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "" };
/* 301 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "" };
/* 302 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "" };
/*     */     }
/*     */ 
/*     */     
/*     */     public final void configureSystems(GameSystemProvider param1GameSystemProvider) {
/* 307 */       param1GameSystemProvider.events.getListeners(EnemyDie.class).addStateAffecting(new AirTower.OnEnemyDie(param1GameSystemProvider));
/* 308 */       param1GameSystemProvider.events.getListeners(EnemyTakeDamage.class).addStateAffecting(new AirTower.OnEnemyTakeDamage(param1GameSystemProvider));
/*     */     }
/*     */     
/*     */     @Null
/*     */     public final CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/* 313 */       if (param1TowerStatType == TowerStatType.U_BURN_DAMAGE) {
/* 314 */         String str = StringFormatter.compactNumberWithPrecisionTrimZeros(3.0D, 1, true).toString();
/* 315 */         return Game.i.localeManager.i18n.format("tower_stat_more_info_AIR_U_BURN_CHANCE", new Object[] { str });
/*     */       } 
/* 317 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 325 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_HEAVY_WEAPONS_DAMAGE), 2, true).toString();
/* 326 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_FAST_MECHANISM_SPEED), 2, true).toString();
/* 327 */       (arrayOfAbilityConfig[1]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_FAST_MECHANISM_IGNITION_CHANCE), 2, true).toString();
/* 328 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_FOUNDATION_SPEED), 2, true).toString();
/* 329 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_FOUNDATION_BURN_DAMAGE), 2, true).toString();
/* 330 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_AIR_A_AIMED_DROP_DAMAGE) * 100.0D, false).toString();
/* 331 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_AIR_A_ULTIMATE_DAMAGE), 2, true).toString();
/*     */       
/* 333 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean shouldDrawAbilityToCache(int param1Int) {
/* 339 */       if (param1Int == 0) {
/* 340 */         return false;
/*     */       }
/* 342 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 347 */       switch (AirTower.null.b[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 348 */           return 5;
/* 349 */         case 2: return 5;
/* 350 */         case 3: return 4;
/* 351 */         case 4: return 1;
/* 352 */         case 5: return 3; }
/* 353 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int getBuildHotKey() {
/* 359 */       return 52;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String[] getAbilityAliases() {
/* 364 */       return AirTower.ABILITY_ALIASES;
/*     */     }
/*     */     
/*     */     public final Color getColor() {
/* 368 */       return MaterialColor.CYAN.P500;
/*     */     }
/*     */     
/*     */     public final AirTower create() {
/* 372 */       return new AirTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\AirTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */