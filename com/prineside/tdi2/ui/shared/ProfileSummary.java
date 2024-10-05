/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Cursor;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.AuthManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Auth;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.screens.account.AccountScreen;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LimitedWidthLabel;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.TextureRegionConfig;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public class ProfileSummary extends UiManager.UiComponent.Adapter {
/*  32 */   private static final TLog a = TLog.forClass(ProfileSummary.class);
/*     */   public static ProfileSummary i() {
/*  34 */     return (ProfileSummary)Game.i.uiManager.getComponent(ProfileSummary.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private int b;
/*     */   private int c;
/*  40 */   public final UiManager.UiLayer uiLayer = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 100, "ProfileSummary");
/*     */   
/*     */   private final Group d;
/*     */   
/*     */   public final Image avatar;
/*     */   
/*     */   private final Image e;
/*     */   private final LimitedWidthLabel f;
/*     */   private final Image g;
/*     */   private final Actor h;
/*     */   public final Label hintLabel;
/*     */   private final Label i;
/*     */   private final Group j;
/*     */   private final Image k;
/*     */   private final Group l;
/*     */   private final Image m;
/*     */   private final Group n;
/*     */   private final Image o;
/*     */   private final Label p;
/*     */   private final Image q;
/*     */   private final Label r;
/*     */   private final Table s;
/*     */   private Label t;
/*     */   private AnimationStage u;
/*  64 */   private final Array<AnimationStage> v = new Array(true, 1, AnimationStage.class);
/*     */   
/*  66 */   private static final StringBuilder w = new StringBuilder();
/*     */   
/*     */   private boolean x;
/*     */   private boolean y;
/*     */   private int z;
/*     */   
/*     */   public ProfileSummary() {
/*  73 */     Table table = this.uiLayer.getTable();
/*     */     
/*     */     Group group2;
/*  76 */     (group2 = new Group()).setTransform(false);
/*  77 */     table.add((Actor)group2).expand().top().left().size(226.0F, 100.0F).padTop(44.0F).padLeft(40.0F);
/*     */     
/*  79 */     this.d = new Group();
/*  80 */     this.d.setTransform(false);
/*  81 */     this.d.setSize(226.0F, 100.0F);
/*  82 */     group2.addActor((Actor)this.d);
/*     */     
/*  84 */     this.n = new Group();
/*  85 */     this.n.setTransform(false);
/*  86 */     this.n.setTouchable(Touchable.disabled);
/*  87 */     this.n.setSize(226.0F, 100.0F);
/*  88 */     group2.addActor((Actor)this.n);
/*     */     
/*  90 */     this.avatar = new Image();
/*  91 */     this.avatar.setSize(48.0F, 48.0F);
/*  92 */     this.avatar.setPosition(0.0F, 52.0F);
/*  93 */     this.d.addActor((Actor)this.avatar);
/*     */     
/*  95 */     this.e = new Image((Drawable)Game.i.assetManager.getDrawable("player-profile-avatar-frame"));
/*  96 */     this.e.setSize(54.0F, 54.0F);
/*  97 */     this.e.setPosition(-3.0F, 49.0F);
/*  98 */     this.e.setColor(new Color(269488383));
/*  99 */     this.d.addActor((Actor)this.e);
/*     */ 
/*     */     
/* 102 */     (table = new Table()).setSize(420.0F, 48.0F);
/* 103 */     table.setPosition(64.0F, 52.0F);
/* 104 */     this.d.addActor((Actor)table);
/*     */     
/* 106 */     this.f = new LimitedWidthLabel("", 30, 24, 380.0F);
/* 107 */     table.add((Actor)this.f).maxWidth(380.0F).height(48.0F).padRight(8.0F);
/*     */     
/* 109 */     this.g = new Image((Drawable)Game.i.assetManager.getQuad("icons.cloudSyncWarning"));
/* 110 */     this.g.addAction((Action)Actions.forever(
/* 111 */           (Action)Actions.sequence(
/* 112 */             (Action)Actions.color(MaterialColor.YELLOW.P500, 0.4F), 
/* 113 */             (Action)Actions.color(MaterialColor.AMBER.P800, 0.8F))));
/*     */ 
/*     */     
/* 116 */     this.g.setTouchable(Touchable.enabled);
/* 117 */     this.g.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 120 */             String str = Game.i.localeManager.i18n.get("profile_summary_cloud_sync_warning_auto_saves_off");
/* 121 */             TooltipsOverlay.i().showText("profile_summary_cloud_sync_warning", (Actor)ProfileSummary.a(this.a), str, UiManager.MainUiLayer.SHARED_COMPONENTS, 101, 4);
/*     */           }
/*     */         });
/* 124 */     Game.i.cursorGraphics.setActorCustomMouseCursorConditional((Actor)this.g, () -> Cursor.SystemCursor.Hand);
/* 125 */     this.g.setVisible(false);
/* 126 */     table.add((Actor)this.g).size(48.0F);
/*     */     
/* 128 */     table.add().height(1.0F).growX();
/*     */     
/* 130 */     this.l = new Group();
/* 131 */     this.l.setTransform(false);
/* 132 */     this.l.setSize(226.0F, 48.0F);
/* 133 */     this.l.setTouchable(Touchable.enabled);
/* 134 */     this.l.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 137 */             this.a.toggleXpInfoDropdown();
/*     */           }
/*     */         });
/* 140 */     this.d.addActor((Actor)this.l);
/*     */     
/* 142 */     Game.i.cursorGraphics.setActorCustomMouseCursorConditional((Actor)this.l, () -> Cursor.SystemCursor.Hand);
/*     */     
/* 144 */     this.j = new Group();
/* 145 */     this.j.setTransform(false);
/* 146 */     this.j.setSize(48.0F, 48.0F);
/* 147 */     this.j.setOrigin(24.0F, 24.0F);
/* 148 */     this.l.addActor((Actor)this.j);
/*     */     
/* 150 */     this.i = new Label("", Game.i.assetManager.getLabelStyle(21));
/* 151 */     this.i.setPosition(64.0F, 24.0F);
/* 152 */     this.i.setSize(100.0F, 16.0F);
/* 153 */     this.i.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 154 */     this.l.addActor((Actor)this.i);
/*     */     
/*     */     Group group1;
/* 157 */     (group1 = new Group()).setTransform(false);
/* 158 */     group1.setPosition(64.0F, 10.0F);
/* 159 */     group1.setSize(162.0F, 8.0F);
/* 160 */     this.l.addActor((Actor)group1);
/*     */     
/*     */     Image image;
/* 163 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setSize(162.0F, 8.0F);
/* 164 */     image.setColor(1.0F, 1.0F, 1.0F, 0.21F);
/* 165 */     group1.addActor((Actor)image);
/*     */     
/* 167 */     this.m = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 168 */     group1.addActor((Actor)this.m);
/*     */     
/* 170 */     this.o = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 171 */     this.o.setColor(MaterialColor.AMBER.P500);
/* 172 */     this.o.setSize(0.0F, 8.0F);
/* 173 */     group1.addActor((Actor)this.o);
/*     */     
/* 175 */     this.q = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/* 176 */     this.q.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 177 */     this.q.setSize(0.0F, 8.0F);
/* 178 */     group1.addActor((Actor)this.q);
/*     */     
/* 180 */     this.p = new Label("+0 XP", Game.i.assetManager.getLabelStyle(21));
/* 181 */     this.p.setSize(100.0F, 16.0F);
/* 182 */     this.p.setPosition(242.0F, 11.0F);
/* 183 */     this.p.setColor(MaterialColor.AMBER.P500);
/* 184 */     this.n.addActor((Actor)this.p);
/*     */     
/* 186 */     this.r = new Label("+0 bonus XP", Game.i.assetManager.getLabelStyle(21));
/* 187 */     this.r.setSize(100.0F, 16.0F);
/* 188 */     this.r.setPosition(242.0F, 11.0F);
/* 189 */     this.r.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 190 */     this.n.addActor((Actor)this.r);
/*     */     
/* 192 */     this.k = new Image();
/* 193 */     this.k.setPosition(207.0F, 22.0F);
/* 194 */     this.k.setSize(20.0F, 20.0F);
/* 195 */     this.l.addActor((Actor)this.k);
/*     */     
/* 197 */     this.h = new Actor();
/* 198 */     this.h.setPosition(-40.0F, 48.0F);
/* 199 */     this.h.setSize(266.0F, 92.0F);
/* 200 */     this.h.setTouchable(Touchable.enabled);
/* 201 */     this.h.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 204 */             AccountScreen.goToScreen();
/*     */           }
/*     */         });
/* 207 */     this.d.addActor(this.h);
/* 208 */     Game.i.cursorGraphics.setActorCustomMouseCursorConditional(this.h, () -> Cursor.SystemCursor.Hand);
/*     */     
/* 210 */     this.hintLabel = new Label(Game.i.localeManager.i18n.get("tap_here_to_sign_in"), Game.i.assetManager.getLabelStyle(21));
/* 211 */     this.hintLabel.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/* 212 */     this.hintLabel.setSize(100.0F, 16.0F);
/* 213 */     this.hintLabel.setPosition(64.0F, 40.0F);
/* 214 */     this.d.addActor((Actor)this.hintLabel);
/*     */ 
/*     */     
/* 217 */     this.s = new Table();
/* 218 */     this.s.setPosition(64.0F, -140.0F);
/* 219 */     this.s.setSize(386.0F, 140.0F);
/* 220 */     this.s.setBackground(Game.i.assetManager.getDrawable("blank").tint(new Color(128)));
/* 221 */     this.s.setTouchable(Touchable.enabled);
/* 222 */     this.s.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 225 */             this.a.toggleXpInfoDropdown();
/*     */           }
/*     */         });
/* 228 */     this.d.addActor((Actor)this.s);
/*     */     
/* 230 */     setVisible(false);
/*     */     
/* 232 */     Game.i.authManager.addListener(new AuthManager.AuthManagerListener.AuthManagerListenerAdapter(this)
/*     */         {
/*     */           public void stateUpdated() {
/* 235 */             if (ProfileSummary.b(this.a) && 
/* 236 */               (ProfileSummary.c(this.a)).size == 0 && ProfileSummary.d(this.a) == null)
/*     */             {
/* 238 */               this.a.update();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void toggleXpInfoDropdown() {
/* 246 */     this.s.setVisible(!this.s.isVisible());
/* 247 */     b();
/*     */   }
/*     */   
/*     */   private void b() {
/* 251 */     this.z = Game.getTimestampSeconds();
/*     */     
/* 253 */     if (this.t != null) {
/*     */       int i;
/* 255 */       if ((i = (Game.i.authManager.getSessionData()).nextXpRefreshTimestamp - Game.getTimestampSeconds()) < 0) i = 0;
/*     */       
/* 257 */       this.t.setText(StringFormatter.timePassed(i, true, true));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void update() {
/* 262 */     if (this.y) {
/*     */       
/* 264 */       a.i("skipped update during animation", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 268 */     if (Game.i.authManager.isSignedIn() && !Game.i.authManager.isAutoSavesEnabled()) {
/* 269 */       this.g.setVisible(true);
/*     */     } else {
/* 271 */       this.g.setVisible(false);
/*     */     } 
/*     */     
/* 274 */     this.f.setText(Game.i.authManager.getNickname());
/* 275 */     if (Game.i.authManager.isSignedIn()) {
/* 276 */       this.avatar.setVisible(true);
/* 277 */       this.f.setVisible(true);
/*     */       
/* 279 */       SP_Auth.SessionData sessionData = Game.i.authManager.getSessionData();
/* 280 */       this.b = sessionData.profileLevel;
/* 281 */       this.c = sessionData.currentLevelXp;
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
/* 293 */       this.avatar.setDrawable((Drawable)new TextureRegionDrawable(Game.i.authManager.getAvatar(64)));
/* 294 */       this.e.setVisible(true);
/* 295 */       this.hintLabel.setVisible(false);
/* 296 */       this.l.setVisible(true);
/*     */       
/* 298 */       this.j.clear();
/* 299 */       Array array = Game.i.authManager.getProfileLevelTextures(this.b);
/* 300 */       for (byte b = 0; b < array.size; b++) {
/* 301 */         this.j.addActor((Actor)((TextureRegionConfig[])array.items)[b].createImage(0.0F, 0.0F, 48.0F));
/*     */       }
/*     */       
/* 304 */       this.i.setText(this.c + " / " + sessionData.nextLevelXp + " XP");
/*     */       
/* 306 */       float f = (int)(162.0F * this.c / sessionData.nextLevelXp);
/* 307 */       this.m.setVisible(true);
/* 308 */       this.m.setColor(Color.WHITE);
/* 309 */       this.m.setSize(f, 8.0F);
/*     */       
/* 311 */       if (sessionData.xpStatus == AuthManager.XpStatus.BONUS) {
/* 312 */         this.k.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top"));
/* 313 */         this.k.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 314 */       } else if (sessionData.xpStatus == AuthManager.XpStatus.REDUCED) {
/* 315 */         this.k.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"));
/* 316 */         this.k.setColor(new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*     */       } else {
/* 318 */         this.k.setVisible(false);
/*     */       } 
/*     */ 
/*     */       
/* 322 */       this.s.clearChildren();
/*     */       
/*     */       Label label2;
/* 325 */       (label2 = new Label(Game.i.localeManager.i18n.format("profile_summary_dropdown_bonus_xp_available", new Object[] { Integer.valueOf(sessionData.bonusXpRemaining) }), Game.i.assetManager.getLabelStyle(21))).setAlignment(8);
/* 326 */       this.s.add((Actor)label2).expandX().fillX().padLeft(16.0F).padRight(16.0F).row();
/*     */ 
/*     */       
/* 329 */       (label2 = new Label(Game.i.localeManager.i18n.format("profile_summary_dropdown_regular_xp_available", new Object[] { Integer.valueOf(sessionData.regularXpRemaining) }), Game.i.assetManager.getLabelStyle(21))).setAlignment(8);
/* 330 */       this.s.add((Actor)label2).expandX().fillX().padLeft(16.0F).padRight(16.0F).row();
/*     */       
/* 332 */       if (sessionData.bonusXpRemaining == 0 && sessionData.regularXpRemaining == 0) {
/*     */         
/* 334 */         (label2 = new Label(Game.i.localeManager.i18n.get("profile_summary_dropdown_xp_reduced"), Game.i.assetManager.getLabelStyle(21))).setAlignment(8);
/* 335 */         label2.setColor(new Color(1.0F, 1.0F, 1.0F, 0.56F));
/* 336 */         this.s.add((Actor)label2).expandX().fillX().padLeft(16.0F).padRight(16.0F).row();
/*     */       } 
/* 338 */       if (sessionData.tempXp > 0) {
/*     */         
/* 340 */         (label2 = new Label("", Game.i.assetManager.getLabelStyle(21))).setText(Game.i.localeManager.i18n.format("profile_summary_dropdown_validated_xp", new Object[] { Integer.valueOf(sessionData.tempXp) }));
/* 341 */         label2.setAlignment(8);
/* 342 */         label2.setColor(new Color(1.0F, 1.0F, 1.0F, 0.56F));
/* 343 */         this.s.add((Actor)label2).expandX().fillX().padLeft(16.0F).padRight(16.0F).row();
/*     */       } 
/*     */       
/* 346 */       Table table = new Table();
/* 347 */       Label label1 = new Label(Game.i.localeManager.i18n.get("profile_summary_dropdown_next_refresh") + ":", Game.i.assetManager.getLabelStyle(21));
/* 348 */       table.add((Actor)label1);
/* 349 */       label1.setColor(new Color(1.0F, 1.0F, 1.0F, 0.56F));
/* 350 */       this.t = new Label("1d 00:00:00", Game.i.assetManager.getLabelStyle(21));
/* 351 */       table.add((Actor)this.t).padLeft(8.0F);
/* 352 */       table.add().height(1.0F).expandX().fillX();
/* 353 */       this.s.add((Actor)table).expandX().fillX().padLeft(16.0F).padRight(16.0F);
/*     */       return;
/*     */     } 
/* 356 */     this.avatar.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-user"));
/* 357 */     this.e.setVisible(false);
/* 358 */     this.hintLabel.setVisible(true);
/* 359 */     this.l.setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showXpGained(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 367 */     if (paramInt1 <= 0) {
/* 368 */       a.i("no regular xp, cancel", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 372 */     if (paramBoolean1) {
/* 373 */       this.k.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top"));
/* 374 */       this.k.setColor(MaterialColor.LIGHT_GREEN.P500);
/* 375 */     } else if (!paramBoolean2) {
/* 376 */       this.k.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom"));
/* 377 */       this.k.setColor(new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*     */     } else {
/* 379 */       this.k.setVisible(false);
/*     */     } 
/*     */     
/* 382 */     this.p.setPosition(242.0F, 11.0F);
/*     */     
/* 384 */     this.n.setVisible(true);
/* 385 */     this.p.setVisible(false);
/* 386 */     this.r.setVisible(false);
/*     */     
/* 388 */     this.uiLayer.getTable().setVisible(true);
/* 389 */     this.x = true;
/* 390 */     this.y = true;
/*     */     
/* 392 */     this.d.clearActions();
/* 393 */     this.d.setTransform(true);
/* 394 */     this.d.addAction((Action)Actions.sequence(
/* 395 */           (Action)Actions.scaleTo(0.0F, 0.0F), 
/* 396 */           (Action)Actions.parallel(
/* 397 */             (Action)Actions.sequence(
/* 398 */               (Action)Actions.delay(0.13F), 
/* 399 */               (Action)Actions.scaleBy(1.0F, 0.0F, 0.4F, (Interpolation)Interpolation.swingOut)), 
/*     */             
/* 401 */             (Action)Actions.scaleBy(0.0F, 1.0F, 0.4F, (Interpolation)Interpolation.swingOut)), 
/*     */           
/* 403 */           (Action)Actions.run(() -> {
/*     */               this.d.setTransform(false);
/*     */               int i = this.b;
/*     */               int j = (Game.i.authManager.getSessionData()).nextLevelXp;
/*     */               int k = this.c;
/*     */               int m = 0;
/*     */               boolean bool = false;
/*     */               paramInt1 = paramInt1;
/*     */               paramInt2 = paramInt2;
/*     */               int n = 0;
/*     */               int i1 = 0;
/*     */               while (paramInt1 > 0 || paramInt2 > 0) {
/*     */                 if (paramInt1 > 0) {
/*     */                   if (k + paramInt1 < j) {
/*     */                     AnimationGiveXpStage animationGiveXpStage2;
/*     */                     (animationGiveXpStage2 = new AnimationGiveXpStage(this)).baseXpLine = k;
/*     */                     animationGiveXpStage2.startRegularXpLine = 0;
/*     */                     animationGiveXpStage2.endRegularXpLine = paramInt1;
/*     */                     animationGiveXpStage2.startBaseXpLabel = k;
/*     */                     animationGiveXpStage2.endBaseXpLabel = k + paramInt1;
/*     */                     animationGiveXpStage2.startRegularXpLabel = n;
/*     */                     animationGiveXpStage2.endRegularXpLabel = n + paramInt1;
/*     */                     m = paramInt1;
/*     */                     this.v.add(animationGiveXpStage2);
/*     */                     n += paramInt1;
/*     */                     paramInt1 = 0;
/*     */                     continue;
/*     */                   } 
/*     */                   int i3 = j - k;
/*     */                   AnimationGiveXpStage animationGiveXpStage1;
/*     */                   (animationGiveXpStage1 = new AnimationGiveXpStage(this)).baseXpLine = k;
/*     */                   animationGiveXpStage1.startRegularXpLine = 0;
/*     */                   animationGiveXpStage1.endRegularXpLine = i3;
/*     */                   animationGiveXpStage1.startBaseXpLabel = k;
/*     */                   animationGiveXpStage1.endBaseXpLabel = k + i3;
/*     */                   animationGiveXpStage1.startRegularXpLabel = n;
/*     */                   animationGiveXpStage1.endRegularXpLabel = n + i3;
/*     */                   m = i3;
/*     */                   k = 0;
/*     */                   this.v.add(animationGiveXpStage1);
/*     */                   AnimationLevelUpStage animationLevelUpStage1 = new AnimationLevelUpStage(this);
/*     */                   if (++i > (Game.i.authManager.getSessionData()).maxProfileLevel) {
/*     */                     i = (Game.i.authManager.getSessionData()).maxProfileLevel;
/*     */                   }
/*     */                   animationLevelUpStage1.newLevel = i;
/*     */                   this.v.add(animationLevelUpStage1);
/*     */                   n += i3;
/*     */                   paramInt1 -= i3;
/*     */                   continue;
/*     */                 } 
/*     */                 if (k + m + paramInt2 < j) {
/*     */                   AnimationGiveXpStage animationGiveXpStage1;
/*     */                   (animationGiveXpStage1 = new AnimationGiveXpStage(this)).baseXpLine = k;
/*     */                   animationGiveXpStage1.startRegularXpLine = m;
/*     */                   animationGiveXpStage1.endRegularXpLine = m;
/*     */                   animationGiveXpStage1.startBonusXpLine = 0;
/*     */                   animationGiveXpStage1.endBonusXpLine = paramInt2;
/*     */                   animationGiveXpStage1.startBaseXpLabel = k + m;
/*     */                   animationGiveXpStage1.endBaseXpLabel = k + m + paramInt2;
/*     */                   animationGiveXpStage1.startRegularXpLabel = n;
/*     */                   animationGiveXpStage1.endRegularXpLabel = n;
/*     */                   animationGiveXpStage1.startBonusXpLabel = i1;
/*     */                   animationGiveXpStage1.endBonusXpLabel = i1 + paramInt2;
/*     */                   if (!bool) {
/*     */                     animationGiveXpStage1.fadeInBonus = true;
/*     */                     bool = true;
/*     */                   } 
/*     */                   this.v.add(animationGiveXpStage1);
/*     */                   i1 += paramInt2;
/*     */                   paramInt2 = 0;
/*     */                   continue;
/*     */                 } 
/*     */                 int i2 = j - k - m;
/*     */                 AnimationGiveXpStage animationGiveXpStage;
/*     */                 (animationGiveXpStage = new AnimationGiveXpStage(this)).baseXpLine = k;
/*     */                 animationGiveXpStage.startRegularXpLine = m;
/*     */                 animationGiveXpStage.endRegularXpLine = m;
/*     */                 animationGiveXpStage.startBonusXpLine = 0;
/*     */                 animationGiveXpStage.endBonusXpLine = i2;
/*     */                 animationGiveXpStage.startBaseXpLabel = k + m;
/*     */                 animationGiveXpStage.endBaseXpLabel = k + m + i2;
/*     */                 animationGiveXpStage.startRegularXpLabel = n;
/*     */                 animationGiveXpStage.endRegularXpLabel = n;
/*     */                 animationGiveXpStage.startBonusXpLabel = i1;
/*     */                 animationGiveXpStage.endBonusXpLabel = i1 + i2;
/*     */                 m = 0;
/*     */                 k = 0;
/*     */                 if (!bool) {
/*     */                   animationGiveXpStage.fadeInBonus = true;
/*     */                   bool = true;
/*     */                 } 
/*     */                 this.v.add(animationGiveXpStage);
/*     */                 AnimationLevelUpStage animationLevelUpStage = new AnimationLevelUpStage(this);
/*     */                 if (++i > (Game.i.authManager.getSessionData()).maxProfileLevel) {
/*     */                   i = (Game.i.authManager.getSessionData()).maxProfileLevel;
/*     */                 }
/*     */                 animationLevelUpStage.newLevel = i;
/*     */                 this.v.add(animationLevelUpStage);
/*     */                 i1 += i2;
/*     */                 paramInt2 -= i2;
/*     */               } 
/*     */             })));
/*     */   }
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
/*     */   public void hide() {
/* 532 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void postRender(float paramFloat) {
/* 537 */     if (this.x) {
/* 538 */       if (this.u == null && this.v.size != 0) {
/*     */         
/* 540 */         this.u = (AnimationStage)this.v.removeIndex(0);
/* 541 */         this.u.start();
/*     */       } 
/*     */       
/* 544 */       if (this.u != null) {
/* 545 */         AnimationStage.a(this.u, (int)(paramFloat * 1000000.0F));
/* 546 */         if (AnimationStage.a(this.u) >= this.u.duration) {
/* 547 */           AnimationStage.b(this.u, this.u.duration);
/*     */         }
/* 549 */         this.u.draw(Interpolation.pow2Out.apply((float)AnimationStage.a(this.u) / (float)this.u.duration));
/*     */         
/* 551 */         if (AnimationStage.a(this.u) == this.u.duration) {
/* 552 */           this.u = null;
/*     */         }
/*     */       } 
/*     */       
/* 556 */       if (this.s.isVisible() && this.z != Game.getTimestampSeconds()) {
/* 557 */         b();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public ProfileSummary setVisible(boolean paramBoolean) {
/* 563 */     return setVisibleClickEnabled(paramBoolean, true);
/*     */   }
/*     */   
/*     */   public ProfileSummary setVisibleClickEnabled(boolean paramBoolean1, boolean paramBoolean2) {
/* 567 */     this.d.clearActions();
/* 568 */     this.d.addAction((Action)Actions.scaleTo(1.0F, 1.0F));
/*     */     
/* 570 */     this.uiLayer.getTable().setVisible(paramBoolean1);
/* 571 */     if (paramBoolean1) {
/* 572 */       if (Game.getTimestampSeconds() - Game.i.authManager.lastStateUpdateTimestamp > 30) {
/* 573 */         Game.i.authManager.loadStateFromServer(null, null);
/*     */       }
/*     */       
/* 576 */       if (!this.x) {
/* 577 */         update();
/*     */       }
/*     */     } else {
/* 580 */       this.y = false;
/* 581 */       this.u = null;
/* 582 */       this.v.clear();
/* 583 */       this.n.setVisible(false);
/* 584 */       this.o.setVisible(false);
/* 585 */       this.q.setVisible(false);
/* 586 */       this.s.setVisible(false);
/*     */     } 
/* 588 */     this.x = paramBoolean1;
/* 589 */     this.h.setVisible(paramBoolean2);
/*     */     
/* 591 */     return this;
/*     */   }
/*     */   
/*     */   private static abstract class AnimationStage {
/*     */     private long a;
/*     */     public long duration;
/*     */     
/*     */     private AnimationStage() {}
/*     */     
/*     */     public void start() {}
/*     */     
/*     */     public void draw(float param1Float) {}
/*     */   }
/*     */   
/*     */   private class AnimationGiveXpStage extends AnimationStage {
/*     */     public int startBaseXpLabel;
/*     */     public int endBaseXpLabel;
/*     */     public int baseXpLine;
/*     */     public int startRegularXpLabel;
/*     */     public int endRegularXpLabel;
/*     */     public int startRegularXpLine;
/*     */     public int endRegularXpLine;
/*     */     public int startBonusXpLabel;
/*     */     public int endBonusXpLabel;
/*     */     public int startBonusXpLine;
/*     */     public int endBonusXpLine;
/*     */     public boolean fadeInBonus;
/*     */     
/*     */     public AnimationGiveXpStage(ProfileSummary this$0) {
/* 620 */       super((byte)0);
/* 621 */       this.duration = 1000000L;
/*     */     }
/*     */ 
/*     */     
/*     */     public void start() {
/* 626 */       ProfileSummary.e(this.a).setVisible(true);
/* 627 */       ProfileSummary.a().setLength(0);
/* 628 */       ProfileSummary.a().append("+").append(this.startRegularXpLabel).append(" XP");
/* 629 */       ProfileSummary.e(this.a).setText((CharSequence)ProfileSummary.a());
/*     */       
/* 631 */       ProfileSummary.a().setLength(0);
/* 632 */       ProfileSummary.a().append("+").append(this.startBonusXpLabel).append(" bonus XP");
/* 633 */       ProfileSummary.f(this.a).setText((CharSequence)ProfileSummary.a());
/*     */       
/* 635 */       if (this.fadeInBonus) {
/* 636 */         ProfileSummary.f(this.a).setVisible(true);
/*     */         
/* 638 */         ProfileSummary.e(this.a).clearActions();
/* 639 */         ProfileSummary.e(this.a).addAction((Action)Actions.parallel(
/* 640 */               (Action)Actions.color(new Color(1.0F, 1.0F, 1.0F, 0.36F), 0.3F), 
/* 641 */               (Action)Actions.moveTo(242.0F, 31.0F, 0.3F)));
/*     */       } 
/*     */ 
/*     */       
/* 645 */       ProfileSummary.g(this.a).setVisible(true);
/* 646 */       ProfileSummary.g(this.a).setColor(Color.WHITE);
/* 647 */       ProfileSummary.h(this.a).setVisible(true);
/* 648 */       ProfileSummary.h(this.a).setColor(MaterialColor.AMBER.P500);
/* 649 */       ProfileSummary.i(this.a).setVisible(true);
/* 650 */       ProfileSummary.i(this.a).setColor(MaterialColor.LIGHT_GREEN.P500);
/*     */     }
/*     */ 
/*     */     
/*     */     public void draw(float param1Float) {
/* 655 */       float f1 = 162.0F / (Game.i.authManager.getSessionData()).nextLevelXp;
/*     */       
/* 657 */       ProfileSummary.g(this.a).setWidth(this.baseXpLine * f1);
/* 658 */       float f2 = (this.startRegularXpLine + (this.endRegularXpLine - this.startRegularXpLine) * param1Float) * f1;
/* 659 */       ProfileSummary.h(this.a).setWidth(f2);
/* 660 */       ProfileSummary.h(this.a).setPosition(ProfileSummary.g(this.a).getWidth(), 0.0F);
/* 661 */       ProfileSummary.i(this.a).setWidth((this.startBonusXpLine + (this.endBonusXpLine - this.startBonusXpLine) * param1Float) * f1);
/* 662 */       ProfileSummary.i(this.a).setPosition(ProfileSummary.g(this.a).getWidth() + ProfileSummary.h(this.a).getWidth(), 0.0F);
/*     */ 
/*     */       
/* 665 */       int i = (int)(this.startBaseXpLabel + (this.endBaseXpLabel - this.startBaseXpLabel) * param1Float);
/* 666 */       ProfileSummary.a().setLength(0);
/* 667 */       ProfileSummary.a().append(i).append(" / ").append((Game.i.authManager.getSessionData()).nextLevelXp).append(" XP");
/* 668 */       ProfileSummary.j(this.a).setText((CharSequence)ProfileSummary.a());
/*     */       
/* 670 */       i = (int)(this.startRegularXpLabel + (this.endRegularXpLabel - this.startRegularXpLabel) * param1Float);
/* 671 */       ProfileSummary.a().setLength(0);
/* 672 */       ProfileSummary.a().append("+").append(i).append(" XP");
/* 673 */       ProfileSummary.e(this.a).setText((CharSequence)ProfileSummary.a());
/*     */       
/* 675 */       i = (int)(this.startBonusXpLabel + (this.endBonusXpLabel - this.startBonusXpLabel) * param1Float);
/* 676 */       ProfileSummary.a().setLength(0);
/* 677 */       ProfileSummary.a().append("+").append(i).append(" bonus XP");
/* 678 */       ProfileSummary.f(this.a).setText((CharSequence)ProfileSummary.a());
/*     */     } }
/*     */   
/*     */   private class AnimationLevelUpStage extends AnimationStage {
/*     */     public int newLevel;
/*     */     
/*     */     public AnimationLevelUpStage(ProfileSummary this$0) {
/* 685 */       super((byte)0);
/* 686 */       this.duration = 500000L;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void start() {
/* 693 */       float f = (float)this.duration / 1000000.0F;
/*     */       
/* 695 */       ProfileSummary.g(this.a).clearActions();
/* 696 */       ProfileSummary.g(this.a).addAction((Action)Actions.sequence((Action)Actions.delay(0.5F * f), (Action)Actions.fadeOut(0.3F * f)));
/* 697 */       ProfileSummary.i(this.a).clearActions();
/* 698 */       ProfileSummary.i(this.a).addAction((Action)Actions.sequence((Action)Actions.delay(0.5F * f), (Action)Actions.fadeOut(0.3F * f)));
/* 699 */       ProfileSummary.h(this.a).clearActions();
/* 700 */       ProfileSummary.h(this.a).addAction((Action)Actions.sequence((Action)Actions.delay(0.5F * f), (Action)Actions.fadeOut(0.3F * f)));
/*     */       
/* 702 */       ProfileSummary.k(this.a).clearActions();
/* 703 */       ProfileSummary.k(this.a).addAction((Action)Actions.sequence(new Action[] {
/* 704 */               (Action)Actions.delay(0.5F * f), 
/* 705 */               (Action)Actions.scaleTo(0.0F, 0.0F, 0.25F * f), 
/* 706 */               (Action)Actions.alpha(0.0F), 
/* 707 */               (Action)Actions.run(() -> {
/*     */                   ProfileSummary.k(this.a).clearChildren();
/*     */                   
/*     */                   Array array = Game.i.authManager.getProfileLevelTextures(this.newLevel);
/*     */                   for (byte b = 0; b < array.size; b++) {
/*     */                     ProfileSummary.k(this.a).addActor((Actor)((TextureRegionConfig[])array.items)[b].createImage(0.0F, 0.0F, 48.0F));
/*     */                   }
/* 714 */                 }), (Action)Actions.scaleTo(2.0F, 2.0F), 
/* 715 */               (Action)Actions.parallel(
/* 716 */                 (Action)Actions.scaleTo(1.0F, 1.0F, 0.25F * f, (Interpolation)Interpolation.pow2In), 
/* 717 */                 (Action)Actions.alpha(1.0F, 0.25F * f, (Interpolation)Interpolation.pow2In))
/*     */             }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\ProfileSummary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */