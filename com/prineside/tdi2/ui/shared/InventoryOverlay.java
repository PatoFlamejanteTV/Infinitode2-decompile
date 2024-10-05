/*      */ package com.prineside.tdi2.ui.shared;
/*      */ 
/*      */ import com.badlogic.gdx.Application;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*      */ import com.badlogic.gdx.utils.Disposable;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.Timer;
/*      */ import com.prineside.tdi2.CraftRecipe;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.ItemSortingType;
/*      */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*      */ import com.prineside.tdi2.enums.ItemType;
/*      */ import com.prineside.tdi2.enums.RarityType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.items.GateItem;
/*      */ import com.prineside.tdi2.items.TileItem;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.InputListener;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Cell;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*      */ import com.prineside.tdi2.ui.actors.ButtonHoldHint;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.ItemCell;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*      */ import com.prineside.tdi2.ui.actors.QuadActor;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.QuadDrawable;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.util.Objects;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class InventoryOverlay
/*      */   implements Disposable, UiManager.UiComponent
/*      */ {
/*   67 */   private static final TLog a = TLog.forClass(InventoryOverlay.class);
/*      */   public static InventoryOverlay i() {
/*   69 */     return (InventoryOverlay)Game.i.uiManager.getComponent(InventoryOverlay.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   76 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 190, "InventoryOverlay toggle button");
/*   77 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 192, "InventoryOverlay main");
/*      */   
/*      */   private ComplexButton d;
/*      */   private Group e;
/*      */   private Group f;
/*      */   private Group g;
/*      */   private Group h;
/*      */   private Group i;
/*      */   private QuadActor j;
/*      */   private ScrollPane k;
/*   87 */   private float l = -1.0F;
/*      */   
/*      */   private Image m;
/*      */   
/*      */   private Group n;
/*      */   
/*      */   private Image o;
/*   94 */   private ObjectMap<ItemStack, ItemCell> p = new ObjectMap();
/*      */ 
/*      */   
/*      */   private CraftRecipe q;
/*      */   
/*      */   private int[] r;
/*      */   
/*      */   private boolean s;
/*      */   
/*  103 */   private Array<SubcategoryButtonConfig> t = new Array(SubcategoryButtonConfig.class);
/*      */   
/*      */   private static final TabConfig[] u;
/*      */   private boolean v;
/*      */   
/*      */   public final void dispose() {
/*  109 */     Game.i.uiManager.removeLayer(this.b);
/*  110 */     Game.i.uiManager.removeLayer(this.c);
/*      */   }
/*      */   
/*      */   public enum TabType {
/*  114 */     ITEMS_MATERIALS,
/*  115 */     ITEMS_MAP_EDITOR,
/*  116 */     ITEMS_OTHER,
/*      */ 
/*      */     
/*  119 */     CRAFTING,
/*  120 */     PACKS;
/*      */     
/*  122 */     public static final TabType[] values = values();
/*      */     static {
/*      */     
/*      */     } }
/*      */   static {
/*  127 */     (u = new TabConfig[TabType.values.length])[TabType.ITEMS_MATERIALS.ordinal()] = new TabConfig(TabType.ITEMS_MATERIALS, 92.0F, "icon-backpack", MaterialColor.CYAN.P800, MaterialColor.CYAN.P500, new ItemSubcategoryType[] { ItemSubcategoryType.M_RESOURCE, ItemSubcategoryType.M_BLUEPRINT, ItemSubcategoryType.M_DUST, ItemSubcategoryType.M_TOKENS, ItemSubcategoryType.M_CURRENCY }, (byte)0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  134 */     u[TabType.ITEMS_MAP_EDITOR.ordinal()] = new TabConfig(TabType.ITEMS_MAP_EDITOR, 216.0F, "icon-edit", MaterialColor.GREEN.P800, MaterialColor.GREEN.P500, new ItemSubcategoryType[] { ItemSubcategoryType.ME_PLATFORMS, ItemSubcategoryType.ME_ROADS, ItemSubcategoryType.ME_SOURCES, ItemSubcategoryType.ME_SPAWNS, ItemSubcategoryType.ME_BASES, ItemSubcategoryType.ME_SOUNDS, ItemSubcategoryType.ME_SPECIAL }, (byte)0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  143 */     u[TabType.ITEMS_OTHER.ordinal()] = new TabConfig(TabType.ITEMS_OTHER, 340.0F, "icon-question", MaterialColor.BLUE_GREY.P800, MaterialColor.BLUE_GREY.P500, new ItemSubcategoryType[] { ItemSubcategoryType.O_OTHER }, (byte)0);
/*      */ 
/*      */ 
/*      */     
/*  147 */     u[TabType.CRAFTING.ordinal()] = new TabConfig(TabType.CRAFTING, 647.0F, "icon-tools", MaterialColor.LIGHT_BLUE.P800, MaterialColor.LIGHT_BLUE.P500, new ItemSubcategoryType[] { ItemSubcategoryType.M_RESOURCE, ItemSubcategoryType.M_BLUEPRINT, ItemSubcategoryType.M_DUST, ItemSubcategoryType.M_TOKENS, ItemSubcategoryType.M_CURRENCY, ItemSubcategoryType.ME_PLATFORMS, ItemSubcategoryType.ME_ROADS, ItemSubcategoryType.ME_SOURCES, ItemSubcategoryType.ME_SPAWNS, ItemSubcategoryType.ME_BASES, ItemSubcategoryType.ME_SOUNDS, ItemSubcategoryType.ME_SPECIAL, ItemSubcategoryType.P_DECRYPTED, ItemSubcategoryType.P_ENCRYPTED }, (byte)0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  163 */     u[TabType.PACKS.ordinal()] = new TabConfig(TabType.PACKS, 771.0F, "icon-chest", MaterialColor.PINK.P800, MaterialColor.PINK.P500, new ItemSubcategoryType[] { ItemSubcategoryType.P_DECRYPTED, ItemSubcategoryType.P_ENCRYPTED }, (byte)0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  170 */   private TabType w = TabType.ITEMS_MATERIALS;
/*  171 */   private float[] x = new float[TabType.values.length];
/*  172 */   private ItemSortingType y = ItemSortingType.KIND; @Null
/*  173 */   private ItemStack z = null;
/*  174 */   private Array<ItemStack> A = new Array(ItemStack.class);
/*  175 */   private Array<ItemStack> B = new Array(ItemStack.class);
/*      */   
/*      */   private boolean C;
/*      */ 
/*      */   
/*  180 */   private final ItemCountSelectionOverlay.ItemCountSelectionListener D = new ItemCountSelectionOverlay.ItemCountSelectionListener(this)
/*      */     {
/*      */       public void countChanged(int param1Int) {
/*  183 */         InventoryOverlay.a(this.a);
/*      */       }
/*      */ 
/*      */       
/*      */       public void selectionConfirmed(int param1Int) {
/*  188 */         if (InventoryOverlay.b(this.a) != null) {
/*  189 */           Game.i.progressManager.sellItems(InventoryOverlay.b(this.a).getItem(), param1Int);
/*      */         }
/*  191 */         this.a.update();
/*  192 */         InventoryOverlay.c(this.a);
/*      */       }
/*      */       
/*      */       public void selectionCanceled() {}
/*      */     };
/*      */   
/*  198 */   private final Array<Label> E = new Array(Label.class);
/*      */   
/*  200 */   private final _ProgressManagerListener F = new _ProgressManagerListener((byte)0);
/*      */ 
/*      */   
/*  203 */   private static final Array<ItemStack> G = new Array(ItemStack.class);
/*      */   
/*      */   private ButtonHoldHint H;
/*      */   
/*      */   public InventoryOverlay() {
/*  208 */     Game.i.progressManager.addListener((ProgressManager.ProgressManagerListener)this.F);
/*      */     
/*      */     Group group;
/*      */     
/*  212 */     (group = new Group()).setTouchable(Touchable.childrenOnly);
/*  213 */     group.setTransform(false);
/*  214 */     this.b.getTable().add((Actor)group).bottom().left().size(112.0F, 105.0F).padBottom(723.0F);
/*  215 */     this.b.getTable().add().height(1.0F).expand().fill();
/*      */     
/*  217 */     this.d = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> show());
/*  218 */     this.d.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-inventory-toggle-button"), -100.0F, 0.0F, 212.0F, 105.0F);
/*  219 */     this.d.setBackgroundColors(MaterialColor.CYAN.P800
/*  220 */         .cpy().mul(1.0F, 1.0F, 1.0F, 0.78F), MaterialColor.CYAN.P900, MaterialColor.CYAN.P700, MaterialColor.GREY.P800);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  225 */     this.d.setIconLabelColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/*  226 */     this.d.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-backpack"), 28.0F, 25.0F, 64.0F, 64.0F);
/*      */     
/*  228 */     this.m = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"));
/*  229 */     this.m.setPosition(86.0F, 72.0F);
/*  230 */     this.m.setSize(32.25F, 36.75F);
/*  231 */     this.m.setVisible(false);
/*  232 */     this.d.addActor((Actor)this.m);
/*      */     
/*  234 */     group.addActor((Actor)this.d);
/*      */     
/*      */     Table table;
/*  237 */     (table = new Table()).setPosition(24.0F, -75.0F);
/*  238 */     table.setSize(190.0F, 75.0F);
/*  239 */     table.setTouchable(Touchable.disabled);
/*  240 */     this.d.addActor((Actor)table);
/*      */     
/*  242 */     rebuildLayoutIfRequired();
/*      */     
/*  244 */     this.c.getTable().setVisible(false);
/*      */     
/*  246 */     this.v = false;
/*  247 */     this.d.setPosition(-212.0F, 723.0F);
/*  248 */     this.d.setVisible(false);
/*  249 */     this.c.getTable().setVisible(false);
/*      */     
/*  251 */     n();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void requireLayoutRebuild() {}
/*      */ 
/*      */ 
/*      */   
/*      */   public final void rebuildLayoutIfRequired() {
/*  261 */     this.c.getTable().clear();
/*      */     
/*  263 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*      */     
/*      */     Group group;
/*  266 */     (group = new Group()).setTransform(false);
/*  267 */     group.setOrigin(598.0F, (860.0F + i) * 0.5F);
/*  268 */     this.c.getTable().add((Actor)group).size(1196.0F, 860.0F + i);
/*      */     
/*  270 */     this.e = new Group();
/*  271 */     this.e.setTransform(false);
/*  272 */     this.e.setSize(1196.0F, 860.0F + i);
/*  273 */     this.e.setOrigin(598.0F, (860.0F + i) * 0.5F);
/*  274 */     group.addActor((Actor)this.e);
/*      */ 
/*      */ 
/*      */     
/*      */     QuadActor quadActor2;
/*      */ 
/*      */ 
/*      */     
/*  282 */     (quadActor2 = new QuadActor(new Color(72), new float[] { 0.0F, 13.0F, 0.0F, 40.0F, 872.0F, 40.0F, 858.0F, 0.0F })).setPosition(20.0F, -11.0F);
/*  283 */     this.e.addActor((Actor)quadActor2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  291 */     (quadActor2 = new QuadActor(new Color(72), new float[] { 0.0F, 0.0F, 321.0F, 870.0F + i, 347.0F, 871.0F + i, 330.0F, 7.0F })).setPosition(872.0F, -24.0F);
/*  292 */     this.e.addActor((Actor)quadActor2);
/*      */     
/*  294 */     this.j = new QuadActor(MaterialColor.GREY.P500, new float[] { 0.0F, 0.0F, 110.0F, 17.0F, 135.0F, 17.0F, 119.0F, 4.0F });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  300 */     this.e.addActor((Actor)this.j);
/*      */     
/*  302 */     quadActor2 = new QuadActor(new Color(791621631), new float[] { 7.0F, 11.0F, 0.0F, 849.0F + i, 1196.0F, 860.0F + i, 1185.0F, 0.0F });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  308 */     this.e.addActor((Actor)quadActor2);
/*      */     
/*  310 */     this.g = new Group();
/*  311 */     this.g.setTransform(false);
/*  312 */     this.g.setSize(862.0F, 832.0F + i);
/*  313 */     this.g.setPosition(0.0F, 14.0F);
/*  314 */     this.e.addActor((Actor)this.g);
/*      */     
/*  316 */     this.i = new Group();
/*  317 */     this.i.setTransform(false);
/*  318 */     this.i.setPosition(-82.0F, 14.0F);
/*  319 */     this.i.setSize(82.0F, 832.0F + i);
/*  320 */     this.e.addActor((Actor)this.i);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  328 */     (quadActor2 = new QuadActor(new Color(36), new float[] { 15.0F, 0.0F, 0.0F, 854.0F + i, 17.0F, 854.0F + i, 22.0F, 0.0F })).setPosition(837.0F, 3.0F);
/*  329 */     this.e.addActor((Actor)quadActor2);
/*      */     
/*      */     ComplexButton complexButton;
/*  332 */     (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> hideWithToggleButton(true))).setBackground((Drawable)Game.i.assetManager.getDrawable("ui-inventory-toggle-button"), -100.0F, 0.0F, 212.0F, 105.0F);
/*  333 */     complexButton.setBackgroundColors(MaterialColor.CYAN.P800, MaterialColor.CYAN.P900, MaterialColor.CYAN.P700, MaterialColor.GREY.P800);
/*  334 */     complexButton.setIconLabelColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/*  335 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 28.0F, 25.0F, 64.0F, 64.0F);
/*  336 */     complexButton.setPosition(1193.0F, 633.0F + i);
/*  337 */     complexButton.setSize(112.0F, 105.0F);
/*  338 */     this.e.addActor((Actor)complexButton);
/*      */     
/*  340 */     this.n = new Group();
/*  341 */     this.n.setPosition(854.0F, 0.0F);
/*  342 */     this.n.setSize(342.0F, 860.0F + i);
/*  343 */     this.e.addActor((Actor)this.n);
/*      */ 
/*      */ 
/*      */     
/*      */     QuadActor quadActor1;
/*      */ 
/*      */ 
/*      */     
/*  351 */     (quadActor1 = new QuadActor(new Color(909522687), new float[] { 6.0F, 0.0F, 0.0F, 877.0F + i, 342.0F, 867.0F + i, 331.0F, 7.0F })).setPosition(854.0F, -7.0F);
/*  352 */     this.e.addActor((Actor)quadActor1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  360 */     (quadActor1 = new QuadActor(new Color(-239), new float[] { 6.0F, 0.0F, 0.0F, 877.0F + i, 12.0F, 871.0F + i, 8.0F, 0.0F })).setPosition(854.0F, -7.0F);
/*  361 */     this.e.addActor((Actor)quadActor1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  369 */     (quadActor1 = new QuadActor(new Color(-239), new float[] { 12.0F, 4.0F, 0.0F, 10.0F, 342.0F, 0.0F, 342.0F, 0.0F })).setPosition(854.0F, 860.0F + i);
/*  370 */     this.e.addActor((Actor)quadActor1);
/*      */ 
/*      */     
/*  373 */     this.h = new Group();
/*  374 */     this.h.setPosition(854.0F, 0.0F);
/*  375 */     this.h.setSize(342.0F, 860.0F + i);
/*      */     
/*  377 */     this.e.addActor((Actor)this.h);
/*      */ 
/*      */     
/*  380 */     this.f = new Group();
/*  381 */     this.f.setTransform(false);
/*  382 */     this.f.setSize(854.0F, 110.0F);
/*  383 */     this.f.setTouchable(Touchable.childrenOnly);
/*  384 */     this.e.addActor((Actor)this.f);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean b() {
/*  391 */     return (this.A.size > 0);
/*      */   }
/*      */   
/*      */   private void a(ItemStack paramItemStack) {
/*  395 */     if (this.z != null) {
/*  396 */       setSelectedItem(null);
/*      */     }
/*      */     
/*  399 */     if (this.A.contains(paramItemStack, true)) {
/*      */       ItemCell itemCell;
/*  401 */       if ((itemCell = (ItemCell)this.p.get(paramItemStack, null)) != null) {
/*  402 */         itemCell.setSelected(false);
/*      */       }
/*      */       
/*  405 */       this.A.removeValue(paramItemStack, true);
/*  406 */       if (this.A.size == 0) {
/*  407 */         c();
/*      */       }
/*      */     } else {
/*  410 */       this.A.add(paramItemStack);
/*      */       
/*      */       ItemCell itemCell;
/*  413 */       if ((itemCell = (ItemCell)this.p.get(paramItemStack, null)) != null) {
/*  414 */         itemCell.setSelected(true);
/*      */       }
/*      */     } 
/*  417 */     j();
/*      */   }
/*      */   
/*      */   private void c() {
/*  421 */     if (this.A.size > 0) {
/*      */       
/*  423 */       for (byte b = 0; b < this.A.size; b++) {
/*  424 */         ItemStack itemStack = ((ItemStack[])this.A.items)[b];
/*      */         ItemCell itemCell;
/*  426 */         if ((itemCell = (ItemCell)this.p.get(itemStack, null)) != null) {
/*  427 */           itemCell.setSelected(false);
/*      */         }
/*      */       } 
/*      */       
/*  431 */       this.A.clear();
/*  432 */       j();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void d() {
/*  438 */     if (this.w != TabType.ITEMS_MAP_EDITOR) {
/*      */       return;
/*      */     }
/*      */     
/*  442 */     float f1 = this.k.getScrollY();
/*  443 */     float f2 = this.k.getHeight();
/*      */ 
/*      */     
/*  446 */     float f3, f4 = (f3 = this.k.getMaxY()) - f1 + 70.0F;
/*  447 */     f1 = f3 - f1 - f2 + 70.0F;
/*      */     
/*  449 */     if (this.z != null) {
/*  450 */       setSelectedItem(null);
/*      */     }
/*      */     
/*  453 */     for (ObjectMap.Entries<ObjectMap.Entry> entries = this.p.iterator(); entries.hasNext();) {
/*      */       
/*  455 */       if ((f = ((ItemCell)(entry = entries.next()).value).getTop()) >= f4 && f <= f1 && !this.A.contains(entry.key, true)) {
/*  456 */         this.A.add(entry.key);
/*  457 */         ((ItemCell)entry.value).setSelected(true);
/*      */       } 
/*      */     } 
/*      */     
/*  461 */     j();
/*      */   }
/*      */   
/*      */   private void a(TabType paramTabType) {
/*  465 */     if (this.w != paramTabType) {
/*  466 */       this.z = null;
/*  467 */       c();
/*      */       
/*  469 */       TabType tabType = this.w;
/*  470 */       this.w = paramTabType;
/*  471 */       if (this.k != null) {
/*  472 */         this.x[tabType.ordinal()] = this.k.getScrollY();
/*  473 */         this.k.setScrollY(this.x[paramTabType.ordinal()]);
/*      */       } 
/*      */       
/*  476 */       update(); TabConfig[] arrayOfTabConfig;
/*      */       int i;
/*      */       byte b;
/*  479 */       for (i = (arrayOfTabConfig = u).length, b = 0; b < i; ) { TabConfig tabConfig = arrayOfTabConfig[b];
/*  480 */         if (this.w == tabConfig.tabType) {
/*      */           Label label;
/*  482 */           (label = new Label(tabConfig.getName(), Game.i.assetManager.getLabelStyle(24))).setPosition(tabConfig.buttonShiftX - 1.0F, -40.0F);
/*  483 */           label.setSize(2.0F, 18.0F);
/*  484 */           label.setAlignment(1);
/*  485 */           label.addAction((Action)Actions.sequence(
/*  486 */                 (Action)Actions.alpha(0.0F), 
/*  487 */                 (Action)Actions.fadeIn(0.3F), 
/*  488 */                 (Action)Actions.delay(3.0F), 
/*  489 */                 (Action)Actions.fadeOut(1.0F), 
/*  490 */                 (Action)Actions.removeActor()));
/*      */           
/*  492 */           this.f.addActor((Actor)label);
/*      */           return;
/*      */         } 
/*      */         b++; }
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   private void e() {
/*  501 */     Item item = this.z.getItem();
/*  502 */     int i = ItemCountSelectionOverlay.i().getSelectedCount();
/*      */     
/*  504 */     this.B.clear();
/*  505 */     item.addSellItems(this.B);
/*      */     
/*  507 */     for (byte b = 0; b < G.size; b++) {
/*  508 */       ItemStack itemStack = ((ItemStack[])this.B.items)[b];
/*  509 */       ((Label[])this.E.items)[b].setText((CharSequence)StringFormatter.commaSeparatedNumber((itemStack.getCount() * i)));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void f() {
/*      */     Table table;
/*  515 */     (table = ItemCountSelectionOverlay.i().getInfoContainer()).clear();
/*      */     
/*  517 */     CraftRecipe craftRecipe = this.q;
/*      */     
/*  519 */     if (this.r == null)
/*      */     {
/*  521 */       this.r = new int[craftRecipe.ingredients.size];
/*      */     }
/*      */ 
/*      */     
/*  525 */     int i = ItemCountSelectionOverlay.i().getSelectedCount();
/*  526 */     int j = craftRecipe.getMaxQueueStackWithGVs();
/*  527 */     boolean bool = true;
/*      */     
/*  529 */     for (byte b = 0; b < craftRecipe.ingredients.size; b++) {
/*      */       Item item; CraftRecipe.Ingredient ingredient;
/*  531 */       Array array = (ingredient = ((CraftRecipe.Ingredient[])craftRecipe.ingredients.items)[b]).getSuitableItemsFromInventory();
/*      */ 
/*      */       
/*  534 */       int m = 0;
/*  535 */       int n = ingredient.getCountWithGVs() * i;
/*      */       
/*  537 */       if (array.size == 0) {
/*      */         
/*  539 */         item = ingredient.getExampleItems()[0];
/*      */       } else {
/*      */         
/*  542 */         int i1 = this.r[b];
/*  543 */         if (array.size <= i1) i1 = 0;
/*      */         
/*  545 */         item = ((ItemStack[])array.items)[i1].getItem();
/*  546 */         m = ((ItemStack[])array.items)[i1].getCount();
/*      */       } 
/*      */       
/*      */       Group group;
/*  550 */       (group = new Group()).setTransform(false);
/*  551 */       table.add((Actor)group).size(64.0F, 80.0F);
/*      */       
/*      */       Actor actor;
/*      */       
/*  555 */       (actor = item.generateIcon(64.0F, true)).setPosition(0.0F, 8.0F);
/*  556 */       group.addActor(actor);
/*      */       
/*      */       Label label1;
/*      */       
/*  560 */       (label1 = new Label(n, Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/*  561 */       label1.setPosition(61.0F, 7.0F);
/*  562 */       label1.setSize(2.0F, 16.0F);
/*  563 */       label1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  564 */       group.addActor((Actor)label1);
/*      */       
/*  566 */       Label label2 = new Label(n, Game.i.assetManager.getLabelStyle(21));
/*  567 */       if (m < n) {
/*      */         
/*  569 */         bool = false;
/*      */         
/*  571 */         label1.setText(m + " / " + n);
/*  572 */         label2.setText(m + " / " + n);
/*  573 */         label2.setColor(MaterialColor.RED.P300);
/*      */       } 
/*  575 */       label2.setAlignment(1);
/*  576 */       label2.setPosition(63.0F, 5.0F);
/*  577 */       label2.setSize(2.0F, 16.0F);
/*  578 */       group.addActor((Actor)label2);
/*      */ 
/*      */       
/*  581 */       if (array.size > 1) {
/*  582 */         byte b1 = b;
/*      */         
/*  584 */         if (this.r[b] > 0) {
/*      */           PaddedImageButton paddedImageButton;
/*      */ 
/*      */ 
/*      */           
/*  589 */           (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top"), () -> { this.r[paramInt] = this.r[paramInt] - 1; f(); }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P600)).setIconSize(24.0F, 24.0F);
/*  590 */           paddedImageButton.setIconPosition(20.0F, 33.0F);
/*  591 */           paddedImageButton.setSize(64.0F, 64.0F);
/*  592 */           paddedImageButton.setPosition(0.0F, 38.0F);
/*  593 */           group.addActor((Actor)paddedImageButton);
/*      */         } 
/*  595 */         if (this.r[b] < array.size - 1) {
/*      */           PaddedImageButton paddedImageButton;
/*      */ 
/*      */ 
/*      */           
/*  600 */           (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"), () -> { this.r[paramInt] = this.r[paramInt] + 1; f(); }MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P600)).setIconSize(24.0F, 24.0F);
/*  601 */           paddedImageButton.setIconPosition(20.0F, 6.0F);
/*  602 */           paddedImageButton.setSize(64.0F, 64.0F);
/*  603 */           paddedImageButton.setPosition(0.0F, -26.0F);
/*  604 */           group.addActor((Actor)paddedImageButton);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  609 */       if (b + 1 != craftRecipe.ingredients.size) {
/*      */         Image image;
/*      */         
/*  612 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-plus"))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  613 */         table.add((Actor)image).size(24.0F).padLeft(20.0F).padRight(20.0F);
/*      */       } 
/*      */       
/*      */       int k;
/*      */       
/*  618 */       if ((k = m / ingredient.getCountWithGVs()) < j) {
/*  619 */         j = k;
/*      */       }
/*      */     } 
/*  622 */     if (j <= 0) j = 1;
/*      */     
/*  624 */     table.add().height(1.0F).expandX().fillX();
/*      */     
/*  626 */     if (i > j || ItemCountSelectionOverlay.i().getMaxCount() != j) {
/*      */       
/*  628 */       a.e("selected " + i + " available " + j, new Object[0]);
/*      */       
/*  630 */       ItemCountSelectionOverlay.i().setMinMaxCount(1, j);
/*  631 */       f();
/*      */     } 
/*      */     
/*  634 */     ItemCountSelectionOverlay.i().setConfirmButtonEnabled(bool);
/*      */   }
/*      */   
/*      */   private void g() {
/*  638 */     if (this.k != null) {
/*  639 */       float f1 = this.k.getVisualScrollY();
/*  640 */       float f2 = this.i.getHeight();
/*      */ 
/*      */       
/*  643 */       for (byte b = 0; b < this.t.size; b++) {
/*      */         SubcategoryButtonConfig subcategoryButtonConfig;
/*  645 */         float f4 = (subcategoryButtonConfig = ((SubcategoryButtonConfig[])this.t.items)[b]).button.getHeight();
/*      */         
/*  647 */         float f5 = subcategoryButtonConfig.distanceY - f1;
/*      */         
/*  649 */         if ((f5 = this.i.getHeight() - f5) + f4 * 0.5F > f2) {
/*  650 */           f5 = f2 - f4 * 0.5F;
/*      */         }
/*      */         
/*  653 */         subcategoryButtonConfig.button.setPosition(0.0F, f5 - f4 * 0.5F);
/*  654 */         f2 = f5 - f4 * 0.5F;
/*      */       } 
/*      */ 
/*      */       
/*  658 */       float f3 = 0.0F;
/*  659 */       for (int i = this.t.size - 1; i >= 0; i--) {
/*      */         SubcategoryButtonConfig subcategoryButtonConfig;
/*  661 */         if ((subcategoryButtonConfig = ((SubcategoryButtonConfig[])this.t.items)[i]).button.getY() < f3) {
/*  662 */           subcategoryButtonConfig.button.setY(f3);
/*  663 */           f3 += subcategoryButtonConfig.button.getHeight();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void h() {
/*  670 */     this.f.clearChildren(); TabConfig[] arrayOfTabConfig; int i;
/*      */     byte b;
/*  672 */     for (i = (arrayOfTabConfig = u).length, b = 0; b < i; b++) {
/*  673 */       TabConfig tabConfig; if ((tabConfig = arrayOfTabConfig[b]).tabType != TabType.ITEMS_OTHER) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  679 */         if (this.w == tabConfig.tabType) {
/*      */           
/*  681 */           this.j.setPosition(tabConfig.buttonShiftX - 60.0F, -6.0F);
/*  682 */           this.j.setColor(tabConfig.colorDark);
/*      */           
/*      */           Group group;
/*  685 */           (group = new Group()).setTransform(false);
/*  686 */           group.setTouchable(Touchable.disabled);
/*  687 */           group.setSize(132.0F, 132.0F);
/*  688 */           group.setPosition(tabConfig.buttonShiftX - 66.0F, -6.0F);
/*  689 */           this.f.addActor((Actor)group);
/*      */ 
/*      */ 
/*      */           
/*      */           QuadActor quadActor;
/*      */ 
/*      */ 
/*      */           
/*  697 */           (quadActor = new QuadActor(new Color(32), new float[] { 0.0F, 4.0F, 7.0F, 120.0F, 17.0F, 119.0F, 5.0F, 7.0F })).setPosition(125.0F, 0.0F);
/*  698 */           group.addActor((Actor)quadActor);
/*      */           
/*  700 */           quadActor = new QuadActor(tabConfig.colorDark, new float[] { 6.0F, 0.0F, 0.0F, 132.0F, 132.0F, 129.0F, 125.0F, 4.0F });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  706 */           group.addActor((Actor)quadActor);
/*      */           
/*      */           Image image;
/*  709 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable(tabConfig.iconAlias))).setSize(80.0F, 80.0F);
/*  710 */           image.setPosition(25.0F, 28.0F);
/*  711 */           group.addActor((Actor)image);
/*      */         } else {
/*      */           ComplexButton complexButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  724 */           (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> a(paramTabConfig.tabType))).setPosition(tabConfig.buttonShiftX - 54.0F, 25.0F);
/*  725 */           complexButton.setSize(108.0F, 85.0F);
/*  726 */           complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable(tabConfig.iconAlias), 22.0F, 18.0F, 64.0F, 64.0F);
/*      */ 
/*      */           
/*  729 */           complexButton.setIconLabelColors(Color.WHITE, tabConfig.colorBright, tabConfig.colorDark, MaterialColor.GREY.P500);
/*  730 */           complexButton.setIconLabelShadowEnabled(true);
/*  731 */           this.f.addActor((Actor)complexButton);
/*      */         } 
/*      */         
/*  734 */         if (tabConfig.tabType == TabType.PACKS) {
/*  735 */           this.o = new Image((TextureRegion)Game.i.assetManager.getTextureRegion("count-bubble"));
/*  736 */           this.o.setSize(21.5F, 24.5F);
/*  737 */           this.o.setPosition(tabConfig.buttonShiftX + 24.0F, 84.0F);
/*  738 */           this.o.setVisible(false);
/*  739 */           if (this.w != TabType.PACKS)
/*      */           {
/*  741 */             this.f.addActor((Actor)this.o);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*  746 */     o();
/*      */   }
/*      */   
/*      */   private static ComplexButton a(String paramString, Drawable paramDrawable, Color[] paramArrayOfColor, Runnable paramRunnable1, Runnable paramRunnable2, Table paramTable1, Table paramTable2) {
/*      */     ComplexButton complexButton;
/*  751 */     (complexButton = new ComplexButton(paramString, Game.i.assetManager.getLabelStyle(24), paramRunnable1, paramRunnable2)).setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 5.0F, 0.0F, 0.0F, 80.0F, 328.0F, 77.0F, 323.0F, 3.0F })), 0.0F, 10.0F, 328.0F, 80.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  757 */     complexButton.backgroundShadow.setVisible(true);
/*  758 */     complexButton.backgroundShadow.setSize(327.0F, 87.0F);
/*  759 */     complexButton.backgroundShadow.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*  760 */     complexButton.backgroundShadow.setDrawable((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 14.0F, 0.0F, 6.0F, 87.0F, 327.0F, 85.0F, 320.0F, 11.0F })));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  767 */     complexButton.setBackgroundColors(paramArrayOfColor[MaterialColor.Variants.P800.ordinal()], paramArrayOfColor[MaterialColor.Variants.P900.ordinal()], paramArrayOfColor[MaterialColor.Variants.P700.ordinal()], MaterialColor.GREY.P700);
/*  768 */     complexButton.setIconPositioned(paramDrawable, 21.0F, 25.0F, 48.0F, 48.0F);
/*  769 */     complexButton.setLabel(77.0F, 25.0F, 240.0F, 48.0F, 8);
/*  770 */     complexButton.label.setWrap(true);
/*      */     
/*  772 */     paramTable1.add((Actor)complexButton).size(328.0F, 90.0F).padTop(8.0F).padLeft(23.0F).left().row();
/*      */ 
/*      */ 
/*      */     
/*      */     Image image;
/*      */ 
/*      */ 
/*      */     
/*  780 */     (image = new Image((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 13.0F, 19.0F, 13.0F, 19.0F, 13.0F })))).setColor(paramArrayOfColor[MaterialColor.Variants.P800.ordinal()]);
/*  781 */     image.getColor().lerp(Color.BLACK, 0.5F);
/*  782 */     paramTable2.add((Actor)image).size(19.0F, 13.0F).padLeft(326.0F).padTop(85.0F).left().row();
/*      */     
/*  784 */     return complexButton;
/*      */   }
/*      */ 
/*      */   
/*      */   private void j() {
/*  789 */     if (this.w != TabType.CRAFTING && this.z != null && Game.i.progressManager.getItemsCount(this.z.getItem()) == 0) {
/*  790 */       setSelectedItem(null);
/*      */       
/*      */       return;
/*      */     } 
/*  794 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*      */     
/*  796 */     this.h.clearChildren();
/*  797 */     this.n.clearChildren();
/*      */     
/*      */     Table table1;
/*  800 */     (table1 = new Table()).setSize(342.0F, 820.0F + i);
/*  801 */     table1.setTouchable(Touchable.childrenOnly);
/*  802 */     table1.setPosition(0.0F, 20.0F);
/*  803 */     this.h.addActor((Actor)table1);
/*      */     
/*      */     Table table2;
/*  806 */     (table2 = new Table()).setSize(342.0F, 820.0F + i);
/*  807 */     table2.setTouchable(Touchable.disabled);
/*  808 */     table2.setPosition(0.0F, 20.0F);
/*  809 */     this.n.addActor((Actor)table2);
/*      */     
/*  811 */     table1.add().width(1.0F).expandY().fillY().row();
/*  812 */     table2.add().width(1.0F).expandY().fillY().row();
/*      */     
/*  814 */     Item item = null;
/*  815 */     boolean bool1 = false;
/*  816 */     boolean bool2 = true;
/*      */     
/*  818 */     if (b()) {
/*      */       
/*  820 */       bool2 = false;
/*      */       
/*  822 */       Array array = new Array(Actor.class);
/*  823 */       for (int j = this.A.size - 1; j >= 0; ) {
/*  824 */         Actor actor = ((ItemStack[])this.A.items)[j].getItem().generateIcon(96.0F, true);
/*  825 */         array.add(actor);
/*      */         
/*  827 */         if (array.size != 8)
/*      */           j--; 
/*  829 */       }  item = ((ItemStack[])this.A.items)[this.A.size - 1].getItem();
/*  830 */       bool1 = true;
/*      */ 
/*      */       
/*  833 */       float f = array.size * 24.0F * 0.5F;
/*      */       
/*  835 */       for (byte b2 = 0; b2 < array.size; b2++) {
/*      */         Actor actor;
/*  837 */         (actor = ((Actor[])array.items)[b2]).setPosition(132.0F - f + b2 * 24.0F, 708.0F + i);
/*  838 */         this.h.addActor(actor);
/*  839 */         actor.setZIndex(0);
/*      */       } 
/*      */       
/*      */       Label label1;
/*      */       
/*  844 */       (label1 = new Label(Game.i.localeManager.i18n.get("selected_items_count") + " " + this.A.size, Game.i.assetManager.getLabelStyle(30))).setAlignment(1);
/*  845 */       label1.setPosition(108.0F, 632.0F + i);
/*  846 */       label1.setSize(128.0F, 32.0F);
/*  847 */       label1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  848 */       this.h.addActor((Actor)label1);
/*      */       
/*      */       Label label2;
/*  851 */       (label2 = new Label(Game.i.localeManager.i18n.get("selected_items_count") + " " + this.A.size, Game.i.assetManager.getLabelStyle(30))).setAlignment(1);
/*  852 */       label2.setPosition(107.0F, 635.0F + i);
/*  853 */       label2.setSize(128.0F, 32.0F);
/*  854 */       this.h.addActor((Actor)label2);
/*      */       
/*      */       Label label3;
/*      */       
/*  858 */       (label3 = new Label(Game.i.localeManager.i18n.get("cancel"), Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/*  859 */       label3.setPosition(43.0F, 600.0F + i);
/*  860 */       label3.setSize(256.0F, 32.0F);
/*  861 */       label3.setColor(MaterialColor.LIGHT_BLUE.P500);
/*  862 */       label3.setTouchable(Touchable.enabled);
/*  863 */       label3.addListener((EventListener)new ClickListener(this)
/*      */           {
/*      */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  866 */               InventoryOverlay.d(this.a);
/*      */             }
/*      */           });
/*  869 */       this.h.addActor((Actor)label3);
/*      */ 
/*      */       
/*  872 */       if (this.w == TabType.ITEMS_MAP_EDITOR) {
/*  873 */         String str = Game.i.localeManager.i18n.get("select_visible_items");
/*  874 */         if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/*  875 */           str = str + " (A)";
/*      */         }
/*      */         
/*      */         Label label;
/*  879 */         (label = new Label(str, Game.i.assetManager.getLabelStyle(24))).setAlignment(1);
/*  880 */         label.setPosition(43.0F, 536.0F + i);
/*  881 */         label.setSize(256.0F, 40.0F);
/*  882 */         label.setColor(MaterialColor.LIGHT_BLUE.P500);
/*  883 */         label.setTouchable(Touchable.enabled);
/*  884 */         label.addListener((EventListener)new ClickListener(this)
/*      */             {
/*      */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  887 */                 InventoryOverlay.e(this.a);
/*      */               }
/*      */             });
/*  890 */         this.h.addActor((Actor)label);
/*      */       } 
/*      */ 
/*      */       
/*  894 */       double d = 0.0D; byte b1;
/*  895 */       for (b1 = 0; b1 < this.A.size; b1++) {
/*      */         Item item1;
/*  897 */         if (item1 = ((ItemStack[])this.A.items)[b1].getItem() instanceof TileItem) {
/*  898 */           if (!Game.i.progressManager.isStarred(item1)) {
/*  899 */             d += ((TileItem)item1).tile.getPrestigeScore() * ((ItemStack[])this.A.items)[b1].getCount();
/*      */           }
/*  901 */         } else if (item1 instanceof GateItem && 
/*  902 */           !Game.i.progressManager.isStarred(item1)) {
/*  903 */           d += ((GateItem)item1).gate.getPrestigeScore() * ((ItemStack[])this.A.items)[b1].getCount();
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  909 */       if ((int)(d = d * 250.0D) > 0) {
/*  910 */         a(Game.i.localeManager.i18n
/*  911 */             .get("gv_title_PRESTIGE_MODE") + " (" + StringFormatter.compactNumber(d, false) + " mP)", (Drawable)Game.i.assetManager
/*  912 */             .getDrawable("icon-crown"), MaterialColor.BLUE.values, () -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("dialog_confirm_mass_item_prestige"), ()), null, table1, table2);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  942 */       G.clear();
/*  943 */       for (b1 = 0; b1 < this.A.size; b1++) {
/*      */         ItemStack itemStack;
/*  945 */         if ((itemStack = ((ItemStack[])this.A.items)[b1]).getItem().canBeSold() && !Game.i.progressManager.isStarred(itemStack.getItem())) itemStack.getItem().addSellItemsMultiplied(G, itemStack.getCount()); 
/*      */       } 
/*  947 */       ProgressManager.compressStacksArray(G);
/*      */       
/*  949 */       if (G.size != 0) {
/*  950 */         a(Game.i.localeManager.i18n
/*  951 */             .get("sell_button"), (Drawable)Game.i.assetManager
/*  952 */             .getDrawable("icon-dollar"), MaterialColor.RED.values, () -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("dialog_confirm_mass_item_sell"), ()), null, table1, table2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  963 */         Table table = new Table();
/*  964 */         for (byte b = 0; b < G.size; ) {
/*  965 */           ItemStack itemStack = ((ItemStack[])G.items)[b];
/*      */           
/*      */           Table table3;
/*  968 */           (table3 = new Table()).add(itemStack.getItem().generateIcon(24.0F, false)).size(24.0F).padRight(6.0F).padLeft(8.0F);
/*      */           
/*  970 */           Label label = new Label((CharSequence)StringFormatter.compactNumber(itemStack.getCount(), false), Game.i.assetManager.getLabelStyle(21));
/*  971 */           table3.add((Actor)label).padRight(8.0F);
/*      */           
/*  973 */           table.add((Actor)table3);
/*      */           
/*  975 */           if (b != 2) {
/*      */             b++;
/*      */           }
/*      */         } 
/*  979 */         if (G.size > 3) {
/*  980 */           Label label = new Label("+", Game.i.assetManager.getLabelStyle(24));
/*  981 */           table.add((Actor)label).padRight(8.0F);
/*      */         } 
/*      */         
/*  984 */         table1.add((Actor)table).padBottom(8.0F).padTop(8.0F).height(24.0F).row();
/*  985 */         table2.add().width(1.0F).height(40.0F).row();
/*      */       }
/*      */     
/*  988 */     } else if (this.z != null) {
/*      */       
/*  990 */       item = this.z.getItem();
/*      */       
/*  992 */       if (this.w == TabType.CRAFTING) {
/*      */ 
/*      */         
/*  995 */         Array array = Game.i.itemManager.getCraftRecipes(item);
/*  996 */         for (byte b = 0; b < array.size; b++) {
/*  997 */           CraftRecipe craftRecipe = ((CraftRecipe[])array.items)[b];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           ComplexButton complexButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1043 */           (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> { this.q = paramCraftRecipe; this.r = null; ItemCountSelectionOverlay.i().show(Game.i.localeManager.i18n.get("craft_button") + " - " + paramCraftRecipe.result.getItem().getTitle(), 1, 1, paramCraftRecipe.result.getItem(), new ItemCountSelectionOverlay.ItemCountSelectionListener(this, paramCraftRecipe) { public void countChanged(int param1Int) { InventoryOverlay.k(this.b); } public void selectionConfirmed(int param1Int) { Array array = new Array(Item.class); for (byte b = 0; b < this.a.ingredients.size; b++) { CraftRecipe.Ingredient ingredient; Array array1 = (ingredient = ((CraftRecipe.Ingredient[])this.a.ingredients.items)[b]).getSuitableItemsFromInventory(); Item item = null; if (array1.size != 0) { int i = InventoryOverlay.l(this.b)[b]; if (array1.size <= i) i = 0;  item = ((ItemStack[])array1.items)[i].getItem(); }  array.add(item); }  Game.i.progressManager.startCrafting(this.a, array, param1Int); this.b.update(); } public void selectionCanceled() {} }); f(); })).setBackground((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 5.0F, 0.0F, 0.0F, 120.0F, 328.0F, 117.0F, 323.0F, 3.0F })), 0.0F, 10.0F, 328.0F, 120.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1049 */           complexButton.backgroundShadow.setVisible(true);
/* 1050 */           complexButton.backgroundShadow.setSize(327.0F, 87.0F);
/* 1051 */           complexButton.backgroundShadow.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 1052 */           complexButton.backgroundShadow.setDrawable((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 14.0F, 0.0F, 6.0F, 87.0F, 327.0F, 85.0F, 320.0F, 11.0F })));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1059 */           complexButton.setBackgroundColors(MaterialColor.BLUE_GREY.P800, MaterialColor.BLUE_GREY.P900, MaterialColor.BLUE_GREY.P700, MaterialColor.GREY.P700);
/* 1060 */           table1.add((Actor)complexButton).size(328.0F, 130.0F).padTop(8.0F).padLeft(23.0F).left().row();
/*      */           
/*      */           Group group;
/* 1063 */           (group = new Group()).setTransform(false);
/*      */           
/* 1065 */           group.setPosition(14.0F, 22.0F);
/* 1066 */           group.setSize(290.0F, 96.0F);
/* 1067 */           complexButton.addActor((Actor)group);
/*      */           
/* 1069 */           for (byte b1 = 0; b1 < craftRecipe.ingredients.size; b1++) {
/* 1070 */             float f = b1 * 96.0F;
/*      */             
/* 1072 */             CraftRecipe.Ingredient ingredient = ((CraftRecipe.Ingredient[])craftRecipe.ingredients.items)[b1];
/*      */             
/*      */             Group group1;
/* 1075 */             (group1 = new Group()).setPosition(f + 16.0F, 20.0F);
/* 1076 */             group1.setSize(64.0F, 64.0F);
/* 1077 */             group.addActor((Actor)group1);
/*      */             
/*      */             Item[] arrayOfItem;
/* 1080 */             if ((arrayOfItem = ingredient.getExampleItems()).length == 1) {
/* 1081 */               Actor actor = arrayOfItem[0].generateIcon(64.0F, true);
/* 1082 */               group1.addActor(actor);
/*      */             } else {
/* 1084 */               Array array1 = new Array(); byte b2; Item[] arrayOfItem1; int k;
/* 1085 */               for (k = (arrayOfItem1 = arrayOfItem).length, b2 = 0; b2 < k; ) { Item item1 = arrayOfItem1[b2];
/* 1086 */                 array1.add(item1.generateIcon(64.0F, true));
/*      */                 b2++; }
/*      */               
/* 1089 */               int[] arrayOfInt = { 0 };
/* 1090 */               group1.addActor((Actor)array1.first());
/* 1091 */               group1.addAction((Action)Actions.forever(
/* 1092 */                     (Action)Actions.sequence(
/* 1093 */                       (Action)Actions.delay(0.75F), 
/* 1094 */                       (Action)Actions.run(() -> {
/*      */                           paramArrayOfint[0] = paramArrayOfint[0] + 1;
/*      */                           
/*      */                           if (paramArrayOfint[0] == paramArray.size) {
/*      */                             paramArrayOfint[0] = 0;
/*      */                           }
/*      */                           
/*      */                           paramGroup.clearChildren();
/*      */                           
/*      */                           paramGroup.addActor((Actor)paramArray.get(paramArrayOfint[0]));
/*      */                         }))));
/*      */             } 
/*      */             
/* 1107 */             int j = ingredient.getCountWithGVs();
/*      */             
/*      */             Label label1;
/* 1110 */             (label1 = new Label(j, Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 1111 */             label1.setPosition(f + 72.0F - 2.0F, 14.0F);
/* 1112 */             label1.setSize(1.0F, 16.0F);
/* 1113 */             label1.setColor(MaterialColor.BLUE_GREY.P800);
/* 1114 */             group.addActor((Actor)label1);
/*      */             
/*      */             Label label2;
/* 1117 */             (label2 = new Label(j, Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 1118 */             label2.setPosition(f + 72.0F, 12.0F);
/* 1119 */             label2.setSize(1.0F, 16.0F);
/* 1120 */             group.addActor((Actor)label2);
/*      */             
/* 1122 */             if (b1 != 0) {
/*      */               Image image1;
/* 1124 */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-plus"))).setSize(24.0F, 24.0F);
/* 1125 */               image1.setPosition(f - 12.0F, 36.0F);
/* 1126 */               group.addActor((Actor)image1);
/*      */             } 
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*      */           Image image;
/*      */ 
/*      */ 
/*      */           
/* 1136 */           (image = new Image((Drawable)new QuadDrawable(new QuadActor(Color.WHITE, new float[] { 0.0F, 0.0F, 0.0F, 13.0F, 19.0F, 13.0F, 19.0F, 13.0F })))).setColor(MaterialColor.BLUE_GREY.P900);
/* 1137 */           image.getColor().lerp(Color.BLACK, 0.5F);
/* 1138 */           table2.add((Actor)image).size(19.0F, 13.0F).padLeft(326.0F).padTop(125.0F).left().row();
/*      */         }
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1144 */         G.clear();
/* 1145 */         if (this.z.getItem().canBeSold()) {
/* 1146 */           this.z.getItem().addSellItems(G);
/*      */         }
/* 1148 */         if (G.size != 0) {
/* 1149 */           int j = 0; int k;
/* 1150 */           for (k = 0; k < G.size; k++) {
/* 1151 */             if (((ItemStack[])G.items)[k].getCount() > j) {
/* 1152 */               j = ((ItemStack[])G.items)[k].getCount();
/*      */             }
/*      */           } 
/* 1155 */           k = j;
/* 1156 */           ComplexButton complexButton = a(Game.i.localeManager.i18n.get("sell_button"), (Drawable)Game.i.assetManager.getDrawable("icon-dollar"), MaterialColor.RED.values, () -> { if (Game.i.progressManager.isStarred(this.z.getItem())) { Dialog.i().showAlert(Game.i.localeManager.i18n.get("starred_item_cant_be_sold")); return; }  int i = this.z.getCount(); paramInt = 500000000 / paramInt; if (i > paramInt) i = paramInt;  ItemCountSelectionOverlay.i().show(Game.i.localeManager.i18n.get("sell_button") + " - " + this.z.getItem().getTitle(), 1, i, this.z.getItem(), this.D); Table table; (table = ItemCountSelectionOverlay.i().getInfoContainer()).clear(); this.E.clear(); for (i = 0; i < G.size; i++) { ItemStack itemStack = ((ItemStack[])G.items)[i]; table.add(itemStack.getItem().generateIcon(32.0F, false)).size(32.0F).padLeft(8.0F); Label label = new Label("0", Game.i.assetManager.getLabelStyle(24)); table.add((Actor)label).padLeft(6.0F).padRight(8.0F); this.E.add(label); }  e(); }null, table1, table2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1185 */           if (Game.i.progressManager.isStarred(this.z.getItem())) {
/* 1186 */             complexButton.setBackgroundColors(MaterialColor.GREY.P800, MaterialColor.GREY.P900, MaterialColor.GREY.P700, MaterialColor.GREY.P800);
/*      */           }
/*      */           
/* 1189 */           Table table = new Table();
/* 1190 */           for (byte b = 0; b < G.size; ) {
/* 1191 */             ItemStack itemStack = ((ItemStack[])G.items)[b];
/*      */             
/*      */             Table table3;
/* 1194 */             (table3 = new Table()).add(itemStack.getItem().generateIcon(24.0F, false)).size(24.0F).padRight(6.0F).padLeft(8.0F);
/*      */             
/* 1196 */             Label label = new Label(itemStack.getCount(), Game.i.assetManager.getLabelStyle(21));
/* 1197 */             table3.add((Actor)label).padRight(8.0F);
/*      */             
/* 1199 */             table.add((Actor)table3);
/*      */             
/* 1201 */             if (b != 2) {
/*      */               b++;
/*      */             }
/*      */           } 
/* 1205 */           if (G.size > 3) {
/* 1206 */             Label label = new Label("+", Game.i.assetManager.getLabelStyle(24));
/* 1207 */             table.add((Actor)label).padRight(8.0F);
/*      */           } 
/*      */           
/* 1210 */           table1.add((Actor)table).padBottom(8.0F).padTop(8.0F).height(24.0F).row();
/* 1211 */           table2.add().width(1.0F).height(40.0F).row();
/*      */         } 
/*      */ 
/*      */         
/* 1215 */         if (this.z.getItem().canBeUnpacked()) {
/* 1216 */           Runnable runnable = null;
/* 1217 */           if (this.z.getCount() > 1) {
/* 1218 */             runnable = (() -> {
/*      */                 int i = 200;
/*      */                 if (this.z.getItem() instanceof com.prineside.tdi2.items.RandomTileItem || this.z.getItem() instanceof com.prineside.tdi2.items.RandomBarrierItem) {
/*      */                   i = 2000;
/*      */                 }
/*      */                 i = Math.min(i, this.z.getCount());
/*      */                 ItemCountSelectionOverlay.i().show(Game.i.localeManager.i18n.get("open_pack_button"), 1, i, this.z.getItem(), new ItemCountSelectionOverlay.ItemCountSelectionListener(this)
/*      */                     {
/*      */                       public void countChanged(int param1Int) {}
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*      */                       public void selectionConfirmed(int param1Int) {
/* 1232 */                         if (InventoryOverlay.b(this.a) != null) {
/* 1233 */                           Game.i.progressManager.openPack(InventoryOverlay.b(this.a).getItem(), param1Int, true, false);
/*      */                         }
/* 1235 */                         this.a.update();
/* 1236 */                         InventoryOverlay.c(this.a);
/*      */                       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*      */                       public void selectionCanceled() {}
/*      */                     });
/*      */                 ItemCountSelectionOverlay.i().setSelectedCount(i);
/*      */               });
/*      */           }
/* 1248 */           a(Game.i.localeManager.i18n.get("open_pack_button"), (Drawable)Game.i.assetManager.getDrawable("icon-eye"), MaterialColor.GREEN.values, () -> { Game.i.progressManager.openPack(this.z.getItem(), 1, true, false); update(); k(); }runnable, table1, table2);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1256 */         if (this.z.getItem().getType() == ItemType.LUCKY_SHOT_TOKEN) {
/* 1257 */           a(Game.i.localeManager.i18n.get("lucky_shot"), (Drawable)Game.i.assetManager.getDrawable("icon-lucky-wheel"), MaterialColor.GREEN.values, () -> { hideWithToggleButton(true); LuckyWheelOverlay.i().setVisible(true); }null, table1, table2);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1264 */         if (this.z.getItem() instanceof Item.UsableItem) {
/* 1265 */           Item.UsableItem usableItem = (Item.UsableItem)this.z.getItem();
/*      */           
/* 1267 */           a(Game.i.localeManager.i18n.get("use_item_button"), (Drawable)Game.i.assetManager.getDrawable("icon-check"), MaterialColor.LIGHT_BLUE.values, () -> { if (paramUsableItem.useItemNeedsConfirmation()) { Dialog.i().showConfirm(Game.i.localeManager.i18n.get("dialog_confirm_item_usage"), ()); return; }  paramUsableItem.useItem(); update(); }null, table1, table2);
/*      */         } 
/*      */       } 
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
/* 1283 */     if (item != null) {
/* 1284 */       if (!bool1) {
/*      */         Actor actor;
/* 1286 */         (actor = item.generateIcon(128.0F, true)).setPosition(107.0F, 692.0F + i);
/* 1287 */         this.h.addActor(actor);
/*      */         
/* 1289 */         Item item1 = item;
/*      */ 
/*      */         
/*      */         PaddedImageButton paddedImageButton;
/*      */         
/* 1294 */         (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-star"), () -> { Game.i.progressManager.setStarred(paramItem, !Game.i.progressManager.isStarred(paramItem)); update(); }Color.WHITE, Color.WHITE, Color.WHITE)).setIconSize(40.0F, 40.0F);
/* 1295 */         paddedImageButton.setIconPosition(8.0F, 8.0F);
/* 1296 */         paddedImageButton.setSize(56.0F, 56.0F);
/* 1297 */         paddedImageButton.setPosition(260.0F, 692.0F + i + 128.0F - 32.0F);
/* 1298 */         this.h.addActor((Actor)paddedImageButton);
/*      */         
/* 1300 */         if (Game.i.progressManager.isStarred(item)) {
/* 1301 */           paddedImageButton.setColors(MaterialColor.YELLOW.P500, MaterialColor.YELLOW.P200, MaterialColor.YELLOW.P700);
/*      */         } else {
/* 1303 */           paddedImageButton.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-star-hollow"));
/* 1304 */           paddedImageButton.setColors(new Color(1.0F, 1.0F, 1.0F, 0.28F), MaterialColor.YELLOW.P200, MaterialColor.YELLOW.P700);
/*      */         } 
/*      */       } 
/*      */       
/* 1308 */       if (Game.i.progressManager.isDeveloperModeEnabled() && this.z != null) {
/*      */         Image image;
/* 1310 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-edit"))).setSize(48.0F, 48.0F);
/* 1311 */         image.setColor(MaterialColor.LIGHT_BLUE.P500);
/* 1312 */         image.setTouchable(Touchable.enabled);
/* 1313 */         image.setPosition(32.0F, 788.0F + i);
/* 1314 */         image.addListener((EventListener)new ClickListener(this)
/*      */             {
/*      */               public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 1317 */                 this.a.hideWithToggleButton(true);
/* 1318 */                 ItemCreationOverlay.i().showForItem(InventoryOverlay.b(this.a).getItem());
/*      */               }
/*      */             });
/* 1321 */         this.h.addActor((Actor)image);
/*      */       } 
/*      */       
/* 1324 */       if (!bool1) {
/* 1325 */         RarityType rarityType = item.getRarity();
/*      */         
/*      */         Label label1;
/* 1328 */         (label1 = new Label(item.getTitle(), Game.i.assetManager.getLabelStyle(30))).setAlignment(1);
/* 1329 */         label1.setPosition(108.0F, 632.0F + i);
/* 1330 */         label1.setSize(128.0F, 32.0F);
/* 1331 */         label1.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/* 1332 */         this.h.addActor((Actor)label1);
/*      */         
/*      */         Label label2;
/* 1335 */         (label2 = new Label(item.getTitle(), Game.i.assetManager.getLabelStyle(30))).setAlignment(1);
/* 1336 */         label2.setPosition(107.0F, 635.0F + i);
/* 1337 */         label2.setSize(128.0F, 32.0F);
/* 1338 */         label2.setColor(Game.i.progressManager.getRarityBrightColor(rarityType));
/* 1339 */         this.h.addActor((Actor)label2);
/*      */         
/*      */         Label label3;
/* 1342 */         (label3 = new Label(Game.i.progressManager.getRarityName(rarityType).toUpperCase(), Game.i.assetManager.getLabelStyle(21))).setAlignment(1);
/* 1343 */         label3.setPosition(107.0F, 613.0F + i);
/* 1344 */         label3.setSize(128.0F, 16.0F);
/* 1345 */         label3.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1346 */         this.h.addActor((Actor)label3);
/*      */         
/*      */         Label label4;
/* 1349 */         (label4 = new Label(item.getDescription(), Game.i.assetManager.getLabelStyle(24))).setPosition(21.0F, 535.0F + i);
/* 1350 */         label4.setSize(300.0F, 64.0F);
/* 1351 */         label4.setWrap(true);
/* 1352 */         label4.setAlignment(2);
/* 1353 */         this.h.addActor((Actor)label4);
/*      */       } 
/*      */       
/*      */       Table table;
/* 1357 */       (table = new Table()).add().height(8.0F).width(300.0F).row();
/* 1358 */       item.fillWithInfo(table, 300.0F);
/* 1359 */       table.row();
/* 1360 */       table.add().expandY().fillY().padBottom(120.0F);
/*      */       
/*      */       ScrollPane scrollPane;
/* 1363 */       UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)table, Game.i.assetManager.getScrollPaneStyle(8.0F)));
/* 1364 */       scrollPane.setPosition(21.0F, 124.0F);
/* 1365 */       scrollPane.setSize(300.0F, 380.0F + i);
/* 1366 */       scrollPane.setScrollingDisabled(true, false);
/* 1367 */       this.h.addActor((Actor)scrollPane);
/*      */ 
/*      */     
/*      */     }
/* 1371 */     else if (bool2) {
/*      */       Label label;
/* 1373 */       (label = new Label(Game.i.localeManager.i18n.get("inventory_no_item_selected_hint"), Game.i.assetManager.getLabelStyle(21))).setSize(282.0F, 860.0F + i);
/* 1374 */       label.setAlignment(1);
/* 1375 */       label.setWrap(true);
/* 1376 */       label.setPosition(30.0F, 0.0F);
/* 1377 */       this.h.addActor((Actor)label);
/*      */     } 
/*      */ 
/*      */     
/* 1381 */     table1.setZIndex(9001);
/*      */   }
/*      */   
/*      */   public final void setSelectedItem(ItemStack paramItemStack) {
/* 1385 */     if (this.z != null) {
/*      */       ItemCell itemCell;
/*      */       
/* 1388 */       if ((itemCell = (ItemCell)this.p.get(this.z, null)) != null) {
/* 1389 */         itemCell.setSelected(false);
/*      */       }
/* 1391 */       this.z = null;
/*      */     } 
/*      */     
/* 1394 */     this.z = paramItemStack;
/*      */     
/* 1396 */     if (paramItemStack != null) {
/*      */       ItemCell itemCell;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1407 */       if ((itemCell = (ItemCell)this.p.get(paramItemStack, null)) != null) {
/* 1408 */         itemCell.setSelected(true);
/*      */       }
/*      */     } 
/*      */     
/* 1412 */     j();
/*      */   }
/*      */   
/*      */   public final void update() {
/* 1416 */     updateAndScroll((this.k == null) ? -1.0F : this.k.getScrollY());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void k() {
/* 1423 */     if (this.z != null && 
/* 1424 */       Game.i.progressManager.getItemsCount(this.z.getItem()) == 0) {
/* 1425 */       setSelectedItem(null);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void l() {
/* 1431 */     this.g.clearChildren();
/* 1432 */     this.t.clear();
/* 1433 */     this.i.clearChildren();
/* 1434 */     this.p.clear();
/*      */     
/* 1436 */     this.h.clearChildren();
/* 1437 */     this.n.clearChildren();
/*      */     
/* 1439 */     if (this.k != null) {
/* 1440 */       if (Game.i.uiManager.stage.getScrollFocus() == this.k) {
/* 1441 */         Game.i.uiManager.stage.setScrollFocus(null);
/*      */       }
/* 1443 */       this.k.remove();
/*      */     } 
/* 1445 */     this.k = null; } public final void updateAndScroll(float paramFloat) { Table table1, table2; Image image1, image2; float f1, f2; Array<SubcategoryItems> array1, array2; byte b1, b2;
/*      */     float f3;
/*      */     byte b3;
/*      */     float f4;
/* 1449 */     h();
/*      */     
/* 1451 */     int i = Game.i.settingsManager.getScaledViewportHeight() - 1080;
/*      */     
/* 1453 */     l();
/*      */     
/* 1455 */     switch (null.a[this.w.ordinal()]) {
/*      */ 
/*      */ 
/*      */       
/*      */       case 1:
/* 1460 */         table2 = new Table();
/* 1461 */         this.k = new ScrollPane((Actor)table2);
/* 1462 */         UiUtils.enableMouseMoveScrollFocus(this.k);
/* 1463 */         this.k.setName("Inventory itemsScroll");
/* 1464 */         this.k.setSize(862.0F, 832.0F + i);
/* 1465 */         this.g.addActor((Actor)this.k);
/*      */         
/* 1467 */         Game.i.uiManager.stage.setScrollFocus((Actor)this.k);
/*      */ 
/*      */         
/* 1470 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(new Color(791621631));
/* 1471 */         image2.setSize(862.0F, 24.0F);
/* 1472 */         image2.setPosition(0.0F, 809.0F + i);
/* 1473 */         image2.setTouchable(Touchable.disabled);
/* 1474 */         this.g.addActor((Actor)image2);
/*      */ 
/*      */         
/* 1477 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(new Color(791621631));
/* 1478 */         image2.setSize(478.0F, 96.0F);
/* 1479 */         image2.setPosition(0.0F, -1.0F);
/* 1480 */         image2.setTouchable(Touchable.disabled);
/* 1481 */         this.g.addActor((Actor)image2);
/*      */         
/* 1483 */         table2.add().colspan(6).height(16.0F).row();
/* 1484 */         f2 = 16.0F;
/*      */ 
/*      */         
/* 1487 */         array2 = m();
/* 1488 */         b2 = 0;
/* 1489 */         for (b3 = 0; b3 < array2.size; b3++) {
/* 1490 */           SubcategoryItems subcategoryItems = ((SubcategoryItems[])array2.items)[b3];
/*      */ 
/*      */           
/* 1493 */           float f = f2 + 30.0F;
/* 1494 */           TextureRegionDrawable textureRegionDrawable = Game.i.assetManager.getDrawable(subcategoryItems.getIconAlias());
/*      */           PaddedImageButton paddedImageButton;
/* 1496 */           (paddedImageButton = new PaddedImageButton((Drawable)textureRegionDrawable, () -> this.k.setScrollY(paramFloat - 40.0F), subcategoryItems.getColor(), Color.WHITE, subcategoryItems.getColor())).setIconSize(48.0F, 48.0F);
/* 1497 */           paddedImageButton.setIconPosition(16.0F, 8.0F);
/* 1498 */           paddedImageButton.setShadow((Drawable)textureRegionDrawable, 19.0F, 5.0F, 48.0F, 48.0F, new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 1499 */           paddedImageButton.setSize(80.0F, 64.0F);
/* 1500 */           this.i.addActor((Actor)paddedImageButton);
/*      */           
/*      */           SubcategoryButtonConfig subcategoryButtonConfig;
/* 1503 */           (subcategoryButtonConfig = new SubcategoryButtonConfig((byte)0)).distanceY = f;
/* 1504 */           subcategoryButtonConfig.button = paddedImageButton;
/* 1505 */           this.t.add(subcategoryButtonConfig);
/*      */           
/*      */           Label label;
/*      */           
/* 1509 */           (label = new Label(subcategoryItems.getTitle(), Game.i.assetManager.getLabelStyle(30))).setColor(subcategoryItems.getColor());
/*      */           
/* 1511 */           table2.add((Actor)label).height(52.0F).width(768.0F).padTop(8.0F).colspan(6).row();
/*      */           
/* 1513 */           f2 += 60.0F;
/*      */           
/* 1515 */           int j = MathUtils.ceil(subcategoryItems.items.size / 6.0F);
/* 1516 */           for (byte b = 0; b < j * 6; b++) {
/*      */             ItemCell itemCell;
/* 1518 */             (itemCell = new ItemCell()).setColRow(b % 6, b2);
/*      */             
/* 1520 */             if (b < subcategoryItems.items.size) {
/* 1521 */               ItemStack itemStack = ((ItemStack[])subcategoryItems.items.items)[b];
/* 1522 */               this.p.put(itemStack, itemCell);
/* 1523 */               itemCell.setItem(itemStack.getItem(), 0);
/*      */               
/* 1525 */               if (Game.i.progressManager.isStarred(itemStack.getItem())) {
/* 1526 */                 itemCell.markStarred(true);
/*      */               }
/*      */               
/* 1529 */               if (itemStack.covered)
/*      */               {
/* 1531 */                 itemCell.setColor(1.0F, 1.0F, 1.0F, 0.44F);
/*      */               }
/*      */               
/* 1534 */               if (this.z != null && itemStack.getItem().sameAs(this.z.getItem())) {
/* 1535 */                 itemCell.setSelected(true);
/* 1536 */                 this.z = itemStack;
/*      */               } 
/*      */               
/* 1539 */               itemCell.addListener((EventListener)new ClickListener(this, itemStack)
/*      */                   {
/*      */                     public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 1542 */                       this.b.setSelectedItem(this.a);
/*      */                     }
/*      */                   });
/*      */             } 
/*      */             
/* 1547 */             Cell cell = table2.add((Actor)itemCell);
/* 1548 */             if ((b + 1) % 6 == 0) {
/* 1549 */               b2++;
/* 1550 */               cell.row();
/*      */             } 
/*      */           } 
/*      */           
/* 1554 */           f2 += j * 140.0F;
/*      */         } 
/*      */         
/* 1557 */         table2.row();
/*      */ 
/*      */         
/* 1560 */         if ((f4 = 832.0F + i - f2) < 0.0F) f4 = 0.0F; 
/* 1561 */         table2.add().colspan(6).height(f4 + 128.0F);
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1567 */         table1 = new Table();
/* 1568 */         this.k = new ScrollPane((Actor)table1);
/* 1569 */         UiUtils.enableMouseMoveScrollFocus(this.k);
/* 1570 */         this.k.setName("Inventory itemsScroll");
/* 1571 */         this.k.setSize(862.0F, 832.0F + i);
/* 1572 */         this.g.addActor((Actor)this.k);
/*      */         
/* 1574 */         Game.i.uiManager.stage.setScrollFocus((Actor)this.k);
/*      */ 
/*      */         
/* 1577 */         (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(new Color(791621631));
/* 1578 */         image1.setSize(862.0F, 24.0F);
/* 1579 */         image1.setPosition(0.0F, 809.0F + i);
/* 1580 */         image1.setTouchable(Touchable.disabled);
/* 1581 */         this.g.addActor((Actor)image1);
/*      */ 
/*      */         
/* 1584 */         (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(new Color(791621631));
/* 1585 */         image2.setSize(862.0F, 96.0F);
/* 1586 */         image2.setPosition(0.0F, -1.0F);
/* 1587 */         image2.setTouchable(Touchable.disabled);
/* 1588 */         this.g.addActor((Actor)image2);
/*      */         
/* 1590 */         table1.add().colspan(6).height(16.0F).row();
/* 1591 */         f1 = 16.0F;
/*      */ 
/*      */         
/* 1594 */         array1 = m();
/* 1595 */         b1 = 0;
/* 1596 */         for (b2 = 0; b2 < array1.size; b2++) {
/*      */           SubcategoryItems subcategoryItems;
/*      */           
/* 1599 */           if ((subcategoryItems = ((SubcategoryItems[])array1.items)[b2]).subcategoryType != ItemSubcategoryType.P_ENCRYPTED || subcategoryItems.items.size != 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1605 */             float f = f1 + 30.0F;
/* 1606 */             TextureRegionDrawable textureRegionDrawable = Game.i.assetManager.getDrawable(subcategoryItems.getIconAlias());
/*      */             PaddedImageButton paddedImageButton;
/* 1608 */             (paddedImageButton = new PaddedImageButton((Drawable)textureRegionDrawable, () -> this.k.setScrollY(paramFloat - 40.0F), subcategoryItems.getColor(), Color.WHITE, subcategoryItems.getColor())).setIconSize(48.0F, 48.0F);
/* 1609 */             paddedImageButton.setIconPosition(16.0F, 8.0F);
/* 1610 */             paddedImageButton.setShadow((Drawable)textureRegionDrawable, 19.0F, 5.0F, 48.0F, 48.0F, new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 1611 */             paddedImageButton.setSize(80.0F, 64.0F);
/* 1612 */             this.i.addActor((Actor)paddedImageButton);
/*      */             
/*      */             SubcategoryButtonConfig subcategoryButtonConfig;
/* 1615 */             (subcategoryButtonConfig = new SubcategoryButtonConfig((byte)0)).distanceY = f;
/* 1616 */             subcategoryButtonConfig.button = paddedImageButton;
/* 1617 */             this.t.add(subcategoryButtonConfig);
/*      */             
/*      */             Label label;
/*      */             
/* 1621 */             (label = new Label(subcategoryItems.getTitle(), Game.i.assetManager.getLabelStyle(30))).setColor(subcategoryItems.getColor());
/*      */             
/* 1623 */             table1.add((Actor)label).height(52.0F).width(768.0F).padTop(8.0F).colspan(6).row();
/*      */             
/* 1625 */             f1 += 60.0F;
/*      */             
/* 1627 */             int j = MathUtils.ceil(subcategoryItems.items.size / 6.0F);
/* 1628 */             for (byte b = 0; b < j * 6; b++) {
/*      */               ItemCell itemCell;
/* 1630 */               (itemCell = new ItemCell()).setColRow(b % 6, b1);
/*      */               
/* 1632 */               if (b < subcategoryItems.items.size) {
/* 1633 */                 ItemStack itemStack = ((ItemStack[])subcategoryItems.items.items)[b];
/* 1634 */                 this.p.put(itemStack, itemCell);
/* 1635 */                 itemCell.setItemStack(itemStack);
/*      */                 
/* 1637 */                 if (Game.i.progressManager.isStarred(itemStack.getItem())) {
/* 1638 */                   itemCell.markStarred(true);
/*      */                 }
/*      */                 
/* 1641 */                 if (itemStack.getItem().getType() == ItemType.CASE) {
/* 1642 */                   itemCell.setNotificationBubbleEnabled(true);
/* 1643 */                 } else if (itemStack.getItem() instanceof com.prineside.tdi2.items.CaseKeyItem && itemStack.getCount() >= 10) {
/* 1644 */                   itemCell.setNotificationBubbleEnabled(true);
/*      */                 } 
/*      */                 
/* 1647 */                 itemCell.addListener((EventListener)new InputListener(this, itemStack, itemCell)
/*      */                     {
/*      */                       private Timer.Task c;
/*      */                       private float d;
/*      */                       private float e;
/*      */                       
/*      */                       public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 1654 */                         if (param1Int1 > 0) return false;
/*      */                         
/* 1656 */                         if (param1Int2 == 0) {
/* 1657 */                           this.d = param1Float1;
/* 1658 */                           this.e = param1Float2;
/*      */                           
/* 1660 */                           if (InventoryOverlay.f(this.b)) {
/* 1661 */                             this.c = null;
/*      */                           } else {
/* 1663 */                             this.c = new Timer.Task(this)
/*      */                               {
/*      */                                 public void run()
/*      */                                 {
/* 1667 */                                   InventoryOverlay.a(this.a.b, this.a.a);
/*      */ 
/*      */                                   
/* 1670 */                                   InventoryOverlay.null.a(this.a, -100.0F);
/* 1671 */                                   InventoryOverlay.null.b(this.a, -100.0F);
/*      */                                   
/* 1673 */                                   if (InventoryOverlay.g(this.a.b) != null) {
/*      */                                     
/* 1675 */                                     (InventoryOverlay.g(this.a.b)).disappearing = true;
/* 1676 */                                     InventoryOverlay.a(this.a.b, (ButtonHoldHint)null);
/*      */                                   } 
/*      */                                 }
/*      */                               };
/* 1680 */                             Timer.schedule(this.c, 0.75F);
/*      */ 
/*      */                             
/* 1683 */                             InventoryOverlay.a(this.b, new ButtonHoldHint(param1Float1, param1Float2, 0.75F));
/* 1684 */                             this.f.addActor((Actor)InventoryOverlay.g(this.b));
/*      */                           } 
/* 1686 */                         } else if (param1Int2 == 1) {
/*      */                           
/* 1688 */                           if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.INSTANT_HOLD_BUTTON_ON_RMB) == 1.0D) {
/* 1689 */                             if (InventoryOverlay.f(this.b)) {
/* 1690 */                               this.c = null;
/*      */                             } else {
/* 1692 */                               if (this.c != null && this.c.isScheduled()) {
/* 1693 */                                 this.c.cancel();
/*      */                               }
/* 1695 */                               InventoryOverlay.a(this.b, this.a);
/*      */ 
/*      */                               
/* 1698 */                               this.d = -100.0F;
/* 1699 */                               this.e = -100.0F;
/*      */                               
/* 1701 */                               if (InventoryOverlay.g(this.b) != null) {
/*      */                                 
/* 1703 */                                 (InventoryOverlay.g(this.b)).disappearing = true;
/* 1704 */                                 InventoryOverlay.a(this.b, (ButtonHoldHint)null);
/*      */                               } 
/*      */                             } 
/*      */                           }
/*      */                         } 
/*      */                         
/* 1710 */                         return true;
/*      */                       }
/*      */ 
/*      */                       
/*      */                       public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 1715 */                         super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*      */                         
/* 1717 */                         if (InventoryOverlay.g(this.b) != null) {
/* 1718 */                           ButtonHoldHint buttonHoldHint = InventoryOverlay.g(this.b);
/* 1719 */                           Objects.requireNonNull(buttonHoldHint); Threads.i().postRunnable(buttonHoldHint::remove);
/* 1720 */                           InventoryOverlay.a(this.b, (ButtonHoldHint)null);
/*      */                         } 
/*      */                         
/*      */                         float f;
/* 1724 */                         if ((f = PMath.getDistanceBetweenPoints(param1Float1, param1Float2, this.d, this.e)) > 16.0F) {
/* 1725 */                           if (this.c != null) {
/*      */                             
/* 1727 */                             this.c.cancel();
/* 1728 */                             this.c = null;
/*      */                           } 
/*      */                           
/*      */                           return;
/*      */                         } 
/* 1733 */                         if (InventoryOverlay.f(this.b)) {
/* 1734 */                           InventoryOverlay.a(this.b, this.a);
/*      */                           
/*      */                           return;
/*      */                         } 
/* 1738 */                         if (this.c != null) {
/*      */                           
/* 1740 */                           this.c.cancel();
/* 1741 */                           this.c = null;
/* 1742 */                           this.b.setSelectedItem(this.a);
/*      */                         } 
/*      */                       }
/*      */                     });
/*      */               } 
/*      */               
/* 1748 */               Cell cell = table1.add((Actor)itemCell);
/* 1749 */               if ((b + 1) % 6 == 0) {
/* 1750 */                 b1++;
/* 1751 */                 cell.row();
/*      */               } 
/*      */             } 
/*      */             
/* 1755 */             f1 += j * 140.0F;
/*      */           } 
/*      */         } 
/* 1758 */         table1.row();
/*      */ 
/*      */         
/* 1761 */         if ((f3 = 832.0F - f1 + i) < 0.0F) f3 = 0.0F; 
/* 1762 */         table1.add().colspan(6).height(f3 + 128.0F);
/*      */         break;
/*      */     } 
/*      */     
/* 1766 */     if (this.p.size > 2000)
/*      */     {
/* 1768 */       if (!this.s) {
/* 1769 */         String str = Game.i.localeManager.i18n.get("too_many_items_sell_advise");
/* 1770 */         Notifications.i().add(str, (Drawable)Game.i.assetManager.getDrawable("icon-trash-bin-dollar"), MaterialColor.DEEP_ORANGE.P800, StaticSoundType.WARNING);
/* 1771 */         this.s = true;
/*      */       } 
/*      */     }
/*      */     
/* 1775 */     g();
/*      */     
/* 1777 */     if (b()) {
/* 1778 */       for (byte b = 0; b < this.A.size; b++) {
/* 1779 */         ItemStack itemStack = ((ItemStack[])this.A.items)[b];
/*      */         ItemCell itemCell;
/* 1781 */         if ((itemCell = (ItemCell)this.p.get(itemStack, null)) != null) {
/* 1782 */           itemCell.setSelected(true);
/*      */         }
/*      */       }
/*      */     
/* 1786 */     } else if (this.z != null) {
/* 1787 */       setSelectedItem(this.z);
/*      */     } 
/*      */ 
/*      */     
/* 1791 */     this.k.layout();
/* 1792 */     if (paramFloat != -1.0F && this.k != null) {
/* 1793 */       this.k.setScrollY(paramFloat);
/* 1794 */       this.k.updateVisualScroll();
/*      */     } 
/*      */     
/* 1797 */     j(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Array<SubcategoryItems> m() {
/* 1805 */     Array<SubcategoryItems> array = new Array(SubcategoryItems.class);
/* 1806 */     TabConfig tabConfig = u[this.w.ordinal()];
/*      */     
/* 1808 */     if (this.w == TabType.CRAFTING) {
/*      */       
/* 1810 */       this.B.clear();
/* 1811 */       for (byte b = 0; b < Game.i.itemManager.craftRecipes.size; b++) {
/*      */         CraftRecipe craftRecipe;
/* 1813 */         if ((craftRecipe = ((CraftRecipe[])Game.i.itemManager.craftRecipes.items)[b]).isAvailable()) {
/*      */           
/* 1815 */           boolean bool = craftRecipe.hasEnoughItemsToRun();
/*      */           
/* 1817 */           Item item = craftRecipe.result.getItem();
/* 1818 */           boolean bool1 = false;
/* 1819 */           for (byte b1 = 0; b1 < this.B.size; b1++) {
/*      */             ItemStack itemStack;
/* 1821 */             if ((itemStack = ((ItemStack[])this.B.items)[b1]).getItem().sameAs(item)) {
/*      */               
/* 1823 */               bool1 = true;
/* 1824 */               itemStack.setCount(((ItemStack[])this.B.items)[b1].getCount() + 1);
/* 1825 */               if (bool && itemStack.covered) {
/* 1826 */                 itemStack.covered = false;
/*      */               }
/*      */               break;
/*      */             } 
/*      */           } 
/* 1831 */           if (!bool1) {
/*      */             ItemStack itemStack;
/*      */             
/* 1834 */             (itemStack = new ItemStack(item, 1)).covered = !bool;
/* 1835 */             this.B.add(itemStack);
/*      */           } 
/*      */         } 
/*      */       } 
/* 1839 */       if (this.y == ItemSortingType.RARITY) {
/*      */         
/* 1841 */         this.B.sort(ItemStack.SORT_COMPARATOR_RARITY_DESC);
/*      */         
/* 1843 */         RarityType rarityType = null;
/* 1844 */         SubcategoryItems subcategoryItems = null;
/*      */         byte b1;
/* 1846 */         for (b1 = 0; b1 < this.B.size; b1++) {
/*      */           SubcategoryItems subcategoryItems1;
/*      */           
/*      */           ItemStack itemStack;
/*      */           RarityType rarityType1;
/* 1851 */           if ((rarityType1 = (itemStack = ((ItemStack[])this.B.items)[b1]).getItem().getRarity()) != rarityType) {
/*      */             
/* 1853 */             (subcategoryItems1 = new SubcategoryItems((byte)0)).rarityType = rarityType1;
/* 1854 */             array.add(subcategoryItems1);
/*      */             
/* 1856 */             rarityType = rarityType1;
/* 1857 */             subcategoryItems = subcategoryItems1;
/*      */           } else {
/* 1859 */             subcategoryItems1 = subcategoryItems;
/*      */           } 
/*      */ 
/*      */           
/* 1863 */           subcategoryItems1.items.add(itemStack);
/*      */         } 
/* 1865 */         for (b1 = 0; b1 < array.size; b1++)
/* 1866 */           (((SubcategoryItems[])array.items)[b1]).items.sort(ItemStack.SORT_COMPARATOR_KIND); 
/*      */       } else {
/*      */         ItemSubcategoryType[] arrayOfItemSubcategoryType; int i;
/*      */         byte b1;
/* 1870 */         for (i = (arrayOfItemSubcategoryType = tabConfig.subcategories).length, b1 = 0; b1 < i; ) { ItemSubcategoryType itemSubcategoryType = arrayOfItemSubcategoryType[b1];
/*      */           SubcategoryItems subcategoryItems;
/* 1872 */           (subcategoryItems = new SubcategoryItems((byte)0)).subcategoryType = itemSubcategoryType;
/*      */           
/* 1874 */           for (byte b2 = 0; b2 < this.B.size; b2++) {
/*      */             ItemStack itemStack;
/* 1876 */             if ((itemStack = ((ItemStack[])this.B.items)[b2]).getItem().getSubcategory() == itemSubcategoryType) {
/* 1877 */               subcategoryItems.items.add(itemStack);
/*      */             }
/*      */           } 
/* 1880 */           if (subcategoryItems.items.size != 0) {
/* 1881 */             subcategoryItems.items.sort(ItemStack.SORT_COMPARATOR_RARITY_DESC);
/* 1882 */             array.add(subcategoryItems);
/*      */           } 
/*      */           
/*      */           b1++; }
/*      */       
/*      */       } 
/* 1888 */     } else if (this.y == ItemSortingType.KIND) {
/* 1889 */       ItemSubcategoryType[] arrayOfItemSubcategoryType; int i; byte b; for (i = (arrayOfItemSubcategoryType = tabConfig.subcategories).length, b = 0; b < i; ) { ItemSubcategoryType itemSubcategoryType = arrayOfItemSubcategoryType[b];
/*      */         SubcategoryItems subcategoryItems;
/* 1891 */         (subcategoryItems = new SubcategoryItems((byte)0)).subcategoryType = itemSubcategoryType;
/*      */         
/* 1893 */         subcategoryItems.items.addAll((Array)Game.i.progressManager.getItemsBySubcategory(itemSubcategoryType));
/* 1894 */         subcategoryItems.items.sort(ItemStack.SORT_COMPARATOR_RARITY_DESC);
/* 1895 */         array.add(subcategoryItems); b++; }
/*      */     
/* 1897 */     } else if (this.y == ItemSortingType.RARITY) {
/* 1898 */       this.B.clear(); ItemSubcategoryType[] arrayOfItemSubcategoryType; byte b;
/* 1899 */       for (int i = (arrayOfItemSubcategoryType = tabConfig.subcategories).length; b < i; ) { ItemSubcategoryType itemSubcategoryType = arrayOfItemSubcategoryType[b];
/* 1900 */         this.B.addAll((Array)Game.i.progressManager.getItemsBySubcategory(itemSubcategoryType)); b++; }
/*      */       
/* 1902 */       this.B.sort(ItemStack.SORT_COMPARATOR_RARITY_DESC);
/*      */       
/* 1904 */       arrayOfItemSubcategoryType = null;
/* 1905 */       SubcategoryItems subcategoryItems = null;
/*      */       
/* 1907 */       for (b = 0; b < this.B.size; b++) {
/*      */         SubcategoryItems subcategoryItems1;
/*      */         
/*      */         ItemStack itemStack;
/*      */         RarityType rarityType;
/* 1912 */         if ((rarityType = (itemStack = ((ItemStack[])this.B.items)[b]).getItem().getRarity()) != arrayOfItemSubcategoryType) {
/*      */           
/* 1914 */           (subcategoryItems1 = new SubcategoryItems((byte)0)).rarityType = rarityType;
/* 1915 */           array.add(subcategoryItems1);
/*      */           
/* 1917 */           RarityType rarityType1 = rarityType;
/* 1918 */           subcategoryItems = subcategoryItems1;
/*      */         } else {
/* 1920 */           subcategoryItems1 = subcategoryItems;
/*      */         } 
/*      */ 
/*      */         
/* 1924 */         subcategoryItems1.items.add(itemStack);
/*      */       } 
/* 1926 */       for (b = 0; b < array.size; b++) {
/* 1927 */         (((SubcategoryItems[])array.items)[b]).items.sort(ItemStack.SORT_COMPARATOR_KIND);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1933 */     return array;
/*      */   }
/*      */   
/*      */   private void a(boolean paramBoolean) {
/* 1937 */     this.d.clearActions();
/*      */     
/* 1939 */     if (paramBoolean) {
/* 1940 */       this.d.addAction((Action)Actions.sequence(
/* 1941 */             (Action)Actions.show(), 
/* 1942 */             (Action)Actions.moveTo(0.0F, 0.0F, 0.15F)));
/*      */ 
/*      */ 
/*      */       
/* 1946 */       if ((Game.i.progressManager.getItemsByType(ItemType.TILE)).size != 0 && !TooltipsOverlay.i().isTagShown("InventoryOverlay.button")) {
/* 1947 */         TooltipsOverlay.i().showText("InventoryOverlay.button", (Actor)this.d.icon, Game.i.localeManager.i18n.get("tooltip_inventory_button"), this.c.mainUiLayer, this.c.zIndex + 1, 16); return;
/*      */       } 
/*      */     } else {
/* 1950 */       this.d.addAction((Action)Actions.sequence(
/* 1951 */             (Action)Actions.moveTo(-212.0F, 0.0F, 0.15F), 
/* 1952 */             (Action)Actions.hide()));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void n() {
/* 1958 */     this.m.setVisible(false);
/*      */     DelayedRemovalArray delayedRemovalArray;
/* 1960 */     if (((Array)(delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.CASE))).size != 0) {
/*      */       
/* 1962 */       this.m.setVisible(true);
/*      */       return;
/*      */     } 
/* 1965 */     delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.CASE_KEY);
/* 1966 */     for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/* 1967 */       if (((ItemStack[])((Array)delayedRemovalArray).items)[b].getCount() >= 10) {
/*      */         
/* 1969 */         this.m.setVisible(true);
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void o() {
/* 1976 */     this.o.setVisible(false);
/*      */     
/*      */     DelayedRemovalArray delayedRemovalArray;
/* 1979 */     if (((Array)(delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.CASE))).size != 0) {
/*      */       
/* 1981 */       this.o.setVisible(true);
/*      */       
/*      */       return;
/*      */     } 
/* 1985 */     delayedRemovalArray = Game.i.progressManager.getItemsByType(ItemType.CASE_KEY);
/* 1986 */     for (byte b = 0; b < ((Array)delayedRemovalArray).size; b++) {
/*      */       ItemStack itemStack;
/* 1988 */       if ((itemStack = (ItemStack)delayedRemovalArray.get(b)).getCount() >= 10) {
/* 1989 */         this.o.setVisible(true);
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void hide() {
/* 1997 */     hideWithToggleButton(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean isPersistent() {
/* 2002 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void preRender(float paramFloat) {
/* 2007 */     if (this.C) {
/* 2008 */       update();
/* 2009 */       this.C = false;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public final void postRender(float paramFloat) {
/* 2015 */     if (this.v) {
/* 2016 */       if (this.k != null && 
/* 2017 */         this.l != this.k.getVisualScrollY()) {
/* 2018 */         g();
/* 2019 */         this.l = this.k.getVisualScrollY();
/*      */       } 
/*      */ 
/*      */       
/* 2023 */       if (Gdx.input.isKeyJustPressed(29)) {
/* 2024 */         d();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2029 */     if (this.v) {
/* 2030 */       o();
/*      */     }
/*      */   }
/*      */   
/*      */   public final void show() {
/* 2035 */     this.v = true;
/*      */     
/* 2037 */     TooltipsOverlay.i().markTagShown("InventoryOverlay.button");
/* 2038 */     TooltipsOverlay.i().hideEntry("InventoryOverlay.button");
/* 2039 */     rebuildLayoutIfRequired();
/*      */     
/* 2041 */     a(false);
/* 2042 */     DarkOverlay.i().addCallerOverlayLayer("InventoryOverlay", this.c.zIndex - 1, () -> {
/*      */           hideWithToggleButton(true);
/*      */           return true;
/*      */         });
/* 2046 */     UiUtils.bouncyShowOverlay(null, (Actor)this.c.getTable(), this.e);
/*      */     
/* 2048 */     update();
/*      */   }
/*      */   
/*      */   public final void hideWithToggleButton(boolean paramBoolean) {
/* 2052 */     DarkOverlay.i().removeCaller("InventoryOverlay");
/* 2053 */     UiUtils.bouncyHideOverlayWithCallback(null, (Actor)this.c.getTable(), this.e, () -> l());
/*      */     
/* 2055 */     this.v = false;
/* 2056 */     c();
/*      */     
/* 2058 */     a(paramBoolean);
/*      */   }
/*      */   
/*      */   private static class TabConfig
/*      */   {
/*      */     public float buttonShiftX;
/*      */     public InventoryOverlay.TabType tabType;
/*      */     public String iconAlias;
/*      */     public Color colorDark;
/*      */     public Color colorBright;
/*      */     public ItemSubcategoryType[] subcategories;
/*      */     private String a;
/*      */     
/*      */     private TabConfig(InventoryOverlay.TabType param1TabType, float param1Float, String param1String, Color param1Color1, Color param1Color2, ItemSubcategoryType[] param1ArrayOfItemSubcategoryType) {
/* 2072 */       this.buttonShiftX = param1Float;
/* 2073 */       this.iconAlias = param1String;
/* 2074 */       this.tabType = param1TabType;
/* 2075 */       this.colorDark = param1Color1;
/* 2076 */       this.colorBright = param1Color2;
/* 2077 */       this.subcategories = param1ArrayOfItemSubcategoryType;
/* 2078 */       this.a = "inventory_tab_name_" + param1TabType.name();
/*      */     }
/*      */     
/*      */     public String getName() {
/* 2082 */       return Game.i.localeManager.i18n.get(this.a);
/*      */     } }
/*      */   
/*      */   private class SubcategoryItems { public ItemSubcategoryType subcategoryType;
/*      */     public RarityType rarityType;
/*      */     public Array<ItemStack> items;
/*      */     
/*      */     private SubcategoryItems(InventoryOverlay this$0) {
/* 2090 */       this.items = new Array(ItemStack.class);
/*      */     }
/*      */     public String getIconAlias() {
/* 2093 */       if (this.subcategoryType != null) {
/* 2094 */         return Game.i.itemManager.getSubcategoryIconAlias(this.subcategoryType);
/*      */       }
/* 2096 */       return Game.i.progressManager.getRarityIcon(this.rarityType);
/*      */     }
/*      */ 
/*      */     
/*      */     public String getTitle() {
/* 2101 */       if (this.subcategoryType != null) {
/* 2102 */         return Game.i.itemManager.getSubcategoryName(this.subcategoryType);
/*      */       }
/* 2104 */       return Game.i.progressManager.getRarityName(this.rarityType);
/*      */     }
/*      */ 
/*      */     
/*      */     public Color getColor() {
/* 2109 */       if (this.subcategoryType != null) {
/* 2110 */         return Game.i.itemManager.getSubcategoryColor(this.subcategoryType);
/*      */       }
/* 2112 */       return Game.i.progressManager.getRarityBrightColor(this.rarityType);
/*      */     } }
/*      */ 
/*      */   
/*      */   private class SubcategoryButtonConfig { public float distanceY;
/*      */     public PaddedImageButton button;
/*      */     
/*      */     private SubcategoryButtonConfig(InventoryOverlay this$0) {} }
/*      */   
/*      */   private class _ProgressManagerListener extends ProgressManager.ProgressManagerListener.ProgressManagerListenerAdapter {
/*      */     private _ProgressManagerListener(InventoryOverlay this$0) {}
/*      */     
/*      */     public void itemsChanged(Item param1Item, int param1Int1, int param1Int2) {
/* 2125 */       if (InventoryOverlay.h(this.a)) {
/*      */         ItemSubcategoryType[] arrayOfItemSubcategoryType; byte b;
/* 2127 */         for (param1Int2 = (arrayOfItemSubcategoryType = arrayOfItemSubcategoryType = (InventoryOverlay.a()[InventoryOverlay.i(this.a).ordinal()]).subcategories).length, b = 0; b < param1Int2; b++) {
/* 2128 */           ItemSubcategoryType itemSubcategoryType; if ((itemSubcategoryType = arrayOfItemSubcategoryType[b]) == param1Item.getSubcategory()) {
/* 2129 */             InventoryOverlay.a(this.a, true);
/*      */             
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 2136 */       InventoryOverlay.j(this.a);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\InventoryOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */