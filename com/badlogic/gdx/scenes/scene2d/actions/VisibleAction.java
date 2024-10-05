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
/*    */ 
/*    */ public class VisibleAction
/*    */   extends Action
/*    */ {
/*    */   private boolean visible;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 28 */     this.target.setVisible(this.visible);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isVisible() {
/* 33 */     return this.visible;
/*    */   }
/*    */   
/*    */   public void setVisible(boolean paramBoolean) {
/* 37 */     this.visible = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\VisibleAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */