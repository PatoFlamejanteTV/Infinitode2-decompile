/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.MapElementPos;
/*    */ import com.prineside.tdi2.events.CancellableStoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class MapElementHover extends CancellableStoppableEvent {
/*    */   @Null
/*    */   private final MapElementPos a;
/*    */   
/*    */   public MapElementHover(@Null MapElementPos paramMapElementPos1, @Null MapElementPos paramMapElementPos2) {
/* 14 */     this.a = paramMapElementPos1;
/* 15 */     this.b = paramMapElementPos2;
/*    */   } @Null
/*    */   private final MapElementPos b; @Null
/*    */   public final MapElementPos getPrevious() {
/* 19 */     return this.a;
/*    */   }
/*    */   @Null
/*    */   public final MapElementPos getCurrent() {
/* 23 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\MapElementHover.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */