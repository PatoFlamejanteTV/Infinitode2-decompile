/*    */ package com.badlogic.gdx.ai;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StdoutLogger
/*    */   implements Logger
/*    */ {
/*    */   public void debug(String paramString1, String paramString2) {
/* 29 */     println("DEBUG", paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void debug(String paramString1, String paramString2, Throwable paramThrowable) {
/* 34 */     println("DEBUG", paramString1, paramString2, paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   public void info(String paramString1, String paramString2) {
/* 39 */     println("INFO", paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void info(String paramString1, String paramString2, Throwable paramThrowable) {
/* 44 */     println("INFO", paramString1, paramString2, paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   public void error(String paramString1, String paramString2) {
/* 49 */     println("ERROR", paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void error(String paramString1, String paramString2, Throwable paramThrowable) {
/* 54 */     println("ERROR", paramString1, paramString2, paramThrowable);
/*    */   }
/*    */   
/*    */   private void println(String paramString1, String paramString2, String paramString3) {
/* 58 */     System.out.println(paramString1 + " " + paramString2 + ": " + paramString3);
/*    */   }
/*    */   
/*    */   private void println(String paramString1, String paramString2, String paramString3, Throwable paramThrowable) {
/* 62 */     println(paramString1, paramString2, paramString3);
/* 63 */     paramThrowable.printStackTrace();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\StdoutLogger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */