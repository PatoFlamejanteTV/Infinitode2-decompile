/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.RandomXS128;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
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
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class IncreaseSelectedBonusesPower
/*     */   extends GenericGameplayMod
/*     */ {
/*  29 */   private int a = 1;
/*  30 */   private int b = 2;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean c = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  39 */     super.write(paramKryo, paramOutput);
/*  40 */     paramOutput.writeVarInt(this.a, true);
/*  41 */     paramOutput.writeVarInt(this.b, true);
/*  42 */     paramOutput.writeBoolean(this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  47 */     super.read(paramKryo, paramInput);
/*  48 */     this.a = paramInput.readVarInt(true);
/*  49 */     this.b = paramInput.readVarInt(true);
/*  50 */     this.c = paramInput.readBoolean();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  60 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.IncreaseSelectedBonusesPower");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  65 */     if (this.c) {
/*  66 */       return Game.i.localeManager.i18n.format("gmod_descr_increase_selected_bonuses_power", new Object[] { Integer.valueOf(this.a) });
/*     */     }
/*  68 */     return Game.i.localeManager.i18n.format("gmod_descr_increase_selected_bonuses_power_random", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.a) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayMod cpy() {
/*  74 */     IncreaseSelectedBonusesPower increaseSelectedBonusesPower = new IncreaseSelectedBonusesPower();
/*  75 */     a(increaseSelectedBonusesPower);
/*  76 */     increaseSelectedBonusesPower.a = this.a;
/*  77 */     increaseSelectedBonusesPower.b = this.b;
/*  78 */     increaseSelectedBonusesPower.c = this.c;
/*  79 */     return (GameplayMod)increaseSelectedBonusesPower;
/*     */   }
/*     */ 
/*     */   
/*     */   public final IncreaseSelectedBonusesPower applyConfig(JsonValue paramJsonValue) {
/*  84 */     super.applyConfig(paramJsonValue);
/*  85 */     this.a = paramJsonValue.getInt("bonusPower", this.a);
/*  86 */     this.b = paramJsonValue.getInt("maxBonusCount", this.b);
/*  87 */     this.c = paramJsonValue.getBoolean("allActiveBonuses", this.c);
/*  88 */     return this;
/*     */   }
/*     */   
/*     */   public static Array<GameplayModSystem.ActiveMod> getSuitableMods(Array<GameplayModSystem.ActiveMod> paramArray) {
/*  92 */     Array<GameplayModSystem.ActiveMod> array = new Array(true, 1, GameplayModSystem.ActiveMod.class);
/*  93 */     for (byte b = 0; b < paramArray.size; b++) {
/*     */       GameplayModSystem.ActiveMod activeMod;
/*     */       GameplayMod gameplayMod;
/*  96 */       if (!(gameplayMod = (activeMod = (GameplayModSystem.ActiveMod)paramArray.get(b)).getMod() instanceof IncreaseSelectedBonusesPower) && activeMod.getSource().equals("BonusSystem") && !activeMod.getMod().isImmediateAndNotListed() && 
/*  97 */         gameplayMod.getPower() < gameplayMod.getMaxPower()) {
/*  98 */         array.add(activeMod);
/*     */       }
/*     */     } 
/*     */     
/* 102 */     return array;
/*     */   }
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*     */     int i;
/* 107 */     RandomXS128 randomXS128 = paramGameSystemProvider.gameplayMod.getModRandom(6523);
/* 108 */     Array<GameplayModSystem.ActiveMod> array = getSuitableMods((Array<GameplayModSystem.ActiveMod>)paramGameSystemProvider.gameplayMod.getActiveMods());
/*     */     
/* 110 */     if (this.c) {
/* 111 */       for (byte b = 0; b < i; b++) {
/*     */         GameplayMod gameplayMod;
/* 113 */         int j = Math.min((gameplayMod = ((GameplayModSystem.ActiveMod[])array.items)[b].getMod()).getPower() + this.a, gameplayMod.getMaxPower());
/* 114 */         if (gameplayMod.getPower() < j) {
/* 115 */           gameplayMod.setRegisteredPower(j);
/* 116 */           gameplayMod.markPowerLevelUpgradedByOtherMod(j);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 120 */       int j; for (j = 0; j < array.size; j++) {
/* 121 */         array.swap(j, i.nextInt(array.size));
/*     */       }
/* 123 */       j = this.b; int k;
/* 124 */       for (i = 0, k = array.size; i < k && 
/* 125 */         j != 0; i++) {
/*     */         GameplayMod gameplayMod;
/*     */         
/* 128 */         int m = Math.min((gameplayMod = ((GameplayModSystem.ActiveMod[])array.items)[i].getMod()).getPower() + this.a, gameplayMod.getMaxPower());
/* 129 */         if (gameplayMod.getPower() < m) {
/* 130 */           gameplayMod.setRegisteredPower(m);
/* 131 */           gameplayMod.markPowerLevelUpgradedByOtherMod(m);
/* 132 */           j--;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/* 138 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(IncreaseSelectedBonusesPower.class, paramString)) == null)
/*     */     {
/* 140 */       return true;
/*     */     }
/*     */     
/* 143 */     activeMod.getMod().setRegisteredPower(this.power);
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 150 */     return GameplayModCategory.OTHER;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 157 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 160 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 165 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("IncreaseSelectedBonusesPower");
/*     */ 
/*     */       
/*     */       ProbableBonusesProvider.BonusProviderConfig bonusProviderConfig;
/*     */ 
/*     */       
/* 171 */       (bonusProviderConfig = (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setMinStage(3).setProbability(0.5F).setProbabilityMultiplierPerStage(0.9F).applyConfig(jsonValue)).setMinStage(Math.min(2, bonusProviderConfig.minStage));
/*     */       
/*     */       IncreaseSelectedBonusesPower increaseSelectedBonusesPower;
/* 174 */       (increaseSelectedBonusesPower = new IncreaseSelectedBonusesPower()).applyConfig(jsonValue);
/*     */ 
/*     */       
/* 177 */       int i = (IncreaseSelectedBonusesPower.getSuitableMods(param1Array)).size;
/* 178 */       float f2 = jsonValue.getFloat("maxBonusCountPerStage", 0.2F);
/* 179 */       IncreaseSelectedBonusesPower.a(increaseSelectedBonusesPower, IncreaseSelectedBonusesPower.a(increaseSelectedBonusesPower) + MathUtils.floor((param1Int - bonusProviderConfig.getMinStage()) * f2 + 0.01F));
/* 180 */       IncreaseSelectedBonusesPower.a(increaseSelectedBonusesPower, Math.min(IncreaseSelectedBonusesPower.a(increaseSelectedBonusesPower), i));
/* 181 */       if (IncreaseSelectedBonusesPower.a(increaseSelectedBonusesPower) == 0) {
/*     */         return;
/*     */       }
/*     */       
/* 185 */       if (IncreaseSelectedBonusesPower.a(increaseSelectedBonusesPower) == i)
/*     */       {
/* 187 */         IncreaseSelectedBonusesPower.a(increaseSelectedBonusesPower, true);
/*     */       }
/*     */       
/* 190 */       float f1 = jsonValue.getFloat("bonusPowerPerStage", 0.0F);
/* 191 */       IncreaseSelectedBonusesPower.b(increaseSelectedBonusesPower, IncreaseSelectedBonusesPower.b(increaseSelectedBonusesPower) + MathUtils.floor((param1Int - bonusProviderConfig.getMinStage()) * f1 + 0.01F));
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 199 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(increaseSelectedBonusesPower, param1Int, param1Array, bonusProviderConfig)) != null)
/* 200 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\IncreaseSelectedBonusesPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */