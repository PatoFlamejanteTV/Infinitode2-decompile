/*      */ package com.prineside.tdi2.ui.shared;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Input;
/*      */ import com.badlogic.gdx.LifecycleListener;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.math.Vector3;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Json;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.JsonWriter;
/*      */ import com.prineside.tdi2.CameraController;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.ResourcePack;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.InterpolationType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.scene2d.Action;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.actions.Actions;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.ui.TextField;
/*      */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*      */ import com.prineside.tdi2.screens.GameScreen;
/*      */ import com.prineside.tdi2.screens.MapEditorScreen;
/*      */ import com.prineside.tdi2.screens.ResearchesScreen;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LabelButton;
/*      */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*      */ import com.prineside.tdi2.ui.actors.LinearChartActor;
/*      */ import com.prineside.tdi2.ui.actors.PaddedImageButton;
/*      */ import com.prineside.tdi2.ui.actors.RectButton;
/*      */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*      */ import com.prineside.tdi2.utils.DrawUtils;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.PMath;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.StringWriter;
/*      */ import java.util.Comparator;
/*      */ 
/*      */ public final class CameraTools extends UiManager.UiComponent.Adapter {
/*   60 */   private static final TLog a = TLog.forClass(CameraTools.class);
/*      */   public static CameraTools i() {
/*   62 */     return (CameraTools)Game.i.uiManager.getComponent(CameraTools.class);
/*      */   }
/*      */   
/*   65 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 9002, "DeveloperConsole camera tools");
/*      */ 
/*      */   
/*   68 */   private final Array<UiManager.UiLayer> c = new Array(UiManager.UiLayer.class);
/*      */   
/*      */   private final Table d;
/*      */   
/*   72 */   private final Vector2 e = new Vector2();
/*   73 */   private float f = 300.0F;
/*   74 */   private float g = 100.0F;
/*   75 */   private float h = 1.0F;
/*   76 */   private float i = 50.0F;
/*      */   
/*      */   private final Label j;
/*      */   
/*      */   private final Label k;
/*      */   
/*      */   private final Label l;
/*      */   
/*      */   private final TextField.TextFieldStyle m;
/*      */   private final SelectBox.SelectBoxStyle n;
/*      */   private final Table o;
/*      */   private Table p;
/*      */   private Table q;
/*      */   private Group r;
/*      */   private Image s;
/*      */   private Image t;
/*      */   private int u;
/*   93 */   private final Scenario[] v = new Scenario[9];
/*      */   private boolean w;
/*      */   private boolean x = true;
/*   96 */   private int y = 0;
/*      */   
/*      */   public CameraTools() {
/*   99 */     Gdx.app.addLifecycleListener(new LifecycleListener(this)
/*      */         {
/*      */           public void pause() {
/*  102 */             CameraTools.a(this.a);
/*      */           }
/*      */ 
/*      */           
/*      */           public void resume() {}
/*      */ 
/*      */           
/*      */           public void dispose() {
/*  110 */             CameraTools.a(this.a);
/*      */           }
/*      */         });
/*      */     
/*  114 */     this.m = Game.i.assetManager.getTextFieldStyle(21);
/*  115 */     this.n = Game.i.assetManager.getSelectBoxStyle((BitmapFont)Game.i.assetManager.getFont(21), true);
/*      */     
/*      */     Table table1;
/*  118 */     (table1 = new Table()).setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(640825565)));
/*  119 */     this.b.getTable().add((Actor)table1).width(800.0F);
/*      */     
/*  121 */     Table table2 = new Table();
/*  122 */     table1.add((Actor)table2).pad(10.0F).expandX().fillX();
/*      */ 
/*      */     
/*  125 */     table1 = new Table();
/*  126 */     table2.add((Actor)table1).top().left().expandX().fillX();
/*      */     
/*  128 */     Table table3 = new Table();
/*  129 */     table1.add((Actor)table3).top().left().row();
/*      */     
/*  131 */     Label label5 = new Label("UI layers", Game.i.assetManager.getLabelStyle(24));
/*  132 */     table3.add((Actor)label5);
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
/*      */     LabelButton labelButton2;
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
/*  158 */     (labelButton2 = new LabelButton("Toggle all", Game.i.assetManager.getLabelStyle(21), () -> { if (this.c.size == 0) { for (byte b = 0; b < Game.i.uiManager.layers.length; b++) { Array array = Game.i.uiManager.layers[b]; for (byte b1 = 0; b1 < array.size; b1++) { UiManager.UiLayer uiLayer; if ((uiLayer = ((UiManager.UiLayer[])array.items)[b1]) != this.b && uiLayer.getTable().isVisible()) { uiLayer.getTable().setVisible(false); this.c.add(uiLayer); }  }  }  } else { for (byte b = 0; b < this.c.size; b++) ((UiManager.UiLayer[])this.c.items)[b].getTable().setVisible(true);  this.c.clear(); }  update(); })).setAlignment(16);
/*  159 */     table3.add((Actor)labelButton2).padLeft(10.0F);
/*      */ 
/*      */     
/*  162 */     (table3 = new Table()).setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F)));
/*  163 */     table1.add((Actor)table3).fillX().expandX().height(250.0F).padTop(5.0F);
/*      */     
/*  165 */     this.d = new Table();
/*      */     ScrollPane scrollPane;
/*  167 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.d, Game.i.assetManager.getScrollPaneStyle(10.0F)));
/*  168 */     scrollPane.setScrollingDisabled(true, false);
/*  169 */     table3.add((Actor)scrollPane).expand().fill().pad(5.0F).row();
/*      */ 
/*      */     
/*  172 */     TextField.TextFieldStyle textFieldStyle = Game.i.assetManager.getTextFieldStyle(21);
/*      */     
/*  174 */     table3 = new Table();
/*  175 */     table2.add((Actor)table3).padLeft(10.0F).top().left().row();
/*      */     
/*  177 */     Table table4 = new Table();
/*  178 */     table3.add((Actor)table4).top().left().row();
/*      */     
/*  180 */     Label label6 = new Label("Cam controller", Game.i.assetManager.getLabelStyle(24));
/*  181 */     table4.add((Actor)label6);
/*      */ 
/*      */     
/*  184 */     (table4 = new Table()).setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F)));
/*  185 */     table3.add((Actor)table4).fillX().top().left().padTop(5.0F);
/*      */     
/*  187 */     table3 = new Table();
/*  188 */     table4.add((Actor)table3).expand().fill().pad(5.0F).row();
/*      */     
/*      */     Label label4;
/*      */     
/*  192 */     (label4 = new Label("Max velocity", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  193 */     table3.add((Actor)label4).top().left().padRight(10.0F);
/*      */     
/*      */     TextFieldXPlatform textFieldXPlatform4;
/*  196 */     (textFieldXPlatform4 = new TextFieldXPlatform(String.valueOf(MathUtils.round(this.f * 10.0F) / 10.0F), textFieldStyle)).addListener((EventListener)new ChangeListener(this, textFieldXPlatform4)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */             try {
/*  200 */               CameraTools.a(this.b, Float.parseFloat(this.a.getText()));
/*  201 */               if (CameraTools.b(this.b) < 0.0F) CameraTools.a(this.b, 0.0F);  return;
/*  202 */             } catch (Exception exception) {
/*      */               return;
/*      */             }  } });
/*  205 */     table3.add((Actor)textFieldXPlatform4).left().size(120.0F, 24.0F).row();
/*      */     
/*      */     Label label3;
/*      */     
/*  209 */     (label3 = new Label("Acceleration", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  210 */     table3.add((Actor)label3).top().left().padRight(10.0F);
/*      */     
/*      */     TextFieldXPlatform textFieldXPlatform3;
/*  213 */     (textFieldXPlatform3 = new TextFieldXPlatform(String.valueOf(MathUtils.round(this.g * 10.0F) / 10.0F), textFieldStyle)).addListener((EventListener)new ChangeListener(this, textFieldXPlatform3)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */             try {
/*  217 */               CameraTools.b(this.b, Float.parseFloat(this.a.getText()));
/*  218 */               if (CameraTools.c(this.b) < 0.0F) CameraTools.b(this.b, 0.0F);  return;
/*  219 */             } catch (Exception exception) {
/*      */               return;
/*      */             }  } });
/*  222 */     table3.add((Actor)textFieldXPlatform3).left().size(120.0F, 24.0F).row();
/*      */     
/*      */     Label label2;
/*      */     
/*  226 */     (label2 = new Label("Decay", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  227 */     table3.add((Actor)label2).top().left().padRight(10.0F);
/*      */     
/*      */     TextFieldXPlatform textFieldXPlatform2;
/*  230 */     (textFieldXPlatform2 = new TextFieldXPlatform(String.valueOf(MathUtils.round(this.g * 10.0F) / 10.0F), textFieldStyle)).addListener((EventListener)new ChangeListener(this, textFieldXPlatform2)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */             try {
/*  234 */               CameraTools.c(this.b, Float.parseFloat(this.a.getText()));
/*  235 */               if (CameraTools.d(this.b) < 0.0F) CameraTools.c(this.b, 0.0F);  return;
/*  236 */             } catch (Exception exception) {
/*      */               return;
/*      */             }  } });
/*  239 */     table3.add((Actor)textFieldXPlatform2).left().size(120.0F, 24.0F).row();
/*      */     
/*      */     Label label1;
/*      */     
/*  243 */     (label1 = new Label("Zoom speed", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  244 */     table3.add((Actor)label1).top().left().padRight(10.0F);
/*      */     
/*      */     TextFieldXPlatform textFieldXPlatform1;
/*  247 */     (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(MathUtils.round(this.h * 100.0F) / 100.0F), textFieldStyle)).addListener((EventListener)new ChangeListener(this, textFieldXPlatform1)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */             try {
/*  251 */               CameraTools.d(this.b, Float.parseFloat(this.a.getText()));
/*  252 */               if (CameraTools.e(this.b) < 0.0F) CameraTools.d(this.b, 0.0F);  return;
/*  253 */             } catch (Exception exception) {
/*      */               return;
/*      */             }  } });
/*  256 */     table3.add((Actor)textFieldXPlatform1).left().size(120.0F, 24.0F).row();
/*      */ 
/*      */ 
/*      */     
/*  260 */     (label1 = new Label("pos", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  261 */     table3.add((Actor)label1).top().left().padTop(10.0F).padRight(10.0F);
/*      */     
/*  263 */     this.j = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  264 */     table3.add((Actor)this.j).top().left().padTop(10.0F).row();
/*      */ 
/*      */ 
/*      */     
/*  268 */     (label1 = new Label("zoom", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  269 */     table3.add((Actor)label1).top().left().padTop(10.0F).padRight(10.0F);
/*      */     
/*  271 */     this.k = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  272 */     table3.add((Actor)this.k).top().left().padTop(10.0F).row();
/*      */ 
/*      */ 
/*      */     
/*  276 */     (label1 = new Label("velocity", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  277 */     table3.add((Actor)label1).top().left().padRight(10.0F);
/*      */     
/*  279 */     this.l = new Label("", Game.i.assetManager.getLabelStyle(21));
/*  280 */     table3.add((Actor)this.l).top().left().row();
/*      */     
/*  282 */     LabelButton labelButton1 = new LabelButton("Stop", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */           this.e.x = 0.0F;
/*      */           this.e.y = 0.0F;
/*      */         });
/*  286 */     table3.add((Actor)labelButton1).colspan(2).top().left().row();
/*      */     
/*  288 */     this.o = new Table();
/*  289 */     table2.add((Actor)this.o).colspan(2).fillX().expandX();
/*      */     
/*  291 */     this.b.getTable().setVisible(false);
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
/*      */ 
/*      */ 
/*      */     
/*  327 */     update();
/*      */   }
/*      */   
/*      */   public final Scenario getSelectedScenario() {
/*  331 */     return this.v[this.u];
/*      */   }
/*      */   
/*      */   public final void setSelectedScenarioIdx(int paramInt, boolean paramBoolean) {
/*  335 */     if (paramInt < 0 || paramInt > 8) {
/*  336 */       throw new IllegalArgumentException("idx is " + paramInt);
/*      */     }
/*      */     
/*  339 */     this.u = paramInt;
/*  340 */     if (paramBoolean) {
/*  341 */       CameraController cameraController = e();
/*  342 */       Scenario scenario = getSelectedScenario();
/*  343 */       if (cameraController != null && scenario != null) {
/*  344 */         cameraController.playScenario(scenario, scenario.startFrame / scenario.fps, this.w);
/*      */       } else {
/*  346 */         a.e("controller " + cameraController + " scenario " + scenario, new Object[0]);
/*      */       } 
/*      */     } 
/*      */     
/*  350 */     updateScenarioMenu();
/*      */   }
/*      */   
/*      */   public final void update() {
/*  354 */     this.d.clear();
/*      */     
/*  356 */     for (byte b = 0; b < Game.i.uiManager.layers.length; b++) {
/*  357 */       Array array = Game.i.uiManager.layers[b];
/*  358 */       for (byte b1 = 0; b1 < array.size; b1++) {
/*  359 */         UiManager.UiLayer uiLayer = ((UiManager.UiLayer[])array.items)[b1];
/*      */         
/*  361 */         LabelToggleButton labelToggleButton = new LabelToggleButton(uiLayer.name, uiLayer.getTable().isVisible(), 21, 21.0F, paramBoolean -> paramUiLayer.getTable().setVisible(paramBoolean.booleanValue()));
/*  362 */         this.d.add((Actor)labelToggleButton).fillX().row();
/*      */       } 
/*      */     } 
/*      */     
/*  366 */     updateScenarioMenu();
/*      */   }
/*      */   public final void updateScenarioMenu() {
/*      */     TextFieldXPlatform textFieldXPlatform;
/*  370 */     this.o.clear();
/*      */     
/*  372 */     Table table1 = new Table();
/*  373 */     this.o.add((Actor)table1).expandX().fillX().row();
/*      */ 
/*      */     
/*  376 */     Label label = new Label("Scenarios", Game.i.assetManager.getLabelStyle(24));
/*  377 */     table1.add((Actor)label).padRight(16.0F).left();
/*      */ 
/*      */     
/*  380 */     for (byte b = 1; b <= 5; b++) {
/*  381 */       byte b1 = b;
/*  382 */       RectButton rectButton1 = new RectButton(String.valueOf(b), Game.i.assetManager.getLabelStyle(21), () -> setSelectedScenarioIdx(paramInt - 1, false));
/*  383 */       if (this.u == b - 1) {
/*  384 */         rectButton1.setBackgroundColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/*  385 */         rectButton1.setLabelColors(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK);
/*      */       } else {
/*  387 */         rectButton1.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.0F), new Color(0.0F, 0.0F, 0.0F, 0.0F), new Color(0.0F, 0.0F, 0.0F, 0.0F), new Color(0.0F, 0.0F, 0.0F, 0.0F));
/*  388 */         if (this.v[b - 1] == null) {
/*  389 */           rectButton1.setLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P500, Color.WHITE);
/*      */         } else {
/*  391 */           rectButton1.setLabelColors(MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P500, Color.WHITE);
/*      */         } 
/*      */       } 
/*  394 */       table1.add((Actor)rectButton1).size(24.0F, 24.0F).bottom();
/*      */     } 
/*      */     
/*  397 */     table1.add().height(1.0F).expandX().fillX();
/*      */ 
/*      */     
/*  400 */     LabelToggleButton labelToggleButton1 = new LabelToggleButton("Loop", this.w, 21, 16.0F, false, paramBoolean -> {
/*      */           this.w = paramBoolean.booleanValue();
/*      */           updateScenarioMenu();
/*      */         });
/*  404 */     table1.add((Actor)labelToggleButton1).height(24.0F).padLeft(64.0F);
/*      */     
/*  406 */     LabelToggleButton labelToggleButton2 = new LabelToggleButton("Draw", this.x, 21, 16.0F, false, paramBoolean -> {
/*      */           this.x = paramBoolean.booleanValue();
/*      */           updateScenarioMenu();
/*      */         });
/*  410 */     table1.add((Actor)labelToggleButton2).height(24.0F).padLeft(16.0F);
/*      */ 
/*      */     
/*  413 */     Table table2 = new Table();
/*  414 */     this.o.add((Actor)table2).expandX().fillX().row();
/*      */     
/*      */     Scenario scenario;
/*  417 */     if ((scenario = getSelectedScenario()) != null) {
/*  418 */       Table table = new Table();
/*  419 */       this.o.add((Actor)table).fillX().expandX().row();
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform3;
/*      */       
/*  423 */       (textFieldXPlatform3 = new TextFieldXPlatform(scenario.name, this.m)).addListener((EventListener)new ChangeListener(this, scenario, textFieldXPlatform3)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  426 */               this.a.name = this.b.getText();
/*      */             }
/*      */           });
/*  429 */       table.add((Actor)textFieldXPlatform3).size(160.0F, 24.0F);
/*      */ 
/*      */ 
/*      */       
/*      */       PaddedImageButton paddedImageButton2;
/*      */ 
/*      */       
/*  436 */       (paddedImageButton2 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> Dialog.i().showConfirm("Remove scenario?", ()), MaterialColor.RED.P500, MaterialColor.RED.P300, MaterialColor.RED.P800)).setIconPosition(4.0F, 4.0F);
/*  437 */       paddedImageButton2.setIconSize(16.0F, 16.0F);
/*  438 */       table.add((Actor)paddedImageButton2).size(24.0F).padLeft(16.0F);
/*      */       
/*      */       Label label3;
/*      */       
/*  442 */       (label3 = new Label("FPS:", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  443 */       table.add((Actor)label3).height(24.0F).padLeft(16.0F);
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform2;
/*  446 */       (textFieldXPlatform2 = new TextFieldXPlatform(String.valueOf(scenario.fps), this.m)).addListener((EventListener)new ChangeListener(this, scenario, textFieldXPlatform2)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  450 */                 this.a.fps = Integer.parseInt(this.b.getText());
/*  451 */                 if (this.a.fps <= 0) this.a.fps = 1;
/*      */                 
/*  453 */                 CameraTools.f(this.c); return;
/*  454 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/*  457 */       table.add((Actor)textFieldXPlatform2).size(48.0F, 24.0F);
/*      */       
/*      */       Label label2;
/*      */       
/*  461 */       (label2 = new Label("Start:", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  462 */       table.add((Actor)label2).height(24.0F).padLeft(16.0F);
/*      */       
/*      */       TextFieldXPlatform textFieldXPlatform1;
/*  465 */       (textFieldXPlatform1 = new TextFieldXPlatform(String.valueOf(scenario.startFrame), this.m)).addListener((EventListener)new ChangeListener(this, scenario, textFieldXPlatform1)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  469 */                 this.a.startFrame = Integer.parseInt(this.b.getText());
/*  470 */                 if (this.a.startFrame < 0) this.a.startFrame = 0;
/*      */                 
/*  472 */                 CameraTools.f(this.c); return;
/*  473 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/*  476 */       table.add((Actor)textFieldXPlatform1).size(60.0F, 24.0F);
/*      */       
/*      */       Label label1;
/*      */       
/*  480 */       (label1 = new Label("Length:", Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  481 */       table.add((Actor)label1).height(24.0F).padLeft(16.0F);
/*      */ 
/*      */       
/*  484 */       (textFieldXPlatform = new TextFieldXPlatform(String.valueOf(scenario.length), this.m)).addListener((EventListener)new ChangeListener(this, scenario, textFieldXPlatform)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  488 */                 this.a.length = Integer.parseInt(this.b.getText());
/*  489 */                 if (this.a.length <= 0) this.a.length = 1;
/*      */                 
/*  491 */                 CameraTools.f(this.c); return;
/*  492 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/*  495 */       table.add((Actor)textFieldXPlatform).size(48.0F, 24.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       PaddedImageButton paddedImageButton1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  509 */       (paddedImageButton1 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right"), () -> { CameraController cameraController = e(); Scenario scenario = getSelectedScenario(); if (cameraController != null && scenario != null) { float f = scenario.startFrame / scenario.fps; if (this.y >= scenario.startFrame && this.y <= scenario.length) f /= scenario.fps;  cameraController.playScenario(scenario, f, this.w); }  }MaterialColor.GREEN.P500, MaterialColor.GREEN.P300, MaterialColor.GREEN.P800)).setIconPosition(4.0F, 4.0F);
/*  510 */       paddedImageButton1.setIconSize(16.0F, 16.0F);
/*  511 */       table.add((Actor)paddedImageButton1).size(24.0F).padLeft(16.0F);
/*      */ 
/*      */       
/*  514 */       LabelButton labelButton = new LabelButton("From JSON", Game.i.assetManager.getLabelStyle(21), () -> Game.i.uiManager.getTextInput(new Input.TextInputListener(this)
/*      */             {
/*      */               public void input(String param1String) {
/*  517 */                 Threads.i().runOnMainThread(() -> {
/*      */                       try {
/*      */                         JsonValue jsonValue = (new JsonReader()).parse(param1String); CameraTools.i(this.a)[CameraTools.j(this.a)] = CameraTools.Scenario.fromJson(jsonValue);
/*      */                         this.a.updateScenarioMenu();
/*      */                         return;
/*  522 */                       } catch (Exception exception) {
/*      */                         CameraTools.a().e("failed to load scenario from json: " + param1String, new Object[] { exception });
/*      */                         Notifications.i().add("Failed to load scenario from JSON", (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*      */                         return;
/*      */                       } 
/*      */                     });
/*      */               }
/*      */               
/*      */               public void canceled() {}
/*      */             }"Load from JSON", "", "Paste scenario JSON here"));
/*  532 */       table.add((Actor)labelButton).left().padLeft(20.0F).height(24.0F);
/*      */       
/*  534 */       labelButton = new LabelButton("To JSON", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */             String str = "";
/*      */             
/*      */             Scenario scenario;
/*      */             
/*      */             if ((scenario = getSelectedScenario()) != null) {
/*      */               Json json = new Json(JsonWriter.OutputType.json);
/*      */               
/*      */               StringWriter stringWriter = new StringWriter();
/*      */               json.setWriter(stringWriter);
/*      */               json.writeObjectStart();
/*      */               scenario.toJson(json);
/*      */               json.writeObjectEnd();
/*      */               str = stringWriter.toString();
/*      */             } 
/*      */             Gdx.app.getClipboard().setContents(str);
/*      */             Notifications.i().add("Scenario copied to the clipboard", null, null, null);
/*      */           });
/*  552 */       table.add((Actor)labelButton).left().padLeft(20.0F).height(24.0F);
/*      */       
/*  554 */       table.add().height(1.0F).expandX().fillX();
/*      */ 
/*      */       
/*  557 */       this.q = new Table();
/*      */       
/*  559 */       Drawable drawable1 = (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(new Color(0.0F, 0.0F, 0.0F, 0.28F));
/*  560 */       Drawable drawable2 = (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(new Color(1044266751));
/*  561 */       drawable1.setMinWidth(12.0F);
/*  562 */       drawable2.setMinWidth(12.0F);
/*      */       
/*      */       ScrollPane scrollPane;
/*  565 */       UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.q, new ScrollPane.ScrollPaneStyle(null, drawable1, drawable2, null, null)));
/*  566 */       this.o.add((Actor)scrollPane).padTop(8.0F).height(120.0F).expandX().fillX().row();
/*      */       
/*  568 */       b();
/*      */       
/*  570 */       this.p = new Table();
/*  571 */       this.o.add((Actor)this.p).expandX().fillX().padTop(16.0F).row();
/*      */       
/*  573 */       c();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  578 */     RectButton rectButton = new RectButton("New scenario", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */           Scenario scenario = new Scenario();
/*      */           
/*      */           CameraController cameraController;
/*      */           if ((cameraController = e()) == null) {
/*      */             scenario.setKeyframe(0, 0.0F, InterpolationType.linear, 0.0F, InterpolationType.linear, 1.0F, InterpolationType.linear);
/*      */           } else {
/*      */             scenario.setKeyframe(0, cameraController.camera.position.x, InterpolationType.linear, cameraController.camera.position.y, InterpolationType.linear, (float)cameraController.zoom, InterpolationType.linear);
/*      */           } 
/*      */           this.v[this.u] = scenario;
/*      */           updateScenarioMenu();
/*      */         });
/*  590 */     textFieldXPlatform.add((Actor)rectButton).size(192.0F, 32.0F);
/*      */     
/*  592 */     this.q = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b() {
/*      */     Scenario scenario;
/*  603 */     if ((scenario = getSelectedScenario()) != null && this.q != null) {
/*  604 */       this.q.clearChildren();
/*      */       
/*  606 */       this.r = new Group();
/*  607 */       this.r.setTransform(false);
/*      */       
/*  609 */       int i, j = Math.max(i = scenario.length << 4, 770);
/*  610 */       this.q.add((Actor)this.r).size(j, 120.0F).padLeft(5.0F).padRight(5.0F).row();
/*      */       
/*      */       int k;
/*  613 */       for (k = 0; k <= scenario.length; k += scenario.fps) {
/*      */         Label label;
/*  615 */         (label = new Label(String.valueOf(k), Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  616 */         label.setPosition((k << 4) - 1.0F, 96.0F);
/*  617 */         label.setSize(2.0F, 24.0F);
/*  618 */         label.setAlignment(1);
/*  619 */         this.r.addActor((Actor)label);
/*      */       } 
/*      */ 
/*      */       
/*  623 */       for (k = 0; k < 3; k++) {
/*  624 */         Image image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  625 */         if (k % 2 == 0) {
/*  626 */           image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*      */         } else {
/*  628 */           image.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*      */         } 
/*  630 */         image.setSize(j, 24.0F);
/*  631 */         image.setPosition(0.0F, ((2 - k) * 24 + 24));
/*  632 */         this.r.addActor((Actor)image);
/*      */       } 
/*      */ 
/*      */       
/*  636 */       if (scenario.startFrame != 0) {
/*      */         Image image;
/*  638 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize((scenario.startFrame << 4), 72.0F);
/*  639 */         image.setPosition(0.0F, 24.0F);
/*  640 */         image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  641 */         this.r.addActor((Actor)image);
/*      */       } 
/*  643 */       if (j > i) {
/*      */         Image image;
/*  645 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize((j - i), 72.0F);
/*  646 */         image.setPosition(i, 24.0F);
/*  647 */         image.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  648 */         this.r.addActor((Actor)image);
/*      */       } 
/*      */ 
/*      */       
/*  652 */       for (k = 0; k <= scenario.length; k++) {
/*      */         Image image;
/*  654 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(1.0F, 72.0F);
/*  655 */         image.setPosition((k << 4), 24.0F);
/*  656 */         image.setColor(1.0F, 1.0F, 1.0F, 0.07F);
/*  657 */         this.r.addActor((Actor)image);
/*      */       } 
/*      */ 
/*      */       
/*  661 */       for (k = 0; k <= scenario.length; k += scenario.fps) {
/*      */         Image image;
/*  663 */         (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(2.0F, 72.0F);
/*  664 */         image.setPosition((k << 4), 24.0F);
/*  665 */         image.setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*  666 */         this.r.addActor((Actor)image);
/*      */         
/*  668 */         i = k / scenario.fps;
/*      */         Label label;
/*  670 */         (label = new Label(":" + i, Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  671 */         label.setPosition((k << 4) - 1.0F, 0.0F);
/*  672 */         label.setSize(2.0F, 24.0F);
/*  673 */         label.setAlignment(1);
/*  674 */         this.r.addActor((Actor)label);
/*      */       } 
/*      */ 
/*      */       
/*  678 */       for (k = 0; k < scenario.keyframes.size; k++) {
/*      */         Scenario.Keyframe keyframe;
/*  680 */         if (!Float.isNaN((keyframe = ((Scenario.Keyframe[])scenario.keyframes.items)[k]).x)) {
/*      */           Image image;
/*  682 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle"))).setColor(MaterialColor.RED.P300);
/*  683 */           image.setSize(12.0F, 12.0F);
/*  684 */           image.setPosition((keyframe.frame << 4) - 6.0F, 76.0F);
/*  685 */           this.r.addActor((Actor)image);
/*      */         } 
/*  687 */         if (!Float.isNaN(keyframe.y)) {
/*      */           Image image;
/*  689 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle"))).setColor(MaterialColor.GREEN.P300);
/*  690 */           image.setSize(12.0F, 12.0F);
/*  691 */           image.setPosition((keyframe.frame << 4) - 6.0F, 52.0F);
/*  692 */           this.r.addActor((Actor)image);
/*      */         } 
/*  694 */         if (!Float.isNaN(keyframe.z)) {
/*      */           Image image;
/*  696 */           (image = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle"))).setColor(MaterialColor.BLUE.P300);
/*  697 */           image.setSize(12.0F, 12.0F);
/*  698 */           image.setPosition((keyframe.frame << 4) - 6.0F, 28.0F);
/*  699 */           this.r.addActor((Actor)image);
/*      */         } 
/*      */       } 
/*      */       
/*  703 */       this.r.addListener((EventListener)new ClickListener(this) {
/*      */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  705 */               CameraTools.a(this.a, MathUtils.round(param1Float1 / 16.0F));
/*  706 */               CameraTools.g(this.a);
/*      */             }
/*      */           });
/*      */ 
/*      */       
/*  711 */       if (this.y < 0) {
/*  712 */         this.y = 0;
/*  713 */       } else if (this.y > scenario.length) {
/*  714 */         this.y = scenario.length;
/*      */       } 
/*      */ 
/*      */       
/*  718 */       this.s = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  719 */       this.s.setSize(2.0F, 96.0F);
/*  720 */       this.s.setPosition(0.0F, 0.0F);
/*  721 */       this.s.setColor(MaterialColor.ORANGE.P300);
/*  722 */       this.r.addActor((Actor)this.s);
/*      */ 
/*      */       
/*  725 */       this.t = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  726 */       this.t.setSize(4.0F, 72.0F);
/*      */       
/*  728 */       this.t.setColor(0.0F, 1.0F, 1.0F, 0.78F);
/*  729 */       this.r.addActor((Actor)this.t);
/*      */       
/*  731 */       d(); return;
/*      */     } 
/*  733 */     this.s = null;
/*      */   }
/*      */ 
/*      */   
/*      */   private void c() {
/*      */     Scenario scenario;
/*  739 */     if ((scenario = getSelectedScenario()) != null && this.p != null) {
/*  740 */       this.p.clearChildren();
/*      */       
/*  742 */       Table table1 = new Table();
/*  743 */       this.p.add((Actor)table1).expandX().fillX().row();
/*      */       
/*  745 */       Label label1 = new Label("Frame: " + this.y, Game.i.assetManager.getLabelStyle(21));
/*  746 */       table1.add((Actor)label1).height(24.0F);
/*      */       
/*  748 */       table1.add().height(1.0F).expandX().fillX();
/*      */       
/*  750 */       RectButton rectButton = new RectButton("Clear", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */             paramScenario.removeKeyframe(this.y);
/*      */             b();
/*      */           });
/*  754 */       table1.add((Actor)rectButton).size(96.0F, 24.0F).padLeft(16.0F);
/*      */       
/*  756 */       rectButton = new RectButton("Cam -> Frame", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */             CameraController cameraController;
/*      */             if ((cameraController = e()) != null) {
/*      */               Scenario.Keyframe keyframe;
/*      */               if ((keyframe = paramScenario.getKeyframe(this.y)) != null) {
/*      */                 paramScenario.setKeyframe(this.y, cameraController.camera.position.x, keyframe.iX, cameraController.camera.position.y, keyframe.iY, (float)cameraController.zoom, keyframe.iZ);
/*      */               } else {
/*      */                 paramScenario.setKeyframe(this.y, cameraController.camera.position.x, InterpolationType.linear, cameraController.camera.position.y, InterpolationType.linear, (float)cameraController.zoom, InterpolationType.linear);
/*      */               } 
/*      */               b();
/*      */               c();
/*      */             } 
/*      */           });
/*  769 */       table1.add((Actor)rectButton).size(160.0F, 24.0F).padLeft(16.0F);
/*      */       
/*  771 */       rectButton = new RectButton("Frame -> Cam (calculate)", Game.i.assetManager.getLabelStyle(21), () -> {
/*      */             CameraController cameraController = e();
/*      */             
/*      */             Scenario scenario = getSelectedScenario();
/*      */             
/*      */             if (cameraController != null && scenario != null) {
/*      */               float f = this.y / scenario.fps;
/*      */               Vector3 vector3 = scenario.calculate(f);
/*      */               cameraController.lookAt(Float.isNaN(vector3.x) ? cameraController.camera.position.x : vector3.x, Float.isNaN(vector3.y) ? cameraController.camera.position.y : vector3.y);
/*      */               cameraController.setZoom(Float.isNaN(vector3.z) ? cameraController.zoom : vector3.z);
/*      */             } 
/*      */           });
/*  783 */       table1.add((Actor)rectButton).size(256.0F, 24.0F).padLeft(16.0F);
/*      */       
/*  785 */       table1.add().height(1.0F).expandX().fillX();
/*      */ 
/*      */       
/*  788 */       Scenario.Keyframe keyframe = scenario.getKeyframe(this.y);
/*      */       
/*  790 */       Table table2 = new Table();
/*  791 */       this.p.add((Actor)table2).fillX().expandX().padTop(8.0F);
/*      */       
/*      */       Label label4;
/*      */       
/*  795 */       (label4 = new Label("x", Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.RED.P300);
/*  796 */       table2.add((Actor)label4);
/*      */       
/*  798 */       boolean bool3 = (keyframe == null || Float.isNaN(keyframe.x)) ? true : false;
/*      */       TextFieldXPlatform textFieldXPlatform3;
/*  800 */       (textFieldXPlatform3 = new TextFieldXPlatform(bool3 ? "" : String.valueOf(keyframe.x), this.m)).addListener((EventListener)new ChangeListener(this, scenario, textFieldXPlatform3)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  804 */                 this.a.setKeyframeX(CameraTools.h(this.c), Float.parseFloat(this.b.getText()), null);
/*  805 */                 CameraTools.f(this.c); return;
/*  806 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/*  809 */       table2.add((Actor)textFieldXPlatform3).size(96.0F, 24.0F).padLeft(8.0F);
/*      */ 
/*      */       
/*      */       PaddedImageButton paddedImageButton3;
/*      */ 
/*      */       
/*  815 */       (paddedImageButton3 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> { paramScenario.setKeyframeX(this.y, Float.NaN, null); updateScenarioMenu(); }MaterialColor.RED.P500, MaterialColor.RED.P300, MaterialColor.RED.P800)).setIconPosition(4.0F, 4.0F);
/*  816 */       paddedImageButton3.setIconSize(16.0F, 16.0F);
/*  817 */       table2.add((Actor)paddedImageButton3).size(24.0F).padLeft(8.0F);
/*      */ 
/*      */       
/*  820 */       InterpolationType interpolationType3 = (keyframe == null || keyframe.iX == null) ? InterpolationType.linear : keyframe.iX;
/*      */       SelectBox selectBox3;
/*  822 */       (selectBox3 = new SelectBox(this.n)).setItems((Object[])InterpolationType.values);
/*  823 */       selectBox3.setSelected(interpolationType3);
/*  824 */       selectBox3.addListener((EventListener)new ChangeListener(this, scenario, keyframe, selectBox3)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  827 */               this.a.setKeyframeX(CameraTools.h(this.d), (this.b == null) ? Float.NaN : this.b.x, (InterpolationType)this.c.getSelected());
/*  828 */               CameraTools.g(this.d);
/*      */             }
/*      */           });
/*  831 */       table2.add((Actor)selectBox3).size(128.0F, 24.0F).padLeft(8.0F);
/*      */       
/*      */       Group group3;
/*  834 */       (group3 = new Group()).setTransform(false);
/*  835 */       table2.add((Actor)group3).size(256.0F, 16.0F).padBottom(4.0F).padTop(4.0F).padLeft(8.0F);
/*      */       
/*      */       Image image2;
/*  838 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*  839 */       image2.setSize(256.0F, 16.0F);
/*  840 */       group3.addActor((Actor)image2);
/*      */ 
/*      */       
/*  843 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle"))).setSize(16.0F, 16.0F);
/*  844 */       image2.addAction((Action)Actions.forever((Action)Actions.sequence(
/*  845 */               (Action)Actions.moveTo(0.0F, 0.0F), 
/*  846 */               (Action)Actions.moveTo(240.0F, 0.0F, 1.5F, InterpolationType.getObject(interpolationType3)))));
/*      */       
/*  848 */       group3.addActor((Actor)image2);
/*      */       
/*      */       LinearChartActor linearChartActor3;
/*  851 */       (linearChartActor3 = new LinearChartActor()).setChartFromInterpolation(interpolationType3);
/*  852 */       linearChartActor3.setColor(MaterialColor.RED.P300, new Color(0.0F, 0.0F, 0.0F, 0.28F));
/*  853 */       table2.add((Actor)linearChartActor3).size(128.0F, 24.0F).padLeft(8.0F);
/*      */       
/*  855 */       table2.add().height(1.0F).expandX().fillX().row();
/*      */       
/*      */       Label label3;
/*      */       
/*  859 */       (label3 = new Label("y", Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.GREEN.P300);
/*  860 */       table2.add((Actor)label3);
/*      */       
/*  862 */       boolean bool2 = (keyframe == null || Float.isNaN(keyframe.y)) ? true : false;
/*      */       TextFieldXPlatform textFieldXPlatform2;
/*  864 */       (textFieldXPlatform2 = new TextFieldXPlatform(bool2 ? "" : String.valueOf(keyframe.y), this.m)).addListener((EventListener)new ChangeListener(this, scenario, textFieldXPlatform2)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  868 */                 this.a.setKeyframeY(CameraTools.h(this.c), Float.parseFloat(this.b.getText()), null);
/*  869 */                 CameraTools.f(this.c); return;
/*  870 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/*  873 */       table2.add((Actor)textFieldXPlatform2).size(96.0F, 24.0F).padLeft(8.0F);
/*      */ 
/*      */       
/*      */       PaddedImageButton paddedImageButton2;
/*      */ 
/*      */       
/*  879 */       (paddedImageButton2 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> { paramScenario.setKeyframeY(this.y, Float.NaN, null); updateScenarioMenu(); }MaterialColor.RED.P500, MaterialColor.RED.P300, MaterialColor.RED.P800)).setIconPosition(4.0F, 4.0F);
/*  880 */       paddedImageButton2.setIconSize(16.0F, 16.0F);
/*  881 */       table2.add((Actor)paddedImageButton2).size(24.0F).padLeft(8.0F);
/*      */ 
/*      */       
/*  884 */       InterpolationType interpolationType2 = (keyframe == null || keyframe.iY == null) ? InterpolationType.linear : keyframe.iY;
/*      */       SelectBox selectBox2;
/*  886 */       (selectBox2 = new SelectBox(this.n)).setItems((Object[])InterpolationType.values);
/*  887 */       selectBox2.setSelected(interpolationType2);
/*  888 */       selectBox2.addListener((EventListener)new ChangeListener(this, scenario, keyframe, selectBox2)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  891 */               this.a.setKeyframeY(CameraTools.h(this.d), (this.b == null) ? Float.NaN : this.b.y, (InterpolationType)this.c.getSelected());
/*  892 */               CameraTools.g(this.d);
/*      */             }
/*      */           });
/*  895 */       table2.add((Actor)selectBox2).size(128.0F, 24.0F).padLeft(8.0F);
/*      */       
/*      */       Group group2;
/*  898 */       (group2 = new Group()).setTransform(false);
/*  899 */       table2.add((Actor)group2).size(256.0F, 16.0F).padBottom(4.0F).padTop(4.0F).padLeft(8.0F);
/*      */ 
/*      */       
/*  902 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*  903 */       image2.setSize(256.0F, 16.0F);
/*  904 */       group2.addActor((Actor)image2);
/*      */ 
/*      */       
/*  907 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle"))).setSize(16.0F, 16.0F);
/*  908 */       image2.addAction((Action)Actions.forever((Action)Actions.sequence(
/*  909 */               (Action)Actions.moveTo(0.0F, 0.0F), 
/*  910 */               (Action)Actions.moveTo(240.0F, 0.0F, 1.5F, InterpolationType.getObject(interpolationType2)))));
/*      */       
/*  912 */       group2.addActor((Actor)image2);
/*      */       
/*      */       LinearChartActor linearChartActor2;
/*  915 */       (linearChartActor2 = new LinearChartActor()).setChartFromInterpolation(interpolationType2);
/*  916 */       linearChartActor2.setColor(MaterialColor.GREEN.P300, new Color(0.0F, 0.0F, 0.0F, 0.28F));
/*  917 */       table2.add((Actor)linearChartActor2).size(128.0F, 24.0F).padLeft(8.0F);
/*      */       
/*  919 */       table2.add().height(1.0F).expandX().fillX().row();
/*      */       
/*      */       Label label2;
/*      */       
/*  923 */       (label2 = new Label("z", Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.BLUE.P300);
/*  924 */       table2.add((Actor)label2);
/*      */       
/*  926 */       boolean bool1 = (keyframe == null || Float.isNaN(keyframe.z)) ? true : false;
/*      */       TextFieldXPlatform textFieldXPlatform1;
/*  928 */       (textFieldXPlatform1 = new TextFieldXPlatform(bool1 ? "" : String.valueOf(keyframe.z), this.m)).addListener((EventListener)new ChangeListener(this, scenario, textFieldXPlatform1)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  932 */                 this.a.setKeyframeZ(CameraTools.h(this.c), Float.parseFloat(this.b.getText()), null);
/*  933 */                 CameraTools.f(this.c); return;
/*  934 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/*  937 */       table2.add((Actor)textFieldXPlatform1).size(96.0F, 24.0F).padLeft(8.0F);
/*      */ 
/*      */       
/*      */       PaddedImageButton paddedImageButton1;
/*      */ 
/*      */       
/*  943 */       (paddedImageButton1 = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-times"), () -> { paramScenario.setKeyframeZ(this.y, Float.NaN, null); updateScenarioMenu(); }MaterialColor.RED.P500, MaterialColor.RED.P300, MaterialColor.RED.P800)).setIconPosition(4.0F, 4.0F);
/*  944 */       paddedImageButton1.setIconSize(16.0F, 16.0F);
/*  945 */       table2.add((Actor)paddedImageButton1).size(24.0F).padLeft(8.0F);
/*      */ 
/*      */       
/*  948 */       InterpolationType interpolationType1 = (keyframe == null || keyframe.iZ == null) ? InterpolationType.linear : keyframe.iZ;
/*      */       SelectBox selectBox1;
/*  950 */       (selectBox1 = new SelectBox(this.n)).setItems((Object[])InterpolationType.values);
/*  951 */       selectBox1.setSelected(interpolationType1);
/*  952 */       selectBox1.addListener((EventListener)new ChangeListener(this, scenario, keyframe, selectBox1)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  955 */               this.a.setKeyframeZ(CameraTools.h(this.d), (this.b == null) ? Float.NaN : this.b.z, (InterpolationType)this.c.getSelected());
/*  956 */               CameraTools.g(this.d);
/*      */             }
/*      */           });
/*  959 */       table2.add((Actor)selectBox1).size(128.0F, 24.0F).padLeft(8.0F);
/*      */       
/*      */       Group group1;
/*  962 */       (group1 = new Group()).setTransform(false);
/*  963 */       table2.add((Actor)group1).size(256.0F, 16.0F).padBottom(4.0F).padTop(4.0F).padLeft(8.0F);
/*      */ 
/*      */       
/*  966 */       (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*  967 */       image2.setSize(256.0F, 16.0F);
/*  968 */       group1.addActor((Actor)image2);
/*      */       
/*      */       Image image1;
/*  971 */       (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("small-circle"))).setSize(16.0F, 16.0F);
/*  972 */       image1.addAction((Action)Actions.forever((Action)Actions.sequence(
/*  973 */               (Action)Actions.moveTo(0.0F, 0.0F), 
/*  974 */               (Action)Actions.moveTo(240.0F, 0.0F, 1.5F, InterpolationType.getObject(interpolationType1)))));
/*      */       
/*  976 */       group1.addActor((Actor)image1);
/*      */       
/*      */       LinearChartActor linearChartActor1;
/*  979 */       (linearChartActor1 = new LinearChartActor()).setChartFromInterpolation(interpolationType1);
/*  980 */       linearChartActor1.setColor(MaterialColor.BLUE.P300, new Color(0.0F, 0.0F, 0.0F, 0.28F));
/*  981 */       table2.add((Actor)linearChartActor1).size(128.0F, 24.0F).padLeft(8.0F);
/*      */       
/*  983 */       table2.add().height(1.0F).expandX().fillX().row();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void d() {
/*      */     CameraController cameraController;
/*  989 */     if ((cameraController = e()) != null && cameraController.currentScenario != null && this.s != null) {
/*  990 */       this.s.setX(cameraController.scenarioTime * cameraController.currentScenario.fps * 16.0F - 1.0F);
/*      */     }
/*      */     
/*  993 */     if (this.t != null) {
/*  994 */       this.t.setPosition((this.y << 4) - 2.0F, 24.0F);
/*      */     }
/*      */   }
/*      */   
/*      */   private static CameraController e() {
/*  999 */     if (Game.i.screenManager.getCurrentScreen() instanceof GameScreen) {
/*      */       GameScreen gameScreen;
/* 1001 */       return (gameScreen = (GameScreen)Game.i.screenManager.getCurrentScreen()).S._input.cameraController;
/* 1002 */     }  if (Game.i.screenManager.getCurrentScreen() instanceof ResearchesScreen) {
/*      */       ResearchesScreen researchesScreen;
/* 1004 */       return (researchesScreen = (ResearchesScreen)Game.i.screenManager.getCurrentScreen()).cameraController;
/* 1005 */     }  if (Game.i.screenManager.getCurrentScreen() instanceof MapEditorScreen) {
/*      */       MapEditorScreen mapEditorScreen;
/* 1007 */       return (mapEditorScreen = (MapEditorScreen)Game.i.screenManager.getCurrentScreen()).S._input.getCameraController();
/*      */     } 
/*      */     
/* 1010 */     return null;
/*      */   }
/*      */   
/*      */   private static boolean f() {
/* 1014 */     return (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.CAMERA_TOOLS_ENABLED) != 0.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void hide() {
/* 1019 */     setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void postRender(float paramFloat) {
/* 1024 */     if (!f())
/*      */       return; 
/* 1026 */     if (Game.i.uiManager.stage.getKeyboardFocus() == null && Gdx.input.isKeyJustPressed(139))
/*      */     {
/* 1028 */       setVisible(!isVisible());
/*      */     }
/*      */     
/* 1031 */     if (isVisible() && Gdx.input.isKeyJustPressed(66))
/*      */     {
/* 1033 */       Game.i.uiManager.stage.unfocusAll();
/*      */     }
/*      */     
/* 1036 */     CameraController cameraController = e();
/*      */     
/* 1038 */     boolean bool1 = false;
/* 1039 */     boolean bool2 = false;
/* 1040 */     float f = 0.0F;
/* 1041 */     if (Gdx.input.isKeyPressed(129)) {
/*      */       
/* 1043 */       if (cameraController != null) {
/*      */         
/* 1045 */         if (Gdx.input.isKeyPressed(21)) {
/* 1046 */           this.e.x -= this.g * paramFloat;
/* 1047 */           bool1 = true;
/*      */         } 
/* 1049 */         if (Gdx.input.isKeyPressed(22)) {
/* 1050 */           this.e.x += this.g * paramFloat;
/* 1051 */           bool1 = true;
/*      */         } 
/* 1053 */         if (Gdx.input.isKeyPressed(19)) {
/* 1054 */           this.e.y += this.g * paramFloat;
/* 1055 */           bool2 = true;
/*      */         } 
/* 1057 */         if (Gdx.input.isKeyPressed(20)) {
/* 1058 */           this.e.y -= this.g * paramFloat;
/* 1059 */           bool2 = true;
/*      */         } 
/* 1061 */         if (Gdx.input.isKeyPressed(76)) {
/* 1062 */           f = this.h * paramFloat;
/*      */         }
/* 1064 */         if (Gdx.input.isKeyPressed(75)) {
/* 1065 */           f = -this.h * paramFloat;
/*      */         }
/*      */       } 
/*      */       
/* 1069 */       if (Gdx.input.isKeyJustPressed(8)) {
/* 1070 */         setSelectedScenarioIdx(0, true);
/* 1071 */       } else if (Gdx.input.isKeyJustPressed(9)) {
/* 1072 */         setSelectedScenarioIdx(1, true);
/* 1073 */       } else if (Gdx.input.isKeyJustPressed(10)) {
/* 1074 */         setSelectedScenarioIdx(2, true);
/* 1075 */       } else if (Gdx.input.isKeyJustPressed(11)) {
/* 1076 */         setSelectedScenarioIdx(3, true);
/* 1077 */       } else if (Gdx.input.isKeyJustPressed(12)) {
/* 1078 */         setSelectedScenarioIdx(4, true);
/*      */       } 
/*      */     } 
/*      */     
/* 1082 */     if (Gdx.input.isKeyJustPressed(69)) {
/*      */       Scenario scenario1;
/* 1084 */       if ((scenario1 = getSelectedScenario()) != null && cameraController != null) {
/* 1085 */         cameraController.playScenario(scenario1, 0.0F, this.w);
/* 1086 */       } else if (scenario1 == null) {
/* 1087 */         Notifications.i().add("Camera scenario is not loaded", null, null, null);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1092 */     if (this.e.x < 0.0F)
/* 1093 */     { if (this.e.x < -this.f) this.e.x = -this.f;
/*      */        }
/* 1095 */     else if (this.e.x > this.f) { this.e.x = this.f; }
/*      */     
/* 1097 */     if (this.e.y < 0.0F)
/* 1098 */     { if (this.e.y < -this.f) this.e.y = -this.f;
/*      */        }
/* 1100 */     else if (this.e.y > this.f) { this.e.y = this.f; }
/*      */ 
/*      */ 
/*      */     
/* 1104 */     if (cameraController != null) {
/* 1105 */       Vector3 vector3 = cameraController.getLookPos();
/* 1106 */       if (!this.e.isZero()) {
/* 1107 */         cameraController.lookAt(vector3.x + this.e.x * paramFloat, vector3.y + this.e.y * paramFloat);
/*      */ 
/*      */         
/* 1110 */         if (!bool1) {
/* 1111 */           if (this.e.x > 0.0F) {
/* 1112 */             this.e.x -= this.i * paramFloat;
/* 1113 */             if (this.e.x < 0.0F) {
/* 1114 */               this.e.x = 0.0F;
/*      */             }
/*      */           } else {
/* 1117 */             this.e.x += this.i * paramFloat;
/* 1118 */             if (this.e.x > 0.0F) {
/* 1119 */               this.e.x = 0.0F;
/*      */             }
/*      */           } 
/*      */         }
/* 1123 */         if (!bool2) {
/* 1124 */           if (this.e.y > 0.0F) {
/* 1125 */             this.e.y -= this.i * paramFloat;
/* 1126 */             if (this.e.y < 0.0F) {
/* 1127 */               this.e.y = 0.0F;
/*      */             }
/*      */           } else {
/* 1130 */             this.e.y += this.i * paramFloat;
/* 1131 */             if (this.e.y > 0.0F) {
/* 1132 */               this.e.y = 0.0F;
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/* 1137 */       if (f != 0.0F) {
/* 1138 */         cameraController.setZoom(cameraController.zoom + f);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1143 */     if (cameraController != null) {
/* 1144 */       Vector3 vector3 = cameraController.getLookPos();
/* 1145 */       this.j.setText((int)vector3.x + " : " + (int)vector3.y);
/* 1146 */       this.j.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*      */       
/* 1148 */       this.k.setText(MathUtils.round((float)cameraController.zoom * 100.0F) / 100.0F);
/* 1149 */       this.l.setText((MathUtils.round(this.e.x * 10.0F) / 10.0F) + " : " + (MathUtils.round(this.e.y * 10.0F) / 10.0F));
/*      */     } else {
/* 1151 */       this.j.setText("No camera");
/* 1152 */       this.j.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */       
/* 1154 */       this.k.setText("-");
/* 1155 */       this.l.setText("-");
/*      */     } 
/*      */ 
/*      */     
/* 1159 */     Scenario scenario = getSelectedScenario();
/* 1160 */     if (cameraController != null && this.x && scenario != null) {
/* 1161 */       SpriteBatch spriteBatch = Game.i.renderingManager.batch;
/* 1162 */       ResourcePack.AtlasTextureRegion atlasTextureRegion1 = Game.i.assetManager.getBlankWhiteTextureRegion();
/* 1163 */       Color color1 = new Color();
/* 1164 */       Color color2 = new Color();
/* 1165 */       Color color3 = MaterialColor.GREEN.P500;
/* 1166 */       Color color4 = MaterialColor.RED.P500;
/* 1167 */       BitmapFont bitmapFont = Game.i.assetManager.getDebugFont(false);
/*      */       
/* 1169 */       spriteBatch.setProjectionMatrix(cameraController.camera.combined);
/*      */       
/* 1171 */       spriteBatch.begin();
/*      */       
/* 1173 */       float f3 = Float.NaN, f4 = Float.NaN, f5 = Float.NaN;
/* 1174 */       double d1 = 0.0D;
/* 1175 */       float f6 = scenario.length / scenario.fps;
/*      */       
/*      */       double d2;
/* 1178 */       for (d2 = 0.0D; d2 <= f6; d2 += 0.05D) {
/* 1179 */         Vector3 vector31 = scenario.calculate((float)d2);
/* 1180 */         if (!Float.isNaN(f3) && !Float.isNaN(f4) && !Float.isNaN(vector31.x) && !Float.isNaN(vector31.y)) {
/* 1181 */           color1.set(color3).lerp(color4, (float)(d1 / f6));
/* 1182 */           color2.set(color3).lerp(color4, (float)(d2 / f6));
/* 1183 */           DrawUtils.texturedLineD((Batch)spriteBatch, (TextureRegion)atlasTextureRegion1, f3, f4, vector31.x, vector31.y, f5 * 2.0F, vector31.z * 2.0F, color1, color2);
/*      */         } 
/* 1185 */         f3 = vector31.x;
/* 1186 */         f4 = vector31.y;
/* 1187 */         f5 = vector31.z;
/* 1188 */         d1 = d2;
/*      */       } 
/*      */ 
/*      */       
/* 1192 */       ResourcePack.AtlasTextureRegion atlasTextureRegion2 = Game.i.assetManager.getTextureRegion("circle");
/* 1193 */       byte b = -1;
/* 1194 */       for (byte b2 = 0; b2 < scenario.length; b2++) {
/* 1195 */         Vector3 vector31 = scenario.calculate(b2 / scenario.fps);
/*      */         
/* 1197 */         if (b2 != b) {
/* 1198 */           for (byte b3 = 0; b3 < scenario.keyframes.size; ) {
/*      */             Scenario.Keyframe keyframe;
/* 1200 */             if ((keyframe = ((Scenario.Keyframe[])scenario.keyframes.items)[b3]).frame == b2) {
/*      */               
/* 1202 */               spriteBatch.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/* 1203 */               spriteBatch.draw((TextureRegion)atlasTextureRegion2, vector31.x - 8.0F, vector31.y - 8.0F, 16.0F, 16.0F);
/* 1204 */               spriteBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/* 1205 */               bitmapFont.draw((Batch)spriteBatch, String.valueOf(b2), vector31.x - 1.0F, vector31.y + 3.0F, 2.0F, 1, false);
/*      */             } 
/*      */             
/* 1208 */             if (keyframe.frame < b2) {
/*      */               b3++;
/*      */             }
/*      */           } 
/*      */           
/* 1213 */           b = b2;
/*      */         } 
/*      */       } 
/*      */       
/* 1217 */       spriteBatch.end();
/*      */ 
/*      */       
/* 1220 */       spriteBatch.setProjectionMatrix((Game.i.uiManager.stage.getCamera()).combined);
/*      */       
/* 1222 */       f3 = Float.NaN;
/* 1223 */       f4 = Float.NaN;
/*      */       
/* 1225 */       byte b1 = 0;
/* 1226 */       spriteBatch.begin();
/* 1227 */       float f2 = (new Color(1.0F, 1.0F, 1.0F, 0.14F)).toFloatBits();
/*      */       double d3;
/* 1229 */       for (d3 = 0.0D; d3 <= f6; d3 += 0.01D) {
/* 1230 */         Vector3 vector31 = scenario.calculate((float)d3);
/* 1231 */         if (!Float.isNaN(f3) && !Float.isNaN(f4) && !Float.isNaN(vector31.x) && !Float.isNaN(vector31.y)) {
/* 1232 */           float f8 = (float)(PMath.getDistanceBetweenPoints(vector31.x, vector31.y, f3, f4) / 0.01D);
/* 1233 */           DrawUtils.texturedLineC((Batch)spriteBatch, (TextureRegion)atlasTextureRegion1, b1, 0.0F, b1, f8 * 0.5F, 2.0F, f2, f2);
/*      */         } 
/*      */         
/* 1236 */         f3 = vector31.x;
/* 1237 */         f4 = vector31.y;
/* 1238 */         b1++;
/*      */       } 
/*      */       
/* 1241 */       f2 = MaterialColor.GREEN.P500.toFloatBits();
/*      */       
/*      */       Vector3 vector3;
/*      */       
/* 1245 */       float f7 = (vector3 = scenario.calculate((float)(cameraController.scenarioTime - 0.005D))).x;
/* 1246 */       float f1 = vector3.y;
/*      */ 
/*      */ 
/*      */       
/* 1250 */       if (cameraController.currentScenario != null && !Float.isNaN((vector3 = scenario.calculate((float)(cameraController.scenarioTime + 0.005D))).x) && !Float.isNaN(vector3.y) && !Float.isNaN(f7) && !Float.isNaN(f1)) {
/* 1251 */         float f9 = (float)(PMath.getDistanceBetweenPoints(vector3.x, vector3.y, f7, f1) / 0.01D);
/* 1252 */         float f8 = (float)(cameraController.scenarioTime / 0.01D);
/* 1253 */         DrawUtils.texturedLineC((Batch)spriteBatch, (TextureRegion)atlasTextureRegion1, f8, 0.0F, f8, f9 * 0.5F, 4.0F, f2, f2);
/*      */       } 
/*      */ 
/*      */       
/* 1257 */       spriteBatch.end();
/*      */     } 
/*      */     
/* 1260 */     if (isVisible()) {
/* 1261 */       d();
/*      */     }
/*      */   }
/*      */   
/*      */   public final boolean isVisible() {
/* 1266 */     return this.b.getTable().isVisible();
/*      */   }
/*      */   
/*      */   public final void setVisible(boolean paramBoolean) {
/* 1270 */     this.b.getTable().setVisible(paramBoolean);
/* 1271 */     if (paramBoolean) {
/* 1272 */       update(); return;
/*      */     } 
/* 1274 */     Game.i.uiManager.stage.unfocusAll();
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
/*      */ 
/*      */   
/*      */   public static class Scenario
/*      */   {
/* 1323 */     public String name = "CS";
/*      */     
/* 1325 */     public int fps = 4;
/* 1326 */     public int length = 40;
/* 1327 */     public int startFrame = 0;
/*      */     
/* 1329 */     private static final Vector3 a = new Vector3(); private static final Comparator<Keyframe> b;
/*      */     static {
/* 1331 */       b = ((param1Keyframe1, param1Keyframe2) -> Integer.compare(param1Keyframe1.frame, param1Keyframe2.frame));
/*      */     }
/* 1333 */     public Array<Keyframe> keyframes = new Array(true, 1, Keyframe.class);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public double getDuration() {
/* 1339 */       return this.length / this.fps;
/*      */     }
/*      */ 
/*      */     
/*      */     public Vector3 calculate(float param1Float) {
/* 1344 */       if (param1Float > this.length / this.fps) {
/* 1345 */         param1Float = this.length / this.fps;
/*      */       }
/* 1347 */       int i = (int)(param1Float * this.fps);
/*      */ 
/*      */       
/* 1350 */       a.x = Float.NaN;
/* 1351 */       Keyframe keyframe2 = null, keyframe3 = null;
/* 1352 */       int k = 0; int n;
/* 1353 */       for (n = this.keyframes.size - 1; n >= 0; n--) {
/*      */         Keyframe keyframe;
/* 1355 */         if ((keyframe = ((Keyframe[])this.keyframes.items)[n]).frame <= i && !Float.isNaN(keyframe.x)) {
/* 1356 */           keyframe2 = keyframe;
/* 1357 */           k = n;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1361 */       if (keyframe2 != null) {
/* 1362 */         for (n = k + 1; n < this.keyframes.size; n++) {
/*      */           Keyframe keyframe;
/* 1364 */           if ((keyframe = ((Keyframe[])this.keyframes.items)[n]).frame > i && !Float.isNaN(keyframe.x)) {
/* 1365 */             keyframe3 = keyframe;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/* 1370 */         if (keyframe3 == null) {
/* 1371 */           a.x = keyframe2.x;
/*      */         } else {
/*      */           float f;
/* 1374 */           if (keyframe2.frame == keyframe3.frame) {
/* 1375 */             f = 1.0F;
/*      */           } else {
/* 1377 */             float f2 = keyframe2.frame / this.fps;
/* 1378 */             float f1 = keyframe3.frame / this.fps;
/* 1379 */             f = (param1Float - f2) / (f1 - f2);
/*      */           } 
/*      */           
/* 1382 */           a.x = InterpolationType.getObject(keyframe3.iX).apply(keyframe2.x, keyframe3.x, f);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1387 */       a.y = Float.NaN;
/* 1388 */       Keyframe keyframe4 = null, keyframe5 = null;
/* 1389 */       k = 0; int j;
/* 1390 */       for (j = this.keyframes.size - 1; j >= 0; j--) {
/*      */         
/* 1392 */         if ((keyframe3 = ((Keyframe[])this.keyframes.items)[j]).frame <= i && !Float.isNaN(keyframe3.y)) {
/* 1393 */           keyframe4 = keyframe3;
/* 1394 */           k = j;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1398 */       if (keyframe4 != null) {
/* 1399 */         for (j = k + 1; j < this.keyframes.size; j++) {
/*      */           
/* 1401 */           if ((keyframe3 = ((Keyframe[])this.keyframes.items)[j]).frame > i && !Float.isNaN(keyframe3.y)) {
/* 1402 */             keyframe5 = keyframe3;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/* 1407 */         if (keyframe5 == null) {
/* 1408 */           a.y = keyframe4.y;
/*      */         } else {
/*      */           float f;
/* 1411 */           if (keyframe4.frame == keyframe5.frame) {
/* 1412 */             f = 1.0F;
/*      */           } else {
/* 1414 */             float f1 = keyframe4.frame / this.fps;
/* 1415 */             float f2 = keyframe5.frame / this.fps;
/* 1416 */             f = (param1Float - f1) / (f2 - f1);
/*      */           } 
/*      */           
/* 1419 */           a.y = InterpolationType.getObject(keyframe5.iY).apply(keyframe4.y, keyframe5.y, f);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1424 */       a.z = Float.NaN;
/* 1425 */       Keyframe keyframe1 = null; keyframe3 = null;
/* 1426 */       k = 0; int m;
/* 1427 */       for (m = this.keyframes.size - 1; m >= 0; m--) {
/*      */         
/* 1429 */         if ((keyframe5 = ((Keyframe[])this.keyframes.items)[m]).frame <= i && !Float.isNaN(keyframe5.z)) {
/* 1430 */           keyframe1 = keyframe5;
/* 1431 */           k = m;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1435 */       if (keyframe1 != null) {
/* 1436 */         for (m = k + 1; m < this.keyframes.size; m++) {
/*      */           
/* 1438 */           if ((keyframe5 = ((Keyframe[])this.keyframes.items)[m]).frame > i && !Float.isNaN(keyframe5.z)) {
/* 1439 */             keyframe3 = keyframe5;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/* 1444 */         if (keyframe3 == null) {
/* 1445 */           a.z = keyframe1.z;
/*      */         } else {
/*      */           float f;
/* 1448 */           if (keyframe1.frame == keyframe3.frame) {
/* 1449 */             f = 1.0F;
/*      */           } else {
/* 1451 */             float f2 = keyframe1.frame / this.fps;
/* 1452 */             float f1 = keyframe3.frame / this.fps;
/* 1453 */             f = (param1Float - f2) / (f1 - f2);
/*      */           } 
/*      */           
/* 1456 */           a.z = InterpolationType.getObject(keyframe3.iZ).apply(keyframe1.z, keyframe3.z, f);
/*      */         } 
/*      */       } 
/*      */       
/* 1460 */       return a;
/*      */     }
/*      */     
/*      */     public Keyframe getKeyframe(int param1Int) {
/* 1464 */       for (byte b = 0; b < this.keyframes.size; b++) {
/* 1465 */         if ((((Keyframe[])this.keyframes.items)[b]).frame == param1Int) {
/* 1466 */           return ((Keyframe[])this.keyframes.items)[b];
/*      */         }
/*      */       } 
/* 1469 */       return null;
/*      */     }
/*      */     
/*      */     public void removeKeyframe(int param1Int) {
/*      */       Keyframe keyframe;
/* 1474 */       if ((keyframe = getKeyframe(param1Int)) != null) {
/* 1475 */         this.keyframes.removeValue(keyframe, true);
/*      */       }
/*      */     }
/*      */     
/*      */     public Keyframe setKeyframe(int param1Int, float param1Float1, InterpolationType param1InterpolationType1, float param1Float2, InterpolationType param1InterpolationType2, float param1Float3, InterpolationType param1InterpolationType3) {
/* 1480 */       if (Float.isNaN(param1Float1) && Float.isNaN(param1Float2) && Float.isNaN(param1Float3)) {
/* 1481 */         removeKeyframe(param1Int);
/* 1482 */         return null;
/*      */       } 
/*      */       
/*      */       Keyframe keyframe;
/* 1486 */       if ((keyframe = getKeyframe(param1Int)) == null) {
/*      */         
/* 1488 */         (keyframe = new Keyframe()).frame = param1Int;
/* 1489 */         this.keyframes.add(keyframe);
/* 1490 */         this.keyframes.sort(b);
/*      */       } 
/*      */       
/* 1493 */       keyframe.x = param1Float1;
/* 1494 */       keyframe.iX = param1InterpolationType1;
/* 1495 */       keyframe.y = param1Float2;
/* 1496 */       keyframe.iY = param1InterpolationType2;
/* 1497 */       keyframe.z = param1Float3;
/* 1498 */       keyframe.iZ = param1InterpolationType3;
/*      */       
/* 1500 */       return keyframe;
/*      */     }
/*      */     
/*      */     public void setKeyframeX(int param1Int, float param1Float, InterpolationType param1InterpolationType) {
/* 1504 */       Keyframe keyframe = getKeyframe(param1Int);
/* 1505 */       if (param1InterpolationType == null) {
/* 1506 */         if (keyframe == null) {
/* 1507 */           param1InterpolationType = InterpolationType.linear;
/*      */         } else {
/* 1509 */           param1InterpolationType = keyframe.iX;
/*      */         } 
/*      */       }
/*      */       
/* 1513 */       if (keyframe == null) {
/* 1514 */         setKeyframe(param1Int, param1Float, param1InterpolationType, Float.NaN, null, Float.NaN, null); return;
/*      */       } 
/* 1516 */       setKeyframe(param1Int, param1Float, param1InterpolationType, keyframe.y, keyframe.iY, keyframe.z, keyframe.iZ);
/*      */     }
/*      */ 
/*      */     
/*      */     public void setKeyframeY(int param1Int, float param1Float, InterpolationType param1InterpolationType) {
/* 1521 */       Keyframe keyframe = getKeyframe(param1Int);
/* 1522 */       if (param1InterpolationType == null) {
/* 1523 */         if (keyframe == null) {
/* 1524 */           param1InterpolationType = InterpolationType.linear;
/*      */         } else {
/* 1526 */           param1InterpolationType = keyframe.iY;
/*      */         } 
/*      */       }
/*      */       
/* 1530 */       if (keyframe == null) {
/* 1531 */         setKeyframe(param1Int, Float.NaN, null, param1Float, param1InterpolationType, Float.NaN, null); return;
/*      */       } 
/* 1533 */       setKeyframe(param1Int, keyframe.x, keyframe.iX, param1Float, param1InterpolationType, keyframe.z, keyframe.iZ);
/*      */     }
/*      */ 
/*      */     
/*      */     public void setKeyframeZ(int param1Int, float param1Float, InterpolationType param1InterpolationType) {
/* 1538 */       Keyframe keyframe = getKeyframe(param1Int);
/* 1539 */       if (param1InterpolationType == null) {
/* 1540 */         if (keyframe == null) {
/* 1541 */           param1InterpolationType = InterpolationType.linear;
/*      */         } else {
/* 1543 */           param1InterpolationType = keyframe.iZ;
/*      */         } 
/*      */       }
/*      */       
/* 1547 */       if (keyframe == null) {
/* 1548 */         setKeyframe(param1Int, Float.NaN, null, Float.NaN, null, param1Float, param1InterpolationType); return;
/*      */       } 
/* 1550 */       setKeyframe(param1Int, keyframe.x, keyframe.iX, keyframe.y, keyframe.iY, param1Float, param1InterpolationType);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Scenario fromJson(JsonValue param1JsonValue) {
/*      */       Scenario scenario;
/* 1557 */       (scenario = new Scenario()).name = param1JsonValue.getString("name");
/* 1558 */       scenario.fps = param1JsonValue.getInt("fps");
/* 1559 */       scenario.length = param1JsonValue.getInt("length");
/* 1560 */       scenario.startFrame = param1JsonValue.getInt("startFrame", 0);
/*      */       
/*      */       try {
/* 1563 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = param1JsonValue.get("keyframes").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 1564 */           scenario.keyframes.add(Keyframe.fromJson(jsonValue)); }
/*      */         
/* 1566 */         scenario.keyframes.sort(b);
/* 1567 */       } catch (Exception exception) {}
/*      */       
/* 1569 */       return scenario;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void toJson(Json param1Json) {
/* 1576 */       param1Json.writeValue("name", this.name);
/* 1577 */       param1Json.writeValue("fps", Integer.valueOf(this.fps));
/* 1578 */       param1Json.writeValue("length", Integer.valueOf(this.length));
/* 1579 */       param1Json.writeValue("startFrame", Integer.valueOf(this.startFrame));
/* 1580 */       param1Json.writeArrayStart("keyframes");
/* 1581 */       for (byte b = 0; b < this.keyframes.size; b++) {
/* 1582 */         param1Json.writeObjectStart();
/* 1583 */         ((Keyframe[])this.keyframes.items)[b].toJson(param1Json);
/* 1584 */         param1Json.writeObjectEnd();
/*      */       } 
/* 1586 */       param1Json.writeArrayEnd();
/*      */     }
/*      */     
/*      */     public static class Keyframe
/*      */     {
/*      */       public int frame;
/*      */       public float x;
/* 1593 */       public InterpolationType iX = InterpolationType.linear;
/*      */       
/*      */       public float y;
/* 1596 */       public InterpolationType iY = InterpolationType.linear;
/*      */       
/*      */       public float z;
/* 1599 */       public InterpolationType iZ = InterpolationType.linear;
/*      */ 
/*      */       
/*      */       public static Keyframe fromJson(JsonValue param2JsonValue) {
/*      */         Keyframe keyframe;
/* 1604 */         (keyframe = new Keyframe()).frame = param2JsonValue.getInt("f");
/*      */         
/* 1606 */         keyframe.x = param2JsonValue.getFloat("x", Float.NaN);
/* 1607 */         if (!Float.isNaN(keyframe.x)) {
/*      */           try {
/* 1609 */             keyframe.iX = InterpolationType.valueOf(param2JsonValue.getString("iX"));
/* 1610 */           } catch (Exception exception) {}
/*      */         }
/* 1612 */         keyframe.y = param2JsonValue.getFloat("y", Float.NaN);
/* 1613 */         if (!Float.isNaN(keyframe.y)) {
/*      */           try {
/* 1615 */             keyframe.iY = InterpolationType.valueOf(param2JsonValue.getString("iY"));
/* 1616 */           } catch (Exception exception) {}
/*      */         }
/* 1618 */         keyframe.z = param2JsonValue.getFloat("z", Float.NaN);
/* 1619 */         if (!Float.isNaN(keyframe.z)) {
/*      */           try {
/* 1621 */             keyframe.iZ = InterpolationType.valueOf(param2JsonValue.getString("iZ"));
/* 1622 */           } catch (Exception exception) {}
/*      */         }
/*      */         
/* 1625 */         return keyframe;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public void toJson(Json param2Json)
/*      */       {
/* 1632 */         param2Json.writeValue("f", Integer.valueOf(this.frame));
/*      */         
/* 1634 */         if (!Float.isNaN(this.x)) {
/* 1635 */           param2Json.writeValue("x", Float.valueOf(this.x));
/* 1636 */           param2Json.writeValue("iX", this.iX.name());
/*      */         } 
/* 1638 */         if (!Float.isNaN(this.y)) {
/* 1639 */           param2Json.writeValue("y", Float.valueOf(this.y));
/* 1640 */           param2Json.writeValue("iY", this.iY.name());
/*      */         } 
/* 1642 */         if (!Float.isNaN(this.z))
/* 1643 */         { param2Json.writeValue("z", Float.valueOf(this.z));
/* 1644 */           param2Json.writeValue("iZ", this.iZ.name()); }  } } } public static class Keyframe { public void toJson(Json param1Json) { param1Json.writeValue("f", Integer.valueOf(this.frame)); if (!Float.isNaN(this.x)) { param1Json.writeValue("x", Float.valueOf(this.x)); param1Json.writeValue("iX", this.iX.name()); }  if (!Float.isNaN(this.y)) { param1Json.writeValue("y", Float.valueOf(this.y)); param1Json.writeValue("iY", this.iY.name()); }  if (!Float.isNaN(this.z)) { param1Json.writeValue("z", Float.valueOf(this.z)); param1Json.writeValue("iZ", this.iZ.name()); }
/*      */        }
/*      */ 
/*      */     
/*      */     public int frame;
/*      */     public float x;
/*      */     public InterpolationType iX;
/*      */     public float y;
/*      */     public InterpolationType iY;
/*      */     public float z;
/*      */     public InterpolationType iZ;
/*      */     
/*      */     public Keyframe() {
/*      */       this.iX = InterpolationType.linear;
/*      */       this.iY = InterpolationType.linear;
/*      */       this.iZ = InterpolationType.linear;
/*      */     }
/*      */     
/*      */     public static Keyframe fromJson(JsonValue param1JsonValue) {
/*      */       Keyframe keyframe;
/*      */       (keyframe = new Keyframe()).frame = param1JsonValue.getInt("f");
/*      */       keyframe.x = param1JsonValue.getFloat("x", Float.NaN);
/*      */       if (!Float.isNaN(keyframe.x))
/*      */         try {
/*      */           keyframe.iX = InterpolationType.valueOf(param1JsonValue.getString("iX"));
/*      */         } catch (Exception exception) {} 
/*      */       keyframe.y = param1JsonValue.getFloat("y", Float.NaN);
/*      */       if (!Float.isNaN(keyframe.y))
/*      */         try {
/*      */           keyframe.iY = InterpolationType.valueOf(param1JsonValue.getString("iY"));
/*      */         } catch (Exception exception) {} 
/*      */       keyframe.z = param1JsonValue.getFloat("z", Float.NaN);
/*      */       if (!Float.isNaN(keyframe.z))
/*      */         try {
/*      */           keyframe.iZ = InterpolationType.valueOf(param1JsonValue.getString("iZ"));
/*      */         } catch (Exception exception) {} 
/*      */       return keyframe;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\CameraTools.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */