/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.tiles.CoreTile;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class CoreTileUpgradeInstall extends StoppableEvent {
/*    */   private final CoreTile a;
/*    */   private final int b;
/*    */   private final int c;
/*    */   
/*    */   public CoreTileUpgradeInstall(CoreTile paramCoreTile, int paramInt1, int paramInt2) {
/* 15 */     Preconditions.checkNotNull(paramCoreTile, "coreTile can not be null");
/* 16 */     this.c = paramInt1;
/* 17 */     this.b = paramInt2;
/* 18 */     this.a = paramCoreTile;
/*    */   }
/*    */   
/*    */   public final CoreTile getCoreTile() {
/* 22 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getRow() {
/* 26 */     return this.b;
/*    */   }
/*    */   
/*    */   public final int getCol() {
/* 30 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\CoreTileUpgradeInstall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */