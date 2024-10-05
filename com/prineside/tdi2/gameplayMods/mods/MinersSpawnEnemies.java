/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyGroup;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Wave;
/*     */ import com.prineside.tdi2.WaveTemplates;
/*     */ import com.prineside.tdi2.buffs.NoBonusSystemPointsBuff;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.events.game.MinerResourceChange;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.pathfinding.Path;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS
/*     */ public final class MinersSpawnEnemies extends GenericGameplayMod implements Listener<MinerResourceChange> {
/*  41 */   private static final TLog a = TLog.forClass(MinersSpawnEnemies.class);
/*     */ 
/*     */   
/*     */   public boolean sharedWaveNumber = true;
/*     */ 
/*     */   
/*     */   public boolean onlyAllowedEnemies = true;
/*     */ 
/*     */   
/*  50 */   public float enemyCountLimit = 5.0F;
/*  51 */   public float enemyCountLimitPerPower = 1.0F;
/*  52 */   public int actualWaveDiffMin = -10;
/*  53 */   public int actualWaveDiffMax = 50;
/*  54 */   public float lootMultiplier = 0.5F;
/*  55 */   public float coinsMultiplier = 0.3F;
/*  56 */   public float healthMultiplier = 1.0F;
/*  57 */   public float xpMultiplier = 1.0F;
/*  58 */   public float scoreMultiplier = 0.5F;
/*  59 */   public int startingWave = 0;
/*  60 */   public float difficultyMultiplier = 0.75F;
/*  61 */   public float resourceInterval = 6.0F;
/*  62 */   public float resourceIntervalPerPower = -1.0F; @Null
/*  63 */   private GameSystemProvider b; private OnEnemySpawn c; public Array<Array<String>> waveTemplatesPerResource = new Array(true, 1, Array.class); public boolean enabled; public int intervalCounter;
/*     */   public MinersSpawnEnemies() {
/*  65 */     for (byte b1 = 0; b1 < ResourceType.values.length; b1++) {
/*  66 */       this.waveTemplatesPerResource.add(new Array(true, 1, String.class));
/*     */     }
/*  68 */     ((Array)this.waveTemplatesPerResource.get(ResourceType.SCALAR.ordinal())).addAll((Object[])new String[] { "REGULAR_MEDIUM", "REGULAR_LOW", "TOXIC_MEDIUM", "TOXIC_ARMORED" });
/*     */ 
/*     */     
/*  71 */     ((Array)this.waveTemplatesPerResource.get(ResourceType.VECTOR.ordinal())).addAll((Object[])new String[] { "STRONG_MEDIUM", "STRONG_LOW", "FAST_MEDIUM", "FAST_LOW", "HEALER_STRONG" });
/*     */ 
/*     */     
/*  74 */     ((Array)this.waveTemplatesPerResource.get(ResourceType.MATRIX.ordinal())).addAll((Object[])new String[] { "HELI_MEDIUM", "JET_MEDIUM", "HEALER_JET", "ICY_HIGH", "ICY_TOXIC", "HEALER_ICY" });
/*     */ 
/*     */     
/*  77 */     ((Array)this.waveTemplatesPerResource.get(ResourceType.TENSOR.ordinal())).addAll((Object[])new String[] { "ARMORED_LOW", "ARMORED_REGULAR", "ARMORED_STRONG", "HEALER_REGULAR", "HEALER_SLOW", "FIGHTER_ARMORED" });
/*     */ 
/*     */     
/*  80 */     ((Array)this.waveTemplatesPerResource.get(ResourceType.INFIAR.ordinal())).addAll((Object[])new String[] { "FIGHTER_LOW", "FIGHTER_MEDIUM", "LIGHT_MEDIUM", "LIGHT_HIGH", "LIGHT_FAST" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     this.c = new OnEnemySpawn(this);
/*  88 */     this.enabled = true;
/*     */     
/*  90 */     this.enemyQueueWaves = new int[ResourceType.values.length];
/*  91 */     this.enemyQueue = new Array(true, ResourceType.values.length, Array.class); int i; ResourceType[] arrayOfResourceType;
/*     */     byte b2;
/*  93 */     for (i = (arrayOfResourceType = ResourceType.values).length, b2 = 0; b2 < i; b2++)
/*  94 */       this.enemyQueue.add(new Array(true, 1, Enemy.class)); 
/*     */   }
/*     */   public int[] enemyQueueWaves;
/*     */   public Array<Array<Enemy>> enemyQueue;
/*     */   public int enemiesSpawned;
/*     */   public int realEnemiesCounter;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 102 */     super.write(paramKryo, paramOutput);
/* 103 */     paramOutput.writeBoolean(this.sharedWaveNumber);
/* 104 */     paramOutput.writeBoolean(this.onlyAllowedEnemies);
/* 105 */     paramOutput.writeFloat(this.enemyCountLimit);
/* 106 */     paramOutput.writeFloat(this.enemyCountLimitPerPower);
/* 107 */     paramOutput.writeInt(this.actualWaveDiffMin);
/* 108 */     paramOutput.writeInt(this.actualWaveDiffMax);
/* 109 */     paramOutput.writeFloat(this.lootMultiplier);
/* 110 */     paramOutput.writeFloat(this.coinsMultiplier);
/* 111 */     paramOutput.writeFloat(this.healthMultiplier);
/* 112 */     paramOutput.writeFloat(this.xpMultiplier);
/* 113 */     paramOutput.writeFloat(this.scoreMultiplier);
/* 114 */     paramOutput.writeInt(this.startingWave);
/* 115 */     paramOutput.writeFloat(this.difficultyMultiplier);
/* 116 */     paramOutput.writeFloat(this.resourceInterval);
/* 117 */     paramOutput.writeFloat(this.resourceIntervalPerPower);
/* 118 */     paramKryo.writeObject(paramOutput, this.waveTemplatesPerResource);
/*     */     
/* 120 */     paramKryo.writeObjectOrNull(paramOutput, this.b, GameSystemProvider.class);
/* 121 */     paramOutput.writeBoolean(this.enabled);
/* 122 */     paramOutput.writeInt(this.intervalCounter);
/* 123 */     paramKryo.writeObject(paramOutput, this.enemyQueueWaves);
/* 124 */     paramKryo.writeObject(paramOutput, this.enemyQueue);
/* 125 */     paramOutput.writeInt(this.enemiesSpawned);
/* 126 */     paramOutput.writeInt(this.realEnemiesCounter);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 131 */     super.read(paramKryo, paramInput);
/* 132 */     this.sharedWaveNumber = paramInput.readBoolean();
/* 133 */     this.onlyAllowedEnemies = paramInput.readBoolean();
/* 134 */     this.enemyCountLimit = paramInput.readFloat();
/* 135 */     this.enemyCountLimitPerPower = paramInput.readFloat();
/* 136 */     this.actualWaveDiffMin = paramInput.readInt();
/* 137 */     this.actualWaveDiffMax = paramInput.readInt();
/* 138 */     this.lootMultiplier = paramInput.readFloat();
/* 139 */     this.coinsMultiplier = paramInput.readFloat();
/* 140 */     this.healthMultiplier = paramInput.readFloat();
/* 141 */     this.xpMultiplier = paramInput.readFloat();
/* 142 */     this.scoreMultiplier = paramInput.readFloat();
/* 143 */     this.startingWave = paramInput.readInt();
/* 144 */     this.difficultyMultiplier = paramInput.readFloat();
/* 145 */     this.resourceInterval = paramInput.readFloat();
/* 146 */     this.resourceIntervalPerPower = paramInput.readFloat();
/* 147 */     this.waveTemplatesPerResource = (Array<Array<String>>)paramKryo.readObject(paramInput, Array.class);
/*     */     
/* 149 */     this.b = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/* 150 */     this.enabled = paramInput.readBoolean();
/* 151 */     this.intervalCounter = paramInput.readInt();
/* 152 */     this.enemyQueueWaves = (int[])paramKryo.readObject(paramInput, int[].class);
/* 153 */     this.enemyQueue = (Array<Array<Enemy>>)paramKryo.readObject(paramInput, Array.class);
/* 154 */     this.enemiesSpawned = paramInput.readInt();
/* 155 */     this.realEnemiesCounter = paramInput.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/* 160 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.MinersSpawnEnemies");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/* 165 */     return Game.i.localeManager.i18n.format("gmod_descr_miners_spawn_enemies", new Object[] { Integer.valueOf(a()) });
/*     */   }
/*     */   
/*     */   private int a() {
/* 169 */     return MathUtils.clamp(MathUtils.round(this.resourceInterval + this.resourceIntervalPerPower * this.power), 1, 2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   private int a(int paramInt) {
/* 174 */     return MathUtils.round((paramInt = this.b.wave.getWaveDifficultyProvider().getDifficultWavesMultiplier(paramInt)) * this.difficultyMultiplier);
/*     */   }
/*     */ 
/*     */   
/*     */   public final MinersSpawnEnemies cpy() {
/* 179 */     MinersSpawnEnemies minersSpawnEnemies = new MinersSpawnEnemies();
/* 180 */     a(minersSpawnEnemies);
/* 181 */     minersSpawnEnemies.sharedWaveNumber = this.sharedWaveNumber;
/* 182 */     minersSpawnEnemies.onlyAllowedEnemies = this.onlyAllowedEnemies;
/* 183 */     minersSpawnEnemies.enemyCountLimit = this.enemyCountLimit;
/* 184 */     minersSpawnEnemies.enemyCountLimitPerPower = this.enemyCountLimitPerPower;
/* 185 */     minersSpawnEnemies.actualWaveDiffMin = this.actualWaveDiffMin;
/* 186 */     minersSpawnEnemies.actualWaveDiffMax = this.actualWaveDiffMax;
/* 187 */     minersSpawnEnemies.lootMultiplier = this.lootMultiplier;
/* 188 */     minersSpawnEnemies.coinsMultiplier = this.coinsMultiplier;
/* 189 */     minersSpawnEnemies.healthMultiplier = this.healthMultiplier;
/* 190 */     minersSpawnEnemies.xpMultiplier = this.xpMultiplier;
/* 191 */     minersSpawnEnemies.scoreMultiplier = this.scoreMultiplier;
/* 192 */     minersSpawnEnemies.startingWave = this.startingWave;
/* 193 */     minersSpawnEnemies.difficultyMultiplier = this.difficultyMultiplier;
/* 194 */     minersSpawnEnemies.resourceInterval = this.resourceInterval;
/* 195 */     minersSpawnEnemies.resourceIntervalPerPower = this.resourceIntervalPerPower;
/* 196 */     for (byte b = 0; b < ResourceType.values.length; b++) {
/* 197 */       ((Array)minersSpawnEnemies.waveTemplatesPerResource.get(b)).clear();
/* 198 */       ((Array)minersSpawnEnemies.waveTemplatesPerResource.get(b)).addAll((Array)this.waveTemplatesPerResource.get(b));
/*     */     } 
/* 200 */     return minersSpawnEnemies;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/* 205 */     return ((paramGameSystemProvider.map.getMap().getTilesByType(SourceTile.class)).size == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 210 */     if ((paramGameSystemProvider.map.getMap().getTilesByType(SourceTile.class)).size == 0) {
/* 211 */       return () -> Game.i.localeManager.i18n.get("gpmod_precondition_no_source_tiles_on_map");
/*     */     }
/* 213 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 219 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(MinersSpawnEnemies.class, paramString)) == null) {
/*     */       
/* 221 */       this.b = paramGameSystemProvider;
/*     */ 
/*     */ 
/*     */       
/* 225 */       Arrays.fill(this.enemyQueueWaves, (this.startingWave > 0) ? this.startingWave : ((paramGameSystemProvider.wave.wave == null) ? 1 : paramGameSystemProvider.wave.wave.waveNumber));
/*     */       
/* 227 */       paramGameSystemProvider.events.getListeners(MinerResourceChange.class).addStateAffecting(this);
/* 228 */       paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this.c);
/* 229 */       return true;
/*     */     } 
/*     */     
/* 232 */     activeMod.getMod().setRegisteredPower(this.power);
/* 233 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 239 */     return GameplayModCategory.OTHER;
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getAdditionalCategory() {
/* 244 */     return GameplayModCategory.LOOTING;
/*     */   }
/*     */ 
/*     */   
/*     */   public final MinersSpawnEnemies applyConfig(JsonValue paramJsonValue) {
/* 249 */     super.applyConfig(paramJsonValue);
/*     */     
/* 251 */     this.sharedWaveNumber = paramJsonValue.getBoolean("sharedWaveNumber", this.sharedWaveNumber);
/* 252 */     this.onlyAllowedEnemies = paramJsonValue.getBoolean("onlyAllowedEnemies", this.onlyAllowedEnemies);
/* 253 */     this.enemyCountLimit = paramJsonValue.getFloat("enemyCountLimit", this.enemyCountLimit);
/* 254 */     this.enemyCountLimitPerPower = paramJsonValue.getFloat("enemyCountLimitPerPower", this.enemyCountLimitPerPower);
/* 255 */     this.actualWaveDiffMax = paramJsonValue.getInt("actualWaveDiffMax", this.actualWaveDiffMax);
/* 256 */     this.actualWaveDiffMin = paramJsonValue.getInt("actualWaveDiffMin", this.actualWaveDiffMin);
/* 257 */     this.lootMultiplier = paramJsonValue.getFloat("lootMultiplier", this.lootMultiplier);
/* 258 */     this.coinsMultiplier = paramJsonValue.getFloat("coinsMultiplier", this.coinsMultiplier);
/* 259 */     this.healthMultiplier = paramJsonValue.getFloat("healthMultiplier", this.healthMultiplier);
/* 260 */     this.xpMultiplier = paramJsonValue.getFloat("xpMultiplier", this.xpMultiplier);
/* 261 */     this.scoreMultiplier = paramJsonValue.getFloat("scoreMultiplier", this.scoreMultiplier);
/* 262 */     this.startingWave = paramJsonValue.getInt("startingWave", this.startingWave);
/* 263 */     this.difficultyMultiplier = paramJsonValue.getFloat("difficultyMultiplier", this.difficultyMultiplier);
/* 264 */     this.resourceInterval = paramJsonValue.getFloat("resourceInterval", this.resourceInterval);
/* 265 */     this.resourceIntervalPerPower = paramJsonValue.getFloat("resourceIntervalPerPower", this.resourceIntervalPerPower);
/*     */     
/* 267 */     if ((paramJsonValue = paramJsonValue.getChild("waveTemplatesPerResource")) != null) {
/* 268 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = paramJsonValue.iterator(); jsonIterator.hasNext(); ) {
/* 269 */         JsonValue jsonValue; ResourceType resourceType = ResourceType.valueOf((jsonValue = jsonIterator.next()).name);
/*     */         Array array;
/* 271 */         (array = (Array)this.waveTemplatesPerResource.get(resourceType.ordinal())).clear();
/* 272 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue.iterator(); jsonIterator1.hasNext(); ) { JsonValue jsonValue1 = jsonIterator1.next();
/* 273 */           array.add(jsonValue1.asString()); }
/*     */       
/*     */       } 
/*     */     }
/*     */     
/* 278 */     return this;
/*     */   }
/*     */   
/*     */   private Enemy a(ResourceType paramResourceType) {
/*     */     Array array;
/* 283 */     if ((array = (Array)this.enemyQueue.get(paramResourceType.ordinal())).size == 0) {
/*     */       Array array1;
/* 285 */       if ((array1 = (Array)this.waveTemplatesPerResource.get(paramResourceType.ordinal())).size == 0) return null; 
/* 286 */       String str = (String)array1.get(this.b.gameState.randomInt(array1.size));
/*     */       
/* 288 */       int i = this.sharedWaveNumber ? this.enemyQueueWaves[0] : this.enemyQueueWaves[paramResourceType.ordinal()];
/* 289 */       if (this.b.wave.wave != null) {
/* 290 */         i = MathUtils.clamp(i, this.b.wave.wave.waveNumber + this.actualWaveDiffMin, this.b.wave.wave.waveNumber + this.actualWaveDiffMax);
/*     */       }
/* 292 */       if (i <= 0) i = 1; 
/*     */       WaveTemplates.WaveTemplate waveTemplate;
/* 294 */       if ((waveTemplate = WaveTemplates.getByName(str)) == null) return null;
/*     */       
/* 296 */       Wave wave = this.b.wave.generateWave(waveTemplate, i, a(i)); int j;
/* 297 */       for (j = 0; j < wave.enemyGroups.size; j++) {
/* 298 */         EnemyGroup enemyGroup = (EnemyGroup)wave.enemyGroups.get(j);
/* 299 */         for (byte b1 = 0; b1 < enemyGroup.count; b1++) {
/*     */           Enemy enemy;
/* 301 */           (enemy = Game.i.enemyManager.getFactory(enemyGroup.getEnemyType()).obtain()).setSpeed(enemyGroup.speed);
/* 302 */           enemy.maxHealth = enemyGroup.health;
/* 303 */           enemy.setHealth(enemyGroup.health);
/* 304 */           enemy.killScore = enemyGroup.killScore;
/* 305 */           enemy.bounty = enemyGroup.bounty;
/* 306 */           enemy.setKillExp(enemyGroup.killExp);
/* 307 */           array.add(enemy);
/*     */         } 
/*     */       } 
/* 310 */       a.i("generate wave, number: " + i + ", difficulty: " + a(i), new Object[0]);
/*     */ 
/*     */       
/* 313 */       j = 37;
/* 314 */       for (byte b = 0; b < array.size; b++) {
/* 315 */         int k = this.b.gameState.randomIntIndependent(array.size, j);
/* 316 */         j = (j * 31 + k) % 65536;
/* 317 */         array.swap(k, b);
/*     */       } 
/* 319 */       if (this.sharedWaveNumber) {
/* 320 */         this.enemyQueueWaves[0] = i + 1;
/*     */       } else {
/* 322 */         this.enemyQueueWaves[paramResourceType.ordinal()] = i + 1;
/*     */       } 
/*     */     } 
/* 325 */     if (array.size == 0) {
/* 326 */       return null;
/*     */     }
/* 328 */     return (Enemy)array.pop();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void handleEvent(MinerResourceChange paramMinerResourceChange) {
/* 334 */     if (paramMinerResourceChange.isMined() && this.enabled) {
/* 335 */       this.intervalCounter++;
/* 336 */       if (this.intervalCounter >= a()) {
/* 337 */         this.intervalCounter = 0;
/*     */         
/* 339 */         int i = (int)((this.enemyCountLimit + this.enemyCountLimitPerPower * this.power) * this.realEnemiesCounter);
/*     */         
/* 341 */         for (byte b = 0; b < paramMinerResourceChange.getDelta() && 
/* 342 */           this.enemiesSpawned < i; b++) {
/*     */           Enemy enemy;
/*     */ 
/*     */ 
/*     */           
/* 347 */           if ((enemy = a(paramMinerResourceChange.getResourceType())) != null) {
/*     */             Path path;
/* 349 */             if ((path = this.b.pathfinding.findPathToTargetTile((Tile)paramMinerResourceChange.getMiner().getTile(), enemy.type)) != null) {
/* 350 */               enemy.notAffectsWaveKillCounter.addReason("MinersSpawnEnemiesCustomSpawn");
/* 351 */               enemy.ignoredByAutoWaveCall = true;
/* 352 */               this.b.enemy.addEnemyWithFirstSpawn(enemy, (Tile)paramMinerResourceChange.getMiner().getTile(), this.b.gameState.randomInt(11));
/*     */               NoBonusSystemPointsBuff noBonusSystemPointsBuff;
/* 354 */               (noBonusSystemPointsBuff = new NoBonusSystemPointsBuff()).setup(9000.0F, 9000.0F);
/* 355 */               this.b.buff.P_NO_BONUS_SYSTEM_POINTS.addBuff(enemy, noBonusSystemPointsBuff);
/* 356 */               enemy.bounty *= this.coinsMultiplier;
/* 357 */               if (this.healthMultiplier != 1.0F) {
/* 358 */                 enemy.maxHealth *= this.healthMultiplier;
/* 359 */                 enemy.setHealth(enemy.getHealth() * this.healthMultiplier);
/*     */               } 
/* 361 */               enemy.killScore = MathUtils.round(enemy.killScore * this.scoreMultiplier);
/* 362 */               enemy.setKillExp(enemy.getKillExp() * this.xpMultiplier);
/* 363 */               if (this.lootMultiplier < 1.0F && enemy.loot != null && enemy.loot.size != 0 && 
/* 364 */                 this.b.gameState.randomFloat() > this.lootMultiplier)
/*     */               {
/* 366 */                 enemy.loot = null;
/*     */               }
/*     */               
/* 369 */               this.enemiesSpawned++;
/*     */             } else {
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemySpawn
/*     */     implements KryoSerializable, Listener<EnemySpawn>
/*     */   {
/*     */     private MinersSpawnEnemies a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 386 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 391 */       this.a = (MinersSpawnEnemies)param1Kryo.readObject(param1Input, MinersSpawnEnemies.class);
/*     */     }
/*     */     
/*     */     private OnEnemySpawn() {}
/*     */     
/*     */     public OnEnemySpawn(MinersSpawnEnemies param1MinersSpawnEnemies) {
/* 397 */       this.a = param1MinersSpawnEnemies;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemySpawn param1EnemySpawn) {
/* 402 */       if (!(param1EnemySpawn.getEnemy()).notAffectsWaveKillCounter.isTrue())
/* 403 */         this.a.realEnemiesCounter++; 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/* 412 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 415 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 420 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("MinersSpawnEnemies");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 430 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new MinersSpawnEnemies()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 431 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\MinersSpawnEnemies.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */