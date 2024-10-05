/*    */ package com.prineside.tdi2.scene2d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
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
/*    */ public abstract class FocusListener
/*    */   implements EventListener
/*    */ {
/*    */   public boolean handle(Event paramEvent) {
/* 28 */     if (!(paramEvent instanceof FocusEvent)) return false; 
/* 29 */     FocusEvent focusEvent = (FocusEvent)paramEvent;
/* 30 */     switch (null.a[focusEvent.getType().ordinal()]) {
/*    */       case 1:
/* 32 */         keyboardFocusChanged(focusEvent, paramEvent.getTarget(), focusEvent.isFocused());
/*    */         break;
/*    */       case 2:
/* 35 */         scrollFocusChanged(focusEvent, paramEvent.getTarget(), focusEvent.isFocused());
/*    */         break;
/*    */     } 
/* 38 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void keyboardFocusChanged(FocusEvent paramFocusEvent, Actor paramActor, boolean paramBoolean) {}
/*    */ 
/*    */   
/*    */   public void scrollFocusChanged(FocusEvent paramFocusEvent, Actor paramActor, boolean paramBoolean) {}
/*    */ 
/*    */   
/*    */   public static class FocusEvent
/*    */     extends Event
/*    */   {
/*    */     private boolean a;
/*    */     
/*    */     private Type b;
/*    */     private Actor c;
/*    */     
/*    */     public void reset() {
/* 57 */       super.reset();
/* 58 */       this.c = null;
/*    */     }
/*    */     
/*    */     public boolean isFocused() {
/* 62 */       return this.a;
/*    */     }
/*    */     
/*    */     public void setFocused(boolean param1Boolean) {
/* 66 */       this.a = param1Boolean;
/*    */     }
/*    */     
/*    */     public Type getType() {
/* 70 */       return this.b;
/*    */     }
/*    */     
/*    */     public void setType(Type param1Type) {
/* 74 */       this.b = param1Type;
/*    */     }
/*    */ 
/*    */     
/*    */     @Null
/*    */     public Actor getRelatedActor() {
/* 80 */       return this.c;
/*    */     }
/*    */ 
/*    */     
/*    */     public void setRelatedActor(@Null Actor param1Actor) {
/* 85 */       this.c = param1Actor;
/*    */     }
/*    */     
/*    */     public enum Type
/*    */     {
/* 90 */       keyboard, scroll; } } public enum Type { keyboard, scroll; }
/*    */ 
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\FocusListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */