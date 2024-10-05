/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ 
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.buffs.ArmorBuff;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class ArmorBuffProcessor extends BuffProcessor<ArmorBuff> {
/*    */   public final boolean isDebuff() {
/* 12 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean addBuff(Enemy paramEnemy, ArmorBuff paramArmorBuff) {
/* 17 */     return a(paramEnemy, (Buff)paramArmorBuff);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\ArmorBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */