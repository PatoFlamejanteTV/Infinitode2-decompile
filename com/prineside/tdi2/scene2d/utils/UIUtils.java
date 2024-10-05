/*    */ package com.prineside.tdi2.scene2d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.utils.SharedLibraryLoader;
/*    */ import com.prineside.tdi2.Game;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class UIUtils
/*    */ {
/* 14 */   public static boolean isAndroid = SharedLibraryLoader.isAndroid;
/* 15 */   public static boolean isMac = SharedLibraryLoader.isMac;
/* 16 */   public static boolean isWindows = SharedLibraryLoader.isWindows;
/* 17 */   public static boolean isLinux = SharedLibraryLoader.isLinux;
/* 18 */   public static boolean isIos = SharedLibraryLoader.isIos;
/*    */   
/*    */   public static boolean hasClipboard() {
/*    */     try {
/* 22 */       return Gdx.app.getClipboard().hasContents();
/* 23 */     } catch (Throwable throwable) {
/* 24 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static boolean left() {
/* 29 */     return Gdx.input.isButtonPressed(0);
/*    */   }
/*    */   
/*    */   public static boolean left(int paramInt) {
/* 33 */     return (paramInt == 0);
/*    */   }
/*    */   
/*    */   public static boolean right() {
/* 37 */     return Gdx.input.isButtonPressed(1);
/*    */   }
/*    */   
/*    */   public static boolean right(int paramInt) {
/* 41 */     return (paramInt == 1);
/*    */   }
/*    */   
/*    */   public static boolean middle() {
/* 45 */     return Gdx.input.isButtonPressed(2);
/*    */   }
/*    */   
/*    */   public static boolean middle(int paramInt) {
/* 49 */     return (paramInt == 2);
/*    */   }
/*    */   
/*    */   public static boolean shift() {
/* 53 */     return (Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60) || Game.i.uiManager.isStageKeyPressed(59) || Game.i.uiManager.isStageKeyPressed(60));
/*    */   }
/*    */   
/*    */   public static boolean shift(int paramInt) {
/* 57 */     return (paramInt == 59 || paramInt == 60);
/*    */   }
/*    */   
/*    */   public static boolean ctrl() {
/* 61 */     if (isMac) {
/* 62 */       return Gdx.input.isKeyPressed(63);
/*    */     }
/* 64 */     if (Gdx.input.isKeyPressed(129) || Gdx.input
/* 65 */       .isKeyPressed(130) || Game.i.uiManager
/* 66 */       .isStageKeyPressed(129) || Game.i.uiManager
/* 67 */       .isStageKeyPressed(130) || Game.i.uiManager
/* 68 */       .isStageKeyPressed(113)) return true; 
/*    */     return false;
/*    */   }
/*    */   public static boolean ctrl(int paramInt) {
/* 72 */     if (isMac) {
/* 73 */       return (paramInt == 63);
/*    */     }
/* 75 */     return (paramInt == 129 || paramInt == 130 || paramInt == 113);
/*    */   }
/*    */   
/*    */   public static boolean alt() {
/* 79 */     return (Gdx.input.isKeyPressed(57) || Gdx.input.isKeyPressed(58) || Game.i.uiManager.isStageKeyPressed(57) || Game.i.uiManager.isStageKeyPressed(58));
/*    */   }
/*    */   
/*    */   public static boolean alt(int paramInt) {
/* 83 */     return (paramInt == 57 || paramInt == 58);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\UIUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */