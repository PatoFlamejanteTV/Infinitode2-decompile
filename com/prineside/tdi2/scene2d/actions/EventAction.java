/*    */ package com.prineside.tdi2.scene2d.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.reflect.ClassReflection;
/*    */ import com.prineside.tdi2.scene2d.Action;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.Event;
/*    */ import com.prineside.tdi2.scene2d.EventListener;
/*    */ 
/*    */ 
/*    */ public abstract class EventAction<T extends Event>
/*    */   extends Action
/*    */ {
/*    */   final Class<? extends T> c;
/*    */   boolean d;
/*    */   boolean e;
/*    */   
/* 17 */   private final EventListener f = new EventListener(this) {
/*    */       public boolean handle(Event param1Event) {
/* 19 */         if (!this.a.e || !ClassReflection.isInstance(this.a.c, param1Event)) return false; 
/* 20 */         this.a.d = this.a.handle(param1Event);
/* 21 */         return this.a.d;
/*    */       }
/*    */     };
/*    */   
/*    */   public EventAction(Class<? extends T> paramClass) {
/* 26 */     this.c = paramClass;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 30 */     this.d = false;
/* 31 */     this.e = false;
/*    */   }
/*    */   
/*    */   public void setTarget(Actor paramActor) {
/* 35 */     if (this.b != null) this.b.removeListener(this.f); 
/* 36 */     super.setTarget(paramActor);
/* 37 */     if (paramActor != null) paramActor.addListener(this.f);
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract boolean handle(T paramT);
/*    */   
/*    */   public boolean act(float paramFloat) {
/* 45 */     this.e = true;
/* 46 */     return this.d;
/*    */   }
/*    */   
/*    */   public boolean isActive() {
/* 50 */     return this.e;
/*    */   }
/*    */   
/*    */   public void setActive(boolean paramBoolean) {
/* 54 */     this.e = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2d\actions\EventAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */