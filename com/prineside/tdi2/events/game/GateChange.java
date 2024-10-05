/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.Gate;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class GateChange
/*    */   extends StoppableEvent
/*    */ {
/*    */   private final int a;
/*    */   private final int b;
/*    */   
/*    */   public GateChange(int paramInt1, int paramInt2, boolean paramBoolean, Gate paramGate1, Gate paramGate2) {
/* 17 */     this.a = paramInt1;
/* 18 */     this.b = paramInt2;
/* 19 */     this.c = paramBoolean;
/* 20 */     this.d = paramGate1;
/* 21 */     this.e = paramGate2;
/*    */   } private final boolean c; @Null
/*    */   private final Gate d; @Null
/*    */   private final Gate e; public final int getX() {
/* 25 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getY() {
/* 29 */     return this.b;
/*    */   }
/*    */   
/*    */   public final boolean isLeftSide() {
/* 33 */     return this.c;
/*    */   }
/*    */   @Null
/*    */   public final Gate getOldGate() {
/* 37 */     return this.d;
/*    */   }
/*    */   @Null
/*    */   public final Gate getNewGate() {
/* 41 */     return this.e;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\GateChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */