/*    */ package com.prineside.tdi2.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.scene2d.Action;
/*    */ import com.prineside.tdi2.scene2d.Actor;
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
/* 26 */   private Array<Action> d = new Array(false, 4);
/*    */   
/*    */   public void setTarget(Actor paramActor) {
/* 29 */     if (paramActor != null) this.d.addAll(paramActor.getActions()); 
/* 30 */     super.setTarget(paramActor);
/*    */   }
/*    */   
/*    */   public void restart() {
/* 34 */     super.restart();
/* 35 */     this.d.clear();
/*    */   }
/*    */   
/*    */   protected final boolean a(float paramFloat) {
/*    */     Array array;
/* 40 */     if ((array = this.b.getActions()).size == 1) this.d.clear(); 
/* 41 */     for (int i = this.d.size - 1; i >= 0; i--) {
/* 42 */       Action action = (Action)this.d.get(i);
/*    */       int j;
/* 44 */       if ((j = array.indexOf(action, true)) == -1) this.d.removeIndex(i); 
/*    */     } 
/* 46 */     if (this.d.size > 0) return false; 
/* 47 */     return this.c.act(paramFloat);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\AfterAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */