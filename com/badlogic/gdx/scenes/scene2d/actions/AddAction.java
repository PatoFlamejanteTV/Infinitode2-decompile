/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Action;
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
/*    */ public class AddAction
/*    */   extends Action
/*    */ {
/*    */   private Action action;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 27 */     this.target.addAction(this.action);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public Action getAction() {
/* 32 */     return this.action;
/*    */   }
/*    */   
/*    */   public void setAction(Action paramAction) {
/* 36 */     this.action = paramAction;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 40 */     if (this.action != null) this.action.restart(); 
/*    */   }
/*    */   
/*    */   public void reset() {
/* 44 */     super.reset();
/* 45 */     this.action = null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\AddAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */