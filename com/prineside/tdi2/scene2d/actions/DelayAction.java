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
/*    */ public class DelayAction
/*    */   extends DelegateAction
/*    */ {
/*    */   private float d;
/*    */   private float e;
/*    */   
/*    */   public DelayAction() {}
/*    */   
/*    */   public DelayAction(float paramFloat) {
/* 28 */     this.d = paramFloat;
/*    */   }
/*    */   
/*    */   protected final boolean a(float paramFloat) {
/* 32 */     if (this.e < this.d) {
/* 33 */       this.e += paramFloat;
/* 34 */       if (this.e < this.d) return false; 
/* 35 */       paramFloat = this.e - this.d;
/*    */     } 
/* 37 */     if (this.c == null) return true; 
/* 38 */     return this.c.act(paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public void finish() {
/* 43 */     this.e = this.d;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 47 */     super.restart();
/* 48 */     this.e = 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getTime() {
/* 53 */     return this.e;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTime(float paramFloat) {
/* 58 */     this.e = paramFloat;
/*    */   }
/*    */   
/*    */   public float getDuration() {
/* 62 */     return this.d;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setDuration(float paramFloat) {
/* 67 */     this.d = paramFloat;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\DelayAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */