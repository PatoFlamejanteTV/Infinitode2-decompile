/*      */ package com.prineside.tdi2;
/*      */ 
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.tdi2.abilities.LoopAbility;
/*      */ import com.prineside.tdi2.components.PowerBonuses;
/*      */ import com.prineside.tdi2.enums.BuildingType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*      */ import com.prineside.tdi2.enums.ModifierType;
/*      */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*      */ import com.prineside.tdi2.enums.TowerStatType;
/*      */ import com.prineside.tdi2.enums.TowerType;
/*      */ import com.prineside.tdi2.managers.AssetManager;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.TowerManager;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.shapes.RangeCircle;
/*      */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*      */ import com.prineside.tdi2.systems.MapSystem;
/*      */ import com.prineside.tdi2.systems.TowerSystem;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.MultiReasonBool;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.ObjectFilter;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.Quad;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ 
/*      */ @REGS(classOnly = true)
/*      */ public abstract class Tower
/*      */   extends Building
/*      */ {
/*   55 */   private static final TLog e = TLog.forClass(Tower.class);
/*      */   
/*      */   public static final int ABILITY_INDEX_SPECIAL = 3;
/*      */   
/*      */   public static final int ABILITY_INDEX_ULTIMATE = 4;
/*      */   
/*      */   public static final int ABILITY_INDEX_POWERFUL = 5;
/*      */   
/*      */   public static final int ABILITIES_COUNT = 6;
/*      */   public static final int DPS_STAT_SLOTS = 10;
/*      */   public static final float DPS_STAT_INTERVAL = 10.0F;
/*      */   public static final short MAX_LEVEL = 999;
/*      */   public static final byte MAX_UPGRADE_LEVEL = 10;
/*   68 */   private static final Color f = new Color(0.56F, 0.56F, 0.56F, 1.0F);
/*   69 */   public static final Color SHADOW_COLOR = new Color(0.0F, 0.0F, 0.0F, 0.21F);
/*      */   
/*   71 */   public static final String[] ABILITY_NAMES = new String[] { "", "", "", "SPECIAL", "ULTIMATE", "POWERFUL" };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int[] LEVEL_EXPERIENCE;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*   82 */     (LEVEL_EXPERIENCE = new int[1000])[0] = 0;
/*   83 */     LEVEL_EXPERIENCE[1] = 0;
/*   84 */     LEVEL_EXPERIENCE[2] = 60;
/*   85 */     LEVEL_EXPERIENCE[3] = 80;
/*   86 */     LEVEL_EXPERIENCE[4] = 110;
/*   87 */     LEVEL_EXPERIENCE[5] = 140;
/*   88 */     LEVEL_EXPERIENCE[6] = 180;
/*   89 */     LEVEL_EXPERIENCE[7] = 220;
/*   90 */     LEVEL_EXPERIENCE[8] = 260;
/*   91 */     LEVEL_EXPERIENCE[9] = 300;
/*   92 */     LEVEL_EXPERIENCE[10] = 350;
/*   93 */     LEVEL_EXPERIENCE[11] = 400;
/*   94 */     LEVEL_EXPERIENCE[12] = 450;
/*   95 */     LEVEL_EXPERIENCE[13] = 500;
/*   96 */     LEVEL_EXPERIENCE[14] = 550;
/*   97 */     LEVEL_EXPERIENCE[15] = 600;
/*   98 */     LEVEL_EXPERIENCE[16] = 650;
/*   99 */     LEVEL_EXPERIENCE[17] = 700;
/*  100 */     LEVEL_EXPERIENCE[18] = 750;
/*  101 */     LEVEL_EXPERIENCE[19] = 800;
/*  102 */     LEVEL_EXPERIENCE[20] = 850; int i;
/*  103 */     for (i = 21; i < 1000; i++) {
/*  104 */       LEVEL_EXPERIENCE[i] = (i - 20) * 50 + 850;
/*      */     }
/*      */   }
/*      */   
/*  108 */   public static final int[] LEVEL_EXPERIENCE_MILESTONES = new int[1000]; private static final AimStrategyEnemyComparator[] g; public int id; public TowerType type;
/*      */   static {
/*  110 */     i = 0;
/*  111 */     for (byte b = 0; b <= 'ϧ'; b++) {
/*  112 */       i += LEVEL_EXPERIENCE[b];
/*  113 */       LEVEL_EXPERIENCE_MILESTONES[b] = i;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  146 */     (g = new AimStrategyEnemyComparator[AimStrategy.values.length])[AimStrategy.FIRST.ordinal()] = ((paramTower, paramEnemy1, paramEnemy2) -> {
/*      */         float f1 = (paramEnemy1.graphPath == null) ? 9001.0F : (paramEnemy1.graphPath.getLengthInTiles() - paramEnemy1.passedTiles);
/*      */         float f2 = (paramEnemy2.graphPath == null) ? 9001.0F : (paramEnemy2.graphPath.getLengthInTiles() - paramEnemy2.passedTiles);
/*      */         return (f1 < f2);
/*      */       });
/*  151 */     g[AimStrategy.LAST.ordinal()] = ((paramTower, paramEnemy1, paramEnemy2) -> {
/*      */         float f1 = (paramEnemy1.graphPath == null) ? 9001.0F : (paramEnemy1.graphPath.getLengthInTiles() - paramEnemy1.passedTiles);
/*      */         float f2 = (paramEnemy2.graphPath == null) ? 9001.0F : (paramEnemy2.graphPath.getLengthInTiles() - paramEnemy2.passedTiles);
/*      */         return (f1 > f2);
/*      */       });
/*  156 */     g[AimStrategy.WEAKEST.ordinal()] = ((paramTower, paramEnemy1, paramEnemy2) -> (paramEnemy1.getHealth() < paramEnemy2.getHealth()));
/*  157 */     g[AimStrategy.STRONGEST.ordinal()] = ((paramTower, paramEnemy1, paramEnemy2) -> (paramEnemy1.getHealth() > paramEnemy2.getHealth()));
/*  158 */     g[AimStrategy.NEAREST.ordinal()] = ((paramTower, paramEnemy1, paramEnemy2) -> ((paramTower.getTile()).center.dst2(paramEnemy1.getPosition()) < (paramTower.getTile()).center.dst2(paramEnemy2.getPosition())));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*  163 */   public AimStrategy aimStrategy = AimStrategy.FIRST; @REGS public enum AimStrategy {
/*  164 */     FIRST, LAST, WEAKEST, STRONGEST, NEAREST, RANDOM; public static final AimStrategy[] values = values(); static {  } } public int moneySpentOn = 0;
/*      */   
/*      */   private float h;
/*      */   
/*      */   protected byte a;
/*      */   
/*      */   public byte bountyModifiersNearby;
/*      */   
/*      */   private byte i;
/*      */   
/*      */   public PowerBonuses powerBonuses;
/*      */   @FrameAccumulatorForPerformance
/*      */   private byte j;
/*      */   protected boolean b;
/*  178 */   public float damageGiven = 0.0F;
/*  179 */   public int shotCount = 0;
/*      */   
/*      */   public float loopAbilityDamageBuffer;
/*      */   
/*      */   @Null
/*      */   public LoopAbility affectedByLoopAbility;
/*  185 */   public float angle = 0.0F;
/*  186 */   public float experience = 0.0F;
/*  187 */   public float currentLevelExperience = 0.0F;
/*  188 */   public float nextLevelExperience = 0.0F;
/*      */ 
/*      */   
/*  191 */   public short level = 1;
/*  192 */   private byte k = 0;
/*  193 */   public boolean[] installedAbilities = new boolean[6];
/*      */   
/*      */   private byte l;
/*      */   
/*      */   protected float c;
/*      */   public float rangeInPixels;
/*      */   public float minRangeInPixels;
/*  200 */   public float experienceGeneration = 0.0F;
/*  201 */   public float experienceMultiplier = 1.0F;
/*      */   
/*  203 */   public MultiReasonBool outOfOrder = new MultiReasonBool();
/*      */ 
/*      */   
/*      */   public boolean attackDisabled;
/*      */ 
/*      */   
/*  209 */   private float[] m = new float[TowerStatType.values.length];
/*      */   private float n;
/*  211 */   private float o = 0.0F;
/*      */ 
/*      */   
/*  214 */   private Enemy.EnemyReference p = Enemy.EnemyReference.NULL;
/*      */   
/*      */   @NAGS
/*      */   public ParticleEffectPool.PooledEffect abilityAvailableParticleEffect;
/*  218 */   public float[] dpsDamage = new float[10];
/*  219 */   public float[] dpsTime = new float[10];
/*  220 */   public float mdps = 0.0F;
/*  221 */   public int enemiesKilled = 0;
/*  222 */   public float bonusCoinsBrought = 0.0F;
/*      */   
/*  224 */   protected static final StringBuilder d = new StringBuilder();
/*      */ 
/*      */   
/*      */   public void write(Kryo paramKryo, Output paramOutput) {
/*  228 */     super.write(paramKryo, paramOutput);
/*  229 */     paramOutput.writeVarInt(this.id, true);
/*  230 */     paramKryo.writeObjectOrNull(paramOutput, this.type, TowerType.class);
/*  231 */     paramKryo.writeObject(paramOutput, this.aimStrategy);
/*  232 */     paramOutput.writeVarInt(this.moneySpentOn, true);
/*  233 */     paramOutput.writeFloat(this.h);
/*  234 */     paramOutput.writeByte(this.a);
/*  235 */     paramOutput.writeByte(this.bountyModifiersNearby);
/*  236 */     paramOutput.writeByte(this.i);
/*  237 */     paramKryo.writeObjectOrNull(paramOutput, this.powerBonuses, PowerBonuses.class);
/*  238 */     paramOutput.writeByte(this.j);
/*  239 */     paramOutput.writeBoolean(this.b);
/*  240 */     paramOutput.writeFloat(this.damageGiven);
/*  241 */     paramOutput.writeVarInt(this.shotCount, true);
/*  242 */     paramOutput.writeFloat(this.loopAbilityDamageBuffer);
/*  243 */     paramKryo.writeClassAndObject(paramOutput, this.affectedByLoopAbility);
/*  244 */     paramOutput.writeFloat(this.angle);
/*  245 */     paramOutput.writeFloat(this.experience);
/*  246 */     paramOutput.writeFloat(this.currentLevelExperience);
/*  247 */     paramOutput.writeFloat(this.nextLevelExperience);
/*  248 */     paramOutput.writeShort(this.level);
/*  249 */     paramOutput.writeByte(this.k);
/*  250 */     paramKryo.writeObject(paramOutput, this.installedAbilities);
/*  251 */     paramOutput.writeByte(this.l);
/*  252 */     paramOutput.writeFloat(this.c);
/*  253 */     paramOutput.writeFloat(this.rangeInPixels);
/*  254 */     paramOutput.writeFloat(this.minRangeInPixels);
/*  255 */     paramOutput.writeFloat(this.experienceGeneration);
/*  256 */     paramOutput.writeFloat(this.experienceMultiplier);
/*  257 */     paramKryo.writeObject(paramOutput, this.m);
/*  258 */     paramOutput.writeFloat(this.n);
/*  259 */     paramOutput.writeFloat(this.o);
/*  260 */     paramKryo.writeObjectOrNull(paramOutput, this.outOfOrder, MultiReasonBool.class);
/*  261 */     paramOutput.writeBoolean(this.attackDisabled);
/*  262 */     paramKryo.writeObject(paramOutput, this.p);
/*  263 */     paramKryo.writeObject(paramOutput, this.dpsDamage);
/*  264 */     paramKryo.writeObject(paramOutput, this.dpsTime);
/*  265 */     paramOutput.writeFloat(this.mdps);
/*  266 */     paramOutput.writeInt(this.enemiesKilled);
/*  267 */     paramOutput.writeFloat(this.bonusCoinsBrought);
/*      */   }
/*      */ 
/*      */   
/*      */   public void read(Kryo paramKryo, Input paramInput) {
/*  272 */     super.read(paramKryo, paramInput);
/*  273 */     this.id = paramInput.readVarInt(true);
/*  274 */     this.type = (TowerType)paramKryo.readObjectOrNull(paramInput, TowerType.class);
/*  275 */     this.aimStrategy = (AimStrategy)paramKryo.readObject(paramInput, AimStrategy.class);
/*  276 */     this.moneySpentOn = paramInput.readVarInt(true);
/*  277 */     this.h = paramInput.readFloat();
/*  278 */     this.a = paramInput.readByte();
/*  279 */     this.bountyModifiersNearby = paramInput.readByte();
/*  280 */     this.i = paramInput.readByte();
/*  281 */     this.powerBonuses = (PowerBonuses)paramKryo.readObjectOrNull(paramInput, PowerBonuses.class);
/*  282 */     this.j = paramInput.readByte();
/*  283 */     this.b = paramInput.readBoolean();
/*  284 */     this.damageGiven = paramInput.readFloat();
/*  285 */     this.shotCount = paramInput.readVarInt(true);
/*  286 */     this.loopAbilityDamageBuffer = paramInput.readFloat();
/*  287 */     this.affectedByLoopAbility = (LoopAbility)paramKryo.readClassAndObject(paramInput);
/*  288 */     this.angle = paramInput.readFloat();
/*  289 */     this.experience = paramInput.readFloat();
/*  290 */     this.currentLevelExperience = paramInput.readFloat();
/*  291 */     this.nextLevelExperience = paramInput.readFloat();
/*  292 */     this.level = paramInput.readShort();
/*  293 */     this.k = paramInput.readByte();
/*  294 */     this.installedAbilities = (boolean[])paramKryo.readObject(paramInput, boolean[].class);
/*  295 */     this.l = paramInput.readByte();
/*  296 */     this.c = paramInput.readFloat();
/*  297 */     this.rangeInPixels = paramInput.readFloat();
/*  298 */     this.minRangeInPixels = paramInput.readFloat();
/*  299 */     this.experienceGeneration = paramInput.readFloat();
/*  300 */     this.experienceMultiplier = paramInput.readFloat();
/*  301 */     this.m = (float[])paramKryo.readObject(paramInput, float[].class);
/*  302 */     this.n = paramInput.readFloat();
/*  303 */     this.o = paramInput.readFloat();
/*  304 */     this.outOfOrder = (MultiReasonBool)paramKryo.readObjectOrNull(paramInput, MultiReasonBool.class);
/*  305 */     this.attackDisabled = paramInput.readBoolean();
/*  306 */     this.p = (Enemy.EnemyReference)paramKryo.readObject(paramInput, Enemy.EnemyReference.class);
/*  307 */     this.dpsDamage = (float[])paramKryo.readObject(paramInput, float[].class);
/*  308 */     this.dpsTime = (float[])paramKryo.readObject(paramInput, float[].class);
/*  309 */     this.mdps = paramInput.readFloat();
/*  310 */     this.enemiesKilled = paramInput.readInt();
/*  311 */     this.bonusCoinsBrought = paramInput.readFloat();
/*      */   }
/*      */   
/*      */   protected Tower(TowerType paramTowerType) {
/*  315 */     super(BuildingType.TOWER);
/*      */     
/*  317 */     this.type = paramTowerType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAimStrategy(AimStrategy paramAimStrategy) {
/*  329 */     this.aimStrategy = paramAimStrategy;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRegistered(GameSystemProvider paramGameSystemProvider) {
/*  334 */     super.setRegistered(paramGameSystemProvider);
/*      */ 
/*      */     
/*  337 */     setExperience(this.experience);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setUnregistered() {
/*  342 */     this.p = Enemy.EnemyReference.NULL;
/*      */ 
/*      */     
/*  345 */     super.setUnregistered();
/*      */   }
/*      */ 
/*      */   
/*      */   public float getWalkCost() {
/*  350 */     return 262144.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void toJson(Json paramJson) {
/*  358 */     super.toJson(paramJson);
/*      */     
/*  360 */     paramJson.writeValue("type", this.type.name());
/*      */     
/*  362 */     paramJson.writeValue("as", this.aimStrategy.name());
/*      */ 
/*      */ 
/*      */     
/*  366 */     paramJson.writeValue("e", Float.valueOf(this.experience));
/*  367 */     paramJson.writeValue("ul", Byte.valueOf(this.k));
/*  368 */     paramJson.writeArrayStart("ia"); boolean[] arrayOfBoolean; int i; byte b;
/*  369 */     for (i = (arrayOfBoolean = this.installedAbilities).length, b = 0; b < i; ) { boolean bool = arrayOfBoolean[b];
/*  370 */       paramJson.writeValue(Boolean.valueOf(bool)); b++; }
/*      */     
/*  372 */     paramJson.writeArrayEnd();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void loadFromJson(JsonValue paramJsonValue) {
/*      */     try {
/*  380 */       this.aimStrategy = AimStrategy.valueOf(paramJsonValue.getString("as"));
/*  381 */       this.k = (byte)paramJsonValue.getInt("ul");
/*      */       
/*  383 */       this.experience = paramJsonValue.getFloat("e");
/*  384 */       byte b = 0;
/*  385 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = paramJsonValue.get("ia").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/*  386 */         this.installedAbilities[b] = jsonValue.asBoolean();
/*  387 */         b++; }
/*      */       
/*  389 */       calculateXpLevel(true); return;
/*  390 */     } catch (Exception exception) {
/*  391 */       e.e("failed to load tower from json", new Object[] { exception });
/*      */       return;
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean sameAs(Building paramBuilding) {
/*  397 */     if (!super.sameAs(paramBuilding)) return false;
/*      */     
/*  399 */     if (((Tower)(paramBuilding = paramBuilding)).type != this.type) return false;
/*      */     
/*  401 */     if (((Tower)paramBuilding).aimStrategy != this.aimStrategy) return false; 
/*  402 */     if (((Tower)paramBuilding).k != this.k) return false; 
/*  403 */     for (byte b = 0; b < this.installedAbilities.length; b++) {
/*  404 */       if (this.installedAbilities[b] != ((Tower)paramBuilding).installedAbilities[b]) return false; 
/*      */     } 
/*  406 */     if (((Tower)paramBuilding).angle != this.angle) return false; 
/*  407 */     if (((Tower)paramBuilding).currentLevelExperience != this.currentLevelExperience) return false; 
/*  408 */     if (((Tower)paramBuilding).experience != this.experience) return false; 
/*  409 */     if (((Tower)paramBuilding).level != this.level) return false; 
/*  410 */     if (((Tower)paramBuilding).nextLevelExperience != this.nextLevelExperience) return false; 
/*  411 */     if (((Tower)paramBuilding).moneySpentOn != this.moneySpentOn) return false;
/*      */     
/*  413 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Tower cloneBuilding() {
/*      */     Tower tower;
/*  420 */     ((Tower)(tower = (Tower)Game.i.towerManager.getFactory(this.type).create())).aimStrategy = this.aimStrategy;
/*  421 */     tower.k = this.k;
/*  422 */     System.arraycopy(this.installedAbilities, 0, tower.installedAbilities, 0, this.installedAbilities.length);
/*      */ 
/*      */ 
/*      */     
/*  426 */     tower.angle = this.angle;
/*  427 */     tower.currentLevelExperience = this.currentLevelExperience;
/*      */     
/*  429 */     tower.experience = this.experience;
/*  430 */     tower.level = this.level;
/*  431 */     tower.nextLevelExperience = this.nextLevelExperience;
/*  432 */     tower.moneySpentOn = this.moneySpentOn;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  437 */     return tower;
/*      */   }
/*      */   
/*      */   public final boolean isOutOfOrder() {
/*  441 */     return this.outOfOrder.isTrue();
/*      */   }
/*      */   @Null
/*      */   public Enemy getTarget() {
/*  445 */     return this.p.enemy;
/*      */   }
/*      */   
/*      */   public void setTarget(Enemy paramEnemy) {
/*  449 */     this.p = this.S.enemy.getReference(paramEnemy);
/*  450 */     if (this.p == null) {
/*  451 */       throw new IllegalArgumentException("Reference is null");
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean canNewAbilityBeInstalled() {
/*      */     TowerSystem.TowerAbilityCategoryRule[] arrayOfTowerAbilityCategoryRule;
/*      */     int i;
/*      */     byte b;
/*  459 */     for (i = (arrayOfTowerAbilityCategoryRule = this.S.tower.towerAbilityCategoryRules).length, b = 0; b < i; b++) {
/*  460 */       TowerSystem.TowerAbilityCategoryRule towerAbilityCategoryRule; if (!(towerAbilityCategoryRule = arrayOfTowerAbilityCategoryRule[b]).autoInstallSingleVariant) {
/*      */         
/*  462 */         byte b1 = 0; byte b2;
/*  463 */         for (b2 = 0; b2 < towerAbilityCategoryRule.requiredXpLevels.size; b2++) {
/*  464 */           int j = towerAbilityCategoryRule.requiredXpLevels.get(b2);
/*  465 */           if (this.level >= j) {
/*  466 */             b1++;
/*      */           }
/*      */         } 
/*      */         
/*  470 */         b2 = 0;
/*  471 */         for (byte b3 = 0; b3 < 6; b3++) {
/*  472 */           if (this.installedAbilities[b3] && this.S.tower.towerAbilityIdxToCategory[b3] == towerAbilityCategoryRule.categoryId) {
/*  473 */             b2++;
/*      */           }
/*      */         } 
/*      */         
/*  477 */         if (b1 > b2) {
/*  478 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/*  482 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean canAbilityBeInstalled(int paramInt) {
/*  490 */     int i = this.S.tower.towerAbilityIdxToCategory[paramInt];
/*  491 */     TowerSystem.TowerAbilityCategoryRule towerAbilityCategoryRule = this.S.tower.towerAbilityCategoryRules[i];
/*      */     
/*  493 */     if (this.installedAbilities[paramInt] || towerAbilityCategoryRule.autoInstallSingleVariant) return false;
/*      */     
/*  495 */     paramInt = 0; byte b;
/*  496 */     for (b = 0; b < 6; b++) {
/*  497 */       if (this.installedAbilities[b] && this.S.tower.towerAbilityIdxToCategory[b] == i) {
/*  498 */         paramInt++;
/*      */       }
/*      */     } 
/*  501 */     if (paramInt >= towerAbilityCategoryRule.requiredXpLevels.size)
/*      */     {
/*  503 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  507 */     b = 0;
/*  508 */     for (i = 0; i < towerAbilityCategoryRule.requiredXpLevels.size; i++) {
/*  509 */       int j = towerAbilityCategoryRule.requiredXpLevels.get(i);
/*  510 */       if (this.level >= j) {
/*  511 */         b++;
/*      */       }
/*      */     } 
/*  514 */     return (b > paramInt);
/*      */   }
/*      */   
/*      */   public final boolean isAbilityInstalled(int paramInt) {
/*  518 */     if (this.installedAbilities[paramInt]) {
/*  519 */       return true;
/*      */     }
/*      */     
/*  522 */     if (this.S == null) return false;
/*      */     
/*  524 */     paramInt = this.S.tower.towerAbilityIdxToCategory[paramInt];
/*      */     TowerSystem.TowerAbilityCategoryRule towerAbilityCategoryRule;
/*  526 */     if ((towerAbilityCategoryRule = this.S.tower.towerAbilityCategoryRules[paramInt]).autoInstallSingleVariant && this.level >= towerAbilityCategoryRule.requiredXpLevels.items[0]) return true;  return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getLevelForExperience(float paramFloat) {
/*  531 */     byte b1 = 1;
/*      */     
/*  533 */     for (byte b2 = 1; b2 <= 'ϧ' && 
/*  534 */       paramFloat >= LEVEL_EXPERIENCE_MILESTONES[b2]; b2++) {
/*  535 */       b1 = b2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  541 */     return b1;
/*      */   }
/*      */   
/*      */   public static int getLevelForExperienceFast(float paramFloat) {
/*  545 */     if (paramFloat >= LEVEL_EXPERIENCE_MILESTONES[LEVEL_EXPERIENCE_MILESTONES.length - 1]) {
/*  546 */       return LEVEL_EXPERIENCE_MILESTONES.length - 1;
/*      */     }
/*  548 */     if (paramFloat <= LEVEL_EXPERIENCE_MILESTONES[0]) {
/*  549 */       return 1;
/*      */     }
/*      */     
/*  552 */     int i = (int)paramFloat;
/*  553 */     int j = 0;
/*  554 */     int k = 998;
/*      */     
/*  556 */     while (j <= k) {
/*  557 */       int m = j + k >>> 1;
/*      */       
/*      */       int n;
/*  560 */       if ((n = LEVEL_EXPERIENCE_MILESTONES[m]) < i) {
/*  561 */         j = m + 1; continue;
/*  562 */       }  if (n > i) {
/*  563 */         k = m - 1;
/*      */         continue;
/*      */       } 
/*  566 */       return m;
/*      */     } 
/*      */ 
/*      */     
/*  570 */     return j - 1;
/*      */   }
/*      */   
/*      */   public void addExperience(float paramFloat) {
/*  574 */     setExperience(this.experience + paramFloat);
/*      */   }
/*      */   
/*      */   public static float getLevelExperienceMilestone(int paramInt) {
/*  578 */     return LEVEL_EXPERIENCE_MILESTONES[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setExperience(float paramFloat) {
/*  586 */     this.experience = paramFloat;
/*      */   }
/*      */   
/*      */   public short getMaxTowerLevel() {
/*  590 */     int i = this.S.gameValue.getIntValueSum(GameValueType.TOWERS_MAX_EXP_LEVEL, Game.i.towerManager.getMaxExpLevelGameValueType(this.type)) + this.i;
/*  591 */     return (short)Math.max(1, Math.min(i, 999));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void calculateXpLevel(boolean paramBoolean) {
/*      */     short s;
/*  605 */     if (paramBoolean) {
/*  606 */       s = 999;
/*  607 */       for (short s1 = 1; s1 <= 999 && 
/*  608 */         (int)this.experience >= LEVEL_EXPERIENCE_MILESTONES[s1]; s1 = (short)(s1 + 1))
/*      */       {
/*  610 */         this.level = s1;
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  617 */       s = getMaxTowerLevel();
/*      */       
/*  619 */       if (getLevel() < s) {
/*      */         
/*  621 */         for (short s1 = (short)(getLevel() + 1); s1 <= s && 
/*  622 */           (int)this.experience >= LEVEL_EXPERIENCE_MILESTONES[s1]; s1 = (short)(s1 + 1))
/*      */         {
/*  624 */           this.level = s1;
/*      */ 
/*      */         
/*      */         }
/*      */       
/*      */       }
/*  630 */       else if (getLevel() > s) {
/*  631 */         setLevel(s);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  636 */     if (getLevel() != s) {
/*      */       
/*  638 */       this.nextLevelExperience = LEVEL_EXPERIENCE[getLevel() + 1];
/*      */     } else {
/*      */       
/*  641 */       this.nextLevelExperience = 0.0F;
/*      */     } 
/*  643 */     this.currentLevelExperience = this.experience - LEVEL_EXPERIENCE_MILESTONES[getLevel()];
/*      */   }
/*      */   
/*      */   public byte getMaxUpgradeLevel() {
/*      */     int i;
/*  648 */     return (byte)Math.min(i = this.S.gameValue.getIntValueSum(GameValueType.TOWERS_MAX_UPGRADE_LEVEL, Game.i.towerManager.getMaxUpgradeLevelGameValueType(this.type)), 10);
/*      */   }
/*      */   
/*      */   public short getLevel() {
/*  652 */     return this.level;
/*      */   }
/*      */   
/*      */   public void setLevel(short paramShort) {
/*  656 */     this.level = paramShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getPowerCombinedMultiplier() {
/*  663 */     return this.n;
/*      */   }
/*      */   
/*      */   private void a() {
/*      */     Enemy enemy;
/*  668 */     if ((enemy = getTarget()) != null) {
/*      */       
/*  670 */       if (!PMath.circleIntersectsCircleV((getTile()).center, this.rangeInPixels, enemy.getPosition(), enemy.getSize())) {
/*      */         
/*  672 */         setTarget((Enemy)null); return;
/*  673 */       }  if (this.minRangeInPixels != 0.0F) {
/*      */         float f;
/*      */         
/*  676 */         if ((f = (getTile()).center.dst2(enemy.getPosition())) < this.minRangeInPixels * this.minRangeInPixels)
/*      */         {
/*      */           
/*  679 */           setTarget((Enemy)null);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void b() {
/*  686 */     if (getTarget() == null) {
/*      */ 
/*      */       
/*  689 */       this.l = (byte)(this.l + 1);
/*  690 */       if (this.l == 6) {
/*      */         
/*  692 */         this.l = 0;
/*      */ 
/*      */         
/*  695 */         setTarget(findTarget());
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void c() {
/*  701 */     if (this.a != 0) {
/*  702 */       this.j = (byte)(this.j + 1);
/*  703 */       if (this.j >= 7 && this.b) {
/*      */ 
/*      */         
/*  706 */         Enemy enemy = findTarget();
/*  707 */         if (getTarget() != enemy) {
/*  708 */           setTarget(enemy);
/*      */         }
/*      */         
/*  711 */         this.j = 0;
/*  712 */         this.b = false;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void d() {
/*  718 */     if (getTarget() == null || !canAttack())
/*      */     {
/*  720 */       this.c = StrictMath.min(this.c, getAttackDelay());
/*      */     }
/*      */   }
/*      */   
/*      */   private void e() {
/*  725 */     if (getTarget() != null)
/*      */     {
/*  727 */       if (canAttack()) {
/*      */         
/*  729 */         float f = getAttackDelay();
/*      */         int i;
/*  731 */         if ((i = (int)(this.c / f)) > 0) {
/*      */           
/*  733 */           attack(i);
/*      */ 
/*      */ 
/*      */           
/*  737 */           this.b = true;
/*      */           
/*  739 */           this.c -= f * i;
/*  740 */           if (this.c < 0.0F) this.c = 0.0F; 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void update(float paramFloat) {
/*  747 */     this.h += paramFloat;
/*      */     
/*  749 */     this.outOfOrder.update(paramFloat);
/*      */     
/*  751 */     if (isOutOfOrder())
/*      */       return; 
/*  753 */     if (shouldSearchForTarget()) {
/*      */       
/*  755 */       this.c += paramFloat;
/*      */       
/*  757 */       c();
/*  758 */       d();
/*  759 */       a();
/*  760 */       b();
/*  761 */       e();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSellPrice() {
/*  768 */     if (isSellFullRefundStillActive()) {
/*  769 */       return this.moneySpentOn;
/*      */     }
/*  771 */     float f1 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWERS_SELL_REFUND);
/*      */     
/*      */     float f2;
/*  774 */     if (getTile() != null && (getTile()).bonusType == SpaceTileBonusType.SELL_REFUND && (getTile()).bonusLevel > 0 && (
/*      */       
/*  776 */       f2 = SpaceTileBonus.getEffect(SpaceTileBonusType.SELL_REFUND, (getTile()).bonusLevel)) > f1) {
/*  777 */       f1 = f2;
/*      */     }
/*      */     
/*  780 */     if (f1 > 1.0F) f1 = 1.0F;
/*      */     
/*  782 */     return (int)(this.moneySpentOn * f1);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isSellFullRefundStillActive() {
/*  787 */     return (this.h < 15.0F && this.k == 0 && this.damageGiven == 0.0F && this.shotCount == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Enemy findTarget() {
/*  793 */     return findTargetFiltered((ObjectFilter<Enemy>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Enemy findTargetFiltered(@Null ObjectFilter<Enemy> paramObjectFilter) {
/*  801 */     Enemy enemy = null;
/*      */     
/*  803 */     if (paramObjectFilter == null) {
/*  804 */       paramObjectFilter = (paramEnemy -> true);
/*      */     }
/*      */     
/*  807 */     Array<Enemy> array = this.S.TSH.getEnemyArray();
/*  808 */     int[] arrayOfInt = { -1 };
/*      */     
/*  810 */     float f1 = (getTile()).center.x;
/*  811 */     float f2 = (getTile()).center.y;
/*      */     
/*  813 */     paramObjectFilter = paramObjectFilter;
/*  814 */     this.S.map.getEnemiesInCircle(f1, f2, this.rangeInPixels, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*      */           Enemy enemy;
/*      */           
/*      */           if ((enemy = paramEnemyReference.enemy) != null && canAttackEnemy(enemy) && paramObjectFilter.test(enemy)) {
/*      */             int i;
/*      */             if ((i = getEnemyPriority(enemy)) > paramArrayOfint[0]) {
/*      */               paramArrayOfint[0] = i;
/*      */               paramArray.clear();
/*      */               paramArray.add(enemy);
/*      */               return true;
/*      */             } 
/*      */             if (i == paramArrayOfint[0]) {
/*      */               paramArray.add(enemy);
/*      */             }
/*      */           } 
/*      */           return true;
/*      */         });
/*  831 */     if (this.aimStrategy == AimStrategy.RANDOM) {
/*      */       
/*  833 */       if (array.size != 0) {
/*  834 */         enemy = (Enemy)array.get(this.S.gameState.randomInt(array.size));
/*      */       }
/*      */     } else {
/*      */       
/*  838 */       AimStrategyEnemyComparator aimStrategyEnemyComparator = g[this.aimStrategy.ordinal()];
/*      */       
/*  840 */       for (byte b = 0; b < array.size; b++) {
/*  841 */         Enemy enemy1 = ((Enemy[])array.items)[b];
/*  842 */         if (enemy == null || aimStrategyEnemyComparator.compare(this, enemy1, enemy)) {
/*  843 */           enemy = enemy1;
/*      */         }
/*      */       } 
/*      */     } 
/*  847 */     this.S.TSH.freeEnemyArray(array);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  856 */     return enemy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte getUpgradeLevel() {
/*  975 */     return this.k;
/*      */   }
/*      */   
/*      */   public void upgradeToLevel(byte paramByte) {
/*  979 */     if (paramByte > getMaxUpgradeLevel()) paramByte = getMaxUpgradeLevel();
/*      */     
/*  981 */     this.k = paramByte;
/*      */     
/*  983 */     this.S.map.markTilesDirtyNearTile((Tile)getTile(), 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUpgradeLevel(byte paramByte) {
/*  992 */     if (paramByte < 0) paramByte = 0; 
/*  993 */     if (paramByte > 10) paramByte = 10;
/*      */     
/*  995 */     this.k = paramByte;
/*      */   }
/*      */   
/*      */   public void upgrade() {
/*  999 */     upgradeToLevel((byte)(this.k + 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateCache() {
/* 1034 */     this.a = 0;
/* 1035 */     int[] arrayOfInt1 = { 0 };
/* 1036 */     int[] arrayOfInt2 = { 0 };
/* 1037 */     this.bountyModifiersNearby = 0;
/* 1038 */     int[] arrayOfInt3 = { 0 };
/* 1039 */     int[] arrayOfInt4 = { 0 };
/* 1040 */     int[] arrayOfInt5 = { 0 };
/* 1041 */     int[] arrayOfInt6 = { 0 };
/* 1042 */     this.i = 0;
/*      */     
/* 1044 */     this.S.map.traverseNeighborTilesAroundTile((Tile)getTile(), paramTile -> {
/*      */           // Byte code:
/*      */           //   0: aload #7
/*      */           //   2: instanceof com/prineside/tdi2/tiles/PlatformTile
/*      */           //   5: ifeq -> 282
/*      */           //   8: aload #7
/*      */           //   10: checkcast com/prineside/tdi2/tiles/PlatformTile
/*      */           //   13: dup
/*      */           //   14: astore #8
/*      */           //   16: getfield building : Lcom/prineside/tdi2/Building;
/*      */           //   19: instanceof com/prineside/tdi2/Modifier
/*      */           //   22: ifeq -> 282
/*      */           //   25: aload #8
/*      */           //   27: getfield building : Lcom/prineside/tdi2/Building;
/*      */           //   30: checkcast com/prineside/tdi2/Modifier
/*      */           //   33: astore #8
/*      */           //   35: getstatic com/prineside/tdi2/Tower$1.b : [I
/*      */           //   38: aload #8
/*      */           //   40: getfield type : Lcom/prineside/tdi2/enums/ModifierType;
/*      */           //   43: invokevirtual ordinal : ()I
/*      */           //   46: iaload
/*      */           //   47: tableswitch default -> 282, 1 -> 88, 2 -> 134, 3 -> 148, 4 -> 158, 5 -> 168, 6 -> 182, 7 -> 233
/*      */           //   88: aload #8
/*      */           //   90: checkcast com/prineside/tdi2/modifiers/BalanceModifier
/*      */           //   93: astore_1
/*      */           //   94: aload_0
/*      */           //   95: getfield i : B
/*      */           //   98: aload_1
/*      */           //   99: invokevirtual getLevel : ()I
/*      */           //   102: iadd
/*      */           //   103: bipush #127
/*      */           //   105: if_icmpge -> 125
/*      */           //   108: aload_0
/*      */           //   109: dup
/*      */           //   110: getfield i : B
/*      */           //   113: aload_1
/*      */           //   114: invokevirtual getLevel : ()I
/*      */           //   117: iadd
/*      */           //   118: i2b
/*      */           //   119: putfield i : B
/*      */           //   122: goto -> 282
/*      */           //   125: aload_0
/*      */           //   126: bipush #127
/*      */           //   128: putfield i : B
/*      */           //   131: goto -> 282
/*      */           //   134: aload_0
/*      */           //   135: dup
/*      */           //   136: getfield a : B
/*      */           //   139: iconst_1
/*      */           //   140: iadd
/*      */           //   141: i2b
/*      */           //   142: putfield a : B
/*      */           //   145: goto -> 282
/*      */           //   148: aload_1
/*      */           //   149: iconst_0
/*      */           //   150: dup2
/*      */           //   151: iaload
/*      */           //   152: iconst_1
/*      */           //   153: iadd
/*      */           //   154: iastore
/*      */           //   155: goto -> 282
/*      */           //   158: aload_2
/*      */           //   159: iconst_0
/*      */           //   160: dup2
/*      */           //   161: iaload
/*      */           //   162: iconst_1
/*      */           //   163: iadd
/*      */           //   164: iastore
/*      */           //   165: goto -> 282
/*      */           //   168: aload_0
/*      */           //   169: dup
/*      */           //   170: getfield bountyModifiersNearby : B
/*      */           //   173: iconst_1
/*      */           //   174: iadd
/*      */           //   175: i2b
/*      */           //   176: putfield bountyModifiersNearby : B
/*      */           //   179: goto -> 282
/*      */           //   182: aload #7
/*      */           //   184: invokevirtual getY : ()I
/*      */           //   187: aload_0
/*      */           //   188: invokevirtual getTile : ()Lcom/prineside/tdi2/tiles/PlatformTile;
/*      */           //   191: invokevirtual getY : ()I
/*      */           //   194: if_icmpeq -> 212
/*      */           //   197: aload #7
/*      */           //   199: invokevirtual getX : ()I
/*      */           //   202: aload_0
/*      */           //   203: invokevirtual getTile : ()Lcom/prineside/tdi2/tiles/PlatformTile;
/*      */           //   206: invokevirtual getX : ()I
/*      */           //   209: if_icmpne -> 222
/*      */           //   212: aload_3
/*      */           //   213: iconst_0
/*      */           //   214: dup2
/*      */           //   215: iaload
/*      */           //   216: iconst_1
/*      */           //   217: iadd
/*      */           //   218: iastore
/*      */           //   219: goto -> 282
/*      */           //   222: aload #4
/*      */           //   224: iconst_0
/*      */           //   225: dup2
/*      */           //   226: iaload
/*      */           //   227: iconst_1
/*      */           //   228: iadd
/*      */           //   229: iastore
/*      */           //   230: goto -> 282
/*      */           //   233: aload #7
/*      */           //   235: invokevirtual getY : ()I
/*      */           //   238: aload_0
/*      */           //   239: invokevirtual getTile : ()Lcom/prineside/tdi2/tiles/PlatformTile;
/*      */           //   242: invokevirtual getY : ()I
/*      */           //   245: if_icmpeq -> 263
/*      */           //   248: aload #7
/*      */           //   250: invokevirtual getX : ()I
/*      */           //   253: aload_0
/*      */           //   254: invokevirtual getTile : ()Lcom/prineside/tdi2/tiles/PlatformTile;
/*      */           //   257: invokevirtual getX : ()I
/*      */           //   260: if_icmpne -> 274
/*      */           //   263: aload #5
/*      */           //   265: iconst_0
/*      */           //   266: dup2
/*      */           //   267: iaload
/*      */           //   268: iconst_1
/*      */           //   269: iadd
/*      */           //   270: iastore
/*      */           //   271: goto -> 282
/*      */           //   274: aload #6
/*      */           //   276: iconst_0
/*      */           //   277: dup2
/*      */           //   278: iaload
/*      */           //   279: iconst_1
/*      */           //   280: iadd
/*      */           //   281: iastore
/*      */           //   282: iconst_1
/*      */           //   283: ireturn
/*      */           // Line number table:
/*      */           //   Java source line number -> byte code offset
/*      */           //   #1045	-> 0
/*      */           //   #1046	-> 8
/*      */           //   #1047	-> 14
/*      */           //   #1048	-> 25
/*      */           //   #1049	-> 35
/*      */           //   #1051	-> 88
/*      */           //   #1052	-> 94
/*      */           //   #1053	-> 108
/*      */           //   #1055	-> 125
/*      */           //   #1057	-> 131
/*      */           //   #1059	-> 134
/*      */           //   #1060	-> 148
/*      */           //   #1061	-> 158
/*      */           //   #1062	-> 168
/*      */           //   #1064	-> 182
/*      */           //   #1065	-> 212
/*      */           //   #1067	-> 222
/*      */           //   #1069	-> 230
/*      */           //   #1072	-> 233
/*      */           //   #1073	-> 263
/*      */           //   #1075	-> 274
/*      */           //   #1082	-> 282
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1088 */     float f3 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.MODIFIER_POWER_VALUE);
/* 1089 */     float f4 = getStartingPwr(this.type, (GameValueProvider)this.S.gameValue) * 0.01F;
/*      */ 
/*      */ 
/*      */     
/* 1093 */     float f2 = (f2 = f4 + 1.0F + f3 * arrayOfInt1[0]) + getExpLevelStatBonusPercentage(getLevel(), this.type, (GameValueProvider)this.S.gameValue);
/*      */ 
/*      */     
/* 1096 */     if (getTile() != null && (getTile()).bonusType == SpaceTileBonusType.PWR_MULTIPLIER && (getTile()).bonusLevel != 0) {
/* 1097 */       f2 *= SpaceTileBonus.getEffect(SpaceTileBonusType.PWR_MULTIPLIER, (getTile()).bonusLevel);
/*      */     }
/*      */ 
/*      */     
/* 1101 */     if (isAbilityInstalled(5)) {
/* 1102 */       f2 = (float)(f2 * (this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWERS_POWERFUL_ABILITY_PWR) + this.S.gameValue.getPercentValueAsMultiplier(Game.i.towerManager.getPowerfulAbilityGameValueType(this.type))));
/*      */     }
/*      */ 
/*      */     
/* 1106 */     if (this.powerBonuses != null) {
/* 1107 */       f2 += this.powerBonuses.getBonusesSum();
/*      */     }
/* 1109 */     this.n = f2; TowerStatType[] arrayOfTowerStatType;
/*      */     int i;
/*      */     byte b;
/* 1112 */     for (i = (arrayOfTowerStatType = Game.i.towerManager.getStatTypes(this.type)).length, b = 0; b < i; ) { TowerStatType towerStatType = arrayOfTowerStatType[b];
/*      */       
/* 1114 */       float f = calculateStat(towerStatType);
/*      */       
/* 1116 */       if (getTile() != null) {
/*      */         SpaceTileBonusType spaceTileBonusType;
/*      */         
/* 1119 */         if ((spaceTileBonusType = SpaceTileBonus.a[towerStatType.ordinal()]) != null && spaceTileBonusType == (getTile()).bonusType && (getTile()).bonusLevel > 0) {
/* 1120 */           f *= SpaceTileBonus.getEffect(spaceTileBonusType, (getTile()).bonusLevel);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1125 */       if (isStatAffectedByPower(towerStatType)) {
/* 1126 */         TowerManager.TowerStatConfig towerStatConfig = Game.i.towerManager.getStatConfig(this.type, towerStatType);
/*      */ 
/*      */         
/* 1129 */         float f5 = (float)StrictMath.pow((((f5 = this.n) - 1.0F) * 100.0F * towerStatConfig.pwrFactor), towerStatConfig.pwrPowerFactor) * 0.01F + 1.0F;
/*      */ 
/*      */         
/* 1132 */         f *= f5;
/*      */       } 
/*      */ 
/*      */       
/* 1136 */       switch (null.a[towerStatType.ordinal()]) {
/*      */         
/*      */         case 1:
/* 1139 */           f = (f = (float)(f + f * arrayOfInt3[0] * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.MODIFIER_DAMAGE_VALUE))) - f * arrayOfInt6[0] * 0.05F;
/*      */           break;
/*      */ 
/*      */         
/*      */         case 2:
/* 1144 */           f = (f = (float)(f + f * arrayOfInt5[0] * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.MODIFIER_ATTACK_SPEED_VALUE))) - f * arrayOfInt4[0] * 0.05F;
/*      */           break;
/*      */         
/*      */         case 3:
/* 1148 */           f = (float)(f + f * this.a * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.MODIFIER_SEARCH_RANGE_VALUE));
/*      */           break;
/*      */         
/*      */         case 4:
/*      */         case 5:
/* 1153 */           f -= f * arrayOfInt2[0] * 0.05F;
/*      */           break;
/*      */       } 
/*      */ 
/*      */       
/* 1158 */       this.m[towerStatType.ordinal()] = Game.i.towerManager.clampStat(this.type, towerStatType, f); b++; }
/*      */     
/*      */     float f1;
/* 1161 */     if ((f1 = getStat(TowerStatType.ATTACK_SPEED)) == 0.0F) {
/* 1162 */       this.o = 0.0F;
/*      */     } else {
/* 1164 */       this.o = 1.0F / f1;
/*      */     } 
/*      */ 
/*      */     
/* 1168 */     this.rangeInPixels = getRange() * 128.0F;
/* 1169 */     this.minRangeInPixels = getMinRange() * 128.0F;
/*      */ 
/*      */     
/* 1172 */     this.experienceGeneration = this.S.gameValue.getFloatValueSum(GameValueType.TOWERS_EXPERIENCE_GENERATION, Game.i.towerManager.getExperienceGenerationGameValueType(this.type));
/* 1173 */     this.experienceGeneration *= this.k / 10.0F;
/* 1174 */     this.experienceMultiplier = (float)this.S.gameValue.getPercentValueAsMultiplierSum(GameValueType.TOWERS_EXPERIENCE_MULTIPLIER, Game.i.towerManager.getExperienceMultiplierGameValueType(this.type));
/*      */     
/* 1176 */     if (getTile() != null && (getTile()).bonusType == SpaceTileBonusType.BONUS_EXPERIENCE && (getTile()).bonusLevel > 0) {
/* 1177 */       this.experienceMultiplier *= SpaceTileBonus.getEffect((getTile()).bonusType, (getTile()).bonusLevel);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float getExpLevelStatBonusPercentage(int paramInt, TowerType paramTowerType, GameValueProvider paramGameValueProvider) {
/* 1187 */     double d1 = paramGameValueProvider.getPercentValueAsMultiplier(GameValueType.TOWERS_POWER_PER_LEVEL_TILL_10);
/* 1188 */     double d2 = paramGameValueProvider.getPercentValueAsMultiplier(Game.i.towerManager.getPplTill10GameValueType(paramTowerType));
/*      */     
/* 1190 */     d1 += d2;
/*      */     
/* 1192 */     if (paramInt <= 10) {
/* 1193 */       return (float)(d1 * (paramInt - 1));
/*      */     }
/* 1195 */     double d3 = paramGameValueProvider.getPercentValueAsMultiplier(Game.i.towerManager.getPplAfter10GameValueType(paramTowerType));
/*      */     
/* 1197 */     return (float)(d1 * 9.0D + (paramInt - 10) * (paramGameValueProvider.getPercentValueAsMultiplier(GameValueType.TOWERS_POWER_PER_LEVEL_AFTER_10) + d3));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isStatAffectedByPower(TowerStatType paramTowerStatType) {
/* 1202 */     return (!(Game.i.towerManager.getStatConfig(this.type, paramTowerStatType)).unique && paramTowerStatType != TowerStatType.RANGE && paramTowerStatType != TowerStatType.MIN_RANGE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final float getStat(TowerStatType paramTowerStatType) {
/* 1210 */     return this.m[paramTowerStatType.ordinal()];
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void dispose() {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void applyDrawInterpolation(float paramFloat) {}
/*      */ 
/*      */   
/*      */   public void drawBatch(Batch paramBatch, float paramFloat) {
/* 1223 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_TOWER_XP) != 0.0D && (getTile()).visibleOnScreen) {
/*      */       ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont;
/*      */       
/* 1226 */       (resourcePackBitmapFont = Game.i.assetManager.getFont(21)).draw(paramBatch, "xp: " + ((int)(this.experience * 10.0F) / 10.0F), (getTile()).center.x - 32.0F, (getTile()).center.y - 64.0F + 40.0F);
/* 1227 */       resourcePackBitmapFont.draw(paramBatch, "clxp: " + ((int)(this.currentLevelExperience * 10.0F) / 10.0F), (getTile()).center.x - 32.0F, (getTile()).center.y - 64.0F + 20.0F);
/*      */     } 
/*      */     
/* 1230 */     if (this.S != null && this.S._mapRendering != null && this.S._mapRendering.getDrawMode() == MapRenderingSystem.DrawMode.DETAILED && this.affectedByLoopAbility != null) {
/*      */       
/* 1232 */       paramFloat = (getTile().getX() << 7) + 7.0F;
/* 1233 */       float f = (getTile().getY() << 7) + 85.0F;
/* 1234 */       paramBatch.setColor(Config.BACKGROUND_COLOR);
/* 1235 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).roundedSmallRect, paramFloat, f, 36.0F, 36.0F);
/* 1236 */       paramBatch.setColor(MaterialColor.GREEN.P900);
/* 1237 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).iconLoop, paramFloat, f, 36.0F, 36.0F);
/* 1238 */       paramBatch.setColor(Color.WHITE);
/*      */       
/* 1240 */       ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont = Game.i.assetManager.getFont(18);
/* 1241 */       StringBuilder stringBuilder = StringFormatter.compactNumber(this.loopAbilityDamageBuffer, false);
/* 1242 */       resourcePackBitmapFont.setColor(Config.BACKGROUND_COLOR);
/* 1243 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)stringBuilder, paramFloat, f + 24.0F + 1.5F, 36.0F, 1, false);
/* 1244 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)stringBuilder, paramFloat, f + 24.0F - 1.5F, 36.0F, 1, false);
/* 1245 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)stringBuilder, paramFloat - 1.5F, f + 24.0F, 36.0F, 1, false);
/* 1246 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)stringBuilder, paramFloat + 1.5F, f + 24.0F, 36.0F, 1, false);
/* 1247 */       resourcePackBitmapFont.setColor(MaterialColor.GREEN.P200);
/* 1248 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)stringBuilder, paramFloat, f + 24.0F, 36.0F, 1, false);
/* 1249 */       resourcePackBitmapFont.setColor(Color.WHITE);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void drawBatchAdditive(Batch paramBatch, float paramFloat) {}
/*      */ 
/*      */   
/*      */   private void a(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {
/* 1258 */     Factory factory = Game.i.towerManager.getFactory(this.type);
/*      */ 
/*      */     
/* 1261 */     paramBatch.setColor(SHADOW_COLOR);
/* 1262 */     factory.getShadowTextures().draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */     
/* 1264 */     if (paramDrawMode == MapRenderingSystem.DrawMode.DEFAULT) {
/*      */       
/* 1266 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/* 1267 */       factory.getBaseTextures().draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 1268 */       if (factory.a != null) {
/* 1269 */         factory.a.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4); return;
/*      */       } 
/* 1271 */     } else if (paramDrawMode == MapRenderingSystem.DrawMode.DETAILED || paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR) {
/*      */ 
/*      */       
/* 1274 */       paramBatch.setColor(f);
/* 1275 */       factory.getBaseTextures().draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 1276 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void b(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {
/* 1281 */     Factory factory = Game.i.towerManager.getFactory(this.type);
/*      */     
/* 1283 */     if (paramDrawMode == MapRenderingSystem.DrawMode.DETAILED || paramDrawMode == MapRenderingSystem.DrawMode.MAP_EDITOR) {
/*      */       
/* 1285 */       float f = paramFloat3 * 0.0078125F;
/* 1286 */       paramFloat4 *= 0.0078125F;
/*      */ 
/*      */       
/* 1289 */       if ((getTile()).bonusLevel != 0) {
/* 1290 */         paramBatch.setColor(Config.BACKGROUND_COLOR);
/* 1291 */         paramBatch.draw(factory.roundedSmallRectTextureRegion, paramFloat1 + 7.0F * f, paramFloat2 + 7.0F * paramFloat4, 36.0F * f, 36.0F * paramFloat4);
/* 1292 */         paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/* 1293 */         getTile().drawBonusExtras(paramBatch, paramFloat1 + 3.0F * f, paramFloat2 + 3.0F * paramFloat4, 44.0F * f, 44.0F * paramFloat4, false, true);
/*      */       } 
/*      */ 
/*      */       
/* 1297 */       if (canAim()) {
/* 1298 */         paramBatch.setColor(Game.i.towerManager.getAimStrategyColor(this.aimStrategy));
/* 1299 */         paramBatch.draw(factory.roundedSmallRectTextureRegion, paramFloat1 + 85.0F * f, paramFloat2 + 85.0F * paramFloat4, 36.0F * f, 36.0F * paramFloat4);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1307 */         paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/* 1308 */         paramBatch.draw(Game.i.towerManager
/* 1309 */             .getAimStrategyIcon(this.aimStrategy), paramFloat1 + 85.0F * f, paramFloat2 + 85.0F * paramFloat4, 36.0F * f, 36.0F * paramFloat4);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1317 */       ResourcePack.ResourcePackBitmapFont resourcePackBitmapFont = Game.i.assetManager.getFont((int)(36.0F * f));
/* 1318 */       d.setLength(0);
/* 1319 */       d.append(this.k);
/* 1320 */       resourcePackBitmapFont.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 1321 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)d, paramFloat1 + 3.0F * f, paramFloat2 + 71.0F * paramFloat4, paramFloat3, 1, false);
/* 1322 */       resourcePackBitmapFont.setColor(Color.WHITE);
/* 1323 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)d, paramFloat1, paramFloat2 + 74.0F, 128.0F, 1, false);
/*      */ 
/*      */       
/* 1326 */       resourcePackBitmapFont = Game.i.assetManager.getFont((int)(24.0F * f));
/* 1327 */       d.setLength(0);
/* 1328 */       d.append("L").append(this.level);
/* 1329 */       resourcePackBitmapFont.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 1330 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)d, paramFloat1 + f * 2.0F, paramFloat2 + 32.0F * paramFloat4, paramFloat3, 1, false);
/* 1331 */       resourcePackBitmapFont.setColor(Color.WHITE);
/* 1332 */       resourcePackBitmapFont.draw(paramBatch, (CharSequence)d, paramFloat1, paramFloat2 + 34.0F * paramFloat4, paramFloat3, 1, false);
/* 1333 */       resourcePackBitmapFont.setColor(Color.WHITE);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void drawBase(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {
/* 1339 */     a(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramDrawMode);
/* 1340 */     drawAbilitiesToCache(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramDrawMode);
/* 1341 */     b(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramDrawMode);
/*      */   }
/*      */   
/*      */   public void drawAbilitiesToCache(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MapRenderingSystem.DrawMode paramDrawMode) {
/* 1345 */     Factory factory = Game.i.towerManager.getFactory(this.type);
/* 1346 */     for (byte b = 0; b < 6; b++) {
/* 1347 */       if (isAbilityInstalled(b) && 
/* 1348 */         factory.shouldDrawAbilityToCache(b)) {
/* 1349 */         factory.getAbilityTextures(b).draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void drawWeapon(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1356 */     if ((getTile()).visibleOnScreen && !isOutOfOrder())
/*      */     {
/* 1358 */       getWeaponTextures().draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat3, 1.0F, 1.0F, this.angle);
/*      */     }
/*      */   }
/*      */   
/*      */   public void drawGlitch(Batch paramBatch) {
/* 1363 */     Factory factory = Game.i.towerManager.getFactory(this.type);
/* 1364 */     paramBatch.setColor(1.0F, 0.0F, 0.0F, 0.8F);
/* 1365 */     paramBatch.draw(Factory.a(factory), (
/* 1366 */         getTile().getX() << 7) - 6.4F + FastRandom.getFloat() * 12.8F - 6.4F, (
/* 1367 */         getTile().getY() << 7) - 6.4F + FastRandom.getFloat() * 12.8F - 6.4F, 140.8F, 140.8F);
/*      */ 
/*      */     
/* 1370 */     paramBatch.setColor(0.0F, 1.0F, 1.0F, 0.8F);
/* 1371 */     paramBatch.draw(Factory.a(factory), (
/* 1372 */         getTile().getX() << 7) - 6.4F + FastRandom.getFloat() * 12.8F - 6.4F, (
/* 1373 */         getTile().getY() << 7) - 6.4F + FastRandom.getFloat() * 12.8F - 6.4F, 140.8F, 140.8F);
/*      */ 
/*      */     
/* 1376 */     paramBatch.setColor(1.0F, 1.0F, 0.0F, 0.8F);
/* 1377 */     paramBatch.draw(Factory.a(factory), (
/* 1378 */         getTile().getX() << 7) - 6.4F + FastRandom.getFloat() * 12.8F - 6.4F, (
/* 1379 */         getTile().getY() << 7) - 6.4F + FastRandom.getFloat() * 12.8F - 6.4F, 140.8F, 140.8F);
/*      */ 
/*      */     
/* 1382 */     paramBatch.setColor(Color.WHITE);
/* 1383 */     paramBatch.draw(Factory.a(factory), (getTile().getX() << 7) - 6.4F, (getTile().getY() << 7) - 6.4F, 140.8F, 140.8F);
/*      */   }
/*      */ 
/*      */   
/*      */   public void drawSelectedRange(Batch paramBatch, RangeCircle paramRangeCircle) {
/* 1388 */     float f1 = (getTile()).center.x;
/* 1389 */     float f2 = (getTile()).center.y;
/* 1390 */     float f3 = getMinRange() * 128.0F;
/* 1391 */     float f4 = getRange() * 128.0F;
/*      */     
/* 1393 */     if (paramRangeCircle.getX() != f1 || paramRangeCircle.getY() != f2 || paramRangeCircle.getMinRadius() != f3 || paramRangeCircle.getMaxRadius() != f4) {
/* 1394 */       paramRangeCircle.setup(f1, f2, f3, f4, MapSystem.TOWER_RANGE_SELECTED_COLOR);
/*      */     }
/*      */ 
/*      */     
/* 1398 */     paramRangeCircle.draw(paramBatch);
/*      */   }
/*      */ 
/*      */   
/*      */   public void drawHoveredRange(Batch paramBatch, RangeCircle paramRangeCircle) {
/* 1403 */     float f1 = (getTile()).center.x;
/* 1404 */     float f2 = (getTile()).center.y;
/* 1405 */     float f3 = getMinRange() * 128.0F;
/* 1406 */     float f4 = getRange() * 128.0F;
/*      */     
/* 1408 */     if (paramRangeCircle.getX() != f1 || paramRangeCircle.getY() != f2 || paramRangeCircle.getMinRadius() != f3 || paramRangeCircle.getMaxRadius() != f4) {
/* 1409 */       paramRangeCircle.setup(f1, f2, f3, f4, MapSystem.TOWER_RANGE_HOVER_COLOR);
/*      */     }
/*      */     
/* 1412 */     paramRangeCircle.draw(paramBatch);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void placedOnMap() {}
/*      */ 
/*      */   
/*      */   public void removedFromMap() {}
/*      */ 
/*      */   
/*      */   public int getEnemyPriority(Enemy paramEnemy) {
/* 1424 */     return paramEnemy.lowAimPriority.isTrue() ? 0 : 10;
/*      */   }
/*      */   
/*      */   public static int getStartingLevel(TowerType paramTowerType, GameValueProvider paramGameValueProvider) {
/* 1428 */     return StrictMath.min(paramGameValueProvider.getIntValueSum(GameValueType.TOWERS_STARTING_LEVEL, Game.i.towerManager.getStartingLevelGameValueType(paramTowerType)), 999);
/*      */   }
/*      */   
/*      */   public static float getStartingPwr(TowerType paramTowerType, GameValueProvider paramGameValueProvider) {
/* 1432 */     return paramGameValueProvider.getIntValueSum(GameValueType.TOWERS_STARTING_PWR, Game.i.towerManager.getStartingPwrGameValueType(paramTowerType));
/*      */   }
/*      */   
/*      */   public float getRange() {
/* 1436 */     return getStat(TowerStatType.RANGE);
/*      */   }
/*      */   
/*      */   public float getMinRange() {
/* 1440 */     return getStat(TowerStatType.MIN_RANGE);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUniqueStatDescription() {
/* 1446 */     return Game.i.towerManager.getUniqueStatDescription(this.type);
/*      */   }
/*      */   
/*      */   protected float calculateStat(TowerStatType paramTowerStatType) {
/* 1450 */     return Game.i.towerManager.getStatFromConfig(this.type, paramTowerStatType, getUpgradeLevel(), getLevel(), (GameValueProvider)this.S.gameValue) * this.S.gameValue.getGlobalStatMultiplier(paramTowerStatType);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasCustomButton()
/*      */   {
/* 1456 */     return false; } public boolean isCustomButtonNeedMapPoint() {
/* 1457 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void customButtonAction(int paramInt1, int paramInt2) {}
/*      */ 
/*      */   
/*      */   public void updateCustomButton(ComplexButton paramComplexButton, boolean paramBoolean) {}
/*      */ 
/*      */   
/*      */   protected void a(StringBuilder paramStringBuilder) {}
/*      */   
/*      */   public void fillTowerMenu(Group paramGroup, ObjectMap<String, Object> paramObjectMap) {
/* 1470 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_BUILDING_INFO) != 0.0D) {
/*      */       Label label;
/* 1472 */       if (paramObjectMap.containsKey("_dbgBuildingInfo")) {
/*      */         
/* 1474 */         if ((label = (Label)paramObjectMap.get("_dbgBuildingInfo")).getParent() != paramGroup) {
/* 1475 */           paramGroup.addActor((Actor)label);
/*      */         }
/*      */       } else {
/* 1478 */         label = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 1479 */         paramGroup.addActor((Actor)label);
/* 1480 */         paramObjectMap.put("_dbgBuildingInfo", label);
/*      */       } 
/*      */       
/* 1483 */       d.setLength(0);
/* 1484 */       d.append("target: ").append(String.valueOf((getTarget() == null) ? "-" : Integer.valueOf((getTarget()).id))).append("\n");
/* 1485 */       d.append("targetSearchFrames: ").append(this.l).append("\n");
/* 1486 */       d.append("shotCount: ").append(this.shotCount).append("\n");
/* 1487 */       d.append("timeSinceLastAttack: ").append(this.c).append("\n");
/* 1488 */       d.append("framesSinceConstantEnemySeeking: ").append(this.j).append("\n");
/* 1489 */       d.append("attackDelay: ").append(getAttackDelay()).append("\n");
/* 1490 */       d.append("powerCombinedMultiplier: ").append(getPowerCombinedMultiplier()).append("\n"); TowerStatType[] arrayOfTowerStatType; int i; byte b;
/* 1491 */       for (i = (arrayOfTowerStatType = TowerStatType.values).length, b = 0; b < i; ) { TowerStatType towerStatType = arrayOfTowerStatType[b];
/*      */         float f;
/* 1493 */         if ((f = getStat(towerStatType)) != 0.0F)
/* 1494 */           d.append("stat|").append(String.valueOf(towerStatType)).append(": ").append(f).append("\n"); 
/*      */         b++; }
/*      */       
/* 1497 */       a(d);
/* 1498 */       label.setText((CharSequence)d);
/*      */       
/* 1500 */       label.setPosition(-200.0F, 128.0F);
/* 1501 */       label.setSize(180.0F, 200.0F);
/* 1502 */       label.setAlignment(16);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean shouldSearchForTarget() {
/* 1511 */     return canAim();
/*      */   }
/*      */   
/*      */   public boolean canAttackEnemy(Enemy paramEnemy) {
/* 1515 */     if (this.S.tower.canTowerAttackEnemy[paramEnemy.type.ordinal()][this.type.ordinal()] && paramEnemy
/* 1516 */       .canBeAttackedBy(this)) return true; 
/*      */     return false;
/*      */   }
/*      */   public boolean canAttack() {
/*      */     Enemy enemy;
/* 1521 */     if ((enemy = getTarget()) != null && !this.attackDisabled) {
/* 1522 */       float f = PMath.getAngleBetweenPoints((getTile()).center, enemy.getPosition());
/*      */ 
/*      */       
/* 1525 */       return ((f = StrictMath.abs(PMath.getDistanceBetweenAngles(this.angle, f))) < 3.0F);
/*      */     } 
/* 1527 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void rotateAtPoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1532 */     rotateToAngle(PMath.getAngleBetweenPoints((getTile()).center.x, (getTile()).center.y, paramFloat1, paramFloat2), paramFloat3, paramFloat4);
/*      */   }
/*      */   
/*      */   public void rotateToAngle(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1536 */     if (paramFloat1 == this.angle)
/*      */       return; 
/* 1538 */     float f = PMath.getDistanceBetweenAngles(this.angle, paramFloat1);
/*      */ 
/*      */     
/* 1541 */     if ((paramFloat2 = paramFloat2 * paramFloat3) < StrictMath.abs(f)) {
/*      */       
/* 1543 */       if (f < 0.0F) {
/* 1544 */         this.angle -= paramFloat2; return;
/*      */       } 
/* 1546 */       this.angle += paramFloat2;
/*      */       
/*      */       return;
/*      */     } 
/* 1550 */     this.angle = paramFloat1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onPreSell() {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void onAbilitySet(int paramInt, boolean paramBoolean) {}
/*      */ 
/*      */   
/*      */   protected final void a(float paramFloat1, float paramFloat2) {
/*      */     Enemy enemy;
/* 1564 */     if ((enemy = getTarget()) != null && !isOutOfOrder())
/*      */     {
/* 1566 */       rotateAtPoint((enemy.getPosition()).x, (enemy.getPosition()).y, paramFloat1, paramFloat2);
/*      */     }
/*      */   }
/*      */   
/*      */   public float getAttackDelay() {
/* 1571 */     return this.o;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void attack(int paramInt) {}
/*      */ 
/*      */   
/*      */   public abstract Quad getWeaponTextures();
/*      */ 
/*      */   
/*      */   public abstract boolean canAim();
/*      */ 
/*      */   
/*      */   public static class AbilityConfig
/*      */   {
/*      */     private final String a;
/*      */     
/*      */     private final String b;
/*      */     
/* 1591 */     public Object[] descriptionArgs = new Object[0];
/*      */     
/*      */     public AbilityConfig(String param1String1, String param1String2) {
/* 1594 */       this.a = param1String1;
/* 1595 */       this.b = param1String2;
/*      */     }
/*      */     
/*      */     public String getName() {
/* 1599 */       return Game.i.localeManager.i18n.get(this.a);
/*      */     }
/*      */     
/*      */     public CharSequence getDescription() {
/* 1603 */       Object[] arrayOfObject = this.descriptionArgs;
/* 1604 */       return Game.i.localeManager.i18n.format(this.b, arrayOfObject);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static abstract class Factory<T extends Tower>
/*      */     implements EntityFactory
/*      */   {
/*      */     private String c;
/*      */     private TowerType d;
/*      */     private TextureRegion e;
/*      */     private TextureRegion f;
/*      */     private Quad g;
/*      */     private Quad h;
/*      */     @Null
/*      */     private Quad i;
/*      */     @Null
/*      */     protected Quad a;
/*      */     private Quad[] j;
/*      */     public TextureRegion roundedSmallRectTextureRegion;
/* 1624 */     protected final Tower.AbilityConfig[] b = new Tower.AbilityConfig[6];
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Factory(String param1String, TowerType param1TowerType) {
/* 1630 */       this.c = param1String;
/* 1631 */       this.d = param1TowerType;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isAvailable(GameValueProvider param1GameValueProvider) {
/* 1637 */       return param1GameValueProvider.getBooleanValue(Game.i.towerManager.getTowerGameValueType(this.d));
/*      */     }
/*      */     
/*      */     public final Quad getAbilityTextures(int param1Int) {
/* 1641 */       return this.j[param1Int];
/*      */     }
/*      */     
/*      */     public final Quad getShadowTextures() {
/* 1645 */       return this.h;
/*      */     }
/*      */     
/*      */     public final Quad getBaseTextures() {
/* 1649 */       return this.g;
/*      */     }
/*      */     @Null
/*      */     public Quad getWeaponTexture() {
/* 1653 */       return this.i;
/*      */     }
/*      */     @Null
/*      */     public Quad getWeaponShadowTexture() {
/* 1657 */       return this.a;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void configureSystems(GameSystemProvider param1GameSystemProvider) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setup() {
/* 1669 */       String[] arrayOfString = getAbilityAliases();
/* 1670 */       if (Game.i.assetManager != null) {
/* 1671 */         this.roundedSmallRectTextureRegion = (TextureRegion)Game.i.assetManager.getTextureRegion("rounded-small-rect");
/* 1672 */         this.e = (TextureRegion)Game.i.assetManager.getTextureRegion(this.c);
/* 1673 */         this.f = (TextureRegion)Game.i.assetManager.getTextureRegion(this.c + "-shape");
/* 1674 */         this.g = Game.i.assetManager.getQuad("towers." + this.d.name() + ".base");
/* 1675 */         this.h = Game.i.assetManager.getQuad("towers." + this.d.name() + ".baseShadow");
/* 1676 */         this.j = new Quad[6];
/* 1677 */         for (byte b1 = 0; b1 < 3; b1++) {
/* 1678 */           this.j[b1] = Game.i.assetManager.getQuad("towers." + this.d.name() + ".abilities." + arrayOfString[b1]);
/*      */         }
/* 1680 */         this.j[3] = Game.i.assetManager.getQuad("towers." + this.d.name() + ".abilities.SPECIAL");
/* 1681 */         this.j[4] = Game.i.assetManager.getQuad("towers." + this.d.name() + ".abilities.ULTIMATE");
/* 1682 */         this.j[5] = Game.i.assetManager.getQuad("towers." + this.d.name() + ".abilities.POWERFUL");
/* 1683 */         this.i = Game.i.assetManager.getQuadOrNull("towers." + this.d.name() + ".weapon");
/* 1684 */         this.a = Game.i.assetManager.getQuadOrNull("towers." + this.d.name() + ".weaponShadow");
/* 1685 */         setupAssets();
/*      */       } 
/*      */       
/* 1688 */       for (byte b = 0; b < arrayOfString.length; b++) {
/* 1689 */         this.b[b] = new Tower.AbilityConfig("tower_ability_" + this.d
/* 1690 */             .name() + "_" + arrayOfString[b] + "_name", "tower_ability_" + this.d
/* 1691 */             .name() + "_" + arrayOfString[b] + "_description");
/*      */       }
/*      */       
/* 1694 */       this.b[3] = new Tower.AbilityConfig("tower_ability_" + this.d
/* 1695 */           .name() + "_SPECIAL_name", "tower_ability_" + this.d
/* 1696 */           .name() + "_SPECIAL_description");
/*      */       
/* 1698 */       this.b[4] = new Tower.AbilityConfig("tower_ability_" + this.d
/* 1699 */           .name() + "_ULTIMATE_name", "tower_ability_" + this.d
/* 1700 */           .name() + "_ULTIMATE_description");
/*      */       
/* 1702 */       this.b[5] = new Tower.AbilityConfig("tower_ability_" + this.d
/* 1703 */           .name() + "_POWERFUL_name", "tower_ability_" + this.d
/* 1704 */           .name() + "_POWERFUL_description");
/*      */       
/* 1706 */       (this.b[5]).descriptionArgs = (Object[])new String[1];
/*      */     }
/*      */     
/*      */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 1710 */       return true;
/*      */     }
/*      */     
/*      */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/* 1714 */       float f = (float)(param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWERS_POWERFUL_ABILITY_PWR) + param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(Game.i.towerManager.getPowerfulAbilityGameValueType(param1Tower.type)));
/* 1715 */       (this.b[5]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(f, 2, true).toString();
/* 1716 */       return this.b;
/*      */     }
/*      */     @Null
/*      */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/* 1720 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setupAssets() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public String getTitle() {
/* 1730 */       return Game.i.towerManager.getTitle(this.d);
/*      */     }
/*      */     
/*      */     public String getDescription() {
/* 1734 */       return Game.i.towerManager.getDescription(this.d);
/*      */     }
/*      */     
/*      */     public int getBuildPrice(GameSystemProvider param1GameSystemProvider) {
/* 1738 */       return param1GameSystemProvider.gameValue.getIntValue(Game.i.towerManager.getPriceGameValueType(this.d));
/*      */     }
/*      */     public boolean canKillEnemies() {
/* 1741 */       return true;
/*      */     }
/*      */     public boolean receivesSpaceTileBonus(SpaceTileBonusType param1SpaceTileBonusType) {
/* 1744 */       if (param1SpaceTileBonusType == null) return false;
/*      */       
/*      */       TowerStatType towerStatType;
/* 1747 */       if ((towerStatType = SpaceTileBonus.b[param1SpaceTileBonusType.ordinal()]) != null && Game.i.towerManager.hasStat(this.d, towerStatType))
/*      */       {
/* 1749 */         return true; } 
/* 1750 */       if (towerStatType == null) {
/*      */         
/* 1752 */         if (param1SpaceTileBonusType == SpaceTileBonusType.BONUS_COINS && !canKillEnemies())
/*      */         {
/* 1754 */           return false;
/*      */         }
/*      */         
/* 1757 */         return true;
/*      */       } 
/*      */ 
/*      */       
/* 1761 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Actor createIconActor(float param1Float) {
/*      */       Image image;
/* 1768 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable(this.c))).setSize(param1Float, param1Float);
/*      */       
/* 1770 */       return (Actor)image;
/*      */     }
/*      */     
/*      */     public Drawable getIconDrawable() {
/* 1774 */       return (Drawable)Game.i.assetManager.getDrawable(this.c);
/*      */     }
/*      */     
/*      */     public TextureRegion getIconTexture() {
/* 1778 */       return this.e;
/*      */     }
/*      */     
/*      */     public abstract int getBuildHotKey();
/*      */     
/*      */     public abstract String[] getAbilityAliases();
/*      */     
/*      */     public abstract T create();
/*      */     
/*      */     public abstract Color getColor();
/*      */     
/*      */     public abstract int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType);
/*      */   }
/*      */   
/*      */   public static abstract class FindEnemyFilter {
/*      */     public abstract boolean isValid(Enemy param1Enemy);
/*      */   }
/*      */   
/*      */   private static interface AimStrategyEnemyComparator {
/*      */     boolean compare(Tower param1Tower, Enemy param1Enemy1, Enemy param1Enemy2);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Tower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */