/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.Explosion;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.SerializableListener;
/*    */ import com.prineside.tdi2.buffs.DeathExplosionBuff;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.events.Event;
/*    */ import com.prineside.tdi2.events.Listener;
/*    */ import com.prineside.tdi2.events.game.EnemyDie;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class DeathExplosionBuffProcessor extends BuffProcessor<DeathExplosionBuff> {
/* 21 */   private OnEnemyDie a = new OnEnemyDie(this);
/*    */ 
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 25 */     super.write(paramKryo, paramOutput);
/* 26 */     paramKryo.writeObject(paramOutput, this.a);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 31 */     super.read(paramKryo, paramInput);
/* 32 */     this.a = (OnEnemyDie)paramKryo.readObject(paramInput, OnEnemyDie.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void setRegistered(GameSystemProvider paramGameSystemProvider) {
/* 37 */     super.setRegistered(paramGameSystemProvider);
/* 38 */     this.S.events.getListeners(EnemyDie.class).addStateAffecting(this.a);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void setUnregistered() {
/* 43 */     this.S.events.getListeners(EnemyDie.class).remove(this.a);
/* 44 */     super.setUnregistered();
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean addBuff(Enemy paramEnemy, DeathExplosionBuff paramDeathExplosionBuff) {
/* 49 */     return a(paramEnemy, (Buff)paramDeathExplosionBuff);
/*    */   }
/*    */ 
/*    */   
/*    */   public final StatisticsType getBuffCountStatistic() {
/* 54 */     return StatisticsType.EB_BC;
/*    */   }
/*    */   
/*    */   @REGS
/*    */   public static final class OnEnemyDie extends SerializableListener<DeathExplosionBuffProcessor> implements Listener<EnemyDie> {
/*    */     private OnEnemyDie() {}
/*    */     
/*    */     public OnEnemyDie(DeathExplosionBuffProcessor param1DeathExplosionBuffProcessor) {
/* 62 */       this.a = param1DeathExplosionBuffProcessor;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*    */       Enemy enemy;
/*    */       DelayedRemovalArray delayedRemovalArray;
/* 69 */       if ((delayedRemovalArray = (enemy = param1EnemyDie.getLastDamage().getEnemy()).getBuffsByTypeOrNull(BuffType.DEATH_EXPLOSION)) != null && delayedRemovalArray.size != 0)
/* 70 */         for (byte b = 0; b < delayedRemovalArray.size; b++) {
/*    */           DeathExplosionBuff deathExplosionBuff;
/* 72 */           Explosion explosion = (deathExplosionBuff = (DeathExplosionBuff)delayedRemovalArray.items[b]).explosion;
/* 73 */           deathExplosionBuff.explosion = null;
/*    */           
/* 75 */           if (explosion != null) {
/* 76 */             explosion.position.set(enemy.getPosition());
/* 77 */             ((DeathExplosionBuffProcessor)this.a).S.explosion.register(explosion);
/* 78 */             explosion.explode();
/*    */           } 
/*    */         }  
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\DeathExplosionBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */