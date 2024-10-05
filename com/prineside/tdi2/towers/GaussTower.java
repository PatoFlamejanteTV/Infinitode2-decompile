/*      */ package com.prineside.tdi2.towers;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.Pools;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.tdi2.DamageRecord;
/*      */ import com.prineside.tdi2.Enemy;
/*      */ import com.prineside.tdi2.Explosion;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.GameValueProvider;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Miner;
/*      */ import com.prineside.tdi2.ProjectileTrail;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.Tower;
/*      */ import com.prineside.tdi2.buffs.DeathExplosionBuff;
/*      */ import com.prineside.tdi2.buffs.StunBuff;
/*      */ import com.prineside.tdi2.enums.AchievementType;
/*      */ import com.prineside.tdi2.enums.BuffType;
/*      */ import com.prineside.tdi2.enums.DamageType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.ShapeType;
/*      */ import com.prineside.tdi2.enums.SpecialDamageType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.enums.TowerStatType;
/*      */ import com.prineside.tdi2.enums.TowerType;
/*      */ import com.prineside.tdi2.events.Event;
/*      */ import com.prineside.tdi2.events.Listener;
/*      */ import com.prineside.tdi2.events.game.EnemyDie;
/*      */ import com.prineside.tdi2.explosions.GenericExplosion;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.shapes.BulletSmokeMultiLine;
/*      */ import com.prineside.tdi2.shapes.MultiLine;
/*      */ import com.prineside.tdi2.shapes.PieChart;
/*      */ import com.prineside.tdi2.tiles.SourceTile;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.PieChartActor;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.Quad;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.Locale;
/*      */ 
/*      */ @REGS
/*      */ public final class GaussTower extends Tower {
/*   72 */   private static final TLog e = TLog.forClass(GaussTower.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   78 */   public static final String[] ABILITY_ALIASES = new String[] { "NANOPARTICLES", "SELF_IMPROVEMENT", "SUPERCONDUCTORS" };
/*      */   
/*      */   private float f;
/*      */   
/*      */   private boolean g;
/*      */   
/*      */   private float h;
/*      */   
/*      */   private float i;
/*      */   
/*      */   private int j;
/*      */   private float k;
/*      */   private float l;
/*      */   private boolean m;
/*      */   private float n;
/*      */   private int o;
/*      */   @NAGS
/*      */   private float p;
/*      */   @NAGS
/*   97 */   private final Vector2 q = new Vector2(); @NAGS
/*      */   private MultiLine r; @NAGS
/*   99 */   private float s = -1000.0F;
/*      */   @NAGS
/*      */   private MultiLine t;
/*  102 */   private static final Color u = new Color();
/*      */   @NAGS
/*  104 */   private final DelayedRemovalArray<Trail> v = new DelayedRemovalArray(Trail.class);
/*      */ 
/*      */   
/*      */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  108 */     super.write(paramKryo, paramOutput);
/*  109 */     paramOutput.writeFloat(this.f);
/*  110 */     paramOutput.writeBoolean(this.g);
/*  111 */     paramOutput.writeFloat(this.h);
/*  112 */     paramOutput.writeFloat(this.i);
/*  113 */     paramOutput.writeVarInt(this.j, true);
/*  114 */     paramOutput.writeFloat(this.k);
/*  115 */     paramOutput.writeFloat(this.l);
/*  116 */     paramOutput.writeBoolean(this.m);
/*  117 */     paramOutput.writeFloat(this.n);
/*  118 */     paramOutput.writeVarInt(this.o, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void read(Kryo paramKryo, Input paramInput) {
/*  123 */     super.read(paramKryo, paramInput);
/*  124 */     this.f = paramInput.readFloat();
/*  125 */     this.g = paramInput.readBoolean();
/*  126 */     this.h = paramInput.readFloat();
/*  127 */     this.i = paramInput.readFloat();
/*  128 */     this.j = paramInput.readVarInt(true);
/*  129 */     this.k = paramInput.readFloat();
/*  130 */     this.l = paramInput.readFloat();
/*  131 */     this.m = paramInput.readBoolean();
/*  132 */     this.n = paramInput.readFloat();
/*  133 */     this.o = paramInput.readVarInt(true);
/*      */   }
/*      */   
/*      */   private GaussTower() {
/*  137 */     super(TowerType.GAUSS);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void setUnregistered() {
/*  142 */     super.setUnregistered();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Quad getWeaponTextures() {
/*  149 */     if (isAbilityInstalled(0)) {
/*  150 */       return Game.i.towerManager.F.GAUSS.getAbilityTextures(0);
/*      */     }
/*  152 */     return Game.i.towerManager.F.GAUSS.getWeaponTexture();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean canAim() {
/*  160 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean shouldSearchForTarget() {
/*  165 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean canAttack() {
/*  171 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final float getAttackDelay() {
/*  176 */     return 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Enemy paramEnemy) {
/*  183 */     if (paramEnemy != null && paramEnemy.gaveMiningSpeedForGauss) {
/*      */       return;
/*      */     }
/*      */     
/*  187 */     float f = this.S.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_ULTIMATE_MINING_TIME);
/*  188 */     this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*      */           SourceTile sourceTile;
/*      */           
/*      */           if (paramTile.type == TileType.SOURCE && (sourceTile = (SourceTile)paramTile).miner != null) {
/*      */             sourceTile.miner.doubleSpeedTimeLeft += paramFloat;
/*      */           }
/*      */           
/*      */           return true;
/*      */         });
/*      */     
/*  198 */     if (paramEnemy != null) {
/*  199 */       paramEnemy.gaveMiningSpeedForGauss = true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void f() {
/*  205 */     Vector2 vector2 = (new Vector2(0.0F, 1.0F)).rotateDeg(this.angle).scl(7680.0F).add((getTile()).center);
/*      */     
/*  207 */     float[] arrayOfFloat1 = { 5296.0F };
/*      */     
/*  209 */     boolean[] arrayOfBoolean = { false };
/*  210 */     boolean bool = false;
/*      */     int i;
/*  212 */     if ((i = this.S.gameValue.getIntValue(GameValueType.TOWER_GAUSS_A_OVERLOAD_SHOTS)) <= 0) {
/*  213 */       i = 1;
/*      */     }
/*  215 */     if (this.o % i == 0 && 
/*  216 */       isAbilityInstalled(3)) {
/*  217 */       arrayOfBoolean[0] = true;
/*  218 */       bool = true;
/*      */     } 
/*      */ 
/*      */     
/*  222 */     float[] arrayOfFloat2 = { getStat(TowerStatType.DAMAGE) };
/*  223 */     int[] arrayOfInt = { 0 };
/*  224 */     float f = this.S.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_ATTACK_RAY_WIDTH);
/*  225 */     this.S.map.rayCastEnemiesSorted((getTile()).center.x, (getTile()).center.y, vector2.x, vector2.y, 128.0F * f, paramEnemyReference -> {
/*      */           Enemy enemy;
/*      */           
/*      */           if ((enemy = paramEnemyReference.enemy) != null && canAttackEnemy(enemy)) {
/*      */             float f1;
/*      */             
/*      */             if ((f1 = enemy.getBuffedDamageMultiplier(TowerType.GAUSS, DamageType.BULLET)) == 0.0F) {
/*      */               return true;
/*      */             }
/*      */             
/*      */             float f2 = -0.001F;
/*      */             
/*      */             if (this.installedAbilities[0] && enemy.isVulnerableToSpecial(SpecialDamageType.NANOPARTICLES)) {
/*      */               f2 = enemy.maxHealth / f1 * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_GAUSS_A_NANO_HP);
/*      */             }
/*      */             
/*      */             float f3;
/*      */             
/*      */             if ((f3 = enemy.getHealth() / f1 - f2) <= 0.0F) {
/*      */               return true;
/*      */             }
/*      */             
/*      */             if (Float.isNaN(f3)) {
/*      */               e.e("canReceiveDamage " + f3 + " " + enemy.getHealth() + " " + f1 + " " + f2 + " " + enemy, new Object[0]);
/*      */               
/*      */               return true;
/*      */             } 
/*      */             
/*      */             if (paramArrayOfboolean[0]) {
/*      */               DeathExplosionBuff deathExplosionBuff = new DeathExplosionBuff();
/*      */               
/*      */               GenericExplosion genericExplosion = (GenericExplosion)this.S.explosion.F.GENERIC.obtain();
/*      */               
/*      */               float f = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_GAUSS_A_OVERLOAD_DAMAGE);
/*      */               
/*      */               genericExplosion.setup(this, 0.0F, 0.0F, enemy.maxHealth * f, 1.0F, 0, 0.0F, 0.0F, MaterialColor.PURPLE.P400, null);
/*      */               
/*      */               deathExplosionBuff.setup(120.0F, 1200.0F, (Explosion)genericExplosion);
/*      */               
/*      */               this.S.buff.P_DEATH_EXPLOSION.addBuff(enemy, deathExplosionBuff);
/*      */               
/*      */               paramArrayOfboolean[0] = false;
/*      */             } 
/*      */             
/*      */             boolean bool = false;
/*      */             
/*      */             if (paramArrayOffloat1[0] <= f3) {
/*      */               paramArrayOffloat2[0] = (getTile()).center.dst(enemy.getPosition()) - 80.0F;
/*      */               
/*      */               this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, paramArrayOffloat1[0], DamageType.BULLET).setTower(this));
/*      */               bool = true;
/*      */             } else {
/*      */               this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, f3, DamageType.BULLET).setTower(this));
/*      */               enemy = paramEnemyReference.enemy;
/*      */               paramArrayOffloat1[0] = paramArrayOffloat1[0] - f3;
/*      */               if (isAbilityInstalled(4)) {
/*      */                 a(enemy);
/*      */               }
/*      */             } 
/*      */             return !bool;
/*      */           } 
/*      */           return true;
/*      */         });
/*  288 */     if (bool)
/*      */     {
/*  290 */       this.S.map.rayCastEnemies((getTile()).center.x, (getTile()).center.y, vector2.x, vector2.y, 128.0F * f, paramEnemyReference -> {
/*      */             Enemy enemy;
/*      */             
/*      */             if ((enemy = paramEnemyReference.enemy) != null && enemy.getHealth() > 0.0F && canAttackEnemy(enemy) && !enemy.wasStunnedByGauss) {
/*      */               float f;
/*      */               
/*      */               if ((f = enemy.getBuffedDamageMultiplier(TowerType.GAUSS, DamageType.BULLET)) == 0.0F) {
/*      */                 return true;
/*      */               }
/*      */               
/*      */               if (enemy.canBeBuffed(BuffType.STUN)) {
/*      */                 StunBuff stunBuff;
/*      */                 (stunBuff = new StunBuff()).copyDisabled = true;
/*      */                 enemy.wasStunnedByGauss = true;
/*      */                 float f1 = i();
/*      */                 stunBuff.setup(f1, f1 * 10.0F, this.id);
/*      */                 this.S.buff.P_STUN.addBuff(enemy, stunBuff);
/*      */                 paramArrayOfint[0] = paramArrayOfint[0] + 1;
/*      */                 this.S.achievement.setProgress(AchievementType.MASS_STUN_ENEMIES_ONE_SHOT, paramArrayOfint[0]);
/*      */               } 
/*      */             } 
/*      */             return true;
/*      */           });
/*      */     }
/*  314 */     this.shotCount++;
/*      */     
/*  316 */     if (!this.S.gameState.canSkipMediaUpdate()) {
/*  317 */       if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*      */         
/*  319 */         vector2.set((getTile()).center);
/*  320 */         ParticleEffectPool.PooledEffect pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.F.GAUSS.g.obtain();
/*  321 */         PMath.shiftPointByAngle(vector2, this.angle, 80.0F);
/*      */         
/*  323 */         pooledEffect.setPosition(vector2.x, vector2.y);
/*  324 */         ((ParticleEmitter)pooledEffect.getEmitters().get(0)).getAngle().setHigh(this.angle + 90.0F);
/*  325 */         ((ParticleEmitter)pooledEffect.getEmitters().get(1)).getAngle().setHigh(this.angle - 15.0F + 90.0F, this.angle + 15.0F + 90.0F);
/*  326 */         ((ParticleEmitter)pooledEffect.getEmitters().get(1)).getAngle().setLow(this.angle + 90.0F);
/*  327 */         ((ParticleEmitter)pooledEffect.getEmitters().get(0)).getRotation().setHigh(this.angle);
/*      */         
/*  329 */         this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*      */ 
/*      */         
/*  332 */         Trail trail = (Trail)Pools.obtain(Trail.class);
/*      */         Vector2 vector21;
/*  334 */         (vector21 = new Vector2()).set(0.0F, 1.0F).rotateDeg(this.angle).scl(arrayOfFloat1[0]).add(vector2);
/*  335 */         Trail.a(trail, vector2.x, vector2.y, vector21.x, vector21.y);
/*  336 */         this.v.add(trail);
/*      */       } 
/*      */       
/*  339 */       if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*      */         
/*  341 */         BulletSmokeMultiLine bulletSmokeMultiLine = (BulletSmokeMultiLine)Game.i.shapeManager.F.BULLET_SMOKE_MULTI_LINE.obtain();
/*  342 */         PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, this.angle, 80.0F, vector2);
/*  343 */         bulletSmokeMultiLine.setTexture(Game.i.towerManager.F.GAUSS.e, false, (FastRandom.getFloat() < 0.5F));
/*  344 */         bulletSmokeMultiLine.maxSegmentWidth = 23.04F;
/*  345 */         bulletSmokeMultiLine.maxAlpha = 1.0F;
/*  346 */         bulletSmokeMultiLine.setColor(MaterialColor.PURPLE.P500);
/*      */         
/*  348 */         Vector2 vector21 = new Vector2();
/*  349 */         PMath.getPointByAngleFromPoint(vector2.x, vector2.y, this.angle, arrayOfFloat1[0], vector21);
/*  350 */         bulletSmokeMultiLine.setup(vector2.x, vector2.y, vector21.x, vector21.y);
/*  351 */         this.S._projectileTrail.addTrail((ProjectileTrail)bulletSmokeMultiLine);
/*      */       } 
/*      */ 
/*      */       
/*  355 */       this.q.set(0.0F, 1.0F).scl(15.36F).rotateDeg(this.angle + 180.0F);
/*  356 */       this.p = 1.0F;
/*      */       
/*  358 */       if (this.S._sound != null) {
/*  359 */         this.S._sound.playShotSound(StaticSoundType.SHOT_GAUSS, this);
/*      */       }
/*      */     } 
/*      */     
/*  363 */     this.f = 0.0F;
/*  364 */     this.k -= getStat(TowerStatType.RESOURCE_CONSUMPTION);
/*  365 */     if (this.k < 0.0F) {
/*  366 */       this.k = 0.0F;
/*      */     }
/*  368 */     this.l = 0.0F;
/*  369 */     this.m = false;
/*  370 */     this.g = true;
/*  371 */     this.o++;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void attack(int paramInt) {
/*  376 */     for (byte b = 0; b < paramInt; b++) {
/*  377 */       f();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private float g() {
/*      */     float f;
/*  385 */     return (f = this.S.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_IMPROVEMENT_XP)) + this.j * this.S.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_IMPROVEMENT_XP_PER_LEVEL);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void addExperience(float paramFloat) {
/*  390 */     if (isAbilityInstalled(1)) {
/*  391 */       float f1 = g();
/*      */       
/*  393 */       float f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_GAUSS_A_IMPROVEMENT_BURN);
/*  394 */       f2 = paramFloat * f2;
/*      */       
/*  396 */       this.i += f2;
/*  397 */       while (this.i >= f1) {
/*      */         
/*  399 */         this.j++;
/*  400 */         this.i -= f1;
/*      */         
/*  402 */         this.S.map.markTilesDirtyNearTile((Tile)getTile(), 1);
/*      */       } 
/*      */       
/*  405 */       super.addExperience(paramFloat - f2); return;
/*      */     } 
/*  407 */     super.addExperience(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final float calculateStat(TowerStatType paramTowerStatType) {
/*  413 */     float f = super.calculateStat(paramTowerStatType);
/*      */     
/*  415 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_GAUSS_A_NANO_DAMAGE)); 
/*  416 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(1)) f = (float)(f * (1.0D + this.j * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_GAUSS_A_IMPROVEMENT_DAMAGE))); 
/*  417 */     if (paramTowerStatType == TowerStatType.RESOURCE_CONSUMPTION) {
/*  418 */       double d1 = this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_GAUSS_UPGRADE_RESOURCE_CONSUMPTION);
/*  419 */       double d2 = (Game.i.towerManager.getStatFromConfig(this.type, paramTowerStatType, 0, getLevel(), (GameValueProvider)this.S.gameValue) * this.S.gameValue.getGlobalStatMultiplier(paramTowerStatType));
/*  420 */       double d3 = f - d2;
/*  421 */       f = (float)(d2 + d3 * d1);
/*      */       
/*  423 */       if (isAbilityInstalled(2)) {
/*  424 */         f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_GAUSS_A_CONDUCTORS_RESOURCE_CONSUMPTION));
/*      */       }
/*      */     } 
/*  427 */     if (paramTowerStatType == TowerStatType.CHARGING_SPEED && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_GAUSS_A_CONDUCTORS_CHARGING_SPEED));
/*      */     
/*  429 */     return f;
/*      */   }
/*      */   
/*      */   private void h() {
/*  433 */     this.r.reset();
/*  434 */     this.r.setTextureRegion(Game.i.towerManager.F.GAUSS.d, false, false);
/*      */ 
/*      */ 
/*      */     
/*  438 */     u.set(1.0F, 1.0F, 1.0F, 0.0F);
/*  439 */     Vector2 vector21 = new Vector2();
/*  440 */     Vector2 vector22 = new Vector2();
/*  441 */     vector21.set((getTile()).center);
/*  442 */     vector22.set(0.0F, 64.0F);
/*  443 */     vector22.rotateDeg(this.angle);
/*      */     
/*  445 */     this.r.appendNode(vector21.x, vector21.y, 4.0F, u.toFloatBits(), false); byte b;
/*  446 */     for (b = 0; b < 16; b++) {
/*  447 */       u.a = (1.0F - (b + 1) / 16.0F) * 0.28F;
/*  448 */       vector21.add(vector22);
/*  449 */       this.r.appendNode(vector21.x, vector21.y, 4.0F, u.toFloatBits(), false);
/*      */     } 
/*  451 */     this.r.updateAllNodes();
/*      */ 
/*      */     
/*  454 */     if (this.s != this.h) {
/*  455 */       this.t.reset();
/*  456 */       this.t.setTextureRegion(Game.i.towerManager.F.GAUSS.d, false, false);
/*      */       
/*  458 */       u.set(MaterialColor.LIGHT_GREEN.P500);
/*  459 */       u.a = 0.0F;
/*  460 */       vector21.set((getTile()).center);
/*  461 */       vector22.set(0.0F, 64.0F);
/*  462 */       vector22.rotateDeg(this.h);
/*      */       
/*  464 */       this.t.appendNode(vector21.x, vector21.y, 4.0F, u.toFloatBits(), false);
/*  465 */       for (b = 0; b < 16; b++) {
/*  466 */         u.a = (1.0F - (b + 1) / 16.0F) * 0.28F;
/*  467 */         vector21.add(vector22);
/*  468 */         this.t.appendNode(vector21.x, vector21.y, 4.0F, u.toFloatBits(), false);
/*      */       } 
/*  470 */       this.t.updateAllNodes();
/*      */       
/*  472 */       this.s = this.h;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void drawWeapon(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  480 */     float f1 = paramFloat3 / 128.0F;
/*      */     
/*  482 */     float f2 = paramBatch.getColor().toFloatBits();
/*  483 */     if (!isOutOfOrder()) {
/*  484 */       Vector2 vector2 = new Vector2();
/*  485 */       if (this.p > 0.0F) {
/*      */         
/*  487 */         vector2.set(this.q).scl(this.p);
/*  488 */         this.p -= paramFloat4;
/*      */       } 
/*      */       
/*  491 */       getWeaponTextures().draw(paramBatch, paramFloat1 + vector2.x * f1, paramFloat2 + vector2.y * f1, 128.0F * f1, 128.0F * f1, 1.0F, 1.0F, this.angle);
/*      */       
/*  493 */       byte b1 = isAbilityInstalled(0) ? 5 : 4;
/*      */       
/*  495 */       float f = this.f / 100.0F;
/*  496 */       for (byte b2 = 0; b2 < b1; b2++) {
/*      */         
/*  498 */         float f3 = 1.0F / b1 * b2;
/*  499 */         if (f > f3 && (
/*      */ 
/*      */           
/*  502 */           f3 = (f - f3) * b1) > 0.0F) {
/*  503 */           if (f3 > 1.0F) {
/*  504 */             f3 = 1.0F;
/*      */           }
/*      */           
/*  507 */           paramBatch.setColor(1.0F, 1.0F, 1.0F, f3);
/*  508 */           paramBatch.draw(Game.i.towerManager.F.GAUSS.c, paramFloat1 + paramFloat3 * 0.5F - (18.0F + vector2.x) * f1, paramFloat2 + paramFloat3 * 0.5F + ((15 + b2 * 12) + vector2.y) * f1, 18.0F * f1, (-15 - b2 * 12) * f1, 36.0F * f1, 24.0F * f1, 1.0F, 1.0F, this.angle);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  523 */       paramBatch.setPackedColor(f2);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static double getResourceChargeValue(ResourceType paramResourceType) {
/*  528 */     return 1.0D + paramResourceType.ordinal() * 0.25D;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void update(float paramFloat) {
/*  533 */     if (!isOutOfOrder()) {
/*  534 */       float f1 = getStat(TowerStatType.RESOURCE_CONSUMPTION);
/*  535 */       float f2 = getStat(TowerStatType.ROTATION_SPEED);
/*      */       
/*  537 */       if (this.f == 0.0F && (this.k == 0.0F || f1 == 0.0F || this.g)) {
/*      */         
/*  539 */         if (this.angle != this.h)
/*      */         {
/*  541 */           rotateToAngle(this.h, paramFloat, f2);
/*      */         }
/*      */         
/*  544 */         this.g = (this.angle != this.h);
/*      */       } else {
/*      */         
/*  547 */         this.g = false;
/*      */       } 
/*      */ 
/*      */       
/*  551 */       if (!this.g && this.k < f1) {
/*  552 */         double[] arrayOfDouble = { (f1 - this.k) };
/*  553 */         this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*      */               if (paramTile.type == TileType.SOURCE && ((SourceTile)paramTile).miner != null) {
/*      */                 Miner miner = ((SourceTile)paramTile).miner;
/*      */                 
/*      */                 ResourceType[] arrayOfResourceType;
/*      */                 
/*      */                 int i = (arrayOfResourceType = ResourceType.values).length;
/*      */                 
/*      */                 for (byte b = 0; b < i; b++) {
/*      */                   ResourceType resourceType = arrayOfResourceType[b];
/*      */                   int j;
/*      */                   if ((j = miner.minedResources[resourceType.ordinal()]) > 0) {
/*      */                     double d = getResourceChargeValue(resourceType);
/*      */                     int k = MathUtils.ceil((float)(paramArrayOfdouble[0] / d));
/*      */                     if (j < k) {
/*      */                       k = j;
/*      */                     }
/*      */                     this.S.miner.removeResources(miner, resourceType, k);
/*      */                     this.S.gameState.addLootIssuedPrizes(new ItemStack((Item)Item.D.F_RESOURCE.create(resourceType), k), 0.0F, 0.0F, -1);
/*      */                     this.k = (float)(this.k + k * d);
/*      */                     paramArrayOfdouble[0] = paramArrayOfdouble[0] - k * d;
/*      */                     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*      */                       if ((j = k) > 3) {
/*      */                         j = 3;
/*      */                       }
/*      */                       for (k = 0; k < j; k++) {
/*      */                         this.S._particle.addOrbParticle(Game.i.towerManager.F.GAUSS.f[resourceType.ordinal()], 18.0F, miner.getTile().getX(), miner.getTile().getY(), getTile().getX(), getTile().getY());
/*      */                       }
/*      */                     } 
/*      */                     if (paramArrayOfdouble[0] <= 0.0D) {
/*      */                       return false;
/*      */                     }
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */               return true;
/*      */             });
/*      */       } 
/*  591 */       if (!this.g) {
/*  592 */         if (this.k >= f1) {
/*      */           
/*  594 */           this.f += getStat(TowerStatType.CHARGING_SPEED) * paramFloat;
/*  595 */           if (this.f >= 100.0F) {
/*  596 */             this.f = 100.0F;
/*      */           }
/*      */         } else {
/*      */           
/*  600 */           this.f = 0.0F;
/*      */         } 
/*      */       }
/*      */       
/*  604 */       if (this.f == 100.0F) {
/*      */         
/*  606 */         if (!this.g)
/*      */         {
/*  608 */           if (this.m || this.angle != this.h) {
/*      */             
/*  610 */             this.l += paramFloat;
/*  611 */             f2 = this.S.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_SHOT_DELAY);
/*  612 */             if (this.l >= f2)
/*      */             {
/*  614 */               if (!this.attackDisabled) {
/*  615 */                 attack(1);
/*  616 */                 this.b = true;
/*      */               } 
/*      */             }
/*      */           } else {
/*  620 */             this.n += paramFloat;
/*  621 */             if (this.n > 0.08F) {
/*      */               
/*  623 */               Vector2 vector2 = (new Vector2(0.0F, 1.0F)).rotateDeg(this.angle).scl(7680.0F).add((getTile()).center);
/*  624 */               f1 = this.S.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_ENEMY_DETECT_RAY_WIDTH);
/*  625 */               this.S.map.rayCastEnemies((getTile()).center.x, (getTile()).center.y, vector2.x, vector2.y, 128.0F * f1, paramEnemyReference -> {
/*      */                     Enemy enemy;
/*      */                     
/*      */                     if ((enemy = paramEnemyReference.enemy) != null && canAttackEnemy(enemy)) {
/*      */                       this.m = true;
/*      */                       
/*      */                       if (this.S._sound != null && this.S.gameState.getGameSpeed() < 2.1D) {
/*      */                         this.S._sound.playShotSound(StaticSoundType.SHOT_GAUSS_CHARGE, this);
/*      */                       }
/*      */                       
/*      */                       return false;
/*      */                     } 
/*      */                     return true;
/*      */                   });
/*  639 */               this.n = 0.0F;
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } else {
/*      */         
/*  645 */         this.m = false;
/*  646 */         this.l = 0.0F;
/*      */       } 
/*      */     } 
/*      */     
/*  650 */     super.update(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/*  656 */     super.drawBatch(paramBatch, paramFloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void drawBatchAdditive(Batch paramBatch, float paramFloat) {
/*  661 */     if (this.r == null) {
/*  662 */       this.r = (MultiLine)Game.i.shapeManager.getFactory(ShapeType.MULTI_LINE).obtain();
/*  663 */       this.t = (MultiLine)Game.i.shapeManager.getFactory(ShapeType.MULTI_LINE).obtain();
/*      */     } 
/*  665 */     h();
/*  666 */     this.r.draw(paramBatch);
/*      */     
/*  668 */     if (this.angle != this.h) {
/*  669 */       this.t.draw(paramBatch);
/*      */     }
/*      */ 
/*      */     
/*  673 */     this.v.begin();
/*  674 */     for (byte b = 0; b < this.v.size; b++) {
/*      */       Trail trail;
/*  676 */       Trail.a(trail = ((Trail[])this.v.items)[b], paramBatch, paramFloat * this.S.gameState.getGameSpeed());
/*  677 */       if (Trail.a(trail)) {
/*  678 */         this.v.removeIndex(b);
/*  679 */         Pools.free(trail);
/*      */       } 
/*      */     } 
/*  682 */     this.v.end();
/*      */   }
/*      */   
/*      */   public final boolean hasCustomButton() {
/*  686 */     return true;
/*      */   }
/*      */   public final boolean isCustomButtonNeedMapPoint() {
/*  689 */     return true;
/*      */   }
/*      */   
/*      */   public final void customButtonAction(int paramInt1, int paramInt2) {
/*  693 */     this.h = PMath.getAngleBetweenPoints((getTile()).center.x, (getTile()).center.y, paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   public final float getTargetAngle() {
/*  697 */     return this.h;
/*      */   }
/*      */   
/*      */   public final void setTargetAngle(float paramFloat) {
/*  701 */     this.h = paramFloat;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void updateCustomButton(ComplexButton paramComplexButton, boolean paramBoolean) {
/*  706 */     paramComplexButton.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-crosshair"));
/*  707 */     if (paramBoolean) {
/*  708 */       paramComplexButton.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.WHITE);
/*  709 */       paramComplexButton.setText(Game.i.localeManager.i18n.get("tap_on_map")); return;
/*      */     } 
/*  711 */     paramComplexButton.setBackgroundColors(MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P900, MaterialColor.LIGHT_BLUE.P700, Color.WHITE);
/*  712 */     paramComplexButton.setText(Game.i.localeManager.i18n.get("rotate_button"));
/*      */   }
/*      */ 
/*      */   
/*      */   private float i() {
/*  717 */     float f1 = this.S.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_OVERLOAD_DURATION);
/*  718 */     float f2 = getUpgradeLevel() / 10.0F * 0.7F + 0.3F;
/*      */     
/*  720 */     return f1 * f2;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void fillTowerMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/*  725 */     float f2, f1 = getStat(TowerStatType.RESOURCE_CONSUMPTION);
/*      */     
/*  727 */     int i = 1;
/*  728 */     if (isAbilityInstalled(1)) {
/*  729 */       i = 32;
/*      */     }
/*  731 */     if (this.f == 100.0F) {
/*  732 */       i = i * 31 + 1;
/*      */     } else {
/*  734 */       i = i * 31 + 2;
/*      */     } 
/*  736 */     if (this.k >= f1) {
/*  737 */       i = i * 31 + 1;
/*      */     } else {
/*  739 */       i = i * 31 + 2;
/*      */     } 
/*      */     
/*  742 */     if (paramObjectMap.size == 0 || !paramObjectMap.get("state", Integer.valueOf(-1)).equals(Integer.valueOf(i))) {
/*      */       
/*  744 */       paramGroup.clear();
/*      */ 
/*      */       
/*  747 */       PieChartActor pieChartActor1 = new PieChartActor();
/*      */       
/*      */       Array array1;
/*  750 */       (array1 = new Array(PieChart.ChartEntryConfig.class)).add(new PieChart.ChartEntryConfig(
/*      */             
/*  752 */             (this.f == 100.0F) ? MaterialColor.LIGHT_GREEN.P500 : MaterialColor.BLUE.P500, 50.0F, 0.0F));
/*      */       
/*  754 */       array1.add(new PieChart.ChartEntryConfig(
/*      */             
/*  756 */             (this.f == 100.0F) ? MaterialColor.LIGHT_GREEN.P500 : MaterialColor.CYAN.P500, 20.0F, 0.0F));
/*      */       
/*  758 */       array1.add(new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.28F), 30.0F, 0.0F));
/*      */ 
/*      */ 
/*      */       
/*  762 */       pieChartActor1.setPosition(40.0F, 40.0F);
/*  763 */       pieChartActor1.setSize(64.0F, 64.0F);
/*  764 */       pieChartActor1.setSegmentCount(200);
/*  765 */       pieChartActor1.setConfigs(array1);
/*  766 */       paramGroup.addActor((Actor)pieChartActor1);
/*      */       
/*      */       Image image1;
/*  769 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("circle"))).setColor(new Color(724249599));
/*  770 */       image1.setSize(36.0F, 36.0F);
/*  771 */       image1.setPosition(54.0F, 54.0F);
/*  772 */       paramGroup.addActor((Actor)image1);
/*      */       
/*      */       Image image2;
/*  775 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-cubes-stacked-flame"))).setSize(24.0F, 24.0F);
/*  776 */       image2.setPosition(60.0F, 60.0F);
/*  777 */       paramGroup.addActor((Actor)image2);
/*      */       
/*      */       Label label2;
/*  780 */       (label2 = new Label("", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.BLUE.P500);
/*  781 */       label2.setPosition(120.0F, 78.0F);
/*  782 */       label2.setSize(100.0F, 18.0F);
/*  783 */       paramGroup.addActor((Actor)label2);
/*      */       
/*      */       Label label1;
/*  786 */       (label1 = new Label("", Game.i.assetManager.getLabelStyle(21))).setColor(new Color(1.0F, 1.0F, 1.0F, 0.56F));
/*  787 */       label1.setPosition(120.0F, 52.0F);
/*  788 */       label1.setSize(100.0F, 16.0F);
/*  789 */       paramGroup.addActor((Actor)label1);
/*      */       
/*  791 */       if (this.k < f1) {
/*  792 */         label1.setText("Loading resources");
/*  793 */         image2.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-cubes-stacked-flame"));
/*  794 */       } else if (this.f == 100.0F) {
/*  795 */         label1.setText("Waiting for target");
/*  796 */         image2.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-crosshair"));
/*      */       } else {
/*  798 */         label1.setText("Recharging");
/*  799 */         image2.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-battery"));
/*      */       } 
/*      */ 
/*      */       
/*  803 */       if (isAbilityInstalled(1)) {
/*  804 */         PieChartActor pieChartActor2 = new PieChartActor();
/*      */         Array array2;
/*  806 */         (array2 = new Array(PieChart.ChartEntryConfig.class)).add(new PieChart.ChartEntryConfig(MaterialColor.AMBER.P500, 20.0F, 0.0F));
/*      */ 
/*      */ 
/*      */         
/*  810 */         array2.add(new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.28F), 30.0F, 0.0F));
/*      */ 
/*      */ 
/*      */         
/*  814 */         pieChartActor2.setPosition(302.0F, 40.0F);
/*  815 */         pieChartActor2.setSize(64.0F, 64.0F);
/*  816 */         pieChartActor2.setSegmentCount(200);
/*  817 */         pieChartActor2.setConfigs(array2);
/*  818 */         paramGroup.addActor((Actor)pieChartActor2);
/*      */ 
/*      */         
/*  821 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("circle"))).setColor(new Color(724249599));
/*  822 */         image1.setSize(36.0F, 36.0F);
/*  823 */         image1.setPosition(316.0F, 54.0F);
/*  824 */         paramGroup.addActor((Actor)image1);
/*      */         
/*      */         Label label4;
/*  827 */         (label4 = new Label("XP", Game.i.assetManager.getLabelStyle(21))).setSize(36.0F, 36.0F);
/*  828 */         label4.setAlignment(1);
/*  829 */         label4.setPosition(316.0F, 54.0F);
/*  830 */         paramGroup.addActor((Actor)label4);
/*      */         
/*      */         Label label3;
/*  833 */         (label3 = new Label("", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.RED.P500);
/*  834 */         label3.setPosition(382.0F, 78.0F);
/*  835 */         label3.setSize(100.0F, 18.0F);
/*  836 */         paramGroup.addActor((Actor)label3);
/*      */ 
/*      */         
/*  839 */         (label4 = new Label(Game.i.localeManager.i18n.get("bonus_damage"), Game.i.assetManager.getLabelStyle(21))).setColor(new Color(1.0F, 1.0F, 1.0F, 0.56F));
/*  840 */         label4.setPosition(382.0F, 52.0F);
/*  841 */         label4.setSize(100.0F, 16.0F);
/*  842 */         paramGroup.addActor((Actor)label4);
/*      */         
/*  844 */         paramObjectMap.put("xpChart", pieChartActor2);
/*  845 */         paramObjectMap.put("xpTitle", label3);
/*      */       } 
/*      */       
/*  848 */       paramObjectMap.put("state", Integer.valueOf(i));
/*  849 */       paramObjectMap.put("chargingChart", pieChartActor1);
/*  850 */       paramObjectMap.put("chargingTitle", label2);
/*      */     } 
/*      */ 
/*      */     
/*  854 */     Label label = (Label)paramObjectMap.get("chargingTitle");
/*  855 */     if (this.f == 0.0F) {
/*      */       
/*  857 */       int j = (int)this.k;
/*  858 */       int k = (int)(this.k % 1.0F * 10.0F);
/*  859 */       d.setLength(0);
/*  860 */       d.append(j).append('.').append(k).append(" / ").append(f1);
/*  861 */       label.setText((CharSequence)d);
/*  862 */       label.setColor(MaterialColor.BLUE.P500);
/*  863 */     } else if (this.f == 100.0F) {
/*      */       
/*  865 */       label.setText(Game.i.localeManager.i18n.get("tower_status_charged"));
/*  866 */       label.setColor(MaterialColor.LIGHT_GREEN.P500);
/*      */     }
/*      */     else {
/*      */       
/*  870 */       int j = (int)(f2 = (100.0F - this.f) / getStat(TowerStatType.CHARGING_SPEED));
/*  871 */       int k = (int)(f2 % 1.0F * 10.0F);
/*  872 */       d.setLength(0);
/*  873 */       d.append(j).append('.').append(k).append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/*  874 */       label.setText((CharSequence)d);
/*  875 */       label.setColor(MaterialColor.CYAN.P500);
/*      */     } 
/*      */ 
/*      */     
/*  879 */     if (f1 <= 0.0F)
/*      */     
/*  881 */     { f2 = 1.0F;
/*      */        }
/*      */     
/*  884 */     else if ((f2 = this.k / f1) > 1.0F) { f2 = 1.0F; }
/*      */ 
/*      */     
/*      */     float f3;
/*  888 */     if ((f3 = this.f / 100.0F) > 1.0F) f3 = 1.0F;
/*      */     
/*      */     PieChartActor pieChartActor;
/*      */     Array array;
/*  892 */     ((PieChart.ChartEntryConfig)(array = (pieChartActor = (PieChartActor)paramObjectMap.get("chargingChart")).getConfigs()).get(0)).setValue(f2 * 50.0F);
/*  893 */     ((PieChart.ChartEntryConfig)array.get(1)).setValue(f3 * 50.0F);
/*  894 */     ((PieChart.ChartEntryConfig)array.get(2)).setValue(100.0F - ((PieChart.ChartEntryConfig)array.get(0)).getValue() - ((PieChart.ChartEntryConfig)array.get(1)).getValue());
/*  895 */     pieChartActor.setConfigs(array);
/*      */ 
/*      */     
/*  898 */     if (isAbilityInstalled(1)) {
/*      */       PieChartActor pieChartActor1;
/*      */       Array array1;
/*  901 */       ((PieChart.ChartEntryConfig)(array1 = (pieChartActor1 = (PieChartActor)paramObjectMap.get("xpChart")).getConfigs()).get(0)).setValue(this.i / g());
/*  902 */       if (((PieChart.ChartEntryConfig)array1.get(0)).getValue() > 1.0F) ((PieChart.ChartEntryConfig)array1.get(0)).setValue(1.0F); 
/*  903 */       ((PieChart.ChartEntryConfig)array1.get(1)).setValue(1.0F - ((PieChart.ChartEntryConfig)array1.get(0)).getValue());
/*  904 */       pieChartActor1.setConfigs(array1);
/*      */       
/*  906 */       Label label1 = (Label)paramObjectMap.get("xpTitle");
/*  907 */       d.setLength(0);
/*  908 */       int j = MathUtils.round(this.j * this.S.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_IMPROVEMENT_DAMAGE));
/*  909 */       d.append(j).append("%");
/*  910 */       label1.setText((CharSequence)d);
/*      */     } 
/*      */     
/*  913 */     super.fillTowerMenu(paramGroup, paramObjectMap);
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnEnemyDie extends SerializableListener<GameSystemProvider> implements Listener<EnemyDie> {
/*      */     private OnEnemyDie() {}
/*      */     
/*      */     public OnEnemyDie(GameSystemProvider param1GameSystemProvider) {
/*  921 */       this.a = param1GameSystemProvider;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*      */       Tower tower;
/*      */       DamageRecord damageRecord;
/*  928 */       if (tower = (damageRecord = param1EnemyDie.getLastDamage()).getTower() instanceof GaussTower && tower.isAbilityInstalled(4)) {
/*  929 */         GaussTower.a((GaussTower)tower, param1EnemyDie.getLastDamage().getEnemy());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static class GaussTowerFactory
/*      */     extends Tower.Factory<GaussTower>
/*      */   {
/*      */     TextureRegion c;
/*      */     TextureRegion d;
/*      */     TextureRegion e;
/*  940 */     TextureRegion[] f = new TextureRegion[ResourceType.values.length];
/*      */     
/*      */     ParticleEffectPool g;
/*      */     
/*      */     public GaussTowerFactory() {
/*  945 */       super("tower-gauss", TowerType.GAUSS);
/*      */     }
/*      */ 
/*      */     
/*      */     public void setup() {
/*  950 */       super.setup();
/*      */       
/*  952 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "2", "10" };
/*  953 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "", "", "", "" };
/*  954 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "50", "5" };
/*  955 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "5", "10", "10" };
/*  956 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "" };
/*      */     }
/*      */     
/*      */     @Null
/*      */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/*  961 */       if (param1TowerStatType == TowerStatType.RESOURCE_CONSUMPTION) {
/*  962 */         GaussTower.a().setLength(0);
/*  963 */         GaussTower.b().append(Game.i.localeManager.i18n.get("tower_stat_more_info_GAUSS_RESOURCE_CONSUMPTION")).append("\n"); ResourceType[] arrayOfResourceType; int i; byte b;
/*  964 */         for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/*  965 */           GaussTower.c().append("[#").append(Game.i.resourceManager.getColor(resourceType).toString()).append("]").append(Game.i.resourceManager.getName(resourceType)).append("[]").append(": ").append(StringFormatter.compactNumber(GaussTower.getResourceChargeValue(resourceType), true)).append("\n"); b++; }
/*      */         
/*  967 */         return (CharSequence)GaussTower.d();
/*      */       } 
/*  969 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void configureSystems(GameSystemProvider param1GameSystemProvider) {
/*  975 */       param1GameSystemProvider.events.getListeners(EnemyDie.class).addStateAffecting(new GaussTower.OnEnemyDie(param1GameSystemProvider));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*      */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/*  982 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_GAUSS_A_NANO_DAMAGE), 2, true).toString();
/*  983 */       (arrayOfAbilityConfig[0]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_NANO_HP), 2, true).toString();
/*  984 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_IMPROVEMENT_BURN), 2, true).toString();
/*  985 */       (arrayOfAbilityConfig[1]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_IMPROVEMENT_DAMAGE), 2, true).toString();
/*  986 */       (arrayOfAbilityConfig[1]).descriptionArgs[2] = StringFormatter.commaSeparatedNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_GAUSS_A_IMPROVEMENT_XP)).toString();
/*  987 */       (arrayOfAbilityConfig[1]).descriptionArgs[3] = StringFormatter.commaSeparatedNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_GAUSS_A_IMPROVEMENT_XP_PER_LEVEL)).toString();
/*  988 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros((1.0D - param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_GAUSS_A_CONDUCTORS_RESOURCE_CONSUMPTION)) * 100.0D, 2, true).toString();
/*  989 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros((param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_CONDUCTORS_CHARGING_SPEED) - 100.0F), 2, true).toString();
/*  990 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_GAUSS_A_OVERLOAD_SHOTS), false).toString();
/*      */       
/*  992 */       float f = GaussTower.a((GaussTower)param1Tower);
/*  993 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(f, 1, true).toString();
/*  994 */       (arrayOfAbilityConfig[3]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_OVERLOAD_DAMAGE), 2, true).toString();
/*  995 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_GAUSS_A_ULTIMATE_MINING_TIME), 2, true).toString();
/*      */       
/*  997 */       return arrayOfAbilityConfig;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 1003 */       if (param1Int == 0) {
/* 1004 */         return false;
/*      */       }
/* 1006 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setupAssets() {
/* 1011 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("tower-gauss-weapon-glow");
/*      */       
/* 1013 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("dashed-line");
/*      */       
/* 1015 */       this.e = (TextureRegion)Game.i.assetManager.getTextureRegion("bullet-trace-smoke");
/*      */ 
/*      */       
/*      */       ParticleEffect particleEffect;
/*      */ 
/*      */       
/* 1021 */       (particleEffect = new ParticleEffect()).load(Gdx.files.internal("particles/gauss-shot.prt"), Game.i.assetManager.getTextureRegion("particle-default").getAtlas());
/* 1022 */       particleEffect.setEmittersCleanUpBlendFunction(false);
/*      */       
/* 1024 */       this.g = Game.i.assetManager.getParticleEffectPool("gauss-shot.prt"); ResourceType[] arrayOfResourceType; int i;
/*      */       byte b;
/* 1026 */       for (i = (arrayOfResourceType = ResourceType.values).length, b = 0; b < i; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 1027 */         this.f[resourceType.ordinal()] = (TextureRegion)Game.i.assetManager.getTextureRegion("resource-orb-" + resourceType.name().toLowerCase(Locale.ENGLISH));
/*      */         b++; }
/*      */     
/*      */     }
/*      */     public Color getColor() {
/* 1032 */       return MaterialColor.AMBER.P500;
/*      */     }
/*      */     
/*      */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 1036 */       switch (GaussTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 1037 */           return 5;
/* 1038 */         case 2: return 1;
/* 1039 */         case 3: return 5;
/* 1040 */         case 4: return 4;
/* 1041 */         case 5: return 1; }
/* 1042 */        return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String[] getAbilityAliases() {
/* 1048 */       return GaussTower.ABILITY_ALIASES;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getBuildHotKey() {
/* 1053 */       return 51;
/*      */     }
/*      */ 
/*      */     
/*      */     public GaussTower create() {
/* 1058 */       return new GaussTower((byte)0);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Trail
/*      */   {
/*      */     private float a;
/*      */     
/*      */     private float b;
/*      */     
/*      */     private float c;
/*      */     
/* 1071 */     private Vector2 d = new Vector2();
/* 1072 */     private Vector2 e = new Vector2();
/* 1073 */     private Vector2 f = new Vector2();
/*      */     
/*      */     private TextureRegion g;
/* 1076 */     private float[] h = new float[0];
/*      */     private int i;
/*      */     private int j;
/* 1079 */     private float[] k = new float[0];
/* 1080 */     private float[] l = new float[0];
/*      */ 
/*      */ 
/*      */     
/*      */     private void a(float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
/* 1085 */       this.d.set(param1Float3, param1Float4).sub(param1Float1, param1Float2).nor();
/* 1086 */       this.e.set(param1Float3, param1Float4).sub(param1Float1, param1Float2);
/* 1087 */       this.f.set(this.d).rotate90(-1).scl(4.0F);
/*      */       
/* 1089 */       this.a = PMath.getAngleBetweenPoints(param1Float1, param1Float2, param1Float3, param1Float4);
/* 1090 */       this.c = 0.0F;
/*      */ 
/*      */       
/* 1093 */       this.g = (TextureRegion)Game.i.assetManager.getTextureRegion("particle-default-long");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1104 */       float f6 = MathUtils.cosDeg(this.a);
/* 1105 */       float f7 = MathUtils.sinDeg(this.a);
/* 1106 */       float f1 = f6 * -4.8F - f7 * -19.2F;
/* 1107 */       float f2 = f7 * -4.8F + f6 * -19.2F;
/* 1108 */       float f3 = f6 * -4.8F - f7 * 19.2F;
/* 1109 */       float f4 = f7 * -4.8F + f6 * 19.2F;
/* 1110 */       float f5 = f6 * 4.8F - f7 * 19.2F;
/* 1111 */       f6 = f7 * 4.8F + f6 * 19.2F;
/* 1112 */       f7 = f1 + f5 - f3;
/* 1113 */       float f8 = f6 - f4 - f2;
/* 1114 */       f1 += 4.8F;
/*      */       
/* 1116 */       f3 += 4.8F;
/*      */       
/* 1118 */       f5 += 4.8F;
/*      */       
/* 1120 */       f7 += 4.8F;
/*      */       
/* 1122 */       float f9 = this.g.getU();
/* 1123 */       float f10 = this.g.getV2();
/* 1124 */       float f11 = this.g.getU2();
/* 1125 */       float f12 = this.g.getV();
/* 1126 */       float f13 = Color.ORANGE.toFloatBits();
/*      */       
/*      */       float[] arrayOfFloat;
/*      */       
/* 1130 */       (arrayOfFloat = new float[20])[0] = f1;
/* 1131 */       arrayOfFloat[1] = f2;
/* 1132 */       arrayOfFloat[2] = f13;
/* 1133 */       arrayOfFloat[3] = f9;
/* 1134 */       arrayOfFloat[4] = f10;
/* 1135 */       arrayOfFloat[5] = f3;
/* 1136 */       arrayOfFloat[6] = f4;
/* 1137 */       arrayOfFloat[7] = f13;
/* 1138 */       arrayOfFloat[8] = f9;
/* 1139 */       arrayOfFloat[9] = f12;
/* 1140 */       arrayOfFloat[10] = f5;
/* 1141 */       arrayOfFloat[11] = f6;
/* 1142 */       arrayOfFloat[12] = f13;
/* 1143 */       arrayOfFloat[13] = f11;
/* 1144 */       arrayOfFloat[14] = f12;
/* 1145 */       arrayOfFloat[15] = f7;
/* 1146 */       arrayOfFloat[16] = f8;
/* 1147 */       arrayOfFloat[17] = f13;
/* 1148 */       arrayOfFloat[18] = f11;
/* 1149 */       arrayOfFloat[19] = f10;
/*      */ 
/*      */       
/* 1152 */       this.b = PMath.getDistanceBetweenPoints(param1Float1, param1Float2, param1Float3, param1Float4);
/* 1153 */       this.j = MathUtils.ceil(this.b / 128.0F * 18.0F);
/* 1154 */       this.i = this.j * 20;
/* 1155 */       if (this.h.length < this.i) {
/* 1156 */         this.h = new float[MathUtils.nextPowerOfTwo(this.i)];
/*      */       }
/* 1158 */       if (this.k.length < this.j) {
/* 1159 */         this.k = new float[MathUtils.nextPowerOfTwo(this.j)];
/* 1160 */         this.l = new float[MathUtils.nextPowerOfTwo(this.j)];
/*      */       } 
/*      */       
/* 1163 */       byte b1 = 0;
/* 1164 */       for (byte b2 = 0; b2 < this.j; b2++) {
/* 1165 */         f1 = FastRandom.getFloat();
/* 1166 */         GaussTower.e().set(-12582657).lerp(0.2F, 0.0F, 1.0F, 1.0F, f1);
/* 1167 */         f2 = GaussTower.e().toFloatBits();
/*      */         
/* 1169 */         f3 = FastRandom.getFloat() * 2.0F - 1.0F;
/* 1170 */         f4 = this.f.x * f3;
/* 1171 */         f3 = this.f.y * f3;
/*      */         
/* 1173 */         f4 = param1Float1 + this.e.x * f1 + f4;
/* 1174 */         f3 = param1Float2 + this.e.y * f1 + f3;
/*      */         
/* 1176 */         byte b3 = 0;
/* 1177 */         for (byte b4 = 0; b4 < 4; b4++) {
/* 1178 */           this.h[b1++] = arrayOfFloat[b3++] + f4;
/* 1179 */           this.h[b1++] = arrayOfFloat[b3++] + f3;
/* 1180 */           this.h[b1++] = f2; b3++;
/* 1181 */           this.h[b1++] = arrayOfFloat[b3++];
/* 1182 */           this.h[b1++] = arrayOfFloat[b3++];
/*      */         } 
/*      */         
/* 1185 */         this.k[b2] = 8000.0F * (FastRandom.getFloat() * 0.9F + 0.1F);
/* 1186 */         this.l[b2] = f1 * this.b;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void a(Batch param1Batch, float param1Float) {
/*      */       float f;
/* 1194 */       if ((f = this.c / 0.6F) < 0.04F) {
/* 1195 */         f /= 0.04F;
/*      */       } else {
/* 1197 */         f = 1.0F - f - 0.041666668F;
/*      */       } 
/*      */       
/* 1200 */       for (byte b = 0; b < this.j; b++) {
/* 1201 */         float f1 = this.d.x * param1Float * this.k[b];
/* 1202 */         float f2 = this.d.y * param1Float * this.k[b];
/* 1203 */         this.l[b] = this.l[b] + param1Float * this.k[b];
/*      */         
/* 1205 */         float f3 = 0.0F;
/* 1206 */         if (this.l[b] < this.b) {
/* 1207 */           GaussTower.e().set(NumberUtils.floatToIntColor(this.h[b * 20 + 2]));
/* 1208 */           (GaussTower.e()).a = f;
/* 1209 */           f3 = GaussTower.e().toFloatBits();
/*      */         } 
/*      */         
/* 1212 */         for (byte b1 = 0; b1 < 4; b1++) {
/* 1213 */           int i = b * 20 + b1 * 5;
/* 1214 */           this.h[i] = this.h[i] + f1;
/* 1215 */           this.h[i + 1] = this.h[i + 1] + f2;
/* 1216 */           this.h[i + 2] = f3;
/*      */         } 
/*      */       } 
/* 1219 */       param1Batch.draw(this.g.getTexture(), this.h, 0, this.i);
/*      */       
/* 1221 */       this.c += param1Float;
/*      */     }
/*      */     
/*      */     private boolean a() {
/* 1225 */       return (this.c >= 0.6F);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\GaussTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */