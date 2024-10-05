/*      */ package com.prineside.tdi2.systems;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystem;
/*      */ import com.prineside.tdi2.GameSystemProvider;
/*      */ import com.prineside.tdi2.Gate;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Map;
/*      */ import com.prineside.tdi2.MapElementPos;
/*      */ import com.prineside.tdi2.Screen;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.Tile;
/*      */ import com.prineside.tdi2.UserMap;
/*      */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*      */ import com.prineside.tdi2.events.Event;
/*      */ import com.prineside.tdi2.events.game.MouseMove;
/*      */ import com.prineside.tdi2.events.game.Render;
/*      */ import com.prineside.tdi2.events.mapEditor.HistoryUpdate;
/*      */ import com.prineside.tdi2.events.mapEditor.MapEditorSelectionChange;
/*      */ import com.prineside.tdi2.events.mapEditor.MapValidationFail;
/*      */ import com.prineside.tdi2.items.GateItem;
/*      */ import com.prineside.tdi2.items.TileItem;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.screens.MapEditorScreen;
/*      */ import com.prineside.tdi2.ui.components.MapEditorInventoryMenu;
/*      */ import com.prineside.tdi2.ui.components.MapEditorItemInfoMenu;
/*      */ import com.prineside.tdi2.ui.components.MapEditorUi;
/*      */ import com.prineside.tdi2.ui.components.MapShiftButtons;
/*      */ import com.prineside.tdi2.ui.shared.AbilitySelectionOverlay;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.utils.IntRectangle;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectPair;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import com.prineside.tdi2.utils.mapeditor.Selection;
/*      */ import com.prineside.tdi2.utils.mapeditor.tools.Draw;
/*      */ import com.prineside.tdi2.utils.mapeditor.tools.Move;
/*      */ import com.prineside.tdi2.utils.mapeditor.tools.Remove;
/*      */ import com.prineside.tdi2.utils.mapeditor.tools.SelectRectangle;
/*      */ import com.prineside.tdi2.utils.mapeditor.tools.View;
/*      */ import java.io.StringWriter;
/*      */ import java.util.concurrent.atomic.AtomicBoolean;
/*      */ 
/*      */ public final class MapEditorSystem
/*      */   extends GameSystem {
/*   61 */   private static final TLog a = TLog.forClass(MapEditorSystem.class);
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int HISTORY_SIZE = 30;
/*      */ 
/*      */   
/*   68 */   public static final Color SELECTION_OUTLINE_COLOR = MaterialColor.LIGHT_BLUE.P500;
/*   69 */   public static final Color SELECTION_FILL_COLOR = MaterialColor.LIGHT_BLUE.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.07F);
/*      */   
/*   71 */   public final Selection selection = new Selection();
/*      */   @Null
/*      */   private MapElementPos b;
/*   74 */   private final Array<Tool> c = new Array();
/*      */   private Tool d;
/*   76 */   private final Array<HistoryImprint> e = new Array(true, 1, HistoryImprint.class);
/*      */   
/*      */   private int f;
/*   79 */   public InventoryDefaultListener inventoryDefaultListener = new InventoryDefaultListener(this);
/*      */ 
/*      */   
/*      */   public boolean basicLevelEditor = false;
/*      */   
/*      */   public boolean mapChanged;
/*      */   
/*      */   public UserMap userMap;
/*      */   
/*      */   public BasicLevel basicLevel;
/*      */   
/*   90 */   private final AtomicBoolean g = new AtomicBoolean(false);
/*      */ 
/*      */   
/*      */   public final boolean affectsGameState() {
/*   94 */     return false;
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
/*      */   public final void setup() {
/*  106 */     this.S._render.addLayer(new RenderSystem.Layer(GameRenderingOrder.MAP_RENDERING_MAP_EDITOR_SELECTION, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> {
/*      */             if (!this.selection.isFromInventory()) {
/*      */               IntRectangle intRectangle = this.selection.dimensions();
/*      */               
/*      */               this.selection.drawOutline(paramBatch, (intRectangle.minX << 7), (intRectangle.minY << 7), 1.0F, 1.0F, SELECTION_OUTLINE_COLOR, SELECTION_FILL_COLOR);
/*      */             } 
/*      */             
/*      */             if (this.b != null) {
/*      */               Tile tile = getHoveredTile();
/*      */               Gate gate;
/*      */               if ((gate = getHoveredGate()) != null) {
/*      */                 GameMapSelectionSystem.drawGateHover(paramBatch, gate.getX(), gate.getY(), gate.isLeftSide());
/*      */                 return;
/*      */               } 
/*      */               if (tile != null) {
/*      */                 GameMapSelectionSystem.drawTileHover(paramBatch, tile.getX(), tile.getY());
/*      */               }
/*      */             } 
/*      */           }));
/*  125 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MODIFIER_DRAW_BATCH, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> ModifierSystem.drawBatch(paramBatch, this.S.map.getMap(), paramFloat2, MapRenderingSystem.DrawMode.MAP_EDITOR)))
/*      */ 
/*      */         
/*  128 */         .setName("MapEditorSystem-drawModifiersBatch"));
/*      */     
/*  130 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MODIFIER_DRAW_BATCH_ADDITIVE, true, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> ModifierSystem.drawBatchAdditive(paramBatch, this.S.map.getMap(), paramFloat2, MapRenderingSystem.DrawMode.MAP_EDITOR)))
/*      */ 
/*      */         
/*  133 */         .setName("MapEditorSystem-drawModifiersBatchAdditive"));
/*      */     
/*  135 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.MINER_DRAW_BATCH, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> MinerSystem.drawBatch(paramBatch, this.S.map.getMap(), paramFloat2, MapRenderingSystem.DrawMode.MAP_EDITOR)))
/*      */ 
/*      */         
/*  138 */         .setName("MapEditorSystem-drawMinersBatch"));
/*      */     
/*  140 */     this.S.events.getListeners(MouseMove.class).add(paramMouseMove -> a(paramMouseMove.getMapX(), paramMouseMove.getMapY())).setDescription("MapEditorSystem - handles hover");
/*  141 */     this.S.events.getListeners(Render.class).addWithPriority(paramRender -> c(), 3000).setDescription("MapEditorSystem - handles input");
/*      */   }
/*      */   
/*      */   private void b() {
/*  145 */     Threads.i().runAsync(() -> {
/*      */           try {
/*      */             Map map = this.S.map.getMap().cpy();
/*      */             
/*      */             Json json = new Json(JsonWriter.OutputType.minimal);
/*      */             
/*      */             StringWriter stringWriter = new StringWriter();
/*      */             
/*      */             json.setWriter(stringWriter);
/*      */             
/*      */             json.writeObjectStart();
/*      */             
/*      */             json.writeValue("isBasicLevel", Boolean.valueOf(this.basicLevelEditor));
/*      */             if (this.basicLevelEditor) {
/*      */               json.writeValue("mapId", this.basicLevel.name);
/*      */               json.writeValue("mapName", this.basicLevel.name);
/*      */             } else {
/*      */               json.writeValue("mapId", this.userMap.id);
/*      */               json.writeValue("mapName", this.userMap.name);
/*      */             } 
/*      */             json.writeValue("timestamp", Long.valueOf(Game.getTimestampMillis()));
/*      */             json.writeObjectStart("map");
/*      */             map.toJson(json);
/*      */             json.writeObjectEnd();
/*      */             json.writeObjectEnd();
/*      */             if (!this.g.get()) {
/*      */               Gdx.files.local("cache/map-editor-backup.json").writeString(stringWriter.toString(), false, "UTF-8");
/*      */             }
/*      */             return;
/*  174 */           } catch (Exception exception) {
/*      */             if (Game.i.settingsManager.isInDebugDetailedMode()) {
/*      */               a.e("failed to auto-save the map", new Object[] { exception });
/*      */             }
/*      */             return;
/*      */           } 
/*      */         });
/*      */   }
/*      */   
/*      */   public final void postSetup() {
/*  184 */     this.S._mapEditorUi.itemInfoMenu.addListener(new MapEditorItemInfoMenu.MapEditorTileInfoMenuListener(this)
/*      */         {
/*      */           public void selectedElementModified() {
/*  187 */             if (!this.a.selection.isFromInventory() && this.a.selection.count() == 1) {
/*  188 */               MapEditorSystem.HistoryImprint historyImprint = this.a.startActionRecord();
/*  189 */               if (this.a.selection.tiles.size != 0) {
/*      */                 
/*  191 */                 Tile tile = (Tile)this.a.selection.tiles.first();
/*  192 */                 this.a.S.map.setTile(tile.getX(), tile.getY(), tile.cloneTile());
/*      */               } else {
/*      */                 
/*  195 */                 Gate gate = (Gate)this.a.selection.gates.first();
/*  196 */                 this.a.S.map.setGate(gate.getX(), gate.getY(), gate.isLeftSide(), gate.cloneGate());
/*      */               } 
/*  198 */               this.a.finishActionRecord(historyImprint);
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           public void menuUpdated() {}
/*      */         });
/*  207 */     View view = new View();
/*  208 */     registerTool((Tool)new Remove());
/*  209 */     registerTool((Tool)new Draw());
/*  210 */     registerTool((Tool)new Move());
/*  211 */     registerTool((Tool)new SelectRectangle());
/*  212 */     registerTool((Tool)view);
/*      */     
/*  214 */     selectTool((Tool)view);
/*      */   }
/*      */   
/*      */   private void c() {
/*  218 */     if (Gdx.input.isKeyJustPressed(61)) {
/*  219 */       this.S._mapEditorUi.inventoryMenu.getSideMenu().setOffscreen(!this.S._mapEditorUi.inventoryMenu.getSideMenu().isOffscreen());
/*      */     }
/*  221 */     if ((Gdx.input.isKeyPressed(129) && Gdx.input.isKeyJustPressed(54)) || (Gdx.input.isKeyJustPressed(129) && Gdx.input.isKeyPressed(54))) {
/*      */       
/*  223 */       if (Gdx.input.isKeyPressed(59)) {
/*  224 */         historyForward(); return;
/*      */       } 
/*  226 */       historyBack();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void registerTool(Tool paramTool) {
/*  232 */     this.c.add(paramTool);
/*  233 */     paramTool.setup(this.S);
/*      */   }
/*      */   @Null
/*      */   public final Tile getHoveredTile() {
/*  237 */     return (this.b instanceof Tile.Pos) ? this.S.map.getMap().getTileAtPos((Tile.Pos)this.b) : null;
/*      */   }
/*      */   @Null
/*      */   public final Gate getHoveredGate() {
/*  241 */     return (this.b instanceof Gate.Pos) ? this.S.map.getMap().getGateAtPos((Gate.Pos)this.b) : null;
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(float paramFloat1, float paramFloat2) {
/*      */     Map map;
/*      */     Gate gate;
/*  248 */     if ((gate = (map = this.S.map.getMap()).getGateByMapPos(paramFloat1, paramFloat2)) != null) {
/*      */       
/*  250 */       this.b = (MapElementPos)new Gate.Pos(gate.getX(), gate.getY(), gate.isLeftSide()); return;
/*      */     } 
/*      */     Tile tile;
/*  253 */     if ((tile = map.getTileByMapPos(paramFloat1, paramFloat2)) == null) {
/*  254 */       this.b = null; return;
/*      */     } 
/*  256 */     this.b = (MapElementPos)new Tile.Pos(tile.getX(), tile.getY());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final HistoryImprint startActionRecord() {
/*  262 */     return new HistoryImprint((byte)0);
/*      */   }
/*      */   
/*      */   public final void finishActionRecord(HistoryImprint paramHistoryImprint) {
/*  266 */     Preconditions.checkNotNull(paramHistoryImprint, "imprint can not be null");
/*  267 */     HistoryImprint.a(paramHistoryImprint);
/*  268 */     a(paramHistoryImprint);
/*      */   }
/*      */   
/*      */   private void a(HistoryImprint paramHistoryImprint) {
/*  272 */     if (!HistoryImprint.b(paramHistoryImprint)) {
/*  273 */       a.e("imprint is not sealed", new Object[0]);
/*      */       return;
/*      */     } 
/*  276 */     if (paramHistoryImprint.getChangesCount() == 0) {
/*  277 */       a.i("no changes in history imprint, skipping", new Object[0]);
/*      */       
/*      */       return;
/*      */     } 
/*  281 */     if (this.f == 30) {
/*  282 */       this.e.removeIndex(0);
/*  283 */       this.f--;
/*      */     } 
/*  285 */     this.e.setSize(this.f);
/*  286 */     this.e.add(paramHistoryImprint);
/*  287 */     this.f++;
/*  288 */     this.S.events.trigger((Event)new HistoryUpdate());
/*  289 */     this.mapChanged = true;
/*      */     
/*  291 */     b();
/*      */   }
/*      */   
/*      */   public final void historyBack() {
/*  295 */     if (this.f > 0) {
/*      */       HistoryImprint historyImprint;
/*  297 */       if (!HistoryImprint.b(historyImprint = (HistoryImprint)this.e.get(this.f - 1))) {
/*  298 */         a.e("last history imprint is not sealed yet", new Object[0]); return;
/*      */       } 
/*  300 */       historyImprint.revert();
/*  301 */       this.f--;
/*  302 */       this.S.events.trigger((Event)new HistoryUpdate());
/*  303 */       this.mapChanged = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean hasHistoryBack() {
/*  309 */     return (this.f > 0);
/*      */   }
/*      */   
/*      */   public final boolean hasHistoryForward() {
/*  313 */     return (this.f < this.e.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Array<HistoryImprint> getHistory() {
/*  320 */     return this.e;
/*      */   }
/*      */   
/*      */   public final int getHistoryPointer() {
/*  324 */     return this.f;
/*      */   }
/*      */   
/*      */   public final void historyForward() {
/*  328 */     if (this.f < this.e.size) {
/*      */       HistoryImprint historyImprint;
/*  330 */       if (!HistoryImprint.b(historyImprint = (HistoryImprint)this.e.get(this.f))) {
/*  331 */         a.e("last history imprint is not sealed yet", new Object[0]); return;
/*      */       } 
/*  333 */       historyImprint.repeat();
/*  334 */       this.f++;
/*  335 */       this.S.events.trigger((Event)new HistoryUpdate());
/*  336 */       this.mapChanged = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final String getSystemName() {
/*  343 */     return "MapEditor";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean selectTool(Tool paramTool) {
/*  350 */     if (this.d != paramTool) {
/*  351 */       if (this.d != null) this.d.disabled(); 
/*  352 */       Tool tool = this.d;
/*  353 */       d();
/*  354 */       this.d = paramTool;
/*  355 */       paramTool.enabled(tool);
/*  356 */       return true;
/*      */     } 
/*  358 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void d() {
/*  363 */     this.S._mapEditorUi.inventoryMenu.setItemDraggingMode(false);
/*  364 */     this.S._mapEditorUi.inventoryMenu.clearListeners();
/*  365 */     this.S._mapEditorUi.inventoryMenu.addListener((MapEditorInventoryMenu.MapEditorInventoryMenuListener)this.inventoryDefaultListener);
/*      */     
/*  367 */     this.S._input.enableAllInput();
/*      */ 
/*      */     
/*  370 */     (this.S._input.getCameraController()).dragButtonIndices.clear();
/*  371 */     (this.S._input.getCameraController()).dragButtonIndices.add(0, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Tool getTool() {
/*  381 */     return this.d;
/*      */   }
/*      */   
/*      */   public final Array<Tool> getTools() {
/*  385 */     return this.c;
/*      */   }
/*      */   
/*      */   private void a(MapEditorInventoryMenu.ItemSlot paramItemSlot) {
/*  389 */     this.selection.clear();
/*  390 */     this.selection.setFromInventory(true);
/*      */     
/*      */     Item item;
/*  393 */     if (item = paramItemSlot.getItemStack().getItem() instanceof TileItem) {
/*  394 */       this.selection.addTile(((TileItem)item).tile);
/*  395 */     } else if (item instanceof GateItem) {
/*  396 */       this.selection.addGate(((GateItem)item).gate);
/*      */     } else {
/*  398 */       a.e("can't selectItemFromInventory - " + item + " is not a tile/gate", new Object[0]);
/*      */     } 
/*  400 */     notifySelectionChanged();
/*      */   }
/*      */   
/*      */   public final void notifySelectionChanged() {
/*  404 */     this.S.events.trigger((Event)new MapEditorSelectionChange());
/*      */   }
/*      */   
/*      */   public final void deselectAll() {
/*  408 */     this.selection.clear();
/*  409 */     notifySelectionChanged();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean startMap() {
/*  416 */     a.i("starting the map...", new Object[0]);
/*      */     try {
/*  418 */       this.S.map.getMap().validate();
/*  419 */     } catch (com.prineside.tdi2.Map.InvalidMapException invalidMapException) {
/*  420 */       this.S.events.trigger((Event)new MapValidationFail(invalidMapException));
/*      */       
/*  422 */       return false;
/*      */     } 
/*      */     
/*  425 */     saveMap();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Runnable runnable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  490 */     (runnable = (() -> { if (GameStateSystem.savedGameExists()) { Dialog.i().showConfirm(Game.i.localeManager.i18n.get("saved_game_will_be_lost_confirm"), ()); return; }  paramRunnable.run(); })).run();
/*      */     
/*  492 */     return true;
/*      */   }
/*      */   
/*      */   public final void saveMap() {
/*  496 */     if (this.basicLevelEditor) {
/*  497 */       Game.i.basicLevelManager.setMap(this.basicLevel, this.S.map.getMap().cpy()); return;
/*      */     } 
/*  499 */     this.userMap.map = this.S.map.getMap().cpy();
/*  500 */     ProgressPrefs.i().requireSave();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void goToPreviousScreen() {
/*  506 */     if (this.mapChanged) {
/*  507 */       Dialog.i().showConfirmWithCallbacks(Game.i.localeManager.i18n.get("edited_map_save_confirm"), () -> {
/*      */             saveMap(); if (this.basicLevelEditor) {
/*      */               Game.i.screenManager.goToLevelSelectScreen();
/*      */               return;
/*      */             } 
/*      */             Game.i.screenManager.goToCustomMapSelectScreen();
/*      */           }() -> {
/*      */             if (this.basicLevelEditor) {
/*      */               Game.i.screenManager.goToLevelSelectScreen();
/*      */               return;
/*      */             } 
/*      */             Game.i.screenManager.goToCustomMapSelectScreen();
/*      */           });
/*      */       return;
/*      */     } 
/*  522 */     if (this.basicLevelEditor) {
/*  523 */       Game.i.screenManager.goToLevelSelectScreen(); return;
/*      */     } 
/*  525 */     Game.i.screenManager.goToCustomMapSelectScreen();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void expandMap(MapShiftButtons.Direction paramDirection) {
/*  531 */     deselectAll();
/*      */     
/*  533 */     Map map = this.S.map.getMap();
/*      */     
/*  535 */     a.i("expand " + paramDirection.name(), new Object[0]);
/*  536 */     if ((paramDirection == MapShiftButtons.Direction.LEFT || paramDirection == MapShiftButtons.Direction.RIGHT) && map.getWidth() >= 48)
/*  537 */       return;  if ((paramDirection == MapShiftButtons.Direction.DOWN || paramDirection == MapShiftButtons.Direction.UP) && map.getHeight() >= 48)
/*      */       return; 
/*  539 */     if (paramDirection == MapShiftButtons.Direction.RIGHT) {
/*  540 */       this.S.map.setMapSize(map.getWidth() + 1, map.getHeight());
/*  541 */     } else if (paramDirection == MapShiftButtons.Direction.UP) {
/*  542 */       this.S.map.setMapSize(map.getWidth(), map.getHeight() + 1);
/*  543 */     } else if (paramDirection == MapShiftButtons.Direction.LEFT) {
/*  544 */       this.S.map.setMapSize(map.getWidth() + 1, map.getHeight());
/*  545 */       shiftMap(MapShiftButtons.Direction.RIGHT);
/*  546 */     } else if (paramDirection == MapShiftButtons.Direction.DOWN) {
/*  547 */       this.S.map.setMapSize(map.getWidth(), map.getHeight() + 1);
/*  548 */       shiftMap(MapShiftButtons.Direction.UP);
/*      */     } 
/*      */     
/*  551 */     this.S._mapRendering.forceTilesRedraw(true);
/*  552 */     this.S.pathfinding.forcePathfindingRebuild();
/*      */   }
/*      */   
/*      */   public final void reduceMap(MapShiftButtons.Direction paramDirection) {
/*  556 */     Map map = this.S.map.getMap();
/*      */     
/*  558 */     if ((paramDirection == MapShiftButtons.Direction.LEFT || paramDirection == MapShiftButtons.Direction.RIGHT) && map.getWidth() == 1)
/*  559 */       return;  if ((paramDirection == MapShiftButtons.Direction.DOWN || paramDirection == MapShiftButtons.Direction.UP) && map.getHeight() == 1)
/*      */       return; 
/*  561 */     if (paramDirection == MapShiftButtons.Direction.RIGHT) {
/*  562 */       shiftMap(MapShiftButtons.Direction.RIGHT);
/*  563 */       shiftMap(MapShiftButtons.Direction.LEFT);
/*  564 */       this.S.map.setMapSize(map.getWidth() - 1, map.getHeight());
/*  565 */     } else if (paramDirection == MapShiftButtons.Direction.UP) {
/*  566 */       shiftMap(MapShiftButtons.Direction.UP);
/*  567 */       shiftMap(MapShiftButtons.Direction.DOWN);
/*  568 */       this.S.map.setMapSize(map.getWidth(), map.getHeight() - 1);
/*  569 */     } else if (paramDirection == MapShiftButtons.Direction.LEFT) {
/*  570 */       shiftMap(MapShiftButtons.Direction.LEFT);
/*  571 */       this.S.map.setMapSize(map.getWidth() - 1, map.getHeight());
/*  572 */     } else if (paramDirection == MapShiftButtons.Direction.DOWN) {
/*  573 */       shiftMap(MapShiftButtons.Direction.DOWN);
/*  574 */       this.S.map.setMapSize(map.getWidth(), map.getHeight() - 1);
/*      */     } 
/*      */     
/*  577 */     this.S._mapRendering.forceTilesRedraw(true);
/*  578 */     this.S.pathfinding.forcePathfindingRebuild();
/*      */   }
/*      */   public final void shiftMap(MapShiftButtons.Direction paramDirection) {
/*      */     byte b;
/*  582 */     deselectAll();
/*      */     
/*  584 */     Map map = this.S.map.getMap();
/*      */     
/*  586 */     switch (null.a[paramDirection.ordinal()]) {
/*      */       
/*      */       case 1:
/*  589 */         for (b = 0; b < map.getHeight(); b++) {
/*      */           Tile tile;
/*      */           
/*  592 */           if ((tile = map.getTile(0, b)) != null) {
/*  593 */             this.S._inventory.addTile(tile, 1);
/*      */           }
/*      */ 
/*      */           
/*  597 */           for (byte b1 = 1; b1 < map.getWidth(); b1++) {
/*  598 */             Tile tile1 = map.getTile(b1, b);
/*  599 */             this.S.map.setTile(b1 - 1, b, (tile1 == null) ? null : tile1.cloneTile());
/*      */           } 
/*      */ 
/*      */           
/*  603 */           this.S.map.setTile(map.getWidth() - 1, b, null);
/*      */         } 
/*      */ 
/*      */         
/*  607 */         for (b = 0; b <= map.getHeight(); b++) {
/*      */           byte b2;
/*  609 */           for (boolean[] arrayOfBoolean2 = { false, true }; b2 < 2; ) { boolean bool = arrayOfBoolean2[b2];
/*      */             Gate gate;
/*  611 */             if ((gate = map.getGate(0, b, bool)) != null) {
/*  612 */               this.S._inventory.addGate(gate, 1);
/*      */             }
/*      */             
/*      */             b2++; }
/*      */           
/*  617 */           for (byte b1 = 1; b1 <= map.getWidth(); b1++) {
/*  618 */             boolean[] arrayOfBoolean; byte b3; for (arrayOfBoolean = new boolean[] { false, true }, b3 = 0; b3 < 2; ) { boolean bool = arrayOfBoolean[b3];
/*  619 */               Gate gate = map.getGate(b1, b, bool);
/*  620 */               this.S.map.setGate(b1 - 1, b, bool, (gate == null) ? null : gate.cloneGate());
/*      */               
/*      */               b3++; }
/*      */           
/*      */           } 
/*  625 */           for (boolean[] arrayOfBoolean1 = { false, true }; b2 < 2; ) { boolean bool = arrayOfBoolean1[b2];
/*  626 */             this.S.map.setGate(map.getWidth(), b, bool, null);
/*      */             b2++; }
/*      */         
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 2:
/*  633 */         for (b = 0; b < map.getHeight(); b++) {
/*      */           Tile tile;
/*      */           
/*  636 */           if ((tile = map.getTile(map.getWidth() - 1, b)) != null) {
/*  637 */             this.S._inventory.addTile(tile, 1);
/*      */           }
/*      */ 
/*      */           
/*  641 */           for (int i = map.getWidth() - 2; i >= 0; i--) {
/*  642 */             Tile tile1 = map.getTile(i, b);
/*  643 */             this.S.map.setTile(i + 1, b, (tile1 == null) ? null : tile1.cloneTile());
/*      */           } 
/*      */ 
/*      */           
/*  647 */           this.S.map.setTile(0, b, null);
/*      */         } 
/*      */ 
/*      */         
/*  651 */         for (b = 0; b <= map.getHeight(); b++) {
/*      */           boolean[] arrayOfBoolean1; byte b1;
/*  653 */           for (arrayOfBoolean1 = new boolean[] { false, true }, b1 = 0; b1 < 2; ) { boolean bool = arrayOfBoolean1[b1];
/*      */             Gate gate1;
/*  655 */             if ((gate1 = map.getGate(map.getWidth(), b, bool)) != null)
/*  656 */               this.S._inventory.addGate(gate1, 1); 
/*      */             b1++; }
/*      */           
/*      */           Gate gate;
/*  660 */           if ((gate = map.getGate(map.getWidth() - 1, b, false)) != null) {
/*  661 */             this.S._inventory.addGate(gate, 1);
/*  662 */             this.S.map.setGate(map.getWidth() - 1, b, false, null);
/*      */           } 
/*      */ 
/*      */           
/*  666 */           for (int i = map.getWidth() - 1; i >= 0; i--) {
/*  667 */             boolean[] arrayOfBoolean; byte b3; for (arrayOfBoolean = new boolean[] { false, true }, b3 = 0; b3 < 2; ) { boolean bool = arrayOfBoolean[b3];
/*  668 */               gate = map.getGate(i, b, bool);
/*  669 */               this.S.map.setGate(i + 1, b, bool, (gate == null) ? null : gate.cloneGate()); b3++; }
/*      */           
/*      */           } 
/*      */           boolean[] arrayOfBoolean2;
/*      */           byte b2;
/*  674 */           for (arrayOfBoolean2 = new boolean[] { false, true }, b2 = 0; b2 < 2; ) { boolean bool = arrayOfBoolean2[b2];
/*  675 */             this.S.map.setGate(0, b, bool, null);
/*      */             b2++; }
/*      */         
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 3:
/*  682 */         for (b = 0; b < map.getWidth(); b++) {
/*      */           Tile tile;
/*      */           
/*  685 */           if ((tile = map.getTile(b, 0)) != null) {
/*  686 */             this.S._inventory.addTile(tile, 1);
/*      */           }
/*      */ 
/*      */           
/*  690 */           for (byte b1 = 1; b1 < map.getHeight(); b1++) {
/*  691 */             Tile tile1 = map.getTile(b, b1);
/*  692 */             this.S.map.setTile(b, b1 - 1, (tile1 == null) ? null : tile1.cloneTile());
/*      */           } 
/*      */ 
/*      */           
/*  696 */           this.S.map.setTile(b, map.getHeight() - 1, null);
/*      */         } 
/*      */ 
/*      */         
/*  700 */         for (b = 0; b <= map.getWidth(); b++) {
/*      */           byte b2;
/*  702 */           for (boolean[] arrayOfBoolean2 = { false, true }; b2 < 2; ) { boolean bool = arrayOfBoolean2[b2];
/*      */             Gate gate;
/*  704 */             if ((gate = map.getGate(b, 0, bool)) != null) {
/*  705 */               this.S._inventory.addGate(gate, 1);
/*      */             }
/*      */             
/*      */             b2++; }
/*      */           
/*  710 */           for (byte b1 = 1; b1 <= map.getHeight(); b1++) {
/*  711 */             boolean[] arrayOfBoolean; byte b3; for (arrayOfBoolean = new boolean[] { false, true }, b3 = 0; b3 < 2; ) { boolean bool = arrayOfBoolean[b3];
/*  712 */               Gate gate = map.getGate(b, b1, bool);
/*  713 */               this.S.map.setGate(b, b1 - 1, bool, (gate == null) ? null : gate.cloneGate());
/*      */               
/*      */               b3++; }
/*      */           
/*      */           } 
/*  718 */           for (boolean[] arrayOfBoolean1 = { false, true }; b2 < 2; ) { boolean bool = arrayOfBoolean1[b2];
/*  719 */             this.S.map.setGate(b, map.getHeight(), bool, null);
/*      */             b2++; }
/*      */         
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 4:
/*  726 */         for (b = 0; b < map.getWidth(); b++) {
/*      */           Tile tile;
/*      */           
/*  729 */           if ((tile = map.getTile(b, map.getHeight() - 1)) != null) {
/*  730 */             this.S._inventory.addTile(tile, 1);
/*      */           }
/*      */ 
/*      */           
/*  734 */           for (int i = map.getHeight() - 2; i >= 0; i--) {
/*  735 */             Tile tile1 = map.getTile(b, i);
/*  736 */             this.S.map.setTile(b, i + 1, (tile1 == null) ? null : tile1.cloneTile());
/*      */           } 
/*      */ 
/*      */           
/*  740 */           this.S.map.setTile(b, 0, null);
/*      */         } 
/*      */ 
/*      */         
/*  744 */         for (b = 0; b <= map.getWidth(); b++) {
/*      */           boolean[] arrayOfBoolean1; byte b1;
/*  746 */           for (arrayOfBoolean1 = new boolean[] { false, true }, b1 = 0; b1 < 2; ) { boolean bool = arrayOfBoolean1[b1];
/*      */             Gate gate1;
/*  748 */             if ((gate1 = map.getGate(b, map.getHeight(), bool)) != null)
/*  749 */               this.S._inventory.addGate(gate1, 1); 
/*      */             b1++; }
/*      */           
/*      */           Gate gate;
/*  753 */           if ((gate = map.getGate(b, map.getHeight() - 1, true)) != null) {
/*  754 */             this.S._inventory.addGate(gate, 1);
/*  755 */             this.S.map.setGate(b, map.getHeight() - 1, true, null);
/*      */           } 
/*      */ 
/*      */           
/*  759 */           for (int i = map.getHeight() - 1; i >= 0; i--) {
/*  760 */             boolean[] arrayOfBoolean; byte b3; for (arrayOfBoolean = new boolean[] { false, true }, b3 = 0; b3 < 2; ) { boolean bool = arrayOfBoolean[b3];
/*  761 */               gate = map.getGate(b, i, bool);
/*  762 */               this.S.map.setGate(b, i + 1, bool, (gate == null) ? null : gate.cloneGate()); b3++; }
/*      */           
/*      */           } 
/*      */           boolean[] arrayOfBoolean2;
/*      */           byte b2;
/*  767 */           for (arrayOfBoolean2 = new boolean[] { false, true }, b2 = 0; b2 < 2; ) { boolean bool = arrayOfBoolean2[b2];
/*  768 */             this.S.map.setGate(b, 0, bool, null);
/*      */             b2++; }
/*      */         
/*      */         } 
/*      */         break;
/*      */     } 
/*      */     
/*  775 */     this.S._mapRendering.forceTilesRedraw(true);
/*  776 */     this.S.pathfinding.forcePathfindingRebuild();
/*      */   }
/*      */ 
/*      */   
/*      */   public final void dispose() {
/*  781 */     this.userMap = null;
/*  782 */     this.basicLevel = null;
/*  783 */     this.g.set(true);
/*      */ 
/*      */     
/*  786 */     deleteBackupFile();
/*      */     
/*  788 */     super.dispose();
/*      */   }
/*      */   
/*      */   public static void deleteBackupFile() {
/*      */     try {
/*  793 */       Gdx.files.local("cache/map-editor-backup.json").delete(); return;
/*  794 */     } catch (Exception exception) {
/*      */       return;
/*      */     }  } @Null
/*      */   public static BackedUpMapInfo getBackUpInfo() {
/*      */     try {
/*  799 */       String str = Gdx.files.local("cache/map-editor-backup.json").readString("UTF-8");
/*  800 */       JsonValue jsonValue = (new JsonReader()).parse(str);
/*      */       BackedUpMapInfo backedUpMapInfo;
/*  802 */       (backedUpMapInfo = new BackedUpMapInfo()).backupTimestamp = jsonValue.getLong("timestamp");
/*  803 */       backedUpMapInfo.isBasicLevel = jsonValue.getBoolean("isBasicLevel");
/*  804 */       backedUpMapInfo.mapId = jsonValue.getString("mapId");
/*  805 */       backedUpMapInfo.mapName = jsonValue.getString("mapName");
/*  806 */       backedUpMapInfo.mapJson = jsonValue.get("map");
/*  807 */       return backedUpMapInfo;
/*  808 */     } catch (Exception exception) {
/*  809 */       return null;
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
/*      */   
/*      */   public class InventoryDefaultListener
/*      */     extends MapEditorInventoryMenu.MapEditorInventoryMenuListener.Adapter
/*      */   {
/*      */     public InventoryDefaultListener(MapEditorSystem this$0) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void itemSlotDragStart(MapEditorInventoryMenu.ItemSlot param1ItemSlot, Vector2 param1Vector2) {
/*  838 */       MapEditorSystem.a(this.a, param1ItemSlot);
/*      */     }
/*      */ 
/*      */     
/*      */     public void itemSlotClicked(MapEditorInventoryMenu.ItemSlot param1ItemSlot) {
/*  843 */       MapEditorSystem.a(this.a, param1ItemSlot);
/*      */     }
/*      */ 
/*      */     
/*      */     public void categoryTabChanged() {
/*  848 */       if (this.a.selection.isFromInventory()) {
/*  849 */         this.a.deselectAll();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final class HistoryImprint
/*      */   {
/*      */     private boolean a;
/*      */     
/*      */     public Array<DelayedRemovalArray<ItemStack>> startingInventory;
/*      */     
/*      */     public Map startingMap;
/*  862 */     public Array<ItemStack> inventoryAddedItems = new Array(true, 1, ItemStack.class);
/*  863 */     public Array<ItemStack> inventoryRemovedItems = new Array(true, 1, ItemStack.class);
/*  864 */     public int mapWidthDelta = 0;
/*  865 */     public int mapHeightDelta = 0;
/*  866 */     public Array<Tile> mapRemovedTiles = new Array(true, 1, Tile.class);
/*  867 */     public Array<Tile> mapAddedTiles = new Array(true, 1, Tile.class);
/*  868 */     public Array<ObjectPair<Tile, Tile>> mapReplacedTiles = new Array(true, 1, ObjectPair.class);
/*  869 */     public Array<Gate> mapRemovedGates = new Array(true, 1, Gate.class);
/*  870 */     public Array<Gate> mapAddedGates = new Array(true, 1, Gate.class);
/*  871 */     public Array<ObjectPair<Gate, Gate>> mapReplacedGates = new Array(true, 1, ObjectPair.class);
/*      */     
/*      */     private HistoryImprint(MapEditorSystem this$0) {
/*  874 */       Array<DelayedRemovalArray<ItemStack>> array = MapEditorSystem.this.S._inventory.getAllItems();
/*  875 */       this.startingInventory = new Array(true, array.size, DelayedRemovalArray.class);
/*  876 */       this.startingInventory.setSize(array.size);
/*  877 */       for (byte b = 0; b < array.size; b++) {
/*  878 */         DelayedRemovalArray delayedRemovalArray1 = (DelayedRemovalArray)array.get(b);
/*  879 */         DelayedRemovalArray delayedRemovalArray2 = new DelayedRemovalArray(true, delayedRemovalArray1.size, ItemStack.class);
/*  880 */         for (byte b1 = 0; b1 < delayedRemovalArray1.size; b1++) {
/*  881 */           delayedRemovalArray2.add(((ItemStack)delayedRemovalArray1.get(b1)).cpy());
/*      */         }
/*  883 */         this.startingInventory.set(b, delayedRemovalArray2);
/*      */       } 
/*      */       
/*  886 */       this.startingMap = MapEditorSystem.this.S.map.getMap().cpy();
/*      */     }
/*      */     
/*      */     public final boolean isSealed() {
/*  890 */       return this.a;
/*      */     }
/*      */     
/*      */     public final int getChangesCount() {
/*  894 */       return this.inventoryAddedItems.size + this.inventoryRemovedItems.size + 
/*      */         
/*  896 */         Math.abs(this.mapWidthDelta) + 
/*  897 */         Math.abs(this.mapHeightDelta) + this.mapRemovedTiles.size + this.mapAddedTiles.size + this.mapReplacedTiles.size + this.mapAddedGates.size + this.mapRemovedGates.size + this.mapReplacedGates.size;
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
/*      */     public final boolean isEmpty() {
/*  909 */       return (getChangesCount() == 0);
/*      */     }
/*      */     
/*      */     private void a() {
/*  913 */       if (this.a) {
/*      */         return;
/*      */       }
/*      */ 
/*      */       
/*  918 */       Array<DelayedRemovalArray<ItemStack>> array = this.b.S._inventory.getAllItems();
/*  919 */       for (byte b1 = 0; b1 < array.size; b1++) {
/*  920 */         DelayedRemovalArray delayedRemovalArray1 = ((DelayedRemovalArray[])this.startingInventory.items)[b1];
/*  921 */         DelayedRemovalArray delayedRemovalArray2 = ((DelayedRemovalArray[])array.items)[b1];
/*      */         
/*      */         byte b;
/*  924 */         for (b = 0; b < delayedRemovalArray2.size; b++) {
/*  925 */           ItemStack itemStack1 = ((ItemStack[])delayedRemovalArray2.items)[b];
/*      */           ItemStack itemStack2;
/*  927 */           if ((itemStack2 = ProgressManager.getItemStackFromArray((Array)delayedRemovalArray1, itemStack1.getItem())) == null) {
/*      */             
/*  929 */             this.inventoryAddedItems.add(new ItemStack(itemStack1.getItem(), itemStack1.getCount()));
/*  930 */           } else if (itemStack2.getCount() < itemStack1.getCount()) {
/*      */             
/*  932 */             this.inventoryAddedItems.add(new ItemStack(itemStack1.getItem(), itemStack1.getCount() - itemStack2.getCount()));
/*  933 */           } else if (itemStack2.getCount() > itemStack1.getCount()) {
/*      */             
/*  935 */             this.inventoryRemovedItems.add(new ItemStack(itemStack1.getItem(), itemStack2.getCount() - itemStack1.getCount()));
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  940 */         for (b = 0; b < delayedRemovalArray1.size; b++) {
/*  941 */           ItemStack itemStack1 = ((ItemStack[])delayedRemovalArray1.items)[b];
/*      */           ItemStack itemStack2;
/*  943 */           if ((itemStack2 = ProgressManager.getItemStackFromArray((Array)delayedRemovalArray2, itemStack1.getItem())) == null)
/*      */           {
/*  945 */             this.inventoryRemovedItems.add(new ItemStack(itemStack1.getItem(), itemStack1.getCount()));
/*      */           }
/*      */         } 
/*      */       } 
/*  949 */       this.startingInventory = null;
/*      */ 
/*      */       
/*  952 */       Map map = this.b.S.map.getMap();
/*  953 */       this.mapWidthDelta = map.getWidth() - this.startingMap.getWidth();
/*  954 */       this.mapHeightDelta = map.getHeight() - this.startingMap.getHeight();
/*      */       
/*  956 */       int i = Math.max(map.getWidth(), this.startingMap.getWidth());
/*  957 */       int j = Math.max(map.getHeight(), this.startingMap.getHeight()); byte b2;
/*  958 */       for (b2 = 0; b2 < j; b2++) {
/*  959 */         for (byte b = 0; b < i; b++) {
/*  960 */           Tile tile2 = map.getTile(b, b2);
/*  961 */           Tile tile1 = this.startingMap.getTile(b, b2);
/*  962 */           if (tile2 == null) {
/*      */             
/*  964 */             if (tile1 != null)
/*      */             {
/*  966 */               this.mapRemovedTiles.add(tile1.cloneTile());
/*      */             
/*      */             }
/*      */           }
/*  970 */           else if (tile1 == null) {
/*      */             
/*  972 */             this.mapAddedTiles.add(tile2.cloneTile());
/*      */           
/*      */           }
/*  975 */           else if (!tile2.sameAsWithExtras(tile1)) {
/*  976 */             this.mapReplacedTiles.add(new ObjectPair(tile1.cloneTile(), tile2.cloneTile()));
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  982 */       for (b2 = 0; b2 < j + 1; b2++) {
/*  983 */         for (byte b = 0; b < i + 1; b++) {
/*  984 */           byte b3; boolean[] arrayOfBoolean; for (arrayOfBoolean = new boolean[] { false, true }, b3 = 0; b3 < 2; ) { boolean bool = arrayOfBoolean[b3];
/*  985 */             Gate gate2 = map.getGate(b, b2, bool);
/*  986 */             Gate gate1 = this.startingMap.getGate(b, b2, bool);
/*  987 */             if (gate2 == null) {
/*      */               
/*  989 */               if (gate1 != null)
/*      */               {
/*  991 */                 this.mapRemovedGates.add(gate1.cloneGate());
/*      */               
/*      */               }
/*      */             }
/*  995 */             else if (gate1 == null) {
/*      */               
/*  997 */               this.mapAddedGates.add(gate2.cloneGate());
/*      */             
/*      */             }
/* 1000 */             else if (!gate2.sameAs(gate1)) {
/* 1001 */               this.mapReplacedGates.add(new ObjectPair(gate1.cloneGate(), gate2.cloneGate()));
/*      */             } 
/*      */             
/*      */             b3++; }
/*      */         
/*      */         } 
/*      */       } 
/* 1008 */       this.startingMap = null;
/* 1009 */       this.a = true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public final void repeat() {
/* 1015 */       if (!this.a) {
/* 1016 */         MapEditorSystem.a().e("can't revert unsealed history imprint", new Object[0]);
/*      */         
/*      */         return;
/*      */       } 
/* 1020 */       if (this.mapWidthDelta > 0) {
/*      */         
/* 1022 */         this.b.S.map.setMapSize(this.b.S.map.getMap().getWidth() + this.mapWidthDelta, this.b.S.map.getMap().getHeight());
/* 1023 */       } else if (this.mapHeightDelta > 0) {
/*      */         
/* 1025 */         this.b.S.map.setMapSize(this.b.S.map.getMap().getWidth(), this.b.S.map.getMap().getHeight() + this.mapHeightDelta);
/*      */       } 
/*      */       byte b;
/* 1028 */       for (b = 0; b < this.inventoryRemovedItems.size; b++) {
/* 1029 */         ItemStack itemStack = (ItemStack)this.inventoryRemovedItems.get(b);
/* 1030 */         this.b.S._inventory.removeMany(itemStack.getItem(), itemStack.getCount());
/*      */       } 
/* 1032 */       for (b = 0; b < this.inventoryAddedItems.size; b++) {
/* 1033 */         ItemStack itemStack = (ItemStack)this.inventoryAddedItems.get(b);
/* 1034 */         this.b.S._inventory.add(itemStack.getItem(), itemStack.getCount());
/*      */       } 
/* 1036 */       for (b = 0; b < this.mapAddedTiles.size; b++) {
/* 1037 */         Tile tile = (Tile)this.mapAddedTiles.get(b);
/* 1038 */         this.b.S.map.setTile(tile.getX(), tile.getY(), tile.cloneTile());
/*      */       } 
/* 1040 */       for (b = 0; b < this.mapAddedGates.size; b++) {
/* 1041 */         Gate gate = (Gate)this.mapAddedGates.get(b);
/* 1042 */         this.b.S.map.setGate(gate.getX(), gate.getY(), gate.isLeftSide(), gate.cloneGate());
/*      */       } 
/* 1044 */       for (b = 0; b < this.mapRemovedTiles.size; b++) {
/* 1045 */         Tile tile = (Tile)this.mapRemovedTiles.get(b);
/* 1046 */         this.b.S.map.setTile(tile.getX(), tile.getY(), null);
/*      */       } 
/* 1048 */       for (b = 0; b < this.mapRemovedGates.size; b++) {
/* 1049 */         Gate gate = (Gate)this.mapRemovedGates.get(b);
/* 1050 */         this.b.S.map.setGate(gate.getX(), gate.getY(), gate.isLeftSide(), null);
/*      */       } 
/* 1052 */       for (b = 0; b < this.mapReplacedTiles.size; b++) {
/*      */         ObjectPair objectPair;
/* 1054 */         Tile tile = (Tile)(objectPair = (ObjectPair)this.mapReplacedTiles.get(b)).second;
/* 1055 */         this.b.S.map.setTile(tile.getX(), tile.getY(), tile.cloneTile());
/*      */       } 
/* 1057 */       for (b = 0; b < this.mapReplacedGates.size; b++) {
/*      */         ObjectPair objectPair;
/* 1059 */         Gate gate = (Gate)(objectPair = (ObjectPair)this.mapReplacedGates.get(b)).second;
/* 1060 */         this.b.S.map.setGate(gate.getX(), gate.getY(), gate.isLeftSide(), gate.cloneGate());
/*      */       } 
/*      */ 
/*      */       
/* 1064 */       if (this.mapWidthDelta < 0) {
/*      */         
/* 1066 */         this.b.S.map.setMapSize(this.b.S.map.getMap().getWidth() - this.mapWidthDelta, this.b.S.map.getMap().getHeight()); return;
/* 1067 */       }  if (this.mapHeightDelta < 0)
/*      */       {
/* 1069 */         this.b.S.map.setMapSize(this.b.S.map.getMap().getWidth(), this.b.S.map.getMap().getHeight() - this.mapHeightDelta);
/*      */       }
/*      */     }
/*      */     
/*      */     public final void revert() {
/* 1074 */       if (!this.a) {
/* 1075 */         MapEditorSystem.a().e("can't revert unsealed history imprint", new Object[0]);
/*      */         
/*      */         return;
/*      */       } 
/* 1079 */       if (this.mapWidthDelta < 0) {
/*      */         
/* 1081 */         this.b.S.map.setMapSize(this.b.S.map.getMap().getWidth() - this.mapWidthDelta, this.b.S.map.getMap().getHeight());
/* 1082 */       } else if (this.mapHeightDelta < 0) {
/*      */         
/* 1084 */         this.b.S.map.setMapSize(this.b.S.map.getMap().getWidth(), this.b.S.map.getMap().getHeight() - this.mapHeightDelta);
/*      */       } 
/*      */       byte b;
/* 1087 */       for (b = 0; b < this.inventoryRemovedItems.size; b++) {
/* 1088 */         ItemStack itemStack = (ItemStack)this.inventoryRemovedItems.get(b);
/* 1089 */         this.b.S._inventory.add(itemStack.getItem(), itemStack.getCount());
/*      */       } 
/* 1091 */       for (b = 0; b < this.inventoryAddedItems.size; b++) {
/* 1092 */         ItemStack itemStack = (ItemStack)this.inventoryAddedItems.get(b);
/* 1093 */         this.b.S._inventory.removeMany(itemStack.getItem(), itemStack.getCount());
/*      */       } 
/* 1095 */       for (b = 0; b < this.mapAddedTiles.size; b++) {
/* 1096 */         Tile tile = (Tile)this.mapAddedTiles.get(b);
/* 1097 */         this.b.S.map.setTile(tile.getX(), tile.getY(), null);
/*      */       } 
/* 1099 */       for (b = 0; b < this.mapAddedGates.size; b++) {
/* 1100 */         Gate gate = (Gate)this.mapAddedGates.get(b);
/* 1101 */         this.b.S.map.setGate(gate.getX(), gate.getY(), gate.isLeftSide(), null);
/*      */       } 
/* 1103 */       for (b = 0; b < this.mapRemovedTiles.size; b++) {
/* 1104 */         Tile tile = (Tile)this.mapRemovedTiles.get(b);
/* 1105 */         this.b.S.map.setTile(tile.getX(), tile.getY(), tile.cloneTile());
/*      */       } 
/* 1107 */       for (b = 0; b < this.mapRemovedGates.size; b++) {
/* 1108 */         Gate gate = (Gate)this.mapRemovedGates.get(b);
/* 1109 */         this.b.S.map.setGate(gate.getX(), gate.getY(), gate.isLeftSide(), gate.cloneGate());
/*      */       } 
/* 1111 */       for (b = 0; b < this.mapReplacedTiles.size; b++) {
/*      */         ObjectPair objectPair;
/* 1113 */         Tile tile = (Tile)(objectPair = (ObjectPair)this.mapReplacedTiles.get(b)).first;
/* 1114 */         this.b.S.map.setTile(tile.getX(), tile.getY(), tile.cloneTile());
/*      */       } 
/* 1116 */       for (b = 0; b < this.mapReplacedGates.size; b++) {
/*      */         ObjectPair objectPair;
/* 1118 */         Gate gate = (Gate)(objectPair = (ObjectPair)this.mapReplacedGates.get(b)).first;
/* 1119 */         this.b.S.map.setGate(gate.getX(), gate.getY(), gate.isLeftSide(), gate.cloneGate());
/*      */       } 
/*      */       
/* 1122 */       if (this.mapWidthDelta > 0) {
/*      */         
/* 1124 */         this.b.S.map.setMapSize(this.b.S.map.getMap().getWidth() - this.mapWidthDelta, this.b.S.map.getMap().getHeight()); return;
/* 1125 */       }  if (this.mapHeightDelta > 0)
/*      */       {
/* 1127 */         this.b.S.map.setMapSize(this.b.S.map.getMap().getWidth(), this.b.S.map.getMap().getHeight() - this.mapHeightDelta);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public final String toString() {
/* 1133 */       return "HistoryImprint (\n  sealed: " + this.a + "\n  inventoryAddedItems: " + this.inventoryAddedItems
/*      */         
/* 1135 */         .toString(", ") + "\n  inventoryRemovedItems: " + this.inventoryRemovedItems
/* 1136 */         .toString(", ") + "\n  mapWidthDelta: " + this.mapWidthDelta + "\n  mapHeightDelta: " + this.mapHeightDelta + "\n  mapRemovedTiles: " + this.mapRemovedTiles
/*      */ 
/*      */         
/* 1139 */         .toString(", ") + "\n  mapAddedTiles: " + this.mapAddedTiles
/* 1140 */         .toString(", ") + "\n  mapReplacedTiles: " + this.mapReplacedTiles
/* 1141 */         .toString(", ") + "\n  mapRemovedGates: " + this.mapRemovedGates
/* 1142 */         .toString(", ") + "\n  mapAddedGates: " + this.mapAddedGates
/* 1143 */         .toString(", ") + "\n  mapReplacedGates: " + this.mapAddedGates
/* 1144 */         .toString(", ") + "\n)";
/*      */     }
/*      */   }
/*      */   
/*      */   public static final class BackedUpMapInfo {
/*      */     public boolean isBasicLevel;
/*      */     public String mapId;
/*      */     public String mapName;
/*      */     public long backupTimestamp;
/*      */     public JsonValue mapJson;
/*      */     
/*      */     public final void startEditor() {
/*      */       MapEditorScreen mapEditorScreen;
/* 1157 */       Map map = Map.fromJson(this.mapJson);
/*      */ 
/*      */       
/* 1160 */       if (this.isBasicLevel) {
/*      */         BasicLevel basicLevel;
/* 1162 */         if ((basicLevel = Game.i.basicLevelManager.getLevel(this.mapId)) == null) {
/* 1163 */           throw new IllegalArgumentException("Basic level '" + this.mapId + "' not exists");
/*      */         }
/* 1165 */         Map map1 = basicLevel.getMap();
/* 1166 */         basicLevel.setMap(map);
/* 1167 */         mapEditorScreen = new MapEditorScreen(basicLevel);
/* 1168 */         basicLevel.setMap(map1);
/*      */       } else {
/*      */         UserMap userMap;
/* 1171 */         if ((userMap = Game.i.userMapManager.getUserMap(this.mapId)) == null) {
/* 1172 */           throw new IllegalArgumentException("User map '" + this.mapId + "' not exists");
/*      */         }
/* 1174 */         Map map1 = userMap.map;
/* 1175 */         userMap.map = (Map)mapEditorScreen;
/* 1176 */         mapEditorScreen = new MapEditorScreen(userMap);
/* 1177 */         userMap.map = map1;
/*      */       } 
/* 1179 */       Game.i.screenManager.setScreen((Screen)mapEditorScreen);
/* 1180 */       mapEditorScreen.S._mapEditor.mapChanged = true;
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface Tool {
/*      */     void setup(GameSystemProvider param1GameSystemProvider);
/*      */     
/*      */     @Null
/*      */     MapEditorUi.PreparedTooltip getTooltip();
/*      */     
/*      */     void enabled(Tool param1Tool);
/*      */     
/*      */     void disabled();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\MapEditorSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */