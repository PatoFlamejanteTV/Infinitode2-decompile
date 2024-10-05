/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.Sort;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Strings;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.EventDispatcher;
/*     */ import com.prineside.tdi2.events.game.SystemsDispose;
/*     */ import com.prineside.tdi2.events.game.SystemsPostSetup;
/*     */ import com.prineside.tdi2.events.game.SystemsSetup;
/*     */ import com.prineside.tdi2.events.game.SystemsStateRestore;
/*     */ import com.prineside.tdi2.systems.AbilitySystem;
/*     */ import com.prineside.tdi2.systems.AchievementSystem;
/*     */ import com.prineside.tdi2.systems.BonusSystem;
/*     */ import com.prineside.tdi2.systems.BuffSystem;
/*     */ import com.prineside.tdi2.systems.CachedRenderingSystem;
/*     */ import com.prineside.tdi2.systems.DamageSystem;
/*     */ import com.prineside.tdi2.systems.EnemySystem;
/*     */ import com.prineside.tdi2.systems.ExperienceSystem;
/*     */ import com.prineside.tdi2.systems.ExplosionSystem;
/*     */ import com.prineside.tdi2.systems.GameMapSelectionSystem;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.systems.GameUiSystem;
/*     */ import com.prineside.tdi2.systems.GameValueSystem;
/*     */ import com.prineside.tdi2.systems.GameplayModSystem;
/*     */ import com.prineside.tdi2.systems.HotKeySystem;
/*     */ import com.prineside.tdi2.systems.InputSystem;
/*     */ import com.prineside.tdi2.systems.InventorySystem;
/*     */ import com.prineside.tdi2.systems.LootSystem;
/*     */ import com.prineside.tdi2.systems.MapEditorSystem;
/*     */ import com.prineside.tdi2.systems.MapEditorUiSystem;
/*     */ import com.prineside.tdi2.systems.MapRenderingSystem;
/*     */ import com.prineside.tdi2.systems.MapSystem;
/*     */ import com.prineside.tdi2.systems.MinerSystem;
/*     */ import com.prineside.tdi2.systems.ModifierSystem;
/*     */ import com.prineside.tdi2.systems.ParticleSystem;
/*     */ import com.prineside.tdi2.systems.PathRenderingSystem;
/*     */ import com.prineside.tdi2.systems.PathfindingSystem;
/*     */ import com.prineside.tdi2.systems.ProjectileSystem;
/*     */ import com.prineside.tdi2.systems.ProjectileTrailSystem;
/*     */ import com.prineside.tdi2.systems.QuestSystem;
/*     */ import com.prineside.tdi2.systems.RenderSystem;
/*     */ import com.prineside.tdi2.systems.ScriptSystem;
/*     */ import com.prineside.tdi2.systems.SoundSystem;
/*     */ import com.prineside.tdi2.systems.StateSystem;
/*     */ import com.prineside.tdi2.systems.StatisticsSystem;
/*     */ import com.prineside.tdi2.systems.TowerSystem;
/*     */ import com.prineside.tdi2.systems.UnitSystem;
/*     */ import com.prineside.tdi2.systems.WaveSystem;
/*     */ import com.prineside.tdi2.utils.FloatSorter;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*     */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*     */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ 
/*     */ @REGS
/*     */ public final class GameSystemProvider
/*     */   implements KryoSerializable {
/*  70 */   private static final TLog a = TLog.forClass(GameSystemProvider.class);
/*     */   
/*  72 */   private static final Class[] b = new Class[] { SoundSystem.class, AchievementSystem.class, InputSystem.class, HotKeySystem.class, MapSystem.class, GameUiSystem.class, MapEditorUiSystem.class, GameValueSystem.class, GameStateSystem.class, BonusSystem.class, GameplayModSystem.class, QuestSystem.class, BuffSystem.class, LootSystem.class, PathfindingSystem.class, EnemySystem.class, UnitSystem.class, AbilitySystem.class, MapRenderingSystem.class, PathRenderingSystem.class, ProjectileSystem.class, ExplosionSystem.class, TowerSystem.class, DamageSystem.class, ExperienceSystem.class, MinerSystem.class, ModifierSystem.class, ProjectileTrailSystem.class, ParticleSystem.class, WaveSystem.class, StatisticsSystem.class, ScriptSystem.class, RenderSystem.class };
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
/*     */   @NAGS
/*     */   public boolean syncChecking = false;
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
/*     */   @NAGS
/* 109 */   public Array<String> syncCheckLog = new Array(true, 1, String.class); public SystemsConfig CFG;
/*     */   public final void syncLog(String paramString, Object... paramVarArgs) {
/* 111 */     if (this.syncChecking) {
/* 112 */       this.syncCheckLog.add(Strings.lenientFormat(paramString, paramVarArgs));
/*     */     }
/*     */   }
/*     */   
/*     */   public final void syncLogTrace() {
/* 117 */     if (this.syncChecking) {
/* 118 */       StringWriter stringWriter = new StringWriter();
/* 119 */       PrintWriter printWriter = new PrintWriter(stringWriter);
/* 120 */       (new Throwable()).printStackTrace(printWriter);
/* 121 */       this.syncCheckLog.add(stringWriter.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 126 */   private final Array<GameSystem> c = new Array(true, 1, GameSystem.class);
/*     */   
/*     */   @NAGS
/* 129 */   private final ObjectMap<Class<?>, GameSystem> d = new ObjectMap(); @NAGS
/* 130 */   private final long[] e = new long[64];
/*     */   
/*     */   @NAGS
/*     */   public SoundSystem _sound;
/*     */   
/*     */   @NAGS
/*     */   public CachedRenderingSystem _cachedRendering;
/*     */   
/*     */   @NAGS
/*     */   public GameMapSelectionSystem _gameMapSelection;
/*     */   @NAGS
/*     */   public AchievementSystem achievement;
/*     */   @NAGS
/*     */   public InputSystem _input;
/*     */   @NAGS
/*     */   public HotKeySystem _hotKey;
/*     */   @NAGS
/*     */   public GameUiSystem _gameUi;
/*     */   @NAGS
/*     */   public MapEditorUiSystem _mapEditorUi;
/*     */   @NAGS
/*     */   public RenderSystem _render;
/*     */   @NAGS
/*     */   public MapRenderingSystem _mapRendering;
/*     */   @NAGS
/*     */   public PathRenderingSystem _pathRendering;
/*     */   @NAGS
/*     */   public ProjectileTrailSystem _projectileTrail;
/*     */   @NAGS
/*     */   public InventorySystem _inventory;
/*     */   @NAGS
/*     */   public MapEditorSystem _mapEditor;
/*     */   @NAGS
/*     */   public ParticleSystem _particle;
/*     */   @NAGS
/*     */   public BonusSystem bonus;
/*     */   @NAGS
/*     */   public GameplayModSystem gameplayMod;
/*     */   @NAGS
/*     */   public GameValueSystem gameValue;
/*     */   @NAGS
/*     */   public StateSystem state;
/* 172 */   public EventDispatcher events = new EventDispatcher(); @NAGS public GameStateSystem gameState; @NAGS public QuestSystem _quest; @NAGS public BuffSystem buff; @NAGS public LootSystem loot; @NAGS public EnemySystem enemy; @NAGS public UnitSystem unit; @NAGS public AbilitySystem ability; @NAGS public MapSystem map; @NAGS public ProjectileSystem projectile; @NAGS public ExplosionSystem explosion; @NAGS public TowerSystem tower; @NAGS public ExperienceSystem experience; @NAGS public MinerSystem miner; @NAGS public ModifierSystem modifier; @NAGS public PathfindingSystem pathfinding; @NAGS public DamageSystem damage; @NAGS public WaveSystem wave; @NAGS public StatisticsSystem statistics; @NAGS
/*     */   public ScriptSystem script; @NAGS
/* 174 */   public final ThreadSafeSharedHelpers TSH = new ThreadSafeSharedHelpers();
/*     */   
/* 176 */   public static DeepClassComparator<GameSystemProvider> CLASS_COMPARATOR = new DeepClassComparator<GameSystemProvider>() {
/*     */       public Class<GameSystemProvider> forClass() {
/* 178 */         return GameSystemProvider.class;
/*     */       }
/*     */       
/*     */       public void compare(GameSystemProvider param1GameSystemProvider1, GameSystemProvider param1GameSystemProvider2, DeepClassComparisonConfig param1DeepClassComparisonConfig) {
/* 182 */         byte b1 = 0;
/* 183 */         byte b2 = 0; byte b3;
/* 184 */         for (b3 = 0; b3 < (GameSystemProvider.a(param1GameSystemProvider1)).size; b3++) {
/* 185 */           if (((GameSystem[])(GameSystemProvider.a(param1GameSystemProvider1)).items)[b3].affectsGameState()) {
/* 186 */             b1++;
/*     */           }
/*     */         } 
/* 189 */         for (b3 = 0; b3 < (GameSystemProvider.a(param1GameSystemProvider2)).size; b3++) {
/* 190 */           if (((GameSystem[])(GameSystemProvider.a(param1GameSystemProvider2)).items)[b3].affectsGameState()) {
/* 191 */             b2++;
/*     */           }
/*     */         } 
/* 194 */         if (b1 != b2) {
/* 195 */           param1DeepClassComparisonConfig.appendPrefix().append(": system count differ (").append(PMath.toString(b1)).append(", ").append(String.valueOf(b2)).append(")\n");
/*     */         }
/* 197 */         for (b3 = 0; b3 < (GameSystemProvider.a(param1GameSystemProvider1)).size; b3++) {
/*     */           GameSystem gameSystem;
/* 199 */           if ((gameSystem = ((GameSystem[])(GameSystemProvider.a(param1GameSystemProvider1)).items)[b3]).affectsGameState()) {
/* 200 */             GameSystem gameSystem1 = GameSystemProvider.a(param1GameSystemProvider2, gameSystem.getClass());
/*     */             
/* 202 */             param1DeepClassComparisonConfig.addPrefix(new String[] { "[", PMath.toString(b3), " ", gameSystem1.getClass().getName(), "]" });
/* 203 */             SyncChecker.compareObjects(gameSystem, gameSystem1, param1DeepClassComparisonConfig);
/* 204 */             param1DeepClassComparisonConfig.popPrefix(5);
/*     */           } 
/*     */         } 
/*     */         
/* 208 */         param1DeepClassComparisonConfig.addPrefix(new String[] { ".E" });
/* 209 */         SyncChecker.compareObjects(param1GameSystemProvider1.events, param1GameSystemProvider2.events, param1DeepClassComparisonConfig);
/* 210 */         param1DeepClassComparisonConfig.popPrefix(1);
/*     */       }
/*     */     };
/*     */   static {
/* 214 */     SyncChecker.CLASS_COMPARATORS.add(CLASS_COMPARATOR);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 222 */     paramKryo.writeObject(paramOutput, this.CFG);
/* 223 */     byte b1 = 0; byte b2;
/* 224 */     for (b2 = 0; b2 < this.c.size; b2++) {
/* 225 */       if (((GameSystem[])this.c.items)[b2].affectsGameState()) {
/* 226 */         b1++;
/*     */       }
/*     */     } 
/* 229 */     paramOutput.writeVarInt(b1, true);
/* 230 */     for (b2 = 0; b2 < this.c.size; b2++) {
/* 231 */       if (((GameSystem[])this.c.items)[b2].affectsGameState())
/*     */       {
/* 233 */         paramKryo.writeClassAndObject(paramOutput, ((GameSystem[])this.c.items)[b2]);
/*     */       }
/*     */     } 
/* 236 */     paramKryo.writeObject(paramOutput, this.events);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 241 */     this.CFG = (SystemsConfig)paramKryo.readObject(paramInput, SystemsConfig.class);
/* 242 */     int i = paramInput.readVarInt(true);
/* 243 */     for (byte b = 0; b < i; b++) {
/* 244 */       GameSystem gameSystem = (GameSystem)paramKryo.readClassAndObject(paramInput);
/*     */       
/* 246 */       addSystem(gameSystem);
/*     */     } 
/* 248 */     this.events = (EventDispatcher)paramKryo.readObject(paramInput, EventDispatcher.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GameSystemProvider(SystemsConfig paramSystemsConfig) {
/* 255 */     this.CFG = paramSystemsConfig;
/*     */   }
/*     */   
/*     */   private void b() {
/* 259 */     this.TSH.sort.sort(this.c, (paramGameSystem1, paramGameSystem2) -> {
/*     */           byte b1 = 0;
/*     */           byte b2 = 0;
/*     */           for (byte b3 = 0; b3 < b.length; b3++) {
/*     */             if (b[b3] == paramGameSystem1.getClass()) {
/*     */               b1 = b3;
/*     */             } else if (b[b3] == paramGameSystem2.getClass()) {
/*     */               b2 = b3;
/*     */             } 
/*     */           } 
/*     */           return Integer.compare(b1, b2);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void createSystems() {
/* 277 */     if (this.CFG.setup == SystemsConfig.Setup.GAME) {
/* 278 */       if (!this.CFG.headless) addSystem((GameSystem)new SoundSystem()); 
/* 279 */       addSystem((GameSystem)new AchievementSystem());
/* 280 */       if (!this.CFG.headless) addSystem((GameSystem)new InputSystem()); 
/* 281 */       if (!this.CFG.headless) addSystem((GameSystem)new HotKeySystem()); 
/* 282 */       if (!this.CFG.headless) addSystem((GameSystem)new GameUiSystem()); 
/* 283 */       if (!this.CFG.headless) addSystem((GameSystem)new RenderSystem()); 
/* 284 */       addSystem((GameSystem)new GameValueSystem());
/* 285 */       addSystem((GameSystem)new ExperienceSystem());
/* 286 */       addSystem((GameSystem)new GameStateSystem());
/* 287 */       addSystem((GameSystem)new BonusSystem());
/* 288 */       addSystem((GameSystem)new GameplayModSystem());
/* 289 */       addSystem((GameSystem)new DamageSystem());
/* 290 */       if (!this.CFG.headless) addSystem((GameSystem)new QuestSystem()); 
/* 291 */       addSystem((GameSystem)new BuffSystem());
/* 292 */       addSystem((GameSystem)new LootSystem());
/* 293 */       addSystem((GameSystem)new EnemySystem());
/* 294 */       addSystem((GameSystem)new UnitSystem());
/* 295 */       addSystem((GameSystem)new AbilitySystem());
/* 296 */       addSystem((GameSystem)new MapSystem());
/* 297 */       if (!this.CFG.headless) addSystem((GameSystem)new MapRenderingSystem()); 
/* 298 */       if (!this.CFG.headless) addSystem((GameSystem)new PathRenderingSystem()); 
/* 299 */       addSystem((GameSystem)new ProjectileSystem());
/* 300 */       addSystem((GameSystem)new ExplosionSystem());
/* 301 */       addSystem((GameSystem)new TowerSystem());
/* 302 */       addSystem((GameSystem)new MinerSystem());
/* 303 */       addSystem((GameSystem)new ModifierSystem());
/* 304 */       addSystem((GameSystem)new PathfindingSystem());
/* 305 */       if (!this.CFG.headless) addSystem((GameSystem)new ProjectileTrailSystem()); 
/* 306 */       if (!this.CFG.headless) addSystem((GameSystem)new ParticleSystem()); 
/* 307 */       if (!this.CFG.headless) addSystem((GameSystem)new GameMapSelectionSystem()); 
/* 308 */       addSystem((GameSystem)new WaveSystem());
/* 309 */       addSystem((GameSystem)new StatisticsSystem());
/* 310 */       if (!this.CFG.noScripts) addSystem((GameSystem)new ScriptSystem()); 
/* 311 */       addSystem((GameSystem)new CachedRenderingSystem());
/* 312 */     } else if (this.CFG.setup == SystemsConfig.Setup.MAP_EDITOR) {
/* 313 */       addSystem((GameSystem)new StateSystem());
/* 314 */       addSystem((GameSystem)new InventorySystem());
/* 315 */       addSystem((GameSystem)new MapEditorSystem());
/* 316 */       addSystem((GameSystem)new MapSystem());
/* 317 */       addSystem((GameSystem)new PathfindingSystem());
/* 318 */       addSystem((GameSystem)new MapRenderingSystem());
/* 319 */       addSystem((GameSystem)new PathRenderingSystem());
/* 320 */       addSystem((GameSystem)new ParticleSystem());
/* 321 */       addSystem((GameSystem)new RenderSystem());
/* 322 */       addSystem((GameSystem)new InputSystem());
/* 323 */       addSystem((GameSystem)new GameValueSystem());
/* 324 */       addSystem((GameSystem)new MapEditorUiSystem());
/* 325 */       addSystem((GameSystem)new CachedRenderingSystem());
/* 326 */       if (!this.CFG.noScripts) addSystem((GameSystem)new ScriptSystem());
/*     */     
/*     */     } 
/* 329 */     b(); byte b; int i;
/* 330 */     for (b = 0, i = this.c.size; b < i; b++) {
/* 331 */       ((GameSystem[])this.c.items)[b].setRegistered(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 336 */   private static final Output f = new Output(65536, -1);
/*     */   
/*     */   public final synchronized GameSystemProvider deepCopy() {
/* 339 */     f.setPosition(0);
/* 340 */     serialize(f);
/* 341 */     return unserialize(new Input(f.getBuffer(), 0, f.position()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void serialize(Output paramOutput) {
/* 347 */     Game.i.networkManager.getFullKryo().writeObject(paramOutput, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GameSystemProvider unserialize(Input paramInput) {
/* 353 */     return (GameSystemProvider)Game.i.networkManager.getFullKryo().readObject(paramInput, GameSystemProvider.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void createAndSetupNonStateAffectingSystemsAfterDeserialization() {
/*     */     Array array;
/* 363 */     (array = new Array(GameSystem.class)).add(new SoundSystem());
/* 364 */     array.add(new InputSystem());
/* 365 */     array.add(new HotKeySystem());
/* 366 */     array.add(new GameUiSystem());
/* 367 */     array.add(new RenderSystem());
/* 368 */     array.add(new MapRenderingSystem());
/* 369 */     array.add(new PathRenderingSystem());
/* 370 */     array.add(new ProjectileTrailSystem());
/* 371 */     array.add(new ParticleSystem());
/* 372 */     array.add(new QuestSystem());
/* 373 */     array.add(new CachedRenderingSystem());
/* 374 */     array.add(new GameMapSelectionSystem());
/*     */     Array.ArrayIterator<GameSystem> arrayIterator;
/* 376 */     for (arrayIterator = array.iterator(); arrayIterator.hasNext(); ) { GameSystem gameSystem = arrayIterator.next();
/* 377 */       addSystem(gameSystem); }
/*     */     
/* 379 */     b();
/* 380 */     for (arrayIterator = array.iterator(); arrayIterator.hasNext();) {
/* 381 */       (gameSystem = arrayIterator.next()).setRegistered(this);
/*     */     }
/* 383 */     for (arrayIterator = array.iterator(); arrayIterator.hasNext();) {
/* 384 */       (gameSystem = arrayIterator.next()).setup();
/*     */     }
/* 386 */     for (arrayIterator = array.iterator(); arrayIterator.hasNext();) {
/* 387 */       (gameSystem = arrayIterator.next()).postSetup();
/*     */     }
/*     */     
/* 390 */     for (arrayIterator = this.c.iterator(); arrayIterator.hasNext();) {
/* 391 */       (gameSystem = arrayIterator.next()).postStateRestore();
/*     */     }
/* 393 */     this.events.getListeners(SystemsStateRestore.class).trigger((Event)new SystemsStateRestore());
/*     */   } public final void setupSystems() {
/*     */     byte b;
/*     */     int i;
/* 397 */     for (b = 0, i = this.c.size; b < i; b++) {
/* 398 */       ((GameSystem[])this.c.items)[b].setup();
/*     */     }
/* 400 */     this.events.getListeners(SystemsSetup.class).trigger((Event)new SystemsSetup());
/*     */   } public final void postSetupSystems() {
/*     */     byte b;
/*     */     int i;
/* 404 */     for (b = 0, i = this.c.size; b < i; b++) {
/* 405 */       ((GameSystem[])this.c.items)[b].postSetup();
/*     */     }
/* 407 */     this.events.getListeners(SystemsPostSetup.class).trigger((Event)new SystemsPostSetup());
/*     */   }
/*     */   
/*     */   public final void compareSync(GameSystemProvider paramGameSystemProvider, StringBuilder paramStringBuilder, boolean paramBoolean) {
/*     */     DeepClassComparisonConfig deepClassComparisonConfig;
/* 412 */     (deepClassComparisonConfig = new DeepClassComparisonConfig()).depth = 12;
/* 413 */     deepClassComparisonConfig.debug = paramBoolean;
/* 414 */     deepClassComparisonConfig.addPrefix(new String[] { "S" });
/* 415 */     SyncChecker.compareObjects(this, paramGameSystemProvider, deepClassComparisonConfig);
/* 416 */     paramStringBuilder.append(deepClassComparisonConfig.sb);
/*     */   }
/*     */   
/*     */   public final void resetSystemsFrameProfiling() {
/* 420 */     for (byte b = 0; b < this.c.size; b++)
/* 421 */       this.e[b] = 0L; 
/*     */   }
/*     */   public final void flushSystemsFrameProfiling() {
/*     */     byte b;
/*     */     int i;
/* 426 */     for (b = 0, i = this.c.size; b < i; b++) {
/* 427 */       long l = this.e[b];
/* 428 */       if (((GameSystem[])this.c.items)[b].profileUpdate()) {
/* 429 */         Game.i.debugManager.registerFrameJob(((GameSystem[])this.c.items)[b].getSystemName(), l);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void updateSystems() {
/* 435 */     if (this.gameState != null) {
/* 436 */       this.gameState.updateNumber++;
/* 437 */       this.gameState.inUpdateStage = true;
/* 438 */       if (Config.isHeadless() && this.gameState.updateNumber % 10000 == 0 && this.gameState.headlessValidatedReplayRecord != null) {
/* 439 */         float f1 = (float)(Game.getTimestampMillis() - this.gameState.validationStartTimestamp) * 0.001F;
/* 440 */         int j = (int)(this.gameState.updateNumber / f1);
/* 441 */         ((HeadlessReplayValidationGame)Game.i).writeServerStatus("validating|" + this.gameState.headlessValidatedReplayRecord.id + "|" + this.gameState.updateNumber + "|" + this.gameState.validationLastUpdateNumber + "|" + j);
/* 442 */         if (this.gameState.updateNumber % 20000 == 0) {
/* 443 */           a.i((this.gameState.updateNumber / 1000) + "k", new Object[0]);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 449 */     float f = (this.gameValue == null) ? Config.UPDATE_DELTA_TIME : this.gameValue.getTickRateDeltaTime();
/* 450 */     byte b1 = 0; byte b2; int i;
/* 451 */     for (b2 = 0, i = this.c.size; b2 < i; b2++) {
/* 452 */       long l = Game.getRealTickCount();
/* 453 */       ((GameSystem[])this.c.items)[b2].update(f);
/*     */ 
/*     */       
/* 456 */       this.e[b1] = this.e[b1] + Game.getRealTickCount() - l;
/* 457 */       b1++;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 464 */     this.map.updateDirtyTiles();
/*     */     
/* 466 */     if (this.gameState != null) {
/* 467 */       this.gameState.inUpdateStage = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public final Array<GameSystem> getSystemsOrdered() {
/* 472 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void addSystem(GameSystem paramGameSystem) {
/* 476 */     if (paramGameSystem == null) throw new IllegalArgumentException("System is null");
/*     */     
/* 478 */     this.d.put(paramGameSystem.getClass(), paramGameSystem);
/*     */     
/* 480 */     this.c.add(paramGameSystem);
/*     */     
/* 482 */     if (paramGameSystem instanceof InventorySystem) this._inventory = (InventorySystem)paramGameSystem; 
/* 483 */     if (paramGameSystem instanceof MapEditorSystem) this._mapEditor = (MapEditorSystem)paramGameSystem; 
/* 484 */     if (paramGameSystem instanceof StateSystem) this.state = (StateSystem)paramGameSystem; 
/* 485 */     if (paramGameSystem instanceof GameStateSystem) this.gameState = (GameStateSystem)paramGameSystem; 
/* 486 */     if (paramGameSystem instanceof SoundSystem) this._sound = (SoundSystem)paramGameSystem; 
/* 487 */     if (paramGameSystem instanceof AchievementSystem) this.achievement = (AchievementSystem)paramGameSystem; 
/* 488 */     if (paramGameSystem instanceof InputSystem) this._input = (InputSystem)paramGameSystem; 
/* 489 */     if (paramGameSystem instanceof HotKeySystem) this._hotKey = (HotKeySystem)paramGameSystem; 
/* 490 */     if (paramGameSystem instanceof GameUiSystem) this._gameUi = (GameUiSystem)paramGameSystem; 
/* 491 */     if (paramGameSystem instanceof MapEditorUiSystem) this._mapEditorUi = (MapEditorUiSystem)paramGameSystem; 
/* 492 */     if (paramGameSystem instanceof MapRenderingSystem) this._mapRendering = (MapRenderingSystem)paramGameSystem; 
/* 493 */     if (paramGameSystem instanceof PathRenderingSystem) this._pathRendering = (PathRenderingSystem)paramGameSystem; 
/* 494 */     if (paramGameSystem instanceof ProjectileTrailSystem) this._projectileTrail = (ProjectileTrailSystem)paramGameSystem; 
/* 495 */     if (paramGameSystem instanceof ParticleSystem) this._particle = (ParticleSystem)paramGameSystem; 
/* 496 */     if (paramGameSystem instanceof GameValueSystem) this.gameValue = (GameValueSystem)paramGameSystem; 
/* 497 */     if (paramGameSystem instanceof ExperienceSystem) this.experience = (ExperienceSystem)paramGameSystem; 
/* 498 */     if (paramGameSystem instanceof QuestSystem) this._quest = (QuestSystem)paramGameSystem; 
/* 499 */     if (paramGameSystem instanceof BuffSystem) this.buff = (BuffSystem)paramGameSystem; 
/* 500 */     if (paramGameSystem instanceof LootSystem) this.loot = (LootSystem)paramGameSystem; 
/* 501 */     if (paramGameSystem instanceof EnemySystem) this.enemy = (EnemySystem)paramGameSystem; 
/* 502 */     if (paramGameSystem instanceof UnitSystem) this.unit = (UnitSystem)paramGameSystem; 
/* 503 */     if (paramGameSystem instanceof AbilitySystem) this.ability = (AbilitySystem)paramGameSystem; 
/* 504 */     if (paramGameSystem instanceof MapSystem) this.map = (MapSystem)paramGameSystem; 
/* 505 */     if (paramGameSystem instanceof ProjectileSystem) this.projectile = (ProjectileSystem)paramGameSystem; 
/* 506 */     if (paramGameSystem instanceof ExplosionSystem) this.explosion = (ExplosionSystem)paramGameSystem; 
/* 507 */     if (paramGameSystem instanceof TowerSystem) this.tower = (TowerSystem)paramGameSystem; 
/* 508 */     if (paramGameSystem instanceof MinerSystem) this.miner = (MinerSystem)paramGameSystem; 
/* 509 */     if (paramGameSystem instanceof ModifierSystem) this.modifier = (ModifierSystem)paramGameSystem; 
/* 510 */     if (paramGameSystem instanceof PathfindingSystem) this.pathfinding = (PathfindingSystem)paramGameSystem; 
/* 511 */     if (paramGameSystem instanceof WaveSystem) this.wave = (WaveSystem)paramGameSystem; 
/* 512 */     if (paramGameSystem instanceof StatisticsSystem) this.statistics = (StatisticsSystem)paramGameSystem; 
/* 513 */     if (paramGameSystem instanceof ScriptSystem) this.script = (ScriptSystem)paramGameSystem; 
/* 514 */     if (paramGameSystem instanceof BonusSystem) this.bonus = (BonusSystem)paramGameSystem; 
/* 515 */     if (paramGameSystem instanceof GameplayModSystem) this.gameplayMod = (GameplayModSystem)paramGameSystem; 
/* 516 */     if (paramGameSystem instanceof DamageSystem) this.damage = (DamageSystem)paramGameSystem; 
/* 517 */     if (paramGameSystem instanceof RenderSystem) this._render = (RenderSystem)paramGameSystem; 
/* 518 */     if (paramGameSystem instanceof CachedRenderingSystem) this._cachedRendering = (CachedRenderingSystem)paramGameSystem; 
/* 519 */     if (paramGameSystem instanceof GameMapSelectionSystem) this._gameMapSelection = (GameMapSelectionSystem)paramGameSystem;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private <T extends GameSystem> T a(Class<T> paramClass) {
/*     */     byte b;
/*     */     GameSystem gameSystem;
/* 528 */     if ((gameSystem = (GameSystem)this.d.get(paramClass, null)) == null) {
/*     */       
/* 530 */       for (b = 0; b < this.c.size; b++) {
/* 531 */         if (paramClass.isInstance(((GameSystem[])this.c.items)[b])) {
/* 532 */           return (T)((GameSystem[])this.c.items)[b];
/*     */         }
/*     */       } 
/* 535 */       throw new IllegalArgumentException("System " + paramClass.getName() + " is not registered");
/*     */     } 
/*     */     
/* 538 */     return b;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 565 */     this.events.getListeners(SystemsDispose.class).trigger((Event)new SystemsDispose()); byte b;
/*     */     int i;
/* 567 */     for (b = 0, i = this.c.size; b < i; b++) {
/* 568 */       ((GameSystem)this.c.get(b)).dispose();
/* 569 */       ((GameSystem)this.c.get(b)).setUnregistered();
/*     */     } 
/*     */     
/* 572 */     this.c.clear();
/* 573 */     this.d.clear();
/*     */     
/* 575 */     this._inventory = null;
/* 576 */     this._mapEditor = null;
/* 577 */     this._sound = null;
/* 578 */     this._input = null;
/* 579 */     this._gameUi = null;
/* 580 */     this._mapRendering = null;
/* 581 */     this._pathRendering = null;
/* 582 */     this._projectileTrail = null;
/* 583 */     this._particle = null;
/* 584 */     this.gameValue = null;
/* 585 */     this.experience = null;
/* 586 */     this.damage = null;
/* 587 */     this.state = null;
/* 588 */     this.gameState = null;
/* 589 */     this._quest = null;
/* 590 */     this.buff = null;
/* 591 */     this.loot = null;
/* 592 */     this.enemy = null;
/* 593 */     this.unit = null;
/* 594 */     this.ability = null;
/* 595 */     this.map = null;
/* 596 */     this.projectile = null;
/* 597 */     this.explosion = null;
/* 598 */     this.tower = null;
/* 599 */     this.miner = null;
/* 600 */     this.modifier = null;
/* 601 */     this.wave = null;
/* 602 */     this.statistics = null;
/* 603 */     this.script = null;
/* 604 */     this.bonus = null;
/* 605 */     this.events = null;
/*     */   }
/*     */   private GameSystemProvider() {}
/*     */   @REGS
/*     */   public static class SystemsConfig implements KryoSerializable { public boolean headless; public boolean noScripts; public Setup setup;
/*     */     
/*     */     @REGS
/* 612 */     public enum Setup { GAME,
/* 613 */       MAP_EDITOR; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 623 */       param1Output.writeBoolean(this.headless);
/* 624 */       param1Output.writeBoolean(this.noScripts);
/* 625 */       param1Kryo.writeObject(param1Output, this.setup);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 630 */       this.headless = param1Input.readBoolean();
/* 631 */       this.noScripts = param1Input.readBoolean();
/* 632 */       this.setup = (Setup)param1Kryo.readObject(param1Input, Setup.class);
/*     */     }
/*     */     
/*     */     private SystemsConfig() {}
/*     */     
/*     */     public SystemsConfig(Setup param1Setup, boolean param1Boolean) {
/* 638 */       this.setup = param1Setup;
/* 639 */       this.headless = param1Boolean;
/*     */     }
/*     */     
/*     */     public SystemsConfig disableScripts() {
/* 643 */       this.noScripts = true;
/* 644 */       return this;
/*     */     } }
/*     */   @REGS
/*     */   public enum Setup { GAME, MAP_EDITOR; }
/*     */   public static final class ThreadSafeSharedHelpers { public static final int MAX_ENEMY_ARRAYS = 8; public static final int MAX_TOWER_ARRAYS = 8;
/*     */     public static final int MAX_MINER_ARRAYS = 8;
/*     */     public static final int MAX_TILE_ARRAYS = 8;
/*     */     public final Sort sort;
/*     */     public final FloatSorter floatSorter;
/*     */     private final Array<Array<Enemy>> a;
/*     */     private final Array<Array<Tower>> b;
/*     */     private final Array<Array<Tile>> c;
/*     */     private final Array<Array<Miner>> d;
/*     */     
/*     */     public ThreadSafeSharedHelpers() {
/* 659 */       this.sort = new Sort();
/* 660 */       this.floatSorter = new FloatSorter(this.sort);
/*     */       
/* 662 */       this.a = new Array(true, 1, Array.class);
/* 663 */       this.b = new Array(true, 1, Array.class);
/* 664 */       this.c = new Array(true, 1, Array.class);
/* 665 */       this.d = new Array(true, 1, Array.class);
/*     */     }
/*     */     public final Array<Enemy> getEnemyArray() {
/* 668 */       if (this.a.size == 0) {
/* 669 */         return new Array(true, 1, Enemy.class);
/*     */       }
/* 671 */       return (Array<Enemy>)this.a.pop();
/*     */     }
/*     */     
/*     */     public final void freeEnemyArray(Array<Enemy> param1Array) {
/* 675 */       if (this.a.size == 8) {
/* 676 */         GameSystemProvider.a().i("disposing enemy array (max arrays reached)", new Object[] { new Throwable() });
/*     */         return;
/*     */       } 
/* 679 */       param1Array.clear();
/* 680 */       this.a.add(param1Array);
/*     */     }
/*     */     
/*     */     public final Array<Tower> getTowerArray() {
/* 684 */       if (this.b.size == 0) {
/* 685 */         return new Array(true, 1, Tower.class);
/*     */       }
/* 687 */       return (Array<Tower>)this.b.pop();
/*     */     }
/*     */     
/*     */     public final void freeTowerArray(Array<Tower> param1Array) {
/* 691 */       if (this.b.size == 8) {
/* 692 */         GameSystemProvider.a().i("disposing tower array (max arrays reached)", new Object[0]);
/*     */         return;
/*     */       } 
/* 695 */       param1Array.clear();
/* 696 */       this.b.add(param1Array);
/*     */     }
/*     */     
/*     */     public final Array<Miner> getMinerArray() {
/* 700 */       if (this.d.size == 0) {
/* 701 */         return new Array(true, 1, Miner.class);
/*     */       }
/* 703 */       return (Array<Miner>)this.d.pop();
/*     */     }
/*     */     
/*     */     public final void freeMinerArray(Array<Miner> param1Array) {
/* 707 */       if (this.d.size == 8) {
/* 708 */         GameSystemProvider.a().i("disposing miner array (max arrays reached)", new Object[0]);
/*     */         return;
/*     */       } 
/* 711 */       param1Array.clear();
/* 712 */       this.d.add(param1Array);
/*     */     }
/*     */     
/*     */     public final Array<Tile> getTileArray() {
/* 716 */       if (this.c.size == 0) {
/* 717 */         return new Array(true, 1, Tile.class);
/*     */       }
/* 719 */       return (Array<Tile>)this.c.pop();
/*     */     }
/*     */     
/*     */     public final void freeTileArray(Array<Tile> param1Array) {
/* 723 */       if (this.c.size == 8) {
/* 724 */         GameSystemProvider.a().i("disposing tile array (max arrays reached)", new Object[0]);
/*     */         return;
/*     */       } 
/* 727 */       param1Array.clear();
/* 728 */       this.c.add(param1Array);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\GameSystemProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */