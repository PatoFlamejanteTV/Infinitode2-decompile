/*     */ package com.prineside.tdi2.screens;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Input;
/*     */ import com.badlogic.gdx.InputAdapter;
/*     */ import com.badlogic.gdx.InputMultiplexer;
/*     */ import com.badlogic.gdx.InputProcessor;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.FancyButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.shared.BackButton;
/*     */ import com.prineside.tdi2.ui.shared.ForwardButton;
/*     */ import com.prineside.tdi2.ui.shared.ScreenTitle;
/*     */ import com.prineside.tdi2.utils.InputVoid;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public class HotkeyScreen extends Screen {
/*  32 */   private static final int[] a = new int[] { 129, 130, 59, 60, 57, 58 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  41 */     Arrays.sort(new int[6]);
/*     */   }
/*  43 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "HotkeyScreen main");
/*  44 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "HotkeyScreen gradient");
/*  45 */   private final UiManager.UiLayer d = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 102, "HotkeyScreen hotkey tint");
/*  46 */   private final UiManager.UiLayer e = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 103, "HotkeyScreen hotkey");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Table f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Table g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Label h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   private IntArray i = new IntArray();
/*     */   
/*  86 */   private SettingsManager.HotkeyAction j = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HotkeyScreen() {
/*  92 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*     */     
/*  94 */     Game.i.uiManager.hideAllComponents();
/*  95 */     Game.i.uiManager.setAsInputHandler();
/*     */     
/*  97 */     ScreenTitle.i()
/*  98 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-wrench"))
/*  99 */       .setText(Game.i.localeManager.i18n.get("hotkey_editor_title"))
/* 100 */       .setVisible(true);
/*     */     
/* 102 */     BackButton.i()
/* 103 */       .setVisible(true)
/* 104 */       .setText(null)
/* 105 */       .setClickHandler(this::a);
/*     */     
/* 107 */     this.f = new Table();
/*     */     ScrollPane scrollPane;
/* 109 */     UiUtils.enableMouseMoveScrollFocus(scrollPane = new ScrollPane((Actor)this.f, Game.i.assetManager.getScrollPaneStyle(16.0F)));
/* 110 */     scrollPane.setScrollingDisabled(true, false);
/* 111 */     this.b.getTable().add((Actor)scrollPane).expand().fill();
/*     */     
/*     */     Image image;
/* 114 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(Config.BACKGROUND_COLOR);
/* 115 */     this.c.getTable().setTouchable(Touchable.disabled);
/* 116 */     this.c.getTable().add((Actor)image).expandX().fillX().height(128.0F).row();
/* 117 */     this.c.getTable().add().expand().fill().row();
/*     */     
/* 119 */     this.f.add().height(128.0F).fillX().expandX().row();
/*     */     
/* 121 */     this.g = new Table();
/* 122 */     this.f.add((Actor)this.g).expandX().fillX();
/*     */ 
/*     */     
/* 125 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/* 126 */     (image.getColor()).a = 0.78F;
/* 127 */     this.d.getTable().add((Actor)image).expand().fill();
/* 128 */     this.d.getTable().setTouchable(Touchable.enabled);
/* 129 */     this.d.getTable().addListener((EventListener)new InputVoid());
/* 130 */     this.d.getTable().setVisible(false);
/*     */     
/* 132 */     this.h = new Label("ABC", Game.i.assetManager.getLabelStyle(36));
/* 133 */     this.e.getTable().add((Actor)this.h);
/* 134 */     this.e.getTable().setVisible(false);
/* 135 */     b();
/*     */   }
/*     */   
/*     */   private void a(IntArray paramIntArray) {
/* 139 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*     */     byte b;
/* 142 */     for (b = 0; b < paramIntArray.size; b++) {
/* 143 */       if (Arrays.binarySearch(a, paramIntArray.items[b]) >= 0) {
/* 144 */         if (stringBuilder.length != 0) {
/* 145 */           stringBuilder.append(" + ");
/*     */         }
/*     */         
/*     */         String str;
/* 149 */         if ((str = Input.Keys.toString(paramIntArray.items[b])).startsWith("L-")) {
/* 150 */           str = str.substring(2);
/*     */         }
/* 152 */         stringBuilder.append(str);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 157 */     for (b = 0; b < paramIntArray.size; b++) {
/* 158 */       if (Arrays.binarySearch(a, paramIntArray.items[b]) < 0) {
/* 159 */         if (stringBuilder.length != 0) {
/* 160 */           stringBuilder.append(" + ");
/*     */         }
/* 162 */         stringBuilder.append(Input.Keys.toString(paramIntArray.items[b]));
/*     */       } 
/*     */     } 
/*     */     
/* 166 */     this.h.setText((CharSequence)stringBuilder);
/*     */   }
/*     */   
/*     */   private void a() {
/* 170 */     if (this.j == null) {
/* 171 */       Game.i.screenManager.goToSettingsScreen(); return;
/*     */     } 
/* 173 */     a(false);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(SettingsManager.HotkeyAction paramHotkeyAction) {
/* 178 */     this.i.clear();
/* 179 */     a(new IntArray(Game.i.settingsManager.getHotKey(paramHotkeyAction)));
/*     */     
/* 181 */     this.d.getTable().setVisible(true);
/* 182 */     this.e.getTable().setVisible(true);
/* 183 */     this.j = paramHotkeyAction;
/*     */     
/*     */     InputMultiplexer inputMultiplexer;
/* 186 */     (inputMultiplexer = new InputMultiplexer()).addProcessor((InputProcessor)new InputAdapter(this) {
/* 187 */           private IntArray a = new IntArray();
/*     */ 
/*     */           
/*     */           public boolean keyDown(int param1Int) {
/* 191 */             if (param1Int == 4 || param1Int == 111) {
/* 192 */               return false;
/*     */             }
/*     */             
/* 195 */             if (!this.a.contains(param1Int)) {
/* 196 */               this.a.add(param1Int);
/*     */             }
/* 198 */             HotkeyScreen.a(this.b).clear();
/* 199 */             HotkeyScreen.a(this.b).addAll(this.a);
/*     */             
/* 201 */             HotkeyScreen.a(this.b, this.a);
/*     */             
/* 203 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean keyUp(int param1Int) {
/* 208 */             this.a.removeValue(param1Int);
/*     */             
/* 210 */             HotkeyScreen.a(this.b, HotkeyScreen.a(this.b));
/* 211 */             return false;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     inputMultiplexer.addProcessor((InputProcessor)Game.i.uiManager.stage);
/* 219 */     Gdx.input.setInputProcessor((InputProcessor)inputMultiplexer);
/*     */     
/* 221 */     ForwardButton.i()
/* 222 */       .setVisible(true)
/* 223 */       .setText(null)
/* 224 */       .setClickHandler(() -> a(true));
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean) {
/* 228 */     if (paramBoolean && this.i.size != 0) {
/* 229 */       Game.i.settingsManager.setHotKey(this.j, this.i.toArray());
/*     */     }
/*     */     
/* 232 */     this.d.getTable().setVisible(false);
/* 233 */     this.e.getTable().setVisible(false);
/* 234 */     this.j = null;
/* 235 */     Game.i.uiManager.setAsInputHandler();
/*     */ 
/*     */     
/* 238 */     ForwardButton.i()
/* 239 */       .setVisible(false);
/*     */     
/* 241 */     b();
/*     */   }
/*     */   
/*     */   private void b() {
/* 245 */     this.g.clear();
/*     */     
/* 247 */     byte b1 = 0; SettingsManager.HotkeyAction[] arrayOfHotkeyAction; int i; byte b2;
/* 248 */     for (i = (arrayOfHotkeyAction = SettingsManager.HotkeyAction.values).length, b2 = 0; b2 < i; ) { SettingsManager.HotkeyAction hotkeyAction = arrayOfHotkeyAction[b2];
/*     */       String str;
/* 250 */       if ((str = Game.i.settingsManager.getHotkeyGroupTitle(hotkeyAction)) != null) {
/*     */         Label label1;
/* 252 */         (label1 = new Label(str, Game.i.assetManager.getLabelStyle(30))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 253 */         this.g.add((Actor)label1).height(64.0F).padTop(16.0F).row();
/*     */       } 
/*     */       
/*     */       Group group;
/* 257 */       (group = new Group()).setTransform(false);
/* 258 */       group.setSize(800.0F, 48.0F);
/* 259 */       this.g.add((Actor)group).padBottom(4.0F).row();
/*     */       
/*     */       Image image;
/* 262 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(800.0F, 48.0F);
/* 263 */       image.setColor(0.0F, 0.0F, 0.0F, 0.21F);
/* 264 */       group.addActor((Actor)image);
/*     */       
/*     */       Label label;
/* 267 */       (label = new Label(Game.i.settingsManager.getHotKeyName(hotkeyAction), Game.i.assetManager.getLabelStyle(24))).setPosition(10.0F, 0.0F);
/* 268 */       label.setSize(200.0F, 48.0F);
/* 269 */       group.addActor((Actor)label);
/*     */       
/* 271 */       StringBuilder stringBuilder = new StringBuilder();
/* 272 */       int[] arrayOfInt = Game.i.settingsManager.getHotKey(hotkeyAction);
/* 273 */       for (byte b = 0; b < arrayOfInt.length; b++) {
/* 274 */         if (b != 0) {
/* 275 */           stringBuilder.append(" + ");
/*     */         }
/*     */         String str1;
/* 278 */         if ((str1 = Input.Keys.toString(arrayOfInt[b])).startsWith("L-")) {
/* 279 */           str1 = str1.substring(2);
/*     */         }
/* 281 */         stringBuilder.append(str1);
/*     */       } 
/*     */       
/*     */       FancyButton fancyButton1;
/*     */       
/* 286 */       (fancyButton1 = (new FancyButton((b1 % 2 == 0) ? "regularButton.a" : "regularButton.b", () -> a(paramHotkeyAction))).withLabel(24, (CharSequence)stringBuilder)).setSize(192.0F, 48.0F);
/* 287 */       fancyButton1.setPosition(412.0F, 0.0F);
/* 288 */       group.addActor((Actor)fancyButton1);
/*     */ 
/*     */       
/*     */       FancyButton fancyButton2;
/*     */ 
/*     */       
/* 294 */       (fancyButton2 = (new FancyButton((b1 % 2 == 0) ? "regularButton.b" : "regularButton.a", () -> { Game.i.settingsManager.setHotKey(paramHotkeyAction, Game.i.settingsManager.getDefaultHotKey(paramHotkeyAction)); b(); })).withLabel(24, Game.i.localeManager.i18n.get("reset"))).setSize(192.0F, 48.0F);
/* 295 */       fancyButton2.setPosition(608.0F, 0.0F);
/* 296 */       group.addActor((Actor)fancyButton2);
/* 297 */       if (Game.i.settingsManager.isDefaultHotKey(hotkeyAction)) {
/* 298 */         fancyButton2.setEnabled(false);
/*     */       }
/*     */       
/* 301 */       b1++;
/*     */       b2++; }
/*     */     
/* 304 */     this.g.add().height(128.0F).width(1.0F).row();
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(float paramFloat) {
/* 309 */     Color color = Game.i.assetManager.getColor("menu_background");
/* 310 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 311 */     Gdx.gl.glClear(16640);
/*     */     
/* 313 */     if (Game.i.settingsManager.isEscButtonJustPressed())
/*     */     {
/* 315 */       a();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 321 */     Game.i.uiManager.removeLayer(this.b);
/* 322 */     Game.i.uiManager.removeLayer(this.c);
/* 323 */     Game.i.uiManager.removeLayer(this.e);
/* 324 */     Game.i.uiManager.removeLayer(this.d);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\HotkeyScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */