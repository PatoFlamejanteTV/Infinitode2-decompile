/*    */ package com.prineside.tdi2.gameplayMods.mods;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*    */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*    */ import com.prineside.tdi2.gameplayMods.GameplayModCategory;
/*    */ import com.prineside.tdi2.gameplayMods.GenericGameplayMod;
/*    */ import com.prineside.tdi2.gameplayMods.ProbableBonus;
/*    */ import com.prineside.tdi2.gameplayMods.ProbableBonusesProvider;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.systems.GameplayModSystem;
/*    */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS
/*    */ public final class MoreBonusVariantsNextTime
/*    */   extends GenericGameplayMod
/*    */ {
/*    */   public final Drawable getIcon() {
/* 29 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.MoreBonusVariantsNextTime");
/*    */   }
/*    */ 
/*    */   
/*    */   public final CharSequence getDescription() {
/* 34 */     return Game.i.localeManager.i18n.format("gmod_descr_more_bonus_variants_next_time", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public final MoreBonusVariantsNextTime cpy() {
/* 39 */     MoreBonusVariantsNextTime moreBonusVariantsNextTime = new MoreBonusVariantsNextTime();
/* 40 */     a(moreBonusVariantsNextTime);
/* 41 */     return moreBonusVariantsNextTime;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 46 */     paramGameSystemProvider.bonus.additionalBonusToSelectFrom = true;
/* 47 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final GameplayModCategory getCategory() {
/* 52 */     return GameplayModCategory.OTHER;
/*    */   }
/*    */ 
/*    */   
/*    */   public final MoreBonusVariantsNextTime applyConfig(JsonValue paramJsonValue) {
/* 57 */     super.applyConfig(paramJsonValue);
/* 58 */     return this;
/*    */   }
/*    */   
/*    */   @REGS
/*    */   public static final class BonusProvider
/*    */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*    */     static {
/* 65 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*    */     } private static final BonusProvider a;
/*    */     public static BonusProvider getInstance() {
/* 68 */       return a;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 73 */       for (byte b = 0; b < param1Array.size; b++) {
/* 74 */         if (((GameplayModSystem.ActiveMod)param1Array.get(b)).getMod() instanceof MoreBonusVariantsNextTime) {
/*    */           return;
/*    */         }
/*    */       } 
/*    */       
/* 79 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("MoreBonusVariantsNextTime");
/*    */ 
/*    */ 
/*    */       
/*    */       ProbableBonus probableBonus;
/*    */ 
/*    */       
/* 86 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new MoreBonusVariantsNextTime()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.2F)).applyConfig(jsonValue))) != null)
/* 87 */         param1Array1.add(probableBonus); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\MoreBonusVariantsNextTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */