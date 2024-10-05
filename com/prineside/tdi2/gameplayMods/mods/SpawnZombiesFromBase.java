/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.units.DisorientedUnit;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class SpawnZombiesFromBase
/*     */   extends GenericGameplayMod
/*     */   implements Listener<EnemySpawn> {
/*  36 */   public float baseCount = 2.0F;
/*  37 */   public float countPerPower = 0.5F;
/*  38 */   public float hp = 30.0F;
/*  39 */   public float hpPerPower = 10.0F;
/*     */   
/*     */   @Null
/*     */   private GameSystemProvider a;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  46 */     super.write(paramKryo, paramOutput);
/*  47 */     paramOutput.writeFloat(this.baseCount);
/*  48 */     paramOutput.writeFloat(this.countPerPower);
/*  49 */     paramOutput.writeFloat(this.hp);
/*  50 */     paramOutput.writeFloat(this.hpPerPower);
/*  51 */     paramKryo.writeObjectOrNull(paramOutput, this.a, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  56 */     super.read(paramKryo, paramInput);
/*  57 */     this.baseCount = paramInput.readFloat();
/*  58 */     this.countPerPower = paramInput.readFloat();
/*  59 */     this.hp = paramInput.readFloat();
/*  60 */     this.hpPerPower = paramInput.readFloat();
/*  61 */     this.a = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  66 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  71 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.SpawnZombiesFromBase");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  76 */     String str = StringFormatter.compactNumberWithPrecisionTrimZeros((getHpMultiplier() * 100.0F), 1, true).toString();
/*  77 */     return Game.i.localeManager.i18n.format("gmod_descr_spawn_zombies_from_base", new Object[] { Integer.valueOf(getCountPerWave()), str });
/*     */   }
/*     */ 
/*     */   
/*     */   public final SpawnZombiesFromBase cpy() {
/*  82 */     SpawnZombiesFromBase spawnZombiesFromBase = new SpawnZombiesFromBase();
/*  83 */     a(spawnZombiesFromBase);
/*  84 */     spawnZombiesFromBase.baseCount = this.baseCount;
/*  85 */     spawnZombiesFromBase.countPerPower = this.countPerPower;
/*  86 */     spawnZombiesFromBase.hp = this.hp;
/*  87 */     spawnZombiesFromBase.hpPerPower = this.hpPerPower;
/*  88 */     return spawnZombiesFromBase;
/*     */   }
/*     */   
/*     */   public final int getCountPerWave() {
/*  92 */     return MathUtils.round(this.baseCount + this.countPerPower * this.power);
/*     */   }
/*     */   
/*     */   public final float getHpMultiplier() {
/*  96 */     return (this.hp + this.hpPerPower * this.power) * 0.01F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 102 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(SpawnZombiesFromBase.class, paramString)) == null) {
/*     */       
/* 104 */       this.a = paramGameSystemProvider;
/* 105 */       paramGameSystemProvider.events.getListeners(EnemySpawn.class).addStateAffecting(this).setDescription("Spawns the disoriented enemies");
/* 106 */       return true;
/*     */     } 
/*     */     
/* 109 */     activeMod.getMod().setRegisteredPower(this.power);
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final SpawnZombiesFromBase applyConfig(JsonValue paramJsonValue) {
/* 116 */     super.applyConfig(paramJsonValue);
/* 117 */     this.baseCount = paramJsonValue.getFloat("baseCount", this.baseCount);
/* 118 */     this.countPerPower = paramJsonValue.getFloat("countPerPower", this.countPerPower);
/* 119 */     this.hp = paramJsonValue.getFloat("hp", this.hp);
/* 120 */     this.hpPerPower = paramJsonValue.getFloat("hpPerPower", this.hpPerPower);
/* 121 */     return this;
/*     */   }
/*     */   
/*     */   public final void handleEvent(EnemySpawn paramEnemySpawn) {
/*     */     Enemy enemy;
/*     */     int i;
/* 127 */     if (!(enemy = paramEnemySpawn.getEnemy()).notAffectsWaveKillCounter.isTrue() && enemy.wave != null && 
/* 128 */       !enemy.isBossRelated() && (
/*     */       
/* 130 */       i = enemy.wave.getSpawnedEnemyCount()) <= getCountPerWave()) {
/*     */       DisorientedUnit disorientedUnit;
/* 132 */       (disorientedUnit = Game.i.unitManager.F.DISORIENTED.create()).setup(null, enemy.type, enemy.maxHealth * getHpMultiplier(), enemy.maxHealth);
/* 133 */       if (this.a.unit.preparePathToRandomSpawn((Unit)disorientedUnit, (Tile)this.a.map.getMap().getTargetTileOrThrow())) {
/* 134 */         disorientedUnit.position.set((this.a.map.getMap().getTargetTileOrThrow()).center);
/* 135 */         this.a.unit.register((Unit)disorientedUnit);
/* 136 */         this.a.map.spawnUnit((Unit)disorientedUnit);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider
/*     */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/* 147 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 150 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 155 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("SpawnZombiesFromBase");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 165 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new SpawnZombiesFromBase()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.5F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 166 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\SpawnZombiesFromBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */