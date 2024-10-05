/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.PMath;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class GameStateTick
/*    */   extends StoppableEvent
/*    */ {
/*    */   private float a;
/*    */   
/*    */   public GameStateTick(float paramFloat) {
/* 17 */     setDeltaTime(paramFloat);
/*    */   }
/*    */   
/*    */   public final float getDeltaTime() {
/* 21 */     return this.a;
/*    */   }
/*    */   
/*    */   public final GameStateTick setDeltaTime(float paramFloat) {
/* 25 */     Preconditions.checkArgument((PMath.isFinite(paramFloat) && paramFloat >= 0.0F), "Invalid delta time: %s", Float.valueOf(paramFloat));
/* 26 */     this.a = paramFloat;
/* 27 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\GameStateTick.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */