/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
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
/*    */ public class TimeScaleAction
/*    */   extends DelegateAction
/*    */ {
/*    */   private float scale;
/*    */   
/*    */   protected boolean delegate(float paramFloat) {
/* 25 */     if (this.action == null) return true; 
/* 26 */     return this.action.act(paramFloat * this.scale);
/*    */   }
/*    */   
/*    */   public float getScale() {
/* 30 */     return this.scale;
/*    */   }
/*    */   
/*    */   public void setScale(float paramFloat) {
/* 34 */     this.scale = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\TimeScaleAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */