/*      */ package com.prineside.tdi2.systems;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.OrthographicCamera;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*      */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.FloatArray;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.tdi2.Action;
/*      */ import com.prineside.tdi2.Building;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Enemy;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystem;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.Gate;
/*      */ import com.prineside.tdi2.Map;
/*      */ import com.prineside.tdi2.Miner;
/*      */ import com.prineside.tdi2.Modifier;
/*      */ import com.prineside.tdi2.SerializableListener;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.Tower;
/*      */ import com.prineside.tdi2.Unit;
/*      */ import com.prineside.tdi2.Wave;
/*      */ import com.prineside.tdi2.actions.CoreUpgradeAction;
/*      */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*      */ import com.prineside.tdi2.enums.ActionType;
/*      */ import com.prineside.tdi2.enums.BuildingType;
/*      */ import com.prineside.tdi2.enums.ShapeType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.events.Event;
/*      */ import com.prineside.tdi2.events.Listener;
/*      */ import com.prineside.tdi2.events.game.BuildingRemove;
/*      */ import com.prineside.tdi2.events.game.CoreTileLevelUp;
/*      */ import com.prineside.tdi2.events.game.CoreTileUpgradeInstall;
/*      */ import com.prineside.tdi2.events.game.EnemyDespawn;
/*      */ import com.prineside.tdi2.events.game.EnemySpawn;
/*      */ import com.prineside.tdi2.events.game.GameValuesRecalculate;
/*      */ import com.prineside.tdi2.events.game.GateChange;
/*      */ import com.prineside.tdi2.events.game.MapSizeChange;
/*      */ import com.prineside.tdi2.events.game.MinerPlace;
/*      */ import com.prineside.tdi2.events.game.MinerRemove;
/*      */ import com.prineside.tdi2.events.game.ModifierPlace;
/*      */ import com.prineside.tdi2.events.game.NextWaveForce;
/*      */ import com.prineside.tdi2.events.game.TileChange;
/*      */ import com.prineside.tdi2.events.game.TowerPlace;
/*      */ import com.prineside.tdi2.events.game.UnitDespawn;
/*      */ import com.prineside.tdi2.events.game.UnitSpawn;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.shapes.RangeCircle;
/*      */ import com.prineside.tdi2.tiles.CoreTile;
/*      */ import com.prineside.tdi2.tiles.PlatformTile;
/*      */ import com.prineside.tdi2.tiles.SourceTile;
/*      */ import com.prineside.tdi2.utils.AABB;
/*      */ import com.prineside.tdi2.utils.AABBCounter;
/*      */ import com.prineside.tdi2.utils.DrawUtils;
/*      */ import com.prineside.tdi2.utils.EntityUtils;
/*      */ import com.prineside.tdi2.utils.FloatSorter;
/*      */ import com.prineside.tdi2.utils.Intersector;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.ObjectFilter;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.WaveBossSupplier;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.Arrays;
/*      */ 
/*      */ @REGS
/*      */ public final class MapSystem
/*      */   extends GameSystem {
/*   85 */   private static final TLog a = TLog.forClass(MapSystem.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   92 */   private static final Color b = new Color(1286557730);
/*   93 */   public static final Color TOWER_RANGE_SELECTED_COLOR = new Color(12375074);
/*   94 */   public static final Color TOWER_RANGE_HOVER_COLOR = new Color(-239);
/*      */   @NAGS
/*   96 */   private final Array<Tile> c = new Array(); @NAGS
/*   97 */   private final Array<Gate> d = new Array(); @NAGS
/*      */   public boolean drawPathTraces = true; @NAGS
/*      */   private float e;
/*      */   @NAGS
/*      */   private RangeCircle f;
/*      */   @NAGS
/*      */   private boolean g = false;
/*      */   @NAGS
/*      */   private float h;
/*  106 */   public DelayedRemovalArray<Enemy.EnemyReference> spawnedEnemies = new DelayedRemovalArray(false, 8, Enemy.EnemyReference.class);
/*  107 */   public DelayedRemovalArray<Unit> spawnedUnits = new DelayedRemovalArray(false, 8, Unit.class);
/*      */   
/*      */   private Map i;
/*      */   private boolean j;
/*      */   private boolean k;
/*      */   private boolean[][] l;
/*      */   private short[][] m;
/*      */   private boolean n;
/*      */   @NAGS
/*  116 */   private final AABB.Factory<Enemy.EnemyReference> o = new AABB.Factory(Enemy.EnemyReference.class, 102.4F); @NAGS
/*      */   private AABB<Enemy.EnemyReference> p; @NAGS
/*      */   private AABBCounter q;
/*      */   @NAGS
/*  120 */   private final RayCastSortedFilter r = new RayCastSortedFilter((byte)0); @NAGS
/*  121 */   private final RayCastSortedRetriever s = new RayCastSortedRetriever(new FloatSorter(), (byte)0);
/*      */   @NAGS
/*  123 */   private final DelayedRemovalArray<RCD> t = new DelayedRemovalArray(true, 1, RCD.class); @NAGS
/*  124 */   private final DelayedRemovalArray<COLD_Circle> u = new DelayedRemovalArray(true, 1, COLD_Circle.class); @NAGS
/*  125 */   private final DelayedRemovalArray<DBG_DirtyTile> v = new DelayedRemovalArray(true, 1, DBG_DirtyTile.class);
/*      */ 
/*      */   
/*      */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  129 */     super.write(paramKryo, paramOutput);
/*  130 */     paramKryo.writeObject(paramOutput, this.spawnedEnemies);
/*  131 */     paramKryo.writeObject(paramOutput, this.spawnedUnits);
/*  132 */     paramKryo.writeObjectOrNull(paramOutput, this.i, Map.class);
/*  133 */     paramOutput.writeBoolean(this.j);
/*  134 */     paramOutput.writeBoolean(this.k);
/*  135 */     paramKryo.writeObject(paramOutput, this.l);
/*  136 */     paramKryo.writeObject(paramOutput, this.m);
/*  137 */     paramOutput.writeBoolean(this.n);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void read(Kryo paramKryo, Input paramInput) {
/*  143 */     super.read(paramKryo, paramInput);
/*  144 */     this.spawnedEnemies = (DelayedRemovalArray<Enemy.EnemyReference>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*  145 */     this.spawnedUnits = (DelayedRemovalArray<Unit>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*  146 */     this.i = (Map)paramKryo.readObjectOrNull(paramInput, Map.class);
/*  147 */     this.j = paramInput.readBoolean();
/*  148 */     this.k = paramInput.readBoolean();
/*  149 */     this.l = (boolean[][])paramKryo.readObject(paramInput, boolean[][].class);
/*  150 */     this.m = (short[][])paramKryo.readObject(paramInput, short[][].class);
/*  151 */     this.n = paramInput.readBoolean();
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean affectsGameState() {
/*  156 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean aabbGenerated() {
/*  165 */     return (this.p != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a() {
/*  172 */     if (this.i == null)
/*      */       return; 
/*  174 */     if (this.S == null) throw new IllegalStateException("System is not registered yet");
/*      */     
/*  176 */     if (this.S.gameState != null) this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  178 */     DelayedRemovalArray delayedRemovalArray1 = this.i.getAllTiles(); int i;
/*  179 */     for (byte b = 0; b < i; b++) {
/*  180 */       ((Tile[])((Array)delayedRemovalArray1).items)[b].setRegistered(this.S);
/*      */     }
/*      */     
/*  183 */     DelayedRemovalArray delayedRemovalArray2 = this.i.getAllGates();
/*  184 */     for (i = 0; i < ((Array)delayedRemovalArray2).size; i++) {
/*  185 */       ((Gate[])((Array)delayedRemovalArray2).items)[i].setRegistered(this.S);
/*      */     }
/*      */   }
/*      */   
/*      */   private void b() {
/*  190 */     if (this.i == null)
/*      */       return; 
/*  192 */     DelayedRemovalArray delayedRemovalArray1 = this.i.getAllTiles(); int i;
/*  193 */     for (byte b = 0; b < i; b++) {
/*  194 */       ((Tile[])((Array)delayedRemovalArray1).items)[b].setUnregistered();
/*      */     }
/*      */     
/*  197 */     DelayedRemovalArray delayedRemovalArray2 = this.i.getAllGates();
/*  198 */     for (i = 0; i < ((Array)delayedRemovalArray2).size; i++) {
/*  199 */       ((Gate[])((Array)delayedRemovalArray2).items)[i].setUnregistered();
/*      */     }
/*      */   }
/*      */   
/*      */   public final Map getMap() {
/*  204 */     return this.i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void getTileAndNeighbours(int paramInt1, int paramInt2, Array<Tile> paramArray) {
/*  211 */     for (byte b = -1; b <= 1; b++) {
/*  212 */       for (byte b1 = -1; b1 <= 1; b1++) {
/*      */         Tile tile;
/*  214 */         if ((tile = this.i.getTile(paramInt1 + b, paramInt2 + b1)) != null) {
/*  215 */           paramArray.add(tile);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void setMap(Map paramMap) {
/*  222 */     if (this.i != null) {
/*  223 */       for (byte b = 0; b < paramMap.getHeight(); b++) {
/*  224 */         for (byte b1 = 0; b1 < paramMap.getWidth(); b1++) {
/*      */           Tile tile;
/*  226 */           if ((tile = paramMap.getTile(b1, b)) != null && tile.isRegistered()) {
/*  227 */             tile.setUnregistered();
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*  233 */     this.i = paramMap;
/*      */ 
/*      */     
/*  236 */     this.l = new boolean[paramMap.getHeight()][paramMap.getWidth()];
/*  237 */     this.m = new short[paramMap.getHeight()][paramMap.getWidth()];
/*      */     
/*  239 */     a();
/*      */     
/*  241 */     if (this.j) {
/*  242 */       d();
/*      */     } else {
/*  244 */       this.k = true;
/*      */     } 
/*      */     
/*  247 */     markAllTilesDirty();
/*      */   }
/*      */   
/*      */   public final void setMapSize(int paramInt1, int paramInt2) {
/*  251 */     if (this.i.getWidth() == paramInt1 && this.i.getHeight() == paramInt2)
/*      */       return; 
/*  253 */     this.i.setSize(paramInt1, paramInt2);
/*  254 */     this.l = new boolean[this.i.getHeight()][this.i.getWidth()];
/*  255 */     this.m = new short[this.i.getHeight()][this.i.getWidth()];
/*  256 */     markAllTilesDirty();
/*      */     
/*  258 */     this.S.events.trigger((Event)new MapSizeChange());
/*      */   }
/*      */   
/*      */   public final short getDirtyTileGeneration(Tile paramTile) {
/*  262 */     return getDirtyTileGenerationAt(paramTile.getX(), paramTile.getY());
/*      */   }
/*      */   
/*      */   public final short getDirtyTileGenerationAt(int paramInt1, int paramInt2) {
/*  266 */     if (paramInt1 < 0 || paramInt2 < 0 || paramInt1 >= this.i.getWidth() || paramInt2 >= this.i.getHeight()) {
/*  267 */       return 0;
/*      */     }
/*      */     
/*  270 */     return this.m[paramInt2][paramInt1];
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void updateDirtyTiles() {
/*  276 */     if (this.l.length != this.i.getHeight() || (this.l[0]).length != this.i.getWidth()) {
/*  277 */       a.i("map size changed, updating all tiles", new Object[0]);
/*  278 */       this.l = new boolean[this.i.getHeight()][this.i.getWidth()];
/*  279 */       this.m = new short[this.i.getHeight()][this.i.getWidth()];
/*  280 */       markAllTilesDirty();
/*      */     } 
/*      */     
/*  283 */     boolean bool = (!Config.isHeadless() && g()) ? true : false;
/*  284 */     for (byte b = 0; b < this.i.getHeight(); b++) {
/*  285 */       for (byte b1 = 0; b1 < this.i.getWidth(); b1++) {
/*  286 */         if (this.l[b][b1]) {
/*  287 */           Tile tile = this.i.getTile(b1, b);
/*  288 */           this.l[b][b1] = false;
/*  289 */           this.m[b][b1] = (short)(this.m[b][b1] + 1);
/*  290 */           if (tile != null) {
/*  291 */             tile.updateCache();
/*  292 */             if (bool) {
/*      */               DBG_DirtyTile dBG_DirtyTile;
/*  294 */               (dBG_DirtyTile = new DBG_DirtyTile((byte)0)).b = tile.getX();
/*  295 */               dBG_DirtyTile.c = tile.getY();
/*  296 */               this.v.add(dBG_DirtyTile);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void markAllTilesDirty() {
/*  305 */     if (this.S.gameState != null) {
/*  306 */       this.S.gameState.checkGameplayUpdateAllowed(); boolean[][] arrayOfBoolean; int i; byte b;
/*  307 */       for (i = (arrayOfBoolean = this.l).length, b = 0; b < i; b++) {
/*  308 */         boolean[] arrayOfBoolean1; Arrays.fill(arrayOfBoolean1 = arrayOfBoolean[b], true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void markTilesDirtyNearTile(Tile paramTile, int paramInt) {
/*  314 */     markTilesDirty(paramTile.getX(), paramTile.getY(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void markTilesDirty(int paramInt1, int paramInt2, int paramInt3) {
/*  322 */     for (int i = paramInt2 - paramInt3; i <= paramInt2 + paramInt3; i++) {
/*  323 */       for (int j = paramInt1 - paramInt3; j <= paramInt1 + paramInt3; j++) {
/*  324 */         if (this.i.getTile(j, i) != null) {
/*  325 */           this.l[i][j] = true;
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void c() {
/*  333 */     if (this.q == null) {
/*  334 */       this.q = new AABBCounter(42.24F);
/*      */     }
/*      */     
/*  337 */     DelayedRemovalArray delayedRemovalArray = this.i.getAllTiles(); byte b;
/*  338 */     for (b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/*  339 */       ((Tile)delayedRemovalArray.get(b)).enemyCount = 0;
/*      */     }
/*      */     
/*  342 */     this.o.reset();
/*  343 */     this.q.reset(); int i;
/*  344 */     for (b = 0, i = this.spawnedEnemies.size; b < i; b++) {
/*      */       Enemy.EnemyReference enemyReference;
/*      */       Enemy enemy;
/*  347 */       if ((enemy = (enemyReference = ((Enemy.EnemyReference[])this.spawnedEnemies.items)[b]).enemy) != null) {
/*      */         
/*  349 */         Vector2 vector2 = enemy.getPosition();
/*  350 */         this.o.add(enemyReference, vector2.x, vector2.y, enemy.getSize());
/*  351 */         this.q.add(vector2.x, vector2.y, 64.0F);
/*      */         Tile tile;
/*  353 */         if (!enemy.disabled.isTrue() && (
/*      */           
/*  355 */           tile = this.i.getTileByMapPos(vector2.x, vector2.y)) != null) {
/*  356 */           tile.enemyCount++;
/*      */         }
/*      */       } 
/*      */     } 
/*  360 */     this.p = this.o.bake(this.p);
/*  361 */     this.q.bake();
/*      */ 
/*      */     
/*  364 */     for (b = 0, i = this.spawnedEnemies.size; b < i; b++) {
/*      */       Enemy.EnemyReference enemyReference;
/*      */       Enemy enemy;
/*  367 */       if ((enemy = (enemyReference = ((Enemy.EnemyReference[])this.spawnedEnemies.items)[b]).enemy) != null) {
/*      */         
/*  369 */         enemy.otherEnemiesNearby = this.q.getEntityCount((enemy.getPosition()).x, (enemy.getPosition()).y);
/*      */ 
/*      */ 
/*      */         
/*  373 */         enemy.otherEnemiesNearby--;
/*  374 */         if (enemy.otherEnemiesNearby < 0) {
/*  375 */           enemy.otherEnemiesNearby = 0;
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void getEnemiesInRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, AABB.EntryRetriever<Enemy.EnemyReference> paramEntryRetriever) {
/*  384 */     if (!this.p.entriesExistInRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4)) {
/*      */       return;
/*      */     }
/*  387 */     this.p.traverseEntriesInRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, (paramFloat5, paramFloat6, paramFloat7) -> 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  392 */         (paramFloat5 + paramFloat7 > paramFloat1 && paramFloat6 + paramFloat7 > paramFloat2 && paramFloat5 - paramFloat7 < paramFloat3 && paramFloat6 - paramFloat7 < paramFloat4), paramEntryRetriever);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void getEnemiesInRectFiltered(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, AABB.EntryFilter paramEntryFilter, AABB.EntryRetriever<Enemy.EnemyReference> paramEntryRetriever) {
/*  398 */     if (!this.p.entriesExistInRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4)) {
/*      */       return;
/*      */     }
/*  401 */     this.p.traverseEntriesInRect(paramFloat1, paramFloat2, paramFloat3, paramFloat4, (paramFloat5, paramFloat6, paramFloat7) -> 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  406 */         (paramFloat5 + paramFloat7 > paramFloat1 && paramFloat6 + paramFloat7 > paramFloat2 && paramFloat5 - paramFloat7 < paramFloat3 && paramFloat6 - paramFloat7 < paramFloat4 && paramEntryFilter.test(paramFloat5, paramFloat6, paramFloat7)), paramEntryRetriever);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void getEnemiesInRectV(Vector2 paramVector21, Vector2 paramVector22, AABB.EntryRetriever<Enemy.EnemyReference> paramEntryRetriever) {
/*  412 */     getEnemiesInRect(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y, paramEntryRetriever);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void getEnemiesInCircleFiltered(float paramFloat1, float paramFloat2, float paramFloat3, AABB.EntryFilter paramEntryFilter, AABB.EntryRetriever<Enemy.EnemyReference> paramEntryRetriever) {
/*  419 */     float f1 = paramFloat1 - paramFloat3;
/*  420 */     float f2 = paramFloat2 - paramFloat3;
/*  421 */     float f3 = paramFloat1 + paramFloat3;
/*  422 */     float f4 = paramFloat2 + paramFloat3;
/*  423 */     if (!this.p.entriesExistInRect(f1, f2, f3, f4)) {
/*      */       return;
/*      */     }
/*      */     
/*  427 */     if (h()) {
/*      */       COLD_Circle cOLD_Circle;
/*  429 */       (cOLD_Circle = new COLD_Circle((byte)0)).b = paramFloat1;
/*  430 */       cOLD_Circle.c = paramFloat2;
/*  431 */       cOLD_Circle.d = paramFloat3;
/*  432 */       cOLD_Circle.e = MaterialColor.CYAN.P500;
/*  433 */       this.u.add(cOLD_Circle);
/*      */       
/*  435 */       this.p.traverseEntriesInRect(f1, f2, f3, f4, (paramFloat4, paramFloat5, paramFloat6) -> 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  440 */           (PMath.circleIntersectsCircle(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6) && paramEntryFilter.test(paramFloat4, paramFloat5, paramFloat6)), (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*      */             paramCOLD_Circle.f.add(paramFloat1, paramFloat2, paramFloat3);
/*      */             
/*      */             return paramEntryRetriever.retrieve(paramEnemyReference, paramFloat1, paramFloat2, paramFloat3);
/*      */           });
/*      */       return;
/*      */     } 
/*  447 */     this.p.traverseEntriesInRect(f1, f2, f3, f4, (paramFloat4, paramFloat5, paramFloat6) -> 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  452 */         (PMath.circleIntersectsCircle(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6) && paramEntryFilter.test(paramFloat4, paramFloat5, paramFloat6)), paramEntryRetriever);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void getEnemiesInCircle(float paramFloat1, float paramFloat2, float paramFloat3, AABB.EntryRetriever<Enemy.EnemyReference> paramEntryRetriever) {
/*  459 */     float f1 = paramFloat1 - paramFloat3;
/*  460 */     float f2 = paramFloat2 - paramFloat3;
/*  461 */     float f3 = paramFloat1 + paramFloat3;
/*  462 */     float f4 = paramFloat2 + paramFloat3;
/*  463 */     if (!this.p.entriesExistInRect(f1, f2, f3, f4)) {
/*      */       return;
/*      */     }
/*  466 */     if (h()) {
/*      */       COLD_Circle cOLD_Circle;
/*  468 */       (cOLD_Circle = new COLD_Circle((byte)0)).b = paramFloat1;
/*  469 */       cOLD_Circle.c = paramFloat2;
/*  470 */       cOLD_Circle.d = paramFloat3;
/*  471 */       cOLD_Circle.e = MaterialColor.CYAN.P500;
/*  472 */       this.u.add(cOLD_Circle);
/*      */       
/*  474 */       this.p.traverseEntriesInRect(f1, f2, f3, f4, (paramFloat4, paramFloat5, paramFloat6) -> PMath.circleIntersectsCircle(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6), (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*      */             paramCOLD_Circle.f.add(paramFloat1, paramFloat2, paramFloat3);
/*      */ 
/*      */             
/*      */             return paramEntryRetriever.retrieve(paramEnemyReference, paramFloat1, paramFloat2, paramFloat3);
/*      */           });
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/*  486 */     this.p.traverseEntriesInRect(f1, f2, f3, f4, (paramFloat4, paramFloat5, paramFloat6) -> PMath.circleIntersectsCircle(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6), paramEntryRetriever);
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
/*      */   public final void getEnemiesInCircleV(Vector2 paramVector2, float paramFloat, AABB.EntryRetriever<Enemy.EnemyReference> paramEntryRetriever) {
/*  498 */     getEnemiesInCircle(paramVector2.x, paramVector2.y, paramFloat, paramEntryRetriever);
/*      */   }
/*      */   
/*      */   private void d() {
/*      */     byte b;
/*  503 */     for (b = 0; b < this.i.getHeight(); b++) {
/*  504 */       for (byte b1 = 0; b1 < this.i.getWidth(); b1++) {
/*      */         PlatformTile platformTile; Tile tile;
/*  506 */         if (tile = this.i.getTile(b1, b) instanceof PlatformTile) {
/*      */           
/*  508 */           if ((platformTile = (PlatformTile)tile).building != null && 
/*  509 */             platformTile.building.buildingType == BuildingType.TOWER) {
/*  510 */             Tower tower = (Tower)platformTile.building;
/*  511 */             platformTile.building.setTile(null);
/*  512 */             platformTile.building = null;
/*      */             
/*  514 */             setTower(platformTile.getX(), platformTile.getY(), tower);
/*      */           } 
/*      */         } else {
/*  517 */           SourceTile sourceTile; if (platformTile instanceof SourceTile && 
/*      */             
/*  519 */             (sourceTile = (SourceTile)platformTile).miner != null) {
/*      */             Miner miner;
/*  521 */             (miner = sourceTile.miner).setTile(null);
/*  522 */             sourceTile.miner = null;
/*      */             
/*  524 */             this.S.miner.register(miner);
/*  525 */             miner.setInstallTime(0.001F);
/*  526 */             setMiner(sourceTile.getX(), sourceTile.getY(), miner);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  533 */     for (b = 0; b < this.i.getHeight(); b++) {
/*  534 */       for (byte b1 = 0; b1 < this.i.getWidth(); b1++) {
/*      */         PlatformTile platformTile; Tile tile;
/*  536 */         if (tile = this.i.getTile(b1, b) instanceof PlatformTile && 
/*      */           
/*  538 */           (platformTile = (PlatformTile)tile).building != null && 
/*  539 */           platformTile.building.buildingType == BuildingType.MODIFIER) {
/*  540 */           Modifier modifier = (Modifier)platformTile.building;
/*  541 */           platformTile.building.setTile(null);
/*  542 */           platformTile.building = null;
/*      */           
/*  544 */           setModifier(platformTile.getX(), platformTile.getY(), modifier);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setup() {
/*  554 */     this.S.events.getListeners(NextWaveForce.class).addStateAffecting(new OnNextWaveForce(this, (byte)0)).setDescription("MapSystem - increases cores double speed");
/*  555 */     this.S.events.getListeners(GameValuesRecalculate.class).addStateAffecting(new OnGameValuesRecalculate(this)).setDescription("MapSystem - updates walkablePlatforms setting and marks all tiles dirty");
/*      */ 
/*      */     
/*  558 */     a();
/*      */     
/*  560 */     if (!this.S.CFG.headless) e();
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public final void postStateRestore() {
/*  566 */     e();
/*      */   }
/*      */   
/*      */   private void e() {
/*  570 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MAP_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawBatch(paramBatch, paramFloat2)))
/*      */ 
/*      */         
/*  573 */         .setName("Map-draw"));
/*      */   }
/*      */ 
/*      */   
/*      */   public final void postSetup() {
/*  578 */     this.j = true;
/*      */     
/*  580 */     if (this.k && this.S.gameState != null)
/*      */     {
/*      */       
/*  583 */       d();
/*      */     }
/*      */     
/*  586 */     markAllTilesDirty();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void showTileWarningParticle(int paramInt1, int paramInt2) {
/*  591 */     if (this.S._particle != null) {
/*      */       ParticleEffectPool.PooledEffect pooledEffect;
/*  593 */       (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.mapManager.tileWarningParticlePool.obtain()).setPosition(((paramInt1 << 7) + 64), ((paramInt2 << 7) + 64));
/*  594 */       this.S._particle.addParticle((ParticleEffect)pooledEffect, false);
/*      */     } 
/*      */   }
/*      */   public final void removeHighlights() {
/*      */     byte b;
/*  599 */     for (b = 0; b < this.c.size; b++) {
/*      */       Tile tile;
/*  601 */       (tile = (Tile)this.c.get(b)).highlightParticleA.allowCompletion();
/*  602 */       tile.highlightParticleA = null;
/*  603 */       tile.highlightParticleB.allowCompletion();
/*  604 */       tile.highlightParticleB = null;
/*      */     } 
/*  606 */     this.c.clear();
/*  607 */     for (b = 0; b < this.d.size; b++) {
/*      */       Gate gate;
/*  609 */       (gate = (Gate)this.d.get(b)).highlightParticleA.allowCompletion();
/*  610 */       gate.highlightParticleA = null;
/*  611 */       gate.highlightParticleB.allowCompletion();
/*  612 */       gate.highlightParticleB = null;
/*      */     } 
/*  614 */     this.d.clear();
/*      */   }
/*      */   
/*      */   public final void highlightTile(Tile paramTile) {
/*  618 */     paramTile.highlightParticleA = (ParticleEffectPool.PooledEffect)Game.i.mapManager.highlightParticlesPool.obtain();
/*  619 */     paramTile.highlightParticleB = (ParticleEffectPool.PooledEffect)Game.i.mapManager.highlightParticlesPool.obtain();
/*  620 */     this.S._particle.addParticle((ParticleEffect)paramTile.highlightParticleA, false);
/*  621 */     this.S._particle.addParticle((ParticleEffect)paramTile.highlightParticleB, false);
/*  622 */     this.c.add(paramTile);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void highlightGate(Gate paramGate) {
/*  627 */     paramGate.highlightParticleA = (ParticleEffectPool.PooledEffect)Game.i.mapManager.highlightParticlesPool.obtain();
/*  628 */     paramGate.highlightParticleB = (ParticleEffectPool.PooledEffect)Game.i.mapManager.highlightParticlesPool.obtain();
/*  629 */     this.S._particle.addParticle((ParticleEffect)paramGate.highlightParticleA, false);
/*  630 */     this.S._particle.addParticle((ParticleEffect)paramGate.highlightParticleB, false);
/*  631 */     this.d.add(paramGate);
/*      */   }
/*      */   
/*      */   public final boolean isPointWithinTile(Tile paramTile, int paramInt1, int paramInt2) {
/*  635 */     return paramTile.boundingBox.contains(paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   public final boolean isVisible(Tile paramTile, OrthographicCamera paramOrthographicCamera) {
/*  639 */     int j = (int)(paramOrthographicCamera.position.x - paramOrthographicCamera.viewportWidth / 2.0F);
/*  640 */     int k = (int)(paramOrthographicCamera.position.x + paramOrthographicCamera.viewportWidth / 2.0F);
/*  641 */     int m = (int)(paramOrthographicCamera.position.y - paramOrthographicCamera.viewportHeight / 2.0F);
/*  642 */     int i = (int)(paramOrthographicCamera.position.y + paramOrthographicCamera.viewportHeight / 2.0F);
/*      */     
/*  644 */     return paramTile.boundingBox.overlaps(j, m, k, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setGate(int paramInt1, int paramInt2, boolean paramBoolean, @Null Gate paramGate) {
/*      */     Gate gate;
/*  654 */     if ((gate = this.i.getGate(paramInt1, paramInt2, paramBoolean)) != null)
/*      */     {
/*  656 */       gate.setUnregistered();
/*      */     }
/*      */     
/*  659 */     this.i.setGate(paramInt1, paramInt2, paramBoolean, paramGate);
/*  660 */     if (paramGate != null) {
/*  661 */       paramGate.setRegistered(this.S);
/*      */     }
/*      */     
/*  664 */     if (this.S._mapRendering != null) this.S._mapRendering.forceTilesRedraw(true);
/*      */     
/*  666 */     this.S.events.trigger((Event)new GateChange(paramInt1, paramInt2, paramBoolean, gate, paramGate));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setTile(int paramInt1, int paramInt2, @Null Tile paramTile) {
/*      */     Tile tile;
/*  675 */     if ((tile = this.i.getTile(paramInt1, paramInt2)) == null && paramTile == null)
/*      */       return; 
/*  677 */     if (tile instanceof com.prineside.tdi2.tiles.SpawnTile && this.S.CFG.setup == GameSystemProvider.SystemsConfig.Setup.GAME) {
/*  678 */       a.e("can't remove spawn tile", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  682 */     if (tile != null) {
/*  683 */       PlatformTile platformTile; if (tile instanceof PlatformTile && 
/*      */         
/*  685 */         (platformTile = (PlatformTile)tile).building != null)
/*      */       {
/*  687 */         if (platformTile.building.buildingType == BuildingType.TOWER)
/*  688 */         { if (this.S.tower != null) this.S.tower.sellTower((Tower)platformTile.building);  }
/*  689 */         else if (platformTile.building.buildingType == BuildingType.MODIFIER && 
/*  690 */           this.S.modifier != null) { this.S.modifier.sellModifier((Modifier)platformTile.building); }
/*      */       
/*      */       }
/*      */       
/*  694 */       if (tile instanceof SourceTile && ((SourceTile)tile).miner != null)
/*      */       {
/*  696 */         if (this.S.miner != null) this.S.miner.sellMiner(tile.getX(), tile.getY());
/*      */       
/*      */       }
/*      */       
/*  700 */       tile.setUnregistered();
/*      */     } 
/*      */     
/*  703 */     this.i.setTile(paramInt1, paramInt2, paramTile);
/*  704 */     if (paramTile != null) {
/*  705 */       paramTile.setRegistered(this.S);
/*      */     }
/*      */     
/*  708 */     if (paramTile instanceof com.prineside.tdi2.tiles.BossTile || tile instanceof com.prineside.tdi2.tiles.BossTile || paramTile instanceof com.prineside.tdi2.tiles.SpawnTile) {
/*  709 */       this.n = true;
/*  710 */       if (this.S.wave != null) this.S.wave.resetNextWavesCache();
/*      */     
/*      */     } 
/*  713 */     markTilesDirty(paramInt1, paramInt2, 1);
/*      */     
/*  715 */     this.S.events.trigger((Event)new TileChange(paramInt1, paramInt2, tile, paramTile));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void registerTile(Tile paramTile) {
/*  722 */     paramTile.setRegistered(this.S);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void unregisterTile(Tile paramTile) {
/*  729 */     if (paramTile.isRegistered()) {
/*  730 */       paramTile.setUnregistered();
/*      */     }
/*      */   }
/*      */   
/*      */   public final void registerGate(Gate paramGate) {
/*  735 */     paramGate.setRegistered(this.S);
/*      */   }
/*      */   
/*      */   public final void unregisterGate(Gate paramGate) {
/*  739 */     if (paramGate.isRegistered()) {
/*  740 */       paramGate.setUnregistered();
/*      */     }
/*      */   }
/*      */   
/*      */   public final void setTower(int paramInt1, int paramInt2, Tower paramTower) {
/*  745 */     if (this.S.gameState != null) this.S.gameState.checkGameplayUpdateAllowed();
/*      */ 
/*      */     
/*      */     Tile tile;
/*  749 */     if ((tile = this.i.getTile(paramInt1, paramInt2)).type != TileType.PLATFORM) {
/*  750 */       throw new IllegalArgumentException("Tile at " + paramInt1 + ":" + paramInt2 + " is " + tile.type.name() + ", can't place tower here");
/*      */     }
/*      */     
/*      */     PlatformTile platformTile;
/*  754 */     if ((platformTile = (PlatformTile)tile).building != null) {
/*  755 */       removeBuilding(platformTile.building);
/*      */     }
/*      */     
/*  758 */     platformTile.building = (Building)paramTower;
/*  759 */     paramTower.setTile(platformTile);
/*      */     
/*  761 */     this.S.events.trigger((Event)new TowerPlace(paramTower));
/*      */     
/*  763 */     markTilesDirtyNearTile((Tile)platformTile, 1);
/*  764 */     paramTower.placedOnMap();
/*      */   }
/*      */   
/*      */   public final void setModifier(int paramInt1, int paramInt2, Modifier paramModifier) {
/*  768 */     if (this.S.gameState != null) this.S.gameState.checkGameplayUpdateAllowed();
/*      */ 
/*      */     
/*      */     Tile tile;
/*  772 */     if ((tile = this.i.getTile(paramInt1, paramInt2)).type != TileType.PLATFORM) {
/*  773 */       throw new IllegalArgumentException("Tile at " + paramInt1 + ":" + paramInt2 + " is " + tile.type.name() + ", can't place modifier here");
/*      */     }
/*      */     
/*      */     PlatformTile platformTile;
/*  777 */     if ((platformTile = (PlatformTile)tile).building != null) {
/*  778 */       removeBuilding(platformTile.building);
/*      */     }
/*      */     
/*  781 */     platformTile.building = (Building)paramModifier;
/*  782 */     paramModifier.setTile(platformTile);
/*      */     
/*  784 */     this.S.events.trigger((Event)new ModifierPlace(paramModifier));
/*      */     
/*  786 */     paramModifier.placedOnMap();
/*  787 */     markTilesDirtyNearTile(tile, 1);
/*      */   }
/*      */   
/*      */   public final void removeBuilding(Building paramBuilding) {
/*  791 */     if (this.S.gameState != null) this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  793 */     PlatformTile platformTile = paramBuilding.getTile();
/*      */     
/*  795 */     paramBuilding.setTile(null);
/*  796 */     platformTile.building = null;
/*  797 */     paramBuilding.removedFromMap();
/*      */     
/*  799 */     this.S.events.trigger((Event)new BuildingRemove(paramBuilding, platformTile));
/*  800 */     markTilesDirtyNearTile((Tile)platformTile, 1);
/*      */   }
/*      */   
/*      */   public final void setMiner(int paramInt1, int paramInt2, Miner paramMiner) {
/*  804 */     if (this.S.gameState != null) this.S.gameState.checkGameplayUpdateAllowed();
/*      */ 
/*      */     
/*      */     Tile tile;
/*  808 */     if ((tile = this.i.getTile(paramInt1, paramInt2)).type != TileType.SOURCE) {
/*  809 */       throw new IllegalArgumentException("Tile at " + paramInt1 + ":" + paramInt2 + " is " + tile.type.name() + ", can't place miner here");
/*      */     }
/*      */     
/*      */     SourceTile sourceTile;
/*  813 */     if ((sourceTile = (SourceTile)tile).miner != null) {
/*  814 */       removeMiner(sourceTile.miner);
/*      */     }
/*      */     
/*  817 */     sourceTile.miner = paramMiner;
/*  818 */     paramMiner.setTile(sourceTile);
/*  819 */     paramMiner.placedOnMap();
/*      */     
/*  821 */     markTilesDirtyNearTile(tile, 1);
/*  822 */     this.S.events.trigger((Event)new MinerPlace(paramMiner));
/*      */   }
/*      */   
/*      */   public final void removeMiner(Miner paramMiner) {
/*  826 */     if (this.S.gameState != null) this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  828 */     SourceTile sourceTile = paramMiner.getTile();
/*      */     
/*  830 */     paramMiner.setTile(null);
/*  831 */     sourceTile.miner = null;
/*  832 */     paramMiner.removedFromMap();
/*      */     
/*  834 */     markTilesDirtyNearTile((Tile)sourceTile, 1);
/*  835 */     this.S.events.trigger((Event)new MinerRemove(paramMiner, sourceTile));
/*      */   }
/*      */   
/*      */   public final boolean isSpawned(Unit paramUnit) {
/*  839 */     return paramUnit.spawned;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void spawnEnemy(Enemy paramEnemy) {
/*  848 */     if (this.S.gameState != null) this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  850 */     if (!paramEnemy.isRegistered()) {
/*  851 */       throw new IllegalArgumentException("Enemy is not registered " + paramEnemy);
/*      */     }
/*      */     
/*  854 */     Enemy.EnemyReference enemyReference = this.S.enemy.getReference(paramEnemy);
/*  855 */     if (this.spawnedEnemies.contains(enemyReference, true)) {
/*  856 */       throw new IllegalStateException("Enemy " + paramEnemy + " is already spawned");
/*      */     }
/*      */     
/*  859 */     this.spawnedEnemies.add(enemyReference);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  865 */     this.S.events.trigger((Event)new EnemySpawn(paramEnemy));
/*      */     
/*  867 */     paramEnemy.onSpawned();
/*      */   }
/*      */   
/*      */   final void a(Unit paramUnit) {
/*  871 */     if (this.S.gameState != null) this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  873 */     if (isSpawned(paramUnit)) {
/*  874 */       this.spawnedUnits.removeValue(paramUnit, true);
/*  875 */       paramUnit.spawned = false;
/*      */       
/*  877 */       this.S.events.trigger((Event)new UnitDespawn(paramUnit));
/*  878 */       paramUnit.onDespawned(); return;
/*      */     } 
/*  880 */     a.e("Unit is not spawned", new Object[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void spawnUnit(Unit paramUnit) {
/*  885 */     if (this.S.gameState != null) this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  887 */     if (!isSpawned(paramUnit)) {
/*  888 */       this.spawnedUnits.add(paramUnit);
/*  889 */       paramUnit.spawned = true;
/*      */       
/*  891 */       this.S.events.trigger((Event)new UnitSpawn(paramUnit));
/*      */       
/*  893 */       paramUnit.onSpawned(); return;
/*      */     } 
/*  895 */     a.e("Unit is already spawned", new Object[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   final void a(Enemy paramEnemy) {
/*  900 */     if (this.S.gameState != null) this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  902 */     if (!EntityUtils.removeByValue((Array)this.spawnedEnemies, paramEnemy)) {
/*  903 */       throw new IllegalArgumentException("Enemy is not in spawnedEnemies: " + paramEnemy);
/*      */     }
/*      */ 
/*      */     
/*  907 */     this.S.events.trigger((Event)new EnemyDespawn(paramEnemy));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean lineCanHitEntry(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  918 */     return this.p.lineCanHitEntry(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*      */   }
/*      */   
/*      */   private static boolean f() {
/*  922 */     if (Config.isHeadless()) return false;
/*      */     
/*  924 */     return (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_RAYCASTS) != 0.0D);
/*      */   }
/*      */   
/*      */   private static boolean g() {
/*  928 */     if (Config.isHeadless()) return false;
/*      */     
/*  930 */     return (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DIRTY_TILES) != 0.0D);
/*      */   }
/*      */   
/*      */   private static boolean h() {
/*  934 */     if (Config.isHeadless()) return false;
/*      */     
/*  936 */     return (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_COLLISIONS) != 0.0D);
/*      */   }
/*      */   
/*      */   public final boolean rayCastEnemiesSorted(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, ObjectFilter<Enemy.EnemyReference> paramObjectFilter) {
/*  940 */     if (paramFloat5 < 0.0F) paramFloat5 = 0.0F;
/*      */     
/*  942 */     float f1 = Math.min(paramFloat1, paramFloat3) - paramFloat5;
/*  943 */     float f2 = Math.max(paramFloat1, paramFloat3) + paramFloat5;
/*  944 */     float f3 = Math.min(paramFloat2, paramFloat4) - paramFloat5;
/*  945 */     float f4 = Math.max(paramFloat2, paramFloat4) + paramFloat5;
/*      */     
/*  947 */     if (!this.p.entriesExistInRect(f1, f3, f2, f4)) {
/*  948 */       return false;
/*      */     }
/*      */     
/*      */     FloatSorter floatSorter;
/*      */     
/*  953 */     (floatSorter = RayCastSortedRetriever.a(this.s)).begin();
/*  954 */     this.p.traverseEntriesInLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, this.r
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  959 */         .setup(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5), this.s
/*  960 */         .setup(paramFloat1, paramFloat2));
/*      */ 
/*      */     
/*  963 */     RCD rCD = null;
/*  964 */     if (f()) {
/*      */       
/*  966 */       (rCD = new RCD((byte)0)).b = paramFloat1;
/*  967 */       rCD.c = paramFloat2;
/*  968 */       rCD.d = paramFloat3;
/*  969 */       rCD.e = paramFloat4;
/*  970 */       rCD.g = MaterialColor.PINK.P500;
/*  971 */       rCD.f = Math.max(1.0F, paramFloat5);
/*  972 */       this.t.add(rCD);
/*      */     } 
/*      */     
/*  975 */     Array array = floatSorter.sort(); byte b;
/*  976 */     for (b = 0; b < array.size; ) {
/*  977 */       if (rCD != null) {
/*      */         Enemy enemy;
/*      */         Enemy.EnemyReference enemyReference;
/*  980 */         Vector2 vector2 = (enemy = (enemyReference = (Enemy.EnemyReference)(((FloatSorter.Entity[])array.items)[b]).object).enemy).getPosition();
/*  981 */         rCD.h.add(vector2.x, vector2.y, enemy.getSize());
/*      */       } 
/*  983 */       if (paramObjectFilter.test((((FloatSorter.Entity[])array.items)[b]).object)) {
/*      */         b++;
/*      */       }
/*      */     } 
/*  987 */     b = (array.size != 0) ? 1 : 0;
/*  988 */     floatSorter.end();
/*      */     
/*  990 */     return b;
/*      */   }
/*      */   
/*      */   public final boolean rayCastEnemies(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, ObjectFilter<Enemy.EnemyReference> paramObjectFilter) {
/*  994 */     if (paramFloat5 < 0.0F) paramFloat5 = 0.0F;
/*      */     
/*  996 */     float f1 = Math.min(paramFloat1, paramFloat3) - paramFloat5;
/*  997 */     float f2 = Math.max(paramFloat1, paramFloat3) + paramFloat5;
/*  998 */     float f3 = Math.min(paramFloat2, paramFloat4) - paramFloat5;
/*  999 */     float f4 = Math.max(paramFloat2, paramFloat4) + paramFloat5;
/* 1000 */     if (!this.p.entriesExistInRect(f1, f3, f2, f4)) {
/* 1001 */       return false;
/*      */     }
/*      */     
/* 1004 */     boolean[] arrayOfBoolean = { false };
/*      */     
/* 1006 */     RCD rCD = null;
/* 1007 */     if (f()) {
/*      */       
/* 1009 */       (rCD = new RCD((byte)0)).b = paramFloat1;
/* 1010 */       rCD.c = paramFloat2;
/* 1011 */       rCD.d = paramFloat3;
/* 1012 */       rCD.e = paramFloat4;
/* 1013 */       rCD.g = MaterialColor.CYAN.P500;
/* 1014 */       rCD.f = Math.max(1.0F, paramFloat5);
/* 1015 */       this.t.add(rCD);
/*      */     } 
/* 1017 */     rCD = rCD;
/*      */     
/* 1019 */     paramFloat5 = paramFloat5;
/* 1020 */     this.p.traverseEntriesInLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, (paramFloat6, paramFloat7, paramFloat8) -> Intersector.intersectSegmentCircle(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat6, paramFloat7, (paramFloat8 + paramFloat5) * (paramFloat8 + paramFloat5)), (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*      */           Enemy enemy;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           if ((enemy = paramEnemyReference.enemy) == null) {
/*      */             return true;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           if (paramRCD != null) {
/*      */             paramRCD.h.add(paramFloat1, paramFloat2, paramFloat3);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           paramArrayOfboolean[0] = true;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           return paramObjectFilter.test(paramEnemyReference);
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1054 */     return arrayOfBoolean[0];
/*      */   }
/*      */   
/*      */   public final int getSpawnedEnemiesCountByWave(Wave paramWave) {
/* 1058 */     byte b1 = 0; byte b2; int i;
/* 1059 */     for (b2 = 0, i = this.spawnedEnemies.size; b2 < i; b2++) {
/*      */       Enemy enemy;
/* 1061 */       if ((enemy = (((Enemy.EnemyReference[])this.spawnedEnemies.items)[b2]).enemy) != null)
/*      */       {
/* 1063 */         if (enemy.wave != null && enemy.wave == paramWave) {
/* 1064 */           b1++;
/*      */         }
/*      */       }
/*      */     } 
/* 1068 */     return b1;
/*      */   }
/*      */   
/*      */   public final void showTowerRangeHint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1072 */     if (this.f == null) {
/* 1073 */       this.f = (RangeCircle)Game.i.shapeManager.getFactory(ShapeType.RANGE_CIRCLE).obtain();
/*      */     }
/* 1075 */     this.g = true;
/* 1076 */     this.f.setup(paramFloat1, paramFloat2, paramFloat3, paramFloat4, b);
/*      */   }
/*      */   
/*      */   public final void hideTowerRangeHint() {
/* 1080 */     this.g = false;
/*      */   }
/*      */   
/*      */   public final void upgradeCoreAction(CoreTile paramCoreTile, int paramInt1, int paramInt2) {
/* 1084 */     CoreTile.Upgrade upgrade = paramCoreTile.getUpgrade(paramInt1, paramInt2);
/* 1085 */     if (paramCoreTile.getUpgradeInstallLevel(paramInt1, paramInt2) >= upgrade.upgradeLevels.size) {
/* 1086 */       a.e("Upgrade " + paramInt2 + ":" + paramInt1 + " is already on max level", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/* 1090 */     if (paramCoreTile.canUpgradeBeInstalled(paramInt1, paramInt2)) {
/* 1091 */       this.S.gameState.pushActionNextUpdate((Action)new CoreUpgradeAction(paramCoreTile.getX(), paramCoreTile.getY(), paramInt1, paramInt2)); return;
/*      */     } 
/* 1093 */     a.e("upgrade can't be installed", new Object[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void upgradeCoreActionAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*      */     Tile tile;
/* 1099 */     if ((tile = this.i.getTile(paramInt1, paramInt2)) != null && tile.type == TileType.CORE) {
/* 1100 */       upgradeCoreAction((CoreTile)tile, paramInt3, paramInt4); return;
/*      */     } 
/* 1102 */     a.e("there's no core tile on " + paramInt1 + ":" + paramInt2, new Object[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean upgradeCoreAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*      */     Tile tile;
/* 1108 */     if ((tile = this.i.getTile(paramInt1, paramInt2)) != null && tile.type == TileType.CORE) {
/* 1109 */       return upgradeCore((CoreTile)tile, paramInt3, paramInt4);
/*      */     }
/* 1111 */     a.e("there's no core tile on " + paramInt1 + ":" + paramInt2, new Object[0]);
/* 1112 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean upgradeCore(CoreTile paramCoreTile, int paramInt1, int paramInt2) {
/*      */     CoreTile.Upgrade upgrade;
/* 1121 */     if ((upgrade = paramCoreTile.getUpgrade(paramInt1, paramInt2)) == null) {
/* 1122 */       a.e("There's no upgrade in core at " + paramInt2 + ":" + paramInt1, new Object[0]);
/* 1123 */       return false;
/*      */     } 
/* 1125 */     if (paramCoreTile.getUpgradeInstallLevel(paramInt1, paramInt2) >= upgrade.upgradeLevels.size) {
/* 1126 */       a.e("Upgrade " + paramInt2 + ":" + paramInt1 + " is already on max level", new Object[0]);
/* 1127 */       return false;
/*      */     } 
/*      */     
/* 1130 */     if (paramCoreTile.canUpgradeBeInstalled(paramInt1, paramInt2)) {
/* 1131 */       int i = this.S.gameState.getMoney();
/* 1132 */       int j = paramCoreTile.getFreeUpgradePoints();
/* 1133 */       int k = paramCoreTile.getUpgradeInstallLevel(paramInt1, paramInt2);
/* 1134 */       CoreTile.Upgrade.UpgradeLevel upgradeLevel = ((CoreTile.Upgrade.UpgradeLevel[])upgrade.upgradeLevels.items)[k];
/*      */ 
/*      */       
/* 1137 */       if ((i = upgrade.costsCoins ? ((i >= upgradeLevel.price) ? 1 : 0) : ((j >= upgradeLevel.price) ? 1 : 0)) != 0) {
/*      */         
/* 1139 */         if (upgrade.costsCoins) {
/* 1140 */           this.S.gameState.removeMoney(upgradeLevel.price);
/*      */         }
/*      */         
/* 1143 */         paramCoreTile.setUpgradeInstallLevel(paramInt1, paramInt2, k + 1);
/*      */         
/* 1145 */         if (upgrade.isAction) {
/* 1146 */           Game.i.triggeredActionManager.perform(this.S, upgrade.getActionType(), upgradeLevel.delta);
/*      */         } else {
/* 1148 */           this.S.gameValue.recalculate();
/*      */         } 
/*      */         
/* 1151 */         i();
/*      */         
/* 1153 */         this.S.events.trigger((Event)new CoreTileUpgradeInstall(paramCoreTile, paramInt1, paramInt2));
/*      */         
/* 1155 */         if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 1156 */           ParticleEffectPool.PooledEffect pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.mapManager.coreHighlightParticlesPool.obtain();
/* 1157 */           Color color = null;
/* 1158 */           switch (null.a[paramCoreTile.getTier().ordinal()]) { case 1:
/* 1159 */               color = MaterialColor.LIGHT_BLUE.P500; break;
/* 1160 */             case 2: color = MaterialColor.PURPLE.P400; break;
/* 1161 */             case 3: color = MaterialColor.ORANGE.P500; break; }
/*      */           
/* 1163 */           ((ParticleEmitter)pooledEffect.getEmitters().first()).getTint().setColors(new float[] { color.r, color.g, color.b });
/*      */ 
/*      */           
/* 1166 */           pooledEffect.setPosition(paramCoreTile.center.x, paramCoreTile.center.y);
/* 1167 */           this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*      */         } 
/* 1169 */         return true;
/*      */       } 
/* 1171 */       a.e("not enough points to make an upgrade", new Object[0]);
/* 1172 */       return false;
/*      */     } 
/*      */     
/* 1175 */     a.e("upgrade can't be installed", new Object[0]);
/* 1176 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void update(float paramFloat) {
/* 1182 */     if (this.i != null && 
/* 1183 */       this.n && this.S.wave != null) {
/* 1184 */       a.i("changing boss waves configuration", new Object[0]);
/*      */       WaveBossSupplier waveBossSupplier;
/* 1186 */       if ((waveBossSupplier = this.i.getBossWaves()) == null) {
/* 1187 */         a.i("map has no bosses", new Object[0]);
/* 1188 */         this.S.wave.setBossWaves(null);
/*      */       } else {
/* 1190 */         a.i("map has bosses", new Object[0]);
/* 1191 */         this.S.wave.setBossWaves(waveBossSupplier.cpy());
/*      */       } 
/* 1193 */       this.n = false;
/*      */     } 
/*      */     
/*      */     StateSystem.ActionsArray actionsArray;
/*      */     
/* 1198 */     if (this.S.gameState != null && (
/*      */       
/* 1200 */       actionsArray = this.S.gameState.getCurrentUpdateActions()) != null) {
/* 1201 */       for (byte b = 0; b < actionsArray.size; b++) {
/*      */         Action action;
/* 1203 */         if ((action = actionsArray.actions[b]).getType() == ActionType.CU) {
/*      */           
/* 1205 */           CoreUpgradeAction coreUpgradeAction = (CoreUpgradeAction)action;
/* 1206 */           if (upgradeCoreAt(coreUpgradeAction.x, coreUpgradeAction.y, coreUpgradeAction.col, coreUpgradeAction.row)) {
/* 1207 */             this.S.gameState.registerPlayerActivity();
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 1214 */     if (this.S.gameState != null && this.S.gameValue != null && 
/* 1215 */       this.S.gameState.isGameRealTimePasses()) {
/* 1216 */       boolean bool = false;
/* 1217 */       this.h += paramFloat;
/*      */       
/* 1219 */       if (this.h > 2.0F) {
/* 1220 */         this.h -= 2.0F;
/* 1221 */         bool = true;
/*      */       } 
/*      */       
/* 1224 */       Array array = this.i.getTilesByType(CoreTile.class);
/* 1225 */       for (byte b = 0; b < array.size; b++) {
/* 1226 */         CoreTile coreTile = ((CoreTile[])array.items)[b];
/* 1227 */         paramFloat = this.S.gameValue.getTickRateDeltaTime();
/*      */         
/* 1229 */         if (coreTile.doubleSpeedTimeLeft > 0.0F) {
/* 1230 */           paramFloat = this.S.gameValue.getTickRateDeltaTime() * 2.0F;
/* 1231 */           coreTile.doubleSpeedTimeLeft -= this.S.gameValue.getTickRateDeltaTime();
/* 1232 */           if (coreTile.doubleSpeedTimeLeft <= 0.0F) {
/* 1233 */             coreTile.doubleSpeedTimeLeft = 0.0F;
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/* 1238 */         paramFloat = Game.i.tileManager.F.CORE.getExperienceGeneration(coreTile, this.S.gameValue) * paramFloat;
/*      */         
/* 1240 */         int i = coreTile.getLevel();
/* 1241 */         coreTile.setExperience(coreTile.getExperience() + paramFloat);
/* 1242 */         if (coreTile.getLevel() > i) {
/*      */           
/* 1244 */           this.S.events.trigger((Event)new CoreTileLevelUp(coreTile));
/*      */ 
/*      */           
/* 1247 */           bool = true;
/*      */         } 
/*      */       } 
/*      */       
/* 1251 */       if (bool) {
/* 1252 */         i();
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1258 */     c();
/*      */ 
/*      */     
/* 1261 */     updateDirtyTiles();
/*      */ 
/*      */     
/* 1264 */     if (Game.i.debugManager != null && Game.i.debugManager.isEnabled()) {
/* 1265 */       Game.i.debugManager.registerValue("Spawned enemies").append(this.spawnedEnemies.size);
/* 1266 */       Game.i.debugManager.registerValue("Spawned units").append(this.spawnedUnits.size);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void i() {
/* 1271 */     Array array = this.i.getTilesByType(CoreTile.class);
/* 1272 */     if (this.S._particle != null && array.size != 0) {
/* 1273 */       for (byte b = 0; b < array.size; b++) {
/*      */         CoreTile coreTile;
/* 1275 */         if ((coreTile = ((CoreTile[])array.items)[b]).upgradeAvailableParticleEffect == null) {
/*      */           
/* 1277 */           if (coreTile.hasSomethingToUpgrade())
/*      */           {
/* 1279 */             coreTile.upgradeAvailableParticleEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.abilityAvailableParticleEffectPool.obtain();
/* 1280 */             coreTile.upgradeAvailableParticleEffect.setPosition(coreTile.center.x + 32.0F, coreTile.center.y - 42.24F);
/* 1281 */             this.S._particle.addParticle((ParticleEffect)coreTile.upgradeAvailableParticleEffect, false);
/*      */           }
/*      */         
/*      */         }
/* 1285 */         else if (!coreTile.hasSomethingToUpgrade()) {
/*      */           
/* 1287 */           coreTile.upgradeAvailableParticleEffect.allowCompletion();
/* 1288 */           coreTile.upgradeAvailableParticleEffect = null;
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean profileUpdate() {
/* 1296 */     return false;
/*      */   }
/*      */   
/*      */   public final String getSystemName() {
/* 1300 */     return "Map";
/*      */   }
/*      */ 
/*      */   
/*      */   private static void a(float paramFloat, Vector2 paramVector2, boolean paramBoolean1, boolean paramBoolean2) {
/*      */     float f1, f2, f3, f4;
/* 1306 */     if (paramBoolean1) {
/* 1307 */       f1 = f2 = -64.0F;
/* 1308 */       f3 = f4 = 64.0F;
/*      */     }
/* 1310 */     else if (f2 != 0.0F) {
/*      */       
/* 1312 */       f1 = -78.0F;
/* 1313 */       f3 = -50.0F;
/* 1314 */       f2 = -64.0F;
/* 1315 */       f4 = 64.0F;
/*      */     } else {
/*      */       
/* 1318 */       f2 = -78.0F;
/* 1319 */       f4 = -50.0F;
/* 1320 */       f1 = -64.0F;
/* 1321 */       f3 = 64.0F;
/*      */     } 
/*      */ 
/*      */     
/* 1325 */     if (paramFloat < 0.25F) {
/*      */       
/* 1327 */       paramVector2.x = f1;
/* 1328 */       paramVector2.y = paramFloat / 0.25F * (f4 - f2) + f2; return;
/* 1329 */     }  if (paramFloat < 0.5F) {
/*      */       
/* 1331 */       paramVector2.x = (paramFloat - 0.25F) / 0.25F * (f3 - f1) + f1;
/* 1332 */       paramVector2.y = f4; return;
/* 1333 */     }  if (paramFloat < 0.75F) {
/*      */       
/* 1335 */       paramVector2.x = f3;
/* 1336 */       paramVector2.y = f4 - (paramFloat - 0.5F) / 0.25F * (f4 - f2);
/*      */       return;
/*      */     } 
/* 1339 */     paramVector2.x = f3 - (paramFloat - 0.75F) / 0.25F * (f3 - f1);
/* 1340 */     paramVector2.y = f2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setPathTracesDrawing(boolean paramBoolean) {
/* 1348 */     this.drawPathTraces = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void traverseNeighborTilesAroundPos(int paramInt1, int paramInt2, ObjectFilter<Tile> paramObjectFilter) {
/* 1355 */     Tile[][] arrayOfTile = this.i.getTilesRaw();
/* 1356 */     int i = Math.max(paramInt2 - 1, 0);
/* 1357 */     int j = Math.min(paramInt2 + 1, this.i.getHeight() - 1) + 1;
/* 1358 */     for (int k = Math.max(paramInt1 - 1, 0), m = Math.min(paramInt1 + 1, this.i.getWidth() - 1); k <= m; k++) {
/* 1359 */       for (int n = i; n < j; n++) {
/* 1360 */         if (k != paramInt1 || n != paramInt2) {
/*      */           Tile tile;
/*      */           
/* 1363 */           if ((tile = arrayOfTile[n][k]) != null && 
/* 1364 */             !paramObjectFilter.test(tile)) {
/*      */             return;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void traverseNeighborTilesAroundTile(Tile paramTile, ObjectFilter<Tile> paramObjectFilter) {
/* 1373 */     traverseNeighborTilesAroundPos(paramTile.getX(), paramTile.getY(), paramObjectFilter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void traverseNeighborTilesIncludingPos(int paramInt1, int paramInt2, ObjectFilter<Tile> paramObjectFilter) {
/* 1380 */     Tile[][] arrayOfTile = this.i.getTilesRaw();
/* 1381 */     int i = Math.max(paramInt2 - 1, 0);
/* 1382 */     paramInt2 = Math.min(paramInt2 + 1, this.i.getHeight() - 1) + 1;
/* 1383 */     for (int j = Math.max(paramInt1 - 1, 0); j <= paramInt1; j++) {
/* 1384 */       for (int k = i; k < paramInt2; k++) {
/*      */         Tile tile;
/* 1386 */         if ((tile = arrayOfTile[k][j]) != null && 
/* 1387 */           !paramObjectFilter.test(tile)) {
/*      */           return;
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void traverseNeighborTilesIncludingTile(Tile paramTile, ObjectFilter<Tile> paramObjectFilter) {
/* 1396 */     traverseNeighborTilesIncludingPos(paramTile.getX(), paramTile.getY(), paramObjectFilter);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 1401 */     this.S._render.prepareBatch(paramBatch, true);
/*      */     
/* 1403 */     if (this.g) {
/* 1404 */       this.f.draw(paramBatch);
/*      */     }
/*      */     
/* 1407 */     if (this.c.size != 0) {
/*      */       
/* 1409 */       this.e += paramFloat * 0.5F;
/* 1410 */       if (this.e > 1.0F) {
/* 1411 */         this.e %= 1.0F;
/*      */       }
/* 1413 */       Vector2 vector21 = new Vector2();
/* 1414 */       Vector2 vector22 = new Vector2();
/* 1415 */       a(this.e, vector21, true, false);
/*      */       
/* 1417 */       this.e += 0.5F;
/* 1418 */       if (this.e > 1.0F) {
/* 1419 */         this.e %= 1.0F;
/*      */       }
/* 1421 */       a(this.e, vector22, true, false);
/*      */       
/* 1423 */       for (byte b = 0; b < this.c.size; b++) {
/*      */         Tile tile;
/* 1425 */         (tile = (Tile)this.c.get(b)).highlightParticleA.setPosition(((tile.getX() << 7) + 64) + vector21.x, ((tile.getY() << 7) + 64) + vector21.y);
/* 1426 */         tile.highlightParticleB.setPosition(((tile.getX() << 7) + 64) + vector22.x, ((tile.getY() << 7) + 64) + vector22.y);
/*      */       } 
/*      */     } 
/* 1429 */     if (this.d.size != 0) {
/*      */       
/* 1431 */       Vector2 vector21 = new Vector2();
/* 1432 */       Vector2 vector22 = new Vector2();
/* 1433 */       for (byte b = 0; b < this.d.size; b++) {
/* 1434 */         Gate gate = (Gate)this.d.get(b);
/*      */         
/* 1436 */         this.e += paramFloat * 0.5F;
/* 1437 */         if (this.e > 1.0F) {
/* 1438 */           this.e %= 1.0F;
/*      */         }
/* 1440 */         a(this.e, vector21, false, gate.isLeftSide());
/*      */         
/* 1442 */         this.e += 0.5F;
/* 1443 */         if (this.e > 1.0F) {
/* 1444 */           this.e %= 1.0F;
/*      */         }
/* 1446 */         a(this.e, vector22, false, gate.isLeftSide());
/*      */         
/* 1448 */         gate.highlightParticleA.setPosition(((gate.getX() << 7) + 64) + vector21.x, ((gate.getY() << 7) + 64) + vector21.y);
/* 1449 */         gate.highlightParticleB.setPosition(((gate.getX() << 7) + 64) + vector22.x, ((gate.getY() << 7) + 64) + vector22.y);
/*      */       } 
/*      */     } 
/*      */     
/* 1453 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_TILE_INFO) != 0.0D) {
/*      */       BitmapFont bitmapFont;
/*      */       
/* 1456 */       (bitmapFont = Game.i.assetManager.getDebugFont(false)).setColor(0.0F, 1.0F, 1.0F, 0.56F);
/* 1457 */       for (byte b = 0; b < this.i.getHeight(); b++) {
/* 1458 */         for (byte b1 = 0; b1 < this.i.getWidth(); b1++) {
/*      */           Tile tile;
/* 1460 */           if ((tile = this.i.getTile(b1, b)) != null)
/*      */           {
/* 1462 */             bitmapFont.draw(paramBatch, "WC: " + String.valueOf((this.S.pathfinding != null) ? (int)tile.getWalkCost(this.S.pathfinding.isWalkablePlatforms()) : 0).length() + " E: " + tile.enemyCount, (b1 << 7), (b << 7) - 10.0F + 64.0F, 128.0F, 1, false); } 
/*      */         } 
/*      */       } 
/* 1465 */       bitmapFont.setColor(Color.WHITE);
/*      */     } 
/*      */     
/* 1468 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_ENEMIES_AABB) != 0.0D && this.p != null) {
/* 1469 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.p.getMinX(), this.p.getMinY(), this.p.getMinX(), this.p.getMaxY(), 2.0F, MaterialColor.PURPLE.P500.toFloatBits(), MaterialColor.PURPLE.P500.toFloatBits());
/* 1470 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.p.getMinX(), this.p.getMinY(), this.p.getMaxX(), this.p.getMinY(), 2.0F, MaterialColor.PURPLE.P500.toFloatBits(), MaterialColor.PURPLE.P500.toFloatBits());
/* 1471 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.p.getMaxX(), this.p.getMinY(), this.p.getMaxX(), this.p.getMaxY(), 2.0F, MaterialColor.PURPLE.P500.toFloatBits(), MaterialColor.PURPLE.P500.toFloatBits());
/* 1472 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.p.getMinX(), this.p.getMaxY(), this.p.getMaxX(), this.p.getMaxY(), 2.0F, MaterialColor.PURPLE.P500.toFloatBits(), MaterialColor.PURPLE.P500.toFloatBits());
/*      */       
/* 1474 */       float f1 = 1.0F / this.p.getCellSizeXInv();
/* 1475 */       float f2 = 1.0F / this.p.getCellSizeYInv();
/* 1476 */       float f3 = (new Color(0.0F, 1.0F, 0.0F, 0.56F)).toFloatBits(); byte b;
/* 1477 */       for (b = 0; b <= this.p.getCols(); b++) {
/*      */         
/* 1479 */         float f4 = b * f1 + this.p.getMinX();
/* 1480 */         float f5 = this.p.getRows() * f2 + this.p.getMinY();
/* 1481 */         DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), f4, this.p.getMinY(), f4, f5, 1.0F, f3, f3);
/*      */       } 
/* 1483 */       for (b = 0; b <= this.p.getRows(); b++) {
/*      */         
/* 1485 */         float f4 = b * f2 + this.p.getMinY();
/* 1486 */         float f5 = this.p.getCols() * f1 + this.p.getMinX();
/* 1487 */         DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.p.getMinX(), f4, f5, f4, 1.0F, f3, f3);
/*      */       } 
/* 1489 */       for (b = 0; b < this.p.getRows(); b++) {
/* 1490 */         for (byte b1 = 0; b1 < this.p.getCols(); b1++) {
/* 1491 */           int i = b * this.p.getCols() + b1;
/* 1492 */           Game.i.assetManager.getSmallDebugFont().draw(paramBatch, this.p.getEntityCount(i), b1 * f1 + 4.0F + this.p.getMinX(), b * f2 + 14.0F + this.p.getMinY());
/*      */         } 
/*      */       } 
/*      */       
/* 1496 */       this.p.debugBatch = paramBatch;
/* 1497 */       if (Gdx.input.isKeyPressed(43)) {
/*      */         
/* 1499 */         w.set(Gdx.input.getX(), Gdx.input.getY());
/* 1500 */         this.S._input.cameraController.screenToMap(w);
/*      */       } 
/* 1502 */       if (Gdx.input.isKeyPressed(40)) {
/*      */         
/* 1504 */         x.set(Gdx.input.getX(), Gdx.input.getY());
/* 1505 */         this.S._input.cameraController.screenToMap(x);
/*      */       } 
/* 1507 */       if (Gdx.input.isKeyPressed(39)) {
/*      */         
/* 1509 */         y.set(Gdx.input.getX(), Gdx.input.getY());
/* 1510 */         this.S._input.cameraController.screenToMap(y);
/*      */       } 
/* 1512 */       paramBatch.setColor(0.0F, 0.0F, 1.0F, 0.28F);
/* 1513 */       paramBatch.draw((TextureRegion)Game.i.assetManager.getTextureRegion("circle"), w.x - 384.0F, w.y - 384.0F, 768.0F, 768.0F);
/*      */       
/* 1515 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), x.x, x.y, y.x, y.y, 3.0F, MaterialColor.CYAN.P500.toFloatBits(), MaterialColor.CYAN.P500.toFloatBits());
/* 1516 */       paramBatch.setColor(1.0F, 0.0F, 0.0F, 0.28F);
/* 1517 */       getEnemiesInCircle(w.x, w.y, 384.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> true);
/*      */ 
/*      */       
/* 1520 */       rayCastEnemiesSorted(x.x, x.y, y.x, y.y, 0.0F, paramEnemyReference -> true);
/*      */ 
/*      */       
/* 1523 */       paramBatch.setColor(Color.WHITE);
/* 1524 */       this.p.debugBatch = null;
/*      */     } 
/*      */     
/* 1527 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_ENEMIES_COUNT_AABB) != 0.0D && this.q != null) {
/* 1528 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.q.getMinX(), this.q.getMinY(), this.q.getMinX(), this.q.getMaxY(), 2.0F, MaterialColor.PURPLE.P500.toFloatBits(), MaterialColor.PURPLE.P500.toFloatBits());
/* 1529 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.q.getMinX(), this.q.getMinY(), this.q.getMaxX(), this.q.getMinY(), 2.0F, MaterialColor.PURPLE.P500.toFloatBits(), MaterialColor.PURPLE.P500.toFloatBits());
/* 1530 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.q.getMaxX(), this.q.getMinY(), this.q.getMaxX(), this.q.getMaxY(), 2.0F, MaterialColor.PURPLE.P500.toFloatBits(), MaterialColor.PURPLE.P500.toFloatBits());
/* 1531 */       DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.q.getMinX(), this.q.getMaxY(), this.q.getMaxX(), this.q.getMaxY(), 2.0F, MaterialColor.PURPLE.P500.toFloatBits(), MaterialColor.PURPLE.P500.toFloatBits());
/*      */       
/* 1533 */       float f1 = this.q.getCellSize();
/* 1534 */       float f2 = (new Color(0.0F, 1.0F, 0.0F, 0.56F)).toFloatBits(); byte b;
/* 1535 */       for (b = 0; b <= this.q.getCols(); b++) {
/*      */         
/* 1537 */         float f3 = b * f1 + this.q.getMinX();
/* 1538 */         float f4 = this.q.getRows() * f1 + this.q.getMinY();
/* 1539 */         DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), f3, this.q.getMinY(), f3, f4, 1.0F, f2, f2);
/*      */       } 
/* 1541 */       for (b = 0; b <= this.q.getRows(); b++) {
/*      */         
/* 1543 */         float f3 = b * f1 + this.q.getMinY();
/* 1544 */         float f4 = this.q.getCols() * f1 + this.q.getMinX();
/* 1545 */         DrawUtils.texturedLineC(paramBatch, (TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.q.getMinX(), f3, f4, f3, 1.0F, f2, f2);
/*      */       } 
/* 1547 */       for (b = 0; b < this.q.getRows(); b++) {
/* 1548 */         for (byte b1 = 0; b1 < this.q.getCols(); b1++) {
/* 1549 */           int i = b * this.q.getCols() + b1;
/* 1550 */           float f = b1 * f1 + this.q.getMinX();
/* 1551 */           f2 = b * f1 + this.q.getMinY();
/* 1552 */           int j = this.q.getEntityCountByCellIdx(i);
/* 1553 */           paramBatch.setColor(0.0F, 1.0F, 0.0F, MathUtils.clamp(0.14F * j, 0.0F, 1.0F));
/* 1554 */           paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), f, f2, f1, f1);
/* 1555 */           paramBatch.setColor(Color.WHITE);
/* 1556 */           Game.i.assetManager.getSmallDebugFont().draw(paramBatch, this.q.getEntityCountByCellIdx(i), b1 * f1 + 4.0F + this.q.getMinX(), b * f1 + 14.0F + this.q.getMinY());
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1561 */     if (this.t.size != 0 || this.u.size != 0 || this.v.size != 0) {
/* 1562 */       paramBatch.end();
/*      */       ShapeRenderer shapeRenderer;
/* 1564 */       (shapeRenderer = Game.i.renderingManager.shapeRenderer).begin(ShapeRenderer.ShapeType.Line);
/* 1565 */       Gdx.gl.glEnable(3042);
/* 1566 */       Gdx.gl.glBlendFunc(770, 771);
/* 1567 */       shapeRenderer.setProjectionMatrix(paramBatch.getProjectionMatrix());
/* 1568 */       this.t.begin(); byte b;
/* 1569 */       for (b = 0; b < this.t.size; b++) {
/*      */         RCD rCD;
/* 1571 */         (rCD = ((RCD[])this.t.items)[b]).a += paramFloat;
/*      */         float f;
/* 1573 */         if ((f = 1.0F - rCD.a * 2.0F) <= 0.0F) {
/* 1574 */           this.t.removeIndex(b);
/*      */         } else {
/* 1576 */           Color color = rCD.g.cpy().mul(1.0F, 1.0F, 1.0F, f);
/* 1577 */           shapeRenderer.setColor(color);
/* 1578 */           shapeRenderer.rectLine(rCD.b, rCD.c, rCD.d, rCD.e, rCD.f);
/* 1579 */           color.mul(1.0F, 1.0F, 1.0F, 0.56F);
/* 1580 */           shapeRenderer.setColor(color);
/* 1581 */           for (byte b1 = 0; b1 < rCD.h.size; b1 += 3) {
/* 1582 */             shapeRenderer.circle(rCD.h.items[b1], rCD.h.items[b1 + 1], rCD.h.items[b1 + 2]);
/*      */           }
/*      */         } 
/*      */       } 
/* 1586 */       this.t.end();
/*      */       
/* 1588 */       this.u.begin();
/* 1589 */       for (b = 0; b < this.u.size; b++) {
/*      */         COLD_Circle cOLD_Circle;
/* 1591 */         (cOLD_Circle = ((COLD_Circle[])this.u.items)[b]).a += paramFloat;
/*      */         float f;
/* 1593 */         if ((f = 1.0F - cOLD_Circle.a * 2.0F) <= 0.0F) {
/* 1594 */           this.u.removeIndex(b);
/*      */         } else {
/* 1596 */           Color color = cOLD_Circle.e.cpy().mul(1.0F, 1.0F, 1.0F, f);
/* 1597 */           shapeRenderer.setColor(color);
/* 1598 */           shapeRenderer.circle(cOLD_Circle.b, cOLD_Circle.c, cOLD_Circle.d);
/* 1599 */           color.mul(1.0F, 1.0F, 1.0F, 0.56F);
/* 1600 */           shapeRenderer.setColor(color);
/* 1601 */           for (byte b1 = 0; b1 < cOLD_Circle.f.size; b1 += 3) {
/* 1602 */             shapeRenderer.circle(cOLD_Circle.f.items[b1], cOLD_Circle.f.items[b1 + 1], cOLD_Circle.f.items[b1 + 2]);
/*      */           }
/*      */         } 
/*      */       } 
/* 1606 */       this.u.end();
/*      */       
/* 1608 */       this.v.begin();
/* 1609 */       for (b = 0; b < this.v.size; b++) {
/*      */         DBG_DirtyTile dBG_DirtyTile;
/* 1611 */         (dBG_DirtyTile = ((DBG_DirtyTile[])this.v.items)[b]).a += paramFloat;
/*      */         float f;
/* 1613 */         if ((f = 1.0F - dBG_DirtyTile.a) <= 0.0F) {
/* 1614 */           this.v.removeIndex(b);
/*      */         } else {
/* 1616 */           Color color = MaterialColor.YELLOW.P500.cpy().mul(1.0F, 1.0F, 1.0F, f * 0.56F);
/* 1617 */           shapeRenderer.setColor(color);
/* 1618 */           shapeRenderer.rect(((dBG_DirtyTile.b << 7) + 2), ((dBG_DirtyTile.c << 7) + 2), 124.0F, 124.0F);
/*      */         } 
/*      */       } 
/* 1621 */       this.v.end();
/*      */       
/* 1623 */       shapeRenderer.end();
/* 1624 */       paramBatch.begin();
/*      */     } 
/*      */     
/* 1627 */     if (g()) {
/* 1628 */       BitmapFont bitmapFont = Game.i.assetManager.getSmallDebugFont();
/* 1629 */       for (byte b = 0; b < this.m.length; b++) {
/* 1630 */         short[] arrayOfShort = this.m[b];
/* 1631 */         for (byte b1 = 0; b1 < arrayOfShort.length; b1++) {
/* 1632 */           bitmapFont.draw(paramBatch, arrayOfShort[b1], ((b1 << 7) + 64), ((b << 7) + 128) - 20.0F, 1.0F, 1, false);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/* 1638 */   private static final Vector2 w = new Vector2();
/* 1639 */   private static final Vector2 x = new Vector2();
/* 1640 */   private static final Vector2 y = new Vector2(128.0F, 128.0F);
/*      */ 
/*      */ 
/*      */   
/*      */   public final void dispose() {
/* 1645 */     Game.i.debugManager.unregisterValue("Spawned enemies");
/*      */     
/* 1647 */     this.c.clear();
/* 1648 */     this.d.clear();
/* 1649 */     this.spawnedEnemies.clear();
/* 1650 */     this.spawnedUnits.clear();
/* 1651 */     if (this.i != null) {
/* 1652 */       b();
/*      */     }
/* 1654 */     this.i = null;
/*      */     
/* 1656 */     this.f = null;
/*      */     
/* 1658 */     super.dispose();
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnNextWaveForce extends SerializableListener<MapSystem> implements Listener<NextWaveForce> {
/*      */     private OnNextWaveForce() {}
/*      */     
/*      */     private OnNextWaveForce(MapSystem param1MapSystem) {
/* 1666 */       this.a = param1MapSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(NextWaveForce param1NextWaveForce) {
/* 1671 */       if (param1NextWaveForce.getTime() > 0.0F) {
/* 1672 */         Array array = MapSystem.a((MapSystem)this.a).getTilesByType(CoreTile.class);
/* 1673 */         for (byte b = 0; b < array.size; b++)
/* 1674 */           (((CoreTile[])array.items)[b]).doubleSpeedTimeLeft += param1NextWaveForce.getTime(); 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnGameValuesRecalculate
/*      */     extends SerializableListener<MapSystem> implements Listener<GameValuesRecalculate> {
/*      */     private OnGameValuesRecalculate() {}
/*      */     
/*      */     public OnGameValuesRecalculate(MapSystem param1MapSystem) {
/* 1685 */       this.a = param1MapSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(GameValuesRecalculate param1GameValuesRecalculate) {
/* 1690 */       ((MapSystem)this.a).markAllTilesDirty();
/*      */     } }
/*      */   private static final class RCD { float a;
/*      */     float b;
/*      */     float c;
/*      */     float d;
/*      */     float e;
/*      */     float f;
/*      */     
/*      */     private RCD() {}
/*      */     
/* 1701 */     Color g = MaterialColor.GREEN.P500;
/* 1702 */     FloatArray h = new FloatArray(); }
/*      */   private static final class COLD_Circle { float a;
/*      */     float b;
/*      */     float c;
/*      */     float d;
/*      */     
/*      */     private COLD_Circle() {}
/*      */     
/* 1710 */     Color e = MaterialColor.GREEN.P500;
/* 1711 */     FloatArray f = new FloatArray(); }
/*      */ 
/*      */   
/*      */   private static final class DBG_DirtyTile {
/*      */     float a;
/*      */     int b;
/*      */     int c;
/*      */     
/*      */     private DBG_DirtyTile() {}
/*      */   }
/*      */   
/*      */   private static final class RayCastSortedFilter implements AABB.EntryFilter {
/*      */     private float a;
/*      */     private float b;
/*      */     private float c;
/*      */     
/*      */     public final RayCastSortedFilter setup(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5) {
/* 1728 */       this.a = param1Float1;
/* 1729 */       this.b = param1Float2;
/* 1730 */       this.c = param1Float3;
/* 1731 */       this.d = param1Float4;
/* 1732 */       this.e = param1Float5;
/* 1733 */       return this;
/*      */     }
/*      */     private float d; private float e;
/*      */     private RayCastSortedFilter() {}
/*      */     public final boolean test(float param1Float1, float param1Float2, float param1Float3) {
/* 1738 */       return Intersector.intersectSegmentCircle(this.a, this.b, this.c, this.d, param1Float1, param1Float2, (param1Float3 + this.e) * (param1Float3 + this.e));
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class RayCastSortedRetriever implements AABB.EntryRetriever<Enemy.EnemyReference> {
/*      */     private final FloatSorter a;
/*      */     private float b;
/*      */     private float c;
/*      */     
/*      */     private RayCastSortedRetriever(FloatSorter param1FloatSorter) {
/* 1748 */       this.a = param1FloatSorter;
/*      */     }
/*      */     
/*      */     public final RayCastSortedRetriever setup(float param1Float1, float param1Float2) {
/* 1752 */       this.b = param1Float1;
/* 1753 */       this.c = param1Float2;
/* 1754 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean retrieve(Enemy.EnemyReference param1EnemyReference, float param1Float1, float param1Float2, float param1Float3) {
/*      */       Enemy enemy;
/* 1760 */       if ((enemy = param1EnemyReference.enemy) == null) return true;
/*      */ 
/*      */       
/* 1763 */       this.a.add(param1EnemyReference, PMath.getSquareDistanceBetweenPoints(param1Float1, param1Float2, this.b, this.c));
/*      */       
/* 1765 */       return true;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\MapSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */