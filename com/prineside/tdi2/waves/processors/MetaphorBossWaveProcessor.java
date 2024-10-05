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
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyGroup;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Wave;
/*     */ import com.prineside.tdi2.WaveProcessor;
/*     */ import com.prineside.tdi2.enemies.bosses.MetaphorBossCreepEnemy;
/*     */ import com.prineside.tdi2.enemies.bosses.MetaphorBossEnemy;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDespawn;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.WaveSystem;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.ui.components.BossHpBar;
/*     */ import com.prineside.tdi2.utils.EntityUtils;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public class MetaphorBossWaveProcessor
/*     */   implements KryoSerializable, WaveProcessor
/*     */ {
/*     */   private Wave a;
/*     */   private Enemy.EnemyReference b;
/*  46 */   private Array<Enemy.EnemyReference> c = new Array(true, 8, Enemy.EnemyReference.class);
/*     */   
/*     */   private boolean d = false;
/*  49 */   private Array<Tower> e = new Array(Tower.class);
/*  50 */   private Array<Tower> f = new Array(Tower.class);
/*     */   
/*     */   private GameSystemProvider g;
/*     */   
/*  54 */   private int h = 0;
/*     */   @NAGS
/*     */   private BossHpBar i;
/*  57 */   private OnEnemySpawn j = new OnEnemySpawn(this, (byte)0);
/*  58 */   private OnEnemyDespawn k = new OnEnemyDespawn(this, (byte)0);
/*  59 */   private OnEnemyDie l = new OnEnemyDie(this);
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  63 */     paramKryo.writeObjectOrNull(paramOutput, this.a, Wave.class);
/*  64 */     paramKryo.writeObjectOrNull(paramOutput, this.b, Enemy.EnemyReference.class);
/*  65 */     paramKryo.writeObject(paramOutput, this.c);
/*  66 */     paramOutput.writeBoolean(this.d);
/*  67 */     paramKryo.writeObject(paramOutput, this.e);
/*  68 */     paramKryo.writeObject(paramOutput, this.f);
/*  69 */     paramKryo.writeObjectOrNull(paramOutput, this.g, GameSystemProvider.class);
/*  70 */     paramOutput.writeVarInt(this.h, true);
/*  71 */     paramKryo.writeObjectOrNull(paramOutput, this.j, OnEnemySpawn.class);
/*  72 */     paramKryo.writeObjectOrNull(paramOutput, this.k, OnEnemyDespawn.class);
/*  73 */     paramKryo.writeObjectOrNull(paramOutput, this.l, OnEnemyDie.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  78 */     this.a = (Wave)paramKryo.readObjectOrNull(paramInput, Wave.class);
/*  79 */     this.b = (Enemy.EnemyReference)paramKryo.readObjectOrNull(paramInput, Enemy.EnemyReference.class);
/*  80 */     this.c = (Array<Enemy.EnemyReference>)paramKryo.readObject(paramInput, Array.class);
/*  81 */     this.d = paramInput.readBoolean();
/*  82 */     this.e = (Array<Tower>)paramKryo.readObject(paramInput, Array.class);
/*  83 */     this.f = (Array<Tower>)paramKryo.readObject(paramInput, Array.class);
/*  84 */     this.g = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  85 */     this.h = paramInput.readVarInt(true);
/*  86 */     this.j = (OnEnemySpawn)paramKryo.readObjectOrNull(paramInput, OnEnemySpawn.class);
/*  87 */     this.k = (OnEnemyDespawn)paramKryo.readObjectOrNull(paramInput, OnEnemyDespawn.class);
/*  88 */     this.l = (OnEnemyDie)paramKryo.readObjectOrNull(paramInput, OnEnemyDie.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<EnemyGroup> generateEnemyGroups(int paramInt1, int paramInt2) {
/*  95 */     float f2 = Wave.calculateDefaultBossWaveCoinsSum(paramInt1);
/*  96 */     float f3 = Wave.calculateDefaultBossWaveExpSum(paramInt1);
/*  97 */     float f4 = Wave.calculateDefaultBossWaveScoreSum(paramInt1);
/*     */     
/*  99 */     Array<EnemyGroup> array = new Array();
/* 100 */     float f1 = WaveSystem.getWaveValue(paramInt1, paramInt2);
/*     */     
/* 102 */     f1 = (f1 = 100.0F + (float)StrictMath.pow(f1 * 10.0D, 1.275D) * 2.0F) * 0.3F;
/*     */     
/* 104 */     array.add(new EnemyGroup(EnemyType.METAPHOR_BOSS, 0.27F, f1 * 1.73F, 1, 1.0F, 0.0F, f2 * 0.5F, f3 * 0.5F, (int)(f4 * 0.041666668F)));
/*     */     
/* 106 */     paramInt2 = MetaphorBossCreepEnemy.Kind.values.length << 1;
/* 107 */     f1 *= 0.22F;
/* 108 */     array.add(new EnemyGroup(EnemyType.METAPHOR_BOSS_CREEP, 0.27F, f1, paramInt2, 0.0F, 0.25F, f2 * 0.5F / paramInt2, f3 * 0.5F / paramInt2, (int)(f4 * 0.5F / paramInt2)));
/*     */     
/* 110 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public Wave setup(GameSystemProvider paramGameSystemProvider, int paramInt1, int paramInt2) {
/* 115 */     this.g = paramGameSystemProvider;
/*     */     
/* 117 */     Array<EnemyGroup> array = generateEnemyGroups(paramInt1, paramInt2);
/* 118 */     this.h = 0;
/* 119 */     for (byte b = 0; b < array.size; b++) {
/*     */       EnemyGroup enemyGroup;
/* 121 */       if ((enemyGroup = (EnemyGroup)array.get(b)).getEnemyType() == EnemyType.METAPHOR_BOSS_CREEP) {
/* 122 */         this.h += enemyGroup.count;
/*     */       }
/*     */     } 
/* 125 */     this.a = new Wave(paramInt1, paramInt2, array);
/* 126 */     this.a.enemiesCanBeSplitBetweenSpawns = false;
/* 127 */     this.a.enemiesCanHaveRandomSideShifts = true;
/* 128 */     this.a.waveMessage = Config.isHeadless() ? null : Game.i.localeManager.i18n.get("enemy_name_METAPHOR_BOSS");
/* 129 */     this.a.waveProcessor = this;
/*     */     
/* 131 */     paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this.j).setDescription("MetaphorBossWaveProcessor - stores creep and boss references, configures creeps");
/* 132 */     paramGameSystemProvider.events.getListeners(EnemyDespawn.class).addStateAffecting(this.k).setDescription("MetaphorBossWaveProcessor - removes enemies from its list of creeps");
/* 133 */     paramGameSystemProvider.events.getListeners(EnemyDie.class).addStateAffecting(this.l).setDescription("MetaphorBossWaveProcessor - kills creeps when head is dead");
/*     */     
/* 135 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getNextWaveDelayMultiplier() {
/* 140 */     return 7.0F;
/*     */   }
/*     */   
/*     */   public String getTowerOutOfOrderReasonNearby() {
/* 144 */     return "DisabledByMetaphorNearbyWave" + this.a.waveNumber;
/*     */   }
/*     */   
/*     */   public String getTowerOutOfOrderReasonPower() {
/* 148 */     return "DisabledByMetaphorPowerWave" + this.a.waveNumber;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 153 */     if (this.d || this.b == null)
/*     */       return; 
/* 155 */     if (this.b.enemy == null) {
/* 156 */       this.d = true;
/* 157 */       b();
/*     */       
/*     */       return;
/*     */     } 
/* 161 */     String str1 = getTowerOutOfOrderReasonNearby();
/* 162 */     String str2 = getTowerOutOfOrderReasonPower();
/*     */     
/* 164 */     MetaphorBossEnemy metaphorBossEnemy = (MetaphorBossEnemy)this.b.enemy;
/*     */ 
/*     */     
/* 167 */     for (byte b2 = 0; b2 < this.e.size; b2++) {
/* 168 */       (((Tower[])this.e.items)[b2]).outOfOrder.removeReason(str1);
/*     */     }
/* 170 */     this.e.clear();
/*     */     
/*     */     Tile tile;
/* 173 */     if ((tile = metaphorBossEnemy.getCurrentTile()) != null) {
/* 174 */       this.g.map.traverseNeighborTilesIncludingTile(tile, paramTile -> {
/*     */             PlatformTile platformTile;
/*     */             
/*     */             if (paramTile instanceof PlatformTile && (platformTile = (PlatformTile)paramTile).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/*     */               Tower tower;
/*     */               
/*     */               (tower = (Tower)platformTile.building).outOfOrder.addReason(paramString);
/*     */               
/*     */               this.e.add(tower);
/*     */             } 
/*     */             
/*     */             return true;
/*     */           });
/*     */     }
/* 188 */     byte b1 = 0;
/*     */     float f;
/* 190 */     if ((f = metaphorBossEnemy.getHealth() / metaphorBossEnemy.maxHealth) < 0.25D) {
/* 191 */       b1 = 3;
/* 192 */     } else if (f < 0.5D) {
/* 193 */       b1 = 2;
/* 194 */     } else if (f < 0.75D) {
/* 195 */       b1 = 1;
/*     */     } 
/*     */     
/* 198 */     if (b1 != 0) {
/* 199 */       for (int i = this.f.size - 1; i >= 0; i--) {
/* 200 */         Tower tower = ((Tower[])this.f.items)[i];
/* 201 */         if (this.e.contains(tower, true)) {
/*     */ 
/*     */           
/* 204 */           (((Tower[])this.f.items)[i]).outOfOrder.removeReason(str2);
/* 205 */           this.f.removeIndex(i);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 210 */       if (this.f.size < b1) {
/*     */         
/* 212 */         Tower tower = null;
/* 213 */         for (byte b = 0; b < this.g.tower.towers.size; b++) {
/*     */           Tower tower1;
/* 215 */           if (!(tower1 = ((Tower[])this.g.tower.towers.items)[b]).outOfOrder.hasReason(str2) && !tower1.outOfOrder.hasReason(str1) && (
/* 216 */             tower == null || tower.moneySpentOn < tower1.moneySpentOn)) {
/* 217 */             tower = tower1;
/*     */           }
/*     */         } 
/*     */         
/* 221 */         if (tower != null)
/*     */         {
/* 223 */           tower.outOfOrder.addReason(str2);
/* 224 */           this.f.add(tower);
/*     */         }
/*     */       
/*     */       } 
/* 228 */     } else if (this.f.size != 0) {
/* 229 */       for (byte b = 0; b < this.f.size; b++) {
/* 230 */         (((Tower[])this.f.items)[b]).outOfOrder.removeReason(str2);
/*     */       }
/* 232 */       this.f.clear();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 237 */     EntityUtils.removeNullRefs(this.c);
/*     */     
/* 239 */     for (byte b3 = 0; b3 < this.c.size; b3++) {
/*     */       MetaphorBossCreepEnemy metaphorBossCreepEnemy;
/* 241 */       if ((metaphorBossCreepEnemy = (MetaphorBossCreepEnemy)(((Enemy.EnemyReference[])this.c.items)[b3]).enemy).getKind() == MetaphorBossCreepEnemy.Kind.FRONT) {
/*     */         
/* 243 */         if (metaphorBossCreepEnemy.passedTiles < metaphorBossEnemy.passedTiles + 0.5F) {
/*     */           float f1;
/*     */           
/* 246 */           if ((f1 = metaphorBossCreepEnemy.getSpeed() + 0.4F * paramFloat) > 1.2F) {
/* 247 */             f1 = 1.2F;
/*     */           }
/* 249 */           metaphorBossCreepEnemy.setSpeed(f1);
/* 250 */         } else if (metaphorBossCreepEnemy.passedTiles > metaphorBossEnemy.passedTiles + 2.0F) {
/*     */           float f1;
/*     */           
/* 253 */           if ((f1 = metaphorBossCreepEnemy.getSpeed() - 0.8F * paramFloat) < 0.2F) {
/* 254 */             f1 = 0.2F;
/* 255 */           } else if (f1 > 1.2F) {
/* 256 */             f1 = 1.2F;
/*     */           } 
/* 258 */           metaphorBossCreepEnemy.setSpeed(f1);
/*     */         } 
/* 260 */       } else if (metaphorBossCreepEnemy.getKind() == MetaphorBossCreepEnemy.Kind.REAR) {
/*     */         
/* 262 */         if (metaphorBossCreepEnemy.passedTiles < metaphorBossEnemy.passedTiles - 2.0F) {
/*     */           
/* 264 */           metaphorBossCreepEnemy.setSpeed(metaphorBossCreepEnemy.getSpeed() + 0.4F * paramFloat);
/* 265 */         } else if (metaphorBossCreepEnemy.passedTiles > metaphorBossEnemy.passedTiles - 0.5F) {
/*     */           float f1;
/* 267 */           if ((f1 = metaphorBossCreepEnemy.getSpeed() - 0.8F * paramFloat) < 0.2F) {
/* 268 */             f1 = 0.2F;
/* 269 */           } else if (f1 > 1.2F) {
/* 270 */             f1 = 1.2F;
/*     */           } 
/* 272 */           metaphorBossCreepEnemy.setSpeed(f1);
/*     */         } 
/* 274 */       } else if (metaphorBossCreepEnemy.getKind() == MetaphorBossCreepEnemy.Kind.RANDOM_SPEED) {
/*     */         
/* 276 */         metaphorBossCreepEnemy.setSpeed(0.27F + PMath.sin(metaphorBossCreepEnemy.existsTime) * 0.2F);
/*     */       } 
/*     */     } 
/* 279 */     metaphorBossEnemy.creepCount = this.c.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 286 */     return this.d;
/*     */   }
/*     */   
/*     */   private void a() {
/* 290 */     if (this.b == null)
/*     */       return; 
/* 292 */     if (this.i == null && this.g._gameUi != null) {
/* 293 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 303 */         .i = (new BossHpBar()).setBossName(Game.i.localeManager.i18n.get("enemy_name_METAPHOR_BOSS")).setMainBarColor(new Color(856888319), new Color(-1340663809)).setSmallBarsCount(1).setFirstSmallBarColor(new Color(590230527), new Color(1618840575)).setSmallBarOneProgress(0.3D).setLabelsColor(new Color(-448050177)).addMark(0.25F).addMark(0.5F).addMark(0.75F).setIcon((Drawable)Game.i.assetManager.getDrawable("boss-wave-icon-METAPHOR"));
/* 304 */       this.g._gameUi.mainUi.addBossHpBar(this.i);
/*     */     } 
/* 306 */     if (this.i != null) {
/* 307 */       MetaphorBossEnemy metaphorBossEnemy = (MetaphorBossEnemy)this.b.enemy;
/* 308 */       this.i.setMainHP(metaphorBossEnemy.getHealth(), metaphorBossEnemy.maxHealth);
/*     */       
/* 310 */       float f = 0.0F;
/* 311 */       for (byte b = 0; b < this.c.size; b++) {
/*     */         MetaphorBossCreepEnemy metaphorBossCreepEnemy;
/* 313 */         if ((metaphorBossCreepEnemy = (MetaphorBossCreepEnemy)((Enemy.EnemyReference)this.c.get(b)).enemy) != null) {
/* 314 */           f += metaphorBossCreepEnemy.getHealth() / metaphorBossCreepEnemy.maxHealth;
/*     */         }
/*     */       } 
/* 317 */       this.i.setSmallBarOneProgress((f / this.h));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 323 */     a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b() {
/* 333 */     this.g.events.getListeners(EnemySpawn.class).remove(this.j);
/* 334 */     this.g.events.getListeners(EnemyDespawn.class).remove(this.k);
/* 335 */     this.g.events.getListeners(EnemyDie.class).remove(this.l);
/* 336 */     this.c.clear();
/*     */     
/* 338 */     String str1 = getTowerOutOfOrderReasonNearby();
/* 339 */     String str2 = getTowerOutOfOrderReasonPower();
/*     */     
/* 341 */     if (this.f.size != 0) {
/* 342 */       for (byte b = 0; b < this.f.size; b++) {
/* 343 */         (((Tower[])this.f.items)[b]).outOfOrder.removeReason(str2);
/*     */       }
/* 345 */       this.f.clear();
/*     */     } 
/* 347 */     if (this.e.size != 0) {
/* 348 */       for (byte b = 0; b < this.e.size; b++) {
/* 349 */         (((Tower[])this.e.items)[b]).outOfOrder.removeReason(str1);
/*     */       }
/* 351 */       this.e.clear();
/*     */     } 
/*     */     
/* 354 */     if (this.i != null) {
/* 355 */       this.g._gameUi.mainUi.removeBossHpBar(this.i);
/* 356 */       this.i = null;
/*     */     } 
/*     */     
/* 359 */     this.g = null;
/*     */   }
/*     */   
/*     */   private MetaphorBossWaveProcessor() {}
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie extends SerializableListener<MetaphorBossWaveProcessor> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(MetaphorBossWaveProcessor param1MetaphorBossWaveProcessor) {
/* 369 */       this.a = param1MetaphorBossWaveProcessor;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       DamageRecord damageRecord;
/* 375 */       Enemy enemy = (damageRecord = param1EnemyDie.getLastDamage()).getEnemy();
/* 376 */       if (MetaphorBossWaveProcessor.a((MetaphorBossWaveProcessor)this.a) != null && enemy == (MetaphorBossWaveProcessor.a((MetaphorBossWaveProcessor)this.a)).enemy)
/*     */       {
/* 378 */         for (int i = (MetaphorBossWaveProcessor.b((MetaphorBossWaveProcessor)this.a)).size - 1; i >= 0; i--) {
/* 379 */           if ((((Enemy.EnemyReference[])(MetaphorBossWaveProcessor.b((MetaphorBossWaveProcessor)this.a)).items)[i]).enemy != null)
/* 380 */             (MetaphorBossWaveProcessor.c((MetaphorBossWaveProcessor)this.a)).damage.queueEnemyKill(damageRecord.copyFor((((Enemy.EnemyReference[])(MetaphorBossWaveProcessor.b((MetaphorBossWaveProcessor)this.a)).items)[i]).enemy, (MetaphorBossWaveProcessor.c((MetaphorBossWaveProcessor)this.a)).damage.obtainRecord())); 
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnEnemyDespawn
/*     */     extends SerializableListener<MetaphorBossWaveProcessor> implements Listener<EnemyDespawn> {
/*     */     private OnEnemyDespawn() {}
/*     */     
/*     */     private OnEnemyDespawn(MetaphorBossWaveProcessor param1MetaphorBossWaveProcessor) {
/* 392 */       this.a = param1MetaphorBossWaveProcessor;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(EnemyDespawn param1EnemyDespawn) {
/*     */       Enemy enemy;
/* 398 */       if ((enemy = param1EnemyDespawn.getEnemy()).type == EnemyType.METAPHOR_BOSS_CREEP)
/* 399 */         EntityUtils.removeByValue(MetaphorBossWaveProcessor.b((MetaphorBossWaveProcessor)this.a), enemy); 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class OnEnemySpawn
/*     */     extends SerializableListener<MetaphorBossWaveProcessor> implements Listener<EnemySpawn> {
/*     */     private OnEnemySpawn() {}
/*     */     
/*     */     private OnEnemySpawn(MetaphorBossWaveProcessor param1MetaphorBossWaveProcessor) {
/* 409 */       this.a = param1MetaphorBossWaveProcessor;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(EnemySpawn param1EnemySpawn) {
/*     */       Enemy enemy;
/* 415 */       if ((enemy = param1EnemySpawn.getEnemy()).wave == MetaphorBossWaveProcessor.d((MetaphorBossWaveProcessor)this.a) && enemy.type == EnemyType.METAPHOR_BOSS) {
/* 416 */         MetaphorBossWaveProcessor.a((MetaphorBossWaveProcessor)this.a, (MetaphorBossWaveProcessor.c((MetaphorBossWaveProcessor)this.a)).enemy.getReference(enemy)); return;
/* 417 */       }  if (enemy.wave == MetaphorBossWaveProcessor.d((MetaphorBossWaveProcessor)this.a) && enemy.type == EnemyType.METAPHOR_BOSS_CREEP) {
/* 418 */         float f; MetaphorBossCreepEnemy metaphorBossCreepEnemy = (MetaphorBossCreepEnemy)enemy;
/* 419 */         MetaphorBossWaveProcessor.b((MetaphorBossWaveProcessor)this.a).add((MetaphorBossWaveProcessor.c((MetaphorBossWaveProcessor)this.a)).enemy.getReference((Enemy)metaphorBossCreepEnemy));
/*     */ 
/*     */         
/* 422 */         MetaphorBossCreepEnemy.Kind kind = MetaphorBossCreepEnemy.Kind.values[((MetaphorBossWaveProcessor.b((MetaphorBossWaveProcessor)this.a)).size - 1) % MetaphorBossCreepEnemy.Kind.values.length];
/* 423 */         metaphorBossCreepEnemy.setKind(kind);
/* 424 */         if (kind == MetaphorBossCreepEnemy.Kind.HIGH_HP) {
/* 425 */           f = metaphorBossCreepEnemy.maxHealth * 3.0F;
/* 426 */           metaphorBossCreepEnemy.setMaxHealth(f);
/* 427 */           metaphorBossCreepEnemy.setHealth(f); return;
/* 428 */         }  if (f == MetaphorBossCreepEnemy.Kind.LOW_HP) {
/* 429 */           f = metaphorBossCreepEnemy.maxHealth * 0.333F;
/* 430 */           metaphorBossCreepEnemy.setMaxHealth(f);
/* 431 */           metaphorBossCreepEnemy.setHealth(f);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class MetaphorBossWaveProcessorFactory extends WaveProcessor.WaveProcessorFactory<MetaphorBossWaveProcessor> {
/*     */     public MetaphorBossWaveProcessorFactory() {
/* 439 */       super(BossType.METAPHOR);
/*     */     }
/*     */ 
/*     */     
/*     */     public MetaphorBossWaveProcessor create() {
/* 444 */       return new MetaphorBossWaveProcessor((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\processors\MetaphorBossWaveProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */