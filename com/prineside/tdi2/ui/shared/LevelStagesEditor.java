/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.BasicLevelStage;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.CheckBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.ObjectConsumer;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class LevelStagesEditor extends UiManager.UiComponent.Adapter {
/*  33 */   private static final TLog a = TLog.forClass(LevelStagesEditor.class);
/*     */   public static LevelStagesEditor i() {
/*  35 */     return (LevelStagesEditor)Game.i.uiManager.getComponent(LevelStagesEditor.class);
/*     */   }
/*     */ 
/*     */   
/*  39 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 142, "LevelStagesEditor main");
/*     */   
/*     */   private CheckBox.CheckBoxStyle c;
/*     */   
/*     */   private SelectBox.SelectBoxStyle d;
/*     */   
/*     */   private TextField.TextFieldStyle e;
/*     */   private BasicLevelStage f;
/*     */   private Table g;
/*     */   private Table h;
/*     */   
/*     */   public LevelStagesEditor() {
/*  51 */     this
/*     */ 
/*     */       
/*  54 */       .c = new CheckBox.CheckBoxStyle(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.RED.P500), Game.i.assetManager.getDrawable("blank").tint(MaterialColor.GREEN.P500), (BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE);
/*     */ 
/*     */     
/*  57 */     this.c.checkboxOff.setLeftWidth(24.0F);
/*  58 */     this.c.checkboxOff.setBottomHeight(24.0F);
/*     */     
/*  60 */     this.d = Game.i.assetManager.getSelectBoxStyle((BitmapFont)Game.i.assetManager.getFont(24), true);
/*  61 */     this.e = Game.i.assetManager.getTextFieldStyle(24);
/*     */     
/*     */     Group group1;
/*     */     
/*  65 */     (group1 = new Group()).setTransform(false);
/*  66 */     this.b.getTable().add((Actor)group1).size(1200.0F, 1000.0F);
/*     */     
/*     */     Image image;
/*  69 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(1200.0F, 1000.0F);
/*  70 */     image.setColor(new Color(858993663));
/*  71 */     group1.addActor((Actor)image);
/*     */ 
/*     */     
/*  74 */     this.g = new Table();
/*     */     ScrollPane scrollPane;
/*  76 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.g, Game.i.assetManager.getScrollPaneStyle(8.0F)));
/*  77 */     scrollPane.setSize(240.0F, 1000.0F);
/*  78 */     scrollPane.setScrollingDisabled(true, false);
/*  79 */     group1.addActor((Actor)scrollPane);
/*     */     
/*  81 */     a();
/*     */     
/*  83 */     this.h = new Table();
/*  84 */     this.h.setSize(900.0F, 906.0F);
/*     */     
/*  86 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.h, Game.i.assetManager.getScrollPaneStyle(16.0F)));
/*  87 */     scrollPane.setSize(940.0F, 906.0F);
/*  88 */     scrollPane.setPosition(260.0F, 84.0F);
/*  89 */     group1.addActor((Actor)scrollPane);
/*     */     
/*     */     Group group2;
/*     */     
/*  93 */     (group2 = new Group()).setTransform(false);
/*  94 */     group2.setPosition(250.0F, 10.0F);
/*  95 */     group1.addActor((Actor)group2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RectButton rectButton;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     (rectButton = new RectButton("Save", Game.i.assetManager.getLabelStyle(24), () -> { Game.i.basicLevelManager.saveStagesConfigOnDisk(); Label label; (label = new Label("Done!", Game.i.assetManager.getLabelStyle(24))).setColor(MaterialColor.GREEN.P500); label.setPosition(740.0F, 0.0F); label.setSize(200.0F, 64.0F); label.setAlignment(1); label.setTouchable(Touchable.disabled); paramGroup.addActor((Actor)label); label.addAction((Action)Actions.sequence((Action)Actions.moveBy(0.0F, 64.0F, 0.3F, (Interpolation)Interpolation.exp5Out), (Action)Actions.fadeOut(0.2F), (Action)Actions.removeActor())); b(); })).setSize(200.0F, 64.0F);
/* 116 */     rectButton.setPosition(740.0F, 0.0F);
/* 117 */     group2.addActor((Actor)rectButton);
/*     */     
/* 119 */     b();
/*     */     
/* 121 */     hide();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPersistent() {
/* 126 */     return true;
/*     */   }
/*     */   
/*     */   public void show() {
/* 130 */     if (!Config.isModdingMode() && !Game.i.progressManager.isDeveloperModeEnabled()) {
/* 131 */       Dialog.i().showAlert("Developer mode research required");
/*     */       
/*     */       return;
/*     */     } 
/* 135 */     DarkOverlay.i().addCallerOverlayLayer("LevelStagesEditor", this.b.zIndex - 1, () -> {
/*     */           hide();
/*     */           return true;
/*     */         });
/* 139 */     b();
/* 140 */     this.b.getTable().setVisible(true);
/*     */   }
/*     */   
/*     */   private void a() {
/* 144 */     this.g.clear();
/*     */     
/* 146 */     for (Array.ArrayIterator<BasicLevelStage> arrayIterator = Game.i.basicLevelManager.stagesOrdered.iterator(); arrayIterator.hasNext(); ) { BasicLevelStage basicLevelStage = arrayIterator.next();
/* 147 */       RectButton rectButton1 = new RectButton(basicLevelStage.name + " - " + basicLevelStage.getTitle(), Game.i.assetManager.getLabelStyle(24), () -> {
/*     */             this.f = paramBasicLevelStage;
/*     */             b();
/*     */           });
/* 151 */       if (this.f == basicLevelStage) {
/* 152 */         rectButton1.setBackgroundColors(Color.WHITE, Color.WHITE, Color.WHITE, MaterialColor.AMBER.P900);
/* 153 */         rectButton1.setEnabled(false);
/*     */       } 
/* 155 */       rectButton1.setIconLabelColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/* 156 */       this.g.add((Actor)rectButton1).size(240.0F, 48.0F).padBottom(2.0F).row(); }
/*     */ 
/*     */     
/* 159 */     this.g.add().width(1.0F).growY().row();
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
/*     */     RectButton rectButton;
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
/* 188 */     (rectButton = new RectButton("Add stage", Game.i.assetManager.getLabelStyle(24), () -> Game.i.uiManager.getTextInput(new Input.TextInputListener(this) { public void input(String param1String) { Threads.i().runOnMainThread(() -> { if (param1String.length() < 2 || param1String.contains("/") || param1String.contains("\\")) { Dialog.i().showAlert("0-9, a-Z and dot, minimum 2 characters"); return; }  if (Game.i.basicLevelManager.getStage(param1String) != null) { Dialog.i().showAlert("Stage with this name already exists"); return; }  BasicLevelStage basicLevelStage = new BasicLevelStage(param1String, Color.WHITE, "New stage"); Game.i.basicLevelManager.addStage(basicLevelStage); LevelStagesEditor.a(this.a, basicLevelStage); LevelStagesEditor.a(this.a); }); } public void canceled() {} }"Stage ID", "", "0-9, a-Z and dot, minimum 2 characters. ID can't be changed, choose wisely"))).setIconLabelColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/* 189 */     rectButton.setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.WHITE);
/* 190 */     this.g.add((Actor)rectButton).size(240.0F, 48.0F).padBottom(2.0F).padTop(8.0F).row();
/*     */   }
/*     */   
/*     */   private void b() {
/* 194 */     this.h.clearChildren();
/*     */     
/* 196 */     if (this.f == null) {
/* 197 */       this.f = (BasicLevelStage)Game.i.basicLevelManager.stagesOrdered.first();
/*     */     }
/*     */     
/* 200 */     a();
/*     */     
/*     */     Group group;
/*     */     
/* 204 */     (group = new Group()).setTransform(false);
/* 205 */     this.h.add((Actor)group).expandX().fillX().padTop(20.0F).height(40.0F).row();
/*     */     
/*     */     Table table2;
/* 208 */     (table2 = new Table()).setSize(700.0F, 40.0F);
/* 209 */     table2.setPosition(200.0F, 0.0F);
/* 210 */     group.addActor((Actor)table2);
/*     */     
/*     */     Table table1;
/* 213 */     (table1 = new Table()).add().height(1.0F).growX();
/* 214 */     table2.add((Actor)table1).growX().row();
/*     */     
/* 216 */     RectButton rectButton = new RectButton("Up", Game.i.assetManager.getLabelStyle(21), () -> {
/*     */           int i;
/*     */           if ((i = Game.i.basicLevelManager.stagesOrdered.indexOf(this.f, true)) > 0) {
/*     */             Game.i.basicLevelManager.stagesOrdered.swap(i, i - 1);
/*     */             b();
/*     */           } 
/*     */         });
/* 223 */     table1.add((Actor)rectButton).size(150.0F, 32.0F).padLeft(10.0F);
/* 224 */     if (Game.i.basicLevelManager.stagesOrdered.indexOf(this.f, true) == 0) {
/* 225 */       rectButton.setEnabled(false);
/*     */     }
/*     */     
/* 228 */     rectButton = new RectButton("Down", Game.i.assetManager.getLabelStyle(21), () -> {
/*     */           int i;
/*     */           if ((i = Game.i.basicLevelManager.stagesOrdered.indexOf(this.f, true)) < Game.i.basicLevelManager.stagesOrdered.size - 1) {
/*     */             Game.i.basicLevelManager.stagesOrdered.swap(i, i + 1);
/*     */             b();
/*     */           } 
/*     */         });
/* 235 */     table1.add((Actor)rectButton).size(150.0F, 32.0F).padLeft(10.0F);
/* 236 */     if (Game.i.basicLevelManager.stagesOrdered.indexOf(this.f, true) == Game.i.basicLevelManager.stagesOrdered.size - 1) {
/* 237 */       rectButton.setEnabled(false);
/*     */     }
/*     */     
/* 240 */     rectButton = new RectButton("Delete", Game.i.assetManager.getLabelStyle(21), () -> {
/*     */           if (this.f.levels.size != 0) {
/*     */             Notifications.i().addFailure(this.f.levels.size + " levels are assigned to this stage, can't delete it");
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/*     */           Dialog.i().showConfirm("Delete this stage?", ());
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 256 */     table1.add((Actor)rectButton).size(150.0F, 32.0F).padLeft(10.0F);
/*     */     
/* 258 */     a("Stage ID");
/* 259 */     hint("Levels will refer to this stage by its ID");
/* 260 */     textField(this.f.name, paramString -> {
/*     */           this.f.name = paramString;
/*     */           a();
/*     */         });
/* 264 */     c();
/*     */     
/* 266 */     a("Stage title");
/* 267 */     hint("String alias (from i18n) or a regular string (which won't be translated)");
/* 268 */     textField(this.f.titleAlias, paramString -> {
/*     */           this.f.titleAlias = paramString;
/*     */           a();
/*     */         });
/* 272 */     c();
/*     */     
/* 274 */     a("Color");
/* 275 */     textField(this.f.color.toString().substring(0, 6), paramString -> {
/*     */           try {
/*     */             Color.rgb888ToColor(this.f.color, Integer.parseInt(paramString, 16)); a();
/*     */             return;
/* 279 */           } catch (Exception exception) {
/*     */             a.e("invalid value: " + paramString, new Object[] { exception }); return;
/*     */           } 
/*     */         });
/* 283 */     c();
/*     */     
/* 285 */     a("Is regular", this.f.regular, paramBoolean -> {
/*     */           this.f.regular = paramBoolean.booleanValue();
/*     */           a();
/*     */         });
/* 289 */     hint("If stage is not regular, it won't be affected by quest difficulty research, its quests will not count towards quests prestige, its quests can not be skipped with accelerators, its quests won't be used for daily quests");
/*     */     
/* 291 */     a("Visibility requirements");
/* 292 */     LevelConfigurationEditor.requirements(this.f.showRequirements, this.h, this.d, this.e, this::b);
/*     */     
/* 294 */     this.h.row();
/* 295 */     this.h.add().width(1.0F).growY().row();
/*     */   }
/*     */   
/*     */   public Label hint(String paramString) {
/*     */     Label label;
/* 300 */     (label = new Label(paramString, Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 301 */     label.setWrap(true);
/* 302 */     label.setAlignment(8);
/* 303 */     this.h.add((Actor)label).top().left().pad(-6.0F, 0.0F, 10.0F, 0.0F).top().left().width(900.0F).row();
/*     */     
/* 305 */     return label;
/*     */   }
/*     */   
/*     */   private LabelToggleButton a(String paramString, boolean paramBoolean, ObjectConsumer<Boolean> paramObjectConsumer) {
/* 309 */     return a(true, paramString, paramBoolean, paramObjectConsumer);
/*     */   }
/*     */   
/*     */   private LabelToggleButton a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ObjectConsumer<Boolean> paramObjectConsumer) {
/* 313 */     LabelToggleButton labelToggleButton = new LabelToggleButton(paramString, paramBoolean2, 24, 32.0F, paramObjectConsumer);
/* 314 */     this.h.add((Actor)labelToggleButton).height(48.0F).top().left().row();
/*     */     
/* 316 */     return labelToggleButton;
/*     */   }
/*     */   
/*     */   private Label a(String paramString) {
/* 320 */     Label label = new Label(paramString, Game.i.assetManager.getLabelStyle(24));
/* 321 */     this.h.add((Actor)label).top().left().pad(10.0F, 0.0F, 10.0F, 0.0F).top().left().row();
/*     */     
/* 323 */     return label;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c() {
/* 331 */     this.h.add().width(1.0F).height(10.0F).row();
/*     */   }
/*     */   
/*     */   public TextFieldXPlatform textField(String paramString, ObjectConsumer<String> paramObjectConsumer) {
/*     */     TextFieldXPlatform textFieldXPlatform;
/* 336 */     (textFieldXPlatform = new TextFieldXPlatform(paramString, this.e)).setSize(400.0F, 64.0F);
/* 337 */     this.h.add((Actor)textFieldXPlatform).top().left().size(300.0F, 48.0F).row();
/* 338 */     textFieldXPlatform.addListener((EventListener)new ChangeListener(this, paramObjectConsumer, textFieldXPlatform)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 341 */             this.a.accept(this.b.getText());
/*     */           }
/*     */         });
/*     */     
/* 345 */     return textFieldXPlatform;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 350 */     DarkOverlay.i().removeCaller("LevelStagesEditor");
/* 351 */     this.b.getTable().setVisible(false);
/*     */     
/* 353 */     Game.i.uiManager.stage.unfocusAll();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\LevelStagesEditor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */