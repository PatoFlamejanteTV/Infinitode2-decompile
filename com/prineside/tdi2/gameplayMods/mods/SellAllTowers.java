/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class SellAllTowers extends GenericGameplayMod {
/*  29 */   private static final TLog a = TLog.forClass(SellAllTowers.class);
/*     */ 
/*     */   
/*  32 */   private float b = 1.15F;
/*     */ 
/*     */ 
/*     */   
/*     */   private int c;
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  41 */     super.write(paramKryo, paramOutput);
/*  42 */     paramOutput.writeFloat(this.b);
/*  43 */     paramOutput.writeInt(this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  48 */     super.read(paramKryo, paramInput);
/*  49 */     this.b = paramInput.readFloat();
/*  50 */     this.c = paramInput.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  60 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.SellAllTowers");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  65 */     String str1 = StringFormatter.compactNumberWithPrecisionTrimZeros((this.b * 100.0F), 1, true).toString();
/*  66 */     String str2 = StringFormatter.commaSeparatedNumber(this.c).toString();
/*  67 */     return Game.i.localeManager.i18n.format("gmod_descr_sell_all_towers", new Object[] { str1, str2 });
/*     */   }
/*     */ 
/*     */   
/*     */   public final SellAllTowers cpy() {
/*  72 */     SellAllTowers sellAllTowers = new SellAllTowers();
/*  73 */     a(sellAllTowers);
/*  74 */     sellAllTowers.b = this.b;
/*  75 */     sellAllTowers.c = this.c;
/*  76 */     return sellAllTowers;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/*  81 */     int i = 0;
/*  82 */     for (byte b = 0; b < paramGameSystemProvider.tower.towers.size; b++) {
/*  83 */       Tower tower = (Tower)paramGameSystemProvider.tower.towers.get(b);
/*  84 */       i += tower.moneySpentOn;
/*     */     } 
/*  86 */     if (i == 0) return () -> Game.i.localeManager.i18n.get("gpmod_precondition_sell_all_towers"); 
/*  87 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void configure(GameSystemProvider paramGameSystemProvider) {
/*  92 */     int i = 0;
/*  93 */     for (byte b = 0; b < paramGameSystemProvider.tower.towers.size; b++) {
/*  94 */       Tower tower = (Tower)paramGameSystemProvider.tower.towers.get(b);
/*  95 */       i += tower.moneySpentOn;
/*     */     } 
/*  97 */     this.c = MathUtils.round(i * this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 102 */     int i = 0;
/* 103 */     for (byte b = 0; b < paramGameSystemProvider.tower.towers.size; b++) {
/* 104 */       Tower tower = (Tower)paramGameSystemProvider.tower.towers.get(b);
/* 105 */       i += tower.getSellPrice();
/*     */     } 
/* 107 */     if (i == 0) {
/* 108 */       a.i("skipped - sumPrice is zero", new Object[0]);
/* 109 */       return false;
/*     */     } 
/*     */ 
/*     */     
/*     */     Array array;
/*     */     
/* 115 */     (array = new Array(true, paramGameSystemProvider.tower.towers.size, Tower.class)).addAll((Array)paramGameSystemProvider.tower.towers);
/*     */     
/* 117 */     float f = 0.0F;
/* 118 */     for (i = 0; i < array.size; i++) {
/*     */       Tower tower;
/* 120 */       if ((tower = (Tower)array.get(i)).moneySpentOn > 0) {
/* 121 */         f += tower.moneySpentOn;
/* 122 */         tower.moneySpentOn = 0;
/* 123 */         paramGameSystemProvider.tower.sellTower(tower);
/*     */       } 
/*     */     } 
/*     */     
/* 127 */     a.i("add money " + f + " -> " + (f * this.b) + " (+" + (f * this.b - f) + " coins)", new Object[0]);
/* 128 */     paramGameSystemProvider.gameState.addMoney(f * this.b, false);
/*     */ 
/*     */     
/* 131 */     for (i = 0; i < (paramGameSystemProvider.gameplayMod.getActiveMods()).size; i++) {
/*     */       GameplayModSystem.ActiveMod activeMod1;
/* 133 */       if ((activeMod1 = (GameplayModSystem.ActiveMod)paramGameSystemProvider.gameplayMod.getActiveMods().get(i)).getMod() instanceof LightningStrikeOnTowerLevelUp) {
/*     */         LightningStrikeOnTowerLevelUp lightningStrikeOnTowerLevelUp;
/* 135 */         (lightningStrikeOnTowerLevelUp = (LightningStrikeOnTowerLevelUp)activeMod1.getMod()).resetStrikeLevelLimits();
/*     */       } 
/*     */     } 
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 140 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(SellAllTowers.class, paramString)) != null) {
/* 141 */       activeMod.getMod().setRegisteredPower(this.power);
/* 142 */       return false;
/*     */     } 
/* 144 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 150 */     return GameplayModCategory.ECONOMICS;
/*     */   }
/*     */ 
/*     */   
/*     */   public final SellAllTowers applyConfig(JsonValue paramJsonValue) {
/* 155 */     super.applyConfig(paramJsonValue);
/* 156 */     this.b = paramJsonValue.getFloat("coinMultiplier", this.b);
/* 157 */     if (this.b < 1.0F) {
/* 158 */       this.b = 1.0F;
/*     */     }
/* 160 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 167 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 170 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 175 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("SellAllTowers");
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */       
/*     */       SellAllTowers sellAllTowers;
/*     */ 
/*     */       
/* 185 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(sellAllTowers = (new SellAllTowers()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.5F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 186 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\SellAllTowers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */