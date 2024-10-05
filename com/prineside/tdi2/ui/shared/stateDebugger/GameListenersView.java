/*    */ package com.prineside.tdi2.ui.shared.stateDebugger;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.screens.GameScreen;
/*    */ 
/*    */ public class GameListenersView
/*    */   extends ListenersView {
/*    */   public String getId() {
/*  9 */     return "GAME_LISTENERS";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 14 */     return "Game listeners";
/*    */   }
/*    */ 
/*    */   
/*    */   public void onShow() {
/* 19 */     if (Game.i.screenManager.getCurrentScreen() instanceof GameScreen) {
/* 20 */       setDispatcher(((GameScreen)Game.i.screenManager.getCurrentScreen()).S.events);
/*    */     }
/* 22 */     super.onShow();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\stateDebugger\GameListenersView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */