/*    */ package com.prineside.tdi2.managers;
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.Manager;
/*    */ import com.prineside.tdi2.enums.TriggeredActionType;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.Group;
/*    */ import com.prineside.tdi2.scene2d.ui.Image;
/*    */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ 
/*    */ @REGS(serializer = TriggeredActionManager.Serializer.class)
/*    */ public class TriggeredActionManager extends Manager.ManagerAdapter {
/* 16 */   private static final TLog a = TLog.forClass(TriggeredActionManager.class);
/*    */   
/*    */   public static class Serializer extends SingletonSerializer<TriggeredActionManager> {
/*    */     public TriggeredActionManager read() {
/* 20 */       return Game.i.triggeredActionManager;
/*    */     }
/*    */   }
/*    */   
/*    */   public void setup() {}
/*    */   
/*    */   public void perform(GameSystemProvider paramGameSystemProvider, TriggeredActionType paramTriggeredActionType, float paramFloat) {
/* 27 */     switch (null.a[paramTriggeredActionType.ordinal()]) {
/*    */       case 1:
/* 29 */         paramGameSystemProvider.gameState.addMoney(paramFloat, false);
/*    */         return;
/*    */     } 
/*    */     
/* 33 */     a.e("action not implemented: " + paramTriggeredActionType, new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTitleAlias(TriggeredActionType paramTriggeredActionType) {
/* 39 */     return "triggered_action_" + paramTriggeredActionType.name();
/*    */   }
/*    */   
/*    */   public Group generateIcon(TriggeredActionType paramTriggeredActionType, float paramFloat, Color paramColor) {
/*    */     Group group;
/* 44 */     (group = new Group()).setTransform(false);
/* 45 */     group.setSize(paramFloat, paramFloat);
/*    */     
/* 47 */     Image image = null;
/* 48 */     switch (null.a[paramTriggeredActionType.ordinal()]) {
/*    */       case 1:
/* 50 */         image = new Image((Drawable)Game.i.assetManager.getDrawable("icon-coins"));
/*    */         break;
/*    */     } 
/* 53 */     if (image != null) {
/* 54 */       image.setColor(paramColor);
/* 55 */       image.setSize(paramFloat, paramFloat);
/* 56 */       group.addActor((Actor)image);
/*    */     } 
/*    */     
/* 59 */     return group;
/*    */   }
/*    */   
/*    */   public void preRender(float paramFloat) {}
/*    */   
/*    */   public void postRender(float paramFloat) {}
/*    */   
/*    */   public void test() {}
/*    */   
/*    */   public void dispose() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\TriggeredActionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */