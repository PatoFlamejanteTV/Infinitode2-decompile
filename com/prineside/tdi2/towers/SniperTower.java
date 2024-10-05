/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.SpecialDamageType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.explosions.GenericExplosion;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.shapes.BulletSmokeMultiLine;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ @REGS
/*     */ public final class SniperTower
/*     */   extends Tower {
/*     */   public static final float MIN_AIM_SPEED_MULTIPLIER_IN_CROWD = 0.15F;
/*     */   public static final float AIM_SPEED_MULTIPLIER_PER_ENEMY_IN_CROWD = 0.04F;
/*  50 */   public static final String[] ABILITY_ALIASES = new String[] { "PENETRATING_BULLETS", "HEAVY_WEAPONS", "SHORT_BARREL" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   private static final Color e = Color.WHITE.cpy();
/*     */   
/*  58 */   private Enemy.EnemyReference f = Enemy.EnemyReference.NULL;
/*  59 */   private float g = 0.0F;
/*  60 */   private int h = 0;
/*     */   
/*  62 */   private static final Color i = new Color();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  66 */     super.write(paramKryo, paramOutput);
/*  67 */     paramKryo.writeObject(paramOutput, this.f);
/*  68 */     paramOutput.writeFloat(this.g);
/*  69 */     paramOutput.writeVarInt(this.h, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  74 */     super.read(paramKryo, paramInput);
/*  75 */     this.f = (Enemy.EnemyReference)paramKryo.readObject(paramInput, Enemy.EnemyReference.class);
/*  76 */     this.g = paramInput.readFloat();
/*  77 */     this.h = paramInput.readVarInt(true);
/*     */   }
/*     */   
/*     */   private SniperTower() {
/*  81 */     super(TowerType.SNIPER);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  86 */     super.setUnregistered();
/*     */     
/*  88 */     this.f = Enemy.EnemyReference.NULL;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/*  93 */     if (isAbilityInstalled(0)) {
/*  94 */       if (isAbilityInstalled(2)) {
/*  95 */         return Game.i.towerManager.F.SNIPER.c;
/*     */       }
/*  97 */       return Game.i.towerManager.F.SNIPER.getAbilityTextures(0);
/*     */     } 
/*     */     
/* 100 */     if (isAbilityInstalled(2)) {
/* 101 */       return Game.i.towerManager.F.SNIPER.getAbilityTextures(2);
/*     */     }
/* 103 */     return Game.i.towerManager.F.SNIPER.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a() {
/*     */     Enemy enemy;
/* 112 */     if ((enemy = getTarget()) == null) return false;
/*     */     
/* 114 */     float f = PMath.getAngleBetweenPoints((getTile()).center, enemy.getPosition());
/* 115 */     if (StrictMath.abs(PMath.getDistanceBetweenAngles(this.angle, f)) < 3.0F)
/*     */     {
/* 117 */       return (this.f.enemy == enemy);
/*     */     }
/*     */     
/* 120 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 131 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAttack() {
/* 137 */     return (a() && !this.attackDisabled && this.g >= 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void attack(int paramInt) {
/*     */     Enemy enemy;
/* 143 */     if ((enemy = getTarget()) == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     Vector2 vector2;
/* 148 */     (vector2 = new Vector2()).set(enemy.getPosition());
/*     */     Color color;
/* 150 */     if ((color = enemy.getColor()) != null) i.set(enemy.getColor());
/*     */     
/* 152 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */       Vector2 vector21;
/*     */       
/* 155 */       (vector21 = new Vector2()).set((getTile()).center);
/* 156 */       if (!isAbilityInstalled(2)) {
/*     */ 
/*     */         
/* 159 */         ResourcePack.AtlasTextureRegion atlasTextureRegion = (FastRandom.getFloat() < 0.5F) ? (AssetManager.TextureRegions.i()).muzzleFlashCompensator1 : (AssetManager.TextureRegions.i()).muzzleFlashCompensator2;
/* 160 */         PMath.shiftPointByAngle(vector21, this.angle, 43.0F);
/* 161 */         this.S._particle.addFlashParticle((TextureRegion)atlasTextureRegion, vector21.x, vector21.y, 28.35F, 13.5F, 56.7F, 56.7F, this.angle);
/*     */       } else {
/* 163 */         ResourcePack.AtlasTextureRegion atlasTextureRegion = (AssetManager.TextureRegions.i()).muzzleFlash1;
/* 164 */         PMath.shiftPointByAngle(vector21, this.angle, 28.0F);
/* 165 */         this.S._particle.addFlashParticle((TextureRegion)atlasTextureRegion, vector21.x, vector21.y, 21.6F, 2.7F, 43.2F, 43.2F, this.angle);
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     boolean bool1 = false;
/* 170 */     boolean bool2 = false;
/* 171 */     float f1 = getStat(TowerStatType.DAMAGE) * paramInt;
/*     */     
/* 173 */     float f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_KILLSHOT_HP);
/* 174 */     int i = this.S.gameValue.getIntValue(GameValueType.TOWER_SNIPER_A_KILLSHOT_INTERVAL);
/* 175 */     float f3 = enemy.getBuffedDamageMultiplier(TowerType.SNIPER, DamageType.BULLET);
/* 176 */     if (isAbilityInstalled(3) && f3 != 0.0F && enemy.isVulnerableToSpecial(SpecialDamageType.KILLSHOT) && enemy.getHealth() < enemy.maxHealth * f2 && this.h >= i) {
/*     */       
/* 178 */       vector2.set(enemy.getPosition());
/*     */       
/* 180 */       bool1 = true;
/* 181 */       this.S.damage.queueDamage(this.S.damage
/* 182 */           .obtainRecord().setup(enemy, enemy.getHealth() + 0.001F, DamageType.BULLET)
/* 183 */           .setTower(this)
/* 184 */           .setCleanForDps(false)
/* 185 */           .setLethal(true)
/* 186 */           .setEfficiency(8)
/* 187 */           .setIgnoreTowerEfficiency(true));
/*     */       
/* 189 */       enemy = null;
/*     */       
/* 191 */       if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */         ParticleEffectPool.PooledEffect pooledEffect;
/* 193 */         (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.F.SNIPER.g.obtain()).setPosition(vector2.x, vector2.y);
/* 194 */         this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */       } 
/*     */       
/* 197 */       this.h = 0;
/*     */     } else {
/*     */       
/* 200 */       if (isAbilityInstalled(4)) {
/*     */         
/* 202 */         f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_ULTIMATE_DAMAGE);
/*     */         
/*     */         float f;
/* 205 */         if ((f3 = (f = PMath.getDistanceBetweenPoints((getTile()).center, enemy.getPosition())) / this.rangeInPixels * (f2 - 1.0F)) > 0.0F)
/*     */         {
/* 207 */           f1 *= f3 + 1.0F;
/*     */         }
/*     */       } 
/*     */       
/* 211 */       f2 = getStat(TowerStatType.U_CRIT_CHANCE) * 0.01F;
/* 212 */       if (this.S.gameState.randomFloat() < f2) {
/*     */         
/* 214 */         bool2 = true;
/* 215 */         f1 *= getStat(TowerStatType.U_CRIT_MULTIPLIER) * 0.01F;
/*     */         
/* 217 */         this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, f1, DamageType.BULLET).setTower(this).setEfficiency(1));
/*     */         
/* 219 */         if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */           ParticleEffectPool.PooledEffect pooledEffect;
/*     */           
/* 222 */           (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.F.SNIPER.f.obtain()).setPosition(vector2.x, vector2.y);
/* 223 */           ParticleEmitter.ScaledNumericValue scaledNumericValue = ((ParticleEmitter)pooledEffect.getEmitters().first()).getAngle();
/* 224 */           f2 = this.angle - 270.0F;
/* 225 */           scaledNumericValue.setHigh(f2 - 15.0F, f2 + 15.0F);
/*     */           ParticleEmitter.GradientColorValue gradientColorValue;
/*     */           float[] arrayOfFloat;
/* 228 */           (arrayOfFloat = (gradientColorValue = ((ParticleEmitter)pooledEffect.getEmitters().first()).getTint()).getColors())[0] = i.r;
/* 229 */           arrayOfFloat[1] = i.g;
/* 230 */           arrayOfFloat[2] = i.b;
/* 231 */           gradientColorValue.setColors(arrayOfFloat);
/*     */           
/* 233 */           this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 239 */         this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, f1, DamageType.BULLET).setTower(this));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 244 */     if (isAbilityInstalled(0)) {
/* 245 */       Vector2 vector21 = new Vector2();
/* 246 */       PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, this.angle, this.rangeInPixels, vector21);
/*     */       
/* 248 */       Enemy enemy1 = enemy;
/* 249 */       f3 = f1;
/* 250 */       this.S.map.rayCastEnemiesSorted(vector2.x, vector2.y, vector21.x, vector21.y, 0.0F, paramEnemyReference -> {
/*     */             Enemy enemy;
/*     */             
/*     */             if ((enemy = paramEnemyReference.enemy) != paramEnemy) {
/*     */               float f1 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_PENETRATION_DAMAGE);
/*     */               
/*     */               f1 = paramFloat * f1;
/*     */               
/*     */               paramFloat = PMath.getDistanceBetweenPoints((getTile()).center, enemy.getPosition());
/*     */               
/*     */               float f2;
/*     */               
/*     */               if (isAbilityInstalled(4) && (f2 = (1.0F - paramFloat / this.rangeInPixels) * 0.75F) > 0.0F) {
/*     */                 f1 *= f2 + 1.0F;
/*     */               }
/*     */               
/*     */               Vector2 vector2 = new Vector2(enemy.getPosition());
/*     */               
/*     */               this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, f1, DamageType.BULLET).setTower(this));
/*     */               
/*     */               if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*     */                 BulletSmokeMultiLine bulletSmokeMultiLine;
/*     */                 
/*     */                 (bulletSmokeMultiLine = (BulletSmokeMultiLine)Game.i.shapeManager.F.BULLET_SMOKE_MULTI_LINE.obtain()).maxAlpha = 1.0F;
/*     */                 
/*     */                 bulletSmokeMultiLine.setTexture(Game.i.towerManager.F.SNIPER.e, false, (FastRandom.getFloat() < 0.5F));
/*     */                 bulletSmokeMultiLine.setColor(MaterialColor.RED.P500);
/*     */                 bulletSmokeMultiLine.setup(paramVector2.x, paramVector2.y, vector2.x, vector2.y);
/*     */                 this.S._projectileTrail.addTrail((ProjectileTrail)bulletSmokeMultiLine);
/*     */               } 
/*     */               return false;
/*     */             } 
/*     */             return true;
/*     */           });
/*     */     } 
/* 285 */     if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/* 286 */       BulletSmokeMultiLine bulletSmokeMultiLine = (BulletSmokeMultiLine)Game.i.shapeManager.F.BULLET_SMOKE_MULTI_LINE.obtain();
/* 287 */       Vector2 vector21 = new Vector2();
/* 288 */       PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, this.angle, 30.0F, vector21);
/* 289 */       bulletSmokeMultiLine.setTexture(Game.i.towerManager.F.SNIPER.e, false, (FastRandom.getFloat() < 0.5F));
/*     */       
/* 291 */       if (bool1) {
/* 292 */         bulletSmokeMultiLine.maxAlpha = 0.56F;
/* 293 */         bulletSmokeMultiLine.setColor(MaterialColor.PURPLE.P500);
/* 294 */       } else if (bool2) {
/* 295 */         bulletSmokeMultiLine.maxAlpha = 0.28F;
/* 296 */         bulletSmokeMultiLine.setColor(MaterialColor.DEEP_ORANGE.P500);
/*     */       } else {
/* 298 */         bulletSmokeMultiLine.setColor(Color.WHITE);
/*     */       } 
/* 300 */       bulletSmokeMultiLine.setup(vector21.x, vector21.y, vector2.x, vector2.y);
/* 301 */       this.S._projectileTrail.addTrail((ProjectileTrail)bulletSmokeMultiLine);
/*     */     } 
/*     */     
/* 304 */     this.shotCount += paramInt;
/*     */     
/* 306 */     if (this.S._sound != null) {
/* 307 */       this.S._sound.playShotSound(StaticSoundType.SHOT_SNIPER, this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 315 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 317 */     if (paramTowerStatType == TowerStatType.RANGE && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_SHORT_RANGE)); 
/* 318 */     if (paramTowerStatType == TowerStatType.ROTATION_SPEED && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_SHORT_ROTATION_SPEED)); 
/* 319 */     if (paramTowerStatType == TowerStatType.U_CRIT_CHANCE && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_SHORT_CRIT_MULTIPLIER)); 
/* 320 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_HEAVY_DAMAGE));
/*     */     
/* 322 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 329 */     Enemy enemy = getTarget();
/* 330 */     if (this.f.enemy != enemy) {
/*     */       
/* 332 */       this.f = this.S.enemy.getReference(enemy);
/* 333 */       this.g = 0.0F;
/*     */     } 
/*     */     
/* 336 */     a(paramFloat, getStat(TowerStatType.ROTATION_SPEED));
/*     */     
/* 338 */     if (enemy != null) {
/*     */       
/* 340 */       if (a()) {
/*     */         float f;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 346 */         if ((f = 1.0F - enemy.otherEnemiesNearby * 0.04F) < 0.15F) f = 0.15F;
/*     */         
/* 348 */         this.g += paramFloat * getStat(TowerStatType.AIM_SPEED) * 0.01F * f;
/*     */         
/* 350 */         if (this.g > 1.0F)
/*     */         {
/* 352 */           this.g = 1.0F;
/*     */         }
/*     */       } else {
/* 355 */         this.g = 0.0F;
/*     */       } 
/*     */     } else {
/* 358 */       this.g = 0.0F;
/*     */     } 
/*     */     
/* 361 */     super.update(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 366 */     if ((getTile()).visibleOnScreen && 
/* 367 */       getTarget() != null && a()) {
/*     */       
/* 369 */       float f = 120.0F * (1.0F - this.g) + 4.0F;
/*     */       
/* 371 */       e.a = this.g;
/* 372 */       paramBatch.setColor(e);
/* 373 */       paramBatch.draw(Game.i.towerManager.F.SNIPER.d, (getTile()).center.x - f / 2.0F, (getTile()).center.y, f / 2.0F, 0.0F, f, 128.0F, 1.0F, 1.0F, this.angle);
/* 374 */       paramBatch.setColor(Color.WHITE);
/*     */     } 
/*     */ 
/*     */     
/* 378 */     super.drawBatch(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie extends SerializableListener<GameSystemProvider> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(GameSystemProvider param1GameSystemProvider) {
/* 386 */       this.a = param1GameSystemProvider;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       DamageRecord damageRecord;
/*     */       Tower tower;
/* 393 */       if (tower = (damageRecord = param1EnemyDie.getLastDamage()).getTower() instanceof SniperTower) {
/*     */         SniperTower sniperTower;
/* 395 */         SniperTower.a(sniperTower = (SniperTower)tower);
/*     */         
/* 397 */         if (DamageType.Efficiency.isCritical(damageRecord.getEfficiency()) && tower.isAbilityInstalled(4)) {
/*     */           Enemy enemy;
/*     */           
/* 400 */           Vector2 vector2 = (enemy = damageRecord.getEnemy()).getPosition();
/* 401 */           float f1 = (sniperTower.getTile()).center.dst2(vector2);
/* 402 */           float f2 = ((GameSystemProvider)this.a).gameValue.getFloatValue(GameValueType.TOWER_SNIPER_A_ULTIMATE_EXPL_RANGE);
/* 403 */           if (f1 < f2 * 128.0F * f2 * 128.0F) {
/*     */             GenericExplosion genericExplosion;
/*     */             
/* 406 */             (genericExplosion = (GenericExplosion)((GameSystemProvider)this.a).explosion.F.GENERIC.obtain()).setup(sniperTower, vector2.x, vector2.y, 
/*     */ 
/*     */                 
/* 409 */                 (damageRecord.getEnemy()).maxHealth * (float)((GameSystemProvider)this.a).gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_ULTIMATE_EXPL_DAMAGE), 1.2F, 0, 0.0F, 0.0F, enemy
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 414 */                 .getColor(), enemy
/* 415 */                 .getColor());
/*     */             
/* 417 */             ((GameSystemProvider)this.a).explosion.register((Explosion)genericExplosion);
/* 418 */             genericExplosion.explode();
/*     */             
/* 420 */             ((GameSystemProvider)this.a).achievement.registerDelta(AchievementType.EXPLODE_ENEMY_WITH_BULLET, 1);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SniperTowerFactory
/*     */     extends Tower.Factory<SniperTower> {
/*     */     Quad c;
/*     */     TextureRegion d;
/*     */     TextureRegion e;
/*     */     ParticleEffectPool f;
/*     */     ParticleEffectPool g;
/*     */     
/*     */     public SniperTowerFactory() {
/* 436 */       super("tower-sniper", TowerType.SNIPER);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 441 */       super.setup();
/*     */       
/* 443 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "" };
/* 444 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "" };
/* 445 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 446 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "", "" };
/* 447 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "", "", "" };
/*     */     }
/*     */ 
/*     */     
/*     */     public void configureSystems(GameSystemProvider param1GameSystemProvider) {
/* 452 */       param1GameSystemProvider.events.getListeners(EnemyDie.class).addStateAffecting(new SniperTower.OnEnemyDie(param1GameSystemProvider));
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 457 */       this.c = Game.i.assetManager.getQuad("towers." + TowerType.SNIPER.name() + ".weaponShortPenetrating");
/*     */       
/* 459 */       this.e = (TextureRegion)Game.i.assetManager.getTextureRegion("bullet-trace-smoke");
/* 460 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("tower-aim");
/*     */ 
/*     */       
/* 463 */       this.f = Game.i.assetManager.getParticleEffectPool("crit-hit.prt");
/*     */ 
/*     */       
/* 466 */       this.g = Game.i.assetManager.getParticleEffectPool("killshot.prt");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 472 */       if (param1Int == 0 || param1Int == 2) {
/* 473 */         return false;
/*     */       }
/* 475 */       return true;
/*     */     }
/*     */     
/*     */     @Null
/*     */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/* 480 */       if (param1TowerStatType == TowerStatType.AIM_SPEED) {
/* 481 */         String str1 = StringFormatter.compactNumberWithPrecisionTrimZeros(4.0D, 1, true).toString();
/* 482 */         String str2 = StringFormatter.compactNumberWithPrecisionTrimZeros(15.000000953674316D, 1, true).toString();
/* 483 */         return Game.i.localeManager.i18n.format("tower_stat_more_info_SNIPER_AIM_SPEED", new Object[] { str1, str2 });
/*     */       } 
/* 485 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/* 491 */       Tower.AbilityConfig[] arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower);
/*     */       
/* 493 */       double d1 = param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SNIPER_A_PENETRATION_DAMAGE);
/* 494 */       (arrayOfAbilityConfig[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(d1, 2, true).toString();
/*     */       
/* 496 */       double d2 = param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_HEAVY_DAMAGE);
/* 497 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(d2, 2, true).toString();
/*     */       
/* 499 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_SHORT_RANGE), 2, true).toString();
/* 500 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_SHORT_ROTATION_SPEED), 2, true).toString();
/* 501 */       (arrayOfAbilityConfig[2]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SNIPER_A_SHORT_CRIT_MULTIPLIER), 2, true).toString();
/*     */       
/* 503 */       double d3 = param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SNIPER_A_KILLSHOT_HP);
/* 504 */       int i = param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_SNIPER_A_KILLSHOT_INTERVAL);
/* 505 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumber(d3, false).toString();
/* 506 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = Integer.toString(i);
/*     */       
/* 508 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SNIPER_A_ULTIMATE_DAMAGE), false).toString();
/* 509 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SNIPER_A_ULTIMATE_EXPL_DAMAGE), 2, true).toString();
/* 510 */       (arrayOfAbilityConfig[4]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SNIPER_A_ULTIMATE_EXPL_RANGE), 2, true).toString();
/*     */       
/* 512 */       return arrayOfAbilityConfig;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 516 */       return MaterialColor.GREEN.P500;
/*     */     }
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 520 */       switch (SniperTower.null.a[param1GeneralizedTowerStatType.ordinal()]) {
/*     */         case 1:
/*     */         case 2:
/* 523 */           return 5;
/*     */         case 3:
/*     */         case 4:
/*     */         case 5:
/* 527 */           return 1;
/* 528 */       }  return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 534 */       return SniperTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 539 */       return 51;
/*     */     }
/*     */ 
/*     */     
/*     */     public SniperTower create() {
/* 544 */       return new SniperTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\SniperTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */