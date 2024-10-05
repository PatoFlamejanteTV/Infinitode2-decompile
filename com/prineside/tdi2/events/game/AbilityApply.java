/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Ability;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class AbilityApply extends StoppableEvent {
/*    */   private final Ability a;
/*    */   private int b;
/*    */   private int c;
/*    */   
/*    */   public AbilityApply(Ability paramAbility, int paramInt1, int paramInt2) {
/* 15 */     Preconditions.checkNotNull(paramAbility);
/* 16 */     this.a = paramAbility;
/* 17 */     setX(paramInt1);
/* 18 */     setY(paramInt2);
/*    */   }
/*    */   
/*    */   public final Ability getAbility() {
/* 22 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getX() {
/* 26 */     return this.b;
/*    */   }
/*    */   
/*    */   public final void setX(int paramInt) {
/* 30 */     this.b = paramInt;
/*    */   }
/*    */   
/*    */   public final int getY() {
/* 34 */     return this.c;
/*    */   }
/*    */   
/*    */   public final void setY(int paramInt) {
/* 38 */     this.c = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\AbilityApply.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */