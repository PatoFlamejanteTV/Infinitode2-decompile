/*    */ package com.badlogic.gdx;
/*    */ 
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface Files
/*    */ {
/*    */   FileHandle getFileHandle(String paramString, FileType paramFileType);
/*    */   
/*    */   FileHandle classpath(String paramString);
/*    */   
/*    */   FileHandle internal(String paramString);
/*    */   
/*    */   FileHandle external(String paramString);
/*    */   
/*    */   FileHandle absolute(String paramString);
/*    */   
/*    */   FileHandle local(String paramString);
/*    */   
/*    */   String getExternalStoragePath();
/*    */   
/*    */   boolean isExternalStorageAvailable();
/*    */   
/*    */   String getLocalStoragePath();
/*    */   
/*    */   boolean isLocalStorageAvailable();
/*    */   
/*    */   public enum FileType
/*    */   {
/* 34 */     Classpath,
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 39 */     Internal,
/*    */ 
/*    */ 
/*    */     
/* 43 */     External,
/*    */ 
/*    */ 
/*    */     
/* 47 */     Absolute,
/*    */ 
/*    */     
/* 50 */     Local;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\Files.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */