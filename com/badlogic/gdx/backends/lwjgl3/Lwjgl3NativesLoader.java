/*    */ package com.badlogic.gdx.backends.lwjgl3;
/*    */ 
/*    */ import com.badlogic.gdx.utils.GdxNativesLoader;
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
/*    */ public final class Lwjgl3NativesLoader
/*    */ {
/*    */   static {
/* 24 */     System.setProperty("org.lwjgl.input.Mouse.allowNegativeMouseCoords", "true");
/*    */   }
/*    */   
/*    */   public static void load() {
/* 28 */     GdxNativesLoader.load();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3NativesLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */