/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.math.MathUtils;
/*    */ import com.badlogic.gdx.utils.StringBuilder;
/*    */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*    */ import com.prineside.tdi2.enums.TowerStatType;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.StringFormatter;
/*    */ 
/*    */ public class SpaceTileBonus
/*    */ {
/*    */   public static final int MAX_LEVEL = 5;
/*    */   
/*    */   static {
/* 16 */     (c = new SpaceTileBonusConfig[SpaceTileBonusType.values.length])[SpaceTileBonusType.RANGE.ordinal()] = new SpaceTileBonusConfig(SpaceTileBonusType.RANGE, "icon-range", new float[] { 1.1F, 1.2F, 1.3F, 1.4F, 1.5F }, MaterialColor.GREEN.P500, MaterialColor.GREEN.P300);
/* 17 */     c[SpaceTileBonusType.DAMAGE.ordinal()] = new SpaceTileBonusConfig(SpaceTileBonusType.DAMAGE, "icon-damage", new float[] { 1.15F, 1.3F, 1.5F, 1.7F, 2.0F }, MaterialColor.RED.P500, MaterialColor.RED.P300);
/* 18 */     c[SpaceTileBonusType.ATTACK_SPEED.ordinal()] = new SpaceTileBonusConfig(SpaceTileBonusType.ATTACK_SPEED, "icon-attack-speed", new float[] { 1.15F, 1.3F, 1.5F, 1.7F, 2.0F }, MaterialColor.ORANGE.P500, MaterialColor.ORANGE.P300);
/* 19 */     c[SpaceTileBonusType.ROTATION_SPEED.ordinal()] = new SpaceTileBonusConfig(SpaceTileBonusType.ROTATION_SPEED, "icon-rotation-speed", new float[] { 1.3F, 1.6F, 2.0F, 2.4F, 3.0F }, MaterialColor.PURPLE.P500, MaterialColor.PURPLE.P300);
/* 20 */     c[SpaceTileBonusType.PROJECTILE_SPEED.ordinal()] = new SpaceTileBonusConfig(SpaceTileBonusType.PROJECTILE_SPEED, "icon-projectile-speed", new float[] { 1.3F, 1.6F, 2.0F, 2.4F, 3.0F }, MaterialColor.DEEP_PURPLE.P500, MaterialColor.DEEP_PURPLE.P300);
/* 21 */     c[SpaceTileBonusType.BONUS_EXPERIENCE.ordinal()] = new SpaceTileBonusConfig(SpaceTileBonusType.BONUS_EXPERIENCE, "icon-experience-plus", new float[] { 1.15F, 1.3F, 1.5F, 1.7F, 2.0F }, MaterialColor.CYAN.P500, MaterialColor.CYAN.P300);
/* 22 */     c[SpaceTileBonusType.BONUS_COINS.ordinal()] = new SpaceTileBonusConfig(SpaceTileBonusType.BONUS_COINS, "icon-coins", new float[] { 1.1F, 1.2F, 1.3F, 1.4F, 1.5F }, MaterialColor.YELLOW.P500, MaterialColor.YELLOW.P300);
/* 23 */     c[SpaceTileBonusType.UPGRADE_DISCOUNT.ordinal()] = new SpaceTileBonusConfig(SpaceTileBonusType.UPGRADE_DISCOUNT, "icon-upgrade-money", new float[] { 0.98F, 0.96F, 0.94F, 0.92F, 0.9F }, MaterialColor.TEAL.P500, MaterialColor.TEAL.P300);
/* 24 */     c[SpaceTileBonusType.SELL_REFUND.ordinal()] = new SpaceTileBonusConfig(SpaceTileBonusType.SELL_REFUND, "icon-sell-refund", new float[] { 0.8F, 0.85F, 0.9F, 0.95F, 0.99F }, MaterialColor.INDIGO.P500, MaterialColor.INDIGO.P300);
/* 25 */     c[SpaceTileBonusType.PWR_MULTIPLIER.ordinal()] = new SpaceTileBonusConfig(SpaceTileBonusType.PWR_MULTIPLIER, "icon-power-plus", new float[] { 1.05F, 1.1F, 1.15F, 1.2F, 1.25F }, MaterialColor.PINK.P500, MaterialColor.PINK.P300);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 30 */     (a = new SpaceTileBonusType[TowerStatType.values.length])[TowerStatType.RANGE.ordinal()] = SpaceTileBonusType.RANGE;
/* 31 */     a[TowerStatType.DAMAGE.ordinal()] = SpaceTileBonusType.DAMAGE;
/* 32 */     a[TowerStatType.ATTACK_SPEED.ordinal()] = SpaceTileBonusType.ATTACK_SPEED;
/* 33 */     a[TowerStatType.ROTATION_SPEED.ordinal()] = SpaceTileBonusType.ROTATION_SPEED;
/* 34 */     a[TowerStatType.PROJECTILE_SPEED.ordinal()] = SpaceTileBonusType.PROJECTILE_SPEED;
/*    */   }
/*    */   private static final SpaceTileBonusConfig[] c; static final SpaceTileBonusType[] a;
/* 37 */   static final TowerStatType[] b = new TowerStatType[TowerStatType.values.length];
/*    */   static {
/* 39 */     for (byte b = 0; b < TowerStatType.values.length; b++) {
/* 40 */       if (a[b] != null) {
/* 41 */         TowerStatType towerStatType = TowerStatType.values[b];
/* 42 */         b[a[b].ordinal()] = towerStatType;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/* 47 */   private static final StringBuilder d = new StringBuilder();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static float getEffect(SpaceTileBonusType paramSpaceTileBonusType, int paramInt) {
/* 53 */     if (paramInt == 0) throw new IllegalArgumentException("level is 0 for " + paramSpaceTileBonusType); 
/* 54 */     if (paramInt <= 0 || paramInt > 5) throw new IllegalArgumentException("Max space tile bonus level is 5, " + paramInt + " given");
/*    */     
/* 56 */     return (c[paramSpaceTileBonusType.ordinal()]).a[paramInt - 1];
/*    */   }
/*    */   
/*    */   public static Color getColor(SpaceTileBonusType paramSpaceTileBonusType) {
/* 60 */     return (c[paramSpaceTileBonusType.ordinal()]).d;
/*    */   }
/*    */   
/*    */   public static Color getBrightColor(SpaceTileBonusType paramSpaceTileBonusType) {
/* 64 */     return (c[paramSpaceTileBonusType.ordinal()]).e;
/*    */   }
/*    */   
/*    */   public static String getIconName(SpaceTileBonusType paramSpaceTileBonusType) {
/* 68 */     return (c[paramSpaceTileBonusType.ordinal()]).c;
/*    */   }
/*    */   
/*    */   public static StringBuilder getDetailedName(SpaceTileBonusType paramSpaceTileBonusType, int paramInt) {
/* 72 */     d.setLength(0);
/* 73 */     int i = paramSpaceTileBonusType.ordinal();
/* 74 */     d.append(Game.i.localeManager.i18n.get((c[i]).b));
/*    */     
/* 76 */     if (paramInt > 0) d.append(" ").append(StringFormatter.romanNumber(paramInt)); 
/* 77 */     d.append(" (").append(MathUtils.round(getEffect(paramSpaceTileBonusType, paramInt) * 100.0F)).append("%)");
/*    */     
/* 79 */     return d;
/*    */   }
/*    */   
/*    */   public static class SpaceTileBonusConfig {
/*    */     final float[] a;
/*    */     final String b;
/*    */     final String c;
/*    */     final Color d;
/*    */     final Color e;
/*    */     
/*    */     SpaceTileBonusConfig(SpaceTileBonusType param1SpaceTileBonusType, String param1String, float[] param1ArrayOffloat, Color param1Color1, Color param1Color2) {
/* 90 */       this.b = "space_tile_bonus_" + param1SpaceTileBonusType.name();
/* 91 */       this.c = param1String;
/* 92 */       this.a = param1ArrayOffloat;
/* 93 */       this.d = param1Color1;
/* 94 */       this.e = param1Color2;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\SpaceTileBonus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */