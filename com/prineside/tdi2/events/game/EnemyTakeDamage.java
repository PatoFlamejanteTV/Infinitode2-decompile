/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.prineside.tdi2.DamageRecord;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class EnemyTakeDamage
/*    */   extends StoppableEvent
/*    */ {
/*    */   private DamageRecord a;
/*    */   
/*    */   public final EnemyTakeDamage setup(DamageRecord paramDamageRecord) {
/* 17 */     this.a = paramDamageRecord;
/* 18 */     return this;
/*    */   }
/*    */   
/*    */   public final DamageRecord getRecord() {
/* 22 */     return this.a;
/*    */   }
/*    */   
/*    */   public final EnemyTakeDamage reset() {
/* 26 */     this.a = null;
/* 27 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\EnemyTakeDamage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */