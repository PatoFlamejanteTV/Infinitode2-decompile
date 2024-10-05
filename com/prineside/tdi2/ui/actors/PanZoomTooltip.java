/*     */ package com.prineside.tdi2.ui.actors;
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class PanZoomTooltip implements Disposable {
/*  23 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 150, "PanZoomTooltip");
/*     */   
/*     */   private final FingerActor b;
/*     */   
/*     */   private final FingerActor c;
/*     */   private final FingerActor d;
/*     */   private Label e;
/*     */   private Label f;
/*     */   private Group g;
/*     */   
/*     */   public PanZoomTooltip() {
/*     */     Group group;
/*  35 */     (group = new Group()).setTransform(false);
/*  36 */     this.a.getTable().add((Actor)group).size(800.0F, 400.0F);
/*     */     
/*  38 */     this.a.getTable().setBackground(Game.i.assetManager.getOverlayBackground());
/*  39 */     this.a.getTable().setTouchable(Touchable.enabled);
/*  40 */     this.a.getTable().addListener((EventListener)new InputVoid());
/*  41 */     this.a.getTable().addListener((EventListener)new InputListener(this)
/*     */         {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  44 */             this.a.hide();
/*  45 */             Game.i.soundManager.playStatic(StaticSoundType.BUTTON);
/*  46 */             return true;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  51 */     this.b = new FingerActor((byte)0);
/*  52 */     group.addActor((Actor)this.b);
/*     */     
/*  54 */     this.e = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  55 */     this.e.setPosition(0.0F, 0.0F);
/*  56 */     this.e.setSize(400.0F, 50.0F);
/*  57 */     this.e.setAlignment(1);
/*  58 */     group.addActor((Actor)this.e);
/*     */ 
/*     */     
/*  61 */     this.c = new FingerActor((byte)0);
/*  62 */     group.addActor((Actor)this.c);
/*  63 */     this.d = new FingerActor((byte)0);
/*  64 */     group.addActor((Actor)this.d);
/*     */     
/*  66 */     this.f = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  67 */     this.f.setPosition(400.0F, 0.0F);
/*  68 */     this.f.setSize(400.0F, 50.0F);
/*  69 */     this.f.setAlignment(1);
/*  70 */     group.addActor((Actor)this.f);
/*     */     
/*  72 */     this.g = new Group();
/*  73 */     this.g.setTransform(false);
/*  74 */     this.g.setVisible(false);
/*  75 */     this.g.setSize(400.0F, 300.0F);
/*  76 */     this.g.setPosition(400.0F, 100.0F);
/*  77 */     group.addActor((Actor)this.g);
/*     */     
/*     */     Image image;
/*  80 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-mouse-wheel"))).setSize(96.0F, 96.0F);
/*  81 */     image.setPosition(152.0F, 82.0F);
/*  82 */     image.setColor(MaterialColor.LIGHT_BLUE.P300);
/*  83 */     this.g.addActor((Actor)image);
/*     */ 
/*     */     
/*  86 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-triangle-top-hollow"))).setSize(64.0F, 64.0F);
/*  87 */     image.setPosition(168.0F, 178.0F);
/*  88 */     image.addAction((Action)Actions.forever(
/*  89 */           (Action)Actions.sequence(
/*  90 */             (Action)Actions.moveTo(168.0F, 226.0F, 1.25F, (Interpolation)Interpolation.pow2), 
/*  91 */             (Action)Actions.fadeOut(0.3F), 
/*  92 */             (Action)Actions.moveTo(168.0F, 178.0F), 
/*  93 */             (Action)Actions.fadeIn(0.3F))));
/*     */ 
/*     */     
/*  96 */     image.setColor(MaterialColor.LIGHT_BLUE.P500);
/*  97 */     this.g.addActor((Actor)image);
/*     */ 
/*     */     
/* 100 */     (image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-triangle-bottom-hollow"))).setSize(64.0F, 64.0F);
/* 101 */     image.setPosition(168.0F, 18.0F);
/* 102 */     image.setColor(MaterialColor.LIGHT_BLUE.P500);
/* 103 */     image.addAction((Action)Actions.forever(
/* 104 */           (Action)Actions.sequence(
/* 105 */             (Action)Actions.moveTo(168.0F, -30.0F, 1.25F, (Interpolation)Interpolation.pow2), 
/* 106 */             (Action)Actions.fadeOut(0.3F), 
/* 107 */             (Action)Actions.moveTo(168.0F, 18.0F), 
/* 108 */             (Action)Actions.fadeIn(0.3F))));
/*     */ 
/*     */     
/* 111 */     this.g.addActor((Actor)image);
/*     */     
/* 113 */     this.a.getTable().setVisible(false);
/* 114 */     hide();
/*     */   }
/*     */   
/*     */   public void show() {
/* 118 */     this.e.setText(Game.i.localeManager.i18n.get("screen_pan"));
/* 119 */     this.f.setText(Game.i.localeManager.i18n.get("screen_zoom"));
/*     */     
/* 121 */     this.b.clearActions();
/* 122 */     this.b.addAction((Action)Actions.forever(
/* 123 */           (Action)Actions.sequence(
/* 124 */             (Action)Actions.run(() -> {
/*     */                 FingerActor.a(this.b).stop();
/*     */                 
/*     */                 this.b.setPosition(50.0F, 100.0F);
/* 128 */               }), (Action)Actions.alpha(1.0F, 0.1F), 
/* 129 */             (Action)Actions.moveTo(350.0F, 350.0F, 1.25F, (Interpolation)Interpolation.pow2), 
/* 130 */             (Action)Actions.alpha(0.0F, 0.5F), 
/* 131 */             (Action)Actions.delay(0.3F))));
/*     */ 
/*     */ 
/*     */     
/* 135 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/* 136 */       this.c.setVisible(false);
/* 137 */       this.d.setVisible(false);
/*     */       
/* 139 */       this.g.setVisible(true);
/*     */     }
/*     */     else {
/*     */       
/* 143 */       this.c.clearActions();
/* 144 */       this.c.setPosition(630.0F, 250.0F);
/* 145 */       this.c.addAction((Action)Actions.forever(
/* 146 */             (Action)Actions.sequence(new Action[] {
/* 147 */                 (Action)Actions.run(() -> {
/*     */                   
/* 149 */                   }), (Action)Actions.moveTo(750.0F, 350.0F, 1.25F, (Interpolation)Interpolation.pow2), 
/* 150 */                 (Action)Actions.alpha(0.0F, 0.5F), 
/* 151 */                 (Action)Actions.delay(0.3F), 
/* 152 */                 (Action)Actions.alpha(1.0F, 0.1F), 
/* 153 */                 (Action)Actions.run(() -> {
/*     */                   
/* 155 */                   }), (Action)Actions.moveTo(630.0F, 250.0F, 1.25F, (Interpolation)Interpolation.pow2), 
/* 156 */                 (Action)Actions.alpha(0.0F, 0.5F), 
/* 157 */                 (Action)Actions.delay(0.3F), 
/* 158 */                 (Action)Actions.alpha(1.0F, 0.1F)
/*     */               })));
/*     */       
/* 161 */       this.d.clearActions();
/* 162 */       this.d.setPosition(570.0F, 200.0F);
/* 163 */       this.d.addAction((Action)Actions.forever(
/* 164 */             (Action)Actions.sequence(new Action[] {
/* 165 */                 (Action)Actions.run(() -> {
/*     */                   
/* 167 */                   }), (Action)Actions.moveTo(450.0F, 100.0F, 1.25F, (Interpolation)Interpolation.pow2), 
/* 168 */                 (Action)Actions.alpha(0.0F, 0.5F), 
/* 169 */                 (Action)Actions.delay(0.3F), 
/* 170 */                 (Action)Actions.alpha(1.0F, 0.1F), 
/* 171 */                 (Action)Actions.run(() -> {
/*     */                   
/* 173 */                   }), (Action)Actions.moveTo(570.0F, 200.0F, 1.25F, (Interpolation)Interpolation.pow2), 
/* 174 */                 (Action)Actions.alpha(0.0F, 0.5F), 
/* 175 */                 (Action)Actions.delay(0.3F), 
/* 176 */                 (Action)Actions.alpha(1.0F, 0.1F)
/*     */               })));
/*     */     } 
/*     */ 
/*     */     
/* 181 */     this.a.getTable().setVisible(true);
/* 182 */     this.a.getTable().clearActions();
/* 183 */     this.a.getTable().addAction((Action)Actions.alpha(1.0F, 0.3F));
/*     */   }
/*     */   
/*     */   public void hide() {
/* 187 */     this.b.clearActions();
/* 188 */     this.c.clearActions();
/* 189 */     this.d.clearActions();
/*     */     
/* 191 */     this.a.getTable().clearActions();
/* 192 */     this.a.getTable().addAction((Action)Actions.sequence(
/* 193 */           (Action)Actions.alpha(0.0F, 0.3F), 
/* 194 */           (Action)Actions.run(() -> this.a.getTable().setVisible(false))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 200 */     Game.i.uiManager.removeLayer(this.a);
/* 201 */     this.b.dispose();
/* 202 */     this.c.dispose();
/* 203 */     this.d.dispose();
/*     */   }
/*     */   
/*     */   private class FingerActor extends Group implements Disposable {
/*     */     private TrailMultilineActor k;
/*     */     
/*     */     private FingerActor(PanZoomTooltip this$0) {
/* 210 */       setTransform(false);
/* 211 */       setSize(1.0F, 1.0F);
/*     */       
/* 213 */       this.k = new TrailMultilineActor();
/* 214 */       this.k.setup(MaterialColor.LIGHT_BLUE.P500, 32.0F, 0.5F, 0.0F);
/* 215 */       addActor((Actor)this.k);
/*     */       
/*     */       Image image;
/* 218 */       (image = new Image((Drawable)Game.i.assetManager.getDrawable("circle"))).setPosition(-16.0F, -16.0F);
/* 219 */       image.setSize(32.0F, 32.0F);
/* 220 */       image.setColor(MaterialColor.LIGHT_BLUE.P500);
/* 221 */       addActor((Actor)image);
/*     */     }
/*     */ 
/*     */     
/*     */     public void dispose() {
/* 226 */       this.k.dispose();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\PanZoomTooltip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */