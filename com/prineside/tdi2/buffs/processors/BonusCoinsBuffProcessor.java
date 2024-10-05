/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.DamageRecord;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.SerializableListener;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.buffs.BonusCoinsBuff;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.events.Event;
/*    */ import com.prineside.tdi2.events.Listener;
/*    */ import com.prineside.tdi2.events.game.EnemyDie;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class BonusCoinsBuffProcessor extends BuffProcessor<BonusCoinsBuff> {
/* 23 */   private OnEnemyDie a = new OnEnemyDie(this);
/*    */   
/*    */   private GameSystemProvider b;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 28 */     super.write(paramKryo, paramOutput);
/* 29 */     paramKryo.writeObject(paramOutput, this.a);
/* 30 */     paramKryo.writeObjectOrNull(paramOutput, this.b, GameSystemProvider.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 35 */     super.read(paramKryo, paramInput);
/* 36 */     this.a = (OnEnemyDie)paramKryo.readObject(paramInput, OnEnemyDie.class);
/* 37 */     this.b = (GameSystemProvider)paramKryo.readObjectOrNull(paramInput, GameSystemProvider.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void setRegistered(GameSystemProvider paramGameSystemProvider) {
/* 42 */     super.setRegistered(paramGameSystemProvider);
/*    */     
/* 44 */     this.b = paramGameSystemProvider;
/* 45 */     this.b.events.getListeners(EnemyDie.class).addStateAffectingWithPriority(this.a, 1000);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void setUnregistered() {
/* 50 */     this.b.events.getListeners(EnemyDie.class).remove(this.a);
/* 51 */     super.setUnregistered();
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean addBuff(Enemy paramEnemy, BonusCoinsBuff paramBonusCoinsBuff) {
/* 56 */     return a(paramEnemy, (Buff)paramBonusCoinsBuff);
/*    */   }
/*    */ 
/*    */   
/*    */   public final StatisticsType getBuffCountStatistic() {
/* 61 */     return StatisticsType.EB_BC;
/*    */   }
/*    */   
/*    */   @REGS
/*    */   public static final class OnEnemyDie extends SerializableListener<BonusCoinsBuffProcessor> implements Listener<EnemyDie> {
/*    */     private OnEnemyDie() {}
/*    */     
/*    */     public OnEnemyDie(BonusCoinsBuffProcessor param1BonusCoinsBuffProcessor) {
/* 69 */       this.a = param1BonusCoinsBuffProcessor;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*    */       DamageRecord damageRecord;
/* 75 */       Enemy enemy = (damageRecord = param1EnemyDie.getLastDamage()).getEnemy();
/* 76 */       Tower tower = damageRecord.getTower();
/*    */       
/*    */       DelayedRemovalArray delayedRemovalArray;
/* 79 */       if ((delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.BONUS_COINS)) != null && delayedRemovalArray.size != 0) {
/*    */         BonusCoinsBuff bonusCoinsBuff;
/*    */         
/* 82 */         float f = (bonusCoinsBuff = (BonusCoinsBuff)delayedRemovalArray.first()).bonusCoinsMultiplier * enemy.bounty;
/* 83 */         if (tower != null && bonusCoinsBuff.issuer == tower)
/*    */         {
/* 85 */           f *= 0.5F;
/*    */         }
/* 87 */         if (f > 0.0F) {
/* 88 */           enemy.bounty += f;
/* 89 */           if (bonusCoinsBuff.issuer != null) {
/* 90 */             bonusCoinsBuff.issuer.bonusCoinsBrought += f; return;
/*    */           } 
/* 92 */           if (tower != null)
/* 93 */             tower.bonusCoinsBrought += f; 
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\BonusCoinsBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */