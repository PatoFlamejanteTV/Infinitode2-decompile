/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.Tile;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class TileChange
/*    */   extends StoppableEvent
/*    */ {
/*    */   private final int a;
/*    */   private final int b;
/*    */   
/*    */   public TileChange(int paramInt1, int paramInt2, @Null Tile paramTile1, @Null Tile paramTile2) {
/* 16 */     this.a = paramInt1;
/* 17 */     this.b = paramInt2;
/* 18 */     this.c = paramTile1;
/* 19 */     this.d = paramTile2;
/*    */   } @Null
/*    */   private final Tile c; @Null
/*    */   private final Tile d; public final int getX() {
/* 23 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getY() {
/* 27 */     return this.b;
/*    */   }
/*    */   
/*    */   public final Tile getOldTile() {
/* 31 */     return this.c;
/*    */   }
/*    */   
/*    */   public final Tile getNewTile() {
/* 35 */     return this.d;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\TileChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */