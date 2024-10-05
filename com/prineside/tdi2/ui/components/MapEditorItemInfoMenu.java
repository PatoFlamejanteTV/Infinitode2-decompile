/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.events.mapEditor.MapEditorSelectionChange;
/*     */ import com.prineside.tdi2.items.GateItem;
/*     */ import com.prineside.tdi2.items.TileItem;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.ui.TextField;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*     */ import com.prineside.tdi2.ui.shared.ItemCreationOverlay;
/*     */ import com.prineside.tdi2.utils.InputVoid;
/*     */ import com.prineside.tdi2.utils.IntRectangle;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class MapEditorItemInfoMenu implements Disposable {
/*  45 */   private static final TLog a = TLog.forClass(MapEditorItemInfoMenu.class);
/*     */   
/*     */   public static final int MENU_WIDTH = 400;
/*     */   
/*     */   public static final int MENU_CONTENT_PADDING = 24;
/*     */   public static final int MENU_CONTENT_PADDING_BOTTOM = 12;
/*     */   public static final int MENU_CONTENT_MAX_HEIGHT = 900;
/*     */   public static final int MENU_CONTENT_WIDTH = 352;
/*  53 */   public static final Color ROW_BACKGROUND = new Color(72);
/*     */   
/*     */   public static final float ROW_DEFAULT_HEIGHT = 32.0F;
/*  56 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 102, "MapEditorItemInfoMenu");
/*     */   
/*     */   private final GameSystemProvider c;
/*     */   
/*     */   private boolean d;
/*     */   
/*     */   private final PaddedImageButton e;
/*     */   
/*     */   private final LimitedWidthLabel f;
/*     */   
/*     */   public final Label itemPosition;
/*     */   private Image g;
/*     */   private Label h;
/*     */   private final Group i;
/*     */   private final Table j;
/*     */   private final Table k;
/*     */   private final ScrollPane l;
/*     */   public final Table itemDetailsContainer;
/*     */   private final PaddedImageButton m;
/*     */   public SelectBox.SelectBoxStyle selectBoxStyle;
/*     */   public TextField.TextFieldStyle textFieldStyle;
/*  77 */   public ObjectMap<String, Object> customData = new ObjectMap();
/*     */   
/*     */   private boolean n = false;
/*     */   
/*     */   public boolean expandCodeEditor = false;
/*  82 */   private final DelayedRemovalArray<MapEditorTileInfoMenuListener> o = new DelayedRemovalArray();
/*     */   
/*     */   public MapEditorItemInfoMenu(GameSystemProvider paramGameSystemProvider) {
/*  85 */     this.c = paramGameSystemProvider;
/*     */     
/*  87 */     paramGameSystemProvider.events.getListeners(MapEditorSelectionChange.class).add(paramMapEditorSelectionChange -> update()).setName("MapEditorItemInfoMenu");
/*     */ 
/*     */     
/*  90 */     this.selectBoxStyle = Game.i.assetManager.getSelectBoxStyle((BitmapFont)Game.i.assetManager.getFont(24), true);
/*  91 */     this.textFieldStyle = Game.i.assetManager.getTextFieldStyle(24);
/*     */     
/*     */     Group group1;
/*     */     
/*  95 */     (group1 = new Group()).setTransform(false);
/*  96 */     group1.setTouchable(Touchable.childrenOnly);
/*  97 */     this.b.getTable().add((Actor)group1).size(400.0F, 96.0F).expand().bottom().left().padLeft(160.0F);
/*     */ 
/*     */ 
/*     */     
/* 101 */     this.j = new Table();
/* 102 */     this.j.setBackground((Drawable)Game.i.assetManager.getQuad("ui.components.mapEditorItemInfo.panelBackground"));
/* 103 */     this.j.setWidth(400.0F);
/* 104 */     group1.addActor((Actor)this.j);
/*     */ 
/*     */     
/* 107 */     this.k = new Table();
/* 108 */     this.l = new ScrollPane((Actor)this.k, Game.i.assetManager.getScrollPaneStyle(0.0F));
/* 109 */     this.l.setScrollingDisabled(true, false);
/* 110 */     this.l.addListener((EventListener)new ScrollPaneFocusListener((byte)0));
/* 111 */     this.j.add((Actor)this.l).width(400.0F).fillY();
/*     */ 
/*     */     
/* 114 */     this.itemDetailsContainer = new Table();
/* 115 */     this.k.add((Actor)this.itemDetailsContainer).width(352.0F).padLeft(24.0F).padRight(24.0F).padTop(24.0F).padBottom(12.0F);
/*     */     
/*     */     Group group2;
/*     */     
/* 119 */     (group2 = new Group()).setTransform(false);
/* 120 */     group2.setTouchable(Touchable.enabled);
/* 121 */     group2.addListener((EventListener)new InputVoid());
/* 122 */     group2.setSize(400.0F, 96.0F);
/* 123 */     group1.addActor((Actor)group2);
/*     */     
/*     */     Image image;
/* 126 */     (image = new Image((Drawable)Game.i.assetManager.getQuad("ui.components.mapEditorItemInfo.panel"))).setSize(400.0F, 96.0F);
/* 127 */     group2.addActor((Actor)image);
/*     */     
/* 129 */     this.i = new Group();
/* 130 */     this.i.setTransform(false);
/* 131 */     this.i.setSize(64.0F, 64.0F);
/* 132 */     this.i.setPosition(16.0F, 16.0F);
/* 133 */     group2.addActor((Actor)this.i);
/*     */ 
/*     */     
/* 136 */     this.e = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"), () -> setMinimized(!this.d), Color.WHITE, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P500);
/*     */ 
/*     */     
/* 139 */     this.e.setSize(400.0F, 96.0F);
/* 140 */     this.e.setIconSize(32.0F, 32.0F);
/* 141 */     this.e.setIconPosition(336.0F, 42.0F);
/* 142 */     group2.addActor((Actor)this.e);
/*     */     
/* 144 */     this.m = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-edit"), () -> { if (paramGameSystemProvider._mapEditor.selection.count() == 1) { Item item = paramGameSystemProvider._mapEditor.selection.getCurrentItem(); boolean bool = false; if (paramGameSystemProvider._mapEditor.selection.count() == 1) if (item instanceof TileItem) { Tile tile; if ((tile = ((TileItem)item).tile).sameAs(paramGameSystemProvider.map.getMap().getTile(tile.getX(), tile.getY()))) bool = true;  } else { Gate gate; if (item instanceof GateItem && (gate = ((GateItem)item).gate).sameAs(paramGameSystemProvider.map.getMap().getGate(gate.getX(), gate.getY(), gate.isLeftSide()))) bool = true;  }   if (bool) { a.i("editing map item", new Object[0]); ItemCreationOverlay.i().showForItemListenable(item, (), false); return; }  a.i("editing inventory item", new Object[0]); ItemCreationOverlay.i().showForItem(item); }  }Color.WHITE, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P500);
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
/* 179 */     this.m.setShadow((Drawable)Game.i.assetManager.getDrawable("circle"), 52.0F, 6.0F, 38.0F, 38.0F, new Color(724249531));
/* 180 */     this.m.setIconSize(24.0F, 24.0F);
/* 181 */     this.m.setIconPosition(56.0F, 16.0F);
/* 182 */     this.m.setSize(96.0F, 96.0F);
/* 183 */     this.m.setPosition(0.0F, 0.0F);
/* 184 */     this.m.setTouchable(Touchable.enabled);
/* 185 */     this.m.setVisible(false);
/* 186 */     group2.addActor((Actor)this.m);
/*     */     
/* 188 */     this.f = new LimitedWidthLabel("", 30, 21, 230.0F);
/* 189 */     this.f.setPosition(96.0F, 48.0F);
/* 190 */     this.f.setSize(230.0F, 22.0F);
/* 191 */     this.f.setTouchable(Touchable.disabled);
/* 192 */     group2.addActor((Actor)this.f);
/*     */     
/*     */     Table table;
/* 195 */     (table = new Table()).setPosition(96.0F, 18.0F);
/* 196 */     table.setSize(286.0F, 24.0F);
/* 197 */     table.setTouchable(Touchable.disabled);
/* 198 */     group2.addActor((Actor)table);
/*     */     
/* 200 */     if (Game.i.gameValueManager.getSnapshot().getBooleanValue(GameValueType.PRESTIGE_MODE) || Game.i.progressManager.isDeveloperModeEnabled()) {
/*     */       
/* 202 */       this.g = new Image((Drawable)Game.i.assetManager.getDrawable("icon-crown"));
/* 203 */       this.g.setColor(MaterialColor.LIGHT_BLUE.P400);
/* 204 */       table.add((Actor)this.g).size(24.0F).padRight(8.0F);
/*     */       
/* 206 */       this.h = new Label("350 mP", Game.i.assetManager.getLabelStyle(21));
/* 207 */       this.h.setColor(MaterialColor.LIGHT_BLUE.P400);
/* 208 */       table.add((Actor)this.h);
/*     */     } 
/*     */     
/* 211 */     table.add().height(1.0F).growX();
/*     */     
/* 213 */     this.itemPosition = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 214 */     this.itemPosition.setColor(MaterialColor.AMBER.P500);
/* 215 */     this.itemPosition.setAlignment(1);
/* 216 */     table.add((Actor)this.itemPosition).width(60.0F);
/*     */     
/* 218 */     setVisible(false);
/* 219 */     b();
/*     */   }
/*     */   
/*     */   public void addListener(MapEditorTileInfoMenuListener paramMapEditorTileInfoMenuListener) {
/* 223 */     Preconditions.checkNotNull(paramMapEditorTileInfoMenuListener);
/* 224 */     if (!this.o.contains(paramMapEditorTileInfoMenuListener, true)) {
/* 225 */       this.o.add(paramMapEditorTileInfoMenuListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeListener(MapEditorTileInfoMenuListener paramMapEditorTileInfoMenuListener) {
/* 230 */     Preconditions.checkNotNull(paramMapEditorTileInfoMenuListener);
/* 231 */     this.o.removeValue(paramMapEditorTileInfoMenuListener, true);
/*     */   }
/*     */   
/*     */   public void listRowBg(int paramInt, Table paramTable) {
/* 235 */     if (paramInt % 2 == 0) {
/* 236 */       paramTable.background((Drawable)Game.i.assetManager.getQuad("ui.components.mapEditorItemInfo.listRowBackgroundOdd"));
/*     */     }
/*     */   }
/*     */   
/*     */   public void notifySelectedElementChanged() {
/* 241 */     this.o.begin();
/* 242 */     for (byte b = 0; b < this.o.size; b++) {
/* 243 */       ((MapEditorTileInfoMenuListener)this.o.get(b)).selectedElementModified();
/*     */     }
/* 245 */     this.o.end();
/*     */ 
/*     */     
/* 248 */     this.c._mapEditor.mapChanged = true;
/*     */     
/* 250 */     update();
/*     */   }
/*     */   
/*     */   public boolean isSelectionFromInventory() {
/* 254 */     return this.c._mapEditor.selection.isFromInventory();
/*     */   }
/*     */   
/*     */   public void update() {
/* 258 */     if (this.c._mapEditor.selection.count() == 0) {
/* 259 */       setVisible(false);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 265 */     setVisible(true);
/*     */     
/* 267 */     this.i.clearChildren();
/*     */     
/* 269 */     Item item = (this.c._mapEditor.selection.count() == 1) ? this.c._mapEditor.selection.getCurrentItem() : null;
/*     */     
/* 271 */     double d = 0.0D;
/* 272 */     if (item != null) {
/*     */       
/* 274 */       this.i.addActor(item.generateIcon(64.0F, false));
/* 275 */       if ((ProgressPrefs.i()).inventory.isStarred(item)) {
/*     */         Image image;
/* 277 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"))).setColor(MaterialColor.YELLOW.P500);
/* 278 */         image.setSize(16.0F, 16.0F);
/* 279 */         image.setPosition(56.0F, 56.0F);
/* 280 */         this.i.addActor((Actor)image);
/*     */       } 
/* 282 */       this.f.setText(item.getTitle());
/*     */       
/* 284 */       this.itemPosition.setVisible(true);
/* 285 */       if (item instanceof TileItem) {
/*     */         Tile tile;
/* 287 */         d = (tile = ((TileItem)item).tile).getPrestigeScore() * 1000.0D;
/* 288 */         this.itemPosition.setText(tile.getX() + ":" + tile.getY());
/*     */       } else {
/*     */         Gate gate;
/* 291 */         d = (gate = ((GateItem)item).gate).getPrestigeScore() * 1000.0D;
/* 292 */         this.itemPosition.setText(gate.getX() + ":" + gate.getY() + " " + (gate.isLeftSide() ? "L" : "B"));
/*     */       } 
/*     */       
/* 295 */       if (this.c._mapEditor.selection.isFromInventory()) {
/* 296 */         this.itemPosition.setText(Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-backpack>"));
/*     */       }
/*     */       
/* 299 */       this.itemDetailsContainer.clearChildren();
/* 300 */       this.itemDetailsContainer.setWidth(352.0F);
/* 301 */       if (item instanceof TileItem) {
/* 302 */         ((TileItem)item).tile.fillMapEditorMenu(this.itemDetailsContainer, this);
/*     */       } else {
/* 304 */         ((GateItem)item).gate.fillMapEditorMenu(this.itemDetailsContainer, this);
/*     */       } 
/* 306 */       this.m.setVisible(Game.i.progressManager.isDeveloperModeEnabled());
/*     */     } else {
/*     */       
/* 309 */       this.itemPosition.setVisible(false);
/* 310 */       this.m.setVisible(false);
/*     */       
/* 312 */       int i = this.c._mapEditor.selection.count();
/*     */       
/*     */       Image image;
/* 315 */       (image = new Image((Drawable)Game.i.assetManager.getQuad("mapeditor.tools.select-rectangle"))).setSize(56.0F, 56.0F);
/* 316 */       image.setPosition(4.0F, 4.0F);
/* 317 */       this.i.addActor((Actor)image);
/*     */       
/*     */       Label label;
/* 320 */       (label = new Label(this.c._mapEditor.selection.count(), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/* 321 */       label.setSize(64.0F, 64.0F);
/* 322 */       label.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 323 */       this.i.addActor((Actor)label);
/*     */       
/* 325 */       this.f.setText(Game.i.localeManager.i18n.format("map_editor_selected_n_elements", new Object[] { Integer.valueOf(i) }));
/*     */       
/* 327 */       this.itemDetailsContainer.clearChildren();
/*     */       
/*     */       IntRectangle intRectangle;
/*     */       
/* 331 */       float f2 = ((intRectangle = this.c._mapEditor.selection.dimensions()).maxX - intRectangle.minX + 1);
/* 332 */       float f1 = (intRectangle.maxY - intRectangle.minY + 1);
/*     */ 
/*     */       
/* 335 */       float f3, f4 = (f3 = Math.min(352.0F / Math.max(f2, f1), 128.0F)) / 128.0F;
/*     */       
/* 337 */       Actor actor = new Actor(this, f4)
/*     */         {
/*     */           public void draw(Batch param1Batch, float param1Float) {
/*     */             try {
/* 341 */               Color color = getColor();
/* 342 */               param1Batch.setColor(color.r, color.g, color.b, color.a * param1Float);
/*     */               
/* 344 */               (MapEditorItemInfoMenu.a(this.k))._mapEditor.selection.draw(param1Batch, getX(), getY(), this.j, this.j, (MapEditorItemInfoMenu.a(this.k)).map.getMap()); return;
/* 345 */             } catch (Exception exception) {
/*     */               return;
/*     */             }  } };
/* 348 */       this.itemDetailsContainer.add(actor).size(f2 * f3, f1 * f3).row();
/*     */     } 
/*     */     
/* 351 */     this.o.begin();
/* 352 */     for (byte b = 0; b < this.o.size; b++) {
/* 353 */       ((MapEditorTileInfoMenuListener)this.o.get(b)).menuUpdated();
/*     */     }
/* 355 */     this.o.end();
/*     */ 
/*     */     
/* 358 */     this.itemDetailsContainer.invalidate();
/* 359 */     this.k.pack();
/*     */     
/* 361 */     this.n = false;
/* 362 */     if (this.itemDetailsContainer.getHeight() == 0.0F) {
/*     */       
/* 364 */       this.j.setVisible(false);
/*     */     } else {
/*     */       
/* 367 */       this.j.setVisible(true);
/*     */       float f;
/* 369 */       if ((f = Math.min(this.itemDetailsContainer.getHeight() + 24.0F + 12.0F, 900.0F)) > 900.0F) {
/* 370 */         this.n = true;
/*     */       }
/*     */       
/* 373 */       this.j.setHeight(f);
/* 374 */       this.l.setHeight(f);
/*     */     } 
/*     */     
/* 377 */     if (this.h != null) {
/* 378 */       if (d == 0.0D) {
/* 379 */         this.h.setVisible(false);
/* 380 */         this.g.setVisible(false);
/*     */       } else {
/* 382 */         this.h.setVisible(true);
/* 383 */         this.g.setVisible(true);
/* 384 */         this.h.setText(StringFormatter.commaSeparatedNumber(StrictMath.round(d)) + " mP");
/*     */       } 
/*     */     }
/*     */     
/* 388 */     b();
/*     */   }
/*     */   
/*     */   private void b() {
/* 392 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/* 394 */     if (this.itemDetailsContainer.hasChildren()) {
/* 395 */       this.e.setVisible(true);
/* 396 */       if (this.d) {
/* 397 */         this.e.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top-hollow"));
/*     */         
/* 399 */         this.j.clearActions();
/* 400 */         this.j.addAction((Action)Actions.sequence(
/* 401 */               (Action)Actions.moveTo(0.0F, -this.j.getHeight() - 96.0F, 0.15F * f), 
/* 402 */               (Action)Actions.hide()));
/*     */         return;
/*     */       } 
/* 405 */       this.e.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom-hollow"));
/*     */       
/* 407 */       this.j.clearActions();
/* 408 */       this.j.addAction((Action)Actions.sequence(
/* 409 */             (Action)Actions.show(), 
/* 410 */             (Action)Actions.moveTo(0.0F, 96.0F, 0.15F * f)));
/*     */       
/*     */       return;
/*     */     } 
/* 414 */     this.e.setVisible(false);
/* 415 */     this.j.clearActions();
/* 416 */     this.j.addAction((Action)Actions.sequence(
/* 417 */           (Action)Actions.moveTo(0.0F, -this.j.getHeight() - 96.0F, 0.15F * f), 
/* 418 */           (Action)Actions.hide()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinimized(boolean paramBoolean) {
/* 424 */     this.d = paramBoolean;
/* 425 */     if (paramBoolean) {
/* 426 */       Game.i.uiManager.stage.setKeyboardFocus(null);
/*     */     }
/* 428 */     b();
/*     */   }
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 432 */     this.b.getTable().setVisible(paramBoolean);
/*     */     
/* 434 */     if (!paramBoolean) {
/* 435 */       Game.i.uiManager.stage.setKeyboardFocus(null); return;
/*     */     } 
/* 437 */     b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 443 */     Game.i.uiManager.removeLayer(this.b);
/*     */   }
/*     */   
/*     */   public static interface MapEditorTileInfoMenuListener
/*     */   {
/*     */     void selectedElementModified();
/*     */     
/*     */     void menuUpdated();
/*     */     
/*     */     public static class MapEditorTileInfoMenuListenerAdapter
/*     */       implements MapEditorTileInfoMenuListener {
/*     */       public void selectedElementModified() {}
/*     */       
/*     */       public void menuUpdated() {}
/*     */     }
/*     */   }
/*     */   
/*     */   private class ScrollPaneFocusListener
/*     */     extends InputListener {
/*     */     private ScrollPaneFocusListener(MapEditorItemInfoMenu this$0) {}
/*     */     
/*     */     public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 465 */       if (MapEditorItemInfoMenu.b(this.a)) {
/* 466 */         MapEditorItemInfoMenu.a().i("itemDetailsScroll enter", new Object[0]);
/* 467 */         Game.i.uiManager.stage.setScrollFocus((Actor)MapEditorItemInfoMenu.c(this.a));
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 473 */       if (Game.i.uiManager.stage.getScrollFocus() == MapEditorItemInfoMenu.c(this.a)) {
/* 474 */         MapEditorItemInfoMenu.a().i("itemDetailsScroll exit", new Object[0]);
/* 475 */         Game.i.uiManager.stage.setScrollFocus(null);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\MapEditorItemInfoMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */