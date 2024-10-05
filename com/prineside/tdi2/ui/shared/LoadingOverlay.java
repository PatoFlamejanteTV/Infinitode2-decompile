/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ 
/*     */ public class LoadingOverlay extends UiManager.UiComponent.Adapter {
/*     */   public static LoadingOverlay i() {
/*  17 */     return (LoadingOverlay)Game.i.uiManager.getComponent(LoadingOverlay.class);
/*     */   }
/*     */   
/*  20 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayerIgnoreSafeArea(UiManager.MainUiLayer.OVERLAY, 150, "LoadingOverlay overlay", true);
/*  21 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 151, "LoadingOverlay main");
/*     */   
/*  23 */   private static final StringBuffer c = new StringBuffer();
/*     */   private final Label d;
/*     */   private final Label e;
/*     */   private final Image f;
/*     */   private final Image g;
/*     */   private final Image h;
/*     */   private boolean i;
/*     */   
/*     */   public LoadingOverlay() {
/*     */     Image image;
/*  33 */     (image = new Image((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion())).setColor(Config.BACKGROUND_COLOR);
/*  34 */     image.setTouchable(Touchable.enabled);
/*  35 */     this.a.getTable().add((Actor)image).expand().fill();
/*     */     
/*  37 */     Group group = new Group();
/*  38 */     this.b.getTable().add((Actor)group).expand().bottom().left().size(320.0F, 64.0F).padLeft(40.0F).padBottom(40.0F);
/*     */     
/*  40 */     this.f = new Image((Drawable)Game.i.assetManager.getDrawable("loading-icon"));
/*  41 */     this.f.setOrigin(1);
/*  42 */     group.addActor((Actor)this.f);
/*     */     
/*  44 */     this.g = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  45 */     this.g.setColor(0.0F, 0.0F, 0.0F, 0.56F);
/*  46 */     this.g.setPosition(0.0F, -16.0F);
/*  47 */     this.g.setSize(320.0F, 5.0F);
/*  48 */     group.addActor((Actor)this.g);
/*     */     
/*  50 */     this.h = new Image((Drawable)Game.i.assetManager.getDrawable("blank"));
/*  51 */     this.h.setColor(MaterialColor.CYAN.P500);
/*  52 */     this.h.setPosition(0.0F, -16.0F);
/*  53 */     group.addActor((Actor)this.h);
/*     */     
/*  55 */     this.d = new Label("Loading...", Game.i.assetManager.getLabelStyle(30));
/*  56 */     this.d.setPosition(80.0F, 8.0F);
/*  57 */     this.d.setSize(200.0F, 64.0F);
/*  58 */     group.addActor((Actor)this.d);
/*     */     
/*  60 */     this.e = new Label("Tip", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE));
/*  61 */     this.e.setPosition(80.0F, -24.0F);
/*  62 */     this.e.setSize(200.0F, 64.0F);
/*  63 */     this.e.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  64 */     group.addActor((Actor)this.e);
/*     */     
/*  66 */     this.i = true;
/*  67 */     hide();
/*     */   }
/*     */   
/*     */   public void show() {
/*  71 */     if (!this.i) {
/*  72 */       c.setLength(0);
/*  73 */       c.append(Game.i.localeManager.i18n.get("loading")).append("...");
/*  74 */       this.d.setText(c);
/*     */       
/*  76 */       this.f.clearActions();
/*  77 */       this.f.addAction((Action)Actions.forever((Action)Actions.rotateBy(90.0F, 1.0F)));
/*     */       
/*  79 */       this.a.getTable().setVisible(true);
/*  80 */       this.b.getTable().setVisible(true);
/*     */       
/*  82 */       this.i = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void showWithBar(float paramFloat, CharSequence paramCharSequence) {
/*  87 */     show();
/*     */     
/*  89 */     this.g.setVisible(true);
/*  90 */     this.h.setVisible(true);
/*  91 */     this.h.setSize(320.0F * paramFloat, 5.0F);
/*     */     
/*  93 */     this.e.setVisible(true);
/*  94 */     this.e.setText(paramCharSequence);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/*  99 */     if (this.i) {
/* 100 */       this.a.getTable().setVisible(false);
/* 101 */       this.b.getTable().setVisible(false);
/* 102 */       this.g.setVisible(false);
/* 103 */       this.h.setVisible(false);
/* 104 */       this.e.setVisible(false);
/* 105 */       this.i = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\LoadingOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */