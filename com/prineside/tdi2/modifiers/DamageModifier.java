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
/*    */ public final class DamageModifier extends Modifier {
/*    */   private DamageModifier() {
/* 17 */     super(ModifierType.DAMAGE);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean connectsToMiners() {
/* 22 */     return false;
/*    */   }
/*    */   
/*    */   public static class DamageModifierFactory
/*    */     extends Modifier.Factory<DamageModifier> {
/*    */     private TextureRegion c;
/*    */     
/*    */     public DamageModifierFactory() {
/* 30 */       super(ModifierType.DAMAGE, MaterialColor.RED.P500, "icon-damage");
/*    */     }
/*    */ 
/*    */     
/*    */     public int getBuildPrice(GameSystemProvider param1GameSystemProvider, int param1Int) {
/* 35 */       return a((int)(100.0F * (float)StrictMath.pow(1.5D, param1Int)));
/*    */     }
/*    */ 
/*    */     
/*    */     public TextureRegion getBaseTexture() {
/* 40 */       return this.c;
/*    */     }
/*    */ 
/*    */     
/*    */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 45 */       float f = MathUtils.round((float)(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.MODIFIER_DAMAGE_VALUE) * 1000.0D)) * 0.1F;
/*    */       
/* 47 */       return Game.i.localeManager.i18n.format("modifier_description_DAMAGE", new Object[] { Float.valueOf(f) });
/*    */     }
/*    */ 
/*    */     
/*    */     public void setupAssets() {
/* 52 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-base-damage");
/*    */     }
/*    */ 
/*    */     
/*    */     public DamageModifier create() {
/* 57 */       return new DamageModifier((byte)0);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\modifiers\DamageModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */