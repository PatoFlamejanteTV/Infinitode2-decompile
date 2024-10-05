/*      */ package com.prineside.tdi2.ui.shared;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.Cursor;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Disposable;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.badlogic.gdx.utils.UBJsonReader;
/*      */ import com.badlogic.gdx.utils.UBJsonWriter;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.events.Listener;
/*      */ import com.prineside.tdi2.events.global.ScreenResize;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.managers.script.ScriptEnvironment;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.EventListener;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.InputEvent;
/*      */ import com.prineside.tdi2.scene2d.InputListener;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.ui.Image;
/*      */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*      */ import com.prineside.tdi2.scene2d.ui.Stack;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.ui.TextField;
/*      */ import com.prineside.tdi2.scene2d.ui.VerticalGroup;
/*      */ import com.prineside.tdi2.scene2d.ui.WidgetGroup;
/*      */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*      */ import com.prineside.tdi2.screens.GameScreen;
/*      */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*      */ import com.prineside.tdi2.ui.actors.RectButton;
/*      */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*      */ import com.prineside.tdi2.utils.FileUtils;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.ObjectPair;
/*      */ import com.prineside.tdi2.utils.Quad;
/*      */ import com.prineside.tdi2.utils.StringFormatter;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.logging.LogLevel;
/*      */ import com.prineside.tdi2.utils.logging.LogWriter;
/*      */ import com.prineside.tdi2.utils.logging.Logger;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.File;
/*      */ import java.io.FileReader;
/*      */ import java.io.IOException;
/*      */ import java.io.OutputStream;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.regex.Matcher;
/*      */ 
/*      */ public class DeveloperConsole
/*      */   implements Disposable, UiManager.UiComponent {
/*   70 */   private static final TLog a = TLog.forClass(DeveloperConsole.class); @Null
/*      */   public static DeveloperConsole i() {
/*   72 */     if ((Config.isModdingMode() || Game.i.progressManager.isDeveloperModeEnabled()) && 
/*   73 */       Game.i.progressManager.isDeveloperModeEnabled()) {
/*   74 */       return (DeveloperConsole)Game.i.uiManager.getComponent(DeveloperConsole.class);
/*      */     }
/*      */ 
/*      */     
/*   78 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*   83 */   private static final Color[] b = new Color[] { MaterialColor.BLUE.P300, MaterialColor.BLUE_GREY.P300, MaterialColor.GREEN.P300, MaterialColor.PURPLE.P300, MaterialColor.YELLOW.P300, MaterialColor.LIGHT_BLUE.P300, MaterialColor.GREY.P300, MaterialColor.CYAN.P300, MaterialColor.ORANGE.P300, MaterialColor.INDIGO.P300, MaterialColor.RED.P300, MaterialColor.TEAL.P300, MaterialColor.AMBER.P300, MaterialColor.PINK.P300, MaterialColor.LIME.P300, MaterialColor.LIGHT_GREEN.P300, MaterialColor.DEEP_PURPLE.P300, MaterialColor.DEEP_ORANGE.P300, MaterialColor.BROWN.P300 };
/*      */ 
/*      */ 
/*      */   
/*      */   private final UiManager.UiLayer c;
/*      */ 
/*      */ 
/*      */   
/*      */   private final UiManager.UiLayer d;
/*      */ 
/*      */ 
/*      */   
/*      */   private final UiManager.UiLayer e;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean f;
/*      */ 
/*      */   
/*      */   private final VerticalGroup g;
/*      */ 
/*      */   
/*      */   private final Group h;
/*      */ 
/*      */   
/*      */   private final TextField i;
/*      */ 
/*      */   
/*      */   private final ScrollPane j;
/*      */ 
/*      */   
/*  114 */   private final Array<LogLine> k = new Array(LogLine.class);
/*      */   
/*      */   private final Label.LabelStyle l;
/*      */   
/*      */   private final Label.LabelStyle m;
/*      */   private final Label.LabelStyle n;
/*      */   private final ComplexButton o;
/*      */   private final ComplexButton p;
/*      */   public final Table buttonsNStuff;
/*      */   private Table q;
/*      */   private Label r;
/*      */   private ScriptEnvironment.Suggestion s;
/*      */   
/*      */   public void hide() {
/*  128 */     setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isPersistent() {
/*  133 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void preRender(float paramFloat) {
/*  138 */     if (!this.f)
/*      */       return; 
/*  140 */     if (this.z != null) {
/*      */       try {
/*  142 */         String str1 = this.z.readLine();
/*  143 */         String str2 = null;
/*  144 */         Array array = new Array();
/*  145 */         long l = 0L;
/*  146 */         byte b = 1;
/*  147 */         StringBuilder stringBuilder = new StringBuilder();
/*      */         
/*  149 */         while (str1 != null) {
/*  150 */           Matcher matcher = LogWriter.LOG_FILE_ENTRY_REGEX.matcher("");
/*      */           try {
/*  152 */             matcher.reset(str1);
/*  153 */             if (matcher.find()) {
/*      */               
/*  155 */               if (str2 != null) {
/*      */                 
/*  157 */                 array.add(new Logger.LogEntry(b, l, str2, stringBuilder.toString()));
/*  158 */                 stringBuilder.setLength(0);
/*      */               } 
/*  160 */               String str = matcher.group(1);
/*  161 */               l = LogWriter.LOG_DATE_FORMAT.parse(str).getTime();
/*  162 */               b = LogLevel.shortNameToLevel(matcher.group(2).charAt(0));
/*  163 */               str2 = matcher.group(3);
/*  164 */               stringBuilder.append(str1.substring(matcher.group().length()));
/*      */             } else {
/*      */               
/*  167 */               stringBuilder.append('\n').append(str1);
/*      */             } 
/*  169 */           } catch (Exception exception) {
/*  170 */             System.out.println("Failed to parse log line: " + str1);
/*  171 */             exception.printStackTrace(System.out);
/*      */           } 
/*      */           
/*  174 */           str1 = this.z.readLine();
/*      */         } 
/*      */         
/*  177 */         if (str2 != null) {
/*      */           
/*  179 */           array.add(new Logger.LogEntry(b, l, str2, stringBuilder.toString()));
/*  180 */           stringBuilder.setLength(0);
/*      */         } 
/*      */         
/*  183 */         for (byte b1 = 0; b1 < array.size; b1++)
/*  184 */           a((Logger.LogEntry)array.get(b1)); 
/*      */         return;
/*  186 */       } catch (Exception exception) {
/*  187 */         System.err.println("Failed to read log file");
/*  188 */         exception.printStackTrace();
/*  189 */         this.z = null;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void postRender(float paramFloat) {}
/*      */   
/*      */   private static class CustomSettingsUI
/*      */   {
/*      */     TextFieldXPlatform a;
/*      */     LabelToggleButton b;
/*      */     
/*      */     private CustomSettingsUI() {}
/*      */   }
/*  204 */   private final CustomSettingsUI[] t = new CustomSettingsUI[SettingsManager.CustomValueType.values.length];
/*      */   
/*      */   private final Listener<ScreenResize> u = paramScreenResize -> h();
/*      */   
/*  208 */   private int v = 0;
/*  209 */   private final Array<String> w = new Array((Object[])new String[] { "" });
/*      */   
/*  211 */   private static final Calendar x = new GregorianCalendar();
/*  212 */   private static final StringBuilder y = new StringBuilder();
/*      */ 
/*      */   
/*      */   private BufferedReader z;
/*      */ 
/*      */   
/*      */   public DeveloperConsole() {
/*  219 */     a.i("creating DeveloperConsole", new Object[0]);
/*  220 */     this.d = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.OVERLAY, 9000, "DeveloperConsole background", true);
/*  221 */     this.d.ignoreVisibleFrame = true;
/*      */     
/*  223 */     this.e = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 9001, "DeveloperConsole main");
/*  224 */     this.e.followVisibleFrame = true;
/*  225 */     this.e.ignoreVisibleFrame = true;
/*  226 */     Game.i.uiManager.rebuildLayers();
/*      */     
/*  228 */     this.c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 9002, "DeveloperConsole toggle button");
/*      */     
/*  230 */     this.l = new Label.LabelStyle(Game.i.assetManager.getDebugFont(false), Color.WHITE);
/*  231 */     this.m = new Label.LabelStyle(Game.i.assetManager.getDebugFont(false), Color.WHITE);
/*  232 */     this.n = new Label.LabelStyle(Game.i.assetManager.getDebugFont(true), Color.WHITE);
/*      */ 
/*      */     
/*  235 */     Drawable drawable = (new TextureRegionDrawable((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).tint(new Color(233));
/*  236 */     this.d.getTable().setBackground(drawable);
/*      */     
/*      */     WidgetGroup widgetGroup;
/*  239 */     (widgetGroup = new WidgetGroup()).setTransform(false);
/*  240 */     this.e.getTable().add((Actor)widgetGroup).expand().fill().pad(8.0F);
/*      */     
/*      */     Table table2;
/*      */     
/*  244 */     (table2 = new Table()).setFillParent(true);
/*  245 */     widgetGroup.addActor((Actor)table2);
/*      */     
/*      */     Table table3;
/*  248 */     (table3 = new Table()).setTouchable(Touchable.childrenOnly);
/*  249 */     table3.setFillParent(true);
/*  250 */     widgetGroup.addActor((Actor)table3);
/*      */     
/*  252 */     this.buttonsNStuff = new Table();
/*  253 */     table3.add((Actor)this.buttonsNStuff).expand().top().left().padLeft(-8.0F).padTop(0.0F);
/*      */ 
/*      */     
/*  256 */     this.h = new Group();
/*  257 */     this.h.setTransform(false);
/*  258 */     this.h.setSize(560.0F, 600.0F);
/*  259 */     this.h.setPosition(96.0F, -438.0F);
/*  260 */     this.h.setVisible(false);
/*  261 */     this.buttonsNStuff.addActor((Actor)this.h);
/*      */     
/*      */     Image image;
/*  264 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(560.0F, 600.0F);
/*  265 */     image.setColor(0.1F, 0.1F, 0.1F, 1.0F);
/*  266 */     this.h.addActor((Actor)image);
/*      */     
/*  268 */     Table table1 = new Table();
/*      */     
/*  270 */     TextField.TextFieldStyle textFieldStyle1 = Game.i.assetManager.getTextFieldStyle(21);
/*      */     
/*  272 */     SettingsManager.CustomValueType[] arrayOfCustomValueType = new SettingsManager.CustomValueType[SettingsManager.CustomValueType.values.length];
/*  273 */     System.arraycopy(SettingsManager.CustomValueType.values, 0, arrayOfCustomValueType, 0, SettingsManager.CustomValueType.values.length);
/*  274 */     Arrays.sort(arrayOfCustomValueType, (paramCustomValueType1, paramCustomValueType2) -> paramCustomValueType1.name().compareTo(paramCustomValueType2.name())); int i;
/*      */     byte b;
/*  276 */     for (i = (arrayOfCustomValueType = arrayOfCustomValueType).length, b = 0; b < i; ) { SettingsManager.CustomValueType customValueType = arrayOfCustomValueType[b];
/*  277 */       CustomSettingsUI customSettingsUI = new CustomSettingsUI((byte)0);
/*  278 */       this.t[customValueType.ordinal()] = customSettingsUI;
/*      */       
/*  280 */       LabelToggleButton labelToggleButton = new LabelToggleButton(customValueType.name(), (Game.i.settingsManager.getCustomValue(customValueType) != 0.0D), 21, 24.0F, paramBoolean -> {
/*      */             if (paramBoolean.booleanValue()) {
/*      */               Game.i.settingsManager.setCustomValue(paramCustomValueType, 1.0D);
/*      */             } else {
/*      */               Game.i.settingsManager.setCustomValue(paramCustomValueType, 0.0D);
/*      */             } 
/*      */             paramCustomSettingsUI.a.setText(Game.i.settingsManager.getCustomValue(paramCustomValueType));
/*      */           });
/*  288 */       customSettingsUI.b = labelToggleButton;
/*  289 */       table1.add((Actor)labelToggleButton).size(460.0F, 24.0F).padBottom(2.0F);
/*      */       
/*  291 */       customSettingsUI.a = new TextFieldXPlatform(Game.i.settingsManager.getCustomValue(customValueType), textFieldStyle1);
/*  292 */       customSettingsUI.a.addListener((EventListener)new ChangeListener(this, customSettingsUI, customValueType)
/*      */           {
/*      */             public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*      */               try {
/*  296 */                 double d = Double.parseDouble(this.a.a.getText());
/*  297 */                 Game.i.settingsManager.setCustomValue(this.b, d);
/*  298 */                 this.a.b.setEnabled((d != 0.0D)); return;
/*  299 */               } catch (Exception exception) {
/*      */                 return;
/*      */               }  } });
/*  302 */       table1.add((Actor)customSettingsUI.a).size(80.0F, 24.0F).padBottom(2.0F).row(); b++; }
/*      */     
/*      */     ScrollPane scrollPane;
/*  305 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)table1));
/*  306 */     scrollPane.setSize(540.0F, 600.0F);
/*  307 */     scrollPane.setPosition(10.0F, 0.0F);
/*  308 */     this.h.addActor((Actor)scrollPane);
/*      */     
/*      */     ComplexButton complexButton3;
/*  311 */     (complexButton3 = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> setCustomSettingsVisible(!isCustomSettingsVisible()))).setBackground((Drawable)Game.i.assetManager.getQuad("ui.console.buttonBg"), 0.0F, 0.0F, 80.0F, 52.0F);
/*  312 */     complexButton3.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-tools"), 24.0F, 10.0F, 32.0F, 32.0F);
/*  313 */     complexButton3.setBackgroundColors(MaterialColor.DEEP_ORANGE.P800, MaterialColor.DEEP_ORANGE.P900, MaterialColor.DEEP_ORANGE.P700, Color.BLACK);
/*  314 */     this.buttonsNStuff.add((Actor)complexButton3).size(80.0F, 52.0F).top().left().padBottom(4.0F).row();
/*      */ 
/*      */     
/*      */     ComplexButton complexButton4;
/*      */ 
/*      */     
/*  320 */     (complexButton4 = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> { ItemCreationOverlay.i().show(); setVisible(false); })).setBackground((Drawable)Game.i.assetManager.getQuad("ui.console.buttonBg"), 0.0F, 0.0F, 80.0F, 52.0F);
/*  321 */     complexButton4.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-backpack"), 24.0F, 10.0F, 32.0F, 32.0F);
/*  322 */     complexButton4.setBackgroundColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P900, MaterialColor.LIGHT_GREEN.P700, Color.BLACK);
/*  323 */     this.buttonsNStuff.add((Actor)complexButton4).size(80.0F, 52.0F).top().left().padBottom(4.0F).row();
/*      */ 
/*      */     
/*      */     ComplexButton complexButton5;
/*      */ 
/*      */     
/*  329 */     (complexButton5 = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> { StateDebugger.i().show(); setVisible(false); })).setBackground((Drawable)Game.i.assetManager.getQuad("ui.console.buttonBg"), 0.0F, 0.0F, 80.0F, 52.0F);
/*  330 */     complexButton5.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-magnifying-glass"), 24.0F, 10.0F, 32.0F, 32.0F);
/*  331 */     complexButton5.setBackgroundColors(MaterialColor.LIME.P800, MaterialColor.LIME.P900, MaterialColor.LIME.P700, Color.BLACK);
/*  332 */     this.buttonsNStuff.add((Actor)complexButton5).size(80.0F, 52.0F).top().left().padBottom(4.0F).row();
/*      */ 
/*      */     
/*  335 */     this.g = new VerticalGroup();
/*  336 */     this.g.grow();
/*  337 */     this.g.padTop(220.0F);
/*      */     
/*  339 */     this.j = new ScrollPane((Actor)this.g, Game.i.assetManager.getScrollPaneStyle(16.0F));
/*  340 */     this.j.setOverscroll(false, false);
/*  341 */     UiUtils.enableMouseMoveScrollFocus(this.j);
/*      */ 
/*      */     
/*  344 */     Table table4 = new Table();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  351 */     TextField.TextFieldStyle textFieldStyle2 = new TextField.TextFieldStyle(Game.i.assetManager.getLargeDebugFont(false), Color.WHITE, (Drawable)new Quad(Game.i.assetManager.getQuad("ui.textField.console.cursor"), true), (Drawable)new Quad(Game.i.assetManager.getQuad("ui.textField.console.selection"), true), (Drawable)new Quad(Game.i.assetManager.getQuad("ui.textField.console.background"), true));
/*      */ 
/*      */     
/*  354 */     this.i = (TextField)new TextFieldXPlatform("", textFieldStyle2);
/*  355 */     this.i.setFocusTraversal(false);
/*  356 */     table4.add((Actor)this.i).expandX().fillX().height(64.0F);
/*      */     
/*  358 */     this.r = new Label("", new Label.LabelStyle(Game.i.assetManager.getLargeDebugFont(false), Color.WHITE));
/*  359 */     this.r.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  360 */     this.r.setHeight(64.0F);
/*  361 */     this.r.setWidth(400.0F);
/*  362 */     this.r.setTouchable(Touchable.disabled);
/*  363 */     this.r.setX(15.0F);
/*  364 */     this.r.setY(0.0F);
/*  365 */     table4.addActor((Actor)this.r);
/*      */     
/*  367 */     this.q = new Table();
/*  368 */     this.q.background(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.BLUE_GREY.P900));
/*  369 */     this.q.setSize(600.0F, 200.0F);
/*  370 */     table4.addActorAt(0, (Actor)this.q);
/*      */     
/*  372 */     table2.add((Actor)this.j).expand().fill().row();
/*  373 */     table2.add((Actor)table4).expandX().fillX().height(64.0F).padTop(8.0F).row();
/*      */     
/*  375 */     this.p = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), this::e);
/*  376 */     this.p.setSize(64.0F, 64.0F);
/*  377 */     this.p.setPosition(-192.0F, 0.0F);
/*  378 */     this.p.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom-hollow"), 8.0F, 8.0F, 48.0F, 48.0F);
/*  379 */     this.p.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 64.0F, 64.0F);
/*  380 */     this.p.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.14F), new Color(0.0F, 0.0F, 0.0F, 0.28F), new Color(0.0F, 0.0F, 0.0F, 0.21F), new Color(0.0F, 0.0F, 0.0F, 0.0F));
/*  381 */     this.p.setIconLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P600, new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*  382 */     table4.add((Actor)this.p).size(64.0F);
/*      */     
/*  384 */     this.o = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), this::d);
/*  385 */     this.o.setSize(64.0F, 64.0F);
/*  386 */     this.o.setPosition(-128.0F, 0.0F);
/*  387 */     this.o.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top-hollow"), 8.0F, 8.0F, 48.0F, 48.0F);
/*  388 */     this.o.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 64.0F, 64.0F);
/*  389 */     this.o.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.14F), new Color(0.0F, 0.0F, 0.0F, 0.28F), new Color(0.0F, 0.0F, 0.0F, 0.21F), new Color(0.0F, 0.0F, 0.0F, 0.0F));
/*  390 */     this.o.setIconLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P600, new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*  391 */     table4.add((Actor)this.o).size(64.0F);
/*      */ 
/*      */ 
/*      */     
/*      */     ComplexButton complexButton2;
/*      */ 
/*      */     
/*  398 */     (complexButton2 = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> { String str = this.i.getText().trim(); str = "log(utils.print(" + str + "))"; a(str, false); })).setSize(64.0F, 64.0F);
/*  399 */     complexButton2.setPosition(-256.0F, 0.0F);
/*  400 */     complexButton2.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-eye"), 8.0F, 8.0F, 48.0F, 48.0F);
/*  401 */     complexButton2.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 64.0F, 64.0F);
/*  402 */     complexButton2.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.14F), new Color(0.0F, 0.0F, 0.0F, 0.28F), new Color(0.0F, 0.0F, 0.0F, 0.21F), new Color(0.0F, 0.0F, 0.0F, 0.0F));
/*  403 */     complexButton2.setIconLabelColors(MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P300, MaterialColor.LIGHT_BLUE.P600, new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*  404 */     table4.add((Actor)complexButton2).size(64.0F);
/*      */ 
/*      */     
/*  407 */     (complexButton2 = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI("https://infinitode.prineside.com/modding/"))).setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-book-closed"), 8.0F, 8.0F, 48.0F, 48.0F);
/*  408 */     complexButton2.setBackground((Drawable)Game.i.assetManager.getDrawable("blank"), 0.0F, 0.0F, 64.0F, 64.0F);
/*  409 */     complexButton2.setBackgroundColors(new Color(0.0F, 0.0F, 0.0F, 0.14F), new Color(0.0F, 0.0F, 0.0F, 0.28F), new Color(0.0F, 0.0F, 0.0F, 0.21F), new Color(0.0F, 0.0F, 0.0F, 0.0F));
/*  410 */     complexButton2.setIconLabelColors(MaterialColor.LIGHT_GREEN.P500, MaterialColor.LIGHT_GREEN.P300, MaterialColor.LIGHT_GREEN.P600, new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*  411 */     table4.add((Actor)complexButton2).size(64.0F);
/*      */     
/*      */     RectButton rectButton;
/*  414 */     (rectButton = new RectButton("Submit", Game.i.assetManager.getLabelStyle(30), this::g)).setBackgroundColors(MaterialColor.LIGHT_GREEN.P800, MaterialColor.LIGHT_GREEN.P900, MaterialColor.LIGHT_GREEN.P700, Color.GRAY);
/*  415 */     table4.add((Actor)rectButton).size(192.0F, 64.0F);
/*      */     
/*  417 */     this.i.clearListeners();
/*  418 */     this.i.addListener((EventListener)new InputListener(this)
/*      */         {
/*      */           
/*      */           public boolean keyDown(InputEvent param1InputEvent, int param1Int)
/*      */           {
/*  423 */             if (param1Int == 19) {
/*      */               
/*  425 */               DeveloperConsole.a(this.a);
/*  426 */               param1InputEvent.cancel();
/*  427 */               param1InputEvent.halt();
/*  428 */               return true;
/*  429 */             }  if (param1Int == 20) {
/*      */               
/*  431 */               DeveloperConsole.b(this.a);
/*  432 */               param1InputEvent.cancel();
/*  433 */               param1InputEvent.halt();
/*  434 */               return true;
/*  435 */             }  if (DeveloperConsole.c(this.a).getSelection().length() == 0 && DeveloperConsole.c(this.a).getCursorPosition() == DeveloperConsole.c(this.a).getText().length() && (param1Int == 61 || param1Int == 22)) {
/*  436 */               if (DeveloperConsole.d(this.a)) {
/*  437 */                 param1InputEvent.cancel();
/*  438 */                 param1InputEvent.halt();
/*  439 */                 return true;
/*      */               } 
/*  441 */             } else if (param1Int == 66 || param1Int == 160) {
/*  442 */               DeveloperConsole.e(this.a);
/*  443 */               param1InputEvent.cancel();
/*  444 */               param1InputEvent.halt();
/*  445 */               return true;
/*      */             } 
/*      */             
/*  448 */             return super.keyDown(param1InputEvent, param1Int);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean keyTyped(InputEvent param1InputEvent, char param1Char) {
/*  454 */             if (param1Char == '\t' || param1Char == '\r' || param1Char == '\n') {
/*  455 */               param1InputEvent.halt();
/*  456 */               param1InputEvent.cancel();
/*  457 */               return true;
/*      */             } 
/*  459 */             DeveloperConsole.a(this.a, 0);
/*  460 */             DeveloperConsole.f(this.a).set(0, DeveloperConsole.c(this.a).getText());
/*      */             
/*  462 */             return false;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean keyUp(InputEvent param1InputEvent, int param1Int) {
/*  468 */             return false;
/*      */           }
/*      */         });
/*  471 */     this.i.addListener((EventListener)new ChangeListener(this)
/*      */         {
/*      */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  474 */             DeveloperConsole.g(this.a);
/*      */           }
/*      */         });
/*  477 */     this.i.addListener((EventListener)this.i.getDefaultInputListener());
/*  478 */     Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)this.i, Cursor.SystemCursor.Ibeam);
/*      */     
/*  480 */     Game.EVENTS.getListeners(ScreenResize.class).add(this.u);
/*      */ 
/*      */ 
/*      */     
/*      */     ComplexButton complexButton1;
/*      */ 
/*      */ 
/*      */     
/*  488 */     (complexButton1 = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> setVisible(!this.f))).setBackground((Drawable)Game.i.assetManager.getQuad("ui.console.buttonBg"), 0.0F, 0.0F, 80.0F, 52.0F);
/*  489 */     complexButton1.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-terminal"), 24.0F, 10.0F, 32.0F, 32.0F);
/*  490 */     complexButton1.setBackgroundColors(MaterialColor.BLUE_GREY.P700, MaterialColor.BLUE_GREY.P800, MaterialColor.BLUE_GREY.P600, Color.BLACK);
/*  491 */     this.c.getTable().add((Actor)complexButton1).expand().top().left().size(80.0F, 52.0F).padTop(175.0F);
/*      */     
/*      */     try {
/*      */       FileHandle fileHandle;
/*  495 */       if ((fileHandle = Gdx.files.local("cache/dev-console-history.ubjson")).exists()) {
/*      */         JsonValue jsonValue;
/*  497 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new UBJsonReader()).parse(fileHandle)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*  498 */           this.w.add(jsonValue1.asString()); }
/*      */ 
/*      */       
/*      */       } 
/*  502 */     } catch (Exception exception) {}
/*      */ 
/*      */ 
/*      */     
/*  506 */     this.f = false;
/*  507 */     this.e.getTable().setVisible(false);
/*  508 */     this.d.getTable().setVisible(false);
/*      */     
/*  510 */     h();
/*  511 */     f();
/*      */   }
/*      */   
/*      */   private boolean a() {
/*      */     String str;
/*  516 */     if ((str = b()) != null) {
/*  517 */       this.i.setText(str);
/*  518 */       this.i.setCursorPosition(str.length());
/*  519 */       c();
/*  520 */       return true;
/*      */     } 
/*  522 */     return false;
/*      */   }
/*      */   
/*      */   @Null
/*      */   private String b() {
/*  527 */     if (this.s == null || this.s.variants.size == 0) {
/*  528 */       return null;
/*      */     }
/*  530 */     if (this.s.variants.size == 1)
/*      */     {
/*  532 */       return this.i.getText().substring(0, this.s.start) + (String)((ObjectPair)this.s.variants.first()).first;
/*      */     }
/*      */     
/*  535 */     int i = 100;
/*  536 */     for (byte b1 = 0; b1 < this.s.variants.size; b1++) {
/*      */       String str1;
/*  538 */       if ((str1 = (String)((ObjectPair)this.s.variants.get(b1)).first).length() < i) {
/*  539 */         i = str1.length();
/*      */       }
/*      */     } 
/*  542 */     String str = null; byte b2;
/*  543 */     label30: for (b2 = 1; b2 < i; b2++) {
/*  544 */       String str1 = ((String)((ObjectPair)this.s.variants.get(0)).first).substring(0, b2);
/*  545 */       for (byte b = 1; b < this.s.variants.size; ) {
/*      */         String str2;
/*  547 */         if ((str2 = (String)((ObjectPair)this.s.variants.get(b)).first).substring(0, b2).equals(str1)) {
/*      */           b++; continue;
/*      */         }  break label30;
/*      */       } 
/*  551 */       str = str1;
/*      */     } 
/*  553 */     if (str != null) {
/*  554 */       return this.i.getText().substring(0, this.s.start) + str;
/*      */     }
/*  556 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void c() {
/*      */     ScriptEnvironment scriptEnvironment;
/*  563 */     if (Game.i.screenManager.getCurrentScreen() instanceof GameScreen) {
/*      */       GameScreen gameScreen;
/*  565 */       scriptEnvironment = (gameScreen = (GameScreen)Game.i.screenManager.getCurrentScreen()).S.script.scriptEnvironment;
/*      */     } else {
/*  567 */       scriptEnvironment = Game.i.scriptManager.global;
/*      */     } 
/*      */     
/*      */     String str1;
/*  571 */     if ((str1 = this.i.getText()).length() == 0) {
/*  572 */       this.r.setVisible(false);
/*  573 */       this.q.setVisible(false);
/*  574 */       this.s = null;
/*      */       
/*      */       return;
/*      */     } 
/*  578 */     ScriptEnvironment.Suggestion suggestion = scriptEnvironment.getAutocompletion(str1, this.i.getCursorPosition() - 1);
/*  579 */     this.s = suggestion;
/*      */ 
/*      */     
/*  582 */     if (suggestion == null || suggestion.variants.size == 0) {
/*  583 */       this.r.setVisible(false);
/*  584 */       this.q.setVisible(false);
/*  585 */       this.s = null; return;
/*      */     } 
/*  587 */     this.q.setVisible(true);
/*  588 */     this.q.clear();
/*      */     
/*  590 */     Table table = new Table();
/*      */     ScrollPane scrollPane;
/*  592 */     (scrollPane = new ScrollPane((Actor)table, Game.i.assetManager.getScrollPaneStyle(0.0F))).setOverscroll(false, false);
/*  593 */     scrollPane.setScrollingDisabled(true, false);
/*  594 */     this.q.add((Actor)scrollPane).pad(5.0F).grow();
/*      */     
/*  596 */     for (Array.ArrayIterator<ObjectPair> arrayIterator = suggestion.variants.iterator(); arrayIterator.hasNext(); ) { ObjectPair objectPair = arrayIterator.next();
/*  597 */       Label label = new Label((CharSequence)objectPair.first, Game.i.assetManager.getDebugLabelStyle());
/*  598 */       table.add((Actor)label).growX();
/*      */ 
/*      */       
/*  601 */       (label = new Label(":" + (String)objectPair.second, Game.i.assetManager.getDebugLabelStyle())).setColor(MaterialColor.LIGHT_BLUE.P500);
/*  602 */       table.add((Actor)label).fillX().padLeft(8.0F).row(); }
/*      */ 
/*      */     
/*  605 */     table.row();
/*  606 */     table.add().width(1.0F).growY();
/*      */     
/*  608 */     table.layout();
/*  609 */     table.pack();
/*  610 */     table.layout();
/*  611 */     table.pack();
/*      */     
/*  613 */     StringBuilder stringBuilder = new StringBuilder();
/*  614 */     for (byte b = 0; b < suggestion.start; b++) {
/*  615 */       stringBuilder.append("x");
/*      */     }
/*  617 */     float f = StringFormatter.calculateWidth((CharSequence)stringBuilder, Game.i.assetManager.getDebugFont(false));
/*  618 */     this.q.setX(f + 14.0F - 5.0F);
/*  619 */     this.q.setY(this.i.getHeight() + 5.0F);
/*  620 */     this.q.setWidth(Math.max(300.0F, table.getWidth() + 10.0F));
/*  621 */     this.q.setHeight(Math.max(10.0F, table.getHeight() + 10.0F));
/*      */     
/*      */     String str2;
/*  624 */     if ((str2 = b()) != null) {
/*  625 */       stringBuilder.setLength(0);
/*  626 */       for (byte b1 = 0; b1 < str2.length(); b1++) {
/*  627 */         if (b1 < this.i.getCursorPosition()) {
/*  628 */           stringBuilder.append(' ');
/*      */         } else {
/*  630 */           stringBuilder.append(str2.charAt(b1));
/*      */         } 
/*      */       } 
/*      */       
/*  634 */       this.r.setVisible(true);
/*  635 */       this.r.setText(stringBuilder.toString());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void d() {
/*  641 */     if (this.w.size == 0)
/*      */       return; 
/*  643 */     this.v++;
/*  644 */     if (this.v >= this.w.size) {
/*  645 */       this.v = this.w.size - 1;
/*      */     }
/*  647 */     this.i.setText((String)this.w.get(this.v));
/*  648 */     this.i.setCursorPosition(9999);
/*  649 */     c();
/*  650 */     f();
/*      */   }
/*      */   
/*      */   private void e() {
/*  654 */     if (this.w.size == 0)
/*      */       return; 
/*  656 */     this.v--;
/*  657 */     if (this.v < 0) {
/*  658 */       this.v = 0;
/*      */     }
/*  660 */     this.i.setText((String)this.w.get(this.v));
/*  661 */     this.i.setCursorPosition(9999);
/*  662 */     c();
/*  663 */     f();
/*      */   }
/*      */   
/*      */   private void f() {
/*  667 */     if (this.w.size != 0) {
/*  668 */       this.o.setEnabled((this.v != this.w.size - 1));
/*  669 */       this.p.setEnabled((this.v > 0)); return;
/*      */     } 
/*  671 */     this.o.setEnabled(false);
/*  672 */     this.p.setEnabled(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(String paramString, boolean paramBoolean) {
/*  677 */     if (paramString.length() == 0) {
/*      */       return;
/*      */     }
/*      */     
/*  681 */     a.i(">>> " + paramString, new Object[0]);
/*      */     
/*  683 */     if (Game.i.screenManager.getCurrentScreen() instanceof GameScreen) {
/*      */       GameScreen gameScreen;
/*      */       
/*  686 */       (gameScreen = (GameScreen)Game.i.screenManager.getCurrentScreen()).S.script.runScriptAction(paramString);
/*      */     } else {
/*      */       ScriptEnvironment.LuaExecutionResult luaExecutionResult;
/*  689 */       if ((luaExecutionResult = Game.i.scriptManager.global.executeLua(paramString, "console")).caughtError == null && 
/*  690 */         luaExecutionResult.returnValue != null && !luaExecutionResult.returnValue.isnil()) {
/*  691 */         a.i("<<< " + luaExecutionResult.returnValue, new Object[0]);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  696 */     if (paramBoolean) {
/*  697 */       if (this.w.size >= 2 && ((String)this.w.get(1)).equals(paramString)) {
/*      */         
/*  699 */         this.w.set(0, "");
/*      */       } else {
/*  701 */         this.w.set(0, paramString);
/*  702 */         this.w.insert(0, "");
/*      */       } 
/*      */       
/*  705 */       if (this.w.size > 20) {
/*  706 */         this.w.pop();
/*      */       }
/*  708 */       this.v = 0;
/*  709 */       n();
/*  710 */       f();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void g() {
/*  715 */     String str = this.i.getText().trim();
/*  716 */     a(str, true);
/*  717 */     this.i.setText("");
/*  718 */     c();
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
/*      */   private void h() {
/*  731 */     k();
/*      */   }
/*      */   
/*      */   private static int j() {
/*      */     int i;
/*  736 */     if ((i = MathUtils.round((float)Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_CONSOLE_LINE_COUNT))) <= 1) {
/*  737 */       i = 100;
/*      */     }
/*      */     
/*  740 */     return i;
/*      */   }
/*      */   
/*      */   private void k() {
/*  744 */     this.j.fling(0.3F, 0.0F, -1000000.0F);
/*      */   }
/*      */   
/*      */   private LogLine a(@Null Date paramDate, @Null String paramString1, byte paramByte, String paramString2, String paramString3) {
/*      */     LogLine logLine;
/*  749 */     if (this.k.size >= j()) {
/*  750 */       logLine = (LogLine)this.k.removeIndex(0);
/*  751 */       this.k.add(logLine);
/*      */       
/*  753 */       this.g.removeActor((Actor)logLine);
/*  754 */       this.g.invalidate();
/*      */     } else {
/*      */       
/*  757 */       logLine = new LogLine(this);
/*  758 */       this.k.add(logLine);
/*      */     } 
/*      */     
/*  761 */     if (paramDate != null) {
/*  762 */       x.setTime(paramDate);
/*      */       
/*  764 */       int i = x.get(11);
/*  765 */       int j = x.get(12);
/*  766 */       int k = x.get(13);
/*      */       
/*  768 */       y.setLength(0);
/*  769 */       if (i < 10) y.append('0'); 
/*  770 */       y.append(i).append(':');
/*  771 */       if (j < 10) y.append('0'); 
/*  772 */       y.append(j).append(':');
/*  773 */       if (k < 10) y.append('0'); 
/*  774 */       y.append(k);
/*  775 */       logLine.n.setText((CharSequence)y);
/*  776 */       logLine.n.setVisible(true);
/*      */     } else {
/*  778 */       logLine.n.setVisible(false);
/*      */     } 
/*      */     
/*  781 */     switch (paramByte) {
/*      */       case 0:
/*  783 */         logLine.p.setColor(MaterialColor.BLUE_GREY.P900);
/*  784 */         logLine.q.setText("D");
/*  785 */         logLine.l.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */         break;
/*      */       
/*      */       case 1:
/*  789 */         logLine.p.setColor(MaterialColor.LIGHT_BLUE.P800);
/*  790 */         logLine.q.setText("I");
/*  791 */         logLine.l.setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*      */         break;
/*      */       
/*      */       case 2:
/*  795 */         logLine.p.setColor(MaterialColor.YELLOW.P900);
/*  796 */         logLine.q.setText("W");
/*  797 */         logLine.l.setColor(MaterialColor.YELLOW.P500);
/*      */         break;
/*      */       
/*      */       case 3:
/*  801 */         logLine.p.setColor(MaterialColor.RED.P800);
/*  802 */         logLine.q.setText("E");
/*  803 */         logLine.l.setColor(MaterialColor.RED.P400);
/*      */         break;
/*      */ 
/*      */       
/*      */       default:
/*  808 */         if (paramString2.startsWith(">>> ")) {
/*  809 */           paramString2 = paramString2.substring(4);
/*  810 */           logLine.p.setColor(MaterialColor.GREEN.P800);
/*  811 */           logLine.q.setText(">");
/*  812 */           logLine.l.setColor(MaterialColor.GREEN.P300); break;
/*  813 */         }  if (paramString2.startsWith("<<< ")) {
/*  814 */           paramString2 = paramString2.substring(4);
/*  815 */           logLine.p.setColor(MaterialColor.PURPLE.P800);
/*  816 */           logLine.q.setText("<");
/*  817 */           logLine.l.setColor(MaterialColor.PURPLE.P300);
/*      */         } 
/*      */         break;
/*      */     } 
/*      */     
/*  822 */     if (paramString1 != null) {
/*  823 */       String str = paramString1;
/*  824 */       if (paramString1.length() > 20) {
/*  825 */         paramString1 = paramString1.substring(0, 20) + "...";
/*      */       }
/*  827 */       logLine.k.setColor(a(str));
/*  828 */       logLine.k.setText(paramString1);
/*  829 */       logLine.k.setVisible(true);
/*  830 */       logLine.o.setVisible(true);
/*      */     } else {
/*  832 */       logLine.k.setVisible(false);
/*  833 */       logLine.o.setVisible(false);
/*      */     } 
/*      */     
/*  836 */     if (!paramString2.contains("\\[#")) {
/*  837 */       paramString2 = paramString2.replaceAll("\\[]", "[[]");
/*      */     }
/*      */     
/*  840 */     if (paramString2.contains("\n")) {
/*  841 */       String[] arrayOfString = paramString2.split("\n");
/*  842 */       logLine.l.setText(arrayOfString[0]);
/*      */     } else {
/*  844 */       logLine.l.setText(paramString2);
/*      */     } 
/*      */     
/*  847 */     logLine.n.clearListeners();
/*  848 */     if (paramString3 != null) {
/*  849 */       logLine.n.addListener((EventListener)new ClickListener(this, logLine, paramString3)
/*      */           {
/*      */             public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/*  852 */               this.a.n.setColor(1.0F, 1.0F, 1.0F, 1.0F);
/*  853 */               super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*      */             }
/*      */ 
/*      */             
/*      */             public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/*  858 */               this.a.n.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  859 */               super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*      */             }
/*      */ 
/*      */             
/*      */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  864 */               String str = this.b;
/*  865 */               if (this.b.startsWith(">>> ")) {
/*      */                 
/*  867 */                 str = str.substring(4);
/*  868 */               } else if (this.b.startsWith("<<< ")) {
/*      */                 
/*  870 */                 str = str.substring(4);
/*      */               } 
/*  872 */               Gdx.app.getClipboard().setContents(str);
/*  873 */               Notifications.i().add("Copied to the clipboard!", null, null, null);
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/*  879 */     this.g.addActor((Actor)logLine);
/*      */     
/*  881 */     return logLine;
/*      */   }
/*      */   
/*      */   private void a(Logger.LogEntry paramLogEntry) {
/*  885 */     boolean bool1 = (this.j.getScrollPercentY() > 0.99F) ? true : false;
/*      */     
/*  887 */     String[] arrayOfString = paramLogEntry.message.split("\n");
/*  888 */     byte b = paramLogEntry.logLevel;
/*  889 */     if (paramLogEntry.message.startsWith(">>> ") || paramLogEntry.message.startsWith("<<< ")) {
/*  890 */       b = -1;
/*      */     }
/*  892 */     boolean bool2 = true; int i; byte b1;
/*  893 */     for (i = (arrayOfString = arrayOfString).length, b1 = 0; b1 < i; ) { String str = arrayOfString[b1];
/*  894 */       if (bool2) {
/*  895 */         a(new Date(paramLogEntry.timestampMs), paramLogEntry.tag, b, str, paramLogEntry.message);
/*      */       } else {
/*  897 */         a(null, null, b, str, paramLogEntry.message);
/*      */       } 
/*  899 */       bool2 = false;
/*      */       b1++; }
/*      */     
/*      */     try {
/*  903 */       this.j.layout();
/*  904 */       if (bool1) k();  return;
/*  905 */     } catch (Exception exception) {
/*  906 */       a.e("failed to layout log scroll pane", new Object[0]);
/*  907 */       this.g.clearChildren();
/*  908 */       this.k.clear();
/*      */       return;
/*      */     } 
/*      */   }
/*      */   public void toggleVisible() {
/*  913 */     setVisible(!this.f);
/*      */   }
/*      */   
/*      */   public void setCustomSettingsVisible(boolean paramBoolean) {
/*  917 */     this.h.setVisible(paramBoolean);
/*  918 */     if (paramBoolean) {
/*      */       SettingsManager.CustomValueType[] arrayOfCustomValueType; int i; byte b;
/*  920 */       for (i = (arrayOfCustomValueType = SettingsManager.CustomValueType.values).length, b = 0; b < i; ) { SettingsManager.CustomValueType customValueType = arrayOfCustomValueType[b];
/*  921 */         CustomSettingsUI customSettingsUI = this.t[customValueType.ordinal()];
/*  922 */         double d = Game.i.settingsManager.getCustomValue(customValueType);
/*  923 */         customSettingsUI.a.setText(d);
/*  924 */         customSettingsUI.b.setEnabled((d != 0.0D));
/*      */         b++; }
/*      */     
/*      */     } 
/*      */   }
/*      */   
/*      */   private void l() {
/*  931 */     Logger.forceLogFileFlushAndRun(() -> {
/*      */           Array array1;
/*      */           
/*      */           (array1 = FileUtils.tail(null = Game.i.actionResolver.getLogFile().file(), j())).reverse();
/*      */           
/*      */           long l = 0L;
/*      */           
/*      */           String str = null;
/*      */           
/*      */           byte b = 1;
/*      */           
/*      */           Array array2 = new Array();
/*      */           
/*      */           StringBuilder stringBuilder = new StringBuilder();
/*      */           Matcher matcher = LogWriter.LOG_FILE_ENTRY_REGEX.matcher("");
/*      */           Array.ArrayIterator<String> arrayIterator = array1.iterator();
/*      */           while (arrayIterator.hasNext()) {
/*      */             String str1 = arrayIterator.next();
/*      */             try {
/*      */               matcher.reset(str1);
/*      */               if (matcher.find()) {
/*      */                 if (str != null) {
/*      */                   array2.add(new Logger.LogEntry(b, l, str, stringBuilder.toString()));
/*      */                   stringBuilder.setLength(0);
/*      */                 } 
/*      */                 String str2 = matcher.group(1);
/*      */                 l = LogWriter.LOG_DATE_FORMAT.parse(str2).getTime();
/*      */                 b = LogLevel.shortNameToLevel(matcher.group(2).charAt(0));
/*      */                 str = matcher.group(3);
/*      */                 stringBuilder.append(str1.substring(matcher.group().length()));
/*      */                 continue;
/*      */               } 
/*      */               stringBuilder.append('\n').append(str1);
/*  964 */             } catch (Exception exception) {
/*      */               System.out.println("Failed to parse log line: " + str1);
/*      */               
/*      */               exception.printStackTrace(System.out);
/*      */             } 
/*      */           } 
/*      */           
/*      */           if (str != null) {
/*      */             array2.add(new Logger.LogEntry(b, l, str, stringBuilder.toString()));
/*      */             stringBuilder.setLength(0);
/*      */           } 
/*      */           synchronized (this) {
/*      */             if (this.z != null) {
/*      */               try {
/*      */                 this.z.close();
/*  979 */               } catch (IOException iOException) {}
/*      */             }
/*      */             
/*      */             try {
/*      */               BufferedReader bufferedReader;
/*      */               (bufferedReader = new BufferedReader(new FileReader(null))).skip(Long.MAX_VALUE);
/*      */               this.z = bufferedReader;
/*  986 */             } catch (Exception exception) {}
/*      */           } 
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
/*      */           Threads.i().runOnMainThread(());
/*      */         });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1010 */       this.j.getStage().setScrollFocus((Actor)this.j);
/* 1011 */       this.i.getStage().setKeyboardFocus((Actor)this.i);
/* 1012 */     } catch (Exception exception) {}
/*      */ 
/*      */ 
/*      */     
/* 1016 */     k();
/* 1017 */     c();
/*      */   }
/*      */   
/*      */   private void m() {
/* 1021 */     this.g.clear();
/* 1022 */     this.k.clear();
/*      */ 
/*      */     
/*      */     try {
/* 1026 */       this.i.getStage().unfocusAll();
/* 1027 */     } catch (Exception exception) {}
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1032 */       this.z.close();
/* 1033 */       this.z = null;
/* 1034 */     } catch (Exception exception) {}
/*      */     
/* 1036 */     this.i.setText("");
/* 1037 */     c();
/* 1038 */     Game.i.uiManager.stage.setKeyboardFocus(null);
/*      */     
/* 1040 */     setCustomSettingsVisible(false);
/*      */   }
/*      */   
/*      */   public boolean isCustomSettingsVisible() {
/* 1044 */     return this.h.isVisible();
/*      */   }
/*      */   
/*      */   public void setVisible(boolean paramBoolean) {
/* 1048 */     if (this.f != paramBoolean) {
/* 1049 */       this.f = paramBoolean;
/*      */       
/* 1051 */       this.d.getTable().setVisible(paramBoolean);
/* 1052 */       this.e.getTable().setVisible(paramBoolean);
/* 1053 */       if (paramBoolean) {
/* 1054 */         l(); return;
/*      */       } 
/* 1056 */       m();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static Color a(String paramString) {
/* 1062 */     long l = 0L; byte b; int i;
/* 1063 */     for (b = 0, i = paramString.length(); b < i; b++) {
/* 1064 */       l += paramString.charAt(b);
/*      */     }
/*      */     
/* 1067 */     return b[(int)(l % b.length)];
/*      */   }
/*      */ 
/*      */   
/*      */   private void n() {
/* 1072 */     if (this.w.size > 1) {
/*      */       try {
/* 1074 */         OutputStream outputStream = Gdx.files.local("cache/dev-console-history.ubjson").write(false, 512);
/*      */         UBJsonWriter uBJsonWriter;
/* 1076 */         (uBJsonWriter = new UBJsonWriter(outputStream)).array();
/* 1077 */         for (byte b = 1; b < this.w.size; b++) {
/* 1078 */           uBJsonWriter.value((String)this.w.get(b));
/*      */         }
/* 1080 */         uBJsonWriter.pop();
/* 1081 */         outputStream.close(); return;
/* 1082 */       } catch (IOException iOException2) {
/* 1083 */         IOException iOException1; (iOException1 = null).printStackTrace();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1090 */     a.i("disposing", new Object[0]);
/* 1091 */     Game.EVENTS.getListeners(ScreenResize.class).remove(this.u);
/* 1092 */     Game.i.uiManager.removeLayer(this.e);
/* 1093 */     Game.i.uiManager.removeLayer(this.d);
/* 1094 */     Game.i.uiManager.removeLayer(this.c);
/*      */     
/* 1096 */     n();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private class LogLine
/*      */     extends Table
/*      */   {
/*      */     Label k;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Label l;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Label n;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Stack o;
/*      */ 
/*      */ 
/*      */     
/*      */     Image p;
/*      */ 
/*      */ 
/*      */     
/*      */     Label q;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     LogLine(DeveloperConsole this$0) {
/* 1135 */       this.n = new Label("", DeveloperConsole.h(this$0));
/* 1136 */       this.n.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1137 */       this.n.setTouchable(Touchable.enabled);
/* 1138 */       this.n.setAlignment(10);
/*      */       
/* 1140 */       add((Actor)this.n).top().left().padLeft(0.0F).width(120.0F).padTop(2.0F).padBottom(2.0F);
/*      */       
/* 1142 */       this.k = new Label("", DeveloperConsole.i(this$0));
/* 1143 */       this.k.setTouchable(Touchable.disabled);
/* 1144 */       this.k.setAlignment(10);
/* 1145 */       add((Actor)this.k).top().left().width(220.0F).padTop(2.0F).padBottom(2.0F);
/*      */       
/* 1147 */       this.p = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 1148 */       this.p.setSize(24.0F, 24.0F);
/*      */       
/* 1150 */       this.q = new Label("", Game.i.assetManager.getDebugLabelStyle());
/* 1151 */       this.q.setSize(24.0F, 24.0F);
/* 1152 */       this.q.setAlignment(1);
/*      */       
/* 1154 */       this.o = new Stack();
/* 1155 */       this.o.addActor((Actor)this.p);
/* 1156 */       this.o.addActor((Actor)this.q);
/*      */       
/* 1158 */       add((Actor)this.o).top().left().size(24.0F).padTop(2.0F).padBottom(2.0F).padRight(8.0F);
/*      */       
/* 1160 */       this.l = new Label("", DeveloperConsole.j(this$0));
/* 1161 */       this.l.setTouchable(Touchable.disabled);
/* 1162 */       this.l.setAlignment(10);
/* 1163 */       this.l.setWrap(true);
/* 1164 */       add((Actor)this.l).expandX().fill().padTop(2.0F).padBottom(2.0F);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\DeveloperConsole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */