/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.Resource;
/*     */ import com.prineside.tdi2.Screen;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.PreferencesManager;
/*     */ import com.prineside.tdi2.managers.ProgressManager;
/*     */ import com.prineside.tdi2.managers.PurchaseManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
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
/*     */ import com.prineside.tdi2.screens.TicTacToeScreen;
/*     */ import com.prineside.tdi2.ui.actors.ComplexButton;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public final class ResourcesAndMoney implements UiManager.UiComponent {
/*     */   public static ResourcesAndMoney i() {
/*  40 */     return (ResourcesAndMoney)Game.i.uiManager.getComponent(ResourcesAndMoney.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   private static final Color a = new Color(168430267);
/*     */   
/*  48 */   private static final Color b = MaterialColor.GREEN.P800;
/*  49 */   private static final Color c = MaterialColor.GREEN.P700;
/*  50 */   private static final Color d = MaterialColor.GREEN.P900;
/*     */   
/*  52 */   private final UiManager.UiLayer e = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SHARED_COMPONENTS, 100, "ResourcesAndMoney");
/*     */   
/*     */   private final Group f;
/*     */   
/*     */   private final Label g;
/*     */   private final Table h;
/*     */   private final Image i;
/*     */   private final Image j;
/*     */   private final Image k;
/*     */   private final Label.LabelStyle l;
/*  62 */   private float m = 0.0F;
/*  63 */   private int n = -1;
/*     */   private boolean o = false;
/*     */   
/*     */   public ResourcesAndMoney() {
/*     */     Group group1;
/*  68 */     (group1 = new Group()).setTransform(false);
/*  69 */     this.e.getTable().add((Actor)group1).expand().top().right().size(1200.0F, 80.0F);
/*     */     
/*  71 */     boolean bool = false;
/*  72 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/*     */       ComplexButton complexButton;
/*  74 */       (complexButton = new ComplexButton("", Game.i.assetManager.getLabelStyle(24), () -> Dialog.i().showConfirm(Game.i.localeManager.i18n.get("exit_game_confirm"), Game::exit))).setBackground((Drawable)Game.i.assetManager.getDrawable("ui-top-bar-exit"), 0.0F, 0.0F, 139.0F, 88.0F);
/*  75 */       complexButton.setBackgroundColors(new Color(673720575), new Color(-2112218369), new Color(-1255922433), Color.GRAY);
/*     */       
/*  77 */       complexButton.setIconPositioned((Drawable)Game.i.assetManager.getDrawable("icon-times"), 46.0F, 26.0F, 40.0F, 40.0F);
/*  78 */       complexButton.setIconColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
/*  79 */       this.e.getTable().add((Actor)complexButton).top().right().size(128.0F, 88.0F).padLeft(-5.0F);
/*     */       
/*  81 */       bool = true;
/*     */     } 
/*     */     
/*  84 */     this.l = new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE);
/*     */     
/*  86 */     this.f = new Group();
/*  87 */     this.f.setTransform(false);
/*  88 */     this.f.setSize(1200.0F, 80.0F);
/*  89 */     group1.addActor((Actor)this.f);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Group group2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     (group2 = new Group(this) { public void act(float param1Float) { super.act(param1Float); if (ResourcesAndMoney.a(this.k) != null) ResourcesAndMoney.a(this.k).setVisible(Game.i.purchaseManager.canShowRewardingAd(PurchaseManager.RewardingAdsType.REGULAR));  } }).setTransform(false);
/* 102 */     group2.setSize(273.0F, 88.0F);
/* 103 */     group2.setPosition(927.0F, -8.0F);
/* 104 */     group1.addActor((Actor)group2);
/*     */     
/*     */     Image image;
/* 107 */     (image = new Image((TextureRegion)Game.i.assetManager.getTextureRegion("ui-top-bar-money"))).setColor(b);
/* 108 */     image.setSize(283.0F, 88.0F);
/* 109 */     group2.addActor((Actor)image);
/*     */     
/* 111 */     this.j = new Image((TextureRegion)Game.i.assetManager.getTextureRegion("icon-money"));
/* 112 */     this.j.setSize(48.0F, 48.0F);
/* 113 */     this.j.setOrigin(24.0F, 4.0F);
/* 114 */     this.j.setPosition(209.0F, 24.0F);
/* 115 */     this.j.setColor(Color.WHITE);
/* 116 */     group2.addActor((Actor)this.j);
/*     */     
/* 118 */     this.k = new Image((Drawable)Game.i.assetManager.getDrawable("count-bubble"));
/* 119 */     this.k.setSize(21.5F, 24.5F);
/* 120 */     this.k.setPosition(249.0F, 56.0F);
/* 121 */     this.k.setVisible(false);
/* 122 */     group2.addActor((Actor)this.k);
/*     */     
/* 124 */     Game.i.preferencesManager.addListener((PreferencesManager.PreferencesManagerListener)new PreferencesManager.PreferencesManagerListener.PreferencesManagerListenerAdapter(this)
/*     */         {
/*     */           public void reloaded() {
/* 127 */             ResourcesAndMoney.a(this.a, true);
/*     */           }
/*     */         });
/*     */     
/* 131 */     Game.i.screenManager.addListener(() -> this.o = true);
/*     */     
/* 133 */     this.g = new Label("0", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/* 134 */     this.g.setAlignment(16);
/* 135 */     this.g.setSize(193.0F, 80.0F);
/* 136 */     this.g.setPosition(0.0F, 8.0F);
/* 137 */     group2.addActor((Actor)this.g);
/*     */     
/* 139 */     this.h = new Table();
/* 140 */     this.h.setSize(273.0F, 24.0F);
/* 141 */     if (bool) {
/* 142 */       this.h.setPosition(1050.0F, -40.0F);
/*     */     } else {
/* 144 */       this.h.setPosition(927.0F, -40.0F);
/*     */     } 
/* 146 */     group1.addActor((Actor)this.h);
/*     */ 
/*     */     
/* 149 */     this.i = new Image((Drawable)Game.i.assetManager.getDrawable("ui-top-bar-ad-available"));
/* 150 */     this.i.setSize(64.0F, 59.0F);
/* 151 */     this.i.setPosition(-1.0F, 14.0F);
/* 152 */     this.i.setVisible(false);
/* 153 */     this.i.addAction((Action)Actions.forever(
/* 154 */           (Action)Actions.sequence(
/* 155 */             (Action)Actions.color(new Color(0.85F, 0.85F, 0.85F, 1.0F), 0.5F, (Interpolation)Interpolation.exp5In), 
/* 156 */             (Action)Actions.color(Color.WHITE, 0.5F, (Interpolation)Interpolation.exp5Out))));
/*     */ 
/*     */     
/* 159 */     group2.addActor((Actor)this.i);
/*     */     
/* 161 */     group2.setTouchable(Touchable.enabled);
/* 162 */     group2.addListener((EventListener)new ClickListener(this, image) {
/*     */           private boolean a = false;
/*     */           private boolean b = false;
/*     */           
/*     */           private void a() {
/* 167 */             if (this.a) {
/* 168 */               this.c.setColor(ResourcesAndMoney.a()); return;
/*     */             } 
/* 170 */             if (this.b) {
/* 171 */               this.c.setColor(ResourcesAndMoney.b()); return;
/*     */             } 
/* 173 */             this.c.setColor(ResourcesAndMoney.c());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 180 */             Game.i.screenManager.goToMoneyScreen();
/* 181 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 186 */             this.a = true;
/* 187 */             a();
/*     */             
/* 189 */             return super.touchDown(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 194 */             this.a = false;
/* 195 */             a();
/*     */             
/* 197 */             super.touchUp(param1InputEvent, param1Float1, param1Float2, param1Int1, param1Int2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 202 */             if (param1Int == -1) {
/* 203 */               this.b = true;
/* 204 */               a();
/*     */             } 
/*     */             
/* 207 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */ 
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 212 */             if (param1Int == -1) {
/* 213 */               this.b = false;
/* 214 */               a();
/*     */             } 
/*     */             
/* 217 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/*     */           }
/*     */         });
/* 220 */     Game.i.cursorGraphics.setActorCustomMouseCursor((Actor)group2, Cursor.SystemCursor.Hand);
/*     */     
/* 222 */     this.o = true;
/* 223 */     setVisible(false);
/*     */     
/* 225 */     Game.i.progressManager.addListener((ProgressManager.ProgressManagerListener)new ProgressManager.ProgressManagerListener.ProgressManagerListenerAdapter(this)
/*     */         {
/*     */           public void itemsChanged(Item param1Item, int param1Int1, int param1Int2) {
/* 228 */             if (param1Item.getType() == ItemType.RESOURCE || param1Item
/* 229 */               .getType() == ItemType.GREEN_PAPER || param1Item
/* 230 */               .getType() == ItemType.ACCELERATOR) {
/* 231 */               ResourcesAndMoney.a(this.a, true);
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public final void updateBoosts() {
/* 238 */     int i = Game.i.progressManager.getItemsCount((Item)Item.D.RARITY_BOOST);
/* 239 */     int j = (int)Game.i.progressManager.getLootBoostTimeLeft();
/* 240 */     int k = i * 31 + j;
/*     */     
/* 242 */     if (this.n != k) {
/* 243 */       this.h.clear();
/*     */       
/* 245 */       this.h.add().height(1.0F).expandX().fillX();
/*     */       
/* 247 */       if (i > 0) {
/* 248 */         Image image = new Image((Drawable)Game.i.assetManager.getDrawable("rarity-token"));
/* 249 */         this.h.add((Actor)image).size(24.0F, 24.0F).padRight(5.0F);
/*     */         
/*     */         Label label;
/* 252 */         (label = new Label("x" + i, Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.AMBER.P500);
/* 253 */         this.h.add((Actor)label).height(24.0F).padRight(16.0F);
/*     */       } 
/* 255 */       if (j > 0) {
/* 256 */         Image image = new Image((Drawable)Game.i.assetManager.getDrawable("loot-token"));
/* 257 */         this.h.add((Actor)image).size(24.0F, 24.0F).padRight(5.0F);
/*     */         
/*     */         Label label;
/* 260 */         (label = new Label((CharSequence)StringFormatter.digestTime(j), Game.i.assetManager.getLabelStyle(21))).setColor(MaterialColor.LIGHT_GREEN.P400);
/* 261 */         this.h.add((Actor)label).height(24.0F).padRight(16.0F);
/*     */       } 
/*     */       
/* 264 */       this.h.add().height(1.0F).width(8.0F);
/*     */       
/* 266 */       this.n = k;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void preRender(float paramFloat) {
/* 272 */     if (this.o) {
/* 273 */       d();
/* 274 */       this.o = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hide() {
/* 280 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isPersistent() {
/* 285 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postRender(float paramFloat) {
/* 290 */     if (this.e.getTable().isVisible()) {
/* 291 */       this.m += paramFloat;
/* 292 */       if (this.m >= 1.0F) {
/* 293 */         this.m = 0.0F;
/* 294 */         updateBoosts();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void d() {
/* 301 */     this.g.setText(String.format(Locale.ENGLISH, "%,d", new Object[] { Integer.valueOf(Game.i.progressManager.getGreenPapers()) }));
/* 302 */     if (Game.i.progressManager.getGreenPapers() < 10000000) {
/* 303 */       this.g.setStyle(Game.i.assetManager.getLabelStyle(30));
/*     */     } else {
/* 305 */       this.g.setStyle(Game.i.assetManager.getLabelStyle(24));
/*     */     } 
/*     */     
/*     */     boolean bool;
/*     */     
/* 310 */     if (bool = ((ProgressPrefs.i()).progress.getVideosWatchedForDoubleGain() >= 500 || (ProgressPrefs.i()).progress.getVideosWatchedForLuckyShot() >= 20) ? true : false) {
/* 311 */       this.k.setVisible(true);
/*     */       
/* 313 */       this.j.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-gift"));
/* 314 */       this.j.clearActions();
/* 315 */       this.j.setPosition(209.0F, 24.0F);
/* 316 */       this.j.addAction((Action)Actions.sequence(
/* 317 */             (Action)Actions.sequence((Action)Actions.scaleTo(1.0F, 1.0F)), 
/* 318 */             (Action)Actions.forever(
/* 319 */               (Action)Actions.sequence(
/* 320 */                 (Action)Actions.scaleTo(1.2F, 0.8F, 0.2F, (Interpolation)Interpolation.fastSlow), 
/* 321 */                 (Action)Actions.parallel(
/* 322 */                   (Action)Actions.sequence(
/* 323 */                     (Action)Actions.scaleTo(0.8F, 1.2F, 0.2F, Interpolation.sine), 
/* 324 */                     (Action)Actions.scaleTo(1.1F, 0.9F, 0.2F, Interpolation.sine), 
/* 325 */                     (Action)Actions.scaleTo(1.0F, 1.0F, 0.1F, Interpolation.sine)), 
/*     */                   
/* 327 */                   (Action)Actions.sequence(
/* 328 */                     (Action)Actions.moveBy(0.0F, 12.0F, 0.2F, (Interpolation)Interpolation.pow2Out), 
/* 329 */                     (Action)Actions.moveBy(0.0F, -12.0F, 0.2F, (Interpolation)Interpolation.pow2In))), 
/*     */ 
/*     */                 
/* 332 */                 (Action)Actions.delay(1.0F)))));
/*     */     }
/*     */     else {
/*     */       
/* 336 */       this.j.clearActions();
/* 337 */       this.j.setPosition(209.0F, 24.0F);
/* 338 */       this.j.setDrawable((Drawable)Game.i.assetManager.getDrawable("icon-money"));
/* 339 */       this.k.setVisible(false);
/*     */     } 
/*     */ 
/*     */     
/* 343 */     this.f.clearChildren();
/*     */ 
/*     */     
/*     */     Image image1;
/*     */     
/* 348 */     (image1 = new Image((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).setColor(a);
/* 349 */     image1.setSize(280.0F, 80.0F);
/* 350 */     float f = 920.0F;
/* 351 */     image1.setPosition(920.0F, 0.0F);
/* 352 */     this.f.addActor((Actor)image1);
/*     */     
/* 354 */     for (int i = ResourceType.values.length - 1; i >= 0; i--) {
/* 355 */       ResourceType resourceType = ResourceType.values[i];
/* 356 */       if (Game.i.progressManager.isResourceOpened(resourceType)) {
/*     */         Image image3;
/* 358 */         (image3 = new Image((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).setColor(a);
/* 359 */         image3.setSize(136.0F, 80.0F);
/* 360 */         f -= 136.0F;
/* 361 */         image3.setPosition(f, 0.0F);
/* 362 */         this.f.addActor((Actor)image3);
/*     */         
/*     */         Group group;
/* 365 */         (group = new Group()).setTransform(false);
/* 366 */         group.setSize(150.0F, 80.0F);
/* 367 */         group.setPosition(f, 0.0F);
/* 368 */         this.f.addActor((Actor)group);
/*     */         
/*     */         Image image4;
/* 371 */         (image4 = new Image((Drawable)Game.i.assetManager.getDrawable(Resource.TEXTURE_REGION_NAMES[resourceType.ordinal()]))).setSize(48.0F, 48.0F);
/* 372 */         image4.setColor(Game.i.resourceManager.getColor(resourceType));
/* 373 */         image4.setPosition(16.0F, 16.0F);
/* 374 */         group.addActor((Actor)image4);
/*     */         
/*     */         Label label1;
/* 377 */         (label1 = new Label((CharSequence)StringFormatter.compactNumber(Game.i.progressManager.getResources(resourceType), false), this.l)).setColor(Game.i.resourceManager.getColor(resourceType));
/* 378 */         label1.setSize(62.0F, 80.0F);
/* 379 */         label1.setPosition(72.0F, 0.0F);
/* 380 */         group.addActor((Actor)label1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     QuadActor quadActor;
/*     */ 
/*     */ 
/*     */     
/* 390 */     (quadActor = new QuadActor(Color.WHITE, new float[] { 28.0F, 0.0F, 0.0F, 80.0F, 38.0F, 80.0F, 38.0F, 0.0F })).setColor(a);
/*     */     
/* 392 */     quadActor.setSize(38.0F, 80.0F);
/* 393 */     f -= 38.0F;
/* 394 */     quadActor.setPosition(f, 0.0F);
/* 395 */     this.f.addActor((Actor)quadActor);
/*     */     
/*     */     Image image2;
/*     */     
/* 399 */     (image2 = new Image((Drawable)Game.i.assetManager.getDrawable("time-accelerator"))).setColor(MaterialColor.YELLOW.P500);
/* 400 */     image2.setSize(48.0F, 48.0F);
/* 401 */     image2.setPosition(f - 136.0F, 16.0F);
/* 402 */     image2.setTouchable(Touchable.enabled);
/* 403 */     int[] arrayOfInt = { 0 };
/* 404 */     image2.addListener((EventListener)new ClickListener(this, arrayOfInt)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 407 */             this.a[0] = this.a[0] + 1;
/* 408 */             if (this.a[0] == 10) {
/* 409 */               Game.i.screenManager.setScreen((Screen)new TicTacToeScreen());
/*     */             }
/*     */           }
/*     */         });
/* 413 */     this.f.addActor((Actor)image2);
/*     */     
/*     */     Label label;
/* 416 */     (label = new Label((CharSequence)StringFormatter.compactNumber(Game.i.progressManager.getAccelerators(), false), this.l)).setColor(MaterialColor.YELLOW.P500);
/* 417 */     label.setSize(64.0F, 80.0F);
/* 418 */     label.setAlignment(1);
/* 419 */     label.setPosition(f - 136.0F + 64.0F, 0.0F);
/* 420 */     this.f.addActor((Actor)label);
/*     */     
/* 422 */     updateBoosts();
/*     */   }
/*     */   
/*     */   public final void setVisible(boolean paramBoolean) {
/* 426 */     this.e.getTable().setVisible(paramBoolean);
/*     */   }
/*     */   
/*     */   public final void dispose() {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\ResourcesAndMoney.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */