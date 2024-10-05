/*    */ package com.badlogic.gdx.scenes.scene2d.utils;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.utils.SharedLibraryLoader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class UIUtils
/*    */ {
/* 13 */   public static boolean isAndroid = SharedLibraryLoader.isAndroid;
/* 14 */   public static boolean isMac = SharedLibraryLoader.isMac;
/* 15 */   public static boolean isWindows = SharedLibraryLoader.isWindows;
/* 16 */   public static boolean isLinux = SharedLibraryLoader.isLinux;
/* 17 */   public static boolean isIos = SharedLibraryLoader.isIos;
/*    */   
/*    */   public static boolean left() {
/* 20 */     return Gdx.input.isButtonPressed(0);
/*    */   }
/*    */   
/*    */   public static boolean left(int paramInt) {
/* 24 */     return (paramInt == 0);
/*    */   }
/*    */   
/*    */   public static boolean right() {
/* 28 */     return Gdx.input.isButtonPressed(1);
/*    */   }
/*    */   
/*    */   public static boolean right(int paramInt) {
/* 32 */     return (paramInt == 1);
/*    */   }
/*    */   
/*    */   public static boolean middle() {
/* 36 */     return Gdx.input.isButtonPressed(2);
/*    */   }
/*    */   
/*    */   public static boolean middle(int paramInt) {
/* 40 */     return (paramInt == 2);
/*    */   }
/*    */   
/*    */   public static boolean shift() {
/* 44 */     return (Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60));
/*    */   }
/*    */   
/*    */   public static boolean shift(int paramInt) {
/* 48 */     return (paramInt == 59 || paramInt == 60);
/*    */   }
/*    */   
/*    */   public static boolean ctrl() {
/* 52 */     if (isMac) {
/* 53 */       return Gdx.input.isKeyPressed(63);
/*    */     }
/* 55 */     return (Gdx.input.isKeyPressed(129) || Gdx.input.isKeyPressed(130));
/*    */   }
/*    */   
/*    */   public static boolean ctrl(int paramInt) {
/* 59 */     if (isMac) {
/* 60 */       return (paramInt == 63);
/*    */     }
/* 62 */     return (paramInt == 129 || paramInt == 130);
/*    */   }
/*    */   
/*    */   public static boolean alt() {
/* 66 */     return (Gdx.input.isKeyPressed(57) || Gdx.input.isKeyPressed(58));
/*    */   }
/*    */   
/*    */   public static boolean alt(int paramInt) {
/* 70 */     return (paramInt == 57 || paramInt == 58);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\UIUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */