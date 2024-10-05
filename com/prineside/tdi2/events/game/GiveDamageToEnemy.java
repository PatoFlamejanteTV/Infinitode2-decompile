/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.DamageRecord;
/*    */ import com.prineside.tdi2.events.CancellableStoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class GiveDamageToEnemy
/*    */   extends CancellableStoppableEvent
/*    */ {
/*    */   private final DamageRecord a;
/*    */   
/*    */   public GiveDamageToEnemy(DamageRecord paramDamageRecord) {
/* 23 */     Preconditions.checkNotNull(paramDamageRecord);
/* 24 */     this.a = paramDamageRecord;
/*    */   }
/*    */   
/*    */   public final DamageRecord getRecord() {
/* 28 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\GiveDamageToEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */