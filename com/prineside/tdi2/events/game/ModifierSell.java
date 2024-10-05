/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Modifier;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class ModifierSell extends StoppableEvent {
/*    */   private final Modifier a;
/*    */   private final int b;
/*    */   
/*    */   public ModifierSell(Modifier paramModifier, int paramInt) {
/* 14 */     Preconditions.checkNotNull(paramModifier, "modifier can not be null");
/* 15 */     Preconditions.checkArgument((paramInt >= 0), "invalid returnedCoins: %s", paramInt);
/* 16 */     this.a = paramModifier;
/* 17 */     this.b = paramInt;
/*    */   }
/*    */   
/*    */   public final Modifier getModifier() {
/* 21 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getReturnedCoins() {
/* 25 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\ModifierSell.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */