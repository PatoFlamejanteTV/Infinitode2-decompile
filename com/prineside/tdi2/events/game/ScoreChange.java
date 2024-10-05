/*    */ package com.prineside.tdi2.events.game;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Null;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.events.StoppableEvent;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public final class ScoreChange
/*    */   extends StoppableEvent
/*    */ {
/*    */   private long a;
/*    */   
/*    */   public ScoreChange(long paramLong, boolean paramBoolean, @Null StatisticsType paramStatisticsType) {
/* 15 */     setOldValue(paramLong);
/* 16 */     setGained(paramBoolean);
/* 17 */     setReason(paramStatisticsType);
/*    */   } private boolean b; @Null
/*    */   private StatisticsType c;
/*    */   public final long getOldValue() {
/* 21 */     return this.a;
/*    */   }
/*    */   
/*    */   public final ScoreChange setOldValue(long paramLong) {
/* 25 */     this.a = paramLong;
/* 26 */     return this;
/*    */   }
/*    */   
/*    */   public final boolean isGained() {
/* 30 */     return this.b;
/*    */   }
/*    */   
/*    */   public final ScoreChange setGained(boolean paramBoolean) {
/* 34 */     this.b = paramBoolean;
/* 35 */     return this;
/*    */   }
/*    */   @Null
/*    */   public final StatisticsType getReason() {
/* 39 */     return this.c;
/*    */   }
/*    */   
/*    */   public final ScoreChange setReason(@Null StatisticsType paramStatisticsType) {
/* 43 */     this.c = paramStatisticsType;
/* 44 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\game\ScoreChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */