/*     */ package com.prineside.tdi2.screens;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.Threads;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.ui.VerticalGroup;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*     */ import com.prineside.tdi2.ui.shared.BackButton;
/*     */ import com.prineside.tdi2.ui.shared.ScreenTitle;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import com.prineside.tdi2.utils.simulation.SimConfig;
/*     */ import com.prineside.tdi2.utils.simulation.SimLogListener;
/*     */ import com.prineside.tdi2.utils.simulation.SimTypeProvider;
/*     */ import com.prineside.tdi2.utils.simulation.Simulation;
/*     */ import com.prineside.tdi2.utils.simulation.providers.PerformanceBenchmarkSimProvider;
/*     */ import com.prineside.tdi2.utils.simulation.providers.SyncCheckSimProvider;
/*     */ import com.prineside.tdi2.utils.simulation.providers.TowerBenchmarkSimProvider;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class SimulationScreen
/*     */   extends Screen
/*     */ {
/*  45 */   public final DelayedRemovalArray<SimEntry> runningSimulations = new DelayedRemovalArray(true, 1, SimEntry.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   public static final HashMap<String, SimTypeProvider> SIM_TYPE_PROVIDERS = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     SimTypeProvider[] arrayOfSimTypeProvider;
/*     */     byte b;
/*  58 */     for (arrayOfSimTypeProvider = arrayOfSimTypeProvider = new SimTypeProvider[] { (SimTypeProvider)new SyncCheckSimProvider(), (SimTypeProvider)new TowerBenchmarkSimProvider(), (SimTypeProvider)new PerformanceBenchmarkSimProvider() }, b = 0; b < 3; ) { SimTypeProvider simTypeProvider = arrayOfSimTypeProvider[b];
/*  59 */       SIM_TYPE_PROVIDERS.put(simTypeProvider.getName(), simTypeProvider);
/*     */       b++; }
/*     */   
/*     */   }
/*  63 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "SimulationScreen main");
/*     */   
/*     */   public SimConfig simConfig;
/*     */   
/*     */   public SelectBox<String> simTypeSelect;
/*     */   
/*     */   public Table formTable;
/*     */   public VerticalGroup simCells;
/*     */   public LabelToggleButton autoNextToggle;
/*     */   
/*     */   public SimulationScreen() {
/*  74 */     Game.i.uiManager.hideAllComponents();
/*  75 */     Game.i.uiManager.setAsInputHandler();
/*     */     
/*  77 */     Game.i.musicManager.stopMusic();
/*     */ 
/*     */     
/*  80 */     ScreenTitle.i()
/*  81 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-lstm-network"))
/*  82 */       .setText("Simulation")
/*  83 */       .setVisible(true);
/*     */     
/*  85 */     BackButton.i()
/*  86 */       .setVisible(true)
/*  87 */       .setText(null)
/*  88 */       .setClickHandler(() -> Game.i.screenManager.goToMainMenu());
/*     */     
/*     */     Table table1;
/*  91 */     (table1 = this.a.getTable()).add().height(1.0F).growX();
/*     */     
/*     */     Table table2;
/*  94 */     (table2 = new Table()).add().width(1.0F).height(40.0F).row();
/*     */     ScrollPane scrollPane2;
/*  96 */     UiUtils.enableMouseMoveScrollFocus(scrollPane2 = new ScrollPane((Actor)table2, Game.i.assetManager.getScrollPaneStyle(10.0F)));
/*  97 */     scrollPane2.setScrollingDisabled(true, false);
/*     */     
/*  99 */     table1.add((Actor)scrollPane2).width(350.0F).growY();
/*     */     
/* 101 */     this.simConfig = new SimConfig();
/* 102 */     this.simConfig.difficultyMode = DifficultyMode.NORMAL;
/* 103 */     this.simConfig.basicLevelName = "sim";
/* 104 */     this.simConfig.startTimestamp = Game.getTimestampMillis();
/*     */     
/*     */     Label label3;
/* 107 */     (label3 = new Label("Difficulty mode", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 108 */     table2.add((Actor)label3).growX().row();
/*     */     
/*     */     SelectBox selectBox2;
/* 111 */     (selectBox2 = new SelectBox(Game.i.assetManager.getSelectBoxStyle(Game.i.assetManager.getDebugFont(false), true))).setItems((Object[])DifficultyMode.values);
/* 112 */     selectBox2.setSelected(DifficultyMode.NORMAL);
/* 113 */     selectBox2.addListener((EventListener)new ChangeListener(this, selectBox2)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 116 */             this.b.simConfig.difficultyMode = (DifficultyMode)this.a.getSelected();
/*     */           }
/*     */         });
/* 119 */     table2.add((Actor)selectBox2).growX().height(40.0F).padBottom(10.0F).row();
/*     */     
/*     */     Label label2;
/* 122 */     (label2 = new Label("Map name", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 123 */     table2.add((Actor)label2).growX().row();
/*     */     
/* 125 */     SelectBox selectBox1 = new SelectBox(Game.i.assetManager.getSelectBoxStyle(Game.i.assetManager.getDebugFont(true), false));
/* 126 */     Array array1 = new Array(true, 1, String.class);
/* 127 */     for (Array.ArrayIterator<BasicLevel> arrayIterator = Game.i.basicLevelManager.levelsOrdered.iterator(); arrayIterator.hasNext(); ) { BasicLevel basicLevel = arrayIterator.next();
/* 128 */       array1.add(basicLevel.name); }
/*     */     
/* 130 */     selectBox1.setItems(array1);
/* 131 */     selectBox1.setSelected("sim");
/* 132 */     selectBox1.addListener((EventListener)new ChangeListener(this, selectBox1)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 135 */             this.b.simConfig.basicLevelName = (String)this.a.getSelected();
/* 136 */             if (Game.i.basicLevelManager.getLevel(this.b.simConfig.basicLevelName) == null) {
/* 137 */               this.a.setColor(Color.RED); return;
/*     */             } 
/* 139 */             this.a.setColor(Color.WHITE);
/*     */           }
/*     */         });
/*     */     
/* 143 */     table2.add((Actor)selectBox1).height(40.0F).growX().padBottom(10.0F).row();
/*     */     
/*     */     Label label1;
/* 146 */     (label1 = new Label("Simulation type", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 147 */     table2.add((Actor)label1).growX().row();
/*     */     
/* 149 */     this.simTypeSelect = new SelectBox(Game.i.assetManager.getSelectBoxStyle(Game.i.assetManager.getDebugFont(true), true));
/* 150 */     Array array2 = new Array();
/* 151 */     for (Map.Entry<String, SimTypeProvider> entry : SIM_TYPE_PROVIDERS.entrySet()) {
/* 152 */       array2.add(entry.getKey());
/*     */     }
/* 154 */     this.simTypeSelect.setItems(array2);
/* 155 */     this.simTypeSelect.addListener((EventListener)new ChangeListener(this)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/* 158 */             this.a.updateForm();
/*     */           }
/*     */         });
/* 161 */     table2.add((Actor)this.simTypeSelect).growX().padBottom(10.0F).height(40.0F).row();
/*     */     
/* 163 */     this.autoNextToggle = new LabelToggleButton("Run next sim on finish", true, 18, 24.0F, false, null);
/* 164 */     table2.add((Actor)this.autoNextToggle).growX().padTop(8.0F).padBottom(4.0F).row();
/*     */     
/*     */     Image image;
/* 167 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(MaterialColor.GREY.P700);
/* 168 */     table2.add((Actor)image).growX().height(1.0F).padBottom(10.0F).row();
/*     */     
/* 170 */     this.formTable = new Table();
/* 171 */     table2.add((Actor)this.formTable).growX().row();
/*     */     
/* 173 */     table2.add().width(1.0F).height(140.0F).row();
/* 174 */     table2.add().width(1.0F).growY();
/*     */ 
/*     */     
/* 177 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(MaterialColor.GREY.P700);
/* 178 */     table1.add((Actor)image).fillY().width(1.0F).padLeft(10.0F).padRight(10.0F);
/*     */     
/* 180 */     this.simCells = new VerticalGroup();
/*     */     ScrollPane scrollPane1;
/* 182 */     UiUtils.enableMouseMoveScrollFocus(scrollPane1 = new ScrollPane((Actor)this.simCells, Game.i.assetManager.getScrollPaneStyle(10.0F)));
/* 183 */     scrollPane1.setScrollingDisabled(true, false);
/* 184 */     table1.add((Actor)scrollPane1).growY().width(1000.0F).padTop(40.0F).padBottom(40.0F);
/*     */     
/* 186 */     table1.add().height(1.0F).growX();
/*     */     
/* 188 */     updateForm();
/*     */   }
/*     */   
/*     */   public void updateForm() {
/* 192 */     this.formTable.clear();
/*     */     
/* 194 */     String str = (String)this.simTypeSelect.getSelected();
/*     */     SimTypeProvider simTypeProvider;
/* 196 */     (simTypeProvider = SIM_TYPE_PROVIDERS.get(str)).prepareSimForm(this);
/*     */   }
/*     */   
/*     */   public void addSimulation(Simulation paramSimulation) {
/*     */     SimEntry simEntry;
/* 201 */     (simEntry = new SimEntry()).simulation = paramSimulation;
/* 202 */     simEntry.uiCell = new RunningSimCell(paramSimulation);
/* 203 */     this.runningSimulations.add(simEntry);
/* 204 */     this.simCells.addActor((Actor)simEntry.uiCell);
/* 205 */     paramSimulation.setSimFinishListener(() -> startNextSim(paramSimulation));
/*     */   }
/*     */   
/*     */   public void startNextSim(Simulation paramSimulation) {
/* 209 */     if (this.autoNextToggle.isEnabled()) {
/* 210 */       for (byte b = 0; b < this.runningSimulations.size; simEntry++) {
/* 211 */         SimEntry simEntry; if (((SimEntry)this.runningSimulations.get(b)).simulation == paramSimulation) {
/*     */           
/* 213 */           for (int i = b + 1; i < this.runningSimulations.size; i++) {
/*     */             
/* 215 */             if (!(simEntry = (SimEntry)this.runningSimulations.get(i)).simulation.isRunning()) {
/* 216 */               simEntry.uiCell.sumRunTime = 0.0D;
/* 217 */               simEntry.simulation.start();
/*     */               return;
/*     */             } 
/*     */           } 
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void stopAllSimulations() {
/* 228 */     for (byte b = 0; b < this.runningSimulations.size; b++) {
/*     */       SimEntry simEntry;
/* 230 */       if ((simEntry = (SimEntry)this.runningSimulations.get(b)).simulation.isRunning()) {
/* 231 */         simEntry.simulation.stop();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(float paramFloat) {
/* 238 */     Color color = Game.i.assetManager.getColor("menu_background");
/* 239 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 240 */     Gdx.gl.glClear(16640);
/*     */     
/* 242 */     if (Game.i.settingsManager.isEscButtonJustPressed())
/*     */     {
/* 244 */       Game.i.screenManager.goToMainMenu();
/*     */     }
/*     */     
/* 247 */     for (byte b = 0; b < this.runningSimulations.size; b++) {
/* 248 */       ((SimEntry)this.runningSimulations.get(b)).uiCell.update();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 254 */     stopAllSimulations();
/*     */     
/* 256 */     super.dispose();
/* 257 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */   
/*     */   public static final class SimEntry {
/*     */     public SimulationScreen.RunningSimCell uiCell;
/*     */     public Simulation simulation;
/*     */   }
/*     */   
/*     */   public static final class RunningSimCell
/*     */     extends Table
/*     */     implements SimLogListener {
/*     */     public Simulation simulation;
/*     */     public Label titleLabel;
/*     */     public Label statusLabel;
/*     */     public Label progressLabel;
/*     */     public Label lastLogMessage;
/*     */     public Image progressBar;
/*     */     public FancyButton startStopButton;
/*     */     public double sumRunTime;
/*     */     
/*     */     public RunningSimCell(Simulation param1Simulation) {
/* 278 */       Preconditions.checkNotNull(param1Simulation);
/* 279 */       this.simulation = param1Simulation;
/*     */       
/*     */       Table table1;
/* 282 */       (table1 = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.BLUE_GREY.P900));
/* 283 */       add((Actor)table1).grow().width(1000.0F).padBottom(5.0F);
/*     */       
/* 285 */       this.titleLabel = new Label(param1Simulation.getName(), Game.i.assetManager.getLabelStyle(21));
/* 286 */       this.titleLabel.setColor(MaterialColor.AMBER.P300);
/* 287 */       this.titleLabel.setWrap(true);
/* 288 */       table1.add((Actor)this.titleLabel).padLeft(10.0F).padRight(10.0F).padTop(10.0F).growX().row();
/*     */       
/* 290 */       Table table2 = new Table();
/* 291 */       table1.add((Actor)table2).pad(10.0F).growX().row();
/*     */       
/* 293 */       table1 = new Table();
/* 294 */       table2.add((Actor)table1).growX();
/*     */       
/* 296 */       this.statusLabel = new Label("", Game.i.assetManager.getLabelStyle(18));
/* 297 */       table1.add((Actor)this.statusLabel).growX().row();
/*     */       
/*     */       Group group;
/* 300 */       (group = new Group()).setTransform(false);
/*     */       
/*     */       Image image;
/* 303 */       (image = new Image(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.56F)))).setSize(700.0F, 24.0F);
/* 304 */       group.addActor((Actor)image);
/*     */       
/* 306 */       this.progressBar = new Image(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.BLUE_GREY.P700));
/* 307 */       this.progressBar.setHeight(24.0F);
/* 308 */       group.addActor((Actor)this.progressBar);
/*     */       
/* 310 */       this.progressLabel = new Label("", Game.i.assetManager.getLabelStyle(18));
/* 311 */       this.progressLabel.setHeight(24.0F);
/* 312 */       this.progressLabel.setPosition(10.0F, 0.0F);
/* 313 */       group.addActor((Actor)this.progressLabel);
/* 314 */       table1.add((Actor)group).width(700.0F).height(24.0F).left().row();
/*     */       
/* 316 */       this.lastLogMessage = new Label("", Game.i.assetManager.getLabelStyle(18));
/* 317 */       this.lastLogMessage.setWrap(true);
/* 318 */       table1.add((Actor)this.lastLogMessage).fillX().padTop(5.0F).row();
/*     */       
/* 320 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 327 */         .startStopButton = (new FancyButton("regularButton.a", () -> { if (param1Simulation.isRunning()) { param1Simulation.stop(); return; }  this.sumRunTime = 0.0D; param1Simulation.start(); })).withLabel(21, "");
/* 328 */       table2.add((Actor)this.startStopButton).size(192.0F, 48.0F).row();
/*     */       
/* 330 */       param1Simulation.setSimLogListener(this);
/*     */       
/* 332 */       update();
/*     */     }
/*     */     
/*     */     public final void update() {
/* 336 */       String str = "";
/* 337 */       if (this.sumRunTime > 0.0D) {
/* 338 */         float f1 = this.simulation.getProgress();
/* 339 */         str = StringFormatter.digestTime((int)this.sumRunTime).toString();
/* 340 */         if (this.simulation.isRunning() && f1 > 0.0F) {
/* 341 */           double d1 = this.sumRunTime / f1;
/* 342 */           double d2 = (1.0F - f1) * d1;
/*     */           
/* 344 */           str = str + ", ETA: " + StringFormatter.digestTime((int)d2);
/*     */         } 
/*     */       } 
/*     */       
/* 348 */       if (this.simulation.isRunning()) {
/* 349 */         this.sumRunTime += Gdx.graphics.getDeltaTime();
/* 350 */         this.statusLabel.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 351 */         this.statusLabel.setText("Running " + str);
/* 352 */         this.startStopButton.label.setText("Stop");
/* 353 */         this.startStopButton.setFlavor("regularRedButton.a");
/*     */       } else {
/* 355 */         if (this.simulation.isSuccessful()) {
/* 356 */           this.statusLabel.setColor(MaterialColor.GREY.P500);
/* 357 */           this.statusLabel.setText("Stopped " + str);
/*     */         } else {
/* 359 */           this.statusLabel.setColor(MaterialColor.ORANGE.P500);
/* 360 */           this.statusLabel.setText("Stopped (error) " + str);
/*     */         } 
/* 362 */         if (this.simulation.isReadyToStart()) {
/* 363 */           this.startStopButton.label.setText("Start");
/* 364 */           this.startStopButton.setEnabled(true);
/* 365 */           this.startStopButton.setFlavor("regularGreenButton.a");
/*     */         } else {
/* 367 */           this.startStopButton.label.setText("Wait...");
/* 368 */           this.startStopButton.setEnabled(false);
/*     */         } 
/*     */       } 
/*     */       float f;
/* 372 */       if ((f = this.simulation.getProgress()) < 1.0E-5F) {
/* 373 */         f = 0.0F;
/*     */       }
/* 375 */       this.progressLabel.setText(StringFormatter.compactNumberWithPrecision((f * 100.0F), 2) + "%");
/* 376 */       this.progressBar.setWidth(f * 700.0F);
/*     */     }
/*     */ 
/*     */     
/*     */     public final void onLog(byte param1Byte, String param1String) {
/* 381 */       Threads.i().runOnMainThread(() -> {
/*     */             switch (param1Byte) {
/*     */               case 1:
/*     */                 this.lastLogMessage.setColor(MaterialColor.GREY.P500);
/*     */                 break;
/*     */               case 2:
/*     */                 this.lastLogMessage.setColor(MaterialColor.AMBER.P500);
/*     */                 break;
/*     */               case 3:
/*     */                 this.lastLogMessage.setColor(MaterialColor.RED.P500);
/*     */                 break;
/*     */             } 
/*     */             this.lastLogMessage.setText(param1String);
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\SimulationScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */