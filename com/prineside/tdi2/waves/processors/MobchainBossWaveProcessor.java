/*     */ package com.prineside.tdi2.waves.processors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyGroup;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Wave;
/*     */ import com.prineside.tdi2.WaveProcessor;
/*     */ import com.prineside.tdi2.buffs.InvulnerabilityBuff;
/*     */ import com.prineside.tdi2.buffs.RegenerationBuff;
/*     */ import com.prineside.tdi2.buffs.SlippingBuff;
/*     */ import com.prineside.tdi2.enemies.bosses.MobchainBossCreepEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.MobchainBossHeadEnemy;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDespawn;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.WaveSystem;
/*     */ import com.prineside.tdi2.ui.components.BossHpBar;
/*     */ import com.prineside.tdi2.utils.EntityUtils;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public class MobchainBossWaveProcessor
/*     */   implements KryoSerializable, WaveProcessor, Listener<EnemySpawn>
/*     */ {
/*     */   private Wave a;
/*  48 */   private Enemy.EnemyReference b = Enemy.EnemyReference.NULL;
/*  49 */   private Array<Enemy.EnemyReference> c = new Array(true, 8, Enemy.EnemyReference.class);
/*     */   private int d;
/*     */   private int e;
/*  52 */   private Array<Enemy.EnemyReference> f = new Array(true, 8, Enemy.EnemyReference.class);
/*  53 */   private int g = 1;
/*     */   private boolean h = false;
/*     */   private GameSystemProvider i;
/*     */   @NAGS
/*     */   private BossHpBar j;
/*     */   @NAGS
/*     */   private Drawable k;
/*     */   @NAGS
/*     */   private Drawable l;
/*  62 */   private OnEnemyDespawn m = new OnEnemyDespawn(this, (byte)0);
/*  63 */   private OnEnemyDie n = new OnEnemyDie(this);
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  67 */     paramKryo.writeObjectOrNull(paramOutput, this.a, Wave.class);
/*  68 */     paramKryo.writeObject(paramOutput, this.b);
/*  69 */     paramKryo.writeObject(paramOutput, this.c);
/*  70 */     paramOutput.writeVarInt(this.d, true);
/*  71 */     paramOutput.writeVarInt(this.e, true);
/*  72 */     paramKryo.writeObject(paramOutput, this.f);
/*  73 */     paramOutput.writeVarInt(this.g, true);
/*  74 */     paramOutput.writeBoolean(this.h);
/*  75 */     paramKryo.writeObjectOrNull(paramOutput, this.i, GameSystemProvider.class);
/*  76 */     paramKryo.writeObjectOrNull(paramOutput, this.m, OnEnemyDespawn.class);
/*  77 */     paramKryo.writeObjectOrNull(paramOutput, this.n, OnEnemyDie.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  82 */     this.a = (Wave)paramKryo.readObjectOrNull(paramInput, Wave.class);
/*  83 */     this.b = (Enemy.EnemyReference)paramKryo.readObject(paramInput, Enemy.EnemyReference.class);
/*  84 */     this.c = (Array<Enemy.EnemyReference>)paramKryo.readObject(paramInput, Array.class);
/*  85 */     this.d = paramInput.readVarInt(true);
/*  86 */     this.e = paramInput.readVarInt(true);
/*  87 */     this.f = (Array<Enemy.EnemyReference>)paramKryo.readObject(paramInput, Array.class);
/*  88 */     this.g = paramInput.readVarInt(true);
/*  89 */     this.h = paramInput.readBoolean();
/*  90 */     this.i = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  91 */     this.m = (OnEnemyDespawn)paramKryo.readObjectOrNull(paramInput, OnEnemyDespawn.class);
/*  92 */     this.n = (OnEnemyDie)paramKryo.readObjectOrNull(paramInput, OnEnemyDie.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getNextWaveDelayMultiplier() {
/*  99 */     return 7.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<EnemyGroup> generateEnemyGroups(int paramInt1, int paramInt2) {
/* 104 */     Array<EnemyGroup> array = new Array(EnemyGroup.class);
/* 105 */     float f2 = WaveSystem.getWaveValue(paramInt1, paramInt2);
/*     */     int j;
/* 107 */     if ((j = MathUtils.floor(4.0F + (float)StrictMath.pow(paramInt1, 0.85D) / 12.0F)) > 8) j = 8;
/*     */ 
/*     */     
/* 110 */     float f3 = Wave.calculateDefaultBossWaveCoinsSum(paramInt1);
/* 111 */     float f4 = Wave.calculateDefaultBossWaveExpSum(paramInt1);
/* 112 */     float f1 = Wave.calculateDefaultBossWaveScoreSum(paramInt1);
/*     */     
/* 114 */     float f5 = f3 * 0.5F;
/* 115 */     float f6 = f4 * 0.3F;
/* 116 */     int k = (int)(f1 * 0.3F);
/* 117 */     f3 = f3 * 0.5F / j;
/* 118 */     f4 = f4 * 0.7F / j;
/* 119 */     int i = StrictMath.round(f1 * 0.7F / j);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 124 */     float f7 = (f2 = 30.0F + (float)StrictMath.pow(f2 * 10.0D, 1.275D) * 0.5F) * (1.0F + j * 0.2F) / j * 0.7F;
/*     */     
/* 126 */     array.add(new EnemyGroup(EnemyType.MOBCHAIN_BOSS_HEAD, 0.32F, f2 * 3.3F, 1, 0.0F, 0.0F, f5, f6, k));
/* 127 */     array.add(new EnemyGroup(EnemyType.MOBCHAIN_BOSS_BODY, 0.32F, f7 * 2.2F, j - 1, 0.55F, 0.55F, f3, f4, i));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     return array;
/*     */   }
/*     */   
/*     */   private Drawable a() {
/* 136 */     if (this.k == null) {
/* 137 */       this.k = (Drawable)Game.i.assetManager.getDrawable("buff-health-bar-icon-armor");
/*     */     }
/* 139 */     return this.k;
/*     */   }
/*     */   
/*     */   private Drawable b() {
/* 143 */     if (this.l == null) {
/* 144 */       this.l = (Drawable)Game.i.assetManager.getDrawable("buff-health-bar-icon-regeneration");
/*     */     }
/* 146 */     return this.l;
/*     */   }
/*     */ 
/*     */   
/*     */   public Wave setup(GameSystemProvider paramGameSystemProvider, int paramInt1, int paramInt2) {
/* 151 */     this.i = paramGameSystemProvider;
/*     */     
/* 153 */     Array<EnemyGroup> array = generateEnemyGroups(paramInt1, paramInt2);
/* 154 */     for (byte b = 0; b < array.size; b++) {
/* 155 */       this.d += (((EnemyGroup[])array.items)[b]).count;
/*     */     }
/* 157 */     this.e = this.d - 1;
/*     */     
/* 159 */     this.a = new Wave(paramInt1, paramInt2, array);
/* 160 */     this.a.enemiesCanBeSplitBetweenSpawns = false;
/* 161 */     this.a.enemiesCanHaveRandomSideShifts = false;
/* 162 */     this.a.waveMessage = Config.isHeadless() ? null : Game.i.localeManager.i18n.get("enemy_name_MOBCHAIN_BOSS_HEAD");
/* 163 */     this.a.waveProcessor = this;
/*     */     
/* 165 */     paramGameSystemProvider.events.getListeners(EnemyDie.class).addStateAffecting(this.n);
/* 166 */     paramGameSystemProvider.events.getListeners(EnemyDespawn.class).addStateAffecting(this.m);
/* 167 */     paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this).setDescription("Stores spawned boss parts to be handled by this processor");
/*     */     
/* 169 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   private void c() {
/* 174 */     if (this.b == null)
/*     */       return; 
/* 176 */     if (this.j == null && this.i._gameUi != null) {
/* 177 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 183 */         .j = (new BossHpBar()).setBossName(Game.i.localeManager.i18n.get("enemy_name_MOBCHAIN_BOSS_HEAD")).setMainBarColor(new Color(521352191), new Color(1731901439)).setSmallBarsCount(1).setFirstSmallBarColor(new Color(590230527), new Color(1618840575)).setLabelsColor(new Color(-1787441665)).setIcon((Drawable)Game.i.assetManager.getDrawable("boss-wave-icon-MOBCHAIN"));
/* 184 */       this.i._gameUi.mainUi.addBossHpBar(this.j);
/*     */     } 
/* 186 */     if (this.j != null) {
/*     */       MobchainBossHeadEnemy mobchainBossHeadEnemy;
/* 188 */       if ((mobchainBossHeadEnemy = (MobchainBossHeadEnemy)this.b.enemy) == null)
/*     */         return; 
/* 190 */       this.j.setMainHP(mobchainBossHeadEnemy.getHealth(), mobchainBossHeadEnemy.maxHealth);
/*     */       
/* 192 */       float f = 0.0F; byte b;
/* 193 */       for (b = 0; b < this.c.size; b++) {
/*     */         Enemy enemy;
/* 195 */         if ((enemy = ((Enemy.EnemyReference)this.c.get(b)).enemy) != null && enemy.type != EnemyType.MOBCHAIN_BOSS_HEAD) {
/* 196 */           f += enemy.getHealth() / enemy.maxHealth;
/*     */         }
/*     */       } 
/* 199 */       if (f == 0.0F) {
/*     */         
/* 201 */         if (this.j.isEffectIconExists(a())) {
/* 202 */           this.j.clearEffectIcons();
/*     */         }
/*     */         
/* 205 */         f = 0.0F;
/* 206 */         for (b = 0; b < this.f.size; b++) {
/*     */           Enemy enemy;
/* 208 */           if ((enemy = ((Enemy.EnemyReference)this.f.get(b)).enemy) != null) {
/* 209 */             f += enemy.getHealth() / enemy.maxHealth;
/*     */           }
/*     */         } 
/* 212 */         this.j.setSmallBarOneProgress((f / this.g));
/*     */         
/* 214 */         if (mobchainBossHeadEnemy.hasBuffsByType(BuffType.REGENERATION)) {
/* 215 */           if (!this.j.isEffectIconExists(b())) {
/* 216 */             this.j.addEffectIcon(b()); return;
/*     */           } 
/*     */         } else {
/* 219 */           this.j.clearEffectIcons();
/*     */           return;
/*     */         } 
/*     */       } else {
/* 223 */         this.j.setSmallBarOneProgress((f / this.e));
/* 224 */         if (!this.j.isEffectIconExists(a())) {
/* 225 */           this.j.addEffectIcon(a());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 233 */     c();
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 238 */     if (this.h)
/*     */       return; 
/* 240 */     EntityUtils.removeNullRefs(this.c);
/* 241 */     EntityUtils.removeNullRefs(this.f);
/*     */     
/* 243 */     if (this.c.size == 0 && this.f.size == 0 && this.a.isFullySpawned()) {
/* 244 */       this.h = true;
/*     */       
/* 246 */       d();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 261 */     if (this.b.enemy == null) {
/*     */       
/* 263 */       for (byte b = 0; b < this.c.size; b++) {
/* 264 */         (((Enemy.EnemyReference[])this.c.items)[b]).enemy.setSpeed(0.64F);
/*     */       }
/*     */       return;
/*     */     } 
/* 268 */     Enemy enemy = this.b.enemy;
/*     */ 
/*     */ 
/*     */     
/* 272 */     float f1 = 0.0F;
/* 273 */     for (byte b1 = 1; b1 < this.c.size; b1++) {
/* 274 */       Enemy enemy1 = (((Enemy.EnemyReference[])this.c.items)[b1]).enemy;
/*     */       Enemy enemy2;
/*     */       float f;
/* 277 */       if ((f = (enemy2 = (((Enemy.EnemyReference[])this.c.items)[b1 - 1]).enemy).passedTiles - enemy1.passedTiles - 0.55F) > 0.0F) {
/* 278 */         f1 += f;
/*     */       }
/*     */     } 
/*     */     
/* 282 */     float f2 = 0.32F - f1;
/*     */     
/* 284 */     if (this.c.size <= 1) {
/* 285 */       f2 = 0.2F;
/*     */     }
/* 287 */     if (f2 < 0.2F) f2 = 0.2F;
/*     */     
/* 289 */     enemy.setSpeed(f2);
/*     */ 
/*     */     
/* 292 */     for (byte b2 = 1; b2 < this.c.size; b2++) {
/* 293 */       Enemy enemy1 = (((Enemy.EnemyReference[])this.c.items)[b2]).enemy;
/* 294 */       Enemy enemy2 = (((Enemy.EnemyReference[])this.c.items)[b2 - 1]).enemy;
/*     */       
/* 296 */       enemy1.setSpeed(0.32F);
/*     */       
/* 298 */       if (enemy2.passedTiles - enemy1.passedTiles < 0.55F) {
/*     */         
/* 300 */         enemy2.passedTiles -= 0.55F;
/* 301 */         if (enemy1.passedTiles < 0.0F) enemy1.passedTiles = 0.0F;
/*     */       
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 307 */     if (enemy.getHealth() < enemy.maxHealth * 0.5F && (enemy.buffsByType == null || (enemy.buffsByType[BuffType.REGENERATION.ordinal()]).size == 0))
/*     */     {
/* 309 */       if (this.f.size != 0) {
/* 310 */         MobchainBossCreepEnemy mobchainBossCreepEnemy = (MobchainBossCreepEnemy)((Enemy.EnemyReference)this.f.first()).enemy;
/*     */         
/*     */         RegenerationBuff regenerationBuff;
/* 313 */         (regenerationBuff = new RegenerationBuff()).setup(2.5F, 25.0F, mobchainBossCreepEnemy.getHealth() * 0.6F, this.i.enemy.getReference((Enemy)mobchainBossCreepEnemy));
/*     */         
/*     */         InvulnerabilityBuff invulnerabilityBuff;
/* 316 */         (invulnerabilityBuff = new InvulnerabilityBuff()).setup(2.5F, 4.0F);
/*     */         
/*     */         SlippingBuff slippingBuff;
/* 319 */         (slippingBuff = new SlippingBuff()).setup(3.0F, 6.0F);
/* 320 */         slippingBuff.speedMultiplier = 0.4F;
/*     */         
/* 322 */         this.i.buff.P_INVULNERABILITY.removeAllBuffs(enemy, BuffType.INVULNERABILITY);
/*     */         
/* 324 */         this.i.buff.P_REGENERATION.addBuffStackSameSourceRemoveOthers(enemy, regenerationBuff, true);
/* 325 */         this.i.buff.P_SLIPPING.addBuff(enemy, slippingBuff);
/* 326 */         this.i.buff.P_INVULNERABILITY.addBuff(enemy, invulnerabilityBuff);
/*     */         
/* 328 */         this.i.damage.queueEnemyKill(this.i.damage.obtainRecord().setup((Enemy)mobchainBossCreepEnemy, 1.0F, DamageType.BULLET));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 335 */     return this.h;
/*     */   }
/*     */   
/*     */   private void d() {
/* 339 */     this.i.events.getListeners(EnemyDie.class).remove(this.n);
/* 340 */     this.i.events.getListeners(EnemySpawn.class).remove(this);
/* 341 */     this.i.events.getListeners(EnemyDespawn.class).remove(this.m);
/*     */ 
/*     */     
/* 344 */     if (this.j != null) {
/* 345 */       this.i._gameUi.mainUi.removeBossHpBar(this.j);
/* 346 */       this.j = null;
/*     */     } 
/* 348 */     this.i = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleEvent(EnemySpawn paramEnemySpawn) {
/*     */     Enemy enemy;
/* 354 */     if ((enemy = paramEnemySpawn.getEnemy()).wave == this.a)
/* 355 */       if (enemy.type == EnemyType.MOBCHAIN_BOSS_BODY || enemy.type == EnemyType.MOBCHAIN_BOSS_HEAD) {
/* 356 */         this.d--;
/* 357 */         this.c.add(this.i.enemy.getReference(enemy));
/* 358 */         if (enemy.type == EnemyType.MOBCHAIN_BOSS_HEAD) {
/*     */           
/* 360 */           this.b = this.i.enemy.getReference(enemy); return;
/*     */         } 
/* 362 */       } else if (enemy.type == EnemyType.MOBCHAIN_BOSS_CREEP) {
/* 363 */         this.f.add(this.i.enemy.getReference(enemy));
/*     */       }  
/*     */   }
/*     */   
/*     */   private MobchainBossWaveProcessor() {}
/*     */   
/*     */   @REGS
/*     */   public static class OnEnemyDespawn extends SerializableListener<MobchainBossWaveProcessor> implements Listener<EnemyDespawn> { private OnEnemyDespawn() {}
/*     */     
/*     */     private OnEnemyDespawn(MobchainBossWaveProcessor param1MobchainBossWaveProcessor) {
/* 373 */       this.a = param1MobchainBossWaveProcessor;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(EnemyDespawn param1EnemyDespawn) {
/*     */       Enemy enemy;
/* 379 */       if ((enemy = param1EnemyDespawn.getEnemy()).wave == MobchainBossWaveProcessor.a((MobchainBossWaveProcessor)this.a)) {
/* 380 */         int i; if (enemy.type == EnemyType.MOBCHAIN_BOSS_BODY || enemy.type == EnemyType.MOBCHAIN_BOSS_HEAD) {
/* 381 */           if (enemy == (MobchainBossWaveProcessor.b((MobchainBossWaveProcessor)this.a)).enemy) {
/*     */             
/* 383 */             MobchainBossWaveProcessor.a((MobchainBossWaveProcessor)this.a, Enemy.EnemyReference.NULL);
/*     */ 
/*     */             
/* 386 */             for (int j = (MobchainBossWaveProcessor.c((MobchainBossWaveProcessor)this.a)).size - 1; j >= 0; j--) {
/*     */               Enemy enemy1;
/* 388 */               if ((enemy1 = ((Enemy.EnemyReference)MobchainBossWaveProcessor.c((MobchainBossWaveProcessor)this.a).get(j)).enemy) != null) {
/* 389 */                 (MobchainBossWaveProcessor.d((MobchainBossWaveProcessor)this.a)).damage.queueEnemyKill((MobchainBossWaveProcessor.d((MobchainBossWaveProcessor)this.a)).damage.obtainRecord().setup(enemy1, 1.0F, DamageType.BULLET));
/*     */               }
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 395 */           EntityUtils.removeByValue(MobchainBossWaveProcessor.e((MobchainBossWaveProcessor)this.a), enemy);
/*     */           
/* 397 */           MobchainBossHeadEnemy mobchainBossHeadEnemy = (MobchainBossHeadEnemy)(MobchainBossWaveProcessor.b((MobchainBossWaveProcessor)this.a)).enemy;
/* 398 */           if ((MobchainBossWaveProcessor.e((MobchainBossWaveProcessor)this.a)).size == 1 && MobchainBossWaveProcessor.f((MobchainBossWaveProcessor)this.a) == 0 && mobchainBossHeadEnemy != null) {
/*     */             
/* 400 */             mobchainBossHeadEnemy.vulnerable = true;
/*     */ 
/*     */             
/* 403 */             Array array = new Array(TowerType.class);
/* 404 */             for (i = 0; i < (MobchainBossWaveProcessor.d((MobchainBossWaveProcessor)this.a)).tower.towers.size; i++) {
/*     */               Tower tower;
/* 406 */               if ((tower = ((Tower[])(MobchainBossWaveProcessor.d((MobchainBossWaveProcessor)this.a)).tower.towers.items)[i]).type != TowerType.AIR && tower.type != TowerType.FREEZING)
/*     */               {
/*     */ 
/*     */                 
/* 410 */                 if (!array.contains(tower.type, true))
/* 411 */                   array.add(tower.type); 
/*     */               }
/*     */             } 
/* 414 */             if (array.size < 4) {
/* 415 */               if (!array.contains(TowerType.BASIC, true)) array.add(TowerType.BASIC); 
/* 416 */               if (!array.contains(TowerType.CANNON, true)) array.add(TowerType.CANNON); 
/* 417 */               if (!array.contains(TowerType.SNIPER, true)) array.add(TowerType.SNIPER); 
/* 418 */               if (!array.contains(TowerType.MULTISHOT, true)) array.add(TowerType.MULTISHOT);
/*     */             
/*     */             } 
/*     */             
/* 422 */             if ((i = MathUtils.floor(2.0F + (float)StrictMath.pow((MobchainBossWaveProcessor.a((MobchainBossWaveProcessor)this.a)).waveNumber, 0.85D) / 12.0F)) > 5) i = 5; 
/* 423 */             MobchainBossWaveProcessor.a((MobchainBossWaveProcessor)this.a, i);
/* 424 */             for (byte b = 0; b < i; b++) {
/* 425 */               TowerType towerType = ((TowerType[])array.items)[(MobchainBossWaveProcessor.d((MobchainBossWaveProcessor)this.a)).gameState.randomInt(array.size)];
/*     */               
/*     */               MobchainBossCreepEnemy mobchainBossCreepEnemy;
/* 428 */               (mobchainBossCreepEnemy = (MobchainBossCreepEnemy)Game.i.enemyManager.getFactory(EnemyType.MOBCHAIN_BOSS_CREEP).obtain()).setSpeed(mobchainBossHeadEnemy.getSpeed());
/* 429 */               mobchainBossCreepEnemy.maxHealth = mobchainBossHeadEnemy.maxHealth * 0.23F;
/* 430 */               mobchainBossCreepEnemy.setHealth(mobchainBossCreepEnemy.maxHealth);
/*     */               
/* 432 */               mobchainBossCreepEnemy.killScore = StrictMath.round(mobchainBossHeadEnemy.killScore * 0.1F);
/* 433 */               mobchainBossCreepEnemy.bounty = 0.0F;
/* 434 */               mobchainBossCreepEnemy.setKillExp(mobchainBossHeadEnemy.getKillExp() * 0.1F);
/*     */               
/* 436 */               mobchainBossCreepEnemy.vulnerableTo = towerType;
/* 437 */               mobchainBossCreepEnemy.color = Game.i.towerManager.getFactory(towerType).getColor();
/*     */               
/*     */               float f;
/* 440 */               if ((f = mobchainBossHeadEnemy.passedTiles - 0.5F - b * 0.5F) < 0.0F) f = 0.0F; 
/* 441 */               (MobchainBossWaveProcessor.d((MobchainBossWaveProcessor)this.a)).enemy.addEnemyWithPath((Enemy)mobchainBossCreepEnemy, mobchainBossHeadEnemy.spawnTile, mobchainBossHeadEnemy.graphPath, -1, mobchainBossHeadEnemy.wave, f);
/*     */             } 
/*     */           }  return;
/* 444 */         }  if (i.type == EnemyType.MOBCHAIN_BOSS_CREEP)
/* 445 */           EntityUtils.removeByValue(MobchainBossWaveProcessor.c((MobchainBossWaveProcessor)this.a), i); 
/*     */       } 
/*     */     } }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie
/*     */     extends SerializableListener<MobchainBossWaveProcessor> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(MobchainBossWaveProcessor param1MobchainBossWaveProcessor) {
/* 456 */       this.a = param1MobchainBossWaveProcessor;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       DamageRecord damageRecord;
/*     */       Enemy enemy;
/* 463 */       if ((enemy = (damageRecord = param1EnemyDie.getLastDamage()).getEnemy()).wave == MobchainBossWaveProcessor.a((MobchainBossWaveProcessor)this.a) && 
/* 464 */         enemy.type == EnemyType.MOBCHAIN_BOSS_HEAD) {
/*     */ 
/*     */         
/* 467 */         Tower tower = damageRecord.getTower();
/* 468 */         DamageType damageType = damageRecord.getDamageType();
/* 469 */         (MobchainBossWaveProcessor.d((MobchainBossWaveProcessor)this.a)).wave.stopSpawningCurrentWave(MobchainBossWaveProcessor.a((MobchainBossWaveProcessor)this.a), tower, damageType);
/* 470 */         for (int i = (MobchainBossWaveProcessor.e((MobchainBossWaveProcessor)this.a)).size - 1; i >= 0; i--) {
/*     */           Enemy enemy1;
/* 472 */           if ((enemy1 = (((Enemy.EnemyReference[])(MobchainBossWaveProcessor.e((MobchainBossWaveProcessor)this.a)).items)[i]).enemy) != null && enemy1 != enemy)
/*     */           {
/* 474 */             (MobchainBossWaveProcessor.d((MobchainBossWaveProcessor)this.a)).damage.queueEnemyKill(damageRecord.copyFor(enemy1, (MobchainBossWaveProcessor.d((MobchainBossWaveProcessor)this.a)).damage.obtainRecord()));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class MobchainBossWaveProcessorFactory extends WaveProcessor.WaveProcessorFactory<MobchainBossWaveProcessor> {
/*     */     public MobchainBossWaveProcessorFactory() {
/* 483 */       super(BossType.MOBCHAIN);
/*     */     }
/*     */ 
/*     */     
/*     */     public MobchainBossWaveProcessor create() {
/* 488 */       return new MobchainBossWaveProcessor((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\processors\MobchainBossWaveProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */