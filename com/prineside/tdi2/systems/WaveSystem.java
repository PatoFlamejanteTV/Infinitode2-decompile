/*      */ package com.prineside.tdi2.systems;
/*      */ 
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.math.RandomXS128;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.IntArray;
/*      */ import com.badlogic.gdx.utils.IntMap;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.ObjectSet;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.tdi2.Action;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.DamageRecord;
/*      */ import com.prineside.tdi2.Enemy;
/*      */ import com.prineside.tdi2.EnemyGroup;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystem;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.Map;
/*      */ import com.prineside.tdi2.SerializableListener;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.Tower;
/*      */ import com.prineside.tdi2.UserMap;
/*      */ import com.prineside.tdi2.Wave;
/*      */ import com.prineside.tdi2.WaveProcessor;
/*      */ import com.prineside.tdi2.WaveTemplates;
/*      */ import com.prineside.tdi2.actions.CallWaveAction;
/*      */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*      */ import com.prineside.tdi2.enums.BossType;
/*      */ import com.prineside.tdi2.enums.DamageType;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.events.Event;
/*      */ import com.prineside.tdi2.events.Listener;
/*      */ import com.prineside.tdi2.events.game.EnemyDie;
/*      */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*      */ import com.prineside.tdi2.events.game.EnemyTakeDamage;
/*      */ import com.prineside.tdi2.events.game.WaveStart;
/*      */ import com.prineside.tdi2.events.game.WaveStatusChange;
/*      */ import com.prineside.tdi2.tiles.SpawnTile;
/*      */ import com.prineside.tdi2.ui.shared.WavesTimelineOverlay;
/*      */ import com.prineside.tdi2.utils.IgnoreMethodOverloadLuaDefWarning;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.NoFieldKryoSerializable;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.WaveBossSupplier;
/*      */ import com.prineside.tdi2.utils.WaveDifficultyProvider;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import com.prineside.tdi2.waves.processors.BrootBossWaveProcessor;
/*      */ import com.prineside.tdi2.waves.processors.ConstructorBossWaveProcessor;
/*      */ import com.prineside.tdi2.waves.processors.MetaphorBossWaveProcessor;
/*      */ import com.prineside.tdi2.waves.processors.MobchainBossWaveProcessor;
/*      */ import com.prineside.tdi2.waves.processors.SnakeBossWaveProcessor;
/*      */ import java.util.Arrays;
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
/*      */ @REGS
/*      */ public final class WaveSystem
/*      */   extends GameSystem
/*      */ {
/*      */   public WaveSystem() {
/*   95 */     this.b = null;
/*   96 */     this.mode = Mode.ENDLESS;
/*      */ 
/*      */ 
/*      */     
/*  100 */     this.c = new DelayedRemovalArray(WaveProcessor.class);
/*      */ 
/*      */ 
/*      */     
/*  104 */     this.autoForceWaveEnabled = false;
/*  105 */     this.instantWaveCallsEnabled = false;
/*  106 */     this.nextWavesCache = new WaveCache[10];
/*  107 */     this.wavesToNotifyAboutCompletion = new DelayedRemovalArray(true, 1, Wave.class);
/*  108 */     this.g = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  116 */     this.m = 1.0F;
/*  117 */     this.n = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  123 */     this.p = new IntMap();
/*      */     
/*  125 */     this.q = new ObjectSet();
/*  126 */     this.r = new Array(true, 1, SpawnTile.class);
/*  127 */     this.s = new DelayedRemovalArray(true, 1, Wave.class);
/*      */ 
/*      */     
/*  130 */     this.t = new ObjectMap();
/*      */ 
/*      */     
/*  133 */     this.t.put(BossType.SNAKE, new SnakeBossWaveProcessor.SnakeBossWaveProcessorFactory());
/*  134 */     this.t.put(BossType.BROOT, new BrootBossWaveProcessor.BrootBossWaveProcessorFactory());
/*  135 */     this.t.put(BossType.CONSTRUCTOR, new ConstructorBossWaveProcessor.ConstructorBossWaveProcessorFactory());
/*  136 */     this.t.put(BossType.MOBCHAIN, new MobchainBossWaveProcessor.MobchainBossWaveProcessorFactory());
/*  137 */     this.t.put(BossType.METAPHOR, new MetaphorBossWaveProcessor.MetaphorBossWaveProcessorFactory()); BossType[] arrayOfBossType; int i;
/*      */     byte b;
/*  139 */     for (i = (arrayOfBossType = BossType.values).length, b = 0; b < i; ) { BossType bossType = arrayOfBossType[b];
/*  140 */       if (!this.t.containsKey(bossType))
/*  141 */         throw new RuntimeException("Not all wave processor factories created"); 
/*      */       b++; }
/*      */     
/*  144 */     for (i = (arrayOfBossType = BossType.values).length, b = 0; b < i; ) { BossType bossType = arrayOfBossType[b];
/*  145 */       ((WaveProcessor.WaveProcessorFactory)this.t.get(bossType)).setup();
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
/*      */       b++; }
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
/*  648 */     this.u = new RandomXS128(1337L);
/*  649 */     this.v = Long.MIN_VALUE;
/*  650 */     this.w = -1; } private static final TLog a = TLog.forClass(WaveSystem.class); public static final int NEXT_WAVES_CACHE_SIZE = 10; public static final float ULTRA_DIFFICULT_MILESTONE_MULTIPLIER = 1.75F; public static final int WAVES_TIMELINE_MAX_WAVE = 100; public static final float ENEMY_INTERVAL_DENSITY_HIGH = 0.25F; public static final float ENEMY_INTERVAL_DENSITY_LOW = 1.0F; private WaveTemplates.WaveTemplate b; public Mode mode; public Status status; public Wave wave; private DelayedRemovalArray<WaveProcessor> c; private float d; private float e; private float f; @NAGS public boolean autoForceWaveEnabled; @NAGS public boolean instantWaveCallsEnabled; public WaveCache[] nextWavesCache; public DelayedRemovalArray<Wave> wavesToNotifyAboutCompletion; private int g; private boolean h; private boolean i; private int j; private float k; private float l; private float m; @NAGS private WaveDifficultyProvider n; public WaveTemplates.PredefinedWaveTemplate[] predefinedWaveTemplates; public WaveBossSupplier bossWaves; private WaveGenerator o; private IntMap<WaveCache> p; @NAGS private final ObjectSet<EnemyType> q; @NAGS
/*      */   private final Array<SpawnTile> r; @NAGS
/*      */   private final DelayedRemovalArray<Wave> s; @NAGS
/*  653 */   private final ObjectMap<BossType, WaveProcessor.WaveProcessorFactory<?>> t; private float a(int paramInt, long paramLong) { if (paramInt <= 0) throw new IllegalArgumentException("Wave number can't be < 1");
/*      */     
/*  655 */     this.S.syncLog("WaveSystem generateSeedMultiplier", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
/*      */     
/*  657 */     if (this.v == paramLong && paramInt == this.w) {
/*  658 */       this.w++;
/*  659 */       float f1 = this.u.nextFloat();
/*  660 */       this.S.syncLog("WaveSystem generateSeedMultiplier result instant ", new Object[] { Float.valueOf(f1) });
/*  661 */       return f1;
/*      */     } 
/*      */     
/*  664 */     this.u.setSeed(paramLong);
/*  665 */     for (byte b = 0; b < paramInt; b++) {
/*  666 */       this.u.nextFloat();
/*      */     }
/*  668 */     this.v = paramLong;
/*  669 */     this.w = paramInt + 1;
/*  670 */     float f = this.u.nextFloat();
/*  671 */     this.S.syncLog("WaveSystem generateSeedMultiplier result", new Object[] { Float.valueOf(f) });
/*  672 */     return f; }
/*      */   @NAGS private final RandomXS128 u;
/*      */   @NAGS private long v;
/*      */   @NAGS private int w; @REGS public enum Mode {
/*      */     ENDLESS, PREDEFINED; } @REGS public enum Status {
/*  677 */     NOT_STARTED, SPAWNING, SPAWNED, ENDED; } public final void write(Kryo paramKryo, Output paramOutput) { super.write(paramKryo, paramOutput); paramKryo.writeClassAndObject(paramOutput, this.b); paramKryo.writeObject(paramOutput, this.mode); paramKryo.writeObjectOrNull(paramOutput, this.status, Status.class); paramKryo.writeClassAndObject(paramOutput, this.wave); paramKryo.writeObject(paramOutput, this.c); paramOutput.writeFloat(this.d); paramOutput.writeFloat(this.e); paramOutput.writeFloat(this.f); paramKryo.writeObject(paramOutput, this.nextWavesCache); paramKryo.writeObject(paramOutput, this.wavesToNotifyAboutCompletion); paramOutput.writeVarInt(this.g, true); paramOutput.writeBoolean(this.h); paramOutput.writeBoolean(this.i); paramOutput.writeVarInt(this.j, true); paramOutput.writeFloat(this.k); paramOutput.writeFloat(this.l); paramOutput.writeFloat(this.m); paramKryo.writeClassAndObject(paramOutput, this.predefinedWaveTemplates); paramKryo.writeClassAndObject(paramOutput, this.bossWaves); paramKryo.writeClassAndObject(paramOutput, this.o); paramKryo.writeClassAndObject(paramOutput, this.p); } public final void read(Kryo paramKryo, Input paramInput) { super.read(paramKryo, paramInput); this.b = (WaveTemplates.WaveTemplate)paramKryo.readClassAndObject(paramInput); this.mode = (Mode)paramKryo.readObject(paramInput, Mode.class); this.status = (Status)paramKryo.readObjectOrNull(paramInput, Status.class); this.wave = (Wave)paramKryo.readClassAndObject(paramInput); this.c = (DelayedRemovalArray<WaveProcessor>)paramKryo.readObject(paramInput, DelayedRemovalArray.class); this.d = paramInput.readFloat(); this.e = paramInput.readFloat(); this.f = paramInput.readFloat(); this.nextWavesCache = (WaveCache[])paramKryo.readObject(paramInput, WaveCache[].class); this.wavesToNotifyAboutCompletion = (DelayedRemovalArray<Wave>)paramKryo.readObject(paramInput, DelayedRemovalArray.class); this.g = paramInput.readVarInt(true); this.h = paramInput.readBoolean(); this.i = paramInput.readBoolean(); this.j = paramInput.readVarInt(true); this.k = paramInput.readFloat(); this.l = paramInput.readFloat(); this.m = paramInput.readFloat(); this.predefinedWaveTemplates = (WaveTemplates.PredefinedWaveTemplate[])paramKryo.readClassAndObject(paramInput); this.bossWaves = (WaveBossSupplier)paramKryo.readClassAndObject(paramInput); this.o = (WaveGenerator)paramKryo.readClassAndObject(paramInput); this.p = (IntMap<WaveCache>)paramKryo.readClassAndObject(paramInput); } public final boolean affectsGameState() { return true; } public final void setup() { this.S.events.getListeners(EnemyDie.class).addStateAffecting(new OnEnemyDie(this)); this.S.events.getListeners(EnemyTakeDamage.class).addStateAffecting(new OnEnemyTakeDamage()); this.S.events.getListeners(EnemyReachTarget.class).addStateAffecting(new OnEnemyReachTarget(this)); if (!this.S.CFG.headless) a();  } private void a() { this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.WAVE_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramBatch, paramFloat2))).setName("Wave-draw")); } public final void draw(Batch paramBatch, float paramFloat) { for (byte b = 0; b < this.c.size; b++) ((WaveProcessor[])this.c.items)[b].draw(paramBatch, paramFloat);  } public final WaveProcessor createBossWaveProcessor(BossType paramBossType) { return ((WaveProcessor.WaveProcessorFactory)this.t.get(paramBossType)).create(); } public final Wave generateBossWaveWithProcessor(BossType paramBossType, int paramInt1, int paramInt2) { return ((WaveProcessor.WaveProcessorFactory)this.t.get(paramBossType)).create().setup(this.S, paramInt1, paramInt2); } public final WaveProcessor.WaveProcessorFactory<?> getWaveProcessorFactory(BossType paramBossType) { return (WaveProcessor.WaveProcessorFactory)this.t.get(paramBossType); } public final float getWaveStartInterval() { return this.S.gameValue.getFloatValue(GameValueType.WAVE_INTERVAL); } public final void setWaveGenerator(WaveGenerator paramWaveGenerator) { this.o = paramWaveGenerator; resetNextWavesCache(); b(); } public final WaveGenerator getWaveGenerator() { return this.o; } public final void postSetup() { setStatus(Status.NOT_STARTED); } public final void postStateRestore() { this.instantWaveCallsEnabled = Game.i.settingsManager.isInstantAutoWaveCallEnabled(); a(); } public final void setForcedTemplate(String paramString) { WaveTemplates.WaveTemplate waveTemplate = null; WaveTemplates.WaveTemplate[] arrayOfWaveTemplate; int i; byte b; for (i = (arrayOfWaveTemplate = WaveTemplates.WAVE_TEMPLATES).length, b = 0; b < i; b++) { WaveTemplates.WaveTemplate waveTemplate1; if ((waveTemplate1 = arrayOfWaveTemplate[b]).getWaveName().equals(paramString)) { waveTemplate = waveTemplate1; break; }  }  if (waveTemplate == null) throw new IllegalArgumentException("Forced wave template '" + this.b + "' not found");  this.b = waveTemplate; resetNextWavesCache(); b(); } public final void overrideWave(int paramInt, Wave paramWave) { this.S.gameState.checkGameplayUpdateAllowed(); if (this.wave != null && this.wave.waveNumber >= paramInt) { a.e("failed to override wave - wave " + paramInt + " already spawned", new Object[0]); return; }  this.p.put(paramInt, new WaveCache(paramWave, paramInt)); a.i("overriding wave " + paramInt + " with wave " + paramWave, new Object[0]); resetNextWavesCache(); b(); } public final int getNextOverridableWaveNumber() { if (this.wave == null) return 1;  if (d() == null) return this.wave.waveNumber + 1;  for (int i = this.wave.waveNumber + 1; i < this.wave.waveNumber + 51; i++) { if (!this.p.containsKey(i)) { a.i("getNextOverridableWaveNumber in loop, current " + this.wave.waveNumber + ", return " + i, new Object[0]); return i; }  }  return -1; } public final void setBossWaves(WaveBossSupplier paramWaveBossSupplier) { this.bossWaves = paramWaveBossSupplier; } public final void resetNextWavesCache() { this.S.gameState.checkGameplayUpdateAllowed(); Arrays.fill((Object[])this.nextWavesCache, (Object)null); } public final int getForceWaveBonus() { return this.i ? (this.j << 1) : this.j; } public final int getCompletedWavesCount() { return this.g; } public final boolean isForceWaveAvailable() { return this.h; } public final void forceNextWaveAction() { if (isForceWaveAvailable()) this.S.gameState.pushActionNextUpdate((Action)new CallWaveAction());  } public final void freezeTimeToNextWave(float paramFloat) { if (paramFloat < 0.0F) { this.f = 0.0F; return; }  this.f += paramFloat; } public final void setStatus(Status paramStatus) { this.S.gameState.checkGameplayUpdateAllowed(); Status status = this.status; this.status = paramStatus; if (paramStatus == Status.SPAWNED) this.e = 0.0F;  b(); this.S.events.trigger((Event)new WaveStatusChange(status)); } public final void setDifficultyExpectedPlaytime(float paramFloat) { this.m = paramFloat; this.n = null; } @Deprecated public static float getDifficultWavesMultiplierOld(int paramInt, int[] paramArrayOfint) { float f1 = 1.0F; for (byte b1 = 1; b1 <= paramInt; b1++) { for (int i = 3; i >= 0; i--) { if (paramArrayOfint[i] != 0 && b1 > paramArrayOfint[i]) { if (i == 0) { f1 = (float)(f1 + 0.01D); break; }  if (i == 1) { f1 = (float)(f1 + 0.02D); break; }  if (i == 2) { i = b1 - paramArrayOfint[2]; f1 = (float)(f1 + 0.03D + StrictMath.pow(i, 1.15D) * 0.004D); break; }  i = b1 - paramArrayOfint[2]; f1 = (float)(f1 + 0.04D + StrictMath.pow(i, 1.15D) * 0.005D); break; }  }  }  float f2 = 0.04F; for (byte b2 = 3; b2 >= 0; b2--) { if (paramArrayOfint[b2] != 0 && paramInt > paramArrayOfint[b2]) { if (b2 == 0) { f2 = 0.04F; break; }  if (b2 == 1) { f2 = 0.035F; break; }  if (b2 == 2) { f2 = 0.025F; break; }  f2 = 0.015F; break; }  }  float f3; if ((f3 = PMath.sin((paramInt + 90)) * f2) < 0.0F) f1 += f1 * f3;  return f1; } public final WaveDifficultyProvider getWaveDifficultyProvider() { if (this.n == null) this.n = new WaveDifficultyProvider((int)this.S.gameState.getSeed(), this.S.gameState.averageDifficulty, this.m);  return this.n; } @IgnoreMethodOverloadLuaDefWarning private WaveCache a(int paramInt) { this.S.syncLog("WaveSystem generateWave D", new Object[] { Integer.valueOf(paramInt) }); this.S.gameState.checkGameplayUpdateAllowed(); Wave wave = null; int i = getWaveDifficultyProvider().getDifficultWavesMultiplier(paramInt); if (this.mode == Mode.ENDLESS) { if (this.bossWaves != null && this.bossWaves.getWaveBoss(paramInt) != null) { wave = generateBossWaveWithProcessor(this.bossWaves.getWaveBoss(paramInt), paramInt, i); } else if (this.b != null) { wave = generateWave(this.b, paramInt, i); } else { this.q.clear(); Array array = this.S.map.getMap().getTilesByType(SpawnTile.class); for (byte b = 0; b < (this.S.map.getMap().getAllowedEnemies()).size; b++) { EnemyType enemyType = ((EnemyType[])(this.S.map.getMap().getAllowedEnemies()).items)[b]; boolean bool = false; for (byte b1 = 0; b1 < array.size; b1++) { SpawnTile spawnTile; if ((spawnTile = ((SpawnTile[])array.items)[b1]).isEnemyAllowedOnWave(enemyType, paramInt)) { bool = true; break; }  }  if (bool) this.q.add(enemyType);  }  if (this.q.size != 0) wave = generateWave(paramInt, i, this.S.gameState.getSeed(), this.q);  this.q.clear(); }  } else if (this.bossWaves != null && this.bossWaves.getWaveBoss(paramInt) != null) { wave = generateBossWaveWithProcessor(this.bossWaves.getWaveBoss(paramInt), paramInt, this.S.gameState.averageDifficulty); } else { int j; if ((j = paramInt - 1) < this.predefinedWaveTemplates.length) wave = generateWave(paramInt, this.S.gameState.averageDifficulty, this.predefinedWaveTemplates[j]);  }  WaveCache waveCache; (waveCache = new WaveCache()).waveNumber = paramInt; if (this.o == null) { waveCache.wave = wave; } else { waveCache.wave = this.o.generate(paramInt, wave, this.S, i); }  return waveCache; } @Null public final Array<EnemyGroup> generateEnemyGroups(int paramInt1, Mode paramMode, WaveDifficultyProvider paramWaveDifficultyProvider, int paramInt2, WaveBossSupplier paramWaveBossSupplier, Map paramMap, long paramLong, WaveTemplates.PredefinedWaveTemplate[] paramArrayOfPredefinedWaveTemplate) { ObjectSet<EnemyType> objectSet; boolean bool; Wave wave; if (paramMode == Mode.ENDLESS) { int j = paramWaveDifficultyProvider.getDifficultWavesMultiplier(paramInt1); Array array = this.S.map.getMap().getTilesByType(SpawnTile.class); if (paramWaveBossSupplier != null && paramWaveBossSupplier.getWaveBoss(paramInt1) != null) { paramInt2 = 0; for (byte b1 = 0; b1 < array.size; b1++) { SpawnTile spawnTile; if ((spawnTile = (SpawnTile)array.get(b1)).isEnemyAllowedOnWave(EnemyType.BOSS, paramInt1)) { paramInt2 = 1; break; }  }  if (paramInt2 == 0) return null;  return createBossWaveProcessor(paramWaveBossSupplier.getWaveBoss(paramInt1)).generateEnemyGroups(paramInt1, j); }  objectSet = new ObjectSet(); for (byte b = 0; b < (paramMap.getAllowedEnemies()).size; b++) { EnemyType enemyType = ((EnemyType[])(paramMap.getAllowedEnemies()).items)[b]; bool = false; for (byte b1 = 0; b1 < array.size; b1++) { SpawnTile spawnTile; if ((spawnTile = ((SpawnTile[])array.items)[b1]).isEnemyAllowedOnWave(enemyType, paramInt1)) { bool = true; break; }  }  if (bool) objectSet.add(enemyType);  }  if ((wave = generateWave(paramInt1, j, paramLong, objectSet)) == null) return null;  return (Array<EnemyGroup>)wave.enemyGroups; }  if (bool != null && bool.getWaveBoss(paramInt1) != null) return createBossWaveProcessor(bool.getWaveBoss(paramInt1)).generateEnemyGroups(paramInt1, objectSet);  int i; if ((i = paramInt1 - 1) < wave.length) return (Array<EnemyGroup>)(generateWave(paramInt1, objectSet, (WaveTemplates.PredefinedWaveTemplate)wave[i])).enemyGroups;  return null; } @IgnoreMethodOverloadLuaDefWarning public final Wave generateWave(int paramInt1, int paramInt2, WaveTemplates.PredefinedWaveTemplate paramPredefinedWaveTemplate) { this.S.syncLog("WaveSystem generateWave A", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramPredefinedWaveTemplate });
/*  678 */     Array array = new Array(); EnemyGroup[] arrayOfEnemyGroup; int i; byte b;
/*  679 */     for (i = (arrayOfEnemyGroup = paramPredefinedWaveTemplate.enemyGroups).length, b = 0; b < i; ) { EnemyGroup enemyGroup = arrayOfEnemyGroup[b];
/*  680 */       array.add(enemyGroup.cpy()); b++; }
/*      */     
/*      */     Wave wave;
/*  683 */     (wave = new Wave(paramInt1, paramInt2, array)).waveMessage = paramPredefinedWaveTemplate.waveMessage;
/*      */     
/*  685 */     return wave; }
/*      */ 
/*      */   
/*      */   public static float getWaveValue(int paramInt1, int paramInt2) {
/*  689 */     return paramInt1 * paramInt2 * 0.01F;
/*      */   } @IgnoreMethodOverloadLuaDefWarning
/*      */   @Null
/*      */   public final Wave generateWave(int paramInt1, int paramInt2, long paramLong, ObjectSet<EnemyType> paramObjectSet) {
/*      */     WaveTemplates.WaveTemplate waveTemplate;
/*  694 */     this.S.syncLog("WaveSystem generateWave B", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramObjectSet });
/*  695 */     float f2 = getWaveValue(paramInt1, paramInt2);
/*  696 */     float f1 = a(paramInt1, paramLong);
/*      */ 
/*      */     
/*  699 */     int i = 0;
/*  700 */     IntArray intArray = new IntArray(WaveTemplates.WAVE_TEMPLATES.length);
/*      */     
/*  702 */     Array array = new Array(); WaveTemplates.WaveTemplate[] arrayOfWaveTemplate; int j, k;
/*  703 */     for (j = (arrayOfWaveTemplate = WaveTemplates.WAVE_TEMPLATES).length, k = 0; k < j; ) { WaveTemplates.WaveTemplate waveTemplate1 = arrayOfWaveTemplate[k];
/*  704 */       boolean bool = true; WaveTemplates.EnemyGroupConfig[] arrayOfEnemyGroupConfig; int m; byte b;
/*  705 */       for (m = (arrayOfEnemyGroupConfig = waveTemplate1.getEnemyGroupConfigs()).length, b = 0; b < m; ) { WaveTemplates.EnemyGroupConfig enemyGroupConfig = arrayOfEnemyGroupConfig[b];
/*  706 */         if (!paramObjectSet.contains(enemyGroupConfig.getEnemyType())) {
/*  707 */           bool = false; break;
/*      */         } 
/*      */         b++; }
/*      */       
/*  711 */       if (bool) {
/*  712 */         int n = waveTemplate1.getProbability(paramInt1, paramInt2, f2);
/*  713 */         intArray.add(n);
/*  714 */         i += n;
/*  715 */         if (n >= 100) {
/*  716 */           array.add(waveTemplate1);
/*      */         }
/*      */       } else {
/*  719 */         intArray.add(0);
/*      */       } 
/*      */       
/*      */       k++; }
/*      */     
/*  724 */     arrayOfWaveTemplate = null;
/*  725 */     j = -1;
/*  726 */     k = (int)(f1 * i);
/*  727 */     if (array.size != 0) {
/*      */       
/*  729 */       byte b = 0;
/*  730 */       for (Array.ArrayIterator<WaveTemplates.WaveTemplate> arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { WaveTemplates.WaveTemplate waveTemplate1 = arrayIterator.next();
/*  731 */         if (arrayOfWaveTemplate == null) {
/*  732 */           waveTemplate = waveTemplate1;
/*  733 */           j = b;
/*      */         } else {
/*  735 */           int m = intArray.items[b];
/*  736 */           int n = intArray.items[j];
/*  737 */           if (m > n) {
/*  738 */             waveTemplate = waveTemplate1;
/*  739 */             j = b;
/*      */           } 
/*      */         } 
/*  742 */         b++; }
/*      */     
/*      */     } else {
/*      */       
/*  746 */       int m = k;
/*  747 */       byte b1 = 0; WaveTemplates.WaveTemplate[] arrayOfWaveTemplate1; int n; byte b2;
/*  748 */       for (n = (arrayOfWaveTemplate1 = WaveTemplates.WAVE_TEMPLATES).length, b2 = 0; b2 < n; ) { WaveTemplates.WaveTemplate waveTemplate1 = arrayOfWaveTemplate1[b2];
/*      */         
/*  750 */         if ((m = m - intArray.items[b1]) < 0) {
/*  751 */           waveTemplate = waveTemplate1;
/*      */           break;
/*      */         } 
/*  754 */         b1++;
/*      */         b2++; }
/*      */     
/*      */     } 
/*  758 */     if (waveTemplate == null) {
/*  759 */       return null;
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
/*  778 */     return generateWave(waveTemplate, paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   @IgnoreMethodOverloadLuaDefWarning
/*      */   public final Wave generateWave(WaveTemplates.WaveTemplate paramWaveTemplate, int paramInt1, int paramInt2) {
/*  783 */     this.S.syncLog("WaveSystem generateWave C", new Object[] { paramWaveTemplate, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
/*  784 */     float f = getWaveValue(paramInt1, paramInt2);
/*  785 */     Array array = new Array(); WaveTemplates.EnemyGroupConfig[] arrayOfEnemyGroupConfig; int i; byte b;
/*  786 */     for (i = (arrayOfEnemyGroupConfig = paramWaveTemplate.getEnemyGroupConfigs()).length, b = 0; b < i; b++) {
/*  787 */       WaveTemplates.EnemyGroupConfig enemyGroupConfig; EnemyType enemyType = (enemyGroupConfig = arrayOfEnemyGroupConfig[b]).getEnemyType();
/*  788 */       float f1 = enemyGroupConfig.getDelay(paramInt1, paramInt2, f);
/*  789 */       float f2 = enemyGroupConfig.getInterval(paramInt1, paramInt2, f);
/*  790 */       int k = enemyGroupConfig.getCount(paramInt1, paramInt2, f);
/*  791 */       float f3 = enemyGroupConfig.getHealth(paramInt1, paramInt2, f);
/*  792 */       float f4 = enemyGroupConfig.getSpeed(paramInt1, paramInt2, f);
/*  793 */       float f5 = enemyGroupConfig.getBounty(paramInt1, paramInt2, f);
/*  794 */       float f6 = enemyGroupConfig.getKillExp(paramInt1, paramInt2, f);
/*  795 */       int j = enemyGroupConfig.getKillScore(paramInt1, paramInt2, f);
/*  796 */       array.add(new EnemyGroup(enemyType, f4, f3, k, f1, f2, f5, f6, j));
/*      */     } 
/*      */     
/*      */     Wave wave;
/*  800 */     (wave = new Wave(paramInt1, paramInt2, array)).waveMessage = paramWaveTemplate.getWaveMessage();
/*      */     
/*  802 */     return wave;
/*      */   }
/*      */   
/*      */   public final WavesTimelineOverlay.WavesConfiguration generateWavesTimelineConfigurationBasicLevel(BasicLevel paramBasicLevel, Map paramMap, int paramInt) {
/*  806 */     if (paramInt <= 0) paramInt = 1; 
/*  807 */     if (paramInt > 10000) paramInt = 10000;
/*      */     
/*      */     WavesTimelineOverlay.WavesConfiguration wavesConfiguration;
/*  810 */     (wavesConfiguration = new WavesTimelineOverlay.WavesConfiguration()).startWave = paramInt;
/*      */ 
/*      */     
/*  813 */     Array array = paramMap.getTilesByType(SpawnTile.class);
/*  814 */     for (byte b = 0; b < array.size; b++) {
/*  815 */       Array array1 = ((SpawnTile[])array.items)[b].getAllowedEnemies();
/*  816 */       for (byte b1 = 0; b1 < array1.size; b1++) {
/*  817 */         SpawnTile.AllowedEnemyConfig allowedEnemyConfig = ((SpawnTile.AllowedEnemyConfig[])array1.items)[b1];
/*  818 */         boolean bool = false;
/*  819 */         for (byte b2 = 0; b2 < wavesConfiguration.enemyConfigs.size; b2++) {
/*      */           SpawnTile.AllowedEnemyConfig allowedEnemyConfig1;
/*  821 */           if ((allowedEnemyConfig1 = ((SpawnTile.AllowedEnemyConfig[])wavesConfiguration.enemyConfigs.items)[b2]).enemyType == allowedEnemyConfig.enemyType) {
/*  822 */             bool = true;
/*  823 */             if (allowedEnemyConfig.firstWave < allowedEnemyConfig1.firstWave) {
/*  824 */               allowedEnemyConfig1.firstWave = allowedEnemyConfig.firstWave;
/*      */             }
/*  826 */             if (allowedEnemyConfig1.lastWave > 0)
/*      */             {
/*  828 */               if (allowedEnemyConfig.lastWave > allowedEnemyConfig1.lastWave || allowedEnemyConfig.lastWave <= 0)
/*      */               {
/*  830 */                 allowedEnemyConfig1.lastWave = allowedEnemyConfig.lastWave;
/*      */               }
/*      */             }
/*      */             break;
/*      */           } 
/*      */         } 
/*  836 */         if (!bool) {
/*  837 */           wavesConfiguration.enemyConfigs.add(new SpawnTile.AllowedEnemyConfig(allowedEnemyConfig.enemyType, allowedEnemyConfig.firstWave, allowedEnemyConfig.lastWave));
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  843 */     Mode mode = (paramBasicLevel.enemyWaves == null) ? Mode.ENDLESS : Mode.PREDEFINED;
/*  844 */     int i = paramMap.getAverageDifficulty();
/*  845 */     wavesConfiguration.enemyGroupsByWave.add(new Array());
/*      */     
/*  847 */     WaveDifficultyProvider waveDifficultyProvider = new WaveDifficultyProvider(paramBasicLevel.seed, i, paramBasicLevel.getDifficultyExpectedPlaytime());
/*      */     
/*  849 */     for (int j = paramInt; j < paramInt + 100; j++) {
/*      */       Array<EnemyGroup> array1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  860 */       if ((array1 = generateEnemyGroups(j, mode, waveDifficultyProvider, i, paramMap.getBossWaves(), paramMap, paramBasicLevel.seed, paramBasicLevel.enemyWaves)) != null) {
/*  861 */         wavesConfiguration.enemyGroupsByWave.add(array1);
/*      */       }
/*      */     } 
/*      */     
/*  865 */     return wavesConfiguration;
/*      */   }
/*      */   
/*      */   public final WavesTimelineOverlay.WavesConfiguration generateWavesTimelineConfigurationUserMap(UserMap paramUserMap, Map paramMap, int paramInt, WaveBossSupplier paramWaveBossSupplier) {
/*  869 */     if (paramInt <= 0) paramInt = 1; 
/*  870 */     if (paramInt > 10000) paramInt = 10000;
/*      */     
/*      */     WavesTimelineOverlay.WavesConfiguration wavesConfiguration;
/*  873 */     (wavesConfiguration = new WavesTimelineOverlay.WavesConfiguration()).startWave = paramInt;
/*      */ 
/*      */     
/*  876 */     Array array = paramMap.getTilesByType(SpawnTile.class);
/*  877 */     for (byte b = 0; b < array.size; b++) {
/*  878 */       Array array1 = ((SpawnTile[])array.items)[b].getAllowedEnemies();
/*  879 */       for (byte b1 = 0; b1 < array1.size; b1++) {
/*  880 */         SpawnTile.AllowedEnemyConfig allowedEnemyConfig = ((SpawnTile.AllowedEnemyConfig[])array1.items)[b1];
/*  881 */         boolean bool = false;
/*  882 */         for (byte b2 = 0; b2 < wavesConfiguration.enemyConfigs.size; b2++) {
/*      */           SpawnTile.AllowedEnemyConfig allowedEnemyConfig1;
/*  884 */           if ((allowedEnemyConfig1 = ((SpawnTile.AllowedEnemyConfig[])wavesConfiguration.enemyConfigs.items)[b2]).enemyType == allowedEnemyConfig.enemyType) {
/*  885 */             bool = true;
/*  886 */             if (allowedEnemyConfig.firstWave < allowedEnemyConfig1.firstWave) {
/*  887 */               allowedEnemyConfig1.firstWave = allowedEnemyConfig.firstWave;
/*      */             }
/*  889 */             if (allowedEnemyConfig1.lastWave > 0)
/*      */             {
/*  891 */               if (allowedEnemyConfig.lastWave > allowedEnemyConfig1.lastWave || allowedEnemyConfig.lastWave <= 0)
/*      */               {
/*  893 */                 allowedEnemyConfig1.lastWave = allowedEnemyConfig.lastWave;
/*      */               }
/*      */             }
/*      */             break;
/*      */           } 
/*      */         } 
/*  899 */         if (!bool) {
/*  900 */           wavesConfiguration.enemyConfigs.add(new SpawnTile.AllowedEnemyConfig(allowedEnemyConfig.enemyType, allowedEnemyConfig.firstWave, allowedEnemyConfig.lastWave));
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  906 */     Mode mode = Mode.ENDLESS;
/*  907 */     int i = paramMap.getAverageDifficulty();
/*  908 */     wavesConfiguration.enemyGroupsByWave.add(new Array());
/*  909 */     int j = paramMap.generateSeed();
/*  910 */     WaveDifficultyProvider waveDifficultyProvider = new WaveDifficultyProvider(j, i, paramMap.getDifficultyExpectedPlaytime());
/*      */     
/*  912 */     for (int k = paramInt; k < paramInt + 100; k++) {
/*      */       Array<EnemyGroup> array1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  922 */       if ((array1 = generateEnemyGroups(k, mode, waveDifficultyProvider, i, paramWaveBossSupplier, paramMap, j, null)) != null) {
/*  923 */         wavesConfiguration.enemyGroupsByWave.add(array1);
/*      */       }
/*      */     } 
/*      */     
/*  927 */     return wavesConfiguration;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b() {
/*  935 */     this.S.syncLog("WaveSystem updateNextWavesCache", new Object[0]);
/*      */     
/*  937 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  939 */     boolean bool = false;
/*  940 */     for (byte b = 0; b < 10; b++) {
/*  941 */       int i; WaveCache waveCache1 = this.nextWavesCache[b];
/*      */       
/*  943 */       if (this.wave != null) {
/*      */         
/*  945 */         i = this.wave.waveNumber + b + 1;
/*      */       } else {
/*      */         
/*  948 */         i = b + 1;
/*      */       } 
/*      */       
/*      */       WaveCache waveCache2;
/*  952 */       if ((waveCache2 = (WaveCache)this.p.get(i)) != null)
/*      */       
/*  954 */       { if (this.nextWavesCache[b] != waveCache2) {
/*  955 */           this.nextWavesCache[b] = waveCache2;
/*      */         } else {
/*      */           
/*      */           continue;
/*      */         }  }
/*  960 */       else if (this.mode == Mode.PREDEFINED && i > this.predefinedWaveTemplates.length)
/*      */       
/*  962 */       { if (this.nextWavesCache[b] == null || (this.nextWavesCache[b]).waveNumber != i || (this.nextWavesCache[b]).wave != null) {
/*  963 */           this.nextWavesCache[b] = new WaveCache();
/*  964 */           (this.nextWavesCache[b]).waveNumber = i;
/*      */         } else {
/*      */           
/*      */           continue;
/*      */         }  }
/*  969 */       else if (waveCache1 == null || waveCache1.waveNumber != i)
/*      */       
/*  971 */       { if (b != 9)
/*      */         
/*  973 */         { WaveCache waveCache = null;
/*  974 */           for (int j = b + 1; j < this.nextWavesCache.length; j++) {
/*      */             
/*  976 */             if ((waveCache2 = this.nextWavesCache[j]) != null && waveCache2.waveNumber == i) {
/*  977 */               waveCache = waveCache2;
/*      */               break;
/*      */             } 
/*      */           } 
/*  981 */           if (waveCache != null) {
/*      */             
/*  983 */             this.nextWavesCache[b] = waveCache;
/*      */           } else {
/*      */             
/*  986 */             this.nextWavesCache[b] = a(i);
/*      */           }  }
/*      */         else
/*      */         
/*  990 */         { this.nextWavesCache[b] = a(i); }  }
/*      */       else { continue; }
/*  992 */        bool = true;
/*      */ 
/*      */       
/*      */       continue;
/*      */     } 
/*      */     
/*  998 */     if (bool) {
/*  999 */       c();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void c() {
/* 1007 */     if (this.S.map.getMap() != null) {
/*      */       
/* 1009 */       int i = 0;
/* 1010 */       if (this.wave != null) {
/* 1011 */         i = this.wave.waveNumber;
/*      */       }
/*      */       
/* 1014 */       Array array = this.S.map.getMap().getTilesByType(SpawnTile.class);
/* 1015 */       for (byte b = 0; b <= 10; b++) {
/* 1016 */         for (Array.ArrayIterator<SpawnTile> arrayIterator = array.iterator(); arrayIterator.hasNext();) {
/* 1017 */           ((Array)(spawnTile = arrayIterator.next()).enemySpawnQueues.get(b)).clear();
/*      */         }
/* 1019 */         if (i + b != 0) {
/*      */           Wave wave;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           WaveCache waveCache;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1031 */           if ((wave = (Wave)((b == 0) ? this.wave : (((waveCache = this.nextWavesCache[b - 1]) == null) ? null : waveCache.wave))) != null) {
/* 1032 */             for (Array.ArrayIterator<EnemyGroup> arrayIterator1 = wave.enemyGroups.iterator(); arrayIterator1.hasNext(); ) {
/* 1033 */               EnemyGroup enemyGroup; EnemyType enemyType = EnemyType.getMainEnemyType((enemyGroup = arrayIterator1.next()).getEnemyType());
/*      */               
/* 1035 */               this.r.clear();
/* 1036 */               if (wave.enemiesCanBeSplitBetweenSpawns) {
/*      */                 
/* 1038 */                 for (Array.ArrayIterator<SpawnTile> arrayIterator2 = array.iterator(); arrayIterator2.hasNext();) {
/*      */ 
/*      */ 
/*      */                   
/* 1042 */                   if ((spawnTile = arrayIterator2.next()).isEnemyAllowedOnWave(enemyType, wave.waveNumber)) {
/* 1043 */                     this.r.add(spawnTile);
/*      */                   }
/*      */                 } 
/*      */               } else {
/*      */                 
/* 1048 */                 for (Array.ArrayIterator<SpawnTile> arrayIterator2 = array.iterator(); arrayIterator2.hasNext();) {
/* 1049 */                   if ((spawnTile = arrayIterator2.next()).isEnemyAllowedOnWave(enemyType, wave.waveNumber)) {
/* 1050 */                     this.r.add(spawnTile);
/*      */                     
/*      */                     break;
/*      */                   } 
/*      */                 } 
/*      */               } 
/* 1056 */               if (this.r.size == 0) {
/*      */                 
/* 1058 */                 a.w("nowhere to spawn enemy group of type %s, wave %s", new Object[] { enemyGroup.getEnemyType().name(), Integer.valueOf(wave.waveNumber) });
/*      */                 continue;
/*      */               } 
/*      */               int j;
/* 1062 */               if ((j = enemyGroup.count / this.r.size) <= 0) j = 1;
/*      */               
/* 1064 */               int k = 0;
/* 1065 */               for (byte b1 = 0; b1 < this.r.size; ) {
/* 1066 */                 if (b1 == this.r.size - 1)
/*      */                 {
/* 1068 */                   j += enemyGroup.count % this.r.size;
/*      */                 }
/*      */ 
/*      */                 
/* 1072 */                 SpawnTile spawnTile = ((SpawnTile[])this.r.items)[b1];
/*      */                 EnemyGroup.SpawnEnemyGroup spawnEnemyGroup;
/* 1074 */                 (spawnEnemyGroup = enemyGroup.createSpawnPortion(j)).health *= spawnTile.difficulty * 0.01F;
/* 1075 */                 ((Array)spawnTile.enemySpawnQueues.get(b)).add(spawnEnemyGroup);
/*      */ 
/*      */                 
/* 1078 */                 if (j == 0 || (k = k + j) < enemyGroup.count) {
/*      */                   b1++;
/*      */                 }
/*      */               } 
/*      */ 
/*      */ 
/*      */               
/* 1085 */               if (k != enemyGroup.count) {
/* 1086 */                 a.e("placed " + k + "/" + enemyGroup.count + " enemies to spawns", new Object[0]);
/*      */               }
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1096 */       this.r.clear();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Wave d() {
/* 1104 */     if (this.status == null)
/*      */     {
/* 1106 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1110 */     b();
/*      */     
/* 1112 */     return (this.nextWavesCache[0]).wave;
/*      */   }
/*      */   
/*      */   public final boolean allWavesSpawned() {
/* 1116 */     return (this.status == Status.ENDED);
/*      */   }
/*      */   
/*      */   public final void startNextWave() {
/* 1120 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*      */     Wave wave;
/* 1123 */     if ((wave = d()) != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1131 */       this.wavesToNotifyAboutCompletion.add(wave);
/*      */ 
/*      */ 
/*      */       
/* 1135 */       this.wave = wave;
/*      */       
/* 1137 */       this.wave.started = true;
/* 1138 */       this.d = 0.0F;
/* 1139 */       setStatus(Status.SPAWNING);
/*      */       
/* 1141 */       if (this.wave.waveProcessor != null) {
/* 1142 */         this.c.add(this.wave.waveProcessor);
/*      */       }
/*      */ 
/*      */       
/* 1146 */       this.S.events.getListeners(WaveStart.class).trigger((Event)new WaveStart(this.wave));
/*      */ 
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 1154 */     throw new IllegalStateException("There's no next wave, current status is " + this.status.name());
/*      */   }
/*      */ 
/*      */   
/*      */   public final float getTimeToNextWave() {
/* 1159 */     return this.l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Array<Enemy> getEnemiesToSpawn(float paramFloat, Array<EnemyGroup.SpawnEnemyGroup> paramArray) {
/* 1167 */     Array<Enemy> array = new Array(true, 16, Enemy.class); byte b;
/*      */     int i;
/* 1169 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*      */       EnemyGroup.SpawnEnemyGroup spawnEnemyGroup;
/*      */       
/*      */       int j;
/* 1173 */       if ((j = (spawnEnemyGroup = ((EnemyGroup.SpawnEnemyGroup[])paramArray.items)[b]).getSpawnCountByTime(paramFloat)) > spawnEnemyGroup.getSpawnedCount()) {
/*      */         
/* 1175 */         for (byte b1 = 0; b1 < j - spawnEnemyGroup.getSpawnedCount(); b1++) {
/*      */           Enemy enemy;
/* 1177 */           (enemy = Game.i.enemyManager.getFactory(spawnEnemyGroup.getEnemyType()).obtain()).setMaxHealth(spawnEnemyGroup.health);
/* 1178 */           enemy.bounty = spawnEnemyGroup.bounty;
/* 1179 */           enemy.setKillExp(spawnEnemyGroup.killExp);
/* 1180 */           enemy.killScore = spawnEnemyGroup.killScore;
/* 1181 */           enemy.setSpeed(spawnEnemyGroup.speed);
/* 1182 */           enemy.setHealth(spawnEnemyGroup.health);
/* 1183 */           if (EnemyType.isBoss(enemy.type))
/*      */           {
/* 1185 */             enemy.ignorePathfinding = true;
/*      */           }
/*      */           
/* 1188 */           array.add(enemy);
/*      */         } 
/*      */         
/* 1191 */         spawnEnemyGroup.addSpawnedCount(j - spawnEnemyGroup.getSpawnedCount());
/*      */       } 
/*      */     } 
/*      */     
/* 1195 */     return array;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void stopSpawningCurrentWave(Wave paramWave, Tower paramTower, DamageType paramDamageType) {
/* 1203 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/* 1205 */     if (this.status == Status.SPAWNING && paramWave == this.wave) {
/*      */       
/* 1207 */       Array array = this.S.map.getMap().getTilesByType(SpawnTile.class);
/* 1208 */       for (byte b = 0; b < array.size; b++) {
/* 1209 */         SpawnTile spawnTile = (SpawnTile)array.get(b);
/* 1210 */         for (byte b1 = 0; b1 < ((Array)spawnTile.enemySpawnQueues.get(0)).size; b1++) {
/*      */           Array<Enemy> array1;
/*      */           
/* 1213 */           for (Array.ArrayIterator<Enemy> arrayIterator = (array1 = getEnemiesToSpawn(9001.0F, (Array<EnemyGroup.SpawnEnemyGroup>)spawnTile.enemySpawnQueues.get(0))).iterator(); arrayIterator.hasNext(); ) {
/* 1214 */             Enemy enemy; (enemy = arrayIterator.next()).spawnTile = spawnTile;
/* 1215 */             enemy.wave = this.wave;
/* 1216 */             if (this.wave.enemiesCanHaveRandomSideShifts && enemy.canHaveRandomSideShift()) {
/* 1217 */               this.S.enemy.registerWithRandomSideShift(enemy);
/*      */             } else {
/* 1219 */               this.S.enemy.registerWithSideShift(enemy, 5);
/*      */             } 
/* 1221 */             this.S.map.spawnEnemy(enemy);
/* 1222 */             enemy.graphPath.getPosition(enemy.passedTiles, enemy.sideShiftIndex, enemy.getPosition());
/*      */             
/* 1224 */             this.S.damage.queueEnemyKill(this.S.damage.obtainRecord().setup(enemy, 1.0F, paramDamageType).setTower(paramTower));
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setForceWaveDoubleBonus(boolean paramBoolean) {
/* 1234 */     this.i = paramBoolean;
/*      */   }
/*      */   
/*      */   public final boolean isForceWaveDoubleBonus() {
/* 1238 */     return this.i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public final Wave getWave(int paramInt) {
/* 1245 */     if (this.wave != null && this.wave.waveNumber == paramInt)
/* 1246 */       return this.wave;  WaveCache[] arrayOfWaveCache;
/*      */     int i;
/*      */     byte b2;
/* 1249 */     for (i = (arrayOfWaveCache = this.nextWavesCache).length, b2 = 0; b2 < i; ) {
/* 1250 */       WaveCache waveCache; if ((waveCache = arrayOfWaveCache[b2]).wave != null && waveCache.waveNumber == paramInt) {
/* 1251 */         return waveCache.wave;
/*      */       }
/*      */       b2++;
/*      */     } 
/* 1255 */     for (byte b1 = 0; b1 < this.wavesToNotifyAboutCompletion.size; b1++) {
/*      */       Wave wave;
/* 1257 */       if ((wave = (Wave)this.wavesToNotifyAboutCompletion.get(b1)).waveNumber == paramInt) {
/* 1258 */         return wave;
/*      */       }
/*      */     } 
/*      */     
/* 1262 */     return null;
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
/*      */   public final void update(float paramFloat) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: dup
/*      */     //   2: getfield d : F
/*      */     //   5: fload_1
/*      */     //   6: fadd
/*      */     //   7: putfield d : F
/*      */     //   10: aload_0
/*      */     //   11: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   14: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*      */     //   17: invokevirtual getCurrentUpdateActions : ()Lcom/prineside/tdi2/systems/StateSystem$ActionsArray;
/*      */     //   20: dup
/*      */     //   21: astore_2
/*      */     //   22: ifnull -> 203
/*      */     //   25: iconst_0
/*      */     //   26: istore_3
/*      */     //   27: iload_3
/*      */     //   28: aload_2
/*      */     //   29: getfield size : I
/*      */     //   32: if_icmpge -> 203
/*      */     //   35: aload_2
/*      */     //   36: getfield actions : [Lcom/prineside/tdi2/Action;
/*      */     //   39: iload_3
/*      */     //   40: aaload
/*      */     //   41: dup
/*      */     //   42: astore #4
/*      */     //   44: invokevirtual getType : ()Lcom/prineside/tdi2/enums/ActionType;
/*      */     //   47: getstatic com/prineside/tdi2/enums/ActionType.CW : Lcom/prineside/tdi2/enums/ActionType;
/*      */     //   50: if_acmpne -> 197
/*      */     //   53: aload_0
/*      */     //   54: invokespecial d : ()Lcom/prineside/tdi2/Wave;
/*      */     //   57: ifnull -> 197
/*      */     //   60: aload_0
/*      */     //   61: getfield h : Z
/*      */     //   64: ifeq -> 203
/*      */     //   67: aload_0
/*      */     //   68: getfield status : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   71: getstatic com/prineside/tdi2/systems/WaveSystem$Status.NOT_STARTED : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   74: if_acmpeq -> 81
/*      */     //   77: iconst_1
/*      */     //   78: goto -> 82
/*      */     //   81: iconst_0
/*      */     //   82: istore_2
/*      */     //   83: aload_0
/*      */     //   84: invokevirtual getTimeToNextWave : ()F
/*      */     //   87: fstore #5
/*      */     //   89: aload_0
/*      */     //   90: invokevirtual getForceWaveBonus : ()I
/*      */     //   93: istore #6
/*      */     //   95: aload_0
/*      */     //   96: getfield k : F
/*      */     //   99: ldc 50.0
/*      */     //   101: fmul
/*      */     //   102: f2i
/*      */     //   103: istore #7
/*      */     //   105: aload_0
/*      */     //   106: iconst_0
/*      */     //   107: putfield i : Z
/*      */     //   110: iload_2
/*      */     //   111: ifeq -> 162
/*      */     //   114: aload_0
/*      */     //   115: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   118: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*      */     //   121: iload #7
/*      */     //   123: i2l
/*      */     //   124: getstatic com/prineside/tdi2/enums/StatisticsType.SG_WCA : Lcom/prineside/tdi2/enums/StatisticsType;
/*      */     //   127: invokevirtual addScore : (JLcom/prineside/tdi2/enums/StatisticsType;)J
/*      */     //   130: pop2
/*      */     //   131: aload_0
/*      */     //   132: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   135: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*      */     //   138: iload #6
/*      */     //   140: i2f
/*      */     //   141: iconst_1
/*      */     //   142: invokevirtual addMoney : (FZ)I
/*      */     //   145: pop
/*      */     //   146: aload_0
/*      */     //   147: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   150: getfield statistics : Lcom/prineside/tdi2/systems/StatisticsSystem;
/*      */     //   153: getstatic com/prineside/tdi2/enums/StatisticsType.CG_WC : Lcom/prineside/tdi2/enums/StatisticsType;
/*      */     //   156: iload #6
/*      */     //   158: i2d
/*      */     //   159: invokevirtual addStatistic : (Lcom/prineside/tdi2/enums/StatisticsType;D)V
/*      */     //   162: aload_0
/*      */     //   163: invokevirtual startNextWave : ()V
/*      */     //   166: iload_2
/*      */     //   167: ifeq -> 194
/*      */     //   170: aload_0
/*      */     //   171: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   174: getfield events : Lcom/prineside/tdi2/events/EventDispatcher;
/*      */     //   177: new com/prineside/tdi2/events/game/NextWaveForce
/*      */     //   180: dup
/*      */     //   181: iload #6
/*      */     //   183: iload #7
/*      */     //   185: fload #5
/*      */     //   187: invokespecial <init> : (IIF)V
/*      */     //   190: invokevirtual trigger : (Lcom/prineside/tdi2/events/Event;)Lcom/prineside/tdi2/events/Event;
/*      */     //   193: pop
/*      */     //   194: goto -> 203
/*      */     //   197: iinc #3, 1
/*      */     //   200: goto -> 27
/*      */     //   203: aload_0
/*      */     //   204: getfield c : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   207: invokevirtual begin : ()V
/*      */     //   210: iconst_0
/*      */     //   211: istore_3
/*      */     //   212: iload_3
/*      */     //   213: aload_0
/*      */     //   214: getfield c : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   217: getfield size : I
/*      */     //   220: if_icmpge -> 276
/*      */     //   223: aload_0
/*      */     //   224: getfield c : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   227: getfield items : [Ljava/lang/Object;
/*      */     //   230: checkcast [Lcom/prineside/tdi2/WaveProcessor;
/*      */     //   233: iload_3
/*      */     //   234: aaload
/*      */     //   235: fload_1
/*      */     //   236: invokeinterface update : (F)V
/*      */     //   241: aload_0
/*      */     //   242: getfield c : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   245: getfield items : [Ljava/lang/Object;
/*      */     //   248: checkcast [Lcom/prineside/tdi2/WaveProcessor;
/*      */     //   251: iload_3
/*      */     //   252: aaload
/*      */     //   253: invokeinterface isDone : ()Z
/*      */     //   258: ifeq -> 270
/*      */     //   261: aload_0
/*      */     //   262: getfield c : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   265: iload_3
/*      */     //   266: invokevirtual removeIndex : (I)Ljava/lang/Object;
/*      */     //   269: pop
/*      */     //   270: iinc #3, 1
/*      */     //   273: goto -> 212
/*      */     //   276: aload_0
/*      */     //   277: getfield c : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   280: invokevirtual end : ()V
/*      */     //   283: aload_0
/*      */     //   284: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   287: getfield map : Lcom/prineside/tdi2/systems/MapSystem;
/*      */     //   290: invokevirtual getMap : ()Lcom/prineside/tdi2/Map;
/*      */     //   293: ldc com/prineside/tdi2/tiles/SpawnTile
/*      */     //   295: invokevirtual getTilesByType : (Ljava/lang/Class;)Lcom/badlogic/gdx/utils/Array;
/*      */     //   298: astore_3
/*      */     //   299: iconst_0
/*      */     //   300: istore #4
/*      */     //   302: iconst_0
/*      */     //   303: istore_2
/*      */     //   304: iload_2
/*      */     //   305: aload_3
/*      */     //   306: getfield size : I
/*      */     //   309: if_icmpge -> 395
/*      */     //   312: aload_3
/*      */     //   313: iload_2
/*      */     //   314: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   317: checkcast com/prineside/tdi2/tiles/SpawnTile
/*      */     //   320: astore #5
/*      */     //   322: iconst_0
/*      */     //   323: istore #6
/*      */     //   325: iload #6
/*      */     //   327: aload #5
/*      */     //   329: getfield enemySpawnQueues : Lcom/badlogic/gdx/utils/Array;
/*      */     //   332: iconst_0
/*      */     //   333: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   336: checkcast com/badlogic/gdx/utils/Array
/*      */     //   339: getfield size : I
/*      */     //   342: if_icmpge -> 389
/*      */     //   345: aload #5
/*      */     //   347: getfield enemySpawnQueues : Lcom/badlogic/gdx/utils/Array;
/*      */     //   350: iconst_0
/*      */     //   351: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   354: checkcast com/badlogic/gdx/utils/Array
/*      */     //   357: iload #6
/*      */     //   359: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   362: checkcast com/prineside/tdi2/EnemyGroup
/*      */     //   365: astore #7
/*      */     //   367: iload #4
/*      */     //   369: aload #7
/*      */     //   371: getfield count : I
/*      */     //   374: aload #7
/*      */     //   376: invokevirtual getSpawnedCount : ()I
/*      */     //   379: isub
/*      */     //   380: iadd
/*      */     //   381: istore #4
/*      */     //   383: iinc #6, 1
/*      */     //   386: goto -> 325
/*      */     //   389: iinc #2, 1
/*      */     //   392: goto -> 304
/*      */     //   395: aload_0
/*      */     //   396: getfield status : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   399: getstatic com/prineside/tdi2/systems/WaveSystem$Status.SPAWNING : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   402: if_acmpne -> 586
/*      */     //   405: iload #4
/*      */     //   407: ifne -> 437
/*      */     //   410: aload_0
/*      */     //   411: invokespecial d : ()Lcom/prineside/tdi2/Wave;
/*      */     //   414: ifnull -> 427
/*      */     //   417: aload_0
/*      */     //   418: getstatic com/prineside/tdi2/systems/WaveSystem$Status.SPAWNED : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   421: invokevirtual setStatus : (Lcom/prineside/tdi2/systems/WaveSystem$Status;)V
/*      */     //   424: goto -> 678
/*      */     //   427: aload_0
/*      */     //   428: getstatic com/prineside/tdi2/systems/WaveSystem$Status.ENDED : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   431: invokevirtual setStatus : (Lcom/prineside/tdi2/systems/WaveSystem$Status;)V
/*      */     //   434: goto -> 678
/*      */     //   437: iconst_0
/*      */     //   438: istore_2
/*      */     //   439: iload_2
/*      */     //   440: aload_3
/*      */     //   441: getfield size : I
/*      */     //   444: if_icmpge -> 583
/*      */     //   447: aload_3
/*      */     //   448: iload_2
/*      */     //   449: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   452: checkcast com/prineside/tdi2/tiles/SpawnTile
/*      */     //   455: astore #5
/*      */     //   457: iconst_0
/*      */     //   458: istore #6
/*      */     //   460: iload #6
/*      */     //   462: aload #5
/*      */     //   464: getfield enemySpawnQueues : Lcom/badlogic/gdx/utils/Array;
/*      */     //   467: iconst_0
/*      */     //   468: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   471: checkcast com/badlogic/gdx/utils/Array
/*      */     //   474: getfield size : I
/*      */     //   477: if_icmpge -> 577
/*      */     //   480: aload_0
/*      */     //   481: getfield d : F
/*      */     //   484: aload #5
/*      */     //   486: getfield enemySpawnQueues : Lcom/badlogic/gdx/utils/Array;
/*      */     //   489: iconst_0
/*      */     //   490: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   493: checkcast com/badlogic/gdx/utils/Array
/*      */     //   496: invokestatic getEnemiesToSpawn : (FLcom/badlogic/gdx/utils/Array;)Lcom/badlogic/gdx/utils/Array;
/*      */     //   499: dup
/*      */     //   500: astore #7
/*      */     //   502: invokevirtual iterator : ()Lcom/badlogic/gdx/utils/Array$ArrayIterator;
/*      */     //   505: astore_1
/*      */     //   506: aload_1
/*      */     //   507: invokeinterface hasNext : ()Z
/*      */     //   512: ifeq -> 571
/*      */     //   515: aload_1
/*      */     //   516: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   521: checkcast com/prineside/tdi2/Enemy
/*      */     //   524: astore #4
/*      */     //   526: aload_0
/*      */     //   527: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   530: getfield enemy : Lcom/prineside/tdi2/systems/EnemySystem;
/*      */     //   533: aload #4
/*      */     //   535: aload #5
/*      */     //   537: aload_0
/*      */     //   538: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   541: getfield enemiesCanHaveRandomSideShifts : Z
/*      */     //   544: ifeq -> 559
/*      */     //   547: aload #4
/*      */     //   549: invokevirtual canHaveRandomSideShift : ()Z
/*      */     //   552: ifeq -> 559
/*      */     //   555: iconst_m1
/*      */     //   556: goto -> 560
/*      */     //   559: iconst_5
/*      */     //   560: aload_0
/*      */     //   561: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   564: fconst_0
/*      */     //   565: invokevirtual addEnemy : (Lcom/prineside/tdi2/Enemy;Lcom/prineside/tdi2/tiles/SpawnTile;ILcom/prineside/tdi2/Wave;F)V
/*      */     //   568: goto -> 506
/*      */     //   571: iinc #6, 1
/*      */     //   574: goto -> 460
/*      */     //   577: iinc #2, 1
/*      */     //   580: goto -> 439
/*      */     //   583: goto -> 678
/*      */     //   586: aload_0
/*      */     //   587: getfield status : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   590: getstatic com/prineside/tdi2/systems/WaveSystem$Status.SPAWNED : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   593: if_acmpne -> 678
/*      */     //   596: aload_0
/*      */     //   597: getfield f : F
/*      */     //   600: fconst_0
/*      */     //   601: fcmpl
/*      */     //   602: ifne -> 618
/*      */     //   605: aload_0
/*      */     //   606: dup
/*      */     //   607: getfield e : F
/*      */     //   610: fload_1
/*      */     //   611: fadd
/*      */     //   612: putfield e : F
/*      */     //   615: goto -> 642
/*      */     //   618: aload_0
/*      */     //   619: dup
/*      */     //   620: getfield f : F
/*      */     //   623: fload_1
/*      */     //   624: fsub
/*      */     //   625: putfield f : F
/*      */     //   628: aload_0
/*      */     //   629: getfield f : F
/*      */     //   632: fconst_0
/*      */     //   633: fcmpg
/*      */     //   634: ifge -> 642
/*      */     //   637: aload_0
/*      */     //   638: fconst_0
/*      */     //   639: putfield f : F
/*      */     //   642: aload_0
/*      */     //   643: invokevirtual getTimeToNextWave : ()F
/*      */     //   646: fconst_0
/*      */     //   647: fcmpl
/*      */     //   648: ifne -> 678
/*      */     //   651: aload_0
/*      */     //   652: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   655: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*      */     //   658: getfield difficultyMode : Lcom/prineside/tdi2/enums/DifficultyMode;
/*      */     //   661: getstatic com/prineside/tdi2/enums/DifficultyMode.EASY : Lcom/prineside/tdi2/enums/DifficultyMode;
/*      */     //   664: if_acmpeq -> 678
/*      */     //   667: aload_0
/*      */     //   668: invokespecial d : ()Lcom/prineside/tdi2/Wave;
/*      */     //   671: ifnull -> 678
/*      */     //   674: aload_0
/*      */     //   675: invokevirtual startNextWave : ()V
/*      */     //   678: aload_0
/*      */     //   679: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   682: ifnull -> 1139
/*      */     //   685: aload_0
/*      */     //   686: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   689: getfield gameState : Lcom/prineside/tdi2/systems/GameStateSystem;
/*      */     //   692: invokevirtual getHealth : ()I
/*      */     //   695: ifle -> 1139
/*      */     //   698: aload_0
/*      */     //   699: getfield g : I
/*      */     //   702: aload_0
/*      */     //   703: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   706: getfield waveNumber : I
/*      */     //   709: if_icmpge -> 1139
/*      */     //   712: aload_0
/*      */     //   713: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   716: invokevirtual clear : ()V
/*      */     //   719: aload_0
/*      */     //   720: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   723: aload_0
/*      */     //   724: getfield wavesToNotifyAboutCompletion : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   727: invokevirtual addAll : (Lcom/badlogic/gdx/utils/Array;)V
/*      */     //   730: aload_0
/*      */     //   731: getfield status : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   734: getstatic com/prineside/tdi2/systems/WaveSystem$Status.SPAWNING : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   737: if_acmpne -> 811
/*      */     //   740: aload_0
/*      */     //   741: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   744: getfield waveNumber : I
/*      */     //   747: istore_2
/*      */     //   748: iconst_0
/*      */     //   749: istore #5
/*      */     //   751: iload #5
/*      */     //   753: aload_0
/*      */     //   754: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   757: getfield size : I
/*      */     //   760: if_icmpge -> 808
/*      */     //   763: aload_0
/*      */     //   764: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   767: getfield items : [Ljava/lang/Object;
/*      */     //   770: checkcast [Lcom/prineside/tdi2/Wave;
/*      */     //   773: iload #5
/*      */     //   775: aaload
/*      */     //   776: getfield waveNumber : I
/*      */     //   779: aload_0
/*      */     //   780: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   783: getfield waveNumber : I
/*      */     //   786: if_icmpne -> 802
/*      */     //   789: aload_0
/*      */     //   790: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   793: iload #5
/*      */     //   795: invokevirtual removeIndex : (I)Ljava/lang/Object;
/*      */     //   798: pop
/*      */     //   799: goto -> 821
/*      */     //   802: iinc #5, 1
/*      */     //   805: goto -> 751
/*      */     //   808: goto -> 821
/*      */     //   811: aload_0
/*      */     //   812: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   815: getfield waveNumber : I
/*      */     //   818: iconst_1
/*      */     //   819: iadd
/*      */     //   820: istore_2
/*      */     //   821: iconst_0
/*      */     //   822: istore #5
/*      */     //   824: iload #5
/*      */     //   826: aload_0
/*      */     //   827: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   830: getfield map : Lcom/prineside/tdi2/systems/MapSystem;
/*      */     //   833: getfield spawnedEnemies : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   836: getfield size : I
/*      */     //   839: if_icmpge -> 982
/*      */     //   842: aload_0
/*      */     //   843: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   846: getfield map : Lcom/prineside/tdi2/systems/MapSystem;
/*      */     //   849: getfield spawnedEnemies : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   852: getfield items : [Ljava/lang/Object;
/*      */     //   855: checkcast [Lcom/prineside/tdi2/Enemy$EnemyReference;
/*      */     //   858: iload #5
/*      */     //   860: aaload
/*      */     //   861: getfield enemy : Lcom/prineside/tdi2/Enemy;
/*      */     //   864: dup
/*      */     //   865: astore #6
/*      */     //   867: ifnull -> 976
/*      */     //   870: aload #6
/*      */     //   872: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   875: ifnull -> 976
/*      */     //   878: aload #6
/*      */     //   880: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   883: getfield waveNumber : I
/*      */     //   886: iload_2
/*      */     //   887: if_icmpge -> 899
/*      */     //   890: aload #6
/*      */     //   892: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   895: getfield waveNumber : I
/*      */     //   898: istore_2
/*      */     //   899: aload_0
/*      */     //   900: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   903: invokevirtual begin : ()V
/*      */     //   906: iconst_0
/*      */     //   907: istore #7
/*      */     //   909: iload #7
/*      */     //   911: aload_0
/*      */     //   912: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   915: getfield size : I
/*      */     //   918: if_icmpge -> 969
/*      */     //   921: aload_0
/*      */     //   922: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   925: getfield items : [Ljava/lang/Object;
/*      */     //   928: checkcast [Lcom/prineside/tdi2/Wave;
/*      */     //   931: iload #7
/*      */     //   933: aaload
/*      */     //   934: dup
/*      */     //   935: astore_1
/*      */     //   936: getfield waveNumber : I
/*      */     //   939: aload #6
/*      */     //   941: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   944: getfield waveNumber : I
/*      */     //   947: if_icmpne -> 963
/*      */     //   950: aload_0
/*      */     //   951: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   954: iload #7
/*      */     //   956: invokevirtual removeIndex : (I)Ljava/lang/Object;
/*      */     //   959: pop
/*      */     //   960: goto -> 969
/*      */     //   963: iinc #7, 1
/*      */     //   966: goto -> 909
/*      */     //   969: aload_0
/*      */     //   970: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   973: invokevirtual end : ()V
/*      */     //   976: iinc #5, 1
/*      */     //   979: goto -> 824
/*      */     //   982: iload_2
/*      */     //   983: iconst_1
/*      */     //   984: isub
/*      */     //   985: aload_0
/*      */     //   986: getfield g : I
/*      */     //   989: if_icmple -> 999
/*      */     //   992: aload_0
/*      */     //   993: iload_2
/*      */     //   994: iconst_1
/*      */     //   995: isub
/*      */     //   996: putfield g : I
/*      */     //   999: iconst_0
/*      */     //   1000: istore #5
/*      */     //   1002: iload #5
/*      */     //   1004: aload_0
/*      */     //   1005: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   1008: getfield size : I
/*      */     //   1011: if_icmpge -> 1132
/*      */     //   1014: aload_0
/*      */     //   1015: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   1018: getfield items : [Ljava/lang/Object;
/*      */     //   1021: checkcast [Lcom/prineside/tdi2/Wave;
/*      */     //   1024: iload #5
/*      */     //   1026: aaload
/*      */     //   1027: dup
/*      */     //   1028: astore #6
/*      */     //   1030: iconst_1
/*      */     //   1031: putfield completed : Z
/*      */     //   1034: aload_0
/*      */     //   1035: getfield wavesToNotifyAboutCompletion : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   1038: invokevirtual begin : ()V
/*      */     //   1041: iconst_0
/*      */     //   1042: istore #7
/*      */     //   1044: iload #7
/*      */     //   1046: aload_0
/*      */     //   1047: getfield wavesToNotifyAboutCompletion : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   1050: getfield size : I
/*      */     //   1053: if_icmpge -> 1099
/*      */     //   1056: aload_0
/*      */     //   1057: getfield wavesToNotifyAboutCompletion : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   1060: getfield items : [Ljava/lang/Object;
/*      */     //   1063: checkcast [Lcom/prineside/tdi2/Wave;
/*      */     //   1066: iload #7
/*      */     //   1068: aaload
/*      */     //   1069: getfield waveNumber : I
/*      */     //   1072: aload #6
/*      */     //   1074: getfield waveNumber : I
/*      */     //   1077: if_icmpne -> 1093
/*      */     //   1080: aload_0
/*      */     //   1081: getfield wavesToNotifyAboutCompletion : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   1084: iload #7
/*      */     //   1086: invokevirtual removeIndex : (I)Ljava/lang/Object;
/*      */     //   1089: pop
/*      */     //   1090: goto -> 1099
/*      */     //   1093: iinc #7, 1
/*      */     //   1096: goto -> 1044
/*      */     //   1099: aload_0
/*      */     //   1100: getfield wavesToNotifyAboutCompletion : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   1103: invokevirtual end : ()V
/*      */     //   1106: aload_0
/*      */     //   1107: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   1110: getfield events : Lcom/prineside/tdi2/events/EventDispatcher;
/*      */     //   1113: new com/prineside/tdi2/events/game/WaveComplete
/*      */     //   1116: dup
/*      */     //   1117: aload #6
/*      */     //   1119: invokespecial <init> : (Lcom/prineside/tdi2/Wave;)V
/*      */     //   1122: invokevirtual trigger : (Lcom/prineside/tdi2/events/Event;)Lcom/prineside/tdi2/events/Event;
/*      */     //   1125: pop
/*      */     //   1126: iinc #5, 1
/*      */     //   1129: goto -> 1002
/*      */     //   1132: aload_0
/*      */     //   1133: getfield s : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   1136: invokevirtual clear : ()V
/*      */     //   1139: aload_0
/*      */     //   1140: getfield h : Z
/*      */     //   1143: istore_2
/*      */     //   1144: aload_0
/*      */     //   1145: invokespecial d : ()Lcom/prineside/tdi2/Wave;
/*      */     //   1148: ifnull -> 1220
/*      */     //   1151: aload_0
/*      */     //   1152: getfield status : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   1155: getstatic com/prineside/tdi2/systems/WaveSystem$Status.NOT_STARTED : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   1158: if_acmpne -> 1169
/*      */     //   1161: aload_0
/*      */     //   1162: iconst_1
/*      */     //   1163: putfield h : Z
/*      */     //   1166: goto -> 1225
/*      */     //   1169: aload_0
/*      */     //   1170: getfield status : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   1173: getstatic com/prineside/tdi2/systems/WaveSystem$Status.SPAWNED : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   1176: if_acmpne -> 1220
/*      */     //   1179: aload_0
/*      */     //   1180: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   1183: ifnonnull -> 1196
/*      */     //   1186: new java/lang/IllegalStateException
/*      */     //   1189: dup
/*      */     //   1190: ldc 'wave object not set while status is SPAWNED'
/*      */     //   1192: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   1195: athrow
/*      */     //   1196: aload_0
/*      */     //   1197: invokevirtual getCompletedWavesCount : ()I
/*      */     //   1200: aload_0
/*      */     //   1201: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   1204: getfield waveNumber : I
/*      */     //   1207: iconst_5
/*      */     //   1208: isub
/*      */     //   1209: if_icmplt -> 1220
/*      */     //   1212: aload_0
/*      */     //   1213: iconst_1
/*      */     //   1214: putfield h : Z
/*      */     //   1217: goto -> 1225
/*      */     //   1220: aload_0
/*      */     //   1221: iconst_0
/*      */     //   1222: putfield h : Z
/*      */     //   1225: aload_0
/*      */     //   1226: invokespecial d : ()Lcom/prineside/tdi2/Wave;
/*      */     //   1229: ifnull -> 1307
/*      */     //   1232: aload_0
/*      */     //   1233: getfield status : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   1236: getstatic com/prineside/tdi2/systems/WaveSystem$Status.SPAWNED : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   1239: if_acmpne -> 1307
/*      */     //   1242: aload_0
/*      */     //   1243: invokevirtual getWaveStartInterval : ()F
/*      */     //   1246: fstore #5
/*      */     //   1248: aload_0
/*      */     //   1249: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   1252: getfield waveProcessor : Lcom/prineside/tdi2/WaveProcessor;
/*      */     //   1255: ifnull -> 1275
/*      */     //   1258: fload #5
/*      */     //   1260: aload_0
/*      */     //   1261: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   1264: getfield waveProcessor : Lcom/prineside/tdi2/WaveProcessor;
/*      */     //   1267: invokeinterface getNextWaveDelayMultiplier : ()F
/*      */     //   1272: fmul
/*      */     //   1273: fstore #5
/*      */     //   1275: fload #5
/*      */     //   1277: aload_0
/*      */     //   1278: getfield e : F
/*      */     //   1281: fsub
/*      */     //   1282: dup
/*      */     //   1283: fstore #6
/*      */     //   1285: fconst_0
/*      */     //   1286: fcmpg
/*      */     //   1287: ifge -> 1298
/*      */     //   1290: aload_0
/*      */     //   1291: fconst_0
/*      */     //   1292: putfield l : F
/*      */     //   1295: goto -> 1312
/*      */     //   1298: aload_0
/*      */     //   1299: fload #6
/*      */     //   1301: putfield l : F
/*      */     //   1304: goto -> 1312
/*      */     //   1307: aload_0
/*      */     //   1308: fconst_0
/*      */     //   1309: putfield l : F
/*      */     //   1312: aload_0
/*      */     //   1313: getfield status : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   1316: getstatic com/prineside/tdi2/systems/WaveSystem$Status.SPAWNED : Lcom/prineside/tdi2/systems/WaveSystem$Status;
/*      */     //   1319: if_acmpne -> 1423
/*      */     //   1322: aload_0
/*      */     //   1323: getfield h : Z
/*      */     //   1326: ifeq -> 1415
/*      */     //   1329: aload_0
/*      */     //   1330: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   1333: getfield gameValue : Lcom/prineside/tdi2/systems/GameValueSystem;
/*      */     //   1336: getstatic com/prineside/tdi2/enums/GameValueType.FORCED_WAVE_BONUS : Lcom/prineside/tdi2/enums/GameValueType;
/*      */     //   1339: invokevirtual getPercentValueAsMultiplier : (Lcom/prineside/tdi2/enums/GameValueType;)D
/*      */     //   1342: d2f
/*      */     //   1343: fstore #5
/*      */     //   1345: aload_0
/*      */     //   1346: dup
/*      */     //   1347: getfield l : F
/*      */     //   1350: aload_0
/*      */     //   1351: invokevirtual getWaveStartInterval : ()F
/*      */     //   1354: fdiv
/*      */     //   1355: aload_0
/*      */     //   1356: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   1359: getfield killedEnemiesBountySum : I
/*      */     //   1362: i2f
/*      */     //   1363: ldc 0.8
/*      */     //   1365: fmul
/*      */     //   1366: aload_0
/*      */     //   1367: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   1370: getfield enemiesSumBounty : F
/*      */     //   1373: ldc 0.2
/*      */     //   1375: fmul
/*      */     //   1376: fadd
/*      */     //   1377: fmul
/*      */     //   1378: fload #5
/*      */     //   1380: fmul
/*      */     //   1381: putfield k : F
/*      */     //   1384: aload_0
/*      */     //   1385: getfield k : F
/*      */     //   1388: invokestatic isNaN : (F)Z
/*      */     //   1391: ifeq -> 1399
/*      */     //   1394: aload_0
/*      */     //   1395: fconst_0
/*      */     //   1396: putfield k : F
/*      */     //   1399: aload_0
/*      */     //   1400: dup
/*      */     //   1401: getfield k : F
/*      */     //   1404: f2d
/*      */     //   1405: invokestatic ceil : (D)D
/*      */     //   1408: d2i
/*      */     //   1409: putfield j : I
/*      */     //   1412: goto -> 1428
/*      */     //   1415: aload_0
/*      */     //   1416: iconst_0
/*      */     //   1417: putfield j : I
/*      */     //   1420: goto -> 1428
/*      */     //   1423: aload_0
/*      */     //   1424: iconst_0
/*      */     //   1425: putfield j : I
/*      */     //   1428: aload_0
/*      */     //   1429: getfield h : Z
/*      */     //   1432: ifeq -> 1551
/*      */     //   1435: aload_0
/*      */     //   1436: invokevirtual isAutoForceWaveEnabled : ()Z
/*      */     //   1439: ifeq -> 1551
/*      */     //   1442: aload_0
/*      */     //   1443: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   1446: ifnull -> 1551
/*      */     //   1449: aload_0
/*      */     //   1450: getfield wave : Lcom/prineside/tdi2/Wave;
/*      */     //   1453: getfield killedEnemiesCount : I
/*      */     //   1456: ifle -> 1551
/*      */     //   1459: iconst_0
/*      */     //   1460: istore #5
/*      */     //   1462: iconst_0
/*      */     //   1463: istore #6
/*      */     //   1465: iload #6
/*      */     //   1467: aload_0
/*      */     //   1468: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   1471: getfield map : Lcom/prineside/tdi2/systems/MapSystem;
/*      */     //   1474: getfield spawnedEnemies : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   1477: getfield size : I
/*      */     //   1480: if_icmpge -> 1542
/*      */     //   1483: aload_0
/*      */     //   1484: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   1487: getfield map : Lcom/prineside/tdi2/systems/MapSystem;
/*      */     //   1490: getfield spawnedEnemies : Lcom/badlogic/gdx/utils/DelayedRemovalArray;
/*      */     //   1493: getfield items : [Ljava/lang/Object;
/*      */     //   1496: checkcast [Lcom/prineside/tdi2/Enemy$EnemyReference;
/*      */     //   1499: iload #6
/*      */     //   1501: aaload
/*      */     //   1502: getfield enemy : Lcom/prineside/tdi2/Enemy;
/*      */     //   1505: dup
/*      */     //   1506: astore #7
/*      */     //   1508: ifnull -> 1536
/*      */     //   1511: aload #7
/*      */     //   1513: getfield type : Lcom/prineside/tdi2/enums/EnemyType;
/*      */     //   1516: getstatic com/prineside/tdi2/enums/EnemyType.GENERIC : Lcom/prineside/tdi2/enums/EnemyType;
/*      */     //   1519: if_acmpeq -> 1536
/*      */     //   1522: aload #7
/*      */     //   1524: getfield ignoredByAutoWaveCall : Z
/*      */     //   1527: ifne -> 1536
/*      */     //   1530: iconst_1
/*      */     //   1531: istore #5
/*      */     //   1533: goto -> 1542
/*      */     //   1536: iinc #6, 1
/*      */     //   1539: goto -> 1465
/*      */     //   1542: iload #5
/*      */     //   1544: ifne -> 1551
/*      */     //   1547: aload_0
/*      */     //   1548: invokevirtual forceNextWaveAction : ()V
/*      */     //   1551: aload_0
/*      */     //   1552: getfield h : Z
/*      */     //   1555: iload_2
/*      */     //   1556: if_icmpeq -> 1602
/*      */     //   1559: aload_0
/*      */     //   1560: invokevirtual isAutoForceWaveEnabled : ()Z
/*      */     //   1563: ifeq -> 1584
/*      */     //   1566: aload_0
/*      */     //   1567: getfield h : Z
/*      */     //   1570: ifeq -> 1584
/*      */     //   1573: aload_0
/*      */     //   1574: getfield instantWaveCallsEnabled : Z
/*      */     //   1577: ifeq -> 1584
/*      */     //   1580: aload_0
/*      */     //   1581: invokevirtual forceNextWaveAction : ()V
/*      */     //   1584: aload_0
/*      */     //   1585: getfield S : Lcom/prineside/tdi2/GameSystemProvider;
/*      */     //   1588: getfield events : Lcom/prineside/tdi2/events/EventDispatcher;
/*      */     //   1591: new com/prineside/tdi2/events/game/ForceWaveAvailabilityChange
/*      */     //   1594: dup
/*      */     //   1595: invokespecial <init> : ()V
/*      */     //   1598: invokevirtual trigger : (Lcom/prineside/tdi2/events/Event;)Lcom/prineside/tdi2/events/Event;
/*      */     //   1601: pop
/*      */     //   1602: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1267	-> 0
/*      */     //   #1270	-> 10
/*      */     //   #1271	-> 21
/*      */     //   #1272	-> 25
/*      */     //   #1273	-> 35
/*      */     //   #1274	-> 42
/*      */     //   #1276	-> 53
/*      */     //   #1278	-> 60
/*      */     //   #1279	-> 67
/*      */     //   #1280	-> 83
/*      */     //   #1281	-> 89
/*      */     //   #1282	-> 95
/*      */     //   #1284	-> 105
/*      */     //   #1286	-> 110
/*      */     //   #1288	-> 114
/*      */     //   #1289	-> 131
/*      */     //   #1290	-> 146
/*      */     //   #1293	-> 162
/*      */     //   #1295	-> 166
/*      */     //   #1296	-> 170
/*      */     //   #1298	-> 194
/*      */     //   #1272	-> 197
/*      */     //   #1304	-> 203
/*      */     //   #1305	-> 210
/*      */     //   #1306	-> 223
/*      */     //   #1307	-> 241
/*      */     //   #1308	-> 261
/*      */     //   #1305	-> 270
/*      */     //   #1311	-> 276
/*      */     //   #1314	-> 283
/*      */     //   #1315	-> 299
/*      */     //   #1316	-> 302
/*      */     //   #1317	-> 312
/*      */     //   #1318	-> 322
/*      */     //   #1319	-> 345
/*      */     //   #1320	-> 367
/*      */     //   #1318	-> 383
/*      */     //   #1316	-> 389
/*      */     //   #1324	-> 395
/*      */     //   #1325	-> 405
/*      */     //   #1327	-> 410
/*      */     //   #1329	-> 417
/*      */     //   #1332	-> 427
/*      */     //   #1336	-> 437
/*      */     //   #1337	-> 447
/*      */     //   #1338	-> 457
/*      */     //   #1339	-> 480
/*      */     //   #1341	-> 500
/*      */     //   #1342	-> 526
/*      */     //   #1343	-> 568
/*      */     //   #1338	-> 571
/*      */     //   #1336	-> 577
/*      */     //   #1347	-> 586
/*      */     //   #1349	-> 596
/*      */     //   #1362	-> 605
/*      */     //   #1363	-> 615
/*      */     //   #1364	-> 618
/*      */     //   #1365	-> 628
/*      */     //   #1366	-> 637
/*      */     //   #1370	-> 642
/*      */     //   #1372	-> 651
/*      */     //   #1373	-> 667
/*      */     //   #1379	-> 678
/*      */     //   #1380	-> 698
/*      */     //   #1382	-> 712
/*      */     //   #1383	-> 719
/*      */     //   #1386	-> 730
/*      */     //   #1388	-> 740
/*      */     //   #1391	-> 748
/*      */     //   #1392	-> 763
/*      */     //   #1393	-> 789
/*      */     //   #1394	-> 799
/*      */     //   #1391	-> 802
/*      */     //   #1399	-> 811
/*      */     //   #1402	-> 821
/*      */     //   #1403	-> 842
/*      */     //   #1404	-> 865
/*      */     //   #1406	-> 878
/*      */     //   #1407	-> 890
/*      */     //   #1411	-> 899
/*      */     //   #1412	-> 906
/*      */     //   #1413	-> 921
/*      */     //   #1414	-> 935
/*      */     //   #1415	-> 950
/*      */     //   #1416	-> 960
/*      */     //   #1412	-> 963
/*      */     //   #1419	-> 969
/*      */     //   #1402	-> 976
/*      */     //   #1423	-> 982
/*      */     //   #1424	-> 992
/*      */     //   #1427	-> 999
/*      */     //   #1429	-> 1014
/*      */     //   #1433	-> 1028
/*      */     //   #1436	-> 1034
/*      */     //   #1437	-> 1041
/*      */     //   #1438	-> 1056
/*      */     //   #1439	-> 1080
/*      */     //   #1440	-> 1090
/*      */     //   #1437	-> 1093
/*      */     //   #1443	-> 1099
/*      */     //   #1445	-> 1106
/*      */     //   #1427	-> 1126
/*      */     //   #1447	-> 1132
/*      */     //   #1487	-> 1139
/*      */     //   #1488	-> 1144
/*      */     //   #1491	-> 1151
/*      */     //   #1493	-> 1161
/*      */     //   #1494	-> 1169
/*      */     //   #1496	-> 1179
/*      */     //   #1497	-> 1186
/*      */     //   #1499	-> 1196
/*      */     //   #1503	-> 1212
/*      */     //   #1506	-> 1220
/*      */     //   #1511	-> 1225
/*      */     //   #1514	-> 1232
/*      */     //   #1515	-> 1242
/*      */     //   #1516	-> 1248
/*      */     //   #1518	-> 1258
/*      */     //   #1520	-> 1275
/*      */     //   #1521	-> 1283
/*      */     //   #1522	-> 1290
/*      */     //   #1524	-> 1298
/*      */     //   #1526	-> 1304
/*      */     //   #1527	-> 1307
/*      */     //   #1532	-> 1312
/*      */     //   #1534	-> 1322
/*      */     //   #1535	-> 1329
/*      */     //   #1538	-> 1345
/*      */     //   #1539	-> 1384
/*      */     //   #1540	-> 1394
/*      */     //   #1542	-> 1399
/*      */     //   #1543	-> 1412
/*      */     //   #1545	-> 1415
/*      */     //   #1548	-> 1423
/*      */     //   #1552	-> 1428
/*      */     //   #1555	-> 1459
/*      */     //   #1556	-> 1462
/*      */     //   #1557	-> 1483
/*      */     //   #1558	-> 1506
/*      */     //   #1559	-> 1530
/*      */     //   #1560	-> 1533
/*      */     //   #1556	-> 1536
/*      */     //   #1563	-> 1542
/*      */     //   #1565	-> 1551
/*      */     //   #1566	-> 1559
/*      */     //   #1567	-> 1573
/*      */     //   #1569	-> 1580
/*      */     //   #1573	-> 1584
/*      */     //   #1579	-> 1602
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
/*      */   public final String getSystemName() {
/* 1583 */     return "Wave";
/*      */   }
/*      */   
/*      */   public final boolean isAutoForceWaveEnabled() {
/* 1587 */     return this.autoForceWaveEnabled;
/*      */   }
/*      */   
/*      */   public final void setAutoForceWaveEnabled(boolean paramBoolean) {
/* 1591 */     if (!this.S.gameValue.getBooleanValue(GameValueType.AUTO_WAVE_CALL))
/*      */       return; 
/* 1593 */     if (this.autoForceWaveEnabled != paramBoolean) {
/*      */       
/* 1595 */       this.autoForceWaveEnabled = paramBoolean;
/*      */       
/* 1597 */       if (paramBoolean && this.h) {
/* 1598 */         forceNextWaveAction();
/*      */       }
/*      */     } 
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
/*      */   public final void dispose() {
/* 1613 */     this.b = null;
/* 1614 */     this.wave = null;
/* 1615 */     this.c.clear();
/* 1616 */     Arrays.fill((Object[])this.nextWavesCache, (Object)null);
/*      */     
/* 1618 */     this.predefinedWaveTemplates = null;
/*      */     
/* 1620 */     super.dispose();
/*      */   }
/*      */   
/*      */   @REGS(arrayLevels = 1)
/*      */   public static class WaveCache
/*      */     implements KryoSerializable {
/*      */     public Wave wave;
/*      */     public int waveNumber;
/*      */     
/*      */     public void write(Kryo param1Kryo, Output param1Output) {
/* 1630 */       param1Kryo.writeClassAndObject(param1Output, this.wave);
/* 1631 */       param1Output.writeVarInt(this.waveNumber, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public void read(Kryo param1Kryo, Input param1Input) {
/* 1636 */       this.wave = (Wave)param1Kryo.readClassAndObject(param1Input);
/* 1637 */       this.waveNumber = param1Input.readVarInt(true);
/*      */     }
/*      */     
/*      */     public WaveCache() {}
/*      */     
/*      */     public WaveCache(Wave param1Wave, int param1Int) {
/* 1643 */       this.wave = param1Wave;
/* 1644 */       this.waveNumber = param1Int;
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnEnemyDie extends SerializableListener<WaveSystem> implements Listener<EnemyDie> {
/*      */     private OnEnemyDie() {}
/*      */     
/*      */     public OnEnemyDie(WaveSystem param1WaveSystem) {
/* 1653 */       this.a = param1WaveSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*      */       Enemy enemy;
/*      */       DamageRecord damageRecord;
/* 1660 */       if ((enemy = (damageRecord = param1EnemyDie.getLastDamage()).getEnemy()).wave != null && !enemy.notAffectsWaveKillCounter.isTrue()) {
/* 1661 */         enemy.wave.killedEnemiesCount++;
/* 1662 */         enemy.wave.killedEnemiesBountySum = (int)(enemy.wave.killedEnemiesBountySum + enemy.bounty);
/*      */         
/* 1664 */         if (enemy.wave.killedEnemiesCount == enemy.wave.totalEnemiesCount && enemy.wave.waveNumber > 0) {
/*      */           
/* 1666 */           int i = 100 + enemy.wave.waveNumber * 10 + (int)(enemy.wave.killedEnemiesBountySum * 0.1F);
/* 1667 */           ((WaveSystem)this.a).S.gameState.addScore(i, StatisticsType.SG_WCL);
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnEnemyTakeDamage
/*      */     implements Listener<EnemyTakeDamage>, NoFieldKryoSerializable {
/*      */     public final void handleEvent(EnemyTakeDamage param1EnemyTakeDamage) {
/*      */       Enemy enemy;
/* 1678 */       if ((enemy = param1EnemyTakeDamage.getRecord().getEnemy()).wave != null)
/* 1679 */         enemy.wave.enemiesTookDamage += param1EnemyTakeDamage.getRecord().getFactDamage(); 
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnEnemyReachTarget
/*      */     implements KryoSerializable, Listener<EnemyReachTarget>
/*      */   {
/*      */     private WaveSystem a;
/*      */     
/*      */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 1690 */       param1Kryo.writeObject(param1Output, this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 1695 */       this.a = (WaveSystem)param1Kryo.readObject(param1Input, WaveSystem.class);
/*      */     }
/*      */     
/*      */     private OnEnemyReachTarget() {}
/*      */     
/*      */     public OnEnemyReachTarget(WaveSystem param1WaveSystem) {
/* 1701 */       this.a = param1WaveSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(EnemyReachTarget param1EnemyReachTarget) {
/*      */       Tile tile;
/* 1707 */       if (tile = param1EnemyReachTarget.getEnemy().getCurrentTile() instanceof com.prineside.tdi2.tiles.TargetTile) {
/* 1708 */         if ((param1EnemyReachTarget.getEnemy()).wave != null) {
/* 1709 */           (param1EnemyReachTarget.getEnemy()).wave.passedEnemiesCount++;
/*      */         }
/*      */         
/* 1712 */         if (this.a.isAutoForceWaveEnabled() && this.a.S.gameState.difficultyMode == DifficultyMode.EASY)
/*      */         {
/* 1714 */           this.a.setAutoForceWaveEnabled(false);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS(classOnly = true)
/*      */   public static interface WaveGenerator {
/*      */     Wave generate(int param1Int1, Wave param1Wave, GameSystemProvider param1GameSystemProvider, int param1Int2);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\WaveSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */