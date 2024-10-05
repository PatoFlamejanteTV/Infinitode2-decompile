/*    */ package com.badlogic.gdx.backends.lwjgl3;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Lwjgl3WindowAdapter
/*    */   implements Lwjgl3WindowListener
/*    */ {
/*    */   public void created(Lwjgl3Window paramLwjgl3Window) {}
/*    */   
/*    */   public void iconified(boolean paramBoolean) {}
/*    */   
/*    */   public void maximized(boolean paramBoolean) {}
/*    */   
/*    */   public void focusLost() {}
/*    */   
/*    */   public void focusGained() {}
/*    */   
/*    */   public boolean closeRequested() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public void filesDropped(String[] paramArrayOfString) {}
/*    */   
/*    */   public void refreshRequested() {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3WindowAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */