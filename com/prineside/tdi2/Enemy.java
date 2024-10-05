/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.IntIntMap;
/*     */ import com.badlogic.gdx.utils.IntSet;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.buffs.BlizzardBuff;
/*     */ import com.prineside.tdi2.buffs.FreezingBuff;
/*     */ import com.prineside.tdi2.buffs.SlippingBuff;
/*     */ import com.prineside.tdi2.buffs.ThrowBackBuff;
/*     */ import com.prineside.tdi2.buffs.VulnerabilityBuff;
/*     */ import com.prineside.tdi2.components.StunDebuffStats;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.SpecialDamageType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.pathfinding.Path;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.utils.EnumKeyArray;
/*     */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*     */ import com.prineside.tdi2.utils.MultiReasonBool;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ 
/*     */ @REGS(classOnly = true, arrayLevels = 1)
/*     */ public abstract class Enemy extends Registrable {
/*  50 */   private static final TLog a = TLog.forClass(Enemy.class);
/*     */   
/*     */   public static final String ATTACHED_PARTICLE_REGENERATION_BUFF = "RegenerationBuff";
/*     */   
/*     */   public static final int UNREGISTERED_ID = 0;
/*     */   
/*  56 */   public static final Color HEALTH_BAR_BACKGROUND_COLOR = new Color(0.1F, 0.1F, 0.1F, 1.0F);
/*     */ 
/*     */   
/*     */   public static final float SIZE = 25.6F;
/*     */ 
/*     */   
/*  62 */   private float b = 1.0F;
/*  63 */   public int killScore = 1;
/*     */   
/*  65 */   public float angle = 0.0F;
/*     */   
/*  67 */   private Vector2 c = new Vector2();
/*     */   
/*     */   @NAGS
/*     */   public float drawAngle;
/*     */   @NAGS
/*  72 */   public Vector2 drawPosition = new Vector2(); @NAGS public float drawScale; @NAGS
/*  73 */   public boolean healthBarInvisible; public MultiReasonBool invisible = new MultiReasonBool();
/*  74 */   public MultiReasonBool disabled = new MultiReasonBool();
/*     */   public boolean chasedByCrusher;
/*     */   public boolean gaveMiningSpeedForGauss;
/*     */   public Array<ItemStack> loot;
/*     */   public IntSet thrownBackBy;
/*     */   public float ignitionProgress;
/*     */   public int ignitionIncreasedLastFrame;
/*  81 */   public MultiReasonBool notAffectsWaveKillCounter = new MultiReasonBool();
/*  82 */   public MultiReasonBool lowAimPriority = new MultiReasonBool();
/*     */   public IntSet caughtByCrushersSet;
/*     */   public int totalCatchesByCrushers;
/*     */   public StunDebuffStats stunDebuffStats;
/*     */   @NAGS
/*     */   public ObjectMap<String, ParticleEffectPool.PooledEffect> attachedParticles;
/*     */   public EnemyType type;
/*  89 */   private float d = 100.0F;
/*  90 */   public float maxHealth = 100.0F;
/*     */ 
/*     */   
/*  93 */   private float e = 1.0F;
/*  94 */   public float bounty = 0.0F;
/*     */ 
/*     */   
/*  97 */   private float f = 1.0F;
/*     */   
/*     */   public int otherEnemiesNearby;
/*     */   
/*     */   @NAGS
/* 102 */   private float g = 0.0F;
/* 103 */   public float healthBarScale = 1.0F;
/*     */ 
/*     */   
/* 106 */   public int id = 0;
/*     */   public Path graphPath;
/* 108 */   public int pathSearches = 0;
/*     */   
/*     */   public boolean ignorePathfinding;
/*     */   
/*     */   public int sideShiftIndex;
/*     */   
/*     */   public float passedTiles;
/*     */   
/*     */   public float sumPassedTiles;
/*     */   
/*     */   public float existsTime;
/*     */   
/*     */   @EnumKeyArray(enumerator = BuffType.class)
/*     */   public DelayedRemovalArray[] buffsByType;
/*     */   
/*     */   @Null
/*     */   public boolean[] buffsAppliedByType;
/*     */   
/*     */   @Null
/*     */   public SpawnTile spawnTile;
/*     */   
/*     */   public boolean ignoredOnGameOverNoEnemies;
/*     */   
/*     */   @Null
/* 132 */   public Wave wave = null;
/*     */   
/*     */   public boolean ignoredByAutoWaveCall;
/*     */   
/* 136 */   public float buffFreezingPercent = 0.0F;
/*     */   
/*     */   public float buffFreezingLightningLengthBonus;
/*     */   
/*     */   public float buffFreezingPoisonDurationBonus;
/*     */   
/*     */   public int buffSnowballHits;
/*     */   
/*     */   public IntIntMap multishotTowerHits;
/*     */   
/*     */   public boolean wasAimedAtWithChainReactionBuff;
/*     */   
/*     */   public boolean wasStunnedByGauss;
/*     */   
/*     */   private ObjectMap<String, Object> h;
/*     */   
/*     */   @NAGS
/*     */   private Color i;
/*     */   
/*     */   @NAGS
/* 156 */   private float j = -1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   private static final Color k = new Color(Color.WHITE);
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/* 166 */     super.write(paramKryo, paramOutput);
/* 167 */     paramOutput.writeFloat(this.b);
/* 168 */     paramOutput.writeInt(this.killScore);
/*     */     
/* 170 */     paramOutput.writeFloat(this.angle);
/* 171 */     paramKryo.writeObject(paramOutput, this.c);
/* 172 */     paramKryo.writeObject(paramOutput, this.invisible);
/* 173 */     paramKryo.writeObject(paramOutput, this.disabled);
/* 174 */     paramOutput.writeBoolean(this.chasedByCrusher);
/* 175 */     paramOutput.writeBoolean(this.gaveMiningSpeedForGauss);
/* 176 */     paramKryo.writeObjectOrNull(paramOutput, this.loot, Array.class);
/* 177 */     paramKryo.writeObjectOrNull(paramOutput, this.thrownBackBy, IntSet.class);
/* 178 */     paramOutput.writeFloat(this.ignitionProgress);
/* 179 */     paramOutput.writeVarInt(this.ignitionIncreasedLastFrame, true);
/* 180 */     paramKryo.writeObject(paramOutput, this.notAffectsWaveKillCounter);
/* 181 */     paramKryo.writeObject(paramOutput, this.lowAimPriority);
/* 182 */     paramKryo.writeObjectOrNull(paramOutput, this.caughtByCrushersSet, IntSet.class);
/* 183 */     paramOutput.writeVarInt(this.totalCatchesByCrushers, true);
/* 184 */     paramKryo.writeObjectOrNull(paramOutput, this.stunDebuffStats, StunDebuffStats.class);
/* 185 */     paramKryo.writeObjectOrNull(paramOutput, this.type, EnemyType.class);
/* 186 */     paramOutput.writeFloat(this.d);
/* 187 */     paramOutput.writeFloat(this.maxHealth);
/* 188 */     paramOutput.writeFloat(this.e);
/* 189 */     paramOutput.writeFloat(this.bounty);
/* 190 */     paramOutput.writeFloat(this.f);
/* 191 */     paramOutput.writeVarInt(this.otherEnemiesNearby, true);
/* 192 */     paramOutput.writeFloat(this.healthBarScale);
/* 193 */     paramOutput.writeVarInt(this.id, true);
/* 194 */     paramKryo.writeObjectOrNull(paramOutput, this.graphPath, Path.class);
/* 195 */     paramOutput.writeVarInt(this.pathSearches, true);
/* 196 */     paramOutput.writeBoolean(this.ignorePathfinding);
/* 197 */     paramOutput.writeByte(this.sideShiftIndex);
/* 198 */     paramOutput.writeFloat(this.passedTiles);
/* 199 */     paramOutput.writeFloat(this.sumPassedTiles);
/* 200 */     paramOutput.writeFloat(this.existsTime);
/* 201 */     paramKryo.writeClassAndObject(paramOutput, this.buffsByType);
/* 202 */     paramKryo.writeObjectOrNull(paramOutput, this.buffsAppliedByType, boolean[].class);
/* 203 */     paramKryo.writeObjectOrNull(paramOutput, this.spawnTile, SpawnTile.class);
/* 204 */     paramOutput.writeBoolean(this.ignoredOnGameOverNoEnemies);
/* 205 */     paramKryo.writeObjectOrNull(paramOutput, this.wave, Wave.class);
/* 206 */     paramOutput.writeBoolean(this.ignoredByAutoWaveCall);
/* 207 */     paramOutput.writeFloat(this.buffFreezingPercent);
/* 208 */     paramOutput.writeFloat(this.buffFreezingLightningLengthBonus);
/* 209 */     paramOutput.writeFloat(this.buffFreezingPoisonDurationBonus);
/* 210 */     paramOutput.writeVarInt(this.buffSnowballHits, true);
/* 211 */     paramKryo.writeObjectOrNull(paramOutput, this.multishotTowerHits, IntIntMap.class);
/* 212 */     paramOutput.writeBoolean(this.wasAimedAtWithChainReactionBuff);
/* 213 */     paramOutput.writeBoolean(this.wasStunnedByGauss);
/* 214 */     paramKryo.writeObjectOrNull(paramOutput, this.h, ObjectMap.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/* 220 */     super.read(paramKryo, paramInput);
/* 221 */     this.b = paramInput.readFloat();
/* 222 */     this.killScore = paramInput.readInt();
/*     */     
/* 224 */     this.angle = paramInput.readFloat();
/* 225 */     this.c = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/* 226 */     this.invisible = (MultiReasonBool)paramKryo.readObject(paramInput, MultiReasonBool.class);
/* 227 */     this.disabled = (MultiReasonBool)paramKryo.readObject(paramInput, MultiReasonBool.class);
/* 228 */     this.chasedByCrusher = paramInput.readBoolean();
/* 229 */     this.gaveMiningSpeedForGauss = paramInput.readBoolean();
/* 230 */     this.loot = (Array<ItemStack>)paramKryo.readObjectOrNull(paramInput, Array.class);
/* 231 */     this.thrownBackBy = (IntSet)paramKryo.readObjectOrNull(paramInput, IntSet.class);
/* 232 */     this.ignitionProgress = paramInput.readFloat();
/* 233 */     this.ignitionIncreasedLastFrame = paramInput.readVarInt(true);
/* 234 */     this.notAffectsWaveKillCounter = (MultiReasonBool)paramKryo.readObject(paramInput, MultiReasonBool.class);
/* 235 */     this.lowAimPriority = (MultiReasonBool)paramKryo.readObject(paramInput, MultiReasonBool.class);
/* 236 */     this.caughtByCrushersSet = (IntSet)paramKryo.readObjectOrNull(paramInput, IntSet.class);
/* 237 */     this.totalCatchesByCrushers = paramInput.readVarInt(true);
/* 238 */     this.stunDebuffStats = (StunDebuffStats)paramKryo.readObjectOrNull(paramInput, StunDebuffStats.class);
/* 239 */     this.type = (EnemyType)paramKryo.readObjectOrNull(paramInput, EnemyType.class);
/* 240 */     this.d = paramInput.readFloat();
/* 241 */     this.maxHealth = paramInput.readFloat();
/* 242 */     this.e = paramInput.readFloat();
/* 243 */     this.bounty = paramInput.readFloat();
/* 244 */     this.f = paramInput.readFloat();
/* 245 */     this.otherEnemiesNearby = paramInput.readVarInt(true);
/* 246 */     this.healthBarScale = paramInput.readFloat();
/* 247 */     this.id = paramInput.readVarInt(true);
/* 248 */     this.graphPath = (Path)paramKryo.readObjectOrNull(paramInput, Path.class);
/* 249 */     this.pathSearches = paramInput.readVarInt(true);
/* 250 */     this.ignorePathfinding = paramInput.readBoolean();
/* 251 */     this.sideShiftIndex = paramInput.readByte();
/* 252 */     this.passedTiles = paramInput.readFloat();
/* 253 */     this.sumPassedTiles = paramInput.readFloat();
/* 254 */     this.existsTime = paramInput.readFloat();
/* 255 */     this.buffsByType = (DelayedRemovalArray[])paramKryo.readClassAndObject(paramInput);
/* 256 */     this.buffsAppliedByType = (boolean[])paramKryo.readObjectOrNull(paramInput, boolean[].class);
/* 257 */     this.spawnTile = (SpawnTile)paramKryo.readObjectOrNull(paramInput, SpawnTile.class);
/* 258 */     this.ignoredOnGameOverNoEnemies = paramInput.readBoolean();
/* 259 */     this.wave = (Wave)paramKryo.readObjectOrNull(paramInput, Wave.class);
/* 260 */     this.ignoredByAutoWaveCall = paramInput.readBoolean();
/* 261 */     this.buffFreezingPercent = paramInput.readFloat();
/* 262 */     this.buffFreezingLightningLengthBonus = paramInput.readFloat();
/* 263 */     this.buffFreezingPoisonDurationBonus = paramInput.readFloat();
/* 264 */     this.buffSnowballHits = paramInput.readVarInt(true);
/* 265 */     this.multishotTowerHits = (IntIntMap)paramKryo.readObjectOrNull(paramInput, IntIntMap.class);
/* 266 */     this.wasAimedAtWithChainReactionBuff = paramInput.readBoolean();
/* 267 */     this.wasStunnedByGauss = paramInput.readBoolean();
/* 268 */     this.h = (ObjectMap<String, Object>)paramKryo.readObjectOrNull(paramInput, ObjectMap.class);
/*     */   }
/*     */   
/*     */   protected Enemy(EnemyType paramEnemyType) {
/* 272 */     this.type = paramEnemyType;
/*     */   }
/*     */   @Null
/*     */   public Object getUserData(String paramString) {
/* 276 */     if (this.h != null) {
/* 277 */       return this.h.get(paramString, null);
/*     */     }
/* 279 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUserData(String paramString, @Null Object paramObject) {
/* 284 */     if (paramObject == null) {
/*     */       
/* 286 */       if (this.h != null) {
/* 287 */         this.h.remove(paramString);
/* 288 */         if (this.h.size == 0) {
/* 289 */           this.h = null; return;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 293 */       if (this.h == null) {
/* 294 */         this.h = new ObjectMap();
/*     */       }
/* 296 */       this.h.put(paramString, paramObject);
/*     */     } 
/*     */   }
/*     */   @Null
/*     */   public Tile getCurrentTile() {
/* 301 */     return this.S.map.getMap().getTileByMapPosV(getPosition());
/*     */   }
/*     */   
/*     */   public Color getColor() {
/* 305 */     return this.S.enemy.getColor(this.type);
/*     */   }
/*     */   
/*     */   public void initBuffsByTypeArray() {
/* 309 */     if (this.buffsByType != null)
/*     */       return; 
/* 311 */     this.buffsByType = new DelayedRemovalArray[BuffType.values.length];
/* 312 */     for (byte b = 0; b < BuffType.values.length; b++) {
/* 313 */       this.buffsByType[b] = new DelayedRemovalArray(false, 0, BuffType.relevantClasses[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasBuffsByType(BuffType paramBuffType) {
/* 321 */     return (this.buffsByType != null && (this.buffsByType[paramBuffType.ordinal()]).size != 0);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray getBuffsByTypeOrNull(BuffType paramBuffType) {
/* 325 */     if (this.buffsByType == null) return null; 
/* 326 */     return this.buffsByType[paramBuffType.ordinal()];
/*     */   }
/*     */   public void update(float paramFloat) {
/*     */     ThrowBackBuff throwBackBuff;
/* 330 */     this.existsTime += paramFloat;
/*     */ 
/*     */     
/*     */     DelayedRemovalArray delayedRemovalArray;
/*     */     
/* 335 */     float f2 = ((delayedRemovalArray = getBuffsByTypeOrNull(BuffType.SLIPPING)) == null || delayedRemovalArray.size == 0) ? 1.0F : ((SlippingBuff)delayedRemovalArray.first()).speedMultiplier;
/* 336 */     float f3 = (delayedRemovalArray == null || delayedRemovalArray.size == 0) ? 1.0F : ((SlippingBuff)delayedRemovalArray.first()).throwBackDistance;
/*     */ 
/*     */     
/* 339 */     if ((delayedRemovalArray = getBuffsByTypeOrNull(BuffType.THROW_BACK)) != null && delayedRemovalArray.size != 0) {
/*     */ 
/*     */ 
/*     */       
/* 343 */       f1 = (f1 = -(throwBackBuff = (ThrowBackBuff)delayedRemovalArray.first()).force) * f3;
/* 344 */     } else if (hasBuffsByType(BuffType.BLIZZARD) || hasBuffsByType(BuffType.SNOWBALL) || hasBuffsByType(BuffType.STUN)) {
/*     */       
/* 346 */       f1 = 0.0F;
/*     */     } else {
/*     */       
/* 349 */       f1 = (f1 = this.e * (100.0F - this.buffFreezingPercent) * 0.01F) * throwBackBuff;
/*     */     } 
/*     */     
/*     */     float f1;
/*     */     
/* 354 */     if ((f1 = (float)(f1 * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ENEMIES_SPEED))) != this.f) {
/*     */       
/* 356 */       float f = paramFloat * 8.0F;
/*     */ 
/*     */       
/* 359 */       if ((f3 = StrictMath.abs(f1 = f1 - this.f)) > f) {
/* 360 */         f1 = f / f3 * f1;
/*     */       }
/* 362 */       this.f += f1;
/*     */     } 
/*     */ 
/*     */     
/* 366 */     if (this.S.gameState.updateNumber > this.ignitionIncreasedLastFrame + 1) {
/* 367 */       this.ignitionProgress -= paramFloat;
/* 368 */       if (this.ignitionProgress < 0.0F) {
/* 369 */         this.ignitionProgress = 0.0F;
/*     */       }
/*     */     } 
/*     */     
/* 373 */     this.invisible.update(paramFloat);
/* 374 */     this.disabled.update(paramFloat);
/* 375 */     this.notAffectsWaveKillCounter.update(paramFloat);
/* 376 */     this.lowAimPriority.update(paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canHaveRandomSideShift() {
/* 385 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float giveDamage(Tower paramTower, float paramFloat, DamageType paramDamageType) {
/* 392 */     float f = getBuffedDamageMultiplier((paramTower == null) ? null : paramTower.type, paramDamageType);
/*     */     
/* 394 */     if ((f = paramFloat * f) > getHealth()) f = getHealth(); 
/* 395 */     getHealth();
/*     */ 
/*     */ 
/*     */     
/* 399 */     setHealth(getHealth() - f);
/*     */     
/* 401 */     this.g += 0.5F;
/* 402 */     if (this.g > 1.0F) this.g = 1.0F;
/*     */     
/* 404 */     return f;
/*     */   }
/*     */   
/*     */   public float giveDamageRaw(float paramFloat, DamageType paramDamageType) {
/* 408 */     if (paramFloat > getHealth()) paramFloat = getHealth(); 
/* 409 */     getHealth();
/*     */ 
/*     */ 
/*     */     
/* 413 */     setHealth(getHealth() - paramFloat);
/*     */     
/* 415 */     this.g += 0.5F;
/* 416 */     if (this.g > 1.0F) this.g = 1.0F;
/*     */     
/* 418 */     return paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSize() {
/* 425 */     return 25.6F;
/*     */   }
/*     */   
/*     */   public float getSquaredSize() {
/* 429 */     return 655.36005F;
/*     */   }
/*     */   
/*     */   public void drawBatch(Batch paramBatch, float paramFloat) {
/* 433 */     drawBatch(paramBatch, paramFloat, Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawBatchAdditive(Batch paramBatch, float paramFloat) {
/* 440 */     if (this.g != 0.0F) {
/* 441 */       k.set(1.0F, 1.0F, 1.0F, this.g);
/* 442 */       drawBatch(paramBatch, paramFloat, k);
/* 443 */       this.g -= paramFloat * 10.0F;
/* 444 */       if (this.g < 0.0F) this.g = 0.0F; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setPositionToPath() {
/* 449 */     this.angle = this.graphPath.getRotation(this.passedTiles, this.sideShiftIndex);
/* 450 */     this.graphPath.getPosition(this.passedTiles, this.sideShiftIndex, this.c);
/* 451 */     applyDrawInterpolation(0.0F);
/* 452 */     onPositionSetToPath();
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector2 getPosition() {
/* 457 */     return this.c;
/*     */   }
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public final void setPosition(Vector2 paramVector2) {
/* 462 */     this.c.set(paramVector2);
/*     */   }
/*     */ 
/*     */   
/*     */   @IgnoreMethodOverloadLuaDefWarning
/*     */   public void setPosition(float paramFloat1, float paramFloat2) {
/* 468 */     this.c.set(paramFloat1, paramFloat2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void applyDrawInterpolation(float paramFloat) {
/* 473 */     if (this.S._gameUi == null)
/*     */       return; 
/* 475 */     if (paramFloat < 0.0F) paramFloat = 0.0F; 
/* 476 */     if (paramFloat > 1.0F) paramFloat = 1.0F;
/*     */     
/* 478 */     if (!this.disabled.isTrue() && this.graphPath != null) {
/*     */       float f;
/*     */ 
/*     */       
/* 482 */       if ((f = this.passedTiles + getPassedTilesDelta(paramFloat)) < -0.49999F) f = -0.499999F; 
/*     */       try {
/* 484 */         this.graphPath.getPosition(f, this.sideShiftIndex, this.drawPosition);
/* 485 */       } catch (Exception exception) {
/* 486 */         a.e("passedTiles: " + this.passedTiles + ", interpolatedTime: " + paramFloat + ", " + getPassedTilesDelta(paramFloat), new Object[0]);
/* 487 */         throw exception;
/*     */       } 
/* 489 */       this.drawAngle = this.graphPath.getRotation(exception, this.sideShiftIndex);
/*     */     } else {
/* 491 */       this.drawAngle = this.angle;
/* 492 */       this.drawPosition.set(getPosition());
/*     */     } 
/*     */     
/* 495 */     if (this.existsTime + paramFloat < 1.0F) {
/*     */       
/* 497 */       this.drawScale = Interpolation.pow2Out.apply(this.existsTime + paramFloat); return;
/*     */     } 
/* 499 */     this.drawScale = 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void drawBatch(Batch paramBatch, float paramFloat, Color paramColor) {
/* 504 */     k.set(paramColor);
/*     */     
/* 506 */     paramBatch.setColor(k);
/*     */ 
/*     */     
/* 509 */     if (this.S.enemy.isEmojiEnemies()) {
/*     */       TextureRegion textureRegion;
/*     */       
/* 512 */       paramFloat = (textureRegion = getEmojiTexture()).getRegionWidth() * this.drawScale;
/* 513 */       paramBatch.draw(textureRegion, this.drawPosition.x - paramFloat * 0.5F, this.drawPosition.y - paramFloat * 0.5F, paramFloat, paramFloat);
/*     */     } else {
/*     */       TextureRegion textureRegion;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 520 */       if (this.loot != null) {
/* 521 */         textureRegion = getHighlightTexture();
/*     */       } else {
/* 523 */         textureRegion = getTexture();
/*     */       } 
/*     */       
/* 526 */       paramFloat = textureRegion.getRegionWidth() * this.drawScale;
/* 527 */       paramBatch.draw(textureRegion, this.drawPosition.x - paramFloat * 0.5F, this.drawPosition.y - paramFloat * 0.5F, paramFloat * 0.5F, paramFloat * 0.5F, paramFloat, paramFloat, 1.0F, 1.0F, this.drawAngle);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 536 */     if (hasBuffsByType(BuffType.BLIZZARD) || hasBuffsByType(BuffType.SNOWBALL)) {
/* 537 */       paramBatch.draw(Game.i.enemyManager.getIceOverlayTexture(this.id % 2), this.drawPosition.x - paramFloat * 0.5F, this.drawPosition.y - paramFloat * 0.5F, paramFloat, paramFloat);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack addLoot(Item paramItem, int paramInt) {
/* 549 */     if (this.loot == null) {
/* 550 */       this.loot = new Array(true, 1, ItemStack.class);
/*     */     }
/*     */     ItemStack itemStack;
/* 553 */     (itemStack = ProgressManager.addItemToStacksArray(this.loot, paramItem, paramInt)).covered = (itemStack.getItem() != Item.D.GREEN_PAPER && itemStack.getItem() != Item.D.BIT_DUST);
/* 554 */     return itemStack;
/*     */   }
/*     */   
/*     */   public TextureRegion getTexture() {
/* 558 */     return this.S.enemy.getTexture(this.type);
/*     */   }
/*     */   
/*     */   public TextureRegion getHighlightTexture() {
/* 562 */     return this.S.enemy.getHighlightTexture(this.type);
/*     */   }
/*     */   
/*     */   public TextureRegion getEmojiTexture() {
/* 566 */     return this.S.enemy.getEmojiTexture(this.type);
/*     */   }
/*     */   
/*     */   public void drawHealth(Batch paramBatch) {
/* 570 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */ 
/*     */     
/* 573 */     if (this.buffsByType != null) {
/* 574 */       byte b1 = 0; BuffType[] arrayOfBuffType1; int j;
/* 575 */       for (int i = (arrayOfBuffType1 = BuffType.values).length; j < i; ) { BuffType buffType = arrayOfBuffType1[j];
/* 576 */         if ((this.buffsByType[buffType.ordinal()]).size != 0) {
/* 577 */           b1++;
/*     */         }
/*     */         j++; }
/*     */       
/* 581 */       float f1 = this.drawPosition.x - b1 * 16.0F * 0.5F; BuffType[] arrayOfBuffType2; byte b2;
/* 582 */       for (j = (arrayOfBuffType2 = BuffType.values).length, b2 = 0; b2 < j; ) { BuffType buffType = arrayOfBuffType2[b2];
/*     */         DelayedRemovalArray delayedRemovalArray;
/* 584 */         if ((delayedRemovalArray = this.buffsByType[buffType.ordinal()]).size != 0) {
/* 585 */           byte b = 0;
/*     */           int k;
/* 587 */           if ((k = delayedRemovalArray.size - 1) > 6) {
/* 588 */             k = 6;
/*     */           }
/* 590 */           for (k = k; k >= 0; ) {
/* 591 */             b++;
/* 592 */             Buff buff = ((Buff[])delayedRemovalArray.items)[k];
/* 593 */             paramBatch.draw(buff.getHealthBarIcon(), f1, this.drawPosition.y + 68.0F + k * 6.0F, 16.0F, 16.0F);
/* 594 */             if (b != 5)
/*     */               k--; 
/* 596 */           }  f1 += 16.0F;
/*     */         } 
/*     */         
/*     */         b2++; }
/*     */     
/*     */     } 
/* 602 */     float f = this.d / this.maxHealth;
/*     */     
/* 604 */     paramBatch.setColor(HEALTH_BAR_BACKGROUND_COLOR);
/* 605 */     paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.drawPosition.x - 28.0F * this.healthBarScale, this.drawPosition.y + 52.0F * this.healthBarScale, 56.0F * this.healthBarScale, 8.0F * this.healthBarScale);
/*     */     
/* 607 */     if (this.i == null || this.j != f) {
/* 608 */       if (this.i == null) {
/* 609 */         this.i = new Color();
/*     */       }
/* 611 */       this.j = f;
/* 612 */       this.i.set(0.956F + -0.658F * f, 0.262F + 0.424F * f, 0.211F + 0.102F * f, 1.0F);
/*     */     } 
/* 614 */     paramBatch.setColor(this.i);
/* 615 */     paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.drawPosition.x - 26.0F * this.healthBarScale, this.drawPosition.y + 54.0F * this.healthBarScale, (int)(52.0F * f * this.healthBarScale), 4.0F * this.healthBarScale);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHealth(float paramFloat) {
/* 620 */     if (Float.isNaN(paramFloat)) throw new IllegalArgumentException("HP is NaN, previously " + this.d); 
/* 621 */     this.d = paramFloat;
/*     */   }
/*     */   
/*     */   public void setKillExp(float paramFloat) {
/* 625 */     this.b = paramFloat;
/*     */   }
/*     */   
/*     */   public float getKillExp() {
/* 629 */     return this.b;
/*     */   }
/*     */   
/*     */   public int getKillScore() {
/* 633 */     return this.killScore;
/*     */   }
/*     */   
/*     */   public float getHealth() {
/* 637 */     return this.d;
/*     */   }
/*     */   
/*     */   public void setMaxHealth(float paramFloat) {
/* 641 */     this.maxHealth = paramFloat;
/*     */   }
/*     */   
/*     */   public void setSpeed(float paramFloat) {
/* 645 */     this.e = paramFloat;
/*     */   }
/*     */   
/*     */   public float getSpeed() {
/* 649 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getPassedTilesDelta(float paramFloat) {
/* 659 */     return this.graphPath.getPassedTilesDelta(paramFloat, this.passedTiles, this.sideShiftIndex, getBuffedSpeed());
/*     */   }
/*     */   
/*     */   public float getBuffedSpeed() {
/* 663 */     return this.f;
/*     */   }
/*     */   
/*     */   public float getTowerDamageMultiplier(TowerType paramTowerType) {
/* 667 */     return this.S.tower.towerEnemyDamageMultiplier[this.type.ordinal()][paramTowerType.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getBuffedDamageMultiplier(TowerType paramTowerType, DamageType paramDamageType) {
/* 674 */     float f1 = (paramTowerType == null) ? 1.0F : getTowerDamageMultiplier(paramTowerType);
/*     */     
/* 676 */     if (hasBuffsByType(BuffType.INVULNERABILITY)) {
/* 677 */       return 0.0F;
/*     */     }
/*     */ 
/*     */     
/* 681 */     DelayedRemovalArray delayedRemovalArray1 = getBuffsByTypeOrNull(BuffType.FREEZING);
/* 682 */     byte b = 0;
/* 683 */     if (delayedRemovalArray1 != null && delayedRemovalArray1.size != 0) {
/* 684 */       int i = this.S.gameValue.getIntValue(GameValueType.TOWER_FREEZING_A_EVAPORATION_STACK);
/* 685 */       float f = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FREEZING_A_EVAPORATION_DAMAGE);
/* 686 */       byte b1 = 0;
/*     */ 
/*     */       
/* 689 */       b++; FreezingBuff freezingBuff;
/* 690 */       for (; b1 < delayedRemovalArray1.size && ((freezingBuff = ((FreezingBuff[])delayedRemovalArray1.items)[b1]).tower == null || freezingBuff.tower.type != TowerType.FREEZING || !freezingBuff.tower.isAbilityInstalled(0) || b != i); b1++);
/*     */ 
/*     */       
/* 693 */       f1 *= 1.0F + f * b;
/*     */     } 
/*     */ 
/*     */     
/* 697 */     if (hasBuffsByType(BuffType.ARMOR)) {
/* 698 */       f1 *= 0.5F;
/*     */     }
/*     */     
/*     */     DelayedRemovalArray delayedRemovalArray2;
/*     */     
/* 703 */     if ((delayedRemovalArray2 = getBuffsByTypeOrNull(BuffType.BLIZZARD)) != null && delayedRemovalArray2.size != 0) {
/* 704 */       BlizzardBuff blizzardBuff = (BlizzardBuff)delayedRemovalArray2.first();
/* 705 */       f1 *= blizzardBuff.damageMultiplier;
/*     */     } 
/*     */     
/*     */     DelayedRemovalArray delayedRemovalArray3;
/*     */     
/* 710 */     if ((delayedRemovalArray3 = getBuffsByTypeOrNull(BuffType.VULNERABILITY)) != null && delayedRemovalArray3.size != 0) {
/* 711 */       float f = 1.0F;
/* 712 */       for (byte b1 = 0; b1 < delayedRemovalArray3.size; b1++) {
/*     */         VulnerabilityBuff vulnerabilityBuff;
/* 714 */         if ((vulnerabilityBuff = (VulnerabilityBuff)delayedRemovalArray3.items[b1]).damageMultiplier > f) {
/* 715 */           f = vulnerabilityBuff.damageMultiplier;
/*     */         }
/*     */       } 
/* 718 */       f1 *= f;
/*     */     } 
/*     */     
/*     */     float f2;
/*     */     
/* 723 */     if ((f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ENEMIES_VULNERABILITY)) < 0.0F) f2 = 0.0F;
/*     */ 
/*     */     
/* 726 */     return f1 = f1 * f2;
/*     */   }
/*     */   public abstract boolean hasDrawPriority();
/*     */   public float getBaseDamage() {
/* 730 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onSpawned() {}
/*     */   
/*     */   public void onPreDie() {}
/*     */   
/*     */   public void onPositionSetToPath() {}
/*     */   
/*     */   public final boolean canBeBuffed(BuffType paramBuffType) {
/* 741 */     return (getBuffVulnerability(paramBuffType) > 0.0F);
/*     */   }
/*     */   
/*     */   public float getBuffVulnerability(BuffType paramBuffType) {
/* 745 */     if (hasBuffsByType(BuffType.INVULNERABILITY) && this.S.buff.getProcessor(paramBuffType).isDebuff()) {
/* 746 */       return 0.0F;
/*     */     }
/* 748 */     return this.S.enemy.enemyBuffVulnerability[this.type.ordinal()][paramBuffType.ordinal()];
/*     */   }
/*     */   
/*     */   public boolean isVulnerableTo(DamageType paramDamageType) {
/* 752 */     if (hasBuffsByType(BuffType.INVULNERABILITY)) {
/* 753 */       return false;
/*     */     }
/* 755 */     return this.S.enemy.enemyDamageVulnerability[this.type.ordinal()][paramDamageType.ordinal()];
/*     */   }
/*     */   
/*     */   public boolean isBossRelated() {
/* 759 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isBossMainBodyPart() {
/* 763 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isVulnerableToSpecial(SpecialDamageType paramSpecialDamageType) {
/* 767 */     if (hasBuffsByType(BuffType.INVULNERABILITY)) {
/* 768 */       return false;
/*     */     }
/* 770 */     return this.S.enemy.enemySpecialDamageVulnerability[this.type.ordinal()][paramSpecialDamageType.ordinal()];
/*     */   }
/*     */   
/*     */   public float getAbilityVulnerability(AbilityType paramAbilityType) {
/* 774 */     if (hasBuffsByType(BuffType.INVULNERABILITY)) {
/* 775 */       return 0.0F;
/*     */     }
/* 777 */     return 1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeAttackedBy(Tower paramTower) {
/* 783 */     return true;
/*     */   }
/*     */   public boolean isAir() {
/* 786 */     return this.S.enemy.flyingEnemy[this.type.ordinal()];
/*     */   }
/*     */   
/*     */   public boolean dynamicPathfindingAllowed() {
/* 790 */     return true;
/*     */   }
/*     */   
/*     */   public ParticleEffectPool.PooledEffect getBreakParticle() {
/* 794 */     return (ParticleEffectPool.PooledEffect)Factory.a(Game.i.enemyManager.getFactory(this.type)).obtain();
/*     */   }
/*     */   
/*     */   public ParticleEffectPool.PooledEffect getHitParticle() {
/* 798 */     return (ParticleEffectPool.PooledEffect)Factory.b(Game.i.enemyManager.getFactory(this.type)).obtain();
/*     */   }
/*     */   
/*     */   public static abstract class Factory<T extends Enemy>
/*     */     implements Disposable, EntityFactory {
/*     */     private ParticleEffectPool a;
/*     */     private ParticleEffectPool b;
/*     */     private final String c;
/*     */     private final String d;
/*     */     
/*     */     public Factory(EnemyType param1EnemyType) {
/* 809 */       this.c = "enemy_name_" + param1EnemyType.name();
/* 810 */       this.d = "enemy_description_" + param1EnemyType.name();
/*     */       
/* 812 */       if (Game.i.assetManager != null) {
/*     */         ParticleEffect particleEffect;
/* 814 */         (particleEffect = new ParticleEffect()).load(Gdx.files.internal("particles/break.prt"), (AssetManager.TextureRegions.i()).blank.getAtlas());
/* 815 */         particleEffect.setEmittersCleanUpBlendFunction(false);
/* 816 */         ((ParticleEmitter)particleEffect.getEmitters().get(0)).getTint().setColors(new float[] { (getColor()).r, (getColor()).g, (getColor()).b });
/* 817 */         this.a = Game.i.assetManager.getParticleEffectPoolWithTemplate("break.prt@enemyType:" + param1EnemyType.name(), particleEffect);
/*     */ 
/*     */         
/* 820 */         (particleEffect = new ParticleEffect()).load(Gdx.files.internal("particles/enemy-hit.prt"), (AssetManager.TextureRegions.i()).blank.getAtlas());
/* 821 */         particleEffect.setEmittersCleanUpBlendFunction(false);
/* 822 */         ((ParticleEmitter)particleEffect.getEmitters().get(0)).getTint().setColors(new float[] { (getColor()).r, (getColor()).g, (getColor()).b });
/* 823 */         this.b = Game.i.assetManager.getParticleEffectPoolWithTemplate("enemy-hit.prt@enemyType:" + param1EnemyType.name(), particleEffect);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setup() {
/* 828 */       if (Game.i.assetManager != null) {
/* 829 */         setupAssets();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {}
/*     */ 
/*     */     
/*     */     public final T obtain() {
/* 838 */       return create();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getTitle() {
/* 844 */       return Game.i.localeManager.i18n.get(this.c);
/*     */     }
/*     */     
/*     */     public String getDescription() {
/* 848 */       return Game.i.localeManager.i18n.get(this.d);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public TextureRegion getEmojiTexture() {
/* 854 */       return getTexture();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTextureSize() {
/* 862 */       return getTexture().getRegionWidth();
/*     */     }
/*     */     public void dispose() {}
/*     */     
/*     */     protected abstract T create();
/*     */     
/*     */     public abstract Color getColor();
/*     */     
/*     */     public abstract TextureRegion getTexture();
/*     */     
/*     */     public abstract TextureRegion getHighlightTexture(); }
/*     */   
/*     */   @REGS(arrayLevels = 1)
/*     */   public static class EnemyReference implements KryoSerializable { public static final EnemyReference NULL;
/*     */     public Enemy enemy;
/*     */     
/*     */     static {
/* 879 */       SyncChecker.addSyncShareableObject(NULL = new EnemyReference());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 886 */       param1Kryo.writeClassAndObject(param1Output, this.enemy);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 891 */       this.enemy = (Enemy)param1Kryo.readClassAndObject(param1Input);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Enemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */