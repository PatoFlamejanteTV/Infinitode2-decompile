/*     */ package com.prineside.tdi2.towers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.enums.UnitType;
/*     */ import com.prineside.tdi2.explosions.CannonExplosion;
/*     */ import com.prineside.tdi2.projectiles.CannonProjectile;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.shapes.PieChart;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.PieChartActor;
/*     */ import com.prineside.tdi2.units.MineUnit;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.MovingAverageFloat;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ @REGS
/*     */ public final class CannonTower
/*     */   extends Tower
/*     */ {
/*     */   public static final int ABILITY_FOUNDATION = 2;
/*  48 */   public static final String[] ABILITY_ALIASES = new String[] { "SHRAPNEL", "LONG_BARREL", "FOUNDATION" };
/*     */ 
/*     */   
/*     */   private float e;
/*     */ 
/*     */   
/*     */   private float f;
/*     */   
/*     */   private float g;
/*     */   
/*  58 */   private MovingAverageFloat h = new MovingAverageFloat(10);
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  62 */     super.write(paramKryo, paramOutput);
/*  63 */     paramOutput.writeFloat(this.e);
/*  64 */     paramOutput.writeFloat(this.f);
/*  65 */     paramOutput.writeFloat(this.g);
/*  66 */     paramKryo.writeObject(paramOutput, this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  71 */     super.read(paramKryo, paramInput);
/*  72 */     this.e = paramInput.readFloat();
/*  73 */     this.f = paramInput.readFloat();
/*  74 */     this.g = paramInput.readFloat();
/*  75 */     this.h = (MovingAverageFloat)paramKryo.readObject(paramInput, MovingAverageFloat.class);
/*     */   }
/*     */   
/*     */   private CannonTower() {
/*  79 */     super(TowerType.CANNON);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/*  84 */     if (isAbilityInstalled(1)) {
/*  85 */       return Game.i.towerManager.F.CANNON.getAbilityTextures(1);
/*     */     }
/*  87 */     return Game.i.towerManager.F.CANNON.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   public final float getRotationSinceShot() {
/* 104 */     return Math.min(180.0F, this.g);
/*     */   }
/*     */   
/*     */   public final float getDamageBonusForFoundationRotation() {
/* 108 */     if (isAbilityInstalled(2)) {
/* 109 */       return getRotationSinceShot() * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_FOUNDATION_DAMAGE_PER_DEG);
/*     */     }
/* 111 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void attack(int paramInt) {
/* 117 */     if (getTarget() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 121 */     Vector2 vector2 = new Vector2();
/* 122 */     float f1 = 30.0F;
/* 123 */     if (isAbilityInstalled(1)) {
/* 124 */       f1 = 43.0F;
/*     */     }
/* 126 */     PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, this.angle, f1, vector2);
/*     */     
/* 128 */     CannonProjectile cannonProjectile = (CannonProjectile)this.S.projectile.F.CANNON.obtain();
/* 129 */     this.S.projectile.register((Projectile)cannonProjectile);
/*     */     
/* 131 */     int i = 0;
/* 132 */     float f2 = 0.0F;
/* 133 */     float f3 = 0.0F;
/* 134 */     if (isAbilityInstalled(0)) {
/* 135 */       i = this.S.gameValue.getIntValue(GameValueType.TOWER_CANNON_A_SHRAPNEL_COUNT);
/* 136 */       f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_SHRAPNEL_DAMAGE);
/* 137 */       f3 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_SHRAPNEL_DISTANCE) * getStat(TowerStatType.U_EXPLOSION_RANGE) * 128.0F;
/*     */     } 
/* 139 */     float f4 = getStat(TowerStatType.DAMAGE) * paramInt * (1.0F + getDamageBonusForFoundationRotation());
/* 140 */     cannonProjectile.setup(this, 
/*     */         
/* 142 */         getTarget(), f4, 
/*     */         
/* 144 */         getStat(TowerStatType.U_EXPLOSION_RANGE), vector2, 
/*     */         
/* 146 */         getStat(TowerStatType.PROJECTILE_SPEED), i * paramInt, f2, f3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     this.shotCount += paramInt;
/* 153 */     this.h.push(this.g);
/* 154 */     this.g = 0.0F;
/*     */ 
/*     */     
/* 157 */     if (this.S._sound != null) {
/* 158 */       this.S._sound.playShotSound(StaticSoundType.SHOT_CANNON, this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillTowerMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/* 164 */     byte b = 1;
/* 165 */     if (isAbilityInstalled(2)) {
/* 166 */       b = 32;
/*     */     }
/*     */     
/* 169 */     if (paramObjectMap.size == 0 || !paramObjectMap.get("state", Integer.valueOf(-1)).equals(Integer.valueOf(b))) {
/*     */       
/* 171 */       paramGroup.clear();
/*     */ 
/*     */ 
/*     */       
/* 175 */       if (isAbilityInstalled(2)) {
/*     */         
/* 177 */         PieChartActor pieChartActor = new PieChartActor();
/*     */         Array array;
/* 179 */         (array = new Array(PieChart.ChartEntryConfig.class)).add(new PieChart.ChartEntryConfig(MaterialColor.RED.P500, 20.0F, 0.0F));
/*     */ 
/*     */ 
/*     */         
/* 183 */         array.add(new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.28F), 30.0F, 0.0F));
/*     */ 
/*     */ 
/*     */         
/* 187 */         pieChartActor.setPosition(40.0F, 0.0F);
/* 188 */         pieChartActor.setSize(64.0F, 64.0F);
/* 189 */         pieChartActor.setSegmentCount(200);
/* 190 */         pieChartActor.setConfigs(array);
/* 191 */         paramGroup.addActor((Actor)pieChartActor);
/*     */         
/*     */         Image image1;
/* 194 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("circle"))).setColor(new Color(724249599));
/* 195 */         image1.setSize(36.0F, 36.0F);
/* 196 */         image1.setPosition(54.0F, 14.0F);
/* 197 */         paramGroup.addActor((Actor)image1);
/*     */         
/*     */         Image image2;
/* 200 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-rotation-speed"))).setSize(28.0F, 28.0F);
/* 201 */         image2.setPosition(58.0F, 18.0F);
/* 202 */         paramGroup.addActor((Actor)image2);
/*     */         
/*     */         Label label1;
/* 205 */         (label1 = new Label("", Game.i.assetManager.getLabelStyle(21))).setPosition(120.0F, 38.0F);
/* 206 */         label1.setSize(100.0F, 18.0F);
/* 207 */         paramGroup.addActor((Actor)label1);
/*     */         
/*     */         Label label2;
/* 210 */         (label2 = new Label(Game.i.localeManager.i18n.get("average_rotation_since_shot"), Game.i.assetManager.getLabelStyle(21))).setColor(new Color(1.0F, 1.0F, 1.0F, 0.56F));
/* 211 */         label2.setPosition(120.0F, 12.0F);
/* 212 */         label2.setSize(100.0F, 16.0F);
/* 213 */         paramGroup.addActor((Actor)label2);
/*     */         
/* 215 */         paramObjectMap.put("foundationAngleChart", pieChartActor);
/* 216 */         paramObjectMap.put("rotationTitle", label1);
/*     */       } 
/*     */       
/* 219 */       paramObjectMap.put("state", Integer.valueOf(b));
/*     */     } 
/*     */ 
/*     */     
/* 223 */     if (isAbilityInstalled(2)) {
/* 224 */       Label label = (Label)paramObjectMap.get("rotationTitle");
/* 225 */       PieChartActor pieChartActor = (PieChartActor)paramObjectMap.get("foundationAngleChart");
/*     */       
/*     */       float f1;
/* 228 */       if ((f1 = this.h.getAverage()) > 180.0F) {
/* 229 */         f1 = 180.0F;
/*     */       }
/*     */       Array array;
/* 232 */       ((PieChart.ChartEntryConfig)(array = pieChartActor.getConfigs()).get(0)).setValue(f1);
/* 233 */       float f2 = 180.0F - f1 + 0.01F;
/* 234 */       ((PieChart.ChartEntryConfig)array.get(1)).setValue(f2);
/* 235 */       pieChartActor.setConfigs(array);
/*     */       
/* 237 */       d.setLength(0);
/* 238 */       d.append(MathUtils.round(f1));
/* 239 */       d.append(Game.i.localeManager.i18n.get("measure_units_degrees"));
/* 240 */       d.append(", +");
/* 241 */       f1 *= (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_FOUNDATION_DAMAGE_PER_DEG);
/* 242 */       d.append(StringFormatter.compactNumberWithPrecision((f1 * 100.0F), 1));
/* 243 */       d.append("% ");
/* 244 */       d.append(Game.i.localeManager.i18n.get("tower_stat_DAMAGE"));
/* 245 */       label.setText((CharSequence)d);
/*     */     } 
/*     */     
/* 248 */     super.fillTowerMenu(paramGroup, paramObjectMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 255 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 257 */     if (paramTowerStatType == TowerStatType.RANGE && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_LONG_BARREL_RANGE)); 
/* 258 */     if (paramTowerStatType == TowerStatType.ROTATION_SPEED && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_FOUNDATION_SPEED)); 
/* 259 */     if (paramTowerStatType == TowerStatType.PROJECTILE_SPEED && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_FOUNDATION_SPEED)); 
/* 260 */     if (paramTowerStatType == TowerStatType.U_EXPLOSION_RANGE && isAbilityInstalled(1)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_LONG_EXPLOSION_RANGE));
/*     */     
/* 262 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 269 */     if (isOutOfOrder()) {
/* 270 */       super.update(paramFloat);
/*     */       
/*     */       return;
/*     */     } 
/* 274 */     a(paramFloat, getStat(TowerStatType.ROTATION_SPEED));
/* 275 */     this.g += Math.abs(PMath.getDistanceBetweenAngles(this.f, this.angle));
/* 276 */     this.f = this.angle;
/*     */     
/* 278 */     if (isAbilityInstalled(4)) {
/* 279 */       float f1 = this.S.gameValue.getFloatValue(GameValueType.TOWER_CANNON_A_MINE_INTERVAL);
/* 280 */       int i = this.S.gameValue.getIntValue(GameValueType.TOWER_CANNON_A_MINE_COUNT);
/* 281 */       float f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_MINE_DAMAGE);
/*     */       
/* 283 */       this.e += paramFloat;
/* 284 */       if (this.e >= f1) {
/* 285 */         this.e -= f1;
/*     */         
/* 287 */         byte b1 = 0;
/* 288 */         for (byte b2 = 0; b2 < this.S.map.spawnedUnits.size; b2++) {
/*     */           Unit unit; MineUnit mineUnit;
/* 290 */           if ((unit = ((Unit[])this.S.map.spawnedUnits.items)[b2]).type == UnitType.MINE && 
/*     */             
/* 292 */             (mineUnit = (MineUnit)unit).owner == this) {
/* 293 */             b1++;
/*     */           }
/*     */         } 
/*     */         
/* 297 */         if (b1 < i) {
/*     */           
/* 299 */           Array array = this.S.TSH.getTileArray();
/* 300 */           if (this.S.gameValue.getBooleanValue(GameValueType.ENEMIES_WALK_ON_PLATFORMS)) {
/*     */             
/* 302 */             this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */                   PlatformTile platformTile;
/*     */                   if (paramTile.enemyCount != 0) {
/*     */                     return true;
/*     */                   }
/*     */                   if (paramTile.type == TileType.PLATFORM) {
/*     */                     if ((platformTile = (PlatformTile)paramTile).building == null) {
/*     */                       paramArray.add(platformTile);
/*     */                     }
/*     */                   } else if (((Tile)platformTile).type == TileType.ROAD) {
/*     */                     paramArray.add(platformTile);
/*     */                   } 
/*     */                   return true;
/*     */                 });
/*     */           } else {
/* 317 */             this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*     */                   if (paramTile.enemyCount != 0) {
/*     */                     return true;
/*     */                   }
/*     */                   if (paramTile.type == TileType.ROAD) {
/*     */                     paramArray.add(paramTile);
/*     */                   }
/*     */                   return true;
/*     */                 });
/*     */           } 
/* 327 */           if (array.size != 0) {
/* 328 */             int k = this.S.gameState.randomInt(array.size);
/*     */             
/*     */             Tile tile;
/* 331 */             float f3 = (tile = ((Tile[])array.items)[k]).center.x + (this.S.gameState.randomFloat() - 0.5F) * 64.0F;
/* 332 */             float f4 = tile.center.y + (this.S.gameState.randomFloat() - 0.5F) * 64.0F;
/*     */             
/* 334 */             int j = 0;
/* 335 */             float f5 = 0.0F;
/* 336 */             float f6 = 0.0F;
/* 337 */             if (isAbilityInstalled(0)) {
/* 338 */               j = this.S.gameValue.getIntValue(GameValueType.TOWER_CANNON_A_SHRAPNEL_COUNT);
/* 339 */               f5 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_SHRAPNEL_DAMAGE);
/* 340 */               f6 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_SHRAPNEL_DISTANCE) * getStat(TowerStatType.U_EXPLOSION_RANGE) * 128.0F;
/*     */             } 
/*     */             
/*     */             CannonExplosion cannonExplosion;
/* 344 */             (cannonExplosion = (CannonExplosion)this.S.explosion.F.CANNON.obtain()).setup(this, 0.0F, 0.0F, getStat(TowerStatType.DAMAGE) * 1.0F / getAttackDelay() * f2, getStat(TowerStatType.U_EXPLOSION_RANGE) * 2.0F, j, f5, f6);
/* 345 */             cannonExplosion.piercingMultiplier = 1.5F;
/* 346 */             cannonExplosion.throwBackDistance = this.level * 0.1F * 1.5F + 1.5F;
/*     */             
/*     */             MineUnit mineUnit;
/* 349 */             (mineUnit = Game.i.unitManager.F.MINE.create()).setup(this, (getTile()).center.x, (getTile()).center.y, f3, f4, (Explosion)cannonExplosion, MaterialColor.RED.P500);
/* 350 */             this.S.unit.register((Unit)mineUnit);
/* 351 */             this.S.map.spawnUnit((Unit)mineUnit);
/*     */           } 
/*     */           
/* 354 */           this.S.TSH.freeTileArray(array);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 359 */     super.update(paramFloat);
/*     */   }
/*     */   
/*     */   public static class CannonTowerFactory extends Tower.Factory<CannonTower> {
/*     */     public CannonTowerFactory() {
/* 364 */       super("tower-cannon", TowerType.CANNON);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 369 */       super.setup();
/*     */       
/* 371 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "", "" };
/* 372 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "", "" };
/* 373 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 374 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "", "" };
/* 375 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "", "", "" };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 382 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_CANNON_A_SHRAPNEL_COUNT), false).toString();
/* 383 */       (arrayOfAbilityConfig[0]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_CANNON_A_SHRAPNEL_DAMAGE), 2, true).toString();
/* 384 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_LONG_BARREL_RANGE), 2, true).toString();
/* 385 */       (arrayOfAbilityConfig[1]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_LONG_EXPLOSION_RANGE), 2, true).toString();
/* 386 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_FOUNDATION_SPEED), 2, true).toString();
/* 387 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_FOUNDATION_PIERCING), 2, true).toString();
/* 388 */       (arrayOfAbilityConfig[2]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_CANNON_A_FOUNDATION_DAMAGE_PER_DEG), 2, true).toString();
/* 389 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_CANNON_A_PRESSURE_HEALTH), false).toString();
/* 390 */       (arrayOfAbilityConfig[3]).descriptionArgs[1] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_CANNON_A_PRESSURE_DAMAGE), false).toString();
/*     */       
/* 392 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_CANNON_A_MINE_DAMAGE), 2, true).toString();
/* 393 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_CANNON_A_MINE_INTERVAL), 2, true).toString();
/* 394 */       (arrayOfAbilityConfig[4]).descriptionArgs[2] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_CANNON_A_MINE_COUNT), false).toString();
/*     */       
/* 396 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 402 */       if (param1Int == 1) {
/* 403 */         return false;
/*     */       }
/* 405 */       return true;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 409 */       return MaterialColor.RED.P500;
/*     */     }
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 413 */       switch (CannonTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 414 */           return 2;
/* 415 */         case 2: return 2;
/* 416 */         case 3: return 2;
/* 417 */         case 4: return 5;
/* 418 */         case 5: return 4; }
/* 419 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 425 */       return CannonTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 430 */       return 33;
/*     */     }
/*     */ 
/*     */     
/*     */     public CannonTower create() {
/* 435 */       return new CannonTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\CannonTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */