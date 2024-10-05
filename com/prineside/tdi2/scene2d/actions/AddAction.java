/*    */ package com.prineside.tdi2.scene2d.actions;
/*    */ 
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
/*    */ public class AddAction
/*    */   extends Action
/*    */ {
/*    */   private Action c;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 27 */     this.b.addAction(this.c);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public Action getAction() {
/* 32 */     return this.c;
/*    */   }
/*    */   
/*    */   public void setAction(Action paramAction) {
/* 36 */     this.c = paramAction;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 40 */     if (this.c != null) this.c.restart(); 
/*    */   }
/*    */   
/*    */   public void reset() {
/* 44 */     super.reset();
/* 45 */     this.c = null;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\AddAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */