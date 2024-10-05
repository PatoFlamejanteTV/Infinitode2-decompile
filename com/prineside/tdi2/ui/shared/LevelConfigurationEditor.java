/*      */ package com.prineside.tdi2.ui.shared;
/*      */ import com.badlogic.gdx.Application;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Input;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.math.Interpolation;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.prineside.tdi2.BasicLevel;
/*      */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*      */ import com.prineside.tdi2.BasicLevelStage;
/*      */ import com.prineside.tdi2.EnemyGroup;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Requirement;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.WaveTemplates;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.RequirementType;
/*      */ import com.prineside.tdi2.enums.ResearchType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.gameplayMods.BonusStagesConfig;
/*      */ import com.prineside.tdi2.managers.AuthManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.CheckBox;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.ui.TextArea;
/*      */ import com.prineside.tdi2.scene2d.ui.TextField;
/*      */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.ItemCell;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*      */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*      */ import com.prineside.tdi2.ui.actors.RectButton;
/*      */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectConsumer;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.StringWriter;
/*      */ 
/*      */ public final class LevelConfigurationEditor extends UiManager.UiComponent.Adapter {
/*   64 */   private static final TLog a = TLog.forClass(LevelConfigurationEditor.class);
/*      */   public static LevelConfigurationEditor i() {
/*   66 */     return (LevelConfigurationEditor)Game.i.uiManager.getComponent(LevelConfigurationEditor.class);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*   71 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 141, "LevelConfigurationEditor main");
/*      */   
/*      */   private BasicLevel c;
/*      */   
/*      */   private Table d;
/*      */   
/*      */   private Table e;
/*      */   
/*      */   private CheckBox.CheckBoxStyle f;
/*      */   
/*      */   private SelectBox.SelectBoxStyle g;
/*      */   private TextField.TextFieldStyle h;
/*      */   private RectButton i;
/*      */   
/*      */   public LevelConfigurationEditor() {
/*   86 */     this
/*      */ 
/*      */       
/*   89 */       .f = new CheckBox.CheckBoxStyle(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.RED.P500), Game.i.assetManager.getDrawable("blank").tint(MaterialColor.GREEN.P500), (BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE);
/*      */ 
/*      */     
/*   92 */     this.f.checkboxOff.setLeftWidth(24.0F);
/*   93 */     this.f.checkboxOff.setBottomHeight(24.0F);
/*      */     
/*   95 */     this.g = Game.i.assetManager.getSelectBoxStyle((BitmapFont)Game.i.assetManager.getFont(24), true);
/*   96 */     this.h = Game.i.assetManager.getTextFieldStyle(24);
/*      */     
/*      */     Group group1;
/*      */     
/*  100 */     (group1 = new Group()).setTransform(false);
/*  101 */     this.b.getTable().add((Actor)group1).size(1200.0F, 1000.0F);
/*      */     
/*      */     Image image;
/*  104 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(1200.0F, 1000.0F);
/*  105 */     image.setColor(new Color(858993663));
/*  106 */     group1.addActor((Actor)image);
/*      */ 
/*      */     
/*  109 */     this.d = new Table();
/*      */     ScrollPane scrollPane;
/*  111 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.d, Game.i.assetManager.getScrollPaneStyle(8.0F)));
/*  112 */     scrollPane.setSize(240.0F, 1000.0F);
/*  113 */     scrollPane.setScrollingDisabled(true, false);
/*  114 */     group1.addActor((Actor)scrollPane);
/*      */     
/*  116 */     b();
/*      */     
/*  118 */     this.e = new Table();
/*  119 */     this.e.setSize(900.0F, 906.0F);
/*      */     
/*  121 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.e, Game.i.assetManager.getScrollPaneStyle(16.0F)));
/*  122 */     scrollPane.setSize(940.0F, 906.0F);
/*  123 */     scrollPane.setPosition(260.0F, 84.0F);
/*  124 */     group1.addActor((Actor)scrollPane);
/*      */     
/*      */     Group group2;
/*  127 */     (group2 = new Group()).setTransform(false);
/*  128 */     group2.setPosition(250.0F, 10.0F);
/*  129 */     group1.addActor((Actor)group2);
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
/*      */     RectButton rectButton;
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
/*  153 */     (rectButton = new RectButton("Save", Game.i.assetManager.getLabelStyle(24), () -> { Game.i.soundManager.playStatic(StaticSoundType.BUTTON); if (this.c != null) { this.c.saveToDisk(); Label label; (label = new Label("Done!", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.GREEN.P500); label.setPosition(740.0F, 0.0F); label.setSize(200.0F, 64.0F); label.setAlignment(1); label.setTouchable(Touchable.disabled); paramGroup.addActor((Actor)label); label.addAction((Action)Actions.sequence((Action)Actions.moveBy(0.0F, 64.0F, 0.3F, (Interpolation)Interpolation.exp5Out), (Action)Actions.fadeOut(0.2F), (Action)Actions.removeActor())); c(); }  })).setSize(200.0F, 64.0F);
/*  154 */     rectButton.setPosition(740.0F, 0.0F);
/*  155 */     group2.addActor((Actor)rectButton);
/*      */     
/*  157 */     c();
/*      */     
/*  159 */     hide();
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean isPersistent() {
/*  164 */     return true;
/*      */   }
/*      */   
/*      */   private void b() {
/*  168 */     this.d.clear();
/*      */     
/*  170 */     for (Array.ArrayIterator<BasicLevelStage> arrayIterator = Game.i.basicLevelManager.stagesOrdered.iterator(); arrayIterator.hasNext(); ) {
/*  171 */       BasicLevelStage basicLevelStage; (basicLevelStage = arrayIterator.next()).sortLevels();
/*      */       
/*      */       Label label;
/*  174 */       (label = new Label(basicLevelStage.name + " - " + basicLevelStage.getTitle(), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  175 */       label.setAlignment(1);
/*  176 */       this.d.add((Actor)label).size(240.0F, 24.0F).padBottom(4.0F).padTop(16.0F).row();
/*      */       
/*  178 */       for (Array.ArrayIterator<BasicLevel> arrayIterator1 = basicLevelStage.levels.iterator(); arrayIterator1.hasNext(); ) { BasicLevel basicLevel = arrayIterator1.next();
/*  179 */         RectButton rectButton = new RectButton(basicLevel.name, Game.i.assetManager.getLabelStyle(24), () -> {
/*      */               this.c = paramBasicLevel;
/*      */               c();
/*      */             });
/*  183 */         if (this.c == basicLevel) {
/*  184 */           rectButton.setBackgroundColors(Color.WHITE, Color.WHITE, Color.WHITE, MaterialColor.AMBER.P900);
/*  185 */           rectButton.setEnabled(false);
/*      */         } 
/*  187 */         rectButton.setIconLabelColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/*  188 */         this.d.add((Actor)rectButton).size(240.0F, 48.0F).padBottom(2.0F).row(); }
/*      */     
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
/*      */ 
/*      */     
/*      */     RectButton rectButton1;
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
/*  220 */     (rectButton1 = new RectButton("Add level", Game.i.assetManager.getLabelStyle(24), () -> Game.i.uiManager.getTextInput(new Input.TextInputListener(this) { public void input(String param1String) { Threads.i().runOnMainThread(() -> { if (param1String.length() < 2 || param1String.contains("/") || param1String.contains("\\")) { Dialog.i().showAlert("0-9, a-Z and dot, minimum 2 characters"); return; }  if (Game.i.basicLevelManager.getLevel(param1String) != null) { Dialog.i().showAlert("Level with this name already exists"); return; }  BasicLevel basicLevel = BasicLevel.createNew(param1String); Game.i.basicLevelManager.registerLevel(basicLevel); basicLevel.saveToDisk(); LevelConfigurationEditor.a(this.a, basicLevel); LevelConfigurationEditor.c(this.a); }); } public void canceled() {} }"Level name", "", "0-9, a-Z and dot, minimum 2 characters. Name can't be changed, choose wisely"))).setIconLabelColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/*  221 */     rectButton1.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.WHITE);
/*  222 */     this.d.add((Actor)rectButton1).size(240.0F, 48.0F).padBottom(2.0F).padTop(8.0F).row();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     RectButton rectButton2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  235 */     (rectButton2 = new RectButton("Add from Json", Game.i.assetManager.getLabelStyle(24), () -> Game.i.uiManager.getTextInput(new Input.TextInputListener(this) { public void input(String param1String) { Threads.i().runOnMainThread(() -> LevelConfigurationEditor.a(this.a, param1String)); } public void canceled() {} }"Level JSON", "", "Copied from the existing level"))).setIconLabelColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/*  236 */     rectButton2.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.WHITE);
/*  237 */     this.d.add((Actor)rectButton2).size(240.0F, 48.0F).padBottom(2.0F).padTop(8.0F).row();
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
/*      */     RectButton rectButton3;
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
/*  268 */     (rectButton3 = new RectButton("Add from URL", Game.i.assetManager.getLabelStyle(24), () -> Game.i.uiManager.getTextInput(new Input.TextInputListener(this) { public void input(String param1String) { Net.HttpRequest httpRequest; (httpRequest = new Net.HttpRequest("GET")).setUrl(param1String); Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener(this) { public void handleHttpResponse(Net.HttpResponse param2HttpResponse) { String str = param2HttpResponse.getResultAsString(); Threads.i().runOnMainThread(() -> LevelConfigurationEditor.a(this.a.a, param2String)); } public void failed(Throwable param2Throwable) { LevelConfigurationEditor.a().e("request failed", new Object[] { param2Throwable }); } public void cancelled() {} }); } public void canceled() {} }"Level Json URL", "", "Shared online by someone"))).setIconLabelColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/*  269 */     rectButton3.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.WHITE);
/*  270 */     this.d.add((Actor)rectButton3).size(240.0F, 48.0F).padBottom(2.0F).padTop(8.0F).row();
/*      */     
/*  272 */     this.d.add().width(1.0F).height(96.0F);
/*      */   }
/*      */   
/*      */   private void a(String paramString) {
/*      */     try {
/*  277 */       BasicLevel basicLevel1 = BasicLevel.createNewFromFullJson(paramString);
/*  278 */       Runnable runnable = () -> {
/*      */           Game.i.basicLevelManager.registerLevel(paramBasicLevel);
/*      */           
/*      */           paramBasicLevel.saveToDisk();
/*      */           Game.i.basicLevelManager.setMap(paramBasicLevel, paramBasicLevel.getMap());
/*      */           this.c = paramBasicLevel;
/*      */           c();
/*      */           Notifications.i().add("Level " + paramBasicLevel.name + " imported from Json", null, null, StaticSoundType.SUCCESS);
/*      */         };
/*      */       BasicLevel basicLevel2;
/*  288 */       if ((basicLevel2 = Game.i.basicLevelManager.getLevel(basicLevel1.name)) == null) {
/*  289 */         runnable.run();
/*      */       } else {
/*  291 */         Dialog.i().showConfirm("Level " + basicLevel1.name + " already exists and will be overwritten, continue?", runnable); return;
/*      */       } 
/*  293 */     } catch (Exception exception) {
/*  294 */       a.e("failed to create level from json", new Object[] { exception });
/*  295 */       Notifications.i().add("Failed to read level from json: " + exception.getMessage(), null, MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*      */     } 
/*      */   }
/*      */   
/*      */   public final void show() {
/*  300 */     if (!Config.isModdingMode() && !Game.i.progressManager.isDeveloperModeEnabled()) {
/*  301 */       Dialog.i().showAlert("Developer mode research required");
/*      */       
/*      */       return;
/*      */     } 
/*  305 */     DarkOverlay.i().addCallerOverlayLayer("LevelConfigurationEditor", this.b.zIndex - 1, () -> {
/*      */           hide();
/*      */           return true;
/*      */         });
/*  309 */     this.b.getTable().setVisible(true);
/*      */   }
/*      */   
/*      */   public final void showForLevel(BasicLevel paramBasicLevel) {
/*  313 */     this.c = paramBasicLevel;
/*  314 */     c();
/*  315 */     show();
/*      */   }
/*      */   
/*      */   private void c() {
/*  319 */     if (this.c == null) {
/*  320 */       this.c = (BasicLevel)Game.i.basicLevelManager.levelsOrdered.first();
/*      */     }
/*      */     
/*  323 */     b();
/*      */     
/*  325 */     this.e.clearChildren();
/*      */     
/*      */     Group group;
/*      */     
/*  329 */     (group = new Group()).setTransform(false);
/*  330 */     this.e.add((Actor)group).expandX().fillX().padTop(20.0F).height(40.0F).row();
/*      */     
/*      */     Label label;
/*  333 */     (label = new Label(this.c.name, Game.i.assetManager.getLabelStyle(30))).setColor(MaterialColor.AMBER.P500);
/*  334 */     label.setSize(200.0F, 40.0F);
/*  335 */     group.addActor((Actor)label);
/*      */     
/*      */     Table table4;
/*  338 */     (table4 = new Table()).setSize(700.0F, 40.0F);
/*  339 */     table4.setPosition(200.0F, 0.0F);
/*  340 */     group.addActor((Actor)table4);
/*      */     
/*      */     Table table2;
/*  343 */     (table2 = new Table()).add().height(1.0F).growX();
/*  344 */     table4.add((Actor)table2).growX().row();
/*      */     
/*  346 */     boolean bool1 = Gdx.files.internal("levels/" + this.c.name + ".json").exists();
/*  347 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop || Gdx.app.getType() == Application.ApplicationType.HeadlessDesktop) {
/*  348 */       bool1 = false;
/*      */     }
/*  350 */     boolean bool2 = Gdx.files.local("levels/" + this.c.name + ".json").exists();
/*      */     int j;
/*  352 */     if (j = (Gdx.app.getType() != Application.ApplicationType.Desktop && Game.i.basicLevelManager.defaultLevelNames.contains(this.c.name, false)) ? 1 : 0) {
/*      */       
/*  354 */       Label label1 = new Label("Default", Game.i.assetManager.getLabelStyle(21));
/*  355 */       table2.add((Actor)label1).padRight(10.0F);
/*      */     } 
/*      */     
/*  358 */     RectButton rectButton5 = new RectButton("Clone", Game.i.assetManager.getLabelStyle(21), () -> Game.i.uiManager.getTextInput(new Input.TextInputListener(this)
/*      */           {
/*      */             
/*      */             public void input(String param1String)
/*      */             {
/*  363 */               if (param1String.length() < 2 || param1String.contains("/") || param1String.contains("\\")) {
/*  364 */                 Dialog.i().showAlert("0-9, a-Z and dot, minimum 2 characters");
/*      */                 
/*      */                 return;
/*      */               } 
/*  368 */               if (Game.i.basicLevelManager.getLevel(param1String) != null) {
/*  369 */                 Dialog.i().showAlert("Level with this name already exists");
/*      */                 
/*      */                 return;
/*      */               } 
/*  373 */               BasicLevel basicLevel = LevelConfigurationEditor.a(this.a).clone(param1String);
/*  374 */               Game.i.basicLevelManager.registerLevel(basicLevel);
/*      */               
/*  376 */               LevelConfigurationEditor.a(this.a, basicLevel);
/*  377 */               LevelConfigurationEditor.c(this.a);
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void canceled() {}
/*      */           }"Map name", this.c.name, ""));
/*  386 */     table2.add((Actor)rectButton5).size(150.0F, 32.0F).padLeft(10.0F);
/*      */     
/*  388 */     if (bool2)
/*      */     {
/*  390 */       if (bool1) {
/*      */         
/*  392 */         rectButton5 = new RectButton("Reset configuration", Game.i.assetManager.getLabelStyle(21), () -> Dialog.i().showConfirm("Reset level configuration? Original configuration will be used", ()));
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
/*  406 */         table2.add((Actor)rectButton5).size(200.0F, 32.0F).padLeft(10.0F);
/*  407 */       } else if (!j) {
/*      */         
/*  409 */         rectButton5 = new RectButton("Delete", Game.i.assetManager.getLabelStyle(21), () -> Dialog.i().showConfirm("Delete this level? Map will be kept as a local file (create a level with the same name to access it)", ()));
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
/*  423 */         table2.add((Actor)rectButton5).size(150.0F, 32.0F).padLeft(10.0F);
/*      */       } 
/*      */     }
/*      */     
/*  427 */     bool1 = Gdx.files.internal("levels/maps/" + this.c.name + ".json").exists();
/*  428 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop || Gdx.app.getType() == Application.ApplicationType.HeadlessDesktop) {
/*  429 */       bool1 = false;
/*      */     }
/*  431 */     bool2 = Gdx.files.local("levels/maps/" + this.c.name + ".json").exists();
/*  432 */     if (j && bool1 && bool2) {
/*      */       
/*  434 */       rectButton5 = new RectButton("Reset map", Game.i.assetManager.getLabelStyle(21), () -> Dialog.i().showConfirm("Reset map? Map will be restored to the original state", ()));
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
/*  446 */       table2.add((Actor)rectButton5).size(200.0F, 32.0F).padLeft(10.0F);
/*      */     } 
/*  448 */     if (!j && bool2) {
/*      */       
/*  450 */       rectButton5 = new RectButton("Delete (+map)", Game.i.assetManager.getLabelStyle(21), () -> Dialog.i().showConfirm("Delete this level and its map?", ()));
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
/*  465 */       table2.add((Actor)rectButton5).size(200.0F, 32.0F).padLeft(10.0F);
/*      */     } 
/*      */ 
/*      */     
/*  469 */     (table2 = new Table()).add().height(1.0F).growX();
/*  470 */     table4.row();
/*  471 */     table4.add((Actor)table2).padTop(10.0F).growX();
/*      */     
/*  473 */     RectButton rectButton2 = new RectButton("Copy JSON", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */           String str = this.c.toJsonStringEverything();
/*      */           
/*      */           a.i(str, new Object[0]);
/*      */           
/*      */           Gdx.app.getClipboard().setContents(str);
/*      */           Notifications.i().add("Map and its configuration has been copied to the clipboard", null, null, StaticSoundType.SUCCESS);
/*      */         });
/*  481 */     table2.add((Actor)rectButton2).size(150.0F, 32.0F).padLeft(10.0F);
/*      */     
/*  483 */     this.i = new RectButton("Share online", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */           this.i.setEnabled(false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           Game.i.authManager.createPasteBin("Level " + this.c.name, this.c.toJsonStringEverything(), ());
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  498 */     table2.add((Actor)this.i).size(150.0F, 32.0F).padLeft(10.0F);
/*      */ 
/*      */     
/*  501 */     d();
/*      */     
/*  503 */     b("Stage");
/*  504 */     SelectBox selectBox1 = new SelectBox(this.g);
/*  505 */     Array array1 = new Array(String.class);
/*  506 */     for (Array.ArrayIterator<BasicLevelStage> arrayIterator1 = Game.i.basicLevelManager.stagesOrdered.iterator(); arrayIterator1.hasNext(); ) { BasicLevelStage basicLevelStage = arrayIterator1.next();
/*  507 */       array1.add(basicLevelStage.name + " - " + basicLevelStage.getTitle()); }
/*      */     
/*  509 */     selectBox1.setItems(array1);
/*  510 */     selectBox1.setSelected(this.c.stageName + " - " + Game.i.basicLevelManager.getStage(this.c.stageName).getTitle());
/*  511 */     selectBox1.addListener((EventListener)new ChangeListener(this, selectBox1)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  514 */             String[] arrayOfString = ((String)this.a.getSelected()).split(" - ");
/*      */             
/*  516 */             Game.i.basicLevelManager.unloadLevel((LevelConfigurationEditor.a(this.b)).name);
/*  517 */             (LevelConfigurationEditor.a(this.b)).stageName = arrayOfString[0];
/*  518 */             Game.i.basicLevelManager.registerLevel(LevelConfigurationEditor.a(this.b));
/*      */             
/*  520 */             LevelConfigurationEditor.b(this.b);
/*      */           }
/*      */         });
/*  523 */     a(selectBox1);
/*      */     
/*  525 */     d();
/*      */     
/*  527 */     b("Position in stage");
/*  528 */     hint("Levels will be sorted by this value, higher = further in the list");
/*  529 */     textField(String.valueOf(this.c.stagePosition), paramString -> {
/*      */           try {
/*      */             this.c.stagePosition = Integer.parseInt(paramString); b();
/*      */             return;
/*  533 */           } catch (Exception exception) {
/*      */             a.e("bad value: " + paramString, new Object[] { exception });
/*      */             return;
/*      */           } 
/*      */         });
/*  538 */     d();
/*      */     
/*  540 */     b("Seed");
/*  541 */     hint("Random seed - enemy waves depend on it");
/*  542 */     textField(String.valueOf(this.c.seed), paramString -> {
/*      */           try {
/*      */             this.c.seed = Integer.parseInt(paramString); return;
/*  545 */           } catch (Exception exception) {
/*      */             a.e("bad value: " + paramString, new Object[] { exception });
/*      */             return;
/*      */           } 
/*      */         });
/*  550 */     d();
/*      */     
/*  552 */     a("Has leaderboards", this.c.hasLeaderboards, paramBoolean -> this.c.hasLeaderboards = paramBoolean.booleanValue());
/*      */ 
/*      */     
/*  555 */     hint("Should the game send replays for this level to the server and show leaderboards?");
/*      */     
/*  557 */     d();
/*      */     
/*  559 */     a("No achievements", this.c.achievementsDisabled, paramBoolean -> this.c.achievementsDisabled = paramBoolean.booleanValue());
/*      */ 
/*      */ 
/*      */     
/*  563 */     a("Not affects statistics", this.c.notAffectsStatistics, paramBoolean -> this.c.notAffectsStatistics = paramBoolean.booleanValue());
/*      */ 
/*      */     
/*  566 */     hint("Playing on this level won't count towards the global statistics");
/*      */     
/*  568 */     d();
/*      */     
/*  570 */     b("Forced difficulty");
/*  571 */     SelectBox selectBox2 = new SelectBox(this.g);
/*      */     Array array2;
/*  573 */     (array2 = new Array(String.class)).add("-"); DifficultyMode[] arrayOfDifficultyMode;
/*  574 */     for (int i = (arrayOfDifficultyMode = DifficultyMode.values()).length; j < i; ) { DifficultyMode difficultyMode = arrayOfDifficultyMode[j];
/*  575 */       array2.add(difficultyMode.name()); j++; }
/*      */     
/*  577 */     selectBox2.setItems(array2);
/*  578 */     if (this.c.forcedDifficulty == null) {
/*  579 */       selectBox2.setSelected("-");
/*      */     } else {
/*  581 */       selectBox2.setSelected(this.c.forcedDifficulty.name());
/*      */     } 
/*  583 */     selectBox2.addListener((EventListener)new ChangeListener(this, selectBox2)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */             String str;
/*  587 */             if ((str = (String)this.a.getSelected()).equals("-")) {
/*  588 */               (LevelConfigurationEditor.a(this.b)).forcedDifficulty = null; return;
/*      */             } 
/*  590 */             (LevelConfigurationEditor.a(this.b)).forcedDifficulty = DifficultyMode.valueOf(str);
/*      */           }
/*      */         });
/*      */     
/*  594 */     a(selectBox2);
/*      */     
/*  596 */     d();
/*      */     
/*  598 */     b("Fast forward frame");
/*  599 */     hint("Game will start the first wave and auto-run to this frame at start");
/*  600 */     textField(String.valueOf(this.c.fastForwardFrame), paramString -> {
/*      */           try {
/*      */             this.c.fastForwardFrame = Integer.parseInt(paramString);
/*      */             if (this.c.fastForwardFrame < 0)
/*      */               this.c.fastForwardFrame = 0; 
/*      */             return;
/*  606 */           } catch (Exception exception) {
/*      */             a.e("bad value: " + paramString, new Object[] { exception });
/*      */             return;
/*      */           } 
/*      */         });
/*  611 */     d();
/*      */     
/*  613 */     a("Fixed quests", this.c.fixedQuests, paramBoolean -> this.c.fixedQuests = paramBoolean.booleanValue());
/*      */ 
/*      */     
/*  616 */     hint("If enabled, quests prizes / difficulty will not be affected by research (for example, Prestige mode hard quests research)");
/*      */     
/*  618 */     d();
/*      */     
/*  620 */     a("Bonus", this.c.isBonus, paramBoolean -> this.c.isBonus = paramBoolean.booleanValue());
/*      */ 
/*      */     
/*  623 */     hint("Will mark this level as bonus one");
/*      */     
/*  625 */     d();
/*      */     
/*  627 */     a("Custom waves", this.c.customWaves, paramBoolean -> this.c.customWaves = paramBoolean.booleanValue());
/*  628 */     hint("Level has custom (scripted) waves, wave timeline won't be available in level's menu");
/*      */     
/*  630 */     d();
/*      */     
/*  632 */     a("Daily quest", this.c.dailyQuest, paramBoolean -> this.c.dailyQuest = paramBoolean.booleanValue());
/*      */ 
/*      */     
/*  635 */     hint("Daily quest level names should start with 'DQ'");
/*      */     
/*  637 */     d();
/*      */     
/*  639 */     b("Price in Green Papers");
/*  640 */     textField(String.valueOf(this.c.priceInMoney), paramString -> {
/*      */           try {
/*      */             this.c.priceInMoney = Integer.parseInt(paramString); if (this.c.priceInMoney < 0)
/*      */               this.c.priceInMoney = 0;  return;
/*  644 */           } catch (Exception exception) {
/*      */             a.e("bad value: " + paramString, new Object[] { exception });
/*      */             return;
/*      */           } 
/*      */         });
/*  649 */     d();
/*      */     
/*  651 */     b("Price in Resources");
/*  652 */     Table table1 = new Table();
/*  653 */     this.e.add((Actor)table1).top().left().pad(10.0F, 0.0F, 10.0F, 0.0F).top().left().row();
/*  654 */     table1.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.14F))); ResourceType[] arrayOfResourceType; byte b;
/*  655 */     for (j = (arrayOfResourceType = ResourceType.values).length, b = 0; b < j; ) { ResourceType resourceType = arrayOfResourceType[b];
/*      */       Label label1;
/*  657 */       (label1 = new Label(Game.i.resourceManager.getName(resourceType), Game.i.assetManager.getLabelStyle(24))).setColor(Game.i.resourceManager.getColor(resourceType));
/*  658 */       table1.add((Actor)label1).padLeft(15.0F).padRight(15.0F).height(48.0F);
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform1;
/*  661 */       (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(this.c.priceInResources[resourceType.ordinal()]), this.h)).setSize(300.0F, 40.0F);
/*  662 */       table1.add((Actor)textFieldXPlatform1).size(300.0F, 40.0F).padRight(4.0F).row();
/*  663 */       textFieldXPlatform1.addListener((EventListener)new ChangeListener(this, resourceType, textFieldXPlatform1)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  667 */                 (LevelConfigurationEditor.a(this.c)).priceInResources[this.a.ordinal()] = Integer.parseInt(this.b.getText()); return;
/*  668 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/*      */       b++; }
/*      */     
/*  673 */     d();
/*      */     
/*  675 */     b("Difficulty expected playtime");
/*  676 */     hint("Difficulty growth multiplier. Default is 1, smaller number will make difficulty grow earlier - better to keep in range 0..2\nDifficulty of portals define the overall difficulty of the map, this field defines how fast the difficulty will grow. Almost not affects the first ~20 waves");
/*  677 */     Table table3 = new Table();
/*  678 */     this.e.add((Actor)table3).top().left().pad(10.0F, 0.0F, 10.0F, 0.0F).top().left().row();
/*      */     TextFieldXPlatform textFieldXPlatform;
/*  680 */     (textFieldXPlatform = new TextFieldXPlatform(String.valueOf(this.c.difficultyExpectedPlaytime), this.h)).setSize(300.0F, 40.0F);
/*  681 */     table3.add((Actor)textFieldXPlatform).size(300.0F, 40.0F).padBottom(8.0F).row();
/*  682 */     textFieldXPlatform.addListener((EventListener)new ChangeListener(this, textFieldXPlatform)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */             try {
/*  686 */               (LevelConfigurationEditor.a(this.b)).difficultyExpectedPlaytime = Float.parseFloat(this.a.getText()); return;
/*  687 */             } catch (Exception exception) {
/*      */               return;
/*      */             }  }
/*      */         });
/*  691 */     d();
/*      */     
/*  693 */     b("Bonus stages config");
/*  694 */     TextArea textArea = new TextArea("", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), true));
/*  695 */     if (this.c.bonusStagesConfig != null) {
/*  696 */       Json json = new Json(JsonWriter.OutputType.json);
/*  697 */       StringWriter stringWriter = new StringWriter();
/*  698 */       json.setWriter(stringWriter);
/*      */       
/*  700 */       json.writeObjectStart();
/*  701 */       this.c.bonusStagesConfig.toJson(json);
/*  702 */       json.writeObjectEnd();
/*      */       
/*  704 */       textArea.setText((new JsonReader()).parse(stringWriter.toString()).prettyPrint(JsonWriter.OutputType.json, 2));
/*      */     } 
/*  706 */     textArea.addListener((EventListener)new ChangeListener(this, textArea)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */             try {
/*      */               String str;
/*  711 */               if ((str = this.a.getText()).length() == 0) {
/*  712 */                 (LevelConfigurationEditor.a(this.b)).bonusStagesConfig = null;
/*      */               } else {
/*  714 */                 (LevelConfigurationEditor.a(this.b)).bonusStagesConfig = BonusStagesConfig.fromJsonString(str); return;
/*      */               } 
/*  716 */             } catch (Exception exception) {
/*  717 */               LevelConfigurationEditor.a().i("invalid bonus stages config", new Object[0]);
/*      */             } 
/*      */           }
/*      */         });
/*  721 */     textArea.setMessageText("(No config)");
/*  722 */     this.e.add((Actor)textArea).top().left().padRight(10.0F).growX().minHeight(300.0F).top().left().row();
/*      */     
/*  724 */     d();
/*      */     
/*  726 */     b("Enemy waves");
/*  727 */     hint("Use fixed enemy waves configuration");
/*      */     
/*  729 */     Table table5 = new Table();
/*  730 */     this.e.add((Actor)table5).top().left().pad(10.0F, 0.0F, 10.0F, 0.0F).top().left().row();
/*  731 */     if (this.c.enemyWaves != null) {
/*  732 */       byte b2 = 0; int k; byte b1; WaveTemplates.PredefinedWaveTemplate[] arrayOfPredefinedWaveTemplate;
/*  733 */       for (k = (arrayOfPredefinedWaveTemplate = this.c.enemyWaves).length, b1 = 0; b1 < k; ) { WaveTemplates.PredefinedWaveTemplate predefinedWaveTemplate = arrayOfPredefinedWaveTemplate[b1];
/*      */         Table table7;
/*  735 */         (table7 = new Table()).setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.14F)));
/*      */         
/*  737 */         Table table8 = new Table();
/*  738 */         table7.add((Actor)table8).width(40.0F).align(10).padLeft(15.0F).padRight(15.0F).padTop(10.0F).top().left();
/*      */         
/*  740 */         Label label1 = new Label(String.valueOf(b2 + 1), Game.i.assetManager.getLabelStyle(30));
/*  741 */         table8.add((Actor)label1).size(40.0F, 32.0F).align(1).row();
/*      */         
/*  743 */         byte b3 = b2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         ComplexButton complexButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  762 */         (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> Dialog.i().showConfirm("Delete wave?", ()))).setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 40.0F, 40.0F);
/*  763 */         complexButton.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, Color.GRAY);
/*  764 */         complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 4.0F, 4.0F, 32.0F, 32.0F);
/*  765 */         table8.add((Actor)complexButton).padTop(10.0F).size(40.0F, 40.0F);
/*      */         
/*      */         Table table9;
/*  768 */         (table9 = new Table()).add().height(4.0F).row();
/*      */         Label.LabelStyle labelStyle;
/*  770 */         (labelStyle = new Label.LabelStyle(Game.i.assetManager.getLabelStyle(21))).fontColor = MaterialColor.GREY.P600;
/*      */         
/*  772 */         table9.add((Actor)new Label("Type", labelStyle));
/*  773 */         table9.add((Actor)new Label("Count", labelStyle));
/*  774 */         table9.add((Actor)new Label("HP", labelStyle));
/*  775 */         table9.add((Actor)new Label("Speed", labelStyle));
/*  776 */         table9.add((Actor)new Label("Delay", labelStyle));
/*  777 */         table9.add((Actor)new Label("Interval", labelStyle));
/*  778 */         table9.add((Actor)new Label("Coins", labelStyle));
/*  779 */         table9.add((Actor)new Label("Score", labelStyle));
/*  780 */         table9.add((Actor)new Label("XP", labelStyle));
/*  781 */         table9.add();
/*  782 */         table9.row();
/*  783 */         table9.add().height(4.0F).row();
/*      */         
/*  785 */         byte b4 = 0; EnemyGroup[] arrayOfEnemyGroup; int m; byte b5;
/*  786 */         for (m = (arrayOfEnemyGroup = predefinedWaveTemplate.enemyGroups).length, b5 = 0; b5 < m; ) { EnemyGroup enemyGroup = arrayOfEnemyGroup[b5];
/*      */           
/*      */           SelectBox selectBox;
/*  789 */           (selectBox = new SelectBox(this.g)).setItems(new Array((Object[])EnemyType.values));
/*  790 */           selectBox.setSelected(enemyGroup.getEnemyType());
/*  791 */           selectBox.addListener((EventListener)new ChangeListener(this, enemyGroup, selectBox)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  794 */                   this.a.setEnemyType((EnemyType)this.b.getSelected());
/*      */                 }
/*      */               });
/*  797 */           table9.add((Actor)selectBox).size(150.0F, 40.0F).padRight(4.0F);
/*      */           
/*      */           TextFieldXPlatform textFieldXPlatform1;
/*      */           
/*  801 */           (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(enemyGroup.count), this.h)).addListener((EventListener)new ChangeListener(this, enemyGroup, textFieldXPlatform1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/*  805 */                     this.a.count = Integer.parseInt(this.b.getText());
/*  806 */                     if (this.a.count <= 0) this.a.count = 1;  return;
/*  807 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   }  } });
/*  810 */           table9.add((Actor)textFieldXPlatform1).top().left().size(60.0F, 40.0F).padRight(4.0F);
/*      */ 
/*      */ 
/*      */           
/*  814 */           (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(enemyGroup.health), this.h)).addListener((EventListener)new ChangeListener(this, enemyGroup, textFieldXPlatform1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/*  818 */                     this.a.health = Float.parseFloat(this.b.getText());
/*  819 */                     if (this.a.health < 0.0F) this.a.health = 0.0F;  return;
/*  820 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   }  } });
/*  823 */           table9.add((Actor)textFieldXPlatform1).top().left().size(100.0F, 40.0F).padRight(4.0F);
/*      */ 
/*      */ 
/*      */           
/*  827 */           (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(enemyGroup.speed), this.h)).addListener((EventListener)new ChangeListener(this, enemyGroup, textFieldXPlatform1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/*  831 */                     this.a.speed = Float.parseFloat(this.b.getText());
/*  832 */                     if (this.a.speed < 0.0F) this.a.speed = 0.0F;  return;
/*  833 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   }  } });
/*  836 */           table9.add((Actor)textFieldXPlatform1).top().left().size(75.0F, 40.0F).padRight(4.0F);
/*      */ 
/*      */ 
/*      */           
/*  840 */           (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(enemyGroup.delay), this.h)).addListener((EventListener)new ChangeListener(this, enemyGroup, textFieldXPlatform1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/*  844 */                     this.a.delay = Float.parseFloat(this.b.getText());
/*  845 */                     if (this.a.delay < 0.0F) this.a.delay = 0.0F;  return;
/*  846 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   }  } });
/*  849 */           table9.add((Actor)textFieldXPlatform1).top().left().size(75.0F, 40.0F).padRight(4.0F);
/*      */ 
/*      */ 
/*      */           
/*  853 */           (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(enemyGroup.interval), this.h)).addListener((EventListener)new ChangeListener(this, enemyGroup, textFieldXPlatform1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/*  857 */                     this.a.interval = Float.parseFloat(this.b.getText());
/*  858 */                     if (this.a.interval < 0.0F) this.a.interval = 0.0F;  return;
/*  859 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   }  } });
/*  862 */           table9.add((Actor)textFieldXPlatform1).top().left().size(75.0F, 40.0F).padRight(4.0F);
/*      */ 
/*      */ 
/*      */           
/*  866 */           (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(enemyGroup.bounty), this.h)).addListener((EventListener)new ChangeListener(this, enemyGroup, textFieldXPlatform1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/*  870 */                     this.a.bounty = Float.parseFloat(this.b.getText());
/*  871 */                     if (this.a.bounty < 0.0F) this.a.bounty = 0.0F;  return;
/*  872 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   }  } });
/*  875 */           table9.add((Actor)textFieldXPlatform1).top().left().size(75.0F, 40.0F).padRight(4.0F);
/*      */ 
/*      */ 
/*      */           
/*  879 */           (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(enemyGroup.killScore), this.h)).addListener((EventListener)new ChangeListener(this, enemyGroup, textFieldXPlatform1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/*  883 */                     this.a.killScore = Integer.parseInt(this.b.getText());
/*  884 */                     if (this.a.killScore < 0) this.a.killScore = 0;  return;
/*  885 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   }  } });
/*  888 */           table9.add((Actor)textFieldXPlatform1).top().left().size(75.0F, 40.0F).padRight(4.0F);
/*      */ 
/*      */ 
/*      */           
/*  892 */           (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(enemyGroup.killExp), this.h)).addListener((EventListener)new ChangeListener(this, enemyGroup, textFieldXPlatform1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/*  896 */                     this.a.killExp = Float.parseFloat(this.b.getText());
/*  897 */                     if (this.a.killExp < 0.0F) this.a.killExp = 0.0F;  return;
/*  898 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   }  } });
/*  901 */           table9.add((Actor)textFieldXPlatform1).top().left().size(75.0F, 40.0F).padRight(4.0F);
/*      */ 
/*      */           
/*  904 */           byte b6 = b4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           ComplexButton complexButton1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  923 */           (complexButton1 = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> Dialog.i().showConfirm("Delete group?", ()))).setIconColors(MaterialColor.ORANGE.P500, MaterialColor.ORANGE.P600, MaterialColor.ORANGE.P400, Color.GRAY);
/*  924 */           complexButton1.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 4.0F, 4.0F, 32.0F, 32.0F);
/*  925 */           table9.add((Actor)complexButton1).size(44.0F, 40.0F);
/*      */           
/*  927 */           table9.row();
/*  928 */           table9.add().width(1.0F).height(4.0F).row();
/*      */           
/*  930 */           b4++;
/*      */           b5++; }
/*      */         
/*  933 */         RectButton rectButton = new RectButton("Add group", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */               EnemyGroup[] arrayOfEnemyGroup = new EnemyGroup[paramPredefinedWaveTemplate.enemyGroups.length + 1];
/*      */               
/*      */               System.arraycopy(paramPredefinedWaveTemplate.enemyGroups, 0, arrayOfEnemyGroup, 0, paramPredefinedWaveTemplate.enemyGroups.length);
/*      */               
/*      */               paramPredefinedWaveTemplate.enemyGroups = arrayOfEnemyGroup;
/*      */               
/*      */               arrayOfEnemyGroup[arrayOfEnemyGroup.length - 1] = new EnemyGroup(EnemyType.REGULAR, 1.0F, 20.0F, 10, 0.0F, 0.5F, 2.0F, 1.0F, 10);
/*      */               c();
/*      */             });
/*  943 */         table9.add((Actor)rectButton).size(150.0F, 40.0F).padBottom(4.0F).top().left().row();
/*      */         
/*  945 */         table7.add((Actor)table9).row();
/*  946 */         table5.add((Actor)table7).padBottom(4.0F).row();
/*      */         
/*  948 */         b2++; b1++; }
/*      */     
/*      */     } 
/*  951 */     RectButton rectButton3 = new RectButton("Add wave", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */           if (this.c.enemyWaves == null) {
/*      */             this.c.enemyWaves = new WaveTemplates.PredefinedWaveTemplate[1];
/*      */           } else {
/*      */             WaveTemplates.PredefinedWaveTemplate[] arrayOfPredefinedWaveTemplate = new WaveTemplates.PredefinedWaveTemplate[this.c.enemyWaves.length + 1];
/*      */             
/*      */             System.arraycopy(this.c.enemyWaves, 0, arrayOfPredefinedWaveTemplate, 0, this.c.enemyWaves.length);
/*      */             
/*      */             this.c.enemyWaves = arrayOfPredefinedWaveTemplate;
/*      */           } 
/*      */           
/*      */           this.c.enemyWaves[this.c.enemyWaves.length - 1] = new WaveTemplates.PredefinedWaveTemplate(new EnemyGroup(EnemyType.REGULAR, 1.0F, 20.0F, 10, 0.0F, 0.5F, 2.0F, 1.0F, 10));
/*      */           
/*      */           c();
/*      */         });
/*  966 */     this.e.add((Actor)rectButton3).size(200.0F, 48.0F).top().left().row();
/*      */     
/*  968 */     d();
/*      */     
/*  970 */     b("Visibility requirements");
/*  971 */     requirements(this.c.showRequirements, this.e, this.g, this.h, this::c);
/*      */     
/*  973 */     b("Unlock requirements");
/*  974 */     requirements(this.c.openRequirements, this.e, this.g, this.h, this::c);
/*      */     
/*  976 */     b("Wave quests");
/*  977 */     Table table6 = new Table();
/*  978 */     this.e.add((Actor)table6).top().left().pad(10.0F, 0.0F, 10.0F, 0.0F).fillX().expandX().top().left().row();
/*      */     
/*  980 */     for (Array.ArrayIterator<BasicLevel.WaveQuest> arrayIterator = this.c.waveQuests.iterator(); arrayIterator.hasNext(); ) { BasicLevel.WaveQuest waveQuest = arrayIterator.next();
/*      */       Table table7;
/*  982 */       (table7 = new Table()).setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.14F)));
/*      */       
/*  984 */       Table table8 = new Table();
/*  985 */       table7.add((Actor)table8).width(220.0F).align(10).padLeft(15.0F).padRight(15.0F).padTop(10.0F).top().left();
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform1;
/*  988 */       (textFieldXPlatform1 = new TextFieldXPlatform(waveQuest.id, this.h)).addListener((EventListener)new ChangeListener(this, waveQuest, textFieldXPlatform1)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  991 */               this.a.id = this.b.getText();
/*      */             }
/*      */           });
/*  994 */       table8.add((Actor)textFieldXPlatform1).size(160.0F, 40.0F).align(1);
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform2;
/*  997 */       (textFieldXPlatform2 = new TextFieldXPlatform(String.valueOf(waveQuest.waves), this.h)).addListener((EventListener)new ChangeListener(this, waveQuest, textFieldXPlatform2)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/* 1001 */                 this.a.waves = Integer.parseInt(this.b.getText()); return;
/* 1002 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/* 1005 */       table8.add((Actor)textFieldXPlatform2).size(56.0F, 40.0F).padLeft(4.0F).align(1).row();
/*      */ 
/*      */ 
/*      */       
/*      */       ComplexButton complexButton;
/*      */ 
/*      */ 
/*      */       
/* 1013 */       (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> Dialog.i().showConfirm("Delete wave quest?", ()))).setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 40.0F, 40.0F);
/* 1014 */       complexButton.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, Color.GRAY);
/* 1015 */       complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 4.0F, 4.0F, 32.0F, 32.0F);
/* 1016 */       table8.add((Actor)complexButton).padTop(10.0F).size(40.0F, 40.0F).left();
/*      */       
/* 1018 */       Table table9 = new Table();
/* 1019 */       a(table9, waveQuest.prizes);
/*      */       
/* 1021 */       table7.add((Actor)table9).fillX().expandX().padTop(8.0F).padBottom(8.0F).row();
/* 1022 */       table6.add((Actor)table7).padBottom(4.0F).fillX().expandX().row(); }
/*      */     
/* 1024 */     RectButton rectButton1 = new RectButton("Add wave quest", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */           String str = "W:" + this.c.name + ":";
/*      */           int i = 0;
/*      */           for (byte b = 0; b < this.c.waveQuests.size; b++) {
/*      */             BasicLevel.WaveQuest waveQuest1;
/*      */             String[] arrayOfString = (waveQuest1 = ((BasicLevel.WaveQuest[])this.c.waveQuests.items)[b]).id.split(":");
/*      */             int j = 0;
/*      */             try {
/*      */               j = Integer.parseInt(arrayOfString[arrayOfString.length - 1]);
/* 1033 */             } catch (Exception exception) {}
/*      */             if (j > i) {
/*      */               i = j;
/*      */             }
/*      */           } 
/*      */           str = str + (i + 1);
/*      */           BasicLevel.WaveQuest waveQuest = new BasicLevel.WaveQuest(this.c, str, 1);
/*      */           this.c.waveQuests.add(waveQuest);
/*      */           c();
/*      */         });
/* 1043 */     this.e.add((Actor)rectButton1).size(200.0F, 48.0F).top().left().row();
/* 1044 */     d();
/*      */     
/* 1046 */     b("Quests");
/* 1047 */     table3 = new Table();
/* 1048 */     this.e.add((Actor)table3).top().left().pad(10.0F, 0.0F, 10.0F, 0.0F).fillX().expandX().top().left().row();
/*      */     
/* 1050 */     for (Array.ArrayIterator<BasicLevelQuestConfig> arrayIterator2 = this.c.quests.iterator(); arrayIterator2.hasNext(); ) { BasicLevelQuestConfig basicLevelQuestConfig = arrayIterator2.next();
/*      */       Table table7;
/* 1052 */       (table7 = new Table()).setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.14F)));
/*      */       
/* 1054 */       Table table8 = new Table();
/* 1055 */       table7.add((Actor)table8).width(220.0F).align(10).padLeft(15.0F).padRight(15.0F).padTop(10.0F).top().left();
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform1;
/* 1058 */       (textFieldXPlatform1 = new TextFieldXPlatform(basicLevelQuestConfig.id, this.h)).addListener((EventListener)new ChangeListener(this, basicLevelQuestConfig, textFieldXPlatform1)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1061 */               this.a.id = this.b.getText();
/*      */             }
/*      */           });
/* 1064 */       table8.add((Actor)textFieldXPlatform1).size(220.0F, 40.0F).align(1);
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
/* 1076 */       table8.row();
/*      */ 
/*      */ 
/*      */       
/*      */       ComplexButton complexButton;
/*      */ 
/*      */ 
/*      */       
/* 1084 */       (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(21), () -> Dialog.i().showConfirm("Delete quest?", ()))).setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 40.0F, 40.0F);
/* 1085 */       complexButton.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, Color.GRAY);
/* 1086 */       complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 4.0F, 4.0F, 32.0F, 32.0F);
/* 1087 */       table8.add((Actor)complexButton).padTop(10.0F).size(40.0F, 40.0F).left();
/*      */       
/* 1089 */       table8 = new Table();
/* 1090 */       table7.add((Actor)table8).expandX().fillX().padLeft(15.0F).padRight(15.0F).padTop(10.0F).top().left();
/*      */       
/* 1092 */       Table table9 = new Table();
/* 1093 */       LabelToggleButton labelToggleButton1 = a(false, "Scripted", basicLevelQuestConfig.scripted, paramBoolean -> paramBasicLevelQuestConfig.scripted = paramBoolean.booleanValue());
/*      */ 
/*      */       
/* 1096 */       table9.add((Actor)labelToggleButton1);
/*      */       
/* 1098 */       LabelToggleButton labelToggleButton2 = a(false, "One game", basicLevelQuestConfig.duringGame, paramBoolean -> paramBasicLevelQuestConfig.duringGame = paramBoolean.booleanValue());
/*      */ 
/*      */       
/* 1101 */       table9.add((Actor)labelToggleButton2).padLeft(15.0F);
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform2;
/* 1104 */       (textFieldXPlatform2 = new TextFieldXPlatform((basicLevelQuestConfig.scriptedTitle == null) ? "" : basicLevelQuestConfig.scriptedTitle, this.h)).addListener((EventListener)new ChangeListener(this, textFieldXPlatform2, basicLevelQuestConfig)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1107 */               if (this.a.getText().length() == 0) {
/* 1108 */                 this.b.scriptedTitle = null; return;
/*      */               } 
/* 1110 */               this.b.scriptedTitle = this.a.getText();
/*      */             }
/*      */           });
/*      */       
/* 1114 */       textFieldXPlatform2.setMessageText("Scripted alias");
/* 1115 */       table9.add((Actor)textFieldXPlatform2).padLeft(15.0F).size(260.0F, 40.0F);
/*      */       
/* 1117 */       table9.add().height(1.0F).expandX().fillX();
/*      */       
/* 1119 */       table8.add((Actor)table9).expandX().fillX().row();
/*      */       
/* 1121 */       table9 = new Table();
/*      */       SelectBox selectBox;
/* 1123 */       (selectBox = new SelectBox(this.g)).setItems(new Array((Object[])StatisticsType.values));
/* 1124 */       selectBox.setSelected(basicLevelQuestConfig.statisticsType);
/* 1125 */       selectBox.addListener((EventListener)new ChangeListener(this, basicLevelQuestConfig, selectBox)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1128 */               this.a.statisticsType = (StatisticsType)this.b.getSelected();
/*      */             }
/*      */           });
/* 1131 */       table9.add((Actor)selectBox).size(340.0F, 40.0F);
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform3;
/* 1134 */       (textFieldXPlatform3 = new TextFieldXPlatform(String.valueOf(basicLevelQuestConfig.requiredValue), this.h)).addListener((EventListener)new ChangeListener(this, basicLevelQuestConfig, textFieldXPlatform3)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/* 1138 */                 this.a.requiredValue = Long.parseLong(this.b.getText()); return;
/* 1139 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/* 1142 */       table9.add((Actor)textFieldXPlatform3).size(160.0F, 40.0F).padLeft(15.0F);
/*      */       
/* 1144 */       table9.add().height(1.0F).expandX().fillX();
/* 1145 */       table8.add((Actor)table9).expandX().fillX().padTop(10.0F).row();
/*      */       
/* 1147 */       table9 = new Table();
/* 1148 */       a(table9, basicLevelQuestConfig.prizes);
/*      */       
/* 1150 */       table8.add((Actor)table9).fillX().expandX().padTop(8.0F).padBottom(8.0F);
/* 1151 */       table3.add((Actor)table7).padBottom(4.0F).fillX().expandX().row(); }
/*      */     
/* 1153 */     RectButton rectButton4 = new RectButton("Add quest", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */           String str = "Q:" + this.c.name + ":";
/*      */           int i = 0;
/*      */           for (byte b = 0; b < this.c.quests.size; b++) {
/*      */             BasicLevelQuestConfig basicLevelQuestConfig1;
/*      */             String[] arrayOfString = (basicLevelQuestConfig1 = ((BasicLevelQuestConfig[])this.c.quests.items)[b]).id.split(":");
/*      */             int j = 0;
/*      */             try {
/*      */               j = Integer.parseInt(arrayOfString[arrayOfString.length - 1]);
/* 1162 */             } catch (Exception exception) {}
/*      */             if (j > i) {
/*      */               i = j;
/*      */             }
/*      */           } 
/*      */           str = str + (i + 1);
/*      */           BasicLevelQuestConfig basicLevelQuestConfig = new BasicLevelQuestConfig(str, false, StatisticsType.PT, 360L, true, this.c);
/*      */           this.c.quests.add(basicLevelQuestConfig);
/*      */           c();
/*      */         });
/* 1172 */     this.e.add((Actor)rectButton4).size(200.0F, 48.0F).top().left().row();
/* 1173 */     d();
/*      */     
/* 1175 */     this.e.add().row();
/* 1176 */     this.e.add().width(1.0F).height(80.0F).row();
/* 1177 */     this.e.add().expand().fill().row();
/*      */   }
/*      */   
/*      */   private void a(Table paramTable, Array<ItemStack> paramArray) {
/* 1181 */     for (byte b = 0; b < paramArray.size; b++) {
/* 1182 */       ItemStack itemStack = ((ItemStack[])paramArray.items)[b];
/*      */       Group group;
/* 1184 */       (group = new Group()).setTransform(false);
/* 1185 */       paramTable.add((Actor)group).size(96.0F, 144.0F);
/*      */       
/*      */       ItemCell itemCell;
/* 1188 */       (itemCell = new ItemCell()).setCompact();
/* 1189 */       itemCell.setColRow(b, 0);
/* 1190 */       itemCell.setItem(itemStack.getItem(), 0);
/* 1191 */       itemCell.setPosition(0.0F, 32.0F);
/* 1192 */       itemCell.addListener((EventListener)new ClickListener(this, itemStack)
/*      */           {
/*      */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 1195 */               ItemCreationOverlay.i().showForItemListenable(this.a.getItem(), param1Item -> { param1ItemStack.setItem(param1Item); LevelConfigurationEditor.c(this.b); }true);
/*      */             }
/*      */           });
/*      */ 
/*      */ 
/*      */       
/* 1201 */       group.addActor((Actor)itemCell);
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform;
/* 1204 */       (textFieldXPlatform = new TextFieldXPlatform(String.valueOf(itemStack.getCount()), this.h)).setSize(92.0F, 30.0F);
/* 1205 */       textFieldXPlatform.addListener((EventListener)new ChangeListener(this, itemStack, textFieldXPlatform)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/* 1209 */                 this.a.setCount(Integer.parseInt(this.b.getText())); return;
/* 1210 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/* 1213 */       group.addActor((Actor)textFieldXPlatform);
/*      */ 
/*      */       
/*      */       RectButton rectButton;
/*      */ 
/*      */       
/* 1219 */       (rectButton = new RectButton("", Game.i.assetManager.getLabelStyle(24), () -> { paramArray.removeValue(paramItemStack, true); c(); })).setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 32.0F, 32.0F);
/* 1220 */       rectButton.setBackgroundColors(MaterialColor.RED.P800, MaterialColor.RED.P900, MaterialColor.RED.P700, Color.GRAY);
/* 1221 */       rectButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 3.0F, 3.0F, 24.0F, 24.0F);
/* 1222 */       rectButton.setSize(30.0F, 30.0F);
/* 1223 */       rectButton.setPosition(66.0F, 112.0F);
/* 1224 */       group.addActor((Actor)rectButton);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ComplexButton complexButton;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1237 */     (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> { ItemStack itemStack = new ItemStack((Item)Item.D.GREEN_PAPER, 100); paramArray.add(itemStack); c(); ItemCreationOverlay.i().showForItemListenable(itemStack.getItem(), (), true); })).setBackground((Drawable)Game.i.assetManager.getDrawable((paramArray.size % 2 == 0) ? "item-cell-a-shape" : "item-cell-b-shape"), 0.0F, 0.0F, 96.0F, 105.0F);
/* 1238 */     complexButton.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.28F), new Color(0.0F, 0.0F, 0.0F, 0.56F), new Color(1.0F, 1.0F, 1.0F, 0.14F), Color.GRAY);
/* 1239 */     complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-plus"), 32.0F, 36.5F, 32.0F, 32.0F);
/* 1240 */     paramTable.add((Actor)complexButton).size(96.0F, 105.0F).padBottom(28.0F);
/*      */     
/* 1242 */     paramTable.add().height(1.0F).expandX().fillX();
/*      */   }
/*      */   
/*      */   public static void requirements(Array<Requirement> paramArray, Table paramTable, SelectBox.SelectBoxStyle paramSelectBoxStyle, TextField.TextFieldStyle paramTextFieldStyle, Runnable paramRunnable) {
/* 1246 */     for (byte b = 0; b < paramArray.size; b++) {
/* 1247 */       SelectBox selectBox1; TextFieldXPlatform textFieldXPlatform2; Array array; TextFieldXPlatform textFieldXPlatform1; byte b4; TextFieldXPlatform textFieldXPlatform4; byte b3; TextFieldXPlatform textFieldXPlatform3; byte b2; Requirement requirement = (Requirement)paramArray.get(b);
/*      */       
/* 1249 */       Table table1 = new Table();
/*      */       
/* 1251 */       Table table2 = new Table();
/* 1252 */       table1.add((Actor)table2).expandX().fillX().height(48.0F).padBottom(4.0F);
/*      */       
/*      */       SelectBox selectBox2;
/* 1255 */       (selectBox2 = new SelectBox(paramSelectBoxStyle)).setItems((Object[])RequirementType.values);
/* 1256 */       selectBox2.setSelected(requirement.type);
/* 1257 */       selectBox2.addListener((EventListener)new ChangeListener(requirement, selectBox2, paramRunnable)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1260 */               this.a.setType((RequirementType)this.b.getSelected());
/* 1261 */               this.c.run();
/*      */             }
/*      */           });
/* 1264 */       table2.add((Actor)selectBox2).size(250.0F, 48.0F).top().left();
/*      */       
/* 1266 */       byte b1 = b;
/*      */ 
/*      */       
/*      */       PaddedImageButton paddedImageButton;
/*      */       
/* 1271 */       (paddedImageButton = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> { paramArray.removeIndex(paramInt); paramRunnable.run(); }MaterialColor.ORANGE.P500, MaterialColor.ORANGE.P400, MaterialColor.ORANGE.P700)).setIconSize(32.0F, 32.0F);
/* 1272 */       paddedImageButton.setIconPosition(8.0F, 8.0F);
/* 1273 */       table1.add((Actor)paddedImageButton).size(48.0F).row();
/*      */       
/* 1275 */       switch (null.a[requirement.type.ordinal()]) {
/*      */         
/*      */         case 1:
/* 1278 */           (selectBox1 = new SelectBox(paramSelectBoxStyle)).setItems((Object[])ResearchType.values);
/* 1279 */           selectBox1.setSelected(requirement.researchType);
/* 1280 */           selectBox1.addListener((EventListener)new ChangeListener(requirement, selectBox1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1283 */                   this.a.researchType = (ResearchType)this.b.getSelected();
/*      */                 }
/*      */               });
/* 1286 */           table2.add((Actor)selectBox1).size(400.0F, 48.0F).top().left().padLeft(4.0F);
/*      */ 
/*      */           
/* 1289 */           (textFieldXPlatform2 = new TextFieldXPlatform(requirement.researchLevel, paramTextFieldStyle)).setSize(100.0F, 64.0F);
/* 1290 */           textFieldXPlatform2.setMessageText("Level");
/* 1291 */           table2.add((Actor)textFieldXPlatform2).top().left().size(200.0F, 48.0F).padLeft(4.0F);
/* 1292 */           textFieldXPlatform2.addListener((EventListener)new ChangeListener(requirement, textFieldXPlatform2)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/* 1296 */                     this.a.researchLevel = Integer.parseInt(this.b.getText()); return;
/* 1297 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   } 
/*      */                 }
/*      */               });
/*      */           break;
/*      */         case 2:
/* 1304 */           selectBox1 = new SelectBox(paramSelectBoxStyle);
/* 1305 */           array = new Array(String.class);
/* 1306 */           for (b4 = 0; b4 < Game.i.basicLevelManager.levelsOrdered.size; b4++) {
/* 1307 */             BasicLevel basicLevel = ((BasicLevel[])Game.i.basicLevelManager.levelsOrdered.items)[b4];
/* 1308 */             array.add(basicLevel.name);
/*      */           } 
/* 1310 */           selectBox1.setItems(array);
/* 1311 */           selectBox1.setSelected(requirement.levelName);
/* 1312 */           selectBox1.addListener((EventListener)new ChangeListener(requirement, selectBox1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1315 */                   this.a.levelName = (String)this.b.getSelected();
/*      */                 }
/*      */               });
/* 1318 */           table2.add((Actor)selectBox1).size(400.0F, 48.0F).top().left().padLeft(4.0F);
/*      */ 
/*      */           
/* 1321 */           (textFieldXPlatform4 = new TextFieldXPlatform(requirement.levelStars, paramTextFieldStyle)).setSize(100.0F, 64.0F);
/* 1322 */           textFieldXPlatform4.setMessageText("Stars");
/* 1323 */           table2.add((Actor)textFieldXPlatform4).top().left().size(200.0F, 48.0F).padLeft(4.0F);
/* 1324 */           textFieldXPlatform4.addListener((EventListener)new ChangeListener(requirement, textFieldXPlatform4)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/* 1328 */                     this.a.levelStars = Integer.parseInt(this.b.getText()); return;
/* 1329 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   } 
/*      */                 }
/*      */               });
/*      */           break;
/*      */         case 3:
/* 1336 */           selectBox1 = new SelectBox(paramSelectBoxStyle);
/* 1337 */           array = new Array(String.class);
/* 1338 */           for (b3 = 0; b3 < Game.i.basicLevelManager.stagesOrdered.size; b3++) {
/* 1339 */             BasicLevelStage basicLevelStage = ((BasicLevelStage[])Game.i.basicLevelManager.stagesOrdered.items)[b3];
/* 1340 */             array.add(basicLevelStage.name);
/*      */           } 
/* 1342 */           selectBox1.setItems(array);
/* 1343 */           selectBox1.setSelected(requirement.stageName);
/* 1344 */           selectBox1.addListener((EventListener)new ChangeListener(requirement, selectBox1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1347 */                   this.a.stageName = (String)this.b.getSelected();
/*      */                 }
/*      */               });
/* 1350 */           table2.add((Actor)selectBox1).size(400.0F, 48.0F).top().left().padLeft(4.0F);
/*      */ 
/*      */           
/* 1353 */           (textFieldXPlatform3 = new TextFieldXPlatform(requirement.stageStars, paramTextFieldStyle)).setSize(100.0F, 64.0F);
/* 1354 */           textFieldXPlatform3.setMessageText("Stars");
/* 1355 */           table2.add((Actor)textFieldXPlatform3).top().left().size(200.0F, 48.0F).padLeft(4.0F);
/* 1356 */           textFieldXPlatform3.addListener((EventListener)new ChangeListener(requirement, textFieldXPlatform3)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/* 1360 */                     this.a.stageStars = Integer.parseInt(this.b.getText()); return;
/* 1361 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   } 
/*      */                 }
/*      */               });
/*      */           break;
/*      */         case 4:
/* 1368 */           selectBox1 = new SelectBox(paramSelectBoxStyle);
/* 1369 */           array = new Array(String.class);
/* 1370 */           for (b2 = 0; b2 < Game.i.basicLevelManager.levelsOrdered.size; b2++) {
/* 1371 */             BasicLevel basicLevel = ((BasicLevel[])Game.i.basicLevelManager.levelsOrdered.items)[b2];
/* 1372 */             array.add(basicLevel.name);
/*      */           } 
/* 1374 */           selectBox1.setItems(array);
/* 1375 */           selectBox1.setSelected(requirement.openedLevelName);
/* 1376 */           selectBox1.addListener((EventListener)new ChangeListener(requirement, selectBox1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1379 */                   this.a.openedLevelName = (String)this.b.getSelected();
/*      */                 }
/*      */               });
/* 1382 */           table2.add((Actor)selectBox1).size(400.0F, 48.0F).top().left().padLeft(4.0F);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 5:
/* 1388 */           (selectBox1 = new SelectBox(paramSelectBoxStyle)).setItems((Object[])StatisticsType.values);
/* 1389 */           selectBox1.setSelected(requirement.statisticsType);
/* 1390 */           selectBox1.addListener((EventListener)new ChangeListener(requirement, selectBox1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1393 */                   this.a.statisticsType = (StatisticsType)this.b.getSelected();
/*      */                 }
/*      */               });
/* 1396 */           table2.add((Actor)selectBox1).size(400.0F, 48.0F).top().left().padLeft(4.0F);
/*      */ 
/*      */           
/* 1399 */           (textFieldXPlatform1 = new TextFieldXPlatform(requirement.statisticsValue, paramTextFieldStyle)).setSize(100.0F, 64.0F);
/* 1400 */           textFieldXPlatform1.setMessageText("Value");
/* 1401 */           table2.add((Actor)textFieldXPlatform1).top().left().size(200.0F, 48.0F).padLeft(4.0F);
/* 1402 */           textFieldXPlatform1.addListener((EventListener)new ChangeListener(requirement, textFieldXPlatform1)
/*      */               {
/*      */                 public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */                   try {
/* 1406 */                     this.a.statisticsValue = Double.parseDouble(this.b.getText()); return;
/* 1407 */                   } catch (Exception exception) {
/*      */                     return;
/*      */                   } 
/*      */                 }
/*      */               });
/*      */           break;
/*      */       } 
/*      */       
/* 1415 */       table2.add().height(1.0F).expandX().fillX();
/*      */       
/* 1417 */       paramTable.add((Actor)table1).fillX().expandX().padRight(8.0F).row();
/*      */     } 
/*      */     
/* 1420 */     RectButton rectButton = new RectButton("Add requirement", Game.i.assetManager.getLabelStyle(24), () -> {
/*      */           Requirement requirement;
/*      */           (requirement = new Requirement()).type = RequirementType.ALL_TIME_STATISTIC;
/*      */           requirement.statisticsType = StatisticsType.WIP;
/*      */           requirement.statisticsValue = 1.0D;
/*      */           paramArray.add(requirement);
/*      */           paramRunnable.run();
/*      */         });
/* 1428 */     paramTable.add((Actor)rectButton).size(200.0F, 48.0F).top().left().row();
/*      */   }
/*      */   
/*      */   public final Label hint(String paramString) {
/*      */     Label label;
/* 1433 */     (label = new Label(paramString, Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1434 */     label.setWrap(true);
/* 1435 */     label.setAlignment(8);
/* 1436 */     this.e.add((Actor)label).top().left().pad(-6.0F, 0.0F, 10.0F, 0.0F).top().left().width(900.0F).row();
/*      */     
/* 1438 */     return label;
/*      */   }
/*      */   
/*      */   private LabelToggleButton a(String paramString, boolean paramBoolean, ObjectConsumer<Boolean> paramObjectConsumer) {
/* 1442 */     return a(true, paramString, paramBoolean, paramObjectConsumer);
/*      */   }
/*      */   
/*      */   private LabelToggleButton a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ObjectConsumer<Boolean> paramObjectConsumer) {
/* 1446 */     LabelToggleButton labelToggleButton = new LabelToggleButton(paramString, paramBoolean2, 24, 32.0F, paramObjectConsumer);
/* 1447 */     if (paramBoolean1) this.e.add((Actor)labelToggleButton).height(48.0F).top().left().row();
/*      */     
/* 1449 */     return labelToggleButton;
/*      */   }
/*      */   
/*      */   private Label b(String paramString) {
/* 1453 */     Label label = new Label(paramString, Game.i.assetManager.getLabelStyle(24));
/* 1454 */     this.e.add((Actor)label).top().left().pad(10.0F, 0.0F, 10.0F, 0.0F).top().left().row();
/*      */     
/* 1456 */     return label;
/*      */   }
/*      */   
/*      */   private void a(SelectBox paramSelectBox) {
/* 1460 */     this.e.add((Actor)paramSelectBox).size(400.0F, 48.0F).top().left().row();
/*      */   }
/*      */   
/*      */   private void d() {
/* 1464 */     this.e.add().width(1.0F).height(10.0F).row();
/*      */   }
/*      */   
/*      */   public final TextFieldXPlatform textField(String paramString, ObjectConsumer<String> paramObjectConsumer) {
/*      */     TextFieldXPlatform textFieldXPlatform;
/* 1469 */     (textFieldXPlatform = new TextFieldXPlatform(paramString, this.h)).setSize(400.0F, 64.0F);
/* 1470 */     this.e.add((Actor)textFieldXPlatform).top().left().size(300.0F, 48.0F).row();
/* 1471 */     textFieldXPlatform.addListener((EventListener)new ChangeListener(this, paramObjectConsumer, textFieldXPlatform)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 1474 */             this.a.accept(this.b.getText());
/*      */           }
/*      */         });
/*      */     
/* 1478 */     return textFieldXPlatform;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void hide() {
/* 1483 */     DarkOverlay.i().removeCaller("LevelConfigurationEditor");
/* 1484 */     this.b.getTable().setVisible(false);
/*      */     
/* 1486 */     Game.i.uiManager.stage.unfocusAll();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\LevelConfigurationEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */