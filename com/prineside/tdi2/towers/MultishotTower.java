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
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.projectiles.MultishotProjectile;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.shapes.PieChart;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.PieChartActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ 
/*     */ @REGS
/*     */ public final class MultishotTower
/*     */   extends Tower {
/*     */   public static final int ABILITY_PENETRATING_BULLETS = 0;
/*     */   public static final int ABILITY_BUCKSHOT = 1;
/*     */   public static final int ABILITY_COMPACT_WEAPONS = 2;
/*  40 */   public static final String[] ABILITY_ALIASES = new String[] { "PENETRATING_BULLETS", "BUCKSHOT", "COMPACT_WEAPONS" };
/*     */ 
/*     */ 
/*     */   
/*     */   public int notHitBackProjectileCount;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  50 */     super.write(paramKryo, paramOutput);
/*  51 */     paramOutput.writeVarInt(this.notHitBackProjectileCount, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  56 */     super.read(paramKryo, paramInput);
/*  57 */     this.notHitBackProjectileCount = paramInput.readVarInt(true);
/*     */   }
/*     */   
/*     */   private MultishotTower() {
/*  61 */     super(TowerType.MULTISHOT);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/*  66 */     if (isAbilityInstalled(0)) {
/*  67 */       return Game.i.towerManager.F.MULTISHOT.getAbilityTextures(0);
/*     */     }
/*  69 */     return Game.i.towerManager.F.MULTISHOT.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/*  82 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canAttack() {
/*  87 */     if (getTarget() != null && !this.attackDisabled) {
/*     */       Vector2 vector2;
/*  89 */       (vector2 = new Vector2()).set(getTarget().getPosition());
/*  90 */       float f = PMath.getAngleBetweenPoints((getTile()).center.x, (getTile()).center.y, vector2.x, vector2.y);
/*     */ 
/*     */       
/*  93 */       return ((f = StrictMath.abs(PMath.getDistanceBetweenAngles(this.angle, f))) < 3.0F + getStat(TowerStatType.U_SHOOT_ANGLE) / 2.0F);
/*     */     } 
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void attack(int paramInt) {
/* 101 */     if (getTarget() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 105 */     float f1 = getStat(TowerStatType.U_PROJECTILE_COUNT);
/* 106 */     float f2 = getStat(TowerStatType.U_SHOOT_ANGLE);
/* 107 */     float f3 = getStat(TowerStatType.DAMAGE);
/* 108 */     float f4 = getStat(TowerStatType.PROJECTILE_SPEED);
/*     */     
/* 110 */     int i = (int)f1;
/* 111 */     if (f1 % 1.0F != 0.0F)
/*     */     {
/* 113 */       if (this.S.gameState.randomFloat() < f1 % 1.0F) {
/* 114 */         i++;
/*     */       }
/*     */     }
/*     */     
/* 118 */     f1 = f2 / f1;
/* 119 */     f2 = this.angle - f2 / 2.0F;
/* 120 */     for (byte b = 0; b < i; b++) {
/* 121 */       Vector2 vector21 = new Vector2();
/* 122 */       PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, f2, 12.0F, vector21);
/*     */       
/* 124 */       Vector2 vector22 = new Vector2();
/* 125 */       PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, f2, this.rangeInPixels, vector22);
/*     */ 
/*     */ 
/*     */       
/* 129 */       MultishotProjectile multishotProjectile = (MultishotProjectile)this.S.projectile.F.MULTISHOT.obtain();
/* 130 */       this.S.projectile.register((Projectile)multishotProjectile);
/* 131 */       multishotProjectile.setup(this, f3 * paramInt, vector21, vector22, f4, 
/* 132 */           isAbilityInstalled(0), 
/* 133 */           isAbilityInstalled(3), 1.0F);
/*     */ 
/*     */ 
/*     */       
/* 137 */       f2 += f1;
/*     */     } 
/*     */     
/* 140 */     if (isAbilityInstalled(4)) {
/*     */ 
/*     */       
/* 143 */       float f = (f = f3 * paramInt * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MULTISHOT_A_BACK_SHOT_DAMAGE)) * (this.notHitBackProjectileCount + 1);
/*     */       
/* 145 */       Vector2 vector21 = new Vector2();
/* 146 */       PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, this.angle + 180.0F, 12.0F, vector21);
/*     */       
/* 148 */       Vector2 vector22 = new Vector2();
/* 149 */       PMath.getPointByAngleFromPoint((getTile()).center.x, (getTile()).center.y, this.angle + 180.0F, this.rangeInPixels, vector22);
/*     */       
/* 151 */       MultishotProjectile multishotProjectile = (MultishotProjectile)this.S.projectile.F.MULTISHOT.obtain();
/* 152 */       this.S.projectile.register((Projectile)multishotProjectile);
/* 153 */       multishotProjectile.setup(this, f, vector21, vector22, f4, 
/* 154 */           isAbilityInstalled(0), 
/* 155 */           isAbilityInstalled(3), 1.5F);
/*     */ 
/*     */       
/* 158 */       multishotProjectile.flyingBack = true;
/*     */     } 
/*     */     
/* 161 */     this.shotCount += paramInt;
/*     */     
/* 163 */     if (this.S._sound != null) {
/* 164 */       this.S._sound.playShotSound(StaticSoundType.SHOT_MULTISHOT, this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBuckshotCoinBonusMult() {
/* 170 */     float f1 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MULTISHOT_A_BUCKSHOT_COINS);
/* 171 */     float f2 = 0.2F + 0.8F * getUpgradeLevel() / 10.0F;
/* 172 */     return f1 * f2;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 177 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 179 */     if (paramTowerStatType == TowerStatType.U_SHOOT_ANGLE && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MULTISHOT_A_COMPACT_ARC_SIZE));
/*     */     
/* 181 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fillTowerMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/* 186 */     byte b = 1;
/* 187 */     if (isAbilityInstalled(4)) {
/* 188 */       b = 32;
/*     */     }
/*     */     
/* 191 */     if (paramObjectMap.size == 0 || !paramObjectMap.get("state", Integer.valueOf(-1)).equals(Integer.valueOf(b))) {
/*     */       
/* 193 */       paramGroup.clear();
/*     */       
/* 195 */       if (isAbilityInstalled(4)) {
/*     */         
/* 197 */         int i = Game.i.settingsManager.getScaledViewportHeight() - 1080 + 8;
/*     */         
/* 199 */         PieChartActor pieChartActor = new PieChartActor();
/*     */         Array array;
/* 201 */         (array = new Array(PieChart.ChartEntryConfig.class)).add(new PieChart.ChartEntryConfig(MaterialColor.AMBER.P500, 20.0F, 0.0F));
/*     */ 
/*     */ 
/*     */         
/* 205 */         array.add(new PieChart.ChartEntryConfig(new Color(0.0F, 0.0F, 0.0F, 0.28F), 30.0F, 0.0F));
/*     */ 
/*     */ 
/*     */         
/* 209 */         pieChartActor.setPosition(310.0F, (i + 8));
/* 210 */         pieChartActor.setSize(48.0F, 48.0F);
/* 211 */         pieChartActor.setSegmentCount(150);
/* 212 */         pieChartActor.setConfigs(array);
/* 213 */         paramGroup.addActor((Actor)pieChartActor);
/*     */         
/*     */         Image image;
/* 216 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("circle"))).setColor(new Color(724249599));
/* 217 */         image.setSize(28.0F, 28.0F);
/* 218 */         image.setPosition(320.0F, 17.0F + i);
/* 219 */         paramGroup.addActor((Actor)image);
/*     */ 
/*     */         
/* 222 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-projectile-count"))).setSize(22.0F, 22.0F);
/* 223 */         image.setPosition(323.0F, 19.0F + i);
/* 224 */         paramGroup.addActor((Actor)image);
/*     */         
/*     */         Label label1;
/* 227 */         (label1 = new Label("", Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.ORANGE.P500);
/* 228 */         label1.setPosition(372.0F, 37.0F + i);
/* 229 */         label1.setSize(100.0F, 14.0F);
/* 230 */         paramGroup.addActor((Actor)label1);
/*     */         
/*     */         Label label2;
/* 233 */         (label2 = new Label(Game.i.localeManager.i18n.get("back_shot_damage_multiplier"), Game.i.assetManager.getLabelStyle(18))).setColor(new Color(1.0F, 1.0F, 1.0F, 0.56F));
/* 234 */         label2.setPosition(372.0F, 13.0F + i);
/* 235 */         label2.setSize(100.0F, 13.0F);
/* 236 */         paramGroup.addActor((Actor)label2);
/*     */         
/* 238 */         paramObjectMap.put("backShotStackChart", pieChartActor);
/* 239 */         paramObjectMap.put("projStackTitle", label1);
/*     */       } 
/*     */       
/* 242 */       paramObjectMap.put("state", Integer.valueOf(b));
/*     */     } 
/*     */ 
/*     */     
/* 246 */     if (isAbilityInstalled(4)) {
/* 247 */       Label label = (Label)paramObjectMap.get("projStackTitle");
/*     */       
/*     */       PieChartActor pieChartActor;
/*     */       Array array;
/* 251 */       ((PieChart.ChartEntryConfig)(array = (pieChartActor = (PieChartActor)paramObjectMap.get("backShotStackChart")).getConfigs()).get(0)).setValue(this.notHitBackProjectileCount / this.S.gameValue.getFloatValue(GameValueType.TOWER_MULTISHOT_A_BACK_MAX_STACK));
/* 252 */       ((PieChart.ChartEntryConfig)array.get(1)).setValue(1.0F - ((PieChart.ChartEntryConfig)array.get(0)).getValue());
/* 253 */       pieChartActor.setConfigs(array);
/*     */       
/* 255 */       d.setLength(0);
/* 256 */       d.append(Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-damage>"));
/* 257 */       d.append(MathUtils.round((float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MULTISHOT_A_BACK_SHOT_DAMAGE) * getStat(TowerStatType.DAMAGE) * (this.notHitBackProjectileCount + 1)));
/* 258 */       d.append(" (x").append(this.notHitBackProjectileCount + 1).append(")");
/* 259 */       label.setText((CharSequence)d);
/*     */     } 
/*     */     
/* 262 */     super.fillTowerMenu(paramGroup, paramObjectMap);
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
/*     */     
/* 276 */     super.update(paramFloat);
/*     */   }
/*     */   
/*     */   public static class MultishotTowerFactory extends Tower.Factory<MultishotTower> {
/*     */     public MultishotTowerFactory() {
/* 281 */       super("tower-multishot", TowerType.MULTISHOT);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 286 */       super.setup();
/*     */       
/* 288 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "" };
/* 289 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 290 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "", "", "" };
/* 291 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "" };
/* 292 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "", "" };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/*     */       Tower.AbilityConfig[] arrayOfAbilityConfig;
/* 299 */       ((arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower))[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MULTISHOT_A_PENETRATING_DAMAGE), 2, true).toString();
/* 300 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MULTISHOT_A_COMPACT_ARC_SIZE), 2, true).toString();
/* 301 */       (arrayOfAbilityConfig[2]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MULTISHOT_A_COMPACT_DAMAGE_PER_HIT), 2, true).toString();
/* 302 */       (arrayOfAbilityConfig[2]).descriptionArgs[2] = StringFormatter.compactNumber(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_MULTISHOT_A_COMPACT_MAX_HIT_COUNT), false).toString();
/* 303 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros((param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MULTISHOT_A_BUCKSHOT_DAMAGE) - 100.0F), 1, true).toString();
/* 304 */       (arrayOfAbilityConfig[1]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros((((MultishotTower)param1Tower).getBuckshotCoinBonusMult() * 100.0F), 1, true).toString();
/* 305 */       (arrayOfAbilityConfig[1]).descriptionArgs[2] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MULTISHOT_A_BUCKSHOT_COINS_DURATION), 1, true).toString();
/* 306 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MULTISHOT_A_COUNTER_DAMAGE), 2, true).toString();
/* 307 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(param1GameSystemProvider.gameValue.getFloatValue(GameValueType.TOWER_MULTISHOT_A_BACK_SHOT_DAMAGE), 2, true).toString();
/* 308 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = String.valueOf(param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_MULTISHOT_A_BACK_MAX_STACK));
/*     */       
/* 310 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 316 */       if (param1Int == 0) {
/* 317 */         return false;
/*     */       }
/* 319 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 324 */       switch (MultishotTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 325 */           return 4;
/* 326 */         case 2: return 3;
/* 327 */         case 3: return 2;
/* 328 */         case 4: return 4;
/* 329 */         case 5: return 3; }
/* 330 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 336 */       return 34;
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 341 */       return MultishotTower.ABILITY_ALIASES;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 345 */       return MaterialColor.YELLOW.P500;
/*     */     }
/*     */     
/*     */     public MultishotTower create() {
/* 349 */       return new MultishotTower((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\MultishotTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */