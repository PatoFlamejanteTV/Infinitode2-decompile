/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.tiles.SourceTile;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class GV_MinersMaxUpgradeLevel
/*     */   extends AbstractGameValueMod
/*     */ {
/*     */   public GV_MinersMaxUpgradeLevel() {
/*  27 */     super(GameValueType.MINERS_MAX_UPGRADE_LEVEL, 0.0F, 1.0F, true, GameplayModCategory.LOOTING, (GameplayModCategory)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayMod cpy() {
/*  32 */     GV_MinersMaxUpgradeLevel gV_MinersMaxUpgradeLevel = new GV_MinersMaxUpgradeLevel();
/*  33 */     a(gV_MinersMaxUpgradeLevel);
/*  34 */     return (GameplayMod)gV_MinersMaxUpgradeLevel;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void configure(GameSystemProvider paramGameSystemProvider) {
/*  39 */     int i = 0; MinerType[] arrayOfMinerType; int j; byte b;
/*  40 */     for (j = (arrayOfMinerType = MinerType.values).length, b = 0; b < j; ) { MinerType minerType = arrayOfMinerType[b];
/*  41 */       i = Math.max(i, paramGameSystemProvider.miner.getMaxUpgradeLevel(minerType));
/*     */       b++; }
/*     */     
/*  44 */     this.maxPower = Math.min(this.maxPower, 10 - i);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/*  49 */     return ((paramGameSystemProvider.map.getMap().getTilesByType(SourceTile.class)).size == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/*  54 */     int i = 0;
/*  55 */     boolean bool = false; MinerType[] arrayOfMinerType; int j; byte b;
/*  56 */     for (j = (arrayOfMinerType = MinerType.values).length, b = 0; b < j; ) { MinerType minerType = arrayOfMinerType[b];
/*  57 */       int k = paramGameSystemProvider.miner.getMaxUpgradeLevel(minerType);
/*  58 */       i = Math.max(i, k);
/*  59 */       if (paramGameSystemProvider.miner.getMaxMinersCount(minerType) != 0)
/*  60 */         bool = true; 
/*     */       b++; }
/*     */     
/*  63 */     if (i >= 10 || !bool) {
/*  64 */       int k = i;
/*  65 */       j = bool;
/*  66 */       return () -> {
/*     */           String str = null;
/*     */           if (paramInt >= 10)
/*     */             str = Game.i.localeManager.i18n.format("gpmod_precondition_miners_already_have_max_level", new Object[0]); 
/*     */           if (!paramBoolean) {
/*     */             if (str == null)
/*     */               str = ""; 
/*     */             str = str + Game.i.localeManager.i18n.format("gpmod_precondition_miners_not_available", new Object[0]);
/*     */           } 
/*     */           return str;
/*     */         };
/*     */     } 
/*  78 */     return null;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/*  85 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/*  88 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/*  93 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("GV_MinersMaxUpgradeLevel");
/*     */       
/*     */       GV_MinersMaxUpgradeLevel gV_MinersMaxUpgradeLevel;
/*  96 */       (gV_MinersMaxUpgradeLevel = new GV_MinersMaxUpgradeLevel()).multipleInstances = true;
/*  97 */       gV_MinersMaxUpgradeLevel.maxPower = 3;
/*  98 */       gV_MinersMaxUpgradeLevel.applyConfig(jsonValue);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(gV_MinersMaxUpgradeLevel, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.5F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 109 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\GV_MinersMaxUpgradeLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */