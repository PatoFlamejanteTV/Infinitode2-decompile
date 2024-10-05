/*    */ package com.prineside.tdi2.ui.shared.stateDebugger;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ 
/*    */ public class GlobalListenersView
/*    */   extends ListenersView {
/*    */   public String getId() {
/*  8 */     return "GLOBAL_LISTENERS";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 13 */     return "Global listeners";
/*    */   }
/*    */ 
/*    */   
/*    */   public void onShow() {
/* 18 */     setDispatcher(Game.EVENTS);
/* 19 */     super.onShow();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\ui\shared\stateDebugger\GlobalListenersView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */