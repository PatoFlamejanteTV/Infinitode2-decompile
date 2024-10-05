/*     */ package com.prineside.tdi2.ui.actors;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Image;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ 
/*     */ public class GameplayBonusSummary
/*     */   extends Group
/*     */ {
/*     */   public GameSystemProvider S;
/*     */   public Image iconShadow;
/*     */   public Image iconGlow;
/*     */   public Image icon;
/*     */   
/*     */   public GameplayBonusSummary(GameSystemProvider paramGameSystemProvider) {
/*  29 */     this.S = paramGameSystemProvider;
/*     */     
/*  31 */     setTransform(false);
/*  32 */     setSize(290.0F, 64.0F);
/*     */     
/*     */     Image image2;
/*  35 */     (image2 = new Image((Drawable)Game.i.assetManager.getQuad("ui.gameplayBonusSummary.progressBarBg"))).setPosition(55.0F, 5.0F);
/*  36 */     image2.setSize(240.0F, 16.0F);
/*  37 */     addActor((Actor)image2);
/*     */     
/*  39 */     this.bar = new Image((Drawable)Game.i.assetManager.getQuad("ui.gameplayBonusSummary.progressBar"));
/*  40 */     this.bar.setPosition(55.0F, 5.0F);
/*  41 */     this.bar.setSize(240.0F, 16.0F);
/*  42 */     addActor((Actor)this.bar);
/*     */     
/*  44 */     this.barParticles = new ParticlesCanvas();
/*     */     ParticleEffect particleEffect;
/*  46 */     (particleEffect = new ParticleEffect()).load(Gdx.files.internal("particles/gameplay-bonus-bar-ready.prt"), Game.i.assetManager.getTextureRegion("particle-default").getAtlas());
/*  47 */     particleEffect.setEmittersCleanUpBlendFunction(false);
/*  48 */     this.barParticles.addParticle(particleEffect, 0.0F, 0.0F);
/*  49 */     this.barParticles.setPosition(55.0F, 5.0F);
/*  50 */     this.barParticles.setSize(240.0F, 16.0F);
/*  51 */     addActor(this.barParticles);
/*     */     
/*  53 */     this.iconShadow = new Image((Drawable)Game.i.assetManager.getDrawable("icon-turbo"));
/*  54 */     this.iconShadow.setSize(64.0F, 64.0F);
/*  55 */     this.iconShadow.setPosition(3.0F, -3.0F);
/*  56 */     this.iconShadow.setColor(Config.BACKGROUND_COLOR.cpy().mul(1.0F, 1.0F, 1.0F, 0.56F));
/*  57 */     addActor((Actor)this.iconShadow);
/*     */     
/*  59 */     this.iconGlow = new Image((Drawable)Game.i.assetManager.getDrawable("icon-turbo"));
/*  60 */     this.iconGlow.setSize(64.0F, 64.0F);
/*  61 */     this.iconGlow.setVisible(false);
/*  62 */     this.iconGlow.setOrigin(32.0F, 32.0F);
/*  63 */     addActor((Actor)this.iconGlow);
/*     */     
/*  65 */     this.iconGlow.clearActions();
/*  66 */     this.iconGlow.addAction((Action)Actions.forever((Action)Actions.parallel(
/*  67 */             (Action)Actions.sequence(
/*  68 */               (Action)Actions.alpha(0.78F), 
/*  69 */               (Action)Actions.alpha(0.0F, 1.0F)), 
/*     */             
/*  71 */             (Action)Actions.sequence(
/*  72 */               (Action)Actions.scaleTo(1.0F, 1.0F), 
/*  73 */               (Action)Actions.scaleTo(1.3F, 1.3F, 1.0F)))));
/*     */ 
/*     */ 
/*     */     
/*  77 */     this.icon = new Image((Drawable)Game.i.assetManager.getDrawable("icon-turbo"));
/*  78 */     this.icon.setSize(64.0F, 64.0F);
/*  79 */     this.icon.setOrigin(32.0F, 32.0F);
/*  80 */     addActor((Actor)this.icon);
/*     */     
/*     */     Image image1;
/*  83 */     (image1 = new Image((Drawable)Game.i.assetManager.getDrawable("icon-skull"))).setSize(24.0F, 24.0F);
/*  84 */     image1.setPosition(70.0F, 26.0F);
/*  85 */     addActor((Actor)image1);
/*     */     
/*  87 */     this.objectiveLabel = new Label("120 / 150", Game.i.assetManager.getLabelStyle(21));
/*  88 */     this.objectiveLabel.setSize(100.0F, 24.0F);
/*  89 */     this.objectiveLabel.setPosition(100.0F, 26.0F);
/*  90 */     addActor((Actor)this.objectiveLabel);
/*     */     
/*  92 */     this.stageNumberLabel = new Label("1 / 1", Game.i.assetManager.getLabelStyle(18));
/*  93 */     this.stageNumberLabel.setSize(295.0F, 24.0F);
/*  94 */     this.stageNumberLabel.setPosition(0.0F, 26.0F);
/*  95 */     this.stageNumberLabel.setColor(new Color(1.0F, 1.0F, 1.0F, 0.28F));
/*  96 */     this.stageNumberLabel.setAlignment(16);
/*  97 */     addActor((Actor)this.stageNumberLabel);
/*     */     
/*  99 */     addListener((EventListener)new ClickListener(this, paramGameSystemProvider)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 102 */             this.a._gameUi.gameplayBonusesOverlay.show();
/*     */           }
/*     */         });
/*     */     
/* 106 */     update();
/*     */   }
/*     */   public Image bar; public ParticlesCanvas barParticles; public Label objectiveLabel; public Label stageNumberLabel;
/*     */   public void update() {
/* 110 */     if (this.S.bonus.isEnabled()) {
/*     */       int i;
/* 112 */       if ((i = this.S.bonus.getCurrentVisualProgressPoints()) < this.S.bonus.getNextStagePointsRequirement()) {
/* 113 */         this.objectiveLabel.setText(i + " / " + this.S.bonus.getNextStagePointsRequirement());
/*     */       }
/* 115 */       else if (this.S.bonus.bonusSelectionAvailable()) {
/* 116 */         this.objectiveLabel.setText("Boost available!");
/*     */       } else {
/* 118 */         this.objectiveLabel.setText("MAX");
/*     */       } 
/*     */ 
/*     */       
/* 122 */       if (this.S.bonus.getMaxBonusStages() > 0) {
/* 123 */         this.stageNumberLabel.setText(this.S.bonus.getCurrentVisualProgressStageNumber() + " / " + this.S.bonus.getMaxBonusStages());
/*     */       } else {
/* 125 */         this.stageNumberLabel.setTextFromInt(this.S.bonus.getCurrentVisualProgressStageNumber());
/*     */       } 
/*     */       
/* 128 */       float f = i / this.S.bonus.getNextStagePointsRequirement();
/* 129 */       if (i > 0) {
/* 130 */         this.bar.setWidth(f * 240.0F);
/* 131 */         this.bar.setVisible(true);
/*     */       } else {
/* 133 */         this.bar.setVisible(false);
/*     */       } 
/*     */       
/* 136 */       if (this.S.bonus.bonusSelectionAvailable()) {
/* 137 */         this.icon.setColor(Color.WHITE);
/* 138 */         this.iconGlow.setVisible(true);
/* 139 */         this.barParticles.setVisible(true); return;
/*     */       } 
/* 141 */       this.icon.setColor(MaterialColor.GREY.P500);
/* 142 */       this.iconGlow.setVisible(false);
/* 143 */       this.barParticles.setVisible(false);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\actors\GameplayBonusSummary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */