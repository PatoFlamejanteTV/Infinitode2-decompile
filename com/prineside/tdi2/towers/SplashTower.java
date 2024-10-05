/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.projectiles.SplashProjectile;
/*     */ import com.prineside.tdi2.utils.DrawUtils;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ @REGS
/*     */ public final class SplashTower
/*     */   extends Tower {
/*  43 */   private static final float e = (new Color(-7707137)).toFloatBits();
/*     */   
/*     */   public static final int ABILITY_PENETRATING_BULLETS = 0;
/*     */   
/*     */   public static final int ABILITY_FAST_MECHANISM = 1;
/*     */   
/*     */   public static final int ABILITY_FAST_BULLETS = 2;
/*     */   
/*  51 */   public static final String[] ABILITY_ALIASES = new String[] { "PENETRATING_BULLETS", "FAST_MECHANISM", "FAST_BULLETS" };
/*     */ 
/*     */   
/*     */   private boolean f = false;
/*     */ 
/*     */   
/*     */   private float g;
/*     */   
/*  59 */   private int h = 0;
/*     */   
/*     */   private float i;
/*     */   
/*     */   private int j;
/*     */   
/*     */   private float k;
/*     */   private float l;
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte m;
/*     */   private float n;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  72 */     super.write(paramKryo, paramOutput);
/*  73 */     paramOutput.writeBoolean(this.f);
/*  74 */     paramOutput.writeFloat(this.g);
/*  75 */     paramOutput.writeVarInt(this.h, true);
/*  76 */     paramOutput.writeFloat(this.i);
/*  77 */     paramOutput.writeVarInt(this.j, true);
/*  78 */     paramOutput.writeFloat(this.k);
/*  79 */     paramOutput.writeFloat(this.l);
/*  80 */     paramOutput.writeByte(this.m);
/*  81 */     paramOutput.writeFloat(this.n);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  86 */     super.read(paramKryo, paramInput);
/*  87 */     this.f = paramInput.readBoolean();
/*  88 */     this.g = paramInput.readFloat();
/*  89 */     this.h = paramInput.readVarInt(true);
/*  90 */     this.i = paramInput.readFloat();
/*  91 */     this.j = paramInput.readVarInt(true);
/*  92 */     this.k = paramInput.readFloat();
/*  93 */     this.l = paramInput.readFloat();
/*  94 */     this.m = paramInput.readByte();
/*  95 */     this.n = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private SplashTower() {
/*  99 */     super(TowerType.SPLASH);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/* 104 */     return Game.i.towerManager.F.SPLASH.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 116 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getAttackDelay() {
/* 124 */     return this.n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 131 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 133 */     if (paramTowerStatType == TowerStatType.DAMAGE && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_FAST_BULLETS_DAMAGE)); 
/* 134 */     if (paramTowerStatType == TowerStatType.ATTACK_SPEED && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_FAST_MECHANISM_SPEED)); 
/* 135 */     if (paramTowerStatType == TowerStatType.PROJECTILE_SPEED && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_FAST_BULLETS_SPEED)); 
/* 136 */     if (paramTowerStatType == TowerStatType.U_PIERCING && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_PENETRATING_DAMAGE_CHAIN));
/*     */     
/* 138 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateCache() {
/* 143 */     super.updateCache();
/*     */     
/* 145 */     this.i = getStat(TowerStatType.U_PROJECTILE_COUNT);
/*     */     
/* 147 */     float f = getStat(TowerStatType.ATTACK_SPEED);
/* 148 */     this.n = 1.0F / f / this.i;
/* 149 */     this.j = (int)this.i;
/*     */     
/* 151 */     if (isAbilityInstalled(0)) {
/*     */       
/* 153 */       this.k = 26.0F;
/* 154 */       this.l = 6.0F; return;
/*     */     } 
/* 156 */     this.k = 22.0F;
/* 157 */     this.l = 8.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawWeapon(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 165 */     super.drawWeapon(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */     
/* 167 */     if ((getTile()).visibleOnScreen && !isOutOfOrder() && 
/* 168 */       (paramBatch.getColor()).a == 1.0F) {
/* 169 */       Vector2 vector2 = new Vector2();
/* 170 */       float f1 = paramFloat3 / 128.0F;
/*     */       
/* 172 */       float f2 = 360.0F / this.j;
/* 173 */       for (byte b = 0; b < this.j; b++) {
/* 174 */         float f = b * f2 + this.angle;
/*     */         
/* 176 */         PMath.getPointByAngleFromPoint(paramFloat1 + paramFloat3 * 0.5F, paramFloat2 + paramFloat3 * 0.5F, f, this.k * f1, vector2);
/* 177 */         DrawUtils.texturedLineC(paramBatch, Game.i.towerManager.F.SPLASH.c, paramFloat1 + paramFloat3 * 0.5F, paramFloat2 + paramFloat3 * 0.5F, vector2.x, vector2.y, this.l * f1, e, e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 185 */     super.drawBatch(paramBatch, paramFloat);
/*     */ 
/*     */     
/* 188 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_BUILDING_INFO) != 0.0D) {
/*     */       BitmapFont bitmapFont;
/* 190 */       (bitmapFont = Game.i.assetManager.getDebugFont(false)).draw(paramBatch, "TSS: " + this.g, (getTile()).boundingBox.minX, (getTile()).boundingBox.minY - 20.0F + 64.0F, 128.0F, 1, false);
/* 191 */       bitmapFont.setColor(Color.WHITE);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 197 */     if (isOutOfOrder()) {
/* 198 */       super.update(paramFloat);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 203 */     this.m = (byte)(this.m + 1);
/* 204 */     if (this.m == 3) {
/* 205 */       this.m = 0;
/*     */ 
/*     */       
/* 208 */       this.f = false;
/* 209 */       this.S.map.getEnemiesInCircleV((getTile()).center, this.rangeInPixels, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */             if (paramEnemyReference.enemy != null && canAttackEnemy(paramEnemyReference.enemy)) {
/*     */               this.f = true;
/*     */               
/*     */               return false;
/*     */             } 
/*     */             
/*     */             return true;
/*     */           });
/*     */     } 
/* 219 */     this.g += paramFloat;
/*     */     
/* 221 */     if (this.f) {
/* 222 */       this.angle += 45.0F * paramFloat;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 227 */       Vector2 vector21 = new Vector2();
/* 228 */       Vector2 vector22 = new Vector2();
/* 229 */       float f1 = getStat(TowerStatType.DAMAGE);
/* 230 */       float f2 = getStat(TowerStatType.PROJECTILE_SPEED);
/* 231 */       while (this.g > this.n)
/*     */       {
/* 233 */         this.h++;
/* 234 */         if (this.h >= this.j) this.h = 0;
/*     */         
/* 236 */         float f = this.h * 360.0F / this.j + this.angle;
/*     */         
/* 238 */         vector21.set((getTile()).center);
/* 239 */         PMath.shiftPointByAngle(vector21, f, this.k + 1.0F);
/*     */         
/* 241 */         vector22.set((getTile()).center);
/* 242 */         PMath.shiftPointByAngle(vector22, f, this.rangeInPixels);
/*     */         
/* 244 */         SplashProjectile splashProjectile = (SplashProjectile)this.S.projectile.F.SPLASH.obtain();
/* 245 */         this.S.projectile.register((Projectile)splashProjectile);
/* 246 */         splashProjectile.setup(this, f1, vector21, vector22, f2);
/* 247 */         splashProjectile.chainKillGeneration = 0;
/*     */         
/* 249 */         if (this.S._particle != null) {
/* 250 */           this.S._particle.addFlashParticle((TextureRegion)(AssetManager.TextureRegions.i()).muzzleFlashSmall, vector21.x, vector21.y, 9.6F, 3.6000001F, 19.2F, 28.800001F, f);
/*     */         }
/*     */         
/* 253 */         this.shotCount++;
/*     */         
/* 255 */         this.g -= this.n;
/*     */         
/* 257 */         if (this.S._sound != null) {
/* 258 */           this.S._sound.playShotSound(StaticSoundType.SHOT_SPLASH, this);
/*     */         
/*     */         }
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 266 */       this.g = getAttackDelay() / this.i;
/*     */     } 
/*     */     
/* 269 */     super.update(paramFloat);
/*     */   }
/*     */   
/*     */   public static void triggerChainReaction(GameSystemProvider paramGameSystemProvider, SplashTower paramSplashTower, SplashProjectile paramSplashProjectile) {
/* 273 */     if (paramSplashTower.isAbilityInstalled(4) && paramSplashProjectile.chainKillGeneration < paramGameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_SPLASH_A_ULTIMATE_MAX_CHAIN_LENGTH)) {
/* 274 */       Vector2 vector21 = new Vector2();
/* 275 */       Vector2 vector22 = new Vector2();
/* 276 */       Vector2 vector23 = new Vector2();
/* 277 */       int i = paramGameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_SPLASH_A_ULTIMATE_SPLINTERS);
/* 278 */       float f = 1.0F;
/* 279 */       if (paramSplashProjectile.chainKillGeneration == 0) {
/* 280 */         f = (float)(1.0D * paramGameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_ULTIMATE_BASE_DAMAGE));
/*     */       }
/*     */       
/* 283 */       if ((f = paramSplashProjectile.getDamage() * f) > 0.1F) {
/* 284 */         for (byte b = 0; b < i; b++) {
/* 285 */           SplashProjectile splashProjectile = (SplashProjectile)paramGameSystemProvider.projectile.F.SPLASH.obtain();
/* 286 */           paramGameSystemProvider.projectile.register((Projectile)splashProjectile);
/*     */           
/* 288 */           float f1 = paramGameSystemProvider.gameState.randomFloat() * 6.2831855F;
/* 289 */           vector23.set(PMath.cos(f1), PMath.sin(f1));
/*     */           
/* 291 */           vector23.scl(51.2F);
/* 292 */           vector21.set(vector23).add(paramSplashProjectile.position.x, paramSplashProjectile.position.y);
/*     */           
/* 294 */           vector23.scl(13.0F);
/* 295 */           vector22.set(vector23).add(paramSplashProjectile.position.x, paramSplashProjectile.position.y);
/*     */           
/* 297 */           splashProjectile.setup(paramSplashTower, f, vector21, vector22, 2.0F);
/* 298 */           paramSplashProjectile.chainKillGeneration++;
/* 299 */           splashProjectile.hitCount = (byte)(paramSplashProjectile.hitCount + 1);
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 308 */       paramGameSystemProvider.achievement.setProgress(AchievementType.SPLASH_CHAIN_KILL, paramSplashProjectile.chainKillGeneration + 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnEnemyDie extends SerializableListener<GameSystemProvider> implements Listener<EnemyDie> {
/*     */     private OnEnemyDie() {}
/*     */     
/*     */     public OnEnemyDie(GameSystemProvider param1GameSystemProvider) {
/* 317 */       this.a = param1GameSystemProvider;
/*     */     }
/*     */     
/*     */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*     */       DamageRecord damageRecord;
/*     */       Projectile projectile;
/*     */       Tower tower;
/* 324 */       if (tower = (damageRecord = param1EnemyDie.getLastDamage()).getTower() instanceof SplashTower && 
/*     */         
/* 326 */         projectile = damageRecord.getProjectile() instanceof SplashProjectile)
/* 327 */         SplashTower.triggerChainReaction((GameSystemProvider)this.a, (SplashTower)tower, (SplashProjectile)projectile); 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SplashTowerFactory
/*     */     extends Tower.Factory<SplashTower>
/*     */   {
/*     */     TextureRegion c;
/*     */     
/*     */     public SplashTowerFactory() {
/* 337 */       super("tower-splash", TowerType.SPLASH);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 342 */       super.setup();
/*     */       
/* 344 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "0.9", "50" };
/* 345 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "1.25" };
/* 346 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "1.25", "1.25", "", "" };
/* 347 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "1.1", "0.8" };
/* 348 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "5", "", "", "" };
/*     */     }
/*     */ 
/*     */     
/*     */     public void configureSystems(GameSystemProvider param1GameSystemProvider) {
/* 353 */       param1GameSystemProvider.events.getListeners(EnemyDie.class).addStateAffecting(new SplashTower.OnEnemyDie(param1GameSystemProvider));
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 358 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("blank");
/*     */     }
/*     */     
/*     */     @Null
/*     */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/* 363 */       if (param1TowerStatType == TowerStatType.U_PIERCING) {
/* 364 */         return Game.i.localeManager.i18n.get("tower_stat_more_info_SPLASH_U_PIERCING");
/*     */       }
/* 366 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 374 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_PENETRATING_DAMAGE_CHAIN), 2, true).toString();
/*     */       
/* 376 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_FAST_MECHANISM_SPEED), 2, true).toString();
/*     */       
/* 378 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_FAST_BULLETS_DAMAGE), 2, true).toString();
/* 379 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_FAST_BULLETS_SPEED), 2, true).toString();
/* 380 */       (arrayOfAbilityConfig[2]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SPLASH_A_FAST_BULLETS_BONUS_XP), 2, true).toString();
/* 381 */       (arrayOfAbilityConfig[2]).descriptionArgs[3] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SPLASH_A_FAST_BULLETS_BONUS_XP_DURATION), 2, true).toString();
/*     */       
/* 383 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_RIFFLED_DAMAGE), 2, true).toString();
/* 384 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SPLASH_A_RIFFLED_SPEED_MARK), 2, true).toString();
/*     */       
/* 386 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SPLASH_A_ULTIMATE_ON_HIT_CHANCE), false).toString();
/* 387 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SPLASH_A_ULTIMATE_SPLINTERS), false).toString();
/* 388 */       (arrayOfAbilityConfig[4]).descriptionArgs[2] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_SPLASH_A_ULTIMATE_BASE_DAMAGE), false).toString();
/* 389 */       (arrayOfAbilityConfig[4]).descriptionArgs[3] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_SPLASH_A_ULTIMATE_MAX_CHAIN_LENGTH), false).toString();
/*     */       
/* 391 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 397 */       if (param1Int == 0) {
/* 398 */         return false;
/*     */       }
/* 400 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 405 */       return 47;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 409 */       return MaterialColor.DEEP_ORANGE.P500;
/*     */     }
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 413 */       switch (SplashTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 414 */           return 4;
/* 415 */         case 2: return 5;
/* 416 */         case 3: return 3;
/* 417 */         case 4: return 3;
/* 418 */         case 5: return 2; }
/* 419 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 425 */       return SplashTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public SplashTower create() {
/* 430 */       return new SplashTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\SplashTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */