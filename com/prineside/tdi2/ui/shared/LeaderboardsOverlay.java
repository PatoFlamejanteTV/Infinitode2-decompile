/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.LeaderBoardManager;
/*     */ import com.prineside.tdi2.managers.ReplayManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.ScrollPane;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.TextureRegionConfig;
/*     */ import com.prineside.tdi2.utils.UiUtils;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public final class LeaderboardsOverlay extends UiManager.UiComponent.Adapter {
/*     */   public static LeaderboardsOverlay i() {
/*  43 */     return (LeaderboardsOverlay)Game.i.uiManager.getComponent(LeaderboardsOverlay.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  48 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 161, "LeaderboardsOverlay main");
/*     */   
/*     */   private Group b;
/*     */   
/*     */   private Group c;
/*     */   
/*     */   private Image d;
/*     */   
/*     */   private Label e;
/*     */   private ComplexButton f;
/*     */   private ScrollPane g;
/*     */   private Table h;
/*     */   private Label i;
/*     */   private Label j;
/*     */   private Label k;
/*     */   private Label l;
/*     */   private Image m;
/*     */   private Label n;
/*     */   private BasicLevel o;
/*     */   private ReplayManager.LeaderboardsMode p;
/*  68 */   private static final StringBuilder q = new StringBuilder();
/*     */ 
/*     */   
/*     */   public LeaderboardsOverlay() {
/*     */     Group group;
/*  73 */     (group = new Group()).setTransform(false);
/*  74 */     this.a.getTable().add((Actor)group).size(710.0F, 959.0F);
/*     */     
/*  76 */     this.b = new Group();
/*  77 */     this.b.setTransform(false);
/*  78 */     this.b.setSize(710.0F, 959.0F);
/*  79 */     this.b.setOrigin(355.0F, 479.5F);
/*  80 */     group.addActor((Actor)this.b);
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor;
/*     */ 
/*     */ 
/*     */     
/*  88 */     (quadActor = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.21F), new float[] { 0.0F, 0.0F, 0.0F, 920.0F, 692.0F, 950.0F, 700.0F, 27.0F })).setSize(700.0F, 950.0F);
/*  89 */     quadActor.setPosition(25.0F, -19.0F);
/*  90 */     this.b.addActor((Actor)quadActor);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     (quadActor = new QuadActor(new Color(791621631), new float[] { 0.0F, 0.0F, 0.0F, 958.0F, 710.0F, 946.0F, 710.0F, 21.0F })).setSize(710.0F, 958.0F);
/*  99 */     this.b.addActor((Actor)quadActor);
/*     */     
/* 101 */     this.d = new Image((Drawable)Game.i.assetManager.getDrawable("icon-crown"));
/* 102 */     this.d.setSize(64.0F, 64.0F);
/* 103 */     this.d.setPosition(40.0F, 863.0F);
/* 104 */     this.b.addActor((Actor)this.d);
/*     */     
/* 106 */     this.n = new Label("", Game.i.assetManager.getLabelStyle(30));
/* 107 */     this.n.setSize(100.0F, 40.0F);
/* 108 */     this.n.setPosition(128.0F, 887.0F);
/* 109 */     this.b.addActor((Actor)this.n);
/*     */     
/* 111 */     this.e = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 112 */     this.e.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 113 */     this.e.setSize(100.0F, 24.0F);
/* 114 */     this.e.setPosition(128.0F, 863.0F);
/* 115 */     this.b.addActor((Actor)this.e);
/*     */     
/* 117 */     this.f = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> show(this.o, (this.p == ReplayManager.LeaderboardsMode.score) ? ReplayManager.LeaderboardsMode.waves : ReplayManager.LeaderboardsMode.score));
/* 118 */     this.f.setPosition(533.0F, 844.0F);
/* 119 */     this.f.setSize(194.0F, 82.0F);
/* 120 */     this.f.setLabel(76.0F, 21.0F, 100.0F, 48.0F, 8);
/* 121 */     this.f.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-crown"), 21.0F, 20.0F, 48.0F, 48.0F);
/* 122 */     this.f.setBackground((Drawable)Game.i.assetManager.getDrawable("ui-leaderboard-switch-button"), 0.0F, 0.0F, 194.0F, 82.0F);
/* 123 */     this.b.addActor((Actor)this.f);
/*     */     
/*     */     Image image;
/* 126 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(724249599));
/* 127 */     image.setSize(710.0F, 662.0F);
/* 128 */     image.setPosition(0.0F, 173.0F);
/* 129 */     this.b.addActor((Actor)image);
/*     */     
/* 131 */     this.h = new Table();
/* 132 */     this.g = new ScrollPane((Actor)this.h);
/* 133 */     UiUtils.enableMouseMoveScrollFocus(this.g);
/* 134 */     this.g.setScrollingDisabled(true, false);
/* 135 */     this.g.setSize(710.0F, 662.0F);
/* 136 */     this.g.setPosition(0.0F, 173.0F);
/* 137 */     this.b.addActor((Actor)this.g);
/*     */ 
/*     */     
/* 140 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 141 */     image.setSize(710.0F, 10.0F);
/* 142 */     image.setPosition(0.0F, 825.0F);
/* 143 */     image.setTouchable(Touchable.disabled);
/* 144 */     this.b.addActor((Actor)image);
/*     */ 
/*     */     
/* 147 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 148 */     image.setSize(710.0F, 10.0F);
/* 149 */     image.setPosition(0.0F, 173.0F);
/* 150 */     image.setTouchable(Touchable.disabled);
/* 151 */     this.b.addActor((Actor)image);
/*     */     
/* 153 */     this.m = new Image((Drawable)Game.i.assetManager.getDrawable("loading-icon"));
/* 154 */     this.m.setSize(64.0F, 64.0F);
/* 155 */     this.m.setPosition(323.0F, 726.0F);
/* 156 */     this.m.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 157 */     this.m.setOrigin(1);
/* 158 */     this.m.addAction((Action)Actions.forever((Action)Actions.rotateBy(90.0F, 1.0F)));
/* 159 */     this.b.addActor((Actor)this.m);
/*     */     
/* 161 */     this.c = new Group();
/* 162 */     this.c.setTransform(false);
/* 163 */     this.c.setSize(710.0F, 173.0F);
/* 164 */     this.b.addActor((Actor)this.c);
/*     */     
/* 166 */     this.l = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 167 */     this.l.setPosition(40.0F, 108.0F);
/* 168 */     this.l.setSize(100.0F, 64.0F);
/* 169 */     this.l.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 170 */     this.c.addActor((Actor)this.l);
/*     */ 
/*     */     
/* 173 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setPosition(0.0F, 44.0F);
/* 174 */     image.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 175 */     image.setSize(710.0F, 64.0F);
/* 176 */     this.c.addActor((Actor)image);
/*     */     
/* 178 */     this.i = new Label("1", Game.i.assetManager.getLabelStyle(24));
/* 179 */     this.i.setPosition(0.0F, 44.0F);
/* 180 */     this.i.setSize(128.0F, 64.0F);
/* 181 */     this.i.setAlignment(1);
/* 182 */     this.i.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 183 */     this.c.addActor((Actor)this.i);
/*     */     
/* 185 */     this.j = new Label("", Game.i.assetManager.getLabelStyle(30));
/* 186 */     this.j.setPosition(128.0F, 44.0F);
/* 187 */     this.j.setSize(100.0F, 64.0F);
/* 188 */     this.c.addActor((Actor)this.j);
/*     */     
/* 190 */     this.k = new Label("1,000", Game.i.assetManager.getLabelStyle(24));
/* 191 */     this.k.setPosition(570.0F, 44.0F);
/* 192 */     this.k.setAlignment(16);
/* 193 */     this.k.setSize(100.0F, 64.0F);
/* 194 */     this.c.addActor((Actor)this.k);
/*     */     
/* 196 */     this.a.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   public final void show(BasicLevel paramBasicLevel, ReplayManager.LeaderboardsMode paramLeaderboardsMode) {
/* 200 */     if (DifficultyMode.isEndless(Game.i.progressManager.getDifficultyMode()) && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.ENDLESS_LEADERBOARD_HINT_SHOWN) == 0.0D) {
/* 201 */       String str = StringFormatter.timePassed(MathUtils.round(2700.0F), false, false);
/* 202 */       str = Game.i.localeManager.i18n.format("endless_leaderboard_description", new Object[] { str });
/* 203 */       Dialog.i().showAlert(str);
/* 204 */       Dialog.i().makeConfirmButtonDisabled(2);
/* 205 */       Game.i.settingsManager.setCustomValue(SettingsManager.CustomValueType.ENDLESS_LEADERBOARD_HINT_SHOWN, 1.0D);
/*     */     } 
/*     */     
/* 208 */     Game.i.settingsManager.isUiAnimationsEnabled();
/*     */     
/* 210 */     this.n.setText(Game.i.localeManager.i18n.get("leaderboard"));
/*     */     
/* 212 */     this.o = paramBasicLevel;
/* 213 */     this.p = paramLeaderboardsMode;
/*     */     
/* 215 */     DarkOverlay.i().addCallerOverlayLayer("LeaderboardsOverlay", this.a.zIndex - 1, () -> {
/*     */           hide();
/*     */           return true;
/*     */         });
/* 219 */     UiUtils.bouncyShowOverlay(null, (Actor)this.a.getTable(), this.b);
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
/* 234 */     DifficultyMode difficultyMode = Game.i.progressManager.getDifficultyMode();
/* 235 */     if (paramBasicLevel.forcedDifficulty != null) {
/* 236 */       difficultyMode = paramBasicLevel.forcedDifficulty;
/*     */     }
/*     */     
/* 239 */     if (paramLeaderboardsMode == ReplayManager.LeaderboardsMode.score) {
/* 240 */       this.d.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-crown"));
/* 241 */       this.e.setText(paramBasicLevel.name + " - " + Game.i.localeManager.i18n.get("score") + " - " + Game.i.progressManager.getDifficultyName(difficultyMode));
/* 242 */       this.f.setText(Game.i.localeManager.i18n.get("score"));
/* 243 */       this.f.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-crown"));
/* 244 */     } else if (paramLeaderboardsMode == ReplayManager.LeaderboardsMode.waves) {
/* 245 */       this.d.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-wave"));
/* 246 */       this.e.setText(paramBasicLevel.name + " - " + Game.i.localeManager.i18n.get("waves") + " - " + Game.i.progressManager.getDifficultyName(difficultyMode));
/* 247 */       this.f.setText(Game.i.localeManager.i18n.get("waves"));
/* 248 */       this.f.setIcon((Drawable)Game.i.assetManager.getDrawable("icon-wave"));
/*     */     } 
/*     */ 
/*     */     
/* 252 */     this.l.setText(Game.i.localeManager.i18n.get("your_rank"));
/* 253 */     this.h.clearChildren();
/* 254 */     this.m.setVisible(true);
/* 255 */     this.c.setVisible(false);
/*     */     
/* 257 */     Game.i.leaderBoardManager.getLeaderboards(GameStateSystem.GameMode.BASIC_LEVELS, difficultyMode, paramBasicLevel.name, paramLeaderboardsMode, paramLeaderboardsResult -> {
/*     */           this.m.setVisible(false);
/*     */           
/*     */           if (paramLeaderboardsResult.success) {
/*     */             this.c.setVisible(true);
/*     */             
/*     */             Drawable drawable = Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.14F));
/*     */             
/*     */             int i;
/*     */             
/*     */             for (i = 0; i < paramLeaderboardsResult.entries.size; i++) {
/*     */               LeaderBoardManager.LeaderboardsEntry leaderboardsEntry = (LeaderBoardManager.LeaderboardsEntry)paramLeaderboardsResult.entries.get(i);
/*     */               
/*     */               Table table1 = new Table();
/*     */               
/*     */               Label label2;
/*     */               
/*     */               (label2 = new Label(String.valueOf(leaderboardsEntry.rank), Game.i.assetManager.getLabelStyle(24))).setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*     */               
/*     */               label2.setAlignment(1);
/*     */               
/*     */               table1.add((Actor)label2).size(79.0F, 64.0F).padLeft(10.0F);
/*     */               
/*     */               Group group;
/*     */               
/*     */               (group = new Group()).setTransform(false);
/*     */               
/*     */               table1.add((Actor)group).size(64.0F);
/*     */               
/*     */               Image image2;
/*     */               
/*     */               (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(64.0F, 64.0F);
/*     */               
/*     */               image2.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*     */               
/*     */               group.addActor((Actor)image2);
/*     */               Array array = Game.i.authManager.getProfileLevelTextures(leaderboardsEntry.profileLevel);
/*     */               for (byte b = 0; b < array.size; b++) {
/*     */                 group.addActor((Actor)((TextureRegionConfig[])array.items)[b].createImage(8.0F, 8.0F, 48.0F));
/*     */               }
/*     */               Image image3 = new Image();
/*     */               if (leaderboardsEntry.hasProfilePicture) {
/*     */                 image3.setDrawable((Drawable)new TextureRegionDrawable((TextureRegion)Game.i.assetManager.loadWebTexture(Config.AVATAR_WEB_TEXTURES_URL + leaderboardsEntry.playerId.toLowerCase(Locale.US) + "-32.png")));
/*     */               } else {
/*     */                 image3.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-user"));
/*     */                 image3.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/*     */               } 
/*     */               table1.add((Actor)image3).size(40.0F).padLeft(12.0F).padRight(12.0F);
/*     */               (group = new Group()).setTransform(false);
/*     */               table1.add((Actor)group).size(100.0F, 64.0F);
/*     */               Image image1;
/*     */               (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-left"))).setColor(0.0F, 0.0F, 0.0F, 0.14F);
/*     */               image1.setSize(128.0F, 64.0F);
/*     */               group.addActor((Actor)image1);
/*     */               Table table2;
/*     */               (table2 = new Table()).setSize(300.0F, 64.0F);
/*     */               group.addActor((Actor)table2);
/*     */               LimitedWidthLabel limitedWidthLabel = new LimitedWidthLabel(leaderboardsEntry.nickname, 30, 24, 240.0F);
/*     */               if (leaderboardsEntry.nickname.equals(Game.i.authManager.getNickname())) {
/*     */                 limitedWidthLabel.setColor(MaterialColor.GREEN.P500);
/*     */               } else if (leaderboardsEntry.rank == 1) {
/*     */                 limitedWidthLabel.setColor(MaterialColor.AMBER.P500);
/*     */               } else if (leaderboardsEntry.rank == 2) {
/*     */                 limitedWidthLabel.setColor(MaterialColor.AMBER.P300);
/*     */               } else if (leaderboardsEntry.rank == 3) {
/*     */                 limitedWidthLabel.setColor(MaterialColor.AMBER.P100);
/*     */               } 
/*     */               limitedWidthLabel.setTouchable(Touchable.enabled);
/*     */               limitedWidthLabel.addListener((EventListener)new ClickListener(this, leaderboardsEntry)
/*     */                   {
/*     */                     public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2)
/*     */                     {
/* 329 */                       (WebBrowser.i()).webView.loadUrl("GET", Config.XDX_VIEW_PLAYER_PROFILE_URL + this.a.playerId, null);
/* 330 */                       WebBrowser.i().setVisible(true);
/* 331 */                       LeaderboardsOverlay.i().hide();
/*     */                     }
/*     */                   });
/*     */               
/*     */               table2.add((Actor)limitedWidthLabel).padLeft(16.0F);
/*     */               
/*     */               table2.add().height(1.0F).expandX().fillX();
/*     */               
/*     */               if (leaderboardsEntry.badgeIconTexture != null) {
/*     */                 AssetManager.WebTextureRegion webTextureRegion;
/*     */                 
/*     */                 Group group1;
/*     */                 
/*     */                 (group1 = new Group()).setTransform(false);
/*     */                 
/*     */                 table2.add((Actor)group1).padLeft(16.0F).size(40.0F);
/*     */                 
/*     */                 ResourcePack.AtlasTextureRegion atlasTextureRegion;
/*     */                 
/*     */                 if ((atlasTextureRegion = Game.i.assetManager.getTextureRegionSetThrowing(leaderboardsEntry.badgeIconTexture, false)) == null) {
/*     */                   webTextureRegion = Game.i.assetManager.loadWebTexture("https://files.prineside.com/static/infinitode_website/optional/" + leaderboardsEntry.badgeIconTexture + ".png");
/*     */                 }
/*     */                 
/*     */                 Image image;
/*     */                 
/*     */                 (image = new Image((Drawable)new TextureRegionDrawable((TextureRegion)webTextureRegion))).setColor((leaderboardsEntry.badgeIconColor == null) ? Color.WHITE : leaderboardsEntry.badgeIconColor);
/*     */                 
/*     */                 image.setSize(40.0F, 40.0F);
/*     */                 
/*     */                 group1.addActor((Actor)image);
/*     */                 
/*     */                 if (leaderboardsEntry.badgeOverlayTexture != null) {
/*     */                   AssetManager.WebTextureRegion webTextureRegion1;
/*     */                   
/*     */                   ResourcePack.AtlasTextureRegion atlasTextureRegion1;
/*     */                   if ((atlasTextureRegion1 = Game.i.assetManager.getTextureRegionSetThrowing(leaderboardsEntry.badgeOverlayTexture, false)) == null) {
/*     */                     webTextureRegion1 = Game.i.assetManager.loadWebTexture("https://files.prineside.com/static/infinitode_website/optional/" + leaderboardsEntry.badgeOverlayTexture + ".png");
/*     */                   }
/*     */                   Image image4;
/*     */                   (image4 = new Image((Drawable)new TextureRegionDrawable((TextureRegion)webTextureRegion1))).setColor((leaderboardsEntry.badgeOverlayColor == null) ? Color.WHITE : leaderboardsEntry.badgeOverlayColor);
/*     */                   image4.setSize(40.0F, 40.0F);
/*     */                   group1.addActor((Actor)image4);
/*     */                 } 
/*     */               } 
/*     */               table1.add().growX().height(1.0F);
/*     */               Label label1;
/*     */               (label1 = new Label((CharSequence)StringFormatter.commaSeparatedNumber(leaderboardsEntry.score), Game.i.assetManager.getLabelStyle(24))).setAlignment(16);
/*     */               table1.add((Actor)label1).size(100.0F, 64.0F).padRight(40.0F);
/*     */               if (i % 2 == 0) {
/*     */                 table1.setBackground(drawable);
/*     */               }
/*     */               this.h.add((Actor)table1).size(710.0F, 64.0F).row();
/*     */             } 
/*     */             if (paramLeaderboardsResult.entries.size * 64.0F < this.g.getHeight()) {
/*     */               this.h.add().size(1.0F, this.g.getHeight() - paramLeaderboardsResult.entries.size * 64.0F).row();
/*     */             }
/*     */             if (Game.i.authManager.isSignedIn() && paramLeaderboardsResult.player != null) {
/*     */               this.j.setText(Game.i.authManager.getNickname());
/*     */               if (paramLeaderboardsResult.player.rank == 0) {
/*     */                 this.i.setText("?");
/*     */                 this.k.setText(Game.i.localeManager.i18n.get("not_ranked"));
/*     */               } else {
/*     */                 this.i.setText(String.valueOf(paramLeaderboardsResult.player.rank));
/*     */                 this.k.setText((CharSequence)StringFormatter.commaSeparatedNumber(paramLeaderboardsResult.player.score));
/*     */                 if (paramLeaderboardsResult.player.rank == 1) {
/*     */                   this.l.setText(Game.i.localeManager.i18n.get("your_rank") + " - " + Game.i.localeManager.i18n.get("leader") + "!");
/*     */                 } else {
/*     */                   i = MathUtils.ceil(paramLeaderboardsResult.player.rank / paramLeaderboardsResult.player.total * 100.0F);
/*     */                   q.setLength(0);
/*     */                   q.append(Game.i.localeManager.i18n.get("your_rank")).append(" - ").append(Game.i.localeManager.i18n.format("top_percent", new Object[] { Integer.valueOf(i) }));
/*     */                   this.l.setText((CharSequence)q);
/*     */                 } 
/*     */               } 
/*     */             } else {
/*     */               this.i.setText("???");
/*     */               this.j.setText(Game.i.localeManager.i18n.get("sign_in_to_get_ranked"));
/*     */               this.k.setText((CharSequence)StringFormatter.commaSeparatedNumber((paramLeaderboardsMode == ReplayManager.LeaderboardsMode.score) ? (ProgressPrefs.i()).basicLevel.getLevelMaxScore(paramBasicLevel.name) : (ProgressPrefs.i()).basicLevel.getLevelMaxReachedWave(paramBasicLevel.name)));
/*     */               return;
/*     */             } 
/*     */           } else {
/*     */             Notifications.i().add(Game.i.localeManager.i18n.get("failed_to_load_leaderboard"), (Drawable)Game.i.assetManager.getDrawable("icon-times"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */           } 
/*     */         });
/* 414 */     Game.i.uiManager.stage.setScrollFocus((Actor)this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 419 */     Game.i.settingsManager.isUiAnimationsEnabled();
/*     */     
/* 421 */     DarkOverlay.i().removeCaller("LeaderboardsOverlay");
/* 422 */     UiUtils.bouncyHideOverlay(null, (Actor)this.a.getTable(), this.b);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\LeaderboardsOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */