/*    */ package com.prineside.tdi2.gameplayMods.mods;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.enums.AbilityType;
/*    */ import com.prineside.tdi2.enums.GameValueType;
/*    */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*    */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*    */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*    */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*    */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*    */ import com.prineside.tdi2.systems.GameplayModSystem;
/*    */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*    */ import com.prineside.tdi2.utils.ObjectSupplier;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*    */ 
/*    */ @REGS
/*    */ public final class GV_AbilitiesMaxEnergy
/*    */   extends AbstractGameValueMod
/*    */ {
/*    */   public GV_AbilitiesMaxEnergy() {
/* 25 */     super(GameValueType.ABILITIES_MAX_ENERGY, 1.0F, 2.0F, true, GameplayModCategory.OFFENSIVE, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public final GameplayMod cpy() {
/* 30 */     GV_AbilitiesMaxEnergy gV_AbilitiesMaxEnergy = new GV_AbilitiesMaxEnergy();
/* 31 */     a(gV_AbilitiesMaxEnergy);
/* 32 */     return (GameplayMod)gV_AbilitiesMaxEnergy;
/*    */   }
/*    */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/*    */     AbilityType[] arrayOfAbilityType;
/*    */     int i;
/*    */     byte b;
/* 38 */     for (i = (arrayOfAbilityType = paramGameSystemProvider.ability.abilitiesConfiguration.slots).length, b = 0; b < i; b++) {
/* 39 */       AbilityType abilityType; if ((abilityType = arrayOfAbilityType[b]) != null) {
/* 40 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 44 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 49 */     for (byte b = 0; b < paramGameSystemProvider.ability.abilitiesConfiguration.slots.length; b++) {
/*    */       AbilityType abilityType;
/* 51 */       if ((abilityType = paramGameSystemProvider.ability.abilitiesConfiguration.slots[b]) != null) {
/* 52 */         return null;
/*    */       }
/*    */     } 
/* 55 */     return () -> Game.i.localeManager.i18n.get("gpmod_precondition_no_abilities_selected");
/*    */   }
/*    */   
/*    */   @REGS
/*    */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable { private static final BonusProvider a;
/*    */     
/*    */     static {
/* 62 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*    */     }
/*    */     public static BonusProvider getInstance() {
/* 65 */       return a;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 70 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("GV_AbilitiesMaxEnergy");
/*    */       
/*    */       GV_AbilitiesMaxEnergy gV_AbilitiesMaxEnergy;
/* 73 */       (gV_AbilitiesMaxEnergy = new GV_AbilitiesMaxEnergy()).maxPower = 3;
/* 74 */       gV_AbilitiesMaxEnergy.applyConfig(jsonValue);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       ProbableBonus probableBonus;
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 84 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(gV_AbilitiesMaxEnergy, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.5F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 85 */         param1Array1.add(probableBonus); 
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\GV_AbilitiesMaxEnergy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */