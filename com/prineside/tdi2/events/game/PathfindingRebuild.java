/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class PathfindingRebuild extends StoppableEvent {
/*    */   private final boolean a;
/*    */   
/*    */   public PathfindingRebuild(boolean paramBoolean) {
/* 11 */     this.a = paramBoolean;
/*    */   }
/*    */   
/*    */   public final boolean isDefaultPathsAffected() {
/* 15 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\PathfindingRebuild.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */