/*     */ package com.prineside.tdi2.gameplayMods;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.gameplayMods.mods.AddAllAbilityCharges;
/*     */ import com.prineside.tdi2.gameplayMods.mods.AddRandomCoreTile;
/*     */ import com.prineside.tdi2.gameplayMods.mods.AddRandomPlatform;
/*     */ import com.prineside.tdi2.gameplayMods.mods.AllAbilitiesForRandomTower;
/*     */ import com.prineside.tdi2.gameplayMods.mods.BaseExplodesOnEnemyPass;
/*     */ import com.prineside.tdi2.gameplayMods.mods.BoostExistingEnemiesWithLoot;
/*     */ import com.prineside.tdi2.gameplayMods.mods.BuildRandomMiner;
/*     */ import com.prineside.tdi2.gameplayMods.mods.CriticalDamage;
/*     */ import com.prineside.tdi2.gameplayMods.mods.DebuffsLastLonger;
/*     */ import com.prineside.tdi2.gameplayMods.mods.DepositCoinsGeneration;
/*     */ import com.prineside.tdi2.gameplayMods.mods.DoubleMiningSpeed;
/*     */ import com.prineside.tdi2.gameplayMods.mods.EnemiesDropResources;
/*     */ import com.prineside.tdi2.gameplayMods.mods.ExtraDamagePerBuff;
/*     */ import com.prineside.tdi2.gameplayMods.mods.FirstEnemiesInWaveExplode;
/*     */ import com.prineside.tdi2.gameplayMods.mods.GV_AbilitiesEnergy;
/*     */ import com.prineside.tdi2.gameplayMods.mods.GV_AbilitiesMaxEnergy;
/*     */ import com.prineside.tdi2.gameplayMods.mods.GV_BountiesNearby;
/*     */ import com.prineside.tdi2.gameplayMods.mods.GV_DisableBountyModifierHarm;
/*     */ import com.prineside.tdi2.gameplayMods.mods.GV_MinersMaxUpgradeLevel;
/*     */ import com.prineside.tdi2.gameplayMods.mods.GV_TowersMaxExpLevel;
/*     */ import com.prineside.tdi2.gameplayMods.mods.IncreaseSelectedBonusesPower;
/*     */ import com.prineside.tdi2.gameplayMods.mods.IncreasedTowerToEnemyEfficiency;
/*     */ import com.prineside.tdi2.gameplayMods.mods.LastEnemiesInWaveDealNoDamage;
/*     */ import com.prineside.tdi2.gameplayMods.mods.LightningStrikeOnTowerLevelUp;
/*     */ import com.prineside.tdi2.gameplayMods.mods.LowHpEnemiesDealNoDamage;
/*     */ import com.prineside.tdi2.gameplayMods.mods.MineLegendaryItems;
/*     */ import com.prineside.tdi2.gameplayMods.mods.MinedItemsTurnIntoDust;
/*     */ import com.prineside.tdi2.gameplayMods.mods.MinersSpawnEnemies;
/*     */ import com.prineside.tdi2.gameplayMods.mods.MoreBonusVariantsNextTime;
/*     */ import com.prineside.tdi2.gameplayMods.mods.MultiplyLootedItems;
/*     */ import com.prineside.tdi2.gameplayMods.mods.MultiplyMdps;
/*     */ import com.prineside.tdi2.gameplayMods.mods.NukeOnBonusStage;
/*     */ import com.prineside.tdi2.gameplayMods.mods.ReceiveCoins;
/*     */ import com.prineside.tdi2.gameplayMods.mods.SellAllTowers;
/*     */ import com.prineside.tdi2.gameplayMods.mods.SpawnZombiesFromBase;
/*     */ import com.prineside.tdi2.gameplayMods.mods.SummonLootBoss;
/*     */ import com.prineside.tdi2.gameplayMods.mods.TowersAttackSpeed;
/*     */ import com.prineside.tdi2.gameplayMods.mods.TowersDamage;
/*     */ import com.prineside.tdi2.gameplayMods.mods.TriggerRandomAbility;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.JsonHandler;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.ReflectionUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.IOException;
/*     */ 
/*     */ @REGS
/*     */ public class BonusStagesConfig
/*     */   implements KryoSerializable
/*     */ {
/*  68 */   private static final TLog a = TLog.forClass(BonusStagesConfig.class);
/*     */   
/*     */   public static final int SEED_RANDOM = 0;
/*     */   
/*     */   public static final int SEED_TAKE_FROM_LEVEL = -1;
/*     */   
/*     */   public static final int SEED_TAKE_FROM_DAILY_QUEST = -2;
/*     */   public static final String DEFAULT_CONFIG_FILE_PATH = "res/default-bonus-stages-config.json";
/*     */   public static final String GENERIC_PROVIDER_CLASS_PATH = "com.prineside.tdi2.gameplayMods.mods.";
/*  77 */   public static final ProbableBonusesProvider[] DEFAULT_BONUS_PROVIDERS = new ProbableBonusesProvider[] { 
/*  78 */       (ProbableBonusesProvider)DepositCoinsGeneration.BonusProvider.getInstance(), 
/*  79 */       (ProbableBonusesProvider)EnemiesDropResources.BonusProvider.getInstance(), 
/*  80 */       (ProbableBonusesProvider)ExtraDamagePerBuff.BonusProvider.getInstance(), 
/*  81 */       (ProbableBonusesProvider)GV_AbilitiesEnergy.BonusProvider.getInstance(), 
/*  82 */       (ProbableBonusesProvider)GV_BountiesNearby.BonusProvider.getInstance(), 
/*  83 */       (ProbableBonusesProvider)GV_DisableBountyModifierHarm.BonusProvider.getInstance(), 
/*  84 */       (ProbableBonusesProvider)GV_TowersMaxExpLevel.BonusProvider.getInstance(), 
/*  85 */       (ProbableBonusesProvider)GV_AbilitiesMaxEnergy.BonusProvider.getInstance(), 
/*  86 */       (ProbableBonusesProvider)GV_MinersMaxUpgradeLevel.BonusProvider.getInstance(), 
/*  87 */       (ProbableBonusesProvider)IncreasedTowerToEnemyEfficiency.BonusProvider.getInstance(), 
/*  88 */       (ProbableBonusesProvider)IncreaseSelectedBonusesPower.BonusProvider.getInstance(), 
/*  89 */       (ProbableBonusesProvider)LastEnemiesInWaveDealNoDamage.BonusProvider.getInstance(), 
/*  90 */       (ProbableBonusesProvider)LowHpEnemiesDealNoDamage.BonusProvider.getInstance(), 
/*  91 */       (ProbableBonusesProvider)MineLegendaryItems.BonusProvider.getInstance(), 
/*  92 */       (ProbableBonusesProvider)DoubleMiningSpeed.BonusProvider.getInstance(), 
/*  93 */       (ProbableBonusesProvider)AllAbilitiesForRandomTower.BonusProvider.getInstance(), 
/*  94 */       (ProbableBonusesProvider)DebuffsLastLonger.BonusProvider.getInstance(), 
/*  95 */       (ProbableBonusesProvider)ReceiveCoins.BonusProvider.getInstance(), 
/*  96 */       (ProbableBonusesProvider)BoostExistingEnemiesWithLoot.BonusProvider.getInstance(), 
/*  97 */       (ProbableBonusesProvider)FirstEnemiesInWaveExplode.BonusProvider.getInstance(), 
/*  98 */       (ProbableBonusesProvider)BaseExplodesOnEnemyPass.BonusProvider.getInstance(), 
/*  99 */       (ProbableBonusesProvider)MinersSpawnEnemies.BonusProvider.getInstance(), 
/* 100 */       (ProbableBonusesProvider)MinedItemsTurnIntoDust.BonusProvider.getInstance(), 
/* 101 */       (ProbableBonusesProvider)TriggerRandomAbility.BonusProvider.getInstance(), 
/* 102 */       (ProbableBonusesProvider)BuildRandomMiner.BonusProvider.getInstance(), 
/* 103 */       (ProbableBonusesProvider)MultiplyMdps.BonusProvider.getInstance(), 
/* 104 */       (ProbableBonusesProvider)AddRandomCoreTile.BonusProvider.getInstance(), 
/* 105 */       (ProbableBonusesProvider)AddAllAbilityCharges.BonusProvider.getInstance(), 
/* 106 */       (ProbableBonusesProvider)SummonLootBoss.BonusProvider.getInstance(), 
/* 107 */       (ProbableBonusesProvider)SpawnZombiesFromBase.BonusProvider.getInstance(), 
/* 108 */       (ProbableBonusesProvider)AddRandomPlatform.BonusProvider.getInstance(), 
/* 109 */       (ProbableBonusesProvider)MoreBonusVariantsNextTime.BonusProvider.getInstance(), 
/* 110 */       (ProbableBonusesProvider)CriticalDamage.BonusProvider.getInstance(), 
/* 111 */       (ProbableBonusesProvider)SellAllTowers.BonusProvider.getInstance(), 
/* 112 */       (ProbableBonusesProvider)NukeOnBonusStage.BonusProvider.getInstance(), 
/* 113 */       (ProbableBonusesProvider)TowersDamage.BonusProvider.getInstance(), 
/* 114 */       (ProbableBonusesProvider)TowersAttackSpeed.BonusProvider.getInstance(), 
/* 115 */       (ProbableBonusesProvider)MultiplyLootedItems.BonusProvider.getInstance(), 
/* 116 */       (ProbableBonusesProvider)LightningStrikeOnTowerLevelUp.BonusProvider.getInstance() };
/*     */   
/*     */   public boolean reRollEnabled;
/*     */   
/*     */   public boolean forceImmediateSelection;
/*     */   
/*     */   public boolean replaceBonusesWithNotSatisfiedPreconditions;
/*     */   public int maxReRollsPerStage;
/*     */   public int maxReRollsAllTime;
/* 125 */   public float reRollPrice = 0.15F;
/* 126 */   public float reRollMinPrice = 0.05F;
/* 127 */   public float reRollMaxPrice = 0.15F;
/* 128 */   public float reRollPricePerStage = -0.005F;
/* 129 */   public float immediateBonusesChance = 1.0F;
/* 130 */   public float persistentBonusesChance = 1.0F;
/* 131 */   public int activeBonusesSlotLimit = 0;
/*     */   public boolean chainReRoll;
/*     */   public boolean ignoreImpossiblePreconditions;
/*     */   public boolean selectedBonusAffectsRandom;
/* 135 */   public IntArray stageRequirements = new IntArray(true, new int[] { 200, 300, 400 }, 0, 3);
/* 136 */   public int endlessStageRequirement = 0;
/* 137 */   public int endlessStageRequirementPerStage = 0;
/*     */   
/*     */   public int seed;
/*     */   
/*     */   public boolean isFillWithDefaultBonusProviders;
/* 142 */   public Array<String> bonusProviderListClassNames = new Array();
/*     */   
/* 144 */   public Array<ProbableBonusesProvider> probableBonusesProviders = new Array();
/* 145 */   public JsonValue bonusesConfig = new JsonValue(JsonValue.ValueType.object);
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/* 149 */     paramOutput.writeBoolean(this.reRollEnabled);
/* 150 */     paramOutput.writeBoolean(this.forceImmediateSelection);
/* 151 */     paramOutput.writeBoolean(this.replaceBonusesWithNotSatisfiedPreconditions);
/* 152 */     paramOutput.writeVarInt(this.maxReRollsPerStage, true);
/* 153 */     paramOutput.writeVarInt(this.maxReRollsAllTime, true);
/* 154 */     paramOutput.writeFloat(this.reRollPrice);
/* 155 */     paramOutput.writeFloat(this.reRollMinPrice);
/* 156 */     paramOutput.writeFloat(this.reRollMaxPrice);
/* 157 */     paramOutput.writeFloat(this.reRollPricePerStage);
/* 158 */     paramOutput.writeFloat(this.immediateBonusesChance);
/* 159 */     paramOutput.writeFloat(this.persistentBonusesChance);
/* 160 */     paramOutput.writeInt(this.activeBonusesSlotLimit);
/* 161 */     paramOutput.writeBoolean(this.chainReRoll);
/* 162 */     paramOutput.writeBoolean(this.ignoreImpossiblePreconditions);
/* 163 */     paramOutput.writeBoolean(this.selectedBonusAffectsRandom);
/* 164 */     paramKryo.writeObject(paramOutput, this.stageRequirements);
/* 165 */     paramOutput.writeInt(this.seed);
/* 166 */     paramOutput.writeInt(this.endlessStageRequirement);
/* 167 */     paramOutput.writeInt(this.endlessStageRequirementPerStage);
/* 168 */     paramOutput.writeBoolean(this.isFillWithDefaultBonusProviders);
/* 169 */     paramKryo.writeObject(paramOutput, this.bonusProviderListClassNames);
/* 170 */     paramKryo.writeObject(paramOutput, this.probableBonusesProviders);
/* 171 */     paramKryo.writeObject(paramOutput, this.bonusesConfig);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/* 176 */     this.reRollEnabled = paramInput.readBoolean();
/* 177 */     this.forceImmediateSelection = paramInput.readBoolean();
/* 178 */     this.replaceBonusesWithNotSatisfiedPreconditions = paramInput.readBoolean();
/* 179 */     this.maxReRollsPerStage = paramInput.readVarInt(true);
/* 180 */     this.maxReRollsAllTime = paramInput.readVarInt(true);
/* 181 */     this.reRollPrice = paramInput.readFloat();
/* 182 */     this.reRollMinPrice = paramInput.readFloat();
/* 183 */     this.reRollMaxPrice = paramInput.readFloat();
/* 184 */     this.reRollPricePerStage = paramInput.readFloat();
/* 185 */     this.immediateBonusesChance = paramInput.readFloat();
/* 186 */     this.persistentBonusesChance = paramInput.readFloat();
/* 187 */     this.activeBonusesSlotLimit = paramInput.readInt();
/* 188 */     this.chainReRoll = paramInput.readBoolean();
/* 189 */     this.ignoreImpossiblePreconditions = paramInput.readBoolean();
/* 190 */     this.selectedBonusAffectsRandom = paramInput.readBoolean();
/* 191 */     this.stageRequirements = (IntArray)paramKryo.readObject(paramInput, IntArray.class);
/* 192 */     this.seed = paramInput.readInt();
/* 193 */     this.endlessStageRequirement = paramInput.readInt();
/* 194 */     this.endlessStageRequirementPerStage = paramInput.readInt();
/* 195 */     this.isFillWithDefaultBonusProviders = paramInput.readBoolean();
/* 196 */     this.bonusProviderListClassNames = (Array<String>)paramKryo.readObject(paramInput, Array.class);
/* 197 */     this.probableBonusesProviders = (Array<ProbableBonusesProvider>)paramKryo.readObject(paramInput, Array.class);
/* 198 */     this.bonusesConfig = (JsonValue)paramKryo.readObject(paramInput, JsonValue.class);
/*     */   }
/*     */   
/*     */   public BonusStagesConfig cpy() {
/*     */     BonusStagesConfig bonusStagesConfig;
/* 203 */     (bonusStagesConfig = new BonusStagesConfig()).reRollEnabled = this.reRollEnabled;
/* 204 */     bonusStagesConfig.forceImmediateSelection = this.forceImmediateSelection;
/* 205 */     bonusStagesConfig.replaceBonusesWithNotSatisfiedPreconditions = this.replaceBonusesWithNotSatisfiedPreconditions;
/* 206 */     bonusStagesConfig.maxReRollsPerStage = this.maxReRollsPerStage;
/* 207 */     bonusStagesConfig.maxReRollsAllTime = this.maxReRollsAllTime;
/* 208 */     bonusStagesConfig.reRollPrice = this.reRollPrice;
/* 209 */     bonusStagesConfig.reRollMinPrice = this.reRollMinPrice;
/* 210 */     bonusStagesConfig.reRollMaxPrice = this.reRollMaxPrice;
/* 211 */     bonusStagesConfig.reRollPricePerStage = this.reRollPricePerStage;
/* 212 */     bonusStagesConfig.immediateBonusesChance = this.immediateBonusesChance;
/* 213 */     bonusStagesConfig.persistentBonusesChance = this.persistentBonusesChance;
/* 214 */     bonusStagesConfig.activeBonusesSlotLimit = this.activeBonusesSlotLimit;
/* 215 */     bonusStagesConfig.chainReRoll = this.chainReRoll;
/* 216 */     bonusStagesConfig.ignoreImpossiblePreconditions = this.ignoreImpossiblePreconditions;
/* 217 */     bonusStagesConfig.selectedBonusAffectsRandom = this.selectedBonusAffectsRandom;
/* 218 */     bonusStagesConfig.stageRequirements.clear();
/* 219 */     bonusStagesConfig.stageRequirements.addAll(this.stageRequirements);
/* 220 */     bonusStagesConfig.seed = this.seed;
/* 221 */     bonusStagesConfig.endlessStageRequirement = this.endlessStageRequirement;
/* 222 */     bonusStagesConfig.endlessStageRequirementPerStage = this.endlessStageRequirementPerStage;
/* 223 */     bonusStagesConfig.isFillWithDefaultBonusProviders = this.isFillWithDefaultBonusProviders;
/* 224 */     bonusStagesConfig.bonusProviderListClassNames.addAll(this.bonusProviderListClassNames);
/* 225 */     bonusStagesConfig.probableBonusesProviders.addAll(this.probableBonusesProviders);
/* 226 */     bonusStagesConfig.bonusesConfig = JsonHandler.cloneJsonValue(this.bonusesConfig);
/* 227 */     return bonusStagesConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BonusStagesConfig fromJsonString(String paramString) {
/* 234 */     return fromJson((new JsonReader()).parse(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public static BonusStagesConfig fromJson(JsonValue paramJsonValue) {
/*     */     BonusStagesConfig bonusStagesConfig;
/* 240 */     (bonusStagesConfig = new BonusStagesConfig()).forceImmediateSelection = paramJsonValue.getBoolean("forceImmediateSelection", bonusStagesConfig.forceImmediateSelection);
/* 241 */     bonusStagesConfig.replaceBonusesWithNotSatisfiedPreconditions = paramJsonValue.getBoolean("replaceBonusesWithNotSatisfiedPreconditions", bonusStagesConfig.replaceBonusesWithNotSatisfiedPreconditions);
/* 242 */     bonusStagesConfig.reRollEnabled = paramJsonValue.getBoolean("reRollEnabled", bonusStagesConfig.reRollEnabled);
/* 243 */     bonusStagesConfig.maxReRollsPerStage = paramJsonValue.getInt("reRollEnabled", bonusStagesConfig.maxReRollsPerStage);
/* 244 */     bonusStagesConfig.maxReRollsAllTime = paramJsonValue.getInt("maxReRollsAllTime", bonusStagesConfig.maxReRollsAllTime);
/* 245 */     bonusStagesConfig.reRollPrice = paramJsonValue.getFloat("reRollPrice", bonusStagesConfig.reRollPrice);
/* 246 */     bonusStagesConfig.reRollMinPrice = paramJsonValue.getFloat("reRollMinPrice", bonusStagesConfig.reRollMinPrice);
/* 247 */     bonusStagesConfig.reRollMaxPrice = paramJsonValue.getFloat("reRollMaxPrice", bonusStagesConfig.reRollMaxPrice);
/* 248 */     bonusStagesConfig.reRollPricePerStage = paramJsonValue.getFloat("reRollMaxPrice", bonusStagesConfig.reRollPricePerStage);
/* 249 */     bonusStagesConfig.immediateBonusesChance = paramJsonValue.getFloat("immediateBonusesChance", bonusStagesConfig.immediateBonusesChance);
/* 250 */     bonusStagesConfig.persistentBonusesChance = paramJsonValue.getFloat("persistentBonusesChance", bonusStagesConfig.persistentBonusesChance);
/* 251 */     bonusStagesConfig.activeBonusesSlotLimit = paramJsonValue.getInt("activeBonusesSlotLimit", bonusStagesConfig.activeBonusesSlotLimit);
/* 252 */     bonusStagesConfig.chainReRoll = paramJsonValue.getBoolean("reRollMaxPrice", bonusStagesConfig.chainReRoll);
/* 253 */     bonusStagesConfig.ignoreImpossiblePreconditions = paramJsonValue.getBoolean("ignoreImpossiblePreconditions", bonusStagesConfig.ignoreImpossiblePreconditions);
/* 254 */     bonusStagesConfig.selectedBonusAffectsRandom = paramJsonValue.getBoolean("reRollMaxPrice", bonusStagesConfig.selectedBonusAffectsRandom);
/*     */     JsonValue jsonValue;
/* 256 */     if ((jsonValue = paramJsonValue.get("stageRequirements")) != null) {
/* 257 */       bonusStagesConfig.stageRequirements.clear();
/* 258 */       bonusStagesConfig.stageRequirements.addAll(paramJsonValue.get("stageRequirements").asIntArray());
/*     */     } 
/* 260 */     bonusStagesConfig.seed = paramJsonValue.getInt("seed", bonusStagesConfig.seed);
/* 261 */     bonusStagesConfig.endlessStageRequirement = paramJsonValue.getInt("endlessStageRequirement", bonusStagesConfig.endlessStageRequirement);
/* 262 */     bonusStagesConfig.endlessStageRequirementPerStage = paramJsonValue.getInt("endlessStageRequirementPerStage", bonusStagesConfig.endlessStageRequirementPerStage);
/* 263 */     bonusStagesConfig.isFillWithDefaultBonusProviders = paramJsonValue.getBoolean("fillWithDefaultBonusProviders", false);
/* 264 */     if (bonusStagesConfig.isFillWithDefaultBonusProviders) {
/* 265 */       bonusStagesConfig.fillWithDefaultBonusProviders();
/*     */     }
/*     */     
/* 268 */     if ((jsonValue = paramJsonValue.get("bonusProviderList")) != null) {
/* 269 */       JsonValue.JsonIterator<JsonValue> jsonIterator; if (bonusStagesConfig.isFillWithDefaultBonusProviders) {
/*     */         
/* 271 */         for (jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) {
/*     */           String str; JsonValue jsonValue1;
/* 273 */           if (!(str = (jsonValue1 = jsonIterator.next()).asString()).contains(".")) {
/* 274 */             str = "com.prineside.tdi2.gameplayMods.mods." + str;
/*     */           }
/*     */           try {
/* 277 */             Class<?> clazz = ReflectionUtils.getClassByName(str);
/*     */ 
/*     */             
/* 280 */             boolean bool = false;
/* 281 */             for (byte b = 0; b < bonusStagesConfig.probableBonusesProviders.size; b++) {
/*     */               ProbableBonusesProvider probableBonusesProvider;
/* 283 */               if ((probableBonusesProvider = (ProbableBonusesProvider)bonusStagesConfig.probableBonusesProviders.get(b)).getClass() == clazz) {
/* 284 */                 bonusStagesConfig.probableBonusesProviders.removeIndex(b);
/* 285 */                 bool = true;
/*     */                 break;
/*     */               } 
/*     */             } 
/* 289 */             if (!bool) {
/* 290 */               a.e("active provider not found and can't be disabled: " + str, new Object[0]);
/*     */             }
/* 292 */             bonusStagesConfig.bonusProviderListClassNames.add(str);
/* 293 */           } catch (Exception exception) {
/* 294 */             a.e("failed to init probable bonus provider: " + str, new Object[0]);
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 299 */         for (jsonIterator = jsonIterator.iterator(); jsonIterator.hasNext(); ) {
/*     */           String str; JsonValue jsonValue1;
/* 301 */           if (!(str = (jsonValue1 = jsonIterator.next()).asString()).contains(".")) {
/* 302 */             str = "com.prineside.tdi2.gameplayMods.mods." + str;
/*     */           }
/*     */           
/*     */           try {
/*     */             Class<?> clazz;
/* 307 */             ProbableBonusesProvider probableBonusesProvider = (ProbableBonusesProvider)(clazz = ReflectionUtils.getClassByName(str)).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
/*     */             
/* 309 */             boolean bool = false;
/* 310 */             for (byte b = 0; b < bonusStagesConfig.probableBonusesProviders.size; b++) {
/*     */               ProbableBonusesProvider probableBonusesProvider1;
/* 312 */               if ((probableBonusesProvider1 = (ProbableBonusesProvider)bonusStagesConfig.probableBonusesProviders.get(b)) == probableBonusesProvider) {
/* 313 */                 bool = true;
/*     */                 break;
/*     */               } 
/*     */             } 
/* 317 */             if (bool) {
/* 318 */               a.e("can't add bonus provider " + probableBonusesProvider + " - already added", new Object[0]); continue;
/*     */             } 
/* 320 */             bonusStagesConfig.bonusProviderListClassNames.add(str);
/* 321 */             bonusStagesConfig.probableBonusesProviders.add(probableBonusesProvider);
/*     */           }
/* 323 */           catch (Exception exception) {
/* 324 */             a.e("failed to init probable bonus provider: " + str, new Object[0]);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 329 */     bonusStagesConfig.bonusesConfig = paramJsonValue.get("bonusesConfig");
/*     */     
/* 331 */     return bonusStagesConfig;
/*     */   }
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 335 */     paramJson.writeValue("forceImmediateSelection", Boolean.valueOf(this.forceImmediateSelection));
/* 336 */     paramJson.writeValue("replaceBonusesWithNotSatisfiedPreconditions", Boolean.valueOf(this.replaceBonusesWithNotSatisfiedPreconditions));
/* 337 */     paramJson.writeValue("reRollEnabled", Boolean.valueOf(this.reRollEnabled));
/* 338 */     paramJson.writeValue("maxReRollsPerStage", Integer.valueOf(this.maxReRollsPerStage));
/* 339 */     paramJson.writeValue("maxReRollsAllTime", Integer.valueOf(this.maxReRollsAllTime));
/* 340 */     paramJson.writeValue("reRollPrice", Float.valueOf(this.reRollPrice));
/* 341 */     paramJson.writeValue("reRollMinPrice", Float.valueOf(this.reRollMinPrice));
/* 342 */     paramJson.writeValue("reRollMaxPrice", Float.valueOf(this.reRollMaxPrice));
/* 343 */     paramJson.writeValue("reRollPricePerStage", Float.valueOf(this.reRollPricePerStage));
/* 344 */     paramJson.writeValue("immediateBonusesChance", Float.valueOf(this.immediateBonusesChance));
/* 345 */     paramJson.writeValue("persistentBonusesChance", Float.valueOf(this.persistentBonusesChance));
/* 346 */     paramJson.writeValue("activeBonusesSlotLimit", Integer.valueOf(this.activeBonusesSlotLimit));
/* 347 */     paramJson.writeValue("chainReRoll", Boolean.valueOf(this.chainReRoll));
/* 348 */     paramJson.writeValue("ignoreImpossiblePreconditions", Boolean.valueOf(this.ignoreImpossiblePreconditions));
/* 349 */     paramJson.writeValue("selectedBonusAffectsRandom", Boolean.valueOf(this.selectedBonusAffectsRandom));
/* 350 */     paramJson.writeValue("stageRequirements", this.stageRequirements.toArray());
/* 351 */     paramJson.writeValue("seed", Integer.valueOf(this.seed));
/* 352 */     paramJson.writeValue("endlessStageRequirement", Integer.valueOf(this.endlessStageRequirement));
/* 353 */     paramJson.writeValue("endlessStageRequirementPerStage", Integer.valueOf(this.endlessStageRequirementPerStage));
/* 354 */     paramJson.writeValue("fillWithDefaultBonusProviders", Boolean.valueOf(this.isFillWithDefaultBonusProviders));
/* 355 */     paramJson.writeArrayStart("bonusProviderList");
/* 356 */     for (byte b = 0; b < this.bonusProviderListClassNames.size; b++) {
/*     */       String str;
/* 358 */       if ((str = (String)this.bonusProviderListClassNames.get(b)).startsWith("com.prineside.tdi2.gameplayMods.mods.")) {
/* 359 */         str = str.substring(37);
/*     */       }
/* 361 */       paramJson.writeValue(str);
/*     */     } 
/* 363 */     paramJson.writeArrayEnd();
/*     */     try {
/* 365 */       paramJson.getWriter().name("bonusesConfig").json(this.bonusesConfig.toJson(JsonWriter.OutputType.json)); return;
/* 366 */     } catch (IOException iOException) {
/* 367 */       throw new RuntimeException(iOException);
/*     */     }  } public void fillWithDefaultBonusProviders() {
/*     */     ProbableBonusesProvider[] arrayOfProbableBonusesProvider;
/*     */     int i;
/*     */     byte b;
/* 372 */     for (i = (arrayOfProbableBonusesProvider = DEFAULT_BONUS_PROVIDERS).length, b = 0; b < i; ) { ProbableBonusesProvider probableBonusesProvider = arrayOfProbableBonusesProvider[b];
/* 373 */       if (!this.probableBonusesProviders.contains(probableBonusesProvider, true)) {
/* 374 */         this.probableBonusesProviders.add(probableBonusesProvider);
/*     */       }
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBonusesConfig(JsonValue paramJsonValue) {
/* 383 */     this.bonusesConfig = paramJsonValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DelayedRemovalArray<ProbableBonus> getProbableBonuses(int paramInt, GameSystemProvider paramGameSystemProvider) {
/* 390 */     paramGameSystemProvider.gameState.checkGameplayUpdateAllowed();
/* 391 */     DelayedRemovalArray<ProbableBonus> delayedRemovalArray = new DelayedRemovalArray(true, 1, ProbableBonus.class);
/*     */     byte b;
/* 393 */     for (b = 0; b < this.probableBonusesProviders.size; b++) {
/* 394 */       ((ProbableBonusesProvider)this.probableBonusesProviders.get(b)).provide(paramInt, paramGameSystemProvider.bonus.getStagesConfig(), (Array<GameplayModSystem.ActiveMod>)paramGameSystemProvider.gameplayMod.getActiveMods(), (Array<ProbableBonus>)delayedRemovalArray);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 404 */     if (this.immediateBonusesChance != 1.0F) {
/* 405 */       delayedRemovalArray.begin();
/* 406 */       for (b = 0; b < delayedRemovalArray.size; b++) {
/*     */         ProbableBonus probableBonus;
/* 408 */         if ((probableBonus = (ProbableBonus)delayedRemovalArray.get(b)).getBonus().isImmediateAndNotListed()) {
/* 409 */           probableBonus.setProbability((int)(probableBonus.getProbability() * this.immediateBonusesChance));
/* 410 */           if (probableBonus.getProbability() <= 0) {
/* 411 */             delayedRemovalArray.removeIndex(b);
/*     */           }
/*     */         } 
/*     */       } 
/* 415 */       delayedRemovalArray.end();
/*     */     } 
/*     */     
/* 418 */     if (this.persistentBonusesChance != 1.0F) {
/* 419 */       delayedRemovalArray.begin();
/* 420 */       for (b = 0; b < delayedRemovalArray.size; b++) {
/*     */         ProbableBonus probableBonus;
/* 422 */         if (!(probableBonus = (ProbableBonus)delayedRemovalArray.get(b)).getBonus().isImmediateAndNotListed()) {
/* 423 */           probableBonus.setProbability((int)(probableBonus.getProbability() * this.persistentBonusesChance));
/* 424 */           if (probableBonus.getProbability() <= 0) {
/* 425 */             delayedRemovalArray.removeIndex(b);
/*     */           }
/*     */         } 
/*     */       } 
/* 429 */       delayedRemovalArray.end();
/*     */     } 
/*     */     
/* 432 */     if (this.activeBonusesSlotLimit > 0) {
/*     */       
/* 434 */       DelayedRemovalArray delayedRemovalArray1 = paramGameSystemProvider.gameplayMod.getActiveMods();
/*     */       
/* 436 */       byte b1 = 0; byte b2;
/* 437 */       for (b2 = 0; b2 < delayedRemovalArray1.size; b2++) {
/*     */         GameplayModSystem.ActiveMod activeMod;
/* 439 */         if ((activeMod = ((GameplayModSystem.ActiveMod[])delayedRemovalArray1.items)[b2]).getSource().equals("BonusSystem") && !activeMod.getMod().isImmediateAndNotListed()) {
/* 440 */           b1++;
/*     */         }
/*     */       } 
/* 443 */       if (b1 >= this.activeBonusesSlotLimit) {
/*     */         
/* 445 */         delayedRemovalArray.begin();
/* 446 */         for (b2 = 0; b2 < delayedRemovalArray.size; b2++) {
/*     */           ProbableBonus probableBonus;
/* 448 */           if (!(probableBonus = (ProbableBonus)delayedRemovalArray.get(b2)).getBonus().isImmediateAndNotListed()) {
/* 449 */             b1 = 0;
/* 450 */             for (byte b3 = 0; b3 < delayedRemovalArray1.size; b3++) {
/*     */               GameplayModSystem.ActiveMod activeMod;
/* 452 */               if ((activeMod = ((GameplayModSystem.ActiveMod[])delayedRemovalArray1.items)[b3]).getSource().equals("BonusSystem") && !activeMod.getMod().isImmediateAndNotListed() && 
/* 453 */                 activeMod.getMod().getId().equals(probableBonus.getBonus().getId())) {
/* 454 */                 b1 = 1;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */             
/* 460 */             if (b1 == 0) {
/* 461 */               delayedRemovalArray.removeIndex(b2);
/*     */             }
/*     */           } 
/*     */         } 
/* 465 */         delayedRemovalArray.end();
/*     */       } 
/*     */     } 
/*     */     
/* 469 */     if (!this.ignoreImpossiblePreconditions) {
/*     */       
/* 471 */       delayedRemovalArray.begin();
/* 472 */       for (b = 0; b < delayedRemovalArray.size; b++) {
/*     */         ProbableBonus probableBonus;
/* 474 */         if ((probableBonus = (ProbableBonus)delayedRemovalArray.get(b)).getBonus().isAlwaysUseless(paramGameSystemProvider)) {
/* 475 */           a.i("exclude useless: " + probableBonus.getBonus().getId(), new Object[0]);
/* 476 */           delayedRemovalArray.removeIndex(b);
/*     */         } 
/*     */       } 
/* 479 */       delayedRemovalArray.end();
/*     */     } 
/*     */     
/* 482 */     if (!Config.isHeadless()) {
/* 483 */       a.i("getProbableBonuses " + paramInt, new Object[0]);
/* 484 */       for (b = 0; b < delayedRemovalArray.size; b++) {
/* 485 */         ProbableBonus probableBonus = (ProbableBonus)delayedRemovalArray.get(b);
/* 486 */         a.i(((probableBonus.getBonus().getNotSatisfiedPreconditions(paramGameSystemProvider) == null) ? 1 : 0) + " " + probableBonus.getProbability() + ": " + probableBonus.getBonus().getId(), new Object[0]);
/*     */       } 
/*     */     } 
/*     */     
/* 490 */     return delayedRemovalArray;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonValue getBonusConfig(String paramString) {
/* 497 */     if (paramString.contains(".")) {
/* 498 */       throw new IllegalArgumentException("Dots are not allowed in path. Provide a correct name of the bonus");
/*     */     }
/*     */     
/* 501 */     return JsonHandler.orEmptyObject(this.bonusesConfig.get(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStageRequirement(int paramInt) {
/* 509 */     return (paramInt > this.stageRequirements.size) ? (this.endlessStageRequirement + this.endlessStageRequirementPerStage * (paramInt - this.stageRequirements.size)) : this.stageRequirements.get(paramInt - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxStages() {
/* 516 */     return (this.endlessStageRequirement <= 0) ? this.stageRequirements.size : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReRollPrice(int paramInt, GameSystemProvider paramGameSystemProvider) {
/* 525 */     if (this.reRollMaxPrice <= 0.0F) {
/* 526 */       return 0;
/*     */     }
/*     */     
/* 529 */     float f = MathUtils.clamp(this.reRollPrice + paramInt * this.reRollPricePerStage, this.reRollMinPrice, this.reRollMaxPrice);
/* 530 */     return MathUtils.ceil((float)paramGameSystemProvider.statistics.getStatistic(StatisticsType.CG) * f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxReRollsPerStage() {
/* 537 */     return this.maxReRollsPerStage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxReRollsAllTime() {
/* 544 */     return this.maxReRollsAllTime;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\BonusStagesConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */