/*    */ package com.prineside.tdi2.scene2d.actions;
/*    */ 
/*    */ import com.prineside.tdi2.scene2d.Event;
/*    */ 
/*    */ 
/*    */ public class CountdownEventAction<T extends Event>
/*    */   extends EventAction<T>
/*    */ {
/*    */   private int f;
/*    */   private int g;
/*    */   
/*    */   public CountdownEventAction(Class<? extends T> paramClass, int paramInt) {
/* 13 */     super(paramClass);
/* 14 */     this.f = paramInt;
/*    */   }
/*    */   
/*    */   public boolean handle(T paramT) {
/* 18 */     this.g++;
/* 19 */     return (this.g >= this.f);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\CountdownEventAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */