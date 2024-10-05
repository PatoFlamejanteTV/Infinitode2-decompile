/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueConfig;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class DepositCoinsGeneration
/*     */   extends GenericGameplayMod {
/*  30 */   private static final TLog a = TLog.forClass(DepositCoinsGeneration.class);
/*     */ 
/*     */   
/*  33 */   private float b = 1.0F;
/*     */ 
/*     */   
/*     */   @Null
/*     */   private GameSystemProvider c;
/*     */   
/*     */   private GameValueConfig d;
/*     */   
/*     */   private float e;
/*     */   
/*     */   private float f;
/*     */   
/*     */   private boolean g;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  49 */     super.write(paramKryo, paramOutput);
/*  50 */     paramOutput.writeFloat(this.b);
/*  51 */     paramKryo.writeObjectOrNull(paramOutput, this.d, GameValueConfig.class);
/*  52 */     paramKryo.writeObjectOrNull(paramOutput, this.c, GameSystemProvider.class);
/*  53 */     paramOutput.writeFloat(this.e);
/*  54 */     paramOutput.writeFloat(this.f);
/*  55 */     paramOutput.writeBoolean(this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  60 */     super.read(paramKryo, paramInput);
/*  61 */     this.b = paramInput.readFloat();
/*  62 */     this.d = (GameValueConfig)paramKryo.readObjectOrNull(paramInput, GameValueConfig.class);
/*  63 */     this.c = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*  64 */     this.e = paramInput.readFloat();
/*  65 */     this.f = paramInput.readFloat();
/*  66 */     this.g = paramInput.readBoolean();
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/*  71 */     return GameplayModCategory.ECONOMICS;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  76 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.DepositCoinsGeneration");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  81 */     return Game.i.localeManager.i18n.format("gmod_descr_deposit_coins_generation", new Object[] { StringFormatter.compactNumberWithPrecisionTrimZeros((this.b * this.power), 1, true) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayMod cpy() {
/*  86 */     DepositCoinsGeneration depositCoinsGeneration = new DepositCoinsGeneration();
/*  87 */     a(depositCoinsGeneration);
/*  88 */     depositCoinsGeneration.b = this.b;
/*  89 */     depositCoinsGeneration.e = this.e;
/*  90 */     depositCoinsGeneration.f = this.f;
/*  91 */     depositCoinsGeneration.g = this.g;
/*  92 */     return (GameplayMod)depositCoinsGeneration;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void configure(GameSystemProvider paramGameSystemProvider) {
/*     */     float f;
/*  98 */     if (this.g) {
/*     */       
/* 100 */       a.i("config on " + paramGameSystemProvider.statistics.getAverageCoinsPerMinute() + " x " + this.e, new Object[0]);
/* 101 */       f = paramGameSystemProvider.statistics.getAverageCoinsPerMinute() * this.e;
/*     */     } else {
/*     */       
/* 104 */       f = this.f;
/*     */     } 
/* 106 */     this.b = f / this.power;
/* 107 */     paramGameSystemProvider.syncLog("configure", new Object[] { "DepositCoinsGeneration", Float.valueOf(this.b) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 112 */     this.c = paramGameSystemProvider;
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 115 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(DepositCoinsGeneration.class, paramString)) == null) {
/*     */       
/* 117 */       this.d = new GameValueConfig(GameValueType.COINS_GENERATION, (this.b * this.power), false, true);
/* 118 */       paramGameSystemProvider.gameValue.addCustomGameValue(this.d);
/*     */       
/* 120 */       return true;
/*     */     } 
/*     */     
/*     */     DepositCoinsGeneration depositCoinsGeneration;
/* 124 */     (depositCoinsGeneration = (DepositCoinsGeneration)activeMod.getMod()).b = this.b;
/* 125 */     depositCoinsGeneration.power = this.power;
/* 126 */     depositCoinsGeneration.a();
/*     */     
/* 128 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/* 133 */     this.d.setValue((this.b * this.power));
/* 134 */     this.c.gameValue.recalculate();
/*     */   }
/*     */ 
/*     */   
/*     */   public final DepositCoinsGeneration applyConfig(JsonValue paramJsonValue) {
/* 139 */     super.applyConfig(paramJsonValue);
/* 140 */     this.b = paramJsonValue.getFloat("coinsPerMinute", this.b);
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setRegisteredPower(int paramInt) {
/* 146 */     super.setRegisteredPower(paramInt);
/* 147 */     a();
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider
/*     */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     static {
/* 154 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     } private static final BonusProvider a;
/*     */     public static BonusProvider getInstance() {
/* 157 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 162 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("DepositCoinsGeneration");
/*     */ 
/*     */ 
/*     */       
/* 166 */       ProbableBonusesProvider.BonusProviderConfig bonusProviderConfig = (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.9F).applyConfig(jsonValue);
/*     */ 
/*     */       
/* 169 */       boolean bool = jsonValue.getBoolean("dependsOnPlayerCpm", true);
/* 170 */       float f = 0.0F;
/*     */       
/* 172 */       if (!bool)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 177 */         f = jsonValue.getFloat("baseBonusCpm", 10.0F) + jsonValue.getFloat("bonusCpmPerStage", 2.0F) * (param1Int - 1);
/*     */       }
/*     */       
/* 180 */       DepositCoinsGeneration depositCoinsGeneration1 = new DepositCoinsGeneration();
/*     */       
/* 182 */       DepositCoinsGeneration depositCoinsGeneration2 = null;
/* 183 */       for (byte b = 0; b < param1Array.size; b++) {
/*     */         GameplayModSystem.ActiveMod activeMod;
/* 185 */         if ((activeMod = ((GameplayModSystem.ActiveMod[])param1Array.items)[b]).getMod().getId().equals(depositCoinsGeneration1.getId()) && activeMod.getSource().equals("BonusSystem")) {
/*     */           
/* 187 */           depositCoinsGeneration2 = (DepositCoinsGeneration)activeMod.getMod();
/*     */           break;
/*     */         } 
/*     */       } 
/* 191 */       DepositCoinsGeneration.a(depositCoinsGeneration1, jsonValue.getFloat("playerCpmMultiplier", 0.03F) + jsonValue.getFloat("playerCpmMultiplierPerStage", 0.001F) * (param1Int - 1));
/* 192 */       DepositCoinsGeneration.b(depositCoinsGeneration1, f);
/* 193 */       DepositCoinsGeneration.a(depositCoinsGeneration1, bool);
/* 194 */       if (depositCoinsGeneration2 != null) {
/* 195 */         DepositCoinsGeneration.c(depositCoinsGeneration1, jsonValue.getFloat("playerCpmMultiplierPerLevel", 0.003F) * depositCoinsGeneration2.power);
/*     */       }
/*     */       
/* 198 */       depositCoinsGeneration1.applyConfig(jsonValue);
/*     */       
/* 200 */       depositCoinsGeneration1.applyConfig(jsonValue);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 209 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(depositCoinsGeneration1, param1Int, param1Array, bonusProviderConfig)) != null)
/* 210 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\DepositCoinsGeneration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */