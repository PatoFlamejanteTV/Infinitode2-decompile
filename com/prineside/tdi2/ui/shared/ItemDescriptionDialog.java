/*     */ package com.prineside.tdi2.ui.shared;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.managers.UiManager;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.ui.actors.ItemCell;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.QuadActor;
/*     */ 
/*     */ public class ItemDescriptionDialog extends UiManager.UiComponent.Adapter {
/*     */   public static ItemDescriptionDialog i() {
/*  19 */     return (ItemDescriptionDialog)Game.i.uiManager.getComponent(ItemDescriptionDialog.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  24 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.OVERLAY, 203, "ItemDescriptionDialog main");
/*     */   
/*     */   private Group b;
/*     */   
/*     */   private ItemCell c;
/*     */   private Table d;
/*     */   
/*     */   public ItemDescriptionDialog() {
/*  32 */     this.b = new Group();
/*  33 */     this.b.setOrigin(487.5F, 118.5F);
/*  34 */     this.a.getTable().add((Actor)this.b).size(975.0F, 237.0F);
/*     */     
/*  36 */     QuadActor quadActor = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.28F), new float[] { 6.0F, 19.0F, 6.0F, 220.0F, 966.0F, 231.0F, 975.0F, 0.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     this.b.addActor((Actor)quadActor);
/*     */     
/*  44 */     quadActor = new QuadActor(MaterialColor.BLUE_GREY.P800, new float[] { 0.0F, 25.0F, 0.0F, 226.0F, 960.0F, 237.0F, 960.0F, 15.0F });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     this.b.addActor((Actor)quadActor);
/*     */ 
/*     */     
/*  53 */     this.c = new ItemCell();
/*  54 */     this.c.setPosition(40.0F, 56.0F);
/*  55 */     this.b.addActor((Actor)this.c);
/*     */     
/*  57 */     this.d = new Table();
/*  58 */     this.d.setPosition(210.0F, 56.0F);
/*  59 */     this.d.setSize(650.0F, 140.0F);
/*  60 */     this.b.addActor((Actor)this.d);
/*     */     
/*  62 */     this.a.getTable().setVisible(false);
/*     */   }
/*     */   
/*     */   public void show(Item paramItem) {
/*  66 */     showWithCount(paramItem, 0);
/*     */   }
/*     */   
/*     */   public void showWithCount(Item paramItem, int paramInt) {
/*  70 */     this.c.setItem(paramItem, paramInt);
/*     */     
/*  72 */     this.d.clear();
/*     */ 
/*     */     
/*  75 */     Label label2 = new Label(paramItem.getTitle(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(36), Color.WHITE));
/*  76 */     this.d.add((Actor)label2).top().left().width(650.0F).row();
/*     */     
/*     */     Label label1;
/*     */     
/*  80 */     (label1 = new Label(paramItem.getDescription(), new Label.LabelStyle((BitmapFont)Game.i.assetManager.getFont(30), Color.WHITE))).setColor(1.0F, 1.0F, 1.0F, 0.78F);
/*  81 */     label1.setWrap(true);
/*  82 */     this.d.add((Actor)label1).top().left().width(650.0F).row();
/*     */     
/*  84 */     this.a.getTable().setVisible(true);
/*  85 */     DarkOverlay.i().addCallerOverlayLayer("ItemDescriptionDialog", this.a.zIndex - 1, () -> {
/*     */           hide();
/*     */           return true;
/*     */         });
/*  89 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*     */     
/*  91 */     this.b.clearActions();
/*  92 */     this.b.addAction((Action)Actions.sequence(
/*  93 */           (Action)Actions.scaleTo(0.0F, 0.0F), 
/*  94 */           (Action)Actions.parallel(
/*  95 */             (Action)Actions.sequence(
/*  96 */               (Action)Actions.delay(0.1F * f), 
/*  97 */               (Action)Actions.scaleBy(1.0F, 0.0F, 0.3F * f, (Interpolation)Interpolation.swingOut)), 
/*     */             
/*  99 */             (Action)Actions.scaleBy(0.0F, 1.0F, 0.3F * f, (Interpolation)Interpolation.swingOut))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {
/* 106 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/* 107 */     DarkOverlay.i().removeCaller("ItemDescriptionDialog");
/*     */     
/* 109 */     this.b.clearActions();
/* 110 */     this.b.addAction((Action)Actions.sequence(
/* 111 */           (Action)Actions.parallel(
/* 112 */             (Action)Actions.sequence(
/* 113 */               (Action)Actions.delay(0.07F * f), 
/* 114 */               (Action)Actions.scaleBy(0.0F, -this.b.getScaleY(), 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*     */             
/* 116 */             (Action)Actions.scaleBy(-this.b.getScaleX(), 0.0F, 0.3F * f, (Interpolation)Interpolation.swingIn)), 
/*     */           
/* 118 */           (Action)Actions.run(() -> this.a.getTable().setVisible(false))));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\ItemDescriptionDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */