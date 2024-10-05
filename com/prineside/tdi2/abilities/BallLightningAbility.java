/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.projectiles.ChainLightningProjectile;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.shapes.ChainLightning;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.FloatSorter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class BallLightningAbility
/*     */   extends Ability
/*     */ {
/*     */   public static final float DEFAULT_ATTACK_INTERVAL = 0.2F;
/*  54 */   private static final int[] b = new int[] { 100, 125, 150, 175, 250, 300, 400, 550, 750, 875, 1000 };
/*     */ 
/*     */   
/*  57 */   private static final int[][] c = new int[][] { { 5, 10, 25, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 5, 15, 30, 0, 0, 0, 0, 0, 250 }, { 0, 0, 0, 0, 10, 25, 40, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 10, 20, 60, 0, 150 }, { 0, 0, 0, 0, 0, 0, 0, 10, 20, 75, 0 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   private Vector2 d = new Vector2();
/*  66 */   private Vector2 e = new Vector2(); @NAGS
/*  67 */   private final Vector2 f = new Vector2();
/*  68 */   private Enemy.EnemyReference g = Enemy.EnemyReference.NULL;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float duration;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float damage;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public Tower launchedByTower;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   public float attackInterval = 0.2F;
/*     */   
/*     */   private float h;
/*  92 */   private float i = 0.0F;
/*  93 */   private DelayedRemovalArray<Enemy.EnemyReference> j = new DelayedRemovalArray(false, 4, Enemy.EnemyReference.class);
/*  94 */   private int k = 0;
/*     */   @NAGS
/*  96 */   private final DelayedRemovalArray<ChainLightning> l = new DelayedRemovalArray(false, 8, ChainLightning.class);
/*     */   
/*  98 */   private static final Color m = new Color();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 102 */     super.write(paramKryo, paramOutput);
/*     */     
/* 104 */     paramKryo.writeObject(paramOutput, this.d);
/* 105 */     paramKryo.writeObject(paramOutput, this.e);
/* 106 */     paramKryo.writeObject(paramOutput, this.g);
/* 107 */     paramOutput.writeFloat(this.duration);
/* 108 */     paramOutput.writeFloat(this.damage);
/* 109 */     paramKryo.writeClassAndObject(paramOutput, this.launchedByTower);
/* 110 */     paramOutput.writeFloat(this.attackInterval);
/* 111 */     paramOutput.writeFloat(this.h);
/* 112 */     paramOutput.writeFloat(this.i);
/* 113 */     paramKryo.writeObject(paramOutput, this.j);
/* 114 */     paramOutput.writeVarInt(this.k, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 119 */     super.read(paramKryo, paramInput);
/* 120 */     this.d = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/* 121 */     this.e = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/* 122 */     this.g = (Enemy.EnemyReference)paramKryo.readObject(paramInput, Enemy.EnemyReference.class);
/* 123 */     this.duration = paramInput.readFloat();
/* 124 */     this.damage = paramInput.readFloat();
/* 125 */     this.launchedByTower = (Tower)paramKryo.readClassAndObject(paramInput);
/* 126 */     this.attackInterval = paramInput.readFloat();
/* 127 */     this.h = paramInput.readFloat();
/* 128 */     this.i = paramInput.readFloat();
/* 129 */     this.j = (DelayedRemovalArray<Enemy.EnemyReference>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/* 130 */     this.k = paramInput.readVarInt(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void configure(int paramInt1, int paramInt2, double paramDouble) {
/* 135 */     this.duration = this.S.gameValue.getFloatValue(GameValueType.ABILITY_BALL_LIGHTNING_DURATION);
/* 136 */     this.i = 0.0F;
/* 137 */     this.h = 0.0F;
/* 138 */     this.launchedByTower = null;
/*     */     
/* 140 */     this.damage = (float)(this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_BALL_LIGHTNING_DAMAGE) * paramDouble);
/* 141 */     this.d.set(paramInt1, paramInt2);
/* 142 */     this.a = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_BALL_LIGHTNING_COINS);
/*     */   }
/*     */   
/*     */   private BallLightningAbility() {
/* 146 */     super(AbilityType.BALL_LIGHTNING);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean start() {
/* 151 */     if (this.damage <= 0.0F) {
/* 152 */       if (this.S._gameUi != null) {
/* 153 */         Notifications.i().add(Game.i.localeManager.i18n.get("ability_cant_start_zero_damage"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */       }
/* 155 */       return false;
/*     */     } 
/*     */     
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 163 */     this.h += paramFloat;
/*     */     
/* 165 */     if (this.launchedByTower != null && !this.launchedByTower.isRegistered()) {
/*     */       
/* 167 */       this.launchedByTower = null;
/* 168 */       this.h = this.duration;
/*     */       
/*     */       return;
/*     */     } 
/* 172 */     if (this.g.enemy == null) {
/* 173 */       float f = Float.MAX_VALUE;
/* 174 */       Enemy enemy = null;
/*     */       
/* 176 */       for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*     */         Enemy enemy1;
/* 178 */         if ((enemy1 = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null)
/*     */         {
/* 180 */           if (enemy1.isVulnerableTo(DamageType.ELECTRICITY) && (
/* 181 */             this.launchedByTower == null || this.launchedByTower.canAttackEnemy(enemy1)))
/*     */           {
/*     */ 
/*     */             
/* 185 */             if (enemy == null) {
/* 186 */               enemy = enemy1;
/*     */             } else {
/*     */               float f1;
/* 189 */               if ((f1 = this.d.dst2(enemy1.getPosition())) < f) {
/* 190 */                 enemy = enemy1;
/* 191 */                 f = f1;
/*     */               } 
/*     */             }  } 
/*     */         }
/*     */       } 
/* 196 */       if (enemy != null) {
/* 197 */         this.g = this.S.enemy.getReference(enemy);
/*     */       }
/*     */     } 
/*     */     
/* 201 */     if (this.g.enemy != null) {
/*     */       
/* 203 */       this.f.set(this.g.enemy.getPosition());
/* 204 */       this.f.sub(this.d);
/* 205 */       this.f.nor();
/* 206 */       this.f.scl(10.0F * paramFloat);
/*     */       
/* 208 */       this.e.add(this.f);
/* 209 */       this.e.limit2(100.0F);
/*     */     } else {
/*     */       
/* 212 */       this.e.scl(0.9F);
/*     */     } 
/*     */     
/* 215 */     this.d.add(this.e);
/*     */ 
/*     */     
/* 218 */     this.i += paramFloat;
/* 219 */     if (this.i >= this.attackInterval) {
/* 220 */       this.i -= this.attackInterval;
/*     */ 
/*     */       
/* 223 */       this.j.begin();
/* 224 */       for (byte b = 0; b < this.j.size; b++) {
/* 225 */         if ((((Enemy.EnemyReference[])this.j.items)[b]).enemy == null) {
/* 226 */           this.j.removeIndex(b);
/*     */         }
/*     */       } 
/* 229 */       this.j.end();
/*     */       
/* 231 */       if (this.j.size < 3 && this.j.size < this.S.map.spawnedEnemies.size) {
/*     */         FloatSorter floatSorter;
/*     */         
/* 234 */         (floatSorter = this.S.TSH.floatSorter).begin();
/* 235 */         for (byte b1 = 0; b1 < this.S.map.spawnedEnemies.size; b1++) {
/*     */           Enemy.EnemyReference enemyReference;
/*     */           Enemy enemy;
/* 238 */           if ((enemy = (enemyReference = ((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b1]).enemy) != null) {
/* 239 */             floatSorter.add(enemyReference, this.d.dst2(enemy.getPosition()));
/*     */           }
/*     */         } 
/* 242 */         Array array = floatSorter.sort();
/* 243 */         for (byte b2 = 0; b2 < array.size; b2++) {
/*     */           Enemy.EnemyReference enemyReference;
/*     */           Enemy enemy;
/* 246 */           if ((enemy = (enemyReference = (Enemy.EnemyReference)(((FloatSorter.Entity[])array.items)[b2]).object).enemy).getAbilityVulnerability(AbilityType.BALL_LIGHTNING) != 0.0F && 
/* 247 */             enemy.isVulnerableTo(DamageType.ELECTRICITY) && (
/* 248 */             this.launchedByTower == null || this.launchedByTower.canAttackEnemy(enemy))) {
/*     */             
/* 250 */             boolean bool = false;
/* 251 */             for (byte b3 = 0; b3 < this.j.size; b3++) {
/* 252 */               if ((((Enemy.EnemyReference[])this.j.items)[b3]).enemy == enemy) {
/* 253 */                 bool = true;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/* 258 */             if (!bool)
/* 259 */             { this.j.add(enemyReference);
/* 260 */               if (this.j.size != 3)
/*     */                 continue;  break; } 
/*     */           }  continue;
/* 263 */         }  floatSorter.end();
/*     */       } 
/*     */ 
/*     */       
/* 267 */       if (this.j.size != 0) {
/* 268 */         if (this.k >= this.j.size) {
/* 269 */           this.k = 0;
/*     */         }
/*     */         
/* 272 */         Enemy enemy = (((Enemy.EnemyReference[])this.j.items)[this.k]).enemy;
/* 273 */         ChainLightningProjectile chainLightningProjectile = (ChainLightningProjectile)this.S.projectile.F.CHAIN_LIGHTNING.obtain();
/* 274 */         this.S.projectile.register((Projectile)chainLightningProjectile);
/*     */         float f;
/* 276 */         if ((f = this.damage * enemy.getAbilityVulnerability(AbilityType.BALL_LIGHTNING)) > 0.0F)
/*     */         {
/* 278 */           chainLightningProjectile.setup(this.launchedByTower, enemy, f, f * 0.1F, 0.0F, 0.0F, this.d);
/*     */         }
/*     */         
/* 281 */         this.k++;
/*     */       } 
/*     */     } 
/*     */     
/* 285 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && this.S._gameUi != null) {
/*     */       
/* 287 */       if (this.h < this.duration) {
/*     */         
/* 289 */         int i = FastRandom.getInt(3) + 1;
/* 290 */         for (byte b1 = 0; b1 < i; b1++) {
/*     */           ChainLightning chainLightning;
/* 292 */           (chainLightning = (ChainLightning)Game.i.shapeManager.F.CHAIN_LIGHTNING.obtain()).setTexture(BallLightningAbilityFactory.a(Game.i.abilityManager.F.BALL_LIGHTNING), true, true);
/*     */           
/* 294 */           m.set(MaterialColor.LIGHT_BLUE.P200);
/* 295 */           m.a = 0.56F;
/* 296 */           chainLightning.setFadingToEnd(true);
/* 297 */           chainLightning.setColor(m);
/* 298 */           chainLightning.setup(this.d.x, this.d.y, this.d.x + (FastRandom.getFloat() - 0.5F) * 2.0F * 100.0F, this.d.y + (FastRandom.getFloat() - 0.5F) * 2.0F * 100.0F, 2.0F, 0.1F, false, 6.7200003F, 33.6F, 8.0F);
/* 299 */           this.l.add(chainLightning);
/*     */         } 
/*     */       } 
/*     */       
/* 303 */       this.l.begin();
/* 304 */       for (byte b = 0; b < this.l.size; b++) {
/*     */         ChainLightning chainLightning;
/* 306 */         (chainLightning = ((ChainLightning[])this.l.items)[b]).update(paramFloat);
/* 307 */         if (chainLightning.isFinished()) {
/* 308 */           this.l.removeIndex(b);
/* 309 */           chainLightning.free();
/*     */         } 
/*     */       } 
/* 312 */       this.l.end();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDone() {
/* 318 */     return (this.h >= this.duration + 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawBatchAdditive(Batch paramBatch, float paramFloat) {
/* 328 */     paramFloat = 1.0F;
/* 329 */     if (this.h >= this.duration && (
/*     */       
/* 331 */       paramFloat = 1.0F - (this.h - this.duration) / 0.5F) < 0.0F) paramFloat = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 335 */     m.set(MaterialColor.LIGHT_BLUE.P200);
/* 336 */     m.a = (0.16F + PMath.sin(this.h * 5.0F) * 0.04F) * paramFloat;
/* 337 */     paramBatch.setColor(m);
/* 338 */     paramBatch.draw(BallLightningAbilityFactory.b(Game.i.abilityManager.F.BALL_LIGHTNING), this.d.x - 192.0F, this.d.y - 192.0F, 384.0F, 384.0F);
/*     */     
/* 340 */     m.set(1.0F, 1.0F, 1.0F, paramFloat);
/* 341 */     paramBatch.setColor(m);
/* 342 */     paramBatch.draw(BallLightningAbilityFactory.c(Game.i.abilityManager.F.BALL_LIGHTNING), this.d.x - 32.0F, this.d.y - 32.0F, 64.0F, 64.0F);
/*     */     
/* 344 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */ 
/*     */     
/* 347 */     for (byte b = 0; b < this.l.size; b++)
/* 348 */       ((ChainLightning[])this.l.items)[b].draw(paramBatch); 
/*     */   }
/*     */   
/*     */   public static class BallLightningAbilityFactory
/*     */     extends Ability.Factory<BallLightningAbility> {
/*     */     private TextureRegion a;
/*     */     private TextureRegion b;
/*     */     private TextureRegion c;
/*     */     
/*     */     public BallLightningAbilityFactory(AbilityType param1AbilityType) {
/* 358 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 363 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("ball-lightning-orb");
/* 364 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("particle-default");
/* 365 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("chain-lightning");
/*     */     }
/*     */ 
/*     */     
/*     */     public BallLightningAbility create() {
/* 370 */       return new BallLightningAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 375 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 380 */       return MaterialColor.YELLOW.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 385 */       float f1 = MathUtils.round((float)param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_BALL_LIGHTNING_DAMAGE) * 1000.0F) / 10.0F;
/* 386 */       float f2 = param1GameValueProvider.getFloatValue(GameValueType.ABILITY_BALL_LIGHTNING_DURATION);
/* 387 */       int i = (int)StrictMath.round(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_BALL_LIGHTNING_COINS) * 100.0D);
/*     */       
/* 389 */       String str2 = Game.i.localeManager.i18n.format("ability_description_BALL_LIGHTNING", new Object[] { Integer.valueOf(3), Float.valueOf(0.6F), Float.valueOf(f1), Float.valueOf(f2) });
/* 390 */       String str1 = Game.i.localeManager.i18n.format("ability_coins_for_killed_enemies", new Object[] { Integer.valueOf(i) });
/* 391 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 396 */       return MaterialColor.YELLOW.P800;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 401 */       return BallLightningAbility.a()[StrictMath.min(param1Int, (BallLightningAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 406 */       return BallLightningAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (BallLightningAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 411 */       return Game.i.assetManager.getDrawable("icon-ball-lightning");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\BallLightningAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */