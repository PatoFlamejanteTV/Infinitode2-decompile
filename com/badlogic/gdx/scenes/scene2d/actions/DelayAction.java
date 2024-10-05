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
/*    */ public class DelayAction
/*    */   extends DelegateAction
/*    */ {
/*    */   private float duration;
/*    */   private float time;
/*    */   
/*    */   public DelayAction() {}
/*    */   
/*    */   public DelayAction(float paramFloat) {
/* 28 */     this.duration = paramFloat;
/*    */   }
/*    */   
/*    */   protected boolean delegate(float paramFloat) {
/* 32 */     if (this.time < this.duration) {
/* 33 */       this.time += paramFloat;
/* 34 */       if (this.time < this.duration) return false; 
/* 35 */       paramFloat = this.time - this.duration;
/*    */     } 
/* 37 */     if (this.action == null) return true; 
/* 38 */     return this.action.act(paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public void finish() {
/* 43 */     this.time = this.duration;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 47 */     super.restart();
/* 48 */     this.time = 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getTime() {
/* 53 */     return this.time;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTime(float paramFloat) {
/* 58 */     this.time = paramFloat;
/*    */   }
/*    */   
/*    */   public float getDuration() {
/* 62 */     return this.duration;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setDuration(float paramFloat) {
/* 67 */     this.duration = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\DelayAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */