/*     */ package com.prineside.tdi2.utils.mapeditor.tools;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.items.GateItem;
/*     */ import com.prineside.tdi2.items.TileItem;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.systems.GameMapSelectionSystem;
/*     */ import com.prineside.tdi2.systems.MapEditorSystem;
/*     */ import com.prineside.tdi2.systems.RenderSystem;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.components.MapEditorInventoryMenu;
/*     */ import com.prineside.tdi2.ui.components.MapEditorUi;
/*     */ import com.prineside.tdi2.utils.InputMultiplexerExtended;
/*     */ import com.prineside.tdi2.utils.IntRectangle;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.mapeditor.Selection;
/*     */ 
/*     */ public final class Move implements MapEditorSystem.Tool {
/*     */   private GameSystemProvider a;
/*     */   private MapEditorUi.ToolButton b;
/*  40 */   private final InventoryListener c = new InventoryListener((byte)0);
/*     */   
/*     */   private MapEditorSystem.HistoryImprint d;
/*     */   
/*     */   private Selection e;
/*  45 */   private final Vector2 f = new Vector2(-2.1474836E9F, -2.1474836E9F);
/*     */   private Image g;
/*  47 */   private final Vector2 h = new Vector2();
/*     */   
/*     */   private Selection i;
/*  50 */   private final RenderSystem.Layer j = new RenderSystem.Layer(GameRenderingOrder.MAP_RENDERING_MAP_EDITOR_SELECTION + 50, false, new HintLayerRenderer((byte)0));
/*     */   
/*  52 */   private final Gate k = (Gate)Game.i.gateManager.F.BARRIER_TYPE.create();
/*  53 */   private static final Vector2 l = new Vector2();
/*     */ 
/*     */   
/*     */   public final void setup(GameSystemProvider paramGameSystemProvider) {
/*  57 */     this.a = paramGameSystemProvider;
/*     */     
/*  59 */     this.b = new MapEditorUi.ToolButton((Drawable)Game.i.assetManager.getQuad("mapeditor.tools.move"), () -> paramGameSystemProvider._mapEditor.selectTool(this), null);
/*     */ 
/*     */ 
/*     */     
/*  63 */     paramGameSystemProvider._mapEditorUi.mainUi.addToolButton(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final MapEditorUi.PreparedTooltip getTooltip() {
/*  68 */     return new MapEditorUi.PreparedTooltip("map_editor_tool_move", (Actor)this.b, Game.i.localeManager.i18n.get("map_editor_tooltip_move_tool"));
/*     */   }
/*     */   
/*     */   private static float b() {
/*  72 */     if (c()) {
/*  73 */       return 0.0F;
/*     */     }
/*  75 */     return 150.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean c() {
/*  80 */     return (Gdx.app.getType() == Application.ApplicationType.Desktop);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void enabled(MapEditorSystem.Tool paramTool) {
/*  89 */     this.b.setActive(true);
/*     */     
/*  91 */     this.a._mapEditorUi.inventoryMenu.setItemDraggingMode(true);
/*  92 */     this.a._mapEditorUi.inventoryMenu.addListener((MapEditorInventoryMenu.MapEditorInventoryMenuListener)this.c);
/*     */ 
/*     */     
/*  95 */     (this.a._input.getCameraController()).dragButtonIndices.clear();
/*  96 */     (this.a._input.getCameraController()).dragButtonIndices.add(1);
/*     */     
/*     */     InputMultiplexerExtended inputMultiplexerExtended;
/*     */     
/* 100 */     (inputMultiplexerExtended = this.a._input.setupInputMultiplexer(true, true, true)).addProcessor((InputProcessor)new MapInputHandler((byte)0));
/*     */     
/* 102 */     this.a._render.addLayer(this.j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 109 */     this.h.set(paramFloat3, paramFloat4);
/*     */     
/* 111 */     paramFloat2 += b();
/*     */     
/* 113 */     if (this.e.count() == 1) {
/* 114 */       this.a._mapEditorUi.draggingItemHelper.setIconShiftInstantly(paramFloat3, paramFloat4);
/*     */     } else {
/* 116 */       this.a._mapEditorUi.draggingItemHelper.setIconShiftInstantly(0.0F, 0.0F);
/*     */     } 
/*     */     
/* 119 */     if (this.a._mapEditorUi.inventoryMenu.isStagePointOnInventory(paramFloat1, paramFloat2)) {
/* 120 */       this.a._mapEditorUi.draggingItemHelper.setScaleInstantly(1.0F);
/*     */     }
/* 122 */     else if (this.e.count() == 1) {
/* 123 */       this.a._mapEditorUi.draggingItemHelper.setScaleInstantly((float)(1.0D / (this.a._input.getCameraController()).zoom));
/*     */     } else {
/* 125 */       this.a._mapEditorUi.draggingItemHelper.setScaleInstantly(0.0F);
/*     */     } 
/*     */ 
/*     */     
/* 129 */     Group group = this.a._mapEditorUi.draggingItemHelper.show();
/*     */     
/* 131 */     this.g = new Image((Drawable)Game.i.assetManager.getQuad("screen.mapEditor.draggingItems.arrowPointer"));
/* 132 */     this.g.setSize(64.0F, 64.0F);
/* 133 */     this.g.setPosition(-32.0F, 128.0F);
/* 134 */     this.g.setVisible(false);
/* 135 */     group.addActor((Actor)this.g);
/*     */     
/* 137 */     if (this.e.count() == 1) {
/*     */       Actor actor;
/* 139 */       (actor = this.e.getCurrentItem().generateIcon(128.0F, true)).setPosition(-64.0F, -64.0F);
/* 140 */       group.addActor(actor);
/*     */     } else {
/*     */       Image image;
/* 143 */       (image = new Image((Drawable)Game.i.assetManager.getQuad("mapeditor.tools.select-rectangle"))).setSize(128.0F, 128.0F);
/* 144 */       image.setPosition(-58.0F, -70.0F);
/* 145 */       image.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 146 */       group.addActor((Actor)image);
/*     */ 
/*     */       
/* 149 */       (image = new Image((Drawable)Game.i.assetManager.getQuad("mapeditor.tools.select-rectangle"))).setSize(128.0F, 128.0F);
/* 150 */       image.setPosition(-64.0F, -64.0F);
/* 151 */       group.addActor((Actor)image);
/*     */       
/*     */       Label label;
/* 154 */       (label = new Label(this.e.count(), Game.i.assetManager.getLabelStyle(60))).setSize(128.0F, 128.0F);
/* 155 */       label.setAlignment(1);
/* 156 */       label.setPosition(-58.0F, -70.0F);
/* 157 */       label.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 158 */       group.addActor((Actor)label);
/*     */ 
/*     */       
/* 161 */       (label = new Label(this.e.count(), Game.i.assetManager.getLabelStyle(60))).setSize(128.0F, 128.0F);
/* 162 */       label.setAlignment(1);
/* 163 */       label.setPosition(-64.0F, -64.0F);
/* 164 */       group.addActor((Actor)label);
/*     */     } 
/*     */     
/* 167 */     a(paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   private void a(float paramFloat1, float paramFloat2) {
/* 171 */     paramFloat2 += b();
/*     */     
/* 173 */     this.a._mapEditorUi.draggingItemHelper.setPosition(paramFloat1, paramFloat2);
/* 174 */     if (this.g != null) this.g.setVisible(false); 
/* 175 */     if (this.a._mapEditorUi.inventoryMenu.isStagePointOnInventory(paramFloat1, paramFloat2)) {
/*     */       
/* 177 */       this.a._mapEditorUi.draggingItemHelper.setScale(1.0F);
/* 178 */       this.a._mapEditorUi.draggingItemHelper.setIconShift(0.0F, 0.0F);
/*     */       
/* 180 */       this.f.set(-2.1474836E9F, -2.1474836E9F);
/*     */       return;
/*     */     } 
/* 183 */     if (c()) {
/* 184 */       this.a._mapEditorUi.draggingItemHelper.setScale(0.33F);
/* 185 */       this.a._mapEditorUi.draggingItemHelper.setIconShift(32.0F, -42.0F);
/*     */     } else {
/* 187 */       this.a._mapEditorUi.draggingItemHelper.setScale(0.5F);
/* 188 */       this.a._mapEditorUi.draggingItemHelper.setIconShift(0.0F, -96.0F);
/*     */       
/* 190 */       if (this.g != null) this.g.setVisible(true);
/*     */     
/*     */     } 
/* 193 */     this.f.set(paramFloat1, paramFloat2);
/*     */     
/* 195 */     this.i = this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   private void d() {
/* 200 */     if (!this.e.isFromInventory())
/*     */     {
/* 202 */       this.a._mapEditor.selection.clear();
/*     */     }
/*     */     
/* 205 */     if (this.f.x == -2.1474836E9F || this.f.y == -2.1474836E9F) {
/*     */       Array.ArrayIterator<Tile> arrayIterator;
/* 207 */       for (arrayIterator = this.e.tiles.iterator(); arrayIterator.hasNext(); ) { Tile tile = arrayIterator.next();
/* 208 */         this.a._inventory.addTile(tile, 1); }
/*     */       
/* 210 */       for (arrayIterator = this.e.gates.iterator(); arrayIterator.hasNext(); ) { Gate gate = (Gate)arrayIterator.next();
/* 211 */         this.a._inventory.addGate(gate, 1); }
/*     */     
/*     */     } else {
/*     */       
/* 215 */       this.a._mapEditor.selection.setFromInventory(false);
/*     */       
/* 217 */       l.set(this.f);
/* 218 */       this.a._input.getCameraController().stageToMap(l);
/*     */       
/* 220 */       Map map = this.a.map.getMap();
/* 221 */       if (this.e.count() == 1 && this.e.gates.size == 1) {
/*     */         
/* 223 */         Gate gate = (Gate)this.e.gates.first();
/* 224 */         if (this.a.map.getMap().fitGateToMapPos(l.x, l.y, this.k)) {
/*     */           Gate gate1;
/*     */           
/* 227 */           if ((gate1 = map.getGate(this.k.getX(), this.k.getY(), this.k.isLeftSide())) != null) {
/* 228 */             if (!this.e.isFromInventory() && this.e.count() == 1) {
/*     */               
/* 230 */               this.a.map.setGate(gate.getX(), gate.getY(), gate.isLeftSide(), gate1.cloneGate());
/*     */             } else {
/*     */               
/* 233 */               this.a._inventory.addGate(gate1, 1);
/*     */             } 
/*     */           }
/*     */           
/* 237 */           Gate gate2 = gate.cloneGate();
/* 238 */           this.a.map.setGate(this.k.getX(), this.k.getY(), this.k.isLeftSide(), gate2);
/* 239 */           this.a._mapEditor.selection.addGate(gate2);
/*     */         } else {
/*     */           
/* 242 */           this.a._inventory.addGate(gate, 1);
/*     */         } 
/* 244 */       } else if (this.e.count() == 1 && this.e.tiles.size == 1) {
/*     */         
/* 246 */         Tile tile = (Tile)this.e.tiles.first();
/* 247 */         int i = Map.posToCell(l.x);
/* 248 */         int j = Map.posToCell(l.y);
/* 249 */         if (i >= 0 && i < map.getWidth() && j >= 0 && j < map.getHeight()) {
/*     */           Tile tile1;
/*     */           
/* 252 */           if ((tile1 = map.getTile(i, j)) != null) {
/* 253 */             if (!this.e.isFromInventory() && this.e.count() == 1) {
/*     */               
/* 255 */               Tile tile3 = (Tile)this.e.tiles.first();
/* 256 */               this.a.map.setTile(tile3.getX(), tile3.getY(), tile1.cloneTile());
/*     */             } else {
/*     */               
/* 259 */               this.a._inventory.addTile(tile1, 1);
/*     */             } 
/*     */           }
/*     */           
/* 263 */           Tile tile2 = tile.cloneTile();
/* 264 */           this.a.map.setTile(i, j, tile2);
/* 265 */           this.a._mapEditor.selection.addTile(tile2);
/*     */         } else {
/*     */           
/* 268 */           this.a._inventory.addTile(tile, 1);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 273 */         l.add(-this.h.x, -this.h.y);
/* 274 */         float f1 = l.x;
/* 275 */         float f2 = l.y;
/* 276 */         int i = MathUtils.floor(f1 * 0.0078125F);
/* 277 */         int j = MathUtils.floor(f2 * 0.0078125F);
/*     */         
/* 279 */         IntRectangle intRectangle = this.e.dimensions(); Array.ArrayIterator<Tile> arrayIterator;
/* 280 */         for (arrayIterator = this.e.tiles.iterator(); arrayIterator.hasNext(); ) {
/* 281 */           Tile tile; int k = (tile = arrayIterator.next()).getX() - intRectangle.minX + i;
/* 282 */           int m = tile.getY() - intRectangle.minY + j;
/* 283 */           if (k >= 0 && k < map.getWidth() && m >= 0 && m < map.getHeight()) {
/*     */             Tile tile1;
/*     */             
/* 286 */             if ((tile1 = map.getTile(k, m)) != null) {
/* 287 */               this.a._inventory.addTile(tile1, 1);
/*     */             }
/* 289 */             tile1 = tile.cloneTile();
/* 290 */             this.a.map.setTile(k, m, tile1);
/* 291 */             this.a._mapEditor.selection.addTile(tile1);
/*     */             continue;
/*     */           } 
/* 294 */           this.a._inventory.addTile(tile, 1);
/*     */         } 
/*     */         
/* 297 */         for (arrayIterator = this.e.gates.iterator(); arrayIterator.hasNext(); ) {
/* 298 */           Gate gate1; int k = (gate1 = (Gate)arrayIterator.next()).getX() - intRectangle.minX + i;
/* 299 */           int m = gate1.getY() - intRectangle.minY + j;
/* 300 */           if (k < 0 || k > map
/*     */             
/* 302 */             .getWidth() || m < 0 || m > map
/*     */             
/* 304 */             .getHeight() || (m == map
/* 305 */             .getHeight() && gate1.isLeftSide()) || (k == map
/* 306 */             .getWidth() && !gate1.isLeftSide())) {
/*     */ 
/*     */             
/* 309 */             this.a._inventory.addGate(gate1, 1);
/*     */             continue;
/*     */           } 
/*     */           Gate gate2;
/* 313 */           if ((gate2 = map.getGate(k, m, gate1.isLeftSide())) != null) {
/* 314 */             this.a._inventory.addGate(gate2, 1);
/*     */           }
/* 316 */           gate2 = gate1.cloneGate();
/* 317 */           this.a.map.setGate(k, m, gate1.isLeftSide(), gate2);
/* 318 */           this.a._mapEditor.selection.addGate(gate2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 324 */     this.a._mapEditor.notifySelectionChanged();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 329 */     this.a._mapEditorUi.draggingItemHelper.hide();
/* 330 */     this.f.set(-2.1474836E9F, -2.1474836E9F);
/*     */     
/* 332 */     if (this.d != null) {
/* 333 */       this.a._mapEditor.finishActionRecord(this.d);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void disabled() {
/* 339 */     this.a._render.removeLayer(this.j);
/*     */     
/* 341 */     this.b.setActive(false);
/*     */   }
/*     */   
/*     */   private class InventoryListener extends MapEditorInventoryMenu.MapEditorInventoryMenuListener.Adapter {
/* 345 */     private final Vector2 a = new Vector2();
/*     */     
/*     */     private boolean b;
/*     */     
/*     */     public void itemSlotDragStart(MapEditorInventoryMenu.ItemSlot param1ItemSlot, Vector2 param1Vector2) {
/* 350 */       this.a.set(param1Vector2);
/* 351 */       (Move.a(this.c))._input.getCameraController().screenToStage(this.a);
/*     */       ItemStack itemStack;
/* 353 */       Item item = (itemStack = param1ItemSlot.getItemStack()).getItem();
/* 354 */       if ((Move.a(this.c))._inventory.contains(item, 1)) {
/* 355 */         Move.a(this.c, (Move.a(this.c))._mapEditor.startActionRecord());
/* 356 */         if ((Move.a(this.c))._inventory.remove(item)) {
/* 357 */           (Move.a(this.c))._mapEditor.selection.clear();
/* 358 */           (Move.a(this.c))._mapEditor.selection.setFromInventory(true);
/* 359 */           if (item instanceof TileItem) {
/* 360 */             (Move.a(this.c))._mapEditor.selection.addTile(((TileItem)item).tile);
/* 361 */           } else if (item instanceof GateItem) {
/* 362 */             (Move.a(this.c))._mapEditor.selection.addGate(((GateItem)item).gate);
/*     */           } 
/* 364 */           Move.a(this.c, (Move.a(this.c))._mapEditor.selection.cpy());
/*     */           
/* 366 */           Move.a(this.c, this.a.x, this.a.y, 0.0F, 0.0F);
/* 367 */           this.b = true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void itemSlotDrag(MapEditorInventoryMenu.ItemSlot param1ItemSlot, Vector2 param1Vector2) {
/* 374 */       if (this.b) {
/* 375 */         this.a.set(param1Vector2);
/* 376 */         (Move.a(this.c))._input.getCameraController().screenToStage(this.a);
/* 377 */         Move.a(this.c, this.a.x, this.a.y);
/*     */       } 
/*     */     }
/*     */     private InventoryListener(Move this$0) {}
/*     */     
/*     */     public void itemSlotDragEnd(MapEditorInventoryMenu.ItemSlot param1ItemSlot, Vector2 param1Vector2) {
/* 383 */       if (this.b) {
/* 384 */         this.b = false;
/* 385 */         this.a.set(param1Vector2);
/* 386 */         (Move.a(this.c))._input.getCameraController().screenToStage(this.a);
/* 387 */         Move.b(this.c, this.a.x, this.a.y);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private class MapInputHandler extends InputAdapter {
/* 393 */     private int a = -1;
/*     */     
/*     */     private boolean b;
/* 396 */     private final Vector2 c = new Vector2();
/* 397 */     private final Vector2 d = new Vector2();
/*     */ 
/*     */     
/*     */     public boolean touchDown(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 401 */       if (param1Int4 == 0) {
/* 402 */         Vector2 vector2 = new Vector2(param1Int1, param1Int2);
/* 403 */         (Move.a(this.e))._input.getCameraController().screenToMap(vector2);
/*     */         
/* 405 */         (Move.a(this.e))._mapEditor.selection.setFromInventory(false);
/*     */         
/*     */         Gate gate;
/* 408 */         if ((gate = (Move.a(this.e)).map.getMap().getGateByMapPos(vector2.x, vector2.y)) != null) {
/* 409 */           if (!(Move.a(this.e))._mapEditor.selection.containsGate(gate)) {
/*     */             
/* 411 */             (Move.a(this.e))._mapEditor.selection.clear();
/* 412 */             (Move.a(this.e))._mapEditor.selection.gates.add(gate);
/*     */           } 
/*     */         } else {
/*     */           Tile tile;
/* 416 */           if ((tile = (Move.a(this.e)).map.getMap().getTileByMapPos(vector2.x, vector2.y)) != null) {
/* 417 */             if (!(Move.a(this.e))._mapEditor.selection.containsTile(tile)) {
/*     */               
/* 419 */               (Move.a(this.e))._mapEditor.selection.clear();
/* 420 */               (Move.a(this.e))._mapEditor.selection.addTile(tile);
/*     */             } 
/*     */           } else {
/*     */             
/* 424 */             (Move.a(this.e))._mapEditor.selection.clear();
/*     */           } 
/*     */         } 
/* 427 */         (Move.a(this.e))._mapEditor.notifySelectionChanged();
/*     */         
/* 429 */         if ((Move.a(this.e))._mapEditor.selection.count() > 0) {
/*     */           
/* 431 */           Move.a(this.e, (Move.a(this.e))._mapEditor.selection.cpy());
/* 432 */           this.a = param1Int3;
/* 433 */           this.b = false;
/*     */           
/* 435 */           this.c.set(vector2);
/* 436 */           (Move.a(this.e))._input.getCameraController().mapToStage(this.c);
/*     */           
/* 438 */           this.d.setZero();
/* 439 */           if (Move.b(this.e).count() > 1) {
/*     */             
/* 441 */             IntRectangle intRectangle = Move.b(this.e).dimensions();
/* 442 */             this.d.x = vector2.x - (intRectangle.minX << 7) - 64.0F;
/* 443 */             this.d.y = vector2.y - (intRectangle.minY << 7) - 64.0F;
/*     */           } 
/*     */         } 
/*     */         
/* 447 */         return false;
/*     */       } 
/* 449 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean touchDragged(int param1Int1, int param1Int2, int param1Int3) {
/* 454 */       if (param1Int3 == this.a) {
/* 455 */         Vector2 vector2 = new Vector2(param1Int1, param1Int2);
/* 456 */         (Move.a(this.e))._input.getCameraController().screenToStage(vector2);
/*     */         
/* 458 */         if (!this.b && 
/* 459 */           vector2.dst(this.c) > 5.0F) {
/*     */           
/* 461 */           if (!Move.c(this.e)) {
/*     */             
/* 463 */             Move.a(this.e, (Move.a(this.e))._mapEditor.startActionRecord()); Array.ArrayIterator<Tile> arrayIterator;
/* 464 */             for (arrayIterator = (Move.b(this.e)).tiles.iterator(); arrayIterator.hasNext(); ) { Tile tile = arrayIterator.next();
/* 465 */               (Move.a(this.e)).map.setTile(tile.getX(), tile.getY(), null); }
/*     */             
/* 467 */             for (arrayIterator = (Move.b(this.e)).gates.iterator(); arrayIterator.hasNext(); ) { Gate gate = (Gate)arrayIterator.next();
/* 468 */               (Move.a(this.e)).map.setGate(gate.getX(), gate.getY(), gate.isLeftSide(), null); }
/*     */           
/*     */           } 
/*     */ 
/*     */           
/* 473 */           this.b = true;
/* 474 */           Move.a(this.e, vector2.x, vector2.y, this.d.x, this.d.y);
/*     */         } 
/*     */         
/* 477 */         if (this.b) {
/* 478 */           Move.a(this.e, vector2.x, vector2.y);
/*     */         }
/*     */         
/* 481 */         return false;
/*     */       } 
/* 483 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean touchUp(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 488 */       if (this.a == param1Int3) {
/* 489 */         this.a = -1;
/* 490 */         if (this.b) {
/* 491 */           Vector2 vector2 = new Vector2(param1Int1, param1Int2);
/* 492 */           (Move.a(this.e))._input.getCameraController().screenToStage(vector2);
/* 493 */           Move.b(this.e, vector2.x, vector2.y);
/*     */         } 
/*     */       } 
/* 496 */       return false;
/*     */     }
/*     */     
/*     */     private MapInputHandler(Move this$0) {}
/*     */   }
/*     */   
/*     */   private final class HintLayerRenderer implements RenderSystem.LayerRenderer {
/*     */     public final void render(Batch param1Batch, float param1Float1, float param1Float2, float param1Float3) {
/* 504 */       if ((Move.d(this.a)).x != -2.1474836E9F && (Move.d(this.a)).y != -2.1474836E9F) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 509 */         param1Batch.setColor(Color.WHITE);
/*     */         
/* 511 */         Move.a().set(Move.d(this.a));
/* 512 */         (Move.a(this.a))._input.getCameraController().stageToMap(Move.a());
/*     */         
/* 514 */         if (Move.b(this.a).count() == 1 && (Move.b(this.a)).gates.size == 1) {
/*     */           
/* 516 */           Gate gate = (Gate)(Move.b(this.a)).gates.first();
/* 517 */           if ((Move.a(this.a)).map.getMap().fitGateToMapPos((Move.a()).x, (Move.a()).y, Move.e(this.a))) {
/* 518 */             boolean bool = gate.isLeftSide();
/* 519 */             gate.setPosition(gate.getX(), gate.getY(), Move.e(this.a).isLeftSide());
/* 520 */             gate.drawStatic(param1Batch, (Move.e(this.a).getX() << 7), (Move.e(this.a).getY() << 7), 128.0F, 128.0F);
/* 521 */             param1Batch.setColor(MaterialColor.ORANGE.P500);
/* 522 */             GameMapSelectionSystem.drawGateSelection(param1Batch, Move.e(this.a).getX(), Move.e(this.a).getY(), Move.e(this.a).isLeftSide());
/* 523 */             param1Batch.setColor(Color.WHITE);
/* 524 */             gate.setPosition(gate.getX(), gate.getY(), bool);
/*     */           } 
/*     */         } else {
/*     */           
/* 528 */           if (Move.b(this.a).count() > 1) {
/* 529 */             Move.a().add(-(Move.f(this.a)).x, -(Move.f(this.a)).y);
/*     */           }
/*     */           
/* 532 */           param1Float1 = (Move.a()).x;
/* 533 */           param1Float2 = (Move.a()).y;
/*     */           
/* 535 */           int i = MathUtils.floor(param1Float1 * 0.0078125F);
/* 536 */           int j = MathUtils.floor(param1Float2 * 0.0078125F);
/* 537 */           Move.g(this.a).draw(param1Batch, (i << 7), (j << 7), 1.0F, 1.0F, (Move.a(this.a)).map.getMap());
/* 538 */           Move.g(this.a).drawOutline(param1Batch, (i << 7), (j << 7), 1.0F, 1.0F, MaterialColor.ORANGE.P500, null);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 547 */         param1Batch.end();
/*     */       } 
/*     */     }
/*     */     
/*     */     private HintLayerRenderer(Move this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\mapeditor\tools\Move.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */