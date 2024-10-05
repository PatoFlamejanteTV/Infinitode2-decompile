/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Action;
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AfterAction
/*    */   extends DelegateAction
/*    */ {
/* 26 */   private Array<Action> waitForActions = new Array(false, 4);
/*    */   
/*    */   public void setTarget(Actor paramActor) {
/* 29 */     if (paramActor != null) this.waitForActions.addAll(paramActor.getActions()); 
/* 30 */     super.setTarget(paramActor);
/*    */   }
/*    */   
/*    */   public void restart() {
/* 34 */     super.restart();
/* 35 */     this.waitForActions.clear();
/*    */   }
/*    */   
/*    */   protected boolean delegate(float paramFloat) {
/*    */     Array array;
/* 40 */     if ((array = this.target.getActions()).size == 1) this.waitForActions.clear(); 
/* 41 */     for (int i = this.waitForActions.size - 1; i >= 0; i--) {
/* 42 */       Action action = (Action)this.waitForActions.get(i);
/*    */       int j;
/* 44 */       if ((j = array.indexOf(action, true)) == -1) this.waitForActions.removeIndex(i); 
/*    */     } 
/* 46 */     if (this.waitForActions.size > 0) return false; 
/* 47 */     return this.action.act(paramFloat);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\AfterAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */