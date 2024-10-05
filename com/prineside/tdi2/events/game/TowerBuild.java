/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class TowerBuild extends StoppableEvent {
/*    */   private final Tower a;
/*    */   private final int b;
/*    */   
/*    */   public TowerBuild(Tower paramTower, int paramInt) {
/* 14 */     Preconditions.checkNotNull(paramTower);
/* 15 */     this.a = paramTower;
/* 16 */     this.b = paramInt;
/*    */   }
/*    */   
/*    */   public final Tower getTower() {
/* 20 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getPrice() {
/* 24 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\TowerBuild.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */