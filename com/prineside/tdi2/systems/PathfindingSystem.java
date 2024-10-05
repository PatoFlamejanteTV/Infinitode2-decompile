/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.ai.pfa.Connection;
/*     */ import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
/*     */ import com.badlogic.gdx.ai.pfa.GraphPath;
/*     */ import com.badlogic.gdx.ai.pfa.Heuristic;
/*     */ import com.badlogic.gdx.ai.pfa.indexed.IndexedAStarPathFinder;
/*     */ import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.ByteArray;
/*     */ import com.badlogic.gdx.utils.IntMap;
/*     */ import com.badlogic.gdx.utils.IntSet;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.GateBarrier;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.BuildingRemove;
/*     */ import com.prineside.tdi2.events.game.GameValuesRecalculate;
/*     */ import com.prineside.tdi2.events.game.GateChange;
/*     */ import com.prineside.tdi2.events.game.ModifierPlace;
/*     */ import com.prineside.tdi2.events.game.PathfindingRebuild;
/*     */ import com.prineside.tdi2.events.game.TileChange;
/*     */ import com.prineside.tdi2.events.game.TowerPlace;
/*     */ import com.prineside.tdi2.gates.TeleportGate;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.pathfinding.HeavyPathNode;
/*     */ import com.prineside.tdi2.pathfinding.Path;
/*     */ import com.prineside.tdi2.pathfinding.PathConnection;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.tiles.TargetTile;
/*     */ import com.prineside.tdi2.utils.DrawUtils;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ @REGS
/*     */ public final class PathfindingSystem
/*     */   extends GameSystem
/*     */ {
/*  60 */   private static final TLog a = TLog.forClass(PathfindingSystem.class);
/*     */ 
/*     */   
/*  63 */   private static final Color b = new Color(0.0F, 1.0F, 0.0F, 0.28F);
/*  64 */   private static final Color c = new Color(1.0F, 1.0F, 0.0F, 0.28F);
/*     */   
/*     */   @NAGS
/*     */   public boolean throwExceptionOnMissingPath = true;
/*     */   
/*     */   private boolean d = true;
/*     */   private boolean e = false;
/*     */   @NAGS
/*     */   private volatile boolean f;
/*  73 */   public Array<HeavyPathNode> pathfindingNodes = new Array(true, 1, HeavyPathNode.class);
/*     */   private HeavyPathNode[][] g;
/*  75 */   private IntMap<IntMap<Path>> h = new IntMap();
/*  76 */   private int i = -1; @NAGS
/*  77 */   private final IntMap<IndexedGraph<HeavyPathNode>> j = new IntMap();
/*     */ 
/*     */   
/*  80 */   private static final Heuristic<HeavyPathNode> k = new Heuristic<HeavyPathNode>()
/*     */     {
/*     */       public float estimate(HeavyPathNode param1HeavyPathNode1, HeavyPathNode param1HeavyPathNode2) {
/*  83 */         return (StrictMath.abs(param1HeavyPathNode2.x - param1HeavyPathNode1.x) + StrictMath.abs(param1HeavyPathNode2.y - param1HeavyPathNode1.y));
/*     */       }
/*     */     };
/*     */   @NAGS
/*  87 */   private final HashMap<PathfindingParameterizedConfig, Path> l = new HashMap<>(); @NAGS
/*  88 */   private final HashMap<SharedPathfindingConfig, Path> m = new HashMap<>(); @NAGS
/*  89 */   private final Array<Map.EnemyTypeSpawnPair> n = new Array(); @NAGS
/*  90 */   private final IntSet o = new IntSet(); @NAGS
/*  91 */   private final IntMap<Array<TeleportGate>> p = new IntMap();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  95 */     super.write(paramKryo, paramOutput);
/*  96 */     paramOutput.writeBoolean(this.d);
/*  97 */     paramOutput.writeBoolean(this.e);
/*  98 */     paramKryo.writeObject(paramOutput, this.pathfindingNodes);
/*  99 */     paramKryo.writeObjectOrNull(paramOutput, this.g, HeavyPathNode[][].class);
/* 100 */     paramKryo.writeObject(paramOutput, this.h);
/* 101 */     paramOutput.writeInt(this.i);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/* 106 */     super.read(paramKryo, paramInput);
/* 107 */     this.d = paramInput.readBoolean();
/* 108 */     this.e = paramInput.readBoolean();
/* 109 */     this.pathfindingNodes = (Array<HeavyPathNode>)paramKryo.readObject(paramInput, Array.class);
/* 110 */     this.g = (HeavyPathNode[][])paramKryo.readObjectOrNull(paramInput, HeavyPathNode[][].class);
/* 111 */     this.h = (IntMap<IntMap<Path>>)paramKryo.readObject(paramInput, IntMap.class);
/* 112 */     this.i = paramInput.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 117 */     this.S.events.getListeners(GateChange.class).addStateAffecting(new OnGateChange(this, (byte)0)).setDescription("PathfindingSystem");
/* 118 */     this.S.events.getListeners(TileChange.class).addStateAffecting(new OnTileChange(this, (byte)0)).setDescription("PathfindingSystem");
/* 119 */     this.S.events.getListeners(TowerPlace.class).addStateAffecting(new OnTowerPlace(this, (byte)0)).setDescription("PathfindingSystem");
/* 120 */     this.S.events.getListeners(ModifierPlace.class).addStateAffecting(new OnModifierPlace(this, (byte)0)).setDescription("PathfindingSystem");
/* 121 */     this.S.events.getListeners(BuildingRemove.class).addStateAffecting(new OnBuildingRemove(this, (byte)0)).setDescription("PathfindingSystem");
/* 122 */     this.S.events.getListeners(GameValuesRecalculate.class).addStateAffecting(new OnGameValuesRecalculate(this)).setDescription("PathfindingSystem");
/*     */   }
/*     */   
/*     */   private void a() {
/* 126 */     if (this.S.CFG.headless)
/* 127 */       return;  this.S._render.addLayer(new RenderSystem.Layer(GameRenderingOrder.MAP_RENDERING_POST_DRAW + 10, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawDebug(paramBatch)));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postSetup() {
/* 132 */     b();
/* 133 */     a();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postStateRestore() {
/* 138 */     a();
/*     */   }
/*     */   
/*     */   public final boolean isWalkablePlatforms() {
/* 142 */     return this.e;
/*     */   }
/*     */   
/*     */   private void b() {
/*     */     boolean bool;
/* 147 */     if ((bool = this.S.gameValue.getBooleanValue(GameValueType.ENEMIES_WALK_ON_PLATFORMS)) != this.e) {
/* 148 */       this.e = bool;
/* 149 */       forcePathfindingRebuild();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAllEnemiesFindPath() {
/* 158 */     return ((getEnemyTypesThatCantFindPath()).size == 0);
/*     */   }
/*     */   
/*     */   public final void forcePathfindingRebuild() {
/* 162 */     this.d = true;
/*     */   } @Null
/*     */   public final Path findPathBetweenXY(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Null EnemyType paramEnemyType) {
/*     */     HeavyPathNode heavyPathNode;
/* 166 */     rebuildPathfindingIfNeeded();
/*     */     
/* 168 */     if (paramEnemyType != null) {
/* 169 */       paramEnemyType = EnemyType.getMainEnemyType(paramEnemyType);
/*     */     }
/*     */     
/*     */     PathfindingParameterizedConfig pathfindingParameterizedConfig;
/* 173 */     PathfindingParameterizedConfig.a(pathfindingParameterizedConfig = new PathfindingParameterizedConfig((byte)0), paramEnemyType);
/* 174 */     PathfindingParameterizedConfig.a(pathfindingParameterizedConfig, paramInt1);
/* 175 */     PathfindingParameterizedConfig.b(pathfindingParameterizedConfig, paramInt2);
/* 176 */     PathfindingParameterizedConfig.c(pathfindingParameterizedConfig, paramInt3);
/* 177 */     PathfindingParameterizedConfig.d(pathfindingParameterizedConfig, paramInt4);
/*     */     
/* 179 */     synchronized (this.l) {
/* 180 */       Path path = this.l.get(pathfindingParameterizedConfig);
/*     */     } 
/*     */ 
/*     */     
/* 184 */     if (paramInt1 != null) {
/* 185 */       if (Path.EMPTY == paramInt1) {
/* 186 */         heavyPathNode = null;
/*     */       } else {
/* 188 */         paramInt2 = paramInt1;
/*     */       } 
/*     */     } else {
/* 191 */       HeavyPathNode heavyPathNode1 = this.g[PathfindingParameterizedConfig.a(pathfindingParameterizedConfig)][PathfindingParameterizedConfig.b(pathfindingParameterizedConfig)];
/* 192 */       heavyPathNode = this.g[PathfindingParameterizedConfig.c(pathfindingParameterizedConfig)][PathfindingParameterizedConfig.d(pathfindingParameterizedConfig)];
/*     */       
/* 194 */       DefaultGraphPath defaultGraphPath = new DefaultGraphPath();
/*     */       boolean bool;
/* 196 */       if (bool = (new IndexedAStarPathFinder(a(paramEnemyType))).searchNodePath(heavyPathNode1, heavyPathNode, k, (GraphPath)defaultGraphPath)) {
/*     */         SharedPathfindingConfig sharedPathfindingConfig;
/*     */         
/* 199 */         (sharedPathfindingConfig = new SharedPathfindingConfig((byte)0)).set((GraphPath<HeavyPathNode>)defaultGraphPath);
/*     */         
/* 201 */         if ((null = this.m.get(sharedPathfindingConfig)) == null) {
/*     */           
/* 203 */           null = new Path(defaultGraphPath);
/* 204 */           this.m.put(sharedPathfindingConfig, null);
/*     */         } else {
/*     */           
/* 207 */           null = null;
/*     */         } 
/* 209 */         synchronized (this.l) {
/* 210 */           this.l.put(new PathfindingParameterizedConfig(pathfindingParameterizedConfig, (byte)0), null);
/*     */         } 
/*     */       } else {
/* 213 */         synchronized (this.l) {
/* 214 */           this.l.put(new PathfindingParameterizedConfig(pathfindingParameterizedConfig, (byte)0), Path.EMPTY);
/*     */         } 
/* 216 */         heavyPathNode = null;
/*     */       } 
/*     */     } 
/* 219 */     return (Path)heavyPathNode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public final Path findPathBetweenTiles(Tile paramTile1, Tile paramTile2) {
/* 226 */     if (paramTile1 == null) throw new IllegalArgumentException("startTile is null"); 
/* 227 */     if (paramTile2 == null) throw new IllegalArgumentException("targetTile is null");
/*     */     
/* 229 */     return findPathBetweenXY(paramTile1.getX(), paramTile1.getY(), paramTile2.getX(), paramTile2.getY(), null);
/*     */   }
/*     */   @Null
/*     */   public final Path findPathToTargetTile(Tile paramTile, @Null EnemyType paramEnemyType) {
/* 233 */     TargetTile targetTile = this.S.map.getMap().getTargetTileOrThrow();
/* 234 */     if (paramTile == null) throw new IllegalArgumentException("startTile is null"); 
/* 235 */     if (targetTile == null) throw new IllegalArgumentException("targetTile is null");
/*     */     
/* 237 */     return findPathBetweenXY(paramTile.getX(), paramTile.getY(), targetTile.getX(), targetTile.getY(), paramEnemyType);
/*     */   }
/*     */   
/*     */   private static int a(Tile paramTile) {
/* 241 */     return (paramTile.getY() << 11) + paramTile.getX();
/*     */   }
/*     */   
/*     */   public final Path getDefaultPathWithoutStateChanges(EnemyType paramEnemyType, SpawnTile paramSpawnTile) {
/* 245 */     if (paramSpawnTile == null) {
/* 246 */       throw new IllegalArgumentException("spawnTile is null");
/*     */     }
/*     */     
/* 249 */     paramEnemyType = EnemyType.getMainEnemyType(paramEnemyType);
/* 250 */     int i = a((Tile)paramSpawnTile);
/* 251 */     if (!this.h.containsKey(i)) {
/* 252 */       return null;
/*     */     }
/*     */     IntMap intMap;
/* 255 */     if (!(intMap = (IntMap)this.h.get(i)).containsKey(paramEnemyType.ordinal())) {
/* 256 */       return null;
/*     */     }
/*     */     
/* 259 */     return (Path)intMap.get(paramEnemyType.ordinal());
/*     */   }
/*     */   
/*     */   private IndexedGraph<HeavyPathNode> a(@Null EnemyType paramEnemyType) {
/* 263 */     boolean bool = (paramEnemyType == null) ? true : paramEnemyType.ordinal();
/*     */     IndexedGraph<HeavyPathNode> indexedGraph;
/* 265 */     if ((indexedGraph = (IndexedGraph)this.j.get(bool)) == null) {
/* 266 */       if (paramEnemyType == null) {
/* 267 */         indexedGraph = new NoEnemyMapGraph(this.pathfindingNodes, (byte)0);
/*     */       } else {
/* 269 */         indexedGraph = new EnemyTypeMapGraph(this.pathfindingNodes, this.S.map.getMap(), paramEnemyType, (byte)0);
/*     */       } 
/* 271 */       this.j.put(bool, indexedGraph);
/*     */     } 
/*     */     
/* 274 */     return indexedGraph;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void rebuildPathfindingIfNeeded() {
/* 279 */     if (this.d) {
/* 280 */       rebuildPathfinding();
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
/*     */   public final void rebuildPathfinding() {
/* 292 */     if (this.f) {
/* 293 */       throw new IllegalStateException("already rebuilding");
/*     */     }
/* 295 */     this.f = true;
/*     */     
/* 297 */     this.j.clear();
/*     */     
/* 299 */     synchronized (this.l) {
/* 300 */       this.l.clear();
/*     */     } 
/* 302 */     this.m.clear();
/*     */ 
/*     */     
/* 305 */     byte b1 = 0;
/* 306 */     this.pathfindingNodes.clear();
/*     */     
/* 308 */     Map map = this.S.map.getMap();
/* 309 */     if (this.g == null || this.g.length != map.getHeight() || (this.g[0]).length != map.getWidth()) {
/* 310 */       this.g = new HeavyPathNode[map.getHeight()][map.getWidth()];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 319 */     boolean bool = isWalkablePlatforms(); short s;
/* 320 */     for (s = 0; s < map.getHeight(); s = (short)(s + 1)) {
/* 321 */       short s1; for (s1 = 0; s1 < map.getWidth(); s1 = (short)(s1 + 1)) {
/* 322 */         Tile tile = map.getTile(s1, s);
/*     */         HeavyPathNode heavyPathNode;
/* 324 */         (heavyPathNode = new HeavyPathNode()).setup(b1, s1, s, (tile == null) ? 6.871948E10F : tile.getWalkCost(bool));
/* 325 */         this.g[s][s1] = heavyPathNode;
/* 326 */         this.pathfindingNodes.add(heavyPathNode);
/* 327 */         b1++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 332 */     this.o.clear();
/* 333 */     for (s = 0; s < this.pathfindingNodes.size; s++) {
/*     */       HeavyPathNode heavyPathNode;
/*     */       
/* 336 */       (heavyPathNode = ((HeavyPathNode[])this.pathfindingNodes.items)[s]).connections.clear();
/* 337 */       if (heavyPathNode.x > 0) {
/*     */         HeavyPathNode heavyPathNode1;
/*     */         
/* 340 */         if ((heavyPathNode1 = this.g[heavyPathNode.y][heavyPathNode.x - 1]) != null) {
/* 341 */           a(heavyPathNode, heavyPathNode1, false);
/*     */         }
/*     */       } 
/* 344 */       if (heavyPathNode.y > 0) {
/*     */         HeavyPathNode heavyPathNode1;
/*     */         
/* 347 */         if ((heavyPathNode1 = this.g[heavyPathNode.y - 1][heavyPathNode.x]) != null) {
/* 348 */           a(heavyPathNode, heavyPathNode1, false);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 354 */     map.getTeleportGates(this.p);
/* 355 */     for (Iterator<IntMap.Entry> iterator = this.p.iterator(); iterator.hasNext();) {
/* 356 */       if (((Array)(entry = iterator.next()).value).size > 1) {
/*     */         
/* 358 */         Array array1 = (Array)entry.value;
/* 359 */         for (byte b = 0; b < array1.size; b++) {
/*     */           HeavyPathNode heavyPathNode2;
/*     */           TeleportGate teleportGate;
/* 362 */           HeavyPathNode heavyPathNode1 = ((teleportGate = ((TeleportGate[])array1.items)[b]).getX() == map.getWidth() || teleportGate.getY() == map.getHeight()) ? null : this.g[teleportGate.getY()][teleportGate.getX()];
/*     */           
/* 364 */           if (!teleportGate.isLeftSide()) {
/*     */ 
/*     */             
/* 367 */             heavyPathNode2 = (teleportGate.getX() == map.getWidth() || teleportGate.getY() == 0) ? null : this.g[teleportGate.getY() - 1][teleportGate.getX()];
/*     */           }
/*     */           else {
/*     */             
/* 371 */             heavyPathNode2 = (teleportGate.getX() == 0 || teleportGate.getY() == map.getHeight()) ? null : this.g[teleportGate.getY()][teleportGate.getX() - 1];
/*     */           } 
/*     */           
/* 374 */           for (byte b3 = 0; b3 < array1.size; b3++) {
/* 375 */             if (b3 != b) {
/*     */               HeavyPathNode heavyPathNode4;
/*     */               
/*     */               TeleportGate teleportGate1;
/* 379 */               HeavyPathNode heavyPathNode3 = ((teleportGate1 = ((TeleportGate[])array1.items)[b3]).getX() == map.getWidth() || teleportGate1.getY() == map.getHeight()) ? null : this.g[teleportGate1.getY()][teleportGate1.getX()];
/*     */               
/* 381 */               if (!teleportGate1.isLeftSide()) {
/*     */ 
/*     */                 
/* 384 */                 heavyPathNode4 = (teleportGate1.getX() == map.getWidth() || teleportGate1.getY() == 0) ? null : this.g[teleportGate1.getY() - 1][teleportGate1.getX()];
/*     */               }
/*     */               else {
/*     */                 
/* 388 */                 heavyPathNode4 = (teleportGate1.getX() == 0 || teleportGate1.getY() == map.getHeight()) ? null : this.g[teleportGate1.getY()][teleportGate1.getX() - 1];
/*     */               } 
/*     */               
/* 391 */               if (heavyPathNode1 != null) {
/* 392 */                 if (heavyPathNode3 != null) {
/* 393 */                   a(heavyPathNode1, heavyPathNode3, true);
/*     */                 }
/* 395 */                 if (heavyPathNode4 != null) {
/* 396 */                   a(heavyPathNode1, heavyPathNode4, true);
/*     */                 }
/*     */               } 
/* 399 */               if (heavyPathNode2 != null) {
/* 400 */                 if (heavyPathNode3 != null) {
/* 401 */                   a(heavyPathNode2, heavyPathNode3, true);
/*     */                 }
/* 403 */                 if (heavyPathNode4 != null) {
/* 404 */                   a(heavyPathNode2, heavyPathNode4, true);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 410 */           if (heavyPathNode1 != null) {
/* 411 */             if (teleportGate.isLeftSide()) {
/* 412 */               heavyPathNode1.teleportIndices[0] = teleportGate.index;
/*     */             } else {
/* 414 */               heavyPathNode1.teleportIndices[3] = teleportGate.index;
/*     */             } 
/*     */           }
/* 417 */           if (heavyPathNode2 != null) {
/* 418 */             if (teleportGate.isLeftSide()) {
/* 419 */               heavyPathNode2.teleportIndices[1] = teleportGate.index;
/*     */             } else {
/* 421 */               heavyPathNode2.teleportIndices[2] = teleportGate.index;
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 430 */     this.d = false;
/* 431 */     this.f = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 436 */     this.h.clear();
/*     */     
/* 438 */     Array array = map.getTilesByType(SpawnTile.class);
/* 439 */     IntMap intMap = new IntMap();
/* 440 */     Threads.i().concurrentLoop(array, (paramInt, paramSpawnTile) -> {
/*     */           IntMap intMap = new IntMap();
/*     */           
/*     */           int i = a((Tile)paramSpawnTile);
/*     */           
/*     */           synchronized (paramIntMap) {
/*     */             paramIntMap.put(i, intMap);
/*     */           } 
/*     */           
/*     */           Array array = paramSpawnTile.getAllowedEnemies();
/*     */           
/*     */           for (byte b = 0; b < array.size; b++) {
/*     */             EnemyType enemyType = (((SpawnTile.AllowedEnemyConfig[])array.items)[b]).enemyType;
/*     */             try {
/*     */               Path path;
/*     */               if ((path = findPathToTargetTile((Tile)paramSpawnTile, enemyType)) != null) {
/*     */                 intMap.put(enemyType.ordinal(), path);
/*     */               }
/* 458 */             } catch (Exception exception) {
/*     */               if (this.throwExceptionOnMissingPath) {
/*     */                 throw new Map.PathNotFoundForEnemyTypeException(enemyType, exception);
/*     */               }
/*     */               
/*     */               intMap.put(enemyType.ordinal(), null);
/*     */             } 
/*     */           } 
/*     */         });
/*     */     
/* 468 */     this.h.putAll(intMap);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 473 */     int i = 1; byte b2;
/* 474 */     for (b2 = 0; b2 < array.size; b2++) {
/*     */       SpawnTile spawnTile;
/* 476 */       int j = a((Tile)(spawnTile = ((SpawnTile[])array.items)[b2]));
/* 477 */       IntMap intMap1 = (IntMap)intMap.get(j);
/*     */       
/* 479 */       Array array1 = spawnTile.getAllowedEnemies();
/* 480 */       for (byte b = 0; b < array1.size; b++) {
/* 481 */         EnemyType enemyType = (((SpawnTile.AllowedEnemyConfig[])array1.items)[b]).enemyType;
/*     */         Path path;
/* 483 */         if ((path = (Path)intMap1.get(enemyType.ordinal())) != null) {
/* 484 */           i = i * 31 + path.hashCode();
/*     */         } else {
/* 486 */           i = i * 31 + 9001;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 495 */     b2 = (this.i != i) ? 1 : 0;
/* 496 */     this.i = i;
/*     */     
/* 498 */     this.S.events.trigger((Event)new PathfindingRebuild(b2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 505 */     return paramInt1 + (paramInt2 << 7) + (paramInt3 << 7 << 7) + (paramInt4 << 7 << 7 << 7);
/*     */   }
/*     */   
/*     */   private void a(HeavyPathNode paramHeavyPathNode1, HeavyPathNode paramHeavyPathNode2, boolean paramBoolean) {
/* 509 */     int i = a(paramHeavyPathNode1.x, paramHeavyPathNode1.y, paramHeavyPathNode2.x, paramHeavyPathNode2.y);
/* 510 */     int j = a(paramHeavyPathNode2.x, paramHeavyPathNode2.y, paramHeavyPathNode1.x, paramHeavyPathNode1.y);
/* 511 */     i = StrictMath.min(i, j);
/* 512 */     if (paramBoolean) {
/* 513 */       i = -i;
/*     */     }
/*     */     
/* 516 */     if (!this.o.contains(i)) {
/*     */       
/* 518 */       this.o.add(i);
/*     */       
/* 520 */       paramHeavyPathNode1.connections.add(new PathConnection(this.pathfindingNodes, paramHeavyPathNode1.index, paramHeavyPathNode2.index, paramBoolean, paramHeavyPathNode2.cost));
/* 521 */       paramHeavyPathNode2.connections.add(new PathConnection(this.pathfindingNodes, paramHeavyPathNode2.index, paramHeavyPathNode1.index, paramBoolean, paramHeavyPathNode1.cost));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Array<Map.EnemyTypeSpawnPair> getEnemyTypesThatCantFindPath() {
/* 529 */     this.n.clear();
/* 530 */     rebuildPathfindingIfNeeded();
/*     */     
/*     */     Map map;
/* 533 */     Array array = (map = this.S.map.getMap()).getTilesByType(SpawnTile.class);
/* 534 */     for (byte b = 0; b < array.size; b++) {
/*     */       SpawnTile spawnTile;
/* 536 */       int i = a((Tile)(spawnTile = ((SpawnTile[])array.items)[b]));
/* 537 */       Array array1 = spawnTile.getAllowedEnemies();
/* 538 */       for (byte b1 = 0; b1 < array1.size; b1++) {
/* 539 */         if (!this.h.containsKey(i) || !((IntMap)this.h.get(i)).containsKey(((SpawnTile.AllowedEnemyConfig)array1.get(b1)).enemyType.ordinal())) {
/* 540 */           this.n.add(new Map.EnemyTypeSpawnPair(((SpawnTile.AllowedEnemyConfig)array1.get(b1)).enemyType, spawnTile));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 545 */     return this.n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Path getDefaultPath(EnemyType paramEnemyType, SpawnTile paramSpawnTile) {
/* 554 */     if (paramSpawnTile == null) {
/* 555 */       throw new IllegalArgumentException("spawnTile is null");
/*     */     }
/*     */     
/* 558 */     rebuildPathfindingIfNeeded();
/*     */     
/* 560 */     int i = a((Tile)paramSpawnTile);
/*     */     
/* 562 */     if (!this.h.containsKey(i)) {
/* 563 */       if (this.throwExceptionOnMissingPath) {
/* 564 */         a.e(this.h.size + " total paths:", new Object[0]);
/* 565 */         for (IntMap.Entry entry : this.h) {
/* 566 */           a.e(" - " + entry.key + " " + entry.value, new Object[0]);
/*     */         }
/* 568 */         throw new IllegalArgumentException("No paths from " + paramSpawnTile);
/*     */       } 
/* 570 */       return null;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 579 */     EnemyType enemyType = EnemyType.getMainEnemyType((EnemyType)entry);
/*     */     IntMap intMap;
/* 581 */     if (!(intMap = (IntMap)this.h.get(i)).containsKey(enemyType.ordinal())) {
/* 582 */       if (this.throwExceptionOnMissingPath) {
/* 583 */         throw new IllegalArgumentException("No paths from " + paramSpawnTile + " for enemy type " + enemyType.name());
/*     */       }
/* 585 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 589 */     return (Path)intMap.get(enemyType.ordinal());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 595 */     rebuildPathfindingIfNeeded();
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
/*     */   public final void drawDebug(Batch paramBatch) {
/* 607 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_PATHFINDING) != 0.0D) {
/*     */       
/* 609 */       ResourcePack.AtlasTextureRegion atlasTextureRegion = Game.i.assetManager.getBlankWhiteTextureRegion();
/*     */       BitmapFont bitmapFont;
/* 611 */       (bitmapFont = Game.i.assetManager.getDebugFont(false)).setColor(1.0F, 0.3F, 1.0F, 0.56F);
/* 612 */       for (byte b = 0; b < this.pathfindingNodes.size; b++) {
/* 613 */         HeavyPathNode heavyPathNode = ((HeavyPathNode[])this.pathfindingNodes.items)[b];
/* 614 */         for (byte b1 = 0; b1 < heavyPathNode.connections.size; b1++) {
/*     */           Connection connection;
/* 616 */           HeavyPathNode heavyPathNode2 = (HeavyPathNode)(connection = ((Connection[])heavyPathNode.connections.items)[b1]).getFromNode();
/* 617 */           HeavyPathNode heavyPathNode1 = (HeavyPathNode)connection.getToNode();
/*     */           
/* 619 */           DrawUtils.texturedLineD(paramBatch, (TextureRegion)atlasTextureRegion, ((heavyPathNode2.x << 7) + 64), ((heavyPathNode2.y << 7) + 64), ((heavyPathNode1.x << 7) + 64), ((heavyPathNode1.y << 7) + 64), 6.0F, 1.0F, b, c);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 624 */         bitmapFont.draw(paramBatch, String.valueOf(heavyPathNode.index), (heavyPathNode.x << 7), (heavyPathNode.y << 7) + 30.0F + 64.0F, 128.0F, 1, false);
/*     */       } 
/*     */       
/* 627 */       bitmapFont.setColor(Color.WHITE);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 633 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 638 */     return "Pathfinding";
/*     */   }
/*     */   
/*     */   private static final class PathfindingParameterizedConfig
/*     */   {
/*     */     private EnemyType a;
/*     */     private int b;
/*     */     private int c;
/*     */     
/*     */     private PathfindingParameterizedConfig(PathfindingParameterizedConfig param1PathfindingParameterizedConfig) {
/* 648 */       this.a = param1PathfindingParameterizedConfig.a;
/* 649 */       this.b = param1PathfindingParameterizedConfig.b;
/* 650 */       this.c = param1PathfindingParameterizedConfig.c;
/* 651 */       this.d = param1PathfindingParameterizedConfig.d;
/* 652 */       this.e = param1PathfindingParameterizedConfig.e;
/*     */     }
/*     */ 
/*     */     
/*     */     private int d;
/*     */     private int e;
/*     */     
/*     */     private PathfindingParameterizedConfig() {}
/*     */     
/*     */     public final int hashCode() {
/*     */       int i;
/* 663 */       return i = (i = (i = (i = (i = 31 + ((this.a == null) ? -1 : this.a.ordinal())) * 31 + this.b) * 31 + this.c) * 31 + this.d) * 31 + this.e;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 668 */       if (param1Object == this) return true; 
/* 669 */       if (!(param1Object instanceof PathfindingParameterizedConfig)) return false;
/*     */       
/* 671 */       if (((PathfindingParameterizedConfig)(param1Object = param1Object)).a == this.a && ((PathfindingParameterizedConfig)param1Object).b == this.b && ((PathfindingParameterizedConfig)param1Object).c == this.c && ((PathfindingParameterizedConfig)param1Object).d == this.d && ((PathfindingParameterizedConfig)param1Object).e == this.e) return true;  return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class SharedPathfindingConfig {
/* 676 */     private final ByteArray a = new ByteArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void set(GraphPath<HeavyPathNode> param1GraphPath) {
/* 686 */       this.a.clear(); byte b; int i;
/* 687 */       for (b = 0, i = param1GraphPath.getCount(); b < i; b++) {
/* 688 */         HeavyPathNode heavyPathNode = (HeavyPathNode)param1GraphPath.get(b);
/* 689 */         this.a.add((byte)heavyPathNode.x, (byte)heavyPathNode.y);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 695 */       int i = 1; byte b; int j;
/* 696 */       for (b = 0, j = this.a.size; b < j; b++) {
/* 697 */         i = i * 31 + this.a.items[b];
/*     */       }
/* 699 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 704 */       if (param1Object == this) return true; 
/* 705 */       if (!(param1Object instanceof SharedPathfindingConfig)) return false;
/*     */       
/* 707 */       if (((SharedPathfindingConfig)(param1Object = param1Object)).a.size != this.a.size) {
/* 708 */         return false;
/*     */       }
/* 710 */       for (byte b = 0; b < this.a.size; b++) {
/* 711 */         if (((SharedPathfindingConfig)param1Object).a.items[b] != this.a.items[b]) {
/* 712 */           return false;
/*     */         }
/*     */       } 
/* 715 */       return true;
/*     */     }
/*     */     
/*     */     private SharedPathfindingConfig() {} }
/*     */   
/*     */   private static final class NoEnemyMapGraph implements IndexedGraph<HeavyPathNode> { private final Array<HeavyPathNode> a;
/*     */     
/*     */     private NoEnemyMapGraph(Array<HeavyPathNode> param1Array) {
/* 723 */       this.a = param1Array;
/*     */     }
/*     */ 
/*     */     
/*     */     public final Array<Connection<HeavyPathNode>> getConnections(HeavyPathNode param1HeavyPathNode) {
/* 728 */       return param1HeavyPathNode.connections;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getIndex(HeavyPathNode param1HeavyPathNode) {
/* 733 */       return param1HeavyPathNode.index;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getNodeCount() {
/* 738 */       return this.a.size;
/*     */     } }
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
/*     */   @Deprecated
/*     */   private static final class EnemyTypeMapGraph2
/*     */     implements IndexedGraph<HeavyPathNode>
/*     */   {
/*     */     private final Array<HeavyPathNode> a;
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
/*     */     private final Array<Array<Connection<HeavyPathNode>>> b;
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
/*     */     public final Array<Connection<HeavyPathNode>> getConnections(HeavyPathNode param1HeavyPathNode) {
/* 802 */       return ((Array[])this.b.items)[param1HeavyPathNode.index];
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getIndex(HeavyPathNode param1HeavyPathNode) {
/* 807 */       return param1HeavyPathNode.index;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getNodeCount() {
/* 812 */       return this.a.size;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class EnemyTypeMapGraph
/*     */     implements IndexedGraph<HeavyPathNode>
/*     */   {
/*     */     private final Array<HeavyPathNode> a;
/*     */     private final Map b;
/*     */     private final EnemyType c;
/*     */     private final Array<Connection<HeavyPathNode>>[] d;
/*     */     
/*     */     private EnemyTypeMapGraph(Array<HeavyPathNode> param1Array, Map param1Map, EnemyType param1EnemyType) {
/* 825 */       this.a = param1Array;
/* 826 */       this.b = param1Map;
/* 827 */       this.c = param1EnemyType;
/* 828 */       this.d = (Array<Connection<HeavyPathNode>>[])new Array[param1Array.size];
/*     */     }
/*     */ 
/*     */     
/*     */     public final Array<Connection<HeavyPathNode>> getConnections(HeavyPathNode param1HeavyPathNode) {
/*     */       Array<Connection<HeavyPathNode>> array;
/* 834 */       if ((array = this.d[param1HeavyPathNode.index]) == null) {
/* 835 */         array = new Array(true, 4, Connection.class); byte b; int i;
/* 836 */         for (b = 0, i = param1HeavyPathNode.connections.size; b < i; b++) {
/* 837 */           if (((PathConnection)((Connection[])param1HeavyPathNode.connections.items)[b]).isTeleport) {
/*     */             
/* 839 */             array.add(((Connection[])param1HeavyPathNode.connections.items)[b]);
/*     */           } else {
/*     */             Connection connection;
/*     */ 
/*     */             
/* 844 */             HeavyPathNode heavyPathNode = (HeavyPathNode)(connection = ((Connection[])param1HeavyPathNode.connections.items)[b]).getToNode();
/*     */             
/* 846 */             Gate gate = null;
/* 847 */             if (param1HeavyPathNode.y == heavyPathNode.y) {
/* 848 */               if (param1HeavyPathNode.x + 1 == heavyPathNode.x) {
/*     */                 
/* 850 */                 gate = this.b.getGate(heavyPathNode.x, heavyPathNode.y, true);
/* 851 */               } else if (heavyPathNode.x + 1 == param1HeavyPathNode.x) {
/*     */                 
/* 853 */                 gate = this.b.getGate(param1HeavyPathNode.x, param1HeavyPathNode.y, true);
/*     */               } 
/* 855 */             } else if (param1HeavyPathNode.x == heavyPathNode.x) {
/* 856 */               if (param1HeavyPathNode.y + 1 == heavyPathNode.y) {
/*     */                 
/* 858 */                 gate = this.b.getGate(heavyPathNode.x, heavyPathNode.y, false);
/* 859 */               } else if (param1HeavyPathNode.y == heavyPathNode.y + 1) {
/*     */                 
/* 861 */                 gate = this.b.getGate(param1HeavyPathNode.x, param1HeavyPathNode.y, false);
/*     */               } 
/*     */             } 
/*     */             
/* 865 */             if (!(gate instanceof GateBarrier) || ((GateBarrier)gate).canEnemyPass(this.c)) {
/*     */               
/* 867 */               array.add(connection);
/*     */             } else {
/*     */               
/* 870 */               PathConnection pathConnection = new PathConnection(this.a, ((HeavyPathNode)connection.getFromNode()).index, ((HeavyPathNode)connection.getToNode()).index, false, 6.871948E10F);
/* 871 */               array.add(pathConnection);
/*     */             } 
/*     */           } 
/* 874 */         }  this.d[param1HeavyPathNode.index] = array;
/*     */       } 
/*     */       
/* 877 */       return array;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getIndex(HeavyPathNode param1HeavyPathNode) {
/* 882 */       return param1HeavyPathNode.index;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getNodeCount() {
/* 887 */       return this.a.size;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnGateChange extends SerializableListener<PathfindingSystem> implements Listener<GateChange> {
/*     */     private OnGateChange() {}
/*     */     
/*     */     private OnGateChange(PathfindingSystem param1PathfindingSystem) {
/* 896 */       this.a = param1PathfindingSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(GateChange param1GateChange) {
/* 901 */       ((PathfindingSystem)this.a).forcePathfindingRebuild();
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnTileChange extends SerializableListener<PathfindingSystem> implements Listener<TileChange> {
/*     */     private OnTileChange() {}
/*     */     
/*     */     private OnTileChange(PathfindingSystem param1PathfindingSystem) {
/* 910 */       this.a = param1PathfindingSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(TileChange param1TileChange) {
/* 915 */       ((PathfindingSystem)this.a).forcePathfindingRebuild();
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnTowerPlace extends SerializableListener<PathfindingSystem> implements Listener<TowerPlace> {
/*     */     private OnTowerPlace() {}
/*     */     
/*     */     private OnTowerPlace(PathfindingSystem param1PathfindingSystem) {
/* 924 */       this.a = param1PathfindingSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(TowerPlace param1TowerPlace) {
/* 929 */       if (((PathfindingSystem)this.a).isWalkablePlatforms())
/* 930 */         ((PathfindingSystem)this.a).forcePathfindingRebuild(); 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnModifierPlace
/*     */     extends SerializableListener<PathfindingSystem> implements Listener<ModifierPlace> {
/*     */     private OnModifierPlace() {}
/*     */     
/*     */     private OnModifierPlace(PathfindingSystem param1PathfindingSystem) {
/* 940 */       this.a = param1PathfindingSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(ModifierPlace param1ModifierPlace) {
/* 945 */       if (((PathfindingSystem)this.a).isWalkablePlatforms())
/* 946 */         ((PathfindingSystem)this.a).forcePathfindingRebuild(); 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnBuildingRemove
/*     */     extends SerializableListener<PathfindingSystem> implements Listener<BuildingRemove> {
/*     */     private OnBuildingRemove() {}
/*     */     
/*     */     private OnBuildingRemove(PathfindingSystem param1PathfindingSystem) {
/* 956 */       this.a = param1PathfindingSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(BuildingRemove param1BuildingRemove) {
/* 961 */       if (((PathfindingSystem)this.a).isWalkablePlatforms())
/* 962 */         ((PathfindingSystem)this.a).forcePathfindingRebuild(); 
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnGameValuesRecalculate
/*     */     extends SerializableListener<PathfindingSystem> implements Listener<GameValuesRecalculate> {
/*     */     private OnGameValuesRecalculate() {}
/*     */     
/*     */     public OnGameValuesRecalculate(PathfindingSystem param1PathfindingSystem) {
/* 972 */       this.a = param1PathfindingSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(GameValuesRecalculate param1GameValuesRecalculate) {
/* 977 */       if (((PathfindingSystem)this.a).S.gameValue.getBooleanValue(GameValueType.ENEMIES_WALK_ON_PLATFORMS) != PathfindingSystem.a((PathfindingSystem)this.a))
/* 978 */         PathfindingSystem.b((PathfindingSystem)this.a); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\PathfindingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */