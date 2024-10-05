/*     */ package com.prineside.tdi2.modifiers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class MiningSpeedModifier
/*     */   extends Modifier {
/*  25 */   private static final TLog a = TLog.forClass(MiningSpeedModifier.class);
/*     */   
/*     */   private MiningSpeedModifier() {
/*  28 */     super(ModifierType.MINING_SPEED);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillModifierMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/*  33 */     if (paramObjectMap.size == 0 || paramObjectMap.get("modifier_menu_hint", null) == null) {
/*  34 */       int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */       
/*  36 */       paramGroup.clear();
/*     */       
/*     */       Table table2;
/*  39 */       (table2 = new Table()).setPosition(40.0F, 80.0F);
/*  40 */       table2.setSize(520.0F, (i + 600));
/*  41 */       paramGroup.addActor((Actor)table2);
/*     */       
/*     */       Label label;
/*  44 */       (label = new Label(Game.i.localeManager.i18n.get("mining_speed_mods_tooltip"), Game.i.assetManager.getLabelStyle(24))).setWrap(true);
/*  45 */       table2.add((Actor)label).width(520.0F).row();
/*     */       
/*  47 */       Table table1 = createEfficiencyTable(this.S, -1);
/*  48 */       table2.add((Actor)table1).width(520.0F).padTop(8.0F).row();
/*     */       
/*  50 */       table2.add().width(1.0F).growY();
/*     */       
/*  52 */       a.i("recreate custom menu", new Object[0]);
/*  53 */       paramObjectMap.put("modifier_menu_hint", label);
/*  54 */       paramObjectMap.put("modifier_menu_table", table1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Table createEfficiencyTable(GameSystemProvider paramGameSystemProvider, int paramInt) {
/*     */     Label.LabelStyle labelStyle;
/*  60 */     (labelStyle = new Label.LabelStyle(Game.i.assetManager.getLabelStyle(18))).background = Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/*  61 */     labelStyle.background.setLeftWidth(5.0F);
/*  62 */     labelStyle.background.setRightWidth(5.0F);
/*  63 */     labelStyle.background.setTopHeight(2.0F);
/*  64 */     labelStyle.background.setBottomHeight(2.0F);
/*     */     
/*  66 */     Table table = new Table();
/*  67 */     for (byte b1 = 1; b1 <= 8; b1++) {
/*  68 */       Label label = new Label(String.valueOf(b1), labelStyle);
/*  69 */       if (b1 <= paramInt) {
/*  70 */         label.setColor(MaterialColor.LIGHT_GREEN.P400);
/*     */       }
/*  72 */       label.setAlignment(1);
/*  73 */       table.add((Actor)label).growX().padLeft(1.0F).padRight(1.0F);
/*     */     } 
/*  75 */     table.row();
/*     */     
/*  77 */     float f = 0.0F;
/*  78 */     for (byte b2 = 1; b2 <= 8; b2++) {
/*     */       
/*  80 */       float f1, f2 = (f1 = paramGameSystemProvider.miner.getMiningSpeedModifierEfficiencyPerCount(b2)) - f;
/*  81 */       f = f1;
/*     */       
/*  83 */       Label label = new Label((CharSequence)StringFormatter.compactNumber((f2 * 100.0F), false).append("%"), labelStyle);
/*  84 */       if (b2 <= paramInt) {
/*  85 */         label.setColor(MaterialColor.LIGHT_GREEN.P400);
/*     */       }
/*  87 */       label.setAlignment(1);
/*  88 */       table.add((Actor)label).growX().padLeft(1.0F).padRight(1.0F).padTop(2.0F);
/*     */     } 
/*     */     
/*  91 */     return table;
/*     */   }
/*     */   
/*     */   public static class MiningSpeedModifierFactory extends Modifier.Factory<MiningSpeedModifier> {
/*     */     private TextureRegion c;
/*     */     
/*     */     public MiningSpeedModifierFactory() {
/*  98 */       super(ModifierType.MINING_SPEED, MaterialColor.TEAL.P500, "icon-pickaxe");
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getBaseTexture() {
/* 103 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 108 */       float f = MathUtils.round((float)(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.MODIFIER_MINING_SPEED_VALUE) * 1000.0D)) * 0.1F;
/*     */       
/* 110 */       return Game.i.localeManager.i18n.format("modifier_description_MINING_SPEED", new Object[] { Float.valueOf(f) });
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildPrice(GameSystemProvider param1GameSystemProvider, int param1Int) {
/* 115 */       return a((int)(120.0F * (float)StrictMath.pow(1.600000023841858D, param1Int * 1.05D)));
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 120 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-base-mining-speed");
/*     */     }
/*     */ 
/*     */     
/*     */     public MiningSpeedModifier create() {
/* 125 */       return new MiningSpeedModifier((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\modifiers\MiningSpeedModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */