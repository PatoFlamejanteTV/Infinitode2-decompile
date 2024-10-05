/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Files;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.scenes.scene2d.Action;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.scenes.scene2d.actions.Actions;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Timer;
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
/*     */   private static TooltipManager instance;
/*     */   private static Files files;
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
/*  55 */   final Array<Tooltip> shown = new Array();
/*     */   
/*  57 */   float time = this.initialTime;
/*  58 */   final Timer.Task resetTask = new Timer.Task() {
/*     */       public void run() {
/*  60 */         TooltipManager.this.time = TooltipManager.this.initialTime;
/*     */       }
/*     */     };
/*     */   Tooltip showTooltip;
/*     */   
/*  65 */   final Timer.Task showTask = new Timer.Task() {
/*     */       public void run() {
/*  67 */         if (TooltipManager.this.showTooltip == null || TooltipManager.this.showTooltip.targetActor == null)
/*     */           return; 
/*     */         Stage stage;
/*  70 */         if ((stage = TooltipManager.this.showTooltip.targetActor.getStage()) == null)
/*  71 */           return;  stage.addActor((Actor)TooltipManager.this.showTooltip.container);
/*  72 */         TooltipManager.this.showTooltip.container.toFront();
/*  73 */         TooltipManager.this.shown.add(TooltipManager.this.showTooltip);
/*     */         
/*  75 */         TooltipManager.this.showTooltip.container.clearActions();
/*  76 */         TooltipManager.this.showAction(TooltipManager.this.showTooltip);
/*     */         
/*  78 */         if (!TooltipManager.this.showTooltip.instant) {
/*  79 */           TooltipManager.this.time = TooltipManager.this.subsequentTime;
/*  80 */           TooltipManager.this.resetTask.cancel();
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*     */   public void touchDown(Tooltip paramTooltip) {
/*  86 */     this.showTask.cancel();
/*  87 */     if (paramTooltip.container.remove()) this.resetTask.cancel(); 
/*  88 */     this.resetTask.run();
/*  89 */     if (this.enabled || paramTooltip.always) {
/*  90 */       this.showTooltip = paramTooltip;
/*  91 */       Timer.schedule(this.showTask, this.time);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enter(Tooltip paramTooltip) {
/*  96 */     this.showTooltip = paramTooltip;
/*  97 */     this.showTask.cancel();
/*  98 */     if (this.enabled || paramTooltip.always) {
/*  99 */       if (this.time == 0.0F || paramTooltip.instant) {
/* 100 */         this.showTask.run(); return;
/*     */       } 
/* 102 */       Timer.schedule(this.showTask, this.time);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void hide(Tooltip paramTooltip) {
/* 107 */     this.showTooltip = null;
/* 108 */     this.showTask.cancel();
/* 109 */     if (paramTooltip.container.hasParent()) {
/* 110 */       this.shown.removeValue(paramTooltip, true);
/* 111 */       hideAction(paramTooltip);
/* 112 */       this.resetTask.cancel();
/* 113 */       Timer.schedule(this.resetTask, this.resetTime);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void showAction(Tooltip paramTooltip) {
/* 119 */     float f = this.animations ? ((this.time > 0.0F) ? 0.5F : 0.15F) : 0.1F;
/* 120 */     paramTooltip.container.setTransform(true);
/* 121 */     (paramTooltip.container.getColor()).a = 0.2F;
/* 122 */     paramTooltip.container.setScale(0.05F);
/* 123 */     paramTooltip.container.addAction((Action)Actions.parallel((Action)Actions.fadeIn(f, Interpolation.fade), (Action)Actions.scaleTo(1.0F, 1.0F, f, Interpolation.fade)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hideAction(Tooltip paramTooltip) {
/* 129 */     paramTooltip.container
/* 130 */       .addAction((Action)Actions.sequence((Action)Actions.parallel((Action)Actions.alpha(0.2F, 0.2F, Interpolation.fade), (Action)Actions.scaleTo(0.05F, 0.05F, 0.2F, Interpolation.fade)), (Action)Actions.removeActor()));
/*     */   }
/*     */   
/*     */   public void hideAll() {
/* 134 */     this.resetTask.cancel();
/* 135 */     this.showTask.cancel();
/* 136 */     this.time = this.initialTime;
/* 137 */     this.showTooltip = null;
/*     */     
/* 139 */     for (Array.ArrayIterator<Tooltip> arrayIterator = this.shown.iterator(); arrayIterator.hasNext();)
/* 140 */       (tooltip = arrayIterator.next()).hide(); 
/* 141 */     this.shown.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void instant() {
/* 146 */     this.time = 0.0F;
/* 147 */     this.showTask.run();
/* 148 */     this.showTask.cancel();
/*     */   }
/*     */   
/*     */   public static TooltipManager getInstance() {
/* 152 */     if (files == null || files != Gdx.files) {
/* 153 */       files = Gdx.files;
/* 154 */       instance = new TooltipManager();
/*     */     } 
/* 156 */     return instance;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\TooltipManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */