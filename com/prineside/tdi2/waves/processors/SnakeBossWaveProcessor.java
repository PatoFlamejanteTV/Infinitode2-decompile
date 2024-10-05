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
/*     */ import com.prineside.tdi2.enemies.bosses.SnakeBossHeadEnemy;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
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
/*     */ public class SnakeBossWaveProcessor
/*     */   implements KryoSerializable, WaveProcessor, Listener<EnemySpawn> {
/*     */   private Wave a;
/*  41 */   private Enemy.EnemyReference b = Enemy.EnemyReference.NULL;
/*  42 */   private Array<Enemy.EnemyReference> c = new Array(true, 8, Enemy.EnemyReference.class);
/*     */   private int d;
/*     */   private int e;
/*  45 */   private int f = 0;
/*     */   
/*     */   private boolean g = false;
/*     */   
/*     */   @NAGS
/*     */   private BossHpBar h;
/*     */   @NAGS
/*     */   private Drawable i;
/*     */   private GameSystemProvider j;
/*  54 */   private OnEnemyDespawn k = new OnEnemyDespawn(this, (byte)0);
/*  55 */   private OnEnemyDie l = new OnEnemyDie(this);
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  59 */     paramKryo.writeObjectOrNull(paramOutput, this.a, Wave.class);
/*  60 */     paramKryo.writeObject(paramOutput, this.b);
/*  61 */     paramKryo.writeObject(paramOutput, this.c);
/*  62 */     paramOutput.writeVarInt(this.d, true);
/*  63 */     paramOutput.writeVarInt(this.e, true);
/*  64 */     paramOutput.writeVarInt(this.f, true);
/*  65 */     paramOutput.writeBoolean(this.g);
/*  66 */     paramKryo.writeObjectOrNull(paramOutput, this.j, GameSystemProvider.class);
/*  67 */     paramKryo.writeObjectOrNull(paramOutput, this.k, OnEnemyDespawn.class);
/*  68 */     paramKryo.writeObjectOrNull(paramOutput, this.l, OnEnemyDie.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  73 */     this.a = (Wave)paramKryo.readObjectOrNull(paramInput, Wave.class);
/*  74 */     this.b = (Enemy.EnemyReference)paramKryo.readObject(paramInput, Enemy.EnemyReference.class);
/*  75 */     this.c = (Array<Enemy.EnemyReference>)paramKryo.readObject(paramInput, Array.class);
/*  76 */     this.d = paramInput.readVarInt(true);
/*  77 */     this.e = paramInput.readVarInt(true);
/*  78 */     this.f = paramInput.readVarInt(true);
/*  79 */     this.g = paramInput.readBoolean();
/*  80 */     this.j = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  81 */     this.k = (OnEnemyDespawn)paramKryo.readObjectOrNull(paramInput, OnEnemyDespawn.class);
/*  82 */     this.l = (OnEnemyDie)paramKryo.readObjectOrNull(paramInput, OnEnemyDie.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<EnemyGroup> generateEnemyGroups(int paramInt1, int paramInt2) {
/*  89 */     Array<EnemyGroup> array = new Array();
/*  90 */     float f2 = WaveSystem.getWaveValue(paramInt1, paramInt2);
/*     */     int j;
/*  92 */     if ((j = MathUtils.floor(10.0F + (float)StrictMath.pow(paramInt1, 0.85D) / 6.0F)) > 30) j = 30;
/*     */ 
/*     */     
/*  95 */     float f3 = Wave.calculateDefaultBossWaveCoinsSum(paramInt1);
/*  96 */     float f4 = Wave.calculateDefaultBossWaveExpSum(paramInt1);
/*  97 */     float f1 = Wave.calculateDefaultBossWaveScoreSum(paramInt1);
/*     */     
/*  99 */     float f5 = f3 * 0.5F;
/* 100 */     float f6 = f4 * 0.3F;
/* 101 */     int k = (int)(f1 * 0.3F);
/* 102 */     f3 = f3 * 0.5F / j;
/* 103 */     f4 = f4 * 0.7F / j;
/* 104 */     int i = StrictMath.round(f1 * 0.7F / j);
/*     */ 
/*     */ 
/*     */     
/* 108 */     float f7 = (f2 = (8.0F + (float)StrictMath.pow(f2 * 10.0D, 1.275D) * 0.1F) * 3.5F) / 3.0F * 20.0F / j;
/*     */     
/* 110 */     array.add(new EnemyGroup(EnemyType.SNAKE_BOSS_HEAD, 0.3F, f2 * 2.0F, 1, 0.0F, 0.0F, f5, f6, k));
/* 111 */     if (j > 1) array.add(new EnemyGroup(EnemyType.SNAKE_BOSS_BODY, 0.3F, f7, j - 1, 0.37F, 0.37F, f3, f4, i)); 
/* 112 */     array.add(new EnemyGroup(EnemyType.SNAKE_BOSS_TAIL, 0.3F, f7 * 2.0F * 1.5F, 1, 0.37F * j, 0.0F, f3, f4, i));
/*     */     
/* 114 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public Wave setup(GameSystemProvider paramGameSystemProvider, int paramInt1, int paramInt2) {
/* 119 */     this.j = paramGameSystemProvider;
/*     */     
/* 121 */     Array<EnemyGroup> array = generateEnemyGroups(paramInt1, paramInt2);
/*     */     
/* 123 */     this.e = 0;
/* 124 */     for (byte b = 0; b < array.size; b++) {
/* 125 */       this.e += ((EnemyGroup)array.get(b)).count;
/*     */     }
/* 127 */     this.e--;
/*     */     
/* 129 */     this.a = new Wave(paramInt1, paramInt2, array);
/* 130 */     this.a.enemiesCanBeSplitBetweenSpawns = false;
/* 131 */     this.a.enemiesCanHaveRandomSideShifts = false;
/* 132 */     this.a.waveMessage = Config.isHeadless() ? null : Game.i.localeManager.i18n.get("enemy_name_SNAKE_BOSS_HEAD");
/* 133 */     this.a.waveProcessor = this;
/*     */     
/* 135 */     paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this).setDescription("Stores references for creeps");
/* 136 */     paramGameSystemProvider.events.getListeners(EnemyDespawn.class).addStateAffecting(this.k);
/* 137 */     paramGameSystemProvider.events.getListeners(EnemyDie.class).addStateAffecting(this.l);
/*     */     
/* 139 */     return this.a;
/*     */   }
/*     */   
/*     */   private Drawable a() {
/* 143 */     if (this.i == null) {
/* 144 */       this.i = (Drawable)Game.i.assetManager.getDrawable("buff-health-bar-icon-armor");
/*     */     }
/* 146 */     return this.i;
/*     */   }
/*     */   
/*     */   private void b() {
/* 150 */     if (this.b == null)
/*     */       return; 
/* 152 */     if (this.h == null && this.j._gameUi != null) {
/* 153 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 160 */         .h = (new BossHpBar()).setBossName(Game.i.localeManager.i18n.get("enemy_name_SNAKE_BOSS_HEAD")).setMainBarColor(new Color(607327231), new Color(-1950135553)).setSmallBarsCount(2).setFirstSmallBarColor(new Color(590230527), new Color(1618840575)).setSecondSmallBarColor(new Color(607327231), new Color(-1950135553)).setLabelsColor(new Color(-1361739265)).setIcon((Drawable)Game.i.assetManager.getDrawable("boss-wave-icon-SNAKE"));
/* 161 */       this.j._gameUi.mainUi.addBossHpBar(this.h);
/*     */     } 
/* 163 */     if (this.h != null) {
/*     */       SnakeBossHeadEnemy snakeBossHeadEnemy;
/* 165 */       if ((snakeBossHeadEnemy = (SnakeBossHeadEnemy)this.b.enemy) == null)
/*     */         return; 
/* 167 */       this.h.setMainHP(snakeBossHeadEnemy.getHealth(), snakeBossHeadEnemy.maxHealth);
/*     */       
/* 169 */       if (this.d < this.e) {
/* 170 */         if (!this.h.isEffectIconExists(a())) {
/* 171 */           this.h.addEffectIcon(a());
/*     */         }
/*     */       } else {
/* 174 */         this.h.clearEffectIcons();
/*     */       } 
/*     */       
/* 177 */       float f = 0.0F;
/* 178 */       for (byte b = 0; b < this.c.size; b++) {
/*     */         Enemy enemy;
/* 180 */         if ((enemy = ((Enemy.EnemyReference)this.c.get(b)).enemy) != null && enemy.type != EnemyType.SNAKE_BOSS_HEAD) {
/* 181 */           f += enemy.getHealth() / enemy.maxHealth;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 186 */       this.h.setSmallBarOneProgress(snakeBossHeadEnemy.damageResistance);
/* 187 */       this.h.setSmallBarTwoProgress((f / this.e));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 193 */     b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 198 */     if (this.g)
/*     */       return; 
/* 200 */     EntityUtils.removeNullRefs(this.c);
/*     */     
/* 202 */     if (this.c.size == 0 && this.a.isFullySpawned()) {
/* 203 */       this.g = true;
/* 204 */       c();
/*     */       
/*     */       return;
/*     */     } 
/* 208 */     if (this.b.enemy == null) {
/*     */       
/* 210 */       for (byte b = 0; b < this.c.size; b++) {
/* 211 */         (((Enemy.EnemyReference[])this.c.items)[b]).enemy.setSpeed(1.0F);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     SnakeBossHeadEnemy snakeBossHeadEnemy;
/* 217 */     float f1 = (snakeBossHeadEnemy = (SnakeBossHeadEnemy)this.b.enemy).defaultMinSpeed + this.f / this.e * (snakeBossHeadEnemy.defaultMaxSpeed - snakeBossHeadEnemy.defaultMinSpeed);
/*     */ 
/*     */     
/* 220 */     if (this.d < this.e) {
/* 221 */       snakeBossHeadEnemy.damageResistance = 1.0F;
/*     */     } else {
/* 223 */       snakeBossHeadEnemy.damageResistance = 1.0F - this.f / this.e;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 228 */     float f2 = 0.0F;
/* 229 */     for (byte b1 = 1; b1 < this.c.size; b1++) {
/* 230 */       Enemy enemy1 = (((Enemy.EnemyReference[])this.c.items)[b1]).enemy;
/*     */       Enemy enemy2;
/*     */       float f;
/* 233 */       if ((f = (enemy2 = (((Enemy.EnemyReference[])this.c.items)[b1 - 1]).enemy).passedTiles - enemy1.passedTiles - 0.37F) > 0.0F) {
/* 234 */         f2 += f;
/*     */       }
/*     */     } 
/*     */     
/*     */     float f3;
/* 239 */     if ((f3 = f1 - f2) < snakeBossHeadEnemy.defaultMinSpeed * 0.5F) f3 = snakeBossHeadEnemy.defaultMinSpeed * 0.5F;
/*     */     
/* 241 */     snakeBossHeadEnemy.setSpeed(f3);
/*     */ 
/*     */     
/* 244 */     for (byte b2 = 1; b2 < this.c.size; b2++) {
/* 245 */       Enemy enemy1 = (((Enemy.EnemyReference[])this.c.items)[b2]).enemy;
/* 246 */       Enemy enemy2 = (((Enemy.EnemyReference[])this.c.items)[b2 - 1]).enemy;
/*     */       
/* 248 */       enemy1.setSpeed(f1);
/*     */       
/* 250 */       if (enemy2.passedTiles - enemy1.passedTiles < 0.37F) {
/*     */         
/* 252 */         enemy2.passedTiles -= 0.37F;
/* 253 */         if (enemy1.passedTiles < 0.0F) enemy1.passedTiles = 0.0F;
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isDone() {
/* 260 */     return this.g;
/*     */   }
/*     */   
/*     */   private void c() {
/* 264 */     if (this.h != null) {
/* 265 */       this.j._gameUi.mainUi.removeBossHpBar(this.h);
/* 266 */       this.h = null;
/*     */     } 
/*     */     
/* 269 */     this.j.events.getListeners(EnemySpawn.class).remove(this);
/* 270 */     this.j.events.getListeners(EnemyDespawn.class).remove(this.k);
/* 271 */     this.j.events.getListeners(EnemyDie.class).remove(this.l);
/*     */     
/* 273 */     this.j = null;
/*     */     
/* 275 */     this.b = Enemy.EnemyReference.NULL;
/* 276 */     this.c.clear();
/* 277 */     this.a = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleEvent(EnemySpawn paramEnemySpawn) {
/*     */     Enemy enemy;
/* 283 */     if ((enemy = paramEnemySpawn.getEnemy()).wave == this.a) {
/* 284 */       Enemy.EnemyReference enemyReference = this.j.enemy.getReference(enemy);
/* 285 */       this.c.add(enemyReference);
/* 286 */       this.d++;
/* 287 */       if (enemy.type == EnemyType.SNAKE_BOSS_HEAD)
/*     */       {
/* 289 */         this.b = enemyReference; } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private SnakeBossWaveProcessor() {}
/*     */   
/*     */   @REGS
/*     */   public static class OnEnemyDespawn extends SerializableListener<SnakeBossWaveProcessor> implements Listener<EnemyDespawn> { private OnEnemyDespawn() {}
/*     */     
/*     */     private OnEnemyDespawn(SnakeBossWaveProcessor param1SnakeBossWaveProcessor) {
/* 299 */       this.a = param1SnakeBossWaveProcessor;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleEvent(EnemyDespawn param1EnemyDespawn) {
/*     */       Enemy enemy;
/* 305 */       if ((enemy = param1EnemyDespawn.getEnemy()).wave == SnakeBossWaveProcessor.a((SnakeBossWaveProcessor)this.a)) {
/* 306 */         SnakeBossWaveProcessor.b((SnakeBossWaveProcessor)this.a);
/* 307 */         if (enemy == (SnakeBossWaveProcessor.c((SnakeBossWaveProcessor)this.a)).enemy)
/*     */         {
/* 309 */           SnakeBossWaveProcessor.a((SnakeBossWaveProcessor)this.a, Enemy.EnemyReference.NULL);
/*     */         }
/*     */ 
/*     */         
/* 313 */         for (byte b = 0; b < (SnakeBossWaveProcessor.d((SnakeBossWaveProcessor)this.a)).size; b++) {
/* 314 */           if ((((Enemy.EnemyReference[])(SnakeBossWaveProcessor.d((SnakeBossWaveProcessor)this.a)).items)[b]).enemy == enemy) {
/* 315 */             SnakeBossWaveProcessor.d((SnakeBossWaveProcessor)this.a).removeIndex(b);
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } }
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie extends SerializableListener<SnakeBossWaveProcessor> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(SnakeBossWaveProcessor param1SnakeBossWaveProcessor) {
/* 328 */       this.a = param1SnakeBossWaveProcessor;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       DamageRecord damageRecord;
/*     */       Enemy enemy;
/* 335 */       if ((enemy = (damageRecord = param1EnemyDie.getLastDamage()).getEnemy()).wave == SnakeBossWaveProcessor.a((SnakeBossWaveProcessor)this.a) && 
/* 336 */         enemy.type == EnemyType.SNAKE_BOSS_HEAD) {
/*     */ 
/*     */         
/* 339 */         Tower tower = damageRecord.getTower();
/* 340 */         DamageType damageType = damageRecord.getDamageType();
/* 341 */         (SnakeBossWaveProcessor.e((SnakeBossWaveProcessor)this.a)).wave.stopSpawningCurrentWave(SnakeBossWaveProcessor.a((SnakeBossWaveProcessor)this.a), tower, damageType);
/* 342 */         for (int i = (SnakeBossWaveProcessor.d((SnakeBossWaveProcessor)this.a)).size - 1; i >= 0; i--) {
/*     */           Enemy enemy1;
/* 344 */           if ((enemy1 = (((Enemy.EnemyReference[])(SnakeBossWaveProcessor.d((SnakeBossWaveProcessor)this.a)).items)[i]).enemy) != null && enemy1 != enemy)
/*     */           {
/* 346 */             (SnakeBossWaveProcessor.e((SnakeBossWaveProcessor)this.a)).damage.queueEnemyKill(damageRecord.copyFor(enemy1, (SnakeBossWaveProcessor.e((SnakeBossWaveProcessor)this.a)).damage.obtainRecord()));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SnakeBossWaveProcessorFactory extends WaveProcessor.WaveProcessorFactory<SnakeBossWaveProcessor> {
/*     */     public SnakeBossWaveProcessorFactory() {
/* 355 */       super(BossType.SNAKE);
/*     */     }
/*     */ 
/*     */     
/*     */     public SnakeBossWaveProcessor create() {
/* 360 */       return new SnakeBossWaveProcessor((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\waves\processors\SnakeBossWaveProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */