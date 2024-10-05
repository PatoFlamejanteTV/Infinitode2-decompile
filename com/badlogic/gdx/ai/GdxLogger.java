/*    */ package com.badlogic.gdx.ai;
/*    */ 
/*    */ import com.badlogic.gdx.Gdx;
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
/*    */ public class GdxLogger
/*    */   implements Logger
/*    */ {
/*    */   public void debug(String paramString1, String paramString2) {
/* 29 */     Gdx.app.debug(paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void debug(String paramString1, String paramString2, Throwable paramThrowable) {
/* 34 */     Gdx.app.debug(paramString1, paramString2, paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   public void info(String paramString1, String paramString2) {
/* 39 */     Gdx.app.log(paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void info(String paramString1, String paramString2, Throwable paramThrowable) {
/* 44 */     Gdx.app.log(paramString1, paramString2, paramThrowable);
/*    */   }
/*    */ 
/*    */   
/*    */   public void error(String paramString1, String paramString2) {
/* 49 */     Gdx.app.error(paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void error(String paramString1, String paramString2, Throwable paramThrowable) {
/* 54 */     Gdx.app.error(paramString1, paramString2, paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\GdxLogger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */