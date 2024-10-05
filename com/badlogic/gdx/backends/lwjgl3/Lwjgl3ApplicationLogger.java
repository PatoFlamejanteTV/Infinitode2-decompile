/*    */ package com.badlogic.gdx.backends.lwjgl3;
/*    */ 
/*    */ import com.badlogic.gdx.ApplicationLogger;
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
/*    */ public class Lwjgl3ApplicationLogger
/*    */   implements ApplicationLogger
/*    */ {
/*    */   public void log(String paramString1, String paramString2) {
/* 26 */     System.out.println("[" + paramString1 + "] " + paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void log(String paramString1, String paramString2, Throwable paramThrowable) {
/* 31 */     System.out.println("[" + paramString1 + "] " + paramString2);
/* 32 */     paramThrowable.printStackTrace(System.out);
/*    */   }
/*    */ 
/*    */   
/*    */   public void error(String paramString1, String paramString2) {
/* 37 */     System.err.println("[" + paramString1 + "] " + paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void error(String paramString1, String paramString2, Throwable paramThrowable) {
/* 42 */     System.err.println("[" + paramString1 + "] " + paramString2);
/* 43 */     paramThrowable.printStackTrace(System.err);
/*    */   }
/*    */ 
/*    */   
/*    */   public void debug(String paramString1, String paramString2) {
/* 48 */     System.out.println("[" + paramString1 + "] " + paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void debug(String paramString1, String paramString2, Throwable paramThrowable) {
/* 53 */     System.out.println("[" + paramString1 + "] " + paramString2);
/* 54 */     paramThrowable.printStackTrace(System.out);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3ApplicationLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */