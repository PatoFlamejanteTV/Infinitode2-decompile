/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.DamageRecord;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class EnemyDie extends StoppableEvent {
/*    */   private final DamageRecord a;
/*    */   private boolean b;
/*    */   
/*    */   public EnemyDie(DamageRecord paramDamageRecord) {
/* 14 */     Preconditions.checkNotNull(paramDamageRecord);
/* 15 */     this.a = paramDamageRecord;
/*    */   }
/*    */   
/*    */   public final DamageRecord getLastDamage() {
/* 19 */     return this.a;
/*    */   }
/*    */   
/*    */   public final boolean isCancelled() {
/* 23 */     return this.b;
/*    */   }
/*    */   
/*    */   public final void setCancelled(boolean paramBoolean) {
/* 27 */     this.b = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\EnemyDie.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */