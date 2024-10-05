/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.shapes.ChainLightning;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.EntityUtils;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class ThunderAbility
/*     */   extends Ability
/*     */ {
/*  38 */   private static final int[] b = new int[] { 100, 125, 150, 175, 250, 300, 400, 550, 700, 800, 850 };
/*     */ 
/*     */   
/*  41 */   private static final int[][] c = new int[][] { { 5, 10, 25, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 5, 15, 30, 0, 0, 0, 0, 0, 250 }, { 0, 0, 0, 0, 10, 25, 40, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 10, 20, 60, 0, 150 }, { 0, 0, 0, 0, 0, 0, 0, 10, 20, 75, 0 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   public int chargesCount = 0;
/*     */   public int targetChargesCount;
/*  51 */   public float timeSinceLastCharge = 0.0F;
/*     */   public float damage;
/*     */   @NAGS
/*  54 */   private final ChainLightning[] d = new ChainLightning[128];
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  58 */     super.write(paramKryo, paramOutput);
/*  59 */     paramOutput.writeVarInt(this.chargesCount, true);
/*  60 */     paramOutput.writeVarInt(this.targetChargesCount, true);
/*  61 */     paramOutput.writeFloat(this.timeSinceLastCharge);
/*  62 */     paramOutput.writeFloat(this.damage);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  67 */     super.read(paramKryo, paramInput);
/*  68 */     this.chargesCount = paramInput.readVarInt(true);
/*  69 */     this.targetChargesCount = paramInput.readVarInt(true);
/*  70 */     this.timeSinceLastCharge = paramInput.readFloat();
/*  71 */     this.damage = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private ThunderAbility() {
/*  75 */     super(AbilityType.THUNDER);
/*     */   }
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/*  80 */     this.a = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_THUNDER_COINS);
/*     */     
/*  82 */     this.damage = (float)(this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_THUNDER_DAMAGE) * paramDouble);
/*     */     
/*  84 */     this.targetChargesCount = this.S.gameValue.getIntValue(GameValueType.ABILITY_THUNDER_CHARGES_COUNT);
/*  85 */     if (this.targetChargesCount >= 128) {
/*  86 */       this.targetChargesCount = 128;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean start() {
/*  92 */     if (this.damage <= 0.0F) {
/*  93 */       if (this.S._gameUi != null) {
/*  94 */         Notifications.i().add(Game.i.localeManager.i18n.get("ability_cant_start_zero_damage"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */       }
/*  96 */       return false;
/*     */     } 
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   public void update(float paramFloat) {
/*     */     Enemy enemy;
/* 103 */     if (this.chargesCount < this.targetChargesCount) {
/*     */       
/* 105 */       EntityUtils.removeNullRefs((Array)this.S.map.spawnedEnemies);
/* 106 */       if (this.S.map.spawnedEnemies.size != 0) {
/* 107 */         enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[this.S.gameState.randomInt(this.S.map.spawnedEnemies.size)]).enemy;
/* 108 */         if (this.S.enemy.enemyDamageVulnerability[enemy.type.ordinal()][DamageType.ELECTRICITY.ordinal()]) {
/* 109 */           if (Game.i.shapeManager != null && !this.S.gameState.canSkipMediaUpdate()) {
/*     */             ChainLightning chainLightning;
/* 111 */             (chainLightning = (ChainLightning)Game.i.shapeManager.getFactory(ShapeType.CHAIN_LIGHTNING).obtain()).setTexture(Game.i.abilityManager.F.THUNDER.lightningTexture, true, true);
/* 112 */             chainLightning.setColor(MaterialColor.LIGHT_BLUE.P200);
/* 113 */             this.d[this.chargesCount] = chainLightning;
/*     */             
/* 115 */             chainLightning.setup((enemy.getPosition()).x, (enemy.getPosition()).y + 4096.0F, (enemy.getPosition()).x, (enemy.getPosition()).y, 1.0F, 0.15F, true, 30.72F, 128.0F, 25.6F);
/*     */           } 
/*     */           
/* 118 */           if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */             ParticleEffectPool.PooledEffect pooledEffect;
/* 120 */             (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.abilityManager.F.THUNDER.a.obtain()).setPosition((enemy.getPosition()).x, (enemy.getPosition()).y);
/* 121 */             this.S._particle.addParticle((ParticleEffect)pooledEffect, false);
/*     */           } 
/*     */           
/* 124 */           this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, this.damage, DamageType.ELECTRICITY).setAbility(this).setEfficiency(8));
/*     */ 
/*     */           
/* 127 */           this.chargesCount++;
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } else {
/* 132 */       this.timeSinceLastCharge += enemy;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 138 */     return (this.chargesCount >= this.targetChargesCount && this.timeSinceLastCharge > 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawBatchAdditive(Batch paramBatch, float paramFloat) {
/* 148 */     for (byte b = 0; b < this.d.length; b++) {
/* 149 */       if (this.d[b] != null) {
/* 150 */         this.d[b].update(paramFloat);
/* 151 */         this.d[b].draw(paramBatch);
/* 152 */         if (this.d[b].isFinished()) {
/* 153 */           this.d[b].free();
/* 154 */           this.d[b] = null;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class ThunderAbilityFactory
/*     */     extends Ability.Factory<ThunderAbility> {
/*     */     public TextureRegion lightningTexture;
/*     */     ParticleEffectPool a;
/*     */     
/*     */     public ThunderAbilityFactory(AbilityType param1AbilityType) {
/* 166 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 171 */       this.lightningTexture = (TextureRegion)Game.i.assetManager.getTextureRegion("chain-lightning-wide");
/* 172 */       this.a = Game.i.assetManager.getParticleEffectPool("sparks.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public ThunderAbility create() {
/* 177 */       return new ThunderAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 182 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 187 */       return MaterialColor.INDIGO.P400;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 192 */       int j = param1GameValueProvider.getIntValue(GameValueType.ABILITY_THUNDER_CHARGES_COUNT);
/* 193 */       int k = param1GameValueProvider.getIntValue(GameValueType.ABILITY_THUNDER_DAMAGE);
/* 194 */       int i = (int)StrictMath.round(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_THUNDER_COINS) * 100.0D);
/*     */       
/* 196 */       String str2 = Game.i.localeManager.i18n.format("ability_description_THUNDER", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
/* 197 */       String str1 = Game.i.localeManager.i18n.format("ability_coins_for_killed_enemies", new Object[] { Integer.valueOf(i) });
/* 198 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 203 */       return MaterialColor.INDIGO.P600;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 208 */       return ThunderAbility.a()[StrictMath.min(param1Int, (ThunderAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 213 */       return ThunderAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (ThunderAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 218 */       return Game.i.assetManager.getDrawable("icon-thunder");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\ThunderAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */