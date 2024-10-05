/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Action;
/*    */ import com.badlogic.gdx.scenes.scene2d.Touchable;
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
/*    */ public class TouchableAction
/*    */   extends Action
/*    */ {
/*    */   private Touchable touchable;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 29 */     this.target.setTouchable(this.touchable);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public Touchable getTouchable() {
/* 34 */     return this.touchable;
/*    */   }
/*    */   
/*    */   public void setTouchable(Touchable paramTouchable) {
/* 38 */     this.touchable = paramTouchable;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\TouchableAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */