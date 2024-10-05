/*    */ package com.prineside.tdi2.scene2d.actions;
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
/*    */   private float d;
/*    */   
/*    */   protected final boolean a(float paramFloat) {
/* 25 */     if (this.c == null) return true; 
/* 26 */     return this.c.act(paramFloat * this.d);
/*    */   }
/*    */   
/*    */   public float getScale() {
/* 30 */     return this.d;
/*    */   }
/*    */   
/*    */   public void setScale(float paramFloat) {
/* 34 */     this.d = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\TimeScaleAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */