/*      */ package com.prineside.tdi2.screens;
/*      */ 
/*      */ import com.badlogic.gdx.Application;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.Graphics;
/*      */ import com.badlogic.gdx.Input;
/*      */ import com.badlogic.gdx.Net;
/*      */ import com.badlogic.gdx.files.FileHandle;
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*      */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.net.HttpParametersUtils;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.BufferUtils;
/*      */ import com.badlogic.gdx.utils.JsonReader;
/*      */ import com.badlogic.gdx.utils.JsonValue;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.ObjectMap;
/*      */ import com.badlogic.gdx.utils.StringBuilder;
/*      */ import com.google.common.base.Preconditions;
/*      */ import com.prineside.tdi2.ActionResolver;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.Screen;
/*      */ import com.prineside.tdi2.Threads;
/*      */ import com.prineside.tdi2.enums.RarityType;
/*      */ import com.prineside.tdi2.enums.StaticSoundType;
/*      */ import com.prineside.tdi2.ibxm.IBXM;
/*      */ import com.prineside.tdi2.managers.AuthManager;
/*      */ import com.prineside.tdi2.managers.HttpManager;
/*      */ import com.prineside.tdi2.managers.LocaleManager;
/*      */ import com.prineside.tdi2.managers.PreferencesManager;
/*      */ import com.prineside.tdi2.managers.ReplayManager;
/*      */ import com.prineside.tdi2.managers.SettingsManager;
/*      */ import com.prineside.tdi2.managers.UiManager;
/*      */ import com.prineside.tdi2.managers.music.LiveMusicManager;
/*      */ import com.prineside.tdi2.managers.preferences.LegacyPreferences;
/*      */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
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
/*      */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*      */ import com.prineside.tdi2.scene2d.ui.Table;
/*      */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*      */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*      */ import com.prineside.tdi2.screens.account.AccountScreen;
/*      */ import com.prineside.tdi2.systems.GameStateSystem;
/*      */ import com.prineside.tdi2.ui.actors.FancyButton;
/*      */ import com.prineside.tdi2.ui.actors.HorizontalSlider;
/*      */ import com.prineside.tdi2.ui.actors.HotKeyHintLabel;
/*      */ import com.prineside.tdi2.ui.actors.Label;
/*      */ import com.prineside.tdi2.ui.actors.LabelButton;
/*      */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*      */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*      */ import com.prineside.tdi2.ui.actors.QuadActor;
/*      */ import com.prineside.tdi2.ui.shared.BackButton;
/*      */ import com.prineside.tdi2.ui.shared.DeveloperConsole;
/*      */ import com.prineside.tdi2.ui.shared.Dialog;
/*      */ import com.prineside.tdi2.ui.shared.MainMenuUiScene;
/*      */ import com.prineside.tdi2.ui.shared.Notifications;
/*      */ import com.prineside.tdi2.ui.shared.ScreenTitle;
/*      */ import com.prineside.tdi2.ui.shared.WebBrowser;
/*      */ import com.prineside.tdi2.utils.FastRandom;
/*      */ import com.prineside.tdi2.utils.FileIntegrityChecker;
/*      */ import com.prineside.tdi2.utils.IntPair;
/*      */ import com.prineside.tdi2.utils.MaterialColor;
/*      */ import com.prineside.tdi2.utils.UiUtils;
/*      */ import com.prineside.tdi2.utils.errorhandling.CrashHandler;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ import java.nio.IntBuffer;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Locale;
/*      */ import java.util.Random;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SettingsScreen
/*      */   extends Screen
/*      */ {
/*   93 */   private static final TLog a = TLog.forClass(SettingsScreen.class);
/*      */   
/*      */   private static boolean b = false;
/*      */   
/*   97 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 100, "SettingsScreen main");
/*   98 */   private final UiManager.UiLayer d = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 101, "SettingsScreen gradient");
/*   99 */   private final UiManager.UiLayer e = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.SCREEN, 102, "SettingsScreen safezone hint", true);
/*      */   
/*  101 */   private static final int[] f = new int[] { 0, 24, 30, 45, 48, 60, 72, 90, 100, 120, 128, 140, 144, 240 };
/*      */   
/*      */   private Table g;
/*      */   
/*      */   private int h;
/*      */   
/*      */   private int i;
/*      */   
/*      */   private ScrollPane j;
/*      */   
/*      */   private LabelToggleButton k;
/*      */   private LabelToggleButton l;
/*      */   private LabelToggleButton m;
/*      */   private SelectBox<String> n;
/*      */   private HorizontalSlider o;
/*      */   private HorizontalSlider p;
/*      */   private HorizontalSlider q;
/*      */   private HorizontalSlider r;
/*      */   private SelectBox<String> s;
/*      */   private Label t;
/*      */   private FancyButton u;
/*      */   
/*      */   public SettingsScreen() {
/*  124 */     this(0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public SettingsScreen(float paramFloat) {
/*  130 */     ActionResolver.InitConfigManager initConfigManager = Game.i.actionResolver.getInitConfigManager();
/*      */ 
/*      */     
/*  133 */     Game.i.musicManager.continuePlayingMenuMusicTrack();
/*      */     
/*  135 */     Game.i.uiManager.hideAllComponents();
/*  136 */     Game.i.uiManager.setAsInputHandler();
/*      */     
/*  138 */     ScreenTitle.i()
/*  139 */       .setIcon((Drawable)Game.i.assetManager.getDrawable("icon-wrench"))
/*  140 */       .setText(Game.i.localeManager.i18n.get("settings_title"))
/*  141 */       .setVisible(true);
/*      */     
/*  143 */     BackButton.i()
/*  144 */       .setVisible(true)
/*  145 */       .setText(null)
/*  146 */       .setClickHandler(() -> Game.i.screenManager.goToMainMenu());
/*      */     
/*  148 */     this.g = new Table();
/*  149 */     this.j = new ScrollPane((Actor)this.g, Game.i.assetManager.getScrollPaneStyle(16.0F));
/*  150 */     UiUtils.enableMouseMoveScrollFocus(this.j);
/*  151 */     this.j.setScrollingDisabled(true, false);
/*  152 */     this.c.getTable().add((Actor)this.j).expand().fill();
/*      */     
/*      */     Image image;
/*  155 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(Config.BACKGROUND_COLOR);
/*  156 */     this.d.getTable().setTouchable(Touchable.disabled);
/*  157 */     this.d.getTable().add((Actor)image).expandX().fillX().height(128.0F).row();
/*  158 */     this.d.getTable().add().expand().fill().row();
/*      */     
/*  160 */     this.g.add().height(128.0F).fillX().expandX().row();
/*      */ 
/*      */     
/*  163 */     Table table1 = a(Game.i.localeManager.i18n.get("settings_language"), "icon-locale");
/*      */     
/*  165 */     Table table4 = new Table();
/*  166 */     table1.add((Actor)table4).expandX().fillX().row();
/*      */     
/*  168 */     byte b = 0;
/*  169 */     for (Array.ArrayIterator<LocaleManager.Locale> arrayIterator = Game.i.localeManager.getAvailableLocales().iterator(); arrayIterator.hasNext(); ) { LocaleManager.Locale locale = arrayIterator.next();
/*      */       
/*      */       LocaleButton localeButton;
/*      */       
/*  173 */       (localeButton = new LocaleButton(locale.name, () -> a(paramLocale.alias))).setSelected(locale.alias.equals(Game.i.localeManager.i18n.getLocale().getLanguage() + "_" + Game.i.localeManager.i18n.getLocale().getCountry()));
/*  174 */       Cell cell = table4.add((Actor)localeButton.b).height(64.0F).width(340.0F);
/*  175 */       b++;
/*      */       
/*  177 */       if (b == 4) {
/*  178 */         cell.row();
/*  179 */         b = 0;
/*      */       }  }
/*      */ 
/*      */     
/*  183 */     Table table5 = new Table();
/*  184 */     Cell cell2 = table1.add((Actor)table5).padLeft(64.0F).padRight(-64.0F).expandX().fillX().padTop(16.0F);
/*  185 */     table1.row();
/*      */     
/*  187 */     if (!Game.i.localeManager.getLocale().equals("en_US")) {
/*  188 */       cell2.minHeight(160.0F);
/*      */       Label label;
/*  190 */       (label = new Label(Game.i.localeManager.i18n.get("loading..."), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  191 */       table5.add((Actor)label);
/*      */       
/*  193 */       Game.i.httpManager.post(Config.GET_COMMUNITY_TRANSLATORS_URL)
/*  194 */         .param("locale", Game.i.localeManager.getLocale())
/*  195 */         .listener(new HttpManager.RequestListener(this, table5)
/*      */           {
/*      */             public void onFinish(boolean param1Boolean1, Net.HttpResponse param1HttpResponse, boolean param1Boolean2, Throwable param1Throwable) {
/*  198 */               String str = param1HttpResponse.getResultAsString();
/*      */               
/*  200 */               JsonValue jsonValue = (new JsonReader()).parse(str);
/*      */               
/*  202 */               Threads.i().runOnMainThread(() -> {
/*      */                     Table table = new Table();
/*      */                     
/*      */                     byte b = 0;
/*      */                     
/*      */                     JsonValue.JsonIterator<JsonValue> jsonIterator = param1JsonValue.get("users").iterator();
/*      */                     
/*      */                     while (jsonIterator.hasNext()) {
/*      */                       JsonValue jsonValue;
/*      */                       
/*      */                       String str;
/*      */                       
/*      */                       if ((!(str = (jsonValue = jsonIterator.next()).getString("nickname")).toLowerCase(Locale.US).equals("therainycat") && !str.toLowerCase(Locale.US).equals("marshallua")) || Game.i.localeManager.getLocale().equals("uk_UA") || Game.i.localeManager.getLocale().equals("ru_RU")) {
/*      */                         Table table1 = new Table();
/*      */                         
/*      */                         table.add((Actor)table1).width(340.0F);
/*      */                         
/*      */                         if (++b == 4) {
/*      */                           table.row();
/*      */                           b = 0;
/*      */                         } 
/*      */                         Image image = new Image((TextureRegion)Game.i.assetManager.getTextureRegion("icon-user"));
/*      */                         if (jsonValue.getInt("has_avatar") == 1) {
/*      */                           image.setDrawable((Drawable)new TextureRegionDrawable((TextureRegion)Game.i.assetManager.loadWebTexture(Game.i.authManager.getAvatarWebUrl(jsonValue.getString("id"), 32))));
/*      */                         }
/*      */                         table1.add((Actor)image).size(24.0F).padRight(8.0F);
/*      */                         LimitedWidthLabel limitedWidthLabel;
/*      */                         (limitedWidthLabel = new LimitedWidthLabel(str, 24, 18, 308.0F)).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */                         table1.add((Actor)limitedWidthLabel).width(308.0F);
/*      */                         table1.addListener((EventListener)new ClickListener(this, str, limitedWidthLabel)
/*      */                             {
/*      */                               public void clicked(InputEvent param2InputEvent, float param2Float1, float param2Float2)
/*      */                               {
/*  235 */                                 (WebBrowser.i()).webView.loadUrl("GET", Config.XDX_VIEW_PLAYER_PROFILE_BY_NICKNAME_URL + this.a, null);
/*  236 */                                 WebBrowser.i().setVisible(true);
/*      */                               }
/*      */ 
/*      */                               
/*      */                               public void enter(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, @Null Actor param2Actor) {
/*  241 */                                 this.b.setColor(Color.WHITE);
/*      */                               }
/*      */ 
/*      */                               
/*      */                               public void exit(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, @Null Actor param2Actor) {
/*  246 */                                 this.b.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */                               }
/*      */                             });
/*      */                       } 
/*      */                     } 
/*      */                     
/*      */                     param1Table.clear();
/*      */                     
/*      */                     Label label;
/*      */                     
/*      */                     (label = new Label(Game.i.localeManager.i18n.get("settings_community_translators_title"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*      */                     label.setWrap(true);
/*      */                     param1Table.add((Actor)label).growX().row();
/*      */                     param1Table.add((Actor)table).growX().row();
/*      */                   });
/*      */             }
/*  262 */           }).send();
/*      */     } 
/*      */     
/*      */     LabelButton labelButton2;
/*      */     
/*  267 */     (labelButton2 = new LabelButton(Game.i.localeManager.i18n.get("settings_fix_translation") + " " + Game.i.assetManager.replaceRegionAliasesWithChars("<@icon-link-out>"), Game.i.assetManager.getLabelStyle(24), () -> Gdx.net.openURI("https://infinitode.prineside.com/?m=translate"))).setColors(MaterialColor.LIGHT_GREEN.P700, MaterialColor.LIGHT_GREEN.P300);
/*      */     
/*  269 */     table1.add((Actor)labelButton2).left().height(64.0F).padTop(16.0F).padLeft(64.0F).row();
/*      */ 
/*      */     
/*  272 */     table1 = a(Game.i.localeManager.i18n.get("settings_audio"), "icon-note");
/*      */ 
/*      */     
/*  275 */     Label label7 = new Label(Game.i.localeManager.i18n.get("settings_sound"), Game.i.assetManager.getLabelStyle(30));
/*  276 */     table1.add((Actor)label7).padLeft(64.0F).size(616.0F, 64.0F);
/*      */     
/*  278 */     Label label3 = new Label(Game.i.localeManager.i18n.get("settings_music"), Game.i.assetManager.getLabelStyle(30));
/*  279 */     table1.add((Actor)label3).padLeft(64.0F).size(616.0F, 64.0F).row();
/*      */ 
/*      */     
/*  282 */     Table table3 = new Table();
/*  283 */     table1.add((Actor)table3).padLeft(64.0F).padBottom(16.0F).size(616.0F, 48.0F);
/*  284 */     Label label4 = new Label(StrictMath.round(Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SOUND_VOLUME) * 100.0D) + "%", Game.i.assetManager.getLabelStyle(24));
/*      */ 
/*      */     
/*      */     HorizontalSlider horizontalSlider;
/*      */     
/*  289 */     (horizontalSlider = new HorizontalSlider(400.0F, Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SOUND_VOLUME), 0.0D, 1.0D, paramDouble -> { Game.i.settingsManager.setSoundVoulme(paramDouble.doubleValue()); paramLabel.setText(StrictMath.round(paramDouble.doubleValue() * 100.0D) + "%"); })).setNotifyOnDrag(true);
/*  290 */     table3.add((Actor)horizontalSlider).size(400.0F, 48.0F);
/*  291 */     table3.add((Actor)label4).padLeft(16.0F);
/*  292 */     table3.add().height(1.0F).expandX().fillX();
/*      */ 
/*      */     
/*  295 */     table3 = new Table();
/*  296 */     table1.add((Actor)table3).padLeft(64.0F).padBottom(16.0F).size(616.0F, 48.0F).row();
/*  297 */     label4 = new Label(StrictMath.round(Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_VOLUME) * 100.0D) + "%", Game.i.assetManager.getLabelStyle(24));
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
/*  308 */     (horizontalSlider = new HorizontalSlider(400.0F, Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_VOLUME), 0.0D, 1.0D, paramDouble -> { double d = Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_VOLUME); Game.i.settingsManager.setMusicVolume(paramDouble.doubleValue()); if (d > 0.0D && paramDouble.doubleValue() <= 0.0D) { Game.i.musicManager.stopMusic(); } else if (d <= 0.0D && paramDouble.doubleValue() > 0.0D) { Game.i.musicManager.continuePlayingMenuMusicTrack(); }  paramLabel.setText(StrictMath.round(paramDouble.doubleValue() * 100.0D) + "%"); })).setNotifyOnDrag(true);
/*  309 */     table3.add((Actor)horizontalSlider).size(400.0F, 48.0F);
/*  310 */     table3.add((Actor)label4).padLeft(16.0F);
/*  311 */     table3.add().height(1.0F).expandX().fillX();
/*      */ 
/*      */     
/*  314 */     Label label2 = new Label(Game.i.localeManager.i18n.get("settings_shooting_sound"), Game.i.assetManager.getLabelStyle(30));
/*  315 */     table1.add((Actor)label2).padLeft(64.0F).size(616.0F, 64.0F).row();
/*      */     
/*  317 */     Table table2 = new Table();
/*  318 */     table1.add((Actor)table2).padLeft(64.0F).padBottom(16.0F).size(616.0F, 48.0F).row();
/*  319 */     label4 = new Label(StrictMath.round(Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SHOOTING_SOUNDS_VOLUME) * 100.0D) + "%", Game.i.assetManager.getLabelStyle(24));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  324 */     (horizontalSlider = new HorizontalSlider(400.0F, Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SHOOTING_SOUNDS_VOLUME), 0.0D, 1.0D, paramDouble -> { Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.SHOOTING_SOUNDS_VOLUME, paramDouble.doubleValue()); paramLabel.setText(StrictMath.round(paramDouble.doubleValue() * 100.0D) + "%"); })).setNotifyOnDrag(true);
/*  325 */     table2.add((Actor)horizontalSlider).size(400.0F, 48.0F);
/*  326 */     table2.add((Actor)label4).padLeft(16.0F);
/*  327 */     table2.add().height(1.0F).expandX().fillX();
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
/*  361 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_smooth_music"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SMOOTH_MUSIC) != 0.0D), 30, 40.0F, true, paramBoolean -> {
/*      */             Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.SMOOTH_MUSIC, paramBoolean.booleanValue() ? 1.0D : 0.0D);
/*      */             
/*      */             IBXM iBXM;
/*      */             if (Game.i.musicManager instanceof LiveMusicManager && (iBXM = ((LiveMusicManager)Game.i.musicManager).ibxm) != null) {
/*      */               iBXM.setInterpolation(Game.i.musicManager.getInterpolation());
/*      */             }
/*  368 */           })).padLeft(64.0F).width(616.0F).height(64.0F).row();
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
/*  393 */     if (Game.i.settingsManager.isSecretCodesEnabled())
/*      */     {
/*  395 */       (table1 = a(Game.i.localeManager.i18n.get("settings_special"), "icon-star")).add((Actor)new LabelButton(Game.i.localeManager.i18n.get("settings_secret_code"), Game.i.assetManager.getLabelStyle(30), () -> {
/*      */               Input.TextInputListener textInputListener = new Input.TextInputListener(this)
/*      */                 {
/*      */                   public void input(String param1String) {
/*  399 */                     Threads.i().runOnMainThread(() -> Game.i.secretCodeManager.applyCode(param1String));
/*      */                   }
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   public void canceled() {}
/*      */                 };
/*      */               Game.i.uiManager.getTextInput(textInputListener, Game.i.localeManager.i18n.get("secret_code"), "", "");
/*  408 */             })).height(64.0F).padLeft(64.0F).width(616.0F);
/*      */     }
/*      */     
/*  411 */     table1.add((Actor)new LabelButton(Game.i.localeManager.i18n.get("settings_restore_purchases"), Game.i.assetManager.getLabelStyle(30), () -> {
/*      */ 
/*      */ 
/*      */             
/*      */             if (Game.i.purchaseManager.isPurchasesEnabled()) {
/*      */               Dialog.i().showConfirm(Game.i.localeManager.i18n.get("settings_restore_purchases") + "?", ());
/*      */             }
/*  418 */           })).height(64.0F).padLeft(64.0F).width(616.0F).row();
/*      */     
/*  420 */     if (Game.i.progressManager.hasPermanentDoubleGain() || Game.i.progressManager.hasTemporaryDoubleGain()) {
/*  421 */       table2 = new Table();
/*  422 */       table1.add((Actor)table2).padLeft(64.0F).width(616.0F);
/*      */       
/*  424 */       table2.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_enable_double_gain"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DOUBLE_GAIN_DISABLED_MANUALLY) == 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.DOUBLE_GAIN_DISABLED_MANUALLY, paramBoolean.booleanValue() ? 0.0D : 1.0D))).height(64.0F).growX().row();
/*      */ 
/*      */       
/*  427 */       (label4 = new Label(Game.i.localeManager.i18n.get("settings_enable_double_gain_hint"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  428 */       label4.setWrap(true);
/*  429 */       table2.add((Actor)label4).padTop(8.0F).padBottom(16.0F).fillX().row();
/*      */     } 
/*      */     
/*  432 */     if (Game.i.authManager.isProfileStatusActive("premium")) {
/*  433 */       table2 = new Table();
/*  434 */       table1.add((Actor)table2).padLeft(64.0F).width(616.0F);
/*      */       
/*  436 */       table2.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_enable_premium_status"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PREMIUM_STATUS_DISABLED_MANUALLY) == 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.PREMIUM_STATUS_DISABLED_MANUALLY, paramBoolean.booleanValue() ? 0.0D : 1.0D))).height(64.0F).growX().row();
/*      */ 
/*      */       
/*  439 */       (label4 = new Label(Game.i.localeManager.i18n.get("settings_enable_premium_status_hint"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  440 */       label4.setWrap(true);
/*  441 */       table2.add((Actor)label4).padTop(8.0F).padBottom(16.0F).fillX().row();
/*      */     } 
/*  443 */     table1.row();
/*      */     
/*  445 */     if (Game.i.authManager.isProfileStatusActive("premium") || Game.i.progressManager.hasPermanentDoubleGain() || Game.i.progressManager.hasTemporaryDoubleGain()) {
/*      */       Label label;
/*  447 */       (label = new Label(Game.i.localeManager.i18n.get("settings_enable_account_status_disclaimer"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  448 */       label.setWrap(true);
/*  449 */       table1.add((Actor)label).padLeft(64.0F).colspan(2).fillX();
/*      */     } 
/*  451 */     table1.row();
/*      */ 
/*      */     
/*  454 */     if (Game.i.actionResolver.personalizedAdsSupported()) {
/*  455 */       table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_personalized_ads"), Game.i.actionResolver.personalizedAdsEnabled(), 30, 40.0F, true, paramBoolean -> Game.i.actionResolver.setPersonalizedAds(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F).row();
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
/*  506 */     table1 = a(Game.i.localeManager.i18n.get("settings_gameplay"), "icon-joystick");
/*      */ 
/*      */     
/*  509 */     if (Game.getTimestampSeconds() < 1723485232 && !b)
/*      */     {
/*  511 */       if (Game.i.preferencesManager.getLegacyPreferences().has1dot8prefs()) {
/*      */         
/*  513 */         (table2 = new Table()).background(Game.i.assetManager.getDrawable("blank").tint(MaterialColor.PURPLE.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.07F)));
/*  514 */         table1.add((Actor)table2).padBottom(4.0F).colspan(2).fillX().row();
/*      */ 
/*      */         
/*  517 */         (label4 = new Label(Game.i.localeManager.i18n.get("old_1_dot_8_prefs_found_manual_migration_hint"), Game.i.assetManager.getLabelStyle(21))).setWrap(true);
/*  518 */         label4.setColor(MaterialColor.PURPLE.P300);
/*  519 */         label4.setAlignment(1);
/*  520 */         table2.add((Actor)label4).growX().padLeft(20.0F).padRight(20.0F).padTop(20.0F).row();
/*      */         
/*  522 */         FancyButton fancyButton = new FancyButton("regularGreenButton.a", () -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("1_dot_8_manual_migration_confirm"), ()));
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
/*  544 */         label4 = new Label(Game.i.localeManager.i18n.get("migrate_manually"), Game.i.assetManager.getLabelStyle(24));
/*  545 */         fancyButton.add((Actor)label4);
/*  546 */         table2.add((Actor)fancyButton).width(400.0F).height(48.0F).padTop(16.0F).padBottom(8.0F).row();
/*      */ 
/*      */         
/*  549 */         StringBuilder stringBuilder = new StringBuilder();
/*      */         
/*  551 */         FileHandle fileHandle1 = Gdx.files.local(PreferencesManager.getSettingsPrefsFilePath());
/*  552 */         FileHandle fileHandle2 = Gdx.files.local(PreferencesManager.getProgressPrefsFilePath());
/*  553 */         if (fileHandle1.exists() || fileHandle2.exists()) {
/*  554 */           stringBuilder.append("1.9 saves found /");
/*      */         } else {
/*  556 */           stringBuilder.append("1.9 saves not found /");
/*      */         } 
/*  558 */         stringBuilder.append(" migration flag ").append(Game.i.preferencesManager.getLegacyPreferences().has1dot9migrationFlag() ? "found" : "not found");
/*      */         Label label;
/*  560 */         (label = new Label((CharSequence)stringBuilder, Game.i.assetManager.getLabelStyle(21))).setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*  561 */         table2.add((Actor)label).padTop(8.0F).padBottom(20.0F).row();
/*      */       } 
/*      */     }
/*      */     
/*  565 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_instant_auto_wave_calls"), Game.i.settingsManager.isInstantAutoWaveCallEnabled(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setInstantAutoWaveCallEnabled(paramBoolean.booleanValue()))).height(64.0F).padLeft(64.0F).width(616.0F);
/*      */     
/*  567 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/*  568 */       table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_rmb_equals_hold_button"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.INSTANT_HOLD_BUTTON_ON_RMB) != 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.INSTANT_HOLD_BUTTON_ON_RMB, paramBoolean.booleanValue() ? 1.0D : 0.0D))).height(64.0F).padLeft(64.0F).width(616.0F).row();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Group group1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  581 */     (group1 = new Group()).setTransform(false);
/*      */ 
/*      */     
/*  584 */     (label4 = new Label(Game.i.localeManager.i18n.get("settings_auto_save_interval"), Game.i.assetManager.getLabelStyle(30))).setSize(100.0F, 64.0F);
/*  585 */     label4.setPosition(0.0F, 64.0F);
/*  586 */     group1.addActor((Actor)label4);
/*      */     
/*      */     Label label5;
/*  589 */     (label5 = new Label("", Game.i.assetManager.getLabelStyle(24))).setPosition(420.0F, 0.0F);
/*  590 */     label5.setSize(180.0F, 64.0F);
/*  591 */     group1.addActor((Actor)label5);
/*      */     
/*  593 */     int i = (int)(Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.STATE_AUTO_SAVE_INTERVAL) * 2.0D);
/*  594 */     this.r = new HorizontalSlider(400.0F, 0.0D, 0.0D, 30.0D, paramDouble -> {
/*      */           int i = MathUtils.round(paramDouble.floatValue());
/*      */           
/*      */           Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.STATE_AUTO_SAVE_INTERVAL, (i * 0.5F));
/*      */           
/*      */           if (i == 0) {
/*      */             paramLabel.setText(Game.i.localeManager.i18n.get("never"));
/*      */             
/*      */             return;
/*      */           } 
/*      */           
/*      */           if (i % 2 == 0) {
/*      */             paramLabel.setText((i / 2) + Game.i.localeManager.i18n.get("TIME_CHAR_MINUTE"));
/*      */             
/*      */             return;
/*      */           } 
/*      */           
/*      */           paramLabel.setText((i / 2) + Game.i.localeManager.i18n.get("TIME_CHAR_MINUTE") + " 30" + Game.i.localeManager.i18n.get("TIME_CHAR_SECOND"));
/*      */         });
/*  613 */     this.r.setNotifyOnDrag(true);
/*  614 */     this.r.setSize(400.0F, 64.0F);
/*  615 */     this.r.setValue(i, true);
/*  616 */     group1.addActor((Actor)this.r);
/*      */     
/*  618 */     table1.row();
/*  619 */     table1.add((Actor)group1).padLeft(64.0F).width(616.0F).height(128.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     LabelButton labelButton1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  639 */     (labelButton1 = new LabelButton(Game.i.localeManager.i18n.get("settings_reset_progress"), Game.i.assetManager.getLabelStyle(30), () -> { boolean bool = Game.i.progressManager.isDeveloperModeEnabled(); Dialog.i().showConfirm(Game.i.localeManager.i18n.get("settings_reset_progress_question"), ()); Dialog.i().makeConfirmButtonDisabled(2); })).setColors(MaterialColor.RED.P600, MaterialColor.ORANGE.P400);
/*  640 */     table1.add((Actor)labelButton1).bottom().left().padLeft(64.0F).width(616.0F).height(64.0F).row();
/*      */ 
/*      */ 
/*      */     
/*  644 */     (label7 = new Label(Game.i.localeManager.i18n.get("settings_auto_save_hint"), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  645 */     label7.setWrap(true);
/*  646 */     table1.add((Actor)label7).top().left().padLeft(64.0F).width(616.0F).padTop(8.0F).padBottom(16.0F).row();
/*      */     
/*  648 */     if (Game.i.actionResolver.hasNotifications()) {
/*  649 */       table1.row();
/*  650 */       table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_notifications"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SEND_NOTIFICATIONS) != 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.SEND_NOTIFICATIONS, paramBoolean.booleanValue() ? 1.0D : 0.0D)))
/*      */ 
/*      */         
/*  653 */         .padLeft(64.0F).width(616.0F).height(64.0F);
/*      */     } 
/*      */     
/*  656 */     table1.row();
/*  657 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_show_bonus_selection_immediately"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SHOW_BONUS_SELECTION_IMMEDIATELY) != 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.SHOW_BONUS_SELECTION_IMMEDIATELY, paramBoolean.booleanValue() ? 1.0D : 0.0D))).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */     
/*  659 */     table1.row();
/*  660 */     table1.add().height(1.0F).expandX().fillX().row();
/*      */ 
/*      */     
/*  663 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/*  664 */       table1.add((Actor)new LabelButton(Game.i.localeManager.i18n.get("settings_edit_hotkeys"), Game.i.assetManager.getLabelStyle(30), () -> Game.i.screenManager.goToHotkeyEditorScreen())).padLeft(64.0F).height(64.0F).width(616.0F).row();
/*      */     }
/*      */ 
/*      */     
/*  668 */     if (Gdx.graphics.supportsDisplayModeChange() || initConfigManager.isAvailable(SettingsManager.InitConfig.GRAPHICS_AA_LEVELS)) {
/*  669 */       table1 = a(Game.i.localeManager.i18n.get("settings_screen"), "icon-screen");
/*      */       
/*  671 */       Table table = new Table();
/*  672 */       table1.add((Actor)table).colspan(2).width(1360.0F).row();
/*      */       
/*  674 */       if (Gdx.graphics.supportsDisplayModeChange()) {
/*      */         
/*  676 */         this
/*      */           
/*  678 */           .k = new LabelToggleButton(Game.i.localeManager.i18n.get("settings_toggle_graphics_full_screen"), (initConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED) != 0), 30, 40.0F, true, paramBoolean -> this.u.setEnabled(true));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  684 */         table.add((Actor)this.k).width(616.0F).padLeft(64.0F).height(64.0F).top().left();
/*      */ 
/*      */         
/*  687 */         this
/*      */           
/*  689 */           .m = new LabelToggleButton(Game.i.localeManager.i18n.get("settings_toggle_graphics_vertical_synchronization"), (initConfigManager.get(SettingsManager.InitConfig.GRAPHICS_VSYNC) != 0), 30, 40.0F, true, paramBoolean -> this.u.setEnabled(true));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  695 */         table.add((Actor)this.m).width(616.0F).padLeft(64.0F).height(64.0F).top().left().row();
/*      */         
/*  697 */         if (initConfigManager.isAvailable(SettingsManager.InitConfig.GRAPHICS_FS_BORDERLESS)) {
/*      */           
/*  699 */           this.l = new LabelToggleButton(Game.i.localeManager.i18n.get("settings_windowed_borderless_fullscreen"), (initConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_BORDERLESS) != 0), 30, 40.0F, true, paramBoolean -> this.u.setEnabled(true));
/*      */ 
/*      */           
/*  702 */           table.add((Actor)this.l).width(616.0F).padLeft(64.0F).height(64.0F).top().left().row();
/*      */         } 
/*      */ 
/*      */         
/*  706 */         Graphics.DisplayMode[] arrayOfDisplayMode1 = Gdx.graphics.getDisplayModes();
/*  707 */         int k = 0; Graphics.DisplayMode[] arrayOfDisplayMode2; int n;
/*  708 */         for (int m = (arrayOfDisplayMode2 = arrayOfDisplayMode1).length; n < m; ) { Graphics.DisplayMode displayMode1 = arrayOfDisplayMode2[n];
/*  709 */           if (k < displayMode1.bitsPerPixel)
/*  710 */             k = displayMode1.bitsPerPixel; 
/*      */           n++; }
/*      */         
/*  713 */         Array array1 = new Array(IntPair.class); Graphics.DisplayMode[] arrayOfDisplayMode3; byte b2;
/*  714 */         for (n = (arrayOfDisplayMode3 = arrayOfDisplayMode1).length, b2 = 0; b2 < n; ) {
/*  715 */           Graphics.DisplayMode displayMode1; if ((displayMode1 = arrayOfDisplayMode3[b2]).bitsPerPixel >= k && 
/*  716 */             displayMode1.height >= 540.0F) {
/*      */             
/*  718 */             boolean bool = false;
/*  719 */             for (byte b4 = 0; b4 < array1.size; b4++) {
/*  720 */               if ((((IntPair[])array1.items)[b4]).a == displayMode1.width && (((IntPair[])array1.items)[b4]).b == displayMode1.height) {
/*  721 */                 bool = true;
/*      */                 break;
/*      */               } 
/*      */             } 
/*  725 */             if (!bool)
/*  726 */               array1.add(new IntPair(displayMode1.width, displayMode1.height)); 
/*      */           }  b2++;
/*      */         } 
/*  729 */         array1.sort((paramIntPair1, paramIntPair2) -> Integer.compare(paramIntPair1.a, paramIntPair2.a));
/*      */         
/*  731 */         Array array2 = new Array(String.class);
/*  732 */         for (n = 0; n < array1.size; n++) {
/*  733 */           IntPair intPair = ((IntPair[])array1.items)[n];
/*  734 */           array2.add(intPair.a + "x" + intPair.b);
/*      */         } 
/*      */         
/*  737 */         Graphics.DisplayMode displayMode = SettingsManager.getBestFullscreenMode(initConfigManager
/*  738 */             .get(SettingsManager.InitConfig.GRAPHICS_FS_WIDTH), initConfigManager
/*  739 */             .get(SettingsManager.InitConfig.GRAPHICS_FS_HEIGHT));
/*      */ 
/*      */         
/*  742 */         this.n = new SelectBox(Game.i.assetManager.getSelectBoxStyle((BitmapFont)Game.i.assetManager.getFont(24), true));
/*  743 */         this.n.setItems(array2);
/*  744 */         this.n.setSelected(displayMode.width + "x" + displayMode.height);
/*  745 */         this.n.addListener((EventListener)new ChangeListener(this)
/*      */             {
/*      */               public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  748 */                 SettingsScreen.a(this.a).setEnabled(true);
/*      */               }
/*      */             });
/*  751 */         table.add((Actor)this.n).width(516.0F).padLeft(64.0F).height(56.0F).padTop(8.0F).padRight(100.0F).top().left();
/*      */         
/*      */         Group group;
/*      */         
/*  755 */         (group = new Group()).setTransform(false);
/*  756 */         table.add((Actor)group).width(616.0F).padLeft(64.0F).height(64.0F).top().left().row();
/*      */         
/*      */         Label label;
/*  759 */         (label = new Label("", Game.i.assetManager.getLabelStyle(24))).setPosition(420.0F, 0.0F);
/*  760 */         label.setSize(180.0F, 64.0F);
/*  761 */         group.addActor((Actor)label);
/*      */         
/*  763 */         int i1 = initConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FPS_LIMIT);
/*  764 */         this.o = new HorizontalSlider(400.0F, i1, 0.0D, 1.0D, paramDouble -> {
/*      */               int i = MathUtils.round((float)this.o.getValue() * (f.length - 1));
/*      */               
/*      */               if (this.u != null) {
/*      */                 this.u.setEnabled(true);
/*      */               }
/*      */               
/*      */               if ((i = f[i]) == 0) {
/*      */                 paramLabel.setText(Game.i.localeManager.i18n.get("settings_label_no_fps_limit"));
/*      */                 
/*      */                 return;
/*      */               } 
/*      */               
/*      */               paramLabel.setText("Max " + i + " FPS");
/*      */             });
/*      */         
/*  780 */         this.o.setNotifyOnDrag(true);
/*  781 */         this.o.setSize(400.0F, 64.0F);
/*      */         
/*  783 */         byte b3 = 0;
/*  784 */         k = 9001;
/*  785 */         for (byte b1 = 0; b1 < f.length; b1++) {
/*      */           int i2;
/*  787 */           if ((i2 = Math.abs(f[b1] - i1)) < k) {
/*  788 */             k = i2;
/*  789 */             b3 = b1;
/*      */           } 
/*      */         } 
/*  792 */         this.o.setValue((b3 / (f.length - 1)), true);
/*  793 */         group.addActor((Actor)this.o);
/*      */       } 
/*      */       
/*  796 */       if (initConfigManager.isAvailable(SettingsManager.InitConfig.GRAPHICS_AA_LEVELS)) {
/*      */         
/*  798 */         Label label = new Label(Game.i.localeManager.i18n.get("settings_label_anti_aliasing"), Game.i.assetManager.getLabelStyle(30));
/*  799 */         table.add((Actor)label).top().left().padTop(24.0F).padLeft(64.0F).row();
/*      */         
/*  801 */         this.s = new SelectBox(Game.i.assetManager.getSelectBoxStyle((BitmapFont)Game.i.assetManager.getFont(24), false));
/*      */         Array array;
/*  803 */         (array = new Array()).add("None");
/*      */         
/*  805 */         int k = 4;
/*      */         try {
/*  807 */           IntBuffer intBuffer = BufferUtils.newIntBuffer(4);
/*  808 */           Gdx.gl20.glGetIntegerv(36183, intBuffer);
/*  809 */           k = intBuffer.get();
/*  810 */           a.i("received max samples: " + k, new Object[0]);
/*  811 */         } catch (Exception exception) {
/*      */           
/*  813 */           a.e("Failed to get max samples, falling back to " + k, new Object[0]);
/*      */         } 
/*      */         
/*  816 */         if (k >= 2) {
/*  817 */           array.add("2x MSAA");
/*      */         }
/*  819 */         if (k >= 4) {
/*  820 */           array.add("4x MSAA");
/*      */         }
/*  822 */         if (k >= 8) {
/*  823 */           array.add("8x MSAA");
/*      */         }
/*  825 */         if (k >= 16) {
/*  826 */           array.add("16x MSAA");
/*      */         }
/*  828 */         this.s.setItems((Object[])new String[0]);
/*  829 */         this.s.setItems(array);
/*  830 */         int m = initConfigManager.get(SettingsManager.InitConfig.GRAPHICS_AA_LEVELS);
/*  831 */         a.i("current MSAA setting: " + m, new Object[0]);
/*      */         try {
/*  833 */           IntBuffer intBuffer = BufferUtils.newIntBuffer(4);
/*  834 */           Gdx.gl20.glGetIntegerv(32937, intBuffer);
/*  835 */           int n = intBuffer.get();
/*  836 */           a.i("received current samples: " + n, new Object[0]);
/*  837 */         } catch (Exception exception) {
/*      */           
/*  839 */           a.e("Failed to get current samples", new Object[0]);
/*      */         } 
/*      */         
/*  842 */         switch (m) { case 0: case 1:
/*  843 */             this.s.setSelected("None"); break;
/*  844 */           case 2: this.s.setSelected("2x MSAA"); break;
/*  845 */           case 4: this.s.setSelected("4x MSAA"); break;
/*  846 */           case 8: this.s.setSelected("8x MSAA"); break;
/*  847 */           case 16: this.s.setSelected("16x MSAA"); break; }
/*      */         
/*  849 */         this.s.addListener((EventListener)new ChangeListener(this, initConfigManager)
/*      */             {
/*      */               public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  852 */                 null = (String)SettingsScreen.b(this.b).getSelected();
/*  853 */                 byte b = 1;
/*  854 */                 switch (null) { case "None":
/*  855 */                     b = 1; break;
/*  856 */                   case "2x MSAA": b = 2; break;
/*  857 */                   case "4x MSAA": b = 4; break;
/*  858 */                   case "8x MSAA": b = 8; break;
/*  859 */                   case "16x MSAA": b = 16; break; }
/*      */                 
/*  861 */                 SettingsScreen.a(this.b).setEnabled(true);
/*      */                 
/*  863 */                 if (b != this.a.get(SettingsManager.InitConfig.GRAPHICS_AA_LEVELS)) {
/*  864 */                   SettingsScreen.c(this.b).setVisible(true);
/*      */                 }
/*      */               }
/*      */             });
/*  868 */         table.add((Actor)this.s).width(516.0F).padLeft(64.0F).height(56.0F).padTop(8.0F).top().left().row();
/*      */       } 
/*      */ 
/*      */       
/*  872 */       this
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
/*  960 */         .u = (new FancyButton("regularButton.a", () -> { if (Gdx.graphics.supportsDisplayModeChange()) { Gdx.graphics.setVSync(this.m.isEnabled()); if (paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_VSYNC) != (this.m.isEnabled() ? 1 : 0)) paramInitConfigManager.set(SettingsManager.InitConfig.GRAPHICS_VSYNC, this.m.isEnabled() ? 1 : 0);  int i = MathUtils.round((float)this.o.getValue() * (f.length - 1)); int j = f[i]; if (paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FPS_LIMIT) != j) paramInitConfigManager.set(SettingsManager.InitConfig.GRAPHICS_FPS_LIMIT, j);  Game.i.actionResolver.setFpsLimit(j); String[] arrayOfString; if (this.n.getSelected() != null && (arrayOfString = ((String)this.n.getSelected()).split("x")).length >= 2) try { i = Integer.parseInt(arrayOfString[0]); j = Integer.parseInt(arrayOfString[1]); paramInitConfigManager.set(SettingsManager.InitConfig.GRAPHICS_FS_WIDTH, i); paramInitConfigManager.set(SettingsManager.InitConfig.GRAPHICS_FS_HEIGHT, j); } catch (Exception exception) { a.e(exception.getMessage(), new Object[0]); }   boolean bool; if (bool = this.l.isEnabled()) { if (paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_BORDERLESS) == 0) paramInitConfigManager.set(SettingsManager.InitConfig.GRAPHICS_FS_BORDERLESS, 1);  } else if (paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_BORDERLESS) != 0) { paramInitConfigManager.set(SettingsManager.InitConfig.GRAPHICS_FS_BORDERLESS, 0); }  if (this.k.isEnabled()) { Graphics.DisplayMode displayMode; if ((displayMode = SettingsManager.getBestFullscreenMode(paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_WIDTH), paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_HEIGHT))) != null) { if (bool) { Gdx.graphics.setUndecorated(true); Gdx.graphics.setWindowedMode(displayMode.width, displayMode.height); } else { Gdx.graphics.setUndecorated(false); Gdx.graphics.setFullscreenMode(displayMode); }  if (paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED) == 0) paramInitConfigManager.set(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED, 1);  }  } else { Gdx.graphics.setUndecorated(false); Gdx.graphics.setWindowedMode(1600, 900); if (paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED) != 0) paramInitConfigManager.set(SettingsManager.InitConfig.GRAPHICS_FS_ENABLED, 0);  }  }  if (paramInitConfigManager.isAvailable(SettingsManager.InitConfig.GRAPHICS_AA_LEVELS)) { byte b = 1; switch ((String)this.s.getSelected()) { case "None": b = 1; break;case "2x MSAA": b = 2; break;case "4x MSAA": b = 4; break;case "8x MSAA": b = 8; break;case "16x MSAA": b = 16; break; }  if (paramInitConfigManager.get(SettingsManager.InitConfig.GRAPHICS_AA_LEVELS) != b) paramInitConfigManager.set(SettingsManager.InitConfig.GRAPHICS_AA_LEVELS, b);  }  this.u.setEnabled(false); Game.i.actionResolver.getInitConfigManager().saveIfRequired(); })).withLabel(30, Game.i.localeManager.i18n.get("settings_button_apply"));
/*      */       
/*  962 */       this.u.setEnabled(false);
/*  963 */       table.add((Actor)this.u).size(220.0F, 64.0F).padLeft(64.0F).left().padTop(32.0F).padBottom(16.0F).row();
/*      */       
/*  965 */       this.t = new Label(Game.i.localeManager.i18n.get("settings_note_restart_required"), Game.i.assetManager.getLabelStyle(24));
/*  966 */       this.t.setColor(MaterialColor.AMBER.P500);
/*  967 */       this.t.setVisible(false);
/*  968 */       table.add((Actor)this.t).padLeft(64.0F).top().left().fillX().row();
/*      */       
/*  970 */       table.add().height(1.0F).expandX().fillX();
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
/*  986 */     (table1 = a(Game.i.localeManager.i18n.get("settings_graphics"), "icon-easel")).add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_large_fonts"), Game.i.settingsManager.isLargeFontsEnabled(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setLargeFontsEnabled(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */ 
/*      */     
/*      */     Cell cell1;
/*      */     
/*  991 */     (cell1 = table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_draw_particles"), Game.i.settingsManager.isParticlesDrawing(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setParticlesDrawing(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F)).row();
/*      */ 
/*      */     
/*  994 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_draw_explosions"), Game.i.settingsManager.isExplosionsDrawing(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setExplosionsDrawing(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  999 */     (cell1 = table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_draw_projectiles"), Game.i.settingsManager.isProjectilesDrawing(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setProjectilesDrawing(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F)).row();
/*      */ 
/*      */     
/* 1002 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_draw_projectile_trails"), Game.i.settingsManager.isProjectileTrailsDrawing(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setProjectileTrailsDrawing(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1007 */     (cell1 = table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_flying_coins"), Game.i.settingsManager.isFlyingCoinsEnabled(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setFlyingCoinsEnabled(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F)).row();
/*      */ 
/*      */     
/* 1010 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_ui_animations"), Game.i.settingsManager.isUiAnimationsEnabled(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setUiAnimationsEnabled(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1015 */     (cell1 = table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_stains"), Game.i.settingsManager.isStainsEnabled(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setStainsEnabled(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F)).row();
/*      */ 
/*      */     
/* 1018 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_colorblindness"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.COLORBLIND_MODE) == 1.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.COLORBLIND_MODE, paramBoolean.booleanValue() ? 1.0D : 0.0D))).padLeft(64.0F).width(616.0F).height(64.0F);
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
/* 1033 */     (cell1 = table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_slow_motion_pause"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.SLOW_MOTION_PAUSE) == 1.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.SLOW_MOTION_PAUSE, paramBoolean.booleanValue() ? 1.0D : 0.0D))).padLeft(64.0F).width(616.0F).height(64.0F)).row();
/*      */ 
/*      */     
/* 1036 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_draw_tower_target"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DRAW_TOWER_TARGET) == 1.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.DRAW_TOWER_TARGET, paramBoolean.booleanValue() ? 1.0D : 0.0D))).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1041 */     (cell1 = table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_live_leaderboards"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.LIVE_LEADERBOARDS) > 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.LIVE_LEADERBOARDS, paramBoolean.booleanValue() ? 1.0D : 0.0D))).padLeft(64.0F).width(616.0F).height(64.0F)).row();
/*      */ 
/*      */     
/* 1044 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_statistics_chart"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.STATISTICS_CHART_ENABLED) > 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.STATISTICS_CHART_ENABLED, paramBoolean.booleanValue() ? 1.0D : 0.0D))).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */ 
/*      */     
/*      */     LabelToggleButton labelToggleButton1;
/*      */     
/* 1049 */     (labelToggleButton1 = new LabelToggleButton(Game.i.localeManager.i18n.get("settings_3d_models"), Game.i.settingsManager.isThreeDeeModelsEnabled(), 30, 40.0F, true, null)).onToggle = (paramBoolean -> {
/*      */         if (Game.i.settingsManager.setThreeDeeModelsEnabled(paramBoolean.booleanValue())) {
/*      */           MainMenuUiScene.i().recreate();
/*      */           
/*      */           MainMenuUiScene.i().rebuildIfNeeded();
/*      */           return;
/*      */         } 
/*      */         paramLabelToggleButton.setEnabled(Game.i.settingsManager.isThreeDeeModelsEnabled());
/*      */       });
/* 1058 */     (cell1 = table1.add((Actor)labelToggleButton1).padLeft(64.0F).width(616.0F).height(64.0F)).row();
/*      */     
/*      */     LabelToggleButton labelToggleButton2;
/*      */     
/* 1062 */     (labelToggleButton2 = new LabelToggleButton(Game.i.localeManager.i18n.get("settings_loot_icons"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.LOOT_ICONS_ENABLED) != 0.0D), 30, 40.0F, true, null)).onToggle = (paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.LOOT_ICONS_ENABLED, paramBoolean.booleanValue() ? 1.0D : 0.0D));
/* 1063 */     table1.add((Actor)labelToggleButton2).padLeft(64.0F).width(616.0F).height(64.0F);
/* 1064 */     i = 0;
/*      */     
/* 1066 */     if (HotKeyHintLabel.isAvailable()) {
/*      */       LabelToggleButton labelToggleButton;
/*      */       
/* 1069 */       (labelToggleButton = new LabelToggleButton(Game.i.localeManager.i18n.get("settings_hot_key_hints"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.UI_HOT_KEY_HINTS) != 0.0D), 30, 40.0F, true, null)).onToggle = (paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.UI_HOT_KEY_HINTS, paramBoolean.booleanValue() ? 1.0D : 0.0D));
/* 1070 */       cell1 = table1.add((Actor)labelToggleButton).padLeft(64.0F).width(616.0F).height(64.0F);
/* 1071 */       i = 1;
/* 1072 */       cell1.row();
/*      */     } 
/*      */     
/* 1075 */     if (Game.i.actionResolver.rewardAdsAvailable()) {
/*      */       LabelToggleButton labelToggleButton;
/*      */       
/* 1078 */       (labelToggleButton = new LabelToggleButton()).setup(Game.i.localeManager.i18n.get("settings_pause_ads_icon"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.ENABLE_PAUSE_AD_ICON) != 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.ENABLE_PAUSE_AD_ICON, paramBoolean.booleanValue() ? 1.0D : 0.0D));
/* 1079 */       cell1 = table1.add((Actor)labelToggleButton).padLeft(64.0F).width(616.0F).height(64.0F);
/* 1080 */       if ((i = (i == 0) ? 1 : 0) != 0) cell1.row();
/*      */     
/*      */     } 
/*      */     
/*      */     LabelToggleButton labelToggleButton3;
/* 1085 */     (labelToggleButton3 = new LabelToggleButton(Game.i.localeManager.i18n.get("settings_damage_particles"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DAMAGE_PARTICLES_ENABLED) != 0.0D), 30, 40.0F, true, null)).onToggle = (paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.DAMAGE_PARTICLES_ENABLED, paramBoolean.booleanValue() ? 1.0D : 0.0D));
/* 1086 */     cell1 = table1.add((Actor)labelToggleButton3).padLeft(64.0F).width(616.0F).height(64.0F);
/* 1087 */     if ((i = (i == 0) ? 1 : 0) != 0) cell1.row();
/*      */     
/*      */     LabelToggleButton labelToggleButton4;
/* 1090 */     (labelToggleButton4 = new LabelToggleButton(Game.i.localeManager.i18n.get("settings_damage_particles_more"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DAMAGE_PARTICLES_MORE) != 0.0D), 30, 40.0F, true, null)).onToggle = (paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.DAMAGE_PARTICLES_MORE, paramBoolean.booleanValue() ? 1.0D : 0.0D));
/* 1091 */     cell1 = table1.add((Actor)labelToggleButton4).padLeft(64.0F).width(616.0F).height(64.0F);
/* 1092 */     if ((i = (i == 0) ? 1 : 0) != 0) cell1.row();
/*      */ 
/*      */     
/*      */     LabelToggleButton labelToggleButton5;
/* 1096 */     (labelToggleButton5 = new LabelToggleButton(Game.i.localeManager.i18n.get("settings_music_spectrum"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MUSIC_SPECTRUM_ENABLED) != 0.0D), 30, 40.0F, true, null)).onToggle = (paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.MUSIC_SPECTRUM_ENABLED, paramBoolean.booleanValue() ? 1.0D : 0.0D));
/* 1097 */     cell1 = table1.add((Actor)labelToggleButton5).padLeft(64.0F).width(616.0F).height(64.0F);
/* 1098 */     if ((i = (i == 0) ? 1 : 0) != 0) cell1.row();
/*      */ 
/*      */     
/*      */     Group group2;
/* 1102 */     (group2 = new Group()).setTransform(false);
/*      */     
/*      */     Label label8;
/* 1105 */     (label8 = new Label(Game.i.localeManager.i18n.get("settings_ui_safe_zone"), Game.i.assetManager.getLabelStyle(30))).setSize(100.0F, 64.0F);
/* 1106 */     label8.setPosition(0.0F, 64.0F);
/* 1107 */     group2.addActor((Actor)label8);
/*      */     
/*      */     Label label9;
/* 1110 */     (label9 = new Label("", Game.i.assetManager.getLabelStyle(24))).setPosition(420.0F, 0.0F);
/* 1111 */     label9.setSize(180.0F, 64.0F);
/* 1112 */     group2.addActor((Actor)label9);
/*      */     
/* 1114 */     int j = initConfigManager.get(SettingsManager.InitConfig.GRAPHICS_SAFE_AREA);
/* 1115 */     this.p = new HorizontalSlider(400.0F, j, 0.0D, 160.0D, paramDouble -> {
/*      */           int i = MathUtils.round(paramDouble.floatValue());
/*      */           
/*      */           paramInitConfigManager.set(SettingsManager.InitConfig.GRAPHICS_SAFE_AREA, i);
/*      */           
/*      */           this.e.getTable().setTouchable(Touchable.disabled);
/*      */           
/*      */           this.e.getTable().clear();
/*      */           
/*      */           Image image1;
/*      */           
/*      */           (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(MaterialColor.LIGHT_BLUE.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F));
/*      */           
/*      */           this.e.getTable().add((Actor)image1).expandY().fillY().width(i);
/*      */           this.e.getTable().add().fill().expand();
/*      */           Image image2;
/*      */           (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(MaterialColor.LIGHT_BLUE.P500.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F));
/*      */           this.e.getTable().add((Actor)image2).expandY().fillY().width(i);
/*      */           image1.addAction((Action)Actions.sequence((Action)Actions.delay(0.2F), (Action)Actions.fadeOut(1.0F)));
/*      */           image2.addAction((Action)Actions.sequence((Action)Actions.delay(0.2F), (Action)Actions.fadeOut(1.0F)));
/*      */           if (i == 0) {
/*      */             paramLabel.setText(Game.i.localeManager.i18n.get("settings_label_full_screen"));
/*      */             return;
/*      */           } 
/*      */           paramLabel.setText(i + "px");
/*      */         });
/* 1141 */     this.p.setNotifyOnDrag(true);
/* 1142 */     this.p.setSize(400.0F, 64.0F);
/* 1143 */     this.p.setValue(j, true);
/* 1144 */     group2.addActor((Actor)this.p);
/*      */     
/* 1146 */     table1.row();
/* 1147 */     table1.add((Actor)group2).padLeft(64.0F).width(616.0F).height(128.0F);
/*      */ 
/*      */ 
/*      */     
/* 1151 */     (group2 = new Group()).setTransform(false);
/*      */     
/*      */     Label label6;
/* 1154 */     (label6 = new Label(Game.i.localeManager.i18n.get("settings_ui_scale"), Game.i.assetManager.getLabelStyle(30))).setSize(100.0F, 64.0F);
/* 1155 */     label6.setPosition(0.0F, 64.0F);
/* 1156 */     group2.addActor((Actor)label6);
/*      */     
/*      */     Label label1;
/* 1159 */     (label1 = new Label("", Game.i.assetManager.getLabelStyle(24))).setPosition(420.0F, 0.0F);
/* 1160 */     label1.setSize(180.0F, 64.0F);
/* 1161 */     group2.addActor((Actor)label1);
/*      */     
/* 1163 */     double d = Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.UI_SCALE);
/* 1164 */     this.q = new HorizontalSlider(400.0F, d, 0.7D, 1.0D, paramDouble -> {
/*      */           double d = paramDouble.doubleValue();
/*      */           
/*      */           a.i("setting custom value UI_SCALE " + d, new Object[0]);
/*      */           Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.UI_SCALE, d);
/*      */           paramLabel.setText(MathUtils.round((float)(d * 100.0D)) + "%");
/*      */         });
/* 1171 */     this.q.setNotifyOnDrag(true);
/* 1172 */     this.q.setSize(400.0F, 64.0F);
/* 1173 */     this.q.setValue(d, false);
/* 1174 */     label1.setText(MathUtils.round((float)(d * 100.0D)) + "%");
/* 1175 */     group2.addActor((Actor)this.q);
/*      */     
/* 1177 */     table1.add((Actor)group2).padLeft(64.0F).width(616.0F).height(128.0F);
/* 1178 */     table1.row();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1184 */     (table1 = a(Game.i.localeManager.i18n.get("settings_experimental"), "icon-exclamation-triangle")).add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_multithreaded_rendering"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.MULTITHREADING) != 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.MULTITHREADING, paramBoolean.booleanValue() ? 1.0D : 0.0D))).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */ 
/*      */     
/* 1187 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_postprocessing"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.POSTPROCESSING) != 0.0D), 30, 40.0F, true, paramBoolean -> {
/*      */             Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.POSTPROCESSING, paramBoolean.booleanValue() ? 1.0D : 0.0D);
/*      */             Game.i.screenManager.goToSettingsScreenAndScroll(this.j.getScrollY());
/* 1190 */           })).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */     
/* 1192 */     table1.row();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1201 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.POSTPROCESSING) != 0.0D) {
/* 1202 */       String str = Game.i.localeManager.i18n.get("settings_postprocessing");
/* 1203 */       str = str + " [#FF9900](";
/* 1204 */       str = str + Game.i.localeManager.i18n.get("settings_experimental");
/* 1205 */       str = str + ")[]";
/* 1206 */       table1 = a(str, "icon-easel");
/*      */ 
/*      */       
/* 1209 */       Table table7 = new Table();
/* 1210 */       table1.add((Actor)table7).padLeft(64.0F).padTop(32.0F).padBottom(24.0F).size(616.0F, 48.0F);
/*      */       
/* 1212 */       Label label11 = new Label(Game.i.localeManager.i18n.get("settings_pp_graphics_scale"), Game.i.assetManager.getLabelStyle(30));
/* 1213 */       table7.add((Actor)label11).padBottom(16.0F).top().left().row();
/*      */       
/* 1215 */       Label label12 = new Label(StrictMath.round(Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PP_GRAPHICS_SCALE) * 100.0D) + "%", Game.i.assetManager.getLabelStyle(24));
/*      */ 
/*      */ 
/*      */       
/*      */       HorizontalSlider horizontalSlider1;
/*      */ 
/*      */       
/* 1222 */       (horizontalSlider1 = new HorizontalSlider(400.0F, Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PP_GRAPHICS_SCALE), 0.5D, 1.0D, paramDouble -> { double d = Math.round(paramDouble.doubleValue() * 20.0D) / 20.0D; Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.PP_GRAPHICS_SCALE, d); paramLabel.setText(StrictMath.round(d * 100.0D) + "%"); })).setNotifyOnDrag(true);
/* 1223 */       table7.add((Actor)horizontalSlider1).size(400.0F, 48.0F);
/* 1224 */       table7.add((Actor)label12).padLeft(16.0F);
/* 1225 */       table7.add().height(1.0F).expandX().fillX();
/*      */ 
/*      */       
/* 1228 */       table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_pp_clean_detailed_mode"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PP_CLEAN_DETAILED_MODE) != 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.PP_CLEAN_DETAILED_MODE, paramBoolean.booleanValue() ? 1.0D : 0.0D))).padLeft(64.0F).width(616.0F).height(64.0F).row();
/*      */       
/* 1230 */       table1.row();
/*      */ 
/*      */       
/* 1233 */       Table table6 = new Table();
/* 1234 */       table1.add((Actor)table6).padLeft(64.0F).padTop(32.0F).padBottom(24.0F).size(616.0F, 48.0F);
/*      */       
/* 1236 */       label11 = new Label(Game.i.localeManager.i18n.get("settings_pp_effects_scale"), Game.i.assetManager.getLabelStyle(30));
/* 1237 */       table6.add((Actor)label11).padBottom(16.0F).top().left().row();
/*      */       
/* 1239 */       Label label10 = new Label(StrictMath.round(Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PP_EFFECTS_SCALE) * 100.0D) + "%", Game.i.assetManager.getLabelStyle(24));
/*      */ 
/*      */ 
/*      */       
/*      */       HorizontalSlider horizontalSlider2;
/*      */ 
/*      */       
/* 1246 */       (horizontalSlider2 = new HorizontalSlider(400.0F, Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.PP_EFFECTS_SCALE), 0.5D, 1.0D, paramDouble -> { double d = Math.round(paramDouble.doubleValue() * 20.0D) / 20.0D; Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.PP_EFFECTS_SCALE, d); paramLabel.setText(StrictMath.round(d * 100.0D) + "%"); })).setNotifyOnDrag(true);
/* 1247 */       table6.add((Actor)horizontalSlider2).size(400.0F, 48.0F);
/* 1248 */       table6.add((Actor)label10).padLeft(16.0F);
/* 1249 */       table6.add().height(1.0F).expandX().fillX();
/*      */       
/* 1251 */       table1.row();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1258 */     (table1 = a(Game.i.localeManager.i18n.get("settings_development"), "icon-tools")).add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_debug_mode"), Game.i.settingsManager.isInDebugMode(), 30, 40.0F, true, paramBoolean -> {
/*      */             Game.i.settingsManager.setDebugMode(paramBoolean.booleanValue());
/*      */ 
/*      */ 
/*      */             
/*      */             this.h++;
/*      */ 
/*      */             
/*      */             if (this.h <= 3) {
/*      */               Game.i.soundManager.playRarity(RarityType.COMMON);
/*      */             } else if (this.h == 4) {
/*      */               Game.i.soundManager.playRarity(RarityType.RARE);
/*      */             } else if (this.h == 5) {
/*      */               Game.i.soundManager.playRarity(RarityType.VERY_RARE);
/*      */             } else if (this.h == 6) {
/*      */               Game.i.soundManager.playRarity(RarityType.EPIC);
/*      */             } else if (this.h == 7) {
/*      */               Game.i.soundManager.playRarity(RarityType.LEGENDARY);
/*      */             } 
/*      */ 
/*      */             
/*      */             if (this.h == 8) {
/*      */               Game.i.screenManager.startNewBasicLevel(Game.i.basicLevelManager.getLevel("zecred"), null);
/*      */             }
/* 1282 */           })).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */ 
/*      */     
/* 1285 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_debug_detailed_mode"), Game.i.settingsManager.isInDebugDetailedMode(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setDebugDetailedMode(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F).row();
/*      */ 
/*      */     
/* 1288 */     table1.add((Actor)new LabelToggleButton("FPS", (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_SHOW_FPS) != 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.DBG_SHOW_FPS, (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_SHOW_FPS) == 0.0D) ? 1.0D : 0.0D))).padLeft(64.0F).width(616.0F).height(64.0F);
/*      */ 
/*      */     
/* 1291 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_toggle_desync_check"), (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_SYNC_VALIDATION) != 0.0D), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.DBG_SYNC_VALIDATION, (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_SYNC_VALIDATION) == 0.0D) ? 1.0D : 0.0D))).padLeft(64.0F).width(616.0F).height(64.0F).row();
/*      */ 
/*      */     
/* 1294 */     table1.add((Actor)new LabelToggleButton(Game.i.localeManager.i18n.get("settings_debug_bug_reports"), Game.i.settingsManager.isBugReportsEnabled(), 30, 40.0F, true, paramBoolean -> Game.i.settingsManager.setBugReportsEnabled(paramBoolean.booleanValue()))).padLeft(64.0F).width(616.0F).height(64.0F);
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
/* 1425 */     table1.add((Actor)new LabelButton(Game.i.localeManager.i18n.get("settings_button_send_logs"), Game.i.assetManager.getLabelStyle(30), () -> Game.i.uiManager.getTextInput(new Input.TextInputListener(this)
/*      */             {
/*      */               public void input(String param1String) {
/* 1428 */                 Threads.i().runOnMainThread(() -> {
/*      */                       FastRandom.random.setSeed((new Random()).nextLong());
/*      */                       String str = FastRandom.getDistinguishableString(6, FastRandom.random);
/*      */                       CrashHandler.report("Manual " + str + ": " + ((param1String.length() > 256) ? param1String.substring(0, 256) : param1String));
/*      */                       Gdx.app.getClipboard().setContents(str);
/*      */                       Notifications.i().add("Logs sent, ID: [#FFFF00]" + str + "[] (copied to clipboard)", null, null, null);
/*      */                     });
/*      */               }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public void canceled() {}
/* 1445 */             }Game.i.localeManager.i18n.get("settings_send_logs_dialog_question"), "", Game.i.localeManager.i18n.get("settings_send_logs_field_placeholder")))).padLeft(64.0F).height(64.0F).width(616.0F).row();
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
/* 1520 */     this.g.add().height(144.0F).fillX().expandX().row();
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
/* 1541 */     table1.row();
/*      */ 
/*      */     
/* 1544 */     (label1 = new Label("", Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 1545 */     table1.add((Actor)label1).padLeft(64.0F).fillX().padTop(16.0F).row();
/*      */     try {
/*      */       Array array;
/* 1548 */       if ((array = FileIntegrityChecker.runTheTest()).size == 0) {
/* 1549 */         label1.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 1550 */         label1.setText("File integrity check passed!");
/*      */       } else {
/*      */         StringBuilder stringBuilder;
/* 1553 */         (stringBuilder = new StringBuilder()).append("File integrity check failed with ").append(String.valueOf(array.size)).append(" error(s):");
/* 1554 */         for (j = 0; j < array.size; j++) {
/* 1555 */           stringBuilder.append("- ").append((String)array.get(j)).append("\n");
/*      */         }
/* 1557 */         label1.setColor(MaterialColor.ORANGE.P500);
/* 1558 */         label1.setText((CharSequence)stringBuilder);
/*      */       } 
/* 1560 */     } catch (Exception exception) {
/* 1561 */       a.e("File integrity check failed", new Object[] { exception });
/* 1562 */       label1.setColor(Color.RED);
/* 1563 */       label1.setText("File integrity check failed: " + exception.getMessage());
/*      */     } 
/*      */     
/* 1566 */     if (paramFloat != 0.0F) {
/* 1567 */       a.i("scrolling to " + paramFloat, new Object[0]);
/* 1568 */       this.c.getTable().invalidate();
/* 1569 */       this.c.getTable().layout();
/*      */       
/* 1571 */       this.j.setScrollY(paramFloat);
/* 1572 */       this.j.updateVisualScroll();
/*      */     } 
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
/*      */ 
/*      */   
/*      */   public void show() {
/* 1668 */     super.show();
/* 1669 */     Game.i.uiManager.stage.setScrollFocus((Actor)this.j);
/*      */   }
/*      */   
/*      */   private Table a(String paramString1, String paramString2) {
/* 1673 */     Table table2 = new Table();
/* 1674 */     this.g.add((Actor)table2).fillX().expandX().row();
/*      */     
/* 1676 */     if (this.i % 2 == 0) {
/* 1677 */       QuadActor quadActor = new QuadActor(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 0.0F }, new Color(0.0F, 0.0F, 0.0F, 0.28F));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1683 */       table2.add((Actor)quadActor).expandX().fillX().height(24.0F).padTop(8.0F).row();
/*      */     } 
/*      */     
/* 1686 */     Table table3 = new Table();
/* 1687 */     if (this.i % 2 == 0) {
/* 1688 */       table3.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.28F)));
/*      */     }
/* 1690 */     table2.add((Actor)table3).expandX().fillX().row();
/*      */     
/* 1692 */     Table table4 = new Table();
/* 1693 */     table3.add((Actor)table4).width(1360.0F).padTop(32.0F).row();
/*      */     
/* 1695 */     Image image = new Image((Drawable)Game.i.assetManager.getDrawable(paramString2));
/* 1696 */     table4.add((Actor)image).padRight(16.0F).size(48.0F).left();
/*      */     
/* 1698 */     Label label = new Label(paramString1, Game.i.assetManager.getLabelStyle(36));
/* 1699 */     table4.add((Actor)label).expandX().fillX();
/*      */     
/* 1701 */     Table table1 = new Table();
/* 1702 */     table3.add((Actor)table1).padBottom(16.0F).padTop(16.0F).width(1360.0F).row();
/*      */     
/* 1704 */     if (this.i % 2 == 0) {
/* 1705 */       QuadActor quadActor = new QuadActor(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F }, new Color(0.0F, 0.0F, 0.0F, 0.28F));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1711 */       table2.add((Actor)quadActor).expandX().fillX().height(24.0F).padBottom(8.0F).row();
/*      */     } 
/*      */     
/* 1714 */     this.i++;
/*      */     
/* 1716 */     return table1;
/*      */   }
/*      */   
/*      */   private static void a(String paramString) {
/* 1720 */     Game.i.localeManager.setLocale(paramString, true);
/*      */ 
/*      */     
/* 1723 */     Game.i.screenManager.goToSettingsScreen();
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(float paramFloat) {
/* 1728 */     Color color = Game.i.assetManager.getColor("menu_background");
/* 1729 */     Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
/* 1730 */     Gdx.gl.glClear(16640);
/*      */     
/* 1732 */     if (Game.i.settingsManager.isEscButtonJustPressed()) {
/*      */       
/* 1734 */       Game.i.screenManager.goToMainMenu();
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void dispose() {
/* 1741 */     Game.i.uiManager.removeLayer(this.c);
/* 1742 */     Game.i.uiManager.removeLayer(this.d);
/* 1743 */     Game.i.uiManager.removeLayer(this.e);
/*      */   }
/*      */ 
/*      */   
/*      */   public static class LocaleButton
/*      */   {
/*      */     private Image c;
/*      */     public Label label;
/*      */     boolean a;
/*      */     private boolean d;
/*      */     Table b;
/*      */     private Runnable e;
/*      */     
/*      */     public LocaleButton(String param1String, Runnable param1Runnable) {
/* 1757 */       Preconditions.checkNotNull(param1Runnable);
/* 1758 */       this.e = param1Runnable;
/*      */       
/* 1760 */       this.b = new Table();
/* 1761 */       this.c = new Image((Drawable)Game.i.assetManager.getDrawable("icon-check"));
/* 1762 */       this.c.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 1763 */       this.label = new Label(param1String, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/* 1764 */       this.label.setColor(MaterialColor.LIGHT_BLUE.P300);
/*      */       
/* 1766 */       this.b.add((Actor)this.c).padRight(16.0F).size(48.0F, 48.0F);
/* 1767 */       this.b.add((Actor)this.label).expandX().fillX();
/*      */       
/* 1769 */       this.b.setTouchable(Touchable.enabled);
/* 1770 */       this.b.addListener((EventListener)new ClickListener(this) {
/*      */             public void clicked(InputEvent param2InputEvent, float param2Float1, float param2Float2) {
/* 1772 */               this.a.onClick();
/*      */             }
/*      */           });
/*      */ 
/*      */       
/* 1777 */       this.b.addListener((EventListener)new InputListener(this) {
/*      */             public void enter(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, Actor param2Actor) {
/* 1779 */               this.a.a = true;
/* 1780 */               SettingsScreen.LocaleButton.a(this.a);
/*      */             }
/*      */             
/*      */             public void exit(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, Actor param2Actor) {
/* 1784 */               this.a.a = false;
/* 1785 */               SettingsScreen.LocaleButton.a(this.a);
/*      */             }
/*      */           });
/*      */       
/* 1789 */       setSelected(false);
/*      */     }
/*      */     
/*      */     private void a() {
/* 1793 */       if (this.d) {
/* 1794 */         this.label.setColor(MaterialColor.LIGHT_GREEN.P300); return;
/*      */       } 
/* 1796 */       if (this.a) {
/* 1797 */         this.label.setColor(Color.WHITE); return;
/*      */       } 
/* 1799 */       this.label.setColor(MaterialColor.LIGHT_BLUE.P300);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setSelected(boolean param1Boolean) {
/* 1805 */       this.d = param1Boolean;
/* 1806 */       if (param1Boolean) {
/* 1807 */         this.c.setVisible(true);
/*      */       } else {
/* 1809 */         this.c.setVisible(false);
/*      */       } 
/* 1811 */       a();
/*      */     }
/*      */     
/*      */     public void onClick() {
/* 1815 */       this.e.run();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\screens\SettingsScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */