/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.CameraController;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.buffs.NoBonusSystemPointsBuff;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class NukeAbility
/*     */   extends Ability
/*     */ {
/*  35 */   private static final int[] b = new int[] { 100, 125, 170, 250, 350, 475, 600, 725, 850, 1000, 1200 };
/*     */ 
/*     */   
/*  38 */   private static final int[][] c = new int[][] { { 10, 20, 45, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 15, 25, 60, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 15, 35, 70, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 15, 35, 60, 0, 150 }, { 0, 0, 0, 0, 0, 0, 0, 15, 35, 80, 100 } };
/*     */ 
/*     */   
/*     */   @NAGS
/*     */   private float d;
/*     */ 
/*     */   
/*     */   @NAGS
/*     */   private float e;
/*     */   
/*     */   public float damage;
/*     */   
/*     */   private boolean f;
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  54 */     super.write(paramKryo, paramOutput);
/*  55 */     paramOutput.writeFloat(this.damage);
/*  56 */     paramOutput.writeBoolean(this.f);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  61 */     super.read(paramKryo, paramInput);
/*  62 */     this.damage = paramInput.readFloat();
/*  63 */     this.f = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private NukeAbility() {
/*  67 */     super(AbilityType.NUKE);
/*     */   }
/*     */   
/*     */   public boolean isKilledEnemyNotAffectsBonusSystem() {
/*  71 */     return this.f;
/*     */   }
/*     */   
/*     */   public void setKilledEnemyNotAffectsBonusSystem(boolean paramBoolean) {
/*  75 */     this.f = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/*  80 */     this.a = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_NUKE_COINS);
/*     */     
/*  82 */     this.d = paramInt1;
/*  83 */     this.e = paramInt2;
/*     */     
/*  85 */     this.damage = (float)(paramDouble * this.S.gameValue.getIntValue(GameValueType.ABILITY_NUKE_DAMAGE) * 0.009999999776482582D);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean start() {
/*  90 */     if (this.damage <= 0.0F) {
/*  91 */       if (this.S._gameUi != null) {
/*  92 */         Notifications.i().add(Game.i.localeManager.i18n.get("ability_cant_start_zero_damage"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */       }
/*  94 */       return false;
/*     */     } 
/*     */     
/*  97 */     this.S.map.spawnedEnemies.begin();
/*  98 */     for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*     */       Enemy enemy;
/* 100 */       if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null) {
/*     */         
/* 102 */         if (this.f) {
/*     */           NoBonusSystemPointsBuff noBonusSystemPointsBuff;
/* 104 */           (noBonusSystemPointsBuff = new NoBonusSystemPointsBuff()).setup(this.S.gameValue.getTickRateDeltaTime() + 0.001F, this.S.gameValue.getTickRateDeltaTime() + 0.001F);
/* 105 */           this.S.buff.P_NO_BONUS_SYSTEM_POINTS.addBuff(enemy, noBonusSystemPointsBuff);
/*     */         } 
/* 107 */         this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, this.damage, DamageType.EXPLOSION).setAbility(this).setCleanForDps(false).setEfficiency(8));
/*     */       } 
/* 109 */     }  this.S.map.spawnedEnemies.end();
/*     */     
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startEffects() {
/* 116 */     a(1.0F);
/*     */     
/* 118 */     if (this.S._particle != null) {
/*     */       ParticleEffectPool.PooledEffect pooledEffect;
/* 120 */       (pooledEffect = (ParticleEffectPool.PooledEffect)NukeAbilityFactory.a(Game.i.abilityManager.F.NUKE).obtain()).setPosition(this.d, this.e);
/* 121 */       this.S._particle.addParticle((ParticleEffect)pooledEffect, false);
/*     */     } 
/*     */     
/* 124 */     if (this.S._input != null && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.CAMERA_SHAKE_ENABLED) == 1.0D) {
/* 125 */       this.S._input.cameraController.animate((CameraController.CameraControllerAnimation)new CameraController.ShakeAnimation(35.0F, 2.5F));
/*     */ 
/*     */       
/* 128 */       this.S._gameUi.screenBorderGradient.fullscreenFlash(Color.WHITE.cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), 2.0F, (Interpolation)Interpolation.pow2In);
/* 129 */       this.S.gameState.animateSpeed(0.35F, 4.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {}
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 138 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {}
/*     */   
/*     */   public static class NukeAbilityFactory
/*     */     extends Ability.Factory<NukeAbility>
/*     */   {
/*     */     private ParticleEffectPool a;
/*     */     
/*     */     public NukeAbilityFactory(AbilityType param1AbilityType) {
/* 150 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public NukeAbility create() {
/* 155 */       return new NukeAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 160 */       this.a = Game.i.assetManager.getParticleEffectPool("nuke-explosion.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 165 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 170 */       return MaterialColor.PURPLE.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 175 */       int j = param1GameValueProvider.getIntValue(GameValueType.ABILITY_NUKE_DAMAGE);
/* 176 */       int i = (int)StrictMath.round(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_NUKE_COINS) * 100.0D);
/*     */       
/* 178 */       String str2 = Game.i.localeManager.i18n.format("ability_description_NUKE", new Object[] { Integer.valueOf(j) });
/* 179 */       String str1 = Game.i.localeManager.i18n.format("ability_coins_for_killed_enemies", new Object[] { Integer.valueOf(i) });
/* 180 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 185 */       return MaterialColor.PURPLE.P700;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getTitle() {
/* 190 */       return Game.i.localeManager.i18n.get("ability_name_NUKE");
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 195 */       return NukeAbility.a()[StrictMath.min(param1Int, (NukeAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 200 */       return NukeAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (NukeAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 205 */       return Game.i.assetManager.getDrawable("icon-nuke");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\NukeAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */