/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntSet;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.buffs.ThrowBackBuff;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class ThrowBackBuffProcessor extends BuffProcessor<ThrowBackBuff> {
/*    */   public final StatisticsType getBuffCountStatistic() {
/* 15 */     return StatisticsType.EB_TB;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean addBuff(Enemy paramEnemy, ThrowBackBuff paramThrowBackBuff) {
/* 20 */     if (paramEnemy.hasBuffsByType(BuffType.THROW_BACK))
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     if (paramEnemy.thrownBackBy == null || (!paramEnemy.thrownBackBy.contains(paramThrowBackBuff.ownerId) && paramEnemy.thrownBackBy.size < 3)) {
/* 26 */       if (super.addBuff(paramEnemy, (Buff)paramThrowBackBuff)) {
/*    */         
/* 28 */         if (paramEnemy.thrownBackBy == null) {
/* 29 */           paramEnemy.thrownBackBy = new IntSet();
/*    */         }
/* 31 */         paramEnemy.thrownBackBy.add(paramThrowBackBuff.ownerId);
/* 32 */         return true;
/*    */       } 
/* 34 */       return false;
/*    */     } 
/*    */ 
/*    */     
/* 38 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\ThrowBackBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */