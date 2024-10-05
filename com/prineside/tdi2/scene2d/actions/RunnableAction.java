/*    */ package com.prineside.tdi2.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Pool;
/*    */ import com.prineside.tdi2.scene2d.Action;
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
/*    */   private Runnable c;
/*    */   private boolean d;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 30 */     if (!this.d) {
/* 31 */       this.d = true;
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
/* 42 */       this.c.run(); return;
/*    */     } finally {
/* 44 */       setPool(pool);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void restart() {
/* 49 */     this.d = false;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 53 */     super.reset();
/* 54 */     this.c = null;
/*    */   }
/*    */   
/*    */   public Runnable getRunnable() {
/* 58 */     return this.c;
/*    */   }
/*    */   
/*    */   public void setRunnable(Runnable paramRunnable) {
/* 62 */     this.c = paramRunnable;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\RunnableAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */