/*     */ package com.prineside.tdi2.ui.components;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.CameraController;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.events.game.Render;
/*     */ import com.prineside.tdi2.events.mapEditor.InventoryItemAdd;
/*     */ import com.prineside.tdi2.events.mapEditor.InventoryItemRemove;
/*     */ import com.prineside.tdi2.events.mapEditor.MapEditorSelectionChange;
/*     */ import com.prineside.tdi2.events.mapEditor.SelectionChange;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.SideMenu;
/*     */ import com.prineside.tdi2.utils.InputListenerExtended;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class MapEditorInventoryMenu
/*     */   implements Disposable {
/*  46 */   private static final TLog a = TLog.forClass(MapEditorInventoryMenu.class);
/*     */ 
/*     */   
/*  49 */   private static final ItemSubcategoryType[] b = new ItemSubcategoryType[] { ItemSubcategoryType.ME_PLATFORMS, ItemSubcategoryType.ME_ROADS, ItemSubcategoryType.ME_SOURCES, ItemSubcategoryType.ME_SPAWNS, ItemSubcategoryType.ME_BASES, ItemSubcategoryType.ME_SPECIAL, ItemSubcategoryType.ME_SOUNDS };
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
/*  60 */   private final DelayedRemovalArray<MapEditorInventoryMenuListener> c = new DelayedRemovalArray();
/*     */   
/*     */   private final SideMenu d;
/*     */   private boolean e;
/*     */   private boolean f;
/*     */   private final SideMenu.SideMenuContainer g;
/*  66 */   private final ObjectMap<ItemSubcategoryType, ItemCategoryTab> h = new ObjectMap();
/*     */   
/*     */   private boolean i;
/*  69 */   private final Array<ItemSlot> j = new Array();
/*     */   public ScrollPane scrollPane;
/*     */   private final Group k;
/*     */   private final Label l;
/*     */   private final Table m;
/*     */   private ItemSubcategoryType n;
/*  75 */   public Array<ItemSlot> cells = new Array();
/*  76 */   private final ObjectMap<Item, ItemSlot> o = new ObjectMap();
/*     */   
/*     */   private final CameraController p;
/*     */   
/*     */   private final GameSystemProvider q;
/*     */   
/*  82 */   private static final Vector2 r = new Vector2();
/*  83 */   private static final Array<ItemStack> s = new Array();
/*     */   
/*     */   public MapEditorInventoryMenu(GameSystemProvider paramGameSystemProvider) {
/*  86 */     this.q = paramGameSystemProvider;
/*     */     
/*  88 */     paramGameSystemProvider.events.getListeners(Render.class).add(paramRender -> {
/*     */           if (this.i) {
/*     */             rebuildItemList();
/*     */           }
/*     */         });
/*  93 */     paramGameSystemProvider.events.getListeners(InventoryItemAdd.class).add(paramInventoryItemAdd -> {
/*     */           if (isVisible() && paramInventoryItemAdd.getItem().getSubcategory() == this.n) {
/*     */             Game.i.uiManager.runOnStageActOnce(());
/*     */           }
/*     */         });
/*  98 */     paramGameSystemProvider.events.getListeners(InventoryItemRemove.class).add(paramInventoryItemRemove -> {
/*     */           if (isVisible() && paramInventoryItemRemove.getItem().getSubcategory() == this.n) {
/*     */             Game.i.uiManager.runOnStageActOnce(());
/*     */           }
/*     */         });
/* 103 */     paramGameSystemProvider.events.getListeners(SelectionChange.class).add(paramSelectionChange -> b());
/*     */ 
/*     */ 
/*     */     
/* 107 */     this.p = paramGameSystemProvider._input.getCameraController();
/*     */     
/* 109 */     this.d = new SideMenu(508.0F);
/* 110 */     this.d.addOffscreenBackground();
/*     */ 
/*     */     
/* 113 */     this.g = this.d.createContainer("MapEditorInventoryMenu");
/* 114 */     this.g.setName("tile_inventory_menu_container");
/*     */     
/* 116 */     float f = 160.0F;
/* 117 */     for (int i = b.length - 1; i >= 0; i--) {
/* 118 */       ItemSubcategoryType itemSubcategoryType = b[i];
/*     */       ItemCategoryTab itemCategoryTab;
/* 120 */       (itemCategoryTab = new ItemCategoryTab(itemSubcategoryType, (byte)0)).addListener((EventListener)new ClickListener(this, itemSubcategoryType)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 123 */               this.b.setActiveTab(this.a);
/*     */             }
/*     */           });
/* 126 */       this.h.put(itemSubcategoryType, itemCategoryTab);
/* 127 */       f += 112.0F;
/* 128 */       itemCategoryTab.setPosition(-112.0F, f);
/* 129 */       this.g.addActor((Actor)itemCategoryTab);
/*     */     } 
/*     */     
/*     */     Image image;
/* 133 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(724249599));
/* 134 */     image.setTouchable(Touchable.enabled);
/* 135 */     image.setSize(508.0F, Game.i.settingsManager.getScaledViewportHeight());
/* 136 */     this.g.addActor((Actor)image);
/*     */     
/* 138 */     Table table = new Table();
/*     */     Drawable drawable2;
/* 140 */     (drawable2 = Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.0F))).setMinWidth(4.0F);
/*     */     Drawable drawable1;
/* 142 */     (drawable1 = Game.i.assetManager.getDrawable("blank").tint(MaterialColor.LIGHT_BLUE.P800)).setMinWidth(4.0F);
/* 143 */     this.scrollPane = new ScrollPane((Actor)table, new ScrollPane.ScrollPaneStyle(null, null, null, drawable2, drawable1));
/* 144 */     this.scrollPane.setScrollBarPositions(true, false);
/* 145 */     this.scrollPane.setScrollingDisabled(true, false);
/* 146 */     this.scrollPane.setSize(508.0F, Game.i.settingsManager.getScaledViewportHeight());
/* 147 */     this.g.addActor((Actor)this.scrollPane);
/*     */     
/* 149 */     this.scrollPane.addListener((EventListener)new InputListener(this)
/*     */         {
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 152 */             Game.i.uiManager.stage.setScrollFocus((Actor)this.a.scrollPane);
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 157 */             if (Game.i.uiManager.stage.getScrollFocus() == this.a.scrollPane) {
/* 158 */               Game.i.uiManager.stage.setScrollFocus(null);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 163 */     this.m = new Table();
/* 164 */     table.add((Actor)this.m).width(384.0F).padLeft(32.0F).top().left();
/* 165 */     table.add().size(104.0F, Game.i.settingsManager.getScaledViewportHeight());
/* 166 */     this.m.addListener((EventListener)(new InputListenerExtended(this)
/*     */         {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 169 */             MapEditorInventoryMenu.a().i("touchDown setFlickScroll(false)", new Object[0]);
/* 170 */             if (MapEditorInventoryMenu.a(this.a)) {
/* 171 */               this.a.scrollPane.setFlickScroll(false);
/*     */             }
/* 173 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 178 */             MapEditorInventoryMenu.a().i("touchUp setFlickScroll(true)", new Object[0]);
/* 179 */             this.a.scrollPane.setFlickScroll(true);
/*     */           }
/* 181 */         }).setMode(InputEvent.Type.touchDragged, 2));
/*     */     
/* 183 */     this.l = new Label("", Game.i.assetManager.getLabelStyle(30));
/*     */ 
/*     */     
/* 186 */     this.k = new Group();
/* 187 */     this.k.setTransform(false);
/*     */ 
/*     */ 
/*     */     
/*     */     Group group;
/*     */ 
/*     */     
/* 194 */     (group = new Group()).setTransform(false);
/* 195 */     group.setPosition(416.0F, 0.0F);
/* 196 */     group.setSize(80.0F, Game.i.settingsManager.getScaledViewportHeight());
/* 197 */     group.setTouchable(Touchable.disabled);
/* 198 */     this.g.addActor((Actor)group);
/*     */     
/* 200 */     for (byte b = 0; b < 8; b++) {
/*     */       Image image1;
/* 202 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top"))).setColor(new Color(555819519));
/* 203 */       image1.setSize(32.0F, 32.0F);
/* 204 */       image1.setPosition(24.0F, Game.i.settingsManager.getScaledViewportHeight() / 2.0F + 32.0F + b * 48.0F);
/* 205 */       group.addActor((Actor)image1);
/*     */ 
/*     */       
/* 208 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"))).setColor(new Color(555819519));
/* 209 */       image1.setSize(32.0F, 32.0F);
/* 210 */       image1.setPosition(24.0F, Game.i.settingsManager.getScaledViewportHeight() / 2.0F - 32.0F - 32.0F - b * 48.0F);
/* 211 */       group.addActor((Actor)image1);
/*     */     } 
/*     */     
/* 214 */     this.g.show();
/*     */     
/* 216 */     setActiveTab(b[0]);
/*     */     
/* 218 */     paramGameSystemProvider.events.getListeners(MapEditorSelectionChange.class).add(paramMapEditorSelectionChange -> b())
/*     */       
/* 220 */       .setDescription("MapEditorInventoryMenu");
/*     */   }
/*     */   
/*     */   public SideMenu getSideMenu() {
/* 224 */     return this.d;
/*     */   }
/*     */   
/*     */   public void setItemDraggingMode(boolean paramBoolean) {
/* 228 */     this.e = paramBoolean;
/*     */   }
/*     */   
/*     */   public void addListener(MapEditorInventoryMenuListener paramMapEditorInventoryMenuListener) {
/* 232 */     Preconditions.checkNotNull(paramMapEditorInventoryMenuListener);
/* 233 */     if (!this.c.contains(paramMapEditorInventoryMenuListener, true)) {
/* 234 */       this.c.add(paramMapEditorInventoryMenuListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeListener(MapEditorInventoryMenuListener paramMapEditorInventoryMenuListener) {
/* 239 */     Preconditions.checkNotNull(paramMapEditorInventoryMenuListener);
/* 240 */     this.c.removeValue(paramMapEditorInventoryMenuListener, true);
/*     */   }
/*     */   
/*     */   public void clearListeners() {
/* 244 */     this.c.clear();
/*     */   }
/*     */   
/*     */   public boolean isStagePointOnInventory(float paramFloat1, float paramFloat2) {
/* 248 */     r.set(paramFloat1, paramFloat2);
/* 249 */     this.g.stageToLocalCoordinates(r);
/*     */     
/* 251 */     return (r.x >= 0.0F && r.x <= this.g.getWidth());
/*     */   }
/*     */   
/*     */   public void setActiveTab(ItemSubcategoryType paramItemSubcategoryType) {
/* 255 */     this.n = paramItemSubcategoryType;
/*     */     
/* 257 */     for (ObjectMap.Values<ItemCategoryTab> values = this.h.values().iterator(); values.hasNext();) {
/* 258 */       (itemCategoryTab = values.next()).setActive(false);
/*     */     }
/*     */     
/* 261 */     ((ItemCategoryTab)this.h.get(paramItemSubcategoryType)).setActive(true);
/* 262 */     rebuildItemList();
/*     */     
/* 264 */     this.c.begin();
/* 265 */     for (byte b = 0; b < this.c.size; b++) {
/* 266 */       ((MapEditorInventoryMenuListener)this.c.get(b)).categoryTabChanged();
/*     */     }
/* 268 */     this.c.end();
/*     */   }
/*     */   
/*     */   public void deselectAll() {
/* 272 */     for (byte b = 0; b < this.cells.size; b++) {
/* 273 */       ((ItemSlot)this.cells.get(b)).setActive(false);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 278 */     return true;
/*     */   }
/*     */   
/*     */   public void rebuildItemList() {
/* 282 */     this.i = false;
/*     */     
/* 284 */     deselectAll();
/* 285 */     String str = Game.i.itemManager.getSubcategoryName(this.n);
/* 286 */     this.l.setText(str.toUpperCase());
/*     */ 
/*     */     
/* 289 */     s.clear();
/* 290 */     s.addAll((Array)this.q._inventory.getItemsBySubCategory(this.n));
/*     */ 
/*     */     
/* 293 */     s.sort((paramItemStack1, paramItemStack2) -> {
/*     */           int i = paramItemStack1.getItem().getSortingScore(ItemSortingType.KIND);
/*     */ 
/*     */           
/*     */           int j = paramItemStack2.getItem().getSortingScore(ItemSortingType.KIND);
/*     */ 
/*     */           
/*     */           return (i == j) ? 0 : ((i < j) ? 1 : -1);
/*     */         });
/*     */ 
/*     */     
/* 304 */     this.k.clearChildren();
/*     */     
/*     */     int i;
/*     */     
/* 308 */     float f1 = (i = MathUtils.ceil(s.size / 3.0F)) * 128.0F, f2 = f1;
/*     */ 
/*     */     
/* 311 */     this.cells.clear();
/* 312 */     this.o.clear();
/* 313 */     for (byte b = 0; b < s.size; b++) {
/* 314 */       ItemSlot itemSlot; ItemStack itemStack = (ItemStack)s.get(b);
/*     */ 
/*     */       
/* 317 */       if (b >= this.j.size) {
/*     */         
/* 319 */         itemSlot = new ItemSlot(b, (byte)0);
/* 320 */         this.j.add(itemSlot);
/*     */       } else {
/*     */         
/* 323 */         itemSlot = (ItemSlot)this.j.get(b);
/*     */       } 
/*     */       
/* 326 */       float f = (b % 3) * 128.0F;
/* 327 */       if (b % 3 == 0) f2 -= 128.0F; 
/* 328 */       itemSlot.setPosition(f, f2);
/* 329 */       this.k.addActor((Actor)itemSlot);
/* 330 */       this.cells.add(itemSlot);
/* 331 */       this.o.put(itemStack.getItem(), itemSlot);
/*     */       
/* 333 */       itemSlot.setItemStack(itemStack, false);
/* 334 */       itemSlot.setIconCountVisible(true);
/*     */     } 
/*     */     
/* 337 */     this.m.clearChildren();
/* 338 */     this.m.add((Actor)this.l).top().left().padTop(32.0F).padBottom(10.0F).row();
/* 339 */     this.m.add((Actor)this.k).top().left().width(384.0F).height(f1).padBottom(40.0F);
/*     */     
/* 341 */     b();
/*     */   }
/*     */   
/*     */   public void rebuildSlot(ItemSlot paramItemSlot, boolean paramBoolean) {
/* 345 */     Preconditions.checkNotNull(paramItemSlot, "Slot can not be null");
/*     */     
/*     */     ItemStack itemStack;
/* 348 */     if ((itemStack = paramItemSlot.getItemStack()).getCount() <= 0) {
/*     */       
/* 350 */       if (this.f) {
/*     */         
/* 352 */         paramItemSlot.setIconCountVisible(false); return;
/*     */       } 
/* 354 */       this.i = true;
/*     */       return;
/*     */     } 
/* 357 */     paramItemSlot.setItemStack(itemStack, paramBoolean);
/* 358 */     paramItemSlot.setIconCountVisible(true);
/*     */   }
/*     */ 
/*     */   
/*     */   private ItemSlot a(Item paramItem) {
/* 363 */     Preconditions.checkNotNull(paramItem);
/* 364 */     for (Array.ArrayIterator<ItemSlot> arrayIterator = this.cells.iterator(); arrayIterator.hasNext();) {
/* 365 */       if ((itemSlot = arrayIterator.next()).getItemStack().getItem().sameAs(paramItem)) {
/* 366 */         return itemSlot;
/*     */       }
/*     */     } 
/* 369 */     return null;
/*     */   }
/*     */   
/*     */   public void rebuildSlotOfItem(Item paramItem, boolean paramBoolean) {
/*     */     ItemSlot itemSlot;
/* 374 */     if ((itemSlot = a(paramItem)) == null) {
/*     */       
/* 376 */       this.i = true;
/*     */       return;
/*     */     } 
/* 379 */     rebuildSlot(itemSlot, paramBoolean);
/*     */   }
/*     */   
/*     */   private void b() {
/* 383 */     deselectAll();
/* 384 */     if (this.q._mapEditor.selection.isFromInventory()) {
/* 385 */       Array.ArrayIterator<Tile> arrayIterator; for (arrayIterator = this.q._mapEditor.selection.tiles.iterator(); arrayIterator.hasNext(); ) { Tile tile = arrayIterator.next();
/*     */         ItemSlot itemSlot;
/* 387 */         if ((itemSlot = a((Item)Item.D.F_TILE.create(tile))) != null) {
/* 388 */           itemSlot.setActive(true);
/*     */         } }
/*     */       
/* 391 */       for (arrayIterator = this.q._mapEditor.selection.gates.iterator(); arrayIterator.hasNext(); ) { Gate gate = (Gate)arrayIterator.next();
/*     */         ItemSlot itemSlot;
/* 393 */         if ((itemSlot = a((Item)Item.D.F_GATE.create(gate))) != null) {
/* 394 */           itemSlot.setActive(true);
/*     */         } }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 402 */     this.d.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   public class ItemSlot
/*     */     extends Group
/*     */   {
/*     */     private final Image l;
/*     */     
/*     */     private final Group m;
/*     */     private final Image n;
/*     */     private final Label o;
/*     */     private final Image p;
/*     */     private ItemStack q;
/*     */     private boolean r;
/*     */     
/*     */     private ItemSlot(MapEditorInventoryMenu this$0, int param1Int) {
/* 419 */       setTransform(false);
/*     */       
/* 421 */       setSize(128.0F, 128.0F);
/*     */       
/* 423 */       this.l = new Image((Drawable)Game.i.assetManager.getQuad((param1Int % 2 == 0) ? "ui.components.mapEditorInventory.itemCellA" : "ui.components.mapEditorInventory.itemCellB"));
/* 424 */       this.l.setSize(128.0F, 128.0F);
/* 425 */       addActor((Actor)this.l);
/*     */       
/* 427 */       this.m = new Group();
/* 428 */       this.m.setTransform(false);
/* 429 */       this.m.setPosition(10.0F, 10.0F);
/* 430 */       addActor((Actor)this.m);
/*     */       
/* 432 */       this.n = new Image((Drawable)Game.i.assetManager.getQuad((param1Int % 2 == 0) ? "ui.components.mapEditorInventory.itemCellACountBg" : "ui.components.mapEditorInventory.itemCellBCountBg"));
/* 433 */       this.n.setSize(128.0F, 128.0F);
/* 434 */       this.n.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 435 */       addActor((Actor)this.n);
/*     */       
/* 437 */       this.o = new Label("122", Game.i.assetManager.getLabelStyle(21));
/* 438 */       this.o.setSize(42.0F, 32.0F);
/* 439 */       this.o.setPosition(75.0F, 3.0F);
/* 440 */       this.o.setAlignment(1);
/* 441 */       addActor((Actor)this.o);
/*     */       
/* 443 */       this.p = new Image((Drawable)Game.i.assetManager.getDrawable("icon-star"));
/* 444 */       this.p.setColor(MaterialColor.YELLOW.P500);
/* 445 */       this.p.setSize(20.0F, 20.0F);
/* 446 */       this.p.setPosition(104.0F, 104.0F);
/* 447 */       this.p.setVisible(false);
/* 448 */       addActor((Actor)this.p);
/*     */       
/* 450 */       addListener((EventListener)(new InputListenerExtended(this, MapEditorInventoryMenu.this) {
/* 451 */             private final Vector2 a = new Vector2();
/* 452 */             private final Vector2 b = new Vector2();
/* 453 */             private final Vector2 c = new Vector2();
/*     */             private boolean d = false;
/* 455 */             private int e = -1;
/*     */ 
/*     */             
/*     */             public boolean touchDown(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int1, int param2Int2) {
/* 459 */               if (param2Int2 == 0 && this.e == -1) {
/*     */                 
/* 461 */                 if (MapEditorInventoryMenu.a(this.f.k)) {
/* 462 */                   this.a.x = param2Float1;
/* 463 */                   this.a.y = param2Float2;
/* 464 */                   this.f.localToStageCoordinates(this.a);
/* 465 */                   MapEditorInventoryMenu.a(this.f.k, true);
/*     */                 } 
/* 467 */                 this.e = param2Int1;
/*     */                 
/* 469 */                 return true;
/*     */               } 
/*     */               
/* 472 */               return false;
/*     */             }
/*     */ 
/*     */             
/*     */             public void touchDragged(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int) {
/* 477 */               if (this.e == param2Int) {
/* 478 */                 this.b.set(param2Float1, param2Float2);
/* 479 */                 this.f.localToStageCoordinates(this.b);
/* 480 */                 this.c.set(this.b);
/* 481 */                 MapEditorInventoryMenu.b(this.f.k).stageToScreen(this.c);
/*     */                 
/* 483 */                 if (!this.d && MapEditorInventoryMenu.a(this.f.k) && 
/* 484 */                   this.a.dst2(this.b) > 16.0F) {
/*     */                   
/* 486 */                   this.d = true;
/*     */                   
/* 488 */                   MapEditorInventoryMenu.c(this.f.k).begin();
/* 489 */                   for (byte b = 0; b < (MapEditorInventoryMenu.c(this.f.k)).size; b++) {
/* 490 */                     ((MapEditorInventoryMenu.MapEditorInventoryMenuListener)MapEditorInventoryMenu.c(this.f.k).get(b)).itemSlotDragStart(this.f, this.a);
/*     */                   }
/* 492 */                   MapEditorInventoryMenu.c(this.f.k).end();
/*     */                 } 
/*     */ 
/*     */                 
/* 496 */                 if (this.d) {
/* 497 */                   MapEditorInventoryMenu.c(this.f.k).begin();
/* 498 */                   for (byte b = 0; b < (MapEditorInventoryMenu.c(this.f.k)).size; b++) {
/* 499 */                     ((MapEditorInventoryMenu.MapEditorInventoryMenuListener)MapEditorInventoryMenu.c(this.f.k).get(b)).itemSlotDrag(this.f, this.c);
/*     */                   }
/* 501 */                   MapEditorInventoryMenu.c(this.f.k).end();
/*     */                 } 
/*     */               } 
/*     */             }
/*     */ 
/*     */             
/*     */             public void touchUp(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int1, int param2Int2) {
/* 508 */               if (param2Int1 == this.e) {
/* 509 */                 byte b; MapEditorInventoryMenu.a(this.f.k, false);
/*     */                 
/* 511 */                 this.b.set(param2Float1, param2Float2);
/* 512 */                 this.f.localToStageCoordinates(this.b);
/* 513 */                 this.c.set(this.b);
/* 514 */                 MapEditorInventoryMenu.b(this.f.k).stageToScreen(this.c);
/*     */                 
/* 516 */                 if (this.d) {
/* 517 */                   this.d = false;
/*     */                   
/* 519 */                   MapEditorInventoryMenu.c(this.f.k).begin();
/* 520 */                   for (b = 0; b < (MapEditorInventoryMenu.c(this.f.k)).size; b++) {
/* 521 */                     ((MapEditorInventoryMenu.MapEditorInventoryMenuListener)MapEditorInventoryMenu.c(this.f.k).get(b)).itemSlotDragEnd(this.f, this.c);
/*     */                   }
/* 523 */                   MapEditorInventoryMenu.c(this.f.k).end();
/*     */                   
/* 525 */                   this.f.k.rebuildSlot(this.f, false);
/*     */                 
/*     */                 }
/* 528 */                 else if (!b.isTouchFocusCancel()) {
/* 529 */                   MapEditorInventoryMenu.c(this.f.k).begin();
/* 530 */                   for (b = 0; b < (MapEditorInventoryMenu.c(this.f.k)).size; b++) {
/* 531 */                     ((MapEditorInventoryMenu.MapEditorInventoryMenuListener)MapEditorInventoryMenu.c(this.f.k).get(b)).itemSlotClicked(this.f);
/*     */                   }
/* 533 */                   MapEditorInventoryMenu.c(this.f.k).end();
/*     */                 } 
/*     */                 
/* 536 */                 this.e = -1;
/*     */               } 
/*     */             }
/* 539 */           }).setMode(InputEvent.Type.touchDragged, 2));
/*     */       
/* 541 */       this.r = true;
/* 542 */       setActive(false);
/*     */     }
/*     */     
/*     */     public void setIconCountVisible(boolean param1Boolean) {
/* 546 */       this.m.setVisible(param1Boolean);
/* 547 */       this.o.setVisible(param1Boolean);
/* 548 */       this.n.setVisible(param1Boolean);
/*     */     }
/*     */     
/*     */     public void setItemStack(ItemStack param1ItemStack, boolean param1Boolean) {
/* 552 */       if (param1ItemStack == null)
/*     */         return; 
/* 554 */       if (param1Boolean || this.q == null || !this.q.getItem().sameAs(param1ItemStack.getItem())) {
/*     */         
/* 556 */         this.m.clearChildren();
/* 557 */         Actor actor = param1ItemStack.getItem().generateIcon(108.0F, false);
/* 558 */         this.m.addActor(actor);
/*     */       } 
/*     */       
/* 561 */       this.q = param1ItemStack;
/* 562 */       setIconCountVisible(true);
/*     */       
/* 564 */       this.p.setVisible((ProgressPrefs.i()).inventory.isStarred(param1ItemStack.getItem()));
/*     */       
/* 566 */       this.o.setText(String.valueOf(param1ItemStack.getCount()));
/*     */     }
/*     */     
/*     */     public ItemStack getItemStack() {
/* 570 */       return this.q;
/*     */     }
/*     */     
/*     */     public void setActive(boolean param1Boolean) {
/* 574 */       if (this.r != param1Boolean) {
/* 575 */         if (param1Boolean) {
/* 576 */           this.l.setColor(MaterialColor.LIGHT_BLUE.P800);
/*     */         } else {
/* 578 */           this.l.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*     */         } 
/*     */         
/* 581 */         this.r = param1Boolean;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ItemCategoryTab
/*     */     extends Group {
/*     */     public static final float SIZE = 112.0F;
/*     */     private final Image k;
/*     */     private final Image l;
/*     */     
/*     */     private ItemCategoryTab(ItemSubcategoryType param1ItemSubcategoryType) {
/* 593 */       setTransform(false);
/*     */       
/* 595 */       setSize(112.0F, 112.0F);
/*     */       
/* 597 */       this.k = new Image((Drawable)Game.i.assetManager.getQuad("ui.components.mapEditorInventory.categoryTab.normal"));
/* 598 */       this.k.setSize(112.0F, 112.0F);
/* 599 */       addActor((Actor)this.k);
/*     */       
/* 601 */       this.l = new Image((Drawable)Game.i.assetManager.getDrawable(Game.i.itemManager.getSubcategoryIconAlias(param1ItemSubcategoryType)));
/* 602 */       this.l.setSize(64.0F, 64.0F);
/* 603 */       this.l.setPosition(24.0F, 24.0F);
/* 604 */       addActor((Actor)this.l);
/*     */       
/* 606 */       setActive(false);
/*     */     }
/*     */     
/*     */     public void setActive(boolean param1Boolean) {
/* 610 */       if (param1Boolean) {
/* 611 */         this.k.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.components.mapEditorInventory.categoryTab.active"));
/* 612 */         this.k.setColor(new Color(724249599));
/* 613 */         this.l.setColor(Color.WHITE); return;
/*     */       } 
/* 615 */       this.k.setDrawable((Drawable)Game.i.assetManager.getQuad("ui.components.mapEditorInventory.categoryTab.normal"));
/* 616 */       this.k.setColor(new Color(555819519));
/* 617 */       this.l.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface MapEditorInventoryMenuListener {
/*     */     void itemSlotDragStart(MapEditorInventoryMenu.ItemSlot param1ItemSlot, Vector2 param1Vector2);
/*     */     
/*     */     void itemSlotDragEnd(MapEditorInventoryMenu.ItemSlot param1ItemSlot, Vector2 param1Vector2);
/*     */     
/*     */     void itemSlotDrag(MapEditorInventoryMenu.ItemSlot param1ItemSlot, Vector2 param1Vector2);
/*     */     
/*     */     void itemSlotClicked(MapEditorInventoryMenu.ItemSlot param1ItemSlot);
/*     */     
/*     */     void categoryTabChanged();
/*     */     
/*     */     public static class Adapter implements MapEditorInventoryMenuListener {
/*     */       public void itemSlotDragStart(MapEditorInventoryMenu.ItemSlot param2ItemSlot, Vector2 param2Vector2) {}
/*     */       
/*     */       public void itemSlotDragEnd(MapEditorInventoryMenu.ItemSlot param2ItemSlot, Vector2 param2Vector2) {}
/*     */       
/*     */       public void itemSlotDrag(MapEditorInventoryMenu.ItemSlot param2ItemSlot, Vector2 param2Vector2) {}
/*     */       
/*     */       public void itemSlotClicked(MapEditorInventoryMenu.ItemSlot param2ItemSlot) {}
/*     */       
/*     */       public void categoryTabChanged() {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\MapEditorInventoryMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */