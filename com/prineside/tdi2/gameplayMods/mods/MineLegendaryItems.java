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
/*    */ import com.prineside.tdi2.tiles.SourceTile;
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
/*    */ public final class MineLegendaryItems
/*    */   extends GenericGameplayMod
/*    */ {
/*    */   public final Drawable getIcon() {
/* 30 */     return (Drawable)Game.i.assetManager.getQuad("gpMods.MineLegendaryItems");
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/* 35 */     return ((paramGameSystemProvider.map.getMap().getTilesByType(SourceTile.class)).size == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public final CharSequence getDescription() {
/* 40 */     return Game.i.localeManager.i18n.format("gmod_descr_mine_legendary_items", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public final MineLegendaryItems cpy() {
/* 45 */     MineLegendaryItems mineLegendaryItems = new MineLegendaryItems();
/* 46 */     a(mineLegendaryItems);
/* 47 */     return mineLegendaryItems;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean register(GameSystemProvider paramGameSystemProvider, String paramString) {
/* 52 */     paramGameSystemProvider.loot.minersMineOnlyLegendaries = true;
/* 53 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final GameplayModCategory getCategory() {
/* 58 */     return GameplayModCategory.LOOTING;
/*    */   }
/*    */ 
/*    */   
/*    */   public final MineLegendaryItems applyConfig(JsonValue paramJsonValue) {
/* 63 */     super.applyConfig(paramJsonValue);
/* 64 */     return this;
/*    */   }
/*    */   
/*    */   @REGS
/*    */   public static final class BonusProvider
/*    */     implements ProbableBonusesProvider, NoFieldKryoSerializable {
/*    */     static {
/* 71 */       SyncChecker.addSyncShareableObject(a = new BonusProvider());
/*    */     } private static final BonusProvider a;
/*    */     public static BonusProvider getInstance() {
/* 74 */       return a;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void provide(int param1Int, BonusStagesConfig param1BonusStagesConfig, Array<GameplayModSystem.ActiveMod> param1Array, Array<ProbableBonus> param1Array1) {
/* 79 */       for (byte b = 0; b < param1Array.size; b++) {
/* 80 */         if (((GameplayModSystem.ActiveMod)param1Array.get(b)).getMod() instanceof MineLegendaryItems) {
/*    */           return;
/*    */         }
/*    */       } 
/*    */       
/* 85 */       JsonValue jsonValue = param1BonusStagesConfig.getBonusConfig("MineLegendaryItems");
/*    */ 
/*    */ 
/*    */       
/*    */       ProbableBonus probableBonus;
/*    */ 
/*    */       
/* 92 */       if ((probableBonus = ProbableBonusesProvider.addOrModify((new MineLegendaryItems()).applyConfig(jsonValue), param1Int, param1Array, (new ProbableBonusesProvider.BonusProviderConfig(0.2F)).applyConfig(jsonValue))) != null)
/* 93 */         param1Array1.add(probableBonus); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\mods\MineLegendaryItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */