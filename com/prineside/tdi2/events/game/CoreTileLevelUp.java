/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.tiles.CoreTile;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class CoreTileLevelUp extends StoppableEvent {
/*    */   private final CoreTile a;
/*    */   
/*    */   public CoreTileLevelUp(CoreTile paramCoreTile) {
/* 13 */     Preconditions.checkNotNull(paramCoreTile);
/* 14 */     this.a = paramCoreTile;
/*    */   }
/*    */   
/*    */   public final CoreTile getCoreTile() {
/* 18 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\CoreTileLevelUp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */