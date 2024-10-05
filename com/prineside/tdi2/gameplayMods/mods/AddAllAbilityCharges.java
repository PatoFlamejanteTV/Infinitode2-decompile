/*     */ package com.prineside.tdi2.gameplayMods.mods;
/*     */ 
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
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS
/*     */ public final class AddAllAbilityCharges
/*     */   extends GenericGameplayMod {
/*  26 */   private int a = 5;
/*  27 */   private int b = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  35 */     super.write(paramKryo, paramOutput);
/*  36 */     paramOutput.writeInt(this.a);
/*  37 */     paramOutput.writeInt(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  42 */     super.read(paramKryo, paramInput);
/*  43 */     this.a = paramInput.readInt();
/*  44 */     this.b = paramInput.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isImmediateAndNotListed() {
/*  49 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Drawable getIcon() {
/*  54 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.AddAllAbilityCharges");
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence getDescription() {
/*  59 */     return Game.i.localeManager.i18n.format("gmod_descr_add_ability_charges", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.a) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final AddAllAbilityCharges cpy() {
/*  64 */     AddAllAbilityCharges addAllAbilityCharges = new AddAllAbilityCharges();
/*  65 */     a(addAllAbilityCharges);
/*  66 */     addAllAbilityCharges.a = this.a;
/*  67 */     addAllAbilityCharges.b = this.b;
/*  68 */     return addAllAbilityCharges;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/*  73 */     for (byte b = 0; b < paramGameSystemProvider.ability.getAbilitySlotCount(); b++) {
/*  74 */       if (paramGameSystemProvider.ability.abilitiesConfiguration.slots[b] != null)
/*     */       {
/*  76 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  81 */     return true;
/*     */   }
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/*     */     int i;
/*  86 */     for (i = 0; i < paramGameSystemProvider.ability.getAbilitySlotCount(); i++) {
/*  87 */       if (paramGameSystemProvider.ability.abilitiesConfiguration.slots[i] != null && 
/*  88 */         paramGameSystemProvider.ability.getAvailableAbilities(i) < this.a) {
/*  89 */         return null;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  95 */     return () -> Game.i.localeManager.i18n.format("gpmod_precondition_add_all_ability_charges", new Object[] { Integer.valueOf(paramInt) });
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 100 */     for (byte b = 0; b < paramGameSystemProvider.ability.getAbilitySlotCount(); b++) {
/* 101 */       if (paramGameSystemProvider.ability.abilitiesConfiguration.slots[b] != null && 
/* 102 */         paramGameSystemProvider.ability.getAvailableAbilities(b) < this.a) {
/* 103 */         paramGameSystemProvider.ability.addAbilityCharges(b, this.b);
/*     */       }
/*     */     } 
/*     */     
/*     */     GameplayModSystem.ActiveMod activeMod;
/*     */     
/* 109 */     if ((activeMod = paramGameSystemProvider.gameplayMod.getActiveModFromSource(AddAllAbilityCharges.class, paramString)) != null) {
/* 110 */       activeMod.getMod().setRegisteredPower(this.power);
/* 111 */       return false;
/*     */     } 
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final GameplayModCategory getCategory() {
/* 119 */     return GameplayModCategory.OFFENSIVE;
/*     */   }
/*     */ 
/*     */   
/*     */   public final AddAllAbilityCharges applyConfig(JsonValue paramJsonValue) {
/* 124 */     super.applyConfig(paramJsonValue);
/* 125 */     this.a = paramJsonValue.getInt("maxCurrentCharges", this.a);
/* 126 */     if (this.a <= 0) this.a = 1;
/*     */     
/* 128 */     this.b = paramJsonValue.getInt("chargeCount", this.b);
/* 129 */     return this;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider
/*     */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     static {
/* 136 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     } private static final BonusProvider a;
/*     */     public static BonusProvider getInstance() {
/* 139 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 144 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("AddAllAbilityCharges");
/*     */ 
/*     */ 
/*     */       
/*     */       ProbableBonus probableBonus;
/*     */ 
/*     */ 
/*     */       
/*     */       AddAllAbilityCharges addAllAbilityCharges;
/*     */ 
/*     */       
/* 155 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(addAllAbilityCharges = (new AddAllAbilityCharges()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(1.0F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 156 */         param1Array1.add(probableBonus); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\AddAllAbilityCharges.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */