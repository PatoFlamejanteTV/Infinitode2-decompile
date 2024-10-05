/*    */ package com.prineside.tdi2.buffs.processors;
/*    */ import com.prineside.tdi2.Buff;
/*    */ import com.prineside.tdi2.BuffProcessor;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.Tile;
/*    */ import com.prineside.tdi2.buffs.NoDamageBuff;
/*    */ import com.prineside.tdi2.enums.BuffType;
/*    */ import com.prineside.tdi2.events.Event;
/*    */ import com.prineside.tdi2.events.Listener;
/*    */ import com.prineside.tdi2.events.game.EnemyReachTarget;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ 
/*    */ @REGS
/*    */ public final class NoDamageBuffProcessor extends BuffProcessor<NoDamageBuff> implements Listener<EnemyReachTarget> {
/* 17 */   private static final TLog a = TLog.forClass(NoDamageBuffProcessor.class);
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isDebuff() {
/* 22 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean addBuff(Enemy paramEnemy, NoDamageBuff paramNoDamageBuff) {
/* 27 */     return a(paramEnemy, (Buff)paramNoDamageBuff);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void setRegistered(GameSystemProvider paramGameSystemProvider) {
/* 32 */     super.setRegistered(paramGameSystemProvider);
/* 33 */     paramGameSystemProvider.events.getListeners(EnemyReachTarget.class).addStateAffecting(this).setDescription("NoDamageBuffProcessor - sets damage to zero if enemy has NO_DAMAGE buff");
/*    */   }
/*    */ 
/*    */   
/*    */   public final void setUnregistered() {
/* 38 */     super.setUnregistered();
/* 39 */     if (this.S != null && this.S.events != null) {
/* 40 */       this.S.events.getListeners(EnemyReachTarget.class).remove(this);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final void handleEvent(EnemyReachTarget paramEnemyReachTarget) {
/*    */     Tile tile;
/* 47 */     if (tile = paramEnemyReachTarget.getEnemy().getCurrentTile() instanceof com.prineside.tdi2.tiles.TargetTile && 
/* 48 */       paramEnemyReachTarget.getEnemy().hasBuffsByType(BuffType.NO_DAMAGE)) {
/* 49 */       a.i("enemy has NO_DAMAGE buff, removing damage", new Object[0]);
/* 50 */       paramEnemyReachTarget.setFactDamage(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\buffs\processors\NoDamageBuffProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */