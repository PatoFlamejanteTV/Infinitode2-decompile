/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.enums.AbilityType;
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
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class MultiplyMdps
/*     */   extends GenericGameplayMod {
/*  28 */   private float a = 2.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  36 */     super.write(paramKryo, paramOutput);
/*  37 */     paramOutput.writeFloat(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  42 */     super.read(paramKryo, paramInput);
/*  43 */     this.a = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  48 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  53 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.MultiplyMdps");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  58 */     String str = StringFormatter.compactNumberWithPrecisionTrimZeros(this.a, 1, true).toString();
/*  59 */     return Game.i.localeManager.i18n.format("gmod_descr_multiply_mdps", new Object[] { str });
/*     */   }
/*     */ 
/*     */   
/*     */   public final MultiplyMdps cpy() {
/*  64 */     MultiplyMdps multiplyMdps = new MultiplyMdps();
/*  65 */     a(multiplyMdps);
/*  66 */     multiplyMdps.a = this.a;
/*  67 */     return multiplyMdps;
/*     */   } public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/*     */     AbilityType[] arrayOfAbilityType;
/*     */     int i;
/*     */     byte b;
/*  72 */     for (i = (arrayOfAbilityType = paramGameSystemProvider.ability.abilitiesConfiguration.slots).length, b = 0; b < i; b++) {
/*  73 */       AbilityType abilityType; if ((abilityType = arrayOfAbilityType[b]) != null) {
/*  74 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/*  83 */     for (byte b = 0; b < paramGameSystemProvider.ability.getAbilitySlotCount(); b++) {
/*  84 */       if (paramGameSystemProvider.ability.getAvailableAbilities(b) > 0) {
/*  85 */         return null;
/*     */       }
/*     */     } 
/*  88 */     return () -> Game.i.localeManager.i18n.get("gpmod_precondition_multiply_mdps_no_abilities");
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/*  93 */     paramGameSystemProvider.damage.setTowersMaxDps(paramGameSystemProvider.damage.getTowersMaxDps() * this.a);
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/*  96 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(MultiplyMdps.class, paramString)) != null) {
/*  97 */       activeMod.getMod().setRegisteredPower(this.power);
/*  98 */       return false;
/*     */     } 
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 106 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final MultiplyMdps applyConfig(JsonValue paramJsonValue) {
/* 111 */     super.applyConfig(paramJsonValue);
/* 112 */     this.a = paramJsonValue.getFloat("mdpsMultiplier", this.a);
/* 113 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*     */     
/*     */     static {
/* 120 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/* 123 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 128 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("MultiplyMdps");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/* 137 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new MultiplyMdps()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.2F).applyConfig(jsonValue))) != null)
/* 138 */         param1Array1.add(probableBonus); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\MultiplyMdps.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */