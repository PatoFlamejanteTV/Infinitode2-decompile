/*     */ package com.prineside.tdi2.ui.shared;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.global.Render;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.screens.GameScreen;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.TableButton;
/*     */ import com.prineside.tdi2.ui.actors.Window;
/*     */ import com.prineside.tdi2.ui.shared.stateDebugger.GameListenersView;
/*     */ import com.prineside.tdi2.ui.shared.stateDebugger.GlobalListenersView;
/*     */ import com.prineside.tdi2.ui.shared.stateDebugger.UtilitiesView;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class StateDebugger
/*     */   extends UiManager.UiComponent.Adapter {
/*     */   public static StateDebugger i() {
/*  30 */     return (StateDebugger)Game.i.uiManager.getComponent(StateDebugger.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int WINDOW_CONTENTS_PADDING = 12;
/*     */   public static final int WINDOW_CONTENTS_PADDING_TOP = 8;
/*  36 */   private final HashMap<String, View> a = new HashMap<>();
/*  37 */   private final Array<String> b = new Array();
/*     */   
/*     */   public Window window;
/*     */   
/*     */   public Table contentTable;
/*     */   private String c;
/*  43 */   private final HashMap<String, TableButton> d = new HashMap<>();
/*     */   
/*     */   private final Listener<Render> e = paramRender -> renderWindow();
/*     */   
/*     */   public StateDebugger() {
/*  48 */     registerView((View)new GameListenersView());
/*  49 */     registerView((View)new GlobalListenersView());
/*  50 */     registerView((View)new UtilitiesView());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPersistent() {
/*  55 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/*  60 */     if (this.window != null) {
/*  61 */       this.window.close();
/*  62 */       this.window = null;
/*     */     } 
/*     */     
/*  65 */     Game.EVENTS.getListeners(Render.class).remove(this.e);
/*     */   }
/*     */   
/*     */   public static void tableRowSep(Table paramTable, int paramInt) {
/*     */     Image image;
/*  70 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  71 */     paramTable.add((Actor)image).height(1.0F).colspan(paramInt).fillX().row();
/*     */     
/*  73 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*  74 */     paramTable.add((Actor)image).height(1.0F).colspan(paramInt).fillX().row();
/*     */   }
/*     */   @Null
/*     */   public GameSystemProvider getCurrentSystemProvider() {
/*  78 */     if (Game.i.screenManager.getCurrentScreen() instanceof GameScreen) {
/*     */       GameScreen gameScreen;
/*  80 */       return (gameScreen = (GameScreen)Game.i.screenManager.getCurrentScreen()).S;
/*     */     } 
/*  82 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerView(View paramView) {
/*  87 */     this.a.put(paramView.getId(), paramView);
/*  88 */     if (!this.b.contains(paramView.getId(), false)) {
/*  89 */       this.b.add(paramView.getId());
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCurrentViewId() {
/*  94 */     return (this.c == null) ? (String)this.b.first() : this.c;
/*     */   }
/*     */   
/*     */   public View getCurrentView() {
/*  98 */     return getView(getCurrentViewId());
/*     */   }
/*     */   
/*     */   public View getView(String paramString) {
/* 102 */     return this.a.get(paramString);
/*     */   }
/*     */   
/*     */   public void renderWindow() {
/* 106 */     if (!this.window.isVisible())
/*     */       return; 
/* 108 */     getCurrentView().onRender();
/*     */     
/* 110 */     this.window.clampWindowPosition();
/*     */   }
/*     */   
/*     */   public void rebuildWindow() {
/* 114 */     this.contentTable.clear();
/*     */     
/* 116 */     for (Array.ArrayIterator<String> arrayIterator = this.b.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/* 117 */       boolean bool = !getCurrentViewId().equals(str) ? true : false;
/* 118 */       ((TableButton)this.d.get(str)).setEnabled(bool); }
/*     */     
/* 120 */     getCurrentView().rebuildWindow();
/* 121 */     this.window.clampWindowPosition();
/* 122 */     renderWindow();
/*     */   }
/*     */   
/*     */   public void setTab(String paramString) {
/* 126 */     Preconditions.checkNotNull(paramString, "viewId is null");
/*     */     
/* 128 */     if (this.c != null) {
/* 129 */       getCurrentView().onHide();
/*     */     }
/* 131 */     this.c = paramString;
/* 132 */     rebuildWindow();
/* 133 */     getCurrentView().onShow();
/*     */   }
/*     */   
/*     */   public void show() {
/* 137 */     if (!Config.isModdingMode() && !Game.i.progressManager.isDeveloperModeEnabled()) {
/* 138 */       Dialog.i().showAlert("Developer mode research required");
/*     */       
/*     */       return;
/*     */     } 
/* 142 */     hide();
/*     */     
/* 144 */     Game.EVENTS.getListeners(Render.class).add(this.e).setName("StateDebugger").setDescription("Calls renderWindow");
/*     */     
/*     */     Window.WindowStyle windowStyle;
/* 147 */     (windowStyle = Game.i.assetManager.createDefaultWindowStyle()).resizeable = true;
/* 148 */     windowStyle.inheritWidgetMinSize = false;
/* 149 */     this.window = new Window(windowStyle);
/* 150 */     this.window.setTitle("State debugger");
/* 151 */     this.window.minWidth = 100.0F;
/* 152 */     this.window.minHeight = 250.0F;
/* 153 */     Game.i.uiManager.addWindow(this.window);
/*     */     
/* 155 */     this.window.showAtCursor();
/* 156 */     this.window.addListener((Window.WindowListener)new Window.WindowListener.Adapter(this)
/*     */         {
/*     */           public void closed() {
/* 159 */             this.a.getCurrentView().onHide();
/* 160 */             Game.i.uiManager.stage.setScrollFocus(null);
/* 161 */             this.a.window.remove();
/*     */           }
/*     */         });
/*     */     
/* 165 */     Table table1 = new Table();
/*     */ 
/*     */     
/* 168 */     Table table2 = new Table();
/*     */     
/*     */     Image image;
/* 171 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/* 172 */     image.setFillParent(true);
/* 173 */     table2.addActor((Actor)image);
/*     */     
/* 175 */     table1.add((Actor)table2).expandX().fillX().row();
/* 176 */     table2.add().height(1.0F).width(4.0F);
/*     */     Array.ArrayIterator<String> arrayIterator;
/* 178 */     for (arrayIterator = this.b.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/* 179 */       TableButton tableButton = new TableButton(() -> setTab(paramString));
/* 180 */       table2.add((Actor)tableButton).height(32.0F).padLeft(1.0F).padRight(1.0F).padTop(4.0F);
/*     */       
/* 182 */       tableButton.setName("StateDebugger_tab_" + str);
/* 183 */       tableButton.setContentColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P700, Color.WHITE);
/* 184 */       tableButton.setBackgroundDrawable((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 185 */       tableButton.setBackgroundColors(new Color(), new Color(), new Color(), new Color(0.1F, 0.1F, 0.1F, 1.0F));
/*     */       
/* 187 */       Label label = new Label(getView(str).getName(), Game.i.assetManager.getLabelStyle(18));
/* 188 */       tableButton.add((Actor)label).padLeft(8.0F).padRight(8.0F);
/*     */       
/* 190 */       this.d.put(str, tableButton); }
/*     */ 
/*     */     
/* 193 */     table2.add().height(1.0F).growX();
/* 194 */     table2.add().height(1.0F).width(4.0F);
/*     */ 
/*     */     
/* 197 */     this.contentTable = new Table();
/* 198 */     table1.add((Actor)this.contentTable).pad(12.0F).padTop(8.0F).expand().fill();
/* 199 */     for (arrayIterator = this.b.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/* 200 */       getView(str).init(); }
/*     */     
/* 202 */     setTab((String)this.b.first());
/*     */     
/* 204 */     for (arrayIterator = this.b.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/*     */       View view;
/* 206 */       (view = getView(str)).postInit(); }
/*     */ 
/*     */     
/* 209 */     this.window.setContents((Actor)table1);
/* 210 */     this.window.fitToContentSimple();
/*     */   }
/*     */   
/*     */   public static interface View {
/*     */     String getId();
/*     */     
/*     */     String getName();
/*     */     
/*     */     void rebuildWindow();
/*     */     
/*     */     void init();
/*     */     
/*     */     void postInit();
/*     */     
/*     */     void onShow();
/*     */     
/*     */     void onHide();
/*     */     
/*     */     void onRender();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\StateDebugger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */