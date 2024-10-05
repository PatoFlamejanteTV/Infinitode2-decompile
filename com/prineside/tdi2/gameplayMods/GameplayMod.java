/*    */ package com.prineside.tdi2.gameplayMods;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.utils.ObjectSupplier;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public interface GameplayMod
/*    */ {
/*    */   String getId();
/*    */   
/*    */   Drawable getIcon();
/*    */   
/*    */   CharSequence getDescription();
/*    */   
/*    */   GameplayMod cpy();
/*    */   
/*    */   @Null
/*    */   default ObjectSupplier<CharSequence> getNotSatisfiedPreconditions(GameSystemProvider paramGameSystemProvider) {
/* 23 */     return null;
/*    */   }
/*    */   default boolean isImmediateAndNotListed() {
/* 26 */     return false;
/*    */   }
/*    */   default boolean isAlwaysUseless(GameSystemProvider paramGameSystemProvider) {
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   default boolean allowsMultipleInstancesFromDifferentSources() {
/* 35 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default int getPower() {
/* 42 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default int getMaxPower() {
/* 49 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   default void setRegisteredPower(int paramInt) {}
/*    */ 
/*    */ 
/*    */   
/*    */   void markPowerLevelUpgradedByOtherMod(int paramInt);
/*    */ 
/*    */ 
/*    */   
/*    */   boolean isPowerLevelUpgradedByOtherMod(int paramInt);
/*    */ 
/*    */ 
/*    */   
/*    */   void setReplacesUnsatisfiedMod(GameplayMod paramGameplayMod);
/*    */ 
/*    */ 
/*    */   
/*    */   @Null
/*    */   GameplayMod getReplacesUnsatisfiedMod();
/*    */ 
/*    */ 
/*    */   
/*    */   default void configure(GameSystemProvider paramGameSystemProvider) {}
/*    */ 
/*    */ 
/*    */   
/*    */   boolean register(GameSystemProvider paramGameSystemProvider, String paramString);
/*    */ 
/*    */   
/*    */   GameplayModCategory getCategory();
/*    */ 
/*    */   
/*    */   @Null
/*    */   default GameplayModCategory getAdditionalCategory() {
/* 87 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\gameplayMods\GameplayMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */