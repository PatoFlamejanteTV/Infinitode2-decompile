/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ 
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.buffs.BlizzardBuff;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class BlizzardBuffProcessor extends BuffProcessor<BlizzardBuff> {
/*    */   public final boolean addBuff(Enemy paramEnemy, BlizzardBuff paramBlizzardBuff) {
/* 13 */     return a(paramEnemy, (Buff)paramBlizzardBuff);
/*    */   }
/*    */ 
/*    */   
/*    */   public final StatisticsType getBuffCountStatistic() {
/* 18 */     return StatisticsType.EB_F;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\BlizzardBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */