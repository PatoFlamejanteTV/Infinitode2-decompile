/*    */ package com.badlogic.gdx.scenes.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Action;
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.scenes.scene2d.Event;
/*    */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*    */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*    */ 
/*    */ 
/*    */ public abstract class EventAction<T extends Event>
/*    */   extends Action
/*    */ {
/*    */   final Class<? extends T> eventClass;
/*    */   boolean result;
/*    */   boolean active;
/*    */   
/* 17 */   private final EventListener listener = new EventListener() {
/*    */       public boolean handle(Event param1Event) {
/* 19 */         if (!EventAction.this.active || !ClassReflection.isInstance(EventAction.this.eventClass, param1Event)) return false; 
/* 20 */         EventAction.this.result = EventAction.this.handle(param1Event);
/* 21 */         return EventAction.this.result;
/*    */       }
/*    */     };
/*    */   
/*    */   public EventAction(Class<? extends T> paramClass) {
/* 26 */     this.eventClass = paramClass;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 30 */     this.result = false;
/* 31 */     this.active = false;
/*    */   }
/*    */   
/*    */   public void setTarget(Actor paramActor) {
/* 35 */     if (this.target != null) this.target.removeListener(this.listener); 
/* 36 */     super.setTarget(paramActor);
/* 37 */     if (paramActor != null) paramActor.addListener(this.listener);
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract boolean handle(T paramT);
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 45 */     this.active = true;
/* 46 */     return this.result;
/*    */   }
/*    */   
/*    */   public boolean isActive() {
/* 50 */     return this.active;
/*    */   }
/*    */   
/*    */   public void setActive(boolean paramBoolean) {
/* 54 */     this.active = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2d\actions\EventAction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */