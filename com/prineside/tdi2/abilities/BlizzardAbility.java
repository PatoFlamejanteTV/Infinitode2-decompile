/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntSet;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.buffs.BlizzardBuff;
/*     */ import com.prineside.tdi2.buffs.FreezingBuff;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemySpawn;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.tiles.RoadTile;
/*     */ import com.prineside.tdi2.ui.actors.ImageWithParentColor;
/*     */ import com.prineside.tdi2.units.IceFieldUnit;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class BlizzardAbility
/*     */   extends Ability
/*     */   implements Listener<EnemySpawn>
/*     */ {
/*  50 */   private static final int[] b = new int[] { 100, 125, 150, 175, 250, 300, 400, 550, 750, 875, 1000 };
/*     */ 
/*     */   
/*  53 */   private static final int[][] c = new int[][] { { 5, 10, 25, 0, 0, 0, 0, 0, 0, 0, 300 }, { 0, 0, 5, 10, 30, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 10, 20, 50, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 10, 25, 45, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 10, 25, 75, 100 } };
/*     */ 
/*     */   
/*     */   public static final int ICE_FIELD_LIFETIME_MIN = 585;
/*     */ 
/*     */   
/*     */   public static final int ICE_FIELD_LIFETIME_MAX = 615;
/*     */   
/*     */   public static final int ICE_FIELD_COUNT = 8;
/*     */   
/*     */   public static final int ICE_FIELD_MAX_TOUCHES = 20;
/*     */   
/*     */   private float d;
/*     */   
/*  67 */   private Array<ObjectPair<Enemy, BlizzardBuff>> e = new Array(true, 1, ObjectPair.class);
/*  68 */   private Array<IceFieldUnit> f = new Array(true, 1, IceFieldUnit.class); @NAGS
/*     */   private Group g;
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect h;
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect i;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  76 */     super.write(paramKryo, paramOutput);
/*  77 */     paramOutput.writeFloat(this.d);
/*  78 */     paramKryo.writeObject(paramOutput, this.e);
/*  79 */     paramKryo.writeObject(paramOutput, this.f);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  84 */     super.read(paramKryo, paramInput);
/*  85 */     this.d = paramInput.readFloat();
/*  86 */     this.e = (Array<ObjectPair<Enemy, BlizzardBuff>>)paramKryo.readObject(paramInput, Array.class);
/*  87 */     this.f = (Array<IceFieldUnit>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */   
/*     */   private BlizzardAbility() {
/*  91 */     super(AbilityType.BLIZZARD);
/*     */   }
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/*  96 */     float f1 = this.S.gameValue.getFloatValue(GameValueType.ABILITY_BLIZZARD_DURATION);
/*  97 */     float f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_BLIZZARD_BONUS_DAMAGE);
/*     */     
/*  99 */     this.d = f1;
/* 100 */     this.e.clear();
/*     */     
/* 102 */     this.S.map.spawnedEnemies.begin();
/* 103 */     for (byte b1 = 0; b1 < this.S.map.spawnedEnemies.size; b1++) {
/*     */       Enemy enemy;
/* 105 */       if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b1]).enemy) != null) {
/*     */         BlizzardBuff blizzardBuff;
/*     */         
/* 108 */         (blizzardBuff = new BlizzardBuff()).setup(f1, f1 * 10.0F, f2);
/* 109 */         this.e.add(new ObjectPair(enemy, blizzardBuff));
/*     */       } 
/*     */     } 
/* 112 */     this.S.map.spawnedEnemies.end();
/*     */ 
/*     */     
/* 115 */     Map map = this.S.map.getMap();
/* 116 */     IntSet intSet = new IntSet();
/* 117 */     for (byte b2 = 0; b2 < this.S.map.spawnedUnits.size; b2++) {
/*     */       Unit unit;
/* 119 */       if (unit = (Unit)this.S.map.spawnedUnits.get(b2) instanceof IceFieldUnit) {
/* 120 */         int i = Map.posToCell(unit.position.x);
/* 121 */         int j = Map.posToCell(unit.position.y);
/* 122 */         intSet.add(j * 48 + i);
/*     */       } 
/*     */     } 
/*     */     
/* 126 */     long l = 0L;
/* 127 */     Array array1 = new Array(true, 1, ObjectPair.class);
/* 128 */     Array array2 = map.getTilesByType(RoadTile.class);
/* 129 */     for (byte b3 = 0; b3 < array2.size; b3++) {
/*     */       RoadTile roadTile;
/* 131 */       int i = (roadTile = (RoadTile)array2.get(b3)).getY() * 48 + roadTile.getX();
/* 132 */       if (!intSet.contains(i)) {
/* 133 */         long l1 = (long)PMath.getDistanceBetweenPoints(roadTile.center, (map.getTargetTileOrThrow()).center);
/* 134 */         array1.add(new ObjectPair(roadTile, Long.valueOf(l1)));
/* 135 */         l = Math.max(l, l1);
/*     */       } 
/*     */     } 
/*     */     
/* 139 */     if (array1.size != 0) {
/* 140 */       long l1 = 0L; byte b;
/* 141 */       for (b = 0; b < array1.size; b++) {
/*     */         ObjectPair objectPair;
/* 143 */         (objectPair = ((ObjectPair[])array1.items)[b]).second = Long.valueOf(l - ((Long)objectPair.second).longValue() + 128L);
/* 144 */         l1 += ((Long)objectPair.second).longValue();
/*     */       } 
/*     */       
/* 147 */       for (b = 0; b < 8; ) {
/* 148 */         long l2 = (long)(this.S.gameState.randomFloat() * (float)l1);
/* 149 */         array2 = null;
/* 150 */         byte b4 = 0;
/* 151 */         ObjectPair objectPair = ((ObjectPair[])array1.items)[b4];
/*     */         
/* 153 */         for (; b4 < array1.size && (l2 = l2 - ((Long)objectPair.second).longValue()) > 0L; b4++);
/*     */ 
/*     */ 
/*     */         
/* 157 */         if (objectPair == null) {
/* 158 */           objectPair = (ObjectPair)array1.first();
/*     */         }
/* 160 */         array1.removeValue(objectPair, true);
/* 161 */         l1 -= ((Long)objectPair.second).longValue();
/*     */         
/* 163 */         IceFieldUnit iceFieldUnit = Game.i.unitManager.F.ICE_FIELD.create();
/* 164 */         float f = 585.0F + this.S.gameState.randomFloat() * 30.0F;
/* 165 */         iceFieldUnit.setup(((RoadTile)objectPair.first).center.x, ((RoadTile)objectPair.first).center.y, f, 20);
/* 166 */         this.f.add(iceFieldUnit);
/*     */ 
/*     */ 
/*     */         
/* 170 */         if (array1.size != 0) {
/*     */           b++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean start() {
/*     */     byte b;
/* 179 */     for (b = 0; b < this.e.size; b++) {
/* 180 */       ObjectPair objectPair = ((ObjectPair[])this.e.items)[b];
/* 181 */       this.S.buff.P_BLIZZARD.addBuff((Enemy)objectPair.first, (BlizzardBuff)objectPair.second);
/*     */     } 
/* 183 */     for (b = 0; b < this.f.size; b++) {
/* 184 */       IceFieldUnit iceFieldUnit = ((IceFieldUnit[])this.f.items)[b];
/* 185 */       this.S.unit.register((Unit)iceFieldUnit);
/* 186 */       this.S.map.spawnUnit((Unit)iceFieldUnit);
/*     */     } 
/* 188 */     this.S.events.getListeners(EnemySpawn.class).addStateAffecting(this).setDescription("Applies Freezing debuff to the enemies that spawn during this ability is still active");
/*     */     
/* 190 */     if (this.S._gameUi != null) {
/* 191 */       this.g = new Group(this)
/*     */         {
/*     */           public void draw(Batch param1Batch, float param1Float) {
/* 194 */             param1Batch.end();
/*     */             
/* 196 */             param1Batch.begin();
/* 197 */             param1Batch.setBlendFunction(770, 1);
/* 198 */             super.draw(param1Batch, param1Float);
/* 199 */             param1Batch.end();
/*     */             
/* 201 */             param1Batch.begin();
/* 202 */             param1Batch.setBlendFunction(770, 771);
/*     */           }
/*     */         };
/* 205 */       this.g.setTransform(false);
/* 206 */       this.g.setTouchable(Touchable.disabled);
/* 207 */       this.g.setSize(Game.i.uiManager.viewport
/* 208 */           .getWorldWidth() + (Game.i.uiManager.getScreenSafeMargin() << 1), Game.i.uiManager.viewport
/* 209 */           .getWorldHeight());
/*     */       
/* 211 */       this.g.setPosition(
/* 212 */           -Game.i.uiManager.getScreenSafeMargin(), 0.0F);
/*     */ 
/*     */       
/* 215 */       this.S._gameUi.mainUi.customElementsContainer.addActor((Actor)this.g);
/*     */       
/*     */       ImageWithParentColor imageWithParentColor;
/*     */       
/* 219 */       (imageWithParentColor = new ImageWithParentColor((Drawable)Game.i.assetManager.getDrawable("blizzard-screen-border@flip-x"))).setSize(195.0F, 453.0F);
/* 220 */       imageWithParentColor.setColor(MaterialColor.LIGHT_BLUE.P100);
/* 221 */       this.g.addActor((Actor)imageWithParentColor);
/*     */ 
/*     */       
/* 224 */       (imageWithParentColor = new ImageWithParentColor((Drawable)Game.i.assetManager.getDrawable("blizzard-screen-border"))).setSize(195.0F, 453.0F);
/* 225 */       imageWithParentColor.setColor(MaterialColor.LIGHT_BLUE.P100);
/* 226 */       imageWithParentColor.setPosition(Game.i.uiManager.viewport.getWorldWidth() - 195.0F, 0.0F);
/* 227 */       this.g.addActor((Actor)imageWithParentColor);
/*     */       
/* 229 */       this.g.addAction((Action)Actions.sequence(
/* 230 */             (Action)Actions.alpha(0.0F), 
/* 231 */             (Action)Actions.fadeIn(0.1F)));
/*     */     } 
/*     */ 
/*     */     
/* 235 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && this.S._gameUi != null) {
/* 236 */       this.h = (ParticleEffectPool.PooledEffect)BlizzardAbilityFactory.a(Game.i.abilityManager.F.BLIZZARD).obtain();
/* 237 */       this.i = (ParticleEffectPool.PooledEffect)BlizzardAbilityFactory.a(Game.i.abilityManager.F.BLIZZARD).obtain();
/*     */       
/* 239 */       this.S._gameUi.mainUi.particlesCanvas.addParticle((ParticleEffect)this.h, -Game.i.uiManager.getScreenSafeMargin(), 0.0F);
/* 240 */       this.S._gameUi.mainUi.particlesCanvas.addParticle((ParticleEffect)this.i, Game.i.uiManager.viewport.getWorldWidth() + Game.i.uiManager.getScreenSafeMargin(), 0.0F);
/*     */     } 
/* 242 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float paramFloat) {
/* 247 */     this.d -= paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 252 */     return (this.d <= 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDone() {
/* 257 */     if (this.g != null) {
/* 258 */       this.g.clearActions();
/* 259 */       this.g.addAction((Action)Actions.sequence(
/* 260 */             (Action)Actions.fadeOut(0.3F), 
/* 261 */             (Action)Actions.removeActor()));
/*     */     } 
/*     */     
/* 264 */     if (this.h != null) {
/* 265 */       this.h.allowCompletion();
/* 266 */       this.h = null;
/*     */       
/* 268 */       this.i.allowCompletion();
/* 269 */       this.i = null;
/*     */     } 
/* 271 */     this.S.events.getListeners(EnemySpawn.class).remove(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleEvent(EnemySpawn paramEnemySpawn) {
/*     */     FreezingBuff freezingBuff;
/* 282 */     (freezingBuff = new FreezingBuff()).setup(null, 10.0F, 100.0F, this.d, this.d * 10.0F, 0.0F, 0.0F);
/* 283 */     this.S.buff.P_FREEZING.addBuff(paramEnemySpawn.getEnemy(), freezingBuff);
/*     */   }
/*     */   
/*     */   public static class BlizzardAbilityFactory extends Ability.Factory<BlizzardAbility> {
/*     */     private ParticleEffectPool a;
/*     */     
/*     */     public BlizzardAbilityFactory(AbilityType param1AbilityType) {
/* 290 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public BlizzardAbility create() {
/* 295 */       return new BlizzardAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 300 */       super.setupAssets();
/*     */       
/* 302 */       this.a = Game.i.assetManager.getParticleEffectPool("blizzard.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 307 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 312 */       return MaterialColor.CYAN.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 317 */       float f = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_BLIZZARD_DURATION);
/* 318 */       int i = (int)StrictMath.round(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_BLIZZARD_BONUS_DAMAGE) * 100.0D);
/*     */       
/* 320 */       String str2 = Game.i.localeManager.i18n.format("ability_description_BLIZZARD", new Object[] { Float.valueOf(f), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(MathUtils.round(65.0F)), Integer.valueOf(20) });
/* 321 */       String str1 = Game.i.localeManager.i18n.format("ability_frozen_enemies_damage_bonus", new Object[] { Integer.valueOf(i) });
/* 322 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 327 */       return MaterialColor.CYAN.P700;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 332 */       return BlizzardAbility.a()[StrictMath.min(param1Int, (BlizzardAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 337 */       return BlizzardAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (BlizzardAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 342 */       return Game.i.assetManager.getDrawable("icon-blizzard");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\BlizzardAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */