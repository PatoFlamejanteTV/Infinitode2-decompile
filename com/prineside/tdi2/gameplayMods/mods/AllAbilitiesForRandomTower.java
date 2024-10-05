/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class AllAbilitiesForRandomTower extends GenericGameplayMod {
/*  27 */   private static final TLog a = TLog.forClass(AllAbilitiesForRandomTower.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  40 */     super.write(paramKryo, paramOutput);
/*  41 */     paramOutput.writeVarInt(this.b, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  46 */     super.read(paramKryo, paramInput);
/*  47 */     this.b = paramInput.readVarInt(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  52 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  57 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.AllAbilitiesForRandomTower");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  62 */     return Game.i.localeManager.i18n.format("gmod_descr_all_abilities_for_random_tower", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  67 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final AllAbilitiesForRandomTower cpy() {
/*  72 */     AllAbilitiesForRandomTower allAbilitiesForRandomTower = new AllAbilitiesForRandomTower();
/*  73 */     a(allAbilitiesForRandomTower);
/*  74 */     allAbilitiesForRandomTower.b = this.b;
/*  75 */     return allAbilitiesForRandomTower;
/*     */   }
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/*     */     int j;
/*     */     int i;
/*  81 */     if ((i = (getSuitableTowers(paramGameSystemProvider)).size) >= this.b) {
/*  82 */       return null;
/*     */     }
/*     */     
/*  85 */     return () -> Game.i.localeManager.i18n.format("gpmod_precondition_all_abilities_for_random_tower", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     Array<Tower> array;
/*  92 */     if ((array = getSuitableTowers(paramGameSystemProvider)).size == 0) {
/*  93 */       a.e("no suitable towers found, can't register", new Object[0]);
/*  94 */       return false;
/*     */     } 
/*     */     
/*     */     RandomXS128 randomXS128;
/*  98 */     int i = (randomXS128 = paramGameSystemProvider.gameplayMod.getModRandom(3805)).nextInt(array.size);
/*  99 */     Tower tower = (Tower)array.get(i);
/* 100 */     paramGameSystemProvider.tower.setAbilityInstalled(tower, 0, true);
/* 101 */     paramGameSystemProvider.tower.setAbilityInstalled(tower, 1, true);
/* 102 */     paramGameSystemProvider.tower.setAbilityInstalled(tower, 2, true);
/* 103 */     paramGameSystemProvider.tower.setAbilityInstalled(tower, 4, true);
/* 104 */     paramGameSystemProvider.tower.setAbilityInstalled(tower, 5, true);
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 107 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(AllAbilitiesForRandomTower.class, paramString)) != null) {
/* 108 */       activeMod.getMod().setRegisteredPower(this.power);
/* 109 */       return false;
/*     */     } 
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final AllAbilitiesForRandomTower applyConfig(JsonValue paramJsonValue) {
/* 118 */     super.applyConfig(paramJsonValue);
/* 119 */     return this;
/*     */   }
/*     */   
/*     */   public static Array<Tower> getSuitableTowers(GameSystemProvider paramGameSystemProvider) {
/* 123 */     Array<Tower> array = new Array(true, 1, Tower.class);
/* 124 */     for (byte b = 0; b < paramGameSystemProvider.tower.towers.size; b++) {
/*     */       Tower tower;
/*     */       
/* 127 */       if (!(tower = (Tower)paramGameSystemProvider.tower.towers.get(b)).isAbilityInstalled(0) || 
/* 128 */         !tower.isAbilityInstalled(1) || 
/* 129 */         !tower.isAbilityInstalled(2) || 
/* 130 */         !tower.isAbilityInstalled(4) || 
/* 131 */         !tower.isAbilityInstalled(5))
/*     */       {
/* 133 */         array.add(tower);
/*     */       }
/*     */     } 
/*     */     
/* 137 */     return array;
/*     */   }
/*     */   
/*     */   public static Array<Tower> getAlreadyActiveTowers(GameSystemProvider paramGameSystemProvider) {
/* 141 */     Array<Tower> array = new Array(true, 1, Tower.class);
/* 142 */     for (byte b = 0; b < paramGameSystemProvider.tower.towers.size; b++) {
/*     */       Tower tower;
/* 144 */       if ((tower = (Tower)paramGameSystemProvider.tower.towers.get(b))
/* 145 */         .isAbilityInstalled(0) && tower
/* 146 */         .isAbilityInstalled(1) && tower
/* 147 */         .isAbilityInstalled(2) && tower
/* 148 */         .isAbilityInstalled(4) && tower
/* 149 */         .isAbilityInstalled(5))
/*     */       {
/* 151 */         array.add(tower);
/*     */       }
/*     */     } 
/*     */     
/* 155 */     return array;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 162 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 165 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 170 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("AllAbilitiesForRandomTower");
/*     */       AllAbilitiesForRandomTower allAbilitiesForRandomTower;
/* 172 */       AllAbilitiesForRandomTower.a(allAbilitiesForRandomTower = (new AllAbilitiesForRandomTower()).applyConfig(jsonValue), jsonValue.getInt("minSuitableTowersOnMap", 2));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(allAbilitiesForRandomTower, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.7F)).setPowerUpProbabilityMultiplier(0.9F).applyConfig(jsonValue))) != null)
/* 183 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\AllAbilitiesForRandomTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */