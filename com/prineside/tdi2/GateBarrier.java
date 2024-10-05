/*   */ package com.prineside.tdi2;
/*   */ 
/*   */ import com.prineside.tdi2.enums.EnemyType;
/*   */ import com.prineside.tdi2.enums.GateType;
/*   */ 
/*   */ public abstract class GateBarrier
/*   */   extends Gate {
/*   */   protected GateBarrier(GateType paramGateType) {
/* 9 */     super(paramGateType);
/*   */   }
/*   */   
/*   */   public abstract boolean canEnemyPass(EnemyType paramEnemyType);
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\GateBarrier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */