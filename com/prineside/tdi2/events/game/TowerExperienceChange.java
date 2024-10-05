/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.PMath;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class TowerExperienceChange
/*    */   extends StoppableEvent
/*    */ {
/*    */   private Tower a;
/*    */   private final float b;
/*    */   
/*    */   public TowerExperienceChange(Tower paramTower, float paramFloat) {
/* 18 */     Preconditions.checkNotNull(paramTower, "tower can not be null");
/* 19 */     Preconditions.checkArgument(PMath.isFinite(paramFloat), "invalid delta %s", Float.valueOf(paramFloat));
/* 20 */     this.a = paramTower;
/* 21 */     this.b = paramFloat;
/*    */   }
/*    */   
/*    */   public final Tower getTower() {
/* 25 */     return this.a;
/*    */   }
/*    */   
/*    */   public final float getDelta() {
/* 29 */     return this.b;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\TowerExperienceChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */