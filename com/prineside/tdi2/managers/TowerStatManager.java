/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = TowerStatManager.Serializer.class)
/*     */ public class TowerStatManager extends Manager.ManagerAdapter {
/*  16 */   private static final TLog a = TLog.forClass(TowerStatManager.class);
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<TowerStatManager> {
/*     */     public TowerStatManager read() {
/*  20 */       return Game.i.towerStatManager;
/*     */     } }
/*     */   
/*  23 */   private final TowerStat[] b = new TowerStat[TowerStatType.values.length];
/*     */   
/*  25 */   private static final StringBuilder c = new StringBuilder();
/*  26 */   private static final StringBuilder d = new StringBuilder();
/*     */   
/*     */   public TowerStatManager() {
/*  29 */     a(TowerStatType.RANGE, "icon-range", MaterialColor.GREEN.P500, "measure_units_tiles");
/*  30 */     a(TowerStatType.MIN_RANGE, "icon-range-minimum", MaterialColor.GREEN.P500, "measure_units_tiles").setVisible(false);
/*  31 */     a(TowerStatType.DAMAGE, "icon-damage", MaterialColor.RED.P500, null);
/*  32 */     a(TowerStatType.ATTACK_SPEED, "icon-attack-speed", MaterialColor.ORANGE.P500, "measure_units_units_per_second");
/*  33 */     a(TowerStatType.ROTATION_SPEED, "icon-rotation-speed", MaterialColor.PURPLE.P500, "measure_units_degrees_per_second");
/*  34 */     a(TowerStatType.PROJECTILE_SPEED, "icon-projectile-speed", MaterialColor.DEEP_PURPLE.P500, "measure_units_tiles_per_second");
/*  35 */     a(TowerStatType.AIM_SPEED, "icon-aim-time", MaterialColor.CYAN.P500, "measure_units_percent_per_second");
/*  36 */     a(TowerStatType.CHARGING_SPEED, "icon-aim-time", MaterialColor.CYAN.P500, "measure_units_percent_per_second");
/*  37 */     a(TowerStatType.FREEZE_PERCENT, "icon-freeze-percent", MaterialColor.LIGHT_BLUE.P500, "measure_units_percent");
/*  38 */     a(TowerStatType.FREEZE_SPEED, "icon-freeze-in-time", MaterialColor.INDIGO.P500, "measure_units_percent_per_second");
/*     */     
/*  40 */     a(TowerStatType.STUN_CHANCE, "icon-stun", MaterialColor.TEAL.P500, "measure_units_percent");
/*  41 */     a(TowerStatType.CHAIN_LIGHTNING_DAMAGE, "icon-lightning-damage", MaterialColor.DEEP_ORANGE.P500, "measure_units_percent");
/*  42 */     a(TowerStatType.RESOURCE_CONSUMPTION, "icon-cubes-stacked-flame", MaterialColor.RED.P500, null);
/*  43 */     a(TowerStatType.DURATION, "icon-clock", MaterialColor.PINK.P500, "measure_units_seconds");
/*     */     
/*  45 */     a(TowerStatType.PRICE, "icon-dollar", Color.WHITE, null);
/*  46 */     a(TowerStatType.STARTING_LEVEL, "icon-experience-bar", Color.WHITE, null);
/*  47 */     a(TowerStatType.STARTING_POWER, "icon-power", Color.WHITE, null);
/*  48 */     a(TowerStatType.MAX_EXP_LEVEL, "icon-experience-max", Color.WHITE, null);
/*  49 */     a(TowerStatType.MAX_UPGRADE_LEVEL, "icon-upgrade-max", Color.WHITE, null);
/*  50 */     a(TowerStatType.EXPERIENCE_MULTIPLIER, "icon-experience-plus", Color.WHITE, null);
/*  51 */     a(TowerStatType.EXPERIENCE_GENERATION, "icon-experience-generation", Color.WHITE, null);
/*  52 */     a(TowerStatType.UPGRADE_PRICE, "icon-upgrade-money", Color.WHITE, null);
/*     */     
/*  54 */     a(TowerStatType.U_PIERCING, "icon-piercing-projectile", MaterialColor.AMBER.P600, "measure_units_percent");
/*  55 */     a(TowerStatType.U_DAMAGE_MULTIPLY, "icon-damage-multiplier", MaterialColor.AMBER.P600, "measure_units_percent");
/*  56 */     a(TowerStatType.U_CRIT_CHANCE, "icon-critical-damage-percent", MaterialColor.AMBER.P600, "measure_units_percent");
/*  57 */     a(TowerStatType.U_CRIT_MULTIPLIER, "icon-critical-damage", MaterialColor.AMBER.P600, "measure_units_percent");
/*  58 */     a(TowerStatType.U_EXPLOSION_RANGE, "icon-explosion-range", MaterialColor.AMBER.P600, "measure_units_tiles");
/*  59 */     a(TowerStatType.U_POISON_DURATION_BONUS, "icon-skull-and-bones-clock-plus", MaterialColor.AMBER.P600, "measure_units_percent");
/*  60 */     a(TowerStatType.U_CHAIN_LIGHTNING_BONUS_LENGTH, "icon-lightning-length", MaterialColor.AMBER.P600, "measure_units_percent");
/*  61 */     a(TowerStatType.U_POISON_DURATION, "icon-skull-and-bones-clock", MaterialColor.AMBER.P600, "measure_units_seconds");
/*  62 */     a(TowerStatType.U_PROJECTILE_COUNT, "icon-projectile-count", MaterialColor.AMBER.P600, null);
/*  63 */     a(TowerStatType.U_STUN_DURATION, "icon-stun-clock", MaterialColor.AMBER.P600, "measure_units_seconds");
/*  64 */     a(TowerStatType.U_QUAKE_CHARGE_SPEED, "icon-quake", MaterialColor.AMBER.P600, "measure_units_percent_per_second");
/*  65 */     a(TowerStatType.U_BURN_CHANCE, "icon-flame-percent", MaterialColor.AMBER.P600, "measure_units_percent");
/*  66 */     a(TowerStatType.U_BURN_DAMAGE, "icon-flame-damage", MaterialColor.AMBER.P600, "measure_units_percent_per_second");
/*  67 */     a(TowerStatType.U_ACCELERATION, "icon-speedometer-clock", MaterialColor.AMBER.P600, "measure_units_percent_per_second");
/*  68 */     a(TowerStatType.U_SHOOT_ANGLE, "icon-shot-angle", MaterialColor.AMBER.P600, "measure_units_degrees");
/*  69 */     a(TowerStatType.U_CHAIN_LIGHTNING_LENGTH, "icon-lightning-length", MaterialColor.AMBER.P600, null);
/*  70 */     a(TowerStatType.U_LRM_AIM_SPEED, "icon-rocket-aim-time", MaterialColor.AMBER.P600, "measure_units_percent_per_second");
/*  71 */     a(TowerStatType.U_BURNING_TIME, "icon-flame-clock", MaterialColor.AMBER.P600, "measure_units_seconds");
/*  72 */     a(TowerStatType.U_BATTERIES_CAPACITY, "icon-battery-max", MaterialColor.AMBER.P600, "measure_units_seconds");
/*     */     
/*  74 */     a(TowerStatType.U_BONUS_COINS, "icon-coin", MaterialColor.AMBER.P600, "measure_units_percent");
/*  75 */     a(TowerStatType.U_BONUS_EXPERIENCE, "icon-experience-plus", MaterialColor.AMBER.P600, "measure_units_percent");
/*  76 */     a(TowerStatType.U_SHARED_DAMAGE, "icon-damage-split", MaterialColor.AMBER.P600, "measure_units_percent");
/*  77 */     a(TowerStatType.U_DIRECT_FIRE_DAMAGE, "icon-flame-damage", MaterialColor.AMBER.P600, "measure_units_percent");
/*  78 */     a(TowerStatType.U_MAGAZINE_SIZE, "icon-magazine-size", MaterialColor.AMBER.P600, null); TowerStatType[] arrayOfTowerStatType;
/*     */     int i;
/*     */     byte b;
/*  81 */     for (i = (arrayOfTowerStatType = TowerStatType.values).length, b = 0; b < i; ) { TowerStatType towerStatType = arrayOfTowerStatType[b];
/*  82 */       if (this.b[towerStatType.ordinal()] == null)
/*  83 */         throw new RuntimeException("Tower stat type " + towerStatType.name() + " is not initialized"); 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   private TowerStat a(TowerStatType paramTowerStatType, String paramString1, Color paramColor, String paramString2) {
/*     */     TowerStat towerStat;
/*  90 */     TowerStat.a(towerStat = new TowerStat(), paramTowerStatType);
/*  91 */     TowerStat.a(towerStat, "tower_stat_" + paramTowerStatType.name());
/*  92 */     TowerStat.b(towerStat, "tower_stat_short_" + paramTowerStatType.name());
/*  93 */     towerStat.unitsAlias = paramString2;
/*  94 */     TowerStat.c(towerStat, paramString1);
/*  95 */     TowerStat.a(towerStat, paramColor);
/*     */     
/*  97 */     this.b[paramTowerStatType.ordinal()] = towerStat;
/*  98 */     return towerStat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setup() {}
/*     */   
/*     */   public void test() {
/*     */     TowerStatType[] arrayOfTowerStatType;
/*     */     int i;
/*     */     byte b;
/* 108 */     for (i = (arrayOfTowerStatType = TowerStatType.values).length, b = 0; b < i; ) { TowerStatType towerStatType = arrayOfTowerStatType[b];
/* 109 */       if (Game.i.assetManager.getTextureRegion(this.b[towerStatType.ordinal()].getIconDrawableAlias()) == null)
/* 110 */         a.e("Icon texture region is null for stat type " + towerStatType.name(), new Object[0]); 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public TowerStat getInstance(TowerStatType paramTowerStatType) {
/* 116 */     return this.b[paramTowerStatType.ordinal()];
/*     */   }
/*     */   
/*     */   public static class TowerStat
/*     */   {
/*     */     private String a;
/*     */     public String unitsAlias;
/*     */     private TowerStatType b;
/*     */     private Color c;
/*     */     private String d;
/*     */     private boolean e = true;
/*     */     
/*     */     public TowerStatType getType() {
/* 129 */       return this.b;
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 133 */       return this.c;
/*     */     }
/*     */     
/*     */     public String getIconDrawableAlias() {
/* 137 */       return this.d;
/*     */     }
/*     */     
/*     */     public String getName() {
/* 141 */       return Game.i.localeManager.i18n.get(this.a);
/*     */     }
/*     */     
/*     */     public boolean isVisible() {
/* 145 */       return this.e;
/*     */     }
/*     */     
/*     */     public TowerStat setVisible(boolean param1Boolean) {
/* 149 */       this.e = param1Boolean;
/* 150 */       return this;
/*     */     }
/*     */     
/*     */     public StringBuilder getFormattedValue(float param1Float, boolean param1Boolean) {
/* 154 */       TowerStatManager.a().setLength(0);
/*     */       
/* 156 */       TowerStatManager.a().append(StringFormatter.compactNumber(param1Float, true));
/*     */       
/* 158 */       if (param1Boolean) {
/* 159 */         switch (TowerStatManager.null.a[this.b.ordinal()]) {
/*     */           
/*     */           case 1:
/*     */           case 2:
/* 163 */             TowerStatManager.a().append("/").append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/*     */             break;
/*     */           
/*     */           case 3:
/*     */           case 4:
/*     */           case 5:
/*     */           case 6:
/*     */           case 7:
/* 171 */             TowerStatManager.a().append("%/").append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/*     */             break;
/*     */           
/*     */           case 8:
/*     */           case 9:
/*     */           case 10:
/* 177 */             TowerStatManager.a().append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/*     */             break;
/*     */           
/*     */           case 11:
/*     */           case 12:
/*     */           case 13:
/*     */           case 14:
/*     */           case 15:
/* 185 */             TowerStatManager.a().append("%");
/*     */             break;
/*     */           
/*     */           case 16:
/*     */           case 17:
/* 190 */             TowerStatManager.b().setLength(0);
/* 191 */             TowerStatManager.b().append(TowerStatManager.a());
/* 192 */             TowerStatManager.a().setLength(0);
/* 193 */             TowerStatManager.a().append('x').append(TowerStatManager.b());
/*     */             break;
/*     */           
/*     */           case 18:
/* 197 */             TowerStatManager.b().setLength(0);
/* 198 */             TowerStatManager.b().append(TowerStatManager.a());
/* 199 */             TowerStatManager.a().setLength(0);
/* 200 */             TowerStatManager.a().append('+').append(TowerStatManager.b());
/*     */             break;
/*     */           
/*     */           case 19:
/* 204 */             TowerStatManager.b().setLength(0);
/* 205 */             TowerStatManager.b().append(TowerStatManager.a());
/* 206 */             TowerStatManager.a().setLength(0);
/* 207 */             TowerStatManager.a().append('+').append(TowerStatManager.b()).append(Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/*     */             break;
/*     */         } 
/*     */       
/*     */       }
/* 212 */       return TowerStatManager.a();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\TowerStatManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */