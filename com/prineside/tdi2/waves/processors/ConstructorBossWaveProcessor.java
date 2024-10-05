/*     */ package com.prineside.tdi2.waves.processors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyGroup;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Wave;
/*     */ import com.prineside.tdi2.WaveProcessor;
/*     */ import com.prineside.tdi2.enemies.bosses.ConstructorBossEnemy;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.WaveSystem;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.ui.components.BossHpBar;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public class ConstructorBossWaveProcessor implements KryoSerializable, WaveProcessor, Listener<EnemySpawn> {
/*  33 */   private static final TLog a = TLog.forClass(ConstructorBossWaveProcessor.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Wave b;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Enemy.EnemyReference c;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean d = false;
/*     */ 
/*     */ 
/*     */   
/*  51 */   private Array<EnemyType> e = new Array(EnemyType.class);
/*  52 */   private Array<EnemyType> f = new Array(EnemyType.class);
/*     */   
/*     */   private GameSystemProvider g;
/*     */   @NAGS
/*     */   private BossHpBar h;
/*     */   @NAGS
/*     */   private Drawable i;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  61 */     paramKryo.writeObjectOrNull(paramOutput, this.b, Wave.class);
/*  62 */     paramKryo.writeObjectOrNull(paramOutput, this.c, Enemy.EnemyReference.class);
/*  63 */     paramOutput.writeBoolean(this.d);
/*  64 */     paramKryo.writeObject(paramOutput, this.e);
/*  65 */     paramKryo.writeObject(paramOutput, this.f);
/*  66 */     paramKryo.writeObjectOrNull(paramOutput, this.g, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  71 */     this.b = (Wave)paramKryo.readObjectOrNull(paramInput, Wave.class);
/*  72 */     this.c = (Enemy.EnemyReference)paramKryo.readObjectOrNull(paramInput, Enemy.EnemyReference.class);
/*  73 */     this.d = paramInput.readBoolean();
/*  74 */     this.e = (Array<EnemyType>)paramKryo.readObject(paramInput, Array.class);
/*  75 */     this.f = (Array<EnemyType>)paramKryo.readObject(paramInput, Array.class);
/*  76 */     this.g = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<EnemyGroup> generateEnemyGroups(int paramInt1, int paramInt2) {
/*  85 */     float f2 = Wave.calculateDefaultBossWaveCoinsSum(paramInt1);
/*  86 */     float f3 = Wave.calculateDefaultBossWaveExpSum(paramInt1);
/*  87 */     float f4 = Wave.calculateDefaultBossWaveScoreSum(paramInt1);
/*     */     
/*  89 */     Array<EnemyGroup> array = new Array();
/*  90 */     float f1 = WaveSystem.getWaveValue(paramInt1, paramInt2);
/*  91 */     f1 = 100.0F + (float)StrictMath.pow(f1 * 10.0D, 1.275D) * 1.35F;
/*  92 */     array.add(new EnemyGroup(EnemyType.CONSTRUCTOR_BOSS, 0.3003F, f1 * 3.3F, 1, 0.0F, 0.0F, f2 * 0.75F, f3 * 0.75F, (int)(f4 * 0.75F)));
/*     */     
/*  94 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public Wave setup(GameSystemProvider paramGameSystemProvider, int paramInt1, int paramInt2) {
/*  99 */     this.g = paramGameSystemProvider;
/*     */     
/* 101 */     this.b = new Wave(paramInt1, paramInt2, generateEnemyGroups(paramInt1, paramInt2));
/* 102 */     this.b.enemiesCanBeSplitBetweenSpawns = false;
/* 103 */     this.b.enemiesCanHaveRandomSideShifts = false;
/* 104 */     this.b.waveMessage = Config.isHeadless() ? null : Game.i.localeManager.i18n.get("enemy_name_CONSTRUCTOR_BOSS");
/* 105 */     this.b.waveProcessor = this;
/*     */     
/* 107 */     paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this).setDescription("Handles boss spawn");
/*     */     
/* 109 */     return this.b;
/*     */   }
/*     */   
/*     */   private void a(ConstructorBossEnemy paramConstructorBossEnemy) {
/* 113 */     this.c = this.g.enemy.getReference((Enemy)paramConstructorBossEnemy);
/* 114 */     paramConstructorBossEnemy.processor = this;
/*     */ 
/*     */     
/* 117 */     this.e.clear();
/* 118 */     Array array = paramConstructorBossEnemy.spawnTile.getAllowedEnemies(); int i;
/* 119 */     for (i = 0; i < array.size; i++) {
/* 120 */       this.e.add((((SpawnTile.AllowedEnemyConfig[])array.items)[i]).enemyType);
/*     */     }
/*     */ 
/*     */     
/* 124 */     for (i = this.e.size - 1; i >= 0; i--) {
/*     */       EnemyType enemyType;
/* 126 */       if ((enemyType = ((EnemyType[])this.e.items)[i]) == EnemyType.ARMORED || enemyType == EnemyType.HEALER || EnemyType.isBoss(enemyType)) {
/* 127 */         this.e.removeIndex(i);
/*     */       }
/*     */     } 
/*     */     
/* 131 */     if (this.e.size == 0) {
/*     */       
/* 133 */       a.i("no normal enemy types allowed, fallback", new Object[0]);
/* 134 */       this.e.add(EnemyType.REGULAR);
/* 135 */       this.e.add(EnemyType.FAST);
/* 136 */       this.e.add(EnemyType.STRONG);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 141 */     if (paramConstructorBossEnemy.spawnTile.getAllowedEnemiesSet().contains(EnemyType.HEALER)) {
/* 142 */       this.f.add(EnemyType.HEALER);
/*     */     }
/* 144 */     if (paramConstructorBossEnemy.spawnTile.getAllowedEnemiesSet().contains(EnemyType.ARMORED)) {
/* 145 */       this.f.add(EnemyType.ARMORED);
/*     */     }
/* 147 */     if (this.f.size == 0) {
/*     */       
/* 149 */       a.i("no aura enemy types allowed, fallback", new Object[0]);
/* 150 */       this.f.addAll(this.e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getNextWaveDelayMultiplier() {
/* 156 */     return 7.0F;
/*     */   }
/*     */   
/*     */   private Drawable a() {
/* 160 */     if (this.i == null) {
/* 161 */       this.i = (Drawable)Game.i.assetManager.getDrawable("buff-health-bar-icon-armor");
/*     */     }
/* 163 */     return this.i;
/*     */   }
/*     */   
/*     */   private void b() {
/* 167 */     if (this.c == null)
/*     */       return; 
/* 169 */     if (this.h == null && this.g._gameUi != null) {
/* 170 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 180 */         .h = (new BossHpBar()).setBossName(Game.i.localeManager.i18n.get("enemy_name_CONSTRUCTOR_BOSS")).setMainBarColor(new Color(321401855), new Color(1618840575)).setSmallBarsCount(2).setFirstSmallBarColor(new Color(590230527), new Color(1618840575)).setSecondSmallBarColor(new Color(806110975), new Color(1780194047)).setLabelsColor(new Color(-1868255489)).addMark(0.75F).addMark(0.5F).addMark(0.25F).setIcon((Drawable)Game.i.assetManager.getDrawable("boss-wave-icon-CONSTRUCTOR"));
/* 181 */       this.g._gameUi.mainUi.addBossHpBar(this.h);
/*     */     } 
/* 183 */     if (this.h != null) {
/* 184 */       ConstructorBossEnemy constructorBossEnemy = (ConstructorBossEnemy)this.c.enemy;
/* 185 */       this.h.setMainHP(constructorBossEnemy.getHealth(), constructorBossEnemy.maxHealth);
/*     */       
/*     */       float f;
/* 188 */       if ((f = getInvulnerabilityProgress()) > 0.0F) {
/* 189 */         if (!this.h.isEffectIconExists(a())) {
/* 190 */           this.h.addEffectIcon(a());
/*     */         }
/* 192 */         this.h.setSmallBarOneProgress(f);
/*     */         
/* 194 */         this.h.setSmallBarTwoProgress(0.0D);
/*     */       } else {
/* 196 */         this.h.clearEffectIcons();
/* 197 */         this.h.setSmallBarOneProgress(0.0D);
/*     */ 
/*     */         
/* 200 */         f = constructorBossEnemy.timeSinceCreepSpawn / 10.0F;
/* 201 */         this.h.setSmallBarTwoProgress(f);
/*     */       } 
/*     */       
/* 204 */       byte b = 0;
/* 205 */       if (!constructorBossEnemy.groupSpawned75hp) {
/* 206 */         b++;
/*     */       }
/* 208 */       if (!constructorBossEnemy.groupSpawned50hp) {
/* 209 */         b++;
/*     */       }
/* 211 */       if (!constructorBossEnemy.groupSpawned25hp) {
/* 212 */         b++;
/*     */       }
/*     */       
/* 215 */       if ((this.h.marksGroup.getChildren()).size != b) {
/* 216 */         this.h.clearMarks();
/*     */         
/* 218 */         if (!constructorBossEnemy.groupSpawned75hp) {
/* 219 */           this.h.addMark(0.75F);
/*     */         }
/* 221 */         if (!constructorBossEnemy.groupSpawned50hp) {
/* 222 */           this.h.addMark(0.5F);
/*     */         }
/* 224 */         if (!constructorBossEnemy.groupSpawned25hp) {
/* 225 */           this.h.addMark(0.25F);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getInvulnerabilityProgress() {
/*     */     ConstructorBossEnemy constructorBossEnemy;
/* 233 */     if ((constructorBossEnemy = (ConstructorBossEnemy)this.c.enemy) == null || !constructorBossEnemy.invulnerable) {
/* 234 */       return 0.0F;
/*     */     }
/*     */     
/* 237 */     float f2 = 1.2F + 0.75F * constructorBossEnemy.enemiesToSpawnStartCount;
/* 238 */     float f1 = constructorBossEnemy.spawnDelayBeforeTime + constructorBossEnemy.spawnDelayAfterTime + (constructorBossEnemy.enemiesToSpawnStartCount - constructorBossEnemy.enemiesToSpawn.size) * 0.75F + constructorBossEnemy.spawningTime;
/*     */     
/* 240 */     return 1.0F - f1 / f2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 245 */     b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 250 */     if (this.d || this.c == null)
/*     */       return; 
/* 252 */     if (this.c.enemy == null) {
/* 253 */       this.d = true;
/* 254 */       c();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     ConstructorBossEnemy constructorBossEnemy;
/*     */     
/*     */     float f;
/* 262 */     if ((f = (constructorBossEnemy = (ConstructorBossEnemy)this.c.enemy).getHealth() / constructorBossEnemy.maxHealth) <= 0.75F && !constructorBossEnemy.groupSpawned75hp) {
/*     */       
/* 264 */       for (byte b = 0; b < 3; b++) {
/* 265 */         EnemyType enemyType = ((EnemyType[])this.e.items)[this.g.gameState.randomInt(this.e.size)];
/*     */         
/*     */         Enemy enemy;
/* 268 */         (enemy = Game.i.enemyManager.getFactory(enemyType).obtain()).setSpeed(0.6F);
/* 269 */         enemy.maxHealth = constructorBossEnemy.maxHealth * 0.015000001F;
/* 270 */         enemy.setHealth(enemy.maxHealth);
/*     */         
/* 272 */         enemy.killScore = StrictMath.round(constructorBossEnemy.killScore * 0.027777778F);
/* 273 */         enemy.bounty = StrictMath.round(constructorBossEnemy.bounty * 0.027777778F);
/* 274 */         enemy.setKillExp(constructorBossEnemy.getKillExp() * 0.027777778F);
/*     */         
/* 276 */         constructorBossEnemy.enemiesToSpawn.add(enemy);
/*     */       } 
/*     */       
/* 279 */       constructorBossEnemy.groupSpawned75hp = true;
/*     */     } 
/* 281 */     if (f <= 0.5F && !constructorBossEnemy.groupSpawned50hp) {
/*     */       byte b;
/* 283 */       for (b = 0; b < 4; b++) {
/* 284 */         EnemyType enemyType = ((EnemyType[])this.e.items)[this.g.gameState.randomInt(this.e.size)];
/*     */         
/*     */         Enemy enemy;
/* 287 */         (enemy = Game.i.enemyManager.getFactory(enemyType).obtain()).setSpeed(0.6F + b * 0.05F);
/* 288 */         enemy.maxHealth = constructorBossEnemy.maxHealth * 0.015000001F;
/* 289 */         enemy.setHealth(enemy.maxHealth);
/*     */         
/* 291 */         enemy.killScore = StrictMath.round(constructorBossEnemy.killScore * 0.027777778F);
/* 292 */         enemy.bounty = StrictMath.round(constructorBossEnemy.bounty * 0.027777778F);
/* 293 */         enemy.setKillExp(constructorBossEnemy.getKillExp() * 0.027777778F);
/*     */         
/* 295 */         constructorBossEnemy.enemiesToSpawn.add(enemy);
/*     */       } 
/*     */       
/* 298 */       for (b = 0; b <= 0; b++) {
/* 299 */         EnemyType enemyType = ((EnemyType[])this.f.items)[this.g.gameState.randomInt(this.f.size)];
/*     */         
/*     */         Enemy enemy;
/* 302 */         (enemy = Game.i.enemyManager.getFactory(enemyType).obtain()).setSpeed(0.65F);
/* 303 */         enemy.maxHealth = constructorBossEnemy.maxHealth * 0.021000002F;
/* 304 */         enemy.setHealth(enemy.maxHealth);
/*     */         
/* 306 */         enemy.killScore = StrictMath.round(constructorBossEnemy.killScore * 0.027777778F);
/* 307 */         enemy.bounty = StrictMath.round(constructorBossEnemy.bounty * 0.027777778F);
/* 308 */         enemy.setKillExp(constructorBossEnemy.getKillExp() * 0.027777778F);
/*     */         
/* 310 */         constructorBossEnemy.enemiesToSpawn.add(enemy);
/*     */       } 
/*     */       
/* 313 */       constructorBossEnemy.groupSpawned50hp = true;
/*     */     } 
/* 315 */     if (f <= 0.25F && !constructorBossEnemy.groupSpawned25hp) {
/*     */       byte b;
/* 317 */       for (b = 0; b < 5; b++) {
/* 318 */         EnemyType enemyType = ((EnemyType[])this.e.items)[this.g.gameState.randomInt(this.e.size)];
/*     */         
/*     */         Enemy enemy;
/* 321 */         (enemy = Game.i.enemyManager.getFactory(enemyType).obtain()).setSpeed(0.6F + b * 0.05F);
/* 322 */         enemy.maxHealth = constructorBossEnemy.maxHealth * 0.015000001F;
/* 323 */         enemy.setHealth(enemy.maxHealth);
/*     */         
/* 325 */         enemy.killScore = StrictMath.round(constructorBossEnemy.killScore * 0.027777778F);
/* 326 */         enemy.bounty = StrictMath.round(constructorBossEnemy.bounty * 0.027777778F);
/* 327 */         enemy.setKillExp(constructorBossEnemy.getKillExp() * 0.027777778F);
/*     */         
/* 329 */         constructorBossEnemy.enemiesToSpawn.add(enemy);
/*     */       } 
/*     */       
/* 332 */       for (b = 0; b < 2; b++) {
/* 333 */         EnemyType enemyType = ((EnemyType[])this.f.items)[this.g.gameState.randomInt(this.f.size)];
/*     */         
/*     */         Enemy enemy;
/* 336 */         (enemy = Game.i.enemyManager.getFactory(enemyType).obtain()).setSpeed(0.65F);
/* 337 */         enemy.maxHealth = constructorBossEnemy.maxHealth * 0.021000002F;
/* 338 */         enemy.setHealth(enemy.maxHealth);
/*     */         
/* 340 */         enemy.killScore = StrictMath.round(constructorBossEnemy.killScore * 0.027777778F);
/* 341 */         enemy.bounty = StrictMath.round(constructorBossEnemy.bounty * 0.027777778F);
/* 342 */         enemy.setKillExp(constructorBossEnemy.getKillExp() * 0.027777778F);
/*     */         
/* 344 */         constructorBossEnemy.enemiesToSpawn.add(enemy);
/*     */       } 
/*     */       
/* 347 */       constructorBossEnemy.groupSpawned25hp = true;
/*     */     } 
/*     */     
/* 350 */     if (constructorBossEnemy.enemiesToSpawn.size != 0) {
/*     */       
/* 352 */       constructorBossEnemy.enemiesToSpawnStartCount = Math.max(constructorBossEnemy.enemiesToSpawn.size, constructorBossEnemy.enemiesToSpawnStartCount);
/* 353 */       constructorBossEnemy.spawnDelayAfterTime = 0.0F;
/*     */       
/* 355 */       constructorBossEnemy.invulnerable = true;
/* 356 */       constructorBossEnemy.changeSpeedTo(0.0F, paramFloat);
/*     */       
/* 358 */       if (constructorBossEnemy.spawnDelayBeforeTime < 0.2F) {
/*     */         
/* 360 */         constructorBossEnemy.spawnDelayBeforeTime += paramFloat;
/*     */         return;
/*     */       } 
/* 363 */       constructorBossEnemy.spawningTime += paramFloat;
/* 364 */       if (constructorBossEnemy.spawningTime >= 0.75F) {
/*     */         Enemy enemy;
/*     */         
/* 367 */         (enemy = (Enemy)constructorBossEnemy.enemiesToSpawn.pop()).ignorePathfinding = true;
/*     */ 
/*     */         
/* 370 */         this.g.enemy.addEnemyWithPath(enemy, constructorBossEnemy.spawnTile, constructorBossEnemy.graphPath, 5, constructorBossEnemy.wave, constructorBossEnemy.passedTiles);
/*     */         
/* 372 */         constructorBossEnemy.timeSinceCreepSpawn = 0.0F;
/* 373 */         constructorBossEnemy.spawningTime = 0.0F;
/*     */         
/*     */         return;
/*     */       } 
/*     */     } else {
/* 378 */       if (constructorBossEnemy.spawnDelayAfterTime < 1.0F) {
/*     */         
/* 380 */         constructorBossEnemy.spawnDelayAfterTime += paramFloat;
/*     */         return;
/*     */       } 
/* 383 */       constructorBossEnemy.spawnDelayBeforeTime = 0.0F;
/* 384 */       constructorBossEnemy.enemiesToSpawnStartCount = 0;
/* 385 */       constructorBossEnemy.invulnerable = false;
/* 386 */       constructorBossEnemy.changeSpeedTo(0.3003F, paramFloat);
/* 387 */       float f1 = constructorBossEnemy.graphPath.getLengthInTiles();
/* 388 */       if (constructorBossEnemy.passedTiles < f1 * 0.5F) {
/*     */         
/* 390 */         constructorBossEnemy.timeSinceCreepSpawn += paramFloat;
/* 391 */         if (constructorBossEnemy.timeSinceCreepSpawn >= 10.0F) {
/*     */           Enemy enemy;
/*     */           
/* 394 */           (enemy = Game.i.enemyManager.getFactory(EnemyType.REGULAR).obtain()).setSpeed(0.8F);
/* 395 */           enemy.maxHealth = constructorBossEnemy.maxHealth * 0.015000001F;
/* 396 */           enemy.setHealth(enemy.maxHealth);
/*     */           
/* 398 */           enemy.killScore = StrictMath.round(constructorBossEnemy.killScore * 0.027777778F);
/* 399 */           enemy.bounty = StrictMath.round(constructorBossEnemy.bounty * 0.027777778F);
/* 400 */           enemy.setKillExp(constructorBossEnemy.getKillExp() * 0.027777778F);
/*     */           
/* 402 */           constructorBossEnemy.enemiesToSpawn.add(enemy);
/*     */ 
/*     */           
/* 405 */           (enemy = Game.i.enemyManager.getFactory(EnemyType.FAST).obtain()).setSpeed(0.92F);
/* 406 */           enemy.maxHealth = constructorBossEnemy.maxHealth * 0.015000001F * 0.85F;
/* 407 */           enemy.setHealth(enemy.maxHealth);
/*     */           
/* 409 */           enemy.killScore = StrictMath.round(constructorBossEnemy.killScore * 0.027777778F);
/* 410 */           enemy.bounty = StrictMath.round(constructorBossEnemy.bounty * 0.027777778F);
/* 411 */           enemy.setKillExp(constructorBossEnemy.getKillExp() * 0.027777778F);
/*     */           
/* 413 */           constructorBossEnemy.enemiesToSpawn.add(enemy);
/*     */ 
/*     */           
/* 416 */           (enemy = Game.i.enemyManager.getFactory(EnemyType.STRONG).obtain()).setSpeed(0.64000005F);
/* 417 */           enemy.maxHealth = constructorBossEnemy.maxHealth * 0.015000001F * 1.15F;
/* 418 */           enemy.setHealth(enemy.maxHealth);
/*     */           
/* 420 */           enemy.killScore = StrictMath.round(constructorBossEnemy.killScore * 0.027777778F);
/* 421 */           enemy.bounty = StrictMath.round(constructorBossEnemy.bounty * 0.027777778F);
/* 422 */           enemy.setKillExp(constructorBossEnemy.getKillExp() * 0.027777778F);
/*     */           
/* 424 */           constructorBossEnemy.enemiesToSpawn.add(enemy);
/*     */           
/* 426 */           constructorBossEnemy.spawningTime = 0.0F;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 437 */     return this.d;
/*     */   }
/*     */   
/*     */   private void c() {
/* 441 */     this.g.events.getListeners(EnemySpawn.class).remove(this);
/*     */     
/* 443 */     if (this.h != null) {
/* 444 */       this.g._gameUi.mainUi.removeBossHpBar(this.h);
/* 445 */       this.h = null;
/*     */     } 
/*     */     
/* 448 */     this.g = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleEvent(EnemySpawn paramEnemySpawn) {
/*     */     Enemy enemy;
/* 454 */     if ((enemy = paramEnemySpawn.getEnemy()).wave == this.b && enemy.type == EnemyType.CONSTRUCTOR_BOSS && this.c == null)
/* 455 */       a((ConstructorBossEnemy)enemy); 
/*     */   }
/*     */   
/*     */   private ConstructorBossWaveProcessor() {}
/*     */   
/*     */   public static class ConstructorBossWaveProcessorFactory extends WaveProcessor.WaveProcessorFactory<ConstructorBossWaveProcessor> { public ConstructorBossWaveProcessorFactory() {
/* 461 */       super(BossType.CONSTRUCTOR);
/*     */     }
/*     */ 
/*     */     
/*     */     public ConstructorBossWaveProcessor create() {
/* 466 */       return new ConstructorBossWaveProcessor((byte)0);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\processors\ConstructorBossWaveProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */