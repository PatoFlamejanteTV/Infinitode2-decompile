/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class TowerLevelUp extends StoppableEvent {
/*    */   private final Tower a;
/*    */   
/*    */   public TowerLevelUp(Tower paramTower) {
/* 13 */     Preconditions.checkNotNull(paramTower);
/* 14 */     this.a = paramTower;
/*    */   }
/*    */   
/*    */   public final Tower getTower() {
/* 18 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\TowerLevelUp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */