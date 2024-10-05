/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyGroup;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Wave;
/*     */ import com.prineside.tdi2.buffs.NoDamageBuff;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.events.game.WaveComplete;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class SummonLootBoss extends GenericGameplayMod {
/*  39 */   private static final TLog a = TLog.forClass(SummonLootBoss.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   public int itemCount = 20;
/*  47 */   public float bossHp = 0.8F;
/*     */   public boolean damageToBase = false;
/*  49 */   public float coinMultiplier = 1.0F;
/*     */   @Null
/*     */   private GameSystemProvider b;
/*     */   @Null
/*     */   private Wave c;
/*  54 */   private OnEnemySpawn d = new OnEnemySpawn(this);
/*  55 */   private OnWaveComplete e = new OnWaveComplete(this, (byte)0);
/*     */   
/*     */   private boolean f;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  60 */     super.write(paramKryo, paramOutput);
/*  61 */     paramOutput.writeInt(this.itemCount);
/*  62 */     paramOutput.writeFloat(this.bossHp);
/*  63 */     paramOutput.writeBoolean(this.damageToBase);
/*  64 */     paramOutput.writeFloat(this.coinMultiplier);
/*  65 */     paramKryo.writeObjectOrNull(paramOutput, this.b, GameSystemProvider.class);
/*  66 */     paramKryo.writeObjectOrNull(paramOutput, this.c, Wave.class);
/*  67 */     paramKryo.writeObject(paramOutput, this.d);
/*  68 */     paramKryo.writeObject(paramOutput, this.e);
/*  69 */     paramOutput.writeBoolean(this.f);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  74 */     super.read(paramKryo, paramInput);
/*  75 */     this.itemCount = paramInput.readInt();
/*  76 */     this.bossHp = paramInput.readFloat();
/*  77 */     this.damageToBase = paramInput.readBoolean();
/*  78 */     this.coinMultiplier = paramInput.readFloat();
/*  79 */     this.b = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  80 */     this.c = (Wave)paramKryo.readObjectOrNull(paramInput, Wave.class);
/*  81 */     this.d = (OnEnemySpawn)paramKryo.readObject(paramInput, OnEnemySpawn.class);
/*  82 */     this.e = (OnWaveComplete)paramKryo.readObject(paramInput, OnWaveComplete.class);
/*  83 */     this.f = paramInput.readBoolean();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  88 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  93 */     return GameplayModCategory.LOOTING;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  98 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.SummonLootBoss");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/* 103 */     return Game.i.localeManager.i18n.format("gmod_descr_summon_loot_boss", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public final SummonLootBoss cpy() {
/* 108 */     SummonLootBoss summonLootBoss = new SummonLootBoss();
/* 109 */     a(summonLootBoss);
/* 110 */     summonLootBoss.itemCount = this.itemCount;
/* 111 */     summonLootBoss.bossHp = this.bossHp;
/* 112 */     summonLootBoss.damageToBase = this.damageToBase;
/* 113 */     summonLootBoss.coinMultiplier = this.coinMultiplier;
/* 114 */     return summonLootBoss;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/* 119 */     Array array = paramGameSystemProvider.map.getMap().getTilesByType(SpawnTile.class);
/* 120 */     for (byte b = 0; b < array.size; b++) {
/*     */       SpawnTile spawnTile;
/* 122 */       if ((spawnTile = (SpawnTile)array.get(b)).getAllowedEnemiesSet().contains(EnemyType.BOSS)) {
/* 123 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 134 */     Array array = paramGameSystemProvider.map.getMap().getTilesByType(SpawnTile.class);
/* 135 */     for (byte b = 0; b < array.size; b++) {
/*     */       SpawnTile spawnTile;
/* 137 */       if ((spawnTile = (SpawnTile)array.get(b)).getAllowedEnemiesSet().contains(EnemyType.BOSS)) {
/* 138 */         return null;
/*     */       }
/*     */     } 
/* 141 */     return () -> Game.i.localeManager.i18n.get("gpmod_precondition_nowhere_to_spawn_boss");
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 146 */     this.b = paramGameSystemProvider;
/*     */     
/* 148 */     RandomXS128 randomXS128 = paramGameSystemProvider.gameplayMod.getModRandom(7784);
/*     */     int i;
/* 150 */     if ((i = paramGameSystemProvider.wave.getNextOverridableWaveNumber()) != -1) {
/* 151 */       BossType bossType = BossType.values[randomXS128.nextInt(BossType.values.length)];
/* 152 */       Wave wave = paramGameSystemProvider.wave.generateBossWaveWithProcessor(bossType, i, paramGameSystemProvider.wave.getWaveDifficultyProvider().getDifficultWavesMultiplier(i));
/* 153 */       this.c = wave;
/*     */       
/* 155 */       for (byte b = 0; b < wave.enemyGroups.size; b++) {
/*     */         EnemyGroup enemyGroup;
/* 157 */         (enemyGroup = (EnemyGroup)wave.enemyGroups.get(b)).health *= this.bossHp;
/* 158 */         enemyGroup.bounty *= this.coinMultiplier;
/*     */       } 
/* 160 */       paramGameSystemProvider.wave.overrideWave(i, wave);
/*     */ 
/*     */       
/* 163 */       paramGameSystemProvider.events.getListeners(WaveComplete.class).addStateAffecting(this.e);
/* 164 */       paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this.d).setDescription("Fills enemies with loot and configures them");
/*     */     } else {
/* 166 */       a.e("skipped - no wave to override", new Object[0]);
/*     */     } 
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 170 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(SummonLootBoss.class, paramString)) == null)
/*     */     {
/* 172 */       return true;
/*     */     }
/*     */     
/* 175 */     activeMod.getMod().setRegisteredPower(this.power);
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void onWaveCompleted(Wave paramWave) {
/* 181 */     if (paramWave == this.c) {
/*     */       
/* 183 */       this.b.events.getListeners(EnemySpawn.class).remove(this.d);
/* 184 */       this.b.events.getListeners(WaveComplete.class).remove(this.e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void onEnemySpawn(EnemySpawn paramEnemySpawn) {
/*     */     Enemy enemy;
/* 191 */     if ((enemy = paramEnemySpawn.getEnemy()).wave == this.c) {
/* 192 */       if (!this.damageToBase) {
/*     */         NoDamageBuff noDamageBuff;
/* 194 */         (noDamageBuff = new NoDamageBuff()).setup(3600.0F, 3600.0F);
/* 195 */         this.b.buff.P_NO_DAMAGE.addBuff(enemy, noDamageBuff);
/*     */       } 
/*     */       
/* 198 */       if (!this.f && enemy.isBossMainBodyPart()) {
/*     */         
/* 200 */         a.i("filling with loot " + enemy, new Object[0]);
/* 201 */         for (byte b = 0; b < this.itemCount; b++) {
/* 202 */           this.b.loot.forceFillWithLoot(enemy);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final SummonLootBoss applyConfig(JsonValue paramJsonValue) {
/* 210 */     super.applyConfig(paramJsonValue);
/* 211 */     this.itemCount = paramJsonValue.getInt("itemCount", this.itemCount);
/* 212 */     this.bossHp = paramJsonValue.getFloat("bossHp", this.bossHp);
/* 213 */     this.damageToBase = paramJsonValue.getBoolean("damageToBase", this.damageToBase);
/* 214 */     this.coinMultiplier = paramJsonValue.getFloat("coinMultiplier", this.coinMultiplier);
/* 215 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnWaveComplete extends SerializableListener<SummonLootBoss> implements Listener<WaveComplete> {
/*     */     private OnWaveComplete() {}
/*     */     
/*     */     private OnWaveComplete(SummonLootBoss param1SummonLootBoss) {
/* 223 */       this.a = param1SummonLootBoss;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(WaveComplete param1WaveComplete) {
/* 228 */       ((SummonLootBoss)this.a).onWaveCompleted(param1WaveComplete.getWave());
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemySpawn
/*     */     implements KryoSerializable, Listener<EnemySpawn> {
/*     */     private SummonLootBoss a;
/*     */     
/*     */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 238 */       param1Kryo.writeObject(param1Output, this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 243 */       this.a = (SummonLootBoss)param1Kryo.readObject(param1Input, SummonLootBoss.class);
/*     */     }
/*     */     
/*     */     @Deprecated
/*     */     private OnEnemySpawn() {}
/*     */     
/*     */     public OnEnemySpawn(SummonLootBoss param1SummonLootBoss) {
/* 250 */       this.a = param1SummonLootBoss;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(EnemySpawn param1EnemySpawn) {
/* 255 */       this.a.onEnemySpawn(param1EnemySpawn);
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/* 263 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 266 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 271 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("SummonLootBoss");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 280 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new SummonLootBoss()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.7F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 281 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\SummonLootBoss.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */