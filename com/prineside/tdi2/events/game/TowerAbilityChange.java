/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class TowerAbilityChange extends StoppableEvent {
/*    */   private final Tower a;
/*    */   private final int b;
/*    */   private final boolean c;
/*    */   
/*    */   public TowerAbilityChange(Tower paramTower, int paramInt, boolean paramBoolean) {
/* 15 */     Preconditions.checkNotNull(paramTower);
/* 16 */     this.a = paramTower;
/* 17 */     this.b = paramInt;
/* 18 */     this.c = paramBoolean;
/*    */   }
/*    */   
/*    */   public final Tower getTower() {
/* 22 */     return this.a;
/*    */   }
/*    */   
/*    */   public final int getAbilityIndex() {
/* 26 */     return this.b;
/*    */   }
/*    */   
/*    */   public final boolean isInstalled() {
/* 30 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\TowerAbilityChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */