/*      */ package com.prineside.tdi2;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.IdentityMap;
/*      */ import com.badlogic.gdx.utils.IntArray;
/*      */ import com.badlogic.gdx.utils.IntMap;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.ObjectSet;
/*      */ import com.badlogic.gdx.utils.Predicate;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.KryoSerializable;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.tdi2.enums.AbilityType;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.TileType;
/*      */ import com.prineside.tdi2.gates.TeleportGate;
/*      */ import com.prineside.tdi2.managers.MapManager;
/*      */ import com.prineside.tdi2.tiles.BossTile;
/*      */ import com.prineside.tdi2.tiles.DummyTile;
/*      */ import com.prineside.tdi2.tiles.GameValueTile;
/*      */ import com.prineside.tdi2.tiles.SourceTile;
/*      */ import com.prineside.tdi2.tiles.SpawnTile;
/*      */ import com.prineside.tdi2.tiles.TargetTile;
/*      */ import com.prineside.tdi2.tiles.XmMusicTrackTile;
/*      */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*      */ import com.prineside.tdi2.utils.IntPair;
/*      */ import com.prineside.tdi2.utils.IntRectangle;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.WaveBossSupplier;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ @REGS
/*      */ public final class Map implements KryoSerializable {
/*   46 */   private static final TLog a = TLog.forClass(Map.class);
/*      */   
/*      */   public static final int MAX_TECHNICAL_SIZE = 48;
/*      */   
/*      */   public static final int MAX_SIZE = 24;
/*      */   
/*      */   public static final float WALK_COST_1 = 1.0F;
/*      */   
/*      */   public static final float WALK_COST_2 = 512.0F;
/*      */   
/*      */   public static final float WALK_COST_3 = 262144.0F;
/*      */   
/*      */   public static final float WALK_COST_4 = 1.3421773E8F;
/*      */   
/*      */   public static final float WALK_COST_MAX = 6.871948E10F;
/*      */   
/*      */   public static final float VOID_WALK_COST = 6.871948E10F;
/*      */   
/*      */   public static final float BARRIER_WALK_COST = 6.871948E10F;
/*      */   
/*      */   public static final float GATE_HIT_AREA_WIDTH = 18.199999F;
/*      */   
/*      */   private Tile[][] b;
/*      */   
/*      */   private Gate[][][] c;
/*      */   
/*      */   private int d;
/*      */   
/*      */   private int e;
/*      */   @NAGS
/*      */   private boolean f = true;
/*      */   @NAGS
/*   78 */   private final DelayedRemovalArray<Tile> g = new DelayedRemovalArray(true, 1, Tile.class); @NAGS
/*   79 */   private final DelayedRemovalArray<Gate> h = new DelayedRemovalArray(true, 1, Gate.class); @NAGS
/*   80 */   private final IdentityMap<Class<? extends Tile>, Array<? extends Tile>> i = new IdentityMap(); @NAGS
/*   81 */   private final IdentityMap<Class<? extends Gate>, Array<? extends Gate>> j = new IdentityMap();
/*      */   @NAGS
/*   83 */   private final Array<EnemyType> k = new Array(EnemyType.class); @NAGS
/*   84 */   private final ObjectSet<EnemyType> l = new ObjectSet(); @NAGS
/*      */   private MapManager.MapPreview m;
/*      */   @NAGS
/*   87 */   private final IntPair n = new IntPair(); @NAGS
/*   88 */   private final IntRectangle o = new IntRectangle(); @NAGS
/*   89 */   private final Gate p = (Gate)Game.i.gateManager.F.BARRIER_TYPE.create();
/*      */ 
/*      */   
/*      */   public final void write(Kryo paramKryo, Output paramOutput) {
/*   93 */     paramKryo.writeObjectOrNull(paramOutput, this.b, Tile[][].class);
/*   94 */     paramKryo.writeObjectOrNull(paramOutput, this.c, Gate[][][].class);
/*   95 */     paramOutput.writeVarInt(this.d, true);
/*   96 */     paramOutput.writeVarInt(this.e, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void read(Kryo paramKryo, Input paramInput) {
/*  101 */     this.b = (Tile[][])paramKryo.readObjectOrNull(paramInput, Tile[][].class);
/*  102 */     this.c = (Gate[][][])paramKryo.readObjectOrNull(paramInput, Gate[][][].class);
/*  103 */     this.d = paramInput.readVarInt(true);
/*  104 */     this.e = paramInput.readVarInt(true);
/*  105 */     this.f = true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Map(int paramInt1, int paramInt2) {
/*  111 */     this(new Tile[paramInt2][paramInt1], new Gate[paramInt2 + 1][paramInt1 + 1][2]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map(Tile[][] paramArrayOfTile, Gate[][][] paramArrayOfGate) {
/*  118 */     this.b = paramArrayOfTile;
/*  119 */     this.c = paramArrayOfGate;
/*      */     
/*  121 */     this.e = paramArrayOfTile.length;
/*  122 */     this.d = (paramArrayOfTile[0]).length;
/*      */     byte b;
/*  124 */     for (b = 0; b < this.e; b++) {
/*  125 */       for (byte b1 = 0; b1 < this.d; b1++) {
/*  126 */         if (paramArrayOfTile[b][b1] != null) {
/*  127 */           paramArrayOfTile[b][b1].setPos(b1, b);
/*      */         }
/*      */       } 
/*      */     } 
/*  131 */     for (b = 0; b <= this.e; b++) {
/*  132 */       for (byte b1 = 0; b1 <= this.d; b1++) {
/*  133 */         for (byte b2 = 0; b2 < 2; b2++) {
/*  134 */           if (paramArrayOfGate[b][b1][b2] != null) {
/*  135 */             paramArrayOfGate[b][b1][b2].setPosition(b1, b, (b2 == 0));
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  141 */     this.f = true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int positionToCoordinate(float paramFloat) {
/*  148 */     if (paramFloat < 0.0F) return -1; 
/*  149 */     return (int)(paramFloat * 0.0078125F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getTileIndex(float paramFloat) {
/*  156 */     if (paramFloat < 0.0F) return -1;
/*      */     
/*  158 */     return (int)(paramFloat * 0.0078125F);
/*      */   }
/*      */   
/*      */   public final TargetTile getTargetTileOrThrow() {
/*  162 */     return getTargetTile(true);
/*      */   }
/*      */   
/*      */   public final TargetTile getTargetTile(boolean paramBoolean) {
/*      */     Array<TargetTile> array;
/*  167 */     if ((array = getTilesByType(TargetTile.class)).size == 0) {
/*  168 */       if (paramBoolean) throw new IllegalStateException("No target tile on map"); 
/*  169 */       return null;
/*      */     } 
/*  171 */     return (TargetTile)array.first();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void traverseNeighborTiles(int paramInt1, int paramInt2, Predicate<Tile> paramPredicate) {
/*  180 */     for (int i = paramInt1 - 1; i <= paramInt1 + 1; i++) {
/*  181 */       for (int j = paramInt2 - 1; j <= paramInt2 + 1; j++) {
/*  182 */         if (i != paramInt1 || j != paramInt2) {
/*      */           Tile tile;
/*      */           
/*  185 */           if ((tile = getTile(i, j)) != null && 
/*  186 */             !paramPredicate.evaluate(tile)) {
/*      */             return;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void getNeighbourTiles(Array<Tile> paramArray, int paramInt1, int paramInt2) {
/*  198 */     traverseNeighborTiles(paramInt1, paramInt2, paramTile -> {
/*      */           paramArray.add(paramTile);
/*      */           return true;
/*      */         });
/*      */   }
/*      */   
/*      */   public final AbilitySelectionOverlay.SelectedAbilitiesConfiguration getMaxedAbilitiesConfiguration() {
/*  205 */     a();
/*      */ 
/*      */     
/*  208 */     ObjectMap objectMap = new ObjectMap(); AbilityType[] arrayOfAbilityType; int i; byte b1;
/*  209 */     for (i = (arrayOfAbilityType = AbilityType.values).length, b1 = 0; b1 < i; ) { AbilityType abilityType = arrayOfAbilityType[b1];
/*  210 */       objectMap.put(Game.i.abilityManager.getMaxPerGameGameValueType(abilityType), abilityType);
/*      */       
/*      */       b1++; }
/*      */     
/*      */     Array array;
/*  215 */     (array = new Array(GameValueConfig.class)).addAll(getTargetTileOrThrow().getGameValues());
/*      */ 
/*      */     
/*  218 */     for (i = 0; i < this.g.size; i++) {
/*      */       Tile tile;
/*  220 */       if ((tile = ((Tile[])this.g.items)[i]).type == TileType.GAME_VALUE) {
/*  221 */         GameValueTile gameValueTile = (GameValueTile)tile;
/*  222 */         array.add(new GameValueConfig(gameValueTile
/*  223 */               .getGameValueType(), gameValueTile
/*  224 */               .getDelta(), false, true));
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  232 */     AbilitySelectionOverlay.SelectedAbilitiesConfiguration selectedAbilitiesConfiguration = new AbilitySelectionOverlay.SelectedAbilitiesConfiguration();
/*  233 */     b1 = 0;
/*  234 */     for (byte b2 = 0; b2 < array.size; b2++) {
/*  235 */       GameValueConfig gameValueConfig = (GameValueConfig)array.get(b2);
/*  236 */       if (objectMap.containsKey(gameValueConfig.getType())) {
/*      */         
/*  238 */         boolean bool = false;
/*  239 */         for (byte b = 0; b < 6; b++) {
/*  240 */           if (selectedAbilitiesConfiguration.slots[b] == objectMap.get(gameValueConfig.getType())) {
/*  241 */             selectedAbilitiesConfiguration.counts[b] = selectedAbilitiesConfiguration.counts[b] + MathUtils.round((float)gameValueConfig.getValue());
/*  242 */             bool = true;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*  247 */         if (!bool) {
/*  248 */           selectedAbilitiesConfiguration.slots[b1] = (AbilityType)objectMap.get(gameValueConfig.getType());
/*  249 */           selectedAbilitiesConfiguration.counts[b1] = MathUtils.round((float)gameValueConfig.getValue());
/*      */           
/*  251 */           b1++;
/*  252 */           if (b1 != 6)
/*      */             continue;  break;
/*      */         } 
/*      */       }  continue;
/*      */     } 
/*  257 */     return selectedAbilitiesConfiguration;
/*      */   }
/*      */   
/*      */   public static int getTileIdByPos(Tile paramTile) {
/*  261 */     return (paramTile.b << 11) + paramTile.a;
/*      */   }
/*      */   
/*      */   public final double getPrestigeScore() {
/*  265 */     a();
/*      */     
/*  267 */     double d = 0.0D; Array.ArrayIterator<Tile> arrayIterator;
/*  268 */     for (arrayIterator = this.g.iterator(); arrayIterator.hasNext(); ) { Tile tile = arrayIterator.next();
/*  269 */       d += tile.getPrestigeScore(); }
/*      */     
/*  271 */     for (arrayIterator = this.h.iterator(); arrayIterator.hasNext(); ) { Gate gate = (Gate)arrayIterator.next();
/*  272 */       d += gate.getPrestigeScore(); }
/*      */ 
/*      */     
/*  275 */     return d;
/*      */   }
/*      */   
/*      */   public final <T extends Tile> Array<T> getTilesByType(Class<T> paramClass) {
/*  279 */     Preconditions.checkNotNull(paramClass, "Class can not be null");
/*  280 */     a();
/*      */     
/*      */     Array<T> array;
/*  283 */     if ((array = (Array)this.i.get(paramClass)) == null) {
/*  284 */       array = new Array(true, 1, paramClass);
/*  285 */       this.i.put(paramClass, array);
/*      */     } 
/*  287 */     return array;
/*      */   }
/*      */   
/*      */   public final <T extends Gate> Array<T> getGatesByType(Class<T> paramClass) {
/*  291 */     Preconditions.checkNotNull(paramClass, "Class can not be null");
/*  292 */     a();
/*      */     
/*      */     Array<T> array;
/*  295 */     if ((array = (Array)this.j.get(paramClass)) == null) {
/*  296 */       array = new Array(true, 1, paramClass);
/*      */     }
/*  298 */     return array;
/*      */   }
/*      */   
/*      */   public final void getTeleportGates(IntMap<Array<TeleportGate>> paramIntMap) {
/*  302 */     paramIntMap.clear();
/*  303 */     Array<TeleportGate> array = getGatesByType(TeleportGate.class); byte b; int i;
/*  304 */     for (b = 0, i = array.size; b < i; b++) {
/*  305 */       TeleportGate teleportGate = (TeleportGate)array.get(b);
/*  306 */       if (!paramIntMap.containsKey(teleportGate.index)) {
/*  307 */         paramIntMap.put(teleportGate.index, new Array(true, 1, TeleportGate.class));
/*      */       }
/*  309 */       ((Array)paramIntMap.get(teleportGate.index)).add(teleportGate);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void multiplyPortalsDifficulty(float paramFloat) {
/*  314 */     a();
/*  315 */     Array<SpawnTile> array = getTilesByType(SpawnTile.class); byte b; int i;
/*  316 */     for (b = 0, i = array.size; b < i; b++) {
/*      */       SpawnTile spawnTile;
/*  318 */       (spawnTile = (SpawnTile)array.get(b)).difficulty = MathUtils.round(spawnTile.difficulty * paramFloat);
/*      */     } 
/*  320 */     this.f = true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getAverageDifficulty() {
/*      */     Array<SpawnTile> array;
/*  328 */     if ((array = getTilesByType(SpawnTile.class)).size == 0) throw new IllegalStateException("No spawn tiles on map");
/*      */     
/*  330 */     int i = 0; byte b; int j;
/*  331 */     for (b = 0, j = array.size; b < j; b++) {
/*  332 */       i += ((SpawnTile)array.get(b)).difficulty;
/*      */     }
/*      */     
/*  335 */     return i / array.size;
/*      */   }
/*      */ 
/*      */   
/*      */   public final float getDifficultyExpectedPlaytime() {
/*  340 */     float f = (f = this.g.size) / 576.0F;
/*  341 */     f = 0.5F - f * 0.45F;
/*  342 */     a.i("getDifficultyExpectedPlaytime: " + f, new Object[0]);
/*      */     
/*  344 */     return f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setSize(int paramInt1, int paramInt2) {
/*  353 */     if (this.d == paramInt1 && this.e == paramInt2)
/*      */       return; 
/*  355 */     if (paramInt1 <= 0 || paramInt1 > 48) throw new IllegalArgumentException("Invalid width: " + paramInt1); 
/*  356 */     if (paramInt2 <= 0 || paramInt2 > 48) throw new IllegalArgumentException("Invalid height: " + paramInt2);
/*      */     
/*  358 */     Tile[][] arrayOfTile = new Tile[paramInt2][paramInt1];
/*  359 */     Gate[][][] arrayOfGate = new Gate[paramInt2 + 1][paramInt1 + 1][2];
/*      */     byte b;
/*  361 */     for (b = 0; b < paramInt2; b++) {
/*  362 */       for (byte b1 = 0; b1 < paramInt1; b1++) {
/*  363 */         arrayOfTile[b][b1] = getTile(b1, b);
/*      */       }
/*      */     } 
/*  366 */     for (b = 0; b <= paramInt2; b++) {
/*  367 */       for (byte b1 = 0; b1 <= paramInt1; b1++) {
/*  368 */         for (byte b2 = 0; b2 < 2; b2++) {
/*  369 */           arrayOfGate[b][b1][b2] = getGate(b1, b, (b2 == 0));
/*      */         }
/*      */       } 
/*      */     } 
/*  373 */     this.b = arrayOfTile;
/*  374 */     this.c = arrayOfGate;
/*      */     
/*  376 */     this.e = arrayOfTile.length;
/*  377 */     this.d = (arrayOfTile[0]).length;
/*      */     
/*  379 */     this.f = true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int[] getResourcesCount() {
/*  386 */     a();
/*      */     
/*  388 */     int[] arrayOfInt = new int[ResourceType.values.length + 1]; byte b;
/*      */     int i;
/*  390 */     for (b = 0, i = this.g.size; b < i; b++) {
/*      */       Tile tile;
/*  392 */       if (tile = ((Tile[])this.g.items)[b] instanceof SourceTile) {
/*  393 */         SourceTile sourceTile = (SourceTile)tile;
/*  394 */         int j = 0; ResourceType[] arrayOfResourceType; int k; byte b1;
/*  395 */         for (k = (arrayOfResourceType = ResourceType.values).length, b1 = 0; b1 < k; ) { ResourceType resourceType = arrayOfResourceType[b1];
/*  396 */           int m = sourceTile.getResourcesCount(resourceType);
/*  397 */           arrayOfInt[resourceType.ordinal()] = arrayOfInt[resourceType.ordinal()] + m;
/*  398 */           j += m; b1++; }
/*      */         
/*  400 */         arrayOfInt[ResourceType.values.length] = arrayOfInt[ResourceType.values.length] + StrictMath.round((1.0F - sourceTile.getResourceDensity()) * j);
/*      */       } 
/*      */     } 
/*      */     
/*  404 */     return arrayOfInt;
/*      */   }
/*      */   
/*      */   public final void unloadPreview() {
/*  408 */     if (this.m != null) {
/*  409 */       this.m.dispose();
/*  410 */       this.m = null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void regeneratePreview() {
/*  415 */     unloadPreview();
/*  416 */     this.m = Game.i.mapManager.generatePreview(this);
/*      */   }
/*      */   
/*      */   public final MapManager.MapPreview getPreview() {
/*  420 */     if (this.m == null || this.m.isDisposed()) {
/*  421 */       regeneratePreview();
/*      */     }
/*      */     
/*  424 */     return this.m; } public static Map fromJson(JsonValue paramJsonValue) { JsonValue jsonValue1; boolean bool; int j; JsonValue jsonValue2; Tile[][] arrayOfTile1; Tile[][] arrayOfTile2; Gate[][][] arrayOfGate1; JsonValue.JsonIterator<JsonValue> jsonIterator1; Gate[][][] arrayOfGate2; JsonValue jsonValue3; JsonValue jsonValue4;
/*      */     Array array;
/*      */     JsonValue.JsonIterator<JsonValue> jsonIterator2;
/*      */     int[] arrayOfInt;
/*  428 */     if (!paramJsonValue.isObject()) {
/*  429 */       throw new IllegalArgumentException("JsonValue must be an object");
/*      */     }
/*      */     
/*      */     int i;
/*  433 */     switch (i = paramJsonValue.getInt("v", 1)) {
/*      */       case 1:
/*  435 */         i = paramJsonValue.getInt("width");
/*  436 */         j = paramJsonValue.getInt("height");
/*  437 */         jsonValue2 = paramJsonValue.get("tiles");
/*      */         
/*  439 */         arrayOfTile2 = new Tile[j][i];
/*  440 */         for (jsonIterator1 = jsonValue2.iterator(); jsonIterator1.hasNext(); ) { JsonValue jsonValue = jsonIterator1.next();
/*  441 */           Tile tile = Game.i.tileManager.createTileFromJson(jsonValue);
/*  442 */           if (arrayOfTile2[tile.b][tile.a] == null) {
/*  443 */             arrayOfTile2[tile.b][tile.a] = Game.i.tileManager.createTileFromJson(jsonValue); continue;
/*      */           } 
/*  445 */           throw new IllegalArgumentException("Duplicate tile " + tile.a + ":" + tile.b); }
/*      */ 
/*      */ 
/*      */         
/*  449 */         arrayOfGate2 = new Gate[j + 1][i + 1][2];
/*      */ 
/*      */         
/*  452 */         if ((jsonValue4 = paramJsonValue.get("gates")) != null) {
/*  453 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue4.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/*  454 */             Gate gate = Game.i.gateManager.createGateFromJson(jsonValue);
/*  455 */             if (arrayOfGate2[gate.getY()][gate.getX()][gate.isLeftSide() ? 0 : 1] == null) {
/*  456 */               arrayOfGate2[gate.getY()][gate.getX()][gate.isLeftSide() ? 0 : 1] = gate; continue;
/*      */             } 
/*  458 */             throw new IllegalArgumentException("Duplicate gate " + gate.getX() + ":" + gate.getY() + " " + gate.isLeftSide()); }
/*      */         
/*      */         }
/*      */ 
/*      */         
/*  463 */         return new Map(arrayOfTile2, arrayOfGate2);
/*      */       
/*      */       case 2:
/*  466 */         i = paramJsonValue.getInt("w");
/*      */         
/*  468 */         arrayOfTile1 = new Tile[j = paramJsonValue.getInt("h")][i];
/*  469 */         arrayOfGate1 = new Gate[j + 1][i + 1][2];
/*  470 */         jsonValue3 = paramJsonValue.get("tt");
/*  471 */         array = new Array(true, 8, Tile.class);
/*  472 */         for (jsonIterator2 = jsonValue3.iterator(); jsonIterator2.hasNext(); ) { JsonValue jsonValue = jsonIterator2.next();
/*  473 */           Tile tile = null;
/*      */           try {
/*  475 */             tile = Game.i.tileManager.createTileFromJson(jsonValue);
/*  476 */           } catch (Exception exception) {
/*  477 */             a.e("failed to load tile from json: " + jsonValue.toJson(JsonWriter.OutputType.json), new Object[0]);
/*      */           } 
/*  479 */           array.add(tile); }
/*      */ 
/*      */         
/*  482 */         arrayOfInt = paramJsonValue.get("t").asIntArray();
/*  483 */         for (i = 0; i < arrayOfInt.length; i += 3) {
/*  484 */           Tile tile2; j = arrayOfInt[i];
/*  485 */           int k = arrayOfInt[i + 1];
/*  486 */           int m = arrayOfInt[i + 2];
/*      */           
/*      */           Tile tile1;
/*  489 */           if ((tile1 = ((Tile[])array.items)[j]) == null) {
/*      */             
/*  491 */             DummyTile dummyTile = Game.i.tileManager.F.DUMMY.create();
/*      */           } else {
/*  493 */             tile2 = tile1.cloneTile();
/*      */           } 
/*  495 */           tile2.a = k;
/*  496 */           tile2.b = m;
/*  497 */           arrayOfTile1[m][k] = tile2;
/*      */         } 
/*      */ 
/*      */         
/*  501 */         if ((jsonValue1 = paramJsonValue.get("gt")) != null) {
/*  502 */           Array array1 = new Array(true, 8, Gate.class);
/*  503 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/*  504 */             Gate gate = null;
/*      */             try {
/*  506 */               gate = Game.i.gateManager.createGateFromJson(jsonValue);
/*  507 */             } catch (Exception exception) {
/*  508 */               a.e("failed to load gate from json: " + jsonValue.toJson(JsonWriter.OutputType.json), new Object[0]);
/*      */             } 
/*  510 */             array1.add(gate); }
/*      */ 
/*      */           
/*  513 */           int[] arrayOfInt1 = paramJsonValue.get("g").asIntArray();
/*  514 */           for (byte b = 0; b < arrayOfInt1.length; b += 4) {
/*  515 */             int m = arrayOfInt1[b];
/*  516 */             int n = arrayOfInt1[b + 1];
/*  517 */             int k = arrayOfInt1[b + 2];
/*  518 */             bool = (arrayOfInt1[b + 3] == 1) ? true : false;
/*      */             try {
/*  520 */               if (m >= array1.size) {
/*  521 */                 throw new IllegalArgumentException("Template index " + m + " out of bounds, there's only " + array1.size + " templates");
/*      */               }
/*      */               Gate gate;
/*  524 */               if ((gate = ((Gate[])array1.items)[m]) != null)
/*      */               {
/*  526 */                 (gate = gate.cloneGate()).setPosition(n, k, bool);
/*  527 */                 arrayOfGate1[k][n][bool ? 0 : 1] = gate;
/*      */               }
/*      */             
/*  530 */             } catch (Exception exception) {
/*  531 */               throw new IllegalArgumentException("failed to load gate " + m + ":" + n + ":" + k, exception);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/*  536 */         return new Map(arrayOfTile1, arrayOfGate1);
/*      */     } 
/*      */     
/*  539 */     throw new IllegalArgumentException("Unrecognized map version: " + bool); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void toJson(Json paramJson) {
/*  548 */     a();
/*  549 */     paramJson.writeValue("v", Integer.valueOf(2));
/*  550 */     paramJson.writeValue("w", Integer.valueOf(this.d));
/*  551 */     paramJson.writeValue("h", Integer.valueOf(this.e));
/*      */ 
/*      */     
/*  554 */     Array array1 = new Array(true, 1, Tile.class);
/*  555 */     IntArray intArray1 = new IntArray();
/*  556 */     for (byte b1 = 0; b1 < this.g.size; b1++) {
/*  557 */       Tile tile = (Tile)this.g.get(b1);
/*  558 */       int i = -1;
/*  559 */       for (byte b = 0; b < array1.size; b++) {
/*  560 */         if (((Tile)array1.get(b)).sameAsWithExtras(tile)) {
/*  561 */           i = b;
/*      */           break;
/*      */         } 
/*      */       } 
/*  565 */       if (i == -1) {
/*      */         
/*  567 */         i = array1.size;
/*  568 */         array1.add(tile);
/*      */       } 
/*  570 */       intArray1.add(i, tile.a, tile.b);
/*      */     } 
/*      */     
/*  573 */     Array array2 = new Array(true, 1, Gate.class);
/*  574 */     IntArray intArray2 = new IntArray(); Array.ArrayIterator<Gate> arrayIterator;
/*  575 */     for (arrayIterator = this.h.iterator(); arrayIterator.hasNext(); ) { Gate gate = arrayIterator.next();
/*  576 */       int i = -1;
/*  577 */       for (byte b = 0; b < array2.size; b++) {
/*  578 */         if (((Gate)array2.get(b)).sameAs(gate)) {
/*  579 */           i = b;
/*      */           break;
/*      */         } 
/*      */       } 
/*  583 */       if (i == -1) {
/*      */         
/*  585 */         i = array2.size;
/*  586 */         array2.add(gate);
/*      */       } 
/*  588 */       intArray2.add(i, gate.getX(), gate.getY(), gate.isLeftSide() ? 1 : 0); }
/*      */ 
/*      */     
/*  591 */     paramJson.writeArrayStart("tt");
/*  592 */     for (arrayIterator = array1.iterator(); arrayIterator.hasNext(); ) { Tile tile = (Tile)arrayIterator.next();
/*  593 */       paramJson.writeObjectStart();
/*  594 */       int i = tile.a;
/*  595 */       int j = tile.b;
/*  596 */       tile.a = tile.b = 0;
/*  597 */       tile.toJson(paramJson);
/*  598 */       tile.a = i;
/*  599 */       tile.b = j;
/*  600 */       paramJson.writeObjectEnd(); }
/*      */     
/*  602 */     paramJson.writeArrayEnd();
/*      */     
/*  604 */     if (array2.size != 0) {
/*  605 */       paramJson.writeArrayStart("gt");
/*  606 */       for (arrayIterator = array2.iterator(); arrayIterator.hasNext(); ) { Gate gate = arrayIterator.next();
/*  607 */         paramJson.writeObjectStart();
/*  608 */         int i = gate.getX();
/*  609 */         int j = gate.getY();
/*  610 */         boolean bool = gate.isLeftSide();
/*  611 */         gate.setPosition(0, 0, false);
/*  612 */         gate.toJson(paramJson);
/*  613 */         gate.setPosition(i, j, bool);
/*  614 */         paramJson.writeObjectEnd(); }
/*      */       
/*  616 */       paramJson.writeArrayEnd();
/*      */     } 
/*      */     
/*  619 */     paramJson.writeArrayStart("t"); byte b2;
/*  620 */     for (b2 = 0; b2 < intArray1.size; b2++) {
/*  621 */       paramJson.writeValue(Integer.valueOf(intArray1.items[b2]));
/*      */     }
/*  623 */     paramJson.writeArrayEnd();
/*      */     
/*  625 */     if (array2.size != 0) {
/*  626 */       paramJson.writeArrayStart("g");
/*  627 */       for (b2 = 0; b2 < intArray2.size; b2++) {
/*  628 */         paramJson.writeValue(Integer.valueOf(intArray2.items[b2]));
/*      */       }
/*  630 */       paramJson.writeArrayEnd();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int generateSeed() {
/*  639 */     a();
/*  640 */     int i = 1;
/*      */     
/*  642 */     for (Array.ArrayIterator<Tile> arrayIterator = this.g.iterator(); arrayIterator.hasNext(); ) {
/*      */       Tile tile; int j;
/*  644 */       if ((j = (tile = arrayIterator.next()).generateSeedSalt()) != 0) i = i * 19 + j; 
/*  645 */       i = i * 23 + tile.type.ordinal();
/*  646 */       i = i * 29 + tile.a;
/*  647 */       i = i * 31 + tile.b;
/*      */     } 
/*      */     
/*  650 */     return i;
/*      */   }
/*      */   
/*      */   public final boolean hasTileThatAllowsWalkablePlatforms() {
/*  654 */     a();
/*      */     
/*  656 */     for (byte b = 0; b < this.g.size; b++) {
/*  657 */       if ((((Tile[])this.g.items)[b]).type == TileType.TARGET) {
/*      */         TargetTile targetTile;
/*      */         
/*  660 */         Array array = (targetTile = (TargetTile)((Tile[])this.g.items)[b]).getGameValues();
/*  661 */         for (byte b1 = 0; b1 < array.size; b1++) {
/*      */           GameValueConfig gameValueConfig;
/*  663 */           if ((gameValueConfig = ((GameValueConfig[])array.items)[b1]).getType() == GameValueType.ENEMIES_WALK_ON_PLATFORMS && gameValueConfig.getValue() >= 1.0D)
/*  664 */             return true; 
/*      */         } 
/*      */       } else {
/*  667 */         GameValueTile gameValueTile; if ((((Tile[])this.g.items)[b]).type == TileType.GAME_VALUE && (
/*      */ 
/*      */           
/*  670 */           gameValueTile = (GameValueTile)((Tile[])this.g.items)[b]).getGameValueType() == GameValueType.ENEMIES_WALK_ON_PLATFORMS && gameValueTile.getDelta() >= 1.0D) {
/*  671 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  677 */     return false;
/*      */   }
/*      */   
/*      */   private void a() {
/*  681 */     if (this.f) {
/*  682 */       b();
/*      */     }
/*      */   }
/*      */   
/*      */   private void b() {
/*  687 */     this.f = false;
/*      */     
/*  689 */     this.h.clear();
/*  690 */     this.g.clear(); ObjectMap.Values<Array> values;
/*  691 */     for (values = this.i.values().iterator(); values.hasNext();) {
/*  692 */       (array1 = values.next()).clear();
/*      */     }
/*  694 */     for (values = this.j.values().iterator(); values.hasNext();) {
/*  695 */       (array1 = values.next()).clear();
/*      */     }
/*  697 */     this.l.clear();
/*  698 */     this.k.clear();
/*      */     byte b1;
/*  700 */     for (b1 = 0; b1 < this.e; b1++) {
/*  701 */       for (byte b = 0; b < this.d; b++) {
/*      */         Tile tile;
/*  703 */         if ((tile = this.b[b1][b]) != null) {
/*  704 */           this.g.add(tile);
/*      */           
/*  706 */           Class<?> clazz = tile.getClass();
/*      */           Array array1;
/*  708 */           if ((array1 = (Array)this.i.get(clazz)) == null) {
/*  709 */             array1 = new Array(true, 1, clazz);
/*  710 */             this.i.put(clazz, array1);
/*      */           } 
/*  712 */           array1.add(tile);
/*      */         } 
/*      */       } 
/*      */     } 
/*  716 */     for (b1 = 0; b1 < this.e + 1; b1++) {
/*  717 */       for (byte b = 0; b < this.d + 1; b++) {
/*  718 */         for (byte b3 = 0; b3 < 2; b3++) {
/*      */           Gate gate;
/*  720 */           if ((gate = this.c[b1][b][b3]) != null) {
/*  721 */             this.h.add(gate);
/*      */             
/*  723 */             Class<?> clazz = gate.getClass();
/*      */             Array array1;
/*  725 */             if ((array1 = (Array)this.j.get(clazz)) == null) {
/*  726 */               array1 = new Array(true, 1, clazz);
/*  727 */               this.j.put(clazz, array1);
/*      */             } 
/*  729 */             array1.add(gate);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  735 */     Array<SpawnTile> array = getTilesByType(SpawnTile.class); byte b2; int i;
/*  736 */     for (b2 = 0, i = array.size; b2 < i; b2++) {
/*      */       SpawnTile spawnTile;
/*  738 */       Array array1 = (spawnTile = (SpawnTile)array.get(b2)).getAllowedEnemies(); int j; byte b;
/*  739 */       for (b = 0, j = array1.size; b < j; b++) {
/*  740 */         EnemyType enemyType = (((SpawnTile.AllowedEnemyConfig[])array1.items)[b]).enemyType;
/*  741 */         if (!this.l.contains(enemyType)) {
/*  742 */           this.k.add(enemyType);
/*  743 */           this.l.add(enemyType);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  748 */     this.m = null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public final Gate getGate(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  755 */     if (paramInt1 >= 0 && paramInt1 <= this.d && paramInt2 >= 0 && paramInt2 <= this.e) {
/*  756 */       return this.c[paramInt2][paramInt1][paramBoolean ? 0 : 1];
/*      */     }
/*      */     
/*  759 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean fitGateToMapPos(float paramFloat1, float paramFloat2, Gate paramGate) {
/*  768 */     int i = (int)(paramFloat1 / 128.0F);
/*  769 */     int j = (int)(paramFloat2 / 128.0F);
/*  770 */     paramFloat1 %= 128.0F;
/*  771 */     paramFloat2 %= 128.0F;
/*  772 */     float f1 = PMath.getSquareDistanceBetweenPoints(paramFloat1, paramFloat2, 64.0F, 128.0F);
/*  773 */     float f2 = PMath.getSquareDistanceBetweenPoints(paramFloat1, paramFloat2, 64.0F, 0.0F);
/*  774 */     float f3 = PMath.getSquareDistanceBetweenPoints(paramFloat1, paramFloat2, 0.0F, 64.0F);
/*  775 */     float f4 = PMath.getSquareDistanceBetweenPoints(paramFloat1, paramFloat2, 128.0F, 64.0F);
/*      */     
/*  777 */     if (f1 <= f2 && f1 <= f3 && f1 <= f4) {
/*      */       
/*  779 */       if (128.0F - paramFloat2 > 18.199999F) return false; 
/*  780 */       if (i < 0 || i >= this.d) return false; 
/*  781 */       if (j < -1 || j >= this.e) return false; 
/*  782 */       paramGate.setPosition(i, j + 1, false);
/*      */       
/*  784 */       return true;
/*  785 */     }  if (f2 <= f1 && f2 <= f4 && f2 <= f3) {
/*      */       
/*  787 */       if (paramFloat2 > 18.199999F || paramFloat2 < -18.199999F) return false; 
/*  788 */       if (i < 0 || i >= this.d) return false; 
/*  789 */       if (j < 0 || j > this.e) return false; 
/*  790 */       paramGate.setPosition(i, j, false);
/*      */       
/*  792 */       return true;
/*  793 */     }  if (f3 <= f1 && f3 <= f2 && f3 <= f4) {
/*      */       
/*  795 */       if (paramFloat1 > 18.199999F || paramFloat1 < -18.199999F) return false; 
/*  796 */       if (j < 0 || j >= this.e) return false; 
/*  797 */       if (i < 0 || i > this.d) return false; 
/*  798 */       paramGate.setPosition(i, j, true);
/*      */       
/*  800 */       return true;
/*      */     } 
/*      */     
/*  803 */     if (128.0F - paramFloat1 > 18.199999F) return false; 
/*  804 */     if (j < 0 || j >= this.e) return false; 
/*  805 */     if (i < -1 || i >= this.d) return false; 
/*  806 */     paramGate.setPosition(i + 1, j, true);
/*      */     
/*  808 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public final Gate getGateByMapPos(float paramFloat1, float paramFloat2) {
/*  820 */     if (fitGateToMapPos(paramFloat1, paramFloat2, this.p)) {
/*  821 */       return getGate(this.p.getX(), this.p.getY(), this.p.isLeftSide());
/*      */     }
/*      */     
/*  824 */     return null;
/*      */   }
/*      */   
/*      */   public final void setGate(int paramInt1, int paramInt2, boolean paramBoolean, @Null Gate paramGate) {
/*  828 */     if (paramInt1 < 0 || paramInt1 > this.d) {
/*  829 */       throw new IllegalArgumentException("x is out of range: " + paramInt1 + " (max " + (this.d + 1) + ")");
/*      */     }
/*  831 */     if (paramInt2 < 0 || paramInt2 > this.e) {
/*  832 */       throw new IllegalArgumentException("y is out of range: " + paramInt2 + " (max " + (this.e + 1) + ")");
/*      */     }
/*      */     
/*      */     Gate gate;
/*  836 */     if ((gate = getGate(paramInt1, paramInt2, paramBoolean)) == null && paramGate == null)
/*      */       return; 
/*  838 */     if (gate != null) {
/*  839 */       gate.setPosition(0, 0, true);
/*      */     }
/*      */     
/*  842 */     this.c[paramInt2][paramInt1][paramBoolean ? 0 : 1] = paramGate;
/*  843 */     if (paramGate != null) {
/*  844 */       paramGate.setPosition(paramInt1, paramInt2, paramBoolean);
/*      */     }
/*      */     
/*  847 */     this.f = true;
/*      */   }
/*      */   @Null
/*      */   public final Tile getTileAtPos(Tile.Pos paramPos) {
/*  851 */     Preconditions.checkNotNull(paramPos);
/*  852 */     return getTile(paramPos.getX(), paramPos.getY());
/*      */   }
/*      */   @Null
/*      */   public final Gate getGateAtPos(Gate.Pos paramPos) {
/*  856 */     Preconditions.checkNotNull(paramPos);
/*  857 */     return getGate(paramPos.getX(), paramPos.getY(), paramPos.isLeft());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public final Tile getTile(int paramInt1, int paramInt2) {
/*  864 */     if (paramInt2 >= 0 && paramInt2 < this.e && paramInt1 >= 0 && paramInt1 < this.d) {
/*  865 */       return this.b[paramInt2][paramInt1];
/*      */     }
/*      */     
/*  868 */     return null;
/*      */   }
/*      */   
/*      */   public final Tile[][] getTilesRaw() {
/*  872 */     return this.b;
/*      */   }
/*      */   
/*      */   public final Gate[][][] getGatesRaw() {
/*  876 */     return this.c;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final DelayedRemovalArray<Tile> getAllTiles() {
/*  883 */     a();
/*  884 */     return this.g;
/*      */   }
/*      */   
/*      */   public final DelayedRemovalArray<Gate> getAllGates() {
/*  888 */     a();
/*  889 */     return this.h;
/*      */   }
/*      */   
/*      */   public final Tile getTileByMapPosV(Vector2 paramVector2) {
/*  893 */     return getTileByMapPos(paramVector2.x, paramVector2.y);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public final IntPair getTileCoordinatesByMapPos(float paramFloat1, float paramFloat2) {
/*  900 */     if (paramFloat1 < 0.0F || paramFloat2 < 0.0F) return null; 
/*  901 */     int i = (int)(paramFloat1 * 0.0078125F);
/*  902 */     int j = (int)(paramFloat2 * 0.0078125F);
/*  903 */     if (i >= this.d || j >= this.e) return null; 
/*  904 */     this.n.a = i;
/*  905 */     this.n.b = j;
/*  906 */     return this.n;
/*      */   }
/*      */   
/*      */   public final Tile getTileByMapPos(float paramFloat1, float paramFloat2) {
/*  910 */     if (paramFloat1 < 0.0F || paramFloat2 < 0.0F) return null; 
/*  911 */     return getTile((int)(paramFloat1 * 0.0078125F), (int)(paramFloat2 * 0.0078125F));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setTile(int paramInt1, int paramInt2, @Null Tile paramTile) {
/*  919 */     if (paramInt1 < 0 || paramInt1 >= this.d) {
/*  920 */       throw new IllegalArgumentException("x is out of range: " + paramInt1 + " (max " + this.d + ")");
/*      */     }
/*  922 */     if (paramInt2 < 0 || paramInt2 >= this.e) {
/*  923 */       throw new IllegalArgumentException("y is out of range: " + paramInt2 + " (max " + this.e + ")");
/*      */     }
/*      */     
/*      */     Tile tile;
/*  927 */     if ((tile = getTile(paramInt1, paramInt2)) == paramTile)
/*      */       return; 
/*  929 */     if (tile != null) {
/*  930 */       tile.setPos(0, 0);
/*      */     }
/*      */     
/*  933 */     this.b[paramInt2][paramInt1] = paramTile;
/*  934 */     if (paramTile != null) {
/*  935 */       this.b[paramInt2][paramInt1].setPos(paramInt1, paramInt2);
/*      */     }
/*      */     
/*  938 */     this.f = true;
/*      */   }
/*      */   
/*      */   public final Map cpy() {
/*  942 */     Tile[][] arrayOfTile = new Tile[this.b.length][(this.b[0]).length];
/*  943 */     for (byte b1 = 0; b1 < this.b.length; b1++) {
/*  944 */       for (byte b = 0; b < (this.b[b1]).length; b++) {
/*  945 */         if (this.b[b1][b] != null) {
/*  946 */           arrayOfTile[b1][b] = this.b[b1][b].cloneTile();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  951 */     Gate[][][] arrayOfGate = new Gate[this.b.length + 1][(this.b[0]).length + 1][2];
/*  952 */     for (byte b2 = 0; b2 <= this.e; b2++) {
/*  953 */       for (byte b = 0; b <= this.d; b++) {
/*  954 */         for (byte b3 = 0; b3 < 2; b3++) {
/*  955 */           if (this.c[b2][b][b3] != null) {
/*  956 */             arrayOfGate[b2][b][b3] = this.c[b2][b][b3].cloneGate();
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  962 */     return new Map(arrayOfTile, arrayOfGate);
/*      */   }
/*      */   
/*      */   public final IntRectangle getTrimBounds() {
/*  966 */     a();
/*      */     
/*  968 */     int i = Integer.MAX_VALUE;
/*  969 */     int j = Integer.MAX_VALUE;
/*  970 */     int k = Integer.MIN_VALUE;
/*  971 */     int m = Integer.MIN_VALUE;
/*      */     Array.ArrayIterator<Tile> arrayIterator;
/*  973 */     for (arrayIterator = this.g.iterator(); arrayIterator.hasNext(); ) {
/*  974 */       Tile tile; int i1 = (tile = arrayIterator.next()).getX();
/*  975 */       int n = tile.getY();
/*  976 */       if (i1 < i) i = i1; 
/*  977 */       if (i1 > k) k = i1; 
/*  978 */       if (n < j) j = n; 
/*  979 */       if (n > m) m = n; 
/*      */     } 
/*  981 */     for (arrayIterator = this.h.iterator(); arrayIterator.hasNext(); ) {
/*  982 */       Gate gate; int i1 = (gate = (Gate)arrayIterator.next()).getX();
/*  983 */       int n = gate.getY();
/*  984 */       if (i1 < i) i = i1; 
/*  985 */       if (i1 > k) k = i1; 
/*  986 */       if (n < j) j = n; 
/*  987 */       if (n > m) m = n; 
/*      */     } 
/*  989 */     this.o.set(i, k, j, m);
/*      */     
/*  991 */     return this.o;
/*      */   }
/*      */   
/*      */   public final int getWidth() {
/*  995 */     return this.d;
/*      */   }
/*      */   
/*      */   public final int getHeight() {
/*  999 */     return this.e;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Map cpyTrimmed() {
/*      */     IntRectangle intRectangle;
/* 1007 */     if ((intRectangle = getTrimBounds()).minX == Integer.MAX_VALUE)
/*      */     {
/* 1009 */       return new Map(1, 1);
/*      */     }
/*      */     
/* 1012 */     int i = intRectangle.maxX - intRectangle.minX + 1;
/*      */     
/*      */     int j;
/*      */     
/* 1016 */     Tile[][] arrayOfTile = new Tile[j = intRectangle.maxY - intRectangle.minY + 1][i];
/* 1017 */     for (j = 0; j < this.b.length; j++) {
/* 1018 */       for (byte b1 = 0; b1 < (this.b[j]).length; b1++) {
/* 1019 */         if (this.b[j][b1] != null) {
/* 1020 */           arrayOfTile[j - intRectangle.minY][b1 - intRectangle.minX] = this.b[j][b1].cloneTile();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1025 */     Gate[][][] arrayOfGate = new Gate[arrayOfTile.length + 1][(arrayOfTile[0]).length + 1][2];
/* 1026 */     for (byte b = 0; b <= this.e; b++) {
/* 1027 */       for (byte b1 = 0; b1 <= this.d; b1++) {
/* 1028 */         for (byte b2 = 0; b2 < 2; b2++) {
/* 1029 */           if (this.c[b][b1][b2] != null) {
/* 1030 */             arrayOfGate[b - intRectangle.minY][b1 - intRectangle.minX][b2] = this.c[b][b1][b2].cloneGate();
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1036 */     return new Map(arrayOfTile, arrayOfGate);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public final WaveBossSupplier getBossWaves() {
/* 1043 */     a();
/*      */     
/* 1045 */     boolean bool = false;
/* 1046 */     Array<SpawnTile> array = getTilesByType(SpawnTile.class);
/* 1047 */     for (byte b = 0; b < array.size; b++) {
/* 1048 */       if (((SpawnTile[])array.items)[b].getAllowedEnemiesSet().contains(EnemyType.BOSS)) {
/* 1049 */         bool = true;
/*      */         break;
/*      */       } 
/*      */     } 
/* 1053 */     if (bool) {
/*      */       Array<BossTile> array1;
/* 1055 */       if ((array1 = getTilesByType(BossTile.class)).size != 0) {
/* 1056 */         return ((BossTile)array1.first()).getBossWaveMap();
/*      */       }
/* 1058 */       return null;
/*      */     } 
/*      */     
/* 1061 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int posToCell(float paramFloat) {
/* 1069 */     return (int)((paramFloat + 32768.0F) * 0.0078125F) - 256;
/*      */   }
/*      */   
/*      */   public final Array<EnemyType> getAllowedEnemies() {
/* 1073 */     a();
/* 1074 */     return this.k;
/*      */   }
/*      */   
/*      */   public final ObjectSet<EnemyType> getAllowedEnemiesSet() {
/* 1078 */     a();
/* 1079 */     return this.l;
/*      */   }
/*      */   
/*      */   public final XmMusicTrackTile getMusicTile() {
/*      */     Array<XmMusicTrackTile> array;
/* 1084 */     if ((array = getTilesByType(XmMusicTrackTile.class)).size == 0) return null; 
/* 1085 */     return (XmMusicTrackTile)array.first();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void validate() {
/*      */     Array array;
/* 1093 */     a();
/*      */ 
/*      */     
/* 1096 */     boolean bool1 = false;
/* 1097 */     byte b1 = 0;
/* 1098 */     for (Array.ArrayIterator<Tile> arrayIterator = this.g.iterator(); arrayIterator.hasNext(); ) {
/* 1099 */       Tile tile; if ((tile = arrayIterator.next()).type == TileType.SPAWN) {
/* 1100 */         b1 = 1; continue;
/* 1101 */       }  if (tile.type == TileType.TARGET) {
/* 1102 */         if (bool1) {
/* 1103 */           Array array1 = new Array();
/* 1104 */           for (Array.ArrayIterator<Tile> arrayIterator1 = this.g.iterator(); arrayIterator1.hasNext();) {
/* 1105 */             if ((tile1 = arrayIterator1.next()).type == TileType.TARGET) {
/* 1106 */               array1.add(tile1);
/*      */             }
/*      */           } 
/* 1109 */           throw new InvalidMapException(InvalidMapException.Reason.MULTIPLE_TARGETS, array1);
/*      */         } 
/* 1111 */         bool1 = true;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1116 */     byte b2 = 0;
/* 1117 */     boolean bool2 = false;
/* 1118 */     byte b3 = 0;
/* 1119 */     boolean bool3 = false;
/* 1120 */     for (byte b4 = 0; b4 < this.e; b4++) {
/* 1121 */       for (byte b = 0; b < this.d; b++) {
/*      */         Tile tile1; Tile tile2;
/* 1123 */         if ((tile2 = this.b[b4][b]) != null && tile2.type == TileType.XM_MUSIC_TRACK) {
/* 1124 */           if (b2) {
/* 1125 */             array = new Array();
/* 1126 */             for (b1 = 0; b1 < this.e; b1++) {
/* 1127 */               for (b2 = 0; b2 < this.d; b2++) {
/*      */                 
/* 1129 */                 if ((tile1 = this.b[b1][b2]) != null && tile1.type == TileType.XM_MUSIC_TRACK) {
/* 1130 */                   array.add(tile1);
/*      */                 }
/*      */               } 
/*      */             } 
/* 1134 */             throw new InvalidMapException(InvalidMapException.Reason.MULTIPLE_SOUND_TRACKS, array);
/*      */           } 
/*      */           
/* 1137 */           b2 = 1;
/* 1138 */         } else if (tile2 != null && tile2.type == TileType.CORE) {
/* 1139 */           if (tile1 != null) {
/* 1140 */             array = new Array();
/* 1141 */             for (b1 = 0; b1 < this.e; b1++) {
/* 1142 */               for (b2 = 0; b2 < this.d; b2++) {
/*      */                 
/* 1144 */                 if ((tile1 = this.b[b1][b2]) != null && tile1.type == TileType.CORE) {
/* 1145 */                   array.add(tile1);
/*      */                 }
/*      */               } 
/*      */             } 
/* 1149 */             throw new InvalidMapException(InvalidMapException.Reason.MULTIPLE_CORES, array);
/*      */           } 
/*      */           
/* 1152 */           boolean bool = true;
/* 1153 */         } else if (tile2 != null && tile2.type == TileType.BOSS) {
/* 1154 */           if (bool3) {
/* 1155 */             array = new Array();
/* 1156 */             for (b1 = 0; b1 < this.e; b1++) {
/* 1157 */               for (b2 = 0; b2 < this.d; b2++) {
/*      */                 
/* 1159 */                 if ((tile1 = this.b[b1][b2]) != null && tile1.type == TileType.BOSS) {
/* 1160 */                   array.add(tile1);
/*      */                 }
/*      */               } 
/*      */             } 
/* 1164 */             throw new InvalidMapException(InvalidMapException.Reason.MULTIPLE_BOSS_TILES, array);
/*      */           } 
/*      */           
/* 1167 */           bool3 = true;
/*      */         } else {
/* 1169 */           b3++;
/* 1170 */           if (tile2 != null && tile2.type == TileType.SPAWN && b3 > 8) {
/* 1171 */             array = new Array();
/* 1172 */             for (b1 = 0; b1 < this.e; b1++) {
/* 1173 */               for (b2 = 0; b2 < this.d; b2++) {
/*      */                 
/* 1175 */                 if ((tile1 = this.b[b1][b2]) != null && tile1.type == TileType.SPAWN) {
/* 1176 */                   array.add(tile1);
/*      */                 }
/*      */               } 
/*      */             } 
/* 1180 */             throw new InvalidMapException(InvalidMapException.Reason.TOO_MANY_PORTALS, array);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1187 */     if (b1 == 0) {
/* 1188 */       throw new InvalidMapException(InvalidMapException.Reason.SPAWN_NOT_FOUND, new Array());
/*      */     }
/*      */ 
/*      */     
/* 1192 */     if (array == null)
/* 1193 */       throw new InvalidMapException(InvalidMapException.Reason.TARGET_NOT_FOUND, new Array()); 
/*      */   }
/*      */   
/*      */   private Map() {}
/*      */   
/*      */   public static class InvalidMapException extends RuntimeException { public enum Reason {
/* 1199 */       MULTIPLE_TARGETS,
/* 1200 */       MULTIPLE_SOUND_TRACKS,
/* 1201 */       SPAWN_NOT_FOUND,
/* 1202 */       TARGET_NOT_FOUND,
/* 1203 */       TOO_MANY_PORTALS,
/* 1204 */       MULTIPLE_CORES,
/* 1205 */       MULTIPLE_BOSS_TILES;
/*      */     }
/*      */     
/* 1208 */     public final Array<Tile> invalidTiles = new Array();
/*      */     
/*      */     public final Reason reason;
/*      */ 
/*      */     
/*      */     public InvalidMapException(Reason param1Reason, Array<Tile> param1Array) {
/* 1214 */       this.reason = param1Reason;
/* 1215 */       if (param1Array != null) this.invalidTiles.addAll(param1Array);
/*      */     
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getFixHintMessage() {
/* 1222 */       String str = this.reason.name();
/* 1223 */       return Game.i.localeManager.i18n.get("invalid_map_format_hint_" + str);
/*      */     } }
/*      */   
/*      */   public enum Reason { MULTIPLE_TARGETS, MULTIPLE_SOUND_TRACKS, SPAWN_NOT_FOUND, TARGET_NOT_FOUND, TOO_MANY_PORTALS, MULTIPLE_CORES, MULTIPLE_BOSS_TILES; }
/*      */   
/*      */   public static class EnemyTypeSpawnPair { public EnemyType enemyType;
/*      */     public SpawnTile spawnTile;
/*      */     
/*      */     public EnemyTypeSpawnPair(EnemyType param1EnemyType, SpawnTile param1SpawnTile) {
/* 1232 */       this.enemyType = param1EnemyType;
/* 1233 */       this.spawnTile = param1SpawnTile;
/*      */     } }
/*      */ 
/*      */   
/*      */   public static class PathNotFoundForEnemyTypeException extends RuntimeException {
/*      */     public EnemyType enemyType;
/*      */     
/*      */     public PathNotFoundForEnemyTypeException(EnemyType param1EnemyType, Throwable param1Throwable) {
/* 1241 */       super("Path not found for enemy type: " + param1EnemyType, param1Throwable);
/*      */       
/* 1243 */       this.enemyType = param1EnemyType;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Map.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */