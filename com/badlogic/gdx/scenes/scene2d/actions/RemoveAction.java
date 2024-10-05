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
/*    */ public class RemoveAction
/*    */   extends Action
/*    */ {
/*    */   private Action action;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 27 */     this.target.removeAction(this.action);
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
/*    */   public void reset() {
/* 40 */     super.reset();
/* 41 */     this.action = null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\RemoveAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */