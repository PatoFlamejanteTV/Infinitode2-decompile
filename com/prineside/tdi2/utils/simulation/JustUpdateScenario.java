/*    */ package com.prineside.tdi2.utils.simulation;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ 
/*    */ public final class JustUpdateScenario implements Scenario {
/*    */   private GameSystemProvider a;
/*    */   private final int b;
/*    */   
/*    */   public JustUpdateScenario(int paramInt) {
/* 11 */     Preconditions.checkArgument((paramInt > 0), "frames must be > 0, %s given", paramInt);
/* 12 */     this.b = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void setGSP(GameSystemProvider paramGameSystemProvider) {
/* 17 */     this.a = paramGameSystemProvider;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void start(GameSystemProvider paramGameSystemProvider) {
/* 22 */     this.a = paramGameSystemProvider;
/* 23 */     paramGameSystemProvider.wave.startNextWave();
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean isFinished() {
/* 28 */     return (this.a.gameState.updateNumber >= this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public final float getProgress() {
/* 33 */     return this.a.gameState.updateNumber / this.b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void onUpdate() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Scenario cpy() {
/* 45 */     return new JustUpdateScenario(this.b);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\JustUpdateScenario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */