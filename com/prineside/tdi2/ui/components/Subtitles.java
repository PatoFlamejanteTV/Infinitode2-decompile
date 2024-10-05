/*    */ package com.prineside.tdi2.ui.components;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*    */ import com.badlogic.gdx.utils.Disposable;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.managers.UiManager;
/*    */ import com.prineside.tdi2.scene2d.Action;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.Touchable;
/*    */ import com.prineside.tdi2.scene2d.actions.Actions;
/*    */ import com.prineside.tdi2.scene2d.ui.Table;
/*    */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*    */ import com.prineside.tdi2.ui.actors.Label;
/*    */ 
/*    */ public class Subtitles implements Disposable {
/* 17 */   private final UiManager.UiLayer a = Game.i.uiManager.addLayer(UiManager.MainUiLayer.SCREEN, 104, "Subtitles main");
/*    */   
/*    */   private Drawable b;
/*    */   
/*    */   private Table c;
/* 22 */   private DelayedRemovalArray<ScheduledMessage> d = new DelayedRemovalArray(ScheduledMessage.class);
/*    */   
/*    */   public Subtitles() {
/* 25 */     this.b = Game.i.assetManager.getDrawable("blank").tint(new Color(0.0F, 0.0F, 0.0F, 0.56F));
/*    */     
/* 27 */     this.c = new Table();
/* 28 */     this.a.getTable().setTouchable(Touchable.disabled);
/* 29 */     this.a.getTable().add((Actor)this.c).fillX().expandX().expandY().bottom().right().padLeft(288.0F).padBottom(144.0F);
/*    */   }
/*    */   
/*    */   public void finalFadeOut() {
/* 33 */     float f = Game.i.settingsManager.isUiAnimationsEnabled() ? 1.0F : 0.0F;
/*    */     
/* 35 */     this.a.getTable().setTouchable(Touchable.disabled);
/* 36 */     this.a.getTable().clearActions();
/* 37 */     this.a.getTable().addAction((Action)Actions.alpha(0.0F, f * 1.0F));
/*    */   }
/*    */   
/*    */   public void schedule(CharSequence[] paramArrayOfCharSequence, float paramFloat1, float paramFloat2) {
/* 41 */     for (byte b = 0; b < paramArrayOfCharSequence.length; b++) {
/*    */       ScheduledMessage scheduledMessage;
/* 43 */       (scheduledMessage = new ScheduledMessage((byte)0)).a = paramArrayOfCharSequence[b];
/* 44 */       scheduledMessage.b = paramFloat1 + paramFloat2 * b;
/* 45 */       this.d.add(scheduledMessage);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void add(CharSequence paramCharSequence) {
/*    */     Table table;
/* 51 */     (table = new Table()).setBackground(this.b);
/* 52 */     this.c.add((Actor)table).fillX().expandX().padTop(4.0F).row();
/*    */     
/*    */     Label label;
/* 55 */     (label = new Label(paramCharSequence, Game.i.assetManager.getLabelStyle(30))).setAlignment(8);
/* 56 */     label.setWrap(true);
/* 57 */     table.add((Actor)label).pad(4.0F).padRight(120.0F).expand().fill();
/*    */     
/* 59 */     table.addAction((Action)Actions.sequence(
/* 60 */           (Action)Actions.alpha(0.0F), 
/* 61 */           (Action)Actions.fadeIn(0.3F), 
/* 62 */           (Action)Actions.delay(7.0F), 
/* 63 */           (Action)Actions.fadeOut(2.0F), 
/* 64 */           (Action)Actions.removeActor()));
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(float paramFloat) {
/* 69 */     this.d.begin();
/* 70 */     for (byte b = 0; b < this.d.size; b++) {
/*    */       ScheduledMessage scheduledMessage;
/* 72 */       (scheduledMessage = ((ScheduledMessage[])this.d.items)[b]).b -= paramFloat;
/* 73 */       if (scheduledMessage.b <= 0.0F) {
/* 74 */         add(scheduledMessage.a);
/* 75 */         this.d.removeIndex(b);
/*    */       } 
/*    */     } 
/* 78 */     this.d.end();
/*    */   }
/*    */ 
/*    */   
/*    */   public void dispose() {
/* 83 */     Game.i.uiManager.removeLayer(this.a);
/*    */   }
/*    */   
/*    */   private class ScheduledMessage {
/*    */     CharSequence a;
/*    */     float b;
/*    */     
/*    */     private ScheduledMessage(Subtitles this$0) {}
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\components\Subtitles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */