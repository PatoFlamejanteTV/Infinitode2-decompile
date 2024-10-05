/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Action;
/*    */ import com.badlogic.gdx.utils.Pool;
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
/*    */ public class RunnableAction
/*    */   extends Action
/*    */ {
/*    */   private Runnable runnable;
/*    */   private boolean ran;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 30 */     if (!this.ran) {
/* 31 */       this.ran = true;
/* 32 */       run();
/*    */     } 
/* 34 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 39 */     Pool pool = getPool();
/* 40 */     setPool(null);
/*    */     try {
/* 42 */       this.runnable.run(); return;
/*    */     } finally {
/* 44 */       setPool(pool);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void restart() {
/* 49 */     this.ran = false;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 53 */     super.reset();
/* 54 */     this.runnable = null;
/*    */   }
/*    */   
/*    */   public Runnable getRunnable() {
/* 58 */     return this.runnable;
/*    */   }
/*    */   
/*    */   public void setRunnable(Runnable paramRunnable) {
/* 62 */     this.runnable = paramRunnable;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\RunnableAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */