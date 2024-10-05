/*     */ package com.prineside.tdi2.managers;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.towers.AirTower;
/*     */ import com.prineside.tdi2.towers.BasicTower;
/*     */ import com.prineside.tdi2.towers.BlastTower;
/*     */ import com.prineside.tdi2.towers.CannonTower;
/*     */ import com.prineside.tdi2.towers.CrusherTower;
/*     */ import com.prineside.tdi2.towers.FlamethrowerTower;
/*     */ import com.prineside.tdi2.towers.FreezingTower;
/*     */ import com.prineside.tdi2.towers.GaussTower;
/*     */ import com.prineside.tdi2.towers.LaserTower;
/*     */ import com.prineside.tdi2.towers.MinigunTower;
/*     */ import com.prineside.tdi2.towers.MissileTower;
/*     */ import com.prineside.tdi2.towers.MultishotTower;
/*     */ import com.prineside.tdi2.towers.SniperTower;
/*     */ import com.prineside.tdi2.towers.SplashTower;
/*     */ import com.prineside.tdi2.towers.TeslaTower;
/*     */ import com.prineside.tdi2.towers.VenomTower;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ @REGS(serializer = TowerManager.Serializer.class)
/*     */ public final class TowerManager extends Manager.ManagerAdapter {
/*     */   public static final int STAT_ROUNDING_NONE = 0;
/*     */   public static final int STAT_ROUNDING_FLOOR = 1;
/*     */   public static final int STAT_ROUNDING_MIDDLE = 2;
/*     */   public static final int STAT_ROUNDING_CEIL = 3;
/*     */   
/*     */   static {
/*  54 */     TLog.forClass(TowerManager.class);
/*     */   }
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<TowerManager> { public TowerManager read() {
/*  58 */       return Game.i.towerManager;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   private final Tower.Factory[] a = new Tower.Factory[TowerType.values.length];
/*     */   
/*  68 */   private final String[] b = new String[Tower.AimStrategy.values.length];
/*  69 */   private final String[] c = new String[Tower.AimStrategy.values.length]; public final boolean[][] canTowerAttackEnemy; public final float[][] towerEnemyDamageMultiplier; private final TowerStatsConfig[] d; private final StatisticsType[] e; private final StatisticsType[] f; private final StatisticsType[] g; private final StatisticsType[] h; private final StatisticsType[] i; private final StatisticsType[] j; private final String[] k; private final String[] l; private final String[] m; private final GameValueType[] n; private final GameValueType[] o;
/*     */   private final GameValueType[] p;
/*  71 */   public final ObjectMap<TowerType, String> SHORT_TOWER_ALIASES = new ObjectMap(); private final GameValueType[] q; private final GameValueType[] r; private final GameValueType[] s; private final GameValueType[] t; private final GameValueType[] u; private final GameValueType[] v; private final GameValueType[] w; private final GameValueType[] x; private final GameValueType[] y; public final Factories F; public ParticleEffectPool abilityAvailableParticleEffectPool; public ParticleEffectPool[] highlightParticles; public ParticleEffectPool upgradeParticles; public ParticleEffectPool lvlUpParticles;
/*     */   public TowerManager() {
/*  73 */     this.SHORT_TOWER_ALIASES.put(TowerType.BASIC, "B");
/*  74 */     this.SHORT_TOWER_ALIASES.put(TowerType.SNIPER, "S");
/*  75 */     this.SHORT_TOWER_ALIASES.put(TowerType.CANNON, "C");
/*  76 */     this.SHORT_TOWER_ALIASES.put(TowerType.FREEZING, "F");
/*  77 */     this.SHORT_TOWER_ALIASES.put(TowerType.VENOM, "V");
/*  78 */     this.SHORT_TOWER_ALIASES.put(TowerType.SPLASH, "SP");
/*  79 */     this.SHORT_TOWER_ALIASES.put(TowerType.BLAST, "BL");
/*  80 */     this.SHORT_TOWER_ALIASES.put(TowerType.MULTISHOT, "M");
/*  81 */     this.SHORT_TOWER_ALIASES.put(TowerType.MINIGUN, "MI");
/*  82 */     this.SHORT_TOWER_ALIASES.put(TowerType.AIR, "A");
/*  83 */     this.SHORT_TOWER_ALIASES.put(TowerType.TESLA, "T");
/*  84 */     this.SHORT_TOWER_ALIASES.put(TowerType.MISSILE, "MS");
/*  85 */     this.SHORT_TOWER_ALIASES.put(TowerType.FLAMETHROWER, "FL");
/*  86 */     this.SHORT_TOWER_ALIASES.put(TowerType.LASER, "L");
/*  87 */     this.SHORT_TOWER_ALIASES.put(TowerType.GAUSS, "G");
/*  88 */     this.SHORT_TOWER_ALIASES.put(TowerType.CRUSHER, "CR");
/*     */ 
/*     */     
/*  91 */     this.canTowerAttackEnemy = new boolean[EnemyType.values.length][TowerType.values.length];
/*  92 */     this.towerEnemyDamageMultiplier = new float[EnemyType.values.length][TowerType.values.length];
/*  93 */     this.d = new TowerStatsConfig[TowerType.values.length];
/*     */     
/*  95 */     this.e = new StatisticsType[TowerType.values.length];
/*  96 */     this.f = new StatisticsType[TowerType.values.length];
/*  97 */     this.g = new StatisticsType[TowerType.values.length];
/*  98 */     this.h = new StatisticsType[TowerType.values.length];
/*  99 */     this.i = new StatisticsType[TowerType.values.length];
/* 100 */     this.j = new StatisticsType[TowerType.values.length];
/* 101 */     this.k = new String[TowerType.values.length];
/* 102 */     this.l = new String[TowerType.values.length];
/* 103 */     this.m = new String[TowerType.values.length];
/* 104 */     this.n = new GameValueType[TowerType.values.length];
/* 105 */     this.o = new GameValueType[TowerType.values.length];
/* 106 */     this.p = new GameValueType[TowerType.values.length];
/* 107 */     this.q = new GameValueType[TowerType.values.length];
/* 108 */     this.r = new GameValueType[TowerType.values.length];
/* 109 */     this.s = new GameValueType[TowerType.values.length];
/* 110 */     this.t = new GameValueType[TowerType.values.length];
/* 111 */     this.u = new GameValueType[TowerType.values.length];
/* 112 */     this.v = new GameValueType[TowerType.values.length];
/* 113 */     this.w = new GameValueType[TowerType.values.length];
/* 114 */     this.x = new GameValueType[TowerType.values.length];
/* 115 */     this.y = new GameValueType[TowerType.values.length];
/*     */     
/* 117 */     this.F = new Factories();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     this.highlightParticles = new ParticleEffectPool[TowerType.values.length];
/*     */     
/*     */     Tower.AimStrategy[] arrayOfAimStrategy;
/*     */     int i;
/*     */     byte b;
/* 143 */     for (i = (arrayOfAimStrategy = Tower.AimStrategy.values).length, b = 0; b < i; ) { Tower.AimStrategy aimStrategy = arrayOfAimStrategy[b];
/* 144 */       this.b[aimStrategy.ordinal()] = "aim_strategy_" + aimStrategy.name(); b++; }
/*     */     
/* 146 */     this.c[Tower.AimStrategy.FIRST.ordinal()] = "icon-target-first";
/* 147 */     this.c[Tower.AimStrategy.LAST.ordinal()] = "icon-target-last";
/* 148 */     this.c[Tower.AimStrategy.STRONGEST.ordinal()] = "icon-target-strong";
/* 149 */     this.c[Tower.AimStrategy.WEAKEST.ordinal()] = "icon-target-weak";
/* 150 */     this.c[Tower.AimStrategy.NEAREST.ordinal()] = "icon-target-near";
/* 151 */     this.c[Tower.AimStrategy.RANDOM.ordinal()] = "icon-target-random";
/*     */     TowerType[] arrayOfTowerType;
/* 153 */     for (i = (arrayOfTowerType = TowerType.values).length, b = 0; b < i; ) { TowerType towerType = arrayOfTowerType[b];
/* 154 */       String str = (String)this.SHORT_TOWER_ALIASES.get(towerType);
/* 155 */       this.e[towerType.ordinal()] = StatisticsType.valueOf("TMS_" + str);
/* 156 */       this.f[towerType.ordinal()] = StatisticsType.valueOf("TDD_" + str);
/* 157 */       this.g[towerType.ordinal()] = StatisticsType.valueOf("TB_" + str);
/* 158 */       this.h[towerType.ordinal()] = StatisticsType.valueOf("TS_" + str);
/* 159 */       this.i[towerType.ordinal()] = StatisticsType.valueOf("TU_" + str);
/* 160 */       this.j[towerType.ordinal()] = StatisticsType.valueOf("TEK_" + str);
/* 161 */       this.k[towerType.ordinal()] = "tower_name_" + towerType.name();
/* 162 */       this.l[towerType.ordinal()] = "tower_description_" + towerType.name();
/* 163 */       this.m[towerType.ordinal()] = "tower_unique_stat_description_" + towerType.name();
/* 164 */       this.n[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_UPGRADE_PRICE");
/* 165 */       this.o[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_PRICE");
/* 166 */       this.p[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_MAX_EXP_LEVEL");
/* 167 */       this.q[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_MAX_UPGRADE_LEVEL");
/* 168 */       this.r[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_EXPERIENCE_GENERATION");
/* 169 */       this.u[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_EXPERIENCE_MULTIPLIER");
/* 170 */       this.s[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_PPL_TILL_10");
/* 171 */       this.t[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_PPL_AFTER_10");
/* 172 */       this.v[towerType.ordinal()] = GameValueType.valueOf("TOWER_TYPE_" + towerType.name());
/* 173 */       this.w[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_STARTING_LEVEL");
/* 174 */       this.x[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_STARTING_PWR");
/* 175 */       this.y[towerType.ordinal()] = GameValueType.valueOf("TOWER_" + towerType.name() + "_A_POWERFUL_PWR");
/*     */       b++; }
/*     */     
/* 178 */     this.a[TowerType.BASIC.ordinal()] = (Tower.Factory)(this.F.BASIC = new BasicTower.BasicTowerFactory());
/* 179 */     this.a[TowerType.AIR.ordinal()] = (Tower.Factory)(this.F.AIR = new AirTower.AirTowerFactory());
/* 180 */     this.a[TowerType.BLAST.ordinal()] = (Tower.Factory)(this.F.BLAST = new BlastTower.BlastTowerFactory());
/* 181 */     this.a[TowerType.CANNON.ordinal()] = (Tower.Factory)(this.F.CANNON = new CannonTower.CannonTowerFactory());
/* 182 */     this.a[TowerType.FREEZING.ordinal()] = (Tower.Factory)(this.F.FREEZING = new FreezingTower.FreezingTowerFactory());
/* 183 */     this.a[TowerType.MINIGUN.ordinal()] = (Tower.Factory)(this.F.MINIGUN = new MinigunTower.MinigunTowerFactory());
/* 184 */     this.a[TowerType.MISSILE.ordinal()] = (Tower.Factory)(this.F.MISSILE = new MissileTower.MissileTowerFactory());
/* 185 */     this.a[TowerType.MULTISHOT.ordinal()] = (Tower.Factory)(this.F.MULTISHOT = new MultishotTower.MultishotTowerFactory());
/* 186 */     this.a[TowerType.SNIPER.ordinal()] = (Tower.Factory)(this.F.SNIPER = new SniperTower.SniperTowerFactory());
/* 187 */     this.a[TowerType.SPLASH.ordinal()] = (Tower.Factory)(this.F.SPLASH = new SplashTower.SplashTowerFactory());
/* 188 */     this.a[TowerType.TESLA.ordinal()] = (Tower.Factory)(this.F.TESLA = new TeslaTower.TeslaTowerFactory());
/* 189 */     this.a[TowerType.VENOM.ordinal()] = (Tower.Factory)(this.F.VENOM = new VenomTower.VenomTowerFactory());
/* 190 */     this.a[TowerType.FLAMETHROWER.ordinal()] = (Tower.Factory)(this.F.FLAMETHROWER = new FlamethrowerTower.FlamethrowerTowerFactory());
/* 191 */     this.a[TowerType.LASER.ordinal()] = (Tower.Factory)(this.F.LASER = new LaserTower.LaserTowerFactory());
/* 192 */     this.a[TowerType.GAUSS.ordinal()] = (Tower.Factory)(this.F.GAUSS = new GaussTower.GaussTowerFactory());
/* 193 */     this.a[TowerType.CRUSHER.ordinal()] = (Tower.Factory)(this.F.CRUSHER = new CrusherTower.CrusherTowerFactory());
/*     */     
/* 195 */     for (i = (arrayOfTowerType = TowerType.values).length, b = 0; b < i; ) { TowerType towerType = arrayOfTowerType[b];
/* 196 */       if (this.a[towerType.ordinal()] == null) {
/* 197 */         throw new RuntimeException("Not all tower factories were created");
/*     */       }
/*     */       
/*     */       b++; }
/*     */     
/* 202 */     JsonValue jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/tower-enemy-attack-matrix.json"));
/* 203 */     Array array = new Array(); JsonValue.JsonIterator<JsonValue> jsonIterator;
/* 204 */     for (jsonIterator = jsonValue.get("columns").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 205 */       array.add(TowerType.valueOf(jsonValue1.asString())); }
/*     */     
/* 207 */     for (jsonIterator = jsonValue.get("values").iterator(); jsonIterator.hasNext(); ) {
/* 208 */       JsonValue jsonValue1; EnemyType enemyType = EnemyType.valueOf((jsonValue1 = jsonIterator.next()).name);
/* 209 */       byte b1 = 0;
/* 210 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue1.iterator(); jsonIterator1.hasNext(); ) { JsonValue jsonValue2 = jsonIterator1.next();
/* 211 */         this.canTowerAttackEnemy[enemyType.ordinal()][((TowerType)array.get(b1)).ordinal()] = jsonValue2.asBoolean();
/* 212 */         b1++; }
/*     */     
/*     */     } 
/*     */ 
/*     */     
/* 217 */     jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/tower-enemy-damage-matrix.json"));
/* 218 */     array = new Array();
/* 219 */     for (jsonIterator = jsonValue.get("columns").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 220 */       array.add(TowerType.valueOf(jsonValue1.asString())); }
/*     */     
/* 222 */     for (jsonIterator = jsonValue.get("values").iterator(); jsonIterator.hasNext(); ) {
/* 223 */       JsonValue jsonValue1; EnemyType enemyType = EnemyType.valueOf((jsonValue1 = jsonIterator.next()).name);
/* 224 */       byte b1 = 0;
/* 225 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue1.iterator(); jsonIterator1.hasNext(); ) { JsonValue jsonValue2 = jsonIterator1.next();
/* 226 */         this.towerEnemyDamageMultiplier[enemyType.ordinal()][((TowerType)array.get(b1)).ordinal()] = jsonValue2.asFloat();
/* 227 */         b1++; }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public final float getStatBarCoeff(TowerStatType paramTowerStatType, float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 234 */     if (paramTowerStatType == TowerStatType.DAMAGE) {
/* 235 */       if (paramFloat2 < 1000.0F) {
/* 236 */         f = Interpolation.pow3Out.apply(paramFloat1 / paramFloat2);
/* 237 */       } else if (paramFloat2 < 3000.0F) {
/* 238 */         f = Interpolation.pow4Out.apply(paramFloat1 / paramFloat2);
/* 239 */       } else if (paramFloat2 < 10000.0F) {
/* 240 */         f = Interpolation.pow5Out.apply(paramFloat1 / paramFloat2);
/*     */       } else {
/*     */         
/* 243 */         f = Interpolation.pow5Out.apply(paramFloat1 / 10000.0F);
/*     */       } 
/*     */     } else {
/* 246 */       f = paramFloat1 / paramFloat2;
/*     */     } 
/*     */     
/* 249 */     return MathUtils.clamp(f, 0.0F, 1.0F);
/*     */   } public static class Factories {
/*     */     public BasicTower.BasicTowerFactory BASIC; public AirTower.AirTowerFactory AIR; public BlastTower.BlastTowerFactory BLAST; public CannonTower.CannonTowerFactory CANNON; public FreezingTower.FreezingTowerFactory FREEZING; public MinigunTower.MinigunTowerFactory MINIGUN; public MissileTower.MissileTowerFactory MISSILE; public MultishotTower.MultishotTowerFactory MULTISHOT; public SniperTower.SniperTowerFactory SNIPER; public SplashTower.SplashTowerFactory SPLASH; public TeslaTower.TeslaTowerFactory TESLA; public VenomTower.VenomTowerFactory VENOM; public FlamethrowerTower.FlamethrowerTowerFactory FLAMETHROWER; public LaserTower.LaserTowerFactory LASER; public GaussTower.GaussTowerFactory GAUSS; public CrusherTower.CrusherTowerFactory CRUSHER; }
/*     */   public final void reloadTowerStats() {
/*     */     JsonValue jsonValue;
/* 254 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/tower-stats.json"))).iterator(); jsonIterator.hasNext(); ) {
/* 255 */       JsonValue jsonValue1; TowerType towerType = TowerType.valueOf((jsonValue1 = jsonIterator.next()).name);
/* 256 */       TowerStatsConfig towerStatsConfig = new TowerStatsConfig((byte)0);
/* 257 */       this.d[towerType.ordinal()] = towerStatsConfig;
/*     */       
/* 259 */       JsonValue jsonValue3 = jsonValue1.get("prices");
/* 260 */       byte b = 0;
/* 261 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator2 = jsonValue3.iterator(); jsonIterator2.hasNext(); ) { JsonValue jsonValue4 = jsonIterator2.next();
/* 262 */         towerStatsConfig.a[b++] = jsonValue4.asInt(); }
/*     */       
/* 264 */       if (b != 10) throw new RuntimeException("Tower " + towerType.name() + " has " + b + "/10 prices");
/*     */       
/* 266 */       towerStatsConfig.b = jsonValue1.getFloat("upgradePriceMultiplier", 1.0F);
/*     */ 
/*     */       
/* 269 */       JsonValue jsonValue2 = jsonValue1.get("stats");
/* 270 */       Array array = new Array(TowerStatType.class);
/* 271 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue2.iterator(); jsonIterator1.hasNext(); ) {
/* 272 */         TowerStatType towerStatType = TowerStatType.valueOf((jsonValue2 = jsonIterator1.next()).name);
/* 273 */         array.add(towerStatType);
/*     */         
/* 275 */         TowerStatConfig towerStatConfig = new TowerStatConfig();
/* 276 */         towerStatsConfig.c.put(towerStatType.ordinal(), towerStatConfig);
/*     */         
/* 278 */         towerStatConfig.minValue = jsonValue2.getFloat("min", Float.MIN_VALUE);
/* 279 */         towerStatConfig.maxValue = jsonValue2.getFloat("max", Float.MAX_VALUE);
/* 280 */         towerStatConfig.unique = jsonValue2.getBoolean("unique", false);
/* 281 */         towerStatConfig.pwrFactor = jsonValue2.getFloat("pwrFactor", 1.0F);
/* 282 */         towerStatConfig.pwrPowerFactor = jsonValue2.getFloat("pwrPowerFactor", 1.0F);
/*     */         String str;
/* 284 */         if ((str = jsonValue2.getString("rounding", null)) != null) {
/* 285 */           switch (str) {
/*     */             case "middle":
/* 287 */               towerStatConfig.rounding = 2;
/*     */               break;
/*     */             case "ceil":
/* 290 */               towerStatConfig.rounding = 3;
/*     */               break;
/*     */             case "floor":
/* 293 */               towerStatConfig.rounding = 1;
/*     */               break;
/*     */           } 
/*     */         
/*     */         }
/* 298 */         if (jsonValue2.hasChild("gvMultipliers")) {
/* 299 */           Array array1 = new Array(GameValueType.class);
/* 300 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator3 = jsonValue2.get("gvMultipliers").iterator(); jsonIterator3.hasNext(); ) { JsonValue jsonValue4 = jsonIterator3.next();
/* 301 */             array1.add(GameValueType.valueOf(jsonValue4.asString())); }
/*     */           
/* 303 */           towerStatConfig.gameValueMultipliers = (GameValueType[])array1.toArray();
/*     */         } else {
/* 305 */           towerStatConfig.gameValueMultipliers = null;
/*     */         } 
/*     */         
/* 308 */         if (towerStatConfig.unique) {
/* 309 */           towerStatConfig.values = new float[999];
/*     */         } else {
/* 311 */           towerStatConfig.values = new float[11];
/*     */         } 
/*     */         
/* 314 */         if (jsonValue2.has("values")) {
/*     */           
/* 316 */           JsonValue jsonValue4 = jsonValue2.get("values");
/* 317 */           byte b2 = 0;
/* 318 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator3 = jsonValue4.iterator(); jsonIterator3.hasNext(); ) { JsonValue jsonValue5 = jsonIterator3.next();
/* 319 */             towerStatConfig.values[b2++] = jsonValue5.asFloat(); }
/*     */           
/* 321 */           if (b2 != towerStatConfig.values.length) throw new RuntimeException("Tower " + towerType.name() + " has " + b2 + "/" + towerStatConfig.values.length + " values for " + towerStatType.name()); 
/*     */           continue;
/*     */         } 
/* 324 */         float f1 = jsonValue2.getFloat("startValue");
/* 325 */         float f2 = jsonValue2.getFloat("valueDelta");
/* 326 */         float f3 = jsonValue2.getFloat("deltaPower", 1.0F);
/* 327 */         for (byte b1 = 0; b1 < towerStatConfig.values.length; b1++) {
/* 328 */           towerStatConfig.values[b1] = f1 + (float)Math.pow((b1 * f2), f3);
/*     */         }
/*     */       } 
/*     */       
/* 332 */       towerStatsConfig.d = (TowerStatType[])array.toArray();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 342 */     reloadTowerStats(); Tower.Factory[] arrayOfFactory; int i;
/*     */     byte b;
/* 344 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/* 345 */       Tower.Factory factory; (factory = arrayOfFactory[b]).setup();
/*     */     } 
/*     */     
/* 348 */     if (Game.i.assetManager != null) {
/* 349 */       this.abilityAvailableParticleEffectPool = Game.i.assetManager.getParticleEffectPool("ability-available-mark.prt");
/* 350 */       this.upgradeParticles = Game.i.assetManager.getParticleEffectPool("upgrade.prt");
/* 351 */       this.lvlUpParticles = Game.i.assetManager.getParticleEffectPool("lvl-up.prt");
/*     */       TowerType[] arrayOfTowerType;
/* 353 */       for (i = (arrayOfTowerType = TowerType.values).length, b = 0; b < i; ) { TowerType towerType = arrayOfTowerType[b];
/*     */         ParticleEffect particleEffect;
/* 355 */         (particleEffect = new ParticleEffect()).load(Gdx.files.internal("particles/building-highlight.prt"), Game.i.assetManager.getTextureRegion("tower-basic-base").getAtlas());
/* 356 */         particleEffect.setEmittersCleanUpBlendFunction(false);
/*     */         
/* 358 */         Array array = new Array(Sprite.class);
/* 359 */         Sprite sprite = new Sprite((TextureRegion)Game.i.assetManager.getTextureRegion("tower-" + towerType.name().toLowerCase(Locale.US) + "-shape"));
/* 360 */         array.add(sprite);
/* 361 */         ((ParticleEmitter)particleEffect.getEmitters().first()).setSprites(array);
/* 362 */         Color color = getFactory(towerType).getColor();
/* 363 */         float[] arrayOfFloat = ((ParticleEmitter)particleEffect.getEmitters().first()).getTint().getColors();
/* 364 */         for (byte b1 = 0; b1 < arrayOfFloat.length; b1 += 3) {
/* 365 */           arrayOfFloat[b1] = color.r;
/* 366 */           arrayOfFloat[b1 + 1] = color.g;
/* 367 */           arrayOfFloat[b1 + 2] = color.b;
/*     */         } 
/*     */         
/* 370 */         this.highlightParticles[towerType.ordinal()] = Game.i.assetManager.getParticleEffectPoolWithTemplate("building-highlight.prt@towerType:" + towerType.name(), particleEffect);
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */   public final Tower.Factory<? extends Tower> getFactory(TowerType paramTowerType) {
/* 376 */     return this.a[paramTowerType.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getStatFromConfig(TowerType paramTowerType, TowerStatType paramTowerStatType, int paramInt1, int paramInt2, GameValueProvider paramGameValueProvider) {
/*     */     float f;
/* 383 */     if (paramGameValueProvider == null) throw new IllegalArgumentException("gvp is null"); 
/* 384 */     if (paramInt1 > 10) throw new IllegalArgumentException("Upgrade level is " + paramInt1 + ", max 10"); 
/* 385 */     if (paramInt2 > 999) throw new IllegalArgumentException("Experience level is " + paramInt2 + ", max 20");
/*     */     
/*     */     TowerStatConfig towerStatConfig;
/* 388 */     if ((towerStatConfig = (TowerStatConfig)(this.d[paramTowerType.ordinal()]).c.get(paramTowerStatType.ordinal())) == null) throw new IllegalArgumentException(paramTowerType.name() + " has no " + paramTowerStatType.name());
/*     */     
/* 390 */     if (towerStatConfig.unique) {
/* 391 */       f = towerStatConfig.values[paramInt2 - 1];
/*     */     } else {
/* 393 */       f = towerStatConfig.values[paramInt1];
/*     */     } 
/*     */     
/* 396 */     if (towerStatConfig.gameValueMultipliers != null) {
/* 397 */       f = (float)(f * paramGameValueProvider.getPercentValueAsMultiplierSumAll(towerStatConfig.gameValueMultipliers));
/*     */     }
/*     */     
/* 400 */     switch (towerStatConfig.rounding) { case 1:
/* 401 */         f = MathUtils.floor(f); break;
/* 402 */       case 2: f = MathUtils.round(f); break;
/* 403 */       case 3: f = MathUtils.ceil(f);
/*     */         break; }
/*     */     
/* 406 */     return f;
/*     */   }
/*     */   
/*     */   public final TowerStatType[] getStatTypes(TowerType paramTowerType) {
/* 410 */     return (this.d[paramTowerType.ordinal()]).d;
/*     */   }
/*     */   
/*     */   public final TowerStatConfig getStatConfig(TowerType paramTowerType, TowerStatType paramTowerStatType) {
/* 414 */     return (TowerStatConfig)(this.d[paramTowerType.ordinal()]).c.get(paramTowerStatType.ordinal());
/*     */   }
/*     */   
/*     */   public final boolean hasStat(TowerType paramTowerType, TowerStatType paramTowerStatType) {
/* 418 */     return (this.d[paramTowerType.ordinal()]).c.containsKey(paramTowerStatType.ordinal());
/*     */   }
/*     */   
/*     */   public final float clampStat(TowerType paramTowerType, TowerStatType paramTowerStatType, float paramFloat) {
/*     */     TowerStatConfig towerStatConfig;
/* 423 */     if ((towerStatConfig = (TowerStatConfig)(this.d[paramTowerType.ordinal()]).c.get(paramTowerStatType.ordinal())).minValue != Float.MIN_VALUE && paramFloat < towerStatConfig.minValue) {
/* 424 */       paramFloat = towerStatConfig.minValue;
/*     */     }
/* 426 */     if (towerStatConfig.maxValue != Float.MAX_VALUE && paramFloat > towerStatConfig.maxValue) {
/* 427 */       paramFloat = towerStatConfig.maxValue;
/*     */     }
/*     */     
/* 430 */     switch (towerStatConfig.rounding) { case 1:
/* 431 */         paramFloat = MathUtils.floor(paramFloat); break;
/* 432 */       case 2: paramFloat = MathUtils.round(paramFloat); break;
/* 433 */       case 3: paramFloat = MathUtils.ceil(paramFloat);
/*     */         break; }
/*     */     
/* 436 */     return paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getUpgradePrice(TowerType paramTowerType, int paramInt, GameValueProvider paramGameValueProvider) {
/* 443 */     return 
/* 444 */       (int)((this.d[paramTowerType.ordinal()]).a[paramInt - 1] * paramGameValueProvider.getPercentValueAsMultiplierSum(GameValueType.TOWERS_UPGRADE_PRICE, getUpgradePriceGameValueType(paramTowerType)));
/*     */   }
/*     */   
/*     */   public final float getUpgradePriceMultiplier(TowerType paramTowerType) {
/* 448 */     return (this.d[paramTowerType.ordinal()]).b;
/*     */   }
/*     */   
/*     */   public final Tower fromJson(JsonValue paramJsonValue) {
/* 452 */     TowerType towerType = TowerType.valueOf(paramJsonValue.getString("type"));
/*     */     
/*     */     Tower tower;
/* 455 */     (tower = getFactory(towerType).create()).loadFromJson(paramJsonValue);
/*     */     
/* 457 */     return tower;
/*     */   }
/*     */   
/*     */   public final String getAimStrategyName(Tower.AimStrategy paramAimStrategy) {
/* 461 */     String str = this.b[paramAimStrategy.ordinal()];
/*     */     
/* 463 */     return Game.i.localeManager.i18n.get(str);
/*     */   }
/*     */   
/*     */   public final String getAimStrategyIconAlias(Tower.AimStrategy paramAimStrategy) {
/* 467 */     return this.c[paramAimStrategy.ordinal()];
/*     */   }
/*     */   
/*     */   public final TextureRegion getAimStrategyIcon(Tower.AimStrategy paramAimStrategy) {
/* 471 */     return (TextureRegion)Game.i.assetManager.getTextureRegion(getAimStrategyIconAlias(paramAimStrategy));
/*     */   }
/*     */   
/*     */   public final Color getAimStrategyColor(Tower.AimStrategy paramAimStrategy) {
/* 475 */     switch (null.a[paramAimStrategy.ordinal()]) { case 1:
/* 476 */         return MaterialColor.CYAN.P800;
/* 477 */       case 2: return MaterialColor.BLUE.P800;
/* 478 */       case 3: return MaterialColor.DEEP_ORANGE.P800;
/* 479 */       case 4: return MaterialColor.GREEN.P800;
/* 480 */       case 5: return MaterialColor.YELLOW.P900;
/* 481 */       case 6: return MaterialColor.PURPLE.P700; }
/*     */ 
/*     */     
/* 484 */     return null;
/*     */   }
/*     */   
/*     */   public final String getTitle(TowerType paramTowerType) {
/* 488 */     int i = paramTowerType.ordinal();
/* 489 */     return Game.i.localeManager.i18n.get(this.k[i]);
/*     */   }
/*     */   
/*     */   public final String getDescription(TowerType paramTowerType) {
/* 493 */     int i = paramTowerType.ordinal();
/* 494 */     return Game.i.localeManager.i18n.get(this.l[i]);
/*     */   }
/*     */   
/*     */   public final String getUniqueStatDescription(TowerType paramTowerType) {
/* 498 */     int i = paramTowerType.ordinal();
/* 499 */     return Game.i.localeManager.i18n.get(this.m[i]);
/*     */   }
/*     */   
/*     */   public final GameValueType getUpgradePriceGameValueType(TowerType paramTowerType) {
/* 503 */     return this.n[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getPriceGameValueType(TowerType paramTowerType) {
/* 507 */     return this.o[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getMaxExpLevelGameValueType(TowerType paramTowerType) {
/* 511 */     return this.p[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getMaxUpgradeLevelGameValueType(TowerType paramTowerType) {
/* 515 */     return this.q[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getExperienceGenerationGameValueType(TowerType paramTowerType) {
/* 519 */     return this.r[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getPplTill10GameValueType(TowerType paramTowerType) {
/* 523 */     return this.s[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getPplAfter10GameValueType(TowerType paramTowerType) {
/* 527 */     return this.t[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getExperienceMultiplierGameValueType(TowerType paramTowerType) {
/* 531 */     return this.u[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getTowerGameValueType(TowerType paramTowerType) {
/* 535 */     return this.v[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getStartingLevelGameValueType(TowerType paramTowerType) {
/* 539 */     return this.w[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getStartingPwrGameValueType(TowerType paramTowerType) {
/* 543 */     return this.x[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final GameValueType getPowerfulAbilityGameValueType(TowerType paramTowerType) {
/* 547 */     return this.y[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final StatisticsType getMoneySpentStatisticType(TowerType paramTowerType) {
/* 551 */     return this.e[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final StatisticsType getUpgradedStatisticType(TowerType paramTowerType) {
/* 555 */     return this.i[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final StatisticsType getDamageDealtStatisticType(TowerType paramTowerType) {
/* 559 */     return this.f[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final StatisticsType getEnemiesKilledStatisticsType(TowerType paramTowerType) {
/* 563 */     return this.j[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final StatisticsType getBuiltStatisticType(TowerType paramTowerType) {
/* 567 */     return this.g[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final StatisticsType getSoldStatisticType(TowerType paramTowerType) {
/* 571 */     return this.h[paramTowerType.ordinal()];
/*     */   }
/*     */   
/*     */   public final CharSequence getGeneralizedTowerStatName(GeneralizedTowerStatType paramGeneralizedTowerStatType) {
/* 575 */     switch (null.b[paramGeneralizedTowerStatType.ordinal()]) { case 1:
/* 576 */         return Game.i.localeManager.i18n.get("generalized_tower_stat_RANGE");
/* 577 */       case 2: return Game.i.localeManager.i18n.get("generalized_tower_stat_ATTACK_SPEED");
/* 578 */       case 3: return Game.i.localeManager.i18n.get("generalized_tower_stat_DAMAGE");
/* 579 */       case 4: return Game.i.localeManager.i18n.get("generalized_tower_stat_CROWD_DAMAGE");
/* 580 */       case 5: return Game.i.localeManager.i18n.get("generalized_tower_stat_AGILITY"); }
/* 581 */      return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public final Color getGeneralizedTowerStatColor(GeneralizedTowerStatType paramGeneralizedTowerStatType) {
/* 586 */     switch (null.b[paramGeneralizedTowerStatType.ordinal()]) { case 1:
/* 587 */         return MaterialColor.GREEN.P500;
/* 588 */       case 2: return MaterialColor.ORANGE.P500;
/* 589 */       case 3: return MaterialColor.RED.P500;
/* 590 */       case 4: return MaterialColor.PINK.P500;
/* 591 */       case 5: return MaterialColor.PURPLE.P500; }
/* 592 */      return Color.WHITE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {}
/*     */ 
/*     */   
/*     */   private static class TowerStatsConfig
/*     */   {
/* 602 */     int[] a = new int[10];
/*     */     float b;
/* 604 */     IntMap<TowerManager.TowerStatConfig> c = new IntMap();
/*     */     
/*     */     TowerStatType[] d;
/*     */ 
/*     */     
/*     */     public String toString() {
/*     */       StringBuilder stringBuilder;
/* 611 */       (stringBuilder = new StringBuilder()).append("TowerStatsConfig { ");
/* 612 */       stringBuilder.append("prices: ").append(Arrays.toString(this.a)).append(", ");
/* 613 */       stringBuilder.append("upgradePriceMultiplier: ").append(this.b).append(", ");
/* 614 */       stringBuilder.append("configs: ").append(this.c).append(", ");
/* 615 */       stringBuilder.append("statTypes: ").append(Arrays.toString((Object[])this.d)).append(", ");
/* 616 */       stringBuilder.append("}");
/*     */       
/* 618 */       return stringBuilder.toString();
/*     */     }
/*     */     private TowerStatsConfig() {} }
/*     */   public static class TowerStatConfig { public GameValueType[] gameValueMultipliers; public boolean unique; public int rounding; public float pwrFactor; public float pwrPowerFactor; public float[] values; public float minValue;
/*     */     public float maxValue;
/*     */     
/*     */     public TowerStatConfig() {
/* 625 */       this.rounding = 0;
/*     */       
/* 627 */       this.pwrPowerFactor = 1.0F;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/*     */       StringBuilder stringBuilder;
/* 636 */       (stringBuilder = new StringBuilder()).append("TowerStatConfig { ");
/* 637 */       stringBuilder.append("gameValueMultipliers: ").append((this.gameValueMultipliers == null) ? "null" : Arrays.toString((Object[])this.gameValueMultipliers)).append(", ");
/* 638 */       stringBuilder.append("unique: ").append(this.unique).append(", ");
/* 639 */       stringBuilder.append("rounding: ").append(this.rounding).append(", ");
/* 640 */       stringBuilder.append("pwrFactor: ").append(this.pwrFactor).append(", ");
/* 641 */       stringBuilder.append("pwrPowerFactor: ").append(this.pwrPowerFactor).append(", ");
/* 642 */       stringBuilder.append("values: ").append(Arrays.toString(this.values)).append(", ");
/* 643 */       stringBuilder.append("minValue: ").append(this.minValue).append(", ");
/* 644 */       stringBuilder.append("maxValue: ").append(this.maxValue);
/* 645 */       stringBuilder.append("}");
/*     */       
/* 647 */       return stringBuilder.toString();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\TowerManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */