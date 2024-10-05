/*    */ package com.prineside.tdi2.events.mapEditor;
/*    */ 
/*    */ import com.prineside.tdi2.Map;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ 
/*    */ public final class MapValidationFail extends StoppableEvent {
/*    */   private final Map.InvalidMapException a;
/*    */   
/*    */   public MapValidationFail(Map.InvalidMapException paramInvalidMapException) {
/* 10 */     this.a = paramInvalidMapException;
/*    */   }
/*    */   
/*    */   public final Map.InvalidMapException getException() {
/* 14 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\mapEditor\MapValidationFail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */