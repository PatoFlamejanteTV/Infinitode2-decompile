/*    */ package com.prineside.tdi2.scene2d.actions;
/*    */ 
/*    */ import com.prineside.tdi2.scene2d.Action;
/*    */ import com.prineside.tdi2.scene2d.Touchable;
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
/*    */   private Touchable c;
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 29 */     this.b.setTouchable(this.c);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public Touchable getTouchable() {
/* 34 */     return this.c;
/*    */   }
/*    */   
/*    */   public void setTouchable(Touchable paramTouchable) {
/* 38 */     this.c = paramTouchable;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\TouchableAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */