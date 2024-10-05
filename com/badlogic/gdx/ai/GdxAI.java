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
/*    */ public final class GdxAI
/*    */ {
/* 46 */   private static Timepiece timepiece = new DefaultTimepiece();
/* 47 */   private static Logger logger = (Gdx.app == null) ? new NullLogger() : new GdxLogger();
/* 48 */   private static FileSystem fileSystem = (Gdx.files == null) ? new StandaloneFileSystem() : new GdxFileSystem();
/*    */ 
/*    */   
/*    */   public static Timepiece getTimepiece() {
/* 52 */     return timepiece;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setTimepiece(Timepiece paramTimepiece) {
/* 57 */     timepiece = paramTimepiece;
/*    */   }
/*    */ 
/*    */   
/*    */   public static Logger getLogger() {
/* 62 */     return logger;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setLogger(Logger paramLogger) {
/* 67 */     logger = paramLogger;
/*    */   }
/*    */ 
/*    */   
/*    */   public static FileSystem getFileSystem() {
/* 72 */     return fileSystem;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setFileSystem(FileSystem paramFileSystem) {
/* 77 */     fileSystem = paramFileSystem;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\GdxAI.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */