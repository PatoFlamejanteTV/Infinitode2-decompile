/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.buffs.SnowballBuff;
/*    */ import com.prineside.tdi2.enums.AchievementType;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class SnowballBuffProcessor extends BuffProcessor<SnowballBuff> {
/* 13 */   public static final float[] STUN_DURATION_BY_STUN_COUNT = new float[] { 1.0F, 0.8F, 0.65F, 0.5F, 0.35F, 0.2F }; public static final int MAX_HITS_ONE_ENEMY = (new float[6]).length;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean addBuff(Enemy paramEnemy, SnowballBuff paramSnowballBuff) {
/* 20 */     if (paramEnemy.buffSnowballHits >= MAX_HITS_ONE_ENEMY)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     if (paramEnemy.hasBuffsByType(BuffType.SNOWBALL))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/*    */     boolean bool;
/* 31 */     if (bool = super.addBuff(paramEnemy, (Buff)paramSnowballBuff)) {
/* 32 */       paramEnemy.buffSnowballHits++;
/* 33 */       this.S.achievement.setProgress(AchievementType.HIT_ENEMY_WITH_SNOWBALLS, paramEnemy.buffSnowballHits);
/*    */     } 
/* 35 */     return bool;
/*    */   }
/*    */ 
/*    */   
/*    */   public final StatisticsType getBuffCountStatistic() {
/* 40 */     return StatisticsType.EB_F;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\SnowballBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */