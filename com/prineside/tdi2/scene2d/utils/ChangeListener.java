/*    */ package com.prineside.tdi2.scene2d.utils;
/*    */ 
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.Event;
/*    */ import com.prineside.tdi2.scene2d.EventListener;
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
/*    */ public abstract class ChangeListener
/*    */   implements EventListener
/*    */ {
/*    */   public boolean handle(Event paramEvent) {
/* 27 */     if (!(paramEvent instanceof ChangeEvent)) return false; 
/* 28 */     changed((ChangeEvent)paramEvent, paramEvent.getTarget());
/* 29 */     return false;
/*    */   }
/*    */   
/*    */   public abstract void changed(ChangeEvent paramChangeEvent, Actor paramActor);
/*    */   
/*    */   public static class ChangeEvent extends Event {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\ChangeListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */