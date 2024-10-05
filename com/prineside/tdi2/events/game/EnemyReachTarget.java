/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Enemy;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.PMath;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class EnemyReachTarget
/*    */   extends StoppableEvent
/*    */ {
/*    */   private Enemy a;
/*    */   private float b;
/*    */   private int c;
/*    */   private boolean d;
/*    */   
/*    */   public EnemyReachTarget(Enemy paramEnemy, float paramFloat, int paramInt) {
/* 27 */     setEnemy(paramEnemy);
/* 28 */     setBaseDamage(paramFloat);
/* 29 */     setFactDamage(paramInt);
/*    */   }
/*    */   
/*    */   public final Enemy getEnemy() {
/* 33 */     return this.a;
/*    */   }
/*    */   
/*    */   public final void setEnemy(Enemy paramEnemy) {
/* 37 */     Preconditions.checkNotNull(paramEnemy, "Enemy can not be null");
/* 38 */     this.a = paramEnemy;
/*    */   }
/*    */   
/*    */   public final float getBaseDamage() {
/* 42 */     return this.b;
/*    */   }
/*    */   
/*    */   public final EnemyReachTarget setBaseDamage(float paramFloat) {
/* 46 */     Preconditions.checkArgument((paramFloat >= 0.0F && PMath.isFinite(paramFloat)), "Base damage must be >= 0, %s given", Float.valueOf(paramFloat));
/* 47 */     this.b = paramFloat;
/* 48 */     return this;
/*    */   }
/*    */   
/*    */   public final int getFactDamage() {
/* 52 */     return this.c;
/*    */   }
/*    */   
/*    */   public final EnemyReachTarget setFactDamage(int paramInt) {
/* 56 */     Preconditions.checkArgument((paramInt >= 0), "Fact damage must be >= 0, %s given", paramInt);
/* 57 */     this.c = paramInt;
/* 58 */     return this;
/*    */   }
/*    */   
/*    */   public final boolean isCancelled() {
/* 62 */     return this.d;
/*    */   }
/*    */   
/*    */   public final void setCancelled(boolean paramBoolean) {
/* 66 */     this.d = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\EnemyReachTarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */