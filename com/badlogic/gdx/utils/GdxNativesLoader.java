/*    */ package com.badlogic.gdx.utils;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GdxNativesLoader
/*    */ {
/*    */   public static boolean disableNativesLoading = false;
/*    */   private static boolean nativesLoaded;
/*    */   
/*    */   public static synchronized void load() {
/* 26 */     if (nativesLoaded)
/*    */       return; 
/* 28 */     if (disableNativesLoading)
/*    */       return; 
/* 30 */     (new SharedLibraryLoader()).load("gdx");
/* 31 */     nativesLoaded = true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\GdxNativesLoader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */