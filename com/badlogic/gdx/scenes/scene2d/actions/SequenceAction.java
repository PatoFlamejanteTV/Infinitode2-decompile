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
/*    */ public class SequenceAction
/*    */   extends ParallelAction
/*    */ {
/*    */   private int index;
/*    */   
/*    */   public SequenceAction() {}
/*    */   
/*    */   public SequenceAction(Action paramAction) {
/* 31 */     addAction(paramAction);
/*    */   }
/*    */   
/*    */   public SequenceAction(Action paramAction1, Action paramAction2) {
/* 35 */     addAction(paramAction1);
/* 36 */     addAction(paramAction2);
/*    */   }
/*    */   
/*    */   public SequenceAction(Action paramAction1, Action paramAction2, Action paramAction3) {
/* 40 */     addAction(paramAction1);
/* 41 */     addAction(paramAction2);
/* 42 */     addAction(paramAction3);
/*    */   }
/*    */   
/*    */   public SequenceAction(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4) {
/* 46 */     addAction(paramAction1);
/* 47 */     addAction(paramAction2);
/* 48 */     addAction(paramAction3);
/* 49 */     addAction(paramAction4);
/*    */   }
/*    */   
/*    */   public SequenceAction(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4, Action paramAction5) {
/* 53 */     addAction(paramAction1);
/* 54 */     addAction(paramAction2);
/* 55 */     addAction(paramAction3);
/* 56 */     addAction(paramAction4);
/* 57 */     addAction(paramAction5);
/*    */   }
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 61 */     if (this.index >= this.actions.size) return true; 
/* 62 */     Pool pool = getPool();
/* 63 */     setPool(null);
/*    */     try {
/* 65 */       if (((Action)this.actions.get(this.index)).act(paramFloat)) {
/* 66 */         if (this.actor == null) return true; 
/* 67 */         this.index++;
/* 68 */         if (this.index >= this.actions.size) return true; 
/*    */       } 
/* 70 */       return false;
/*    */     } finally {
/* 72 */       setPool(pool);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void restart() {
/* 77 */     super.restart();
/* 78 */     this.index = 0;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\SequenceAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */