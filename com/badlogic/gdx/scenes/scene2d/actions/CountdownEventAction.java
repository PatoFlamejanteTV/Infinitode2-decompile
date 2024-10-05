/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Event;
/*    */ 
/*    */ 
/*    */ public class CountdownEventAction<T extends Event>
/*    */   extends EventAction<T>
/*    */ {
/*    */   int count;
/*    */   int current;
/*    */   
/*    */   public CountdownEventAction(Class<? extends T> paramClass, int paramInt) {
/* 13 */     super(paramClass);
/* 14 */     this.count = paramInt;
/*    */   }
/*    */   
/*    */   public boolean handle(T paramT) {
/* 18 */     this.current++;
/* 19 */     return (this.current >= this.count);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\CountdownEventAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */