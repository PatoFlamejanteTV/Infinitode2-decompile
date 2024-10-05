/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ 
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.buffs.SlippingBuff;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class SlippingBuffProcessor extends BuffProcessor<SlippingBuff> {
/*    */   public final boolean addBuff(Enemy paramEnemy, SlippingBuff paramSlippingBuff) {
/* 14 */     if (paramEnemy.hasBuffsByType(BuffType.SLIPPING)) {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     return super.addBuff(paramEnemy, (Buff)paramSlippingBuff);
/*    */   }
/*    */ 
/*    */   
/*    */   public final StatisticsType getBuffCountStatistic() {
/* 23 */     return StatisticsType.EB_SL;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\SlippingBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */