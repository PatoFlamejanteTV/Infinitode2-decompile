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
/*    */ public class RepeatAction
/*    */   extends DelegateAction
/*    */ {
/*    */   public static final int FOREVER = -1;
/*    */   private int d;
/*    */   private int e;
/*    */   private boolean f;
/*    */   
/*    */   protected final boolean a(float paramFloat) {
/* 28 */     if (this.e == this.d) return true; 
/* 29 */     if (this.c.act(paramFloat)) {
/* 30 */       if (this.f) return true; 
/* 31 */       if (this.d > 0) this.e++; 
/* 32 */       if (this.e == this.d) return true; 
/* 33 */       if (this.c != null) this.c.restart(); 
/*    */     } 
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void finish() {
/* 40 */     this.f = true;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 44 */     super.restart();
/* 45 */     this.e = 0;
/* 46 */     this.f = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCount(int paramInt) {
/* 51 */     this.d = paramInt;
/*    */   }
/*    */   
/*    */   public int getCount() {
/* 55 */     return this.d;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\RepeatAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */