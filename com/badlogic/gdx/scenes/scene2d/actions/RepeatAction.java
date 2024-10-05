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
/*    */ public class RepeatAction
/*    */   extends DelegateAction
/*    */ {
/*    */   public static final int FOREVER = -1;
/*    */   private int repeatCount;
/*    */   private int executedCount;
/*    */   private boolean finished;
/*    */   
/*    */   protected boolean delegate(float paramFloat) {
/* 28 */     if (this.executedCount == this.repeatCount) return true; 
/* 29 */     if (this.action.act(paramFloat)) {
/* 30 */       if (this.finished) return true; 
/* 31 */       if (this.repeatCount > 0) this.executedCount++; 
/* 32 */       if (this.executedCount == this.repeatCount) return true; 
/* 33 */       if (this.action != null) this.action.restart(); 
/*    */     } 
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void finish() {
/* 40 */     this.finished = true;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 44 */     super.restart();
/* 45 */     this.executedCount = 0;
/* 46 */     this.finished = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCount(int paramInt) {
/* 51 */     this.repeatCount = paramInt;
/*    */   }
/*    */   
/*    */   public int getCount() {
/* 55 */     return this.repeatCount;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\RepeatAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */