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
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*     */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*     */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.utils.JsonHandler;
/*     */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*     */ import com.prineside.tdi2.utils.ObjectSupplier;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class GV_AbilitiesEnergy
/*     */   extends AbstractGameValueMod
/*     */ {
/*     */   private int a;
/*     */   private AbilityType b;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  34 */     super.write(paramKryo, paramOutput);
/*  35 */     paramKryo.writeObject(paramOutput, this.b);
/*  36 */     paramOutput.writeVarInt(this.a, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  41 */     super.read(paramKryo, paramInput);
/*  42 */     this.b = (AbilityType)paramKryo.readObject(paramInput, AbilityType.class);
/*  43 */     this.a = paramInput.readVarInt(true);
/*     */   }
/*     */ 
/*     */   
/*     */   private GV_AbilitiesEnergy() {}
/*     */ 
/*     */   
/*     */   public GV_AbilitiesEnergy(AbilityType paramAbilityType, int paramInt, GameValueType paramGameValueType, float paramFloat1, float paramFloat2) {
/*  51 */     super(paramGameValueType, paramFloat1, paramFloat2, true, GameplayModCategory.OFFENSIVE, (GameplayModCategory)null);
/*  52 */     this.b = paramAbilityType;
/*  53 */     this.a = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getId() {
/*  58 */     return getClass().getSimpleName() + "_" + this.b.name();
/*     */   }
/*     */ 
/*     */   
/*     */   public final GameplayMod cpy() {
/*  63 */     GV_AbilitiesEnergy gV_AbilitiesEnergy = new GV_AbilitiesEnergy();
/*  64 */     a(gV_AbilitiesEnergy);
/*  65 */     gV_AbilitiesEnergy.a = this.a;
/*  66 */     gV_AbilitiesEnergy.b = this.b;
/*  67 */     return (GameplayMod)gV_AbilitiesEnergy;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void configure(GameSystemProvider paramGameSystemProvider) {
/*  72 */     this.maxPower = paramGameSystemProvider.gameValue.getIntValue(this.gvType) + this.power - 1 - this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/*  77 */     return (paramGameSystemProvider.ability.abilitiesConfiguration.getSlot(this.b) == -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/*  82 */     if (paramGameSystemProvider.gameValue.getIntValue(this.gvType) > this.a && paramGameSystemProvider.ability.abilitiesConfiguration.getSlot(this.b) != -1) {
/*  83 */       return null;
/*     */     }
/*     */     
/*  86 */     return () -> Game.i.localeManager.i18n.format("gpmod_precondition_gv_abilities_energy", new Object[] { Integer.valueOf(this.a) });
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*     */     private static final BonusProvider a;
/*     */     
/*     */     static {
/*  94 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*     */     }
/*     */     public static BonusProvider getInstance() {
/*  97 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 102 */       JsonValue jsonValue1 = param1BonusStagesConfig.getBonusConfig("GV_AbilitiesEnergy");
/*     */ 
/*     */       
/* 105 */       ProbableBonusesProvider.BonusProviderConfig bonusProviderConfig = (new ProbableBonusesProvider.BonusProviderConfig(0.2F)).applyConfig(jsonValue1);
/*     */ 
/*     */       
/* 108 */       int i = jsonValue1.getInt("minAbilityEnergy", 0);
/* 109 */       JsonValue jsonValue2 = JsonHandler.orEmptyObject(jsonValue1.get("abilities")); AbilityType[] arrayOfAbilityType;
/*     */       int j;
/*     */       byte b;
/* 112 */       for (j = (arrayOfAbilityType = AbilityType.values).length, b = 0; b < j; ) { AbilityType abilityType = arrayOfAbilityType[b];
/* 113 */         JsonValue jsonValue = JsonHandler.orEmptyObject(jsonValue2.get(abilityType.name()));
/*     */         
/* 115 */         GameValueType gameValueType = Game.i.abilityManager.getEnergyCostGameValueType(abilityType);
/* 116 */         int k = jsonValue.getInt("minAbilityEnergy", i);
/*     */         
/* 118 */         ProbableBonusesProvider.BonusProviderConfig bonusProviderConfig1 = bonusProviderConfig.cpy().applyConfig(jsonValue);
/*     */ 
/*     */         
/*     */         GV_AbilitiesEnergy gV_AbilitiesEnergy;
/*     */ 
/*     */         
/*     */         ProbableBonus probableBonus;
/*     */         
/* 126 */         if ((probableBonus = ProbableBonusesProvider.addOrModify((gV_AbilitiesEnergy = new GV_AbilitiesEnergy(abilityType, k, gameValueType, 0.0F, -1.0F)).applyConfig(jsonValue1).applyConfig(jsonValue), param1Int, param1Array, bonusProviderConfig1)) != null)
/* 127 */           param1Array1.add(probableBonus); 
/*     */         b++; }
/*     */     
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\GV_AbilitiesEnergy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */