/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.shapes.Circle;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class SmokeBombAbility
/*     */   extends Ability
/*     */ {
/*  44 */   private static final int[] b = new int[] { 100, 125, 150, 175, 250, 300, 400, 550, 750, 875, 1000 };
/*     */ 
/*     */   
/*  47 */   private static final int[][] c = new int[][] { { 4, 8, 20, 25, 0, 0, 0, 0, 0, 0, 300 }, { 0, 0, 4, 8, 20, 35, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 20, 45, 0, 0, 0, 200 }, { 0, 0, 0, 0, 0, 0, 10, 20, 55, 80, 0 }, { 0, 0, 0, 0, 0, 0, 0, 10, 25, 60, 0 } };
/*     */   
/*     */   private float d;
/*     */   
/*     */   private float e;
/*     */   
/*     */   private int f;
/*     */   
/*     */   private SmokeBombAbility() {
/*  56 */     super(AbilityType.SMOKE_BOMB);
/*     */   }
/*     */ 
/*     */   
/*     */   private int g;
/*     */   
/*     */   private double h;
/*     */   
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect i;
/*     */   @NAGS
/*     */   private Circle j;
/*  68 */   private static final StringBuilder k = new StringBuilder();
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  72 */     super.write(paramKryo, paramOutput);
/*  73 */     paramOutput.writeFloat(this.d);
/*  74 */     paramOutput.writeFloat(this.e);
/*  75 */     paramOutput.writeInt(this.f);
/*  76 */     paramOutput.writeInt(this.g);
/*  77 */     paramOutput.writeDouble(this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  82 */     super.read(paramKryo, paramInput);
/*  83 */     this.d = paramInput.readFloat();
/*  84 */     this.e = paramInput.readFloat();
/*  85 */     this.f = paramInput.readInt();
/*  86 */     this.g = paramInput.readInt();
/*  87 */     this.h = paramInput.readDouble();
/*     */   }
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/*  92 */     this.h = paramDouble;
/*  93 */     this.a = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_SMOKE_BOMB_COINS);
/*     */     
/*  95 */     this.f = paramInt1;
/*  96 */     this.g = paramInt2;
/*     */     
/*  98 */     float f = this.S.gameValue.getFloatValue(GameValueType.ABILITY_SMOKE_BOMB_DURATION);
/*  99 */     this.e = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_SMOKE_BOMB_DAMAGE);
/*     */     
/* 101 */     this.d = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean start() {
/* 106 */     if (this.h * this.e <= 0.0D) {
/* 107 */       if (this.S._gameUi != null) {
/* 108 */         Notifications.i().add(Game.i.localeManager.i18n.get("ability_cant_start_zero_damage"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */       }
/* 110 */       return false;
/*     */     } 
/*     */     
/* 113 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 114 */       this.i = (ParticleEffectPool.PooledEffect)Game.i.abilityManager.F.SMOKE_BOMB.a.obtain();
/*     */       
/* 116 */       this.S._particle.addParticle((ParticleEffect)this.i, false);
/* 117 */       this.i.setPosition(this.f, this.g);
/*     */     } 
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUnregistered() {
/* 124 */     if (this.i != null) {
/* 125 */       this.i.allowCompletion();
/* 126 */       this.i = null;
/*     */     } 
/* 128 */     if (this.j != null) {
/* 129 */       this.j.free();
/* 130 */       this.j = null;
/*     */     } 
/*     */     
/* 133 */     super.setUnregistered();
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 138 */     this.d -= paramFloat;
/*     */     
/* 140 */     paramFloat = (float)this.h * this.e * paramFloat;
/*     */     
/* 142 */     this.S.map.spawnedEnemies.begin();
/* 143 */     for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*     */       Enemy.EnemyReference enemyReference;
/*     */       Enemy enemy;
/* 146 */       if ((enemy = (enemyReference = ((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null) {
/*     */         float f;
/*     */         
/* 149 */         if ((f = PMath.getSquareDistanceBetweenPoints((enemy.getPosition()).x, (enemy.getPosition()).y, this.f, this.g)) < 65536.0F && enemy.isVulnerableTo(DamageType.POISON))
/* 150 */           this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, paramFloat, DamageType.POISON).setAbility(this).setEfficiency(4)); 
/*     */       } 
/*     */     } 
/* 153 */     this.S.map.spawnedEnemies.end();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 158 */     return (this.d <= 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 163 */     if (this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED) {
/* 164 */       if (this.j == null && Game.i.shapeManager != null) {
/* 165 */         this.j = (Circle)Game.i.shapeManager.getFactory(ShapeType.CIRCLE).obtain();
/*     */         Color color1;
/* 167 */         (color1 = MaterialColor.LIGHT_GREEN.P300.cpy()).a = 0.07F;
/*     */         Color color2;
/* 169 */         (color2 = MaterialColor.LIGHT_GREEN.P300.cpy()).a = 0.21F;
/* 170 */         this.j.setup(this.f, this.g, 0.0F, 256.0F, 32, color1.toFloatBits(), color2.toFloatBits());
/*     */       } 
/*     */       
/* 173 */       if (this.j != null) {
/* 174 */         this.j.draw(paramBatch);
/*     */         
/* 176 */         paramBatch.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 177 */         paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).iconSmokeBomb, (this.f - 32 + 3), (this.g - 32 - 3), 64.0F, 64.0F);
/* 178 */         paramBatch.setColor(MaterialColor.LIGHT_GREEN.P300);
/* 179 */         paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).iconSmokeBomb, (this.f - 32), (this.g - 32), 64.0F, 64.0F);
/* 180 */         paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */         
/* 182 */         k.setLength(0);
/* 183 */         k.append((int)this.d);
/* 184 */         k.append('.');
/* 185 */         k.append((int)(this.d % 1.0F * 10.0F));
/*     */         ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont;
/* 187 */         (resourcePackBitmapFont = Game.i.assetManager.getFont(30)).setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 188 */         resourcePackBitmapFont.draw(paramBatch, (CharSequence)k, (this.f - 1) + 2.0F, (this.g + 64) - 2.0F, 2.0F, 1, false);
/* 189 */         resourcePackBitmapFont.setColor(MaterialColor.LIGHT_GREEN.P300);
/* 190 */         resourcePackBitmapFont.draw(paramBatch, (CharSequence)k, (this.f - 1), (this.g + 64), 2.0F, 1, false);
/* 191 */         resourcePackBitmapFont.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class SmokeBombAbilityFactory extends Ability.Factory<SmokeBombAbility> {
/*     */     ParticleEffectPool a;
/*     */     
/*     */     public SmokeBombAbilityFactory(AbilityType param1AbilityType) {
/* 200 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 205 */       this.a = Game.i.assetManager.getParticleEffectPool("ability-poison-cloud.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public SmokeBombAbility create() {
/* 210 */       return new SmokeBombAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 215 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 220 */       return MaterialColor.LIGHT_GREEN.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 225 */       float f1 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_SMOKE_BOMB_DURATION);
/* 226 */       float f2 = MathUtils.round((float)param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_SMOKE_BOMB_DAMAGE) * 1000.0F) / 10.0F;
/* 227 */       int i = (int)StrictMath.round(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_SMOKE_BOMB_COINS) * 100.0D);
/*     */       
/* 229 */       String str2 = Game.i.localeManager.i18n.format("ability_description_SMOKE_BOMB", new Object[] { Float.valueOf(f2), Float.valueOf(f1) });
/* 230 */       String str1 = Game.i.localeManager.i18n.format("ability_coins_for_killed_enemies", new Object[] { Integer.valueOf(i) });
/* 231 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 236 */       return MaterialColor.LIGHT_GREEN.P800;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 241 */       return SmokeBombAbility.a()[StrictMath.min(param1Int, (SmokeBombAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 246 */       return SmokeBombAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (SmokeBombAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 251 */       return Game.i.assetManager.getDrawable("icon-smoke-bomb");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\SmokeBombAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */