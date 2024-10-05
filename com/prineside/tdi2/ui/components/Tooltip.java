/*    */ package com.prineside.tdi2.ui.components;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.utils.Disposable;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.managers.UiManager;
/*    */ import com.prineside.tdi2.scene2d.Action;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.Group;
/*    */ import com.prineside.tdi2.scene2d.actions.Actions;
/*    */ import com.prineside.tdi2.ui.actors.Label;
/*    */ import com.prineside.tdi2.ui.actors.QuadActor;
/*    */ 
/*    */ public class Tooltip implements Disposable {
/* 15 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 106, "Tooltip");
/*    */   
/*    */   private final Label b;
/*    */   private final Group c;
/*    */   
/*    */   public Tooltip() {
/* 21 */     this.c = new Group();
/* 22 */     this.c.setOrigin(240.0F, 48.0F);
/* 23 */     this.a.getTable().add((Actor)this.c).size(480.0F, 96.0F).expand().top().padTop(175.0F);
/*    */     
/* 25 */     QuadActor quadActor = new QuadActor(new Color(0.0F, 0.0F, 0.0F, 0.56F), new float[] { 16.0F, 0.0F, 0.0F, 96.0F, 480.0F, 96.0F, 464.0F, 0.0F });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 31 */     this.c.addActor((Actor)quadActor);
/*    */     
/* 33 */     this.b = new Label("", Game.i.assetManager.getLabelStyle(30));
/* 34 */     this.b.setSize(440.0F, 96.0F);
/* 35 */     this.b.setAlignment(1);
/* 36 */     this.b.setWrap(true);
/* 37 */     this.c.addActor((Actor)this.b);
/*    */     
/* 39 */     this.c.addAction((Action)Actions.alpha(0.0F));
/* 40 */     this.c.setVisible(false);
/*    */   }
/*    */   
/*    */   public void show(CharSequence paramCharSequence) {
/* 44 */     if (paramCharSequence.length() > 30) {
/* 45 */       this.b.setStyle(Game.i.assetManager.getLabelStyle(24));
/*    */     } else {
/* 47 */       this.b.setStyle(Game.i.assetManager.getLabelStyle(30));
/*    */     } 
/* 49 */     this.b.setText(paramCharSequence);
/*    */     
/* 51 */     this.c.clearActions();
/* 52 */     this.c.addAction((Action)Actions.sequence(
/* 53 */           (Action)Actions.show(), 
/* 54 */           (Action)Actions.parallel(
/* 55 */             (Action)Actions.sequence(
/* 56 */               (Action)Actions.scaleTo(1.1F, 1.1F, 0.1F), 
/* 57 */               (Action)Actions.scaleTo(1.0F, 1.0F, 0.1F)), 
/*    */             
/* 59 */             (Action)Actions.alpha(1.0F, 0.3F)), 
/*    */           
/* 61 */           (Action)Actions.delay(3.5F), 
/* 62 */           (Action)Actions.alpha(0.0F, 0.3F), 
/* 63 */           (Action)Actions.hide()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 69 */     Game.i.uiManager.removeLayer(this.a);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\Tooltip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */