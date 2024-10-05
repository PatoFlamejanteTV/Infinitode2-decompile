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
/*    */ public abstract class RelativeTemporalAction
/*    */   extends TemporalAction
/*    */ {
/*    */   private float c;
/*    */   
/*    */   protected final void a() {
/* 25 */     this.c = 0.0F;
/*    */   }
/*    */   
/*    */   protected final void a(float paramFloat) {
/* 29 */     b(paramFloat - this.c);
/* 30 */     this.c = paramFloat;
/*    */   }
/*    */   
/*    */   protected abstract void b(float paramFloat);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\RelativeTemporalAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */