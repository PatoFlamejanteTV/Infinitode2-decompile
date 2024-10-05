/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.components.PowerBonuses;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.projectiles.BasicProjectile;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ @REGS
/*     */ public final class BasicTower
/*     */   extends Tower {
/*     */   public static final int ABILITY_FOUNDATION = 2;
/*  40 */   public static final String[] ABILITY_ALIASES = new String[] { "DOUBLE_GUN", "LARGE_CALIBER", "FOUNDATION" };
/*     */ 
/*     */   
/*     */   private int e;
/*     */ 
/*     */   
/*     */   private boolean f;
/*     */   
/*     */   private DelayedRemovalArray<Tower> g;
/*     */   
/*     */   @FrameAccumulatorForPerformance
/*     */   private byte h;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  55 */     super.write(paramKryo, paramOutput);
/*  56 */     paramOutput.writeVarInt(this.e, true);
/*  57 */     paramOutput.writeBoolean(this.f);
/*  58 */     paramKryo.writeObjectOrNull(paramOutput, this.g, DelayedRemovalArray.class);
/*  59 */     paramOutput.writeByte(this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  64 */     super.read(paramKryo, paramInput);
/*  65 */     this.e = paramInput.readVarInt(true);
/*  66 */     this.f = paramInput.readBoolean();
/*  67 */     this.g = (DelayedRemovalArray<Tower>)paramKryo.readObjectOrNull(paramInput, DelayedRemovalArray.class);
/*  68 */     this.h = paramInput.readByte();
/*     */   }
/*     */   
/*     */   private BasicTower() {
/*  72 */     super(TowerType.BASIC);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/*  77 */     if (isAbilityInstalled(0)) {
/*  78 */       return Game.i.towerManager.F.BASIC.getAbilityTextures(0);
/*     */     }
/*  80 */     return Game.i.towerManager.F.BASIC.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getSellPrice() {
/*  86 */     if (isAbilityInstalled(3)) {
/*  87 */       this.moneySpentOn -= this.e;
/*  88 */       int i = super.getSellPrice();
/*  89 */       this.moneySpentOn += this.e;
/*     */       
/*  91 */       return this.e + i;
/*     */     } 
/*  93 */     return super.getSellPrice();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void addExperience(float paramFloat) {
/*  99 */     if (this.g != null && this.g.size != 0) {
/*     */       
/* 101 */       int i = a();
/* 102 */       if (this.g == null) {
/*     */         
/* 104 */         super.addExperience(paramFloat);
/*     */       
/*     */       }
/* 107 */       else if (i == 0) {
/*     */         
/* 109 */         paramFloat /= this.g.size;
/* 110 */         b(paramFloat);
/*     */       } else {
/*     */         
/* 113 */         paramFloat /= i;
/* 114 */         a(paramFloat);
/*     */         return;
/*     */       } 
/*     */     } else {
/* 118 */       super.addExperience(paramFloat);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int a() {
/* 128 */     byte b1 = 0;
/*     */     
/* 130 */     this.g.begin();
/* 131 */     for (byte b2 = 0; b2 < this.g.size; b2++) {
/*     */       Tower tower;
/* 133 */       if (!(tower = ((Tower[])this.g.items)[b2]).isRegistered()) {
/*     */         
/* 135 */         this.g.removeIndex(b2);
/* 136 */       } else if (tower.getLevel() < tower.getMaxTowerLevel()) {
/* 137 */         b1++;
/*     */       } 
/*     */     } 
/* 140 */     this.g.end();
/*     */     
/* 142 */     if (this.g.size == 0) {
/*     */       
/* 144 */       this.g = null;
/* 145 */       return 0;
/*     */     } 
/* 147 */     return b1;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(float paramFloat) {
/* 152 */     this.g.begin();
/* 153 */     for (byte b = 0; b < this.g.size; b++) {
/*     */       Tower tower;
/* 155 */       if ((tower = ((Tower[])this.g.items)[b]).getLevel() < tower.getMaxTowerLevel()) {
/* 156 */         this.S.experience.addExperienceRaw(tower, paramFloat);
/* 157 */         if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && !this.S.gameState.canSkipMediaUpdate() && tower.getTile() != null) {
/* 158 */           this.S._particle.addXpOrbParticle(paramFloat, getTile().getX(), getTile().getY(), tower.getTile().getX(), tower.getTile().getY());
/*     */         }
/*     */       } 
/*     */     } 
/* 162 */     this.g.end();
/*     */   }
/*     */   
/*     */   private void b(float paramFloat) {
/* 166 */     this.g.begin();
/* 167 */     for (byte b = 0; b < this.g.size; b++) {
/* 168 */       Tower tower = ((Tower[])this.g.items)[b];
/* 169 */       this.S.experience.addExperienceRaw(tower, paramFloat);
/* 170 */       if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing() && !this.S.gameState.canSkipMediaUpdate() && tower.getTile() != null) {
/* 171 */         this.S._particle.addXpOrbParticle(paramFloat, getTile().getX(), getTile().getY(), tower.getTile().getX(), tower.getTile().getY());
/*     */       }
/*     */     } 
/* 174 */     this.g.end();
/*     */   }
/*     */   
/*     */   public final void onAbilitySet(int paramInt, boolean paramBoolean) {
/*     */     float f;
/* 179 */     super.onAbilitySet(paramInt, paramBoolean);
/*     */     
/* 181 */     if (paramInt == 4) {
/*     */       
/* 183 */       paramInt = MathUtils.round(this.S.gameValue.getFloatValue(GameValueType.TOWER_BASIC_A_COPY_COUNT));
/* 184 */       f = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BASIC_A_COPY_UPGRADE_LEVEL);
/*     */ 
/*     */       
/* 187 */       for (byte b = 0; b < paramInt; b++) {
/* 188 */         Array array = this.S.TSH.getTowerArray();
/* 189 */         this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */               PlatformTile platformTile;
/*     */               
/*     */               if (paramTile.type == TileType.PLATFORM && (platformTile = (PlatformTile)paramTile).building != null && platformTile.building.buildingType == BuildingType.TOWER) {
/*     */                 paramArray.add(platformTile.building);
/*     */               }
/*     */               
/*     */               return true;
/*     */             });
/* 198 */         if (array.size == 0)
/*     */         {
/* 200 */           array.add(this);
/*     */         }
/* 202 */         Tower tower = ((Tower[])array.items)[this.S.gameState.randomInt(array.size)];
/* 203 */         this.S.TSH.freeTowerArray(array);
/*     */         
/*     */         byte b1;
/* 206 */         if ((b1 = (byte)MathUtils.floor(tower.getUpgradeLevel() * f)) > 10) {
/* 207 */           b1 = 10;
/*     */         }
/*     */         
/* 210 */         b1 = b1;
/* 211 */         this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */               PlatformTile platformTile;
/*     */               
/*     */               if (paramTile.type == TileType.PLATFORM && (platformTile = (PlatformTile)paramTile).building == null) {
/*     */                 if ((paramTower = this.S.tower.buildTowerIgnorePrice(paramTower.type, this.aimStrategy, paramTile.getX(), paramTile.getY(), true)) != null) {
/*     */                   if (paramByte != 0) {
/*     */                     paramTower.upgradeToLevel(paramByte);
/*     */                   }
/*     */                   
/*     */                   if (this.g == null) {
/*     */                     this.g = new DelayedRemovalArray(true, 2, Tower.class);
/*     */                   }
/*     */                   this.g.add(paramTower);
/*     */                   return false;
/*     */                 } 
/*     */               }
/*     */               return true;
/*     */             });
/*     */       } 
/*     */       return;
/*     */     } 
/* 232 */     if (paramInt == 3 && 
/* 233 */       f != 0.0F) {
/* 234 */       this.e = this.moneySpentOn;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void b() {
/* 240 */     if (isAbilityInstalled(3)) {
/*     */       
/* 242 */       Array array = this.S.TSH.getTowerArray();
/*     */       
/* 244 */       Map map = this.S.map.getMap();
/* 245 */       int i = getTile().getX();
/* 246 */       int j = getTile().getY();
/* 247 */       for (byte b = -1; b <= 1; b++) {
/* 248 */         for (byte b1 = -1; b1 <= 1; b1++) {
/* 249 */           Tile tile; PlatformTile platformTile; Tower tower; if ((b != 0 || b1 != 0) && 
/*     */             
/* 251 */             tile = map.getTile(i + b, j + b1) instanceof PlatformTile && 
/*     */             
/* 253 */             (platformTile = (PlatformTile)tile).building != null && platformTile.building.buildingType == BuildingType.TOWER && 
/*     */             
/* 255 */             (tower = (Tower)platformTile.building).type != TowerType.BASIC) {
/* 256 */             array.add(tower);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 263 */       if (array.size != 0) {
/* 264 */         float f = (getPowerCombinedMultiplier() - 1.0F) / array.size * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BASIC_A_SPECIAL_PWR_SHARE);
/* 265 */         for (byte b1 = 0; b1 < array.size; b1++) {
/*     */           Tower tower;
/* 267 */           if ((tower = ((Tower[])array.items)[b1]).powerBonuses == null) {
/* 268 */             tower.powerBonuses = new PowerBonuses();
/*     */           }
/*     */           
/* 271 */           if (tower.powerBonuses.addOrReplaceBonus(this.id, 0, f)) {
/* 272 */             this.S.map.markTilesDirtyNearTile((Tile)tower.getTile(), 1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 277 */       this.S.TSH.freeTowerArray(array);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/* 285 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 290 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void attack(int paramInt) {
/* 295 */     if (getTarget() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 299 */     Vector2 vector2 = new Vector2();
/* 300 */     PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, this.angle, 28.5F, vector2);
/* 301 */     if (isAbilityInstalled(0)) {
/* 302 */       if (this.f) {
/* 303 */         PMath.getPointByAngleFromPoint(vector2.x, vector2.y, this.angle - 90.0F, 7.0F, vector2);
/*     */       } else {
/* 305 */         PMath.getPointByAngleFromPoint(vector2.x, vector2.y, this.angle + 90.0F, 7.0F, vector2);
/*     */       } 
/* 307 */       this.f = !this.f;
/*     */     } 
/*     */     
/* 310 */     BasicProjectile basicProjectile = (BasicProjectile)this.S.projectile.F.BASIC.obtain();
/* 311 */     this.S.projectile.register((Projectile)basicProjectile);
/* 312 */     basicProjectile.setup(this, getTarget(), getStat(TowerStatType.DAMAGE) * paramInt, vector2, getStat(TowerStatType.PROJECTILE_SPEED));
/*     */     
/* 314 */     if (this.S._particle != null) {
/* 315 */       this.S._particle.addFlashParticle((TextureRegion)(AssetManager.TextureRegions.i()).muzzleFlashSmall, vector2.x, vector2.y, 10.4F, 3.8999999F, 20.8F, 31.199999F, this.angle);
/*     */     }
/*     */     
/* 318 */     this.shotCount += paramInt;
/*     */     
/* 320 */     if (this.S._sound != null) {
/* 321 */       this.S._sound.playShotSound(StaticSoundType.SHOT_BASIC, this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 329 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 331 */     switch (null.a[paramTowerStatType.ordinal()]) {
/*     */       case 1:
/* 333 */         f *= calculateStat(TowerStatType.U_DAMAGE_MULTIPLY) * 0.01F;
/*     */         
/* 335 */         if (isAbilityInstalled(1)) {
/* 336 */           f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BASIC_A_LARGE_CALIBER_DAMAGE));
/*     */         }
/*     */         break;
/*     */       
/*     */       case 2:
/* 341 */         if (isAbilityInstalled(0)) {
/* 342 */           f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BASIC_A_DOUBLE_GUN_ATTACK_SPEED));
/*     */         }
/*     */         break;
/*     */       
/*     */       case 3:
/*     */       case 4:
/* 348 */         if (isAbilityInstalled(2)) {
/* 349 */           f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BASIC_A_FOUNDATION_SPEED));
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 355 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void onPreSell() {
/* 363 */     if (isAbilityInstalled(3)) {
/* 364 */       Array array = this.S.TSH.getTowerArray();
/*     */       
/* 366 */       Map map = this.S.map.getMap();
/* 367 */       int i = getTile().getX();
/* 368 */       int j = getTile().getY(); byte b;
/* 369 */       for (b = -1; b <= 1; b++) {
/* 370 */         for (byte b1 = -1; b1 <= 1; b1++) {
/* 371 */           PlatformTile platformTile; Tile tile; Tower tower; if ((b != 0 || b1 != 0) && 
/*     */             
/* 373 */             tile = map.getTile(i + b, j + b1) instanceof PlatformTile && 
/*     */             
/* 375 */             (platformTile = (PlatformTile)tile).building != null && platformTile.building.buildingType == BuildingType.TOWER && 
/*     */             
/* 377 */             (tower = (Tower)platformTile.building).type != TowerType.BASIC) {
/* 378 */             array.add(tower);
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 385 */       if (array.size != 0) {
/* 386 */         for (b = 0; b < array.size; b++) {
/*     */           Tower tower;
/* 388 */           if ((tower = ((Tower[])array.items)[b]).powerBonuses != null) {
/* 389 */             tower.powerBonuses.removeBonus(this.id);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 398 */     if (isOutOfOrder()) {
/* 399 */       super.update(paramFloat);
/*     */       
/*     */       return;
/*     */     } 
/* 403 */     a(paramFloat, getStat(TowerStatType.ROTATION_SPEED));
/*     */ 
/*     */ 
/*     */     
/* 407 */     this.h = (byte)(this.h + 1);
/* 408 */     if (this.h == 5) {
/* 409 */       this.h = 0;
/*     */       double d;
/* 411 */       if (this.g != null && this.g.size != 0 && 
/* 412 */         getLevel() >= getMaxTowerLevel() && (
/*     */         
/* 414 */         d = (this.experience - Tower.LEVEL_EXPERIENCE_MILESTONES[getLevel()])) >= 1.0D) {
/*     */         
/* 416 */         int i = a();
/* 417 */         if (this.g != null) {
/*     */           
/* 419 */           float f = (float)Math.min(d - 9.999999747378752E-5D, (paramFloat * 5.0F) * 1000.0D);
/* 420 */           if (i == 0) {
/*     */             
/* 422 */             float f1 = f / this.g.size;
/* 423 */             b(f1);
/*     */           } else {
/*     */             
/* 426 */             float f1 = f / i;
/* 427 */             a(f1);
/*     */           } 
/* 429 */           setExperience(this.experience - f);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 434 */       b();
/*     */     } 
/*     */ 
/*     */     
/* 438 */     super.update(paramFloat);
/*     */   }
/*     */   
/*     */   public static class BasicTowerFactory extends Tower.Factory<BasicTower> {
/*     */     public BasicTowerFactory() {
/* 443 */       super("tower-basic", TowerType.BASIC);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 448 */       super.setup();
/*     */       
/* 450 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "" };
/* 451 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "" };
/* 452 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "" };
/* 453 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "" };
/* 454 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "", "" };
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 459 */       return BasicTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 466 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BASIC_A_DOUBLE_GUN_ATTACK_SPEED), 2, true).toString();
/* 467 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BASIC_A_LARGE_CALIBER_DAMAGE), 2, true).toString();
/* 468 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BASIC_A_FOUNDATION_SPEED), 2, true).toString();
/*     */       float f;
/* 470 */       if ((f = param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_BASIC_A_FOUNDATION_RICOCHET_CHANCE)) > 99.0F) {
/* 471 */         f = 99.0F;
/*     */       }
/* 473 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(f, 2, true).toString();
/* 474 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_BASIC_A_COPY_COUNT), false).toString();
/* 475 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_BASIC_A_COPY_UPGRADE_LEVEL), 2, true).toString();
/*     */       
/* 477 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_BASIC_A_SPECIAL_PWR_SHARE), 1, true).toString();
/*     */       
/* 479 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 485 */       if (param1Int == 0) {
/* 486 */         return false;
/*     */       }
/* 488 */       return true;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 492 */       return MaterialColor.TEAL.P500;
/*     */     }
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 496 */       switch (BasicTower.null.b[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 497 */           return 3;
/* 498 */         case 2: return 4;
/* 499 */         case 3: return 3;
/* 500 */         case 4: return 1;
/* 501 */         case 5: return 4; }
/* 502 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 508 */       return 8;
/*     */     }
/*     */ 
/*     */     
/*     */     public BasicTower create() {
/* 513 */       return new BasicTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\BasicTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */