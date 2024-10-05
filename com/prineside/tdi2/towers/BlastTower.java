/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.buffs.StunBuff;
/*     */ import com.prineside.tdi2.buffs.ThrowBackBuff;
/*     */ import com.prineside.tdi2.buffs.VulnerabilityBuff;
/*     */ import com.prineside.tdi2.components.StunDebuffStats;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.LimitedParticleType;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.shapes.Circle;
/*     */ import com.prineside.tdi2.shapes.PieChart;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.PieChartActor;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.ObjectFilter;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class BlastTower
/*     */   extends Tower
/*     */ {
/*     */   public static final String TOWER_OUT_OF_ORDER_REASON_QUAKE = "BlastQuake";
/*     */   
/*     */   @REGS
/*     */   public enum State
/*     */   {
/*  67 */     NORMAL,
/*  68 */     QUAKING; static {
/*     */     
/*  70 */     } public static final State[] values = values();
/*     */   }
/*     */   
/*  73 */   public static final String[] ABILITY_ALIASES = new String[] { "HEAVY_SHELL", "FAST_MECHANISM", "SONIC_WAVE" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   private static final Color e = new Color(1163551999);
/*     */   
/*     */   @NAGS
/*     */   private Circle f;
/*  83 */   private State g = State.NORMAL;
/*  84 */   private float h = 0.0F;
/*  85 */   private float i = 0.0F;
/*  86 */   private float j = 0.0F;
/*  87 */   private Array<Enemy.EnemyReference> k = new Array(true, 1, Enemy.EnemyReference.class);
/*     */   
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte l;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  94 */     super.write(paramKryo, paramOutput);
/*  95 */     paramKryo.writeObject(paramOutput, this.g);
/*  96 */     paramOutput.writeFloat(this.j);
/*  97 */     paramOutput.writeFloat(this.h);
/*  98 */     paramOutput.writeFloat(this.i);
/*  99 */     paramKryo.writeObject(paramOutput, this.k);
/* 100 */     paramOutput.writeByte(this.l);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 105 */     super.read(paramKryo, paramInput);
/* 106 */     this.g = (State)paramKryo.readObject(paramInput, State.class);
/* 107 */     this.j = paramInput.readFloat();
/* 108 */     this.h = paramInput.readFloat();
/* 109 */     this.i = paramInput.readFloat();
/* 110 */     this.k = (Array<Enemy.EnemyReference>)paramKryo.readObject(paramInput, Array.class);
/* 111 */     this.l = paramInput.readByte();
/*     */   }
/*     */   
/*     */   private BlastTower() {
/* 115 */     super(TowerType.BLAST);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/* 120 */     super.setUnregistered();
/*     */     
/* 122 */     this.k.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/* 127 */     if (isAbilityInstalled(0)) {
/* 128 */       return Game.i.towerManager.F.BLAST.getAbilityTextures(0);
/*     */     }
/* 130 */     return Game.i.towerManager.F.BLAST.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/* 138 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 143 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 150 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 152 */     if (paramTowerStatType == TowerStatType.U_STUN_DURATION && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_SONIC_WAVE_DURATION)); 
/* 153 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_HEAVY_SHELL_DAMAGE)); 
/* 154 */     if (paramTowerStatType == TowerStatType.ATTACK_SPEED && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_HEAVY_SHELL_SPEED)); 
/* 155 */     if (paramTowerStatType == TowerStatType.ATTACK_SPEED && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_FAST_MECHANISM_SPEED)); 
/* 156 */     if (paramTowerStatType == TowerStatType.STUN_CHANCE && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_HEAVY_SHELL_CHANCE));
/*     */     
/* 158 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateCache() {
/* 163 */     super.updateCache();
/*     */     
/* 165 */     if (this.f != null && getTile() != null) {
/* 166 */       float f1 = this.f.getInnerColor();
/* 167 */       float f2 = this.f.getOuterColor();
/* 168 */       this.f.setup((getTile()).center.x, (getTile()).center.y, this.rangeInPixels * 0.5F, this.rangeInPixels, 48, f1, f2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fillTowerMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/* 178 */     if (paramObjectMap.size == 0 || !paramObjectMap.get("state", Integer.valueOf(-1)).equals(Integer.valueOf(1))) {
/*     */       
/* 180 */       paramGroup.clear();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 185 */       PieChartActor pieChartActor1 = new PieChartActor();
/*     */       Array array1;
/* 187 */       (array1 = new Array(PieChart.ChartEntryConfig.class)).add(new PieChart.ChartEntryConfig(MaterialColor.AMBER.P500, 20.0F, 0.0F));
/*     */ 
/*     */ 
/*     */       
/* 191 */       array1.add(new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.28F), 30.0F, 0.0F));
/*     */ 
/*     */ 
/*     */       
/* 195 */       pieChartActor1.setPosition(40.0F, 0.0F);
/* 196 */       pieChartActor1.setSize(64.0F, 64.0F);
/* 197 */       pieChartActor1.setSegmentCount(200);
/* 198 */       pieChartActor1.setConfigs(array1);
/* 199 */       paramGroup.addActor((Actor)pieChartActor1);
/*     */       
/*     */       Image image2;
/* 202 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("circle"))).setColor(new Color(724249599));
/* 203 */       image2.setSize(36.0F, 36.0F);
/* 204 */       image2.setPosition(54.0F, 14.0F);
/* 205 */       paramGroup.addActor((Actor)image2);
/*     */       
/*     */       Image image1;
/* 208 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-quake"))).setSize(28.0F, 28.0F);
/* 209 */       image1.setPosition(58.0F, 18.0F);
/* 210 */       paramGroup.addActor((Actor)image1);
/*     */       
/*     */       Label label1;
/* 213 */       (label1 = new Label("", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.ORANGE.P500);
/* 214 */       label1.setPosition(120.0F, 38.0F);
/* 215 */       label1.setSize(100.0F, 18.0F);
/* 216 */       paramGroup.addActor((Actor)label1);
/*     */       
/*     */       Label label2;
/* 219 */       (label2 = new Label(Game.i.localeManager.i18n.get("quake_charge"), Game.i.assetManager.getLabelStyle(21))).setColor(new Color(1.0F, 1.0F, 1.0F, 0.56F));
/* 220 */       label2.setPosition(120.0F, 12.0F);
/* 221 */       label2.setSize(100.0F, 16.0F);
/* 222 */       paramGroup.addActor((Actor)label2);
/*     */       
/* 224 */       paramObjectMap.put("quakeChargeChart", pieChartActor1);
/* 225 */       paramObjectMap.put("chargeTitle", label1);
/*     */       
/* 227 */       paramObjectMap.put("state", Integer.valueOf(1));
/*     */     } 
/*     */     
/*     */     float f;
/*     */     
/* 232 */     if ((f = this.h / 100.0F) < 0.0F) {
/* 233 */       f = 0.0F;
/*     */     }
/* 235 */     Label label = (Label)paramObjectMap.get("chargeTitle");
/*     */     
/*     */     PieChartActor pieChartActor;
/*     */     Array array;
/* 239 */     ((PieChart.ChartEntryConfig)(array = (pieChartActor = (PieChartActor)paramObjectMap.get("quakeChargeChart")).getConfigs()).get(0)).setValue(f);
/* 240 */     if (this.h >= 100.0F) {
/* 241 */       ((PieChart.ChartEntryConfig)array.get(0)).color = MaterialColor.RED.P500;
/*     */     } else {
/* 243 */       ((PieChart.ChartEntryConfig)array.get(0)).color = MaterialColor.AMBER.P500;
/*     */     } 
/* 245 */     if (f > 1.0F) f = 1.0F; 
/* 246 */     ((PieChart.ChartEntryConfig)array.get(1)).setValue(1.0F - f);
/* 247 */     pieChartActor.setConfigs(array);
/*     */     
/* 249 */     if (this.h >= 100.0F) {
/* 250 */       label.setColor(MaterialColor.RED.P500);
/*     */     } else {
/* 252 */       label.setColor(MaterialColor.AMBER.P500);
/*     */     } 
/* 254 */     d.setLength(0);
/* 255 */     d.append(MathUtils.round(f * 100.0F));
/* 256 */     d.append("%");
/* 257 */     label.setText((CharSequence)d);
/*     */     
/* 259 */     super.fillTowerMenu(paramGroup, paramObjectMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawWeapon(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 264 */     if ((getTile()).visibleOnScreen && !isOutOfOrder()) {
/* 265 */       paramFloat4 = 0.0F;
/* 266 */       switch (null.a[this.g.ordinal()]) {
/*     */         case 1:
/* 268 */           if (this.j > getAttackDelay()) {
/*     */             
/* 270 */             paramFloat4 = 1.0F;
/*     */             break;
/*     */           } 
/* 273 */           paramFloat4 = 0.7F + this.j / getAttackDelay() * 0.3F;
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         case 2:
/* 279 */           if ((paramFloat4 = 1.0F + this.i / 2.0F * 0.6F) > 1.6F) {
/* 280 */             paramFloat4 = 1.6F;
/*     */           }
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 286 */       getWeaponTextures().draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4, 0.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   private float a() {
/* 291 */     float f1 = this.S.gameValue.getFloatValue(GameValueType.TOWER_BLAST_A_STOPPING_FORCE_MIN_DIST);
/* 292 */     float f2 = this.S.gameValue.getFloatValue(GameValueType.TOWER_BLAST_A_STOPPING_FORCE_MAX_DIST);
/* 293 */     return f1 + getUpgradeLevel() * 0.1F * (f2 - f1);
/*     */   }
/*     */   
/*     */   private float b() {
/* 297 */     float f1 = getUpgradeLevel() / 10.0F;
/* 298 */     float f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_STOPPING_FORCE_ULTIMATE_MIN);
/* 299 */     float f3 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_STOPPING_FORCE_ULTIMATE_MAX);
/*     */     
/* 301 */     return f2 + (f3 - f2) * f1;
/*     */   }
/*     */   
/*     */   private boolean a(Enemy paramEnemy, float paramFloat1, float paramFloat2) {
/* 305 */     if (paramEnemy == null) {
/* 306 */       return false;
/*     */     }
/*     */     
/*     */     StunDebuffStats stunDebuffStats;
/* 310 */     byte b = ((stunDebuffStats = paramEnemy.stunDebuffStats) == null) ? 0 : stunDebuffStats.getCountByTower(this.id);
/* 311 */     paramFloat1 *= StunBuff.STUN_CHANCE_PENALTY_SAME_TOWER[b];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 316 */     paramFloat2 = paramFloat2;
/* 317 */     if (b >= StunBuff.STUN_DURATION_BY_STUN_COUNT.length) {
/*     */       
/* 319 */       paramFloat1 = 0.0F;
/*     */     } else {
/* 321 */       paramFloat2 *= StunBuff.STUN_DURATION_BY_STUN_COUNT[b];
/*     */     } 
/*     */     
/* 324 */     b = 0;
/* 325 */     if (paramFloat1 != 0.0F && this.S.gameState.randomFloat() < paramFloat1) {
/*     */       
/* 327 */       StunBuff stunBuff = new StunBuff();
/* 328 */       float f = paramFloat2 * paramEnemy.getBuffVulnerability(BuffType.STUN);
/* 329 */       stunBuff.setup(f, f * 10.0F, this.id);
/* 330 */       if (this.S.buff.P_STUN.addBuff(paramEnemy, stunBuff)) {
/* 331 */         b = 1;
/*     */       }
/*     */     } 
/*     */     
/* 335 */     if (isAbilityInstalled(3)) {
/*     */       
/* 337 */       double d = this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_STOPPING_FORCE_CHANCE);
/* 338 */       if (this.S.gameState.randomFloat() < d) {
/* 339 */         paramFloat1 = a();
/*     */         ThrowBackBuff throwBackBuff;
/* 341 */         (throwBackBuff = new ThrowBackBuff()).setup(this.id, paramFloat1 * 2.0F, 0.5F, 10.0F);
/* 342 */         if (this.S.buff.P_THROW_BACK.addBuff(paramEnemy, throwBackBuff) && 
/* 343 */           isAbilityInstalled(4)) {
/* 344 */           paramFloat1 = b();
/*     */           VulnerabilityBuff vulnerabilityBuff;
/* 346 */           (vulnerabilityBuff = new VulnerabilityBuff()).setup(this.id, paramFloat1, 2.0F, 20.0F);
/* 347 */           this.S.buff.P_VULNERABILITY.addBuff(paramEnemy, vulnerabilityBuff);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 353 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 358 */     if (!isOutOfOrder()) {
/*     */       ParticleEmitter.GradientColorValue gradientColorValue;
/*     */       
/* 361 */       this.l = (byte)(this.l + 1);
/* 362 */       if (this.l == 4) {
/* 363 */         this.l = 0;
/*     */         
/* 365 */         this.k.clear();
/* 366 */         this.S.map.getEnemiesInCircleV((getTile()).center, this.rangeInPixels, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */               Enemy enemy;
/*     */               
/*     */               if ((enemy = paramEnemyReference.enemy) == null || !canAttackEnemy(enemy)) {
/*     */                 return true;
/*     */               }
/*     */               this.k.add(paramEnemyReference);
/*     */               return true;
/*     */             });
/*     */       } 
/* 376 */       boolean bool = isAbilityInstalled(2);
/* 377 */       switch (null.a[this.g.ordinal()]) {
/*     */         case 1:
/* 379 */           this.j += paramFloat;
/* 380 */           if (this.k.size != 0 || (bool && this.h >= 100.0F))
/*     */           {
/* 382 */             if (this.j >= getAttackDelay()) {
/*     */               
/* 384 */               if (this.h >= 100.0F) {
/*     */                 
/* 386 */                 this.g = State.QUAKING;
/* 387 */                 this.i = 0.0F;
/*     */                 break;
/*     */               } 
/* 390 */               boolean bool1 = false;
/* 391 */               float f1 = getStat(TowerStatType.DAMAGE);
/* 392 */               float f2 = getStat(TowerStatType.STUN_CHANCE) * 0.01F;
/* 393 */               float f3 = getStat(TowerStatType.U_STUN_DURATION);
/*     */               
/* 395 */               float f4 = this.rangeInPixels * this.rangeInPixels;
/* 396 */               byte b1 = 0;
/* 397 */               for (byte b2 = 0; b2 < this.k.size; b2++) {
/*     */                 Enemy enemy;
/* 399 */                 if ((enemy = (((Enemy.EnemyReference[])this.k.items)[b2]).enemy) != null) {
/*     */                   float f;
/*     */                   
/* 402 */                   if ((f = (getTile()).center.dst2(enemy.getPosition())) < f4) {
/*     */                     
/* 404 */                     float f6 = (getTile()).center.dst(enemy.getPosition());
/*     */                     float f5;
/* 406 */                     if ((f5 = f1 * (1.0F - f6 / this.rangeInPixels)) > 0.0F) {
/* 407 */                       this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, f1 * (1.0F - f6 / this.rangeInPixels), DamageType.EXPLOSION).setTower(this));
/* 408 */                       bool1 = true;
/*     */                       
/* 410 */                       if (b1 < 3)
/*     */                       {
/* 412 */                         if (a(enemy, f2, f3)) {
/* 413 */                           b1++;
/* 414 */                           this.S.achievement.setProgress(AchievementType.MASS_STUN_ENEMIES_ONE_SHOT, b1);
/*     */                         } 
/*     */                       }
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               } 
/* 421 */               if (bool1) {
/* 422 */                 this.j = 0.0F;
/* 423 */                 this.shotCount++;
/*     */                 
/* 425 */                 if (this.S._particle != null && Game.i.settingsManager.isExplosionsDrawing()) {
/*     */                   
/* 427 */                   ParticleEffectPool.PooledEffect pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.F.BLAST.c.obtain();
/* 428 */                   float f5 = ((getTile().getX() << 7) + 64);
/* 429 */                   float f6 = ((getTile().getY() << 7) + 64);
/* 430 */                   pooledEffect.setPosition(f5, f6);
/*     */                   
/*     */                   float[] arrayOfFloat;
/*     */                   
/*     */                   ParticleEmitter particleEmitter;
/*     */                   
/* 436 */                   (arrayOfFloat = (gradientColorValue = (particleEmitter = (ParticleEmitter)pooledEffect.getEmitters().first()).getTint()).getColors())[0] = e.r;
/* 437 */                   arrayOfFloat[1] = e.g;
/* 438 */                   arrayOfFloat[2] = e.b;
/* 439 */                   gradientColorValue.setColors(arrayOfFloat);
/*     */                   
/* 441 */                   particleEmitter.getXScale().setHigh(this.rangeInPixels * 2.0F);
/* 442 */                   particleEmitter.getYScale().setHigh(this.rangeInPixels * 2.0F);
/*     */                   
/* 444 */                   this.S._particle.addLimitedParticle((ParticleEffect)pooledEffect, LimitedParticleType.EXPLOSION_BLAST, f5, f6);
/*     */                 } 
/*     */                 
/* 447 */                 if (this.S._sound != null) {
/* 448 */                   this.S._sound.playShotSound(StaticSoundType.SHOT_BLAST, this);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           }
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 2:
/* 459 */           this.i += paramFloat;
/*     */           
/* 461 */           if (this.i >= 2.0F) {
/*     */ 
/*     */ 
/*     */             
/* 465 */             float f1 = getStat(TowerStatType.DAMAGE) * getStat(TowerStatType.ATTACK_SPEED) * this.i;
/* 466 */             float f2 = getStat(TowerStatType.U_STUN_DURATION) * 1.5F;
/*     */             
/* 468 */             float f3 = this.rangeInPixels * this.rangeInPixels;
/* 469 */             byte b1 = 0;
/* 470 */             for (byte b2 = 0; b2 < this.k.size; b2++) {
/*     */               Enemy enemy;
/* 472 */               if ((enemy = (((Enemy.EnemyReference[])this.k.items)[b2]).enemy) != null) {
/*     */                 float f;
/*     */                 
/* 475 */                 if ((f = (getTile()).center.dst2(enemy.getPosition())) < f3) {
/*     */                   
/* 477 */                   float f4 = (getTile()).center.dst(enemy.getPosition());
/*     */                   float f5;
/* 479 */                   if ((f5 = f1 * (1.0F - f4 / this.rangeInPixels)) > 0.0F) {
/* 480 */                     this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, f1 * (1.0F - f4 / this.rangeInPixels), DamageType.EXPLOSION).setTower(this));
/*     */ 
/*     */                     
/* 483 */                     if (a(enemy, 1.0F, f2)) {
/* 484 */                       b1++;
/* 485 */                       this.S.achievement.setProgress(AchievementType.MASS_STUN_ENEMIES_ONE_SHOT, b1);
/* 486 */                       if (this.S._particle != null) {
/*     */                         ParticleEffectPool.PooledEffect pooledEffect;
/* 488 */                         (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.F.BLAST.e.obtain()).setPosition((enemy.getPosition()).x, (enemy.getPosition()).y);
/* 489 */                         this.S._particle.addLimitedParticle((ParticleEffect)pooledEffect, LimitedParticleType.ENEMY_STUN, (enemy.getPosition()).x, (enemy.getPosition()).y);
/*     */                       } 
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */             
/* 497 */             this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), new ObjectFilter<Tile>(this) {
/*     */                   public boolean test(Tile param1Tile) {
/*     */                     PlatformTile platformTile;
/* 500 */                     if (param1Tile instanceof PlatformTile && 
/*     */                       
/* 502 */                       (platformTile = (PlatformTile)param1Tile).building instanceof Tower) {
/*     */                       Tower tower;
/* 504 */                       (tower = (Tower)platformTile.building).outOfOrder.addReasonForDuration("BlastQuake", 2.0F);
/*     */                     } 
/*     */                     
/* 507 */                     return true;
/*     */                   }
/*     */                 });
/*     */             
/* 511 */             if (gradientColorValue != null) {
/*     */               
/* 513 */               Array array = this.S.TSH.getEnemyArray(); int i;
/* 514 */               for (i = 0; i < this.S.map.spawnedEnemies.size; i++) {
/*     */                 Enemy.EnemyReference enemyReference; float f;
/* 516 */                 if ((enemyReference = ((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[i]).enemy != null && (
/*     */                   
/* 518 */                   f = enemyReference.enemy.getPosition().dst2((getTile()).center)) > f3 && 
/* 519 */                   canAttackEnemy(enemyReference.enemy) && enemyReference.enemy.canBeBuffed(BuffType.STUN)) {
/* 520 */                   array.add(enemyReference.enemy);
/*     */                 }
/*     */               } 
/*     */ 
/*     */               
/* 525 */               i = this.S.gameValue.getIntValue(GameValueType.TOWER_BLAST_A_SONIC_WAVE_QUAKE_ENEMIES);
/* 526 */               for (byte b = 0; b < i; b++) {
/* 527 */                 if (array.size != 0) {
/* 528 */                   Enemy enemy = (Enemy)array.removeIndex(this.S.gameState.randomInt(array.size));
/* 529 */                   if (a(enemy, 1.0F, f2)) {
/* 530 */                     b1++;
/* 531 */                     this.S.achievement.setProgress(AchievementType.MASS_STUN_ENEMIES_ONE_SHOT, b1);
/*     */                     
/* 533 */                     if (this.S._particle != null) {
/*     */                       ParticleEffectPool.PooledEffect pooledEffect;
/* 535 */                       (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.F.BLAST.e.obtain()).setPosition((enemy.getPosition()).x, (enemy.getPosition()).y);
/* 536 */                       this.S._particle.addLimitedParticle((ParticleEffect)pooledEffect, LimitedParticleType.ENEMY_STUN, (enemy.getPosition()).x, (enemy.getPosition()).y);
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */               
/* 542 */               this.S.TSH.freeEnemyArray(array);
/*     */             } 
/*     */             
/* 545 */             if (this.S._particle != null && Game.i.settingsManager.isExplosionsDrawing()) {
/*     */               
/* 547 */               ParticleEffectPool.PooledEffect pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.F.BLAST.d.obtain();
/* 548 */               float f4 = ((getTile().getX() << 7) + 64);
/* 549 */               float f5 = ((getTile().getY() << 7) + 64);
/* 550 */               pooledEffect.setPosition(f4, f5);
/*     */               
/*     */               ParticleEmitter particleEmitter;
/* 553 */               (particleEmitter = (ParticleEmitter)pooledEffect.getEmitters().first()).getXScale().setHigh(this.rangeInPixels * 2.0F);
/* 554 */               particleEmitter.getYScale().setHigh(this.rangeInPixels * 2.0F);
/*     */               
/* 556 */               this.S._particle.addLimitedParticle((ParticleEffect)pooledEffect, LimitedParticleType.EXPLOSION_BLAST, f4, f5);
/*     */             } 
/*     */             
/* 559 */             if (this.S._sound != null) {
/* 560 */               this.S._sound.playShotSound(StaticSoundType.SHOT_BLAST_QUAKE, this);
/*     */             }
/*     */             
/* 563 */             this.h = 0.0F;
/* 564 */             this.i = 0.0F;
/* 565 */             this.j = 0.0F;
/* 566 */             this.g = State.NORMAL;
/*     */           } 
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 572 */       if (this.S.gameState.isGameRealTimePasses()) {
/* 573 */         this.h += getStat(TowerStatType.U_QUAKE_CHARGE_SPEED) * paramFloat;
/* 574 */         if (this.h > 100.0F) {
/* 575 */           this.h = 100.0F;
/* 576 */           this.i += paramFloat;
/*     */         } else {
/* 578 */           this.i = 0.0F;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 583 */     super.update(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 588 */     super.drawBatch(paramBatch, paramFloat);
/*     */     
/* 590 */     if (this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED) {
/* 591 */       if (this.f == null && Game.i.shapeManager != null) {
/* 592 */         this.f = (Circle)Game.i.shapeManager.getFactory(ShapeType.CIRCLE).obtain();
/* 593 */         Color color1 = MaterialColor.BLUE_GREY.P500.cpy();
/* 594 */         Color color2 = MaterialColor.BLUE_GREY.P500.cpy();
/* 595 */         color1.a = 0.0F;
/* 596 */         color2.a = 0.14F;
/* 597 */         this.f.setup((getTile()).center.x, (getTile()).center.y, this.rangeInPixels * 0.5F, this.rangeInPixels, 48, color1.toFloatBits(), color2.toFloatBits());
/*     */       } 
/*     */       
/* 600 */       if (this.f != null) {
/* 601 */         this.f.draw(paramBatch);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(StringBuilder paramStringBuilder) {
/* 608 */     paramStringBuilder.append("state: ").append(this.g.name()).append("\n");
/* 609 */     paramStringBuilder.append("quakeCharge: ").append(this.h).append("\n");
/* 610 */     paramStringBuilder.append("quakeProgress: ").append(this.i).append("\n");
/* 611 */     paramStringBuilder.append("timeSinceLastAttack: ").append(this.j).append("\n");
/*     */   }
/*     */   
/*     */   public static class BlastTowerFactory extends Tower.Factory<BlastTower> {
/*     */     ParticleEffectPool c;
/*     */     ParticleEffectPool d;
/*     */     ParticleEffectPool e;
/*     */     
/*     */     public BlastTowerFactory() {
/* 620 */       super("tower-blast", TowerType.BLAST);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 625 */       super.setup();
/*     */       
/* 627 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 628 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "" };
/* 629 */       (this.b[2]).descriptionArgs = new Object[] { "", Integer.valueOf(1) };
/* 630 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "", "" };
/* 631 */       (this.b[4]).descriptionArgs = new Object[] { "", "" };
/*     */     }
/*     */     @Null
/*     */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/*     */       String str;
/* 636 */       if (param1TowerStatType == TowerStatType.STUN_CHANCE) {
/* 637 */         str = StringFormatter.compactNumberWithPrecisionTrimZeros(100.0D, 1, true).toString();
/* 638 */         String str1 = StringFormatter.compactNumberWithPrecisionTrimZeros(3.0D, 1, true).toString();
/* 639 */         String str2 = StringFormatter.compactNumberWithPrecisionTrimZeros(20.0D, 1, true).toString();
/*     */         
/* 641 */         return Game.i.localeManager.i18n.format("tower_stat_more_info_BLAST_STUN_CHANCE", new Object[] { str, str1, str2, Integer.valueOf(6) });
/* 642 */       }  if (str == TowerStatType.U_STUN_DURATION)
/* 643 */         return Game.i.localeManager.i18n.format("tower_stat_more_info_BLAST_U_STUN_DURATION", new Object[] { Integer.valueOf(25), Integer.valueOf(0) }); 
/* 644 */       if (str == TowerStatType.U_QUAKE_CHARGE_SPEED) {
/* 645 */         str = Game.i.localeManager.i18n.format("tower_stat_more_info_BLAST_U_QUAKE_CHARGE_SPEED", new Object[] { StringFormatter.compactNumberWithPrecisionTrimZeros(1.5D, 1, true).toString() });
/*     */ 
/*     */         
/* 648 */         return str = str + "\n" + Game.i.localeManager.i18n.format("quake_disables_nearest_towers_for", new Object[] { Float.valueOf(2.0F) });
/*     */       } 
/* 650 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 658 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_HEAVY_SHELL_SPEED), 2, true).toString();
/* 659 */       (arrayOfAbilityConfig[0]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_HEAVY_SHELL_DAMAGE), 2, true).toString();
/* 660 */       (arrayOfAbilityConfig[0]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_HEAVY_SHELL_CHANCE), 2, true).toString();
/*     */       
/* 662 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_FAST_MECHANISM_SPEED), 2, true).toString();
/*     */       
/* 664 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BLAST_A_SONIC_WAVE_DURATION), 2, true).toString();
/* 665 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = Integer.valueOf(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_BLAST_A_SONIC_WAVE_QUAKE_ENEMIES));
/*     */ 
/*     */       
/* 668 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(BlastTower.a((BlastTower)param1Tower), 2, true).toString();
/* 669 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_BLAST_A_STOPPING_FORCE_CHANCE), false).toString();
/*     */       
/* 671 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = "+" + StringFormatter.compactNumber(((BlastTower.b((BlastTower)param1Tower) - 1.0F) * 100.0F), false).toString();
/* 672 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = "2";
/*     */       
/* 674 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 680 */       if (param1Int == 0) {
/* 681 */         return false;
/*     */       }
/* 683 */       return true;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 687 */       return MaterialColor.BLUE_GREY.P500;
/*     */     }
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 691 */       switch (BlastTower.null.b[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 692 */           return 2;
/* 693 */         case 2: return 1;
/* 694 */         case 3: return 1;
/* 695 */         case 4: return 3;
/* 696 */         case 5: return 3; }
/* 697 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 703 */       return BlastTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 708 */       this.c = Game.i.assetManager.getParticleEffectPool("shockwave.prt");
/* 709 */       this.d = Game.i.assetManager.getParticleEffectPool("shockwave-quake.prt");
/* 710 */       this.e = Game.i.assetManager.getParticleEffectPool("stun.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 715 */       return 32;
/*     */     }
/*     */ 
/*     */     
/*     */     public BlastTower create() {
/* 720 */       return new BlastTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\BlastTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */