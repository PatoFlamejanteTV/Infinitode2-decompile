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
/*    */ public class RemoveActorAction
/*    */   extends Action
/*    */ {
/*    */   private boolean removed;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 27 */     if (!this.removed) {
/* 28 */       this.removed = true;
/* 29 */       this.target.remove();
/*    */     } 
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 35 */     this.removed = false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\RemoveActorAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */