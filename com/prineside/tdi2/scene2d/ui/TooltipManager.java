/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Timer;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Stage;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
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
/*     */ public class TooltipManager
/*     */ {
/*     */   private static TooltipManager e;
/*     */   private static Files f;
/*  38 */   public float initialTime = 2.0F;
/*     */   
/*  40 */   public float subsequentTime = 0.0F;
/*     */   
/*  42 */   public float resetTime = 1.5F;
/*     */   
/*     */   public boolean enabled = true;
/*     */   
/*     */   public boolean animations = true;
/*     */   
/*  48 */   public float maxWidth = 2.1474836E9F;
/*     */   
/*  50 */   public float offsetX = 15.0F, offsetY = 19.0F;
/*     */ 
/*     */   
/*  53 */   public float edgeDistance = 7.0F;
/*     */   
/*  55 */   final Array<Tooltip> a = new Array();
/*     */   
/*  57 */   float b = this.initialTime;
/*  58 */   final Timer.Task c = new Timer.Task(this) {
/*     */       public void run() {
/*  60 */         this.a.b = this.a.initialTime;
/*     */       }
/*     */     };
/*     */   Tooltip d;
/*     */   
/*  65 */   private Timer.Task g = new Timer.Task(this) {
/*     */       public void run() {
/*  67 */         if (this.a.d == null || this.a.d.d == null)
/*     */           return; 
/*     */         Stage stage;
/*  70 */         if ((stage = this.a.d.d.getStage()) == null)
/*  71 */           return;  stage.addActor((Actor)this.a.d.a);
/*  72 */         this.a.d.a.toFront();
/*  73 */         this.a.a.add(this.a.d);
/*     */         
/*  75 */         this.a.d.a.clearActions();
/*  76 */         this.a.a(this.a.d);
/*     */         
/*  78 */         if (!this.a.d.b) {
/*  79 */           this.a.b = this.a.subsequentTime;
/*  80 */           this.a.c.cancel();
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*     */   public void touchDown(Tooltip paramTooltip) {
/*  86 */     this.g.cancel();
/*  87 */     if (paramTooltip.a.remove()) this.c.cancel(); 
/*  88 */     this.c.run();
/*  89 */     if (this.enabled || paramTooltip.c) {
/*  90 */       this.d = paramTooltip;
/*  91 */       Timer.schedule(this.g, this.b);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enter(Tooltip paramTooltip) {
/*  96 */     this.d = paramTooltip;
/*  97 */     this.g.cancel();
/*  98 */     if (this.enabled || paramTooltip.c) {
/*  99 */       if (this.b == 0.0F || paramTooltip.b) {
/* 100 */         this.g.run(); return;
/*     */       } 
/* 102 */       Timer.schedule(this.g, this.b);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void hide(Tooltip paramTooltip) {
/* 107 */     this.d = null;
/* 108 */     this.g.cancel();
/* 109 */     if (paramTooltip.a.hasParent()) {
/* 110 */       this.a.removeValue(paramTooltip, true);
/* 111 */       b(paramTooltip);
/* 112 */       this.c.cancel();
/* 113 */       Timer.schedule(this.c, this.resetTime);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(Tooltip paramTooltip) {
/* 119 */     float f = this.animations ? ((this.b > 0.0F) ? 0.5F : 0.15F) : 0.1F;
/* 120 */     paramTooltip.a.setTransform(true);
/* 121 */     (paramTooltip.a.getColor()).a = 0.2F;
/* 122 */     paramTooltip.a.setScale(0.05F);
/* 123 */     paramTooltip.a.addAction((Action)Actions.parallel((Action)Actions.fadeIn(f, Interpolation.fade), (Action)Actions.scaleTo(1.0F, 1.0F, f, Interpolation.fade)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void b(Tooltip paramTooltip) {
/* 129 */     paramTooltip.a
/* 130 */       .addAction((Action)Actions.sequence((Action)Actions.parallel((Action)Actions.alpha(0.2F, 0.2F, Interpolation.fade), (Action)Actions.scaleTo(0.05F, 0.05F, 0.2F, Interpolation.fade)), (Action)Actions.removeActor()));
/*     */   }
/*     */   
/*     */   public void hideAll() {
/* 134 */     this.c.cancel();
/* 135 */     this.g.cancel();
/* 136 */     this.b = this.initialTime;
/* 137 */     this.d = null;
/*     */     
/* 139 */     for (Array.ArrayIterator<Tooltip> arrayIterator = this.a.iterator(); arrayIterator.hasNext();)
/* 140 */       (tooltip = arrayIterator.next()).hide(); 
/* 141 */     this.a.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void instant() {
/* 146 */     this.b = 0.0F;
/* 147 */     this.g.run();
/* 148 */     this.g.cancel();
/*     */   }
/*     */   
/*     */   public static TooltipManager getInstance() {
/* 152 */     if (f == null || f != Gdx.files) {
/* 153 */       f = Gdx.files;
/* 154 */       e = new TooltipManager();
/*     */     } 
/* 156 */     return e;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\TooltipManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */