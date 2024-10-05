/*    */ package com.prineside.tdi2.modifiers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.GameValueProvider;
/*    */ import com.prineside.tdi2.Modifier;
/*    */ import com.prineside.tdi2.enums.GameValueType;
/*    */ import com.prineside.tdi2.enums.ModifierType;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class AttackSpeedModifier extends Modifier {
/*    */   private AttackSpeedModifier() {
/* 17 */     super(ModifierType.ATTACK_SPEED);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean connectsToMiners() {
/* 22 */     return false;
/*    */   }
/*    */   
/*    */   public static class AttackSpeedModifierFactory
/*    */     extends Modifier.Factory<AttackSpeedModifier> {
/*    */     private TextureRegion c;
/*    */     
/*    */     public AttackSpeedModifierFactory() {
/* 30 */       super(ModifierType.ATTACK_SPEED, MaterialColor.AMBER.P500, "icon-attack-speed");
/*    */     }
/*    */ 
/*    */     
/*    */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 35 */       float f = MathUtils.round((float)(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.MODIFIER_ATTACK_SPEED_VALUE) * 1000.0D)) * 0.1F;
/*    */       
/* 37 */       return Game.i.localeManager.i18n.format("modifier_description_ATTACK_SPEED", new Object[] { Float.valueOf(f) });
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getBaseTexture() {
/* 42 */       return this.c;
/*    */     }
/*    */ 
/*    */     
/*    */     public int getBuildPrice(GameSystemProvider param1GameSystemProvider, int param1Int) {
/* 47 */       return a((int)(100.0F * (float)StrictMath.pow(1.5D, param1Int)));
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 52 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-base-attack-speed");
/*    */     }
/*    */ 
/*    */     
/*    */     public AttackSpeedModifier create() {
/* 57 */       return new AttackSpeedModifier((byte)0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\modifiers\AttackSpeedModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */