/*    */ package com.prineside.tdi2.ui.events;
/*    */ 
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.Event;
/*    */ import com.prineside.tdi2.scene2d.EventListener;
/*    */ 
/*    */ public abstract class MoveToFrontListener
/*    */   implements EventListener {
/*    */   public boolean handle(Event paramEvent) {
/* 10 */     if (!(paramEvent instanceof MoveToFrontEvent)) return false; 
/* 11 */     actorMovedToFront((MoveToFrontEvent)paramEvent, paramEvent.getTarget(), (paramEvent.getTarget() == paramEvent.getListenerActor()));
/* 12 */     return false;
/*    */   }
/*    */   
/*    */   public abstract void actorMovedToFront(MoveToFrontEvent paramMoveToFrontEvent, Actor paramActor, boolean paramBoolean);
/*    */   
/*    */   public static class MoveToFrontEvent extends Event {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\events\MoveToFrontListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */