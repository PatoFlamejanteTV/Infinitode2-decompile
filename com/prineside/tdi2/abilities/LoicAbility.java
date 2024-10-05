/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Modifier;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.modifiers.BountyModifier;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.shapes.MultiLine;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class LoicAbility
/*     */   extends Ability
/*     */ {
/*  47 */   private static final int[] b = new int[] { 100, 125, 170, 250, 350, 475, 600, 725, 850, 1000, 1200 };
/*     */ 
/*     */   
/*  50 */   private static final int[][] c = new int[][] { { 7, 15, 35, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 7, 15, 35, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 12, 25, 45, 0, 0, 0, 200 }, { 0, 0, 0, 0, 0, 0, 15, 45, 60, 0, 150 }, { 0, 0, 0, 0, 0, 0, 0, 15, 30, 80, 0 } };
/*     */ 
/*     */   
/*     */   private float d;
/*     */ 
/*     */   
/*     */   private float e;
/*     */   
/*     */   private int f;
/*     */   
/*     */   @NAGS
/*  61 */   private float g = -1.0F;
/*  62 */   private float h = 0.0F;
/*  63 */   private Rectangle i = new Rectangle();
/*     */   @NAGS
/*     */   private MultiLine j;
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect k;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  70 */     super.write(paramKryo, paramOutput);
/*  71 */     paramOutput.writeFloat(this.d);
/*  72 */     paramOutput.writeFloat(this.e);
/*  73 */     paramOutput.writeInt(this.f);
/*  74 */     paramOutput.writeFloat(this.h);
/*  75 */     paramKryo.writeObject(paramOutput, this.i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  80 */     super.read(paramKryo, paramInput);
/*  81 */     this.d = paramInput.readFloat();
/*  82 */     this.e = paramInput.readFloat();
/*  83 */     this.f = paramInput.readInt();
/*  84 */     this.h = paramInput.readFloat();
/*  85 */     this.i = (Rectangle)paramKryo.readObject(paramInput, Rectangle.class);
/*     */   }
/*     */   
/*  88 */   private static final Color l = new Color();
/*     */   
/*     */   private LoicAbility() {
/*  91 */     super(AbilityType.LOIC);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUnregistered() {
/*  96 */     super.setUnregistered();
/*     */     
/*  98 */     if (this.k != null) {
/*  99 */       this.k.allowCompletion();
/* 100 */       this.k = null;
/*     */     } 
/*     */     
/* 103 */     this.j = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/* 109 */     this.a = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_LOIC_COINS);
/*     */     
/* 111 */     this.h = 0.0F;
/* 112 */     this.f = paramInt1;
/* 113 */     this.d = (float)(this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_LOIC_DAMAGE) * paramDouble);
/* 114 */     this.e = this.S.gameValue.getFloatValue(GameValueType.ABILITY_LOIC_DURATION);
/*     */     
/* 116 */     this.i.set(paramInt1 - 64.0F, 0.0F, 128.0F, (this.S.map.getMap().getHeight() << 7));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean start() {
/* 121 */     if (this.d <= 0.0F) {
/* 122 */       if (this.S._gameUi != null) {
/* 123 */         Notifications.i().add(Game.i.localeManager.i18n.get("ability_cant_start_zero_damage"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */       }
/* 125 */       return false;
/*     */     } 
/*     */     
/* 128 */     if (Game.i.shapeManager != null) {
/* 129 */       this.j = (MultiLine)Game.i.shapeManager.getFactory(ShapeType.MULTI_LINE).obtain();
/*     */       
/* 131 */       if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 132 */         this.k = (ParticleEffectPool.PooledEffect)LoicAbilityFactory.a(Game.i.abilityManager.F.LOIC).obtain();
/* 133 */         this.k.setPosition(this.f, (this.S.map.getMap().getHeight() << 7) * 0.5F);
/*     */         
/* 135 */         float f = (this.S.map.getMap().getHeight() << 7) / 128.0F;
/*     */         
/* 137 */         Array array = this.k.getEmitters();
/* 138 */         for (byte b1 = 0; b1 < array.size; b1++) {
/*     */           ParticleEmitter particleEmitter;
/* 140 */           (particleEmitter = (ParticleEmitter)array.get(b1)).getSpawnHeight().setHigh(128.0F * f);
/* 141 */           particleEmitter.getYOffsetValue().setLow(-64.0F * f);
/* 142 */           particleEmitter.getEmission().setHigh(10.0F * f);
/*     */         } 
/*     */         
/* 145 */         this.S._particle.addParticle((ParticleEffect)this.k, false);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 150 */     for (byte b = 0; b < this.S.modifier.modifiers.size; b++) {
/*     */       Modifier modifier;
/* 152 */       if (modifier = (Modifier)this.S.modifier.modifiers.get(b) instanceof BountyModifier) {
/*     */         BountyModifier bountyModifier;
/* 154 */         (bountyModifier = (BountyModifier)modifier).boostedByAbility = true;
/*     */       } 
/*     */     } 
/*     */     
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void c() {
/*     */     float f2;
/* 164 */     if (this.h < 0.3F) {
/* 165 */       f2 = this.h / 0.3F;
/* 166 */     } else if (this.e - this.h < 0.3F) {
/*     */       
/* 168 */       f2 = (this.e - this.h) / 0.3F;
/*     */       
/* 170 */       if (this.k != null) {
/* 171 */         this.k.allowCompletion();
/* 172 */         this.k = null;
/*     */       } 
/*     */     } else {
/*     */       
/* 176 */       float f5, f6 = MathUtils.floor((f5 = this.e - 0.6F) / 0.5F);
/* 177 */       float f7 = f5 / f6;
/* 178 */       float f4 = (this.h - 0.3F) / f7 * 3.1415927F;
/* 179 */       f2 = (float)(0.9499999992549419D + (PMath.sin(f4) * 0.1F * 0.5F));
/*     */     } 
/*     */     
/*     */     float f1;
/* 183 */     if ((f1 = 128.0F * f2) == this.g)
/*     */       return; 
/* 185 */     this.g = f1;
/*     */     
/* 187 */     l.set(MaterialColor.CYAN.P200);
/* 188 */     this.j.reset();
/* 189 */     this.j.setTextureRegion(LoicAbilityFactory.b(Game.i.abilityManager.F.LOIC), false, false);
/*     */     
/* 191 */     int i = MathUtils.ceil((this.S.map.getMap().getHeight() << 7) / LoicAbilityFactory.b(Game.i.abilityManager.F.LOIC).getRegionWidth() + 2.0F);
/*     */     
/* 193 */     l.a = 0.0F;
/* 194 */     float f3 = ((this.S.map.getMap().getHeight() << 7) + LoicAbilityFactory.b(Game.i.abilityManager.F.LOIC).getRegionWidth());
/* 195 */     this.j.appendNode(this.f, f3, f1, l.toFloatBits(), false);
/* 196 */     for (byte b = 0; b < i; b++) {
/* 197 */       l.a = f2;
/* 198 */       if (b == i - 1) {
/* 199 */         l.a = 0.0F;
/*     */       }
/* 201 */       f3 -= LoicAbilityFactory.b(Game.i.abilityManager.F.LOIC).getRegionWidth();
/* 202 */       this.j.appendNode(this.f, f3, f1, l.toFloatBits(), false);
/*     */     } 
/* 204 */     this.j.updateAllNodes();
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 209 */     this.h += paramFloat;
/* 210 */     paramFloat = this.d * paramFloat;
/*     */     
/* 212 */     this.S.map.spawnedEnemies.begin();
/* 213 */     for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*     */       Enemy enemy;
/* 215 */       if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null && this.i.contains(enemy.getPosition())) {
/*     */         float f;
/*     */         
/* 218 */         if ((f = paramFloat * enemy.getAbilityVulnerability(AbilityType.LOIC)) > 0.0F)
/* 219 */           this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, f, DamageType.LASER)
/* 220 */               .setAbility(this)
/* 221 */               .setEfficiency(4)
/* 222 */               .setCleanForDps(false)); 
/*     */       } 
/*     */     } 
/* 225 */     this.S.map.spawnedEnemies.end();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 230 */     return (this.h >= this.e);
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {}
/*     */ 
/*     */   
/*     */   public void drawBatchAdditive(Batch paramBatch, float paramFloat) {
/* 238 */     if (this.j == null)
/*     */       return; 
/* 240 */     c();
/* 241 */     this.j.draw(paramBatch);
/*     */   }
/*     */   
/*     */   public static class LoicAbilityFactory
/*     */     extends Ability.Factory<LoicAbility>
/*     */   {
/*     */     private TextureRegion a;
/*     */     private ParticleEffectPool b;
/*     */     
/*     */     public LoicAbilityFactory(AbilityType param1AbilityType) {
/* 251 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 256 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("laser-wide");
/* 257 */       this.b = Game.i.assetManager.getParticleEffectPool("loic.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public LoicAbility create() {
/* 262 */       return new LoicAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 267 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 272 */       return MaterialColor.CYAN.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 277 */       float f1 = MathUtils.round((float)param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_LOIC_DAMAGE) * 1000.0F) / 10.0F;
/* 278 */       float f2 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_LOIC_DURATION);
/* 279 */       int i = (int)StrictMath.round(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_LOIC_COINS) * 100.0D);
/*     */       
/* 281 */       String str2 = Game.i.localeManager.i18n.format("ability_description_LOIC", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
/* 282 */       String str1 = Game.i.localeManager.i18n.format("ability_coins_for_killed_enemies", new Object[] { Integer.valueOf(i) });
/* 283 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 288 */       return MaterialColor.CYAN.P800;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 293 */       return LoicAbility.a()[StrictMath.min(param1Int, (LoicAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 298 */       return LoicAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (LoicAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 303 */       return Game.i.assetManager.getDrawable("icon-loic");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\LoicAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */