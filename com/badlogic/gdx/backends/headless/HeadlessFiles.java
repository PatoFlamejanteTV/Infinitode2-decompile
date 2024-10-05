/*    */ package com.badlogic.gdx.backends.headless;
/*    */ 
/*    */ import com.badlogic.gdx.Files;
/*    */ import com.badlogic.gdx.files.FileHandle;
/*    */ import java.io.File;
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
/*    */ public final class HeadlessFiles
/*    */   implements Files
/*    */ {
/* 27 */   public static final String externalPath = System.getProperty("user.home") + File.separator;
/* 28 */   public static final String localPath = (new File("")).getAbsolutePath() + File.separator;
/*    */ 
/*    */   
/*    */   public final FileHandle getFileHandle(String paramString, Files.FileType paramFileType) {
/* 32 */     return new HeadlessFileHandle(paramString, paramFileType);
/*    */   }
/*    */ 
/*    */   
/*    */   public final FileHandle classpath(String paramString) {
/* 37 */     return new HeadlessFileHandle(paramString, Files.FileType.Classpath);
/*    */   }
/*    */ 
/*    */   
/*    */   public final FileHandle internal(String paramString) {
/* 42 */     return new HeadlessFileHandle(paramString, Files.FileType.Internal);
/*    */   }
/*    */ 
/*    */   
/*    */   public final FileHandle external(String paramString) {
/* 47 */     return new HeadlessFileHandle(paramString, Files.FileType.External);
/*    */   }
/*    */ 
/*    */   
/*    */   public final FileHandle absolute(String paramString) {
/* 52 */     return new HeadlessFileHandle(paramString, Files.FileType.Absolute);
/*    */   }
/*    */ 
/*    */   
/*    */   public final FileHandle local(String paramString) {
/* 57 */     return new HeadlessFileHandle(paramString, Files.FileType.Local);
/*    */   }
/*    */ 
/*    */   
/*    */   public final String getExternalStoragePath() {
/* 62 */     return externalPath;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean isExternalStorageAvailable() {
/* 67 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public final String getLocalStoragePath() {
/* 72 */     return localPath;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean isLocalStorageAvailable() {
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\headless\HeadlessFiles.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */