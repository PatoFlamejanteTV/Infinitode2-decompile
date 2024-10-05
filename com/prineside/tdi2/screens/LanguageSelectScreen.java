/*     */ package com.prineside.tdi2.screens;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.managers.LocaleManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class LanguageSelectScreen extends Screen {
/*  29 */   private static final TLog a = TLog.forClass(LanguageSelectScreen.class);
/*  30 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "LanguageSelectScreen main");
/*  31 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 103, "MainMenuScreen launchFade");
/*     */   
/*     */   public LanguageSelectScreen() {
/*  34 */     this(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LanguageSelectScreen(boolean paramBoolean) {
/*  40 */     a();
/*     */     
/*  42 */     this.c.getTable().setTouchable(Touchable.disabled);
/*  43 */     if (paramBoolean) {
/*  44 */       this.c.getTable().setVisible(true);
/*     */       Image image;
/*  46 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/*  47 */       this.c.getTable().add((Actor)image).grow();
/*  48 */       this.c.getTable().addAction((Action)Actions.fadeOut(0.8F)); return;
/*     */     } 
/*  50 */     this.c.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   private void a() {
/*     */     String str;
/*  55 */     Game.i.uiManager.hideAllComponents();
/*  56 */     Game.i.uiManager.setAsInputHandler();
/*     */     
/*  58 */     ScreenTitle.i()
/*  59 */       .setText("Language")
/*  60 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-locale"))
/*  61 */       .setVisible(true);
/*     */     
/*     */     Table table1;
/*  64 */     (table1 = this.b.getTable()).clear();
/*     */     
/*  66 */     Label.LabelStyle labelStyle1 = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE);
/*     */     Label.LabelStyle labelStyle2;
/*  68 */     (labelStyle2 = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE)).background = Game.i.assetManager.getDrawable("blank").tint(MaterialColor.LIGHT_GREEN.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.07F));
/*  69 */     byte b1 = 0;
/*  70 */     byte b2 = 1;
/*     */     int i;
/*  72 */     if ((i = (Game.i.localeManager.getAvailableLocales()).size) > 10) {
/*  73 */       b2 = 3;
/*  74 */     } else if (i > 5) {
/*  75 */       b2 = 2;
/*     */     } 
/*     */     
/*  78 */     Table table2 = new Table();
/*  79 */     table1.add((Actor)table2).colspan(b2).padBottom(32.0F).row();
/*     */     
/*     */     Image image3;
/*  82 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  83 */     table1.add((Actor)image3).height(1.0F).fillX().colspan(b2).row();
/*     */     
/*  85 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(1.0F, 1.0F, 1.0F, 0.14F);
/*  86 */     table1.add((Actor)image3).height(1.0F).fillX().colspan(b2).padBottom(32.0F).row();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     (image3 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-note"))).setColor(MaterialColor.LIGHT_BLUE.P400);
/*  92 */     table2.add((Actor)image3).size(40.0F).padRight(12.0F);
/*  93 */     LabelToggleButton labelToggleButton3 = new LabelToggleButton("Music", Game.i.settingsManager.isMusicEnabled(), 30, 32.0F, paramBoolean -> Game.i.settingsManager.setMusicVolume(paramBoolean.booleanValue() ? 0.699999988079071D : 0.0D));
/*     */ 
/*     */     
/*  96 */     table2.add((Actor)labelToggleButton3).height(32.0F);
/*     */     
/*     */     Image image2;
/*  99 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-speaker"))).setColor(MaterialColor.LIGHT_BLUE.P400);
/* 100 */     table2.add((Actor)image2).size(40.0F).padRight(12.0F).padLeft(92.0F);
/* 101 */     LabelToggleButton labelToggleButton2 = new LabelToggleButton("Sounds", Game.i.settingsManager.isSoundEnabled(), 30, 32.0F, paramBoolean -> Game.i.settingsManager.setSoundVoulme(paramBoolean.booleanValue() ? 0.699999988079071D : 0.0D));
/*     */ 
/*     */     
/* 104 */     table2.add((Actor)labelToggleButton2).height(32.0F);
/*     */     
/*     */     Image image1;
/* 107 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-large-fonts"))).setColor(MaterialColor.LIGHT_BLUE.P400);
/* 108 */     table2.add((Actor)image1).size(40.0F).padRight(12.0F).padLeft(92.0F);
/* 109 */     LabelToggleButton labelToggleButton1 = new LabelToggleButton("Large fonts", Game.i.settingsManager.isLargeFontsEnabled(), 30, 32.0F, paramBoolean -> {
/*     */           Game.i.settingsManager.setLargeFontsEnabled(paramBoolean.booleanValue());
/*     */           a();
/*     */         });
/* 113 */     table2.add((Actor)labelToggleButton1).height(32.0F);
/*     */     
/* 115 */     table2 = null;
/*     */     try {
/* 117 */       String str1 = Game.i.actionResolver.getDefaultLocale();
/* 118 */       a.i("device locale " + str1, new Object[0]);
/*     */       String[] arrayOfString;
/* 120 */       if ((arrayOfString = Game.i.actionResolver.getDefaultLocale().split("_")).length == 1 && arrayOfString[0].length() == 2) {
/* 121 */         str = arrayOfString[0].toLowerCase(Locale.US);
/* 122 */       } else if (arrayOfString.length > 1) {
/* 123 */         if (arrayOfString[0].length() == 2) {
/* 124 */           str = arrayOfString[0].toLowerCase(Locale.US);
/*     */         }
/* 126 */         else if (arrayOfString[1].length() == 2) {
/* 127 */           str = arrayOfString[1].toLowerCase(Locale.US);
/*     */         }
/*     */       
/*     */       } 
/* 131 */     } catch (Exception exception) {
/* 132 */       a.i("failed to get default language", new Object[] { exception });
/*     */     } 
/* 134 */     a.i("highlighting locale '" + str + "'", new Object[0]);
/*     */     
/* 136 */     for (Array.ArrayIterator<LocaleManager.Locale> arrayIterator = Game.i.localeManager.getAvailableLocales().iterator(); arrayIterator.hasNext(); ) { LocaleManager.Locale locale = arrayIterator.next();
/*     */       Label label;
/* 138 */       (label = new Label(locale.name, labelStyle1)).setAlignment(1);
/* 139 */       table1.add((Actor)label).size(460.0F, 120.0F);
/*     */       
/* 141 */       if (str != null && locale.alias.startsWith(str)) {
/* 142 */         label.setStyle(labelStyle2);
/*     */       }
/* 144 */       label.addListener((EventListener)new InputListener(this, label) {
/*     */             public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 146 */               this.a.setColor(MaterialColor.LIGHT_BLUE.P500);
/*     */             }
/*     */             
/*     */             public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 150 */               this.a.setColor(Color.WHITE);
/*     */             }
/*     */           });
/* 153 */       label.addListener((EventListener)new ClickListener(this, locale)
/*     */           {
/*     */             public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 156 */               Game.i.localeManager.setLocale(this.a.alias, true);
/* 157 */               LanguageSelectScreen.a(this.b).getTable().setTouchable(Touchable.disabled);
/*     */               
/* 159 */               LanguageSelectScreen.b(this.b).getTable().clear();
/* 160 */               LanguageSelectScreen.b(this.b).getTable().setVisible(true);
/*     */               Image image;
/* 162 */               (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(Config.BACKGROUND_COLOR);
/* 163 */               LanguageSelectScreen.b(this.b).getTable().add((Actor)image).grow();
/* 164 */               (LanguageSelectScreen.b(this.b).getTable().getColor()).a = 0.0F;
/* 165 */               LanguageSelectScreen.b(this.b).getTable().addAction((Action)Actions.sequence(
/* 166 */                     (Action)Actions.fadeIn(0.5F), 
/* 167 */                     (Action)Actions.run(() -> Game.i.screenManager.goToMainMenuJustLaunched(true))));
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 174 */       b1++;
/* 175 */       if (b1 % b2 == 0) {
/* 176 */         table1.row();
/*     */       } }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(float paramFloat) {
/* 183 */     Color color = Game.i.assetManager.getColor("menu_background");
/* 184 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 185 */     Gdx.gl.glClear(16640);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 190 */     Game.i.uiManager.removeLayer(this.b);
/* 191 */     Game.i.uiManager.removeLayer(this.c);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\LanguageSelectScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */