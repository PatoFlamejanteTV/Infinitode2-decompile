/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.RightSideMenuButton;
/*     */ import com.prineside.tdi2.utils.InputVoid;
/*     */ 
/*     */ public class StorylineMessages implements Disposable {
/*  20 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 193, "StorylineMessages main");
/*  21 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 194, "StorylineMessages overlay");
/*  22 */   private final UiManager.UiLayer c = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 195, "StorylineMessages button");
/*  23 */   private final UiManager.UiLayer[] d = new UiManager.UiLayer[] { this.a, this.b, this.c };
/*     */   
/*     */   private boolean e;
/*     */   private float f;
/*     */   private Group g;
/*  28 */   private Array<String> h = new Array();
/*  29 */   private Array<Label> i = new Array();
/*     */   
/*     */   private Runnable j;
/*     */   private GameSystemProvider k;
/*     */   
/*     */   public StorylineMessages(GameSystemProvider paramGameSystemProvider) {
/*  35 */     this.k = paramGameSystemProvider;
/*     */ 
/*     */     
/*  38 */     this.a.getTable().setBackground(Game.i.assetManager.getOverlayBackground());
/*     */ 
/*     */     
/*  41 */     this.g = new Group();
/*  42 */     this.g.setWidth(1060.0F);
/*  43 */     this.g.setHeight(1.0F);
/*  44 */     this.a.getTable().add((Actor)this.g).expand().bottom().left().padLeft(40.0F).padRight(40.0F).padBottom(160.0F);
/*     */ 
/*     */ 
/*     */     
/*  48 */     this.b.getTable().setTouchable(Touchable.enabled);
/*  49 */     this.b.getTable().addListener((EventListener)new InputVoid());
/*     */     
/*     */     Image image;
/*  52 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-top"))).setColor(Config.BACKGROUND_COLOR);
/*  53 */     this.b.getTable().add((Actor)image).expand().fillX().height(760.0F).top().row();
/*     */ 
/*     */     
/*  56 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("gradient-bottom"))).setColor(Config.BACKGROUND_COLOR);
/*  57 */     this.b.getTable().add((Actor)image).expand().fillX().height(160.0F).bottom();
/*     */ 
/*     */     
/*  60 */     Table table = new Table();
/*  61 */     this.c.getTable().add((Actor)table).expand().bottom().right().padBottom(40.0F);
/*     */     
/*  63 */     table.add((Actor)new RightSideMenuButton(Game.i.localeManager.i18n.get("continue"), "icon-triangle-right", () -> a())); UiManager.UiLayer[] arrayOfUiLayer; int i; byte b;
/*  64 */     for (i = (arrayOfUiLayer = this.d).length, b = 0; b < i; b++) {
/*  65 */       UiManager.UiLayer uiLayer; (uiLayer = arrayOfUiLayer[b]).getTable().setVisible(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/*  75 */     if (this.h.size > 0) {
/*  76 */       a((String)this.h.removeIndex(0)); return;
/*     */     } 
/*  78 */     hide();
/*  79 */     if (this.j != null) {
/*  80 */       Runnable runnable = this.j;
/*  81 */       this.j = null;
/*  82 */       runnable.run();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void runOnContinue(Runnable paramRunnable) {
/*  91 */     this.j = paramRunnable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flushQueue() {
/*  98 */     while (this.h.size > 0) {
/*  99 */       a((String)this.h.removeIndex(0));
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(String paramString) {
/*     */     Label label;
/* 105 */     (label = new Label(paramString, new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE))).setWrap(true);
/* 106 */     label.setWidth(1060.0F);
/* 107 */     label.layout();
/* 108 */     label.pack();
/* 109 */     label.setWidth(1060.0F);
/* 110 */     this.i.add(label);
/*     */     
/* 112 */     label.addAction((Action)Actions.alpha(0.0F));
/*     */ 
/*     */     
/* 115 */     this.g.clearChildren();
/* 116 */     float f = 0.0F;
/* 117 */     for (int i = this.i.size - 1; i >= 0; i--) {
/*     */       Label label1;
/* 119 */       (label1 = (Label)this.i.get(i)).setPosition(0.0F, f);
/* 120 */       this.g.addActor((Actor)label1);
/*     */       
/* 122 */       if (i == this.i.size - 1) {
/*     */         
/* 124 */         label1.addAction((Action)Actions.alpha(1.0F, 0.3F));
/* 125 */         f += 16.0F;
/*     */       } else {
/*     */         
/* 128 */         label1.addAction((Action)Actions.alpha(0.56F));
/*     */       } 
/*     */       
/* 131 */       f += label1.getHeight();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void queue(String[] paramArrayOfString) {
/* 140 */     if (paramArrayOfString.length == 0)
/*     */       return; 
/* 142 */     this.h.addAll((Object[])paramArrayOfString);
/*     */     
/* 144 */     if (!this.e) {
/* 145 */       a((String)this.h.removeIndex(0));
/* 146 */       show();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(String paramString) {
/* 155 */     flushQueue();
/* 156 */     a(paramString);
/* 157 */     show();
/*     */   }
/*     */   
/*     */   public void show() {
/* 161 */     if (!this.e) {
/* 162 */       this.f = this.k.gameState.getNonAnimatedGameSpeed();
/* 163 */       this.k.gameState.setGameSpeed(0.0F); UiManager.UiLayer[] arrayOfUiLayer; int i;
/*     */       byte b;
/* 165 */       for (i = (arrayOfUiLayer = this.d).length, b = 0; b < i; b++) {
/* 166 */         UiManager.UiLayer uiLayer; (uiLayer = arrayOfUiLayer[b]).getTable().setVisible(true);
/* 167 */         uiLayer.getTable().clearActions();
/* 168 */         uiLayer.getTable().addAction((Action)Actions.sequence(
/* 169 */               (Action)Actions.alpha(1.0F, 0.3F)));
/*     */       } 
/*     */       
/* 172 */       this.e = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void hide() {
/* 177 */     if (this.e) {
/* 178 */       this.k.gameState.setGameSpeed(this.f); UiManager.UiLayer[] arrayOfUiLayer; int i;
/*     */       byte b;
/* 180 */       for (i = (arrayOfUiLayer = this.d).length, b = 0; b < i; b++) {
/* 181 */         UiManager.UiLayer uiLayer; (uiLayer = arrayOfUiLayer[b]).getTable().clearActions();
/* 182 */         uiLayer.getTable().addAction((Action)Actions.sequence(
/* 183 */               (Action)Actions.alpha(0.0F, 0.3F), 
/* 184 */               (Action)Actions.run(() -> paramUiLayer.getTable().setVisible(false))));
/*     */       } 
/*     */       
/* 187 */       this.e = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 193 */     Game.i.uiManager.removeLayer(this.a);
/* 194 */     Game.i.uiManager.removeLayer(this.b);
/* 195 */     Game.i.uiManager.removeLayer(this.c);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\StorylineMessages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */