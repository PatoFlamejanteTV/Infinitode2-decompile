/*    */ package com.prineside.tdi2.gameplayMods.mods;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.enums.GameValueType;
/*    */ import com.prineside.tdi2.enums.ModifierType;
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
/*    */ public final class GV_DisableBountyModifierHarm
/*    */   extends AbstractGameValueMod
/*    */ {
/*    */   public GV_DisableBountyModifierHarm() {
/* 25 */     super(GameValueType.MODIFIER_BOUNTY_NO_HARM_TO_TOWERS, 0.0F, 1.0F, true, GameplayModCategory.ECONOMICS, (GameplayModCategory)null);
/*    */   }
/*    */ 
/*    */   
/*    */   public final GameplayMod cpy() {
/* 30 */     GV_DisableBountyModifierHarm gV_DisableBountyModifierHarm = new GV_DisableBountyModifierHarm();
/* 31 */     a(gV_DisableBountyModifierHarm);
/* 32 */     return (GameplayMod)gV_DisableBountyModifierHarm;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/* 37 */     return (paramGameSystemProvider.modifier.getMaxModifiersCount(ModifierType.BOUNTY) == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 42 */     if (paramGameSystemProvider.modifier.getMaxModifiersCount(ModifierType.BOUNTY) == 0 || paramGameSystemProvider.gameValue.getBooleanValue(GameValueType.MODIFIER_BOUNTY_NO_HARM_TO_TOWERS))
/* 43 */       return () -> {
/*    */           String str = null;
/*    */           if (paramGameSystemProvider.modifier.getMaxModifiersCount(ModifierType.BOUNTY) == 0) {
/*    */             str = Game.i.localeManager.i18n.get("gpmod_precondition_no_modifier");
/*    */           }
/*    */           if (paramGameSystemProvider.gameValue.getBooleanValue(GameValueType.MODIFIER_BOUNTY_NO_HARM_TO_TOWERS)) {
/*    */             if (str == null) {
/*    */               str = "";
/*    */             }
/*    */             str = str + "\n" + Game.i.localeManager.i18n.get("gpmod_precondition_effect_already_enabled");
/*    */           } 
/*    */           return str;
/*    */         }; 
/* 56 */     return null;
/*    */   }
/*    */   
/*    */   @REGS
/*    */   public static final class BonusProvider implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*    */     private static final BonusProvider a;
/*    */     
/*    */     static {
/* 64 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*    */     }
/*    */     public static BonusProvider getInstance() {
/* 67 */       return a;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 72 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("GV_DisableBountyModifierHarm");
/*    */       
/*    */       GV_DisableBountyModifierHarm gV_DisableBountyModifierHarm;
/* 75 */       (gV_DisableBountyModifierHarm = new GV_DisableBountyModifierHarm()).multipleInstances = false;
/* 76 */       gV_DisableBountyModifierHarm.maxPower = 1;
/* 77 */       gV_DisableBountyModifierHarm.applyConfig(jsonValue);
/*    */ 
/*    */ 
/*    */       
/*    */       ProbableBonus probableBonus;
/*    */ 
/*    */ 
/*    */       
/* 85 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(gV_DisableBountyModifierHarm, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.6F)).applyConfig(jsonValue))) != null)
/* 86 */         param1Array1.add(probableBonus); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\GV_DisableBountyModifierHarm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */