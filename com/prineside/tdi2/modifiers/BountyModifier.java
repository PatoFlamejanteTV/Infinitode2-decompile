/*     */ package com.prineside.tdi2.modifiers;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.ModifierProcessor;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.modifiers.processors.BountyModifierProcessor;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class BountyModifier extends Modifier {
/*  34 */   private static final TLog a = TLog.forClass(BountyModifier.class);
/*     */   
/*     */   public static final float ABILITY_BOOST_MULTIPLIER = 1.3F;
/*     */   
/*  38 */   private static final StringBuilder b = new StringBuilder();
/*     */   
/*     */   public boolean boostedByAbility;
/*     */   
/*     */   public int coinsGained;
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect c;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  47 */     super.write(paramKryo, paramOutput);
/*     */     
/*  49 */     paramOutput.writeBoolean(this.boostedByAbility);
/*  50 */     paramOutput.writeVarInt(this.coinsGained, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  55 */     super.read(paramKryo, paramInput);
/*     */     
/*  57 */     this.boostedByAbility = paramInput.readBoolean();
/*  58 */     this.coinsGained = paramInput.readVarInt(true);
/*     */   }
/*     */   
/*     */   private BountyModifier() {
/*  62 */     super(ModifierType.BOUNTY);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean connectsToMiners() {
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat, MapRenderingSystem.DrawMode paramDrawMode) {
/*  72 */     super.drawBatch(paramBatch, paramFloat, paramDrawMode);
/*     */     
/*  74 */     if (this.boostedByAbility) {
/*  75 */       if (this.c == null && 
/*  76 */         this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*  77 */         this.c = (ParticleEffectPool.PooledEffect)Game.i.assetManager.getParticleEffectPool("bounty-modifier-boost.prt").obtain();
/*  78 */         this.c.setPosition((getTile()).center.x, (getTile()).center.y);
/*  79 */         this.S._particle.addParticle((ParticleEffect)this.c, false);
/*     */         
/*     */         return;
/*     */       } 
/*  83 */     } else if (this.c != null) {
/*  84 */       this.c.allowCompletion();
/*  85 */       this.c = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void removedFromMap() {
/*  92 */     super.removedFromMap();
/*  93 */     if (this.c != null) {
/*  94 */       this.c.allowCompletion();
/*  95 */       this.c = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillModifierMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/* 101 */     int k = 1;
/* 102 */     if (this.boostedByAbility) {
/* 103 */       k = 32;
/*     */     }
/*     */     
/* 106 */     int m = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*     */     
/* 108 */     if (paramObjectMap.size == 0 || !paramObjectMap.get("state", Integer.valueOf(-1)).equals(Integer.valueOf(k))) {
/* 109 */       a.i("recreate custom menu", new Object[0]);
/* 110 */       paramGroup.clear();
/*     */       
/*     */       Group group;
/* 113 */       (group = new Group()).setTransform(false);
/* 114 */       group.setPosition(0.0F, 606.0F + m);
/* 115 */       group.setSize(600.0F, 48.0F);
/* 116 */       paramGroup.addActor((Actor)group);
/*     */       
/*     */       Image image;
/* 119 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 48.0F);
/* 120 */       image.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 121 */       group.addActor((Actor)image);
/*     */       
/*     */       Label label3;
/* 124 */       (label3 = new Label(Game.i.localeManager.i18n.get("statistics_CG_PG"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(100.0F, 48.0F);
/* 125 */       label3.setPosition(40.0F, 0.0F);
/* 126 */       group.addActor((Actor)label3);
/*     */       
/*     */       Label label4;
/* 129 */       (label4 = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE))).setSize(100.0F, 48.0F);
/* 130 */       label4.setPosition(460.0F, 0.0F);
/* 131 */       label4.setAlignment(16);
/* 132 */       group.addActor((Actor)label4);
/*     */ 
/*     */       
/* 135 */       (group = new Group()).setTransform(false);
/* 136 */       group.setPosition(0.0F, 606.0F + m - 48.0F - 4.0F);
/* 137 */       group.setSize(600.0F, 48.0F);
/* 138 */       paramGroup.addActor((Actor)group);
/*     */ 
/*     */       
/* 141 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(600.0F, 48.0F);
/* 142 */       image.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 143 */       group.addActor((Actor)image);
/*     */ 
/*     */       
/* 146 */       (label3 = new Label(Game.i.localeManager.i18n.get("efficiency"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(100.0F, 48.0F);
/* 147 */       label3.setPosition(40.0F, 0.0F);
/* 148 */       group.addActor((Actor)label3);
/*     */       
/*     */       Label label5;
/* 151 */       (label5 = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE))).setSize(100.0F, 48.0F);
/* 152 */       label5.setPosition(460.0F, 0.0F);
/* 153 */       label5.setAlignment(16);
/* 154 */       group.addActor((Actor)label5);
/*     */       
/* 156 */       if (this.boostedByAbility) {
/* 157 */         String str = Game.i.localeManager.i18n.format("bounty_boosted_by_ability", new Object[] { Integer.valueOf(MathUtils.round(130.0F)) });
/*     */         
/* 159 */         (label3 = new Label(str, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setSize(100.0F, 48.0F);
/* 160 */         label3.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 161 */         label3.setPosition(40.0F, -48.0F);
/* 162 */         group.addActor((Actor)label3);
/*     */       } 
/*     */       
/* 165 */       paramObjectMap.put("bonusCoinsLabel", label4);
/* 166 */       paramObjectMap.put("efficiencyLabel", label5);
/* 167 */       paramObjectMap.put("state", Integer.valueOf(k));
/*     */     } 
/*     */     
/* 170 */     Label label1 = (Label)paramObjectMap.get("bonusCoinsLabel");
/* 171 */     Label label2 = (Label)paramObjectMap.get("efficiencyLabel");
/* 172 */     label1.setTextFromInt(this.coinsGained);
/*     */     
/* 174 */     int n = this.S.gameValue.getIntValue(GameValueType.MODIFIER_BOUNTY_VALUE);
/* 175 */     double d = this.S.gameValue.getPercentValueAsMultiplier(GameValueType.MODIFIER_BOUNTY_PERCENT);
/* 176 */     int i = MathUtils.ceil(n / (float)d);
/*     */     int j;
/* 178 */     k = MathUtils.floor((j = this.S.gameState.getMoney()) / i * 100.0F);
/* 179 */     if (j >= i) k = 100;
/*     */     
/* 181 */     b.setLength(0);
/* 182 */     b.append(j).append(" / ").append(i).append(" = ").append(k).append("%");
/* 183 */     label2.setText((CharSequence)b);
/*     */   }
/*     */   
/*     */   public static class BountyModifierFactory extends Modifier.Factory<BountyModifier> {
/*     */     private TextureRegion c;
/*     */     
/*     */     public BountyModifierFactory() {
/* 190 */       super(ModifierType.BOUNTY, MaterialColor.AMBER.P500, "icon-coin");
/*     */     }
/*     */     
/*     */     public ModifierProcessor createProcessor() {
/* 194 */       return (ModifierProcessor)new BountyModifierProcessor();
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 199 */       int i = param1GameValueProvider.getIntValue(GameValueType.MODIFIER_BOUNTY_VALUE);
/* 200 */       float f = MathUtils.round((float)param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.MODIFIER_BOUNTY_PERCENT) * 1000.0F) * 0.1F;
/*     */       
/* 202 */       String str = Game.i.localeManager.i18n.format("modifier_description_BOUNTY", new Object[] { Float.valueOf(f), Integer.valueOf(i) });
/* 203 */       if (!param1GameValueProvider.getBooleanValue(GameValueType.MODIFIER_BOUNTY_NEIGHBORING)) {
/* 204 */         str = str + "\n[#FFC107]" + Game.i.localeManager.i18n.get("modifier_cant_be_placed_near") + "[]";
/*     */       }
/* 206 */       if (!param1GameValueProvider.getBooleanValue(GameValueType.MODIFIER_BOUNTY_NO_HARM_TO_TOWERS)) {
/* 207 */         str = str + "\n[#FFC107]" + Game.i.localeManager.i18n.get("nearby_towers_dont_gain_coins") + "[]";
/*     */       }
/* 209 */       return str;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean canBePlacedNear(ModifierType param1ModifierType, GameValueProvider param1GameValueProvider) {
/* 214 */       if (!param1GameValueProvider.getBooleanValue(GameValueType.MODIFIER_BOUNTY_NEIGHBORING)) {
/* 215 */         return (param1ModifierType != ModifierType.BOUNTY);
/*     */       }
/* 217 */       return super.canBePlacedNear(param1ModifierType, param1GameValueProvider);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getBuildPrice(GameSystemProvider param1GameSystemProvider, int param1Int) {
/* 223 */       float f = 1.0F;
/* 224 */       if (param1GameSystemProvider.gameState.averageDifficulty > 100) {
/* 225 */         f = 1.0F + (param1GameSystemProvider.gameState.averageDifficulty - 100) * 0.01F * 0.5F;
/*     */       }
/* 227 */       return a((int)(180.0F * (float)StrictMath.pow(1.600000023841858D, (param1Int * 1.15F)) * f));
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getBaseTexture() {
/* 232 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 237 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("modifier-base-bounty");
/*     */     }
/*     */ 
/*     */     
/*     */     public BountyModifier create() {
/* 242 */       return new BountyModifier((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\modifiers\BountyModifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */