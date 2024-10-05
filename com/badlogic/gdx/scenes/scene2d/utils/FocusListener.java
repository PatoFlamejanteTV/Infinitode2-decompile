/*    */ package com.badlogic.gdx.scenes.scene2d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*    */ import com.badlogic.gdx.scenes.scene2d.Event;
/*    */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*    */ import com.badlogic.gdx.utils.Null;
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
/* 30 */     switch (focusEvent.getType()) {
/*    */       case keyboard:
/* 32 */         keyboardFocusChanged(focusEvent, paramEvent.getTarget(), focusEvent.isFocused());
/*    */         break;
/*    */       case scroll:
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
/*    */     private boolean focused;
/*    */     
/*    */     private Type type;
/*    */     private Actor relatedActor;
/*    */     
/*    */     public void reset() {
/* 57 */       super.reset();
/* 58 */       this.relatedActor = null;
/*    */     }
/*    */     
/*    */     public boolean isFocused() {
/* 62 */       return this.focused;
/*    */     }
/*    */     
/*    */     public void setFocused(boolean param1Boolean) {
/* 66 */       this.focused = param1Boolean;
/*    */     }
/*    */     
/*    */     public Type getType() {
/* 70 */       return this.type;
/*    */     }
/*    */     
/*    */     public void setType(Type param1Type) {
/* 74 */       this.type = param1Type;
/*    */     }
/*    */ 
/*    */     
/*    */     @Null
/*    */     public Actor getRelatedActor() {
/* 80 */       return this.relatedActor;
/*    */     }
/*    */ 
/*    */     
/*    */     public void setRelatedActor(@Null Actor param1Actor) {
/* 85 */       this.relatedActor = param1Actor;
/*    */     }
/*    */     
/*    */     public enum Type
/*    */     {
/* 90 */       keyboard, scroll; } } public enum Type { keyboard, scroll; }
/*    */ 
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\FocusListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */