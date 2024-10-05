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
/*    */ public class RemoveActorAction
/*    */   extends Action
/*    */ {
/*    */   private boolean c;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 27 */     if (!this.c) {
/* 28 */       this.c = true;
/* 29 */       this.b.remove();
/*    */     } 
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 35 */     this.c = false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\RemoveActorAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */