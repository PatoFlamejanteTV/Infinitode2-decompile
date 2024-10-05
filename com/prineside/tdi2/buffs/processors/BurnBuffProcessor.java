/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ 
/*    */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.buffs.BurnBuff;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.enums.DamageType;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class BurnBuffProcessor extends BuffProcessor<BurnBuff> {
/*    */   @FrameAccumulatorForPerformance
/*    */   private byte a;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 23 */     super.write(paramKryo, paramOutput);
/* 24 */     paramOutput.writeByte(this.a);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 29 */     super.read(paramKryo, paramInput);
/* 30 */     this.a = paramInput.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public final StatisticsType getBuffCountStatistic() {
/* 35 */     return StatisticsType.EB_I;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean addBuff(Enemy paramEnemy, BurnBuff paramBurnBuff) {
/*    */     DelayedRemovalArray delayedRemovalArray;
/* 43 */     if ((delayedRemovalArray = paramEnemy.getBuffsByTypeOrNull(BuffType.BURN)) != null && delayedRemovalArray.size != 0) {
/*    */       BurnBuff burnBuff;
/* 45 */       if ((burnBuff = ((BurnBuff[])delayedRemovalArray.items)[0]).fireDamage * burnBuff.duration < paramBurnBuff.duration * paramBurnBuff.fireDamage) {
/*    */         
/* 47 */         removeBuffAtIndex(paramEnemy, BuffType.BURN, 0);
/*    */         
/* 49 */         return super.addBuff(paramEnemy, (Buff)paramBurnBuff);
/*    */       } 
/*    */       
/* 52 */       return false;
/*    */     } 
/*    */     
/* 55 */     return super.addBuff(paramEnemy, (Buff)paramBurnBuff);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void update(float paramFloat) {
/* 62 */     this.a = (byte)(this.a + 1);
/* 63 */     if (this.a == 8) {
/* 64 */       paramFloat *= 8.0F;
/* 65 */       this.a = 0;
/* 66 */       this.S.map.spawnedEnemies.begin(); byte b; int i;
/* 67 */       for (b = 0, i = this.S.map.spawnedEnemies.size; b < i; b++) {
/*    */         Enemy enemy;
/* 69 */         if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null) {
/*    */           DelayedRemovalArray delayedRemovalArray;
/*    */ 
/*    */           
/* 73 */           if ((delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.BURN)) != null && delayedRemovalArray.size != 0) {
/*    */             
/* 75 */             delayedRemovalArray.begin(); byte b1; int j;
/* 76 */             for (b1 = 0, j = delayedRemovalArray.size; b1 < j; b1++) {
/*    */               BurnBuff burnBuff;
/* 78 */               float f1 = (burnBuff = ((BurnBuff[])delayedRemovalArray.items)[b1]).fireDamage * paramFloat * enemy.getBuffVulnerability(BuffType.BURN);
/* 79 */               float f2 = 1.0F + burnBuff.bonusDamagePerEnemyNearby * enemy.otherEnemiesNearby;
/* 80 */               f1 *= f2;
/* 81 */               if (burnBuff.tower != null && !burnBuff.tower.isRegistered()) {
/* 82 */                 burnBuff.tower = null;
/*    */               }
/* 84 */               if (f1 > 0.0F) {
/* 85 */                 this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, f1, DamageType.FIRE).setTower(burnBuff.tower).setAbility(burnBuff.fromAbility).setEfficiency(4));
/*    */               }
/*    */             } 
/* 88 */             delayedRemovalArray.end();
/*    */           } 
/*    */         } 
/* 91 */       }  this.S.map.spawnedEnemies.end();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\BurnBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */