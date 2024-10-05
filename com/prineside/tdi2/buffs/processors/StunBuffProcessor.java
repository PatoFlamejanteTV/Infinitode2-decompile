/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.buffs.StunBuff;
/*    */ import com.prineside.tdi2.components.StunDebuffStats;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class StunBuffProcessor extends BuffProcessor<StunBuff> {
/*    */   @FrameAccumulatorForPerformance
/*    */   private byte a;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 22 */     super.write(paramKryo, paramOutput);
/* 23 */     paramOutput.writeByte(this.a);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 28 */     super.read(paramKryo, paramInput);
/* 29 */     this.a = paramInput.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public final StatisticsType getBuffCountStatistic() {
/* 34 */     return StatisticsType.EB_S;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean addBuff(Enemy paramEnemy, StunBuff paramStunBuff) {
/* 39 */     if (paramEnemy.stunDebuffStats == null) {
/* 40 */       paramEnemy.stunDebuffStats = new StunDebuffStats();
/*    */     }
/*    */     
/* 43 */     if (paramEnemy.stunDebuffStats.totalCount >= 6)
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if (paramEnemy.hasBuffsByType(BuffType.STUN) || this.S.gameState.randomFloat() < paramEnemy.stunDebuffStats.immunity)
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 54 */     paramEnemy.stunDebuffStats.addStunnedBy(paramStunBuff.issuerId);
/* 55 */     paramEnemy.stunDebuffStats.totalCount = (byte)(paramEnemy.stunDebuffStats.totalCount + 1);
/*    */ 
/*    */     
/* 58 */     paramEnemy.stunDebuffStats.immunity = 1.0F;
/* 59 */     paramEnemy.stunDebuffStats.passedTilesOnLastStun = paramEnemy.sumPassedTiles;
/*    */     
/* 61 */     return super.addBuff(paramEnemy, (Buff)paramStunBuff);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final void update(float paramFloat) {
/* 67 */     this.a = (byte)(this.a + 1);
/* 68 */     if (this.a == 7) {
/*    */       
/* 70 */       this.a = 0; byte b;
/*    */       int i;
/* 72 */       for (b = 0, i = this.S.map.spawnedEnemies.size; b < i; b++) {
/*    */         Enemy enemy;
/* 74 */         if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null) {
/*    */           StunDebuffStats stunDebuffStats;
/*    */           
/* 77 */           if ((stunDebuffStats = enemy.stunDebuffStats) != null) {
/*    */             float f;
/*    */             
/* 80 */             if ((f = enemy.sumPassedTiles - stunDebuffStats.passedTilesOnLastStun) < 3.0F) {
/* 81 */               stunDebuffStats.immunity = 1.0F;
/*    */             } else {
/* 83 */               stunDebuffStats.immunity = 1.0F - f * 0.2F;
/*    */             } 
/* 85 */             if (stunDebuffStats.immunity < 0.0F) stunDebuffStats.immunity = 0.0F; 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\StunBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */