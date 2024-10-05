/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.InputListenerExtended;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SideMenu
/*     */   implements Disposable
/*     */ {
/*     */   public static final float DEFAULT_WIDTH = 600.0F;
/*     */   public static final float TOGGLE_BUTTON_WIDTH = 140.0F;
/*  33 */   public final UiManager.UiLayer uiLayer = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 105, "SideMenu");
/*     */   
/*     */   private final float a;
/*     */   
/*     */   private final Group b;
/*     */   
/*     */   private final Group c;
/*     */   
/*     */   private final Group d;
/*     */   
/*     */   private final Image e;
/*     */   
/*     */   private final PaddedImageButton f;
/*     */   private final Group g;
/*     */   private float h;
/*     */   private final Label i;
/*     */   private final Image j;
/*     */   public Image sideShadow;
/*  51 */   private final Array<SideMenuContainer> k = new Array();
/*     */   
/*     */   private boolean l;
/*     */   
/*     */   private boolean m;
/*     */   
/*     */   private final Drawable n;
/*     */   
/*     */   private final Drawable o;
/*     */   private final Runnable p;
/*     */   private final Runnable q;
/*  62 */   private final DelayedRemovalArray<SideMenuListener> r = new DelayedRemovalArray();
/*     */   
/*     */   public SideMenu(float paramFloat) {
/*  65 */     this.a = paramFloat;
/*     */     
/*     */     Group group;
/*     */     
/*  69 */     (group = new Group()).setTransform(false);
/*  70 */     group.setTouchable(Touchable.childrenOnly);
/*  71 */     this.uiLayer.getTable().add((Actor)group).width(paramFloat + 140.0F).height(Game.i.settingsManager.getScaledViewportHeight()).expand().bottom().right();
/*     */ 
/*     */     
/*  74 */     this.b = new Group();
/*  75 */     this.b.setSize(paramFloat + 140.0F, Game.i.settingsManager.getScaledViewportHeight());
/*  76 */     this.b.setTransform(true);
/*  77 */     this.b.setTouchable(Touchable.childrenOnly);
/*  78 */     group.addActor((Actor)this.b);
/*     */ 
/*     */     
/*  81 */     this.sideShadow = new Image((Drawable)Game.i.assetManager.getQuad("ui.actors.sideMenu.sideShadow"));
/*  82 */     this.sideShadow.setSize(7.0F, Game.i.settingsManager.getScaledViewportHeight());
/*  83 */     this.sideShadow.setPosition(133.0F, 0.0F);
/*  84 */     this.b.addActor((Actor)this.sideShadow);
/*     */ 
/*     */     
/*  87 */     this.e = new Image((Drawable)Game.i.assetManager.getDrawable("ui-tile-menu-toggle-button"));
/*  88 */     this.e.setSize(180.0F, 196.0F);
/*  89 */     this.b.addActor((Actor)this.e);
/*     */ 
/*     */     
/*  92 */     this.c = new Group();
/*  93 */     this.c.setTransform(false);
/*  94 */     this.c.setSize(paramFloat, Game.i.settingsManager.getScaledViewportHeight());
/*  95 */     this.c.setPosition(140.0F, 0.0F);
/*  96 */     this.b.addActor((Actor)this.c);
/*     */ 
/*     */     
/*  99 */     this.g = new Group();
/* 100 */     this.g.setSize(288.0F, 173.0F);
/* 101 */     this.g.setPosition(-148.0F, 0.0F);
/* 102 */     this.b.addActor((Actor)this.g);
/*     */     
/* 104 */     this.g.setTouchable(Touchable.enabled);
/* 105 */     this.g.addListener((EventListener)new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 108 */             this.a.hideSideTooltip();
/*     */             
/* 110 */             SideMenu.a(this.a).begin();
/* 111 */             for (byte b = 0; b < (SideMenu.a(this.a)).size; b++) {
/* 112 */               ((SideMenu.SideMenuListener)SideMenu.a(this.a).get(b)).sideTooltipHidden();
/*     */             }
/* 114 */             SideMenu.a(this.a).end();
/*     */           }
/*     */         });
/*     */     
/* 118 */     this.j = new Image((Drawable)Game.i.assetManager.getQuad("ui.actors.sideMenu.sideTooltip"));
/* 119 */     this.g.addActor((Actor)this.j);
/*     */     
/* 121 */     this.i = new Label("Side tooltip", Game.i.assetManager.getLabelStyle(24));
/* 122 */     this.i.setSize(238.0F, 173.0F);
/* 123 */     this.i.setPosition(20.0F, 0.0F);
/* 124 */     this.i.setWrap(true);
/* 125 */     this.i.setAlignment(1);
/* 126 */     this.g.addActor((Actor)this.i);
/*     */     
/* 128 */     hideSideTooltip();
/*     */ 
/*     */     
/* 131 */     this.n = (Drawable)Game.i.assetManager.getDrawable("icon-triangle-right-hollow");
/* 132 */     this.o = (Drawable)Game.i.assetManager.getDrawable("icon-triangle-left-hollow");
/*     */     
/* 134 */     this.f = new PaddedImageButton((Drawable)Game.i.assetManager.getDrawable("icon-triangle-right-hollow"), () -> setOffscreen(!this.m), Color.WHITE, MaterialColor.LIGHT_BLUE.P500, MaterialColor.LIGHT_BLUE.P600);
/* 135 */     this.f.setName("side_menu_toggle_button");
/* 136 */     this.f.setSize(140.0F, 196.0F);
/* 137 */     this.f.setTouchable(Touchable.enabled);
/* 138 */     this.f.setIconSize(64.0F, 64.0F);
/* 139 */     this.f.setIconPosition(32.0F, 48.0F);
/* 140 */     this.b.addActor((Actor)this.f);
/*     */     
/* 142 */     if (HotKeyHintLabel.isEnabled()) {
/* 143 */       this.f.addActor((Actor)new HotKeyHintLabel(Game.i.settingsManager.getHotKey(SettingsManager.HotkeyAction.TOGGLE_TILE_MENU), 64.0F, 12.0F));
/*     */     }
/*     */ 
/*     */     
/* 147 */     this.d = new Group();
/* 148 */     this.d.setSize(paramFloat, Game.i.settingsManager.getScaledViewportHeight());
/* 149 */     this.d.setPosition(140.0F, 0.0F);
/* 150 */     this.d.setTransform(false);
/* 151 */     this.d.setTouchable(Touchable.enabled);
/* 152 */     this.d.addListener((EventListener)(new InputListenerExtended(this)
/*     */         {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 155 */             return true;
/*     */           }
/* 157 */         }).setMode(InputEvent.Type.touchDragged, 2));
/* 158 */     this.b.addActor((Actor)this.d);
/*     */ 
/*     */     
/* 161 */     this.p = (() -> {
/*     */         this.d.setVisible(false); this.c.setVisible(false);
/*     */         this.r.begin();
/*     */         byte b = 0;
/*     */         int i = this.r.size;
/*     */         while (b < i) {
/*     */           ((SideMenuListener)this.r.get(b)).offscreenChanged();
/*     */           b++;
/*     */         } 
/*     */         this.r.end();
/*     */       });
/* 172 */     this.q = (() -> {
/*     */         this.d.setVisible(true);
/*     */         
/*     */         this.c.setVisible(true);
/*     */       });
/*     */     
/* 178 */     setVisible(true);
/*     */     
/* 180 */     this.m = true;
/* 181 */     setOffscreen(false);
/*     */   }
/*     */   
/*     */   public Group getWrapper() {
/* 185 */     return this.b;
/*     */   }
/*     */   
/*     */   public void addOffscreenBackground() {
/* 189 */     if (Game.i.settingsManager.getScaledViewportHeight() > 0) {
/*     */       Image image;
/* 191 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("blank"))).setColor(new Color(387389371));
/* 192 */       image.setSize(Game.i.uiManager.getScreenSafeMargin(), Game.i.settingsManager.getScaledViewportHeight());
/* 193 */       image.setPosition(this.a, 0.0F);
/* 194 */       getBackgroundContainer().addActor((Actor)image);
/*     */ 
/*     */       
/* 197 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-left"))).setSize(10.0F, Game.i.settingsManager.getScaledViewportHeight());
/* 198 */       image.setPosition(this.a, 0.0F);
/* 199 */       image.setColor(0.0F, 0.0F, 0.0F, 0.14F);
/* 200 */       getBackgroundContainer().addActor((Actor)image);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void finalFadeOut() {
/* 205 */     setOffscreen(true);
/* 206 */     this.uiLayer.getTable().setTouchable(Touchable.disabled);
/* 207 */     this.uiLayer.getTable().clearActions();
/* 208 */     this.uiLayer.getTable().addAction((Action)Actions.alpha(0.0F, 1.0F));
/*     */   }
/*     */   
/*     */   public Group getBackgroundContainer() {
/* 212 */     return this.c;
/*     */   }
/*     */   
/*     */   public void showSideTooltip(CharSequence paramCharSequence, float paramFloat) {
/* 216 */     if (this.g.isVisible() && this.i.textEquals(paramCharSequence) && this.h == paramFloat) {
/*     */       return;
/*     */     }
/*     */     
/* 220 */     this.i.setText(paramCharSequence);
/* 221 */     this.i.layout();
/* 222 */     this.i.validate();
/*     */ 
/*     */ 
/*     */     
/* 226 */     float f1 = 173.0F;
/*     */     float f2;
/* 228 */     if ((f2 = this.i.getPrefHeight() + 24.0F) > 173.0F) {
/* 229 */       f1 = f2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 234 */     this.g.setSize(this.g.getWidth(), f1);
/* 235 */     this.g.setVisible(true);
/* 236 */     this.g.setY(paramFloat - f1 / 2.0F);
/*     */ 
/*     */     
/* 239 */     this.j.setSize(288.0F, f1);
/*     */ 
/*     */     
/* 242 */     this.i.setSize(238.0F, f1);
/* 243 */     this.i.setPosition(20.0F, 0.0F);
/*     */     
/* 245 */     this.h = paramFloat;
/*     */   }
/*     */   
/*     */   public void hideSideTooltip() {
/* 249 */     this.g.setVisible(false);
/*     */   }
/*     */   
/*     */   public void addListener(SideMenuListener paramSideMenuListener) {
/* 253 */     if (paramSideMenuListener == null) {
/* 254 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 257 */     if (!this.r.contains(paramSideMenuListener, true)) {
/* 258 */       this.r.add(paramSideMenuListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeListener(SideMenuListener paramSideMenuListener) {
/* 263 */     if (paramSideMenuListener == null) {
/* 264 */       throw new IllegalArgumentException("listener is null");
/*     */     }
/*     */     
/* 267 */     this.r.removeValue(paramSideMenuListener, true);
/*     */   }
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 271 */     if (this.l != paramBoolean) {
/* 272 */       this.l = paramBoolean;
/*     */       
/* 274 */       this.r.begin();
/* 275 */       for (byte b = 0; b < this.r.size; b++) {
/* 276 */         ((SideMenuListener)this.r.get(b)).visibilityChanged();
/*     */       }
/* 278 */       this.r.end();
/*     */     } 
/*     */     
/* 281 */     this.uiLayer.getTable().setVisible(paramBoolean);
/*     */   }
/*     */   
/*     */   public void setOffscreen(boolean paramBoolean) {
/* 285 */     if (this.m != paramBoolean) {
/* 286 */       this.m = paramBoolean;
/*     */       
/* 288 */       if (paramBoolean) {
/* 289 */         this.b.clearActions();
/*     */         
/* 291 */         this.r.begin(); int k;
/* 292 */         for (paramBoolean = false, k = this.r.size; paramBoolean < k; paramBoolean++) {
/* 293 */           ((SideMenuListener)this.r.get(paramBoolean)).offscreenStartingToChange();
/*     */         }
/* 295 */         this.r.end();
/*     */         
/* 297 */         this.f.clearActions();
/* 298 */         this.e.clearActions();
/* 299 */         int j = Game.i.uiManager.getScreenSafeMargin();
/* 300 */         if (Game.i.settingsManager.isUiAnimationsEnabled()) {
/* 301 */           this.b.addAction((Action)Actions.sequence((Action)Actions.moveTo(this.a + j, 0.0F, 0.2F, (Interpolation)Interpolation.exp5Out), (Action)Actions.run(this.p)));
/* 302 */           this.f.addAction((Action)Actions.moveTo(-j, 0.0F, 0.2F));
/* 303 */           this.e.addAction((Action)Actions.moveTo(-j, 0.0F, 0.2F));
/*     */         } else {
/* 305 */           this.b.setPosition(this.a + j, 0.0F);
/* 306 */           this.f.setPosition(-j, 0.0F);
/* 307 */           this.e.setPosition(-j, 0.0F);
/* 308 */           this.p.run();
/*     */         } 
/* 310 */         this.f.setIcon(this.o);
/*     */         
/*     */         return;
/*     */       } 
/* 314 */       this.b.clearActions();
/* 315 */       this.q.run();
/*     */       
/* 317 */       this.f.clearActions();
/* 318 */       this.e.clearActions();
/* 319 */       if (Game.i.settingsManager.isUiAnimationsEnabled()) {
/* 320 */         this.b.addAction((Action)Actions.moveTo(0.0F, 0.0F, 0.2F, (Interpolation)Interpolation.exp5Out));
/* 321 */         this.f.addAction((Action)Actions.moveTo(0.0F, 0.0F, 0.2F));
/* 322 */         this.e.addAction((Action)Actions.moveTo(0.0F, 0.0F, 0.2F));
/*     */       } else {
/* 324 */         this.b.setPosition(0.0F, 0.0F);
/* 325 */         this.f.setPosition(0.0F, 0.0F);
/* 326 */         this.e.setPosition(0.0F, 0.0F);
/*     */       } 
/* 328 */       this.f.setIcon(this.n);
/*     */       
/* 330 */       this.r.begin(); int i;
/* 331 */       for (paramBoolean = false, i = this.r.size; paramBoolean < i; paramBoolean++) {
/* 332 */         ((SideMenuListener)this.r.get(paramBoolean)).offscreenStartingToChange();
/*     */       }
/* 334 */       this.r.end();
/*     */       
/* 336 */       this.r.begin();
/* 337 */       for (paramBoolean = false, i = this.r.size; paramBoolean < i; paramBoolean++) {
/* 338 */         ((SideMenuListener)this.r.get(paramBoolean)).offscreenChanged();
/*     */       }
/* 340 */       this.r.end();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVisible() {
/* 346 */     return this.l;
/*     */   }
/*     */   
/*     */   public boolean isOffscreen() {
/* 350 */     return this.m;
/*     */   }
/*     */   
/*     */   private void a() {
/* 354 */     for (Array.ArrayIterator<SideMenuContainer> arrayIterator = this.k.iterator(); arrayIterator.hasNext();) {
/* 355 */       if ((sideMenuContainer = arrayIterator.next()).k) {
/* 356 */         setVisible(true);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 361 */     setVisible(false);
/*     */   }
/*     */   
/*     */   public SideMenuContainer createContainer(String paramString) {
/*     */     SideMenuContainer sideMenuContainer;
/* 366 */     (sideMenuContainer = new SideMenuContainer(this, paramString)).setSize(this.d.getWidth(), this.d.getHeight());
/* 367 */     this.d.addActor((Actor)sideMenuContainer);
/* 368 */     this.k.add(sideMenuContainer);
/* 369 */     sideMenuContainer.setVisible(false);
/*     */     
/* 371 */     return sideMenuContainer;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 376 */     Game.i.uiManager.removeLayer(this.uiLayer);
/*     */   }
/*     */   
/*     */   public static class SideMenuContainer
/*     */     extends Group
/*     */   {
/*     */     boolean k;
/*     */     private final SideMenu l;
/*     */     public Label hintLabel;
/*     */     public final String name;
/* 386 */     public static StringBuilder sb = new StringBuilder();
/*     */     
/*     */     public SideMenuContainer(SideMenu param1SideMenu, String param1String) {
/* 389 */       setTransform(false);
/* 390 */       this.name = param1String;
/* 391 */       this.l = param1SideMenu;
/* 392 */       setName("SMC-" + param1String);
/*     */     }
/*     */     
/*     */     public void setLabelOverTitleTilePos(Tile param1Tile) {
/* 396 */       if (param1Tile == null)
/*     */         return; 
/* 398 */       sb.setLength(0);
/* 399 */       sb.append(param1Tile.getX()).append(":").append(param1Tile.getY());
/* 400 */       setLabelOverTitle((CharSequence)sb);
/*     */     }
/*     */     
/*     */     public void setLabelOverTitle(CharSequence param1CharSequence) {
/* 404 */       if (this.hintLabel != null) {
/* 405 */         this.hintLabel.remove();
/*     */       }
/*     */       
/* 408 */       this.hintLabel = new Label(param1CharSequence, Game.i.assetManager.getLabelStyle(24));
/* 409 */       this.hintLabel.setSize(100.0F, 26.0F);
/* 410 */       this.hintLabel.setPosition(460.0F, Game.i.settingsManager.getScaledViewportHeight() - 54.0F);
/* 411 */       this.hintLabel.setAlignment(16);
/* 412 */       this.hintLabel.setColor(1.0F, 1.0F, 1.0F, 0.28F);
/* 413 */       addActor((Actor)this.hintLabel);
/*     */     }
/*     */     
/*     */     public void show() {
/* 417 */       setVisible(true);
/* 418 */       this.k = true;
/* 419 */       SideMenu.b(this.l);
/*     */     }
/*     */     
/*     */     public void hide() {
/* 423 */       setVisible(false);
/* 424 */       this.k = false;
/* 425 */       SideMenu.b(this.l);
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface SideMenuListener {
/*     */     void offscreenChanged();
/*     */     
/*     */     void offscreenStartingToChange();
/*     */     
/*     */     void visibilityChanged();
/*     */     
/*     */     void sideTooltipHidden();
/*     */     
/*     */     public static class SideMenuListenerAdapter implements SideMenuListener {
/*     */       public void offscreenChanged() {}
/*     */       
/*     */       public void offscreenStartingToChange() {}
/*     */       
/*     */       public void visibilityChanged() {}
/*     */       
/*     */       public void sideTooltipHidden() {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\SideMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */