/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ 
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.buffs.NoBonusSystemPointsBuff;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class NoBonusSystemPointsBuffProcessor extends BuffProcessor<NoBonusSystemPointsBuff> {
/*    */   public final boolean isDebuff() {
/* 12 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean addBuff(Enemy paramEnemy, NoBonusSystemPointsBuff paramNoBonusSystemPointsBuff) {
/* 17 */     return a(paramEnemy, (Buff)paramNoBonusSystemPointsBuff);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\NoBonusSystemPointsBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */