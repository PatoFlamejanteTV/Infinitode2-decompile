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
/*    */ 
/*    */ public class VisibleAction
/*    */   extends Action
/*    */ {
/*    */   private boolean c;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 28 */     this.b.setVisible(this.c);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isVisible() {
/* 33 */     return this.c;
/*    */   }
/*    */   
/*    */   public void setVisible(boolean paramBoolean) {
/* 37 */     this.c = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\VisibleAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */