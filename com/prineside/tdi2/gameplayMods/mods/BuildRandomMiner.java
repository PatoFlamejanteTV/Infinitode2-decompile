/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Miner;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class BuildRandomMiner extends GenericGameplayMod {
/*  35 */   private static final TLog a = TLog.forClass(BuildRandomMiner.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   public int minerCount = 1;
/*  43 */   public int upgradeLevel = 1;
/*  44 */   public float doubleSpeedDuration = 600.0F;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  48 */     super.write(paramKryo, paramOutput);
/*  49 */     paramOutput.writeInt(this.minerCount);
/*  50 */     paramOutput.writeInt(this.upgradeLevel);
/*  51 */     paramOutput.writeFloat(this.doubleSpeedDuration);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  56 */     super.read(paramKryo, paramInput);
/*  57 */     this.minerCount = paramInput.readInt();
/*  58 */     this.upgradeLevel = paramInput.readInt();
/*  59 */     this.doubleSpeedDuration = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  69 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.BuildRandomMiner");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  74 */     String str = StringFormatter.timePassed(MathUtils.round(this.doubleSpeedDuration), false, false);
/*  75 */     return Game.i.localeManager.i18n.format("gmod_descr_build_random_miner", new Object[] { Integer.valueOf(this.minerCount), Integer.valueOf(this.upgradeLevel), str });
/*     */   }
/*     */ 
/*     */   
/*     */   public final BuildRandomMiner cpy() {
/*  80 */     BuildRandomMiner buildRandomMiner = new BuildRandomMiner();
/*  81 */     a(buildRandomMiner);
/*  82 */     buildRandomMiner.minerCount = this.minerCount;
/*  83 */     buildRandomMiner.upgradeLevel = this.upgradeLevel;
/*  84 */     buildRandomMiner.doubleSpeedDuration = this.doubleSpeedDuration;
/*  85 */     return buildRandomMiner;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/*  91 */     return ((paramGameSystemProvider.map.getMap().getTilesByType(SourceTile.class)).size == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/*  96 */     if ((getSuitablePlaces(paramGameSystemProvider)).size == 0) {
/*  97 */       return () -> Game.i.localeManager.i18n.get("gpmod_precondition_build_random_miner");
/*     */     }
/*  99 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 105 */     RandomXS128 randomXS128 = paramGameSystemProvider.gameplayMod.getModRandom(9427);
/*     */     
/* 107 */     Array<ObjectPair<SourceTile, MinerType>> array = getSuitablePlaces(paramGameSystemProvider);
/* 108 */     for (byte b = 0; b < this.minerCount; b++) {
/* 109 */       if (array.size > 0) {
/* 110 */         ObjectPair objectPair = (ObjectPair)array.removeIndex(randomXS128.nextInt(array.size));
/*     */         Miner miner;
/* 112 */         if ((miner = paramGameSystemProvider.miner.buildMiner((MinerType)objectPair.second, ((SourceTile)objectPair.first).getX(), ((SourceTile)objectPair.first).getY(), false, false)) != null) {
/* 113 */           if (this.upgradeLevel > 0) {
/* 114 */             miner.setUpgradeLevel(this.upgradeLevel);
/*     */           }
/* 116 */           if (this.doubleSpeedDuration > 0.0F) {
/* 117 */             miner.doubleSpeedTimeLeft = this.doubleSpeedDuration;
/*     */           }
/*     */         } 
/*     */       } else {
/* 121 */         a.e("bonus ignored - no suitable place for miner " + (b + 1) + " / " + this.minerCount, new Object[0]);
/*     */       } 
/*     */     } 
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 126 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(BuildRandomMiner.class, paramString)) != null) {
/* 127 */       activeMod.getMod().setRegisteredPower(this.power);
/* 128 */       return false;
/*     */     } 
/* 130 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Array<ObjectPair<SourceTile, MinerType>> getSuitablePlaces(GameSystemProvider paramGameSystemProvider) {
/* 135 */     boolean[][] arrayOfBoolean = new boolean[MinerType.values.length][ResourceType.values.length]; MinerType[] arrayOfMinerType; int i; byte b;
/* 136 */     for (i = (arrayOfMinerType = MinerType.values).length, b = 0; b < i; ) { MinerType minerType = arrayOfMinerType[b];
/* 137 */       if (paramGameSystemProvider.miner.getMaxMinersCount(minerType) > 0) {
/* 138 */         Miner.Factory factory = Game.i.minerManager.getFactory(minerType); ResourceType[] arrayOfResourceType; int j; byte b1;
/* 139 */         for (j = (arrayOfResourceType = ResourceType.values).length, b1 = 0; b1 < j; ) { ResourceType resourceType = arrayOfResourceType[b1];
/* 140 */           if (factory.canMineResource(resourceType))
/* 141 */             arrayOfBoolean[minerType.ordinal()][resourceType.ordinal()] = true; 
/*     */           b1++; }
/*     */       
/*     */       } 
/*     */       b++; }
/*     */     
/* 147 */     Array<ObjectPair<SourceTile, MinerType>> array = new Array(true, 1, ObjectPair.class);
/* 148 */     for (i = 0; i < (paramGameSystemProvider.map.getMap().getAllTiles()).size; i++) {
/*     */       Tile tile; SourceTile sourceTile;
/* 150 */       if ((tile = (Tile)paramGameSystemProvider.map.getMap().getAllTiles().get(i)).type == TileType.SOURCE && 
/*     */         
/* 152 */         (sourceTile = (SourceTile)tile).miner == null) {
/* 153 */         ResourceType[] arrayOfResourceType; int j; byte b1; for (j = (arrayOfResourceType = ResourceType.values).length, b1 = 0; b1 < j; ) { ResourceType resourceType = arrayOfResourceType[b1];
/*     */           int k;
/* 155 */           if ((k = sourceTile.getResourcesCount(resourceType)) > 0) {
/* 156 */             MinerType[] arrayOfMinerType1; byte b2; for (k = (arrayOfMinerType1 = MinerType.values).length, b2 = 0; b2 < k; ) { MinerType minerType = arrayOfMinerType1[b2];
/* 157 */               if (arrayOfBoolean[minerType.ordinal()][resourceType.ordinal()]) {
/* 158 */                 array.add(new ObjectPair(sourceTile, minerType));
/*     */               }
/*     */               b2++; }
/*     */           
/*     */           } 
/*     */           b1++; }
/*     */       
/*     */       } 
/*     */     } 
/* 167 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 172 */     return GameplayModCategory.LOOTING;
/*     */   }
/*     */ 
/*     */   
/*     */   public final BuildRandomMiner applyConfig(JsonValue paramJsonValue) {
/* 177 */     super.applyConfig(paramJsonValue);
/* 178 */     this.minerCount = paramJsonValue.getInt("minerCount", this.minerCount);
/* 179 */     this.upgradeLevel = paramJsonValue.getInt("upgradeLevel", this.upgradeLevel);
/* 180 */     this.doubleSpeedDuration = paramJsonValue.getFloat("doubleSpeedDuration", this.doubleSpeedDuration);
/* 181 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 188 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 191 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 196 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("BuildRandomMiner");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 205 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new BuildRandomMiner()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 206 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\BuildRandomMiner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */