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
/*    */ public final class GV_BountiesNearby
/*    */   extends AbstractGameValueMod
/*    */ {
/*    */   public GV_BountiesNearby() {
/* 25 */     super(GameValueType.MODIFIER_BOUNTY_NEIGHBORING, 0.0F, 1.0F, true, GameplayModCategory.ECONOMICS, (GameplayModCategory)null);
/*    */   }
/*    */ 
/*    */   
/*    */   public final GameplayMod cpy() {
/* 30 */     GV_BountiesNearby gV_BountiesNearby = new GV_BountiesNearby();
/* 31 */     a(gV_BountiesNearby);
/* 32 */     return (GameplayMod)gV_BountiesNearby;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/* 37 */     return (paramGameSystemProvider.modifier.getMaxModifiersCount(ModifierType.BOUNTY) == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public final ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 42 */     if (paramGameSystemProvider.modifier.getMaxModifiersCount(ModifierType.BOUNTY) == 0 || paramGameSystemProvider.gameValue.getBooleanValue(GameValueType.MODIFIER_BOUNTY_NEIGHBORING))
/* 43 */       return () -> {
/*    */           String str = null;
/*    */           if (paramGameSystemProvider.modifier.getMaxModifiersCount(ModifierType.BOUNTY) == 0) {
/*    */             str = Game.i.localeManager.i18n.get("gpmod_precondition_no_modifier");
/*    */           }
/*    */           if (paramGameSystemProvider.gameValue.getBooleanValue(GameValueType.MODIFIER_BOUNTY_NEIGHBORING)) {
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
/* 72 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("GV_BountiesNearby");
/*    */       
/*    */       GV_BountiesNearby gV_BountiesNearby;
/* 75 */       (gV_BountiesNearby = new GV_BountiesNearby()).multipleInstances = false;
/* 76 */       gV_BountiesNearby.maxPower = 1;
/* 77 */       gV_BountiesNearby.applyConfig(jsonValue);
/*    */ 
/*    */ 
/*    */       
/*    */       ProbableBonus probableBonus;
/*    */ 
/*    */ 
/*    */       
/* 85 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(gV_BountiesNearby, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.6F)).applyConfig(jsonValue))) != null)
/* 86 */         param1Array1.add(probableBonus); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\GV_BountiesNearby.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */