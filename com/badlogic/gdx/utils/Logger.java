/*    */ package com.badlogic.gdx.utils;
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
/*    */ 
/*    */ public class Logger
/*    */ {
/*    */   public static final int NONE = 0;
/*    */   public static final int ERROR = 1;
/*    */   public static final int INFO = 2;
/*    */   public static final int DEBUG = 3;
/*    */   private final String tag;
/*    */   private int level;
/*    */   
/*    */   public Logger(String paramString) {
/* 36 */     this(paramString, 1);
/*    */   }
/*    */   
/*    */   public Logger(String paramString, int paramInt) {
/* 40 */     this.tag = paramString;
/* 41 */     this.level = paramInt;
/*    */   }
/*    */   
/*    */   public void debug(String paramString) {
/* 45 */     if (this.level >= 3) Gdx.app.debug(this.tag, paramString); 
/*    */   }
/*    */   
/*    */   public void debug(String paramString, Exception paramException) {
/* 49 */     if (this.level >= 3) Gdx.app.debug(this.tag, paramString, paramException); 
/*    */   }
/*    */   
/*    */   public void info(String paramString) {
/* 53 */     if (this.level >= 2) Gdx.app.log(this.tag, paramString); 
/*    */   }
/*    */   
/*    */   public void info(String paramString, Exception paramException) {
/* 57 */     if (this.level >= 2) Gdx.app.log(this.tag, paramString, paramException); 
/*    */   }
/*    */   
/*    */   public void error(String paramString) {
/* 61 */     if (this.level > 0) Gdx.app.error(this.tag, paramString); 
/*    */   }
/*    */   
/*    */   public void error(String paramString, Throwable paramThrowable) {
/* 65 */     if (this.level > 0) Gdx.app.error(this.tag, paramString, paramThrowable);
/*    */   
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setLevel(int paramInt) {
/* 72 */     this.level = paramInt;
/*    */   }
/*    */   
/*    */   public int getLevel() {
/* 76 */     return this.level;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Logger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */