/*    */ package com.crashinvaders.basisu.gdx;
/*    */ 
/*    */ import com.badlogic.gdx.Application;
/*    */ import com.badlogic.gdx.Gdx;
/*    */ import com.badlogic.gdx.utils.SharedLibraryLoader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BasisuNativeLibLoader
/*    */ {
/*    */   private static boolean nativeLibLoaded = false;
/*    */   
/*    */   public static synchronized void loadIfNeeded() {
/* 15 */     if (nativeLibLoaded) {
/*    */       return;
/*    */     }
/* 18 */     if (Gdx.app.getType() == Application.ApplicationType.WebGL) {
/* 19 */       nativeLibLoaded = true;
/*    */       
/*    */       return;
/*    */     } 
/* 23 */     (new SharedLibraryLoader()).load("gdx-basis-universal");
/* 24 */     nativeLibLoaded = true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\crashinvaders\basisu\gdx\BasisuNativeLibLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */