/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Building;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.tiles.PlatformTile;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class BuildingRemove extends StoppableEvent {
/*    */   private final Building a;
/*    */   private final PlatformTile b;
/*    */   
/*    */   public BuildingRemove(Building paramBuilding, PlatformTile paramPlatformTile) {
/* 15 */     Preconditions.checkNotNull(paramBuilding, "building can not be null");
/* 16 */     Preconditions.checkNotNull(paramPlatformTile, "oldTile can not be null");
/* 17 */     this.a = paramBuilding;
/* 18 */     this.b = paramPlatformTile;
/*    */   }
/*    */   
/*    */   public final Building getBuilding() {
/* 22 */     return this.a;
/*    */   }
/*    */   
/*    */   public final PlatformTile getOldTile() {
/* 26 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\BuildingRemove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */