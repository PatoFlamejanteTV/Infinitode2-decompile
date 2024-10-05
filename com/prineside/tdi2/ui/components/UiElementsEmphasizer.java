/*     */ package com.prineside.tdi2.ui.components;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.utils.InputVoid;
/*     */ 
/*     */ public class UiElementsEmphasizer implements Disposable {
/*  23 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 120, "UiElementsEmphasizer background and labels");
/*  24 */   private final UiManager.UiLayer b = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 121, "UiElementsEmphasizer element");
/*     */   
/*     */   private Group c;
/*     */   
/*     */   private Label d;
/*     */   private Label e;
/*  30 */   private static final Vector2 f = new Vector2();
/*     */   
/*     */   private boolean g;
/*     */   
/*     */   private Actor h;
/*     */   private Rectangle i;
/*     */   private float j;
/*     */   private float k;
/*     */   private boolean l;
/*     */   private Touchable m;
/*     */   private Group n;
/*     */   private Runnable o;
/*     */   private float p;
/*     */   private final GameSystemProvider q;
/*     */   
/*     */   public UiElementsEmphasizer(GameSystemProvider paramGameSystemProvider) {
/*  46 */     this.q = paramGameSystemProvider;
/*     */ 
/*     */     
/*  49 */     this.a.getTable().setBackground(Game.i.assetManager.getOverlayBackground());
/*     */ 
/*     */     
/*  52 */     this.d = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  53 */     this.d.setAlignment(1);
/*  54 */     this.a.getTable().add((Actor)this.d).size(100.0F, 40.0F).padTop(700.0F).row();
/*     */     
/*  56 */     this.e = new Label("", new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE));
/*  57 */     this.e.setAlignment(1);
/*  58 */     this.e.setWrap(true);
/*  59 */     this.a.getTable().add((Actor)this.e).width(1200.0F).row();
/*     */     
/*     */     Label label;
/*  62 */     (label = new Label(Game.i.localeManager.i18n.get("tap_screen_to_continue"), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(24), Color.WHITE))).setAlignment(1);
/*  63 */     label.setColor(1.0F, 1.0F, 1.0F, 0.56F);
/*  64 */     this.a.getTable().add((Actor)label).size(100.0F, 40.0F).padTop(160.0F).row();
/*     */ 
/*     */     
/*  67 */     this.b.getTable().setTouchable(Touchable.enabled);
/*  68 */     this.b.getTable().addListener((EventListener)new InputVoid());
/*  69 */     this.b.getTable().addListener((EventListener)new InputListener(this)
/*     */         {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  72 */             this.a.hide(false);
/*  73 */             return true;
/*     */           }
/*     */         });
/*     */     
/*  77 */     this.c = new Group();
/*  78 */     this.b.getTable().add((Actor)this.c).size(1.0F);
/*     */     
/*  80 */     this.a.getTable().addAction((Action)Actions.alpha(0.0F));
/*  81 */     this.a.getTable().setVisible(false);
/*  82 */     this.b.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   public void show(Actor paramActor, Rectangle paramRectangle, String paramString1, String paramString2, Runnable paramRunnable) {
/*  86 */     if (this.g) {
/*  87 */       hide(true);
/*     */     }
/*     */     
/*  90 */     this.p = this.q.gameState.getNonAnimatedGameSpeed();
/*  91 */     this.q.gameState.setGameSpeed(0.0F);
/*     */     
/*  93 */     this.a.getTable().setVisible(true);
/*  94 */     this.a.getTable().clearActions();
/*  95 */     this.a.getTable().addAction((Action)Actions.alpha(1.0F, 0.3F));
/*  96 */     this.b.getTable().setVisible(true);
/*     */     
/*  98 */     this.d.setText(paramString1);
/*  99 */     this.e.setText(paramString2);
/*     */     
/* 101 */     this.g = true;
/* 102 */     this.h = paramActor;
/* 103 */     this.i = paramRectangle;
/* 104 */     this.o = paramRunnable;
/*     */     
/* 106 */     float f1 = Game.i.uiManager.stage.getWidth() / 2.0F;
/* 107 */     float f2 = Game.i.uiManager.stage.getHeight() / 2.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     if (paramActor.getParent() != null) {
/* 116 */       f.set(paramRectangle.x, paramRectangle.y);
/* 117 */       paramActor.getParent().localToStageCoordinates(f);
/* 118 */       this.j = f.x - f1;
/* 119 */       this.k = f.y - f2;
/* 120 */       this.n = paramActor.getParent();
/* 121 */       this.n.removeActor(paramActor);
/*     */     } else {
/* 123 */       this.j = 0.0F;
/* 124 */       this.k = 0.0F;
/* 125 */       this.n = null;
/*     */     } 
/*     */     
/* 128 */     this.c.addActor(paramActor);
/* 129 */     paramActor.setVisible(true);
/* 130 */     paramActor.setScale(0.0F);
/* 131 */     paramActor.setPosition(-paramRectangle.width * 0.5F, -paramRectangle.height * 0.5F);
/*     */     
/* 133 */     this.l = false;
/* 134 */     if (paramActor instanceof Group) {
/* 135 */       this.l = ((Group)paramActor).isTransform();
/* 136 */       ((Group)paramActor).setTransform(true);
/*     */     } 
/* 138 */     this.m = paramActor.getTouchable();
/* 139 */     paramActor.setTouchable(Touchable.disabled);
/*     */     
/* 141 */     paramActor.addAction((Action)Actions.scaleTo(1.5F, 1.5F, 0.75F, (Interpolation)Interpolation.swingOut));
/*     */   }
/*     */   
/*     */   public void hide(boolean paramBoolean) {
/* 145 */     if (!this.g)
/*     */       return; 
/* 147 */     this.q.gameState.setGameSpeed(this.p);
/* 148 */     this.g = false;
/*     */     
/* 150 */     this.a.getTable().clearActions();
/* 151 */     this.a.getTable().addAction((Action)Actions.sequence(
/* 152 */           (Action)Actions.alpha(0.0F, 0.5F), 
/* 153 */           (Action)Actions.hide()));
/*     */ 
/*     */     
/* 156 */     this.h.clearActions();
/* 157 */     if (paramBoolean)
/* 158 */     { this.c.removeActor(this.h);
/* 159 */       if (this.n != null) this.n.addActor(this.h); 
/* 160 */       this.h.setScale(1.0F);
/* 161 */       this.h.setPosition(this.i.x, this.i.y);
/* 162 */       if (this.h instanceof Group) ((Group)this.h).setTransform(this.l); 
/* 163 */       this.h.setTouchable(this.m);
/*     */       
/* 165 */       this.h = null;
/* 166 */       this.n = null;
/* 167 */       this.b.getTable().setVisible(false);
/*     */       
/* 169 */       if (this.o != null) { this.o.run(); return; }
/*     */        }
/* 171 */     else { this.h.addAction((Action)Actions.sequence(
/* 172 */             (Action)Actions.parallel(
/* 173 */               (Action)Actions.scaleTo(1.0F, 1.0F, 0.5F), 
/* 174 */               (Action)Actions.moveTo(this.j, this.k, 0.5F, (Interpolation)Interpolation.pow2)), 
/*     */             
/* 176 */             (Action)Actions.run(() -> {
/*     */                 this.c.removeActor(this.h);
/*     */                 if (this.n != null) {
/*     */                   this.n.addActor(this.h);
/*     */                 }
/*     */                 this.h.setPosition(this.i.x, this.i.y);
/*     */                 if (this.h instanceof Group) {
/*     */                   ((Group)this.h).setTransform(this.l);
/*     */                 }
/*     */                 this.h.setTouchable(this.m);
/*     */                 this.h = null;
/*     */                 this.n = null;
/*     */                 this.b.getTable().setVisible(false);
/*     */                 if (this.o != null)
/*     */                   this.o.run(); 
/*     */               }))); }
/*     */   
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 196 */     Game.i.uiManager.removeLayer(this.b);
/* 197 */     Game.i.uiManager.removeLayer(this.a);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\UiElementsEmphasizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */