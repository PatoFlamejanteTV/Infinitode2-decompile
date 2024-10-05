/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Disposable;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(classOnly = true)
/*    */ public abstract class GameSystem
/*    */   extends Registrable
/*    */   implements Disposable
/*    */ {
/*    */   public int getFastStateHash() {
/* 12 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean affectsGameState();
/*    */ 
/*    */ 
/*    */   
/*    */   public void setup() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void postSetup() {}
/*    */ 
/*    */   
/*    */   public void postStateRestore() {}
/*    */ 
/*    */   
/*    */   public void update(float paramFloat) {}
/*    */ 
/*    */   
/*    */   public boolean profileUpdate() {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public abstract String getSystemName();
/*    */   
/*    */   public void dispose() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\GameSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */