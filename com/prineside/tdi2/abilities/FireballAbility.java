/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.explosions.FireballExplosion;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class FireballAbility
/*     */   extends Ability
/*     */ {
/*  28 */   private static final int[] b = new int[] { 100, 125, 150, 175, 250, 300, 400, 550, 750, 875, 1000 };
/*     */ 
/*     */   
/*  31 */   private static final int[][] c = new int[][] { { 4, 8, 20, 25, 0, 0, 0, 0, 0, 0, 300 }, { 0, 0, 4, 8, 20, 35, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 20, 45, 0, 0, 0, 200 }, { 0, 0, 0, 0, 0, 0, 10, 20, 55, 80, 0 }, { 0, 0, 0, 0, 0, 0, 0, 10, 25, 60, 0 } };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FireballExplosion d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  43 */     super.write(paramKryo, paramOutput);
/*  44 */     paramKryo.writeClassAndObject(paramOutput, this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  49 */     super.read(paramKryo, paramInput);
/*  50 */     this.d = (FireballExplosion)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */   
/*     */   private FireballAbility() {
/*  54 */     super(AbilityType.FIREBALL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/*  59 */     this.a = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_FIREBALL_COINS);
/*     */     
/*  61 */     float f1 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_FIREBALL_FIRE_DAMAGE) * 0.1F;
/*     */     
/*  63 */     this.d = (FireballExplosion)this.S.explosion.F.FIREBALL.obtain();
/*  64 */     float f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_FIREBALL_DAMAGE);
/*  65 */     this.d.setup(paramInt1, paramInt2, (float)(f2 * paramDouble), (float)(f1 * paramDouble), 4.0F, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean start() {
/*  70 */     if (this.d.getDamage() <= 0.0F && this.d.getFireDamage() <= 0.0F) {
/*  71 */       if (this.S._gameUi != null) {
/*  72 */         Notifications.i().add(Game.i.localeManager.i18n.get("ability_cant_start_zero_damage"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */       }
/*  74 */       return false;
/*     */     } 
/*     */     
/*  77 */     this.S.explosion.register((Explosion)this.d);
/*  78 */     this.d.explode();
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startEffects() {
/*  84 */     a(1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/*  92 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {}
/*     */   
/*     */   public static class FireballAbilityFactory
/*     */     extends Ability.Factory<FireballAbility>
/*     */   {
/*     */     public FireballAbilityFactory(AbilityType param1AbilityType) {
/* 102 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public FireballAbility create() {
/* 107 */       return new FireballAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 112 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 117 */       return MaterialColor.DEEP_ORANGE.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 122 */       int j = param1GameValueProvider.getIntValue(GameValueType.ABILITY_FIREBALL_DAMAGE);
/* 123 */       int k = param1GameValueProvider.getIntValue(GameValueType.ABILITY_FIREBALL_FIRE_DAMAGE);
/* 124 */       int i = (int)StrictMath.round(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_FIREBALL_COINS) * 100.0D);
/*     */       
/* 126 */       String str2 = Game.i.localeManager.i18n.format("ability_description_FIREBALL", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
/* 127 */       String str1 = Game.i.localeManager.i18n.format("ability_coins_for_killed_enemies", new Object[] { Integer.valueOf(i) });
/* 128 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 133 */       return MaterialColor.DEEP_ORANGE.P700;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getTitle() {
/* 138 */       return Game.i.localeManager.i18n.get("ability_name_FIREBALL");
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 143 */       return FireballAbility.a()[StrictMath.min(param1Int, (FireballAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 148 */       return FireballAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (FireballAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 153 */       return Game.i.assetManager.getDrawable("icon-fireball");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\FireballAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */