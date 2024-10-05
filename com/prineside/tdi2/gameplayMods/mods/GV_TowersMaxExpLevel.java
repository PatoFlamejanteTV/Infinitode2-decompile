/*    */ package com.prineside.tdi2.gameplayMods.mods;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.prineside.tdi2.enums.GameValueType;
/*    */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*    */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*    */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*    */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*    */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*    */ import com.prineside.tdi2.systems.GameplayModSystem;
/*    */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*    */ 
/*    */ @REGS
/*    */ public final class GV_TowersMaxExpLevel
/*    */   extends AbstractGameValueMod
/*    */ {
/*    */   public GV_TowersMaxExpLevel() {
/* 21 */     super(GameValueType.TOWERS_MAX_EXP_LEVEL, 0.0F, 10.0F, true, GameplayModCategory.OFFENSIVE, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public final GameplayMod cpy() {
/* 26 */     GV_TowersMaxExpLevel gV_TowersMaxExpLevel = new GV_TowersMaxExpLevel();
/* 27 */     a(gV_TowersMaxExpLevel);
/* 28 */     return (GameplayMod)gV_TowersMaxExpLevel;
/*    */   }
/*    */   
/*    */   @REGS
/*    */   public static final class BonusProvider
/*    */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*    */     static {
/* 35 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*    */     } private static final BonusProvider a;
/*    */     public static BonusProvider getInstance() {
/* 38 */       return a;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 43 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("GV_TowersMaxExpLevel");
/*    */       
/*    */       GV_TowersMaxExpLevel gV_TowersMaxExpLevel;
/* 46 */       (gV_TowersMaxExpLevel = new GV_TowersMaxExpLevel()).maxPower = 3;
/* 47 */       gV_TowersMaxExpLevel.applyConfig(jsonValue);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       ProbableBonus probableBonus;
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 57 */       if ((probableBonus = ProbableBonusesProvider.addOrModify(gV_TowersMaxExpLevel, param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.5F)).setPowerUpProbabilityMultiplier(0.8F).applyConfig(jsonValue))) != null)
/* 58 */         param1Array1.add(probableBonus); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\GV_TowersMaxExpLevel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */